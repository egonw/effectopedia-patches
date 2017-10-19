package org.qsari.effectopedia.executor.java;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.modelling.AbstractModelExecutor;
import org.qsari.effectopedia.core.modelling.ExecutableModel;
import org.qsari.effectopedia.core.modelling.ExecutionProgressUpdater;
import org.qsari.effectopedia.core.modelling.ModelExecutor;
import org.qsari.effectopedia.core.objects.Method_InSilicoGlobalModel;
import org.qsari.effectopedia.data.objects.Resource;
import org.qsari.effectopedia.data.objects.Resource.ResourceType;
import org.qsari.effectopedia.defaults.DefaultSourceCode;

public class JavaModelExecutor extends AbstractModelExecutor implements ModelExecutor, ExecutionProgressUpdater
	{
		public static final JavaModelExecutor																		EXECUTOR	= new JavaModelExecutor();
		
		protected ArrayList<JavaSourceCodeBuliderObject>							sourceCode;
		protected ArrayList<JavaByteCodeObject>																byteCode;
		protected DiagnosticCollector<JavaFileObject>										diagnostics;
		protected JavaCompiler.CompilationTask																	compilationTask;
		protected JavaFileManager																														fileManager;
		protected ClassLoader																																		loader;
		protected HashMap<String, JavaSourceCodeBuliderObject>	classes;
		protected ArrayList<String>																												options;
		
		public static void main(String[] args)
			{
				JavaModelExecutor jme = new JavaModelExecutor(null,null);
				jme.sourceCode = new ArrayList<JavaSourceCodeBuliderObject>();
				JavaSourceCodeBuliderObject jsc = new JavaSourceCodeBuliderObject("JavaExecutableModel");
				jme.classes = new HashMap<String, JavaSourceCodeBuliderObject>();
				// jsc.append("import org.qsari.effectopedia.data.objects.ObjectPropertyType; public class Test\n{\n public void run()\n {\n System.out.print(\"test\"); \n}\n public ObjectPropertyType opt = new ObjectPropertyType();\n}");
				jsc.append(DefaultSourceCode.DEFAULT_JAVA_EXECUTABLE_MODEL);
				jme.sourceCode.add(jsc);
				jme.classes.put(jsc.className, jsc);
				ExecutableModel em = jme.getModel();
				em.execute(null, null, null);
			}
		
		public JavaModelExecutor()
			{
				//ModelExecutorFactory.registerExecutor(this, Resource.ResourceType.JAVA_SOURCE_CODE);
			}
		
		public JavaModelExecutor(Method_InSilicoGlobalModel model, Resource method)
			{
				this();
				setGlobalModel(model,method);
			}
		
		protected boolean init()
			{
				JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
				if (compiler == null)
					{
						console.println("JDK required (rather than JRE)");
						for (String s : System.getProperty("java.library.path").split(";"))
							console.println(s);
						return false;
					}
				
				if (model != null)
					{
						sourceCode = new ArrayList<JavaSourceCodeBuliderObject>();
						classes = new HashMap<String, JavaSourceCodeBuliderObject>();
						for (Resource resource : model.getResources().getCachedObjects())
							if (resource.getResourceType() == ResourceType.JAVA_SOURCE_CODE)
								{
									String resourceName = resource.getName();
									JavaSourceCodeBuliderObject jscbo = new JavaSourceCodeBuliderObject(resourceName);
									jscbo.append(resource.getContent());
									sourceCode.add(jscbo);
									classes.put(resourceName, jscbo);
								}
					}
				
				URL applicationRootPathURL = Effectopedia.class.getProtectionDomain().getCodeSource().getLocation();
				console.println(applicationRootPathURL.getPath());

				options = new ArrayList<String>();
				options.add("-cp");
				options.add(applicationRootPathURL.getPath());
				diagnostics = new DiagnosticCollector<JavaFileObject>();
				byteCode = new ArrayList<JavaByteCodeObject>();
				
				fileManager = compiler.getStandardFileManager(diagnostics, null, null);
				fileManager = new ForwardingJavaFileManager<JavaFileManager>(fileManager)
					{
						public JavaFileObject getJavaFileForOutput(Location location, final String className, JavaFileObject.Kind kind, FileObject sibling) throws IOException
							{
								if (classes.containsKey(className))
									{
										JavaByteCodeObject fileObject = new JavaByteCodeObject(className);
										byteCode.add(fileObject);
										return fileObject;
									}
								else
									return super.getJavaFileForOutput(location, className, kind, sibling);
							}
					};
				compilationTask = compiler.getTask(null, fileManager, diagnostics, options, null, sourceCode);
				fireProgressMade(5);
				return true;
			}
		
		protected boolean compile()
			{
				Boolean result = compilationTask.call();
				
				for (Diagnostic<? extends JavaFileObject> d : diagnostics.getDiagnostics())
					console.println(d.getKind() + ": " + d.getMessage(null));
				
				try
					{
						fileManager.close();
					}
				catch (IOException e)
					{
						e.printStackTrace();
					}
				
				if (!result)
					{
						console.println("Compilation failed.");
						return false;
					}
				
				Map<String, byte[]> byteCodeMap = new HashMap<>();
				for (JavaByteCodeObject cl : byteCode)
					byteCodeMap.put(cl.getName().substring(1), cl.getBytes());
				loader = new ClassLoaderMap(byteCodeMap);
				fireProgressMade(10);
				return true;
			}
		
		public static class JavaSourceCodeBuliderObject extends SimpleJavaFileObject
			{
				private StringBuilder	sourceCode;
				private final String		className;
				
				public JavaSourceCodeBuliderObject(String className)
					{
						super(URI.create("string:///" + className.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
						this.sourceCode = new StringBuilder();
						this.className = className;
					}
				
				public CharSequence getCharContent(boolean ignoreEncodingErrors)
					{
						return sourceCode;
					}
				
				public void append(String str)
					{
						sourceCode.append(str);
						sourceCode.append('\n');
					}
				
				public String getClassName()
					{
						return className;
					}
				
			}
		
		public static class JavaByteCodeObject extends SimpleJavaFileObject
			{
				private ByteArrayOutputStream	stream;
				
				public JavaByteCodeObject(String name)
					{
						super(URI.create("bytes:///" + name), Kind.CLASS);
						stream = new ByteArrayOutputStream();
					}
				
				public OutputStream openOutputStream() throws IOException
					{
						return stream;
					}
				
				public byte[] getBytes()
					{
						return stream.toByteArray();
					}
			}
		
		public class ClassLoaderMap extends ClassLoader
			{
				private Map<String, byte[]>	classes;
				
				public ClassLoaderMap(Map<String, byte[]> classes)
					{
						this.classes = classes;
					}
				
				protected Class<?> findClass(String name) throws ClassNotFoundException
					{
						byte[] classBytes = classes.get(name);
						if (classBytes == null)
							throw new ClassNotFoundException(name);
						Class<?> cl = defineClass(name, classBytes, 0, classBytes.length);
						if (cl == null)
							throw new ClassNotFoundException(name);
						return cl;
					}
			}
		
		public ExecutableModel getModel()
			{
				ExecutableModel model = null;
				try
					{
						if (init() && compile())
							model = (ExecutableModel) loader.loadClass(sourceCode.get(0).getClassName()).newInstance();
					}
				catch (InstantiationException e)
					{
						e.printStackTrace(console);
						return null;
					}
				catch (IllegalAccessException e)
					{
						e.printStackTrace(console);
						return null;
					}
				catch (ClassNotFoundException e)
					{
						e.printStackTrace(console);
						return null;
					}
				return model;
			}
		
		public Object newInstance(int sourceCodeIndex)
			{
				Object obj = null;
				try
					{
						if (init() && compile())
							obj = loader.loadClass(sourceCode.get(sourceCodeIndex).getClassName()).newInstance();
					}
				catch (InstantiationException e)
					{
						e.printStackTrace(console);
						return null;
					}
				catch (IllegalAccessException e)
					{
						e.printStackTrace(console);
						return null;
					}
				catch (ClassNotFoundException e)
					{
						e.printStackTrace(console);
						return null;
					}
				return obj;
			}
		
	}

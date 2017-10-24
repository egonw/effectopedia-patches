package org.qsari.effectopedia.executor.r;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.qsari.effectopedia.core.modelling.AbstractFileBasedModelExecutor;
import org.qsari.effectopedia.core.modelling.ExecutableModel;
import org.qsari.effectopedia.core.modelling.ExecutionProgressUpdater;
import org.qsari.effectopedia.core.modelling.ModelExecutor;
import org.qsari.effectopedia.core.objects.Method_InSilicoGlobalModel;
import org.qsari.effectopedia.data.objects.DataValue_String;
import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.objects.Resource;
import org.rosuda.JRI.REXP;
import org.rosuda.JRI.RList;
import org.rosuda.JRI.RMainLoopCallbacks;
import org.rosuda.JRI.Rengine;

public class RModelExecutor extends AbstractFileBasedModelExecutor implements ModelExecutor, ExecutionProgressUpdater
	{
		public static final RModelExecutor	EXECUTOR			= new RModelExecutor();
		
		protected RExecutableModel									em;
		protected Rengine																		rEngine;
		protected String[]																	engineArgs	= new String[0];
		
		public static void main(String[] args)
			{
				RModelExecutor rme = new RModelExecutor();
				ExecutableModel em = rme.getModel();
				em.execute(null, null, null);
			}
		
		class RConsole implements RMainLoopCallbacks
			{
				public void rWriteConsole(Rengine re, String text, int oType)
					{
						console.print(text);
					}
				
				public void rBusy(Rengine re, int which)
					{
						console.println("rBusy(" + which + ")");
					}
				
				public String rReadConsole(Rengine re, String prompt, int addToHistory)
					{
						console.print(prompt);
						try
							{
								BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
								String s = br.readLine();
								return (s == null || s.length() == 0) ? s : s + "\n";
							}
						catch (Exception e)
							{
								console.println("jriReadConsole exception: " + e.getMessage());
							}
						return null;
					}
				
				public void rShowMessage(Rengine re, String message)
					{
						console.println("rShowMessage \"" + message + "\"");
					}
				
				public String rChooseFile(Rengine re, int newFile)
					{
						FileDialog fd = new FileDialog(new Frame(), (newFile == 0) ? "Select a file" : "Select a new file", (newFile == 0) ? FileDialog.LOAD : FileDialog.SAVE);
						fd.setVisible(true);
						String res = null;
						if (fd.getDirectory() != null)
							res = fd.getDirectory();
						if (fd.getFile() != null)
							res = (res == null) ? fd.getFile() : (res + fd.getFile());
						return res;
					}
				
				public void rFlushConsole(Rengine re)
					{
					}
				
				public void rLoadHistory(Rengine re, String filename)
					{
					}
				
				public void rSaveHistory(Rengine re, String filename)
					{
					}
			}
		
		public RModelExecutor()
			{
				// ModelExecutorFactory.registerExecutor(this,
				// Resource.ResourceType.R_SOURCE_CODE);
			}
		
		@Override
		public void setGlobalModel(Method_InSilicoGlobalModel globalModel, Resource method)
			{
				this.model = globalModel;
				this.em = new RExecutableModel(globalModel,method);
			}
		
		public void setGlobalModel(Method_InSilicoGlobalModel globalModel, RExecutableModel em)
			{
				this.model = globalModel;
				this.em = em;
			}
		
		@Override
		public ExecutableModel getModel()
			{
				return em;
			}
		
		public boolean init()
			{
				if (!initResources())
					return false;
				
				if ((rEngine != null) && (rEngine.isAlive()))
					{
						rEngine.eval("setwd(\"" + workPath.toString().replace("\\", "\\\\") + "\")");
						return true;
					}
				System.setProperty("jri.ignore.ule", "yes");
				if (!Rengine.jriLoaded)
					{
						console
								.println("Please make sure that rJava package is installed in R and its bin directory is added to the system PATH,\nR_HOME directory is set and jri.dll (in Windows) is available in the bin directory of your R installation!");
						return false;
					}
				if (!Rengine.versionCheck())
					{
						console.println("Version mismatch - Java files don't match library version!");
						return false;
					}
				if (engineArgs != null)
					console.println("Creating REngine (" + engineArgs.toString() + ")");
				String[] extendedArgs = Arrays.copyOf(engineArgs, engineArgs.length + 1);
				extendedArgs[extendedArgs.length - 1] = "--no-save"; // append this option
				rEngine = new Rengine(extendedArgs, false, new RConsole());
				console.println("Rengine created, waiting for R");
				// the engine creates R is a new thread, so we should wait until it's ready
				if (!rEngine.waitForR())
					{
						console.println("Cannot load R");
						return false;
					}
				
				if (rEngine != null)
					rEngine.eval("setwd(\"" + workPath.toString().replace("\\", "\\\\") + "\")");
				
				return true;
			}
		
		protected boolean disconnect(boolean exit)
			{
				try
					{
						if (exit)
							rEngine.end();
						return true;
					}
				catch (Exception e)
					{
						e.printStackTrace(console);
						return false;
					}
			}
		
		public String objectPropertiesToRList(String listName, String listDescription, ObjectProperties properties)
			{
				StringBuilder sb = new StringBuilder();
				sb.append(listName);
				sb.append(" = list (   #");
				sb.append(listDescription);
				sb.append("\n");
				for (ObjectProperty op : properties.getProperties())
					addObjectProperty(sb, "", op);
				if (properties.getCount() > 0)
					sb.deleteCharAt(lastObjPropDefEnd);
				sb.append(")\n");
				return sb.toString();
			}
		
		protected void addObjectProperty(StringBuilder sb, String preffix, ObjectProperty op)
			{
				String opName;
				if (preffix.length() > 0)
					opName = preffix + "_" + op.getType().getName();
				else
					opName = op.getType().getName();
				sb.append(opName);
				sb.append(" = ");
				if (op instanceof ObjectPropertyMultivalued)
					{
						int cnt = ((ObjectPropertyMultivalued) op).valuesCount();
						sb.append("c(");
						for (int i = 0; i < cnt - 1; i++)
							{
								appendValidValue(sb, op.getType().getBaseValueType(), ((ObjectPropertyMultivalued) op).getValueAndUnitPair(i).getDisplayValue());
								sb.append(", ");
							}
						if (cnt > 0)
							appendValidValue(sb, op.getType().getBaseValueType(), ((ObjectPropertyMultivalued) op).getValueAndUnitPair(cnt - 1).getDisplayValue());
						sb.append(")");
					}
				else
					sb.append(op.getDisplayValue());
				lastObjPropDefEnd = sb.length();
				sb.append(",   #");
				sb.append(op.getDisplayUnit());
				sb.append(" ");
				sb.append(op.getType().getDescription());
				sb.append("\n");
				if (op instanceof ObjectPropertyMultivalued_Documented)
					addDescriptors(sb, opName, (ObjectPropertyMultivalued_Documented) op);
			//TODO
				/*
				for (ValueAndUnit vu : op.getValuePairs())
					{
						ObjectProperties subProperties = vu.getSubProperties();
						if (subProperties != null)
							for (ObjectProperty subProp : subProperties.getProperties())
								addObjectProperty(sb, opName, subProp);
					}
					*/
			}
		
		protected void addDescriptors(StringBuilder sb, String preffix, ObjectPropertyMultivalued_Documented op)
			{
				int descrCnt = op.getType().getDescriptorsCount();
				for (int j = 0; j < descrCnt - 1; j++)
					{
						DescriptorType descriptorType = (DescriptorType) op.getType().getDescriptors().get(j);
						sb.append(preffix);
						sb.append("_");
						sb.append(descriptorType.getName());
						sb.append(" = ");
						
						sb.append("c(");
						int cnt = op.valuesCount();
						for (int i = 0; i < cnt - 1; i++)
							{
								appendValidValue(sb, descriptorType.getBaseValueType(), op.getValueAndUnitPair(i).getDescriptor(descriptorType).getDisplayValue());
								sb.append(", ");
							}
						if (cnt > 0)
							appendValidValue(sb, descriptorType.getBaseValueType(), op.getValueAndUnitPair(cnt - 1).getDescriptor(descriptorType).getDisplayValue());
						sb.append(")");
						lastObjPropDefEnd = sb.length();
						sb.append(",   #");
						String displUnit = op.getValueAndUnitPair(0).getDescriptor(descriptorType).getDisplayUnit();
						if (displUnit != null)
							{
								sb.append(displUnit);
								sb.append(" ");
							}
						sb.append(descriptorType.getDescription());
						sb.append("\n");
					}
				
			}
		
		protected void appendValidValue(StringBuilder sb, Class<?> baseType, String value)
			{
				if (baseType == DataValue_String.class)
					{
						sb.append("'");
						sb.append(value);
						sb.append("'");
					}
				else
					sb.append(((value != null) && (value.length() > 0)) ? value : "0");
			}
		
		public ObjectProperties RListToObjectProperties(String listName, ObjectProperties properties)
			{
				if (properties != null)
					{
						REXP x = rEngine.eval(listName);
						if (x == null)
							return properties;
						RList list = x.asList();
						for (ObjectProperty op : properties.getProperties())
							readProperty(list, op.getType().getName(), op);
					}
				return properties;
			}
		
		protected void readProperty(RList list, String propertyName, ObjectProperty op)
			{
				if ((op instanceof ObjectPropertyMultivalued_Documented) || (op instanceof ObjectPropertyMultivalued))
					{
						ObjectPropertyMultivalued mvOP = ((ObjectPropertyMultivalued) op);
						double[] values = (list.at(propertyName)).asDoubleArray();
						if (values == null)
							return;
						mvOP.clearValuePairs();
						mvOP.add(values.length);
						for (int i = 0; i < values.length; i++)
							mvOP.getValueAndUnitPair(i).setDoubleValue(values[i]);
						if (mvOP instanceof ObjectPropertyMultivalued_Documented)
							readDescriptors(list, propertyName, (ObjectPropertyMultivalued_Documented) op);
					}
				else
					{
						REXP value = list.at(propertyName);
						op.setValue(value.asString());
					}
				//TODO
				/*
				for (ValueAndUnit vu : op.getValuePairs())
					{
						ObjectProperties subProperties = vu.getSubProperties();
						if (subProperties != null)
							for (ObjectProperty subProp : subProperties.getProperties())
								readProperty(list, propertyName + "_" + subProp.getType().getName(), subProp);
					}
					*/
			}
		
		protected void readDescriptors(RList list, String propertyName, ObjectPropertyMultivalued_Documented op)
			{
				int descrCnt = op.getType().getDescriptorsCount();
				for (int j = 0; j < descrCnt - 1; j++)
					{
						DescriptorType descriptorType = (DescriptorType) op.getType().getDescriptors().get(j);
						String descriptorFullName = propertyName + "_" + descriptorType.getName();
						REXP x = list.at(descriptorFullName);
						if (x != null)
							{
								double[] values = x.asDoubleArray();
								if (values != null)
									for (int i = 0; i < values.length; i++)
										op.getValueAndUnitPair(i).getDescriptor(descriptorType).setFromDouble(values[i]);
							}
					}
			}
		
		@Override
		public void updateResources()
			{
				if (em != null)
					em.generateInitializer(null, model.getModelParamaters(), null);
			}
		
	}

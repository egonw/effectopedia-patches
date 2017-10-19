package org.qsari.effectopedia.executor.matlab;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.modelling.AbstractExecutableModel;
import org.qsari.effectopedia.core.modelling.ExecutableModel;
import org.qsari.effectopedia.core.objects.Method_InSilicoGlobalModel;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.Resource;

import matlabcontrol.MatlabInvocationException;

public class MatlabExecutableModel extends AbstractExecutableModel implements ExecutableModel
	{
		
		public MatlabExecutableModel(Method_InSilicoGlobalModel model, Resource method)
			{
				super(model, method);
			}
		
		@Override
		public boolean execute(ObjectProperties input, ObjectProperties modelParameters, ObjectProperties output)
			{
				fireProgressMade(0);
				generateInitializer(input, modelParameters, output);
				MatlabModelExecutor.EXECUTOR.setGlobalModel(model, this);
				if (MatlabModelExecutor.EXECUTOR.init())
					{
						try
							{
								String modelName = model.getResources().getCachedObject(0).getName();
								console.println("Executing: " + model.getTitle() + " initialization (" + modelName + ")");
								fireProgressMade(10);
								MatlabModelExecutor.EXECUTOR.proxy.eval("clear all;");
								MatlabModelExecutor.EXECUTOR.proxy.eval("display('Executing: " + model.getTitle() + "...');");
								MatlabModelExecutor.EXECUTOR.proxy.eval(modelName);
								MatlabModelExecutor.EXECUTOR.proxy.eval("display(INPUT);");
								MatlabModelExecutor.EXECUTOR.proxy.eval("display(MODPAR);");
								Object out = MatlabModelExecutor.EXECUTOR.proxy.getVariable("OUTPUT");
								MatlabModelExecutor.EXECUTOR.proxy.eval("display(OUTPUT);");
								
								console.print(out.toString());
								MatlabModelExecutor.EXECUTOR.MatlabStructToObjectProperties("OUTPUT", output);
								fireProgressMade(100);
								return true;
							}
						catch (MatlabInvocationException e)
							{
								e.printStackTrace(console);
								return false;
							}
					}
				return false;
			}
		
		protected void generateInitializer(ObjectProperties input, ObjectProperties modelParameters, ObjectProperties output)
			{
				if (model != null)
					{
						MatlabModelExecutor.EXECUTOR.setGlobalModel(model, this);
						StringBuilder sb = new StringBuilder();
						sb.append("% ");
						sb.append(model.getTitle());
						sb.append(" \n");
						sb.append("% Genereted using Efecttopedia ver.");
						sb.append(Effectopedia.VERSION);
						sb.append(" in-silico model settings interface\n");
						sb.append("\n");
						sb.append("clear;\n\n");
						sb.append("% Define data structures for exchange with Effectopedia.\n");
						sb.append("global INPUT MODPAR OUTPUT\n\n");
						if (input != null)
							sb.append(MatlabModelExecutor.EXECUTOR.objectPropertiesToMatlabStruct("INPUT", "Model input data structure", input));
						if (modelParameters != null)
							sb.append(MatlabModelExecutor.EXECUTOR.objectPropertiesToMatlabStruct("MODPAR", "Model parameters", modelParameters));
						if (output != null)
							sb.append(MatlabModelExecutor.EXECUTOR.objectPropertiesToMatlabStruct("OUTPUT", "Model output data structure", output));
						sb.append("\n");
						Resource[] resources = model.getResources().getCachedObjects();
						if (resources.length > 1)
							{
								sb.append("% Execute the model using global parameters.\n");
								if (method != null)
									sb.append(method.getName());
								else
									sb.append(resources[1].getName());
								resources[0].setContent(sb.toString());
							}
					}
			}
	}

package org.qsari.effectopedia.executor.r;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.modelling.AbstractExecutableModel;
import org.qsari.effectopedia.core.modelling.ExecutableModel;
import org.qsari.effectopedia.core.objects.Method_InSilicoGlobalModel;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.Resource;

public class RExecutableModel extends AbstractExecutableModel implements ExecutableModel
	{
		public RExecutableModel(Method_InSilicoGlobalModel model, Resource method)
			{
				super(model,method);
			}
		
		@Override
		public boolean execute(ObjectProperties input, ObjectProperties modelParameters, ObjectProperties output)
			{
				fireProgressMade(0);
				generateInitializer(input, modelParameters, output);
				RModelExecutor.EXECUTOR.setGlobalModel(model, this);
				if (RModelExecutor.EXECUTOR.init())
					{
						String modelName = model.getResources().getCachedObject(0).getFileName();
						console.println("Executing: " + model.getTitle() + " initialization (" + modelName + ")");
						fireProgressMade(10);
						RModelExecutor.EXECUTOR.rEngine.eval("print('Executing: " + model.getTitle() + "...');");
						RModelExecutor.EXECUTOR.rEngine.eval("source(\"" + modelName + "\")");
						RModelExecutor.EXECUTOR.rEngine.eval("str(INPUT)");
						RModelExecutor.EXECUTOR.rEngine.eval("str(MODPAR)");
						RModelExecutor.EXECUTOR.rEngine.eval("str(OUTPUT)");
						
						RModelExecutor.EXECUTOR.RListToObjectProperties("OUTPUT", output);
						
						fireProgressMade(100);
						return true;
					}
				return false;
			}
		
		protected void generateInitializer(ObjectProperties input, ObjectProperties modelParameters, ObjectProperties output)
			{
				if (model != null)
					{
						RModelExecutor.EXECUTOR.setGlobalModel(model, this);
						StringBuilder sb = new StringBuilder();
						sb.append("# ");
						sb.append(model.getTitle());
						sb.append(" \n");
						sb.append("# Genereted using Efecttopedia ver.");
						sb.append(Effectopedia.VERSION);
						sb.append(" in-silico model settings interface\n");
						sb.append("\n\n");
						sb.append("# Define list(s) for exchange with Effectopedia.\n");
						if (input != null)
							sb.append(RModelExecutor.EXECUTOR.objectPropertiesToRList("INPUT", "Model input data structure", input));
						if (modelParameters != null)
							sb.append(RModelExecutor.EXECUTOR.objectPropertiesToRList("MODPAR", "Model parameters", modelParameters));
						if (output != null)
							sb.append(RModelExecutor.EXECUTOR.objectPropertiesToRList("OUTPUT", "Model output data structure", output));
						sb.append("\n");
						Resource[] resources = model.getResources().getCachedObjects();
						if (resources.length > 1)
							{
								sb.append("# Execute the model using global parameters.\n");
								sb.append("source(\"");
								if ((method != null)&&(method!=resources[0]))
									sb.append(method.getFileName());
								else
									sb.append(resources[1].getFileName());
								sb.append("\")");
								resources[0].setContent(sb.toString());
							}
					}
			}
		
	}

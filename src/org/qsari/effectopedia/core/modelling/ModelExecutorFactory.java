package org.qsari.effectopedia.core.modelling;

import java.util.HashMap;

import org.qsari.effectopedia.data.objects.Resource;
import org.qsari.effectopedia.data.objects.Resource.ResourceType;
import org.qsari.effectopedia.executor.java.JavaModelExecutor;
import org.qsari.effectopedia.executor.matlab.MatlabModelExecutor;
import org.qsari.effectopedia.executor.r.RModelExecutor;

public class ModelExecutorFactory
	{
		protected static final HashMap<Resource.ResourceType, ModelExecutor>	executors	= new HashMap<Resource.ResourceType, ModelExecutor>();
		
		public static void registerExecutor(ModelExecutor executor, Resource.ResourceType resourceType)
			{
				executors.put(resourceType, executor);
			}
		
		public static ModelExecutor getExecutor(Resource.ResourceType resourceType)
			{
				return executors.get(resourceType);
			}
		
		static
			{
				registerExecutor(JavaModelExecutor.EXECUTOR, ResourceType.JAVA_SOURCE_CODE);
				registerExecutor(RModelExecutor.EXECUTOR, ResourceType.R_SOURCE_CODE);
				registerExecutor(MatlabModelExecutor.EXECUTOR, ResourceType.MATLAB_SOURCE_CODE);
			}
	}

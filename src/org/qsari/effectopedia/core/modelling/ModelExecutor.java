package org.qsari.effectopedia.core.modelling;

import java.io.PrintStream;

import org.qsari.effectopedia.core.objects.Method_InSilicoGlobalModel;
import org.qsari.effectopedia.data.objects.Resource;

public interface ModelExecutor
	{
		public void setGlobalModel(Method_InSilicoGlobalModel globalModel, Resource method);
		
		public Method_InSilicoGlobalModel getGlobalModel();
		
		public ExecutableModel getModel();
		
		public void setConsole(PrintStream console);

		public void updateResources();
		
		public void addExecutionProgressListener(ExecutionProgressListener listener);
		
		public void removeExecutionProgressListener(ExecutionProgressListener listener);
	}

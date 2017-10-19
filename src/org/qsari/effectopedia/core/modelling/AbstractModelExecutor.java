package org.qsari.effectopedia.core.modelling;

import java.io.PrintStream;
import java.util.ArrayList;

import org.qsari.effectopedia.core.objects.Method_InSilicoGlobalModel;
import org.qsari.effectopedia.data.objects.Resource;

public abstract class AbstractModelExecutor implements ModelExecutor, ExecutionProgressUpdater
	{
		
		@Override
		public void setGlobalModel(Method_InSilicoGlobalModel globalModel, Resource method)
			{
				this.model = globalModel;
				this.method = method;
			}
		
		@Override
		public Method_InSilicoGlobalModel getGlobalModel()
			{
				return this.model;
			}
		
		public void setConsole(PrintStream console)
			{
				this.console = (console == null) ? System.out : console;
			}
		
		public void updateResources()
			{
				
			}
		
		@Override
		public void addExecutionProgressListener(ExecutionProgressListener listener)
			{
				listeners.add(listener);
			}
		
		@Override
		public void removeExecutionProgressListener(ExecutionProgressListener listener)
			{
				listeners.remove(listener);
			}
		
		public void fireProgressMade(int percentComplete)
			{
				for (ExecutionProgressListener listener : listeners)
					listener.onProgress(percentComplete);
			}
		
		public Resource getMethod()
			{
				return method;
			}

		public void setMethod(Resource method)
			{
				this.method = method;
			}

		protected Method_InSilicoGlobalModel											model;
		protected Resource																													method;
		protected PrintStream																										console			= System.out;
		protected ArrayList<ExecutionProgressListener>	listeners	= new ArrayList<ExecutionProgressListener>();
	}

package org.qsari.effectopedia.core.modelling;

import java.io.PrintStream;
import java.util.ArrayList;

import org.qsari.effectopedia.core.objects.Method_InSilicoGlobalModel;
import org.qsari.effectopedia.data.objects.Resource;

public abstract class AbstractExecutableModel implements ExecutableModel
	{
		public AbstractExecutableModel(Method_InSilicoGlobalModel model, Resource method)
			{
				this.model = model;
				this.method = method;
			}
		
		public void setConsole(PrintStream console)
			{
				this.console = (console == null) ? System.out : console;
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
		
		public Method_InSilicoGlobalModel getModel()
			{
				return model;
			}
		
		public void setModel(Method_InSilicoGlobalModel model)
			{
				this.model = model;
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
		protected Resource																													method				= null;
		protected PrintStream																										console			= System.out;
		protected ArrayList<ExecutionProgressListener>	listeners	= new ArrayList<ExecutionProgressListener>();
	}

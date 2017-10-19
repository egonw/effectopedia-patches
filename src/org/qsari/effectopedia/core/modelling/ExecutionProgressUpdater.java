package org.qsari.effectopedia.core.modelling;

public interface ExecutionProgressUpdater
	{
		public void addExecutionProgressListener(ExecutionProgressListener listener);
		
		public void removeExecutionProgressListener(ExecutionProgressListener listener);

	}

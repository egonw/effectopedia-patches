package org.qsari.effectopedia.core.modelling;

import java.io.PrintStream;

import org.qsari.effectopedia.data.objects.ObjectProperties;

public interface ExecutableModel extends ExecutionProgressUpdater
	{
		public boolean execute(ObjectProperties input, ObjectProperties modelParameters, ObjectProperties output);
		
		public void setConsole(PrintStream console);
	}

package org.qsari.effectopedia.go;

public interface ProcessableGO
	{
		public static final int	VERTICAL_SHIFT			= 1;
		public static final int	HORIZONTAL_SHIFT	= 2;
		
		public void process(int action, Object value);
		
		public void processSelected(int action, Object value);
		
	}

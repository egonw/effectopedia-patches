package org.qsari.effectopedia.gui.core;


public interface ManageableIndexedListUI<P>
	{
		public int getActiveListIndex();
		
		public P add(boolean enableSelectionDialog);
		
		public void remove();
		
		public void reset();
		
		public Object getList();
	}

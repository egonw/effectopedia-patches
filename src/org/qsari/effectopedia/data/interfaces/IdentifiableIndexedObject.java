package org.qsari.effectopedia.data.interfaces;

public interface IdentifiableIndexedObject
	{
		public long getID();
		
		public void autoSetId();
		
		public void setExternalID(long value);
		
		public long getExternalID();
		
		public String toString();
	}

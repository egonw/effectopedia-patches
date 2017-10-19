package org.qsari.effectopedia.data.interfaces;


public interface IdentifiableEffectopediaObject extends IdentifiableIndexedObject
	{
		
		public IdentifiableEffectopediaObject getParent();
		
		public boolean isDefaultID();
		
		public long getDefaultID();
		
		public void setDefaultID(long defualtID);
		
		public boolean isReadonly();
		
		public void setReadonly(boolean readonly);
		
		public IdentifiableDataSource getDataSource();
		
	}

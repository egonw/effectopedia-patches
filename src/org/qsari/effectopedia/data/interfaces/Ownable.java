package org.qsari.effectopedia.data.interfaces;

public interface Ownable
	{
		public Class<?> getOwnerClass();
		
		public void setOwnerClass(Class<?> owner);
	}

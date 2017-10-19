package org.qsari.effectopedia.base.io;

import org.qsari.effectopedia.base.EffectopediaObject;

public interface BaseIO
	{
		public static enum DataPattern
			{
				RUSSIAN_DOLL,SALAMI_SLICE, VENETIAN_BLIND, GARDEN_OF_EDEN
			}
		
		public boolean load(String path);
		
		public void save(String path, boolean saveLocally);
		
		BaseIOAttribute newAttribute(String name);
		
		BaseIOValue newValue(String name);
		
		BaseIOElement newElement(String name);
		
		BaseIOArray newArray(String name, int count);
		
		<E extends EffectopediaObject> E load(Class<?> cl, E effectopediaObejct, BaseIOElement element);
		
		double getFormatVersion();
		
		double getInputVersion();
		
		public DataPattern getDataPattern();
	}

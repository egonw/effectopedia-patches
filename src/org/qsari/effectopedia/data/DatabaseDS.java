package org.qsari.effectopedia.data;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;

public class DatabaseDS extends RevisionBasedDS implements DataSourceItem
	{
		public void add(EffectopediaObject eo)
			{
				EffectopediaObjects<? extends EffectopediaObject> objects = liveIndices.get(eo.getClass());
				objects.put(eo.getID(), eo);
			}
		
		public void add(Class<? extends EffectopediaObject> objectClass, EffectopediaObject eo)
			{
				EffectopediaObjects<? extends EffectopediaObject> objects = liveIndices.get(objectClass);
				objects.put(eo.getID(), eo);
			}
		
		public void addToArchive(Class<? extends EffectopediaObject> objectClass, EffectopediaObject eo)
			{
				EffectopediaObjects<? extends EffectopediaObject> objects = archiveIndices.get(objectClass);
				objects.put(eo.getID(), eo);
			}
		
		public EffectopediaObject remove(Class<? extends EffectopediaObject> objectClass, long id)
			{
				EffectopediaObjects<?> objects = liveIndices.get(objectClass);
				return (EffectopediaObject) objects.remove(id);
			}

		@Override
		public EffectopediaObject getLiveEffectopediaObjectByExternalID(long externalID)
			{
				return null;
			}
		
		@Override
		public EffectopediaObject getArchiveEffectopediaObjectByExternalID(long externalID)
			{
				return null;
			}
		
		
		public String toString()
			{
				return "Database";
			}

	}

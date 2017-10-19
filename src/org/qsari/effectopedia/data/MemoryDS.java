package org.qsari.effectopedia.data;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.base.IndexedObject;

public class MemoryDS extends DataSource implements DataSourceItem
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
				if (objects != null)
					{
						EffectopediaObject o = (EffectopediaObject) objects.get(id);
						if (o != null)
							{
								objects.remove(id);
								return o;
							}
						else
							return null;
					}
				else
					return null;
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
				return "Local memory";
			}
		
		public String getObjectURI(IndexedObject io)
			{
				return "Local Memory sourceID= " + dataSourceID + "&extID=" + io.getExternalID();
			}

	}

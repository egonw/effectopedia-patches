package org.qsari.effectopedia.core.containers;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.Resource;

public class Resources extends EffectopediaObjects<Resource>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public boolean addNew(EffectopediaObject parent, DataSource dataSource, Class<Resource> objectClass)
			{
				Resource src = new Resource(parent, dataSource);
				Resource old = put(src.getID(), src);
				return (old == null) || (old == src);
			}
		
		public String toString()
			{
				return "resources";
			}
		
		public static final Class<?>	objectsClass	= Resource.class;
		
	}

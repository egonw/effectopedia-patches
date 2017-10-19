package org.qsari.effectopedia.core.containers;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.core.objects.TransformationSet;
import org.qsari.effectopedia.data.DataSource;

public class TransformationSets extends EffectopediaObjects<TransformationSet>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public boolean addNew(EffectopediaObject parent, DataSource dataSource, Class<TransformationSet> objectClass)
			{
				TransformationSet t = new TransformationSet(parent, dataSource);
				TransformationSet old = put(t.getID(), t);
				return (old == null) || (old == t);
			}
		
		public String toString()
			{
				return "transformation sets";
			}
		
		public static final Class<?>	objectsClass	= TransformationSet.class;
		
	}

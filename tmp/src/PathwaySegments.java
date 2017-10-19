package org.qsari.effectopedia.core.containers;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwaySegment;

public class PathwaySegments extends EffectopediaObjects<PathwaySegment>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public boolean addNew(EffectopediaObject parent, Class<PathwaySegment> objectClass)
			{
				PathwaySegment p = new PathwaySegment(parent);
				PathwaySegment old = put(p.getID(), p);
				return (old == null) || (old == p);
			}
		
		public Pathway[] createNewArray(int size)
			{
				return new Pathway[size];
			}
		
		public static final Class<PathwaySegment>	objectsClass	= PathwaySegment.class;
		
	}

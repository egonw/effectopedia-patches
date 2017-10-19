package org.qsari.effectopedia.core.containers;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.core.objects.Lab;
import org.qsari.effectopedia.data.DataSource;

public class Labs extends EffectopediaObjects<Lab>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
	
		public boolean addNew(EffectopediaObject parent ,DataSource dataSource, Class<Lab> objectClass)
			{
				Lab l = new Lab(parent,dataSource);
				Lab old = put(l.getID(), l);
				return (old == null) || (old == l);
			}
		
		public Lab[] get()
			{
				return values().toArray(new Lab[values().size()]);
			}
		
		public String toString()
			{
				return "labs";
			}

		public static final Class<?>	objectsClass	= Lab.class;
		
	}

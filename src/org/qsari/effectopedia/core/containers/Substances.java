package org.qsari.effectopedia.core.containers;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.core.objects.Substance;
import org.qsari.effectopedia.data.DataSource;

public class Substances extends EffectopediaObjects<Substance>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public boolean addNew(EffectopediaObject parent, DataSource dataSource, Class<Substance> objectClass)
			{
				Substance e = null;
				try
					{
						e = objectClass.newInstance();
						e.setParent(parent);
						e.setDataSource(dataSource);
					}
				catch (InstantiationException ie)
					{
						ie.printStackTrace();
					}
				catch (IllegalAccessException iae)
					{
						iae.printStackTrace();
					}
				Substance old = put(e.getID(), e);
				return (old == null) || (old == e);
			}
		
		public Substance[] get()
			{
				return values().toArray(new Substance[values().size()]);
			}
		
		public String toString()
			{
				return "substances";
			}
		
		public static final Class<?>	objectsClass	= Substance.class;
	}

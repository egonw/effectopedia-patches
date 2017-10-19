package org.qsari.effectopedia.core.containers;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.core.objects.Constituent;
import org.qsari.effectopedia.data.DataSource;

public class Constituents extends EffectopediaObjects<Constituent>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public boolean addNew(EffectopediaObject parent, DataSource dataSource, Class<Constituent> objectClass)
			{
				Constituent e = null;
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
				Constituent old = put(e.getID(), e);
				return (old == null) || (old == e);
			}
		
		public Constituent[] get()
			{
				return values().toArray(new Constituent[values().size()]);
			}
		
		public String toString()
			{
				return "constituents";
			}
		
		public static final Class<?>	objectsClass			= Constituent.class;
	}

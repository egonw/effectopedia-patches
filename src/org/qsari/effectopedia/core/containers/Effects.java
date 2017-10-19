package org.qsari.effectopedia.core.containers;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.data.DataSource;

public class Effects extends EffectopediaObjects<Effect>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
	
		public boolean addNew(EffectopediaObject parent, DataSource dataSource, Class<Effect> objectClass)
			{
				Effect e = null;
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
				Effect old = put(e.getID(), e);
				return (old == null) || (old == e);
			}

		public Effect[] get()
			{
				return values().toArray(new Effect[values().size()]);
			}

		public String toString()
			{
				return "(key) events / adverse effects";
			}

	}

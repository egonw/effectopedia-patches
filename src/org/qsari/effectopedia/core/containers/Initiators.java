package org.qsari.effectopedia.core.containers;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.core.objects.Initiator;
import org.qsari.effectopedia.data.DataSource;

public class Initiators extends EffectopediaObjects<Initiator>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public boolean addNew(EffectopediaObject parent, DataSource dataSource, Class<Initiator> objectClass)
			{
				Initiator s = null;
				try
					{
						s = objectClass.newInstance();
						s.setParent(parent);
						s.setDataSource(dataSource);
					}
				catch (InstantiationException ie)
					{
						ie.printStackTrace();
					}
				catch (IllegalAccessException iae)
					{
						iae.printStackTrace();
					}
				Initiator old = put(s.getID(), s);
				return (old == null) || (old == s);
			}
		
		public Initiator[] get()
			{
				return values().toArray(new Initiator[values().size()]);
			}
		
		public String toString()
			{
				return "initiatiors";
			}
	}

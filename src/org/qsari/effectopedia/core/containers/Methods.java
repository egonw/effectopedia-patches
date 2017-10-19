package org.qsari.effectopedia.core.containers;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.core.objects.Method;
import org.qsari.effectopedia.data.DataSource;

public class Methods extends EffectopediaObjects<Method>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
	
		public boolean addNew(EffectopediaObject parent, DataSource dataSource, Class<Method> objectClass)
			{
				Method m = null;
				try
					{
						m = objectClass.newInstance();
						m.setParent(parent);
						m.setDataSource(dataSource);
					}
				catch (InstantiationException ie)
					{
						ie.printStackTrace();
					}
				catch (IllegalAccessException iae)
					{
						iae.printStackTrace();
					}
				Method old = put(m.getID(), m);
				return (old == null) || (old == m);
			}
		
		public Method[] get()
			{
				return values().toArray(new Method[values().size()]);
			}
		
		public String toString()
			{
				return "methods";
			}
		
		public static final Class<?>	objectsClass	= Method.class;
		
	}

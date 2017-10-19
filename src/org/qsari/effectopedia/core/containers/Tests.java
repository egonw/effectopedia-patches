package org.qsari.effectopedia.core.containers;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.core.objects.Test;
import org.qsari.effectopedia.data.DataSource;

public class Tests extends EffectopediaObjects<Test>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;


		public boolean addNew(EffectopediaObject parent, DataSource dataSource, Class<Test> objectClass)
			{
				Test e = null;
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
				Test old = put(e.getID(), e);
				return (old == null) || (old == e);
			}
		
		public Test[] get()
			{
				return values().toArray(new Test[values().size()]);
			}
		
		public String toString()
			{
				return "tests";
			}
		
		public static final Class<?>	objectsClass	= Test.class;
	}

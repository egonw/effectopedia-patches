package org.qsari.effectopedia.core.containers;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.data.DataSource;

public class Links extends EffectopediaObjects<Link>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public boolean addNew(EffectopediaObject parent,DataSource dataSource, Class<Link> objectClass)
			{
				Link l = null;
				try
					{
						l = objectClass.newInstance();
						l.setParent(parent);
						l.setDataSource(dataSource);
					}
				catch (InstantiationException ie)
					{
						ie.printStackTrace();
					}
				catch (IllegalAccessException iae)
					{
						iae.printStackTrace();
					}
				Link old = put(l.getID(), l);
				return (old == null) || (old == l);
			}
		
		public Link[] get()
			{
				return values().toArray(new Link[values().size()]);
			}
		
		public String toString()
			{
				return "links";
			}
		
		public static final Class<Link>	objectsClass	= Link.class;
	}

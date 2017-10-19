package org.qsari.effectopedia.core.containers;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.DescriptorType;

public class PropertyTypes extends EffectopediaObjects<DescriptorType>
	{
		/**
	 * 
	 */
	private static final long	serialVersionUID	= -4910554501993203442L;

		public boolean addNew(EffectopediaObject parent,DataSource dataSource, Class<DescriptorType> objectClass)
			{
				DescriptorType property = null;
				try
					{
						property = objectClass.newInstance();
						property.setParent(parent);
						property.setDataSource(dataSource);
					}
				catch (InstantiationException ie)
					{
						ie.printStackTrace();
					}
				catch (IllegalAccessException iae)
					{
						iae.printStackTrace();
					}
				DescriptorType old = put(property.getID(), property);
				return (old == null) || (old == property);
			}
		
		public DescriptorType[] get()
			{
				return values().toArray(new DescriptorType[values().size()]);
			}
		
		public String toString()
			{
				return "property types";
			}
		
		public static final Class<DescriptorType>	objectsClass	= DescriptorType.class;	
	}

package org.qsari.effectopedia.core.containers;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.quantification.DataTemplateType;

public class DataTempleteTypes extends EffectopediaObjects<DataTemplateType>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= -4910554501993203442L;
		
		public boolean addNew(EffectopediaObject parent, DataSource dataSource,Class<DataTemplateType> objectClass)
			{
				DataTemplateType newType = new DataTemplateType(parent,dataSource);
				DataTemplateType old = put(newType.getID(), newType);
				return (old == null) || (old == newType);
			}
		
		public DataTemplateType[] get()
			{
				return values().toArray(new DataTemplateType[values().size()]);
			}

		public String toString()
			{
				return "template_types";
			}

		public static final Class<DataTemplateType>	objectsClass	= DataTemplateType.class;
	}

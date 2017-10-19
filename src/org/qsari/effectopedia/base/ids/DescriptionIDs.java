package org.qsari.effectopedia.base.ids;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public class DescriptionIDs extends IDs<DescriptionSection> implements Cloneable, Traceable
	{
		
		public DescriptionIDs()
			{
				super();
			}
			
		public DescriptionIDs(EffectopediaObject parent, DataSource dataSource, Class<DescriptionSection> objectClass)
			{
				super(parent, dataSource, objectClass);
			}
			
		public void cloneFieldsTo(DescriptionIDs clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
			}
			
		@Override
		public DescriptionIDs clone()
			{
				DescriptionIDs clone = new DescriptionIDs(getParent(), dataSource, objectClass);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
			
		@Override
		public DescriptionIDs clone(EffectopediaObject parent, DataSource dataSource)
			{
				DescriptionIDs clone = new DescriptionIDs(parent, dataSource, objectClass);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
			
		public DescriptionSection getDSBy(long originalDefaultID)
			{
				for (DescriptionSection ds : objects)
					if (ds.getOriginalDefaultID() == originalDefaultID)
						return ds;
				return null;
			}
	}

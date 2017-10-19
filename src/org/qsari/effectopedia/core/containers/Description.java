package org.qsari.effectopedia.core.containers;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.data.DataSource;

public class Description extends EffectopediaObjects<DescriptionSection>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public boolean addNew(EffectopediaObject parent, DataSource dataSource, Class<DescriptionSection> objectClass)
			{
				DescriptionSection ds = new DescriptionSection(parent, dataSource);
				DescriptionSection old = put(ds.getID(), ds);
				return (old == null) || (old == ds);
			}
		
		public DescriptionSection[] get()
			{
				return values().toArray(new DescriptionSection[values().size()]);
			}
		
		public String toString()
			{
				return "description";
			}
		
	}

package org.qsari.effectopedia.data.interfaces;

import org.qsari.effectopedia.data.objects.FixedValuesList;

public interface IdentifiableDescriptorType extends IdentifiableIndexedObject
	{
		public String getName();
		
		public void setName(String name);
		
		public String getDescription();
		
		public void setDescription(String description);
		
		public IdentifiableDataUnit getDefaultUnit();
		
		public void setDefaultUnit(IdentifiableDataUnit defaultUnit);
		
		public Class<?> getBaseValueType();
		
		public void setBaseValueType(Class<?> baseValueType);
		
		public FixedValuesList getFixedValuesList();

		public void setFixedValuesList(FixedValuesList fixedValuesList);
	}

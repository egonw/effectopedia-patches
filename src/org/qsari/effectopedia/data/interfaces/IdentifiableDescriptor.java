package org.qsari.effectopedia.data.interfaces;


public interface IdentifiableDescriptor
	{
		public StringableDataValue<?> getValue();

		public String getDisplayValue();
		
		public String getValueAndUnit();
		
		public void setValue(String value);
		
		public void setValueAndUnit(String valueAndUnit);
		
		public IdentifiableDescriptorType getType();
		
		public void setType(IdentifiableDescriptorType type);
	}

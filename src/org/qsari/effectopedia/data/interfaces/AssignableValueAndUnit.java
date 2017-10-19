package org.qsari.effectopedia.data.interfaces;

public interface AssignableValueAndUnit
	{
		public StringableDataValue<?> getValue();
		
		public void setValue(String value);
		
		public String getDisplayValue();
		
		public String getDisplayUnit();
		
		public IdentifiableDataUnit getUnit();
		
		public void setUnit(String unit);
		
	}

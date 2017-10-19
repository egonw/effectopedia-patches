package org.qsari.effectopedia.data.interfaces;

public interface StringableDataValue<T>
	{
		public StringableDataValue<T> setValue(T value);
		
		public T getValue();
		
		public String toString();
		
		public void parseString(String fromString);
		
		public String getDisplayValue();
		
		public double getAsDouble();
		
		public void setFromDouble(double newValue);
	}

package org.qsari.effectopedia.base;

public interface Stringable
	{
		public String[] getFields();
		
		public String[] getValues();
		
		public void setValues(String[] values);
		
		public void setValue(int index, String value);
		
		public String getValue(int index);
	}

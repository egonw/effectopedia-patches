package org.qsari.effectopedia.base.io;

public interface BaseIOAttribute extends BaseIOValue
	{
		public BaseIOAttribute setValue(boolean value);
		
		public BaseIOAttribute setValue(int value);
		
		public BaseIOAttribute setValue(long value);
		
		public BaseIOAttribute setValue(float value);
		
		public BaseIOAttribute setValue(double value);
		
		public BaseIOAttribute setValue(String value);

		public BaseIOAttribute setData(String value);
		
		public BaseIOAttribute setName(String name);
	}

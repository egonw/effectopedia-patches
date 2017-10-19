package org.qsari.effectopedia.base.io;

public interface BaseIOValue extends BaseIOEntry
	{
		public BaseIOValue setValue(boolean value);
		
		public BaseIOValue setValue(int value);
		
		public BaseIOValue setValue(long value);
		
		public BaseIOValue setValue(float value);
		
		public BaseIOValue setValue(double value);
		
		public BaseIOValue setValue(String value);
		
		public BaseIOValue setData(String value);

		public BaseIOValue setName(String name);
	
	}

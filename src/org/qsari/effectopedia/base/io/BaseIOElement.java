package org.qsari.effectopedia.base.io;

import java.util.List;

public interface BaseIOElement extends BaseIOEntry
	{
		public BaseIOElement addChild(BaseIOElement child);
		
		public BaseIOElement addValueElement(BaseIOValue valueElement);

		public BaseIOElement getChild(String name);
		
		public BaseIOValue getValueElement(String name);
		
		public BaseIOArray getArray(String name);
		
		public BaseIOElement setValue(String value);
		
		public BaseIOElement setData(String value);

		public List<BaseIOElement> getChildren();
		
		public BaseIOElement setName(String name);
		
		public String getChildValue(String name);
		
		public BaseIOAttribute getAttribute(String name);
		
		public String getAttributeValue(String name);
		
		public BaseIOElement addAttribute(BaseIOAttribute attribute);
		
		public BaseIOElement setAttribute(String name, boolean value);
		
		public BaseIOElement setAttribute(String name, int value);
		
		public BaseIOElement setAttribute(String name, long value);
		
		public BaseIOElement setAttribute(String name, float value);
		
		public BaseIOElement setAttribute(String name, double value);
		
		public BaseIOElement setAttribute(String name, String value);
		
		public List<BaseIOAttribute> getAttributes();
		
	}

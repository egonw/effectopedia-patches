package org.qsari.effectopedia.data.xml;

import org.jdom.Element;
import org.qsari.effectopedia.base.io.BaseIOArray;

public class XMLArrayElement extends XMLElement implements BaseIOArray
	{
		public XMLArrayElement(Element element)
			{
				super(element);
			}
		
		public XMLArrayElement(String name, int count)
			{
				super(name);
				setAttribute("count", String.valueOf(count));
			}
		
		@Override
		public void setCount(int count)
			{
				setAttribute("count", String.valueOf(count));
			}
		
		@Override
		public int getCount()
			{
				return Integer.parseInt(getAttributeValue("count"));
			}
		
		@Override
		public boolean isValidArray()
			{
				int count = Integer.parseInt(getAttributeValue("count"));
				return (count > 0) & (count == getChildren().size());
			}
		
	}

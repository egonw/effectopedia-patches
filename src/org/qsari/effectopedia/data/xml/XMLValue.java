package org.qsari.effectopedia.data.xml;

import java.util.HashMap;

import org.jdom.CDATA;
import org.jdom.Element;
import org.jdom.Namespace;
import org.qsari.effectopedia.base.io.BaseIOValue;

public class XMLValue implements BaseIOValue
	{
		public XMLValue(Element element)
			{
				this.element = element;
				elementMAP.put(element, this);
			}
		
		public XMLValue(String name)
			{
				Element e = new Element(name, DEFAULT_NAMESPACE);
				this.element = e;
				elementMAP.put(e, this);
			}
		
		public boolean getBooleanValue()
			{
				return Boolean.parseBoolean(element.getValue());
			}
		
		public double getDoubleValue()
			{
				return Double.parseDouble(element.getTextTrim());
			}
		
		public float getFloatValue()
			{
				return Float.parseFloat(element.getTextTrim());
			}
		
		public int getIntValue()
			{
				return Integer.parseInt(element.getTextTrim());
			}
		
		public long getLongValue()
			{
				return Long.parseLong(element.getTextTrim());
			}
		
		@Override
		public BaseIOValue setValue(boolean value)
			{
				element.setText(String.valueOf(value));
				return this;
			}

		@Override
		public BaseIOValue setValue(int value)
			{
				element.setText(String.valueOf(value));
				return this;
			}

		@Override
		public BaseIOValue setValue(long value)
			{
				element.setText(String.valueOf(value));
				return this;
			}

		@Override
		public BaseIOValue setValue(float value)
			{
				element.setText(String.valueOf(value));
				return this;
			}

		@Override
		public BaseIOValue setValue(double value)
			{
				element.setText(String.valueOf(value));
				return this;
			}

		public BaseIOValue setValue(String value)
			{
				element.setText(value);
				return this;
			}
		
		public BaseIOValue setData(String value)
			{
				element.addContent(new CDATA(value));
				return this;
			}
		
		public String getName()
			{
				return element.getName();
			}
		
		public String getValue()
			{
				return element.getText();
			}
		
		public BaseIOValue setName(String name)
			{
				element.setName(name);
				return this;
			}
		
		protected static BaseIOValue getBaseIOValue(Element element)
			{
				if (element != null)
					{
						XMLValue e = elementMAP.get(element);
						if (e == null)
							{
								e = new XMLValue(element);
								elementMAP.put(element, e);
							}
						return e;
					}
				else
					return null;
			}
		
		protected Element																											element;
		
		protected static HashMap<Element, XMLValue>	elementMAP								= new HashMap<Element, XMLValue>();
		public static final Namespace															DEFAULT_NAMESPACE	= Namespace.XML_NAMESPACE;
	}

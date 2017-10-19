package org.qsari.effectopedia.data.xml;

import java.util.HashMap;

import org.jdom.Attribute;
import org.jdom.DataConversionException;
import org.jdom.Namespace;
import org.qsari.effectopedia.base.io.BaseIOAttribute;

public class XMLAttribute implements BaseIOAttribute
	{
		
		/**
	 * 
	 */
		public static final long						serialVersionUID		= 1L;
		
		public static final Namespace	DEFAULT_NAMESPACE	= Namespace.XML_NAMESPACE;
		
		public XMLAttribute(Attribute attribute)
			{
				this.attribute = attribute;
				attributeMAP.put(attribute, this);
			}
		
		public XMLAttribute(String name)
			{
				Attribute a = new Attribute(name, "", DEFAULT_NAMESPACE);
				attributeMAP.put(a, this);
				this.attribute = a;
			}
		
		public XMLAttribute(String name, String value)
			{
				Attribute a = new Attribute(name, value==null?"":value, DEFAULT_NAMESPACE);
				attributeMAP.put(a, this);
				this.attribute = a;
			}
		
		public boolean getBooleanValue()
			{
				try
					{
						return attribute.getBooleanValue();
					}
				catch (DataConversionException e)
					{
						e.printStackTrace();
						return false;
					}
			}
		
		public double getDoubleValue()
			{
				try
					{
						return attribute.getDoubleValue();
					}
				catch (DataConversionException e)
					{
						e.printStackTrace();
						return 0D;
					}
			}
		
		public float getFloatValue()
			{
				try
					{
						return attribute.getFloatValue();
					}
				catch (DataConversionException e)
					{
						e.printStackTrace();
						return 0F;
					}
			}
		
		public int getIntValue()
			{
				try
					{
						return attribute.getIntValue();
					}
				catch (DataConversionException e)
					{
						e.printStackTrace();
						return -1;
					}
			}
		
		public long getLongValue()
			{
				try
					{
						return attribute.getLongValue();
					}
				catch (DataConversionException e)
					{
						e.printStackTrace();
						return 0;
					}
			}
		
		public String getValue()
			{
				return attribute.getValue();
			}
		
		@Override
		public BaseIOAttribute setValue(boolean value)
			{
				attribute.setValue(String.valueOf(value));
				return this;
			}
		
		@Override
		public BaseIOAttribute setValue(int value)
			{
				attribute.setValue(String.valueOf(value));
				return this;
			}
		
		@Override
		public BaseIOAttribute setValue(long value)
			{
				attribute.setValue(String.valueOf(value));
				return this;
			}
		
		@Override
		public BaseIOAttribute setValue(float value)
			{
				attribute.setValue(String.valueOf(value));
				return this;
			}
		
		@Override
		public BaseIOAttribute setValue(double value)
			{
				attribute.setValue(String.valueOf(value));
				return this;
			}
		
		public XMLAttribute setValue(String value)
			{
				attribute.setValue(value);
				return this;
			}
		
		public XMLAttribute setName(String name)
			{
				attribute.setName(name);
				return this;
			}
		
		public String getName()
			{
				return attribute.getName();
			}

		public BaseIOAttribute setData(String value)
			{
				return null;
			}

		protected Attribute	attribute;
		
		protected static BaseIOAttribute getBaseIOAttribute(Attribute attribute)
			{
				if (attribute != null)
					{
						XMLAttribute a = attributeMAP.get(attribute);
						if (a == null)
							{
								a = new XMLAttribute(attribute);
								attributeMAP.put(attribute, a);
							}
						return a;
					}
				else
					return null;
			}

		protected static HashMap<Attribute, XMLAttribute>	attributeMAP	= new HashMap<Attribute, XMLAttribute>();

	}

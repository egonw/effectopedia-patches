package org.qsari.effectopedia.data.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.CDATA;
import org.jdom.Element;
import org.jdom.Namespace;
import org.qsari.effectopedia.base.io.BaseIOArray;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.BaseIOValue;

public class XMLElement implements BaseIOElement
	{
		public XMLElement(Element element)
			{
				this.element = element;
				elementMAP.put(element,this);
			}

		public XMLElement(String name)
			{
				Element e = new Element(name, DEFAULT_NAMESPACE);
				this.element = e;
				elementMAP.put(e, this);
			}
		
		public boolean getBooleanValue()
			{
				return Boolean.getBoolean(element.getValue());
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
		
		public BaseIOElement addChild(BaseIOElement child)
			{
				element.addContent(((XMLElement) child).element);
				return this;
			}

		public BaseIOElement addValueElement(BaseIOValue valueElement)
			{
				element.addContent(((XMLValue) valueElement).element);
				return this;
			}

		public String getChildValue(String name)
			{
				return element.getChildText(name, DEFAULT_NAMESPACE);
			}
		
		public BaseIOElement addAttribute(BaseIOAttribute attribute)
			{
				element.setAttribute(((XMLAttribute) attribute).attribute);
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

		public BaseIOElement setValue(String value)
			{
				element.setText(value);
				return this;
			}
		
		@Override
		public BaseIOElement setData(String value)
			{
				element.setContent(new CDATA(value));
				return this;
			}

		public BaseIOElement getChild(String name)
			{
				return getBaseIOElement(element.getChild(name,DEFAULT_NAMESPACE));
			}

		@Override
		public BaseIOValue getValueElement(String name)
			{
				return XMLValue.getBaseIOValue(element.getChild(name,DEFAULT_NAMESPACE));
			}

		public BaseIOArray getArray(String name)
			{
				return getBaseIOArrayElement(element.getChild(name,DEFAULT_NAMESPACE));
			}
		
		public List<BaseIOElement> getChildren()
			{
				List<?> children = element.getChildren();
				ArrayList<BaseIOElement> list = new ArrayList<BaseIOElement>(children.size());
				Iterator<?> it = children.iterator();
				while (it.hasNext())
					list.add(getBaseIOElement((Element) it.next()));
				return list;
			}
		
		public BaseIOAttribute getAttribute(String name)
			{
				return XMLAttribute.getBaseIOAttribute(element.getAttribute(name,DEFAULT_NAMESPACE));
			}
		
		public String getAttributeValue(String name)
			{
				Attribute a = element.getAttribute(name,DEFAULT_NAMESPACE);
				return (a != null) ? a.getValue() : null;
			}
		
		@Override
		public BaseIOElement setAttribute(String name, boolean value)
			{
				XMLAttribute attribute = new XMLAttribute(name,String.valueOf(value));
				element.setAttribute(attribute.attribute);
				return this;
			}

		@Override
		public BaseIOElement setAttribute(String name, int value)
			{
				XMLAttribute attribute = new XMLAttribute(name,String.valueOf(value));
				element.setAttribute(attribute.attribute);
				return this;
			}

		@Override
		public BaseIOElement setAttribute(String name, long value)
			{
				XMLAttribute attribute = new XMLAttribute(name,String.valueOf(value));
				element.setAttribute(attribute.attribute);
				return this;
			}

		@Override
		public BaseIOElement setAttribute(String name, float value)
			{
				XMLAttribute attribute = new XMLAttribute(name,String.valueOf(value));
				element.setAttribute(attribute.attribute);
				return this;
			}

		@Override
		public BaseIOElement setAttribute(String name, double value)
			{
				XMLAttribute attribute = new XMLAttribute(name,String.valueOf(value));
				element.setAttribute(attribute.attribute);
				return this;
			}

		public BaseIOElement setAttribute(String name, String value)
			{
				XMLAttribute attribute = new XMLAttribute(name, value);
				element.setAttribute(attribute.attribute);
				return this;
			}
		
		public List<BaseIOAttribute> getAttributes()
			{
				List<?> attributes = element.getAttributes();
				ArrayList<BaseIOAttribute> list = new ArrayList<BaseIOAttribute>(attributes.size());
				Iterator<?> it = attributes.iterator();
				while (it.hasNext())
					list.add(XMLAttribute.getBaseIOAttribute((Attribute) it.next()));
				return list;
			}
		
		public BaseIOElement setName(String name)
			{
				element.setName(name);
				return this;
			}
		
		protected static BaseIOElement getBaseIOElement(Element element)
			{
				if (element != null)
					{
						XMLElement e = elementMAP.get(element);
						if (e == null)
							{
								e = new XMLElement(element);
								elementMAP.put(element, e);
							}
						return e;
					}
				else
					return null;
			}

		protected static BaseIOArray getBaseIOArrayElement(Element element)
			{
				if (element != null)
					{
						XMLArrayElement e = (XMLArrayElement) elementMAP.get(element);
						if (e == null)
							{
								Attribute attribute  = element.getAttribute("count",DEFAULT_NAMESPACE);
								if (attribute==null)
									return null;
								e = new XMLArrayElement(element);
								elementMAP.put(element, e);
							}
						return e;
					}
				else
					return null;
			}
		
		public Element getElement()
			{
				return element;
			}

		protected Element																													element;
		
		protected static HashMap<Element, XMLElement>	elementMAP								= new HashMap<Element, XMLElement>();
		public static final Namespace																	DEFAULT_NAMESPACE	= Namespace.XML_NAMESPACE;
	}

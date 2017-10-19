package org.qsari.effectopedia.data.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.qsari.effectopedia.base.io.BaseIOArray;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.BaseIOValue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JSONObject extends JSONNode implements BaseIOElement
	{
		
		public JSONObject(ObjectNode node)
			{
				super("");
				this.node = node;
				nodeMAP.put(node, this);
			}
		
		public JSONObject(String name)
			{
				super(name);
				node = JSONFileDS.factory.objectNode();
				nodeMAP.put(node, this);
			}
		
		@Override
		public BaseIOElement addChild(BaseIOElement child)
			{
				((ObjectNode) node).set(child.getName(), ((JSONNode) child).node);
				return this;
			}
		
		@Override
		public BaseIOElement getChild(String name)
			{
				JSONNode obj = getBaseIOEntry(((ObjectNode) node).get(name));
				if (obj.node.isObject())
					return (JSONObject) obj;
				else
					return null;
			}
		
		@Override
		public BaseIOArray getArray(String name)
			{
				JSONNode arr = getBaseIOEntry(((ObjectNode) node).get(name));
				if (arr.node.isArray())
					return (BaseIOArray) arr;
				else
					return null;
			}
		
		@Override
		public List<BaseIOElement> getChildren()
			{
				ArrayList<BaseIOElement> list = new ArrayList<BaseIOElement>(node.size());
				Iterator<JsonNode> it = node.elements();
				while (it.hasNext())
					{
						JSONNode n = getBaseIOEntry(it.next());
						if (n instanceof JSONObject)
							list.add((JSONObject) n);
					}
				return list;
			}
		
		@Override
		public BaseIOElement setName(String name)
			{
				this.nodeName = name;
				return this;
			}
		
		@Override
		public BaseIOElement setValue(String value)
			{
				JSONValue val = new JSONValue("value");
				val.setValue(value);
				((ObjectNode) node).set("value", ((JSONNode) val).node);
				return this;
			}
		
		@Override
		public BaseIOElement setData(String value)
			{
				JSONValue val = new JSONValue("value");
    val.setData(value);
				((ObjectNode) node).set("value", ((JSONNode) val).node);
				return this;
			}
		
		@Override
		public String getChildValue(String name)
			{
				JSONNode obj = getBaseIOEntry(((ObjectNode) node).get(name));
				return obj.getValue();
			}
		
		@Override
		public BaseIOAttribute getAttribute(String name)
			{
				JSONNode att = getBaseIOEntry(((ObjectNode) node).get(name));
				if (att.node.isValueNode())
					return (JSONValue) att;
				else
					return null;
			}
		
		@Override
		public String getAttributeValue(String name)
			{
				JSONNode att = getBaseIOEntry(((ObjectNode) node).get(name));
				if (att.node.isValueNode())
					return att.node.asText();
				else
					return null;
			}
		
		@Override
		public BaseIOElement addAttribute(BaseIOAttribute attribute)
			{
				((ObjectNode) node).set(attribute.getName(), ((JSONNode) attribute).node);
				return this;
			}
		
		@Override
		public BaseIOElement setAttribute(String name, boolean value)
			{
				JSONValue attribute = new JSONValue(name);
				attribute.setValue(value);
				((ObjectNode) node).set(name, ((JSONNode) attribute).node);
				return this;
			}
		
		@Override
		public BaseIOElement setAttribute(String name, int value)
			{
				JSONValue attribute = new JSONValue(name);
				attribute.setValue(value);
				((ObjectNode) node).set(name, ((JSONNode) attribute).node);
				return this;
			}
		
		@Override
		public BaseIOElement setAttribute(String name, long value)
			{
				JSONValue attribute = new JSONValue(name);
				attribute.setValue(value);
				((ObjectNode) node).set(name, ((JSONNode) attribute).node);
				return this;
			}
		
		@Override
		public BaseIOElement setAttribute(String name, float value)
			{
				JSONValue attribute = new JSONValue(name);
				attribute.setValue(value);
				((ObjectNode) node).set(name, ((JSONNode) attribute).node);
				return this;
			}
		
		@Override
		public BaseIOElement setAttribute(String name, double value)
			{
				JSONValue attribute = new JSONValue(name);
				attribute.setValue(value);
				((ObjectNode) node).set(name, ((JSONNode) attribute).node);
				return this;
			}
		
		@Override
		public BaseIOElement setAttribute(String name, String value)
			{
				JSONValue baseTypeValue = new JSONValue(name);
				baseTypeValue.setValue(value);
				((ObjectNode) node).set(name, baseTypeValue.getNode());
				return this;
			}
		
		@Override
		public List<BaseIOAttribute> getAttributes()
			{
				ArrayList<BaseIOAttribute> list = new ArrayList<BaseIOAttribute>(node.size());
				Iterator<JsonNode> it = node.elements();
				while (it.hasNext())
					{
						JSONNode n = getBaseIOEntry(it.next());
						if (n instanceof JSONValue)
							list.add((JSONValue) n);
					}
				return list;
			}
		
		@Override
		public BaseIOElement addValueElement(BaseIOValue valueElement)
			{
				if (valueElement instanceof JSONNode)
					((ObjectNode) node).set(((JSONNode) valueElement).nodeName, ((JSONNode) valueElement).node);
				return this;
			}
		
		@Override
		public BaseIOValue getValueElement(String name)
			{
				JSONNode val = getBaseIOEntry(((ObjectNode) node).get(name));
				if (val.node.isValueNode())
					return (JSONValue) val;
				else
					return null;
			}
	}

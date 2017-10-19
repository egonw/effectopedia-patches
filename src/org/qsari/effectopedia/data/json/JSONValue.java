package org.qsari.effectopedia.data.json;

import org.qsari.effectopedia.base.io.BaseIOAttribute;

import com.fasterxml.jackson.databind.JsonNode;

public class JSONValue extends JSONNode implements BaseIOAttribute
	{
		public JSONValue(String fieldName)
			{
				super(fieldName);
			}

		@Override
		public BaseIOAttribute setValue(boolean value)
			{
				node = JSONFileDS.factory.booleanNode(value);
				nodeMAP.put(node, this);
				return this;
			}
		
		@Override
		public BaseIOAttribute setValue(int value)
			{
				node = JSONFileDS.factory.numberNode(value);
				nodeMAP.put(node, this);
				return this;
			}
		
		@Override
		public BaseIOAttribute setValue(long value)
			{
				node = JSONFileDS.factory.numberNode(value);
				nodeMAP.put(node, this);
				return this;
			}
		
		@Override
		public BaseIOAttribute setValue(float value)
			{
				node = JSONFileDS.factory.numberNode(value);
				nodeMAP.put(node, this);
				return this;
			}
		
		@Override
		public BaseIOAttribute setValue(double value)
			{
				node = JSONFileDS.factory.numberNode(value);
				nodeMAP.put(node, this);
				return this;
			}
		
		@Override
		public BaseIOAttribute setValue(String value)
			{
				node = JSONFileDS.factory.textNode(value);
				nodeMAP.put(node, this);
				return this;
			}

		@Override
		public BaseIOAttribute setData(String value)
			{
				node = JSONFileDS.factory.binaryNode(value.getBytes());
				nodeMAP.put(node, this);
				return this;
			}
		
		@Override
		public BaseIOAttribute setName(String name)
			{
				nodeName = name;
				return this;
			}
		
		public JsonNode getNode()
			{
				return node;
			}
		
		public void setNode(JsonNode node)
			{
				this.node = node;
			}

		
	}

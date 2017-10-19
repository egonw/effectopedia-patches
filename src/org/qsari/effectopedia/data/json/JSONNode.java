package org.qsari.effectopedia.data.json;

import java.util.HashMap;

import org.qsari.effectopedia.base.io.BaseIOEntry;

import com.fasterxml.jackson.databind.JsonNode;

public class JSONNode implements BaseIOEntry
	{
		public JSONNode(String name)
			{
				this.nodeName = name;
			}
		
		@Override
		public String getName()
			{
				return nodeName;
			}
		
		@Override
		public boolean getBooleanValue()
			{
				return node.asBoolean();
			}
		
		@Override
		public double getDoubleValue()
			{
				return node.asDouble();
			}
		
		@Override
		public float getFloatValue()
			{
				return (float) node.asDouble();
			}
		
		@Override
		public int getIntValue()
			{
				return node.asInt();
			}
		
		@Override
		public long getLongValue()
			{
				return node.asLong();
			}
		
		@Override
		public String getValue()
			{
				return node.asText();
			}
		
		protected static JSONNode getBaseIOEntry(JsonNode node)
			{
				if (node != null)
					return nodeMAP.get(node);
				else
					return null;
			}
		
		protected String																													nodeName;
		protected JsonNode																											node;
		protected static HashMap<JsonNode, JSONNode>	nodeMAP	= new HashMap<JsonNode, JSONNode>();
	}

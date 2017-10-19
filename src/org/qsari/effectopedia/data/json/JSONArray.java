package org.qsari.effectopedia.data.json;

import org.qsari.effectopedia.base.io.BaseIOArray;
import org.qsari.effectopedia.base.io.BaseIOElement;

import com.fasterxml.jackson.databind.node.ArrayNode;

public class JSONArray extends JSONObject implements BaseIOArray
	{

	public JSONArray(String name)
		{
			super(name);
			node = JSONFileDS.factory.arrayNode();
			nodeMAP.put(node, this);
		}

	@Override
	public void setCount(int count)
		{
		}

	@Override
	public int getCount()
		{
			return node.size();
		}

	@Override
	public BaseIOElement addChild(BaseIOElement child)
		{
			((ArrayNode) node).add(((JSONNode) child).node);
			return this;
		}

	@Override
	public boolean isValidArray()
		{
			return (node!=null)&&(node.isArray());
		}
		
	}

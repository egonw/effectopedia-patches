package org.qsari.effectopedia.data.objects;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.search.SearchableItem;

public class DataValue_IntRef extends DataValue_Integer 
	{

	public DataValue_IntRef(SearchableItem searchableItem, FixedValuesList fixedList)
		{
			super(searchableItem);
			this.fixedList = fixedList;
		}
	
	public DataValue_IntRef(SearchableItem searchableItem, FixedValuesList fixedList, int value)
		{
			super(searchableItem);
			this.fixedList = fixedList;
			this.value = value;
		}

	public DataValue_IntRef(SearchableItem searchableItem, FixedValuesList fixedList, String value)
		{
			super(searchableItem);
			this.fixedList = fixedList;
			this.value = fixedList.indexOf(value);
		}
	
	public DataValue_IntRef clone()
		{
			DataValue_IntRef clone = new DataValue_IntRef(this.searchItem,this.fixedList,this.value);
			return clone;
		}
	
	public String getDisplayValue()
		{
			return fixedList.get(value);
		}
	
	public void parseString(String fromString)
		{
			
			Integer newValue = fixedList.indexOf(fromString);
			if (newValue==-1)
				newValue = Integer.parseInt(fromString);
			if (value!=newValue)
				{
					DataValue_Integer oldValue = this.clone();
					value = newValue;
					if (searchItem!=null)
				  Effectopedia.getEffectopedia().getData().updateSearchIndices(oldValue, this);
				}
		} 
 
	public FixedValuesList fixedList;
	}

package org.qsari.effectopedia.data.objects;

import org.qsari.effectopedia.search.SearchableItem;

public class DataValue_LongRef extends DataValue_Long 
	{

	public DataValue_LongRef(SearchableItem searchableItem, FixedValuesList fixedList)
		{
			super(searchableItem);
			this.fixedList = fixedList;
		}
	
	public DataValue_LongRef clone()
		{
			DataValue_LongRef clone = new DataValue_LongRef(this.searchItem,this.fixedList);
			clone.value = this.value;
			return clone;
		}
	
		public FixedValuesList fixedList;
	}

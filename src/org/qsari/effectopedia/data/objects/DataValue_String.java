package org.qsari.effectopedia.data.objects;

import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.search.SearchableItem;

public class DataValue_String extends DataValue<String>
	{
	
		public DataValue_String()
			{
				this.searchItem = null;
			}
		
	public DataValue_String(SearchableItem searchableItem)
		{
			super(searchableItem);
			value = null;
		}

	public DataValue_String clone()
		{
			DataValue_String clone = new DataValue_String(searchItem);
			clone.value = this.value;
			return clone;
		}

	public DataValue_String clone(IndexedObject parent)
		{
			DataValue_String clone = new DataValue_String(searchItem.clone(parent));
			clone.value = this.value;
			return clone;
		}
	
	public void parseString(String fromString)
		{
			if (((value==null)&&(fromString!=null))||((value!=null)&&(!value.equalsIgnoreCase(fromString))))
				{
					DataValue_String oldValue = this.clone();
					value = fromString;
					if (searchItem!=null)
					 Effectopedia.getEffectopedia().getData().updateSearchIndices(oldValue, this);
				}
		}
	
	}

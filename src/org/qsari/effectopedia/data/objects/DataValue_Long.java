package org.qsari.effectopedia.data.objects;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.search.SearchableItem;

public class DataValue_Long extends DataValue<Long>
	{
		
		public DataValue_Long(SearchableItem searchableItem)
			{
				super(searchableItem);
				value = new Long(0L);
			}
		
		public DataValue_Long clone()
			{
				DataValue_Long clone = new DataValue_Long(searchItem);
				clone.value = this.value;
				return clone;
			}
		
		public void parseString(String fromString)
			{
				try
					{
						Long newValue = Long.parseLong(fromString);
						if (value != newValue)
							{
								DataValue_Long oldValue = this.clone();
								value = newValue;
								if (searchItem != null)
									Effectopedia.getEffectopedia().getData().updateSearchIndices(oldValue, this);
							}
					}
				catch (NumberFormatException e)
					{
						System.out.println("Exception Handled!");
						e.printStackTrace(System.out);
					}
			}
		
		@Override
		public void setFromDouble(double newValue)
			{
				value = Long.valueOf((long) newValue);
			}
		
	}

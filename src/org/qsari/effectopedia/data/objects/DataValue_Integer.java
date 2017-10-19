package org.qsari.effectopedia.data.objects;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.search.SearchableItem;

public class DataValue_Integer extends DataValue<Integer>
	{
		
		public DataValue_Integer(SearchableItem searchableItem)
			{
				super(searchableItem);
				value = new Integer(0);
			}
		
		public DataValue_Integer clone()
			{
				DataValue_Integer clone = new DataValue_Integer(searchItem);
				clone.value = this.value;
				return clone;
			}
		
		public void parseString(String fromString)
			{
				if ((fromString != null) && (fromString.length() > 0))
					try
						{
							Integer newValue = Integer.parseInt(fromString.replaceAll("[^0-9]", ""));
							if (value != newValue)
								{
									DataValue_Integer oldValue = this.clone();
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
				value = Integer.valueOf((int) newValue);
			}
		
	}

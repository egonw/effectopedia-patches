package org.qsari.effectopedia.data.objects;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.search.SearchableItem;

public class DataValue_Double extends DataValue<Double>
	{
		
		public DataValue_Double(SearchableItem searchableItem)
			{
				super(searchableItem);
				value = new Double(0.0D);
			}
		
		public DataValue_Double clone()
			{
				DataValue_Double clone = new DataValue_Double(searchItem);
				clone.value = this.value;
				return clone;
			}
		
		public void parseString(String fromString)
			{
				try
					{
						Double newValue = ((fromString == null)||(fromString.length()==0)) ? Double.NaN : Double.parseDouble(fromString);
						if (value != newValue)
							{
								DataValue_Double oldValue = this.clone();
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
				value = Double.valueOf(newValue);
			}
		
	}

package org.qsari.effectopedia.data.objects;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.search.SearchableItem;

public class DataValue_Float extends DataValue<Float>
	{
		
		public DataValue_Float(SearchableItem searchableItem)
			{
				super(searchableItem);
				value = new Float(0.0F);
			}
		
		public DataValue_Float clone()
			{
				DataValue_Float clone = new DataValue_Float(searchItem);
				clone.value = this.value;
				return clone;
			}
		
		public void parseString(String fromString)
			{
				try
					{
						Float newValue = ((fromString==null)||fromString.length()==0)?Float.NaN:Float.parseFloat(fromString);
						if (value != newValue)
							{
								DataValue_Float oldValue = this.clone();
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
				value = Float.valueOf((float) newValue);
			}
		
	}

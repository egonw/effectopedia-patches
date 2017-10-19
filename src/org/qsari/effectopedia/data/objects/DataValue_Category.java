package org.qsari.effectopedia.data.objects;

import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.BaseIOValue;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.search.SearchableItem;

public class DataValue_Category<T> extends DataValue<DataValue<T>>
	{
		public DataValue_Category(SearchableItem searchableItem)
		{
			super(searchableItem);
			value = new DataValue<T>(searchableItem);
		}

		public DataValue_Category<T> clone()
			{
				DataValue_Category<T> clone = new DataValue_Category<T>(searchItem);
				clone.value = this.value;
				clone.categoryIndex = this.categoryIndex;
				return clone;
			}

		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						BaseIOElement e = element.getChild("value");
						if (e != null)
							value.parseString(e.getValue());
						categoryIndex = Integer.parseInt(element.getChildValue("category_intex"));
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				BaseIOValue e = io.newValue("value");
				if (value!=null)
				 e.setValue(value.toString());
				element.addValueElement(e);
				element.addValueElement(io.newValue("categoryIndex").setValue(Integer.toString(categoryIndex)));
				return element;
			}
		
	 public int getCategoryIndex()
			{
				return categoryIndex;
			}

		public void setCategoryIndex(int categoryIndex)
			{
				this.categoryIndex = categoryIndex;
			}
		
		public void parseString(String fromString)
			{
				if (((value==null)&&(fromString!=null))||((value!=null)&&(!value.toString().equalsIgnoreCase(fromString))))
					{
						DataValue_Category<T> oldValue = this.clone();
						value.parseString(fromString);
						Effectopedia.getEffectopedia().getData().updateSearchIndices(oldValue, this);
					}
			}

		protected int categoryIndex;
	}

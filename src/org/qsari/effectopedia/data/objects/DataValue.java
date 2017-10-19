/*
 * 
 */

package org.qsari.effectopedia.data.objects;

import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.interfaces.StringableDataValue;
import org.qsari.effectopedia.search.SearchableItem;

public class DataValue<T> implements Importable, Exportable, Cloneable, Traceable, Comparable<T>, StringableDataValue<T>
	{
		
		public DataValue()
			{
				this.searchItem = null;
			}
		
		public DataValue(SearchableItem searchableItem)
			{
				super();
				this.searchItem = searchableItem;
			}
		
		public DataValue(SearchableItem searchableItem, T value)
			{
				super();
				this.value = value;
				this.searchItem = searchableItem;
			}
		
		public void cloneFieldsTo(DataValue<T> clone)
			{
				clone.value = this.value;
			}
		
		public DataValue<T> clone()
			{
				DataValue<T> clone = new DataValue<T>(searchItem);
				cloneFieldsTo(clone);
				return clone;
			}
		
		public DataValue<T> clone(IndexedObject object)
			{
				DataValue<T> clone = new DataValue<T>(searchItem.clone(object));
				cloneFieldsTo(clone);
				return clone;
			}
		
		public DataValue<T> clone(SearchableItem searchItem)
			{
				DataValue<T> clone = new DataValue<T>(searchItem);
				cloneFieldsTo(clone);
				return clone;
			}
		
		public SearchableItem getSearchItem()
			{
				return searchItem;
			}
		
		public void setSearchItem(SearchableItem searchItem)
			{
				this.searchItem = searchItem;
			}
		
		public DataValue<T> setValue(T value)
			{
				if (((value == null) && (this.value != null)) || (!value.equals(this.value)))
					{
						this.value = value;
					}
				return this;
			}
		
		public T getValue()
			{
				return this.value;
			}
		
		public String toString()
			{
				if (value != null)
					return value.toString();
				else
					return null;
			}
		
		@SuppressWarnings("unchecked")
		public void parseString(String fromString)
			{
				if ((value == null) || (value instanceof String))
					value = (T) fromString;
				else if (value instanceof Integer)
					value = (T) (Integer) Integer.parseInt(fromString);
				else if (value instanceof Float)
					value = (T) (Float) Float.parseFloat(fromString);
				else if (value instanceof Double)
					value = (T) (Double) Double.parseDouble(fromString);
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						parseString(element.getValue());
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				if (value != null)
					element.setValue(getDisplayValue());
				return element;
			}
		
		@SuppressWarnings("unchecked")
		public int compareTo(Object otherValue)
			{
				if ((this.value instanceof Comparable<?>) && (otherValue instanceof DataValue<?>))
					return ((Comparable<T>) this.value).compareTo(((DataValue<T>) otherValue).getValue());
				else
					return 0;
			}
		
		public String getDisplayValue()
			{
				return (value != null) ? value.toString() : "n/a";
			}
		
		public static DataValue<?> newValue(SearchableItem searchableItem, Class<?> c, FixedValuesList valueList)
			{// temporary implementation
				if (c.equals(DataValue_String.class) || c.equals(String.class))
					return new DataValue_String(searchableItem);
				if (c.equals(DataValue_Float.class) || c.equals(Float.class))
					return new DataValue_Float(searchableItem);
				if (c.equals(DataValue_IntRef.class))
					return new DataValue_IntRef(searchableItem, valueList);
				if (c.equals(DataValue_LongRef.class))
					return new DataValue_LongRef(searchableItem, valueList);
				if (c.equals(DataValue_Integer.class) || c.equals(Integer.class))
					return new DataValue_Integer(searchableItem);
				if (c.equals(DataValue_Long.class) || c.equals(Long.class))
					return new DataValue_Long(searchableItem);
				if (c.equals(DataValue_Double.class) || c.equals(Double.class))
					return new DataValue_Double(searchableItem);
				if (c.equals(DataValue_List.class))
					return new DataValue_List<DataValue_String>(searchableItem, DataValue_String.class);
				return null;
			}
		
		public int compareTo(DataValue<T> another)
			{
				if ((value != null) && (another.value != null))
					return ((Comparable<T>) value).compareTo(another.value);
				else
					return 0;
			}
		
		public double getAsDouble()
			{
				if (value instanceof Double)
					return (Double) value;
				else
					return Double.NaN;
			}
		
		@SuppressWarnings("unchecked")
		@Override
		public void setFromDouble(double newValue)
			{
				if (value instanceof Number)
					{
						if (value instanceof Integer)
							value = (T) Integer.valueOf((int) newValue);
						else if (value instanceof Long)
							value = (T) Long.valueOf((long) newValue);
						else if (value instanceof Float)
							value = (T) (Float) Float.valueOf((float) newValue);
						else if (value instanceof Double)
							value = (T) (Double) Double.valueOf(newValue);
					}
			}
		
		protected SearchableItem	searchItem	= null;
		protected T														value;
		
	}

package org.qsari.effectopedia.data.objects;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.search.SearchableItem;

public class DataValue_Interval<T extends DataValue<?>> extends DataValue<Interval<T>>
	{
		
		public DataValue_Interval(SearchableItem searchableItem)
			{
				super(searchableItem);
				value = new Interval<T>();
			}
		
		@SuppressWarnings("unchecked")
		public DataValue_Interval<T> clone()
			{
				DataValue_Interval<T> clone = new DataValue_Interval<T>(searchItem);
				clone.value.lowerBoundary = (T) this.value.lowerBoundary.clone();
				clone.value.inclusiveLowerBoundary = this.value.inclusiveLowerBoundary;
				clone.value.upperBoundary = (T) this.value.upperBoundary.clone();
				clone.value.inclusiveLowerBoundary = this.value.inclusiveLowerBoundary;
				return clone;
			}
		
		public Interval<T> setIntervalValue(T lowerBoundary, T upperBoundary)
			{
				value.lowerBoundary = lowerBoundary;
				value.upperBoundary = upperBoundary;
				return value;
			}
		
		public String toString()
			{
				StringBuilder val = new StringBuilder();
				val.append(value.inclusiveLowerBoundary ? INCL_LOWER_BOUNDARY : EXCL_LOWER_BOUNDARY);
				if (value.lowerBoundary != null)
					val.append(value.lowerBoundary.toString());
				val.append(",");
				if (value.upperBoundary != null)
					val.append(value.upperBoundary.toString());
				val.append(value.inclusiveUpperBoundary ? INCL_UPPER_BOUNDARY : EXCL_UPPER_BOUNDARY);
				return val.toString();
			}
		
		public String getDisplayValue()
			{
				return toString();
			}
		
		public void parseString(String fromString)
			{
				String[] range = fromString.split(DELIMITER);
				if (range.length == 2)
					{
						String boundary = range[0];
						int lb = boundary.indexOf(INCL_LOWER_BOUNDARY);
						if (lb == -1)
							{
								lb = boundary.indexOf(EXCL_LOWER_BOUNDARY);
								value.inclusiveLowerBoundary = lb == -1;
							}
						else
							value.inclusiveLowerBoundary = true;
						value.lowerBoundary.parseString((lb != -1) ? boundary.substring(lb + 1, boundary.length()) : boundary);
						
						boundary = range[1];
						int ub = boundary.indexOf(INCL_UPPER_BOUNDARY);
						if (ub == -1)
							{
								ub = boundary.indexOf(EXCL_UPPER_BOUNDARY);
								value.inclusiveUpperBoundary = lb == -1;
							}
						else
							value.inclusiveUpperBoundary = true;
						value.upperBoundary.parseString((ub != -1) ? boundary.substring(0, ub) : boundary);
					}
				if (searchItem != null)
					{
						DataValue_Interval<T> oldValue = this.clone();
						Effectopedia.getEffectopedia().getData().updateSearchIndices(oldValue, this);
					}
			}
		
		public static final boolean isValidInterval(String string)
			{
				return string.matches(REGEX);
			}
		
		public static final String	DELIMITER											= ",";
		public static final String	INCL_LOWER_BOUNDARY	= "[";
		public static final String	EXCL_LOWER_BOUNDARY	= "(";
		public static final String	INCL_UPPER_BOUNDARY	= "]";
		public static final String	EXCL_UPPER_BOUNDARY	= ")";
		public static final String	REGEX															= ",+";
	}

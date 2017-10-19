package org.qsari.effectopedia.base;

import java.util.Collection;
import java.util.EnumMap;

public class StringableFields<E extends Enum<E>> 
	{
		public StringableFields(Class fieldsClass)
			{
				fieldsMap = new EnumMap<E, String>(fieldsClass);
			}

		public String[] getKeys(E[] fields)
			{
				int l = fields.length;
				String[] result = new String[fields.length];
				for (int i = 0; i < l; i++)
					result[i] = fields[i].toString();
				return result;
			}
		
		public String[] getValues()
			{
				Collection<String> c = fieldsMap.values();
				String[] result = new String[c.size()];
				return c.toArray(result); 
			}

		public String[] getValues(E[] fields)
			{
				int l = fields.length;
				String[] result = new String[fields.length];
				for (int i = 0; i < l; i++)
					result[i] = fieldsMap.get(fields[i]);
				return result;
			}
		
		public void setValues(E[] fields, String[] values)
			{
				int l = values.length; 
				if (l!=fields.length)
					return; 
				for (int i = 0; i < l; i++)
					fieldsMap.put(fields[i], values[i]);
			}
		
		public void setValue(E field, String value) 
			{
				fieldsMap.put(field, value);
			}
		
		public String getValue(E field)
			{
				return fieldsMap.get(field); 
			}
		
		private EnumMap<E, String>	fieldsMap;
	}

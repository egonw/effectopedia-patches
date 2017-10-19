package org.qsari.effectopedia.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class AllClassFields extends ArrayList<Field>
	{
		/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

		public AllClassFields(Class<?> forClass)
			{
				super();
				addFields(forClass);
			}
		
		public void addFields(Class<?> forClass)
			{
				Field fields[] = forClass.getDeclaredFields();
				for (Field fld : fields)
					{
						fld.setAccessible(true);
						add(fld);
					}
				Class<?> superClass = forClass.getSuperclass();
				if (superClass != null)
					addFields(superClass);
			}
	}

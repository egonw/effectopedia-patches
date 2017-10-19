package org.qsari.effectopedia.data.objects;


public enum BaseValueTypes
	{
		DOUBLE(DataValue_Double.class, "Real Number (Double precision)"), FLOAT(DataValue_Float.class, "Real Number (Double precision)"), INT(DataValue_Integer.class, "Natural Number (Integer)"), INTREF(
				DataValue_IntRef.class, "Fixed value index"), LONG(DataValue_Long.class, "Natural Number (Long)"), LONGREF(DataValue_LongRef.class, "Identifier (Numerical)"), STRING(DataValue_String.class,
				"Text");
		
		BaseValueTypes(Class<?> valueType, String caption)
			{
				this.valueType = valueType;
				this.caption = caption;
			}
		
		public String toString()
			{
				return caption;
			}
		
		public Class<?> getValueType()
			{
				return valueType;
			}
		
		public static final BaseValueTypes getByClass(Class<?> valueType)
			{
				for (BaseValueTypes baseType : values())
					if (baseType.valueType.isAssignableFrom(valueType))
						return baseType;
				return null;
			}
		
		private final Class<?>	valueType;
		private final String			caption;
	}

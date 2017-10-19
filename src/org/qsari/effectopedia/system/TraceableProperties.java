package org.qsari.effectopedia.system;

import java.util.HashMap;

public class TraceableProperties
	{
		private TraceableProperties()
			{
				super();
				propertyIDs = new HashMap<Long, TraceableProperty>();
				
			}
		
		public TraceableProperty addProperty(TraceableProperty property)
			{
				return propertyIDs.put(property.getID(),property);
			}

		public long add(String propertyName, String displayName, Class<?> ownerClass)
			{
    TraceableProperty property = new TraceableProperty(propertyName,displayName,ownerClass);
    propertyIDs.put(property.getID(),property);
				return property.getID();
			}

		public static TraceableProperties								REGISTERED	= new TraceableProperties();
		private HashMap<Long, TraceableProperty>	propertyIDs;
	}

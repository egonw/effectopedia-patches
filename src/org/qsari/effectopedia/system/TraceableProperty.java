package org.qsari.effectopedia.system;

import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.defaults.DefaultTextProperties;

public class TraceableProperty extends IndexedObject
	{
		
		public TraceableProperty(String name, String displayName, Class<?> ownerClass)
			{
				super();
				autoSetId();
				this.name = name;
				this.displayName = displayName;
				this.ownerClass = ownerClass;
			}
		
		public long autoId()
			{
				return traceablePropertiesIDs++;
			}
		
		public String getName()
			{
				return name;
			}
		
		public String getDisplayName()
			{
				return displayName;
			}
		
		public Class<?> getOwnerClass()
			{
				return ownerClass;
			}
		
		public static long getTraceableCalassIDs()
			{
				return traceablePropertiesIDs;
			}
		
		public static long getTraceablePropertiesIDs()
			{
				return traceablePropertiesIDs;
			}

		public String getDefaultValue()
			{
				if (ownerClass != null)
					return DefaultTextProperties.INSTANCE.getDefault(ownerClass.getSimpleName() + name);
				else
					return null;
			}
		
		private String													name;
		private String													displayName;
		private Class<?>											ownerClass;
		protected static long						traceablePropertiesIDs	= 0;
		
	}

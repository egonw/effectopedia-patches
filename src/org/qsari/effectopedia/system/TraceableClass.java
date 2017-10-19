package org.qsari.effectopedia.system;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.IndexedObject;

public class TraceableClass extends IndexedObject
	{
		public TraceableClass(Class<? extends EffectopediaObject> c)
			{
				super();
				autoSetId();
				this.registeredClass = c;
				this.name = c.getSimpleName();
				this.classPath = c.getPackage().getName();
				this.description = c.getSimpleName();
			}
		
		public TraceableClass(Class<? extends EffectopediaObject> c, String name, String identifier, String description)
			{
				super();
				autoSetId();
				this.registeredClass = c;
				this.name = name;
				this.identifier = identifier;
				this.classPath = c.getPackage().getName();
				this.description = description;
			}
		
		public long autoId()
			{
				return traceableCalassIDs++;
			}
		
		public String getDescription()
			{
				return description;
			}
		
		public String getName()
			{
				return name;
			}
		
		public Class<? extends EffectopediaObject> getRegisteredClass()
			{
				return registeredClass;
			}
		
		public static long getTraceableCalassIDs()
			{
				return traceableCalassIDs;
			}
		
		public String getIdentifier()
			{
				return identifier;
			}

		public void setIdentifier(String identifier)
			{
				this.identifier = identifier;
			}

		public final String getClassPath()
			{
				return classPath;
			}
		
		public final void setClassPath(String classPath)
			{
				this.classPath = classPath;
			}
		
		private String																														description;
		private String																														name;
		private String																														identifier;
		private String																														classPath;
		
		private Class<? extends EffectopediaObject>	registeredClass;
		
		protected static long																							traceableCalassIDs	= 0;
		
	}

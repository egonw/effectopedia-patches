package org.qsari.effectopedia.data.objects;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.system.ActionTypes;

public class Resource extends EffectopediaObject implements Importable, Exportable, Cloneable
	{
		public static enum ResourceType
			{
				JAVA_SOURCE_CODE("Java source code", "java", true), R_SOURCE_CODE("R source code", "r", true), MATLAB_SOURCE_CODE("Matlab source code", "m", true), DATA("Data", "txt", false), OTHER("Other", "",
						false);
				private ResourceType(String name, String defaultExtension, boolean executable)
					{
						this.descriptiveName = name;
						this.defaultExtension = defaultExtension;
						this.executable = executable;
					}
				
				public String toString()
					{
						return descriptiveName;
					}
				
				public String getDefaultExtension()
					{
						return defaultExtension;
					}
				
				public boolean isExecutable()
					{
						return executable;
					}
				
				private String		descriptiveName;
				private String		defaultExtension;
				private boolean	executable;
			};
		
		public Resource()
			{
				super();
			}
		
		public Resource(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
			}
		
		public Resource(EffectopediaObject parent, DataSource dataSource, String name, String content, ResourceType resourceType)
			{
				super(parent, dataSource);
				this.name = name;
				this.content = content;
				this.resourceType = resourceType;
			}
		
		public void cloneFieldsTo(Resource clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.name = this.name;
				clone.content = this.content;
				clone.resourceType = this.resourceType;
			}
		
		@Override
		public Resource clone()
			{
				Resource clone = new Resource();
				cloneFieldsTo(clone);
				return clone;
			}
		
		@Override
		public EffectopediaObject clone(EffectopediaObject parent, DataSource dataSource)
			{
				Resource clone = new Resource(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						BaseIOElement codeEl = element.getChild("resource");
						if (codeEl != null)
							{
								BaseIOAttribute lang = codeEl.getAttribute("resource_type");
								if (lang != null)
									resourceType = ResourceType.valueOf(lang.getValue().toUpperCase());
								BaseIOAttribute nameAttr = codeEl.getAttribute("name");
								if (nameAttr != null)
									name = nameAttr.getValue();
								content = codeEl.getValue();
							}
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				BaseIOElement codeEl = io.newElement("resource").setValue(content);
				codeEl.setAttribute("name", name);
				codeEl.setAttribute("resource_type", resourceType.name());
				element.addChild(codeEl);
				return element;
			}
		
		public String getName()
			{
				return name;
			}
		
		public String getFileName()
			{
				if (resourceType.defaultExtension.length() > 0)
					return name + "." + resourceType.defaultExtension;
				else
					return name;
			}
		
		public void setName(String name)
			{
				if (((name == null) && (this.name != null)) || (!name.equals(this.name)))
					{
						beforeUpdate(true, ActionTypes.RES_NAME_AID);
						this.name = name;
					}
			}
		
		public String getContent()
			{
				return content;
			}
		
		public void setContent(String content)
			{
				if (((content == null) && (this.content != null)) || (!content.equals(this.content)))
					{
						beforeUpdate(true, ActionTypes.RES_CONTENT_AID);
						this.content = content;
					}
			}
		
		public ResourceType getResourceType()
			{
				return resourceType;
			}
		
		public void setResourceType(ResourceType resourceType)
			{
				if (((resourceType == null) && (this.resourceType != null)) || (!resourceType.equals(this.resourceType)))
					{
						beforeUpdate(true, ActionTypes.RES_TYPE_AID);
						this.resourceType = resourceType;
					}
			}
		
		public String toString()
			{
				return getFileName();
			}
		
		protected String							name;
		protected String							content;
		protected ResourceType	resourceType	= ResourceType.JAVA_SOURCE_CODE;
	}

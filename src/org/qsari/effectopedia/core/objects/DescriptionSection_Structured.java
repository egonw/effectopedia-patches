package org.qsari.effectopedia.core.objects;

import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultObjectIOFactory;
import org.qsari.effectopedia.defaults.DefaultObjectIOFactory.DefaultObjectIO;

public class DescriptionSection_Structured extends DescriptionSection
	{
		public DescriptionSection_Structured()
			{
				super();
				this.structuredContent = null;
				this.structuredContentClass = null;
			}
		
		public DescriptionSection_Structured(EffectopediaObject parent, DataSource dataSource, String title, String content, Object structuredContent)
			{
				super(parent, dataSource, title, content);
				this.structuredContent = structuredContent;
				if (structuredContent != null)
					this.structuredContentClass = structuredContent.getClass();
			}
		
		@Override
				public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if (eoDestintation instanceof DescriptionSection_Structured)
					{
						((DescriptionSection_Structured) eoDestintation).structuredContentClass = this.structuredContentClass;
						if (this.structuredContent instanceof EffectopediaObject)
							{
								if (assignContainedEO)
									((EffectopediaObject) this.structuredContent).assignFieldsTo((EffectopediaObject) ((DescriptionSection_Structured) eoDestintation).getStructuredContent(),assignContainedEO);
							}
						else
							{
								DefaultObjectIO oio = DefaultObjectIOFactory.FACTORY.getDefaultIO(structuredContentClass);
								((DescriptionSection_Structured) eoDestintation).structuredContent = oio.cloneObject(this.structuredContentClass, this.structuredContent, eoDestintation, dataSource);
							}
					}
			}
		
		public void cloneFieldsTo(DescriptionSection_Structured clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.structuredContentClass = this.structuredContentClass;
				DefaultObjectIO oio = DefaultObjectIOFactory.FACTORY.getDefaultIO(structuredContentClass);
				clone.structuredContent = oio.cloneObject(this.structuredContentClass, this.structuredContent, clone, dataSource);
			}
		
		public DescriptionSection_Structured clone()
			{
				DescriptionSection_Structured clone = new DescriptionSection_Structured(parent, dataSource, null, null, null);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public DescriptionSection_Structured clone(EffectopediaObject parent, DataSource dataSource)
			{
				DescriptionSection_Structured clone = new DescriptionSection_Structured(parent, dataSource, null, null, null);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		@Override
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				if (structuredContent instanceof EffectopediaObject)
					((EffectopediaObject) structuredContent).getContainedIDs(containedIDs, includeOwned);
			}
		
		@Override
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				if (structuredContent instanceof EffectopediaObject)
					((EffectopediaObject) structuredContent).getContainedExternalIDs(containedIDs);
			}
		
		@Override
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				if (structuredContent instanceof EffectopediaObject)
					((EffectopediaObject) structuredContent).replaceDefaultObjectsWtihClones();
			}
		
		@Override
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (structuredContent instanceof EffectopediaObject)
					((EffectopediaObject) structuredContent).process(batch);
			}
		
		@Override
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				if (structuredContent instanceof EffectopediaObject)
					((EffectopediaObject) structuredContent).reloadReferredObjectsFromID();
			}
		
		public Object getStructuredContent()
			{
				return structuredContent;
			}
		
		public void setStructuredContent(Object structuredContent)
			{
				this.structuredContent = structuredContent;
			}
		
		public Class<?> getStructuredContentClass()
			{
				return structuredContentClass;
			}
		
		public void setStructuredContentClass(Class<?> structuredContentClass)
			{
				this.structuredContentClass = structuredContentClass;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						BaseIOElement contentElement = element.getChild("structured_content");
						if (contentElement != null)
							try
								{
									structuredContentClass = Class.forName(contentElement.getChild("conent_class").getValue());
									DefaultObjectIO oio = DefaultObjectIOFactory.FACTORY.getDefaultIO(structuredContentClass);
									if (oio != null)
										structuredContent = oio.load(structuredContentClass, structuredContent, contentElement.getChild("conent_object"), io);
								}
							catch (ClassNotFoundException e)
								{
									e.printStackTrace();
								}
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				BaseIOElement contentElement = io.newElement("structured_content");
				contentElement.addValueElement(io.newValue("conent_class").setValue(structuredContentClass.getName()));
				DefaultObjectIO oio = DefaultObjectIOFactory.FACTORY.getDefaultIO(structuredContentClass);
				if (oio != null)
					contentElement.addChild(oio.store(structuredContent, io.newElement("conent_object"), io));
				element.addChild(contentElement);
				return element;
			}
		
		protected Object			structuredContent;
		protected Class<?>	structuredContentClass;
		
	}

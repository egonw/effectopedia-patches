package org.qsari.effectopedia.data.quantification;

import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObject.BatchProcessor;
import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.objects.Method_InSilicoGlobalModel;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.Resource;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public abstract class FunctionalRelationship implements Importable, Exportable, Titleable
	{
		public static enum EvidenceType
			{
				UNDEFINED(0, "Undefined"), EXPERIMENTAL_DATA(1, "Experimental data"), IN_SILICO_MODEL(2, "In-silico model");
				
				EvidenceType(int code, String caption)
					{
						this.code = code;
						this.caption = caption;
					}
				
				public String toString()
					{
						return caption;
					}
				
				public int getCode()
					{
						return code;
					}
				
				private final int				code;
				private final String	caption;
			}
		
		public FunctionalRelationship()
			{
				this.owner = null;
			}
		
		public FunctionalRelationship(EffectopediaObject owner)
			{
				this.owner = owner;
			}
		
		public void cloneFieldsTo(FunctionalRelationship clone, DataSource dataSource)
			{
				if (this.supportEvidenceIDs != null)
					clone.supportEvidenceIDs = this.supportEvidenceIDs.clone(clone.owner, dataSource);
				clone.templates = this.templates.clone();
				clone.properties = this.properties.clone(owner, dataSource);
				clone.evidenceType = this.evidenceType;
			}
		
		public FunctionalRelationship clone(EffectopediaObject owner, DataSource dataSource)
			{
				FunctionalRelationship clone = null;
				try
					{
						clone = this.getClass().newInstance();
						clone.setOwner(EffectopediaObject.addID_OffsetIfNeeded(owner, dataSource));
						cloneFieldsTo(clone, dataSource);
					}
				catch (InstantiationException e)
					{
						e.printStackTrace();
					}
				catch (IllegalAccessException e)
					{
						e.printStackTrace();
					}
				return clone;
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				if (supportEvidenceIDs != null)
					containedIDs.put(supportEvidenceIDs.getID(), supportEvidenceIDs);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				if (supportEvidenceIDs != null)
					containedIDs.put(supportEvidenceIDs.getExternalID(), supportEvidenceIDs);
			}
		
		public void replaceDefaultObjectsWtihClones()
			{
				if (supportEvidenceIDs != null)
					supportEvidenceIDs = EffectopediaObject.cloneIfInDefaultObjects(supportEvidenceIDs, owner, owner.getDataSource());
			}
		
		public void process(BatchProcessor batch)
			{
				if (supportEvidenceIDs != null)
					supportEvidenceIDs.process(batch);
			}
		
		public void updateParenthood()
			{
				if (supportEvidenceIDs != null)
					supportEvidenceIDs = EffectopediaObject.updateParent(supportEvidenceIDs, owner);
			}
		
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				if (supportEvidenceIDs != null)
					{
						supportEvidenceIDs = owner.getDataSource().get(supportEvidenceIDs.getClass(), supportEvidenceIDs.getID());
						supportEvidenceIDs.reloadReferredObjectsFromID();
					}
			}
		
		public ObjectProperties getProperties()
			{
				return properties;
			}
		
		public void setProperties(ObjectProperties properties)
			{
				this.properties = properties;
			}
		
		public DataTemplates getTemplates()
			{
				return templates;
			}
		
		public void setTemplates(DataTemplates templates)
			{
				this.templates = templates;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						properties.load(element.getChild("relatiosnhip_properties"), io);
						properties.setOwner(owner);
						templates.load(element.getChild("data_templates"), io);
						BaseIOElement supportEvidences = element.getChild("support_evidences");
						if (supportEvidences != null)
							{
								BaseIOAttribute evidenceType = element.getAttribute("evidence_type");
								if (evidenceType != null)
									this.evidenceType = EvidenceType.valueOf(evidenceType.getValue());
								this.supportEvidenceIDs = DefaultEffectopediaObjects.DEFAULT_FN_REL_SUPPORT_EVIDENCE_IDS.clone(owner, owner.getDataSource());
								supportEvidenceIDs.load(supportEvidences, io);
							}
						BaseIOElement trType = element.getChild("transformation_type");
						if (trType != null)
							this.transformationType = TransformationFunctionType.valueOf(trType.getValue());
						else
							this.transformationType = TransformationFunctionType.NONE;
						templates.setProperties(properties);
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				if (properties != null)
					properties.updateExternalID(element.getChild("relatiosnhip_properties"));
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				if (properties != null)
					element.addChild(properties.store(io.newElement("relatiosnhip_properties"), io));
				if (templates != null)
					element.addChild(templates.store(io.newElement("data_templates"), io));
				if (!evidenceType.equals(EvidenceType.UNDEFINED))
					{
						BaseIOElement supportEvidences = io.newElement("support_evidences");
						supportEvidences.setAttribute("evidence_type", evidenceType.name());
						if (supportEvidenceIDs != null)
							supportEvidenceIDs.store(supportEvidences, io);
						element.addChild(supportEvidences);
					}
				if (!transformationType.equals(TransformationFunctionType.NONE))
					element.addChild(io.newElement("transformation_type").setValue(transformationType.name()));
				return element;
			}
		
		public EffectopediaObject getOwner()
			{
				return owner;
			}
		
		public void setOwner(EffectopediaObject owner)
			{
				this.owner = owner;
				if (properties != null)
					properties.setOwner(owner);
				if (templates != null)
					templates.setOwner(owner);
			}
		
		protected double NullToNaN(Double value)
			{
				if (value == null)
					return Double.NaN;
				else
					return value.doubleValue();
				
			}
		
		public String getTitle()
			{
				if (templates != null)
					return templates.chartTitle;
				else
					return null;
			}
		
		public void setTitle(String title)
			{
				if (templates != null)
					templates.chartTitle = title;
			}
		
		public EvidenceType getEvidenceType()
			{
				return evidenceType;
			}
		
		public void setEvidenceType(EvidenceType evidenceType)
			{
				this.evidenceType = evidenceType;
			}
		
		public ReferenceIDs<EffectopediaObject> getSupportEvidenceIDs()
			{
				if (supportEvidenceIDs == null)
					this.supportEvidenceIDs = DefaultEffectopediaObjects.DEFAULT_FN_REL_SUPPORT_EVIDENCE_IDS.clone(owner, owner.getDataSource());
				return supportEvidenceIDs;
			}
		
		public TransformationFunctionType getTransformationType()
			{
				return transformationType;
			}
		
		public void setTransformationType(TransformationFunctionType transformationType)
			{
				this.transformationType = transformationType;
			}
		
		public Method_InSilicoGlobalModel getModel()
			{
				if ((evidenceType == EvidenceType.IN_SILICO_MODEL) && (supportEvidenceIDs != null))
					return (Method_InSilicoGlobalModel) supportEvidenceIDs.getCachedObject(DefaultEffectopediaObjects.DEFAULT_GM_EVIDENCE_INDEX);
				return null;
			}
		
		public void setModel(Method_InSilicoGlobalModel model)
			{
				if ((evidenceType == EvidenceType.IN_SILICO_MODEL) && (supportEvidenceIDs != null))
					supportEvidenceIDs.set(model, DefaultEffectopediaObjects.DEFAULT_GM_EVIDENCE_INDEX);
			}

		public Resource getModelMethod()
			{
				if ((evidenceType == EvidenceType.IN_SILICO_MODEL) && (supportEvidenceIDs != null))
					return (Resource) supportEvidenceIDs.getCachedObject(DefaultEffectopediaObjects.DEFAULT_GM_METHOD_INDEX);
				return null;
			}

		public void setModelMethod(Resource resource)
			{
				if ((evidenceType == EvidenceType.IN_SILICO_MODEL) && (supportEvidenceIDs != null))
					supportEvidenceIDs.set(resource, DefaultEffectopediaObjects.DEFAULT_GM_METHOD_INDEX);
			}

		public abstract DataSeries rebuildSeries();
		
		public abstract ModifiableTableModel generateTableModel();
		
		protected EffectopediaObject															owner;
		protected ReferenceIDs<EffectopediaObject>	supportEvidenceIDs;
		protected DataTemplates																				templates;
		protected ObjectProperties																	properties;
		protected EvidenceType																					evidenceType							= EvidenceType.UNDEFINED;
		protected TransformationFunctionType							transformationType	= TransformationFunctionType.NONE;
		
	}

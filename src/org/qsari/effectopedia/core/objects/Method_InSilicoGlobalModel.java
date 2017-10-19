package org.qsari.effectopedia.core.objects;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.ids.IDs;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.core.modelling.ModelExecutor;
import org.qsari.effectopedia.core.modelling.ModelExecutorFactory;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.ModelPresets;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.Resource;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.history.EditHistory;

public class Method_InSilicoGlobalModel extends Method
	{
		public Method_InSilicoGlobalModel()
			{
				super();
				descriptionIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_GLOBALMODEL_IDS);
				modelCallers = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_MODEL_CALLERS_REFIDS);
				resources = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_RECOURCE_IDS);
				this.modelParamaters = DefaultEffectopediaObjects.buildingDefaultObjects ? DefaultEffectopediaObjects.DEFAULT_MODEL_PARAMETERS : DefaultEffectopediaObjects.DEFAULT_MODEL_PARAMETERS.clone(this,
						null);
				this.modelMetadata = DefaultEffectopediaObjects.buildingDefaultObjects ? DefaultEffectopediaObjects.DEFAULT_GM_METADATA_PROP : DefaultEffectopediaObjects.DEFAULT_GM_METADATA_PROP
						.clone(this, null);
			}
		
		public Method_InSilicoGlobalModel(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_GLOBALMODEL_IDS.clone(this, dataSource);
				modelCallers = DefaultEffectopediaObjects.DEFAULT_MODEL_CALLERS_REFIDS.clone(this, dataSource);
				resources = DefaultEffectopediaObjects.DEFAULT_RECOURCE_IDS.clone(this, dataSource);
				this.modelParamaters = DefaultEffectopediaObjects.DEFAULT_MODEL_PARAMETERS.clone(this, dataSource);
				this.modelMetadata = DefaultEffectopediaObjects.DEFAULT_GM_METADATA_PROP.clone(this, dataSource);
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				descriptionIDs.getContainedIDs(containedIDs, includeOwned);
				containedIDs.put(modelCallers.getID(), modelCallers);
				resources.getContainedIDs(containedIDs, includeOwned);
				if (modelParamaters != null)
					modelParamaters.getContainedIDs(containedIDs);
				if (modelMetadata != null)
					modelMetadata.getContainedIDs(containedIDs);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				descriptionIDs.getContainedExternalIDs(containedIDs);
				containedIDs.put(modelCallers.getExternalID(), modelCallers);
				resources.getContainedExternalIDs(containedIDs);
				if (modelParamaters != null)
					modelParamaters.getContainedExternalIDs(containedIDs);
				if (modelMetadata != null)
					modelMetadata.getContainedExternalIDs(containedIDs);
			}
		
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				modelCallers = EffectopediaObject.cloneIfInDefaultObjects(modelCallers, this, dataSource);
				resources = EffectopediaObject.cloneIfInDefaultObjects(resources, this, dataSource);
			}
		
		@Override
		public void replaceArchivedObjectsWtihClones()
			{
				super.replaceArchivedObjectsWtihClones();
				modelCallers = EditHistory.replaceArchivedObjectsWtihClones(modelCallers, this, dataSource);
				resources = EditHistory.replaceArchivedObjectsWtihClones(resources, this, dataSource);
			}
		
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (modelCallers != null)
					modelCallers.process(batch);
				if (resources != null)
					resources.process(batch);
			}
		
		@Override
		public void init(boolean asDefaultObject)
			{
				metadata = new ObjectProperties(this, DefaultEffectopediaObjects.DEFAULT_DOC_KNOWLEDGE_METADATA);
				if (modelCallers == null)
					modelCallers = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_MODEL_CALLERS_REFIDS);
				if (resources == null)
					resources = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_JAVA_RECOURCE_IDS);
				modelMetadata = asDefaultObject ? DefaultEffectopediaObjects.DEFAULT_GM_METADATA_PROP : DefaultEffectopediaObjects.DEFAULT_GM_METADATA_PROP.clone(this, dataSource);
				updateParenthood();
			}
		
		public void updateParenthood()
			{
				super.updateParenthood();
			}
		
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				modelCallers = dataSource.get(modelCallers.getClass(), modelCallers.getID());
				resources = dataSource.get(resources.getClass(), resources.getID());
			}
		
		@Override
		public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if (eoDestintation instanceof Method_InSilicoGlobalModel)
					{
						if (assignContainedEO)
							{
								this.modelCallers.assignFieldsTo(((Method_InSilicoGlobalModel) eoDestintation).getModelCallers(), assignContainedEO);
								this.resources.assignFieldsTo(((Method_InSilicoGlobalModel) eoDestintation).getResources(), assignContainedEO);
							}
						if (this.modelParamaters != null)
							((Method_InSilicoGlobalModel) eoDestintation).modelParamaters = this.modelParamaters.clone(eoDestintation, dataSource);
						else
							((Method_InSilicoGlobalModel) eoDestintation).modelParamaters = null;
						if (this.modelMetadata != null)
							((Method_InSilicoGlobalModel) eoDestintation).modelMetadata = this.modelMetadata.clone(eoDestintation, dataSource);
						else
							((Method_InSilicoGlobalModel) eoDestintation).modelMetadata = null;
						if (this.modelPersets != null)
							((Method_InSilicoGlobalModel) eoDestintation).modelPersets = this.modelPersets.clone();
						else
							((Method_InSilicoGlobalModel) eoDestintation).modelPersets = null;
					}
			}
		
		public void cloneFieldsTo(Method_InSilicoGlobalModel clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.modelCallers = this.modelCallers.clone(clone, dataSource);
				clone.resources = this.resources.clone(clone, dataSource);
				if (this.modelParamaters != null)
					clone.modelParamaters = this.modelParamaters.clone(clone, dataSource);
				else
					clone.modelParamaters = null;
				if (this.modelMetadata != null)
					clone.modelMetadata = this.modelMetadata.clone(clone, dataSource);
				else
					clone.modelMetadata = null;
				if (this.modelPersets != null)
					clone.modelPersets = this.modelPersets.clone();
				else
					clone.modelPersets = null;
			}
		
		public Method_InSilicoGlobalModel clone()
			{
				Method_InSilicoGlobalModel clone = new Method_InSilicoGlobalModel(null, dataSource);
				cloneFieldsTo(clone, dataSource);
				clone.setParent(parent);
				return clone;
			}
		
		public Method_InSilicoGlobalModel clone(EffectopediaObject parent, DataSource dataSource)
			{
				Method_InSilicoGlobalModel clone = new Method_InSilicoGlobalModel(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						modelCallers = io.load(ReferenceIDs.class, modelCallers, element.getChild("related_test_ids"));
						resources = io.load(IDs.class, resources, element.getChild("resources"));
						if (modelParamaters != null)
							modelParamaters.load(element.getChild("model_parameters"), io);
						if (modelMetadata != null)
							modelMetadata.load(element.getChild("model_metadata"), io);
						BaseIOElement presets = element.getChild("model_persets");
						if (presets != null)
							{
								if (modelPersets == null)
									modelPersets = new ModelPresets(this);
								modelPersets.load(presets, io);
							}
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
				modelCallers.updateExternalID(element.getChild("related_test_ids"));
				resources.updateExternalID(element.getChild("resources"));
				if (modelParamaters != null)
					modelParamaters.updateExternalID(element.getChild("model_parameters"));
				if (modelMetadata != null)
					modelMetadata.updateExternalID(element.getChild("model_metadata"));
				if (modelPersets != null)
					modelPersets.updateExternalID(element.getChild("model_persets"));
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addChild(modelCallers.store(io.newElement("related_test_ids"), io));
				if (modelMetadata != null)
					element.addChild(modelMetadata.store(io.newElement("model_metadata"), io));
				if (modelParamaters != null)
					element.addChild(modelParamaters.store(io.newElement("model_parameters"), io));
				element.addChild(resources.store(io.newElement("resources"), io));
				if (modelPersets != null)
					element.addChild(modelPersets.store(io.newElement("model_persets"), io));
				return element;
			}
		
		public ReferenceIDs<EffectopediaObject> getModelCallers()
			{
				return modelCallers;
			}
		
		public void setModelCallers(ReferenceIDs<EffectopediaObject> modelCallers)
			{
				this.modelCallers = modelCallers;
			}
		
		public final ObjectProperties getModelParamaters()
			{
				return modelParamaters;
			}
		
		public final void setModelParamaters(ObjectProperties modelParamaters)
			{
				this.modelParamaters = modelParamaters;
			}
		
		public ObjectProperties getModelMetadata()
			{
				return modelMetadata;
			}
		
		public void setModelMetadata(ObjectProperties modelMetadata)
			{
				this.modelMetadata = modelMetadata;
			}
		
		public IDs<Resource> getResources()
			{
				return resources;
			}
		
		public void setResources(IDs<Resource> resources)
			{
				this.resources = resources;
			}
		
		public Resource[] getExecutableResources(boolean includeInitMethod)
			{
				ArrayList<Resource> executable = new ArrayList<Resource>();
				for (Resource r : resources.getCachedObjects())
					if (r.getResourceType().isExecutable())
						if (includeInitMethod)
							executable.add(r);
						else if (!r.getName().equals("init"))
							executable.add(r);
				Resource[] exe = new Resource[executable.size()];
				return executable.toArray(exe);
			}
		
		public ModelExecutor getModelExecutor()
			{
				if (modelExecutor == null)
					updateModelExecutor();
				return modelExecutor;
			}
		
		public void updateModelExecutor()
			{
				if ((referenceIDs != null) && (resources.size() > 0))
					modelExecutor = ModelExecutorFactory.getExecutor(resources.getCachedObject(0).getResourceType());
			}
		
		public void setModelExecutor(ModelExecutor modelExecutor)
			{
				this.modelExecutor = modelExecutor;
			}
		
		public ModelPresets getModelPersets()
			{
				if (modelPersets == null)
					modelPersets = new ModelPresets(this);
				return modelPersets;
			}
		
		public void setModelPersets(ModelPresets modelPersets)
			{
				this.modelPersets = modelPersets;
			}
		
		public boolean hasDefaultPreset(boolean withCalculatedStatus)
			{
				if (withCalculatedStatus)
					return (modelPersets != null) && (modelPersets.size() > 0) && (modelPersets.getDefault().isCalculated());
				else
					return (modelPersets != null) && (modelPersets.size() > 0);
			}
		
		public boolean hasPreset(boolean withCalculatedStatus)
			{
				return (modelPersets != null) && (modelPersets.hasPresets(withCalculatedStatus));
			}
		
		public boolean compatibleWith(Class<? extends EffectopediaObject> eoClass)
			{
				if (modelCallers.size() == 0)
					return true;
				else
					return eoClass.isAssignableFrom(modelCallers.getCachedObject(0).getClass());
			}
		
		protected ModelExecutor																				modelExecutor;
		protected ObjectProperties																	modelMetadata;
		protected ObjectProperties																	modelParamaters;
		protected IDs<Resource>																				resources;
		protected ModelPresets																					modelPersets;
		protected ReferenceIDs<EffectopediaObject>	modelCallers;
	}

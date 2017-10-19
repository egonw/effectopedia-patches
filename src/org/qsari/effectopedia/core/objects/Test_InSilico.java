package org.qsari.effectopedia.core.objects;

import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.core.object.elemets.Coordinates;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public class Test_InSilico extends Test
	{
		public Test_InSilico()
			{
				super();
				descriptionIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_IN_SILICO_TEST_IDS);
				globalModelIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_GLOBAL_MODEL_RIDS);
				relatedEffectMappingIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_TEST_RESP_MAPPING_REFIDS);
				relatedTestIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REL_TEST_IDS);
				testType = TestType.IN_SILICO;
			}
		
		public Test_InSilico(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_IN_SILICO_TEST_IDS.clone(this, dataSource);
				globalModelIDs = DefaultEffectopediaObjects.DEFAULT_GLOBAL_MODEL_RIDS.clone(this, dataSource);
				relatedEffectMappingIDs = DefaultEffectopediaObjects.DEFAULT_TEST_RESP_MAPPING_REFIDS.clone(this, dataSource);
				relatedTestIDs = DefaultEffectopediaObjects.DEFAULT_REL_TEST_IDS.clone(this, dataSource);
				testType = TestType.IN_SILICO;
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				if (globalModelIDs != null)
					globalModelIDs.getContainedIDs(containedIDs, includeOwned);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				if (globalModelIDs != null)
					globalModelIDs.getContainedExternalIDs(containedIDs);
			}
		
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				if (globalModelIDs != null)
					globalModelIDs.replaceDefaultObjectsWtihClones();
			}
		
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (globalModelIDs != null)
					globalModelIDs.process(batch);
			}
		
		public void updateParenthood()
			{
				super.updateParenthood();
				if (globalModelIDs != null)
					globalModelIDs = EffectopediaObject.updateParent(globalModelIDs, this);
			}
		
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				if (globalModelIDs != null)
					globalModelIDs = dataSource.get(globalModelIDs.getClass(), globalModelIDs.getID());
			}
		
		@Override
		public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if ((eoDestintation instanceof Test_InSilico) && assignContainedEO)
					this.globalModelIDs.assignFieldsTo(((Test_InSilico) eoDestintation).getGlobalModelIDs(), assignContainedEO);
			}
		
		public void cloneFieldsTo(Test_InSilico clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.globalModelIDs = this.globalModelIDs.clone(clone, dataSource);
			}
		
		public Test_InSilico clone()
			{
				Test_InSilico clone = new Test_InSilico(null, dataSource);
				cloneFieldsTo(clone, dataSource);
				clone.setParent(parent);
				return clone;
			}
		
		public Test_InSilico clone(EffectopediaObject parent, DataSource dataSource)
			{
				Test_InSilico clone = new Test_InSilico(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						globalModelIDs = io.load(ReferenceIDs.class, globalModelIDs, element.getChild("global_models_ids"));
						
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addChild(globalModelIDs.store(io.newElement("global_models_ids"), io));
				return element;
			}
		
		@Override
		public void init(boolean asDefaultObject)
			{
				this.metadata = new ObjectProperties(this, DefaultEffectopediaObjects.DEFAULT_DOC_KNOWLEDGE_METADATA);
				coordinates = new Coordinates(this, DefaultEffectopediaObjects.DEFAULT_CONTEXT.getDimensions());
				if (asDefaultObject)
					globalModelIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_GLOBAL_MODEL_RIDS);
				else
					globalModelIDs = DefaultEffectopediaObjects.DEFAULT_GLOBAL_MODEL_RIDS.clone(this, dataSource);
				updateParenthood();
			}
		
		public ReferenceIDs<Method_InSilicoGlobalModel> getGlobalModelIDs()
			{
				return globalModelIDs;
			}
		
		public void setGlobalModelIDs(ReferenceIDs<Method_InSilicoGlobalModel> globalModelIDs)
			{
				this.globalModelIDs = globalModelIDs;
			}
		
		protected ReferenceIDs<Method_InSilicoGlobalModel>	globalModelIDs;
	}

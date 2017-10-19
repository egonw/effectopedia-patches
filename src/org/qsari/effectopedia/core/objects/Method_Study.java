package org.qsari.effectopedia.core.objects;

import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.history.EditHistory;

public class Method_Study extends Method
	{
		public Method_Study()
			{
				super();
				descriptionIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_STUDY_IDS);
				relatedTests = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REL_TEST_REFIDS);
			}
		
		public Method_Study(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_STUDY_IDS.clone(this, dataSource);
				relatedTests = DefaultEffectopediaObjects.DEFAULT_REL_TEST_REFIDS.clone(this, dataSource);
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				descriptionIDs.getContainedIDs(containedIDs, includeOwned);
				containedIDs.put(relatedTests.getID(), relatedTests);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				descriptionIDs.getContainedExternalIDs(containedIDs);
				containedIDs.put(relatedTests.getExternalID(), relatedTests);
			}
		
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				relatedTests = EffectopediaObject.cloneIfInDefaultObjects(relatedTests, this, dataSource);
			}
		
		@Override
		public void replaceArchivedObjectsWtihClones()
			{
				super.replaceArchivedObjectsWtihClones();
				relatedTests = EditHistory.replaceArchivedObjectsWtihClones(relatedTests, this, dataSource);
			}
		
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (relatedTests != null)
					relatedTests.process(batch);
			}
		
		public void updateParenthood()
			{
				super.updateParenthood();
				if (relatedTests == null)
					relatedTests = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REL_TEST_REFIDS);
			}
		
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				relatedTests = dataSource.get(relatedTests.getClass(), relatedTests.getID());
			}
		
		
		@Override
				public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if ((eoDestintation instanceof Method_Study)&&assignContainedEO)
					this.relatedTests.assignFieldsTo(((Method_Study) eoDestintation).getRelatedTests(),assignContainedEO);
			}
		

		public void cloneFieldsTo(Method_Study clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.relatedTests = this.relatedTests.clone(clone, dataSource);
			}
		
		public Method_Study clone()
			{
				Method_Study clone = new Method_Study(null, dataSource);
				cloneFieldsTo(clone, dataSource);
				clone.setParent(parent);
				return clone;
			}
		
		public Method_Study clone(EffectopediaObject parent, DataSource dataSource)
			{
				Method_Study clone = new Method_Study(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						relatedTests = io.load(ReferenceIDs.class, relatedTests, element.getChild("related_test_ids"));
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
				relatedTests.updateExternalID(element.getChild("related_test_ids"));
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addChild(relatedTests.store(io.newElement("related_test_ids"), io));
				return element;
			}
		
		public ReferenceIDs<Test> getRelatedTests()
			{
				return relatedTests;
			}
		
		public void setRelatedTests(ReferenceIDs<Test> relatedStudies)
			{
				this.relatedTests = relatedStudies;
			}
		
		protected ReferenceIDs<Test>	relatedTests;
		
	}

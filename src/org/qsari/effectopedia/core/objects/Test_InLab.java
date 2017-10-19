package org.qsari.effectopedia.core.objects;

import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.ids.IDs;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public class Test_InLab extends Test
	{
		public Test_InLab()
			{
				super();
				descriptionIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_TEST_IDS);
				investigationIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_INVESTIGATION_RIDS);
				studyIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_STUDY_RIDS);
				labIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_LAB_IDS);
				relatedEffectMappingIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_TEST_RESP_MAPPING_REFIDS);
				relatedTestIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REL_TEST_IDS);
			}
		
		public Test_InLab(TestType testType)
			{
				super();
				descriptionIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_TEST_IDS);
				investigationIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_INVESTIGATION_RIDS);
				studyIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_STUDY_RIDS);
				labIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_LAB_IDS);
				relatedEffectMappingIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_TEST_RESP_MAPPING_REFIDS);
				relatedTestIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REL_TEST_IDS);
				this.testType = testType;
			}
		
		public Test_InLab(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_TEST_IDS.clone(this, dataSource);
				labIDs = DefaultEffectopediaObjects.DEFAULT_LAB_IDS.clone(this, dataSource);
				investigationIDs = DefaultEffectopediaObjects.DEFAULT_INVESTIGATION_RIDS.clone(this, dataSource);
				studyIDs = DefaultEffectopediaObjects.DEFAULT_STUDY_RIDS.clone(this, dataSource);
				relatedEffectMappingIDs = DefaultEffectopediaObjects.DEFAULT_TEST_RESP_MAPPING_REFIDS.clone(this, dataSource);
				relatedTestIDs = DefaultEffectopediaObjects.DEFAULT_REL_TEST_IDS.clone(this, dataSource);
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				containedIDs.put(labIDs.getID(), labIDs);
				containedIDs.put(studyIDs.getID(), studyIDs);
				containedIDs.put(investigationIDs.getID(), investigationIDs);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				containedIDs.put(labIDs.getExternalID(), labIDs);
				containedIDs.put(studyIDs.getExternalID(), studyIDs);
				containedIDs.put(investigationIDs.getExternalID(), investigationIDs);
			}
		
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				labIDs = EffectopediaObject.cloneIfInDefaultObjects(labIDs, this, dataSource);
				studyIDs = EffectopediaObject.cloneIfInDefaultObjects(studyIDs, this, dataSource);
				investigationIDs = EffectopediaObject.cloneIfInDefaultObjects(investigationIDs, this, dataSource);
			}
		
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (labIDs != null)
					labIDs.process(batch);
				if (studyIDs != null)
					studyIDs.process(batch);
				if (investigationIDs != null)
					investigationIDs.process(batch);
			}
		
		public void updateParenthood()
			{
				super.updateParenthood();
				labIDs = EffectopediaObject.updateParent(labIDs, this);
				studyIDs = EffectopediaObject.updateParent(studyIDs, this);
				investigationIDs = EffectopediaObject.updateParent(investigationIDs, this);
			}
		
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				labIDs = dataSource.get(labIDs.getClass(), labIDs.getID());
				studyIDs = dataSource.get(studyIDs.getClass(), studyIDs.getID());
				investigationIDs = dataSource.get(investigationIDs.getClass(), investigationIDs.getID());
			}
		
		public IDs<Lab> getLabIDs()
			{
				return labIDs;
			}
		
		@Override
		public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if ((eoDestintation instanceof Test_InLab) && assignContainedEO)
					{
						this.labIDs.assignFieldsTo(((Test_InLab) eoDestintation).getLabIDs(), assignContainedEO);
						this.studyIDs.assignFieldsTo(((Test_InLab) eoDestintation).getStudyIDs(), assignContainedEO);
						this.investigationIDs.assignFieldsTo(((Test_InLab) eoDestintation).getInvestigationIDs(), assignContainedEO);
					}
			}
		
		public void cloneFieldsTo(Test_InLab clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.labIDs = this.labIDs.clone(clone, dataSource);
				clone.studyIDs = this.studyIDs.clone(clone, dataSource);
				clone.investigationIDs = this.investigationIDs.clone(clone, dataSource);
			}
		
		public Test_InLab clone()
			{
				Test_InLab clone = new Test_InLab(null, dataSource);
				cloneFieldsTo(clone, dataSource);
				clone.setParent(parent);
				return clone;
			}
		
		public Test_InLab clone(EffectopediaObject parent, DataSource dataSource)
			{
				Test_InLab clone = new Test_InLab(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						labIDs = io.load(IDs.class, labIDs, element.getChild("lab_ids"));
						investigationIDs = io.load(ReferenceIDs.class, investigationIDs, element.getChild("investigation_ids"));
						studyIDs = io.load(ReferenceIDs.class, studyIDs, element.getChild("study_ids"));
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
				labIDs.updateExternalID(element.getChild("lab_ids"));
				investigationIDs.updateExternalID(element.getChild("investigation_ids"));
				studyIDs.updateExternalID(element.getChild("study_ids"));
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addChild(labIDs.store(io.newElement("lab_ids"), io));
				element.addChild(investigationIDs.store(io.newElement("investigation_ids"), io));
				element.addChild(studyIDs.store(io.newElement("study_ids"), io));
				return element;
			}
		
		public void InitDefaultInLabTestReferences()
			{
				investigationIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_INVESTIGATION_RIDS);
				studyIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_STUDY_RIDS);
			}
		
		public ReferenceIDs<Method_Investigation> getInvestigationIDs()
			{
				return investigationIDs;
			}
		
		public ReferenceIDs<Method_Study> getStudyIDs()
			{
				return studyIDs;
			}
		
		protected IDs<Lab>																											labIDs;
		protected ReferenceIDs<Method_Investigation>	investigationIDs;
		protected ReferenceIDs<Method_Study>									studyIDs;
	}

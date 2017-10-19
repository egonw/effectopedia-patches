package org.qsari.effectopedia.core.objects;

import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.ids.IDs;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.history.EditHistory;

public class Test extends DocumentedKnowledge_Located implements Importable, Exportable, Cloneable, Traceable
	{
		public enum TestType
			{
				IN_CHEMICO("In-chemico"), IN_VITRO("In-vitro"), EX_VIVO("Ex-vivo"), IN_VIVO("In-vivo"), IN_SILICO("In-silico"), UNDEFINED("Undefined");
				
				private TestType(String caption)
					{
						this.caption = caption;
					}
				
				public static TestType getTypeByCaption(String caption)
					{
						switch (Character.toLowerCase(caption.charAt(5)))
							{
								case 'e':
									return IN_CHEMICO;
								case 't':
									return IN_VITRO;
								case 'v':
									if (Character.toLowerCase(caption.charAt(1)) == 'i')
										return IN_VIVO;
									else
										return EX_VIVO;
								case 'l':
									return IN_SILICO;
								default:
									return UNDEFINED;
							}
					}
				
				public final String	caption;
			};
		
		public Test()
			{
				super();
				descriptionIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_TEST_IDS);
				relatedEffectMappingIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_TEST_RESP_MAPPING_REFIDS);
				relatedTestIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REL_TEST_IDS);
				substanceDataIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_SUBST_DATA_RIDS);
			}
		
		public Test(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_TEST_IDS.clone(this, dataSource);
				relatedEffectMappingIDs = DefaultEffectopediaObjects.DEFAULT_TEST_RESP_MAPPING_REFIDS.clone(this, dataSource);
				relatedTestIDs = DefaultEffectopediaObjects.DEFAULT_REL_TEST_IDS.clone(this, dataSource);
				substanceDataIDs = DefaultEffectopediaObjects.DEFAULT_SUBST_DATA_RIDS.clone(this, dataSource);
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				descriptionIDs.getContainedIDs(containedIDs, includeOwned);
				containedIDs.put(relatedEffectMappingIDs.getID(), relatedEffectMappingIDs);
				containedIDs.put(relatedTestIDs.getID(), relatedTestIDs);
				substanceDataIDs.getContainedIDs(containedIDs, includeOwned);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				descriptionIDs.getContainedExternalIDs(containedIDs);
				containedIDs.put(relatedEffectMappingIDs.getExternalID(), relatedEffectMappingIDs);
				containedIDs.put(relatedTestIDs.getExternalID(), relatedTestIDs);
				substanceDataIDs.getContainedExternalIDs(containedIDs);
			}
		
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				relatedEffectMappingIDs = EffectopediaObject.cloneIfInDefaultObjects(relatedEffectMappingIDs, this, dataSource);
				relatedTestIDs = EffectopediaObject.cloneIfInDefaultObjects(relatedTestIDs, this, dataSource);
				substanceDataIDs = EffectopediaObject.cloneIfInDefaultObjects(substanceDataIDs, this, dataSource);
			}
		
		@Override
		public void replaceArchivedObjectsWtihClones()
			{
				super.replaceArchivedObjectsWtihClones();
				relatedEffectMappingIDs = EditHistory.replaceArchivedObjectsWtihClones(relatedEffectMappingIDs, this, dataSource);
				relatedTestIDs = EditHistory.replaceArchivedObjectsWtihClones(relatedTestIDs, this, dataSource);
				substanceDataIDs = EditHistory.replaceArchivedObjectsWtihClones(substanceDataIDs, this, dataSource);
			}
		
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (relatedEffectMappingIDs != null)
					relatedEffectMappingIDs.process(batch);
				if (relatedTestIDs != null)
					relatedTestIDs.process(batch);
				if (substanceDataIDs != null)
					substanceDataIDs.process(batch);
			}
		
		public void updateParenthood()
			{
				super.updateParenthood();
				if (relatedEffectMappingIDs == null)
					relatedEffectMappingIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_TEST_RESP_MAPPING_REFIDS);
				relatedEffectMappingIDs = EffectopediaObject.updateParent(relatedEffectMappingIDs, this);
				relatedTestIDs = EffectopediaObject.updateParent(relatedTestIDs, this);
				if (substanceDataIDs == null)
					substanceDataIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_SUBST_DATA_RIDS);
				substanceDataIDs = EffectopediaObject.updateParent(substanceDataIDs, this);
			}
		
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				relatedEffectMappingIDs = dataSource.get(relatedEffectMappingIDs.getClass(), relatedEffectMappingIDs.getID());
				relatedTestIDs = dataSource.get(relatedTestIDs.getClass(), relatedTestIDs.getID());
				substanceDataIDs = dataSource.get(substanceDataIDs.getClass(), substanceDataIDs.getID());
				substanceDataIDs.reloadReferredObjectsFromID();
			}
		
		public ReferenceIDs<TestResponseMapping> getRelatedEffectMappingIDs()
			{
				return relatedEffectMappingIDs;
			}
		
		public TestResponseMapping getTestResponseMapping(Effect toEffect)
			{
				TestResponseMapping[] trms = relatedEffectMappingIDs.getCachedObjects();
				for (TestResponseMapping trm : trms)
					if (trm.getEffect().getCachedObject() == toEffect)
						return trm;
				return null;
			}
		
		public ReferenceIDs<Test> getRelatedTestIDs()
			{
				return relatedTestIDs;
			}
		
		public IDs<SubstanceData> getSubstanceDataIDs()
			{
				return substanceDataIDs;
			}
		
		public boolean hasIncommingMappings()
			{
				return relatedEffectMappingIDs.size() > 0;
			}
		
		public boolean hasOutgoingMappings()
			{
				return false;
			}
		
		public PathwayElement[] incommingMappings()
			{
				return relatedEffectMappingIDs.getCachedObjects();
			}
		
		public PathwayElement[] outgoingMappings()
			{
				return null;
			}
		
		public void map(PathwayElement element)
			{
				if (element instanceof TestResponseMapping)
					relatedEffectMappingIDs.addIfDifferent((TestResponseMapping) element);
			}
		
		public void ummap(PathwayElement element)
			{
				if (element instanceof TestResponseMapping)
					relatedEffectMappingIDs.remove((TestResponseMapping) element);
			}
		
		public TestType getTestType()
			{
				return testType;
			}
		
		@Override
				public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if (eoDestintation instanceof Test)
					{
						((Test) eoDestintation).testType = this.testType;
						if (assignContainedEO)
							{
								this.relatedEffectMappingIDs.assignFieldsTo(((Test) eoDestintation).getRelatedEffectMappingIDs(),assignContainedEO);
								this.relatedTestIDs.assignFieldsTo(((Test) eoDestintation).getRelatedTestIDs(),assignContainedEO);
								this.substanceDataIDs.assignFieldsTo(((Test) eoDestintation).getSubstanceDataIDs(),assignContainedEO);
							}
					}
			}
		
		public void cloneFieldsTo(Test clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.relatedEffectMappingIDs = this.relatedEffectMappingIDs.clone(clone, dataSource);
				clone.relatedTestIDs = this.relatedTestIDs.clone(clone, dataSource);
				if (substanceDataIDs != null)
					clone.substanceDataIDs = this.substanceDataIDs.clone(clone, dataSource);
				clone.testType = this.testType;
			}
		
		public Test clone()
			{
				Test clone = new Test(null, dataSource);
				cloneFieldsTo(clone, dataSource);
				clone.setParent(parent);
				return clone;
			}
		
		public Test clone(EffectopediaObject parent, DataSource dataSource)
			{
				Test clone = new Test(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						relatedEffectMappingIDs = io.load(ReferenceIDs.class, relatedEffectMappingIDs, element.getChild("related_effect_mapping_ids"));
						relatedTestIDs = io.load(ReferenceIDs.class, relatedTestIDs, element.getChild("related_test_ids"));
						BaseIOElement substantData = element.getChild("related_substance_data_ids");
						if (substantData != null)
							substanceDataIDs = io.load(IDs.class, substanceDataIDs, substantData);
						// System.out.println("###T"+this.DEBUG_getIDs());
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
				relatedEffectMappingIDs.updateExternalID(element.getChild("related_effect_mapping_ids"));
				relatedTestIDs.updateExternalID(element.getChild("related_test_ids"));
				BaseIOElement substanceData = element.getChild("related_substance_data_ids");
				if (substanceData != null)
					substanceDataIDs.updateExternalID(element.getChild("related_substance_data_ids"));
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addChild(relatedEffectMappingIDs.store(io.newElement("related_effect_mapping_ids"), io));
				element.addChild(relatedTestIDs.store(io.newElement("related_test_ids"), io));
				element.addChild(substanceDataIDs.store(io.newElement("related_substance_data_ids"), io));
				return element;
			}
		
		public Test relateWith(Test anotherTest)
			{
				relatedTestIDs.add(anotherTest);
				anotherTest.getRelatedTestIDs().add(this);
				return this;
			}
		
		@Override
		public String DEBUG_getIDs()
			{
				StringBuilder sb = new StringBuilder();
				sb.append(super.DEBUG_getIDs());
				if (substanceDataIDs != null)
					{
						sb.append("\tsubstanceDataIDs\t");
						for (SubstanceData sd : substanceDataIDs.getCachedObjects())
							sb.append(sd.getObjectProperties().DEBUG_getSummary());
					}
				return sb.toString();
			}
		
		public SubstanceData[] getSubstanceData()
			{
				return substanceDataIDs.getCachedObjects();
			}
		
		protected ReferenceIDs<TestResponseMapping>	relatedEffectMappingIDs;
		protected ReferenceIDs<Test>																relatedTestIDs;
		protected IDs<SubstanceData>																substanceDataIDs;
		protected TestType																										testType	= TestType.UNDEFINED;
	}

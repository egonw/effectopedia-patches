package org.qsari.effectopedia.core.objects;

import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.Describable;
import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.ids.IDs;
import org.qsari.effectopedia.base.ids.ReferenceID;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.history.EditHistory;

public class TestResponseMapping extends DocumentedKnowledge implements Importable, Exportable, Cloneable, Traceable, Describable
	{
		public TestResponseMapping()
			{
				super();
				descriptionIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_TRM_IDS);
				descriptionIDs.setParent(this);
				this.test = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REFERENCE_T);
				this.effect = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REFERENCE_E);
				this.transformationSets = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_TRANSFORMATION_SETS);
			}
		
		public TestResponseMapping(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_TRM_IDS.clone(this, dataSource);
				this.test = DefaultEffectopediaObjects.DEFAULT_REFERENCE_T.clone(this, dataSource);
				this.effect = DefaultEffectopediaObjects.DEFAULT_REFERENCE_E.clone(this, dataSource);
				this.transformationSets = DefaultEffectopediaObjects.DEFAULT_TRANSFORMATION_SETS.clone(this, dataSource);
				
			}
		
		public TestResponseMapping(EffectopediaObject parent, DataSource dataSource, Test test, Effect effect)
			{
				super(parent, dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_TRM_IDS.clone(this, dataSource);
				this.test = DefaultEffectopediaObjects.DEFAULT_REFERENCE_T.clone(this, dataSource);
				this.effect = DefaultEffectopediaObjects.DEFAULT_REFERENCE_E.clone(this, dataSource);
				this.transformationSets = DefaultEffectopediaObjects.DEFAULT_TRANSFORMATION_SETS.clone(this, dataSource);
				bringToLive();
				if (effect.isDefaultID())
					effect.bringToLive();
				map(effect);
				effect.map(this);
				if (test.isDefaultID())
					test.bringToLive();
				map(test);
				test.map(this);
			}
		
		@Override
		public void init(boolean asDefaultObject)
			{
				this.metadata = new ObjectProperties(this, DefaultEffectopediaObjects.DEFAULT_DOC_KNOWLEDGE_METADATA);
				this.transformationSets = DefaultEffectopediaObjects.DEFAULT_TRANSFORMATION_SETS.clone(this, dataSource);
				updateParenthood();
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				descriptionIDs.getContainedIDs(containedIDs, includeOwned);
				if (transformationSets != null)
					transformationSets.getContainedIDs(containedIDs, includeOwned);
				containedIDs.put(test.getID(), test);
				containedIDs.put(effect.getID(), effect);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				descriptionIDs.getContainedExternalIDs(containedIDs);
				if (transformationSets != null)
					transformationSets.getContainedExternalIDs(containedIDs);
				containedIDs.put(test.getExternalID(), test);
				containedIDs.put(effect.getExternalID(), effect);
			}
		
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				test = EffectopediaObject.cloneIfInDefaultObjects(test, this, dataSource);
				effect = EffectopediaObject.cloneIfInDefaultObjects(effect, this, dataSource);
				if (transformationSets != null)
					transformationSets = EffectopediaObject.cloneIfInDefaultObjects(transformationSets, this, dataSource);
			}
		
		@Override
		public void replaceArchivedObjectsWtihClones()
			{
				super.replaceArchivedObjectsWtihClones();
				test = EditHistory.replaceArchivedObjectsWtihClones(test, this, dataSource);
				effect = EditHistory.replaceArchivedObjectsWtihClones(effect, this, dataSource);
				if (transformationSets != null)
					transformationSets = EditHistory.replaceArchivedObjectsWtihClones(transformationSets, this, dataSource);
			}
		
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (test != null)
					test.process(batch);
				if (effect != null)
					effect.process(batch);
				if (transformationSets != null)
					transformationSets.process(batch);
			}
		
		public void updateParenthood()
			{
				super.updateParenthood();
				test = EffectopediaObject.updateParent(test, this);
				effect = EffectopediaObject.updateParent(effect, this);
				if (transformationSets != null)
					transformationSets = EffectopediaObject.updateParent(transformationSets, this);
			}
		
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				test = dataSource.get(test.getClass(), test.getID());
				effect = dataSource.get(effect.getClass(), effect.getID());
				if (transformationSets != null)
					transformationSets = dataSource.get(transformationSets.getClass(), transformationSets.getID());
			}
		
		public void map(PathwayElement element)
			{
				if (element instanceof Effect)
					this.effect.set((Effect) element);
				else if (element instanceof Test)
					this.test.set((Test) element);
			}
		
		public void unmap(PathwayElement element)
			{
				if (element == this.effect.getCachedObject())
					this.effect.set(null);
				if (element == this.test.getCachedObject())
					this.test.set(null);
			}
		
		public static void unmap(PathwayElement element1, PathwayElement element2)
			{
				element1.unmap(element2);
				element2.unmap(element1);
			}
		
		public static void map(PathwayElement element1, PathwayElement element2)
			{
				element1.map(element2);
				element2.map(element1);
			}
		
		public ReferenceID<Test> getTest()
			{
				return test;
			}
		
		public ReferenceID<Effect> getEffect()
			{
				return effect;
			}
		
		@Override
		public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if ((eoDestintation instanceof TestResponseMapping) && assignContainedEO)
					{
						if (this.effect != null)
							this.effect.assignFieldsTo(((TestResponseMapping) eoDestintation).getEffect(), assignContainedEO);
						else if (((TestResponseMapping) eoDestintation).getEffect() != null)
							((TestResponseMapping) eoDestintation).getEffect().set(null);
						if (this.test != null)
							this.test.assignFieldsTo(((TestResponseMapping) eoDestintation).getTest(), assignContainedEO);
						else if (((TestResponseMapping) eoDestintation).getTest() != null)
							((TestResponseMapping) eoDestintation).getTest().set(null);
						
					}
			}
		
		public void cloneFieldsTo(TestResponseMapping clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				if (this.effect != null)
					clone.effect = this.effect.clone(clone, dataSource);
				else
					clone.effect = null;
				if (this.test != null)
					clone.test = this.test.clone(clone, dataSource);
				else
					clone.test = null;
				if (this.transformationSets != null)
					clone.transformationSets = this.transformationSets.clone(clone, dataSource);
				else
					clone.transformationSets = null;
			}
		
		public TestResponseMapping clone()
			{
				TestResponseMapping clone = new TestResponseMapping(null, dataSource);
				cloneFieldsTo(clone, dataSource);
				clone.setParent(parent);
				return clone;
			}
		
		public TestResponseMapping clone(EffectopediaObject parent, DataSource dataSource)
			{
				TestResponseMapping clone = new TestResponseMapping(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						test = io.load(ReferenceID.class, test, element.getChild(io.getInputVersion() < 0.95 ? "structure" : "test"));
						effect = io.load(ReferenceID.class, effect, element.getChild("effect"));
						transformationSets = io.load(IDs.class, transformationSets, element.getChild("transformation_sets"));
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
				test.updateExternalID(element.getChild("test"));
				effect.updateExternalID(element.getChild("effect"));
				if (transformationSets != null)
					transformationSets.updateExternalID(element.getChild("transformation_sets"));
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addChild(test.store(io.newElement("test"), io));
				element.addChild(effect.store(io.newElement("effect"), io));
				if (transformationSets != null)
					element.addChild(transformationSets.store(io.newElement("transformation_sets"), io));
				return element;
			}
		
		public boolean hasIncommingMappings()
			{
				return effect.getCachedObject() != null;
			}
		
		public boolean hasOutgoingMappings()
			{
				return test.getCachedObject() != null;
			}
		
		public PathwayElement[] incommingMappings()
			{
				PathwayElement[] result =
					{ effect.getCachedObject() };
				return result;
			}
		
		public PathwayElement[] outgoingMappings()
			{
				PathwayElement[] result =
					{ test.getCachedObject() };
				return result;
			}
		
		public String DEBUG_getIDs()
			{
				StringBuilder sb = new StringBuilder();
				sb.append(super.DEBUG_getIDs());
				sb.append("\tpathway_ids\t");
				sb.append(pathwayIDs.DEBUG_getIDs());
				sb.append("\ttest\t");
				if (test != null)
					sb.append(test.DEBUG_getIDs());
				sb.append("\teffect\t");
				if (effect != null)
					sb.append(effect.DEBUG_getIDs());
				return sb.toString();
			}
		
		@Override
		public String getGenericDescription()
			{
				// TODO Auto-generated method stub
				return null;
			}
		
		public IDs<TransformationSet> getTransformationSets()
			{
				return transformationSets;
			}
		
		public void setTransformationSets(IDs<TransformationSet> transformationSets)
			{
				this.transformationSets = transformationSets;
			}
		
		public boolean hasTransformationSets()
			{
				return (transformationSets != null) && (transformationSets.size() > 0);
			}
		
		protected ReferenceID<Test>						test;
		protected ReferenceID<Effect>				effect;
		protected IDs<TransformationSet>	transformationSets;
		
	}

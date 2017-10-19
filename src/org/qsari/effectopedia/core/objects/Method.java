package org.qsari.effectopedia.core.objects;

import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.history.EditHistory;

public class Method extends DocumentedKnowledge
	{
		
		public Method()
			{
				super();
				descriptionIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_METHOD_IDS);
				relatedEffectIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REL_EFFECT_IDS);
			}
		
		public Method(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_METHOD_IDS.clone(this, dataSource);
				relatedEffectIDs = DefaultEffectopediaObjects.DEFAULT_REL_EFFECT_IDS.clone(this, dataSource);
			}
		
		public Method clone()
			{
				Method clone = new Method(getParent(), dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		@Override
		public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if ((eoDestintation instanceof Method) && (assignContainedEO))
					this.relatedEffectIDs.assignFieldsTo(((Method_Study) eoDestintation).getRelatedEffectIDs(), assignContainedEO);
			}
		
		public void cloneFieldsTo(Method clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.relatedEffectIDs = this.relatedEffectIDs.clone(clone, dataSource);
			}
		
		public Method clone(EffectopediaObject parent, DataSource dataSource)
			{
				Method clone = new Method(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				if (relatedEffectIDs != null)
					relatedEffectIDs.getContainedIDs(containedIDs, includeOwned);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				if (relatedEffectIDs != null)
					relatedEffectIDs.getContainedExternalIDs(containedIDs);
			}
		
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				relatedEffectIDs = EffectopediaObject.cloneIfInDefaultObjects(relatedEffectIDs, this, dataSource);
			}
		
		@Override
		public void replaceArchivedObjectsWtihClones()
			{
				super.replaceArchivedObjectsWtihClones();
				relatedEffectIDs = EditHistory.replaceArchivedObjectsWtihClones(relatedEffectIDs, this, dataSource);
			}
		
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (relatedEffectIDs != null)
					relatedEffectIDs.process(batch);
			}
		
		public void updateParenthood()
			{
				super.updateParenthood();
				if (relatedEffectIDs == null)
					relatedEffectIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REL_EFFECT_IDS);
			}
		
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				relatedEffectIDs = dataSource.get(relatedEffectIDs.getClass(), relatedEffectIDs.getID());
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						relatedEffectIDs = io.load(ReferenceIDs.class, relatedEffectIDs, element.getChild("related_effect_ids"));
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
				relatedEffectIDs.updateExternalID(element.getChild("related_effect_ids"));
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addChild(relatedEffectIDs.store(io.newElement("related_effect_ids"), io));
				return element;
			}
		
		public DescriptionSection getSummaryDescription()
			{
				if ((descriptionIDs != null) && (descriptionIDs.size() > 0))
					return descriptionIDs.getCachedObject(0);
				else
					return null;
			}
		
		public final ReferenceIDs<Effect> getRelatedEffectIDs()
			{
				return relatedEffectIDs;
			}
		
		public final void setRelatedEffectIDs(ReferenceIDs<Effect> relatedEffectIDs)
			{
				this.relatedEffectIDs = relatedEffectIDs;
			}
		
		protected ReferenceIDs<Effect>	relatedEffectIDs;
	}

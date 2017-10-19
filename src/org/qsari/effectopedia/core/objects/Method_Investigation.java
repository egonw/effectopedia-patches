package org.qsari.effectopedia.core.objects;

import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.history.EditHistory;

public class Method_Investigation extends Method
	{
		public Method_Investigation()
			{
				super();
				descriptionIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_INVESTIGATION_IDS);
				relatedStudies = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REL_STUDIES_REFIDS);
			}
		
		public Method_Investigation(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_INVESTIGATION_IDS.clone(this, dataSource);
				relatedStudies = DefaultEffectopediaObjects.DEFAULT_REL_STUDIES_REFIDS.clone(this, dataSource);
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				descriptionIDs.getContainedIDs(containedIDs, includeOwned);
				containedIDs.put(relatedStudies.getID(), relatedStudies);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				descriptionIDs.getContainedExternalIDs(containedIDs);
				containedIDs.put(relatedStudies.getExternalID(), relatedStudies);
			}
		
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				relatedStudies = EffectopediaObject.cloneIfInDefaultObjects(relatedStudies, this, dataSource);
			}
		
		@Override
		public void replaceArchivedObjectsWtihClones()
			{
				super.replaceArchivedObjectsWtihClones();
				relatedStudies = EditHistory.replaceArchivedObjectsWtihClones(relatedStudies, this, dataSource);
			}
		
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (relatedStudies != null)
					relatedStudies.process(batch);
			}
		
		public void updateParenthood()
			{
				super.updateParenthood();
				if (relatedStudies == null)
					relatedStudies = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REL_STUDIES_REFIDS);
			}
		
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				relatedStudies = dataSource.get(relatedStudies.getClass(), relatedStudies.getID());
			}
		
		@Override
		public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if ((eoDestintation instanceof Method_Investigation) && assignContainedEO)
					this.relatedStudies.assignFieldsTo(((Method_Investigation) eoDestintation).getRelatedStudies(), assignContainedEO);
			}
		
		public void cloneFieldsTo(Method_Investigation clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.relatedStudies = this.relatedStudies.clone(clone, dataSource);
			}
		
		public Method_Investigation clone()
			{
				Method_Investigation clone = new Method_Investigation(null, dataSource);
				cloneFieldsTo(clone, dataSource);
				clone.setParent(parent);
				return clone;
			}
		
		public Method_Investigation clone(EffectopediaObject parent, DataSource dataSource)
			{
				Method_Investigation clone = new Method_Investigation(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						relatedStudies = io.load(ReferenceIDs.class, relatedStudies, element.getChild("related_study_ids"));
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
				relatedStudies.updateExternalID(element.getChild("related_study_ids"));
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addChild(relatedStudies.store(io.newElement("related_study_ids"), io));
				return element;
			}
		
		public ReferenceIDs<Method_Study> getRelatedStudies()
			{
				return relatedStudies;
			}
		
		public void setRelatedStudies(ReferenceIDs<Method_Study> relatedStudies)
			{
				this.relatedStudies = relatedStudies;
			}
		
		protected ReferenceIDs<Method_Study>	relatedStudies;
	}

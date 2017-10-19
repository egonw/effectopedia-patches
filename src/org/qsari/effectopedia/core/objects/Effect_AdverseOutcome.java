package org.qsari.effectopedia.core.objects;

import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.quantification.AggregationFunction;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.history.EditHistory;

public class Effect_AdverseOutcome extends Effect implements Importable, Exportable, Cloneable, Traceable
	{
		public Effect_AdverseOutcome()
			{
				super();
				descriptionIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_DE_IDS);
				descriptionIDs.setParent(this);
				upstreamLinkIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_LINKS_ETE_REFIDS);
				upstreamLinkIDs.addReferenceIDsChangeListener(this);
			}
		
		public Effect_AdverseOutcome(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_DE_IDS.clone(this, dataSource);
				upstreamLinkIDs = DefaultEffectopediaObjects.DEFAULT_LINKS_ETE_REFIDS.clone(this, dataSource);
				upstreamLinkIDs.addReferenceIDsChangeListener(this);
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				descriptionIDs.getContainedIDs(containedIDs, includeOwned);
				containedIDs.put(upstreamLinkIDs.getID(), upstreamLinkIDs);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				descriptionIDs.getContainedExternalIDs(containedIDs);
				containedIDs.put(upstreamLinkIDs.getExternalID(), upstreamLinkIDs);
			}
		
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				upstreamLinkIDs = EffectopediaObject.cloneIfInDefaultObjects(upstreamLinkIDs, this, dataSource);
			}
		
		@Override
		public void replaceArchivedObjectsWtihClones()
			{
				super.replaceArchivedObjectsWtihClones();
				upstreamLinkIDs = EditHistory.replaceArchivedObjectsWtihClones(upstreamLinkIDs, this, dataSource);
			}
		
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (upstreamLinkIDs != null)
					upstreamLinkIDs.process(batch);
			}
		
		public void updateParenthood()
			{
				super.updateParenthood();
				upstreamLinkIDs = EffectopediaObject.updateParent(upstreamLinkIDs, this);
			}
		
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				upstreamLinkIDs = dataSource.get(upstreamLinkIDs.getClass(), upstreamLinkIDs.getID());
				if (responseFn == null)
					responseFn = new AggregationFunction(this).createState();
			}
		
		public ReferenceIDs<Link_EffectToEffect> getUpstreamLinkIDs()
			{
				return upstreamLinkIDs;
			}
		
		@Override
				public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if ((eoDestintation instanceof Effect_AdverseOutcome)&&(assignContainedEO))
					this.upstreamLinkIDs.assignFieldsTo(((Effect_AdverseOutcome) eoDestintation).getUpstreamLinkIDs(),assignContainedEO);
			}
		
		public void cloneFieldsTo(Effect_AdverseOutcome clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.upstreamLinkIDs = this.upstreamLinkIDs.clone(clone, dataSource);
			}
		
		public Effect_AdverseOutcome clone()
			{
				Effect_AdverseOutcome clone = new Effect_AdverseOutcome(null, dataSource);
				cloneFieldsTo(clone, dataSource);
				clone.setParent(parent);
				return clone;
			}
		
		public Effect_AdverseOutcome clone(EffectopediaObject parent, DataSource dataSource)
			{
				Effect_AdverseOutcome clone = new Effect_AdverseOutcome(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						upstreamLinkIDs = io.load(ReferenceIDs.class, upstreamLinkIDs, element.getChild("upstream_link_ids"));
						upstreamLinkIDs.addReferenceIDsChangeListener(this);
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
				upstreamLinkIDs.updateExternalID(element.getChild("upstream_link_ids"));
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addChild(upstreamLinkIDs.store(io.newElement("upstream_link_ids"), io));
				return element;
			}
		
		public void link_Up(PathwayElement element)
			{
				if (element instanceof Link_EffectToEffect)
					this.upstreamLinkIDs.addIfDifferent((Link_EffectToEffect) element);
			}
		
		public void unlink_Up(PathwayElement element)
			{
				if (element instanceof Link_EffectToEffect)
					this.upstreamLinkIDs.removeIfPresent((Link_EffectToEffect) element);
			}
		
		public boolean hasIncommingAssociations()
			{
				return upstreamLinkIDs.size() > 0;
			}
		
		public PathwayElement[] incommingAssociations()
			{
				return upstreamLinkIDs.getCachedObjects();
			}
		
		protected ReferenceIDs<Link_EffectToEffect>	upstreamLinkIDs;
	}

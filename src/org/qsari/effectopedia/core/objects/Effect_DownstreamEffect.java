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

public class Effect_DownstreamEffect extends Effect implements Importable, Exportable, Cloneable, Traceable
	{
		public Effect_DownstreamEffect()
			{
				super();
				descriptionIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_DE_IDS);
				descriptionIDs.setParent(this);
				upstreamLinkIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_LINKS_ETE_REFIDS);
				downstreamLinkIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_LINKS_ETE_REFIDS);
				upstreamLinkIDs.addReferenceIDsChangeListener(this);
			}
		
		public Effect_DownstreamEffect(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_DE_IDS.clone(this, dataSource);
				upstreamLinkIDs = DefaultEffectopediaObjects.DEFAULT_LINKS_ETE_REFIDS.clone(this, dataSource);
				downstreamLinkIDs = DefaultEffectopediaObjects.DEFAULT_LINKS_ETE_REFIDS.clone(this, dataSource);
				upstreamLinkIDs.addReferenceIDsChangeListener(this);
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				descriptionIDs.getContainedIDs(containedIDs, includeOwned);
				containedIDs.put(upstreamLinkIDs.getID(), upstreamLinkIDs);
				containedIDs.put(downstreamLinkIDs.getID(), downstreamLinkIDs);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				descriptionIDs.getContainedExternalIDs(containedIDs);
				containedIDs.put(upstreamLinkIDs.getExternalID(), upstreamLinkIDs);
				containedIDs.put(downstreamLinkIDs.getExternalID(), downstreamLinkIDs);
			}
		
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				upstreamLinkIDs = EffectopediaObject.cloneIfInDefaultObjects(upstreamLinkIDs, this, dataSource);
				downstreamLinkIDs = EffectopediaObject.cloneIfInDefaultObjects(downstreamLinkIDs, this, dataSource);
			}
		
		@Override
		public void replaceArchivedObjectsWtihClones()
			{
				super.replaceArchivedObjectsWtihClones();
				upstreamLinkIDs = EditHistory.replaceArchivedObjectsWtihClones(upstreamLinkIDs, this, dataSource);
				downstreamLinkIDs = EditHistory.replaceArchivedObjectsWtihClones(downstreamLinkIDs, this, dataSource);
			}
		
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (upstreamLinkIDs != null)
					upstreamLinkIDs.process(batch);
				if (downstreamLinkIDs != null)
					downstreamLinkIDs.process(batch);
			}
		
		public void updateParenthood()
			{
				super.updateParenthood();
				upstreamLinkIDs = EffectopediaObject.updateParent(upstreamLinkIDs, this);
				downstreamLinkIDs = EffectopediaObject.updateParent(downstreamLinkIDs, this);
			}
		
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				upstreamLinkIDs = dataSource.get(upstreamLinkIDs.getClass(), upstreamLinkIDs.getID());
				upstreamLinkIDs.addReferenceIDsChangeListener(this);
				downstreamLinkIDs = dataSource.get(downstreamLinkIDs.getClass(), downstreamLinkIDs.getID());
				if (responseFn == null)
					responseFn = new AggregationFunction(this).createState();
			}
		
		public ReferenceIDs<Link_EffectToEffect> getUpstreamLinkIDs()
			{
				return upstreamLinkIDs;
			}
		
		public ReferenceIDs<Link_EffectToEffect> getDownstreamLinkIDs()
			{
				return downstreamLinkIDs;
			}
		
		@Override
				public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if ((eoDestintation instanceof Effect_DownstreamEffect)&&(assignContainedEO))
					{
						this.upstreamLinkIDs.assignFieldsTo(((Effect_DownstreamEffect) eoDestintation).getUpstreamLinkIDs(),assignContainedEO);
						this.downstreamLinkIDs.assignFieldsTo(((Effect_DownstreamEffect) eoDestintation).getDownstreamLinkIDs(),assignContainedEO);
					}
			}
		
		public void cloneFieldsTo(Effect_DownstreamEffect clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.upstreamLinkIDs = this.upstreamLinkIDs.clone(clone, dataSource);
				clone.downstreamLinkIDs = this.downstreamLinkIDs.clone(clone, dataSource);
			}
		
		public Effect_DownstreamEffect clone()
			{
				Effect_DownstreamEffect clone = new Effect_DownstreamEffect(null, dataSource);
				cloneFieldsTo(clone, dataSource);
				clone.setParent(parent);
				return clone;
			}
		
		public Effect_DownstreamEffect clone(EffectopediaObject parent, DataSource dataSource)
			{
				Effect_DownstreamEffect clone = new Effect_DownstreamEffect(parent, dataSource);
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
						downstreamLinkIDs = io.load(ReferenceIDs.class, downstreamLinkIDs, element.getChild("downstream_link_ids"));
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
				upstreamLinkIDs.updateExternalID(element.getChild("upstream_link_ids"));
				downstreamLinkIDs.updateExternalID(element.getChild("downstream_link_ids"));
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addChild(upstreamLinkIDs.store(io.newElement("upstream_link_ids"), io));
				element.addChild(downstreamLinkIDs.store(io.newElement("downstream_link_ids"), io));
				return element;
			}
		
		public void link_Up(PathwayElement element)
			{
				if (element instanceof Link_EffectToEffect)
					this.upstreamLinkIDs.addIfDifferent((Link_EffectToEffect) element);
			}
		
		public void link_Down(PathwayElement element)
			{
				if (element instanceof Link_EffectToEffect)
					this.downstreamLinkIDs.addIfDifferent((Link_EffectToEffect) element);
			}
		
		public void unlink_Up(PathwayElement element)
			{
				if (element instanceof Link_EffectToEffect)
					this.upstreamLinkIDs.removeIfPresent((Link_EffectToEffect) element);
			}
		
		public void unlink_Down(PathwayElement element)
			{
				if (element instanceof Link_EffectToEffect)
					this.downstreamLinkIDs.removeIfPresent((Link_EffectToEffect) element);
			}
		
		public boolean hasIncommingAssociations()
			{
				return upstreamLinkIDs.size() > 0;
			}
		
		public boolean hasOutgoingAssociations()
			{
				return downstreamLinkIDs.size() > 0;
			}
		
		public PathwayElement[] incommingAssociations()
			{
				return upstreamLinkIDs.getCachedObjects();
			}
		
		public PathwayElement[] outgoingAssociations()
			{
				return downstreamLinkIDs.getCachedObjects();
			}
		
		@Override
		public String DEBUG_getIDs()
			{
				StringBuilder sb = new StringBuilder();
				sb.append(super.DEBUG_getIDs());
				sb.append("\tpathway_ids\t");
				sb.append(pathwayIDs.DEBUG_getIDs());
				sb.append("\tupstreamLinkIDs\t");
				if (upstreamLinkIDs != null)
					sb.append(upstreamLinkIDs.DEBUG_getIDs());
				sb.append("\tdownstreamLinkIDs\t");
				if (downstreamLinkIDs != null)
					sb.append(downstreamLinkIDs.DEBUG_getIDs());
				sb.append("\trelatedTestMappingIDs\t");
				if (relatedTestMappingIDs != null)
					sb.append(relatedTestMappingIDs.DEBUG_getIDs());
				return sb.toString();
			}
		
		protected ReferenceIDs<Link_EffectToEffect>	upstreamLinkIDs;
		protected ReferenceIDs<Link_EffectToEffect>	downstreamLinkIDs;
	}

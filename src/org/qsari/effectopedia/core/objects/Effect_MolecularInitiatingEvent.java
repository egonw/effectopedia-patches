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

public class Effect_MolecularInitiatingEvent extends Effect implements Importable, Exportable, Cloneable, Traceable
	{
		
		public Effect_MolecularInitiatingEvent()
			{
				super();
				descriptionIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_MIE_IDS);
				descriptionIDs.setParent(this);
				upstreamLinkIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_LINKN_STMIE_REFIDS);
				downstreamLinkIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_LINKS_ETE_REFIDS);
				upstreamLinkIDs.addReferenceIDsChangeListener(this);
			}
		
		public Effect_MolecularInitiatingEvent(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_MIE_IDS.clone(this, dataSource);
				upstreamLinkIDs = DefaultEffectopediaObjects.DEFAULT_LINKN_STMIE_REFIDS.clone(this, dataSource);
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
		
		@Override
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
				downstreamLinkIDs = dataSource.get(downstreamLinkIDs.getClass(), downstreamLinkIDs.getID());
				if (responseFn == null)
					responseFn = new AggregationFunction(this).createState().createResponseFunctionIfNeeded(false);
			}
		
		public ReferenceIDs<Link_ChemStructToMIE> getUpstreamLinkIDs()
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
				if ((eoDestintation instanceof Effect_MolecularInitiatingEvent)&&(assignContainedEO))
					{
						this.upstreamLinkIDs.assignFieldsTo(((Effect_MolecularInitiatingEvent) eoDestintation).getUpstreamLinkIDs(),assignContainedEO);
						this.downstreamLinkIDs.assignFieldsTo(((Effect_MolecularInitiatingEvent) eoDestintation).getDownstreamLinkIDs(),assignContainedEO);
					}
			}
		
		public void cloneFieldsTo(Effect_MolecularInitiatingEvent clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.upstreamLinkIDs = this.upstreamLinkIDs.clone(clone, dataSource);
				clone.downstreamLinkIDs = this.downstreamLinkIDs.clone(clone, dataSource);
			}
		
		public Effect_MolecularInitiatingEvent clone()
			{
				Effect_MolecularInitiatingEvent clone = new Effect_MolecularInitiatingEvent(null, dataSource);
				cloneFieldsTo(clone, dataSource);
				clone.setParent(parent);
				return clone;
			}
		
		public Effect_MolecularInitiatingEvent clone(EffectopediaObject parent, DataSource dataSource)
			{
				Effect_MolecularInitiatingEvent clone = new Effect_MolecularInitiatingEvent(parent, dataSource);
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
				if (element instanceof Link_ChemStructToMIE)
					this.upstreamLinkIDs.addIfDifferent((Link_ChemStructToMIE) element);
			}
		
		public void link_Down(PathwayElement element)
			{
				if (element instanceof Link_EffectToEffect)
					this.downstreamLinkIDs.addIfDifferent((Link_EffectToEffect) element);
			}
		
		public void unlink_Up(PathwayElement element)
			{
				if (element instanceof Link_ChemStructToMIE)
					this.upstreamLinkIDs.removeIfPresent((Link_ChemStructToMIE) element);
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
		
		protected ReferenceIDs<Link_ChemStructToMIE>	upstreamLinkIDs;
		protected ReferenceIDs<Link_EffectToEffect>		downstreamLinkIDs;
		
	}

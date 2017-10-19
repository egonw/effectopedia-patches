package org.qsari.effectopedia.core.objects;

import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.DataValue_String;
import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.data.quantification.AggregationFunction;
import org.qsari.effectopedia.data.quantification.Factor;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.history.EditHistory;
import org.qsari.effectopedia.search.SearchIndices;
import org.qsari.effectopedia.search.SearchableItem;
import org.qsari.effectopedia.system.ActionTypes;
import org.qsari.effectopedia.system.TraceableProperties;

public class Initiator extends PathwayElement implements Importable, Exportable, Cloneable, Traceable, Titleable, Factor
	{
		public Initiator()
			{
				super();
				downstreamLinkIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_CHEMICAL_REFIDS);
				referenceIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REFERENCES_REFIDS);
				SearchableItem sa = new SearchableItem(this, S_TITLE_PID, SearchIndices.TITLE_INDEX);
				this.title = new DataValue_String(sa);
			}
		
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (downstreamLinkIDs != null)
					downstreamLinkIDs.process(batch);
				if (referenceIDs != null)
					referenceIDs.process(batch);
			}
		
		public Initiator(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				downstreamLinkIDs = DefaultEffectopediaObjects.DEFAULT_CHEMICAL_REFIDS.clone(this, dataSource);
				referenceIDs = DefaultEffectopediaObjects.DEFAULT_REFERENCES_REFIDS.clone(this, dataSource);
				SearchableItem sa = new SearchableItem(this, S_TITLE_PID, SearchIndices.TITLE_INDEX);
				this.title = new DataValue_String(sa);
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				containedIDs.put(downstreamLinkIDs.getID(), downstreamLinkIDs);
				containedIDs.put(referenceIDs.getID(), referenceIDs);
				
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				containedIDs.put(downstreamLinkIDs.getExternalID(), downstreamLinkIDs);
				if (referenceIDs != null)
					containedIDs.put(referenceIDs.getExternalID(), referenceIDs);
			}
		
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				downstreamLinkIDs = EffectopediaObject.cloneIfInDefaultObjects(downstreamLinkIDs, this, dataSource);
				referenceIDs = EffectopediaObject.cloneIfInDefaultObjects(referenceIDs, this, dataSource);
			}
		
		@Override
		public void replaceArchivedObjectsWtihClones()
			{
				super.replaceArchivedObjectsWtihClones();
				downstreamLinkIDs = EditHistory.replaceArchivedObjectsWtihClones(downstreamLinkIDs, this, dataSource);
				referenceIDs = EditHistory.replaceArchivedObjectsWtihClones(referenceIDs, this, dataSource);
			}
		
		public void updateParenthood()
			{
				super.updateParenthood();
				downstreamLinkIDs = EffectopediaObject.updateParent(downstreamLinkIDs, this);
				referenceIDs = EffectopediaObject.updateParent(referenceIDs, this);
			}
		
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				downstreamLinkIDs = dataSource.get(downstreamLinkIDs.getClass(), downstreamLinkIDs.getID());
				referenceIDs = dataSource.get(referenceIDs.getClass(), referenceIDs.getID());
			}
		
		@Override
		public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if (eoDestintation instanceof Initiator)
					{
						((Initiator) eoDestintation).setTitle(this.title.getValue());
						if (assignContainedEO)
							{
								this.downstreamLinkIDs.assignFieldsTo(((Initiator) eoDestintation).downstreamLinkIDs, assignContainedEO);
								this.referenceIDs.assignFieldsTo(((Initiator) eoDestintation).referenceIDs, assignContainedEO);
							}
					}
			}
		
		public void cloneFieldsTo(Initiator clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.downstreamLinkIDs = this.downstreamLinkIDs.clone(clone, dataSource);
				clone.referenceIDs = this.referenceIDs.clone(clone, dataSource);
				clone.title = this.title.clone(clone);
			}
		
		public Initiator clone()
			{
				Initiator clone = new Initiator(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public Initiator clone(EffectopediaObject parent, DataSource dataSource)
			{
				Initiator clone = new Initiator(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void setTitle(String title)
			{
				if (((title == null) && (this.title != null)) || (!title.equals(this.title)))
					{
						beforeUpdate(true, ActionTypes.S_TITLE_AID);
						this.title.parseString(title);
						this.generic = false;
					}
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						title.parseString(element.getValueElement("title").getValue());
						downstreamLinkIDs = io.load(ReferenceIDs.class, downstreamLinkIDs, element.getChild("downstream_link_ids"));
						referenceIDs = io.load(ReferenceIDs.class, referenceIDs, element.getChild("reference_ids"));
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
				downstreamLinkIDs.updateExternalID(element.getChild("downstream_link_ids"));
				referenceIDs.updateExternalID(element.getChild("reference_ids"));
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addValueElement(io.newValue("title").setValue(title.toString()));
				element.addChild(downstreamLinkIDs.store(io.newElement("downstream_link_ids"), io));
				element.addChild(referenceIDs.store(io.newElement("reference_ids"), io));
				return element;
			}
		
		public Link[] incommingAssociations()
			{
				return null;
			}
		
		public Link[] outgoingAssociations()
			{
				return downstreamLinkIDs.getCachedObjects();
			}
		
		public void link_Down(PathwayElement element)
			{
				if (element instanceof Link_ChemStructToMIE)
					this.downstreamLinkIDs.addIfDifferent((Link_ChemStructToMIE) element);
				else if (element instanceof Link_ChemStructToChemStruct)
					this.downstreamLinkIDs.addIfDifferent((Link_ChemStructToChemStruct) element);
			}
		
		public void unlink_Down(PathwayElement element)
			{
				if (element instanceof Link_ChemStructToMIE)
					this.downstreamLinkIDs.removeIfPresent((Link_ChemStructToMIE) element);
				else if (element instanceof Link_ChemStructToChemStruct)
					this.downstreamLinkIDs.removeIfPresent((Link_ChemStructToChemStruct) element);
			}
		
		public boolean hasOutgoingAssociations()
			{
				return downstreamLinkIDs.size() > 0;
			}
		
		public ReferenceIDs<Link> getDownstreamLinkIDs()
			{
				return downstreamLinkIDs;
			}
		
		public ReferenceIDs<Reference> getReferenceIDs()
			{
				return this.referenceIDs;
			}
		
		@Override
		public ObjectProperty getCurrentState()
			{
				return (stateFn != null) ? stateFn.getProperties().getProperty(0) : null;
			}
		
		protected AggregationFunction getStateFn()
			{
				return stateFn;
			}
		
		protected void setStateFn(AggregationFunction stateFn)
			{
				this.stateFn = stateFn;
			}
		
		public static final long										S_TITLE_PID	= TraceableProperties.REGISTERED.add("title", "", Initiator.class);
		
		protected ReferenceIDs<Link>						downstreamLinkIDs;
		protected ReferenceIDs<Reference>	referenceIDs;
		protected AggregationFunction					stateFn;
		
	}

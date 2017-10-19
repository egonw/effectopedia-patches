package org.qsari.effectopedia.core.objects;

import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.ids.ReferenceID;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.defaults.DefaultOntologies;
import org.qsari.effectopedia.history.EditHistory;
import org.qsari.effectopedia.ontologies.OntologyInstances;

public class Link_ChemStructToChemStruct extends Link implements Importable, Exportable, Cloneable, Traceable
	{
		public Link_ChemStructToChemStruct()
			{
				super();
				descriptionIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_LINK_STRS_IDS);
				descriptionIDs.setParent(this);
				parentStructure = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REFERENCE_I);
				childStructure = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REFERENCE_I);
				enzymeSystem = DefaultOntologies.defaultInstances.get(DefaultOntologies.ENZYME);
			}
		
		public Link_ChemStructToChemStruct(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_LINK_STRS_IDS.clone(this, dataSource);
				parentStructure = DefaultEffectopediaObjects.DEFAULT_REFERENCE_I.clone(this, dataSource);
				childStructure = DefaultEffectopediaObjects.DEFAULT_REFERENCE_I.clone(this, dataSource);
				enzymeSystem = DefaultOntologies.defaultInstances.get(DefaultOntologies.ENZYME);
			}
		
		public Link_ChemStructToChemStruct(EffectopediaObject parent, DataSource dataSource, Initiator chemical, Initiator reactiveChemical)
			{
				super(parent, dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_LINK_STRS_IDS.clone(this, dataSource);
				this.parentStructure = DefaultEffectopediaObjects.DEFAULT_REFERENCE_I.clone(this, dataSource);
				this.childStructure = DefaultEffectopediaObjects.DEFAULT_REFERENCE_I.clone(this, dataSource);
				enzymeSystem = DefaultOntologies.defaultInstances.get(DefaultOntologies.ENZYME);
				bringToLive();
				if (chemical.isDefaultID())
					chemical.bringToLive();
				link_Up(chemical);
				chemical.link_Down(this);
				if (reactiveChemical.isDefaultID())
					reactiveChemical.bringToLive();
				link_Down(reactiveChemical);
				reactiveChemical.link_Up(this);
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				descriptionIDs.getContainedIDs(containedIDs, includeOwned);
				containedIDs.put(parentStructure.getID(), parentStructure);
				containedIDs.put(childStructure.getID(), childStructure);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				descriptionIDs.getContainedExternalIDs(containedIDs);
				containedIDs.put(parentStructure.getExternalID(), parentStructure);
				containedIDs.put(childStructure.getExternalID(), childStructure);
			}
		
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				parentStructure = EffectopediaObject.cloneIfInDefaultObjects(parentStructure, this, dataSource);
				childStructure = EffectopediaObject.cloneIfInDefaultObjects(childStructure, this, dataSource);
			}
		
		@Override
		public void replaceArchivedObjectsWtihClones()
			{
				super.replaceArchivedObjectsWtihClones();
				parentStructure = EditHistory.replaceArchivedObjectsWtihClones(parentStructure, this, dataSource);
				childStructure = EditHistory.replaceArchivedObjectsWtihClones(childStructure, this, dataSource);
			}
		
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (parentStructure != null)
					parentStructure.process(batch);
				if (childStructure != null)
					childStructure.process(batch);
			}
		
		public void updateParenthood()
			{
				super.updateParenthood();
				parentStructure = EffectopediaObject.updateParent(parentStructure, this);
				childStructure = EffectopediaObject.updateParent(childStructure, this);
				enzymeSystem.setParent(this);
			}
		
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				parentStructure = dataSource.get(parentStructure.getClass(), parentStructure.getID());
				childStructure = dataSource.get(childStructure.getClass(), childStructure.getID());
			}
		
		public ReferenceID<Initiator> getParentStructure()
			{
				return this.parentStructure;
			}
		
		public ReferenceID<Initiator> getStructure()
			{
				return this.childStructure;
			}
		
		@Override
				public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if ((eoDestintation instanceof Link_ChemStructToChemStruct)&&(assignContainedEO))
					{
						if (parentStructure != null)
							parentStructure.assignFieldsTo(((Link_ChemStructToChemStruct) eoDestintation).parentStructure,assignContainedEO);
						if (childStructure != null)
							childStructure.assignFieldsTo(((Link_ChemStructToChemStruct) eoDestintation).childStructure,assignContainedEO);
					}
			}
		
		public void cloneFieldsTo(Link_ChemStructToChemStruct clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				if (this.parentStructure != null)
					clone.parentStructure = this.parentStructure.clone(clone, dataSource);
				else
					clone.parentStructure = null;
				if (this.childStructure != null)
					clone.childStructure = this.childStructure.clone(clone, dataSource);
				else
					clone.childStructure = null;
			}
		
		public Link_ChemStructToChemStruct clone()
			{
				Link_ChemStructToChemStruct clone = new Link_ChemStructToChemStruct(null, dataSource);
				cloneFieldsTo(clone, dataSource);
				clone.setParent(parent);
				return clone;
			}
		
		public Link_ChemStructToChemStruct clone(EffectopediaObject parent, DataSource dataSource)
			{
				Link_ChemStructToChemStruct clone = new Link_ChemStructToChemStruct(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						parentStructure = io.load(ReferenceID.class, parentStructure, element.getChild(io.getInputVersion() < 0.95 ? "structure" : "parent_structure"));
						childStructure = io.load(ReferenceID.class, childStructure, element.getChild("child_structure"));
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
				parentStructure.updateExternalID(element.getChild("parent_structure"));
				childStructure.updateExternalID(element.getChild("child_structure"));
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addChild(parentStructure.store(io.newElement("parent_structure"), io));
				element.addChild(childStructure.store(io.newElement("child_structure"), io));
				return element;
			}
		
		public void link_Down(PathwayElement element)
			{
				if (element instanceof Initiator)
					this.childStructure.set((Initiator) element);
			}
		
		public void link_Up(PathwayElement element)
			{
				if (element instanceof Initiator)
					this.parentStructure.set((Initiator) element);
			}
		
		public void unlink_Down(PathwayElement element)
			{
				if (element == this.childStructure.getCachedObject())
					this.childStructure.set(null);
			}
		
		public void unlink_Up(PathwayElement element)
			{
				if (element == this.parentStructure.getCachedObject())
					this.parentStructure.set(null);
			}
		
		public boolean hasIncommingAssociations()
			{
				return parentStructure.getCachedObject() != null;
			}
		
		public boolean hasOutgoingAssociations()
			{
				return childStructure.getCachedObject() != null;
			}
		
		public PathwayElement[] incommingAssociations()
			{
				PathwayElement[] result =
					{ parentStructure.getCachedObject() };
				return result;
			}
		
		public PathwayElement[] outgoingAssociations()
			{
				PathwayElement[] result =
					{ childStructure.getCachedObject() };
				return result;
			}
		
		public OntologyInstances getEnzymeSystem()
			{
				return enzymeSystem;
			}
		
		public void setEnzymeSystem(OntologyInstances enzymeSystem)
			{
				this.enzymeSystem = enzymeSystem;
			}
		
		private ReferenceID<Initiator>	parentStructure;
		private ReferenceID<Initiator>	childStructure;
		private OntologyInstances						enzymeSystem;
		
	}

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
import org.qsari.effectopedia.history.EditHistory;

public class Link_ChemStructToMIE extends Link implements Importable, Exportable, Cloneable, Traceable
	{
		
		public Link_ChemStructToMIE()
			{
				super();
				descriptionIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_LINK_STMIE_IDS);
				descriptionIDs.setParent(this);
				this.structure = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REFERENCE_I);
				this.effect = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REFERENCE_E);
			}
		
		public Link_ChemStructToMIE(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_LINK_STMIE_IDS.clone(this, dataSource);
				this.structure = DefaultEffectopediaObjects.DEFAULT_REFERENCE_I.clone(this, dataSource);
				this.effect = DefaultEffectopediaObjects.DEFAULT_REFERENCE_E.clone(this, dataSource);
			}
		
		public Link_ChemStructToMIE(EffectopediaObject parent, DataSource dataSource, Initiator substance, Effect mie)
			{
				super(parent, dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_LINK_STMIE_IDS.clone(this, dataSource);
				this.structure = DefaultEffectopediaObjects.DEFAULT_REFERENCE_I.clone(this, dataSource);
				this.effect = DefaultEffectopediaObjects.DEFAULT_REFERENCE_E.clone(this, dataSource);
				bringToLive();
				if (mie.isDefaultID())
					mie.bringToLive();
				link_Down(mie);
				mie.link_Up(this);
				if (substance.isDefaultID())
					substance.bringToLive();
				link_Up(substance);
				substance.link_Down(this);
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				descriptionIDs.getContainedIDs(containedIDs, includeOwned);
				containedIDs.put(structure.getID(), structure);
				containedIDs.put(effect.getID(), effect);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				descriptionIDs.getContainedExternalIDs(containedIDs);
				containedIDs.put(structure.getExternalID(), structure);
				containedIDs.put(effect.getExternalID(), effect);
			}
		
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				structure = EffectopediaObject.cloneIfInDefaultObjects(structure, this, dataSource);
				effect = EffectopediaObject.cloneIfInDefaultObjects(effect, this, dataSource);
			}
		
		@Override
		public void replaceArchivedObjectsWtihClones()
			{
				super.replaceArchivedObjectsWtihClones();
				structure = EditHistory.replaceArchivedObjectsWtihClones(structure, this, dataSource);
				effect = EditHistory.replaceArchivedObjectsWtihClones(effect, this, dataSource);
			}
		
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (structure != null)
					structure.process(batch);
				if (effect != null)
					effect.process(batch);
			}
		
		public void updateParenthood()
			{
				super.updateParenthood();
				structure = EffectopediaObject.updateParent(structure, this);
				effect = EffectopediaObject.updateParent(effect, this);
			}
		
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				structure = dataSource.get(structure.getClass(), structure.getID());
				effect = dataSource.get(effect.getClass(), effect.getID());
			}
		
		public void link_Down(PathwayElement element)
			{
				if (element instanceof Effect)
					this.effect.set((Effect) element);
			}
		
		public void link_Up(PathwayElement element)
			{
				if (element instanceof Initiator)
					this.structure.set((Initiator) element);
			}
		
		public void unlink_Down(PathwayElement element)
			{
				if (element == this.effect.getCachedObject())
					this.effect.set(null);
			}
		
		public void unlink_Up(PathwayElement element)
			{
				if (element == this.structure.getCachedObject())
					this.structure.set(null);
			}
		
		public ReferenceID<Initiator> getStructure()
			{
				return structure;
			}
		
		public ReferenceID<Effect> getEffect()
			{
				return effect;
			}
		
		@Override
				public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if ((eoDestintation instanceof Link_ChemStructToMIE)&&(assignContainedEO))
					{
						if (effect != null)
							effect.assignFieldsTo(((Link_ChemStructToMIE) eoDestintation).effect,assignContainedEO);
						if (structure != null)
							structure.assignFieldsTo(((Link_ChemStructToMIE) eoDestintation).structure,assignContainedEO);
					}
			}
		
		public void cloneFieldsTo(Link_ChemStructToMIE clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				if (this.effect != null)
					clone.effect = this.effect.clone(clone, dataSource);
				else
					clone.effect = null;
				if (this.structure != null)
					clone.structure = this.structure.clone(clone, dataSource);
				else
					clone.structure = null;
			}
		
		public Link_ChemStructToMIE clone()
			{
				Link_ChemStructToMIE clone = new Link_ChemStructToMIE(null, dataSource);
				cloneFieldsTo(clone, dataSource);
				clone.setParent(parent);
				return clone;
			}
		
		public Link_ChemStructToMIE clone(EffectopediaObject parent, DataSource dataSource)
			{
				Link_ChemStructToMIE clone = new Link_ChemStructToMIE(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						structure = io.load(ReferenceID.class, structure, element.getChild("structure"));
						effect = io.load(ReferenceID.class, effect, element.getChild("effect"));
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
				structure.updateExternalID(element.getChild("structure"));
				effect.updateExternalID(element.getChild("effect"));
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addChild(structure.store(io.newElement("structure"), io));
				element.addChild(effect.store(io.newElement("effect"), io));
				return element;
			}
		
		public boolean hasIncommingAssociations()
			{
				return structure.getCachedObject() != null;
			}
		
		public boolean hasOutgoingAssociations()
			{
				return effect.getCachedObject() != null;
			}
		
		public PathwayElement[] incommingAssociations()
			{
				PathwayElement[] result =
					{ structure.getCachedObject() };
				return result;
			}
		
		public PathwayElement[] outgoingAssociations()
			{
				PathwayElement[] result =
					{ effect.getCachedObject() };
				return result;
			}
		
		public String DEBUG_getIDs()
			{
				StringBuilder sb = new StringBuilder();
				sb.append(super.DEBUG_getIDs());
				sb.append("\tpathway_ids\t");
				sb.append(pathwayIDs.DEBUG_getIDs());
				sb.append("\tsubstance\t");
				if (structure != null)
					sb.append(structure.DEBUG_getIDs());
				sb.append("\teffect\t");
				if (effect != null)
					sb.append(effect.DEBUG_getIDs());
				return sb.toString();
			}
		
		private ReferenceID<Initiator>	structure;
		protected ReferenceID<Effect>		effect;
		
	}

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

public class Link_EffectToEffect extends Link implements Importable, Exportable, Cloneable, Traceable
	{
		public Link_EffectToEffect()
			{
				super();
				descriptionIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_LINK_ETE_IDS);
				fromEffect = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REFERENCE_E);
				toEffect = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REFERENCE_E);
			}
		
		public Link_EffectToEffect(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_LINK_ETE_IDS.clone(this, dataSource);
				fromEffect = DefaultEffectopediaObjects.DEFAULT_REFERENCE_E.clone(this, dataSource);
				toEffect = DefaultEffectopediaObjects.DEFAULT_REFERENCE_E.clone(this, dataSource);
			}
		
		public Link_EffectToEffect(EffectopediaObject parent, DataSource dataSource, Effect fromEffect, Effect toEffect)
			{
				super(parent, dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_LINK_ETE_IDS.clone(this, dataSource);
				this.fromEffect = DefaultEffectopediaObjects.DEFAULT_REFERENCE_E.clone(this, dataSource);
				this.toEffect = DefaultEffectopediaObjects.DEFAULT_REFERENCE_E.clone(this, dataSource);
				bringToLive();
				if (fromEffect.isDefaultID())
					fromEffect.bringToLive();
				link_Up(fromEffect);
				if (toEffect.isDefaultID())
					toEffect.bringToLive();
				link_Down(toEffect);
				fromEffect.link_Down(this);
				toEffect.link_Up(this);
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				descriptionIDs.getContainedIDs(containedIDs, includeOwned);
				containedIDs.put(fromEffect.getID(), fromEffect);
				containedIDs.put(toEffect.getID(), toEffect);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				descriptionIDs.getContainedExternalIDs(containedIDs);
				containedIDs.put(fromEffect.getExternalID(), fromEffect);
				containedIDs.put(toEffect.getExternalID(), toEffect);
			}
		
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				fromEffect = EffectopediaObject.cloneIfInDefaultObjects(fromEffect, this, dataSource);
				toEffect = EffectopediaObject.cloneIfInDefaultObjects(toEffect, this, dataSource);
			}

		@Override
		public void replaceArchivedObjectsWtihClones()
			{
				super.replaceArchivedObjectsWtihClones();
				fromEffect = EditHistory.replaceArchivedObjectsWtihClones(fromEffect,this,dataSource);
				toEffect = EditHistory.replaceArchivedObjectsWtihClones(toEffect,this,dataSource);
			}

		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (fromEffect != null)
					fromEffect.process(batch);
				if (toEffect != null)
					toEffect.process(batch);
			}
		
		public void updateParenthood()
			{
				super.updateParenthood();
				fromEffect = EffectopediaObject.updateParent(fromEffect, this);
				toEffect = EffectopediaObject.updateParent(toEffect, this);
			}
		
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				fromEffect = dataSource.get(fromEffect.getClass(), fromEffect.getID());
				toEffect = dataSource.get(toEffect.getClass(), toEffect.getID());
			}
		
		public ReferenceID<Effect> getFromEffect()
			{
				return fromEffect;
			}
		
		public ReferenceID<Effect> getToEffect()
			{
				return toEffect;
			}
		
		@Override
				public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if ((eoDestintation instanceof Link_EffectToEffect)&&(assignContainedEO))
					{
						if (toEffect != null)
							toEffect.assignFieldsTo(((Link_EffectToEffect) eoDestintation).toEffect,assignContainedEO);
						if (fromEffect != null)
							fromEffect.assignFieldsTo(((Link_EffectToEffect) eoDestintation).fromEffect,assignContainedEO);
					}
			}
	
		public void cloneFieldsTo(Link_EffectToEffect clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				if (this.toEffect != null)
					clone.toEffect = this.toEffect.clone(clone, dataSource);
				else
					clone.toEffect = null;
				if (this.fromEffect != null)
					clone.fromEffect = this.fromEffect.clone(clone, dataSource);
				else
					clone.fromEffect = null;
			}
		
		public Link_EffectToEffect clone()
			{
				Link_EffectToEffect clone = new Link_EffectToEffect(null, dataSource);
				cloneFieldsTo(clone, dataSource);
				clone.setParent(parent);
				return clone;
			}
		
		public Link_EffectToEffect clone(EffectopediaObject parent, DataSource dataSource)
			{
				Link_EffectToEffect clone = new Link_EffectToEffect(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						fromEffect = io.load(ReferenceID.class, fromEffect, element.getChild("from_effect"));
						toEffect = io.load(ReferenceID.class, toEffect, element.getChild("to_effect"));
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
				fromEffect.updateExternalID(element.getChild("from_effect"));
				toEffect.updateExternalID(element.getChild("to_effect"));
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addChild(fromEffect.store(io.newElement("from_effect"), io));
				element.addChild(toEffect.store(io.newElement("to_effect"), io));
				return element;
			}
		
		public void link_Down(PathwayElement element)
			{
				if (element instanceof Effect)
					this.toEffect.set((Effect) element);
			}
		
		public void link_Up(PathwayElement element)
			{
				if (element instanceof Effect)
					this.fromEffect.set((Effect) element);
			}
		
		public void unlink_Down(PathwayElement element)
			{
				if (toEffect == null)
					return;
				if (element == this.toEffect.getCachedObject())
					this.toEffect.set(null);
			}
		
		public void unlink_Up(PathwayElement element)
			{
				if (fromEffect == null)
					return;
				if (element == this.fromEffect.getCachedObject())
					this.fromEffect.set(null);
			}
		
		public boolean hasIncommingAssociations()
			{
				return fromEffect.getCachedObject() != null;
			}
		
		public boolean hasOutgoingAssociations()
			{
				return toEffect.getCachedObject() != null;
			}
		
		public PathwayElement[] incommingAssociations()
			{
				PathwayElement[] result =
					{ fromEffect.getCachedObject() };
				return result;
			}
		
		public PathwayElement[] outgoingAssociations()
			{
				PathwayElement[] result =
					{ toEffect.getCachedObject() };
				return result;
			}
		
		public String getDescriptiveTitle()
			{
				StringBuilder sb = new StringBuilder();
				if ((fromEffect != null)&&(fromEffect.getCachedObject() != null))
					sb.append(fromEffect.getCachedObject().getTitle());
				else
					sb.append("Unknown Cause");
				if (getLinkType() != LinkType.UNKNOWN)
					{
						sb.append(" ");
						sb.append(getLinkType().toString());
						sb.append("ly");
					}
				sb.append(" Leads to ");
				if ((toEffect != null)&&(toEffect.getCachedObject() != null))
					sb.append(toEffect.getCachedObject().getTitle());
				else
					sb.append("Unknown Consiquence");
				return sb.toString();
				
			}
		
		public String DEBUG_getIDs()
			{
				StringBuilder sb = new StringBuilder();
				sb.append(super.DEBUG_getIDs());
				sb.append("\tpathway_ids\t");
				sb.append(pathwayIDs.DEBUG_getIDs());
				sb.append("\tfromEffect\t");
				if (fromEffect != null)
					sb.append(fromEffect.DEBUG_getIDs());
				sb.append("\ttoEffect\t");
				if (toEffect != null)
					sb.append(toEffect.DEBUG_getIDs());
				return sb.toString();
			}
		
		protected ReferenceID<Effect>	fromEffect;
		protected ReferenceID<Effect>	toEffect;
		
	}

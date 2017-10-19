package org.qsari.effectopedia.core.objects;

import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.ids.DescriptionIDs;
import org.qsari.effectopedia.base.ids.ReferenceID;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.containers.References.Referable;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.history.EditHistory;

public class Initiator_BiologcalPerturbation extends Initiator implements Importable, Exportable, Cloneable, Traceable, Referable
	{
		public Initiator_BiologcalPerturbation()
			{
				super();
				descriptionIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_BIOPERT_IDS);
				this.substance = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REFERENCE_I);
				this.effect = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REFERENCE_E);
			}
		
		public Initiator_BiologcalPerturbation(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_BIOPERT_IDS.clone(this, dataSource);
				this.substance = DefaultEffectopediaObjects.DEFAULT_REFERENCE_I.clone(this, dataSource);
				this.effect = DefaultEffectopediaObjects.DEFAULT_REFERENCE_E.clone(this, dataSource);
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				descriptionIDs.getContainedIDs(containedIDs, includeOwned);
				containedIDs.put(substance.getID(), substance);
				containedIDs.put(effect.getID(), effect);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				descriptionIDs.getContainedExternalIDs(containedIDs);
				containedIDs.put(substance.getExternalID(), substance);
				containedIDs.put(effect.getExternalID(), effect);
			}
		
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				substance = EffectopediaObject.cloneIfInDefaultObjects(substance, this, dataSource);
				effect = EffectopediaObject.cloneIfInDefaultObjects(effect, this, dataSource);
			}
		
		@Override
		public void replaceArchivedObjectsWtihClones()
			{
				super.replaceArchivedObjectsWtihClones();
				substance = EditHistory.replaceArchivedObjectsWtihClones(substance, this, dataSource);
				effect = EditHistory.replaceArchivedObjectsWtihClones(effect, this, dataSource);
			}
		
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (descriptionIDs != null)
					descriptionIDs.process(batch);
				if (substance != null)
					substance.process(batch);
				if (effect != null)
					effect.process(batch);
			}
		
		public void updateParenthood()
			{
				super.updateParenthood();
				descriptionIDs = EffectopediaObject.updateParent(descriptionIDs, this);
				descriptionIDs.updateParenthood();
				substance = EffectopediaObject.updateParent(substance, this);
				effect = EffectopediaObject.updateParent(effect, this);
			}
		
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				descriptionIDs = dataSource.get(descriptionIDs.getClass(), descriptionIDs.getID());
				substance = dataSource.get(substance.getClass(), substance.getID());
				effect = dataSource.get(effect.getClass(), effect.getID());
			}
		
		@Override
		public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if ((eoDestintation instanceof Initiator_BiologcalPerturbation) && assignContainedEO)
					{
						this.descriptionIDs.assignFieldsTo(((Initiator_BiologcalPerturbation) eoDestintation).getDescriptionIDs(), assignContainedEO);
						if (this.effect != null)
							this.effect.assignFieldsTo(((Initiator_BiologcalPerturbation) eoDestintation).getEffect(), assignContainedEO);
						if (this.substance != null)
							this.substance.assignFieldsTo(((Initiator_BiologcalPerturbation) eoDestintation).getSubstance(), assignContainedEO);
					}
			}
		
		public void cloneFieldsTo(Initiator_BiologcalPerturbation clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.descriptionIDs = this.descriptionIDs.clone(clone, dataSource);
				if (this.effect != null)
					clone.effect = this.effect.clone(clone, dataSource);
				else
					clone.effect = null;
				if (this.substance != null)
					clone.substance = this.substance.clone(clone, dataSource);
				else
					clone.substance = null;
				clone.effect.setParent(clone);
				clone.substance.setParent(clone);
			}
		
		public Initiator_BiologcalPerturbation clone()
			{
				Initiator_BiologcalPerturbation clone = new Initiator_BiologcalPerturbation(null, dataSource);
				cloneFieldsTo(clone, dataSource);
				clone.setParent(parent);
				return clone;
			}
		
		public Initiator_BiologcalPerturbation clone(EffectopediaObject parent, DataSource dataSource)
			{
				Initiator_BiologcalPerturbation clone = new Initiator_BiologcalPerturbation(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						descriptionIDs = io.load(DescriptionIDs.class, descriptionIDs, element.getChild("description"));
						substance = io.load(ReferenceID.class, substance, element.getChild("substance"));
						effect = io.load(ReferenceID.class, effect, element.getChild("effect"));
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				if (element != null)
					{
						super.updateExternalID(element);
						descriptionIDs.updateExternalID(element.getChild("description"));
						substance.updateExternalID(element.getChild("substance"));
						effect.updateExternalID(element.getChild("effect"));
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addChild(descriptionIDs.store(io.newElement("description"), io));
				element.addChild(substance.store(io.newElement("substance"), io));
				element.addChild(effect.store(io.newElement("effect"), io));
				return element;
			}
		
		public final DescriptionIDs getDescriptionIDs()
			{
				return descriptionIDs;
			}
		
		public final void setDescriptionIDs(DescriptionIDs descriptionIDs)
			{
				this.descriptionIDs = descriptionIDs;
			}
		
		public final ReferenceID<Initiator> getSubstance()
			{
				return substance;
			}
		
		public final void setSubstance(ReferenceID<Initiator> substance)
			{
				this.substance = substance;
			}
		
		public final ReferenceID<Effect> getEffect()
			{
				return effect;
			}
		
		public final void setEffect(ReferenceID<Effect> effect)
			{
				this.effect = effect;
			}
		
		protected DescriptionIDs							descriptionIDs;
		private ReferenceID<Initiator>	substance;
		protected ReferenceID<Effect>		effect;
	}

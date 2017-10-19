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
import org.qsari.effectopedia.defaults.DefaultDataTemplates;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.history.EditHistory;

public class SubstanceData_InLab extends SubstanceData implements Importable, Exportable, Cloneable, Traceable
	{
		
		public SubstanceData_InLab()
			{
				super();
				this.lab = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REFERENCE_L);
			}
		
		public SubstanceData_InLab(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				this.lab = DefaultEffectopediaObjects.DEFAULT_REFERENCE_L.clone(this, dataSource);
			}
		
		@Override
		public void init(boolean asDefaultObject)
			{
				this.substance = DefaultEffectopediaObjects.buildingDefaultObjects ? DefaultEffectopediaObjects.DEFAULT_REFERENCE_S : DefaultEffectopediaObjects.DEFAULT_REFERENCE_S.clone(this, dataSource);
				this.objectProperties = DefaultEffectopediaObjects.buildingDefaultObjects ? DefaultEffectopediaObjects.DEFAULT_D_RESP_DATA : DefaultEffectopediaObjects.DEFAULT_D_RESP_DATA.clone(this, null);
				this.templates = DefaultDataTemplates.DTS_DR_SINGLE_CHEM_ALL.clone();
				this.templates.setProperties(objectProperties);
				this.templates.setOwner(this);
				this.lab = DefaultEffectopediaObjects.DEFAULT_REFERENCE_L.clone(this, dataSource);
				updateParenthood();
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				if (lab != null)
					containedIDs.put(lab.getID(), lab);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				if (lab != null)
					containedIDs.put(lab.getExternalID(), lab);
			}
		
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				if (lab != null)
					lab = EffectopediaObject.cloneIfInDefaultObjects(lab, this, dataSource);
			}
		
		@Override
		public void replaceArchivedObjectsWtihClones()
			{
				super.replaceArchivedObjectsWtihClones();
				if (lab != null)
					lab = EditHistory.replaceArchivedObjectsWtihClones(lab, this, dataSource);
			}
		
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (lab != null)
					lab.process(batch);
			}
		
		public void updateParenthood()
			{
				super.updateParenthood();
				if (lab != null)
					lab = EffectopediaObject.updateParent(lab, this);
			}
		
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				if (lab != null)
					lab = dataSource.get(lab.getClass(), lab.getID());
			}
		
		public ReferenceID<Lab> getLab()
			{
				return lab;
			}
		
		@Override
		public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if ((eoDestintation instanceof SubstanceData_InLab) && (this.lab != null) && assignContainedEO)
					this.lab.assignFieldsTo(((SubstanceData_InLab) eoDestintation).getLab(), assignContainedEO);
			}
		
		public void cloneFieldsTo(SubstanceData_InLab clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				if (this.lab != null)
					clone.lab = this.lab.clone(clone, dataSource);
				else
					clone.lab = null;
			}
		
		@Override
		public SubstanceData_InLab clone()
			{
				SubstanceData_InLab clone = new SubstanceData_InLab(null, dataSource);
				cloneFieldsTo(clone, dataSource);
				clone.setParent(parent);
				return clone;
			}
		
		@Override
		public SubstanceData_InLab clone(EffectopediaObject parent, DataSource dataSource)
			{
				SubstanceData_InLab clone = new SubstanceData_InLab(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						BaseIOElement labElement = element.getChild("lab");
						if (labElement != null)
							lab = io.load(ReferenceID.class, lab, labElement);
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
				if (lab != null)
					lab.updateExternalID(element.getChild("lab"));
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				if (lab != null)
					element.addChild(lab.store(io.newElement("lab"), io));
				return element;
			}
		
		public String DEBUG_getIDs()
			{
				StringBuilder sb = new StringBuilder();
				sb.append(super.DEBUG_getIDs());
				sb.append("\tlab\t");
				if (lab != null)
					sb.append(lab.DEBUG_getIDs());
				return sb.toString();
			}
		
		protected ReferenceID<Lab>	lab;
	}

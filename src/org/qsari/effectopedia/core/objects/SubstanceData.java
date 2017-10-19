package org.qsari.effectopedia.core.objects;

import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.ids.ReferenceID;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.quantification.DataTemplates;
import org.qsari.effectopedia.defaults.DefaultDataTemplates;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.system.ActionTypes;

public class SubstanceData extends EffectopediaObject implements Importable, Exportable, Cloneable, Traceable, Titleable
	{
		
		public SubstanceData()
			{
				super();
				this.initiator = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REFERENCE_I);
				this.substance = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REFERENCE_S);
				this.test = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REFERENCE_T);
				this.objectProperties = DefaultEffectopediaObjects.buildingDefaultObjects ? DefaultEffectopediaObjects.DEFAULT_D_RESP_DATA : DefaultEffectopediaObjects.DEFAULT_D_RESP_DATA.clone(this, null);
				this.templates = DefaultDataTemplates.DTS_DR_SINGLE_CHEM_ALL.clone();
				this.templates.setProperties(objectProperties);
				this.templates.setOwner(this);
			}
		
		public SubstanceData(Test test, Initiator initiator, DataSource dataSource)
			{
				super(initiator, dataSource);
				this.initiator = DefaultEffectopediaObjects.DEFAULT_REFERENCE_I.clone(this, dataSource);
				this.initiator.set(initiator);
				this.substance = DefaultEffectopediaObjects.DEFAULT_REFERENCE_S.clone(this, dataSource);
				this.test = DefaultEffectopediaObjects.DEFAULT_REFERENCE_T.clone(this, dataSource);
				this.test.set(test);
				test.getSubstanceDataIDs().add(this);
				this.objectProperties = DefaultEffectopediaObjects.DEFAULT_D_RESP_DATA.clone(this, dataSource);
				this.templates = DefaultDataTemplates.DTS_DR_SINGLE_CHEM_ALL.clone();
				this.templates.setProperties(objectProperties);
				this.templates.setOwner(this);
			}
		
		public SubstanceData(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				this.initiator = DefaultEffectopediaObjects.DEFAULT_REFERENCE_I.clone(this, dataSource);
				this.substance = DefaultEffectopediaObjects.DEFAULT_REFERENCE_S.clone(this, dataSource);
				this.test = DefaultEffectopediaObjects.DEFAULT_REFERENCE_T.clone(this, dataSource);
				this.objectProperties = DefaultEffectopediaObjects.DEFAULT_D_RESP_DATA.clone(this, dataSource);
				this.templates = DefaultDataTemplates.DTS_DR_SINGLE_CHEM_ALL.clone();
				this.templates.setProperties(objectProperties);
				this.templates.setOwner(this);
			}
		
		@Override
		public void init(boolean asDefaultObject)
			{
				this.substance = DefaultEffectopediaObjects.buildingDefaultObjects ? DefaultEffectopediaObjects.DEFAULT_REFERENCE_S : DefaultEffectopediaObjects.DEFAULT_REFERENCE_S.clone(this, dataSource);
				this.objectProperties = DefaultEffectopediaObjects.buildingDefaultObjects ? DefaultEffectopediaObjects.DEFAULT_D_RESP_DATA : DefaultEffectopediaObjects.DEFAULT_D_RESP_DATA.clone(this, dataSource);
				this.templates = DefaultDataTemplates.DTS_DR_SINGLE_CHEM_ALL.clone();
				this.templates.setProperties(objectProperties);
				this.templates.setOwner(this);
				updateParenthood();
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				containedIDs.put(initiator.getID(), initiator);
				containedIDs.put(substance.getID(), substance);
				containedIDs.put(test.getID(), test);
				if (objectProperties != null)
					objectProperties.getContainedIDs(containedIDs);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				containedIDs.put(initiator.getExternalID(), initiator);
				containedIDs.put(substance.getExternalID(), substance);
				containedIDs.put(test.getExternalID(), test);
				if (objectProperties != null)
					objectProperties.getContainedExternalIDs(containedIDs);
			}
		
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				initiator = EffectopediaObject.cloneIfInDefaultObjects(initiator, this, dataSource);
				substance = EffectopediaObject.cloneIfInDefaultObjects(substance, this, dataSource);
				test = EffectopediaObject.cloneIfInDefaultObjects(test, this, dataSource);
			}
		
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (initiator != null)
					initiator.process(batch);
				if (substance != null)
					substance.process(batch);
				if (test != null)
					test.process(batch);
			}
		
		public void updateParenthood()
			{
				super.updateParenthood();
				initiator = EffectopediaObject.updateParent(initiator, this);
				if (substance != null)
					substance = EffectopediaObject.updateParent(substance, this);
				test = EffectopediaObject.updateParent(test, this);
			}
		
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				initiator = dataSource.get(initiator.getClass(), initiator.getID());
				substance = dataSource.get(substance.getClass(), substance.getID());
				test = dataSource.get(test.getClass(), test.getID());
				if (templates != null)
					templates.setOwner(dataSource.get(this.getClass(), this.getID()));
				if (objectProperties != null)
					objectProperties.setOwner(dataSource.get(this.getClass(), this.getID()));
			}
		
		public ReferenceID<Test> getTest()
			{
				return test;
			}
		
		@Override
		public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if (eoDestintation instanceof SubstanceData)
					{
						if (assignContainedEO)
							{
								if (this.test != null)
									this.test.assignFieldsTo(((SubstanceData) eoDestintation).getTest(), assignContainedEO);
								else if (((SubstanceData) eoDestintation).getTest() != null)
									((SubstanceData) eoDestintation).getTest().set(null);
								if (this.initiator != null)
									this.initiator.assignFieldsTo(((SubstanceData) eoDestintation).getInitiator(), assignContainedEO);
								else if (((SubstanceData) eoDestintation).getInitiator() != null)
									((SubstanceData) eoDestintation).getInitiator().set(null);
								if (this.substance != null)
									this.substance.assignFieldsTo(((SubstanceData) eoDestintation).getSubstance(), assignContainedEO);
								else if (((SubstanceData) eoDestintation).getSubstance() != null)
									((SubstanceData) eoDestintation).getSubstance().set(null);
							}
						if (this.objectProperties != null)
							((SubstanceData) eoDestintation).objectProperties = this.objectProperties.clone(eoDestintation, dataSource);
						else
							((SubstanceData) eoDestintation).objectProperties = null;
						if (this.templates != null)
							{
								((SubstanceData) eoDestintation).templates = this.templates.clone();
								if (((SubstanceData) eoDestintation).objectProperties != null)
									{
										((SubstanceData) eoDestintation).templates.setTypes(((SubstanceData) eoDestintation).objectProperties.getTypes());
										((SubstanceData) eoDestintation).templates.setProperties(((SubstanceData) eoDestintation).objectProperties);
									}
								((SubstanceData) eoDestintation).templates.setOwner(eoDestintation);
							}
					}
			}
		
		public void cloneFieldsTo(SubstanceData clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				if (this.test != null)
					clone.test = this.test.clone(clone, dataSource);
				else
					clone.test = null;
				if (this.initiator != null)
					clone.initiator = this.initiator.clone(clone, dataSource);
				else
					clone.initiator = null;
				if (this.substance != null)
					clone.substance = this.substance.clone(clone, dataSource);
				else
					clone.substance = null;
				if (this.objectProperties != null)
					clone.objectProperties = this.objectProperties.clone(clone, dataSource);
				else
					clone.objectProperties = null;
				if (this.templates != null)
					{
						clone.templates = this.templates.clone();
						if (clone.objectProperties != null)
							{
								clone.templates.setTypes(clone.objectProperties.getTypes());
								clone.templates.setProperties(clone.objectProperties);
							}
						clone.templates.setOwner(clone);
					}
			}
		
		@Override
		public SubstanceData clone()
			{
				SubstanceData clone = new SubstanceData(null, dataSource);
				cloneFieldsTo(clone, dataSource);
				clone.setParent(parent);
				return clone;
			}
		
		@Override
		public SubstanceData clone(EffectopediaObject parent, DataSource dataSource)
			{
				SubstanceData clone = new SubstanceData(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						initiator = io.load(ReferenceID.class, initiator, element.getChild("substance"));
						substance = io.load(ReferenceID.class, substance, element.getChild("tested_substance"));
						if (substance == null)
							this.substance = DefaultEffectopediaObjects.DEFAULT_REFERENCE_S.clone(this, dataSource);
						test = io.load(ReferenceID.class, test, element.getChild("test"));
						objectProperties.load(element.getChild("summary_data"), io);
						objectProperties.setOwner(this);
						templates.load(element.getChild("data_templates"), io);
						templates.setProperties(objectProperties);
						// System.out.println("###0"+objectProperties.DEBUG_getSummary());
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
				initiator.updateExternalID(element.getChild("substance"));
				substance.updateExternalID(element.getChild("tested_substance"));
				test.updateExternalID(element.getChild("test"));
				if (objectProperties != null)
					objectProperties.updateExternalID(element.getChild("summary_data"));
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addChild(initiator.store(io.newElement("substance"), io));
				element.addChild(substance.store(io.newElement("tested_substance"), io));
				element.addChild(test.store(io.newElement("test"), io));
				if (objectProperties != null)
					element.addChild(objectProperties.store(io.newElement("summary_data"), io));
				if (templates != null)
					element.addChild(templates.store(io.newElement("data_templates"), io));
				return element;
			}
		
		public boolean hasIncommingAssociations()
			{
				return initiator.getCachedObject() != null;
			}
		
		public boolean hasOutgoingAssociations()
			{
				return test.getCachedObject() != null;
			}
		
		public String DEBUG_getIDs()
			{
				StringBuilder sb = new StringBuilder();
				sb.append(super.DEBUG_getIDs());
				sb.append("\tinitiator\t");
				if (initiator != null)
					sb.append(initiator.DEBUG_getIDs());
				sb.append("\tsubstance\t");
				if (substance != null)
					sb.append(substance.DEBUG_getIDs());
				sb.append("\teffect\t");
				if (test != null)
					sb.append(test.DEBUG_getIDs());
				return sb.toString();
			}
		
		public String toString()
			{
				if ((initiator != null) && (initiator.getCachedObject() != null))
					return initiator.getCachedObject().getTitle() + " (" + getIDandExternalID() + ")";
				return "(" + getIDandExternalID() + ")";
			}
		
		public String getTitle()
			{
				if (initiator != null)
					return initiator.getCachedObject().getTitle();
				return null;
			}
		
		public void setTitle(String title)
			{
				if (initiator != null)
					initiator.getCachedObject().setTitle(title);
			}
		
		public void setObjectPropertiesAndKeepItDefault(ObjectProperties defaultDoseResposeData)
			{
				objectProperties = defaultDoseResposeData;
				this.objectProperties.setOwner(this);
				this.templates.setProperties(objectProperties);
			}
		
		public final ObjectProperties getObjectProperties()
			{
				return objectProperties;
			}
		
		public final void setObjectProperties(ObjectProperties objectProperties)
			{
				if (this.objectProperties != objectProperties)
					beforeUpdate(true, ActionTypes.SUBSTANCE_DATA);
				this.objectProperties = objectProperties;
				this.objectProperties.setOwner(this);
				this.templates.setProperties(objectProperties);
			}
		
		public final void setTest(ReferenceID<Test> test)
			{
				this.test = test;
			}
		
		public ReferenceID<Initiator> getInitiator()
			{
				return initiator;
			}
		
		public final void setInitiator(ReferenceID<Initiator> initiator)
			{
				this.initiator = initiator;
			}
		
		public DataTemplates getTemplates()
			{
				return templates;
			}
		
		public void setTemplates(DataTemplates templates)
			{
				this.templates = templates;
			}
		
		public ReferenceID<Substance> getSubstance()
			{
				return substance;
			}
		
		public void setSubstance(ReferenceID<Substance> substance)
			{
				this.substance = substance;
			}
		
		protected DataTemplates										templates;
		protected ObjectProperties							objectProperties;
		protected ReferenceID<Test>						test;
		protected ReferenceID<Initiator>	initiator;
		protected ReferenceID<Substance>	substance;
	}

package org.qsari.effectopedia.core.objects;

import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.ids.ReferenceID;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.interfaces.IdentifiableConstituent;
import org.qsari.effectopedia.data.objects.DataUnit;
import org.qsari.effectopedia.data.objects.DataValue_Double;
import org.qsari.effectopedia.data.objects.DataValue_Interval;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public class Constituent extends EffectopediaObject implements IdentifiableConstituent
	{
		public static enum ConstituentType
			{
				CONSTITUENT(0, "Constituent"), IMPURITY(1, "Impurity");
				
				ConstituentType(int code, String caption)
					{
						this.code = code;
						this.caption = caption;
					}
				
				public String toString()
					{
						return caption;
					}
				
				public int getCode()
					{
						return code;
					}
				
				private final int				code;
				private final String	caption;
			}
		
		public Constituent()
			{
				typical = PURE;
				structure = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_CONST_REFCHEM);
				actualRange = new DataValue_Interval<DataValue_Double>(null);
				actualRange.setIntervalValue(PURE, PURE);
			}
		
		public Constituent(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				typical = PURE;
				structure = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_CONST_REFCHEM);
				actualRange = new DataValue_Interval<DataValue_Double>(null);
				actualRange.setIntervalValue(PURE, PURE);
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				containedIDs.put(structure.getID(), structure);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				containedIDs.put(structure.getExternalID(), structure);
			}
		
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				structure = EffectopediaObject.cloneIfInDefaultObjects(structure, this, dataSource);
			}
		
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (structure != null)
					structure.process(batch);
			}
		
		public void updateParenthood()
			{
				super.updateParenthood();
				structure = EffectopediaObject.updateParent(structure, this);
			}
		
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				structure = dataSource.get(structure.getClass(), structure.getID());
			}
		
		@Override
		public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if (eoDestintation instanceof Constituent)
					{
						((Constituent) eoDestintation).setConstituentType(this.constituentType);
						((Constituent) eoDestintation).typical.setValue(this.typical.getValue());
						((Constituent) eoDestintation).actualRange.setValue(this.actualRange.getValue());
						((Constituent) eoDestintation).rangeUnit.setCaption(this.rangeUnit.getCaption());
						if (assignContainedEO)
							this.structure.assignFieldsTo(((Constituent) eoDestintation), assignContainedEO);
					}
			}
		
		public void cloneFieldsTo(Constituent clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.constituentType = this.constituentType;
				if (structure != null)
					clone.structure = this.structure.clone(clone, dataSource);
				if (typical != null)
					clone.typical = this.typical.clone();
				if (actualRange != null)
					clone.actualRange = this.actualRange.clone();
				if (rangeUnit != null)
					clone.rangeUnit = this.rangeUnit.clone();
			}
		
		@Override
		public Constituent clone()
			{
				Constituent clone = new Constituent(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		@Override
		public Constituent clone(EffectopediaObject parent, DataSource dataSource)
			{
				Constituent clone = new Constituent(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void setStructureAndKeepItDefault(Initiator_ChemicalStructure chemicalStructure)
			{
				this.structure.setAndKeepItDefault(chemicalStructure);
			}
		
		public Initiator_ChemicalStructure getStructure()
			{
				return structure.getCachedObject();
			}
		
		public void setStructure(Initiator_ChemicalStructure structure)
			{
				this.structure.set(structure);
			}
		
		public String getTypical()
			{
				if (typical != null)
					return typical.getDisplayValue() + "%";
				else
					return "%";
			}
		
		public void setTypical(String typical)
			{
				if ((typical != null) && (typical.length() > 0))
					{
						int lastDigit = typical.indexOf("%");
						if (lastDigit == -1)
							lastDigit = typical.length();
						if ((this.typical == null) || (this.typical == PURE))
							this.typical = new DataValue_Double(null);
						this.typical.parseString(typical.substring(0, lastDigit));
					}
			}
		
		public String getActualRange()
			{
				if (actualRange != null)
					return actualRange.getDisplayValue() + "%";
				else
					return "[,]%";
			}
		
		public void setActualRange(String actualRange)
			{
				if ((this.actualRange == null) || (this.actualRange.getValue().lowerBoundary == PURE))
					this.actualRange.setIntervalValue(new DataValue_Double(null), new DataValue_Double(null));
				this.actualRange.parseString(actualRange.replaceAll("\\%", ""));
			}
		
		public ConstituentType getConstituentType()
			{
				return constituentType;
			}
		
		public void setConstituentType(ConstituentType constituentType)
			{
				this.constituentType = constituentType;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						BaseIOAttribute constitType = element.getAttribute("type");
						if (constitType != null)
							this.constituentType = ConstituentType.valueOf(constitType.getValue());
						structure = io.load(ReferenceID.class, structure, element.getChild("structure"));
						if ((this.typical == null) || (this.typical == PURE))
							this.typical = new DataValue_Double(null);
						typical.load(element.getChild("typical_percent"), io);
						if ((this.actualRange == null) || (this.actualRange.getValue().lowerBoundary == PURE))
							this.actualRange.setIntervalValue(new DataValue_Double(null), new DataValue_Double(null));
						actualRange.load(element.getChild("actual_range"), io);
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
				structure.updateExternalID(element.getChild("structure"));
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.setAttribute("type", constituentType.name());
				element.addChild(structure.store(io.newElement("structure"), io));
				element.addChild(typical.store(io.newElement("typical_percent"), io));
				element.addChild(actualRange.store(io.newElement("actual_range"), io));
				return element;
			}
		
		public static final ConstituentType[]														ConstituentTypes	= new ConstituentType[]
																																																																							{ ConstituentType.CONSTITUENT, ConstituentType.IMPURITY };
		protected ConstituentType																										constituentType		= ConstituentType.CONSTITUENT;
		protected ReferenceID<Initiator_ChemicalStructure>	structure;
		protected DataValue_Double																									typical;
		protected DataUnit																																	unit;
		protected DataValue_Interval<DataValue_Double>					actualRange;
		protected DataUnit																																	rangeUnit;
		public final DataValue_Double																						PURE													= (DataValue_Double) (new DataValue_Double(null)).setValue(100D);	;
	}

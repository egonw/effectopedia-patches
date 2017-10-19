package org.qsari.effectopedia.data.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.interfaces.AssignableValueAndUnit;
import org.qsari.effectopedia.data.interfaces.IdentifiableObjectPropertyMultivalued;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented.Documented_Value;

public class ObjectPropertyMultivalued extends ObjectProperty implements Importable, Exportable, Cloneable, IdentifiableObjectPropertyMultivalued
	{
		protected ObjectPropertyMultivalued()
			{
				super();
			}
		
		public ObjectPropertyMultivalued(EffectopediaObject owner, ObjectPropertyType type)
			{
				super(owner, type);
				pairs = new ArrayList<ValueAndUnit>();
				pairs.add(vu);
			}
		
		public void cloneFieldsTo(ObjectPropertyMultivalued clone)
			{
				clone.type = this.type;
				if (IndexedObject.ID_OFFSET != 0)
					clone.type.setExternalID(0);
				clone.pairs.clear();
				for (ValueAndUnit pair : pairs)
					clone.pairs.add(pair.clone(clone));
				if (pairs.size() > 0)
					clone.vu = clone.pairs.get(0);
				else
					clone.vu = this.vu.clone(clone);
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				type.getContainedIDs(containedIDs, true);
			}
		
		public void getContainedEffectopediaObjects(ArrayList<EffectopediaObject> list)
			{
				list.add(type);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				type.getContainedExternalIDs(containedIDs);
			}
		
		public ObjectPropertyMultivalued clone()
			{
				ObjectPropertyMultivalued clone = new ObjectPropertyMultivalued(this.owner, this.type);
				cloneFieldsTo(clone);
				return clone;
			}
		
		public ObjectPropertyMultivalued clone(EffectopediaObject owner)
			{
				ObjectPropertyMultivalued clone = new ObjectPropertyMultivalued(owner, this.type);
				cloneFieldsTo(clone);
				return clone;
			}
		
		@Override
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						BaseIOElement type = element.getChild("type");
						if (type != null)
							this.type = (ObjectPropertyType) io.load(ObjectPropertyType.class, null, type);
						BaseIOElement entries = element.getChild("entries");
						if (entries != null)
							{
								int count = Integer.parseInt(entries.getAttributeValue("count"));
								List<BaseIOElement> children = entries.getChildren();
								if ((count != 0) && (children != null) && (children.size() == count))
									{
										Iterator<BaseIOElement> iterator = children.iterator();
										BaseIOElement entry = iterator.next();
										vu.load(entry, io);
										while (iterator.hasNext())
											{
												entry = iterator.next();
												ValueAndUnit vuPair = add();
												vuPair.load(entry, io);
											}
										// Compatibility with legacy code, providing one subProperties for the
										// whole ObjectProperty compared to the new which supports one
										// subProperties per value pair (loaded in the code above)
										BaseIOElement subProp = element.getChild("sub_properties");
										if (subProp != null)
											{
												ObjectProperties subProperties = new ObjectProperties(owner, this.type.getSubPropertyTypes());
												subProperties.load(subProp, io);
												for (ValueAndUnit pair : pairs)
													pair.setSubProperties(subProperties.clone(owner, owner.getDataSource()));
											}
										// end of legacy compatibility code
									}
								else
									clearValuePairs();
							}
						else
							vu.load(element, io);
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				type.updateExternalID(element.getChild("type"));
			}
		
		@Override
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				if (type != null)
					element.addChild(type.store(io.newElement("type"), io));
				if (pairs.size() == 1)
					vu.store(element, io);
				else
					{
						BaseIOElement entries = io.newElement("entries");
						entries.setAttribute("count", String.valueOf(pairs.size()));
						for (ValueAndUnit entry : pairs)
							entries.addChild(entry.store(io.newElement("entry"), io));
						element.addChild(entries);
					}
				return element;
			}
		
		/*
		 * public DataValue<?> getValue(int index) { return pairs.get(index).value; }
		 * 
		 * public void setValue(DataValue<?> value, int index) { ValueAndUnit pair =
		 * type.acceptingMultipleValues ? pairs.get(index) : vu; if (((value.value ==
		 * null) && (pair.value != null)) || (!value.equals(pair.value)))
		 * owner.beforeUpdate(true, type.actionTypeID); pair.value = value; }
		 * 
		 * public void setValue(String value, int index) { ValueAndUnit pair =
		 * pairs.get(index); pair.setValue(value); }
		 * 
		 * public String getDisplayValue(int index) { ValueAndUnit pair =
		 * pairs.get(index); return pair.getDisplayValue(); }
		 * 
		 * public String getDisplayUnit(int index) { ValueAndUnit pair =
		 * pairs.get(index); return pair.getDisplayUnit(); }
		 * 
		 * public DataUnit getUnit(int index) { return pairs.get(index).unit; }
		 * 
		 * public void setUnit(DataUnit unit, int index) { pairs.get(index).unit =
		 * unit; }
		 * 
		 * public void setUnit(String unit, int index) { ValueAndUnit pair =
		 * pairs.get(index); pair.setUnit(unit); }
		 */
		public ValueAndUnit getValueAndUnitPair(int index)
			{
				return pairs.get(index);
			}
		
		@Override
		public void add(AssignableValueAndUnit pair)
			{
				if (pair instanceof ValueAndUnit)
					{
						if (pairs.size() == 0)
							vu = (ValueAndUnit) pair;
						pairs.add((ValueAndUnit) pair);
					}
			}
		
		public boolean remove(int index)
			{
				int count = pairs.size();
				if ((index >= 0) && (index <= count - 1))
					{
						pairs.remove(index);
						if (index == 0)
							vu = (count == 1) ? null : pairs.get(0);
						return true;
					}
				return false;
			}
		
		public ValueAndUnit add()
			{
				ValueAndUnit newPair = new ValueAndUnit();
				if (pairs.size() == 0)
					vu = (ValueAndUnit) newPair;
				pairs.add(newPair);
				return newPair;
			}
		
		public ValueAndUnit insert(int index)
			{
				ValueAndUnit newPair = new ValueAndUnit();
				if (pairs.size() == 0)
					vu = (ValueAndUnit) newPair;
				pairs.add(index, newPair);
				return newPair;
			}
		
		public void add(int count)
			{
				for (int i = count; i > 0; i--)
					pairs.add(new ValueAndUnit());
				if ((pairs.size() == count) && (count > 0))
					vu = (ValueAndUnit) pairs.get(0);
			}
		
		public void clearValuePairs()
			{
				pairs.clear();
			}
		
		public int valuesCount()
			{
				return pairs.size();
			}
		
		@Override
		public void setUnit(String unit)
			{
				for (ValueAndUnit pair : pairs)
					pair.setUnit(unit);
			}
		
		@Override
		public String DEBUG_getSummary()
			{
				StringBuilder sb = new StringBuilder();
				for (ValueAndUnit pair : pairs)
					{
						sb.append(pair.getDisplayValue());
						sb.append(" ");
					}
				sb.append(getDisplayUnit());
				return sb.toString();
			}
		
		public double[] getValuesAsDouble()
			{
				double[] values = new double[pairs.size()];
				for (int i = pairs.size() - 1; i >= 0; i--)
					{
						DataValue<?> value = ((Documented_Value) pairs.get(i)).value;
						values[i] = (value == null) ? Double.NaN : value.getAsDouble();
					}
				return values;
			}
		
		public void sort(Comparator<ValueAndUnit> comparator)
			{
				this.comparator = comparator;
				Collections.sort(pairs, comparator);
			}
		
		public boolean assingFrom(ObjectProperty op)
			{
				boolean possible = op.type == type;
				if (possible)
					{
						pairs.clear();
						for (ValueAndUnit pair : ((ObjectPropertyMultivalued) op).pairs)
							pairs.add(pair.clone(this));
						if (pairs.size() > 0)
							vu = pairs.get(0);
					}
				return possible;
			}
		
		public ValueAndUnit[] getValuePairs()
			{
				return pairs.toArray(new ValueAndUnit[pairs.size()]);
			}
		
		protected ArrayList<ValueAndUnit>	pairs;
	}

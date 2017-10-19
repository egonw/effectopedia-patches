package org.qsari.effectopedia.data.objects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.interfaces.AssignableValueAndUnit;
import org.qsari.effectopedia.data.interfaces.IdentifiableObjectProperty;
import org.qsari.effectopedia.data.interfaces.IdentifiableObjectPropertyType;
import org.qsari.effectopedia.data.interfaces.StringableDataValue;
import org.qsari.effectopedia.defaults.DefaultTextProperties;
import org.qsari.effectopedia.search.SearchableItem;

public class ObjectProperty implements Importable, Exportable, Cloneable, IdentifiableObjectProperty, Titleable
	{
		
		public class ValueAndUnit implements Importable, Exportable, AssignableValueAndUnit, Comparable<ValueAndUnit>
			{
				protected DataValue<?>					value;
				protected DataUnit									unit;
				protected ObjectProperties	subProperties;
				protected boolean										generic	= true;
				
				public void assign(AssignableValueAndUnit vu)
					{
						setValue(vu.getDisplayValue());
						setUnit(vu.getDisplayUnit());
						generic = false;
					}
				
				public ValueAndUnit assign(String[] doc_val)
					{
						if (doc_val.length != 2)
							return this;
						setValue(doc_val[0]);
						setUnit(doc_val[1]);
						generic = false;
						return this;
					}
				
				public ValueAndUnit clone(ObjectProperty op)
					{
						ValueAndUnit clone = op.new ValueAndUnit();
						clone.value = (value != null) ? this.value.clone() : null;
						clone.unit = (unit != null) ? this.unit.clone() : null;
						clone.subProperties = (subProperties != null) && (op.getOwner() != null) ? this.subProperties.clone(op.getOwner(), op.getOwner().getDataSource()) : null;
						clone.generic = this.generic;
						return clone;
					}
				
				public void load(BaseIOElement element, BaseIO io)
					{
						if (element != null)
							{
								this.value = loadBaseTypeValue(this.value, "value", element, io);
								this.unit = loadUnit(this.unit, "unit", element, io);
								BaseIOElement subProp = element.getChild("sub_properties");
								if (subProp != null)
									{
										subProperties = new ObjectProperties(owner, type.getSubPropertyTypes());
										subProperties.load(subProp, io);
									}
								
							}
					}
				
				protected final DataValue<?> loadBaseTypeValue(DataValue<?> value, String name, BaseIOElement element, BaseIO io)
					{
						BaseIOElement val = element.getChild(name);
						if ((val != null) && (val.getValue().length() != 0))
							{
								if (value == null)
									value = DataValue.newValue(getSearchableItem(), type.baseValueType, type.fixedValuesList);
								value.load(val, io);
							}
						return value;
					}
				
				protected final DataUnit loadUnit(DataUnit unit, String name, BaseIOElement element, BaseIO io)
					{
						BaseIOElement u = element.getChild(name);
						if (u != null)
							if (unit == null)
								unit = new DataUnit(u.getChildValue("caption"));
							else
								unit.setCaption(u.getChildValue("caption"));
						return unit;
					}
				
				public void updateExternalID(BaseIOElement element)
					{
						BaseIOElement subProp = element.getChild("sub_properties");
						if ((subProperties != null) && (subProp != null))
							subProperties.updateExternalID(subProp);
					}
				
				public BaseIOElement store(BaseIOElement element, BaseIO io)
					{
						if ((value != null) && (value.toString() != null) && (value.toString().length() > 0))
							element.addChild(value.store(io.newElement("value"), io));
						if (unit != null)
							element.addChild(unit.store(io.newElement("unit"), io));
						if (subProperties != null)
							element.addChild(subProperties.store(io.newElement("sub_properties"), io));
						return element;
					}
				
				@Override
				public StringableDataValue<?> getValue()
					{
						return value;
					}
				
				@Override
				public void setValue(String value)
					{
						boolean different = ((value == null) && (this.value != null)) || ((this.value == null) && (value != null));
						if ((value != null) && (this.value != null))
							different = !(value.equals(this.value.toString()));
						if (different)
							{
								if (owner != null)
									owner.beforeUpdate(true, type.actionTypeID);
								if (value != null)
									{
										if (this.value == null)
											this.value = DataValue.newValue(getSearchableItem(), type.baseValueType, type.fixedValuesList);
										this.value.parseString(value);
									}
								else
									this.value = null;
								generic = false;
							}
					}
				
				@Override
				public String getDisplayValue()
					{
						if (this.value == null)
							return DefaultTextProperties.INSTANCE.getDefault(type.getFullName());
						else
							return this.value.getDisplayValue();
					}
				
				public Double getDoubleValue()
					{
						if (this.value == null)
							return null;
						else
							return this.value.getAsDouble();
					}
				
				public void setDoubleValue(Double newValue)
					{
						boolean different = ((newValue == null) && (this.value != null)) || ((this.value == null) && (newValue != null)) || !(newValue.equals(this.value.toString()));
						if (different)
							{
								if (owner != null)
									owner.beforeUpdate(true, type.actionTypeID);
								if (newValue != null)
									{
										if (this.value == null)
											this.value = DataValue.newValue(getSearchableItem(), type.baseValueType, type.fixedValuesList);
										this.value.setFromDouble(newValue);
									}
								else
									this.value = null;
								generic = false;
							}
					}
				
				@Override
				public String getDisplayUnit()
					{
						return this.unit == null ? "" : this.unit.getCaption();
					}
				
				@Override
				public DataUnit getUnit()
					{
						return unit;
					}
				
				@Override
				public void setUnit(String unit)
					{
						boolean different = ((unit == null) && (this.unit != null)) || (this.unit == null) && (unit != null);
						if ((unit != null) && (this.unit != null))
							different = !(unit.equals(this.unit.getCaption()));
						if (different)
							{
								if (owner != null)
									owner.beforeUpdate(true, type.actionTypeID);
								if (this.unit == null)
									this.unit = new DataUnit(unit);
								else
									this.unit.setCaption(unit);
								generic = false;
							}
					}
				
				public boolean hasUnit()
					{
						return this.unit != null;
					}
				
				@Override
				public int compareTo(ValueAndUnit otherValue)
					{
						return comparator.compare(this, otherValue);
					}
				
				public ObjectProperties getSubProperties()
					{
						return subProperties;
					}
				
				public void setSubProperties(ObjectProperties subProperties)
					{
						this.subProperties = subProperties;
					}
				
				public void createSubProperties()
					{
						this.subProperties = new ObjectProperties(owner, type.getSubPropertyTypes());
					}
			}
		
		protected ObjectProperty()
			{
				super();
				
			}
		
		public ObjectProperty(EffectopediaObject owner, ObjectPropertyType type)
			{
				super();
				vu = new ValueAndUnit();
				this.owner = owner;
				this.type = type;
				if ((type != null) && (type.getSubPropertyTypes() != null))
					vu.subProperties = new ObjectProperties(owner, type.getSubPropertyTypes());
				vu.unit = (type != null) ? type.defaultUnit : null;
			}
		
		public void cloneFieldsTo(ObjectProperty clone)
			{
				clone.type = this.type;
				if (IndexedObject.ID_OFFSET != 0)
					clone.type.setExternalID(0);
				clone.vu = this.vu.clone(clone);
				if (this.vu.subProperties != null)
					clone.vu.subProperties = this.vu.subProperties.clone(clone.getOwner(), clone.getOwner().getDataSource());
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
		
		public ObjectProperty clone()
			{
				ObjectProperty clone = new ObjectProperty(this.owner, this.type);
				cloneFieldsTo(clone);
				return clone;
			}
		
		public ObjectProperty clone(EffectopediaObject owner)
			{
				ObjectProperty clone = new ObjectProperty(owner, this.type);
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
				vu.store(element, io);
				return element;
			}
		
		public SearchableItem getSearchableItem()
			{
				if ((type.searchable) && (searchableItem == null))
					searchableItem = new SearchableItem(owner, type.propertyID, type.searchName);
				return searchableItem;
			}
		
		public void setSearchableItem(SearchableItem searchableItem)
			{
				this.searchableItem = searchableItem;
			}
		
		public EffectopediaObject getOwner()
			{
				return owner;
			}
		
		public DataValue<?> getValue()
			{
				return vu.value;
			}
		
		public void setValue(DataValue<?> value)
			{
				if ((owner != null) && ((vu.value != null)) || (!value.equals(vu.value)))
					owner.beforeUpdate(true, type.actionTypeID);
				vu.value = (DataValue<?>) value;
			}
		
		public void setValue(String value)
			{
				vu.setValue(value);
			}
		
		public String getDisplayValue()
			{
				return vu.getDisplayValue();
			}
		
		public String getDisplayUnit()
			{
				return vu.getDisplayUnit();
			}
		
		public DataUnit getUnit()
			{
				return vu.unit;
			}
		
		public void setUnit(DataUnit unit)
			{
				vu.unit = (DataUnit) unit;
			}
		
		public void setUnit(String unit)
			{
				vu.setUnit(unit);
			}
		
		@Override
		public IdentifiableObjectPropertyType getType()
			{
				return type;
			}
		
		public ValueAndUnit getValueAndUnit()
			{
				return vu;
			}
		
		public int valuesCount()
			{
				return 1;
			}
		
		@Override
		public String getTitle()
			{
				if (vu != null)
					return (vu.unit != null ? vu.getDisplayValue() + " " + vu.unit.caption : vu.getDisplayValue());
				else
					return "";
			}
		
		@Override
		public void setTitle(String title)
			{
				// TODO
			}
		
		public String DEBUG_getSummary()
			{
				StringBuilder sb = new StringBuilder();
				sb.append(getDisplayValue());
				sb.append(" ");
				sb.append(getDisplayUnit());
				return sb.toString();
			}
		
		public static class ValueComparator implements Comparator<ValueAndUnit>
			{
				public static final Comparator	comparator	= new ValueComparator();
				
				private ValueComparator()
					{
						super();
					}
				
				public int compare(ValueAndUnit value1, ValueAndUnit value2)
					{
						if ((value1 == null) || (value2 == null))
							return 0;
						else
							return ((DataValue<?>) value1.getValue()).compareTo(value2.getValue());
					}
			}
		
		public boolean assingFrom(ObjectProperty op)
			{
				boolean possible = op.type == type;
				if (possible)
					vu = op.vu.clone(this);
				return possible;
			}
		
		public ValueAndUnit[] getValuePairs()
			{
				return new ValueAndUnit[]
					{ vu };
			}
		
		public void setOwner(EffectopediaObject owner)
			{
				this.owner = owner;
				if (searchableItem!=null)
					searchableItem.setObject(owner);
				if (vu.subProperties != null)
					vu.subProperties.setOwner(owner);
			}
		
		protected Comparator									comparator					= ValueComparator.comparator;
		
		protected ObjectPropertyType	type;
		protected SearchableItem					searchableItem	= null;
		protected EffectopediaObject	owner;
		protected ValueAndUnit							vu;
	}

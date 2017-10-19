package org.qsari.effectopedia.data.objects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.interfaces.AssignableDocumentedValue;
import org.qsari.effectopedia.data.interfaces.IdentifiableDescriptorType;
import org.qsari.effectopedia.data.interfaces.IdentifiableObjectPropertyDocumented;
import org.qsari.effectopedia.data.interfaces.StringableDataValue;
import org.qsari.effectopedia.defaults.DefaultTextProperties;

public class ObjectPropertyMultivalued_Documented extends ObjectPropertyMultivalued implements IdentifiableObjectPropertyDocumented, Importable, Exportable
	{
		public class Documented_Value extends ValueAndUnit implements Importable, Exportable, AssignableDocumentedValue
			{
				protected DataValue<?>																																										minValue;
				protected DataValue<?>																																										maxValue;
				protected LinkedHashMap<IdentifiableDescriptorType, Descriptor>	descriptors;
				protected String																																																notes;
				protected DataValue_String																																						references;
				
				public Documented_Value()
					{
						descriptors = new LinkedHashMap<IdentifiableDescriptorType, Descriptor>();
						if (type != null)
							{
								DescriptorTypesContainer types = (DescriptorTypesContainer) type.getDescriptors();
								if (types != null)
									for (IdentifiableDescriptorType type : types)
										descriptors.put(type, new Descriptor(type));
							}
					}
				
				public Documented_Value assign(String[] doc_val)
					{
						if (doc_val.length != 6 + 2 * descriptors.size())
							{
								System.err.println("Incorrect number of parameters! Expected " + (6 + 2 * descriptors.size()) + " but found " + doc_val.length);
								return this;
							}
						int index = 0;
						setValue(doc_val[index++]);
						setMinValue(doc_val[index++]);
						setMaxValue(doc_val[index++]);
						setUnit(doc_val[index++]);
						for (IdentifiableDescriptorType dt : type.descriptors)
							{
								Descriptor descr = descriptors.get(dt);
								descr.setValue(doc_val[index++]);
								descr.setUnit(doc_val[index++]);
							}
						notes = doc_val[index++];
						setReferences(doc_val[index]);
						generic = false;
						return this;
					}
				
				@Override
				public Documented_Value clone(ObjectProperty op)
					{
						Documented_Value clone = ((ObjectPropertyMultivalued_Documented) op).new Documented_Value();
						clone.value = (value != null) ? this.value.clone() : null;
						clone.minValue = (minValue != null) ? this.minValue.clone() : null;
						clone.maxValue = (maxValue != null) ? this.maxValue.clone() : null;
						clone.unit = (unit != null) ? this.unit.clone() : null;
						for (Descriptor d : descriptors.values())
							clone.descriptors.put(d.type, d.clone());
						clone.notes = this.notes;
						clone.references = (references != null) ? this.references.clone() : null;
						clone.generic = this.generic;
						clone.subProperties = (subProperties != null)&&(op.getOwner()!=null) ? this.subProperties.clone(op.getOwner(),op.getOwner().getDataSource()) : null;
						return clone;
					}
				
				public void load(BaseIOElement element, BaseIO io)
					{
						if (element != null)
							{
								super.load(element, io);
								minValue = loadBaseTypeValue(minValue, "min_value", element, io);
								maxValue = loadBaseTypeValue(maxValue, "max_value", element, io);
								if (descriptors == null)
									descriptors = new LinkedHashMap<IdentifiableDescriptorType, Descriptor>();
								loadDescriptors(type.getDescriptors(), descriptors, "descriptors", element, io);
								BaseIOElement references = element.getChild("references");
								if (references == null)
									references = element.getChild("reference");
								if ((references != null))
									{
										if (this.references == null)
											this.references = (DataValue_String) DataValue.newValue(getSearchableItem(), DataValue_String.class, null);
										this.references.load(references, io);
									}
								notes = element.getChildValue("notes");
								generic = false;
							}
					}
				
				protected final void loadDescriptors(DescriptorTypesContainer types, LinkedHashMap<IdentifiableDescriptorType, Descriptor> descriptors, String name, BaseIOElement element, BaseIO io)
					{
						if (element == null)
							return;
						BaseIOElement descr = element.getChild(name);
						if (descr == null)
							return;
						descriptors.clear();
						int count = Integer.parseInt(descr.getAttributeValue("count"));
						List<BaseIOElement> children = descr.getChildren();
						if ((count != 0) && (children != null) && (children.size() == count))
							{
								Iterator<BaseIOElement> iterator = children.iterator();
								while (iterator.hasNext())
									{
										BaseIOElement descriptor = iterator.next();
										IdentifiableDescriptorType t = types.getType(descriptor.getName());
										if (t != null)
											{
												Descriptor d = new Descriptor(t);
												d.load(descriptor, io);
												descriptors.put(d.type, d);
											}
									}
							}
						for (IdentifiableDescriptorType type : types)
							if (descriptors.get(type) == null)
								descriptors.put(type, new Descriptor(type));
					}
				
				@Override
				public BaseIOElement store(BaseIOElement element, BaseIO io)
					{
						element = super.store(element, io);
						if ((minValue != null) && (minValue.toString() != null) && (minValue.toString().length() > 0))
							element.addChild(minValue.store(io.newElement("min_value"), io));
						if ((maxValue != null) && (maxValue.toString() != null) && (maxValue.toString().length() > 0))
							element.addChild(maxValue.store(io.newElement("max_value"), io));
						if (this.descriptors != null)
							{
								BaseIOElement desriptors = io.newElement("descriptors");
								desriptors.setAttribute("count", String.valueOf(this.descriptors.size()));
								for (Descriptor d : this.descriptors.values())
									desriptors.addChild(d.store(io.newElement(d.type.getName()), io));
								element.addChild(desriptors);
							}
						if (notes != null)
							element.addValueElement(io.newValue("notes").setData(notes));
						if (references != null)
							element.addChild(references.store(io.newElement("references"), io));
						element.setAttribute("documented", "true");
						return element;
					}
				
				public final DataValue<?> getMinValue()
					{
						return minValue;
					}
				
				public final void setMinValue(DataValue<?> minValue)
					{
						this.minValue = minValue;
						generic = false;
					}
				
				public final void setMinValue(String value)
					{
						boolean different = ((value == null) && (this.minValue != null)) || ((this.minValue == null) && (value != null));
						if ((value != null) && (this.minValue != null))
							different = !(value.equals(this.minValue.toString()));
						if (different)
							{
								if (owner != null)
									owner.beforeUpdate(true, type.actionTypeID);
								if (value != null)
									{
										if (this.minValue == null)
											this.minValue = DataValue.newValue(getSearchableItem(), type.baseValueType, type.fixedValuesList);
										this.minValue.parseString(value);
									}
								else
									this.minValue = null;
							}
						generic = false;
					}
				
				public String getDisplayMinValue()
					{
						if (this.minValue == null)
							return DefaultTextProperties.INSTANCE.getDefault(type.getFullName());
						else
							return this.minValue.getDisplayValue();
					}
				
				public Double getMinValueAsDouble()
					{
						return (this.minValue == null) ? null : this.minValue.getAsDouble();
					}
				
				public void setMinValueFromDouble(Double newValue)
					{
						boolean different = ((newValue == null) && (this.minValue != null)) || ((this.minValue == null) && (newValue != null)) || !(newValue.equals(this.minValue.toString()));
						if (different)
							{
								if (owner != null)
									owner.beforeUpdate(true, type.actionTypeID);
								if (newValue != null)
									{
										if (this.minValue == null)
											this.minValue = DataValue.newValue(getSearchableItem(), type.baseValueType, type.fixedValuesList);
										this.minValue.setFromDouble(newValue);
										;
									}
								else
									this.minValue = null;
							}
					}
				
				public final DataValue<?> getMaxValue()
					{
						return maxValue;
					}
				
				public final void setMaxValue(DataValue<?> maxValue)
					{
						this.maxValue = maxValue;
						generic = false;
					}
				
				public final void setMaxValue(String value)
					{
						boolean different = ((value == null) && (this.maxValue != null)) || ((this.maxValue == null) && (value != null));
						if ((value != null) && (this.maxValue != null))
							different = !(value.equals(this.maxValue.toString()));
						if (different)
							{
								if (owner != null)
									owner.beforeUpdate(true, type.actionTypeID);
								if (value != null)
									{
										if (this.maxValue == null)
											this.maxValue = DataValue.newValue(getSearchableItem(), type.baseValueType, type.fixedValuesList);
										this.maxValue.parseString(value);
									}
								else
									this.maxValue = null;
							}
						generic = false;
					}
				
				public String getDisplayMaxValue()
					{
						if (this.maxValue == null)
							return DefaultTextProperties.INSTANCE.getDefault(type.getFullName());
						else
							return this.maxValue.getDisplayValue();
					}
				
				public Double getMaxValueAsDouble()
					{
						return (this.maxValue == null) ? null : this.maxValue.getAsDouble();
					}
				
				public void setMaxValueFromDouble(Double newValue)
					{
						boolean different = ((newValue == null) && (this.maxValue != null)) || ((this.maxValue == null) && (newValue != null)) || !(newValue.equals(this.maxValue.toString()));
						if (different)
							{
								if (owner != null)
									owner.beforeUpdate(true, type.actionTypeID);
								if (newValue != null)
									{
										if (this.maxValue == null)
											this.maxValue = DataValue.newValue(getSearchableItem(), type.baseValueType, type.fixedValuesList);
										this.maxValue.setFromDouble(newValue);
										;
									}
								else
									this.maxValue = null;
							}
					}
				
				public final Descriptor getDescriptor(IdentifiableDescriptorType type)
					{
						return descriptors.get(type);
					}
				
				public final Descriptor getDescriptor(int index)
					{
						return descriptors.get(type.descriptors.get(index));
					}
				
				public final Collection<Descriptor> getDescriptors()
					{
						return descriptors.values();
					}
				
				public final void addDescriptor(Descriptor descriptor)
					{
						if (descriptor != null)
							this.descriptors.put(descriptor.type, descriptor);
					}
				
				public final void removeDescriptor(DescriptorType descriptorType)
					{
						if (descriptorType != null)
							this.descriptors.remove(descriptorType);
					}
				
				public final void setDescriptors(Collection<Descriptor> descriptors)
					{
						for (Descriptor d : descriptors)
							this.descriptors.put(d.type, d);
					}
				
				public final String getNotes()
					{
						return notes;
					}
				
				public final void setNotes(String notes)
					{
						this.notes = notes;
					}
				
				public void setReferences(String value)
					{
						boolean different = ((value == null) && (this.references != null)) || (this.references == null) && (value != null);
						if ((value != null) && (this.references != null))
							different = !(value.equals(this.references.toString()));
						if (different)
							{
								if (owner != null)
									owner.beforeUpdate(true, type.actionTypeID);
								if (value != null)
									{
										if (this.references == null)
											this.references = (DataValue_String) DataValue.newValue(getSearchableItem(), DataValue_String.class, null);
										this.references.parseString(value);
									}
								else
									this.references = null;
							}
						generic = false;
					}
				
				public String getDisplayConditions()
					{
						return null;
					}
				
				public String getReferences()
					{
						if (references != null)
							return references.getDisplayValue();
						return null;
					}
				
				public boolean isGeneric()
					{
						return generic;
					}
				
				public int compareTo(ValueAndUnit otherValue)
					{
						return comparator.compare(this, otherValue);
					}
				
				public String getDescription()
					{
						if (descriptors.size() > 0)
							{
								StringBuilder sb = new StringBuilder();
								sb.append("(");
								Iterator<Descriptor> it = this.descriptors.values().iterator();
								while (it.hasNext())
									{
										Descriptor d = it.next();
										sb.append(d.type.getName());
										sb.append("=");
										sb.append(d.getDisplayValue());
										sb.append(" ");
										sb.append(d.getDisplayUnit());
										if (it.hasNext())
											sb.append(", ");
									}
								sb.append(")");
								return sb.toString();
							}
						return "";
					}
				
			}
		
		public ObjectPropertyMultivalued_Documented(EffectopediaObject owner, ObjectPropertyType type)
			{
				super();
				this.owner = owner;
				this.type = type;
				vu = new Documented_Value();
				vu.unit = (type != null) ? type.defaultUnit : null;
				pairs = new ArrayList<ValueAndUnit>();
				pairs.add(vu);
				comparator = ValueComparator.comparator;
			}
		
		public ObjectPropertyMultivalued_Documented assign(String[][] values)
			{
				int count = values.length;
		//		System.out.println(count);
		//		System.out.println(values[0].length);
				pairs.clear();
				for (int i = 0; i < count; i++)
					pairs.add(new Documented_Value().assign(values[i]));
				vu = pairs.get(0);
				return this;
			}
		
		public ObjectPropertyMultivalued_Documented clone()
			{
				ObjectPropertyMultivalued_Documented clone = new ObjectPropertyMultivalued_Documented(this.owner, this.type);
				cloneFieldsTo(clone);
				return clone;
			}
		
		public ObjectPropertyMultivalued_Documented clone(EffectopediaObject owner)
			{
				ObjectPropertyMultivalued_Documented clone = new ObjectPropertyMultivalued_Documented(owner, this.type);
				cloneFieldsTo(clone);
				return clone;
			}
		
		public void parseConditions(String conditions)
			{
				
			}
		
		public String getDisplayConditions()
			{
				return type.descriptorsCaption;
			}
		
		public DataValue<?> getMinValue()
			{
				return ((Documented_Value) vu).getMinValue();
			}
		
		public void setMinValue(DataValue<?> minValue)
			{
				((Documented_Value) vu).setMinValue(minValue);
			}
		
		public void setMinValue(String value)
			{
				((Documented_Value) vu).setMinValue(value);
			}
		
		public String getDisplayMinValue()
			{
				return ((Documented_Value) vu).getDisplayMinValue();
			}
		
		public DataValue<?> getMaxValue()
			{
				return ((Documented_Value) vu).getMaxValue();
			}
		
		public void setMaxValue(DataValue<?> MaxValue)
			{
				((Documented_Value) vu).setMaxValue(MaxValue);
			}
		
		public void setMaxValue(String value)
			{
				((Documented_Value) vu).setMaxValue(value);
			}
		
		public String getDisplayMaxValue()
			{
				return ((Documented_Value) vu).getDisplayMaxValue();
			}
		
		public Collection<Descriptor> getDescriptors()
			{
				return ((Documented_Value) vu).getDescriptors();
			}
		
		public void setDescriptors(ArrayList<Descriptor> descriptors)
			{
				((Documented_Value) vu).setDescriptors(descriptors);
			}
		
		public String getNotes()
			{
				return ((Documented_Value) vu).getNotes();
			}
		
		public void setNotes(String notes)
			{
				((Documented_Value) vu).setNotes(notes);
			}
		
		public void setDisplayReferences(String references)
			{
				((Documented_Value) vu).setReferences(references);
			}
		
		public String getDisplayReferences()
			{
				return ((Documented_Value) vu).getReferences();
			}
		
		public StringableDataValue<?> getMinValue(int index)
			{
				Documented_Value pair = (Documented_Value) pairs.get(index);
				return pair.getMinValue();
			}
		
		public void setMinValue(String value, int index)
			{
				Documented_Value pair = (Documented_Value) pairs.get(index);
				pair.setMinValue(value);
			}
		
		public String getDisplayMinValue(int index)
			{
				Documented_Value pair = (Documented_Value) pairs.get(index);
				return pair.getDisplayMinValue();
			}
		
		public StringableDataValue<?> getMaxValue(int index)
			{
				Documented_Value pair = (Documented_Value) pairs.get(index);
				return pair.getMaxValue();
			}
		
		public void setMaxValue(String value, int index)
			{
				Documented_Value pair = (Documented_Value) pairs.get(index);
				pair.setMaxValue(value);
			}
		
		public String getDisplayMaxValue(int index)
			{
				Documented_Value pair = (Documented_Value) pairs.get(index);
				return pair.getDisplayMaxValue();
			}
		
		public Documented_Value getValueAndUnitPair(int index)
			{
				return (Documented_Value) pairs.get(index);
			}
		
		public Documented_Value[] getValuePairs()
			{
				return pairs.toArray(new Documented_Value[pairs.size()]);
			}
		
		@Override
		public Documented_Value add()
			{
				Documented_Value newPair = new Documented_Value();
				if (pairs.size() == 0)
					vu = (Documented_Value) newPair;
				pairs.add(newPair);
				return newPair;
			}
		
		@Override
		public Documented_Value insert(int index)
			{
				Documented_Value newPair = new Documented_Value();
				if (pairs.size() == 0)
					vu = (Documented_Value) newPair;
				pairs.add(index, newPair);
				return newPair;
			}
		
		@Override
		public void add(int count)
			{
				for (int i = count; i > 0; i--)
					pairs.add(new Documented_Value());
				if ((pairs.size() == count) && (count > 0))
					vu = (Documented_Value) pairs.get(0);
			}
		
		@Override
		public void add(AssignableDocumentedValue pair)
			{
				if (pair instanceof ValueAndUnit)
					{
						if (pairs.size() == 0)
							vu = (Documented_Value) pair;
						pairs.add((Documented_Value) pair);
					}
			}
		
		public double[] getMinValuesAsDouble()
			{
				double[] values = new double[pairs.size()];
				for (int i = pairs.size() - 1; i >= 0; i--)
					{
						DataValue<?> value = ((Documented_Value) pairs.get(i)).getMinValue();
						values[i] = (value == null) ? Double.NaN : value.getAsDouble();
					}
				return values;
			}
		
		public double[] getMaxValuesAsDouble()
			{
				double[] values = new double[pairs.size()];
				for (int i = pairs.size() - 1; i >= 0; i--)
					{
						DataValue<?> value = ((Documented_Value) pairs.get(i)).getMaxValue();
						values[i] = (value == null) ? Double.NaN : value.getAsDouble();
					}
				return values;
			}
		
		public double[] getDescriptorValuesAsDouble(int descriptorIndex)
			{
				double[] values = new double[pairs.size()];
				for (int i = pairs.size() - 1; i >= 0; i--)
					{
						Descriptor value = ((Documented_Value) pairs.get(i)).getDescriptor(descriptorIndex);
						values[i] = (value == null) ? Double.NaN : value.getAsDouble();
					}
				return values;
			}
		
		public double[] getDescriptorValuesAsDouble(DescriptorType descriptorType)
			{
				double[] values = new double[pairs.size()];
				for (int i = pairs.size() - 1; i >= 0; i--)
					{
						Descriptor value = ((Documented_Value) pairs.get(i)).getDescriptor(descriptorType);
						if (value != null)
							{
								Double v = value.getAsDouble();
								if (v == null)
									values[i] = Double.NaN;
								else
									values[i] = v;
							}
						else
							values[i] = Double.NaN;
					}
				return values;
			}
		
		public void setDescriptorUnit(DescriptorType descriptorType, String unit)
			{
				for (ValueAndUnit pair : pairs)
					{
						Descriptor descr = ((Documented_Value) pair).getDescriptor(descriptorType);
						descr.setUnit(unit);
					}
			}
		
		@Override
		public String getTitle()
			{
				if (vu != null)
					{
						StringBuilder sb = new StringBuilder();
						sb.append(type.getName());
						sb.append("=");
						sb.append(vu.getDisplayValue());
						if (vu.unit != null)
							{
								sb.append(" ");
								sb.append(vu.getDisplayUnit());
							}
						if (type.descriptors.size() > 0)
							{
								sb.append(" (");
								for (IdentifiableDescriptorType dt : type.descriptors)
									{
										Descriptor d = ((Documented_Value) vu).descriptors.get(dt);
										sb.append(d.getValueAndUnit());
										sb.append(", ");
									}
								Descriptor d = ((Documented_Value) vu).descriptors.get(type.descriptors.get(type.getDescriptorsCount() - 1));
								sb.append(d.getValueAndUnit());
								sb.append(")");
							}
						return sb.toString();
					}
				else
					return "";
			}
		
		public static class DescriptorComparator implements Comparator<ValueAndUnit>
			{
				public DescriptorComparator(DescriptorType descrType)
					{
						super();
						this.descrType = descrType;
					}
				
				public int compare(ValueAndUnit value1, ValueAndUnit value2)
					{
						if ((value1 == null) || (value2 == null))
							return 0;
						else
							{
								DataValue<?> dv1 = ((DataValue<?>) ((Documented_Value) value1).getDescriptor(descrType).getValue());
								if (dv1==null)
									return 0;
								DataValue<?> dv2 = ((DataValue<?>) ((Documented_Value) value2).getDescriptor(descrType).getValue());
								if (dv2==null)
									return 0;
								return dv1.compareTo(dv2);
							}
					}
				
				protected DescriptorType	descrType;
			}

		public static class DualDescriptorComparator implements Comparator<ValueAndUnit>
			{
				public DualDescriptorComparator(DescriptorType primeDescrType,DescriptorType secondaryDescrType)
					{
						super();
						this.primeDescrType = primeDescrType;
						this.secondaryDescrType = secondaryDescrType;
					}
				
				public int compare(ValueAndUnit value1, ValueAndUnit value2)
					{
						if ((value1 == null) || (value2 == null))
							return 0;
						else
							{
								DataValue<?> dv1 = ((DataValue<?>) ((Documented_Value) value1).getDescriptor(primeDescrType).getValue());
								if (dv1==null)
									return 0;
								DataValue<?> dv2 = ((DataValue<?>) ((Documented_Value) value2).getDescriptor(primeDescrType).getValue());
								if (dv2==null)
									return 0;
								int result = dv1.compareTo(dv2);
								if (result!=0)
									return result;
								else
									{
										dv1 = ((DataValue<?>) ((Documented_Value) value1).getDescriptor(secondaryDescrType).getValue());
										if (dv1==null)
											return 0;
										dv2 = ((DataValue<?>) ((Documented_Value) value2).getDescriptor(secondaryDescrType).getValue());
										if (dv2==null)
											return 0;
										return dv1.compareTo(dv2);
									}
							}
					}
				
				protected DescriptorType	primeDescrType;
				protected DescriptorType	secondaryDescrType;
			}

		public boolean addDescriptor(DescriptorType descriptorType)
			{
				if (type.getDescriptors().contains(descriptorType))
					return false;
				type.getDescriptors().add(descriptorType);
				for (ValueAndUnit pair : pairs)
					((Documented_Value) pair).addDescriptor(new Descriptor(descriptorType));
				return true;
			}
		
		public boolean removeDescriptor(DescriptorType descriptorType)
			{
				if (type.getDescriptors().contains(descriptorType))
					{
						type.getDescriptors().remove(descriptorType);
						for (ValueAndUnit pair : pairs)
							((Documented_Value) pair).removeDescriptor(descriptorType);
						return true;
					}
				return false;
			}
	}

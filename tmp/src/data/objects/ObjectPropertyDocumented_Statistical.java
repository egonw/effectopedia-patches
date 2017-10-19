package org.qsari.effectopedia.data.objects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.interfaces.AssignableDocumentedValue;
import org.qsari.effectopedia.data.interfaces.IdentifiableDescriptorType;
import org.qsari.effectopedia.data.interfaces.IdentifiableObjectPropertyDocumented;
import org.qsari.effectopedia.data.objects.ObjectProperty.ValueAndUnit;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented.Documented_Value;
import org.qsari.effectopedia.defaults.DefaultTextProperties;

public class ObjectPropertyDocumented_Statistical extends ObjectPropertyMultivalued_Documented implements IdentifiableObjectPropertyDocumented
	{
		public class Statistical_Value extends Documented_Value implements Importable, Exportable, AssignableDocumentedValue
			{
				protected DataValue<?>										medianValue;
				protected DataValue<?>										standardDeviation;
				protected int																			numberOfSamples;
				protected DistributionType						distributionType;
				protected ArrayList<Descriptor>	distribution_coef;
				
				public Statistical_Value assign(String[] doc_val)
					{
						if (doc_val.length != 9 + descriptors.size() + distribution_coef.size())
							return this;
						
						int index = 0;
						setValue(doc_val[index++]);
						setMinValue(doc_val[index++]);
						setMaxValue(doc_val[index++]);
						setMedianValue(doc_val[index++]);
						setStandardDeviation(doc_val[index++]);
						setUnit(doc_val[index++]);
						// TODO distribution
						for (int i = 0; i < descriptors.size(); i++)
							{
								Descriptor descr = descriptors.get(i);
								descr.setValue(doc_val[index++]);
								descr.setUnit(doc_val[index++]);
							}
						notes = doc_val[index++];
						setReferences(doc_val[index]);
						return this;
					}
				
				@Override
				public Statistical_Value clone()
					{
						Statistical_Value clone = new Statistical_Value();
						clone.value = (value != null) ? this.value.clone() : null;
						clone.minValue = (minValue != null) ? this.minValue.clone() : null;
						clone.maxValue = (maxValue != null) ? this.maxValue.clone() : null;
						clone.medianValue = (medianValue != null) ? this.medianValue.clone() : null;
						clone.standardDeviation = (standardDeviation != null) ? this.standardDeviation.clone() : null;
						clone.unit = (unit != null) ? this.unit.clone() : null;
						clone.numberOfSamples = this.numberOfSamples;
						clone.distributionType = this.distributionType.clone();
						for (Descriptor d : distribution_coef)
							clone.distribution_coef.add(d.clone());
						for (Descriptor d : descriptors.values())
							clone.descriptors.put(d.type,d.clone());
						clone.notes = this.notes;
						clone.references = (references != null) ? this.references.clone() : null;
						return clone;
					}
				
				public void load(BaseIOElement element, BaseIO io)
					{
						if (element != null)
							{
								super.load(element, io);
								medianValue = loadBaseTypeValue(medianValue, "median_value", element, io);
								standardDeviation = loadBaseTypeValue(standardDeviation, "standard_deviation", element, io);
								
								BaseIOElement references = element.getChild("references");
								if (references == null)
									references = element.getChild("reference");
								notes = element.getChildValue("notes");
								if ((references != null) && (references.getValue().length() != 0))
									{
										if (this.references == null)
											this.references = (DataValue_String) DataValue.newValue(getSearchableItem(), DataValue_String.class, null);
										this.references.load(references, io);
									}
							}
					}
				
				protected final void loadDescriptors(DescriptorTypesContainer types, BaseIOElement element, BaseIO io)
					{
						if (element == null)
							return;
						int count = Integer.parseInt(element.getAttributeValue("count"));
						List<BaseIOElement> children = element.getChildren();
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
											}
									}
							}
					}
				
				@Override
				public BaseIOElement store(BaseIOElement element, BaseIO io)
					{
						element = super.store(element, io);
						if ((minValue != null) && (minValue.toString() != null) && (minValue.toString().length() > 0))
							element.addChild(minValue.store(io.newElement("min_value"), io));
						if ((maxValue != null) && (maxValue.toString() != null) && (maxValue.toString().length() > 0))
							element.addChild(maxValue.store(io.newElement("max_value"), io));
						BaseIOElement desriptors = io.newElement("descriptors");
						
						desriptors.setAttribute("count", String.valueOf(this.descriptors.size()));
						for (Descriptor d : this.descriptors.values())
							desriptors.addChild(d.store(io.newElement(d.type.getName()), io));
						element.addChild(desriptors);
						if (notes != null)
							element.addValueElement(io.newValue("notes").setData(notes));
						if (references != null)
							element.addChild(references.store(io.newElement("references"), io));
						element.setAttribute("documented", "true");
						return element;
					}
				
				public final DataValue<?> getMedianValue()
					{
						return medianValue;
					}
				
				public final void setMedianValue(DataValue<?> medianValue)
					{
						this.medianValue = medianValue;
					}
				
				public final void setMedianValue(String value)
					{
						boolean different = ((value == null) && (this.medianValue != null)) || (this.medianValue == null) && (value != null);
						if ((value != null) && (this.medianValue != null))
							different = !(value.equals(this.medianValue.toString()));
						if (different)
							{
								if (owner != null)
									owner.beforeUpdate(true, type.actionTypeID);
								if (value != null)
									{
										if (this.medianValue == null)
											this.medianValue = DataValue.newValue(getSearchableItem(), type.baseValueType, type.fixedValuesList);
										this.medianValue.parseString(value);
									}
								else
									this.medianValue = null;
							}
					}
				
				public String getDisplayMedianValue()
					{
						if (this.medianValue == null)
							return DefaultTextProperties.INSTANCE.getDefault(type.getFullName());
						else
							return this.medianValue.getDisplayValue();
					}
				
				public final DataValue<?> getStandardDeviation()
					{
						return standardDeviation;
					}
				
				public final void setStandardDeviation(DataValue<?> standardDeviation)
					{
						this.standardDeviation = standardDeviation;
					}
				
				public final void setStandardDeviation(String value)
					{
						boolean different = ((value == null) && (this.standardDeviation != null)) || (this.standardDeviation == null) && (value != null);
						if ((value != null) && (this.standardDeviation != null))
							different = !(value.equals(this.standardDeviation.toString()));
						if (different)
							{
								if (owner != null)
									owner.beforeUpdate(true, type.actionTypeID);
								if (value != null)
									{
										if (this.standardDeviation == null)
											this.standardDeviation = DataValue.newValue(getSearchableItem(), type.baseValueType, type.fixedValuesList);
										this.standardDeviation.parseString(value);
									}
								else
									this.standardDeviation = null;
							}
					}
				
				public String getDisplayStandardDeviation()
					{
						if (this.standardDeviation == null)
							return DefaultTextProperties.INSTANCE.getDefault(type.getFullName());
						else
							return this.standardDeviation.getDisplayValue();
					}
				
				public final int getNumberOfSamples()
					{
						return numberOfSamples;
					}
				
				public final void setNumberOfSamples(int numberOfSamples)
					{
						this.numberOfSamples = numberOfSamples;
					}
				
				public final ArrayList<Descriptor> getDistribution_coef()
					{
						return distribution_coef;
					}
				
				public final void setDistribution_coef(ArrayList<Descriptor> distribution_coef)
					{
						this.distribution_coef = distribution_coef;
					}
				
			}
		
		public ObjectPropertyDocumented_Statistical(EffectopediaObject owner, ObjectPropertyType type)
			{
				super(owner, type);
				vu = new Statistical_Value();
			}
		
		public Statistical_Value getValueAndUnitPair(int index)
			{
				return (Statistical_Value) pairs.get(index);
			}

		@Override
		public Statistical_Value add()
			{
				Statistical_Value newPair = new Statistical_Value();
				pairs.add(newPair);
				return newPair;
			}

		@Override
		public void add(AssignableDocumentedValue pair)
			{
				if (pair instanceof ValueAndUnit)
					{
						if (pairs.size() == 0)
							vu = (Statistical_Value) pair;
						pairs.add((Statistical_Value) pair);
					}
			}
		
		
	}

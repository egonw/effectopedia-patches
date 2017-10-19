package org.qsari.effectopedia.data.objects;

import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.interfaces.IdentifiableDescriptor;
import org.qsari.effectopedia.data.interfaces.IdentifiableDescriptorType;
import org.qsari.effectopedia.data.interfaces.StringableDataValue;

public class Descriptor implements Importable, Exportable, IdentifiableDescriptor
	{
		protected DataValue<?>	value;
		protected DataUnit					unit;
		
		public Descriptor(IdentifiableDescriptorType type)
			{
				super();
				this.type = type;
			}
		
		public Descriptor clone()
			{
				Descriptor clone = new Descriptor(type);
				clone.value = (value != null) ? this.value.clone() : null;
				clone.unit = (unit != null) ? this.unit.clone() : null;
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						BaseIOElement value = element.getChild("value");
						if ((value != null) && (value.getValue().length() != 0))
							{
								if (this.value == null)
									this.value = DataValue.newValue(null, type.getBaseValueType(), type.getFixedValuesList());
								this.value.load(value, io);
							}
						BaseIOElement unit = element.getChild("unit");
						if (unit != null)
							if (this.unit == null)
								this.unit = new DataUnit(unit.getChildValue("caption"));
							else
								this.unit.setCaption(unit.getChildValue("caption"));
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				if ((value != null) && (value.toString() != null) && (value.toString().length() > 0))
					element.addChild(value.store(io.newElement("value"), io));
				if (unit != null)
					element.addChild(unit.store(io.newElement("unit"), io));
				return element;
			}
		
		public String getDisplayValue()
			{
				return (value != null) ? value.getDisplayValue() : "";
			}
		
		public String getDisplayUnit()
			{
				return ((unit != null) ? unit.caption : "");
			}
		
		public String getValueAndUnit()
			{
				return ((value != null) ? value.getDisplayValue() + " " : "") + ((unit != null) ? unit.caption : "");
			}
		
		public void setValue(String value)
			{
				if (this.value == null)
					this.value = DataValue.newValue(null, type.getBaseValueType(), type.getFixedValuesList());
				this.value.parseString(value);
			}
		
		public void setUnit(String unit)
			{
				if (unit == null)
					return;
				if (this.unit == null)
					this.unit = new DataUnit(unit);
				else
					this.unit.setCaption(unit);
			}
		
		public void setValueAndUnit(String valueAndUnit)
			{
				if (valueAndUnit == null)
					return;
				valueAndUnit = valueAndUnit.trim();
				int p = valueAndUnit.indexOf(" ");
				String value;
				String unit;
				if (p < 0)
					{
						value = valueAndUnit;
						this.unit = null;
					}
				else
					{
						value = valueAndUnit.substring(0, p);
						unit = valueAndUnit.substring(p + 1);
						if (this.unit == null)
							this.unit = new DataUnit(unit);
						else
							this.unit.setCaption(unit);
					}
				if (this.value == null)
					this.value = DataValue.newValue(null, type.getBaseValueType(), type.getFixedValuesList());
				this.value.parseString(value);
			}
		
		public final IdentifiableDescriptorType getType()
			{
				return type;
			}
		
		@Override
		public void setType(IdentifiableDescriptorType type)
			{
				this.type = type;
			}
		
		@Override
		public StringableDataValue<?> getValue()
			{
				return value;
			}
		
		public Double getAsDouble()
			{
				if (value != null)
					return value.getAsDouble();
				else
					return null;
			}
		
		public void setFromDouble(double newValue)
			{
				if (this.value == null)
					this.value = DataValue.newValue(null, type.getBaseValueType(), type.getFixedValuesList());
				this.value.setFromDouble(newValue);
			}
		
		protected IdentifiableDescriptorType	type;
		
	}

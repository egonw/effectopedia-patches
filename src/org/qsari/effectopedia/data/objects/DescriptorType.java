package org.qsari.effectopedia.data.objects;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.BaseIOValue;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.interfaces.IdentifiableDataUnit;
import org.qsari.effectopedia.data.interfaces.IdentifiableDescriptorType;

public class DescriptorType extends EffectopediaObject implements Importable, Exportable, Cloneable, IdentifiableDescriptorType
	{
		
		public DescriptorType()
			{
				super();
			}
		
		public DescriptorType(String name, String description, Class<?> baseValueType, DataUnit defaultUnit)
			{
				super();
				this.name = name;
				this.description = description;
				this.defaultUnit = defaultUnit;
				this.baseValueType = baseValueType;
				// Negative ID Revolution
				// bringToLive();
			}
		
		public DescriptorType(String name, String description, Class<?> baseValueType, DataUnit defaultUnit, FixedValuesList fixedValuesList)
			{
				super();
				this.name = name;
				this.description = description;
				this.defaultUnit = defaultUnit;
				this.baseValueType = baseValueType;
				this.fixedValuesList = fixedValuesList;
			}
		
		public void cloneFieldsTo(DescriptorType clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone);
				clone.name = this.name;
				clone.description = this.description;
				clone.defaultUnit = this.defaultUnit;
				clone.baseValueType = this.baseValueType;
			}
		
		@Override
		public DescriptorType clone(EffectopediaObject owner, DataSource dataSource)
			{
				DescriptorType clone = new DescriptorType();
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		@Override
		public DescriptorType clone()
			{
				DescriptorType clone = new DescriptorType();
				cloneFieldsTo(clone);
				return clone;
			}
		
		public String getName()
			{
				return this.name;
			}
		
		public void setName(String name)
			{
				this.name = name;
			}
		
		public final String getDescription()
			{
				return description;
			}
		
		public final void setDescription(String description)
			{
				this.description = description;
			}
		
		public final DataUnit getDefaultUnit()
			{
				return defaultUnit;
			}
		
		public final void setDefaultUnit(IdentifiableDataUnit defaultUnit)
			{
				if (defaultUnit == null)
					{
						this.defaultUnit = null;
						return;
					}
				if (defaultUnit instanceof DataUnit)
					this.defaultUnit = (DataUnit) defaultUnit;
				else
					this.defaultUnit = new DataUnit(defaultUnit.getCaption());
			}
		
		public String getDisplayUnit()
			{
				return this.defaultUnit == null ? "" : this.defaultUnit.getCaption();
			}
		
		public void setDisplayUnit(String unit)
			{
				boolean different = ((unit == null) && (this.defaultUnit != null)) || (this.defaultUnit == null) && (unit != null);
				if ((unit != null) && (this.defaultUnit != null))
					different = !(unit.equals(this.defaultUnit.getCaption()));
				if (different)
					{
						if (this.defaultUnit == null)
							this.defaultUnit = new DataUnit(unit);
						else
							this.defaultUnit.setCaption(unit);
					}
			}
		
		public final Class<?> getBaseValueType()
			{
				return baseValueType;
			}
		
		public final void setBaseValueType(Class<?> baseValueType)
			{
				this.baseValueType = baseValueType;
			}
		
		@Override
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						if (isDefaultID())
							name = element.getValueElement("name").getValue();
						else
							deepLoad(element, io);
					}
			}
		
		@SuppressWarnings("unchecked")
		protected void deepLoad(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						name = element.getValueElement("name").getValue();
						BaseIOValue desc = element.getValueElement("description");
						if (desc != null)
							description = desc.getValue();
						BaseIOElement el = element.getChild("default_unit");
						if (el != null)
							defaultUnit = new DataUnit(el.getChildValue("caption"));
						BaseIOValue e = element.getValueElement("base_value_type");
						if (e != null)
							try
								{
									baseValueType = (Class<? extends EffectopediaObject>) Class.forName(e.getValue());
								}
							catch (ClassNotFoundException e1)
								{
									e1.printStackTrace();
								}
					}
			}
		
		@Override
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				if (isDefaultID())
					return element.setAttribute("name", name);
				else
					return deepStore(element, io);
			}
		
		protected BaseIOElement deepStore(BaseIOElement element, BaseIO io)
			{
				element.addValueElement(io.newValue("name").setValue(name));
				element.addValueElement(io.newValue("description").setValue(description));
				if (defaultUnit != null)
					element.addChild(defaultUnit.store(io.newElement("default_unit"), io));
				if (baseValueType != null)
					element.addValueElement(io.newValue("base_value_type").setValue(baseValueType.getName()));
				return element;
			}
		
		public final FixedValuesList getFixedValuesList()
			{
				return fixedValuesList;
			}
		
		public final void setFixedValuesList(FixedValuesList fixedValuesList)
			{
				this.fixedValuesList = fixedValuesList;
			}
		
		public String toString()
			{
				return name;
			}
		
		protected String										name;
		protected String										description;
		protected DataUnit								defaultUnit;
		protected Class<?>								baseValueType;
		protected FixedValuesList	fixedValuesList	= null;
		
	}

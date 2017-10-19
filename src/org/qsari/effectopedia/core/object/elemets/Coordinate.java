package org.qsari.effectopedia.core.object.elemets;

import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.objects.ContextDimension;
import org.qsari.effectopedia.core.objects.DocumentedKnowledge_Located;
import org.qsari.effectopedia.data.objects.DataUnit;
import org.qsari.effectopedia.data.objects.DataValue;
import org.qsari.effectopedia.data.objects.FixedValuesList;
import org.qsari.effectopedia.search.SearchableItem;

public class Coordinate implements Importable, Exportable, Cloneable, Traceable
	{
		public Coordinate(DocumentedKnowledge_Located owner, ContextDimension dimension)
			{
				super();
				this.owner = owner;
				this.dimension = dimension;
			}
		
		public ContextDimension getDimension()
			{
				return dimension;
			}
		
		public DataValue<?> getValue()
			{
				return value;
			}
		
		public void setValue(DataValue<?> value)
			{
				this.value = value;
			}
		
		public DataUnit getUnit()
			{
				return unit;
			}
		
		public void setUnit(DataUnit unit)
			{
				this.unit = unit;
			}

		@Override
		public void load(BaseIOElement element, BaseIO io)
			{
				BaseIOElement value = element.getChild("value");
				if ((value!=null)&&(value.getValue().length() != 0))
					{
						if (this.value == null)
							this.value = DataValue.newValue(getSearchableItem(), dimension.getBaseDataType(), (FixedValuesList) dimension.getDefaultValues());
						this.value.load(value,io);
					}
				BaseIOElement unit = element.getChild("unit");
				if (unit != null)
					if (this.unit == null)
						this.unit = new DataUnit(unit.getChildValue("caption"));
					else
						this.unit.setCaption(unit.getChildValue("caption"));
			}
		
		@Override
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				if (value != null)
					element.addChild(value.store(io.newElement("value"),io));
				if (unit != null)
					element.addChild(unit.store(io.newElement("unit"), io));
				return element;
			}
		
		public Coordinate clone(DocumentedKnowledge_Located owner)
			{
				Coordinate clone = new Coordinate(owner, dimension);
				clone.value = (value != null) ? this.value.clone() : null;
				clone.unit = (unit != null) ? this.unit.clone() : null;
				return clone;
			}
		
		public void setValue(String value)
			{
				boolean different = ((value == null) && (this.value != null)) || (this.value == null) && (value != null);
				if ((value != null) && (this.value != null))
					different = !(value.equals(this.value.toString()));
				if (different)
					{
						owner.beforeUpdate(true, dimension.getValueActionTypeID());
						if (value != null)
							{
								if (this.value == null)
									this.value = DataValue.newValue(getSearchableItem(), dimension.getBaseDataType(), (FixedValuesList) dimension.getDefaultValues());
								this.value.parseString(value);
							}
						else
							this.value = null;
					}
			}
		
		public SearchableItem getSearchableItem()
			{
				if ((dimension.isSearchable()) && (searchableItem == null))
					searchableItem = new SearchableItem(owner, dimension.propertyID, dimension.getName());
				return searchableItem;
			}
		
		protected DataValue<?>																						value;
		protected DataUnit																										unit;
		protected SearchableItem																				searchableItem;
		protected final ContextDimension												dimension;
		protected final DocumentedKnowledge_Located	owner;
	}

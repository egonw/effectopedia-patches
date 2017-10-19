package org.qsari.effectopedia.core.objects;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.FixedValuesList;
import org.qsari.effectopedia.data.objects.FixedValuesLists;
import org.qsari.effectopedia.data.objects.ValuesList;
import org.qsari.effectopedia.defaults.DefaultFixedListValues;

public class ContextDimension_Hierarchical extends ContextDimension
	{
		public ContextDimension_Hierarchical()
			{
				super();
			}
		
		public ContextDimension_Hierarchical(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
			}
		
		public ContextDimension_Hierarchical(EffectopediaObject parent, DataSource dataSource, String dimensionName)
			{
				super(parent, dataSource);
				this.name = dimensionName;
			}
		
		public ContextDimension_Hierarchical(EffectopediaObject parent, DataSource dataSource, String dimensionName, FixedValuesList hierarchy)
			{
				super(parent, dataSource);
				this.name = dimensionName;
				this.hierarchy = hierarchy;
			}
		
		@Override
				public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if (eoDestintation instanceof ContextDimension_Hierarchical)
					((ContextDimension_Hierarchical) eoDestintation).hierarchy = this.hierarchy;
			}
		
		public void cloneFieldsTo(ContextDimension_Hierarchical clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.hierarchy = this.hierarchy;
			}
		
		public ContextDimension_Hierarchical clone()
			{
				ContextDimension_Hierarchical clone = new ContextDimension_Hierarchical(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public ContextDimension_Hierarchical clone(EffectopediaObject parent, DataSource dataSource)
			{
				ContextDimension_Hierarchical clone = new ContextDimension_Hierarchical(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public FixedValuesList getHierarchy()
			{
				return hierarchy;
			}
		
		public void setHierarchy(FixedValuesList hierarchy)
			{
				this.hierarchy = hierarchy;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						BaseIOElement e = element.getChild("sub_category");
						if (e != null)
							{
								String name = e.getAttributeValue("hierarchy");
								hierarchy = (FixedValuesList) DefaultFixedListValues.INSTANCE.getList(name);
							}
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				BaseIOElement e = io.newElement("sub_category");
				e.setAttribute("hierarchy", hierarchy.getName());
				element.addChild(e);
				return element;
			}
		
		public long getCardinality()// TODO temporary implementation
			{
				if ((selected != null) && (defaultValues != null))
					return ((FixedValuesLists) defaultValues).getList(selected).size();
				return cardinality;
			}
		
		public ValuesList getDefaultValues()// TODO temporary implementation
			{
				if ((selected != null) && (defaultValues != null))
					return ((FixedValuesLists) defaultValues).getList(selected);
				return defaultValues;
			}
		
		public String getSelected()// TODO temporary implementation
			{
				return selected;
			}
		
		public void setSelected(String selected)
			{
				this.selected = selected;// TODO temporary implementation
			}
		
		protected String										selected;		// TODO temporary implementation
		protected FixedValuesList	hierarchy;
	}

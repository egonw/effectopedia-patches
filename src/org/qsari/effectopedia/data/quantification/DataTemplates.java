package org.qsari.effectopedia.data.quantification;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOArray;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.objects.Descriptor;
import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented.Documented_Value;
import org.qsari.effectopedia.data.objects.ObjectPropertyTypesContainer;
import org.qsari.effectopedia.data.quantification.DataSampleValueFactory.DataSampleDescriptorValue;

public class DataTemplates extends ArrayList<DataTemplate> implements Importable, Exportable, Cloneable, Titleable
	{
		
		public DataTemplates()
			{
				this.secondaryAxisTemplateIndex = NO_SECONDARY_AXIS;
			}
			
		public DataTemplates(String chartTitle, String xAxisTitle, String yAxisTitle)
			{
				this.chartTitle = chartTitle;
				this.xAxisTitle = xAxisTitle;
				this.yPrimaryAxisTitle = yAxisTitle;
				this.secondaryAxisTemplateIndex = NO_SECONDARY_AXIS;
			}
			
		public DataTemplates(String chartTitle, String xAxisTitle, String primaryYAxisTitle, String secondaryYAxisTitle)
			{
				this.chartTitle = chartTitle;
				this.xAxisTitle = xAxisTitle;
				this.yPrimaryAxisTitle = primaryYAxisTitle;
				this.ySecondaryAxisTitle = secondaryYAxisTitle;
				this.secondaryAxisTemplateIndex = DEFAULT_SECONDARY_AXIS_INDEX;
			}
			
		public void cloneFieldsTo(DataTemplates clone)
			{
				clone.chartTitle = this.chartTitle;
				clone.xAxisTitle = this.xAxisTitle;
				clone.groupingTitle = this.groupingTitle;
				clone.yPrimaryAxisTitle = this.yPrimaryAxisTitle;
				clone.ySecondaryAxisTitle = this.ySecondaryAxisTitle;
				clone.secondaryAxisTemplateIndex = this.secondaryAxisTemplateIndex;
				for (DataTemplate template : this)
					clone.add(template.clone());
			}
			
		public DataTemplates clone()
			{
				DataTemplates clone = new DataTemplates();
				cloneFieldsTo(clone);
				return clone;
			}
			
		public final ObjectProperties getProperties()
			{
				return properties;
			}
			
		public final void setProperties(ObjectProperties properties)
			{
				if (properties != null)
					{
						this.types = properties.getTypes();
						this.properties = properties;
						loadObjectProperties();
					}
				else
					this.properties = null;
			}
			
		public final ObjectPropertyTypesContainer getTypes()
			{
				return types;
			}
			
		public final void setTypes(ObjectPropertyTypesContainer types)
			{
				this.types = types;
			}
			
		public final void loadObjectProperties()
			{
				if ((properties != null) && (properties.getCount() == size()))
					for (int i = size() - 1; i >= 0; i--)
						get(i).setObjProp((ObjectPropertyMultivalued_Documented) properties.getProperty(i));
			}
			
		@Override
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element == null)
					return;
				BaseIOAttribute index = element.getAttribute("secondary_axis_template_index");
				if (index != null)
					{
						secondaryAxisTemplateIndex = index.getIntValue();
						ySecondaryAxisTitle = element.getChildValue("secondary_y_axis_title");
					}
				chartTitle = element.getChildValue("chart_title");
				xAxisTitle = element.getChildValue("x_axis_title");
				groupingTitle = element.getChildValue("grouping_title");
				yPrimaryAxisTitle = element.getChildValue("y_axis_title");
				BaseIOArray templates = element.getArray("templates");
				int count = templates.getCount();
				if (count != 0)
					{
						this.clear();
						this.ensureCapacity(count);
						List<BaseIOElement> children = templates.getChildren();
						if ((count != 0) && (children != null) && (children.size() == count))
							{
								Iterator<BaseIOElement> iterator = children.iterator();
								while (iterator.hasNext())
									{
										BaseIOElement templ = iterator.next();
										DataTemplate template = new DataTemplate();
										template.load(templ, io);
										add(template);
									}
							}
					}
			}
			
		@Override
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				if ((element != null))
					{
						if (secondaryAxisTemplateIndex != NO_SECONDARY_AXIS)
							element.setAttribute("secondary_axis_template_index", secondaryAxisTemplateIndex);
						element.addValueElement(io.newValue("chart_title").setValue(chartTitle));
						element.addValueElement(io.newValue("x_axis_title").setValue(xAxisTitle));
						element.addValueElement(io.newValue("grouping_title").setValue(groupingTitle));
						element.addValueElement(io.newValue("y_axis_title").setValue(yPrimaryAxisTitle));
						element.addValueElement(io.newValue("secondary_y_axis_title").setValue(ySecondaryAxisTitle));
						BaseIOArray templates = io.newArray("templates", this.size());
						for (DataTemplate template : this)
							{
								BaseIOElement tmpl = io.newElement("data_template");
								template.store(tmpl, io);
								templates.addChild(tmpl);
							}
						element.addChild(templates);
					}
				return element;
				
			}
			
		public DataTemplates setupTemplates(ObjectPropertyTypesContainer types)
			{
				if (types.size() == size())
					this.types = types;
				return this;
			}
			
		public String getChartTitle()
			{
				return chartTitle;
			}
			
		public void setChartTitle(String chartTitle)
			{
				this.chartTitle = chartTitle;
			}
			
		public String getxAxisTitle()
			{
				return xAxisTitle;
			}
			
		public void setxAxisTitle(String xAxisTitle)
			{
				this.xAxisTitle = xAxisTitle;
			}
			
		public String getGroupingTitle()
			{
				return groupingTitle;
			}
			
		public void setGroupingTitle(String groupingTitle)
			{
				this.groupingTitle = groupingTitle;
			}
			
		public String getyPrimaryAxisTitle()
			{
				return yPrimaryAxisTitle;
			}
			
		public void setyPrimaryAxisTitle(String yPrimaryAxisTitle)
			{
				this.yPrimaryAxisTitle = yPrimaryAxisTitle;
			}
			
		public String getySecondaryAxisTitle()
			{
				return ySecondaryAxisTitle;
			}
			
		public void setySecondaryAxisTitle(String ySecondaryAxisTitle)
			{
				this.ySecondaryAxisTitle = ySecondaryAxisTitle;
			}
			
		public String getDefaultYDisplayUnit()
			{
				if (size() > 0)
					{
						DataTemplate template = get(0);
						if (template.objProp != null)
							return template.objProp.getDisplayUnit();
						else
							return null;
					}
				else
					return null;
			}
			
		public void setDefaultYDisplayUnit(String unit)
			{
				if (secondaryAxisTemplateIndex != NO_SECONDARY_AXIS)
					{
						DataTemplate template = get(0);
						if (template.objProp != null)
							template.objProp.setUnit(unit);
					}
				else
					for (DataTemplate template : this)
						if (template.objProp != null)
							template.objProp.setUnit(unit);
			}
			
		public String getSecondaryYDisplayUnit()
			{
				if ((secondaryAxisTemplateIndex != NO_SECONDARY_AXIS) && (secondaryAxisTemplateIndex < size()))
					{
						DataTemplate template = get(secondaryAxisTemplateIndex);
						if (template.objProp != null)
							return template.objProp.getDisplayUnit();
						else
							return null;
					}
				else
					return null;
			}
			
		public void setSecondaryYDisplayUnit(String unit)
			{
				if ((secondaryAxisTemplateIndex != -1) && (secondaryAxisTemplateIndex < size()))
					{
						DataTemplate template = get(secondaryAxisTemplateIndex);
						if (template.objProp != null)
							template.objProp.setUnit(unit);
					}
			}
			
		public String getDefaultXDisplayUnit()
			{
				if (size() > 0)
					{
						DataTemplate template = get(0);
						if ((template.getType().getChartX() instanceof DataSampleDescriptorValue))
							{
								DescriptorType descriptorType = ((DataSampleDescriptorValue) template.getType().getChartX()).descriptorType;
								if (template.objProp != null)
									{
										Documented_Value val = (Documented_Value) template.objProp.getValueAndUnit();
										if (val != null)
											{
												Descriptor descriptor = val.getDescriptor(descriptorType);
												if (descriptor != null)
													return descriptor.getDisplayUnit();
												else
													return descriptorType.getDefaultUnit()!=null?descriptorType.getDefaultUnit().getCaption():"";
											}
									}
							}
					}
				return null;
			}
			
		public void setDefaultXDisplayUnit(String unit)
			{
				if ((size() > 0) && ((get(0).getType().getChartX() instanceof DataSampleDescriptorValue)))
					{
						DescriptorType descriptorType = ((DataSampleDescriptorValue) get(0).getType().getChartX()).descriptorType;
						for (DataTemplate template : this)
							if (template.objProp != null)
								template.objProp.setDescriptorUnit(descriptorType, unit);
					}
			}
			
		public String getDefaultGroupDisplayUnit()
			{
				if (size() > 0)
					{
						DataTemplate template = get(0);
						if ((template.getType().getChartGroup() instanceof DataSampleDescriptorValue))
							{
								DescriptorType descriptorType = ((DataSampleDescriptorValue) template.getType().getChartGroup()).descriptorType;
								if (template.objProp != null)
									{
										Documented_Value val = (Documented_Value) template.objProp.getValueAndUnit();
										if (val != null)
											{
												String unit = val.getDescriptor(descriptorType).getDisplayUnit();
												if (unit != null)
													return unit;
												else
													return descriptorType.getDefaultUnit().getCaption();
											}
									}
							}
					}
				return null;
			}
			
		public void setDefaultGroupDisplayUnit(String unit)
			{
				if ((size() > 0) && ((get(0).getType().getChartGroup() instanceof DataSampleDescriptorValue)))
					{
						DescriptorType descriptorType = ((DataSampleDescriptorValue) get(0).getType().getChartGroup()).descriptorType;
						for (DataTemplate template : this)
							if (template.objProp != null)
								template.objProp.setDescriptorUnit(descriptorType, unit);
					}
			}
			
		public int getColumnCount(boolean commonX)
			{
				int cnt = commonX ? 1 : 2;
				for (DataTemplate template : this)
					cnt += template.getType().getColumnDataTypes().size();
				return cnt;
			}
			
		public EffectopediaObject getOwner()
			{
				return owner;
			}
			
		public void setOwner(EffectopediaObject owner)
			{
				this.owner = owner;
			}
			
		@Override
		public String getTitle()
			{
				return chartTitle;
			}
			
		@Override
		public void setTitle(String title)
			{
				chartTitle = title;
			}
			
		public int getSecondaryAxisTemplateIndex()
			{
				return secondaryAxisTemplateIndex;
			}
			
		public void setSecondaryAxisTemplateIndex(int secondaryAxisTemplateIndex)
			{
				this.secondaryAxisTemplateIndex = secondaryAxisTemplateIndex;
			}
			
		public void setSecondaryAxisTemplateIndex()
			{
				this.secondaryAxisTemplateIndex = DEFAULT_SECONDARY_AXIS_INDEX;
			}
			
		public void resetTitles()
			{
				this.xAxisTitle = null;
				this.yPrimaryAxisTitle = null;
				this.ySecondaryAxisTitle = null;
				this.chartTitle = null;
			}
			
		public boolean isUsingGroups()
			{
				if (size() > 0)
					return get(0).getType().getChartGroup() != null;
				else
					return false;
			}
			
		public static final int																NO_SECONDARY_AXIS												= -1;
		public static final int																DEFAULT_SECONDARY_AXIS_INDEX	= 1;
		
		protected ObjectPropertyTypesContainer	types;
		protected ObjectProperties													properties;
		protected String																							chartTitle;
		protected String																							xAxisTitle;
		protected String																							groupingTitle;
		protected String																							yPrimaryAxisTitle;
		protected String																							ySecondaryAxisTitle;
		
		protected int																										secondaryAxisTemplateIndex			= NO_SECONDARY_AXIS;
		protected EffectopediaObject											owner;
		/**
		 * 
		 */
		private static final long														serialVersionUID													= 1L;
		
	}

package org.qsari.effectopedia.data.quantification;

import java.util.ArrayList;
import java.util.StringTokenizer;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOArray;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.quantification.DataSampleValueFactory.DataSampleValue;

public class DataTemplateType extends EffectopediaObject implements Importable, Exportable, Cloneable
	{
		public DataTemplateType(String desctiption)
			{
				super();
				this.description = desctiption;
				columnNames = new ArrayList<String>();
				columnDataTypes = new ArrayList<DataSampleValueFactory.DataSampleValue>();
			}
		
		public DataTemplateType(EffectopediaObject owner, DataSource dataSource)
			{
				super(owner, dataSource);
				columnNames = new ArrayList<String>();
				columnDataTypes = new ArrayList<DataSampleValueFactory.DataSampleValue>();
			}
		
		public void cloneFieldsTo(DataTemplateType clone)
			{
				super.cloneFieldsTo(clone);
				clone.chartX = this.chartX;
				clone.chartGroup = this.chartGroup;
				clone.chartY = this.chartY;
				clone.chartYErrorLowerRange = this.chartYErrorLowerRange;
				clone.chartYErrorUpperRange = this.chartYErrorUpperRange;
				for (String columnName : this.columnNames)
					clone.columnNames.add(columnName);
				for (DataSampleValueFactory.DataSampleValue columnType : this.columnDataTypes)
					clone.columnDataTypes.add(columnType);
			}
		
		@Override
		public DataTemplateType clone(EffectopediaObject owner, DataSource dataSource)
			{
				DataTemplateType clone = new DataTemplateType(owner, dataSource);
				cloneFieldsTo(clone);
				return clone;
			}
		
		@Override
		public DataTemplateType clone()
			{
				DataTemplateType clone = new DataTemplateType(this.description);
				cloneFieldsTo(clone);
				return clone;
			}
		
		@Override
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						
						description = element.getChildValue("description");
						
						BaseIOElement chart = element.getChild("chart");
						if (chart != null)
							{
								BaseIOAttribute markerAttribute = chart.getAttribute("x");
								if (markerAttribute != null)
									chartX = getValueType(markerAttribute.getValue());
								markerAttribute = chart.getAttribute("group");
								if (markerAttribute != null)
									chartGroup = getValueType(markerAttribute.getValue());
								markerAttribute = chart.getAttribute("y");
								if (markerAttribute != null)
									chartY = getValueType(markerAttribute.getValue());
								markerAttribute = chart.getAttribute("y_error_lower_range");
								if (markerAttribute != null)
									chartYErrorLowerRange = getValueType(markerAttribute.getValue());
								markerAttribute = chart.getAttribute("y_error_upper_range");
								if (markerAttribute != null)
									chartYErrorUpperRange = getValueType(markerAttribute.getValue());
							}
						
						BaseIOArray columnNamesArray = element.getArray("column_names");
						if (columnNamesArray != null)
							{
								int count = columnNamesArray.getCount();
								if (count != 0)
									{
										columnNames.clear();
										columnNames.ensureCapacity(count);
										StringTokenizer idsArray = new StringTokenizer(columnNamesArray.getValue(), "|");
										while (idsArray.hasMoreTokens())
											columnNames.add(idsArray.nextToken().trim());
									}
							}
						
						BaseIOArray columnTypesArray = element.getArray("column_types");
						if (columnTypesArray != null)
							{
								int count = columnTypesArray.getCount();
								if (count != 0)
									{
										columnDataTypes.clear();
										columnDataTypes.ensureCapacity(count);
										StringTokenizer idsArray = new StringTokenizer(columnNamesArray.getValue(), "|");
										while (idsArray.hasMoreTokens())
											columnDataTypes.add(getValueType(idsArray.nextToken().trim()));
									}
							}
						
					}
			}
		
		public static DataSampleValue getValueType(String valueTypeIndex)
			{
				int index = Integer.valueOf(valueTypeIndex);
				if ((index >= 0) && (index < DataSampleValueFactory.VALUES.size()))
					return DataSampleValueFactory.VALUES.get(index);
				else
					return null;
			}
		
		@Override
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				
				element.addValueElement(io.newValue("description").setValue(description));
				
				BaseIOElement marker = io.newElement("chart");
				marker.addAttribute(io.newAttribute("x").setValue(DataSampleValueFactory.VALUES.indexOf(chartX)));
				marker.addAttribute(io.newAttribute("group").setValue(DataSampleValueFactory.VALUES.indexOf(chartGroup)));
				marker.addAttribute(io.newAttribute("y").setValue(DataSampleValueFactory.VALUES.indexOf(chartY)));
				marker.addAttribute(io.newAttribute("y_error_lower_range").setValue(DataSampleValueFactory.VALUES.indexOf(chartYErrorLowerRange)));
				marker.addAttribute(io.newAttribute("y_error_upper_range").setValue(DataSampleValueFactory.VALUES.indexOf(chartYErrorUpperRange)));
				element.addChild(marker);
				
				int count = columnNames.size();
				BaseIOArray columnNamesArray = io.newArray("column_names", count);
				if (count != 0)
					{
						StringBuilder idsArray = new StringBuilder();
						for (String columnName : columnNames)
							{
								idsArray.append(columnName);
								idsArray.append('|');
							}
						columnNamesArray.setValue(idsArray.toString());
					}
				element.addChild(columnNamesArray);
				
				BaseIOArray columnTypesArray = io.newArray("column_types", count);
				if (count != 0)
					{
						StringBuilder idsArray = new StringBuilder();
						for (DataSampleValue columnType : columnDataTypes)
							{
								idsArray.append(DataSampleValueFactory.VALUES.indexOf(columnType));
								idsArray.append('|');
							}
						columnTypesArray.setValue(idsArray.toString());
					}
				element.addChild(columnTypesArray);
				return element;
			}
		
		public ArrayList<String> getColumnNames()
			{
				return columnNames;
			}
		
		public ArrayList<DataSampleValueFactory.DataSampleValue> getColumnDataTypes()
			{
				return columnDataTypes;
			}
		
		public DataSampleValue getChartX()
			{
				return chartX;
			}
		
		public void setChartX(DataSampleValue chartX)
			{
				this.chartX = chartX;
			}
		
		protected DataSampleValue getChartGroup()
			{
				return chartGroup;
			}

		protected void setChartGroup(DataSampleValue chartGroup)
			{
				this.chartGroup = chartGroup;
			}

		public DataSampleValue getChartY()
			{
				return chartY;
			}
		
		public void setChartY(DataSampleValue chartY)
			{
				this.chartY = chartY;
			}
		
		public DataSampleValue getChartYErrorLowerRange()
			{
				return chartYErrorLowerRange;
			}
		
		public void setChartYErrorLowerRange(DataSampleValue chartYErrorLowerRange)
			{
				this.chartYErrorLowerRange = chartYErrorLowerRange;
			}
		
		public DataSampleValue getChartYErrorUpperRange()
			{
				return chartYErrorUpperRange;
			}
		
		public void setChartYErrorUpperRange(DataSampleValue chartYErrorUpperRange)
			{
				this.chartYErrorUpperRange = chartYErrorUpperRange;
			}
		
		public DataTemplateType addColumn(String columnName, DataSampleValue columnType)
			{
				columnNames.add(columnName);
				columnDataTypes.add(columnType);
				return this;
			}
		
		public DataTemplateType updateChartSetup(DataSampleValue chartX, DataSampleValue chartY, DataSampleValue chartYErrorLowerRange, DataSampleValue chartYErrorUpperRange)
			{
				this.chartX = chartX;
				this.chartY = chartY;
				this.chartGroup = null;
				this.chartYErrorLowerRange = chartYErrorLowerRange;
				this.chartYErrorUpperRange = chartYErrorUpperRange;
				return this;
			}

		public DataTemplateType updateChartSetup(DataSampleValue chartX,DataSampleValue chartGroup, DataSampleValue chartY, DataSampleValue chartYErrorLowerRange, DataSampleValue chartYErrorUpperRange)
			{
				this.chartX = chartX;
				this.chartY = chartY;
				this.chartGroup = chartGroup;
				this.chartYErrorLowerRange = chartYErrorLowerRange;
				this.chartYErrorUpperRange = chartYErrorUpperRange;
				return this;
			}
		
		public String getDescription()
			{
				return description;
			}
		
		public void setDescription(String description)
			{
				this.description = description;
			}
		
		@Override
		public String toString()
			{
				return description;
			}
		
		public int indexOfColumnType(DataSampleValueFactory.DataSampleValue dataType)
			{
				return columnDataTypes.indexOf(dataType);
			}
		
		protected String																																												description;
		protected DataSampleValue																																			chartX;
		protected DataSampleValue																																			chartGroup;
		protected DataSampleValue																																			chartY;
		protected DataSampleValue																																			chartYErrorLowerRange;
		protected DataSampleValue																																			chartYErrorUpperRange;
		protected ArrayList<String>																																	columnNames;
		protected ArrayList<DataSampleValueFactory.DataSampleValue>	columnDataTypes;
		
	}

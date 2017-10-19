package org.qsari.effectopedia.data.quantification;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.quantification.DataSampleValueFactory.DataSampleValue;
import org.qsari.effectopedia.gui.util.HexColorConverter;

public class DataTemplate implements Importable, Exportable, Cloneable
	{
		public DataTemplate()
			{
				super();
			}
		
		public DataTemplate(DataSeries series)
			{
				setSeries(series);
			}
		
		public void cloneFieldsTo(DataTemplate clone)
			{
				clone.yDataColumnOffset = this.yDataColumnOffset;
				clone.showRawData = this.showRawData;
				clone.markerType = this.markerType;
				clone.markerFillColor = this.markerFillColor;
				clone.markerOutlineColor = this.markerOutlineColor;
				clone.markerSize = this.markerSize;
				clone.seriesTitle = this.seriesTitle;
				clone.objProp = this.objProp;
				if (type != null)
					clone.type = this.type.clone();
			}
		
		public void cloneProperties(EffectopediaObject owner)
			{
				objProp = objProp.clone(owner);
			}
		
		public DataTemplate clone()
			{
				DataTemplate clone = new DataTemplate(series != null ? series.clone() : null);
				cloneFieldsTo(clone);
				return clone;
			}
		
		@Override
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						seriesTitle = element.getValueElement("series_title").getValue();
						BaseIOElement marker = element.getChild("marker");
						if (marker != null)
							{
								BaseIOAttribute markerAttribute = marker.getAttribute("type");
								if (markerAttribute != null)
									markerType = markerAttribute.getIntValue();
								markerAttribute = marker.getAttribute("size");
								if (markerAttribute != null)
									markerSize = markerAttribute.getIntValue();
								markerAttribute = marker.getAttribute("fill_color");
								if (markerAttribute != null)
									markerFillColor = HexColorConverter.hexToColor(markerAttribute.getValue());
								markerAttribute = marker.getAttribute("outline_color");
								if (markerAttribute != null)
									markerOutlineColor = HexColorConverter.hexToColor(markerAttribute.getValue());
							}
						type = io.load(DataTemplateType.class, type, element.getChild("template_type"));
					}
			}
		
		@Override
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				element.addValueElement(io.newValue("series_title").setValue(seriesTitle));
				BaseIOElement marker = io.newElement("marker");
				marker.setAttribute("type", markerType);
				marker.setAttribute("size", markerSize);
				marker.setAttribute("fill_color", HexColorConverter.colorToHex(markerFillColor));
				marker.setAttribute("outline_color", HexColorConverter.colorToHex(markerOutlineColor));
				element.addChild(marker);
				element.addChild(type.store(io.newElement("template_type"), io));
				return element;
			}
		
		public ArrayList<String> getColumnNames()
			{
				return type.columnNames;
			}
		
		public DataSeries getSeries()
			{
				return series;
			}
		
		public void setSeries(DataSeries series)
			{
				this.series = series;
				if (series != null)
					yDataColumnOffset = series.x.count(showRawData);
				else
					yDataColumnOffset = -1;
			}
		
		public Object getSeriesValueAt(int rowIndex, int columnIndex)
			{
				if (series == null)
					return null;
				DataSampleValueFactory.DataSampleValue value = type.getColumnDataTypes().get(columnIndex);
				if (columnIndex < yDataColumnOffset)
					return value.get(series.x, rowIndex, columnIndex);
				else
					return value.get(series.y, rowIndex, columnIndex - yDataColumnOffset);
			}
		
		public Object getObjPropValueAt(int rowIndex, int columnIndex)
			{
				if (objProp == null)
					return null;
				DataSampleValueFactory.DataSampleValue value = type.getColumnDataTypes().get(columnIndex);
				return value.get(objProp, rowIndex, 0);
			}
		
		public void setSeriesValueAt(int rowIndex, int columnIndex, Object value)
			{
				if ((series == null) || (value == null))
					return;
				double v;
				if (value instanceof String)
					v = Double.valueOf((String) value);
				else if (value instanceof Number)
					v = (Double) value;
				else
					v = Double.NaN;
				DataSampleValueFactory.DataSampleValue sampleValue = type.getColumnDataTypes().get(columnIndex);
				if (columnIndex < yDataColumnOffset)
					sampleValue.set(series.x, rowIndex, columnIndex, v);
				else
					sampleValue.set(series.y, rowIndex, columnIndex, v);
			}
		
		public void setObjPropValueAt(int rowIndex, int columnIndex, Object value)
			{
				if ((objProp == null) || (value == null))
					return;
				double v;
				if (value instanceof String)
					v = Double.valueOf((String) value);
				else if (value instanceof Number)
					v = (Double) value;
				else
					v = Double.NaN;
				DataSampleValueFactory.DataSampleValue sampleValue = type.getColumnDataTypes().get(columnIndex);
				sampleValue.set(objProp, rowIndex, columnIndex, v);
			}
		
		public final int getMarkerType()
			{
				return markerType;
			}
		
		public final void setMarkerType(int markerType)
			{
				this.markerType = markerType;
			}
		
		public final Color getMarkerFillColor()
			{
				return markerFillColor;
			}
		
		public final void setMarkerFillColor(Color markerFillColor)
			{
				this.markerFillColor = markerFillColor;
			}
		
		public final Color getMarkerOutlineColor()
			{
				return markerOutlineColor;
			}
		
		public final void setMarkerOutlineColor(Color markerOutlineColor)
			{
				this.markerOutlineColor = markerOutlineColor;
			}
		
		public final int getMarkerSize()
			{
				return markerSize;
			}
		
		public final void setMarkerSize(int markerSize)
			{
				this.markerSize = markerSize;
			}
		
		public final String getSeriesTitle()
			{
				return seriesTitle;
			}
		
		public final void setSeriesTitle(String seriesTitle)
			{
				this.seriesTitle = seriesTitle;
			}
		
		public DataTemplateType getType()
			{
				return type;
			}
		
		public DataTemplate setType(DataTemplateType type)
			{
				this.type = type;
				return this;
			}
		
		public DataTemplate setSeriesOptions(String seriesTitle, int markerType, Color markerFillColor, Color seriesColor, int markerSize)
			{
				this.markerType = markerType;
				this.markerFillColor = markerFillColor;
				this.markerOutlineColor = seriesColor;
				this.markerSize = markerSize;
				this.seriesTitle = seriesTitle;
				return this;
			}
		
		public ObjectPropertyMultivalued_Documented getObjProp()
			{
				return objProp;
			}
		
		public void setObjProp(ObjectPropertyMultivalued_Documented objProp)
			{
				this.objProp = objProp;
				if ((objProp != null) && (type != null))
					{
						series = new DataSeries(objProp.valuesCount(), 0, true);
						type.chartX.set(series.x, objProp);
						type.chartY.set(series.y, objProp);
						type.chartYErrorLowerRange.set(series.y, objProp);
						type.chartYErrorUpperRange.set(series.y, objProp);
						for (DataSampleValue val : type.columnDataTypes)
							val.set(series.y, objProp);
					}
			}
		
		public DataSeries rebuildSeries()
			{
				if (objProp == null)
					return null;
				series = new DataSeries(objProp.valuesCount(), 0, true);
				type.chartX.set(series.x, objProp);
				series.x.setSimpleData(series.x.data);
				type.chartY.set(series.y, objProp);
				series.y.setSimpleData(series.y.data);
				type.chartYErrorLowerRange.set(series.y, objProp);
				type.chartYErrorUpperRange.set(series.y, objProp);
				return series;
			}
		
		protected TreeMap<Double, TreeMap<Double, Integer>> getGroupIndices()
			{
				return getGroupIndices(type.chartGroup, type.chartX);
			}
		
		protected TreeMap<Double, TreeMap<Double, Integer>> getGroupIndices(DataSampleValue groupValue, DataSampleValue xValue)
			{
				if (groupIndices == null)
					{
						groupIndices = new TreeMap<Double, TreeMap<Double, Integer>>();
						for (int i = objProp.valuesCount() - 1; i >= 0; i--)
							{
								Double grp = groupValue.get(objProp, i, 0);
								if (grp != null)
									{
										TreeMap<Double, Integer> group = groupIndices.get(grp);
										if (group == null)
											{
												group = new TreeMap<Double, Integer>();
												groupIndices.put(grp, group);
											}
										Double xVal = xValue.get(objProp, i, 0);
										if (xVal != null)
											group.put(xVal, i);
									}
							}
					}
				return groupIndices;
			}
		
		public DataSeries[] rebuildGroupedSeries()
			{
				return rebuildGroupedSeries(type.chartGroup, type.chartX);
			}
		
		public DataSeries[] rebuildGroupedSeries(DataSampleValue groupValue, DataSampleValue xValue)
			{
				if (objProp == null)
					return null;
				groupIndices = null;
				DataSeries[] dataSeries = new DataSeries[getGroupIndices(groupValue, xValue).size()];
				int grp = 0;
				for (Map.Entry<Double, TreeMap<Double, Integer>> group : groupIndices.entrySet())
					{
						series = new DataSeries(group.getValue().size(), 0, true);
						series.init(0.0);
						int i = 0;
						for (Integer index : group.getValue().values())
							{
								series.x.data[i] = type.chartX.get(objProp, index, 0);
								series.y.data[i] = nullToNaN(type.chartY.get(objProp, index, 0));
								series.y.displayMin[i] = nullToNaN(type.chartYErrorLowerRange.get(objProp, index, 0));
								series.y.displayMax[i] = nullToNaN(type.chartYErrorUpperRange.get(objProp, index, 0));
								i++;
							}
						series.y.rawDataMin = series.y.displayMin;
						series.y.rawDataMax = series.y.displayMax;
						series.x.setSimpleData(series.x.data);
						series.y.meanData = series.y.data;
						dataSeries[grp++] = series;
					}
				return dataSeries;
			}
		
		public static double nullToNaN(Double value)
			{
				return (value == null) ? Double.NaN : value;
			}
		
		private int																																									yDataColumnOffset	= -1;
		public boolean																																						showRawData							= false;
		protected int																																							markerType;
		protected Color																																					markerFillColor;
		protected Color																																					markerOutlineColor;
		protected int																																							markerSize;
		protected String																																				seriesTitle;
		
		protected DataSeries																																series;
		protected TreeMap<Double, TreeMap<Double, Integer>>	groupIndices;
		protected ObjectPropertyMultivalued_Documented						objProp;
		protected DataTemplateType																										type;
	}

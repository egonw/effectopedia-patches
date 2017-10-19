package org.qsari.effectopedia.data.quantification;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented.DescriptorComparator;
import org.qsari.effectopedia.data.quantification.DataSampleValueFactory.DataSampleDescriptorValue;
import org.qsari.effectopedia.data.quantification.DataSampleValueFactory.DataSampleValue;
import org.qsari.effectopedia.gui.comp.custom_table_header.ColumnGroup;
import org.qsari.effectopedia.gui.comp.custom_table_header.DefaultTableHeaderEditor.OptionsListener;
import org.qsari.effectopedia.gui.comp.custom_table_header.TableHeaderEditorManager;

public class DataTemplatesTableModel extends AbstractTableModel implements ModifiableTableModel
	{
		public DataTemplatesTableModel(DataTemplates templates, OptionsListener optionsListener)
			{
				this.templates = templates;
				this.optionsListener = optionsListener;
				if (templates.size() > 0)
					primaryData = templates.get(0);
				if ((templates.size() > 1) && (sharedXData))
					synchroniseXData();
				updateColumn2TemplateIndex();
			}
		
		@Override
		public Class<?> getColumnClass(int columnIndex)
			{
				return Double.class;
			}
		
		@Override
		public int getColumnCount()
			{
				if (columIndex2TemplateIndex != null)
					return columIndex2TemplateIndex.length;
				else
					return 0;
			}
		
		@Override
		public String getColumnName(int columnIndex)
			{
				if (columIndex2TemplateIndex == null)
					return null;
				else
					{
						int templateIndex = columIndex2TemplateIndex[columnIndex];
						return templates.get(templateIndex).getColumnNames().get(columnIndex - columnOffests[templateIndex]);
					}
			}
		
		@Override
		public int getRowCount()
			{
				if ((primaryData != null) && (primaryData.objProp != null))
					return primaryData.objProp.valuesCount();
				else
					return 0;
			}
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex)
			{
				if (columIndex2TemplateIndex == null)
					return null;
				else
					{
						int templateIndex = columIndex2TemplateIndex[columnIndex];
						Double value = (Double) templates.get(templateIndex).getObjPropValueAt(rowIndex, columnIndex - columnOffests[templateIndex]);
						
						if ((value == null) || (Double.isNaN(value)))
							return null;
						else
							return value;
					}
			}
		
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex)
			{
				if (columIndex2TemplateIndex != null)
					{
						int templateIndex = columIndex2TemplateIndex[columnIndex];
						if ((sharedXData) && (columnIndex == 0))
							for (DataTemplate template : templates)
								template.setObjPropValueAt(rowIndex, 0, aValue);
						else
							templates.get(templateIndex).setObjPropValueAt(rowIndex, columnIndex - columnOffests[templateIndex], aValue);
						fireTableCellUpdated(rowIndex, columnIndex);
					}
			}
		
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex)
			{
				return rowIndex >= 0;
			}
		
		protected void updateColumn2TemplateIndex()
			{
				int commonColumnsCnt = 1;
				if (primaryData.getType().chartGroup != null)
					commonColumnsCnt++;
				columnOffests = new Integer[templates.size()];
				ArrayList<Integer> index = new ArrayList<Integer>();
				if (sharedXData)
					{
						// TODO support for raw data in the ObjectPtoperties
						int commonColumns = 0;
						for (int t = 0; t < templates.size(); t++)
							{
								DataTemplate template = templates.get(t);
								columnOffests[t] = index.size() - commonColumns;
								for (int i = commonColumns; i < template.type.columnDataTypes.size(); i++)
									index.add(t);
								if (commonColumns == 0)
									commonColumns = commonColumnsCnt;
							}
					}
				else
					{
						for (int t = 0; t < templates.size(); t++)
							{
								DataTemplate template = templates.get(t);
								columnOffests[t] = index.size();
								for (int i = 0; i < template.type.columnDataTypes.size(); i++)
									index.add(t);
							}
					}
				columIndex2TemplateIndex = index.toArray(new Integer[index.size()]);
			}
		
		public void synchroniseXData()
			{
				int templateCount = templates.size();
				DescriptorType descriptorType;
				Comparator<ObjectProperty.ValueAndUnit> cmp;
				if (primaryData.type.chartX instanceof DataSampleDescriptorValue)
					{
						descriptorType = ((DataSampleDescriptorValue) primaryData.type.chartX).descriptorType;
						cmp = new DescriptorComparator(descriptorType);
					}
				else
					return;
				
				// Build a index for the common X axis descriptor. For each unique value
				HashMap<Double, BitSet> xValuesIndex = new HashMap<Double, BitSet>();
				for (int i = templateCount - 1; i >= 0; i--)
					{
						DataTemplate template = templates.get(i);
						ObjectPropertyMultivalued_Documented op = template.getObjProp();
						for (int j = op.valuesCount() - 1; j >= 0; j--)
							{
								Double value = template.type.chartX.get(op, j, 0);
								if (value != null)
									{
										BitSet indices = xValuesIndex.get(value);
										if (indices == null)
											indices = new BitSet(templateCount);
										indices.set(i, true);
										xValuesIndex.put(value, indices);
									}
							}
					}
				
				// Add a generic Documented_value for all values available in other
				// DataTemplates
				for (Iterator<Entry<Double, BitSet>> it = xValuesIndex.entrySet().iterator(); it.hasNext();)
					{
						Entry<Double, BitSet> entry = it.next();
						for (int i = templateCount - 1; i >= 0; i--)
							if (!entry.getValue().get(i))
								templates.get(i).getObjProp().add().getDescriptor(descriptorType).setFromDouble(entry.getKey());
					}
				
				// Sort all ObjectProperties
				for (DataTemplate template : templates)
					template.getObjProp().sort(cmp);
				
				// Check if all objectProperties have equal number of values
				for (DataTemplate template : templates)
					{
						ObjectPropertyMultivalued_Documented objProp = template.getObjProp();
						System.out.println("After sorting " + objProp.valuesCount());
						for (int i = 0; i < objProp.valuesCount(); i++)
							System.out.print(objProp.getValueAndUnitPair(i).getDescriptor(descriptorType).getDisplayValue());
						System.out.println();
						for (int i = 0; i < objProp.valuesCount(); i++)
							System.out.print(objProp.getValueAndUnitPair(i).getDisplayMinValue() + " ");
						System.out.println();
						for (int i = 0; i < objProp.valuesCount(); i++)
							System.out.print(objProp.getValueAndUnitPair(i).getDisplayValue() + " ");
						System.out.println();
						for (int i = 0; i < objProp.valuesCount(); i++)
							System.out.print(objProp.getValueAndUnitPair(i).getDisplayMaxValue() + " ");
						System.out.println();
					}
				fireTableDataChanged();
			}
		
		public void addDataRow()
			{
				for (DataTemplate template : templates)
					template.getObjProp().add();
			}
		
		public void addRow()
			{
				for (DataTemplate template : templates)
					template.getObjProp().add();
				int index = primaryData.objProp.valuesCount() - 2;
				fireTableRowsInserted(index, index);
			}
		
		public void addRows(int count)
			{
				int index = primaryData.objProp.valuesCount() - 1;
				if (index < 0)
					index = 0;
				for (DataTemplate template : templates)
					template.getObjProp().add(count);
				fireTableRowsInserted(index, index + count);
			}
		
		public void removeRow(int index)
			{
				if (index > -1)
					{
						for (DataTemplate template : templates)
							template.getObjProp().remove(index);
						fireTableRowsDeleted(index, index);
					}
			}
		
		public void removeAll()
			{
				int count = getRowCount();
				if (count > 0)
					{
						for (DataTemplate template : templates)
							template.getObjProp().clearValuePairs();
						fireTableRowsDeleted(0, count - 1);
					}
			}
		
		public String getDataAsTabDelimitedText()
			{
				Object value;
				StringBuilder text = new StringBuilder();
				int cntMinusOne = getColumnCount() - 1;
				
				// Append data header
				text.append(templates.getChartTitle());
				text.append("\n");
				if (sharedXData)
					{
						text.append(primaryData.type.columnNames.get(0));
						if (primaryData.getType().chartGroup != null)
							text.append(primaryData.type.columnNames.get(1));
						text.append("\t");
						for (Iterator<DataTemplate> it = templates.iterator(); it.hasNext();)
							{
								DataTemplate template = it.next();
								text.append(template.seriesTitle);
								if (it.hasNext())
									for (int i = template.type.columnDataTypes.size() - 2; i >= 0; i--)
										text.append("\t");
								else
									text.append("\n");
							}
					}
				for (int column = 0; column < cntMinusOne; column++)
					{
						text.append(getColumnName(column));
						text.append("\t");
					}
				text.append(getColumnName(cntMinusOne));
				text.append("\n");
				
				// Append data
				for (int row = 0; row < getRowCount(); row++)
					{
						for (int column = 0; column < cntMinusOne; column++)
							{
								value = getValueAt(row, column);
								if (value != null)
									text.append(value);
								text.append("\t");
							}
						value = getValueAt(row, cntMinusOne);
						if (value != null)
							text.append(value);
						text.append("\n");
					}
				return text.toString();
			}
		
		public void setDataFromTabDelimitedText(String text)
			{
				String[] lines = text.split("\\n");
				ArrayList<String[]> data = new ArrayList<String[]>(lines.length);
				for (int i = 0; i < lines.length; i++)
					data.add(lines[i].split("\\t"));
				int headerLinesCount = 0;
				while (headerLinesCount < data.size() && !(data.get(headerLinesCount)[0].matches("-?\\d+(\\.\\d+)?")))
					{
						if (headerLinesCount > 2)
							return;
						headerLinesCount++;
					}
				removeAll();
				
				// Load header
				DTsDefaultDispalySettings displaySettings = DTsDispalySettingsFactory.getSettings(templates, this);
				displaySettings.pasteHeader(data, headerLinesCount);
				
				// Load data
				int colCnt = getColumnCount();
				int row = 0;
				for (int i = headerLinesCount; i < data.size(); i++)
					{
						String[] dataLine = data.get(i);
						int length = dataLine.length;
						length = (length > colCnt) ? colCnt : length;
						for (DataTemplate template : templates)
							template.getObjProp().add();
						for (int j = 0; j < length; j++)
							{
								try
									{
										Double value = Double.valueOf(dataLine[j]);
										if (value != null)
											setValueAt(value, row, j);
									}
								catch (Exception e)
									{
										;
									}
							}
						row++;
					}
				
				fireTableDataChanged();
			}
		
		@Override
		public ColumnGroup createHeader(JTable inTable, TableHeaderEditorManager manager)
			{
				DTsDefaultDispalySettings displaySettings = DTsDispalySettingsFactory.getSettings(templates, this);
				return displaySettings.createHeader(inTable, manager, optionsListener);
			}
		
		public DTsDefaultDispalySettings getDisplaySettings()
			{
				return DTsDispalySettingsFactory.getSettings(templates, this);
			}
		
		public int findColumnIndex(int templateIndex, DataSampleValue valueType)
			{
				return columnOffests[templateIndex] + templates.get(templateIndex).getType().indexOfColumnType(valueType);
			}
		
		public static final String getFirstLine(String text)
			{
				int p = text.indexOf("\n");
				return (p == -1) ? text : text.subSequence(0, p).toString();
			}
		
		public boolean												showRawData						= false;
		public boolean												sharedXData						= true;
		public DataTemplates						templates;
		protected OptionsListener	optionsListener;
		protected DataTemplate				primaryData						= null;
		protected Integer[]							columIndex2TemplateIndex;
		protected Integer[]							columnOffests;
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
	}

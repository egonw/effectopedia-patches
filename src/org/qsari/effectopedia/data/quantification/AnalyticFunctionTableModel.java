package org.qsari.effectopedia.data.quantification;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.data.quantification.DataSampleValueFactory.DataSampleDescriptorValue;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.gui.comp.custom_table_header.ColumnGroup;
import org.qsari.effectopedia.gui.comp.custom_table_header.GroupableTableHeader;
import org.qsari.effectopedia.gui.comp.custom_table_header.TableHeaderEditorManager;
import org.qsari.effectopedia.gui.obj_prop.ChartOptionsUI;

public class AnalyticFunctionTableModel extends AbstractTableModel implements ModifiableTableModel
	{
		
		public AnalyticFunctionTableModel(AnalyticFunction analyticFn)
			{
				this.analyticFn = analyticFn;
			}
		
		@Override
		public Class<?> getColumnClass(int columnIndex)
			{
				if ((columnIndex == 0) || (columnIndex == descrInedx))
					return String.class;
				else
					return Double.class;
			}
		
		@Override
		public int getColumnCount()
			{
				int count = (defineUncertainty) ? 4 : 2;
				if (provideParameterDescription)
					return count + 1;
				else
					return count;
			}
		
		@Override
		public String getColumnName(int columnIndex)
			{
				return COLUMN_NAMES[columnIndex];
			}
		
		@Override
		public int getRowCount()
			{
				if (analyticFn != null)
					return analyticFn.getParameters().valuesCount();
				else
					return 0;
			}
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex)
			{
				if (analyticFn == null)
					return null;
				if (columnIndex == 0)
					return analyticFn.getParameters().getValueAndUnitPair(rowIndex).getDescriptor(DefaultEffectopediaObjects.DEFAULT_PARAMETER_NAME).getDisplayValue();
				else if (columnIndex == 1)
					return analyticFn.getParameters().getValueAndUnitPair(rowIndex).getDoubleValue();
				else if (columnIndex == minValueIndex)
					return analyticFn.getParameters().getValueAndUnitPair(rowIndex).getMinValueAsDouble();
				else if (columnIndex == maxValueIndex)
					return analyticFn.getParameters().getValueAndUnitPair(rowIndex).getMaxValueAsDouble();
				else if (columnIndex == descrInedx)
					return analyticFn.getParameters().getValueAndUnitPair(rowIndex).getNotes();
				else
					return null;
			}
		
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex)
			{
				if (analyticFn != null)
					{
						if (columnIndex == 0)
							analyticFn.getParameters().getValueAndUnitPair(rowIndex).getDescriptor(DefaultEffectopediaObjects.DEFAULT_PARAMETER_NAME).setValue((String) aValue);
						else if (columnIndex == 1)
							analyticFn.getParameters().getValueAndUnitPair(rowIndex).setDoubleValue((Double) aValue);
						else if (columnIndex == minValueIndex)
							analyticFn.getParameters().getValueAndUnitPair(rowIndex).setMinValueFromDouble((Double) aValue);
						else if (columnIndex == maxValueIndex)
							analyticFn.getParameters().getValueAndUnitPair(rowIndex).setMaxValueFromDouble((Double) aValue);
						else if (columnIndex == descrInedx)
							analyticFn.getParameters().getValueAndUnitPair(rowIndex).setNotes((String) aValue);
						else
							return;
						fireTableCellUpdated(rowIndex, columnIndex);
					}
			}
		
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex)
			{
				return rowIndex >= 0;
			}
		
		public void generateDefaultTitlesIfNeeded()
			{
				String xAxisTitle = analyticFn.getTemplates().getxAxisTitle();
				String yAxisTitle = analyticFn.getTemplates().getyPrimaryAxisTitle();
				String chartTitle = analyticFn.getTemplates().getChartTitle();
				DataTemplates templates = analyticFn.getTemplates();
				if (((xAxisTitle == null) || (xAxisTitle.length() == 0)) && ((templates.get(0).getType().getChartX() instanceof DataSampleDescriptorValue)))
					{
						DescriptorType descriptorType = ((DataSampleDescriptorValue) templates.get(0).getType().getChartX()).descriptorType;
						templates.setxAxisTitle(descriptorType.getDescription());
					}
				if (((yAxisTitle == null) || (yAxisTitle.length() == 0)))
					{
						yAxisTitle = "Measured response";
						templates.setyPrimaryAxisTitle(yAxisTitle);
					}
				if ((((chartTitle == null) || (chartTitle.length() == 0))) && (templates.getOwner() != null))
					{
						EffectopediaObject eo = templates.getOwner().getParent();
						while (eo != null)
							{
								if (eo instanceof Titleable)
									{
										chartTitle = ((Titleable) eo).getTitle();
										break;
									}
								eo = eo.getParent();
							}
						templates.setChartTitle(chartTitle);
					}
			}
		
		public ColumnGroup createHeader(JTable inTable, TableHeaderEditorManager manager)
			{
				generateDefaultTitlesIfNeeded();
				ChartOptionsUI titleEditor = new ChartOptionsUI(this);
				ColumnGroup g_title = new ColumnGroup(analyticFn.getTemplates(), titleEditor);
				titleEditor.load(analyticFn.getTemplates(), false);
				
				Enumeration<TableColumn> columns = inTable.getColumnModel().getColumns();
				while (columns.hasMoreElements())
					g_title.add(((TableColumn) columns.nextElement()));
				
				GroupableTableHeader header = (GroupableTableHeader) inTable.getTableHeader();
				header.removeAllColumnGroups();
				header.addColumnGroup(g_title);
				manager.clearEditors();
				manager.setEditor(g_title, titleEditor);
				return g_title;
			}
		
		public void addRow()
			{
				if (analyticFn != null)
					{
						int cnt = analyticFn.getParameters().valuesCount();
						analyticFn.getParameters().add();
						fireTableRowsInserted(cnt, cnt);
					}
			}
		
		public void removeRow(int index)
			{
				if (analyticFn != null)
					{
						analyticFn.getParameters().remove(index);
						fireTableRowsDeleted(index, index);
					}
			}
		
		public void removeAll()
			{
				int count = getRowCount();
				if ((count > 0) && (analyticFn != null))
					{
						analyticFn.getParameters().clearValuePairs();
						fireTableRowsDeleted(0, count - 1);
					}
			}
		
		public String getDataAsTabDelimitedText()
			{
				Object value;
				StringBuilder text = new StringBuilder();
				int cntMinusOne = getColumnCount() - 1;
				
				// Append data header
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
				for (int i = 0; i < lines.length - 1; i++)
					data.add(lines[i].split("\\t"));
				int headerLines = 0;
				while (headerLines < data.size() && !(data.get(headerLines)[0].matches("-?\\d+(\\.\\d+)?")))
					{
						if (headerLines > 1)
							return;
						headerLines++;
					}
				
				removeAll();
				// Load data
				int colCnt = getColumnCount();
				int row = 0;
				for (int i = headerLines; i < data.size(); i++)
					{
						String[] dataLine = data.get(i);
						int length = dataLine.length;
						length = (length > colCnt) ? colCnt : length;
						addRow();
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
		
		public boolean isDefineUncertainty()
			{
				return defineUncertainty;
			}
		
		public void setDefineUncertainty(boolean defineUncertainty)
			{
				this.defineUncertainty = defineUncertainty;
				fireTableStructureChanged();
			}
		
		public boolean isProvideParameterDescription()
			{
				return provideParameterDescription;
			}
		
		public void setProvideParameterDescription(boolean provideParameterDescription)
			{
				this.provideParameterDescription = provideParameterDescription;
				if (defineUncertainty)
					{
						minValueIndex = 2;
						maxValueIndex = 3;
						descrInedx = 4;
					}
				else
					{
						minValueIndex = -2;
						maxValueIndex = -3;
						descrInedx = 2;
					}
				fireTableStructureChanged();
			}
		
		public boolean															defineUncertainty											= true;
		public boolean															provideParameterDescription	= true;
		public AnalyticFunction						analyticFn;
		protected int																minValueIndex															= 2;
		protected int																maxValueIndex															= 3;
		protected int																descrInedx																		= 4;
		public static final String[]	COLUMN_NAMES																=
																																																												{ "parameter", "value", "lower param. range", "upper param. range", "description" };
		/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	}

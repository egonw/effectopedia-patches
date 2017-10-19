package org.qsari.effectopedia.data.quantification;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.data.quantification.DataSampleValueFactory.DataSampleDescriptorValue;
import org.qsari.effectopedia.gui.chart.ChartDataSeries;
import org.qsari.effectopedia.gui.chart.ChartPanel;
import org.qsari.effectopedia.gui.chart.ChartTemplate;
import org.qsari.effectopedia.gui.comp.custom_table_header.ColumnGroup;
import org.qsari.effectopedia.gui.comp.custom_table_header.DefaultTableHeaderEditor;
import org.qsari.effectopedia.gui.comp.custom_table_header.DefaultTableHeaderEditor.OptionsListener;
import org.qsari.effectopedia.gui.comp.custom_table_header.GroupableTableHeader;
import org.qsari.effectopedia.gui.comp.custom_table_header.MultiLineTableHeaderRenderer;
import org.qsari.effectopedia.gui.comp.custom_table_header.TableHeaderEditorManager;
import org.qsari.effectopedia.gui.obj_prop.ChartSeriesNameAndLookUI;
import org.qsari.effectopedia.gui.obj_prop.ChartTitleAndYAxisEditorUI;
import org.qsari.effectopedia.gui.obj_prop.ChartXAxisEditorUI;

public class DTsDefaultDispalySettings
	{
		protected DTsDefaultDispalySettings(DataTemplates templates, DataTemplatesTableModel tableModel)
			{
				this.templates = templates;
				this.tableModel = tableModel;
			}
		
		public void generateDefaultTitlesIfNeeded()
			{
				String xAxisTitle = templates.getxAxisTitle();
				String groupingTitle = templates.getGroupingTitle();
				String yAxisTitle = templates.getyPrimaryAxisTitle();
				String chartTitle = templates.getChartTitle();
				if (((xAxisTitle == null) || (xAxisTitle.length() == 0)) && ((templates.get(0).getType().getChartX() instanceof DataSampleDescriptorValue)))
					{
						DescriptorType descriptorType = ((DataSampleDescriptorValue) templates.get(0).getType().getChartX()).descriptorType;
						templates.setxAxisTitle(descriptorType.getDescription());
					}
				if (((groupingTitle == null) || (groupingTitle.length() == 0)) && ((templates.get(0).getType().getChartGroup() instanceof DataSampleDescriptorValue)))
					{
						DescriptorType descriptorType = ((DataSampleDescriptorValue) templates.get(0).getType().getChartGroup()).descriptorType;
						templates.setGroupingTitle(descriptorType.getDescription());
					}
				if (((yAxisTitle == null) || (yAxisTitle.length() == 0)))
					{
						yAxisTitle = templates.getTypes().get(0).getDescription();
						templates.setyPrimaryAxisTitle(yAxisTitle);
						templates.setySecondaryAxisTitle(yAxisTitle);
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
		
		public ColumnGroup createHeader(JTable inTable, TableHeaderEditorManager manager, OptionsListener optionsListener)
			{
				ColumnGroup[] templateHeaders = new ColumnGroup[templates.size()];
				generateDefaultTitlesIfNeeded();
				ChartTitleAndYAxisEditorUI titleEditor = new ChartTitleAndYAxisEditorUI(tableModel);
				titleEditor.setOptionsListener(optionsListener);
				ColumnGroup g_title = new ColumnGroup(templates, titleEditor);
				titleEditor.load(templates, false);
				
				TableColumnModel cm = inTable.getColumnModel();
				
				MultiLineTableHeaderRenderer renderer = new MultiLineTableHeaderRenderer();
				Enumeration<TableColumn> columns = cm.getColumns();
				while (columns.hasMoreElements())
					((TableColumn) columns.nextElement()).setHeaderRenderer(renderer);
				
				g_title.add(cm.getColumn(0));
				int column = tableModel.sharedXData ? 1 : 0;
				for (int i = 0; i < templates.size(); i++)
					{
						DataTemplate template = templates.get(i);
						ChartSeriesNameAndLookUI seriesEditor = new ChartSeriesNameAndLookUI(tableModel);
						seriesEditor.load(template, false);
						templateHeaders[i] = new ColumnGroup(template, seriesEditor);
						for (int j = template.type.columnDataTypes.size() - 2; j >= 0; j--)
							templateHeaders[i].add(cm.getColumn(column++));
						g_title.add(templateHeaders[i]);
					}
				GroupableTableHeader header = (GroupableTableHeader) inTable.getTableHeader();
				header.removeAllColumnGroups();
				header.addColumnGroup(g_title);
				manager.clearEditors();
				for (int i = 0; i < templates.size(); i++)
					manager.setEditor(templateHeaders[i], (DefaultTableHeaderEditor) templateHeaders[i].getHeaderRenderer());
				manager.setEditor(g_title, titleEditor);
				ChartXAxisEditorUI xAxisTitle = new ChartXAxisEditorUI(tableModel);
				manager.setEditor(cm.getColumn(0), xAxisTitle);
				cm.getColumn(0).setHeaderRenderer(xAxisTitle);
				xAxisTitle.load(templates, false);
				return g_title;
			}
		
		public void pasteHeader(ArrayList<String[]> data, int headerLinesCount)
			{
				if ((headerLinesCount!=3)||(data.get(0).length!=1))
					return;
				if (data.get(1).length!=2*templates.size())
					return;
				if (data.get(2).length!=tableModel.getColumnCount())
				 return;
			}
		
		public DTsDefaultDispalySettings updateChart(ChartPanel cpChart)
			{
				String xAxisTitle = templates.getxAxisTitle() + " [" + templates.getDefaultXDisplayUnit() + "]";
				String yAxisTitle = templates.getyPrimaryAxisTitle() + " [" + templates.getDefaultYDisplayUnit() + "]";
				String chartTitle = templates.getChartTitle();
				ChartTemplate chartTemplate = new ChartTemplate(xAxisTitle, yAxisTitle, chartTitle);
				cpChart.reset();
				if (tableModel.getRowCount() > 0)
					{
						cpChart.createPrimaryAxis(chartTemplate);
						for (DataTemplate template : templates)
							{
								DataSeries series = template.rebuildSeries();
								series.updateRanges();
								ChartDataSeries chartSeries = new ChartDataSeries(series, cpChart.primaryXAxis, cpChart.primaryYAxis, template.getMarkerType(), template.getMarkerOutlineColor());
								chartSeries.getMarker().setSize(template.getMarkerSize());
								cpChart.getPrimarySeries().add(chartSeries);
							}
						cpChart.primaryViewport.setSeries(cpChart.getPrimarySeries());
					}
				cpChart.repaint();
				return this;
			}
		
		public DataTemplates getTemplates()
			{
				return templates;
			}
		
		public void setTemplates(DataTemplates templates)
			{
				this.templates = templates;
			}
		
		public DataTemplatesTableModel getTableModel()
			{
				return tableModel;
			}
		
		public void setTableModel(DataTemplatesTableModel tableModel)
			{
				this.tableModel = tableModel;
			}
		
		protected DataTemplates											templates;
		protected DataTemplatesTableModel	tableModel;
	}

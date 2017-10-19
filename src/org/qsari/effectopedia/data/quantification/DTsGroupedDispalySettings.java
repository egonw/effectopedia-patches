package org.qsari.effectopedia.data.quantification;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.qsari.effectopedia.gui.chart.ChartDataSeries;
import org.qsari.effectopedia.gui.chart.ChartPanel;
import org.qsari.effectopedia.gui.chart.ChartTemplate;
import org.qsari.effectopedia.gui.comp.custom_table_header.ColumnGroup;
import org.qsari.effectopedia.gui.comp.custom_table_header.DefaultTableHeaderEditor;
import org.qsari.effectopedia.gui.comp.custom_table_header.DefaultTableHeaderEditor.OptionsListener;
import org.qsari.effectopedia.gui.comp.custom_table_header.GroupableTableHeader;
import org.qsari.effectopedia.gui.comp.custom_table_header.MultiLineTableHeaderRenderer;
import org.qsari.effectopedia.gui.comp.custom_table_header.TableHeaderEditorManager;
import org.qsari.effectopedia.gui.obj_prop.ChartGroupEditorUI;
import org.qsari.effectopedia.gui.obj_prop.ChartSeriesNameAndLookUI;
import org.qsari.effectopedia.gui.obj_prop.ChartTitleAndYAxisEditorUI;
import org.qsari.effectopedia.gui.obj_prop.ChartXAxisEditorUI;

public class DTsGroupedDispalySettings extends DTsDefaultDispalySettings
	{
		protected DTsGroupedDispalySettings(DataTemplates templates, DataTemplatesTableModel tableModel)
			{
				super(templates, tableModel);
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
				g_title.add(cm.getColumn(1));
				int column = tableModel.sharedXData ? 2 : 0;
				for (int i = 0; i < templates.size(); i++)
					{
						DataTemplate template = templates.get(i);
						ChartSeriesNameAndLookUI seriesEditor = new ChartSeriesNameAndLookUI(tableModel);
						seriesEditor.load(template, false);
						templateHeaders[i] = new ColumnGroup(template, seriesEditor);
						for (int j = template.type.columnDataTypes.size() - 3; j >= 0; j--)
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
				
				ChartGroupEditorUI groupTitle = new ChartGroupEditorUI(tableModel);
				manager.setEditor(cm.getColumn(1), groupTitle);
				cm.getColumn(1).setHeaderRenderer(groupTitle);
				groupTitle.load(templates, false);
				
				return g_title;
			}
		
		public void pasteHeader(ArrayList<String[]> data, int headerLinesCount)
			{
				if ((headerLinesCount != 3) || (data.get(0).length != 1))
					return;
				if (data.get(1).length != 2 * templates.size())
					return;
				if (data.get(2).length != tableModel.getColumnCount())
					return;
			}
		
		public DTsGroupedDispalySettings updateChart(ChartPanel cpChart)
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
								DataSeries[] series = template.rebuildGroupedSeries();
								for (int grp = 0; grp < series.length; grp++)
									{
										series[grp].updateRanges();
										ChartDataSeries chartSeries = new ChartDataSeries(series[grp], cpChart.primaryXAxis, cpChart.primaryYAxis, template.getMarkerType(), template.getMarkerOutlineColor());
										chartSeries.getMarker().setSize(template.getMarkerSize());
										chartSeries.getMarker().fillColor = getColorFromTemplate(template, grp, series.length - 1);
										cpChart.getPrimarySeries().add(chartSeries);
									}
							}
						cpChart.primaryViewport.setSeries(cpChart.getPrimarySeries());
					}
				cpChart.repaint();
				return this;
			}
		
		public static Color getColorFromTemplate(DataTemplate template, int index, int paleteSize)
			{
				double fillW = (paleteSize == 0) ? 1 : ((double) index) / paleteSize;
				double outlineW = 1 - fillW;
				Color fill = template.markerFillColor;
				Color outline = template.markerOutlineColor;
				double red = fill.getRed() * fillW + outline.getRed() * outlineW;
				double green = fill.getGreen() * fillW + outline.getGreen() * outlineW;
				double blue = fill.getBlue() * fillW + outline.getBlue() * outlineW;
				return new Color((int) red, (int) green, (int) blue);
			}
	}

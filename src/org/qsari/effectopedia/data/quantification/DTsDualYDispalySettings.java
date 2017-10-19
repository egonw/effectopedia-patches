package org.qsari.effectopedia.data.quantification;

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
import org.qsari.effectopedia.gui.obj_prop.ChartTitleEditorUI;
import org.qsari.effectopedia.gui.obj_prop.ChartXAxisEditorUI;
import org.qsari.effectopedia.gui.obj_prop.ChartYAxisAndLookUI;

public class DTsDualYDispalySettings extends DTsDefaultDispalySettings
	{
		
		protected DTsDualYDispalySettings(DataTemplates templates, DataTemplatesTableModel tableModel)
		{
			super(templates, tableModel);
		}

		public ColumnGroup createHeader(JTable inTable, TableHeaderEditorManager manager, OptionsListener optionsListener)
			{
				ColumnGroup[] templateHeaders = new ColumnGroup[templates.size()];
				generateDefaultTitlesIfNeeded();
				ChartTitleEditorUI titleEditor = new ChartTitleEditorUI(tableModel);
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
						ChartYAxisAndLookUI seriesEditor = new ChartYAxisAndLookUI(tableModel, i < templates.secondaryAxisTemplateIndex);
						seriesEditor.load(templates, false);
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
		
		@Override
		public DTsDualYDispalySettings updateChart(ChartPanel cpChart)
			{
				String xAxisTitle = templates.getxAxisTitle() + " [" + templates.getDefaultXDisplayUnit() + "]";
				String yPrimaryAxisTitle = templates.getyPrimaryAxisTitle() + " [" + templates.getDefaultYDisplayUnit() + "]";
				String ySecondaryAxisTitle = templates.getySecondaryAxisTitle() + " [" + templates.getSecondaryYDisplayUnit() + "]";
				String chartTitle = templates.getChartTitle();
				ChartTemplate chartTemplate = new ChartTemplate(xAxisTitle, yPrimaryAxisTitle, ySecondaryAxisTitle, chartTitle);
				cpChart.reset();
				int secondary = templates.secondaryAxisTemplateIndex == DataTemplates.NO_SECONDARY_AXIS ? templates.size() : templates.secondaryAxisTemplateIndex;
				if (tableModel.getRowCount() > 0)
					{
						cpChart.createDualYAxisChart(chartTemplate);
						for (int templateIndex = 0; templateIndex < templates.size(); templateIndex++)
							{
								DataTemplate template = templates.get(templateIndex);
								DataSeries series = template.rebuildSeries();
								series.updateRanges();
								if (templateIndex < secondary)
									{
										ChartDataSeries chartSeries = new ChartDataSeries(series, cpChart.primaryXAxis, cpChart.primaryYAxis, template.getMarkerType(), template.getMarkerOutlineColor());
										chartSeries.getMarker().setSize(template.getMarkerSize());
										cpChart.getPrimarySeries().add(chartSeries);
										cpChart.primaryYAxis.setLabelColor(template.getMarkerOutlineColor());
										cpChart.primaryYAxisTitle.setTitleColor(template.getMarkerOutlineColor());
									}
								else
									{
										ChartDataSeries chartSeries = new ChartDataSeries(series, cpChart.primaryXAxis, cpChart.secondaryYAxis, template.getMarkerType(), template.getMarkerOutlineColor());
										chartSeries.getMarker().setSize(template.getMarkerSize());
										cpChart.getSecondarySeries().add(chartSeries);
										cpChart.secondaryYAxis.setLabelColor(template.getMarkerOutlineColor());
										cpChart.secondaryYAxisTitle.setTitleColor(template.getMarkerOutlineColor());
									}
							}
						cpChart.primaryViewport.setSeries(cpChart.getPrimarySeries());
						cpChart.secondaryViewport.setSeries(cpChart.getSecondarySeries());

					}
				cpChart.repaint();
				return this;
			}
		
	}

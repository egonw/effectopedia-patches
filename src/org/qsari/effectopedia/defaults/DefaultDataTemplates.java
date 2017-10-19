package org.qsari.effectopedia.defaults;

import java.awt.Color;

import org.qsari.effectopedia.data.quantification.DataSampleValueFactory;
import org.qsari.effectopedia.data.quantification.DataTemplate;
import org.qsari.effectopedia.data.quantification.DataTemplates;
import org.qsari.effectopedia.gui.chart.ChartDataSeries;
import org.qsari.effectopedia.gui.chart.ChartUtils;

public class DefaultDataTemplates
	{
		public static DataTemplate		DT_TESTED_CHEM																				= new DataTemplate().setSeriesOptions("Tested Chemical", ChartDataSeries.MARKER_PLUS, Color.white, ChartUtils.chartSeriesRedColor,
																																																																		ChartUtils.defaultMarkerSize);
		public static DataTemplate		DT_REF_CHEM																							= new DataTemplate().setSeriesOptions("Reference Chemical", ChartDataSeries.MARKER_CIRCLE, Color.white,
																																																																		ChartUtils.chartSeriesBlueColor, ChartUtils.defaultMarkerSize);
		public static DataTemplate		DT_RESP_RESP																						= new DataTemplate().setSeriesOptions("Response response", ChartDataSeries.MARKER_CIRCLE, Color.white,
																																																																		ChartUtils.chartSeriesOrangeColor, ChartUtils.defaultMarkerSize);
		public static DataTemplate		DT_UPSTREAM																							= new DataTemplate().setSeriesOptions("Upstream (key) event", ChartDataSeries.MARKER_SQUARE, Color.white,
																																																																		ChartUtils.chartSeriesPurpleColor, ChartUtils.defaultMarkerSize);
		public static DataTemplate		DT_DOWNSTREAM																					= new DataTemplate().setSeriesOptions("Downstream (key) event", ChartDataSeries.MARKER_RHOMB, Color.white,
																																																																		ChartUtils.chartSeriesDarkGreenColor, ChartUtils.defaultMarkerSize);
		public static DataTemplate		DT_TIME_SERIES																				= new DataTemplate().setSeriesOptions("Time Series", ChartDataSeries.MARKER_PLUS, Color.white, ChartUtils.chartSeriesRedColor,
																																																																		ChartUtils.defaultMarkerSize);
		
		public static DataTemplates	DTS_TC_SINGLE_CHEM_MEAN_MIN_MAX			= new DataTemplates();
		public static DataTemplates	DTS_TC_SINGLE_CHEM_MEAN_STDEV					= new DataTemplates();
		public static DataTemplates	DTS_TC_SINGLE_CHEM_MEAN_SEM							= new DataTemplates();
		public static DataTemplates	DTS_TC_SINGLE_CHEM_MEAN_CI95						= new DataTemplates();
		public static DataTemplates	DTS_TC_SINGLE_CHEM_ALL												= new DataTemplates();
		public static DataTemplates	DTS_TC_SINGLE_T_CHEM_MEAN_MIN_MAX	= new DataTemplates();
		public static DataTemplates	DTS_TC_SINGLE_T_CHEM_MEAN_STDEV			= new DataTemplates();
		public static DataTemplates	DTS_TC_SINGLE_T_CHEM_MEAN_SEM					= new DataTemplates();
		public static DataTemplates	DTS_TC_SINGLE_T_CHEM_MEAN_CI95				= new DataTemplates();
		public static DataTemplates	DTS_TC_SINGLE_T_CHEM_ALL										= new DataTemplates();
		
		public static DataTemplates	DTS_DR_SINGLE_CHEM_MEAN_MIN_MAX			= new DataTemplates();
		public static DataTemplates	DTS_DR_SINGLE_CHEM_MEAN_STDEV					= new DataTemplates();
		public static DataTemplates	DTS_DR_SINGLE_CHEM_MEAN_SEM							= new DataTemplates();
		public static DataTemplates	DTS_DR_SINGLE_CHEM_MEAN_CI95						= new DataTemplates();
		public static DataTemplates	DTS_DR_SINGLE_CHEM_ALL												= new DataTemplates();
		public static DataTemplates	DTS_DR_SINGLE_T_MEAN_MIN_MAX						= new DataTemplates();
		public static DataTemplates	DTS_DR_SINGLE_T_MEAN_STDEV								= new DataTemplates();
		public static DataTemplates	DTS_DR_SINGLE_T_MEAN_SEM										= new DataTemplates();
		public static DataTemplates	DTS_DR_SINGLE_T_MEAN_CI95									= new DataTemplates();
		public static DataTemplates	DTS_DR_SINGLE_T_ALL															= new DataTemplates();
		
		public static DataTemplates	DTS_DR_DUAL_CHEM_MEAN_MIN_MAX					= new DataTemplates();
		public static DataTemplates	DTS_DR_DUAL_CHEM_MEAN_STDEV							= new DataTemplates();
		public static DataTemplates	DTS_DR_DUAL_CHEM_MEAN_SEM									= new DataTemplates();
		public static DataTemplates	DTS_DR_DUAL_CHEM_MEAN_CI95								= new DataTemplates();
		public static DataTemplates	DTS_DR_DUAL_CHEM_ALL														= new DataTemplates();
		public static DataTemplates	DTS_DR_DUAL_T_MEAN_MIN_MAX								= new DataTemplates();
		public static DataTemplates	DTS_DR_DUAL_T_MEAN_STDEV										= new DataTemplates();
		public static DataTemplates	DTS_DR_DUAL_T_MEAN_SEM												= new DataTemplates();
		public static DataTemplates	DTS_DR_DUAL_T_MEAN_CI95											= new DataTemplates();
		public static DataTemplates	DTS_DR_DUAL_T_ALL																	= new DataTemplates();
		
		public static DataTemplates	DTS_RESP_RESP_MEAN_MIN_MAX								= new DataTemplates();
		public static DataTemplates	DTS_RESP_RESP_MEAN_STDEV										= new DataTemplates();
		public static DataTemplates	DTS_RESP_RESP_MEAN_SEM												= new DataTemplates();
		public static DataTemplates	DTS_RESP_RESP_MEAN_CI95											= new DataTemplates();
		public static DataTemplates	DTS_RESP_RESP_ALL																	= new DataTemplates();
		
		public static DataTemplates	DTS_TIME_COURSE_MEAN_MIN_MAX						= new DataTemplates();
		public static DataTemplates	DTS_TIME_COURSE_MEAN_STDEV								= new DataTemplates();
		public static DataTemplates	DTS_TIME_COURSE_MEAN_SEM										= new DataTemplates();
		public static DataTemplates	DTS_TIME_COURSE_MEAN_CI95									= new DataTemplates();
		public static DataTemplates	DTS_TIME_COURSE_ALL															= new DataTemplates();
		
		public static DataTemplates	DTS_TIME_SERIES_MEAN_MIN_MAX						= new DataTemplates();
		public static DataTemplates	DTS_TIME_SERIES_MEAN_STDEV								= new DataTemplates();
		public static DataTemplates	DTS_TIME_SERIES_MEAN_SEM										= new DataTemplates();
		public static DataTemplates	DTS_TIME_SERIES_MEAN_CI95									= new DataTemplates();
		public static DataTemplates	DTS_TIME_SERIES_ALL															= new DataTemplates();
		
		public static void initTemplates()
			{
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_STDEV.addColumn("chem. conc.", DataSampleValueFactory.DESCR_VALUE);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_STDEV.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_STDEV.addColumn("standard deviation", DataSampleValueFactory.STDEV);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_STDEV.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_STDEV.updateChartSetup(DataSampleValueFactory.DESCR_VALUE, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_STDEV,
						DataSampleValueFactory.MEAN_PLUS_STDEV);
				
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_SEM.addColumn("chem. conc.", DataSampleValueFactory.DESCR_VALUE);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_SEM.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_SEM.addColumn("standard mean error", DataSampleValueFactory.SEM);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_SEM.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_SEM.updateChartSetup(DataSampleValueFactory.DESCR_VALUE, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_SEM,
						DataSampleValueFactory.MEAN_PLUS_SEM);
				
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_CI95.addColumn("chem. conc.", DataSampleValueFactory.DESCR_VALUE);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_CI95.addColumn("mean", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_CI95.addColumn("confidence interval 95%", DataSampleValueFactory.CI95);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_CI95.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_CI95.updateChartSetup(DataSampleValueFactory.DESCR_VALUE, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_CI95,
						DataSampleValueFactory.MEAN_PLUS_CI95);
				
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_MINMAX.addColumn("chem. conc.", DataSampleValueFactory.DESCR_VALUE);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_MINMAX.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_MINMAX.addColumn("min value", DataSampleValueFactory.LOWEST_REP);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_MINMAX.addColumn("max value", DataSampleValueFactory.HIGHEST_REP);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_MINMAX.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_MINMAX.updateChartSetup(DataSampleValueFactory.DESCR_VALUE, DataSampleValueFactory.VALUE, DataSampleValueFactory.LOWEST_REP,
						DataSampleValueFactory.HIGHEST_REP);
				
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_ALL.addColumn("chem. conc.", DataSampleValueFactory.DESCR_VALUE);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_ALL.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_ALL.addColumn("min value", DataSampleValueFactory.LOWEST_REP);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_ALL.addColumn("max value", DataSampleValueFactory.HIGHEST_REP);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_ALL.addColumn("standard deviation", DataSampleValueFactory.STDEV);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_ALL.addColumn("standard mean error", DataSampleValueFactory.SEM);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_ALL.addColumn("confidence interval 95%", DataSampleValueFactory.CI95);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_ALL.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_DR_DTT_ALL.updateChartSetup(DataSampleValueFactory.DESCR_VALUE, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_SEM,
						DataSampleValueFactory.MEAN_PLUS_SEM);
				
				DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_STDEV.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_STDEV.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_STDEV.addColumn("standard deviation", DataSampleValueFactory.STDEV);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_STDEV.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_STDEV.updateChartSetup(DataSampleValueFactory.TIME, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_STDEV,
						DataSampleValueFactory.MEAN_PLUS_STDEV);
				
				DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_SEM.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_SEM.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_SEM.addColumn("standard mean error", DataSampleValueFactory.SEM);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_SEM.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_SEM.updateChartSetup(DataSampleValueFactory.TIME, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_SEM,
						DataSampleValueFactory.MEAN_PLUS_SEM);
				
				DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_CI95.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_CI95.addColumn("mean", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_CI95.addColumn("confidence interval 95%", DataSampleValueFactory.CI95);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_CI95.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_CI95.updateChartSetup(DataSampleValueFactory.TIME, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_CI95,
						DataSampleValueFactory.MEAN_PLUS_CI95);
				
				DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_MINMAX.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_MINMAX.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_MINMAX.addColumn("min value", DataSampleValueFactory.LOWEST_REP);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_MINMAX.addColumn("max value", DataSampleValueFactory.HIGHEST_REP);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_MINMAX.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_MINMAX.updateChartSetup(DataSampleValueFactory.TIME, DataSampleValueFactory.VALUE, DataSampleValueFactory.LOWEST_REP,
						DataSampleValueFactory.HIGHEST_REP);
				
				DefaultEffectopediaObjects.DEFAULT_T_DTT_ALL.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_ALL.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_ALL.addColumn("min value", DataSampleValueFactory.LOWEST_REP);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_ALL.addColumn("max value", DataSampleValueFactory.HIGHEST_REP);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_ALL.addColumn("standard deviation", DataSampleValueFactory.STDEV);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_ALL.addColumn("standard mean error", DataSampleValueFactory.SEM);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_ALL.addColumn("confidence interval 95%", DataSampleValueFactory.CI95);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_ALL.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_T_DTT_ALL.updateChartSetup(DataSampleValueFactory.TIME, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_SEM,
						DataSampleValueFactory.MEAN_PLUS_SEM);

				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_STDEV.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_STDEV.addColumn("chem. conc.", DataSampleValueFactory.DESCR_VALUE);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_STDEV.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_STDEV.addColumn("standard deviation", DataSampleValueFactory.STDEV);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_STDEV.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_STDEV.updateChartSetup(DataSampleValueFactory.TIME,DataSampleValueFactory.DESCR_VALUE, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_STDEV,
						DataSampleValueFactory.MEAN_PLUS_STDEV);
				
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_SEM.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_SEM.addColumn("chem. conc.", DataSampleValueFactory.DESCR_VALUE);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_SEM.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_SEM.addColumn("standard mean error", DataSampleValueFactory.SEM);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_SEM.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_SEM.updateChartSetup(DataSampleValueFactory.TIME,DataSampleValueFactory.DESCR_VALUE, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_SEM,
						DataSampleValueFactory.MEAN_PLUS_SEM);
				
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_CI95.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_CI95.addColumn("chem. conc.", DataSampleValueFactory.DESCR_VALUE);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_CI95.addColumn("mean", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_CI95.addColumn("confidence interval 95%", DataSampleValueFactory.CI95);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_CI95.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_CI95.updateChartSetup(DataSampleValueFactory.TIME,DataSampleValueFactory.DESCR_VALUE, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_CI95,
						DataSampleValueFactory.MEAN_PLUS_CI95);
				
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_MINMAX.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_MINMAX.addColumn("chem. conc.", DataSampleValueFactory.DESCR_VALUE);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_MINMAX.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_MINMAX.addColumn("min value", DataSampleValueFactory.LOWEST_REP);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_MINMAX.addColumn("max value", DataSampleValueFactory.HIGHEST_REP);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_MINMAX.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_MEAN_MINMAX.updateChartSetup(DataSampleValueFactory.TIME,DataSampleValueFactory.DESCR_VALUE, DataSampleValueFactory.VALUE, DataSampleValueFactory.LOWEST_REP,
						DataSampleValueFactory.HIGHEST_REP);
				
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_ALL.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_ALL.addColumn("chem. conc.", DataSampleValueFactory.DESCR_VALUE);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_ALL.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_ALL.addColumn("min value", DataSampleValueFactory.LOWEST_REP);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_ALL.addColumn("max value", DataSampleValueFactory.HIGHEST_REP);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_ALL.addColumn("standard deviation", DataSampleValueFactory.STDEV);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_ALL.addColumn("standard mean error", DataSampleValueFactory.SEM);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_ALL.addColumn("confidence interval 95%", DataSampleValueFactory.CI95);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_ALL.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_T_DR_DTT_ALL.updateChartSetup(DataSampleValueFactory.TIME,DataSampleValueFactory.DESCR_VALUE, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_SEM,
						DataSampleValueFactory.MEAN_PLUS_SEM);

				DefaultEffectopediaObjects.DEFAULT_RR_DTT_MEAN_STDEV.addColumn("upstream (key) event", DataSampleValueFactory.UPSTREAM_CAUSE);
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_MEAN_STDEV.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_MEAN_STDEV.addColumn("standard deviation", DataSampleValueFactory.STDEV);
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_MEAN_STDEV.updateChartSetup(DataSampleValueFactory.UPSTREAM_CAUSE, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_STDEV,
						DataSampleValueFactory.MEAN_PLUS_STDEV);
				
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_MEAN_SEM.addColumn("upstream (key) event", DataSampleValueFactory.UPSTREAM_CAUSE);
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_MEAN_SEM.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_MEAN_SEM.addColumn("standard mean error", DataSampleValueFactory.SEM);
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_MEAN_SEM.updateChartSetup(DataSampleValueFactory.UPSTREAM_CAUSE, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_SEM,
						DataSampleValueFactory.MEAN_PLUS_SEM);
				
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_MEAN_CI95.addColumn("upstream (key) event", DataSampleValueFactory.UPSTREAM_CAUSE);
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_MEAN_CI95.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_MEAN_CI95.addColumn("confidence interval 95%", DataSampleValueFactory.CI95);
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_MEAN_CI95.updateChartSetup(DataSampleValueFactory.UPSTREAM_CAUSE, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_CI95,
						DataSampleValueFactory.MEAN_PLUS_CI95);
				
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_MEAN_MINMAX.addColumn("upstream (key) event", DataSampleValueFactory.UPSTREAM_CAUSE);
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_MEAN_MINMAX.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_MEAN_MINMAX.addColumn("min value", DataSampleValueFactory.LOWEST_REP);
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_MEAN_MINMAX.addColumn("max value", DataSampleValueFactory.HIGHEST_REP);
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_MEAN_MINMAX.updateChartSetup(DataSampleValueFactory.UPSTREAM_CAUSE, DataSampleValueFactory.VALUE, DataSampleValueFactory.LOWEST_REP,
						DataSampleValueFactory.HIGHEST_REP);
				
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_ALL.addColumn("upstream (key) event", DataSampleValueFactory.UPSTREAM_CAUSE);
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_ALL.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_ALL.addColumn("min value", DataSampleValueFactory.LOWEST_REP);
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_ALL.addColumn("max value", DataSampleValueFactory.HIGHEST_REP);
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_ALL.addColumn("standard deviation", DataSampleValueFactory.STDEV);
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_ALL.addColumn("standard mean error", DataSampleValueFactory.SEM);
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_ALL.addColumn("confidence interval 95%", DataSampleValueFactory.CI95);
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_ALL.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_RR_DTT_ALL.updateChartSetup(DataSampleValueFactory.UPSTREAM_CAUSE, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_SEM,
						DataSampleValueFactory.MEAN_PLUS_SEM);
				
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_MEAN_STDEV.addColumn("upstream (key) event", DataSampleValueFactory.UPSTREAM_CAUSE);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_MEAN_STDEV.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_MEAN_STDEV.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_MEAN_STDEV.addColumn("standard deviation", DataSampleValueFactory.STDEV);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_MEAN_STDEV.updateChartSetup(DataSampleValueFactory.UPSTREAM_CAUSE,DataSampleValueFactory.TIME, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_STDEV,
						DataSampleValueFactory.MEAN_PLUS_STDEV);
				
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_MEAN_SEM.addColumn("upstream (key) event", DataSampleValueFactory.UPSTREAM_CAUSE);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_MEAN_SEM.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_MEAN_SEM.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_MEAN_SEM.addColumn("standard mean error", DataSampleValueFactory.SEM);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_MEAN_SEM.updateChartSetup(DataSampleValueFactory.UPSTREAM_CAUSE,DataSampleValueFactory.TIME, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_SEM,
						DataSampleValueFactory.MEAN_PLUS_SEM);
				
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_MEAN_CI95.addColumn("upstream (key) event", DataSampleValueFactory.UPSTREAM_CAUSE);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_MEAN_CI95.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_MEAN_CI95.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_MEAN_CI95.addColumn("confidence interval 95%", DataSampleValueFactory.CI95);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_MEAN_CI95.updateChartSetup(DataSampleValueFactory.UPSTREAM_CAUSE, DataSampleValueFactory.TIME,DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_CI95,
						DataSampleValueFactory.MEAN_PLUS_CI95);
				
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_MEAN_MINMAX.addColumn("upstream (key) event", DataSampleValueFactory.UPSTREAM_CAUSE);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_MEAN_MINMAX.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_MEAN_MINMAX.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_MEAN_MINMAX.addColumn("min value", DataSampleValueFactory.LOWEST_REP);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_MEAN_MINMAX.addColumn("max value", DataSampleValueFactory.HIGHEST_REP);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_MEAN_MINMAX.updateChartSetup(DataSampleValueFactory.UPSTREAM_CAUSE, DataSampleValueFactory.TIME,DataSampleValueFactory.VALUE, DataSampleValueFactory.LOWEST_REP,
						DataSampleValueFactory.HIGHEST_REP);
				
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_ALL.addColumn("upstream (key) event", DataSampleValueFactory.UPSTREAM_CAUSE);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_ALL.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_ALL.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_ALL.addColumn("min value", DataSampleValueFactory.LOWEST_REP);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_ALL.addColumn("max value", DataSampleValueFactory.HIGHEST_REP);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_ALL.addColumn("standard deviation", DataSampleValueFactory.STDEV);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_ALL.addColumn("standard mean error", DataSampleValueFactory.SEM);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_ALL.addColumn("confidence interval 95%", DataSampleValueFactory.CI95);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_ALL.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_ALL.updateChartSetup(DataSampleValueFactory.UPSTREAM_CAUSE, DataSampleValueFactory.TIME,DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_SEM,
						DataSampleValueFactory.MEAN_PLUS_SEM);
				
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_MINMAX.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_MINMAX.addColumn("chem. conc.", DataSampleValueFactory.DESCR_VALUE);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_MINMAX.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_MINMAX.addColumn("min value", DataSampleValueFactory.LOWEST_REP);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_MINMAX.addColumn("max value", DataSampleValueFactory.HIGHEST_REP);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_MINMAX.updateChartSetup(DataSampleValueFactory.DESCR_VALUE, DataSampleValueFactory.VALUE, DataSampleValueFactory.LOWEST_REP,
						DataSampleValueFactory.HIGHEST_REP);
				
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_STDEV.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_STDEV.addColumn("chem. conc.", DataSampleValueFactory.DESCR_VALUE);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_STDEV.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_STDEV.addColumn("standard deviation", DataSampleValueFactory.STDEV);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_STDEV.updateChartSetup(DataSampleValueFactory.TIME, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_STDEV,
						DataSampleValueFactory.MEAN_PLUS_STDEV);
				
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_SEM.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_SEM.addColumn("chem. conc.", DataSampleValueFactory.DESCR_VALUE);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_SEM.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_SEM.addColumn("standard mean error", DataSampleValueFactory.SEM);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_SEM.updateChartSetup(DataSampleValueFactory.TIME, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_SEM,
						DataSampleValueFactory.MEAN_PLUS_SEM);
				
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_CI95.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_CI95.addColumn("chem. conc.", DataSampleValueFactory.DESCR_VALUE);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_CI95.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_CI95.addColumn("confidence interval 95%", DataSampleValueFactory.CI95);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_CI95.updateChartSetup(DataSampleValueFactory.TIME, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_CI95,
						DataSampleValueFactory.MEAN_PLUS_CI95);
				
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_ALL.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_ALL.addColumn("chem. conc.", DataSampleValueFactory.DESCR_VALUE);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_ALL.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_ALL.addColumn("min value", DataSampleValueFactory.LOWEST_REP);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_ALL.addColumn("max value", DataSampleValueFactory.HIGHEST_REP);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_ALL.addColumn("standard deviation", DataSampleValueFactory.STDEV);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_ALL.addColumn("standard mean error", DataSampleValueFactory.SEM);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_ALL.addColumn("confidence interval 95%", DataSampleValueFactory.CI95);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_ALL.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_TC_DTT_ALL.updateChartSetup(DataSampleValueFactory.TIME, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_SEM,
						DataSampleValueFactory.MEAN_PLUS_SEM);
				
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_MINMAX.addColumn("nominal conc.", DataSampleValueFactory.NOMINAL_VALUE);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_MINMAX.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_MINMAX.addColumn("min value", DataSampleValueFactory.LOWEST_REP);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_MINMAX.addColumn("max value", DataSampleValueFactory.HIGHEST_REP);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_MINMAX.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_MINMAX.updateChartSetup(DataSampleValueFactory.NOMINAL_VALUE, DataSampleValueFactory.VALUE, DataSampleValueFactory.LOWEST_REP,
						DataSampleValueFactory.HIGHEST_REP);
				
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_STDEV.addColumn("nominal conc.", DataSampleValueFactory.NOMINAL_VALUE);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_STDEV.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_STDEV.addColumn("standard deviation", DataSampleValueFactory.STDEV);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_STDEV.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_ALL.updateChartSetup(DataSampleValueFactory.NOMINAL_VALUE, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_STDEV,
						DataSampleValueFactory.MEAN_PLUS_STDEV);
				
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_SEM.addColumn("nominal conc.", DataSampleValueFactory.NOMINAL_VALUE);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_SEM.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_SEM.addColumn("standard mean error", DataSampleValueFactory.SEM);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_SEM.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_SEM.updateChartSetup(DataSampleValueFactory.NOMINAL_VALUE, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_SEM,
						DataSampleValueFactory.MEAN_PLUS_SEM);
				
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_CI95.addColumn("nominal conc.", DataSampleValueFactory.NOMINAL_VALUE);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_CI95.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_CI95.addColumn("confidence interval 95%", DataSampleValueFactory.CI95);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_CI95.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_CI95.updateChartSetup(DataSampleValueFactory.NOMINAL_VALUE, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_CI95,
						DataSampleValueFactory.MEAN_PLUS_CI95);
				
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_ALL.addColumn("nominal conc.", DataSampleValueFactory.NOMINAL_VALUE);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_ALL.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_ALL.addColumn("min value", DataSampleValueFactory.LOWEST_REP);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_ALL.addColumn("max value", DataSampleValueFactory.HIGHEST_REP);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_ALL.addColumn("standard deviation", DataSampleValueFactory.STDEV);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_ALL.addColumn("standard mean error", DataSampleValueFactory.SEM);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_ALL.addColumn("confidence interval 95%", DataSampleValueFactory.CI95);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_ALL.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_ALL.updateChartSetup(DataSampleValueFactory.NOMINAL_VALUE, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_SEM,
						DataSampleValueFactory.MEAN_PLUS_SEM);
				
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_MINMAX.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_MINMAX.addColumn("nominal conc.", DataSampleValueFactory.NOMINAL_VALUE);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_MINMAX.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_MINMAX.addColumn("min value", DataSampleValueFactory.LOWEST_REP);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_MINMAX.addColumn("max value", DataSampleValueFactory.HIGHEST_REP);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_MINMAX.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_MINMAX.updateChartSetup(DataSampleValueFactory.TIME,DataSampleValueFactory.NOMINAL_VALUE, DataSampleValueFactory.VALUE, DataSampleValueFactory.LOWEST_REP,
						DataSampleValueFactory.HIGHEST_REP);
				
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_STDEV.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_STDEV.addColumn("nominal conc.", DataSampleValueFactory.NOMINAL_VALUE);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_STDEV.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_STDEV.addColumn("standard deviation", DataSampleValueFactory.STDEV);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_STDEV.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_STDEV.updateChartSetup(DataSampleValueFactory.TIME, DataSampleValueFactory.NOMINAL_VALUE,DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_STDEV,
						DataSampleValueFactory.MEAN_PLUS_STDEV);
				
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_SEM.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_SEM.addColumn("nominal conc.", DataSampleValueFactory.NOMINAL_VALUE);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_SEM.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_SEM.addColumn("standard mean error", DataSampleValueFactory.SEM);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_SEM.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_SEM.updateChartSetup(DataSampleValueFactory.TIME, DataSampleValueFactory.NOMINAL_VALUE,DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_SEM,
						DataSampleValueFactory.MEAN_PLUS_SEM);
				
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_CI95.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_CI95.addColumn("nominal conc.", DataSampleValueFactory.NOMINAL_VALUE);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_CI95.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_CI95.addColumn("confidence interval 95%", DataSampleValueFactory.CI95);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_CI95.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_CI95.updateChartSetup(DataSampleValueFactory.TIME, DataSampleValueFactory.NOMINAL_VALUE,DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_CI95,
						DataSampleValueFactory.MEAN_PLUS_CI95);
				
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_ALL.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_ALL.addColumn("nominal conc.", DataSampleValueFactory.NOMINAL_VALUE);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_ALL.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_ALL.addColumn("min value", DataSampleValueFactory.LOWEST_REP);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_ALL.addColumn("max value", DataSampleValueFactory.HIGHEST_REP);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_ALL.addColumn("standard deviation", DataSampleValueFactory.STDEV);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_ALL.addColumn("standard mean error", DataSampleValueFactory.SEM);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_ALL.addColumn("confidence interval 95%", DataSampleValueFactory.CI95);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_ALL.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_ALL.updateChartSetup(DataSampleValueFactory.TIME, DataSampleValueFactory.NOMINAL_VALUE,DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_SEM,
						DataSampleValueFactory.MEAN_PLUS_SEM);
				
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_MEAN_MINMAX.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_MEAN_MINMAX.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_MEAN_MINMAX.addColumn("min value", DataSampleValueFactory.LOWEST_REP);
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_MEAN_MINMAX.addColumn("max value", DataSampleValueFactory.HIGHEST_REP);
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_MEAN_MINMAX.updateChartSetup(DataSampleValueFactory.DESCR_VALUE, DataSampleValueFactory.VALUE, DataSampleValueFactory.LOWEST_REP,
						DataSampleValueFactory.HIGHEST_REP);
				
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_MEAN_STDEV.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_MEAN_STDEV.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_MEAN_STDEV.addColumn("standard deviation", DataSampleValueFactory.STDEV);
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_MEAN_STDEV.updateChartSetup(DataSampleValueFactory.TIME, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_STDEV,
						DataSampleValueFactory.MEAN_PLUS_STDEV);
				
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_MEAN_SEM.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_MEAN_SEM.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_MEAN_SEM.addColumn("standard mean error", DataSampleValueFactory.SEM);
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_MEAN_SEM.updateChartSetup(DataSampleValueFactory.TIME, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_SEM,
						DataSampleValueFactory.MEAN_PLUS_SEM);
				
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_MEAN_CI95.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_MEAN_CI95.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_MEAN_CI95.addColumn("confidence interval 95%", DataSampleValueFactory.CI95);
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_MEAN_CI95.updateChartSetup(DataSampleValueFactory.TIME, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_CI95,
						DataSampleValueFactory.MEAN_PLUS_CI95);
				
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_ALL.addColumn("time", DataSampleValueFactory.TIME);
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_ALL.addColumn("mean value", DataSampleValueFactory.MEAN_VALUE);
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_ALL.addColumn("min value", DataSampleValueFactory.LOWEST_REP);
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_ALL.addColumn("max value", DataSampleValueFactory.HIGHEST_REP);
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_ALL.addColumn("standard deviation", DataSampleValueFactory.STDEV);
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_ALL.addColumn("standard mean error", DataSampleValueFactory.SEM);
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_ALL.addColumn("confidence interval 95%", DataSampleValueFactory.CI95);
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_ALL.addColumn("number of replicates", DataSampleValueFactory.N);
				DefaultEffectopediaObjects.DEFAULT_TS_DTT_ALL.updateChartSetup(DataSampleValueFactory.TIME, DataSampleValueFactory.VALUE, DataSampleValueFactory.MEAN_MINUS_SEM,
						DataSampleValueFactory.MEAN_PLUS_SEM);
				
				DTS_TC_SINGLE_CHEM_MEAN_MIN_MAX.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_MINMAX));
				DTS_TC_SINGLE_CHEM_MEAN_STDEV.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_STDEV));
				DTS_TC_SINGLE_CHEM_MEAN_SEM.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_SEM));
				DTS_TC_SINGLE_CHEM_MEAN_CI95.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_SC_DTT_MEAN_CI95));
				DTS_TC_SINGLE_CHEM_ALL.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_SC_DTT_ALL));
				DTS_TC_SINGLE_T_CHEM_MEAN_MIN_MAX.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_MINMAX));
				DTS_TC_SINGLE_T_CHEM_MEAN_STDEV.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_STDEV));
				DTS_TC_SINGLE_T_CHEM_MEAN_SEM.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_SEM));
				DTS_TC_SINGLE_T_CHEM_MEAN_CI95.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_MEAN_CI95));
				DTS_TC_SINGLE_T_CHEM_ALL.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_SC_DTT_T_ALL));
				
				DTS_DR_SINGLE_CHEM_MEAN_MIN_MAX.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_MINMAX));
				DTS_DR_SINGLE_CHEM_MEAN_STDEV.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_STDEV));
				DTS_DR_SINGLE_CHEM_MEAN_SEM.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_SEM));
				DTS_DR_SINGLE_CHEM_MEAN_CI95.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_CI95));
				DTS_DR_SINGLE_CHEM_ALL.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_DR_DTT_ALL));
				DTS_DR_SINGLE_T_MEAN_MIN_MAX.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_MINMAX));
				DTS_DR_SINGLE_T_MEAN_STDEV.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_STDEV));
				DTS_DR_SINGLE_T_MEAN_SEM.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_SEM));
				DTS_DR_SINGLE_T_MEAN_CI95.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_CI95));
				DTS_DR_SINGLE_T_ALL.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_T_DTT_ALL));
				
				DTS_DR_DUAL_CHEM_MEAN_MIN_MAX.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_MINMAX));
				DTS_DR_DUAL_CHEM_MEAN_STDEV.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_STDEV));
				DTS_DR_DUAL_CHEM_MEAN_SEM.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_SEM));
				DTS_DR_DUAL_CHEM_MEAN_CI95.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_CI95));
				DTS_DR_DUAL_CHEM_ALL.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_DR_DTT_ALL));
				DTS_DR_DUAL_T_MEAN_MIN_MAX.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_MINMAX));
				DTS_DR_DUAL_T_MEAN_STDEV.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_STDEV));
				DTS_DR_DUAL_T_MEAN_SEM.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_SEM));
				DTS_DR_DUAL_T_MEAN_CI95.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_CI95));
				DTS_DR_DUAL_T_ALL.add(DT_TESTED_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_T_DTT_ALL));
				
				DTS_DR_DUAL_CHEM_MEAN_MIN_MAX.add(DT_REF_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_MINMAX));
				DTS_DR_DUAL_CHEM_MEAN_STDEV.add(DT_REF_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_STDEV));
				DTS_DR_DUAL_CHEM_MEAN_SEM.add(DT_REF_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_SEM));
				DTS_DR_DUAL_CHEM_MEAN_CI95.add(DT_REF_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_DR_DTT_MEAN_CI95));
				DTS_DR_DUAL_CHEM_ALL.add(DT_REF_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_DR_DTT_ALL));
				DTS_DR_DUAL_T_MEAN_MIN_MAX.add(DT_REF_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_MINMAX));
				DTS_DR_DUAL_T_MEAN_STDEV.add(DT_REF_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_STDEV));
				DTS_DR_DUAL_T_MEAN_SEM.add(DT_REF_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_SEM));
				DTS_DR_DUAL_T_MEAN_CI95.add(DT_REF_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_T_DTT_MEAN_CI95));
				DTS_DR_DUAL_T_ALL.add(DT_REF_CHEM.clone().setType(DefaultEffectopediaObjects.DEFAULT_T_DTT_ALL));
				
				DTS_RESP_RESP_MEAN_MIN_MAX.add(DT_RESP_RESP.clone().setType(DefaultEffectopediaObjects.DEFAULT_RR_DTT_MEAN_MINMAX));
				DTS_RESP_RESP_MEAN_STDEV.add(DT_RESP_RESP.clone().setType(DefaultEffectopediaObjects.DEFAULT_RR_DTT_MEAN_STDEV));
				DTS_RESP_RESP_MEAN_SEM.add(DT_RESP_RESP.clone().setType(DefaultEffectopediaObjects.DEFAULT_RR_DTT_MEAN_SEM));
				DTS_RESP_RESP_MEAN_CI95.add(DT_RESP_RESP.clone().setType(DefaultEffectopediaObjects.DEFAULT_RR_DTT_MEAN_CI95));
				DTS_RESP_RESP_ALL.add(DT_RESP_RESP.clone().setType(DefaultEffectopediaObjects.DEFAULT_RR_DTT_ALL));
				
				DTS_TIME_COURSE_MEAN_MIN_MAX.add(DT_UPSTREAM.clone().setType(DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_MINMAX));
				DTS_TIME_COURSE_MEAN_STDEV.add(DT_UPSTREAM.clone().setType(DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_STDEV));
				DTS_TIME_COURSE_MEAN_SEM.add(DT_UPSTREAM.clone().setType(DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_SEM));
				DTS_TIME_COURSE_MEAN_CI95.add(DT_UPSTREAM.clone().setType(DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_CI95));
				DTS_TIME_COURSE_ALL.add(DT_UPSTREAM.clone().setType(DefaultEffectopediaObjects.DEFAULT_TC_DTT_ALL));
				
				DTS_TIME_COURSE_MEAN_MIN_MAX.add(DT_DOWNSTREAM.clone().setType(DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_MINMAX));
				DTS_TIME_COURSE_MEAN_STDEV.add(DT_DOWNSTREAM.clone().setType(DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_STDEV));
				DTS_TIME_COURSE_MEAN_SEM.add(DT_DOWNSTREAM.clone().setType(DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_SEM));
				DTS_TIME_COURSE_MEAN_CI95.add(DT_DOWNSTREAM.clone().setType(DefaultEffectopediaObjects.DEFAULT_TC_DTT_MEAN_CI95));
				DTS_TIME_COURSE_ALL.add(DT_DOWNSTREAM.clone().setType(DefaultEffectopediaObjects.DEFAULT_TC_DTT_ALL));
				
				DTS_TIME_COURSE_MEAN_MIN_MAX.setSecondaryAxisTemplateIndex();
				DTS_TIME_COURSE_MEAN_STDEV.setSecondaryAxisTemplateIndex();
				DTS_TIME_COURSE_MEAN_SEM.setSecondaryAxisTemplateIndex();
				DTS_TIME_COURSE_MEAN_CI95.setSecondaryAxisTemplateIndex();
				DTS_TIME_COURSE_ALL.setSecondaryAxisTemplateIndex();
				
				DTS_TIME_SERIES_MEAN_MIN_MAX.add(DT_TIME_SERIES.clone().setType(DefaultEffectopediaObjects.DEFAULT_TS_DTT_MEAN_MINMAX));
				DTS_TIME_SERIES_MEAN_STDEV.add(DT_TIME_SERIES.clone().setType(DefaultEffectopediaObjects.DEFAULT_TS_DTT_MEAN_STDEV));
				DTS_TIME_SERIES_MEAN_SEM.add(DT_TIME_SERIES.clone().setType(DefaultEffectopediaObjects.DEFAULT_TS_DTT_MEAN_SEM));
				DTS_TIME_SERIES_MEAN_CI95.add(DT_TIME_SERIES.clone().setType(DefaultEffectopediaObjects.DEFAULT_TS_DTT_MEAN_CI95));
				DTS_TIME_SERIES_ALL.add(DT_TIME_SERIES.clone().setType(DefaultEffectopediaObjects.DEFAULT_TS_DTT_ALL));
				
			}
	}

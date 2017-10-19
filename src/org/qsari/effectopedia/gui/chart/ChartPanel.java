package org.qsari.effectopedia.gui.chart;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.data.quantification.DataSeries;
import org.qsari.effectopedia.gui.chart.ChartUtils.Offset;

public class ChartPanel extends javax.swing.JPanel implements ActionListener
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		/**
		 * Main static method to display this ChartPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				ChartPanel cp = new ChartPanel();
				cp.TEST_createDualYAxisChart();
				frame.getContentPane().add(cp);
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public ChartPanel()
			{
				super();
				horizontalListOfComponents = new ArrayList<ChartComponent>();
				verticalListOfComponents = new ArrayList<ChartComponent>();
				primarySeries = new ArrayList<ChartDataSeries>();
				secondarySeries = new ArrayList<ChartDataSeries>();
				initGUI();
			}
		
		public void reset()
			{
				horizontalListOfComponents.clear();
				verticalListOfComponents.clear();
				if (dimmer != null)
					{
						convertToFading(primarySeries);
						convertToFading(secondarySeries);
						dimmer.start();
					}
				else
					{
						primarySeries.clear();
						secondarySeries.clear();
					}
			}
		
		protected void convertToFading(ArrayList<ChartDataSeries> series)
			{
				ArrayList<FadingChartDataSeries> newSeries = new ArrayList<FadingChartDataSeries>();
				for (ChartDataSeries s : series)
					if (s instanceof FadingChartDataSeries)
						newSeries.add((FadingChartDataSeries) s);
					else
						newSeries.add(new FadingChartDataSeries(s));
				series.clear();
				series.addAll(newSeries);
			}
		
		public void createDefaultChart()
			{
				primaryXAxis = new ChartAxis_Horizontal();
				primaryYAxis = new ChartAxis_Vertical();
				chartTitle = new ChartTitle("chart title ", ChartUtils.Offset.BOTTOM_AXIS_TITLE, false);
				primaryXAxisTitle = new ChartTitle("concentration [log units]", ChartUtils.Offset.BOTTOM_AXIS_TITLE, false);
				primaryYAxisTitle = new ChartTitle("response [units]", ChartUtils.Offset.LEFT_AXIS_TITLE, true);
				
				primaryXAxis.primaryCross(primaryYAxis);
				
				this.primaryViewport = new ChartViewport(Offset.GRID);
				horizontalListOfComponents.add(primaryYAxisTitle);
				horizontalListOfComponents.add(primaryYAxis);
				horizontalListOfComponents.add(this.primaryViewport);
				
				verticalListOfComponents.add(this.chartTitle);
				verticalListOfComponents.add(this.primaryViewport);
				verticalListOfComponents.add(primaryXAxis);
				verticalListOfComponents.add(primaryXAxisTitle);
				primaryViewport.setHorizontalAxis(primaryXAxis);
				primaryViewport.setVerticalAxis(primaryYAxis);
				
				// series.add(new ChartDataSeries(primaryXAxis, primaryYAxis, 12,
				// ChartDataSeries.MARKER_PLUS, ChartUtils.chartSeriesRedColor));
				// series.add(new
				// ChartDataSeries_Interpolation(primaryXAxis,primaryYAxis,16,
				// ChartDataSeries.MARKER_CIRCLE,ChartUtils.chartSeriesGrayColor,ChartDataSeries_Interpolation.IFN_DOSE_RESP_STIMULATION));
				// series.add(new ChartDataSeries(primaryXAxis, primaryYAxis, 6,
				// ChartDataSeries.MARKER_CIRCLE, ChartUtils.chartSeriesBlueColor));
				// series.add(new ChartDataSeries(primaryXAxis,primaryYAxis,10,
				// ChartDataSeries.MARKER_X,ChartUtils.chartSeriesOrangeColor));
				// series.add(new ChartDataSeries(primaryXAxis,primaryYAxis,10,
				// ChartDataSeries.MARKER_RHOMB,ChartUtils.chartSeriesGrayColor));
				primaryViewport.setSeries(primarySeries);
			}
		
		public void TEST_createDualYAxisChart()
			{
				primaryXAxis = new ChartAxis_Horizontal();
				primaryYAxis = new ChartAxis_Vertical();
				secondaryYAxis = new ChartAxis_Vertical(ChartAxis.DEFAULT_Y, Offset.RIGHT_AXIS, Offset.RIGHT_AXIS_LABELS, ChartAxis.INDENT_WEST, true);
				chartTitle = new ChartTitle("chart title ", ChartUtils.Offset.BOTTOM_AXIS_TITLE, false);
				primaryXAxisTitle = new ChartTitle("concentration [log units]", ChartUtils.Offset.BOTTOM_AXIS_TITLE, false);
				primaryYAxisTitle = new ChartTitle("response 1 [units 1]", ChartUtils.Offset.LEFT_AXIS_TITLE, true);
				secondaryYAxisTitle = new ChartTitle("response 2[units 2]", ChartUtils.Offset.RIGHT_AXIS_TITLE, true);
				
				primaryXAxis.primaryCross(primaryYAxis);
				primaryXAxis.secondaryCross(secondaryYAxis);
				
				this.primaryViewport = new ChartViewport(Offset.GRID);
				this.secondaryViewport = new ChartViewport(Offset.GRID, ChartViewport.NO_GRID_AND_STRIPES);
				
				horizontalListOfComponents.add(primaryYAxisTitle);
				horizontalListOfComponents.add(primaryYAxis);
				horizontalListOfComponents.add(this.primaryViewport);
				horizontalListOfComponents.add(secondaryYAxis);
				horizontalListOfComponents.add(secondaryYAxisTitle);
				
				verticalListOfComponents.add(this.chartTitle);
				verticalListOfComponents.add(this.primaryViewport);
				verticalListOfComponents.add(primaryXAxis);
				verticalListOfComponents.add(primaryXAxisTitle);
				
				primaryViewport.setHorizontalAxis(primaryXAxis);
				primaryViewport.setVerticalAxis(primaryYAxis);
				secondaryViewport.setHorizontalAxis(primaryXAxis);
				secondaryViewport.setVerticalAxis(secondaryYAxis);
				
				primarySeries.add(new ChartDataSeries(primaryXAxis, primaryYAxis, 12, ChartDataSeries.MARKER_PLUS, ChartUtils.chartSeriesRedColor));
				primaryYAxisTitle.titleColor = ChartUtils.chartSeriesRedColor;
				primaryYAxis.labelColor = ChartUtils.chartSeriesRedColor;
				// primarySeries.add(new ChartDataSeries_Interpolation(primaryXAxis,
				// primaryYAxis, 16, ChartDataSeries.MARKER_CIRCLE,
				// ChartUtils.chartSeriesGrayColor,
				// ChartDataSeries_Interpolation.IFN_DOSE_RESP_STIMULATION));
				// primarySeries.add(new ChartDataSeries(primaryXAxis, primaryYAxis, 6,
				// ChartDataSeries.MARKER_CIRCLE, ChartUtils.chartSeriesBlueColor));
				// secondarySeries.add(new ChartDataSeries(primaryXAxis, secondaryYAxis, 10,
				// ChartDataSeries.MARKER_X, ChartUtils.chartSeriesOrangeColor));
				secondarySeries.add(new ChartDataSeries(primaryXAxis, secondaryYAxis, 10, ChartDataSeries.MARKER_RHOMB, ChartUtils.chartSeriesGrayColor));
				secondaryYAxis.labelColor = ChartUtils.chartSeriesGrayColor;
				
				primaryViewport.setSeries(primarySeries);
				secondaryViewport.setSeries(secondarySeries);
			}
		
		public void TEST_loadAANExample()
			{
				primaryXAxis = new ChartAxis_Horizontal();
				primaryYAxis = new ChartAxis_Vertical();
				chartTitle = new ChartTitle("Cyto rtER assay binding", ChartUtils.Offset.BOTTOM_AXIS_TITLE, false);
				primaryXAxisTitle = new ChartTitle("concentration [log units]", ChartUtils.Offset.BOTTOM_AXIS_TITLE, false);
				primaryYAxisTitle = new ChartTitle("3H-e2 Binding [%]", ChartUtils.Offset.LEFT_AXIS_TITLE, true);
				
				primaryXAxis.primaryCross(primaryYAxis);
				this.primaryViewport = new ChartViewport(Offset.GRID);
				horizontalListOfComponents.add(primaryYAxisTitle);
				horizontalListOfComponents.add(primaryYAxis);
				horizontalListOfComponents.add(this.primaryViewport);
				
				verticalListOfComponents.add(this.chartTitle);
				verticalListOfComponents.add(this.primaryViewport);
				verticalListOfComponents.add(primaryXAxis);
				verticalListOfComponents.add(primaryXAxisTitle);
				
				primaryViewport.setHorizontalAxis(primaryXAxis);
				primaryViewport.setVerticalAxis(primaryYAxis);
				
				DataSeries dataE2 = new DataSeries(6, 0, true);
				dataE2.x.setSimpleData(new double[]
					{ -11D, -10D, -9D, -8D, -7D, -6D });
				dataE2.y.setSimpleData(new double[]
					{ 100D, 98D, 87D, 46D, 12D, 0D });
				dataE2.y.rawDataMin = new double[]
					{ 97D, 93D, 84D, 39D, 9D, 0D };
				dataE2.y.rawDataMax = new double[]
					{ 103D, 102D, 93D, 55D, 14D, 0D };
				dataE2.updateRanges();
				
				DataSeries dataANN = new DataSeries(6, 0, true);
				dataANN.x.setSimpleData(new double[]
					{ -4D, -3D, -2.7D, -2.3D, -2D, -1.8D });
				dataANN.y.setSimpleData(new double[]
					{ 95D, 102D, 43D, 28D, 19D, 8D });
				dataANN.y.rawDataMin = new double[]
					{ 90D, 89D, 35D, 21D, 8D, 1D };
				dataANN.y.rawDataMax = new double[]
					{ 105D, 115D, 50D, 41D, 42D, 18D };
				dataANN.updateRanges();
				
				primarySeries.add(new ChartDataSeries(dataE2, primaryXAxis, primaryYAxis, ChartDataSeries.MARKER_PLUS, ChartUtils.chartSeriesRedColor));
				// series.add(new
				// ChartDataSeries_Interpolation(primaryXAxis,primaryYAxis,16,
				// ChartDataSeries.MARKER_CIRCLE,ChartUtils.chartSeriesGrayColor,ChartDataSeries_Interpolation.IFN_DOSE_RESP_STIMULATION));
				primarySeries.add(new ChartDataSeries(dataANN, primaryXAxis, primaryYAxis, ChartDataSeries.MARKER_CIRCLE, ChartUtils.chartSeriesBlueColor));
				// series.add(new ChartDataSeries(primaryXAxis,primaryYAxis,10,
				// ChartDataSeries.MARKER_X,ChartUtils.chartSeriesOrangeColor));
				// series.add(new ChartDataSeries(primaryXAxis,primaryYAxis,10,
				// ChartDataSeries.MARKER_RHOMB,ChartUtils.chartSeriesGrayColor));
				
				primaryViewport.setSeries(primarySeries);
			}
		
		public void redistribute(Point chartOffset, Dimension chartSize)
			{
				int width = chartSize.width;
				int height = chartSize.height;
				int fixedWidth = 0;
				int fixedHeigth = 0;
				for (ChartComponent component : horizontalListOfComponents)
					{
						component.setY(chartOffset.y);
						if (component.isFixedX())
							fixedWidth += component.getWidth();
					}
				for (ChartComponent component : verticalListOfComponents)
					{
						component.setX(chartOffset.x);
						if (component.isFixedY())
							fixedHeigth += component.getHeight();
					}
				int availableWidth = width - fixedWidth;
				int availableHeight = height - fixedHeigth;
				int xOffset = chartOffset.x;
				int yOffset = chartOffset.y;
				
				for (ChartComponent component : horizontalListOfComponents)
					{
						if (!component.isFixedX())
							component.setWidth(availableWidth);
						if (!component.isFixedY())
							component.setHeight(height);
						component.setX(xOffset);
						xOffset += component.getWidth();
					}
				for (ChartComponent component : verticalListOfComponents)
					{
						if (!component.isFixedY())
							component.setHeight(availableHeight);
						if (!component.isFixedX())
							component.setWidth(width);
						component.setY(yOffset);
						yOffset += component.getHeight();
					}
				
				for (ChartComponent component : horizontalListOfComponents)
					component.update();
				for (ChartComponent component : verticalListOfComponents)
					component.update();
			}
		
		public void render(Graphics2D canvas, Point chartOffset, Dimension chartSize)
			{
				redistribute(chartOffset, chartSize);
				canvas.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				if (primaryViewport != null)
					primaryViewport.render(canvas);
				if (secondaryViewport != null)
					{
						secondaryViewport.setDimensions(primaryViewport);
						secondaryViewport.update();
						secondaryViewport.render(canvas);
					}
				for (ChartComponent component : horizontalListOfComponents)
					if (component != primaryViewport)
						component.render(canvas);
				for (ChartComponent component : verticalListOfComponents)
					if (component != primaryViewport)
						component.render(canvas);
			}
		
		@Override
		public void paint(Graphics canvas)
			{
				super.paint(canvas);
				this.getSize(chartSize);
				render((Graphics2D) canvas, chartOffset, chartSize);
			}
		
		private void initGUI()
			{
				try
					{
							{
								this.setBackground(ChartUtils.chartBackground);
								this.setPreferredSize(new java.awt.Dimension(398, 272));
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public void createChart(ChartTemplate template, DataSeries dataSeries1, DataSeries dataSeries2)
			{
				primaryXAxis = new ChartAxis_Horizontal();
				primaryYAxis = new ChartAxis_Vertical();
				this.chartTitle = new ChartTitle(template.chartTitle, ChartUtils.Offset.BOTTOM_AXIS_TITLE, false);
				primaryXAxisTitle = new ChartTitle(template.xAxisTitle, ChartUtils.Offset.BOTTOM_AXIS_TITLE, false);
				primaryYAxisTitle = new ChartTitle(template.yPrimaryAxisTitle, ChartUtils.Offset.LEFT_AXIS_TITLE, true);
				
				primaryXAxis.primaryCross(primaryYAxis);
				this.primaryViewport = new ChartViewport(Offset.GRID);
				horizontalListOfComponents.add(primaryYAxisTitle);
				horizontalListOfComponents.add(primaryYAxis);
				horizontalListOfComponents.add(this.primaryViewport);
				
				verticalListOfComponents.add(this.chartTitle);
				verticalListOfComponents.add(this.primaryViewport);
				verticalListOfComponents.add(primaryXAxis);
				verticalListOfComponents.add(primaryXAxisTitle);
				primaryViewport.setHorizontalAxis(primaryXAxis);
				primaryViewport.setVerticalAxis(primaryYAxis);
				
				if (dataSeries1 != null)
					{
						dataSeries1.updateRanges();
						primarySeries.add(new ChartDataSeries(dataSeries1, primaryXAxis, primaryYAxis, ChartDataSeries.MARKER_PLUS, ChartUtils.chartSeriesRedColor));
					}
				
				if (dataSeries2 != null)
					{
						dataSeries2.updateRanges();
						primarySeries.add(new ChartDataSeries(dataSeries2, primaryXAxis, primaryYAxis, ChartDataSeries.MARKER_CIRCLE, ChartUtils.chartSeriesBlueColor));
					}
				
				primaryViewport.setSeries(primarySeries);
			}
		
		public void createPrimaryAxis(ChartTemplate template)
			{
				primaryXAxis = new ChartAxis_Horizontal();
				primaryYAxis = new ChartAxis_Vertical();
				this.chartTitle = new ChartTitle(template.chartTitle, ChartUtils.Offset.BOTTOM_AXIS_TITLE, false);
				primaryXAxisTitle = new ChartTitle(template.xAxisTitle, ChartUtils.Offset.BOTTOM_AXIS_TITLE, false);
				primaryYAxisTitle = new ChartTitle(template.yPrimaryAxisTitle, ChartUtils.Offset.LEFT_AXIS_TITLE, true);
				
				primaryXAxis.primaryCross(primaryYAxis);
				this.primaryViewport = new ChartViewport(Offset.GRID);
				horizontalListOfComponents.add(primaryYAxisTitle);
				horizontalListOfComponents.add(primaryYAxis);
				horizontalListOfComponents.add(this.primaryViewport);
				
				verticalListOfComponents.add(this.chartTitle);
				verticalListOfComponents.add(this.primaryViewport);
				verticalListOfComponents.add(primaryXAxis);
				verticalListOfComponents.add(primaryXAxisTitle);
				primaryViewport.setHorizontalAxis(primaryXAxis);
				primaryViewport.setVerticalAxis(primaryYAxis);
				
				if (dimmer != null)
					for (ChartDataSeries s : primarySeries)
						s.updateAxis(primaryXAxis, primaryYAxis);
			}
		
		public void createDualYAxisChart(ChartTemplate template)
			{
				primaryXAxis = new ChartAxis_Horizontal();
				primaryYAxis = new ChartAxis_Vertical();
				secondaryYAxis = new ChartAxis_Vertical(ChartAxis.DEFAULT_Y, Offset.RIGHT_AXIS, Offset.RIGHT_AXIS_LABELS, ChartAxis.INDENT_WEST, true);
				this.chartTitle = new ChartTitle(template.chartTitle, ChartUtils.Offset.BOTTOM_AXIS_TITLE, false);
				primaryXAxisTitle = new ChartTitle(template.xAxisTitle, ChartUtils.Offset.BOTTOM_AXIS_TITLE, false);
				primaryYAxisTitle = new ChartTitle(template.yPrimaryAxisTitle, ChartUtils.Offset.LEFT_AXIS_TITLE, true);
				secondaryYAxisTitle = new ChartTitle(template.ySecondaryAxisTitle, ChartUtils.Offset.RIGHT_AXIS_TITLE, true);
				
				primaryXAxis.primaryCross(primaryYAxis);
				primaryXAxis.secondaryCross(secondaryYAxis);
				
				this.primaryViewport = new ChartViewport(Offset.GRID);
				this.secondaryViewport = new ChartViewport(Offset.GRID, ChartViewport.NO_GRID_AND_STRIPES);
				
				horizontalListOfComponents.add(primaryYAxisTitle);
				horizontalListOfComponents.add(primaryYAxis);
				horizontalListOfComponents.add(this.primaryViewport);
				horizontalListOfComponents.add(secondaryYAxis);
				horizontalListOfComponents.add(secondaryYAxisTitle);
				
				verticalListOfComponents.add(this.chartTitle);
				verticalListOfComponents.add(this.primaryViewport);
				verticalListOfComponents.add(primaryXAxis);
				verticalListOfComponents.add(primaryXAxisTitle);
				
				primaryViewport.setHorizontalAxis(primaryXAxis);
				primaryViewport.setVerticalAxis(primaryYAxis);
				secondaryViewport.setHorizontalAxis(primaryXAxis);
				secondaryViewport.setVerticalAxis(secondaryYAxis);
				
				if (dimmer != null)
					{
						for (ChartDataSeries s : primarySeries)
							s.updateAxis(primaryXAxis, primaryYAxis);
						for (ChartDataSeries s : secondarySeries)
							s.updateAxis(primaryXAxis, secondaryYAxis);
					}
			}
		
		public ArrayList<ChartDataSeries> getPrimarySeries()
			{
				return primarySeries;
			}
		
		public ArrayList<ChartDataSeries> getSecondarySeries()
			{
				return secondarySeries;
			}
		
		public void enableFading(boolean enable)
			{
				if (enable)
					dimmer = new Timer(fadeSpeed, this);
				else
					dimmer = null;
			}
		
		@Override
		public void actionPerformed(ActionEvent evt)
			{
				boolean hasFadingSeries = false;
				for (Iterator<ChartDataSeries> iterator = primarySeries.iterator(); iterator.hasNext();)
					{
						ChartDataSeries s = iterator.next();
						if (s instanceof FadingChartDataSeries)
							if (((FadingChartDataSeries) s).fade())
								hasFadingSeries = true;
							else
								iterator.remove();
					}
				for (Iterator<ChartDataSeries> iterator = secondarySeries.iterator(); iterator.hasNext();)
					{
						ChartDataSeries s = iterator.next();
						if (s instanceof FadingChartDataSeries)
							if (((FadingChartDataSeries) s).fade())
								hasFadingSeries = true;
							else
								iterator.remove();
					}
				if (!hasFadingSeries)
					dimmer.stop();
				revalidate();
				repaint();
			}
		
		public final static int														fadeSpeed			= 40;
		public ChartAxis_Horizontal										primaryXAxis;
		public ChartAxis_Vertical												primaryYAxis;
		public ChartAxis_Vertical												secondaryYAxis;
		public ChartTitle																				chartTitle;
		public ChartTitle																				primaryXAxisTitle;
		public ChartTitle																				primaryYAxisTitle;
		public ChartTitle																				secondaryYAxisTitle;
		public ChartViewport																	primaryViewport;
		public ChartViewport																	secondaryViewport;
		protected ArrayList<ChartComponent>		horizontalListOfComponents;
		protected ArrayList<ChartComponent>		verticalListOfComponents;
		protected ArrayList<ChartDataSeries>	primarySeries;
		protected ArrayList<ChartDataSeries>	secondarySeries;
		private Timer																								dimmer						= null;
		private Dimension																				chartSize			= new Dimension();
		private Point																								chartOffset	= new Point(0, 0);
		
	}

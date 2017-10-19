package org.qsari.effectopedia.gui.chart;

import java.awt.Graphics2D;
import java.util.ArrayList;

import org.qsari.effectopedia.gui.chart.ChartUtils.Offset;

public class ChartViewport extends ChartComponent
	{
		public ChartViewport(Offset gridOffset)
			{
				this.gridOffset = gridOffset;
			}
		
		public ChartViewport(Offset gridOffset, int options)
			{
				this.gridOffset = gridOffset;
				this.options = options;
			}
		
		public void render(Graphics2D canvas)
			{
				if ((horizontalAxis == null) || (verticalAxis == null))
					return;
				
				// int x = this.x + gridOffset.horizontal;
				// int y = this.y + gridOffset.vertical;
				int hDiv = horizontalAxis.tickDivisions;
				int vDiv = verticalAxis.tickDivisions;
				canvas.setStroke(ChartUtils.chartGrid);
				
				if ((vDiv > 0) && ((options & (SHOW_HORIZONTAL_STRIPES)) != 0))
					{
						int yDivSize = (verticalAxis.tickMax - verticalAxis.tickMin) / vDiv;
						int yOffset = verticalAxis.tickMax;
						int w = horizontalAxis.tickMax - horizontalAxis.tickMin - 4;
						canvas.setStroke(ChartUtils.chartGrid);
						canvas.setColor(ChartUtils.chartGridStripeColor);
						if ((options & SHOW_HORIZONTAL_STRIPES) != 0)
							for (int i = vDiv; i >= 0; i--)
								{
									if ((i & 1) == 1)
										canvas.fillRect(horizontalAxis.tickMin, yOffset, w, yDivSize);
									yOffset -= yDivSize;
								}
					}
				
				if ((hDiv > 0) && ((options & (SHOW_VERTICAL_GRID + SHOW_VERTICAL_STRIPES)) != 0))
					{
						int xDivSize = (horizontalAxis.tickMax - horizontalAxis.tickMin) / hDiv;
						int xOffset = horizontalAxis.tickMin + xDivSize;
						int h = (verticalAxis.tickMax - verticalAxis.tickMin);
						for (int i = 0; i < hDiv; i++)
							{
								if (((options & SHOW_VERTICAL_STRIPES) != 0) && ((i & 1) == 0))
									{
										canvas.setColor(ChartUtils.chartGridStripeColor);
										canvas.fillRect(xOffset, verticalAxis.tickMin, xDivSize, h);
									}
								if ((options & SHOW_VERTICAL_GRID) != 0)
									{
										canvas.setColor(ChartUtils.chartGridLineColor);
										canvas.drawLine(xOffset, verticalAxis.tickMin, xOffset, verticalAxis.tickMax);
									}
								xOffset += xDivSize;
							}
					}
				
				if ((vDiv > 0) && ((options & (SHOW_HORIZONTAL_GRID)) != 0))
					{
						int yDivSize = (verticalAxis.tickMax - verticalAxis.tickMin) / vDiv;
						int yOffset = verticalAxis.tickMax;
						canvas.setColor(ChartUtils.chartGridLineColor);
						if ((options & SHOW_HORIZONTAL_GRID) != 0)
							for (int i = vDiv; i >= 0; i--)
								{
									canvas.drawLine(horizontalAxis.tickMin, yOffset, horizontalAxis.tickMax - 4, yOffset);
									yOffset -= yDivSize;
								}
					}
				for (ChartDataSeries s : series)
					s.preRender(canvas);
				for (ChartDataSeries s : series)
					s.render(canvas);
			}
		
		public void update()
			{
				for (ChartDataSeries s : series)
					s.update();
				//System.out.println(series.size());
				horizontalAxis.updateLabels();
				verticalAxis.updateLabels();
			}
		
		public ChartAxis_Horizontal getHorizontalAxis()
			{
				return horizontalAxis;
			}
		
		public void setHorizontalAxis(ChartAxis_Horizontal horizontalAxis)
			{
				this.horizontalAxis = horizontalAxis;
			}
		
		public ChartAxis_Vertical getVerticalAxis()
			{
				return verticalAxis;
			}
		
		public void setVerticalAxis(ChartAxis_Vertical verticalAxis)
			{
				this.verticalAxis = verticalAxis;
			}
		
		public ArrayList<ChartDataSeries> getSeries()
			{
				return series;
			}
		
		public void setSeries(ArrayList<ChartDataSeries> series)
			{
				this.series = series;
			}
		
		public int getOptions()
			{
				return options;
			}
		
		public void setOptions(int options)
			{
				this.options = options;
			}
		
		public static final int														NO_GRID_AND_STRIPES					= 0;
		public static final int														SHOW_HORIZONTAL_GRID				= 1;
		public static final int														SHOW_VERTICAL_GRID						= 2;
		public static final int														SHOW_HORIZONTAL_STRIPES	= 4;
		public static final int														SHOW_VERTICAL_STRIPES			= 8;
		public static final int														DEFAULT																	= SHOW_HORIZONTAL_STRIPES + SHOW_HORIZONTAL_GRID + SHOW_VERTICAL_GRID;
		protected int																								options																	= DEFAULT;
		public Offset																								gridOffset														= Offset.ZERO;
		protected ChartAxis_Horizontal							horizontalAxis;
		protected ChartAxis_Vertical									verticalAxis;
		protected ArrayList<ChartDataSeries>	series;
	}

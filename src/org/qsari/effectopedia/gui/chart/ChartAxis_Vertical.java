package org.qsari.effectopedia.gui.chart;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.ArrayList;

import org.qsari.effectopedia.gui.chart.ChartUtils.Offset;

public class ChartAxis_Vertical extends ChartAxis
	{
		public ChartAxis_Vertical()
			{
				super(ChartAxis.DEFAULT_Y, Offset.LEFT_AXIS, Offset.LEFT_AXIS_LABELS, INDENT_EAST, true);
				width = ChartUtils.defaultAxisSize;
			}
		
		public ChartAxis_Vertical(int visualOptions, Offset axisOffset, Offset labelOffset, double indent, boolean linear)
			{
				super(visualOptions, axisOffset, labelOffset, indent, linear);
				width = ChartUtils.defaultAxisSize;
			}
		
		@Override
		public boolean isFixedX()
			{
				return true;
			}
		
		@Override
		public void updateTickRange()
			{
				if (primaryCrossingAxis != null)
					tickMax = primaryCrossingAxis.position;
				else
					tickMax = height - (ChartUtils.defaultAxisSize >> 1);
				int secondaryAxisHeight = 0;
				if (secondaryCrossingAxis != null)
					secondaryAxisHeight = secondaryCrossingAxis.height;

				tickMin = secondaryAxisHeight + y + axisOffset.vertical + (ChartUtils.defaultAxisSize);
				int yDivSize = (tickMax - tickMin) / tickDivisions;
				tickMin = tickMax - yDivSize * tickDivisions;
			}
		
		public void updateLabels()
			{
				labels = new ArrayList<String>(tickDivisions);
				double step = (axisScale.axisMax - axisScale.axisMin) / tickDivisions;
				double labelValue = axisScale.axisMax;
				for (int i = 0; i <= tickDivisions; i++)
					{
						String label = String.format("%.0f", labelValue);
						labels.add(label);
						labelValue -= step;
					}
			}
		
		public void updatePosition()
			{
				this.position = x + (int) (width * indent);
			}
		
		public void render(Graphics2D canvas)
			{
				updatePosition();
				canvas.setStroke(ChartUtils.chartAxis);
				canvas.setColor(ChartUtils.chartAxisTickColor);
				if ((tickDivisions > 0) && ((options & SHOW_TICKS) != 0))
					{
						int yOffset = tickMax;
						int yDivSize = (tickMax - tickMin) / tickDivisions;
						for (int i = tickDivisions; i >= 0; i--)
							{
								canvas.drawLine(position - 2, yOffset, position + 2, yOffset);
								yOffset -= yDivSize;
							}
					}
				canvas.setColor(ChartUtils.chartAxisColor);
				canvas.drawLine(position, this.y + 2, position, this.y + height);
				Polygon poly = new Polygon();
				poly.addPoint(position, 2);
				poly.addPoint(position + 6, 10);
				poly.addPoint(position - 6, 10);
				canvas.fill(poly);
				renderLabels(canvas);
			}
		
		public void renderLabels(Graphics2D canvas)
			{
				canvas.setColor(labelColor);
				// canvas.setFont(lableFont);
				FontMetrics fm = canvas.getFontMetrics(lableFont);
				if ((tickDivisions > 0) && ((options & SHOW_TICKS) != 0))
					{
						int yDivSize = (tickMax - tickMin) / tickDivisions;
						int yOffset = tickMax - yDivSize;
						for (int i = tickDivisions - 1; i >= 0; i--)
							{
								canvas.drawLine(position - 2, yOffset, position + 2, yOffset);
								if (((options & SHOW_LABELS) != 0) && (labels.size() > i))
									{
										String label = labels.get(i);
										int labelWidth = fm.stringWidth(label);
										canvas.drawString(label, position + labelOffset.horizontal - labelWidth, yOffset + labelOffset.vertical);
									}
								yOffset -= yDivSize;
							}
					}
			}
		
		public int scale(double data)
			{
				return tickMax + tickMin - axisScale.scale(data);
			}
		
	}

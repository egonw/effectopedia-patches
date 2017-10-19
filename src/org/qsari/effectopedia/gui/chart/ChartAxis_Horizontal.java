package org.qsari.effectopedia.gui.chart;

import java.awt.Graphics2D;
import java.awt.Polygon;

import org.qsari.effectopedia.gui.chart.ChartUtils.Offset;

public class ChartAxis_Horizontal extends ChartAxis
	{
		public ChartAxis_Horizontal()
			{
				super(ChartAxis.DEFAULT_X, Offset.BOTTOM_AXIS, Offset.BOTTOM_AXIS_LABELS, INDENT_NORTH, true);
				height = ChartUtils.defaultAxisSize >> 1;
			}
		
		public ChartAxis_Horizontal(int visualOptions, Offset axisOffset, Offset labelOffset, double indent, boolean linear)
			{
				super(visualOptions, axisOffset, labelOffset, indent, linear);
				height = ChartUtils.defaultAxisSize >> 1;
			}
		
		public boolean isFixedY()
			{
				return true;
			}
		
		public void updatePosition()
			{
				position = y + (int) (height * indent);
			}
		
		@Override
		public void updateTickRange()
			{
				if (primaryCrossingAxis != null)
					tickMin = primaryCrossingAxis.position;
				else
					tickMin = this.x + axisOffset.horizontal;
				if (secondaryCrossingAxis != null)
					tickMax = secondaryCrossingAxis.position;
				else
					tickMax = tickMin + ((width - tickMin - (ChartUtils.defaultAxisSize >> 1)) / tickDivisions) * tickDivisions;
			}
		
		@Override
		public void render(Graphics2D canvas)
			{
				canvas.setStroke(ChartUtils.chartAxis);
				canvas.setColor(ChartUtils.chartAxisTickColor);
				if ((tickDivisions > 0) && ((options & SHOW_TICKS) != 0))
					{
						int xDivSize = (tickMax - tickMin) / tickDivisions;
						int xOffset = tickMin + xDivSize;
						for (int i = 0; i < tickDivisions; i++)
							{
								canvas.drawLine(xOffset, position - 2, xOffset, position + 2);
								xOffset += xDivSize;
							}
					}
				canvas.setColor(ChartUtils.chartAxisColor);
				canvas.drawLine(this.x, position, this.x + width - 2, position);
				Polygon poly = new Polygon();
				poly.addPoint(this.x + width - 10, position - 6);
				poly.addPoint(this.x + width - 2, position);
				poly.addPoint(this.x + width - 10, position + 6);
				canvas.fill(poly);
				renderLabels(canvas);
			}
		
		public void renderLabels(Graphics2D canvas)
			{
				canvas.setColor(labelColor);
				// canvas.setFont(lableFont);
				if ((tickDivisions > 0) && ((options & SHOW_TICKS) != 0))
					{
						int xDivSize = (tickMax - tickMin) / tickDivisions;
						int xOffset = tickMin;
						for (int i = 0; i <= tickDivisions; i++)
							{
								canvas.drawLine(xOffset, position - 2, xOffset, position + 2);
								if (((options & SHOW_LABELS) != 0) && (labels.size() > i))
									canvas.drawString(labels.get(i), xOffset + labelOffset.horizontal, position + labelOffset.vertical);
								xOffset += xDivSize;
							}
					}
			}
	}

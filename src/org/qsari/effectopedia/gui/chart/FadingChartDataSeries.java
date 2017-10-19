package org.qsari.effectopedia.gui.chart;

import java.awt.Color;

import org.qsari.effectopedia.data.quantification.DataSeries;

public class FadingChartDataSeries extends ChartDataSeries
	{
		
		public FadingChartDataSeries(DataSeries data, ChartAxis_Horizontal xAxis, ChartAxis_Vertical yAxis, int markerType, Color baseColor)
			{
				super(data, xAxis, yAxis, markerType, baseColor);
				alpha = 255;
			}
		
		public FadingChartDataSeries(ChartDataSeries series)
			{
				super(series.data, series.xAxis, series.yAxis, MARKER_NONE, series.seriesColor);
				setMarker(series.marker);
				alpha = 255;
			}
		
		public void fadeColors(int alpha)
			{
				float red = seriesColor.getRed();
				float green = seriesColor.getGreen();
				float blue = seriesColor.getBlue();
				red += 0.0625 * red;
				if (red>255)
					red = 255f;
				green += 0.0625 * green;
				if (green>255f)
					green = 255f;
				blue += 0.0625 * blue;
				if (blue>255f)
					blue = 255f;
				seriesColor = new Color(red/255,green/255,blue/255);
				errorAreaColor = new java.awt.Color(red / 255, green / 255, blue / 255, (alpha / 255) * .2f);
				red += 0.0625 * red;
				if (red>255)
					red = 255f;
				green += 0.0625 * green;
				if (green>255f)
					green = 255f;
				blue += 0.0625 * blue;
				if (blue>255f)
					blue = 255f;
				errorBarColor = new Color(red/255,green/255,blue/255);
				marker.outlineColor = seriesColor;
			}
		
		public boolean fade()
			{
				alpha -= 16;
				if (alpha > 0)
					{
						fadeColors(alpha);
						return true;
					}
				else
					return false;
			}
		
		protected int	alpha;
	}

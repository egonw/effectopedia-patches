package org.qsari.effectopedia.gui.chart;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.Icon;

import org.qsari.effectopedia.data.quantification.DataSeries;

public class ChartDataSeries extends ChartComponent
	{
		public ChartDataSeries(ChartAxis_Horizontal xAxis, ChartAxis_Vertical yAxis, int dataPointsCount, int markerType, Color baseColor)
			{
				this.size = dataPointsCount;
				data = new DataSeries(dataPointsCount, 5, true);
				this.xAxis = xAxis;
				this.yAxis = yAxis;
				AssignMarker(markerType);
				data.GenerateRandomData();
				updateColors(baseColor);
			}
		
		public ChartDataSeries(DataSeries data, ChartAxis_Horizontal xAxis, ChartAxis_Vertical yAxis, int markerType, Color baseColor)
			{
				this.size = data.size;
				this.data = data;
				this.xAxis = xAxis;
				this.yAxis = yAxis;
				AssignMarker(markerType);
				updateColors(baseColor);
			}
		
		public void preRender(Graphics2D canvas)
			{
				updateScaledData();
				renderErrorArea(canvas);
				renderErrorBars(canvas);
			}
		
		@Override
		public void render(Graphics2D canvas)
			{
				updateScaledData();
				canvas.setStroke(ChartUtils.chartDataSeries);
				canvas.setColor(seriesColor);
				int x1 = rawXScaledData[0];
				double y1 = data.y.meanData[0];
				for (int i = 1; i <= size - 1; i++)
					{
						int x2 = rawXScaledData[i];
						double y2 = data.y.meanData[i];
						if ((!Double.isNaN(y1)) && (!Double.isNaN(y2)))
							canvas.drawLine(x1, yAxis.scale(y1), x2, yAxis.scale(y2));
						x1 = x2;
						y1 = y2;
					}
				renderMarkers(canvas);
			}
		
		protected void updateScaledData()
			{
				rawXScaledData = new int[size];
				for (int i = 0; i < size; i++)
					rawXScaledData[i] = xAxis.scale(data.x.meanData[i]);
			}
		
		protected void updateAxis(ChartAxis_Horizontal xAxis, ChartAxis_Vertical yAxis)
			{
				this.xAxis = xAxis;
				this.yAxis = yAxis;
			}
		
		protected void renderMarkers(Graphics2D canvas)
			{
				canvas.setStroke(ChartUtils.chartLine);
				canvas.setColor(seriesColor);
				for (int i = 0; i < size; i++)
					{
						double x = rawXScaledData[i];
						double y = data.y.meanData[i];
						if ((!Double.isNaN(x)) && (!Double.isNaN(y)))
							marker.render(canvas, (int) x, yAxis.scale(y));
					}
			}
		
		protected void renderErrorBars(Graphics2D canvas)
			{
				canvas.setStroke(ChartUtils.chartLine);
				canvas.setColor(seriesColor);
				for (int i = 0; i < size; i++)
					{
						int x = rawXScaledData[i];
						double minE = data.y.displayMin[i];
						double maxE = data.y.displayMax[i];
						if ((!Double.isNaN(minE)) && (!Double.isNaN(maxE)))
							{
								int l = yAxis.scale(minE);
								int u = yAxis.scale(maxE);
								canvas.drawLine(x, l, x, u);
								canvas.drawLine(x - 2, l, x + 2, l);
								canvas.drawLine(x - 2, u, x + 2, u);
							}
					}
			}
		
		private void renderErrorArea(Graphics2D canvas)
			{
				canvas.setStroke(ChartUtils.chartLine);
				canvas.setColor(errorAreaColor);
				Polygon poly = new Polygon();
				for (int i = 0; i < size; i++)
					{
						double y = data.y.displayMin[i];
						if ((!Double.isNaN(y)))
							poly.addPoint(rawXScaledData[i], yAxis.scale(y));
					}
				for (int i = size - 1; i >= 0; i--)
					{
						double y = data.y.displayMax[i];
						if ((!Double.isNaN(y)))
							poly.addPoint(rawXScaledData[i], yAxis.scale(y));
					}
				canvas.fill(poly);
			}
		
		@Override
		public void update()
			{
				xAxis.considerDataRange(data.x.min, data.x.max);
				yAxis.considerDataRange(data.y.rangeMin, data.y.rangeMax);
			}
		
		public double[][] getXRawData()
			{
				return data.getXRawData();
			}
		
		public double[][] getYRawData()
			{
				return data.getYRawData();
			}
		
		public static class Marker implements Icon
			{
				public Marker(Color fillColor, Color outlineColor)
					{
						this.fillColor = fillColor;
						this.outlineColor = outlineColor;
					}
				
				public void render(Graphics2D canvas, int x, int y)
					{
					}
				
				public int getSize()
					{
						return size;
					}
				
				public void setSize(int size)
					{
						this.size = size;
						this.halfSize = size >> 1;
					}
				
				public String toString()
					{
						return "none";
					}
				
				@Override
				public int getIconHeight()
					{
						return 2 * size;
					}
				
				@Override
				public int getIconWidth()
					{
						return 2 * size;
					}
				
				@Override
				public void paintIcon(Component component, Graphics graphics, int x, int y)
					{
						render((Graphics2D) graphics, x + size, y + size);
					}
				
				protected int	size					= ChartUtils.defaultMarkerSize;
				protected int	halfSize	= ChartUtils.defaultMarkerSize >> 1;
				public Color		fillColor;
				public Color		outlineColor;
			}
		
		public static class CircleMarker extends ChartDataSeries.Marker
			{
				public CircleMarker(Color fillColor, Color outlineColor)
					{
						super(fillColor, outlineColor);
					}
				
				public void render(Graphics2D canvas, int x, int y)
					{
						canvas.setColor(fillColor);
						canvas.fillOval(x - halfSize, y - halfSize, size, size);
						canvas.setColor(outlineColor);
						canvas.drawOval(x - halfSize, y - halfSize, size, size);
					}
				
				public String toString()
					{
						return "circle";
					}
			}
		
		public static class SquareMarker extends ChartDataSeries.Marker
			{
				public SquareMarker(Color fillColor, Color outlineColor)
					{
						super(fillColor, outlineColor);
					}
				
				public void render(Graphics2D canvas, int x, int y)
					{
						canvas.setColor(fillColor);
						canvas.fillRect(x - halfSize, y - halfSize, size, size);
						canvas.setColor(outlineColor);
						canvas.drawRect(x - halfSize, y - halfSize, size, size);
					}
				
				public String toString()
					{
						return "square";
					}
			}
		
		public static class RhombMarker extends ChartDataSeries.Marker
			{
				public RhombMarker(Color fillColor, Color outlineColor)
					{
						super(fillColor, outlineColor);
					}
				
				public void render(Graphics2D canvas, int x, int y)
					{
						canvas.setColor(fillColor);
						Polygon poly = new Polygon();
						poly.addPoint(x, y - halfSize);
						poly.addPoint(x + halfSize, y);
						poly.addPoint(x, y + halfSize);
						poly.addPoint(x - halfSize, y);
						canvas.fill(poly);
						canvas.setColor(outlineColor);
						canvas.draw(poly);
					}
				
				public String toString()
					{
						return "rhomb";
					}
			}
		
		public static class TriangleMarker extends ChartDataSeries.Marker
			{
				public TriangleMarker(Color fillColor, Color outlineColor)
					{
						super(fillColor, outlineColor);
					}
				
				public void render(Graphics2D canvas, int x, int y)
					{
						canvas.setColor(fillColor);
						Polygon poly = new Polygon();
						poly.addPoint(x, y - halfSize);
						poly.addPoint(x + halfSize, y + sqrt2HalfSize);
						poly.addPoint(x - halfSize, y + sqrt2HalfSize);
						canvas.fill(poly);
						canvas.setColor(outlineColor);
						canvas.draw(poly);
					}
				
				public void setSize(int size)
					{
						this.size = size;
						this.halfSize = size >> 1;
						this.sqrt2HalfSize = (int) (size / (2 * Math.sqrt(2)));
					}
				
				public String toString()
					{
						return "triangle";
					}
				
				protected int	sqrt2HalfSize	= (int) (ChartUtils.defaultMarkerSize / (2 * Math.sqrt(2)));
			}
		
		public static class SouthTriangleMarker extends ChartDataSeries.TriangleMarker
			{
				public SouthTriangleMarker(Color fillColor, Color outlineColor)
					{
						super(fillColor, outlineColor);
					}
				
				public void render(Graphics2D canvas, int x, int y)
					{
						canvas.setColor(fillColor);
						Polygon poly = new Polygon();
						poly.addPoint(x, y + halfSize);
						poly.addPoint(x + halfSize, y - sqrt2HalfSize);
						poly.addPoint(x - halfSize, y - sqrt2HalfSize);
						canvas.fill(poly);
						canvas.setColor(outlineColor);
						canvas.draw(poly);
					}
				
				public String toString()
					{
						return "trinagle (south)";
					}
				
			}
		
		public static class WestTriangleMarker extends ChartDataSeries.TriangleMarker
			{
				public WestTriangleMarker(Color fillColor, Color outlineColor)
					{
						super(fillColor, outlineColor);
					}
				
				public void render(Graphics2D canvas, int x, int y)
					{
						canvas.setColor(fillColor);
						Polygon poly = new Polygon();
						poly.addPoint(x - halfSize, y);
						poly.addPoint(x + sqrt2HalfSize, y - halfSize);
						poly.addPoint(x + sqrt2HalfSize, y + halfSize);
						canvas.fill(poly);
						canvas.setColor(outlineColor);
						canvas.draw(poly);
					}
				
				public String toString()
					{
						return "trinagle (west)";
					}
			}
		
		public static class EastTriangleMarker extends ChartDataSeries.TriangleMarker
			{
				public EastTriangleMarker(Color fillColor, Color outlineColor)
					{
						super(fillColor, outlineColor);
					}
				
				public void render(Graphics2D canvas, int x, int y)
					{
						canvas.setColor(fillColor);
						Polygon poly = new Polygon();
						poly.addPoint(x + halfSize, y);
						poly.addPoint(x - sqrt2HalfSize, y - halfSize);
						poly.addPoint(x - sqrt2HalfSize, y + halfSize);
						canvas.fill(poly);
						canvas.setColor(outlineColor);
						canvas.draw(poly);
					}
				
				public String toString()
					{
						return "trinagle (east)";
					}
			}
		
		public static class PlusMarker extends ChartDataSeries.Marker
			{
				public PlusMarker(Color fillColor, Color outlineColor)
					{
						super(fillColor, outlineColor);
					}
				
				public void render(Graphics2D canvas, int x, int y)
					{
						canvas.setColor(fillColor);
						Polygon poly = new Polygon();
						poly.addPoint(x - quaterSize, y - halfSize);
						poly.addPoint(x + quaterSize, y - halfSize);
						poly.addPoint(x + quaterSize, y - quaterSize);
						poly.addPoint(x + halfSize, y - quaterSize);
						poly.addPoint(x + halfSize, y + quaterSize);
						poly.addPoint(x + quaterSize, y + quaterSize);
						poly.addPoint(x + quaterSize, y + halfSize);
						poly.addPoint(x - quaterSize, y + halfSize);
						poly.addPoint(x - quaterSize, y + quaterSize);
						poly.addPoint(x - quaterSize, y + quaterSize);
						poly.addPoint(x - halfSize, y + quaterSize);
						poly.addPoint(x - halfSize, y - quaterSize);
						poly.addPoint(x - quaterSize, y - quaterSize);
						canvas.fill(poly);
						canvas.setColor(outlineColor);
						canvas.draw(poly);
					}
				
				public void setSize(int size)
					{
						this.size = size;
						this.halfSize = size >> 1;
						this.quaterSize = size >> 2;
					}
				
				public String toString()
					{
						return "plus";
					}
				
				protected int	quaterSize	= ChartUtils.defaultMarkerSize >> 2;
			}
		
		public static class MinusMarker extends ChartDataSeries.PlusMarker
			{
				public MinusMarker(Color fillColor, Color outlineColor)
					{
						super(fillColor, outlineColor);
					}
				
				public void render(Graphics2D canvas, int x, int y)
					{
						canvas.setColor(fillColor);
						Polygon poly = new Polygon();
						poly.addPoint(x - halfSize, y - quaterSize);
						poly.addPoint(x + halfSize, y - quaterSize);
						poly.addPoint(x + halfSize, y + quaterSize);
						poly.addPoint(x - halfSize, y + quaterSize);
						canvas.fill(poly);
						canvas.setColor(outlineColor);
						canvas.draw(poly);
					}
				
				public String toString()
					{
						return "minus";
					}
				
			}
		
		public static class BarMarker extends ChartDataSeries.PlusMarker
			{
				public BarMarker(Color fillColor, Color outlineColor)
					{
						super(fillColor, outlineColor);
					}
				
				public void render(Graphics2D canvas, int x, int y)
					{
						canvas.setColor(fillColor);
						Polygon poly = new Polygon();
						poly.addPoint(x - quaterSize, y - halfSize);
						poly.addPoint(x + quaterSize, y - halfSize);
						poly.addPoint(x + quaterSize, y + halfSize);
						poly.addPoint(x - quaterSize, y + halfSize);
						canvas.fill(poly);
						canvas.setColor(outlineColor);
						canvas.draw(poly);
					}
				
				public String toString()
					{
						return "bar";
					}
				
			}
		
		public static class DiagonalMarker extends ChartDataSeries.PlusMarker
			{
				public DiagonalMarker(Color fillColor, Color outlineColor)
					{
						super(fillColor, outlineColor);
					}
				
				public void render(Graphics2D canvas, int x, int y)
					{
						canvas.setColor(fillColor);
						Polygon poly = new Polygon();
						poly.addPoint(x - halfSize, y - halfSize);
						poly.addPoint(x - quaterSize, y - halfSize);
						poly.addPoint(x + halfSize, y + quaterSize);
						poly.addPoint(x + halfSize, y + halfSize);
						poly.addPoint(x + quaterSize, y + halfSize);
						poly.addPoint(x - halfSize, y - quaterSize);
						canvas.fill(poly);
						canvas.setColor(outlineColor);
						canvas.draw(poly);
					}
				
				public String toString()
					{
						return "diagonal";
					}
				
			}
		
		public static class DivisionMarker extends ChartDataSeries.PlusMarker
			{
				public DivisionMarker(Color fillColor, Color outlineColor)
					{
						super(fillColor, outlineColor);
					}
				
				public void render(Graphics2D canvas, int x, int y)
					{
						canvas.setColor(fillColor);
						Polygon poly = new Polygon();
						poly.addPoint(x + quaterSize, y - halfSize);
						poly.addPoint(x + halfSize, y - halfSize);
						poly.addPoint(x + halfSize, y - quaterSize);
						poly.addPoint(x - quaterSize, y + halfSize);
						poly.addPoint(x - halfSize, y + halfSize);
						poly.addPoint(x - halfSize, y + quaterSize);
						canvas.fill(poly);
						canvas.setColor(outlineColor);
						canvas.draw(poly);
					}
				
				public String toString()
					{
						return "division";
					}
				
			}
		
		public static class XMarker extends ChartDataSeries.PlusMarker
			{
				public XMarker(Color fillColor, Color outlineColor)
					{
						super(fillColor, outlineColor);
					}
				
				public void render(Graphics2D canvas, int x, int y)
					{
						canvas.setColor(fillColor);
						Polygon poly = new Polygon();
						poly.addPoint(x - halfSize, y - halfSize);
						poly.addPoint(x - quaterSize, y - halfSize);
						poly.addPoint(x, y - quaterSize);
						poly.addPoint(x + quaterSize, y - halfSize);
						poly.addPoint(x + halfSize, y - halfSize);
						poly.addPoint(x + halfSize, y - quaterSize);
						poly.addPoint(x + quaterSize, y);
						poly.addPoint(x + halfSize, y + quaterSize);
						poly.addPoint(x + halfSize, y + halfSize);
						poly.addPoint(x + quaterSize, y + halfSize);
						poly.addPoint(x, y + quaterSize);
						poly.addPoint(x - quaterSize, y + halfSize);
						poly.addPoint(x - halfSize, y + halfSize);
						poly.addPoint(x - halfSize, y + quaterSize);
						poly.addPoint(x - quaterSize, y);
						poly.addPoint(x - halfSize, y - quaterSize);
						canvas.fill(poly);
						canvas.setColor(outlineColor);
						canvas.draw(poly);
					}
				
				public String toString()
					{
						return "X marker";
					}
				
			}
		
		public static class YMarker extends ChartDataSeries.Marker
			{
				public YMarker(Color fillColor, Color outlineColor)
					{
						super(fillColor, outlineColor);
					}
				
				public void render(Graphics2D canvas, int x, int y)
					{
						canvas.setColor(fillColor);
						Polygon poly = new Polygon();
						poly.addPoint(x - halfSize, y - halfSize);
						poly.addPoint(x - quaterSize, y - halfSize);
						poly.addPoint(x, y - quaterSize);
						poly.addPoint(x + quaterSize, y - halfSize);
						poly.addPoint(x + halfSize, y - halfSize);
						poly.addPoint(x + halfSize, y - quaterSize);
						poly.addPoint(x + stemSize, y);
						poly.addPoint(x + stemSize, y + halfSize);
						poly.addPoint(x - stemSize, y + halfSize);
						poly.addPoint(x - stemSize, y);
						canvas.fill(poly);
						canvas.setColor(outlineColor);
						canvas.draw(poly);
					}
				
				public void setSize(int size)
					{
						this.size = size;
						this.halfSize = size >> 1;
						this.quaterSize = size >> 2;
					}
				
				public String toString()
					{
						return "Y marker";
					}
				
				protected int	quaterSize	= ChartUtils.defaultMarkerSize >> 2;
				protected int	stemSize			= (int) Math.round(ChartUtils.defaultMarkerSize * (Math.sqrt(2) / 8));
			}
		
		public static class InvertedYMarker extends ChartDataSeries.YMarker
			{
				public InvertedYMarker(Color fillColor, Color outlineColor)
					{
						super(fillColor, outlineColor);
					}
				
				public void render(Graphics2D canvas, int x, int y)
					{
						canvas.setColor(fillColor);
						Polygon poly = new Polygon();
						poly.addPoint(x - stemSize, y - halfSize);
						poly.addPoint(x + stemSize, y - halfSize);
						poly.addPoint(x + stemSize, y);
						poly.addPoint(x + halfSize, y + quaterSize);
						poly.addPoint(x + halfSize, y + halfSize);
						poly.addPoint(x + quaterSize, y + halfSize);
						poly.addPoint(x, y + quaterSize);
						poly.addPoint(x - quaterSize, y + halfSize);
						poly.addPoint(x - halfSize, y + halfSize);
						poly.addPoint(x - halfSize, y + quaterSize);
						poly.addPoint(x - stemSize, y);
						canvas.fill(poly);
						canvas.setColor(outlineColor);
						canvas.draw(poly);
					}
				
				public String toString()
					{
						return "inverted Y";
					}
			}
		
		public static class NorthHouseMarker extends ChartDataSeries.Marker
			{
				public NorthHouseMarker(Color fillColor, Color outlineColor)
					{
						super(fillColor, outlineColor);
					}
				
				public void render(Graphics2D canvas, int x, int y)
					{
						canvas.setColor(fillColor);
						Polygon poly = new Polygon();
						poly.addPoint(x, y - halfSize);
						poly.addPoint(x + halfSize, y);
						poly.addPoint(x + halfSize, y + halfSize);
						poly.addPoint(x - halfSize, y + halfSize);
						poly.addPoint(x - halfSize, y);
						canvas.fill(poly);
						canvas.setColor(outlineColor);
						canvas.draw(poly);
					}
				
				public String toString()
					{
						return "house";
					}
			}
		
		public static class EastHouseMarker extends ChartDataSeries.Marker
			{
				public EastHouseMarker(Color fillColor, Color outlineColor)
					{
						super(fillColor, outlineColor);
					}
				
				public void render(Graphics2D canvas, int x, int y)
					{
						canvas.setColor(fillColor);
						Polygon poly = new Polygon();
						poly.addPoint(x - halfSize, y - halfSize);
						poly.addPoint(x, y - halfSize);
						poly.addPoint(x + halfSize, y);
						poly.addPoint(x, y + halfSize);
						poly.addPoint(x - halfSize, y + halfSize);
						canvas.fill(poly);
						canvas.setColor(outlineColor);
						canvas.draw(poly);
					}
				
				public String toString()
					{
						return "houe (east)";
					}
			}
		
		public static class WestHouseMarker extends ChartDataSeries.Marker
			{
				public WestHouseMarker(Color fillColor, Color outlineColor)
					{
						super(fillColor, outlineColor);
					}
				
				public void render(Graphics2D canvas, int x, int y)
					{
						canvas.setColor(fillColor);
						Polygon poly = new Polygon();
						poly.addPoint(x - halfSize, y);
						poly.addPoint(x, y - halfSize);
						poly.addPoint(x + halfSize, y - halfSize);
						poly.addPoint(x + halfSize, y + halfSize);
						poly.addPoint(x, y + halfSize);
						canvas.fill(poly);
						canvas.setColor(outlineColor);
						canvas.draw(poly);
					}
				
				public String toString()
					{
						return "house (west)";
					}
			}
		
		public static class SouthHouseMarker extends ChartDataSeries.Marker
			{
				public SouthHouseMarker(Color fillColor, Color outlineColor)
					{
						super(fillColor, outlineColor);
					}
				
				public void render(Graphics2D canvas, int x, int y)
					{
						canvas.setColor(fillColor);
						Polygon poly = new Polygon();
						poly.addPoint(x - halfSize, y - halfSize);
						poly.addPoint(x + halfSize, y - halfSize);
						poly.addPoint(x + halfSize, y);
						poly.addPoint(x, y + halfSize);
						poly.addPoint(x - halfSize, y);
						canvas.fill(poly);
						canvas.setColor(outlineColor);
						canvas.draw(poly);
					}
				
				public String toString()
					{
						return "house (south)";
					}
			}
		
		public static class InfMarker extends ChartDataSeries.Marker
			{
				public InfMarker(Color fillColor, Color outlineColor)
					{
						super(fillColor, outlineColor);
					}
				
				public void render(Graphics2D canvas, int x, int y)
					{
						canvas.setColor(fillColor);
						Polygon poly = new Polygon();
						poly.addPoint(x - halfSize, y - halfSize);
						poly.addPoint(x + halfSize, y + halfSize);
						poly.addPoint(x + halfSize, y - halfSize);
						poly.addPoint(x - halfSize, y + halfSize);
						canvas.fill(poly);
						canvas.setColor(outlineColor);
						canvas.draw(poly);
					}
				
				public String toString()
					{
						return "infinity";
					}
				
			}
		
		public static class EightMarker extends ChartDataSeries.Marker
			{
				public EightMarker(Color fillColor, Color outlineColor)
					{
						super(fillColor, outlineColor);
					}
				
				public void render(Graphics2D canvas, int x, int y)
					{
						canvas.setColor(fillColor);
						Polygon poly = new Polygon();
						poly.addPoint(x - halfSize, y - halfSize);
						poly.addPoint(x + halfSize, y - halfSize);
						poly.addPoint(x - halfSize, y + halfSize);
						poly.addPoint(x + halfSize, y + halfSize);
						canvas.fill(poly);
						canvas.setColor(outlineColor);
						canvas.draw(poly);
					}
				
				public String toString()
					{
						return "eight";
					}
				
			}
		
		public void AssignMarker(int markerType)
			{
				marker = newMarker(markerType, Color.white, seriesColor);
			}
		
		public static Marker newMarker(int markerType, Color fillColor, Color outlineColor)
			{
				if (markerType == MARKER_NONE)
					return new Marker(fillColor, outlineColor);
				else if (markerType == MARKER_CIRCLE)
					return new CircleMarker(fillColor, outlineColor);
				else if (markerType == MARKER_SQUARE)
					return new SquareMarker(fillColor, outlineColor);
				else if (markerType == MARKER_RHOMB)
					return new RhombMarker(fillColor, outlineColor);
				else if (markerType == MARKER_NORTH_TRIANGLE)
					return new TriangleMarker(fillColor, outlineColor);
				else if (markerType == MARKER_SOUTH_TRIANGLE)
					return new SouthTriangleMarker(fillColor, outlineColor);
				else if (markerType == MARKER_EAST_TRIANGLE)
					return new EastTriangleMarker(fillColor, outlineColor);
				else if (markerType == MARKER_WEST_TRIANGLE)
					return new WestTriangleMarker(fillColor, outlineColor);
				else if (markerType == MARKER_PLUS)
					return new PlusMarker(fillColor, outlineColor);
				else if (markerType == MARKER_MINUS)
					return new MinusMarker(fillColor, outlineColor);
				else if (markerType == MARKER_BAR)
					return new BarMarker(fillColor, outlineColor);
				else if (markerType == MARKER_DIVISION)
					return new DivisionMarker(fillColor, outlineColor);
				else if (markerType == MARKER_DIAGONAL)
					return new DiagonalMarker(fillColor, outlineColor);
				else if (markerType == MARKER_X)
					return new XMarker(fillColor, outlineColor);
				else if (markerType == MARKER_Y)
					return new YMarker(fillColor, outlineColor);
				else if (markerType == MARKER_INVERTED_Y)
					return new InvertedYMarker(fillColor, outlineColor);
				else if (markerType == MARKER_NORTH_HOUSE)
					return new NorthHouseMarker(fillColor, outlineColor);
				else if (markerType == MARKER_SOUTH_HOUSE)
					return new SouthHouseMarker(fillColor, outlineColor);
				else if (markerType == MARKER_EAST_HOUSE)
					return new EastHouseMarker(fillColor, outlineColor);
				else if (markerType == MARKER_WEST_HOUSE)
					return new WestHouseMarker(fillColor, outlineColor);
				else
					return new Marker(fillColor, outlineColor);
			}
		
		public void updateColors(Color baseColor)
			{
				seriesColor = baseColor;
				float red = seriesColor.getRed();
				float green = seriesColor.getGreen();
				float blue = seriesColor.getBlue();
				errorAreaColor = new java.awt.Color(red / 255, green / 255, blue / 255, .2f);
				red += 0.1 * red;
				green += 0.1 * green;
				blue += 0.1 * blue;
				errorBarColor = new Color((red < 1.0f) ? red : 1.0f, (green < 1.0f) ? green : 1.0f, (blue < 1.0f) ? blue : 1.0f);
				marker.outlineColor = seriesColor;
			}
		
		public Marker getMarker()
			{
				return marker;
			}
		
		public void setMarker(Marker marker)
			{
				this.marker = marker;
			}
		
		protected Marker												marker;
		protected int[]													rawXScaledData;
		public DataSeries											data;
		public final int												size;
		public ChartAxis_Horizontal	xAxis;
		public ChartAxis_Vertical			yAxis;
		public Color																seriesColor											= ChartUtils.chartSeriesBlueColor;
		public Color																errorBarColor									= ChartUtils.chartSeriesErrorBarColor;
		public Color																errorAreaColor								= ChartUtils.chartSeriesErrorAreaColor;
		
		public final static int					MARKER_NONE											= 0;
		public final static int					MARKER_CIRCLE									= 1;
		public final static int					MARKER_SQUARE									= 2;
		public final static int					MARKER_RHOMB										= 3;
		public final static int					MARKER_NORTH_TRIANGLE	= 4;
		public final static int					MARKER_SOUTH_TRIANGLE	= 5;
		public final static int					MARKER_EAST_TRIANGLE		= 6;
		public final static int					MARKER_WEST_TRIANGLE		= 7;
		public final static int					MARKER_PLUS											= 8;
		public final static int					MARKER_MINUS										= 9;
		public final static int					MARKER_BAR												= 10;
		public final static int					MARKER_DIVISION							= 11;
		public final static int					MARKER_DIAGONAL							= 12;
		public final static int					MARKER_X														= 13;
		public final static int					MARKER_Y														= 14;
		public final static int					MARKER_INVERTED_Y					= 15;
		public final static int					MARKER_NORTH_HOUSE				= 16;
		public final static int					MARKER_SOUTH_HOUSE				= 17;
		public final static int					MARKER_EAST_HOUSE					= 18;
		public final static int					MARKER_WEST_HOUSE					= 19;
		public final static int					MARKER_MAX												= MARKER_WEST_HOUSE;
	}

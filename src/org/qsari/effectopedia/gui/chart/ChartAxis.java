package org.qsari.effectopedia.gui.chart;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import org.qsari.effectopedia.gui.chart.ChartUtils.Offset;

public abstract class ChartAxis extends ChartComponent
	{
		public static final int				HORIZONTAL				= 1;
		public static final int				VERTICAL						= 2;
		public static final int				SHOW_LABELS			= 4;
		public static final int				SHOW_TICKS				= 8;
		public static final int				DEFAULT_X					= HORIZONTAL + SHOW_LABELS + SHOW_TICKS;
		public static final int				DEFAULT_Y					= VERTICAL + SHOW_LABELS + SHOW_TICKS;
		
		public static final double	INDENT_NORTH		= 0.0f;
		public static final double	INDENT_SOUTH		= 1.0f;
		public static final double	INDENT_MIDDLE	= 0.5f;
		public static final double	INDENT_EAST			= 1.0f;
		public static final double	INDENT_WEST			= 0.0f;
		
		public ChartAxis(int visualOptions, Offset axisOffset, Offset labelOffset, double indent, boolean linear)
			{
				this.options = visualOptions;
				this.axisOffset = axisOffset;
				this.labelOffset = labelOffset;
				this.indent = indent;
				if (linear)
					axisScale = new AxisLinearScale();
				else
					axisScale = new AxisLogScale();
			}
		
		public void primaryCross(ChartAxis axis)
			{
				this.primaryCrossingAxis = axis;
				axis.primaryCrossingAxis = this;
			}

		public void secondaryCross(ChartAxis axis)
			{
				this.secondaryCrossingAxis = axis;
				axis.primaryCrossingAxis = this;
			}
		
		public void update()
			{
				updatePosition();
				if (primaryCrossingAxis != null)
					{
						primaryCrossingAxis.updatePosition();
						primaryCrossingAxis.updateTickRange();
					}
				if (secondaryCrossingAxis != null)
					{
						secondaryCrossingAxis.updatePosition();
						secondaryCrossingAxis.updateTickRange();
					}
				updateTickRange();
				axisScale.update();
				updateLabels();
				//System.out.println(this.getClass().getName()+" min: "+axisScale.axisMin+" max: "+axisScale.axisMax);
			}
		
		public abstract void updateTickRange();
		
		public abstract void updatePosition();
		
		public void updateLabels()
			{
				labels = new ArrayList<String>(tickDivisions);
				double step = (axisScale.axisMax - axisScale.axisMin) / tickDivisions;
				double labelValue = axisScale.axisMin;
				for (int i = 0; i <= tickDivisions; i++)
					{
						String label = String.format("%.1f", labelValue);
						labels.add(label);
						labelValue += step;
					}
			}
		
		public Color getLabelColor()
			{
				return labelColor;
			}
		
		public void setLabelColor(Color labelColor)
			{
				this.labelColor = labelColor;
			}
		
		public Font getLableFont()
			{
				return lableFont;
			}
		
		public void setLableFont(Font lableFont)
			{
				this.lableFont = lableFont;
			}
		
		public void considerDataRange(double dataMin, double dataMax)
			{
				double pRange = Math.pow(10, Math.round(Math.log10((Math.abs(dataMax-dataMin)))));
				if (pRange<=0)
					pRange = 1D;
				if (pRange>10)
					pRange = 10;
				if (defaultRange)
					{
						axisScale.setAxisMin((double) Math.signum(dataMin)*((Math.abs(dataMin) / pRange) * pRange));
						axisScale.setAxisMax((double) (Math.ceil(dataMax / pRange) * pRange));
						defaultRange = false;
					}
				else
					{
						if (axisScale.axisMin > dataMin)
							axisScale.setAxisMin((double) Math.signum(dataMin)*(Math.floor(Math.abs(dataMin) / pRange) * pRange));
						if (axisScale.axisMax < dataMax)
							axisScale.setAxisMax((double)(Math.ceil(dataMax / pRange) * pRange));
					}
				axisScale.update();
			}
		
		public int scale(double data)
			{
				return axisScale.scale(data);
			}

		public double value(int index)
			{
				return axisScale.value(index);
			}
		
		public abstract class AxisScale
			{
				public abstract int scale(double data);
				
				public abstract double value(int index); 
				
				public void update()
					{
						axisRange = axisMax - axisMin;
						axisScale = (axisRange != 0) ? (tickMax - tickMin) / axisRange : 1.0f;
					}
				
				public double getAxisMin()
					{
						return axisMin;
					}
				
				public void setAxisMin(double axisMin)
					{
						this.axisMin = axisMin;
					}
				
				public double getAxisMax()
					{
						return axisMax;
					}
				
				public void setAxisMax(double axisMax)
					{
						this.axisMax = axisMax;
					}
				
				public double getAxisRange()
					{
						return axisRange;
					}
				
				public double getAxisScale()
					{
						return axisScale;
					}
				
				protected double	axisMin			= ChartUtils.DEAFULT_MIN;
				protected double	axisMax			= ChartUtils.DEAFULT_MAX;
				protected double	axisRange	= axisMax - axisMin;
				protected double	axisScale	= 1.0f;
			}
		
		public class AxisLinearScale extends ChartAxis.AxisScale
			{
				public int scale(double data)
					{
						return tickMin + (int) ((data - axisMin) * axisScale);
					}
				
				public double value(int index)
					{
						return axisMin + (int) ((index-tickMin) / axisScale);
					}
			}
		
		public class AxisLogScale extends ChartAxis.AxisScale
			{
				public int scale(double data)
					{
						if (data <= 0)
							return tickMin;
						else
							return tickMin + (int) ((Math.log10(data) - axisMin) * axisScale);
					}

				public double value(int index)
					{
						return Math.pow(10,axisMin + ((index-tickMin) / axisScale));
					}
				
				public void setAxisMin(double axisMin)
					{
						this.axisMin = (axisMin <= 0) ? 0.0D : (double) Math.log10(axisMin);
					}
				
				public void setAxisMax(double axisMax)
					{
						this.axisMax = (axisMax <= 0) ? 0.0D : (double) Math.log10(axisMax);
					}
			}
		
		AxisScale																			axisScale;
		boolean																					defaultRange		= true;
		int																									tickMin;
		int																									tickMax;
		protected int															position;
		protected ArrayList<String>	labels;
		protected Color													labelColor				= ChartUtils.chartAxisLabelColor;
		protected Font														lableFont					= ChartUtils.chartAxisLabelFont;
		public int																		options;
		public double															indent								= INDENT_MIDDLE;
		public Offset															labelOffset			= Offset.ZERO;
		public Offset															axisOffset				= Offset.ZERO;
		public int																		tickDivisions	= 6;
		public ChartAxis												primaryCrossingAxis;
		public ChartAxis												secondaryCrossingAxis;
	}

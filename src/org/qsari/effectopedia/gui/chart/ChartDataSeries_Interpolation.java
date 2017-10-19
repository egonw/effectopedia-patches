package org.qsari.effectopedia.gui.chart;

import java.awt.Color;
import java.awt.Graphics2D;

import Flanagan.Regression;
import Flanagan.RegressionFunction;
import Flanagan.RegressionFunction2;

public class ChartDataSeries_Interpolation extends ChartDataSeries
	{
		
		public ChartDataSeries_Interpolation(ChartAxis_Horizontal xAxis, ChartAxis_Vertical yAxis, int dataPointsCount, int markerType, Color baseColor, int intFnType)
			{
				super(xAxis, yAxis, dataPointsCount, markerType, baseColor);
				setInterpolationFunction(intFnType);
				interpolate();
			}
		
		private void setInterpolationFunction(int intFnType)
			{
				if (intFnType == IFN_SIGMOID)
					iFn = new IFn_Sigmoid();
				else if (intFnType == IFN_DOSE_RESP_STIMULATION)
					iFn = new IFn_DoseResponceStimulation();
				else if (intFnType == IFN_DOSE_RESP_INHIBITION)
					iFn = new IFn_DoseResponceInhibition();
				else if (intFnType == IFN_DOSE_RESP_STIM_ASYM)
					iFn = new IFn_DoseResponceAsymetric();
				else if (intFnType == IFN_DOSE_RESP_BIPHASIC)
					iFn = new IFn_Biphasic();
				else if (intFnType == IFN_BELLSHAPE)
					iFn = new IFn_Bellshape();
				else
					iFn = new InterpolationFunction();
			}
		
		@Override
		public void render(Graphics2D canvas)
			{
				canvas.setStroke(ChartUtils.chartInterpolation);
				canvas.setColor(seriesColor);
				if (interpolated)
					{
						int x1 = xAxis.tickMin;
						int y1 = yAxis.scale(iFn.value(xAxis.value(x1)));
						for (int i = xAxis.tickMin + xResolution; i < xAxis.tickMax; i += xResolution)
							{
								int x2 = i;
								int y2 = yAxis.scale(iFn.value(xAxis.value(x2)));
								canvas.drawLine(x1, y1, x2, y2);
								x1 = x2;
								y1 = y2;
							}
						canvas.drawLine(x1, y1, xAxis.tickMax, yAxis.scale(iFn.value(xAxis.value(xAxis.tickMax))));
						renderMarkers(canvas);
					}
				else
					super.render(canvas);
			}
		
		private void interpolate()
			{
				regression = new Regression(getXRawData(), getYRawData());
				iFn.getInitializationVector();
				//System.out.print(iFn.description(true));
				try
					{
						regression.simplex2(iFn, iFn.getInitializationVector());
						iFn.setParameters(regression.getCoeff());
						interpolated = true;
					}
				catch (Exception e)
					{
						interpolated = false;
					}
				//System.out.print(iFn.description(true));
			//	System.out.print(regression.dump());
			}
		
		public class InterpolationFunction implements RegressionFunction, RegressionFunction2
			{
				public String description(boolean showParamValues)
					{
						return "Constant" + (data.y.max - data.y.min) / 2 + "\n param[]";
					}
				
				public double function(double[] param, double[] x)
					{
						return (data.y.max - data.y.min) / 2;
					}

				public double function(double[] param, double[] x, int i)
					{
						return function(param,x);
					}
				
				public double value(double x)
					{
						return (data.y.max - data.y.min) / 2;
					}
				
				public void setParameters(double[] param)
					{
					}
				
				public double[] getInitializationVector()
					{
						return new double[0];
					}
			}
		
		public class IFn_Sigmoid extends InterpolationFunction
			{
				public String description(boolean showParamValues)
					{
						StringBuilder sb = new StringBuilder();
						sb.append("Standard slope dose response stimulation\n");
						sb.append("Y = bottom + (top-bottom)/(1+10^((logEC50-x)))\n");
						sb.append("where Y is the response\n");
						sb.append("      x is the log10 dose or concentration\n");
						sb.append("      bottom is the lowest value of the Y response\n");
						sb.append("      top is the plateaus of the Y response\n");
						sb.append("      logEC50 is the log10 of  half maximal effective concentration (in the same units as x)\n");
						sb.append("param[bottom,top,logEC50]\n");
						if (showParamValues)
							{
								sb.append("param[");
								sb.append(bottom);
								sb.append(",");
								sb.append(top);
								sb.append(",");
								sb.append(logEC50);
								sb.append("]\n");
							}
						return sb.toString();
					}
				
				@Override
				public double function(double[] param, double[] x)
					{
						// bottom + (top-bottom)/(1+10^((log(EC50)-x)*1))
						return param[0] + (param[1] - param[0]) / (1 + Math.pow(10, (param[2] - x[0])));
					}
				
				@Override
				public double value(double x)
					{
						return bottom + (top - bottom) / (1 + Math.pow(10, (logEC50 - x)));
					}
				
				@Override
				public void setParameters(double[] param)
					{
						bottom = param[0];
						top = param[1];
						logEC50 = param[2];
					}
				
				@Override
				public double[] getInitializationVector()
					{
						double[] param = new double[3];
						param[0] = data.y.min;
						param[1] = data.y.max;
						param[2] = data.x.data[getMedianYValue(0, size - 1)];
						setParameters(param);
						return param;
					}
				
				protected int getMedianYValue(int fromIndex, int toIndex)
					{
						double diff = Math.abs(data.y.max - data.y.min);
						double yMean = diff / 2;
						int index = fromIndex;
						for (int i = toIndex; i >= fromIndex; i--)
							{
								double d = Math.abs(data.y.meanData[i] - yMean);
								if (diff > d)
									{
										index = i;
										diff = d;
									}
							}
						return index;
					}
				
				public double getBottom()
					{
						return bottom;
					}
				
				public void setBottom(double bottom)
					{
						this.bottom = bottom;
					}
				
				public double getTop()
					{
						return top;
					}
				
				public void setTop(double top)
					{
						this.top = top;
					}
				
				public double getLogEC50()
					{
						return logEC50;
					}
				
				public void setLogEC50(double logEC50)
					{
						this.logEC50 = logEC50;
					}
				
				protected double	bottom;
				protected double	top;
				protected double	logEC50;
				
			}
		
		public class IFn_DoseResponceStimulation extends ChartDataSeries_Interpolation.IFn_Sigmoid
			{
				public String description(boolean showParamValues)
					{
						StringBuilder sb = new StringBuilder();
						sb.append("Stimulation dose response (four parameters)\n");
						sb.append("Y = bottom + (top-bottom)/(1+10^((logEC50-x)*HillSlope))\n");
						sb.append("where Y is the response\n");
						sb.append("      x is the log10 dose or concentration\n");
						sb.append("      bottom is the lowest value of the Y response\n");
						sb.append("      top is the plateaus of the Y response\n");
						sb.append("      logEC50 is the log10 of  half maximal effective concentration (in the same units as x)\n");
						sb.append("      HillSlope Hill slope factor (unitless)\n");
						sb.append("param[bottom,top,logEC50,HillSlope]\n");
						if (showParamValues)
							{
								sb.append("param[");
								sb.append(bottom);
								sb.append(",");
								sb.append(top);
								sb.append(",");
								sb.append(logEC50);
								sb.append(",");
								sb.append(HillSlope);
								sb.append("]\n");
							}
						return sb.toString();
					}
				
				@Override
				public double function(double[] param, double[] x)
					{
						// bottom + (top-bottom)/(1+10^((log(EC50)-x)*HillSlope))
						return param[0] + (param[1] - param[0]) / (1 + Math.pow(10, (param[2] - x[0]) * param[3]));
					}
				
				@Override
				public double value(double x)
					{
						return bottom + (top - bottom) / (1 + Math.pow(10, (logEC50 - x) * HillSlope));
					}
				
				@Override
				public void setParameters(double[] param)
					{
						bottom = param[0];
						top = param[1];
						logEC50 = param[2];
						HillSlope = param[3];
					}
				
				@Override
				public double[] getInitializationVector()
					{
						double[] param = new double[4];
						param[0] = data.y.min;
						param[1] = data.y.max;
						param[2] = data.x.data[getMedianYValue(0, size - 1)];
						param[3] = 1.0D;
						setParameters(param);
						return param;
					}
				
				public double getHillSlope()
					{
						return HillSlope;
					}
				
				public void setHillSlope(double hillSlope)
					{
						HillSlope = hillSlope;
					}
				
				protected double	HillSlope;
			}
		
		public class IFn_DoseResponceInhibition extends ChartDataSeries_Interpolation.IFn_DoseResponceStimulation
			{
				@Override
				public double function(double[] param, double[] x)
					{
						// bottom + (top-bottom)/(1+10^((log(EC50)-x)*HillSlope))
						return param[0] + (param[1] - param[0]) / (1 + Math.pow(10, (x[0] - param[2]) * param[3]));
					}
				
				@Override
				public double value(double x)
					{
						return bottom + (top - bottom) / (1 + Math.pow(10, (x - logEC50) * HillSlope));
					}
				
				public String description(boolean showParamValues)
					{
						StringBuilder sb = new StringBuilder();
						sb.append("Asymmetric stimulation dose response (Richard's five parameter curve)\n");
						sb.append("Y = bottom + (top-bottom)/(1+10^((x-logEC50)*HillSlope))\n");
						sb.append("where Y is the response\n");
						sb.append("      x is the log10 dose or concentration\n");
						sb.append("      bottom is the lowest value of the Y response\n");
						sb.append("      top is the plateaus of the Y response\n");
						sb.append("      logEC50 is the log10 of  half maximal effective concentration (in the same units as x)\n");
						sb.append("      HillSlope Hill slope factor (unitless)\n");
						sb.append("param[bottom,top,logEC50,HillSlope]\n");
						if (showParamValues)
							{
								sb.append("param[");
								sb.append(bottom);
								sb.append(",");
								sb.append(top);
								sb.append(",");
								sb.append(HillSlope);
								sb.append("]\n");
							}
						return sb.toString();
					}
				
			}
		
		public class IFn_DoseResponceAsymetric extends ChartDataSeries_Interpolation.IFn_DoseResponceStimulation
			{
				public String description(boolean showParamValues)
					{
						StringBuilder sb = new StringBuilder();
						sb.append("Asymmetric stimulation dose response (Richard's five parameter curve)\n");
						sb.append("logXb = logEC50 + (1/HillSlope)*log((2^(1/symmetry))-1)\n");
						sb.append("Y = (top-bottom)/(1+10^((LogXb-X)*HillSlope))^symmetry\n");
						sb.append("where Y is the response\n");
						sb.append("      x is the log10 dose or concentration\n");
						sb.append("      bottom is the lowest value of the Y response\n");
						sb.append("      top is the plateaus of the Y response\n");
						sb.append("      logEC50 is the log10 of  half maximal effective concentration (in the same units as x)\n");
						sb.append("      logXb is the inflexion point\n");
						sb.append("      HillSlope Hill slope factor (unitless)\n");
						sb.append("      symmetry is symmetry parameter (unitless)\n");
						sb.append("param[bottom,top,logEC50,HillSlope, symmetry]\n");
						if (showParamValues)
							{
								sb.append("param[");
								sb.append(bottom);
								sb.append(",");
								sb.append(top);
								sb.append(",");
								sb.append(HillSlope);
								sb.append(",");
								sb.append(symmetry);
								sb.append("]\n");
							}
						return sb.toString();
					}
				
				@Override
				public double function(double[] param, double[] x)
					{
						double logXb = param[2] + (1 / param[3]) * Math.log10((Math.pow(2, (1 / param[4]))) - 1);
						double numerator = param[1] - param[2];
						double denominator = Math.pow((1 + Math.pow(10, ((logXb - x[0]) * param[3]))), param[4]);
						return param[0] + (numerator / denominator);
					}
				
				@Override
				public double value(double x)
					{
						double logXb = logEC50 + (1 / HillSlope) * Math.log10((Math.pow(2, (1 / symmetry))) - 1);
						double numerator = top - bottom;
						double denominator = Math.pow((1 + Math.pow(10, ((logXb - x) * HillSlope))), symmetry);
						return bottom + (numerator / denominator);
					}
				
				@Override
				public void setParameters(double[] param)
					{
						bottom = param[0];
						top = param[1];
						logEC50 = param[2];
						HillSlope = param[3];
						symmetry = param[4];
					}
				
				@Override
				public double[] getInitializationVector()
					{
						double[] param = new double[5];
						param[0] = data.y.min;
						param[1] = data.y.max;
						param[2] = data.x.data[getMedianYValue(0, size - 1)];
						param[3] = 1.0D;
						param[4] = 1.0D;
						setParameters(param);
						return param;
					}
				
				public double getSymmetry()
					{
						return symmetry;
					}
				
				public void setSymmetry(double symmetry)
					{
						this.symmetry = symmetry;
					}
				
				protected double	symmetry;
				
			}
		
		public class IFn_Biphasic extends ChartDataSeries_Interpolation.IFn_Sigmoid
			{
				public String description(boolean showParamValues)
					{
						StringBuilder sb = new StringBuilder();
						sb.append("Biphasic inhibition dose response (six parameter curve)\n");
						sb.append("section1=(top-bottom)*fract/(1+10^((seg1LogEC50-x)*seg1HillSlope))\n");
						sb.append("section2=(top-bottom)* (1-fract)/(1+10^((seg2LogEC50-x)*seg2HillSlope))\n");
						sb.append("Y = bottom + section1 + section2\n");
						sb.append("where Y is the response\n");
						sb.append("      x is the log10 dose or concentration\n");
						sb.append("      bottom is the lowest value of the Y response\n");
						sb.append("      top is the plateaus of the Y response\n");
						sb.append("      seg1logEC50 is the log10 of  half maximal effective concentration for the first segment\n");
						sb.append("      seg2logEC50 is the log10 of  half maximal effective concentration for the second segment\n");
						sb.append("      seg1HillSlope Hill slope factor for the first segment (unitless)\n");
						sb.append("      seg2HillSlope Hill slope factor for the first segment (unitless)\n");
						sb.append("param[bottom,top,seg1logEC50,seg2logEC50,seg1HillSlope, seg2HillSlope]\n");
						if (showParamValues)
							{
								sb.append("param[");
								sb.append(bottom);
								sb.append(",");
								sb.append(top);
								sb.append(",");
								sb.append(logEC50);
								sb.append(",");
								sb.append(seg2LogEC50);
								sb.append(",");
								sb.append(seg1HillSlope);
								sb.append(",");
								sb.append(seg2HillSlope);
								sb.append("]\n");
							}
						return sb.toString();
					}
				
				@Override
				public double function(double[] param, double[] x)
					{
						// span=top-bottom
						// section1=span*frac/(1+10^((logec50_1-x)*nh1))
						// section2=span* (1-frac)/(1+10^((logec50_2-x)*nh2))
						// y=bottom + section1 +section2
						double span = param[1] - param[0];
						double segment1 = span * param[4] / (1 + Math.pow(10, (param[2] - x[0]) * param[5]));
						double segment2 = span * (1 - param[4]) / (1 + Math.pow(10, (param[3] - x[0]) * param[6]));
						return param[0] + segment1 + segment2;
					}
				
				@Override
				public double value(double x)
					{
						double span = top - bottom;
						double segment1 = span * fract / (1 + Math.pow(10, (logEC50 - x) * seg1HillSlope));
						double segment2 = span * (1 - fract) / (1 + Math.pow(10, (seg2LogEC50 - x) * seg2HillSlope));
						return bottom + segment1 + segment2;
					}
				
				@Override
				public void setParameters(double[] param)
					{
						bottom = param[0];
						top = param[1];
						logEC50 = param[2];
						seg2LogEC50 = param[3];
						fract = param[4];
						seg1HillSlope = param[5];
						seg2HillSlope = param[6];
					}
				
				@Override
				public double[] getInitializationVector()
					{
						double[] param = new double[7];
						param[0] = data.y.min;
						param[1] = data.y.max;
						double diff = Math.abs(data.y.max - data.y.min);
						double yMean = diff / 2;
						int index = 0;
						int last = 0;
						for (int i = size - 1; i >= 0; i--)
							{
								double d = Math.abs(data.y.meanData[i] - yMean);
								if (diff > d)
									{
										last = index;
										index = i;
										diff = d;
									}
							}
						param[2] = data.x.data[index];
						param[3] = data.x.data[last];
						param[4] = 0.5D;
						param[5] = 1.0D;
						param[6] = 1.0D;
						setParameters(param);
						return param;
					}
				
				protected double	seg2LogEC50;
				protected double	fract;
				protected double	seg1HillSlope;
				protected double	seg2HillSlope;
			}
		
		public class IFn_Bellshape extends ChartDataSeries_Interpolation.IFn_Sigmoid
			{
				public String description(boolean showParamValues)
					{
						StringBuilder sb = new StringBuilder();
						sb.append("Bellshape inhibition dose response (seven parameter curve)\n");
						sb.append("section1=(plateau1-dip)*fract/(1+10^((seg1LogEC50-x)*seg1HillSlope))\n");
						sb.append("section2=(plateau2-dip)* (1-fract)/(1+10^((seg2LogEC50-x)*seg2HillSlope))\n");
						sb.append("Y = bottom + section1 + section2\n");
						sb.append("where Y is the response\n");
						sb.append("      x is the log10 dose or concentration\n");
						sb.append("      dip is the lowest value of the Y response \n");
						sb.append("      plateau1 is the level of Y response befor the bell dip\n");
						sb.append("      plateau2 is the level of Y response after the bell dip\n");
						sb.append("      seg1logEC50 is the log10 of  half maximal effective concentration for the first segment\n");
						sb.append("      seg2logEC50 is the log10 of  half maximal effective concentration for the second segment\n");
						sb.append("      seg1HillSlope Hill slope factor for the first segment (unitless)\n");
						sb.append("      seg2HillSlope Hill slope factor for the first segment (unitless)\n");
						sb.append("param[dip,plateau1,plateau2,seg1logEC50,seg2logEC50,seg1HillSlope, seg2HillSlope]\n");
						if (showParamValues)
							{
								sb.append("param[");
								sb.append(bottom);
								sb.append(",");
								sb.append(top);
								sb.append(",");
								sb.append(seg2Top);
								sb.append(",");
								sb.append(logEC50);
								sb.append(",");
								sb.append(seg2LogEC50);
								sb.append(",");
								sb.append(seg1HillSlope);
								sb.append(",");
								sb.append(seg2HillSlope);
								sb.append("]\n");
							}
						return sb.toString();
					}
				
				@Override
				public double function(double[] param, double[] x)
					{
						// span1=plateau1-dip
						// span2=plateau2-dip
						// section1=span1/(1+10^((logec50_1-x)*nh1))
						// section2=span2/(1+10^((x-logec50_2)*nh2))
						// y=dip+section1+section2
						double segment1 = (param[1] - param[0]) / (1 + Math.pow(10, (param[3] - x[0]) * param[5]));
						double segment2 = (param[2] - param[0]) / (1 + Math.pow(10, (x[0] - param[4]) * param[6]));
						return param[0] + segment1 + segment2;
					}
				
				@Override
				public double value(double x)
					{
						double segment1 = (top - bottom) / (1 + Math.pow(10, (logEC50 - x) * seg1HillSlope));
						double segment2 = (seg2Top - bottom) / (1 + Math.pow(10, (x - seg2LogEC50) * seg2HillSlope));
						return bottom + segment1 + segment2;
					}
				
				@Override
				public void setParameters(double[] param)
					{
						bottom = param[0];
						top = param[1];
						seg2Top = param[2];
						logEC50 = param[3];
						seg2LogEC50 = param[4];
						seg1HillSlope = param[5];
						seg2HillSlope = param[6];
					}
				
				@Override
				public double[] getInitializationVector()
					{
						double[] param = new double[7];
						param[0] = data.y.min;
						param[1] = data.y.meanData[0];
						param[2] = data.y.meanData[size - 1];
						int index = 0;
						for (int i = size - 1; i >= 0; i--)
							if (data.y.min == data.y.meanData[i])
								{
									index = i;
									break;
								}
						param[3] = data.x.data[getMedianYValue(0, index)];
						param[4] = data.x.data[getMedianYValue(index, size - 1)];
						param[5] = 1.0D;
						param[6] = 1.0D;
						setParameters(param);
						return param;
					}
				
				protected double	seg2LogEC50;
				protected double	seg2Top;
				protected double	seg1HillSlope;
				protected double	seg2HillSlope;
			}
		
		private InterpolationFunction	iFn;
		private Regression												regression;
		private boolean															interpolated														= false;
		protected int																	xResolution															= 4;
		public final static int							IFN_CONST																	= 0;
		public final static int							IFN_SIGMOID															= 1;
		public final static int							IFN_DOSE_RESP_STIMULATION	= 2;
		public final static int							IFN_DOSE_RESP_INHIBITION		= 3;
		public final static int							IFN_DOSE_RESP_STIM_ASYM			= 4;
		public final static int							IFN_DOSE_RESP_BIPHASIC				= 5;
		public final static int							IFN_BELLSHAPE													= 6;
	}

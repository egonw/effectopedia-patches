package org.qsari.effectopedia.data.quantification;

import org.qsari.effectopedia.base.EffectopediaObject;

public class FunctionalRelationship_Threshold extends FunctionalRelationship_Analytic
	{
		
		public FunctionalRelationship_Threshold(EffectopediaObject owner)
			{
				super(owner);
			}
		
		public Double getThreshold()
			{
				return getParameter(THRESHOLD_IDX);
			}
		
		public void setThreshold(String slope)
			{
				setParameter(THRESHOLD_IDX, slope);
			}
		
		public Double getThresholdLowerRange()
			{
				return getParameterLowerRange(THRESHOLD_IDX);
			}
		
		public void setThresholdLowerRange(String slope)
			{
				setParameterLowerRange(THRESHOLD_IDX, slope);
			}
		
		public Double getThresholdUpperRange()
			{
				return getParameterUpperRange(THRESHOLD_IDX);
			}
		
		public void setThresholdUpperRange(String slope)
			{
				setParameterUpperRange(THRESHOLD_IDX, slope);
			}
		
		@Override
		protected void functionSetup()
			{
				// Set the expression of this
				// analytical function and the normal range of values
				function.setMinValue("0");
				function.setValue("50");
				function.setMaxValue("100");
				expression.setValue("if(x<=threshold,no_response_level,max_response_level)");
				// Set the function parameters
				String[][] param = new String[][]
					{
						{ "50", "40", "60", "unit", "threshold", "", "", "" },
						{ "0", "-5", "5", "unit", "no_response_level", "", "", "" },
						{ "100", "90", "110", "unit", "max_response_level", "", "", "" }, };
				parameters.assign(param);
			}
		
		@Override
		public DataSeries rebuildSeries()
			{
				DataSeries series = new DataSeries(SIZE, 0, true);
				double[] x = new double[SIZE];
				double[] y = new double[SIZE];
				double[] yL = new double[SIZE];
				double[] yU = new double[SIZE];
				x[0] = NullToNaN(getLowerApplicabilityRange());
				x[1] = NullToNaN(getParameterLowerRange(THRESHOLD_IDX));
				x[2] = NullToNaN(getParameterLowerRange(THRESHOLD_IDX));
				x[3] = NullToNaN(getParameter(THRESHOLD_IDX));
				x[4] = NullToNaN(getParameter(THRESHOLD_IDX));
				x[5] = NullToNaN(getParameterUpperRange(THRESHOLD_IDX));
				x[6] = NullToNaN(getParameterUpperRange(THRESHOLD_IDX));
				x[7] = NullToNaN(getUpperApplicabilityRange());
				for (int i = SIZE - 1; i >= 0; i--)
					{
						y[i] = (x[i] <= NullToNaN(getParameter(THRESHOLD_IDX))) ? NullToNaN(getParameter(NO_RESP_IDX)) : NullToNaN(getParameter(MAX_RESP_IDX));
						yL[i] = (x[i] <= NullToNaN(getParameterUpperRange(THRESHOLD_IDX))) ? NullToNaN(getParameterLowerRange(NO_RESP_IDX)) : NullToNaN(getParameterLowerRange(MAX_RESP_IDX));
						yU[i] = (x[i] <= NullToNaN(getParameterLowerRange(THRESHOLD_IDX))) ? NullToNaN(getParameterUpperRange(NO_RESP_IDX)) : NullToNaN(getParameterUpperRange(MAX_RESP_IDX));
					}
				yL[6] = yL[7];
				y[4] = y[5];
				yU[2] = yU[3];
				series.x.setSimpleData(x);
				series.y.setSimpleData(y);
				series.y.displayMin = yL;
				series.y.displayMax = yU;
				return series;
			}

		@Override
		public boolean isParameterListModifiable()
			{
				return false;
			}

		public static final int	SIZE									= 8;
		public static final int	THRESHOLD_IDX	= 0;
		public static final int	NO_RESP_IDX		= 1;
		public static final int	MAX_RESP_IDX	= 2;
	}

package org.qsari.effectopedia.data.quantification;

import org.qsari.effectopedia.base.EffectopediaObject;

public class FunctionalRelationship_Linear extends FunctionalRelationship_Analytic
	{
		
		public FunctionalRelationship_Linear(EffectopediaObject owner, boolean direct)
			{
				super(owner);
				setDirect(direct);
			}
		
		public boolean isDirect()
			{
				boolean direct;
				Double slope = getParameter(SLOPE_IDX);
				Double interseption = getParameter(INTERSEPTION_IDX);
				if ((slope != null) && (interseption != null))
					direct = (slope == 1.0D) && (interseption == 0.0D);
				else
					direct = false;
				return direct;
			}
		
		public void setDirect(boolean direct)
			{
				if (direct)
					{
						parameters.getValueAndUnitPair(SLOPE_IDX).setDoubleValue(1.0D);
						parameters.getValueAndUnitPair(INTERSEPTION_IDX).setDoubleValue(0.0D);
					}
			}
		
		@Override
		protected void functionSetup()
			{
				// Set the expression of this
				// analytical function and the normal range of values
				function.setMinValue("0");
				function.setValue("50");
				function.setMaxValue("100");
				expression.setValue("slope*x+interseption");
				// Set the function parameters
				String[][] param = new String[][]
					{
						{ "1", "1", "1", "unit", "slope", "", "", "" },
						{ "0", "-10", "+10", "unit", "interseption", "", "", "" } };
				parameters.assign(param);
			}
		
		public DataSeries rebuildSeries()
			{
				DataSeries series = new DataSeries(SIZE, 0, true);
				double[] x = new double[SIZE];
				double[] y = new double[SIZE];
				double[] yL = new double[SIZE];
				double[] yU = new double[SIZE];
				x[0] = NullToNaN(getLowerApplicabilityRange());
				x[1] = NullToNaN(getUpperApplicabilityRange());
				for (int i = SIZE - 1; i >= 0; i--)
					{
						y[i] = NullToNaN(getParameter(SLOPE_IDX)) * x[i] + getParameter(INTERSEPTION_IDX);
						yL[i] = NullToNaN(getParameterLowerRange(SLOPE_IDX)) * x[i] + getParameterLowerRange(INTERSEPTION_IDX);
						yU[i] = NullToNaN(getParameterUpperRange(SLOPE_IDX)) * x[i] + getParameterUpperRange(INTERSEPTION_IDX);
					}
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
		
		static
			{
				SIZE = 2;
			}
		public static final int	SLOPE_IDX								= 0;
		public static final int	INTERSEPTION_IDX	= 1;
	}

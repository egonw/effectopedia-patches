package org.qsari.effectopedia.data.quantification;

import java.math.BigDecimal;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.Descriptor;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.defaults.DefaultDataTemplates;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.utils.IExpressionEvaluator;
import org.qsari.effectopedia.utils.eval.ExpressionEvaluator;

public class FunctionalRelationship_Analytic extends FunctionalRelationship implements AnalyticFunction
	{
		public FunctionalRelationship_Analytic()
			{
				super();
			}
		
		public FunctionalRelationship_Analytic(EffectopediaObject owner)
			{
				super(owner);
				init(owner);
			}
		
		public void init(EffectopediaObject owner)
			{
				this.owner = owner;
				properties = new ObjectProperties(owner, DefaultEffectopediaObjects.DEFAULT_ANALYTIC_FUNCTION);
				function = (ObjectPropertyMultivalued_Documented) properties.getProperty(0);
				function.getValueAndUnitPair(0).createSubProperties();
				parameters = (ObjectPropertyMultivalued_Documented) function.getValueAndUnitPair(0).getSubProperties().getProperty(0);
				expression = function.getValueAndUnitPair(0).getDescriptor(DefaultEffectopediaObjects.DEFAULT_MATH_EXPRESSION);
				functionSetup();
				templates = DefaultDataTemplates.DTS_RESP_RESP_MEAN_MIN_MAX.clone();
				templates.setProperties(properties);
				templates.setOwner(owner);
			}
		
		public void cloneFieldsTo(FunctionalRelationship clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				((FunctionalRelationship_Analytic) clone).uncertaintyType = this.uncertaintyType;
			}
		
		public Double getParameter(int index)
			{
				if (parameters != null)
					return parameters.getValueAndUnitPair(index).getDoubleValue();
				else
					return null;
			}
		
		public void setParameter(int index, Double value)
			{
				if (parameters != null)
					parameters.getValueAndUnitPair(index).setDoubleValue(value);
			}
		
		public void setParameter(int index, String value)
			{
				if (parameters != null)
					parameters.getValueAndUnitPair(index).setValue(value);
			}
		
		public Double getParameterLowerRange(int index)
			{
				if (parameters != null)
					return parameters.getValueAndUnitPair(index).getMinValueAsDouble();
				else
					return null;
			}
		
		public void setParameterLowerRange(int index, Double value)
			{
				if (parameters != null)
					parameters.getValueAndUnitPair(index).setMinValueFromDouble(value);
			}
		
		public void setParameterLowerRange(int index, String value)
			{
				if (parameters != null)
					parameters.getValueAndUnitPair(index).setMinValue(value);
			}
		
		public Double getParameterUpperRange(int index)
			{
				if (parameters != null)
					return parameters.getValueAndUnitPair(index).getMaxValueAsDouble();
				else
					return null;
			}
		
		public void setParameterUpperRange(int index, Double value)
			{
				if (parameters != null)
					parameters.getValueAndUnitPair(index).setMaxValueFromDouble(value);
			}
		
		public void setParameterUpperRange(int index, String value)
			{
				if (parameters != null)
					parameters.getValueAndUnitPair(index).setMaxValue(value);
			}
		
		public Double getLowerApplicabilityRange()
			{
				if (function != null)
					return function.getValueAndUnitPair(0).getMinValueAsDouble();
				else
					return null;
			}
		
		public void setLowerApplicabilityRange(Double value)
			{
				if (parameters != null)
					function.getValueAndUnitPair(0).setMinValueFromDouble(value);
			}
		
		public void setLowerApplicabilityRange(String value)
			{
				if (parameters != null)
					function.getValueAndUnitPair(0).setMinValue(value);
			}
		
		public Double getUpperApplicabilityRange()
			{
				if (function != null)
					return function.getValueAndUnitPair(0).getMaxValueAsDouble();
				else
					return null;
			}
		
		public void setUpperApplicabilityRange(Double value)
			{
				if (parameters != null)
					function.getValueAndUnitPair(0).setMaxValueFromDouble(value);
			}
		
		public void setUpperApplicabilityRange(String value)
			{
				if (parameters != null)
					function.getValueAndUnitPair(0).setMaxValue(value);
			}
		
		public String getDescription()
			{
				return function.getNotes();
			}
		
		public void setDescription(String description)
			{
				function.setNotes(description);
			}
		
		public String getReferences()
			{
				return function.getDisplayReferences();
			}
		
		public void setReferences(String references)
			{
				function.setDisplayReferences(references);
			}
		
		public ModifiableTableModel generateTableModel()
			{
				return new AnalyticFunctionTableModel(this);
			}
		
		public String getExpression()
			{
				return this.expression.getDisplayValue();
			}
		
		public void setExpression(String expression)
			{
				this.expression.setValue(expression);
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						uncertaintyType = element.getAttributeValue("uncertainty_type");
						super.load(element, io);
						function = (ObjectPropertyMultivalued_Documented) properties.getProperty(0);
						parameters = (ObjectPropertyMultivalued_Documented) function.getValueAndUnitPair(0).getSubProperties().getProperty(0);
						expression = function.getValueAndUnitPair(0).getDescriptor(DefaultEffectopediaObjects.DEFAULT_MATH_EXPRESSION);
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.setAttribute("uncertainty_type", uncertaintyType);
				return element;
			}
		
		public String getUncertaintyType()
			{
				return uncertaintyType;
			}
		
		public void setUncertaintyType(String uncertaintyType)
			{
				this.uncertaintyType = uncertaintyType;
			}
		
		protected void functionSetup()
			{
				// Set the expression of this
				// analytical function and the normal range of values
				function.setMinValue("0");
				function.setValue("50");
				function.setMaxValue("100");
				expression.setValue("x");
				parameters.clearValuePairs();
			}
		
		public BigDecimal evaluate(BigDecimal value)
			{
				if (!evaluator.canEval())
					initEvaluators();
				evaluator.setVariable("x", value);
				return evaluator.eval();
			}
		
		public double evaluate(double value)
			{
				if (!evaluator.canEval())
					initEvaluators();
				evaluator.setVariable("x", value);
				return evaluator.eval().doubleValue();
			}
		
		public BigDecimal evaluateWithinApplicRange(BigDecimal value)
			{
				if (!evaluator.canEval())
					initEvaluators();
				if ((value.doubleValue() < getLowerApplicabilityRange()) || (value.doubleValue() > getUpperApplicabilityRange()))
					return null;
				evaluator.setVariable("x", value);
				return evaluator.eval();
			}
		
		public double evaluateWithinApplicRange(double value)
			{
				if (!evaluator.canEval())
					initEvaluators();
				if ((value < getLowerApplicabilityRange()) || (value > getUpperApplicabilityRange()))
					return Double.NaN;
				evaluator.setVariable("x", value);
				return evaluator.eval().doubleValue();
			}
		
		private void initEvaluators()
			{
				evaluator.setExpression(expression.getDisplayValue());
				evaluatorL.setExpression(expression.getDisplayValue());
				evaluatorU.setExpression(expression.getDisplayValue());
				
				for (int p = parameters.valuesCount() - 1; p >= 0; p--)
					{
						Descriptor parameterDescr = parameters.getValueAndUnitPair(p).getDescriptor(DefaultEffectopediaObjects.DEFAULT_PARAMETER_NAME);
						if (parameterDescr != null)
							{
								String variableName = parameterDescr.getDisplayValue();
								if ((variableName == null) || (variableName.length() > 0))
									{
										Double value = parameters.getValueAndUnitPair(p).getDoubleValue();
										if (value != null)
											evaluator.setVariable(variableName, value);
										value = parameters.getValueAndUnitPair(p).getMinValueAsDouble();
										if (value != null)
											evaluatorL.setVariable(variableName, value);
										value = parameters.getValueAndUnitPair(p).getMaxValueAsDouble();
										if (value != null)
											evaluatorU.setVariable(variableName, value);
									}
							}
					}
			}
		
		public DataSeries rebuildSeries()
			{
				DataSeries series = new DataSeries(SIZE, 0, true);
				double[] x = new double[SIZE];
				double[] y = new double[SIZE];
				double[] yL = new double[SIZE];
				double[] yU = new double[SIZE];
				
				try
					{
						BigDecimal fromValue = new BigDecimal(getLowerApplicabilityRange());
						BigDecimal toValue = new BigDecimal(getUpperApplicabilityRange());
						BigDecimal step = toValue.subtract(fromValue).divide(new BigDecimal(SIZE));
						
						initEvaluators();
						
						BigDecimal xi = toValue;
						for (int i = SIZE - 1; i >= 0; i--)
							{
								evaluator.setVariable("x", xi);
								evaluatorL.setVariable("x", xi);
								evaluatorU.setVariable("x", xi);
								x[i] = xi.doubleValue();
								y[i] = evaluator.eval().doubleValue();
								yL[i] = evaluatorL.eval().doubleValue();
								yU[i] = evaluatorU.eval().doubleValue();
								xi = xi.subtract(step);
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
				
				series.x.setSimpleData(x);
				series.y.setSimpleData(y);
				series.y.displayMin = yL;
				series.y.displayMax = yU;
				return series;
			}
		
		public boolean isParameterListModifiable()
			{
				return true;
			}
		
		public IExpressionEvaluator getEvaluator()
			{
				return evaluator;
			}
		
		public void setEvaluator(IExpressionEvaluator evaluator)
			{
				this.evaluator = evaluator;
			}
		
		public ObjectPropertyMultivalued_Documented getParameters()
			{
				return parameters;
			}

		
		protected String																															uncertaintyType	= "Standard deviation";
		protected ObjectPropertyMultivalued_Documented	function								= null;
		protected ObjectPropertyMultivalued_Documented	parameters						= null;
		protected Descriptor																											expression						= null;
		public static int																														SIZE												= 10;
		private IExpressionEvaluator																			evaluator							= new ExpressionEvaluator();
		private IExpressionEvaluator																			evaluatorL						= new ExpressionEvaluator();
		private IExpressionEvaluator																			evaluatorU						= new ExpressionEvaluator();
	}

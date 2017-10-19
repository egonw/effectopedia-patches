package org.qsari.effectopedia.data.quantification;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.Descriptor;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented.Documented_Value;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship.EvidenceType;
import org.qsari.effectopedia.defaults.DefaultDataTemplates;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.utils.IExpressionEvaluator;
import org.qsari.effectopedia.utils.eval.ExpressionEvaluator;

public class AggregationFunction implements Importable, Exportable, AnalyticFunction
	{
		public static enum AggregationType
			{
				UNDEFINED(0, "Undefined"), ADDITIVE(1, "additive"), SYNERGISTIC(2, "synergistic"), ANTAGONISTIC(3, "antagonistic");
				
				AggregationType(int code, String caption)
					{
						this.code = code;
						this.caption = caption;
					}
				
				public String toString()
					{
						return caption;
					}
				
				public int getCode()
					{
						return code;
					}
				
				private final int				code;
				private final String	caption;
			}
		
		public AggregationFunction()
			{
				this.owner = null;
				initFactors(null);
			}
		
		public AggregationFunction(EffectopediaObject owner)
			{
				this.owner = owner;
				initFactors(owner);
			}
		
		public boolean isInitialized()
			{
				return (factors.getFactors() != null) && (function != null) && (expression != null);
			}
		
		public AggregationFunction createState()
			{
				if (properties != null)
					return this;
				if (DefaultEffectopediaObjects.buildingDefaultObjects)
					{
						this.properties = DefaultEffectopediaObjects.DEFAULT_TIME_SERIES_DATA;
						this.templates = DefaultDataTemplates.DTS_TIME_SERIES_ALL;
					}
				else
					{
						this.properties = DefaultEffectopediaObjects.DEFAULT_TIME_SERIES_DATA.clone(owner, owner.getDataSource());
						this.templates = DefaultDataTemplates.DTS_TIME_SERIES_ALL.clone();
					}
				this.templates.setProperties(properties);
				this.templates.setOwner(owner);
				return this;
			}
		
		public AggregationFunction createResponseFunctionIfNeeded(boolean setFunctionDefaults)
			{
				if (owner instanceof PathwayElement)
					factors.setFactors(((PathwayElement) owner).incommingAssociations());
				if (factors.getCount() <= 1)
					{
						fnProperties = null;
						function = null;
						parameters = null;
						expression = null;
						return this;
					}
				if (fnProperties == null)
					{
						fnProperties = new ObjectProperties(owner, DefaultEffectopediaObjects.DEFAULT_ANALYTIC_FUNCTION);
						function = (ObjectPropertyMultivalued_Documented) fnProperties.getProperty(0);
						function.getValueAndUnitPair(0).createSubProperties();
						parameters = (ObjectPropertyMultivalued_Documented) function.getValueAndUnitPair(0).getSubProperties().getProperty(0);
						expression = function.getValueAndUnitPair(0).getDescriptor(DefaultEffectopediaObjects.DEFAULT_MATH_EXPRESSION);
					}
				if (setFunctionDefaults)
					{
						PathwayElement[] factorsArray = factors.getFactors();
						// Set the expression of this
						// aggregation function and the normal range of values
						
						if (function.getMinValue() == null)
							function.setMinValue("0");
						if (function.getValue() == null)
							function.setValue("50");
						if (function.getMaxValue() == null)
							function.setMaxValue("100");
						
						StringBuilder expr = new StringBuilder();
						// Set the function parameters
						parameters.clearValuePairs();
						for (int i = 0; i < factorsArray.length; i++)
							{
								initParameterValue(factorsArray[i], parameters.add(), i);
								addExpressionTerm(expr, i);
							}
						expression.setValue(expr.toString());
					}
				return this;
			}
		
		public void update(int lowestIndexChanged, int highestIndexChanged)
			{
				createResponseFunctionIfNeeded(true);
				if (owner instanceof Titleable)
					{
						String title = ((Titleable) owner).getTitle();
						templates.setChartTitle(title);
						templates.setyPrimaryAxisTitle(title);
					}
				/*
				int diff = parameters.valuesCount() - factors.getCount();
				
				PathwayElement[] factorsArray = factors.getFactors();
				if (diff == 0)
					for (int i = lowestIndexChanged; i <= highestIndexChanged; i++)
						initParameterValue(factorsArray[i], parameters.getValueAndUnitPair(i), i);
				else if (diff > 0) // new factors were added
					{
						StringBuilder expr = new StringBuilder();
						for (int i = 0; i < factorsArray.length; i++)
							{
								if ((i >= lowestIndexChanged) && (i <= highestIndexChanged))
									initParameterValue(factorsArray[i], parameters.insert(i), i);
								addExpressionTerm(expr, i);
							}
						expression.setValue(expr.toString());
					}
				else
					// factors have been removed
					{
						StringBuilder expr = new StringBuilder();
						for (int i = 0; i < factorsArray.length; i++)
							addExpressionTerm(expr, i);
						for (int i = 0; i < -diff; i++)
							parameters.remove(lowestIndexChanged);
						expression.setValue(expr.toString());
					}
					*/
			}
		
		protected void initParameterValue(PathwayElement element, Documented_Value dv, int index)
			{
				dv.setDoubleValue(1.0D);
				dv.setMaxValueFromDouble(1.0D);
				dv.setMinValueFromDouble(1.0D);
				dv.getDescriptor(DefaultEffectopediaObjects.DEFAULT_PARAMETER_NAME).setValue("a" + index);
				String notes;
				if (element instanceof Link)
					{
						PathwayElement[] upstreamElement = element.incommingAssociations();
						notes = ((upstreamElement != null) && (upstreamElement.length == 1) && (upstreamElement[0] != null)) ? ((Titleable) upstreamElement[0]).getTitle() : "weight of factor " + index;
					}
				else
					notes = "weight of factor " + index;
				dv.setNotes(notes);
			}
		
		private void addExpressionTerm(StringBuilder expr, int i)
			{
				if (i != 0)
					expr.append("+");
				expr.append("a");
				expr.append(i);
				expr.append("*");
				expr.append("x");
				expr.append(i);
			}
		
		protected void initFunction()
			{
				function = (ObjectPropertyMultivalued_Documented) fnProperties.getProperty(0);
				parameters = (ObjectPropertyMultivalued_Documented) function.getValueAndUnitPair(0).getSubProperties().getProperty(0);
				expression = function.getValueAndUnitPair(0).getDescriptor(DefaultEffectopediaObjects.DEFAULT_MATH_EXPRESSION);
			}
		
		protected void initFactors(EffectopediaObject owner)
			{
				if (owner instanceof PathwayElement)
					factors = new Factors<PathwayElement>(((PathwayElement) owner).incommingAssociations(), owner, owner.getDataSource());
				else
					factors = new Factors<PathwayElement>();
			}
		
		public void assignFieldsTo(AggregationFunction destination, EffectopediaObject owner, DataSource dataSource)
			{
				if (this.factors != null)
					destination.factors = this.factors.clone(owner, dataSource);
				destination.templates = this.templates.clone();
				destination.properties = this.properties.clone(owner, dataSource);
				destination.templates.setProperties(destination.properties);
				if (fnProperties != null)
					destination.fnProperties = this.fnProperties.clone(owner, dataSource);
				destination.aggregationType = this.aggregationType;
			}

		public void cloneFieldsTo(AggregationFunction clone, DataSource dataSource)
			{
				if (this.factors != null)
					clone.factors = this.factors.clone(clone.owner, dataSource);
				clone.templates = this.templates.clone();
				clone.properties = this.properties.clone(owner, dataSource);
				clone.templates.setProperties(clone.properties);
				if (fnProperties != null)
					clone.fnProperties = this.fnProperties.clone(owner, dataSource);
				clone.aggregationType = this.aggregationType;
			}
		
		public AggregationFunction clone(EffectopediaObject owner, DataSource dataSource)
			{
				AggregationFunction clone = null;
				try
					{
						clone = this.getClass().newInstance();
						clone.setOwner(owner);
						cloneFieldsTo(clone, dataSource);
					}
				catch (InstantiationException e)
					{
						e.printStackTrace();
					}
				catch (IllegalAccessException e)
					{
						e.printStackTrace();
					}
				return clone;
			}
		
		public ObjectProperties getFnProperties()
			{
				return fnProperties;
			}
		
		public void setFnProperties(ObjectProperties fnProperties)
			{
				this.fnProperties = fnProperties;
			}
		
		public ObjectProperties getProperties()
			{
				return properties;
			}
		
		public void setProperties(ObjectProperties properties)
			{
				this.properties = properties;
			}
		
		public AggregationType getAggregationType()
			{
				return aggregationType;
			}
		
		public void setAggregationType(AggregationType aggregationType)
			{
				this.aggregationType = aggregationType;
			}
		
		public DataTemplates getTemplates()
			{
				return templates;
			}
		
		public void setTemplates(DataTemplates templates)
			{
				this.templates = templates;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						BaseIOElement factorsElement = element.getChild("factors");
						if (factorsElement != null)
							{
								BaseIOAttribute aggregationType = element.getAttribute("aggregation_type");
								if (aggregationType != null)
									this.aggregationType = AggregationType.valueOf(aggregationType.getValue());
								initFactors(owner);
								factors.load(factorsElement, io);
							}
						createState();
						properties.load(element.getChild("state"), io);
						properties.setOwner(owner);
						templates.setProperties(properties);
						BaseIOElement aFn = element.getChild("aggregation_function");
						if (aFn != null)
							{
								fnProperties = new ObjectProperties(owner, DefaultEffectopediaObjects.DEFAULT_ANALYTIC_FUNCTION);
								fnProperties.load(aFn, io);
								fnProperties.setOwner(owner);
								initFunction();
							}
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				if (fnProperties != null)
					fnProperties.updateExternalID(element.getChild("aggregation_function"));
				if (properties != null)
					properties.updateExternalID(element.getChild("aggregate"));
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				if (!aggregationType.equals(EvidenceType.UNDEFINED))
					{
						BaseIOElement factorsElement = io.newElement("factors");
						factorsElement.setAttribute("aggregation_type", aggregationType.name());
						if (factors != null)
							factors.store(factorsElement, io);
						element.addChild(factorsElement);
					}
				if (fnProperties != null)
					element.addChild(fnProperties.store(io.newElement("aggregation_function"), io));
				
				if ((properties != null) && (properties.hasData()))
					{
						element.addChild(properties.store(io.newElement("state"), io));
						if (templates != null)
							element.addChild(templates.store(io.newElement("data_templates"), io));
					}
				return element;
			}
		
		public EffectopediaObject getOwner()
			{
				return owner;
			}
		
		public void setOwner(EffectopediaObject owner)
			{
				this.owner = owner;
				if (fnProperties != null)
					fnProperties.setOwner(owner);
				if (templates != null)
					templates.setOwner(owner);
			}
		
		public BigDecimal evaluate(BigDecimal[] values)
			{
				if (!evaluator.canEval())
					initEvaluators();
				for (int i = values.length - 1; i >= 0; i--)
					evaluator.setVariable("x" + i, values[i]);
				return evaluator.eval();
			}
		
		public double evaluate(double[] values)
			{
				if (!evaluator.canEval())
					initEvaluators();
				for (int i = values.length - 1; i >= 0; i--)
					evaluator.setVariable("x" + i, values[i]);
				return evaluator.eval().doubleValue();
			}
		
		public BigDecimal evaluateWithinApplicRange(BigDecimal[] values)
			{
				if (!evaluator.canEval())
					initEvaluators();
				for (int i = values.length - 1; i >= 0; i--)
					{
						double value = values[i].doubleValue();
						if ((value < getLowerApplicabilityRange()) || (value > getUpperApplicabilityRange()))
							return null;
						evaluator.setVariable("x" + i, value);
					}
				return evaluator.eval();
			}
		
		public double evaluateWithinApplicRange(double[] values)
			{
				if (!evaluator.canEval())
					initEvaluators();
				for (int i = values.length - 1; i >= 0; i--)
					{
						double value = values[i];
						if ((value < getLowerApplicabilityRange()) || (value > getUpperApplicabilityRange()))
							return Double.NaN;
						evaluator.setVariable("x" + i, value);
					}
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
		
		public boolean isConsistent(ArrayList<double[]> dataMatrix, int opt, int size)
			{
				if (opt == CONSISTENT_SIZE)
					{
						int s = dataMatrix.get(0).length;
						for (int i = dataMatrix.size() - 1; i > 0; i--)
							if (dataMatrix.get(i).length != s)
								return false;
					}
				if (opt == CONSISTENT_VALUE)
					{
						double[] values = dataMatrix.get(0);
						for (int i = dataMatrix.size() - 1; i > 0; i--)
							for (int j = values.length - 1; j >= 0; j--)
								if (dataMatrix.get(i)[j] != values[j])
									return false;
					}
				return true;
			}
		
		public void evaluate()
			{
				ArrayList<double[]> time = factors.getAllFactorDescriptorValuesAsDouble(DefaultEffectopediaObjects.DEFAULT_TIME);
				ArrayList<double[]> factorsInTime = factors.getAllFactorValuesAsDouble();
				ArrayList<double[]> minFactorsInTime = factors.getAllFactorMinValuesAsDouble();
				ArrayList<double[]> maxFactorsInTime = factors.getAllFactorMaxValuesAsDouble();
				
				if (!isConsistent(time, CONSISTENT_SIZE + CONSISTENT_VALUE, -1))
					{
						System.err.println("aggregation evaluation does not support time series interpolation.");
						return;
					}
				SIZE = time.get(0).length;
				if ((!isConsistent(factorsInTime, CONSISTENT_SIZE, SIZE)) || (!isConsistent(minFactorsInTime, CONSISTENT_SIZE, SIZE)) || (!isConsistent(maxFactorsInTime, CONSISTENT_SIZE, SIZE)))
					{
						System.err.println("All factors need to be available in the same time points (no interpolation)");
						return;
					}
				
				double[] x = time.get(0);
				double[] y = new double[SIZE];
				double[] yL = new double[SIZE];
				double[] yU = new double[SIZE];
				
				try
					{
						initEvaluators();
						
						for (int i = SIZE - 1; i >= 0; i--)
							{
								for (int j = factorsInTime.size() - 1; j >= 0; j--)
									{
										String xName = "x" + j;
										evaluator.setVariable(xName, factorsInTime.get(j)[i]);
										evaluatorL.setVariable(xName, minFactorsInTime.get(j)[i]);
										evaluatorU.setVariable(xName, maxFactorsInTime.get(j)[i]);
									}
								
								y[i] = evaluator.eval().doubleValue();
								yL[i] = evaluatorL.eval().doubleValue();
								yU[i] = evaluatorU.eval().doubleValue();
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
						return;
					}
				
				ObjectPropertyMultivalued_Documented timeaggregation = (ObjectPropertyMultivalued_Documented) properties.getProperty(0);
				timeaggregation.clearValuePairs();
				for (int i = 0; i < SIZE; i++)
					{
						Documented_Value dv = timeaggregation.add();
						dv.setDoubleValue(y[i]);
						dv.setMaxValueFromDouble(yU[i]);
						dv.setMinValueFromDouble(yL[i]);
						dv.getDescriptor(DefaultEffectopediaObjects.DEFAULT_TIME).setFromDouble(x[i]);
					}
			}
		
		public DataSeries rebuildSeries()
			{
				ArrayList<double[]> time = factors.getAllFactorDescriptorValuesAsDouble(DefaultEffectopediaObjects.DEFAULT_TIME);
				ArrayList<double[]> factorsInTime = factors.getAllFactorValuesAsDouble();
				ArrayList<double[]> minFactorsInTime = factors.getAllFactorMinValuesAsDouble();
				ArrayList<double[]> maxFactorsInTime = factors.getAllFactorMaxValuesAsDouble();
				
				if (!isConsistent(time, CONSISTENT_SIZE + CONSISTENT_VALUE, -1))
					{
						System.err.println("aggregation evaluation does not support time series interpolation.");
						return new DataSeries(0, 0, true);
					}
				SIZE = time.get(0).length;
				if ((!isConsistent(factorsInTime, CONSISTENT_SIZE, SIZE)) || (!isConsistent(minFactorsInTime, CONSISTENT_SIZE, SIZE)) || (!isConsistent(maxFactorsInTime, CONSISTENT_SIZE, SIZE)))
					{
						System.err.println("All factors need to be available in the same time points (no interpolation)");
						return new DataSeries(0, 0, true);
					}
				
				DataSeries series = new DataSeries(SIZE, 0, true);
				double[] x = time.get(0);
				double[] y = new double[SIZE];
				double[] yL = new double[SIZE];
				double[] yU = new double[SIZE];
				
				try
					{
						initEvaluators();
						
						for (int i = SIZE - 1; i >= 0; i--)
							{
								for (int j = factorsInTime.size() - 1; j >= 0; j--)
									{
										String xName = "x" + j;
										evaluator.setVariable(xName, factorsInTime.get(j)[i]);
										evaluatorL.setVariable(xName, minFactorsInTime.get(j)[i]);
										evaluatorU.setVariable(xName, maxFactorsInTime.get(j)[i]);
									}
								
								y[i] = evaluator.eval().doubleValue();
								yL[i] = evaluatorL.eval().doubleValue();
								yU[i] = evaluatorU.eval().doubleValue();
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
				if (expression == null)
					return "x";
				return this.expression.getDisplayValue();
			}
		
		public void setExpression(String expression)
			{
				this.expression.setValue(expression);
			}
		
		protected double NullToNaN(Double value)
			{
				if (value == null)
					return Double.NaN;
				else
					return value.doubleValue();
			}
		
		@Override
		public ObjectPropertyMultivalued_Documented getParameters()
			{
				return parameters;
			}
		
		@Override
		public String getUncertaintyType()
			{
				return uncertaintyType;
			}
		
		@Override
		public void setUncertaintyType(String uncertaintyType)
			{
				this.uncertaintyType = uncertaintyType;
			}
		
		public Factors<PathwayElement> getFactors()
			{
				return factors;
			}
		
		public static final AggregationType[]										AGGREGATION_TYPES	= new AggregationType[]
																																																																				{ AggregationType.UNDEFINED, AggregationType.ADDITIVE, AggregationType.SYNERGISTIC, AggregationType.ANTAGONISTIC };
		
		protected static final int																					CONSISTENT_SIZE			= 1;
		protected static final int																					CONSISTENT_VALUE		= 2;
		
		protected EffectopediaObject																			owner;
		protected Factors<PathwayElement>														factors;
		protected DataTemplates																								templates;
		protected ObjectProperties																					properties;
		protected ObjectProperties																					fnProperties;
		protected ObjectPropertyMultivalued_Documented	function										= null;
		protected ObjectPropertyMultivalued_Documented	parameters								= null;
		protected Descriptor																											expression								= null;
		protected AggregationType																						aggregationType			= AggregationType.ADDITIVE;
		
		protected String																															uncertaintyType			= "Standard deviation";
		public static int																														SIZE														= 10;
		private IExpressionEvaluator																			evaluator									= new ExpressionEvaluator();
		private IExpressionEvaluator																			evaluatorL								= new ExpressionEvaluator();
		private IExpressionEvaluator																			evaluatorU								= new ExpressionEvaluator();
		
	}

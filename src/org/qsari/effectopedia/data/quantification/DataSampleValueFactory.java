package org.qsari.effectopedia.data.quantification;

import java.util.ArrayList;
import java.util.Arrays;

import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented.Documented_Value;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public class DataSampleValueFactory
	{
		DataSampleValueFactory	FACTORY	= new DataSampleValueFactory();
		
		private DataSampleValueFactory()
			{
			}
		
		public static class DataSampleValue
			{
				public DataSampleValue()
					{
						VALUES.add(this);
					}
				
				public double get(DataSamples sample, int index, int repetitionIndex)
					{
						return sample.data[index];
					}
				
				public Double get(ObjectPropertyMultivalued_Documented op, int index, int repetitionIndex)
					{
						return op.getValueAndUnitPair(index).getDoubleValue();
					}
				
				public void set(DataSamples sample, int index, int repetitionIndex, Double value)
					{
						sample.data[index] = value;
					}
				
				public void set(ObjectPropertyMultivalued_Documented op, int index, int repetitionIndex, Double value)
					{
						op.getValueAndUnitPair(index).setDoubleValue(value);
					}
				
				public void set(DataSamples sample, int index, int repetitionIndex, ObjectPropertyMultivalued_Documented op)
					{
						sample.data[index] = op.getValueAndUnitPair(index).getValue().getAsDouble();
					}
				
				public void set(DataSamples sample, ObjectPropertyMultivalued_Documented op)
					{
						sample.data = op.getValuesAsDouble();
					}
				
				public void get(DataSamples sample, int index, int repetitionIndex, ObjectPropertyMultivalued_Documented op)
					{
						op.getValueAndUnitPair(index).getValue().setFromDouble(sample.data[index]);
					}
			}
		
		public static class DataSampleDescriptorValue extends DataSampleValue
			{
				public DataSampleDescriptorValue(DescriptorType descriptorType)
					{
						super();
						this.descriptorType = descriptorType;
					}
				
				public Double get(ObjectPropertyMultivalued_Documented op, int index, int repetitionIndex)
					{
						return op.getValueAndUnitPair(index).getDescriptor(descriptorType).getAsDouble();
					}
				
				public void set(ObjectPropertyMultivalued_Documented op, int index, int repetitionIndex, Double value)
					{
						op.getValueAndUnitPair(index).getDescriptor(descriptorType).setFromDouble(value);
					}
				
				@Override
				public void set(DataSamples sample, int index, int repetitionIndex, ObjectPropertyMultivalued_Documented op)
					{
						// TODO Assumes single descriptor (independent variable)
						sample.data[index] = op.getValueAndUnitPair(index).getDescriptor(descriptorType).getAsDouble();
					}
				
				@Override
				public void get(DataSamples sample, int index, int repetitionIndex, ObjectPropertyMultivalued_Documented op)
					{
						// TODO Assumes single descriptor (independent variable)
						op.getValueAndUnitPair(index).getDescriptor(descriptorType).setFromDouble(sample.data[index]);
					}
				
				@Override
				public void set(DataSamples sample, ObjectPropertyMultivalued_Documented op)
					{
						sample.data = op.getDescriptorValuesAsDouble(descriptorType);
					}
				
				public final DescriptorType	descriptorType;
			}
		
		public static class DataSampleRawValue extends DataSampleValue
			{
				public double get(DataSamples sample, int index, int repetitionIndex)
					{
						return sample.rawData.get(repetitionIndex)[index];
					}
				
				public Double get(ObjectPropertyMultivalued_Documented op, int index, int repetitionIndex)
					{
						// TODO Make ObjectProperties hierarchical to keep raw data
						return Double.NaN;
					}
				
				public void set(DataSamples sample, int index, int repetitionIndex, Double value)
					{
						sample.rawData.get(repetitionIndex)[index] = value;
					}
				
				public void set(DataSamples sample, int index, int repetitionIndex, ObjectPropertyMultivalued_Documented op)
					{
						// TODO Does not apply when using a single descriptor (independent
						// variable)
					}
				
				public void get(DataSamples sample, int index, int repetitionIndex, ObjectPropertyMultivalued_Documented op)
					{
						// TODO Does not apply when using a single descriptor (independent
						// variable)
					}
				
				public void set(DataSamples sample, ObjectPropertyMultivalued_Documented op)
					{
						// TODO Make ObjectProperties hierarchical to keep raw data
					}
			}
		
		public static class DataSampleMeanValue extends DataSampleValue
			{
				@Override
				public double get(DataSamples sample, int index, int repetitionIndex)
					{
						return sample.meanData[index];
					}
				
				@Override
				public void set(DataSamples sample, int index, int repetitionIndex, Double value)
					{
						sample.meanData[index] = value;
					}
			}
		
		public static class DataSampleStatErrorValue extends DataSampleDescriptorValue
			{
				public DataSampleStatErrorValue(int errorType, DescriptorType descriptorType)
					{
						super(descriptorType);
						this.errorType = errorType;
					}
				
				@Override
				public double get(DataSamples sample, int index, int repetitionIndex)
					{
						return sample.statData.get(errorType)[index];
					}
				
				@Override
				public void set(DataSamples sample, int index, int repetitionIndex, Double value)
					{
						sample.statData.get(errorType)[index] = value;
					}
				
				protected int	errorType	= DataSamples.SEM;
			}
		
		public static class DataSampleMeanMinusStatError extends DataSampleStatErrorValue
			{
				public DataSampleMeanMinusStatError(int errorType, DescriptorType descriptorType)
					{
						super(errorType, descriptorType);
					}
				
				@Override
				public Double get(ObjectPropertyMultivalued_Documented op, int index, int repetitionIndex)
					{
						Documented_Value dv = op.getValueAndUnitPair(index);
						Double value = dv.getDoubleValue();
						if (value==null)
							return null;
						Double error = dv.getDescriptor(descriptorType).getAsDouble();
						return error==null?value:value-error;
					}

				
				@Override
				public double get(DataSamples sample, int index, int repetitionIndex)
					{
						return sample.meanData[index] - sample.statData.get(errorType)[index];
					}
				
				@Override
				public void set(DataSamples sample, int index, int repetitionIndex, Double value)
					{
						sample.statData.get(errorType)[index] = sample.meanData[index] - value;
						sample.displayMin[index] = value; 
					}
				
				@Override
				public void set(DataSamples sample, ObjectPropertyMultivalued_Documented op)
					{
						double[] error = op.getDescriptorValuesAsDouble(descriptorType);
						double[] means = op.getValuesAsDouble();
						double[] displayValues = Arrays.copyOf(means, means.length);
						for (int i = displayValues.length - 1; i >= 0; i--)
							displayValues[i] -= error[i];
						sample.statData.set(errorType, error);
						sample.displayMin = displayValues;
					}
				
			}
		
		public static class DataSampleMeanPlusStatError extends DataSampleStatErrorValue
			{
				
				public DataSampleMeanPlusStatError(int errorType, DescriptorType descriptorType)
					{
						super(errorType, descriptorType);
					}

				@Override
				public Double get(ObjectPropertyMultivalued_Documented op, int index, int repetitionIndex)
					{
						Documented_Value dv = op.getValueAndUnitPair(index); 
						Double value = dv.getDoubleValue();
						if (value==null)
							return null;
						Double error = dv.getDescriptor(descriptorType).getAsDouble();
						return error==null?value:value+error;
					}
				
				@Override
				public double get(DataSamples sample, int index, int repetitionIndex)
					{
						return sample.meanData[index] + sample.statData.get(errorType)[index];
					}
				
				@Override
				public void set(DataSamples sample, int index, int repetitionIndex, Double value)
					{
						sample.statData.get(errorType)[index] = value - sample.meanData[index];
						sample.displayMax[index] = value; 
					}
				
				@Override
				public void set(DataSamples sample, ObjectPropertyMultivalued_Documented op)
					{
						double[] error = op.getDescriptorValuesAsDouble(descriptorType);
						double[] means = op.getValuesAsDouble();
						double[] displayValues = Arrays.copyOf(means, means.length);
						for (int i = displayValues.length - 1; i >= 0; i--)
							displayValues[i] += error[i];
						sample.statData.set(errorType, error);
						sample.displayMax = displayValues;
					}
				
			}
		
		public static class DataSampleLowestRepetitionValue extends DataSampleValue
			{
				@Override
				public double get(DataSamples sample, int index, int repetitionIndex)
					{
						return sample.rawDataMin[index];
					}
				
				@Override
				public Double get(ObjectPropertyMultivalued_Documented op, int index, int repetitionIndex)
					{
						return op.getValueAndUnitPair(index).getMinValueAsDouble();
					}
				
				@Override
				public void set(DataSamples sample, int index, int repetitionIndex, Double value)
					{
						sample.rawDataMin[index] = value;
						sample.displayMin[index] = value;
					}
				
				@Override
				public void set(ObjectPropertyMultivalued_Documented op, int index, int repetitionIndex, Double value)
					{
						op.getValueAndUnitPair(index).setMinValueFromDouble(value);
					}
				
				@Override
				public void set(DataSamples sample, int index, int repetitionIndex, ObjectPropertyMultivalued_Documented op)
					{
						sample.rawDataMin[index] = op.getValueAndUnitPair(index).getMinValueAsDouble();
					}
				
				@Override
				public void get(DataSamples sample, int index, int repetitionIndex, ObjectPropertyMultivalued_Documented op)
					{
						op.getValueAndUnitPair(index).setMinValueFromDouble(sample.rawDataMin[index]);
					}
				
				@Override
				public void set(DataSamples sample, ObjectPropertyMultivalued_Documented op)
					{
						sample.rawDataMin = op.getMinValuesAsDouble();
						sample.displayMin = sample.rawDataMin;
					}
				
			}
		
		public static class DataSampleHighestRepetiotionValue extends DataSampleValue
			{
				@Override
				public double get(DataSamples sample, int index, int repetitionIndex)
					{
						return sample.rawDataMax[index];
					}
				
				@Override
				public Double get(ObjectPropertyMultivalued_Documented op, int index, int repetitionIndex)
					{
						return op.getValueAndUnitPair(index).getMaxValueAsDouble();
					}
				
				@Override
				public void set(DataSamples sample, int index, int repetitionIndex, Double value)
					{
						sample.rawDataMax[index] = value;
						sample.displayMax[index] = value;
					}
				
				@Override
				public void set(ObjectPropertyMultivalued_Documented op, int index, int repetitionIndex, Double value)
					{
						op.getValueAndUnitPair(index).setMaxValueFromDouble(value);
					}
				
				@Override
				public void set(DataSamples sample, int index, int repetitionIndex, ObjectPropertyMultivalued_Documented op)
					{
						sample.rawDataMax[index] = op.getValueAndUnitPair(index).getMaxValueAsDouble();
					}
				
				@Override
				public void get(DataSamples sample, int index, int repetitionIndex, ObjectPropertyMultivalued_Documented op)
					{
						op.getValueAndUnitPair(index).setMaxValueFromDouble(sample.rawDataMax[index]);
					}
				
				@Override
				public void set(DataSamples sample, ObjectPropertyMultivalued_Documented op)
					{
						sample.rawDataMax = op.getMaxValuesAsDouble();
						sample.displayMax = sample.rawDataMax;
					}
				
			}
		
		public static final ArrayList<DataSampleValue>								VALUES											= new ArrayList<DataSampleValue>(19);
		// new factory values constants has to be added at the bottom to preserve the
		// simple indexing mechanism
		public static final DataSampleValue																			VALUE												= new DataSampleValue();
		public static final DataSampleDescriptorValue									DESCR_VALUE						= new DataSampleDescriptorValue(DefaultEffectopediaObjects.DEFAULT_LOG_MOL_CONCENTRATION);
		public static final DataSampleRawValue																RAW_VALUE								= new DataSampleRawValue();
		public static final DataSampleMeanValue															MEAN_VALUE							= new DataSampleMeanValue();
		public static final DataSampleStatErrorValue										STDEV												= new DataSampleStatErrorValue(DataSamples.STDEV, DefaultEffectopediaObjects.DEFAULT_STDEV_ERROR);
		public static final DataSampleStatErrorValue										SEM														= new DataSampleStatErrorValue(DataSamples.SEM, DefaultEffectopediaObjects.DEFAULT_SEM_ERROR);
		public static final DataSampleStatErrorValue										CI95													= new DataSampleStatErrorValue(DataSamples.CI95, DefaultEffectopediaObjects.DEFAULT_CI95_ERROR);
		public static final DataSampleMeanMinusStatError						MEAN_MINUS_STDEV	= new DataSampleMeanMinusStatError(DataSamples.STDEV, DefaultEffectopediaObjects.DEFAULT_STDEV_ERROR);
		public static final DataSampleMeanPlusStatError							MEAN_PLUS_STDEV		= new DataSampleMeanPlusStatError(DataSamples.STDEV, DefaultEffectopediaObjects.DEFAULT_STDEV_ERROR);
		public static final DataSampleMeanMinusStatError						MEAN_MINUS_SEM			= new DataSampleMeanMinusStatError(DataSamples.SEM, DefaultEffectopediaObjects.DEFAULT_SEM_ERROR);
		public static final DataSampleMeanPlusStatError							MEAN_PLUS_SEM				= new DataSampleMeanPlusStatError(DataSamples.SEM, DefaultEffectopediaObjects.DEFAULT_SEM_ERROR);
		public static final DataSampleMeanMinusStatError						MEAN_MINUS_CI95		= new DataSampleMeanMinusStatError(DataSamples.CI95, DefaultEffectopediaObjects.DEFAULT_CI95_ERROR);
		public static final DataSampleMeanPlusStatError							MEAN_PLUS_CI95			= new DataSampleMeanPlusStatError(DataSamples.CI95, DefaultEffectopediaObjects.DEFAULT_CI95_ERROR);
		public static final DataSampleLowestRepetitionValue			LOWEST_REP							= new DataSampleLowestRepetitionValue();
		public static final DataSampleHighestRepetiotionValue	HIGHEST_REP						= new DataSampleHighestRepetiotionValue();
		public static final DataSampleStatErrorValue										N																= new DataSampleStatErrorValue(DataSamples.N, DefaultEffectopediaObjects.DEFAULT_REPET_COUNT);
		public static final DataSampleDescriptorValue									UPSTREAM_CAUSE			= new DataSampleDescriptorValue(DefaultEffectopediaObjects.DEFAULT_UPSTREAM_CAUSE);
		public static final DataSampleDescriptorValue									TIME													= new DataSampleDescriptorValue(DefaultEffectopediaObjects.DEFAULT_TIME);
		public static final DataSampleDescriptorValue									NOMINAL_VALUE				= new DataSampleDescriptorValue(DefaultEffectopediaObjects.DEFAULT_LOG_MOL_NOM_CONCENTRATION);
		
		public static final int																															TIME_IDX									= DataSampleValueFactory.VALUES.indexOf(DataSampleValueFactory.TIME);
		public static final int																															DESCR_VALUE_IDX		= DataSampleValueFactory.VALUES.indexOf(DataSampleValueFactory.DESCR_VALUE);
		public static final int																															RAW_VALUE_IDX				= DataSampleValueFactory.VALUES.indexOf(DataSampleValueFactory.RAW_VALUE);
		public static final int																															MEAN_VALUE_IDX			= DataSampleValueFactory.VALUES.indexOf(DataSampleValueFactory.MEAN_VALUE);
		public static final int																															LOWEST_REP_IDX			= DataSampleValueFactory.VALUES.indexOf(DataSampleValueFactory.LOWEST_REP);
		public static final int																															HIGHEST_REP_IDX		= DataSampleValueFactory.VALUES.indexOf(DataSampleValueFactory.HIGHEST_REP);
		public static final int																															STDEV_IDX								= DataSampleValueFactory.VALUES.indexOf(DataSampleValueFactory.STDEV);
		public static final int																															SEM_IDX										= DataSampleValueFactory.VALUES.indexOf(DataSampleValueFactory.SEM);
		public static final int																															CI95_IDX									= DataSampleValueFactory.VALUES.indexOf(DataSampleValueFactory.CI95);
		public static final int																															NOM_VALUE_IDX				= DataSampleValueFactory.VALUES.indexOf(DataSampleValueFactory.NOMINAL_VALUE);
	}

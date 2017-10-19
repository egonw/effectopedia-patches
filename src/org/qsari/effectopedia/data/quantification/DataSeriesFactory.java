package org.qsari.effectopedia.data.quantification;

import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented.Documented_Value;
import org.qsari.effectopedia.data.objects.ObjectPropertyType;

public class DataSeriesFactory
	{
		public static final DataSeriesFactory	FACTORY	= new DataSeriesFactory();
		
		private DataSeriesFactory()
			{
				super();
			}
		
		public static DataSeries getDataSeriesByDescriptor(ObjectPropertyMultivalued_Documented	documentedObjectProperty,int descriptorIndex, int valueRangeFrom, int valueRangeTo)
			{
				if (documentedObjectProperty == null)
					return null;
				ObjectPropertyType type = (ObjectPropertyType) documentedObjectProperty.getType();
				if (descriptorIndex <= type.getDescriptorsCount())
					{
						if (valueRangeFrom == -1)
							valueRangeFrom = 0;
						if (valueRangeTo == -1)
							valueRangeTo = documentedObjectProperty.valuesCount();
						int count = valueRangeTo - valueRangeFrom;
						if (count == 0)
							return null;
						DataSeries dataSeries = new DataSeries(count, 0, true);
						double[] descr = new double[count];
						double[] value = new double[count];
						double[] minVal = new double[count];
						double[] maxVal = new double[count];
						for (int i = valueRangeFrom; i < valueRangeTo; i++)
							{
								Documented_Value dv = documentedObjectProperty.getValueAndUnitPair(i);
								int index = i - valueRangeFrom;
								descr[index] = dv.getDescriptor(descriptorIndex).getValue().getAsDouble();
								value[index] = dv.getValue().getAsDouble();
								minVal[index] = dv.getMinValue().getAsDouble();
								maxVal[index] = dv.getMaxValue().getAsDouble();
							}
						dataSeries.x.setSimpleData(descr);
						dataSeries.y.setSimpleData(value);
						dataSeries.y.rawDataMin = minVal;
						dataSeries.y.rawDataMax = maxVal;
						dataSeries.updateRanges();
						return dataSeries;
					}
				else
					return null;
			}
		
	}

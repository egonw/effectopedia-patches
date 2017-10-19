package org.qsari.effectopedia.data.quantification;

import java.util.ArrayList;
import java.util.Arrays;

public class DataSamples
	{
		public DataSamples(int size)
			{
				this.size = size;
				rawData = new ArrayList<double[]>();
				statData = new ArrayList<double[]>(NUM_STAT_MEASURES);
				initStatData();
			}
		
		public DataSamples(int size, int repetitions)
			{
				this.size = size;
				this.repetitions = repetitions;
				rawData = new ArrayList<double[]>(repetitions);
				statData = new ArrayList<double[]>(NUM_STAT_MEASURES);
				initStatData();
			}
		
		public void assign(DataSamples dataSamples)
			{
				if (dataSamples.size == size)
					{
						data = Arrays.copyOf(dataSamples.data, size);
						repetitions = dataSamples.repetitions;
						if (repetitions == 0)
							{
								meanData = Arrays.copyOf(data, size);
								rawDataMin = Arrays.copyOf(data, size);
								rawDataMax = Arrays.copyOf(data, size);
								displayMin = rawDataMin;
								displayMax = rawDataMax;
								statData.clear();
								for (double[] sData : dataSamples.statData)
									this.statData.add(Arrays.copyOf(sData, size));
							}
						else
							{
								for (int run = dataSamples.rawData.size() - 1; run > 0; run--)
									rawData.set(run, Arrays.copyOf(dataSamples.rawData.get(run), size));
								meanData = Arrays.copyOf(dataSamples.meanData, size);
								rawDataMin = Arrays.copyOf(dataSamples.rawDataMin, size);
								rawDataMax = Arrays.copyOf(dataSamples.rawDataMax, size);
								displayMin = Arrays.copyOf(dataSamples.displayMin, size);
								displayMax = Arrays.copyOf(dataSamples.displayMax, size);
								statData.clear();
								for (double[] sData : dataSamples.statData)
									this.statData.add(Arrays.copyOf(sData, size));
							}
						min = dataSamples.min;
						max = dataSamples.max;
						rangeMin = dataSamples.rangeMin;
						rangeMax = dataSamples.rangeMax;
					}
			}
		
		protected void estimate()
			{
				if (repetitions == 0)
					{
						setSimpleData(data);
						return;
					}
				int[] counts = new int[size];
				Arrays.fill(counts, 0);
				meanData = newConstArray(0.0D);
				rawDataMin = newConstArray(0.0D);
				rawDataMax = newConstArray(0.0D);
				displayMin = rawDataMin;
				displayMax = rawDataMax;
				for (int i = statData.size()-1; i >= 0; i--)
					statData.set(i, newConstArray(0.0D));
				for (int run = rawData.size() - 1; run > 0; run--)
					{
						for (int i = 0; i < size; i++)
							{
								double value = rawData.get(run)[i];
								if (!Double.isNaN(value))
									{
										meanData[i] += value;
										if (counts[i] == 0)
											{
												rawDataMin[i] = value;
												rawDataMax[i] = value;
											}
										else
											{
												if (rawDataMin[i] > value)
													rawDataMin[i] = value;
												if (rawDataMax[i] < value)
													rawDataMax[i] = value;
											}
										counts[i]++;
									}
							}
					}
				for (int i = 0; i < size; i++)
					{
						if (counts[i] != 0)
							meanData[i] = meanData[i] / counts[i];
						double sum = 0;
						for (int run = rawData.size() - 1; run > 0; run--)
							{
								double value = rawData.get(run)[i];
								if (!Double.isNaN(value))
									{
										double s = (value - meanData[i]);
										sum += s * s;
									}
							}
						if (counts[i] != 0)
							{
								double stDev = (double) Math.pow(sum / counts[i], 0.5);
								double stErrMean = sum / counts[i];
								statData.get(STDEV)[i] = stDev;
								statData.get(SEM)[i] = stErrMean;
								statData.get(CI95)[i] = stErrMean * CI95Coef;
							}
					}
			}
		
		protected void updateRanges()
			{
				if (size <= 0)
					return;
				int yTemp = 0;
				min = meanData[0];
				while ((Double.isNaN(min) && (yTemp < size - 1)))
					min = meanData[++yTemp];
				if (yTemp < size)
					{
						max = min;
						for (int i = yTemp; i < size; i++)
							{
								double yValue = meanData[i];
								if (!Double.isNaN(yValue))
									{
										if (yValue < min)
											min = yValue;
										if (yValue > max)
											max = yValue;
									}
							}
					}
				else
					{
						min = DEAFULT_MIN;
						max = DEAFULT_MAX;
					}
				if (repetitions == 0)
					{
						rangeMin = min;
						rangeMax = max;
						return;
					}
				yTemp = 0;
				rangeMin = rawDataMin[0];
				while ((Double.isNaN(rangeMin) && (yTemp < size - 1)))
					min = rawDataMin[++yTemp];
				if (yTemp < size)
					for (int i = yTemp; i < size; i++)
						{
							double yValue = rawDataMin[i];
							if (!Double.isNaN(yValue) && (yValue < rangeMin))
								rangeMin = yValue;
						}
				else
					rangeMin = DEAFULT_MIN;
				
				yTemp = 0;
				rangeMax = rawDataMax[0];
				while ((Double.isNaN(rangeMax) && (yTemp < size - 1)))
					max = rawDataMax[++yTemp];
				if (yTemp < size)
					for (int i = yTemp; i < size; i++)
						{
							double yValue = rawDataMax[i];
							if (!Double.isNaN(yValue) && (yValue > rangeMax))
								rangeMax = yValue;
						}
				else
					rangeMax = DEAFULT_MAX;
			}
		
		public double[] newConstArray(double constValue)
			{
				double[] result = new double[size];
				Arrays.fill(result, constValue);
				return result;
			}
		
		public int count(boolean includeRawData)
			{
				if (repetitions == 0)
					return 1;
				else
					return 3 + (includeRawData ? repetitions : 0);
			}
		
		public void setSimpleData(double[] data)
			{
				if (data.length == size)
					{
						this.data = data;
						this.meanData = Arrays.copyOf(data, size);
						this.rawDataMin = Arrays.copyOf(data, size);
						this.rawDataMax = Arrays.copyOf(data, size);
						this.displayMin = Arrays.copyOf(data, size);
						this.displayMax = Arrays.copyOf(data, size);
						statData.clear();
						for (int i = NUM_STAT_MEASURES-1; i >= 0; i--)
							statData.add(newConstArray(Double.NaN));
						rawData.add(data);
					}
			}
		
		private void initStatData()
			{
				for (int i = NUM_STAT_MEASURES-1; i >= 0; i--)
					statData.add(newConstArray(Double.NaN));
			}
		
		public int																	repetitions							= 0;
		public ArrayList<double[]>	rawData;
		public double[]												rawDataMin;
		public double[]												rawDataMax;

		
		public double[]												data;
		public double[]												meanData;
		public ArrayList<double[]>	statData;
		public double[]												displayMin;
		public double[]												displayMax;
		
		public double														min;
		public double														max;
		public double														rangeMin;
		public double														rangeMax;
		public final int											size;
		
		public static final double	DEAFULT_MIN							= 0D;
		public static final double	DEAFULT_MAX							= 100D;
		public static final int				STDEV													= 0;			// Standard deviation
		public static final int				SEM															= 1;			// Standard error
		public static final int				CI95														= 2;			// Confidence interval
		public static final int				N																	= 3;			// Number of replicates
		public static final double	CI95Coef										= 1.96; // Normal distribution
		public static final int				NUM_STAT_MEASURES	= 4;
	}

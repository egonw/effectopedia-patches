package org.qsari.effectopedia.data.quantification;

import java.util.Arrays;

public class DataSeries
	{
		public DataSeries(int dataPointsCount, int repetitions, boolean fixedX)
			{
				this.size = dataPointsCount;
				x = new DataSamples(dataPointsCount, fixedX ? 0 : repetitions);
				y = new DataSamples(dataPointsCount, repetitions);
			}
		
		public DataSeries clone()
			{
				DataSeries clone = new DataSeries(size, y.repetitions, y.repetitions == 0);
				clone.x.assign(this.x);
				clone.y.assign(this.y);
				return clone;
			}
		
		public void init(Double constValue)
			{
				double[] data = new double[size];
				if (constValue!=null)
				Arrays.fill(data, constValue);
				x.setSimpleData(data);
				y.setSimpleData(Arrays.copyOf(data, size));
			}
		
		protected void estimate()
			{
				x.estimate();
				y.estimate();
			}
		
		public void updateRanges()
			{
				x.updateRanges();
				y.updateRanges();
			}
		
		public double[] newLinearRandomArray(double scale, boolean monotonic_inc)
			{
				double[] result = new double[size];
				if (monotonic_inc)
					{
						result[0] = 0.0f;
						for (int i = 1; i < size; i++)
							result[i] = i + (double) (scale * (4 * Math.random() + i));
					}
				else
					{
						result[0] = size * scale;
						for (int i = 1; i < size; i++)
							result[i] = (double) (scale * (4 * Math.random() + (size - i)) - i);
					}
				return result;
			}
		
		public double[] newSigmuidalRandomArray(double deviation, double scale, boolean stimulation)
			{
				double bottom = 0.0f;
				double top = scale * (95d + (double) (5d * Math.random()));
				double HillSlope = (double) (2 * Math.random()) + 0.1d;
				double logEC50 = (double) ((size + (0.5f - Math.random())) / 2);
				double[] result = new double[size];
				if (stimulation)
					for (int i = 0; i < size; i++)
						result[i] = (double) (bottom + deviation * Math.random() + (top - bottom) / (1 + Math.pow(10, (i - logEC50) * HillSlope)));
				else
					for (int i = 0; i < size; i++)
						result[i] = (double) (bottom + deviation * Math.random() + (top - bottom) / (1 + Math.pow(10, (logEC50 - i) * HillSlope)));
				return result;
			}
		
		public double[] newConstArray(double constValue)
			{
				double[] result = new double[size];
				Arrays.fill(result, constValue);
				return result;
			}
		
		public void GenerateRandomData()
			{
				x.data = newLinearRandomArray(0.1D, true);
				boolean monotonic_inc = false;
				double scale = Math.random() > 0.5 ? 1D : 2D;
				for (int i = 0; i < 5; i++)
					y.rawData.add(newSigmuidalRandomArray(4.0D, scale, monotonic_inc));
				estimate();
				updateRanges();
			}
		
		public double[][] getYRawData()
			{
				double[][] result = new double[y.repetitions][size];
				return y.rawData.toArray(result);
			}
		
		public double[][] getXRawData()
			{
				int cnt = y.repetitions;
				double[][] result = new double[cnt][size];
				for (int i = cnt - 1; i >= 0; i--)
					result[i] = Arrays.copyOf(x.data, size);
				return result;
			}
		
		public final int			size;
		public DataSamples	x;
		public DataSamples	y;
	}

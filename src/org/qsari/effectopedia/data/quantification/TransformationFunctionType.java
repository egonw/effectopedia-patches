package org.qsari.effectopedia.data.quantification;

public enum TransformationFunctionType
	{
		// Do not transform data
		NONE(-1, "No trashformation", new int[0]),
		// Transform time
		TIME(0, "Time", new int[]
			{ DataSampleValueFactory.TIME_IDX }),
		// Transform Treatement level (chemical concentration)
		TREATEMENT(1, "Treatement", new int[]
			{ DataSampleValueFactory.DESCR_VALUE_IDX }),
		// Transform Response level (mean value, raw value, min value, max value)
		RESPONSE(2, "Response", new int[]
			{ DataSampleValueFactory.MEAN_VALUE_IDX, DataSampleValueFactory.RAW_VALUE_IDX, DataSampleValueFactory.LOWEST_REP_IDX, DataSampleValueFactory.HIGHEST_REP_IDX }),
		// Transform Statistical errors (stdev,sem,ci95)
		STATISICAL_ERRORS(3, "Statistical Errors", new int[]
			{ DataSampleValueFactory.STDEV_IDX, DataSampleValueFactory.SEM_IDX, DataSampleValueFactory.CI95_IDX });
		
		TransformationFunctionType(int code, String caption, int[] valueFactoryIDs)
			{
				this.code = code;
				this.caption = caption;
				this.valueFactoryIDs = valueFactoryIDs;
			}
		
		public String toString()
			{
				return caption;
			}
		
		public int getCode()
			{
				return code;
			}
		
		public int[] getValueFactoryIDs()
			{
				return valueFactoryIDs;
			}
		
		private final int				code;
		private final String	caption;
		private final int[]		valueFactoryIDs;
		public static final TransformationFunctionType[] TYPES = new TransformationFunctionType[]{TREATEMENT,RESPONSE,STATISICAL_ERRORS,TIME}; 
	}

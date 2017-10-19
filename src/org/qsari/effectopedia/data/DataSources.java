package org.qsari.effectopedia.data;

import java.util.ArrayList;

public class DataSources extends ArrayList<DataSource> implements DataSourceItem
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		/**
	 * 
	 */
		
		public String toString()
			{
				return "All";
			}
		
		public DataSource getLast()
			{
				if (size() > 0)
					return get(size() - 1);
				else
					return null;
			}
		
	}

package org.qsari.effectopedia.data.objects;

public class Interval<V> 
	{
		Interval()
			{
				super();
			}
	
		Interval(V lowerBoundary, V upperBoundary)
			{
				super();
				this.lowerBoundary = lowerBoundary;
				this.upperBoundary = upperBoundary;
			}
		
		Interval(V lowerBoundary, boolean inclusiveLowerBoundary, V upperBoundary, boolean inclusiveUpperBoundary)
			{
				super();
				this.lowerBoundary = lowerBoundary;
				this.inclusiveLowerBoundary = inclusiveLowerBoundary;
				this.upperBoundary = upperBoundary;
				this.inclusiveUpperBoundary = inclusiveUpperBoundary;
			}
		
		public boolean	inclusiveLowerBoundary	= true;
		public boolean	inclusiveUpperBoundary	= true;
		public V							lowerBoundary;
		public V							upperBoundary;
	}

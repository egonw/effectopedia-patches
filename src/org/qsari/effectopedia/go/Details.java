package org.qsari.effectopedia.go;

public enum Details
{
	NO(3, 0), // no details are visible at zoom focus level 3 or below
	LOW(7, 1), // low details are visible at zoom focus level 7 or below
	MEDIUM(15, 2), // medium details are visible at zoom focus level 15 or below
	HIGH(31, 3), // high details are visible at zoom focus level 31 or below
	ALL(128, 4); // all details are visible at zoom focus level 128 or below
	
	Details(int detailsLevel, int factor)
		{
			this.detailsLevel = detailsLevel;
			this.factor = factor;
		}
	
	public int getFactor()
		{
			return this.factor;
		}

	public boolean isVisible(int atDetailsLevel)
		{
			return atDetailsLevel <= detailsLevel;
		}
	
	public int visibleAtDetailsLevel()
		{
			return detailsLevel;
		}
	
	public static Details visibleDetails(int atDetailsLevel)
		{
			if (MEDIUM.isVisible(atDetailsLevel))
				{
					if (LOW.isVisible(atDetailsLevel))
						{
							if (NO.isVisible(atDetailsLevel))
								{
									return NO;
								}
							else
								{
									return LOW;
								}
						}
					else
						{
							return MEDIUM;
						}
				}
			else
				{
					if (HIGH.isVisible(atDetailsLevel))
						{
							return HIGH;
						}
					else
						{
							return ALL;
						}
				}
		}
	
	public static Details getDetailsByFactor(int atFactor)
		{
			if (atFactor < values().length)
				return values()[atFactor];
			else if (atFactor < 0)
				return NO;
			else
				return ALL;
		}
	
	public static int valuesCount()
		{
			return values().length;
		}
	
	private final int	detailsLevel;
	private final int	factor;
};

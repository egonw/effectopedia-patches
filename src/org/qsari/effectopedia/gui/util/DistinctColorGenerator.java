package org.qsari.effectopedia.gui.util;

import java.awt.Color;
import java.util.ArrayList;

public class DistinctColorGenerator
	{
		private DistinctColorGenerator()
			{
			}
		
		public static final ArrayList<Color> generateColorsNoRed(int count)
			{
				colors.clear();
				if (count > 0)
					{
						double step = 200 / count;
						double hue = 80.0D;
						for (int cnt = count - 1; cnt >= 0; cnt--)
							{
								hue += step;
								int saturation = 70 + (cnt % 3) * 10;
								int brightness = 50 + (cnt % 2) * 40;
								colors.add(Color.getHSBColor((int) hue, saturation, brightness));
							}
					}
				return colors;
			}
		
		public static final ArrayList<Color>	colors	= new ArrayList<Color>();
		
	}

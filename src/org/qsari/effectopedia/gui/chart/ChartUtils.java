package org.qsari.effectopedia.gui.chart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

public class ChartUtils
	{
		public static class Offset
			{
				public Offset(int horizontalOffset, int verticalOffset)
					{
						this.horizontal = horizontalOffset;
						this.vertical = verticalOffset;
					}
				
				public int																	horizontal;
				public int																	vertical;
				
				public static final Offset	ZERO															= new Offset(0, 0);
				public static final Offset	LEFT_AXIS										= new Offset(0, 0);
				public static final Offset	LEFT_AXIS_LABELS			= new Offset(-6, 4);
				public static final Offset	LEFT_AXIS_TITLE				= new Offset(16, 0);
				public static final Offset	RIGHT_AXIS									= new Offset(0, 0);
				public static final Offset	RIGHT_AXIS_LABELS		= new Offset(24, 4);
				public static final Offset	RIGHT_AXIS_TITLE			= new Offset(8, 0);
				public static final Offset	TOP_AXIS											= new Offset(0, 0);
				public static final Offset	TOP_AXIS_LABELS				= new Offset(0, 0);
				public static final Offset	BOTTOM_AXIS								= new Offset(0, -16);
				public static final Offset	BOTTOM_AXIS_LABELS	= new Offset(-8, 16);
				public static final Offset	BOTTOM_AXIS_TITLE		= new Offset(0, 12);
				public static final Offset	GRID															= new Offset(-16, 16);
			}
		
		public final static int			defaultAxisSize											= 32;
		public final static int			defaultFontHeight									= 16;
		public final static int			defaultMarkerSize									= 8;
		
		final static float								dash[]																				=
																																																							{ 4.0f };
		final static float								dot[]																					=
																																																							{ 1.0f, 1.0f };
		public static Color							chartBackground											= Color.white;
		public static Color							chartAxisColor												= new java.awt.Color(96, 96, 96);
		public static Color							chartAxisTickColor								= new java.awt.Color(200, 200, 200);
		public static Color							chartAxisLabelColor							= chartAxisColor;
		public static Color							chartGridLineColor								= new java.awt.Color(230, 230, 230);
		public static Color							chartGridStripeColor						= new java.awt.Color(253, 253, 253);
		public static Font								chartAxisLabelFont								= new Font("Arial", Font.PLAIN, 12);
		public static Color							chartTitleColor											= new java.awt.Color(128, 128, 128);
		public static Font								chartTitlesFont											= new Font("Arial", Font.PLAIN, 12);
		public static Color							chartSeriesOrangeColor				= new java.awt.Color(248, 196, 96);
		public static Color							chartSeriesRedColor							= new java.awt.Color(248, 96, 96);
		public static Color							chartSeriesGreenColor					= new java.awt.Color(96, 248, 196);
		public static Color							chartSeriesBlueColor						= new java.awt.Color(96, 196, 248);
		public static Color							chartSeriesPurpleColor				= new java.awt.Color(196, 96, 196);
		public static Color							chartSeriesDarkGreenColor	= new java.awt.Color(96, 196, 96);
		public static Color							chartSeriesGrayColor						= new java.awt.Color(96, 96, 96);
		public static Color							chartSeriesErrorBarColor		= new java.awt.Color(128, 128, 128);
		public static Color							chartSeriesErrorAreaColor	= new java.awt.Color(96f / 255, 196f / 255, 248f / 255, .2f);
		
		public static BasicStroke	chartAxis																	= new BasicStroke(1.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		public static BasicStroke	chartLine																	= new BasicStroke(1.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		public static BasicStroke	chartGrid																	= new BasicStroke(1.0F, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);
		public static BasicStroke	chartStripe															= new BasicStroke(1.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		public static BasicStroke	chartDataSeries											= new BasicStroke(1.5F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		public static BasicStroke	chartInterpolation								= chartDataSeries;
		
		public static float							DEAFULT_MIN															= 0.0f;
		public static float							DEAFULT_MAX															= 100.0f;
		
	}

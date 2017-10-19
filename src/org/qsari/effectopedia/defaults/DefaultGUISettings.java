package org.qsari.effectopedia.defaults;

import java.awt.Color;

public class DefaultGUISettings
	{
		private static final DefaultGUISettings	INSTANCE	= new DefaultGUISettings();
		
		private DefaultGUISettings()
			{
				
			}
		
		public DefaultGUISettings getGOOptions()
			{
				return INSTANCE;
			}
		
		public static Color	mergeAbsentColor				= new java.awt.Color(242, 242, 242);
		public static Color	mergeEcessColor					= new java.awt.Color(250, 191, 143);
		public static Color	mergeDifferentColor	= new java.awt.Color(253, 233, 217);
		
		public static Color	formColor	= new java.awt.Color(238, 238, 238);
		
		public static Color	uiSelectedColor					= new java.awt.Color(200, 221, 242);
	}

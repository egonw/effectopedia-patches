package org.qsari.effectopedia.gui.util;

import java.awt.Color;

import org.qsari.effectopedia.utils.HexCharByteConverter;

public class HexColorConverter
	{
		public static String colorToHex(Color color)
			{
				byte[] colorARGB = new byte[4];
				colorARGB[0] = (byte) color.getAlpha();
				colorARGB[1] = (byte) color.getRed();
				colorARGB[2] = (byte) color.getGreen();
				colorARGB[3] = (byte) color.getBlue();
				char[] hexColor = HexCharByteConverter.convert(colorARGB);
				return String.copyValueOf(hexColor);
			}
		
		public static Color hexToColor(String hexARGB)
			{
				if (hexARGB.startsWith("#"))
					hexARGB = hexARGB.substring(1);
				if (hexARGB.startsWith("0x"))
					hexARGB = hexARGB.substring(2);
				if (hexARGB.length() == 6)
					hexARGB = "FF" + hexARGB;
				
				Color color = new Color(Integer.valueOf(hexARGB.substring(2, 4), 16), Integer.valueOf(hexARGB.substring(4, 6), 16), Integer.valueOf(
						hexARGB.substring(6), 16),Integer.valueOf(hexARGB.substring(0, 2), 16));
				return color;
			}
	}

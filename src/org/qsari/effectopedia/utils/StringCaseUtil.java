package org.qsari.effectopedia.utils;

public class StringCaseUtil
	{
		public static String SentenceCase(String text)
			{
				StringBuffer sb = new StringBuffer();
				text = text.trim();
				sb.append(Character.toUpperCase(text.charAt(0)));
				sb.append(text.substring(1));
				return sb.toString().trim();
			}
		
		public static String TitleCase(String text)
			{
				String[] arr = text.split(" ");
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < arr.length; i++)
					{
						sb.append(Character.toUpperCase(arr[i].charAt(0)));
						sb.append(arr[i].substring(1));
						sb.append(" ");
					}
				return sb.toString().trim();
			}
		
	}

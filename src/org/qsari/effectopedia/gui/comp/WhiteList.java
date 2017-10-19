package org.qsari.effectopedia.gui.comp;

import java.util.HashSet;

public class WhiteList
	{
		public static final HashSet<String> LIST = new HashSet<String>(); 
		
  public static boolean isWhiteListed(String url)
  	{
  		if (url==null)
  			return false;
  		if (url.indexOf("<")>=0)
  			return false;
  		url = url.toLowerCase();
  		for (String domain : LIST)
  			if (url.indexOf(domain)>=0)
  				return true;
  		return false;
  	}
		
		static 
		{
			LIST.add("https://www.effectopedia.org/");
			LIST.add("https://app.effectopedia.org/");
			LIST.add("https://en.m.wikipedia.org/wiki/");
			LIST.add("https://aopkb.org/aopwiki/");
		}
		
	}

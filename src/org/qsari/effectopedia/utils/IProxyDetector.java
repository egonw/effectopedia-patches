package org.qsari.effectopedia.utils;

import java.net.Proxy;

public interface IProxyDetector
	{
		public void detect();
		
		public boolean isOnline();
		
		public void setProxy(boolean useProxy, String proxyHost, String proxyPort);
		
		public java.util.List<Proxy> getListOfProxies();
		
		public String toString();
		
	}

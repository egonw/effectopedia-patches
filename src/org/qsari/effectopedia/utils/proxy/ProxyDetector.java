package org.qsari.effectopedia.utils.proxy;

import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

import org.qsari.effectopedia.defaults.DefaultServerSettings;
import org.qsari.effectopedia.utils.IProxyDetector;

import com.btr.proxy.search.ProxySearch;

public class ProxyDetector implements IProxyDetector
	{
		public ProxyDetector()
			{
				detect();
			}
		
		@Override
		public void detect()
			{
				online = DefaultServerSettings.isOnline();
				if (!online)
					{
						ProxySearch proxySearch = ProxySearch.getDefaultProxySearch();
						proxySelector = proxySearch.getProxySelector();
						if (proxySelector != null)
							{
								ProxySelector.setDefault(proxySelector);
								initProxy();
								Authenticator.setDefault(new ProxyAuthenticator());
							}
					}
			}
		
		static public String getSystemProxySettings()
			{
				StringBuilder sb = new StringBuilder();
				sb.append(System.getProperties().getProperty("proxyHost"));
				sb.append(":");
				sb.append(System.getProperties().getProperty("proxyPort"));
				return sb.toString();
			}
		
		public void setProxy(boolean useProxy, String proxyHost, String proxyPort)
			{
				System.getProperties().put("proxySet", String.valueOf(useProxy));
				System.getProperties().put("proxyHost", proxyHost);
				System.getProperties().put("proxyPort", proxyPort);
			}
		
		public String toString()
			{
				if (defaultProxy != null)
					return defaultProxy.toString();
				else if (online)
					return "DIRECT Connection";
				else
					return "offline";
			}
		
		/*
		 * //First we get a JavaScript engine ScriptEngineManager manager = new
		 * ScriptEngineManager(); ScriptEngine engine =
		 * manager.getEngineByName("JavaScript");
		 * 
		 * //Create a Java binding to be used from the JavaScript execution
		 * engine.put("MyJavaPacImpl", new PACScriptMethods());
		 * 
		 * //Add the required JavaScript methods by bridging to the Java binding
		 * for(Method method : PACScriptMethods.class.getMethods()) { String
		 * bridgeFunctionDef = defineBridgeFunction( method.getName(),
		 * method.getParameterTypes().length); engine.eval(bridgeFunctionDef); }
		 * 
		 * //The engine is now ready to be used to evaluate the PAC script //(passed
		 * in as a string) engine.eval(pacScript); //Now let's use the FindProxyForURL
		 * function to get the proxy //for the URL we want to access Invocable
		 * invocableEngine = (Invocable) engine; Object resultObj =
		 * invocableEngine.invokeFunction( "FindProxyForURL", url.toString(),
		 * url.getHost()); String proxyConfig = String.valueOf(resultObj);
		 */
		
		private void initProxy()
			{
				try
					{
						List<Proxy> proxies = proxySelector.select(new URI("http://effectopedia.org/"));
						Iterator<Proxy> it = proxies.iterator();
						if (it.hasNext())
							{
								defaultProxy = (Proxy) it.next();
								if (defaultProxy.type() != Type.DIRECT)
									{
										System.setProperty("java.net.useSystemProxies", "true");
										System.getProperties().put("proxySet", true);
										InetSocketAddress addr = (InetSocketAddress) defaultProxy.address();
										if (addr != null)
											{
												System.getProperties().put("proxyHost", addr.getHostName());
												System.getProperties().put("proxyPort", String.valueOf(addr.getPort()));
											}
									}
							}
					}
				catch (URISyntaxException e)
					{
						defaultProxy = null;
						e.printStackTrace();
					}
			}
		
		public java.util.List<Proxy> getListOfProxies()
			{
				System.setProperty("java.net.useSystemProxies", "true");
				try
					{
						List<Proxy> proxies = proxySelector.select(new URI("http://effectopedia.org/"));
						for (Iterator<Proxy> it = proxies.iterator(); it.hasNext();)
							{
								Proxy proxy = (Proxy) it.next();
								System.out.println("Proxy type : " + proxy.type());
								InetSocketAddress addr = (InetSocketAddress) proxy.address();
								if (addr == null)
									System.out.println("Proxy is not in use");
								else
									{
										System.out.println("Proxy hostname : " + addr.getHostName());
										System.out.println("Proxy port : " + addr.getPort());
									}
							}
						return proxies;
					}
				catch (URISyntaxException e)
					{
						e.printStackTrace();
						return null;
					}
			}
		
		public class ProxyAuthenticator extends Authenticator
			{
				@Override
				protected PasswordAuthentication getPasswordAuthentication()
					{
						if (getRequestorType() == RequestorType.PROXY)
							{
								return new PasswordAuthentication("proxy-user", "proxy-password".toCharArray());
							}
						else
							{
								return super.getPasswordAuthentication();
							}
					}
			}
		
		public boolean isOnline()
			{
				return online;
			}
		
		protected ProxySelector	proxySelector;
		protected Proxy									defaultProxy;
		protected boolean							online;
	}

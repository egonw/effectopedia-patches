package org.qsari.effectopedia.system;

import java.util.Locale;

import org.qsari.effectopedia.utils.IProxyDetector;

public class Configuration
	{
		public final Configuration	CURRENT	= new Configuration();
		
		private Configuration()
			{
				
			}
		
		public static IProxyDetector	proxy;
		
		public static void displayProxySettings()
			{
				if (proxy != null)
					System.out.println(proxy);
			}
		
		public final static boolean isMacOS()
			{
				return OSType == MacOS;
			}
		
		public static final String	OS								= System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
		public static final int				OtherOS			= 0;
		public static final int				LinuxOS			= 1;
		public static final int				WindowsOS	= 2;
		public static final int				MacOS					= 3;
		public static final int				SolarisOS	= 4;
		public static final int				UnixOS				= 5;
		
		public static final int				OSType;
		static
			{
				if (OS.contains("mac") || OS.contains("darwin"))
					OSType = MacOS;
				else if (OS.contains("win"))
					OSType = WindowsOS;
				else if (OS.contains("nux"))
					OSType = LinuxOS;
				else if (OS.contains("nix"))
					OSType = UnixOS;
				else if (OS.contains("sol")|| OS.contains("sun"))
					OSType = SolarisOS;
				else
					OSType = OtherOS;
			}
	}
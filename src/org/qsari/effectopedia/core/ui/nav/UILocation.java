package org.qsari.effectopedia.core.ui.nav;

public class UILocation
	{
		
		public static final String	SEPARATOR	= "\\.";
		
		public UILocation(String name, String userInterfaceLocation, String packageName)
			{
				this.name = name;
				this.userInterfaceLocation = userInterfaceLocation;
				this.locationComponents = userInterfaceLocation.split(SEPARATOR);
				this.packageName = packageName;
			}
		
		public static boolean isInterfaceLocation(String location)
			{
				if (location == null)
					return false;
				return location.indexOf(UILocations.interfaceURL) != -1;
			}
		
		public String[] getLocation()
			{
				return locationComponents;
			}
		
		public String getLocation(int index)
			{
				if ((index < locationComponents.length) && (index >= 0))
					return locationComponents[index];
				else
					return null;
			}
		
		public void setLocation(String[] location)
			{
				this.locationComponents = location;
			}
		
		public void setLocation(String location)
			{
				this.locationComponents = location.split(SEPARATOR);
			}
		
		public String getPackageName()
			{
				return packageName;
			}
		
		public void setPackageName(String packageName)
			{
				this.packageName = packageName;
			}
		
		public String getUserInterfaceLocation()
			{
				return userInterfaceLocation;
			}
		
		public void setUserInterfaceLocation(String userInterfaceLocation)
			{
				this.userInterfaceLocation = userInterfaceLocation;
				this.locationComponents = userInterfaceLocation.split(SEPARATOR);
			}
		
		public static String extractLocation(String query)
			{
				int p = query.indexOf('&');
				if (p != -1)
					return query.substring(0, p);
				else
					return query;
			}
		
		public static String extractInitialization(String query)
			{
				int pInitialization = query.indexOf(INI);
				if (pInitialization != -1)
					{
						int pNext = query.indexOf("&", pInitialization + 1);
						return query.substring(pInitialization + INI.length(), (pNext != -1) ? pNext : query.length());
					}
				return null;
			}
		
		public static String extractParameter(String query)
			{
				int pParameter = query.indexOf(PAR);
				if (pParameter != -1)
					{
						int pNext = query.indexOf("&", pParameter + 1);
						return query.substring(pParameter + PAR.length(), (pNext != -1) ? pNext : query.length());
					}
				return null;
			}
		
		public static String extractHelpID(String query)
			{
				if (query == null)
					return null;
				int pHelp = query.indexOf(HELP);
				if (pHelp != -1)
					{
						int pNext = query.indexOf("&", pHelp + 1);
						return query.substring(pHelp + HELP.length(), (pNext != -1) ? pNext : query.length());
					}
				return null;
			}
		
		
		public final String getName()
			{
				return name;
			}
		
		public final void setName(String name)
			{
				this.name = name;
			}

		public boolean isReadOnly()
			{
				return this.readOnly;
			}
		
		public void setReadOnly(boolean readOnly)
			{
				this.readOnly = readOnly;
			}

		public void setReadOnly(String query)
			{
				this.readOnly = query.indexOf(READONLY) != -1;
			}

		private boolean						readOnly;
		private String							name;
		private String							userInterfaceLocation;
		private String[]					locationComponents;
		private String							packageName;
		public static String	INI						= "&ini=";
		public static String	PAR						= "&par=";
		public static String	HELP					= "&help=";
		public static String	READONLY	= "&readonly";
	}

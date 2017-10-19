package org.qsari.effectopedia.system;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.qsari.effectopedia.defaults.DefaultServerSettings;
import org.qsari.effectopedia.utils.HTTPCommunicator;


public class Users extends ArrayList<User>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1171644572507173986L;
		public static Users							REGISTERED							= new Users();
		
		private Users()
			{
				super();
				userMap = new HashMap<Long, User>();
				http = new HTTPCommunicator();
				(new Thread(new UserDisplayNames())).start();
			}
		
		private String getUserProfiles()
			{
				String result = null;
				HttpURLConnection connection;
				try
					{
						connection = http.openConnection(new URL(DefaultServerSettings.userProfiles), true, false, "GET", null, true);
						result = http.readData(connection);
						connection.disconnect();
					}
				catch (MalformedURLException e1)
					{
						System.out.println("Exception Handled!");
						e1.printStackTrace(System.out);
					}
				if (result != null)
					{
						int profileStart = result.indexOf(PROFILES_BEGIN_WITH);
						int profileEnd = result.indexOf(PROFILES_END_WITH);
						if ((profileStart != -1) && (profileEnd != -1))
							result = result.substring(profileStart + PROFILES_BEGIN_WITH.length(), profileEnd);
						else
							result = "";
					}
				return result;
			}
		
		public void loadProfiles(String profiles)
			{
				StringTokenizer st = new StringTokenizer(profiles, ";");
				while (st.hasMoreTokens())
					{
						String profile = st.nextToken().trim();
						int p = profile.indexOf('=', 0);
						int p1 = p > 0 ? profile.indexOf('=', p + 1) : -1;
						Long externalID = Long.parseLong(profile.substring(0, p));
						String displayName = profile.substring(p + 1, p1);
						String options = profile.substring(p1 + 1);
						if (!userMap.containsKey(externalID))
							(new User(displayName, externalID)).setOptions(options);
					}
			}
		
		public class UserDisplayNames implements Runnable
			{
				public void run()
					{
						if (!(DefaultServerSettings.isOnline()))
							return;
						loadProfiles(getUserProfiles());
					}
			}
		
		public String getDisplayNames(ArrayList<Long> externalIDs)
			{
				if (externalIDs == null)
					return null;
				String result = "";
				for (Long eID : externalIDs)
					{
						User user = userMap.get(eID);
						if (user != null)
							result = result + user.getTeamDisplayName() + "; ";
						else
							result = result + "n/a (" + String.valueOf(eID) + "); ";
					}
				return result;
			}
		
		public String getDisplayName(long userID)
			{
				User user = userMap.get(userID);
				if (user != null)
					return user.getDisplayName();
				else
					return "n/a (" + String.valueOf(userID) + ")";
			}
		
		public boolean add(User user)
			{
				if (user == null)
					return false;
				userMap.put(user.getExternalID(), user);
				return super.add(user);
			}
		
		private HashMap<Long, User>	userMap;
		private HTTPCommunicator				http;
		public static final String		AFFILIATION_SEPARATOR	= ",";
		public static final String		PROFILES_BEGIN_WITH			= "<!--profiles";
		public static final String		PROFILES_END_WITH					= "profiles-->";
	}

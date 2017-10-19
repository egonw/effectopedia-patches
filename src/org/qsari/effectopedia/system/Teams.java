package org.qsari.effectopedia.system;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.qsari.effectopedia.defaults.DefaultServerSettings;
import org.qsari.effectopedia.utils.HTTPCommunicator;

public class Teams extends HashMap<Long, ArrayList<Long>>
	{
		public static final Teams	CACHED	= new Teams();
		
		private Teams()
			{
				super();
				http = new HTTPCommunicator();
			}
		
		@Override
		public boolean containsKey(Object key)
			{
				boolean result = super.containsKey(key);
				if ((((Long) key).compareTo(0L) < 0) && !running)
					{
						running = true;
						(new Thread(new GetTeamIDs((Long) key))).start();
					}
				return result;
			}
		
		@Override
		public ArrayList<Long> get(Object key)
			{
				ArrayList<Long> result = super.get(key);
				if ((result == null) && (!running))
					{
						running = true;
						(new Thread(new GetTeamIDs((Long) key))).start();
					}
				return result;
			}
		
		public ArrayList<Long> get(Object key, TeamUsersUpdateListener listener)
			{
				ArrayList<Long> result = get(key);
				if (result==null)
					addTeamUpdateListenerListener(listener);
				return result;
			}
		
		private String getTeam(long ID)
			{
				String result = null;
				HttpURLConnection connection;
				try
					{
						connection = http.openConnection(new URL(DefaultServerSettings.teamProfiles + ID), true, false, "GET", null, true);
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
						int profileStart = result.indexOf(TEAM_IDS_LIST_START);
						int profileEnd = result.indexOf(TEAM_IDS_LIST_END);
						if ((profileStart != -1) && (profileEnd != -1))
							result = result.substring(profileStart + TEAM_IDS_LIST_START.length(), profileEnd);
						else
							result = "";
					}
				return result;
			}
		
		private void storeTeam(long ID, String usetIDs)
			{
				StringTokenizer st = new StringTokenizer(usetIDs, ID_SEPARATOR);
				ArrayList<Long> userIDs = new ArrayList<Long>(st.countTokens());
				while (st.hasMoreTokens())
					try
						{
							long userID = Long.parseLong(st.nextToken().trim());
							userIDs.add(userID);
						}
					catch (Exception e)
						{
						}
				this.put(ID, userIDs);
			}
		
		public class GetTeamIDs implements Runnable
			{
				public GetTeamIDs(long teamID)
					{
						this.teamID = teamID;
					}
				
				public void run()
					{
						if (!(DefaultServerSettings.isOnline()))
							{
								running = false;
								return;
							}
						storeTeam(teamID, getTeam(teamID));
						running = false;
						fireTeamUpdated(new EventObject((Long) teamID));
					}
				
				public final long	teamID;
			}
		
		public interface TeamUsersUpdateListener
			{
				public void teamUsersUpdated(EventObject evt);
			}
		
		public void addTeamUpdateListenerListener(TeamUsersUpdateListener listener)
			{
				if (teamUsersUpdateListeners.indexOf(listener) == -1)
					teamUsersUpdateListeners.add(listener);
			}
		
		public void removeTeamUpdateListenerListener(TeamUsersUpdateListener listener)
			{
				teamUsersUpdateListeners.remove(listener);
			}
		
		protected void fireTeamUpdated(EventObject evt)
			{
				for (TeamUsersUpdateListener listener : teamUsersUpdateListeners)
					listener.teamUsersUpdated(evt);
				teamUsersUpdateListeners.clear();
			}
		
		private static final ArrayList<TeamUsersUpdateListener>	teamUsersUpdateListeners	= new ArrayList<Teams.TeamUsersUpdateListener>();
		private static final String																													ID_SEPARATOR													= ",";
		private static final String																													TEAM_IDS_LIST_START						= "<!--team_ids";
		private static final String																													TEAM_IDS_LIST_END								= "team_ids-->";
		private static volatile boolean																									running																		= false;
		/**
	 * 
	 */
		private static final long																															serialVersionUID									= 1L;
		private HTTPCommunicator																																http;
	}

package org.qsari.effectopedia.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import org.qsari.effectopedia.base.IndexedObject;

public class User extends IndexedObject
	{
		public static final User	SYSTEM	= new User("id=1;displayName=SYSTEM;firstName=Effectopedia;lastName=System;e-mail=system@effectopedia.org");
		public static final User	GUEST		= new User("id=2;displayName=GUEST;firstName=Anonymous;lastName=Guest;e-mail=null@effectopedia.org");
		public static final User	IQF				= new User("id=5;displayName=IQF;firstName=International;lastName=QSAR Foundation;e-mail=info@qsari.org");
		
		public User(String displayName, long existingUserID)
			{
				setExternalID(existingUserID);
				info = new HashMap<String, String>();
				setDisplayName(displayName);
				Users.REGISTERED.add(this);
			}
		
		public long getID()
			{
				// No internal IDs are currently used which will change once multiple
				// servers are supported. Currently the unique externalID is based on the
				// registration in the Effectopedia server.
				return getExternalID();
			}
		
		public User(String profile)
			{
				super();
				autoSetId();
				info = new HashMap<String, String>();
				parseProfile(profile);
				Users.REGISTERED.add(this);
			}
		
		public void parseProfile(String profile)
			{
				StringTokenizer st = new StringTokenizer(profile, "=;");
				if ((st.countTokens() & 1) == 0)
					while (st.hasMoreTokens())
						info.put(st.nextToken().trim(), st.nextToken().trim());
				update();
				displayName = info.get("displayName");
				String id = info.get("id");
				if (id != null)
					setExternalID(Long.parseLong(id));
				Iterator<Map.Entry<String, String>> it = info.entrySet().iterator();
				while (it.hasNext())
					{
						Map.Entry<String, String> entry = it.next();
						System.out.println(entry.getKey() + "=" + entry.getValue());
					}
			}
		
		public final String getFirstName()
			{
				return info.get("firstName");
			}
		
		public final void setFirstName(String firstName)
			{
				info.put("firstName", firstName);
			}
		
		public final String getLastName()
			{
				return info.get("lastName");
			}
		
		public final void setLastName(String lastName)
			{
				info.put("lastName", lastName);
			}
		
		public final String getDisplayName()
			{
				if (teamID>0)
					{
						ArrayList<Long> team = Teams.CACHED.get(Long.valueOf(teamID));
					if (team!=null)
						return Users.REGISTERED.getDisplayNames(team);
					}
				if (displayName == null)
					return info.get("firstName") + " " + info.get("lastName");
				else
					return displayName;
			}
		
		public final String getTeamDisplayName()
			{
				if (displayName == null)
					return info.get("firstName") + " " + info.get("lastName");
				else
					return displayName;
			}

		public final void setDisplayName(String displayName)
			{
				this.displayName = displayName;
				info.put("displayName", displayName);
			}
		
		public final String getE_mail()
			{
				return info.get("e-mail");
			}
		
		public final void setE_mail(String eMail)
			{
				info.put("e-mail", eMail);
			}
		
		public final String getFax()
			{
				return info.get("fax");
			}
		
		public final void setFax(String fax)
			{
				info.put("fax", fax);
			}
		
		public final String getTelephone()
			{
				return info.get("telephone");
			}
		
		public final void setTelephone(String telephone)
			{
				info.put("telephone", telephone);
			}
		
		public final String getWeb()
			{
				return info.get("web");
			}
		
		public final void setWeb(String web)
			{
				info.put("web", web);
			}
		
		public final String getAffiliation()
			{
				return info.get("affiliation");
			}
		
		public final void setAffiliation(String affiliation)
			{
				info.put("affiliation", affiliation);
			}
		
		public final String getCountry()
			{
				return info.get("country");
			}
		
		public final void setCountry(String country)
			{
				info.put("country", country);
			}
		
		public final String getCity()
			{
				return info.get("city");
			}
		
		public final void setCity(String city)
			{
				info.put("city", city);
			}
		
		public final String getStreet()
			{
				return info.get("street");
			}
		
		public final void setStreet(String street)
			{
				info.put("street", street);
			}
		
		public final String getZip()
			{
				return info.get("zip");
			}
		
		public final void setZip(String zip)
			{
				info.put("zip", zip);
			}
		
		public final String getOptions()
			{
				return info.get("options");
			}
		
		public final void setOptions(String options)
			{
				info.put("options", options);
				profileOptions = Integer.parseInt(options);
			}
		
		private void update()
			{
				String options = info.get("options");
				if (options != null)
					profileOptions = Integer.parseInt(options);
			}
		
		public int getProfileOptions()
			{
				return profileOptions;
			}
		
		public final HashMap<String, String> getInfo()
			{
				return info;
			}
		
		public final void setInfo(HashMap<String, String> info)
			{
				this.info = info;
			}
		
		public final Role[] getRole()
			{
				return roles;
			}
		
		public final void setRole(Role[] roles)
			{
				this.roles = roles;
			}
		
		public long getTeamID()
			{
				return teamID;
			}

		public void setTeamID(long teamID)
			{
				this.teamID = teamID;
			}

		private String																		displayName;
		private long																				teamID																		= -1;
		private HashMap<String, String>	info;
		private Role[]																		roles;
		private int																					profileOptions										= PO_NOTIFY_ON_UPDATES;
		protected static long											userIDs																	= 0;
		public static final int									PO_NOTIFY_ON_CHANGES				= 1;
		public static final int									PO_NOTIFY_ON_DISCUSSION	= 2;
		public static final int									PO_NOTIFY_ON_UPDATES				= 3;
		public static final int									PO_NOTIFY_ON_ALL_EVENTS	= 4;
		
	}

package org.qsari.effectopedia.system;

public class UserKey
	{
		public UserKey(long userID)
			{
				this.userID = userID;
			}
		
		protected String encrypt(long ID)
			{
				long id = ID + (release + 3 * version + ID) * ID / (version + ID);
				return Long.toString(id);
			}
		
		public String getKey()
			{
				StringBuilder aKey = new StringBuilder();
				aKey.append(65 + Math.round(57 * Math.random()));
				aKey.append(65 + Math.round(57 * Math.random()));
				int keyLocation = 3 + (int) Math.round(54 * Math.random());
				aKey.append(65 + keyLocation);
				String key = "";
				return key;
			}
		
		public String extractUserKey(String key)
			{
				if (key.length() > 3)
					{
						int position = key.charAt(3) - 65;
						return key.substring(position, position + 128);
					}
				else
					return null;
			}
		
		public boolean isValidKey(String key)
			{
				return true;
			}
		
		public boolean isValidKey(String key, long userID)
			{
				if (isValidKey(key))
					{
						// String aKey = extractUserKey(key);
						// String userKey = encrypt(userID);
						return true;
					}
				else
					return true;
			}
		
		protected long										userID;
		public static final int	version	= 1;
		public static final int	release	= 1;
	}

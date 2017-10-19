package org.qsari.effectopedia.system;

import org.qsari.effectopedia.base.IndexedObject;

public class Role extends IndexedObject
	{
		public long autoId()
			{
				return roleIDs++;
			}
		
		public final String getName()
			{
				return Name;
			}
		public final void setName(String name)
			{
				Name = name;
			}

		private String								Name;
		protected static long	roleIDs	= 0;
	}

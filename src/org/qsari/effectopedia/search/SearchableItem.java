package org.qsari.effectopedia.search;

import org.qsari.effectopedia.base.IndexedObject;

public class SearchableItem implements Cloneable
	{
		public SearchableItem(IndexedObject object, long propertyID, String searchName)
			{
				this.object = object;
				this.propertyID = propertyID;
				this.searchName = searchName;
			}

		public SearchableItem clone(IndexedObject object)
			{
				SearchableItem clone = new SearchableItem(object,this.propertyID,this.searchName);
				return clone;
			}

		
		public IndexedObject getObject()
			{
				return object;
			}
		
		public void setObject(IndexedObject object)
			{
				this.object = object;
			}
		
		public long getPropertyID()
			{
				return propertyID;
			}
		
		public void setPropertyID(long propertyID)
			{
				this.propertyID = propertyID;
			}
		
		public String getSearchName()
			{
				return this.searchName;
			}

		public void setSearchName(String searchName)
			{
				this.searchName = searchName;
			}

		protected IndexedObject	 object;
		protected long											propertyID;
		protected String									searchName;
	}

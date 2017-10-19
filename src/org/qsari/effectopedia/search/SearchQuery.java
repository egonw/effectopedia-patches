package org.qsari.effectopedia.search;

public abstract class SearchQuery 
	{
		public SearchQuery(String caption)
			{
				super();
				this.caption = caption;
			}
		
		public boolean isValid()
			{
				return true;
			}
		
 	public String getSearchPhrase()
			{
				return searchPhrase;
			}
		
		public void setSearchPhrase(String searchPhrase)
			{
				this.searchPhrase = searchPhrase;
			}
		
		public String getCaption()
			{
				return caption;
			}
		
		public void setCaption(String caption)
			{
				this.caption = caption;
			}
		
		public String toString()
			{
				return this.caption;
			}
		
		protected String	searchPhrase;
		protected String	caption;
	}

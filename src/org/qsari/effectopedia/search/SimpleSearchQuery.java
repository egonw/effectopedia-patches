package org.qsari.effectopedia.search;

public class SimpleSearchQuery extends SearchQuery implements Cloneable
	{
		
		public SimpleSearchQuery(String caption, String searchIndexName)
			{
				super(caption);
				this.searchIndexName = searchIndexName;
			}
		
		public boolean isValid()
			{
				return (searchIndexName != null) && (searchIndexName.compareTo("none") != 0);
			}
		
		public SimpleSearchQuery clone()
			{
				SimpleSearchQuery clone = new SimpleSearchQuery(this.caption, this.searchIndexName);
				return clone;
			}
		
		public String getSearchIndexName()
			{
				return searchIndexName;
			}
		
		public void setSearchIndexName(String searchIndexName)
			{
				this.searchIndexName = searchIndexName;
			}
		
		public String getSearchPhrase()
			{
				if (terms.length > 0)
					{
						StringBuffer buffer = new StringBuffer();
						for (String string : terms)
							buffer.append(string.concat(DEFAULT_DELIMITER));
						return buffer.substring(0, buffer.length() - DEFAULT_DELIMITER.length());
					}
				else
					return searchPhrase;
			}
		
		public void setSearchPhrase(String searchPhrase)
			{
				this.searchPhrase = searchPhrase;
				this.terms = searchPhrase.split("\\s");
			}
		
		public String[] getTerms()
			{
				return this.terms;
			}
		
		public String getTerm(int index)
			{
				if ((terms != null) && (index < terms.length))
					return this.terms[index];
				else
					return "";
			}
		
		public int getTermsCount()
			{
				if (terms != null)
					return terms.length;
				else
					return terms.length;
			}
		
		protected String[]									terms													= null;
		protected String											searchIndexName;
		public static final String	DEFAULT_DELIMITER	= " ";
	}

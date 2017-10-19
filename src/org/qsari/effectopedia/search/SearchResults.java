package org.qsari.effectopedia.search;

import java.util.Collection;
import java.util.TreeSet;

import org.qsari.effectopedia.data.DataSource;

public class SearchResults
	{
		public SearchResults()
			{
				items = new TreeSet<SearchResult>();
			}
		
		public void clear()
			{
				items.clear();
			}

		public void add(SearchResult result)
			{
			 items.add(result);
			}

		public void addAll(SearchResults results)
			{
				if (results!=null)
				 for (SearchResult result : results.getItems())
					 items.add(result);
			}

		public void addAll(Collection<SearchableItem> results)
			{
				if (results!=null)
				 for (SearchableItem result : results)
					 items.add(new SearchResult(result));
			}
		
		public TreeSet<SearchResult> getItems()
			{
				return items;
			}
		
		public void setItems(TreeSet<SearchResult> items)
			{
				this.items = items;
			}
		
		public int count()
			{
				return items.size();
			}

		public void setDataSource(DataSource dataSource)
			{
				 for (SearchResult result : items)
					 result.setDataSource(dataSource);
			}
		
		private TreeSet<SearchResult>	items;

	}

package org.qsari.effectopedia.search;

import java.util.ArrayList;
import java.util.Collection;

public class SearchEngine
	{
		
		public SearchEngine()
			{
				super();
				indices = new SearchIndices();
				results = new SearchResults();
			}
		
		public void doSearch(SearchQuery query)
			{
				if (query instanceof SimpleSearchQuery)
					{
						indices.finalizeUpdates();
						this.results.clear();
						SearchIndex<?> searchIndex = indices.getIndexByName(((SimpleSearchQuery) query).getSearchIndexName());
						Collection<SearchableItem> results = parseAndRun(searchIndex, (SimpleSearchQuery) query);
						this.results.addAll(results);
					}
			}
		
		@SuppressWarnings("unchecked")
		private Collection<SearchableItem> parseAndRun(SearchIndex<?> searchIndex, SimpleSearchQuery query)
			{
				Collection<SearchableItem> results = null;
				if (searchIndex.dataType.isAssignableFrom(String.class))
					results = doStringSearch(((SearchIndex<String>) searchIndex), query);
				else if (searchIndex.dataType.isAssignableFrom(Integer.class))
					results = ((SearchIndex<Integer>) searchIndex).search(Integer.parseInt(query.getSearchPhrase()));
				else if (searchIndex.dataType.isAssignableFrom(Long.class))
					results = ((SearchIndex<Long>) searchIndex).search(Long.parseLong(query.getSearchPhrase()));
				else if (searchIndex.dataType.isAssignableFrom(Float.class))
					results = ((SearchIndex<Float>) searchIndex).search(Float.parseFloat(query.getSearchPhrase()));
				else if (searchIndex.dataType.isAssignableFrom(Double.class))
					results = ((SearchIndex<Double>) searchIndex).search(Double.parseDouble(query.getSearchPhrase()));
				return results;
			}
		
		private Collection<SearchableItem> doStringSearch(SearchIndex<String> searchIndex, SimpleSearchQuery query)
			{
				int termsCount = query.getTermsCount();
				if (termsCount == 1)
					return searchIndex.search(query.getSearchPhrase().toLowerCase());
				else if (termsCount != 0)
					{
						Collection<SearchableItem> results = new ArrayList<SearchableItem>();
						String[] terms = query.getTerms();
						Collection<SearchableItem> partialResult = searchIndex.search(terms[0].toLowerCase());
						if (partialResult != null)
							results.addAll(partialResult);
						else
							return null;
						for (int i = 1; i < termsCount; i++)
							{
								partialResult = searchIndex.search(terms[i].toLowerCase());
								if (partialResult != null)
									results.retainAll(partialResult);
								else
									return null;
							}
						return results;
					}
				else
					return null;
			}
		
		public SearchIndices getIndices()
			{
				return indices;
			}
		
		public void setIndices(SearchIndices indices)
			{
				this.indices = indices;
			}
		
		public SearchResults getResults()
			{
				return results;
			}
		
		public void setResults(SearchResults results)
			{
				this.results = results;
			}

		protected SearchIndices	indices;
		protected SearchResults	results;
	}

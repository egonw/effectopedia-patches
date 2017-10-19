package org.qsari.effectopedia.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.qsari.effectopedia.search.SearchIndices.SearchableItemFilter;

public class SearchIndex_Hash<K> extends SearchIndex<K>
	{
		public SearchIndex_Hash(String name, Class<?> dataType)
			{
				super(name,dataType);
				index = new HashMap<K, ArrayList<SearchableItem>>();
			}
		
		public Collection<SearchableItem> search(K key)
			{
				return index.get(key);
			}
		
	public void add(K key, SearchableItem item)
			{
				ArrayList<SearchableItem> current = index.get(key);
				if (current == null)
					{
						current = new ArrayList<SearchableItem>();
						index.put(key, current);
					}
				current.add(item);
			}

	public void putAllMatching(SearchIndex_Hash<K> source, SearchableItemFilter filter)
		{
			Iterator<Entry<K, ArrayList<SearchableItem>>> it = source.getIndex().entrySet().iterator();
			while (it.hasNext())
				{
					Entry<K, ArrayList<SearchableItem>> entry = it.next();
					K key = entry.getKey();
					ArrayList<SearchableItem> items = entry.getValue();
					ArrayList<SearchableItem> filterdItems = new ArrayList<SearchableItem>();
					for (SearchableItem sa: items)
						if (filter.match(sa))
							filterdItems.add(sa);
					if (filterdItems.size()>0)
						index.put(key, filterdItems);
				}
		}
		
	public void putAll(SearchIndex_Hash<K> source)
		{
			Iterator<Entry<K, ArrayList<SearchableItem>>> it = source.getIndex().entrySet().iterator();
			while (it.hasNext())
				{
					Entry<K, ArrayList<SearchableItem>> entry = it.next();
					K key = entry.getKey();
					ArrayList<SearchableItem> items = entry.getValue();
					ArrayList<SearchableItem> newItems = new ArrayList<SearchableItem>();
					for (SearchableItem sa: items)
						newItems.add(sa);
					if (newItems.size()>0)
						index.put(key, newItems);
				}
		}

	public void remove(K key, SearchableItem item)
			{
				ArrayList<SearchableItem> current = index.get(key);
				if (current != null)
					current.remove(item);
			}

		public HashMap<K, ArrayList<SearchableItem>> getIndex()
			{
				return index;
			}
		
		public void setIndex(HashMap<K, ArrayList<SearchableItem>> index)
			{
				this.index = index;
			}
		
		protected HashMap<K, ArrayList<SearchableItem>>	index;

	}

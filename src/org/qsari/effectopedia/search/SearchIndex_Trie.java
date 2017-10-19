package org.qsari.effectopedia.search;

import java.util.Collection;

import org.qsari.effectopedia.utils.TrieMap;

public class SearchIndex_Trie<K> extends SearchIndex<K>
	{
		public SearchIndex_Trie(String name, Class<?> dataType)
			{
				super(name,dataType);
				index = new TrieMap<K, SearchableItem>();
			}
		
		public Collection<SearchableItem> search(K key)
			{
				return null; //TODO index.get(key);
			}

		public void add(K key, SearchableItem item)
			{
    //TODO treat K as K[]
			}
		
		public void remove(K key, SearchableItem item)
			{
   //TODO
			}

		public TrieMap<K, SearchableItem> getIndex()
			{
				return index;
			}

		public void setIndex(TrieMap<K, SearchableItem> index)
			{
				this.index = index;
			}

		protected TrieMap<K, SearchableItem>	index;
		
	}

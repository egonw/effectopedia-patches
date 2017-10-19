package org.qsari.effectopedia.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public abstract class SearchIndex<K>
	{
		public SearchIndex(String name, Class<?> dataType)
			{
				super();
				this.name = name;
				this.dataType = dataType;
			}
		
		public abstract Collection<SearchableItem> search(K key);
		
		public abstract void add(K key, SearchableItem item);
		
		public abstract void remove(K key, SearchableItem item);
		
		public Collection<SearchableItem> clearDuplicates(Collection<SearchableItem> fromCollection)
			{
				HashSet<SearchableItem> unique = new HashSet<SearchableItem>();
				Iterator<SearchableItem> it = fromCollection.iterator();
				while (it.hasNext())
					{
						SearchableItem item = it.next();
						unique.add(item);
					}
				return unique;
			}
		
		public Collection<SearchableItem> filterByClass(Collection<SearchableItem> fromCollection, Class<?> leave)
			{
				ArrayList<SearchableItem> acceptable = new ArrayList<SearchableItem>();
				Iterator<SearchableItem> it = fromCollection.iterator();
				while (it.hasNext())
					{
						SearchableItem item = it.next();
						if (leave.isAssignableFrom(item.getObject().getClass()))
							acceptable.add(item);
					}
				return acceptable;
			}

		public String getName()
			{
				return name;
			}
		
		public void setName(String name)
			{
				this.name = name;
			}
		
		public Class<?> getDataType()
			{
				return dataType;
			}
		
		public void setDataType(Class<?> dataType)
			{
				this.dataType = dataType;
			}
		
		protected String			name;
		protected Class<?>	dataType;
	}

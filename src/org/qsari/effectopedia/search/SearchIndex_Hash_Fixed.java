package org.qsari.effectopedia.search;

import java.util.ArrayList;
import java.util.Collection;

public class SearchIndex_Hash_Fixed extends SearchIndex_Hash<String>
	{
		
		public SearchIndex_Hash_Fixed(String name, Class<?> dataType)
			{
				super(name, dataType);
				fixedList = null;
			}
		
		public SearchIndex_Hash_Fixed(String name, ArrayList<String> fixedList)
			{
				super(name, String.class);
				this.fixedList = fixedList;
			}
		
		public void add(int key, SearchableItem item)
			{
				super.add(fixedList.get(key), item);
			}
		
		public void add(long key, SearchableItem item)
			{
				super.add(fixedList.get((int) key), item);
			}
		
		@Override
		public void add(String key, SearchableItem item)
			{
				if (key.matches("^\\d*$"))
					super.add(fixedList.get(Integer.parseInt(key)), item);
				else
					super.add(key, item);
			}
		
		@Override
		public void remove(String key, SearchableItem item)
			{
				if (key.matches("^\\d*$"))
					super.remove(fixedList.get(Integer.parseInt(key)), item);
				else
					super.remove(key, item);
			}
		
		public void remove(int key, SearchableItem item)
			{
				super.remove(fixedList.get(key), item);
			}
		
		public void remove(long key, SearchableItem item)
			{
				super.remove(fixedList.get((int) key), item);
			}
		
		@Override
		public Collection<SearchableItem> search(String key)
			{
				if (key.matches("^\\d*$"))
					try
						{
							return super.search(fixedList.get(Integer.parseInt(key)));
						}
					catch (IndexOutOfBoundsException e)
						{
							return null;
						}
				else
					return super.search(key);
			}
		
		public ArrayList<String> getFixedList()
			{
				return fixedList;
			}

		public void setFixedList(ArrayList<String> fixedList)
			{
				this.fixedList = fixedList;
			}

		protected ArrayList<String>	fixedList;
	}

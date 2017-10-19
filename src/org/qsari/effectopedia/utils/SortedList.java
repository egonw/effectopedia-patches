package org.qsari.effectopedia.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@SuppressWarnings("serial")
public class SortedList<E> extends ArrayList<E>
	{
		public SortedList(ValueComparator<E> comparator)
			{
				super();
				this.comparator = comparator;
			}
		
		public SortedList(ValueComparator<E> comparator,int initialSize)
			{
				super(initialSize);
				this.comparator = comparator;
			}
		
		public void add(int index, E element)
			{
				add(element);
			}
		
		public static <E> int binarySearch(SortedList<E> list, int low, int hi, E key, ValueComparator<? super E> comparator)
			{
				if ((low > hi) || (low < 0 || hi > list.size()))
					throw new IllegalArgumentException("Illegal search boundaries!");
				int mid = 0;
				if (list.size() > 0)
					while (low <= hi)
						{
							mid = (low + hi) >>> 1;
							final int d = comparator.compare(list.get(mid), key);
							if (d == 0)
								return mid;
							else if (d > 0)
								hi = mid - 1;
							else
								low = ++mid;
						}
				return -mid - 1;
			}
		
		public static <E> int binarySearchValue(SortedList<E> list, int low, int hi, Object value, ValueComparator<? super E> comparator)
			{
				if ((low > hi) || (low < 0 || hi > list.size()))
					throw new IllegalArgumentException("Illegal search boundaries!");
				int mid = 0;
				if (list.size() > 0)
					while (low <= hi)
						{
							mid = (low + hi) >>> 1;
							final int d = comparator.compareToValue(list.get(mid), value);
							if (d == 0)
								return mid;
							else if (d > 0)
								hi = mid - 1;
							else
								low = ++mid;
						}
				return -mid - 1;
			}	

		@Override
		public int indexOf(Object element)
			{
				return binarySearchValue(this,0,(size() > 0) ? size() - 1 : 0,element,comparator);
			}
		
		public static <E> SortedList<E> merge(Set<SortedList<E>> lists, ValueComparator<E> comparator)
			{
				int totalSize = 0; 
				for (SortedList<E> l : lists)
					{
						totalSize += l.size();
					}
				
				SortedList<E> result = new SortedList<E>((ValueComparator<E>) comparator,totalSize);
				
				SortedList<E> lowest;
				
				while (result.size() < totalSize)
					{ 
						lowest = null;
						
						for (SortedList<E> l : lists)
							{
								if (!l.isEmpty())
									{
										if (lowest == null)
											{
												lowest = l;
											}
										else if (comparator.compare(l.get(0),lowest.get(0)) <= 0)
											{
												lowest = l;
											}
									}
							}
						result.add(lowest.get(0));
						lowest.remove(0);
					}
				return result;
			}
		
		public boolean add(E element)
			{
				int index = binarySearch(this, 0, (size() > 0) ? size() - 1 : 0, element, comparator);
				if (index < 0)
					index = -index - 1;
				else
					index++;
				super.add(index, element);
				return true;
			}
		
		@Override
		public boolean addAll(int index, Collection<? extends E> collecton)
			{
				super.addAll(index, collecton);
				Collections.sort(this, comparator);
				return true;
			}
		
		@Override
		public boolean addAll(Collection<? extends E> collecton)
			{
				super.addAll(collecton);
				Collections.sort(this, comparator);
				return true;
			}
		
		private ValueComparator<E> 	comparator;
	}

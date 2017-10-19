package org.qsari.effectopedia.utils;

import java.util.ArrayList;
import java.util.Collection;

public class MultiIndexSortedList<E> extends ArrayList<E>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		public MultiIndexSortedList(ValueComparator<E>[] comparators)
			{
				this.size = comparators.length;
				this.indices = new ArrayList<SortedList<E>>(size);
				for (int i = 0; i < size; i++)
					indices.add(new SortedList<E>(comparators[i]));
			}
		
		public SortedList<E> getList(int index)
			{
				return indices.get(index);
			}
		
		public boolean add(E element)
			{
				super.add(element);
				for (SortedList<E> index : indices)
					index.add(element);
				return true;
			}
		
		@Override
		public boolean addAll(Collection<? extends E> collection)
			{
				super.addAll(collection);
				for (SortedList<E> index : indices)
					index.addAll(collection);
				return true;
			}
		
		public int indexOf(int index, E element)
			{
				SortedList<E> list = indices.get(index);
				return list.indexOf(element);
			}
	
		@Override
		public boolean remove(Object element)
			{
				super.remove(element); //Requires sequential search in natural order array
				boolean fromAllIndeces = true;
				for (SortedList<E> index : indices)
					fromAllIndeces = fromAllIndeces && remove(index, element);
				return fromAllIndeces;
			}

		@Override
		public E remove(int index)
			{
				E element = super.remove(index); 
				for (SortedList<E> i : indices)
				 remove(i, element);
				return element;
			}
		
		public boolean remove(int index, int elementIndex)
			{
				boolean fromAllIndeces = true;
				SortedList<E> list = indices.get(index);
				E element = list.get(elementIndex);
				list.remove(elementIndex);
				for (int i = 0; i < index; i++)
					fromAllIndeces = fromAllIndeces && remove(indices.get(i), element);
				for (int i = index + 1; i < size; i++)
					fromAllIndeces = fromAllIndeces && remove(indices.get(i), element);
				return fromAllIndeces;
			}
		
		protected boolean remove(SortedList<E> list, int elementIndex)
			{
				if ((elementIndex >= 0) && (elementIndex < list.size()))
					{
						list.remove(elementIndex);
						return true;
					}
				return false;
			}
		
		protected boolean remove(SortedList<E> list, Object element)
			{
				int elementIndex = list.indexOf(element);
				if ((elementIndex >= 0) && (elementIndex < list.size()))
					{
						list.remove(elementIndex);
						return true;
					}
				return false;
			}
		
		private ArrayList<SortedList<E>>	indices;
		private int																						size;
	}

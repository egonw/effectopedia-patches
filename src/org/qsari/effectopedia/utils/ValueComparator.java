package org.qsari.effectopedia.utils;

import java.util.Comparator;

public interface ValueComparator<E> extends Comparator<E>
	{
		public int compareToValue(E element, Object value);
	}

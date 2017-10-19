package org.qsari.effectopedia.utils;

import java.util.Arrays;

public class GenericUtils
	{
		public static <T> T[] concatenate(T[] A, T[] B)
			{
				if ((A==null)||(A.length==0))
					return B;
				else if ((B==null)||(B.length==0))
					return A;
				T[] result = Arrays.copyOf(A, A.length + B.length);
				System.arraycopy(B, 0, result, A.length, B.length);
				return result;
			}
	}

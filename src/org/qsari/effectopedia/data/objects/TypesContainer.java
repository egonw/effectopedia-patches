package org.qsari.effectopedia.data.objects;

import java.util.ArrayList;
import java.util.Iterator;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.data.interfaces.IdentifiableDescriptorType;
import org.qsari.effectopedia.data.interfaces.SearchableTypesContainer;

public class TypesContainer<T extends IdentifiableDescriptorType> extends ArrayList<T> implements SearchableTypesContainer<T>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		 
		public String[] getNames()
			{
				String[] names = new String[size()];
				Iterator<T> it = iterator();
				int i = 0;
				while (it.hasNext())
					names[i++] = it.next().getName();
				return names;
			}
		
		public int IndexOf(String name)
			{
				for (int i = size() - 1; i >= 0; i--)
					if (get(i).getName().equals(name))
						return i;
				return -1;
			}
		
		public void clearNonDefault()
			{
				for (Iterator<T> iterator = this.iterator(); iterator.hasNext();)
					if (!((DescriptorType) iterator.next()).isDefaultID())
						iterator.remove();
			}
		
		public T getType(String name)
			{
				for (int i = size() - 1; i >= 0; i--)
					if (get(i).getName().equals(name))
						return get(i);
				return null;
			}
		
		public String DEBUG_getIDs()
			{
				StringBuilder sb = new StringBuilder();
				sb.append("\types count=\t");
				sb.append(size());
				sb.append("\ttypes:\t");
				for (T type : this)
					sb.append(((EffectopediaObject) type).DEBUG_getIDs());
				return sb.toString();
				
			}
	}

package org.qsari.effectopedia.data.interfaces;

public interface SearchableTypesContainer<T extends IdentifiableDescriptorType>
	{
		public String[] getNames();
		
		public int IndexOf(String name);
		
		public T getType(String name);
		
		public boolean add(T descriptorType);
		
		public void add(int index, T descriptorType);
		
		public T remove(int index);
		
		public void clear();
		
		public T get(int index);
		
		public T set(int index, T descriptorType);
		
		public int size();
	}

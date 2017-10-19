package org.qsari.effectopedia.data.interfaces;


public interface IdentifiableObjectPropertyType extends IdentifiableDescriptorType
	{
		public boolean isSearchable();
		
		public boolean isDocumented();
		
		public void setDocumented(boolean documented);
		
		public boolean isAcceptingMultipleValues();
		
		public void setAcceptingMultipleValues(boolean acceptingMultipleValues);
		
		public SearchableTypesContainer<IdentifiableDescriptorType> getDescriptors();
		
		public void setDescriptors(SearchableTypesContainer<IdentifiableDescriptorType> descriptors);
		
		public String getDescriptorsCaption();
		
		public int getDescriptorsCount();
	}

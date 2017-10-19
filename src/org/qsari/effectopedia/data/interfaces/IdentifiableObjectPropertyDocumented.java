package org.qsari.effectopedia.data.interfaces;


public interface IdentifiableObjectPropertyDocumented extends IdentifiableObjectPropertyMultivalued
	{
		public AssignableDocumentedValue getValueAndUnitPair(int index);
		
		public void add(AssignableDocumentedValue pair);
		
	}

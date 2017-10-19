package org.qsari.effectopedia.data.interfaces;

public interface IdentifiableObjectPropertyMultivalued extends IdentifiableObjectProperty
	{
		public AssignableValueAndUnit getValueAndUnitPair(int index); 

		public void add(AssignableValueAndUnit pair);
		
		public int valuesCount();
	}

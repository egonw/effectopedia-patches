package org.qsari.effectopedia.data.interfaces;


public interface IdentifiableObjectProperty
	{

		public IdentifiableEffectopediaObject getOwner();
		
		public IdentifiableObjectPropertyType getType();
		
		public AssignableValueAndUnit getValueAndUnit(); 
		
		public int valuesCount();
	}

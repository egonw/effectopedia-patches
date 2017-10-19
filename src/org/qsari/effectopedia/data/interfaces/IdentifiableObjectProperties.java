package org.qsari.effectopedia.data.interfaces;

import java.util.ArrayList;

import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.data.objects.ObjectPropertyType;

public interface IdentifiableObjectProperties
	{
		public IdentifiableEffectopediaObject getOwner();
		
		public ArrayList<ObjectProperty> getProperties();
		
		public SearchableTypesContainer<ObjectPropertyType> getTypes();
		
		public int getCount();
		
		// public String[] getPropertyNames();
		
		// public String[] getPropertyValues();
		
		// public String[] getPropertyUnits();
		
		// public String getPropertyName(int index);
		
		// public IdentifiableObjectProperty getProperty(String name);
		
		// public String getPropertyValue(int index);
		
		// public void setPropertyValue(int index, String value);
		
		// public void setPropertyUnit(int index, String value);
		
		// public String getPropertyUnit(int index);
		
		// public String getPropertyDefaultDescriptors(int index);
		
		// public String getPropertyReference(int index);
		
	}

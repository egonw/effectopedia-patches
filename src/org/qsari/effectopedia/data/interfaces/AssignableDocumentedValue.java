package org.qsari.effectopedia.data.interfaces;

import java.util.Collection;

import org.qsari.effectopedia.data.objects.DataValue;
import org.qsari.effectopedia.data.objects.Descriptor;

public interface AssignableDocumentedValue extends AssignableValueAndUnit
	{
		public DataValue<?> getMinValue();
		
		public void setMinValue(DataValue<?> minValue);
		
		public void setMinValue(String value);
		
		public String getDisplayMinValue();
		
		public DataValue<?> getMaxValue();
		
		public void setMaxValue(DataValue<?> maxValue);
		
		public void setMaxValue(String value);
		
		public String getDisplayMaxValue();
		
		public Collection<Descriptor> getDescriptors();
		
		public void setDescriptors(Collection<Descriptor> descriptors);
		
		public String getNotes();
		
		public void setNotes(String notes);
		
		public void setReferences(String value);
		
		public String getDisplayConditions();
		
		public String getReferences();
		
	}

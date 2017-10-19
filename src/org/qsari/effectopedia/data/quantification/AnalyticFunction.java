package org.qsari.effectopedia.data.quantification;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;

public interface AnalyticFunction
	{
		public EffectopediaObject getOwner();
		
		public ObjectPropertyMultivalued_Documented getParameters();
		
		public DataTemplates getTemplates();
		
		public Double getParameter(int index);
		
		public void setParameter(int index, Double value);
		
		public void setParameter(int index, String value);
		
		public Double getParameterLowerRange(int index);
		
		public void setParameterLowerRange(int index, Double value);
		
		public void setParameterLowerRange(int index, String value);
		
		public Double getParameterUpperRange(int index);
		
		public void setParameterUpperRange(int index, Double value);
		
		public void setParameterUpperRange(int index, String value);
		
		public Double getLowerApplicabilityRange();
		
		public void setLowerApplicabilityRange(Double value);
		
		public void setLowerApplicabilityRange(String value);
		
		public Double getUpperApplicabilityRange();
		
		public void setUpperApplicabilityRange(Double value);
		
		public void setUpperApplicabilityRange(String value);
		
		public String getDescription();
		
		public void setDescription(String description);
		
		public String getReferences();
		
		public void setReferences(String references);
		
		public ModifiableTableModel generateTableModel();
		
		public String getExpression();
		
		public void setExpression(String expression);
		
		public boolean isParameterListModifiable();
		
		public String getUncertaintyType();
		
		public void setUncertaintyType(String uncertaintyType);
	}

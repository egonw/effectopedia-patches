package org.qsari.effectopedia.data.objects;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.interfaces.IdentifiableDescriptorType;

public class DistributionType extends DescriptorType
	{
		public void cloneFieldsTo(DistributionType clone)
			{
				super.cloneFieldsTo(clone);
				clone.expression = this.expression;
				clone.coefficients = new DescriptorTypesContainer();
				for (IdentifiableDescriptorType coef : this.coefficients)
					clone.coefficients.add(((DescriptorType)coef).clone());
				clone.baseValueType = this.baseValueType;
			}
		
		public DistributionType clone(EffectopediaObject owner, DataSource dataSource)
			{
				DistributionType clone = new DistributionType();
				cloneFieldsTo(clone);
				return clone;
			}
		
		public DistributionType clone()
			{
				DistributionType clone = new DistributionType();
				cloneFieldsTo(clone);
				return clone;
			}

		protected DescriptorTypesContainer	coefficients	= new DescriptorTypesContainer();
		protected String expression;
	}

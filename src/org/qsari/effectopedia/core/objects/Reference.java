/*
 * 
 */

package org.qsari.effectopedia.core.objects;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultTextProperties;
import org.qsari.effectopedia.system.ActionTypes;

public class Reference extends EffectopediaObject implements Importable, Exportable, Cloneable, Traceable
	{
		public Reference()
			{
				super();
			}
		
		public Reference(EffectopediaObject parent,DataSource dataSource)
			{
				super(parent,dataSource);
			}

		public Reference(EffectopediaObject parent,DataSource dataSource, String formatedReference)
			{
				super(parent,dataSource);
				this.formatedReference = formatedReference;
			}
		
		public String getFormatedReference()
			{
				if (this.formatedReference == null)
					return DefaultTextProperties.INSTANCE.getDefault("Reference.formatedReference");
				else
					return this.formatedReference;
			}
		
		public void setFormatedReference(String formatedReference)
			{
				if (((formatedReference == null) && (this.formatedReference != null)) || (!formatedReference.equals(this.formatedReference)))
					{
						beforeUpdate(true, ActionTypes.REFERENCE_FORMATED_AID);
						this.formatedReference = formatedReference;
					}
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						formatedReference = element.getValueElement("formated_reference").getValue();
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addValueElement(io.newValue("formated_reference").setValue(formatedReference));
				return element;
			}
		
		
		@Override
				public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if (eoDestintation instanceof Reference)
					((Reference)eoDestintation).setFormatedReference(this.getFormatedReference());
			}

		
		public void cloneFieldsTo(Reference clone,DataSource dataSource)
			{
				super.cloneFieldsTo(clone,dataSource);
				clone.formatedReference = this.formatedReference;
			}
		
		public Reference clone()
			{
				Reference clone = new Reference(parent,dataSource);
				cloneFieldsTo(clone,dataSource);
				return clone;
			}
		
		public Reference clone(EffectopediaObject parent,DataSource dataSource)
			{
				Reference clone = new Reference(parent,dataSource);
				cloneFieldsTo(clone,dataSource);
				return clone;
			}
		
		protected String								formatedReference;
	}

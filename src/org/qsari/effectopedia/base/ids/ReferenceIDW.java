package org.qsari.effectopedia.base.ids;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.BaseIOValue;
import org.qsari.effectopedia.data.DataSource;

public class ReferenceIDW<E extends EffectopediaObject> extends ReferenceID<E>
	{
		public ReferenceIDW()
			{
				super();
				this.objectClass = null;
				this.referenceID = 0;
				this.weight = 0.0D;
				cachedObject = null;
			}
		
		public ReferenceIDW(EffectopediaObject parent, DataSource dataSource, Class<E> objectClass, double weight)
			{
				super(parent, dataSource, objectClass);
				this.weight = weight;
			}
		
		@SuppressWarnings("unchecked")
		@Override
		public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if ((eoDestintation instanceof ReferenceIDW<?>) && (((ReferenceIDW<?>) eoDestintation).getObjectClass() == objectClass))
					((ReferenceIDW<E>) eoDestintation).setWeight(this.getWeight());
			}
		
		public void cloneFieldsTo(ReferenceIDW<E> clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.referenceID = this.referenceID + ID_OFFSET;
				clone.cachedObject = null;
				clone.weight = weight;
			}
		
		@Override
		public ReferenceIDW<E> clone()
			{
				ReferenceIDW<E> clone = new ReferenceIDW<E>(parent, dataSource, objectClass, 0.0D);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		@Override
		public ReferenceIDW<E> clone(EffectopediaObject parent, DataSource dataSource)
			{
				ReferenceIDW<E> clone = new ReferenceIDW<E>(parent, dataSource, objectClass, 0.0D);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						weight = element.getValueElement("weight").getDoubleValue();
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				BaseIOValue o = io.newValue("weight");
				o.setValue(weight);
				element.addValueElement(o);
				return element;
			}
		
		public String DEBUG_getIDs()
			{
				StringBuilder sb = new StringBuilder();
				sb.append(super.DEBUG_getIDs());
				sb.append("\treferenceID\t");
				sb.append(referenceID);
				sb.append("\tweight\t");
				sb.append(weight);
				return sb.toString();
			}
		
		public double getWeight()
			{
				return weight;
			}
		
		public void setWeight(double weight)
			{
				this.weight = weight;
			}
		
		protected double	weight;
	}

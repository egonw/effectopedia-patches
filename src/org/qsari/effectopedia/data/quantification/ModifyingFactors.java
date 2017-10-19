package org.qsari.effectopedia.data.quantification;

import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObject.BatchProcessor;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.data.DataSource;

public class ModifyingFactors extends Factors<EffectopediaObject>
	{
		public ModifyingFactors(EffectopediaObject owner, DataSource dataSource)
			{
				super();
				objectIDs = new ReferenceIDs<EffectopediaObject>(owner, dataSource, EffectopediaObject.class);
			}
		
		public ModifyingFactors clone(EffectopediaObject owner, DataSource dataSource)
			{
				ModifyingFactors clone = new ModifyingFactors(owner, dataSource);
				clone.objectIDs = objectIDs.clone();
				return clone;
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				containedIDs.put(objectIDs.getID(), objectIDs);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				containedIDs.put(objectIDs.getExternalID(), objectIDs);
			}
		
		public void process(BatchProcessor batch)
			{
				objectIDs.process(batch);
			}
		
		public void updateParenthood()
			{
				objectIDs.updateParenthood();
			}
		
		public void reloadReferredObjectsFromID()
			{
				objectIDs.reloadReferredObjectsFromID();
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element == null)
					return;
				objectIDs.load(element.getChild("ids"), io);
			}
		
		@Override
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					element.addChild(objectIDs.store(io.newElement("ids"), io));
				return element;
			}
		
		public void add(Factor factor)
			{
				if (factor instanceof EffectopediaObject)
					objectIDs.add(factor);
			}
		
		@Override
		public EffectopediaObject[] getFactors()
			{
				return objectIDs.getCachedObjects();
			}
		
		public ReferenceIDs<EffectopediaObject> getObjectIDs()
			{
				return objectIDs;
			}

		public void setObjectIDs(ReferenceIDs<EffectopediaObject> objectIDs)
			{
				this.objectIDs = objectIDs;
			}

		protected ReferenceIDs<EffectopediaObject>	objectIDs;
	}

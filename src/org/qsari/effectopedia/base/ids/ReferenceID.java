package org.qsari.effectopedia.base.ids;

import java.util.HashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.BaseIOValue;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.DataSourceMerge;
import org.qsari.effectopedia.system.ActionTypes;

public class ReferenceID<E extends EffectopediaObject> extends EffectopediaObject implements Importable, Exportable, Cloneable, Traceable
	{
		public ReferenceID()
			{
				super();
				this.objectClass = null;
				this.referenceID = 0;
				cachedObject = null;
			}
			
		public ReferenceID(EffectopediaObject parent, DataSource dataSource, Class<E> objectClass)
			{
				super(parent, dataSource);
				this.objectClass = objectClass;
				this.referenceID = 0;
				cachedObject = null;
			}
			
		@SuppressWarnings("unchecked")
		public ReferenceID(EffectopediaObject parent, DataSource dataSource, E e)
			{
				super(parent, dataSource);
				this.objectClass = ((Class<E>) e.getClass());
				this.referenceID = e.getID();
				cachedObject = e;
			}
			
		public void set(E e)
			{
				if ((e != null) && (!e.equals(cachedObject)))
					{
						beforeUpdate(true, ActionTypes.REFERENCE_SET);
						this.referenceID = e.getID();
						cachedObject = e;
					}
				else if ((e == null) && (cachedObject != null))
					{
						beforeUpdate(true, ActionTypes.REFERENCE_SET);
						this.referenceID = 0;
						cachedObject = e;
					}
			}
			
		public void setAndKeepItDefault(E e)
			{
				if (isDefaultID())
					{
						this.referenceID = e.getID();
						cachedObject = e;
					}
			}
			
		public E getCachedObject()
			{
				if (cachedObject == null)
					cachedObject = Effectopedia.getEffectopedia().<E> getEffectopediaObject(this.objectClass, this.referenceID);
				return cachedObject;
			}
			
		public long getReferenceID()
			{
				return referenceID;
			}
			
		public void updateIDfromObject()
			{
				if (cachedObject != null)
					referenceID = cachedObject.getID();
			}
			
		public void setReferenceID(long referenceID)
			{
				if (this.referenceID != referenceID)
					{
						beforeUpdate(true, ActionTypes.LIST_ADD);
						this.referenceID = referenceID;
						cachedObject = null;
					}
			}
			
		public void replaceExternalReferenceID(HashMap<Long, EffectopediaObject> idMap)
			{
				if (isDefaultID())
					return;
				//System.out.print("replace ExternalID\t" + this.referenceID);
				if (this.referenceID != 0)
					{
						EffectopediaObject eo = idMap.get(this.referenceID);
						if (eo != null)
							{
								//System.out.println("\twith ID\t" + eo.getID());
								this.referenceID = eo.getID();
							}
						else
							System.err.println("\t not found for \t" + this.referenceID);
					}
				this.cachedObject = null;
			}
			
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				if (dataSource != null)
					this.cachedObject = dataSource.get(objectClass, referenceID);
			}
			
		@SuppressWarnings("unchecked")
		public void updateReferrals(HashMap<Long, EffectopediaObject> referrals)
			{
				super.updateReferrals(referrals);
				EffectopediaObject eo = referrals.get(referenceID);
				if (eo != null)
					{
						this.referenceID = eo.getID();
						this.cachedObject = (E) eo;
					}
			}
			
		public void updateReferrals(DataSourceMerge dsm)
			{
				super.updateReferrals(dsm);
			//	if ((cachedObject != null) && (cachedObject.getDataSource() != null) && (cachedObject.getDataSource() != dataSource) && (!cachedObject.isDefaultID()))
			//		System.out.println("need to replace");
				
				E eo = (E) dsm.get(dataSource, cachedObject);
				if (eo != null)
					{
						this.referenceID = eo.getID();
						this.cachedObject = (E) eo;
					}
			}
			
		public Class<E> getObjectClass()
			{
				return objectClass;
			}
			
		@SuppressWarnings("unchecked")
		@Override
		public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if ((eoDestintation instanceof ReferenceID<?>) && (((ReferenceID<?>) eoDestintation).getObjectClass() == objectClass))
					((ReferenceID<E>) eoDestintation).setReferenceID(this.referenceID);
			}
			
		public void cloneFieldsTo(ReferenceID<E> clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.referenceID = this.referenceID > 0 ? this.referenceID + ID_OFFSET : this.referenceID;
				// clone.cachedObject = null;
				clone.cachedObject = this.cachedObject; // TODO Test if this assignment does
																																												// not have negative implications
			}
			
		@Override
		public ReferenceID<E> clone()
			{
				ReferenceID<E> clone = new ReferenceID<E>(parent, dataSource, objectClass);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
			
		@Override
		public ReferenceID<E> clone(EffectopediaObject parent, DataSource dataSource)
			{
				ReferenceID<E> clone = new ReferenceID<E>(parent, dataSource, objectClass);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
			
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						BaseIOValue co = element.getValueElement("object_class");
						try
							{
								objectClass = (Class<E>) Class.forName(co.getValue());
							}
						catch (ClassNotFoundException e1)
							{
								e1.printStackTrace();
							}
						referenceID = element.getValueElement("object_id").getLongValue();
						// System.out.println("###"+getID()+"### ReferenceID="+referenceID);
					}
			}
			
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				BaseIOValue co = io.newValue("object_class");
				co.setValue(objectClass.getName());
				element.addValueElement(co);
				BaseIOValue o = io.newValue("object_id");
				o.setValue(Long.toString(Effectopedia.EFFECTOPEDIA.getData().autoExternalID(objectClass, referenceID)));
				element.addValueElement(o);
				return element;
			}
			
		public String DEBUG_getIDs()
			{
				StringBuilder sb = new StringBuilder();
				sb.append(super.DEBUG_getIDs());
				sb.append("\treferenceID\t");
				sb.append(referenceID);
				return sb.toString();
			}
			
		protected long					referenceID;
		protected E								cachedObject	= null;
		protected Class<E>	objectClass;
	}

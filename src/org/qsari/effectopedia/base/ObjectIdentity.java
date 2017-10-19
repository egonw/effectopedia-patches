package org.qsari.effectopedia.base;

import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.system.TraceableClasses;

public class ObjectIdentity implements  Importable, Exportable
	{
		public ObjectIdentity()
			{
				super();
			}

		public ObjectIdentity(long id, long classID)
			{
				super();
				this.objectId = id;
				this.objectClassId = classID;
			}

		public long getObjectId()
			{
				return objectId;
			}
		
		public void setObjectId(long objectId)
			{
				this.objectId = objectId;
			}
		
		public long getObjectClassId()
			{
				return objectClassId;
			}
		
		public void setObjectClassId(long objectClassId)
			{
				this.objectClassId = objectClassId;
			}
		
		public Class<? extends EffectopediaObject> getObjectClass()
		{
			return TraceableClasses.REGISTERED.getClassByID(this.objectClassId);
		}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						objectClassId = element.getValueElement("object_class_id").getLongValue();
						long externalID = element.getValueElement("object_id").getLongValue();
						objectId = Effectopedia.EFFECTOPEDIA.getData().getIDbyExternalID(objectClassId, externalID);
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				element.addValueElement((io.newValue("object_class_id")).setValue(objectClassId));
				long externalID = Effectopedia.EFFECTOPEDIA.getData().getExternalIDbyID(objectClassId, objectId);
				element.addValueElement((io.newValue("object_id")).setValue(externalID));
				return element;
			}

		protected long	objectClassId;
		protected long	objectId;
		
	}
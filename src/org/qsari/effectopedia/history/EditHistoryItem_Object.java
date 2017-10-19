package org.qsari.effectopedia.history;

import org.qsari.effectopedia.base.ObjectIdentity;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.core.Effectopedia;


public class EditHistoryItem_Object extends ObjectIdentity
	{
		public EditHistoryItem_Object()
			{
			}

		public EditHistoryItem_Object(long id, long archivalId, long classID)
			{
				super(id,classID);
				this.objectArchiveId = archivalId;
			}
		
		public long getObjectArchiveId()
			{
				return objectArchiveId;
			}
		
		public void setObjectArchiveId(long objectArchiveId)
			{
				this.objectArchiveId = objectArchiveId;
			}

		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						long externalID = element.getValueElement("object_archive_id").getLongValue();
						objectArchiveId = Effectopedia.EFFECTOPEDIA.getData().getArchiveIDbyExternalID(externalID);
					}
			}

		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				long externalID = Effectopedia.EFFECTOPEDIA.getData().getExternalIDbyArchivedID(objectClassId, objectArchiveId);
				element.addValueElement(io.newValue("object_archive_id").setValue(externalID));
				element.setAttribute("type","object");
				return element;
			}
		
	 public boolean isForLiveObject()
	 	{
	 		return objectId==objectArchiveId;
	 	}
	 
		protected long	objectArchiveId;
	}

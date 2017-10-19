package org.qsari.effectopedia.history;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.base.ObjectIdentity;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.system.TraceableClasses;

public class EditHistoryAction extends IndexedObject
	{
		
		protected EditHistoryAction()
			{
				super();
				autoSetId();
			}
			
		protected EditHistoryAction(long stampID)
			{
				super();
				this.stampId = stampID;
				autoSetId();
			}
			
		public EditHistoryAction(ObjectIdentity object, long stampID)
			{
				super();
				this.stampId = stampID;
				autoSetId();
				this.object = object;
			}
			
		public long getStampId()
			{
				return stampId;
			}
			
		public long getObjectId()
			{
				if (object != null)
					return object.getObjectId();
				else
					return 0L;
			}
			
		public Class<? extends EffectopediaObject> getObjectClass()
			{
				if (object != null)
					return object.getObjectClass();
				else
					return null;
			}
			
		public long getObjectClassId()
			{
				if (object != null)
					return object.getObjectClassId();
				else
					return 0L;
			}
			
		public ObjectIdentity getObject()
			{
				return object;
			}
			
		public boolean isForDefaultObject()
			{
				if (object != null)
					{
						EffectopediaObject eo = Effectopedia.EFFECTOPEDIA.getData().get(object);
						return (eo != null) ? eo.isDefaultID() : false;
					}
				else
					return false;
			}
			
		public EffectopediaObject getArchivedObject(DataSource dataSource)
			{
				if ((object != null) && (object instanceof EditHistoryItem_Object))
					{
						EffectopediaObject eo;
						Class<? extends EffectopediaObject> cl = TraceableClasses.REGISTERED.getClassByID(((EditHistoryItem_Object) object).getObjectClassId());
						eo = dataSource.get(cl, ((EditHistoryItem_Object) object).getObjectId());
						if (eo == null)
							eo = dataSource.getArchivedEffectopediaObjectByID(cl, ((EditHistoryItem_Object) object).objectArchiveId);
						return eo;
					}
				else
					return null;
			}
			
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						String type = element.getAttributeValue("type");
						if ("object".equals(type))
							object = new EditHistoryItem_Object();
						else if ("property".equals(type))
							object = new EditHistoryItem_Property();
						else
							{
								object = null;
								return;
							}
						super.load(element, io);
						Stamp st = new Stamp();
						st.load(element.getChild("stamp"), io);
						this.stampId = st.getID();
						Effectopedia.EFFECTOPEDIA.getStamps().add(st);// TODO Stamp should be
																																																				// embedded
						object.load(element, io);
					}
			}
			
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				updateExternalID();
				element.setAttribute("id", Long.toString(EditHistory.actionsCnt));
				Stamp stamp = Effectopedia.EFFECTOPEDIA.getStamps().get((int) stampId);
				element.addChild(stamp.store(io.newElement("stamp"), io));
				object.store(element, io);
				EditHistory.actionsCnt++;
				return element;
			}
			
		public long autoId()
			{
				return EditHisoryActionIDs++;
			}
			
		public String DEBUG_getIDs()
			{
				StringBuilder sb = new StringBuilder();
				sb.append("\tclass\t");
				sb.append(getClass());
				sb.append("\tID\t");
				sb.append(getID());
				sb.append("\texternalID\t");
				sb.append(externalID);
				sb.append("\tstampId\t");
				sb.append(stampId);
				if ((object != null) && (object instanceof EditHistoryItem_Object))
					{
						sb.append("\tobject objectId\t");
						sb.append(((EditHistoryItem_Object) object).getObjectId());
						sb.append("\tobject objectClassId\t");
						sb.append(((EditHistoryItem_Object) object).getObjectClassId());
						sb.append("\tobject objectArchiveId\t");
						sb.append(((EditHistoryItem_Object) object).getObjectArchiveId());
					}
				return sb.toString();
			}
			
		public static long							EditHisoryActionIDs	= 0;
		
		protected long											stampId;
		protected ObjectIdentity	object;
	}

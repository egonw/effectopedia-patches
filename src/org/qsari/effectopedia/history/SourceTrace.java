package org.qsari.effectopedia.history;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.system.TraceableClasses;

public class SourceTrace implements Importable, Exportable
	{
		public SourceTrace()
			{
				super();
				this.internalID = 0;
				this.externalID = 0;
				this.classID = 0;
				this.sourceID = null;
			}
		
		public SourceTrace(long internalID, long externalID, long classID, SourceID sourceID)
			{
				super();
				this.internalID = internalID;
				this.externalID = externalID;
				this.classID = classID;
				this.sourceID = sourceID;
			}
		
		public long getExternalID()
			{
				return externalID;
			}
		
		public void setExternalID(long externalID)
			{
				this.externalID = externalID;
			}
		
		public long getInternalID()
			{
				return internalID;
			}
		
		public void setInternalID(long internalID)
			{
				this.internalID = internalID;
			}
		
		public long getClassID()
			{
				return classID;
			}
		
		public void setClassID(long classID)
			{
				this.classID = classID;
			}
		
		public SourceID getSourceID()
			{
				return sourceID;
			}
		
		public void setSourceID(SourceID sourceID)
			{
				this.sourceID = sourceID;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						this.classID = element.getValueElement("class_id").getLongValue();
						if (sourceID == null)
							sourceID = new SourceID();
						this.sourceID.load(element.getChild("source_id"), io);
						this.externalID = element.getValueElement("object_id").getLongValue();
						EffectopediaObject eo = Effectopedia.EFFECTOPEDIA.getData().getEffectopediaObjectByExternalID(externalID);
						this.internalID = (eo != null) ? eo.getID() : 0;
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				element.addValueElement(io.newValue("object_id").setValue(Effectopedia.EFFECTOPEDIA.getData().getExternalIDbyID(classID, internalID)));
				element.addValueElement(io.newValue("class_id").setValue(classID));
				element.addChild(sourceID.store(io.newElement("source_id"), io));
				return element;
			}
		
		public void updateExternalID()
			{
				EffectopediaObject eo = Effectopedia.EFFECTOPEDIA.getData().getEffectopediaObjectByID(TraceableClasses.REGISTERED.getClassByID(classID), internalID);
				if ((eo != null) && (eo.getExternalID() != externalID))
					externalID = eo.getExternalID();
				sourceID.setID(externalID);
			}
		
		public boolean isDefaultTrace()
			{
				EffectopediaObject eo = Effectopedia.DEFAULT_DATASOURCE.getEffectopediaObjectByID(TraceableClasses.REGISTERED.getClassByID(classID), internalID);
				if (eo == null)
					return false;
				return eo.isDefaultID();
			}
		
		protected long					internalID;
		protected long					externalID;
		protected long					classID;
		protected SourceID	sourceID;
		
	}

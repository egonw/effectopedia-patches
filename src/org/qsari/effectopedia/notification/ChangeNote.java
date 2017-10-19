package org.qsari.effectopedia.notification;

import java.util.ArrayList;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.system.TraceableClasses;

public class ChangeNote implements Exportable
	{
		public ChangeNote(long userID, long actionID, Pathway pathway, PathwayElement pathwayElement, EffectopediaObject actionObject)
			{
				this.userID = userID;
				this.actionIDs = new ArrayList<Long>();
				this.actionIDs.add(actionID);
				this.actionObjectTypeIDs = new ArrayList<Long>();
				this.actionObjectTypeIDs.add(TraceableClasses.REGISTERED.getClassID(actionObject.getClass()));
				this.pathway = pathway.getTitle();
				this.pathwayID = pathway.getExternalID();
				this.pathwayElement = pathwayElement.getTitle();
				this.pathwayElementID = pathwayElement.getExternalID();
				this.pathwayElementTypeID = TraceableClasses.REGISTERED.getClassID(pathwayElement.getClass());
			}
		
		public void addAction(long actionID, EffectopediaObject actionObject)
			{
				this.actionIDs.add(actionID);
				this.actionObjectTypeIDs.add(TraceableClasses.REGISTERED.getClassID(actionObject.getClass()));
			}
		
		private String getActionIDsAsString()
			{
				StringBuilder sb = new StringBuilder();
				for (Long actionID : actionIDs)
					{
						sb.append(actionID);
						sb.append(" ");
					}
				sb.delete(sb.length() - 1, sb.length());
				return sb.toString();
			}

		private String getActionObjectTypeIDsAsString()
			{
				StringBuilder sb = new StringBuilder();
				for (Long actionObjectTypeID : actionObjectTypeIDs)
					{
						sb.append(actionObjectTypeID);
						sb.append(" ");
					}
				sb.delete(sb.length() - 1, sb.length());
				return sb.toString();
			}
		
		public boolean equals(long userID, long pathwayID, long pathwayElementID)
			{
				return this.userID == userID && this.pathwayID == pathwayID && this.pathwayElementID == pathwayElementID;
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				element.setAttribute("made_by_user", this.userID);
				element.addValueElement(io.newValue("actions").setValue(getActionIDsAsString()));
				element.addValueElement(io.newValue("object_types").setValue(getActionObjectTypeIDsAsString()));
				BaseIOElement p = io.newElement("pathway").setValue(pathway);
				p.setAttribute("id", Long.toString(this.pathwayID));
				element.addChild(p);
				BaseIOElement e = io.newElement("pathway_element").setValue(pathwayElement);
				e.setAttribute("id", Long.toString(this.pathwayElementID));
				e.setAttribute("type", Long.toString(this.pathwayElementTypeID));
				element.addChild(e);
				return element;
			}
		
		public final long												userID;
		public final ArrayList<Long>	actionIDs;
		public final ArrayList<Long>	actionObjectTypeIDs;
		public final String										pathway;
		public final long												pathwayID;
		public final String										pathwayElement;
		public final long												pathwayElementID;
		public final long												pathwayElementTypeID;
	}

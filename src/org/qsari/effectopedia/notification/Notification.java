package org.qsari.effectopedia.notification;

import java.util.ArrayList;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;

public class Notification implements Exportable
	{
		public Notification(long notifyUserID)
			{
				this.notifyUserID = notifyUserID;
				this.changesNotes = new ArrayList<ChangeNote>();
				this.discussionNotes = new ArrayList<DiscussionNote>();
			}
		
		public ChangeNote createChangeNote(long userID, long actionID, Pathway pathway, PathwayElement pathwayElement, EffectopediaObject actionObject)
			{
				for (ChangeNote n : changesNotes)
					if (n.equals(userID, pathway.getExternalID(), pathwayElement.getExternalID()))
						{
							n.addAction(actionID,actionObject);
							return n;
						}
				ChangeNote note;
				if (pathwayElement instanceof Link)
					note = new LinkNote(userID, actionID, pathway, (Link) pathwayElement,actionObject);
				else
					note = new ChangeNote(userID, actionID, pathway, pathwayElement,actionObject);
				changesNotes.add(note);
				return note;
			}
		
		public DiscussionNote createDiscussionNote(long userID, long actionID, Pathway pathway, PathwayElement pathwayElement, EffectopediaObject actionObject, String subject, String posting)
			{
				for (DiscussionNote n : discussionNotes)
					if (n.equals(userID, pathway.getExternalID(), pathwayElement.getExternalID()))
						{
							n.addAction(actionID,actionObject);
							return n;
						}
				DiscussionNote note = new DiscussionNote(userID, actionID, pathway, pathwayElement, actionObject, subject, posting);
				discussionNotes.add(note);
				return note;				
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				element.setAttribute("notify_user", Long.toString(this.notifyUserID));
				if (changesNotes.size() > 0)
					{
						BaseIOElement cn = io.newElement("cnage_notes");
						cn.setAttribute("count", Integer.toString(changesNotes.size()));
						for (ChangeNote n : changesNotes)
							{
								BaseIOElement note = io.newElement("change");
								n.store(note, io);
								cn.addChild(note);
							}
						element.addChild(cn);
					}
				if (discussionNotes.size() > 0)
					{
						BaseIOElement dn = io.newElement("discussion_notes");
						dn.setAttribute("count", Integer.toString(discussionNotes.size()));
						for (DiscussionNote n : discussionNotes)
							{
								BaseIOElement note = io.newElement("discussion");
								n.store(note, io);
								dn.addChild(note);
							}
						element.addChild(dn);
					}
				return element;
			}

		public final long																						notifyUserID;
		public final ArrayList<ChangeNote>					changesNotes;
		public final ArrayList<DiscussionNote>	discussionNotes;
	}

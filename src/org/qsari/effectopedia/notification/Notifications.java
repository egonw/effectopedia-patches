package org.qsari.effectopedia.notification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.ObjectIdentity;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.DiscussionPosting;
import org.qsari.effectopedia.core.objects.DiscussionTopic;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.history.EditHistory;
import org.qsari.effectopedia.history.EditHistoryAction;
import org.qsari.effectopedia.history.Stamp;
import org.qsari.effectopedia.system.User;
import org.qsari.effectopedia.system.Users;

public class Notifications extends HashMap<Long, Notification> implements Exportable
	{
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		/**
		 * You can always get what you want!
		 */
		public Notification alwaysGet(long userID)
			{
				Notification result = get(userID);
				if (result == null)
					{
						result = new Notification(userID);
						put(userID, result);
					}
				return result;
			}
		
		public void build(EditHistory history, int sinceRevision)
			{
				HashMap<Long, ArrayList<EditHistoryAction>> completeMap = history.getObjectHistoryMap();
				HashMap<Long, ArrayList<EditHistoryAction>> partialMap = history.getPartialObjectHistoryMap(sinceRevision,false);
				HashMap<DiscussionPosting, DiscussionTopic> postingsMap = Effectopedia.EFFECTOPEDIA.getData().getLiveIndices().getDiscussion().generatePostingsMap();
				Iterator<Map.Entry<Long, ArrayList<EditHistoryAction>>> it = partialMap.entrySet().iterator();
				while (it.hasNext())
					{
						Map.Entry<Long, ArrayList<EditHistoryAction>> entry = it.next();
						long objectID = entry.getKey();
						ArrayList<EditHistoryAction> actions = entry.getValue();
						for (EditHistoryAction eha : actions)
							{
								ObjectIdentity oi = eha.getObject();
								Stamp stamp = Effectopedia.EFFECTOPEDIA.getStamps().get((int) eha.getStampId());
								EffectopediaObject eo = (EffectopediaObject) Effectopedia.EFFECTOPEDIA.getData().getEffectopediaObjectByID(oi.getObjectClass(), oi.getObjectId());
								if (eo instanceof DiscussionPosting)
									{
										DiscussionTopic topic = postingsMap.get((DiscussionPosting) eo);
										if (topic != null)
											addDiscussionNote((DiscussionPosting) eo, topic, stamp, User.SYSTEM.getID());
										addUserSpecificDiscussionNotes(completeMap.get(topic.getAboutObject().getID()), (DiscussionPosting) eo, topic, stamp);
										addUserSpecificChangeNotes(completeMap.get(objectID), eo, stamp);
									}
								else
									{
										addChangeNote(eo, stamp, User.SYSTEM.getID());
										addUserSpecificChangeNotes(completeMap.get(objectID), eo, stamp);
									}
							}
						
					}
			}
		
		private void addUserSpecificChangeNotes(ArrayList<EditHistoryAction> actions, EffectopediaObject eo, Stamp stamp)
			{
				if (actions == null)
					return;
				for (EditHistoryAction eha : actions)
					{
						Stamp action_stamp = Effectopedia.EFFECTOPEDIA.getStamps().get((int) eha.getStampId());
						if (action_stamp.getID() < stamp.getID())
							{
								long userID = action_stamp.getUserId();
								User user = (userID > Users.REGISTERED.size()) ? null : Users.REGISTERED.get((int) userID);
								if ((userID != stamp.getUserId()) && (user != null) && ((user.getProfileOptions() & (User.PO_NOTIFY_ON_CHANGES | User.PO_NOTIFY_ON_ALL_EVENTS)) != 0))
									addChangeNote(eo, stamp, userID);
							}
						else
							break;
					}
			}
		
		private void addUserSpecificDiscussionNotes(ArrayList<EditHistoryAction> actions, DiscussionPosting posting, DiscussionTopic topic, Stamp stamp)
			{
				if (actions == null)
					return;
				for (EditHistoryAction eha : actions)
					{
						Stamp action_stamp = Effectopedia.EFFECTOPEDIA.getStamps().get((int) eha.getStampId());
						if (action_stamp.getID() < stamp.getID())
							{
								long userID = action_stamp.getUserId();
								User user = Users.REGISTERED.get((int) userID);
								if ((userID != stamp.getUserId()) && (user != null) && ((user.getProfileOptions() & (User.PO_NOTIFY_ON_DISCUSSION | User.PO_NOTIFY_ON_ALL_EVENTS)) != 0))
									addDiscussionNote(posting, topic, stamp, userID);
							}
						else
							break;
					}
			}
		
		private void addDiscussionNote(DiscussionPosting posting, DiscussionTopic topic, Stamp stamp, long userID)
			{
				EffectopediaObject eo = topic.getAboutObject();
				EffectopediaObject pe = eo;
				while ((pe != null) && !(pe instanceof PathwayElement))
					pe = pe.getParent();
				EffectopediaObject pathway = pe;
				while ((pathway != null) && !(pathway instanceof Pathway))
					pathway = pathway.getParent();
				if ((pe instanceof PathwayElement) && (pathway instanceof Pathway))
					{
						Notification notification = alwaysGet(userID);
						notification.createDiscussionNote(stamp.getUserId(), stamp.getActionId(), (Pathway) pathway, (PathwayElement) pe, eo, posting.getTitle(), posting.getContent());
					}
			}
		
		private void addChangeNote(EffectopediaObject eo, Stamp stamp, long userID)
			{
				EffectopediaObject pe = eo;
				while ((pe != null) && !(pe instanceof PathwayElement))
					pe = pe.getParent();
				EffectopediaObject pathway = pe;
				while ((pathway != null) && !(pathway instanceof Pathway))
					pathway = pathway.getParent();
				if ((pe instanceof PathwayElement) && (pathway instanceof Pathway))
					{
						Notification notification = alwaysGet(userID);
						notification.createChangeNote(stamp.getUserId(), stamp.getActionId(), (Pathway) pathway, (PathwayElement) pe, eo);
					}
			}
		
		public void addDiscussionNote(long userID, DiscussionNote note)
			{
				if (userID != note.userID)
					alwaysGet(userID).discussionNotes.add(note);
			}

		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				element.setAttribute("count", Integer.toString(size()));
				if (size() > 0)
					{
						Iterator<Map.Entry<Long, Notification>> it = entrySet().iterator();
						while (it.hasNext())
							{
								BaseIOElement notification = io.newElement("notification");
								it.next().getValue().store(notification, io);
								element.addChild(notification);
							}
					}
				return element;
			}
	}

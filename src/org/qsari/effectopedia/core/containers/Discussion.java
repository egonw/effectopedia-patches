package org.qsari.effectopedia.core.containers;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.event.EventListenerList;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.core.objects.DiscussionPosting;
import org.qsari.effectopedia.core.objects.DiscussionTopic;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.data.DataSource;

public class Discussion extends EffectopediaObjects<DiscussionPosting>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public Discussion()
			{
				topics = new HashMap<Object, DiscussionTopic>();
				postings = new HashMap<DiscussionTopic, ArrayList<DiscussionPosting>>();
				eventListeners = new EventListenerList();
			}
		
		public boolean addNew(EffectopediaObject parent, DataSource dataSource, Class<DiscussionPosting> objectClass)
			{
				DiscussionPosting dp = new DiscussionPosting(parent, dataSource);
				DiscussionPosting old = put(dp.getID(), dp);
				return (old == null) || (old == dp);
			}
		
		public DiscussionPosting[] get()
			{
				return values().toArray(new DiscussionPosting[values().size()]);
			}
		
		@Override
		public DiscussionPosting put(Long key, DiscussionPosting value)
			{
				if (value instanceof DiscussionTopic)
					{
						DiscussionTopic topic = (DiscussionTopic) value;
						topics.put(topic.getAboutObject(), topic);
					}
				else
					{
						DiscussionTopic topic = (DiscussionTopic) value.getParent();
						ArrayList<DiscussionPosting> postingsOnThisTopic = postings.get(topic);
						if (postingsOnThisTopic == null)
							postingsOnThisTopic = new ArrayList<DiscussionPosting>();
						if (postingsOnThisTopic.indexOf(value) == -1)
							postingsOnThisTopic.add(value);
						postings.put(topic, postingsOnThisTopic);
					}
				DiscussionPosting old = super.put(key, value);
				fireDiscussionChanged(new EventObject(this));
				return old;
			}
		
		public ArrayList<DiscussionPosting> getPostings(DiscussionTopic topic)
			{
				return postings.get(topic);
			}
		
		public Object locateORCreateTopic(Object aboutObject)
			{
				DiscussionTopic topic = topics.get(aboutObject);
				if ((aboutObject != null) && (aboutObject instanceof EffectopediaObject))
					{
						if (topic == null)
							{
								
								topic = new DiscussionTopic(null, ((EffectopediaObject) aboutObject).getDataSource(), (EffectopediaObject) aboutObject, null);
								topics.put(aboutObject, topic);
								topic.bringToLive();
								super.put(topic.getID(), topic);
								fireDiscussionChanged(new EventObject(this));
							}
						return topic;
					}
				else
					return (topic == null) ? new DiscussionTopic(null, null, null, null) : topic;
			}
		
		public DiscussionTopic locateTopic(Object aboutObject)
			{
				return topics.get(aboutObject);
			}
		
		public ArrayList<DiscussionTopic> locateTopics(Object aboutObject)
			{
				if ((aboutObject == null) || !(aboutObject instanceof EffectopediaObject))
					return null;
				ArrayList<DiscussionTopic> relatedTopics = new ArrayList<DiscussionTopic>();
				while (!((aboutObject instanceof PathwayElement) || (aboutObject instanceof Pathway)))
					{
						EffectopediaObject p = ((EffectopediaObject) aboutObject).getParent();
						if (p == null)
							break;
						else
							aboutObject = p;
					}
				if ((aboutObject instanceof PathwayElement) || (aboutObject instanceof Pathway))
					{
						LinkedHashMap<Long, EffectopediaObject> containedIDs = new LinkedHashMap<Long, EffectopediaObject>();
						((EffectopediaObject) aboutObject).getContainedIDs(containedIDs, true);
						Iterator<Map.Entry<Long, EffectopediaObject>> iterator = containedIDs.entrySet().iterator();
						while (iterator.hasNext())
							{
								DiscussionTopic relatedTopic = topics.get(iterator.next().getValue());
								if ((relatedTopic != null))
									relatedTopics.add(relatedTopic);
							}
					}
				else
					{
						DiscussionTopic topic = topics.get(aboutObject);
						if (topic != null)
							relatedTopics.add(topic);
					}
				return relatedTopics;
			}
		
		public ArrayList<DiscussionTopic> getRelatedTopics(Object aboutObject)
			{
				// DiscussionTopic topic = topics.get(aboutObject);
				if (aboutObject instanceof EffectopediaObject)
					{
						EffectopediaObject pe = EffectopediaObject.getParentOfCertainClass((EffectopediaObject) aboutObject, PathwayElement.class);
						if (pe != null)
							{
								LinkedHashMap<Long, EffectopediaObject> containedIDs = new LinkedHashMap<Long, EffectopediaObject>();
								if (pe instanceof PathwayElement)
									((PathwayElement) pe).getContainedIDsForAssociatedPathways(containedIDs);
								else
									pe.getContainedIDs(containedIDs, true);
								ArrayList<DiscussionTopic> relatedTopics = new ArrayList<DiscussionTopic>();
								Iterator<Map.Entry<Long, EffectopediaObject>> iterator = containedIDs.entrySet().iterator();
								while (iterator.hasNext())
									{
										DiscussionTopic relatedTopic = topics.get(iterator.next().getValue());
										if ((relatedTopic != null))
											relatedTopics.add(relatedTopic);
									}
								// if (relatedTopics.size() > 0)
								// return relatedTopics.toArray(new
								// DiscussionTopic[relatedTopics.size()]);
								return relatedTopics;
							}
					}
				return null;
			}
		
		public interface DiscussionChangeListener extends EventListener
			{
				public void discussionChanged(EventObject evt);
			}
		
		public void addDiscussionChangeListener(DiscussionChangeListener listener)
			{
				eventListeners.add(DiscussionChangeListener.class, listener);
			}
		
		public void removeDiscussionChangeListener(DiscussionChangeListener listener)
			{
				eventListeners.remove(DiscussionChangeListener.class, listener);
			}
		
		protected void fireDiscussionChanged(EventObject evt)
			{
				DiscussionChangeListener[] listeners = eventListeners.getListeners(DiscussionChangeListener.class);
				for (int i = 0; i < listeners.length; i++)
					listeners[i].discussionChanged(evt);
			}
		
		public HashMap<DiscussionPosting, DiscussionTopic> generatePostingsMap()
			{
				HashMap<DiscussionPosting, DiscussionTopic> map = new HashMap<DiscussionPosting, DiscussionTopic>();
				Iterator<Map.Entry<DiscussionTopic, ArrayList<DiscussionPosting>>> it = postings.entrySet().iterator();
				while (it.hasNext())
					{
						Map.Entry<DiscussionTopic, ArrayList<DiscussionPosting>> entry = it.next();
						ArrayList<DiscussionPosting> posts = entry.getValue();
						for (DiscussionPosting posting : posts)
							map.put(posting, entry.getKey());
					}
				
				Iterator<Map.Entry<Object, DiscussionTopic>> topic_it = topics.entrySet().iterator();
				while (topic_it.hasNext())
					{
						Map.Entry<Object, DiscussionTopic> entry = topic_it.next();
						map.put(entry.getValue(), entry.getValue());
					}
				
				return map;
			}
		
		public String toString()
			{
				return "discussion";
			}
		
		protected EventListenerList																																				eventListeners;
		private HashMap<Object, DiscussionTopic>																							topics;
		private HashMap<DiscussionTopic, ArrayList<DiscussionPosting>>	postings;
		
	}

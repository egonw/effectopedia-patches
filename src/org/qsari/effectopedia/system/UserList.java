package org.qsari.effectopedia.system;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashSet;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.containers.Discussion;
import org.qsari.effectopedia.core.objects.DiscussionPosting;
import org.qsari.effectopedia.core.objects.DiscussionTopic;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.gui.comp.GlobalUpdateTracker;
import org.qsari.effectopedia.history.EditHistoryAction;
import org.qsari.effectopedia.history.Stamp;
import org.qsari.effectopedia.search.SearchableItem;
import org.qsari.effectopedia.system.Teams.TeamUsersUpdateListener;

public class UserList extends IndexedObject implements Importable, Exportable, TeamUsersUpdateListener
	{
		public UserList(String name, SearchableItem searchableItem)
			{
				super();
				ids = new ArrayList<Long>();
				this.name = name;
				this.searchItem = searchableItem;
			}
		
		public String getName()
			{
				return name;
			}
		
		public void setName(String name)
			{
				this.name = name;
			}
		
		@Override
		public void teamUsersUpdated(EventObject evt)
			{
				actionsCount = -1;
				if (searchItem != null)
					GlobalUpdateTracker.GUT.fireObjectUpdated(new EventObject(searchItem.getObject()));
			}
		
		public String getContributorsList(boolean includeContainedObjects)
			{
				if (searchItem != null)
					{
						IndexedObject owner = searchItem.getObject();
						DataSource data;
						if (owner instanceof EffectopediaObject)
							data = ((EffectopediaObject) owner).getDataSource();
						else
							data = Effectopedia.EFFECTOPEDIA.getData();
						if (data == null)
							return null;
						HashSet<Long> uniqueIDs = new HashSet<Long>();
						ArrayList<EditHistoryAction> ehas;
						if (includeContainedObjects)
							ehas = data.getEditHistory().getContainedObjectHistory((EffectopediaObject) owner, false);
						else
							ehas = data.getEditHistory().getObjectHistory(owner.getID());
						if (ehas.size() == actionsCount)
							return list;
						actionsCount = ehas.size();
						ids.clear();
						for (EditHistoryAction eha : ehas)
							{
								Stamp stamp = Effectopedia.EFFECTOPEDIA.getStamps().get((int) eha.getStampId());
								// System.out.println(eha.getStampId()+" - "+stamp.getFormattedDate());
								if (stamp != null)
									{
										long userID = stamp.getUserId();
										if (!uniqueIDs.contains(userID))
											{
												uniqueIDs.add(userID);
												ids.add(userID);
											}
										if (stamp.getTeamId() > 0)
											{
												ArrayList<Long> team = Teams.CACHED.get(stamp.getTeamId(), this);
												if (team != null)
													for (Long uUD : team)
														if (!uniqueIDs.contains(uUD))
															{
																uniqueIDs.add(uUD);
																ids.add(uUD);
															}
											}
									}
								if ((this.stamp == null) || (this.stamp.getID() < stamp.getID()))
									this.stamp = stamp;
							}
						list = Users.REGISTERED.getDisplayNames(ids);
						return list;
					}
				return null;
			}
		
		public boolean hasReviewers(boolean includeContainedObjects)
			{
				IndexedObject owner = searchItem.getObject();
				DataSource data = Effectopedia.EFFECTOPEDIA.getData();
				if (data == null)
					return false;
				HashSet<Long> uniqueIDs = new HashSet<Long>();
				Discussion discussion = data.getLiveIndices().getDiscussion();
				ArrayList<DiscussionTopic> topics = discussion.locateTopics(owner);
				
				for (DiscussionTopic t : topics)
					{
						long userID = t.getStamp().getUserId();
						if (!uniqueIDs.contains(userID))
							uniqueIDs.add(userID);
						ArrayList<DiscussionPosting> postings = discussion.getPostings(t);
						if (postings != null)
							for (DiscussionPosting p : postings)
								{
									userID = p.getStamp().getUserId();
									if (!uniqueIDs.contains(userID))
										uniqueIDs.add(userID);
								}
					}
				if (uniqueIDs.size() == reviewsCount)
					return reviewsCount != 0;
				reviewsCount = uniqueIDs.size();
				return reviewsCount != 0;
			}
		
		public String getReviewersList(boolean includeContainedObjects)
			{
				if (searchItem == null)
					return null;
				try
					{
						// TODO Test and remove the try section
						IndexedObject owner = searchItem.getObject();
						DataSource data = Effectopedia.EFFECTOPEDIA.getData();
						if (data == null)
							return null;
						HashSet<Long> uniqueIDs = new HashSet<Long>();
						Discussion discussion = data.getLiveIndices().getDiscussion();
						ArrayList<DiscussionTopic> topics = discussion.locateTopics(owner);
						
						for (DiscussionTopic t : topics)
							{
								Stamp stamp = t.getStamp();
								long userID = stamp.getUserId();
								if (!uniqueIDs.contains(userID))
									uniqueIDs.add(userID);
								ArrayList<DiscussionPosting> postings = discussion.getPostings(t);
								if (postings != null)
									for (DiscussionPosting p : postings)
										{
											userID = p.getStamp().getUserId();
											if (!uniqueIDs.contains(userID))
												uniqueIDs.add(userID);
										}
								if ((this.stamp == null) || (this.stamp.getID() < stamp.getID()))
									this.stamp = stamp;
							}
						if (uniqueIDs.size() == reviewsCount)
							return list;
						reviewsCount = uniqueIDs.size();
						ids.clear();
						ids.addAll(uniqueIDs);
						list = Users.REGISTERED.getDisplayNames(ids);
						return list;
					}
				catch (Exception e)
					{
						System.out.println("Exception Handled!");
						e.printStackTrace(System.out);
						return null;
					}
			}
		
		public void reset()
			{
				actionsCount = -1;
				reviewsCount = -1;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						list = element.getValueElement(name).getValue();
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addValueElement(io.newValue(name).setValue(list));
				return element;
			}
		
		public Stamp getStamp()
			{
				return stamp;
			}
		
		private Stamp														stamp								= null;
		private int																actionsCount	= 0;
		private int																reviewsCount	= 0;
		protected String											list									= null;
		protected ArrayList<Long>		ids;
		protected String											name;
		protected SearchableItem			searchItem			= null;
		public static final String	DELIMITER				= ";";
	}

/*
 * 
 */

package org.qsari.effectopedia.core.objects;

import java.util.ArrayList;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.BaseIOValue;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultTextProperties;
import org.qsari.effectopedia.history.EditHistoryAction;
import org.qsari.effectopedia.history.Stamp;
import org.qsari.effectopedia.system.ActionTypes;
import org.qsari.effectopedia.system.Users;

public class DiscussionPosting extends EffectopediaObject implements Importable, Exportable, Cloneable, Traceable, Titleable
	{
		public DiscussionPosting()
			{
				super();
				userID = Effectopedia.EFFECTOPEDIA.getCurrentUser().getID();
			}
		
		public DiscussionPosting(EffectopediaObject parent,DataSource dataSource)
			{
				super(parent,dataSource);
				userID = Effectopedia.EFFECTOPEDIA.getCurrentUser().getID();
			}
		
		public String getTitle()
			{
				if (title == null)
					return DefaultTextProperties.INSTANCE.getDefault("DiscussionPosting.title");
				else
					return title;
			}
		
		public void setTitle(String title)
			{
				if (((title == null) && (this.title != null)) || (!title.equals(this.title)))
					{
						beforeUpdate(true, ActionTypes.DP_TITLE_AID);
						this.title = title;
					}
			}
		
		public String getContent()
			{
				if (content == null)
					return DefaultTextProperties.INSTANCE.getDefault("DiscussionPosting.content");
				else
					return content;
			}
		
		public boolean isNew()
			{
				return (title==null)&&(content==null);
			}
		
		public void setContent(String content)
			{
				if (((content == null) && (this.content != null)) || (!content.equals(this.content)))
					{
						beforeUpdate(true, ActionTypes.DP_CONTENT_AID);
						this.content = content;
					}
			}
		
		public String toString()
			{
				return getTitle();
			}

		@Override
				public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if (eoDestintation instanceof DiscussionPosting)
					{
						((DiscussionPosting) eoDestintation).setTitle(this.title);
						((DiscussionPosting) eoDestintation).setContent(this.content);
					}
			}

		public void cloneFieldsTo(DiscussionPosting clone,DataSource dataSource)
			{
				super.cloneFieldsTo(clone,dataSource);
				clone.title = this.title;
				clone.content = this.content;
			}
		
		public DiscussionPosting clone()
			{
				DiscussionPosting clone = new DiscussionPosting(parent,dataSource);
				cloneFieldsTo(clone,dataSource);
				return clone;
			}
		
		public DiscussionPosting clone(EffectopediaObject parent,DataSource dataSource)
			{
				DiscussionPosting clone = new DiscussionPosting(parent,dataSource);
				cloneFieldsTo(clone,dataSource);
				return clone;
			}

		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element,io);
						title = element.getValueElement("title").getValue();
						content = element.getChildValue("content");
						BaseIOValue topic = element.getValueElement("topic");
						if (topic != null)
							parent = Effectopedia.EFFECTOPEDIA.getData().getLiveEffectopediaObjectByExternalID(topic.getLongValue());
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addValueElement(io.newValue("title").setValue(title));
				element.addChild(io.newElement("content").setValue(content));
				if (parent != null)
					element.addValueElement(io.newValue("topic").setValue(Effectopedia.EFFECTOPEDIA.getData().autoExternalID(parent)));
				return element;
			}
		
		
		public final String getAuthor()
			{
				return Users.REGISTERED.get((int) userID).getDisplayName();
			}
		
		public final Stamp getStamp()
			{
				if (stamp == null)
					{
						ArrayList<EditHistoryAction> actions = Effectopedia.EFFECTOPEDIA.getData().getEditHistory().getObjectHistoryMap().get(this.getID());
						if ((actions != null) && (actions.size() > 0))
							stamp = Effectopedia.EFFECTOPEDIA.getStamps().get((int) actions.get(0).getStampId());
					}
				return stamp;
			}
		
		public static DiscussionPosting addPosting(DiscussionPosting value)
			{
				DataSource data = Effectopedia.EFFECTOPEDIA.getData();
				if (data != null)
					data.getLiveIndices().getDiscussion().put(value.getID(), value);
				return value;
			}
		
		public static ArrayList<DiscussionPosting> getPostings(DiscussionTopic topic)
			{
				DataSource data = Effectopedia.EFFECTOPEDIA.getData();
				if (data != null)
					return data.getLiveIndices().getDiscussion().getPostings(topic);
				return null;
			}
		
		@Override
		public void bringToLive()
			{
				super.bringToLive();
				ArrayList<EditHistoryAction> actions = Effectopedia.EFFECTOPEDIA.getData().getEditHistory().getObjectHistoryMap().get(this.getID());
				if ((actions != null) && (actions.size() > 0))
					stamp = Effectopedia.EFFECTOPEDIA.getStamps().get((int) actions.get(0).getStampId());
			}
		
		/* author - a duplicated field extracted form User display name */
		protected long										userID;
		
		protected Stamp									stamp;
		protected String								title;
		protected String								content;
	}

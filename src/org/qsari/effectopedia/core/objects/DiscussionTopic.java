package org.qsari.effectopedia.core.objects;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.BaseIOValue;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultTextProperties;
import org.qsari.effectopedia.system.ActionTypes;

public class DiscussionTopic extends DiscussionPosting implements Importable, Exportable, Cloneable, Traceable
	{
		public DiscussionTopic()
			{
				super();
			}
		
		public DiscussionTopic(EffectopediaObject parent, DataSource dataSource, EffectopediaObject aboutObject, EffectopediaObject userInterfaceObject)
			{
				super(parent, dataSource);
				this.aboutObject = aboutObject;
				this.userInterfaceObject = userInterfaceObject;
			}
		
		public String getSubject()
			{
				if (this.subject == null)
					return DefaultTextProperties.INSTANCE.getDefault("DiscussionTopic.subject");
				else
					return this.subject;
			}
		
		public void setSubject(String subject)
			{
				if (((subject == null) && (this.subject != null)) || ((subject != null) && (!subject.equals(this.subject))))
					{
						beforeUpdate(true, ActionTypes.DT_SUBJECT_AID);
						this.subject = subject;
					}
			}
		
		@Override
				public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if (eoDestintation instanceof DiscussionTopic)
					((DiscussionTopic) eoDestintation).setSubject(this.subject);
			}
		
		public void cloneFieldsTo(DiscussionTopic clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.subject = this.subject;
			}
		
		public DiscussionTopic clone()
			{
				DiscussionTopic clone = new DiscussionTopic(parent, dataSource, aboutObject, userInterfaceObject);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public DiscussionTopic clone(EffectopediaObject parent, DataSource dataSource)
			{
				DiscussionTopic clone = new DiscussionTopic(parent, dataSource, aboutObject, userInterfaceObject);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						subject = element.getValueElement("subject").getValue();
						aboutObject = Effectopedia.EFFECTOPEDIA.getData().getLiveEffectopediaObjectByExternalID(element.getValueElement("aboutObject").getLongValue());
						BaseIOValue el = element.getValueElement("userInterfaceObject");
						if (el != null)
							userInterfaceObject = Effectopedia.EFFECTOPEDIA.getData().getLiveEffectopediaObjectByExternalID(el.getLongValue());
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addValueElement(io.newValue("subject").setValue(subject));
				element.addValueElement(io.newValue("aboutObject").setValue(aboutObject.getExternalID()));
				if (userInterfaceObject != null)
					element.addValueElement(io.newValue("userInterfaceObject").setValue(userInterfaceObject.getExternalID()));
				return element;
			}
		
		public final EffectopediaObject getUserInterfaceObject()
			{
				return userInterfaceObject;
			}
		
		public final void setUserInterfaceObject(EffectopediaObject userInterfaceObject)
			{
				this.userInterfaceObject = userInterfaceObject;
			}
		
		public final EffectopediaObject getAboutObject()
			{
				return aboutObject;
			}
		
		public final void setAboutObject(EffectopediaObject aboutObject)
			{
				this.aboutObject = aboutObject;
			}
		
		public static Object locateORCreateTopic(Object o)
			{
				DataSource data = Effectopedia.EFFECTOPEDIA.getData();
				if (data != null)
					return data.getLiveIndices().getDiscussion().locateORCreateTopic(o);
				return null;
			}
		
		public static DiscussionTopic locateTopic(Object o)
			{
				DataSource data = Effectopedia.EFFECTOPEDIA.getData();
				if (data != null)
					return data.getLiveIndices().getDiscussion().locateTopic(o);
				return null;
			}
		
		public boolean isNew()
			{
				return (title == null) && (content == null) && (subject == null);
			}
		
		protected String																								subject;
		protected EffectopediaObject												userInterfaceObject;
		protected EffectopediaObject												aboutObject;
		protected ReferenceIDs<DiscussionTopic>	relatedTopis;
	}

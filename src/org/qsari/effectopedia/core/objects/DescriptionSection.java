/*
 * 
 */

package org.qsari.effectopedia.core.objects;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultTextProperties;
import org.qsari.effectopedia.system.ActionTypes;

public class DescriptionSection extends EffectopediaObject implements Importable, Exportable, Cloneable, Traceable, Titleable
	{
		public enum ContentFormat
			{
				TEXT("text"), HTML("html"), REMOTE_HTML("remote html");
				
				private ContentFormat(String caption)
					{
						this.caption = caption;
					}
				
				public static ContentFormat getFormatByCaption(String caption)
					{
						switch (Character.toLowerCase(caption.charAt(0)))
							{
								case 'h':
									return HTML;
								case 'r':
									return REMOTE_HTML;
								default:
									return TEXT;
							}
					}
				
				public final String	caption;
			};
		
		public DescriptionSection()
			{
				super();
			}
		
		public DescriptionSection(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
			}
		
		public DescriptionSection(EffectopediaObject parent, DataSource dataSource, String title, String content)
			{
				super(parent, dataSource);
				this.title = title;
				this.content = content;
			}
		
		public String getTitle()
			{
				if (title == null)
					return DefaultTextProperties.INSTANCE.getDefault("DescriptionSection.title");
				else
					return title;
			}
		
		public void setTitle(String title)
			{
				if (((title == null) && (this.title != null)) || (!title.equals(this.title)))
					{
						beforeUpdate(true, ActionTypes.DS_TITLE_AID);
						this.title = title;
					}
			}
		
		public String getContent()
			{
				if (content == null)
					return "Section content";
				else
					return content;
			}
		
		public void setContent(String content)
			{
				if (((content == null) && (this.content != null)) || (!content.equals(this.content)))
					{
						beforeUpdate(true, ActionTypes.DS_CONTENT_AID);
						this.content = content;
					}
			}
		
		public String toString()
			{
				return getTitle();
			}
		
		public ContentFormat getFormat()
			{
				return format;
			}
		
		public boolean isHTML()
			{
				return (format == ContentFormat.HTML) || (format == ContentFormat.REMOTE_HTML);
			}
		
		public boolean isRemote()
			{
				return (format == ContentFormat.REMOTE_HTML);
			}
		
		public DescriptionSection setFormat(ContentFormat format)
			{
				this.format = format;
				return this;
			}
		
		@Override
				public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if (eoDestintation instanceof DescriptionSection)
					{
						((DescriptionSection) eoDestintation).setTitle(this.title);
						((DescriptionSection) eoDestintation).setContent(this.content);
						((DescriptionSection) eoDestintation).originalDefaultID = this.originalDefaultID;
					}
			}

		public void cloneFieldsTo(DescriptionSection clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.title = this.title;
				clone.content = this.content;
				clone.originalDefaultID = this.originalDefaultID;
			}
		
		public DescriptionSection clone()
			{
				DescriptionSection clone = new DescriptionSection(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public DescriptionSection clone(EffectopediaObject parent, DataSource dataSource)
			{
				DescriptionSection clone = new DescriptionSection(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						BaseIOAttribute a = element.getAttribute("OriginalID");
						if (a != null)
							originalDefaultID = a.getLongValue();
						title = element.getValueElement("title").getValue();
						BaseIOElement contentElement = element.getChild("content");
						BaseIOAttribute formatAttribute = contentElement.getAttribute("format");
						if (formatAttribute != null)
							format = ContentFormat.getFormatByCaption(formatAttribute.getValue());
						else
							format = ContentFormat.TEXT;
						content = contentElement.getValue();
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addValueElement(io.newValue("title").setValue(title));
				element.setAttribute("OriginalID", originalDefaultID);
				BaseIOElement contentElement = io.newElement("content");
				if (format == ContentFormat.TEXT)
					contentElement.setValue(content);
				else
					{
						contentElement.setAttribute("format", format.caption);
						contentElement.setData(content);
					}
				element.addChild(contentElement);
				return element;
			}
		
		@SuppressWarnings("unchecked")
		public <T extends EffectopediaObject> T makeItDefault()
			{
				super.makeItDefault();
				originalDefaultID = getDefaultID();
				return (T) this;
			}
		
		public long getOriginalDefaultID()
			{
				return originalDefaultID;
			}

		private long												originalDefaultID;
		private String										title;
		private String										content;
		protected ContentFormat	format	= ContentFormat.TEXT;
		
	}

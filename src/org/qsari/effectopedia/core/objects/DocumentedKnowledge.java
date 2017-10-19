package org.qsari.effectopedia.core.objects;

import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.ids.DescriptionIDs;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.BaseIOValue;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.containers.References.Referable;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.DataValue_String;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.history.EditHistory;
import org.qsari.effectopedia.search.SearchIndices;
import org.qsari.effectopedia.search.SearchableItem;
import org.qsari.effectopedia.system.ActionTypes;
import org.qsari.effectopedia.system.TraceableProperties;

public class DocumentedKnowledge extends PathwayElement implements Importable, Exportable, Cloneable, Traceable, Referable, Titleable
	{
		public DocumentedKnowledge()
			{
				super();
				descriptionIDs = null;
				referenceIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REFERENCES_REFIDS);
				SearchableItem sa = new SearchableItem(this, DN_TITLE_PID, SearchIndices.TITLE_INDEX);
				this.title = new DataValue_String(sa);
				sa = new SearchableItem(this, DN_KEYWORDS_PID, SearchIndices.KEYWORDS_INDEX);
				// this.keywords = new DataValue_List<DataValue_String>(sa,
				// DataValue_String.class);
				if (DefaultEffectopediaObjects.DEFAULT_DOC_KNOWLEDGE_METADATA != null)
					metadata = new ObjectProperties(this, DefaultEffectopediaObjects.DEFAULT_DOC_KNOWLEDGE_METADATA);
			}
			
		public DocumentedKnowledge(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				descriptionIDs = null;
				referenceIDs = DefaultEffectopediaObjects.DEFAULT_REFERENCES_REFIDS.clone(this, dataSource);
				SearchableItem sa = new SearchableItem(this, DN_TITLE_PID, SearchIndices.TITLE_INDEX);
				this.title = new DataValue_String(sa);
				sa = new SearchableItem(this, DN_KEYWORDS_PID, SearchIndices.KEYWORDS_INDEX);
				// this.keywords = new DataValue_List<DataValue_String>(sa,
				// DataValue_String.class);
				if (DefaultEffectopediaObjects.DEFAULT_DOC_KNOWLEDGE_METADATA != null)
					metadata = new ObjectProperties(this, DefaultEffectopediaObjects.DEFAULT_DOC_KNOWLEDGE_METADATA);
			}
			
		@Override
		public void init(boolean asDefaultObject)
			{
				this.metadata = new ObjectProperties(this, DefaultEffectopediaObjects.DEFAULT_DOC_KNOWLEDGE_METADATA);
				updateParenthood();
			}
			
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				if (descriptionIDs != null)
					descriptionIDs.getContainedIDs(containedIDs, includeOwned);
				metadata.getContainedIDs(containedIDs);
				containedIDs.put(referenceIDs.getID(), referenceIDs);
			}
			
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				if (descriptionIDs != null)
					descriptionIDs.getContainedExternalIDs(containedIDs);
				if (metadata != null)
					metadata.getContainedExternalIDs(containedIDs);
				if (referenceIDs != null)
					containedIDs.put(referenceIDs.getExternalID(), referenceIDs);
			}
			
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				descriptionIDs = EffectopediaObject.cloneIfInDefaultObjects(descriptionIDs, this, dataSource);
				referenceIDs = EffectopediaObject.cloneIfInDefaultObjects(referenceIDs, this, dataSource);
			}
			
		@Override
		public void replaceArchivedObjectsWtihClones()
			{
				super.replaceArchivedObjectsWtihClones();
				descriptionIDs = EditHistory.replaceArchivedObjectsWtihClones(descriptionIDs, this, dataSource);
				referenceIDs = EditHistory.replaceArchivedObjectsWtihClones(referenceIDs, this, dataSource);
			}
			
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (descriptionIDs != null)
					descriptionIDs.process(batch);
				if (referenceIDs != null)
					referenceIDs.process(batch);
			}
			
		public void updateParenthood()
			{
				super.updateParenthood();
				descriptionIDs = EffectopediaObject.updateParent(descriptionIDs, this);
				descriptionIDs.updateParenthood();
				referenceIDs = EffectopediaObject.updateParent(referenceIDs, this);
			}
			
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				descriptionIDs = dataSource.get(descriptionIDs.getClass(), descriptionIDs.getID());
				referenceIDs = dataSource.get(referenceIDs.getClass(), referenceIDs.getID());
			}
			
		public void setTitle(String title)
			{
				if (((title == null) && (this.title.getValue() != null)) || (title != null && !title.equals(this.title.getValue())))
					{
						beforeUpdate(true, ActionTypes.DN_TITLE_AID);
						this.title.parseString(title);
						this.generic = false;
					}
			}
			
		public String getKeyWords()
			{
				if (metadata != null)
					{
						ObjectProperty op = metadata.getProperty(DefaultEffectopediaObjects.DEFAULT_KEYWORDS);
						if (op != null)
							return op.getDisplayValue();
					}
				return "";
			}
			
		public void setKeyWords(String keywords)
			{
				if (metadata != null)
					{
						ObjectProperty op = metadata.getProperty(DefaultEffectopediaObjects.DEFAULT_KEYWORDS);
						if (op != null)
							op.setValue(keywords);
					}
			}
			
		public void updateSearchableItems()
			{
				if (title != null)
					this.title.getSearchItem().setObject(this);
				if (metadata != null)
					metadata.setOwner(this);
			}
			
		public DescriptionIDs getDescriptionIDs()
			{
				return this.descriptionIDs;
			}
			
		public ReferenceIDs<Reference> getReferenceIDs()
			{
				return this.referenceIDs;
			}
			
		@Override
		public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if (eoDestintation instanceof DocumentedKnowledge)
					{
						((DocumentedKnowledge) eoDestintation).setTitle(this.title.getValue());
						// ((DocumentedKnowledge)
						// eoDestintation).setKeyWords(this.keywords.getDisplayValue());
						((DocumentedKnowledge) eoDestintation).setMetadata(metadata.clone(eoDestintation, dataSource));
						
						if (assignContainedEO)
							{
								this.descriptionIDs.assignFieldsTo(((DocumentedKnowledge) eoDestintation).getDescriptionIDs(), assignContainedEO);
								this.referenceIDs.assignFieldsTo(((DocumentedKnowledge) eoDestintation).getReferenceIDs(), assignContainedEO);
							}
					}
			}
			
		public void cloneFieldsTo(DocumentedKnowledge clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.title = this.title.clone(clone);
				// clone.keywords = this.keywords.clone(clone);
				clone.setMetadata(metadata.clone(clone, dataSource));
				clone.descriptionIDs = this.descriptionIDs.clone(clone, dataSource);
				clone.referenceIDs = this.referenceIDs.clone(clone, dataSource);
			}
			
		public DocumentedKnowledge clone()
			{
				DocumentedKnowledge clone = new DocumentedKnowledge(getParent(), dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
			
		public DocumentedKnowledge clone(EffectopediaObject parent, DataSource dataSource)
			{
				DocumentedKnowledge clone = new DocumentedKnowledge(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
			
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						title.parseString(element.getValueElement("title").getValue());
						loadKeywordsFromOldRepresentation(element);
						descriptionIDs = io.load(DescriptionIDs.class, descriptionIDs, element.getChild("description"));
						referenceIDs = io.load(ReferenceIDs.class, referenceIDs, element.getChild("reference_ids"));
						metadata.load(element.getChild("metadata"), io);
					}
			}
			
		private void loadKeywordsFromOldRepresentation(BaseIOElement element)
			{
				BaseIOValue kw = element.getValueElement("keywords");
				if (kw != null)
					{
						String kwValue = kw.getValue();
						if ((kwValue != null) && (kwValue.length() > 0))
							setKeyWords(kwValue);
					}
			}
			
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
				descriptionIDs.updateExternalID(element.getChild("description"));
				referenceIDs.updateExternalID(element.getChild("reference_ids"));
				metadata.updateExternalID(element.getChild("metadata"));
			}
			
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addValueElement(io.newValue("title").setValue(title.toString()));
				// element.addValueElement(io.newValue("keywords").setValue(keywords.toString()));
				element.addChild(descriptionIDs.store(io.newElement("description"), io));
				element.addChild(referenceIDs.store(io.newElement("reference_ids"), io));
				element.addChild(metadata.store(io.newElement("metadata"), io));
				return element;
			}
			
		public ObjectProperties getMetadata()
			{
				return metadata;
			}
			
		public void setMetadata(ObjectProperties metadata)
			{
				this.metadata = metadata;
			}
			
		public static final long										DN_TITLE_PID				= TraceableProperties.REGISTERED.add("title", "", DocumentedKnowledge.class);
		public static final long										DN_KEYWORDS_PID	= TraceableProperties.REGISTERED.add("keywords modified", "", DocumentedKnowledge.class);
		
		// protected DataValue_List<DataValue_String> keywords;
		protected ObjectProperties								metadata;
		protected DescriptionIDs										descriptionIDs;
		protected ReferenceIDs<Reference>	referenceIDs;
	}

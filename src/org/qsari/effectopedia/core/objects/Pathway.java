package org.qsari.effectopedia.core.objects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.QualityAssured;
import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.ids.DescriptionIDs;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIO.DataPattern;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.BaseIOValue;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.ExtensibleIO;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.containers.References.Referable;
import org.qsari.effectopedia.core.object.elemets.EssetialityDescription;
import org.qsari.effectopedia.core.object.elemets.QualityAssurance;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.DataSourceMerge;
import org.qsari.effectopedia.data.objects.DataValue_List;
import org.qsari.effectopedia.data.objects.DataValue_String;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.defaults.DefaultTextProperties;
import org.qsari.effectopedia.history.EditHistory;
import org.qsari.effectopedia.search.SearchIndices;
import org.qsari.effectopedia.search.SearchableItem;
import org.qsari.effectopedia.system.ActionTypes;
import org.qsari.effectopedia.system.TraceableProperties;

public class Pathway extends EffectopediaObject implements Importable, Exportable, Cloneable, Traceable, QualityAssured, Referable, Titleable
	{
		
		public Pathway()
			{
				super();
				descriptionIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_PATHWAY_IDS);
				referenceIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REFERENCES_REFIDS);
				descriptionIDs.setParent(this);
				referenceIDs.setParent(this);
				SearchableItem sa = new SearchableItem(this, P_TITLE_PID, SearchIndices.TITLE_INDEX);
				this.title = new DataValue_String(sa);
				sa = new SearchableItem(this, P_KEYWORDS_PID, SearchIndices.KEYWORDS_INDEX);
				this.keywords = new DataValue_List<DataValue_String>(sa, DataValue_String.class);
				sa = new SearchableItem(this, P_GROUPS_PID, SearchIndices.GROUP_INDEX);
				this.groups = new DataValue_List<DataValue_String>(sa, DataValue_String.class);
				sa = new SearchableItem(this, P_UIDS, SearchIndices.UIDS);
				this.uids = new DataValue_List<DataValue_String>(sa, DataValue_String.class);
				qa = new QualityAssurance(this);
				sa = new SearchableItem(this, P_STATUS, SearchIndices.STATUS);
				this.status = new DataValue_List<DataValue_String>(sa, DataValue_String.class);
				elements = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_PATHWAY_ELEMENT_IDS);
				segmentRoots = new ArrayList<PathwayElement>();
			}
			
		public Pathway(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_PATHWAY_IDS.clone(this, dataSource);
				referenceIDs = DefaultEffectopediaObjects.DEFAULT_REFERENCES_REFIDS.clone(this, dataSource);
				SearchableItem sa = new SearchableItem(this, P_TITLE_PID, SearchIndices.TITLE_INDEX);
				this.title = new DataValue_String(sa);
				sa = new SearchableItem(this, P_KEYWORDS_PID, SearchIndices.KEYWORDS_INDEX);
				this.keywords = new DataValue_List<DataValue_String>(sa, DataValue_String.class);
				sa = new SearchableItem(this, P_GROUPS_PID, SearchIndices.GROUP_INDEX);
				this.groups = new DataValue_List<DataValue_String>(sa, DataValue_String.class);
				sa = new SearchableItem(this, P_UIDS, SearchIndices.UIDS);
				this.uids = new DataValue_List<DataValue_String>(sa, DataValue_String.class);
				sa = new SearchableItem(this, P_STATUS, SearchIndices.STATUS);
				this.status = new DataValue_List<DataValue_String>(sa, DataValue_String.class);
				qa = new QualityAssurance(this);
				elements = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_PATHWAY_ELEMENT_IDS);
				segmentRoots = new ArrayList<PathwayElement>();
			}
			
		@Override
		public void init(boolean asDefaultObject)
			{
				elements = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_PATHWAY_ELEMENT_IDS);
				updateParenthood();
			}
			
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				descriptionIDs.getContainedIDs(containedIDs, includeOwned);
				containedIDs.put(referenceIDs.getID(), referenceIDs);
				containedIDs.put(elements.getID(), elements);
				if (trueElementsLoaded && includeOwned)
					for (PathwayElement e : elements.getObjects())
						e.getContainedIDs(containedIDs, includeOwned);
			}
			
		@Override
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				descriptionIDs.getContainedExternalIDs(containedIDs);
				containedIDs.put(referenceIDs.getExternalID(), referenceIDs);
				containedIDs.put(elements.getExternalID(), elements);
				if (trueElementsLoaded)
					for (PathwayElement e : elements.getObjects())
						e.getContainedExternalIDs(containedIDs);
			}
			
		@Override
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
			
		@Override
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (descriptionIDs != null)
					descriptionIDs.process(batch);
				if (referenceIDs != null)
					referenceIDs.process(batch);
				if (batch.getOptions() == BatchProcessor.PROCESS_ALL)
					for (PathwayElement e : elements.getObjects())
						e.process(batch);
			}
			
		@Override
		public void updateParenthood()
			{
				descriptionIDs = EffectopediaObject.cloneIfDefault(descriptionIDs, this, dataSource);
				referenceIDs = EffectopediaObject.cloneIfDefault(referenceIDs, this, dataSource);
				for (PathwayElement e : elements.getObjects())
					e.setParent(this);
			}
			
		public String getTitle()
			{
				String titleString = null;
				if (title != null)
					titleString = title.toString();
				if ((titleString == null) || (titleString.length() == 0))
					return DefaultTextProperties.INSTANCE.getDefault(getClass().getSimpleName() + ".title");
				else
					return titleString;
			}
			
		public SearchableItem getSearchableItem()
			{
				return (title != null) ? title.getSearchItem() : null;
			}
			
		public void setTitle(String title)
			{
				if (((title == null) && (this.title.getValue() != null)) || (title != null && !title.equals(this.title.getValue())))
					{
						beforeUpdate(true, ActionTypes.P_TITLE_AID);
						this.title.parseString(title);
					}
			}
			
		public String getKeyWords()
			{
				String keywordsString = null;
				if (keywords != null)
					keywordsString = keywords.toString();
				if (keywordsString == null)
					return " ";
				else
					return keywordsString;
			}
			
		public void setKeyWords(String keywords)
			{
				if (((keywords == null) && (this.keywords.getValue() != null)) || (keywords != null && !keywords.equals(this.keywords.getValue())))
					{
						beforeUpdate(true, ActionTypes.P_KEYWORDS_AID);
						this.keywords.parseString(keywords);
					}
			}
			
		public void updateSearchableItems()
			{
				if (title != null)
					this.title.getSearchItem().setObject(this);
				if (keywords != null)
					this.keywords.getSearchItem().setObject(this);
			}
			
		public DescriptionIDs getDescriptionIDs()
			{
				return descriptionIDs;
			}
			
		public ReferenceIDs<Reference> getReferenceIDs()
			{
				return this.referenceIDs;
			}
			
		public QualityAssurance getQA()
			{
				return qa;
			}
			
		public void setQA(QualityAssurance qualityAssurance)
			{
				this.qa = qualityAssurance;
			}
			
		@Override
		public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if (eoDestintation instanceof Pathway)
					{
						((Pathway) eoDestintation).setTitle(this.title.getValue());
						((Pathway) eoDestintation).setKeyWords(this.keywords.getDisplayValue());
						((Pathway) eoDestintation).setGroups(this.groups);
						((Pathway) eoDestintation).setUids(this.uids.getDisplayValue());
						((Pathway) eoDestintation).setStatus(this.status.getDisplayValue());
						if (assignContainedEO)
							{
								this.descriptionIDs.assignFieldsTo(((Pathway) eoDestintation).getDescriptionIDs(), assignContainedEO);
								this.referenceIDs.assignFieldsTo(getReferenceIDs(), assignContainedEO);
								this.elements.assignFieldsTo(((Pathway) eoDestintation).elements, assignContainedEO);
							}
					}
			}
			
		public void cloneFieldsTo(Pathway clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.title = this.title.clone(clone);
				clone.keywords = this.keywords.clone(clone);
				clone.groups = this.groups.clone(clone);
				clone.uids = this.uids.clone(clone);
				clone.status = this.status.clone(clone);
				clone.descriptionIDs = this.descriptionIDs.clone(clone, dataSource);
				clone.referenceIDs = this.referenceIDs.clone(clone, dataSource);
				clone.elements = this.elements.clone(clone, dataSource);
			}
			
		public void cloneFieldsExceptTitleTo(Pathway clone, DataSource dataSource, String newTitle)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.title.setValue(newTitle);
				clone.keywords = this.keywords.clone(clone);
				clone.groups = this.groups.clone(clone);
				clone.uids = this.uids.clone(clone);
				clone.status = this.status.clone(clone);
				clone.descriptionIDs = this.descriptionIDs.clone(clone, dataSource);
				clone.referenceIDs = this.referenceIDs.clone(clone, dataSource);
				clone.elements = this.elements.clone(clone, dataSource);
			}
			
		public Pathway clone()
			{
				Pathway clone = new Pathway();
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
			
		public Pathway clone(EffectopediaObject parent, DataSource dataSource)
			{
				Pathway clone = new Pathway(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
			
		public Pathway deepClone(EffectopediaObject parent, DataSource dataSource)
			{
				Pathway clone = new Pathway();
				cloneFieldsTo(clone, dataSource);
				for (PathwayElement e : elements.getObjects())
					clone.elements.add(e.clone(clone, dataSource));
				if (EffectopediaObject.ID_OFFSET == 0)
					clone.process(EffectopediaObject.BatchUpdateClonedReferrals.INSTANCE);
				clone.setDataSource(dataSource);
				return clone;
			}
			
		public Pathway createDeepCloneWithNewTitles(EffectopediaObject parent, DataSource dataSource, String titlePrffix, String titleSuffix, String elementTitlePrffix, String elementTitleSuffix)
			{
				Pathway dc = new Pathway(parent, dataSource);
				cloneFieldsExceptTitleTo(dc, dataSource, titlePrffix + getTitle() + titleSuffix);
				for (PathwayElement e : elements.getObjects())
					if (!(e instanceof Initiator))
						{
							PathwayElement newElement = e.clone(dc, dataSource);
							if (e.title.getValue() != null)
								newElement.setTitle(elementTitlePrffix + e.getTitle() + elementTitleSuffix);
							newElement.getPathwayIDs().remove(this);
							dc.add(newElement);
						}
					else
						dc.add(e);
				return dc;
			}
			
		public void updateReferrals(DataSourceMerge dsm)
			{
				super.updateReferrals(dsm);
				elements.updateReferrals(dsm);
			}
			
		public ReferenceIDs<PathwayElement> getElements()
			{
				return elements;
			}
			
		public void setElements(ArrayList<PathwayElement> elements)
			{
				this.elements.setAll(elements);
			}
			
		public String getElementsDescription(int maxLength)
			{
				final String DELIMITER = ", ";
				if (elements != null)
					{
						StringBuilder description = new StringBuilder();
						for (PathwayElement e : elements.getObjects())
							if (!(e instanceof Link))
								{
									description.append(e.getTitle());
									if ((maxLength > 0) && (description.length() > maxLength))
										{
											description.delete(maxLength - 3, description.length());
											description.append("...");
											description.append(DELIMITER);
											break;
										}
									description.append(DELIMITER);
								}
						if (description.length() > 0)
							description.delete(description.length() - DELIMITER.length(), description.length());
						return description.toString();
					}
				return null;
			}
			
		public void updateSegmentRoots()
			{
				segmentRoots.clear();
				for (PathwayElement element : elements.getObjects())
					if (!element.hasIncommingAssociations(getID()) && !(element.hasIncommingMappings()) && !(element instanceof Method))
						segmentRoots.add(element);
			}
			
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				descriptionIDs = dataSource.get(descriptionIDs.getClass(), descriptionIDs.getID());
				referenceIDs = dataSource.get(referenceIDs.getClass(), referenceIDs.getID());
				elements = dataSource.get(elements.getClass(), elements.getID());
				if (dataSource != null)
					{
						int count = elements.size();
						
						for (int i = 0; i < count; i++)
							{
								PathwayElement pe = elements.getCachedObject(i);
								long elementID = pe.getID();
								if (elementID == 0)
									elements.set(pe = (PathwayElement) dataSource.getEffectopediaObjectByExternalID(pe.getExternalID()), i);
								else
									elements.set(pe = dataSource.get(pe.getClass(), elementID), i);
								// if (dataSource.get(pe.getClass(), pe.getID()) == null)
								// System.err.println("Error in Pathway.reloadReferredObjectsFromID the
								// method did not find object for:"
								// + pe.getClass() + "\t" + pe.getID());
							}
					}
				trueElementsLoaded = true;
			}
			
		public void sortElements()
			{
				if (sorted)
					return;
				updateSegmentRoots();
				ArrayList<PathwayElement> el = elements.getObjects();
				elements.clear();
				for (PathwayElement root : segmentRoots)
					addElements(root, el);
				if (el.size() != 0)
					{
						System.out.println("Disconnected fragments!");
						for (PathwayElement e : el)
							System.out.print(e.getIDsDescription());
					}
				sorted = true;
			}
			
		public void updateEssentiality()
			{
				if (!sorted)
					sortElements();
				if (essentiality == null)
					essentiality = new EssetialityDescription(descriptionIDs);
				essentiality.addPathwayElements(elements.getObjects());
				essentiality.sort(elements.getObjects());
			}
			
		public void addElements(PathwayElement root, ArrayList<PathwayElement> el)
			{
				long pathwayID = getID();
				LinkedList<PathwayElement> oe = new LinkedList<PathwayElement>();
				oe.add(root);
				while (oe.size() > 0)
					{
						PathwayElement element = oe.getFirst();
						oe.removeFirst();
						if (element.hasOutgoingAssociations())
							{
								PathwayElement[] outgoing = element.outgoingAssociations();
								for (int e = 0; e < outgoing.length; e++)
									if (outgoing[e].belongsTo(pathwayID))
										oe.add(outgoing[e]);
							}
						el.remove(element);
						if (elements.getIndexOf(element) == -1)
							elements.internalAdd(element);
					}
			}
			
		public Link findLink(PathwayElement e1, PathwayElement e2)
			{
				if (e1.hasOutgoingAssociations() && e2.hasIncommingAssociations())
					{
						PathwayElement[] out = e1.outgoingAssociations();
						PathwayElement[] in = e2.incommingAssociations();
						for (int i = 0; i < out.length; i++)
							for (int j = 0; j < in.length; j++)
								if ((out[i] == in[j]) && (out[i].getPathwayIDs().contains(this) != -1))
									return (Link) out[i];
					}
				return null;
			}
			
		public ArrayList<PathwayElement> getSegmentRoots()
			{
				return segmentRoots;
			}
			
		public void setSegmentRoots(ArrayList<PathwayElement> segmentRoots)
			{
				this.segmentRoots = segmentRoots;
			}
			
		public static void link(PathwayElement cause, PathwayElement consequence)
			{
				consequence.link_Up(cause);
				cause.link_Down(consequence);
			}
			
		public static void unlink(Pathway pathway, PathwayElement cause, PathwayElement consequence)
			{
				if ((pathway != null) && (cause != null) && (consequence != null))
					{
						Link link = pathway.findLink(cause, consequence);
						if (link == null)
							return;
						link.getPathwayIDs().remove(pathway);
						pathway.disassociate(link);
						link.unlink_Down(consequence);
						link.unlink_Up(cause);
						consequence.unlink_Up(cause);
						cause.unlink_Down(consequence);
					}
			}
			
		public static void unlink(PathwayElement cause, PathwayElement consequence)
			{
				if ((cause != null) && (consequence != null))
					{
						consequence.unlink_Up(cause);
						cause.unlink_Down(consequence);
					}
			}
			
		public static void link(PathwayElement cause, Link link, PathwayElement consequence)
			{
				link.link_Down(consequence);
				link.link_Up(cause);
				cause.link_Down(link);
				consequence.link_Up(link);
			}
			
		public static void unlink(PathwayElement cause, Link link, PathwayElement consequence)
			{
				link.unlink_Down(consequence);
				link.unlink_Up(cause);
				cause.unlink_Down(link);
				consequence.unlink_Up(link);
			}
			
		public static void map(PathwayElement effect, TestResponseMapping trm, PathwayElement test)
			{
				trm.map(test);
				trm.map(effect);
				effect.map(trm);
				test.map(trm);
			}
			
		public static void unmap(PathwayElement effect, TestResponseMapping trm, PathwayElement test)
			{
				trm.unmap(effect);
				trm.unmap(test);
				effect.unmap(trm);
				test.unmap(trm);
			}
			
		public static PathwayElement getDirektLink(PathwayElement upstreamElement, PathwayElement downstreamElement)
			{
				if ((upstreamElement == null) || (downstreamElement == null))
					return null;
				PathwayElement[] uElements = upstreamElement.outgoingAssociations();
				PathwayElement[] dElements = downstreamElement.incommingAssociations();
				for (int i = uElements.length - 1; i >= 0; i--)
					for (int j = dElements.length - 1; j >= 0; j--)
						if (uElements[i] == dElements[j])
							return uElements[i];
				return null;
			}
			
		private static boolean onPath(Set<PathwayElement> elements, PathwayElement ue)
			{
				if (ue.hasOutgoingAssociations())
					{
						boolean isOnPath = false;
						PathwayElement[] uElements = ue.outgoingAssociations();
						for (int i = 0; i < uElements.length; i++)
							{
								if (elements.contains(uElements[i]))
									isOnPath = isOnPath || (uElements[i].getTag() == 0) ? false : true;
								else
									isOnPath = isOnPath || onPath(elements, uElements[i]);
							}
						ue.setTag(isOnPath ? 1 : 0);
						// System.out.println(((DocumentedKnowledge) ue).getTitle() + " tag =" +
						// ue.getTag());
						elements.add(ue);
						return isOnPath;
					}
				else
					{
						ue.setTag(0);
						// System.out.println(((DocumentedKnowledge) ue).getTitle() + " tag =" +
						// ue.getTag());
						elements.add(ue);
						return false;
					}
			}
			
		public static PathwayElement[] getPathElements(PathwayElement ue, PathwayElement de)
			{
				Set<PathwayElement> elements = new HashSet<PathwayElement>();
				de.setTag(1);
				elements.add(de);
				// PathwayElement[] etest = de.outgoingAssociations();
				// System.out.println(((DocumentedKnowledge) de).getTitle() + " tag =" +
				// de.getTag());
				if (onPath(elements, ue))
					{
						ArrayList<PathwayElement> onPathElements = new ArrayList<PathwayElement>();
						Iterator<PathwayElement> it = elements.iterator();
						while (it.hasNext())
							{
								PathwayElement e = it.next();
								if (e.getTag() == 1)
									onPathElements.add(e);
							}
						return onPathElements.toArray(new PathwayElement[onPathElements.size()]);
					}
				else
					return null;
			}
			
		public void associate(PathwayElement element)
			{
				if (element != null)
					{
						this.elements.add(element);
						sorted = false;
						element.mergeWith(this);
					}
			}
			
		public void add(PathwayElement element)
			{
				if ((element != null) && (elements.getIndexOf(element) == -1))
					{
						this.elements.add(element);
						element.pathwayIDs.addIfDifferent(this);
						sorted = false;
					}
			}
			
		public void associateUpstream(PathwayElement element)
			{
				if (element != null)
					{
						PathwayElement[] incomming = element.incommingAssociations();
						if (incomming != null)
							for (int i = 0; i < incomming.length; i++)
								associateUpstream(incomming[i]);
						PathwayElement[] outgoing = element.outgoingMappings();
						if (outgoing != null)
							for (int i = 0; i < outgoing.length; i++)
								associateUpstream(outgoing[i]);
						if (!element.belongsTo(this.getID()))
							element.pathwayIDs.add(this);
						if (this.elements.getIndexOf(element) == -1)
							{
								this.elements.add(element);
								sorted = false;
							}
					}
			}
			
		public void addMissingElements()
			{
				for (PathwayElement element : segmentRoots)
					checkForMissingElements(element);
				
			}
			
		private void checkForMissingElements(PathwayElement element)
			{
				long thisID = this.getID();
				if ((element != null) && (element.belongsTo(thisID)))
					{
						if (this.elements.getIndexOf(element) == -1)
							{
								this.elements.add(element);
								sorted = false;
							}
						PathwayElement[] outgoing = element.outgoingAssociations();
						if (outgoing != null)
							for (int i = 0; i < outgoing.length; i++)
								checkForMissingElements(outgoing[i]);
						outgoing = element.outgoingMappings();
						if (outgoing != null)
							for (int i = 0; i < outgoing.length; i++)
								checkForMissingElements(outgoing[i]);
					}
					
				PathwayElement[] outgoing = element.outgoingMappings();
				if (outgoing != null)
					for (int i = 0; i < outgoing.length; i++)
						if ((outgoing[i].belongsTo(thisID)) && (this.elements.getIndexOf(element) == -1))
							{
								this.elements.add(element);
								sorted = false;
							}
			}
			
		public void associateDownstream(PathwayElement element)
			{
				if (element != null)
					{
						if (this.elements.getIndexOf(element) == -1)
							{
								this.elements.add(element);
								sorted = false;
							}
						if (!element.belongsTo(this.getID()))
							element.pathwayIDs.add(this);
						PathwayElement[] outgoing = element.outgoingAssociations();
						if (outgoing != null)
							for (int i = 0; i < outgoing.length; i++)
								associateDownstream(outgoing[i]);
						outgoing = element.outgoingMappings();
						if (outgoing != null)
							for (int i = 0; i < outgoing.length; i++)
								associateUpstream(outgoing[i]);
					}
			}
			
		public void disassociate(PathwayElement element)
			{
				if (element != null)
					{
						this.elements.remove(element);
						element.pathwayIDs.remove(this);
						sorted = false;
					}
			}
			
		public void disassociateUpstream(PathwayElement element)
			{
				if (element != null)
					{
						PathwayElement[] incomming = element.incommingAssociations();
						if (incomming != null)
							for (int i = 0; i < incomming.length; i++)
								disassociateUpstream(incomming[i]);
						PathwayElement[] outgoing = element.outgoingMappings();
						if (outgoing != null)
							for (int i = 0; i < outgoing.length; i++)
								disassociateUpstream(outgoing[i]);
						this.elements.remove(element);
						element.pathwayIDs.remove(this);
						sorted = false;
					}
			}
			
		public void disassociateDownstream(PathwayElement element)
			{
				if (element != null)
					{
						this.elements.remove(element);
						element.pathwayIDs.remove(this);
						sorted = false;
						PathwayElement[] outgoing = element.outgoingAssociations();
						if (outgoing != null)
							for (int i = 0; i < outgoing.length; i++)
								disassociateDownstream(outgoing[i]);
						outgoing = element.outgoingMappings();
						if (outgoing != null)
							for (int i = 0; i < outgoing.length; i++)
								disassociateUpstream(outgoing[i]);
					}
			}
			
		public static void replace(DocumentedKnowledge_Located oldLocatedPathwayElement, DocumentedKnowledge_Located newLocatedPathwayElement, ArrayList<Pathway> visiblePathways)
			{
				if ((oldLocatedPathwayElement != null) && (newLocatedPathwayElement != null))
					if ((visiblePathways != null) && (visiblePathways.size() > 0))
						for (Pathway p : visiblePathways)
							{
								if (p.elements.getIndexOf(oldLocatedPathwayElement) != -1)
									{
										replace(oldLocatedPathwayElement, newLocatedPathwayElement);
										p.disassociate(oldLocatedPathwayElement);
										oldLocatedPathwayElement.pathwayIDs.removeIfPresent(p);
										p.add(newLocatedPathwayElement);
										newLocatedPathwayElement.pathwayIDs.addIfDifferent(p);
									}
							}
					else
						replace(oldLocatedPathwayElement, newLocatedPathwayElement);
			}
			
		public static void replace(Initiator oldSubstance, Initiator newSubstance, ArrayList<Pathway> visiblePathways)
			{
				if ((oldSubstance != null) && (newSubstance != null))
					if ((visiblePathways != null) && (visiblePathways.size() > 0))
						for (Pathway p : visiblePathways)
							{
								if (p.elements.getIndexOf(oldSubstance) != -1)
									{
										replace(oldSubstance, newSubstance);
										p.disassociate(oldSubstance);
										oldSubstance.pathwayIDs.removeIfPresent(p);
										p.add(newSubstance);
										newSubstance.pathwayIDs.addIfDifferent(p);
									}
							}
					else
						replace(oldSubstance, newSubstance);
			}
			
		private static void replace(PathwayElement oldElement, PathwayElement newElement)
			{
				PathwayElement[] incoming = oldElement.incommingAssociations();
				PathwayElement[] outgoing = oldElement.outgoingAssociations();
				if (outgoing != null)
					for (int i = 0; i < outgoing.length; i++)
						{
							PathwayElement[] o = (outgoing[i] != null) ? outgoing[i].outgoingAssociations() : null;
							if ((o != null) && (o.length == 1))
								{
									unlink(oldElement, (Link) outgoing[i], o[0]);
									link(newElement, (Link) outgoing[i], o[0]);
								}
						}
				if (incoming != null)
					for (int i = 0; i < incoming.length; i++)
						{
							PathwayElement[] ia = (incoming[i] != null) ? incoming[i].incommingAssociations() : null;
							if ((ia != null) && (ia.length == 1))
								{
									unlink(ia[0], (Link) incoming[i], oldElement);
									link(ia[0], (Link) incoming[i], newElement);
								}
						}
				incoming = oldElement.incommingMappings();
				outgoing = oldElement.outgoingMappings();
				if (outgoing != null)
					for (int i = 0; i < outgoing.length; i++)
						{
							PathwayElement[] o = (outgoing[i] != null) ? outgoing[i].outgoingMappings() : null;
							if ((o != null) && (o.length == 1))
								{
									unmap(oldElement, (TestResponseMapping) outgoing[i], o[0]);
									map(newElement, (TestResponseMapping) outgoing[i], o[0]);
								}
						}
				if (incoming != null)
					for (int i = 0; i < incoming.length; i++)
						{
							PathwayElement[] ia = (incoming[i] != null) ? incoming[i].incommingMappings() : null;
							if ((ia != null) && (ia.length == 1))
								{
									unmap(ia[0], (TestResponseMapping) incoming[i], oldElement);
									map(ia[0], (TestResponseMapping) incoming[i], newElement);
								}
						}
			}
			
		public static void substitute(PathwayElement oldElement, PathwayElement newElement)
			{
				replace(oldElement, newElement);
				if (oldElement.isGeneric())
					{
						ReferenceIDs<Pathway> pathways = oldElement.getPathwayIDs();
						for (Pathway p : pathways.getObjects())
							{
								if (p != null)
									{
										p.disassociate(oldElement);
										p.associate(newElement);
									}
							}
						Effectopedia.EFFECTOPEDIA.getData().remove(oldElement);
					}
			}
			
		public String toString()
			{
				return getTitle();
			}
			
		public Pathway makeItReadonly()
			{
				setReadonly(true);
				for (PathwayElement e : elements.getObjects())
					e.setReadonly(true);
				return this;
			}
			
		public String DEBUG_getIDs()
			{
				StringBuilder sb = new StringBuilder();
				sb.append(super.DEBUG_getIDs());
				sb.append("\telements(");
				sb.append(elements.size());
				sb.append(")\t");
				for (PathwayElement e : elements.getObjects())
					{
						sb.append("\t");
						sb.append(e.DEBUG_getIDs());
					}
				return sb.toString();
			}
			
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						title.parseString(element.getValueElement("title").getValue());
						keywords.parseString(element.getValueElement("keywords").getValue());
						BaseIOValue property = element.getValueElement("groups");
						if (property != null)
							groups.parseString(property.getValue());
						property = element.getValueElement("uids");
						if (property != null)
							uids.parseString(property.getValue());
						property = element.getValueElement("status");
						if (property != null)
							status.parseString(property.getValue());
						descriptionIDs = io.load(DescriptionIDs.class, descriptionIDs, element.getChild("description"));
						referenceIDs = io.load(ReferenceIDs.class, referenceIDs, element.getChild("reference_ids"));
						if (io.getDataPattern() == DataPattern.RUSSIAN_DOLL)
							loadElements(element.getChild("elements"), io);
						else
							loadElementIDs(element.getChild("element_ids"), io);
					}
			}
			
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
				descriptionIDs.updateExternalID(element.getChild("description"));
				referenceIDs.updateExternalID(element.getChild("reference_ids"));
			}
			
		private void loadElements(BaseIOElement element, BaseIO io)
			{
				if (element == null)
					return;
				EffectopediaObject.loadIDs(elements, element, io);
				Effectopedia.EFFECTOPEDIA.getData().add(elements.getClass(), elements);
				int count = Integer.parseInt(element.getAttributeValue("count"));
				List<BaseIOElement> children = element.getChildren();
				if ((count != 0) && (children != null) && (children.size() == count))
					{
						trueElementsLoaded = true;
						Iterator<BaseIOElement> iterator = children.iterator();
						while (iterator.hasNext())
							{
								BaseIOElement child = (BaseIOElement) iterator.next();
								try
									{
										Class<?> cl = Class.forName(child.getName());
										PathwayElement pe = (PathwayElement) io.load(cl, null, child);
										// System.out.println("PathwayElement(" + pe.getClass() + ")" +
										// pe.getExternalID() + " loaded");
										/*
										 * long id = pe.getID(); System.out.print(pe.getClass() + "ID=\t" +
										 * pe.getID() + "\tExternalID=\t" + pe.getExternalID() +
										 * "\tDefaultID=\t" + pe.getDefaultID()); if (pe instanceof
										 * Link_SubstanceToMIE) System.out.print("\tsubstance=\t" +
										 * ((Link_SubstanceToMIE) pe).getSubstance().getReferenceID() +
										 * "\teffect=\t" + ((Link_SubstanceToMIE)
										 * pe).getEffect().getReferenceID()); if (pe instanceof
										 * Link_EffectToEffect) System.out.print("\tfrom effect=\t" +
										 * ((Link_EffectToEffect) pe).getFromEffect().getReferenceID() +
										 * "\tto effect=\t" + ((Link_EffectToEffect)
										 * pe).getToEffect().getReferenceID());
										 * System.out.print("\tincomming=\t" +
										 * Arrays.toString(pe.incommingAssociations()));
										 * System.out.print("\toutgoing=\t" +
										 * Arrays.toString(pe.outgoingAssociations()));
										 * System.out.println("\tpathway=\t" +
										 * Arrays.toString(pe.getPathwayIDs().getCachedIDs()));
										 */
										pe.setParent(this);
										elements.internalLoad(pe);
									}
								catch (ClassNotFoundException cnfe)
									{
										cnfe.printStackTrace();
									}
							}
					}
			}
			
		private void loadElementIDs(BaseIOElement element, BaseIO io)
			{
				if (element == null)
					return;
				EffectopediaObject.loadIDs(elements, element, io);
				Effectopedia.EFFECTOPEDIA.getData().add(elements.getClass(), elements);
				int count = Integer.parseInt(element.getAttributeValue("count"));
				List<BaseIOElement> children = element.getChildren();
				if ((count != 0) && (children != null) && (children.size() == count))
					{
						trueElementsLoaded = false;
						Iterator<BaseIOElement> iterator = children.iterator();
						while (iterator.hasNext())
							{
								BaseIOElement child = (BaseIOElement) iterator.next();
								try
									{
										Class<?> cl = Class.forName(child.getName());
										PathwayElement pe = (PathwayElement) cl.newInstance();
										pe.setExternalID(child.getAttribute("id").getLongValue());
										pe.setParent(this);
										elements.internalLoad(pe);
									}
								catch (ClassNotFoundException cnfe)
									{
										cnfe.printStackTrace();
									}
								catch (InstantiationException e)
									{
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								catch (IllegalAccessException e)
									{
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							}
					}
			}
			
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addValueElement(io.newValue("title").setValue(title.toString()));
				element.addValueElement(io.newValue("keywords").setValue(keywords.toString()));
				element.addValueElement(io.newValue("groups").setValue(groups.toString()));
				element.addValueElement(io.newValue("uids").setValue(uids.toString()));
				element.addValueElement(io.newValue("status").setValue(status.toString()));
				element.addChild(descriptionIDs.store(io.newElement("description"), io));
				if (io instanceof ExtensibleIO)
					{
						String diagram = ((ExtensibleIO)io).getNamedValue(this, "diagram");
						if ((diagram!=null)&&(diagram.length()>0))
				   element.addValueElement(io.newValue("diagram").setData(diagram));
					}
				element.addChild(referenceIDs.store(io.newElement("reference_ids"), io));
				sortElements();
				if (io.getDataPattern() == DataPattern.RUSSIAN_DOLL)
					element.addChild(storeElements(element, io));
				else
					element.addChild(storeElementIDs(element, io));
				return element;
			}
			
		public BaseIOElement storeElements(BaseIOElement element, BaseIO io)
			{
				BaseIOElement els = io.newElement("elements");
				EffectopediaObject.storeIDs(elements, els, io);
				els.setAttribute("count", String.valueOf(elements.size()));
				for (PathwayElement e : elements.getObjects())
					els.addChild(e.store(io.newElement(e.getClass().getName()), io));
				return els;
			}
			
		public BaseIOElement storeElementIDs(BaseIOElement element, BaseIO io)
			{
				BaseIOElement els = io.newElement("element_ids");
				EffectopediaObject.storeIDs(elements, els, io);
				els.setAttribute("count", String.valueOf(elements.size()));
				for (PathwayElement e : elements.getObjects())
					els.addChild(EffectopediaObject.storeIDs(e, io.newElement(e.getClass().getName()), io));
				return els;
			}
			
		public EssetialityDescription getEssentiality()
			{
				return essentiality;
			}
			
		public void setEssentiality(EssetialityDescription essentiality)
			{
				this.essentiality = essentiality;
			}
			
		public DataValue_List<DataValue_String> getGroups()
			{
				return groups;
			}
			
		public void setGroups(DataValue_List<DataValue_String> groups)
			{
				this.groups = groups;
			}
			
		public DataValue_List<DataValue_String> getUids()
			{
				return uids;
			}
			
		public void setUids(String uids)
			{
				if (((uids == null) && (this.uids.getValue() != null)) || (uids != null && !uids.equals(this.uids.getValue())))
					{
						beforeUpdate(true, ActionTypes.P_UIDS_AID);
						this.uids.parseString(uids);
					}
			}
			
		public DataValue_List<DataValue_String> getStatus()
			{
				return status;
			}
			
		public void setStatus(String status)
			{
				if (((status == null) && (this.status.getValue() != null)) || (status != null && !status.equals(this.status.getValue())))
					{
						beforeUpdate(true, ActionTypes.P_UIDS_AID);
						this.status.parseString(status);
					}
			}
			
		public Effect_MolecularInitiatingEvent getMIE()
			{
				for (PathwayElement pe : elements.getCachedObjects())
					if (pe instanceof Effect_MolecularInitiatingEvent)
						return (Effect_MolecularInitiatingEvent) pe;
				return null;
			}

		public Effect_AdverseOutcome getAO()
			{
				for (PathwayElement pe : elements.getCachedObjects())
					if (pe instanceof Effect_AdverseOutcome)
						return (Effect_AdverseOutcome) pe;
				return null;
			}
			
		private boolean																												sorted													= true;
		private boolean																												trueElementsLoaded	= true;
		protected QualityAssurance																	qa;
		protected DataValue_String																	title;
		protected DataValue_List<DataValue_String>	keywords;
		protected DataValue_List<DataValue_String>	groups;
		protected DataValue_List<DataValue_String>	uids;
		protected DataValue_List<DataValue_String>	status;
		
		public static final long																			P_TITLE_PID								= TraceableProperties.REGISTERED.add("title modified", "", Pathway.class);
		public static final long																			P_KEYWORDS_PID					= TraceableProperties.REGISTERED.add("keywords modified", "", Pathway.class);
		public static final long																			P_GROUPS_PID							= TraceableProperties.REGISTERED.add("groups modified", "", Pathway.class);
		public static final long																			P_UIDS													= TraceableProperties.REGISTERED.add("OECD work program ID", "", Pathway.class);
		public static final long																			P_STATUS											= TraceableProperties.REGISTERED.add("Pathway status", "", Pathway.class);
		public static final long																			P_ESSENTIALITY_PID	= TraceableProperties.REGISTERED.add("essentiality", "", Pathway.class);
		
		protected EssetialityDescription											essentiality;
		protected DescriptionIDs																			descriptionIDs;
		protected ReferenceIDs<Reference>										referenceIDs;
		protected ReferenceIDs<PathwayElement>					elements;
		protected ArrayList<PathwayElement>								segmentRoots;
	}

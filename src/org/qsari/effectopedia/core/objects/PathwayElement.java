package org.qsari.effectopedia.core.objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.QualityAssured;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.object.elemets.QualityAssurance;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.DataValue_String;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.defaults.DefaultTextProperties;
import org.qsari.effectopedia.history.EditHistory;
import org.qsari.effectopedia.search.SearchableItem;
import org.qsari.effectopedia.system.ActionTypes;

public class PathwayElement extends EffectopediaObject implements Importable, Exportable, Cloneable, Traceable, QualityAssured
	{
		
		public PathwayElement()
			{
				super();
				pathwayIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_PATHWAY_REFIDS);
				qa = new QualityAssurance(this);
			}
			
		public PathwayElement(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				pathwayIDs = DefaultEffectopediaObjects.DEFAULT_PATHWAY_REFIDS.clone(this, dataSource);
				qa = new QualityAssurance(this);
				if ((parent instanceof Pathway) && (dataSource == parent.getDataSource()))
					{
						if (parent.isDefaultID() && pathwayIDs.isDefaultID())
							pathwayIDs.addAndKeepItDefault((Pathway) parent);
						else
							pathwayIDs.add((Pathway) parent);
						((Pathway) parent).getElements().add(this);
					}
			}
			
		@Override
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				containedIDs.put(pathwayIDs.getID(), pathwayIDs);
			}
			
		@Override
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				containedIDs.put(pathwayIDs.getExternalID(), pathwayIDs);
			}
			
		@Override
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				pathwayIDs = EffectopediaObject.cloneIfInDefaultObjects(pathwayIDs, this, dataSource);
			}
			
		@Override
		public void replaceArchivedObjectsWtihClones()
			{
				super.replaceArchivedObjectsWtihClones();
				pathwayIDs = EditHistory.replaceArchivedObjectsWtihClones(pathwayIDs, this, dataSource);
			}
			
		public void getContainedIDsForAssociatedPathways(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				Pathway[] pathways = pathwayIDs.getCachedObjects();
				for (Pathway p : pathways)
					p.getContainedIDs(containedIDs, false);
			}
			
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (pathwayIDs != null)
					pathwayIDs.process(batch);
			}
			
		public void updateParenthood()
			{
				// (pathwayIDs =
				// EffectopediaObject.cloneIfDefault(pathwayIDs)).setParent(this);
				pathwayIDs.setParent(this);
			}
			
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				pathwayIDs = dataSource.get(pathwayIDs.getClass(), pathwayIDs.getID());
			}
			
		public String getTitle()
			{
				String titleString = null;
				if (title != null)
					titleString = title.toString();
				if ((titleString == null) || (titleString == ""))
					return DefaultTextProperties.INSTANCE.getDefault(getClass().getSimpleName() + ".title");
				else
					return titleString;
			}
			
		public boolean hasAssignedTitle()
			{
				return (title != null) && (title.toString() != null) && (title.toString() != "");
			}
			
		public SearchableItem getSearchableItem()
			{
				return (title != null) ? title.getSearchItem() : null;
			}
			
		public void setTitle(String title)
			{
				if (((title == null) && (this.title != null)) || (!title.equals(this.title)))
					{
						beforeUpdate(true, ActionTypes.PE_TITLE_AID);
						this.title.parseString(title);
						this.generic = false;
					}
			}
			
		@Override
		public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if (eoDestintation instanceof PathwayElement)
					{
						((PathwayElement) eoDestintation).setTitle(this.title.getValue());
						((PathwayElement) eoDestintation).generic = this.generic;
						if (assignContainedEO)
							this.pathwayIDs.assignFieldsTo(((PathwayElement) eoDestintation).getPathwayIDs(), assignContainedEO);
					}
			}
			
		public void cloneFieldsTo(PathwayElement clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				// if (clone.pathwayIDs.isDefaultID()) //TODO Check for implications
				clone.pathwayIDs = this.pathwayIDs.clone(clone, dataSource);
				clone.generic = this.generic;
			}
			
		public PathwayElement clone()
			{
				PathwayElement clone = new PathwayElement(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
			
		public PathwayElement clone(EffectopediaObject parent, DataSource dataSource)
			{
				PathwayElement clone = new PathwayElement(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
			
		public boolean belongsTo(long pathwayID)
			{
				return (pathwayIDs.contains(pathwayID) != -1);
			}
			
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
					//	System.out.println("pathwayIDs = " + element.getChild("pathway_ids").getAttribute("id").getValue());
						pathwayIDs = io.load(ReferenceIDs.class, pathwayIDs, element.getChild("pathway_ids"));
						BaseIOAttribute generic = element.getAttribute("generic");
						if (generic != null)
							this.generic = generic.getBooleanValue();
					}
			}
			
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
				pathwayIDs.updateExternalID(element.getChild("pathway_ids"));
			}
			
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				//if (pathwayIDs == null)
				//	System.out.println("PathwayElement.storeToXMLElement" + this.DEBUG_getIDs());
				element.addChild(pathwayIDs.store(io.newElement("pathway_ids"), io));
				element.setAttribute("generic", String.valueOf(isGeneric()));
				return element;
			}
			
		public ReferenceIDs<Pathway> getPathwayIDs()
			{
				return pathwayIDs;
			}
			
		public static boolean isUpLinkedTo(PathwayElement element, Class<? extends PathwayElement> elementClass)
			{
				if (element == null)
					return false;
				PathwayElement[] associations = (element instanceof Link) ? element.incommingAssociations() : PathwayElement.getPrevousLevelIncommingAssociations(element.incommingAssociations());
				if (associations != null)
					for (PathwayElement e : associations)
						if ((e != null) && (elementClass.isAssignableFrom(e.getClass())))
							return true;
				return false;
			}
			
		public boolean isDirectlyLinkedTo(PathwayElement element)
			{
				if (element == null)
					return false;
				PathwayElement[] associations = incommingAssociations();
				if (associations != null)
					for (PathwayElement e : associations)
						if (e == element)
							return true;
				associations = outgoingAssociations();
				if (associations != null)
					for (PathwayElement e : associations)
						if (e == element)
							return true;
				return false;
			}
	
		public static int countElementsBetween(PathwayElement fromElement, PathwayElement toElement)
			{
				if ((fromElement == null)||(toElement == null))
					return -1;
				PathwayElement[] associations = fromElement.outgoingAssociations();
				if (associations != null)
					for (PathwayElement e : associations)
						if (e == toElement)
							return 0;
						else 
							{
								int result = countElementsBetween(e,toElement);
								if (result>=0)
									return result+1;
							}
				return -1;
			}			
		public static boolean areMapped(PathwayElement element1, PathwayElement element2)
			{
				if ((element1 == null) || (element2 == null))
					return false;
				PathwayElement[] mappings = element1.incommingMappings();
				if (mappings != null)
					for (PathwayElement e : mappings)
						{
							if (e == null)
								continue;
							if (e == element2)
								return true;
							if (e.hasIncommingMappings())
								for (PathwayElement m : e.incommingMappings())
									if (m == element2)
										return true;
						}
				mappings = element1.outgoingMappings();
				if (mappings != null)
					for (PathwayElement e : mappings)
						{
							if (e == null)
								continue;
							if (e == element2)
								return true;
							if (e.hasOutgoingMappings())
								for (PathwayElement m : e.outgoingMappings())
									if (m == element2)
										return true;
						}
				return false;
			}
			
		public boolean hasIncommingAssociations()
			{
				return false;
			}
			
		public PathwayElement[] incommingAssociations()
			{
				return null;
			}
			
		public boolean hasIncommingAssociations(long onPathwayID)
			{
				PathwayElement[] incomming = incommingAssociations();
				if ((incomming == null) || (incomming.length == 0))
					return false;
				for (PathwayElement e : incomming)
					if ((e != null) && (e.getPathwayIDs().contains(onPathwayID) != -1))
						return true;
				return false;
			}
			
		public boolean hasOutgoingAssociations()
			{
				return false;
			}
			
		public PathwayElement[] outgoingAssociations()
			{
				return null;
			}
			
		public boolean hasIncommingMappings()
			{
				return false;
			}
			
		public PathwayElement[] incommingMappings()
			{
				return null;
			}
			
		public boolean hasOutgoingMappings()
			{
				return false;
			}
			
		public PathwayElement[] outgoingMappings()
			{
				return null;
			}
			
		public void map(PathwayElement element)
			{
				
			}
			
		public void unmap(PathwayElement element)
			{
				
			}
			
		public void link_Up(PathwayElement element)
			{
				
			}
			
		public void link_Down(PathwayElement element)
			{
				
			}
			
		public void unlink_Up(PathwayElement element)
			{
				
			}
			
		public void unlink_Down(PathwayElement element)
			{
				
			}
			
		public void unlink()
			{
				PathwayElement[] associations = incommingAssociations();
				if (associations != null)
					for (int i = associations.length - 1; i >= 0; i--)
						Pathway.unlink(associations[i], this);
				associations = outgoingAssociations();
				if (associations != null)
					for (int i = associations.length - 1; i >= 0; i--)
						Pathway.unlink(this, associations[i]);
			}
			
		public void mergeWith(Pathway pathway)
			{
				long pathwayID = pathway.getID();
				if (!belongsTo(pathwayID))
					pathwayIDs.add(pathway);
				PathwayElement[] incomming = incommingAssociations();
				if (incomming != null)
					for (int i = incomming.length - 1; i >= 0; i--)
						{
							PathwayElement[] previous = incomming[i].incommingAssociations();
							for (int j = previous.length - 1; j >= 0; j--)
								if (previous[j].belongsTo(pathwayID))
									{
										if (!incomming[i].belongsTo(pathwayID))
											incomming[i].pathwayIDs.add(pathway);
										break;
									}
						}
					
				PathwayElement[] outgoing = outgoingAssociations();
				if (outgoing != null)
					for (int i = outgoing.length - 1; i >= 0; i--)
						{
							PathwayElement[] next = outgoing[i].outgoingAssociations();
							for (int j = next.length - 1; j >= 0; j--)
								if (next[j].belongsTo(pathwayID))
									{
										if (!outgoing[i].belongsTo(pathwayID))
											outgoing[i].pathwayIDs.add(pathway);
										break;
									}
						}
			}
			
		protected void removeIncommingAssociation(PathwayElement pathwayElement)
			{
				
			}
			
		protected void removeOutgoingAssociation(PathwayElement pathwayElement)
			{
				
			}
			
		public boolean isGeneric()
			{
				return generic;
			}
			
		public void setGeneric(boolean generic)
			{
				this.generic = generic;
			}
			
		public int getTag()
			{
				return tag;
			}
			
		public void setTag(int tag)
			{
				this.tag = tag;
			}
			
		public String toString()
			{
				return getTitle();
			}
			
		public QualityAssurance getQA()
			{
				return qa;
			}
			
		public void setQA(QualityAssurance qualityAssurance)
			{
				this.qa = qualityAssurance;
			}
			
		public Pathway[] getAssocuatedPathways()
			{
				return pathwayIDs.getCachedObjects();
			}
			
		public String getPathwaysDescription(int maxLength)
			{
				final String DELIMITER = ", ";
				if (pathwayIDs != null)
					{
						StringBuilder description = new StringBuilder();
						Pathway[] pathways = pathwayIDs.getCachedObjects();
						for (int i = 0; i < pathways.length; i++)
							{
								description.append(pathways[i].getTitle());
								if ((maxLength > 0) && (description.length() > maxLength))
									{
										description.delete(maxLength - 3, description.length());
										description.append("...");
										description.append(DELIMITER);
										break;
									}
								description.append(DELIMITER);
							}
						description.delete(description.length() - DELIMITER.length(), description.length());
						return description.toString();
					}
				return null;
			}
			
		public static void swap(PathwayElement element1, PathwayElement element2)
			{
				PathwayElement temp = element1;
				element1 = element2;
				element2 = temp;
			}
			
		public static PathwayElement[] getPrevousLevelIncommingAssociations(PathwayElement[] elements)
			{
				ArrayList<PathwayElement> result = new ArrayList<PathwayElement>();
				if (elements != null)
					{
						for (int i = elements.length - 1; i >= 0; i--)
							if (elements[i].hasIncommingAssociations())
								result.addAll(Arrays.asList(elements[i].incommingAssociations()));
						return result.toArray(new PathwayElement[result.size()]);
					}
				return null;
			}
			
		public static PathwayElement[] getNextLevelOutgoingAssociations(PathwayElement[] elements)
			{
				ArrayList<PathwayElement> result = new ArrayList<PathwayElement>();
				if (elements != null)
					{
						for (int i = 0; i < elements.length; i++)
							if (elements[i].hasOutgoingAssociations())
								result.addAll(Arrays.asList(elements[i].outgoingAssociations()));
						return result.toArray(new PathwayElement[result.size()]);
					}
				return null;
			}
			
		public static PathwayElement[] getOutgoingMappingElements(PathwayElement[] elements)
			{
				ArrayList<PathwayElement> result = new ArrayList<PathwayElement>();
				if (elements != null)
					{
						for (int i = 0; i < elements.length; i++)
							if (elements[i].hasOutgoingMappings())
								result.addAll(Arrays.asList(elements[i].outgoingMappings()));
						return result.toArray(new PathwayElement[result.size()]);
					}
				return null;
			}
			
		public static boolean areGeneric(PathwayElement[] elements)
			{
				boolean result = elements != null;
				if (result)
					for (int i = elements.length - 1; i >= 0; i--)
						{
							result = result && elements[i].isGeneric();
							if (!result)
								return false;
						}
				return result;
			}
			
		public static boolean areLinked(PathwayElement pathwayElement1, PathwayElement pathwayElement2)
			{
				return isLinked(pathwayElement1, pathwayElement2) || isLinked(pathwayElement2, pathwayElement1);
			}
			
		private static boolean isLinked(PathwayElement upstreamElement, PathwayElement downstreamElement)
			{
				if ((upstreamElement == null) || (downstreamElement == null))
					return false;
				PathwayElement[] out = upstreamElement.outgoingAssociations();
				if (out != null)
					for (PathwayElement e : out)
						{
							if (isLinked(e, downstreamElement))
								return true;
							if (e == downstreamElement)
								return true;
						}
				return false;
			}
			
		protected DataValue_String						title;
		protected QualityAssurance						qa;
		protected int																			tag					= 0;
		protected boolean															generic	= true;
		protected ReferenceIDs<Pathway>	pathwayIDs;
		
	}

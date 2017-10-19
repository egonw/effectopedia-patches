package org.qsari.effectopedia.core.objects;

import java.util.LinkedHashMap;
import java.util.StringTokenizer;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.containers.References.Referable;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.interfaces.IdentifiableStructure;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.history.EditHistory;

public class Initiator_ChemicalStructure extends Initiator implements Importable, Exportable, IdentifiableStructure, Cloneable, Traceable, Referable
	{
		public Initiator_ChemicalStructure()
			{
				super();
				upstreamLinkIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_CHEMICAL_REFIDS);
				substanceIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_SUBSTANCE_REFIDS);
				identification = new ObjectProperties(this, DefaultEffectopediaObjects.CHEMICAL_STRUCT_IDENT);
				properties = new ObjectProperties(this, DefaultEffectopediaObjects.CHEMICAL_PROPERTIES);
				structure2DImage = new ObjectProperty(this, DefaultEffectopediaObjects.STRUCTURE_2DIMAGE);
				synonyms = new ObjectProperty(this, DefaultEffectopediaObjects.STRUCTURE_SYNONYMS);
			}
		
		public Initiator_ChemicalStructure(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				upstreamLinkIDs = DefaultEffectopediaObjects.DEFAULT_CHEMICAL_REFIDS.clone(this, dataSource);
				substanceIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_SUBSTANCE_REFIDS);
				identification = new ObjectProperties(this, DefaultEffectopediaObjects.CHEMICAL_STRUCT_IDENT);
				properties = new ObjectProperties(this, DefaultEffectopediaObjects.CHEMICAL_PROPERTIES);
				structure2DImage = new ObjectProperty(this, DefaultEffectopediaObjects.STRUCTURE_2DIMAGE);
				synonyms = new ObjectProperty(this, DefaultEffectopediaObjects.STRUCTURE_SYNONYMS);
			}
		
		@Override
		public void init(boolean asDefaultObject)
			{
				substanceIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_SUBSTANCE_REFIDS);
				substanceIDs.addAndKeepItDefault(DefaultEffectopediaObjects.DEFAULT_SUBSTANCE);
				updateParenthood();
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				containedIDs.put(upstreamLinkIDs.getID(), upstreamLinkIDs);
				containedIDs.put(substanceIDs.getID(), substanceIDs);
				identification.getContainedIDs(containedIDs);
				properties.getContainedIDs(containedIDs);
				structure2DImage.getContainedIDs(containedIDs);
				synonyms.getContainedIDs(containedIDs);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				containedIDs.put(upstreamLinkIDs.getExternalID(), upstreamLinkIDs);
				containedIDs.put(substanceIDs.getExternalID(), substanceIDs);
				identification.getContainedExternalIDs(containedIDs);
				properties.getContainedExternalIDs(containedIDs);
				structure2DImage.getContainedExternalIDs(containedIDs);
				synonyms.getContainedExternalIDs(containedIDs);
			}
		
		public void replaceDefaultObjectsWtihClones()
			{
				super.replaceDefaultObjectsWtihClones();
				upstreamLinkIDs = EffectopediaObject.cloneIfInDefaultObjects(upstreamLinkIDs, this, dataSource);
				substanceIDs = EffectopediaObject.cloneIfInDefaultObjects(substanceIDs, this, dataSource);
				Substance substance = substanceIDs.getCachedObject(0);
				if (substance != null)
					{
						substance.setParent(this);
						substance.initComposition(true);
					}
			}
		
		@Override
		public void replaceArchivedObjectsWtihClones()
			{
				super.replaceArchivedObjectsWtihClones();
				upstreamLinkIDs = EditHistory.replaceArchivedObjectsWtihClones(upstreamLinkIDs, this, dataSource);
				substanceIDs = EditHistory.replaceArchivedObjectsWtihClones(substanceIDs, this, dataSource);
				Substance substance = substanceIDs.getCachedObject(0);
				if (substance != null)
					{
						substance.setParent(this);
						substance.initComposition(true);
					}
			}
		
		@Override
		public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if (eoDestintation instanceof Initiator_ChemicalStructure)
					{
						((Initiator_ChemicalStructure) eoDestintation).setIdentification(identification.clone(eoDestintation, dataSource));
						((Initiator_ChemicalStructure) eoDestintation).setProperties(properties.clone(eoDestintation, dataSource));
						((Initiator_ChemicalStructure) eoDestintation).setStructure2DImage(structure2DImage.clone(eoDestintation));
						((Initiator_ChemicalStructure) eoDestintation).setSynonyms(synonyms.clone(eoDestintation));
						if (assignContainedEO)
							{
								this.upstreamLinkIDs.assignFieldsTo(((Initiator_ChemicalStructure) eoDestintation).upstreamLinkIDs, assignContainedEO);
								this.substanceIDs.assignFieldsTo(((Initiator_ChemicalStructure) eoDestintation).substanceIDs, assignContainedEO);
							}
					}
			}
		
		public void cloneFieldsTo(Initiator_ChemicalStructure clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.upstreamLinkIDs = this.upstreamLinkIDs.clone(clone, dataSource);
				
				clone.substanceIDs = this.substanceIDs.clone(clone, dataSource);
				Substance pureClone = Substance.createDefaultPureSubstance(clone, dataSource);
				clone.substanceIDs.setAndKeepItDefault(pureClone, 0);
				
				clone.setIdentification(identification.clone(clone, dataSource));
				clone.setProperties(properties.clone(clone, dataSource));
				clone.setStructure2DImage(structure2DImage.clone(clone));
				clone.setSynonyms(synonyms.clone(clone));
			}
		
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (upstreamLinkIDs != null)
					upstreamLinkIDs.process(batch);
				if (substanceIDs != null)
					substanceIDs.process(batch);
			}
		
		public void updateParenthood()
			{
				super.updateParenthood();
				upstreamLinkIDs = EffectopediaObject.updateParent(upstreamLinkIDs, this);
				substanceIDs = EffectopediaObject.updateParent(substanceIDs, this);
			}
		
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				upstreamLinkIDs = dataSource.get(upstreamLinkIDs.getClass(), upstreamLinkIDs.getID());
				substanceIDs = dataSource.get(substanceIDs.getClass(), substanceIDs.getID());
			}
		
		public Initiator_ChemicalStructure clone()
			{
				Initiator_ChemicalStructure clone = new Initiator_ChemicalStructure(null, dataSource);
				cloneFieldsTo(clone, dataSource);
				clone.setParent(parent);
				return clone;
			}
		
		public Initiator_ChemicalStructure clone(EffectopediaObject parent, DataSource dataSource)
			{
				Initiator_ChemicalStructure clone = new Initiator_ChemicalStructure(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public ObjectProperties getIdentification()
			{
				return identification;
			}
		
		public void setIdentification(ObjectProperties identification)
			{
				this.identification = identification;
			}
		
		public ObjectProperties getProperties()
			{
				return properties;
			}
		
		public void setProperties(ObjectProperties properties)
			{
				this.properties = properties;
			}
		
		public ObjectProperty getStructure2DImage()
			{
				return structure2DImage;
			}
		
		public void setStructure2DImage(ObjectProperty structure2dImage)
			{
				structure2DImage = structure2dImage;
			}
		
		public String[] getSynonymsList()
			{
				if (synonyms != null)
					return getSynonymsList(synonyms.getDisplayValue());
				return null;
			}
		
		public void setSynonymsList(String[] list)
			{
				synonyms.setValue(setSynonymsList(list, "|"));
			}
		
		public ObjectProperty getSynonyms()
			{
				return synonyms;
			}
		
		public void setSynonyms(ObjectProperty synonyms)
			{
				this.synonyms = synonyms;
			}
		
		public static String setSynonymsList(String[] list, String delimiter)
			{
				StringBuffer buffer = new StringBuffer();
				for (int i = 0; i < list.length - 1; i++)
					{
						buffer.append(list[i]);
						buffer.append(delimiter);
					}
				buffer.append(list[list.length - 1]);
				return buffer.toString();
			}
		
		public static String[] getSynonymsList(String list)
			{
				if (list != null)
					{
						StringTokenizer st = new StringTokenizer(list, SYNONYM_DIVIDERS);
						String[] result = new String[st.countTokens()];
						int i = 0;
						while (st.hasMoreTokens())
							result[i++] = st.nextToken();
						return result;
					}
				return null;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						BaseIOElement upstream_links = element.getChild("upstream_link_ids");
						if (upstream_links != null)
							upstreamLinkIDs = io.load(ReferenceIDs.class, upstreamLinkIDs, upstream_links);
						else
							upstreamLinkIDs = DefaultEffectopediaObjects.DEFAULT_CHEMICAL_REFIDS.clone(this, dataSource);
						BaseIOElement substances = element.getChild("substances");
						if (substances != null)
							{
								substanceIDs.setParent(this);
								substanceIDs = io.load(ReferenceIDs.class, substanceIDs, substances);
								
							}
						else
							{
								substanceIDs = DefaultEffectopediaObjects.DEFAULT_SUBSTANCE_REFIDS.clone(this, dataSource);
								Substance pure = Substance.createDefaultPureSubstance(this, dataSource);
								substanceIDs.repaclace(0, pure);
							}
						identification.load(element.getChild("identification"), io);
						properties.load(element.getChild("properties"), io);
						structure2DImage.load(element.getChild("structure2DImage"), io);
						synonyms.load(element.getChild("synonyms"), io);
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				if (element != null)
					{
						super.updateExternalID(element);
						upstreamLinkIDs.updateExternalID(element.getChild("upstream_link_ids"));
						substanceIDs.updateExternalID(element.getChild("substances"));
						identification.updateExternalID(element.getChild("identification"));
						properties.updateExternalID(element.getChild("properties"));
						structure2DImage.updateExternalID(element.getChild("structure2DImage"));
						synonyms.updateExternalID(element.getChild("synonyms"));
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addChild(identification.store(io.newElement("identification"), io));
				element.addChild(properties.store(io.newElement("properties"), io));
				element.addChild(structure2DImage.store(io.newElement("structure2DImage"), io));
				element.addChild(synonyms.store(io.newElement("synonyms"), io));
				element.addChild(upstreamLinkIDs.store(io.newElement("upstream_link_ids"), io));
				element.addChild(substanceIDs.store(io.newElement("substances"), io));
				return element;
			}
		
		public String DEBUG_getIDs()
			{
				StringBuilder sb = new StringBuilder();
				sb.append(super.DEBUG_getIDs());
				sb.append("\tpathway_ids\t");
				sb.append(pathwayIDs.DEBUG_getIDs());
				if (downstreamLinkIDs != null)
					{
						sb.append("\tdownstreamLinkIds\t");
						sb.append(downstreamLinkIDs.DEBUG_getIDs());
					}
				if (referenceIDs != null)
					{
						sb.append("\treferenceIDs\t");
						sb.append(referenceIDs.DEBUG_getIDs());
					}
				return sb.toString();
			}
		
		public boolean hasIncommingAssociations()
			{
				return upstreamLinkIDs.size() > 0;
			}
		
		public boolean hasOutgoingAssociations()
			{
				return downstreamLinkIDs.size() > 0;
			}
		
		public Link[] incommingAssociations()
			{
				return upstreamLinkIDs.getCachedObjects();
			}
		
		public Link[] outgoingAssociations()
			{
				return downstreamLinkIDs.getCachedObjects();
			}
		
		public void link_Up(PathwayElement element)
			{
				if (element instanceof Link_ChemStructToChemStruct)
					this.upstreamLinkIDs.addIfDifferent((Link_ChemStructToChemStruct) element);
			}
		
		public void unlink_Up(PathwayElement element)
			{
				if (element instanceof Link_ChemStructToChemStruct)
					this.upstreamLinkIDs.removeIfPresent((Link_ChemStructToChemStruct) element);
			}
		
		public String getStructureName()
			{
				return getTitle();
			}
		
		@Override
		public void setTitle(String title)
			{
				super.setTitle(title);
				Substance pure = substanceIDs.getCachedObject(0);
				if (pure != null)
					pure.setTitleAndKeepItDefault("Pure " + title);
			}
		
		public void setStructureName(String name)
			{
				setTitle(name);
			}
		
		public ReferenceIDs<Substance> getSubstanceIDs()
			{
				return substanceIDs;
			}
		
		public void setSubstanceIDs(ReferenceIDs<Substance> substanceIDs)
			{
				this.substanceIDs = substanceIDs;
			}
		
		protected ReferenceIDs<Link>						upstreamLinkIDs;
		protected ReferenceIDs<Substance>	substanceIDs;
		
		protected ObjectProperties								identification;
		protected ObjectProperties								properties;
		protected ObjectProperty										structure2DImage;
		protected ObjectProperty										synonyms;
		
		private static final String							SYNONYM_DIVIDERS	= "|\t\n";
		
	}

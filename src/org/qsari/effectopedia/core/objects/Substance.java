package org.qsari.effectopedia.core.objects;

import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.base.ids.IDs;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.interfaces.IdentifiableSubstance;
import org.qsari.effectopedia.data.objects.DataValue_String;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.defaults.DefaultTextProperties;
import org.qsari.effectopedia.search.SearchIndices;
import org.qsari.effectopedia.search.SearchableItem;
import org.qsari.effectopedia.system.ActionTypes;
import org.qsari.effectopedia.system.TraceableProperties;

public class Substance extends EffectopediaObject implements Titleable, IdentifiableSubstance, Importable, Exportable
	{
		
		public Substance()
			{
				super();
				SearchableItem sa = new SearchableItem(this, SUBST_TITLE_PID, SearchIndices.TITLE_INDEX);
				this.title = new DataValue_String(sa);
				if (!DefaultEffectopediaObjects.buildingDefaultObjects)
					{
						composition = DefaultEffectopediaObjects.DEFAULT_COMPOSIOTION.clone();
						identification = DefaultEffectopediaObjects.DEFAULT_SUBSTANCE_IDENT.clone(this, null);
						properties = DefaultEffectopediaObjects.DEFAULT_SUBSTANCE_PROP.clone(this, null);
					}
			}
		
		public Substance(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				SearchableItem sa = new SearchableItem(this, SUBST_TITLE_PID, SearchIndices.TITLE_INDEX);
				this.title = new DataValue_String(sa);
				identification = DefaultEffectopediaObjects.buildingDefaultObjects ? DefaultEffectopediaObjects.DEFAULT_SUBSTANCE_IDENT : DefaultEffectopediaObjects.DEFAULT_SUBSTANCE_IDENT
						.clone(this, dataSource);
				composition = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_COMPOSIOTION);
				properties = DefaultEffectopediaObjects.buildingDefaultObjects ? DefaultEffectopediaObjects.DEFAULT_SUBSTANCE_PROP : DefaultEffectopediaObjects.DEFAULT_SUBSTANCE_PROP.clone(this, dataSource);
			}
		
		public static Substance createDefaultPureSubstance(Initiator_ChemicalStructure structure, DataSource dataSource)
			{
				Substance pure = DefaultEffectopediaObjects.DEFAULT_SUBSTANCE.clone(structure, dataSource);
				pure.initComposition(true);
				return pure;
			}
		
		public static Substance createDefaultSubstance(Initiator_ChemicalStructure structure, DataSource dataSource)
			{
				Substance substance = DefaultEffectopediaObjects.DEFAULT_SUBSTANCE.clone(structure, dataSource);
				substance.initComposition(false);
				return substance;
			}
		
		public Constituent createConstituent(Initiator_ChemicalStructure structure)
			{
				Constituent constituent = DefaultEffectopediaObjects.DEFAULT_CONSTITUENT.clone(this, dataSource);
				constituent.setStructure(structure);
				return constituent;
			}
		
		@Override
		public void init(boolean asDefaultObject)
			{
				initComposition(true);
				identification = asDefaultObject ? DefaultEffectopediaObjects.DEFAULT_SUBSTANCE_IDENT : DefaultEffectopediaObjects.DEFAULT_SUBSTANCE_IDENT.clone(this, dataSource);
				properties = asDefaultObject ? DefaultEffectopediaObjects.DEFAULT_SUBSTANCE_PROP : DefaultEffectopediaObjects.DEFAULT_SUBSTANCE_PROP.clone(this, dataSource);
				updateParenthood();
			}
		
		protected void initComposition(boolean pureComposition)
			{
				composition = DefaultEffectopediaObjects.DEFAULT_COMPOSIOTION.clone(this, dataSource);
				if (parent instanceof Initiator_ChemicalStructure)
					{
						Constituent mainConstituent = DefaultEffectopediaObjects.DEFAULT_CONSTITUENT.clone(this, dataSource);
						Initiator_ChemicalStructure struct = (Initiator_ChemicalStructure) parent;
						if (pureComposition)
							{
								pureChemical = mainConstituent;
								pureChemical.setStructureAndKeepItDefault(struct);
								composition.addAndKeepItDefault(mainConstituent);
								title.parseString(struct.hasAssignedTitle() ? "Pure " + struct.getTitle() : "Physical substance name");
							}
						else
							{
								mainConstituent.setStructure(struct);
								composition.add(mainConstituent);
								title.parseString(struct.hasAssignedTitle() ? struct.getTitle() : "Physical substance name");
							}
					}
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				containedIDs.put(composition.getID(), composition);
				identification.getContainedIDs(containedIDs);
				properties.getContainedIDs(containedIDs);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				containedIDs.put(composition.getExternalID(), composition);
				if (identification != null)
					identification.getContainedExternalIDs(containedIDs);
				if (properties != null)
					properties.getContainedExternalIDs(containedIDs);
			}
		
		@Override
				public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if (eoDestintation instanceof Substance)
					{
						((Substance) eoDestintation).setIdentification(this.identification.clone(eoDestintation, dataSource));
						((Substance) eoDestintation).setIdentification(this.properties.clone(eoDestintation, dataSource));
						if (assignContainedEO)
						this.composition.assignFieldsTo(((Substance) eoDestintation).getComposition(),assignContainedEO);
					}
			}

	
		public void cloneFieldsTo(Substance clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.composition = this.composition.clone(clone, dataSource);
				clone.setIdentification(identification.clone(clone, dataSource));
				clone.setProperties(properties.clone(clone, dataSource));
			}
		
		public Substance clone()
			{
				Substance clone = new Substance(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public Substance clone(EffectopediaObject parent, DataSource dataSource)
			{
				Substance clone = new Substance(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
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

		@Override
		public String toString()
			{
				return getTitle();
			}
		
		public void setTitle(String title)
			{
				if (((title == null) && (this.title.getValue() != null)) || (title != null && !title.equals(this.title.getValue())))
					{
						beforeUpdate(true, ActionTypes.SUBST_TITLE_AID);
						this.title.parseString(title);
					}
			}
		
		public void setTitleAndKeepItDefault(String title)
			{
				this.title.parseString(title);
			}
		
		public Initiator_ChemicalStructure getParentStructure()
			{
				return (Initiator_ChemicalStructure) this.parent;
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
		
		public IDs<Constituent> getComposition()
			{
				return composition;
			}
		
		public void setComposition(IDs<Constituent> composition)
			{
				this.composition = composition;
			}
		
		public Constituent getPureChemical()
			{
				return pureChemical;
			}
		
		public void setPureChemical(Constituent pureChemical)
			{
				this.pureChemical = pureChemical;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						BaseIOElement comp = element.getChild("composition");
						if (comp != null)
							{
								composition = io.load(IDs.class, composition, comp);
								BaseIOAttribute pure = element.getAttribute("pure");
								if ((pure != null) && (pure.getBooleanValue()))
									pureChemical = composition.getCachedObject(0);
							}
						if (isDefaultID()&&(parent!=null))
							{
								Initiator_ChemicalStructure struct = (Initiator_ChemicalStructure) parent;
								title.parseString(struct.hasAssignedTitle() ? "Pure " + struct.getTitle() : "Physical substance name");
							}
						else
							title.parseString(element.getValueElement("title").getValue());
						identification.load(element.getChild("info"), io);
						properties.load(element.getChild("properties"), io);
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				if (element != null)
					{
						super.updateExternalID(element);
						composition.updateExternalID(element.getChild("upstream_link_ids"));
						identification.updateExternalID(element.getChild("info"));
						properties.updateExternalID(element.getChild("properties"));
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addAttribute(io.newAttribute("pure").setValue(pureChemical != null));
				if (isDefaultID())
					element.addValueElement(io.newValue("title").setValue(DefaultTextProperties.INSTANCE.getDefault(getClass().getSimpleName() + ".title")));
				else
					element.addValueElement(io.newValue("title").setValue(title.toString()));
				element.addChild(identification.store(io.newElement("info"), io));
				element.addChild(properties.store(io.newElement("properties"), io));
				element.addChild(composition.store(io.newElement("composition"), io));
				return element;
			}
		
		protected DataValue_String	title;
		protected ObjectProperties	identification;
		protected ObjectProperties	properties;
		protected IDs<Constituent>	composition					= null;
		private Constituent								pureChemical;
		
		public static final long			SUBST_TITLE_PID	= TraceableProperties.REGISTERED.add("title", "", Substance.class);
		
	}

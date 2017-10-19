package org.qsari.effectopedia.defaults;

import java.util.HashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.ids.DescriptionIDs;
import org.qsari.effectopedia.base.ids.IDs;
import org.qsari.effectopedia.base.ids.ReferenceID;
import org.qsari.effectopedia.base.ids.ReferenceIDW;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.containers.Context;
import org.qsari.effectopedia.core.object.elemets.EssetialityDescription;
import org.qsari.effectopedia.core.objects.Constituent;
import org.qsari.effectopedia.core.objects.ContextDimension;
import org.qsari.effectopedia.core.objects.ContextDimension_Hierarchical;
import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.core.objects.DescriptionSection_Structured;
import org.qsari.effectopedia.core.objects.DocumentedKnowledge;
import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Effect_AdverseOutcome;
import org.qsari.effectopedia.core.objects.Effect_DownstreamEffect;
import org.qsari.effectopedia.core.objects.Effect_Endpoint;
import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;
import org.qsari.effectopedia.core.objects.Initiator;
import org.qsari.effectopedia.core.objects.Initiator_BiologcalPerturbation;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.Initiator_StructuralAlerts;
import org.qsari.effectopedia.core.objects.Lab;
import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.Link_ChemStructToChemStruct;
import org.qsari.effectopedia.core.objects.Link_ChemStructToMIE;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.core.objects.Method;
import org.qsari.effectopedia.core.objects.Method_InSilicoGlobalModel;
import org.qsari.effectopedia.core.objects.Method_Investigation;
import org.qsari.effectopedia.core.objects.Method_Study;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.objects.Reference;
import org.qsari.effectopedia.core.objects.Substance;
import org.qsari.effectopedia.core.objects.SubstanceData;
import org.qsari.effectopedia.core.objects.SubstanceData_InLab;
import org.qsari.effectopedia.core.objects.SubstanceData_InSilico;
import org.qsari.effectopedia.core.objects.Test;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.core.objects.Test_ExVivo;
import org.qsari.effectopedia.core.objects.Test_InChemico;
import org.qsari.effectopedia.core.objects.Test_InSilico;
import org.qsari.effectopedia.core.objects.Test_InVitro;
import org.qsari.effectopedia.core.objects.Test_InVivo;
import org.qsari.effectopedia.core.objects.TransformationSet;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.DataUnit;
import org.qsari.effectopedia.data.objects.DataValue_Double;
import org.qsari.effectopedia.data.objects.DataValue_Float;
import org.qsari.effectopedia.data.objects.DataValue_IntRef;
import org.qsari.effectopedia.data.objects.DataValue_Integer;
import org.qsari.effectopedia.data.objects.DataValue_List;
import org.qsari.effectopedia.data.objects.DataValue_String;
import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.data.objects.FixedValuesList;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectPropertyType;
import org.qsari.effectopedia.data.objects.ObjectPropertyTypesContainer;
import org.qsari.effectopedia.data.objects.Resource;
import org.qsari.effectopedia.data.objects.Resource.ResourceType;
import org.qsari.effectopedia.data.quantification.DataTemplateType;
import org.qsari.effectopedia.history.Stamp;
import org.qsari.effectopedia.search.SearchIndices;
import org.qsari.effectopedia.system.ActionTypes;
import org.qsari.effectopedia.system.User;

public class DefaultEffectopediaObjects
	{
		public static boolean buildingDefaultObjects = true;
		static
			{
				Stamp.setDefaultDate(2014, 2, 7, 0, 0, 0, 999);
			}

		@SuppressWarnings("unchecked")
		public static <E extends EffectopediaObject> E get(E defaultObject)
			{
				if (buildingDefaultObjects)
					return defaultObject;
				else
					return (E) defaultObject.clone();
			}

		private static HashMap<Class<? extends EffectopediaObject>, EffectopediaObject> defaultObjects = new HashMap<Class<? extends EffectopediaObject>, EffectopediaObject>();

		public static EffectopediaObject getDefaultNew(Class<? extends EffectopediaObject> c)
			{
				return defaultObjects.get(c);
			}

		private static HashMap<Class<? extends EffectopediaObject>, String> defaultCategories = new HashMap<Class<? extends EffectopediaObject>, String>();
		static
			{
				// I. - Extended PubChem categorisation
				defaultCategories.put(Initiator_ChemicalStructure.class, "I.");
				defaultCategories.put(Substance.class, "I.");
				// II. - Effectopedia categorisation for substance data (dose, time
				// responses)
				defaultCategories.put(SubstanceData.class, "II.");
				// Effectopedia categorisation for the links between two effects
				defaultCategories.put(Link_EffectToEffect.class, "III.");
				// Effectopedia categorisation for analytic functions
				defaultCategories.put(EffectopediaObject.class, "IV.");
				// Effectopedia categorisation for global model properties
				defaultCategories.put(Method_InSilicoGlobalModel.class, "V.");
			}

		public static String getCategoryForClass(Class<? extends EffectopediaObject> forClass)
			{
				String topLevelCategory = defaultCategories.get(forClass);
				return (topLevelCategory == null) ? "." : topLevelCategory;
			}

		public static final DataSource																				DEFAULT_DATA_SOURCE					= null;
		public static final ContextDimension														DEFAULT_LBO													= new ContextDimension(null, DEFAULT_DATA_SOURCE, DefaultTextProperties.INSTANCE.getDefault("DEFAULT_LBO_NAME"), 12,
				ContextDimension.DENUMERABLE, true, DataValue_IntRef.class).<ContextDimension> makeItDefault();
		public static final ContextDimension														DEFAULT_LIFE_STAGE						= new ContextDimension(null, DEFAULT_DATA_SOURCE, DefaultTextProperties.INSTANCE.getDefault("DEFAULT_LIFE_STAGE_NAME"), 9,
				ContextDimension.DENUMERABLE, true, DataValue_IntRef.class).<ContextDimension> makeItDefault();
		public static final ContextDimension														DEFAULT_BIO_COMPARTMENT	= new ContextDimension(null, DEFAULT_DATA_SOURCE, DefaultTextProperties.INSTANCE.getDefault("DEFAULT_BIO_COMPARTMENT_NAME"),
				ContextDimension.UNKNOWN, ContextDimension.DENUMERABLE, false, DataValue_String.class).<ContextDimension> makeItDefault();
		public static final ContextDimension_Hierarchical	DEFAULT_TAXONOMY								= new ContextDimension_Hierarchical(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_TAXONOMY_NAME"), (FixedValuesList) DefaultFixedListValues.INSTANCE.getList("DEFAULT_TAXONOMY_LIST"))
						.<ContextDimension_Hierarchical> makeItDefault();
		public static final ContextDimension														DEFAULT_SEX													= new ContextDimension(null, DEFAULT_DATA_SOURCE, DefaultTextProperties.INSTANCE.getDefault("DEFAULT_SEX_NAME"), 7,
				ContextDimension.DENUMERABLE, true, DataValue_IntRef.class).<ContextDimension> makeItDefault();

		public static final ContextDimension														DEFAULT_TIME_TO_EFFECT		= new ContextDimension(null, DEFAULT_DATA_SOURCE, DefaultTextProperties.INSTANCE.getDefault("DEFAULT_TIME_TO_EFFECT_NAME"),
				ContextDimension.INFINITE, ContextDimension.CONTINEUS, true, DataValue_Float.class).<ContextDimension> makeItDefault();
		public static final ContextDimension														DEFAULT_EFFECT_TERM					= new ContextDimension(null, DEFAULT_DATA_SOURCE, DefaultTextProperties.INSTANCE.getDefault("DEFAULT_EFFECT_TERM_NAME"), 5,
				ContextDimension.DENUMERABLE, true, DataValue_IntRef.class).<ContextDimension> makeItDefault();
		public static final ContextDimension														DEFAULT_OTHER											= new ContextDimension(null, DEFAULT_DATA_SOURCE, DefaultTextProperties.INSTANCE.getDefault("DEFAULT_OTHER_NAME"),
				ContextDimension.UNKNOWN, ContextDimension.CONTINEUS, false, DataValue_String.class).<ContextDimension> makeItDefault();
		static
			{
		ContextDimension.NAME_INDEX.put("Gender", DEFAULT_SEX);
		ContextDimension.NAME_INDEX.put("Location", DEFAULT_BIO_COMPARTMENT);
		ContextDimension.NAME_INDEX.put("Time to Effect", DEFAULT_TIME_TO_EFFECT);
		ContextDimension.NAME_INDEX.put("Time to Effect Term", DEFAULT_EFFECT_TERM);
		ContextDimension.NAME_INDEX.put("Biological Taxonomy", DEFAULT_TAXONOMY);
		ContextDimension.NAME_INDEX.put("Taxonomical Aplicability", DEFAULT_TAXONOMY);

		ContextDimension.NAME_INDEX.put("Unspecified", DEFAULT_OTHER);
	}

		public static final Context DEFAULT_CONTEXT = new Context();
		static
			{

				DEFAULT_LBO.setDefaultValues(DefaultFixedListValues.INSTANCE.getList("DEFAULT_LBO_LIST"));
				DEFAULT_CONTEXT.add(DEFAULT_LBO.oneTimeSetActionTypeIDs(ActionTypes.CD_LBO_VALUE, ActionTypes.CD_LBO_UNIT));
				DEFAULT_CONTEXT.add(DEFAULT_LIFE_STAGE.oneTimeSetActionTypeIDs(ActionTypes.CD_LIFE_STAGE_VALUE, ActionTypes.CD_LIFE_STAGE_UNIT).setSearchable(false));
				DEFAULT_CONTEXT.add(DEFAULT_BIO_COMPARTMENT.oneTimeSetActionTypeIDs(ActionTypes.CD_LOCATION_VALUE, ActionTypes.CD_LOCATION_UNIT));
				DEFAULT_CONTEXT.add(DEFAULT_TAXONOMY.oneTimeSetActionTypeIDs(ActionTypes.CD_TAXONOMY_VALUE, ActionTypes.CD_TAXONOMY_UNIT).setSearchable(false));
				DEFAULT_LIFE_STAGE.setDefaultValues(DefaultFixedListValues.INSTANCE.getList("DEFAULT_LIFE_STAGE_LIST"));
				DEFAULT_SEX.setDefaultValues(DefaultFixedListValues.INSTANCE.getList("DEFAULT_SEX_LIST"));
				DEFAULT_CONTEXT.add(DEFAULT_SEX.oneTimeSetActionTypeIDs(ActionTypes.CD_SEX_VALUE, ActionTypes.CD_SEX_UNIT));
				DEFAULT_EFFECT_TERM.setDefaultValues(DefaultFixedListValues.INSTANCE.getList("DEFAULT_EFFECT_TERM_LIST"));
				DEFAULT_CONTEXT.add(DEFAULT_EFFECT_TERM.oneTimeSetActionTypeIDs(ActionTypes.CD_EFFECT_TERM_VALUE, ActionTypes.CD_EFFECT_TERM_UNIT));
				DEFAULT_CONTEXT.add(DEFAULT_TIME_TO_EFFECT.oneTimeSetActionTypeIDs(ActionTypes.CD_TIME_TO_EFFECT_VALUE, ActionTypes.CD_TIME_TO_EFFECT_UNIT));
				DEFAULT_CONTEXT.add(DEFAULT_OTHER.oneTimeSetActionTypeIDs(ActionTypes.CD_OTHER_VALUE, ActionTypes.CD_OTHER_UNIT).setSearchable(false));
			}
		public static final ObjectPropertyType											CHEMICAL_INFO_SMILES;
		public static final ObjectPropertyType											CHEMICAL_INFO_MOL_FORMULA;
		public static final ObjectPropertyTypesContainer	CHEMICAL_STRUCT_IDENT	= new ObjectPropertyTypesContainer();
		static
			{
				// System.out.print(DataValue_String.class.getSuperclass().getName());
				/*
				 * Categorisation of chemical description and properties is derived from
				 * PubChem. When additional properties are included the letter "a" is added
				 * to the numbering
				 */
				CHEMICAL_STRUCT_IDENT.add(new ObjectPropertyType("I.3.3.1.", "CAS", "CASNO", SearchIndices.CHEMICAL_CASNO, Initiator_ChemicalStructure.class, "Chemical Abstract Service registry number",
						DataValue_Integer.class, null, ActionTypes.CI_CASNO).<ObjectPropertyType> makeItDefault());
				CHEMICAL_STRUCT_IDENT.add(new ObjectPropertyType("I.3.1.1.", "IUPAC Name", "IUPAC_NAME", SearchIndices.CHEMICAL_IUPAC_NAME, Initiator_ChemicalStructure.class, "IUPAC Name", DataValue_String.class,
						null, ActionTypes.CI_IUPAC_NAME).<ObjectPropertyType> makeItDefault());
				CHEMICAL_INFO_SMILES = new ObjectPropertyType("I.3.1.4.", "Canonical SMILES", "SMILES", SearchIndices.CHEMICAL_SMILES, Initiator_ChemicalStructure.class, "SMIELS", DataValue_String.class, null,
						ActionTypes.CI_SMILES).<ObjectPropertyType> makeItDefault();
				CHEMICAL_STRUCT_IDENT.add(CHEMICAL_INFO_SMILES);
				CHEMICAL_INFO_MOL_FORMULA = new ObjectPropertyType("I.3.2.", "Molecular Formula", "Formula", SearchIndices.CHEMICAL_MOL_FORMULA, Initiator_ChemicalStructure.class, "Molecular formula",
						DataValue_String.class, null, ActionTypes.CI_MOL_FORMULA).<ObjectPropertyType> makeItDefault();
			}

		public static final ObjectPropertyTypesContainer CHEMICAL_PROPERTIES = new ObjectPropertyTypesContainer();
		static
			{
				CHEMICAL_PROPERTIES.add((new ObjectPropertyType("I.4.1.", "Molecular Weight", "MOL_WEIGHT", null, Initiator_ChemicalStructure.class, "Mol. Wight", DataValue_Float.class, new DataUnit("g/mol"),
						ActionTypes.CP_MOL_WEIGHT).makeDocumented(null)).<ObjectPropertyType> makeItDefault());
				CHEMICAL_PROPERTIES
						.add((new ObjectPropertyType("I.4.2.7.", "Density", "Density", null, Initiator_ChemicalStructure.class, "Density", DataValue_Float.class, new DataUnit("g/cm^3"), ActionTypes.CP_DENSITY)
								.makeDocumented("Conditions")).<ObjectPropertyType> makeItDefault());
				CHEMICAL_PROPERTIES.add((new ObjectPropertyType("I.4.2.4.", "Melting Point", "Melting_point", null, Initiator_ChemicalStructure.class, "Melting point", DataValue_Float.class, new DataUnit("\u00B0C"),
						ActionTypes.CP_MELTING_POINT).makeDocumented(null)).<ObjectPropertyType> makeItDefault());
				CHEMICAL_PROPERTIES.add((new ObjectPropertyType("I.4.2.3.", "Boiling Point", "Boiling_point", null, Initiator_ChemicalStructure.class, "Boiling point", DataValue_Float.class, new DataUnit("\u00B0C"),
						ActionTypes.CP_BOILING_POINT).makeDocumented(null)).<ObjectPropertyType> makeItDefault());
				CHEMICAL_PROPERTIES
						.add((new ObjectPropertyType("I.4.2.8.", "LogP", "CLog(P)", null, Initiator_ChemicalStructure.class, "CLog(P)", DataValue_Float.class, null, ActionTypes.CP_CLOGP).makeDocumented("Conditions"))
								.<ObjectPropertyType> makeItDefault());
				CHEMICAL_PROPERTIES.add((new ObjectPropertyType("I.4.2.10.", "Water Solubility", "Solubility_in_water", null, Initiator_ChemicalStructure.class, "Solubility in water", DataValue_Float.class,
						new DataUnit("g/100ml"), ActionTypes.CP_WATER_SOL).makeDocumented("Conditions")).<ObjectPropertyType> makeItDefault());
			}

		public static ObjectProperties									DEFAULT_SUBSTANCE_IDENT;
		public static ObjectProperties									DEFAULT_SUBSTANCE_PROP;

		public static final ObjectPropertyType	STRUCTURE_2DIMAGE											= new ObjectPropertyType("I.1.", "2D Structure", "2D_Image", null, Initiator_ChemicalStructure.class, "2D Structure image",
				DataValue_String.class, null, ActionTypes.CP_2D_IMAGE).<ObjectPropertyType> makeItDefault();
		public static final ObjectPropertyType	STRUCTURE_SYNONYMS										= new ObjectPropertyType("I.3.4.2.", "Synonyms", "Synonyms", null, Initiator_ChemicalStructure.class, "Synonyms",
				DataValue_String.class, null, ActionTypes.CP_SYNONYMS).<ObjectPropertyType> makeItDefault();

		public static final DescriptionSection	DEFAULT_DESCRIPTION_SECTION	= new DescriptionSection(null, null, DefaultTextProperties.INSTANCE.getDefault("DEFAULT_DESCRIPTION_SECTION_TITLE"),
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_DESCRIPTION_SECTION_CONTENT")).<DescriptionSection> makeItDefault();
		static
			{
				defaultObjects.put(DescriptionSection.class, DEFAULT_DESCRIPTION_SECTION);
			}

		public static final DescriptionSection	DEFAULT_PATHWAY_DS								= new DescriptionSection(null, DEFAULT_DATA_SOURCE, DefaultTextProperties.INSTANCE.getDefault("DEFAULT_PATHWAY_DS_TITLE"),
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_PATHWAY_DS_CONTENT")).<DescriptionSection> makeItDefault();

		public static final DescriptionSection	DEFAULT_LINK_STMIE_DS					= new DescriptionSection(null, DEFAULT_DATA_SOURCE, DefaultTextProperties.INSTANCE.getDefault("DEFAULT_LINK_STMIE_DS_TITLE"),
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_LINK_STMIE_DS_CONTENT")).<DescriptionSection> makeItDefault();

		public static final DescriptionSection	DEFAULT_LINK_STRS_DS						= new DescriptionSection(null, DEFAULT_DATA_SOURCE, DefaultTextProperties.INSTANCE.getDefault("DEFAULT_LINK_STRS_DS_TITLE"),
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_LINK_STRS_DS_CONTENT")).<DescriptionSection> makeItDefault();

		public static final DescriptionSection	DEFAULT_LINK_ETE_DS							= new DescriptionSection(null, DEFAULT_DATA_SOURCE, DefaultTextProperties.INSTANCE.getDefault("DEFAULT_LINK_ETE_DS_TITLE"),
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_LINK_ETE_DS_CONTENT")).<DescriptionSection> makeItDefault();

		public static final DescriptionSection	DEFAULT_MIE_DS												= new DescriptionSection(null, DEFAULT_DATA_SOURCE, DefaultTextProperties.INSTANCE.getDefault("DEFAULT_MIE_DS_TITLE"),
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_MIE_DS_CONTENT")).<DescriptionSection> makeItDefault();
		public static final DescriptionSection	DEFAULT_DE_DS													= new DescriptionSection(null, DEFAULT_DATA_SOURCE, DefaultTextProperties.INSTANCE.getDefault("DEFAULT_DE_DS_TITLE"),
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_DE_DS_CONTENT")).<DescriptionSection> makeItDefault();
		public static final DescriptionSection	DEFAULT_TEST_DS											= new DescriptionSection(null, DEFAULT_DATA_SOURCE, DefaultTextProperties.INSTANCE.getDefault("DEFAULT_TEST_DS_TITLE"),
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_TEST_DS_CONTENT")).<DescriptionSection> makeItDefault();
		public static final DescriptionSection	DEFAULT_TEST_DS_METHODS			= new DescriptionSection(null, DEFAULT_DATA_SOURCE, DefaultTextProperties.INSTANCE.getDefault("DEFAULT_TEST_DS_METHODS_TITLE"),
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_TEST_DS_METHODS_CONTENT")).<DescriptionSection> makeItDefault();
		public static final DescriptionSection	DEFAULT_TEST_DS_GUIDLINES	= new DescriptionSection(null, DEFAULT_DATA_SOURCE, DefaultTextProperties.INSTANCE.getDefault("DEFAULT_TEST_DS_GUIDLINES_TITLE"),
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_TEST_DS_GUIDLINES_CONTENT")).<DescriptionSection> makeItDefault();
		public static final DescriptionIDs					DEFAULT_DS_IDS												= new DescriptionIDs(null, DEFAULT_DATA_SOURCE, DescriptionSection.class).<DescriptionIDs> makeItDefault();
		static
			{
				DEFAULT_DS_IDS.addAndKeepItDefault(DEFAULT_TEST_DS);
				DEFAULT_TEST_DS.setParent(DEFAULT_DS_IDS);
				DEFAULT_DS_IDS.addAndKeepItDefault(DEFAULT_TEST_DS_METHODS);
				DEFAULT_TEST_DS_METHODS.setParent(DEFAULT_DS_IDS);
				DEFAULT_DS_IDS.addAndKeepItDefault(DEFAULT_TEST_DS_GUIDLINES);
				DEFAULT_TEST_DS_GUIDLINES.setParent(DEFAULT_DS_IDS);
			}
		public static final DescriptionIDs DEFAULT_PATHWAY_IDS = new DescriptionIDs(null, DEFAULT_DATA_SOURCE, DescriptionSection.class).<DescriptionIDs> makeItDefault();
		static
			{
				DEFAULT_PATHWAY_IDS.addAndKeepItDefault(DEFAULT_PATHWAY_DS);
				DEFAULT_PATHWAY_DS.setParent(DEFAULT_PATHWAY_IDS);
			}
		public static final DescriptionIDs DEFAULT_LINK_STMIE_IDS = new DescriptionIDs(null, DEFAULT_DATA_SOURCE, DescriptionSection.class).<DescriptionIDs> makeItDefault();
		static
			{
				DEFAULT_LINK_STMIE_IDS.addAndKeepItDefault(DEFAULT_LINK_STMIE_DS);
				DEFAULT_LINK_STMIE_DS.setParent(DEFAULT_LINK_STMIE_IDS);
			}
		public static final DescriptionIDs DEFAULT_LINK_STRS_IDS = new DescriptionIDs(null, DEFAULT_DATA_SOURCE, DescriptionSection.class).<DescriptionIDs> makeItDefault();
		static
			{
				DEFAULT_LINK_STRS_IDS.addAndKeepItDefault(DEFAULT_LINK_STRS_DS);
				DEFAULT_LINK_STRS_DS.setParent(DEFAULT_LINK_STRS_IDS);
			}
		public static final DescriptionIDs	DEFAULT_LINK_ETE_IDS	= new DescriptionIDs(null, DEFAULT_DATA_SOURCE, DescriptionSection.class).<DescriptionIDs> makeItDefault();

		public static final DescriptionIDs	DEFAULT_MIE_IDS						= new DescriptionIDs(null, DEFAULT_DATA_SOURCE, DescriptionSection.class).<DescriptionIDs> makeItDefault();
		static
			{
				DEFAULT_MIE_IDS.addAndKeepItDefault(DEFAULT_MIE_DS);
				DEFAULT_MIE_DS.setParent(DEFAULT_MIE_IDS);
			}
		public static final DescriptionIDs DEFAULT_DE_IDS = new DescriptionIDs(null, DEFAULT_DATA_SOURCE, DescriptionSection.class).<DescriptionIDs> makeItDefault();
		static
			{
				DEFAULT_DE_IDS.addAndKeepItDefault(DEFAULT_DE_DS);
				DEFAULT_DE_DS.setParent(DEFAULT_DE_IDS);
			}
		public static final DescriptionIDs DEFAULT_TEST_IDS = new DescriptionIDs(null, DEFAULT_DATA_SOURCE, DescriptionSection.class).<DescriptionIDs> makeItDefault();
		static
			{
				DEFAULT_TEST_IDS.addAndKeepItDefault(DEFAULT_TEST_DS);
				DEFAULT_TEST_DS.setParent(DEFAULT_TEST_IDS);
			}
		public static final IDs<Lab>																											DEFAULT_LAB_IDS												= new IDs<Lab>(null, DEFAULT_DATA_SOURCE, Lab.class).<IDs<Lab>> makeItDefault();
		public static final ReferenceIDs<Effect>															DEFAULT_REL_EFFECT_IDS					= new ReferenceIDs<Effect>(null, DEFAULT_DATA_SOURCE, Effect.class).<IDs<Effect>> makeItDefault();
		public static final ReferenceIDs<Test>																	DEFAULT_REL_TEST_IDS							= new ReferenceIDs<Test>(null, DEFAULT_DATA_SOURCE, Test.class).<IDs<Test>> makeItDefault();

		public static final ReferenceIDs<Reference>												DEFAULT_REFERENCES_REFIDS		= new ReferenceIDs<Reference>(null, DEFAULT_DATA_SOURCE, Reference.class).<ReferenceIDs<Reference>> makeItDefault();
		public static final ReferenceIDs<Link_EffectToEffect>		DEFAULT_LINKS_ETE_REFIDS			= new ReferenceIDs<Link_EffectToEffect>(null, DEFAULT_DATA_SOURCE, Link_EffectToEffect.class)
				.<ReferenceIDs<Link_EffectToEffect>> makeItDefault();
		public static final ReferenceIDs<Test>																	DEFAULT_TESTS_REFIDS							= new ReferenceIDs<Test>(null, DEFAULT_DATA_SOURCE, Test.class).<ReferenceIDs<Test>> makeItDefault();
		public static final ReferenceIDs<Link_ChemStructToMIE>	DEFAULT_LINKN_STMIE_REFIDS	= new ReferenceIDs<Link_ChemStructToMIE>(null, DEFAULT_DATA_SOURCE, Link_ChemStructToMIE.class)
				.<ReferenceIDs<Link_ChemStructToMIE>> makeItDefault();
		public static final ReferenceIDs<Link>																	DEFAULT_CHEMICAL_REFIDS				= new ReferenceIDs<Link>(null, DEFAULT_DATA_SOURCE, Link.class).<ReferenceIDs<Link>> makeItDefault();
		public static ReferenceIDs<Substance>																		DEFAULT_SUBSTANCE_REFIDS;

		public static final ReferenceIDs<Pathway>														DEFAULT_PATHWAY_REFIDS					= new ReferenceIDs<Pathway>(null, DEFAULT_DATA_SOURCE, Pathway.class).<ReferenceIDs<Pathway>> makeItDefault();
		public static final ReferenceID<Initiator>													DEFAULT_REFERENCE_I								= new ReferenceID<Initiator>(null, DEFAULT_DATA_SOURCE, Initiator.class).<ReferenceID<Initiator>> makeItDefault();
		public static final ReferenceID<Effect>																DEFAULT_REFERENCE_E								= new ReferenceID<Effect>(null, DEFAULT_DATA_SOURCE, Effect.class).<ReferenceID<Effect>> makeItDefault();

		public static final IDs<PathwayElement>																DEFAULT_PE_IDS													= new IDs<PathwayElement>(null, DEFAULT_DATA_SOURCE, PathwayElement.class).<IDs<PathwayElement>> makeItDefault();

		public static final Initiator_StructuralAlerts									DEFAULT_STRUCTURAL_ALERT							= new Initiator_StructuralAlerts().<Initiator_StructuralAlerts> makeItDefault();
		public static final Link_ChemStructToChemStruct								DEFAULT_LINK_CSTCS									= new Link_ChemStructToChemStruct().<Link_ChemStructToChemStruct> makeItDefault();
		public static final Initiator_ChemicalStructure								DEFAULT_CHEM_STRUCTURE					= new Initiator_ChemicalStructure().<Initiator_ChemicalStructure> makeItDefault();
		public static final Substance																										DEFAULT_SUBSTANCE										= new Substance(DEFAULT_CHEM_STRUCTURE, DEFAULT_DATA_SOURCE).<Substance> makeItDefault();

		public static final Link_ChemStructToMIE															DEFAULT_LINK_CSTMIE								= new Link_ChemStructToMIE().<Link_ChemStructToMIE> makeItDefault();
		public static final Effect_MolecularInitiatingEvent				DEFAULT_MIE																= new Effect_MolecularInitiatingEvent().<Effect_MolecularInitiatingEvent> makeItDefault();
		public static final Effect_DownstreamEffect												DEFAULT_DOWNSTREAM_EFFECT		= new Effect_DownstreamEffect().<Effect_DownstreamEffect> makeItDefault();
		public static final Effect_AdverseOutcome														DEFAULT_ADVERSE_OUTCOME				= new Effect_AdverseOutcome().<Effect_AdverseOutcome> makeItDefault();
		public static final Effect_Endpoint																				DEFAULT_ENDPOINT											= new Effect_Endpoint().<Effect_Endpoint> makeItDefault();
		public static final Test																															DEFAULT_TEST															= new Test().<Test> makeItDefault();
		public static final Link_EffectToEffect																DEFAULT_LINK_ETE											= new Link_EffectToEffect().<Link_EffectToEffect> makeItDefault();
		public static final Initiator																										DEFAULT_INITIATOR										= new Initiator().<Initiator> makeItDefault();
		public static final Reference																										DEFAULT_REFERENCE										= new Reference().<Reference> makeItDefault();

		public static final Pathway																												DEFAULT_PATHWAY												= new Pathway().<Pathway> makeItDefault();

		// In order to keep DefaultID compatible with older version new objects could
		// be added only the the end of Default objects class.

		// additions after version 0.932 below;

		public static final DescriptionSection																	DEFAULT_BIOPERT_DS									= new DescriptionSection(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_BIOPERT_DS_TITLE"), DefaultTextProperties.INSTANCE.getDefault("DEFAULT_BIOPERT_DS_CONTENT")).<DescriptionSection> makeItDefault();

		public static final DescriptionIDs																					DEFAULT_BIOPERT_IDS								= new DescriptionIDs(null, DEFAULT_DATA_SOURCE, DescriptionSection.class).<DescriptionIDs> makeItDefault();
		static
			{
				DEFAULT_BIOPERT_IDS.addAndKeepItDefault(DEFAULT_BIOPERT_DS);
				DEFAULT_BIOPERT_DS.setParent(DEFAULT_BIOPERT_IDS);
			}

		public static final Initiator_BiologcalPerturbation	DEFAULT_BIOLOGICAL_PERTURBATION		= new Initiator_BiologcalPerturbation().<Initiator_BiologcalPerturbation> makeItDefault();

		// additions after version 0.940 below;

		public static final ReferenceID<Test>															DEFAULT_REFERENCE_T								= new ReferenceID<Test>(null, DEFAULT_DATA_SOURCE, Test.class).<ReferenceID<Test>> makeItDefault();

		public static final DescriptionSection														DEFAULT_IN_SILICO_TEST_DS		= new DescriptionSection(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_IN_SILICO_TEST_DS_TITLE"), DefaultTextProperties.INSTANCE.getDefault("DEFAULT_IN_SILICO_TEST_DS_CONTENT")).<DescriptionSection> makeItDefault();
		public static final DescriptionSection														DEFAULT_IN_CHEMICO_TEST_DS	= new DescriptionSection(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_IN_CHEMICO_TEST_DS_TITLE"), DefaultTextProperties.INSTANCE.getDefault("DEFAULT_IN_CHEMICO_TEST_DS_CONTENT"))
						.<DescriptionSection> makeItDefault();
		public static final DescriptionSection														DEFAULT_IN_VITRO_TEST_DS			= new DescriptionSection(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_IN_VITRO_TEST_DS_TITLE"), DefaultTextProperties.INSTANCE.getDefault("DEFAULT_IN_VITRO_TEST_DS_CONTENT")).<DescriptionSection> makeItDefault();
		public static final DescriptionSection														DEFAULT_IN_VIVO_TEST_DS				= new DescriptionSection(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_IN_VIVO_TEST_DS_TITLE"), DefaultTextProperties.INSTANCE.getDefault("DEFAULT_IN_VIVO_TEST_DS_CONTENT")).<DescriptionSection> makeItDefault();
		public static final DescriptionSection														DEFAULT_TRM_DS													= new DescriptionSection(null, DEFAULT_DATA_SOURCE, DefaultTextProperties.INSTANCE.getDefault("DEFAULT_TRM_DS_TITLE"),
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_TRM_DS_CONTENT")).<DescriptionSection> makeItDefault();
		static
			{
				DEFAULT_DS_IDS.addAndKeepItDefault(DEFAULT_IN_SILICO_TEST_DS);
				DEFAULT_IN_SILICO_TEST_DS.setParent(DEFAULT_DS_IDS);
				DEFAULT_DS_IDS.addAndKeepItDefault(DEFAULT_IN_CHEMICO_TEST_DS);
				DEFAULT_IN_CHEMICO_TEST_DS.setParent(DEFAULT_DS_IDS);
				DEFAULT_DS_IDS.addAndKeepItDefault(DEFAULT_IN_VITRO_TEST_DS);
				DEFAULT_IN_VITRO_TEST_DS.setParent(DEFAULT_DS_IDS);
				DEFAULT_DS_IDS.addAndKeepItDefault(DEFAULT_IN_VIVO_TEST_DS);
				DEFAULT_IN_VIVO_TEST_DS.setParent(DEFAULT_DS_IDS);
			}

		public static final DescriptionIDs DEFAULT_IN_SILICO_TEST_IDS = new DescriptionIDs(null, DEFAULT_DATA_SOURCE, DescriptionSection.class).<DescriptionIDs> makeItDefault();
		static
			{
				DEFAULT_IN_SILICO_TEST_IDS.addAndKeepItDefault(DEFAULT_IN_SILICO_TEST_DS);
				DEFAULT_IN_SILICO_TEST_IDS.setParent(DEFAULT_IN_SILICO_TEST_IDS);
			}
		public static final DescriptionIDs DEFAULT_IN_CHEMICO_TEST_IDS = new DescriptionIDs(null, DEFAULT_DATA_SOURCE, DescriptionSection.class).<DescriptionIDs> makeItDefault();
		static
			{
				DEFAULT_IN_CHEMICO_TEST_IDS.addAndKeepItDefault(DEFAULT_IN_CHEMICO_TEST_DS);
				DEFAULT_IN_CHEMICO_TEST_IDS.setParent(DEFAULT_IN_CHEMICO_TEST_IDS);
			}
		public static final DescriptionIDs DEFAULT_IN_VITRO_TEST_IDS = new DescriptionIDs(null, DEFAULT_DATA_SOURCE, DescriptionSection.class).<DescriptionIDs> makeItDefault();
		static
			{
				DEFAULT_IN_VITRO_TEST_IDS.addAndKeepItDefault(DEFAULT_IN_VITRO_TEST_DS);
				DEFAULT_IN_VITRO_TEST_IDS.setParent(DEFAULT_IN_VITRO_TEST_IDS);
			}
		public static final DescriptionIDs DEFAULT_IN_VIVO_TEST_IDS = new DescriptionIDs(null, DEFAULT_DATA_SOURCE, DescriptionSection.class).<DescriptionIDs> makeItDefault();
		static
			{
				DEFAULT_IN_VIVO_TEST_IDS.addAndKeepItDefault(DEFAULT_IN_VIVO_TEST_DS);
				DEFAULT_IN_VIVO_TEST_IDS.setParent(DEFAULT_IN_VIVO_TEST_IDS);
			}
		public static final DescriptionIDs DEFAULT_TRM_IDS = new DescriptionIDs(null, DEFAULT_DATA_SOURCE, DescriptionSection.class).<DescriptionIDs> makeItDefault();
		static
			{
				DEFAULT_TRM_IDS.addAndKeepItDefault(DEFAULT_TRM_DS);
				DEFAULT_TRM_DS.setParent(DEFAULT_TRM_IDS);
			}

		public static final TestResponseMapping																						DEFAULT_TEST_RESPONCE_MAPPNIG				= new TestResponseMapping().<TestResponseMapping> makeItDefault();
		public static final ReferenceIDs<TestResponseMapping>								DEFAULT_TEST_RESP_MAPPING_REFIDS	= new ReferenceIDs<TestResponseMapping>(null, DEFAULT_DATA_SOURCE, TestResponseMapping.class)
				.<ReferenceIDs<TestResponseMapping>> makeItDefault();

		public static final ReferenceIDs<Method_InSilicoGlobalModel>	DEFAULT_GLOBAL_MODEL_RIDS;
		public static final Test_InSilico																												DEFAULT_IN_SILICO_TEST											= new Test_InSilico().<Test_InSilico> makeItDefault();
		public static final Test_InChemico																											DEFAULT_IN_CHEMICO_TEST										= new Test_InChemico().<Test_InChemico> makeItDefault();
		public static final Test_InVitro																													DEFAULT_IN_VITRO_TEST												= new Test_InVitro().<Test_InVitro> makeItDefault();
		public static final Test_InVivo																														DEFAULT_IN_VIVO_TEST													= new Test_InVivo().<Test_InVivo> makeItDefault();

		// additions after version 0.945 below;

		public static final DescriptionSection																							DEFAULT_EX_VIVO_TEST_DS										= new DescriptionSection(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_EX_VIVO_TEST_DS_TITLE"), DefaultTextProperties.INSTANCE.getDefault("DEFAULT_EX_VIVO_TEST_DS_CONTENT")).<DescriptionSection> makeItDefault();
		public static final DescriptionSection																							DEFAULT_IN_LAB_TEST_DOMAIN_DS				= new DescriptionSection(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_IN_LAB_TEST_DOMAIN_DS_TITLE"), DefaultTextProperties.INSTANCE.getDefault("DEFAULT_IN_LAB_TEST_DOMAIN_DS_CONTENT"))
						.<DescriptionSection> makeItDefault();
		public static final DescriptionSection																							DEFAULT_IN_LAB_QUALITY_DOMAIN_DS	= new DescriptionSection(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_IN_LAB_TEST_QUALITY_DS_TITLE"), DefaultTextProperties.INSTANCE.getDefault("DEFAULT_IN_LAB_TEST_QUALITY_DS_CONTENT"))
						.<DescriptionSection> makeItDefault();
		public static final DescriptionSection																							DEFAULT_IN_LAB_COST_DOMAIN_DS				= new DescriptionSection(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_IN_LAB_TEST_COST_DS_TITLE"), DefaultTextProperties.INSTANCE.getDefault("DEFAULT_IN_LAB_TEST_COST_DS_CONTENT"))
						.<DescriptionSection> makeItDefault();

		public static final DescriptionIDs																											DEFAULT_EX_VIVO_TEST_IDS									= new DescriptionIDs(null, DEFAULT_DATA_SOURCE, DescriptionSection.class)
				.<DescriptionIDs> makeItDefault();
		static
			{
				DEFAULT_EX_VIVO_TEST_IDS.addAndKeepItDefault(DEFAULT_EX_VIVO_TEST_DS);
				DEFAULT_EX_VIVO_TEST_IDS.setParent(DEFAULT_EX_VIVO_TEST_IDS);
			}

		static
			{
				DEFAULT_IN_CHEMICO_TEST_IDS.addAndKeepItDefault(DEFAULT_IN_LAB_TEST_DOMAIN_DS);
				DEFAULT_IN_CHEMICO_TEST_IDS.addAndKeepItDefault(DEFAULT_IN_LAB_QUALITY_DOMAIN_DS);
				DEFAULT_IN_CHEMICO_TEST_IDS.addAndKeepItDefault(DEFAULT_IN_LAB_COST_DOMAIN_DS);
				DEFAULT_IN_VITRO_TEST_IDS.addAndKeepItDefault(DEFAULT_IN_LAB_TEST_DOMAIN_DS);
				DEFAULT_IN_VITRO_TEST_IDS.addAndKeepItDefault(DEFAULT_IN_LAB_QUALITY_DOMAIN_DS);
				DEFAULT_IN_VITRO_TEST_IDS.addAndKeepItDefault(DEFAULT_IN_LAB_COST_DOMAIN_DS);
				DEFAULT_IN_VIVO_TEST_IDS.addAndKeepItDefault(DEFAULT_IN_LAB_TEST_DOMAIN_DS);
				DEFAULT_IN_VIVO_TEST_IDS.addAndKeepItDefault(DEFAULT_IN_LAB_QUALITY_DOMAIN_DS);
				DEFAULT_IN_VIVO_TEST_IDS.addAndKeepItDefault(DEFAULT_IN_LAB_COST_DOMAIN_DS);
				DEFAULT_EX_VIVO_TEST_IDS.addAndKeepItDefault(DEFAULT_IN_LAB_TEST_DOMAIN_DS);
				DEFAULT_EX_VIVO_TEST_IDS.addAndKeepItDefault(DEFAULT_IN_LAB_QUALITY_DOMAIN_DS);
				DEFAULT_EX_VIVO_TEST_IDS.addAndKeepItDefault(DEFAULT_IN_LAB_COST_DOMAIN_DS);
			}

		public static final Test_ExVivo								DEFAULT_EX_VIVO_TEST	= new Test_ExVivo().<Test_ExVivo> makeItDefault();

		public static final DescriptionSection	DEFAULT_METHOD_DS				= new DescriptionSection(null, DEFAULT_DATA_SOURCE, DefaultTextProperties.INSTANCE.getDefault("DEFAULT_METHOD_DS_TITLE"),
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_METHOD_DS_CONTENT")).<DescriptionSection> makeItDefault();

		public static final DescriptionIDs					DEFAULT_METHOD_IDS			= new DescriptionIDs(null, DEFAULT_DATA_SOURCE, DescriptionSection.class).<DescriptionIDs> makeItDefault();
		static
			{
				DEFAULT_METHOD_IDS.addAndKeepItDefault(DEFAULT_METHOD_DS);
				DEFAULT_METHOD_DS.setParent(DEFAULT_METHOD_IDS);
			}

		public static final Method													DEFAULT_METHOD												= new Method().<Method> makeItDefault();

		public static final DescriptionSection	DEFAULT_INVESTIGATION_DS		= new DescriptionSection(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_INVESTIGATION_METHOD_DS_TITLE"), DefaultTextProperties.INSTANCE.getDefault("DEFAULT_INVESTIGATION_METHOD_DS_CONTENT"))
						.<DescriptionSection> makeItDefault();
		public static final DescriptionIDs					DEFAULT_INVESTIGATION_IDS	= new DescriptionIDs(null, DEFAULT_DATA_SOURCE, DescriptionSection.class).<DescriptionIDs> makeItDefault();
		static
			{
				DEFAULT_INVESTIGATION_IDS.addAndKeepItDefault(DEFAULT_INVESTIGATION_DS);
				DEFAULT_INVESTIGATION_DS.setParent(DEFAULT_INVESTIGATION_IDS);
			}

		public static final ReferenceIDs<Method_Study>	DEFAULT_REL_STUDIES_REFIDS	= new ReferenceIDs<Method_Study>(null, DEFAULT_DATA_SOURCE, Method_Study.class);
		public static final Method_Investigation							DEFAULT_INVESTIGATION						= new Method_Investigation().<Method_Investigation> makeItDefault();

		public static final DescriptionSection									DEFAULT_STUDY_DS											= new DescriptionSection(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_STUDY_METHOD_DS_TITLE"), DefaultTextProperties.INSTANCE.getDefault("DEFAULT_STUDY_METHOD_DS_CONTENT")).<DescriptionSection> makeItDefault();
		public static final DescriptionIDs													DEFAULT_STUDY_IDS										= new DescriptionIDs(null, DEFAULT_DATA_SOURCE, DescriptionSection.class).<DescriptionIDs> makeItDefault();
		static
			{
				DEFAULT_STUDY_IDS.addAndKeepItDefault(DEFAULT_STUDY_DS);
				DEFAULT_STUDY_DS.setParent(DEFAULT_STUDY_IDS);
			}
		public static final ReferenceIDs<Test>																	DEFAULT_REL_TEST_REFIDS				= new ReferenceIDs<Test>(null, DEFAULT_DATA_SOURCE, Test.class).<ReferenceIDs<Test>> makeItDefault();

		public static final Method_Study																							DEFAULT_STUDY														= new Method_Study().<Method_Study> makeItDefault();

		public static final ReferenceIDs<Method_Investigation>	DEFAULT_INVESTIGATION_RIDS	= new ReferenceIDs<Method_Investigation>(null, DEFAULT_DATA_SOURCE, Method_Investigation.class)
				.<ReferenceIDs<Method_Investigation>> makeItDefault();
		public static final ReferenceIDs<Method_Study>									DEFAULT_STUDY_RIDS									= new ReferenceIDs<Method_Study>(null, DEFAULT_DATA_SOURCE, Method_Study.class)
				.<ReferenceIDs<Method_Study>> makeItDefault();

		// to preserve the order of creation all descendant classes of Test_InLab
		// do not have their Investigation and Study references initialized
		static
			{
				DEFAULT_IN_CHEMICO_TEST.InitDefaultInLabTestReferences();
				DEFAULT_IN_VITRO_TEST.InitDefaultInLabTestReferences();
				DEFAULT_IN_VIVO_TEST.InitDefaultInLabTestReferences();
				DEFAULT_EX_VIVO_TEST.InitDefaultInLabTestReferences();
			}

		static
			{
				defaultObjects.put(Method_Investigation.class, DEFAULT_INVESTIGATION);
				defaultObjects.put(Method_Study.class, DEFAULT_STUDY);
			}

		// additions after version 0.9455 below;
		public static final DescriptorType																											DEFAULT_LOG_MOL_CONCENTRATION;
		public static final ObjectPropertyType																							DEFAULT_D_RESP_TESTED_CHEMICAL;
		public static final ObjectPropertyType																							DEFAULT_D_RESP_REFERENCE_CHEMICAL;
		public static final ObjectPropertyTypesContainer													DEFAULT_D_RESP_PLUS_REF_DATA_TYPE;
		public static final ObjectPropertyTypesContainer													DEFAULT_D_RESP_DATA_TYPE;
		public static final ObjectProperties																									DEFAULT_D_RESP_AND_REF_DATA;
		public static final ObjectProperties																									DEFAULT_D_RESP_DATA;

		public static final SubstanceData																												DEFAULT_SUBSTANCE_DATA							= new SubstanceData().<SubstanceData> makeItDefault();																																																						// DefaultID
																																																																																																																																																																																																								// =
																																																																																																																																																																																																								// -103
		public static final SubstanceData_InLab																						DEFAULT_SUBSTANCE_DATA_INLAB	= new SubstanceData_InLab().<SubstanceData_InLab> makeItDefault();

		public static final ReferenceID<Lab>																									DEFAULT_REFERENCE_L										= new ReferenceID<Lab>(null, DEFAULT_DATA_SOURCE, Lab.class).<ReferenceID<Lab>> makeItDefault();

		public static final IDs<SubstanceData>																							DEFAULT_SUBST_DATA_RIDS						= new IDs<SubstanceData>(null, DEFAULT_DATA_SOURCE, SubstanceData.class)
				.<IDs<SubstanceData>> makeItDefault();

		// additions after version 0.95 below;

		public static final ReferenceID<Initiator_ChemicalStructure>	DEFAULT_CONST_REFCHEM								= new ReferenceID<Initiator_ChemicalStructure>(null, DEFAULT_DATA_SOURCE, Initiator_ChemicalStructure.class)
				.<ReferenceID<Initiator_ChemicalStructure>> makeItDefault();

		public static final Constituent																														DEFAULT_CONSTITUENT										= new Constituent().<Constituent> makeItDefault();

		public static final IDs<Constituent>																									DEFAULT_COMPOSIOTION									= new IDs<Constituent>(null, DEFAULT_DATA_SOURCE, Constituent.class).<IDs<Constituent>> makeItDefault();

		public static final ObjectPropertyType																							UUID																									= new ObjectPropertyType("I.3.3.a1.", "UUID", "UUID", SearchIndices.UUID, EffectopediaObject.class,
				"Universally unique identifier", DataValue_String.class, null, ActionTypes.UUID).<ObjectPropertyType> makeItDefault();
		static
			{
				CHEMICAL_STRUCT_IDENT
						.add(new ObjectPropertyType("I.3.1.2.", "InChI", "InChI", SearchIndices.CHEMICAL_INCHI, Initiator_ChemicalStructure.class, "InChi", DataValue_String.class, null, ActionTypes.CI_INCHI)
								.<ObjectPropertyType> makeItDefault());
				CHEMICAL_STRUCT_IDENT.add(
						new ObjectPropertyType("I.3.1.3.", "InChI Key", "InChI_Key", SearchIndices.CHEMICAL_INCHI_KEY, Initiator_ChemicalStructure.class, "InChi", DataValue_String.class, null, ActionTypes.CI_INCHI_KEY)
								.<ObjectPropertyType> makeItDefault());
				CHEMICAL_STRUCT_IDENT.add(UUID);
				CHEMICAL_STRUCT_IDENT.add(CHEMICAL_INFO_MOL_FORMULA);

				DEFAULT_GLOBAL_MODEL_RIDS = new ReferenceIDs<Method_InSilicoGlobalModel>(null, DEFAULT_DATA_SOURCE, Method_InSilicoGlobalModel.class);

			}

		public static final DescriptionSection	DEFAULT_GLOBALMODEL_DS		= new DescriptionSection(null, DEFAULT_DATA_SOURCE, DefaultTextProperties.INSTANCE.getDefault("DEFAULT_GLOBAL_MODEL_DS_TITLE"),
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_GLOBAL_MODEL_DS_CONTENT")).<DescriptionSection> makeItDefault();
		public static final DescriptionIDs					DEFAULT_GLOBALMODEL_IDS	= new DescriptionIDs(null, DEFAULT_DATA_SOURCE, DescriptionSection.class).<DescriptionIDs> makeItDefault();
		static
			{
				DEFAULT_GLOBALMODEL_IDS.addAndKeepItDefault(DEFAULT_GLOBALMODEL_DS);
				DEFAULT_GLOBALMODEL_DS.setParent(DEFAULT_GLOBALMODEL_IDS);
			}

		public static final ContextDimension DEFAULT_GENERATION = new ContextDimension(null, DEFAULT_DATA_SOURCE, DefaultTextProperties.INSTANCE.getDefault("DEFAULT_GENERATION_NAME"), 6,
				ContextDimension.DENUMERABLE, true, DataValue_IntRef.class).<ContextDimension> makeItDefault();
		static
			{
				DEFAULT_GENERATION.setDefaultValues(DefaultFixedListValues.INSTANCE.getList("DEFAULT_GENERATION_LIST"));
				DEFAULT_CONTEXT.add(DEFAULT_GENERATION.oneTimeSetActionTypeIDs(ActionTypes.CD_GENERATION_VALUE, ActionTypes.CD_GENERATION_UNIT));
			}
		public static final Method_InSilicoGlobalModel DEFAULT_GLOBAL_MODEL = new Method_InSilicoGlobalModel().<Method_InSilicoGlobalModel> makeItDefault();

		static
			{
				DEFAULT_LOG_MOL_CONCENTRATION = new DescriptorType("chemical_concentration", "Measured chemical concentration", DataValue_Double.class, new DataUnit("logM")).<DescriptorType> makeItDefault();

				DEFAULT_D_RESP_TESTED_CHEMICAL = (new ObjectPropertyType("II.1.1.", "Tested substance log concentration response", "Tested_Subst_Log_Conc_Response", null, SubstanceData.class, "Measured response",
						DataValue_Double.class, null, ActionTypes.SP_DOSE_RESP).makeDocumented(null)).<ObjectPropertyType> makeItDefault();
				DEFAULT_D_RESP_TESTED_CHEMICAL.getDescriptors().add(DEFAULT_LOG_MOL_CONCENTRATION);

				DEFAULT_D_RESP_REFERENCE_CHEMICAL = (new ObjectPropertyType("II.1.2.", "Reference substance log concentration response", "Reference_Subst_Log_Conc_Response", null, SubstanceData.class,
						"Reference response", DataValue_Double.class, null, ActionTypes.SP_DOSE_RESP).makeDocumented(null)).<ObjectPropertyType> makeItDefault();
				DEFAULT_D_RESP_REFERENCE_CHEMICAL.getDescriptors().add(DEFAULT_LOG_MOL_CONCENTRATION);

				DEFAULT_D_RESP_DATA_TYPE = new ObjectPropertyTypesContainer();

				DEFAULT_D_RESP_DATA_TYPE.add(DEFAULT_D_RESP_TESTED_CHEMICAL);

				DEFAULT_D_RESP_DATA = new ObjectProperties(DEFAULT_SUBSTANCE_DATA, DEFAULT_D_RESP_DATA_TYPE);

				DEFAULT_D_RESP_PLUS_REF_DATA_TYPE = new ObjectPropertyTypesContainer();

				DEFAULT_D_RESP_PLUS_REF_DATA_TYPE.add(DEFAULT_D_RESP_TESTED_CHEMICAL);
				DEFAULT_D_RESP_PLUS_REF_DATA_TYPE.add(DEFAULT_D_RESP_REFERENCE_CHEMICAL);

				DEFAULT_D_RESP_AND_REF_DATA = new ObjectProperties(DEFAULT_SUBSTANCE_DATA, DEFAULT_D_RESP_PLUS_REF_DATA_TYPE);

				DEFAULT_SUBSTANCE_DATA.setObjectPropertiesAndKeepItDefault(DEFAULT_D_RESP_DATA);
				DEFAULT_SUBSTANCE_DATA_INLAB.setObjectPropertiesAndKeepItDefault(DEFAULT_D_RESP_DATA.clone(DEFAULT_SUBSTANCE_DATA_INLAB, DEFAULT_DATA_SOURCE));

			}
		public static final ObjectPropertyTypesContainer	DEFAULT_MODEL_PARAMETERS_TYPE	= new ObjectPropertyTypesContainer();
		public static final ObjectProperties													DEFAULT_MODEL_PARAMETERS						= new ObjectProperties(DEFAULT_GLOBAL_MODEL, DEFAULT_MODEL_PARAMETERS_TYPE);

		public static final ObjectPropertyTypesContainer	SUBSTANCE_IDENT															= new ObjectPropertyTypesContainer();
		public static final ObjectPropertyTypesContainer	SUBSTANCE_PROP																= new ObjectPropertyTypesContainer();
		static
			{
				SUBSTANCE_IDENT.add(UUID);
				SUBSTANCE_IDENT.add(new ObjectPropertyType("I.3.3.a2.", "Substance type", "TYPE", null, Substance.class, "Substance Type", DataValue_String.class, null, ActionTypes.SUBST_TYPE)
						.<ObjectPropertyType> makeItDefault());
				SUBSTANCE_IDENT
						.add(new ObjectPropertyType("I.3.3.a3.", "IUC Name", "IUC_NAME", null, Substance.class, "IUC Name", DataValue_String.class, null, ActionTypes.S_IUC_NAME).<ObjectPropertyType> makeItDefault());

				DEFAULT_SUBSTANCE_IDENT = new ObjectProperties(DEFAULT_SUBSTANCE, SUBSTANCE_IDENT);
				DEFAULT_SUBSTANCE_PROP = new ObjectProperties(DEFAULT_SUBSTANCE, SUBSTANCE_PROP);

				DEFAULT_SUBSTANCE_REFIDS = new ReferenceIDs<Substance>(null, DEFAULT_DATA_SOURCE, Substance.class).<ReferenceIDs<Substance>> makeItDefault();
			}

		public static final DescriptionSection																										DEFAULT_PATHWAY_BACKGROUND_DS				= new DescriptionSection(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_PATHWAY_BACKGROUND_TITLE"), DefaultTextProperties.INSTANCE.getDefault("DEFAULT_PATHWAY_BACKGROUND_CONTENT"))
						.<DescriptionSection> makeItDefault();

		public static final DescriptionSection																										DEFAULT_PATHWAY_QUANT_CONSID_DS		= new DescriptionSection(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_PATHWAY_QUANT_CONSID_DS_TITLE"), DefaultTextProperties.INSTANCE.getDefault("DEFAULT_PATHWAY_QUANT_CONSID_DS_CONTENT"))
						.<DescriptionSection> makeItDefault();

		public static final DescriptionSection																										DEFAULT_PATHWAY_APP_DOMAIN_DS				= new DescriptionSection(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_PATHWAY_APP_DOMAIN_DS_TITLE"), DefaultTextProperties.INSTANCE.getDefault("DEFAULT_PATHWAY_APP_DOMAIN_DS_CONTENT"))
						.<DescriptionSection> makeItDefault();
		public static final DescriptionSection																										DEFAULT_PATHWAY_APPLICATION_DS			= new DescriptionSection(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_PATHWAY_APPLICATION_DS_TITLE"), DefaultTextProperties.INSTANCE.getDefault("DEFAULT_PATHWAY_APPLICATION_DS_CONTENT"))
						.<DescriptionSection> makeItDefault();

		public static final DescriptionSection																										DEFAULT_LINK_QUANT_UNDERST_DS				= new DescriptionSection(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_LINK_QUANT_UNDERST_DS_TITLE"), DefaultTextProperties.INSTANCE.getDefault("DEFAULT_LINK_QUANT_UNDERST_DS_CONTENT"))
						.<DescriptionSection> makeItDefault();

		public static final DescriptionSection																										DEFAULT_LINK_TAXONOMIC_APPLIC_DS	= new DescriptionSection(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_LINK_TAXONOMIC_APPLIC_DS_TITLE"), DefaultTextProperties.INSTANCE.getDefault("DEFAULT_LINK_TAXONOMIC_APPLIC_DS_CONTENT"))
						.<DescriptionSection> makeItDefault();
		public static final int																																									LINK_WOE_INDEX																			= 1;

		public static final DescriptionSection																										DEFAULT_EFFECT_TEST_SUMMARY_DS			= new DescriptionSection(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_EFFECT_TEST_SUMMARY_DS_TITLE"), DefaultTextProperties.INSTANCE.getDefault("DEFAULT_EFFECT_TEST_SUMMARY_DS_CONTENT"))
						.<DescriptionSection> makeItDefault();

		public static final DescriptionIDs																														DEFAULT_EFFECT_ESSENTIALITY_IDS		= new DescriptionIDs(null, DEFAULT_DATA_SOURCE, DescriptionSection.class)
				.<DescriptionIDs> makeItDefault();

		public static final DescriptionSection_Structured															DEFAULT_EFFECT_ESSENTIALITY_DSS		= new DescriptionSection_Structured(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_EFFECT_ESSENTIALITY_DSS_TITLE"), null, DEFAULT_EFFECT_ESSENTIALITY_IDS).<DescriptionSection_Structured> makeItDefault();
		public static final ReferenceIDs<DescriptionSection_Structured>	DEFAULT_LINK_ESSENTIALITY_IDS				= new ReferenceIDs<DescriptionSection_Structured>(null, DEFAULT_DATA_SOURCE,
				DescriptionSection_Structured.class).<ReferenceIDs<DescriptionSection_Structured>> makeItDefault();

		public static final DescriptionSection_Structured															DEFAULT_LINK_ESSENTIALITY_DSS				= new DescriptionSection_Structured(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_LINK_ESSENTIALITY_DSS_TITLE"), null, DEFAULT_LINK_ESSENTIALITY_IDS).<DescriptionSection_Structured> makeItDefault();

		public static final ReferenceIDW<Effect>																								DEFAULT_EFFECT_ESSENTIALITY_R				= new ReferenceIDW<Effect>(null, DEFAULT_DATA_SOURCE, Effect.class, 0.0D)
				.<ReferenceIDW<Effect>> makeItDefault();
		public static final DescriptionSection_Structured															DEFAULT_EFFECT_ESSENTIALITY_DS			= new DescriptionSection_Structured(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_EFFECT_ESSENTIALITY_DS_TITLE"), null, DEFAULT_EFFECT_ESSENTIALITY_R).<DescriptionSection_Structured> makeItDefault();
		public static final ReferenceIDW<Link_EffectToEffect>											DEFAULT_LINK_ESSENTIALITY_R						= new ReferenceIDW<Link_EffectToEffect>(null, DEFAULT_DATA_SOURCE, Link_EffectToEffect.class, 0.0D)
				.<ReferenceIDW<Link_EffectToEffect>> makeItDefault();

		public static final DescriptionSection_Structured															DEFAULT_LINK_ESSENTIALITY_DS					= new DescriptionSection_Structured(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_LINK_ESSENTIALITY_DS_TITLE"), DefaultTextProperties.INSTANCE.getDefault("DEFAULT_LINK_ESSENTIALITY_DS_CONTENT"), DEFAULT_LINK_ESSENTIALITY_R)
						.<DescriptionSection_Structured> makeItDefault();

		public static final String[]																																				DEFAULT_ESSENTIALITY_WEIGHTS					= new String[]
			{ "undefined", "weak", "moderate", "strong", "nonessential" };
		static
			{
				DEFAULT_LINK_ETE_IDS.addAndKeepItDefault(DEFAULT_LINK_ETE_DS);
				DEFAULT_LINK_ETE_DS.setParent(DEFAULT_LINK_ETE_IDS);
				DEFAULT_LINK_ETE_IDS.addAndKeepItDefault(DEFAULT_LINK_ESSENTIALITY_DS);
				DEFAULT_LINK_ESSENTIALITY_DS.setParent(DEFAULT_LINK_ETE_IDS);
				DEFAULT_LINK_ETE_IDS.addAndKeepItDefault(DEFAULT_LINK_TAXONOMIC_APPLIC_DS);
				DEFAULT_LINK_TAXONOMIC_APPLIC_DS.setParent(DEFAULT_LINK_ETE_IDS);
				DEFAULT_LINK_ETE_IDS.addAndKeepItDefault(DEFAULT_LINK_QUANT_UNDERST_DS);
				DEFAULT_LINK_QUANT_UNDERST_DS.setParent(DEFAULT_LINK_ETE_IDS);
				DEFAULT_LINK_STMIE_IDS.addAndKeepItDefault(DEFAULT_LINK_TAXONOMIC_APPLIC_DS);
				DEFAULT_LINK_TAXONOMIC_APPLIC_DS.setParent(DEFAULT_LINK_STMIE_IDS);
				DEFAULT_LINK_STMIE_IDS.addAndKeepItDefault(DEFAULT_LINK_QUANT_UNDERST_DS);
				DEFAULT_LINK_QUANT_UNDERST_DS.setParent(DEFAULT_LINK_STMIE_IDS);

				DEFAULT_MIE_IDS.addAndKeepItDefault(DEFAULT_EFFECT_TEST_SUMMARY_DS);
				DEFAULT_DE_IDS.addAndKeepItDefault(DEFAULT_EFFECT_TEST_SUMMARY_DS);
			}

		static
			{
				DEFAULT_PATHWAY_IDS.addAndKeepItDefault(DEFAULT_EFFECT_ESSENTIALITY_DSS);
				DEFAULT_EFFECT_ESSENTIALITY_DSS.setParent(DEFAULT_PATHWAY_IDS);
				DEFAULT_PATHWAY_IDS.addAndKeepItDefault(DEFAULT_LINK_ESSENTIALITY_DSS);
				DEFAULT_LINK_ESSENTIALITY_DSS.setParent(DEFAULT_PATHWAY_IDS);
				DEFAULT_PATHWAY.setEssentiality(new EssetialityDescription(DEFAULT_EFFECT_ESSENTIALITY_DSS, DEFAULT_LINK_ESSENTIALITY_DSS));

				DEFAULT_PATHWAY_IDS.addAndKeepItDefault(DEFAULT_PATHWAY_QUANT_CONSID_DS);
				DEFAULT_PATHWAY_QUANT_CONSID_DS.setParent(DEFAULT_PATHWAY_IDS);

				DEFAULT_PATHWAY_IDS.addAndKeepItDefault(DEFAULT_PATHWAY_APP_DOMAIN_DS);
				DEFAULT_PATHWAY_APP_DOMAIN_DS.setParent(DEFAULT_PATHWAY_IDS);
				DEFAULT_PATHWAY_IDS.addAndKeepItDefault(DEFAULT_PATHWAY_APPLICATION_DS);
				DEFAULT_PATHWAY_APPLICATION_DS.setParent(DEFAULT_PATHWAY_IDS);
			}

		public static final DescriptorType	DEFAULT_STDEV_ERROR		= new DescriptorType("stdiv_error", "Standard diviation error", DataValue_Double.class, null).<DescriptorType> makeItDefault();

		public static final DescriptorType	DEFAULT_SEM_ERROR				= new DescriptorType("sem_error", "Standard error of mean", DataValue_Double.class, null).<DescriptorType> makeItDefault();
		public static final DescriptorType	DEFAULT_CI95_ERROR			= new DescriptorType("ci95_error", "95% Confidence interval of mean", DataValue_Double.class, null).<DescriptorType> makeItDefault();
		public static final DescriptorType	DEFAULT_MEDIAN_VALUE	= new DescriptorType("median", "Median value", DataValue_Double.class, null).<DescriptorType> makeItDefault();

		public static final DescriptorType	DEFAULT_REPET_COUNT		= new DescriptorType("n_repet", "Repretitions count", DataValue_Double.class, null).<DescriptorType> makeItDefault();
		static
			{
				DEFAULT_D_RESP_TESTED_CHEMICAL.getDescriptors().add(DEFAULT_STDEV_ERROR);
				DEFAULT_D_RESP_TESTED_CHEMICAL.getDescriptors().add(DEFAULT_SEM_ERROR);
				DEFAULT_D_RESP_TESTED_CHEMICAL.getDescriptors().add(DEFAULT_CI95_ERROR);
				DEFAULT_D_RESP_TESTED_CHEMICAL.getDescriptors().add(DEFAULT_MEDIAN_VALUE);
				DEFAULT_D_RESP_TESTED_CHEMICAL.getDescriptors().add(DEFAULT_REPET_COUNT);

				DEFAULT_D_RESP_REFERENCE_CHEMICAL.getDescriptors().add(DEFAULT_STDEV_ERROR);
				DEFAULT_D_RESP_REFERENCE_CHEMICAL.getDescriptors().add(DEFAULT_SEM_ERROR);
				DEFAULT_D_RESP_REFERENCE_CHEMICAL.getDescriptors().add(DEFAULT_CI95_ERROR);
				DEFAULT_D_RESP_REFERENCE_CHEMICAL.getDescriptors().add(DEFAULT_MEDIAN_VALUE);
				DEFAULT_D_RESP_REFERENCE_CHEMICAL.getDescriptors().add(DEFAULT_REPET_COUNT);
			}

		public static final DataTemplateType													DEFAULT_DR_DTT_MEAN_STDEV		= new DataTemplateType("Dose response data for the mean and standard devidation, number of replicates")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_DR_DTT_MEAN_SEM				= new DataTemplateType("Dose response data for the mean and standard error, number of replicates")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_DR_DTT_MEAN_CI95			= new DataTemplateType("Dose response data for the mean and 95% confidence interval, number of replicates")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_DR_DTT_MEAN_MINMAX	= new DataTemplateType("Dose response data for the mean, minimum and maximum responce, number of replicates")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_DR_DTT_ALL									= new DataTemplateType("Dose response data for the mean, min, max, st. dev,st err, 96% conf. int, number of replicates")
				.<DataTemplateType> makeItDefault();

		public static final DataTemplateType													DEFAULT_RR_DTT_MEAN_STDEV		= new DataTemplateType("Mean response response data with standard devidation").<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_RR_DTT_MEAN_SEM				= new DataTemplateType("Mean response response data with standard error").<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_RR_DTT_MEAN_CI95			= new DataTemplateType("Mean response response data with  95% confidence interval").<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_RR_DTT_MEAN_MINMAX	= new DataTemplateType("Mean response response data with minimum and maximum responce")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_RR_DTT_ALL									= new DataTemplateType("Mean response response data with min, max, st. dev,st err, 96% conf. int, number of replicates")
				.<DataTemplateType> makeItDefault();
		public static final DescriptorType															DEFAULT_UPSTREAM_CAUSE					= new DescriptorType("upstream_cause", "upstream (key) event / effect", DataValue_Double.class, null)
				.<DescriptorType> makeItDefault();

		public static final ObjectPropertyType											DEFAULT_RESPONSE_RESPONSE		= (new ObjectPropertyType("III.1.", "Response response", "Response_Response", null, Link_EffectToEffect.class,
				"response response", DataValue_Double.class, null, ActionTypes.L_RESP_RESP).makeDocumented(null)).<ObjectPropertyType> makeItDefault();
		public static final ObjectPropertyTypesContainer	DEFAULT_RESP_RESP_TYPE					= new ObjectPropertyTypesContainer();

		static
			{
				DEFAULT_RESPONSE_RESPONSE.getDescriptors().add(DEFAULT_UPSTREAM_CAUSE);
				DEFAULT_RESPONSE_RESPONSE.getDescriptors().add(DEFAULT_STDEV_ERROR);
				DEFAULT_RESPONSE_RESPONSE.getDescriptors().add(DEFAULT_SEM_ERROR);
				DEFAULT_RESPONSE_RESPONSE.getDescriptors().add(DEFAULT_CI95_ERROR);
				DEFAULT_RESPONSE_RESPONSE.getDescriptors().add(DEFAULT_MEDIAN_VALUE);
				DEFAULT_RESPONSE_RESPONSE.getDescriptors().add(DEFAULT_REPET_COUNT);

				DEFAULT_RESP_RESP_TYPE.add(DEFAULT_RESPONSE_RESPONSE);
			}

		public static final ObjectProperties													DEFAULT_RESP_RESP_DATA						= new ObjectProperties(DEFAULT_LINK_ETE, DEFAULT_RESP_RESP_TYPE);

		public static final ObjectPropertyTypesContainer	DEFAULT_ANALYTIC_FUNCTION			= new ObjectPropertyTypesContainer();

		public static final ObjectPropertyType											DEFAULT_FUNCTION												= (new ObjectPropertyType("IV.1.", "Analytic Function", "Function", null, EffectopediaObject.class,
				"mathematical expression", DataValue_Double.class, null, ActionTypes.EO_FN_EXPRESSION).makeDocumented(null)).<ObjectPropertyType> makeItDefault();
		public static final ObjectPropertyType											DEFAULT_PARAMETER_DESCRS				= (new ObjectPropertyType("IV.1.1.", "Function_Parameters", "Function_Parameters", null, EffectopediaObject.class,
				"function parameters", DataValue_Double.class, null, ActionTypes.EO_FN_PARAMETERS).makeDocumented(null)).<ObjectPropertyType> makeItDefault();
		public static final ObjectPropertyTypesContainer	DEFAULT_FUNCTION_PARAMETERS	= new ObjectPropertyTypesContainer();

		public static final DescriptorType															DEFAULT_PARAMETER_NAME						= new DescriptorType("parameter_name", "descriptive name of a function parameter", DataValue_String.class, null)
				.<DescriptorType> makeItDefault();
		public static final DescriptorType															DEFAULT_MATH_EXPRESSION					= new DescriptorType("expression", "mathematical expression", DataValue_String.class, null)
				.<DescriptorType> makeItDefault();
		static
			{
				DEFAULT_PARAMETER_DESCRS.getDescriptors().add(DEFAULT_PARAMETER_NAME);
				DEFAULT_FUNCTION_PARAMETERS.add(DEFAULT_PARAMETER_DESCRS);
				DEFAULT_FUNCTION.setSubPropertyTypes(DEFAULT_FUNCTION_PARAMETERS);
				DEFAULT_FUNCTION.getDescriptors().add(DEFAULT_MATH_EXPRESSION);
				// DEFAULT_FUNCTION.getDescriptors().add(DEFAULT_UPSTREAM_CAUSE);
				DEFAULT_ANALYTIC_FUNCTION.add(DEFAULT_FUNCTION);
			}

		// additions after version 0.962 below;

		public static final DescriptorType															DEFAULT_TIME																					= new DescriptorType("time", "Time", DataValue_Double.class, null).<DescriptorType> makeItDefault();
		public static final int																										TIME_COURSE_COUNT																= 4;
		public static final int																										TIME_COURSE_UPSTREAM													= 0;
		public static final int																										TIME_COURSE_DOWNSTREAM											= 1;
		public static final int																										TIME_COURSE_UPSTREAM_REF_CMPND			= 2;
		public static final int																										TIME_COURSE_DOWNSTREAM_REF_CMPND	= 3;
		public static final ObjectPropertyType[]									DEFAULT_TIME_COURSE														= new ObjectPropertyType[TIME_COURSE_COUNT];
		public static final ObjectPropertyTypesContainer	DEFAULT_LINK_TIME_COURSES								= new ObjectPropertyTypesContainer();

		public static final DataTemplateType													DEFAULT_TC_DTT_MEAN_STDEV								= new DataTemplateType("Time course data for the mean and standard devidation").<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_TC_DTT_MEAN_SEM										= new DataTemplateType("Time course data for the mean and standard error").<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_TC_DTT_MEAN_CI95									= new DataTemplateType("Time course data for the mean and 95% confidence interval")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_TC_DTT_MEAN_MINMAX							= new DataTemplateType("Time course data for the mean, minimum and maximum responce")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_TC_DTT_ALL															= new DataTemplateType(
				"Time course data for the mean, min, max, st. dev,st err, 96% conf. int, number of replicates").<DataTemplateType> makeItDefault();

		public static final ObjectProperties													DEFAULT_LINK_TIME_COURSE_DATA;
		static
			{
				for (int i = TIME_COURSE_COUNT - 1; i >= 0; i--)
					{
						DEFAULT_TIME_COURSE[i] = (new ObjectPropertyType("II.2.", "Time cource response", "Time_course_response_" + i, null, SubstanceData.class, "time course", DataValue_Double.class, null,
								ActionTypes.SP_TIME_COURSE).makeDocumented(null)).<ObjectPropertyType> makeItDefault();
						DEFAULT_TIME_COURSE[i].getDescriptors().add(DEFAULT_TIME);
						DEFAULT_TIME_COURSE[i].getDescriptors().add(DEFAULT_LOG_MOL_CONCENTRATION);
						DEFAULT_TIME_COURSE[i].getDescriptors().add(DEFAULT_STDEV_ERROR);
						DEFAULT_TIME_COURSE[i].getDescriptors().add(DEFAULT_SEM_ERROR);
						DEFAULT_TIME_COURSE[i].getDescriptors().add(DEFAULT_CI95_ERROR);
						DEFAULT_TIME_COURSE[i].getDescriptors().add(DEFAULT_MEDIAN_VALUE);
						DEFAULT_TIME_COURSE[i].getDescriptors().add(DEFAULT_REPET_COUNT);
					}
				DEFAULT_LINK_TIME_COURSES.add(DEFAULT_TIME_COURSE[TIME_COURSE_UPSTREAM]);
				DEFAULT_LINK_TIME_COURSES.add(DEFAULT_TIME_COURSE[TIME_COURSE_DOWNSTREAM]);
				DEFAULT_LINK_TIME_COURSE_DATA = new ObjectProperties(DEFAULT_LINK_ETE, DEFAULT_LINK_TIME_COURSES);
			}

		public static final ReferenceIDs<EffectopediaObject> DEFAULT_FN_REL_SUPPORT_EVIDENCE_IDS = new ReferenceIDs<EffectopediaObject>(null, DEFAULT_DATA_SOURCE, EffectopediaObject.class)
				.<ReferenceIDs<EffectopediaObject>> makeItDefault();
		static
			{
				DEFAULT_FN_REL_SUPPORT_EVIDENCE_IDS.addAndKeepItDefault(DEFAULT_TEST);
				DEFAULT_FN_REL_SUPPORT_EVIDENCE_IDS.addAndKeepItDefault(DEFAULT_TEST);
				DEFAULT_FN_REL_SUPPORT_EVIDENCE_IDS.addAndKeepItDefault(DEFAULT_SUBSTANCE_DATA);
				DEFAULT_FN_REL_SUPPORT_EVIDENCE_IDS.addAndKeepItDefault(DEFAULT_SUBSTANCE_DATA);
				DEFAULT_FN_REL_SUPPORT_EVIDENCE_IDS.addAndKeepItDefault(DEFAULT_STUDY);
			}

		// additions after version 0.963 below;

		public static final DescriptionSection					DEFAULT_TRANSF_SET_BIO_CONTEXT_DS	= new DescriptionSection(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_TRANSF_SET_BIO_CONTEXT_DS_TITLE"), DefaultTextProperties.INSTANCE.getDefault("DEFAULT_TRANSF_SET_BIO_CONTEXT_DS_CONTENT"))
						.<DescriptionSection> makeItDefault();

		public static final DescriptionSection					DEFAULT_TRANSF_SET_APPL_DOMAIN_DS	= new DescriptionSection(null, DEFAULT_DATA_SOURCE,
				DefaultTextProperties.INSTANCE.getDefault("DEFAULT_TRANSF_SET_APPL_DOMAIN_DS_TITLE"), DefaultTextProperties.INSTANCE.getDefault("DEFAULT_TRANSF_SET_APPL_DOMAIN_DS_CONTENT"))
						.<DescriptionSection> makeItDefault();

		public static final DescriptionIDs									DEFAULT_TRANSFORMATION_SET_IDS				= new DescriptionIDs(null, DEFAULT_DATA_SOURCE, DescriptionSection.class).<DescriptionIDs> makeItDefault();
		public static final IDs<TransformationSet>	DEFAULT_TRANSFORMATION_SETS							= new IDs<TransformationSet>(null, DEFAULT_DATA_SOURCE, TransformationSet.class)
				.<IDs<TransformationSet>> makeItDefault();
		static
			{
				DEFAULT_TRANSFORMATION_SET_IDS.addAndKeepItDefault(DEFAULT_TRANSF_SET_BIO_CONTEXT_DS);
				DEFAULT_TRANSF_SET_BIO_CONTEXT_DS.setParent(DEFAULT_TRANSFORMATION_SET_IDS);
				DEFAULT_TRANSFORMATION_SET_IDS.addAndKeepItDefault(DEFAULT_TRANSF_SET_APPL_DOMAIN_DS);
				DEFAULT_TRANSF_SET_APPL_DOMAIN_DS.setParent(DEFAULT_TRANSFORMATION_SET_IDS);
			}

		public static final TransformationSet DEFAULT_TRANSFORMATION_SET = new TransformationSet(DEFAULT_TEST_RESPONCE_MAPPNIG, DEFAULT_DATA_SOURCE).<TransformationSet> makeItDefault();
		static
			{
				defaultObjects.put(TransformationSet.class, DEFAULT_TRANSFORMATION_SET);
				DEFAULT_FN_REL_SUPPORT_EVIDENCE_IDS.addAndKeepItDefault(DEFAULT_TRANSFORMATION_SET);
				DEFAULT_FN_REL_SUPPORT_EVIDENCE_IDS.addAndKeepItDefault(DEFAULT_TRANSFORMATION_SET);
				// additions after version 0.964 below;
				DEFAULT_REL_STUDIES_REFIDS.makeItDefault();// BugFix: the
																																															// DEFAULT_REL_STUDIES_REFIDS was
																																															// not made a default object
				DEFAULT_GLOBAL_MODEL_RIDS.makeItDefault(); // BugFix: the
																																															// DEFAULT_GLOBAL_MODEL_RIDS was
																																															// not made a default object
			}

		// additions after version 0.972 below;

		public static final ObjectPropertyType											DEFAULT_GM_SYS_REQ_OS												= new ObjectPropertyType("V.1.2.1.", "Operating system", "operating_system", null, Method_InSilicoGlobalModel.class,
				"Supported operating system(s)", DataValue_String.class, null, ActionTypes.GM_SYS_REQ).<ObjectPropertyType> makeItDefault();
		public static final ObjectPropertyType											DEFAULT_GM_SYS_REQ_PROG_LANGUAGE	= new ObjectPropertyType("V.1.2.2.", "Programming language", "programming_language", null,
				Method_InSilicoGlobalModel.class, "Programming language used", DataValue_String.class, null, ActionTypes.GM_SYS_REQ)
						.addFixedValuesList((FixedValuesList) DefaultFixedListValues.INSTANCE.get("PROG_LANG")).<ObjectPropertyType> makeItDefault();

		public static final ObjectPropertyType											DEFAULT_GM_SYS_REQ_LIBRARIES					= new ObjectPropertyType("V.1.2.3.", "Extensions", "extensions", null, Method_InSilicoGlobalModel.class,
				"Describe all additional libraries, plugins and extensions which are not part of the stnadard package. Where possible provide links to download installation instructions", DataValue_String.class,
				null, ActionTypes.GM_SYS_REQ).<ObjectPropertyType> makeItDefault();
		public static final ObjectPropertyType											DEFAULT_GM_SYS_REQ_PROG_OPT						= new ObjectPropertyType("V.1.2.4.", "Program Options", "program_options", null, Method_InSilicoGlobalModel.class,
				"Provide instructions on how to setup all non-default options of the programing language compiler/interpreter.", DataValue_String.class, null, ActionTypes.GM_SYS_REQ)
						.<ObjectPropertyType> makeItDefault();
		public static final ObjectPropertyType											DEFAULT_GM_SYS_REQ_CMD_LINE_OPT		= new ObjectPropertyType("V.1.2.5.", "Comandline Options", "comandline_options", null,
				Method_InSilicoGlobalModel.class, "Provide any nonstandard commandline options", DataValue_String.class, null, ActionTypes.GM_SYS_REQ).<ObjectPropertyType> makeItDefault();

		public static final ObjectPropertyType											DEFAULT_GM_SYS_REQ_EST_RUNTIME			= new ObjectPropertyType("V.1.2.6.", "Runtime range", "runtime_range", null, Method_InSilicoGlobalModel.class,
				"Expected runtime using average modern hardware", DataValue_String.class, null, ActionTypes.GM_SYS_REQ).addFixedValuesList((FixedValuesList) DefaultFixedListValues.INSTANCE.get("EST_RUNTIME"))
						.<ObjectPropertyType> makeItDefault();

		public static final ObjectPropertyType											DEFAULT_GM_LICENSE															= new ObjectPropertyType("V.1.3.", "License", "license", null, Method_InSilicoGlobalModel.class,
				"Source code license", DataValue_String.class, null, ActionTypes.GM_LICENSE).<ObjectPropertyType> makeItDefault();

		public static final ObjectPropertyType											DEFAULT_GM_CITATION														= new ObjectPropertyType("V.1.4.", "Citation", "citation", null, Method_InSilicoGlobalModel.class,
				"Provide preffered citation reference", DataValue_String.class, null, ActionTypes.GM_CITATION).<ObjectPropertyType> makeItDefault();
		public static final ObjectPropertyType											DEFAULT_GM_VERSION															= new ObjectPropertyType("V.1.1.", "Version", "version", null, Method_InSilicoGlobalModel.class,
				"Global Model Version", DataValue_String.class, null, ActionTypes.GM_CITATION).<ObjectPropertyType> makeItDefault();
		public static final ObjectPropertyType											DEFAULT_GM_SYS_REQUIREMENTS						= (new ObjectPropertyType("V.1.2.", "System Requirements", "System_requirements", null,
				Method_InSilicoGlobalModel.class, "Provides a summary of the system requirements for execution of this global model", DataValue_String.class, null, ActionTypes.GM_SYS_REQ).makeCategorical())
						.<ObjectPropertyType> makeItDefault();
		public static final ObjectPropertyTypesContainer	DEFAULT_GM_METADATA														= new ObjectPropertyTypesContainer();

		public static final ObjectProperties													DEFAULT_GM_METADATA_PROP;

		static
			{
				ObjectPropertyTypesContainer DEFAULT_GM_SYS_REQ_SUBPROPERTIES_CONT = new ObjectPropertyTypesContainer();
				DEFAULT_GM_SYS_REQ_SUBPROPERTIES_CONT.add(DEFAULT_GM_SYS_REQ_OS);
				DEFAULT_GM_SYS_REQ_SUBPROPERTIES_CONT.add(DEFAULT_GM_SYS_REQ_PROG_LANGUAGE);
				DEFAULT_GM_SYS_REQ_SUBPROPERTIES_CONT.add(DEFAULT_GM_SYS_REQ_LIBRARIES);
				DEFAULT_GM_SYS_REQ_SUBPROPERTIES_CONT.add(DEFAULT_GM_SYS_REQ_PROG_OPT);
				DEFAULT_GM_SYS_REQ_SUBPROPERTIES_CONT.add(DEFAULT_GM_SYS_REQ_CMD_LINE_OPT);
				DEFAULT_GM_SYS_REQ_SUBPROPERTIES_CONT.add(DEFAULT_GM_SYS_REQ_EST_RUNTIME);
				DEFAULT_GM_SYS_REQUIREMENTS.setSubPropertyTypes(DEFAULT_GM_SYS_REQ_SUBPROPERTIES_CONT);
				ObjectProperties DEFAULT_GM_SYS_REQ_SUBPROPERTIES = new ObjectProperties(DEFAULT_GLOBAL_MODEL, DEFAULT_GM_SYS_REQ_SUBPROPERTIES_CONT);

				DEFAULT_GM_METADATA.add(DEFAULT_GM_LICENSE);
				DEFAULT_GM_METADATA.add(DEFAULT_GM_VERSION);
				DEFAULT_GM_METADATA.add(DEFAULT_GM_CITATION);
				DEFAULT_GM_METADATA.add(DEFAULT_GM_SYS_REQUIREMENTS);
				DEFAULT_GM_METADATA_PROP = new ObjectProperties(DEFAULT_GLOBAL_MODEL, DEFAULT_GM_METADATA);
				DEFAULT_GM_METADATA_PROP.getProperty(DEFAULT_GM_SYS_REQUIREMENTS).getValueAndUnit().setSubProperties(DEFAULT_GM_SYS_REQ_SUBPROPERTIES);
			}

		public static final IDs<Resource>										DEFAULT_JAVA_RECOURCE_IDS								= new IDs<Resource>(null, DEFAULT_DATA_SOURCE, Resource.class).<IDs<Resource>> makeItDefault();
		public static final Resource															DEFAULT_JAVA_EXECUTABLE_MODEL				= new Resource(DEFAULT_GLOBAL_MODEL, DEFAULT_DATA_SOURCE, "JavaExecutableModel",
				DefaultSourceCode.DEFAULT_JAVA_EXECUTABLE_MODEL, ResourceType.JAVA_SOURCE_CODE).<Resource> makeItDefault();
		public static final IDs<Resource>										DEFAULT_MATLAB_RECOURCE_IDS						= new IDs<Resource>(null, DEFAULT_DATA_SOURCE, Resource.class).<IDs<Resource>> makeItDefault();
		public static final Resource															DEFAULT_MATLAB_MODEL_INITIALIZER	= new Resource(DEFAULT_GLOBAL_MODEL, DEFAULT_DATA_SOURCE, "init", "", ResourceType.MATLAB_SOURCE_CODE)
				.<Resource> makeItDefault();
		public static final Resource															DEFAULT_MATLAB_EXECUTABLE_MODEL		= new Resource(DEFAULT_GLOBAL_MODEL, DEFAULT_DATA_SOURCE, "model", "", ResourceType.MATLAB_SOURCE_CODE)
				.<Resource> makeItDefault();
		public static final IDs<Resource>										DEFAULT_R_RECOURCE_IDS											= new IDs<Resource>(null, DEFAULT_DATA_SOURCE, Resource.class).<IDs<Resource>> makeItDefault();
		public static final Resource															DEFAULT_R_MODEL_INITIALIZER						= new Resource(DEFAULT_GLOBAL_MODEL, DEFAULT_DATA_SOURCE, "init", "", ResourceType.R_SOURCE_CODE)
				.<Resource> makeItDefault();
		public static final Resource															DEFAULT_R_EXECUTABLE_MODEL							= new Resource(DEFAULT_GLOBAL_MODEL, DEFAULT_DATA_SOURCE, "model", "", ResourceType.R_SOURCE_CODE)
				.<Resource> makeItDefault();
		public static final IDs<Resource>										DEFAULT_RECOURCE_IDS													= DEFAULT_R_RECOURCE_IDS;

		public static final SubstanceData_InSilico	DEFAULT_SUBSTANCE_DATA_INSILICO		= new SubstanceData_InSilico().<SubstanceData_InSilico> makeItDefault();
		static
			{
				DEFAULT_JAVA_RECOURCE_IDS.addAndKeepItDefault(DEFAULT_JAVA_EXECUTABLE_MODEL);
				DEFAULT_MATLAB_RECOURCE_IDS.addAndKeepItDefault(DEFAULT_MATLAB_MODEL_INITIALIZER);
				DEFAULT_MATLAB_RECOURCE_IDS.addAndKeepItDefault(DEFAULT_MATLAB_EXECUTABLE_MODEL);
				DEFAULT_R_RECOURCE_IDS.addAndKeepItDefault(DEFAULT_R_MODEL_INITIALIZER);
				DEFAULT_R_RECOURCE_IDS.addAndKeepItDefault(DEFAULT_R_EXECUTABLE_MODEL);
				DEFAULT_GLOBAL_MODEL.setResources(DEFAULT_RECOURCE_IDS);
				ObjectProperties in_silico_prop = DEFAULT_D_RESP_DATA.clone(DEFAULT_SUBSTANCE_DATA_INSILICO, DEFAULT_DATA_SOURCE);
				in_silico_prop.generate();
				DEFAULT_SUBSTANCE_DATA_INSILICO.setObjectPropertiesAndKeepItDefault(in_silico_prop);
			}

		// additions after version 0.973 below;
		public static final ObjectPropertyType											DEFAULT_TESTED_CHEMICAL											= (new ObjectPropertyType("II.3", "Tested substance measured concentration", "Tested_Subst_Measured_Log_Conc",
				null, SubstanceData.class, "Measured Concentration", DataValue_Double.class, null, ActionTypes.SP_MEASURED_CONC).makeDocumented(null)).<ObjectPropertyType> makeItDefault();;
		public static final ObjectPropertyTypesContainer	DEFAULT_STRESSOR_DATA_TYPE								= new ObjectPropertyTypesContainer();
		public static final ObjectProperties													DEFAULT_STRESSOR_DATA													= new ObjectProperties(DEFAULT_SUBSTANCE_DATA, DEFAULT_STRESSOR_DATA_TYPE);
		public static final DescriptorType															DEFAULT_LOG_MOL_NOM_CONCENTRATION	= new DescriptorType("nom_chemical_concentration", "Nominal chemical concentration", DataValue_Double.class,
				new DataUnit("logM")).<DescriptorType> makeItDefault();

		public static final DataTemplateType													DEFAULT_SC_DTT_MEAN_STDEV									= new DataTemplateType("Nominal and measured mean concentraion and standard devidation")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_SC_DTT_MEAN_SEM											= new DataTemplateType("Nominal and measured mean concentraion and standard error")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_SC_DTT_MEAN_CI95										= new DataTemplateType("Nominal and measured mean concentraion and 95% confidence interval")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_SC_DTT_MEAN_MINMAX								= new DataTemplateType("Nominal and measured mean, minimum and maximum concentraion")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_SC_DTT_ALL																= new DataTemplateType(
				"Nominal and measured concentration: mean, min, max, st. dev,st err, 96% conf. int, number of replicates").<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_SC_DTT_T_MEAN_STDEV							= new DataTemplateType("Nominal and measured time course data for the mean and standard devidation")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_SC_DTT_T_MEAN_SEM									= new DataTemplateType("Nominal and measured time course data for the mean and standard error")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_SC_DTT_T_MEAN_CI95								= new DataTemplateType("Nominal and measured time course data for the mean and 95% confidence interval")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_SC_DTT_T_MEAN_MINMAX						= new DataTemplateType("Nominal and measured time course data for the mean, minimum and maximum concentration")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_SC_DTT_T_ALL														= new DataTemplateType(
				"Nominal and measured time course data for the mean, min, max, st. dev,st err, 96% conf. int, number of replicates").<DataTemplateType> makeItDefault();

		static

			{
				DEFAULT_D_RESP_TESTED_CHEMICAL.getDescriptors().add(0, DEFAULT_TIME);

				DEFAULT_D_RESP_REFERENCE_CHEMICAL.getDescriptors().add(0, DEFAULT_TIME);

				DEFAULT_D_RESP_DATA.generate();
				DEFAULT_D_RESP_AND_REF_DATA.generate();

				DEFAULT_SUBSTANCE_DATA.getObjectProperties().generate();
				DEFAULT_SUBSTANCE_DATA_INSILICO.getObjectProperties().generate();
				DEFAULT_SUBSTANCE_DATA_INLAB.getObjectProperties().generate();

				DEFAULT_TESTED_CHEMICAL.getDescriptors().add(DEFAULT_TIME);
				DEFAULT_TESTED_CHEMICAL.getDescriptors().add(DEFAULT_LOG_MOL_NOM_CONCENTRATION);
				DEFAULT_TESTED_CHEMICAL.getDescriptors().add(DEFAULT_STDEV_ERROR);
				DEFAULT_TESTED_CHEMICAL.getDescriptors().add(DEFAULT_SEM_ERROR);
				DEFAULT_TESTED_CHEMICAL.getDescriptors().add(DEFAULT_CI95_ERROR);
				DEFAULT_TESTED_CHEMICAL.getDescriptors().add(DEFAULT_MEDIAN_VALUE);
				DEFAULT_TESTED_CHEMICAL.getDescriptors().add(DEFAULT_REPET_COUNT);

				DEFAULT_STRESSOR_DATA_TYPE.add(DEFAULT_TESTED_CHEMICAL);

				DEFAULT_STRESSOR_DATA.generate();
				DEFAULT_SUBSTANCE_DATA_INSILICO.setLocalModelInputProperties(DEFAULT_STRESSOR_DATA);
			}

		// additions after version 0.980 below;
		public static final int DEFAULT_GM_EVIDENCE_INDEX = DEFAULT_FN_REL_SUPPORT_EVIDENCE_IDS.size();
		static
			{
				DEFAULT_FN_REL_SUPPORT_EVIDENCE_IDS.addAndKeepItDefault(DEFAULT_GLOBAL_MODEL);
			}
		// additions after version 0.9875 below;
		public static final DataTemplateType													DEFAULT_TS_DTT_MEAN_STDEV		= new DataTemplateType("Time series data for the mean and standard devidation").<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_TS_DTT_MEAN_SEM				= new DataTemplateType("Time series data for the mean and standard error").<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_TS_DTT_MEAN_CI95			= new DataTemplateType("Time series data for the mean and 95% confidence interval").<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_TS_DTT_MEAN_MINMAX	= new DataTemplateType("Time series data for the mean, minimum and maximum responce").<DataTemplateType> makeItDefault();
		public static final DataTemplateType													DEFAULT_TS_DTT_ALL									= new DataTemplateType("Time series data for the mean, min, max, st. dev,st err, 96% conf. int, number of replicates")
				.<DataTemplateType> makeItDefault();

		public static final ObjectProperties													DEFAULT_TIME_SERIES_DATA;
		public static final ObjectPropertyType											DEFAULT_TIME_SERIES								= (new ObjectPropertyType("II.2.", "Time series", "Time_series", null, SubstanceData.class, "time series",
				DataValue_Double.class, null, ActionTypes.SP_TIME_COURSE).makeDocumented(null)).<ObjectPropertyType> makeItDefault();
		public static final ObjectPropertyTypesContainer	DEFAULT_TIME_SERIES_TYPE			= new ObjectPropertyTypesContainer();
		static
			{
				DEFAULT_TIME_SERIES.getDescriptors().add(DEFAULT_TIME);
				DEFAULT_TIME_SERIES.getDescriptors().add(DEFAULT_STDEV_ERROR);
				DEFAULT_TIME_SERIES.getDescriptors().add(DEFAULT_SEM_ERROR);
				DEFAULT_TIME_SERIES.getDescriptors().add(DEFAULT_CI95_ERROR);
				DEFAULT_TIME_SERIES.getDescriptors().add(DEFAULT_MEDIAN_VALUE);
				DEFAULT_TIME_SERIES.getDescriptors().add(DEFAULT_REPET_COUNT);
				DEFAULT_TIME_SERIES_TYPE.add(DEFAULT_TIME_SERIES);
				DEFAULT_TIME_SERIES_DATA = new ObjectProperties(DEFAULT_DOWNSTREAM_EFFECT, DEFAULT_TIME_SERIES_TYPE);
			}

		public static final DataTemplateType	DEFAULT_T_DTT_MEAN_STDEV					= new DataTemplateType("Time response data for the mean and standard devidation, number of replicates")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType	DEFAULT_T_DTT_MEAN_SEM							= new DataTemplateType("Time response data for the mean and standard error, number of replicates")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType	DEFAULT_T_DTT_MEAN_CI95						= new DataTemplateType("Time response data for the mean and 95% confidence interval, number of replicates")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType	DEFAULT_T_DTT_MEAN_MINMAX				= new DataTemplateType("Time response data for the mean, minimum and maximum responce, number of replicates")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType	DEFAULT_T_DTT_ALL												= new DataTemplateType("Time response data for the mean, min, max, st. dev,st err, 96% conf. int, number of replicates")
				.<DataTemplateType> makeItDefault();

		public static final DataTemplateType	DEFAULT_T_DR_DTT_MEAN_STDEV		= new DataTemplateType("Time dose response data for the mean and standard devidation, number of replicates")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType	DEFAULT_T_DR_DTT_MEAN_SEM				= new DataTemplateType("Time dose response data for the mean and standard error, number of replicates")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType	DEFAULT_T_DR_DTT_MEAN_CI95			= new DataTemplateType("Time dose response data for the mean and 95% confidence interval, number of replicates")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType	DEFAULT_T_DR_DTT_MEAN_MINMAX	= new DataTemplateType("Time dose response data for the mean, minimum and maximum responce, number of replicates")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType	DEFAULT_T_DR_DTT_ALL									= new DataTemplateType("Time dose response data for the mean, min, max, st. dev,st err, 96% conf. int, number of replicates")
				.<DataTemplateType> makeItDefault();

		static
			{
				DEFAULT_RESPONSE_RESPONSE.getDescriptors().add(0, DEFAULT_TIME);
			}
		public static final DataTemplateType																																										DEFAULT_T_RR_DTT_MEAN_STDEV		= new DataTemplateType("Mean time response response data with standard devidation")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType																																										DEFAULT_T_RR_DTT_MEAN_SEM				= new DataTemplateType("Mean time response response data with standard error")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType																																										DEFAULT_T_RR_DTT_MEAN_CI95			= new DataTemplateType("Mean time response response data with  95% confidence interval")
				.<DataTemplateType> makeItDefault();
		public static final DataTemplateType																																										DEFAULT_T_RR_DTT_MEAN_MINMAX	= new DataTemplateType(
				"Mean time response response data with minimum and maximum responce").<DataTemplateType> makeItDefault();
		public static final DataTemplateType																																										DEFAULT_T_RR_DTT_ALL									= new DataTemplateType(
				"Mean time response response data with min, max, st. dev,st err, 96% conf. int, number of replicates").<DataTemplateType> makeItDefault();
		public static final DataTemplateType[]																																								DEFAULT_D_RESP_DTT											= new DataTemplateType[]
			{ DEFAULT_DR_DTT_MEAN_STDEV, DEFAULT_DR_DTT_MEAN_SEM, DEFAULT_DR_DTT_MEAN_CI95, DEFAULT_DR_DTT_MEAN_MINMAX, DEFAULT_DR_DTT_ALL, DEFAULT_T_DTT_MEAN_STDEV, DEFAULT_T_DTT_MEAN_SEM,
			DEFAULT_T_DTT_MEAN_CI95, DEFAULT_T_DTT_MEAN_MINMAX, DEFAULT_T_DTT_ALL, DEFAULT_T_DR_DTT_MEAN_STDEV, DEFAULT_T_DR_DTT_MEAN_SEM, DEFAULT_T_DR_DTT_MEAN_CI95, DEFAULT_T_DR_DTT_MEAN_MINMAX,
			DEFAULT_T_DR_DTT_ALL };

		public static final DataTemplateType[]																																								DEFAULT_RESP_RESP_DTT								= new DataTemplateType[]
			{ DEFAULT_RR_DTT_MEAN_STDEV, DEFAULT_RR_DTT_MEAN_SEM, DEFAULT_RR_DTT_MEAN_CI95, DEFAULT_RR_DTT_MEAN_MINMAX, DEFAULT_RR_DTT_ALL, DEFAULT_T_RR_DTT_MEAN_STDEV, DEFAULT_T_RR_DTT_MEAN_SEM,
			DEFAULT_T_RR_DTT_MEAN_CI95, DEFAULT_T_RR_DTT_MEAN_MINMAX, DEFAULT_T_RR_DTT_ALL };

		public static final DataTemplateType[]																																								DEFAULT_STRESOR_DATA_DTT					= new DataTemplateType[]
			{ DEFAULT_SC_DTT_MEAN_STDEV, DEFAULT_SC_DTT_MEAN_SEM, DEFAULT_SC_DTT_MEAN_CI95, DEFAULT_SC_DTT_MEAN_MINMAX, DEFAULT_SC_DTT_ALL, DEFAULT_SC_DTT_T_MEAN_STDEV, DEFAULT_SC_DTT_T_MEAN_SEM,
			DEFAULT_SC_DTT_T_MEAN_CI95, DEFAULT_SC_DTT_T_MEAN_MINMAX, DEFAULT_SC_DTT_T_ALL };

		public static final DataTemplateType[]																																								DEFAULT_TIME_SERIES_DTT						= new DataTemplateType[]
			{ DEFAULT_TS_DTT_MEAN_STDEV, DEFAULT_TS_DTT_MEAN_SEM, DEFAULT_TS_DTT_MEAN_CI95, DEFAULT_TS_DTT_MEAN_MINMAX, DEFAULT_TS_DTT_ALL };

		public static final HashMap<ObjectPropertyTypesContainer, DataTemplateType[]>	compatiblityMAP_OPT_DTT						= new HashMap<ObjectPropertyTypesContainer, DataTemplateType[]>();
		static
			{
				compatiblityMAP_OPT_DTT.put(DEFAULT_D_RESP_DATA_TYPE, DEFAULT_D_RESP_DTT);
				compatiblityMAP_OPT_DTT.put(DEFAULT_D_RESP_PLUS_REF_DATA_TYPE, DEFAULT_D_RESP_DTT);
				compatiblityMAP_OPT_DTT.put(DEFAULT_RESP_RESP_TYPE, DEFAULT_RESP_RESP_DTT);
				compatiblityMAP_OPT_DTT.put(DEFAULT_STRESSOR_DATA_TYPE, DEFAULT_STRESOR_DATA_DTT);
				compatiblityMAP_OPT_DTT.put(DEFAULT_TIME_SERIES_TYPE, DEFAULT_TIME_SERIES_DTT);
			}

		public static final int DEFAULT_GM_METHOD_INDEX = DEFAULT_FN_REL_SUPPORT_EVIDENCE_IDS.size();
		static
			{
				DEFAULT_FN_REL_SUPPORT_EVIDENCE_IDS.addAndKeepItDefault(DEFAULT_R_EXECUTABLE_MODEL);
			}

		public static DataTemplateType[] getCompatibleTemplateTypes(ObjectPropertyTypesContainer types)
			{
				return compatiblityMAP_OPT_DTT.get(types);
			}

		public static final ReferenceID<Substance>											DEFAULT_REFERENCE_S										= new ReferenceID<Substance>(null, DEFAULT_DATA_SOURCE, Substance.class).<ReferenceID<Substance>> makeItDefault();
		public static final ReferenceIDs<EffectopediaObject>	DEFAULT_MODEL_CALLERS_REFIDS	= new ReferenceIDs<EffectopediaObject>(null, DEFAULT_DATA_SOURCE, EffectopediaObject.class)
				.<ReferenceIDs<EffectopediaObject>> makeItDefault();

		public static final Lab																														DEFAULT_LAB																		= new Lab(DEFAULT_IN_CHEMICO_TEST, DEFAULT_DATA_SOURCE).<Lab> makeItDefault();
		static
			{
				defaultObjects.put(Lab.class, DEFAULT_LAB);
			}

		public static final ReferenceIDs<PathwayElement>	DEFAULT_PATHWAY_ELEMENT_IDS	= new ReferenceIDs<PathwayElement>(null, DEFAULT_DATA_SOURCE, PathwayElement.class)
				.<ReferenceIDs<PathwayElement>> makeItDefault();

		public static final ObjectPropertyType											DEFAULT_SHORT_NAME										= new ObjectPropertyType("VI.1.1.", "AOP-Wiki short name", "short_name", SearchIndices.TITLE_INDEX, EffectopediaObject.class,
				"Short name form AOP-Wiki", DataValue_String.class, null, ActionTypes.SHORT_NAME).<ObjectPropertyType> makeItDefault();
		public static final ObjectPropertyType											DEFAULT_KEYWORDS												= new ObjectPropertyType("VI.2.1.", "Keywords", "keywords", SearchIndices.KEYWORDS_INDEX, EffectopediaObject.class,
				"keywords", DataValue_List.class, null, ActionTypes.KEYWORDS).<ObjectPropertyType> makeItDefault();
		public static final ObjectPropertyType											DEFAULT_GROUPS														= new ObjectPropertyType("VI.2.2.", "Groups", "groups", SearchIndices.GROUP_INDEX, EffectopediaObject.class, "group",
				DataValue_List.class, null, ActionTypes.GROUPS).<ObjectPropertyType> makeItDefault();

		public static final ObjectPropertyType											DEFAULT_EVENT_COMPONENTS				= new ObjectPropertyType("VI.3.1.", "Event components", "event_components", null, Effect.class,
				"Provide one or event components. Each event component consit of a biological process, object, and action.", DataValue_String.class, null, ActionTypes.E_COMPONENTS).makeMultivalued()
						.<ObjectPropertyType> makeItDefault();

		public static final ObjectPropertyType											DEFAULT_EC_PROCESS										= new ObjectPropertyType("VI.3.1.1.", "Process", "process", null, Effect.class,
				"Biological process describes dynamics of the underlying biological system", DataValue_String.class, null, ActionTypes.E_PROCESS).<ObjectPropertyType> makeItDefault();

		public static final ObjectPropertyType											DEFAULT_EC_OBJECT											= new ObjectPropertyType("VI.3.1.2.", "Object", "object", null, Method_InSilicoGlobalModel.class,
				"The biological object is the subject of the perturbation (e.g. specific biological receptor that is activated or inhibited)", DataValue_String.class, null, ActionTypes.E_OBJECT)
						.<ObjectPropertyType> makeItDefault();

		public static final ObjectPropertyType											DEFAULT_EC_ACTION											= new ObjectPropertyType("VI.3.1.3.", "Action", "action", null, Method_InSilicoGlobalModel.class,
				"Action describes the type of perturabtion of the process for the object (e.g. 'decreased' in the case the receptor is inhibited to indicate a decrease in the signaling by that receptor))",
				DataValue_String.class, null, ActionTypes.GM_SYS_REQ).addFixedValuesList((FixedValuesList) DefaultFixedListValues.INSTANCE.get("ACTIONS")).<ObjectPropertyType> makeItDefault();

		static
			{
				ObjectPropertyTypesContainer DEFAULT_EVENT_COMPONENTS_CONT = new ObjectPropertyTypesContainer();
				DEFAULT_EVENT_COMPONENTS_CONT.add(DEFAULT_EC_PROCESS);
				DEFAULT_EVENT_COMPONENTS_CONT.add(DEFAULT_EC_OBJECT);
				DEFAULT_EVENT_COMPONENTS_CONT.add(DEFAULT_EC_ACTION);
				DEFAULT_EVENT_COMPONENTS.setSubPropertyTypes(DEFAULT_EVENT_COMPONENTS_CONT);
			}

		public static final ObjectPropertyTypesContainer	DEFAULT_DOC_KNOWLEDGE_METADATA	= new ObjectPropertyTypesContainer();
		public static final ObjectPropertyTypesContainer	DEFAULT_EFFECT_METADATA								= new ObjectPropertyTypesContainer();
		static
			{
				DEFAULT_DOC_KNOWLEDGE_METADATA.add(DEFAULT_KEYWORDS);

				DEFAULT_EFFECT_METADATA.add(DEFAULT_KEYWORDS);
				DEFAULT_EFFECT_METADATA.add(DEFAULT_GROUPS);
				DEFAULT_EFFECT_METADATA.add(DEFAULT_SHORT_NAME);
				DEFAULT_EFFECT_METADATA.add(DEFAULT_EVENT_COMPONENTS);
			}

		static
			{
				DefaultDataTemplates.initTemplates();

				EffectopediaObject.initDefaultObjects();
				Stamp.resetDefaultDate();
			}

		public static void generateTestGOs()
			{
				Effectopedia.EFFECTOPEDIA.getData().generateTestData();
				Effectopedia.EFFECTOPEDIA.getData().getViews().setDefaultViewAxis();
				Effectopedia.EFFECTOPEDIA.setCurrentUser(User.GUEST);
				Effectopedia.EFFECTOPEDIA.connect();
			}

		static
			{
				buildingDefaultObjects = false;
			}

	}

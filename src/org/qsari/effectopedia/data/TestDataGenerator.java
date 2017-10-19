package org.qsari.effectopedia.data;

import java.util.Iterator;

import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.ContextDimension_Hierarchical;
import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.core.objects.DocumentedKnowledge_Located.BatchSetCooridnate;
import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Effect_AdverseOutcome;
import org.qsari.effectopedia.core.objects.Effect_DownstreamEffect;
import org.qsari.effectopedia.core.objects.Effect_Endpoint;
import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.Initiator_StructuralAlerts;
import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.Link_ChemStructToChemStruct;
import org.qsari.effectopedia.core.objects.Link_ChemStructToMIE;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.objects.Reference;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.history.Stamp;
import org.qsari.effectopedia.search.SearchIndices;
import org.qsari.effectopedia.search.SearchResult;
import org.qsari.effectopedia.search.SearchResults;
import org.qsari.effectopedia.search.SimpleSearchQuery;
import org.qsari.effectopedia.system.User;

public class TestDataGenerator
	{
		public static final TestDataGenerator	EXAMPLES	= new TestDataGenerator();
		
		private TestDataGenerator()
			{
				super();
			}
		
		public PathwayElement Test0(DataSource dataSource)
			{
				Initiator_ChemicalStructure chemical1 = DefaultEffectopediaObjects.DEFAULT_CHEM_STRUCTURE.clone(null, dataSource);
				Effect_MolecularInitiatingEvent mie1 = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie1.setTitle("eho");
				chemical1.setTitle("c");
				return mie1;
			}
		
		public Pathway Example1(DataSource dataSource)
			{
				Pathway pathway = new Pathway(null, dataSource);
				pathway.setTitle("Estrogen Binding Mediated Population Reduction");
				pathway.setKeyWords("estrogen receptor binding, sex reversal,reproductive impairment");
				
				Pathway pathway1 = new Pathway(null, dataSource);
				pathway1.setTitle("Oxidation of hemoglobin Mediated Population Reduction");
				pathway1.setKeyWords("hemoglobin oxidation");
				
				Initiator_ChemicalStructure chemical1 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical1.setTitle("Octylphnenol");
				chemical1.getStructure2DImage().setValue("https://app.effectopedia.org/media/chem/octylphenol.png");
				chemical1.getIdentification().setPropertyValue(0, "27193288");
				chemical1.getIdentification().setPropertyValue(1, "(1,1,3,3-tetramethylbutyl)phenol");
				chemical1.getIdentification().setPropertyValue(2, "OC1=CC(C(C)(C)CC(C)(C)C)=CC=C1");
				chemical1.getIdentification().setPropertyValue(3, "C14H22O");
				chemical1.getProperties().setPropertyValue(0, "206.3239");
				
				Initiator_ChemicalStructure chemical2 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical2.setTitle("Amylaniline");
				chemical2.getStructure2DImage().setValue("https://app.effectopedia.org/media/chem/amylaniline.png");
				chemical2.getIdentification().setPropertyValue(0, "33228443");
				chemical2.getIdentification().setPropertyValue(1, "4-n-Amylaniline");
				chemical2.getIdentification().setPropertyValue(2, "NC1=CC=C(C=C1)CCCCC");
				chemical2.getIdentification().setPropertyValue(3, "C11H17N");
				chemical2.getProperties().setPropertyValue(0, "163.2594");
				pathway1.add(chemical2);
				
				Effect_MolecularInitiatingEvent mie1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie1.setTitle("Binding to ER");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										mie1,
										dataSource,
										"Abstract",
										"The ER's helix 12 domain plays a crucial role in determining interactions with coactivators and corepressors and, therefore, the respective agonist or antagonist effect of the ligand. Different ligands may differ in their affinity for alpha and beta isoforms of the estrogen receptor: * 17-beta-estradiol binds equally well to both receptors * estrone bind preferentially to the alpha receptor * estriol, raloxifene, and genistein to the beta receptor Subtype selective estrogen receptor modulators preferentially bind to either the α- or the β-subtype of the receptor. In addition, the different estrogen receptor combinations may respond differently to various ligands, which may translate into tissue selective agonistic and antagonistic effects.[13] The ratio of α- to β- subtype concentration has been proposed to play a role in certain diseases. The concept of selective estrogen receptor modulators is based on the ability to promote ER interactions with different proteins such as transcriptional coactivator or corepressors. Furthermore, the ratio of coactivator to corepressor protein varies in different tissues.[15] As a consequence, the same ligand may be an agonist in some tissue (where coactivators predominate) while antagonistic in other tissues (where corepressors dominate). Tamoxifen, for example, is an antagonist in breast and is, therefore, used as a breast cancer treatment[16] but an ER agonist in bone (thereby preventing osteoporosis) and a partial agonist in the endometrium (increasing the risk of uterine cancer).")
										.<DescriptionSection> makeItLive(), 0);
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Dahlman-Wright K, Cavailles V, Fuqua SA, Jordan VC, Katzenellenbogen JA, Korach KS, Maggi A, Muramatsu M, Parker MG, Gustafsson JA (2006). International Union of Pharmacology. LXIV. Estrogen receptors. Pharmacol. Rev. 58 (4): 773–81")
										.<Reference> makeItLive());
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource, "Levin ER (2005). Integration of the extranuclear and nuclear actions of estrogen. Mol. Endocrinol. 19 (8): 1951–9.").<Reference> makeItLive());
				
				Effect_MolecularInitiatingEvent mie2 = new Effect_MolecularInitiatingEvent(pathway1, dataSource);
				mie2.setTitle("Oxidation of hemoglobin (methemoglobin)");
				mie2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie1);
				new Link_ChemStructToMIE(pathway, dataSource, chemical2, mie1);
				new Link_ChemStructToMIE(pathway1, dataSource, chemical2, mie2);
				
				Effect_DownstreamEffect cellular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect1.setTitle("ER Transcription Factors");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				Effect_DownstreamEffect cellular_effect2 = new Effect_DownstreamEffect(pathway1, dataSource);
				cellular_effect2.setTitle("Oxidative stress in red blood cells");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_EffectToEffect(pathway, dataSource, mie1, cellular_effect1);
				new Link_EffectToEffect(pathway1, dataSource, mie2, cellular_effect2);
				
				Effect_DownstreamEffect tissue_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				tissue_effect1.setTitle("Upreregulated Gene Transcription in the liver tissue");
				tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				Effect_DownstreamEffect tissue_effect2 = new Effect_DownstreamEffect(pathway1, dataSource);
				tissue_effect2.setTitle("Reduced oxygen supply and hypoxia");
				tissue_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				tissue_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				Effect_DownstreamEffect tissue_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
				tissue_effect3.setTitle("Gene expression for Vtg production");
				tissue_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				tissue_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, tissue_effect1);
				new Link_EffectToEffect(pathway1, dataSource, cellular_effect2, tissue_effect2);
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, tissue_effect3);
				
				Effect_DownstreamEffect organ_effect1 = new Effect_DownstreamEffect(pathway1, dataSource);
				organ_effect1.setTitle("Respiration changes");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				Effect_DownstreamEffect organ_effect2 = new Effect_DownstreamEffect(pathway1, dataSource);
				organ_effect2.setTitle("Headache and fatigue");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				Effect_DownstreamEffect organ_effect3 = new Effect_DownstreamEffect(pathway1, dataSource);
				organ_effect3.setTitle("Seizures");
				organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				Effect_DownstreamEffect organ_effect4 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect4.setTitle("Alteration of Anal fin papillae");
				organ_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				
				Effect_DownstreamEffect organ_effect5 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect5.setTitle("Alteration of Gonadal morphology");
				organ_effect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				
				new Link_EffectToEffect(pathway1, dataSource, tissue_effect2, organ_effect1);
				new Link_EffectToEffect(pathway1, dataSource, tissue_effect2, organ_effect2);
				new Link_EffectToEffect(pathway1, dataSource, tissue_effect2, organ_effect3);
				new Link_EffectToEffect(pathway, dataSource, tissue_effect3, organ_effect4);
				new Link_EffectToEffect(pathway, dataSource, tissue_effect3, organ_effect5);
				
				Effect_DownstreamEffect individual_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect1.setTitle("Reduced Growth");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				Effect_DownstreamEffect individual_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect2.setTitle("Reduced eggs per female");
				individual_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				Effect_DownstreamEffect individual_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect3.setTitle("Reduced Fertility");
				individual_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				Effect_DownstreamEffect individual_effect4 = (Effect_DownstreamEffect) searchEffectByTitle("Death");
				if (individual_effect4 != null)
					pathway.associate(individual_effect4);
				else
					{
						individual_effect4 = new Effect_DownstreamEffect(pathway1, dataSource);
						individual_effect4.setTitle("Death");
						individual_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
						individual_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						individual_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
					}
				
				Effect_DownstreamEffect individual_effect5 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect5.setTitle("Mixed sex gonads");
				individual_effect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				
				Effect_DownstreamEffect individual_effect6 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect6.setTitle("Sex reversal");
				individual_effect6.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect6.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				
				Effect_DownstreamEffect individual_effect7 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect7.setTitle("Delayed adult mail mortality");
				individual_effect7.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect7.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				
				new Link_EffectToEffect(pathway, dataSource, tissue_effect1, individual_effect1);
				new Link_EffectToEffect(pathway, dataSource, tissue_effect1, individual_effect2);
				new Link_EffectToEffect(pathway, dataSource, tissue_effect1, individual_effect3);
				new Link_EffectToEffect(pathway1, dataSource, organ_effect3, individual_effect4);
				new Link_EffectToEffect(pathway, dataSource, organ_effect4, individual_effect5);
				new Link_EffectToEffect(pathway, dataSource, organ_effect4, individual_effect6);
				new Link_EffectToEffect(pathway, dataSource, organ_effect4, individual_effect7);
				
				Effect_DownstreamEffect population_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				population_effect1.setTitle("Altered sex ratios");
				population_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "population");
				population_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				Effect_AdverseOutcome population_adverseOutcome = (Effect_AdverseOutcome) searchEffectByTitle("Population reduction");
				if (population_adverseOutcome != null)
					pathway.associate(population_adverseOutcome);
				else
					{
						population_adverseOutcome = new Effect_AdverseOutcome(pathway, dataSource);
						population_adverseOutcome.setTitle("Population reduction");
						population_adverseOutcome.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "population");
						population_adverseOutcome.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						population_adverseOutcome.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
						pathway1.add(population_adverseOutcome);
					}
				
				new Link_EffectToEffect(pathway, dataSource, individual_effect1, population_adverseOutcome);
				new Link_EffectToEffect(pathway, dataSource, individual_effect2, population_adverseOutcome);
				new Link_EffectToEffect(pathway, dataSource, individual_effect3, population_adverseOutcome);
				Link link = (Link) Pathway.getDirektLink(individual_effect4, population_adverseOutcome);
				if (link != null)
					pathway.add(link);
				else
					new Link_EffectToEffect(pathway1, dataSource, individual_effect4, population_adverseOutcome);
				new Link_EffectToEffect(pathway, dataSource, individual_effect5, population_effect1);
				new Link_EffectToEffect(pathway, dataSource, individual_effect5, population_effect1);
				new Link_EffectToEffect(pathway, dataSource, individual_effect7, population_effect1);
				new Link_EffectToEffect(pathway, dataSource, population_effect1, population_adverseOutcome);
				
				pathway.updateEssentiality();
				return pathway;
			}
		
		public Effect searchEffectByTitle(String title)
			{
				SimpleSearchQuery query = new SimpleSearchQuery("", SearchIndices.TITLE_INDEX);
				query.setSearchPhrase(title);
				DataSource source = Effectopedia.EFFECTOPEDIA.getData();
				source.getSearchEngine().doSearch(query);
				SearchResults results = source.getSearchEngine().getResults();
				if (results.count() == 1)
					{
						IndexedObject result = results.getItems().first().getSearchableItem().getObject();
						if (result instanceof Effect)
							return (Effect) result;
					}
				else
					{
						Iterator<SearchResult> it = results.getItems().iterator();
						while (it.hasNext())
							{
								SearchResult searchResult = it.next();
								IndexedObject result = searchResult.getSearchableItem().getObject();
								if (result instanceof Effect)
									return (Effect) result;
							}
					}
				return null;
			}
		
		public Pathway searchPathwayByTitle(String title)
			{
				SimpleSearchQuery query = new SimpleSearchQuery("", SearchIndices.TITLE_INDEX);
				query.setSearchPhrase(title);
				DataSource source = Effectopedia.EFFECTOPEDIA.getData();
				source.getSearchEngine().doSearch(query);
				SearchResults results = source.getSearchEngine().getResults();
				if (results.count() == 1)
					{
						IndexedObject result = results.getItems().first().getSearchableItem().getObject();
						if (result instanceof Pathway)
							return (Pathway) result;
					}
				else
					{
						Iterator<SearchResult> it = results.getItems().iterator();
						while (it.hasNext())
							{
								SearchResult searchResult = it.next();
								IndexedObject result = searchResult.getSearchableItem().getObject();
								if (result instanceof Pathway)
									return (Pathway) result;
							}
					}
				return null;
			}
		
		public Pathway Example2(DataSource dataSource)
			{
				Pathway pathway = new Pathway(null, dataSource);
				pathway.setTitle("AChE binding leading to population reduction");
				
				Initiator_StructuralAlerts structuralAlert = new Initiator_StructuralAlerts(pathway, dataSource);
				structuralAlert.setTitle("organophosphates, carbamites");
				
				Effect_MolecularInitiatingEvent mie1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie1.setTitle("AChE binding");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_ChemStructToMIE(pathway, dataSource, structuralAlert, mie1);
				
				Effect_DownstreamEffect cellular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect1.setTitle("Decreased AChE in neurons");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "neurons");
				
				new Link_EffectToEffect(pathway, dataSource, mie1, cellular_effect1);
				
				Effect_DownstreamEffect tissue_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				tissue_effect1.setTitle("Increased residence time of AChE");
				tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, tissue_effect1);
				
				Effect_DownstreamEffect organ_effect1 = (Effect_DownstreamEffect) searchEffectByTitle("Loss of consciousness");
				if (organ_effect1 != null)
					pathway.associate(organ_effect1);
				else
					{
						organ_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
						organ_effect1.setTitle("Loss of consciousness");
						organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
						organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "brain");
					}
				
				Effect_DownstreamEffect organ_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect2.setTitle("Headache and fatigue");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				Effect_DownstreamEffect organ_effect3 = (Effect_DownstreamEffect) searchEffectByTitle("Signaling disruption");
				if (organ_effect3 != null)
					pathway.associate(organ_effect3);
				else
					{
						organ_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
						organ_effect3.setTitle("Signaling disruption");
						organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
						organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
					}
				
				Effect_DownstreamEffect organ_effect4 = (Effect_DownstreamEffect) searchEffectByTitle("Seizures");
				if (organ_effect4 != null)
					pathway.associate(organ_effect4);
				else
					{
						organ_effect4 = new Effect_DownstreamEffect(pathway, dataSource);
						organ_effect4.setTitle("Seizures");
						organ_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
						organ_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						organ_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
					}
				
				new Link_EffectToEffect(pathway, dataSource, tissue_effect1, organ_effect1);
				new Link_EffectToEffect(pathway, dataSource, tissue_effect1, organ_effect2);
				new Link_EffectToEffect(pathway, dataSource, tissue_effect1, organ_effect3);
				new Link_EffectToEffect(pathway, dataSource, tissue_effect1, organ_effect4);
				
				Effect_DownstreamEffect organ_system_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_system_effect1.setTitle("Convolutions");
				organ_system_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ system");
				organ_system_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organ_system_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "neuromuscular junction");
				
				Effect_DownstreamEffect organ_system_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_system_effect2.setTitle("Tremors");
				organ_system_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ system");
				organ_system_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organ_system_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "neuromuscular junction");
				
				Effect_DownstreamEffect organ_system_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_system_effect3.setTitle("Paralysis");
				organ_system_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ system");
				organ_system_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organ_system_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "neuromuscular junction");
				
				new Link_EffectToEffect(pathway, dataSource, organ_effect3, organ_system_effect1);
				new Link_EffectToEffect(pathway, dataSource, organ_effect3, organ_system_effect2);
				new Link_EffectToEffect(pathway, dataSource, organ_effect3, organ_system_effect3);
				
				Effect_DownstreamEffect individual_effect1 = (Effect_DownstreamEffect) searchEffectByTitle("Death");
				if (individual_effect1 != null)
					pathway.associate(individual_effect1);
				else
					{
						individual_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
						individual_effect1.setTitle("Death");
						individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
						individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
					}
				
				new Link_EffectToEffect(pathway, dataSource, organ_system_effect1, individual_effect1);
				new Link_EffectToEffect(pathway, dataSource, organ_system_effect3, individual_effect1);
				
				Effect_AdverseOutcome population_adverseOutcome = (Effect_AdverseOutcome) searchEffectByTitle("Population reduction");
				if (population_adverseOutcome != null)
					pathway.associate(population_adverseOutcome);
				else
					{
						population_adverseOutcome = new Effect_AdverseOutcome(pathway, dataSource);
						population_adverseOutcome.setTitle("Population reduction");
						population_adverseOutcome.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "population");
						population_adverseOutcome.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						population_adverseOutcome.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
					}
				
				Link link = (Link) Pathway.getDirektLink(individual_effect1, population_adverseOutcome);
				if (link != null)
					pathway.add(link);
				else
					new Link_EffectToEffect(pathway, dataSource, individual_effect1, population_adverseOutcome);
				
				pathway.updateEssentiality();
				return pathway;
			}
		
		public Pathway Example3(DataSource dataSource)
			{
				Pathway pathway = new Pathway(null, dataSource);
				pathway.setTitle("Binding to Thyroid Peroxidase (TPO) mediated Learning impairment");
				
				Initiator_ChemicalStructure chemical1 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical1.setTitle("Propyltiouracil");
				chemical1.getStructure2DImage().setValue("https://app.effectopedia.org/media/chem/propyltiouracil.png");
				chemical1.getIdentification().setPropertyValue(0, "51525");
				chemical1.getIdentification().setPropertyValue(1, "4(1H)-Pyrimidinone, 2,3-dihydro-6-propyl-2-thioxo- (9CI)");
				chemical1.getIdentification().setPropertyValue(2, "S=C(NC(CCC)=C1)NC1=O");
				chemical1.getIdentification().setPropertyValue(3, "C7H10N2OS");
				chemical1.getProperties().setPropertyValue(0, "170.2321");
				
				Effect_MolecularInitiatingEvent mie1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie1.setTitle("Binding to Thyroid Peroxidase (TPO)");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie1);
				
				Effect_DownstreamEffect cellular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect1.setTitle("Decreased levels of TPO");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "thyroid cells");
				
				new Link_EffectToEffect(pathway, dataSource, mie1, cellular_effect1);
				
				Effect_DownstreamEffect tissue_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				tissue_effect1.setTitle("Decrease levels of serum T4 and T3");
				tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "blood");
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, tissue_effect1);
				
				Effect_DownstreamEffect organ_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect1.setTitle("Altered TR mediated proteints");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Hippocampal,Brain");
				
				Effect_DownstreamEffect organ_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect2.setTitle("Synaptic malformation and altered function");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_EffectToEffect(pathway, dataSource, tissue_effect1, organ_effect1);
				new Link_EffectToEffect(pathway, dataSource, organ_effect1, organ_effect2);
				
				Effect_DownstreamEffect individual_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect1.setTitle("Learning impairment");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_EffectToEffect(pathway, dataSource, organ_effect1, individual_effect1);
				
				pathway.updateEssentiality();
				return pathway;
			}
		
		public Pathway Example4(DataSource dataSource)
			{
				Pathway pathway = new Pathway(null, dataSource);
				pathway.setTitle("Pathway newrok: NMDA, nACh, GABA A, receptor binding leading to population reduction");
				
				Initiator_ChemicalStructure chemical1 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical1.setTitle("Isofluorane");
				chemical1.getStructure2DImage().setValue("https://app.effectopedia.org/media/chem/isofluorane.png");
				chemical1.getIdentification().setPropertyValue(0, "26675467");
				chemical1.getIdentification().setPropertyValue(1, "1-Chloro-2,2,2-Trifluoroethyl Difluoromethyl Ether");
				chemical1.getIdentification().setPropertyValue(2, "FC(F)OC(Cl)C(F)(F)F");
				chemical1.getIdentification().setPropertyValue(3, "C3H2ClF5O");
				chemical1.getProperties().setPropertyValue(0, "184.4924");
				
				Initiator_ChemicalStructure chemical2 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical2.setTitle("Octanol");
				chemical2.getStructure2DImage().setValue("https://app.effectopedia.org/media/chem/octanol.png");
				chemical2.getIdentification().setPropertyValue(0, "111875");
				chemical2.getIdentification().setPropertyValue(1, "1-Octanol");
				chemical2.getIdentification().setPropertyValue(2, "CCCCCCCCO");
				chemical2.getIdentification().setPropertyValue(3, "C8H18O");
				chemical2.getProperties().setPropertyValue(0, "130.2279");
				
				Effect_MolecularInitiatingEvent mie1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie1.setTitle("Binding to the NMDA receptor");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				Effect_MolecularInitiatingEvent mie2 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie2.setTitle("Binding to the nACh receptor");
				mie2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				Effect_MolecularInitiatingEvent mie3 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie3.setTitle("Binding to the GABA A receptor");
				mie3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				Effect_MolecularInitiatingEvent mie4 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie4.setTitle("Hydrophobic binding to proteins and membranes");
				mie4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie1);
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie2);
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie3);
				new Link_ChemStructToMIE(pathway, dataSource, chemical2, mie4);
				
				Effect_DownstreamEffect cellular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect1.setTitle("Reduced membrane current");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "neurons");
				
				Effect_DownstreamEffect cellular_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect2.setTitle("Decreased channel  open time");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "neurons");
				
				Effect_DownstreamEffect cellular_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect3.setTitle("Increased channel open time");
				cellular_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				cellular_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "neurons");
				
				Effect_DownstreamEffect cellular_effect4 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect4.setTitle("Reduction of all cell functions");
				cellular_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				cellular_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "all cells");
				
				new Link_EffectToEffect(pathway, dataSource, mie1, cellular_effect1);
				new Link_EffectToEffect(pathway, dataSource, mie2, cellular_effect2);
				new Link_EffectToEffect(pathway, dataSource, mie3, cellular_effect3);
				new Link_EffectToEffect(pathway, dataSource, mie4, cellular_effect4);
				
				Effect_DownstreamEffect organ_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect1.setTitle("Reduced Excitatory Transmition");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Brain Stem");
				
				Effect_DownstreamEffect organ_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect2.setTitle("Reduced Excitatory of the Hippocampus");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Hippocampus");
				
				Effect_DownstreamEffect organ_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect3.setTitle("Facilitated Inhibitory Transmission Cortex-Thalamus");
				organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Brain");
				
				Effect_DownstreamEffect organ_effect4 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect4.setTitle("Reversible decrease of organ functions");
				organ_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organ_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "all organs");
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, organ_effect1);
				new Link_EffectToEffect(pathway, dataSource, cellular_effect2, organ_effect2);
				new Link_EffectToEffect(pathway, dataSource, cellular_effect3, organ_effect3);
				new Link_EffectToEffect(pathway, dataSource, cellular_effect4, organ_effect4);
				
				Effect_DownstreamEffect individual_effect1 = (Effect_DownstreamEffect) searchEffectByTitle("Death");
				if (individual_effect1 != null)
					pathway.associate(individual_effect1);
				else
					{
						individual_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
						individual_effect1.setTitle("Death");
						individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
						individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
					}
				
				Effect_DownstreamEffect individual_effect2 = (Effect_DownstreamEffect) searchEffectByTitle("Death");
				if (individual_effect2 != null)
					pathway.associate(individual_effect2);
				else
					{
						individual_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
						individual_effect2.setTitle("Unconscious");
						individual_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
						individual_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						individual_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
					}
				
				Effect_DownstreamEffect individual_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect3.setTitle("Sedation");
				individual_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				Effect_DownstreamEffect individual_effect4 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect4.setTitle("Excitability");
				individual_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_EffectToEffect(pathway, dataSource, organ_effect4, individual_effect1);
				new Link_EffectToEffect(pathway, dataSource, organ_effect1, individual_effect2);
				new Link_EffectToEffect(pathway, dataSource, organ_effect4, individual_effect2);
				new Link_EffectToEffect(pathway, dataSource, organ_effect2, individual_effect3);
				new Link_EffectToEffect(pathway, dataSource, organ_effect3, individual_effect3);
				new Link_EffectToEffect(pathway, dataSource, organ_effect4, individual_effect3);
				new Link_EffectToEffect(pathway, dataSource, organ_effect4, individual_effect4);
				
				Effect_AdverseOutcome population_adverseOutcome = (Effect_AdverseOutcome) searchEffectByTitle("Population reduction");
				if (population_adverseOutcome != null)
					pathway.associate(population_adverseOutcome);
				else
					{
						population_adverseOutcome = new Effect_AdverseOutcome(pathway, dataSource);
						population_adverseOutcome.setTitle("Population reduction");
						population_adverseOutcome.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "population");
						population_adverseOutcome.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						population_adverseOutcome.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
					}
				
				Link link = (Link) Pathway.getDirektLink(individual_effect1, population_adverseOutcome);
				if (link != null)
					pathway.add(link);
				else
					new Link_EffectToEffect(pathway, dataSource, individual_effect1, population_adverseOutcome);
				
				pathway.updateEssentiality();
				return pathway;
			}
		
		public Pathway Example5(DataSource dataSource)
			{
				Pathway pathway = new Pathway(null, dataSource);
				pathway.setTitle("Weak acid respiratory uncoupling leading to death");
				pathway.setKeyWords("respiratory uncoupling,acute aquatic toxicity");
				
				Initiator_StructuralAlerts structuralAlert = new Initiator_StructuralAlerts(pathway, dataSource);
				structuralAlert.setTitle("Ionized uncouplers");
				
				Effect_MolecularInitiatingEvent mie1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie1.setTitle("Interaction with inner mitochondrial membrane & non-covalent perturbation");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");
				
				mie1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										mie1,
										dataSource,
										"Background",
										"During normal mitochondria function an H-ion gradient is formed across the inner mitochondrial membrane as a result of metabolically mediated electron transport and the H-ions are used to generate ATP via the ATP-synthetase enzyme complex, which is membrane bound.  The movement of electrons down the mitochondrial respiratory chain is coupled to the proton pumping, which builds a large proton motive force (membrane potential) across the mitochondrial inner membrane.  The energy transduced by the membrane potential is used for the synthesis of ATP.")
										.<DescriptionSection> makeItLive(), 0);
				mie1
						.getDescriptionIDs()
						.add(
								new DescriptionSection(
										mie1,
										dataSource,
										"Description",
										"The ionized uncoupler short-circuits the H-ion gradient and provides an alternative process of transporting the H-ions across the membrane (Blaikie et al., 2006).  Respiration continues to pump H-ions across the inner membrane into the mitochondrial matrix but no ion gradient is formed because the weak acids dissipate the ions and no ATP is synthesized.  The result is that uncoupling chemicals induce a metabolically futile wasting of energy by stimulating resting respiration, while at the same time decreasing ATP yield (Wallace and Starkov, 2000).  Molecularly and physiologically, the best studied, weak acid respiratory uncouplers compounds are 2,4-dinitrophenol and pentachlorophenol (Loomis and Lippmann, 1948; McLaughlin and Dilger, 1980; McKim et al., 1987).")
										.<DescriptionSection> makeItLive());
				
				mie1.getReferenceIDs().add(
						new Reference(null, dataSource, "Wallace, K.B. and Starkov, A.A. 2000. Mitochondrial targets of drug toxicity. Annu. Rev. Pharmacol. Toxicol. 40:353-388.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(
						new Reference(null, dataSource, "Loomis, W.F. and Lippmnn, F. 1948. Reversible inhibition of the uncoupling of between phosphorylation and oxidation. J. Biol. Chem. 172:807-808.")
								.<Reference> makeItLive());
				mie1.getReferenceIDs().add(
						new Reference(null, dataSource, "McLaughlin, S.G. and Dilger, J.P. 1980. Transport of protons across membranes by weak acids. Physiol. Rev. 60:825-863.").<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"McKim, J.M., Schmieder, P.K. Carlson, R.W., Hunt, E.P. and Niemi, G.J. 1987. Use of respiratory-cardiovascular responses of rainbow trout (Salmo gairdneri) in identifying acute toxicity syndromes I fish: Part 1. Pentachlorophenol, 2,4-dinitrophenol, tricaine methanesulfonate and 1-octanol. Environ. Toxicol. Chem. 6:295-312.")
										.<Reference> makeItLive());
				
				new Link_ChemStructToMIE(pathway, dataSource, structuralAlert, mie1);
				
				Effect_DownstreamEffect organelle_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				organelle_effect1.setTitle("Reduced ATP formation");
				organelle_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organelle");
				organelle_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organelle_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");
				
				new Link_EffectToEffect(pathway, dataSource, mie1, organelle_effect1);
				
				Effect_DownstreamEffect cellular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect1.setTitle("Inhibition of ATP-dependent cellular functions");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");
				
				new Link_EffectToEffect(pathway, dataSource, organelle_effect1, cellular_effect1);
				
				Effect_DownstreamEffect tissue_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				tissue_effect1.setTitle("Reduced ATP-depndent functions");
				tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, tissue_effect1);
				
				Effect_DownstreamEffect organ_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect1.setTitle("Heart Failure");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "heart");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "long-term");
				
				Effect_DownstreamEffect organ_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect2.setTitle("Respiratory Failure");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ system");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "long-term");
				
				Effect_DownstreamEffect organ_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect3.setTitle("Increased metabolism");
				organ_effect3
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										organ_effect3,
										dataSource,
										"Abstract",
										"McKim et al. (1997) used fish acute toxicity syndromes based on biochemical and/or physiological effects of exposure, selected as key responses measured in vivo from exposure to model chemicals.  One syndrome they developed was for weak acid uncouplers based on 2,4-dinitrophenol and pentachlorophenol (McKim et al., 1997) that is different than either the syndrome for nonpolar narcosis or polar narcosis.  The physiological-biochemical responses in spinally transected rainbow trout upon exposure to these two model weak acid uncoupler is a rapid and continuous increase in ventilation volume and O2 consumption, which corresponds to an increase in the rate of metabolism.  These whole fish observations are consistent with the hypothesis of futile metabolism where ventilation increases in an effort to provide more oxygen, which is utilized in respiration, but without the production of ATP.  Ten phenolic uncouplers have been tested in the fathead minnow 96-hr flow-through acute toxicity assay (Russom et al., 1997).")
										.<DescriptionSection> makeItLive(), 0);
				organ_effect3
						.getReferenceIDs()
						.add(
								new Reference(
										organ_effect3,
										dataSource,
										"McKim, J.M., Schmieder, P.K. Carlson, R.W., Hunt, E.P. and Niemi, G.J. 1987. Use of respiratory-cardiovascular responses of rainbow trout (Salmo gairdneri) in identifying acute toxicity syndromes I fish: Part 1. Pentachlorophenol, 2,4-dinitrophenol, tricaine methanesulfonate and 1-octanol. Environ. Toxicol. Chem. 6:295-312.")
										.<Reference> makeItLive());
				organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "heart");
				organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mid-term");
				
				new Link_EffectToEffect(pathway, dataSource, tissue_effect1, organ_effect3);
				new Link_EffectToEffect(pathway, dataSource, tissue_effect1, organ_effect1);
				new Link_EffectToEffect(pathway, dataSource, organ_effect1, organ_effect2);
				
				Effect_DownstreamEffect individual_effect1 = (Effect_DownstreamEffect) searchEffectByTitle("Death");
				if (individual_effect1 != null)
					pathway.associate(individual_effect1);
				else
					{
						individual_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
						individual_effect1.setTitle("Death");
						individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
						individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
					}
				
				new Link_EffectToEffect(pathway, dataSource, organ_effect2, individual_effect1);
				
				Effect_AdverseOutcome population_adverseOutcome = (Effect_AdverseOutcome) searchEffectByTitle("Population reduction");
				if (population_adverseOutcome != null)
					pathway.associate(population_adverseOutcome);
				else
					{
						population_adverseOutcome = new Effect_AdverseOutcome(pathway, dataSource);
						population_adverseOutcome.setTitle("Population reduction");
						population_adverseOutcome.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "population");
						population_adverseOutcome.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						population_adverseOutcome.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
					}
				
				Link link = (Link) Pathway.getDirektLink(individual_effect1, population_adverseOutcome);
				if (link != null)
					pathway.add(link);
				else
					new Link_EffectToEffect(pathway, dataSource, individual_effect1, population_adverseOutcome);

				pathway.updateEssentiality();
				return pathway;
			}
		
		public Pathway Example6(DataSource dataSource)
			{
				Pathway pathway = new Pathway(null, dataSource);
				pathway.setTitle("Example6 Neurotoxicity");
				pathway.setKeyWords("neurotoxicity, synthetic pyrethroids, voltage-gated sodium channels, membrane potential");
				
				Initiator_StructuralAlerts structuralAlert = new Initiator_StructuralAlerts(pathway, dataSource);
				structuralAlert.setTitle("Ionized uncouplers");
				
				Effect_MolecularInitiatingEvent mie1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie1.setTitle("Interaction (VSGCs)");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				// mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX,
				// "short-term");
				mie1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										mie1,
										dataSource,
										"Background",
										"Voltage-gated sodium channels (VSGCs) are protein structures common to vertebrate and invertebrate species.  They are composed of multiple subunits (alpha and beta subunits in mammals). The alpha subunit forms a pore through neuronal membranes and controls sodium flux across the neuronal membrane. The beta subunits influence the function and expression of the alpha subunits. Opening of the VGSC increases sodium entry into the neuron and is responsible for generating the action potential (movement of an electrical signal along the neuron that represents a change in membrane excitability). There are a number of VSGC subtypes, and there is evidence that channel subtypes differ in sensitivity to different toxicants.")
										.<DescriptionSection> makeItLive(), 0);
				mie1
						.getDescriptionIDs()
						.add(
								new DescriptionSection(
										mie1,
										dataSource,
										"Description",
										"Toxicants interact with voltage-gated sodium channels (VGSCs) to alter the normal flux of sodium ions across the neuronal cell membrane by prolonging (slowing) the kinetics of VGSC activation (opening) and inactivation (closing);")
										.<DescriptionSection> makeItLive());
				
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource,
								"Shafer, TJ; Meyer, DA; Crofton, KM.  2005.  Developmental neurotoxicity of pyrethroid insecticides: Critical review and future research needs.  Environ.Health Persp. 113(2): 123-136.")
								.<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"US EPA. 2009.  Draft Science Policy Paper.  Proposed Common Mechanism Grouping for the Pyrethrins and Synthetic Pyrethroids.  Available at -   http://www.regulations.gov/search/Regs/home.html#documentDetail?R=09000064809a62df")
										.<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Soderlund, D.M., J.M. Clark, L.P. Sheets, L.S. Mullin, V.J. Piccirillo, D. Sargent, J.T. Stevens, and M.L. Weiner. 2002.  Mechanisms of pyrethroid neurotoxicity: implications for cumulative risk assessment.  Toxicology 171(1)3-59")
										.<Reference> makeItLive());
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource,
								"Shafer, TJ; Meyer, DA; Crofton, KM.  2005.  Developmental neurotoxicity of pyrethroid insecticides: Critical review and future research needs.  Environ.Health Persp. 113(2): 123-136")
								.<Reference> makeItLive());
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource,
								"Wolansky, M. J. and Harrill, J. A. 2008. Neurobehavioral Toxicology of Pyrethroid Insecticides in Adult Animals:  A Critical Review. Neurotoxicol.Teratol.  30[2], 55-78.")
								.<Reference> makeItLive());
				
				Effect_MolecularInitiatingEvent mie2 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie2.setTitle("chloride-permeable ion channels");
				mie2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				Effect_MolecularInitiatingEvent mie3 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie3.setTitle("voltage-gated calcium channels");
				mie3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie3
						.getReferenceIDs()
						.add(
								new Reference(
										mie3,
										dataSource,
										"Shafer, TJ and D. Meyer 2004.  Effects of Pyrethroids on Voltage-Sensitive Calcium Channels:  A Critical Evaluation of Strengths, Weaknesses, Data Needs, and Relationship to Assessment of Cumulative Neurotoxicity.  Toxicology and Applied Pharmacology (196)(2):303-318.")
										.<Reference> makeItLive());
				
				Effect_MolecularInitiatingEvent mie4 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie4.setTitle("ligand-gated chloride channels");
				mie4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_ChemStructToMIE(pathway, dataSource, structuralAlert, mie1);
				new Link_ChemStructToMIE(pathway, dataSource, structuralAlert, mie2);
				new Link_ChemStructToMIE(pathway, dataSource, structuralAlert, mie3);
				new Link_ChemStructToMIE(pathway, dataSource, structuralAlert, mie4);
				
				Effect_DownstreamEffect cellular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect1.setTitle("Neuronal membrane potential disruption");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				// cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX,
				// "short-term");
				
				new Link_EffectToEffect(pathway, dataSource, mie1, cellular_effect1);
				
				Effect_DownstreamEffect tissue_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				tissue_effect1.setTitle("Disruption of homeostasis of neuronal networks");
				tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, tissue_effect1);
				
				Effect_DownstreamEffect organ_effect1 = (Effect_DownstreamEffect) searchEffectByTitle("Loss of consciousness");
				if (organ_effect1 != null)
					pathway.associate(organ_effect1);
				else
					{
						organ_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
						organ_effect1.setTitle("Loss of consciousness");
						organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
						organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "brain");
					}
				
				Effect_DownstreamEffect organ_effect2 = (Effect_DownstreamEffect) searchEffectByTitle("Seizures");
				if (organ_effect2 != null)
					pathway.associate(organ_effect2);
				else
					{
						organ_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
						organ_effect2.setTitle("Seizures");
						organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
						organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
					}
				
				Effect_DownstreamEffect organ_effect3 = (Effect_DownstreamEffect) searchEffectByTitle("Signaling disruption");
				if (organ_effect3 != null)
					pathway.associate(organ_effect3);
				else
					{
						organ_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
						organ_effect3.setTitle("Signaling disruption");
						organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
						organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
					}
				
				new Link_EffectToEffect(pathway, dataSource, tissue_effect1, organ_effect1);
				new Link_EffectToEffect(pathway, dataSource, tissue_effect1, organ_effect2);
				new Link_EffectToEffect(pathway, dataSource, tissue_effect1, organ_effect3);
				
				Effect_DownstreamEffect organ_system_effect1 = (Effect_DownstreamEffect) searchEffectByTitle("Convolutions");
				if (organ_system_effect1 != null)
					pathway.associate(organ_system_effect1);
				else
					{
						organ_system_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
						organ_system_effect1.setTitle("Convolutions");
						organ_system_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ system");
						organ_system_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						organ_system_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "neuromuscular junction");
					}
				Effect_DownstreamEffect organ_system_effect2 = (Effect_DownstreamEffect) searchEffectByTitle("Tremors");
				if (organ_system_effect2 != null)
					pathway.associate(organ_system_effect2);
				else
					{
						organ_system_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
						organ_system_effect2.setTitle("Tremors");
						organ_system_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ system");
						organ_system_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						organ_system_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "neuromuscular junction");
					}
				
				Effect_DownstreamEffect organ_system_effect3 = (Effect_DownstreamEffect) searchEffectByTitle("Paralysis");
				if (organ_system_effect3 != null)
					pathway.associate(organ_system_effect3);
				else
					{
						organ_system_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
						organ_system_effect3.setTitle("Paralysis");
						organ_system_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ system");
						organ_system_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						organ_system_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "neuromuscular junction");
					}
				
				if (Pathway.getDirektLink(organ_effect3, organ_system_effect1) == null)
					new Link_EffectToEffect(pathway, dataSource, organ_effect3, organ_system_effect1);
				if (Pathway.getDirektLink(organ_effect3, organ_system_effect2) == null)
					new Link_EffectToEffect(pathway, dataSource, organ_effect3, organ_system_effect2);
				if (Pathway.getDirektLink(organ_effect3, organ_system_effect3) == null)
					new Link_EffectToEffect(pathway, dataSource, organ_effect3, organ_system_effect3);
				
				Effect_DownstreamEffect individual_effect1 = (Effect_DownstreamEffect) searchEffectByTitle("Death");
				if (individual_effect1 != null)
					pathway.associate(individual_effect1);
				else
					{
						individual_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
						individual_effect1.setTitle("Death");
						individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
						individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
					}
				
				if (Pathway.getDirektLink(organ_effect3, individual_effect1) == null)
					new Link_EffectToEffect(pathway, dataSource, organ_effect3, individual_effect1);
				if (Pathway.getDirektLink(organ_system_effect3, individual_effect1) == null)
					new Link_EffectToEffect(pathway, dataSource, organ_system_effect3, individual_effect1);
				
				Effect_DownstreamEffect individual_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect2.setTitle("Movement Impariment");
				individual_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				individual_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				
				Effect_DownstreamEffect individual_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect3.setTitle("Behavioral Changes ");
				individual_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				individual_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				
				if (Pathway.getDirektLink(organ_effect3, individual_effect2) == null)
					new Link_EffectToEffect(pathway, dataSource, organ_effect3, individual_effect2);
				
				if (Pathway.getDirektLink(organ_effect3, individual_effect3) == null)
					new Link_EffectToEffect(pathway, dataSource, organ_effect3, individual_effect3);
				
				Effect_AdverseOutcome population_adverseOutcome = (Effect_AdverseOutcome) searchEffectByTitle("Population reduction");
				if (population_adverseOutcome != null)
					pathway.associate(population_adverseOutcome);
				else
					{
						population_adverseOutcome = new Effect_AdverseOutcome(pathway, dataSource);
						population_adverseOutcome.setTitle("Population reduction");
						population_adverseOutcome.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "population");
						population_adverseOutcome.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						population_adverseOutcome.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
					}
				
				if (Pathway.getDirektLink(individual_effect1, population_adverseOutcome) == null)
					new Link_EffectToEffect(pathway, dataSource, individual_effect1, population_adverseOutcome);
				
				new Link_EffectToEffect(pathway, dataSource, individual_effect2, population_adverseOutcome);
				new Link_EffectToEffect(pathway, dataSource, individual_effect3, population_adverseOutcome);

				pathway.updateEssentiality();
				return pathway;
			}
		
		public Pathway Example7(DataSource dataSource)
			{
				Pathway pathway = new Pathway(null, dataSource);
				pathway.setTitle("Vinclozoline case study");
				pathway.setKeyWords("neurotoxicity, synthetic pyrethroids, voltage-gated sodium channels, membrane potential");
				
				Initiator_ChemicalStructure chemical1 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical1.setTitle("Vinclozoline");
				chemical1.getStructure2DImage().setValue("https://app.effectopedia.org/media/chem/vinclozoline.png");
				chemical1.getIdentification().setPropertyValue(0, "50471448");
				chemical1.getIdentification().setPropertyValue(1, "(RS)-3-(3,5-dichlorophenyl)-5-methyl- 5-vinyloxazolidine-2,4-dione");
				chemical1.getIdentification().setPropertyValue(2, "O=C2OC(C(=O)N2c1cc(Cl)cc(Cl)c1)(C=C)C");
				chemical1.getIdentification().setPropertyValue(3, "C12H9Cl2NO3");
				chemical1.getProperties().setPropertyValue(0, "286.11076");
				
				Initiator_ChemicalStructure rChemical1 = new Initiator_ChemicalStructure(pathway, dataSource);
				rChemical1.setTitle("M1");
				rChemical1.getStructure2DImage().setValue("https://app.effectopedia.org/media/chem/m1.png");
				rChemical1.getIdentification().setPropertyValue(0, "0");
				rChemical1.getIdentification().setPropertyValue(1, "2-[(3,5-dichlorophenyl)carbamoyloxy]-2-methylbut-3-enoic acid");
				rChemical1.getIdentification().setPropertyValue(2, "CC(C=C)(C(=O)O)OC(=O)NC1=CC(=CC(=C1)Cl)Cl");
				rChemical1.getIdentification().setPropertyValue(3, "C12H11Cl2NO4");
				rChemical1.getProperties().setPropertyValue(0, "304.12604");
				
				Initiator_ChemicalStructure rChemical2 = new Initiator_ChemicalStructure(pathway, dataSource);
				rChemical2.setTitle("M2");
				rChemical2.getStructure2DImage().setValue("https://app.effectopedia.org/media/chem/m2.png");
				rChemical2.getIdentification().setPropertyValue(0, "0");
				rChemical2.getIdentification().setPropertyValue(1, "N-(3,5-dichlorophenyl)-2-hydroxy-2-methylbut-3-enamide");
				rChemical2.getIdentification().setPropertyValue(2, "C1=C(C=C(C=C1NC(C(C)(C=C)O)=O)Cl)Cl");
				rChemical2.getIdentification().setPropertyValue(3, "C11H11Cl2NO2");
				rChemical2.getProperties().setPropertyValue(0, "260.11654");
				
				Initiator_ChemicalStructure rChemical3 = new Initiator_ChemicalStructure(pathway, dataSource);
				rChemical3.setTitle("M3");
				rChemical3.getStructure2DImage().setValue("https://app.effectopedia.org/media/chem/m3.png");
				rChemical3.getIdentification().setPropertyValue(0, "0");
				rChemical3.getIdentification().setPropertyValue(1, "");
				rChemical3.getIdentification().setPropertyValue(2, "O=C1OC(C(=O)N1C2=CC(=C(C(=C2)Cl)O)Cl)(C=C)C");
				rChemical3.getIdentification().setPropertyValue(3, "C11H12Cl2NO3");
				
				new Link_ChemStructToChemStruct(pathway, dataSource, chemical1, rChemical1);
				new Link_ChemStructToChemStruct(pathway, dataSource, chemical1, rChemical2);
				new Link_ChemStructToChemStruct(pathway, dataSource, chemical1, rChemical3);
				Effect_MolecularInitiatingEvent mie0 = (Effect_MolecularInitiatingEvent) searchEffectByTitle("Nonspecific Protein Binding");
				if (mie0 != null)
					pathway.associate(mie0);
				else
					{
						mie0 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
						mie0.setTitle("Nonspecific Protein Binding");
						mie0.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
						mie0.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						mie0.getDescriptionIDs().set(new DescriptionSection(mie0, dataSource, "Abstract", "Nonspecific protein binding").<DescriptionSection> makeItLive(), 0);
					}
				
				Effect_MolecularInitiatingEvent mie1 = (Effect_MolecularInitiatingEvent) searchEffectByTitle("Binding to ER");
				if (mie1 != null)
					pathway.associateDownstream(mie1);
				else
					{
						mie1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
						mie1.setTitle("Binding to ER");
						mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
						mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						mie1
								.getDescriptionIDs()
								.set(
										new DescriptionSection(
												mie1,
												dataSource,
												"Abstract",
												"The ER's helix 12 domain plays a crucial role in determining interactions with coactivators and corepressors and, therefore, the respective agonist or antagonist effect of the ligand. Different ligands may differ in their affinity for alpha and beta isoforms of the estrogen receptor: * 17-beta-estradiol binds equally well to both receptors * estrone bind preferentially to the alpha receptor * estriol, raloxifene, and genistein to the beta receptor Subtype selective estrogen receptor modulators preferentially bind to either the α- or the β-subtype of the receptor. In addition, the different estrogen receptor combinations may respond differently to various ligands, which may translate into tissue selective agonistic and antagonistic effects.[13] The ratio of α- to β- subtype concentration has been proposed to play a role in certain diseases. The concept of selective estrogen receptor modulators is based on the ability to promote ER interactions with different proteins such as transcriptional coactivator or corepressors. Furthermore, the ratio of coactivator to corepressor protein varies in different tissues.[15] As a consequence, the same ligand may be an agonist in some tissue (where coactivators predominate) while antagonistic in other tissues (where corepressors dominate). Tamoxifen, for example, is an antagonist in breast and is, therefore, used as a breast cancer treatment[16] but an ER agonist in bone (thereby preventing osteoporosis) and a partial agonist in the endometrium (increasing the risk of uterine cancer).")
												.<DescriptionSection> makeItLive(), 0);
						mie1
								.getReferenceIDs()
								.add(
										new Reference(
												mie1,
												dataSource,
												"Dahlman-Wright K, Cavailles V, Fuqua SA, Jordan VC, Katzenellenbogen JA, Korach KS, Maggi A, Muramatsu M, Parker MG, Gustafsson JA (2006). International Union of Pharmacology. LXIV. Estrogen receptors. Pharmacol. Rev. 58 (4): 773–81")
												.<Reference> makeItLive());
						mie1.getReferenceIDs().add(
								new Reference(mie1, dataSource, "Levin ER (2005). Integration of the extranuclear and nuclear actions of estrogen. Mol. Endocrinol. 19 (8): 1951–9.").<Reference> makeItLive());
					}
				
				Effect_MolecularInitiatingEvent mie2 = (Effect_MolecularInitiatingEvent) searchEffectByTitle("Binding to AR");
				if (mie2 != null)
					pathway.associate(mie2);
				else
					{
						mie2 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
						mie2.setTitle("Binding to AR");
						mie2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
						mie2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						mie2.getDescriptionIDs().set(new DescriptionSection(mie2, dataSource, "Abstract", "").<DescriptionSection> makeItLive(), 0);
					}
				
				Effect_MolecularInitiatingEvent mie3 = (Effect_MolecularInitiatingEvent) searchEffectByTitle("Binding to PR");
				if (mie3 != null)
					pathway.associate(mie3);
				else
					{
						mie3 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
						mie3.setTitle("Binding to PR");
						mie3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
						mie3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						mie3.getDescriptionIDs().set(new DescriptionSection(mie3, dataSource, "Abstract", "Binding to Progesterone Receptor").<DescriptionSection> makeItLive(), 0);
					}
				
				Effect_MolecularInitiatingEvent mie4 = (Effect_MolecularInitiatingEvent) searchEffectByTitle("Binding to GR");
				if (mie4 != null)
					pathway.associate(mie4);
				else
					{
						mie4 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
						mie4.setTitle("Binding to GR");
						mie4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
						mie4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						mie4.getDescriptionIDs().set(new DescriptionSection(mie4, dataSource, "Abstract", "Binding to Glucocorticoid receptor").<DescriptionSection> makeItLive(), 0);
					}
				
				Effect_MolecularInitiatingEvent mie5 = (Effect_MolecularInitiatingEvent) searchEffectByTitle("Binding to MR");
				if (mie5 != null)
					pathway.associate(mie5);
				else
					{
						mie5 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
						mie5.setTitle("Binding to MR");
						mie5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
						mie5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						mie5.getDescriptionIDs().set(new DescriptionSection(mie5, dataSource, "Abstract", "Binding to Mineralocorticoid Receptor").<DescriptionSection> makeItLive(), 0);
					}
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie1);
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie3);
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie4);
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie5);
				
				new Link_ChemStructToMIE(pathway, dataSource, rChemical1, mie0);
				new Link_ChemStructToMIE(pathway, dataSource, rChemical2, mie0);
				new Link_ChemStructToMIE(pathway, dataSource, rChemical3, mie0);
				new Link_ChemStructToMIE(pathway, dataSource, rChemical1, mie1);
				new Link_ChemStructToMIE(pathway, dataSource, rChemical2, mie1);
				new Link_ChemStructToMIE(pathway, dataSource, rChemical1, mie2);
				new Link_ChemStructToMIE(pathway, dataSource, rChemical2, mie2);
				
				pathway.updateEssentiality();
				return pathway;
			}
		
		public Pathway LhasaInhibitionComplex_I_IV(DataSource dataSource)
			{
				Effectopedia.EFFECTOPEDIA.setCurrentUser(STEVEN_AND_DAMIANO);
				Pathway pathway = new Pathway(null, dataSource);
				pathway.setTitle("Inhibition of complexes I-IV");
				
				Effectopedia.EFFECTOPEDIA.setCurrentUser(STEVEN);
				Initiator_ChemicalStructure chemical1 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical1.setTitle("Rotenone");
				chemical1
						.getStructure2DImage()
						.setValue(
								"https://apps.ideaconsult.net/ambit2/depict/cdk?search=c12c3c%28O%5BC%40H%5D%28C3%29C%28%3DC%29C%29ccc1C%28%3DO%29%5BC%40%40H%5D1%5BC%40H%5D%28O2%29COc2c1cc%28c%28c2%29OC%29OC&w=200&h=200&media=image/png");
				chemical1.getIdentification().setPropertyValue(0, "83794");
				chemical1.getIdentification().setPropertyValue(1, "(2R,6aS,12aS)-2-Isopropenyl-8,9-dimethoxy-1,2,12,12a-tetrahydrochromeno[3,4-b]furo[2,3-h]chromen-6(6aH)-one");
				chemical1.getIdentification().setPropertyValue(2, "O=C2c5ccc1O[C@@H](C(=C)\\C)Cc1c5O[C@H]3[C@@H]2c4c(OC3)cc(OC)c(OC)c4");
				chemical1.getIdentification().setPropertyValue(3, "C23H22O6");
				chemical1.getProperties().setPropertyValue(0, "394.417");
				chemical1.getProperties().setPropertyValue(2, "165.5");
				
				Effectopedia.EFFECTOPEDIA.setCurrentUser(DAMIANO);
				Initiator_ChemicalStructure chemical2 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical2.setTitle("Thenoyltrifluoroacetone");
				chemical2.getStructure2DImage().setValue("https://apps.ideaconsult.net/ambit2/depict/cdk?search=c1%28C%28CC%28C%28F%29%28F%29F%29%3DO%29%3DO%29cccs1&w=200&h=200&media=image/png");
				chemical2.getIdentification().setPropertyValue(0, "326910");
				chemical2.getIdentification().setPropertyValue(1, "4,4,4-Trifluoro-1-(2-thienyl)butane-1,3-dione");
				chemical2.getIdentification().setPropertyValue(2, "O=C(c1sccc1)CC(=O)C(F)(F)F");
				chemical2.getIdentification().setPropertyValue(3, "C8H5F3O2S");
				chemical2.getProperties().setPropertyValue(0, "222.184");
				chemical2.getProperties().setPropertyValue(2, "42.5");
				chemical2.getProperties().setPropertyValue(3, "97.0");
				
				Initiator_ChemicalStructure chemical3 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical3.setTitle("Myxothiazol");
				chemical3
						.getStructure2DImage()
						.setValue(
								"https://apps.ideaconsult.net/ambit2/depict/cdk?search=O%3DC%28N%29%5CC%3DC%28%5COC%29%5BC%40H%5D%28C%29%5BC%40%40H%5D%28OC%29%2FC%3DC%2Fc1nc%28sc1%29c2nc%28sc2%29%5BC%40H%5D%28%5CC%3DC%5CC%3DC%5CC%28C%29C%29C&w=200&h=200&media=image/png");
				chemical3.getIdentification().setPropertyValue(0, "76706553");
				chemical3.getIdentification().setPropertyValue(1, "(2E,4R,5S,6E)-3,5-Dimethoxy-4-methyl-7-{2'-[(2S,3E,5E)-7-methyl-3,5-octadien-2-yl]-2,4'-bi-1,3-thiazol-4-yl}-2,6-heptadienamide");
				chemical3.getIdentification().setPropertyValue(2, "O=C(N)\\C=C(\\OC)[C@H](C)[C@@H](OC)/C=C/c1nc(sc1)c2nc(sc2)[C@H](\\C=C\\C=C\\C(C)C)C");
				chemical3.getIdentification().setPropertyValue(3, "C25H33N3O3S2");
				chemical3.getProperties().setPropertyValue(0, "487.678");
				
				Effectopedia.EFFECTOPEDIA.setCurrentUser(STEVEN);
				Initiator_ChemicalStructure chemical4 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical4.setTitle("Potassium cyanide");
				chemical4.getStructure2DImage().setValue("https://apps.ideaconsult.net/ambit2/depict/cdk?search=[C-]%23N.[K%2B]&w=200&h=200&media=image/png");
				chemical4.getIdentification().setPropertyValue(0, "151508");
				chemical4.getIdentification().setPropertyValue(1, "Potassium cyanide");
				chemical4.getIdentification().setPropertyValue(2, "[K+].[C-]#N");
				chemical4.getIdentification().setPropertyValue(3, "CKN");
				chemical4.getProperties().setPropertyValue(0, "65.116");
				chemical4.getProperties().setPropertyValue(2, "634.0");
				
				Effect_MolecularInitiatingEvent mie1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie1.setTitle("Inhibition of complex I");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										mie1,
										dataSource,
										"Background",
										"The electron transport chain (ETC) is composed of four complexes (I-IV) embedded in the mitochondrial inner membrane and plays a crucial role in the production of ATP by mitochondria.  Electrons are received from a donor such as nicotinamide adenine dinucleotide (NADH) and then dropped through a series of intermediate stages of increasing redox potential to their final destination, oxygen.  The energy released from NADH oxidation is used to pump protons from the matrix of the mitochondria to the intermembrane space, thereby creating an electrochemical gradient which is used by ATP synthase as the energy source for ATP production.\n\nComplex I, also known as NADH-ubiquinone oxidoreductase, is the first of the four complexes of the ETC.  The complex receives 2 electrons from NADH and passes each electron along a chain of Fe-S clusters where they are ultimately delivered, via terminal cluster N2, to ubiquinone which is reduced to ubiquinol.  For each electron pair donated to ubiquinone, complex I pumps 4 protons from the matrix to the intermembrane space [Scheffler].")
										.<DescriptionSection> makeItLive(), 0);
				mie1
						.getDescriptionIDs()
						.add(
								new DescriptionSection(
										mie1,
										dataSource,
										"Description",
										"A large number of structurally diverse compounds of synthetic and natural origin are known to inhibit the activity of complex I [Esposti].  Rotenone is perhaps the best known of these, although other well-known inhibitors include the antibiotic piericidin A and N-methyl-4-phenylpyridinium (MPP+) which is the active metabolite of N-methyl-4-phenyl-1,2,3,6-tetrahydropyridine.\n\nThe mechanism of complex I inhibition is not well understood.  It appears that the vast majority of known inhibitors, including rotenone, act at the ubiquinone reduction site, preventing the transfer of electrons from the terminal Fe-S cluster, N2, to ubiquinone [Scheffler].  However, many authors believe that complex I has multiple ubiquinone reduction sites and as a result may present multiple sites for inhibitors [Gluck et al].  This may, in part, explain the structural diversity of compounds capable of inhibiting the complex.")
										.<DescriptionSection> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource, "Scheffler, I. E. (2008). Mitochondria, Second Edition. Hoboken, NJ: John Wiley & Sons.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource, "Esposti, M. D. (1998). Inhibitors of NADH−ubiquinone reductase: an overview. Biochimica et Biophysica Acta, 1364, 222-235.").<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Gluck, M. R., Krueger, M. J., Ramsay, R. R., Sablin, S. O., Singer T. P., & Nicklas, W. J. (1994). Characterization of the inhibitory mechanism of 1-methyl-4-phenylpyridinium and 4-phenylpyridine analogs in inner membrane preparations. Journal of Biological Chemistry, 269, 3167-3174.")
										.<Reference> makeItLive());
				
				Effectopedia.EFFECTOPEDIA.setCurrentUser(DAMIANO);
				Effect_MolecularInitiatingEvent mie2 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie2.setTitle("Inhibition of complex II");
				mie2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie2
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										mie2,
										dataSource,
										"Background",
										"The electron transport chain (ETC) is composed of four complexes (I-IV) embedded in the mitochondrial inner membrane and plays a crucial role in the production of ATP by mitochondria.  Electrons are received from a donor such as nicotinamide adenine dinucleotide (NADH) and then dropped through a series of intermediate stages of increasing redox potential to their final destination, oxygen.  The energy released from NADH oxidation is used to pump protons from the matrix of the mitochondria to the intermembrane space, thereby creating an electrochemical gradient which is used by ATP synthase as the energy source for ATP production.\n\nComplex II, more commonly referred to as succinate:ubiquinone reductase (SQR), plays a role in both the ETC and the Krebs cycle.  It is responsible for the oxidation of succinate to fumarate and the reduction of ubiquinone to ubiquinol.  Structurally, SQR is the simplest of the complexes of the ETC, consisting of only four subunits [Scheffler].  These are a flavoprotein, an iron-sulfur protein (containing the 3 centres: [2Fe-2S], [3Fe-4S] and [4Fe-4S]) and two small membrane anchor subunits.  The complex contributes to electron flow to oxygen but is not directly involved in proton translocation.")
										.<DescriptionSection> makeItLive(), 0);
				mie2
						.getDescriptionIDs()
						.add(
								new DescriptionSection(
										mie2,
										dataSource,
										"Description",
										"Xenobiotic-induced inhibition of complex II is not well understood and may proceed via multiple mechanisms involving different sites within the complex.  Inhibitors of complex II can be broadly divided into two classes: those that bind in the succinate pocket and those which bind in the ubiquinone pocket.  The former class includes various dicarboxylic acids and analogues.  Examples include oxaloacetate [Wojtovich et al], fluorinated analogues of succinate and fumarate such as 2-fluorosuccinate and difluorofumarate [Tober et al], as well as the nitro-analogue of malonate, 3-nitro propionic acid (3-NPA) [Sun et al].  Examples of ubiquinone type inhibitors include carboxin, thenoyltrifluoroacetone (TTFA) and various atpenins, such as harzianopyridone [Miyadera et al].")
										.<DescriptionSection> makeItLive());
				mie2.getReferenceIDs().add(new Reference(mie2, dataSource, "Scheffler, I. E. (2008). Mitochondria, Second Edition. Hoboken, NJ: John Wiley & Sons.").<Reference> makeItLive());
				mie2.getReferenceIDs().add(
						new Reference(mie2, dataSource, "Wojtovich, L., Wojtovich, A. B., and Ernster, L. (1969). The inhibition of succinate dehydrogenase by oxaloacetate. Biochimica et Biophysica Acta, 191, 10-21.")
								.<Reference> makeItLive());
				mie2
						.getReferenceIDs()
						.add(
								new Reference(
										mie2,
										dataSource,
										"Tober, C. L., Nicholls, P., & Brodie, J. D. (1970). Metabolism and enzymology of fluorosuccinic acids: II. Substrate and inhibitor effects with soluble succinate dehydrogenase. Archives of Biochemistry and Biophysics, 138, 506-514.")
										.<Reference> makeItLive());
				mie2.getReferenceIDs().add(
						new Reference(mie2, dataSource,
								"Sun, F., Huo, X., Zhai, Y., Wang, A., Xu, J., Su, D., … Rao, Z. (2005). Crystal structure of mitochondrial respiratory membrane protein complex II. Cell, 121, 1043-1057.")
								.<Reference> makeItLive());
				mie2
						.getReferenceIDs()
						.add(
								new Reference(
										mie2,
										dataSource,
										"Miyadera, H., Shiomi, K., Ui, H., Yamaguchi, Y., Masuma, R., Tomoda, H., … Omura, S. (2003). Atpenins, potent and specific inhibitors of mitochondrial complex II (succinate-ubiquinone oxidoreductase). Proceedings of the National Academy of Sciences of the United States of America, 100, 473-477.")
										.<Reference> makeItLive());
				
				Effect_MolecularInitiatingEvent mie3 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie3.setTitle("Inhibition of complex III");
				mie3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie3
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										mie3,
										dataSource,
										"Background",
										"The electron transport chain (ETC) is composed of four complexes (I-IV) embedded in the mitochondrial inner membrane and plays a crucial role in the production of ATP by mitochondria.  Electrons are received from a donor such as nicotinamide adenine dinucleotide (NADH) and then dropped through a series of intermediate stages of increasing redox potential to their final destination, oxygen.  The energy released from NADH oxidation is used to pump protons from the matrix of the mitochondria to the intermembrane space, thereby creating an electrochemical gradient which is used by ATP synthase as the energy source for ATP production.\n\nComplex III, also known as ubiquinone-cytochrome c oxidoreductase or the bc1 complex, is a homodimeric and multi-subunit protein.  Three subunits form the functional core of the enzyme and these contain prosthetic groups which are responsible for the catalytic activity.  The cytochrome b subunit has two b-type hemes (bL and bH), the cytochrome c subunit has one c-type heme (c1) and the Reiske subunit contains a 2Fe-2S cluster.  Overall, the complex catalyses the oxidation of ubiquinol to ubiquinone and the reduction of cytochrome c3+ to cytochrome c2+.  In the process, 4 protons are pumped to the intermembrane space [Scheffler].")
										.<DescriptionSection> makeItLive(), 0);
				mie3
						.getDescriptionIDs()
						.add(
								new DescriptionSection(
										mie3,
										dataSource,
										"Description",
										"Xenobiotic-induced inhibition of complex III is not well understood and may proceed via multiple mechanisms involving different sites within the complex.  A number of structurally diverse compounds have been shown to inhibit the activity of complex III.  Inhibitors may be divided into at least two categories based on their site of action: those that bind at the Qo site (Class P) and those that bind at the Qi site (Class N) [Esser et al].  Examples of the former group include include stigmatellin [Esposti et al] and myxothiazol [Esposti et al], while an example of the latter group is antimycin A [Von Jagow and Link].")
										.<DescriptionSection> makeItLive());
				mie3.getReferenceIDs().add(new Reference(mie3, dataSource, "Scheffler, I. E. (2008). Mitochondria, Second Edition. Hoboken, NJ: John Wiley & Sons.").<Reference> makeItLive());
				mie3
						.getReferenceIDs()
						.add(
								new Reference(
										mie3,
										dataSource,
										"Esser, L., Quinn, B., Li, Y. F., Zhang, M., Elberry, M., Yu, L., … Xia, D. (2004). Crystallographic studies of quinol oxidation site inhibitors: a modified classification of inhibitors for the cytochrome bc(1) complex. Journal of Molecular Biology, 341, 281-302.")
										.<Reference> makeItLive());
				mie3.getReferenceIDs().add(
						new Reference(mie3, dataSource, "Esposti, M. D. (1998). Inhibitors of NADH−ubiquinone reductase: an overview. Biochimica et Biophysica Acta, 1364, 222-235.").<Reference> makeItLive());
				mie3.getReferenceIDs().add(
						new Reference(mie3, dataSource, "von Jagow, G., & Link, T. A. (1986). Use of specific inhibitors on the mitochondrial bc1 complex. Methods in Enzymology, 126, 253-271.")
								.<Reference> makeItLive());
				
				Effectopedia.EFFECTOPEDIA.setCurrentUser(STEVEN);
				Effect_MolecularInitiatingEvent mie4 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie4.setTitle("Inhibition of complex IV");
				mie4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie4
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										mie4,
										dataSource,
										"Background",
										"The electron transport chain (ETC) is composed of four complexes (I-IV) embedded in the mitochondrial inner membrane and plays a crucial role in the production of ATP by mitochondria.  Electrons are received from a donor such as nicotinamide adenine dinucleotide (NADH) and then dropped through a series of intermediate stages of increasing redox potential to their final destination, oxygen.  The energy released from NADH oxidation is used to pump protons from the matrix of the mitochondria to the intermembrane space, thereby creating an electrochemical gradient which is used by ATP synthase as the energy source for ATP production.\n\nComplex IV, commonly referred to as cytochrome c oxidase, is the fourth and terminal complex of the ETC.  The mammalian complex functions as a dimer, with each monomer unit containing 13 different polypeptide chains.  Three subunits form the functional core of the enzyme and these contain two hemes (heme a and heme a3) and two copper centres (the CuA and CuB centres).  The role of the complex within the ETC is to receive four electrons from cytochrome c and pass them, via the copper and heme centres, to oxygen, which is reduced to water.  The energy released by this process is used to pump protons from the mitochondrial matrix to the intermembrane space.  For every oxygen molecule that is reduced, two molecules of water are produced and four protons are pumped to the intermembrane space [Scheffler].")
										.<DescriptionSection> makeItLive(), 0);
				mie4
						.getDescriptionIDs()
						.add(
								new DescriptionSection(
										mie2,
										dataSource,
										"Description",
										"Xenobiotic-induced inhibition of complex IV is not well understood and may proceed via multiple mechanisms involving different sites within the complex.  A variety of structurally diverse compounds are known to inhibit the activity of complex IV [Nicholls and Chance].  Inhibitors can be classified according to whether they effect the oxygen-reducing, heme a3—CuB centre of the enzyme (e.g. cyanide [Rossignol et al] and carbon monoxide [Erecinska and Wilson]) or the interaction of complex IV with the natural electron donor, cytochrome c (e.g. alkaline proteins and polypeptides) [Wallace and Starkov].")
										.<DescriptionSection> makeItLive());
				mie4.getReferenceIDs().add(new Reference(mie4, dataSource, "Scheffler, I. E. (2008). Mitochondria, Second Edition. Hoboken, NJ: John Wiley & Sons.").<Reference> makeItLive());
				mie4.getReferenceIDs().add(
						new Reference(mie4, dataSource, "Nicholls, P., & Chance, B. (1974). Cytochrome c oxidase. In O, Hayaish (Ed.), Molecular Mechanisms of Oxygen Activation (pp 479-534). New York: Academic.")
								.<Reference> makeItLive());
				mie4
						.getReferenceIDs()
						.add(
								new Reference(
										mie4,
										dataSource,
										"Rossignol, R., Letellier, T., Malgat, M., Rocher, C., & Mazat, J. P. (2000). Tissue variation in the control of oxidative phosphorylation: implication for mitochondrial diseases. Biochemical Journal, 347, 45-53.")
										.<Reference> makeItLive());
				mie4.getReferenceIDs().add(
						new Reference(mie4, dataSource, "Erecińska, M., & Wilson, D. F. (1980). Inhibitors of cytochrome c oxidase. Pharmacology & Therapeutics, 8, 1-20.").<Reference> makeItLive());
				mie4.getReferenceIDs().add(
						new Reference(mie4, dataSource, "Wallace, K. B., & Starkov, A. A. (2000). Mitochondrial targets of drug toxicity. Annual Review of Pharmacology and Toxicology, 40, 353-388.")
								.<Reference> makeItLive());
				
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie1);
				new Link_ChemStructToMIE(pathway, dataSource, chemical4, mie4);
				Effectopedia.EFFECTOPEDIA.setCurrentUser(DAMIANO);
				new Link_ChemStructToMIE(pathway, dataSource, chemical2, mie2);
				new Link_ChemStructToMIE(pathway, dataSource, chemical3, mie3);
				
				Effectopedia.EFFECTOPEDIA.setCurrentUser(STEVEN_AND_DAMIANO);
				Effect_DownstreamEffect organelle_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				organelle_effect1.setTitle("Inhibition of the electron transport chain");
				organelle_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organelle");
				organelle_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organelle_effect1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										organelle_effect1,
										dataSource,
										"Description",
										"Inhibition of any of the protein complexes I-IV can result in an impairment of the proper functioning of the electron transport chain (ETC) as a whole.  This results in reduced electron flow along the ETC and a decrease in proton translocation from the matrix to the intermembrane space.")
										.<DescriptionSection> makeItLive(), 0);
				
				new Link_EffectToEffect(pathway, dataSource, mie1, organelle_effect1);
				new Link_EffectToEffect(pathway, dataSource, mie2, organelle_effect1);
				new Link_EffectToEffect(pathway, dataSource, mie3, organelle_effect1);
				new Link_EffectToEffect(pathway, dataSource, mie4, organelle_effect1);
				
				Effect_DownstreamEffect organelle_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				organelle_effect2.setTitle("Reduced mitochondrial oxygen consumption");
				organelle_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organelle");
				organelle_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organelle_effect2
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										organelle_effect2,
										dataSource,
										"Description",
										"In normally functioning mitochondria, electrons are carried along the electron transport chain (ETC) from a donor, such as nicotinamide adenine dinucleotide, to oxygen which is reduced to water.  This process results in the consumption of oxygen by mitochondria.\n\nThe inhibition of electron flow along the ETC prevents the conversion of oxygen to water, resulting in reduced mitochondrial oxygen consumption.  Xenobiotics may impair electron flow via multiple mechanisms, including the inhibition of individual complexes of the ETC and inhibition of ATP synthase leading to fixed or hyperpolarized membrane potential.\n\nOxygen consumption can be measured in isolated mitochondria or whole cells.  Traditionally, this was achieved using the Clarke electrode; however, alternative methods have now been developed.  One approach is to use a conjugated Pt-porphyrin probe with long-decay phosphorescence which is quenched by molecular oxygen [Hynes et al].  It is important to note that while a reduction in oxygen consumption in isolated mitochondria is indicative of mitochondrial dysfunction, this is not the case in whole cells since a dying cell will display a reduction in oxygen uptake regardless of mechanism.  To overcome this problem, pH sensors can be used to measure extracellular acidification.  Glycolysis is known to increase following mitochondrial impairment, thereby increasing the acidification rate, an effect not seen with general cytotoxicity.")
										.<DescriptionSection> makeItLive(), 0);
				organelle_effect2
						.getReferenceIDs()
						.add(
								new Reference(
										organelle_effect2,
										dataSource,
										"Hynes, J., Marroquin, L. D., Ogurtsov, V. I., Christiansen. K, N., Stevens, G. J,, Papkovsky, D. B., & Will, Y. (2006). Investigation of drug-induced mitochondrial toxicity using fluorescence-based oxygen-sensitive probes. Toxicological Sciences, 92, 186-200.")
										.<Reference> makeItLive());
				
				Effect_DownstreamEffect organelle_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
				organelle_effect3.setTitle("Reduced mitochondrial membrane potential");
				organelle_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organelle");
				organelle_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organelle_effect3
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										organelle_effect3,
										dataSource,
										"Description",
										"In normally functioning mitochondria, the energy released as electrons flow through the electron transport chain (ETC) is used to pump protons from the matrix to the intermembrane space, thereby maintaining the electrochemical gradient.\n\nThe interaction of xenobiotics with mitochondrial targets may lead to reduced membrane potential via a variety of mechanisms.  These include inhibition of the individual complexes of the ETC and uncoupling of oxidative phosphorylation.\n\nMitochondrial membrane potential is usually measured in vitro using fluorescent cationic dyes which accumulate in the mitochondrial matrix as a function of the Nernst equation.  Examples of dyes used include JC-1, rhodamine 123, tetramethylrhodamine methyl ester and MitoTracker Red [Nadanaciva and Will].")
										.<DescriptionSection> makeItLive(), 0);
				organelle_effect3.getReferenceIDs().add(
						new Reference(organelle_effect3, dataSource, "Nadanaciva, S., & Will, Y. (2011). New insights in drug-induced mitochondrial toxicity. Current Pharmaceutical Design, 17, 2100-2112.")
								.<Reference> makeItLive());
				
				Effect_DownstreamEffect organelle_effect4 = new Effect_DownstreamEffect(pathway, dataSource);
				organelle_effect4.setTitle("Increased mitochondrial reactive oxygen species formation");
				organelle_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organelle");
				organelle_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organelle_effect4
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										organelle_effect4,
										dataSource,
										"Description",
										"Mitochondria are believed to be a major source of reactive oxygen species (ROS) under normal physiological conditions.  It is thought that ROS generation is localized to complexes I and III, via electron leakage.  ‘Leaked’ electrons may react with molecular oxygen, which undergoes a one-electron reduction to yield superoxide [Turrens].\n\nXenobiotics may cause an increase in ROS formation via interaction with several mitochondrial targets including inhibition of individual complexes of the electron transport chain (ETC) and inhibition of ATP synthase.\n\nROS are usually measured in vitro using compounds such as dichlorofluorescin or dihydroethidium bromide, which yield a fluorescent signal upon oxidation.")
										.<DescriptionSection> makeItLive(), 0);
				organelle_effect4.getReferenceIDs().add(
						new Reference(organelle_effect4, dataSource, "Turrens, J. F. (1997). Superoxide production by the mitochondrial respiratory chain. Bioscience Reports, 17, 3-8.").<Reference> makeItLive());
				
				Link link = new Link_EffectToEffect(pathway, dataSource, organelle_effect1, organelle_effect2);
				link
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										link,
										dataSource,
										"Description",
										"In several studies using mammalian isolated mitochondria or whole cells, treatment with compounds known to inhibit the individual complexes of the ETC (e.g. rotenone [Kweon et al], thenoyltrifluoroacetone [Byun et al], myxothiazol [Young et al] and potassium cyanide [Rossignol et al]) led to a decrease in oxygen consumption.")
										.<DescriptionSection> makeItLive(), 0);
				link
						.getReferenceIDs()
						.add(
								new Reference(
										link,
										dataSource,
										"Kweon, G.-R., Marks, J. D., Krencik, R., Leung, E. H., Schumacker, P. T., Hyland, K., & Kang, U. J. (2004). Distinct mechanisms of neurodegeneration induced by chronic complex I inhibition in dopaminergic and non-dopaminergic cells. Journal of Biological Chemistry, 279, 51783-51792.")
										.<Reference> makeItLive());
				link
						.getReferenceIDs()
						.add(
								new Reference(
										link,
										dataSource,
										"Byun, H.-O., Kim, H. Y., Lim, J. J., Seo, Y.-H., & Yoon, G. (2008). Mitochondrial dysfunction by complex II inhibition delays overall cell cycle progression via reactive oxygen species production. Journal of Cellular Biochemistry, 104, 1747-1759.")
										.<Reference> makeItLive());
				link
						.getReferenceIDs()
						.add(
								new Reference(
										link,
										dataSource,
										"Rossignol, R., Letellier, T., Malgat, M., Rocher, C., & Mazat, J. P. (2000). Tissue variation in the control of oxidative phosphorylation: implication for mitochondrial diseases. Biochemical Journal, 347, 45-53.")
										.<Reference> makeItLive());
				link
						.getReferenceIDs()
						.add(
								new Reference(
										link,
										dataSource,
										"Young, T. A., Cunningham, C. C., & Bailey, S. M. (2002). Reactive oxygen species production by the mitochondrial respiratory chain in isolated rat hepatocytes and liver mitochondria: studies using myxothiazol. Archives of Biochemistry and Biophysics, 405, 65-72.")
										.<Reference> makeItLive());
				
				link = new Link_EffectToEffect(pathway, dataSource, organelle_effect1, organelle_effect3);
				link
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										link,
										dataSource,
										"Description",
										"In several studies using mammalian isolated mitochondria or whole cells, treatment with compounds known to inhibit the individual complexes of the ETC (e.g. rotenone [Isenberg and Klaunig], thenoyltrifluoroacetone [Byun et al], myxothiazol [Bal-Price and Brown] and potassium cyanide [Li et al]) led to a decrease in mitochondrial membrane potential.")
										.<DescriptionSection> makeItLive(), 0);
				link.getReferenceIDs().add(
						new Reference(link, dataSource,
								"Isenberg, J. S., & Klaunig, J. E. (2000). Role of the mitochondrial membrane permeability transition (MPT) in rotenone-induced apoptosis in liver cells. Toxicological Sciences, 53, 340-51.")
								.<Reference> makeItLive());
				link
						.getReferenceIDs()
						.add(
								new Reference(
										link,
										dataSource,
										"Byun, H.-O., Kim, H. Y., Lim, J. J., Seo, Y.-H., & Yoon, G. (2008). Mitochondrial dysfunction by complex II inhibition delays overall cell cycle progression via reactive oxygen species production. Journal of Cellular Biochemistry, 104, 1747-1759.")
										.<Reference> makeItLive());
				link.getReferenceIDs().add(
						new Reference(link, dataSource,
								"Bal-Price A., & Brown, G. C. (2000). Nitric-oxide-induced necrosis and apoptosis in PC12 cells mediated by mitochondria. Journal of Neurochemistry, 75, 1455-1466.").<Reference> makeItLive());
				link
						.getReferenceIDs()
						.add(
								new Reference(
										link,
										dataSource,
										"Li, L., Prabhakaran, E., Mills, E. M., Borowitz, J. L., & Isom, G. E. (2005). Enhancement of cyanide-induced mitochondrial dysfunction and cortical cell necrosis by uncoupling protein-2. Toxicological Sciences, 86, 116-124.")
										.<Reference> makeItLive());
				
				link = new Link_EffectToEffect(pathway, dataSource, organelle_effect1, organelle_effect4);
				link
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										link,
										dataSource,
										"Description",
										"Inhibition of complexes of the ETC results in accumulation of reduced forms before the inhibitor point and oxidized components ahead of the inhibitor point.  As a result, electrons may remain at sites of leakage for longer periods of time, leading to increased mitochondrial ROS production.  In numerous in vitro studies, treatment of isolated mitochondria or whole cells with inhibitors of individual complexes of the ETC (e.g. rotenone [Sherer et al, Young et al], thenoyltrifluoroacetone [Byun et al], myxothiazol [Young et al] and potassium cyanide [Prabhakaran et al]) led to an increase in ROS levels.  A variety of mammalian cell types were employed.")
										.<DescriptionSection> makeItLive(), 0);
				link
						.getReferenceIDs()
						.add(
								new Reference(
										link,
										dataSource,
										"Sherer, T. B., Betarbet, R., Testa, C. M., Seo, B. B., Richardson, J. R., Kim, J. H., … Greenamyre, J. T. (2003). Mechanism of toxicity in rotenone models of Parkinson's disease. Journal of Neuroscience, 23, 10756-10764.")
										.<Reference> makeItLive());
				link
						.getReferenceIDs()
						.add(
								new Reference(
										link,
										dataSource,
										"Young, T. A., Cunningham, C. C., & Bailey, S. M. (2002). Reactive oxygen species production by the mitochondrial respiratory chain in isolated rat hepatocytes and liver mitochondria: studies using myxothiazol. Archives of Biochemistry and Biophysics, 405, 65-72.")
										.<Reference> makeItLive());
				link
						.getReferenceIDs()
						.add(
								new Reference(
										link,
										dataSource,
										"Byun, H.-O., Kim, H. Y., Lim, J. J., Seo, Y.-H., & Yoon, G. (2008). Mitochondrial dysfunction by complex II inhibition delays overall cell cycle progression via reactive oxygen species production. Journal of Cellular Biochemistry, 104, 1747-1759.")
										.<Reference> makeItLive());
				link
						.getReferenceIDs()
						.add(
								new Reference(
										link,
										dataSource,
										"Prabhakaran, K., Li, L., Borowitz, J. L., & Isom, G. E. (2002). Cyanide induces different modes of death in cortical and mesencephalon cells. Journal of Pharmacology and Experimental Therapeutics, 303, 510-519.")
										.<Reference> makeItLive());
				
				Effect_DownstreamEffect organelle_effect5 = (Effect_DownstreamEffect) searchEffectByTitle("Reduced ATP formation");
				if (organelle_effect5 != null)
					{
						pathway.associate(organelle_effect5);
					}
				else
					{
						organelle_effect5 = new Effect_DownstreamEffect(pathway, dataSource);
						organelle_effect5.setTitle("Reduced ATP formation");
						organelle_effect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organelle");
						organelle_effect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						organelle_effect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");
					}
				
				organelle_effect5
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										organelle_effect5,
										dataSource,
										"Description",
										"In normally functioning mitochondria, the energy released from NADH oxidation is used to pump protons from the matrix of the mitochondria to the intermembrane space, thereby creating an electrochemical gradient which is used by ATP synthase (complex V) as the energy source for ATP production.\n\nXenobiotics may cause reduced mitochondrial ATP formation via interaction with a variety of mitochondrial targets including inhibition of individual complexes of the electron transport chain and inhibition of ATP synthase.\n\nATP levels are often measured at a cellular level using luciferin-luciferase based assays.  These assays involve the measurement of light produced by the reaction of ATP with added luciferase and D-luciferin.  Within certain limits, the light emitted is proportional to the ATP concentration.")
										.<DescriptionSection> makeItLive(), 0);
				
				link = new Link_EffectToEffect(pathway, dataSource, organelle_effect3, organelle_effect5);
				link
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										link,
										dataSource,
										"Description",
										"Since mitochondrial membrane potential is used as an energy supply for ATP synthase, a reduction in this potential may lead to a concurrent reduction in ATP synthesis via oxidative phosphorylation.  In many cases, this dysfunction may manifest itself at a cellular level by a reduction in cellular ATP level.  This was demonstrated in several studies using isolated mitochondria or whole cells and inhibitors of the individual complexes of the ETC (e.g. rotenone [Kweon et al, Pastorino et al], TTFA [Byun et al], antimycin A [Wu et al] and potassium cyanide [Li et al]).  A variety of mammalian cell types were employed.")
										.<DescriptionSection> makeItLive(), 0);
				link
						.getReferenceIDs()
						.add(
								new Reference(
										link,
										dataSource,
										"Kweon, G.-R., Marks, J. D., Krencik, R., Leung, E. H., Schumacker, P. T., Hyland, K., & Kang, U. J. (2004). Distinct mechanisms of neurodegeneration induced by chronic complex I inhibition in dopaminergic and non-dopaminergic cells. Journal of Biological Chemistry, 279, 51783-51792.")
										.<Reference> makeItLive());
				link
						.getReferenceIDs()
						.add(
								new Reference(
										link,
										dataSource,
										"Pastorino, J. G., Snyder, J. W., Serroni, A., Hoek, J. B., & Farber, J. L. (1993). Cyclosporin and carnitine prevent the anoxic death of cultured hepatocytes by inhibiting the mitochondrial permeability transition. Journal of Biological Chemistry, 268, 13791-13798.")
										.<Reference> makeItLive());
				link
						.getReferenceIDs()
						.add(
								new Reference(
										link,
										dataSource,
										"Byun, H.-O., Kim, H. Y., Lim, J. J., Seo, Y.-H., & Yoon, G. (2008). Mitochondrial dysfunction by complex II inhibition delays overall cell cycle progression via reactive oxygen species production. Journal of Cellular Biochemistry, 104, 1747-1759.")
										.<Reference> makeItLive());
				link
						.getReferenceIDs()
						.add(
								new Reference(
										link,
										dataSource,
										"Wu, E. Y., Smith, M. T., Bellomo, G., & Di Monte, D. (1990). Relationships between the mitochondrial transmembrane potential, ATP concentration, and cytotoxicity in isolated rat hepatocytes. Archives of Biochemistry and Biophysics, 282, 358-362.")
										.<Reference> makeItLive());
				link
						.getReferenceIDs()
						.add(
								new Reference(
										link,
										dataSource,
										"Li, L., Prabhakaran, E., Mills, E. M., Borowitz, J. L., & Isom, G. E. (2005). Enhancement of cyanide-induced mitochondrial dysfunction and cortical cell necrosis by uncoupling protein-2. Toxicological Sciences, 86, 116-124.")
										.<Reference> makeItLive());
				
				Effect_DownstreamEffect cellular_effect1 = (Effect_DownstreamEffect) searchEffectByTitle("Inhibition of ATP-dependent cellular functions");
				if (cellular_effect1 != null)
					pathway.associate(cellular_effect1);
				else
					{
						cellular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
						cellular_effect1.setTitle("Inhibition of ATP-dependent cellular functions");
						cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
						cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");
					}
				cellular_effect1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										cellular_effect1,
										dataSource,
										"Description",
										"Cells which are unable to sufficiently compensate for a reduction in oxidative phosphorylation by increasing glycolysis, will suffer a significant drop in cellular ATP level following electron transport chain inhibition.  In these cells, there will likely be a subsequent inhibition of ATP-dependent cellular functions.  Many of these functions are crucial for cell function and survival.  For instance, severe energy depletion may cause failure of the ATP-driven calcium and sodium pumps.  This in turn can result in flooding of the cell with calcium and sodium, leading to osmotic rupture of the plasma membrane [Boelsterli].")
										.<DescriptionSection> makeItLive(), 0);
				cellular_effect1.getReferenceIDs().add(
						new Reference(cellular_effect1, dataSource, "Boelsterli, U. A. (2003). Mechanistic Toxicology: The Molecular Basis of How Chemicals Disrupt Biological Targets. London, Taylor & Francis.")
								.<Reference> makeItLive());
				
				link = (Link) Pathway.getDirektLink(organelle_effect5, cellular_effect1);
				if (link != null)
					pathway.add(link);
				else
					new Link_EffectToEffect(pathway, dataSource, organelle_effect5, cellular_effect1);
				
				Effect_DownstreamEffect cellular_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect2.setTitle("Necrosis");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");
				cellular_effect2
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										cellular_effect2,
										dataSource,
										"Description",
										"Necrosis is a pathway of premature cell death and, in contrast to apoptosis, is a passive and unscheduled process.  Necrotic cells swell and rupture, usually leading to an inflammatory response.  Necrosis is prevalent in cases where cells are exposed to high concentrations of a toxic xenobiotic and when exposure is long.  Necrosis promoting mechanisms include oxidative stress, mitochondrial damage and ATP depletion, or activation of Ca2+-dependent proteases, phospholipases and endonucleases [Boelsterli].")
										.<DescriptionSection> makeItLive(), 0);
				cellular_effect2.getReferenceIDs().add(
						new Reference(cellular_effect2, dataSource, "Boelsterli, U. A. (2003). Mechanistic Toxicology: The Molecular Basis of How Chemicals Disrupt Biological Targets. London, Taylor & Francis.")
								.<Reference> makeItLive());
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, cellular_effect2);
				
				Effect_DownstreamEffect cellular_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect3.setTitle("Apoptosis");
				cellular_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				cellular_effect3
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										organelle_effect3,
										dataSource,
										"Description",
										"Apoptosis is the most common and best understood form of programmed cell death.  Cells undergoing apoptotic death display characteristic morphological changes, including blebbing, cell shrinkage, nuclear fragmentation, chromatin condensation and chromosomal DNA fragmentation.  Xenobiotic-induced apoptosis may be triggered by a wide variety of stimuli.  Among these, excessive oxidative stress and its downstream signalling cascades are believed to be a critical initiator of apoptotic death [Boelsterli].")
										.<DescriptionSection> makeItLive(), 0);
				cellular_effect3.getReferenceIDs().add(
						new Reference(mie1, dataSource, "Boelsterli, U. A. (2003) Mechanistic Toxicology: The Molecular Basis of How Chemicals Disrupt Biological Targets. Taylor & Francis, London.")
								.<Reference> makeItLive());
				
				new Link_EffectToEffect(pathway, dataSource, organelle_effect4, cellular_effect3);
				
				Effect_DownstreamEffect tissue_effect1 = (Effect_DownstreamEffect) searchEffectByTitle("Reduced ATP-depndent functions");
				if (tissue_effect1 != null)
					pathway.associateDownstream(tissue_effect1);
				else
					{
						tissue_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
						tissue_effect1.setTitle("Reduced ATP-depndent functions");
						tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
						tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");
					}
				
				link = (Link) Pathway.getDirektLink(cellular_effect1, tissue_effect1);
				if (link != null)
					pathway.add(link);
				else
					new Link_EffectToEffect(pathway, dataSource, cellular_effect1, tissue_effect1);
				
				pathway.updateEssentiality();
				return pathway;
			}
		
		public Pathway LhasaInhibitionATPSynthesis(DataSource dataSource)
			{
				Effectopedia.EFFECTOPEDIA.setCurrentUser(STEVEN_AND_DAMIANO);
				
				Pathway pathway = new Pathway(null, dataSource);
				pathway.setTitle("Inhibition of ATP synthase");
				
				Effectopedia.EFFECTOPEDIA.setCurrentUser(STEVEN);
				Initiator_ChemicalStructure chemical1 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical1.setTitle("Oligomycin A");
				chemical1
						.getStructure2DImage()
						.setValue(
								"https://apps.ideaconsult.net/ambit2/depict/cdk?search=C[C@H]%28O%29C[C@H]1O[C@@]3%28CC[C@H]1C%29O[C@@H]2CC[C@H]%28CC%29/C=C/C=C/C[C@H]%28C%29[C@@H]%28O%29[C@]%28C%29%28O%29C%28=O%29[C@H]%28C%29[C@@H]%28O%29[C@H]%28C%29C%28=O%29[C@H]%28C%29[C@@H]%28O%29[C@H]%28C%29/C=C/C%28=O%29O[C@@H]%28[C@H]2C%29[C@H]3C&w=200&h=200&media=image/png");
				chemical1.getIdentification().setPropertyValue(0, "579135");
				chemical1
						.getIdentification()
						.setPropertyValue(
								1,
								"(1S,4E,5'R,6R,6'R,7S,8R,10S,11S,12R,14S,15R,16S,18E,20E,22S,25R,27S,28R,29S)-22-Ethyl-7,11,14,15-tetrahydroxy-6'-[(2S)-2-hydroxypropyl]-5',6,8,10,12,14,16,28,29-nonamethyl-3',4',5',6'-tetrahydro-3H,9H ,13H-spiro[2,26-dioxabicyclo[23.3.1]nonacosa-4,18,20-triene-27,2'-pyran]-3,9,13-trione");
				chemical1.getIdentification().setPropertyValue(2,
						"C[C@H](O)C[C@H]1O[C@@]3(CC[C@H]1C)O[C@@H]2CC[C@H](CC)/C=C/C=C/C[C@H](C)[C@@H](O)[C@](C)(O)C(=O)[C@H](C)[C@@H](O)[C@H](C)C(=O)[C@H](C)[C@@H](O)[C@H](C)/C=C/C(=O)O[C@@H]([C@H]2C)[C@H]3C");
				chemical1.getIdentification().setPropertyValue(3, " ");
				chemical1.getProperties().setPropertyValue(0, "791.069");
				
				Effect_MolecularInitiatingEvent mie1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie1.setTitle("Inhibition of ATP synthase");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										mie1,
										dataSource,
										"Background",
										"Complex V, commonly referred to as ATP synthase, is a multisubunit protein located within the mitochondria and responsible for the majority of ATP synthesis in aerobic cells.  The enzyme is reversible and may also hydrolyse ATP to produce ADP and generate a proton gradient.  The complex consists of two structurally and functionally distinct regions: the hydrophobic FO region, embedded within the mitochondrial membrane, and the hydrophilic F1 portion which protrudes into the mitochondrial matrix.\n\nATP synthase produces ATP from ADP and inorganic phosphate.  The reaction is energetically unfavourable, a problem which ATP synthase overcomes by harnessing the energy produced by the electron transport chain (ETC) and stored in the form of the mitochondrial membrane potential.  During electron transport, protons are pumped from the mitochondrial matrix to the intermembrane space, creating an electrochemical gradient across the inner membrane of the mitochondria.  The FO portion of ATP synthase is embedded in the inner membrane and provides a narrow hydrophilic channel through which protons can pass.  When protons travel through ATP synthase, from the intermembrane space to the mitochondrial matrix, driven by the electrochemical gradient, their movement causes FO and its axle to rotate .  The rotation of the axle induces conformational changes in proteins of the F1 portion.  The energy released due to these conformational changes is used to drive the energetically unfavourable formation of ATP.")
										.<DescriptionSection> makeItLive(), 0);
				mie1
						.getDescriptionIDs()
						.add(
								new DescriptionSection(
										mie1,
										dataSource,
										"Description",
										"A wide variety of structurally diverse compounds are known to inhibit the activity of ATP synthase.  Inhibitors may be broadly divided into two categories: those which act at the FO portion, such as oligomycin [Glaser et al] and N-(2,2,6,6-tetramethylpeperidyl-1-oxyl)-N-(cyclohexyl)carbo-diimide (NCCD) [Azzi et al], and those which act at the F1 portion, such as azide [Bald et al] and quinacrine mustard [Laikind and Allison].  It should be noted, however, that many inhibitors have multiple binding sites, and may inhibit both the FO and F1 portions.  An example is dicyclohexylcarbodiimide (DCCD) which binds covalently to both FO- and F1-sites [Hong and Pederson].")
										.<DescriptionSection> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Glaser, E., Norling, B., Kopecký, J., & Ernster, L. (1982). Comparison of the effects of oligomycin and dicyclohexylcarbodiimide on mitochondrial ATPase and related reactions. European Journal of Biochemistry, 121, 525-531.")
										.<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Azzi, A., Bragadin, M. A., Tamburro, A. M., & Santato, M. (1973). Site-directed spin labelling of the mitochondrial membrane. Synthesis and utilization of the adenosine triphosphatase inhibitor (N-(2, 2, 6, 6-tetramethyl-piperidyl-1-oxyl)-N’-(cyclohexyl)-carbodiimide). Journal of Biological Chemistry, 248, 5520-5526.")
										.<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Bald, D., Amano, T., Muneyuki, E., Pitard, B., Rigaud, J. L., Kruip, J., … Shibata, M. (1998). ATP synthesis by F0F1-ATP synthase independent of noncatalytic nucleotide binding sites and insensitive to azide inhibition. Journal of Biological Chemistry, 273, 865-870.")
										.<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Laikind, P. K., & Allison, W. S. (1983). Quinacrine mustard inactivates the bovine heart mitochondrial F1-ATPase with the modification of the beta subunit. Journal of Biological Chemistry, 258, 11700-11704.")
										.<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Hong, S., & Pedersen, P. L. (2008). ATP synthase and the actions of inhibitors utilized to study its roles in human health, disease, and other scientific areas. Microbiology and Molecular Biology Reviews, 72, 590-641.")
										.<Reference> makeItLive());
				
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie1);
				
				Effectopedia.EFFECTOPEDIA.setCurrentUser(STEVEN_AND_DAMIANO);
				Effect_DownstreamEffect organelle_effect1 = (Effect_DownstreamEffect) searchEffectByTitle("Reduced ATP formation");
				if (organelle_effect1 != null)
					{
						pathway.associateDownstream(organelle_effect1);
					}
				else
					{
						organelle_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
						organelle_effect1.setTitle("Reduced ATP formation");
						organelle_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organelle");
						organelle_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						organelle_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");
					}
				
				organelle_effect1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										organelle_effect1,
										dataSource,
										"Description",
										"In normally functioning mitochondria, the energy released from NADH oxidation is used to pump protons from the matrix of the mitochondria to the intermembrane space, thereby creating an electrochemical gradient which is used by ATP synthase (complex V) as the energy source for ATP production.\n\nXenobiotics may cause reduced mitochondrial ATP formation via interaction with a variety of mitochondrial targets including inhibition of individual complexes of the electron transport chain and inhibition of ATP synthase.\n\nATP levels are often measured at a cellular level using luciferin-luciferase based assays.  These assays involve the measurement of light produced by the reaction of ATP with added luciferase and D-luciferin.  Within certain limits, the light emitted is proportional to the ATP concentration.")
										.<DescriptionSection> makeItLive(), 0);
				
				Effect_DownstreamEffect organelle_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				organelle_effect2.setTitle("Hyperpolarized mitochondrial membrane potential");
				organelle_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organelle");
				organelle_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organelle_effect2
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										organelle_effect2,
										dataSource,
										"Description",
										"The inhibition of ATP synthase prevents dissipation of the proton gradient.  As a result, the electron transport chain is also impaired, since the energy released via oxidation of substrates and electron flow is not sufficient to pump more protons against the steep electrochemical gradient.  Consequently, mitochondrial membrane potential is either maintained or hyperpolarized immediately following inhibition of ATP synthase.\n\nTreatment of a variety of cell types with oligomycin has been shown to have either no effect on mitochondrial membrane potential or to lead to hyperpolarization.  For instance, in a study using cultured hepatocytes, treatment with 1 μg/mL oligomycin had no impact on mitochondrial membrane potential until the very onset of cell death [Nieminen et al].  Likewise, no change in membrane potential was observed following treatment of FL5.12 cells with 15 μM oligomycin [Marton et al].")
										.<DescriptionSection> makeItLive(), 0);
				organelle_effect2
						.getReferenceIDs()
						.add(
								new Reference(
										organelle_effect2,
										dataSource,
										"Nieminen, A-L., Saylor, A. K., Herman, B., & Lemasters, J. J. (1994). ATP depletion rather than mitochondrial depolarization mediates hepatocyte killing after metabolic inhibition. The American Journal of Physiology, 267, C67-74.")
										.<Reference> makeItLive());
				organelle_effect2
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Marton, A., Mihalik, R., Bratincsák, A., Adleff, V., Peták, I., Végh, M., … Krajcsi, P. (1997). Apoptotic cell death induced by inhibitors of energy conservation Bcl-2 inhibits apoptosis downstream of a fall of ATP level. European Journal of Biochemistry, 250, 467-475.")
										.<Reference> makeItLive());
				
				Link link = new Link_EffectToEffect(pathway, dataSource, mie1, organelle_effect1);
				link
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										link,
										dataSource,
										"Description",
										"Inhibition of ATP synthase by oligomycin at the FO portion of the complex prevents proton translocation across the inner membrane, from the intermembrane space to the mitochondrial matrix.  As a consequence, the rotor of ATP synthase is unable to turn and the means of driving the energetically unfavourable formation of ATP is lost.  Thus, ATP production via oxidative phosphorylation is prevented.\n\nA reduction in ATP synthesis via oxidative phosphorylation has been observed at a cellular level in several studies following exposure to the ATP synthase inhibitor oligomycin.  For instance, in studies using freshly isolated and cultured rat hepatocytes, treatment with concentrations of oligomycin of 0.1 μg/mL and above led to rapid deletion of ATP after 30 mins exposure [Nieminen et al].")
										.<DescriptionSection> makeItLive(), 0);
				link
						.getReferenceIDs()
						.add(
								new Reference(
										link,
										dataSource,
										"Nieminen, A-L., Saylor, A. K., Herman, B., & Lemasters, J. J. (1994). ATP depletion rather than mitochondrial depolarization mediates hepatocyte killing after metabolic inhibition. The American Journal of Physiology, 267, C67-74.")
										.<Reference> makeItLive());
				
				new Link_EffectToEffect(pathway, dataSource, mie1, organelle_effect2);
				
				Effect_DownstreamEffect organelle_effect3 = (Effect_DownstreamEffect) searchEffectByTitle("Reduced mitochondrial oxygen consumption");
				if (organelle_effect3 != null)
					pathway.associate(organelle_effect3);
				else
					{
						organelle_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
						organelle_effect3.setTitle("Reduced mitochondrial oxygen consumption");
						organelle_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organelle");
						organelle_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						organelle_effect3
								.getDescriptionIDs()
								.set(
										new DescriptionSection(
												organelle_effect3,
												dataSource,
												"Description",
												"In normally functioning mitochondria, electrons are carried along the electron transport chain (ETC) from a donor, such as nicotinamide adenine dinucleotide, to oxygen which is reduced to water.  This process results in the consumption of oxygen by mitochondria.\n\nThe inhibition of electron flow along the ETC prevents the conversion of oxygen to water, resulting in reduced mitochondrial oxygen consumption.  Xenobiotics may impair electron flow via multiple mechanisms, including the inhibition of individual complexes of the ETC and inhibition of ATP synthase leading to fixed or hyperpolarized membrane potential.\n\nOxygen consumption can be measured in isolated mitochondria or whole cells.  Traditionally, this was achieved using the Clarke electrode; however, alternative methods have now been developed.  One approach is to use a conjugated Pt-porphyrin probe with long-decay phosphorescence which is quenched by molecular oxygen [Hynes et al].  It is important to note that while a reduction in oxygen consumption in isolated mitochondria is indicative of mitochondrial dysfunction, this is not the case in whole cells since a dying cell will display a reduction in oxygen uptake regardless of mechanism.  To overcome this problem, pH sensors can be used to measure extracellular acidification.  Glycolysis is known to increase following mitochondrial impairment, thereby increasing the acidification rate, an effect not seen with general cytotoxicity.")
												.<DescriptionSection> makeItLive(), 0);
						organelle_effect3
								.getReferenceIDs()
								.add(
										new Reference(
												organelle_effect3,
												dataSource,
												"Hynes, J., Marroquin, L. D., Ogurtsov, V. I., Christiansen. K, N., Stevens, G. J,, Papkovsky, D. B., & Will, Y. (2006). Investigation of drug-induced mitochondrial toxicity using fluorescence-based oxygen-sensitive probes. Toxicological Sciences, 92, 186-200.")
												.<Reference> makeItLive());
						
					}
				
				Effect_DownstreamEffect organelle_effect4 = (Effect_DownstreamEffect) searchEffectByTitle("Increased mitochondrial reactive oxygen species formation");
				if (organelle_effect4 != null)
					pathway.associate(organelle_effect4);
				else
					{
						organelle_effect4 = new Effect_DownstreamEffect(pathway, dataSource);
						organelle_effect4.setTitle("Increased mitochondrial reactive oxygen species formation");
						organelle_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organelle");
						organelle_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						organelle_effect4
								.getDescriptionIDs()
								.set(
										new DescriptionSection(
												organelle_effect4,
												dataSource,
												"Description",
												"Mitochondria are believed to be a major source of reactive oxygen species (ROS) under normal physiological conditions.  It is thought that ROS generation is localized to complexes I and III, via electron leakage.  ‘Leaked’ electrons may react with molecular oxygen, which undergoes a one-electron reduction to yield superoxide [Turrens].\n\nXenobiotics may cause an increase in ROS formation via interaction with several mitochondrial targets including inhibition of individual complexes of the electron transport chain (ETC) and inhibition of ATP synthase.\n\nROS are usually measured in vitro using compounds such as dichlorofluorescin or dihydroethidium bromide, which yield a fluorescent signal upon oxidation.")
												.<DescriptionSection> makeItLive(), 0);
						organelle_effect4.getReferenceIDs().add(
								new Reference(organelle_effect4, dataSource, "Turrens, J. F. (1997). Superoxide production by the mitochondrial respiratory chain. Bioscience Reports, 17, 3-8.").<Reference> makeItLive());
					}
				
				link = new Link_EffectToEffect(pathway, dataSource, organelle_effect2, organelle_effect3);
				link
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										link,
										dataSource,
										"Description",
										"Inhibition of ATP synthase may lead to hyperpolarized mitochondrial membrane potential and impaired electron flow along the ETC.  As a result, oxygen consumption by the mitochondria may be reduced.\n\nTreatment of a pro-B-lymphocyte cell line (FL5.12) with 15 μM of the ATP synthase inhibitor oligomycin, led to fixed mitochondrial membrane potential and a significant reduction in oxygen uptake [Marton et al].")
										.<DescriptionSection> makeItLive(), 0);
				link
						.getReferenceIDs()
						.add(
								new Reference(
										link,
										dataSource,
										"Marton, A., Mihalik, R., Bratincsák, A., Adleff, V., Peták, I., Végh, M., … Krajcsi, P. (1997). Apoptotic cell death induced by inhibitors of energy conservation Bcl-2 inhibits apoptosis downstream of a fall of ATP level. European Journal of Biochemistry, 250, 467-475.")
										.<Reference> makeItLive());
				link = new Link_EffectToEffect(pathway, dataSource, organelle_effect2, organelle_effect4);
				link
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										link,
										dataSource,
										"Description",
										"Inhibition of ATP synthase may lead to hyperpolarized mitochondrial membrane potential which may in turn lead to increased ROS formation.\n\nAn increase in ROS following treatment of mouse neuronal cells with 10 μg/mL oligomycin for 2 h has been demonstrated [Liu and Schubert].")
										.<DescriptionSection> makeItLive(), 0);
				link.getReferenceIDs().add(
						new Reference(link, dataSource, "Liu, Y., & Schubert, D. R. (2009). The specificity of neuroprotection by antioxidants. Journal of Biomedical Science, 16, 98.").<Reference> makeItLive());
				
				Effect_DownstreamEffect cellular_effect1 = (Effect_DownstreamEffect) searchEffectByTitle("Apoptosis");
				if (cellular_effect1 != null)
					pathway.associate(cellular_effect1);
				else
					{
						cellular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
						cellular_effect1.setTitle("Apoptosis");
						cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
						cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						cellular_effect1
								.getDescriptionIDs()
								.set(
										new DescriptionSection(
												cellular_effect1,
												dataSource,
												"Description",
												"Apoptosis is the most common and best understood form of programmed cell death.  Cells undergoing apoptotic death display characteristic morphological changes, including blebbing, cell shrinkage, nuclear fragmentation, chromatin condensation and chromosomal DNA fragmentation.  Xenobiotic-induced apoptosis may be triggered by a wide variety of stimuli.  Among these, excessive oxidative stress and its downstream signalling cascades are believed to be a critical initiator of apoptotic death [Boelsterli].")
												.<DescriptionSection> makeItLive(), 0);
						cellular_effect1.getReferenceIDs().add(
								new Reference(cellular_effect1, dataSource, "Boelsterli, U. A. (2003) Mechanistic Toxicology: The Molecular Basis of How Chemicals Disrupt Biological Targets. Taylor & Francis, London.")
										.<Reference> makeItLive());
					}
				
				new Link_EffectToEffect(pathway, dataSource, organelle_effect4, cellular_effect1);

				pathway.updateEssentiality();
				return pathway;
			}
		
		public Pathway LhasaInhibitionEnzyme5AalphaReductaseType2(DataSource dataSource)
			{
				Effectopedia.EFFECTOPEDIA.setCurrentUser(DAMIANO);
				
				Pathway pathway = new Pathway(null, dataSource);
				pathway.setTitle("Inhibition of the enzyme 5-alpha reductase type 2");
				
				Initiator_ChemicalStructure chemical1 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical1.setTitle("Finasteride");
				chemical1
						.getStructure2DImage()
						.setValue(
								"https://apps.ideaconsult.net/ambit2/depict/cdk?search=%5BC%40H%5D12%5BC%40H%5D3%5BC%40%40H%5D%28%5BC%40%40%5D4%28%5BC%40%40H%5D%28CC3%29NC%28%3DO%29C%3DC4%29C%29CC%5BC%40%40%5D1%28%5BC%40H%5D%28CC2%29C%28%3DO%29NC%28C%29%28C%29C%29C&w=200&h=200&media=image/png");
				chemical1.getIdentification().setPropertyValue(0, "98319267");
				chemical1.getIdentification().setPropertyValue(1,
						"(4aR,4bS,6aS,7S,9aS,9bS,11aR)-4a,6a-Dimethyl-N-(2-methyl-2-propanyl)-2-oxo-2,4a,4b,5,6,6a,7,8,9,9a,9b,10,11,11a-tetradecahydro-1H-indeno[5,4-f]quinoline-7-carboxamide");
				chemical1.getIdentification().setPropertyValue(2, "[C@H]12[C@H]3[C@@H]([C@@]4([C@@H](CC3)NC(=O)C=C4)C)CC[C@@]1([C@H](CC2)C(=O)NC(C)(C)C)C");
				chemical1.getIdentification().setPropertyValue(3, "C23H36N2O2");
				chemical1.getProperties().setPropertyValue(0, "372.544");
				
				Effect_MolecularInitiatingEvent mie1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie1.setTitle("Inhibition of the enzyme 5-alpha reductase type 2");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				mie1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										mie1,
										dataSource,
										"Description",
										"Substrates for 5-alpha reductases are 3-keto, delta 4,5 C19/C21 steroids. The group '3-keto' refers to the oxygen-carbon double bond at carbon 3. 'Delta 4,5' refers to the double bond between carbons 4 and 5. The reaction involves a stereoselective and irreversible break of the double bond between C4 and C5 with the aid of the NADPH cofactor and the insertion of a hydride anion to the alpha face in C5 and a proton to the beta face in C4 and leads to the formation of the product that leaves the enzyme-NADP+ complex. The NADP+ departs last and the enzyme becomes free for further catalytic cycles. The reaction is the following: Substrate + NADPH + H+ = 5-alpha-substrate + NADP+. Inhibitors can be classified in three types: 1) competitive with the cofactor (NADPH) and substrate where the inhibitor binds the free enzyme, 2) competitive with the substrate where the inhibitor binds the enzyme-NADPH complex (e.g. 4-6-10 azasteroids) and 3) uncompetitive with the enzyme-NADP+ complex where the inhibitor binds the complex after the product leaves. Finasteride is competitive with the substrate. The 5-alpha reductase type 2 shows a narrow acidic pH optimum (pH 5.0 - 5.5) but in human intact cells it appears that this enzyme functions at a more neutral pH range (6.0-7.0). The affinity for testosterone is shown by Km = 0.004 - 1 µM [Azzouni et al].")
										.<DescriptionSection> makeItLive(), 0);
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource,
								"Azzouni, F., Godoy, A., Li, Y., & Mohler, J. (2012). The 5 alpha-reductase isozyme family: a review of basic biology and their role in human diseases. Advances in Urology, 530121.")
								.<Reference> makeItLive());
				
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie1);
				
				Effect_DownstreamEffect cellular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect1.setTitle("Decrease in dihydrotestosterone conversion from testosterone");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX,
						"indifferent gonad; prostate [stromal cells, basal epithelium]; epididymis [stromal cells]; prefrontal cortex in adult male rats");
				cellular_effect1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(cellular_effect1, dataSource, "Description", "In men finasteride decreases mean serum levels of dihydrotestosterone by 71% after 24 weeks of use [Azzouni].")
										.<DescriptionSection> makeItLive(),
								0);
				cellular_effect1.getReferenceIDs().add(
						new Reference(cellular_effect1, dataSource,
								"Azzouni, F., Godoy, A., Li, Y., & Mohler, J. (2012). The 5 alpha-reductase isozyme family: a review of basic biology and their role in human diseases. Advances in Urology, 530121.")
								.<Reference> makeItLive());
				
				new Link_EffectToEffect(pathway, dataSource, mie1, cellular_effect1);
				
				Effect_DownstreamEffect cellular_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect2.setTitle("Decrease in transcription of androgen-dependent genes");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX,
						"indifferent gonad; prostate [stromal cells, basal epithelium]; epididymis [stromal cells]; prefrontal cortex in adult male rats");
				cellular_effect2.getDescriptionIDs().set(new DescriptionSection(cellular_effect2, dataSource, "Description", "").<DescriptionSection> makeItLive(), 0);
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, cellular_effect2);
				
				Effect_DownstreamEffect organ_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect1.setTitle("Alteration of proliferation and differentiation of several androgen dependent tissues");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX,
						"indifferent gonad; prostate [stromal cells, basal epithelium]; epididymis [stromal cells]; prefrontal cortex in adult male rats");
				organ_effect1.getDescriptionIDs().set(new DescriptionSection(organ_effect1, dataSource, "Description", "").<DescriptionSection> makeItLive(), 0);
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect2, organ_effect1);
				
				Effect_DownstreamEffect individual_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect1.setTitle("Developmental toxicity by inhibition of the 5-alpha reductase enzyme");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX,
						"indifferent gonad; prostate [stromal cells, basal epithelium]; epididymis [stromal cells]; prefrontal cortex in adult male rats");
				individual_effect1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										individual_effect1,
										dataSource,
										"Description",
										"Internal and external genitalia malformations. In utero exposure to finasteride in rats at and above 0.1 mg/kg/day caused dose dependent effects in the male offspring including decreased ano-genital distance, nipple retention, ectopic testes, hypospadias, and a decrease in prostate gland weight [Bowman et al].  A study on fetal development in rhesus monkeys showed that when a high oral dose of finasteride (2 mg/kg) was administered, male foetuses presented external malformations of the genitalia [Prahalada et al].")
										.<DescriptionSection> makeItLive(), 0);
				individual_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										individual_effect1,
										dataSource,
										"Prahalada, S., Tarantal, A. F., Harris, G. S., Ellsworth, K. P., Clarke, A. P., Skiles, G. L., … Hendrickx, A. G. (1997). Effects of finasteride, a type 2 5-alpha reductase inhibitor, on fetal development in the rhesus monkey (Macaca mulatta). Teratology, 55, 119-31.")
										.<Reference> makeItLive());
				individual_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										individual_effect1,
										dataSource,
										"Bowman, C. J., Barlow, N. J., Turner, K. J., Wallace, D. G., & Foster, P. M. (2003). Effects of in utero exposure to finasteride on androgen-dependent reproductive development in the male rat. Toxicological Sciences, 74, 393-406.")
										.<Reference> makeItLive());
				
				new Link_EffectToEffect(pathway, dataSource, organ_effect1, individual_effect1);

				pathway.updateEssentiality();
				return pathway;
			}
		
		public Pathway LhasaAR_Antagonism(DataSource dataSource)
			{
				Effectopedia.EFFECTOPEDIA.setCurrentUser(DAMIANO);
				
				Pathway pathway = new Pathway(null, dataSource);
				pathway.setTitle("Antagonism of the androgen receptor");
				
				Initiator_ChemicalStructure chemical1 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical1.setTitle("Flutamide");
				chemical1.getStructure2DImage().setValue(
						"https://apps.ideaconsult.net/ambit2/depict/cdk?search=c1%28c%28ccc%28c1%29NC%28C%28C%29C%29%3DO%29%5BN%2B%5D%28%3DO%29%5BO-%5D%29C%28F%29%28F%29F&w=206&h=127&media=image/png");
				chemical1.getIdentification().setPropertyValue(0, "13311847");
				chemical1.getIdentification().setPropertyValue(1, "2-Methyl-N-[4-nitro-3-(trifluoromethyl)phenyl]-propanamide");
				chemical1.getIdentification().setPropertyValue(2, "c1(c(ccc(c1)NC(C(C)C)=O)[N+](=O)[O-])C(F)(F)F");
				chemical1.getIdentification().setPropertyValue(3, "C11H11F3N2O3");
				chemical1.getProperties().setPropertyValue(0, "276.212");
				
				Effect_MolecularInitiatingEvent mie1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie1.setTitle("Antagonism of the androgen receptor");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				mie1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										mie1,
										dataSource,
										"Description",
										"The androgen receptor (AR) is a member of the nuclear hormone receptor family, which also consists of mineral corticoid, glucocorticoid, oestrogen and progesterone receptors [Helsen et al]. These receptors are classified as class I receptors of the nuclear receptors ‘super family’ which includes thyroid hormones, retinoic acid and vitamin D receptors. Upon androgen binding to the AR there are two consecutive conformational changes of the receptor [Helsen et al]. From a proteolysis assay it has been found that a fragment of 35 kDa within the ligand binding domain region is initially protected by the ligand. Afterwards, a second conformational change leads to the protection of a smaller fragment of 29 kDa. In vitro assays using the HepG2 cell line showed that flutamide competitively inhibits DHT-mediated transactivation of the AR with a dissociation constant Kb of 1.07 x 10-8M [McIntyre et al]. ")
										.<DescriptionSection> makeItLive(), 0);
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Helsen, C., Kerkhofs, S., Clinckemalie, L., Spans, L., Laurent, M., Boonen, S., … Claessens, F. (2012). Structural basis for nuclear hormone receptor DNA binding. Molecular and Cellular Endocrinology, 348, 411-417.")
										.<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"McIntyre, B. S., Barlow, N. J., Wallace, D. G., Maness, S. C., Gaido, K. W., & Foster, P. M. (2000). Effects of in utero exposure to linuron on androgen-dependent reproductive development in the male Crl:CD(SD)BR rat. Toxicology and Applied Pharmacology, 167, 87-99.")
										.<Reference> makeItLive());
				
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie1);
				
				Effect_DownstreamEffect cellular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect1.setTitle("Decrease in transcription of androgen dependent genes");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX,
						"prostate [secretory, basal, smooth muscle and fibroblast cells]; seminal vesicles; epididymis; testicles [sertoli, germ, leydig, fibroblast, rete testis cells]; breast [acinar, duct cells]");
				cellular_effect1.getDescriptionIDs().set(new DescriptionSection(cellular_effect1, dataSource, "Description", "").<DescriptionSection> makeItLive(), 0);
				
				new Link_EffectToEffect(pathway, dataSource, mie1, cellular_effect1);
				
				Effect_DownstreamEffect cellular_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect2.setTitle("Repression of Wnt signalling");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX,
						"prostate [secretory, basal, smooth muscle and fibroblast cells]; seminal vesicles; epididymis; testicles [sertoli, germ, leydig, fibroblast, rete testis cells]; breast [acinar, duct cells]");
				cellular_effect2
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										cellular_effect2,
										dataSource,
										"Description",
										"It has been proposed that cells with high levels of Wnt activity undergo apoptosis, cells with moderate levels of Wnt activity maintain a proliferative state and cells with low levels of Wnt activity undergo differentiation [Mulholland et al]. The key mediator of the Wnt signalling pathway is the beta-catenin which is present in the membrane maintain cellular adhesion and a cytoplasmic pool which is regulated by an Axin destruction complex  phosphorylating beta-catenin to target it for degradation [Mulholland et al]. Wnt ligand binding to the frizzled receptor inhibits the destruction complex and therefore stabilises the cytoplasmic beta-catenin levels that translocate within the nucleus and associate with Tcf/LEF-1 transcription factors and activate Wnt target genes [Mulholland et al]. A transcription product is Axin2 that forms a secondary beta-catenin destruction complex and creates a negative feed-back for Wnt signalling. Thus, Axin2 can be seen as a biomarker for activation of Wnt signalling [Chen et al].  Treatment with flutamide of pregnant Sprague-Dawley rats leads to decreased expression of Axin2 in fibroblasts of the gubernacular core (the gubernaculum is the fetal structure that connects the testis with the scrotum and directs its course in its descent) of male fetuses which were positive for the androgen receptor [Chen et al]. Therefore flutamide treatment represses Wnt signalling [Chen et al].")
										.<DescriptionSection> makeItLive(), 0);
				cellular_effect2
						.getReferenceIDs()
						.add(
								new Reference(
										cellular_effect2,
										dataSource,
										"Chen, N., Harisis, G. N., Farmer, P., Buraundi, S., Sourial, M., Southwell, B. R., ... Hutson, J. M. (2011). Gone with the Wnt: the canonical Wnt signaling axis is present and androgen dependent in the rodent gubernaculum. Journal of Pediatric Surgery, 46, 2363-2369.")
										.<Reference> makeItLive());
				cellular_effect2
						.getReferenceIDs()
						.add(
								new Reference(
										cellular_effect2,
										dataSource,
										"McIntyre, B. S., Barlow, N. J., Wallace, D. G., Maness, S. C., Gaido, K. W., & Foster, P. M. (2000). Effects of in utero exposure to linuron on androgen-dependent reproductive development in the male Crl:CD(SD)BR rat. Toxicology and Applied Pharmacology, 167, 87-99.")
										.<Reference> makeItLive());
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, cellular_effect2);
				
				Effect_DownstreamEffect organ_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect1.setTitle("Alteration of cell proliferation and differentiation of androgen dependent organs");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX,
						"prostate [secretory, basal, smooth muscle and fibroblast cells]; seminal vesicles; epididymis; testicles [sertoli, germ, leydig, fibroblast, rete testis cells]; breast [acinar, duct cells]");
				organ_effect1.getDescriptionIDs().set(new DescriptionSection(organ_effect1, dataSource, "Description", "").<DescriptionSection> makeItLive(), 0);
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect2, organ_effect1);
				
				Effect_DownstreamEffect individual_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect1.setTitle("Developmental toxicity by antagonism of the androgen receptor");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX,
						"indifferent gonad; prostate [stromal cells, basal epithelium]; epididymis [stromal cells]; prefrontal cortex in adult male rats");
				individual_effect1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										individual_effect1,
										dataSource,
										"Description",
										"Flutamide induces feminisation of the external genitalia, nipple retention, alteration of androgen-dependent testicular descent and alteration of the anogenital distance. Flutamide exhibits a potent anti-androgenic activity and induces a dose-dependent decrease in the weight of accessory sex organs at doses of 1 mg/kg and above. Accessory sex organs more sensitive to flutamide at a 20 mg/kg dose are: seminal vesicles, ventral prostate, and Cowper’s glands. Flutamide administered for 15 days reduces accessory sex organs weights but does not affect testes weight. Flutamide increases serum testosterone levels [McIntyre et al (2000), McIntyre et al (2001)].")
										.<DescriptionSection> makeItLive(), 0);
				individual_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										individual_effect1,
										dataSource,
										"McIntyre, B. S., Barlow, N. J., & Foster, P. M. (2001). Androgen-mediated development in male rat offspring exposed to flutamide in utero: permanence and correlation of early postnatal changes in anogenital distance and nipple retention with malformations in androgen-dependent tissues. Toxicological Sciences, 62, 236-249.")
										.<Reference> makeItLive());
				individual_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										individual_effect1,
										dataSource,
										"McIntyre, B. S., Barlow, N. J., Wallace, D. G., Maness, S. C., Gaido, K. W., & Foster, P. M. (2000). Effects of in utero exposure to linuron on androgen-dependent reproductive development in the male Crl:CD(SD)BR rat. Toxicology and Applied Pharmacology, 167, 87-99.")
										.<Reference> makeItLive());
				
				new Link_EffectToEffect(pathway, dataSource, organ_effect1, individual_effect1);

				pathway.updateEssentiality();
				return pathway;
			}
		
		public Pathway LhasaAromatase_Inhibition(DataSource dataSource)
			{
				Effectopedia.EFFECTOPEDIA.setCurrentUser(DAMIANO);
				
				Pathway pathway = new Pathway(null, dataSource);
				pathway.setTitle("Aromatase inhibition");
				
				Initiator_ChemicalStructure chemical1 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical1.setTitle("Letrozole");
				chemical1.getStructure2DImage().setValue(
						"https://apps.ideaconsult.net/ambit2/depict/cdk?search=c1%28c%28ccc%28c1%29NC%28C%28C%29C%29%3DO%29%5BN%2B%5D%28%3DO%29%5BO-%5D%29C%28F%29%28F%29F&w=318&h=367&media=image/png");
				chemical1.getIdentification().setPropertyValue(0, "112809515");
				chemical1.getIdentification().setPropertyValue(1, "4,4'-(1H-1,2,4-Triazol-1-ylmethylene)dibenzonitrile");
				chemical1.getIdentification().setPropertyValue(2, "n1(C(c2ccc(cc2)C#N)c2ccc(cc2)C#N)ncnc1");
				chemical1.getIdentification().setPropertyValue(3, "C17H11N5");
				chemical1.getProperties().setPropertyValue(0, "285.303");
				chemical1.getProperties().setPropertyValue(2, "182.0");
				
				Effect_MolecularInitiatingEvent mie1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie1.setTitle("Inhibition of the aromatase enzyme");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										mie1,
										dataSource,
										"Description",
										"The aromatase enzyme is part of the cytochrome P450 superfamily and therefore is a heme-binding protein. This enzyme is located within the microsomes of oestrogen producing cells, has high substrate specificity and its activity is regulated by phosphorylation.  A complex with a NADPH-cytochrome P450 reductase allows the aromatase to catalyse the conversion of C19 androgens to C18 oestrogens. The placenta converts 16-alpha-hydroxy-dehydroepiandrosterone to oestriol, the ovary converts testosterone to oestradiol and the adipose tissue aromatizes androstenedione to oestradiol. Letrozole inhibits peripheral aromatase at doses of 0.5-2.5 mg per day by 98% [Boon et al, Furr].")
										.<DescriptionSection> makeItLive(), 0);
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource, "Boon, W. C., Chow, J. D., & Simpson, E. R. (2010). The multiple roles of estrogens and the enzyme aromatase. Progress in Brain Research, 181, 209-232.")
								.<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource, "Furr, B. J. (2005). Aromatase inhibitors. Basel, Switzerland: Birkhäuser Verlang.").<Reference> makeItLive());
				
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie1);
				
				Effect_DownstreamEffect cellular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect1.setTitle("Decrease in conversion of testosterone to oestradiol");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				cellular_effect1
						.getCoordinates()
						.setValue(
								DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX,
								"granulosa, corpus luteum, ovary, syncytotrophoblasts of the placenta, adipose mesenchymal tissue, skin fibroblasts, bone osteoclasts and osteoblasts, skeletal and smooth muscle, and vascular endothelium.");
				cellular_effect1.getDescriptionIDs().set(new DescriptionSection(cellular_effect1, dataSource, "Description", "").<DescriptionSection> makeItLive(), 0);
				
				new Link_EffectToEffect(pathway, dataSource, mie1, cellular_effect1);
				
				Effect_DownstreamEffect cellular_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect2.setTitle("Decrease in transcription of oestrogen receptor genes");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				cellular_effect2
						.getCoordinates()
						.setValue(
								DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX,
								"granulosa, corpus luteum, ovary, syncytotrophoblasts of the placenta, adipose mesenchymal tissue, skin fibroblasts, bone osteoclasts and osteoblasts, skeletal and smooth muscle, and vascular endothelium.");
				cellular_effect2.getDescriptionIDs().set(new DescriptionSection(cellular_effect2, dataSource, "Description", "").<DescriptionSection> makeItLive(), 0);
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, cellular_effect2);
				
				Effect_DownstreamEffect individual_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect1.setTitle("Developmental toxicity by inhibition of the aromatase enzyme with letrozole");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				individual_effect1
						.getCoordinates()
						.setValue(
								DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX,
								"granulosa, corpus luteum, ovary, syncytotrophoblasts of the placenta, adipose mesenchymal tissue, skin fibroblasts, bone osteoclasts and osteoblasts, skeletal and smooth muscle, and vascular endothelium.");
				individual_effect1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										individual_effect1,
										dataSource,
										"Description",
										"Letrozole administered to rats (between 6-16 gestation days) was embryotoxic at doses that were not maternally toxic, showing that the compound could be considered a developmental toxicant [Tiboni et al (2008)]. A significant dose-dependent increase in uterine lethality has been observed in rats exposed to doses lower than or equal to the recommended human therapeutic dose. It has also been found that letrozole increases the frequency of early and late resorptions and at the higher dose increases the ratio of fetal mortality. Letrozole also induced minor structural anomalies of the vertebral bodies [Tiboni et al (2008)]. From these findings it has been suggested that letrozole may not affect organogenesis or that if it does, it induces malformations incompatible with the continuation of the pregnancy [Tiboni et al (2008)]. Oestradiol cyclopentylpropionate (ECP) when administered concomitantly with letrozole gave protection against embryolethality (post-implantation pregnancy loss) at low doses more than at high ones [Tiboni et al (2009)]. Post-implantation pregnancy loss when lower doses of ECP were administered with letrozole was similar to the control group [Tiboni et al (2009)]. Moreover ECP co-administration did not prevent the skeletal anomalies caused by letrozole [Tiboni et al (2009)]. In baboons, letrozole increased significantly the number of pregnancies ending in spontaneous abortion but when it was co-administered with oestradiol the induced increase of miscarriage rate was suppressed [Tiboni et al (2009)]. Letrozole inhibits peripheral aromatase at doses of 0.5-2.5 mg per day by 98% [Tiboni et al (2008)].")
										.<DescriptionSection> makeItLive(), 0);
				individual_effect1.getReferenceIDs().add(
						new Reference(individual_effect1, dataSource,
								"Tiboni, G., Marotta, F., Castigliego, A. P., & C, R. (2009). Impact of estrogen replacement on letrozole-induced embryopathic effects. Human Reproduction, 24, 2688-2692.")
								.<Reference> makeItLive());
				individual_effect1.getReferenceIDs().add(
						new Reference(individual_effect1, dataSource,
								"Tiboni, G., Marotta, F., Rossi, C., & Giampietro, F. (2008). Effects of the aromatase inhibitor letrozole on in utero development in rats. Human Reproduction, 23,  1719-1723.")
								.<Reference> makeItLive());
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect2, individual_effect1);
				
				pathway.updateEssentiality();
    return pathway;
			}
		
		public Pathway LhasaAromatase_Inhibition_of_histone_deacetylases_class_I(DataSource dataSource)
			{
				Effectopedia.EFFECTOPEDIA.setCurrentUser(DAMIANO);
				
				Pathway pathway = new Pathway(null, dataSource);
				pathway.setTitle("Inhibition of histone deacetylases class I");
				
				Initiator_ChemicalStructure chemical1 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical1.setTitle("Valproic acid");
				chemical1.getStructure2DImage().setValue("https://apps.ideaconsult.net/ambit2/depict/cdk?search=C%28CCC%29%28CCC%29C%28O%29%3DO&w=318&h=367&media=image/png");
				chemical1.getIdentification().setPropertyValue(0, "99661");
				chemical1.getIdentification().setPropertyValue(1, "2-Propylpentanoic acid");
				chemical1.getIdentification().setPropertyValue(2, "C(CCC)(CCC)C(O)=O");
				chemical1.getIdentification().setPropertyValue(3, "C8H16O2");
				chemical1.getProperties().setPropertyValue(0, "144.211");
				chemical1.getProperties().setPropertyValue(2, "220.0");
				
				Effect_MolecularInitiatingEvent mie1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie1.setTitle("Inhibition of histone deacetylases (HDACs) class I");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										mie1,
										dataSource,
										"Description",
										"Valproic acid (VA) has been shown to selectively inhibit the catalytic activity of class I HDACs by establishing favourable interactions in the catalytic binding site. Histone deacetylase class I is located within the nucleus. [Khan et al, Detich et al]")
										.<DescriptionSection> makeItLive(), 0);
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Khan, N., Jeffers, M., Kumar, S., Hackett, C., Boldog, F., Khramtsov, N.,... Sehested, M. (2008). Determination of the class and isoform selectivity of small-molecule histone deacetylase inhibitors. Biochemical Journal, 409, 581-589.")
										.<Reference> makeItLive());
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource, "Detich, N., Bovenzi, V., & Szyf, M. (2003). Valproate induces replication-independent active DNA demethylation.  Journal of Biological Chemistry, 275, 86-92.")
								.<Reference> makeItLive());
				
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie1);
				
				Effect_DownstreamEffect organelle_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				organelle_effect1.setTitle("De-repression of the Wnt/beta-catenin signalling pathway");
				organelle_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organelle");
				organelle_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organelle_effect1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										organelle_effect1,
										dataSource,
										"Description",
										"The induction or augmentation of Wnt signalling by inhibition of HDACs class 1 may be caused by increased expression of Wnt ligands and their receptors, decreased expression of Wnt signalling inhibitors acting at the ligand level, modifications of Wnt ligands and their receptors, and increased cellular secretion of Wnt ligands or increased cell surface presentation of their receptors [Bordonaro et al].")
										.<DescriptionSection> makeItLive(), 0);
				organelle_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										organelle_effect1,
										dataSource,
										"Bordonaro, M., Lazarova, D. L., & Sartorelli, A. C. (2007). The activation of beta-catenin by Wnt signaling mediates the effects of histone deacetylase inhibitors. Experimental Cell Research, 313, 1652-1666.")
										.<Reference> makeItLive());
				
				new Link_EffectToEffect(pathway, dataSource, mie1, organelle_effect1);
				
				Effect_DownstreamEffect cellular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect1.setTitle("Accumulation of beta-catenin");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				cellular_effect1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										cellular_effect1,
										dataSource,
										"Description",
										"Wnt binding of Frizzled leads to phosphorylation of Dishevelled, which is a cytoplasmic mediator, and thus to inhibition of the multifunctional serine/threonine kinase, GSK3-beta. This in turn leads to the accumulation of beta catenin [Mulholland et al]. It has been shown in mouse Neuro2A cells that Valproic acid increases the expression of beta-catenin by activation of the canonical Wnt signalling pathway [Phiel et al].")
										.<DescriptionSection> makeItLive(), 0);
				cellular_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										cellular_effect1,
										dataSource,
										"Mulholland, D. J., Dedhar, S., Coetzee, G. A., & Nelson, C. C. (2005). Interaction of nuclear receptors with the Wnt/beta-catenin/Tcf signaling axis: Wnt you like to know? Endocrine Reviews, 26, 898-915.")
										.<Reference> makeItLive());
				cellular_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										cellular_effect1,
										dataSource,
										"Phiel, C. J., Zhang, F., Huang, E. Y., Guenther, M. G., Lazar, M. A., & Klein, P. S. (2001). Histone deacetylase is a direct target of valproic  acid, a potent anticonvulsant, mood stabilizer, and teratogen. Journal of Biological Chemistry, 276, 36734-36741.")
										.<Reference> makeItLive());
				
				new Link_EffectToEffect(pathway, dataSource, organelle_effect1, cellular_effect1);
				
				Effect_DownstreamEffect cellular_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect2.setTitle("Activation of Wnt target genes");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				cellular_effect2
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										cellular_effect2,
										dataSource,
										"Description",
										"Increased cellular levels and subsequent nuclear accumulation of beta-catenin results in its binding to the amino terminus of the high-mobility group binding protein, T cell factor (Tcf), and promotes its interaction with target DNA sequences (A/TA/TCAAAG), therefore promoting displacement of the Tcf repressors, Groucho and CtBP. This transcription complex activates Wnt target genes [Mulholland et al].")
										.<DescriptionSection> makeItLive(), 0);
				cellular_effect2
						.getReferenceIDs()
						.add(
								new Reference(
										cellular_effect2,
										dataSource,
										"Mulholland, D. J., Dedhar, S., Coetzee, G. A., & Nelson, C. C. (2005). Interaction of nuclear receptors with the Wnt/beta-catenin/Tcf signaling axis: Wnt you like to know? Endocrine Reviews, 26, 898-915.")
										.<Reference> makeItLive());
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, cellular_effect2);
				
				Effect_DownstreamEffect individual_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect1.setTitle("Valproic acid exposure developmental outcome");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				individual_effect1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										individual_effect1,
										dataSource,
										"Description",
										"Exposure of pregnant mice and rats to 75-500 mg/kg of valproic acid (VPA) resulted in increased embryotoxic and teratogenic effects in the corresponding foetuses. The adverse effects included: embryo-lethality and exencephaly (mice only), anterior neural tube defects, somite defects, limb abnormalities, heart malformations  and spina bifida (aperta and occulta) [Binkerd et al, Di Carlo, Ehlers et al (1992a), Ehlers et al (1992b), Narotsky et al, Menegola et al]. Trichostatin A (TSA) also caused similar reproductive defects in a mouse embryo study [Svensson et al]. Carboxylic acids have also been tested in Xenopus [Dawson et al].  Exposure of Xenopus embryos to 5mM VPA after the mid-blastula transition resulted in a significant loss of anterior structures and shortening of the anterior-posterior axis in 88% of the embryos [Dawson et al]. TSA also caused similar effects at 50nM and 100nM in 21% and 77% of the embryos respectively [Phiel et al].")
										.<DescriptionSection> makeItLive(), 0);
				individual_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										individual_effect1,
										dataSource,
										"Binkerd, P. E., Rowland, J. M., Nau, H., & Hendrickx, A. G. (1988). Evaluation of valproic acid (VPA) developmental  toxicity and pharmacokinetics in Sprague-Dawley rats. Fundamental and Applied Toxicology, 11, 485-493.")
										.<Reference> makeItLive());
				individual_effect1
						.getReferenceIDs()
						.add(
								new Reference(individual_effect1, dataSource,
										"Di Carlo, F. J. (1990). Structure-activity relationships (Sar) and structure-metabolism relationships (Smr) affecting the teratogenicity of carboxylic acids. Drug Metabolism Reviews, 22, 411-449.")
										.<Reference> makeItLive());
				individual_effect1.getReferenceIDs().add(
						new Reference(individual_effect1, dataSource, "Ehlers K., Stürje H., Merker H.J., Nau H. (1992a). Valproic acid-induced spina bifida: a mouse model. Teratology, 45, 145-154.")
								.<Reference> makeItLive());
				individual_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										individual_effect1,
										dataSource,
										"Ehlers K., Stürje H., Merker H.J., Nau H. (1992b). Spina bifida aperta induced by valproic  acid and by all-trans-retinoic acid in the mouse: distinct differences in morphology and periods of sensitivity. Teratology, 46, 117-130.")
										.<Reference> makeItLive());
				individual_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										individual_effect1,
										dataSource,
										"Narotsky M.G., Francis E.Z., Kavlock R.J. (1994). Developmental toxicity and structure-activity relationships of aliphatic acids, including dose-response assessment of valproic acid in mice and rats. Fundamental Applied Toxicology, 22, 251-265.")
										.<Reference> makeItLive());
				individual_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										individual_effect1,
										dataSource,
										"Menegola E., Broccia M.L., Nau H., Prati M., Ricolfi R., Giavini E. (1996). Teratogenic effects of sodium valproate in mice and rats at midgestation and at term. Teratogenesis Carcinogenesis Mutagenesis, 16, 97-108.")
										.<Reference> makeItLive());
				individual_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										individual_effect1,
										dataSource,
										"Svensson, K., Mattsson, R., James, T. C., Wentzel, P., Pilartz, M., MacLaughlin, J.,... Ohlsson, R. (1998). The paternal allele of the H19 gene is progressively silenced during early mouse development: the acetylation status of histones may be involved in the generation of variegated expression patterns. Development, 125, 61-69.")
										.<Reference> makeItLive());
				individual_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										individual_effect1,
										dataSource,
										"Dawson, D. A., Schultz, T. W., & Hunter, R. S. (1996). Developmental toxicity of carboxylic acids to Xenopus embryos: a quantitative structure-activity relationship and computer-automated structure evaluation. Teratogenesis, Carcinogenesis, and Mutagenesis, 16, 109-124.")
										.<Reference> makeItLive());
				individual_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										individual_effect1,
										dataSource,
										"Phiel, C. J., Zhang, F., Huang, E. Y., Guenther, M. G., Lazar, M. A., & Klein, P. S. (2001). Histone deacetylase is a direct target of valproic acid, a potent anticonvulsant, mood stabilizer, and teratogen. Journal of Biological Chemistry, 276, 36734-36741.")
										.<Reference> makeItLive());
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect2, individual_effect1);

				pathway.updateEssentiality();
				return pathway;
			}
		
		public Pathway LhasaBindingToNicotinicReceptors(DataSource dataSource)
			{
				Effectopedia.EFFECTOPEDIA.setCurrentUser(DAMIANO);
				
				Pathway pathway = new Pathway(null, dataSource);
				pathway.setTitle("Binding of nicotine to nicotinic receptors leading to adverse development");
				
				Initiator_ChemicalStructure chemical1 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical1.setTitle("Nicotine");
				chemical1.getStructure2DImage().setValue("https://apps.ideaconsult.net/ambit2/depict/cdk?search=[C@H]1%28c2cccnc2%29N%28CCC1%29C&w=318&h=367&media=image/png");
				chemical1.getIdentification().setPropertyValue(0, "54115");
				chemical1.getIdentification().setPropertyValue(1, "3-(1-Methyl-2-pyrrolidinyl)pyridine");
				chemical1.getIdentification().setPropertyValue(2, "[C@H]1(c2cccnc2)N(CCC1)C");
				chemical1.getIdentification().setPropertyValue(3, "C10H14N2");
				chemical1.getProperties().setPropertyValue(0, "162.232");
				chemical1.getProperties().setPropertyValue(2, "247.0");
				
				Effect_MolecularInitiatingEvent mie1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie1.setTitle("Binding of nicotine to nicotinic receptors alpha4Beta2 and alpha7 (agonism)");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX,
						"spinal cord, pons, medulla, cortex, subcortical forebrain, cerebellum, thalamus, hippocampal formation, basal ganglia");
				
				mie1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										mie1,
										dataSource,
										"Description",
										"Nicotinic acetylcholine receptors (nAChR) are pentameric ligand-gated cation channels which are widely distributed within the human and rodent brain during development [Dajas-Bailador and Wonnacott]. In humans, the mRNA of most nAChR subunits and their respective binding sites is expressed during the first trimester appearing with a caudal to rostral gradient [Araud et al, Millar and Gotti].")
										.<DescriptionSection> makeItLive(), 0);
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource,
								"Dajas-Bailador, F., & Wonnacott, S. (2004). Nicotinic acetylcholine receptors and the regulation of neuronal signalling. Trends in Pharmacological Sciences, 317-324.")
								.<Reference> makeItLive());
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource,
								"Araud, T., Wonnacott, S., & Bertrand, D. (2010). Associated proteins: The universal toolbox controlling ligand gated ion channel function. Biochemical Pharmacology, 160-169.")
								.<Reference> makeItLive());
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource, "Millar, N. S., & Gotti, C. (2009). Diversity of vertebrate nicotinic acetylcholine receptors. Neuropharmacology, 237-246.").<Reference> makeItLive());
				
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie1);
				
				Effect_DownstreamEffect cellular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect1.setTitle("Activation of Voltage operated calcium channels (pre-synaptic) and direct depolarisation (post-synaptic)");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX,
						"spinal cord, pons, medulla, cortex, subcortical forebrain, cerebellum, thalamus, hippocampal formation, basal ganglia");
				
				cellular_effect1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										cellular_effect1,
										dataSource,
										"Description",
										"The increase of intracellular Ca2+ induces the release of further Ca2+ from intracellular stores (calcium-induced calcium release (CICR)) by [Dajas-Bailador and Wonnacott] :\n1) activation of the phospholipase C (PLC) and the subsequent production of inositol (1,4,5)-triphosphate (IP3) that triggers Ca2+ release from the lumen of the endoplasmic reticulum (ER) by binding to its receptor (IP3R).\n2) binding (and activation) to specific sensor proteins (e.g. calmodulin) that consequently bind to the IP3R (located in the ER).\n3) activation of ryanodine receptors located in the ER. ")
										.<DescriptionSection> makeItLive(), 0);
				cellular_effect1.getReferenceIDs().add(
						new Reference(cellular_effect1, dataSource,
								"Dajas-Bailador, F., & Wonnacott, S. (2004). Nicotinic acetylcholine receptors and the regulation of neuronal signalling. Trends in Pharmacological Sciences, 25, 317-324.")
								.<Reference> makeItLive());
				
				new Link_EffectToEffect(pathway, dataSource, mie1, cellular_effect1);
				
				Effect_DownstreamEffect tissue_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				tissue_effect1.setTitle("Alteration of neurotrasmitter release such as dopamine, norepinephrine, serotonin");
				tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Central and Periferal Nervous system");
				tissue_effect1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										tissue_effect1,
										dataSource,
										"Description",
										"In vivo studies show that acute nicotine treatment stimulates dopamine release in monkeys, and in fetal rat forebrain, whilst chronic infusion towards the end of gestation, alters the level of brain dopamine, norepinephrine and their metabolites [Domino and Tsukada, Benwell et al].")
										.<DescriptionSection> makeItLive(), 0);
				tissue_effect1.getReferenceIDs().add(
						new Reference(tissue_effect1, dataSource, "Domino, E. F., & Tsukada, H. (2009). Nicotine sensitization of monkey striatal dopamine release. European Journal of Pharmacology, 607, 91-95.")
								.<Reference> makeItLive());
				tissue_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										tissue_effect1,
										dataSource,
										"Benwell, M. E., Balfour, D. J., & Birrell, C. E. (1995). Desensitization of the nicotine-induced mesolimbic dopamine responses during constant infusion with nicotine. British Journal of Pharmacology, 114, 454-460.")
										.<Reference> makeItLive());
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, tissue_effect1);
				
				Effect_DownstreamEffect organ_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect1.setTitle("Apoptosis");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Central and Periferal Nervous system, respiratory system, cardiovascular system, pancreas ");
				organ_effect1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										organ_effect1,
										dataSource,
										"Description",
										"Prenatal nicotine exposure damages the developing brain, induces apoptosis and reduces the number of neuronal cells. Cell number reduction and damage caused by nicotine increase in the postnatal period after exposure is discontinued. In rat pancreases the apoptosis process involved an increase in Fas and FasL soluble protein, Bcl2/Bax ratio, bax translocation into the mitochondria, cytochrome C release into the cytosol, mitochondrial swelling and active/inactive caspase [Bruin et al (2008a), Bruin et al (2008b), Somm et al].")
										.<DescriptionSection> makeItLive(), 0);
				organ_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										organ_effect1,
										dataSource,
										"Bruin, J. E., Gerstein, H. C., Morrison, K. M., & Holloway, A. C. (2008a). Increased pancreatic beta-cell apoptosis following fetal and neonatal exposure to nicotine is mediated via the mitochondria. Toxicological Sciences , 362-370.")
										.<Reference> makeItLive());
				organ_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										organ_effect1,
										dataSource,
										"Bruin, J. E., Petre, M. A., Raha, S., Morrison, K. M., Gerstein, H. C., & Holloway, A. C. (2008b). Fetal and neonatal nicotine exposure in Wistar rats causes progressive pancreatic mitochondrial damage and beta cell dysfunction. PloS one, 3, e3371")
										.<Reference> makeItLive());
				organ_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										organ_effect1,
										dataSource,
										"Somm, E., Schwitzgebel, V. M., Vauthay, D. M., Aubert, M. L., & Hüppi, P. S. (2009). Prenatal nicotine exposure and the programming of metabolic and cardiovascular disorders. Molecular and Cellular Endocrinology, 304, 69-77.")
										.<Reference> makeItLive());
				
				new Link_EffectToEffect(pathway, dataSource, tissue_effect1, organ_effect1);
				
				Effect_DownstreamEffect individual_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect1.setTitle("Nicotine exposure developmental outcome");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX,
						"Central and Periferal Nervous system, respiratory system, cardiovascular system, pancreas");
				individual_effect1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										individual_effect1,
										dataSource,
										"Description",
										"Nicotine causes brain damage, induces changes in either motor or reward functions, increases spontaneous apnea and vulnerability to death from hypoxic challenge during the first days after birth, increases the heart rate due to cholinergic enhancement of cardioinhibitory vagal neuronal disinhibition, alters airway structure and mechanics in fetal monkey inducing a decrease of pulmonary function, impairs alveolisation of the lungs in perinatally-treated rats, induces postnatal breathing and proximal airway obstruction in lambs, increases postnatal body weight and induces higher levels of body fat in the fetus at gestational day (GD) 20 [Slotkin, Bruin et al, Roy et al].")
										.<DescriptionSection> makeItLive(), 0);
				individual_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										individual_effect1,
										dataSource,
										"Slotkin, T. A. (2008). If nicotine is a developmental neurotoxicant in animal studies, dare we recommend nicotine replacement therapy in pregnant women and adolescents? Neurotoxicology and Teratology, 30, 1-19.")
										.<Reference> makeItLive());
				individual_effect1.getReferenceIDs().add(
						new Reference(individual_effect1, dataSource,
								"Bruin, J. E., Gerstein, H. C., & Holloway, A. C. (2010). Long-term consequences of fetal and neonatal nicotine exposure: a critical review. Toxicological Sciences, 116, 364-374.")
								.<Reference> makeItLive());
				individual_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										individual_effect1,
										dataSource,
										"Roy, T. S., Andrews, J. E., Seidler, F. J., & Slotkin, T. A. (1998). Nicotine evokes cell death in embryonic rat brain during neurulation. The Journal of pharmacology and experimental therapeutics, 287, 1136-1144.")
										.<Reference> makeItLive());
				
				new Link_EffectToEffect(pathway, dataSource, organ_effect1, individual_effect1);

				pathway.updateEssentiality();
				return pathway;
			}
		
		public Pathway LhasaRetinoicAcidSignalling(DataSource dataSource)
			{
				Effectopedia.EFFECTOPEDIA.setCurrentUser(DAMIANO);
				
				Pathway pathway = new Pathway(null, dataSource);
				pathway.setTitle("Retinoic acid signalling leading to developmental toxicity");
				
				Initiator_ChemicalStructure chemical1 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical1.setTitle("All-trans retinoic acid");
				chemical1.getStructure2DImage().setValue(
						"https://apps.ideaconsult.net/ambit2/depict/cdk?search=C%3D1%28C%28CCCC1C%29%28C%29C%29\\C%3DC\\C%28%3DC\\C%3DC\\C%28%3DC\\C%28O%29%3DO%29C%29C&w=318&h=367&media=image/png");
				chemical1.getIdentification().setPropertyValue(0, "302794");
				chemical1.getIdentification().setPropertyValue(1, "Retinoic acid");
				chemical1.getIdentification().setPropertyValue(2, "C=1(C(CCCC1C)(C)C)\\C=C\\C(=C\\C=C\\C(=C\\C(O)=O)C)C");
				chemical1.getIdentification().setPropertyValue(3, "C20H28O2");
				chemical1.getProperties().setPropertyValue(0, "300.435");
				chemical1.getProperties().setPropertyValue(2, "180.0");
				
				Effect_MolecularInitiatingEvent mie1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie1.setTitle("Binding to the retinoic acid receptor (agonism)");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie1
						.getCoordinates()
						.setValue(
								DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX,
								"brain, spinal cord, eye, inner ear, nasal structures, pituitary gland, palate, salivary gland, thyroid gland, trachea, lung, heart, stomach, intestine, liver, pancreas, kidney, gonad, skin, skeletal system, limbs");
				
				mie1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										mie1,
										dataSource,
										"Description",
										"The biological function of vitamin A is mediated by the association of all-trans retinoic acid with retinoic acid receptors (RARs) and retinoid X receptors (RXRs). RARs when activated form heterodimers with a RXR which in this case is silent and is not activated by a ligand. RXRs when activated form homodimers. Transcriptional activation of target genes occurs where upon binding to the ligand, a conformational change of the receptors complexed with corepressors leads to release of the corepressors and the recruitment of coactivators. RAR/RXR heterodimers bind to specific DNA elements in regulatory regions of target genes [Bastien and Rochette-Egly].")
										.<DescriptionSection> makeItLive(), 0);
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource, "Bastien, J., & Rochette-Egly, C. (2004). Nuclear retinoid receptors and the transcription of retinoid-target genes. Gene, 328, 1-16.").<Reference> makeItLive());
				
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie1);
				
				Effect_DownstreamEffect cellular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect1.setTitle("Transcription of retinoic acid regulated genes");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				cellular_effect1
						.getCoordinates()
						.setValue(
								DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX,
								"brain, spinal cord, eye, inner ear, nasal structures, pituitary gland, palate, salivary gland, thyroid gland, trachea, lung, heart, stomach, intestine, liver, pancreas, kidney, gonad, skin, skeletal system, limbs");
				cellular_effect1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										cellular_effect1,
										dataSource,
										"Description",
										"In mouse embryonic fibroblasts it has been found that retinoic acid receptors (RARs) bind to 354 loci. RARs bind directly to a DR2 element in the Ctgf promoter and mediate retinoic acid (RA) induction of its expression. RARs also bind to the gene encoding the TGF -beta-3 ligand that is potently activated by RA treatment. RARs also bind genes involved in other pathways of cell cycle regulation and transformation: tumor necrosis factor (ligand) superfamily member 13 (Tnfsf13), cyclin D1 (Ccnd1), metastasis marker nuclear protein 1 (Nupr1), growth factor Fgf18, tyrosine kinase Src, gene encoding Src-related Shc1(A) and cortactin (Cttn) which is a SRC substrate involved in metastasis [Delacroix et al].")
										.<DescriptionSection> makeItLive(), 0);
				cellular_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										cellular_effect1,
										dataSource,
										"Delacroix, L., Moutier, E., Altobelli, G., Legras, S., Poch, O., Choukrallah, M.-A., … Davidson, I. (2010). Cell-specific interaction of retinoic acid receptors with target genes in mouse embryonic fibroblasts and embryonic stem cells. Molecular and Cellular Biology, 30, 231-244.")
										.<Reference> makeItLive());
				
				new Link_EffectToEffect(pathway, dataSource, mie1, cellular_effect1);
				
				Effect_DownstreamEffect cellular_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect2.setTitle("Repression of the Wnt signalling pathway");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				cellular_effect2
						.getCoordinates()
						.setValue(
								DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX,
								"brain, spinal cord, eye, inner ear, nasal structures, pituitary gland, palate, salivary gland, thyroid gland, trachea, lung, heart, stomach, intestine, liver, pancreas, kidney, gonad, skin, skeletal system, limbs");
				cellular_effect2
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										cellular_effect2,
										dataSource,
										"Description",
										"It has been found that in Raldh1 -/-; Raldh3 -/- double mutant mice, loss of retinoic acid signalling leads to up-regulation of Wnt/beta-catenin signalling in mesenchymal ocular tissues showing that cross-talk between retinoic acid and Wnt signaling is required for eye morphogenesis [Kumar and Duester]. Retinoid signalling potently inhibits the Wnt/beta-catenin pathway in colon cancer cells, breast cancer cells and in mesenchymal cell cultures (undifferentiated cells) through physical interactions between beta-catenin and RAR-alpha [Kumar and Duester]. However, retinoid signalling stimulates the Wnt/beta-catenin pathway in chondrocyte cultures (differentiated cells) showing that the relationship between these two pathways is differentiation-dependent [Yasuhara et al]. Retinoid signalling represses the Wnt pathway in Xenopus blastula embryos leading to down-regulation of genes important for dorsal development [Li et al]. In this study retinoic acid repression occurs mainly through nuclear beta-catenin and not by interference with its stability.")
										.<DescriptionSection> makeItLive(), 0);
				cellular_effect2.getReferenceIDs().add(
						new Reference(cellular_effect2, dataSource,
								"Kumar, S., & Duester, G. (2010). Retinoic acid signaling in perioptic mesenchyme represses Wnt signaling via induction of Pitx2 and Dkk2. Developmental Biology, 340, 67-74.")
								.<Reference> makeItLive());
				cellular_effect2
						.getReferenceIDs()
						.add(
								new Reference(
										cellular_effect2,
										dataSource,
										"Yasuhara, R., Yuasa, T., Williams, J. A., Byers, S. W., Shah, S., Pacifici, M., . . . Enomoto-Iwamoto, M. (2010). Wnt/beta-catenin and retinoic acid receptor signaling pathways interact to regulate chondrocyte function and matrix turnover. Journal of Biological Chemistry, 285, 317-327.")
										.<Reference> makeItLive());
				cellular_effect2
						.getReferenceIDs()
						.add(
								new Reference(
										cellular_effect2,
										dataSource,
										"Li, S., Lou, X., Wang, J., Liu, B., Ma, L., Su, Z., & Ding, X. (2008). Retinoid signaling can repress blastula Wnt signaling and impair dorsal development in Xenopus embryo. Differentiation, 76, 897-907.")
										.<Reference> makeItLive());
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, cellular_effect2);
				
				Effect_DownstreamEffect individual_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect1.setTitle("Developmental toxicity of retinoic acid");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				individual_effect1
						.getCoordinates()
						.setValue(
								DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX,
								"brain, spinal cord, eye, inner ear, nasal structures, pituitary gland, palate, salivary gland, thyroid gland, trachea, lung, heart, stomach, intestine, liver, pancreas, kidney, gonad, skin, skeletal system, limbs");
				individual_effect1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										individual_effect1,
										dataSource,
										"Description",
										"Fetal malformations observed in Macaca monkeys after administration of 10 mg/kg/day of retinoic acid (RA, all trans configuration) between gestational days 24-35 were the following: hypoplasia of the facial cranium with misconfigured bones, hypertelorism and cleft palate, exophthalmos, and defects of the external ear [Biesalski]. Exencephaly, anophthalmia or maxillomandibular ankylosis observed in rodents after a single dose [Lohnes et al, Elmazar et al]  have not been observed in primates because these types of malformations require a repeated dose in order to manifest [Biesalski]. 13-cis RA is 4-8 times less teratogenic than all trans RA in comparison for the incidence of cleft palate and extremities malformation [Biesalski]. The dose of 13-cis RA that leads to cleft palate seems to be species-dependent: 150 mg/kg/day in rats and 10 mg/kg/day in rabbits [Biesalski]. Retinoic acid malformations that have been observed in humans are: microtia or anotia, faulty development of the facial cranial bones, cardiac defects, thymic hypoplasia and aplasia and malformation of the central nervous system [Biesalski].")
										.<DescriptionSection> makeItLive(), 0);
				individual_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										individual_effect1,
										dataSource,
										"Lohnes, D., Mark, M., Mendelsohn, C., Dollé, P., Dierich, A., Gorry, P., … Chambon, P. (1994). Function of the retinoic acid receptors (RARs) during development (I). Craniofacial and skeletal abnormalities in RAR double mutants. Development, 120, 2723-2748.")
										.<Reference> makeItLive());
				individual_effect1.getReferenceIDs().add(
						new Reference(individual_effect1, dataSource, "Biesalski, H. K. (1989). Comparative assessment of the toxicology of vitamin A and retinoids in man. Toxicology, 57, 117-161.")
								.<Reference> makeItLive());
				individual_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										individual_effect1,
										dataSource,
										"Elmazar, M. M., Rühl, R., Reichert, U., Shroot, B., & Nau, H. (1997). RARalpha-mediated teratogenicity in mice is potentiated by an RXR agonist and reduced by an RAR antagonist: dissection of retinoid receptor-induced pathways. Toxicology and Applied Pharmacology, 146, 21-28.")
										.<Reference> makeItLive());
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect2, individual_effect1);
				
				pathway.updateEssentiality();
				return pathway;
			}
		
		public void generateMIEs(DataSource dataSource)
			{
				Effect_MolecularInitiatingEvent mie;
				ContextDimension_Hierarchical dimension;
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Ah Receptor Binding");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "unknown");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Species "));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "fish");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Cytochrome Oxidase Binding");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Chloride-permeable ion channels");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "unknown");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Ligand-gated chloride channels");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "unknown");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("HMG-CoA Reductase Binding");
				mie.setKeyWords("Sterol Synethsis");
				mie.setGroup("Egosterol synthesis");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Kingdom"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Fungi");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("HMG-CoA Reductase Binding");
				mie.setKeyWords("Sterol Synethsis");
				mie.setGroup("Plant sterol synthesis");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Kingdom"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Plantae");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("HMG-CoA Reductase Binding");
				mie.setKeyWords("Sterol Synethsis");
				mie.setGroup("Cholesterol synthesis");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Kingdom"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Animalia");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Squalene Epoxidase Binding");
				mie.setKeyWords("Sterol Synethsis");
				mie.setGroup("Egosterol synthesis");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Kingdom"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Fungi");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Squalene Epoxidase Binding");
				mie.setKeyWords("Sterol Synethsis");
				mie.setGroup("Plant sterol synthesis");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Kingdom"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Plantae");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Squalene Epoxidase Binding");
				mie.setKeyWords("Sterol Synethsis");
				mie.setGroup("Cholesterol synthesis");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Kingdom"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Animalia");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("14-α-Demethylase (CYP51) Binding");
				mie.setKeyWords("DMI Fungicides");
				mie.setGroup("Egosterol synthesis");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Kingdom"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Fungi");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("5-Enolpyruvoylshikimate-3-phosphate synthases (EPSPS) Binding");
				mie.setKeyWords("Amino acid synthesis");
				mie.setGroup("EPSPS Inhibitor");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Kingdom"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Plantae, Bacteria");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Glutamine Synthase (GS) Binding");
				mie.setKeyWords("Glutamate-Nitrogen");
				mie.setGroup("GS Inhibitor");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Domain"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Bacteria, Archaea , Eukarya");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Acetolactate Synthase (ALS) Binding");
				mie.setKeyWords("Growth Inhibitor)");
				mie.setGroup("ALS Inhibitor");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Kingdom"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Plantae");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Butrylcholinesterases (BuChE) Binding");
				mie.setKeyWords("Blood PlasmaBrain");
				mie.setGroup("BuChE Inhibitor");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Kingdom"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Animalia");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Neuropathy Target Esterase Binding");
				mie.setKeyWords("Paralytic ataxia, delayed neurotoxicity");
				mie.setGroup("NTE Inhibitor");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Kingdom"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Animalia");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Carboxylesterase Binding");
				mie.setKeyWords("OPP Detoxification");
				mie.setGroup("CBE Inhibitor");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Kingdom"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Animalia");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Cytochrome B Binding");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Akonitase Binding");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Lycopene Cyclase Binding");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Phytoene Desaturase Binding");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Protoporphyrinogen Oxidase Binding");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Tubulin Binding");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Chitin Synthetase Binding");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Sunlight Absorption");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Electrophilic Protein Binding");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Electrophilic DNA Binding");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Electron Transport Shunt");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Free Radical Formation");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Oxidative Phosphorylation Uncoupling");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Polar Narosis");
				mie.setGroup("Narcosis");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "All");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Life"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "All life");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Non-Polar Narcosis");
				mie.setGroup("Narcosis");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "All");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Life"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "All life");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("5-Hydroxytryptamine Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Acetylcholine Receptor (Muscarinic) Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Adenosine Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Adrenoceptors Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Anaphylatoxin and Formyl Peptide Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Angiotensin Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Apelin Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Bile Acid Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Bombesin Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Bradykinin Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Calcitonin Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Calcium-Sensing Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Cannabinoid Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Chemokine Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Cholecystokinin Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Corticotropin-Releasing Factor Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Dopamine Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Endothelin Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Estrogen (G Protein Coupled) Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Free Fatty Acid Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Frizzled Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Gabab Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Galanin Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Ghrelin Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Glucagon Receptor Family Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Glycoprotein Hormone Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Gonadotrophin-Releasing Hormone Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("GPR18, GPR55 and GPR119 Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Histamine Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Hydroxycarboxylic Acid Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Kisspeptin, Neuropeptide FF, Prolactin-Releasing Peptide and Qrfp Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Leukotriene Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Lysophospholipid (LPA) Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Lysophospholipid (S1P) Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Melanin-Concentrating Hormone Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Melanocortin Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Melatonin Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Metabotropic Glutamate Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Motilin Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Neuromedin U Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Neuropeptide S Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Neuropeptide W/Neuropeptide B Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Neuropeptide Y Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Neurotensin Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Opioid Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Orexin Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("P2Y Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Parathyroid Hormone Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Platelet-Activating Factor Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Prokineticin Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Prostanoid Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Protease-Activated Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Relaxin Family Peptide Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Resolvin Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Somatostatin Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Tachykinin Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Thyrotropin-Releasing Hormone Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Trace Amine Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Urotensin Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Vasopressin and Oxytocin Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Vip and Pacap Receptor Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Voltage-Gated Ion Channels Binding");
				mie.setGroup("G Protein-Coupled Receptor Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Cyclic Nucleotide-Regulated Channels Binding");
				mie.setGroup("CatSper and Two-Pore channel Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Potassium Channels Binding");
				mie.setGroup("CatSper and Two-Pore channel Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Transient Receptor Potential Channels Binding");
				mie.setGroup("CatSper and Two-Pore channel Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Voltage-Gated Calcium Channels Binding");
				mie.setGroup("CatSper and Two-Pore channel Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Voltage-Gated Proton Channel Binding");
				mie.setGroup("CatSper and Two-Pore channel Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Voltage-Gated Sodium Channels Binding");
				mie.setGroup("CatSper and Two-Pore channel Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("5-HT3 Receptor Binding");
				mie.setGroup("Ligand-gated ion channel Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Acid-sensing (proton-gated) ion channels (ASICs) Binding");
				mie.setGroup("Ligand-gated ion channel Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Epithelial sodium channels (ENaC) Binding");
				mie.setGroup("Ligand-gated ion channel Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("GABAA Receptor Binding");
				mie.setGroup("Ligand-gated ion channel Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Glycine Receptor Binding");
				mie.setGroup("Ligand-gated ion channel Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Ionotropic glutamate Receptor Binding");
				mie.setGroup("Ligand-gated ion channel Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("IP3 receptor Binding");
				mie.setGroup("Ligand-gated ion channel Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Nicotinic acetylcholine Receptor Binding");
				mie.setGroup("Ligand-gated ion channel Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("P2X Receptor Binding");
				mie.setGroup("Ligand-gated ion channel Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Ryanodine receptor Binding");
				mie.setGroup("Ligand-gated ion channel Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("ZAC  Binding");
				mie.setGroup("Ligand-gated ion channel Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Aquaporin 0");
				mie.setKeyWords("water transport");
				mie.setGroup("Water channels");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "eye, lens fiber cells");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Borgnia M, Nielsen S, Engel A, Agre P: Cellular and molecular biology of aquaporin water channels. Annu Rev Biochem 68:425, 1999.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "deGroot BL, Grubmuller H: Water permeation across biological membranes: Mechanism and dynamics of aquaporin-1 and GlpF. Science 294:2353, 2001.")
								.<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "Hibuse T, Proc Nat Acad Sci (USA) 102:10993, 2005.").<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "King LS, Agre P: Pathophysiology of the aquaporin water channels. Annu Rev Physiol 58:619, 1998.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Knepper MA, Inoue T: Regulation of aquaporin-2 water channel trafficking by vasopressin. Curr Opinion Cell Biol 9:560, 1997.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Lee MD, King LS, Agre P: The aquaporin family of water channel proteins in clinical medicine. Medicine 76:141, 1997.").<Reference> makeItLive());
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Aquaporin 1");
				mie.setKeyWords("water transport");
				mie.setGroup("Water channels");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Red blood cells");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Borgnia M, Nielsen S, Engel A, Agre P: Cellular and molecular biology of aquaporin water channels. Annu Rev Biochem 68:425, 1999.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "deGroot BL, Grubmuller H: Water permeation across biological membranes: Mechanism and dynamics of aquaporin-1 and GlpF. Science 294:2353, 2001.")
								.<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "Hibuse T, Proc Nat Acad Sci (USA) 102:10993, 2005.").<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "King LS, Agre P: Pathophysiology of the aquaporin water channels. Annu Rev Physiol 58:619, 1998.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Knepper MA, Inoue T: Regulation of aquaporin-2 water channel trafficking by vasopressin. Curr Opinion Cell Biol 9:560, 1997.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Lee MD, King LS, Agre P: The aquaporin family of water channel proteins in clinical medicine. Medicine 76:141, 1997.").<Reference> makeItLive());
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Aquaporin 1");
				mie.setKeyWords("water transport");
				mie.setGroup("Water channels");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Kidney: proximal tubule");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Borgnia M, Nielsen S, Engel A, Agre P: Cellular and molecular biology of aquaporin water channels. Annu Rev Biochem 68:425, 1999.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "deGroot BL, Grubmuller H: Water permeation across biological membranes: Mechanism and dynamics of aquaporin-1 and GlpF. Science 294:2353, 2001.")
								.<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "Hibuse T, Proc Nat Acad Sci (USA) 102:10993, 2005.").<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "King LS, Agre P: Pathophysiology of the aquaporin water channels. Annu Rev Physiol 58:619, 1998.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Knepper MA, Inoue T: Regulation of aquaporin-2 water channel trafficking by vasopressin. Curr Opinion Cell Biol 9:560, 1997.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Lee MD, King LS, Agre P: The aquaporin family of water channel proteins in clinical medicine. Medicine 76:141, 1997.").<Reference> makeItLive());
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Aquaporin 1");
				mie.setKeyWords("water transport");
				mie.setGroup("Water channels");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Eye: ciliary epithelium");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Borgnia M, Nielsen S, Engel A, Agre P: Cellular and molecular biology of aquaporin water channels. Annu Rev Biochem 68:425, 1999.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "deGroot BL, Grubmuller H: Water permeation across biological membranes: Mechanism and dynamics of aquaporin-1 and GlpF. Science 294:2353, 2001.")
								.<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "Hibuse T, Proc Nat Acad Sci (USA) 102:10993, 2005.").<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "King LS, Agre P: Pathophysiology of the aquaporin water channels. Annu Rev Physiol 58:619, 1998.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Knepper MA, Inoue T: Regulation of aquaporin-2 water channel trafficking by vasopressin. Curr Opinion Cell Biol 9:560, 1997.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Lee MD, King LS, Agre P: The aquaporin family of water channel proteins in clinical medicine. Medicine 76:141, 1997.").<Reference> makeItLive());
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Aquaporin 1");
				mie.setKeyWords("water transport");
				mie.setGroup("Water channels");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Brain: choriod plexus");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Borgnia M, Nielsen S, Engel A, Agre P: Cellular and molecular biology of aquaporin water channels. Annu Rev Biochem 68:425, 1999.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "deGroot BL, Grubmuller H: Water permeation across biological membranes: Mechanism and dynamics of aquaporin-1 and GlpF. Science 294:2353, 2001.")
								.<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "Hibuse T, Proc Nat Acad Sci (USA) 102:10993, 2005.").<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "King LS, Agre P: Pathophysiology of the aquaporin water channels. Annu Rev Physiol 58:619, 1998.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Knepper MA, Inoue T: Regulation of aquaporin-2 water channel trafficking by vasopressin. Curr Opinion Cell Biol 9:560, 1997.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Lee MD, King LS, Agre P: The aquaporin family of water channel proteins in clinical medicine. Medicine 76:141, 1997.").<Reference> makeItLive());
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Aquaporin 1");
				mie.setKeyWords("water transport");
				mie.setGroup("Water channels");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Lung: alveolar epithelial cells");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Borgnia M, Nielsen S, Engel A, Agre P: Cellular and molecular biology of aquaporin water channels. Annu Rev Biochem 68:425, 1999.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "deGroot BL, Grubmuller H: Water permeation across biological membranes: Mechanism and dynamics of aquaporin-1 and GlpF. Science 294:2353, 2001.")
								.<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "Hibuse T, Proc Nat Acad Sci (USA) 102:10993, 2005.").<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "King LS, Agre P: Pathophysiology of the aquaporin water channels. Annu Rev Physiol 58:619, 1998.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Knepper MA, Inoue T: Regulation of aquaporin-2 water channel trafficking by vasopressin. Curr Opinion Cell Biol 9:560, 1997.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Lee MD, King LS, Agre P: The aquaporin family of water channel proteins in clinical medicine. Medicine 76:141, 1997.").<Reference> makeItLive());
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Aquaporin 2");
				mie.setKeyWords("water transport");
				mie.setGroup("Water channels");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Kidney: collecting ducts");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Borgnia M, Nielsen S, Engel A, Agre P: Cellular and molecular biology of aquaporin water channels. Annu Rev Biochem 68:425, 1999.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "deGroot BL, Grubmuller H: Water permeation across biological membranes: Mechanism and dynamics of aquaporin-1 and GlpF. Science 294:2353, 2001.")
								.<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "Hibuse T, Proc Nat Acad Sci (USA) 102:10993, 2005.").<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "King LS, Agre P: Pathophysiology of the aquaporin water channels. Annu Rev Physiol 58:619, 1998.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Knepper MA, Inoue T: Regulation of aquaporin-2 water channel trafficking by vasopressin. Curr Opinion Cell Biol 9:560, 1997.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Lee MD, King LS, Agre P: The aquaporin family of water channel proteins in clinical medicine. Medicine 76:141, 1997.").<Reference> makeItLive());
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Aquaporin 3");
				mie.setKeyWords("water transport");
				mie.setGroup("Water channels");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Kidney: collecting ducts");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Borgnia M, Nielsen S, Engel A, Agre P: Cellular and molecular biology of aquaporin water channels. Annu Rev Biochem 68:425, 1999.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "deGroot BL, Grubmuller H: Water permeation across biological membranes: Mechanism and dynamics of aquaporin-1 and GlpF. Science 294:2353, 2001.")
								.<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "Hibuse T, Proc Nat Acad Sci (USA) 102:10993, 2005.").<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "King LS, Agre P: Pathophysiology of the aquaporin water channels. Annu Rev Physiol 58:619, 1998.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Knepper MA, Inoue T: Regulation of aquaporin-2 water channel trafficking by vasopressin. Curr Opinion Cell Biol 9:560, 1997.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Lee MD, King LS, Agre P: The aquaporin family of water channel proteins in clinical medicine. Medicine 76:141, 1997.").<Reference> makeItLive());
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Aquaporin 3");
				mie.setKeyWords("water transport");
				mie.setGroup("Water channels");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Trachea: epithelial cells");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Borgnia M, Nielsen S, Engel A, Agre P: Cellular and molecular biology of aquaporin water channels. Annu Rev Biochem 68:425, 1999.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "deGroot BL, Grubmuller H: Water permeation across biological membranes: Mechanism and dynamics of aquaporin-1 and GlpF. Science 294:2353, 2001.")
								.<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "Hibuse T, Proc Nat Acad Sci (USA) 102:10993, 2005.").<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "King LS, Agre P: Pathophysiology of the aquaporin water channels. Annu Rev Physiol 58:619, 1998.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Knepper MA, Inoue T: Regulation of aquaporin-2 water channel trafficking by vasopressin. Curr Opinion Cell Biol 9:560, 1997.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Lee MD, King LS, Agre P: The aquaporin family of water channel proteins in clinical medicine. Medicine 76:141, 1997.").<Reference> makeItLive());
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Aquaporin 4");
				mie.setKeyWords("water transport");
				mie.setGroup("Water channels");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Kidney: collecting ducts");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Borgnia M, Nielsen S, Engel A, Agre P: Cellular and molecular biology of aquaporin water channels. Annu Rev Biochem 68:425, 1999.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "deGroot BL, Grubmuller H: Water permeation across biological membranes: Mechanism and dynamics of aquaporin-1 and GlpF. Science 294:2353, 2001.")
								.<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "Hibuse T, Proc Nat Acad Sci (USA) 102:10993, 2005.").<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "King LS, Agre P: Pathophysiology of the aquaporin water channels. Annu Rev Physiol 58:619, 1998.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Knepper MA, Inoue T: Regulation of aquaporin-2 water channel trafficking by vasopressin. Curr Opinion Cell Biol 9:560, 1997.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Lee MD, King LS, Agre P: The aquaporin family of water channel proteins in clinical medicine. Medicine 76:141, 1997.").<Reference> makeItLive());
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Aquaporin 4");
				mie.setKeyWords("water transport");
				mie.setGroup("Water channels");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Brain: ependymal cells");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Borgnia M, Nielsen S, Engel A, Agre P: Cellular and molecular biology of aquaporin water channels. Annu Rev Biochem 68:425, 1999.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "deGroot BL, Grubmuller H: Water permeation across biological membranes: Mechanism and dynamics of aquaporin-1 and GlpF. Science 294:2353, 2001.")
								.<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "Hibuse T, Proc Nat Acad Sci (USA) 102:10993, 2005.").<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "King LS, Agre P: Pathophysiology of the aquaporin water channels. Annu Rev Physiol 58:619, 1998.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Knepper MA, Inoue T: Regulation of aquaporin-2 water channel trafficking by vasopressin. Curr Opinion Cell Biol 9:560, 1997.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Lee MD, King LS, Agre P: The aquaporin family of water channel proteins in clinical medicine. Medicine 76:141, 1997.").<Reference> makeItLive());
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Aquaporin 4");
				mie.setKeyWords("water transport");
				mie.setGroup("Water channels");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Brain: hypothalamus");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Borgnia M, Nielsen S, Engel A, Agre P: Cellular and molecular biology of aquaporin water channels. Annu Rev Biochem 68:425, 1999.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "deGroot BL, Grubmuller H: Water permeation across biological membranes: Mechanism and dynamics of aquaporin-1 and GlpF. Science 294:2353, 2001.")
								.<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "Hibuse T, Proc Nat Acad Sci (USA) 102:10993, 2005.").<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "King LS, Agre P: Pathophysiology of the aquaporin water channels. Annu Rev Physiol 58:619, 1998.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Knepper MA, Inoue T: Regulation of aquaporin-2 water channel trafficking by vasopressin. Curr Opinion Cell Biol 9:560, 1997.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Lee MD, King LS, Agre P: The aquaporin family of water channel proteins in clinical medicine. Medicine 76:141, 1997.").<Reference> makeItLive());
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Aquaporin 4");
				mie.setKeyWords("water transport");
				mie.setGroup("Water channels");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Lung: bronchial epithelium");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Borgnia M, Nielsen S, Engel A, Agre P: Cellular and molecular biology of aquaporin water channels. Annu Rev Biochem 68:425, 1999.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "deGroot BL, Grubmuller H: Water permeation across biological membranes: Mechanism and dynamics of aquaporin-1 and GlpF. Science 294:2353, 2001.")
								.<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "Hibuse T, Proc Nat Acad Sci (USA) 102:10993, 2005.").<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "King LS, Agre P: Pathophysiology of the aquaporin water channels. Annu Rev Physiol 58:619, 1998.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Knepper MA, Inoue T: Regulation of aquaporin-2 water channel trafficking by vasopressin. Curr Opinion Cell Biol 9:560, 1997.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Lee MD, King LS, Agre P: The aquaporin family of water channel proteins in clinical medicine. Medicine 76:141, 1997.").<Reference> makeItLive());
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Aquaporin 5");
				mie.setKeyWords("water transport");
				mie.setGroup("Water channels");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Salivary glands");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Borgnia M, Nielsen S, Engel A, Agre P: Cellular and molecular biology of aquaporin water channels. Annu Rev Biochem 68:425, 1999.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "deGroot BL, Grubmuller H: Water permeation across biological membranes: Mechanism and dynamics of aquaporin-1 and GlpF. Science 294:2353, 2001.")
								.<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "Hibuse T, Proc Nat Acad Sci (USA) 102:10993, 2005.").<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "King LS, Agre P: Pathophysiology of the aquaporin water channels. Annu Rev Physiol 58:619, 1998.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Knepper MA, Inoue T: Regulation of aquaporin-2 water channel trafficking by vasopressin. Curr Opinion Cell Biol 9:560, 1997.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Lee MD, King LS, Agre P: The aquaporin family of water channel proteins in clinical medicine. Medicine 76:141, 1997.").<Reference> makeItLive());
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Aquaporin 5");
				mie.setKeyWords("water transport");
				mie.setGroup("Water channels");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Lacrimal glands");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Borgnia M, Nielsen S, Engel A, Agre P: Cellular and molecular biology of aquaporin water channels. Annu Rev Biochem 68:425, 1999.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "deGroot BL, Grubmuller H: Water permeation across biological membranes: Mechanism and dynamics of aquaporin-1 and GlpF. Science 294:2353, 2001.")
								.<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "Hibuse T, Proc Nat Acad Sci (USA) 102:10993, 2005.").<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "King LS, Agre P: Pathophysiology of the aquaporin water channels. Annu Rev Physiol 58:619, 1998.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Knepper MA, Inoue T: Regulation of aquaporin-2 water channel trafficking by vasopressin. Curr Opinion Cell Biol 9:560, 1997.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Lee MD, King LS, Agre P: The aquaporin family of water channel proteins in clinical medicine. Medicine 76:141, 1997.").<Reference> makeItLive());
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Aquaporin 6");
				mie.setKeyWords("water transport");
				mie.setGroup("Water channels");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Kidney");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Borgnia M, Nielsen S, Engel A, Agre P: Cellular and molecular biology of aquaporin water channels. Annu Rev Biochem 68:425, 1999.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "deGroot BL, Grubmuller H: Water permeation across biological membranes: Mechanism and dynamics of aquaporin-1 and GlpF. Science 294:2353, 2001.")
								.<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "Hibuse T, Proc Nat Acad Sci (USA) 102:10993, 2005.").<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "King LS, Agre P: Pathophysiology of the aquaporin water channels. Annu Rev Physiol 58:619, 1998.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Knepper MA, Inoue T: Regulation of aquaporin-2 water channel trafficking by vasopressin. Curr Opinion Cell Biol 9:560, 1997.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Lee MD, King LS, Agre P: The aquaporin family of water channel proteins in clinical medicine. Medicine 76:141, 1997.").<Reference> makeItLive());
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Aquaporin 7");
				mie.setKeyWords("water transport");
				mie.setGroup("Water channels");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Fat cells");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Borgnia M, Nielsen S, Engel A, Agre P: Cellular and molecular biology of aquaporin water channels. Annu Rev Biochem 68:425, 1999.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "deGroot BL, Grubmuller H: Water permeation across biological membranes: Mechanism and dynamics of aquaporin-1 and GlpF. Science 294:2353, 2001.")
								.<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "Hibuse T, Proc Nat Acad Sci (USA) 102:10993, 2005.").<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "King LS, Agre P: Pathophysiology of the aquaporin water channels. Annu Rev Physiol 58:619, 1998.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Knepper MA, Inoue T: Regulation of aquaporin-2 water channel trafficking by vasopressin. Curr Opinion Cell Biol 9:560, 1997.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Lee MD, King LS, Agre P: The aquaporin family of water channel proteins in clinical medicine. Medicine 76:141, 1997.").<Reference> makeItLive());
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Aquaporin 7");
				mie.setKeyWords("water transport");
				mie.setGroup("Water channels");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Testis and sperm");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Borgnia M, Nielsen S, Engel A, Agre P: Cellular and molecular biology of aquaporin water channels. Annu Rev Biochem 68:425, 1999.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "deGroot BL, Grubmuller H: Water permeation across biological membranes: Mechanism and dynamics of aquaporin-1 and GlpF. Science 294:2353, 2001.")
								.<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "Hibuse T, Proc Nat Acad Sci (USA) 102:10993, 2005.").<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "King LS, Agre P: Pathophysiology of the aquaporin water channels. Annu Rev Physiol 58:619, 1998.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Knepper MA, Inoue T: Regulation of aquaporin-2 water channel trafficking by vasopressin. Curr Opinion Cell Biol 9:560, 1997.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Lee MD, King LS, Agre P: The aquaporin family of water channel proteins in clinical medicine. Medicine 76:141, 1997.").<Reference> makeItLive());
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Aquaporin 8");
				mie.setKeyWords("water transport");
				mie.setGroup("Water channels");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Testis, pancreas, liver, others");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Borgnia M, Nielsen S, Engel A, Agre P: Cellular and molecular biology of aquaporin water channels. Annu Rev Biochem 68:425, 1999.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "deGroot BL, Grubmuller H: Water permeation across biological membranes: Mechanism and dynamics of aquaporin-1 and GlpF. Science 294:2353, 2001.")
								.<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "Hibuse T, Proc Nat Acad Sci (USA) 102:10993, 2005.").<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "King LS, Agre P: Pathophysiology of the aquaporin water channels. Annu Rev Physiol 58:619, 1998.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Knepper MA, Inoue T: Regulation of aquaporin-2 water channel trafficking by vasopressin. Curr Opinion Cell Biol 9:560, 1997.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Lee MD, King LS, Agre P: The aquaporin family of water channel proteins in clinical medicine. Medicine 76:141, 1997.").<Reference> makeItLive());
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Aquaporin 9");
				mie.setKeyWords("water transport");
				mie.setGroup("Water channels");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "Leukocytes");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Borgnia M, Nielsen S, Engel A, Agre P: Cellular and molecular biology of aquaporin water channels. Annu Rev Biochem 68:425, 1999.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "deGroot BL, Grubmuller H: Water permeation across biological membranes: Mechanism and dynamics of aquaporin-1 and GlpF. Science 294:2353, 2001.")
								.<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "Hibuse T, Proc Nat Acad Sci (USA) 102:10993, 2005.").<Reference> makeItLive());
				mie.getReferenceIDs().add(new Reference(mie, dataSource, "King LS, Agre P: Pathophysiology of the aquaporin water channels. Annu Rev Physiol 58:619, 1998.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Knepper MA, Inoue T: Regulation of aquaporin-2 water channel trafficking by vasopressin. Curr Opinion Cell Biol 9:560, 1997.").<Reference> makeItLive());
				mie.getReferenceIDs().add(
						new Reference(mie, dataSource, "Lee MD, King LS, Agre P: The aquaporin family of water channel proteins in clinical medicine. Medicine 76:141, 1997.").<Reference> makeItLive());
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Plasma membrane intrinsic protein 1");
				mie.setKeyWords("water transport");
				mie.setGroup("Water channels, Plasma membrane Intrinsic Protein (PIP) ");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "plasma membrane of plant cells");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				dimension = (ContextDimension_Hierarchical) mie.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				mie.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Kingdom"));
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Plantae");
				mie
						.getReferenceIDs()
						.add(
								new Reference(
										mie,
										dataSource,
										"Vandeleur RK, Mayo G, Shelden MC, Gilliham M, Kaiser BN, Tyerman SD. The role of plasma membrane intrinsic protein aquaporins in water transport through roots: diurnal and drought stress responses reveal different strategies between isohydric and anisohydric cultivars of grapevine. Plant Physiol. 2009 Jan;149(1):445-60. doi: 10.1104/pp.108.128645. Epub 2008 Nov 5.")
										.<Reference> makeItLive());
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Chloride channels");
				mie.setGroup("Ion channel  Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Connexins and Pannexins");
				mie.setGroup("Ion channel  Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Sodium leak channel, non-selective");
				mie.setGroup("Ion channel  Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Nuclear hormone receptors");
				mie.setGroup("Ion channel  Disruptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("1A. Thyroid Hormone Receptor Binding");
				mie.setGroup("Nuclear Hormone Type 2 Receptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("1C. Peroxisome proliferator-activated Receptor Binding");
				mie.setGroup("Nuclear Hormone Receptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("1H. Liver X receptor-like Receptor Binding");
				mie.setGroup("Nuclear Hormone Receptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("1I. Vitamin D receptor-like Receptor Binding");
				mie.setGroup("Nuclear Hormone Receptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Steroid hormone");
				mie.setGroup("Nuclear Hormone Receptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Retinoic Acid  Receptor Binding");
				mie.setGroup("Nuclear Hormone Type 2 Receptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie = DefaultEffectopediaObjects.DEFAULT_MIE.clone(null, dataSource);
				mie.setTitle("Retinoid X  Receptor Binding");
				mie.setGroup("Nuclear Hormone Type 2 Receptors");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
			}
		
		public void generateAdversOutcomesAndEndpoints(DataSource dataSource)
			{
				Effect_AdverseOutcome ao;
				Effect_Endpoint e;
				ContextDimension_Hierarchical dimension;
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Increased Mortality");
				e.setGroup("Acute Lethality ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Shortened Lifespan");
				
				e.setGroup("Acute Lethality ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				ao = DefaultEffectopediaObjects.DEFAULT_ADVERSE_OUTCOME.clone(null, dataSource);
				ao.setTitle("Irritation/Corrosivity");
				ao.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				ao.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Membrane/Tissue Damage");
				e.setGroup("Irritation/Corrosivity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				ao = DefaultEffectopediaObjects.DEFAULT_ADVERSE_OUTCOME.clone(null, dataSource);
				ao.setTitle("Sensitization");
				ao.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				ao.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Hypersensitivity");
				e.setGroup("Sensitization");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				ao = DefaultEffectopediaObjects.DEFAULT_ADVERSE_OUTCOME.clone(null, dataSource);
				ao.setTitle("Growth Impairment");
				ao.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				ao.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Age at Weaning");
				e.setGroup("Growth Impairment");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Altered Molt Stages");
				e.setGroup("Growth Impairment");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Wet Weight");
				e.setGroup("Growth Impairment");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Length");
				e.setGroup("Growth Impairment");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Time to Maturity");
				e.setGroup("Growth Impairment");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Time to First Mating");
				e.setGroup("Growth Impairment");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Gonad-somatic Index");
				e.setGroup("Growth Impairment");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				ao = DefaultEffectopediaObjects.DEFAULT_ADVERSE_OUTCOME.clone(null, dataSource);
				ao.setTitle("Reproduction Impairment ");
				ao.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				ao.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Fecundity");
				e.setGroup("Reproduction Impairment ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Fertility");
				e.setGroup("Reproduction Impairment ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Size at Birth");
				e.setGroup("Reproduction Impairment ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Number of Live Births");
				e.setGroup("Reproduction Impairment ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Resorptions");
				e.setGroup("Reproduction Impairment ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Clutch Size");
				e.setGroup("Reproduction Impairment ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Shell Thickness");
				e.setGroup("Reproduction Impairment ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Hatch Success");
				e.setGroup("Reproduction Impairment ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Number of Spawns");
				e.setGroup("Reproduction Impairment ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Juvenile Production");
				e.setGroup("Reproduction Impairment ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Egg Production");
				e.setGroup("Reproduction Impairment ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Egg Quality");
				e.setGroup("Reproduction Impairment ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Juvenile Survival");
				e.setGroup("Reproduction Impairment ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Lactation ");
				e.setGroup("Reproduction Impairment ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Sex Ratios");
				e.setGroup("Reproduction Impairment ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				ao = DefaultEffectopediaObjects.DEFAULT_ADVERSE_OUTCOME.clone(null, dataSource);
				ao.setTitle("Altered Development");
				ao.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				ao.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Teratogenicity");
				e.setGroup("Altered Development");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Delayed Metamorphosis");
				e.setGroup("Altered Development");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Juvenile Development");
				e.setGroup("Altered Development");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Pipping Success");
				e.setGroup("Altered Development");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Impaired Regeneration");
				e.setGroup("Altered Development");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Emergence Rate");
				e.setGroup("Altered Development");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Predator Avoidance");
				e.setGroup("Behavioral Impairment");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Predation Success");
				e.setGroup("Behavioral Impairment");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Feeding Behavior");
				e.setGroup("Behavioral Impairment");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Swimming Activity");
				e.setGroup("Behavioral Impairment");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Straying Imprinting ");
				e.setGroup("Behavioral Impairment");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Web Building");
				e.setGroup("Behavioral Impairment");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Nest Building");
				e.setGroup("Behavioral Impairment");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Burrowing Activity");
				e.setGroup("Behavioral Impairment");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Mating Behavior");
				e.setGroup("Behavioral Impairment");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Territoriality");
				e.setGroup("Behavioral Impairment");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Courtship ");
				e.setGroup("Behavioral Impairment");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Parental care");
				e.setGroup("Behavioral Impairment");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Nest Defense");
				e.setGroup("Behavioral Impairment");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Secondary sex Characteristics");
				e.setGroup("Behavioral Impairment");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				ao = DefaultEffectopediaObjects.DEFAULT_ADVERSE_OUTCOME.clone(null, dataSource);
				ao.setTitle("Acute Toxicity");
				ao.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "0");
				ao.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "0");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("LC50 Acute Toxicity to Daphnia");
				e.setGroup("Acute Toxicity to Daphnia");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TIME_TO_EFFECT.DIMENSION_INDEX, "24");
				e.getCoordinates().setUnit(DefaultEffectopediaObjects.DEFAULT_TIME_TO_EFFECT.DIMENSION_INDEX, "hours");
				dimension = (ContextDimension_Hierarchical) e.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				e.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Genus"));
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Daphnia");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("EC50 Growth Impairment to Algae");
				e.setGroup("Acute Toxicity to Algae");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "asexual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TIME_TO_EFFECT.DIMENSION_INDEX, "24");
				e.getCoordinates().setUnit(DefaultEffectopediaObjects.DEFAULT_TIME_TO_EFFECT.DIMENSION_INDEX, "hours");
				dimension = (ContextDimension_Hierarchical) e.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				e.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Phylum"));
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Algae");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("LC50 Acute Toxicity to Small Fish");
				e.setGroup("Acute Toxicity to Fish");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TIME_TO_EFFECT.DIMENSION_INDEX, "96");
				e.getCoordinates().setUnit(DefaultEffectopediaObjects.DEFAULT_TIME_TO_EFFECT.DIMENSION_INDEX, "hours");
				dimension = (ContextDimension_Hierarchical) e.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				e.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Phylum"));
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Fish");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("LC50 Acute Toxicity to Earhworms");
				e.setGroup("Acute Toxicity to Earhworms");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "hermaphrodite");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TIME_TO_EFFECT.DIMENSION_INDEX, "48");
				e.getCoordinates().setUnit(DefaultEffectopediaObjects.DEFAULT_TIME_TO_EFFECT.DIMENSION_INDEX, "hours");
				dimension = (ContextDimension_Hierarchical) e.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				e.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Order"));
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Megadrilacea");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("LD50 Avian Acute Oral Toxicity");
				e.setGroup("Acute Toxicity to Birds");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TIME_TO_EFFECT.DIMENSION_INDEX, "3");
				e.getCoordinates().setUnit(DefaultEffectopediaObjects.DEFAULT_TIME_TO_EFFECT.DIMENSION_INDEX, "days");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");
				dimension = (ContextDimension_Hierarchical) e.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				e.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Aves");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("LC50");
				e.setGroup("Acute Inhalation Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "0");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "0");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("LD50");
				e.setGroup("Acute Oral Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "0");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "0");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("LD50");
				e.setGroup("Acute Dermal Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "0");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "0");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Skin Corrosion");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "0");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "0");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Photosensitisation");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "0");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "0");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Photomutagenicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "0");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "0");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Photocarcinogenicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "0");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "0");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Acute photoirritation");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "0");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "0");
				
				ao = DefaultEffectopediaObjects.DEFAULT_ADVERSE_OUTCOME.clone(null, dataSource);
				ao.setTitle("Chronic Toxicity");
				ao.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "0");
				ao.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "0");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Nitrogen transformation activity of soil microorganisms");
				e.setGroup("Long-term Toxicity to Soil Microorganisms");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "population");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "long-term");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("NOEC Long-term Toxicity to Fish ");
				e.setGroup("Long-term Toxicity to Fish");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "long-term");
				dimension = (ContextDimension_Hierarchical) e.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				e.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Phylum"));
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Fish");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("EC50 Reduction of Seedling Emergence and Growth");
				e.setGroup("Long-term Toxicity to Higher Plants");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TIME_TO_EFFECT.DIMENSION_INDEX, "14");
				e.getCoordinates().setUnit(DefaultEffectopediaObjects.DEFAULT_TIME_TO_EFFECT.DIMENSION_INDEX, " days");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "long-term");
				dimension = (ContextDimension_Hierarchical) e.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				e.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Kingdom"));
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Plantae");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Skin Irritation");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "0");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "0");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Skin Sensitisation");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "0");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "0");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Respiratory Sensitisation");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "0");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "0");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Eye irritation");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "0");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "0");
				
				ao = DefaultEffectopediaObjects.DEFAULT_ADVERSE_OUTCOME.clone(null, dataSource);
				ao.setTitle("Mutagenicity");
				ao.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				ao.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "unspecified");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Revertants colonies per plate");
				e.setGroup("Mutagenicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "asexual");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TIME_TO_EFFECT.DIMENSION_INDEX, "3");
				e.getCoordinates().setUnit(DefaultEffectopediaObjects.DEFAULT_TIME_TO_EFFECT.DIMENSION_INDEX, " days");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");
				dimension = (ContextDimension_Hierarchical) e.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				e.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Domain"));
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Bacteria");
				
				ao = DefaultEffectopediaObjects.DEFAULT_ADVERSE_OUTCOME.clone(null, dataSource);
				ao.setTitle("Carcionogenicity");
				ao.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "0");
				ao.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "0");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Tumor incidents");
				e.setGroup("Carcionogenicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "0");
				dimension = (ContextDimension_Hierarchical) e.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				e.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Kingdom"));
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Animalia");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Neoplasia");
				e.setGroup("Carcionogenicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "0");
				dimension = (ContextDimension_Hierarchical) e.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				e.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Kingdom"));
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Animalia");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Fibrosis");
				e.setGroup("Repeated dose toxicity, Liver Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "liver");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TIME_TO_EFFECT.DIMENSION_INDEX, "28");
				e.getCoordinates().setUnit(DefaultEffectopediaObjects.DEFAULT_TIME_TO_EFFECT.DIMENSION_INDEX, " days");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "long-term");
				dimension = (ContextDimension_Hierarchical) e.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				e.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Fibrosis");
				e.setGroup("Repeated dose toxicity, Kidney Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "kidney");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TIME_TO_EFFECT.DIMENSION_INDEX, "90");
				e.getCoordinates().setUnit(DefaultEffectopediaObjects.DEFAULT_TIME_TO_EFFECT.DIMENSION_INDEX, " days");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "long-term");
				dimension = (ContextDimension_Hierarchical) e.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				e.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Fibrosis");
				e.setGroup("Repeated dose toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "lymph nodes");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TIME_TO_EFFECT.DIMENSION_INDEX, "12");
				e.getCoordinates().setUnit(DefaultEffectopediaObjects.DEFAULT_TIME_TO_EFFECT.DIMENSION_INDEX, "months");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "long-term");
				dimension = (ContextDimension_Hierarchical) e.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				e.getCoordinates().setCategory(dimension.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Class"));
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, "Mammalia");
				
				ao = DefaultEffectopediaObjects.DEFAULT_ADVERSE_OUTCOME.clone(null, dataSource);
				ao.setTitle("Organ Toxicity");
				ao.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				ao.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Pigmentation");
				e.setGroup("Liver Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "liver");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Fibrosis");
				e.setGroup("Liver Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "liver");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Inflamation");
				e.setGroup("Liver Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "liver");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Eosinophilia");
				e.setGroup("Liver Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "liver");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Swelling");
				e.setGroup("Liver Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "liver");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Steatosis");
				e.setGroup("Liver Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "liver");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Hypertrophy");
				e.setGroup("Liver Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "liver");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Granuloma");
				e.setGroup("Liver Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "liver");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Sinusodal obstruction syndrome");
				e.setGroup("Liver Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "liver");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Cholestasis");
				e.setGroup("Liver Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "liver");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Phospholipidosis");
				e.setGroup("Liver Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "liver");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Bile duct inflammation");
				e.setGroup("Liver Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "liver");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Vacuolisation");
				e.setGroup("Liver Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "liver");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Glycogen depletion/deposit");
				e.setGroup("Liver Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "liver");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Bile Accumulation");
				e.setGroup("Liver Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "liver");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Neoplastic lesion");
				e.setGroup("Liver Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "liver");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Cirrhosis");
				e.setGroup("Liver Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "liver");
				
				e = DefaultEffectopediaObjects.DEFAULT_ENDPOINT.clone(null, dataSource);
				e.setTitle("Cholangitis");
				e.setGroup("Liver Toxicity");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "liver");
			}
		
		public Pathway LhasaPatch(DataSource dataSource)
			{
				Pathway pathway = searchPathwayByTitle("Inhibition of complexes I-IV");
				
				Effectopedia.EFFECTOPEDIA.setCurrentUser(User.IQF);
				
				Effect_MolecularInitiatingEvent mie1 = (Effect_MolecularInitiatingEvent) searchEffectByTitle("Inhibition of complex I");
				mie1.setTitle("Binding to complex I");
				Effect_MolecularInitiatingEvent mie2 = (Effect_MolecularInitiatingEvent) searchEffectByTitle("Inhibition of complex II");
				mie2.setTitle("Binding to complex II");
				Effect_MolecularInitiatingEvent mie3 = (Effect_MolecularInitiatingEvent) searchEffectByTitle("Inhibition of complex III");
				mie3.setTitle("Binding to complex III");
				Effect_MolecularInitiatingEvent mie4 = (Effect_MolecularInitiatingEvent) searchEffectByTitle("Inhibition of complex IV");
				mie4.setTitle("Binding to complex IV");
				
				Effect_DownstreamEffect de = (Effect_DownstreamEffect) searchEffectByTitle("Inhibition of the electron transport chain");
				
				Effectopedia.EFFECTOPEDIA.setCurrentUser(STEVEN_AND_DAMIANO);
				Effect_DownstreamEffect e1 = new Effect_DownstreamEffect(pathway, dataSource);
				e1.setTitle("Inhibition of complex I");
				e1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				e1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e1.getDescriptionIDs()
						.set(
								new DescriptionSection(
										e1,
										dataSource,
										"Background",
										"The electron transport chain (ETC) is composed of four complexes (I-IV) embedded in the mitochondrial inner membrane and plays a crucial role in the production of ATP by mitochondria.  Electrons are received from a donor such as nicotinamide adenine dinucleotide (NADH) and then dropped through a series of intermediate stages of increasing redox potential to their final destination, oxygen.  The energy released from NADH oxidation is used to pump protons from the matrix of the mitochondria to the intermembrane space, thereby creating an electrochemical gradient which is used by ATP synthase as the energy source for ATP production.\n\nComplex I, also known as NADH-ubiquinone oxidoreductase, is the first of the four complexes of the ETC.  The complex receives 2 electrons from NADH and passes each electron along a chain of Fe-S clusters where they are ultimately delivered, via terminal cluster N2, to ubiquinone which is reduced to ubiquinol.  For each electron pair donated to ubiquinone, complex I pumps 4 protons from the matrix to the intermembrane space [Scheffler].")
										.<DescriptionSection> makeItLive(), 0);
				e1.getDescriptionIDs()
						.add(
								new DescriptionSection(
										e1,
										dataSource,
										"Description",
										"A large number of structurally diverse compounds of synthetic and natural origin are known to inhibit the activity of complex I [Esposti].  Rotenone is perhaps the best known of these, although other well-known inhibitors include the antibiotic piericidin A and N-methyl-4-phenylpyridinium (MPP+) which is the active metabolite of N-methyl-4-phenyl-1,2,3,6-tetrahydropyridine.\n\nThe mechanism of complex I inhibition is not well understood.  It appears that the vast majority of known inhibitors, including rotenone, act at the ubiquinone reduction site, preventing the transfer of electrons from the terminal Fe-S cluster, N2, to ubiquinone [Scheffler].  However, many authors believe that complex I has multiple ubiquinone reduction sites and as a result may present multiple sites for inhibitors [Gluck et al].  This may, in part, explain the structural diversity of compounds capable of inhibiting the complex.")
										.<DescriptionSection> makeItLive());
				e1.getReferenceIDs().add(new Reference(e1, dataSource, "Scheffler, I. E. (2008). Mitochondria, Second Edition. Hoboken, NJ: John Wiley & Sons.").<Reference> makeItLive());
				e1.getReferenceIDs().add(
						new Reference(e1, dataSource, "Esposti, M. D. (1998). Inhibitors of NADH−ubiquinone reductase: an overview. Biochimica et Biophysica Acta, 1364, 222-235.").<Reference> makeItLive());
				e1.getReferenceIDs()
						.add(
								new Reference(
										e1,
										dataSource,
										"Gluck, M. R., Krueger, M. J., Ramsay, R. R., Sablin, S. O., Singer T. P., & Nicklas, W. J. (1994). Characterization of the inhibitory mechanism of 1-methyl-4-phenylpyridinium and 4-phenylpyridine analogs in inner membrane preparations. Journal of Biological Chemistry, 269, 3167-3174.")
										.<Reference> makeItLive());
				
				Effectopedia.EFFECTOPEDIA.setCurrentUser(DAMIANO);
				Effect_DownstreamEffect e2 = new Effect_DownstreamEffect(pathway, dataSource);
				e2.setTitle("Inhibition of complex II");
				e2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				e2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e2.getDescriptionIDs()
						.set(
								new DescriptionSection(
										e2,
										dataSource,
										"Background",
										"The electron transport chain (ETC) is composed of four complexes (I-IV) embedded in the mitochondrial inner membrane and plays a crucial role in the production of ATP by mitochondria.  Electrons are received from a donor such as nicotinamide adenine dinucleotide (NADH) and then dropped through a series of intermediate stages of increasing redox potential to their final destination, oxygen.  The energy released from NADH oxidation is used to pump protons from the matrix of the mitochondria to the intermembrane space, thereby creating an electrochemical gradient which is used by ATP synthase as the energy source for ATP production.\n\nComplex II, more commonly referred to as succinate:ubiquinone reductase (SQR), plays a role in both the ETC and the Krebs cycle.  It is responsible for the oxidation of succinate to fumarate and the reduction of ubiquinone to ubiquinol.  Structurally, SQR is the simplest of the complexes of the ETC, consisting of only four subunits [Scheffler].  These are a flavoprotein, an iron-sulfur protein (containing the 3 centres: [2Fe-2S], [3Fe-4S] and [4Fe-4S]) and two small membrane anchor subunits.  The complex contributes to electron flow to oxygen but is not directly involved in proton translocation.")
										.<DescriptionSection> makeItLive(), 0);
				e2.getDescriptionIDs()
						.add(
								new DescriptionSection(
										e2,
										dataSource,
										"Description",
										"Xenobiotic-induced inhibition of complex II is not well understood and may proceed via multiple mechanisms involving different sites within the complex.  Inhibitors of complex II can be broadly divided into two classes: those that bind in the succinate pocket and those which bind in the ubiquinone pocket.  The former class includes various dicarboxylic acids and analogues.  Examples include oxaloacetate [Wojtovich et al], fluorinated analogues of succinate and fumarate such as 2-fluorosuccinate and difluorofumarate [Tober et al], as well as the nitro-analogue of malonate, 3-nitro propionic acid (3-NPA) [Sun et al].  Examples of ubiquinone type inhibitors include carboxin, thenoyltrifluoroacetone (TTFA) and various atpenins, such as harzianopyridone [Miyadera et al].")
										.<DescriptionSection> makeItLive());
				e2.getReferenceIDs().add(new Reference(e2, dataSource, "Scheffler, I. E. (2008). Mitochondria, Second Edition. Hoboken, NJ: John Wiley & Sons.").<Reference> makeItLive());
				e2.getReferenceIDs().add(
						new Reference(e2, dataSource, "Wojtovich, L., Wojtovich, A. B., and Ernster, L. (1969). The inhibition of succinate dehydrogenase by oxaloacetate. Biochimica et Biophysica Acta, 191, 10-21.")
								.<Reference> makeItLive());
				e2.getReferenceIDs()
						.add(
								new Reference(
										e2,
										dataSource,
										"Tober, C. L., Nicholls, P., & Brodie, J. D. (1970). Metabolism and enzymology of fluorosuccinic acids: II. Substrate and inhibitor effects with soluble succinate dehydrogenase. Archives of Biochemistry and Biophysics, 138, 506-514.")
										.<Reference> makeItLive());
				e2.getReferenceIDs().add(
						new Reference(e2, dataSource,
								"Sun, F., Huo, X., Zhai, Y., Wang, A., Xu, J., Su, D., … Rao, Z. (2005). Crystal structure of mitochondrial respiratory membrane protein complex II. Cell, 121, 1043-1057.")
								.<Reference> makeItLive());
				e2.getReferenceIDs()
						.add(
								new Reference(
										e2,
										dataSource,
										"Miyadera, H., Shiomi, K., Ui, H., Yamaguchi, Y., Masuma, R., Tomoda, H., … Omura, S. (2003). Atpenins, potent and specific inhibitors of mitochondrial complex II (succinate-ubiquinone oxidoreductase). Proceedings of the National Academy of Sciences of the United States of America, 100, 473-477.")
										.<Reference> makeItLive());
				
				Effect_DownstreamEffect e3 = new Effect_DownstreamEffect(pathway, dataSource);
				e3.setTitle("Inhibition of complex III");
				e3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				e3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e3.getDescriptionIDs()
						.set(
								new DescriptionSection(
										e3,
										dataSource,
										"Background",
										"The electron transport chain (ETC) is composed of four complexes (I-IV) embedded in the mitochondrial inner membrane and plays a crucial role in the production of ATP by mitochondria.  Electrons are received from a donor such as nicotinamide adenine dinucleotide (NADH) and then dropped through a series of intermediate stages of increasing redox potential to their final destination, oxygen.  The energy released from NADH oxidation is used to pump protons from the matrix of the mitochondria to the intermembrane space, thereby creating an electrochemical gradient which is used by ATP synthase as the energy source for ATP production.\n\nComplex III, also known as ubiquinone-cytochrome c oxidoreductase or the bc1 complex, is a homodimeric and multi-subunit protein.  Three subunits form the functional core of the enzyme and these contain prosthetic groups which are responsible for the catalytic activity.  The cytochrome b subunit has two b-type hemes (bL and bH), the cytochrome c subunit has one c-type heme (c1) and the Reiske subunit contains a 2Fe-2S cluster.  Overall, the complex catalyses the oxidation of ubiquinol to ubiquinone and the reduction of cytochrome c3+ to cytochrome c2+.  In the process, 4 protons are pumped to the intermembrane space [Scheffler].")
										.<DescriptionSection> makeItLive(), 0);
				e3.getDescriptionIDs()
						.add(
								new DescriptionSection(
										e3,
										dataSource,
										"Description",
										"Xenobiotic-induced inhibition of complex III is not well understood and may proceed via multiple mechanisms involving different sites within the complex.  A number of structurally diverse compounds have been shown to inhibit the activity of complex III.  Inhibitors may be divided into at least two categories based on their site of action: those that bind at the Qo site (Class P) and those that bind at the Qi site (Class N) [Esser et al].  Examples of the former group include include stigmatellin [Esposti et al] and myxothiazol [Esposti et al], while an example of the latter group is antimycin A [Von Jagow and Link].")
										.<DescriptionSection> makeItLive());
				e3.getReferenceIDs().add(new Reference(e3, dataSource, "Scheffler, I. E. (2008). Mitochondria, Second Edition. Hoboken, NJ: John Wiley & Sons.").<Reference> makeItLive());
				e3.getReferenceIDs()
						.add(
								new Reference(
										e3,
										dataSource,
										"Esser, L., Quinn, B., Li, Y. F., Zhang, M., Elberry, M., Yu, L., … Xia, D. (2004). Crystallographic studies of quinol oxidation site inhibitors: a modified classification of inhibitors for the cytochrome bc(1) complex. Journal of Molecular Biology, 341, 281-302.")
										.<Reference> makeItLive());
				e3.getReferenceIDs().add(
						new Reference(e3, dataSource, "Esposti, M. D. (1998). Inhibitors of NADH−ubiquinone reductase: an overview. Biochimica et Biophysica Acta, 1364, 222-235.").<Reference> makeItLive());
				e3.getReferenceIDs().add(
						new Reference(e3, dataSource, "von Jagow, G., & Link, T. A. (1986). Use of specific inhibitors on the mitochondrial bc1 complex. Methods in Enzymology, 126, 253-271.").<Reference> makeItLive());
				
				Effectopedia.EFFECTOPEDIA.setCurrentUser(STEVEN);
				Effect_DownstreamEffect e4 = new Effect_DownstreamEffect(pathway, dataSource);
				e4.setTitle("Inhibition of complex IV");
				e4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				e4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				e4.getDescriptionIDs()
						.set(
								new DescriptionSection(
										e4,
										dataSource,
										"Background",
										"The electron transport chain (ETC) is composed of four complexes (I-IV) embedded in the mitochondrial inner membrane and plays a crucial role in the production of ATP by mitochondria.  Electrons are received from a donor such as nicotinamide adenine dinucleotide (NADH) and then dropped through a series of intermediate stages of increasing redox potential to their final destination, oxygen.  The energy released from NADH oxidation is used to pump protons from the matrix of the mitochondria to the intermembrane space, thereby creating an electrochemical gradient which is used by ATP synthase as the energy source for ATP production.\n\nComplex IV, commonly referred to as cytochrome c oxidase, is the fourth and terminal complex of the ETC.  The mammalian complex functions as a dimer, with each monomer unit containing 13 different polypeptide chains.  Three subunits form the functional core of the enzyme and these contain two hemes (heme a and heme a3) and two copper centres (the CuA and CuB centres).  The role of the complex within the ETC is to receive four electrons from cytochrome c and pass them, via the copper and heme centres, to oxygen, which is reduced to water.  The energy released by this process is used to pump protons from the mitochondrial matrix to the intermembrane space.  For every oxygen molecule that is reduced, two molecules of water are produced and four protons are pumped to the intermembrane space [Scheffler].")
										.<DescriptionSection> makeItLive(), 0);
				e4.getDescriptionIDs()
						.add(
								new DescriptionSection(
										e2,
										dataSource,
										"Description",
										"Xenobiotic-induced inhibition of complex IV is not well understood and may proceed via multiple mechanisms involving different sites within the complex.  A variety of structurally diverse compounds are known to inhibit the activity of complex IV [Nicholls and Chance].  Inhibitors can be classified according to whether they effect the oxygen-reducing, heme a3—CuB centre of the enzyme (e.g. cyanide [Rossignol et al] and carbon monoxide [Erecinska and Wilson]) or the interaction of complex IV with the natural electron donor, cytochrome c (e.g. alkaline proteins and polypeptides) [Wallace and Starkov].")
										.<DescriptionSection> makeItLive());
				e4.getReferenceIDs().add(new Reference(e4, dataSource, "Scheffler, I. E. (2008). Mitochondria, Second Edition. Hoboken, NJ: John Wiley & Sons.").<Reference> makeItLive());
				e4.getReferenceIDs().add(
						new Reference(e4, dataSource, "Nicholls, P., & Chance, B. (1974). Cytochrome c oxidase. In O, Hayaish (Ed.), Molecular Mechanisms of Oxygen Activation (pp 479-534). New York: Academic.")
								.<Reference> makeItLive());
				e4.getReferenceIDs()
						.add(
								new Reference(
										e4,
										dataSource,
										"Rossignol, R., Letellier, T., Malgat, M., Rocher, C., & Mazat, J. P. (2000). Tissue variation in the control of oxidative phosphorylation: implication for mitochondrial diseases. Biochemical Journal, 347, 45-53.")
										.<Reference> makeItLive());
				e4.getReferenceIDs()
						.add(new Reference(e4, dataSource, "Erecińska, M., & Wilson, D. F. (1980). Inhibitors of cytochrome c oxidase. Pharmacology & Therapeutics, 8, 1-20.").<Reference> makeItLive());
				e4.getReferenceIDs().add(
						new Reference(e4, dataSource, "Wallace, K. B., & Starkov, A. A. (2000). Mitochondrial targets of drug toxicity. Annual Review of Pharmacology and Toxicology, 40, 353-388.")
								.<Reference> makeItLive());
				
				Effectopedia.EFFECTOPEDIA.setCurrentUser(User.IQF);
				Pathway.unlink(pathway, mie1, de);
				Pathway.unlink(pathway, mie2, de);
				Pathway.unlink(pathway, mie3, de);
				Pathway.unlink(pathway, mie4, de);
				
				Effectopedia.EFFECTOPEDIA.setCurrentUser(STEVEN);
				new Link_EffectToEffect(pathway, dataSource, mie1, e1);
				new Link_EffectToEffect(pathway, dataSource, mie4, e4);
				Effectopedia.EFFECTOPEDIA.setCurrentUser(DAMIANO);
				new Link_EffectToEffect(pathway, dataSource, mie2, e2);
				new Link_EffectToEffect(pathway, dataSource, mie3, e3);
				
				Effectopedia.EFFECTOPEDIA.setCurrentUser(User.IQF);
				
				new Link_EffectToEffect(pathway, dataSource, e1, de);
				new Link_EffectToEffect(pathway, dataSource, e2, de);
				new Link_EffectToEffect(pathway, dataSource, e3, de);
				new Link_EffectToEffect(pathway, dataSource, e4, de);
				
				return pathway;
			}
		
		public Pathway Gil_Thought_starter_DNA_Intercalation_Mediated_Cardiomyopathy(DataSource dataSource)
			{
				Effectopedia.EFFECTOPEDIA.setCurrentUser(GDVEITH);
				
				Pathway pathway = new Pathway(null, dataSource);
				pathway.setTitle("DNA Intercalation Mediated Cardiomyopathy");
				
				Initiator_ChemicalStructure chemical1 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical1.setTitle("Doxorubicin (DOX)");
				chemical1
						.getStructure2DImage()
						.setValue(
								"https://apps.ideaconsult.net/ambit2/depict/cdk?search=OCC%28%3DO%29%5BC%40%40%5D4%28O%29C%5BC%40H%5D%28O%5BC%40H%5D1C%5BC%40H%5D%28N%29%5BC%40H%5D%28O%29%5BC%40H%5D%28C%29O1%29c5c%28O%29c3C%28%3DO%29c2c%28OC%29cccc2C%28%3DO%29c3c%28O%29c5C4&w=200&h=200&media=image/png");
				chemical1.getIdentification().setPropertyValue(0, "23214928");
				chemical1.getIdentification().setPropertyValue(1, "(7S,9S)-7-[(2R,4S,5S,6S)-4-amino-5-hydroxy-6-methyloxan-2-yl]oxy-6,9,11-trihydroxy-9-(2-hydroxyacetyl)-4-methoxy-8,10-dihydro-7H-tetracene-5,12-dione");
				chemical1.getIdentification().setPropertyValue(2, "OCC(=O)[C@@]4(O)C[C@H](O[C@H]1C[C@H](N)[C@H](O)[C@H](C)O1)c5c(O)c3C(=O)c2c(OC)cccc2C(=O)c3c(O)c5C4");
				chemical1.getIdentification().setPropertyValue(3, "C27H29NO11");
				chemical1.getProperties().setPropertyValue(0, "543.52");
				chemical1.getSynonyms().setValue("Hydroxydaunorubicin|Adriamycin PFS|Adriamycin RDF");
				
				Effect_MolecularInitiatingEvent mie1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie1.setTitle("Intercalation with Nuclear and mt DNA");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE.DIMENSION_INDEX, "adult");
				
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie1);
				
				Effect_DownstreamEffect organelle_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				organelle_effect1.setTitle("Inhibition of Topoisomerase II");
				organelle_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organelle");
				organelle_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organelle_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mid-term");
				
				new Link_EffectToEffect(pathway, dataSource, mie1, organelle_effect1);
				
				Effect_DownstreamEffect organelle_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				organelle_effect2.setTitle("Altered Expression of ETC Proteins");
				organelle_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organelle");
				organelle_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organelle_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");
				
				new Link_EffectToEffect(pathway, dataSource, mie1, organelle_effect2);
				
				Effect_DownstreamEffect organelle_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
				organelle_effect3.setTitle("Deregulation and Increase of mt Calcium Loading");
				organelle_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organelle");
				organelle_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organelle_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");
				
				new Link_EffectToEffect(pathway, dataSource, organelle_effect2, organelle_effect3);
				
				Effect_DownstreamEffect organelle_effect4 = new Effect_DownstreamEffect(pathway, dataSource);
				organelle_effect4.setTitle("Reduced Calcium Loading Capacity of Mitochondria");
				organelle_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organelle");
				organelle_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organelle_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mid-term");
				
				new Link_EffectToEffect(pathway, dataSource, organelle_effect3, organelle_effect4);
				
				Effect_DownstreamEffect organelle_effect5 = new Effect_DownstreamEffect(pathway, dataSource);
				organelle_effect5.setTitle("Calcium-Induced MPT");
				organelle_effect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organelle");
				organelle_effect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organelle_effect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");
				
				new Link_EffectToEffect(pathway, dataSource, organelle_effect3, organelle_effect5);
				
				Effect_DownstreamEffect cellular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect1.setTitle("Inhibited DNA Replication");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mid-term");
				
				new Link_EffectToEffect(pathway, dataSource, organelle_effect1, cellular_effect1);
				
				Effect_DownstreamEffect cellular_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect2.setTitle("Altered Sychronization of Calcium in Myocytes");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mid-term");
				
				new Link_EffectToEffect(pathway, dataSource, organelle_effect4, cellular_effect2);
				
				Effect_DownstreamEffect cellular_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect3.setTitle("Calcium-Induced Cell Death in Myocytes");
				cellular_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				cellular_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");
				
				new Link_EffectToEffect(pathway, dataSource, organelle_effect5, cellular_effect3);
				
				Effect_DownstreamEffect cellular_effect4 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect4.setTitle("Altered Calicium Signaling");
				cellular_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				cellular_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");
				
				new Link_EffectToEffect(pathway, dataSource, organelle_effect5, cellular_effect4);
				
				Effect_DownstreamEffect tissue_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				tissue_effect1.setTitle("Tumor Cell Death and Regression");
				tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mid-term");
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, tissue_effect1);
				
				Effect_DownstreamEffect tissue_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				tissue_effect2.setTitle("Congestive Heart Failure");
				tissue_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				tissue_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				tissue_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "long-term");
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, tissue_effect2);
				
				Effect_DownstreamEffect tissue_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
				tissue_effect3.setTitle("Increased Sensitivity to Calcium Loading/ROS in Myocytes");
				tissue_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				tissue_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				tissue_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mid-term");
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect2, tissue_effect3);
				new Link_EffectToEffect(pathway, dataSource, cellular_effect3, tissue_effect3);
				
				Effect_DownstreamEffect organ_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect1.setTitle("Dialated CardioMyopathy");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "long-term");
				
				new Link_EffectToEffect(pathway, dataSource, tissue_effect2, organ_effect1);
				
				Effect_DownstreamEffect organ_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect2.setTitle("Accumulating Risk for Cardiopathy");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mid-term");
				
				new Link_EffectToEffect(pathway, dataSource, tissue_effect3, organ_effect2);
				
				ContextDimension_Hierarchical dimension = (ContextDimension_Hierarchical) mie1.getCoordinates().getCoordiante(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX).getDimension();
				BatchSetCooridnate batchToHuman = new BatchSetCooridnate(DefaultEffectopediaObjects.DEFAULT_TAXONOMY.DIMENSION_INDEX, (dimension).getHierarchy().indexOf("Species"), "human");
				BatchSetCooridnate batchToAdult = new BatchSetCooridnate(DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE.DIMENSION_INDEX, "adult");
				pathway.process(batchToHuman);
				pathway.process(batchToAdult);
				
				Effectopedia.EFFECTOPEDIA.setCurrentUser(User.IQF);
				Effect_DownstreamEffect organ_effect3 = (Effect_DownstreamEffect) searchEffectByTitle("Heart Failure");
				if (organ_effect3 != null)
					pathway.associate(organ_effect3);
				else
					{
						organ_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
						organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
						organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_BIO_COMPARTMENT.DIMENSION_INDEX, "heart");
						organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "long-term");
					}
				
				Effectopedia.EFFECTOPEDIA.setCurrentUser(GDVEITH);
				
				Effect_DownstreamEffect organ_system_effect1 = (Effect_DownstreamEffect) searchEffectByTitle("Respiratory Failure");
				if (organ_system_effect1 != null)
					pathway.associate(organ_system_effect1);
				else
					{
						organ_system_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
						organ_system_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ system");
						organ_system_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
						organ_system_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "long-term");
					}
				
				Link link = (Link) Pathway.getDirektLink(organ_effect3, organ_system_effect1);
				if (link != null)
					pathway.add(link);
				else
					new Link_EffectToEffect(pathway, dataSource, organ_effect3, organ_system_effect1);
				
				new Link_EffectToEffect(pathway, dataSource, organ_effect1, organ_effect3);
				new Link_EffectToEffect(pathway, dataSource, organ_effect2, organ_effect3);

				pathway.updateEssentiality();
				return pathway;
			}
		
		public Pathway AR_Agonism_leading_to_reproductive_dysfunction(DataSource dataSource)
			{
				Effectopedia.EFFECTOPEDIA.setCurrentUser(DVILLENEUVE);
				Stamp.setDefaultDate(2015, 3, 18, 14, 24, 17, 0);
				Pathway pathway = new Pathway(null, dataSource);
				pathway.setTitle("Androgen receptor agonism leading to reproductive dysfunction");
				
				Initiator_ChemicalStructure chemical1 = new Initiator_ChemicalStructure(pathway, dataSource);
				
				Effect_MolecularInitiatingEvent mie1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie1.setTitle("Androgen receptor, agonism");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE.DIMENSION_INDEX, "adult");
				mie1.getDescriptionIDs()
				.set(
						new DescriptionSection(
								mie1,
								dataSource,
								"How this Key Event works",
								"Site of action: The molecular site of action is the ligand binding domain of the AR. The cellular site of action for the molecular initiating event is undefined.Responses at the macromolecular level: Binding of a ligand, including xenobiotics that act as AR agonists, to the cytosolic AR mediates a conformational shift that facilitates dissociation from accompanying heat shock proteins and dimerization with another AR (Prescott and Coetzee 2006; Claessens et al. 2008; Centenera et al. 2008). Homodimerization unveils a nuclear localization sequence, allowing the AR-ligand complex to translocate to the nucleus and bind to androgen-response elements (AREs) (Claessens et al. 2008; Cutress et al. 2008). This elicits recruitment of additional transcription factors and transcriptional activation of androgen-responsive genes (Heemers and Tindall 2007).")
								.<DescriptionSection> makeItLive(), 0);
				mie1.getDescriptionIDs()
				.add(
						new DescriptionSection(
								mie1,
								dataSource,
								"How it is Measured or Detected",
								"Methods that have been previously reviewed and approved by a recognized authority should be included in the Overview section above. All other methods, including those well established in the published literature, should be described here. Consider the following criteria when describing each method: 1. Is the assay fit for purpose? 2. Is the assay directly or indirectly (i.e. a surrogate) related to a key event relevant to the final adverse effect in question? 3. Is the assay repeatable? 4. Is the assay reproducible?\nMeasurement/detection: Binding to the androgen receptor can be directly measured in cell free systems based on displacement of a radio-labeled standard (generally testosterone or DHT) in a competitive binding assay (e.g., (Olsson et al. 2005; Sperry and Thomas 1999; Wilson et al. 2007; Tilley et al. 1989; Kim et al. 2010). However, cell based transcriptional activation assays are typically required to differentiate agonists from antagonists, in vitro. A number of reporter gene assays have been developed and used to screen chemicals for AR agonist and/or antagonist activity (e.g., (Wilson et al. 2002; van der Burg et al. 2010; Mak et al. 1999; Araki et al. 2005). Expression of androgen responsive proteins like spiggin in primary cell cultures has also been used to detect AR agonist activity (Jolly et al. 2006).\nIn fish, phenotypic masculinization of females has frequently been used as an indirect measurement of in vivo androgen receptor agonism. For example, development of nuptial tubercles, a dorsal fatpad, and a characteristic banding pattern has been observed in female fathead minnows exposed to androgen agonists (Ankley et al. 2003; Jensen et al. 2006; Ankley et al. 2010; LaLone et al. 2013). Likewise, anal fin elongation in female western mosquitofish (Gambusia affinis) has similarly been viewed as evidence of AR activation (Raut et al. 2011; Sone et al. 2005).")
								.<DescriptionSection> makeItLive());
				mie1.getDescriptionIDs()
				.add(
						new DescriptionSection(
								mie1,
								dataSource,
								"Evidence Supporting Taxonomic Applicability",
								"Taxonomic applicability: Androgen receptor orthologs are primarily limited to vertebrates (Baker 1997; Thornton 2001; Eick and Thornton 2011; Markov and Laudet 2011). Therefore, this MIE would generally be viewed as relevant to vertebrates, but not necessarily invertebrates.")
								.<DescriptionSection> makeItLive());
				mie1.getDescriptionIDs()
				.add(
						new DescriptionSection(
								mie1,
								dataSource,
								"Evidence for Chemical Initiation of this Molecular Initiating Event",
								"Characterization of chemical properties: Androgen receptor binding chemicals can be grouped into two broad structural domains, steroidal and non-steroidal (Yin et al. 2003). Steroidal androgens consist primarily of testosterone and its derivatives (Yin et al. 2003). Many of the non-steroidal AR binding chemicals studied are derivatives of well known non-steroidal AR antagonists like bicalutamide, hydroxyflutamide, and nilutamide (Yin et al. 2003). Nonetheless, a number of QSARs and SARs that consider AR binding of both these pharmaceutical agents as well as environmental chemicals have been developed (Waller et al. 1996; Serafimova et al. 2002; Todorov et al. 2011; Hong et al. 2003; Bohl et al. 2004). However, it has been shown that very minor structural differences can dramatically impact function as either an agonist or antagonist (Yin et al. 2003; Bohl et al. 2004; Norris et al. 2009), making it difficult at present to predict agonist versus antagonist activity based on chemical structure alone.")
								.<DescriptionSection> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Prescott J, Coetzee GA. 2006. Molecular chaperones throughout the life cycle of the androgen receptor. Cancer letters 231(1): 12-19.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Claessens F, Denayer S, Van Tilborgh N, Kerkhofs S, Helsen C, Haelens A. 2008. Diverse roles of androgen receptor (AR) domains in AR-mediated signaling. Nuclear receptor signaling 6: e008.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Centenera MM, Harris JM, Tilley WD, Butler LM. 2008. The contribution of different androgen receptor domains to receptor dimerization and signaling. Molecular endocrinology 22(11): 2373-2382.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Cutress ML, Whitaker HC, Mills IG, Stewart M, Neal DE. 2008. Structural basis for the nuclear import of the human androgen receptor. Journal of cell science 121(Pt 7): 957-968.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Yin D, He Y, Perera MA, Hong SS, Marhefka C, Stourman N, et al. 2003. Key structural features of nonsteroidal ligands for binding and activation of the androgen receptor. Molecular pharmacology 63(1): 211-223.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Waller CL, Juma BW, Gray EJ, Kelce WR. 1996. Three-dimensional quantitative structure-activity relationships for androgen receptor ligands. Toxicology and Applied Pharmacolgy 137: 219-227.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Serafimova R, Walker J, Mekenyan O. 2002. Androgen receptor binding affinity of pesticide \"active\" formulation ingredients. QSAR evaluation by COREPA method. SAR and QSAR in environmental research 13(1): 127-134.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Todorov M, Mombelli E, Ait-Aissa S, Mekenyan O. 2011. Androgen receptor binding affinity: a QSAR evaluation. SAR and QSAR in environmental research 22(3): 265-291.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Hong H, Fang H, Xie Q, Perkins R, Sheehan DM, Tong W. 2003. Comparative molecular field analysis (CoMFA) model using a large diverse set of natural, synthetic and environmental chemicals for binding to the androgen receptor. SAR and QSAR in environmental research 14(5-6): 373-388.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Bohl CE, Chang C, Mohler ML, Chen J, Miller DD, Swaan PW, et al. 2004. A ligand-based approach to identify quantitative structure-activity relationships for the androgen receptor. Journal of medicinal chemistry 47(15): 3765-3776.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Norris JD, Joseph JD, Sherk AB, Juzumiene D, Turnbull PS, Rafferty SW, et al. 2009. Differential presentation of protein interaction surfaces on the androgen receptor defines the pharmacological actions of bound ligands. Chemistry & biology 16(4): 452-460.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Olsson P-E, Berg A, von Hofsten J, Grahn B, Hellqvist A, Larsson A, et al. 2005. Molecular cloning and characterization of a nuclear androgen receptor activated by 11-ketotestosterone. Reproductive Biology and Endocrinology 3: 1-17.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Sperry TS, Thomas P. 1999. Identification of two nuclear androgen receptors in kelp bass (Paralabrax clathratus) and their binding affinities for xenobiotics: comparison with Atlantic croaker (Micropogonias undulatus) androgen receptors. Biology of reproduction 61(4): 1152-1161.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Wilson VS, Cardon MC, Gray LE, Jr., Hartig PC. 2007. Competitive binding comparison of endocrine-disrupting compounds to recombinant androgen receptor from fathead minnow, rainbow trout, and human. Environmental toxicology and chemistry / SETAC 26(9): 1793-1802.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Tilley WD, Marcelli M, Wilson JD, McPhaul MJ. 1989. Characterization and expression of a cDNA encoding the human androgen receptor. Proceedings of the National Academy of Sciences of the United States of America 86(1): 327-331.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Kim TS, Yoon CY, Jung KK, Kim SS, Kang IH, Baek JH, et al. 2010. In vitro study of Organization for Economic Co-operation and Development (OECD) endocrine disruptor screening and testing methods- establishment of a recombinant rat androgen receptor (rrAR) binding assay. The Journal of toxicological sciences 35(2): 239-243.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Wilson VS, Bobseine K, Lambright CR, Gray LE. 2002. A novel cell line, MDA-kb2, that stably expresses an androgen- and glucocorticoid-responsive reporter for the detection of hormone receptor agonists and antagonists. Toxicological Sciences 66: 69-81.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "van der Burg B, Winter R, Man HY, Vangenechten C, Berckmans P, Weimer M, et al. 2010. Optimization and prevalidation of the in vitro AR CALUX method to test androgenic and antiandrogenic activity of compounds. Reproductive toxicology 30(1): 18-24.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Mak P, Cruz FD, Chen S. 1999. A yeast screen system for aromatase inhibitors and ligands for androgen receptor: yeast cells transformed with aromatase and androgen receptor. Environmental health perspectives 107(11): 855-860.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Araki N, Ohno K, Nakai M, Takeyoshi M, Iida M. 2005. Screening for androgen receptor activities in 253 industrial chemicals by in vitro reporter gene assays using AR-EcoScreen cells. Toxicology in vitro : an international journal published in association with BIBRA 19(6): 831-842.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Jolly C, Katsiadaki I, Le Belle N, Mayer I, Dufour S. 2006. Development of a stickleback kidney cell culture assay for the screening of androgenic and anti-androgenic endocrine disrupters. Aquatic toxicology 79(2): 158-166.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Baker ME. 1997. Steroid receptor phylogeny and vertebrate origins. Molecular and cellular endocrinology 135(2): 101-107.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Thornton JW. 2001. Evolution of vertebrate steroid receptors from an ancestral estrogen receptor by ligand exploitation and serial genome expansions. Proceedings of the National Academy of Sciences of the United States of America 98(10): 5671-5676.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Eick GN, Thornton JW. 2011. Evolution of steroid receptors from an estrogen-sensitive ancestral receptor. Molecular and cellular endocrinology 334(1-2): 31-38.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Markov GV, Laudet V. 2011. Origin and evolution of the ligand-binding ability of nuclear receptors. Molecular and cellular endocrinology 334(1-2): 21-30.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Sone K, Hinago M, Itamoto M, Katsu Y, Watanabe H, Urushitani H, Tooi O, Guillette LJ Jr, Iguchi T. Effects of an androgenic growth promoter 17beta-trenbolone on masculinization of Mosquitofish (Gambusia affinis affinis). Gen Comp Endocrinol. 2005 Sep 1;143(2):151-60. Epub 2005 Apr 13. PubMed PMID: 16061073.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Stanko JP, Angus RA. In vivo assessment of the capacity of androstenedione to masculinize female mosquitofish (Gambusia affinis) exposed through dietary and static renewal methods. Environ Toxicol Chem. 2007 May;26(5):920-6. PubMed PMID: 17521138.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "LaLone CA, Villeneuve DL, Cavallin JE, Kahl MD, Durhan EJ, Makynen EA, Jensen KM, Stevens KE, Severson MN, Blanksma CA, Flynn KM, Hartig PC, Woodard JS, Berninger JP, Norberg-King TJ, Johnson RD, Ankley GT. Cross-species sensitivity to a novel androgen receptor agonist of potential environmental concern, spironolactone. Environ Toxicol Chem. 2013 Nov;32(11):2528-41. doi: 10.1002/etc.2330. Epub 2013 Sep 6. PubMed PMID: 23881739.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Jensen KM, Makynen EA, Kahl MD, Ankley GT. Effects of the feedlot contaminant 17alpha-trenbolone on reproductive endocrinology of the fathead minnow. Environ Sci Technol. 2006 May 1;40(9):3112-7. PubMed PMID: 16719119.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Ankley GT, Jensen KM, Kahl MD, Durhan EJ, Makynen EA, Cavallin JE, Martinović D, Wehmas LC, Mueller ND, Villeneuve DL. Use of chemical mixtures to differentiate mechanisms of endocrine action in a small fish model. Aquat Toxicol. 2010 Sep 1;99(3):389-96. doi: 10.1016/j.aquatox.2010.05.020. Epub 2010 Jun 4. PubMed PMID: 20573408.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Ankley GT, Jensen KM, Makynen EA, Kahl MD, Korte JJ, Hornung MW, Henry TR, Denny JS, Leino RL, Wilson VS, Cardon MC, Hartig PC, Gray LE. Effects of the androgenic growth promoter 17-beta-trenbolone on fecundity and reproductive endocrinology of the fathead minnow. Environ Toxicol Chem. 2003 Jun;22(6):1350-60. PubMed PMID: 12785594.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource,  "Ankley GT, Gray LE. Cross-species conservation of endocrine pathways: a critical analysis of tier 1 fish and rat screening assays with 12 model chemicals. Environ Toxicol Chem. 2013 Apr;32(5):1084-7. doi: 10.1002/etc.2151. Epub 2013 Mar 19. PubMed PMID: 23401061.").<Reference> makeItLive());

				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie1);
				
				Effect_DownstreamEffect molecular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				molecular_effect1.setTitle("Gonadotropins, circulating concentrations, reduction");
				molecular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				molecular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				molecular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE.DIMENSION_INDEX, "adult");
				
				Link_EffectToEffect link = new Link_EffectToEffect(pathway, dataSource, mie1, molecular_effect1);
				link.getDescriptionIDs()
				.set(
						new DescriptionSection(
								link,
								dataSource,
								"Biological Plausibility",
								"Circulating concentrations of steroid hormones are tightly regulated via positive and negative feedback loops that operate through endocrine, autocrine, and/or paracrine mechanisms within the hypothalamic-pituitary-gonadal axis (Norris 2007). Gonadotropin (luteinizing hormone [LH] and follicle-stimulating hormone [FSH]) secretion from the pituitary is a key regulator of gonadal steroid biosynthesis. Negative feedback of androgens or estrogens at the level of the hypothalamus and/or pituitary can reduce gonadotropin secretion by pituitary gonadotropes either indirectly due to decreased GnRH signaling from the hypothalamus or directly through intrapituitary regulators of gonadotropin expression (e.g., activin, follistatin, inhibin) (Norris 2007; Habibi and Huggard 1998).\nThe specific mechanisms through which negative feedback of AR agonists on the hypothalamus and pituitary are mediated in fish are not fully understood. However, it is thought that GABAergic and dopaminergic neurons may be important mediators of sex steroid feedback on gonadotropin releasing hormone (GnRH) release from the hypothalamus (Trudeau et al. 2000; Trudeau 1997). Recent evidence also suggests an important role of kisspeptin neurons, which have been shown to express both AR and ERÎ± are important mediators of feedback response to circulating androgen concentrations (Oakley et al. 2009). Follistatin expression in the pituitary has also been cited as a key regulator of gonadotropin expression that is directly regulated by androgens and estrogens (Cheng et al. 2007). Regardless of the exact mechanisms, negative feedback of androgens on GnRH and/or gonadotropin release from the hypothalamus and/or pituitary is a well established endocrine phenomenon.")
								.<DescriptionSection> makeItLive(), 0);
				link.getDescriptionIDs()
				.add(
						new DescriptionSection(
								link,
								dataSource,
								"Empirical Support for Linkage",
								"Include consideration of temporal concordance here")
								.<DescriptionSection> makeItLive());
				link.getDescriptionIDs()
				.add(
						new DescriptionSection(
								link,
								dataSource,
								"Uncertainties or Inconsistencies",
								"Due to uncertainties regarding the exact mechanisms through which exogenous androgens mediate a negative feedback response this initiation of a negative feedback response is not directly observable. Negative feedback would generally be inferred through a decrease in gonadotropin release and associated declines in circulating gonadotropin concentrations.")
								.<DescriptionSection> makeItLive());
				link.getReferenceIDs().add(new Reference(link, dataSource,  "Norris DO. 2007. Vertebrate Endocrinology. Fourth ed. New York: Academic Press.").<Reference> makeItLive());
				link.getReferenceIDs().add(new Reference(link, dataSource,  "Habibi HR, Huggard DL. 1998. Testosterone regulation of gonadotropin production in goldfish. Comparative biochemistry and physiology Part C, Pharmacology, toxicology & endocrinology 119(3): 339-344.").<Reference> makeItLive());
				link.getReferenceIDs().add(new Reference(link, dataSource,  "Trudeau VL, Spanswick D, Fraser EJ, Lariviére K, Crump D, Chiu S, et al. 2000. The role of amino acid neurotransmitters in the regulation of pituitary gonadotropin release in fish. Biochemistry and Cell Biology 78: 241-259.").<Reference> makeItLive());
				link.getReferenceIDs().add(new Reference(link, dataSource,  "Trudeau VL. 1997. Neuroendocrine regulation of gonadotropin II release and gonadal growth in the goldfish, Carassius auratus. Reviews of Reproduction 2: 55-68.").<Reference> makeItLive());
				link.getReferenceIDs().add(new Reference(link, dataSource,  "Oakley AE, Clifton DK, Steiner RA. 2009. Kisspeptin signaling in the brain. Endocrine reviews 30(6): 713-743.").<Reference> makeItLive());
				link.getReferenceIDs().add(new Reference(link, dataSource,  "Cheng GF, Yuen CW, Ge W. 2007. Evidence for the existence of a local activin follistatin negative feedback loop in the goldfish pituitary and its regulation by activin and gonadal steroids. The Journal of endocrinology 195(3): 373-384.").<Reference> makeItLive());
				
				Effect_DownstreamEffect cellular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect1.setTitle("Testosterone synthesis by ovarian theca cells, reduction");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE.DIMENSION_INDEX, "adult");
				cellular_effect1.getDescriptionIDs()
				.set(
						new DescriptionSection(
								cellular_effect1,
								dataSource,
								"How this Key Event works",
								"Testosterone is synthesized in ovarian theca cells through a series of enzyme catalyzed reactions that convert cholesterol to androgens (see KEGG reference pathway 00140 for details; www.genome.jp/kegg; (Payne and Hales 2004; Magoffin 2005; Young and McNeilly 2010). Binding of luteinizing hormone to luteinizing hormone receptors located on the surface of theca cell membranes leads to increased expression of steriodogenic cytochrome P450s, steroidogeneic acute regulatory protein, and consequent increases in androgen production (Payne and Hales 2004; Miller 1988; Miller and Strauss 1999).")
								.<DescriptionSection> makeItLive(), 0);
				cellular_effect1.getDescriptionIDs()
				.add(
						new DescriptionSection(
								cellular_effect1,
								dataSource,
								"How it is Measured or Detected",
								"Steroid production by isolated primary theca cells can be measured using radioimmunoassay or enzyme immunoassay approaches (e.g., (Benninghoff and Thomas 2006; Campbell et al. 1998). However, the isolation and culture methods are not trivial. Similarly, development of immortalized theca cell lines has proven challenging (Havelock et al. 2004). Consequently, this key event is perhaps best evaluated by examining T production by intact ovarian tissue explants either exposed to chemicals in vitro (e.g., (Villeneuve et al. 2007; McMaster ME 1995) or in vivo (i.e., via ex vivo steroidogenesis assay; e.g., (Ankley et al. 2007)). Reductions in T production by ovarian tissue explants can indicate either direct inhibition of steriodogenic enzymes involved in T synthesis, or indirect impacts due to feedback along the hypothalamic-pituitary-gonadal axis (in cases where chemical exposures occur in vivo). However, because T synthesis in the theca cells is closely linked to estradiol (E2) synthesis by granulosa cells, reductions in T production by intact ovary tissue can also be due to increased aromatase activity and the resulting increased rate of converting T to E2.")
								.<DescriptionSection> makeItLive());
				
				link = new Link_EffectToEffect(pathway, dataSource, molecular_effect1, cellular_effect1);
				link.getDescriptionIDs()
				.set(
						new DescriptionSection(
								link,
								dataSource,
								"Biological Plausibility",
								"In mammals androgen production by theca cells is largely under control of LH (Norris 2007; Young and McNeilly 2010). In fish, the differential role of LH versus FSH has been more difficult to define, in part due to the inability to specifically measure LH and FSH in most fish species and the parallel fluctuations of LH and FSH expression in many species. However, regardless of the differential effects of the two gonadotropins there is little dispute that gonadotropins stimulate gonadal steroid production and that the production of androgens (e.g., androstenedione, testosterone), which are the precursors for estrogen synthesis occurs in the theca cells (Payne and Hales 2004; Young and McNeilly 2010; Miller 1988; Nagahama et al. 1993).")
								.<DescriptionSection> makeItLive(), 0);
				link.getDescriptionIDs()
				.add(
						new DescriptionSection(
								link,
								dataSource,
								"Empirical Support for Linkage",
								"Include consideration of temporal concordance here There is a strong weight of evidence establishing the role of gonadotropins in stimulating gonadal steroidogenesis. This relationship is widely accepted.")
								.<DescriptionSection> makeItLive());
				link.getDescriptionIDs()
				.add(
						new DescriptionSection(
								link,
								dataSource,
								"Uncertainties or Inconsistencies",
								"")
								.<DescriptionSection> makeItLive());
				link.getDescriptionIDs()
				.add(
						new DescriptionSection(
								link,
								dataSource,
								"Quantitative Understanding of the Linkage",
								"Is it known how much change in the first event is needed to impact the second? Are there known modulators of the response-response relationships? Are there models or extrapolation approaches that help describe those relationships?\nPredictive quantitative relationships between circulating gonadotropin concentrations in fish and testosterone synthesis by ovarian theca cells have not been established.")
								.<DescriptionSection> makeItLive());
				link.getDescriptionIDs()
				.add(
						new DescriptionSection(
								link,
								dataSource,
								"Evidence Supporting Taxonomic Applicability",
								"")
								.<DescriptionSection> makeItLive());
			
				Effect_DownstreamEffect cellular_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect2.setTitle("17beta-estradiol synthesis by ovarian granulosa cells, reduction");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE.DIMENSION_INDEX, "adult");

				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, cellular_effect2);
				
				Stamp.resetDefaultDate();
				pathway.updateEssentiality();
				return pathway;
			}
		
		private final User	GDVEITH												= new User("Int'l QSAR Foundation Thought-Starter", 58L);
		private final User	STEVEN													= new User("S Canipa, Lhasa Limited", 12L);
		private final User	DAMIANO												= new User("D Portinari, Lhasa Limited", 18L);
		private final User	DVILLENEUVE								= new User("Dan Villeneuve", 22L);
		private final User	STEVEN_AND_DAMIANO	= new User("S Canipa and D Portinari, Lhasa Limited", 44L);
	}

package org.qsari.effectopedia.data.generated;

import org.qsari.effectopedia.base.ids.IDs;
import org.qsari.effectopedia.base.ids.ReferenceIDW;
import org.qsari.effectopedia.core.object.elemets.EssetialityDescription;
import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.core.objects.DescriptionSection.ContentFormat;
import org.qsari.effectopedia.core.objects.DescriptionSection_Structured;
import org.qsari.effectopedia.core.objects.Effect_AdverseOutcome;
import org.qsari.effectopedia.core.objects.Effect_DownstreamEffect;
import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.Link.LinkType;
import org.qsari.effectopedia.core.objects.Link_ChemStructToMIE;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.core.objects.Method_InSilicoGlobalModel;
import org.qsari.effectopedia.core.objects.Reference;
import org.qsari.effectopedia.core.objects.SubstanceData_InSilico;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.core.objects.Test_ExVivo;
import org.qsari.effectopedia.core.objects.Test_InSilico;
import org.qsari.effectopedia.core.objects.Test_InVitro;
import org.qsari.effectopedia.core.objects.Test_InVivo;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.RevisionBasedDS;
import org.qsari.effectopedia.data.objects.DataUnit;
import org.qsari.effectopedia.data.objects.DataValue_Double;
import org.qsari.effectopedia.data.objects.DataValue_String;
import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.objects.ObjectPropertyType;
import org.qsari.effectopedia.data.objects.Resource;
import org.qsari.effectopedia.data.objects.Resource.ResourceType;
import org.qsari.effectopedia.data.quantification.DataTemplates;
import org.qsari.effectopedia.defaults.DefaultDataTemplates;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.system.ActionTypes;

public class AInh extends SourceGeneratedPathway
	{
		
		public AInh(DataSource dataSource)
			{
				super("Aromatase inhibition leading to population reduction", "aromatase inhibition,reproductive impairment,", dataSource,
						"D://Java//org.qsari.effectopedia//test//AInh//Aromatase inhibition leading to population reduction");
			}
			
		protected Initiator_ChemicalStructure					initiator_chemicalstructure1;
		protected Link_ChemStructToMIE												link_chemstructtomie2;
		protected Effect_MolecularInitiatingEvent	effect_molecularinitiatingevent3;
		protected Link_EffectToEffect													link_effecttoeffect4;
		protected Effect_DownstreamEffect									effect_downstreameffect5;
		protected Link_EffectToEffect													link_effecttoeffect6;
		protected Effect_DownstreamEffect									effect_downstreameffect7;
		protected Link_EffectToEffect													link_effecttoeffect8;
		protected Effect_DownstreamEffect									effect_downstreameffect9;
		protected Link_EffectToEffect													link_effecttoeffect10;
		protected Effect_DownstreamEffect									effect_downstreameffect11;
		protected Link_EffectToEffect													link_effecttoeffect12;
		protected Effect_DownstreamEffect									effect_downstreameffect13;
		protected Link_EffectToEffect													link_effecttoeffect14;
		protected Effect_DownstreamEffect									effect_downstreameffect15;
		protected Link_EffectToEffect													link_effecttoeffect16;
		protected Effect_AdverseOutcome											effect_adverseoutcome17;
		protected Initiator_ChemicalStructure					initiator_chemicalstructure18;
		protected Link_ChemStructToMIE												link_chemstructtomie19;
		protected Initiator_ChemicalStructure					initiator_chemicalstructure20;
		protected Link_ChemStructToMIE												link_chemstructtomie21;
		protected Test_InVitro																				test_invitro22;
		protected Test_InVivo																					test_invivo23;
		protected Test_ExVivo																					test_exvivo24;
		protected Test_InSilico																			test_insilico25;
		protected TestResponseMapping													testresponsemapping26;
		protected TestResponseMapping													testresponsemapping27;
		protected TestResponseMapping													testresponsemapping28;
		protected TestResponseMapping													testresponsemapping29;
		protected Test_ExVivo																					test_exvivo30;
		protected Test_InSilico																			test_insilico31;
		protected TestResponseMapping													testresponsemapping32;
		protected TestResponseMapping													testresponsemapping33;
		protected Test_InVivo																					test_invivo34;
		protected Test_InSilico																			test_insilico35;
		protected Test_InVivo																					test_invivo36;
		protected Test_InSilico																			test_insilico37;
		protected Test_InVivo																					test_invivo38;
		protected Test_InSilico																			test_insilico39;
		protected Test_InVivo																					test_invivo40;
		protected Test_InSilico																			test_insilico41;
		protected TestResponseMapping													testresponsemapping42;
		protected TestResponseMapping													testresponsemapping43;
		protected TestResponseMapping													testresponsemapping44;
		protected TestResponseMapping													testresponsemapping45;
		protected TestResponseMapping													testresponsemapping46;
		protected TestResponseMapping													testresponsemapping47;
		protected TestResponseMapping													testresponsemapping48;
		protected TestResponseMapping													testresponsemapping49;
		protected Test_InVivo																					test_invivo50;
		protected Test_InSilico																			test_insilico51;
		protected TestResponseMapping													testresponsemapping52;
		protected TestResponseMapping													testresponsemapping53;
		protected Test_InSilico																			test_insilico54;
		protected TestResponseMapping													testresponsemapping55;
		protected Test_InVitro																				test_invitro56;
		protected TestResponseMapping													testresponsemapping57;
		protected Method_InSilicoGlobalModel						method_insilicoglobalmodel58;
		protected Test_InVitro																				test_invitro59;
		protected TestResponseMapping													testresponsemapping60;
		
		protected Method_InSilicoGlobalModel						gm1;
		
		@Override
		public void generateContent()
			{
				genreateRevision1();
				genreateRevision2();
				
				storeRevision();
				((RevisionBasedDS) dataSource).setLocation(pathway);
			}
			
		public void genreateRevision1()
			{
				
				initiator_chemicalstructure1 = new Initiator_ChemicalStructure(pathway, dataSource);
				initiator_chemicalstructure1.setTitle("Fadrozole");
				initiator_chemicalstructure1.getStructure2DImage().setValue("http://www.effectopedia.org/chem/fadrozole.png");
				initiator_chemicalstructure1.getIdentification().setPropertyValue(0, "102676313");
				initiator_chemicalstructure1.getIdentification().setPropertyValue(1, "4-(5,6,7,8-tetrahydroimidazo[1,5-a]pyridin-5-yl)benzonitrile");
				initiator_chemicalstructure1.getIdentification().setPropertyValue(2, "C1CC(N2C=NC=C2C1)C3=CC=C(C=C3)C#N");
				initiator_chemicalstructure1.getIdentification().setPropertyValue(3, "InChI=1S/C14H13N3/c15-8-11-4-6-12(7-5-11)14-3-1-2-13-9-16-10-17(13)14/h4-7,9-10,14H,1-3H2");
				initiator_chemicalstructure1.getIdentification().setPropertyValue(4, "CLPFFLWZZBQMAO-UHFFFAOYSA-N");
				initiator_chemicalstructure1.getIdentification().setPropertyValue(5, " ");
				initiator_chemicalstructure1.getIdentification().setPropertyValue(6, "C14H13N3");
				initiator_chemicalstructure1.setSynonymsList(new String[]
					{ " " });
					
				effect_molecularinitiatingevent3 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				effect_molecularinitiatingevent3.setTitle("Aromatase inhibition");
				effect_molecularinitiatingevent3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				effect_molecularinitiatingevent3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				effect_molecularinitiatingevent3.getDescriptionIDs()
						.set(new DescriptionSection(effect_molecularinitiatingevent3, dataSource, "Definition",
								"Inhibition of cytochrome P450 aromatase (CYP19; specifically cyp19a1a in fish). \n\nSite of action: The site of action for the molecular initiating event is the ovarian granulosa cells. \n\nWhile many vertebrates have a single isoform of aromatase, fish are known to have two isoforms. CYP19a1a is predominantly expressed in ovary while cyp19a1b is predominantly expressed in brain (Callard et al. 2001; Cheshenko et al. 2008). For the purposes of this MIE, when applied to fish, the assumed effect is on cyp19a1a. However, given that both isoforms show similar sensitivity to aromatase inhibitors (Hinfray et al. 2006) and catalyze the same reaction, discrimination of specific isoforms is not viewed as critical in relative to determining downstream key events resulting from aromatase inhibition in ovarian granulosa cells. \n\nResponses at the macromolecular level: Aromatase catalyzes three sequential oxidation steps (i.e., KEGG reactions R02501, R04761, R03087 or R01840, R04759, R02351; http://www.genome.jp/kegg/pathway.html) involved in the conversion of C-19 androgens (e.g., testosterone, androstenedione) to C-18 estrogens (e.g., 17 beta-estradiol, estrone). Aromatase inhibitors interfere with one or more of these reactions, leading to reduced efficiency in converting C-19 androgens into C-18 estrogens. Therefore, inhibition of aromatase activity results in decreased rate of 17 beta-estradiol (and presumably estrone) production by the ovary. \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								0);
				effect_molecularinitiatingevent3.getDescriptionIDs()
						.set(new DescriptionSection(effect_molecularinitiatingevent3, dataSource, "Measurment/detection",
								"Measurement/detection: Aromatase activity is typically measured by evaluating the production of tritiated water released upon the aromatase catalyzed conversion of radio-labeled androstenedione to estrone (Lephart and Simpson 1991). Aromatase activity can be measured in cell lines exposed in vitro (e.g., human placental JEG-3 cells and JAR choriocarcinoma cells, (Letcher et al. 1999); H295R human adrenocortical carcinoma cells (Sanderson et al. 2000)). Aromatase activity can also be quantified in tissue (i.e., ovary or brain) from vertebrates exposed in vivo (e.g., (Villeneuve et al. 2006; Ankley et al. 2002). In vitro aromatase assays are amenable to high throughput and have been included in nascent high throughput screening programs like the US EPA ToxcastTM program. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								1);
				effect_molecularinitiatingevent3.getDescriptionIDs()
						.set(new DescriptionSection(effect_molecularinitiatingevent3, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Aromatase (CYP19) orthologs are known to be present among most of the vertebrate lineage, at least down to the cartilaginous fishes. Orthologs have generally not been found in invertebrates, however, CYP19 was detected in the invertebrate chordate, amphioxus and analysis of conservation of gene order and content suggests a possible origin among primitive chordates (Castro et al. 2005). Fishes generally have two aromatase isoforms, cyp19a1a which is predominantly expressed in ovary and cyp19b, predominantly expressed in brain (Callard et al. 2001). Given that cyp19a1a is dominant isoform expressed in ovary and both isoforms appear to show similar sensitivity to aromatase inhibitors (Hinfray et al., 2006), for the purpose of this key event which focuses on gonadal aromatase activty, distinction of effects on one isoform versus the other are considered negligible. Total activity, without regard to isoform can be considered. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								2);
				effect_molecularinitiatingevent3.getDescriptionIDs()
						.set(new DescriptionSection(effect_molecularinitiatingevent3, dataSource, " Evidence for Chemical Initiation of this Molecular Initiating Event",
								" Characterization of chemical properties: Chemicals are known to inhibit aromatase activity through two primary molecular mechanisms. Steroid-like structures can inhibit the enzyme at its active site, with structures having ∆4 positioned double bonds generally acting as stronger inhibitors than those with ∆5 positioned double bonds (Petkov et al. 2009). Non-steroidal aromatase inhibitors generally act by interfering with electron transfer via the cytochrome P450 heme group of the aromatase enzyme, with greater nucleophilicity of the heteroatom contributing to greater potency as an inhibitor (Petkov et al. 2009). Petkov et al. (Petkov et al. 2009) have provided a detailed analysis of structural categorization of chemicals as potential steroidal or non-steroidal aromatase inhibitors. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								3);
				effect_molecularinitiatingevent3.getReferenceIDs()
						.add(new Reference(effect_molecularinitiatingevent3, dataSource,
								"Petkov PI, Temelkov S, Villeneuve DL, Ankley GT, Mekenyan OG. 2009. Mechanism-based categorization of aromatase inhibitors: a potential discovery and screening tool. SAR QSAR Environ Res 20(7-8): 657-678. ")
										.<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs()
						.add(new Reference(effect_molecularinitiatingevent3, dataSource, "Lephart ED, Simpson ER. 1991. Assay of aromatase activity. Methods Enzymol 206: 477-483. ").<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs()
						.add(new Reference(effect_molecularinitiatingevent3, dataSource,
								"Letcher RJ, van Holsteijn I, Drenth H-J, Norstrom RJ, Bergman A, Safe S, et al. 1999. Cytotoxicity and aromatase (CYP19) activity modulation by organochlorines in human placental JEG-3 and JAR choriocarcinoma cells. Toxico App Pharm 160: 10-20. ")
										.<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs()
						.add(new Reference(effect_molecularinitiatingevent3, dataSource,
								"Sanderson J, Seinen W, Giesy J, van den Berg M. 2000. 2-chloro-triazine herbicides induce aromatase (CYP19) activity in H295R human adrenocortical carcinoma cells: a novel mechanism for estrogenicity. Toxicol Sci 54: 121-127. ")
										.<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs()
						.add(new Reference(effect_molecularinitiatingevent3, dataSource,
								"Villeneuve DL, Knoebl I, Kahl MD, Jensen KM, Hammermeister DE, Greene KJ, et al. 2006. Relationship between brain and ovary aromatase activity and isoform-specific aromatase mRNA expression in the fathead minnow (Pimephales promelas). Aquat Toxicol 76(3-4): 353-368. ")
										.<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs()
						.add(new Reference(effect_molecularinitiatingevent3, dataSource,
								"Ankley GT, Kahl MD, Jensen KM, Hornung MW, Korte JJ, Makynen EA, et al. 2002. Evaluation of the aromatase inhibitor fadrozole in a short-term reproduction assay with the fathead minnow (Pimephales promelas). Toxicol Sci 67: 121-130. ")
										.<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs().add(new Reference(effect_molecularinitiatingevent3, dataSource,
						"Castro LF, Santos MM, Reis-Henriques MA. 2005. The genomic environment around the Aromatase gene: evolutionary insights. BMC Evol Biol 5: 43. ").<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs()
						.add(new Reference(effect_molecularinitiatingevent3, dataSource,
								"Callard GV, Tchoudakova AV, Kishida M, Wood E. 2001. Differential tissue distribution, developmental programming, estrogen regulation and promoter characteristics of cyp19 genes in teleost fish. J Ster Biochem Mol Biol 79: 305-314. ")
										.<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs()
						.add(new Reference(effect_molecularinitiatingevent3, dataSource,
								"Cheshenko K, Pakdel F, Segner H, Kah O, Eggen RI. Interference of endocrine disrupting chemicals with aromatase CYP19 expression or activity, and consequences for reproduction of teleost fish. Gen Comp Endocrinol. 2008 Jan 1;155(1):31-62. ")
										.<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs()
						.add(new Reference(effect_molecularinitiatingevent3, dataSource,
								"Hinfray N, Porcher JM, Brion F. Inhibition of rainbow trout (Oncorhynchus mykiss) P450 aromatase activities in brain and ovarian microsomes by various environmental substances. Comp Biochem Physiol C Toxicol Pharmacol. 2006 Nov;144(3):252-62 ")
										.<Reference> makeItLive());
				
				effect_downstreameffect5 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect5.setTitle("17beta-estradiol synthesis by ovarian granulosa cells, Reduction");
				effect_downstreameffect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				effect_downstreameffect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE.DIMENSION_INDEX, "adult");
				effect_downstreameffect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				effect_downstreameffect5.getDescriptionIDs()
						.set(new DescriptionSection(effect_downstreameffect5, dataSource, "Definition",
								"Like all steroids, estradiol is a cholesterol derivative. Estradiol synthesis in ovary is mediated by a number of enzyme catalyzed reactions involving cyp11 (cholesterol side chain cleavage enzyme), cyp 17 (17alpha-hydroxylase/17,20-lyase), 3beta hydroxysteroid dehyrogenase, 17beta hydroxysteroid dehydrogenase, and cyp19 (aromatase). Among those enzyme catalyzed reactions, conversion of testosterone to estradiol, catalyzed by aromatase, is considered to be rate limiting for estradiol synthesis. Within the ovary, aromatase expression and activity is primarily localized in the granulosa cells (reviewed in (Norris 2007; Yaron 1995; Havelock et al. 2004) and others). Reactions involved in synthesis of C-19 androgens are primarily localized in the theca cells and C-19 androgens diffuse from the theca into granulosa cells where aromatase can catalyze their conversion to C-18 estrogens. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								0);
				effect_downstreameffect5.getDescriptionIDs()
						.set(new DescriptionSection(effect_downstreameffect5, dataSource, "Measurment/detection",
								"Due to the importance of both theca and granulosa cells in ovarian steroidogenesis, it is generally impractical to measure E2 production by isolated granulosa cells (Havelock et al. 2004). However, this key event can be evaluated by examining E2 production by intact ovarian tissue explants either exposed to chemicals in vitro (e.g., (Villeneuve et al. 2007; McMaster ME 1995) or in vivo (i.e., via ex vivo steroidogenesis assay; e.g., (Ankley et al. 2007)). Estradiol released by ovarian tissue explants into media can be quantified by RIA (e.g., Jensen et al. 2001), ELISA, or analytical methods such as LC-MS (e.g., Owen et al. 2014). \n\nOECD TG 456 (OECD 2011) is the validated test guideline for an in vitro screen for chemical effects on steroidogenesis, specifically the production of 17beta-estradiol (E2) and testosterone (T). \n\nThe synthesis of E2 can be measured in vitro cultured ovarian cells. The methods for culturing mammalian ovarian cells can be found in the Database Service on Alternative Methods to animal experimentation (DB-ALM): Culture of Human Cumulus Granulosa Cells (EURL ECVAM Protocol No. 92, https://ecvam-dbalm.jrc.ec.europa.eu/methods-and-protocols?id_prot=266), Granulosa and Theca Cell Culture Systems (EURL ECVAM Method Summary No. 92, https://ecvam-dbalm.jrc.ec.europa.eu/methods-and-protocols?id_met=535). \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								1);
				effect_downstreameffect5.getDescriptionIDs()
						.set(new DescriptionSection(effect_downstreameffect5, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Key enzymes needed to synthesize 17β-estradiol first appear in the common ancestor of amphioxus and vertebrates (Baker 2011). Consequently, it is plausible that this key event is applicable to most vertebrates.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								2);
				effect_downstreameffect5.getReferenceIDs()
						.add(new Reference(effect_downstreameffect5, dataSource, "Norris DO. 2007. Vertebrate Endocrinology. Fourth ed. New York: Academic Press. ").<Reference> makeItLive());
				effect_downstreameffect5.getReferenceIDs()
						.add(new Reference(effect_downstreameffect5, dataSource, "Havelock JC, Rainey WE, Carr BR. 2004. Ovarian granulosa cell lines. Molecular and cellular endocrinology 228(1-2): 67-78. ")
								.<Reference> makeItLive());
				effect_downstreameffect5.getReferenceIDs().add(
						new Reference(effect_downstreameffect5, dataSource, "Yaron Z. 1995. Endocrine control of gametogenesis and spawning induction in the carp. Aquaculture 129: 49-73. ").<Reference> makeItLive());
				effect_downstreameffect5.getReferenceIDs()
						.add(new Reference(effect_downstreameffect5, dataSource,
								"Villeneuve DL, Ankley GT, Makynen EA, Blake LS, Greene KJ, Higley EB, et al. 2007. Comparison of fathead minnow ovary explant and H295R cell-based steroidogenesis assays for identifying endocrine-active chemicals. Ecotoxicol Environ Saf 68(1): 20-32. ")
										.<Reference> makeItLive());
				effect_downstreameffect5.getReferenceIDs()
						.add(new Reference(effect_downstreameffect5, dataSource,
								"McMaster ME MK, Jardine JJ, Robinson RD, Van Der Kraak GJ. 1995. Protocol for measuring in vitro steroid production by fish gonadal tissue. Canadian Technical Report of Fisheries and Aquatic Sciences 1961 1961: 1-78. ")
										.<Reference> makeItLive());
				
				effect_downstreameffect7 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect7.setTitle("Plasma 17beta-estradiol concentrations, Reduction");
				effect_downstreameffect7.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				effect_downstreameffect7.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE.DIMENSION_INDEX, "adult");
				effect_downstreameffect7.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				effect_downstreameffect7.getDescriptionIDs()
						.set(new DescriptionSection(effect_downstreameffect7, dataSource, "Definition",
								"Estradiol synthesized by the gonads is transported to other tissues via blood circulation. The gonads are generally considered to be the primary source of estrogens in systemic circulation.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								0);
				effect_downstreameffect7.getDescriptionIDs()
						.set(new DescriptionSection(effect_downstreameffect7, dataSource, "Measurment/detection",
								"Total concentrations of 17β-estradiol in plasma can be measured by radioimmunoassay (e.g., (Jensen et al. 2001)), enzyme-linked immunosorbent assay (available through many commercial vendors), or by analytical chemistry (e.g., LC/MS; Owen et al. 2014). Total steroid hormones are typically extracted from plasma or serum via liquid-liquid or solid phase extraction prior to analysis.\n\nGiven that there are numerous genes, like those coding for vertebrate vitellogenins, choriongenins, cyp19a1b, etc. which are known to be regulated by estrogen response elements, targeted qPCR or proteomic analysis of appropriate targets could also be used as an indirect measure of reduced circulating estrogen concentrations. However, further support for the specificity of the individual gene targets for estrogen-dependent regulation should be established in order to support their use.\n\nA line of transgenic zebrafish employing green fluorescence protein under control of estrogen response elements could also be used to provide direct evidence of altered estrogen, with decreased GFP signal in estrogen responsive tissues like liver, ovary, pituitary, and brain indicating a reduction in circulating estrogens (Gorelick and Halpern 2011). ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								1);
				effect_downstreameffect7.getDescriptionIDs()
						.set(new DescriptionSection(effect_downstreameffect7, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Key enzymes needed to synthesize 17β-estradiol first appear in the common ancestor of amphioxus and vertebrates (Baker 2011). Consequently, it is plausible that this key event is applicable to most vertebrates.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								2);
				effect_downstreameffect7.getReferenceIDs()
						.add(new Reference(effect_downstreameffect7, dataSource,
								"Jensen K, Korte J, Kahl M, Pasha M, Ankley G. 2001. Aspects of basic reproductive biology and endocrinology in the fathead minnow (Pimephales promelas). Comparative Biochemistry and Physiology Part C 128: 127-141.")
										.<Reference> makeItLive());
				effect_downstreameffect7.getReferenceIDs().add(new Reference(effect_downstreameffect7, dataSource,
						"Baker ME. 2011. Origin and diversification of steroids: co-evolution of enzymes and nuclear receptors. Molecular and cellular endocrinology 334(1-2): 14-20. ").<Reference> makeItLive());
				effect_downstreameffect7.getReferenceIDs()
						.add(new Reference(effect_downstreameffect7, dataSource,
								"Owen LJ, Wu FC, Keevil BG. 2014. A rapid direct assay for the routine measurement of oestradiol and oestrone by liquid chromatography tandem mass spectrometry. Ann. Clin. Biochem. 51(pt 3):360-367.")
										.<Reference> makeItLive());
				effect_downstreameffect7.getReferenceIDs()
						.add(new Reference(effect_downstreameffect7, dataSource,
								"Gorelick DA, Halpern ME. Visualization of estrogen receptor transcriptional activation in zebrafish. Endocrinology. 2011 Jul;152(7):2690-703. doi: 10.1210/en.2010-1257. Epub 2011 May 3. PubMed PMID: 21540282")
										.<Reference> makeItLive());
				
				effect_downstreameffect9 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect9.setTitle("Vitellogenin synthesis in liver, Reduction");
				effect_downstreameffect9.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				effect_downstreameffect9.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE.DIMENSION_INDEX, "adult");
				effect_downstreameffect9.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				effect_downstreameffect9.getDescriptionIDs()
						.set(new DescriptionSection(effect_downstreameffect9, dataSource, "Definition",
								"Vitellogenin is an egg yolk precursor protein synthesized by hepatocytes of oviparous vertebrates. In vertebrates, transcription of vitellogenin genes is predominantly regulated by estrogens via their action on nuclear estrogen receptors. During vitellogenic periods of the reproductive cycle, when circulating estrogen concentrations are high, vitellogenin transcription and synthesis are typically orders of magnitude greater than during non-reproductive conditions. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								0);
				effect_downstreameffect9.getDescriptionIDs()
						.set(new DescriptionSection(effect_downstreameffect9, dataSource, "Measurment/detection",
								"Relative abundance of vitellogenin transcripts or protein can be readily measured in liver tissue from organisms exposed in vivo (e.g., (Biales et al. 2007)), or in liver slices (e.g., (Schmieder et al. 2000) or hepatocytes (e.g., (Navas and Segner 2006) exposed in vitro, using real-time quantitative PCR (transcripts) or ELISA (protein). ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								1);
				effect_downstreameffect9.getDescriptionIDs()
						.set(new DescriptionSection(effect_downstreameffect9, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Oviparous vertebrates. Although vitellogenin is conserved among oviparous vertebrates and many invertebrates, liver is not a relevant tissue for the production of vitellogenin in invertebrates (Wahli 1988)")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								2);
				effect_downstreameffect9.getReferenceIDs()
						.add(new Reference(effect_downstreameffect9, dataSource,
								"Biales AD, Bencic DC, Lazorchak JL, Lattier DL. 2007. A quantitative real-time polymerase chain reaction method for the analysis of vitellogenin transcripts in model and nonmodel fish species. Environ Toxicol Chem 26(12): 2679-2686.")
										.<Reference> makeItLive());
				effect_downstreameffect9.getReferenceIDs()
						.add(new Reference(effect_downstreameffect9, dataSource,
								"Schmieder P, Tapper M, Linnum A, Denny J, Kolanczyk R, Johnson R. 2000. Optimization of a precision-cut trout liver tissue slice assay as a screen for vitellogenin induction: comparison of slice incubation techniques. Aquat Toxicol 49(4): 251-268. ")
										.<Reference> makeItLive());
				effect_downstreameffect9.getReferenceIDs()
						.add(new Reference(effect_downstreameffect9, dataSource,
								"Navas JM, Segner H. 2006. Vitellogenin synthesis in primary cultures of fish liver cells as endpoint for in vitro screening of the (anti)estrogenic activity of chemical substances. Aquat Toxicol 80(1): 1-22. ")
										.<Reference> makeItLive());
				effect_downstreameffect9.getReferenceIDs()
						.add(new Reference(effect_downstreameffect9, dataSource, "Wahli W. 1988. Evolution and expression of vitellogenin genes. Trends in Genetics. 4:227-232.").<Reference> makeItLive());
				
				effect_downstreameffect11 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect11.setTitle("Plasma vitellogenin concentrations, Reduction");
				effect_downstreameffect11.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				effect_downstreameffect11.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE.DIMENSION_INDEX, "adult");
				effect_downstreameffect11.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				effect_downstreameffect11.getDescriptionIDs()
						.set(new DescriptionSection(effect_downstreameffect11, dataSource, "Definition", "Vitellogenin synthesized in the liver is secreted into the blood and circulates to the ovaries for uptake. ")
								.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);
				effect_downstreameffect11.getDescriptionIDs()
						.set(new DescriptionSection(effect_downstreameffect11, dataSource, "Measurment/detection",
								"Vitellogenin concentrations in plasma are typically detected using enzyme linked Immunosorbent assay (ELISA; e.g., (Korte et al. 2000; Tyler et al. 1996; Holbech et al. 2001; Fenske et al. 2001). Although less specific and/or sensitive, determination of alkaline-labile phosphate or Western blotting has also been employed. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								1);
				effect_downstreameffect11.getDescriptionIDs()
						.set(new DescriptionSection(effect_downstreameffect11, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Oviparous vertebrates synthesize yolk precursor proteins that are transported in the circulation for uptake by developing oocytes. Many invertebrates also synthesize vitellogenins that are taken up into developing oocytes via active transport mechanisms. However, invertebrate vitellogenins are transported in hemolymph or via other transport mechanisms rather than plasma. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								2);
				effect_downstreameffect11.getReferenceIDs()
						.add(new Reference(effect_downstreameffect11, dataSource,
								"Korte JJ, Kahl MD, Jensen KM, Mumtaz SP, Parks LG, LeBlanc GA, et al. 2000. Fathead minnow vitellogenin: complementary DNA sequence and messenger RNA and protein expression after 17B-estradiol treatment. Environmental Toxicology and Chemistry 19(4): 972-981.")
										.<Reference> makeItLive());
				effect_downstreameffect11.getReferenceIDs()
						.add(new Reference(effect_downstreameffect11, dataSource,
								"Tyler C, van der Eerden B, Jobling S, Panter G, Sumpter J. 1996. Measurement of vitellogenin, a biomarker for exposure to oestrogenic chemicals, in a wide variety of cyprinid fish. Journal of Comparative Physiology and Biology 166: 418-426.")
										.<Reference> makeItLive());
				effect_downstreameffect11.getReferenceIDs()
						.add(new Reference(effect_downstreameffect11, dataSource, "Wahli W. 1988. Evolution and expression of vitellogenin genes. Trends in Genetics. 4:227-232.").<Reference> makeItLive());
				effect_downstreameffect11.getReferenceIDs()
						.add(new Reference(effect_downstreameffect11, dataSource,
								"Holbech H, Andersen L, Petersen GI, Korsgaard B, Pedersen KL, Bjerregaard P. Development of an ELISA for vitellogenin in whole body homogenate of zebrafish (Danio rerio). Comp Biochem Physiol C Toxicol Pharmacol. 2001 Sep;130(1):119-31.")
										.<Reference> makeItLive());
				effect_downstreameffect11.getReferenceIDs()
						.add(new Reference(effect_downstreameffect11, dataSource,
								"Fenske M, van Aerle R, Brack S, Tyler CR, Segner H. Development and validation of a homologous zebrafish (Danio rerio Hamilton-Buchanan) vitellogenin enzyme-linked immunosorbent assay (ELISA) and its application for studies on estrogenic chemicals. Comp Biochem Physiol C Toxicol Pharmacol. 2001. Jul;129(3):217-32.")
										.<Reference> makeItLive());
				
				effect_downstreameffect13 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect13.setTitle("Vitellogenin accumulation into oocytes and oocyte growth/development, Reduction");
				effect_downstreameffect13.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				effect_downstreameffect13.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE.DIMENSION_INDEX, "adult");
				effect_downstreameffect13.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				effect_downstreameffect13.getDescriptionIDs()
						.set(new DescriptionSection(effect_downstreameffect13, dataSource, "Definition",
								"Vitellogenin from the blood is selectively taken up by competent oocytes via receptor-mediated endocytosis. Although vitellogenin receptors mediate the uptake, opening of intercellular channels through the follicular layers to the oocyte surface as the oocyte reaches a “critical” size is thought to be a key trigger in allowing vitellogenin uptake (Tyler and Sumpter 1996). Once critical size is achieved, concentrations in the plasma and temperature are thought to impose the primary limits on uptake (Tyler and Sumpter 1996). Uptake of vitellogenin into oocytes causes considerable oocyte growth during vitellogenesis, accounting for up to 95% of the final egg size in many fish (Tyler and Sumpter 1996). Given the central role of vitellogenesis in oocyte maturation, vitellogenin accumulation is a prominent feature used in histological staging of oocytes (e.g., (Leino et al. 2005; Wolf et al. 2004).")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								0);
				effect_downstreameffect13.getDescriptionIDs()
						.set(new DescriptionSection(effect_downstreameffect13, dataSource, "Measurment/detection",
								"Relative vitellogenin accumulation can be evaluated qualitatively using routine histological approaches (Leino et al. 2005; Wolf et al. 2004). Oocyte size can be evaluated qualitatively or quantitatively using routine histological and light microscopy and/or imaging approaches.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								1);
				effect_downstreameffect13.getDescriptionIDs()
						.set(new DescriptionSection(effect_downstreameffect13, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Oviparous vertebrates and invertebrates. Although hormonal regulation of vitellogenin synthesis and mechanisms of vitellogenin transport from the site of synthesis to the ovary vary between vertebrates and invertebrates (Wahli 1988), in both vertebrates and invertebrates, vitellogenin is incorporated into oocytes and cleaved to form yolk proteins. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								2);
				effect_downstreameffect13.getReferenceIDs()
						.add(new Reference(effect_downstreameffect13, dataSource, "Tyler C, Sumpter J. 1996. Oocyte growth and development in teleosts. Reviews in Fish Biology and Fisheries 6: 287-318.")
								.<Reference> makeItLive());
				effect_downstreameffect13.getReferenceIDs()
						.add(new Reference(effect_downstreameffect13, dataSource,
								"Leino R, Jensen K, Ankley G. 2005. Gonadal histology and characteristic histopathology associated with endocrine disruption in the adult fathead minnow. Environmental Toxicology and Pharmacology 19: 85-98.")
										.<Reference> makeItLive());
				effect_downstreameffect13.getReferenceIDs()
						.add(new Reference(effect_downstreameffect13, dataSource,
								"Wolf JC, Dietrich DR, Friederich U, Caunter J, Brown AR. 2004. Qualitative and quantitative histomorphologic assessment of fathead minnow Pimephales promelas gonads as an endpoint for evaluating endocrine-active compounds: a pilot methodology study. Toxicol Pathol 32(5): 600-612.")
										.<Reference> makeItLive());
				
				effect_downstreameffect15 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect15.setTitle("Cumulative fecundity and spawning, Reduction");
				effect_downstreameffect15.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				effect_downstreameffect15.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE.DIMENSION_INDEX, "adult");
				effect_downstreameffect15.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				effect_downstreameffect15.getDescriptionIDs()
						.set(new DescriptionSection(effect_downstreameffect15, dataSource, "Definition",
								"Spawning refers to the release of eggs. Cumulative fecundity refers to the total number of eggs deposited by a female, or group of females over a specified period of time. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								0);
				effect_downstreameffect15.getDescriptionIDs()
						.set(new DescriptionSection(effect_downstreameffect15, dataSource, "Measurment/detection",
								"In laboratory-based reproduction assays (e.g., OECD 229; OECD 240), spawning and cumulative fecundity can be directly measured through daily observation of egg deposition and egg counts. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								1);
				effect_downstreameffect15.getDescriptionIDs().set(new DescriptionSection(effect_downstreameffect15, dataSource, "Evidence Supporting Taxonomic Applicability",
						"Cumulative fecundity and spawning can, in theory, be evaluated for any egg laying animal. ").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 2);
				effect_downstreameffect15.getDescriptionIDs()
						.set(new DescriptionSection(effect_downstreameffect15, dataSource, "Regulatory Examples Using This Adverse Outcome",
								"Cumulative fecundity is the most apical endpoint considered in the OECD 229 Fish Short Term Reproduction Assay. The OECD 229 assay serves as screening assay for endocrine disruption and associated reproductive impairment (OECD 2012). Fecundity is also an important apical endpoint in the Medaka Extended One Generation Reproduction Test (MEOGRT; OECD Test Guideline 240). ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								3);
				effect_downstreameffect15.getReferenceIDs()
						.add(new Reference(effect_downstreameffect15, dataSource, "OECD. 2012a. Test no. 229: Fish short term reproduction assay. Paris, France:Organization for Economic Cooperation and Development.")
								.<Reference> makeItLive());
				
				effect_adverseoutcome17 = new Effect_AdverseOutcome(pathway, dataSource);
				effect_adverseoutcome17.setTitle("Population trajectory, Decrease");
				effect_adverseoutcome17.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "population");
				effect_adverseoutcome17.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				effect_adverseoutcome17.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				effect_adverseoutcome17.getDescriptionIDs()
						.set(new DescriptionSection(effect_adverseoutcome17, dataSource, "Definition",
								"Maintenance of sustainable fish and wildlife populations (i.e., adequate to ensure long-term delivery of valued ecosystem services) is an accepted regulatory goal upon which risk assessments and risk management decisions are based.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								0);
				effect_adverseoutcome17.getDescriptionIDs()
						.set(new DescriptionSection(effect_adverseoutcome17, dataSource, "Measurment/detection",
								"Population trajectories, either hypothetical or site specific, can be estimated via population modeling based on measurements of vital rates or reasonable surrogates measured in laboratory studies. As an example, Miller and Ankley 2004 used measures of cumulative fecundity from laboratory studies with repeat spawning fish species to predict population-level consequences of continuous exposure. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								1);
				effect_adverseoutcome17.getDescriptionIDs().set(
						new DescriptionSection(effect_adverseoutcome17, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Consideration of population size and changes in population size over time is potentially relevant to all living organisms.").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
						2);
				effect_adverseoutcome17.getDescriptionIDs()
						.set(new DescriptionSection(effect_adverseoutcome17, dataSource, "Regulatory Examples Using This Adverse Outcome",
								"Maintenance of sustainable fish and wildlife populations (i.e., adequate to ensure long-term delivery of valued ecosystem services) is a widely accepted regulatory goal upon which risk assessments and risk management decisions are based.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								3);
				effect_adverseoutcome17.getReferenceIDs()
						.add(new Reference(effect_adverseoutcome17, dataSource,
								"Miller DH, Ankley GT. 2004. Modeling impacts on populations: fathead minnow (Pimephales promelas) exposure to the endocrine disruptor 17trenbolone as a case study. Ecotoxicology and Environmental Safety 59: 1-9.")
										.<Reference> makeItLive());
				
				initiator_chemicalstructure18 = new Initiator_ChemicalStructure(pathway, dataSource);
				initiator_chemicalstructure18.setTitle("Prochloraz");
				initiator_chemicalstructure18.getStructure2DImage()
						.setValue("https://apps.ideaconsult.net/ambit2/depict/cdk?search=O%3DC%28N%28CCOc1c%28Cl%29cc%28Cl%29cc1Cl%29CCC%29n2ccnc2&w=200&h=200&media=image/png");
				initiator_chemicalstructure18.getIdentification().setPropertyValue(0, "67747095");
				initiator_chemicalstructure18.getIdentification().setPropertyValue(1, "N-propyl-N-[2-(2,4,6-trichlorophenoxy)ethyl]imidazole-1-carboxamide");
				initiator_chemicalstructure18.getIdentification().setPropertyValue(2, "O=C(N(CCOc1c(Cl)cc(Cl)cc1Cl)CCC)n2ccnc2");
				initiator_chemicalstructure18.getIdentification().setPropertyValue(3, " ");
				initiator_chemicalstructure18.getIdentification().setPropertyValue(4, " ");
				initiator_chemicalstructure18.getIdentification().setPropertyValue(5, " ");
				initiator_chemicalstructure18.getIdentification().setPropertyValue(6, "");
				initiator_chemicalstructure18.setSynonymsList(new String[]
					{ " " });
					
				initiator_chemicalstructure20 = new Initiator_ChemicalStructure(pathway, dataSource);
				initiator_chemicalstructure20.setTitle("Letrozole");
				initiator_chemicalstructure20.getStructure2DImage()
						.setValue("https://apps.ideaconsult.net/ambit2/depict/cdk?search=C3%3DCC%28C%23N%29%3DCC%3DC3C%28C1%3DCC%3DC%28C%23N%29C%3DC1%29N2N%3DCN%3DC2&w=200&h=200&media=image/png");
				initiator_chemicalstructure20.getIdentification().setPropertyValue(0, "112809515");
				initiator_chemicalstructure20.getIdentification().setPropertyValue(1, "4-[(4-cyanophenyl)-(1,2,4-triazol-1-yl)methyl]benzonitrile");
				initiator_chemicalstructure20.getIdentification().setPropertyValue(2, "C3=CC(C#N)=CC=C3C(C1=CC=C(C#N)C=C1)N2N=CN=C2");
				initiator_chemicalstructure20.getIdentification().setPropertyValue(3, " ");
				initiator_chemicalstructure20.getIdentification().setPropertyValue(4, " ");
				initiator_chemicalstructure20.getIdentification().setPropertyValue(5, " ");
				initiator_chemicalstructure20.getIdentification().setPropertyValue(6, "");
				initiator_chemicalstructure20.setSynonymsList(new String[]
					{ " " });
					
				test_invitro22 = new Test_InVitro(pathway, dataSource);
				test_invitro22.setTitle("H295R");
				test_invitro22.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				test_invitro22.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				test_invivo23 = new Test_InVivo(pathway, dataSource);
				test_invivo23.setTitle("Aromatase inhibition in primary tissue in vivo");
				test_invivo23.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				test_invivo23.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				test_exvivo24 = new Test_ExVivo(pathway, dataSource);
				test_exvivo24.setTitle("Aromatase inhibition ex-vivo");
				test_exvivo24.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				test_exvivo24.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				test_insilico25 = new Test_InSilico(pathway, dataSource);
				test_insilico25.setTitle("HPG axis model aromatase inhibition");
				test_insilico25.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				test_insilico25.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				test_insilico25.getDescriptionIDs()
						.set(new DescriptionSection(test_insilico25, dataSource, "HPG axis model: aromatase inhibition",
								"<html><img src='http://effectopedia.org/rev/media/aromatase_inhibition.png'alt='image description'  width='215' height='101'><p>The HPG axis model perform prediction on estradiol and vitellogenin responses to aromatase inhibitor. In this part of the model, a mathematical description is provided for aromatase inhibitor to inhibit the conversion of testosterone to estradiol.</p></html>")
										.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(),
								0);
				test_insilico25.getDescriptionIDs().set(new DescriptionSection(test_insilico25, dataSource, "Methods and Materials", "http://www.effectopedia.org/rev/content/Methods_HPG.xhtml")
						.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 1);
				
				test_exvivo30 = new Test_ExVivo(pathway, dataSource);
				test_exvivo30.setTitle("Ex-vivo E2 production");
				test_exvivo30.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				test_exvivo30.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				test_insilico31 = new Test_InSilico(pathway, dataSource);
				test_insilico31.setTitle("In-silico Test Method Title");
				test_insilico31.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				test_insilico31.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				test_invivo34 = new Test_InVivo(pathway, dataSource);
				test_invivo34.setTitle("In-vivo Radio Immuno Assay");
				test_invivo34.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				test_invivo34.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				test_insilico35 = new Test_InSilico(pathway, dataSource);
				test_insilico35.setTitle("HPG axis model E2 Plasma concentration");
				test_insilico35.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				test_insilico35.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				test_insilico35.getDescriptionIDs()
						.set(new DescriptionSection(test_insilico35, dataSource, "HPG axis model: reduce circulating E2",
								"<html><img src='http://effectopedia.org/rev/media/aromatase%20inhibition.png'alt='image description' ><p>The HPG axis model perform prediction of E2 concentration in the plasma.</p></html>")
										.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(),
								0);
				
				test_invivo36 = new Test_InVivo(pathway, dataSource);
				test_invivo36.setTitle("In-vivo Real Time PCR");
				test_invivo36.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				test_invivo36.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				test_insilico37 = new Test_InSilico(pathway, dataSource);
				test_insilico37.setTitle("In-silico Test Method Title");
				test_insilico37.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				test_insilico37.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				test_invivo38 = new Test_InVivo(pathway, dataSource);
				test_invivo38.setTitle("In-vivo Radio Immuno Assay");
				test_invivo38.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				test_invivo38.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				test_insilico39 = new Test_InSilico(pathway, dataSource);
				test_insilico39.setTitle("HPG axis model Plasma VTG");
				test_insilico39.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				test_insilico39.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				test_invivo40 = new Test_InVivo(pathway, dataSource);
				test_invivo40.setTitle("In-vivo Histology");
				test_invivo40.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				test_invivo40.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				test_insilico41 = new Test_InSilico(pathway, dataSource);
				test_insilico41.setTitle("In-silico Test Method Title");
				test_insilico41.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				test_insilico41.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				test_invivo50 = new Test_InVivo(pathway, dataSource);
				test_invivo50.setTitle("In-vivo Reproduction Assay");
				test_invivo50.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				test_invivo50.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				test_insilico51 = new Test_InSilico(pathway, dataSource);
				test_insilico51.setTitle("In-silico Test Method Title");
				test_insilico51.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				test_insilico51.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				test_insilico54 = new Test_InSilico(pathway, dataSource);
				test_insilico54.setTitle("Predictive In-silico model");
				test_insilico54.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "population");
				test_insilico54.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				test_insilico54.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				
				test_invitro56 = new Test_InVitro(pathway, dataSource);
				test_invitro56.setTitle("NVS_ADME hCYP19A1");
				test_invitro56.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				test_invitro56.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				test_invitro59 = new Test_InVitro(pathway, dataSource);
				test_invitro59.setTitle("Tox21 Aromatase Inhibition");
				test_invitro59.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				test_invitro59.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				link_chemstructtomie2 = new Link_ChemStructToMIE(pathway, dataSource, initiator_chemicalstructure1, effect_molecularinitiatingevent3);
				link_chemstructtomie2.setLinkType(LinkType.UNKNOWN);
				link_effecttoeffect4 = new Link_EffectToEffect(pathway, dataSource, effect_molecularinitiatingevent3, effect_downstreameffect5);
				link_effecttoeffect4.setLinkType(LinkType.DIRECT);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect4_weigth1 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect4, dataSource, Link_EffectToEffect.class, 3.0);
				link_effecttoeffect4.getDescriptionIDs()
						.set(new DescriptionSection_Structured(link_effecttoeffect4, dataSource, "(Key) Event Relationships Weight of Evidences",
								"•  Biological Plausibility: \n\nWithin the ovary, aromatase expression and activity is primarily localized in the granulosa cells (reviewed in (Norris 2007; Yaron 1995; Havelock et al. 2004) and others). C-19 androgens diffuse from the theca cells into granulosa cells where aromatase can catalyze their conversion to C-18 estrogens. Therefore, inhibition of ovarian aromatase activity can generally be assumed to directly impact E2 synthesis by the granulosa cells.\n\n•  Empirical Support for Linkage:\n\nKnown aromatase inhibitors including fadrozole and prochloraz were shown to cause concentration-dependent inhibition of aromatase activity in fathead minnow ovary homogenates (Villeneuve et al. 2006; Ankley et al. 2005). \n\nFadrozole and prochloraz also cause concentration-dependent decreases in E2 production by fathead minnow ovary explants exposed in vitro (Villeneuve et al. 2007). \n\nFollowing in vivo exposure to fadrozole or prochloraz, ex vivo E2 production is significantly decreased in a concentration-dependent manner early in the time-course following exposure, although depending on the concentration, compensatory responses may offset the direct impact later in the exposure time-course (Villeneuve et al. 2006; Villeneuve et al. 2009; Ankley et al. 2009a; Skolness et al. 2011). \n\n•  Uncertainties or Inconsistencies:\n\nBased on the limited set of studies available to date, there are no known inconsistencies. \n\n",
								link_effecttoeffect4_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect4.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect4, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Aromatase (CYP19) orthologs are known to be present among most of the vertebrate lineage, at least down to the cartilaginous fishes. Orthologs have generally not been found in invertebrates, however, CYP19 was detected in the invertebrate chordate, amphioxus and analysis of conservation of gene order and content suggests a possible origin among primitive chordates (Castro et al. 2005). ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								2);
				link_effecttoeffect4.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect4, dataSource, "Quantitative Understading",
								"Several mechanistically-based models of ovarian steroidogenesis have been developed (Breen et al. 2013; Breen et al. 2007; Shoemaker et al. 2010; Quignot and Bois 2013). \n\nThe Breen et al. 2007 model was developed based on in vitro experiments with fathead minnow ovary tissue, and considers effects on steroidogenesis within the ovary only. \n\nThe Breen et al. 2013 model was developed based on in vivo time-course data for fathead minnow and incorporates prediction of compensatory responses resulting from feedback mechanisms operating as part of the hypothalamic-pituitary-gonadal axis. \n\nThe Shoemaker et al. 2010 model is chimeric and includes signaling pathways and aspects of transcriptional regulation based on a mixture of fish-specific and mammalian sources. \n\nThe Quignot and Bois 2013 model was designed to predict rat ovarian steroid secretion based on in vitro experiments with endocrine disrupting chemicals. \n\nThese may be adaptable to predict in vitro E2 production and/or plasma E2 concentrations from in vitro or in vivo measurements of aromatase inhibition. \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								3);
				link_effecttoeffect4.getReferenceIDs()
						.add(new Reference(link_effecttoeffect4, dataSource, "Norris DO. 2007. Vertebrate Endocrinology. Fourth ed. New York: Academic Press. ").<Reference> makeItLive());
				link_effecttoeffect4.getReferenceIDs()
						.add(new Reference(link_effecttoeffect4, dataSource, "Yaron Z. 1995. Endocrine control of gametogenesis and spawning induction in the carp. Aquaculture 129: 49-73. ").<Reference> makeItLive());
				link_effecttoeffect4.getReferenceIDs()
						.add(new Reference(link_effecttoeffect4, dataSource, "Havelock JC, Rainey WE, Carr BR. 2004. Ovarian granulosa cell lines. Molecular and cellular endocrinology 228(1-2): 67-78. ")
								.<Reference> makeItLive());
				link_effecttoeffect4.getReferenceIDs()
						.add(new Reference(link_effecttoeffect4, dataSource,
								"Villeneuve DL, Knoebl I, Kahl MD, Jensen KM, Hammermeister DE, Greene KJ, et al. 2006. Relationship between brain and ovary aromatase activity and isoform-specific aromatase mRNA expression in the fathead minnow (Pimephales promelas). Aquat Toxicol 76(3-4): 353-368. ")
										.<Reference> makeItLive());
				link_effecttoeffect4.getReferenceIDs()
						.add(new Reference(link_effecttoeffect4, dataSource,
								"Ankley GT, Jensen KM, Durhan EJ, Makynen EA, Butterworth BC, Kahl MD, et al. 2005. Effects of two fungicides with multiple modes of action on reproductive endocrine function in the fathead minnow (Pimephales promelas). Toxicol Sci 86(2): 300-308. ")
										.<Reference> makeItLive());
				link_effecttoeffect4.getReferenceIDs()
						.add(new Reference(link_effecttoeffect4, dataSource,
								"Villeneuve DL, Ankley GT, Makynen EA, Blake LS, Greene KJ, Higley EB, et al. 2007. Comparison of fathead minnow ovary explant and H295R cell-based steroidogenesis assays for identifying endocrine-active chemicals. Ecotoxicol Environ Saf 68(1): 20-32. ")
										.<Reference> makeItLive());
				link_effecttoeffect4.getReferenceIDs()
						.add(new Reference(link_effecttoeffect4, dataSource,
								"Villeneuve DL, Mueller ND, Martinovic D, Makynen EA, Kahl MD, Jensen KM, et al. 2009. Direct effects, compensation, and recovery in female fathead minnows exposed to a model aromatase inhibitor. Environ Health Perspect 117(4): 624-631. ")
										.<Reference> makeItLive());
				link_effecttoeffect4.getReferenceIDs()
						.add(new Reference(link_effecttoeffect4, dataSource,
								"Ankley GT, Bencic D, Cavallin JE, Jensen KM, Kahl MD, Makynen EA, et al. 2009a. Dynamic nature of alterations in the endocrine system of fathead minnows exposed to the fungicide prochloraz. Toxicol Sci 112(2): 344-353. ")
										.<Reference> makeItLive());
				link_effecttoeffect4.getReferenceIDs()
						.add(new Reference(link_effecttoeffect4, dataSource,
								"Skolness SY, Durhan EJ, Garcia-Reyero N, Jensen KM, Kahl MD, Makynen EA, et al. 2011. Effects of a short-term exposure to the fungicide prochloraz on endocrine function and gene expression in female fathead minnows (Pimephales promelas). Aquat Toxicol 103(3-4): 170-178. ")
										.<Reference> makeItLive());
				link_effecttoeffect4.getReferenceIDs()
						.add(new Reference(link_effecttoeffect4, dataSource,
								"Breen M, Villeneuve DL, Ankley GT, Bencic DC, Breen MS, Watanabe KH, et al. 2013. Developing Predictive Approaches to Characterize Adaptive Responses of the Reproductive Endocrine Axis to Aromatase Inhibition: II. Computational Modeling. Toxicological sciences : an official journal of the Society of Toxicology. ")
										.<Reference> makeItLive());
				link_effecttoeffect4.getReferenceIDs()
						.add(new Reference(link_effecttoeffect4, dataSource,
								"Breen MS, Villeneuve DL, Breen M, Ankley GT, Conolly RB. 2007. Mechanistic computational model of ovarian steroidogenesis to predict biochemical responses to endocrine active compounds. Annals of biomedical engineering 35(6): 970-981. ")
										.<Reference> makeItLive());
				link_effecttoeffect4.getReferenceIDs()
						.add(new Reference(link_effecttoeffect4, dataSource,
								"Shoemaker JE, Gayen K, Garcia-Reyero N, Perkins EJ, Villeneuve DL, Liu L, et al. 2010. Fathead minnow steroidogenesis: in silico analyses reveals tradeoffs between nominal target efficacy and robustness to cross-talk. BMC systems biology 4: 89. ")
										.<Reference> makeItLive());
				link_effecttoeffect4.getReferenceIDs()
						.add(new Reference(link_effecttoeffect4, dataSource,
								"Quignot N, Bois FY. 2013. A computational model to predict rat ovarian steroid secretion from in vitro experiments with endocrine disruptors. PloS one 8(1): e53891. ")
										.<Reference> makeItLive());
				
				link_effecttoeffect6 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect5, effect_downstreameffect7);
				link_effecttoeffect6.setLinkType(LinkType.DIRECT);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect6_weigth1 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect6, dataSource, Link_EffectToEffect.class, 3.0);
				link_effecttoeffect6.getDescriptionIDs()
						.set(new DescriptionSection_Structured(link_effecttoeffect6, dataSource, "(Key) Event Relationships Weight of Evidences",
								"•Biological Plausibility: \n\nWhile brain, interrenal, adipose, and breast tissue (in mammals) are capable of synthesizing estradiol, the gonads are generally considered the major source of circulating estrogens in vertebrates, including fish (Norris 2007). Consequently, if estradiol synthesis by ovarian granulosa cells is reduced, plasma E2 concentrations would be expected to decrease unless there are concurrent reductions in the rate of E2 catabolism. Synthesis in other tissues generally plays a paracrine role only, thus the contribution of other tissues to plasma E2 concentrations can generally be considered negligible. \n\n•Empirical Support for Linkage:\n\nFish \n\nIn multiple studies with aromatase inhibitors (e.g., fadrozole, prochloraz), significant reductions in ex vivo E2 production have been linked to, and shown to precede, reductions in circulating E2 concentrations (Villeneuve et al. 2009; Skolness et al. 2011). It is also notable that compensatory responses at the level of ex vivo steroid production (i.e., rate of E2 synthesis per unit mass of tissue) tend to precede recovery of plasma E2 concentrations following an initial insult (Villeneuve et al. 2009; Ankley et al. 2009a; Villeneuve et al. 2013). \n\nEx vivo E2 production by ovary tissue collected from female fish exposed to 30 or 300 µg ketoconazole/L showed significant decreases prior to significant effects on plasma estradiol being observed (Ankley et al. 2012). \n\nMammals \n\nMEHP /DEHP, mice, ex vivo DEHP (10 -100 µg/ml); MEHP (0.1 and 10 µg/ml) dose dependent reduction E2 production (Gupta et al., 2010) \n\nDEHP, rat, in vivo 300-600 mg/kg/day, dose dependent reduction of E2 plasma levels (Xu et al., 2010) \n\nEvidence for rodent and human models is summarized in the AOP Wiki: Relationship:45 > Aop:25 > Relationship:5: Table 1.  Summary of the experimental data for decrease E2 production and decreased E2 levels. IC50- half maximal inhibitory concentration values reported if available, otherwise the concentration at which the effect was observed:\n\nEvidence for rodent and human models is summarized in Table 1. \n\n<p>&nbsp;</p>\n\n<table border=\"1\">\n\n<tbody>\n\n<tr>\n\n<td><center>Compound class</center></td>\n\n<td><center>Species</center></td>\n\n<td><center>Study type</center></td>\n\n<td><center>Dose</center></td>\n\n<td><center>E2 production/levels</center></td>\n\n<td><center>Reference</center></td>\n\n</tr>\n\n<tr>\n\n<td><center>Phthalates (DEHP)</center><center></center></td>\n\n<td><center>rat</center></td>\n\n<td><center>ex vivo</center></td>\n\n<td><center>1500 mg/kg/day</center></td>\n\n<td><center>Reduced/increased E2 production in ovary culture</center></td>\n\n<td><center>(Laskey &amp; Berman, 1993)</center></td>\n\n</tr>\n\n<tr>\n\n<td><center>Phthalates (MEHP)</center><center></center></td>\n\n<td><center>rat</center><center></center></td>\n\n<td><center>in vitro</center></td>\n\n<td><center>From 50 &micro;M</center></td>\n\n<td><center>Reduced E2 production (concentration and time dependent in Granulosa cell)</center></td>\n\n<td><center>(Davis, Weaver, Gaines, &amp; Heindel, 1994)</center></td>\n\n</tr>\n\n<tr>\n\n<td><center>Phthalates (MEHP)</center><center></center></td>\n\n<td><center>rat</center><center></center></td>\n\n<td><center>in vitro</center></td>\n\n<td><center>100-200&micro;M</center></td>\n\n<td><center>reduction E2 production (dose dependent)</center></td>\n\n<td><center>(Lovekamp &amp; Davis, 2001)</center><center></center></td>\n\n</tr>\n\n<tr>\n\n<td><center>Phthalates (DEHP)</center><center></center></td>\n\n<td><center>rat</center></td>\n\n<td><center>in vivo</center></td>\n\n<td><center>300-600 mg/kg/day</center></td>\n\n<td><center>reduction E2 levels dose dependent</center></td>\n\n<td><center>(Xu et al., 2010),</center></td>\n\n</tr>\n\n<tr>\n\n<td><center>Phthalates (MEHP)</center><center></center></td>\n\n<td><center>human</center></td>\n\n<td><center>in vitro</center></td>\n\n<td><center>IC(50)= 49- 138 &micro;M (dependent on the stimulant)</center></td>\n\n<td><center>reduction E2 production (dose dependent)</center></td>\n\n<td><center>(Reinsberg, Wegener-Toper, van der Ven, van der Ven, &amp; Klingmueller, 2009)</center></td>\n\n</tr>\n\n<tr>\n\n<td><center>Phthalates (MEHP/DEHP)</center><center></center></td>\n\n<td><center>mice</center></td>\n\n<td><center>ex vivo</center></td>\n\n<td><center>DEHP (10 -100&nbsp;&mu;g/ml); MEHP (0.1 and 10&nbsp;&mu;g/ml)</center></td>\n\n<td><center>reduction E2 production (dose dependent)</center></td>\n\n<td><center>(Gupta et al., 2010)</center></td>\n\n</tr>\n\n</tbody>\n\n</table>\n\n<p>&nbsp;</p>\n\nTable 1. Summary of the experimental data for decrease E2 production and decreased E2 levels. IC50- half maximal inhibitory concentration values reported if available, otherwise the concentration at which the effect was observed. \n\n•Uncertainties or Inconsistencies:\n\nBased on the limited set of studies available to date, there are no known inconsistencies. \n\n",
								link_effecttoeffect6_weigth1).setFormat(ContentFormat.HTML).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect6.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect6, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Key enzymes needed to synthesize 17beta-estradiol first appear in the common ancestor of amphioxus and vertebrates (Baker 2011). While some E2 synthesis can occur in other tissues, the ovary is recognized as the major source of 17beta-estradiol synthesis in female vertebrates. Endocrine actions of ovarian E2 are facilitated through transport via the plasma. Consequently, this key event relationship is applicable to most female vertebrates. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								2);
				link_effecttoeffect6.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect6, dataSource, "Quantitative Understading",
								"At present we are unaware of any well established quantitative relationships between ex vivo E2 production (as an indirect measure of granulosa cell E2 synthesis) and plasma E2 concentrations. \n\nThere are considerable data available which might support the development of such a relationship. Additionally, there are a number of existing mathematical/computational models of ovarian steroidogenesis (Breen et al. 2013; Shoemaker et al. 2010) and/or physiologically-based pharmacokinetic models of the hypothalamic-pituitary-gonadal axis (e.g., (Li et al. 2011a) that may be adaptable to support a quantitative understanding of this linkage. \n\n•  The Breen et al. 2013 model was developed based on in vivo time-course data for fathead minnow and incorporates prediction of compensatory responses resulting from feedback mechanisms operating as part of the hypothalamic-pituitary-gonadal axis. \n\n•  The Shoemaker et al. 2010 model is chimeric and includes signaling pathways and aspects of transcriptional regulation based on a mixture of fish-specific and mammalian sources. \n\n•  The Li et al. 2011 model is a PBPK-based model that was calibrated from data from fathead minnows, including controls and fish exposed to either 17alpha ethynylestradiol or 17beta trenbolone. \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								3);
				link_effecttoeffect6.getReferenceIDs().add(new Reference(link_effecttoeffect6, dataSource, "Fish ").<Reference> makeItLive());
				link_effecttoeffect6.getReferenceIDs()
						.add(new Reference(link_effecttoeffect6, dataSource, "Norris DO. 2007. Vertebrate Endocrinology. Fourth ed. New York: Academic Press. ").<Reference> makeItLive());
				link_effecttoeffect6.getReferenceIDs()
						.add(new Reference(link_effecttoeffect6, dataSource,
								"Arukwe A, Goksoyr A. 2003. Eggshell and egg yolk proteins in fish: hepatic proteins for the next generation: oogenetic, population, and evolutionary implications of endocrine disruption. Comparative Hepatology 2(4): 1-21. ")
										.<Reference> makeItLive());
				link_effecttoeffect6.getReferenceIDs()
						.add(new Reference(link_effecttoeffect6, dataSource,
								"Skolness SY, Durhan EJ, Garcia-Reyero N, Jensen KM, Kahl MD, Makynen EA, et al. 2011. Effects of a short-term exposure to the fungicide prochloraz on endocrine function and gene expression in female fathead minnows (Pimephales promelas). Aquat Toxicol 103(3-4): 170-178. ")
										.<Reference> makeItLive());
				link_effecttoeffect6.getReferenceIDs()
						.add(new Reference(link_effecttoeffect6, dataSource,
								"Ankley GT, Bencic DC, Cavallin JE, Jensen KM, Kahl MD, Makynen EA, et al. 2009a. Dynamic nature of alterations in the endocrine system of fathead minnows exposed to the fungicide prochloraz. Toxicological sciences : an official journal of the Society of Toxicology 112(2): 344-353. ")
										.<Reference> makeItLive());
				link_effecttoeffect6.getReferenceIDs()
						.add(new Reference(link_effecttoeffect6, dataSource,
								"Villeneuve DL, Breen M, Bencic DC, Cavallin JE, Jensen KM, Makynen EA, et al. 2013. Developing Predictive Approaches to Characterize Adaptive Responses of the Reproductive Endocrine Axis to Aromatase Inhibition: I. Data Generation in a Small Fish Model. Toxicological sciences : an official journal of the Society of Toxicology. ")
										.<Reference> makeItLive());
				link_effecttoeffect6.getReferenceIDs()
						.add(new Reference(link_effecttoeffect6, dataSource,
								"Ankley GT, Cavallin JE, Durhan EJ, Jensen KM, Kahl MD, Makynen EA, et al. 2012. A time-course analysis of effects of the steroidogenesis inhibitor ketoconazole on components of the hypothalamic-pituitary-gonadal axis of fathead minnows. Aquatic toxicology 114-115: 88-95. ")
										.<Reference> makeItLive());
				link_effecttoeffect6.getReferenceIDs()
						.add(new Reference(link_effecttoeffect6, dataSource,
								"Shoemaker JE, Gayen K, Garcia-Reyero N, Perkins EJ, Villeneuve DL, Liu L, et al. 2010. Fathead minnow steroidogenesis: in silico analyses reveals tradeoffs between nominal target efficacy and robustness to cross-talk. BMC systems biology 4: 89. ")
										.<Reference> makeItLive());
				link_effecttoeffect6.getReferenceIDs()
						.add(new Reference(link_effecttoeffect6, dataSource,
								"Li Z, Kroll KJ, Jensen KM, Villeneuve DL, Ankley GT, Brian JV, et al. 2011a. A computational model of the hypothalamic: pituitary: gonadal axis in female fathead minnows (Pimephales promelas) exposed to 17alpha-ethynylestradiol and 17beta-trenbolone. BMC systems biology 5: 63. ")
										.<Reference> makeItLive());
				link_effecttoeffect6.getReferenceIDs().add(new Reference(link_effecttoeffect6, dataSource,
						"Baker ME. 2011. Origin and diversification of steroids: co-evolution of enzymes and nuclear receptors. Molecular and cellular endocrinology 334(1-2): 14-20. ").<Reference> makeItLive());
				link_effecttoeffect6.getReferenceIDs().add(new Reference(link_effecttoeffect6, dataSource, "Mammals ").<Reference> makeItLive());
				link_effecttoeffect6.getReferenceIDs()
						.add(new Reference(link_effecttoeffect6, dataSource,
								"Davis, B J, R Weaver, L J Gaines, and J J Heindel. 1994. â€œMono-(2-Ethylhexyl) Phthalate Suppresses Estradiol Production Independent of FSH-cAMP Stimulation in Rat Granulosa Cells.â€� Toxicology and Applied Pharmacology 128 (2) (October): 224â€“8. doi:10.1006/taap.1994.1201. ")
										.<Reference> makeItLive());
				link_effecttoeffect6.getReferenceIDs()
						.add(new Reference(link_effecttoeffect6, dataSource,
								"Gupta, Rupesh K, Jeffery M Singh, Tracie C Leslie, Sharon Meachum, Jodi a Flaws, and Humphrey H-C Yao. 2010. â€œDi-(2-Ethylhexyl) Phthalate and Mono-(2-Ethylhexyl) Phthalate Inhibit Growth and Reduce Estradiol Levels of Antral Follicles in Vitro.â€� Toxicology and Applied Pharmacology 242 (2) (January 15): 224â€“30. doi:10.1016/j.taap.2009.10.011. ")
										.<Reference> makeItLive());
				link_effecttoeffect6.getReferenceIDs()
						.add(new Reference(link_effecttoeffect6, dataSource,
								"Laskey, J.W., and E. Berman. 1993. â€œSteroidogenic Assessment Using Ovary Culture in Cycling Rats: Effects of Bis (2-Diethylhexyl) Phthalate on Ovarian Steroid Production.â€� Reproductive Toxicology 7 (1) (January): 25â€“33. doi:10.1016/0890-6238(93)90006-S. ")
										.<Reference> makeItLive());
				link_effecttoeffect6.getReferenceIDs()
						.add(new Reference(link_effecttoeffect6, dataSource,
								"Lovekamp, T N, and B J Davis. 2001. â€œMono-(2-Ethylhexyl) Phthalate Suppresses Aromatase Transcript Levels and Estradiol Production in Cultured Rat Granulosa Cells.â€� Toxicology and Applied Pharmacology 172 (3) (May 1): 217â€“24. doi:10.1006/taap.2001.9156. ")
										.<Reference> makeItLive());
				link_effecttoeffect6.getReferenceIDs()
						.add(new Reference(link_effecttoeffect6, dataSource,
								"Reinsberg, Jochen, Petra Wegener-Toper, Katrin van der Ven, Hans van der Ven, and Dietrich Klingmueller. 2009. â€œEffect of Mono-(2-Ethylhexyl) Phthalate on Steroid Production of Human Granulosa Cells.â€� Toxicology and Applied Pharmacology 239 (1) (August 15): 116â€“23. doi:10.1016/j.taap.2009.05.022. ")
										.<Reference> makeItLive());
				link_effecttoeffect6.getReferenceIDs()
						.add(new Reference(link_effecttoeffect6, dataSource,
								"Xu, Chuan, Ji-An Chen, Zhiqun Qiu, Qing Zhao, Jiaohua Luo, Lan Yang, Hui Zeng, et al. 2010. â€œOvotoxicity and PPAR-Mediated Aromatase Downregulation in Female Sprague-Dawley Rats Following Combined Oral Exposure to Benzo[a]pyrene and Di-(2-Ethylhexyl) Phthalate.â€� Toxicology Letters 199 (3) (December 15): 323â€“32. doi:10.1016/j.toxlet.2010.09.015. ")
										.<Reference> makeItLive());
				
				link_effecttoeffect8 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect7, effect_downstreameffect9);
				link_effecttoeffect8.setLinkType(LinkType.DIRECT);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect8_weigth1 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect8, dataSource, Link_EffectToEffect.class, 3.0);
				link_effecttoeffect8.getDescriptionIDs()
						.set(new DescriptionSection_Structured(link_effecttoeffect8, dataSource, "(Key) Event Relationships Weight of Evidences",
								"\n\n•Biological Plausibility: \n\nVitellogenin synthesis in fish is localized in the liver and is well documented to be regulated by estrogens via interaction with estrogen receptors (Tyler et al. 1996; Tyler and Sumpter 1996; Arukwe and Goksoyr 2003). The vitellogenin gene contains estrogen repsonsive elements in its promoter region and site directed mutagenesis has shown these to be essential for estrogen-dependent expression of vitellogenin (Chang et al. 1992; Teo et al. 1998). Liver is not regarded as a major site of E2 synthesis (Norris 2007), therefore the majority of E2 in liver comes from the circulation. \n\nEstrogen regulates expression of the vitellogenin gene in the amphibian Xenopus laevis (Skipper and Hamilton, 1977). \n\n•Empirical Support for Linkage:\n\nIn a number of time-course experiments with aromatase inhibitors (e.g., fadrozole, prochloraz), decreases in plasma estradiol concentrations precede decreases in plasma vitellogenin concentrations (Villeneuve et al. 2009; Skolness et al. 2011; Ankley et al. 2009b). Recovery of plasma E2 concentrations also precedes recovery of plasma VTG concentrations after cessation of exposure (Villeneuve et al. 2009; Ankley et al. 2009a; Villeneuve et al. 2013). \n\nIt was demonstrated in Danio rerio that in vivo exposure to the aromatase inhibitor letrozole significantly reduced the expression of mRNA transcripts coding for vtg1, vtg2, and er_alpha, all of which are known to be regulated by estrogens (Sun et al. 2010). However, similar effects were not observed in primary cultured hepatocytes from Danio rerio, indicating that letrozole's effects on vtg transcription were not direct. \n\nMany studies have demonstrated that exposure of hepatocytes to estrogens in vitro or in vivo induce vitellogenin mRNA synthesis (e.g., see reviews by (Navas and Segner 2006; Iguchi et al. 2006)). \n\nIn female fathead minnows exposed to 17 beta-trenbolone, significant reductions in plasma E2 concentrations preceded significant reductions in plasma VTG (Ekman et al. 2011). \n\nIntra-arterial injection of the estrogen 17 alpha ethynyl estradiol into male rainbow trout causes vitellogenin induction with about a 12 h lag time before increasing from basal levels (Schultz et al. 2001). \n\n•Uncertainties or Inconsistencies:\n\nBased on the limited set of studies available to date, there are no known inconsistencies. \n\n",
								link_effecttoeffect8_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect8.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect8, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Key enzymes needed to synthesize 17beta-estradiol first appear in the common ancestor of amphioxus and vertebrates (Baker 2011). However, non-oviparous vertebrates do not require vitellogenin. Consequently, this KER is applicable to oviparous vertebrates. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								2);
				link_effecttoeffect8.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect8, dataSource, "Quantitative Understading",
								"At least two computational models that include functions which link circulating concentrations of E2 to VTG production by the liver have been published (Li et al. 2011a; Murphy et al. 2005; Murphy et al. 2009), although both models focus on predicting plasma VTG concentrations rather than transcription or translation within the liver. A significant positive correlation (r=0.87) between plasma E2 concentrations corresponding plasma VTG concentrations in female fathead minnows held under laboratory conditions has also been reported (Ankley et al. 2008). \n\nThere are multiple isoforms of vitellogenin. The sensitivity and inducibility of each of those isoforms may vary somewhat. Consequently, response-response relationships may vary somewhat depending on the speicific isoform for which QPCR primers or antibodies were developed.\n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								3);
				link_effecttoeffect8.getReferenceIDs()
						.add(new Reference(link_effecttoeffect8, dataSource, "Tyler C, Sumpter J. 1996. Oocyte growth and development in teleosts. Reviews in Fish Biology and Fisheries 6: 287-318. ")
								.<Reference> makeItLive());
				link_effecttoeffect8.getReferenceIDs()
						.add(new Reference(link_effecttoeffect8, dataSource,
								"Tyler C, van der Eerden B, Jobling S, Panter G, Sumpter J. 1996. Measurement of vitellogenin, a biomarker for exposure to oestrogenic chemicals, in a wide variety of cyprinid fish. Journal of Comparative Physiology and Biology 166: 418-426. ")
										.<Reference> makeItLive());
				link_effecttoeffect8.getReferenceIDs()
						.add(new Reference(link_effecttoeffect8, dataSource,
								"Arukwe A, GoksÃ¸yr A. 2003. Eggshell and egg yolk proteins in fish: hepatic proteins for the next generation: oogenetic, population, and evolutionary implications of endocrine disruption. Comparative Hepatology 2(4): 1-21. ")
										.<Reference> makeItLive());
				link_effecttoeffect8.getReferenceIDs()
						.add(new Reference(link_effecttoeffect8, dataSource, "Norris DO. 2007. Vertebrate Endocrinology. Fourth ed. New York: Academic Press. ").<Reference> makeItLive());
				link_effecttoeffect8.getReferenceIDs()
						.add(new Reference(link_effecttoeffect8, dataSource,
								"Villeneuve DL, Mueller ND, Martinovic D, Makynen EA, Kahl MD, Jensen KM, et al. 2009. Direct effects, compensation, and recovery in female fathead minnows exposed to a model aromatase inhibitor. Environ Health Perspect 117(4): 624-631. ")
										.<Reference> makeItLive());
				link_effecttoeffect8.getReferenceIDs()
						.add(new Reference(link_effecttoeffect8, dataSource,
								"Skolness SY, Durhan EJ, Garcia-Reyero N, Jensen KM, Kahl MD, Makynen EA, et al. 2011. Effects of a short-term exposure to the fungicide prochloraz on endocrine function and gene expression in female fathead minnows (Pimephales promelas). Aquat Toxicol 103(3-4): 170-178. ")
										.<Reference> makeItLive());
				link_effecttoeffect8.getReferenceIDs()
						.add(new Reference(link_effecttoeffect8, dataSource,
								"Ankley GT, Bencic D, Cavallin JE, Jensen KM, Kahl MD, Makynen EA, et al. 2009b. Dynamic nature of alterations in the endocrine system of fathead minnows exposed to the fungicide prochloraz. Toxicol Sci 112(2): 344-353. ")
										.<Reference> makeItLive());
				link_effecttoeffect8.getReferenceIDs()
						.add(new Reference(link_effecttoeffect8, dataSource,
								"Ankley GT, Bencic DC, Cavallin JE, Jensen KM, Kahl MD, Makynen EA, et al. 2009a. Dynamic nature of alterations in the endocrine system of fathead minnows exposed to the fungicide prochloraz. Toxicological sciences : an official journal of the Society of Toxicology 112(2): 344-353. ")
										.<Reference> makeItLive());
				link_effecttoeffect8.getReferenceIDs()
						.add(new Reference(link_effecttoeffect8, dataSource,
								"Villeneuve DL, Breen M, Bencic DC, Cavallin JE, Jensen KM, Makynen EA, et al. 2013. Developing Predictive Approaches to Characterize Adaptive Responses of the Reproductive Endocrine Axis to Aromatase Inhibition: I. Data Generation in a Small Fish Model. Toxicological sciences : an official journal of the Society of Toxicology. ")
										.<Reference> makeItLive());
				link_effecttoeffect8.getReferenceIDs()
						.add(new Reference(link_effecttoeffect8, dataSource,
								"Sun L, Wen L, Shao X, Qian H, Jin Y, Liu W, et al. 2010. Screening of chemicals with anti-estrogenic activity using in vitro and in vivo vitellogenin induction responses in zebrafish (Danio rerio). Chemosphere 78(7): 793-799. ")
										.<Reference> makeItLive());
				link_effecttoeffect8.getReferenceIDs()
						.add(new Reference(link_effecttoeffect8, dataSource,
								"Iguchi T, Irie F, Urushitani H, Tooi O, Kawashima Y, Roberts M, et al. 2006. Availability of in vitro vitellogenin assay for screening of estrogenic and anti-estrogenic activities of environmental chemicals. Environ Sci 13(3): 161-183. ")
										.<Reference> makeItLive());
				link_effecttoeffect8.getReferenceIDs()
						.add(new Reference(link_effecttoeffect8, dataSource,
								"Navas JM, Segner H. 2006. Vitellogenin synthesis in primary cultures of fish liver cells as endpoint for in vitro screening of the (anti)estrogenic activity of chemical substances. Aquat Toxicol 80(1): 1-22. ")
										.<Reference> makeItLive());
				link_effecttoeffect8.getReferenceIDs()
						.add(new Reference(link_effecttoeffect8, dataSource,
								"Ekman DR, Villeneuve DL, Teng Q, Ralston-Hooper KJ, Martinovic-Weigelt D, Kahl MD, et al. 2011. Use of gene expression, biochemical and metabolite profiles to enhance exposure and effects assessment of the model androgen 17beta-trenbolone in fish. Environmental toxicology and chemistry / SETAC 30(2): 319-329. ")
										.<Reference> makeItLive());
				link_effecttoeffect8.getReferenceIDs()
						.add(new Reference(link_effecttoeffect8, dataSource,
								"Schultz IR, Orner G, Merdink JL, Skillman A. 2001. Dose-response relationships and pharmacokinetics of vitellogenin in rainbow trout after intravascular administration of 17alpha-ethynylestradiol. Aquatic toxicology 51(3): 305-318. ")
										.<Reference> makeItLive());
				link_effecttoeffect8.getReferenceIDs()
						.add(new Reference(link_effecttoeffect8, dataSource,
								"Li Z, Kroll KJ, Jensen KM, Villeneuve DL, Ankley GT, Brian JV, et al. 2011a. A computational model of the hypothalamic: pituitary: gonadal axis in female fathead minnows (Pimephales promelas) exposed to 17alpha-ethynylestradiol and 17beta-trenbolone. BMC systems biology 5: 63. ")
										.<Reference> makeItLive());
				link_effecttoeffect8.getReferenceIDs()
						.add(new Reference(link_effecttoeffect8, dataSource,
								"Murphy CA, Rose KA, Rahman MS, Thomas P. 2009. Testing and applying a fish vitellogenesis model to evaluate laboratory and field biomarkers of endocrine disruption in Atlantic croaker (Micropogonias undulatus) exposed to hypoxia. Environmental toxicology and chemistry / SETAC 28(6): 1288-1303. ")
										.<Reference> makeItLive());
				link_effecttoeffect8.getReferenceIDs()
						.add(new Reference(link_effecttoeffect8, dataSource,
								"Murphy CA, Rose KA, Thomas P. 2005. Modeling vitellogenesis in female fish exposed to environmental stressors: predicting the effects of endocrine disturbance due to exposure to a PCB mixture and cadmium. Reproductive toxicology 19(3): 395-409. ")
										.<Reference> makeItLive());
				link_effecttoeffect8.getReferenceIDs()
						.add(new Reference(link_effecttoeffect8, dataSource,
								"Ankley GT, Miller DH, Jensen KM, Villeneuve DL, Martinovic D. 2008. Relationship of plasma sex steroid concentrations in female fathead minnows to reproductive success and population status. Aquatic toxicology 88(1): 69-74. ")
										.<Reference> makeItLive());
				link_effecttoeffect8.getReferenceIDs()
						.add(new Reference(link_effecttoeffect8, dataSource, "Skipper JK, Hamilton TH. 1977. Regulation by estrogen of the vitellogenin gene. Proc Natl Acad Sci USA 74:2384-2388. ")
								.<Reference> makeItLive());
				link_effecttoeffect8.getReferenceIDs()
						.add(new Reference(link_effecttoeffect8, dataSource,
								"Chang TC, Nardulli AM, Lew D, and Shapiro, DJ. 1992. The role of estrogen response elements in expression of the Xenopus laevis vitellogenin B1 gene. Molecular Endocrinology 6:3, 346-354")
										.<Reference> makeItLive());
				link_effecttoeffect8.getReferenceIDs().add(new Reference(link_effecttoeffect8, dataSource,
						"Teo BY, Tan NS, Lim EH, Lam TJ, Ding JL. A novel piscine vitellogenin gene: structural and functional analyses of estrogen-inducible promoter. Mol Cell ").<Reference> makeItLive());
				link_effecttoeffect8.getReferenceIDs().add(new Reference(link_effecttoeffect8, dataSource, "Endocrinol. 1998 Nov 25;146(1-2):103-20. PubMed PMID: 10022768. ").<Reference> makeItLive());
				
				link_effecttoeffect10 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect9, effect_downstreameffect11);
				link_effecttoeffect10.setLinkType(LinkType.DIRECT);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect10_weigth1 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect10, dataSource, Link_EffectToEffect.class, 3.0);
				link_effecttoeffect10.getDescriptionIDs()
						.set(new DescriptionSection_Structured(link_effecttoeffect10, dataSource, "(Key) Event Relationships Weight of Evidences",
								"•Biological Plausibility: \n\nLiver is the major source of VTG protein production in fish (Tyler and Sumpter 1996; Arukwe and GoksÃ¸yr 2003). Protein production involves transcription and subsequent translation. The time-lag between decreases in transcription/translation and decreases in plasma VTG concentrations can be expected to be dependent on vitellogenin elimination half-lives. \n\n•Empirical Support for Linkage:\n\nIn a number of time-course experiments with aromatase inhibitors, decreases in plasma estradiol concentrations precede decreases in plasma vitellogenin concentrations (Villeneuve et al. 2009; Skolness et al. 2011; Ankley et al. 2009b). Recovery of plasma E2 concentrations also precedes recovery of plasma VTG concentrations after cessation of exposure (Villeneuve et al. 2009; Ankley et al. 2009a; Villeneuve et al. 2013). \n\nIn experiments with strong estrogens, increases in vtg mRNA synthesis precede increases in plasma VTG concentration (Korte et al. 2000; Schmid et al. 2002). \n\nElimination half-lives for VTG protein have been determined for induced male fish, but to our knowledge, similar kinetic studies have not been done for reproductively mature females (Korte et al. 2000; Schultz et al. 2001). \n\nIn male sheepshead minnows injected with E2, induction of VTG mRNA precedes induction of plasma VTG (Bowman et al. 2000). \n\nIn male Cichlasoma dimerus exposed to octylphenol for 28 days and then held in clean water, decline in induced VTG mRNA concentrations precedes declines in induced plasma VTG concentrations (Genovese et al. 2012). \n\n•Uncertainties or Inconsistencies:\n\nThere are no known inconsistencies between these KERs which are not readily explained on the basis of the expected dose, temporal, and incidence relationships between these two KERs. This applies across a significant body of literature in which these two KEs have been measured. \n\n",
								link_effecttoeffect10_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect10.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect10, dataSource, "Evidence Supporting Taxonomic Applicability",
								"This KER primarily applies to taxa that synthesize vitellogenin in the liver which is transported elsewhere in the body via plasma. ").setFormat(ContentFormat.TEXT)
										.<DescriptionSection> makeItLive(),
								2);
				link_effecttoeffect10.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect10, dataSource, "Quantitative Understading",
								"Due to temporal disconnects (lag) between induction of mRNA transcription and translation and significant changes in plasma concentrations as well as variable rates of uptake of VTG from plasma into oocytes, a precise quantitative relationship between VTG transcription/translation and circulating VTG concentrations has not been described. However, models and statistical relationships that define quantitative relationships between circulating E2 concentrations and circulating VTG concentrations have been developed (Li et al. 2011a; Murphy et al. 2005; Murphy et al. 2009; Ankley et al. 2008).")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								3);
				link_effecttoeffect10.getReferenceIDs()
						.add(new Reference(link_effecttoeffect10, dataSource, "Tyler C, Sumpter J. 1996. Oocyte growth and development in teleosts. Reviews in Fish Biology and Fisheries 6: 287-318. ")
								.<Reference> makeItLive());
				link_effecttoeffect10.getReferenceIDs()
						.add(new Reference(link_effecttoeffect10, dataSource,
								"Arukwe A, GoksÃ¸yr A. 2003. Eggshell and egg yolk proteins in fish: hepatic proteins for the next generation: oogenetic, population, and evolutionary implications of endocrine disruption. Comparative Hepatology 2(4): 1-21. ")
										.<Reference> makeItLive());
				link_effecttoeffect10.getReferenceIDs()
						.add(new Reference(link_effecttoeffect10, dataSource,
								"Villeneuve DL, Mueller ND, Martinovic D, Makynen EA, Kahl MD, Jensen KM, et al. 2009. Direct effects, compensation, and recovery in female fathead minnows exposed to a model aromatase inhibitor. Environ Health Perspect 117(4): 624-631. ")
										.<Reference> makeItLive());
				link_effecttoeffect10.getReferenceIDs()
						.add(new Reference(link_effecttoeffect10, dataSource,
								"Skolness SY, Durhan EJ, Garcia-Reyero N, Jensen KM, Kahl MD, Makynen EA, et al. 2011. Effects of a short-term exposure to the fungicide prochloraz on endocrine function and gene expression in female fathead minnows (Pimephales promelas). Aquat Toxicol 103(3-4): 170-178. ")
										.<Reference> makeItLive());
				link_effecttoeffect10.getReferenceIDs()
						.add(new Reference(link_effecttoeffect10, dataSource,
								"Ankley GT, Bencic D, Cavallin JE, Jensen KM, Kahl MD, Makynen EA, et al. 2009b. Dynamic nature of alterations in the endocrine system of fathead minnows exposed to the fungicide prochloraz. Toxicol Sci 112(2): 344-353. ")
										.<Reference> makeItLive());
				link_effecttoeffect10.getReferenceIDs()
						.add(new Reference(link_effecttoeffect10, dataSource,
								"Ankley GT, Bencic DC, Cavallin JE, Jensen KM, Kahl MD, Makynen EA, et al. 2009a. Dynamic nature of alterations in the endocrine system of fathead minnows exposed to the fungicide prochloraz. Toxicological sciences : an official journal of the Society of Toxicology 112(2): 344-353. ")
										.<Reference> makeItLive());
				link_effecttoeffect10.getReferenceIDs()
						.add(new Reference(link_effecttoeffect10, dataSource,
								"Villeneuve DL, Breen M, Bencic DC, Cavallin JE, Jensen KM, Makynen EA, et al. 2013. Developing Predictive Approaches to Characterize Adaptive Responses of the Reproductive Endocrine Axis to Aromatase Inhibition: I. Data Generation in a Small Fish Model. Toxicological sciences : an official journal of the Society of Toxicology. ")
										.<Reference> makeItLive());
				link_effecttoeffect10.getReferenceIDs()
						.add(new Reference(link_effecttoeffect10, dataSource,
								"Korte JJ, Kahl MD, Jensen KM, Mumtaz SP, Parks LG, LeBlanc GA, et al. 2000. Fathead minnow vitellogenin: complementary DNA sequence and messenger RNA and protein expression after 17B-estradiol treatment. Environmental Toxicology and Chemistry 19(4): 972-981. ")
										.<Reference> makeItLive());
				link_effecttoeffect10.getReferenceIDs()
						.add(new Reference(link_effecttoeffect10, dataSource,
								"Schmid T, Gonzalez-Valero J, Rufli H, Dietrich DR. 2002. Determination of vitellogenin kinetics in male fathead minnows (Pimephales promelas). Toxicol Lett 131(1-2): 65-74. ")
										.<Reference> makeItLive());
				link_effecttoeffect10.getReferenceIDs()
						.add(new Reference(link_effecttoeffect10, dataSource,
								"Schultz IR, Orner G, Merdink JL, Skillman A. 2001. Dose-response relationships and pharmacokinetics of vitellogenin in rainbow trout after intravascular administration of 17alpha-ethynylestradiol. Aquatic toxicology 51(3): 305-318. ")
										.<Reference> makeItLive());
				link_effecttoeffect10.getReferenceIDs()
						.add(new Reference(link_effecttoeffect10, dataSource,
								"Bowman CJ, Kroll KJ, Hemmer MJ, Folmar LC, Denslow ND. 2000. Estrogen-induced vitellogenin mRNA and protein in sheepshead minnow (Cyprinodon variegatus). General and comparative endocrinology 120(3): 300-313. ")
										.<Reference> makeItLive());
				link_effecttoeffect10.getReferenceIDs()
						.add(new Reference(link_effecttoeffect10, dataSource,
								"Genovese G, Regueira M, Piazza Y, Towle DW, Maggese MC, Lo Nostro F. 2012. Time-course recovery of estrogen-responsive genes of a cichlid fish exposed to waterborne octylphenol. Aquatic toxicology 114-115: 1-13. ")
										.<Reference> makeItLive());
				link_effecttoeffect10.getReferenceIDs()
						.add(new Reference(link_effecttoeffect10, dataSource,
								"Li Z, Kroll KJ, Jensen KM, Villeneuve DL, Ankley GT, Brian JV, et al. 2011a. A computational model of the hypothalamic: pituitary: gonadal axis in female fathead minnows (Pimephales promelas) exposed to 17alpha-ethynylestradiol and 17beta-trenbolone. BMC systems biology 5: 63. ")
										.<Reference> makeItLive());
				link_effecttoeffect10.getReferenceIDs()
						.add(new Reference(link_effecttoeffect10, dataSource,
								"Murphy CA, Rose KA, Rahman MS, Thomas P. 2009. Testing and applying a fish vitellogenesis model to evaluate laboratory and field biomarkers of endocrine disruption in Atlantic croaker (Micropogonias undulatus) exposed to hypoxia. Environmental toxicology and chemistry / SETAC 28(6): 1288-1303. ")
										.<Reference> makeItLive());
				link_effecttoeffect10.getReferenceIDs()
						.add(new Reference(link_effecttoeffect10, dataSource,
								"Murphy CA, Rose KA, Thomas P. 2005. Modeling vitellogenesis in female fish exposed to environmental stressors: predicting the effects of endocrine disturbance due to exposure to a PCB mixture and cadmium. Reproductive toxicology 19(3): 395-409. ")
										.<Reference> makeItLive());
				link_effecttoeffect10.getReferenceIDs()
						.add(new Reference(link_effecttoeffect10, dataSource,
								"Ankley GT, Miller DH, Jensen KM, Villeneuve DL, Martinovic D. 2008. Relationship of plasma sex steroid concentrations in female fathead minnows to reproductive success and population status. Aquatic toxicology 88(1): 69-74. ")
										.<Reference> makeItLive());
				
				link_effecttoeffect12 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect11, effect_downstreameffect13);
				link_effecttoeffect12.setLinkType(LinkType.UNKNOWN);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect12_weigth1 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect12, dataSource, Link_EffectToEffect.class, 2.0);
				link_effecttoeffect12.getDescriptionIDs()
						.set(new DescriptionSection_Structured(link_effecttoeffect12, dataSource, "(Key) Event Relationships Weight of Evidences",
								"• Biological Plausibility: \n\nVitellogenin synthesized in the liver and transported to the ovary via the circulation is the primary source of egg yolk proteins in fish (Tyler and Sumpter 1996; Arukwe and Goksoyr 2003). In many teleosts vitellogenesis can account for up to 95% of total egg size (Tyler and Sumpter 1996). \n\n• Empirical Support for Linkage:\n\nIn some (Ankley et al. 2002; Ankley et al. 2003; Lalone et al. 2013), but not all (Ankley et al. 2005; Sun et al. 2007; Skolness et al. 2013) fish reproduction studies, reductions in plasma vitellogenin have been associated with visible decreases in yolk protein content in oocytes and overall reductions in ovarian stage. \n\n• Uncertainties or Inconsistencies:\n\nNot all fish reproduction studies showing reductions in plasma vitellogenin have caused visible decreases in yolk protein content in oocytes and overall reductions in ovarian stage. (Ankley et al. 2005; Sun et al. 2007; Skolness et al. 2013). \n\nWhile plasma vitellogenin is well established as the only major source of vitellogenins to the oocyte, the extent to which a decrease will impact an ovary that has already developed vitellogenic staged oocytes is less certain. It would be assumed that the more rapid the turn-over of oocytes in the ovary, the tighter the linkage between these KEs. Thus, repeat spawning species with asynchronous oocyte development that spawn frequently would likely be more vulnerable than annual spawning species with synchronous oocyte development that had already reached late vitellogenic stages. \n\n",
								link_effecttoeffect12_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect12.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect12, dataSource, "Evidence Supporting Taxonomic Applicability",
								"This KER is expected to be primarily applicable to oviparous vertebrates that synthesize vitellogenin in hepatic tissue which is ultimately incorporated into oocytes present in the ovary.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								2);
				link_effecttoeffect12.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect12, dataSource, "Quantitative Understading",
								"Rates of vitellogenin uptake as a function of ovarian follicle surface area have been estimated for rainbow trout, an annual spawning fish species, and may exceed 700 ng/mm2 follicle surface per hour (Tyler and Sumpter 1996). \n\nComparable data are lacking for repeat-spawning species and kinetic relationships between plasma concentrations and uptake rates within the ovary have not been defined. \n\nA model based on a statistical relationship between plasma E2 concentrations, spawning interval, and cumulative fecundity has been developed to predict changes in cumulative fecundity from plasma VTG (Li et al. 2011b), but it does not incorporate a model of the kinetics of VTG uptake nor the influence of VTG uptake on oocyte growth. \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								3);
				link_effecttoeffect12.getReferenceIDs()
						.add(new Reference(link_effecttoeffect12, dataSource, "Tyler C, Sumpter J. 1996. Oocyte growth and development in teleosts. Reviews in Fish Biology and Fisheries 6: 287-318. ")
								.<Reference> makeItLive());
				link_effecttoeffect12.getReferenceIDs()
						.add(new Reference(link_effecttoeffect12, dataSource,
								"Arukwe A, GoksÃ¸yr A. 2003. Eggshell and egg yolk proteins in fish: hepatic proteins for the next generation: oogenetic, population, and evolutionary implications of endocrine disruption. Comparative Hepatology 2(4): 1-21. ")
										.<Reference> makeItLive());
				link_effecttoeffect12.getReferenceIDs()
						.add(new Reference(link_effecttoeffect12, dataSource,
								"Ankley GT, Jensen KM, Makynen EA, Kahl MD, Korte JJ, Hornung MW, et al. 2003. Effects of the androgenic growth promoter 17-ï�¢-trenbolone on fecundity and reproductive endocrinology of the fathead minnow. Environmental Toxicology and Chemistry 22(6): 1350-1360. ")
										.<Reference> makeItLive());
				link_effecttoeffect12.getReferenceIDs()
						.add(new Reference(link_effecttoeffect12, dataSource,
								"Ankley GT, Kahl MD, Jensen KM, Hornung MW, Korte JJ, Makynen EA, et al. 2002. Evaluation of the aromatase inhibitor fadrozole in a short-term reproduction assay with the fathead minnow (Pimephales promelas). Toxicological Sciences 67: 121-130. ")
										.<Reference> makeItLive());
				link_effecttoeffect12.getReferenceIDs()
						.add(new Reference(link_effecttoeffect12, dataSource,
								"Ankley GT, Jensen KM, Durhan EJ, Makynen EA, Butterworth BC, Kahl MD, et al. 2005. Effects of two fungicides with multiple modes of action on reproductive endocrine function in the fathead minnow (Pimephales promelas). Toxicol Sci 86(2): 300-308. ")
										.<Reference> makeItLive());
				link_effecttoeffect12.getReferenceIDs()
						.add(new Reference(link_effecttoeffect12, dataSource,
								"Sun L, Zha J, Spear PA, Wang Z. 2007. Toxicity of the aromatase inhibitor letrozole to Japanese medaka (Oryzias latipes) eggs, larvae and breeding adults. Comp Biochem Physiol C Toxicol Pharmacol 145(4): 533-541. ")
										.<Reference> makeItLive());
				link_effecttoeffect12.getReferenceIDs()
						.add(new Reference(link_effecttoeffect12, dataSource,
								"Skolness SY, Blanksma CA, Cavallin JE, Churchill JJ, Durhan EJ, Jensen KM, et al. 2013. Propiconazole Inhibits Steroidogenesis and Reproduction in the Fathead Minnow (Pimephales promelas). Toxicological sciences : an official journal of the Society of Toxicology 132(2): 284-297. ")
										.<Reference> makeItLive());
				link_effecttoeffect12.getReferenceIDs()
						.add(new Reference(link_effecttoeffect12, dataSource,
								"Li Z, Villeneuve DL, Jensen KM, Ankley GT, Watanabe KH. 2011b. A computational model for asynchronous oocyte growth dynamics in a batch-spawning fish. Can J Fish Aquat Sci 68: 1528-1538. ")
										.<Reference> makeItLive());
				
				link_effecttoeffect14 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect13, effect_downstreameffect15);
				link_effecttoeffect14.setLinkType(LinkType.UNKNOWN);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect14_weigth1 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect14, dataSource, Link_EffectToEffect.class, 2.0);
				link_effecttoeffect14.getDescriptionIDs()
						.set(new DescriptionSection_Structured(link_effecttoeffect14, dataSource, "(Key) Event Relationships Weight of Evidences",
								"• Biological Plausibility: \n\nVitellogenesis is a critical stage of oocyte development and accumulated lipids and yolk proteins make up the majority of oocyte biomass (Tyler and Sumpter 1996). At least in mammals, maintenance of meiotic arrest is supported by signals transmitted through gap junctions between the granulosa cells and oocytes (Jamnongjit and Hammes 2005). Disruption of oocyte-granulosa contacts as a result of cell growth has been shown to coincide with oocyte maturation (Eppig 1994). However, it remains unclear whether the relationship between vitellogenin accumulation and oocyte growth and eventual maturation is causal or simply correlative. \n\n• Empirical Support for Linkage:\n\nAt present, to our best knowledge there are no studies that definitively demonstrate a direct cause-effect relationship between impaired VTG accumulation into oocytes and impaired spawning. There is, however, strong correlative evidence. Across a range of laboratory studies with small fish, there is a robust and statistically significant correlation between reductions in circulating VTG concentrations and reductions in cumulative fecundity (Miller et al. 2007). To date, we are unaware of any fish reproduction studies which show a large reduction in circulating VTG concentrations, but not reductions in cumulative fecundity. \n\n• Uncertainties or Inconsistencies:\n\nBased on the limited number of studies available that have examined both of these KEs, there are no known, unexplained, results that are inconsistent with this relationship. \n\n",
								link_effecttoeffect14_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect14.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect14, dataSource, "Evidence Supporting Taxonomic Applicability",
								"On the basis of the taxonomic relevance of the two KEs linked via this KER, this KER is likely applicable to aquatic, oviparous, vertebrates which both produce vitellogenin and deposit eggs/sperm into an aquatic environment. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								2);
				link_effecttoeffect14.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect14, dataSource, "Quantitative Understading",
								"Across a range of laboratory studies with fathead minnow, there is a robust and statistically significant correlation between reductions in circulating VTG concentrations and reductions in cumulative fecundity (Miller et al. 2007). At present it is unclear how well that relationship may hold for other fish species or feral fish under the influence of environmental variables. A model based on a statistical relationship between plasma E2 concentrations, spawning interval, and cumulative fecundity has been developed to predict changes in cumulative fecundity from plasma VTG (Li et al. 2011b). However, to date, such models do not specifically consider vitellogenin uptake into oocytes as a quantitative predictor of fecundity. Furthermore, with the exception of a few specialized studies, quantitative measures of VTG content in oocytes are rarely measured in toxicity studies. In contrast, plasma VTG is routinely measured. .")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								3);
				link_effecttoeffect14.getReferenceIDs()
						.add(new Reference(link_effecttoeffect14, dataSource, "Tyler C, Sumpter J. 1996. Oocyte growth and development in teleosts. Reviews in Fish Biology and Fisheries 6: 287-318. ")
								.<Reference> makeItLive());
				link_effecttoeffect14.getReferenceIDs()
						.add(new Reference(link_effecttoeffect14, dataSource, "Jamnongjit M, Hammes SR. 2005. Oocyte maturation: the coming of age of a germ cell. Seminars in reproductive medicine 23(3): 234-241. ")
								.<Reference> makeItLive());
				link_effecttoeffect14.getReferenceIDs()
						.add(new Reference(link_effecttoeffect14, dataSource, "Eppig JJ. 1994. Further reflections on culture systems for the growth of oocytes in vitro. Human reproduction 9(6): 974-976. ")
								.<Reference> makeItLive());
				link_effecttoeffect14.getReferenceIDs()
						.add(new Reference(link_effecttoeffect14, dataSource,
								"Miller DH, Jensen KM, Villeneuve DL, Kahl MD, Makynen EA, Durhan EJ, et al. 2007. Linkage of biochemical responses to population-level effects: a case study with vitellogenin in the fathead minnow (Pimephales promelas). Environ Toxicol Chem 26(3): 521-527. ")
										.<Reference> makeItLive());
				link_effecttoeffect14.getReferenceIDs()
						.add(new Reference(link_effecttoeffect14, dataSource,
								"Li Z, Villeneuve DL, Jensen KM, Ankley GT, Watanabe KH. 2011b. A computational model for asynchronous oocyte growth dynamics in a batch-spawning fish. Can J Fish Aquat Sci 68: 1528-1538. ")
										.<Reference> makeItLive());
				
				link_effecttoeffect16 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect15, effect_adverseoutcome17);
				link_effecttoeffect16.setLinkType(LinkType.DIRECT);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect16_weigth1 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect16, dataSource, Link_EffectToEffect.class, 2.0);
				link_effecttoeffect16.getDescriptionIDs()
						.set(new DescriptionSection_Structured(link_effecttoeffect16, dataSource, "(Key) Event Relationships Weight of Evidences",
								"• Biological Plausibility: \n\nUsing a relatively simple density-dependent population model and assuming constant young of year survival with no immigration/emigration, reductions in cumulative fecundity have been predicted to yield declines in population size over time (Miller and Ankley 2004). Under real-world environmental conditions, outcomes may vary depending on how well conditions conform with model assumptions. Nonetheless, cumulative fecundity can be considered one vital rate that contributes to overall population trajectories (Kramer et al. 2011). \n\n• Empirical Support for Linkage:\n\nUsing a relatively simple density-dependent population model and assuming constant young of year survival with no immigration/emigration, reductions in cumulative fecundity have been predicted to yield declines in population size over time (Miller and Ankley 2004). However, it should be noted that the model was constructed in such a way that predicted population size is dependent on cumulative fecundity, therefore this is a fairly weak form of empirical support. \n\nIn a study in which an entire lake was treated with 17alpha-ethynyl estradiol, Kidd et al. (2007) declines in fathead minnow population size were associated with signs of reduced fecundity. \n\n• Uncertainties or Inconsistencies:\n\nWester et al. (2003) and references cited therein suggest that although egg production is an endpoint of demographic significance, incomplete reductions of egg production may not translate in a simple manner to population reductions. Compensatory effects of reduced predation and reduced competition for limited food and/or habitat resources may offset the effects of incomplete reductions in egg production. \n\nFish and other egg laying animals employ a diverse range of reproductive strategies and life histories. The nature of the relationship between reduced spawning frequency and cumulative fecundity and overall population trajectories will depend heavily on the life history and reproductive strategy of the species in question. Relationships developed for one species will not necessarily hold for other species, particularly those with differing life histories. \n\n",
								link_effecttoeffect16_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect16.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect16, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Spawning generally refers to the release of eggs and/or sperm into water, generally by aquatic or semi-aquatic organisms. Consequently, by definition, this KER is likely applicable only to organisms that spend a portion of their life-cycle in or near aquatic environments. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								2);
				link_effecttoeffect16.getDescriptionIDs()
						.set(new DescriptionSection(link_effecttoeffect16, dataSource, "Quantitative Understading",
								"Cumulative fecundity is one example of a vital rate that can influence population size over time. A variety of population model constructs can be adapted to utilize measurements or estimates of cumulative fecundity as a predictor of population trends over time (e.g., (Miller and Ankley 2004; Miller et al. 2013). \n\nThe model of Miller et al. 20014 uses a relatively simple density-dependent population model and assuming constant young of year survival with no immigration/emigration, use measures of cumulative fecundity to predict relative change in in population size over time (Miller and Ankley 2004). \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								3);
				link_effecttoeffect16.getReferenceIDs()
						.add(new Reference(link_effecttoeffect16, dataSource,
								"Miller DH, Ankley GT. 2004. Modeling impacts on populations: fathead minnow (Pimephales promelas) exposure to the endocrine disruptor 17ï�¢ï€­trenbolone as a case study. Ecotoxicology and Environmental Safety 59: 1-9. ")
										.<Reference> makeItLive());
				link_effecttoeffect16.getReferenceIDs()
						.add(new Reference(link_effecttoeffect16, dataSource,
								"Miller DH, Tietge JE, McMaster ME, Munkittrick KR, Xia X, Ankley GT. 2013. Assessment of Status of White Sucker (Catostomus Commersoni) Populations Exposed to Bleached Kraft Pulp Mill Effluent. Environmental toxicology and chemistry / SETAC (in press). ")
										.<Reference> makeItLive());
				link_effecttoeffect16.getReferenceIDs()
						.add(new Reference(link_effecttoeffect16, dataSource,
								"Wester P, van den Brandhof E, Vos J, van der Ven L. 2003. Identification of endocrine disruptive effects in the aquatic environment - a partial life cycle assay with zebrafish. (RIVM Report). Bilthoven, the Netherlands: Joint Dutch Environment Ministry. ")
										.<Reference> makeItLive());
				link_effecttoeffect16.getReferenceIDs()
						.add(new Reference(link_effecttoeffect16, dataSource,
								"Kidd KA, Blanchfield KH, Palace VP, Evans RE, Lazorchak JM, Flick RW. 2007. Collapse of a fish population after exposure to a synthetic estrogen. PNAS 104:8897-8901. ")
										.<Reference> makeItLive());
				link_effecttoeffect16.getReferenceIDs()
						.add(new Reference(link_effecttoeffect16, dataSource,
								"Kramer VJ, Etterson MA, Hecker M, Murphy CA, Roesijadi G, Spade DJ, Spromberg JA, Wang M, Ankley GT. Adverse outcome pathways and ecological risk assessment: bridging to population-level effects. Environ Toxicol Chem. 2011 Jan;30(1):64-76. doi: 10.1002/etc.375. PubMed PMID: 20963853 ")
										.<Reference> makeItLive());
				
				link_chemstructtomie19 = new Link_ChemStructToMIE(pathway, dataSource, initiator_chemicalstructure18, effect_molecularinitiatingevent3);
				link_chemstructtomie19.setLinkType(LinkType.UNKNOWN);
				link_chemstructtomie21 = new Link_ChemStructToMIE(pathway, dataSource, initiator_chemicalstructure20, effect_molecularinitiatingevent3);
				link_chemstructtomie21.setLinkType(LinkType.UNKNOWN);
				testresponsemapping26 = new TestResponseMapping(pathway, dataSource, test_invitro22, effect_molecularinitiatingevent3);
				
				testresponsemapping27 = new TestResponseMapping(pathway, dataSource, test_invivo23, effect_molecularinitiatingevent3);
				
				testresponsemapping28 = new TestResponseMapping(pathway, dataSource, test_exvivo24, effect_molecularinitiatingevent3);
				
				testresponsemapping29 = new TestResponseMapping(pathway, dataSource, test_insilico25, effect_molecularinitiatingevent3);
				
				testresponsemapping32 = new TestResponseMapping(pathway, dataSource, test_exvivo30, effect_downstreameffect5);
				
				testresponsemapping33 = new TestResponseMapping(pathway, dataSource, test_insilico31, effect_downstreameffect5);
				
				testresponsemapping42 = new TestResponseMapping(pathway, dataSource, test_invivo34, effect_downstreameffect7);
				
				testresponsemapping43 = new TestResponseMapping(pathway, dataSource, test_insilico35, effect_downstreameffect7);
				
				testresponsemapping44 = new TestResponseMapping(pathway, dataSource, test_invivo36, effect_downstreameffect9);
				
				testresponsemapping45 = new TestResponseMapping(pathway, dataSource, test_insilico37, effect_downstreameffect9);
				
				testresponsemapping46 = new TestResponseMapping(pathway, dataSource, test_invivo38, effect_downstreameffect11);
				
				testresponsemapping47 = new TestResponseMapping(pathway, dataSource, test_insilico39, effect_downstreameffect11);
				
				testresponsemapping48 = new TestResponseMapping(pathway, dataSource, test_invivo40, effect_downstreameffect13);
				
				testresponsemapping49 = new TestResponseMapping(pathway, dataSource, test_insilico41, effect_downstreameffect13);
				
				testresponsemapping52 = new TestResponseMapping(pathway, dataSource, test_invivo50, effect_downstreameffect15);
				
				testresponsemapping53 = new TestResponseMapping(pathway, dataSource, test_insilico51, effect_downstreameffect15);
				
				testresponsemapping55 = new TestResponseMapping(pathway, dataSource, test_insilico54, effect_adverseoutcome17);
				
				testresponsemapping57 = new TestResponseMapping(pathway, dataSource, test_invitro56, effect_molecularinitiatingevent3);
				
				testresponsemapping60 = new TestResponseMapping(pathway, dataSource, test_invitro59, effect_molecularinitiatingevent3);
				
				pathway.getGroups().parseString("");
				pathway.getUids().parseString(
						"OECD Project 1.12: The Adverse outcome pathways linking aromatase inhibition, androgen receptor agonism, estrogen receptor antagonism, or steroidogenesis inhibition, to impaired reproduction in small repeat-spawning fish species,");
				pathway.getStatus().parseString("EAGMST Approved,");
				
				pathway.updateEssentiality();
				EssetialityDescription essentiality = pathway.getEssentiality();
				DescriptionSection_Structured dss;
				pathway.getDescriptionIDs()
						.set(new DescriptionSection(pathway, dataSource, "Abstract",
								"This adverse outcome pathway details the linkage between inhibition of gonadal aromatase activity in females and reproductive dysfunction, as measured through the adverse effect of reduced cumulative fecundity and spawning. Initial development of this AOP draws heavily on evidence collected using repeat-spawning fish species. Cumulative fecundity is the most apical endpoint considered in the OECD 229 Fish Short Term Reproduction Assay. The OECD 229 assay serves as screening assay for endocrine disruption and associated reproductive impairment (OECD 2012). Cumulative fecundity is one of several variables known to be of demographic significance in forecasting fish population trends. Therefore, this AOP has utility in supporting the application of measures of aromatase, or in silico predictions of the ability to inhibit aromatase, as a means to identify chemicals with known potential to adversely affect fish populations and potentially other oviparous vertebrates. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								0);
				pathway.getDescriptionIDs()
						.set(new DescriptionSection(pathway, dataSource, "Quantitative Considerations",
								"At present, quantitative understanding of the AOP is approaching the point where an in vitro measurement of aromatase inhibition could be used as an input parameter into a series of coupled computational models that could generate quantitative predictions across multiple key events (e.g., circulating E2 concentrations, circulating VTG concentrations, predicted impacts on cumulative fecundity, and effects on population trajectories). A sequence of supporting models has been coupled together and predictions have been made for novel aromatase inhibitors (identified through high throughput in vitro screening), but those predictions have not yet been validated experimentally. The present models are also unable to account for pharmacokinetic considerations (e.g., adsorption, distribution, metabolism/biotransformation, and elimination) and have demonstrated only partial success in simulating compensatory/feedback responses to aromatase inhibition (e.g., (Breen et al. 2013). ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								3);
				pathway.getDescriptionIDs()
						.set(new DescriptionSection(pathway, dataSource, "Applicability of the AOP",
								"•	Sex: The AOP applies to females only. Males have relatively low gonadal aromatase expression and activity and the androgen 11-KT, rather than the estrogen E2 is a stronger driver of reproductive functions in males. That said, at least in fish, there is a potential autocrine and paracrine for estrogens synthesized in the brain in regulating reproductive behaviors. However, those potential effects are addressed through an alternative AOP that shares the MIE of aromatase inhibition. \n\n•	Life stages: The relevant life stages for this AOP are reproductively mature adults. This AOP does not apply to adult stages that lack a sexually mature ovary, for example as a result of seasonal or environmentally-induced gonadal senescence (i.e., through control of temperature, photo-period, etc. in a laboratory setting). \n\n•	Taxonomic: At present, the assumed taxonomic applicability domain of this AOP is class Osteichthyes. In all likelihood, the AOP will also prove applicable to all classes of fish (e.g., Agnatha and Chondrithyes as well). Additionally, all the key events described should be conserved among all oviparous vertebrates, suggesting that the AOP may also have relevance for amphibians, reptiles, and birds. However, species-specific differences in reproductive strategies/life histories, ADME (adsorption, distribution, metabolism, and elimination), compensatory reproductive endocrine responses may influence the outcomes, particularly from a quantitative standpoint. \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								4);
				pathway.getDescriptionIDs()
						.set(new DescriptionSection(pathway, dataSource, "Considerations for Potential Applications of the AOP (optional)",
								"The present AOP can provide potential support for the use of alternatives to the fish short term reproduction assay as a screen for aromatase inhibitors. \n\nThe present AOP can serve as a foundation for tiered testing strategies and IATA related to risk assessments on chemicals identified as aromatase inhibitors. \n\nThe present AOP can be used to guide endpoint selection for effects-based monitoring studies at sites where aromatase inhibition has been identified as a relevant biological activity of interest (e.g., through bioeffects prediction or bioeffects surveillance approaches; see Schroeder et al. 2016). \n\nA series of computational models aligned with this AOP (i.e., a quantitative AOP construct) can be applied to estimate in vivo bench-mark doses based on in vitro screening results. Case studies evaluating this application are under way. \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								5);
				pathway.getDescriptionIDs()
						.set(new DescriptionSection(pathway, dataSource, " Essentiality of the Key Events - overall assessment",
								" Support for the essentiality of a number of key events in the AOP was provided by several time-course, stop-reversibility, experiments with fathead minnows exposed to aromatase inhibitors. \n\n1. Villeneuve et al. 2009 and 2013 examined a time-course of key event responses to fadrozole as well as the time-course of recovery following cessation of fadrozole delivery. Once fadrozole was removed from the system, ex vivo E2 production increased, followed by increases in plasma E2 concentrations, and then increases in plasma vitellogenin concentrations. Additionally, while exposure to the chemical was on-going, compensatory up-regulation of CYP19a1a gene expression resulted in increases in ex vivo E2 production, followed by increased plasma E2 and plasma VTG. The essentiality of aromatase inhibition relative to impaired E2 production was further supported by the observation of an \"overshoot\" in E2 production, relative to controls, shortly after cessation of fadrozole delivery. \n\n2. Similar support was provided in a study by Ankley et al. (2009a). Cessation of prochloraz delivery resulted in rapid recovery of ex vivo E2 production and plasma E2 concentrations, with recovery of vitellogenin concentrations lagging slightly behind. Increased expression of cyp19a1a mRNA during the exposure period aligned with increased ex vivo E2 production, and increased plasma E2, compared to the first day of exposure. \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								6);
				pathway.getDescriptionIDs()
						.set(new DescriptionSection(pathway, dataSource, " Overall Assessment of the AOP",
								" • Biological plausibility: Biological plausibility refers to the structural or functional relationship between the key events based on our fundamental understanding of \"normal biology\". In general, the biological plausibility and coherence linking aromatase inhibition through decreases in circulating concentrations of E2 is very solid. The biochemistry of steroidogenesis and the predominant role of the gonad in synthesis of the sex steroids is well established. Similarly, the role of E2 as the major regulator of hepatic vitellogenin production is widely documented in the literature. The direct link between reduced VTG concentrations in the plasma and reduced uptake into oocytes is highly plausible, as the plasma is the primary source of the VTG. However, the direct connection between reduced VTG uptake and impaired spawning/reduced cumulative fecundity is more tentative. It is not clear, for instance whether impaired VTG uptake limits oocyte growth and failure to reach a critical size in turn impairs physical or inter-cellular signaling processes that promote release of the oocyte from the surrounding follicles. In at least one experiment, oocytes with similar size to vitellogenic oocytes, but lacking histological staining characteristic of vitellogenic oocytes was observed (R. Johnson, personal communication). Regulation of oocyte maturation and spawning involves many factors other than vitellogenin accumulation (Clelland and Peng, 2009). At present, the link between reductions in circulating VTG concentrations and reduced cumulative fecundity are best supported by the correlation between those endpoints across multiple experiments, including those that impact VTG via other molecular initiating events (Miller et al. 2007). \n\n• Concordance of dose-response relationships: Dose response concordance considers the degree to which upstream events are shown to occur at test concentrations equal to or lower than those that cause significant effects on downstream key events, the underlying assumption being that all KEs can be measured with equal precision. There are a limited number of studies in which multiple key events were considered in the same study. These were considered the most useful for evaluating the concordance of dose-response relationships. In general, effects on downstream key events occurred at concentrations equal to or greater than those at which upstream events occurred (Concordance table: [1]) at https://aopwiki.org/wiki/images/e/eb/Annex1_for_AOP_25_aromatase_inhibtion_reproductive_dys_revised_2016-02-05.pdf. However, there are exceptions. There are cases where no significant effects on estradiol synthesis by ovarian granulosa cells (ovary explants) were observed, but significant effects on plasma E2 or VTG concentrations were observed. Likewise, there are cases where impacts on plasma VTG were observed at concentrations lower than those reported to reduce plasma E2 concentrations. Based on knowledge of the studies in question, the apparent lack of concordance in some cases is driven by two primary factors. First, differences in the sensitivity and dynamic range of the measurements being made. Second, the effects of compensatory responses along the HPG axis. For instance, although ex vivo E2 production is rapidly affected by exposure to fadrozole, it is also a response that is more rapidly corrected through upregulation of aromatase transcripts (see Villeneuve et al. 2009), meaning that it recovers more quickly than plasma concentrations of E2 or plasma VTG concentrations. Thus, at certain time points, one can get an apparent effect on plasma E2 or T without a measurable impact on E2 production by the gonad tissue, because the upstream insult occurred earlier in time and was subsequently offset by a compensatory response, but the compensation has yet to propagate through the pathway. Sensitivity and dynamic range of the measurement methods is also an issue. Vitellogenin concentrations have a highly dynamic range and can change by orders of magnitude. Other endpoints like plasma steroids are regulated in a narrower range, making differences more difficult to distinguish statistically. Therefore, in our assessment, the deviations from concordance do not call the KERs into question. \n\nThe concentration-dependence of the key event responses with regard to the concentration of aromatase inhibitor has been established in vitro and/or in vivo for nearly all key events in the AOP. \n\n1.	Concentration-dependent aromatase inhibition: (Villeneuve et al. 2006; Ankley et al. 2005; M et al. 2004; AM et al. 2000; Shilling et al. 1999) \n\n2.	Concentration-dependent decreases in E2 production in vitro, ex vivo: (Ankley et al. 2002; Villeneuve et al. 2007; Villeneuve et al. 2009; Ankley et al. 2005; a Marca Pereira et al. 2011; Lee et al. 2006). \n\n3.	Concentration-dependent decreases in circulating E2 concentrations: (Ankley et al. 2002; Villeneuve et al. 2009; Ankley et al. 2005; Ankley et al. 2009a; GT et al. 2001) \n\n4.	Concentration-dependent decreases in vitellogenin mRNA expression: (Sun et al. 2010; Sun et al. 2011; Zhang et al. 2008) \n\n5.	Concentration-dependent decreases in circulating vitellogenin concentrations: (Ankley et al. 2002; Villeneuve et al. 2009; Ankley et al. 2005; Ankley et al. 2009a; Sun et al. 2007; GT et al. 2001; Ralston-Hooper et al. 2013) \n\n6.	Concentration-dependent reductions in VTG uptake into oocytes or impaired oocyte development: Concentration-dependence of these effects has not been well demonstrated. The effects, when seen, have typically been documented at the greatest exposure concentration tested, but concentration-dependence of the severity or frequency of the impact was not documented (e.g., (Ankley et al. 2002; Ankley et al. 2005; Sun et al. 2007) \n\n7.	Concentration-dependent reductions in cumulative fecundity: (Ankley et al. 2002; Ankley et al. 2005; Sun et al. 2007; Zhang et al. 2008) \n\n8.	Declining population trajectory: Modeled population trajectories show a concentration-dependent reduction in projected population size, however, those results are driven by the concentration-dependence of cumulative fecundity. Population-level effects have not been measured directly. \n\n• Temporal concordance: Temporal concordance refers to the degree to which the data support the hypothesized sequence of the key events; i.e., the effect on KE1 is observed before the effect on KE2, which is observed before the effect on KE3 and so on. Temporal concordance of the AOP from aromatase inhibition to decreased E2 production, decreased circulating E2, and decreased plasma VTG concentrations has been established (e.g., (Villeneuve et al. 2009; Ankley et al. 2009a; Skolness et al. 2011). Temporal concordance has not been established beyond that key event, in large part due to disconnect in the time-scales over which the events can be measured. For example, most small fish used in reproductive toxicity testing will can spawn anywhere from once daily to several days per week. Given the variability in daily spawning rates, it is neither practical nor effective to evaluate cumulative fecundity at a time scale shorter than roughly a week. Since the impacts at lower levels of biological organization can be detected within hours of exposure, lack of impact on cumulative fecundity before the other key events are impacted cannot be effectively measured. Overall, among those key events whose temporal concordance can reasonably be evaluated, the temporal profile observed is consistent with the AOP. \n\n• Consistency: We are aware of no cases where the pattern of key events described was observed without also observing a significant impact on cumulative fecundity. The final adverse outcome is not specific to this AOP. Many of the key events included in this AOP overlap with AOPs linking other molecular initiating events to reproductive dysfunction in small fish. \n\n• Uncertainties, inconsistencies, and data gaps: The current major uncertainty in this AOP is whether there is a direct biological linkage between impaired VTG uptake into oocytes and impaired spawning/reduced cumulative fecundity. Plausible biological connections have been hypothesized, but have not yet been tested experimentally. \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								7);
				dss = essentiality.getEssentialityDescription(effect_molecularinitiatingevent3);
				dss.setContent("There is good evidence from stop/reversibility studies that ceasing delivery of the aromatase inhibitor leads to recovery of the subsequent key events. ");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(3.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect5);
				dss.setContent(
						"17beta-estradiol synthesis by ovarian granulosa cells, reduction: [Strong] In both exposure studies and stop/reversibility studies, when ex vivo E2 production (as measure of this KE) recovers either through compensation or due to removal of the stressor, subsequent KEs have been shown to recover after a lag period. ");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(3.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect7);
				dss.setContent(
						"plasma 17beta-estradiol concentrations, reduction: [Strong] In both exposure studies and stop/reversibility studies, when plasma E2 concentrations recover either through compensation or due to removal of the stressor, subsequent KEs have been shown to recover after a lag period. ");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(3.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect9);
				dss.setContent(
						"Vitellogenin production in liver (transcription, translation), reduction: [Moderate] This endpoint was not specifically examined in stop/reversibility studies with aromatase inhibitors, but biological plausibility provides strong support for the essentiality of this event. ");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(2.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect11);
				dss.setContent("Plasma vitellogenin concentrations, reduction: [Strong] Shown to recover in a predictable fashion consistent with the order of events in the AOP in stop/recovery studies. ");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(3.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect13);
				dss.setContent(
						"Vitellogenin accumulation into oocytes and oocyte growth/development, reduction: [Weak] Some contradictory evidence regarding the essentiality of this event. No stop/reversibility studies have explicitly considered this key event. ");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(1.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect15);
				dss.setContent("Cumulative fecundity and spawning, reductions: [Moderate] By definition, some degree of spawning is required to maintain population. ");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(2.0);
				dss = essentiality.getEssentialityDescription(effect_adverseoutcome17);
				dss.setContent("Adverse Outcome");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource, "1. OECD. 2012. Test No. 229: Fish Short Term Reproduction Assay. Paris, France:Organization for Economic Cooperation and Development. ")
								.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"2. Petkov PI, Temelkov S, Villeneuve DL, Ankley GT, Mekenyan OG. 2009. Mechanism-based categorization of aromatase inhibitors: a potential discovery and screening tool. SAR QSAR Environ Res 20(7-8): 657-678. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs().add(new Reference(pathway, dataSource, "3. Lephart ED, Simpson ER. 1991. Assay of aromatase activity. Methods Enzymol 206: 477-483. ").<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"4. Letcher RJ, van Holsteijn I, Drenth H-J, Norstrom RJ, Bergman A, Safe S, et al. 1999. Cytotoxicity and aromatase (CYP19) activity modulation by organochlorines in human placental JEG-3 and JAR choriocarcinoma cells. Toxicology and applied pharmacology 160: 10-20. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"5. Sanderson J, Seinen W, Giesy J, van den Berg M. 2000. 2-chloro-triazine herbicides induce aromatase (CYP19) activity in H295R human adrenocortical carcinoma cells: a novel mechanism for estrogenicity. Toxicological Sciences 54: 121-127. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"6. Villeneuve DL, Knoebl I, Kahl MD, Jensen KM, Hammermeister DE, Greene KJ, et al. 2006. Relationship between brain and ovary aromatase activity and isoform-specific aromatase mRNA expression in the fathead minnow (Pimephales promelas). Aquat Toxicol 76(3-4): 353-368. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"7. Ankley GT, Kahl MD, Jensen KM, Hornung MW, Korte JJ, Makynen EA, et al. 2002. Evaluation of the aromatase inhibitor fadrozole in a short-term reproduction assay with the fathead minnow (Pimephales promelas). Toxicological Sciences 67: 121-130. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs().add(
						new Reference(pathway, dataSource, "8. Castro LF, Santos MM, Reis-Henriques MA. 2005. The genomic environment around the Aromatase gene: evolutionary insights. BMC evolutionary biology 5: 43. ")
								.<Reference> makeItLive());
				pathway.getReferenceIDs().add(new Reference(pathway, dataSource, "9. Norris DO. 2007. Vertebrate Endocrinology. Fourth ed. New York: Academic Press. ").<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource, "10. Yaron Z. 1995. Endocrine control of gametogenesis and spawning induction in the carp. Aquaculture 129: 49-73. ").<Reference> makeItLive());
				pathway.getReferenceIDs().add(
						new Reference(pathway, dataSource, "11. Havelock JC, Rainey WE, Carr BR. 2004. Ovarian granulosa cell lines. Molecular and cellular endocrinology 228(1-2): 67-78. ").<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"12. Villeneuve DL, Ankley GT, Makynen EA, Blake LS, Greene KJ, Higley EB, et al. 2007. Comparison of fathead minnow ovary explant and H295R cell-based steroidogenesis assays for identifying endocrine-active chemicals. Ecotoxicol Environ Saf 68(1): 20-32. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"13. McMaster ME MK, Jardine JJ, Robinson RD, Van Der Kraak GJ. 1995. Protocol for measuring in vitro steroid production by fish gonadal tissue. Canadian Technical Report of Fisheries and Aquatic Sciences 1961 1961: 1-78. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"14. Ankley GT, Jensen KM, Kahl MD, Makynen EA, Blake LS, Greene KJ, et al. 2007. Ketoconazole in the fathead minnow (Pimephales promelas): reproductive toxicity and biological compensation. Environ Toxicol Chem 26(6): 1214-1223. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"15. Villeneuve DL, Mueller ND, Martinovic D, Makynen EA, Kahl MD, Jensen KM, et al. 2009. Direct effects, compensation, and recovery in female fathead minnows exposed to a model aromatase inhibitor. Environ Health Perspect 117(4): 624-631. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs().add(new Reference(pathway, dataSource,
						"16. Baker ME. 2011. Origin and diversification of steroids: co-evolution of enzymes and nuclear receptors. Molecular and cellular endocrinology 334(1-2): 14-20. ").<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"17. Jensen K, Korte J, Kahl M, Pasha M, Ankley G. 2001. Aspects of basic reproductive biology and endocrinology in the fathead minnow (Pimephales promelas). Comparative Biochemistry and Physiology Part C 128: 127-141. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"18. Biales AD, Bencic DC, Lazorchak JL, Lattier DL. 2007. A quantitative real-time polymerase chain reaction method for the analysis of vitellogenin transcripts in model and nonmodel fish species. Environ Toxicol Chem 26(12): 2679-2686. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"19. Schmieder P, Tapper M, Linnum A, Denny J, Kolanczyk R, Johnson R. 2000. Optimization of a precision-cut trout liver tissue slice assay as a screen for vitellogenin induction: comparison of slice incubation techniques. Aquat Toxicol 49(4): 251-268. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"20. Navas JM, Segner H. 2006. Vitellogenin synthesis in primary cultures of fish liver cells as endpoint for in vitro screening of the (anti)estrogenic activity of chemical substances. Aquat Toxicol 80(1): 1-22. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"21. Korte JJ, Kahl MD, Jensen KM, Mumtaz SP, Parks LG, LeBlanc GA, et al. 2000. Fathead minnow vitellogenin: complementary DNA sequence and messenger RNA and protein expression after 17B-estradiol treatment. Environmental Toxicology and Chemistry 19(4): 972-981. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"22. Tyler C, van der Eerden B, Jobling S, Panter G, Sumpter J. 1996. Measurement of vitellogenin, a biomarker for exposure to oestrogenic chemicals, in a wide variety of cyprinid fish. Journal of Comparative Physiology and Biology 166: 418-426. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource, "23. Tyler C, Sumpter J. 1996. Oocyte growth and development in teleosts. Reviews in Fish Biology and Fisheries 6: 287-318. ").<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"24. Leino R, Jensen K, Ankley G. 2005. Gonadal histology and characteristic histopathology associated with endocrine disruption in the adult fathead minnow. Environmental Toxicology and Pharmacology 19: 85-98. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"25. Wolf JC, Dietrich DR, Friederich U, Caunter J, Brown AR. 2004. Qualitative and quantitative histomorphologic assessment of fathead minnow Pimephales promelas gonads as an endpoint for evaluating endocrine-active compounds: a pilot methodology study. Toxicol Pathol 32(5): 600-612. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"26. Miller DH, Ankley GT. 2004. Modeling impacts on populations: fathead minnow (Pimephales promelas) exposure to the endocrine disruptor 17b-trenbolone as a case study. Ecotoxicology and Environmental Safety 59: 1-9. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"27. Ankley GT, Jensen KM, Durhan EJ, Makynen EA, Butterworth BC, Kahl MD, et al. 2005. Effects of two fungicides with multiple modes of action on reproductive endocrine function in the fathead minnow (Pimephales promelas). Toxicol Sci 86(2): 300-308. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"28. Ankley GT, Bencic D, Cavallin JE, Jensen KM, Kahl MD, Makynen EA, et al. 2009a. Dynamic nature of alterations in the endocrine system of fathead minnows exposed to the fungicide prochloraz. Toxicol Sci 112(2): 344-353. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"29. Skolness SY, Durhan EJ, Garcia-Reyero N, Jensen KM, Kahl MD, Makynen EA, et al. 2011. Effects of a short-term exposure to the fungicide prochloraz on endocrine function and gene expression in female fathead minnows (Pimephales promelas). Aquat Toxicol 103(3-4): 170-178. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"30. Breen M, Villeneuve DL, Ankley GT, Bencic DC, Breen MS, Watanabe KH, et al. 2013. Developing Predictive Approaches to Characterize Adaptive Responses of the Reproductive Endocrine Axis to Aromatase Inhibition: II. Computational Modeling. Toxicological sciences : an official journal of the Society of Toxicology. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"31. Breen MS, Villeneuve DL, Breen M, Ankley GT, Conolly RB. 2007. Mechanistic computational model of ovarian steroidogenesis to predict biochemical responses to endocrine active compounds. Annals of biomedical engineering 35(6): 970-981. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"32. Shoemaker JE, Gayen K, Garcia-Reyero N, Perkins EJ, Villeneuve DL, Liu L, et al. 2010. Fathead minnow steroidogenesis: in silico analyses reveals tradeoffs between nominal target efficacy and robustness to cross-talk. BMC systems biology 4: 89. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"33. Quignot N, Bois FY. 2013. A computational model to predict rat ovarian steroid secretion from in vitro experiments with endocrine disruptors. PloS one 8(1): e53891. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"34. Ankley GT, Bencic DC, Cavallin JE, Jensen KM, Kahl MD, Makynen EA, et al. 2009b. Dynamic nature of alterations in the endocrine system of fathead minnows exposed to the fungicide prochloraz. Toxicological sciences : an official journal of the Society of Toxicology 112(2): 344-353. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"35. Villeneuve DL, Breen M, Bencic DC, Cavallin JE, Jensen KM, Makynen EA, et al. 2013. Developing Predictive Approaches to Characterize Adaptive Responses of the Reproductive Endocrine Axis to Aromatase Inhibition: I. Data Generation in a Small Fish Model. Toxicological sciences : an official journal of the Society of Toxicology. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"36. Ankley GT, Cavallin JE, Durhan EJ, Jensen KM, Kahl MD, Makynen EA, et al. 2012. A time-course analysis of effects of the steroidogenesis inhibitor ketoconazole on components of the hypothalamic-pituitary-gonadal axis of fathead minnows. Aquatic toxicology 114-115: 88-95. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"37. Li Z, Kroll KJ, Jensen KM, Villeneuve DL, Ankley GT, Brian JV, et al. 2011a. A computational model of the hypothalamic: pituitary: gonadal axis in female fathead minnows (Pimephales promelas) exposed to 17alpha-ethynylestradiol and 17beta-trenbolone. BMC systems biology 5: 63. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"38. A A, A G. 2003. Eggshell and egg yolk proteins in fish: hepatic proteins for the next generation: oogenetic, population, and evolutionary implications of endocrine disruption. Comparative Hepatology 2(4): 1-21. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"39. Sun L, Wen L, Shao X, Qian H, Jin Y, Liu W, et al. 2010. Screening of chemicals with anti-estrogenic activity using in vitro and in vivo vitellogenin induction responses in zebrafish (Danio rerio). Chemosphere 78(7): 793-799. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"40. Iguchi T, Irie F, Urushitani H, Tooi O, Kawashima Y, Roberts M, et al. 2006. Availability of in vitro vitellogenin assay for screening of estrogenic and anti-estrogenic activities of environmental chemicals. Environ Sci 13(3): 161-183. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"41. Murphy CA, Rose KA, Thomas P. 2005. Modeling vitellogenesis in female fish exposed to environmental stressors: predicting the effects of endocrine disturbance due to exposure to a PCB mixture and cadmium. Reproductive toxicology 19(3): 395-409. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"42. Murphy CA, Rose KA, Rahman MS, Thomas P. 2009. Testing and applying a fish vitellogenesis model to evaluate laboratory and field biomarkers of endocrine disruption in Atlantic croaker (Micropogonias undulatus) exposed to hypoxia. Environmental toxicology and chemistry / SETAC 28(6): 1288-1303. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"43. Ankley GT, Miller DH, Jensen KM, Villeneuve DL, Martinovic D. 2008. Relationship of plasma sex steroid concentrations in female fathead minnows to reproductive success and population status. Aquatic toxicology 88(1): 69-74. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"44. Schmid T, Gonzalez-Valero J, Rufli H, Dietrich DR. 2002. Determination of vitellogenin kinetics in male fathead minnows (Pimephales promelas). Toxicol Lett 131(1-2): 65-74. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"45. Schultz IR, Orner G, Merdink JL, Skillman A. 2001. Dose-response relationships and pharmacokinetics of vitellogenin in rainbow trout after intravascular administration of 17alpha-ethynylestradiol. Aquatic toxicology 51(3): 305-318. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"46. Bowman CJ, Kroll KJ, Hemmer MJ, Folmar LC, Denslow ND. 2000. Estrogen-induced vitellogenin mRNA and protein in sheepshead minnow (Cyprinodon variegatus). General and comparative endocrinology 120(3): 300-313. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"47. Genovese G, Regueira M, Piazza Y, Towle DW, Maggese MC, Lo Nostro F. 2012. Time-course recovery of estrogen-responsive genes of a cichlid fish exposed to waterborne octylphenol. Aquatic toxicology 114-115: 1-13. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"48. Ankley GT, Jensen KM, Makynen EA, Kahl MD, Korte JJ, Hornung MW, et al. 2003. Effects of the androgenic growth promoter 17-b-trenbolone on fecundity and reproductive endocrinology of the fathead minnow. Environmental Toxicology and Chemistry 22(6): 1350-1360. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"49. Sun L, Zha J, Spear PA, Wang Z. 2007. Toxicity of the aromatase inhibitor letrozole to Japanese medaka (Oryzias latipes) eggs, larvae and breeding adults. Comp Biochem Physiol C Toxicol Pharmacol 145(4): 533-541. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"50. Li Z, Villeneuve DL, Jensen KM, Ankley GT, Watanabe KH. 2011b. A computational model for asynchronous oocyte growth dynamics in a batch-spawning fish. Can J Fish Aquat Sci 68: 1528-1538. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"51. Miller DH, Jensen KM, Villeneuve DL, Kahl MD, Makynen EA, Durhan EJ, et al. 2007. Linkage of biochemical responses to population-level effects: a case study with vitellogenin in the fathead minnow (Pimephales promelas). Environ Toxicol Chem 26(3): 521-527. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"52. Miller DH, Tietge JE, McMaster ME, Munkittrick KR, Xia X, Ankley GT. 2013. Assessment of Status of White Sucker (Catostomus Commersoni) Populations Exposed to Bleached Kraft Pulp Mill Effluent. Environmental toxicology and chemistry / SETAC. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs().add(new Reference(pathway, dataSource,
						"53. M H, M vdB, JT S. 2004. A comparison of human H295R and rat R2C cell lines as in vitro screening tools for effects on aromatase. Toxicol Lett 146: 183-194. ").<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource, "54. AM V, C H, V B, JC L. 2000. Screening of selected pesticides for inhibition of CYP19 aromatase activity in vitro. Toxicology In Vitro 14: 227-234. ")
								.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"55. Shilling AD, Carlson DB, Williams DE. 1999. Rainbow trout, Oncorhynchus mykiss, as a model for aromatase inhibition. J Steroid Biochem Mol Biol 70(1-3): 89-95. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"56. a Marca Pereira ML, Wheeler JR, Thorpe KL, Burkhardt-Holm P. 2011. Development of an ex vivo brown trout (Salmo trutta fario) gonad culture for assessing chemical effects on steroidogenesis. Aquat Toxicol 101(3-4): 500-511. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"57. Lee PS, Pankhurst NW, King HR. 2006. Effects of aromatase inhibitors on in vitro steroidogenesis by Atlantic salmon (Salmo salar) gonadal and brain tissue. Comp Biochem Physiol A Mol Integr Physiol 145(2): 195-203. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"58. GT A, KM J, MD K, JJ K, EA M. 2001. Description and evaluation of a short-term reproduction test with the fathead minnow (Pimephales promelas). Environmental Toxicology and Chemistry 20(6): 1276-1290. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"59. Sun L, Shao X, Chi J, Hu X, Jin Y, Fu Z. 2011. Transcriptional responses in the brain, liver and gonad of Japanese ricefish (Oryzias latipes) exposed to two anti-estrogens. Comp Biochem Physiol C Toxicol Pharmacol 153(4): 392-401. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"60. Zhang X, Hecker M, Tompsett AR, Park JW, Jones PD, Newsted J, et al. 2008. Responses of the medaka HPG axis PCR array and reproduction to prochloraz and ketoconazole. Environ Sci Technol 42(17): 6762-6769. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"61. Ralston-Hooper KJ, Turner ME, Soderblom EJ, Villeneuve D, Ankley GT, Moseley MA, et al. 2013. Application of a Label-free, Gel-free Quantitative Proteomics Method for Ecotoxicological Studies of Small Fish Species. Environ Sci Technol 47(2): 1091-1100. ")
										.<Reference> makeItLive());
				pathway.getReferenceIDs().add(new Reference(pathway, dataSource,
						"62. Clelland E, Peng C. Endocrine/paracrine control of zebrafish ovarian development. Mol Cell Endocrinol. 2009. 312(1-2):42-52. doi: 10.1016/j.mce.2009.04.009. ").<Reference> makeItLive());
				pathway.getReferenceIDs()
						.add(new Reference(pathway, dataSource,
								"63. Schroeder, A. L., Ankley, G. T., Houck, K. A. and Villeneuve, D. L. (2016), Environmental surveillance and monitoring-The next frontiers for high-throughput toxicology. Environ Toxicol Chem, 35: 513â€“525. doi:10.1002/etc.3309 ")
										.<Reference> makeItLive());
			}
			
		public void genreateRevision2()
			{
				gm1 = new Method_InSilicoGlobalModel(pathway, dataSource);
				gm1.setTitle("Fathead Minnow Hypothalamic-Pituitary-Gonadal Axis Model");
				
				DescriptionSection sum = new DescriptionSection(gm1, dataSource, "HPG axis model description",
						"<html>\n<body>\n<img src='https://app.effectopedia.org/media/rev/hpg_axis.png' width='403' height='244' alt='HPG-Axis model diagram' />\n<p>Perturbation of the HPG axis by environmental chemicals can alter sex steroid levels, leading to reproductive dysfunction. In female fathead minnows (Pimephalespromelas, abbreviated FHM), inhibition of aromatase (CYP19A), which converts testosterone into 17&beta;-estradiol (E2), impairs oogenesis and reproduction. The key anatomical and regulatory components of the FHM HPG axis have been identified before using expert elicitation, which were coded into a differential equation-based computational model (Breen et al., 2013). In this model, the body of the FHM is represented by six tissue compartments: gill, brain (as a tissue including hypothalamic-pituitary complex), ovary, liver, venous blood, and rest of body. The rest of body compartment accounts for blood flow and tissue volume not directly associated with the HPG axis or reproductive function. The key input from the expert elicitation was identification of a regulatory loop that senses decreased levels of E2 and upregulates aromatase activity in an attempt to compensate for its inhibition. This regulatory loop identified thorough expert elicitation involves (i) sensing changes in the circulating E2 level in the brain compartment; (ii) release from the brain of a signaling molecule (analogous to LH and FSH); (iii) interaction of these signaling molecules with receptors at the ovary-blood interface; (iv) an increased production of ovarian aromatase mRNA as a function of the amount of signal receptor complex; and, finally, (v) translation of the mRNA into new aromatase protein.</p></</body>\n</html>")
								.<DescriptionSection> makeItLive();
				sum.setFormat(ContentFormat.HTML);
				gm1.getDescriptionIDs().set(sum, 0);
				
				DescriptionSection mm = new DescriptionSection(gm1, dataSource, "Methods and Materials", "https://app.effectopedia.org/media/content/Methods_HPG.xhtml").<DescriptionSection> makeItLive();
				mm.setFormat(ContentFormat.HTML);
				gm1.getDescriptionIDs().add(mm);
				
				gm1.getModelCallers().add(test_insilico25);
				test_insilico25.getGlobalModelIDs().add(gm1);
				gm1.getModelCallers().add(test_insilico35);
				test_insilico35.getGlobalModelIDs().add(gm1);
				gm1.getModelCallers().add(test_insilico39);
				test_insilico39.getGlobalModelIDs().add(gm1);
				
				ObjectProperties modelParameters = gm1.getModelParamaters();
				ObjectPropertyType opt1 = new ObjectPropertyType("V.1.1", "ki_fad", "ki_fad", null, Method_InSilicoGlobalModel.class,
						"Inhibition constant for the chemical (Fadrozole)", DataValue_Double.class, new DataUnit("uMol/L"), ActionTypes.GM_PARAMETER).makeDocumented(null).makeItLive();
				ObjectPropertyMultivalued_Documented op1 = new ObjectPropertyMultivalued_Documented(gm1, opt1);
				String[][] values = new String[][]
					{
					{ "5.52E-05", "1E-06", "1E-4", null, "",
					"Cheng WY, Q Zhang, A Schroeder, DL Villeneuve, GT Ankley, R Conolly, Computational Modeling of Plasma Vitellogenin Alterations in Response to Aromatase Inhibition in Fathead Minnows,Toxicological Sciences 154 (1), 78-89" } };
				op1.assign(values);
				modelParameters.add(op1);
				
				ObjectPropertyType opt2 = new ObjectPropertyType("V.1.2", "ksyn_vtg", "ksyn_vtg", null, Method_InSilicoGlobalModel.class, "Synthesis rate of VTG influenced by E2",
						DataValue_Double.class, new DataUnit("l"), ActionTypes.GM_PARAMETER).makeDocumented(null).makeItLive();
				ObjectPropertyMultivalued_Documented op2 = new ObjectPropertyMultivalued_Documented(gm1, opt2);
				values = new String[][]
					{
							{ "874.6797064", "700", "1000", null, "",
							"Cheng WY, Q Zhang, A Schroeder, DL Villeneuve, GT Ankley, R Conolly, Computational Modeling of Plasma Vitellogenin Alterations in Response to Aromatase Inhibition in Fathead Minnows,Toxicological Sciences 154 (1), 78-89" } };
				op2.assign(values);
				modelParameters.add(op2);
				
				ObjectPropertyType opt3 = new ObjectPropertyType("V.1.3", "k_storageVTGovary", "k_storageVTGovary", null, Method_InSilicoGlobalModel.class, "Storage rate of VTG to the ovary", DataValue_Double.class,
						null, ActionTypes.GM_PARAMETER).makeDocumented(null).makeItLive();
				ObjectPropertyMultivalued_Documented op3 = new ObjectPropertyMultivalued_Documented(gm1, opt3);
				values = new String[][]
					{
							{ "1", "0.9", "1", null, "",
							"Cheng WY, Q Zhang, A Schroeder, DL Villeneuve, GT Ankley, R Conolly, Computational Modeling of Plasma Vitellogenin Alterations in Response to Aromatase Inhibition in Fathead Minnows,Toxicological Sciences 154 (1), 78-89" } };
				op3.assign(values);
				modelParameters.add(op3);
				
				ObjectPropertyType opt4 = new ObjectPropertyType("V.1.4", "ksynVTGreceptor", "ksynVTGreceptor", null, Method_InSilicoGlobalModel.class, "Synthesis rate of VTG receptor (transporter) to carry VTG into the ovary", DataValue_Double.class,
						null, ActionTypes.GM_PARAMETER).makeDocumented(null).makeItLive();
				ObjectPropertyMultivalued_Documented op4 = new ObjectPropertyMultivalued_Documented(gm1, opt4);
				values = new String[][]
					{
							{ "0.001088994", "1E-4", "1E-2", null, "",
							"Cheng WY, Q Zhang, A Schroeder, DL Villeneuve, GT Ankley, R Conolly, Computational Modeling of Plasma Vitellogenin Alterations in Response to Aromatase Inhibition in Fathead Minnows,Toxicological Sciences 154 (1), 78-89" } };
				op4.assign(values);
				modelParameters.add(op4);
				
				ObjectProperties modelMetaData = gm1.getModelMetadata();
				modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_LICENSE).setValue("General Public License (GPL V 3.0)");
				modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_VERSION).setValue("1.0");
				modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_CITATION).setValue("Cheng WY, Q Zhang, A Schroeder, DL Villeneuve, GT Ankley, R Conolly, Computational Modeling of Plasma Vitellogenin Alterations in Response to Aromatase Inhibition in Fathead Minnows,Toxicological Sciences 154 (1), 78-89");
				ObjectProperties sysReq = modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQUIREMENTS).getValueAndUnit().getSubProperties();
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_CMD_LINE_OPT).setValue("none");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_EST_RUNTIME).setValue("seconds");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_LIBRARIES).setValue("no additional libraries required");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_OS).setValue("Windows, Linux, Mac OS");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_PROG_LANGUAGE).setValue("Matlab");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_PROG_OPT).setValue("default");
				
				IDs<Resource> gm1resources = DefaultEffectopediaObjects.DEFAULT_MATLAB_RECOURCE_IDS.clone(gm1, gm1.getDataSource());
				gm1resources.getCachedObject(0).makeItLive();
				gm1resources.getCachedObject(1).setName("FHM_Dose_Percent_Inh_run");
				gm1resources.getCachedObject(1).setContent("%%Rory Conolly\n%March 17, 2017\n%% \n \n%% Development notes\n%January 31, 2017\n%The fathead minnow (FHM) model of WanYun Cheng (Toxicol. Sci. 154,\n%78 - 89, 2016 doi: 10.1093/toxsci/kfw142) was coded in Simbiology. \n%The current effort is to develop a plain MATLAB version for use in \n%Effectopedia - collaboration with WanYun and Hristo Aladjov\n \n%February 21, 2017\n%Model now runs as MATLAB script for plasma E2 and plasma VTG simulations. \n%Now will modify this code to simulate fold change in ovarian CYP19A mRNA. \n%The fold change simualtion requires that the model be run twice, so that \n%mRNA levels for some nonzero exposure to fadrozole can be examined as a \n%ratio to the control levels (i.e., exposed/control).\n \n%February 26, 2017\n%Started work on modifying this code to run dose-response simulations.\n \n%February 26, 2017\n%Modified to predict effect of iprodione exposure on plasma VTG, using a\n%TEF of 0.02 based on the ToxCast cell-based assay for inhibition or\n%aromatase.\n%% \n \n%% INITIAL\n"+
				"clc\ndisp('Running FHM_Dose_Response_run...')\n \nformat shorte\nglobal param\nglobal INPUT\nglobal OUTPUT\n \ntic ;%Starts the timer; toc at end gives elapsed time\n \nFHM_Init_Parameters; %initializes parameter values\n \n%Simulation setup\n%Use an initial run to allow the model to stabilize, a second run \n% where the fish are dosed with fadrozole, and finally a third run \n% for depuration\n% (initialization)-(FAD exposure) - (depuration)\ninitialization_duration = 2000; %hr\nexposure_start_time = 0; %keep at zero\nexposure_duration = 504; %hours Runor a long time to reach\n                                %steady state \ndepuration_duration = 0; %(hours) Don't want to depurate for a dose-\n                         %response \nrun_start_time  = exposure_start_time - initialization_duration;\ninitialization_end_time = exposure_start_time;\nexposure_end_time = exposure_duration;\n \n%ODES are solved from one event to the next\nevent_list = [run_start_time          %start initialization\n              initialization_end_time\n              exposure_start_time\n              exposure_end_time];          %end of depuration\n \n%Set up a vector of doses using Effectopedia input\ndoses = log10(INPUT.Tested_Subst_Measured_Log_Conc_nom_chemical_concentration);\ndoses = [0, doses]; %include control\ndose_response_data = -1 * ones(length(doses), length(y0));\nactivity = zeros(length(doses),1); %To hold CYP19A activities\n          \n%Fadrozole was dosed as ug/L. Need to convert to umol/L for use here.\n%Fadrozole MW = 223 (g/mol or ug/umol))\nFAD_MW = 223; %(g/mol or ug/umol))\n \n%End of INITIAL section\n%%\n \n%%\n%DYNAMIC \n \n"+
				"for jjj = 1 : length(doses)\n    \n    disp(['Running dose ' num2str(doses(jjj)) ' ug/L'])\n    timex = []; %initialize\n    simdatax = []; %initialize\n    \n    %Convert ug/L to umol/L by dividing by the MW\n    %For example, (30 ug/L)/(223 ug/umol) = 1.3453e-1 umol/L\n    %FAD_dose is how the exposure was described for the FHM experiments\n    %param.FAD_conc is the exposure in ug/L converted to umol/L to  use in\n    %this model\n    param.FAD_conc = doses(jjj) / FAD_MW; %umol/L (uM)\n \n    %Run the model, stepping through the event list at each dose\n \n    for i = 1:2:length(event_list)\n    \n        %Set the interval for simualtion\n        tspan = event_list(i):event_list(i+1);\n    \n        %FAD dosing after initialization is complete\n        if tspan(1) == exposure_start_time %start of exposure to FAD\n            param.F_conc = param.FAD_conc;\n        else\n            param.F_conc = 0;\n        end\n            \n        %Initial Conditions for solution of ODEs:\n        if i ~= 1\n            y0 = simdata(end,:); %Set initial conditions to values from \n                         %end of the previous run\n        end\n    \n        %SOLVING THE ODEs\n        % odeset sets parameters for the ODE solver\n        options = odeset('RelTol', 1.e-12, 'AbsTol', 1.e-12, 'BDF', 'off' );\n \n        %MATLAB integration algorithms\n        % ode15s, ode23s, ode23t, ode23tb, ode45, ode23, ode113\n        [time,simdata] = ode15s('FHM_ode',tspan,y0,options);\n  \n    end\n    \n    %Save dose-response data\n    dose_response_data(jjj,:) = simdata(end,:); \n    \n    %Ovarian CYP19A activity\n    %Calculation for CYP19A activity (not a state variable)\n    Vmax = param.kcat_CYP19A * simdata(end,3)* param.V_Ovary;\n    activity(jjj) = Vmax*simdata(end,5) ...\n                         /(param.Km_T*(1+(simdata(end,1)/param.Ki_fad)) ...\n                         +simdata(end,5));\n                   \nend\n \n%End of DYNAMIC\n%%\n%POSTPROCESSING\ndisp('Postprocessing...')\n \n%State variables\n%1 FAD in ovary\n%2 E2 in ovary\n%3 CYP19A in ovary\n%4 CYP19A mRNA in ovary\n%5 T (testosterone) in ovary\n%6 FAD in liver\n%7 E2 in liver\n%8 FAD in rest of body\n%9 E2 in rest of body\n%10 FAD in venous blood\n%11 E2 in venous blood\n%12 Free form of LHFSH receptor \n%13 LHFSH in venous blood\n%14 VTG in venous blood\n%15 FAD in venous blood from brain\n%16 E2 in venous blood from brain\n%17 LHFSH in venous blood from brain\n%18 FAD in water (This equation not used in MATLAB version of the model\n%19 VTG in ovary blood\n%20 VTG in liver blood\n%21 VTG in brain blood\n%22 VTG in rest of body blood\n%23 VTG in gill blood\n%24 VTG receptor in ovary\n%25 VTG in ovary\n%26 VTG in  liver\n \n%Specify a TEF. Default is fadrozole TEF == 1\nfadrozole = false; %Set to false if some other chemical\nif fadrozole\n    TEF = 1;\nelse\n    TEF = 0.03; %iprodione\nend\n \n%Exporting to Effectopedia...\n %export ovarian CYP19A activity as a function of iprodione concentration\n %convert CYP19A activity into percent inhibition\n activity = 100*activity/max(activity);\n activity = 100 - activity; %% inhibition\n \n %Set Effectopedia output to % Inhibition dose response \n OUTPUT.Tested_Subst_Log_Conc_Response_chemical_concentration = INPUT.Tested_Subst_Measured_Log_Conc_nom_chemical_concentration;\n OUTPUT.Tested_Subst_Log_Conc_Response = real(activity);\n OUTPUT.Tested_Subst_Log_Conc_Response(1) = []; %remomve control\n not_calculated = [];\n OUTPUT.Tested_Subst_Log_Conc_Response_time = not_calculated; % Time\n OUTPUT.Tested_Subst_Log_Conc_Response_stdiv_error = not_calculated; % Standard diviation error\n OUTPUT.Tested_Subst_Log_Conc_Response_sem_error = not_calculated; %% Standard error of mean\n OUTPUT.Tested_Subst_Log_Conc_Response_ci95_error = not_calculated; % 95% Confidence interval of mean\n OUTPUT.Tested_Subst_Log_Conc_Response_median = not_calculated; % Median value\n \ndisp('    ')\ndisp('Finished')\ndisp(['Run lasted ' num2str(round(toc)/60) ' minutes'])\n \n%End of Program\n%%\n\n");
				Resource model2 = new Resource(gm1resources, dataSource);
				model2.setResourceType(ResourceType.MATLAB_SOURCE_CODE);
				model2.setName("FHM_Dose_Plasma_E2_run");
				model2.setContent("%%Rory Conolly\n%March 17, 2017\n%% \n \n%% Development notes\n%January 31, 2017\n%The fathead minnow (FHM) model of WanYun Cheng (Toxicol. Sci. 154,\n%78 - 89, 2016 doi: 10.1093/toxsci/kfw142) was coded in Simbiology. \n%The current effort is to develop a plain MATLAB version for use in \n%Effectopedia - collaboration with WanYun and Hristo Aladjov\n \n%February 21, 2017\n%Model now runs as MATLAB script for plasma E2 and plasma VTG simulations. \n%Now will modify this code to simulate fold change in ovarian CYP19A mRNA. \n%The fold change simualtion requires that the model be run twice, so that \n%mRNA levels for some nonzero exposure to fadrozole can be examined as a \n%ratio to the control levels (i.e., exposed/control).\n \n%February 26, 2017\n%Started work on modifying this code to run dose-response simulations.\n \n%February 26, 2017\n%Modified to predict effect of iprodione exposure on plasma VTG, using a\n%TEF of 0.02 based on the ToxCast cell-based assay for inhibition or\n%aromatase.\n%% \n \n%% INITIAL\n"
						+ "clc\ndisp('Running FHM_Dose_Response_run...')\n \nformat shorte\nglobal param\nglobal INPUT\nglobal OUTPUT\n \ntic ;%Starts the timer; toc at end gives elapsed time\n \nFHM_Init_Parameters; %initializes parameter values\n \n%Simulation setup\n%Use an initial run to allow the model to stabilize, a second run \n% where the fish are dosed with fadrozole, and finally a third run \n% for depuration\n% (initialization)-(FAD exposure) - (depuration)\ninitialization_duration = 2000; %hr\nexposure_start_time = 0; %keep at zero\nexposure_duration = 504; %hours Runor a long time to reach\n                                %steady state \ndepuration_duration = 0; %(hours) Don't want to depurate for a dose-\n                         %response \nrun_start_time  = exposure_start_time - initialization_duration;\ninitialization_end_time = exposure_start_time;\nexposure_end_time = exposure_duration;\n \n%ODES are solved from one event to the next\nevent_list = [run_start_time          %start initialization\n              initialization_end_time\n              exposure_start_time\n              exposure_end_time];          %end of depuration\n \n%Set up a vector of doses using Effectopedia input\ndoses = log10(INPUT.Tested_Subst_Measured_Log_Conc_nom_chemical_concentration);\ndoses = [0, doses]; %include control\ndose_response_data = -1 * ones(length(doses), length(y0));\nactivity = zeros(length(doses),1); %To hold CYP19A activities\n          \n%Fadrozole was dosed as ug/L. Need to convert to umol/L for use here.\n%Fadrozole MW = 223 (g/mol or ug/umol))\nFAD_MW = 223; %(g/mol or ug/umol))\n \n%End of INITIAL section\n%%\n \n%%\n%DYNAMIC \n \n"
						+ "for jjj = 1 : length(doses)\n    \n    disp(['Running dose ' num2str(doses(jjj)) ' ug/L'])\n    timex = []; %initialize\n    simdatax = []; %initialize\n    \n    %Convert ug/L to umol/L by dividing by the MW\n    %For example, (30 ug/L)/(223 ug/umol) = 1.3453e-1 umol/L\n    %FAD_dose is how the exposure was described for the FHM experiments\n    %param.FAD_conc is the exposure in ug/L converted to umol/L to  use in\n    %this model\n    param.FAD_conc = doses(jjj) / FAD_MW; %umol/L (uM)\n \n    %Run the model, stepping through the event list at each dose\n \n    for i = 1:2:length(event_list)\n    \n        %Set the interval for simualtion\n        tspan = event_list(i):event_list(i+1);\n    \n        %FAD dosing after initialization is complete\n        if tspan(1) == exposure_start_time %start of exposure to FAD\n            param.F_conc = param.FAD_conc;\n        else\n            param.F_conc = 0;\n        end\n            \n        %Initial Conditions for solution of ODEs:\n        if i ~= 1\n            y0 = simdata(end,:); %Set initial conditions to values from \n                         %end of the previous run\n        end\n    \n        %SOLVING THE ODEs\n        % odeset sets parameters for the ODE solver\n        options = odeset('RelTol', 1.e-12, 'AbsTol', 1.e-12, 'BDF', 'off' );\n \n        %MATLAB integration algorithms\n        % ode15s, ode23s, ode23t, ode23tb, ode45, ode23, ode113\n        [time,simdata] = ode15s('FHM_ode',tspan,y0,options);\n  \n    end\n    \n    %Save dose-response data\n    dose_response_data(jjj,:) = simdata(end,:); \n    \n    %Ovarian CYP19A activity\n    %Calculation for CYP19A activity (not a state variable)\n    Vmax = param.kcat_CYP19A * simdata(end,3)* param.V_Ovary;\n    activity(jjj) = Vmax*simdata(end,5) ...\n                         /(param.Km_T*(1+(simdata(end,1)/param.Ki_fad)) ...\n                         +simdata(end,5));\n                   \nend\n \n%End of DYNAMIC\n%%\n%POSTPROCESSING\ndisp('Postprocessing...')\n \n%State variables\n%1 FAD in ovary\n%2 E2 in ovary\n%3 CYP19A in ovary\n%4 CYP19A mRNA in ovary\n%5 T (testosterone) in ovary\n%6 FAD in liver\n%7 E2 in liver\n%8 FAD in rest of body\n%9 E2 in rest of body\n%10 FAD in venous blood\n%11 E2 in venous blood\n%12 Free form of LHFSH receptor \n%13 LHFSH in venous blood\n%14 VTG in venous blood\n%15 FAD in venous blood from brain\n%16 E2 in venous blood from brain\n%17 LHFSH in venous blood from brain\n%18 FAD in water (This equation not used in MATLAB version of the model\n%19 VTG in ovary blood\n%20 VTG in liver blood\n%21 VTG in brain blood\n%22 VTG in rest of body blood\n%23 VTG in gill blood\n%24 VTG receptor in ovary\n%25 VTG in ovary\n%26 VTG in  liver\n \n%Specify a TEF. Default is fadrozole TEF == 1\nfadrozole = false; %Set to false if some other chemical\nif fadrozole\n    TEF = 1;\nelse\n    TEF = 0.03; %iprodione\nend\n \n%Exporting to Effectopedia...\n%Select the state to export\nstate = 11; % Plasma E2 uM\n \n%Set Effectopedia output to % Plasma E2 dose response \n OUTPUT.Tested_Subst_Log_Conc_Response_chemical_concentration = INPUT.Tested_Subst_Measured_Log_Conc_nom_chemical_concentration;\n OUTPUT.Tested_Subst_Log_Conc_Response = real(dose_response_data(:,state));\n OUTPUT.Tested_Subst_Log_Conc_Response(1) = []; %remomve control\n not_calculated = [];\n OUTPUT.Tested_Subst_Log_Conc_Response_time = not_calculated; % Time\n OUTPUT.Tested_Subst_Log_Conc_Response_stdiv_error = not_calculated; % Standard diviation error\n OUTPUT.Tested_Subst_Log_Conc_Response_sem_error = not_calculated; %% Standard error of mean\n OUTPUT.Tested_Subst_Log_Conc_Response_ci95_error = not_calculated; % 95% Confidence interval of mean\n OUTPUT.Tested_Subst_Log_Conc_Response_median = not_calculated; % Median value\n \ndisp('    ')\ndisp('Finished')\ndisp(['Run lasted ' num2str(round(toc)/60) ' minutes'])\n \n%End of Program\n%%\n\n");
				gm1resources.add(model2);

				Resource model3 = new Resource(gm1resources, dataSource);
				model3.setResourceType(ResourceType.MATLAB_SOURCE_CODE);
				model3.setName("FHM_Dose_Plasma_VTG_run");
				model3.setContent("%%Rory Conolly\n%March 17, 2017\n%% \n \n%% Development notes\n%January 31, 2017\n%The fathead minnow (FHM) model of WanYun Cheng (Toxicol. Sci. 154,\n%78 - 89, 2016 doi: 10.1093/toxsci/kfw142) was coded in Simbiology. \n%The current effort is to develop a plain MATLAB version for use in \n%Effectopedia - collaboration with WanYun and Hristo Aladjov\n \n%February 21, 2017\n%Model now runs as MATLAB script for plasma E2 and plasma VTG simulations. \n%Now will modify this code to simulate fold change in ovarian CYP19A mRNA. \n%The fold change simualtion requires that the model be run twice, so that \n%mRNA levels for some nonzero exposure to fadrozole can be examined as a \n%ratio to the control levels (i.e., exposed/control).\n \n%February 26, 2017\n%Started work on modifying this code to run dose-response simulations.\n \n%February 26, 2017\n%Modified to predict effect of iprodione exposure on plasma VTG, using a\n%TEF of 0.02 based on the ToxCast cell-based assay for inhibition or\n%aromatase.\n%% \n \n%% INITIAL\n"+
				"clc\ndisp('Running FHM_Dose_Response_run...')\n \nformat shorte\nglobal param\nglobal INPUT\nglobal OUTPUT\n \ntic ;%Starts the timer; toc at end gives elapsed time\n \nFHM_Init_Parameters; %initializes parameter values\n \n%Simulation setup\n%Use an initial run to allow the model to stabilize, a second run \n% where the fish are dosed with fadrozole, and finally a third run \n% for depuration\n% (initialization)-(FAD exposure) - (depuration)\ninitialization_duration = 2000; %hr\nexposure_start_time = 0; %keep at zero\nexposure_duration = 504; %hours Runor a long time to reach\n                                %steady state \ndepuration_duration = 0; %(hours) Don't want to depurate for a dose-\n                         %response \nrun_start_time  = exposure_start_time - initialization_duration;\ninitialization_end_time = exposure_start_time;\nexposure_end_time = exposure_duration;\n \n%ODES are solved from one event to the next\nevent_list = [run_start_time          %start initialization\n              initialization_end_time\n              exposure_start_time\n              exposure_end_time];          %end of depuration\n \n%Set up a vector of doses using Effectopedia input\ndoses = log10(INPUT.Tested_Subst_Measured_Log_Conc_nom_chemical_concentration);\ndoses = [0, doses]; %include control\ndose_response_data = -1 * ones(length(doses), length(y0));\nactivity = zeros(length(doses),1); %To hold CYP19A activities\n          \n%Fadrozole was dosed as ug/L. Need to convert to umol/L for use here.\n%Fadrozole MW = 223 (g/mol or ug/umol))\nFAD_MW = 223; %(g/mol or ug/umol))\n \n%End of INITIAL section\n%%\n \n%%\n%DYNAMIC \n \n"+
				"for jjj = 1 : length(doses)\n    \n    disp(['Running dose ' num2str(doses(jjj)) ' ug/L'])\n    timex = []; %initialize\n    simdatax = []; %initialize\n    \n    %Convert ug/L to umol/L by dividing by the MW\n    %For example, (30 ug/L)/(223 ug/umol) = 1.3453e-1 umol/L\n    %FAD_dose is how the exposure was described for the FHM experiments\n    %param.FAD_conc is the exposure in ug/L converted to umol/L to  use in\n    %this model\n    param.FAD_conc = doses(jjj) / FAD_MW; %umol/L (uM)\n \n    %Run the model, stepping through the event list at each dose\n \n    for i = 1:2:length(event_list)\n    \n        %Set the interval for simualtion\n        tspan = event_list(i):event_list(i+1);\n    \n        %FAD dosing after initialization is complete\n        if tspan(1) == exposure_start_time %start of exposure to FAD\n            param.F_conc = param.FAD_conc;\n        else\n            param.F_conc = 0;\n        end\n            \n        %Initial Conditions for solution of ODEs:\n        if i ~= 1\n            y0 = simdata(end,:); %Set initial conditions to values from \n                         %end of the previous run\n        end\n    \n        %SOLVING THE ODEs\n        % odeset sets parameters for the ODE solver\n        options = odeset('RelTol', 1.e-12, 'AbsTol', 1.e-12, 'BDF', 'off' );\n \n        %MATLAB integration algorithms\n        % ode15s, ode23s, ode23t, ode23tb, ode45, ode23, ode113\n        [time,simdata] = ode15s('FHM_ode',tspan,y0,options);\n  \n    end\n    \n    %Save dose-response data\n    dose_response_data(jjj,:) = simdata(end,:); \n    \n    %Ovarian CYP19A activity\n    %Calculation for CYP19A activity (not a state variable)\n    Vmax = param.kcat_CYP19A * simdata(end,3)* param.V_Ovary;\n    activity(jjj) = Vmax*simdata(end,5) ...\n                         /(param.Km_T*(1+(simdata(end,1)/param.Ki_fad)) ...\n                         +simdata(end,5));\n                   \nend\n \n%End of DYNAMIC\n%%\n%POSTPROCESSING\ndisp('Postprocessing...')\n \n%State variables\n%1 FAD in ovary\n%2 E2 in ovary\n%3 CYP19A in ovary\n%4 CYP19A mRNA in ovary\n%5 T (testosterone) in ovary\n%6 FAD in liver\n%7 E2 in liver\n%8 FAD in rest of body\n%9 E2 in rest of body\n%10 FAD in venous blood\n%11 E2 in venous blood\n%12 Free form of LHFSH receptor \n%13 LHFSH in venous blood\n%14 VTG in venous blood\n%15 FAD in venous blood from brain\n%16 E2 in venous blood from brain\n%17 LHFSH in venous blood from brain\n%18 FAD in water (This equation not used in MATLAB version of the model\n%19 VTG in ovary blood\n%20 VTG in liver blood\n%21 VTG in brain blood\n%22 VTG in rest of body blood\n%23 VTG in gill blood\n%24 VTG receptor in ovary\n%25 VTG in ovary\n%26 VTG in  liver\n \n%Specify a TEF. Default is fadrozole TEF == 1\nfadrozole = false; %Set to false if some other chemical\nif fadrozole\n    TEF = 1;\nelse\n    TEF = 0.03; %iprodione\nend\n \n%Exporting to Effectopedia...\n%Select the state to export\nstate = 14; % Plasma VTG uM\n \n%Set Effectopedia output to % Plasma VTG dose response \n OUTPUT.Tested_Subst_Log_Conc_Response_chemical_concentration = INPUT.Tested_Subst_Measured_Log_Conc_nom_chemical_concentration;\n OUTPUT.Tested_Subst_Log_Conc_Response = real(dose_response_data(:,state));\n OUTPUT.Tested_Subst_Log_Conc_Response(1) = []; %remomve control\n not_calculated = [];\n OUTPUT.Tested_Subst_Log_Conc_Response_time = not_calculated; % Time\n OUTPUT.Tested_Subst_Log_Conc_Response_stdiv_error = not_calculated; % Standard diviation error\n OUTPUT.Tested_Subst_Log_Conc_Response_sem_error = not_calculated; %% Standard error of mean\n OUTPUT.Tested_Subst_Log_Conc_Response_ci95_error = not_calculated; % 95% Confidence interval of mean\n OUTPUT.Tested_Subst_Log_Conc_Response_median = not_calculated; % Median value\n \ndisp('    ')\ndisp('Finished')\ndisp(['Run lasted ' num2str(round(toc)/60) ' minutes'])\n \n%End of Program\n%%\n\n");
				gm1resources.add(model3);

				Resource initial = new Resource(gm1resources, dataSource);
				initial.setName("FHM_Init_Parameters");
				initial.setResourceType(ResourceType.MATLAB_SOURCE_CODE);
				initial.setContent("%FHM_initial\n%Rory Conolly\n%February 4, 2017\nglobal MODPAR\n \n%Brain\nparam.V_Brain = 1.20E-05;      %    \nparam.V_BrainBlood = 1.20E-07; %\nparam.E2 = 0;           %V_BrainBlood.E2\nparam.FAD = 0;           %V_BrainBlood.FAD\nparam.LHFSH = 0;%        V_BrainBlood.LHFSH\n \n%Gill\nparam.V_Gill = 1.58E-05; %V_BrainBlood.V_Gill\nparam.V_GillBlood = 1.58E-07 ;%\n \n%Liver\nparam.V_Liver = 2.40E-05; % \nparam.V_LiverBlood = 2.40E-07; %    \nparam.V_LiverTissue = 2.38E-05; %   \n \n%Ovary\nparam.V_Ovary = 1.44E-04    ;%  \nparam.V_OvaryBlood =    1.44E-06    ;%  \nparam.V_OvaryTissue = 1.43E-04; %   \n \n%ROB\nparam.V_ROB = 7.27E-04  ;%Volume ROB tissue \nparam.V_RobBlood =  7.26E-06; % \n \n%Venous blood\nparam.V_Venous =    2.45E-05; %Volume venous blood  \n \n%Water in the fish tank\nparam.V_Water = 100.    ;%Liters\n \n%Model Scoped Parameters\n% In SimBiology, parameters can be associated either with a model \n% (sometimes called 'model-scoped parameters') or with a kinetic law of a \n% reaction ('reaction-scoped parameters'). A model-scoped parameter is \n% visible throughout the model and can be used in any reaction, event, or\n% rule. A reaction-scoped parameter can only be used in the rate of the \n% reaction that it's associated with.\nparam.A_LHFSH_venous_free = 0   ;%  \nparam.A_R_LHFSH_free =  2.88E-07    ;%  \nparam.A_R_LHFSH_total = 2.88E-07    ;%  \nparam.k_LHFSH = 0.0344  ;%  \nparam.k_LHFSH_off = 0.0139  ;%  \nparam.k_LHFSH_on =  7.86E-05    ;%  \nparam.k_loss_CYP19A =   0.02056 ;%  \nparam.k_loss_E2 =   3.73    ;%  \nparam.k_loss_FAD =  46.98   ; %First-order FAD clearance in liver   \nparam.k_loss_FAD_water =    1   ;%First-order FAD clearance in water    \nparam.k_loss_LHFSH =    797 ;%  \nparam.k_loss_LHFSH_brain =  48  ;%  \nparam.k_loss_mRNA = 8.02    ;%  \nparam.k_loss_T =    1.0897  ;%  \nparam.k_storageVTGovary =   MODPAR.k_storageVTGovary   ;%  \nparam.k_syn_LHFSH = 8   ;%  \nparam.ka_syn_mRNA = 3.43E-10    ;%  \nparam.KaVTGreceptor =   0.995335982 ;%  \nparam.kcat_CYP19A   =   3.01E-04    ;%  \nparam.kcatVTGtransport =    0.458818195 ;%  \nparam.kdegVTGreceptor = 0.012917039 ;%  \nparam.ki_E2 =   2.61E-05    ;%  \nparam.Ki_fad =  MODPAR.ki_fad;%  \nparam.km_syn_CYP19A =   4428    ;%  \nparam.Km_T =    3.37E-05    ;%  \nparam.KmVTGtransport =  618.9233258 ;%  \nparam.ksyn_mRNA_basel = 1.79E-10    ;%  \nparam.ksyn_mRNA_max =   164 ;%  \nparam.ksyn_T =  1.84E-06    ;%  \nparam.ksyn_vtg =    MODPAR.ksyn_vtg ;%  \nparam.ksynVTGreceptor = MODPAR.ksynVTGreceptor;%  \nparam.kVTGtransfer =    0.065733656 ;%  \nparam.LVTGtransfer =    6.50E-04    ;%  \nparam.mass =    0   ;%  \nparam.n1 =  3.855   ;%  \nparam.OVTGtransfer_rate =   0   ;%  \n \nparam.P_e2_brain_blood =    1   ;%  \nparam.P_e2_liver_blood =    1   ;%  \nparam.P_e2_ovary_blood =    1   ;%  \nparam.P_e2_rob_blood = 1    ;%  \nparam.P_fad_brain_blood =   1   ;%  \nparam.P_fad_liver_blood =   1   ;%  \nparam.P_fad_ovary_blood =   1   ;%  \nparam.P_fad_rob_blood = 1   ;%  \nparam.P_fad_water_blood =   1   ;%  \n \nparam.Qbrain =  4.25E-04    ;%  \nparam.Qcardiac =    0.0111  ;%  \nparam.Qliver =  6.50E-04    ;%  \nparam.Qovary =  0.006292    ;%  \nparam.Qrob =    0.003738    ;%  \n \nparam.QVTGcardiac = 0.0111  ;%  \nparam.QVTGliver =   6.50E-04    ;%  \nparam.QVTGovary =   0.006292    ;%  \n \nparam.Qwater_gill = 0.05714 ;%  \n \nparam.Vmax_CYP19A = 0   ;%  \nparam.Vmax_syn_CYP19A = 0.00207 ;%  \nparam.VmaxVTGtransport =    0   ;%  \n \n%State variable initial conditions\n%y0 is the vector of state variable initial conditions\nV_Ovary.FAD = 0.;\nV_Ovary.E2 = 0.;\nCYP19A = 0;%    V_Ovary.CYP19A\nCYP19AmRNA = 1.00E-06; %    V_Ovary.CYP19AmRNA\nT = 0   ; %V_Ovary.T\nV_Liver.FAD = 0.;\nV_Liver.E2 = 0.;\nV_ROB.FAD = 0.;\nV_ROB.E2 = 0.;\nV_Venous.FAD = 0;\nE21 = 0; %V_Venous.E21\nLHFSH_R_LHFSH = 0; %V_Venous.LHFSH_R_LHFSH\nV_Venous.LHFSH = 0.;\nVVTG = 0; %V_Venous.VVTG\nV_Brain.FAD = 0; %V_Brain.FAD initial value\nV_Brain.E2 = 0; %V_Brain.E2 initial value\nV_Brain.LHFSH = 0; %V_Brain.LHFSH initial value\nV_Water.FAD = 0.;\nOBVTG = 0; %V_OvaryBlood.OBVTG\nLBVTG = 0; %V_LiverBlood.LBVTG\nBBVTG = 0; %BrainBlood.BBVTG initial value\nRBVTG = 0; %V_RobBlood.RBVTG\nGVTG = 0; %V_GillBlood.GVTG\nVTGreceptor = 0; %V_OvaryTissue.VTGreceptor\nOVTG =  0 ; %V_OvaryTissue.OVTG\nLVTG = 0 ; %V_LiverTissue.LVTG\n \n%Vector of initial conditions for passing to integration algorithm\ny0 = [ V_Ovary.FAD;\n    V_Ovary.E2;\n    CYP19A %    V_Ovary.CYP19A\n    CYP19AmRNA  %   V_Ovary.CYP19AmRNA\n    T           %V_Ovary.T\n    V_Liver.FAD\n    V_Liver.E2\n    V_ROB.FAD\n    V_ROB.E2\n    V_Venous.FAD\n    E21\n    LHFSH_R_LHFSH %V_Venous.LHFSH_R_LHFSH\n    V_Venous.LHFSH\n    VVTG\n    V_Brain.FAD  %V_Brain.FAD initial value\n    V_Brain.E2 %V_Brain.E2 initial value\n    V_Brain.LHFSH %V_Brain.LHFSH initial value\n    V_Water.FAD\n    OBVTG %V_OvaryBlood.OBVTG\n    LBVTG %V_LiverBlood.LBVTG\n    BBVTG %BrainBlood.BBVTG initial value\n    RBVTG %V_RobBlood.RBVTG\n    GVTG %V_GillBlood.GVTG\n    VTGreceptor %V_OvaryTissue.VTGreceptor\n    OVTG %V_OvaryTissue.OVTG\n    LVTG ]; %V_LiverTissue.LVTG\n \n \n \n\n\n");
				gm1resources.add(initial);

				Resource ode = new Resource(gm1resources, dataSource);
				ode.setName("FHM_ode");
				ode.setResourceType(ResourceType.MATLAB_SOURCE_CODE);
				ode.setContent("%%ODE file for FHM model\n%Rory Conolly\n%February 20, 2017\n%%\n \n%%\nfunction integrate = FHM_ode(~,statevalues)\n \nglobal param; %everything that starts with param is global\nintegrate = zeros(length(statevalues),1) ;%initialize\n%%\n \n%%\n%Get the results of the integration\nV_Ovary.FAD = statevalues(1);      %\nV_Ovary.E2 = statevalues(2);      %\nCYP19A = statevalues(3);      %\nCYP19AmRNA = statevalues(4);      %\nT = statevalues(5);      %\nV_Liver.FAD = statevalues(6);      %\nV_Liver.E2 = statevalues(7);      %\nV_ROB.FAD = statevalues(8);      %\nV_ROB.E2 = statevalues(9);      %\nV_Venous.FAD = statevalues(10);      %\nE21 = statevalues(11);      %\nLHFSH_R_LHFSH = statevalues(12);      %\nV_Venous.LHFSH = statevalues(13);      %\nVVTG = statevalues(14);      %\nV_Brain.FAD = statevalues(15);      %\nV_Brain.E2 = statevalues(16);      %\nV_Brain.LHFSH = statevalues(17);      %\nV_Water.FAD = statevalues(18);      %\nOBVTG = statevalues(19);      %\nLBVTG = statevalues(20);      %\nBBVTG = statevalues(21);      %\nRBVTG = statevalues(22);      %\nGVTG = statevalues(23);      %\nVTGreceptor = statevalues(24);      %\nOVTG = statevalues(25);      %\nLVTG = statevalues(26);      %\n%%\n \n%%\n%Algebraic repeated Assignments\n \n%Fadrozole in gill water (umol/L)\n% (L/hr x umol/L + L/hr X umol/L) / (L/hr + L/hr) --> umol/L  \nV_Gill.FAD = (param.Qwater_gill*param.F_conc + param.Qcardiac ...\n    * V_Venous.FAD) / (param.Qcardiac+(param.Qwater_gill ...\n    /param.P_fad_water_blood));\n \n%LHFSH-receptor complex in venous blood (umol/L)\nV_Venous.LHFSH_R_LHFSH = LHFSH_R_LHFSH;\n \n%Free LHFSH receptor in venous blood (umol)\nparam.A_R_LHFSH_free = param.A_R_LHFSH_total ...\n    -(V_Venous.LHFSH_R_LHFSH*param.V_Venous);\n \n%Free (unbound) LHFSH in venous blood (umol)\nA_LHFSH_venous_free = (V_Venous.LHFSH-V_Venous.LHFSH_R_LHFSH) ...\n                      * param.V_Venous;\n \n%CYP19A in ovary\nparam.Vmax_CYP19A  =  param.kcat_CYP19A*(CYP19A*param.V_Ovary);\n                        %umol/hr\n \n%E2 in venous blood\nV_Venous.E21 = E21; %umol/L\n \n%E2 in gill blood\nV_Gill.E2  =  V_Venous.E21;  %umol/L\n \n%LHFSH in gill blood\nV_Gill.LHFSH  =  V_Venous.LHFSH;\n \n%Vmax for VTG transport into the ovary\nparam.VmaxVTGtransport = VTGreceptor*param.kcatVTGtransport ...\n                         * param.V_Ovary;   %umol/hr\n \n%%\n \n%%\n%Fluxes ;\nReactionFlux1  =  param.Qbrain*V_Gill.E2; %E2 into brain \nReactionFlux2  =  param.Qbrain*(V_Brain.E2/param.P_e2_brain_blood); %E2 out of brain\nReactionFlux3  =  param.Qbrain*V_Gill.FAD;\nReactionFlux4  =  param.Qbrain*(V_Brain.FAD/param.P_fad_brain_blood);\n                    %L/hr X umol/L --> umol/hr\nReactionFlux5  =  param.k_syn_LHFSH ;\nReactionFlux6  =  param.k_loss_LHFSH_brain*V_Brain.LHFSH*param.V_Brain  ;\nReactionFlux7  =  (param.k_LHFSH*V_Brain.LHFSH*param.V_Brain)/(1+(V_Brain.E2/param.ki_E2))  ;\nReactionFlux8  =  param.Qovary*V_Gill.FAD   ;\nReactionFlux9  =  param.Qovary*(V_Ovary.FAD/param.P_fad_ovary_blood)    ;\nReactionFlux10  =  param.Qovary*V_Gill.E2   ;\nReactionFlux11  =  param.Qovary*(V_Ovary.E2/param.P_e2_ovary_blood) ;\nReactionFlux12  =  param.Qrob*V_Gill.FAD    ;\nReactionFlux13  =  param.Qrob*(V_ROB.FAD/param.P_fad_rob_blood) ;"
				+"\nReactionFlux14  =  param.Qrob*V_Gill.E2 ;\nReactionFlux15  =  param.Qrob*(V_ROB.E2/param.P_e2_rob_blood)   ;\nReactionFlux16  =  param.Qliver*V_Gill.FAD  ;\nReactionFlux17  =  param.Qliver*(V_Liver.FAD/param.P_fad_liver_blood)   ;\nReactionFlux18  =  param.Qliver*V_Gill.E2   ;\nReactionFlux19  =  param.Qliver*(V_Liver.E2/param.P_e2_liver_blood) ;\nReactionFlux20  =  param.Vmax_CYP19A*T/((param.Km_T*(1+(V_Ovary.FAD/param.Ki_fad)))+T)  ;\nReactionFlux21  =  (param.Vmax_syn_CYP19A*CYP19AmRNA)/(param.km_syn_CYP19A+CYP19AmRNA)  ;\nReactionFlux22  =  param.ksyn_mRNA_basel    ;\nReactionFlux23  =  ((param.ksyn_mRNA_max-param.ksyn_mRNA_basel) ...\n                   * LHFSH_R_LHFSH)/(param.ka_syn_mRNA+LHFSH_R_LHFSH);\nReactionFlux24  =  param.k_loss_LHFSH*A_LHFSH_venous_free   ;\nReactionFlux25  =  param.k_LHFSH_on*A_LHFSH_venous_free*param.A_R_LHFSH_free    ;\nReactionFlux26  =  param.k_LHFSH_off*(LHFSH_R_LHFSH*param.V_Venous) ;\nReactionFlux27  =  param.Qcardiac*E21   ;\nReactionFlux28  =  param.Qcardiac*V_Venous.FAD  ;\nReactionFlux29  =  param.k_loss_mRNA*CYP19AmRNA*param.V_Ovary   ;\nReactionFlux30  =  param.k_loss_CYP19A*CYP19A*param.V_Ovary ;\nReactionFlux31  =  param.k_loss_FAD*V_Liver.FAD*param.V_Liver   ;\nReactionFlux32  =  param.k_loss_E2*V_Liver.E2*param.V_Liver ;\nReactionFlux33  =  param.Qcardiac*A_LHFSH_venous_free/param.V_Venous    ;\nReactionFlux34  =  param.k_loss_FAD_water*V_Water.FAD*param.V_Water; %FAD loss in water\nReactionFlux35  =  param.ksyn_T-param.k_loss_T*T*param.V_Ovary  ;\nReactionFlux36  =  param.QVTGcardiac*VVTG   ;\nReactionFlux37  =  (param.k_storageVTGovary*OVTG)*param.V_OvaryTissue   ;\nReactionFlux38  =  param.QVTGliver*LBVTG    ;\nReactionFlux39  =  param.ksyn_vtg*V_Liver.E2*param.V_Liver  ;\nReactionFlux40  =  param.Qrob*RBVTG ;\nReactionFlux41  =  param.Qbrain*BBVTG   ;\nReactionFlux42  =  param.Qovary*OBVTG   ;\nReactionFlux43  =  param.Qovary*GVTG    ;\nReactionFlux44  =  param.Qbrain*GVTG    ;\nReactionFlux45  =  param.Qrob*GVTG  ;\nReactionFlux46  =  param.Qliver*GVTG    ;\nReactionFlux47  =  LVTG*param.QVTGliver ;\nReactionFlux48  =  param.ksynVTGreceptor*param.KaVTGreceptor^param.n1/(param.KaVTGreceptor^param.n1+OVTG^param.n1)  ;\nReactionFlux49  =  (param.kdegVTGreceptor*VTGreceptor)*param.V_OvaryTissue  ;\nReactionFlux50  =  param.VmaxVTGtransport*OBVTG/(param.KmVTGtransport+OBVTG)    ;\n%%\n \n%%\n%Differential equations\n%1 FAD in ovary\ndV_Ovary.FADdt =  1/param.V_Ovary*(ReactionFlux8 - ReactionFlux9);\nintegrate(1) = dV_Ovary.FADdt; \n \n%2 E2 in ovary\ndV_Ovary.E2dt =  1/param.V_Ovary*(ReactionFlux10 - ReactionFlux11 + ReactionFlux20) ;\nintegrate(2) = dV_Ovary.E2dt; \n \n%3 CYP19A in ovary\ndCYP19Adt =  1/param.V_Ovary*(ReactionFlux21 - ReactionFlux30)  ;\nintegrate(3) = dCYP19Adt; \n \n%4 CYP19A mRNA in ovary\ndCYP19AmRNAdt =  1/param.V_Ovary*(ReactionFlux22 + ReactionFlux23 - ReactionFlux29) ;\nintegrate(4) = dCYP19AmRNAdt; \n \n%5 testosterone in ovary\ndTdt =  1/param.V_Ovary*(-ReactionFlux20 + ReactionFlux35)  ;\nintegrate(5) = dTdt; \n \n%6 FAD in liver\n"
				+"dV_Liver.FADdt =  1/param.V_Liver*(ReactionFlux16 - ReactionFlux17 - ReactionFlux31)    ;\nintegrate(6) = dV_Liver.FADdt; \n \n%7 E2 in liver\ndV_Liver.E2dt =  1/param.V_Liver*(ReactionFlux18 - ReactionFlux19 - ReactionFlux32) ;\nintegrate(7) = dV_Liver.E2dt; \n \n%8 FAD in rest of body\ndV_ROB.FADdt =  1/param.V_ROB*(ReactionFlux12 - ReactionFlux13) ;\nintegrate(8) = dV_ROB.FADdt; \n \n%9 E2 in rest of body\ndV_ROB.E2dt =  1/param.V_ROB*(ReactionFlux14 - ReactionFlux15)  ;\nintegrate(9) = dV_ROB.E2dt; \n \n%10 FAD in venous blood\n% 1/L X umol\ndV_Venous.FADdt = 1/param.V_Venous*(ReactionFlux4 + ReactionFlux9 + ReactionFlux13 + ReactionFlux17 - ReactionFlux28)   ;\nintegrate(10) = dV_Venous.FADdt;\n \n%11 E2 in venous blood\ndE21dt = 1/param.V_Venous*(ReactionFlux2 + ReactionFlux11 + ReactionFlux15 + ReactionFlux19 - ReactionFlux27)   ;\nintegrate(11) = dE21dt; \n \n%12 Free form of LHFSH receptor \ndLHFSH_R_LHFSHdt =  1/param.V_Venous*(ReactionFlux25 - ReactionFlux26)  ;\nintegrate(12) = dLHFSH_R_LHFSHdt;\n \n%13 LHFSH in venous blood\ndV_Venous.LHFSHdt =  1/param.V_Venous*(ReactionFlux7 - ReactionFlux24 - ReactionFlux33) ;\nintegrate(13) = dV_Venous.LHFSHdt;\n \n%14 VTG in venous blood\ndVVTGdt =  1/param.V_Venous*(-ReactionFlux36 + ReactionFlux38 + ReactionFlux40 + ReactionFlux41 + ReactionFlux42)   ;\nintegrate(14) = dVVTGdt; \n \n%15 FAD in venous blood from brain\ndV_Brain.FADdt =  1/param.V_Brain*(ReactionFlux3 - ReactionFlux4)   ;\nintegrate(15) = dV_Brain.FADdt; \n \n%16 E2 in venous blood from brain\ndV_Brain.E2dt =  1/param.V_Brain*(ReactionFlux1 - ReactionFlux2)    ;\nintegrate(16) = dV_Brain.E2dt; \n \n%17 LHFSH in venous blood from brain\ndV_Brain.LHFSHdt =  1/param.V_Brain*(ReactionFlux5 - ReactionFlux6 - ReactionFlux7) ;\nintegrate(17) = dV_Brain.LHFSHdt;\n \n%18 FAD in water (This equation not used in MATLAB version of the model\n%dV_Water.FADdt =  1/param.V_Water*(-ReactionFlux34);\ndV_Water.FADdt =  0;\nintegrate(18) = dV_Water.FADdt; \n \n%19 VTG in ovary blood\ndOBVTGdt =  1/param.V_OvaryBlood*(-ReactionFlux42 + ReactionFlux43 - ReactionFlux50)    ;\nintegrate(19) = dOBVTGdt; \n \n%20 VTG in liver blood\ndLBVTGdt =  1/param.V_LiverBlood*(-ReactionFlux38 + ReactionFlux46 + ReactionFlux47)    ;\nintegrate(20) = dLBVTGdt; \n \n%21 VTG in brain blood\ndBBVTGdt =  1/param.V_BrainBlood*(-ReactionFlux41 + ReactionFlux44) ;\nintegrate(21) = dBBVTGdt; \n \n%22 VTG in rest of body blood\ndRBVTGdt =  1/param.V_RobBlood*(-ReactionFlux40 + ReactionFlux45)   ;\nintegrate(22) = dRBVTGdt; \n \n%23 VTG in gill blood\ndGVTGdt =  1/param.V_GillBlood*(ReactionFlux36 - ReactionFlux43 - ReactionFlux44 - ReactionFlux45 - ReactionFlux46) ;\nintegrate(23) = dGVTGdt;\n \n%24 VTG receptor in ovary\ndVTGreceptordt =  1/param.V_OvaryTissue*(ReactionFlux48 - ReactionFlux49)   ;\nintegrate(24) = dVTGreceptordt;\n \n%25 VTG in ovary\ndOVTGdt =  1/param.V_OvaryTissue*(-ReactionFlux37 + ReactionFlux50);\nintegrate(25) = dOVTGdt;\n \n%26 VTG in  liver\ndLVTGdt = 1/param.V_LiverTissue*(ReactionFlux39 - ReactionFlux47);\nintegrate(26) = dLVTGdt;\n%%\n"		);
				gm1resources.add(ode);

				Resource data = new Resource(gm1resources, dataSource);
				data.setName("FAD_data");
				data.setResourceType(ResourceType.MATLAB_SOURCE_CODE);
				data.setContent("%Fadrozole data file\n%Rory Conolly\n%February 19, 2017\n \n%Plasma E2 and plasma VTG data are uM (micromolar) while ovaaarian CRP19A\n% mRNA data are fold change relative to control\n \n    %Time  Plasma E2    CYP19A Plasma VTG\nFAD_data_control = [ ...\n    24     1.4267e-02   1      1.85E+02\n    48     2.1255e-02   1      1.38E+02\n    96     2.2154E-02   1      1.37E+02\n    192    2.3138E-02   1      1.26E+02\n    216    2.2169E-02   1      1.41E+02\n    240    1.8140E-02   1      1.44E+02\n    288    1.7805E-02   1      1.39E+02\n    384    1.4923E-02   1      1.27E+02\n    480    8.1504E-03   1      1.73E+02\n    576    1.6266E-02   1      1.56E+02\n    672    1.2437E-02   1      1.47E+02 ];\n \n    %Time  Plasma E2    CYP19A Plasma VTG\nFAD_data_0_5 = [ ...\n    24  1.2630E-02  1.29E+00    1.43E+02\n    192 1.1120E-02  1.53E+00    9.87E+01\n    288 1.2568E-02  1.76E+00    1.02E+02\n    384 8.1180E-03  1.18E+00    1.22E+02\n    480 9.6335E-03  1.60E+00    1.12E+02\n    576 1.9110E-02  1.26E+00    8.37E+01\n    672 9.2977E-03  9.61E-01    1.04E+02 ];\n \n    %Time  Plasma E2    CYP19A Plasma VTG\n FAD_data_3 = [ ...\n    24  8.4556E-03  1.95E+00    8.52E+01\n    48  4.5754E-03  7.63E-01    1.15E+02\n    96  1.3640E-02  5.06E+00    2.35E+01\n    192 3.3306E-02  4.17E+00    3.31E+01\n    216 5.1670E-02  2.63E+00    4.62E+01\n    240 1.7988E-02  9.21E-01    4.03E+01\n    288 3.0303E-02  1.88E+00    7.40E+01\n    384 2.2827E-02  9.49E-01    7.61E+01 ];\n \n    %Time  Plasma E2    CYP19A Plasma VTG\nFAD_data_30 = [ ...\n    24  4.4127E-03  2.61E+00    6.91E+01\n    48  2.6077E-03  5.96E+00    1.16E+01\n    96  3.4963E-03  1.40E+01    1.18E+00\n    192 3.5049E-03  4.71E+00    2.17E+00\n    216 1.0238E-02  2.36E+00    5.14E-01\n    240 2.4103E-02  1.40E+00    4.11E+00\n    288 2.8853E-02  2.42E+00    5.81E+01\n    384 2.0487E-02  2.01E+00    5.10E+01\n    480 1.1599E-02  1.68E+00    1.15E+02\n    576 1.1125E-02  6.01E-01    1.16E+02\n    672 1.4120E-02  1.72E+00    9.52E+01 ];\n");
				gm1resources.add(data);
				
				gm1.setResources(gm1resources);
				
				SubstanceData_InSilico subst_data1s = new SubstanceData_InSilico(test_insilico25, initiator_chemicalstructure1, dataSource);
				ObjectProperties inputProp = subst_data1s.getLocalModelInputProperties();
				ObjectPropertyMultivalued_Documented chemConc = (ObjectPropertyMultivalued_Documented) inputProp.getProperty("Tested_Subst_Measured_Log_Conc");
				/*
				 * Value Min Max Unit, DEFAULT_TIME, Unit DEFAULT_LOG_MOL_NOM_CONCENTRATION,
				 * Unit DEFAULT_STDEV_ERROR, Unit DEFAULT_SEM_ERROR, Unit
				 * DEFAULT_CI95_ERROR, Unit DEFAULT_MEDIAN_VALUE, Unit DEFAULT_REPET_COUNT,
				 * Unit
				 */
				String[][] cValues = new String[][]
					{
					{ "-10", "-10.1", "-9.9", "logM", "0", "s", "-10", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-9", "-9.1", "-8.9", "logM", "0", "s", "-9", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-8", "-8.1", "-7.9", "logM", "0", "s", "-8", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-7", "-7.1", "-6.9", "logM", "0", "s", "-7", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-6", "-6.1", "-5.9", "logM", "0", "s", "-6", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-5", "-5.1", "-4.9", "logM", "0", "s", "-5", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-4", "-4.1", "-3.9", "logM", "0", "s", "-4", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-3", "-3.1", "-2.9", "logM", "0", "s", "-3", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-2", "-2.1", "-1.9", "logM", "0", "s", "-2", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" },
					{ "-1", "-1.1", "-0.9", "logM", "0", "s", "-1", "logM", "", "", "0.1", "logM", "", "", "", "", "3", "", "", "" } };
				chemConc.assign(cValues);

				SubstanceData_InSilico subst_data2s = new SubstanceData_InSilico(test_insilico35, initiator_chemicalstructure1, dataSource);
				ObjectProperties inputProp2 = subst_data2s.getLocalModelInputProperties();
				ObjectPropertyMultivalued_Documented chemConc2 = (ObjectPropertyMultivalued_Documented) inputProp2.getProperty("Tested_Subst_Measured_Log_Conc");
				chemConc2.assign(cValues);

				SubstanceData_InSilico subst_data3s = new SubstanceData_InSilico(test_insilico39, initiator_chemicalstructure1, dataSource);
				ObjectProperties inputProp3 = subst_data3s.getLocalModelInputProperties();
				ObjectPropertyMultivalued_Documented chemConc3 = (ObjectPropertyMultivalued_Documented) inputProp3.getProperty("Tested_Subst_Measured_Log_Conc");
				chemConc3.assign(cValues);

				
				ObjectProperties summary = DefaultEffectopediaObjects.DEFAULT_D_RESP_DATA.clone(initiator_chemicalstructure1, dataSource);
				DataTemplates templates = DefaultDataTemplates.DTS_DR_SINGLE_CHEM_MEAN_MIN_MAX.clone();
				templates.setChartTitle(test_insilico25.getTitle());
				subst_data1s.setTemplates(templates);
				subst_data1s.setObjectProperties(summary);
				ObjectPropertyMultivalued_Documented testedSubst = (ObjectPropertyMultivalued_Documented) summary.getProperty("Tested_Subst_Log_Conc_Response");
				// mean min max unit chem conc. unit notes references
				String[][] drValues = new String[][]
					{
					{ "0.009999000099990002", "", "", "%", "", "", "-10", "logM", "", "", "0", "%", "", "", "", "", "1", "", "", "" },
					{ "0.06305594883398934", "", "", "%", "", "", "-9", "logM", "", "", "0", "%", "", "", "", "", "1", "", "", "" },
					{ "0.39652856191521973", "", "", "%", "", "", "-8", "logM", "", "", "0", "%", "", "", "", "", "1", "", "", "" },
					{ "2.4503367550335984", "", "", "%", "", "", "-7", "logM", "", "", "0", "%", "", "", "", "", "1", "", "", "" },
					{ "13.680688860320998", "", "", "%", "", "", "-6", "logM", "", "", "0", "%", "", "", "", "", "1", "", "", "" },
					{ "50.0", "", "", "%", "", "", "-5", "logM", "", "", "0", "%", "", "", "", "", "1", "", "", "" },
					{ "86.31931113967902", "", "", "%", "", "", "-4", "logM", "", "", "0", "%", "", "", "", "", "1", "", "", "" },
					{ "97.54966324496641", "", "", "%", "", "", "-3", "logM", "", "", "0", "%", "", "", "", "", "1", "", "", "" },
					{ "99.60347143808477", "", "", "%", "", "", "-2", "logM", "", "", "0", "%", "", "", "", "", "1", "", "", "" },
					{ "99.93694405116601	", "", "", "%", "", "", "-1", "logM", "", "", "0", "%", "", "", "", "", "1", "", "", "" } };
				testedSubst.assign(drValues);
				test_insilico25.getSubstanceDataIDs().add(subst_data1s);
			}
	}

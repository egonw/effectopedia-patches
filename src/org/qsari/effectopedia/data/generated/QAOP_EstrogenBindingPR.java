package org.qsari.effectopedia.data.generated;

import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.core.objects.DescriptionSection.ContentFormat;
import org.qsari.effectopedia.core.objects.Effect_AdverseOutcome;
import org.qsari.effectopedia.core.objects.Effect_DownstreamEffect;
import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.Link_ChemStructToMIE;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.core.objects.Method_Investigation;
import org.qsari.effectopedia.core.objects.Method_Study;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.Reference;
import org.qsari.effectopedia.core.objects.SubstanceData;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.core.objects.Test_InVitro;
import org.qsari.effectopedia.core.objects.Test_InVivo;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.defaults.DefaultDataTemplates;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.system.User;

public class QAOP_EstrogenBindingPR extends SourceGeneratedPathway
	{
		
		public QAOP_EstrogenBindingPR(DataSource dataSource)
			{
				super("Example1 Estrogen Binding Mediated Population Reduction", "estrogen receptor binding, sex reversal,reproductive impairment", dataSource,
						".//test//Estrogen Binding Mediated Population Reduction");
			}
		
		// revision 1
		protected Initiator_ChemicalStructure					chemical1;
		protected Effect_MolecularInitiatingEvent	mie1;
		protected Effect_DownstreamEffect									cellular_effect1;
		protected Effect_DownstreamEffect									tissue_effect1;
		protected Effect_DownstreamEffect									tissue_effect2;
		protected Effect_DownstreamEffect									organ_effect1;
		protected Effect_DownstreamEffect									organ_effect2;
		protected Effect_DownstreamEffect									individual_effect1;
		protected Effect_DownstreamEffect									individual_effect2;
		protected Effect_DownstreamEffect									population_effect1;
		protected Effect_DownstreamEffect									population_effect2;
		protected Effect_AdverseOutcome											population_adverseOutcome;
		
		protected Link_ChemStructToMIE												link_ch1_mie1;
		protected Link_EffectToEffect													link_ce1_oe1;
		protected Link_EffectToEffect													link_ce1_oe2;
		protected Link_EffectToEffect													link_oe1_ie1;
		protected Link_EffectToEffect													link_oe1_ie2;
		protected Link_EffectToEffect													link_oe2_pe2;
		protected TestResponseMapping													mapping_oet1_oe1;
		
		// revision 2
		protected Effect_DownstreamEffect									organ_effect3;
		protected Effect_DownstreamEffect									individual_effect3;
		// revision 3
		protected Test_InVitro																				mie1test1;
		protected Test_InVitro																				tissue_effect1test1;
		protected Test_InVivo																					tissue_effect1test2;
		protected Test_InVivo																					tissue_effect1test3;
		protected Test_InVivo																					tissue_effect2test1;
		protected Test_InVivo																					tissue_effect2test2;
		protected Test_InVivo																					organ_effect1test1;
		protected Test_InVivo																					organ_effect2test1;
		protected Test_InVivo																					organ_effect2test2;
		protected Test_InVivo																					individual_effect1test1;
		protected Test_InVivo																					individual_effect2test1;
		
		protected TestResponseMapping													mapping_t3te1;
		protected TestResponseMapping													mapping_t2te2;
		protected TestResponseMapping													mapping_t1o2;
		protected TestResponseMapping													mapping_t2oe2;
		
		// revision 5
		protected Effect_DownstreamEffect									individual_effect4;
		// revision 6
		protected Method_Study																				study1;
		protected Method_Investigation												investigation1;
		
		// revision 9
		protected Test_InVitro																				mie1test2;
		
		// revision 10
		protected Initiator_ChemicalStructure					chemical2;
		protected Link_ChemStructToMIE												link_ch2_mie1;
		protected SubstanceData																			subst_data1s;
		protected SubstanceData																			subst_data2s;
		protected SubstanceData																			subst_data3s;
		protected SubstanceData																			subst_data4s;
		protected SubstanceData																			subst_data5s;
		
		// revision 12
		
		protected Effect_DownstreamEffect									tissue_effect1a;
		protected Effect_DownstreamEffect									tissue_effect2a;
		protected Effect_DownstreamEffect									organ_effect1a;
		protected Effect_DownstreamEffect									organ_effect2a;
		protected Effect_DownstreamEffect									individual_effect1a;
		protected Effect_DownstreamEffect									individual_effect2a;
		
		// revision 13
		protected Effect_DownstreamEffect									organ_effect3a;
		protected Effect_DownstreamEffect									individual_effect3a;
		protected Test_InVivo																					organ_effect3test1;
		protected Test_InVivo																					individual_effect3test1;
		protected TestResponseMapping													mapping_oe3tot1;
		protected TestResponseMapping													mapping_i3tit1;
		
		@Override
		public void generateContent()
			{
				storeRevision();
				genreateRevision1();
				updateVariables();
				genreateRevision2();
				storeRevision();
				genreateRevision3();
				storeRevision();
				genreateRevision4();
				storeRevision();
				genreateRevision5();
				storeRevision();
				genreateRevision6();
				storeRevision();
				genreateRevision7();
				storeRevision();
				genreateRevision8();
				storeRevision();
				genreateRevision9();
				storeRevision();
				genreateRevision10();
				storeRevision();
				genreateRevision11();
				storeRevision();
				genreateRevision12();
				storeRevision();
				genreateRevision13();
				storeRevision();
				genreateRevision14();
				storeRevision();
			}
		
		public void genreateRevision1()
			{
				
				chemical1 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical1.setTitle("Amylaniline");
				chemical1.getStructure2DImage().setValue("https://app.effectopedia.org/media/chem/amylaniline.png");
				chemical1.getIdentification().setPropertyValue(0, "33228443");
				chemical1.getIdentification().setPropertyValue(1, "4-n-Amylaniline");
				chemical1.getIdentification().setPropertyValue(2, "NC1=CC=C(C=C1)CCCCC");
				chemical1.getIdentification().setPropertyValue(3, "C11H17N");
				chemical1.getProperties().setPropertyValue(0, "163.2594");
				
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
				
				link_ch1_mie1 = new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie1);
				
				cellular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect1.setTitle("ER Transcription Factors");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_EffectToEffect(pathway, dataSource, mie1, cellular_effect1);
				
				tissue_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				tissue_effect1.setTitle("Vtg mRNA induction");
				tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				
				tissue_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				tissue_effect2.setTitle("Altered Anal fin papillae");
				tissue_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				tissue_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, tissue_effect1);
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, tissue_effect2);
				
				organ_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect1.setTitle("Sex reversed genetic male");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				
				organ_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect2.setTitle("Intersex genetic male");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				
				link_ce1_oe1 = new Link_EffectToEffect(pathway, dataSource, cellular_effect1, organ_effect1);
				link_ce1_oe2 = new Link_EffectToEffect(pathway, dataSource, cellular_effect1, organ_effect2);
				
				individual_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect1.setTitle("Altered Fertility");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				
				individual_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect2.setTitle("Altered Fecundity");
				individual_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				
				link_oe1_ie1 = new Link_EffectToEffect(pathway, dataSource, organ_effect1, individual_effect1);
				link_oe1_ie2 = new Link_EffectToEffect(pathway, dataSource, organ_effect1, individual_effect2);
				
				population_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				population_effect1.setTitle("Impaired Reproduction");
				population_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "population");
				population_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				population_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				population_effect2.setTitle("Altered sex ratios");
				population_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "population");
				population_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				population_adverseOutcome = (Effect_AdverseOutcome) searchEffectByTitle(dataSource,"Population reduction");
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
				
				new Link_EffectToEffect(pathway, dataSource, individual_effect1, population_effect1);
				new Link_EffectToEffect(pathway, dataSource, individual_effect2, population_effect1);
				link_oe2_pe2 = new Link_EffectToEffect(pathway, dataSource, organ_effect2, population_effect2);
				new Link_EffectToEffect(pathway, dataSource, population_effect2, population_adverseOutcome);
				Link link = (Link) Pathway.getDirektLink(population_effect1, population_adverseOutcome);
				if (link != null)
					pathway.add(link);
				else
					new Link_EffectToEffect(pathway, dataSource, population_effect1, population_adverseOutcome);
			}
		
		public void genreateRevision2()
			{
				organ_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect3.setTitle("Decreased egg production in ovary");
				organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, organ_effect3);
				
				individual_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect3.setTitle("Reduced eggs per female");
				individual_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				new Link_EffectToEffect(pathway, dataSource, organ_effect3, individual_effect3);
				new Link_EffectToEffect(pathway, dataSource, individual_effect3, population_effect1);
			}
		
		public void genreateRevision3()
			{
				mie1test1 = new Test_InVitro(pathway, dataSource);
				mie1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new TestResponseMapping(pathway, dataSource, mie1test1, mie1);
				
				tissue_effect1test1 = new Test_InVitro(pathway, dataSource);
				tissue_effect1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				tissue_effect1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				
				tissue_effect1test2 = new Test_InVivo(pathway, dataSource);
				tissue_effect1test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				tissue_effect1test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				
				tissue_effect1test3 = new Test_InVivo(pathway, dataSource);
				tissue_effect1test3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				tissue_effect1test3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				
				tissue_effect2test1 = new Test_InVivo(pathway, dataSource);
				tissue_effect2test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				tissue_effect2test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				
				tissue_effect2test2 = new Test_InVivo(pathway, dataSource);
				tissue_effect2test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				tissue_effect2test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				
				new TestResponseMapping(pathway, dataSource, tissue_effect1test1, tissue_effect1);
				new TestResponseMapping(pathway, dataSource, tissue_effect1test2, tissue_effect1);
				mapping_t3te1 = new TestResponseMapping(pathway, dataSource, tissue_effect1test3, tissue_effect1);
				new TestResponseMapping(pathway, dataSource, tissue_effect2test1, tissue_effect2);
				mapping_t2te2 = new TestResponseMapping(pathway, dataSource, tissue_effect2test2, tissue_effect2);
				
				organ_effect1test1 = new Test_InVivo(pathway, dataSource);
				organ_effect1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				
				organ_effect2test1 = new Test_InVivo(pathway, dataSource);
				organ_effect2test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect2test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				
				organ_effect2test2 = new Test_InVivo(pathway, dataSource);
				organ_effect2test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect2test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				
				mapping_oet1_oe1 = new TestResponseMapping(pathway, dataSource, organ_effect1test1, organ_effect1);
				mapping_t1o2 = new TestResponseMapping(pathway, dataSource, organ_effect2test1, organ_effect2);
				mapping_t2oe2 = new TestResponseMapping(pathway, dataSource, organ_effect2test2, organ_effect2);
				
				individual_effect1test1 = new Test_InVivo(pathway, dataSource);
				individual_effect1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				
				individual_effect2test1 = new Test_InVivo(pathway, dataSource);
				individual_effect2test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect2test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				
				new TestResponseMapping(pathway, dataSource, individual_effect1test1, individual_effect1);
				new TestResponseMapping(pathway, dataSource, individual_effect2test1, individual_effect2);
			}
		
		public void genreateRevision4()
			{
				mie1test1.setTitle("Trout  Cyto rtER Assay");
				tissue_effect1test1.setTitle("Trout liver slices");
				tissue_effect1test2.setTitle("F0 (Parent Generation) adult male Medaka liver vitellogenin (VTG mRNA) induction");
				tissue_effect1test3.setTitle("Medaka F1");
				tissue_effect1test1.relateWith(tissue_effect1test2).relateWith(tissue_effect1test3);
				tissue_effect1test2.relateWith(tissue_effect1test3);
				tissue_effect2test1.setTitle("Medaka F0");
				tissue_effect2test2.setTitle("Medaka F1");
				tissue_effect2test1.relateWith(tissue_effect2test2);
				organ_effect1test1.setTitle("Medaka F1");
				organ_effect2test1.setTitle("Medaka F0");
				organ_effect2test2.setTitle("Medaka F1");
				organ_effect2test1.relateWith(organ_effect2test2);
				individual_effect1test1.setTitle("Medaka F0");
				individual_effect2test1.setTitle("Medaka F0");
			}
		
		public void genreateRevision5()
			{
				individual_effect4 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect4.setTitle("Viablilty of YY Eggs");
				individual_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_EffectToEffect(pathway, dataSource, organ_effect2, individual_effect4);
				new Link_EffectToEffect(pathway, dataSource, individual_effect4, population_adverseOutcome);
			}
		
		public void genreateRevision6()
			{
				study1 = new Method_Study(pathway, dataSource);
				study1.setTitle("F0 (Paren Generation) adult Study");
				DescriptionSection st = new DescriptionSection(
						study1,
						dataSource,
						"Parent Generation Study Summary",
						"<html>\n<ul>\n<li>Generation: <i>F0</i></li>\n<li>Exposure duration: <i>5 weeks starting with reproducing adults</i></li>\n<li># fish per replicate tank: <i>2 (1 male; 1 female)</i></li>\n</ul>\n</html>\n")
						.<DescriptionSection> makeItLive();
				st.setFormat(ContentFormat.HTML);
				study1.getDescriptionIDs().set(st, 0);
				
				investigation1 = new Method_Investigation(pathway, dataSource);
				investigation1.setTitle("Multigenerational Medaka Investigation");
				
				DescriptionSection inv = new DescriptionSection(
						investigation1,
						dataSource,
						"Investigation Summary",
						"<html>\n<table>\n  <tr>\n    <td valign='top'>\n<ul>\n  <li>Timeline</li>\n  <li>Species/strain:<i>Medaka</i></li>\n  <li>Toxicant chemistry: <br> <i>measured vs nominal<br>measured concentrations</i></li>\n  <li>Treatment & replication</li>\n</ul>\n    </td>\n    <td valign='top'> <img src='https://app.effectopedia.org/media/rev/MultiGenInvestigationTimeline.png' alt='Investigation timeline' style='width:304px;height:228px'>\n</td>\n  </tr>\n</table>\n</html>\n")
						.<DescriptionSection> makeItLive();
				inv.setFormat(ContentFormat.HTML);
				investigation1.getDescriptionIDs().set(inv, 0);
				investigation1.getRelatedStudies().add(study1);
				
				tissue_effect1test2.getStudyIDs().add(study1);
				tissue_effect1test2.getInvestigationIDs().add(investigation1);
			}
		
		public void genreateRevision7()
			{
				link_oe1_ie1.link_Up(organ_effect2);
				organ_effect2.link_Down(link_oe1_ie1);
				link_oe1_ie2.link_Up(organ_effect2);
				organ_effect2.link_Down(link_oe1_ie2);
				organ_effect2.setTitle("Altered phenotype of testes in genetic males");
				pathway.disassociate(organ_effect1);
				pathway.disassociate(organ_effect1test1);
				pathway.disassociate(mapping_oet1_oe1);
				pathway.disassociate(link_ce1_oe1);
				pathway.sortElements();
			}
		
		public void genreateRevision8()
			{
				// Effectopedia.EFFECTOPEDIA.setCurrentUser(KFLYNN);
				tissue_effect1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										tissue_effect1,
										dataSource,
										"Description",
										"Vitellogenin is the precursor of both lipoproteins and phosphoproteins that are the primary proteins of the yolk of oviparous species.  Vitellogenin (Vtg) is synthesized in the liver and, via active uptake, is deposited in the growing oocyte.  Vitellogenin is not normally expressed on appreciable levels in males thus providing a convenient biomarker of EDC exposure.  Often Vtg gene expression is measured by determining the Vtg mRNA copy number per nanogram (ng) of total mRNA in the liver by quantitative PCR (QPCR).  QPCR is highly sensitive and has a large dynamic range (~7 orders of magnitude), making it an ideal tool for efficiently assessing levels of a target gene.")
										.<DescriptionSection> makeItLive(), 0);
				
				organ_effect2
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										organ_effect2,
										dataSource,
										"Description",
										"The inappropriate activation of the estrogen receptor can cause the feminization of the testis.  The severity of the perturbation is usually described based upon the number of oocytes in a particular testis and the developmental stage of those oocytes (Johnson et al. 2009).  The spectrum of effects range from a single immature oocyte to numerous mature oocytes.  At the extreme,  complete sex reversal in which the male gonad becomes phenotypically indistinguishable from a normal ovary can be observed.")
										.<DescriptionSection> makeItLive(), 0);
				organ_effect2
						.getReferenceIDs()
						.add(
								new Reference(
										organ_effect2,
										dataSource,
										"Johnson, R., Wolf, J., & Braunbeck, T. (2009). OECD guidance document for the diagnosis of endocrine-related histopathology of fish gonads. Organisation for Economic Co-operation and Development, France.")
										.<Reference> makeItLive());
				
				individual_effect4
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										individual_effect4,
										dataSource,
										"Abstract",
										"In some fish species, YY embryos are viable and develop normally.  Depending on the genetics of the strain used, YY medaka are viable (Yamamoto, 1955; Yamamoto, 1964).  Additionally, YY fish have been obtained in many other species of fish including guppy (Kavumpurath and Pandian, 1993), goldfish (Yamamoto, 1974), tilapia (Carrasco et al., 1999), rainbow trout (Scheerer et al., 1991), and common carp (Bongers et al., 1999).  However in other species, YY fish do not survive and there are concerns of whether YY individuals are as robust as the normal XY male within a species.  Obviously these considerations are important for determining the consequences of the production of YY embryos.  If YY individuals do develop to sexual maturity and spawn, there will be population level consequences.")
										.<DescriptionSection> makeItLive(), 0);
				individual_effect4.getReferenceIDs().add(
						new Reference(individual_effect4, dataSource,
								"Yamamoto, T. O. (1955). Progeny of artificially induced sex-reversals of male genotype (XY) in the medaka (Oryzias latipes) with special reference to YY-male. Genetics, 40(3), 406.")
								.<Reference> makeItLive());
				individual_effect4.getReferenceIDs().add(
						new Reference(individual_effect4, dataSource,
								"Kavumpurath, S., & Pandian, T. J. (1993). Production of a YY female guppy, Poecilia reticulata, by endocrine sex reversal and progeny testing. Aquaculture,118(3), 183-189.")
								.<Reference> makeItLive());
				individual_effect4.getReferenceIDs().add(
						new Reference(individual_effect4, dataSource, "Yamamoto, T. O. (1974). A YY male goldfish from mating estrone-induced XY female and normal male. The Journal of heredity, 66(1), 2-4.")
								.<Reference> makeItLive());
				individual_effect4
						.getReferenceIDs()
						.add(
								new Reference(
										individual_effect4,
										dataSource,
										"Carrasco, L. A., Penman, D. J., & Bromage, N. (1999). Evidence for the presence of sex chromosomes in the Nile tilapia (Oreochromis niloticus) from synaptonemal complex analysis of XX, XY and YY genotypes. Aquaculture,173(1), 207-218.")
										.<Reference> makeItLive());
				individual_effect4.getReferenceIDs().add(
						new Reference(individual_effect4, dataSource,
								"Scheerer, P. D., Thorgaard, G. H., & Allendorf, F. W. (1991). Genetic analysis of androgenetic rainbow trout. Journal of Experimental Zoology, 260(3), 382-390.").<Reference> makeItLive());
				individual_effect4.getReferenceIDs().add(
						new Reference(individual_effect4, dataSource,
								"Bongers, A. B. J., Zandieh-Doulabi, B., Richter, C. J., & Komen, J. (1999). Viable androgenetic YY genotypes of common carp (Cyprinus carpio L.).Journal of Heredity, 90(1), 195-198.")
								.<Reference> makeItLive());
				
				population_effect2
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										population_effect2,
										dataSource,
										"Description",
										"Feminization or masculinization in a XX/XY sex determining system by anthropogenic factors, if strong enough, will drive the X or Y chromosome, respectively, to extinction.  In general, anthropogenically altered sex ratios appear to have negative impacts on population size and the persistence of sex chromosomes (Cotton and Wedekind, 2009).")
										.<DescriptionSection> makeItLive(), 0);
				population_effect2.getReferenceIDs().add(
						new Reference(population_effect2, dataSource, "Cotton, S., & Wedekind, C. (2009). Population consequences of environmental sex reversal. Conservation Biology, 23(1), 196-206.")
								.<Reference> makeItLive());
				
			}
		
		public void genreateRevision9()
			{
				
				DescriptionSection erb_in_fish = new DescriptionSection(
						mie1,
						dataSource,
						"Established link between biological function and ER in fishes",
						"<html>As reported by Nagler et al., 2012, the only ER isoform that has been linked to a biological function in fishes is isoform erα1 and vitellogenin synthesis in the liver. This has been most convincingly established by gene knockdown experiments in the goldfish[Nelson and Habibi, 2010].Other studies show correlative associations of erα1 with vitellogenesis for medaka [Chakraborty et al., 2011], fathead minnow [Filby and Tyler, 2005), European silver eel [Palstra et al., 2010] and largemouth bass [Sabo-Attwood et al., 2004],and rainbow trout[Nagler et al., 2012].</html>")
						.<DescriptionSection> makeItLive();
				erb_in_fish.setFormat(ContentFormat.HTML);
				mie1.getDescriptionIDs().add(erb_in_fish);
				
				DescriptionSection rec_Wiki_rtER = new DescriptionSection(mie1, dataSource, "Estrogen Receptor - Wikipedia Bacground", "http://en.m.wikipedia.org/wiki/Estrogen_receptor")
						.<DescriptionSection> makeItLive();
				rec_Wiki_rtER.setFormat(ContentFormat.HTML);
				mie1.getDescriptionIDs().add(rec_Wiki_rtER);
				
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource,
								"Nelson ER, Habibi HR. Functional significance of nuclear estrogen receptor subtypes in the liver of goldfish. Endocrinology. 2010; 151:1668–1676. [PubMed: 20194729]")
								.<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Chakraborty T, Shibata Y, Zhou L-Y, Katsu Y, Iguchi T, Nagahama Y. Differential expression of three estrogen receptor subtype mRNAs in gonads and liver from embryos to adults of the medaka, Oryzias latipes. Mol Cell Endocrinol. 2011; 333:47–54. [PubMed: 21146584]")
										.<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Filby AL, Tyler CR. Molecular characterization of estrogen receptors 1, 2a, and 2b and their tissue andontogenic expression profiles in fathead minnow (Pimephales promelas). BiolReprod. 2005; 73:648–662. [PubMed: 15930325]")
										.<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Palstra AP, Schnabel D, Nieveen MC, Spaink HP, van den Thillart GEEJM. Temporal expression of hepatic estrogen receptor1, vitellogenin1, and vitellogenin2 in European silver eels. Gen Comp Endocrinol. 2010; 166:1–11. [PubMed: 19766647]")
										.<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Sabo-Attwood T, Kroll KJ, Denslow ND. Differential expression of largemouth bass (Micropterus salmoides) estrogen receptor isotypes alpha, beta, and gamma by estradiol. Mol Cell Endocrinol.2004; 218:107–118. [PubMed: 15130515]")
										.<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Nagler JJ, Cavileer TD, Verducci JS, Schultz IR, Hook SE, Hayton WL. 2012. Estrogen receptor mRNA expression patterns in the liver and ovary of female rainbow trout over a complete reproductive cycle. Gen Comp Endocrinol; 2012 Sep 15;178(3):556-61.")
										.<Reference> makeItLive());
				
				// Effectopedia.EFFECTOPEDIA.setCurrentUser(PSCHMIEDER);
				link_ch1_mie1.setTitle("Mechanisms of Binding to the Estrogen Receptor");
				DescriptionSection erb = new DescriptionSection(
						link_ch1_mie1,
						dataSource,
						"Chemical Structures and ER Binding",
						"<html>Based upon the  understanding of chemical structural characteristics necessary for ER binding (Katzenellenbogen et  al., 2003) it was hypothesized  how non-steroidal chemicals might interact with the ER, albeit with likely  lower affinity than E2 (OECD,  2008; OECD,  2009; USEPA, 2009).  When the endogenous ligand  17&beta;-estradiol (E2) binds to the  ER, the hydroxyl groups on both the steroidal A-ring of E2 (the 3&alpha;-OH), and the  steroidal D-ring of E2 (the 17&beta;-OH) interact with amino acids within the  binding pocket of the ER via hydrogen bonding as illustrated  in Figure 1, with the 3&alpha;-OH participating as a hydrogen bond donor (&lsquo;A&rsquo; binding site)  and the 17&beta;-OH acting as a hydrogen-bond  acceptor (e.g., interacting with histidine 524) (&lsquo;B&rsquo; binding site) (USEPA, 2013; OECD, 2009; USEPA, 2009; Katzenellenbogen et  al., 2003).  These relatively weak hydrogen bonds vary from a somewhat  stronger 1.9 kcal/mol for the &lsquo;A&rsquo;-site  3&alpha;-OH interaction to  a weaker 0.6 kcal/mol for the &lsquo;B&rsquo;-site  17&beta;-OH (Anstead et  al., 1997).  Unlike E2 or other steroidal molecules with high ER affinity  that interact at both the A-site and the B-site, the  chemicals in the USEPA EDSP chemical inventories (USEPA,  2013; USEPA, 2009)  only contain a single  peripheral atom hypothesized to interact with ER. Industrial chemicals with a phenolic  oxygen that can act as a hydrogen bond donor are thus most likely to bind at the 3&alpha;-OH or &lsquo;A&rsquo;-site, and those with a single peripheral atom that can act as an H-bond  acceptor are most likely to bind at the  17&beta;-OH or &lsquo;B&rsquo;-site (USEPA, 2013; OECD, 2009;  USEPA, 2009; Katzenellenbogen et al., 2003; Hamblin et al.,  2003).<br /><br />\n<img src='https://app.effectopedia.org/media/rev/ER_AB_Interaction.png' alt='A B interaction' /><br /><br /> Alignment of the protein sequences of the human and trout ER further show that the three amino acids in the A and B sub-pockets of the ligand binding domain of the human ER that are involved in interaction with the endogenous ligand are conserved across vertebrate classes (Pakdel et al., 1989; Matthews et al., 2000).  Thus, the charge parameters that influence binding of ligands within these sub-pockets of the human ER would also be expected to be important for ligand binding in the trout ER. The local atomic charges on peripheral atoms of chemicals of interest can be calculated and compared to the charge characteristics of E2 to initially categorize chemicals as either potential ‘A’-type or ‘B’-type binders as shown in Figure 2 (Hornung et al., 2014).<br><img src='https://app.effectopedia.org/media/rev/ER_B_Interaction.png' alt='B site only interaction' /></html>")
						.<DescriptionSection> makeItLive();
				erb.setFormat(ContentFormat.HTML);
				link_ch1_mie1.getDescriptionIDs().set(erb, 0);
				
				link_ch1_mie1
						.getReferenceIDs()
						.add(
								new Reference(
										link_ch1_mie1,
										dataSource,
										"Katzenellenbogen, JA., Muthyala,R., Katzenellenbogen,B.S., 2003. Nature of the ligand-binding pocket of estrogen receptor α and ß: The search for subtype-selective ligands and implications for the prediction of estrogenic activity, Pure Appl. Chem. 75: 2397–2403.")
										.<Reference> makeItLive());
				link_ch1_mie1
						.getReferenceIDs()
						.add(
								new Reference(
										link_ch1_mie1,
										dataSource,
										"Organisation for Economic Cooperation and Development (OECD), 2008. Workshop on Integrated Approaches to Testing and Assessment. 11–13 December 2007, Washington DC, Series on Testing and Assessment, No. 88, OECD, Paris.")
										.<Reference> makeItLive());
				link_ch1_mie1.getReferenceIDs().add(
						new Reference(link_ch1_mie1, dataSource,
								"OECD, 2009. Report of the expert consultation to evaluate an estrogen receptor binding affinity model for hazard identification, Series on Testing and Assessment, No. 111, OECD, Paris.")
								.<Reference> makeItLive());
				link_ch1_mie1
						.getReferenceIDs()
						.add(
								new Reference(
										link_ch1_mie1,
										dataSource,
										"US Environmental Protection Agency (EPA), Federal Insecticide, Fungicide, and Rodenticide Act (FIFRA) Science Advisory Panel (SAP), 2009. An effects-based expert system to predict estrogen receptor binding affinity for food use inert ingredients and antimicrobial pesticides: application in a prioritization scheme for endocrine disruptor screening, FIFRA Science Advisory Panel Meeting, Arlington, VA. White paper listed as ‘Meeting Materials’. Available at http://www.regulations.gov/#!docket-Detail;D=EPA-HQ-OPP-2009-0322.")
										.<Reference> makeItLive());
				link_ch1_mie1
						.getReferenceIDs()
						.add(
								new Reference(
										link_ch1_mie1,
										dataSource,
										"US Environmental Protection Agency, Federal Insecticide, Fungicide, and Rodenticide Act (FIFRA) Science Advisory Panel (SAP), 2013. Prioritization of the endocrine disruptor screening program universe of chemicals for an estrogen receptor adverse outcome pathway using computational toxicology tools, FIFRA Science Advisory Panel Meeting, Arlington, VA.  White Paper listed as ‘Meeting Materials’. Available at http://www.regulations.gov/#!documentDetail;D=EPA-HQ-OPP-2012-0818-0017.")
										.<Reference> makeItLive());
				link_ch1_mie1
						.getReferenceIDs()
						.add(
								new Reference(
										link_ch1_mie1,
										dataSource,
										"Anstead, G.M., Carlson, K.E., Katzenellenbogen, J.A., 1997. The estradiol pharmacophore: Ligand structure-estrogen receptor binding affinity relationships and a model for the receptor binding site, Steroids 62: 268–303.")
										.<Reference> makeItLive());
				link_ch1_mie1.getReferenceIDs().add(
						new Reference(link_ch1_mie1, dataSource,
								"Hamblen, E.L., Cronin, M.T.D., Schultz, T.W., 2003. Estrogenicity and acute toxicity of selected anilines using a recombinant yeast assay, Chemosphere 52: 1173–1181.")
								.<Reference> makeItLive());
				link_ch1_mie1
						.getReferenceIDs()
						.add(
								new Reference(
										link_ch1_mie1,
										dataSource,
										"Pakdel, F., Le Guellec, C.,  Vaillant, C., Le Roux, M.G., Valotaire, Y.,  1989. Identification and estrogen induction of two estrogen receptors (ER) messenger ribonucleic acids in the rainbow trout liver: 35 sequence homology with other ERs, Mol. Endocrinol. 3: 44–51.")
										.<Reference> makeItLive());
				link_ch1_mie1
						.getReferenceIDs()
						.add(
								new Reference(link_ch1_mie1, dataSource,
										"Matthews, J., Celius, T., Halgren, R., Zacharewski, T., 2000. Differential estrogen receptor binding of estrogenic substances: a species comparison, J. Ster. Biochem. Mol. Biol. 74: 223–234.")
										.<Reference> makeItLive());
				link_ch1_mie1
						.getReferenceIDs()
						.add(
								new Reference(
										link_ch1_mie1,
										dataSource,
										"Hornung, M.W., Tapper, M.A.,  Denny, J.S.,  Kolanczyk, R.C.,  Sheedy, B.R.,   Hartig, P.C., Aladjov, H., Henry, T.R., Schmieder, P.K., 2014. Effects-Based Chemical Category Approach for Prioritization of Low Affinity Estrogenic Chemicals. SAR and QSAR in Environmental Research, 25(04): 289 - 323.")
										.<Reference> makeItLive());
				
				DescriptionSection cyt_rtER = new DescriptionSection(
						mie1test1,
						dataSource,
						"Cytosolic rainbow trout ER (cyto rtER) in vitro Assay Method",
						"<html>\n<body>\n<p>Rainbow trout ER competitive binding assays were conducted using  liver cytosolic preparations (cyto rtER&alpha;&beta;) from immature  rainbow trout, with test chemical ability to displace [3H]-E2  used to determine IC50 and relative binding affinity (RBA) values (compared  with positive control, unlabeled E2, yielding 100% displacement as measured in  each assay) described in Schmieder et al., 2004. Thus the preparations  contained the full complement of ER receptors (&alpha;1, &alpha;2, &beta;1, &beta;2) found in trout  liver (Nagler et al., 2007).  Cyto rtER&alpha;&beta; from individual  fish was used for separate competitive binding experiments.  Saturation binding experiments were performed  on each cytosol to determine equilibrium dissociation constant (Kd = 2.0 nM ± 1.1; mean ± SD)  and maximum binding capacity (Bmax = 16.4 fmol/mg protein ± 6.1; mean ± SD) before use in competitive  binding assays. Each chemical was tested in duplicate technical replicates at a  minimum of six concentrations covering four to six log intervals. Each test  chemical was assayed in at least two different cyto rtER&alpha;&beta; preparations, and  if initial results indicated the chemical was active, a third competitive  binding experiment, typically including analysis of test chemical  concentration, was completed. To optimize the assay for detecting any potential  for activity of very low affinity ligands and thus increase confidence in  negative results, chemicals were tested to the maximum concentration of that  chemical&rsquo;s solubility in the assay media. In general a stock solution of  chemical was initially prepared in ethanol at 1.285 M from which five log- or  half-log unit dilutions were made in ethanol. Upon further dilution of ethanol  stocks into binding assay buffer, the maximal chemical test concentration that  could be achieved for any chemical was 0.010 M (-2 log M) and 1.5% ethanol. If  a chemical was not soluble in ethanol at 1.285 M, lower concentrations in  ethanol were attempted until it was soluble and then tested by dilution in  buffer media from that concentration. Binding assay media were inspected  visually for signs of precipitate formation at each concentration once the  ethanol stock dilution was added to the assay buffer. For unlabeled E2 and for  test chemicals that displaced greater than 50% of the [3H]-E2 from the  receptor, binding curves were fit using a One-Site Competition fit model (GraphPad Prism v5.02; GraphPad Software, Inc., La  Jolla, CA, USA) which constrained the Hillslope parameter to -1. Where 50%  displacement was not attained but trout slice vitellogenin (Vtg) mRNA expression  assays indicated a positive response, the partial binding curves were  extrapolated to 100% displacement by constraining the bottom of the binding  curves to zero, which then provided an extrapolated IC50. Relative binding  affinities were calculated for each experimental replicate (different cytosols  run on different days) by comparing the IC50 of the test chemical to the IC50  of the full E2 binding curve that was run in parallel in the same experiment:  RBA% = 100 × (IC50 test chemical / IC50 E2). Calculated RBAs presented are mean  and SD of the three experimental replicates. Data used to generate the curves  for IC50 calculations excluded concentrations where precipitate was observed,  except in cases where the Vtg slice assay data confirmed ER activation for that  chemical and inclusion of the higher concentration point in the binding data  analysis was needed for the One-Site Competition model to fit the data and  calculate an RBA. </p>\n</body>\n</html>")
						.<DescriptionSection> makeItLive();
				cyt_rtER.setFormat(ContentFormat.HTML);
				
				mie1test1.getDescriptionIDs().clear();
				mie1test1.getDescriptionIDs().add(cyt_rtER);
				
				mie1test1
						.getReferenceIDs()
						.set(
								new Reference(
										mie1test1,
										dataSource,
										"P.K. Schmieder, M.A. Tapper, J.S. Denny, R.C. Kolanczyk, B.R. Sheedy, T.R. Henry and G.D. Veith, 2004. Use of trout liver slices to enhance mechanistic interpretation of estrogen receptor binding for cost-effective prioritization of chemicals within large inventories, Environ. Sci. Technol. 38:6333–6342.")
										.<Reference> makeItLive(), 0);
				mie1test1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1test1,
										dataSource,
										"J. J. Nagler, T. Cavileer, Sullivan, J., D. G. Cyr, and C. Rexroad, III, 2007. The complete nuclear estrogen receptor family in the rainbow trout: Discovery of the novel ERα2 and both ERß isoforms, Gene 1–2:164–173.")
										.<Reference> makeItLive());
				
				DescriptionSection trout_liver_slices = new DescriptionSection(
						tissue_effect1test1,
						dataSource,
						"Trout liver slice ER-responsive Vtg mRNA gene expression assay.",
						"<html>\n<body>\n<p>Trout liver slice gene expression assays measuring induction of Vtg mRNA can be used to verify that ER binding displacement measured in cyto rtERαß binding, or rec rtERα binding assays is due to true competitive binding within the ER ligand binding domain, and translated to gene activation, and not due to an artifact. A detailed description of the rainbow trout liver slice assay is found in (Schmieder et al., 2004). For each slice assay a six-conc E2 curve is run as a positive control to verify the responsiveness of the slices and compare across slice experiments. Thus Vtg induction for a chemical in each experiment was determined in comparison to maximum induction by E2 and to the baseline observed with the solvent controls. To detect any potential for ER-mediated gene activation and minimize the potential for false negatives, statistically significant induction was determined by comparing the Vtg mRNA copy number in exposed slices with vehicle control slices using ANOVA followed by Dunnett’s t-test (p < 0.05). Due to the large dynamic range of the Vtg mRNA measurement by quantitative real time reverse transcriptase polymerase chain reaction (real time RT-PCR), unequal variances among treatment groups often resulted. Where this occurred Vtg mRNA data were log10 transformed and analyzed by ANOVA. If the transformation failed to normalize, the variances the non-parametric Kruskal–Wallis test were used followed by Dunn’s test to compare test chemical treatment with the vehicle control group with significance set at p < 0.05. Slice viability was assessed using: lactate dehydrogenase (LDH) enzyme activity leakage into the slice media; visual observation; and/or, a decrease in the slice Vtg mRNA at concentrations of the chemical above those showing significant Vtg mRNA induction. This sometimes occurred where no evidence of toxicity by LDH was detected, indicating the sensitive nature of the Vtg mRNA measure. Vtg induction is reported for a chemical only when it occurs at concentrations lower than those producing slice toxicity.</p>\n</body>\n</html>")
						.<DescriptionSection> makeItLive();
				trout_liver_slices.setFormat(ContentFormat.HTML);
				
				tissue_effect1test1.getDescriptionIDs().clear();
				tissue_effect1test1.getDescriptionIDs().add(trout_liver_slices);
				
				mie1test2 = new Test_InVitro(pathway, dataSource);
				mie1test2.setTitle("Recombinant rainbow trout ER (rec rtER) in vitro Assay");
				
				mie1test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				DescriptionSection rec_rtER = new DescriptionSection(
						mie1test2,
						dataSource,
						"Recombinant rainbow trout ER (rec rtER) in vitro Assay",
						"<html>A  recombinant rtER&alpha;  (rec rtER&alpha;) competitive binding assay can be used for testing very low  affinity industrial  chemicals, given the increased chemical  bioavailability in the assay due to very low total protein concentration.  This is in contrast to the cyto  rtER&alpha;&beta;  assay used to test the binding of hundreds of industrial chemicals where the endogenous receptors and  co-factors are present (Hornung et  al., 2014; Schmieder et al., 2014; and referenceds there-in). For instance, the  rec rtER&alpha; has  been used to get a more complete binding curve in  those cases where the cyto rtER&alpha;&beta; binding curves did not reach 50% displacement  but Vtg gene expression results indicated activity.  The  rtER&alpha;  gene (from Dr. Farzad Pakdel, (Pakdel et al., 1990; Pakdel et al., 2000; Hornung et al., 2014)) was used to generate a recombinant baculovirus with the ER gene expressed under the  control of the polh promoter and then used to infect Sf9  insect cells for production of ER protein as previously described (Rider et al., 2009).  The  expressed rec rtER&alpha; was prepared for binding assays by  lysing the cells and then processed using the same homogenization and  centrifugation steps used for preparation of the trout liver cytosol (Hornung et al., 2014).  A  1:10,000 dilution of this preparation was used to determine equilibrium  dissociation constant <strong>(Kd = 1.33 nM)</strong> and maximum binding capacity <strong>(Bmax =1760 fmol/mg protein)</strong>.  The  rec  rtER&alpha; binding assay was performed under the same conditions as the cyto  rtER&alpha;&beta; binding assay, with the only difference being the receptor  used and increased test chemical bioavailability.  A more complete curve can often be detected  with rec rtER&alpha;  when it cannot with cyto rtER&alpha;&beta; solely due to greater chemical availability (USEPA, 2009; USEPA, 2013  Appendix G.; Heringa et al., 2004). In the  rec rtER&alpha; assay the lower total protein concentration is 0.01 mg/ml compared to  the 4 mg/ml in the cyto rtER&alpha;&beta; assays.  Chemicals tested in rec rtER&alpha;  system have higher free fraction of a chemical for a given nominal  concentration than those in cyto rtER&alpha;&beta; assays  (Heringa et al., 2004); thus there is  greater displacement of [3H]-E2 at lower concentrations  of xenobiotic test chemical when using the rec  rtER&alpha; compared to cyto rtER&alpha;&beta; with  displacement curves shifted to the left.</html></html>")
						.<DescriptionSection> makeItLive();
				rec_rtER.setFormat(ContentFormat.HTML);
				
				mie1test2.getDescriptionIDs().clear();
				mie1test2.getDescriptionIDs().add(rec_rtER);
				
				mie1test2
						.getReferenceIDs()
						.add(
								new Reference(
										mie1test2,
										dataSource,
										"M.W. Hornung, M.A. Tapper, J.S. Denny, R.C. Kolanczyk, B.R. Sheedy, P.C. Hartig, H. Aladjov, T.R. Henry and P.K. Schmieder Effects-Based Chemical Category Approach for Prioritization of Low Affinity Estrogenic Chemicals  Journal: SAR and QSAR in Environmental Research , Volume: 25, Issue: 04, pages 289 - 323.  Published Online: 29 Apr 2014")
										.<Reference> makeItLive());
				mie1test2
						.getReferenceIDs()
						.add(
								new Reference(
										mie1test2,
										dataSource,
										"P.K. Schmieder, R.C. Kolanczyk, M.W. Hornung, M.A. Tapper, J.S. Denny, B.R. Sheedy and H. Aladjov A Rule-based Expert System for Chemical Prioritization Using Effects-based Chemical Categories Journal: SAR and QSAR in Environmental Research , Volume: 25, Issue: 04, pages 253 - 287.")
										.<Reference> makeItLive());
				mie1test2.getReferenceIDs().add(
						new Reference(mie1test2, dataSource,
								"F. Pakdel, F. Le Gac, P. Le Goff and Y. Valotaire, Full-length sequence and in vitro expression of rainbow trout estrogen receptor cDNA, Mol. Cell. Endocrinol. 71, (1990), 195–204.")
								.<Reference> makeItLive());
				mie1test2
						.getReferenceIDs()
						.add(
								new Reference(
										mie1test2,
										dataSource,
										"F. Pakdel, R. Métivier, G. Flouriot and Y. Valotaire, Two estrogen receptor (ER) isoforms with dif- ferent estrogen dependencies are generated from the trout ER gene, Endocrinology 141, (2000), 15 571–580.")
										.<Reference> makeItLive());
				mie1test2
						.getReferenceIDs()
						.add(
								new Reference(mie1test2, dataSource,
										"C.V. Rider, P.C. Hartig, M.C. Cardon and V.S. Wilson, Development of a competitive binding assay system with recombinant estrogen receptors from multiple species, Tox. Lett. 184, (2009), 85–89.")
										.<Reference> makeItLive());
				mie1test2
						.getReferenceIDs()
						.add(
								new Reference(
										mie1test2,
										dataSource,
										"US Environmental Protection Agency (EPA), Federal Insecticide, Fungicide, and Rodenticide Act (FIFRA) Science Advisory Panel (SAP), 2009. An effects-based expert system to predict estrogen receptor binding affinity for food use inert ingredients and antimicrobial pesticides: application in a prioritization scheme for endocrine disruptor screening, FIFRA Science Advisory Panel Meeting, Arlington, VA. White paper listed as ‘Meeting Materials’. Available at http://www.regulations.gov/#!docket-Detail;D=EPA-HQ-OPP-2009-0322.")
										.<Reference> makeItLive());
				mie1test2
						.getReferenceIDs()
						.add(
								new Reference(
										mie1test2,
										dataSource,
										"US Environmental Protection Agency, Federal Insecticide, Fungicide, and Rodenticide Act (FIFRA) Science Advisory Panel (SAP), Prioritization of the endocrine disruptor screening program uni- 10 verse of chemicals for an estrogen receptor adverse outcome pathway using computational toxicology tools, FIFRA Science Advisory Panel Meeting, Arlington, VA, 2013, White Paper listed as ‘Meeting Materials’. Available at http://www.regulations.gov/#!documentDetail;D=EPA-HQ-OPP- 2012-0818-0017.")
										.<Reference> makeItLive());
				mie1test2
						.getReferenceIDs()
						.add(
								new Reference(
										mie1test2,
										dataSource,
										"M. Heringa, R. Schreurs, F. Busser, P. Van Der Saag, B. Van Der Burg and J. Hermens, Toward more useful in vitro toxicity data with measured free concentrations, Environ. Sci. Technol. 38, 20 (2004), 6263–6270.")
										.<Reference> makeItLive());
				
				mie1test2.relateWith(mie1test1);
				
				new TestResponseMapping(pathway, dataSource, mie1test2, mie1);
				
			}
		
		public void genreateRevision10()
			{
				chemical2 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical2.setTitle("Octylphnenol");
				chemical2.getStructure2DImage().setValue("https://app.effectopedia.org/media/chem/octylphenol.png");
				chemical2.getIdentification().setPropertyValue(0, "27193288");
				chemical2.getIdentification().setPropertyValue(1, "(1,1,3,3-tetramethylbutyl)phenol");
				chemical2.getIdentification().setPropertyValue(2, "OC1=CC(C(C)(C)CC(C)(C)C)=CC=C1");
				chemical2.getIdentification().setPropertyValue(3, "C14H22O");
				chemical2.getProperties().setPropertyValue(0, "206.3239");
				
				link_ch2_mie1 = new Link_ChemStructToMIE(pathway, dataSource, chemical2, mie1);
				// TODO Test case for the test mapping depiction bug
				
				subst_data1s = new SubstanceData(mie1test1, chemical1, dataSource);
				ObjectProperties summary = DefaultEffectopediaObjects.DEFAULT_D_RESP_AND_REF_DATA.clone(chemical1, dataSource);
				subst_data1s.setTemplates(DefaultDataTemplates.DTS_DR_DUAL_CHEM_MEAN_MIN_MAX);
				subst_data1s.setObjectProperties(summary);
				ObjectPropertyMultivalued_Documented testedSubst = (ObjectPropertyMultivalued_Documented) summary.getProperty("Tested_Subst_Log_Conc_Response");
				// mean min max unit chem conc. unit notes references
				String[][] values = new String[][]
					{
						{ "95.1", "92", "98.3", "E2%[3H]-E2", "", "", "-5", "logM", "", "", "3.2", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" },
						{ "102.1", "95.6", "108.5", "E2%[3H]-E2", "", "", "-4", "logM", "", "", "6.5", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" },
						{ "43.2", "38.9", "47.5", "E2%[3H]-E2", "", "", "-3", "logM", "", "", "4.3", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" },
						{ "28.1", "22", "34.3", "E2%[3H]-E2", "", "", "-2.7", "logM", "", "", "6.2", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" },
						{ "19.2", "10.5", "27.9", "E2%[3H]-E2", "", "", "-2.3", "logM", "", "", "8.7", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" },
						{ "8.1", "3.8", "12.5", "E2%[3H]-E2", "", "", "-2", "logM", "", "", "4.4", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" } };
				testedSubst.assign(values);
				
				ObjectPropertyMultivalued_Documented refSubst = (ObjectPropertyMultivalued_Documented) summary.getProperty("Reference_Subst_Log_Conc_Response");
				// mean min max unit chem conc. unit notes references
				values = new String[][]
					{
						{ "100", "100", "100", "E2%[3H]-E2", "", "", "-11", "logM", "", "", "0", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" },
						{ "97.7", "96.2", "99.1", "E2%[3H]-E2", "", "", "-10", "logM", "", "", "1.4", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" },
						{ "87.2", "85.8", "88.6", "E2%[3H]-E2", "", "", "-9", "logM", "", "", "1.4", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" },
						{ "46.1", "42.2", "49.9", "E2%[3H]-E2", "", "", "-8", "logM", "", "", "3.8", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" },
						{ "11.9", "10.8", "13.1", "E2%[3H]-E2", "", "", "-7", "logM", "", "", "1.2", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" },
						{ "0", "0", "0", "E2%[3H]-E2", "", "", "-6", "logM", "", "", "0", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" } };
				refSubst.assign(values);
				
				subst_data2s = new SubstanceData(mie1test1, chemical2, dataSource);
				summary = DefaultEffectopediaObjects.DEFAULT_D_RESP_AND_REF_DATA.clone(chemical2, dataSource);
				subst_data2s.setTemplates(DefaultDataTemplates.DTS_DR_DUAL_CHEM_MEAN_MIN_MAX);
				subst_data2s.setObjectProperties(summary);
				testedSubst = (ObjectPropertyMultivalued_Documented) summary.getProperty(DefaultEffectopediaObjects.DEFAULT_D_RESP_TESTED_CHEMICAL);
				// mean min max unit chem conc. unit notes references
				values = new String[][]
					{
						{ "99", "97", "101.1", "E2%[3H]-E2", "", "", "-9", "logM", "", "", "2.1", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" },
						{ "101.9", "97.4", "106.3", "E2%[3H]-E2", "", "", "-8", "logM", "", "", "4.5", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" },
						{ "100", "98.1", "101.8", "E2%[3H]-E2", "", "", "-7", "logM", "", "", "1.8", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" },
						{ "94.3", "90", "98.5", "E2%[3H]-E2", "", "", "-6", "logM", "", "", "4.3", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" },
						{ "76.9", "72.7", "81.1", "E2%[3H]-E2", "", "", "-5", "logM", "", "", "4.2", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" },
						{ "37.5", "33.8", "41.3", "E2%[3H]-E2", "", "", "-4", "logM", "", "", "3.7", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" },
						{ "1.8", "0.6", "3", "E2%[3H]-E2", "", "", "-3.3", "logM", "", "", "1.2", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" },
						{ "-5.5", "-8.0", "-2.9", "E2%[3H]-E2", "", "", "-3", "logM", "", "", "2.6", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" } };
				testedSubst.assign(values);
				
				refSubst = (ObjectPropertyMultivalued_Documented) summary.getProperty(DefaultEffectopediaObjects.DEFAULT_D_RESP_REFERENCE_CHEMICAL);
				// mean min max unit chem conc. unit notes references
				values = new String[][]
					{
						{ "100", "100", "100", "E2%[3H]-E2", "", "", "-11", "logM", "", "", "0.0", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" },
						{ "97.2", "96.3", "98.1", "E2%[3H]-E2", "", "", "-10", "logM", "", "", "0.9", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" },
						{ "82.3", "81.4", "83.3", "E2%[3H]-E2", "", "", "-9", "logM", "", "", "1.0", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" },
						{ "38.9", "36", "41.8", "E2%[3H]-E2", "", "", "-8", "logM", "", "", "2.9", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" },
						{ "7.2", "6.9", "7.5", "E2%[3H]-E2", "", "", "-7", "logM", "", "", "0.3", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" },
						{ "0", "0", "0", "E2%[3H]-E2", "", "", "-6", "logM", "", "", "0.0", "E2%[3H]-E2", "", "", "", "", "3", "", "", "" } };
				refSubst.assign(values);
				
				subst_data3s = new SubstanceData(mie1test2, chemical1, dataSource);
				summary = DefaultEffectopediaObjects.DEFAULT_D_RESP_AND_REF_DATA.clone(chemical1, dataSource);
				subst_data3s.setTemplates(DefaultDataTemplates.DTS_DR_DUAL_CHEM_MEAN_MIN_MAX);
				subst_data3s.setObjectProperties(summary);
				testedSubst = (ObjectPropertyMultivalued_Documented) summary.getProperty("Tested_Subst_Log_Conc_Response");
				// mean min max unit chem conc. unit notes references
				values = new String[][]
					{
						{ "102.9", "102.9", "102.9", null, "", "", "-8", "logM", "", "", "0", "", "", "", "", "", "1", "", "", "" },
						{ "117.3", "117.3", "117.3", null, "", "", "-7", "logM", "", "", "0", "", "", "", "", "", "1", "", "", "" },
						{ "96.6", "86.6", "103.7", null, "", "", "-6", "logM", "", "", "7.1", "", "", "", "", "", "3", "", "", "" },
						{ "109.6", "102.5", "116.7", null, "", "", "-5", "logM", "", "", "7.1", "", "", "", "", "", "5", "", "", "" },
						{ "93.2", "78.5", "108.0", null, "", "", "-4", "logM", "", "", "14.8", "", "", "", "", "", "5", "", "", "" },
						{ "33.8", "33.8", "33.8", null, "", "", "-3.7", "logM", "", "", "0", "", "", "", "", "", "1", "", "", "" },
						{ "16.3", "13.4", "19.1", null, "", "", "-3.3", "logM", "", "", "2.8", "", "", "", "", "", "3", "", "", "" },
						{ "11.8", "9.9", "13.8", null, "", "", "-3", "logM", "", "", "2.0", "", "", "", "", "", "4", "", "", "" },
						{ "10.7", "10.7", "10.7", null, "", "", "-2.7", "logM", "", "", "0.0", "", "", "", "", "", "1", "", "", "" },
						{ "10.6", "5.4", "15.9", null, "", "", "-2.3", "logM", "", "", "5.2", "", "", "", "", "", "2", "", "", "" },
						{ "6.7", "4.7", "8.7", null, "", "", "-2", "logM", "", "", "2.0", "", "", "", "", "", "4", "", "", "" } };
				testedSubst.assign(values);
				
				refSubst = (ObjectPropertyMultivalued_Documented) summary.getProperty("Reference_Subst_Log_Conc_Response");
				// mean min max unit chem conc. unit notes references
				values = new String[][]
					{
						{ "100", "100", "100", null, "", "", "-11", "logM", "", "", "0", "", "", "", "", "", "5", "", "", "" },
						{ "111.6", "103.9", "119.4", null, "", "", "-10", "logM", "", "", "7.7", "", "", "", "", "", "5", "", "", "" },
						{ "102.9", "93.6", "112.2", null, "", "", "-9", "logM", "", "", "9.3", "", "", "", "", "", "5", "", "", "" },
						{ "38.8", "34.3", "43.2", null, "", "", "-8", "logM", "", "", "4.5", "", "", "", "", "", "5", "", "", "" },
						{ "7.6", "5.8", "9.4", null, "", "", "-7", "logM", "", "", "1.8", "", "", "", "", "", "5", "", "", "" },
						{ "0", "0", "0", null, "", "", "-6", "logM", "", "", "0", "", "", "", "", "", "5", "", "", "" } };
				refSubst.assign(values);
				
				subst_data4s = new SubstanceData(mie1test2, chemical2, dataSource);
				summary = DefaultEffectopediaObjects.DEFAULT_D_RESP_AND_REF_DATA.clone(chemical2, dataSource);
				subst_data4s.setTemplates(DefaultDataTemplates.DTS_DR_DUAL_CHEM_MEAN_MIN_MAX);
				subst_data4s.setObjectProperties(summary);
				testedSubst = (ObjectPropertyMultivalued_Documented) summary.getProperty("Tested_Subst_Log_Conc_Response");
				// mean min max unit chem conc. unit notes references
				values = new String[][]
					{
						{ "111.8", "107.9", "115.6", null, "", "", "-8", "logM", "", "", "3.9", "", "", "", "", "", "3", "", "", "" },
						{ "112.9", "112", "113.9", null, "", "", "-7", "logM", "", "", "1.0", "", "", "", "", "", "3", "", "", "" },
						{ "69.4", "66.1", "72.7", null, "", "", "-6", "logM", "", "", "3.3", "", "", "", "", "", "3", "", "", "" },
						{ "14.4", "13.1", "15.8", null, "", "", "-5", "logM", "", "", "1.3", "", "", "", "", "", "3", "", "", "" },
						{ "1.7", "0.4", "2.9", null, "", "", "-4", "logM", "", "", "1.2", "", "", "", "", "", "3", "", "", "" },
						{ "29.4", "26.6", "32.2", null, "", "", "-3", "logM", "", "", "2.8", "", "", "", "", "", "3", "", "", "" } };
				testedSubst.assign(values);
				
				refSubst = (ObjectPropertyMultivalued_Documented) summary.getProperty("Reference_Subst_Log_Conc_Response");
				// mean min max unit chem conc. unit notes references
				values = new String[][]
					{
						{ "100", "100", "100", null, "", "", "-11", "logM", "", "", "0", "", "", "", "", "", "3", "", "", "" },
						{ "101.3", "95.8", "106.7", null, "", "", "-10", "logM", "", "", "5.4", "", "", "", "", "", "3", "", "", "" },
						{ "93.5", "87", "99.9", null, "", "", "-9", "logM", "", "", "6.5", "", "", "", "", "", "3", "", "", "" },
						{ "41.4", "38.8", "44.1", null, "", "", "-8", "logM", "", "", "2.6", "", "", "", "", "", "3", "", "", "" },
						{ "5.4", "5.0", "5.8", null, "", "", "-7", "logM", "", "", "0.4", "", "", "", "", "", "3", "", "", "" },
						{ "0", "0", "0", null, "", "", "-6", "logM", "", "", "0", "", "", "", "", "", "3", "", "", "" } };
				refSubst.assign(values);
				
				subst_data5s = new SubstanceData(tissue_effect1test1, chemical1, dataSource);
				summary = DefaultEffectopediaObjects.DEFAULT_D_RESP_AND_REF_DATA.clone(chemical1, dataSource);
				subst_data5s.setTemplates(DefaultDataTemplates.DTS_DR_DUAL_CHEM_MEAN_MIN_MAX);
				subst_data5s.setObjectProperties(summary);
				testedSubst = (ObjectPropertyMultivalued_Documented) summary.getProperty("Tested_Subst_Log_Conc_Response");
				// mean min max unit chem conc. unit notes references
				values = new String[][]
					{
						{ "135310.2", "25170.6", "245449.8", "mRNA copies/400g total RNA", "", "", "-6", "logM", "", "", "110139.6", "", "", "", "", "", "2", "", "", "" },
						{ "173021.3", "136589.5", "209453.1", "mRNA copies/400g total RNA", "", "", "-5", "logM", "", "", "36431.84", "", "", "", "", "", "5", "", "", "" },
						{ "249812.4", "249812.4", "249812.4", "mRNA copies/400g total RNA", "", "", "-4.7", "logM", "", "", "0", "", "", "", "", "", "1", "", "", "" },
						{ "754872.1", "110658.2", "1399086.0", "mRNA copies/400g total RNA", "", "", "-4.3", "logM", "", "", "644213.9", "", "", "", "", "", "2", "", "", "" },
						{ "7230270", "3049414.0", "11411126.0", "mRNA copies/400g total RNA", "", "", "-4", "logM", "", "", "4180856", "", "", "", "", "", "5", "", "", "" },
						{ "16962620", "2877620.0", "31047620.0", "mRNA copies/400g total RNA", "", "", "-3.7", "logM", "", "", "14085000", "", "", "", "", "", "4", "", "", "" },
						{ "12572890", "	2008940.0", "23136840.0", "mRNA copies/400g total RNA", "", "", "-3.3", "logM", "", "", "10563950", "", "", "", "", "", "5", "", "", "" }, };
				testedSubst.assign(values);
				
				refSubst = (ObjectPropertyMultivalued_Documented) summary.getProperty("Reference_Subst_Log_Conc_Response");
				// mean min max unit chem conc. unit notes references
				values = new String[][]
					{
						{ "241670.6", "	54122.0", "	429219.2", "mRNA copies/400g total RNA", "", "", "-10", "logM", "", "", "187548.6", "", "", "", "", "", "5", "", "", "" },
						{ "1556822", "	711467.7", "	2402176.3", "mRNA copies/400g total RNA", "", "", "-9", "logM", "", "", "845354.3", "", "", "", "", "", "5", "", "", "" },
						{ "9949959", "	3288100.0", "	16611818.0", "mRNA copies/400g total RNA", "", "", "-8", "logM", "", "", "6661859", "", "", "", "", "", "5", "", "", "" },
						{ "16239190", "	10286616.0", "	22191764.0", "mRNA copies/400g total RNA", "", "", "-7", "logM", "", "", "5952574", "", "", "", "", "", "5", "", "", "" },
						{ "21476930", "	10174380.0", "	32779480.0", "mRNA copies/400g total RNA", "", "", "-6", "logM", "", "", "11302550", "", "", "", "", "", "5", "", "", "" },
						{ "19977000", "	10431237.0", "	29522763.0", "mRNA copies/400g total RNA", "", "", "-5", "logM", "", "", "9545763", "", "", "", "", "", "5", "", "", "" } };
				refSubst.assign(values);
				
			}
		
		public void genreateRevision11()
			{
				
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "all");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "all");
				tissue_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F0) parent generation");
				tissue_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F0) parent generation");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F0) parent generation");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F0) parent generation");
				organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F1) first generation");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F0) parent generation");
				individual_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F0) parent generation");
				population_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "all");
				population_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "all");
				population_adverseOutcome.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "all");
				
				individual_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F1) first generation");
				individual_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F0) parent generation");
				
				mie1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "all");
				mie1test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "all");
				tissue_effect1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "all");
				
				tissue_effect1test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F0) parent generation");
				tissue_effect1test3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F1) first generation");
				
				tissue_effect2test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F0) parent generation");
				tissue_effect2test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F1) first generation");
				organ_effect1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F1) first generation");
				organ_effect2test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F0) parent generation");
				organ_effect2test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F1) first generation");
				
				individual_effect1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F0) parent generation");
				individual_effect2test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F0) parent generation");
				
			}
		
		public void genreateRevision12()
			{
				tissue_effect1a = new Effect_DownstreamEffect(pathway, dataSource);
				tissue_effect1a.setTitle("Vtg mRNA induction");
				tissue_effect1a.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				tissue_effect1a.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				tissue_effect1a.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F1) first generation");
				
				tissue_effect2a = new Effect_DownstreamEffect(pathway, dataSource);
				tissue_effect2a.setTitle("Altered Anal fin papillae");
				tissue_effect2a.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				tissue_effect2a.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				tissue_effect2a.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F1) first generation");
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, tissue_effect1a);
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, tissue_effect2a);
				
				organ_effect2a = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect2a.setTitle("Altered phenotype of testes in genetic males");
				organ_effect2a.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect2a.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				organ_effect2a.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F1) first generation");
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, organ_effect2a);
				
				individual_effect1a = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect1a.setTitle("Altered Fertility");
				individual_effect1a.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect1a.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				individual_effect1a.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F1) first generation");
				
				individual_effect2a = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect2a.setTitle("Altered Fecundity");
				individual_effect2a.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect2a.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				individual_effect2a.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F1) first generation");
				
				new Link_EffectToEffect(pathway, dataSource, organ_effect2a, individual_effect1a);
				new Link_EffectToEffect(pathway, dataSource, organ_effect2a, individual_effect2a);
				
				new Link_EffectToEffect(pathway, dataSource, individual_effect1a, population_effect1);
				new Link_EffectToEffect(pathway, dataSource, individual_effect2a, population_effect1);
				new Link_EffectToEffect(pathway, dataSource, organ_effect2a, population_effect2);
				
				TestResponseMapping.unmap(mapping_t3te1, tissue_effect1);
				TestResponseMapping.unmap(mapping_t2te2, tissue_effect2);
				TestResponseMapping.unmap(mapping_t2oe2, organ_effect2);
				TestResponseMapping.map(mapping_t3te1, tissue_effect1a);
				TestResponseMapping.map(mapping_t2te2, tissue_effect2a);
				TestResponseMapping.map(mapping_t2oe2, organ_effect2a);
				
				pathway.disassociate(link_oe1_ie1);
				pathway.disassociate(link_oe1_ie2);
				pathway.disassociate(link_oe2_pe2);
			}
		
		public void genreateRevision13()
			{
				
				organ_effect3a = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect3a.setTitle("Altered phenotype of testes in genetic males");
				organ_effect3a.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect3a.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				organ_effect3a.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F2) second generation");
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, organ_effect3a);
				
				individual_effect3a = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect3a.setTitle("Altered Fecundity");
				individual_effect3a.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect3a.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				individual_effect3a.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F2) second generation");
				
				new Link_EffectToEffect(pathway, dataSource, organ_effect3a, individual_effect3a);
				
				new Link_EffectToEffect(pathway, dataSource, individual_effect3a, population_effect1);
				
				organ_effect3test1 = new Test_InVivo(pathway, dataSource);
				organ_effect3test1.setTitle("Medaka F2");
				organ_effect3test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect3test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				organ_effect3test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F2) second generation");
				
				mapping_oe3tot1 = new TestResponseMapping(pathway, dataSource, organ_effect3test1, organ_effect3a);
				
				individual_effect3test1 = new Test_InVivo(pathway, dataSource);
				individual_effect3test1.setTitle("Medaka F2");
				individual_effect3test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect3test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "male");
				individual_effect3test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_GENERATION.DIMENSION_INDEX, "(F2) second generation");
				
				mapping_i3tit1 = new TestResponseMapping(pathway, dataSource, individual_effect3test1, individual_effect3a);
				
			}
		
		public void genreateRevision14()
			{
				chemical1.setTitle("4-n-Amylaniline");
				chemical1.getIdentification().setPropertyValue(3, "InChI=1S/C11H17N/c1-2-3-4-5-10-6-8-11(12)9-7-10/h6-9H,2-5,12H2,1H3");
				chemical1.getIdentification().setPropertyValue(4, "DGFTWBUZRHAHTH-UHFFFAOYSA-N");
				chemical1.getIdentification().setPropertyValue(6, "C11H17N");
				
				chemical2.setTitle("4-t-Octylphenol");
				chemical2.getStructure2DImage().setValue("https://apps.ideaconsult.net/ambit2/depict/cdk?search=OC1%3DCC%3DC%28C%28C%29%28C%29CC%28C%29%28C%29C%29C%3DC1&w=200&h=200&media=image/png");
				chemical2.getIdentification().setPropertyValue(0, "140669");
				chemical2.getIdentification().setPropertyValue(1, "4-(1,1,3,3,-tetramethylbutyl)-phenol");
				chemical2.getIdentification().setPropertyValue(2, "OC1=CC=C(C(C)(C)CC(C)(C)C)C=C1");
				chemical2.getIdentification().setPropertyValue(3, "InChI=1S/C14H22O/c1-13(2,3)10-14(4,5)11-6-8-12(15)9-7-11/h6-9,15H,10H2,1-5H3");
				chemical2.getIdentification().setPropertyValue(4, "ISAVYTVYFVQUDY-UHFFFAOYSA-N");
				chemical2.getIdentification().setPropertyValue(6, "C14H22O");
			}
		
		private final User	RJOHNSON			= new User("Rodney Jhonson", 38L);
		
		private final User	PSCHMIEDER	= new User("Patricia Schmieder", 37L);
		private final User	KFLYNN					= new User("Kevin Flynn", 26L);
		
	}

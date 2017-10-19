package org.qsari.effectopedia.data.generated;

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
import org.qsari.effectopedia.core.objects.Reference;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.core.objects.Test_ExVivo;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.RevisionBasedDS;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public class GeneratedAOP extends SourceGeneratedPathway
	{
		
		public GeneratedAOP(DataSource dataSource)
			{
				super("Protein Alkylation to Liver Fibrosis", "", dataSource, "D://Java//org.qsari.effectopedia//test//Protein Alkylation to Liver Fibrosis");
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
		protected Effect_AdverseOutcome											effect_adverseoutcome15;
		protected Link_EffectToEffect													link_effecttoeffect16;
		protected TestResponseMapping													testresponsemapping17;
		protected Test_ExVivo																					test_exvivo18;
		
		@Override
		public void generateContent()
			{
				genreateRevision1();
				storeRevision();
				((RevisionBasedDS) dataSource).setLocation(pathway);
			}
		
		public void genreateRevision1()
			{
				
				initiator_chemicalstructure1 = new Initiator_ChemicalStructure(pathway, dataSource);
				initiator_chemicalstructure1.setTitle("carbon tetrachlride Chemical Strucutre");
				initiator_chemicalstructure1.getStructure2DImage().setValue("org.qsari.effectopedia.data.objects.ObjectProperty@b68ba7");
				initiator_chemicalstructure1.getIdentification().setPropertyValue(0, "0");
				initiator_chemicalstructure1.getIdentification().setPropertyValue(1, "n/a");
				initiator_chemicalstructure1.getIdentification().setPropertyValue(2, "");
				initiator_chemicalstructure1.getIdentification().setPropertyValue(3, " ");
				initiator_chemicalstructure1.getIdentification().setPropertyValue(4, "VZGDMQKNWNREIO-UHFFFAOYSA-N");
				initiator_chemicalstructure1.getIdentification().setPropertyValue(5, " ");
				initiator_chemicalstructure1.getIdentification().setPropertyValue(6, "");
				initiator_chemicalstructure1.setSynonymsList(new String[]
					{ " " });
				
				effect_molecularinitiatingevent3 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				effect_molecularinitiatingevent3.setTitle("Protein Alkylation");
				effect_molecularinitiatingevent3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				effect_molecularinitiatingevent3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE.DIMENSION_INDEX, "zygote");
				effect_molecularinitiatingevent3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				effect_molecularinitiatingevent3
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_molecularinitiatingevent3,
										dataSource,
										"Definition",
										"Alkylation is the transfer of an alkyl group from one molecule to another. The alkyl group may be transferred as an alkyl carbocation, a free radical, a carbanion or a carbene (or their equivalents). Protein alkylation is the addition of an alkyl group to a protein amino acid. An alkyl group is any group derived from an alkane by removal of one hydrogen atom. Alkylating agents are highly reactive chemicals that introduce alkyl groups into biologically active molecules and thereby prevent their proper functioning. Alkylating agents are classified according to their nucleophilic or electrophilic character. Nucleophilic alkylating agents deliver the equivalent of an alkyl anion (carbanion). These compounds typically can add to an electron-deficient carbon atom such as at a carbonyl group. Electrophilic alkylating agents deliver the equivalent of an alkyl cation. Alkyl halides can also react directly with amines to form C-N bonds; the same holds true for other nucleophiles such as alcohols, carboxylic acids, thiols, etc. Alkylation with only one carbon is termed methylation. [1] [2]\n\nCovalent protein alkylation by reactive electrophiles was identified as a key triggering event in chemical toxicity over 40 years ago and these reactions remain a major cause of chemical-induced toxicity. Interestingly, some chemical molecules produce significant protein covalent binding without causing toxicity, which suggests that only a critical subset of protein alkylation events contributes to injury. The study by Codreanu et al. (2014) describes an inventory of electrophile- mediated protein damage in intact cells and suggests that non-toxic covalent binding may largely be survivable damage to cytoskeletal components, whereas toxic covalent binding produces lethal injury by targeting protein synthesis and catabolism and possibly mitochondrial electron transport")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);
				effect_molecularinitiatingevent3
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_molecularinitiatingevent3,
										dataSource,
										"Measurment/detection",
										"HPLC-ESI-MS/MS analysis\n\nHigh Performance Liquid Chromatography – electrospray tandem mass spectrometry (HPLC-ESI-MS/MS) is the most popular MS technique. It combines the separation ability of HPLC along with the sensitivity and specificity of detection from MS. One of the advantages of HPLC-MS is that it allows samples to be rapidly desalted online, so no sample preparation is required unlike samples for GC-MS. Electrospray ionisation can produce singly or multiply charged ions. Typically high molecular weight compounds have multiple charges i.e. peptides and proteins. This technique is particularly suited to analysing polar molecules of mass <2000 Dalton and requires no prior derivatisation in most applications. [8] [3] [9]\n\nMALDI-TOF/MS (Matrix Assisted Laser Desorption/Ionization Time of Flight Mass Spectrometry)\n\nMatrix-assisted laser desorption/ionization (MALDI) is a soft ionization technique used in mass spectrometry, allowing the analysis of biomolecules (biopolymers such as DNA, proteins, peptides and sugars) and large organic molecules (such as polymers, dendrimers and other macromolecules), which tend to be fragile and fragment when ionized by more conventional ionization methods. MALDI methodology is a three-step process. First, the sample is mixed with a suitable matrix material and applied to a metal plate. Second, a pulsed laser irradiates the sample, triggering ablation and desorption of the sample and matrix material. Finally, the analyte molecules are ionized by being protonated or deprotonated in the hot plume of ablated gases, and can then be accelerated into whichever mass spectrometer is used to analyse them.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 1);
				
				effect_downstreameffect5 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect5.setTitle("cell injury/death");
				effect_downstreameffect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				effect_downstreameffect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				effect_downstreameffect5
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect5,
										dataSource,
										"Definition",
										"Two types of cell death can be distinguished by morphological features, although it is likely that these are two ends of a spectrum with possible intermediate forms. Apoptosis involves shrinkage, nuclear disassembly, and fragmentation of the cell into discrete bodies with intact plasma membranes. These are rapidly phagocytosed by neighbouring cells. An important feature of apoptosis is the requirement for adenosine triphosphate (ATP) to initiate the execution phase. In contrast, necrotic cell death is characterized by cell swelling and lysis. This is usually a consequence of profound loss of mitochondrial function and resultant ATP depletion, leading to loss of ion homeostasis, including volume regulation, and increased Ca2+. The latter activates a number of nonspecific hydrolases (i.e., proteases, nucleases, and phospholipases) as well as calcium dependent kinases. Activation of calpain I, the Ca2+-dependent cysteine protease cleaves the death-promoting Bcl-2 family members Bid and Bax which translocate to mitochondrial membranes, resulting in release of truncated apoptosis-inducing factor (tAIF), cytochrome c and endonuclease in the case of Bid and cytocrome c in the case of Bax. tAIF translocates to cell nuclei, and together with cyclophilin A and phosphorylated histone H2AX (γH2AX) is responsible for DNA cleavage, a feature of programmed necrosis. Activated calpain I has also been shown to cleave the plasma membrane Na+–Ca2+ exchanger, which leads to build-up of intracellular Ca2+, which is the source of additional increased intracellular Ca2+. Cytochrome c in cellular apoptosis is a component of the apoptosome.\n\nDNA damage activates nuclear poly(ADP-ribose) polymerase-1(PARP-1), a DNA repair enzyme. PARP-1 forms poly(ADP-ribose) polymers, to repair DNA, but when DNA damage is extensive, PAR accumulates, exits cell nuclei and travels to mitochondrial membranes, where it, like calpain I, is involved in AIF release from mitochondria. A fundamental distinction between necrosis and apoptosis is the loss of plasma membrane integrity; this is integral to the former but not the latter. As a consequence, lytic release of cellular constituents promotes a local inflammatory reaction, whereas the rapid removal of apoptotic bodies minimizes such a reaction. The distinction between the two modes of death is easily accomplished in vitro but not in vivo. Thus, although claims that certain drugs induce apoptosis have been made, these are relatively unconvincing. DNA fragmentation can occur in necrosis, leading to positive TUNEL staining. Conversely, when apoptosis is massive, it can exceed the capacity for rapid phagocytosis, resulting in the eventual appearance of secondary necrosis.\n\nTwo alternative pathways - either extrinsic (receptor-mediated) or intrinsic (mitochondria-mediated) - lead to apoptotic cell death. The initiation of cell death begins either at the plasma membrane with the binding of TNF or FasL to their cognate receptors or within the cell. The latter is due to the occurrence of intracellular stress in the form of biochemical events such as oxidative stress, redox changes, covalent binding, lipid peroxidation, and consequent functional effects on mitochondria, endoplasmic reticulum, microtubules, cytoskeleton, or DNA. The intrinsic mitochondrial pathway involves the initiator, caspase-9, which, when activated, forms an “apoptosome” in the cytosol, together with cytochrome c, which translocates from mitochondria, Apaf-1 and dATP. The apoptosome activates caspase-3, the central effector caspase, which in turn activates downstream factors that are responsible for the apoptotic death of a cell [1]. Intracellular stress either directly affects mitochondria or can lead to effects on other organelles, which then send signals to the mitochondria to recruit participation in the death process [1][2]Constitutively expressed nitric oxide synthase (nNOS) is a Ca2+-dependent cytosolic enzyme that forms nitric oxide (NO) from L-arginine, and NO reacts with the free radical such as superoxide (O2−) to form the very toxic free radical peroxynitrite (ONOO−). Free radicals such as ONOO−, O2 − and hydroxyl radical (OH−) damage cellular membranes and intracellular proteins, enzymes and DNA ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);
				effect_downstreameffect5
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect5,
										dataSource,
										"Measurment/detection",
										"Necrosis:\n\nLDH is a soluble cytoplasmic enzyme that is present in almost all cells and is released into extracellular space when the plasma membrane is damaged. To detect the leakage of LDH into cell culture medium, a tetrazolium salt is used in this assay. In the first step, LDH produces reduced nicotinamide adenine dinucleotide (NADH) when it catalyzes the oxidation of lactate to pyruvate. In the second step, a tetrazolium salt is converted to a colored formazan product using newly synthesized NADH in the presence of an electron acceptor. The amount of formazan product can be colorimetrically quantified by standard spectroscopy. Because of the linearity of the assay, it can be used to enumerate the percentage of necrotic cells in a sample. [5]\n\nThe MTT assay is a colorimetric assay for assessing cell viability. NAD(P)H-dependent cellular oxidoreductase enzymes may reflect the number of viable cells present. These enzymes are capable of reducing the tetrazolium dye MTT 3-(4,5-dimethylthiazol-2-yl)-2,5-diphenyltetrazolium bromide to its insoluble formazan, which has a purple color. Other closely related tetrazolium dyes including XTT, MTS and the WSTs. Tetrazolium dye assays can also be used to measure cytotoxicity (loss of viable cells) or cytostatic activity (shift from proliferation to quiescence) of potential medicinal agents and toxic materials. MTT assays are usually done in the dark since the MTT reagent is sensitive to light [6].\n\nPropidium iodide (PI) is an intercalating agent and a fluorescent molecule used to stain necrotic cells. It is cell membrane impermeant so it stains only those cells where the cell membrane is destroyed. When PI is bound to nucleic acids, the fluorescence excitation maximum is 535 nm and the emission maximum is 617 nm [7] .\n\nApoptosis:\n\nTUNEL is a common method for detecting DNA fragmentation that results from apoptotic signalling cascades. The assay relies on the presence of nicks in the DNA which can be identified by terminal deoxynucleotidyl transferase or TdT, an enzyme that will catalyze the addition of dUTPs that are secondarily labeled with a marker. It may also label cells that have suffered severe DNA damage.\n\nCaspase activity assays measured by fluorescence. During apoptosis, mainly caspase-3 and -7 cleave PARP to yield an 85 kDa and a 25 kDa fragment. PARP cleavage is considered to be one of the classical characteristics of apoptosis. Antibodies to the 85 kDa fragment of cleaved PARP or to caspase-3 both serve as markers for apoptotic cells that can be monitored using immunofluorescence [8].\n\nHoechst 33342 staining: Hoechst dyes are cell-permeable and bind to DNA in live or fixed cells. Therefore, these stains are often called supravital, which means that cells survive a treatment with these compounds. The stained, condensed or fragmented DNA is a marker of apoptosis.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 1);
				effect_downstreameffect5
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect5,
										dataSource,
										"Fujikawa, D.G. (2015), The role of excitotoxic programmed necrosis in acute brain injury, Comput Struct Biotechnol J, vol. 13, pp. 212-221. Malhi, H. et al. (2010), Hepatocyte death: a clear and present danger, Physiol Rev, vol. 90, no. 3, pp. 1165-1194. Kaplowitz, N. (2002), Biochemical and Cellular Mechanisms of Toxic Liver Injury, Semin Liver Dis, vol. 22, no. 2, http://www.medscape.com/viewarticle/433631 (accessed on 20 January 2016). Kroemer, G. et al., (2009), Classification of cell death: recommendations of the Nomenclature Committee on Cell Death, Cell Death Differ, vol. 16, no. 1, pp. 3-11.")
										.<Reference> makeItLive());
				effect_downstreameffect5.getReferenceIDs().add(
						new Reference(effect_downstreameffect5, dataSource, "Malhi, H. et al. (2010), Hepatocyte death: a clear and present danger, Physiol Rev, vol. 90, no. 3, pp. 1165-1194.reference")
								.<Reference> makeItLive());
				effect_downstreameffect5.getReferenceIDs().add(
						new Reference(effect_downstreameffect5, dataSource,
								"Lotersztain, S. et al. (2005), Hepatic fibrosis: molecular mechanisms and drug targets, Annu. Rev. Pharmacol. Toxicol, vol. 45, pp. 605–628.").<Reference> makeItLive());
				
				effect_downstreameffect7 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect7.setTitle("KC activation");
				effect_downstreameffect7.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				effect_downstreameffect7.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				effect_downstreameffect7
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect7,
										dataSource,
										"Definition",
										"Kupffer cells (KCs) are a specialized population of macrophages that reside in the liver; they were first described by Carl Wilhelm von Kupffer (1829–1902). [1] KCs constitute 80%-90% of the tissue macrophages in the reticuloendothelial system and account for approximately 15% of the total liver cell population [2] They play an important role in normal physiology and homeostasis as well as participating in the acute and chronic responses of the liver to toxic compounds. Activation of KCs results in the release of an array of inflammatory mediators, growth factors, and reactive oxygen species. This activation appears to modulate acute hepatocyte injury as well as chronic liver responses including hepatic cancer. Understanding the role KCs play in these diverse responses is key to understanding mechanisms of liver injury.[3] Besides the release of inflammatory mediators including cytokines, chemokines, lysosomal and proteolytic enzymes KCs are a main source of TGF-β1 (transforming growth factor-beta 1, the most potent profibrogenic cytokine). In addition latent TGF-β1 can be activated by KC-secreted matrix metalloproteinase 9 (MMP-9). [4] [5] through the release of biologically active substances that promote the pathogenic process. Activated KCs also release ROS like superoxide generated by NOX (NADPH oxidase), thus contributing to oxidative stress. Oxidative stress also activates a variety of transcription factors like NF-κB, PPAR-γ leading to an increased gene expression for the production of growth factors, inflammatory cytokines and chemokines. KCs express TNF-α (Tumor Necrosis Factor-alpha), IL-1 (Interleukin-1) and MCP-1 (monocyte-chemoattractant protein-1), all being mitogens and chemoattractants for hepatic stellate ceells (HSCs) and induce the expression of PDGF receptors on HSCs which enhances cell proliferation. Expressed TNF-α, TRAIL (TNF-related apoptosis-inducing ligand), and FasL (Fas Ligand) are not only pro-inflammatory active but also capable of inducing death receptor-mediated apoptosis in hepatocytes[6] [7][3] Under conditions of oxidative stress macrophages are further activated which leads to a more enhanced inflammatory response that again further activates KCs though cytokines (Interferon gamma (IFNγ), granulocyte macrophage colony-stimulating factor (GM-CSF), TNF-α), bacterial lipopolysaccharides, extracellular matrix proteins, and other chemical mediators. [8] [9] Besides KCs, the resident hepatic macrophages, infiltrating bone marrow-derived macrophages, originating from circulating monocytes are recruited to the injured liver via chemokine signals. KCs appear essential for sensing tissue injury and initiating inflammatory responses, while infiltrating Ly-6C+ monocyte-derived macrophages are linked to chronic inflammation and fibrogenesis. The profibrotic functions of KCs (HSC activation via paracrine mechanisms) during chronic hepatic injury remain functionally relevant, even if the infiltration of additional inflammatory monocytes is blocked via pharmacological inhibition of the chemokine CCL2 [10] [11] KC activation and macrophage recruitment are two separate events and both are necessary for fibrogenesis, but as they occur in parallel, they can be summarised as one KE. Probably there is a threshold of KC activation and release above which liver damage is induced. Pre-treatment with gadolinium chloride (GdCl), which inhibits KC function, reduced both hepatocyte and sinusoidal epithelial cell injury, as well as decreased the numbers of macrophages appearing in hepatic lesions and inhibited TGF-β1 mRNA expression in macrophages. Experimental inhibition of KC function or depletion of KCs appeared to protect against chemical-induced liver injury.[")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);
				effect_downstreameffect7
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect7,
										dataSource,
										"Measurment/detection",
										"Kupffer cell activation can be measured by means of expressed cytokines, e.g. tissue levels of TNF-a [13], IL-6 expression, measured by immunoassays or Elisa (offered by various companies), soluble CD163 [14] [15] or increase in expression of Kupffer cell marker genes such as Lyz, Gzmb, and Il1b, (Genome U34A Array, Affymetrix);")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 1);
				
				effect_downstreameffect9 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect9.setTitle("TGF-b1 expression ");
				effect_downstreameffect9.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				effect_downstreameffect9.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				effect_downstreameffect9
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect9,
										dataSource,
										"Definition",
										"The transforming growth factor beta (TGF-β) family of cytokines are ubiquitous, multifunctional, and essential to survival. They play important roles in growth and development, inflammation and repair, and host immunity. The mammalian TGF-β isoforms (TGF-β1, β2 and β3) are secreted as latent precursors and have multiple cell surface receptors of which at least two mediate signal transduction. Autocrine and paracrine effects of TGF-βs can be modified by extracellular matrix, neighbouring cells and other cytokines. The vital role of the TGF-β family is illustrated by the fact that approximately 50% of TGF-1 gene knockout mice die in utero and the remainder succumb to uncontrolled inflammation after birth. The role of TGF-β in homeostatic and pathogenic processes suggests numerous applications in the diagnosis and treatment of various diseases characterised by inflammation and fibrosis. [1] [2] [3] Abnormal TGF-β regulation and function are implicated in a growing number of fibrotic and inflammatory pathologies, including pulmonary fibrosis, liver cirrhosis, glomerulonephritis and diabetic nephropathy, congestive heart failure, rheumatoid arthritis, Marfan syndrome, hypertrophic scars, systemic sclerosis, myocarditis, and Crohn’s disease. [4] TGF-β1 is a polypeptide member of the TGF-β superfamily of cytokines. TGF-β is synthesized as a non-active pro-form, forms a complex with two latent associated proteins latency-associated protein (LAP) and latent TGF- β binding protein (LTBP) and undergoes protolithic cleavage by the endopeptidase furin to generate the mature TGF-β dimer. Among the TGF-βs, six distinct isoforms have been discovered although only the TGF-β1, TGF-β2 and TGF-β3 isoforms are expressed in mammals, and their human genes are located on chromosomes 19q13, 1q41 and 14q24, respectively. Out of the three TGF-β isoforms (β1, β2 and β3) only TGF-β1 was linked to fibrogenesis and is the most potent fibrogenic factor for hepatic stellate cells. [5][6]. During fibrogenesis, tissue and blood levels of active TGF-β are elevated and overexpression of TGF-β1 in transgenic mice can induce fibrosis. Additionally, experimental fibrosis can be inhibited by anti-TGF-β treatments with neutralizing antibodies or soluble TGF-β receptors [7][8][9][10] TGF-β1 induces its own mRNA to sustain high levels in local sites of injury.The effects of TGF-β1 are classically mediated by intracellular signalling via Smad proteins. Smads 2 and 3 are stimulatory whereas Smad 7 is inhibitory. [11][12][13] Smad1/5/8, MAP kinase (mitogen-activated protein) and PI3 kinase are further signalling pathways in different cell types for TGF-β1 effects.\n\nTGF-β is found in all tissues, but is particularly abundant in bone, lung, kidney and placental tissue. TGF-β is produced by many, but not all parenchymal cell types, and is also produced or released by infiltrating cells such as lymphocytes, monocytes/macrophages, and platelets. Following wounding or inflammation, all these cells are potential sources of TGF-β. In general, the release and activation of TGF-β stimulates the production of various extracellular matrix proteins and inhibits the degradation of these matrix proteins. [14]\n\nTGF-β 1 is produced by every leukocyte lineage, including lymphocytes, macrophages, and dendritic cells, and its expression serves in both autocrine and paracrine modes to control the differentiation, proliferation, and state of activation of these immune cells. [15]\n\nIn the liver TGF-β1 is released by activated Kupffer cells, liver sinusoidal endothelial cells, and platelets; in the further course of events also activated hepatic stellate cells express TGF-β1. Hepatocytes do not produce TGF-β1 but are implicated in intracellular activation of latent TGF-β1.[16][17][18][19][20]\n\nTGF-β1 is the most established mediator and regulator of epithelial-mesenchymal-transition (EMT) which further contributes to the production of extracellular matrix. It has been shown that TGF-β1 mediates EMT by inducing snail-1 transcription factor and tyrosine phosphorylation of Smad2/3 with subsequent recruitment of Smad4. [21][22][23][24][25][26] [27][28][29] [18] [19] [11] [12][20]\n\nTGF-β1 induces apoptosis and angiogenesis in vitro and in vivo through the activation of vascular endothelial growth factor (VEGF) High levels of VEGF and TGF-β1 are present in many tumors. Crosstalk between the signalling pathways activated by these growth factors controls endothelial cell apoptosis and angiogenesis.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);
				effect_downstreameffect9
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect9,
										dataSource,
										"Measurment/detection",
										"There are several assays for TGB-β1 measurement available.\n\ne.g. Human TGF-β1 ELISA Kit. The Human TGF-β 1 ELISA (Enzyme –Linked Immunosorbent Assay) kit is an in vitro enzyme-linked immunosorbent assay for the quantitative measurement of human TGF-β1 in serum, plasma, cell culture supernatants, and urine. This assay employs an antibody specific for human TGF-β1 coated on a 96-well plate. Standards and samples are pipetted into the wells and TGF-β1 present in a sample is bound to the wells by the immobilized antibody. The wells are washed and biotinylated anti-human TGF-β1 antibody is added. After washing away unbound biotinylated antibody, HRP- conjugated streptavidin is pipetted to the wells. The wells are again washed, a TMB substrate solution is added to the wells and colour develops in proportion to the amount of TGF-β1 bound. The StopSolution changes the colour from blue to yellow, and the intensity of the colour is measured at 450 nm [30] ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 1);
				effect_downstreameffect9.getReferenceIDs().add(
						new Reference(effect_downstreameffect9, dataSource,
								"Mazzieri, R .et al. (2000), Measurements of Active TGF-β Generated by Culture Cells, Methods in Molecular Biology, vol. 142, pp. 13-27, DOI: 10.1385/1-59259-053-5:13.")
								.<Reference> makeItLive());
				
				effect_downstreameffect11 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect11.setTitle("HSC activation");
				effect_downstreameffect11.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				effect_downstreameffect11.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				effect_downstreameffect11
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect11,
										dataSource,
										"Definition",
										"Stellate cell activation means a transdifferentiation from a quiescent vitamin A–storing cell to a proliferative and contractile myofibroblast. Multiple cells and cytokines play a part in the regulation of hepatic stellate cell (HSC) activation that consists of discrete phenotype responses, mainly proliferation, contractility, fibrogenesis, matrix degradation, chemotaxis, and retinoid loss.\n\nHSCs undergo activation through a two-phase process. The first step, the initiation phase, is triggered by injured hepatocytes, reactive oxygen speecies (ROS) and paracrine stimulation from neighbouring cell types (Kupffer cells (KCs), Liver sinusoidal endothelial cells (LSECs), and platelets) and make HSCs sensitized to activation by up-regulating various receptors. The perpetuation phase refers to the maintenance of HSC activation, which is a dynamic process including the secretion of autocrine and paracrine growth factors (such as TGF-β1), chemokines, and the up-regulation of collagen synthesis (mainly type I collagen). In response to growth factors (including Platelet-derived Growth Factor (PDGF) and Vascular Endothelial Growth Factor (VEGF)) HSCs proliferate. Increased contractility (Endothelin-1 and NO are the key opposing counter-regulators that control HSC contractility, in addition to angiotensinogen II, and others) leads to increased portal resistance. Driven by chemoattractants their accumulation in areas of injury is enhanced. TGF-β1 synthesis promotes activation of neighbouring quiescent hepatic stellate cells, whereas the release of HGF (hepatocyte growth factor) stimulates regeneration of adjacent hepatocytes. The release of chemoattractants (monocyte chemoattractant protein-1(MCP-1) and colony-stimulating factors (CSFs)) amplifies inflammation. [1][2][3][4][5][6][7] Activated HSCs (myofibroblasts) are the primary collagen producing cell, the key cellular mediators of fibrosis and a nexus for converging inflammatory pathways leading to fibrosis. Experimental inhibition of stellate cell activation prevents fibrosis.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);
				effect_downstreameffect11
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect11,
										dataSource,
										"Measurment/detection",
										"Alpha-smooth muscle actin (α-SMA) is a well-known marker of hepatic stellate cells activation. Anti-alpha smooth muscle Actin [1A4] monoclonal antibody reacts with the alpha smooth muscle isoform of actin.\n\nGene expression profiling confirmed early changes for known genes related to HSC activation such as alpha smooth muscle actin (Acta2), lysyl oxidase (Lox) and collagen, type I, alpha 1 (Col1a1). Insulin-like growth factor binding protein 3 (Igfbp3) was identified as a gene strongly affected and as marker for culture-activated HSCs and plays a role in HSC migration.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 1);
				effect_downstreameffect11.getReferenceIDs().add(
						new Reference(effect_downstreameffect11, dataSource, "Lee, U.E. and S.L. Friedman (2011), Mechanisms of Hepatic Fibrogenesis, Best Pract Res Clin Gastroenterol, vol. 25, no. 2, pp. 195-206.")
								.<Reference> makeItLive());
				effect_downstreameffect11.getReferenceIDs().add(
						new Reference(effect_downstreameffect11, dataSource, " Friedman, S.L (2010), Evolving challenges in hepatic fibrosis, Nat. Rev. Gastroenterol. Hepatol, vol. 7, no. 8, pp. 425–436.")
								.<Reference> makeItLive());
				effect_downstreameffect11.getReferenceIDs().add(new Reference(effect_downstreameffect11, dataSource, "Type your APA formatted reference").<Reference> makeItLive());
				effect_downstreameffect11.getReferenceIDs().add(
						new Reference(effect_downstreameffect11, dataSource, " Friedman, S.L. (2008), Mechanisms of Hepatic Fibrogenesis, Gastroenterology, vol. 134, no. 6, pp. 1655–1669.").<Reference> makeItLive());
				
				effect_downstreameffect13 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect13.setTitle("Collagen Accumulation ");
				effect_downstreameffect13.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
				effect_downstreameffect13.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				effect_downstreameffect13
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect13,
										dataSource,
										"Definition",
										"Collagen is mostly found in fibrous tissues such as tendons, ligaments and skin. It is also abundant in corneas, cartilage, bones, blood vessels, the gut, intervertebral discs, and the dentin in teeth. In muscle tissue, it serves as a major component of the endomysium. Collagen is the main structural protein in the extracellular space in the various connective tissues, making up from 25% to 35% of the whole-body protein content. In normal tissues, collagen provides strength, integrity, and structure. When tissues are disrupted following injury, collagen is needed to repair the defect. If too much collagen is deposited, normal anatomical structure is lost, function is compromised, and fibrosis results.\n\nThe fibroblast is the most common collagen producing cell.Collagen-producing cells may also arise from the process of transition of differentiated epithelial cells into mesenchymal cells (EMT). This has been observed e.g. during renal fibrosis (transformation of tubular epithelial cells into fibroblasts) and in liver injury (transdifferentiation of hepatocytes and cholangiocytes into fibroblasts). [1]\n\nThere are close to 20 different types of collagen found with the predominant form being type I collagen. This fibrillar form of collagen represents over 90 percent of our total collagen and is composed of three very long protein chains which are wrapped around each other to form a triple helical structure called a collagen monomer. Collagen is produced initially as a larger precursor molecule called procollagen. As the procollagen is secreted from the cell, procollagen proteinases remove the extension peptides from the ends of the molecule. The processed molecule is referred to as collagen and is involved in fiber formation. In the extracellular spaces the triple helical collagen molecules line up and begin to form fibrils and then fibers. Formation of stable crosslinks within and between the molecules is promoted by the enzyme lysyl oxidase and gives the collagen fibers tremendous strength. [2] The overall amount of collagen deposited by fibroblasts is a regulated balance between collagen synthesis and collagen catabolism. Disturbance of this balance leads to changes in the amount and composition of collagen. Changes in the composition of the extracellular matrix initiate positive feedback pathways that increase collagen production.\n\nNormally, collagen in connective tissues has a slow turn over; degradating enzymes are collagenases, belonging to the family of matrix metalloproteinases (MMPs).Other cells that can synthesize and release collagenase are macrophages, neutrophils, osteoclasts, and tumor cells. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);
				effect_downstreameffect13
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect13,
										dataSource,
										"Measurment/detection",
										"Determination of the amount of collagen produced in vitro can be done in a variety of ways ranging from simple colorimetric assays to elaborate chromatographic procedures using radioactive and non-radioactive material. What most of these procedures have in common is the need to destroy the cell layer to obtain solubilized collagen from the pericellular matrix. Rishikof et al describe several methods to assess the in vitro production of type I collagen: Western immunoblotting of intact alpha1(I) collagen using antibodies directed to alpha1(I) collagen amino and carboxyl propeptides, the measurement of alpha1(I) collagen mRNA levels using real-time polymerase chain reaction, and methods to determine the transcriptional regulation of alpha1(I) collagen using a nuclear run-on assay.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 1);
				
				effect_adverseoutcome15 = new Effect_AdverseOutcome(pathway, dataSource);
				effect_adverseoutcome15.setTitle("Liver fibrosis");
				effect_adverseoutcome15.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				effect_adverseoutcome15.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE.DIMENSION_INDEX, "adult");
				effect_adverseoutcome15.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				effect_adverseoutcome15.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_TIME_TO_EFFECT.DIMENSION_INDEX, "0.0");
				effect_adverseoutcome15
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_adverseoutcome15,
										dataSource,
										"Definition",
										"Liver fibrosis results from perpetuation of the normal wound healing response, as a result of repeated cycles of hepatocyte injury and repair and is a dynamic process, characterised by an excessive deposition of ECM (extracellular matrix) proteins including glycoproteins, collagens, and proteoglycans. It is usually secondary to hepatic injury and inflammation, and progresses at different rates depending on the aetiology of liver disease and is also influenced by environmental and genetic factors. If fibrosis continues, it disrupts the normal architecture of the liver, altering the normal function of the organ and ultimately leading to liver damage. Cirrhosis represents the final stage of fibrosis. It is characterised by fibrous septa which divide the parenchyma into regenerative nodules which leads to vascular modifications and portal hypertension with its complications of variceal bleeding, hepatic encephalopathy, ascites, and hepatorenal syndrome. In addition, this condition is largely associated with hepatocellular carcinoma with a further increase in the relative mortality rate. [1] [2]\n\nLiver fibrosis is an important health issue with clear regulatory relevance. The burden of disease attributable to liver fibrosis is quite high; progressive hepatic fibrosis, ultimately leading to cirrhosis, is a significant contributor to global health burden. [3] In the European Union, 0.1 % of the population is affected by cirrhosis, the most advanced stage of liver fibrosis with full architectural disturbances. [4] Besides the epidemiological relevance, liver fibrosis also imposes a considerable economic burden on society. Indeed, the only curative therapy for chronic liver failure is liver transplantation. More than 5.500 orthotopic liver transplantations are currently performed in Europe on a yearly basis, costing up to €100.000 the first year and €10.000 yearly thereafter")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);
				effect_adverseoutcome15.getDescriptionIDs().set(
						new DescriptionSection(effect_adverseoutcome15, dataSource, "Measurment/detection", "").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 1);
				
				test_exvivo18 = new Test_ExVivo(pathway, dataSource);
				test_exvivo18.setTitle("Ex-vivo Test Method Title");
				test_exvivo18.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				test_exvivo18.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				link_chemstructtomie2 = new Link_ChemStructToMIE(pathway, dataSource, initiator_chemicalstructure1, effect_molecularinitiatingevent3);
				link_chemstructtomie2.setLinkType(LinkType.UNKNOWN);
				
				link_effecttoeffect4 = new Link_EffectToEffect(pathway, dataSource, effect_molecularinitiatingevent3, effect_downstreameffect5);
				link_effecttoeffect4.setLinkType(LinkType.DIRECT);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect4_weigth0 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect4, dataSource, Link_EffectToEffect.class, 2.0);
				link_effecttoeffect4
						.getDescriptionIDs()
						.set(
								new DescriptionSection_Structured(
										link_effecttoeffect4,
										dataSource,
										"(Key) Event Relationships Weight of Evidences",
										"• Biological Plausibility: \n\nCell injury caused by covalent binding is biologically plausible. The mechanistic relationship between MIE and KE 1 consistent with established biological knowledge.\n\n• Empirical Support for Linkage:\n\nEven though protein alkylation is a generic process having an impact on multiple physiological processes in the cell, certain connections related to which alkylated proteins lead and/or contribute to cell injury have been described with high biological plausibility. Better understanding of the effects of alkylating agents at the molecular level is aided by recent application of new toxicogenomics technologies. [12] However, further efforts are certainly needed. Here we list literature-based evidence on how protein alkylation induced by allyl alcohol and carbon tetrachloride (CCl4) could be leading to cell injury (apoptosis/necrosis).\n\nAllyl alcohol/Acrolein-induced apoptosis of human cells is associated with depletion of cellular GSH and intracellular generation of oxidants [13], achieved by alkylation of various proteins involved in the process.[14][15] More specifically, allyl alcohol/acrolein is considered a mitochondrial toxin that leads to cell death.[16] Whether apoptosis or necrosis ensues after acrolein exposure appears to be related to dose and cell type. In regards to activation of caspases as part of the mitochondrial death pathway it was shown that apoptosis could be both caspase-dependent: in human neuroblastoma cells [17] and in A549 lung cells [18], as well as caspase-independent: in CHO cells. [19] It was suggested that the activation of certain caspases may arise from a partial inhibition of their active site cysteine residue through direct alkylation by acrolein.[20]\n\nFurthermore, using biotin hydrazide labeling, it was shown that NF-κB RelA and p50, as well as JNK2, were revealed as direct targets for alkylation by acrolein, affecting the GSH depletion. Mass spectrometry analysis of acrolein-modified recombinant JNK2 indicated adduction to Cys(41) and Cys(177), putative important sites involved in mitogen-activated protein kinase (MAPK) kinase (MEK) binding and JNK2 phosphorylation.[21] In complimentary work, exposure of cultured hepatocytes to acrolein led to a sustained activation of ERK1/2, JNK, and p38, which was associated with ER and mitochondrial stress and apoptosis. The cytotoxic effects of acrolein were decreased by JNK inhibitor, suggesting that kinase activation may be linked to cell death and liver injury. [22]\n\nSchwend et al. (2008) tried to identify new proteins that undergo alkylation by acrylamide by treating three human cell lines (Jurkat, Caco-2 and HepG2 cells) with acrylamide and analyzing extracted proteins by MALDI-TOF for potentially alkylated candidates. They could identify two novel acrylamide target proteins that may contribute to the toxicity of acrylamide in cell cultures. Acrylamide showed dose-dependent cytotoxic effects in all three tested cultures (IC50 2-4 mM for the three cell lines). Protein alkylation could be observed already at lower, sub-cytotoxic doses (10uM). Their data confirmed that acrylamide causes cytotoxicity effects in cell cultures and this cytotoxicity is most likely mediated by protein alkylation. [23]\n\nThompson and Burcham (2008) studied the impact of culture media composition on the extent of damage occurring at protein targets within acrolein-exposed cells (A549 cells), and saw that acrolein induced concentration- dependent damage to cell proteins and increased cytochrome c release as marker of apoptotic cell death. [7]\n\nCai et al. (2005) investigated the mitochondria-initiated apoptosis pathway involved in CCl4 hepatotoxicity in vitro and observed a time-and dose-dependent decrease in cellular glutathione content, along with a concomitant increase in malondialdehyde levels following the application of CCl4. Caspase 3 activity was stimulated at all doses of CCl4, with the most significant activation at 3 mmol/L. Cytochrome c was released obviously after CCl4 treatment. A time-dependent decrease in Bcl-XL expression was observed. DNA fragmentation results revealed apoptosis and necrosis following CCl4 treatment. They concluded that oxidative damage is one of the essential mechanisms of CCl4 hepatotoxicity, which triggers apoptosis via the mitochondria-initiated pathway.[24]\n\nPerrissoud et al. (1980) investigated the effect of CCl4 on isolated rat hepatocytes. The ultrastructural alterations and release of lactate dehydrogenase (LDH) and glutamate-oxaloacetate transaminase (GOT), were recorded after different periods of incubation. After 5 min incubation with CC14, morphological changes observed by electron microscopy, involved the plasma membrane. The endoplasmic reticulum and mitochondria were altered later. These morphological alterations were accompanied by an early release of LDH and GOT into the incubation medium.[25] .\n\nJohnston and Kroening (1998) investigated mechanisms of early carbon tetrachloride toxicity in cultured rat hepatocytes and found that primary rat hepatocytes in culture were killed after a 2 hr incubation with CCl4 gas at partial pressures above a threshold between 45 and 54 mmHg. They concluded that early hepatocyte death in cell culture is independent of metabolism of CCl4, and may be related to direct effects of CCl4 on intracellular membranes.[26]\n\nBoll et al. (2001) modelled CCl4-induced liver damage in monolayer cultures of rat primary hepatocytes with a focus on involvement of covalent binding of CC14 metabolites to cell components and/ or peroxidative damage as the cause of injury. They observed that covalent binding of 1 4 C-labelled metabolites was detected in hepatocytes immediately after exposure to CC14. Electrophoresis of microsomal proteins from [14C]-CCl4-treated hepatocytes revealed that, aside of the start and the front of the gel, radioactive label was found primarily between 70 and 80 kDa.[2][27]\n\nIn a study performed on isolated hepatocytes it was demonstrated that direct alkylation of critical sulfhydryl groups in proteins leads to a sustained increase in free Ca++ concentrations which, via Ca++ - dependent protease activates the enzyme xantine oxidase. This activation generates a substantial amount of superoxide anion free radical and other ROS that oxidize other protein sulfhydryl groups. Thiol depletion in the cytoplasm is primarily linked to the alkylation by the reactive metabolite acrolein.[28]\n\nBoot (1996) described toxicological data of organic mercury compounds (alkylating agents) in rat hepatocytes, primary human hepatocytes, and in situ perfused total rat livers. Significant effects like induction of glutathione depletion, inhibition of cellular glucose and amino acid uptake with blocked albumin synthesis were observed in almost all tested physiological parameters. [29]\n\nCodreanu et al. (2014) intended to profile the accumulation of proteome damage in human cells (RKO and THP-1 cells) treated with lipid electrophile probes. Damage occurred selectively across functional protein interaction networks, with the most highly alkylation- susceptible proteins mapping to networks involved in cytoskeletal regulation. [10] \n\n• Uncertainties or Inconsistencies:\n\nThough covalent protein alkylation by reactive electrophiles was identified as a key triggering event in chemical toxicity already over 40 years ago and despite the intense effort expended over the past few years, our understanding of the mechanism and consequences of protein modification by reactive intermediates – both oxidizing and alkylating agents - is still quite limited. Covalent protein alkylation is a feature of many hepatotoxic drugs and the overall extent of binding does not adequately distinguish toxic from non-toxic binding. Directly relating covalent binding to hepatotoxicity is likely an oversimplification of the process whereby adduct formation ultimately leads to toxicity. Understanding underlying complexities (e.g., which macromolecules are important covalent binding targets) will be essential to any understanding of the problem of metabolism-dependent hepatotoxicity and predicting toxicity from in vitro experiments. [30][31] Data from Codreanu et al. suggest that non-toxic covalent binding may largely be survivable damage to cytoskeletal components and other highly reactive protein targets, whereas toxic covalent binding produces lethal injury by targeting protein synthesis and catabolism and possibly mitochondrial electron transport. Future studies with appropriate probe molecules for toxic and non-toxic drugs could test these hypotheses and provide a better mechanistic basis for interpreting protein alkylation in drugsafety evaluation [10]\n\nFor this AOP it is not known whether protein alkylation to certain proteins is required and whether particular proteins and various binding sites influence the further downstream process. Further we do not know whether there is a threshold and if this threshold would refer to the number of alkylation of a single protein or of a threshold number of protein\n\nCell injury caused by covalent binding is biologically plausible. The mechanistic relationship between MIE and KE 1 consistent with established biological knowledge.",
										link_effecttoeffect4_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 0);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect4_weigth1 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect4, dataSource, Link_EffectToEffect.class, 0.0);
				link_effecttoeffect4.getDescriptionIDs().set(
						new DescriptionSection_Structured(link_effecttoeffect4, dataSource, "(Key) Event Relationship Weight of Evidence",
								"• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect4_weigth1).setFormat(ContentFormat.TEXT)
								.<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect4.getDescriptionIDs().set(
						new DescriptionSection(link_effecttoeffect4, dataSource, "Evidence Supporting Taxonomic Applicability", "human,  rat").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 2);
				link_effecttoeffect4.getDescriptionIDs()
						.set(
								new DescriptionSection(link_effecttoeffect4, dataSource, "Quantitative Understading", "Quantitative data are hardly available. ").setFormat(ContentFormat.TEXT)
										.<DescriptionSection> makeItLive(), 3);
				
				link_effecttoeffect6 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect5, effect_downstreameffect7);
				link_effecttoeffect6.setLinkType(LinkType.DIRECT);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect6_weigth0 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect6, dataSource, Link_EffectToEffect.class, 2.0);
				link_effecttoeffect6
						.getDescriptionIDs()
						.set(
								new DescriptionSection_Structured(
										link_effecttoeffect6,
										dataSource,
										"(Key) Event Relationships Weight of Evidences",
										"• Biological Plausibility: \n\nThere is a functional relationship between cell injury/death and KC activation, consistent with established biological knowledge. \n\n• Empirical Support for Linkage:\n\nThere is convincing theoretical evidence that hepatocyte injury and apoptosis causes KC activation, as well as inflammation and oxidative stress. But there are only limited experimental studies which could show that there is a direct relationship between these two events with temporal concordance. Specific markers for activated KCs have not been identified yet. KC activation cannot be detected morphologically by staining techniques since cell morphology does not change, but cytokines release can be measured (with the caveat that KCs activate spontaneously in vitro) and used as marker for KC activation.[12][13] Tukov et al. examined the effects of KCs cultured in contact with rat hepatocytes. They found that by adding KCs to the cultures they could mimic in vivo drug-induced inflammatory responses. Experiments on cells of the macrophage lineage showed significant aldehyde-induced stimulation of the activity of protein kinase C, an enzyme involved in several signal transduction pathways. Further, 4-Hydroxynonenal (HNE) was demonstrated to up-regulate TGF-β1 expression and synthesis in isolated rat KCs.[14] Canbay et al could prove that engulfment of hepatocyte apoptotic bodies stimulated KC generation of cytokines\n\n• Uncertainties or Inconsistencies:\n\nThe detailed mechanisms of the KC - hepatocyte interaction and its consequences for both normal and toxicant-driven liver responses remain to be determined. KC activation followed by cytokine release is associated in some cases with evident liver damage, whereas in others this event is unrelated to liver damage or may be even protective; apparently this impact is dependent on the quantity of KC activation; excessive or prolonged release of KC mediators can switch an initially protective mechanism to a damaging inflammatory response. Evidence suggests that low levels of cytokine release from KCs constitute a survival signal that protects hepatocytes from cell death and in some cases, stimulates proliferation. [\n\n",
										link_effecttoeffect6_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 0);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect6_weigth1 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect6, dataSource, Link_EffectToEffect.class, 0.0);
				link_effecttoeffect6.getDescriptionIDs().set(
						new DescriptionSection_Structured(link_effecttoeffect6, dataSource, "(Key) Event Relationship Weight of Evidence",
								"• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect6_weigth1).setFormat(ContentFormat.TEXT)
								.<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect6.getDescriptionIDs().set(
						new DescriptionSection(link_effecttoeffect6, dataSource, "Evidence Supporting Taxonomic Applicability", "Human:  Rat: ").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 2);
				link_effecttoeffect6.getDescriptionIDs().set(
						new DescriptionSection(link_effecttoeffect6, dataSource, "Quantitative Understading", "no quantitative data ").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 3);
				
				link_effecttoeffect8 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect7, effect_downstreameffect9);
				link_effecttoeffect8.setLinkType(LinkType.DIRECT);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect8_weigth0 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect8, dataSource, Link_EffectToEffect.class, 2.0);
				link_effecttoeffect8
						.getDescriptionIDs()
						.set(
								new DescriptionSection_Structured(
										link_effecttoeffect8,
										dataSource,
										"(Key) Event Relationships Weight of Evidences",
										"• Biological Plausibility: \n\nThe functional relationship between these KEs is consistent with biological knowledge.\n\n• Empirical Support for Linkage:\n\nCytokine release is one of the features that define KC activation and there is sound empirical evidence for this KER. Experimental studies have shown enhanced cytokine gene expression by KCs in evolution of experimental liver injury. Northern blot analysis of freshly isolated KCs showed enhanced mRNA expression of three acute phase cytokines by the hepatic resident macrophages, TNF-α, IL-6 and TGF-β.[1]\n\n[11][12]Experiments by Matsuoka and Tsukamoto already 1990 showed that KCs isolated from rat liver with alcoholic fibrosis express and release TGF-β1 and that this cytokine is largely responsible for the KC-conditioned medium-induced stimulation of collagen formation by HSCs.\n\n• Uncertainties or Inconsistencies:\n\nthere are no inconsistencies \n\n",
										link_effecttoeffect8_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 0);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect8_weigth1 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect8, dataSource, Link_EffectToEffect.class, 0.0);
				link_effecttoeffect8.getDescriptionIDs().set(
						new DescriptionSection_Structured(link_effecttoeffect8, dataSource, "(Key) Event Relationship Weight of Evidence",
								"• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect8_weigth1).setFormat(ContentFormat.TEXT)
								.<DescriptionSection_Structured> makeItLive(), 1);
				
				link_effecttoeffect10 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect9, effect_downstreameffect11);
				link_effecttoeffect10.setLinkType(LinkType.DIRECT);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect10_weigth0 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect10, dataSource, Link_EffectToEffect.class, 2.0);
				link_effecttoeffect10
						.getDescriptionIDs()
						.set(
								new DescriptionSection_Structured(
										link_effecttoeffect10,
										dataSource,
										"(Key) Event Relationships Weight of Evidences",
										"• Biological Plausibility: \n\nThere is good understanding and broad acceptance of this KER\n\n• Empirical Support for Linkage:\n\nIt is difficult to get experimental evidence in vitro for TGF-β1-induced HSC activation because HSCs undergo spontaneous activation when cultured on plastic; nevertheless qualitative empirical evidence for temporal and incidence concordance for this KER exists. Czaja et al could prove that treatment of cultured hepatic cells with TGF-β1 increased type I pro-collagen mRNA levels 13-fold due to post-transcriptional gene regulation. Tan et al. discovered that short TGF-β1 pulses can exert long-lasting effects on fibroblasts. HSCs activated in culture do not fully reproduce the changes in gene expression observed in vivo. De Minicis et al investigated gene expression changes in 3 different models of HSC activation and compared gene expression profiles in culture (mice HSCs in co-culture with KCs) and in vivo and did not find a proper correlation. [\n\n• Uncertainties or Inconsistencies:\n\nThere are no uncertainties that TGF-b1 activates HSCs. \n\n",
										link_effecttoeffect10_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 0);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect10_weigth1 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect10, dataSource, Link_EffectToEffect.class, 0.0);
				link_effecttoeffect10.getDescriptionIDs().set(
						new DescriptionSection_Structured(link_effecttoeffect10, dataSource, "(Key) Event Relationship Weight of Evidence",
								"• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect10_weigth1).setFormat(ContentFormat.TEXT)
								.<DescriptionSection_Structured> makeItLive(), 1);
				
				link_effecttoeffect12 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect11, effect_downstreameffect13);
				link_effecttoeffect12.setLinkType(LinkType.DIRECT);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect12_weigth0 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect12, dataSource, Link_EffectToEffect.class, 2.0);
				link_effecttoeffect12
						.getDescriptionIDs()
						.set(
								new DescriptionSection_Structured(
										link_effecttoeffect12,
										dataSource,
										"(Key) Event Relationships Weight of Evidences",
										"• Biological Plausibility: \n\nhere is general acceptance that HSCs are collagen producing cells and key actors in fibrogenesis. The functional relationship between these KEs is consistent with biological knowledge\n\n• Empirical Support for Linkage:\n\nt is difficult to stimulate sufficient collagen production and its subsequent incorporation into a pericellular matrix in vitro; therefore analytical methods have focused on measurement of pro-collagen secreted into culture medium or measurement of α-smooth muscle actin (α-SMA) expression, a marker of fibroblast activation. In primary culture, HSCs from normal liver begin to express α-SMA coincident with culture-induced activation.\n\n• Uncertainties or Inconsistencies:\n\nno inconsistencies \n\n",
										link_effecttoeffect12_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 0);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect12_weigth1 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect12, dataSource, Link_EffectToEffect.class, 0.0);
				link_effecttoeffect12.getDescriptionIDs().set(
						new DescriptionSection_Structured(link_effecttoeffect12, dataSource, "(Key) Event Relationship Weight of Evidence",
								"• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect12_weigth1).setFormat(ContentFormat.TEXT)
								.<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect12.getDescriptionIDs().set(
						new DescriptionSection(link_effecttoeffect12, dataSource, "Quantitative Understading", "no quantitative data ").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 3);
				
				link_effecttoeffect14 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect13, effect_adverseoutcome15);
				link_effecttoeffect14.setLinkType(LinkType.DIRECT);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect14_weigth1 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect14, dataSource, Link_EffectToEffect.class, 0.0);
				link_effecttoeffect14.getDescriptionIDs().set(
						new DescriptionSection_Structured(link_effecttoeffect14, dataSource, "(Key) Event Relationship Weight of Evidence",
								"• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect14_weigth1).setFormat(ContentFormat.TEXT)
								.<DescriptionSection_Structured> makeItLive(), 1);
				
				testresponsemapping17 = new TestResponseMapping(pathway, dataSource, test_exvivo18, effect_downstreameffect5);
				pathway
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										pathway,
										dataSource,
										"Abstract",
										"Hepatotoxicity in general is of special interest for human health risk assessment. Liver fibrosis in particular is an important human health issue associated with chemical exposure and predictive assays are lacking; it is a typical result of chronic or repeated-dose toxic injury and one of the considered endpoints for regulatory purposes. It is a long-term process in which inflammation, tissue destruction, and repair occur simultaneously, together with sustained production of growth factors and fibrogenic cytokines due to a complex interplay between various hepatic cell types, various receptors and signalling pathways which lead to an imbalance between the deposition and degradation of extracellular matrix (ECM) and a change of ECM composition. Due to this complex situation an adequate cell model is not available and an in vitro evaluation of fibrogenic potential is therefore not feasible. A sufficiently detailed description of the AOP to liver fibrosis might support chemical risk assessment by indicating early (upstream) markers for downstream events and facilitate a testing strategy without the need for a sophisticated cell model. This systematic and coherent display of currently available mechanistic-toxicological information can serve as a knowledge-based repository for identification/selection/development of in vitro methods suitable for measuring key events (KEs) and their relationships along the AOP and to facilitate the use of alternative data for regulatory purposes. Identified uncertainties and knowledge gaps can direct future research by priority setting and targeted testing. The KE descriptions can be used for hazard identification and read-across to assess the toxic potential of an untested substance. This AOP describes the linkage between hepatic injury caused by protein alkylation and the formation of liver fibrosis. The molecular initiating event (MIE) is protein alkylation, leading to structural and functional cell injury and further to cell death, the first KE. Apoptotic hepatocytes undergo genomic DNA fragmentation and formation of apoptotic bodies. Upon engulfment of apoptotic bodies Kupffer cells (KCs) are activated, the next KE along the pathway. Activated KCs are the main source of TGF-β1, the most potent profibrogenic cytokine. TGF-β1 expression therefore is considered a KE that causes the next KE, hepatic stellate cell (HSCs) activation, meaning the transdifferentiation from a quiescent vitamin A–storing cell to a proliferative and contractile myofibroblast, the central effector in hepatic fibrosis. Activated HSCs cause progressive collagen accumulation, which together with changes in ECM composition signifies the KE on tissue level. The excessive accumulation of extracellular matrix proteins progressively affects the whole organ and alters its normal functioning, which corresponds to liver fibrosis, the adverse outcome (AO). There are two further events that play an important role in driving fibrogenesis, namely oxidative stress and chronic inflammation. Both are on-going processes being present throughout the pathway and interconnected with most of the KEs. Hence, they are not classified as KEs themselves and described in the individual KE and key event relationship (KER) descriptions. The inflammatory response plays an important role in driving fibrogenesis, since persistent inflammation precedes fibrosis. Inflammatory signalling stems from injured hepatocytes, activated KCs and HSCs. Inflammatory and fibrogenic cells stimulate each other in amplifying fibrosis. Chemokines and their receptors provoke further fibrogenesis, as well as interacting with inflammatory cells to modify the immune response during injury. Oxidative stress, as well, plays a crucial role in liver fibrogenesis by inducing hepatocyte apoptosis, activation of KCs and HSCs and fuelling inflammation. ROS contributing to oxidative stress are generated by hepatocytes, KCs, HSCs and inflammatory cells. This purely qualitative AOP description is plausible, the scientific data supporting the AOP are logic, coherent and consistent and there is temporal agreement between the individual KEs. Quantitative data on dose-response-relationships and temporal sequences between KEs are still lacking; the provision of quantitative data will further strengthen the weight of evidence and make the AOP applicable for a wide range of purposes.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);
				pathway
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										pathway,
										dataSource,
										"Considerations for Potential Applications of the AOP (optional)",
										"his systematic and coherent display of currently available mechanistic-toxicological information can serve as a knowledge-based repository for identification/selection/development of in vitro methods suitable for measuring KEs and their relationships along the AOP and to facilitate the use of alternative data for regulatory purposes. Identified uncertainties and knowledge gaps can direct future research by priority setting and targeted testing. The KE descriptions can be used for hazard identification and read-across to assess the toxic potential of an untested substance. A sufficiently detailed description of the AOP to liver fibrosis might support chemical risk assessment by indicating early (upstream) markers for downstream events and facilitate a testing strategy without the need for an elaborated cell model.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 5);
				
				pathway.updateEssentiality();
				EssetialityDescription essentiality = pathway.getEssentiality();
				DescriptionSection_Structured dss;
				dss = essentiality.getEssentialityDescription(effect_molecularinitiatingevent3);
				dss.setContent("Section content");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect5);
				dss.setContent("Section content");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect7);
				dss.setContent("Section content");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect9);
				dss.setContent("Section content");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect11);
				dss.setContent("Section content");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect13);
				dss.setContent("Section content");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
				dss = essentiality.getEssentialityDescription(effect_adverseoutcome15);
				dss.setContent("Section content");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
			}
	}

package org.qsari.effectopedia.data.generated;

import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.core.objects.DescriptionSection.ContentFormat;
import org.qsari.effectopedia.core.objects.DescriptionSection_Structured;
import org.qsari.effectopedia.core.objects.Effect_AdverseOutcome;
import org.qsari.effectopedia.core.objects.Effect_DownstreamEffect;
import org.qsari.effectopedia.core.objects.Effect_Endpoint;
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
import org.qsari.effectopedia.core.objects.Test_ExVivo;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.defaults.DefaultDataTemplates;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.system.User;
import org.qsari.effectopedia.data.RevisionBasedDS;
import org.qsari.effectopedia.core.objects.Link.LinkType;
import org.qsari.effectopedia.base.ids.ReferenceIDW;
import org.qsari.effectopedia.core.object.elemets.EssetialityDescription;

public class NMDARs1b extends SourceGeneratedPathway
	{
		
		public NMDARs1b(DataSource dataSource)
			{
				super("Chronic binding of antagonist to N-methyl-D-aspartate receptors (NMDARs) during brain development induces impairment of learning and memory abilities",
						"N-methyl-D-aspartate receptors, NMDARs, brain development, learning imapriment,", dataSource,
						"D://Java//org.qsari.effectopedia//test//Chronic binding of antagonist to N-methyl-D-aspartate receptors (NMDARs) during brain development induces impairment of learning and memory abilities");
			}
		
		protected Initiator_ChemicalStructure					initiator_chemicalstructure1;
		protected Initiator_ChemicalStructure					initiator_chemicalstructure2;
		protected Effect_MolecularInitiatingEvent	effect_molecularinitiatingevent3;
		protected Link_ChemStructToMIE												link_chemstructtomie4;
		protected Link_ChemStructToMIE												link_chemstructtomie5;
		protected Effect_DownstreamEffect									effect_downstreameffect6;
		protected Link_EffectToEffect													link_effecttoeffect7;
		protected Effect_DownstreamEffect									effect_downstreameffect8;
		protected Link_EffectToEffect													link_effecttoeffect9;
		protected Effect_DownstreamEffect									effect_downstreameffect10;
		protected Link_EffectToEffect													link_effecttoeffect11;
		protected Effect_DownstreamEffect									effect_downstreameffect12;
		protected Effect_DownstreamEffect									effect_downstreameffect13;
		protected Effect_DownstreamEffect									effect_downstreameffect14;
		protected Link_EffectToEffect													link_effecttoeffect15;
		protected Link_EffectToEffect													link_effecttoeffect16;
		protected Link_EffectToEffect													link_effecttoeffect17;
		protected Effect_DownstreamEffect									effect_downstreameffect18;
		protected Link_EffectToEffect													link_effecttoeffect19;
		protected Link_EffectToEffect													link_effecttoeffect20;
		protected Link_EffectToEffect													link_effecttoeffect21;
		protected Effect_DownstreamEffect									effect_downstreameffect22;
		protected Link_EffectToEffect													link_effecttoeffect23;
		protected Effect_DownstreamEffect									effect_downstreameffect24;
		protected Link_EffectToEffect													link_effecttoeffect25;
		
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
				initiator_chemicalstructure1.setTitle("Glycine");
				initiator_chemicalstructure1.getStructure2DImage().setValue("org.qsari.effectopedia.data.objects.ObjectProperty@13a50f8");
				initiator_chemicalstructure1.getIdentification().setPropertyValue(0, "56406");
				initiator_chemicalstructure1.getIdentification().setPropertyValue(1, "Glycine");
				initiator_chemicalstructure1.getIdentification().setPropertyValue(2, "C(C(=O)O)N");
				initiator_chemicalstructure1.getIdentification().setPropertyValue(3, "InChI=1S/C2H5NO2/c3-1-2(4)5/h1,3H2,(H,4,5)");
				initiator_chemicalstructure1.getIdentification().setPropertyValue(4, "DHMQDGOQFOQNFH-UHFFFAOYSA-N");
				initiator_chemicalstructure1.getIdentification().setPropertyValue(5, " ");
				initiator_chemicalstructure1.getIdentification().setPropertyValue(6, "C2H5NO2");
				initiator_chemicalstructure1.setSynonymsList(new String[]
					{ "Aminoethanoic acid \"Aminoacetic acid\"Glycocoll" });
				
				initiator_chemicalstructure2 = new Initiator_ChemicalStructure(pathway, dataSource);
				initiator_chemicalstructure2.setTitle("L-Glutamate");
				initiator_chemicalstructure2.getStructure2DImage().setValue("org.qsari.effectopedia.data.objects.ObjectProperty@19a07f5");
				initiator_chemicalstructure2.getIdentification().setPropertyValue(0, "56860");
				initiator_chemicalstructure2.getIdentification().setPropertyValue(1, "2-Aminopentanedioic acid");
				initiator_chemicalstructure2.getIdentification().setPropertyValue(2, "C(CC(=O)O)C(C(=O)O)N");
				initiator_chemicalstructure2.getIdentification().setPropertyValue(3, "InChI=1S/C5H9NO4/c6-3(5(9)10)1-2-4(7)8/h3H,1-2,6H2,(H,7,8)(H,9,10)");
				initiator_chemicalstructure2.getIdentification().setPropertyValue(4, "WHUUTDBJXJRKMK-UHFFFAOYSA-N");
				initiator_chemicalstructure2.getIdentification().setPropertyValue(5, " ");
				initiator_chemicalstructure2.getIdentification().setPropertyValue(6, "C5H9NO4");
				initiator_chemicalstructure2.setSynonymsList(new String[]
					{ "2-Aminoglutaric acid" });
				
				effect_molecularinitiatingevent3 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				effect_molecularinitiatingevent3.setTitle("NMDARs, Binding of antagonist");
				effect_molecularinitiatingevent3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				effect_molecularinitiatingevent3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				effect_molecularinitiatingevent3
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_molecularinitiatingevent3,
										dataSource,
										"Definition",
										"<html><b>Biological state:</b> L-glutamate (Glu) is a neurotransmitter with important role in the regulation of brain development and maturation processes. Two major classes of Glu receptors, ionotropic and metabotropic, have been identified. Due to its physiological and pharmacological properties, Glu activates three classes of ionotropic receptors named: Î±-amino-3-hydroxy-5-methyl-4-isoazolepropionic acid (AMPA receptors), 2-carboxy-3-carboxymethyl-4-isopropenylpyrrolidine (kainate receptors) and N-methyl-D-aspartate (NMDA receptors, NMDARs), which transduce the postsynaptic signal. Ionotropic glutamate receptors are integral membrane proteins formed by four large subunits that compose a central ion channel pore. In case of NMDA receptors, two NR1 subunits are combined with either two NR2 (NR2A, NR2B, NR2C, NR2D) subunits and less commonly are assembled together with a combination of NR2 and NR3 (A, B) subunits (reviewed in Traynelis et al., 2010). To be activated NMDA receptors require simultaneous binding of both glutamate to NR2 subunits and of glycine to either NR1 or NR3 subunits that provide the specific binding sites named extracellular ligand-binding domains (LBDs). Apart from LBDs, NMDA receptor subunits contain three more domains that are considered semiautonomous: 1) the extracellular amino-terminal domain that plays important role in assembly and trafficking of these receptors; 2) the transmembrane domain that is linked with LBD and contributes to the formation of the core of the ion channel and 3) the intracellular carboxyl-terminal domain that influences membrane targeting, stabilization, degradation and post-translation modifications.<br><br><b>Biological compartments:</b> The genes of the NMDAR subunits are expressed in various tissues and are not only restricted to the nervous system. The level of expression of these receptors in neuronal and non-neuronal cells depends on: transcription, chromatin remodelling, mRNA levels, translation, stabilization of the protein, receptor assembly and trafficking, energy metabolism and numerous environmental stimuli (reviewed in Traynelis et al., 2010).<br><br>In hippocampus region of the brain, NR2A and NR2B are the most abundant NR2 family subunits. NR2A-containing NMDARs are mostly expressed synaptically, while NR2B-containing NMDARs are found both synaptically and extrasynaptically (Tovar and Westbrook, 1999).<br><br><b>General role in biology:</b> NMDA receptors, when compared to the other Glu receptors, are characterized by higher affinity for Glu, slower activation and desensitisation kinetics, higher permeability for calcium (Ca2+) and susceptibility to potential-dependent blockage by magnesium ions (Mg2+). NMDA receptors are involved in fast excitatory synaptic transmission and neuronal plasticity in the central nervous system (CNS). Functions of NMDA receptors:<br><br> 1. They are involved in cell signalling events converting environmental stimuli to genetic changes by regulating gene transcription and epigenetic modifications in neuronal cells (Cohen and Greenberg, 2008).<br><br>	2. In NMDA receptors, the ion channel is blocked by extracellular Mg2+ and Zn2+ ions, allowing the flow of Na+ and Ca2+ ions into the cell and K+ out of the cell which is voltage-dependent. Ca2+ flux through the NMDA receptor is considered to play a critical role in pre- and post-synaptic plasticity, a cellular mechanism important for learning and memory (Barria and Malinow, 2002).<br><br>	3. The NMDA receptors have been shown to play an essential role in the strengthening of synapses and neuronal differentiation, through long-term potentiation (LTP), and the weakening of synapses, through long-term depression (LTD). All these processes are implicated in the memory and learning function (Barria and Malinow, 2002).<br><br><html>")
										.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 0);
				effect_molecularinitiatingevent3
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_molecularinitiatingevent3,
										dataSource,
										"Measurment/detection",
										"<html><i>Methods that have been previously reviewed and approved by a recognized authority should be included in the Overview section above. All other methods, including those well established in the published literature, should be described here. Consider the following criteria when describing each method: 1. Is the assay fit for purpose? 2. Is the assay directly or indirectly (i.e. a surrogate) related to a key event relevant to the final adverse effect in question? 3. Is the assay repeatable? 4. Is the assay reproducible?</i><br>There is no OECD advised method for measuring NMDA receptor binding of antagonists. However, there are methods described in the scientific literature that allow measuring:<br><br><b>1. Ex vivo: </b>The most common assay used is the NMDA receptor (MK801 site) radioligand competition binding assays (Reynolds, 2001; Gao et al., 2013; http://pdsp.med.unc.edu/UNC-CH%20Protocol%20Book.pdf; http://www.currentprotocols.com/WileyCDA/CPUnit/refId-ph0120.html). This assay is based on the use of the most potent and specific antagonist of this receptor, MK801 that is used to detect and differentiate agonists and antagonists that bind to this specific site of the receptor.<br><br><b>2. In silico: </b>The prediction of NMDA receptor targeting is achievable by combining database mining, molecular docking, structure-based pharmacophore searching, and chemical similarity searching methods together (Korkut and Varnali, 2003; Koutsoukos et al., 2011; Gao et al., 2013; Mazumber and Borah, 2014; Chtitaa et al., 2015).</html>")
										.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 1);
				effect_molecularinitiatingevent3
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_molecularinitiatingevent3,
										dataSource,
										"Evidence Supporting Taxonomic Applicability",
										"The evolution of NMDAR subunits (NR1, NR2, NR3) is well-conserved throughout different species from lower organism to mammals, including humans (Ewald and Cline, 2009; Tikhonov and Magazanik, 2009; Koo and Hampson, 2010; Teng et al., 2010; Flores-soto et al., 2012).\n\nMany of the binding sites for the noncompetitive or competitive antagonists e.g. for binding of dizocilpine (MK-801), phencyclidine, D-2-amino-5-phosphonopentanoate (AP5) and 3-((R)-2-carboxypiperazin-4-yl)-propyl-1-phosphonic acid (R-CPP) are also conserved in Drosophila (reviewed in Xia and Chiang, 2009).\n\nCellular membranes can be prepared from different brain areas of distinct species. Using [3H]MK-801, high affinity binding sites for MK-801 were detected in membranes of the rat brain (Woodruff et al., 1987). The same binding assay has been used in preparations from human brains mostly by patients with neurodegenerative disorders (Slater et al., 1993) as well as from different marine, avian species (Scheuhammer et al., 2008) and insects (Eldefrawi et al., 1993).")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 2);
				effect_molecularinitiatingevent3
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_molecularinitiatingevent3,
										dataSource,
										"Evidence for Chemical Initiation of this Molecular Initiating Event",
										"Glu and glycine are endogenous agonists that bind to LBD of specific NMDA receptor subunits. In this binding site numerous competitive exogenous antagonists have been identified to cause closure of binding site and inhibition of NMDA receptor (reviewed in Traynelis et al., 2010). Here, are listed some known competitive antagonists for NMDA receptor, some of them are specific to NR1 subunit and some to NR2 subunit:\n\nÎ±-AA, Î±-aminoadipate;\n\n5,7-DCKA, 5,7-dichlorokynurenic acid;\n\n7-CKA, 7-chlorokynurenic acid;\n\nACEA-1011, 5-chloro-7-trifluoromethyl-1,4-dihydro-2,3-quinoxalinedione;\n\nACEA-1021, licostinel;\n\nAP5, 2-amino-5-phosphonopentanoate;\n\nAP7, 2-amino-7-phosphonopentanoate;\n\nCGP-61594, (Â±)-trans-4-[2-(4-azidophyenyl)acetylamino]-5,7-dichloro-1,2,3,4-tetrahydroquinoline-2-carboxylic acid;\n\nCGP-40116, d-(E)-2-amino-4-methyl-5-phosphono-3-pentenoic acid;\n\nCGP-43487, d-(E)-2-amino-4-methyl-5-phosphono-3-pentenoic acid methyl ester;\n\nCGP-58411, 7-chloro-4-hydroxy-3-phenyl-1H-quinolin-2-one;\n\nCGS-19755, (2R,4S)-4-(phosphonomethyl)piperidine-2-carboxylic acid;\n\nCPP, 4-(3-phosphonopropyl) pizerazine-2-carboxylic acid;\n\nGV150,526A, gavestinel;\n\nGV196,771A, (E)-4,6-dichloro-3-[(2-oxo-1-phenyl-3-pyrrolidinylidene)methyl]-1H-indole-2-carboxylic acid;\n\nL-689,560, 4-trans-2-carboxy-5,7-dichloro-4-phenylaminocarbonylamino-1,2,3,4-tetrahydroquinoline;\n\nL-701,324, 7-chloro-4-hydroxy-3-(3-phenoxy)phenyl-2(1H)-quinolone;\n\nMDL105,519, (E)-3-(2-phenyl-2-carboxyethenyl)-4, 6-dichloro-1H-indole-2-carboxylic acid;\n\nPBPD, (2S,3R)-1-(biphenyl-4-carbonyl)piperazine-2,3-dicarboxylic acid;\n\nPMPA, (R,S)-4-(phosphonomethyl)-piperazine-2-carboxylic acid;\n\nPPDA, (2S,3R)-1-(phenanthren-2-carbonyl)piperazine-2,3-dicarboxylic acid\n\nBesides competitive antagonists, noncompetitive antagonists have also been designed like phenylethanolamine ifenprodil that interacts with the NR2B extracellular amino-terminal domain. It has been suggested that they act by stabilizing an agonist-bound state in which the receptor has a low open probability. Other more potent derivatives of ifenprodil are: Î±-(4-hydroxyphenyl)-Î²-methyl-4-(phenylmethyl)-1-piperidine propanol (Ro 25-6981), 1-[2-(4-hydroxy-phenoxy)-ethyl]-4-(4-methyl-benzyl)-piperidin-4-ol (Ro 63-1908), besonprodil (CI-1041), and traxoprodil mesylate (CP-101,606). Ethanol has been proposed to be a noncompetitive antagonist of NMDA receptors, binding to NR2 subunit (Nagy, 2008). Inhibition of NMDA receptor function by ethanol and interactions between ethanol and the noncompetitive NMDA receptor antagonist ifenprodil have been examined in neocortical neurons from rat and human embryonic kidney (HEK) 293 cells expressing recombinant NMDA receptors (Lovinger, 1995). Recently, a structural model has been suggested that predicts the presence of four sites of ethanol action on the NMDA receptor, each containing four pairs of positions in the NR1/NR2 subunits (reviewed in Chandrasekar, 2013). Some other antagonists can become trapped in the pore of the NMDA receptor after channel closure and these antagonists are called uncompetitive or trapping blockers. The most well studied NMDA receptor uncompetitive antagonists are Mg2+, polyamines, phencyclidine, ketamine, MK-801, memantine, amantadine, pentamidine, 9-tetrahydroaminoacridine, dextromethorphan, and its metabolite dextrorphan. MK-801 has been shown to prevent toluene-induced alterations in pattern-elicited visual-evoked potentials in vivo, suggesting the possibility that the binding site of toluene might be common with the one of MK-801 (Bale et al., 2007). However, another study suggests that toluene interference with the NMDA receptor might not be exclusively because of the binding to the channel pore (Smothers and Woodward, 2007) but it may involve some other binding sites. Lead (Pb2+) is considered a voltage independent antagonist of NMDA receptors and it is believed that possibly shares the same binding site with Zn2+ (reviewed in Neal and Guilarte, 2010; Traynelis et al., 2010). However, studies done in recombinant NR2A- and NR2B- containing NMDA receptors with mutated Zn2+ binding sites exhibit that additional structural elements, different from those important for Zn2+ binding are involved in Pb2+ binding site (reviewed in Neal and Guilarte, 2010). Similarly, there are contradicting experimental evidence and disagreement about Pb2+'s role as competitive or non-competitive antagonist (Neal and Guilarte, 2010).")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 3);
				effect_molecularinitiatingevent3
						.getReferenceIDs()
						.add(
								new Reference(effect_molecularinitiatingevent3, dataSource,
										"Bale AS, Jackson MD, Krantz QT, Benignus VA, Bushnell PJ, Shafer TJ, Boyes WK. (2007) Evaluating the NMDA-glutamate receptor as a site of action for toluene, in vivo. Toxicol Sci. 98: 159-66.")
										.<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs().add(
						new Reference(effect_molecularinitiatingevent3, dataSource, "Barria A, Malinow R. (2002) Subunit-specific NMDA receptor trafficking to synapses. Neuron 35: 345-353.").<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs().add(
						new Reference(effect_molecularinitiatingevent3, dataSource, "Chandrasekar R. (2013) Alcohol and NMDA receptor: current research and future direction. Front Mol Neurosci. 6: 14.")
								.<Reference> makeItLive());
				effect_molecularinitiatingevent3
						.getReferenceIDs()
						.add(
								new Reference(
										effect_molecularinitiatingevent3,
										dataSource,
										"Chtitaa S, Larifb M, Ghamalia M, Bouachrinec M, Lakhlifia T. (2015) DFT-based QSAR Studies of MK801 derivatives for non competitive antagonists of NMDA using electronic and topological descriptors. Journal of Taibah University for Science. 9: 143-154.")
										.<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs().add(
						new Reference(effect_molecularinitiatingevent3, dataSource,
								"Cohen S, Greenberg ME. (2008) Communication between the synapse and the nucleus in neuronal development, plasticity, and disease. Ann Rev Cell Dev Biol 24: 183-209.")
								.<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs().add(
						new Reference(effect_molecularinitiatingevent3, dataSource,
								"Eldefrawi ME, Anis NA, Eldefrawi AT. (1993) Glutamate receptor inhibitors as potential insecticides. Arch Insect Biochem Physiol. 22: 25-39.").<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs().add(
						new Reference(effect_molecularinitiatingevent3, dataSource,
								"Ewald RC, Cline HT. (2009) Cloning and phylogentic analysis of NMDA receptor subunits NR1, NR2A and NR2B in Xenopus laevis tadpoles. Front Mol Neurosci. 2: 4.").<Reference> makeItLive());
				effect_molecularinitiatingevent3
						.getReferenceIDs()
						.add(
								new Reference(
										effect_molecularinitiatingevent3,
										dataSource,
										"Flores-soto ME, Chaparro-Huerta V, Escoto-Delgadillo M, Vazuez-Valls E, Gonzalez-Castaneda RE, Beas-Zarate C. (2012) Structure and function of NMDA-type glutamate receptor subunits. Neurologia 27: 301-310.")
										.<Reference> makeItLive());
				effect_molecularinitiatingevent3
						.getReferenceIDs()
						.add(
								new Reference(
										effect_molecularinitiatingevent3,
										dataSource,
										"Gao L, Fang JS, Bai XY, Zhou D, Wang YT, Liu AL, Du GH. (2013) In silico Target Fishing for the Potential Targets and Molecular Mechanisms of Baicalein as an Antiparkinsonian Agent: Discovery of the Protective Effects on NMDA Receptor-Mediated Neurotoxicity. Chem Biol Drug Des. 81: 675-87.")
										.<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs().add(
						new Reference(effect_molecularinitiatingevent3, dataSource,
								"Koo JCP, Hampson DR. (2010) Phylogenic and evolutionary analysis of glutamate receptor based on extant invertebrate genes. JULS 1: 42-48.").<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs().add(
						new Reference(effect_molecularinitiatingevent3, dataSource,
								"Korkut A, Varnali T. (2003) Quantitative structure activity relationship (QSAR) of competitive N-methyl-D-aspartate (NMDA) antagonists. Mol Phys 101: 3285-3291.").<Reference> makeItLive());
				effect_molecularinitiatingevent3
						.getReferenceIDs()
						.add(
								new Reference(
										effect_molecularinitiatingevent3,
										dataSource,
										"Koutsoukas A, Simms B, Kirchmair J, Bond PJ, Whitmore AV, Zimmer S, Young MP, Jenkins JL, Glick M, Glen RC, Bender A. (2011) From in silico target prediction to multi-target drug design: current databases, methods and applications. J Proteomics 74: 2554-2574.")
										.<Reference> makeItLive());
				effect_molecularinitiatingevent3
						.getReferenceIDs()
						.add(
								new Reference(
										effect_molecularinitiatingevent3,
										dataSource,
										"Lovinger DM. (1995) Developmental decrease in ethanol inhibition of N-methyl-D-aspartate receptors in rat neocortical neurons: relation to the actions of ifenprodil. J Pharmacol Exp Ther. 274: 164-172.")
										.<Reference> makeItLive());
				effect_molecularinitiatingevent3
						.getReferenceIDs()
						.add(
								new Reference(
										effect_molecularinitiatingevent3,
										dataSource,
										"Mazumder MK, Borah A (2014) Piroxicam inhibits NMDA receptor-mediated excitotoxicity through allosteric inhibition of the GluN2B subunit: An in silico study elucidating a novel mechanism of action of the drug. Medical Hypotheses 83: 740â€“746.")
										.<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs().add(
						new Reference(effect_molecularinitiatingevent3, dataSource, "Nagy J. (2008) Alcohol related changes in regulation of NMDA receptor functions. Curr Neuropharmacol 6: 39-54.")
								.<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs().add(
						new Reference(effect_molecularinitiatingevent3, dataSource, "Neal AP, Guilarte TR. (2010) Molecular Neurobiology of Lead (Pb2+): Effects on Synaptic Function. Mol Neurobiol. 42: 151-160.")
								.<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs().add(
						new Reference(effect_molecularinitiatingevent3, dataSource,
								"Nihei MK, Guilarte TR. (1999) NMDAR-2A subunit protein expression is reduced in the hippocampus of rats exposed to Pb2+ during development. Brain Res Mol Brain Res. 66: 42-49.")
								.<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs().add(
						new Reference(effect_molecularinitiatingevent3, dataSource,
								"Reynolds IJ. (2001) [3H](+)MK801 radioligand binding assay at the N-methyl-D-aspartate receptor. Curr Protoc Pharmacol. Chapter 1:Unit 1.20. doi: 10.1002/0471141755.ph0120s11.")
								.<Reference> makeItLive());
				effect_molecularinitiatingevent3
						.getReferenceIDs()
						.add(
								new Reference(
										effect_molecularinitiatingevent3,
										dataSource,
										"Scheuhammer AM, Basu N, Burgess NM, Elliott JE, Campbell GD, Wayland M, Champoux L, Rodrigue J. (2008) Relationships among mercury, selenium, and neurochemical parameters in common loons (Gavia immer) and bald eagles (Haliaeetus leucocephalus). Ecotoxicology 17: 93-101.")
										.<Reference> makeItLive());
				effect_molecularinitiatingevent3
						.getReferenceIDs()
						.add(
								new Reference(
										effect_molecularinitiatingevent3,
										dataSource,
										"Slater P, McConnell SE, D'Souza SW, Barson AJ. (1993) Postnatal changes in N-methyl-D-aspartate receptor binding and stimulation by glutamate and glycine of [3H]-MK-801 binding in human temporal cortex. Br J Pharmacol. 108: 1143-1149.")
										.<Reference> makeItLive());
				effect_molecularinitiatingevent3
						.getReferenceIDs()
						.add(
								new Reference(
										effect_molecularinitiatingevent3,
										dataSource,
										"Smothers CT, Woodward JJ. (2007) Pharmacological characterization of glycine-activated currents in HEK 293 cells expressing N-methyl-d-aspartate NR1 and NR3 subunits. J Pharmacol Exp Ther. 322: 739-748.")
										.<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs().add(
						new Reference(effect_molecularinitiatingevent3, dataSource,
								"Teng H, Cai W, Zhou L, Zhang J, Liu Q, Wang Y, et al. (2010) Evolutionary mode of functional divergence of vertebrate NMDA receptor subunit 2 Genes. PLoS ONE. 5(10): e13342.")
								.<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs().add(
						new Reference(effect_molecularinitiatingevent3, dataSource,
								"Tikhonov DB, Magazanik LG. (2009) Origin and molecular evolution of ionotropic glutamate receptors. Neurosci Behav Physiol. 39: 763-772.").<Reference> makeItLive());
				effect_molecularinitiatingevent3.getReferenceIDs().add(
						new Reference(effect_molecularinitiatingevent3, dataSource,
								"Tovar KR, Westbrook GL. (1999) The incorporation of NMDA receptors with a distinct subunit composition at nascent hippocampal synapses in vitro. J Neurosci. 19: 4180â€“4188.")
								.<Reference> makeItLive());
				effect_molecularinitiatingevent3
						.getReferenceIDs()
						.add(
								new Reference(
										effect_molecularinitiatingevent3,
										dataSource,
										"Traynelis S, Wollmuth LP, McBain CJ, Menniti FS, Vance KM, Ogden KK, Hansen KB, Yuan H, Myers SJ, Dingledine R. (2010) Glutamate receptor ion channels: structure, regulation, and function. Pharmacol Rev. 62: 405-496.")
										.<Reference> makeItLive());
				effect_molecularinitiatingevent3
						.getReferenceIDs()
						.add(
								new Reference(
										effect_molecularinitiatingevent3,
										dataSource,
										"Woodruff GN, Foster AC, Gill R, Kemp JA, Wong EH, Iversen LL. (1987) The interaction between MK-801 and receptors for N-methyl-D-aspartate: functional consequences. Neuropharmacology 26(7B): 903-909.")
										.<Reference> makeItLive());
				effect_molecularinitiatingevent3
						.getReferenceIDs()
						.add(
								new Reference(
										effect_molecularinitiatingevent3,
										dataSource,
										"Xia S, Chiang AS. (2009) NMDA Receptors in Drosophila. In: Van Dongen AM, editor. Biology of the NMDA Receptor. Boca Raton (FL): CRC Press; Chapter 10. Available from: http://www.ncbi.nlm.nih.gov/books/NBK5286/")
										.<Reference> makeItLive());
				
				effect_downstreameffect6 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect6.setTitle("NMDARs, Inhibition");
				effect_downstreameffect6.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				effect_downstreameffect6.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				effect_downstreameffect6
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect6,
										dataSource,
										"Definition",
										"<html><b>Biological state:</b> L-glutamate (Glu) is a neurotransmitter with important role in the regulation of brain development and maturation processes. Two major classes of Glu receptors, ionotropic and metabotropic, have been identified. Due to its physiological and pharmacological properties, Glu activates three classes of ionotropic receptors named: Î±-amino-3-hydroxy-5-methyl-4-isoazolepropionic acid (AMPA receptors), 2-carboxy-3-carboxymethyl-4-isopropenylpyrrolidine (kainate receptors) and N-methyl-D-aspartate (NMDA receptors, NMDARs), which transduce the postsynaptic signal. Ionotropic glutamate receptors are integral membrane proteins formed by four large subunits that compose a central ion channel pore. In case of NMDA receptors, two NR1 subunits are combined with either two NR2 (NR2A, NR2B, NR2C, NR2D) subunits and less commonly are assembled together with a combination of NR2 and NR3 (A, B) subunits (reviewed in Traynelis et al., 2010). To be activated NMDA receptors require simultaneous binding of both glutamate to NR2 subunits and of glycine to either NR1 or NR3 subunits that provide the specific binding sites named extracellular ligand-binding domains (LBDs). Apart from LBDs, NMDA receptor subunits contain three more domains that are considered semiautonomous: 1) the extracellular amino-terminal domain that plays important role in assembly and trafficking of these receptors; 2) the transmembrane domain that is linked with LBD and contributes to the formation of the core of the ion channel and 3) the intracellular carboxyl-terminal domain that influences membrane targeting, stabilization, degradation and post-translation modifications.<br><br><b>Biological compartments:</b> The genes of the NMDAR subunits are expressed in various tissues and are not only restricted to the nervous system. The level of expression of these receptors in neuronal and non-neuronal cells depends on: transcription, chromatin remodelling, mRNA levels, translation, stabilization of the protein, receptor assembly and trafficking, energy metabolism and numerous environmental stimuli (reviewed in Traynelis et al., 2010).<br><br>In hippocampus region of the brain, NR2A and NR2B are the most abundant NR2 family subunits. NR2A-containing NMDARs are mostly expressed synaptically, while NR2B-containing NMDARs are found both synaptically and extrasynaptically (Tovar and Westbrook, 1999).<br><br><b>General role in biology:</b> NMDA receptors, when compared to the other Glu receptors, are characterized by higher affinity for Glu, slower activation and desensitisation kinetics, higher permeability for calcium (Ca2+) and susceptibility to potential-dependent blockage by magnesium ions (Mg2+). NMDA receptors are involved in fast excitatory synaptic transmission and neuronal plasticity in the central nervous system (CNS). Functions of NMDA receptors:<br><br>1. They are involved in cell signalling events converting environmental stimuli to genetic changes by regulating gene transcription and epigenetic modifications in neuronal cells (Cohen and Greenberg, 2008).<br><br>2. In NMDA receptors, the ion channel is blocked by extracellular Mg2+ and Zn2+ ions, allowing the flow of Na+ and Ca2+ ions into the cell and K+ out of the cell which is voltage-dependent. Ca2+ flux through the NMDA receptor is considered to play a critical role in pre- and post-synaptic plasticity, a cellular mechanism important for learning and memory (Barria and Malinow, 2002).<br><br>3. The NMDA receptors have been shown to play an essential role in the strengthening of synapses and neuronal differentiation, through long-term potentiation (LTP), and the weakening of synapses, through long-term depression (LTD). All these processes are implicated in the memory and learning function (Barria and Malinow, 2002).<br><br><html>")
										.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 0);
				effect_downstreameffect6
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect6,
										dataSource,
										"Measurment/detection",
										"<html><i>Methods that have been previously reviewed and approved by a recognized authority should be included in the Overview section above. All other methods, including those well established in the published literature, should be described here. Consider the following criteria when describing each method: 1. Is the assay fit for purpose? 2. Is the assay directly or indirectly (i.e. a surrogate) related to a key event relevant to the final adverse effect in question? 3. Is the assay repeatable? 4. Is the assay reproducible?</i><br><br>No OECD methods are available to measure the activation state of NMDA receptors.<br><br>The measurement of the activation or the inhibition of NMDA receptors is done indirectly by recording the individual ion channels that are selective to Na+, K+ and Ca+2 by the patch clamp technique. This method relies on lack of measurable ion flux when NMDA ion channel is closed, whereas constant channel specific conductance is recorded at the open state of the receptor (Blanke and VanDongen, 2009). Furthermore, this method is based on the prediction that activation or inhibition of an ion channel results from an increase in the probability of being in the open or close state, respectively.<br><br>The whole-cell patch clamp recording techniques have also been used to study synaptically-evoked NMDA receptor-mediated excitatory or inhibitory postsynaptic currents (EPSCs and IPSCs, respectively) in brain slices and neuronal cells, allowing the evaluation of the activated or inhibited state of the receptor (Ogdon and Stanfield, 2009; Zhao et al., 2009).<br><br>Microelectrode array (MEA) recordings are used to measure electrical activity in cultured neurons in response to NMDA receptor activation or inactivation (Keefer et al., 2001, Gramowski et al., 2000 and Gopal, 2003; Johnstone et al., 2010). MEAs can also be applied in higher throughput platforms to facilitate screening of numerous chemical compounds based on electrical activity measurements (McConnell et al., 2012).</html>")
										.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 1);
				effect_downstreameffect6
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect6,
										dataSource,
										"Evidence Supporting Taxonomic Applicability",
										"The cellular expression of the NMDAR subunits has been studied in both adult human cortex and hippocampus (Scherzer et al., 1998) as well as during the development of the human hippocampal formation (Law et al., 2003). The whole-cell patch clamp recording techniques have been used in NMDA receptors expressed in human TsA cells (derivative of the human embryonic kidney cell line HEK-293) (Ludolph et al., 2010). Cell-attached single-channel recordings of NMDA channels has been carried out in human dentate gyrus granule cells acutely dissociated from slices prepared from hippocampi surgically removed from human patients (Lieberman and Mody, 1999).\n\nIt is important to note that in invertebrates the glutamatergic synaptic transmission has inhibitory and not excitatory role like in vertebrates. This type of neurotransmission is mediated by glutamate-gated chloride channels that are members of the â€˜cys-loopâ€™ ligand-gated anion channel superfamily found only in invertebrates. The subunits of glutamate-activated chloride channel have been isolated from C. elegans and from Drosophila (Blanke and VanDongen, 2009).")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 2);
				effect_downstreameffect6.getReferenceIDs().add(
						new Reference(effect_downstreameffect6, dataSource, "Barria A, Malinow R. (2002) Subunit-specific NMDA receptor trafficking to synapses. Neuron 35: 345-353.").<Reference> makeItLive());
				effect_downstreameffect6
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect6,
										dataSource,
										"Blanke ML, VanDongen AMJ. (2009) Activation Mechanisms of the NMDA Receptor. In: Van Dongen AM, editor. Biology of the NMDA Receptor. Boca Raton (FL): CRC Press; Chapter 13. Available from: http://www.ncbi.nlm.nih.gov/books/NBK5274/")
										.<Reference> makeItLive());
				effect_downstreameffect6.getReferenceIDs().add(
						new Reference(effect_downstreameffect6, dataSource,
								"Cohen S, Greenberg ME. (2008) Communication between the synapse and the nucleus in neuronal development, plasticity, and disease. Ann Rev Cell Dev Biol 24: 183-209.")
								.<Reference> makeItLive());
				effect_downstreameffect6.getReferenceIDs().add(
						new Reference(effect_downstreameffect6, dataSource,
								"Gopal K. (2003) Neurotoxic effects of mercury on auditory cortex networks growing on microelectrode arrays: a preliminary analysis. Neurotoxicol Teratol. 25: 69-76.")
								.<Reference> makeItLive());
				effect_downstreameffect6
						.getReferenceIDs()
						.add(
								new Reference(effect_downstreameffect6, dataSource,
										"Gramowski A, Schiffmann D, Gross GW. (2000) Quantification of acute neurotoxic effects of trimethyltin using neuronal networks cultures on microelectrode arrays. Neurotoxicology 21: 331-342.")
										.<Reference> makeItLive());
				effect_downstreameffect6.getReferenceIDs().add(
						new Reference(effect_downstreameffect6, dataSource,
								"Johnstone AFM, Gross GW, Weiss D, Schroeder O, Shafer TJ. (2010). Use of microelectrode arrays for neurotoxicity testing in the 21st century Neurotoxicology 31: 331-350.")
								.<Reference> makeItLive());
				effect_downstreameffect6.getReferenceIDs().add(
						new Reference(effect_downstreameffect6, dataSource,
								"Keefer E, Norton S, Boyle N, Talesa V, Gross G. (2001) Acute toxicity screening of novel AChE inhibitors using neuronal networks on microelectrode arrays. Neurotoxicology 22: 3-12.")
								.<Reference> makeItLive());
				effect_downstreameffect6
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect6,
										dataSource,
										"Law AJ, Weickert CS, Webster MJ, Herman MM, Kleinman JE, Harrison PJ. (2003) Expression of NMDA receptor NR1, NR2A and NR2B subunit mRNAs during development of the human hippocampal formation. Eur J Neurosci. 18: 1197-1205.")
										.<Reference> makeItLive());
				effect_downstreameffect6.getReferenceIDs().add(
						new Reference(effect_downstreameffect6, dataSource, "Lieberman DN, Mody I. (1999) Properties of single NMDA receptor channels in human dentate gyrus granule cells. J Physiol. 518: 55-70.")
								.<Reference> makeItLive());
				effect_downstreameffect6
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect6,
										dataSource,
										"Ludolph AG, Udvardi PT, Schaz U, Henes C, Adolph O, Weigt HU, Fegert JM, Boeckers TM, FÃ¶hr KJ. (2010) Atomoxetine acts as an NMDA receptor blocker in clinically relevant concentrations. Br J Pharmacol. 160: 283-291.")
										.<Reference> makeItLive());
				effect_downstreameffect6
						.getReferenceIDs()
						.add(
								new Reference(effect_downstreameffect6, dataSource,
										"McConnell ER, McClain MA, Ross J, LeFew WR, Shafer TJ (2012). Evaluation of multi-well microelectrode arrays for neurotoxicity screening using a chemical training set Neurotoxicology 33: 1048-1057.")
										.<Reference> makeItLive());
				effect_downstreameffect6
						.getReferenceIDs()
						.add(
								new Reference(effect_downstreameffect6, dataSource,
										"Ogdon D, Stanfield P. (2009) Patch clamp techniques for single channel and whole-cell recording. Chapter 4, pages 53-78. http://www.utdallas.edu/~tres/microelectrode/microelectrodes_ch04.pdf")
										.<Reference> makeItLive());
				effect_downstreameffect6
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect6,
										dataSource,
										"Scherzer CR, Landwehrmeyer GB, Kerner JA, Counihan TJ, Kosinski CM, Standaert DG, Daggett LP, VeliÃ§elebi G, Penney JB, Young AB. (1998) Expression of N-methyl-D-aspartate receptor subunit mRNAs in the human brain: hippocampus and cortex. J Comp Neurol. 390: 75-90.")
										.<Reference> makeItLive());
				effect_downstreameffect6.getReferenceIDs().add(
						new Reference(effect_downstreameffect6, dataSource,
								"Tovar KR, Westbrook GL. (1999) The incorporation of NMDA receptors with a distinct subunit composition at nascent hippocampal synapses in vitro. J Neurosci. 19: 4180â€“4188.")
								.<Reference> makeItLive());
				effect_downstreameffect6
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect6,
										dataSource,
										"Traynelis S, Wollmuth LP, McBain CJ, Menniti FS, Vance KM, Ogden KK, Hansen KB, Yuan H, Myers SJ, Dingledine R. (2010) Glutamate receptor ion channels: structure, regulation, and function. Pharmacol Rev. 62: 405-496.")
										.<Reference> makeItLive());
				effect_downstreameffect6
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect6,
										dataSource,
										"Zhao Y, Inayat S, Dikin DA, Singer JH, Ruoff RS, Troy JB. (2009) Patch clamp technique: review of the current state of the art and potential contributions from Nanoengineering. Proc. IMechE 222, Part N: J. Nanoengineering and Nanosystems 149. DOI: 10.1243/17403499JNN149")
										.<Reference> makeItLive());
				
				effect_downstreameffect8 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect8.setTitle("Calcium influx, Decreased");
				effect_downstreameffect8.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				effect_downstreameffect8.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				effect_downstreameffect8
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect8,
										dataSource,
										"Definition",
										"<html><b>Biological state:</b> Under physiological resting conditions of the cell, the free intracellular Ca2+ reaches around 100 nM, whereas the extracellular Ca2+ can be found at higher concentrations of 1.2 mM that under certain stimulus may invade the cell (Berridge et al, 2000). Six to seven oxygen atoms surround Ca2+, whereas the protein chelator of Ca2+ is the EF motif that is present in many proteins such as calmodulin (Clapham, 2007). The EF-hand is a helix-loop-helix calcium-binding motif in which two helices pack together at an angle of approximately 90 degrees (Lewit-Bentley and RÃ©ty, 2000). The two helices are separated by a loop region where calcium actually binds. The EF notation for the motif is derived from the notation applied to the structure of parvalbumin, in which the E and F helices were originally identified as forming this calcium-binding motif.<br><br><b>Biological compartments:</b> Ca2+ ions accumulate in the cytoplasm, cellular organelles (e.g. mitochondria and endoplasmic reticulum) and nucleus in response to diverse classes of stimuli.<br><br><b>General role in biology:</b> In order to adapt to altered stimulus from exposure to different environmental factors, cells require signal transmission. However, signalling needs messengers whose concentration is modified upon stimulus (Clapham, 2007). Ca2+ ions act as an important intracellular messenger playing the role of ubiquitous signalling molecules and consequently regulate many different cellular functions (Berridge, 2012; Hagenston and Bading, 2011). Given its important role in processes that are fundamental to all cell types, Ca2+ homeostasis is tightly regulated by intracellular and extracellular mechanisms (Barhoumi et al., 2010). Intracellular Ca2+ concentration is regulated by opening or closing channels in the plasma membrane. Additionally, the Ca2+ ions can be released from intracellular stores of the endoplasmic reticulum (ER) through ryanodine receptors (RYRs) or inositol 1,4,5-trisphosphate receptors (InsP3Rs). Ca2+ homeostasis is also regulated by the mechanisms that remove Ca2+ from the cytosol, for example pumps in both cell membrane and ER membrane. In addition, cytosolic Ca2+ regulation involves accumulation of Ca2+ in mitochondria that have the capacity to buffer the excess of cytoplasmic Ca2+ ions. In neurons, Ca2+ ions regulate many critical functions. Firstly, they contribute to dendritic electrical signalling, producing postsynaptic depolarization by the current carried by Ca2+ ions. Secondly, Ca2+ activates Ca2+-sensitive proteins such as different kinases, calcineurin and calpain, triggering signalling pathways critical for cell physiology. Modification of the gene transcription is the final outcome of the Ca2+ ions impact on long-term modifications affecting neurotransmitters release (reviewed in Neher and Sakaba, 2008), neuronal differentiation, synapse function and cell viability (Clapham, 2007; Higley and Sabatini, 2012). Thus, the Ca2+ that enters and accumulates in cytoplasm and nucleus is a central signalling molecule that regulates synapse and neuronal cell function, including learning and memory processes (Berridge, 2012; Hagenston and Bading, 2011).<html>")
										.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 0);
				effect_downstreameffect8
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect8,
										dataSource,
										"Measurment/detection",
										"<html><i>Methods that have been previously reviewed and approved by a recognized authority should be included in the Overview section above. All other methods, including those well established in the published literature, should be described here. Consider the following criteria when describing each method: 1. Is the assay fit for purpose? 2. Is the assay directly or indirectly (i.e. a surrogate) related to a key event relevant to the final adverse effect in question? 3. Is the assay repeatable? 4. Is the assay reproducible?</i><br><br>Methods that have been previously reviewed and approved by a recognized authority should be included in the Overview section above. All other methods, including those well established in the published literature, should be described here. Consider the following criteria when describing each method: 1. Is the assay fit for purpose? 2. Is the assay directly or indirectly (i.e. a surrogate) related to a key event relevant to the final adverse effect in question? 3. Is the assay repeatable? 4. Is the assay reproducible?No OECD method is available to measure intracellular Ca2+.<br><br>The gold standard method for measuring Ca2+ current through NMDA receptor is patch clamp electrophysiology (Blanke and VanDongen, 2009).<br><br>In vitro, well-established flow cytometric or high content imaging analysis with specific fluorescent dyes (Ca2+-sensitive fluorophores) such as Fura-2, Oregon Green-BAPTA, Fluo-4 and X-Rhod exist for determination of intracellular Ca2+ concentration. The use of different fluorometric calcium indicators in neuroscience and neurotoxicology have been recently reviewed by Grienberger and Konnerth (2012) and Calvo et al (2015).<br><br>Barhoumi et al. 2010 summarised all the methods to measure cytosolic Ca2+ alterations due to exposure to neurotoxic compounds, including steady state, short-term kinetic measurements of stimulated Ca2+ transients and dynamic measurements. This paper further discusses the strengths and weaknesses of each approach in intracellular Ca2+ measurements and its applicability in high throughput screening.<br><br>For quantitative estimation of Ca2+ in dendritic spines, besides of Ca2+-sensitive fluorophores the use of two-photon released caged neurotransmitters has been suggested as it allows direct stimulation of visualized spines (Higley and Sabatini, 2012). In Higley and Sabatini 2012 further technical information can be found in relation to study Ca2+ in dendritic spines.<br><br>Furthermore, there are three methods for measuring Ca2+ influx in NMDA receptors that involve the measurement of 1) relative Ca2+ permeability, 2) channel blockage by Ca2+, and 3) fractional Ca2+ currents from whole-cell currents determined in the presence of high concentrations of intracellular Fura-2 (Traynelis et al., 2010).<br><br>In vivo, two-photon Ca2+ imaging using Ca2+-sensitive fluorescent indicators that measure changes in intracellular Ca2+ concentration as a readout for suprathreshold and subthreshold neuronal activity has also been used to study learning and memory in live rodents (Chen et al., 2013) The last two decades the neuronal function of the larval and adult zebrafish has been extensively studied using Ca2+ imaging methods. By applying simple Ca2+ indicators such as dextran or acetoxymethyl esters to more powerful genetically encoded Ca2+ indicators, zebrafish provides a transparent model where live Ca2+ imaging can be successfully achieved (Kettunen, 2012).</html>")
										.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 1);
				effect_downstreameffect8.getDescriptionIDs().set(
						new DescriptionSection(effect_downstreameffect8, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Ca2+ homeostatic system is known to be highly conserved throughout evolution and is present from humans to invertebrates (Case et al., 2007).").setFormat(ContentFormat.TEXT)
								.<DescriptionSection> makeItLive(), 2);
				effect_downstreameffect8
						.getReferenceIDs()
						.add(
								new Reference(effect_downstreameffect8, dataSource,
										"Barhoumi R, Qian Y, Burghardt RC, Tiffany-Castiglioni E. (2010) Image analysis of Ca2+ signals as a basis for neurotoxicity assays: promises and challenges. Neurotoxicol Teratol. 32: 16-24.")
										.<Reference> makeItLive());
				effect_downstreameffect8.getReferenceIDs().add(
						new Reference(effect_downstreameffect8, dataSource, "Berridge MJ, Lipp P, Bootman MD. (2000) The versatility and universality of calcium signalling. Nat Rev Mol Cell Biol. 1:11-21.")
								.<Reference> makeItLive());
				effect_downstreameffect8.getReferenceIDs().add(
						new Reference(effect_downstreameffect8, dataSource, "Berridge MJ. (2012) Calcium signalling remodelling and disease. Biochem Soc Trans. 40: 297-309.").<Reference> makeItLive());
				effect_downstreameffect8
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect8,
										dataSource,
										"Blanke ML, VanDongen AMJ. (2009) Activation Mechanisms of the NMDA Receptor. In: Van Dongen AM, editor. Biology of the NMDA Receptor. Boca Raton (FL): CRC Press; Chapter 13. Available from: http://www.ncbi.nlm.nih.gov/books/NBK5274/")
										.<Reference> makeItLive());
				effect_downstreameffect8.getReferenceIDs().add(
						new Reference(effect_downstreameffect8, dataSource, "Calvo M, Villalobos C, NÃºÃ±ez L. (2015) Calcium imaging in neuron cell death. Methods Mol Biol. 1254: 73-85.").<Reference> makeItLive());
				effect_downstreameffect8
						.getReferenceIDs()
						.add(
								new Reference(effect_downstreameffect8, dataSource,
										"Case RM, Eisner D, Gurney A, Jones O, Muallem S, Verkhratsky A. (2007) Evolution of calcium homeostasis: from birth of the first cell to an omnipresent signalling system. Cell Calcium 42: 345-350.")
										.<Reference> makeItLive());
				effect_downstreameffect8
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect8,
										dataSource,
										"Chen JL, Andermann ML, Keck T, Xu NL, Ziv Y. (2013) Imaging neuronal populations in behaving rodents: paradigms for studying neural circuits underlying behavior in the mammalian cortex. J Neurosci. 33: 17631-17640.")
										.<Reference> makeItLive());
				effect_downstreameffect8.getReferenceIDs().add(new Reference(effect_downstreameffect8, dataSource, "Clapham DE. (2007) Calcium signaling. Cell 131: 1047-1058.").<Reference> makeItLive());
				effect_downstreameffect8.getReferenceIDs().add(
						new Reference(effect_downstreameffect8, dataSource, "Grienberger C, Konnerth A. (2012) Imaging calcium in neurons. Neuron 73: 862-885.").<Reference> makeItLive());
				effect_downstreameffect8.getReferenceIDs().add(
						new Reference(effect_downstreameffect8, dataSource, "Hagenston AM, Bading H. (2011) Calcium Signaling in Synapse-to-Nucleus Communication. Cold Spring Harb Perspect Biol. 3: a004564.")
								.<Reference> makeItLive());
				effect_downstreameffect8.getReferenceIDs().add(
						new Reference(effect_downstreameffect8, dataSource, "Higley MJ, Sabatini BL. (2012) Calcium signalling in dendritic spines. Cold Spring Harb Perspect Biol. 4: a005686.")
								.<Reference> makeItLive());
				effect_downstreameffect8.getReferenceIDs().add(
						new Reference(effect_downstreameffect8, dataSource, "Kettunen P. (2012) Calcium imaging in the zebrafish. Adv Exp Med Biol. 740: 1039-1071.").<Reference> makeItLive());
				effect_downstreameffect8.getReferenceIDs().add(
						new Reference(effect_downstreameffect8, dataSource, "Neher E., Sakaba T. (2008). Multiple roles of calcium ions in the regulation of neurotransmitter release. Neuron 59: 861-872.")
								.<Reference> makeItLive());
				effect_downstreameffect8
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect8,
										dataSource,
										"Traynelis S, Wollmuth LP, McBain CJ, Menniti FS, Vance KM, Ogden KK, Hansen KB, Yuan H, Myers SJ, Dingledine R. (2010) Glutamate receptor ion channels: structure, regulation, and function. Pharmacol Rev. 62: 405-496.")
										.<Reference> makeItLive());
				
				effect_downstreameffect10 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect10.setTitle("Release of BDNF, Reduced");
				effect_downstreameffect10.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				effect_downstreameffect10.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				effect_downstreameffect10
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect10,
										dataSource,
										"Definition",
										"Provide brief description of the (key) event\n\nBiological state: BDNF belongs to a family of closely related neurotrophic factors named neurotrophins and is widely expressed in the developing and mature CNS. In the rodent cortex, postnatal BDNF expression is initially low but slowly increases to reach high levels around weaning. Therefore, BDNF expression peaks at a time when both structural and functional maturation of cortical circuitry occurs. During postnatal development, BDNF levels are dynamically regulated, in part by neuronal activity dependent mechanisms (Waterhouse and Xu, 2009). Glutamate has been shown to increase the transcription and release of BDNF. Indeed, BDNF is synthesized, stored and released from glutamatergic neurons (Lessmann et al., 2003). \n\nBiological compartments: BDNF initially is synthesized as precursor proteins (proBDNF), which is processed intracellularly to be transformed in its mature form (mBDNF) after proteolytically cleaved in the synaptic cleft by plasmin which is a protease activated by tissue plasminogen activator (tPA) (Cohen-Cory et al., 2010). proBDNF is constantly secreted while tPA release and mBDNF production depends on neuronal excitation (Head et al., 2009). Storage and activity-dependent release of BDNF has been demonstrated in both dendrites and axon terminals (Waterhouse and Xu, 2009). More specifically, in hippocampus, BDNF appears to be stored in dendritic processes of neurons (Balkowiec and Katz, 2002). BDNF is abundant in cerebellum and cortex and has also been measured in cerebrospinal fluid (CSF) (Zhang et al., 2008), whole blood, plasma, serum (plasma without clotting factors) and platelets (Trajkovska et al., 2007). BDNF has been found to be produced by astrocytes under both physiological and pathological conditions (Endo, 2005; Coco et al., 2013; Nelson and Alkon, 2014). \n\nIn humans, mBDNF is sequestered in platelets, consequently BDNF can reach all tissues and organs. Lymphocytic cells have been shown to express BDNF in vitro similarly to eosinophils, dendritic cells, and endothelial cells. The visceral and airway epithelium are also significant sources of BDNF. Female reproductive system including ovaries, placenta and uterus also express BDNF (Wessels et al., 2014). \n\nGeneral role in biology: The biological functions of mBDNF are mediated by binding to tyrosine kinase B (TrkB) receptor that leads to the activation of three major intracellular signalling pathways, including MAPK, PI3K and PLCÎ³1 (SoulÃ© et al., 2006). TrkB-mediated signaling regulates gene transcription in the nucleus through the activation of several transcription factors. These genes are involved in neurite outgrowth, synaptogenesis, synapse maturation and stabilization (Pang et al., 2004; Lu et al., 2005; Nelson and Alkon, 2014). \n\nOn the other hand, proBDNF binds to the p75 neurotrophin receptor (p75NTR) and activates RhoA, a small GTPase that regulates actin cytoskeleton polymerization leading to inhibition of axonal elongation, growth cone collapse, and apoptosis (Dubreuil et al., 2003; Yamauchi et al., 2004; Head et al., 2009). \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);
				effect_downstreameffect10
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect10,
										dataSource,
										"Measurment/detection",
										"Provide a summary of the available measurment and detection methods.\n\nNo OECD methods are available to measure BDNF protein and mRNA levels. Depending on the tissue or fluid measurements distinct methods are used. \n\nBrain tissue: BDNF protein levels can be measured by commercial available antibody sandwich ELISA kits, Western blotting, immunohistochemistry and immunofluorescence. BDNF primers for different exons are available to determine mRNA levels by RT-PCR. The Bdnf gene consists of multiple alternative exons (ten in human, eight in rodents and six in lower vertebrates), and a single exon coding for the entire pro-BDNF protein (Cohen-Cory et al., 2010). \n\nCerebro-spinal fluid (CSF): There are available commercial antibody sandwich ELISA kits (Trajkovska et al., 2007) and immunobead-based multiplex assays for high throughput screening (Zhang et al., 2008). \n\nWhole blood, serum, plasma and platelets: There are several commercial double antibody sandwich ELISA kits that can be used for identification of BDNF levels in biological fluids (Trajkovska et al., 2007). \n\nMethodological considerations that have to be taken into account during sample preparation and measurement of BDNF by ELISA have been recently reviewed in Elfving et al. 2010. A study measuring BDNF by a commercially available ELISA kit in various tissues and biological liquids derived from distinct species revealed that BDNF is undetectable in mouse blood and pig plasma (Klein et al., 2011). This study also showed that in most cases BDNF levels are comparable to levels reported in humans and that there is positive correlation between blood BDNF levels and hippocampal BDNF levels in rats and pigs (Klein et al., 2011). \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 1);
				effect_downstreameffect10
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect10,
										dataSource,
										"",
										"Bdnf gene is well conserved among species, from avian species to fish and mammals (Heinrich and Pagtakhan, 2004; Aid et al., 2007; Pruunsild et al., 2007, Brenowitz, 2013). \n\nKlein et al. (2011) examined blood, serum, plasma and brain-tissue and measured BDNF levels in three different mammalian species: rat, pig, and mouse, using an ELISA method, whereas Trajkovska et al. 2007 determined BDNF levels in human blood. \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 2);
				effect_downstreameffect10.getReferenceIDs().add(
						new Reference(effect_downstreameffect10, dataSource,
								"Aid T, Kazantseva A, Piirsoo M, Palm K, Timmusk T. (2007) Mouse and rat BDNF gene structure and expression revisited. J Neurosci Res. 85: 525-535. ").<Reference> makeItLive());
				effect_downstreameffect10.getReferenceIDs().add(
						new Reference(effect_downstreameffect10, dataSource,
								"Balkowiec A, Katz DM. (2002) Cellular mechanisms regulating activity-dependent release of native brain-derived neurotrophic factor from hippocampal neurons. J Neurosci. 22: 10399-10407. ")
								.<Reference> makeItLive());
				effect_downstreameffect10.getReferenceIDs().add(
						new Reference(effect_downstreameffect10, dataSource,
								"Brenowitz EA. (2013) Testosterone and brain-derived neurotrophic factor interactions in the avian song control system. Neuroscience 239: 115-123. ").<Reference> makeItLive());
				effect_downstreameffect10
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect10,
										dataSource,
										"Coco M, Caggia S, Musumeci G, Perciavalle V, Graziano AC, Pannuzzo G, Cardile V. (2013) Sodium L-lactate differently affects brain-derived neurothrophic factor, inducible nitric oxide synthase, and heat shock protein 70 kDa production in human astrocytes and SH-SY5Y cultures.J Neurosci Res. 91: 313-320. ")
										.<Reference> makeItLive());
				effect_downstreameffect10.getReferenceIDs().add(
						new Reference(effect_downstreameffect10, dataSource,
								"Cohen-Cory S, Kidane AH, Shirkey NJ, Marshak S. (2010) Brain-derived neurotrophic factor and the development of structural neuronal connectivity. Dev Neurobiol. 70: 271-288. ")
								.<Reference> makeItLive());
				effect_downstreameffect10
						.getReferenceIDs()
						.add(
								new Reference(effect_downstreameffect10, dataSource,
										"Dubreuil CI, Winton MJ, McKerracher L. (2003) Rho activation patterns after spinal cord injury and the role of activated Rho in apoptosis in the central nervous system. J Cell Biol. 162: 233-243. ")
										.<Reference> makeItLive());
				effect_downstreameffect10
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect10,
										dataSource,
										"Elfving B, Plougmann PH, Wegener G. (2010) Detection of brain-derived neurotrophic factor (BDNF) in rat blood and brain preparations using ELISA: pitfalls and solutions. J Neurosci Methods 187: 73-77. ")
										.<Reference> makeItLive());
				effect_downstreameffect10.getReferenceIDs().add(
						new Reference(effect_downstreameffect10, dataSource,
								"Endo T. (2005) Glycans and glycan-binding proteins in brain: galectin-1-induced expression of neurotrophic factors in astrocytes. Curr Drug Targets. 6:427-436. ").<Reference> makeItLive());
				effect_downstreameffect10
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect10,
										dataSource,
										"Head BP, Patel HH, Niesman IR, Drummond JC, Roth DM, Patel PM. (2009) Inhibition of p75 neurotrophin receptor attenuates isoflurane-mediated neuronal apoptosis in the neonatal central nervous system. Anesthesiology 110: 813-825. ")
										.<Reference> makeItLive());
				effect_downstreameffect10.getReferenceIDs().add(
						new Reference(effect_downstreameffect10, dataSource,
								"Heinrich G, Pagtakhan CJ. (2004) Both 5' and 3' flanks regulate Zebrafish brain-derived neurotrophic factor gene expression. BMC Neurosci. 5: 19. ").<Reference> makeItLive());
				effect_downstreameffect10
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect10,
										dataSource,
										"Klein AB, Williamson R, Santini MA, Clemmensen C, Ettrup A, Rios M, Knudsen GM, Aznar S. (2011) Blood BDNF concentrations reflect brain-tissue BDNF levels across species. Int J Neuropsychopharmacol. 14: 347-353. ")
										.<Reference> makeItLive());
				effect_downstreameffect10.getReferenceIDs().add(
						new Reference(effect_downstreameffect10, dataSource, "Lessmann V, Gottmann K, Malcangio M. (2003) Neurotrophin secretion: current facts and future prospects. Prog Neurobiol. 69: 341-374. ")
								.<Reference> makeItLive());
				effect_downstreameffect10.getReferenceIDs().add(
						new Reference(effect_downstreameffect10, dataSource, "Lu B, Pang PT, Woo NH. (2005) The yin and yang of neurotrophin action. Nat Rev Neurosci. 6: 603-614. ").<Reference> makeItLive());
				effect_downstreameffect10.getReferenceIDs().add(
						new Reference(effect_downstreameffect10, dataSource,
								"Nelson TJ, Alkon DL. (2014) Molecular regulation of synaptogenesis during associative learning and memory. Brain Res. pii: S0006-8993(14)01660-6. doi: 10.1016/j.brainres.2014.11.054. ")
								.<Reference> makeItLive());
				effect_downstreameffect10
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect10,
										dataSource,
										"Pang PT, Teng HK, Zaitsev E, Woo NT, Sakata K, Zhen S, Teng KK, Yung WH, Hempstead BL, Lu B. (2004) Cleavage of proBDNF by tPA/plasmin is essential for long-term hippocampal plasticity. Science. 306: 487-491. ")
										.<Reference> makeItLive());
				effect_downstreameffect10.getReferenceIDs().add(
						new Reference(effect_downstreameffect10, dataSource,
								"Pruunsild P, Kazantseva A, Aid T, Palm K, Timmusk T. (2007) Dissecting the human BDNF locus: bidirectional transcription, complex splicing, and multiple promoters. Genomics. 90: 397-406. ")
								.<Reference> makeItLive());
				effect_downstreameffect10.getReferenceIDs().add(
						new Reference(effect_downstreameffect10, dataSource,
								"SouleÂ´ J, Messaoudi E, Bramham CR. (2006) Brain-derived neurotrophic factor and control of synaptic consolidation in the adult brain. Biochem Soc Trans. 34 :600-604. ")
								.<Reference> makeItLive());
				effect_downstreameffect10
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect10,
										dataSource,
										"Trajkovska V, Marcussen AB, Vinberg M, Hartvig P, Aznar S, Knudsen GM. (2007) Measurements of brain-derived neurotrophic factor: methodological aspects and demographical data. Brain Res Bull. 73: 143-149. ")
										.<Reference> makeItLive());
				effect_downstreameffect10.getReferenceIDs().add(
						new Reference(effect_downstreameffect10, dataSource,
								"Waterhouse EG, Xu B. (2009) New insights into the role of brain-derived neurotrophic factor in synaptic plasticity. Mol Cell Neurosci. 42: 81-89. ").<Reference> makeItLive());
				effect_downstreameffect10
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect10,
										dataSource,
										"Wessels JM, Wu L, Leyland NA, Wang H, Foster WG. (2014) The Brain-Uterus Connection: Brain Derived Neurotrophic Factor (BDNF) and Its Receptor (Ntrk2) Are Conserved in the Mammalian Uterus. PLoS ONE 9: e94036. ")
										.<Reference> makeItLive());
				effect_downstreameffect10
						.getReferenceIDs()
						.add(
								new Reference(effect_downstreameffect10, dataSource,
										"Yamauchi J, Chan JR, Shooter EM. (2004) Neurotrophins regulate Schwann cell migration by activating divergent signaling pathways dependent on Rho GTPases. Proc Natl Acad Sci U S A. 101: 8774-8779. ")
										.<Reference> makeItLive());
				effect_downstreameffect10
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect10,
										dataSource,
										"Zhang J, Sokal I, Peskind ER, Quinn JF, Jankovic J, Kenney C, Chung KA, Millard SP, Nutt JG, Montine TJ. (2008) CSF multianalyte profile distinguishes Alzheimer and Parkinson diseases. Am J Clin Pathol. 129: 526-529. ")
										.<Reference> makeItLive());
				
				effect_downstreameffect12 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect12.setTitle("Presynaptic release of glutamate, Reduced");
				effect_downstreameffect12.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				effect_downstreameffect12.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				effect_downstreameffect12
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect12,
										dataSource,
										"Definition",
										"Provide brief description of the (key) event\n\nBiological state: Glutamate is an amino acid with neurotransmitter function that is stored in presynaptic vesicles by the action of vesicular glutamate transporters (VGLUTs) and under physiological conditions is found at a concentration of 100 mmol/L per vesicle. Different mechanisms are involved in the release of glutamate (reviewed in Meldrum, 2000). Glutamate is mainly released from the vesicles in a Ca2+-dependent mechanism that involves N- and P/Q-type voltage-dependent Ca2+ channels, closely linked to vesicle docking sites. However, glutamate can also be released by reverse operation during reduction of Na+ and K+ gradient across the membrane like for example during cerebral ischemia. Interestingly, the synaptic release of glutamate is controlled by a wide range of presynaptic receptors that are not only glutamatergic like Group II and Group III of glutamate metabotropic receptors but also cholinergic such as nicotinic and muscarinic, adenosine (A1), kappa opioid, Î³-aminobutyric acid (GABA)B, cholecystokinin and neuropeptide Y (Y2) receptors. \n\nThe synaptic effects of glutamate are rapidly terminated by action of glutamate transporters (excitatory amino acid transporters [EAATs]) located on the plasma membrane of astrocytes and neurons. Therefore, pre-synaptically released glutamate is mostly transported via EAATs to astrocytes and only a small portion is re-uptaken from the synaptic cleft into the presynaptic terminals(Rundfeldt et al., 1994; Blanke and VanDongen, 2009). \n\nFollowing its release, glutamate exerts its effects via ionotropic and metabotropic receptors. Although glutamate is available for binding to receptors for a short time, NMDA receptors show high affinity for this specific neurotransmitter that causes their activation compared to other receptors. \n\nBiological compartments: Glutamate is the most abundant amino acid in the diet, consequently is found at higher levels in plasma compared to cerebrospinal fluid. The blood brain barrier prevents the entry of glutamate, meaning that the glutamate present in CNS is derived from de novo synthesis of this neurotransmitter relying on the recycling of the main resources. Glutamine and Î±-ketoglutarate are the major precursors of glutamate. Glutamine is converted via phosphate-activated glutaminase to glutamate and ammonia, whereas Î±-ketoglutarate is transaminated into glutamate (Platt, 2007). In glial cells, the glutamate is metabolised via glutamine synthase into glutamine or metabolised into Î±-ketoglutarate. These products are actively transported out of the glial cells and back into the pre-synaptic terminals for subsequent re-synthesis and storage of glutamate. \n\nFive transporters of glutamate have been identified in the CNS. Two are expressed predominantly in glia and three in neurons (reviewed in Meldrum, 2000). The presence of glutamate has also been demonstrated in other tissues and organs as glutamate receptors have been found to be expressed in pancreatic Î²-cells, osteoblasts and osteoclasts of bones (Nedergaard et al., 2002). \n\nGeneral role in biology: In mature nervous system, glutamate is known to play important role in synaptic plasticity. Similarly important is this neurotransmitter during development where it regulates neurogenesis, neurite outgrowth, synaptogenesis and apoptosis (reviewed in Mattson, 1996; Meldrum, 2000; Mattson, 2008). \n\nThe proper functioning of the central nervous system relays on the physiological homeostasis between glutamate and GABA, creating the opposite excitatory/inhibitory forces in the brain. Together, these two neurotransmitters constitute more than 90% of all neurotransmission. If this homeostasis is disturbed it could lead to anxiety disorders (Wieronska et al., 2015). \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);
				effect_downstreameffect12
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect12,
										dataSource,
										"Measurment/detection",
										"Provide a summary of the available measurment and detection methods.\n\nNo OECD methods are available to measure glutamate release. \n\nThere are radioactive assays like [3H]glutamate release assay and spectrophotometric commercially available kits to measure glutamate in cell culture medium (release) or intracellular (cell lysate) using LC-MS. Furthermore, neurotransmitters including glutamate can be measured by HPLC with fluorescence detector. \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 1);
				effect_downstreameffect12
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect12,
										dataSource,
										"Blanke ML, VanDongen AMJ. (2009) Activation Mechanisms of the NMDA Receptor. In: Van Dongen AM, editor. Biology of the NMDA Receptor. Boca Raton (FL): CRC Press; Chapter 13. Available from: http://www.ncbi.nlm.nih.gov/books/NBK5274/ ")
										.<Reference> makeItLive());
				effect_downstreameffect12.getReferenceIDs().add(
						new Reference(effect_downstreameffect12, dataSource, "Cleland TA. (1996) Inhibitory glutamate receptor channels. Mol Neurobiol. 13: 97-136. ").<Reference> makeItLive());
				effect_downstreameffect12
						.getReferenceIDs()
						.add(
								new Reference(effect_downstreameffect12, dataSource,
										"Mattson MP. (1996) Calcium and free radicals: mediators of neurotrophic factor and excitatory transmitter regulated developmental plasticity and cell death. Perspect Dev Neurobiol. 3: 79-91. ")
										.<Reference> makeItLive());
				effect_downstreameffect12.getReferenceIDs().add(
						new Reference(effect_downstreameffect12, dataSource, "Mattson MP. (2008) Glutamate and neurotrophic factors in neuronal plasticity and disease. Ann N Y Acad Sci. 1144: 97-112. ")
								.<Reference> makeItLive());
				effect_downstreameffect12.getReferenceIDs().add(
						new Reference(effect_downstreameffect12, dataSource, "Meldrum BS. (2000) Glutamate as a neurotransmitter in the brain: review of physiology and pathology. J Nutr. 130: 1007S-1015S. ")
								.<Reference> makeItLive());
				effect_downstreameffect12.getReferenceIDs().add(
						new Reference(effect_downstreameffect12, dataSource, "Nedergaard M, Takano T, Hansen AJ. (2002) Beyond the role of glutamate as a neurotransmitter. Nat Rev Neurosci. 3: 748-755. ")
								.<Reference> makeItLive());
				effect_downstreameffect12.getReferenceIDs().add(
						new Reference(effect_downstreameffect12, dataSource, "Platt SR. (2007) The role of glutamate in central nervous system health and disease-a review. Vet J. 173: 278-286. ")
								.<Reference> makeItLive());
				effect_downstreameffect12
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect12,
										dataSource,
										"Rundfeldt C, WlaÅº P, LÃ¶scher W. (1994) Anticonvulsant activity of antagonists and partial agonists for the NMDAR-associated glycine site in the kindling model of epilepsy. Brain Res. 653: 125-130. ")
										.<Reference> makeItLive());
				effect_downstreameffect12
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect12,
										dataSource,
										"Wieronska JM, KÅ‚eczek N, WoÅºniak M, Gruca P, Å�asoÅ„-Tyburkiewicz M, Papp M, BraÅ„ski P, Burnat G, Pilc A. (2015) mGluâ‚…-GABAB interplay in animal models of positive, negative and cognitive symptoms of schizophrenia.Neurochem Int. 88: 97-109. ")
										.<Reference> makeItLive());
				
				effect_downstreameffect13 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect13.setTitle("Cell death, N/A");
				effect_downstreameffect13.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				effect_downstreameffect13.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				effect_downstreameffect13
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect13,
										dataSource,
										"Definition",
										"Provide brief description of the (key) event\n\nTwo types of cell death can be distinguished by morphological features, although it is likely that these are two ends of a spectrum with possible intermediate forms. Apoptosis involves shrinkage, nuclear disassembly, and fragmentation of the cell into discrete bodies with intact plasma membranes. These are rapidly phagocytosed by neighbouring cells. An important feature of apoptosis is the requirement for adenosine triphosphate (ATP) to initiate the execution phase. In contrast, necrotic cell death is characterised by cell swelling and lysis. This is usually a consequence of profound loss of mitochondrial function and resultant ATP depletion, leading to loss of ion homeostasis, including volume regulation, and increased Ca2+. The latter activates a number of nonspecific hydrolases (i.e. proteases, nucleases, and phospholipases) as well as calcium dependent kinases. Activation of calpain I, the Ca2+-dependent cysteine protease cleaves the death-promoting Bcl-2 family members Bid and Bax which translocate to mitochondrial membranes, resulting in release of truncated apoptosis-inducing factor (tAIF), cytochrome c and endonuclease in the case of Bid and cytochrome c in the case of Bax. tAIF translocates to cell nuclei, and together with cyclophilin A and phosphorylated histone H2AX (Î³H2AX) is responsible for DNA cleavage, a feature of programmed necrosis. Activated calpain I has also been shown to cleave the plasma membrane Na+â€“Ca2+ exchanger, which leads to build-up of intracellular Ca2+, which is the source of additional increased intracellular Ca2+. Cytochrome c in cellular apoptosis is a component of the apoptosome. \n\nDNA damage activates nuclear poly(ADP-ribose) polymerase-1(PARP-1), a DNA repair enzyme. PARP-1 forms poly(ADP-ribose) polymers, to repair DNA, but when DNA damage is extensive, PAR accumulates, exits cell nuclei and travels to mitochondrial membranes, where it, like calpain I, is involved in AIF release from mitochondria. A fundamental distinction between necrosis and apoptosis is the loss of plasma membrane integrity; this is integral to the former but not the latter. As a consequence, lytic release of cellular constituents promotes a local inflammatory reaction, whereas the rapid removal of apoptotic bodies minimises such a reaction. The distinction between the two modes of death is easily accomplished in vitro but not in vivo. Thus, although claims that certain drugs induce apoptosis have been made, these are relatively unconvincing. DNA fragmentation can occur in necrosis, leading to positive TUNEL staining. Conversely, when apoptosis is massive, it can exceed the capacity for rapid phagocytosis, resulting in the eventual appearance of secondary necrosis. \n\nTwo alternative pathways - either extrinsic (receptor-mediated) or intrinsic (mitochondria-mediated) - lead to apoptotic cell death. The initiation of cell death begins either at the plasma membrane with the binding of TNF or FasL to their cognate receptors or within the cell. The latter is due to the occurrence of intracellular stress in the form of biochemical events such as oxidative stress, redox changes, covalent binding, lipid peroxidation, and consequent functional effects on mitochondria, endoplasmic reticulum, microtubules, cytoskeleton, or DNA. The intrinsic mitochondrial pathway involves the initiator, caspase-9, which, when activated, forms an â€œapoptosomeâ€� in the cytosol, together with cytochrome c, which translocates from mitochondria, Apaf-1 and dATP. The apoptosome activates caspase-3, the central effector caspase, which in turn activates downstream factors that are responsible for the apoptotic death of a cell (Fujikawa, 2015). Intracellular stress either directly affects mitochondria or can lead to effects on other organelles, which then send signals to the mitochondria to recruit participation in the death process (Fujikawa, 2015; Malhi et al., 2010). Constitutively expressed nitric oxide synthase (nNOS) is a Ca2+-dependent cytosolic enzyme that forms nitric oxide (NO) from L-arginine, and NO reacts with the free radical such as superoxide (O2âˆ’) to form the very toxic free radical peroxynitrite (ONOOâˆ’). Free radicals such as ONOOâˆ’, O2âˆ’ and hydroxyl radical (OHâˆ’) damage cellular membranes and intracellular proteins, enzymes and DNA (Fujikawa, 2015; Kaplowitz, 2002; Kroemer et al., 2009; Malhi et al., 2010). \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);
				effect_downstreameffect13
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect13,
										dataSource,
										"Measurment/detection",
										"Provide a summary of the available measurment and detection methods.\n\nNecrosis: \n\nLDH is a soluble cytoplasmic enzyme that is present in almost all cells and is released into extracellular space when the plasma membrane is damaged. To detect the leakage of LDH into cell culture medium, a tetrazolium salt is used in this assay. In the first step, LDH produces reduced nicotinamide adenine dinucleotide (NADH) when it catalyses the oxidation of lactate to pyruvate. In the second step, a tetrazolium salt is converted to a colored formazan product using newly synthesised NADH in the presence of an electron acceptor. The amount of formazan product can be colorimetrically quantified by standard spectroscopy. Because of the linearity of the assay, it can be used to enumerate the percentage of necrotic cells in a sample (Chan et al., 2013).\n\nThe MTT assay is a colorimetric assay for assessing cell viability. NAD(P)H-dependent cellular oxidoreductase enzymes may reflect the number of viable cells present. These enzymes are capable of reducing the tetrazolium dye MTT 3-(4,5-dimethylthiazol-2-yl)-2,5-diphenyltetrazolium bromide to its insoluble formazan, which has a purple color. Other closely related tetrazolium dyes including XTT, MTS and the WSTs. Tetrazolium dye assays can also be used to measure cytotoxicity (loss of viable cells) or cytostatic activity (shift from proliferation to quiescence) of potential medicinal agents and toxic materials. MTT assays are usually done in the dark since the MTT reagent is sensitive to light (Berridge et al., 2005). \n\nPropidium iodide (PI) is an intercalating agent and a fluorescent molecule used to stain necrotic cells. It is cell membrane impermeant so it stains only those cells where the cell membrane is destroyed. When PI is bound to nucleic acids, the fluorescence excitation maximum is 535 nm and the emission maximum is 617 nm (Moore et al., 1998). \n\n	Apoptosis: \n\nTUNEL is a common method for detecting DNA fragmentation that results from apoptotic signalling cascades. The assay relies on the presence of nicks in the DNA which can be identified by terminal deoxynucleotidyl transferase or TdT, an enzyme that will catalyse the addition of dUTPs that are secondarily labeled with a marker. It may also label cells that have suffered severe DNA damage. \n\nCaspase activity is measured by fluorescence. During apoptosis, mainly caspase-3 and -7 cleave PARP to yield an 85 kDa and a 25 kDa fragment. PARP cleavage is considered to be one of the classical characteristics of apoptosis. Antibodies to the 85 kDa fragment of cleaved PARP or to caspase-3 both serve as markers for apoptotic cells that can be monitored using immunofluorescence (Li et al., 2004). \n\nHoechst 33342 staining: Hoechst dyes are cell-permeable and bind to DNA in live or fixed cells. Therefore, these stains are often called supravital, which means that cells survive a treatment with these compounds. The stained, condensed or fragmented DNA is a marker of apoptosis (Didenko, 2002; Kubbies and Rabinovitch, 1983). \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 1);
				effect_downstreameffect13.getReferenceIDs().add(
						new Reference(effect_downstreameffect13, dataSource,
								"Berridge, M.V., P.M. Herst and A.S. Tan (2005), Tetrazolium dyes as tools in cell biology: new insights into their cellular reduction. Biotechnol An Rev. 11: 127-152.")
								.<Reference> makeItLive());
				effect_downstreameffect13.getReferenceIDs().add(
						new Reference(effect_downstreameffect13, dataSource,
								"Chan, F.K., K. Moriwaki and M.J. De Rosa (2013), Detection of necrosis by release of lactate dehydrogenase (LDH) activity. Methods Mol Biol. 979: 65-70. ").<Reference> makeItLive());
				effect_downstreameffect13.getReferenceIDs()
						.add(
								new Reference(effect_downstreameffect13, dataSource,
										"Fink, S.L., and B.T. Cookson (2005), Apoptosis, pyroptosis, and necrosis: mechanistic description of dead and dying eukaryotic cells. Infect Immun. 73: 1907-1916. ")
										.<Reference> makeItLive());
				effect_downstreameffect13.getReferenceIDs().add(
						new Reference(effect_downstreameffect13, dataSource, "Fujikawa, D.G. (2015), The role of excitotoxic programmed necrosis in acute brain injury. Comput Struct Biotechnol J. 13: 212-221. ")
								.<Reference> makeItLive());
				effect_downstreameffect13.getReferenceIDs().add(
						new Reference(effect_downstreameffect13, dataSource,
								"Kaplowitz, N. (2002), Biochemical and Cellular Mechanisms of Toxic Liver Injury, Semin Liver Dis, vol. 22, no. 2,  www.medscape.com/viewarticle/433631 accessed on 20 January 2016.")
								.<Reference> makeItLive());
				effect_downstreameffect13.getReferenceIDs().add(
						new Reference(effect_downstreameffect13, dataSource,
								"Kroemer, G. et al. (2009), Classification of cell death: recommendations of the Nomenclature Committee on Cell Death. Cell Death Differ. 16: 3-11.").<Reference> makeItLive());
				effect_downstreameffect13
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect13,
										dataSource,
										"Kubbies, M., and P.S. Rabinovitch (1983), Flow cytometric analysis of factors which influence the BrdUrd-Hoechst quenching effect in cultivated human fibroblasts and lymphocytes. Cytometry 3: 276-281.")
										.<Reference> makeItLive());
				effect_downstreameffect13.getReferenceIDs().add(
						new Reference(effect_downstreameffect13, dataSource, "Li, P. et al. (2004), Mitochondrial activation of apoptosis. Cell 116: S57-59. ").<Reference> makeItLive());
				effect_downstreameffect13.getReferenceIDs().add(
						new Reference(effect_downstreameffect13, dataSource, "Loo, D.T. (2002), TUNEL Assay an overview of techniques. Methods in Molecular Biology, vol. 203: In ").<Reference> makeItLive());
				effect_downstreameffect13.getReferenceIDs().add(
						new Reference(effect_downstreameffect13, dataSource, "Situ Detection of DNA Damage, chapter 2, Didenko VV (ed.), Humana Press Inc. ").<Reference> makeItLive());
				effect_downstreameffect13.getReferenceIDs().add(
						new Reference(effect_downstreameffect13, dataSource, "Malhi, H. et al. (2010), Hepatocyte death: a clear and present danger. Physiol Rev. 90: 1165-1194. ").<Reference> makeItLive());
				effect_downstreameffect13.getReferenceIDs().add(
						new Reference(effect_downstreameffect13, dataSource, "Moore, A. et al. (1998), Simultaneous measurement of cell cycle and apoptotic cell death. Methods Cell Biol. 57: 265-278.  ")
								.<Reference> makeItLive());
				
				effect_downstreameffect14 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect14.setTitle("Dendritic morphology, Aberrant");
				effect_downstreameffect14.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				effect_downstreameffect14.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				effect_downstreameffect14
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect14,
										dataSource,
										"Definition",
										"Provide brief description of the (key) event\n\nBiological state: After becoming post-mitotic and during the differentiation process, neuronal cells undergo lengthening, branching, dendrite and dendritic spine formation (Scott and Luo, 2001). In human, dendrites appear as early as 13.5 weeks gestation in the subplate neurons while arborization begins only after 26 weeks (Mrzljak et al., 1988 and Mrzljak et al., 1990). In rodents, during the first postnatal week, both pyramidal and nonpyramidal neurons go through extensive and fast dendrite growth, branching, and elaboration. Dendrite arbor's capacity and complexity continue to increase in the second and third postnatal week, however, much slower. During the same developmental window, dendritic spines begin to appear as a group. The first spines look like filopodia (Dailey and Smith, 1996; Fiala et al., 1998). Filopodia can grow and retract within seconds to minutes, permitting them to explore and identify appropriate presynaptic targets (Dailey and Smith, 1996). As dendrite spines mature, these long and thin structures change and the spines shorten and acquire a bulbous ending or â€˜headâ€™ (Dailey and Smith, 1996). At this final stage of dendrite growth, a neuron possesses a dynamic dendrite tree, which has a greater potential for connectivity and synapse creation because of dendritic spine formation. \n\nBiological compartments: Dendritic morphology determines many aspects of neuronal function, including action potential propagation and information processing. Postsynaptic density-95 (PSD-95), a protein involved in dendritic spine maturation and clustering of synaptic signalling proteins, plays a critical role in regulating dendrite outgrowth and branching, independent of its synaptic functions. In immature neurons, over-expression of PSD-95 decreases the proportion of primary dendrites that undergo additional branching, resulting in a marked reduction of secondary dendrite number. Conversely, knocking down PSD-95 protein in immature neurons increases secondary dendrite number. Binding of cypin to PSD-95 (that regulates PSD-95 location) correlates with formation of stable dendrite branches. Finally, overexpression of PSD-95 in COS-7 cells disrupts microtubule organization, indicating that PSD-95 may modulate microtubules to regulate dendritic branching. Proteins primarily involved in synaptic functions can also play developmental roles in shaping how a neuron patterns its dendrite branches (Kornau et al., 1995). New spines containing PSDs are formed by conversion of dynamic filopodia-like spine precursors in which PSDs appeared de novo, or by direct extension of spines or spine precursors carrying preformed PSDs from the shaft. PSDs are therefore highly dynamic structures that can undergo rapid structural alteration within dendrite shafts, spines and spine precursors, permitting rapid formation and re-modelling of synaptic connections in developing CNS tissues. \n\nDendritic spines are important sites of excitatory synaptic transmission and changes in the strength of these synapses are likely to underlie important higher brain functions such as learning and memory. Spines form biochemical compartments for isolating reactions that occur at one synapse from those at other synapses thereby providing a possible way to ensure the specificity of connections between neurons in the brain. \n\nThe stages of dendrite development have been clearly described in neurons located in the developing rodent cortex and hippocampus (Dailey and Smith, 1996; Fiala et al., 1998; Redmond, 2008) and human prefrontal cortex (Mrzljak et al., 1988; Mrzljak et al., 1990). \n\nGeneral role in biology: Functionally, dendrites serve as post-synaptic part of a synapse, playing a critical role in the processing of information transmitted through synapses. They receive the majority of synaptic inputs comparing to the soma or the axon. Consequently, it is not surprising that postsynaptic activity is closely related to the properties of the dendritic arbor itself, implying that the dendrites strongly influence and control synaptic transmission and plasticity (SjÃ¶strÃ¶m et al., 2008). \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);
				effect_downstreameffect14
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect14,
										dataSource,
										"Measurment/detection",
										"Provide a summary of the available measurment and detection methods.\n\nElaboration of dendritic processes is measured from electron and fluorescent micrographs. These processes are identified primarily by the presence of microtubule associated protein 2 (MAP-2) and the absence of components characteristic of axons and glia (e.g. small vesicles, myelin, glial filaments).These measurements can also be carried out by automated imaging systems in cells prepared for immunohistochemistry with specific antibodies that recognise MAP-2 (Harrill and Mundy, 2011). \n\nTwo-photon time-lapse images can be used to visualise dendrites in GFP-transfected neurons, whereas Golgi Stain Kit is used to measure both dendrites and dendritic spines. A combination of Golgi-Cox and immunofluorescence using confocal microscopy has also been suggested for the visualisation of dendrites in brain slices derived either from rodents or non-human primates (Levine et al., 2013). \n\nThe morphological analysis of neurons, include the use of fluorescent markers, such as DiI (1,1'-dioctadecyl-3,3,3',3'-tetramethylindocarbocyanine perchlorate) that permits not only the visualisation of detailed dendritic arborizations and spines in cell culture and tissue sections but also permits the quantitative analysis of dendritic spines (Cheng et al., 2014). \n\nFluorescent labelling for MARCM (mosaic analysis with a repressible cell marker) system can also be used but only in case of transparent larval body wall found in Drosophila. \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 1);
				effect_downstreameffect14
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect14,
										dataSource,
										" ",
										" Evidence Supporting Taxonomic Applicability\n\nDrosophila is one of the best-studied models that allow examining how diverse dendrite morphologies are formed during development (Grueber et al., 2002). The chick embryo (Gallus domesticus) is another important model in vertebrate developmental neurobiology where the dendritic arbor development has been extensively studied (Rubel and Fritzsch, 2002). Different methods have also been used to study dendritic arborization and spine formation in brain sections and cell cultures derived by rodents (Stansfield et al., 2012) and primates (Khazipov et al., 2001). \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 2);
				effect_downstreameffect14.getReferenceIDs().add(
						new Reference(effect_downstreameffect14, dataSource,
								"Cheng C, Trzcinski O, Doering LC. (2014) Fluorescent labeling of dendritic spines in cell cultures with the carbocyanine dye \"DiI\". Front Neuroanat. 8: 30. ").<Reference> makeItLive());
				effect_downstreameffect14.getReferenceIDs().add(
						new Reference(effect_downstreameffect14, dataSource, "Dailey ME, Smith SJ. (1996) The dynamics of dendritic structure in developing hippocampal slices. J Neurosci. 16: 2983-2994. ")
								.<Reference> makeItLive());
				effect_downstreameffect14.getReferenceIDs().add(
						new Reference(effect_downstreameffect14, dataSource,
								"Fiala JC, Feinberg M, Popov V, Harris KM. (1998) Synaptogenesis via dendritic filopodia in developing hippocampal area CA1. J Neurosci. 18: 8900-8911. ").<Reference> makeItLive());
				effect_downstreameffect14.getReferenceIDs().add(
						new Reference(effect_downstreameffect14, dataSource, "Grueber WB, Jan LY, Jan YN. (2002) Tiling of the Drosophila epidermis by multidendritic sensory neurons. Development 129: 2867-2878. ")
								.<Reference> makeItLive());
				effect_downstreameffect14.getReferenceIDs().add(
						new Reference(effect_downstreameffect14, dataSource, "Harrill JA, Mundy WR. (2011) Quantitative assessment of neurite outgrowth in PC12 cells. Methods Mol Biol. 758: 331-348. ")
								.<Reference> makeItLive());
				effect_downstreameffect14
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect14,
										dataSource,
										"Khazipov R, Esclapez M, Caillard O, Bernard C, Khalilov I, Tyzio R, Hirsch J, Dzhala V, Berger B, Ben-Ari Y. (2001) Early development of neuronal activity in the primate hippocampus in utero. J Neurosci. 21: 977097-81. ")
										.<Reference> makeItLive());
				effect_downstreameffect14
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect14,
										dataSource,
										"Kornau HC, LT Schenker, MB Kennedy, PH Seeburg. Domain interaction between NMDA receptor subunits and the postsynaptic density protein PSD-95. Science 22 September 1995: Vol. 269 no. 5231 pp. 1737-1740 ")
										.<Reference> makeItLive());
				effect_downstreameffect14
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect14,
										dataSource,
										"Levine ND, Rademacher DJ, Collier TJ, O'Malley JA, Kells AP, San Sebastian W, Bankiewicz KS, Steece-Collier K. (2013) Advances in thin tissue Golgi-Cox impregnation: fast, reliable methods for multi-assay analyses in rodent and non-human primate brain. J Neurosci Methods 213: 214-227. ")
										.<Reference> makeItLive());
				effect_downstreameffect14.getReferenceIDs().add(
						new Reference(effect_downstreameffect14, dataSource,
								"Mrzljak L, Uylings HB, Kostovic I, Van Eden CG. (1988). Prenatal development of neurons in the human prefrontal cortex: I. A qualitative Golgi study. J Compar Neurol. 271: 355-386. ")
								.<Reference> makeItLive());
				effect_downstreameffect14.getReferenceIDs().add(
						new Reference(effect_downstreameffect14, dataSource,
								"Mrzljak L, Uylings HB, Van Eden CG, Judas M. (1990). Neuronal development in human prefrontal cortex in prenatal and postnatal stages. Prog Brain Res. 85: 185-222. ")
								.<Reference> makeItLive());
				effect_downstreameffect14.getReferenceIDs().add(
						new Reference(effect_downstreameffect14, dataSource, "Redmond L. (2008) Translating neuronal activity into dendrite elaboration: signaling to the nucleus. Neurosignals 16: 194-208. ")
								.<Reference> makeItLive());
				effect_downstreameffect14.getReferenceIDs().add(
						new Reference(effect_downstreameffect14, dataSource, "Rubel EW, Fritzsch B. (2002) Auditory system development: primary auditory neurons and their targets. Annu Rev Neurosci. 25: 51-101. ")
								.<Reference> makeItLive());
				effect_downstreameffect14.getReferenceIDs().add(
						new Reference(effect_downstreameffect14, dataSource, "Scott EK, Luo L: (2001) How do dendrites take their shape? Nat Neurosci. 4: 359-365. ").<Reference> makeItLive());
				effect_downstreameffect14.getReferenceIDs().add(
						new Reference(effect_downstreameffect14, dataSource, "SjÃ¶strÃ¶m PJ, Rancz EA, Roth A, HÃ¤usser M. (2008) Dendritic excitability and synaptic plasticity. Physiol Rev. 88: 769-840. ")
								.<Reference> makeItLive());
				effect_downstreameffect14
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect14,
										dataSource,
										"Stansfield KH, Pilsner JR, Lu Q, Wright RO, Guilarte TR. (2012) Dysregulation of BDNF-TrkB signaling in developing hippocampal neurons by Pb(2+): implications for an environmental basis of neurodevelopmental disorders. Toxicol Sci. 127: 277-295. ")
										.<Reference> makeItLive());
				
				effect_downstreameffect18 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect18.setTitle("Synaptogenesis, Decreased");
				effect_downstreameffect18.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				effect_downstreameffect18.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				effect_downstreameffect18
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect18,
										dataSource,
										"Definition",
										"Provide brief description of the (key) event\n\nBiological state: Synaptogenesis is a multi-step process that is crucial for brain development and involves the formation of synapses. It follows axonal migration, at which stage presynaptic and postsynaptic differentiation occurs (Garner et al., 2002). \"Synaptic assembly\" that refers to the gathering of the appropriate components and \"synaptic formation\" that is defined by the mechanisms involved in recruitment of molecules required for differentiation, stabilization and maturation of synapse, are the main phases that characterise synaptogenesis (ColÃ³n-Ramos, 2009). Elimination is a physiological step involved in synaptogenesis regarding the synapses that fail to get stabilised and mature. \n\nThe first step is the recognition and the establishment of contact between an axon and a dendritic spine in which pre- and postsynaptic neurons play important role. The presynaptic differentiation occurs followed by excretion of neurotransmitters that bind to appropriate receptors located on the target spine. However, a postsynaptic neuron does not passively receive guidance from a presynaptic axon but are the same dendritic filopodia that gradually are transformed into spines that select and engage their presynaptic neurons. The transformation of dendritic filopodia into dendritic spines that involves the expression of the whole postsynaptic machinery such as postsynaptic density (PSD), receptor subunits, scaffolding proteins and actin cytoskeleton, is the first step to give nascent synapses. However, to become functional and mature these synapses need an important number of cell-cell interactions, including stimulation from glutamatergic synapses as well as the influence of neurotrophic factors (Munno and Syed, 2003). \n\nHowever, all this is true for glutamatergic synapses because GABAergic synapses do not appear in dendritic spines, but rather form on dendritic shafts, nerve cell somata and axon initial segments. These inhibitory synapses besides their distinct location are also structurally different compared to excitatory synapses (reviewed in Gatto and Broadie, 2010). \n\nBiological compartments: Synaptogenesis is spatially and temporally strictly controlled process. It does not happen in a uniform way in all brain regions and there important differences between the times of appearance of the main two types of synapses (reviewed in Erecinska et al., 2004). For example, in rat hippocampus excitatory synapses are well established or fully mature within the two first postnatal weeks, whereas inhibitory synapses cannot be found prior to PND 18, after which it increases steadily to reach adult levels at PND 28. In addition, in rat neostriatal neurons the excitatory responses to both cortical and thalamic stimuli can be observed by PND 6, but the long-lasting hyperpolarization and late depolarization is never seen before PND 12. \n\nStructural remodelling of synapses and formation of new synaptic contacts has been postulated as a possible mechanism underlying the late phase of long-term potentiation (LTP), a form of plasticity which is involved in learning and memory. LTP induction results in a sequence of morphological changes consisting of a transient remodelling of the postsynaptic membrane followed by a marked increase in the proportion of axon terminals contacting two or more dendritic spines. Three-dimensional reconstruction revealed that these spines arose from the same dendrite. As pharmacological blockade of LTP prevented these morphological changes, it is suggested that LTP is associated with the formation of new, mature and probably functional synapses contacting the same presynaptic terminal and thereby duplicating activated synapses (Erik et al., 2006). \n\nIn human, synaptogenesis does not happen at the same time in all brain regions, as the prefrontal cortex lags behind in terms of synapse formation compared to the auditory and visual cortices. In contrast, synaptogenesis appears to proceed concurrently in different brain areas for rhesus monkey (Erecinska et al., 2004). \n\nGeneral role in biology: The period of rapid synaptogenesis or the so-called brain growth spurt is considered one of the most important processes that take place during brain development (Garner et al., 2002). This process is crucial not only in neurodevelopment but also plays a vital role in synaptic plasticity, learning and memory and adaptation throughout life. Without this process no complex brain network can be established as synapse is the fundamental unit of connectivity and communication between neurons (Tau and Peterson, 2010). Cell adhesion represents the most direct way of coordinating synaptic connectivity in the brain. Recent evidence highlights the importance of a trans-synaptic interaction between postsynaptic neuroligins and presynaptic neurexins. These transmembrane molecules bind each other extracellularly to promote adhesion between dendrites and axons, facilitating synapse establishment (Dean and Dresbach, 2006). Furthermore, the number of excitatory versus inhibitory synapses created at single neuron dictates neuronal excitability and function (Schummers et al., 2002). \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);
				effect_downstreameffect18
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect18,
										dataSource,
										"Measurment/detection",
										"Provide a summary of the available measurment and detection methods.\n\nThere is no OECD advised method for measuring synaptogenesis. \n\nAnatomical methods can be used to structurally estimate the number of excitatory or inhibitory synapses. Immunostaining can be employed with specific antibodies that recognize vesicular glutamate transporters (VGLUTs) and the postsynaptic density protein-95 kDa (PSD-95) that are characteristic of excitatory synapses, while inhibitory synapses are identified by the presence of the vesicular GABA (VGAT) and vesicular inhibitory amino acid (VIAAT) transporters and the postsynaptic adaptor protein gephryin (Gatto and Broadie, 2010). There are commercial available synaptogenesis assay kits that rely on the immunostaining of cells with MAP-2, PSD-95 and synaptophysin. Some other presynaptic (Bassoon) and postsynaptic (ProSAP1/Shank2) markers have been suggested and showed to correlate well with the ultrastructural studies in cultured hippocampus primary cells (Grabrucker et al., 2009). Electron microscopy can also be applied to assess the prevalence of excitatory and inhibitory synapses amongst convergent contacts (Megias et al., 2001). Recently, a high content image analysis based on RNAi screening protocols has been suggested as a useful tool to create imaging algorithm for use in both in vitro and in vivo synaptic punctae analysis (Nieland et al., 2014). \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 1);
				effect_downstreameffect18
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect18,
										dataSource,
										" ",
										" Evidence Supporting Taxonomic Applicability\n\nThe mechanisms governing synapse formation is considered conserved among both vertebrates and invertebrates (Munno and Syed, 2003). Invertebrates have served as simple animal models to study synapse formation. Indeed, ColÃ³n-Ramos (2009) has recently reviewed the early developmental events that take place in the process of synaptogenesis pointing out the importance of this process in neural network formation and function. The experimental evaluation of synaptogenesis has been performed using invertebrates and in particular C. elegans and Drosophila as well as vertebrates (ColÃ³n-Ramos, 2009). \n\nThis vulnerable period of synaptogenesis appears to happen in different developmental stages across species. For example, in rodents primarily synaptogenesis occurs during the first two weeks after birth (Bai et al., 2013). For rhesus monkeys, this period ranges from approximately 115-day gestation up to PND 60 (Bai et al., 2013). In humans, it starts from the third trimester of pregnancy and continues 2-3 years following birth (Bai et al., 2013). \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 2);
				effect_downstreameffect18.getReferenceIDs().add(
						new Reference(effect_downstreameffect18, dataSource,
								"Bai X, Twaroski D, Bosnjak ZJ. (2013) Modeling anesthetic developmental neurotoxicity using human stem cells. Semin Cardiothorac Vasc Anesth. 17: 276-287. ").<Reference> makeItLive());
				effect_downstreameffect18.getReferenceIDs().add(
						new Reference(effect_downstreameffect18, dataSource, "ColÃ³n -Ramos DA. (2009) Synapse formation in developing neural circuits. Curr Top Devel Biol. 87: 53-79. ").<Reference> makeItLive());
				effect_downstreameffect18.getReferenceIDs().add(
						new Reference(effect_downstreameffect18, dataSource,
								"Dean C, Dresbach T. (2006) Neuroligins and neurexins: linking cell adhesion, synapse formation and cognitive function. Trends Neurosci. 29:21-29. ").<Reference> makeItLive());
				effect_downstreameffect18.getReferenceIDs().add(
						new Reference(effect_downstreameffect18, dataSource, "Erecinska M, Cherian S, Silver IA. (2004) Energy metabolism in mammalian brain during development. Prog Neurobiol. 73: 397-445. ")
								.<Reference> makeItLive());
				effect_downstreameffect18
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect18,
										dataSource,
										"Erik I. Charyc, Barbara F. Akum, Joshua S. Goldber, Rebecka J. JÃ¶rnsten, Christopher Rongo, James Q. Zheng and Bonnie L. Firestein. Activity-Independent Regulation of Dendrite Patterning by Postsynaptic Density Protein PSD-95. Journal of Neuroscience 2006, 26(40): 10164-10176. ")
										.<Reference> makeItLive());
				effect_downstreameffect18.getReferenceIDs().add(
						new Reference(effect_downstreameffect18, dataSource, "Garner CC, Zhai RC, Gundelfinger ED, Ziv NE. (2002) Molecular mechanisms of CNS synaptogenesis. Cell Press 25: 243-250. ")
								.<Reference> makeItLive());
				effect_downstreameffect18.getReferenceIDs().add(
						new Reference(effect_downstreameffect18, dataSource,
								"Gatto CL, Broadie K. (2010) Genetic controls balancing excitatory and inhibitory synaptogenesis in neurodevelopmental disorder models. Front Syn Neurosci. 2: 4. ").<Reference> makeItLive());
				effect_downstreameffect18.getReferenceIDs().add(
						new Reference(effect_downstreameffect18, dataSource,
								"Grabrucker A, Vaida B, Bockmann J, Boeckers TM. (2009) Synaptogenesis of hippocampal neurons in primary cell culture. Cell Tissue Res. 338: 333-341. ").<Reference> makeItLive());
				effect_downstreameffect18.getReferenceIDs().add(
						new Reference(effect_downstreameffect18, dataSource,
								"Megias M, Emri Z, Freund TF, Gulyas AI. (2001) Total number and distribution of inhibitory and excitatory synapses on hippocampal CA1 pyramidal cells. Neuroscience 102: 527-540. ")
								.<Reference> makeItLive());
				effect_downstreameffect18.getReferenceIDs().add(
						new Reference(effect_downstreameffect18, dataSource, "Munno DW, Syed NI. (2003) Synaptogenesis in the CNS: an odyssey from wiring together to firing together. J Physiol. 552: 1-11. ")
								.<Reference> makeItLive());
				effect_downstreameffect18
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect18,
										dataSource,
										"Nieland TJF, Logan DJ, Saulnier J, Lam D, Johnson C, et al. (2014) High Content Image Analysis Identifies Novel Regulators of Synaptogenesis in a High-Throughput RNAi Screen of Primary Neurons. PLoS ONE. 9: e91744. ")
										.<Reference> makeItLive());
				effect_downstreameffect18.getReferenceIDs().add(
						new Reference(effect_downstreameffect18, dataSource,
								"Schummers J, MariÃ±o J, Sur M. (2002) Synaptic integration by V1 neurons depends on location within the orientation map. Neuron. 36: 969-978. ").<Reference> makeItLive());
				effect_downstreameffect18.getReferenceIDs().add(
						new Reference(effect_downstreameffect18, dataSource, "Tau GZ, Peterson BS. (2010) Normal Development of Brain Circuits. Neuropsychopharmacology 35: 147-168. ").<Reference> makeItLive());
				
				effect_downstreameffect22 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect22.setTitle("Neuronal network function, Decreased");
				effect_downstreameffect22.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				effect_downstreameffect22.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				effect_downstreameffect22
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect22,
										dataSource,
										"Definition",
										"Provide brief description of the (key) event\n\nBiological state: There are striking differences in neuronal network formation and function among the developing and mature brain. The developing brain shows a slow maturation and a transient passage from spontaneous, long-duration action potentials to synaptically-triggered, short-duration action potentials. \n\nFurthermore, at this precise developmental stage the neuronal network is characterised by \"hyperexcitabilityâ€�, which is related to the increased number of local circuit recurrent excitatory synapses and the lack of Î³-amino-butyric acid A (GABAA)-mediated inhibitory function that appears much later. This â€œhyperexcitabilityâ€� disappears with maturation when pairing of the pre- and postsynaptic partners occurs and synapses are formed generating population of postsynaptic potentials and population of spikes followed by developmental GABA switch. Glutamatergic neurotransmission is dominant at early stages of development and NMDA receptor-mediated synaptic currents are far more times longer than those in maturation, allowing more calcium to enter the neurons. The processes that are involved in increased calcium influx and the subsequent intracellular events seem to play a critical role in establishment of wiring of neural circuits and strengthening of synaptic connections during development (reviewed in Erecinska et al., 2004). Neurons that do not receive glutaminergic stimulation are undergoing developmental apoptosis. \n\nDuring the neonatal period, the brain is subject to profound alterations in neuronal circuitry due to high levels of synaptogenesis and gliogenesis. For example, in neuroendocrine regions such as the preoptic area-anterior hypothalamus (POA-AH), the site of gonadotropin-releasing hormone (GnRH) system is developmentally regulated by glutamatergic neurons. The changes in the expression of the N-methyl-D-aspartate (NMDA) receptor subunits NR1 and NR2B system begin early in postnatal development, before the onset of puberty, thereby playing a role in establishing the appropriate environment for the subsequent maturation of GnRH neurons (Adams et al., 1999). \n\nBiological compartments: Neural network formation and function happen in all brain regions but it appears to onset at different time points of development (reviewed in Erecinska et al., 2004). Glutamatergic neurotransmission in hippocampus is poorly developed at birth. Initially, NMDA receptors play important role but the vast majority of these premature glutamatergic synapses are â€œsilentâ€� possibly due to delayed development of hippocampal AMPA receptors. In contrast, in the cerebral cortex the maturation of excitatory glutamatergic neurotransmission happens much earlier. The â€œsilentâ€� synapses disappear by PND 7-8 in both brain regions mentioned above. \n\nThere is strong evidence suggesting that NMDA receptor subunit composition controls synaptogenesis and synapse stabilization (Gambrill and Barria, 2011). It is established fact that during early postnatal development in the rat hippocampus, synaptogenesis occurs in parallel with a developmental switch in the subunit composition of NMDA receptors from NR2B to NR2A. It is suggested that early expression of NR2A in organotypic hippocampal slices reduces the number of synapses and the volume and dynamics of spines. In contrast, overexpression of NR2B does not affect the normal number and growth of synapses. However, it does increase spine motility, adding and retracting spines at a higher rate. The C terminus of NR2B, and specifically its ability to bind CaMKII, is sufficient to allow proper synapse formation and maturation. Conversely, the C terminus of NR2A was sufficient to stop the development of synapse number and spine growth. These results indicate that the ratio of synaptic NR2B over NR2A controls spine motility and synaptogenesis, and suggest a structural role for the intracellular C terminus of NR2 in recruiting the signalling and scaffolding molecules necessary for proper synaptogenesis. Interestingly, it was found that genetic deletion of NR3A accelerates glutamatergic synaptic transmission, as measured by AMPAR-mediated postsynaptic currents recorded in hippocampal CA1. Consistent, the deletion of NR3A accelerates the expression of the glutamate receptor subunits NR1, NR2A, and GluR1 sugesting that glutamatergic synapse maturation is critically dependent upon activation of NMDA-type glutamate receptors (Henson et al., 2012). \n\nGeneral role in biology: The development of neuronal networks can be distinguished into two phases: an early â€˜establishmentâ€™ phase of neuronal connections, where activity-dependent and independent mechanisms could operate, and a later â€˜maintenanceâ€™ phase, which appears to be controlled by neuronal activity (Yuste and Sur, 1999). These neuronal networks facilitate information flow that is necessary to produce complex behaviors, including learning and memory (Mayford et al., 2012).\n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);
				effect_downstreameffect22
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect22,
										dataSource,
										"Measurment/detection",
										"Provide a summary of the available measurment and detection methods.\n\nIn vivo: The recording of brain activity by using electroencephalography (EEG), electrocorticography (ECoG) and local field potentials (LFP) assists towards the collection of signals generated by multiple neuronal cell networks. Advances in computer technology have allowed quantification of the EEG and expansion of quantitative EEG (qEEG) analysis providing a sensitive tool for time-course studies of different compounds acting on neuronal networks' function (Binienda et al., 2011). The number of excitatory or inhibitory synapses can be functionally studied at an electrophysiological level by examining the contribution of glutamatergic and GABAergic synaptic inputs. The number of them can be determined by variably clamping the membrane potential and recording excitatory and inhibitory postsynaptic currents (EPSCs or IPSCs) (Liu, 2004). \n\nIn vitro: Microelectrode array (MEA) recordings are also used to measure electrical activity in cultured neurons (Keefer et al., 2001, Gramowski et al., 2000; Gopal, 2003; Johnstone et al., 2010). MEAs can be applied in high throughput platforms to facilitate screening of numerous chemical compounds (McConnell et al., 2012). Using selective agonists and antagonists of different classes of receptors their response can be evaluated in a quantitative manner (Novellino et al., 2011; Hogberg et al., 2011). Patch clamping technique can also be used to measure neuronal network activity. \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 1);
				effect_downstreameffect22
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect22,
										dataSource,
										" ",
										" Evidence Supporting Taxonomic Applicability\n\nIn vitro studies in brain slices applying electrophysiological techniques showed significant variability among species (immature rats, rabbits and kittens) related to synaptic latency, duration, amplitude and efficacy in spike initiation (reviewed in Erecinska et al., 2004). \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 2);
				effect_downstreameffect22
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect22,
										dataSource,
										"Adams MM, Flagg RA, Gore AC., Perinatal changes in hypothalamic N-methyl-D-aspartate receptors and their relationship to gonadotropin-releasing hormone neurons. Endocrinology. 1999 May;140(5):2288-96. ")
										.<Reference> makeItLive());
				effect_downstreameffect22.getReferenceIDs().add(
						new Reference(effect_downstreameffect22, dataSource,
								"Binienda ZK, Beaudoin MA, Thorn BT, Ali SF. (2011) Analysis of electrical brain waves in neurotoxicology: Î³-hydroxybutyrate. Curr Neuropharmacol. 9: 236-239. ").<Reference> makeItLive());
				effect_downstreameffect22.getReferenceIDs().add(
						new Reference(effect_downstreameffect22, dataSource, "Erecinska M, Cherian S, Silver IA. (2004) Energy metabolism in mammalian brain during development. Prog Neurobiol. 73: 397-445. ")
								.<Reference> makeItLive());
				effect_downstreameffect22.getReferenceIDs().add(
						new Reference(effect_downstreameffect22, dataSource,
								"Gambrill AC, Barria A. NMDA receptor subunit composition controls synaptogenesis and synapse stabilization. Proc Natl Acad Sci U S A. 2011:108(14):5855-60. ").<Reference> makeItLive());
				effect_downstreameffect22.getReferenceIDs().add(
						new Reference(effect_downstreameffect22, dataSource,
								"Gopal K. (2003) Neurotoxic effects of mercury on auditory cortex networks growing on microelectrode arrays: a preliminary analysis. Neurotoxicol Teratol. 25: 69-76. ")
								.<Reference> makeItLive());
				effect_downstreameffect22
						.getReferenceIDs()
						.add(
								new Reference(effect_downstreameffect22, dataSource,
										"Gramowski A, Schiffmann D, Gross GW. (2000) Quantification of acute neurotoxic effects of trimethyltin using neuronal networks cultures on microelectrode arrays. Neurotoxicology 21: 331-342. ")
										.<Reference> makeItLive());
				effect_downstreameffect22.getReferenceIDs().add(
						new Reference(effect_downstreameffect22, dataSource,
								"Henson MA, Larsen RS, Lawson SN, PÃ©rez-OtaÃ±o I, Nakanishi N, Lipton SA, Philpot BD. (2012) Genetic deletion of NR3A accelerates glutamatergic synapse maturation. PLoS One. 7(8). ")
								.<Reference> makeItLive());
				effect_downstreameffect22
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect22,
										dataSource,
										"Hogberg HT, Sobanski T, Novellino A, Whelan M, Weiss DG, Bal-Price AK. (2011) Application of micro-electrode arrays (MEAs) as an emerging technology for developmental neurotoxicity: evaluation of domoic acid-induced effects in primary cultures of rat cortical neurons. Neurotoxicology 32: 158-168. ")
										.<Reference> makeItLive());
				effect_downstreameffect22.getReferenceIDs().add(
						new Reference(effect_downstreameffect22, dataSource,
								"Johnstone AFM, Gross GW, Weiss D, Schroeder O, Shafer TJ. (2010) Use of microelectrode arrays for neurotoxicity testing in the 21st century Neurotoxicology 31: 331-350. ")
								.<Reference> makeItLive());
				effect_downstreameffect22.getReferenceIDs().add(
						new Reference(effect_downstreameffect22, dataSource,
								"Keefer E, Norton S, Boyle N, Talesa V, Gross G. (2001) Acute toxicity screening of novel AChE inhibitors using neuronal networks on microelectrode arrays. Neurotoxicology 22: 3-12. ")
								.<Reference> makeItLive());
				effect_downstreameffect22.getReferenceIDs().add(
						new Reference(effect_downstreameffect22, dataSource,
								"Liu G. (2004) Local structural balance and functional interaction of excitatory and inhibitory synapses in hippocampal dendrites. Nat Neurosci. 7: 373-379. ").<Reference> makeItLive());
				effect_downstreameffect22.getReferenceIDs().add(
						new Reference(effect_downstreameffect22, dataSource, "Mayford M, Siegelbaum SA, Kandel ER. (2012) Synapses and memory storage. Cold Spring Harb Perspect Biol. 4. pii: a005751. ")
								.<Reference> makeItLive());
				effect_downstreameffect22
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect22,
										dataSource,
										"McConnell ER, McClain MA, Ross J, LeFew WR, Shafer TJ. (2012) Evaluation of multi-well microelectrode arrays for neurotoxicity screening using a chemical training set. Neurotoxicology 33: 1048-1057. ")
										.<Reference> makeItLive());
				effect_downstreameffect22
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect22,
										dataSource,
										"Novellino A, Scelfo B, Palosaari T, Price A, Sobanski T, Shafer TJ, Johnstone AF, Gross GW, Gramowski A, Schroeder O, JÃ¼gelt K, Chiappalone M, Benfenati F, Martinoia S, Tedesco MT, Defranchi E, D'Angelo P, Whelan M. (2011) Development of micro-electrode array based tests for neurotoxicity: assessment of interlaboratory reproducibility with neuroactive chemicals. Front Neuroeng. 4: 4. ")
										.<Reference> makeItLive());
				effect_downstreameffect22.getReferenceIDs().add(
						new Reference(effect_downstreameffect22, dataSource, "Yuste R, Peinado A, Katz LC. (1992) Neuronal domains in developing neocortex. Science 257: 665-669. ").<Reference> makeItLive());
				
				effect_downstreameffect24 = new Effect_DownstreamEffect(pathway, dataSource);
				effect_downstreameffect24.setTitle("Learning and memory, Impairment");
				effect_downstreameffect24.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				effect_downstreameffect24.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				effect_downstreameffect24
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect24,
										dataSource,
										"Definition",
										"Provide brief description of the (key) event\n\nLearning can be defined as the process by which new information is acquired to establish knowledge by systematic study or by trial and error (Ono, 2009). Two types of learning are considered in neurobehavioral studies: a) associative learning and b) non-associative learning. \n\nAssociative learning is learning by making associations between different events. In associative learning, a subject learns the relationship among two different stimuli or between the stimulus and the subjectâ€™s behaviour. Classical conditioning, operant conditioning and category learning are some examples of associative learning. On the other hand, non-associative learning can be defined as an alteration in the behavioral response that occurs over time in response to a single type of stimulus. Habituation and sensitization are some examples of non-associative learning. Another important type of learning is emotional learning and the simplest form of emotional regulation is extinction (Quirk and Mueller, 2008). During extinction, conditioned response to a stimulus decreases when the reinforcer is omitted and fear conditioning experiments help to elucidate the underlined mechanism. \n\nThe memory to be formed requires acquisition, retention and retrieval of information in the brain, which is characterised by the non-conscious recall of information (Ono, 2009). Memory is considered very important as it allows the subjects to access the past, to form experience and consequently to acquire skills for surviving purposes. There are three main categories of memory, including sensory memory, short-term or working memory (up to a few hours) and long-term memory (up to several days or even much longer). At the cellular level the storage of long-term memory is associated with increased gene expression and protein synthesis as well as formation of novel synaptic connections (Lynch, 2004). \n\nLearning-related processes require neural networks to detect correlations between events in the environment and store these as changes in synaptic strength (Abbott and Nelson, 2000). Long-term potentiation (LTP) and long-term depression (LTD) are two fundamental processes involved in cognitive functions (Abbott and Nelson, 2000; Malenka and Bear, 2004), which respectively, strengthen synaptic inputs that are effective at depolarizing the postsynaptic neuron and weaken inputs that are not, thus reinforcing useful pathways in the brain. Synapses that are strengthened become more effective at depolarizing the postsynaptic neuron, eventually driving neuronal activity to saturation (Abbott and Nelson, 2000). As correlated activity of presynaptic and postsynaptic neurons drives strengthening of specific synapses, the postsynaptic neuron will be driven more strongly, and so presynaptic inputs that were initially only poorly correlated with postsynaptic firing will be better able to trigger firing of the postsynaptic neuron. This implies that nervous systems must have a matching set of plasticity mechanisms that counteract these destabilizing forces. The cortical and hippocampal pyramidal neurons have a target firing rate, and synaptic strengths are regulated to maintain these rates relatively constant in the face of perturbations in input channel (Burrone et al., 2002). This provides a robust mechanism for generating stability in network function in the face of learning-related changes in synaptic input. In principle, neurons could maintain stable firing rates through homeostatic regulation of many aspects of neuronal excitability. These possibilities include balancing inward and outward voltage-dependent conductances that determine firing properties generally called â€œintrinsic excitabilityâ€� (Marder and Goaillard, 2006; Zhang and Linden 2003), regulating inhibitory and/or excitatory synaptic strength (Turrigiano, 2011) or synapse number (Kirov et al., 1999) or by adjusting the ease with which other forms of plasticity can be induced, so-called â€œmetaplasticityâ€� (Abraham and Bear, 1996). Evidence suggests that all of these mechanisms can contribute to the homeostatic regulation of neuronal firing rates in central circuits. Activity-dependent alteration in synaptic strength is a fundamental property of the vertebrate central nervous system and is thought to underlie learning and memory. \n\nA major expression mechanism of synaptic scaling is changes in the accumulation of synaptic glutamate receptors. Central synapses typically cluster both AMPA receptors and NMDA receptors. AMPA receptors are ionotropic and carry out the majority of excitatory synaptic current in the central nervous system; NMDA receptors are also ionotropic but open as a function of voltage, flux calcium, and mediate a number of calcium-dependent forms of synaptic plasticity (Malenka and Bear, 2004). Synaptic scaling results in postsynaptic changes in both types of glutamate receptors (Stellwagen and Malenka, 2006; Watt et al., 2000) and can therefore be monitored by measuring changes in receptor accumulation at synapses. \n\nThe best characterized form of LTP occurs in the CA1 region of the hippocampus, in which LTP is initiated by transient activation of receptors and is expressed as a persistent increase in synaptic transmission through AMPA receptors followed by activation of NMDARs. This increase is due, at least in part, to a postsynaptic modification of AMPA-receptor function; this modification could be caused by an increase in the number of receptors, their open probability, their kinetics or their single-channel conductance. Summing up activity-dependent alteration in synaptic strength is a fundamental property of the vertebrate central nervous system that underlies learning and memory processes. \n\nIt is appropriate to state that while much emphasis has been given on the key role of the hippocampus in memory, it would probably be simplistic to attribute memory deficits solely to hippocampal damage (Barker and Warburton, 2011). There is substantial evidence that fundamental memory functions are not mediated by hippocampus alone but require a network that includes, in addition to the hippocampus, anterior thalamic nuclei, mammillary bodies cortex, cerebellum and basal ganglia (Aggleton and Brown, 1999; Doya, 2000; Mitchell et al., 2002, Toscano and Guilarte, 2005). Each of these brain structures can be potentially damaged leading to more or less severe impairment of learning and memory. \n\nAmnesia is defined as the impairment or loss of memory. Depending on the cause amnesia can be characterised as functional, organic amnesia or infantile amnesia. Dementia, is a brain disease that causes a long term and often gradual decrease in the ability to think and remember as well as problems with language, and a decrease in motivation (Solomon and Budson, 2011). It is an intellectual impairment observed mainly in elderly people due to the progress of a neudegenerative disease. In younger people this type of impairment is known as presenile dementia. The most common affected areas include memory, visual-spatial, language, attention, and executive function (problem solving). Therefore, very often, short-time memory, mind, speech and motor skills are affected. Certain forms of dementia can be treated, to some extent. The most common form of dementia is Alzheimer's disease, which accounts for between 50 and 60 percent of all cases. Other types include vascular dementia and Lewy body dementia (Burns, 2009). Initial symptoms in Alzheimer's disease is memory impairment (for review, Arhavsky, 2010), in particular short-term/episodic memory, which depends largely on hippocampal system (for review, Storandt et al., 2009; Daulatzai, 2013). This pathological and age-related memory decline is believed to be a result of reduced synaptic plasticity, including changes in the NR2 subunit composition of the NMDA receptor (for review, Wang et al., 2014). It can then evolve towards a global loss of cognitive functions defined as dementia (for review, Larson et al., 1992). \n\nIn the past, the study of infant memory has relied in models and tests used in adults and more specific amnesic patients with hippocampal damage. For this reason, the infant memory has been distinguished to declarative or explicit memory and nondeclarative or implicit memory. However, in recent years this distinction such as explicit/implicit are no longer accepted especially in relation to hippocampal function as new theories have been emerged (reviewed in Mullally and Maguire, 2014). Furthermore, there are findings that even very young infants have a more adept and flexible memory system than was previously thought and neurobiological data derived from non-humans provide support to the new hypotheses about hippocampal development that would facilitate to interpret infant memory data from humans. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);
				effect_downstreameffect24
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect24,
										dataSource,
										"Measurment/detection",
										"Provide a summary of the available measurment and detection methods.\n\nIn humans: The neuropsychological tests have been used for neurosensory assessment of humans including identification of altered neurobehaviours in vulnerable populations such as children (Rohlman et al., 2008). Intelligence tests, perceptual motor tests, planning tests, and logical, spatial, short term, long term, and working memory tasks can be used in neurobehavioral studies to assess learning and memory. The same test is also used to identify risks from occupational exposure to chemicals. \n\nIn laboratory animals: Current behavioural tests used for evaluating learning and memory processes in rats such as the Morris water maze, Radial maze, Passive avoidance and Spontaneous alternation are characterized in the KE Decreased Neuronal Network Function. \n\nCognitive function including learning and memory is an important endpoint required by the US EPA and OECD Developmental Neurotoxicity (DNT) Guidelines (OCSPP 870.6300 or OECD 426). The methods applied to assess learning and memory have been reviewed (Markis et al., 2009) and discussed in the OECD Series on testing and assessment number 20, Guidance document for Neurotoxicity Testing (2004) . This document is considered an essential supplement to a substantial number of already existing OECD Test Guidelines relevant for neurotoxicity testing. \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 1);
				effect_downstreameffect24
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect24,
										dataSource,
										" ",
										" Evidence Supporting Taxonomic Applicability\n\nLearning and memory have been studied in invertebrates such as gastropod molluscs and drosophila and vertebrates such as rodents and primates. Recently, larval zebrafish has also been suggested as a model for the study of learning and memory (Roberts et al., 2013). \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 2);
				effect_downstreameffect24
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										effect_downstreameffect24,
										dataSource,
										" ",
										" Regulatory Examples Using This Adverse Outcome\n\nImpairment of learning and memory is considered a chemically-induced adverse outcome that is used for risk assessment and management purposes. Neurotoxicity testing guidelines (OECD TG 424 and 426) are implemented on a number of occasions where the neurotoxic properties of a compound have to be assessed in order to comply with relevant EU regulations. These regulations are as follows: REACH regulation (EC, No 1907/2006), Plant protection products regulation (EC, No 1107/2009), Biocidal products regulation (EC, No 528/2012), Test methods regulation (EC, No 440/2008), Classification, labelling and packaging of substances and mixtures (EC, No 1272/2008) and Maximum residue levels of pesticides in or on food and feed of plant and animal origin regulation (EC, No 396/2005). \n\nThe US EPA and OECD Developmental Neurotoxicity (DNT) Guidelines (OCSPP 870.6300 or OECD 426) both require testing of learning and memory. These DNT Guidelines have been used to identify developmental neurotoxicity and adverse neurodevelopmental outcomes (Makris et al., 2009). Also in the frame of the OECD GD 43 (2008) on reproductive toxicity, learning and memory testing may have potential to be applied in the context of developmental neurotoxicity studies. However, many of the learning and memory tasks used in guideline studies may not readily detect subtle impairments in cognitive function associated with modest degrees of developmental thyroid disruption (Gilbert et al., 2012). \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 3);
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource, "Abbott LF, Nelson SB. (2000) Synaptic plasticity: Taming the beast. Nat Neurosci 3: 1178â€“1183. ").<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource, "Abraham HAJ, Bear MF. Bidirectional modification of CA1 synapses in the adult hippocampus in vivo. Nature. 1996 May 9;381(6578):163-6. ")
								.<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource, "Aggleton JP, Brown MW. (1999) Episodic memory, amnesia, and the hippocampal-anterior thalamic axis. Behav Brain Sci. 22: 425-489. ")
								.<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource, "Arshavsky YI. 2010. Why Alzheimer's disease starts with a memory impairment: neurophysiological insight. J Alzheimers Dis 20(1): 5-16. ")
								.<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource, "Barker GR, Warburton EC. (2011) When is the hippocampus involved in recognition memory? J Neurosci. 31: 10721-10731. ")
								.<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource, "Burns A, Iliffe, S. (2009). Dementia. BMJ (Clinical research ed.) 338: b75. ").<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource,
								"Burrone J, Oâ€™Byrne M, Murthy VN. (2002) Multiple forms of synaptic plasticity triggered by selective suppression of activity in individual neurons. Nature 420: 414â€“418. ")
								.<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource,
								"Daulatzai MA. 2013. Neurotoxic saboteurs: straws that break the hippo's (hippocampus) back drive cognitive impairment and Alzheimer's Disease. Neurotox Res 24(3): 407-459. ")
								.<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource, "Doya K. (2000) Complementary roles of basal ganglia and cerebellum in learning and motor control. Curr Opin Neurobiol. 10: 732-739. ")
								.<Reference> makeItLive());
				effect_downstreameffect24
						.getReferenceIDs()
						.add(
								new Reference(effect_downstreameffect24, dataSource,
										"Gilbert ME, Rovet J, Chen Z, Koibuchi N. (2012) Developmental thyroid hormone disruption: prevalence, environmental contaminants and neurodevelopmental consequences. Neurotoxicology 33: 842-52. ")
										.<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource,
								"Kirov SA, Sorra KE, Harris KM. (1999) Slices have more synapses than perfusion-fixed hippocampus from both young and mature rats. J Neurosci. 19: 2876â€“2886. ").<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource,
								"Larson EB, Kukull WA, Katzman RL. 1992. Cognitive impairment: dementia and Alzheimer's disease. Annual review of public health 13: 431-449. ").<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource, "Lynch MA. (2004) Long-term potentiation and memory. Physiol Rev. 84: 87-136. ").<Reference> makeItLive());
				effect_downstreameffect24
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect24,
										dataSource,
										"Makris SL, Raffaele K, Allen S, Bowers WJ, Hass U, Alleva E, Calamandrei G, Sheets L, Amcoff P, Delrue N, Crofton KM. (2009) A retrospective performance assessment of the developmental neurotoxicity study in support of OECD test guideline 426. Environ Health Perspect. 117:17-25. ")
										.<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource, "Malenka RC, Bear MF (2004). LTP and LTD: An embarrassment of riches. Neuron 44: 5â€“21. ").<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs()
						.add(
								new Reference(effect_downstreameffect24, dataSource,
										"Marder E, Goaillard JM. (2006). Variability, compensation and homeostasis in neuron and network function. Nat Rev Neurosci. 7: 563â€“574. ").<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource,
								"Mitchell AS, Dalrymple-Alford JC, Christie MA. (2002) Spatial working memory and the brainstem cholinergic innervation to the anterior thalamus. J Neurosci. 22: 1922-1928. ")
								.<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource, "Mullally SL, Maguire EA. (2014) Learning to remember: the early ontogeny of episodic memory. Dev Cogn Neurosci. 9: 12-29. ")
								.<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource, "OECD (2004) Series on testing and assessment number 20, Guidance document for neurotoxicity testing. ").<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource,
								"OECD (2007). Test Guideline 426. OECD Guideline for Testing of Chemicals. Developmental Neurotoxicity Study. http://www.oecd.org/document/55/0,3343,en_2649_34377_2349687_1_1_ 1_1,00.html ")
								.<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource, "OECD (2008) Nr 43 GUIDANCE DOCUMENT ON MAMMALIAN REPRODUCTIVE TOXICITY TESTING AND ASSESSMENT. ENV/JM/MONO(2008)16 ")
								.<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource,
								"Ono T. (2009) Learning and Memory. Encyclopedia of neuroscience. M D. Binder, N. Hirokawa and U. Windhorst (Eds). Springer-Verlag GmbH Berlin Heidelberg. pp 2129-2137. ")
								.<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource, "Quirk GJ, Mueller D. (2008) Neural mechanisms of extinction learning and retrieval. Neuropsychopharmacology 33: 56-72. ")
								.<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs()
						.add(
								new Reference(effect_downstreameffect24, dataSource, "Roberts AC, Bill BR, Glanzman DL. (2013) Learning and memory in zebrafish larvae. Front Neural Circuits 7: 126. ")
										.<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource,
								"Rohlman DS, Lucchini R, Anger WK, Bellinger DC, van Thriel C. (2008) Neurobehavioral testing in human risk assessment. Neurotoxicology. 29: 556-567. ").<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource, "Solomon, Andrew E. Budson, Paul R. (2011). Memory loss : a practical guide for clinicians. Elsevier Saunders. ISBN 9781416035978 ")
								.<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource, "Stellwagen D, Malenka RC. (2006) Synaptic scaling mediated by glial TNF-Î±. Nature 440: 1054â€“1059. ").<Reference> makeItLive());
				effect_downstreameffect24
						.getReferenceIDs()
						.add(
								new Reference(
										effect_downstreameffect24,
										dataSource,
										"Storandt M, Mintun MA, Head D, Morris JC. 2009. Cognitive decline and brain volume loss as signatures of cerebral amyloid-beta peptide deposition identified with Pittsburgh compound B: cognitive decline associated with Abeta deposition. Arch Neurol 66(12): 1476-1481. ")
										.<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource, "Toscano CD, Guilarte TR. (2005) Lead neurotoxicity: From exposure to molecular effects. Brain Res Rev. 49: 529-554. ")
								.<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource,
								"Turrigiano G. (2011) Too many cooks? Intrinsic and synaptic homeostatic mechanisms in cortical circuit refinement. Annu Rev Neurosci. 34: 89â€“103. ").<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource,
								"Wang D, Jacobs SA, Tsien JZ. 2014. Targeting the NMDA receptor subunit NR2B for treating or preventing age-related memory decline. Expert opinion on therapeutic targets 18(10): 1121-1130. ")
								.<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource,
								"Watt AJ, van Rossum MC, MacLeod KM, Nelson SB, Turrigiano GG. (2000) Activity coregulates quantal AMPA and NMDA currents at neocortical synapses. Neuron 26: 659â€“670. ")
								.<Reference> makeItLive());
				effect_downstreameffect24.getReferenceIDs().add(
						new Reference(effect_downstreameffect24, dataSource,
								"Zhang W, Linden DJ. (2003) The other side of the engram: Experience-driven changes in neuronal intrinsic excitability. Nat Rev Neurosci. 4: 885â€“900. ").<Reference> makeItLive());
				
				link_chemstructtomie4 = new Link_ChemStructToMIE(pathway, dataSource, initiator_chemicalstructure1, effect_molecularinitiatingevent3);
				link_chemstructtomie4.setLinkType(LinkType.UNKNOWN);
				link_chemstructtomie5 = new Link_ChemStructToMIE(pathway, dataSource, initiator_chemicalstructure2, effect_molecularinitiatingevent3);
				link_chemstructtomie5.setLinkType(LinkType.UNKNOWN);
				link_effecttoeffect7 = new Link_EffectToEffect(pathway, dataSource, effect_molecularinitiatingevent3, effect_downstreameffect6);
				link_effecttoeffect7.setLinkType(LinkType.DIRECT);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect7_weigth0 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect7, dataSource, Link_EffectToEffect.class, 3.0);
				link_effecttoeffect7
						.getDescriptionIDs()
						.set(
								new DescriptionSection_Structured(
										link_effecttoeffect7,
										dataSource,
										"(Key) Event Relationships Weight of Evidences",
										"<html><h3><b>Biological Plausibility</b></h3>There is structural mechanistic understanding supporting the relationship between MIE (NMDARs, binding of antagonists) and KE (NMDARs, inhibition). Crystal structure studies are used to study the binding of antagonists/agonists to NMDA receptors. In case of NMDAR antagonists, the binding to the receptor causes LBD conformation changes which promote channel closure leading to reduced Ca+2 influx (Blanke and VanDongen, 2009). This lack of measurable ion flux is applied as an indication of NMDAR inhibition.<br><h3><b>Empirical Support for Linkage</b></h3><i>Include consideration of temporal concordance here</i><br><br>In slices of cerebellum derived from postnatal days 6-30 (PND 6-30) Sprague Dawley rats, 10 ÂµM MK-801 completely blocked evoked NMDA excitatory postsynaptic currents (EPSCs) as it has been demonstrated by patch clamp technique (Rumbaugh and Vicini, 1999). The same technique has been employed in cortical slices from C57BL/6 mice of both genders and different age groups (P8-12, P21-28 or P45-90), showing that 1 ÂµM APV and 50 nM NVP-AAM077 antagonise a similar amount of NMDA receptor current independently of the age (de Marchena et al., 2008).<br><br>Pb2+ has potent inhibitory effects on the NMDA receptor (Alkondon et al., 1990; Guilarte and Miceli, 1992; Guilarte, 1997; Gavazzo et al., 2001). In rat hippocampal neurons, Pb2+ (2.5-50 Î¼M) inhibits NMDA-induced whole-cell and single-channel currents in a concentration-dependent manner, suggesting that Pb2+ can decrease the frequency of NMDA-induced channel activation (Alkondon et al., 1990). In the same study, they have examined the effect of Pb2+ on the binding of [3H]MK-801 to the rat brain hippocampal membranes and showed that Pb2+ inhibits the binding of [3H]-MK-801 in a concentration dependent manner with an IC50 value close to 7 ÂµM (Alkondon et al., 1990). These inhibitory effects of Pb2+ on NMDA receptors activation appear to be age and brain region specific (Guilarte, 1997; Guilarte and Miceli, 1992). The Pb2+ IC50 is significantly lower in cortical membranes prepared from neonatal than from adult rats, whereas the hippocampus is more sensitive than the cerebral cortex since the Pb2+ IC50 is significantly lower in the hippocampus (Guilarte and Miceli, 1992). The number of [3H]-MK-801 binding sites associated with the high and low affinity sites of Pb2+ inhibition in the hippocampus of rats is increased as a function of age, peaking at PND 28 and 21 (Guilarte, 1997). High and low affinity Pb(2+)-sensitive [3H]-MK-801 binding sites have also been measured in the cerebral cortex during early development, but that has not been possible to evaluate after PND 14.<br><br>The developing brain is more sensitive than the adult brain to Pb2+-induced effects mediated through the NMDA receptor. Moreover, the hippocampus appears to be particularly vulnerable as in this brain structure NMDA receptors undergo subunit specific changes during developmental Pb2+ exposure (Guilarte and McGlothan, 1998). Exposure to Pb2+ during synaptogenesis causes decreased expression of hippocampal NR2A-subunit of NMDARs at synapses and increased targeting of NR2B-NMDARs to dendritic spines (without increased NR2B-NMDARs expression) (Nihei and Guilarte, 1999; Neal et al., 2011; Zhang et al., 2002).<br><br><h3><b>Uncertainties or Inconsistencies</b></h3>Pb2+ has been found to produce either potentiation or inhibition depending on: a) the subunit composition of NMDA receptors, b) endogenous glutamate concentration and c) Pb2+ dosage. In case that the NMDA receptors are saturated by agonist, Pb2+ at low concentrations (<1 ÂµM) acts as a positive modulator of agonist action at NR1b-2AC and NR1a-2AB subunit complexes, whereas at higher concentrations, Pb2+ it behaves as a potent inhibitor of all recombinant NMDA receptors tested and was least potent at NR1b-2AC (Omelchenko et al., 1996; 1997), meaning that Pb2+ is not always acting as NMDAR inhibitor but it can also behave as NMDAR activator under certain conditions.<br><br><html>",
										link_effecttoeffect7_weigth0).setFormat(ContentFormat.HTML).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect7
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										link_effecttoeffect7,
										dataSource,
										"Quantitative Understanding of the Linkage",
										"<html><i>Is it known how much change in the first event is needed to impact the second? Are there known modulators of the response-response relationships? Are there models or extrapolation approaches that help describe those relationships?</i><br><br>To predict how potent an antagonist can be, the half maximal inhibition concentrations (IC50) and the half maximal effective concentration (EC50) of glutamate/glycine induced currents is measured in NMDA receptors from brain slices and cells or in recombinantly expressed receptors. Traynelis et al. 2010 summarised the IC50 values for competitive, noncompetitive and uncompetitive antagonists in different subunits of NMDA receptors. The inhibitory effect (efficacy) of antagonists on NMDA receptors has been found to be dependent on:<br><br>-the type of subunits that form the NMDA receptors depending on the developmental stage -the chemical structure of the antagonists<br><br><br><br>-the binding site of receptor that the antagonists prefer<br><br>-how tightly an antagonist binds to the receptor (affinity)<br><br>At CA3-CA1 synapses, NMDARs are largely composed of NR1 (NMDA receptor subunit 1)-NR2A or NR1-NR2B containing subunits. Recent, but controversial, evidence has correlated NR1-NR2A receptors with the induction of LTP and NR1-NR2B receptors with LTD. However, LTP can be induced by activation of either subtype of NMDAR and the ratio of NR2A:NR2B receptors has been proposed as an alternative determinant of the direction of synaptic plasticity (Mac Donald et al., 2006).<br><br><b>Pb2+:</b> Although the NR2 subunits have different Zn2+ binding sites i.e. the NR2A-NMDAR binds Zn2+ at a high-affinity site (nM affinity) while the NR2B-NMDAR binds Zn2+ with lower affinity (ÂµM range); the Pb2+ IC50 for wild type NR2A-NMDARs was reported to be 1.3 ÂµM, while the Pb2+ IC50 of wild type NR2B-NMDARs was 1.2 ÂµM (Gavazzo et al., 2008). Similar findings were published by Lasley and Gilbert (1999) using cortical neurons from adult rats. The IC50 for Pb2+ ranged from 1.52 to 4.86 ÂµM, with the ranking of Pb2+ potency in inhibition of NMDA receptor subunits to be NR1b-2A>NR1b-2C>NR1b-2D>NR1b-2AC after experiments that have been conducted in Xenopus oocytes injected with cRNAs for different combinations of NMDA receptor subunits (Omelchenko et al., 1997).</html>")
										.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 2);
				link_effecttoeffect7
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect7,
										dataSource,
										"Alkondon M, Costa AC, Radhakrishnan V, Aronstam RS, Albuquerque EX. (1990) Selective blockade of NMDA-activated channel currents may be implicated in learning deficits caused by lead. FEBS Lett. 261: 124-130.")
										.<Reference> makeItLive());
				link_effecttoeffect7
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect7,
										dataSource,
										"Blanke ML, VanDongen AMJ. (2009) Activation Mechanisms of the NMDA Receptor. In: Van Dongen AM, editor. Biology of the NMDA Receptor. Boca Raton (FL): CRC Press; Chapter 13. Available from: http://www.ncbi.nlm.nih.gov/books/NBK5274/")
										.<Reference> makeItLive());
				link_effecttoeffect7
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect7,
										dataSource,
										"de Marchena J, Roberts AC, Middlebrooks PG, Valakh V, Yashiro K, Wilfley LR, Philpot BD. (2008) NMDA receptor antagonists reveal age-dependent differences in the properties of visual cortical plasticity. J Neurophysiol. 100: 1936-1948.")
										.<Reference> makeItLive());
				link_effecttoeffect7.getReferenceIDs().add(
						new Reference(link_effecttoeffect7, dataSource,
								"Gavazzo P, Gazzoli A, Mazzolini M, Marchetti C. (2001) Lead inhibition of NMDA channels in native and recombinant receptors. NeuroReport. 12: 3121-3125.").<Reference> makeItLive());
				link_effecttoeffect7.getReferenceIDs().add(
						new Reference(link_effecttoeffect7, dataSource,
								"Gavazzo P, Zanardi I, Baranowska-Bosiacka I, Marchetti C. (2008) Molecular determinants of Pb2+ interaction with NMDA receptor channels. Neurochem Int. 52: 329-337.")
								.<Reference> makeItLive());
				link_effecttoeffect7.getReferenceIDs().add(
						new Reference(link_effecttoeffect7, dataSource,
								"Guilarte TR, Miceli RC. (1992) Age-dependent effects of lead on [3H]-MK-801 binding to the NMDA receptor-gated ionophore: In vitro and in vivo studies. Neurosci Lett. 148: 27-30.")
								.<Reference> makeItLive());
				link_effecttoeffect7.getReferenceIDs().add(
						new Reference(link_effecttoeffect7, dataSource,
								"Guilarte TR. (1997) Pb2+ Inhibits Nmda Receptor Function at High and Low Affinity Sites: Developmental and Regional Brain Expression. Neurotoxicology 18: 43-51.").<Reference> makeItLive());
				link_effecttoeffect7.getReferenceIDs().add(
						new Reference(link_effecttoeffect7, dataSource,
								"Guilarte TR, McGlothan JL. (1998) Hippocampal Nmda Receptor Mrna Undergoes Subunit Specific Changes During Developmental Lead Exposure. Brain Res. 790: 98-107.").<Reference> makeItLive());
				link_effecttoeffect7.getReferenceIDs().add(
						new Reference(link_effecttoeffect7, dataSource,
								"Hedegaard MK, Hansen KB, Andersen KT, BrÃ¤uner-Osborne H, Traynelis SF. (2012) Molecular pharmacology of human NMDA receptors. Neurochem Int. 61: 601-609.").<Reference> makeItLive());
				link_effecttoeffect7.getReferenceIDs().add(
						new Reference(link_effecttoeffect7, dataSource,
								"Lasley SM, Gilbert ME. (1999) Lead inhibits the rat N-methyl-d-aspartate receptor channel by binding to a site distinct from the zinc allosteric site. Toxicol Appl Pharmacol. 159: 224-233.")
								.<Reference> makeItLive());
				link_effecttoeffect7.getReferenceIDs().add(
						new Reference(link_effecttoeffect7, dataSource,
								"MacDonald JF, Jackson MF, Beazely MA. (2006) Hippocampal long-term synaptic plasticity and signal amplification of NMDA receptors. Crit Rev Neurobiol. 18: 71-84.").<Reference> makeItLive());
				link_effecttoeffect7.getReferenceIDs().add(
						new Reference(link_effecttoeffect7, dataSource,
								"Neal AP, Worley PF, Guilarte TR. (2011) Lead exposure during synaptogenesis alters NMDA receptor targeting via NMDA receptor inhibition. Neurotoxicology 32: 281-289.")
								.<Reference> makeItLive());
				link_effecttoeffect7
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect7,
										dataSource,
										"Omelchenko IA, Nelson CS, Marino JL., Allen CN. (1996). The sensitivity of N-methyl-d-aspartate receptors to lead inhibition is dependent on the receptor subunit composition. J Pharmacol Exp Ther. 278: 15-20.")
										.<Reference> makeItLive());
				link_effecttoeffect7.getReferenceIDs().add(
						new Reference(link_effecttoeffect7, dataSource,
								"Omelchenko IA, Nelson CS, Allen CN. (1997) Lead inhibition of N-Methyl-D-aspartate receptors containing NR2A, NR2C and NR2D subunits. J Pharmacol Exp Ther. 282: 1458-1464.")
								.<Reference> makeItLive());
				link_effecttoeffect7.getReferenceIDs().add(
						new Reference(link_effecttoeffect7, dataSource,
								"Rumbaugh G, Vicini S. (1999) Distinct Synaptic and Extrasynaptic NMDA Receptors in Developing Cerebellar Granule Neurons. J Neurosc. 19: 10603-10610.").<Reference> makeItLive());
				link_effecttoeffect7
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect7,
										dataSource,
										"Traynelis S, Wollmuth LP, McBain CJ, Menniti FS, Vance KM, Ogden KK, Hansen KB, Yuan H, Myers SJ, Dingledine R. (2010) Glutamate receptor ion channels: structure, regulation, and function. Pharmacol Rev. 62: 405-496.")
										.<Reference> makeItLive());
				link_effecttoeffect7
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect7,
										dataSource,
										"Zhang XY, Liu AP, Ruan DY, Liu J. (2002) Effect of developmental lead exposure on the expression of specific NMDA receptor subunit mRNAs in the hippocampus of neonatal rats by digoxigenin-labeled in situ hybridization histochemistry. Neurotox Teratol 24: 149-160.")
										.<Reference> makeItLive());
				
				link_effecttoeffect9 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect6, effect_downstreameffect8);
				link_effecttoeffect9.setLinkType(LinkType.DIRECT);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect9_weigth0 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect9, dataSource, Link_EffectToEffect.class, 2.0);
				link_effecttoeffect9
						.getDescriptionIDs()
						.set(
								new DescriptionSection_Structured(
										link_effecttoeffect9,
										dataSource,
										"(Key) Event Relationships Weight of Evidences",
										"<html>\n\n<body>\n\n<h3><span id=\"Biological_Plausibility\">Biological Plausibility</span></h3>\n\n<p>The relationship between KE (NMDARs, Inhibition) and KE (Calcium influx, Decreased) is plausible as the function evaluation of NMDA receptors is commonly carried out by measurement of intracellular influx of Ca2+ upon NMDA receptor stimulation by agonist. Calcium imaging techniques have been extensively utilized to investigate the relationship between these two KEs. Almost 15% of the current through NMDA receptors is mediated by Ca2+ under physiological conditions (Higley and Sabatini, 2012).</p>\n\n<p>It has been shown that less than five and, occasionally only a single NMDA receptor opens under physiological conditions, causing a total Ca2+ influx of about 6000 ions into a dendritic spine head reaching a concentration of âˆ¼10 ÂµM (Higley and Sabatini, 2012). However, the majority of the ions are rapidly eliminated by binding Ca2+ proteins, reaching âˆ¼1 ÂµM of free Ca2+ concentration (Higley and Sabatini, 2012).</p>\n\n<p>In rat primary forebrain cultures, the intracellular Ca2+ increases after activation of the NMDA receptor and this increase is blocked when the cells are cultured under Ca2+ free conditions, demonstrating that the NMDA-evoked increase in intracellular Ca2+ derives from extracellular and not intracellular sources (Liu et al., 2013).</p>\n\n<p>Neurons in brain slices from wild-type (GluRÎµ2+/+) mice showed increase of intracellular Ca2+ in the presence of 100 Î¼M NMDA that was completely inhibited after exposure to 100 mM APV. In contrast, the NMDA-mediated increase in Ca2+ was absent in brain slices from GluRÎµ2âˆ’/âˆ’ mice that do not possess any functional NMDA receptors in the developing neocortex (Okada et al., 2003).</p>\n\n<h3><span id=\"Empirical_Support_for_Linkage\">Empirical Support for Linkage</span></h3>\n\n<p><em>Include consideration of temporal concordance here</em></p>\n\n<p><strong>Pb2+:</strong> There are a few studies examining the effect of Pb2+ exposure on the changes in intracellular Ca2+. Incubation of rat synaptosomes with Pb2+ stimulates the activity of calmodulin reaching the higher effect at 30 ÂµM, whereas higher concentrations of Pb2+ causes inhibition (Sandhir and Gill, 1994). Pb2+ exposure increases the activity of calmodulin by 45% in animal models. The IC50 values for inhibition of Ca2+ ATPase by Pb2+ has been found to be 13.34 and 16.69 ÂµM in calmodulin-rich and calmodulin-depleted synaptic plasma membranes, respectively. Exposure of rats to Pb2+ has also inhibitory effect on Ca2+ ATPase activity, causing increase in intrasynaptosomal Ca2+ (Sandhir and Gill, 1994). In embryonic rat hippocampal neurons, exposure to 100 nM Pb2+ for periods from 1 hour to 2 days showes decrease of intracellular Ca2+ by a calmodulin-dependent mechanism (Ferguson et al., 2000).</p>\n\n<p>There is evidence that Pb2+ exposure affects Ca2+ homeostasis causing alterations in the phosphorylation state of different kinases. For example, Pb2+ has been shown to interfere with MAPK signaling as it increases the phosphorylation of both ERK1/2 and p38(MAPK) (Cordova et al., 2004). However, the findings regarding calcium/calmodulin kinase II (CamKII) activity are not clear (Toscano and Guilarte, 2005). On one hand, Pb2+ has been found to cause reduction of CREB phosphorylation in the hippocampus of rats exposed during brain development (Toscano et al., 2003; Toscano et al., 2002). On the other hand, the levels of phosphorylation of CamKII have not been explored but only the mRNA expression levels have been studied in rat pups on PND 25 that received Pb2+ (180 and 375-ppm lead acetate in food for 30 days) and reached blood Pb2+ levels 5.8 to 10.3 Î¼g/dl on PND 55 (Schneider et al., 2012). More specifically, CamKIIÎ± gene expression has been found to be very sensitive to Pb2+ exposure in the frontal cortex but not in the hippocampus, whereas CamKIIÎ² gene expression in both brain structures remained unchanged (Schneider et al., 2012).</p>\n\n<p>Acute Pb2+ (10Î¼M) exposure impairs LTP (125.8% reduction of baseline) in CA1 region of hippocampus derived from Sprague-Dawley rats (15-18 PND) as it has been recorded by whole cell patch-clamp technique (Li et al., 2006). In the same study, through calcium imaging, it has been shown in the 10mM caffeine-perfused cultured hippocampal neurons that 10Î¼M Pb2+ reduces intracellular Fluo-4 fluorescence ratio to 0.44 (Li et al., 2006).</p>\n\n<p>Pb2+ chronically or acutely applied, significantly reduces LTP in CA1 region of hippocampus from Wistar or Sprague-Dawley rats (30 and 60 PND) (Carpenter et al., 2002). These animals were exposed to Pb2+ via the mother&rsquo;s drinking water either through gestation and lactation (upto day 21) (perinatal), only by lactation through the mother&rsquo;s drinking water and then in the pup&rsquo;s drinking water (post) or from gestation (pre and post). The concentrations of Pb2+ used in the drinking water were 0.1 and 0.2%. In CA1, LTP has been reduced at both ages and Pb2+ concentrations or duration of exposure. In CA3, there have been no differences with time of exposure, but there was a dramatic difference in response as the age of animals increased. At 30 days LTP was significantly reduced, but at 60 days LTP was increased by about 30% (Carpenter et al., 2002). In the same brain structure and area (CA3) the effects of Pb2+ on LTP have been different in 30 PND and 60 PND rats after either acute perfusion of Pb2+ or from slices derived from rats after chronic developmental exposure to Pb2+, as inhibition of LTP has been recorded in 30 PND CA3, whereas potentiation has been measured in 60 PND CA3 with either exposure paradigm that have been attributed to possible involvement of protein kinase C (Hussain et al., 2000).</p>\n\n<table>\n\n  <tbody>\n\n    <tr>\n\n      <td align=\"center\"><strong>Stressor</strong></td>\n\n      <td align=\"center\"><strong>Experimental Model</strong></td>\n\n      <td align=\"center\"><strong>Tested concentrations</strong></td>\n\n      <td align=\"center\"><strong>Exposure route</strong></td>\n\n      <td align=\"center\"><strong>Exposure duration</strong></td>\n\n      <td align=\"center\"><strong>Inhibition of NMDAR (KE up) (measurements, quantitative if available)</strong></td>\n\n      <td align=\"center\"><strong>Reduced Ca 2+ influx (KE down) (measurements, quantitative if available)</strong></td>\n\n      <td align=\"center\"><strong>References</strong></td>\n\n    </tr>\n\n    <tr>\n\n      <td>Lead</td>\n\n      <td>CA1 pyramidal neurons derived from Sprague-Dawley rats (15-18 PND)</td>\n\n      <td>5-20 ÂµM</td>\n\n      <td></td>\n\n      <td>25 min</td>\n\n      <td>By bath application of 5Ã¬M lead for 15 min prior to and 10 min after the tetanus, the LTP was induced to 151.4Â±3.5% of baseline. In the presence of 10Ã¬M lead, the LTP was reduced significantly to 125.8Â±2.9% of baseline. The reduction of 20Ã¬M lead to LTP was not significant with that of 10Ã¬M.</td>\n\n      <td>In the 10mM caffeine-perfused cultured hippocampal neurons, 10Ã¬M lead reduced intracellular Fluo-4 fluorescence ratio to 0.44Â±0.08</td>\n\n      <td>Li et al., 2006</td>\n\n    </tr>\n\n    <tr>\n\n      <td>Lead</td>\n\n      <td>CA1 region of hippocampus from Wistar or Sprague-Dawley rats (30 and 60 PND)</td>\n\n      <td>Two concentrations of lead were used in the drinking water 0.1 and 0.2%.</td>\n\n      <td>in utero and per os</td>\n\n      <td>Rats exposed to lead via the mother&rsquo;s drinking water either through gestation and lactation (to day 21) (perinatal), only by lactation through the mother&rsquo;s drinking water and then in the pup&rsquo;s drinking water until use (post) or from gestation until use (pre and post).</td>\n\n      <td>In CA1, LTP is reduced at both ages, and there were no significant differences in the effects of the two lead concentrations or with the duration of exposure. In CA3 there were no differences with time of exposure, but there was a dramatic difference in response as a function of age. At 30 days LTP was significantly reduced, but at 60 days LTP was increased by about 30%. As in the chronic exposure studies, lead reduced LTP in CA1 at both ages but reduced LTP in CA3 in 30-day animals while potentiating LTP in 60-day animals.</td>\n\n      <td></td>\n\n      <td>Carpenter et al., 2002</td>\n\n    </tr>\n\n    <tr>\n\n      <td></td>\n\n    </tr>\n\n  </tbody>\n\n</table>\n\n<h3><span id=\"Uncertainties_or_Inconsistencies\">Uncertainties or Inconsistencies</span></h3>\n\n<p>The structural diversity of NMDA subunits can influence the functionality of the receptors and their permeability to Ca2+. For example, NR2B subunits show higher affinity for glutamate binding and higher Ca2+ permeability (reviewed in Higley and Sabatini, 2012). But NMDA receptor subunit composition is not the only parameter that influences Ca2+ entrance in the cytosol. Membrane potential due to pore blockade by extracellular Mg2+ and receptor phosphorylation are two additional regulator of Ca2+ influx through NMDA receptors (reviewed in Higley and Sabatini, 2012).</p>\n\n<p>Entrance of Ca2+ into neuronal cell can also happen through KA and AMPA receptors but to a smaller extend compared to NMDA receptors (reviewed in Higley and Sabatini, 2012). However, recent findings suggest that AMPA receptors may also contribute to Ca2+ signalling during CNS development (reviewed in Cohen and Greenberg, 2008). Early in development cortical pyramidal neurons express calcium-permeable, GluR2 subunitâ€“lacking AMPA receptors. During postnatal development these neurons undergo a switch in the subunit composition of AMPA receptors, expressing instead GluR2-containing, calcium-impermeable AMPA receptor suggesting that the main point entrance of Ca2+ at this developmental stage are NMDA receptors.</p>\n\n<p>Furthermore, Ca2+ entry occurs through L- and H-type voltage-dependent Ca2+channels (L-VDCCs) (Perez-Reyes and Schneider, 1994; Berridge, 1998; Felix, 2005) that are encountered in neurons, suggesting that there are more possible entrance sites for Ca2+ to get into the cytosol rather than only through NMDA receptors.</p>\n\n<p>Interestingly, Pb2+ has the ability to mimic or even compete with Ca2+ in the CNS (Flora et al., 2006). Indeed, Pb2+ is accumulated in the same mitochondrial compartment as Ca2+ and it has been linked to disruptions in intracellular calcium metabolism (Bressler and Goldstein, 1991). So, it can be that the reduced levels of Ca2+ after Pb2+ exposure may not be attributed to NMDA receptor inhibition but also to the ability of this heavy metal to compete with Ca2+. To make things more complicated, recent findings suggest that BDNF can also acutely elicit an increase in intracellular Ca2+ concentration, which is attributed not only to the influx of extracellular Ca2+ but also to Ca2+ mobilization from intracellular calcium stores (Numakawa et al., 2002; He et al., 2005). These finding derive from primary cultures of cortical neurons (E18 or 2-3 PND), where BDNF-evoked Ca2+ signals have not been altered neither by tetrodotoxin nor by a cocktail of glutamate receptor blockers (CNQX and APV), pointing out the importance of BDNF in Ca2+ homeostasis (Numakawa et al., 2002; He et al., 2005).</p>\n\n</body>\n\n</html>\n\n",
										link_effecttoeffect9_weigth0).setFormat(ContentFormat.HTML).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect9
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										link_effecttoeffect9,
										dataSource,
										"Quantitative Understanding of the Linkage",
										"<html><i>Is it known how much change in the first event is needed to impact the second? Are there known modulators of the response-response relationships? Are there models or extrapolation approaches that help describe those relationships?</i>\n\nNo enough data is available to address the questions above.</html>")
										.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 2);
				link_effecttoeffect9.getReferenceIDs().add(new Reference(link_effecttoeffect9, dataSource, "Berridge MJ. (1998) Neuronal calcium signaling. Neuron 21: 13-26.").<Reference> makeItLive());
				link_effecttoeffect9.getReferenceIDs().add(
						new Reference(link_effecttoeffect9, dataSource, "Bressler JP, Goldstein GW. (1991) Mechanisms of lead neurotoxicity. Biochem Pharmacol. 41: 479-484.").<Reference> makeItLive());
				link_effecttoeffect9
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect9,
										dataSource,
										"Carpenter DO, Hussain RJ, Berger DF, Lombardo JP, Park HY. (2002) Electrophysiologic and behavioral effects of perinatal and acute exposure of rats to lead and polychlorinated biphenyls. Environ Health Perspect. 110: 377-386.")
										.<Reference> makeItLive());
				link_effecttoeffect9.getReferenceIDs().add(
						new Reference(link_effecttoeffect9, dataSource,
								"Cohen S, Greenberg ME. (2008) Communication between the synapse and the nucleus in neuronal development, plasticity and disease. Annu Rev Cell Dev Biol. 24: 183-209.")
								.<Reference> makeItLive());
				link_effecttoeffect9
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect9,
										dataSource,
										"Cordova FM, Rodrigues LS, Giocomelli MBO, Oliveira CS, Posser T, Dunkley PR, Leal RB. (2004) Lead stimulates ERK1/2 and p38MAPK phosphorylation in the hippocampus of immature rats. Brain Res. 998: 65-72.")
										.<Reference> makeItLive());
				link_effecttoeffect9.getReferenceIDs().add(
						new Reference(link_effecttoeffect9, dataSource, "Felix R. (2005) Molecular regulation of voltage-gated Ca2+ channels. J Recept Signal Transduct Res. 25: 57-71.").<Reference> makeItLive());
				link_effecttoeffect9
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect9,
										dataSource,
										"Ferguson C, Kern M, Audesirk G. (2000) Nanomolar concentrations of inorganic lead increase Ca2+ efflux and decrease intracellular free Ca2+ ion concentrations in cultured rat hippocampal neurons by a calmodulin-dependent mechanism. Neurotoxicology 21: 365-378.")
										.<Reference> makeItLive());
				link_effecttoeffect9
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect9,
										dataSource,
										"Flora SJS, Flora G, Saxena G. (2006) Environmental occurrence, health effects and management of lead poisoning, in Lead: Chemistry, Analytical Aspects, Environmental Impacts and Health Effects (Cascas SB and Sordo J eds) Elsevier, Amsterdam, The Netherlands, pp 158-228.")
										.<Reference> makeItLive());
				link_effecttoeffect9.getReferenceIDs().add(
						new Reference(link_effecttoeffect9, dataSource,
								"He J, Gong H, Luo Q. (2005) BDNF acutely modulates synaptic transmission and calcium signalling in developing cortical neurons. Cell Physiol Biochem. 16: 69-76.").<Reference> makeItLive());
				link_effecttoeffect9.getReferenceIDs().add(
						new Reference(link_effecttoeffect9, dataSource,
								"He T, Hirsch HV, Ruden DM, Lnenicka GA. (2009) Chronic lead exposure alters presynaptic calcium regulation and synaptic facilitation in Drosophila larvae. Neurotoxicology 30: 777-784.")
								.<Reference> makeItLive());
				link_effecttoeffect9.getReferenceIDs().add(
						new Reference(link_effecttoeffect9, dataSource, "Higley MJ, Sabatini BL. (2012) Calcium signalling in dendritic spines. Cold Spring Harb Perspect Biol 4: a005686.").<Reference> makeItLive());
				link_effecttoeffect9.getReferenceIDs().add(
						new Reference(link_effecttoeffect9, dataSource,
								"Hussain RJ, Parsons PJ, Carpenter DO. (2000) Effects of lead on long-term potentiation in hippocampal CA3 vary with age. Brain Res Dev Brain Res. 121: 243-252.").<Reference> makeItLive());
				link_effecttoeffect9
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect9,
										dataSource,
										"Li XM, Gu Y, She JQ, Zhu DM, Niu ZD, Wang M, Chen JT, Sun LG, Ruan DY. (2006) Lead inhibited N-methyl-D-aspartate receptor-independent long-term potentiation involved ryanodine-sensitive calcium stores in rat hippocampal area CA1. Neuroscience. 139: 463-473.")
										.<Reference> makeItLive());
				link_effecttoeffect9
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect9,
										dataSource,
										"Liu F, Patterson TA, Sadovova N, Zhang X, Liu S, Zou X, Hanig JP, Paule MG, Slikker W Jr, Wang C. (2013) Ketamine-induced neuronal damage and altered N-methyl-D-aspartate receptor function in rat primary forebrain culture. Toxicol Sci. 131: 548-557.")
										.<Reference> makeItLive());
				link_effecttoeffect9
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect9,
										dataSource,
										"Numakawa T, Yamagishi S, Adachi N, Matsumoto T, Yokomaku D, Yamada M, Hatanaka H (2002) Brain-derived neurotrophic factor-induced potentiation of Ca2+ oscillations in developing cortical neurons. J Biol Chem. 277: 6520-6529.")
										.<Reference> makeItLive());
				link_effecttoeffect9
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect9,
										dataSource,
										"Okada H, Miyakawa N, Mori H, Mishina M, Miyamoto Y, Hisatsune T. (2003) NMDA receptors in cortical development are essential for the generation of coordinated increases in [Ca2+](i) in \"neuronal domains\". Cereb Cortex. 13 :749-757.")
										.<Reference> makeItLive());
				link_effecttoeffect9.getReferenceIDs().add(
						new Reference(link_effecttoeffect9, dataSource, "Perez-Reyes E, Schneider T. (1994) Calcium channels: Structure, function, and classification. Drug Dev Res. 33: 295â€“318.")
								.<Reference> makeItLive());
				link_effecttoeffect9.getReferenceIDs().add(
						new Reference(link_effecttoeffect9, dataSource, "Sandhir R, Gill KD. (1994) Alterations in calcium homeostasis on lead exposure in rat synaptosomes. Mol Cell Biochem. 131: 25-33.")
								.<Reference> makeItLive());
				link_effecttoeffect9.getReferenceIDs().add(
						new Reference(link_effecttoeffect9, dataSource,
								"Schneider JS, Mettil W, Anderson DW. (2012) Differential Effect of Postnatal Lead Exposure on Gene Expression in the Hippocampus and Frontal Cortex. J Mol Neurosci. 47: 76-88.")
								.<Reference> makeItLive());
				link_effecttoeffect9
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect9,
										dataSource,
										"Sinner B, Friedrich O, Zink W, Martin E, Fink RH, et al. (2005) Ketamine stereoselectively inhibits spontaneous Ca2+-oscillations in cultured hippocampal neurons. Anesthesia and analgesia 100: 1660-1666.")
										.<Reference> makeItLive());
				link_effecttoeffect9.getReferenceIDs().add(
						new Reference(link_effecttoeffect9, dataSource, "Toscano CD, Guilarte TR. (2005) Lead neurotoxicity: From exposure to molecular effects. Brain Res Rev. 49: 529-555.").<Reference> makeItLive());
				link_effecttoeffect9
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect9,
										dataSource,
										"Toscano CD, Hashemzadeh-Gargari H, McGlothan JL, Guilarte TR. (2002) Developmental Pb2+ exposure alters NMDAR subtypes and reduces CREB phosphorylation in the rat brain. Dev Brain Res. 139: 217-226.")
										.<Reference> makeItLive());
				link_effecttoeffect9
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect9,
										dataSource,
										"Toscano CD, McGlothan JL, Guilarte TR. (2003) Lead exposure alters cyclic-AMP response element binding protein phosphorylation and binding activity in the developing rat brain. Dev Brain Res. 145: 219-228.")
										.<Reference> makeItLive());
				
				link_effecttoeffect11 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect8, effect_downstreameffect10);
				link_effecttoeffect11.setLinkType(LinkType.UNKNOWN);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect11_weigth0 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect11, dataSource, Link_EffectToEffect.class, 1.0);
				link_effecttoeffect11
						.getDescriptionIDs()
						.set(
								new DescriptionSection_Structured(
										link_effecttoeffect11,
										dataSource,
										"(Key) Event Relationships Weight of Evidences",
										"\n\nHow Does This Key Event Relationship Work\n\nMainly, NMDA receptor activation initiates Ca2+-dependent signaling events that regulate the expression of genes involved in regulation of neuronal function including bdnf (reviewed in Cohen and Greenberg, 2008). Inhibition of NMDA receptors results in low levels of Ca2+ and decreased transcription of BDNF and consequently to low level of BDNF protein production and release. \n\nâ€¢ Biological Plausibility: \n\nBDNF transcription is induced by Ca2+ entering through either L type voltage gated calcium channel (L-VGCC) (Tao et al., 1998) or NMDA receptor (Tabuchi et al., 2000; Zheng et al., 2011) that can last up to 6 h. BDNF IV that is the most studied among its different exons has been shown to bind three Ca2+ elements within the regulatory region (reviewed in Zheng et al., 2012). One of these Ca2+ elements binds to CREB facilitating transcription. However, more transcription factors rather than only CREB are implicated in the transcription process of BDNF such as NFAT (nuclear factor of activated T cell), MEF2 (myocyte enhancer factor 2) and NFÎºB (nuclear factor ÎºB) (reviewed in Zheng et al., 2012). The activation of the relevant transcription factor is triggered by the initial activation of CaM kinase, cAMP/PKA and Ras/ERK1/2 pathways mediated by the elevated intracellular Ca2+. Interestingly, inhibitory studies targeting different elements of these pathways report reduction at mRNA BDNF levels (reviewed in Zheng et al., 2012). \n\nIn particular, exon IV BDNF mRNA transcription is regulated by a transcriptional silencer, methyl-CpG binding protein 2 (MeCP2), demonstrating that epigenetic alterations can also regulate BDNF transcription. Increase of intracellular Ca2+ levels phosphorylates MeCP2, which inactivates its repressor function and permits the transcription of BDNF exon IV (Chen et al., 2003; Greer and Greenberg, 2008; Tao et al., 2009; Zhou et al., 2006). Indeed, NMDA receptor activation has been shown to upregulate BDNF transcripts containing exon IV not only via Ca2+-dependent CREB but also through Ca2+ activation of MeCP2 transcription (Metsis et al., 1993; Shieh et al., 1998, Tao et al., 1998; Tabuchi et al., 2000; Chen et al., 2003; Jiang et al., 2005; Zheng et al., 2011), whereas NMDAR antagonists decrease BDNF exon IV expression (Zafra et al., 1991; Stansfield et al., 2012). Furthermore, BDNF mRNA is also targeted in different locations within the cell during the process of translation, depending on the promoter used (reviewed in Tongiorgi et al., 2006). \n\nâ€¢ Empirical Support for Linkage:\n\nThere is no direct evidence linking reduced levels of Ca2+ to decreased BDNF levels as they have not been ever measured both in the same study after exposure to stressors. However, there are findings that strongly link the different elements of Ca2+-dependent signalling events to transcription of BDNF. \n\nPb2+: Pb2+ decreases the ratio of phosphorylated versus total MeCP2 and consequently MeCP2 maintains its repressor function and prevents BDNF exon IV transcription (Stansfield et al., 2012). MeCP2 gene expression in the frontal cortex is very sensitive to Pb2+ exposure while in the hippocampus, the same gene is affected only at the higher exposure group in rat pups with blood Pb2+ levels 5.8 to 10.3 Î¼g/dl on PND 55 (Schneider et al., 2012). In two different in vivo studies from the same research group, the use of doses of Pb2+ that result in learning and LTP deficits in rats causes decrease in phosphorylation of CREB in cerebral cortex at 14 PND and the same reduction in phosphorylation state of CREB in both cortex and hippocampus at PND 50 (Toscano et al., 2002; 2003). Interestingly, under similar experimental conditions no alteration at the phosphorylation state of CAMKII has been recorded (Toscano et al., 2005). In primary hippocampal neurons exposed to 1 Î¼M Pb2+ for 5 days during the period of synaptogenesis (DIV7â€“DIV12), both the cellular and extracellular proBDNF protein levels of mBDNF decrease with the latter to smaller extend (Neal et al., 2010). In the same in vitro model, Pb2+ also decreases dendritic proBDNF protein levels throughout the length of the dendrites and causes impairment of BDNF vesicle transport to sites of release in dendritic spines (Stansfield et al., 2012). Furthermore, Pb2+ treatment resulted in a specific reduction of Bdnf exon IV and IX mRNA transcripts causing no alteration in the expression of exons I and II (Stansfield et al., 2012). Rat pups on PND 25 exposed to Pb2+ (180 and 375-ppm lead acetate in food for 30 days) demonstrated blood Pb2+ levels 5.8 to 10.3 Î¼g/dl on PND 55 and show no change at gene levels of BDNF (Schneider et al., 2012). In mouse embryonic stem cells (ESCs), Bdnf exon IV has been found to be down-regulated in cells treated with 0.1 ÂµM Pb, whereas Bdnf exon IX has been found up-regulated (SÃ¡nchez-MartÃ­n et al., 2013). \n\nâ€¢ Uncertainties or Inconsistencies:\n\nIn a gene expression study, where gene analysis has been performed in the hippocampus derived from male or female rats fed with 1500 ppm Pb2+-containing chow for 30 days beginning at weaning, two molecular networks have been identified that were different between male and female treated rats. In these networks, CREB was the highly connected node, common for both networks (Schneider et al., 2011). However, no change has been reported in the expression of bdnf gene neither in male nor in female rats treated with Pb2+ (Schneider et al., 2011). \n\n",
										link_effecttoeffect11_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect11
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect11,
										dataSource,
										"Chen WG, Chang Q, Lin Y, Meissner A, West AE, Griffith EC, Jaenisch R, Greenberg ME. (2003) Derepression of BDNF transcription involves calcium-dependent phosphorylation of MeCP2. Science. 302: 885-889. ")
										.<Reference> makeItLive());
				link_effecttoeffect11.getReferenceIDs().add(
						new Reference(link_effecttoeffect11, dataSource,
								"Cohen S, Greenberg ME. (2008) Communication between the synapse and the nucleus in neuronal development, plasticity and disease. Annu Rev Cell Dev Biol. 24: 183-209. ")
								.<Reference> makeItLive());
				link_effecttoeffect11.getReferenceIDs().add(
						new Reference(link_effecttoeffect11, dataSource,
								"Greer PL, Greenberg ME. (2008) From synapse to nucleus: Calcium-dependent gene transcription in the control of synapse development and function. Neuron 59: 846-860. ")
								.<Reference> makeItLive());
				link_effecttoeffect11
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect11,
										dataSource,
										"Heaton MB, Mitchell JJ, Paiva M. (1999) Ethanol-induced alterations in neurotrophin expression in developing cerebellum: relationship to periods of temporal susceptibility. Alcohol Clin Exp Res. 23: 1637-1642. ")
										.<Reference> makeItLive());
				link_effecttoeffect11
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect11,
										dataSource,
										"Jiang X, Tian F, Mearow K, Okagaki P, Lipsky RH, Marini AM. (2005) The excitoprotective effect of N-methyl-D-aspartate receptors is mediated by a brain-derived neurotrophic factor autocrine loop in cultured hippocampal neurons. J Neurochem. 94: 713-722. ")
										.<Reference> makeItLive());
				link_effecttoeffect11
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect11,
										dataSource,
										"Metsis M, Timmusk T, Arenas E, Persson H. (1993) Differential usage of multiple brain-derived neurotrophic factor promoters in the rat brain following neuronal activation. Proc Natl Acad. Sci USA. 90: 8802-8806. ")
										.<Reference> makeItLive());
				link_effecttoeffect11
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect11,
										dataSource,
										"Neal AP, Stansfield KH, Worley PF, Thompson RE, Guilarte TR. (2010) Lead exposure during synaptogenesis alters vesicular proteins and impairs vesicular release: Potential role of NMDA receptor-dependent BDNF signaling. Toxicol Sci. 116: 249-263. ")
										.<Reference> makeItLive());
				link_effecttoeffect11
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect11,
										dataSource,
										"SÃ¡nchez-MartÃ­n FJ, Fan Y, Lindquist DM, Xia Y, Puga A. (2013) Lead Induces Similar Gene Expression Changes in Brains of Gestationally Exposed Adult Mice and in Neurons Differentiated from Mouse Embryonic Stem Cells. PLoS One 8: e80558. ")
										.<Reference> makeItLive());
				link_effecttoeffect11
						.getReferenceIDs()
						.add(
								new Reference(link_effecttoeffect11, dataSource,
										"Schneider JS, Anderson DW, Sonnenahalli H, Vadigepalli R. (2011) Sex-based differences in gene expression in hippocampus following postnatal lead exposure. Toxicol Appl Pharmacol. 256: 179-190. ")
										.<Reference> makeItLive());
				link_effecttoeffect11.getReferenceIDs().add(
						new Reference(link_effecttoeffect11, dataSource,
								"Schneider JS, Mettil W, Anderson DW. (2012). Differential Effect of Postnatal Lead Exposure on Gene Expression in the Hippocampus and Frontal Cortex. J Mol Neurosci. 47: 76-88. ")
								.<Reference> makeItLive());
				link_effecttoeffect11.getReferenceIDs()
						.add(
								new Reference(link_effecttoeffect11, dataSource,
										"Shieh PB, Hu SC, Bobb K, Timmusk T, Ghosh A. (1998) Identification of a signaling pathway involved in calcium regulation of BDNF expression. Neuron 20: 727â€“740. ")
										.<Reference> makeItLive());
				link_effecttoeffect11
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect11,
										dataSource,
										"Stansfield KH, Pilsner JR, Lu Q, Wright RO, Guilarte TR. (2012) Dysregulation of BDNF-TrkB signaling in developing hippocampal neurons by Pb(2+): implications for an environmental basis of neurodevelopmental disorders. Toxicol Sci. 127: 277-295. ")
										.<Reference> makeItLive());
				link_effecttoeffect11
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect11,
										dataSource,
										"Toscano CD, Hashemzadeh-Gargari H, McGlothan JL, Guilarte TR. (2002) Developmental Pb2+ exposure alters NMDAR subtypes and reduces CREB phosphorylation in the rat brain. Brain Res Dev Brain Res. 139: 217-226. ")
										.<Reference> makeItLive());
				link_effecttoeffect11
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect11,
										dataSource,
										"Toscano CD, McGlothan JL, Guilarte TR. (2003) Lead exposure alters cyclic-AMP response element binding protein phosphorylation and binding activity in the developing rat brain. Brain Res. Dev. Brain Res. 145: 219-228. ")
										.<Reference> makeItLive());
				link_effecttoeffect11
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect11,
										dataSource,
										"Toscano CD, O'Callaghan JP, Guilarte TR. (2005) Calcium/calmodulin-dependent protein kinase II activity and expression are altered in the hippocampus of Pb2+-exposed rats. Brain Res. 1044: 51â€“58. ")
										.<Reference> makeItLive());
				link_effecttoeffect11
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect11,
										dataSource,
										"Tabuchi A, Nakaoka R, Amano K, Yukimine M, Andoh T, Kuraishi Y and Tsuda M. (2000) Differential activation of brain-derived neurotrophic factor gene promoters I and III by Ca2+ signals evoked via L-type voltage-dependent and N-methyl-D-aspartate receptor Ca2+ channels. J Biol Chem. 275: 17269-17275. ")
										.<Reference> makeItLive());
				link_effecttoeffect11
						.getReferenceIDs()
						.add(
								new Reference(link_effecttoeffect11, dataSource,
										"Tongiorgi E, Domenici L, Simonato M. (2006) What is the biological significance of BDNF mRNA targeting in the dendrites? Clues from epilepsy and cortical development. Mol Neurobiol. 33: 17-32. ")
										.<Reference> makeItLive());
				link_effecttoeffect11
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect11,
										dataSource,
										"Zheng F, Zhou X, Luo Y, Xiao H, Wayman G, Wang H. (2011) Regulation of brain-derived neurotrophic factor exon IV transcription through calcium responsive elements in cortical neurons. PLoS One 6: e28441. ")
										.<Reference> makeItLive());
				link_effecttoeffect11.getReferenceIDs().add(
						new Reference(link_effecttoeffect11, dataSource,
								"Zheng F, Zhou X, Moon C, Wang H. (2012) Regulation of brain-derived neurotrophic factor expression in neurons. In J Pathophysiol Pharmacol 4: 188-200. ").<Reference> makeItLive());
				link_effecttoeffect11.getReferenceIDs().add(
						new Reference(link_effecttoeffect11, dataSource,
								"Tao X, Finkbeiner S, Arnold DB, Shaywitz AJ, Greenberg ME. (1998) Ca2+ influx regulates BDNF transcription by a CREB family transcription factor-dependent mechanism. Neuron 20: 709-726. ")
								.<Reference> makeItLive());
				link_effecttoeffect11
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect11,
										dataSource,
										"Tao J, Hu K, Chang Q, Wu H, Sherman NE, Martinowich K, Klose RJ, Schanen C, Jaenisch R, Wang W, et al. (2009) Phosphorylation of MeCP2 at Serine 80 regulates its chromatin association and neurological function. Proc Natl Acad Sci USA. 106: 4882-4887. ")
										.<Reference> makeItLive());
				link_effecttoeffect11
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect11,
										dataSource,
										"Zafra F, CastrÃ©n E, Thoenen H, Lindholm D. (1991) Interplay between glutamate and gamma-aminobutyric acid transmitter systems in the physiological regulation of brain-derived neurotrophic factor and nerve growth factor synthesis in hippocampal neurons. Proc Natl Acad Sci U S A. 88: 10037-10041. ")
										.<Reference> makeItLive());
				link_effecttoeffect11
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect11,
										dataSource,
										"Zhou Z, Hong EJ, Cohen S, Zhao WN, Ho HY, Schmidt L, Chen WG, Lin Y, Savner E, Griffith EC, et al. (2006) Brain-specific phosphorylation of MeCP2 regulates activity-dependent Bdnf transcription, dendritic growth, and spine maturation. Neuron 52: 255-269. ")
										.<Reference> makeItLive());
				
				link_effecttoeffect15 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect10, effect_downstreameffect12);
				link_effecttoeffect15.setLinkType(LinkType.UNKNOWN);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect15_weigth0 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect15, dataSource, Link_EffectToEffect.class, 1.0);
				link_effecttoeffect15
						.getDescriptionIDs()
						.set(
								new DescriptionSection_Structured(
										link_effecttoeffect15,
										dataSource,
										"(Key) Event Relationships Weight of Evidences",
										"How Does This Key Event Relationship Work\n\nBDNF, acting via its specific presynaptic receptor TrkB, has been shown to increase excitatory synaptic transmission by triggering presynaptic glutamate release in hippocampal cultures as well as in hippocampal and cortical slices (Lessmann et al., 1994; Kang and Schuman, 1995; Carmignoto et al., 1997; Mohajerani et al., 2007). \n\nâ€¢ Biological Plausibility: \n\nExperimentally, it has been shown that presynaptically, BDNF enhances glutamate release and increases the frequency of mEPSCs in hippocampal neurons of rat (Lessmann and Heumann, 1998; Takei et al., 1998; Minichiello, 2009). It has been reported that BDNF rapidly induces glutamate transporter-mediated glutamate release via phospholipase C-Î³ (PLC-Î³)/Ca2+ signaling and that antidepressants enhance PLC-Î³/Ca2+ signaling leading to reduced levels of BDNF that cause decreased glutamate release (Numakawa et al., 2002; Yagasaki et al., 2006). \n\nâ€¢ Empirical Support for Linkage:\n\nIn cortical cultured neurons obtained from PND 2-3 rat pups, BDNF fails to induce glutamate release at DIV 3 and 4. However, after 5 days in vitro culture or more (DIV 6-9), BDNF (100 ng/ml) induces significant glutamate release (2-2.8 fold) within 1 min after exogenous application (Numakawa et al., 2002). \n\nIt has been shown that there is a dose-dependent effect of BDNF on the glutamate release. The glutamate release is initially observed at 5 ng/ml BDNF and reaches a plateau at 100 ng/ml (Numakawa et al., 2002). \n\nNo studies have been found in the literature measuring both KEs after exposure to the stressors. Interestingly, proton magnetic resonance spectroscopy in adults with childhood lead exposure shows decrease in a composite of glutamate and glutamine in vermis and in parietal white matter of the brain (Cecil et al., 2011). \n\nâ€¢ Uncertainties or Inconsistencies:\n\nRecently, in heterozygous BDNF-knockout (BDNF+/âˆ’) mice it has been demonstrated that the reduced BDNF levels did not affect presynaptic glutamate release (Meis et al., 2012). ",
										link_effecttoeffect15_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect15
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect15,
										dataSource,
										"Carmignoto G, Pizzorusso T, Tia S, Vicini S. (1997) Brain-derived neurotrophic factor and nerve growth factor potentiate excitatory synaptic transmission in the rat visual cortex. J Physiol. 498: 153-164. ")
										.<Reference> makeItLive());
				link_effecttoeffect15
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect15,
										dataSource,
										"Cecil KM, Dietrich KN, Altaye M, Egelhoff JC, Lindquist DM, Brubaker CJ, Lanphear BP. (2011) Proton magnetic resonance spectroscopy in adults with childhood lead exposure. Environ Health Perspect. 119: 403-408. ")
										.<Reference> makeItLive());
				link_effecttoeffect15.getReferenceIDs().add(
						new Reference(link_effecttoeffect15, dataSource,
								"Kang H, Schuman EM. (1995) Long-lasting neurotrophin-induced enhancement of synaptic transmission in the adult hippocampus. Science. 267: 1658-1662. ").<Reference> makeItLive());
				link_effecttoeffect15.getReferenceIDs().add(
						new Reference(link_effecttoeffect15, dataSource,
								"Lessmann V, Gottmann K, Heumann R. (1994) BDNF and NT-4/5 enhance glutamatergic synaptic transmission in cultured hippocampal neurones. Neuroreport 6: 21-25. ").<Reference> makeItLive());
				link_effecttoeffect15
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect15,
										dataSource,
										"Lessmann V, Heumann R. (1998) Modulation of unitary glutamatergic synapses by neurotrophin-4/5 or brain-derived neurotrophic factor in hippocampal microcultures: presynaptic enhancement depends on pre-established paired-pulse facilitation. Neuroscience 86: 399-413. ")
										.<Reference> makeItLive());
				link_effecttoeffect15.getReferenceIDs().add(
						new Reference(link_effecttoeffect15, dataSource,
								"Meis S, Endres T, Lessmann V. (2012) Postsynaptic BDNF signalling regulates long-term potentiation at thalamo-amygdala afferents. J Physiol. 590: 193-208. ").<Reference> makeItLive());
				link_effecttoeffect15.getReferenceIDs().add(
						new Reference(link_effecttoeffect15, dataSource, "Minichiello L. (2009) TrkB signalling pathways in LTP and learning. Nat Rev Neurosci. 10: 850-860. ").<Reference> makeItLive());
				link_effecttoeffect15
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect15,
										dataSource,
										"Mohajerani MH, Sivakumaran S, Zacchi P, Aguilera P, Cherubini E. (2007) Correlated network activity enhances synaptic efficacy via BDNF and the ERK pathway at immature CA3 CA1 connections in the hippocampus. Proc Natl Acad Sci U S A. 104: 13176-13181. ")
										.<Reference> makeItLive());
				link_effecttoeffect15
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect15,
										dataSource,
										"Numakawa T, Yamagishi S, Adachi N, Matsumoto T, Yokomaku D, Yamada M, Hatanaka H. (2002) Brain-derived neurotrophic factor-induced potentiation of Ca2+ oscillations in developing J Biol Chem. 277: 6520-6529. ")
										.<Reference> makeItLive());
				link_effecttoeffect15
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect15,
										dataSource,
										"Takei N, Numakawa T, Kozaki S, Sakai N, Endo Y, Takahashi M, et al. (1998) Brain-derived neurotrophic factor induces rapid and transient release of glutamate through the non-exocytotic pathway from cortical neurons. J Biol Chem. 273: 27620-27624. ")
										.<Reference> makeItLive());
				link_effecttoeffect15
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect15,
										dataSource,
										"Yagasaki Y, Numakawa T, Kumamaru E, Hayashi T, Su TP, Kunugi H. (2006) Chronic antidepressants potentiate via sigma-1 receptors the brain-derived neurotrophic factor-induced signaling for glutamate release. J Biol Chem. 281: 12941-12949. ")
										.<Reference> makeItLive());
				
				link_effecttoeffect16 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect10, effect_downstreameffect13);
				link_effecttoeffect16.setLinkType(LinkType.UNKNOWN);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect16_weigth0 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect16, dataSource, Link_EffectToEffect.class, 1.0);
				link_effecttoeffect16
						.getDescriptionIDs()
						.set(
								new DescriptionSection_Structured(
										link_effecttoeffect16,
										dataSource,
										"(Key) Event Relationships Weight of Evidences",
										"How Does This Key Event Relationship Work\n\nBDNF influences the apoptosis occurring in developing neurons through two distinct mechanisms (Bernd, 2008). mBDNF can trigger prosurvival signaling after binding to TrkB receptor through inactivation of components of the cell death machinery and also through activation of the transcription factor cAMP-response element binding protein (CREB), which drives expression of the pro-survival gene Bcl-2 (West et al., 2001). On the other hand, proBDNF binds to the p75 neurotrophin receptor (p75NTR) and activates RhoA that regulates actin cytoskeleton polymerization resulting in apoptosis (Lee et al., 2001; Miller and Kaplan, 2001; Murray and Holmes, 2011). It is proved that reduced levels of BDNF can severely interfere with the survival of neurons in different brain regions, leading to cell death (Lee et al., 2001; Miller and Kaplan, 2001; Murray and Holmes, 2011). \n\nâ€¢ Biological Plausibility: \n\nBDNF mRNA levels dramatically increase between embryonic days 11 to 13 during rat development, playing important role in neuronal differentiation and survival (reviewed in Murray and Holmes, 2011). The latter has been supported by transgenic experiments where BNDFâˆ’/âˆ’ mice demonstrated a dramatic increase in cell death among developing granule cells leading to impaired development of the layers of the cerebellar cortex (Schwartz et al., 1997). BDNF has also been shown to provide neuroprotection after hypoxic-ischemic brain injury in neonates (P7) but not in older (P21) animals (Cheng et al., 1997; Han and Holtzman, 2000). The neuroprotective role of BDNF has been further supported by the observed correlation between elevated BDNF protein levels and resistance to ischemic damage in hippocampus in vivo (Kokaia et al., 1996) and K+ rich medium-induced apoptosis in vitro (Kubo et al., 1995). \n\nâ€¢ Empirical Support for Linkage:\n\nSeveral in vitro and in vivo studies on cortical neurons have demonstrated that the survival of developing neurons is closely related with the activation of the NMDA receptors and subsequent BDNF synthesis/release that fully support the BDNF neurotrophic theory (Ikonomidou et al., 1999; Yoon et al., 2003; Hansen et al., 2004). \n\nPb2+: Neonatal mice exposed to Pb2+ (350 mg/kg lead twice every 4 h) and sacrificed after 8-24 h show increased apoptotic neurodegeneration above that seen in normal controls. This effect has been recorded only in animals treated with Pb2+ at PND 7, but not at PND 14 (Dribben et al., 2011), confirming the importance of the time of exposure during development in order for Pb2+ to induce apoptosis. Two to four weeks old rats treated for 7 days with 15 mg/kg daily dose of lead acetate show increased apoptosis in hippocampus (Sharifi et al., 2002). In rats (30 PND), it has also been shown that Pb2+ (2, 20 and 200 mg/kg/d) can induce apoptosis (Liu et al., 2010). However, in contrast to the first two in vivo studies, the animals in this experimental approach were old enough to evaluate the most sensitive window of vulnerability of developing neurons to Pb2+ exposure (Liu et al., 2010), confirming that only Pb2+ treatment during synaptogenesis can lead to neuronal cell apoptosis. In vitro evidence of apoptosis induced by Pb2+ also derive from PC12 cells exposed to Pb2+ (0.1, 1, 10 ÂµM) that have shown increased activation of caspase-3 (Xu et al., 2006). Besides PC12 cells (Xu et al., 2006; Sharifi and Mousavi, 2008), lead-induced apoptosis has also been studied in cultured rat cerebellar neurons (Oberto et al., 1996), hippocampal neurons (Niu et al., 2002) and retinal rod cells (He et al., 2000). No significant increase in LDH release was found in neuro-spheres derived from neural stem cells (NSCs) originating from E15 rat cortex (CX), striatum (ST) or ventral mesencephalon (VM) after assessing at 24 h intervals from day 1 through day 7 after addition of lead acetate (0.1â€“10 Î¼M) (Huang and Schneider, 2004). However, LDH release was increased 1 day after addition of 100 Î¼M lead acetate (1.6-2.1 fold depending on the brain region) and 3 days after addition of 50 Î¼M lead acetate to the culture medium (1.3-1.5 fold depending on the brain region). No significant cell loss was observed in cultures exposed to 0.1â€“10 Î¼M lead acetate for 7 days after staining with Hoechst 33342. In contrast, significant cell loss was observed 7 days after exposure to 50 Î¼M (35-50% depending on brain region) or 100 Î¼M lead acetate (60-75% depending on brain region) (Huang and Schneider, 2004). In primary rat hippocampal neurons exposed to 1 Î¼M Pb2+ for 5 days during the period of synaptogenesis (DIV7â€“DIV12), decreased cellular proBDNF protein (40% compared to control) and extracellular levels of mBDNF (25% compared to control) have been recorded (Neal et al., 2010). Significant reductions specifically in dendritic proBDNF protein levels throughout the length of the dendrites have also been described by Stansfield et al. (2012) after exposure to the same concentration of Pb2+ using this in vitro model. In an in vivo study, mice at PND 7 with mean Pb2+ blood levels of 8.10 Î¼g/mL have shown increased apoptosis in the cortex, hippocampus, caudate-putamen, and thalamus compared to controls with F (1,14) = 19.5, 8.40, 4.15, 4.53, respectively (Dribben et al., 2011). These Pb2+ levels in blood (Dribben et al., 2011) were a bit higher than the levels determined in Guilarte et al. 2003 (3.90 Î¼g/dl) that served as the base to calculate in vitro doses in Neal et al. 2010 and Stansfield et al. 2012. \n\nâ€¢ Uncertainties or Inconsistencies:\n\nPb2+: A number of studies demonstrate that deletion of BDNF does not lead to significant apoptotic cell death of neurons in the developing CNS (reviewed in Dekkers et al., 2013). In an in vivo Pb2+ exposure study, where female rats received 1,500 ppm prior, during breeding and lactation shows no changes at mRNA levels of BDNF in different hippocampus section derived from their pups (Guilarte et al., 2003). Regarding Pb2+, the pre- and neonatal exposure of rats to Pb2+ (Pb2+ blood levels below 10 Î¼g/dL) show a decreased number of hippocampus neurons but no morphological or molecular features of severe apoptosis or necrosis have been detected in tested brains (Baranowska-Bosiacka et al., 2013). In contrast to the lack of apoptotic signs, reduced levels of BDNF concentration (pg/mg protein) of BDNF in brain homogenates has been recorded in forebrain cortex (39%) and hippocampus (29%) (Baranowska-Bosiacka et al., 2013). Pregnant rats have been exposed to lead acetate (0.2% in the drinking water) after giving birth until PND 20. At PND 20, blood Pb2+ levels in pups reached at 80 Î¼g/dl. In these animals, the gene expression in different brain regions has been assessed and demonstrated that hippocampus is most sensitive with alterations beginning at PND 12 when caspase 3 mRNA increases after Pb2+ exposure (Chao et al., 2007). However, bcl-x and BDNF mRNA in the hippocampus have been significantly increased after caspase 3 increase, suggesting that the apoptotic signal activates a compensatory response by increasing survival factors like BDNF and that the temporality suggested in this AOP may not be accurate (Chao et al., 2007). \n\nSome of the reported â€œinconsistenciesâ€� may be due to the lack of sufficient details in the reporting since publications vary in what they measure. Some of the referenced studies look at BDNF transcripts, others look at BDNF protein. BDNF processing is highly complex and different mRNA transcripts are known to be implicated in different cellular function. \n\nSeveral studies addressing apoptosis mainly in the developing cerebral cortex have shown that more mechanism besides neurotrophic factors may be involved. Cytokines, as well as neurotransmitters can potentially activate a number of intracellular proteins that execute cell death (Henderson, 1996; Kroemer et al., 2009), meaning that further branches to this AOP might be added in the future. \n\n",
										link_effecttoeffect16_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect16
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect16,
										dataSource,
										"Baranowska-Bosiacka, StruÅ¼yÅ„ska L, Gutowska I, MachaliÅ„ska A, Kolasa A, KÅ‚os P, Czapski GA, Kurzawski M, Prokopowicz A, Marchlewicz M, Safranow K, MachaliÅ„ski B, Wiszniewska B, Chlubek D. (2013) Perinatal exposure to lead induces morphological, ultrastructural and molecular alterations in the hippocampus. Toxicology. 303: 187-200. ")
										.<Reference> makeItLive());
				link_effecttoeffect16.getReferenceIDs().add(
						new Reference(link_effecttoeffect16, dataSource, "Bernd P. (2008) The role of neurotrophins during early development. Gene Expr. 14: 241-250. ").<Reference> makeItLive());
				link_effecttoeffect16
						.getReferenceIDs()
						.add(
								new Reference(link_effecttoeffect16, dataSource,
										"Chao SL, Moss JM, Harry GJ. (2007) Lead-induced Alterations of Apoptosis and Neurotrophic Factor mRNA in the Developing Rat Cortex, Hippocampus, and Cerebellum. J Biochem Mol Toxicol. 21: 265-272. ")
										.<Reference> makeItLive());
				link_effecttoeffect16.getReferenceIDs().add(
						new Reference(link_effecttoeffect16, dataSource,
								"Cheng Y, Gidday JM, Yan Q et al (1997) Marked age-dependent neuroprotection by brain-derived neurotrophic factor against neonatal hypoxic-ischemic brain injury. Ann Neurol 41: 521-529. ")
								.<Reference> makeItLive());
				link_effecttoeffect16.getReferenceIDs().add(
						new Reference(link_effecttoeffect16, dataSource,
								"Dekkers MP, Nikoletopoulou V, Barde YA. (2013) Cell biology in neuroscience: Death of developing neurons: new insights and implications for connectivity. J Cell Biol. 203: 385-393. ")
								.<Reference> makeItLive());
				link_effecttoeffect16.getReferenceIDs().add(
						new Reference(link_effecttoeffect16, dataSource,
								"Dikranian K, Ishimaru MJ, Tenkova T, Labruyere J, Qin YQ, Ikonomidou C, Olney JW. (2001) Apoptosis in the in vivo mammalian forebrain. Neurobiol Dis. 8: 359-379. ").<Reference> makeItLive());
				link_effecttoeffect16.getReferenceIDs().add(
						new Reference(link_effecttoeffect16, dataSource,
								"Dribben WH, Creeley CE, Farber N. (2011) Low-level lead exposure triggers neuronal apoptosis in the developing mouse brain. Neurotoxicol Teratol. 33: 473-480. ").<Reference> makeItLive());
				link_effecttoeffect16.getReferenceIDs().add(
						new Reference(link_effecttoeffect16, dataSource, "Farber NB, Creeley CE, Olney JW. (2010) Alcohol-induced neuroapoptosis in the fetal macaque brain. Neurobiol Dis. 40:200-206. ")
								.<Reference> makeItLive());
				link_effecttoeffect16.getReferenceIDs().add(
						new Reference(link_effecttoeffect16, dataSource,
								"Frade JM, Bovolenta P, MartÃ­nez-Morales JR, Arribas A, Barbas JA, RodrÃ­guez-TÃ©bar A. (1997) Control of early cell death by BDNF in the chick retina. Development. 124: 3313-3320. ")
								.<Reference> makeItLive());
				link_effecttoeffect16.getReferenceIDs().add(
						new Reference(link_effecttoeffect16, dataSource,
								"Guilarte TR, Toscano CD, McGlothan JL, Weaver SA. (2003) Environmental enrichment reverses cognitive and molecular deficits induced by developmental lead exposure. Ann Neurol. 53: 50-56. ")
								.<Reference> makeItLive());
				link_effecttoeffect16.getReferenceIDs().add(
						new Reference(link_effecttoeffect16, dataSource,
								"Hallbook F, BÃ¤ckstrÃ¶m A, Kullander K, Kylberg A, Williams R, Ebendal T (1995). Neurotrophins and their receptors in chicken neuronal development. Int J Dev Biol. 39: 855-868. ")
								.<Reference> makeItLive());
				link_effecttoeffect16.getReferenceIDs().add(
						new Reference(link_effecttoeffect16, dataSource,
								"Han BH, Holtzman DM (2000) BDNF protects the neonatal brain from hypoxic-ischemic injury in vivo via the ERK pathway. J Neurosci. 20: 5775-57811. ").<Reference> makeItLive());
				link_effecttoeffect16
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect16,
										dataSource,
										"Hansen HH, Briem T, Dzietko M, Sifringer M, Voss A, Rzeski W, Zdzisinska B, Thor F, Heumann R, Stepulak A, Bittigau P, Ikonomidou C. (2004). Mechanisms leading to disseminated apoptosis following NMDA receptor blockade in the developing rat brain. Neurobiol Dis. 16: 440-453. ")
										.<Reference> makeItLive());
				link_effecttoeffect16
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect16,
										dataSource,
										"He L, Poblenz AT, Medrano CJ, Fox DA. Lead and calcium produce rod photoreceptor cell apoptosis by opening the mitochondrial permeability transition pore. J Biol Chem. 2000 Apr 21;275(16):12175-84. ")
										.<Reference> makeItLive());
				link_effecttoeffect16.getReferenceIDs().add(
						new Reference(link_effecttoeffect16, dataSource, "Henderson CE. (1996). Programmed cell death in the developing nervous system. Neuron 17: 579-585. ").<Reference> makeItLive());
				link_effecttoeffect16
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect16,
										dataSource,
										"Huang F, Schneider JS. (2004) Effects of lead exposure on proliferation and differentiation of neural stem cells derived from different regions of embryonic rat brain. Neurotoxicology 25: 1001â€“1012. ")
										.<Reference> makeItLive());
				link_effecttoeffect16
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect16,
										dataSource,
										"Ikonomidou C, Bosch F, Miksa M, Bittigau P, VÃ¶ckler J, Dikranian K, Tenkova TI, Stefovska V, Turski L, Olney JW. (1999) Blockade of NMDA receptors and apoptotic neurodegeneration in the developing brain. Science 283: 70-74. ")
										.<Reference> makeItLive());
				link_effecttoeffect16
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect16,
										dataSource,
										"Kokaia Z, Nawa H, Uchino H, Elmer E, Kokaia M, Carnahan J, Smith ML, Siesjo BK & Lindvall O. (1996) Regional brain-derived neurotrophic factor mRNA and protein levels following transient forebrain ischemia in the rat. Brain Res Mol Brain Res. 38: 139-144. ")
										.<Reference> makeItLive());
				link_effecttoeffect16
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect16,
										dataSource,
										"Kroemer G, Galluzzi L, Vandenabeele P, Abrams J, Alnemri ES, Baehrecke EH, Blagosklonny MV, El-Deiry WS., Golstein P, Green DR, Hengartner M, Knight RA, Kumar S, Lipton SA, Malorni W, NuÃ±ez G, Peter ME, Tschopp J, Yuan J, Piacentini M, Zhivotovsky B, Melino G. Nomenclature Committee on Cell Death (2009). Classification of cell death: recommendations of the Nomenclature Committee on Cell Death 2009. Cell Death Differ. 16: 3-11. ")
										.<Reference> makeItLive());
				link_effecttoeffect16
						.getReferenceIDs()
						.add(
								new Reference(link_effecttoeffect16, dataSource,
										"Kubo T, Nonomura T, Enokido Y, Hatanaka H. (1995) Brain-derived neurotrophic factor (BDNF) can prevent apoptosis of rat cerebellar granule neurons in culture. Brain Res Dev Brain Res. 85: 249-258. ")
										.<Reference> makeItLive());
				link_effecttoeffect16.getReferenceIDs().add(
						new Reference(link_effecttoeffect16, dataSource, "Lee R, Kermani P, Teng KK, Hempstead BL. (2001) Regulation of cell survival by secreted proneurotrophins. Science 294: 1945-1948. ")
								.<Reference> makeItLive());
				link_effecttoeffect16
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect16,
										dataSource,
										"Liu J, Han D, Li Y, Zheng L, Gu C, Piao Z, Au WW, Xu X, Huo X. (2010) Lead affects apoptosis and related gene XIAP and Smac expression in the hippocampus of developing rats. Neurochem Res. 35: 473-479. ")
										.<Reference> makeItLive());
				link_effecttoeffect16.getReferenceIDs().add(
						new Reference(link_effecttoeffect16, dataSource, "Miller FD, Kaplan DR. (2001) Neurotrophin signalling pathways regulating neuronal apoptosis. Cell Mol Life Sci. 58: 1045-1053. ")
								.<Reference> makeItLive());
				link_effecttoeffect16
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect16,
										dataSource,
										"Murray PS, Holmes PV. (2011) An Overview of Brain-Derived Neurotrophic Factor and Implications for Excitotoxic Vulnerability in the Hippocampus nternational. J Pept. Volume 2011 (2011), Article ID 654085, 12 pages. ")
										.<Reference> makeItLive());
				link_effecttoeffect16
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect16,
										dataSource,
										"Neal AP, Stansfield KH, Worley PF, Thompson RE, Guilarte TR. (2010) Lead exposure during synaptogenesis alters vesicular proteins and impairs vesicular release: Potential role of NMDA receptor-dependent BDNF signaling. Toxicol Sci. 116: 249-263. ")
										.<Reference> makeItLive());
				link_effecttoeffect16
						.getReferenceIDs()
						.add(
								new Reference(link_effecttoeffect16, dataSource,
										"Niu Y, Zhang R, Cheng Y, Sun X, Tian J. (2002) Effect of lead acetate on the apoptosis and the expression of bcl-2 and bax genes in rat brain cells. Zhonghua Yu Fang Yi Xue Za Zhi. 36: 30-33. ")
										.<Reference> makeItLive());
				link_effecttoeffect16.getReferenceIDs().add(
						new Reference(link_effecttoeffect16, dataSource,
								"Oberto A, Marks N, Evans HL, Guidotti A. (1996) Lead (Pb + 2) promotes apoptosis in newborn rat cerebellar neurons: pathological implications. J Pharmacol Exp Ther. 279: 435-442. ")
								.<Reference> makeItLive());
				link_effecttoeffect16
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect16,
										dataSource,
										"Reinprecht K, Hutter-Paier B, Crailsheim K, Windisch M. (1998) Influence of BDNF and FCS on viability and programmed cell death (PCD) of developing cortical chicken neurons in vitro. J Neural Transm Suppl. 53: 373-384. ")
										.<Reference> makeItLive());
				link_effecttoeffect16
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect16,
										dataSource,
										"Schwartz PM, Borghesani PR, Levy RL, Pomeroy SL, Segal RA. (1997) Abnormal cerebellar development and foliation in BDNF(-/-) mice reveals a role for neurotrophins in CNS patterning. Neuron 19: 269-281. ")
										.<Reference> makeItLive());
				link_effecttoeffect16.getReferenceIDs().add(
						new Reference(link_effecttoeffect16, dataSource,
								"Sharifi AM, Baniasadi S, Jorjani M, Rahimi F, Bakhshayesh M. (2002) Investigation of acute lead poisoning on apoptosis in rat hippocampus in vivo. Neurosci Lett. 329: 45-48. ")
								.<Reference> makeItLive());
				link_effecttoeffect16
						.getReferenceIDs()
						.add(
								new Reference(link_effecttoeffect16, dataSource,
										"Sharifi AM, Mousavi SH. (2008) Studying the effects of lead on DNA fragmentation and proapoptotic bax and antiapoptotic bcl-2 protein expression in PC12 cells. Toxicol. Mech. Methods 18: 75-79. ")
										.<Reference> makeItLive());
				link_effecttoeffect16
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect16,
										dataSource,
										"Stansfield KH, Pilsner JR, Lu Q, Wright RO, Guilarte TR. (2012) Dysregulation of BDNF-TrkB signaling in developing hippocampal neurons by Pb(2+): implications for an environmental basis of neurodevelopmental disorders. Toxicol Sci. 127: 277-295. ")
										.<Reference> makeItLive());
				link_effecttoeffect16
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect16,
										dataSource,
										"West AE, Chen WG, Dalva MB, Dolmetsch RE, Kornhauser JM, Shaywitz AJ, Takasu MA, Tao X, Greenberg ME. (2001) Calcium regulation of neuronal gene expression. Proc Natl Acad Sci U S A. 98: 11024-11031. ")
										.<Reference> makeItLive());
				link_effecttoeffect16.getReferenceIDs()
						.add(
								new Reference(link_effecttoeffect16, dataSource,
										"Xu J, Ji LD, Xu LH. (2006) Lead-induced apoptosis in PC 12 cells: involvement of p53, Bcl-2 family and caspase-3. Toxicol Lett. 166: 160-167. ").<Reference> makeItLive());
				link_effecttoeffect16
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect16,
										dataSource,
										"Yoon WJ, Won SJ, Ryu BR, Gwag BJ. (2003). Blockade of ionotropic glutamate receptors produces neuronal apoptosis through the Bax- cytochrome C-caspase pathway: the causative role of Ca2+deficiency. J Neurochem. 85: 525-533. ")
										.<Reference> makeItLive());
				link_effecttoeffect16
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect16,
										dataSource,
										"Zhu B, Pennack JA, McQuilton P, Forero MG, Mizuguchi K, Sutcliffe B, Gu CJ, Fenton JC, Hidalgo A. (2008) Drosophila neurotrophins reveal a common mechanism for nervous system formation. PLoS Biol. 18;6(11):e284. ")
										.<Reference> makeItLive());
				
				link_effecttoeffect17 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect10, effect_downstreameffect14);
				link_effecttoeffect17.setLinkType(LinkType.UNKNOWN);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect17_weigth0 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect17, dataSource, Link_EffectToEffect.class, 1.0);
				link_effecttoeffect17
						.getDescriptionIDs()
						.set(
								new DescriptionSection_Structured(
										link_effecttoeffect17,
										dataSource,
										"(Key) Event Relationships Weight of Evidences",
										"How Does This Key Event Relationship Work\n\nThe dendritically synthesized BDNF when secreted activates tyrosine kinase B (TrkB) receptors that induce the synthesis of a number of proteins involved in the development of proper dendritic spine morphology. \n\nâ€¢ Biological Plausibility: \n\nAfter activation of tyrosine kinase B (TrkB) receptors by BDNF proteins such as Arc, Homer2, LIMK1 (Kang and Schuman, 1996, Schratt et al., 2004 and Yin et al., 2002) that are known to promote actin polymerization and consequently enlargement of spine heads (Sala et al., 2001) are released. Recently, it has been shown that BDNF promotes dendritic spine formation by interacting with Wnt signaling. Indeed, Wnt signaling inhibition in cultured cortical neurons caused disruption in dendritic spine development, reduction in dendritic arbor size and complexity and blockage of BDNF-induced dendritic spine formation and maturation (Hiester et al., 2013). \n\nIn addition, it has been shown that the inhibition of BDNF synthesis reduces the size of spine heads and impairs LTP (An et al., 2008; Waterhouse and Xu, 2009). BDNF has been characterized as a critical factor in promoting dendritic morphogenesis in various types of neurons (reviewed in Jan and Jan, 2010; Park and Poo, 2013). \n\nBDNF that is synthesised in dendrites is known to regulate the morphology of spines (Tyler and Pozzo-Miller, 2003; An et al., 2008). For example, spines in the absence of spontaneous electrical activity are significantly smaller than normal (Harvey et al., 2008). On the other hand, simultaneous electrical activity and glutamate release increase the size of the spine head, which has been shown to be dependent on BDNF (Tanaka et al., 2008). \n\nMice harboring the Val66Met mutation of Bdnf gene show dendritic arborization defects in the hippocampus. Interestingly, human subjects with the Val66Met SNP demonstrate similar anatomical features (reviewed in Cohen and Greenberg, 2008). \n\nMore targeted studies have shown that, within the physiological range of expression, dendritic spine density is tightly regulated by BDNF in the dentate gyrus but not in CA1 pyramidal cells (Alexis and Stranahan, 2011). \n\nâ€¢ Empirical Support for Linkage:\n\nExposure of rat hippocampal neurons in culture to BDNF causes increase in cypin mRNA and protein levels, which is a known guanine deaminase that activates dendritic arborisation. This increase of cypin induced by BDNF appears after 72 h but not at earlier time points (Kwon et al., 2011), meaning that BDNF has to act first in order to stimulate dendritic arbor formation. \n\nPb2+: The first hint for involvement of Pb2+ in dendritic morphology was described by Alfano and Petit. 1982. They have demonstrated reduction in the length of dendritic processes and the number of dendritic branches in hippocampal dentate granule cells after developmental Pb2+ exposure of Long-Evans hooded rat pups (Alfano and Petit, 1982). More recently, it has been shown that the chronic exposure of rats to environmentally relevant levels (Pb2+ blood levels 25.8 Â± 1.28 Î¼g/dL) during early life alters cell morphology in the dentate gyrus as immature granule cells immunolabeled with doublecortin display aberrant dendritic morphology (Verina et al., 2007). \n\nExposure of rats to Pb2+ that initiated at embryonic phase and terminated at PND 21 have revealed that at PND 14 (Pb2+ concentration in the hippocampus 0.249Â±0.06 Âµg/g) and PND 21 (Pb2+ concentration in the hippocampus 0.471Â±0.11 Âµg/g) the number of dendritic spine on hippocampal CA1 area decreases by 32.83% and 24.11%, respectively (Hu et al., 2014). The length-density of the doublecortin-positive apical dendrites in the outer portion of the dentate gyrus molecular layer has been found significantly decreased up to 36% in chronically exposed rats to environmentally relevant levels of Pb2+ (Pb2+ blood levels 25.8 Â± 1.28 Î¼g/dL) (Verina et al., 2007). In another in vivo study, lower blood levels of Pb2+ (10 Â± 1.28 Î¼g/dL) in similar age of rats has led to significant decrease of BDNF concentration (pg/mg protein) that is 39% in forebrain cortex and 29% in hippocampus (Baranowska-Bosiacka et al., 2013). \n\nIn cultured rat hippocampal neurons, low levels of Pb2+ (0.1 and 1 ÂµM) cause reduction of dendritic spine density in a dose-dependent manner (Hu et al., 2014). In a similar in vitro model, exposure to 1 Î¼M Pb2+ for 5 days during the period of synaptogenesis (DIV7â€“DIV12), significantly reduces proBDNF protein and extracellular levels of mBDNF (Neal et al., 2010). When mouse embryonic stem cells are differentiated into neurons, exposure to lead (II) acetate causes reduction in the percentage of microtubule-associated protein 2 (MAP-2)-positive cells and in the mRNA levels of MAP-2 in a dose-dependent manner (Baek et al., 2011). Similar effects were found in dissociated cells derived from neuro-spheres generated from neural stem cells (NSCs) originating from E15 rat cortex (CX), striatum (ST) or ventral mesencephalon (VM) exposed for 7 days to lead acetate (Huang and Schneider, 2004). More specifically, lead exposure (0.1â€“10 Î¼M) decreases MAP-2-positive cells of ST and VM-derived NSCs, whereas there is no effect in CX-derived NSCs. VM-derived NSCs have the greatest sensitivity to the inhibitory effects of lead exposure causing 25% decrease in MAP-2-positive cells at 0.1 Î¼M and almost 50% at 10 Î¼M (Huang and Schneider, 2004). \n\nâ€¢ Uncertainties or Inconsistencies:\n\nVarious molecular mechanisms have been identified as regulators of dendritic arborisation patterns and dendtitic spine formation (Jan and Jan, 2010). More specific, transcription factors, growth factors, receptor-ligand interactions, various signalling pathways, local translational machinery, cytoskeletal elements, Golgi outposts and endosomes have been identified as contributors to the organization of dendrites of individual neurons and the contribution of these dendrites in the neuronal circuitry (Jan and Jan, 2010). This study suggests that more parameters rather than only BDNF may be involved in dendritic arbor and spine formation during development. ",
										link_effecttoeffect17_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect17
						.getReferenceIDs()
						.add(
								new Reference(link_effecttoeffect17, dataSource,
										" Alexis M, Stranahan AM. (2011) Physiological variability in brain-derived neurotrophic factor expression predicts dendritic spine density in the mouse dentate gyrus. Neurosci Lett. 495: 60-62. ")
										.<Reference> makeItLive());
				link_effecttoeffect17.getReferenceIDs().add(
						new Reference(link_effecttoeffect17, dataSource,
								"Alfano DP, Petit TL. (1982) Neonatal lead exposure alters the dendritic development of hippocampal dentate granule cells. Exp Neurol. 75: 275-288. ").<Reference> makeItLive());
				link_effecttoeffect17
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect17,
										dataSource,
										"An JJ, Gharami K, Liao GY, Woo NH, Lau AG, Vanevski F, Torre ER, Jones KR, Feng Y, Lu B, Xu B. (2008) Distinct role of long 3' UTR BDNF mRNA in spine morphology and synaptic plasticity in hippocampal neurons. Cell 134: 175-187. ")
										.<Reference> makeItLive());
				link_effecttoeffect17
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect17,
										dataSource,
										"Baek DH, Park SH, Park JH, Choi Y, Park KD, Kang JW, Choi KS, Kim HS. (2011) Embryotoxicity of lead (II) acetate and aroclor 1254 using a new end point of the embryonic stem cell test. Int J Toxicol. 30: 498-509. ")
										.<Reference> makeItLive());
				link_effecttoeffect17
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect17,
										dataSource,
										"Baranowska-Bosiacka I, StruÅ¼yÅ„ska L, Gutowska I, MachaliÅ„ska A, Kolasa A, KÅ‚os P, Czapski GA, Kurzawski M, Prokopowicz A, Marchlewicz M, Safranow K, MachaliÅ„ski B, Wiszniewska B, Chlubek D. (2013) Perinatal exposure to lead induces morphological, ultrastructural and molecular alterations in the hippocampus. Toxicology 303: 187-200. ")
										.<Reference> makeItLive());
				link_effecttoeffect17.getReferenceIDs().add(
						new Reference(link_effecttoeffect17, dataSource,
								"Cohen S, Greenberg ME. (2008) Communication between the synapse and the nucleus in neuronal development, plasticity and disease. Annu Rev Cell Dev Biol. 24: 183-209. ")
								.<Reference> makeItLive());
				link_effecttoeffect17.getReferenceIDs().add(
						new Reference(link_effecttoeffect17, dataSource,
								"Harvey CD, Yasuda R, Zhong H, Svoboda K. (2008) The spread of Ras activity triggered by activation of a single dendritic spine. Science. 321: 136-140. ").<Reference> makeItLive());
				link_effecttoeffect17.getReferenceIDs().add(
						new Reference(link_effecttoeffect17, dataSource,
								"Hiester BG, Galati DF, Salinas PC, Jones KR. (2013) Neurotrophin and Wnt signaling cooperatively regulate dendritic spine formation. Mol Cell Neurosci. 56: 115-127. ")
								.<Reference> makeItLive());
				link_effecttoeffect17
						.getReferenceIDs()
						.add(
								new Reference(link_effecttoeffect17, dataSource,
										"Hu F, Xu L, Liu Z-H, Ge M-M, Ruan D-Y, et al. (2014) Developmental Lead Exposure Alters Synaptogenesis through Inhibiting Canonical Wnt Pathway In Vivo and In Vitro. PLoS ONE 9(7): e101894. ")
										.<Reference> makeItLive());
				link_effecttoeffect17
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect17,
										dataSource,
										"Huang F, Schneider JS. (2004) Effects of lead exposure on proliferation and differentiation of neural stem cells derived from different regions of embryonic rat brain. Neurotoxicology 25: 1001â€“1012. ")
										.<Reference> makeItLive());
				link_effecttoeffect17.getReferenceIDs().add(
						new Reference(link_effecttoeffect17, dataSource, "Jan YN, Jan LY (2010). Branching out: mechanisms of dendritic arborization. Nat Rev Neurosci. 11: 316-328. ").<Reference> makeItLive());
				link_effecttoeffect17.getReferenceIDs().add(
						new Reference(link_effecttoeffect17, dataSource,
								"Kang H, Schuman EM. (1996) A requirement for local protein synthesis in neurotrophin-induced hippocampal synaptic plasticity. Science 273: 1402-1406. ").<Reference> makeItLive());
				link_effecttoeffect17
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect17,
										dataSource,
										"Kwon M, FernÃ¡ndez JR, Zegarek GF, Lo SB, Firestein BL. (2011) BDNF-promoted increases in proximal dendrites occur via CREB-dependent transcriptional regulation of cypin. J Neurosci. 31: 9735-9745. ")
										.<Reference> makeItLive());
				link_effecttoeffect17.getReferenceIDs().add(
						new Reference(link_effecttoeffect17, dataSource, "McAllister AK, Lo DC, Katz LC. (1995) Neurotrophins regulate dendritic growth in developing visual cortex. Neuron 15: 791-803. ")
								.<Reference> makeItLive());
				link_effecttoeffect17.getReferenceIDs().add(
						new Reference(link_effecttoeffect17, dataSource, "McAllister AK, Katz LC, Lo DC. (1996) Neurotrophin regulation of cortical dendritic growth requires activity. Neuron 17: 1057-1064. ")
								.<Reference> makeItLive());
				link_effecttoeffect17
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect17,
										dataSource,
										"Neal AP, Stansfield KH, Worley PF, Thompson RE, Guilarte TR. (2010) Lead exposure during synaptogenesis alters vesicular proteins and impairs vesicular release: Potential role of NMDA receptor-dependent BDNF signaling. Toxicol Sci. 116: 249-263. ")
										.<Reference> makeItLive());
				link_effecttoeffect17.getReferenceIDs().add(
						new Reference(link_effecttoeffect17, dataSource, "Park H, Poo MM. (2013) Neurotrophin regulation of neural circuit development and function. Nat Rev Neurosci 14: 7-23. ")
								.<Reference> makeItLive());
				link_effecttoeffect17.getReferenceIDs().add(
						new Reference(link_effecttoeffect17, dataSource,
								"Sala C, Piech V, Wilson NR, Passafaro M, Liu G, Sheng M. (2001) Regulation of dendritic spine morphology and synaptic function by Shank and Homer. Neuron 31: 115-130. ")
								.<Reference> makeItLive());
				link_effecttoeffect17
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect17,
										dataSource,
										"Schratt GM, Nigh EA, Chen WG, Hu L, Greenberg ME. (2004) BDNF regulates the translation of a select group of mRNAs by a mammalian target of rapamycin-phosphatidylinositol 3-kinase-dependent pathway during neuronal development. J Neurosci. 24: 7366-7377. ")
										.<Reference> makeItLive());
				link_effecttoeffect17
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect17,
										dataSource,
										"Stansfield KH, Pilsner JR, Lu Q, Wright RO, Guilarte TR. (2012) Dysregulation of BDNF-TrkB signaling in developing hippocampal neurons by Pb(2+): implications for an environmental basis of neurodevelopmental disorders. Toxicol Sci. 127: 277-295. ")
										.<Reference> makeItLive());
				link_effecttoeffect17
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect17,
										dataSource,
										"Tanaka JI, Horiike Y, Matsuzaki M, Miyazaki T, Ellis-Davies GCR, Kasai H. (2008) Protein synthesis and neurotrophin-dependent structural plasticity of single dendritic spines Science 319: 1683-1687. ")
										.<Reference> makeItLive());
				link_effecttoeffect17.getReferenceIDs().add(
						new Reference(link_effecttoeffect17, dataSource,
								"Tyler WJ, Pozzo-Miller L. (2003) Miniature synaptic transmission and BDNF modulate dendritic spine growth and form in rat CA1 neurones. J Physiol 553: 497-509. ").<Reference> makeItLive());
				link_effecttoeffect17
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect17,
										dataSource,
										"Verina T, Rohde CA, Guilarte TR. (2007). Environmental lead exposure during early life alters granule cell neurogenesis and morphology in the hippocampus of young adult rats. Neuroscience 145: 1037-1047. ")
										.<Reference> makeItLive());
				link_effecttoeffect17.getReferenceIDs().add(
						new Reference(link_effecttoeffect17, dataSource,
								"Waterhouse EG, Xu B. (2009) New insights into the role of brain-derived neurotrophic factor in synaptic plasticity. Mol Cell Neurosci. 42: 81-89. ").<Reference> makeItLive());
				link_effecttoeffect17.getReferenceIDs().add(
						new Reference(link_effecttoeffect17, dataSource,
								"Yin Y, Edelman GM, Vanderklish PW. (2002) The brain-derived neurotrophic factor enhances synthesis of Arc in synaptoneurosomes. Proc Natl Acad Sci USA. 99: 2368-2373. ")
								.<Reference> makeItLive());
				link_effecttoeffect17.getReferenceIDs().add(
						new Reference(link_effecttoeffect17, dataSource,
								"Zagrebelsky M, Korte M. (2014) Form follows function: BDNF and its involvement in sculpting the function and structure of synapses. Neuropharmacology. 76 PtC: 628-638. ")
								.<Reference> makeItLive());
				
				link_effecttoeffect19 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect12, effect_downstreameffect18);
				link_effecttoeffect19.setLinkType(LinkType.UNKNOWN);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect19_weigth0 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect19, dataSource, Link_EffectToEffect.class, 1.0);
				link_effecttoeffect19
						.getDescriptionIDs()
						.set(
								new DescriptionSection_Structured(
										link_effecttoeffect19,
										dataSource,
										"(Key) Event Relationships Weight of Evidences",
										"How Does This Key Event Relationship Work\n\nThe presynaptic release of glutamate causes activation of NMDA receptors and initiates synaptogenesis through activation of downstream signalling pathways required for synapse formation (reviewed in Ghiani et al., 2007). Lack or reduced release of glutamate affects the transcription and translation of molecules required in synaptogenesis (reviewed in Ghiani et al., 2007). \n\nâ€¢ Biological Plausibility: \n\nThe NMDA receptor activation by glutamate during development increases calcium influx, which acts as a secondary signal. Eventually, immediate early genes (IEG) activation is triggered by transcription factors and the proteins required for synapse formation are produced (reviewed in Ghiani et al., 2007). \n\nGlutamate released from entorhinal cortex neurons has been shown to promote synaptogenesis in developing targeted hippocampal neurons (Mattson et al., 1988). Similarly, glutamate has been found to regulate synaptogenesis in the developing visual system of frogs (Cline and Constantine-Paton, 1990). \n\nThe ratio of synaptic NR2B over NR2A NMDAR subunits controls spine motility and synaptogenesis, and it has been suggested a structural role for the intracellular C terminus of NR2 in recruiting the signaling and scaffolding molecules necessary for proper synaptogenesis (Gambrill and Barria, 2011). \n\nâ€¢ Empirical Support for Linkage:\n\nThere is no direct evidence linking reduced presynaptic release of glutamate to decreased synaptogenesis as they have not been ever measured both in the same study after exposure to stressors. However, there are findings that strongly link reduced presynaptic release of glutamate to LTP. \n\nIndeed, measures of presynaptic function at glutamatergic synapses in chronically exposed animals have produced results that can be related to the effects of Pb2+ on glutamate and LTP. Focal perfusion of high K+ is used to measure glutamate release and define the Ca+2-dependent and Ca+2-independent components by inclusion or removal of Ca+2 from the perfusion fluid. Animals exposed to 0.2% Pb2+ cause decrease in K+-evoked hippocampal glutamate release, which is an important factor in the elevated threshold and diminishes magnitude of hippocampal LTP (Gilbert et al., 1996, 1999; Lasley and Gilbert, 1996). Furthermore, the same research group showed that chronic exposure to 0.2% Pb2+ diminishes only the K+-stimulated increase in total extracellular glutamate compared to that in control but not in animals under Ca+2-free conditions, suggesting that the exposure-induced decrease in total glutamate release is due to Pb2+ -related decrements in the Ca+2-dependent component. \n\nIn animals exhibiting blood Pb2+ levels of 30-40 Î¼g/100 ml, the perforant path stimulation to induce paired-pulse facilitation in dentate gyrus, which is a measure that is primarily mediated by enhanced glutamate release, is reduced (Lasley and Gilbert, 1996; Ruan et al., 1998). Microdialysis experiment in animals with the same Pb2+ values show diminished depolarization-induced hippocampal glutamate release (Lasley and Gilbert, 1996; Lasley et al., 1999). \n\nIn another study, rats continuously exposed to 0.1â€“0.5% Pb2+ in the drinking water beginning at gestational day 15-16 show decrease in total K+-stimulated hippocampal glutamate release (Lasley and Gilbert, 2002). Maximal effects have been seen in the 0.2% group (blood Pb = 40 Î¼g/100 ml). However, these effects have been less evident in the 0.5% group and are no longer present in the 1.0% Pb2+ group (Lasley and Gilbert, 2002). The same finding was found in hippocampal cultures and brain slices acutely exposed to Pb2+ (Braga et al., 1999; Xiao et al., 2006). \n\nMore recently, Pb2+ has also been shown to decrease the levels of the vesicular proteins synaptophysin and synaptobrevin and inhibit vesicular release (Neal et al., 2010). Furthermore the same group has reported that chronic in vivo exposure to Pb2+ during development results in a marked inhibition of Schaffer-collateral-CA1 synaptic transmission by inhibiting vesicular release of glutamate, an effect that is not associated with a persistent change in presynaptic calcium entry (Zhang et al., 2015). \n\nâ€¢ Uncertainties or Inconsistencies:\n\n",
										link_effecttoeffect19_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect19.getReferenceIDs().add(
						new Reference(link_effecttoeffect19, dataSource,
								"Braga MFM, Pereire EFR, Albuquerque EX. (1999) Nanomolar concentration of lead inhibit glutamatergic and GABAergic transmission in hippocampal neurons. Brain Res. 826: 22â€“34. ")
								.<Reference> makeItLive());
				link_effecttoeffect19
						.getReferenceIDs()
						.add(
								new Reference(link_effecttoeffect19, dataSource,
										"Cline HT, Constantine-Paton M. (1990) NMDA receptor agonist and antagonists alter retinal ganglion cell arbor structure in the developing frog retinotectal projection. J Neurosci. 10: 1197-1216. ")
										.<Reference> makeItLive());
				link_effecttoeffect19.getReferenceIDs().add(
						new Reference(link_effecttoeffect19, dataSource,
								"Gambrill AC, Barria A. (2011) NMDA receptor subunit composition controls synaptogenesis and synapse stabilization. Proc Natl Acad Sci U S A. 108: 5855-5860. ").<Reference> makeItLive());
				link_effecttoeffect19
						.getReferenceIDs()
						.add(
								new Reference(link_effecttoeffect19, dataSource,
										"Ghiani CA, Beltran-Parrazal L, Sforza DM, et al. (2007) Genetic program of neuronal differentiation and growth induced by specific activation of NMDA receptors. Neurochem Res. 32: 363-376. ")
										.<Reference> makeItLive());
				link_effecttoeffect19
						.getReferenceIDs()
						.add(
								new Reference(link_effecttoeffect19, dataSource,
										"Gilbert ME, Mack CM, Lasley SM. (1996) Chronic developmental lead (Pb++) exposure increases the threshold for long-term potentiation in the rat dentate gyrus in vivo. Brain Res. 736: 118â€“124. ")
										.<Reference> makeItLive());
				link_effecttoeffect19.getReferenceIDs().add(
						new Reference(link_effecttoeffect19, dataSource,
								"Gilbert ME, Mack CM, Lasley SM. (1999a) The influence of developmental period of lead exposure on long-term potentiation in the rat dentate gyrus in vivo. Neurotoxicology 20: 57â€“69. ")
								.<Reference> makeItLive());
				link_effecttoeffect19.getReferenceIDs().add(
						new Reference(link_effecttoeffect19, dataSource,
								"Lasley SM, Gilbert ME. (1996) Presynaptic glutamatergic function in dentate gyrus in vivo is diminished by chronic exposure to inorganic lead. Brain Res. 736: 125â€“134. ")
								.<Reference> makeItLive());
				link_effecttoeffect19.getReferenceIDs().add(
						new Reference(link_effecttoeffect19, dataSource,
								"Lasley SM, Gilbert ME. (2002) Rat hippocampal glutamate and GABA release exhibit biphasic effects as a function of chronic lead exposure level. Toxicol Sci. 66: 139-147. ")
								.<Reference> makeItLive());
				link_effecttoeffect19.getReferenceIDs().add(
						new Reference(link_effecttoeffect19, dataSource,
								"Lasley SM, Green MC, Gilbert ME (1999). Influence of exposure period on in vivo hippocampal glutamate and GABA release in rats chronically exposed to lead. Neurotoxicology 20: 619â€“629. ")
								.<Reference> makeItLive());
				link_effecttoeffect19
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect19,
										dataSource,
										"Mattson MP, Lee RE, Adams ME, Guthrie PB, Kater SB. (1988) Interactions between entorhinal axons and target hippocampal neurons: a role for glutamate in the development of hippocampal circuitry. Neuron 1: 865-876. ")
										.<Reference> makeItLive());
				link_effecttoeffect19
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect19,
										dataSource,
										"Neal AP, Stansfield KH, Worley PF, Thompson RE, Guilarte TR. (2010) Lead exposure during synaptogenesis alters vesicular proteins and impairs vesicular release: Potential role of NMDA receptor-dependent BDNF signaling. Toxicol Sci. 116: 249-263. ")
										.<Reference> makeItLive());
				link_effecttoeffect19
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect19,
										dataSource,
										"Ruan DY, Chen JT, Zhao C, Xu YZ, Wang M, Zhao WF. (1998) Impairment of long-term potentiation and paired-pulse facilitation in rat hippocampal dentate gyrus following developmental lead exposure in vivo. Brain Res. 806, 196â€“201. ")
										.<Reference> makeItLive());
				link_effecttoeffect19
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect19,
										dataSource,
										"Xiao C, Gu Y, Zhou CY, Wang L, Zhang MM, Ruan DY, et al. Lead impairs GABAergic synaptic transmission in rat hippocampal slices: a possible involvement of presynaptic calcium channels. Brain Res. 2006; 1088: 93â€“100. ")
										.<Reference> makeItLive());
				link_effecttoeffect19
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect19,
										dataSource,
										"Zhang XL, Guariglia SR, McGlothan JL, Stansfield KH, Stanton PK, Guilarte TR. (2015) Presynaptic mechanisms of lead neurotoxicity: effects on vesicular release, vesicle clustering and mitochondria number. PLoS One. 10(5):e0127461. ")
										.<Reference> makeItLive());
				
				link_effecttoeffect20 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect13, effect_downstreameffect18);
				link_effecttoeffect20.setLinkType(LinkType.UNKNOWN);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect20_weigth0 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect20, dataSource, Link_EffectToEffect.class, 1.0);
				link_effecttoeffect20
						.getDescriptionIDs()
						.set(
								new DescriptionSection_Structured(
										link_effecttoeffect20,
										dataSource,
										"(Key) Event Relationships Weight of Evidences",
										"How Does This Key Event Relationship Work\n\nUnder physiological conditions, in the developing nervous system, apoptosis occurs during the process of synaptogenesis, where competition leads to the loss of excess neurons and to the connection of the appropriate neurons (Buss et al., 2006; Mennerick and Zorumski, 2000; Oppenheim, 1991). However, when a stressor increases the number of apoptotic cells this KE has a negative effect on synaptogenesis as the reduced number of neurons (besides the ones that have been already eliminated through the physiological process of apoptosis) provides limited dendritic fields for receiving synaptic inputs from incoming axons. At the same time the loss of neurons also means that there are less axons to establish synaptic contacts (Olney, 2014), leading to reduced synaptogenesis and neuronal networking. \n\nâ€¢ Biological Plausibility:\n\n Recently, Dekkers et al. 2013 have reviewed how under physiological conditions components of the apoptotic machinery in developing brain regulate synapse formation and neuronal connectivity. For example, caspase activation is known to be required for axon pruning during development to generate neuronal network (reviewed in Dekkers et al., 2013). Experimental work carried out in Drosophila melanogaster and in mammalian neurons shows that components of apoptotic machinery are involved in axonal degeneration that can consequently interfere with synapse formation (reviewed in Dekkers et al., 2013). Furthermore, Bax mutant mice studies indicate that the lack of this pro-apoptotic protein BAX leads to disruption of intrinsically photosensitive retinal ganglion cells spacing and dendritic stratification that affects synapse localization and function (Chen et al., 2013). \n\nâ€¢ Empirical Support for Linkage:\n\nSynaptogenesis and refinement of the cortical network precedes the programmed cells death of neurons during development (Innocenti and Price, 2005). \n\nPb2+: Elevated blood Pb2+ concentrations that have been evident in new-born rats prenatally exposed to 30 or 200 mg/l Pb2+ caused postnatally delay in synaptogenesis (McCauley et al., 1982). In this study, Pb2+ treatment depresses synaptic counts in pups of PND 11 to 15 but not in older pups (McCauley et al., 1982). In rat hippocampal primary cultures, Pb2+ treatment has no effect on PSD95 puncta density nor has any effect on Synapsin Ia/b total gray value, puncta density, and integrated intensity but only reduces the phosphorylation of Synapsin Ia/b (Stansfield et al., 2012). Pb2+ exposure also represses the expression of presynaptic vesicular proteins implicated in neurotransmitter release, such as synaptobrevin (VAMP1) and synaptophysin (SYN) (Neal et al., 2010). In mouse ESCs cultured in 3D aggregates, the treatment with 0.1 ÂµM Pb2+ causes around 25% of cell loss that is not attributed to apoptosis as no change in caspase 3 levels has been detected (SÃ¡nchez-MartÃ­n et al., 2013). In the same study but in an in vivo model, Pb2+ causes downregulation of Syn1 gene expression in the hippocampus of male offspring (PND 60) derived from female mice exposed to 0 or 3 ppm of lead acetate in drinking water from 8 weeks prior to mating, through gestation and until PND 10 (SÃ¡nchez-MartÃ­n et al., 2013). \n\nâ€¢ Uncertainties or Inconsistencies:\n\nIn adult nervous system, the role of apoptotic machinery in axon pruning and synapse elimination, which are necessary to refine mature neuronal network has been extensively studied (reviewed in Hyman and Yuan, 2012), whereas in developing nervous system the regulatory importance of apoptotic machinery in synapse formation and function is less clear (reviewed in Dekkers et al., 2013). ",
										link_effecttoeffect20_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect20.getReferenceIDs().add(
						new Reference(link_effecttoeffect20, dataSource, "Buss RR, Sun W, Oppenheim RW. (2006) Adaptive roles of programmed cell death during nervous system development. Annu Rev Neurosci. 29: 1-35. ")
								.<Reference> makeItLive());
				link_effecttoeffect20
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect20,
										dataSource,
										"Chen SK, Chew KS, McNeill DS, Keeley PW, Ecker JL, Mao BQ, Pahlberg J, Kim B, Lee SC, Fox MA, Guido W, Wong KY, Sampath AP, Reese BE, Kuruvilla R, Hattar S. (2013) Apoptosis regulates ipRGC spacing necessary for rods and cones to drive circadian photoentrainment. Neuron 77: 503-515. ")
										.<Reference> makeItLive());
				link_effecttoeffect20.getReferenceIDs().add(
						new Reference(link_effecttoeffect20, dataSource,
								"Dekkers MPJ, Nikoletopoulou V, Barde Y-A. (2013) Death of developing neurons: New insights and implications for connectivity. J Cell Biol. 203: 385-393. ").<Reference> makeItLive());
				link_effecttoeffect20.getReferenceIDs().add(
						new Reference(link_effecttoeffect20, dataSource,
								"Hyman BT, Yuan J. (2012) Apoptotic and non-apoptotic roles of caspases in neuronal physiology and pathophysiology. Nat Rev Neurosci 13: 395-406. ").<Reference> makeItLive());
				link_effecttoeffect20.getReferenceIDs().add(
						new Reference(link_effecttoeffect20, dataSource, "Innocenti, GM, Price DJ. (2005) Exuberance in the development of cortical networks. Nat Rev Neurosci. 6: 955-965. ").<Reference> makeItLive());
				link_effecttoeffect20
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect20,
										dataSource,
										"McCauley PT, Bull RJ, Tonti AP, Lukenhoff SD, Meister MV, Doerger JU, Stober JA. (1982) The effect of prenatal and postnatal lead exposure on neonatal synaptogenesis in rat cerebral cortex. J Toxicol Environ Health 10: 639-651. ")
										.<Reference> makeItLive());
				link_effecttoeffect20.getReferenceIDs().add(
						new Reference(link_effecttoeffect20, dataSource, "Mennerick S, Zorumski CF. (2000) Neural activity and survival in the developing nervous system. Mol Neurobiol. 22: 41-54. ")
								.<Reference> makeItLive());
				link_effecttoeffect20
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect20,
										dataSource,
										"Neal AP, Stansfield KH, Worley PF, Thompson RE, Guilarte TR. (2010) Lead exposure during synaptogenesis alters vesicular proteins and impairs vesicular release: Potential role of NMDA receptor-dependent BDNF signaling. Toxicol Sci. 116: 249-263. ")
										.<Reference> makeItLive());
				link_effecttoeffect20.getReferenceIDs().add(
						new Reference(link_effecttoeffect20, dataSource, "Olney JW. (2014) Focus on apoptosis to decipher how alcohol and many other drugs disrupt brain development front. Pediatr. 2: 81. ")
								.<Reference> makeItLive());
				link_effecttoeffect20.getReferenceIDs().add(
						new Reference(link_effecttoeffect20, dataSource, "Oppenheim RW. (1991). Cell death during development of the nervous system. Annu Rev Neurosci. 14: 453-501. ").<Reference> makeItLive());
				link_effecttoeffect20
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect20,
										dataSource,
										"SÃ¡nchez-MartÃ­n FJ, Fan Y, Lindquist DM, Xia Y, Puga A. (2013) Lead Induces Similar Gene Expression Changes in Brains of Gestationally Exposed Adult Mice and in Neurons Differentiated from Mouse Embryonic Stem Cells. PLoS One 8: e80558. ")
										.<Reference> makeItLive());
				link_effecttoeffect20
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect20,
										dataSource,
										"Stansfield KH, Pilsner JR, Lu Q, Wright RO, Guilarte TR. (2012) Dysregulation of BDNF-TrkB signaling in developing hippocampal neurons by Pb(2+): implications for an environmental basis of neurodevelopmental disorders. Toxicol Sci. 127: 277-295. ")
										.<Reference> makeItLive());
				
				link_effecttoeffect21 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect14, effect_downstreameffect18);
				link_effecttoeffect21.setLinkType(LinkType.UNKNOWN);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect21_weigth0 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect21, dataSource, Link_EffectToEffect.class, 1.0);
				link_effecttoeffect21
						.getDescriptionIDs()
						.set(
								new DescriptionSection_Structured(
										link_effecttoeffect21,
										dataSource,
										"(Key) Event Relationships Weight of Evidences",
										"How Does This Key Event Relationship Work\n\nIt is well-established that loss of dendritic spine density and dendrite branch complexity leads to loss of synapse formation. Indeed, huge amount of research has been performed on dendrite arbour, dendritic spines and the molecular components of these structures that led to the elucidation of their role in higher order brain functions, including learning and memory (reviewed in SjÃ¶strÃ¶m et al., 2008). \n\nâ€¢ Biological Plausibility: \n\nIt has been proved that the appearance of extensive dendritic arbor and new spines coincides with synapse formation (Zito et al., 2004). Zhang and Benson (2001) have investigated the role of actin (the main component of dendritic spines) during the early stages of neuronal development by introducing an actin depolymerization protein named latrunculin A and conducting fluorescent imaging of synapse formation. At the early stages of neuronal development, it has been reported that the depolymerisation of filamentous actin (F-actin) significantly reduces the number of stable synapses and the presence of postsynaptic proteins (PSD-95, neuroligins, and Bassoon). Most importantly, pre- and postsynaptic vesicles needed for synaptogenesis have not been found at contact sites as a result of depolymerisation of F-actin (Zhang and Benson, 2001). Furthermore, synapsin I-deficient neurons have been shown to be unable to form synapses during the first week in culture even after establishing axon-dendritic contacts (Ferreira et al., 1996). \n\nâ€¢ Empirical Support for Linkage:\n\nMany studies have indicated that synaptogenesis and spine formation happen in any order, meaning that not always synaptogenesis follows the spine formation but it can also happen the other way around (Bhatt et al., 2009; McAllister, 2007; Okabe et al., 2001). \n\nPb2+: Newborn rats exposed to 10 mg/ml of lead acetate from PND 2 up to PND 20 and 56 demonstrate significant decrease in the spine density as shown in Golgi staining of hippocampal pyramidal neurons of the CA1 region (Kiraly and Jones, 1982). Rat pups from parents exposed to 2 mM PbCl2 3 weeks before mating until their weaning (pre-weaning Pb2+) and weaned pups exposed to 2 mM PbCl2 for 9 weeks (post-weaning Pb2+) were assessed for the number of synapses after Morris water maze (MWM) on PND 91 (Xiao et al., 2014). The number of synapses in pre-weaning Pb2+ group increased significantly, but it was less compared to control group (p<0.05). Similarly, the number of synapses in post-weaning Pb2+ group was less than that of control group, although before MWM the number of synapses was almost the same between post-weaning Pb2+ and control groups. In both pre-weaning Pb2+ and post-weaning Pb2+ groups, synaptic structural parameters such as thickness of postsynaptic density, length of synaptic active zone and synaptic curvature increased whereas width of synaptic cleft decreased compared to controls, suggesting disturbance of synaptic structural plasticity (Xiao et al., 2014). \n\nPb2+ has been shown to decrease the levels of the vesicular proteins synaptophysin and synaptobrevin in vitro (Neal et al., 2010). \n\nâ€¢ Uncertainties or Inconsistencies:\n\n",
										link_effecttoeffect21_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect21.getReferenceIDs().add(
						new Reference(link_effecttoeffect21, dataSource, "Bhatt DH, Zhang S, Gan WB. (2009). Dendritic Spine Dynamics. Ann Rev Physiol. 71: 261-282. ").<Reference> makeItLive());
				link_effecttoeffect21.getReferenceIDs().add(
						new Reference(link_effecttoeffect21, dataSource,
								"Ferreira A, Li L, Chin LS, Greengard P, Kosik KS. (1996) Postsynaptic element contributes to the delay in synaptogenesis in synapsin I-deficient neurons. Mol Cell Neurosci. 8: 286-299. ")
								.<Reference> makeItLive());
				link_effecttoeffect21.getReferenceIDs().add(
						new Reference(link_effecttoeffect21, dataSource,
								"Kiraly E, Jones DG. (1982) Dendritic spine changes in rat hippocampal pyramidal cells after postnatal lead treatment: A Golgi study. Exp Neurol. 77: 236-239. ").<Reference> makeItLive());
				link_effecttoeffect21.getReferenceIDs().add(
						new Reference(link_effecttoeffect21, dataSource, "McAllister AK. (2007) Dynamic aspects of CNS synapse formation. Ann Rev of Neurosc. 30: 425-450. ").<Reference> makeItLive());
				link_effecttoeffect21
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect21,
										dataSource,
										"Neal AP, Stansfield KH, Worley PF, Thompson RE, Guilarte TR. (2010) Lead exposure during synaptogenesis alters vesicular proteins and impairs vesicular release: Potential role of NMDA receptor-dependent BDNF signaling. Toxicol Sci. 116: 249-263. ")
										.<Reference> makeItLive());
				link_effecttoeffect21.getReferenceIDs().add(
						new Reference(link_effecttoeffect21, dataSource,
								"Okabe S, Miwa A, Okado H. (2001) Spine formation and correlated assembly of presynaptic and postsynaptic molecules. J Neurosci. 21: 6105-6114. ").<Reference> makeItLive());
				link_effecttoeffect21.getReferenceIDs().add(
						new Reference(link_effecttoeffect21, dataSource, "SjÃ¶strÃ¶m PJ, Rancz EA, Roth A, HÃ¤usser M. (2008) Dendritic excitability and synaptic plasticity. Physiol Rev. 88: 769-840. ")
								.<Reference> makeItLive());
				link_effecttoeffect21
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect21,
										dataSource,
										"Xiao Y, Fu H, Han X, Hu X, Gu H, Chen Y, Wei Q, Hu Q. (2014) Role of synaptic structural plasticity in impairments of spatial learning and memory induced by developmental lead exposure in Wistar rats. PLoS One. 23;9(12):e115556. ")
										.<Reference> makeItLive());
				link_effecttoeffect21.getReferenceIDs().add(
						new Reference(link_effecttoeffect21, dataSource, "Zhang W, Benson DL. (2001) Stages of synapse development defined by dependence on F-actin. J Neurosci. 21: 5169-5181. ")
								.<Reference> makeItLive());
				link_effecttoeffect21.getReferenceIDs().add(
						new Reference(link_effecttoeffect21, dataSource,
								"Zito K, Knott G, Shepherd GM, Shenolikar S, Svoboda K. (2004) Induction of spine growth and synapse formation by regulation of the spine actin cytoskeleton. Neuron 44: 321-334. ")
								.<Reference> makeItLive());
				
				link_effecttoeffect23 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect18, effect_downstreameffect22);
				link_effecttoeffect23.setLinkType(LinkType.UNKNOWN);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect23_weigth0 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect23, dataSource, Link_EffectToEffect.class, 1.0);
				link_effecttoeffect23
						.getDescriptionIDs()
						.set(
								new DescriptionSection_Structured(
										link_effecttoeffect23,
										dataSource,
										"(Key) Event Relationships Weight of Evidences",
										"How Does This Key Event Relationship Work\n\nThe ability of a neuron to communicate is based on neural network formation that relies on functional synapse establishment (ColÃ³n-Ramos, 2009). The main roles of synapses are the regulation of intercellular communication in the nervous system, and the information flow within neural networks. The connectivity and functionality of neural networks depends on where and when synapses are formed. Therefore, the decreased synapse formation during the process of synaptogenesis is critical and leads to decrease of neural network formation and function in the adult brain. \n\nâ€¢ Biological Plausibility: \n\nNeuronal connections are established via the process of synaptogenesis. The developmental period of synaptogenesis is critical for the formation of the basic circuitry of the nervous system, although neurons are able to form new synapses throughout life (Rodier, 1995). The brain electrical activity dependence on synapse formation is critical for proper neuronal communication. Alterations in synaptic connectivity lead to refinement of neuronal networks during development (Cline and Haas, 2008). Indeed, knockdown of PSD-95 arrests the functional and morphological development of glutamatergic synapses (Ehrlich et al., 2007). \n\nâ€¢ Empirical Support for Linkage:\n\nPb2+: At low Pb2+ levels (less than 30 micrograms/dl), slow cortical potentials have been observed to be positive in children under five years old but negative in children over five years. However, age-related polarity reversal has been observed in children with higher Pb2+ levels (Otto and Reiter, 1984). \n\nIn experiments carried out in Wistar rats that have been fed with lead acetate (400 micrograms lead/g body weight/day) from PND 2 until PND 60, EEG findings show statistically significant reduction in the delta, theta, alpha and beta band of EEG spectral power in motor cortex and hippocampus with the exception of the delta and beta bands power of motor cortex in wakeful state (Kumar and Desiraju, 1992). \n\nMale Sprague-Dawley rats have been exposed to Pb2+ from parturition to weaning though their dams' milk that received drinking water containing 1.0, 2.5, or 5.0 mg/ml lead acetate (McCarren and Eccles, 1983). Beginning from 15 weeks of age, the characteristics of the electrically elicited hippocampal afterdischarge (AD) and its alteration by phenytoin (PHT) showed significant increase in primary AD duration only in the animals exposed to the higher dose of Pb2+, whereas all groups responded to PHT with increases in primary AD duration (McCarren and Eccles, 1983). \n\nâ€¢ Uncertainties or Inconsistencies:\n\n",
										link_effecttoeffect23_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect23.getReferenceIDs().add(
						new Reference(link_effecttoeffect23, dataSource,
								"Cline H, Haas K. (2008) The regulation of dendritic arbor development and plasticity by glutamatergic synaptic input: A review of the synaptotrophic hypothesis. J Physiol 586: 1509-1517. ")
								.<Reference> makeItLive());
				link_effecttoeffect23.getReferenceIDs().add(
						new Reference(link_effecttoeffect23, dataSource, "ColÃ³n-Ramos DA. (2009) Synapse formation in developing neural circuits. Curr Top Dev Biol. 87: 53-79. ").<Reference> makeItLive());
				link_effecttoeffect23.getReferenceIDs().add(
						new Reference(link_effecttoeffect23, dataSource,
								"Ehrlich I, Klein M, Rumpel S, Malinow R. (2007) PSD-95 is required for activity-driven synapse stabilization. Proc Natl Acad Sci U S A. 104: 4176-4181. ").<Reference> makeItLive());
				link_effecttoeffect23.getReferenceIDs().add(
						new Reference(link_effecttoeffect23, dataSource,
								"Kumar MV, Desiraju T. (1992) EEG spectral power reduction and learning disability in rats exposed to lead through postnatal developing age. Indian J Physiol Pharmacol. 36: 15-20. ")
								.<Reference> makeItLive());
				link_effecttoeffect23.getReferenceIDs().add(
						new Reference(link_effecttoeffect23, dataSource,
								"McCarren M, Eccles CU. (1983) Neonatal lead exposure in rats: II. Effects on the hippocampal afterdischarge. Neurobehav Toxicol Teratol. 5: 533-540. ").<Reference> makeItLive());
				link_effecttoeffect23
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect23,
										dataSource,
										"McConnell ER, McClain MA, Ross J, Lefew WR, Shafer TJ. (2012) Evaluation of multi-well microelectrode arrays for neurotoxicity screening using a chemical training set. Neurotoxicology 33: 1048-1057. ")
										.<Reference> makeItLive());
				link_effecttoeffect23
						.getReferenceIDs()
						.add(
								new Reference(link_effecttoeffect23, dataSource,
										"Otto D, Reiter L. (1984) Developmental changes in slow cortical potentials of young children with elevated body lead burden. Neurophysiological considerations. Ann N Y Acad Sci. 425: 377-383. ")
										.<Reference> makeItLive());
				link_effecttoeffect23.getReferenceIDs().add(
						new Reference(link_effecttoeffect23, dataSource, "Rodier PM. (1995) Developing brain as a target of toxicity. Environ. Health Perspect. 103: 73-76.").<Reference> makeItLive());
				
				link_effecttoeffect25 = new Link_EffectToEffect(pathway, dataSource, effect_downstreameffect22, effect_downstreameffect24);
				link_effecttoeffect25.setLinkType(LinkType.UNKNOWN);
				ReferenceIDW<Link_EffectToEffect> link_effecttoeffect25_weigth0 = new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect25, dataSource, Link_EffectToEffect.class, 1.0);
				link_effecttoeffect25
						.getDescriptionIDs()
						.set(
								new DescriptionSection_Structured(
										link_effecttoeffect25,
										dataSource,
										"(Key) Event Relationships Weight of Evidences",
										"How Does This Key Event Relationship Work\n\nLearning and memory is one of the outcomes of the functional expression of neurons and neural networks from mammalian to invertebrates. Damage or destruction of neurons by chemical compounds during development when they are in the process of synapses formation, integration and formation of neural networks, will derange the organization and function of these networks, thereby setting the stage for subsequent impairment of learning and memory. Exposure to the potential developmental toxicants during neuronal differentiation and synaptogenesis will increase risk of functional neuronal network damage leading to learning and memory impairment. \n\nâ€¢ Biological Plausibility: \n\nLong-term potentiation (LTP) is a long-lasting increase in synaptic efficacy (not always and not always high frequency stimulation leads to LTP), and its discovery suggested that changes in synaptic strength could provide the substrate for learning and memory (reviewed in Lynch, 2004). Moreover, LTP is intimately related to the theta rhythm, an oscillation long associated with learning. Learning-induced enhancement in neuronal excitability, a measurement of neural network function, has also been shown in hippocampal neurons following classical conditioning in several experimental approaches (reviewed in Saar and Barkai, 2003). \n\nOn the other hand, memory requires the increase in magnitude of EPSCs to be developed quickly and to be persistent for few weeks at least without disturbing already potentiated contacts. Once again, a substantial body of evidence has demonstrated that tight connection between LTP and diverse instances of memory exist (reviewed in Lynch, 2004). \n\nâ€¢ Empirical Support for Linkage:\n\nA series of important findings suggest that the biochemical changes that happen after induction of LTP also occur during memory acquisition, showing temporality between the two KEs (reviewed in Lynch, 2004). \n\nFurthermore, a review on Morris water maze (MWM) as a tool to investigate spatial learning and memory in laboratory rats also pointed out that the disconnection between neuronal networks rather than the brain damage of certain regions is responsible for the impairment of MWM performance (D'Hooge and De Deyn, 2001). Functional integrated neural networks that involve the coordination action of different brain regions are consequently important for spatial learning and MWM performance. \n\nMorris et al. 1986 found that blocking the NMDA receptor with AP5 inhibits spatial learning in rats. Most importantly, in the same study they measured brain electrical activity and recorded that this agent also inhibits LTP, however, they have not proved that spatial learning and LTP inhibition are causally related (Morris et al., 1986). Since then a number of NMDA receptor antagonists have been studied towards their ability to induce impairment of learning and memory. It is worth mentioning that similar findings have been found in human subjects, where by combining behavioural and electrophysiological data from patients with temporal lobe epilepsy exposed to ketamine, they demonstrated involvement of NMDA receptors in human memory processes (Grunwald et al., 1999). \n\nPb2+: Exposure to low levels of Pb2+, during early development, has been implicated in long-lasting behavioural abnormalities and cognitive deficits in children (Needleman et al., 1975; Needleman and Gatsonis, 1990; Bellinger et al., 1991; 1992; Baghurst et al., 1992; Leviton et al., 1993; Needleman et al., 1996; Finkelstein et al., 1998; Lanphear et al., 2000; 2005; Canfield et al., 2003; Bellinger 2004; Lanphear et al., 2005; Surkan et al., 2007; Jusko et al., 2008; Neal and Guilarte, 2010) and experimental animals (Brockel and Cory-Slechta, 1998; Murphy and Regan, 1999; Moreira et al., 2001). Multiple lines of evidence suggest that Pb2+ can impair hippocampus-mediated learning in animal models (reviewed in Toscano and Guilarte, 2005). \n\nThe majority of the studies addressing the effects of Pb2+ on hippocampal-associated spatial learning and memory processes have been carried out mainly in male rats (Cao et al., 2008, Gilbert et al., 2005); only a few studies have examined both sexes simultaneously (Jett et al., 1997, Xu et al., 2009). Female rats exposed to Pb2+ through gestation and lactation have shown more severe impairment of memory than male rats with similar Pb2+ exposures (Jett et al., 1997). De Souza Lisboa et al. (2005) have reported that exposure to Pb2+ during both pregnancy and lactation causes depressive-like behaviour (detected in the forced swimming test) in female but not male rats. A more recent study has investigated the neurobehavioral outcomes in Pb2+-exposed rats (250, 750 and 1500 ppm Pb2+ acetate in food) during gestation and through weaning and demonstrated that these outcomes are very much influenced by sex and rearing environment (Anderson et al., 2012). In females, Pb2+ exposure lessens some of the benefits of enriched environment on learning, whereas, in males, enrichment does help to overcome detrimental effects of Pb2+ on learning. Regarding reference memory, environmental enrichment has not been beneficial in females when exposure to Pb2+ occurs, in contrast to males (Anderson et al., 2012). \n\nWistar rat pups were exposed to 0.2% Pb2+ via their dams' drinking water from PND 1 to PND 21 and directly via drinking water from weaning until PND 30 (Jaako-Movits et al., 2005). At PND 60 and 80, the neurobehavioural assessment has revealed that developmental Pb2+ exposure induces persistent increase in the level of anxiety and inhibition of contextual fear conditioning (Jaako-Movits et al., 2005). The same behavioural syndrome in rats has been described in Salinas and Huff, 2002 and is in agreement with observations on humans as children exposed to low levels of Pb2+ display attention deficit, increased emotional reactivity and impaired memory and learning (Finkelstein et al., 1998). \n\nIn experiments carried out in Wistar rats that were fed with lead acetate (400 micrograms lead/g body weight/day) from PND 2 until PND 60, EEG findings show statistically significant reduction in the delta, theta, alpha and beta band EEG spectral power in motor cortex and hippocampus but not in delta and beta bands power of motor cortex in wakeful state (Kumar and Desiraju, 1992). After 40 days of recovery, animals have been assessed for their neurobehaviour and revealed that Pb2+ treated animals show more time and sessions in attaining criterion of learning than controls (Kumar and Desiraju, 1992). Further data obtained using animal behavioral techniques demonstrate that NMDA mediated synaptic transmission is decreased by Pb2+ exposure (Cory-Slechta, 1995; Cohn and Cory-Slechta, 1993; 1994). \n\nRat pups from parents exposed to 2 mM PbCl2 3 weeks before mating until their weaning (pre-weaning Pb2+) and weaned pups exposed to 2 mM PbCl2 for 9 weeks (post-weaning Pb2+) were assessed for their spatial learning and memory by MWM on PND 85-90 (Xiao et al., 2014). The study revealed that both rat pups in pre-weaning Pb2+ and post-weaning Pb2+ groups performed significantly worse than those in control group(Xiao et al., 2014). \n\nThe number of synapses in pre-weaning Pb2+ group increased significantly, but it was still less than that of Control group (p<0.05); the number of synapses in post-weaning Pb2+ group was also less than that of control group (p<0.05), although the number of synapses has no differences between post-weaning Pb2+ and control groups before MWM. In both pre-weaning Pb2+ and post-weaning Pb2+ groups, synaptic structural parameters such as thickness of postsynaptic density (PSD), length of synaptic active zone and synaptic curvature increased whereas width of synaptic cleft decreased compared to controls (Xiao et al., 2014). \n\nâ€¢ Uncertainties or Inconsistencies:\n\nOne of the most difficult issues for neuroscientists is to link neuronal network function to cognition, including learning and memory. It is still unclear what modifications of neuronal circuits need to happen in order to alter motor behaviour as it is recorded in a learning and memory test (Mayford et al., 2012), meaning that there is no clear understanding about the how these two KEs are connected. \n\nSeveral epidemiological studies where Pb2+ exposure levels have been studied in relation to neurobehavioural alterations in children have been reviewed in Koller et al. 2004. This review has concluded that in some occasions there is negative correlation between Pb2+ dose and cognitive deficits of the subjects due to high influence of social and parenting factors in cognitive ability like learning and memory (Koller et al. 2004), meaning that not always Pb2+ exposure is positivly associated with learning and memory impairment in children. \n\n",
										link_effecttoeffect25_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
				link_effecttoeffect25.getReferenceIDs().add(
						new Reference(link_effecttoeffect25, dataSource,
								"Anderson DW, Pothakos K, Schneider JS. (2012) Sex and rearing condition modify the effects of perinatal lead exposure on learning and memory. Neurotoxicology 33: 985-995. ")
								.<Reference> makeItLive());
				link_effecttoeffect25
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect25,
										dataSource,
										"Baghurst PA, Tong S, Sawyer MG, Burns J, McMichael AJ. (1992) Environmental exposure to lead and childrenâ€™s intelligence at the age of seven years. The Port Pirie Cohort Study. N Engl J Med. 327: 1279-1284. ")
										.<Reference> makeItLive());
				link_effecttoeffect25
						.getReferenceIDs()
						.add(
								new Reference(link_effecttoeffect25, dataSource,
										"Bellinger D, Sloman J, Leviton A, Rabinowitz M, Needleman HL, Waternaux C. (1991) Low-level lead exposure and children's cognitive function in the preschool years. Pediatrics. 87: 219-227. ")
										.<Reference> makeItLive());
				link_effecttoeffect25.getReferenceIDs().add(
						new Reference(link_effecttoeffect25, dataSource,
								"Bellinger DC, Stiles KM, Needleman HL. (1992) Low-level lead exposure, intelligence and academic achievement: a long-term follow-up study. Pediatrics. 90: 855-861. ")
								.<Reference> makeItLive());
				link_effecttoeffect25.getReferenceIDs().add(new Reference(link_effecttoeffect25, dataSource, "Bellinger DC. (2004) Lead. Pediatrics 113: 1016-1022. ").<Reference> makeItLive());
				link_effecttoeffect25.getReferenceIDs().add(
						new Reference(link_effecttoeffect25, dataSource,
								"Brockel BJ, Cory-Slechta DA. (1998) Lead, attention, and impulsive behavior: changes in a fixed-ratio waiting-for-reward paradigm. Pharmacol Biochem Behav. 60: 545-552. ")
								.<Reference> makeItLive());
				link_effecttoeffect25
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect25,
										dataSource,
										"Canfield RL, Henderson CR Jr, Cory-Slechta D, Cox C, Jusko TA, Lanphear BP. (2003) Intellectual impairment in children with blood lead concentrations below 10 Î¼g per deciliter. N Engl J Med. 348: 1517-1526. ")
										.<Reference> makeItLive());
				link_effecttoeffect25
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect25,
										dataSource,
										"Cao X, Huang S, Ruan D. (2008) Enriched environment restores impaired hippocampal long-term potentiation and water maze performance induced by developmental lead exposure in rats. Dev Psychobiol. 50: 307-313. ")
										.<Reference> makeItLive());
				link_effecttoeffect25
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect25,
										dataSource,
										"Cohn J, Cory-Slechta DA. (1993) Subsensitivity of lead-exposed rats to the accuracy-impairing and rate-altering effects of MK-801 on a multiple schedule of repeated learning and performance. Brain Res. 600: 208-218. ")
										.<Reference> makeItLive());
				link_effecttoeffect25.getReferenceIDs().add(
						new Reference(link_effecttoeffect25, dataSource,
								"Cohn J, Cory-Slechta DA. (1994) Lead exposure potentiates the effects of N-methyl-D-asparate on repeated learning. Neurotoxicol Teratol. 16: 455-465. ").<Reference> makeItLive());
				link_effecttoeffect25.getReferenceIDs().add(
						new Reference(link_effecttoeffect25, dataSource, "Cory-Slechta DA. (1995) MK-801 subsensitivity following postweaning lead exposure. Neurotoxicology 16: 83-95. ").<Reference> makeItLive());
				link_effecttoeffect25.getReferenceIDs().add(
						new Reference(link_effecttoeffect25, dataSource, "D'Hooge R, De Deyn PP. (2001) Applications of the Morris water maze in the study of learning and memory. Brain Res Brain Res Rev. 36: 60-90. ")
								.<Reference> makeItLive());
				link_effecttoeffect25
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect25,
										dataSource,
										"de Souza Lisboa S F, Gonzalves G, Komatsu F, Salci Queiroz CA, Aparecido Almeida A, Gastaldello Moreira EN. (2005) Developmental lead exposure induces depressive-like behavior in female rats. Drug Chem Toxicol. 28: 67-77. ")
										.<Reference> makeItLive());
				link_effecttoeffect25.getReferenceIDs().add(
						new Reference(link_effecttoeffect25, dataSource,
								"Finkelstein Y, Markowitz ME, Rosen JF. (1998) Low-level lead-induced neurotoxicity in children: an update on central nervous system effects. Brain Res Rev. 27: 168-176. ")
								.<Reference> makeItLive());
				link_effecttoeffect25
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect25,
										dataSource,
										"Gilbert ME, Kelly ME, Samsam TE, Goodman JH. (2005) Chronic developmental lead exposure reduces neurogenesis in adult rat hippocampus but does not impair spatial learning. Toxicol Sci. 86: 365-374. ")
										.<Reference> makeItLive());
				link_effecttoeffect25
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect25,
										dataSource,
										"Grunwald T, Beck H, Lehnertz K, BlÃ¼mcke I, Pezer N, Kurthen M, FernÃ¡ndez G, Van Roost D, Heinze HJ, Kutas M, Elger CE. (1999) Evidence relating human verbal memory to hippocampal N-methyl-D-aspartate receptors. Proc Natl Acad Sci U S A. 96: 12085-12089. ")
										.<Reference> makeItLive());
				link_effecttoeffect25
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect25,
										dataSource,
										"Jaako-Movits K, Zharkovsky T, Romantchik O, Jurgenson M, Merisalu E, Heidmets LT, Zharkovsky A. (2005) Developmental lead exposure impairs contextual fear conditioning and reduces adult hippocampal neurogenesis in the rat brain. Int J Dev Neurosci. 23: 627-635. ")
										.<Reference> makeItLive());
				link_effecttoeffect25.getReferenceIDs().add(
						new Reference(link_effecttoeffect25, dataSource,
								"Jett DA, Kuhlmann AC, Farmer SJ, Guilarte TR. (1997) Age-dependent effects of developmental lead exposure on performance in the Morris water maze. Pharmacol Biochem Behav. 57: 271-279. ")
								.<Reference> makeItLive());
				link_effecttoeffect25
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect25,
										dataSource,
										"Jusko TA, Henderson CR, Lanphear BP, Cory-Slechta DA, Parsons PJ, Canfield RL (2008) Blood lead concentrations < 10 microg/dL and child intelligence at 6 years of age. Environ Health Perspect 116:243-248. ")
										.<Reference> makeItLive());
				link_effecttoeffect25.getReferenceIDs().add(
						new Reference(link_effecttoeffect25, dataSource,
								"Koller K, Brown T, Spurgeon A, Levy L (2004) Recent developments in low-level lead exposure and intellectual impairment in children. Environ Health Perspect. 112: 987-994. ")
								.<Reference> makeItLive());
				link_effecttoeffect25.getReferenceIDs().add(
						new Reference(link_effecttoeffect25, dataSource,
								"Kumar MV, Desiraju T. (1992) EEG spectral power reduction and learning disability in rats exposed to lead through postnatal developing age. Indian J Physiol Pharmacol. 36: 15-20. ")
								.<Reference> makeItLive());
				link_effecttoeffect25
						.getReferenceIDs()
						.add(
								new Reference(link_effecttoeffect25, dataSource,
										"Lanphear BP, Dietrich K, Auinger P, Cox C. (2000) Cognitive deficits associated with blood lead concentrations <10 microg/dL in US children and adolescents. Public Health Rep. 115: 521-529. ")
										.<Reference> makeItLive());
				link_effecttoeffect25
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect25,
										dataSource,
										"Lanphear BP, Hornung R, Khoury J, Yolton K, Baghurst P, Bellinger DC, Canfield RL, Dietrich KN, Bornschein R, Greene T, Rothenberg SJ, Needleman HL, Schnaas L, Wasserman G, Graziano J, Roberts R. (2005) Low-level environmental lead exposure and childrenâ€™s intellectual function: an international pooled analysis. Environ Health Perspect. 113: 894-899. ")
										.<Reference> makeItLive());
				link_effecttoeffect25.getReferenceIDs().add(
						new Reference(link_effecttoeffect25, dataSource,
								"Leviton A, Bellinger D, Allred EH, Rabinowitz M, Needleman H, Schoenbaum S (1993) Pre- and postnatal low-level lead exposure and children's dysfunction in school. Environ Res 60:30-43. ")
								.<Reference> makeItLive());
				link_effecttoeffect25.getReferenceIDs().add(
						new Reference(link_effecttoeffect25, dataSource, "Lynch MA. (2004) Long-term potentiation and memory. Physiol Rev. 84: 87-136. ").<Reference> makeItLive());
				link_effecttoeffect25.getReferenceIDs().add(
						new Reference(link_effecttoeffect25, dataSource, "Mayford M, Siegelbaum SA, Kandel ER. (2012) Synapses and memory storage. Cold Spring Harb Perspect Biol. 4. pii: a005751. ")
								.<Reference> makeItLive());
				link_effecttoeffect25.getReferenceIDs()
						.add(
								new Reference(link_effecttoeffect25, dataSource,
										"Moreira EG, Vassilieff I, Vassilieff VS. (2001) Developmental lead exposure: behavioral alterations in the short and long term. Neurotoxicol Teratol. 23: 489-495. ")
										.<Reference> makeItLive());
				link_effecttoeffect25
						.getReferenceIDs()
						.add(
								new Reference(link_effecttoeffect25, dataSource,
										"Morris RG, Anderson E, Lynch GS, Baudry M. (1986) Selective impairment of learning and blockade of long-term potentiation by an N-methyl-D-aspartate receptor antagonist, AP5. Nature 319: 774-776. ")
										.<Reference> makeItLive());
				link_effecttoeffect25
						.getReferenceIDs()
						.add(
								new Reference(link_effecttoeffect25, dataSource,
										"Murphy KJ, Regan CM. (1999) Low level lead exposure in the early postnatal period results in persisting neuroplastic deficits associated with memory consolidation. J Neurochem. 72: 2099-2104. ")
										.<Reference> makeItLive());
				link_effecttoeffect25.getReferenceIDs().add(
						new Reference(link_effecttoeffect25, dataSource, "Neal AP, Guilarte TR. (2010) Molecular Neurobiology of Lead (Pb2+): Effects on Synaptic Function. Mol Neurobiol. 42: 151-160. ")
								.<Reference> makeItLive());
				link_effecttoeffect25.getReferenceIDs().add(
						new Reference(link_effecttoeffect25, dataSource,
								"Needleman HL, Epstein S, Carnow B, Scanlon J, Parkinson D, Samuels S, Mazzochi A, David O. (1975) Letter: Blood-lead levels, behaviour and intelligence. Lancet 1: 751-752. ")
								.<Reference> makeItLive());
				link_effecttoeffect25.getReferenceIDs().add(
						new Reference(link_effecttoeffect25, dataSource, "Needleman HL, Gatsonis CA (1990) Low-level lead exposure and the IQ of children. A meta-analysis of modern studies. Jama 263: 673-678. ")
								.<Reference> makeItLive());
				link_effecttoeffect25.getReferenceIDs().add(
						new Reference(link_effecttoeffect25, dataSource, "Needleman HL, Riess JA, Tobin MJ, Biesecker GE, Greenhouse JB. (1996) Bone Lead Levels and Delinquent Behavior. Jama 275: 363-369. ")
								.<Reference> makeItLive());
				link_effecttoeffect25.getReferenceIDs().add(
						new Reference(link_effecttoeffect25, dataSource, "Saar D, Barkai E. (2003) Long-term modifications in intrinsic neuronal properties and rule learning in rats. Eur J Neurosci. 17: 2727-2734. ")
								.<Reference> makeItLive());
				link_effecttoeffect25.getReferenceIDs().add(
						new Reference(link_effecttoeffect25, dataSource, "Salinas JA, Huff NC. (2002) Lead and conditioned fear to contextual and discrete cues. Neurotoxicol Teratol. 24: 541-550. ")
								.<Reference> makeItLive());
				link_effecttoeffect25
						.getReferenceIDs()
						.add(
								new Reference(link_effecttoeffect25, dataSource,
										"Surkan PJ, Zhang A, Trachtenberg F, Daniel DB, McKinlay S, Bellinger DC. (2007) Neuropsychological function in children with blood lead levels <10 microg/dL. Neurotoxicology. 28: 1170-1177. ")
										.<Reference> makeItLive());
				link_effecttoeffect25.getReferenceIDs()
						.add(
								new Reference(link_effecttoeffect25, dataSource, "Toscano CD, Guilarte TR. (2005) Lead neurotoxicity: From exposure to molecular effects. Brain Res Rev. 49: 529-554. ")
										.<Reference> makeItLive());
				link_effecttoeffect25
						.getReferenceIDs()
						.add(
								new Reference(
										link_effecttoeffect25,
										dataSource,
										"Xiao Y, Fu H, Han X, Hu X, Gu H, Chen Y, Wei Q, Hu Q. (2014) Role of synaptic structural plasticity in impairments of spatial learning and memory induced by developmental lead exposure in Wistar rats. PLoS One. 23;9(12):e115556. ")
										.<Reference> makeItLive());
				link_effecttoeffect25
						.getReferenceIDs()
						.add(
								new Reference(link_effecttoeffect25, dataSource,
										"Xu J, Yan HC, Yang B, Tong LS, Zou YX, Tian Y. (2009) Effects of lead exposure on hippocampal metabotropic glutamate receptor subtype 3 and 7 in developmental rats. J Negat Results Biomed. 8: 5. ")
										.<Reference> makeItLive());
				
				pathway.updateEssentiality();
				EssetialityDescription essentiality = pathway.getEssentiality();
				DescriptionSection_Structured dss;
				pathway
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										pathway,
										dataSource,
										"Abstract",
										"It is well documented and accepted that learning and memory processes rely on physiological functioning of the glutamate receptor N-methyl-D-aspartate (NMDAR). Both animal and human studies investigating NMDA itself, experiments with NMDAR antagonists and mutant mice lacking NMDAR subunits strongly support this statement (Rezvani, 2006). Activation of NMDARs results in long-term potentiation (LTP), which is related to increased synaptic strength, plasticity and memory formation in the hippocampus (Johnston et al., 2009). LTP induced by activation of NMDA receptors has been found to be elevated in the developing rodent brain compared to the mature brain, partially due to 'developmental switch' of the NMDAR 2A and 2B subunits (Johnston et al., 2009). Activation of the NMDAR also enhances brain derived neurotrophic factor (BDNF) release, which promotes neuronal survival, differentiation and synaptogenesis (Tyler et al., 2002; Johnston et al., 2009). Consequently, the blockage of NMDAR by chemical substances during synaptogenesis disrupts neuronal network formation resulting in the impairment of learning and memory processes (Toscano and Guilarte, 2005). This AOP is relevant to developmental neurotoxicity (DNT). The molecular initiating event (MIE) is described as the chronic binding of antagonist to NMDAR in neurons during synaptogenesis (development) in hippocampus (one of the critical brain structures for learning and memory formation). One of the chemicals that blocks NMDAR after chronic exposure is lead (Pb2+), a well-known developmental neurotoxicant.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);
				dss = essentiality.getEssentialityDescription(effect_molecularinitiatingevent3);
				dss
						.setContent("<html>The MIE is defined and described above as the binding of antagonist to NMDA receptor in neurons during development in hippocampus and cortex (the critical brain structures for learning and memory formation). Activation of NMDA receptors results in long-term potentiation (LTP), which is related to increased synaptic strength and memory formation in the hippocampus (Johnston et al., 2009). LTP induced by activation of NMDA receptors has been found to be elevated in the developing rodent brain compared to the mature brain, partially due to \"developmental switch\" of the NMDAR 2A and 2B subunits (Johnston et al., 2009).<br><br><b>Essentiality of MIE (binding of antagonist to NMDAR in neurons during synaptogenesis in hippocampus and cortex) for AO (Impairment of learning and memory) is STRONG:</b> It is well documented that learning and memory processes rely on physiological functioning of NMDA receptors. The essentiality of the MIE has been demonstrated in both animal and human studies investigating NMDA itself, NMDA receptors antagonists and mutant mice lacking NMDA receptor subunits (reviewed in Haberny et al., 2002; Rezvani, 2006 and Granger et al., 2011). NMDA systemically administered in rats, has been shown to potentiate cognitive functions (Rezvani, 2006). There are various studies dealing with specific NMDA receptor subunit gene knock-out leading to a variety of phenotypes. Depending on the endogenous levels of NMDAR subunits, the pattern of their expression and their importance in developmental processes, the loss of a subunit may lead from early embryonic lethality, to mild neurobehavioral impairment up to neuronal disorders that manifest learning and memory deficits (reviewed in Rezvani, 2006 and Granger et al., 2011). Mutant mice lacking NR1 gene have shown perinatal lethality, whereas transgenic mice lacking NR1 subunit in the CA1 region of the hippocampus show both defective LTP and severe deficits in both spatial and nonspatial learning (Shimizu et al., 2000; Tsien et al., 1996). A similar impairment of LTP, long-term depression (LTD), and spatial memory has been seen with CA1-specific NR2B deletion (Brigman et al. 2010). However, LTP has been normal in postnatal forebrain knock-out of NR2A in mice, even though spatial memory has been impaired, probably because of the severe reduction observed in overall excitatory transmission (Shimshek et al., 2006), while the inactivation of the same gene has led to reduced hippocampal LTP and spatial learning (Sakimura et al., 1995). Furthermore, a NR2B transgenic (Tg) line of mice has been developed, in which the NMDA-receptor function has been increased, showing both larger LTP in the hippocampus and superior learning and memory (Tang et al., 1999). Finally, depletion of both NR2A and NR2B in single neurons has shown alteration in synaptic development (Gray et al., 2011). Interestingly, during development, especially during postnatal days (PND) 7-14 in rodents, the central nervous system (CNS) exhibits increased susceptibility to toxic insults that affect NMDA receptors (Haberny et al., 2002). This increased susceptibility has been suggested to be related to the elevated expression of specific NMDA receptor subunits (Miyamoto et al., 2001). Because of the critical role of the NMDA receptor system in brain development, the exposure to antagonists of NMDA receptors can have long-lasting and severe effects (Behar et al., 1999). NMDA-receptor antagonists such as MK-801, ketamine, phencyclidine (PCP) and 2-amino-5-phosphonopentanoate (AP5 or APV) have been extensively used to study the role of NMDA in learning and memory in developing organisms. Both acute and subchronic administration of NMDA-receptor antagonists in several laboratory animals has been shown to impair performance on tasks that seem to depend upon hippocampal functions (reviewed in Rezvani, 2006; Haberny et al., 2002). The developmental neurotoxicity of several agents, including methylmercury, lead, and ethanol is also thought to result from interaction of these substances with the NMDA receptor system (Guilarte, 1997; Guilarte and McGlothan, 1998; Ikonomidou et al., 2000; Kumari and Ticku, 1998; Miyamoto et al., 2001).<br><br><b>Essentiality of MIE (binding of antagonist to NMDAR in neurons during synaptogenesis in hippocampus and cortex for KE (aberrant dendritic morphology) is MODERATE:</b> The cortex-restricted knockout of NR1 causes refinement in dendritic arborisation in cortex and loss of patterning (Iwasato et al., 2000; Lee et al., 2005). Similar alteration in dendritic arbor has also been identified after depletion of both NR2A and NR2B subunits in isolated neurons (Espinosa et al., 2009). Blockade of NMDA receptor with APV has shown decrease of dendritic growth rate in some in vivo experimental approaches (Rajan et al., 1999; Rajan and Cline, 1998). However, other studies have reported increase in dendritic spine number and dendritic branching after chronic APV-treatment both in vivo and in vitro (Rocha and Sur, 1995; McAllister et al., 1996). This discrepancy is possibly attributed to the different developmental expression of NMDA receptor subunits that triggers distinct intracellular signaling pathways linking NMDAR function to different morphological findings.<br><br><b>Essentiality of MIE (binding of antagonist to NMDAR in neurons during synaptogenesis in hippocampus and cortex) for KE (cell death) is STRONG:</b> The essential role of NMDA receptors in survival during early cortical development has been pointed out both in in vitro (Hwang et al., 1999; Yoon et al., 2003) and in vivo rodent studies (Ikonomidou et al., 1999). NMDA receptor deficient mice have revealed the importance of this receptor for neuronal survival during development as an approximately 2-fold increase in developmental cell death has been observed in these transgenic mice, which was caspase-3 and Bax dependent (Adams et al., 2004; Rivero Vaccari et al., 2006).<br><br><b>Essentiality of MIE for KE (decreased neuronal network function) is STRONG:</b> The NMDA receptor is associated with circuit formation and function at the developmental stage of an organism as a number of antagonists of this receptor importantly disrupt the neuronal circut (Simon et al., 1992). Hence, the nature of evidence for the essentiality of the MIE is High (Strong).</html>");
				dss.setFormat(ContentFormat.HTML);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(3.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect6);
				dss
						.setContent("<html><b>Essentiality of KE (Inhibition of NMDA receptors) for AO (Impairment of learning and memory))</b> is <b>STRONG:</b> The noncompetitive antagonist MK-801 has been shown to induce dose-dependent impairment of learning and memory (Wong et al., 1986) and data on rodent models has been recently reviewed in van der Staay et al. 2011. Learning impairments induced by NMDA receptor blockade using MK-801 have also been reported in nonhuman primates (Ogura and Aigner, 1993). Moreover there are human studies demonstrating that NMDA-receptor inhibition impairs learning and memory processes (reviewed in Rezvani, 2006).</html");
				dss.setFormat(ContentFormat.HTML);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(3.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect8);
				dss
						.setContent("<html><b>Essentiality of KE (Decreased Calcium influx) for AO (Impairment of learning and memory)</b> is <b>STRONG:</b> In the nervous system, many intracellular responses to modified Ca2+ levels are mediated by calcium/calmodulin-regulated protein kinases (CaMKs), a family of protein kinases that are initially modulated by binding of Ca2+ to CaM and subsequently by protein phosphorylation (Wayman et al., 2008). Multifunctional CaMKs, such as CaMKII and members of CaMK cascade (CaMKK, CaMKI and CaMKIV) are highly abundant in CNS and regulate different protein substrates (Soderling, 1999). Mice with a mutation in the alpha- CaMKII that is abundantly found in the hippocampus have shown spatial learning impairments, whereas some types of non-spatial learning peocesses have not been affected (Silva et al., 1992).");
				dss.setFormat(ContentFormat.HTML);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(3.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect10);
				dss.setContent("");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(3.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect12);
				dss.setContent("");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(3.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect13);
				dss.setContent("");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(3.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect14);
				dss.setContent("");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(3.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect18);
				dss.setContent("");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(3.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect22);
				dss.setContent("");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(3.0);
				dss = essentiality.getEssentialityDescription(effect_downstreameffect24);
				dss.setContent("");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(3.0);
			}
	}

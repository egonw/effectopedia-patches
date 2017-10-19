package org.qsari.effectopedia.data.generated;

import org.qsari.effectopedia.base.ids.ReferenceIDW;
import org.qsari.effectopedia.core.object.elemets.EssetialityDescription;
import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.core.objects.DescriptionSection.ContentFormat;
import org.qsari.effectopedia.core.objects.DescriptionSection_Structured;
import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Effect_DownstreamEffect;
import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.Link.LinkType;
import org.qsari.effectopedia.core.objects.Link_ChemStructToMIE;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.core.objects.Reference;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.RevisionBasedDS;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public class QAOP_NMDARs extends SourceGeneratedPathway
	{
		
		public QAOP_NMDARs(DataSource dataSource)
			{
				super("Chronic binding of antagonist to N-methyl-D-aspartate receptors (NMDARs) during brain development induces impairment of learning and memory abilities",
						"N-methyl-D-aspartate receptors, NMDARs, brain development, learning imapriment", dataSource, "D://Java//org.qsari.effectopedia//test//NMDARs");
			}
		
		// revision1
		protected Initiator_ChemicalStructure					chemical1;
		protected Effect_MolecularInitiatingEvent	mie1;
		protected Effect_DownstreamEffect									molecular_effect1;
		protected Link_EffectToEffect													link_mie1_me1;
		protected Effect_DownstreamEffect									cellular_effect1;
		protected Link_EffectToEffect													link_me1_ce1;
		protected Effect_DownstreamEffect									cellular_effect2;
		protected Effect_DownstreamEffect									cellular_effect3;
		protected Effect_DownstreamEffect									cellular_effect4;
		protected Effect_DownstreamEffect									cellular_effect5;
		protected Effect_DownstreamEffect									cellular_effect6;
		protected Effect_DownstreamEffect									organ_effect1;
		protected Effect_DownstreamEffect									individual_effect1;
		
		@Override
		public void generateContent()
			{
				genreateRevision1();
				storeRevision();
				((RevisionBasedDS) dataSource).setLocation(pathway);
			}
		
		@SuppressWarnings("unchecked")
		public void genreateRevision1()
			{
				pathway
						.setUids("OECD Project 1.22: The Adverse Outcome Pathway from Binding of Antagonists to NMDAR During Brain Development (Synaptogenesis) Induces Impairment of learning and Memory Abilities");
				pathway.setStatus("EAGMST Approved");
				
				pathway
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										pathway,
										dataSource,
										"Abstract",
										"It is well documented and accepted that learning and memory processes rely on physiological functioning of the glutamate receptor N-methyl-D-aspartate (NMDAR). Both animal and human studies investigating NMDA itself, experiments with NMDAR antagonists and mutant mice lacking NMDAR subunits strongly support this statement (Rezvani, 2006). Activation of NMDARs results in long-term potentiation (LTP), which is related to increased synaptic strength, plasticity and memory formation in the hippocampus (Johnston et al., 2009). LTP induced by activation of NMDA receptors has been found to be elevated in the developing rodent brain compared to the mature brain, partially due to 'developmental switch' of the NMDAR 2A and 2B subunits (Johnston et al., 2009). Activation of the NMDAR also enhances brain derived neurotrophic factor (BDNF) release, which promotes neuronal survival, differentiation and synaptogenesis (Tyler et al., 2002; Johnston et al., 2009). Consequently, the blockage of NMDAR by chemical substances during synaptogenesis disrupts neuronal network formation resulting in the impairment of learning and memory processes (Toscano and Guilarte, 2005). This AOP is relevant to developmental neurotoxicity (DNT). The molecular initiating event (MIE) is described as the chronic binding of antagonist to NMDAR in neurons during synaptogenesis (development) in hippocampus (one of the critical brain structures for learning and memory formation). One of the chemicals that blocks NMDAR after chronic exposure is lead (Pb2+), a well-known developmental neurotoxicant.")
										.<DescriptionSection> makeItLive(), 0);
				
				chemical1 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical1.setTitle("Lead acetate");
				chemical1.getStructure2DImage().setValue("https://apps.ideaconsult.net/ambit2/depict/cdk?search=CC%28%3DO%29%5BO-%5D.CC%28%3DO%29%5BO-%5D.%5BPb%2B2%5D&w=200&h=200&media=image/png");
				chemical1.getIdentification().setPropertyValue(0,"301042");
				chemical1.getIdentification().setPropertyValue(1,"lead(2+);diacetate");
				chemical1.getIdentification().setPropertyValue(2,"CC(=O)[O-].CC(=O)[O-].[Pb+2]");
				chemical1.getIdentification().setPropertyValue(3,"InChI=1S/2C2H4O2.Pb/c2*1-2(3)4;/h2*1H3,(H,3,4);/q;;+2/p-2");
				chemical1.getIdentification().setPropertyValue(4,"GUWSLQUAAYEZAF-UHFFFAOYSA-L");
				chemical1.getIdentification().setPropertyValue(5," ");
				chemical1.getIdentification().setPropertyValue(6,"");
				chemical1.setSynonymsList(new String[] {" "});
				
				
				mie1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie1.setTitle("NMDARs, Binding of antagonist");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										mie1,
										dataSource,
										"Definition",
										"<html><b>Biological state:</b> L-glutamate (Glu) is a neurotransmitter with important role in the regulation of brain development and maturation processes. Two major classes of Glu receptors, ionotropic and metabotropic, have been identified. Due to its physiological and pharmacological properties, Glu activates three classes of ionotropic receptors named: α-amino-3-hydroxy-5-methyl-4-isoazolepropionic acid (AMPA receptors), 2-carboxy-3-carboxymethyl-4-isopropenylpyrrolidine (kainate receptors) and N-methyl-D-aspartate (NMDA receptors, NMDARs), which transduce the postsynaptic signal. Ionotropic glutamate receptors are integral membrane proteins formed by four large subunits that compose a central ion channel pore. In case of NMDA receptors, two NR1 subunits are combined with either two NR2 (NR2A, NR2B, NR2C, NR2D) subunits and less commonly are assembled together with a combination of NR2 and NR3 (A, B) subunits (reviewed in Traynelis et al., 2010). To be activated NMDA receptors require simultaneous binding of both glutamate to NR2 subunits and of glycine to either NR1 or NR3 subunits that provide the specific binding sites named extracellular ligand-binding domains (LBDs). Apart from LBDs, NMDA receptor subunits contain three more domains that are considered semiautonomous: 1) the extracellular amino-terminal domain that plays important role in assembly and trafficking of these receptors; 2) the transmembrane domain that is linked with LBD and contributes to the formation of the core of the ion channel and 3) the intracellular carboxyl-terminal domain that influences membrane targeting, stabilization, degradation and post-translation modifications.<br><br><b>Biological compartments:</b> The genes of the NMDAR subunits are expressed in various tissues and are not only restricted to the nervous system. The level of expression of these receptors in neuronal and non-neuronal cells depends on: transcription, chromatin remodelling, mRNA levels, translation, stabilization of the protein, receptor assembly and trafficking, energy metabolism and numerous environmental stimuli (reviewed in Traynelis et al., 2010).<br><br>In hippocampus region of the brain, NR2A and NR2B are the most abundant NR2 family subunits. NR2A-containing NMDARs are mostly expressed synaptically, while NR2B-containing NMDARs are found both synaptically and extrasynaptically (Tovar and Westbrook, 1999).<br><br><b>General role in biology:</b> NMDA receptors, when compared to the other Glu receptors, are characterized by higher affinity for Glu, slower activation and desensitisation kinetics, higher permeability for calcium (Ca2+) and susceptibility to potential-dependent blockage by magnesium ions (Mg2+). NMDA receptors are involved in fast excitatory synaptic transmission and neuronal plasticity in the central nervous system (CNS). Functions of NMDA receptors:<br><br> 1. They are involved in cell signalling events converting environmental stimuli to genetic changes by regulating gene transcription and epigenetic modifications in neuronal cells (Cohen and Greenberg, 2008).<br><br>	2. In NMDA receptors, the ion channel is blocked by extracellular Mg2+ and Zn2+ ions, allowing the flow of Na+ and Ca2+ ions into the cell and K+ out of the cell which is voltage-dependent. Ca2+ flux through the NMDA receptor is considered to play a critical role in pre- and post-synaptic plasticity, a cellular mechanism important for learning and memory (Barria and Malinow, 2002).<br><br>	3. The NMDA receptors have been shown to play an essential role in the strengthening of synapses and neuronal differentiation, through long-term potentiation (LTP), and the weakening of synapses, through long-term depression (LTD). All these processes are implicated in the memory and learning function (Barria and Malinow, 2002).<br><br><html>")
										.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 0);
				mie1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										mie1,
										dataSource,
										"Measurment/detection",
										"<html><i>Methods that have been previously reviewed and approved by a recognized authority should be included in the Overview section above. All other methods, including those well established in the published literature, should be described here. Consider the following criteria when describing each method: 1. Is the assay fit for purpose? 2. Is the assay directly or indirectly (i.e. a surrogate) related to a key event relevant to the final adverse effect in question? 3. Is the assay repeatable? 4. Is the assay reproducible?</i><br>There is no OECD advised method for measuring NMDA receptor binding of antagonists. However, there are methods described in the scientific literature that allow measuring:<br><br><b>1. Ex vivo: </b>The most common assay used is the NMDA receptor (MK801 site) radioligand competition binding assays (Reynolds, 2001; Gao et al., 2013; http://pdsp.med.unc.edu/UNC-CH%20Protocol%20Book.pdf; http://www.currentprotocols.com/WileyCDA/CPUnit/refId-ph0120.html). This assay is based on the use of the most potent and specific antagonist of this receptor, MK801 that is used to detect and differentiate agonists and antagonists that bind to this specific site of the receptor.<br><br><b>2. In silico: </b>The prediction of NMDA receptor targeting is achievable by combining database mining, molecular docking, structure-based pharmacophore searching, and chemical similarity searching methods together (Korkut and Varnali, 2003; Koutsoukos et al., 2011; Gao et al., 2013; Mazumber and Borah, 2014; Chtitaa et al., 2015).</html>")
										.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 1);
				mie1
						.getDescriptionIDs()
						.add(
								new DescriptionSection(
										mie1,
										dataSource,
										"Evidence Supporting Taxonomic Applicability",
										"The evolution of NMDAR subunits (NR1, NR2, NR3) is well-conserved throughout different species from lower organism to mammals, including humans (Ewald and Cline, 2009; Tikhonov and Magazanik, 2009; Koo and Hampson, 2010; Teng et al., 2010; Flores-soto et al., 2012).\nMany of the binding sites for the noncompetitive or competitive antagonists e.g. for binding of dizocilpine (MK-801), phencyclidine, D-2-amino-5-phosphonopentanoate (AP5) and 3-((R)-2-carboxypiperazin-4-yl)-propyl-1-phosphonic acid (R-CPP) are also conserved in Drosophila (reviewed in Xia and Chiang, 2009).\nCellular membranes can be prepared from different brain areas of distinct species. Using [3H]MK-801, high affinity binding sites for MK-801 were detected in membranes of the rat brain (Woodruff et al., 1987). The same binding assay has been used in preparations from human brains mostly by patients with neurodegenerative disorders (Slater et al., 1993) as well as from different marine, avian species (Scheuhammer et al., 2008) and insects (Eldefrawi et al., 1993).")
										.<DescriptionSection> makeItLive());
				mie1
						.getDescriptionIDs()
						.add(
								new DescriptionSection(
										mie1,
										dataSource,
										"Evidence for Chemical Initiation of this Molecular Initiating Event",
										"Glu and glycine are endogenous agonists that bind to LBD of specific NMDA receptor subunits. In this binding site numerous competitive exogenous antagonists have been identified to cause closure of binding site and inhibition of NMDA receptor (reviewed in Traynelis et al., 2010). Here, are listed some known competitive antagonists for NMDA receptor, some of them are specific to NR1 subunit and some to NR2 subunit:\nα-AA, α-aminoadipate;\n5,7-DCKA, 5,7-dichlorokynurenic acid;\n7-CKA, 7-chlorokynurenic acid;\nACEA-1011, 5-chloro-7-trifluoromethyl-1,4-dihydro-2,3-quinoxalinedione;\nACEA-1021, licostinel;\nAP5, 2-amino-5-phosphonopentanoate;\nAP7, 2-amino-7-phosphonopentanoate;\nCGP-61594, (±)-trans-4-[2-(4-azidophyenyl)acetylamino]-5,7-dichloro-1,2,3,4-tetrahydroquinoline-2-carboxylic acid;\nCGP-40116, d-(E)-2-amino-4-methyl-5-phosphono-3-pentenoic acid;\nCGP-43487, d-(E)-2-amino-4-methyl-5-phosphono-3-pentenoic acid methyl ester;\nCGP-58411, 7-chloro-4-hydroxy-3-phenyl-1H-quinolin-2-one;\nCGS-19755, (2R,4S)-4-(phosphonomethyl)piperidine-2-carboxylic acid;\nCPP, 4-(3-phosphonopropyl) pizerazine-2-carboxylic acid;\nGV150,526A, gavestinel;\nGV196,771A, (E)-4,6-dichloro-3-[(2-oxo-1-phenyl-3-pyrrolidinylidene)methyl]-1H-indole-2-carboxylic acid;\nL-689,560, 4-trans-2-carboxy-5,7-dichloro-4-phenylaminocarbonylamino-1,2,3,4-tetrahydroquinoline;\nL-701,324, 7-chloro-4-hydroxy-3-(3-phenoxy)phenyl-2(1H)-quinolone;\nMDL105,519, (E)-3-(2-phenyl-2-carboxyethenyl)-4, 6-dichloro-1H-indole-2-carboxylic acid;\nPBPD, (2S,3R)-1-(biphenyl-4-carbonyl)piperazine-2,3-dicarboxylic acid;\nPMPA, (R,S)-4-(phosphonomethyl)-piperazine-2-carboxylic acid;\nPPDA, (2S,3R)-1-(phenanthren-2-carbonyl)piperazine-2,3-dicarboxylic acid\nBesides competitive antagonists, noncompetitive antagonists have also been designed like phenylethanolamine ifenprodil that interacts with the NR2B extracellular amino-terminal domain. It has been suggested that they act by stabilizing an agonist-bound state in which the receptor has a low open probability. Other more potent derivatives of ifenprodil are: α-(4-hydroxyphenyl)-β-methyl-4-(phenylmethyl)-1-piperidine propanol (Ro 25-6981), 1-[2-(4-hydroxy-phenoxy)-ethyl]-4-(4-methyl-benzyl)-piperidin-4-ol (Ro 63-1908), besonprodil (CI-1041), and traxoprodil mesylate (CP-101,606). Ethanol has been proposed to be a noncompetitive antagonist of NMDA receptors, binding to NR2 subunit (Nagy, 2008). Inhibition of NMDA receptor function by ethanol and interactions between ethanol and the noncompetitive NMDA receptor antagonist ifenprodil have been examined in neocortical neurons from rat and human embryonic kidney (HEK) 293 cells expressing recombinant NMDA receptors (Lovinger, 1995). Recently, a structural model has been suggested that predicts the presence of four sites of ethanol action on the NMDA receptor, each containing four pairs of positions in the NR1/NR2 subunits (reviewed in Chandrasekar, 2013). Some other antagonists can become trapped in the pore of the NMDA receptor after channel closure and these antagonists are called uncompetitive or trapping blockers. The most well studied NMDA receptor uncompetitive antagonists are Mg2+, polyamines, phencyclidine, ketamine, MK-801, memantine, amantadine, pentamidine, 9-tetrahydroaminoacridine, dextromethorphan, and its metabolite dextrorphan. MK-801 has been shown to prevent toluene-induced alterations in pattern-elicited visual-evoked potentials in vivo, suggesting the possibility that the binding site of toluene might be common with the one of MK-801 (Bale et al., 2007). However, another study suggests that toluene interference with the NMDA receptor might not be exclusively because of the binding to the channel pore (Smothers and Woodward, 2007) but it may involve some other binding sites. Lead (Pb2+) is considered a voltage independent antagonist of NMDA receptors and it is believed that possibly shares the same binding site with Zn2+ (reviewed in Neal and Guilarte, 2010; Traynelis et al., 2010). However, studies done in recombinant NR2A- and NR2B- containing NMDA receptors with mutated Zn2+ binding sites exhibit that additional structural elements, different from those important for Zn2+ binding are involved in Pb2+ binding site (reviewed in Neal and Guilarte, 2010). Similarly, there are contradicting experimental evidence and disagreement about Pb2+'s role as competitive or non-competitive antagonist (Neal and Guilarte, 2010).")
										.<DescriptionSection> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(mie1, dataSource,
										"Bale AS, Jackson MD, Krantz QT, Benignus VA, Bushnell PJ, Shafer TJ, Boyes WK. (2007) Evaluating the NMDA-glutamate receptor as a site of action for toluene, in vivo. Toxicol Sci. 98: 159-66.")
										.<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource, "Barria A, Malinow R. (2002) Subunit-specific NMDA receptor trafficking to synapses. Neuron 35: 345-353.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource, "Chandrasekar R. (2013) Alcohol and NMDA receptor: current research and future direction. Front Mol Neurosci. 6: 14.").<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Chtitaa S, Larifb M, Ghamalia M, Bouachrinec M, Lakhlifia T. (2015) DFT-based QSAR Studies of MK801 derivatives for non competitive antagonists of NMDA using electronic and topological descriptors. Journal of Taibah University for Science. 9: 143-154.")
										.<Reference> makeItLive());
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource,
								"Cohen S, Greenberg ME. (2008) Communication between the synapse and the nucleus in neuronal development, plasticity, and disease. Ann Rev Cell Dev Biol 24: 183-209.")
								.<Reference> makeItLive());
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource, "Eldefrawi ME, Anis NA, Eldefrawi AT. (1993) Glutamate receptor inhibitors as potential insecticides. Arch Insect Biochem Physiol. 22: 25-39.")
								.<Reference> makeItLive());
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource, "Ewald RC, Cline HT. (2009) Cloning and phylogentic analysis of NMDA receptor subunits NR1, NR2A and NR2B in Xenopus laevis tadpoles. Front Mol Neurosci. 2: 4.")
								.<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Flores-soto ME, Chaparro-Huerta V, Escoto-Delgadillo M, Vazuez-Valls E, Gonzalez-Castaneda RE, Beas-Zarate C. (2012) Structure and function of NMDA-type glutamate receptor subunits. Neurologia 27: 301-310.")
										.<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Gao L, Fang JS, Bai XY, Zhou D, Wang YT, Liu AL, Du GH. (2013) In silico Target Fishing for the Potential Targets and Molecular Mechanisms of Baicalein as an Antiparkinsonian Agent: Discovery of the Protective Effects on NMDA Receptor-Mediated Neurotoxicity. Chem Biol Drug Des. 81: 675-87.")
										.<Reference> makeItLive());
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource, "Koo JCP, Hampson DR. (2010) Phylogenic and evolutionary analysis of glutamate receptor based on extant invertebrate genes. JULS 1: 42-48.")
								.<Reference> makeItLive());
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource,
								"Korkut A, Varnali T. (2003) Quantitative structure activity relationship (QSAR) of competitive N-methyl-D-aspartate (NMDA) antagonists. Mol Phys 101: 3285-3291.").<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Koutsoukas A, Simms B, Kirchmair J, Bond PJ, Whitmore AV, Zimmer S, Young MP, Jenkins JL, Glick M, Glen RC, Bender A. (2011) From in silico target prediction to multi-target drug design: current databases, methods and applications. J Proteomics 74: 2554-2574.")
										.<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Lovinger DM. (1995) Developmental decrease in ethanol inhibition of N-methyl-D-aspartate receptors in rat neocortical neurons: relation to the actions of ifenprodil. J Pharmacol Exp Ther. 274: 164-172.")
										.<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Mazumder MK, Borah A (2014) Piroxicam inhibits NMDA receptor-mediated excitotoxicity through allosteric inhibition of the GluN2B subunit: An in silico study elucidating a novel mechanism of action of the drug. Medical Hypotheses 83: 740–746.")
										.<Reference> makeItLive());
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource, "Nagy J. (2008) Alcohol related changes in regulation of NMDA receptor functions. Curr Neuropharmacol 6: 39-54.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource, "Neal AP, Guilarte TR. (2010) Molecular Neurobiology of Lead (Pb2+): Effects on Synaptic Function. Mol Neurobiol. 42: 151-160.").<Reference> makeItLive());
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource,
								"Nihei MK, Guilarte TR. (1999) NMDAR-2A subunit protein expression is reduced in the hippocampus of rats exposed to Pb2+ during development. Brain Res Mol Brain Res. 66: 42-49.")
								.<Reference> makeItLive());
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource,
								"Reynolds IJ. (2001) [3H](+)MK801 radioligand binding assay at the N-methyl-D-aspartate receptor. Curr Protoc Pharmacol. Chapter 1:Unit 1.20. doi: 10.1002/0471141755.ph0120s11.")
								.<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Scheuhammer AM, Basu N, Burgess NM, Elliott JE, Campbell GD, Wayland M, Champoux L, Rodrigue J. (2008) Relationships among mercury, selenium, and neurochemical parameters in common loons (Gavia immer) and bald eagles (Haliaeetus leucocephalus). Ecotoxicology 17: 93-101.")
										.<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Slater P, McConnell SE, D'Souza SW, Barson AJ. (1993) Postnatal changes in N-methyl-D-aspartate receptor binding and stimulation by glutamate and glycine of [3H]-MK-801 binding in human temporal cortex. Br J Pharmacol. 108: 1143-1149.")
										.<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Smothers CT, Woodward JJ. (2007) Pharmacological characterization of glycine-activated currents in HEK 293 cells expressing N-methyl-d-aspartate NR1 and NR3 subunits. J Pharmacol Exp Ther. 322: 739-748.")
										.<Reference> makeItLive());
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource,
								"Teng H, Cai W, Zhou L, Zhang J, Liu Q, Wang Y, et al. (2010) Evolutionary mode of functional divergence of vertebrate NMDA receptor subunit 2 Genes. PLoS ONE. 5(10): e13342.")
								.<Reference> makeItLive());
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource, "Tikhonov DB, Magazanik LG. (2009) Origin and molecular evolution of ionotropic glutamate receptors. Neurosci Behav Physiol. 39: 763-772.")
								.<Reference> makeItLive());
				mie1.getReferenceIDs().add(
						new Reference(mie1, dataSource,
								"Tovar KR, Westbrook GL. (1999) The incorporation of NMDA receptors with a distinct subunit composition at nascent hippocampal synapses in vitro. J Neurosci. 19: 4180–4188.")
								.<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Traynelis S, Wollmuth LP, McBain CJ, Menniti FS, Vance KM, Ogden KK, Hansen KB, Yuan H, Myers SJ, Dingledine R. (2010) Glutamate receptor ion channels: structure, regulation, and function. Pharmacol Rev. 62: 405-496.")
										.<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Woodruff GN, Foster AC, Gill R, Kemp JA, Wong EH, Iversen LL. (1987) The interaction between MK-801 and receptors for N-methyl-D-aspartate: functional consequences. Neuropharmacology 26(7B): 903-909.")
										.<Reference> makeItLive());
				mie1
						.getReferenceIDs()
						.add(
								new Reference(
										mie1,
										dataSource,
										"Xia S, Chiang AS. (2009) NMDA Receptors in Drosophila. In: Van Dongen AM, editor. Biology of the NMDA Receptor. Boca Raton (FL): CRC Press; Chapter 10. Available from: http://www.ncbi.nlm.nih.gov/books/NBK5286/")
										.<Reference> makeItLive());
				
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie1);
				
				molecular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				molecular_effect1.setTitle("NMDARs, Inhibition");
				molecular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				molecular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				molecular_effect1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										molecular_effect1,
										dataSource,
										"Definition",
										"<html><b>Biological state:</b> L-glutamate (Glu) is a neurotransmitter with important role in the regulation of brain development and maturation processes. Two major classes of Glu receptors, ionotropic and metabotropic, have been identified. Due to its physiological and pharmacological properties, Glu activates three classes of ionotropic receptors named: α-amino-3-hydroxy-5-methyl-4-isoazolepropionic acid (AMPA receptors), 2-carboxy-3-carboxymethyl-4-isopropenylpyrrolidine (kainate receptors) and N-methyl-D-aspartate (NMDA receptors, NMDARs), which transduce the postsynaptic signal. Ionotropic glutamate receptors are integral membrane proteins formed by four large subunits that compose a central ion channel pore. In case of NMDA receptors, two NR1 subunits are combined with either two NR2 (NR2A, NR2B, NR2C, NR2D) subunits and less commonly are assembled together with a combination of NR2 and NR3 (A, B) subunits (reviewed in Traynelis et al., 2010). To be activated NMDA receptors require simultaneous binding of both glutamate to NR2 subunits and of glycine to either NR1 or NR3 subunits that provide the specific binding sites named extracellular ligand-binding domains (LBDs). Apart from LBDs, NMDA receptor subunits contain three more domains that are considered semiautonomous: 1) the extracellular amino-terminal domain that plays important role in assembly and trafficking of these receptors; 2) the transmembrane domain that is linked with LBD and contributes to the formation of the core of the ion channel and 3) the intracellular carboxyl-terminal domain that influences membrane targeting, stabilization, degradation and post-translation modifications.<br><br><b>Biological compartments:</b> The genes of the NMDAR subunits are expressed in various tissues and are not only restricted to the nervous system. The level of expression of these receptors in neuronal and non-neuronal cells depends on: transcription, chromatin remodelling, mRNA levels, translation, stabilization of the protein, receptor assembly and trafficking, energy metabolism and numerous environmental stimuli (reviewed in Traynelis et al., 2010).<br><br>In hippocampus region of the brain, NR2A and NR2B are the most abundant NR2 family subunits. NR2A-containing NMDARs are mostly expressed synaptically, while NR2B-containing NMDARs are found both synaptically and extrasynaptically (Tovar and Westbrook, 1999).<br><br><b>General role in biology:</b> NMDA receptors, when compared to the other Glu receptors, are characterized by higher affinity for Glu, slower activation and desensitisation kinetics, higher permeability for calcium (Ca2+) and susceptibility to potential-dependent blockage by magnesium ions (Mg2+). NMDA receptors are involved in fast excitatory synaptic transmission and neuronal plasticity in the central nervous system (CNS). Functions of NMDA receptors:<br><br>1. They are involved in cell signalling events converting environmental stimuli to genetic changes by regulating gene transcription and epigenetic modifications in neuronal cells (Cohen and Greenberg, 2008).<br><br>2. In NMDA receptors, the ion channel is blocked by extracellular Mg2+ and Zn2+ ions, allowing the flow of Na+ and Ca2+ ions into the cell and K+ out of the cell which is voltage-dependent. Ca2+ flux through the NMDA receptor is considered to play a critical role in pre- and post-synaptic plasticity, a cellular mechanism important for learning and memory (Barria and Malinow, 2002).<br><br>3. The NMDA receptors have been shown to play an essential role in the strengthening of synapses and neuronal differentiation, through long-term potentiation (LTP), and the weakening of synapses, through long-term depression (LTD). All these processes are implicated in the memory and learning function (Barria and Malinow, 2002).<br><br><html>")
										.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 0);
				molecular_effect1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										molecular_effect1,
										dataSource,
										"Measurment/detection",
										"<html><i>Methods that have been previously reviewed and approved by a recognized authority should be included in the Overview section above. All other methods, including those well established in the published literature, should be described here. Consider the following criteria when describing each method: 1. Is the assay fit for purpose? 2. Is the assay directly or indirectly (i.e. a surrogate) related to a key event relevant to the final adverse effect in question? 3. Is the assay repeatable? 4. Is the assay reproducible?</i><br><br>No OECD methods are available to measure the activation state of NMDA receptors.<br><br>The measurement of the activation or the inhibition of NMDA receptors is done indirectly by recording the individual ion channels that are selective to Na+, K+ and Ca+2 by the patch clamp technique. This method relies on lack of measurable ion flux when NMDA ion channel is closed, whereas constant channel specific conductance is recorded at the open state of the receptor (Blanke and VanDongen, 2009). Furthermore, this method is based on the prediction that activation or inhibition of an ion channel results from an increase in the probability of being in the open or close state, respectively.<br><br>The whole-cell patch clamp recording techniques have also been used to study synaptically-evoked NMDA receptor-mediated excitatory or inhibitory postsynaptic currents (EPSCs and IPSCs, respectively) in brain slices and neuronal cells, allowing the evaluation of the activated or inhibited state of the receptor (Ogdon and Stanfield, 2009; Zhao et al., 2009).<br><br>Microelectrode array (MEA) recordings are used to measure electrical activity in cultured neurons in response to NMDA receptor activation or inactivation (Keefer et al., 2001, Gramowski et al., 2000 and Gopal, 2003; Johnstone et al., 2010). MEAs can also be applied in higher throughput platforms to facilitate screening of numerous chemical compounds based on electrical activity measurements (McConnell et al., 2012).</html>")
										.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 1);
				molecular_effect1
						.getDescriptionIDs()
						.add(
								new DescriptionSection(
										molecular_effect1,
										dataSource,
										"Evidence Supporting Taxonomic Applicability",
										"The cellular expression of the NMDAR subunits has been studied in both adult human cortex and hippocampus (Scherzer et al., 1998) as well as during the development of the human hippocampal formation (Law et al., 2003). The whole-cell patch clamp recording techniques have been used in NMDA receptors expressed in human TsA cells (derivative of the human embryonic kidney cell line HEK-293) (Ludolph et al., 2010). Cell-attached single-channel recordings of NMDA channels has been carried out in human dentate gyrus granule cells acutely dissociated from slices prepared from hippocampi surgically removed from human patients (Lieberman and Mody, 1999).\nIt is important to note that in invertebrates the glutamatergic synaptic transmission has inhibitory and not excitatory role like in vertebrates. This type of neurotransmission is mediated by glutamate-gated chloride channels that are members of the ‘cys-loop’ ligand-gated anion channel superfamily found only in invertebrates. The subunits of glutamate-activated chloride channel have been isolated from C. elegans and from Drosophila (Blanke and VanDongen, 2009).")
										.<DescriptionSection> makeItLive());
				molecular_effect1.getReferenceIDs().add(
						new Reference(molecular_effect1, dataSource, "Barria A, Malinow R. (2002) Subunit-specific NMDA receptor trafficking to synapses. Neuron 35: 345-353.").<Reference> makeItLive());
				molecular_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										molecular_effect1,
										dataSource,
										"Blanke ML, VanDongen AMJ. (2009) Activation Mechanisms of the NMDA Receptor. In: Van Dongen AM, editor. Biology of the NMDA Receptor. Boca Raton (FL): CRC Press; Chapter 13. Available from: http://www.ncbi.nlm.nih.gov/books/NBK5274/")
										.<Reference> makeItLive());
				molecular_effect1.getReferenceIDs().add(
						new Reference(molecular_effect1, dataSource,
								"Cohen S, Greenberg ME. (2008) Communication between the synapse and the nucleus in neuronal development, plasticity, and disease. Ann Rev Cell Dev Biol 24: 183-209.")
								.<Reference> makeItLive());
				molecular_effect1.getReferenceIDs().add(
						new Reference(molecular_effect1, dataSource,
								"Gopal K. (2003) Neurotoxic effects of mercury on auditory cortex networks growing on microelectrode arrays: a preliminary analysis. Neurotoxicol Teratol. 25: 69-76.")
								.<Reference> makeItLive());
				molecular_effect1
						.getReferenceIDs()
						.add(
								new Reference(molecular_effect1, dataSource,
										"Gramowski A, Schiffmann D, Gross GW. (2000) Quantification of acute neurotoxic effects of trimethyltin using neuronal networks cultures on microelectrode arrays. Neurotoxicology 21: 331-342.")
										.<Reference> makeItLive());
				molecular_effect1.getReferenceIDs().add(
						new Reference(molecular_effect1, dataSource,
								"Johnstone AFM, Gross GW, Weiss D, Schroeder O, Shafer TJ. (2010). Use of microelectrode arrays for neurotoxicity testing in the 21st century Neurotoxicology 31: 331-350.")
								.<Reference> makeItLive());
				molecular_effect1.getReferenceIDs().add(
						new Reference(molecular_effect1, dataSource,
								"Keefer E, Norton S, Boyle N, Talesa V, Gross G. (2001) Acute toxicity screening of novel AChE inhibitors using neuronal networks on microelectrode arrays. Neurotoxicology 22: 3-12.")
								.<Reference> makeItLive());
				molecular_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										molecular_effect1,
										dataSource,
										"Law AJ, Weickert CS, Webster MJ, Herman MM, Kleinman JE, Harrison PJ. (2003) Expression of NMDA receptor NR1, NR2A and NR2B subunit mRNAs during development of the human hippocampal formation. Eur J Neurosci. 18: 1197-1205.")
										.<Reference> makeItLive());
				molecular_effect1.getReferenceIDs().add(
						new Reference(molecular_effect1, dataSource, "Lieberman DN, Mody I. (1999) Properties of single NMDA receptor channels in human dentate gyrus granule cells. J Physiol. 518: 55-70.")
								.<Reference> makeItLive());
				molecular_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										molecular_effect1,
										dataSource,
										"Ludolph AG, Udvardi PT, Schaz U, Henes C, Adolph O, Weigt HU, Fegert JM, Boeckers TM, Föhr KJ. (2010) Atomoxetine acts as an NMDA receptor blocker in clinically relevant concentrations. Br J Pharmacol. 160: 283-291.")
										.<Reference> makeItLive());
				molecular_effect1
						.getReferenceIDs()
						.add(
								new Reference(molecular_effect1, dataSource,
										"McConnell ER, McClain MA, Ross J, LeFew WR, Shafer TJ (2012). Evaluation of multi-well microelectrode arrays for neurotoxicity screening using a chemical training set Neurotoxicology 33: 1048-1057.")
										.<Reference> makeItLive());
				molecular_effect1
						.getReferenceIDs()
						.add(
								new Reference(molecular_effect1, dataSource,
										"Ogdon D, Stanfield P. (2009) Patch clamp techniques for single channel and whole-cell recording. Chapter 4, pages 53-78. http://www.utdallas.edu/~tres/microelectrode/microelectrodes_ch04.pdf")
										.<Reference> makeItLive());
				molecular_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										molecular_effect1,
										dataSource,
										"Scherzer CR, Landwehrmeyer GB, Kerner JA, Counihan TJ, Kosinski CM, Standaert DG, Daggett LP, Veliçelebi G, Penney JB, Young AB. (1998) Expression of N-methyl-D-aspartate receptor subunit mRNAs in the human brain: hippocampus and cortex. J Comp Neurol. 390: 75-90.")
										.<Reference> makeItLive());
				molecular_effect1.getReferenceIDs().add(
						new Reference(molecular_effect1, dataSource,
								"Tovar KR, Westbrook GL. (1999) The incorporation of NMDA receptors with a distinct subunit composition at nascent hippocampal synapses in vitro. J Neurosci. 19: 4180–4188.")
								.<Reference> makeItLive());
				molecular_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										molecular_effect1,
										dataSource,
										"Traynelis S, Wollmuth LP, McBain CJ, Menniti FS, Vance KM, Ogden KK, Hansen KB, Yuan H, Myers SJ, Dingledine R. (2010) Glutamate receptor ion channels: structure, regulation, and function. Pharmacol Rev. 62: 405-496.")
										.<Reference> makeItLive());
				molecular_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										molecular_effect1,
										dataSource,
										"Zhao Y, Inayat S, Dikin DA, Singer JH, Ruoff RS, Troy JB. (2009) Patch clamp technique: review of the current state of the art and potential contributions from Nanoengineering. Proc. IMechE 222, Part N: J. Nanoengineering and Nanosystems 149. DOI: 10.1243/17403499JNN149")
										.<Reference> makeItLive());
				
				link_mie1_me1 = new Link_EffectToEffect(pathway, dataSource, mie1, molecular_effect1);
				link_mie1_me1.setLinkType(LinkType.DIRECT);
				ReferenceIDW<Link_EffectToEffect> wight = new ReferenceIDW<Link_EffectToEffect>(link_mie1_me1, dataSource, Link_EffectToEffect.class, 3.0D);
				link_mie1_me1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										link_mie1_me1,
										dataSource,
										"Definition",
										"<html>It is well documented that prolonged/chronic antagonism of NMDARs triggers the downstream KE named inhibition of NMDARs. Shorter term binding to the same receptors may trigger different downstream KEs, such as up-regulation of the NMDARs, resulting in toxic increased influx of calcium and to cell death. Consequently, this information can be captured in other KERs and AOP.</html>")
										.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 0);
				link_mie1_me1
						.getDescriptionIDs()
						.set(
								new DescriptionSection_Structured(
										link_mie1_me1,
										dataSource,
										"(Key) Event Relationship Weight of Evidence",
										"<html><h3><b>Biological Plausibility</b></h3>There is structural mechanistic understanding supporting the relationship between MIE (NMDARs, binding of antagonists) and KE (NMDARs, inhibition). Crystal structure studies are used to study the binding of antagonists/agonists to NMDA receptors. In case of NMDAR antagonists, the binding to the receptor causes LBD conformation changes which promote channel closure leading to reduced Ca+2 influx (Blanke and VanDongen, 2009). This lack of measurable ion flux is applied as an indication of NMDAR inhibition.<br><h3><b>Empirical Support for Linkage</b></h3><i>Include consideration of temporal concordance here</i><br><br>In slices of cerebellum derived from postnatal days 6-30 (PND 6-30) Sprague Dawley rats, 10 µM MK-801 completely blocked evoked NMDA excitatory postsynaptic currents (EPSCs) as it has been demonstrated by patch clamp technique (Rumbaugh and Vicini, 1999). The same technique has been employed in cortical slices from C57BL/6 mice of both genders and different age groups (P8-12, P21-28 or P45-90), showing that 1 µM APV and 50 nM NVP-AAM077 antagonise a similar amount of NMDA receptor current independently of the age (de Marchena et al., 2008).<br><br>Pb2+ has potent inhibitory effects on the NMDA receptor (Alkondon et al., 1990; Guilarte and Miceli, 1992; Guilarte, 1997; Gavazzo et al., 2001). In rat hippocampal neurons, Pb2+ (2.5-50 μM) inhibits NMDA-induced whole-cell and single-channel currents in a concentration-dependent manner, suggesting that Pb2+ can decrease the frequency of NMDA-induced channel activation (Alkondon et al., 1990). In the same study, they have examined the effect of Pb2+ on the binding of [3H]MK-801 to the rat brain hippocampal membranes and showed that Pb2+ inhibits the binding of [3H]-MK-801 in a concentration dependent manner with an IC50 value close to 7 µM (Alkondon et al., 1990). These inhibitory effects of Pb2+ on NMDA receptors activation appear to be age and brain region specific (Guilarte, 1997; Guilarte and Miceli, 1992). The Pb2+ IC50 is significantly lower in cortical membranes prepared from neonatal than from adult rats, whereas the hippocampus is more sensitive than the cerebral cortex since the Pb2+ IC50 is significantly lower in the hippocampus (Guilarte and Miceli, 1992). The number of [3H]-MK-801 binding sites associated with the high and low affinity sites of Pb2+ inhibition in the hippocampus of rats is increased as a function of age, peaking at PND 28 and 21 (Guilarte, 1997). High and low affinity Pb(2+)-sensitive [3H]-MK-801 binding sites have also been measured in the cerebral cortex during early development, but that has not been possible to evaluate after PND 14.<br><br>The developing brain is more sensitive than the adult brain to Pb2+-induced effects mediated through the NMDA receptor. Moreover, the hippocampus appears to be particularly vulnerable as in this brain structure NMDA receptors undergo subunit specific changes during developmental Pb2+ exposure (Guilarte and McGlothan, 1998). Exposure to Pb2+ during synaptogenesis causes decreased expression of hippocampal NR2A-subunit of NMDARs at synapses and increased targeting of NR2B-NMDARs to dendritic spines (without increased NR2B-NMDARs expression) (Nihei and Guilarte, 1999; Neal et al., 2011; Zhang et al., 2002).<br><br><h3><b>Uncertainties or Inconsistencies</b></h3>Pb2+ has been found to produce either potentiation or inhibition depending on: a) the subunit composition of NMDA receptors, b) endogenous glutamate concentration and c) Pb2+ dosage. In case that the NMDA receptors are saturated by agonist, Pb2+ at low concentrations (<1 µM) acts as a positive modulator of agonist action at NR1b-2AC and NR1a-2AB subunit complexes, whereas at higher concentrations, Pb2+ it behaves as a potent inhibitor of all recombinant NMDA receptors tested and was least potent at NR1b-2AC (Omelchenko et al., 1996; 1997), meaning that Pb2+ is not always acting as NMDAR inhibitor but it can also behave as NMDAR activator under certain conditions.<br><br><html>",
										wight).setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(),1);
				link_mie1_me1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										link_mie1_me1,
										dataSource,
										"Quantitative Understanding of the Linkage",
										"<html><i>Is it known how much change in the first event is needed to impact the second? Are there known modulators of the response-response relationships? Are there models or extrapolation approaches that help describe those relationships?</i><br><br>To predict how potent an antagonist can be, the half maximal inhibition concentrations (IC50) and the half maximal effective concentration (EC50) of glutamate/glycine induced currents is measured in NMDA receptors from brain slices and cells or in recombinantly expressed receptors. Traynelis et al. 2010 summarised the IC50 values for competitive, noncompetitive and uncompetitive antagonists in different subunits of NMDA receptors. The inhibitory effect (efficacy) of antagonists on NMDA receptors has been found to be dependent on:<br><br>-the type of subunits that form the NMDA receptors depending on the developmental stage -the chemical structure of the antagonists<br><br><br><br>-the binding site of receptor that the antagonists prefer<br><br>-how tightly an antagonist binds to the receptor (affinity)<br><br>At CA3-CA1 synapses, NMDARs are largely composed of NR1 (NMDA receptor subunit 1)-NR2A or NR1-NR2B containing subunits. Recent, but controversial, evidence has correlated NR1-NR2A receptors with the induction of LTP and NR1-NR2B receptors with LTD. However, LTP can be induced by activation of either subtype of NMDAR and the ratio of NR2A:NR2B receptors has been proposed as an alternative determinant of the direction of synaptic plasticity (Mac Donald et al., 2006).<br><br><b>Pb2+:</b> Although the NR2 subunits have different Zn2+ binding sites i.e. the NR2A-NMDAR binds Zn2+ at a high-affinity site (nM affinity) while the NR2B-NMDAR binds Zn2+ with lower affinity (µM range); the Pb2+ IC50 for wild type NR2A-NMDARs was reported to be 1.3 µM, while the Pb2+ IC50 of wild type NR2B-NMDARs was 1.2 µM (Gavazzo et al., 2008). Similar findings were published by Lasley and Gilbert (1999) using cortical neurons from adult rats. The IC50 for Pb2+ ranged from 1.52 to 4.86 µM, with the ranking of Pb2+ potency in inhibition of NMDA receptor subunits to be NR1b-2A>NR1b-2C>NR1b-2D>NR1b-2AC after experiments that have been conducted in Xenopus oocytes injected with cRNAs for different combinations of NMDA receptor subunits (Omelchenko et al., 1997).</html>")
										.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(),2);
				link_mie1_me1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										link_mie1_me1,
										dataSource,
										"Evidence Supporting Taxonomic Applicability",
										"The biophysical properties of rat and human receptors have been mostly assessed through recombinant studies, whereas the pharmacological properties of rat and human NMDA receptors have not been fully explored and compared yet (Hedegaard et al., 2012). Mean channel open times for human NMDA receptor subtypes in recombinant protein studies are similar to those of the corresponding rat NMDA receptor subtypes. However, mean single-channel conductances for human NMDA receptor subtypes appear lower than those of the corresponding rat NMDA receptor subtypes. Regarding pharmacological properties of the receptors, the differences were less than 2-fold and were not observed at the same subtypes for all the antagonists tested, suggesting that the molecular pharmacology of NMDA receptor is conserved between human and rat, although some inter-species differences are seen in IC50 values using two-electrode voltage-clamp recordings (Hedegaard et al., 2012),")
										.<DescriptionSection> makeItLive(),3);
				
				link_mie1_me1
						.getReferenceIDs()
						.add(
								new Reference(
										link_mie1_me1,
										dataSource,
										"Alkondon M, Costa AC, Radhakrishnan V, Aronstam RS, Albuquerque EX. (1990) Selective blockade of NMDA-activated channel currents may be implicated in learning deficits caused by lead. FEBS Lett. 261: 124-130.")
										.<Reference> makeItLive());
				link_mie1_me1
						.getReferenceIDs()
						.add(
								new Reference(
										link_mie1_me1,
										dataSource,
										"Blanke ML, VanDongen AMJ. (2009) Activation Mechanisms of the NMDA Receptor. In: Van Dongen AM, editor. Biology of the NMDA Receptor. Boca Raton (FL): CRC Press; Chapter 13. Available from: http://www.ncbi.nlm.nih.gov/books/NBK5274/")
										.<Reference> makeItLive());
				link_mie1_me1
						.getReferenceIDs()
						.add(
								new Reference(
										link_mie1_me1,
										dataSource,
										"de Marchena J, Roberts AC, Middlebrooks PG, Valakh V, Yashiro K, Wilfley LR, Philpot BD. (2008) NMDA receptor antagonists reveal age-dependent differences in the properties of visual cortical plasticity. J Neurophysiol. 100: 1936-1948.")
										.<Reference> makeItLive());
				link_mie1_me1.getReferenceIDs().add(
						new Reference(link_mie1_me1, dataSource,
								"Gavazzo P, Gazzoli A, Mazzolini M, Marchetti C. (2001) Lead inhibition of NMDA channels in native and recombinant receptors. NeuroReport. 12: 3121-3125.").<Reference> makeItLive());
				link_mie1_me1.getReferenceIDs().add(
						new Reference(link_mie1_me1, dataSource,
								"Gavazzo P, Zanardi I, Baranowska-Bosiacka I, Marchetti C. (2008) Molecular determinants of Pb2+ interaction with NMDA receptor channels. Neurochem Int. 52: 329-337.")
								.<Reference> makeItLive());
				link_mie1_me1.getReferenceIDs().add(
						new Reference(link_mie1_me1, dataSource,
								"Guilarte TR, Miceli RC. (1992) Age-dependent effects of lead on [3H]-MK-801 binding to the NMDA receptor-gated ionophore: In vitro and in vivo studies. Neurosci Lett. 148: 27-30.")
								.<Reference> makeItLive());
				link_mie1_me1.getReferenceIDs().add(
						new Reference(link_mie1_me1, dataSource,
								"Guilarte TR. (1997) Pb2+ Inhibits Nmda Receptor Function at High and Low Affinity Sites: Developmental and Regional Brain Expression. Neurotoxicology 18: 43-51.").<Reference> makeItLive());
				link_mie1_me1.getReferenceIDs().add(
						new Reference(link_mie1_me1, dataSource,
								"Guilarte TR, McGlothan JL. (1998) Hippocampal Nmda Receptor Mrna Undergoes Subunit Specific Changes During Developmental Lead Exposure. Brain Res. 790: 98-107.").<Reference> makeItLive());
				link_mie1_me1.getReferenceIDs().add(
						new Reference(link_mie1_me1, dataSource,
								"Hedegaard MK, Hansen KB, Andersen KT, Bräuner-Osborne H, Traynelis SF. (2012) Molecular pharmacology of human NMDA receptors. Neurochem Int. 61: 601-609.").<Reference> makeItLive());
				link_mie1_me1.getReferenceIDs().add(
						new Reference(link_mie1_me1, dataSource,
								"Lasley SM, Gilbert ME. (1999) Lead inhibits the rat N-methyl-d-aspartate receptor channel by binding to a site distinct from the zinc allosteric site. Toxicol Appl Pharmacol. 159: 224-233.")
								.<Reference> makeItLive());
				link_mie1_me1.getReferenceIDs().add(
						new Reference(link_mie1_me1, dataSource,
								"MacDonald JF, Jackson MF, Beazely MA. (2006) Hippocampal long-term synaptic plasticity and signal amplification of NMDA receptors. Crit Rev Neurobiol. 18: 71-84.").<Reference> makeItLive());
				link_mie1_me1.getReferenceIDs().add(
						new Reference(link_mie1_me1, dataSource,
								"Neal AP, Worley PF, Guilarte TR. (2011) Lead exposure during synaptogenesis alters NMDA receptor targeting via NMDA receptor inhibition. Neurotoxicology 32: 281-289.")
								.<Reference> makeItLive());
				link_mie1_me1
						.getReferenceIDs()
						.add(
								new Reference(
										link_mie1_me1,
										dataSource,
										"Omelchenko IA, Nelson CS, Marino JL., Allen CN. (1996). The sensitivity of N-methyl-d-aspartate receptors to lead inhibition is dependent on the receptor subunit composition. J Pharmacol Exp Ther. 278: 15-20.")
										.<Reference> makeItLive());
				link_mie1_me1.getReferenceIDs().add(
						new Reference(link_mie1_me1, dataSource,
								"Omelchenko IA, Nelson CS, Allen CN. (1997) Lead inhibition of N-Methyl-D-aspartate receptors containing NR2A, NR2C and NR2D subunits. J Pharmacol Exp Ther. 282: 1458-1464.")
								.<Reference> makeItLive());
				link_mie1_me1.getReferenceIDs().add(
						new Reference(link_mie1_me1, dataSource, "Rumbaugh G, Vicini S. (1999) Distinct Synaptic and Extrasynaptic NMDA Receptors in Developing Cerebellar Granule Neurons. J Neurosc. 19: 10603-10610.")
								.<Reference> makeItLive());
				link_mie1_me1
						.getReferenceIDs()
						.add(
								new Reference(
										link_mie1_me1,
										dataSource,
										"Traynelis S, Wollmuth LP, McBain CJ, Menniti FS, Vance KM, Ogden KK, Hansen KB, Yuan H, Myers SJ, Dingledine R. (2010) Glutamate receptor ion channels: structure, regulation, and function. Pharmacol Rev. 62: 405-496.")
										.<Reference> makeItLive());
				link_mie1_me1
						.getReferenceIDs()
						.add(
								new Reference(
										link_mie1_me1,
										dataSource,
										"Zhang XY, Liu AP, Ruan DY, Liu J. (2002) Effect of developmental lead exposure on the expression of specific NMDA receptor subunit mRNAs in the hippocampus of neonatal rats by digoxigenin-labeled in situ hybridization histochemistry. Neurotox Teratol 24: 149-160.")
										.<Reference> makeItLive());
				
				cellular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect1.setTitle("Calcium influx, Decreased");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				cellular_effect1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										cellular_effect1,
										dataSource,
										"Definition",
										"<html><b>Biological state:</b> Under physiological resting conditions of the cell, the free intracellular Ca2+ reaches around 100 nM, whereas the extracellular Ca2+ can be found at higher concentrations of 1.2 mM that under certain stimulus may invade the cell (Berridge et al, 2000). Six to seven oxygen atoms surround Ca2+, whereas the protein chelator of Ca2+ is the EF motif that is present in many proteins such as calmodulin (Clapham, 2007). The EF-hand is a helix-loop-helix calcium-binding motif in which two helices pack together at an angle of approximately 90 degrees (Lewit-Bentley and Réty, 2000). The two helices are separated by a loop region where calcium actually binds. The EF notation for the motif is derived from the notation applied to the structure of parvalbumin, in which the E and F helices were originally identified as forming this calcium-binding motif.<br><br><b>Biological compartments:</b> Ca2+ ions accumulate in the cytoplasm, cellular organelles (e.g. mitochondria and endoplasmic reticulum) and nucleus in response to diverse classes of stimuli.<br><br><b>General role in biology:</b> In order to adapt to altered stimulus from exposure to different environmental factors, cells require signal transmission. However, signalling needs messengers whose concentration is modified upon stimulus (Clapham, 2007). Ca2+ ions act as an important intracellular messenger playing the role of ubiquitous signalling molecules and consequently regulate many different cellular functions (Berridge, 2012; Hagenston and Bading, 2011). Given its important role in processes that are fundamental to all cell types, Ca2+ homeostasis is tightly regulated by intracellular and extracellular mechanisms (Barhoumi et al., 2010). Intracellular Ca2+ concentration is regulated by opening or closing channels in the plasma membrane. Additionally, the Ca2+ ions can be released from intracellular stores of the endoplasmic reticulum (ER) through ryanodine receptors (RYRs) or inositol 1,4,5-trisphosphate receptors (InsP3Rs). Ca2+ homeostasis is also regulated by the mechanisms that remove Ca2+ from the cytosol, for example pumps in both cell membrane and ER membrane. In addition, cytosolic Ca2+ regulation involves accumulation of Ca2+ in mitochondria that have the capacity to buffer the excess of cytoplasmic Ca2+ ions. In neurons, Ca2+ ions regulate many critical functions. Firstly, they contribute to dendritic electrical signalling, producing postsynaptic depolarization by the current carried by Ca2+ ions. Secondly, Ca2+ activates Ca2+-sensitive proteins such as different kinases, calcineurin and calpain, triggering signalling pathways critical for cell physiology. Modification of the gene transcription is the final outcome of the Ca2+ ions impact on long-term modifications affecting neurotransmitters release (reviewed in Neher and Sakaba, 2008), neuronal differentiation, synapse function and cell viability (Clapham, 2007; Higley and Sabatini, 2012). Thus, the Ca2+ that enters and accumulates in cytoplasm and nucleus is a central signalling molecule that regulates synapse and neuronal cell function, including learning and memory processes (Berridge, 2012; Hagenston and Bading, 2011).<html>")
										.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 0);
				cellular_effect1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										cellular_effect1,
										dataSource,
										"Measurment/detection",
										"<html><i>Methods that have been previously reviewed and approved by a recognized authority should be included in the Overview section above. All other methods, including those well established in the published literature, should be described here. Consider the following criteria when describing each method: 1. Is the assay fit for purpose? 2. Is the assay directly or indirectly (i.e. a surrogate) related to a key event relevant to the final adverse effect in question? 3. Is the assay repeatable? 4. Is the assay reproducible?</i><br><br>Methods that have been previously reviewed and approved by a recognized authority should be included in the Overview section above. All other methods, including those well established in the published literature, should be described here. Consider the following criteria when describing each method: 1. Is the assay fit for purpose? 2. Is the assay directly or indirectly (i.e. a surrogate) related to a key event relevant to the final adverse effect in question? 3. Is the assay repeatable? 4. Is the assay reproducible?No OECD method is available to measure intracellular Ca2+.<br><br>The gold standard method for measuring Ca2+ current through NMDA receptor is patch clamp electrophysiology (Blanke and VanDongen, 2009).<br><br>In vitro, well-established flow cytometric or high content imaging analysis with specific fluorescent dyes (Ca2+-sensitive fluorophores) such as Fura-2, Oregon Green-BAPTA, Fluo-4 and X-Rhod exist for determination of intracellular Ca2+ concentration. The use of different fluorometric calcium indicators in neuroscience and neurotoxicology have been recently reviewed by Grienberger and Konnerth (2012) and Calvo et al (2015).<br><br>Barhoumi et al. 2010 summarised all the methods to measure cytosolic Ca2+ alterations due to exposure to neurotoxic compounds, including steady state, short-term kinetic measurements of stimulated Ca2+ transients and dynamic measurements. This paper further discusses the strengths and weaknesses of each approach in intracellular Ca2+ measurements and its applicability in high throughput screening.<br><br>For quantitative estimation of Ca2+ in dendritic spines, besides of Ca2+-sensitive fluorophores the use of two-photon released caged neurotransmitters has been suggested as it allows direct stimulation of visualized spines (Higley and Sabatini, 2012). In Higley and Sabatini 2012 further technical information can be found in relation to study Ca2+ in dendritic spines.<br><br>Furthermore, there are three methods for measuring Ca2+ influx in NMDA receptors that involve the measurement of 1) relative Ca2+ permeability, 2) channel blockage by Ca2+, and 3) fractional Ca2+ currents from whole-cell currents determined in the presence of high concentrations of intracellular Fura-2 (Traynelis et al., 2010).<br><br>In vivo, two-photon Ca2+ imaging using Ca2+-sensitive fluorescent indicators that measure changes in intracellular Ca2+ concentration as a readout for suprathreshold and subthreshold neuronal activity has also been used to study learning and memory in live rodents (Chen et al., 2013) The last two decades the neuronal function of the larval and adult zebrafish has been extensively studied using Ca2+ imaging methods. By applying simple Ca2+ indicators such as dextran or acetoxymethyl esters to more powerful genetically encoded Ca2+ indicators, zebrafish provides a transparent model where live Ca2+ imaging can be successfully achieved (Kettunen, 2012).</html>")
										.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(), 1);
				cellular_effect1.getDescriptionIDs().add(
						new DescriptionSection(cellular_effect1, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Ca2+ homeostatic system is known to be highly conserved throughout evolution and is present from humans to invertebrates (Case et al., 2007).").<DescriptionSection> makeItLive());
				cellular_effect1
						.getReferenceIDs()
						.add(
								new Reference(cellular_effect1, dataSource,
										"Barhoumi R, Qian Y, Burghardt RC, Tiffany-Castiglioni E. (2010) Image analysis of Ca2+ signals as a basis for neurotoxicity assays: promises and challenges. Neurotoxicol Teratol. 32: 16-24.")
										.<Reference> makeItLive());
				cellular_effect1.getReferenceIDs().add(
						new Reference(cellular_effect1, dataSource, "Berridge MJ, Lipp P, Bootman MD. (2000) The versatility and universality of calcium signalling. Nat Rev Mol Cell Biol. 1:11-21.")
								.<Reference> makeItLive());
				cellular_effect1.getReferenceIDs().add(
						new Reference(cellular_effect1, dataSource, "Berridge MJ. (2012) Calcium signalling remodelling and disease. Biochem Soc Trans. 40: 297-309.").<Reference> makeItLive());
				cellular_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										cellular_effect1,
										dataSource,
										"Blanke ML, VanDongen AMJ. (2009) Activation Mechanisms of the NMDA Receptor. In: Van Dongen AM, editor. Biology of the NMDA Receptor. Boca Raton (FL): CRC Press; Chapter 13. Available from: http://www.ncbi.nlm.nih.gov/books/NBK5274/")
										.<Reference> makeItLive());
				cellular_effect1.getReferenceIDs().add(
						new Reference(cellular_effect1, dataSource, "Calvo M, Villalobos C, Núñez L. (2015) Calcium imaging in neuron cell death. Methods Mol Biol. 1254: 73-85.").<Reference> makeItLive());
				cellular_effect1
						.getReferenceIDs()
						.add(
								new Reference(cellular_effect1, dataSource,
										"Case RM, Eisner D, Gurney A, Jones O, Muallem S, Verkhratsky A. (2007) Evolution of calcium homeostasis: from birth of the first cell to an omnipresent signalling system. Cell Calcium 42: 345-350.")
										.<Reference> makeItLive());
				cellular_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										cellular_effect1,
										dataSource,
										"Chen JL, Andermann ML, Keck T, Xu NL, Ziv Y. (2013) Imaging neuronal populations in behaving rodents: paradigms for studying neural circuits underlying behavior in the mammalian cortex. J Neurosci. 33: 17631-17640.")
										.<Reference> makeItLive());
				cellular_effect1.getReferenceIDs().add(new Reference(cellular_effect1, dataSource, "Clapham DE. (2007) Calcium signaling. Cell 131: 1047-1058.").<Reference> makeItLive());
				cellular_effect1.getReferenceIDs().add(new Reference(cellular_effect1, dataSource, "Grienberger C, Konnerth A. (2012) Imaging calcium in neurons. Neuron 73: 862-885.").<Reference> makeItLive());
				cellular_effect1.getReferenceIDs().add(
						new Reference(cellular_effect1, dataSource, "Hagenston AM, Bading H. (2011) Calcium Signaling in Synapse-to-Nucleus Communication. Cold Spring Harb Perspect Biol. 3: a004564.")
								.<Reference> makeItLive());
				cellular_effect1.getReferenceIDs().add(
						new Reference(cellular_effect1, dataSource, "Higley MJ, Sabatini BL. (2012) Calcium signalling in dendritic spines. Cold Spring Harb Perspect Biol. 4: a005686.").<Reference> makeItLive());
				cellular_effect1.getReferenceIDs().add(
						new Reference(cellular_effect1, dataSource, "Kettunen P. (2012) Calcium imaging in the zebrafish. Adv Exp Med Biol. 740: 1039-1071.").<Reference> makeItLive());
				cellular_effect1.getReferenceIDs().add(
						new Reference(cellular_effect1, dataSource, "Neher E., Sakaba T. (2008). Multiple roles of calcium ions in the regulation of neurotransmitter release. Neuron 59: 861-872.")
								.<Reference> makeItLive());
				cellular_effect1
						.getReferenceIDs()
						.add(
								new Reference(
										cellular_effect1,
										dataSource,
										"Traynelis S, Wollmuth LP, McBain CJ, Menniti FS, Vance KM, Ogden KK, Hansen KB, Yuan H, Myers SJ, Dingledine R. (2010) Glutamate receptor ion channels: structure, regulation, and function. Pharmacol Rev. 62: 405-496.")
										.<Reference> makeItLive());
				
				link_me1_ce1 = new Link_EffectToEffect(pathway, dataSource, molecular_effect1, cellular_effect1);
				link_me1_ce1.setLinkType(LinkType.DIRECT);
				wight = new ReferenceIDW<Link_EffectToEffect>(link_mie1_me1, dataSource, Link_EffectToEffect.class, 3.0D);
				link_me1_ce1
				.getDescriptionIDs()
				.set(
						new DescriptionSection(
								link_me1_ce1,
								dataSource,
								"Definition",
								"<html>The NMDA receptor is distinct in two ways: firstly, it is both ligand-gated and voltage-dependent and secondly, it requires co-activation by two ligands: glutamate and either D-serine or glycine.<br>NMDA receptor activation allows the influx of Ca2+ only when the receptor is occupied by L-glutamate or other agonists (and removal of Mg++ block) resulting in the postsynaptic membrane depolarization. In contrast, binding of antagonist to NMDA receptor decreases or eliminates Ca2+ influx and consequently dramatically decreases intracellular influx of Ca2+ levels (reviewed in Higley and Sabatini, 2012).</html>")
								.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(),0);
				link_me1_ce1
						.getDescriptionIDs()
						.set(
								new DescriptionSection_Structured(
										link_me1_ce1,
										dataSource,
										"(Key) Event Relationship Weight of Evidence",
										"<html>\n<body>\n<h3><span id=\"Biological_Plausibility\">Biological Plausibility</span></h3>\n<p>The relationship between KE (NMDARs, Inhibition) and KE (Calcium influx, Decreased) is plausible as the function evaluation of NMDA receptors is commonly carried out by measurement of intracellular influx of Ca2+ upon NMDA receptor stimulation by agonist. Calcium imaging techniques have been extensively utilized to investigate the relationship between these two KEs. Almost 15% of the current through NMDA receptors is mediated by Ca2+ under physiological conditions (Higley and Sabatini, 2012).</p>\n<p>It has been shown that less than five and, occasionally only a single NMDA receptor opens under physiological conditions, causing a total Ca2+ influx of about 6000 ions into a dendritic spine head reaching a concentration of ∼10 µM (Higley and Sabatini, 2012). However, the majority of the ions are rapidly eliminated by binding Ca2+ proteins, reaching ∼1 µM of free Ca2+ concentration (Higley and Sabatini, 2012).</p>\n<p>In rat primary forebrain cultures, the intracellular Ca2+ increases after activation of the NMDA receptor and this increase is blocked when the cells are cultured under Ca2+ free conditions, demonstrating that the NMDA-evoked increase in intracellular Ca2+ derives from extracellular and not intracellular sources (Liu et al., 2013).</p>\n<p>Neurons in brain slices from wild-type (GluRε2+/+) mice showed increase of intracellular Ca2+ in the presence of 100 μM NMDA that was completely inhibited after exposure to 100 mM APV. In contrast, the NMDA-mediated increase in Ca2+ was absent in brain slices from GluRε2−/− mice that do not possess any functional NMDA receptors in the developing neocortex (Okada et al., 2003).</p>\n<h3><span id=\"Empirical_Support_for_Linkage\">Empirical Support for Linkage</span></h3>\n<p><em>Include consideration of temporal concordance here</em></p>\n<p><strong>Pb2+:</strong> There are a few studies examining the effect of Pb2+ exposure on the changes in intracellular Ca2+. Incubation of rat synaptosomes with Pb2+ stimulates the activity of calmodulin reaching the higher effect at 30 µM, whereas higher concentrations of Pb2+ causes inhibition (Sandhir and Gill, 1994). Pb2+ exposure increases the activity of calmodulin by 45% in animal models. The IC50 values for inhibition of Ca2+ ATPase by Pb2+ has been found to be 13.34 and 16.69 µM in calmodulin-rich and calmodulin-depleted synaptic plasma membranes, respectively. Exposure of rats to Pb2+ has also inhibitory effect on Ca2+ ATPase activity, causing increase in intrasynaptosomal Ca2+ (Sandhir and Gill, 1994). In embryonic rat hippocampal neurons, exposure to 100 nM Pb2+ for periods from 1 hour to 2 days showes decrease of intracellular Ca2+ by a calmodulin-dependent mechanism (Ferguson et al., 2000).</p>\n<p>There is evidence that Pb2+ exposure affects Ca2+ homeostasis causing alterations in the phosphorylation state of different kinases. For example, Pb2+ has been shown to interfere with MAPK signaling as it increases the phosphorylation of both ERK1/2 and p38(MAPK) (Cordova et al., 2004). However, the findings regarding calcium/calmodulin kinase II (CamKII) activity are not clear (Toscano and Guilarte, 2005). On one hand, Pb2+ has been found to cause reduction of CREB phosphorylation in the hippocampus of rats exposed during brain development (Toscano et al., 2003; Toscano et al., 2002). On the other hand, the levels of phosphorylation of CamKII have not been explored but only the mRNA expression levels have been studied in rat pups on PND 25 that received Pb2+ (180 and 375-ppm lead acetate in food for 30 days) and reached blood Pb2+ levels 5.8 to 10.3 μg/dl on PND 55 (Schneider et al., 2012). More specifically, CamKIIα gene expression has been found to be very sensitive to Pb2+ exposure in the frontal cortex but not in the hippocampus, whereas CamKIIβ gene expression in both brain structures remained unchanged (Schneider et al., 2012).</p>\n<p>Acute Pb2+ (10μM) exposure impairs LTP (125.8% reduction of baseline) in CA1 region of hippocampus derived from Sprague-Dawley rats (15-18 PND) as it has been recorded by whole cell patch-clamp technique (Li et al., 2006). In the same study, through calcium imaging, it has been shown in the 10mM caffeine-perfused cultured hippocampal neurons that 10μM Pb2+ reduces intracellular Fluo-4 fluorescence ratio to 0.44 (Li et al., 2006).</p>\n<p>Pb2+ chronically or acutely applied, significantly reduces LTP in CA1 region of hippocampus from Wistar or Sprague-Dawley rats (30 and 60 PND) (Carpenter et al., 2002). These animals were exposed to Pb2+ via the mother&rsquo;s drinking water either through gestation and lactation (upto day 21) (perinatal), only by lactation through the mother&rsquo;s drinking water and then in the pup&rsquo;s drinking water (post) or from gestation (pre and post). The concentrations of Pb2+ used in the drinking water were 0.1 and 0.2%. In CA1, LTP has been reduced at both ages and Pb2+ concentrations or duration of exposure. In CA3, there have been no differences with time of exposure, but there was a dramatic difference in response as the age of animals increased. At 30 days LTP was significantly reduced, but at 60 days LTP was increased by about 30% (Carpenter et al., 2002). In the same brain structure and area (CA3) the effects of Pb2+ on LTP have been different in 30 PND and 60 PND rats after either acute perfusion of Pb2+ or from slices derived from rats after chronic developmental exposure to Pb2+, as inhibition of LTP has been recorded in 30 PND CA3, whereas potentiation has been measured in 60 PND CA3 with either exposure paradigm that have been attributed to possible involvement of protein kinase C (Hussain et al., 2000).</p>\n"
												+ "<table>\n  <tbody>\n    <tr>\n      <td align=\"center\"><strong>Stressor</strong></td>\n      <td align=\"center\"><strong>Experimental Model</strong></td>\n      <td align=\"center\"><strong>Tested concentrations</strong></td>\n      <td align=\"center\"><strong>Exposure route</strong></td>\n      <td align=\"center\"><strong>Exposure duration</strong></td>\n      <td align=\"center\"><strong>Inhibition of NMDAR (KE up) (measurements, quantitative if available)</strong></td>\n      <td align=\"center\"><strong>Reduced Ca 2+ influx (KE down) (measurements, quantitative if available)</strong></td>\n      <td align=\"center\"><strong>References</strong></td>\n    </tr>\n    <tr>\n      <td>Lead</td>\n      <td>CA1 pyramidal neurons derived from Sprague-Dawley rats (15-18 PND)</td>\n      <td>5-20 µM</td>\n      <td></td>\n      <td>25 min</td>\n      <td>By bath application of 5ìM lead for 15 min prior to and 10 min after the tetanus, the LTP was induced to 151.4±3.5% of baseline. In the presence of 10ìM lead, the LTP was reduced significantly to 125.8±2.9% of baseline. The reduction of 20ìM lead to LTP was not significant with that of 10ìM.</td>\n      <td>In the 10mM caffeine-perfused cultured hippocampal neurons, 10ìM lead reduced intracellular Fluo-4 fluorescence ratio to 0.44±0.08</td>\n      <td>Li et al., 2006</td>\n    </tr>\n    <tr>\n      <td>Lead</td>\n      <td>CA1 region of hippocampus from Wistar or Sprague-Dawley rats (30 and 60 PND)</td>\n      <td>Two concentrations of lead were used in the drinking water 0.1 and 0.2%.</td>\n      <td>in utero and per os</td>\n      <td>Rats exposed to lead via the mother&rsquo;s drinking water either through gestation and lactation (to day 21) (perinatal), only by lactation through the mother&rsquo;s drinking water and then in the pup&rsquo;s drinking water until use (post) or from gestation until use (pre and post).</td>\n      <td>In CA1, LTP is reduced at both ages, and there were no significant differences in the effects of the two lead concentrations or with the duration of exposure. In CA3 there were no differences with time of exposure, but there was a dramatic difference in response as a function of age. At 30 days LTP was significantly reduced, but at 60 days LTP was increased by about 30%. As in the chronic exposure studies, lead reduced LTP in CA1 at both ages but reduced LTP in CA3 in 30-day animals while potentiating LTP in 60-day animals.</td>\n      <td></td>\n      <td>Carpenter et al., 2002</td>\n    </tr>\n    <tr>\n      <td></td>\n    </tr>\n  </tbody>\n</table>\n"
												+ "<h3><span id=\"Uncertainties_or_Inconsistencies\">Uncertainties or Inconsistencies</span></h3>\n<p>The structural diversity of NMDA subunits can influence the functionality of the receptors and their permeability to Ca2+. For example, NR2B subunits show higher affinity for glutamate binding and higher Ca2+ permeability (reviewed in Higley and Sabatini, 2012). But NMDA receptor subunit composition is not the only parameter that influences Ca2+ entrance in the cytosol. Membrane potential due to pore blockade by extracellular Mg2+ and receptor phosphorylation are two additional regulator of Ca2+ influx through NMDA receptors (reviewed in Higley and Sabatini, 2012).</p>\n<p>Entrance of Ca2+ into neuronal cell can also happen through KA and AMPA receptors but to a smaller extend compared to NMDA receptors (reviewed in Higley and Sabatini, 2012). However, recent findings suggest that AMPA receptors may also contribute to Ca2+ signalling during CNS development (reviewed in Cohen and Greenberg, 2008). Early in development cortical pyramidal neurons express calcium-permeable, GluR2 subunit–lacking AMPA receptors. During postnatal development these neurons undergo a switch in the subunit composition of AMPA receptors, expressing instead GluR2-containing, calcium-impermeable AMPA receptor suggesting that the main point entrance of Ca2+ at this developmental stage are NMDA receptors.</p>\n<p>Furthermore, Ca2+ entry occurs through L- and H-type voltage-dependent Ca2+channels (L-VDCCs) (Perez-Reyes and Schneider, 1994; Berridge, 1998; Felix, 2005) that are encountered in neurons, suggesting that there are more possible entrance sites for Ca2+ to get into the cytosol rather than only through NMDA receptors.</p>\n<p>Interestingly, Pb2+ has the ability to mimic or even compete with Ca2+ in the CNS (Flora et al., 2006). Indeed, Pb2+ is accumulated in the same mitochondrial compartment as Ca2+ and it has been linked to disruptions in intracellular calcium metabolism (Bressler and Goldstein, 1991). So, it can be that the reduced levels of Ca2+ after Pb2+ exposure may not be attributed to NMDA receptor inhibition but also to the ability of this heavy metal to compete with Ca2+. To make things more complicated, recent findings suggest that BDNF can also acutely elicit an increase in intracellular Ca2+ concentration, which is attributed not only to the influx of extracellular Ca2+ but also to Ca2+ mobilization from intracellular calcium stores (Numakawa et al., 2002; He et al., 2005). These finding derive from primary cultures of cortical neurons (E18 or 2-3 PND), where BDNF-evoked Ca2+ signals have not been altered neither by tetrodotoxin nor by a cocktail of glutamate receptor blockers (CNQX and APV), pointing out the importance of BDNF in Ca2+ homeostasis (Numakawa et al., 2002; He et al., 2005).</p>\n</body>\n</html>\n",
										wight).setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(),1);
				link_me1_ce1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										link_me1_ce1,
										dataSource,
										"Quantitative Understanding of the Linkage",
										"<html><i>Is it known how much change in the first event is needed to impact the second? Are there known modulators of the response-response relationships? Are there models or extrapolation approaches that help describe those relationships?</i>\nNo enough data is available to address the questions above.</html>")
										.setFormat(ContentFormat.HTML).<DescriptionSection> makeItLive(),2);
				link_me1_ce1
						.getDescriptionIDs()
						.set(
								new DescriptionSection(
										link_me1_ce1,
										dataSource,
										"Evidence Supporting Taxonomic Applicability",
										"Besides the above studies described in rodents, intracellular Ca2+ regulation has been studied at the neuromuscular junction of larval Drosophila exposed to 0, 100 μM or 250 μM Pb2+ (He et al., 2009).")
										.<DescriptionSection> makeItLive(),3);
				
				link_me1_ce1.getReferenceIDs().add(new Reference(link_me1_ce1, dataSource, "Berridge MJ. (1998) Neuronal calcium signaling. Neuron 21: 13-26.").<Reference> makeItLive());
				link_me1_ce1.getReferenceIDs().add(
						new Reference(link_me1_ce1, dataSource, "Bressler JP, Goldstein GW. (1991) Mechanisms of lead neurotoxicity. Biochem Pharmacol. 41: 479-484.").<Reference> makeItLive());
				link_me1_ce1
						.getReferenceIDs()
						.add(
								new Reference(
										link_me1_ce1,
										dataSource,
										"Carpenter DO, Hussain RJ, Berger DF, Lombardo JP, Park HY. (2002) Electrophysiologic and behavioral effects of perinatal and acute exposure of rats to lead and polychlorinated biphenyls. Environ Health Perspect. 110: 377-386.")
										.<Reference> makeItLive());
				link_me1_ce1.getReferenceIDs().add(
						new Reference(link_me1_ce1, dataSource,
								"Cohen S, Greenberg ME. (2008) Communication between the synapse and the nucleus in neuronal development, plasticity and disease. Annu Rev Cell Dev Biol. 24: 183-209.")
								.<Reference> makeItLive());
				link_me1_ce1
						.getReferenceIDs()
						.add(
								new Reference(
										link_me1_ce1,
										dataSource,
										"Cordova FM, Rodrigues LS, Giocomelli MBO, Oliveira CS, Posser T, Dunkley PR, Leal RB. (2004) Lead stimulates ERK1/2 and p38MAPK phosphorylation in the hippocampus of immature rats. Brain Res. 998: 65-72.")
										.<Reference> makeItLive());
				link_me1_ce1.getReferenceIDs().add(
						new Reference(link_me1_ce1, dataSource, "Felix R. (2005) Molecular regulation of voltage-gated Ca2+ channels. J Recept Signal Transduct Res. 25: 57-71.").<Reference> makeItLive());
				link_me1_ce1
						.getReferenceIDs()
						.add(
								new Reference(
										link_me1_ce1,
										dataSource,
										"Ferguson C, Kern M, Audesirk G. (2000) Nanomolar concentrations of inorganic lead increase Ca2+ efflux and decrease intracellular free Ca2+ ion concentrations in cultured rat hippocampal neurons by a calmodulin-dependent mechanism. Neurotoxicology 21: 365-378.")
										.<Reference> makeItLive());
				link_me1_ce1
						.getReferenceIDs()
						.add(
								new Reference(
										link_me1_ce1,
										dataSource,
										"Flora SJS, Flora G, Saxena G. (2006) Environmental occurrence, health effects and management of lead poisoning, in Lead: Chemistry, Analytical Aspects, Environmental Impacts and Health Effects (Cascas SB and Sordo J eds) Elsevier, Amsterdam, The Netherlands, pp 158-228.")
										.<Reference> makeItLive());
				link_me1_ce1.getReferenceIDs().add(
						new Reference(link_me1_ce1, dataSource,
								"He J, Gong H, Luo Q. (2005) BDNF acutely modulates synaptic transmission and calcium signalling in developing cortical neurons. Cell Physiol Biochem. 16: 69-76.").<Reference> makeItLive());
				link_me1_ce1.getReferenceIDs().add(
						new Reference(link_me1_ce1, dataSource,
								"He T, Hirsch HV, Ruden DM, Lnenicka GA. (2009) Chronic lead exposure alters presynaptic calcium regulation and synaptic facilitation in Drosophila larvae. Neurotoxicology 30: 777-784.")
								.<Reference> makeItLive());
				link_me1_ce1.getReferenceIDs().add(
						new Reference(link_me1_ce1, dataSource, "Higley MJ, Sabatini BL. (2012) Calcium signalling in dendritic spines. Cold Spring Harb Perspect Biol 4: a005686.").<Reference> makeItLive());
				link_me1_ce1.getReferenceIDs().add(
						new Reference(link_me1_ce1, dataSource,
								"Hussain RJ, Parsons PJ, Carpenter DO. (2000) Effects of lead on long-term potentiation in hippocampal CA3 vary with age. Brain Res Dev Brain Res. 121: 243-252.").<Reference> makeItLive());
				link_me1_ce1
						.getReferenceIDs()
						.add(
								new Reference(
										link_me1_ce1,
										dataSource,
										"Li XM, Gu Y, She JQ, Zhu DM, Niu ZD, Wang M, Chen JT, Sun LG, Ruan DY. (2006) Lead inhibited N-methyl-D-aspartate receptor-independent long-term potentiation involved ryanodine-sensitive calcium stores in rat hippocampal area CA1. Neuroscience. 139: 463-473.")
										.<Reference> makeItLive());
				link_me1_ce1
						.getReferenceIDs()
						.add(
								new Reference(
										link_me1_ce1,
										dataSource,
										"Liu F, Patterson TA, Sadovova N, Zhang X, Liu S, Zou X, Hanig JP, Paule MG, Slikker W Jr, Wang C. (2013) Ketamine-induced neuronal damage and altered N-methyl-D-aspartate receptor function in rat primary forebrain culture. Toxicol Sci. 131: 548-557.")
										.<Reference> makeItLive());
				link_me1_ce1
						.getReferenceIDs()
						.add(
								new Reference(
										link_me1_ce1,
										dataSource,
										"Numakawa T, Yamagishi S, Adachi N, Matsumoto T, Yokomaku D, Yamada M, Hatanaka H (2002) Brain-derived neurotrophic factor-induced potentiation of Ca2+ oscillations in developing cortical neurons. J Biol Chem. 277: 6520-6529.")
										.<Reference> makeItLive());
				link_me1_ce1
						.getReferenceIDs()
						.add(
								new Reference(
										link_me1_ce1,
										dataSource,
										"Okada H, Miyakawa N, Mori H, Mishina M, Miyamoto Y, Hisatsune T. (2003) NMDA receptors in cortical development are essential for the generation of coordinated increases in [Ca2+](i) in \"neuronal domains\". Cereb Cortex. 13 :749-757.")
										.<Reference> makeItLive());
				link_me1_ce1.getReferenceIDs().add(
						new Reference(link_me1_ce1, dataSource, "Perez-Reyes E, Schneider T. (1994) Calcium channels: Structure, function, and classification. Drug Dev Res. 33: 295–318.").<Reference> makeItLive());
				link_me1_ce1.getReferenceIDs().add(
						new Reference(link_me1_ce1, dataSource, "Sandhir R, Gill KD. (1994) Alterations in calcium homeostasis on lead exposure in rat synaptosomes. Mol Cell Biochem. 131: 25-33.")
								.<Reference> makeItLive());
				link_me1_ce1.getReferenceIDs().add(
						new Reference(link_me1_ce1, dataSource,
								"Schneider JS, Mettil W, Anderson DW. (2012) Differential Effect of Postnatal Lead Exposure on Gene Expression in the Hippocampus and Frontal Cortex. J Mol Neurosci. 47: 76-88.")
								.<Reference> makeItLive());
				link_me1_ce1
						.getReferenceIDs()
						.add(
								new Reference(
										link_me1_ce1,
										dataSource,
										"Sinner B, Friedrich O, Zink W, Martin E, Fink RH, et al. (2005) Ketamine stereoselectively inhibits spontaneous Ca2+-oscillations in cultured hippocampal neurons. Anesthesia and analgesia 100: 1660-1666.")
										.<Reference> makeItLive());
				link_me1_ce1.getReferenceIDs().add(
						new Reference(link_me1_ce1, dataSource, "Toscano CD, Guilarte TR. (2005) Lead neurotoxicity: From exposure to molecular effects. Brain Res Rev. 49: 529-555.").<Reference> makeItLive());
				link_me1_ce1
						.getReferenceIDs()
						.add(
								new Reference(
										link_me1_ce1,
										dataSource,
										"Toscano CD, Hashemzadeh-Gargari H, McGlothan JL, Guilarte TR. (2002) Developmental Pb2+ exposure alters NMDAR subtypes and reduces CREB phosphorylation in the rat brain. Dev Brain Res. 139: 217-226.")
										.<Reference> makeItLive());
				link_me1_ce1
						.getReferenceIDs()
						.add(
								new Reference(
										link_me1_ce1,
										dataSource,
										"Toscano CD, McGlothan JL, Guilarte TR. (2003) Lead exposure alters cyclic-AMP response element binding protein phosphorylation and binding activity in the developing rat brain. Dev Brain Res. 145: 219-228.")
										.<Reference> makeItLive());
				
				cellular_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect2.setTitle("Release of BDNF, Reduced");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, cellular_effect2);
				
				cellular_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect3.setTitle("Presynaptic release of glutamate, Reduced");
				cellular_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				cellular_effect4 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect4.setTitle("Cell death, N/A");
				cellular_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				cellular_effect5 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect5.setTitle("Dendritic morphology, Aberrant");
				cellular_effect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect2, cellular_effect3);
				new Link_EffectToEffect(pathway, dataSource, cellular_effect2, cellular_effect4);
				new Link_EffectToEffect(pathway, dataSource, cellular_effect2, cellular_effect5);
				
				cellular_effect6 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect6.setTitle("Synaptogenesis, Decreased");
				cellular_effect6.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect6.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect3, cellular_effect6);
				new Link_EffectToEffect(pathway, dataSource, cellular_effect4, cellular_effect6);
				new Link_EffectToEffect(pathway, dataSource, cellular_effect5, cellular_effect6);
				
				organ_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect1.setTitle("Neuronal network function, Decreased");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect6, organ_effect1);
				
				individual_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect1.setTitle("Learning and memory, Impairment");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_EffectToEffect(pathway, dataSource, organ_effect1, individual_effect1);
				
				pathway.updateEssentiality();
				
				EssetialityDescription essentiality = pathway.getEssentiality();
				for (DescriptionSection ds : essentiality.links.getCachedObjects())
					if (ds instanceof DescriptionSection_Structured)
						((ReferenceIDW<Link_EffectToEffect>) ((DescriptionSection_Structured) ds).getStructuredContent()).setWeight(1.0D);
				for (DescriptionSection ds : essentiality.effects.getCachedObjects())
					if (ds instanceof DescriptionSection_Structured)
						((ReferenceIDW<Effect>) ((DescriptionSection_Structured) ds).getStructuredContent()).setWeight(3.0D);
				
				((ReferenceIDW<Link_EffectToEffect>) essentiality.getEssentialityDescription(link_mie1_me1).getStructuredContent()).setWeight(3.0D);
				((ReferenceIDW<Link_EffectToEffect>) essentiality.getEssentialityDescription(link_me1_ce1).getStructuredContent()).setWeight(2.0D);
				
				DescriptionSection_Structured dss = essentiality.getEssentialityDescription(mie1);
				dss
						.setContent("<html>The MIE is defined and described above as the binding of antagonist to NMDA receptor in neurons during development in hippocampus and cortex (the critical brain structures for learning and memory formation). Activation of NMDA receptors results in long-term potentiation (LTP), which is related to increased synaptic strength and memory formation in the hippocampus (Johnston et al., 2009). LTP induced by activation of NMDA receptors has been found to be elevated in the developing rodent brain compared to the mature brain, partially due to \"developmental switch\" of the NMDAR 2A and 2B subunits (Johnston et al., 2009).<br><br><b>Essentiality of MIE (binding of antagonist to NMDAR in neurons during synaptogenesis in hippocampus and cortex) for AO (Impairment of learning and memory) is STRONG:</b> It is well documented that learning and memory processes rely on physiological functioning of NMDA receptors. The essentiality of the MIE has been demonstrated in both animal and human studies investigating NMDA itself, NMDA receptors antagonists and mutant mice lacking NMDA receptor subunits (reviewed in Haberny et al., 2002; Rezvani, 2006 and Granger et al., 2011). NMDA systemically administered in rats, has been shown to potentiate cognitive functions (Rezvani, 2006). There are various studies dealing with specific NMDA receptor subunit gene knock-out leading to a variety of phenotypes. Depending on the endogenous levels of NMDAR subunits, the pattern of their expression and their importance in developmental processes, the loss of a subunit may lead from early embryonic lethality, to mild neurobehavioral impairment up to neuronal disorders that manifest learning and memory deficits (reviewed in Rezvani, 2006 and Granger et al., 2011). Mutant mice lacking NR1 gene have shown perinatal lethality, whereas transgenic mice lacking NR1 subunit in the CA1 region of the hippocampus show both defective LTP and severe deficits in both spatial and nonspatial learning (Shimizu et al., 2000; Tsien et al., 1996). A similar impairment of LTP, long-term depression (LTD), and spatial memory has been seen with CA1-specific NR2B deletion (Brigman et al. 2010). However, LTP has been normal in postnatal forebrain knock-out of NR2A in mice, even though spatial memory has been impaired, probably because of the severe reduction observed in overall excitatory transmission (Shimshek et al., 2006), while the inactivation of the same gene has led to reduced hippocampal LTP and spatial learning (Sakimura et al., 1995). Furthermore, a NR2B transgenic (Tg) line of mice has been developed, in which the NMDA-receptor function has been increased, showing both larger LTP in the hippocampus and superior learning and memory (Tang et al., 1999). Finally, depletion of both NR2A and NR2B in single neurons has shown alteration in synaptic development (Gray et al., 2011). Interestingly, during development, especially during postnatal days (PND) 7-14 in rodents, the central nervous system (CNS) exhibits increased susceptibility to toxic insults that affect NMDA receptors (Haberny et al., 2002). This increased susceptibility has been suggested to be related to the elevated expression of specific NMDA receptor subunits (Miyamoto et al., 2001). Because of the critical role of the NMDA receptor system in brain development, the exposure to antagonists of NMDA receptors can have long-lasting and severe effects (Behar et al., 1999). NMDA-receptor antagonists such as MK-801, ketamine, phencyclidine (PCP) and 2-amino-5-phosphonopentanoate (AP5 or APV) have been extensively used to study the role of NMDA in learning and memory in developing organisms. Both acute and subchronic administration of NMDA-receptor antagonists in several laboratory animals has been shown to impair performance on tasks that seem to depend upon hippocampal functions (reviewed in Rezvani, 2006; Haberny et al., 2002). The developmental neurotoxicity of several agents, including methylmercury, lead, and ethanol is also thought to result from interaction of these substances with the NMDA receptor system (Guilarte, 1997; Guilarte and McGlothan, 1998; Ikonomidou et al., 2000; Kumari and Ticku, 1998; Miyamoto et al., 2001).<br><br><b>Essentiality of MIE (binding of antagonist to NMDAR in neurons during synaptogenesis in hippocampus and cortex for KE (aberrant dendritic morphology) is MODERATE:</b> The cortex-restricted knockout of NR1 causes refinement in dendritic arborisation in cortex and loss of patterning (Iwasato et al., 2000; Lee et al., 2005). Similar alteration in dendritic arbor has also been identified after depletion of both NR2A and NR2B subunits in isolated neurons (Espinosa et al., 2009). Blockade of NMDA receptor with APV has shown decrease of dendritic growth rate in some in vivo experimental approaches (Rajan et al., 1999; Rajan and Cline, 1998). However, other studies have reported increase in dendritic spine number and dendritic branching after chronic APV-treatment both in vivo and in vitro (Rocha and Sur, 1995; McAllister et al., 1996). This discrepancy is possibly attributed to the different developmental expression of NMDA receptor subunits that triggers distinct intracellular signaling pathways linking NMDAR function to different morphological findings.<br><br><b>Essentiality of MIE (binding of antagonist to NMDAR in neurons during synaptogenesis in hippocampus and cortex) for KE (cell death) is STRONG:</b> The essential role of NMDA receptors in survival during early cortical development has been pointed out both in in vitro (Hwang et al., 1999; Yoon et al., 2003) and in vivo rodent studies (Ikonomidou et al., 1999). NMDA receptor deficient mice have revealed the importance of this receptor for neuronal survival during development as an approximately 2-fold increase in developmental cell death has been observed in these transgenic mice, which was caspase-3 and Bax dependent (Adams et al., 2004; Rivero Vaccari et al., 2006).<br><br><b>Essentiality of MIE for KE (decreased neuronal network function) is STRONG:</b> The NMDA receptor is associated with circuit formation and function at the developmental stage of an organism as a number of antagonists of this receptor importantly disrupt the neuronal circut (Simon et al., 1992). Hence, the nature of evidence for the essentiality of the MIE is High (Strong).</html>");
				dss.setFormat(ContentFormat.HTML);
				dss = essentiality.getEssentialityDescription(molecular_effect1);
				dss
						.setContent("<html><b>Essentiality of KE (Inhibition of NMDA receptors) for AO (Impairment of learning and memory))</b> is <b>STRONG:</b> The noncompetitive antagonist MK-801 has been shown to induce dose-dependent impairment of learning and memory (Wong et al., 1986) and data on rodent models has been recently reviewed in van der Staay et al. 2011. Learning impairments induced by NMDA receptor blockade using MK-801 have also been reported in nonhuman primates (Ogura and Aigner, 1993). Moreover there are human studies demonstrating that NMDA-receptor inhibition impairs learning and memory processes (reviewed in Rezvani, 2006).</html");
				dss.setFormat(ContentFormat.HTML);
				dss = essentiality.getEssentialityDescription(cellular_effect1);
				dss
						.setContent("<html><b>Essentiality of KE (Decreased Calcium influx) for AO (Impairment of learning and memory)</b> is <b>STRONG:</b> In the nervous system, many intracellular responses to modified Ca2+ levels are mediated by calcium/calmodulin-regulated protein kinases (CaMKs), a family of protein kinases that are initially modulated by binding of Ca2+ to CaM and subsequently by protein phosphorylation (Wayman et al., 2008). Multifunctional CaMKs, such as CaMKII and members of CaMK cascade (CaMKK, CaMKI and CaMKIV) are highly abundant in CNS and regulate different protein substrates (Soderling, 1999). Mice with a mutation in the alpha- CaMKII that is abundantly found in the hippocampus have shown spatial learning impairments, whereas some types of non-spatial learning peocesses have not been affected (Silva et al., 1992).");
				dss.setFormat(ContentFormat.HTML);
				
			}
		
	}

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
import org.qsari.effectopedia.core.objects.Link_ChemStructToChemStruct;
import org.qsari.effectopedia.core.objects.Link_ChemStructToMIE;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.core.objects.Test_InChemico;
import org.qsari.effectopedia.core.objects.Test_InVitro;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.RevisionBasedDS;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public class os	extends SourceGeneratedPathway {

public os(DataSource dataSource) {
super("Oxidation Stress mediated Renal Failure","",dataSource,"D://Java//org.qsari.effectopedia//test//EUToxRisk//Oxidation Stress mediated Renal Failure");
}
protected Initiator_ChemicalStructure initiator_chemicalstructure1;
protected Link_ChemStructToChemStruct link_chemstructtochemstruct2;
protected Initiator_ChemicalStructure initiator_chemicalstructure3;
protected Link_ChemStructToMIE link_chemstructtomie4;
protected Effect_MolecularInitiatingEvent effect_molecularinitiatingevent5;
protected Link_EffectToEffect link_effecttoeffect6;
protected Effect_DownstreamEffect effect_downstreameffect7;
protected Link_EffectToEffect link_effecttoeffect8;
protected Effect_DownstreamEffect effect_downstreameffect9;
protected Link_EffectToEffect link_effecttoeffect10;
protected Effect_DownstreamEffect effect_downstreameffect11;
protected Link_EffectToEffect link_effecttoeffect12;
protected Effect_DownstreamEffect effect_downstreameffect13;
protected Link_EffectToEffect link_effecttoeffect14;
protected Effect_DownstreamEffect effect_downstreameffect15;
protected Link_EffectToEffect link_effecttoeffect16;
protected Effect_DownstreamEffect effect_downstreameffect17;
protected Link_EffectToEffect link_effecttoeffect18;
protected Link_EffectToEffect link_effecttoeffect19;
protected Effect_DownstreamEffect effect_downstreameffect20;
protected Effect_AdverseOutcome effect_adverseoutcome21;
protected Effect_DownstreamEffect effect_downstreameffect22;
protected TestResponseMapping testresponsemapping23;
protected Test_InChemico test_inchemico24;
protected TestResponseMapping testresponsemapping25;
protected Test_InChemico test_inchemico26;
protected TestResponseMapping testresponsemapping27;
protected Test_InVitro test_invitro28;
protected TestResponseMapping testresponsemapping29;
protected Test_InChemico test_inchemico30;
protected TestResponseMapping testresponsemapping31;
protected Test_InChemico test_inchemico32;
protected TestResponseMapping testresponsemapping33;
protected Test_InVitro test_invitro34;
protected TestResponseMapping testresponsemapping35;
protected Test_InVitro test_invitro36;
protected TestResponseMapping testresponsemapping37;
protected Test_InChemico test_inchemico38;
protected TestResponseMapping testresponsemapping39;
protected Test_InVitro test_invitro40;
@Override
public void generateContent()
{genreateRevision1();
storeRevision();
((RevisionBasedDS) dataSource).setLocation(pathway);
}
public void genreateRevision1() {

initiator_chemicalstructure1 = new Initiator_ChemicalStructure(pathway, dataSource);
initiator_chemicalstructure1.setTitle("Potassium bromate");
initiator_chemicalstructure1.getStructure2DImage().setValue("https://apps.ideaconsult.net/ambit2/depict/cdk?search=%5BK%2B%5D.%5BO-%5DBr%28%3DO%29%3DO&w=200&h=200&media=image/png");
initiator_chemicalstructure1.getIdentification().setPropertyValue(0,"7758012");
initiator_chemicalstructure1.getIdentification().setPropertyValue(1,"Potassium bromate");
initiator_chemicalstructure1.getIdentification().setPropertyValue(2,"[K+].[O-]Br(=O)=O");
initiator_chemicalstructure1.getIdentification().setPropertyValue(3,"InChI=1S/BrHO3.K/c2-1(3)4;/h(H,2,3,4);/q;+1/p-1");
initiator_chemicalstructure1.getIdentification().setPropertyValue(4,"Key: OCATYIAKPYKMPG-UHFFFAOYSA-M");
initiator_chemicalstructure1.getIdentification().setPropertyValue(5,"Key: OCATYIAKPYKMPG-UHFFFAOYSA-M");
initiator_chemicalstructure1.getIdentification().setPropertyValue(6,"KBrO3");
initiator_chemicalstructure1.setSynonymsList(new String[] {" "});

initiator_chemicalstructure3 = new Initiator_ChemicalStructure(pathway, dataSource);
initiator_chemicalstructure3.setTitle("Potassium bromate");
initiator_chemicalstructure3.getStructure2DImage().setValue("https://apps.ideaconsult.net/ambit2/depict/cdk?search=%5BK%2B%5D.%5BO-%5DBr%28%3DO%29%3DO&w=200&h=200&media=image/png");
initiator_chemicalstructure3.getIdentification().setPropertyValue(0,"7758012");
initiator_chemicalstructure3.getIdentification().setPropertyValue(1,"Potassium bromate");
initiator_chemicalstructure3.getIdentification().setPropertyValue(2,"[K+].[O-]Br(=O)=O");
initiator_chemicalstructure3.getIdentification().setPropertyValue(3,"InChI=1S/BrHO3.K/c2-1(3)4;/h(H,2,3,4);/q;+1/p-1");
initiator_chemicalstructure3.getIdentification().setPropertyValue(4,"Key: OCATYIAKPYKMPG-UHFFFAOYSA-M");
initiator_chemicalstructure3.getIdentification().setPropertyValue(5," ");
initiator_chemicalstructure3.getIdentification().setPropertyValue(6,"KBrO3");
initiator_chemicalstructure3.setSynonymsList(new String[] {" "});

effect_molecularinitiatingevent5 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
effect_molecularinitiatingevent5.setTitle("Oxidative reactivity");
effect_molecularinitiatingevent5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
effect_molecularinitiatingevent5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
effect_molecularinitiatingevent5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");
effect_molecularinitiatingevent5.getDescriptionIDs().set(new DescriptionSection(effect_molecularinitiatingevent5,dataSource,"Definition","Provide brief description of the molecular initiating event\n\nThe chemical is capable of oxidising other molecules. Typically, these are electron-rich chemicals that attack eletrophilic molecules in the cell. Glutathione (GSH)  is one of the primary defences against such nucleophiles in the cell. Thus, depletion of GSH in a cell-free environment is indicative of the oxidative power of a chemical before starting experiments with live cells.").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);
effect_molecularinitiatingevent5.getDescriptionIDs().set(new DescriptionSection(effect_molecularinitiatingevent5,dataSource,"Measurment/detection","Provide a summary of the available measurment and detection methods.\n\nPromega GSH-Glo kit in cell-free environment").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 1);

effect_downstreameffect7 = new Effect_DownstreamEffect(pathway, dataSource);
effect_downstreameffect7.setTitle("Increased ROS");
effect_downstreameffect7.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
effect_downstreameffect7.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
effect_downstreameffect7.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");

effect_downstreameffect9 = new Effect_DownstreamEffect(pathway, dataSource);
effect_downstreameffect9.setTitle("Breaching the defences against ROS");
effect_downstreameffect9.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
effect_downstreameffect9.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

effect_downstreameffect11 = new Effect_DownstreamEffect(pathway, dataSource);
effect_downstreameffect11.setTitle("Mitochondrial injury");
effect_downstreameffect11.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organelle");
effect_downstreameffect11.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
effect_downstreameffect11.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");

effect_downstreameffect13 = new Effect_DownstreamEffect(pathway, dataSource);
effect_downstreameffect13.setTitle("Energy Crisis");
effect_downstreameffect13.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
effect_downstreameffect13.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

effect_downstreameffect15 = new Effect_DownstreamEffect(pathway, dataSource);
effect_downstreameffect15.setTitle("Inhibition of reabsorbtion water and solutes");
effect_downstreameffect15.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
effect_downstreameffect15.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
effect_downstreameffect15.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mid-term");
effect_downstreameffect15.getDescriptionIDs().set(new DescriptionSection(effect_downstreameffect15,dataSource,"Definition","Fanconi like symptoms").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);

effect_downstreameffect17 = new Effect_DownstreamEffect(pathway, dataSource);
effect_downstreameffect17.setTitle("Water loss");
effect_downstreameffect17.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ system");
effect_downstreameffect17.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
effect_downstreameffect17.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mid-term");
effect_downstreameffect17.getDescriptionIDs().set(new DescriptionSection(effect_downstreameffect17,dataSource,"Definition","Diabetes insipidus").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);

effect_downstreameffect20 = new Effect_DownstreamEffect(pathway, dataSource);
effect_downstreameffect20.setTitle("Elevated blood pressure");
effect_downstreameffect20.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
effect_downstreameffect20.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
effect_downstreameffect20.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mid-term");

effect_adverseoutcome21 = new Effect_AdverseOutcome(pathway, dataSource);
effect_adverseoutcome21.setTitle("Drug Induced Fanconi");
effect_adverseoutcome21.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
effect_adverseoutcome21.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
effect_adverseoutcome21.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "long-term");
effect_adverseoutcome21.getDescriptionIDs().set(new DescriptionSection(effect_adverseoutcome21,dataSource,"Definition","Provide brief description of the (key) event: each kidney holds about 1 million nephrons, which constitutes an excess of nephron units to perform \"normal\" renal function. It is estimated that an individual can los up to 60% of their nephrons without having an impact on the overall renal function. However, when a critical mass of functioning nephrons is lost, renal function starts to decrease, leading to chronic kidney disease.").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);

effect_downstreameffect22 = new Effect_DownstreamEffect(pathway, dataSource);
effect_downstreameffect22.setTitle("Renal failure");
effect_downstreameffect22.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
effect_downstreameffect22.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mid-term");

test_inchemico24 = new Test_InChemico(pathway, dataSource);
test_inchemico24.setTitle("Water transport measurement");
test_inchemico24.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
test_inchemico24.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
test_inchemico24.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mid-term");

test_inchemico26 = new Test_InChemico(pathway, dataSource);
test_inchemico26.setTitle("Decreased Claudin-2");
test_inchemico26.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "tissue");
test_inchemico26.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
test_inchemico26.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mid-term");

test_invitro28 = new Test_InVitro(pathway, dataSource);
test_invitro28.setTitle("Increased lactate production");
test_invitro28.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
test_invitro28.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

test_inchemico30 = new Test_InChemico(pathway, dataSource);
test_inchemico30.setTitle("Mitochondrial Membrane Potential (MMP) - JC1 assay");
test_inchemico30.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organelle");
test_inchemico30.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
test_inchemico30.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");
test_inchemico30.getDescriptionIDs().set(new DescriptionSection(test_inchemico30,dataSource,"Assay Description","In-chemico test method description\n\n• Description of the principles of measurement\n\nJC-1 is a dye that fluorescent in the green range when monomeric and in the cytosol, and in the red range when polymerised in the mitochondria. It's aggregation is dependent on the MMP. Thus, the Red/Green ratio of the dye in a given cell population is indicative of the MMP.\n\n• Identification, amplification detection.\n\n• Dynamic range of detection\n\n• Number of runs/ controls\n\n...").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);

test_inchemico32 = new Test_InChemico(pathway, dataSource);
test_inchemico32.setTitle("Oxygen consumption (Seahorse assay)");
test_inchemico32.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organelle");
test_inchemico32.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
test_inchemico32.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");

test_invitro34 = new Test_InVitro(pathway, dataSource);
test_invitro34.setTitle("Increased HM0X1 mRNA and/or protein");
test_invitro34.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
test_invitro34.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

test_invitro36 = new Test_InVitro(pathway, dataSource);
test_invitro36.setTitle("GSH deplition in cells");
test_invitro36.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
test_invitro36.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

test_inchemico38 = new Test_InChemico(pathway, dataSource);
test_inchemico38.setTitle("DCF Activation");
test_inchemico38.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
test_inchemico38.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
test_inchemico38.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");

test_invitro40 = new Test_InVitro(pathway, dataSource);
test_invitro40.setTitle("GSH depletion in cell-free environment ");
test_invitro40.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
test_invitro40.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
test_invitro40.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "short-term");

link_chemstructtochemstruct2 = new Link_ChemStructToChemStruct(pathway, dataSource,initiator_chemicalstructure1, initiator_chemicalstructure3);
link_chemstructtochemstruct2.setLinkType(LinkType.UNKNOWN);link_chemstructtochemstruct2.getDescriptionIDs().set(new DescriptionSection(link_chemstructtochemstruct2,dataSource,"Abstract","Bioactivation description: the chemical is taken up in PT cells and can be measured in the intracellular compartment. ").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);

link_chemstructtomie4 = new Link_ChemStructToMIE(pathway, dataSource,initiator_chemicalstructure3, effect_molecularinitiatingevent5);
link_chemstructtomie4.setLinkType(LinkType.DIRECT);link_chemstructtomie4.getDescriptionIDs().set(new DescriptionSection(link_chemstructtomie4,dataSource,"Abstract","Molecular Interaction description: potassium bromate can directly oxidise molecules via its reactive oxygens. These oxidised molecules can themselves oxidise others and/or cause ROS production. This leads to a cascade of oxidation if not counteracted by antioxidants such as glutathione.").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);
link_chemstructtomie4.getDescriptionIDs().set(new DescriptionSection(link_chemstructtomie4,dataSource,"Evidence Supporting Taxonomic Applicability","Sumarise the available evidences.").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 1);
link_chemstructtomie4.getDescriptionIDs().set(new DescriptionSection(link_chemstructtomie4,dataSource,"Quantitative Understanding","Provide a summary of the quantitative understading available for this linkage.").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 2);

link_effecttoeffect6 = new Link_EffectToEffect(pathway, dataSource,effect_molecularinitiatingevent5, effect_downstreameffect7);
link_effecttoeffect6.setLinkType(LinkType.DIRECT);ReferenceIDW<Link_EffectToEffect> link_effecttoeffect6_weigth0= new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect6, dataSource, Link_EffectToEffect.class,0.0);
link_effecttoeffect6.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect6,dataSource,"(Key) Event Relationships Weight of Evidences","• Biological Plausibility: Glutathione (GSH) is the main endogenous antioxidant in mammalian cells. GSH is converted to GSSG in the process of reducing reactive species that direrctly cause oxidation. GSSG can be reduced back to GSH by enzymes. When the oxidation overcomes the recycling of GSSG to GSH, GSH levels drop.\n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect6_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);

link_effecttoeffect8 = new Link_EffectToEffect(pathway, dataSource,effect_downstreameffect7, effect_downstreameffect9);
link_effecttoeffect8.setLinkType(LinkType.UNKNOWN);ReferenceIDW<Link_EffectToEffect> link_effecttoeffect8_weigth1= new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect8, dataSource, Link_EffectToEffect.class,0.0);
link_effecttoeffect8.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect8,dataSource,"(Key) Event Relationship Weight of Evidence","• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect8_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);

link_effecttoeffect10 = new Link_EffectToEffect(pathway, dataSource,effect_downstreameffect9, effect_downstreameffect11);
link_effecttoeffect10.setLinkType(LinkType.UNKNOWN);ReferenceIDW<Link_EffectToEffect> link_effecttoeffect10_weigth1= new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect10, dataSource, Link_EffectToEffect.class,0.0);
link_effecttoeffect10.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect10,dataSource,"(Key) Event Relationship Weight of Evidence","• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect10_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);

link_effecttoeffect12 = new Link_EffectToEffect(pathway, dataSource,effect_downstreameffect11, effect_downstreameffect13);
link_effecttoeffect12.setLinkType(LinkType.UNKNOWN);ReferenceIDW<Link_EffectToEffect> link_effecttoeffect12_weigth1= new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect12, dataSource, Link_EffectToEffect.class,0.0);
link_effecttoeffect12.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect12,dataSource,"(Key) Event Relationship Weight of Evidence","• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect12_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);

link_effecttoeffect14 = new Link_EffectToEffect(pathway, dataSource,effect_downstreameffect13, effect_downstreameffect15);
link_effecttoeffect14.setLinkType(LinkType.UNKNOWN);ReferenceIDW<Link_EffectToEffect> link_effecttoeffect14_weigth1= new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect14, dataSource, Link_EffectToEffect.class,0.0);
link_effecttoeffect14.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect14,dataSource,"(Key) Event Relationship Weight of Evidence","• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect14_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);

link_effecttoeffect16 = new Link_EffectToEffect(pathway, dataSource,effect_downstreameffect15, effect_downstreameffect17);
link_effecttoeffect16.setLinkType(LinkType.UNKNOWN);ReferenceIDW<Link_EffectToEffect> link_effecttoeffect16_weigth0= new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect16, dataSource, Link_EffectToEffect.class,0.0);
link_effecttoeffect16.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect16,dataSource,"(Key) Event Relationships Weight of Evidences","• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect16_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);

link_effecttoeffect18 = new Link_EffectToEffect(pathway, dataSource,effect_downstreameffect17, effect_downstreameffect20);
link_effecttoeffect18.setLinkType(LinkType.UNKNOWN);ReferenceIDW<Link_EffectToEffect> link_effecttoeffect18_weigth0= new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect18, dataSource, Link_EffectToEffect.class,0.0);
link_effecttoeffect18.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect18,dataSource,"(Key) Event Relationships Weight of Evidences","• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect18_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);

link_effecttoeffect19 = new Link_EffectToEffect(pathway, dataSource,effect_downstreameffect17, effect_adverseoutcome21);
link_effecttoeffect19.setLinkType(LinkType.UNKNOWN);ReferenceIDW<Link_EffectToEffect> link_effecttoeffect19_weigth0= new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect19, dataSource, Link_EffectToEffect.class,0.0);
link_effecttoeffect19.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect19,dataSource,"(Key) Event Relationships Weight of Evidences","• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect19_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);

testresponsemapping23 = new TestResponseMapping(pathway, dataSource, test_inchemico24, effect_downstreameffect15);

testresponsemapping25 = new TestResponseMapping(pathway, dataSource, test_inchemico26, effect_downstreameffect15);

testresponsemapping27 = new TestResponseMapping(pathway, dataSource, test_invitro28, effect_downstreameffect13);

testresponsemapping29 = new TestResponseMapping(pathway, dataSource, test_inchemico30, effect_downstreameffect11);
testresponsemapping29.getDescriptionIDs().set(new DescriptionSection(testresponsemapping29,dataSource,"Abstract","JC-1  Red/Green ratio descreases when mitochondrial respiration is impaired and the MMP is not maintained.\n\nPositive control: treatment with antimycin A makes Red/Green ratio drop to 10-20% of control level.\n\n").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);

testresponsemapping31 = new TestResponseMapping(pathway, dataSource, test_inchemico32, effect_downstreameffect11);

testresponsemapping33 = new TestResponseMapping(pathway, dataSource, test_invitro34, effect_downstreameffect9);

testresponsemapping35 = new TestResponseMapping(pathway, dataSource, test_invitro36, effect_downstreameffect9);

testresponsemapping37 = new TestResponseMapping(pathway, dataSource, test_inchemico38, effect_downstreameffect7);
testresponsemapping37.getDescriptionIDs().set(new DescriptionSection(testresponsemapping37,dataSource,"Abstract"," Intracellular GSH is measured with the Promega kit (V6912) according to manufacturer's instructions in a multi-well plate reader. Cells are incubated with the test chemical for the desired amount of time, remaining endogenous GSH is measured and compared to the contents of control cells.\n\nResults are expressed as % control, calculated from luminescence measurements.").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);

testresponsemapping39 = new TestResponseMapping(pathway, dataSource, test_invitro40, effect_molecularinitiatingevent5);
testresponsemapping39.getDescriptionIDs().set(new DescriptionSection(testresponsemapping39,dataSource,"Abstract"," The chemical is incubated with GSH in a plastic well without any cells. Oxidative chemicals will depleted the given GSH over time. After 1h of incubation, the remaining GSH is measured by luminescence in a multi-well plate reader, following the protocol from Promega (kit V6912).").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);

pathway.getGroups().parseString("");
pathway.getUids().parseString("");
pathway.getStatus().parseString("");

pathway.updateEssentiality();
EssetialityDescription essentiality = pathway.getEssentiality();
DescriptionSection_Structured dss;
pathway.getDescriptionIDs().set(new DescriptionSection(pathway,dataSource,"Abstract","Adverse Outcom Pathway description\n\n").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);
dss = essentiality.getEssentialityDescription(effect_molecularinitiatingevent5);
dss.setContent("");
dss.setFormat(ContentFormat.TEXT);
((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
dss = essentiality.getEssentialityDescription(effect_downstreameffect7);
dss.setContent("");
dss.setFormat(ContentFormat.TEXT);
((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
dss = essentiality.getEssentialityDescription(effect_downstreameffect9);
dss.setContent("");
dss.setFormat(ContentFormat.TEXT);
((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
dss = essentiality.getEssentialityDescription(effect_downstreameffect11);
dss.setContent("");
dss.setFormat(ContentFormat.TEXT);
((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
dss = essentiality.getEssentialityDescription(effect_downstreameffect13);
dss.setContent("");
dss.setFormat(ContentFormat.TEXT);
((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
dss = essentiality.getEssentialityDescription(effect_downstreameffect15);
dss.setContent("");
dss.setFormat(ContentFormat.TEXT);
((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
dss = essentiality.getEssentialityDescription(effect_downstreameffect17);
dss.setContent("");
dss.setFormat(ContentFormat.TEXT);
((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
dss = essentiality.getEssentialityDescription(effect_downstreameffect20);
dss.setContent("");
dss.setFormat(ContentFormat.TEXT);
((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
dss = essentiality.getEssentialityDescription(effect_adverseoutcome21);
dss.setContent("");
dss.setFormat(ContentFormat.TEXT);
((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
dss = essentiality.getEssentialityDescription(effect_downstreameffect22);
dss.setContent("");
dss.setFormat(ContentFormat.TEXT);
((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
}
}

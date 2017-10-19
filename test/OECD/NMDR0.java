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

public class NMDR0	extends SourceGeneratedPathway {

public NMDR0(DataSource dataSource) {
super("Sample Pathway Title","",dataSource,"D://Java//org.qsari.effectopedia//test//Sample Pathway Title");
}
protected Initiator_ChemicalStructure initiator_chemicalstructure1;
protected Link_ChemStructToMIE link_chemstructtomie2;
protected Effect_MolecularInitiatingEvent effect_molecularinitiatingevent3;
protected Link_EffectToEffect link_effecttoeffect4;
protected Effect_DownstreamEffect effect_downstreameffect5;
protected Link_EffectToEffect link_effecttoeffect6;
protected Effect_DownstreamEffect effect_downstreameffect7;
protected Link_EffectToEffect link_effecttoeffect8;
protected Effect_DownstreamEffect effect_downstreameffect9;
protected Link_EffectToEffect link_effecttoeffect10;
protected Link_EffectToEffect link_effecttoeffect11;
protected Link_EffectToEffect link_effecttoeffect12;
protected Effect_DownstreamEffect effect_downstreameffect13;
protected Effect_DownstreamEffect effect_downstreameffect14;
protected Effect_DownstreamEffect effect_downstreameffect15;
protected Link_EffectToEffect link_effecttoeffect16;
protected Link_EffectToEffect link_effecttoeffect17;
protected Link_EffectToEffect link_effecttoeffect18;
protected Effect_DownstreamEffect effect_downstreameffect19;
protected Link_EffectToEffect link_effecttoeffect20;
protected Effect_DownstreamEffect effect_downstreameffect21;
protected Link_EffectToEffect link_effecttoeffect22;
protected Effect_AdverseOutcome effect_adverseoutcome23;
@Override
public void generateContent()
{genreateRevision1();
storeRevision();
((RevisionBasedDS) dataSource).setLocation(pathway);
}
public void genreateRevision1() {

initiator_chemicalstructure1 = new Initiator_ChemicalStructure(pathway, dataSource);
initiator_chemicalstructure1.setTitle("Lead acetate");
initiator_chemicalstructure1.getStructure2DImage().setValue("https://apps.ideaconsult.net/ambit2/depict/cdk?search=CC%28%3DO%29%5BO-%5D.CC%28%3DO%29%5BO-%5D.%5BPb%2B2%5D&w=200&h=200&media=image/png");
initiator_chemicalstructure1.getIdentification().setPropertyValue(0,"301042");
initiator_chemicalstructure1.getIdentification().setPropertyValue(1,"lead(2+);diacetate");
initiator_chemicalstructure1.getIdentification().setPropertyValue(2,"CC(=O)[O-].CC(=O)[O-].[Pb+2]");
initiator_chemicalstructure1.getIdentification().setPropertyValue(3,"InChI=1S/2C2H4O2.Pb/c2*1-2(3)4;/h2*1H3,(H,3,4);/q;;+2/p-2");
initiator_chemicalstructure1.getIdentification().setPropertyValue(4,"GUWSLQUAAYEZAF-UHFFFAOYSA-L");
initiator_chemicalstructure1.getIdentification().setPropertyValue(5," ");
initiator_chemicalstructure1.getIdentification().setPropertyValue(6,"");
initiator_chemicalstructure1.setSynonymsList(new String[] {" "});

effect_molecularinitiatingevent3 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
effect_molecularinitiatingevent3.setTitle("NMDARs, Binding of antagonist");
effect_molecularinitiatingevent3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
effect_molecularinitiatingevent3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

effect_downstreameffect5 = new Effect_DownstreamEffect(pathway, dataSource);
effect_downstreameffect5.setTitle("NMDARs, Inhibition");
effect_downstreameffect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
effect_downstreameffect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
effect_downstreameffect5.getDescriptionIDs().set(new DescriptionSection(effect_downstreameffect5,dataSource,"Definition","Provide brief description of the (key) event\n\n").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);

effect_downstreameffect7 = new Effect_DownstreamEffect(pathway, dataSource);
effect_downstreameffect7.setTitle("Calcium influx, Decreased");
effect_downstreameffect7.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
effect_downstreameffect7.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

effect_downstreameffect9 = new Effect_DownstreamEffect(pathway, dataSource);
effect_downstreameffect9.setTitle("Release of BDNF, Reduced");
effect_downstreameffect9.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
effect_downstreameffect9.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

effect_downstreameffect13 = new Effect_DownstreamEffect(pathway, dataSource);
effect_downstreameffect13.setTitle("Cell death, N/A");
effect_downstreameffect13.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
effect_downstreameffect13.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

effect_downstreameffect14 = new Effect_DownstreamEffect(pathway, dataSource);
effect_downstreameffect14.setTitle("Presynaptic release of glutamate, Reduced");
effect_downstreameffect14.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
effect_downstreameffect14.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

effect_downstreameffect15 = new Effect_DownstreamEffect(pathway, dataSource);
effect_downstreameffect15.setTitle("Dendritic morphology, Aberrant");
effect_downstreameffect15.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
effect_downstreameffect15.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

effect_downstreameffect19 = new Effect_DownstreamEffect(pathway, dataSource);
effect_downstreameffect19.setTitle("Synaptogenesis, Decreased");
effect_downstreameffect19.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
effect_downstreameffect19.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

effect_downstreameffect21 = new Effect_DownstreamEffect(pathway, dataSource);
effect_downstreameffect21.setTitle("Neuronal network function, Decreased");
effect_downstreameffect21.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
effect_downstreameffect21.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

effect_adverseoutcome23 = new Effect_AdverseOutcome(pathway, dataSource);
effect_adverseoutcome23.setTitle("Learning and memory, Impairment");
effect_adverseoutcome23.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
effect_adverseoutcome23.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

link_chemstructtomie2 = new Link_ChemStructToMIE(pathway, dataSource,initiator_chemicalstructure1, effect_molecularinitiatingevent3);
link_chemstructtomie2.setLinkType(LinkType.UNKNOWN);
link_effecttoeffect4 = new Link_EffectToEffect(pathway, dataSource,effect_molecularinitiatingevent3, effect_downstreameffect5);
link_effecttoeffect4.setLinkType(LinkType.UNKNOWN);ReferenceIDW<Link_EffectToEffect> link_effecttoeffect4_weigth1= new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect4, dataSource, Link_EffectToEffect.class,0.0);
link_effecttoeffect4.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect4,dataSource,"(Key) Event Relationship Weight of Evidence","• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect4_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
link_effecttoeffect4.getDescriptionIDs().set(new DescriptionSection(link_effecttoeffect4,dataSource,"Evidence Supporting Taxonomic Applicability","Sumarise the available evidences.\n\nThe biophysical properties of rat and human receptors have been mostly assessed through recombinant studies, whereas the pharmacological properties of rat and human NMDA receptors have not been fully explored and compared yet (Hedegaard et al., 2012). Mean channel open times for human NMDA receptor subtypes in recombinant protein studies are similar to those of the corresponding rat NMDA receptor subtypes. However, mean single-channel conductances for human NMDA receptor subtypes appear lower than those of the corresponding rat NMDA receptor subtypes. Regarding pharmacological properties of the receptors, the differences were less than 2-fold and were not observed at the same subtypes for all the antagonists tested, suggesting that the molecular pharmacology of NMDA receptor is conserved between human and rat, although some inter-species differences are seen in IC50 values using two-electrode voltage-clamp recordings (Hedegaard et al., 2012),").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 2);

link_effecttoeffect6 = new Link_EffectToEffect(pathway, dataSource,effect_downstreameffect5, effect_downstreameffect7);
link_effecttoeffect6.setLinkType(LinkType.UNKNOWN);ReferenceIDW<Link_EffectToEffect> link_effecttoeffect6_weigth1= new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect6, dataSource, Link_EffectToEffect.class,0.0);
link_effecttoeffect6.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect6,dataSource,"(Key) Event Relationship Weight of Evidence","• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect6_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
link_effecttoeffect6.getDescriptionIDs().set(new DescriptionSection(link_effecttoeffect6,dataSource,"Evidence Supporting Taxonomic Applicability","Sumarise the available evidences.\n\nBesides the above studies described in rodents, intracellular Ca2+ regulation has been studied at the neuromuscular junction of larval Drosophila exposed to 0, 100 μM or 250 μM Pb2+ (He et al., 2009).").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 2);

link_effecttoeffect8 = new Link_EffectToEffect(pathway, dataSource,effect_downstreameffect7, effect_downstreameffect9);
link_effecttoeffect8.setLinkType(LinkType.UNKNOWN);ReferenceIDW<Link_EffectToEffect> link_effecttoeffect8_weigth1= new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect8, dataSource, Link_EffectToEffect.class,0.0);
link_effecttoeffect8.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect8,dataSource,"(Key) Event Relationship Weight of Evidence","• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect8_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);

link_effecttoeffect10 = new Link_EffectToEffect(pathway, dataSource,effect_downstreameffect9, effect_downstreameffect13);
link_effecttoeffect10.setLinkType(LinkType.UNKNOWN);ReferenceIDW<Link_EffectToEffect> link_effecttoeffect10_weigth1= new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect10, dataSource, Link_EffectToEffect.class,0.0);
link_effecttoeffect10.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect10,dataSource,"(Key) Event Relationship Weight of Evidence","• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect10_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);

link_effecttoeffect11 = new Link_EffectToEffect(pathway, dataSource,effect_downstreameffect9, effect_downstreameffect14);
link_effecttoeffect11.setLinkType(LinkType.UNKNOWN);ReferenceIDW<Link_EffectToEffect> link_effecttoeffect11_weigth1= new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect11, dataSource, Link_EffectToEffect.class,0.0);
link_effecttoeffect11.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect11,dataSource,"(Key) Event Relationship Weight of Evidence","• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect11_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);

link_effecttoeffect12 = new Link_EffectToEffect(pathway, dataSource,effect_downstreameffect9, effect_downstreameffect15);
link_effecttoeffect12.setLinkType(LinkType.UNKNOWN);ReferenceIDW<Link_EffectToEffect> link_effecttoeffect12_weigth1= new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect12, dataSource, Link_EffectToEffect.class,0.0);
link_effecttoeffect12.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect12,dataSource,"(Key) Event Relationship Weight of Evidence","• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect12_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);

link_effecttoeffect16 = new Link_EffectToEffect(pathway, dataSource,effect_downstreameffect13, effect_downstreameffect19);
link_effecttoeffect16.setLinkType(LinkType.UNKNOWN);ReferenceIDW<Link_EffectToEffect> link_effecttoeffect16_weigth1= new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect16, dataSource, Link_EffectToEffect.class,0.0);
link_effecttoeffect16.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect16,dataSource,"(Key) Event Relationship Weight of Evidence","• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect16_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);

link_effecttoeffect17 = new Link_EffectToEffect(pathway, dataSource,effect_downstreameffect14, effect_downstreameffect19);
link_effecttoeffect17.setLinkType(LinkType.UNKNOWN);ReferenceIDW<Link_EffectToEffect> link_effecttoeffect17_weigth1= new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect17, dataSource, Link_EffectToEffect.class,0.0);
link_effecttoeffect17.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect17,dataSource,"(Key) Event Relationship Weight of Evidence","• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect17_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);

link_effecttoeffect18 = new Link_EffectToEffect(pathway, dataSource,effect_downstreameffect15, effect_downstreameffect19);
link_effecttoeffect18.setLinkType(LinkType.UNKNOWN);ReferenceIDW<Link_EffectToEffect> link_effecttoeffect18_weigth1= new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect18, dataSource, Link_EffectToEffect.class,0.0);
link_effecttoeffect18.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect18,dataSource,"(Key) Event Relationship Weight of Evidence","• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect18_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);

link_effecttoeffect20 = new Link_EffectToEffect(pathway, dataSource,effect_downstreameffect19, effect_downstreameffect21);
link_effecttoeffect20.setLinkType(LinkType.UNKNOWN);ReferenceIDW<Link_EffectToEffect> link_effecttoeffect20_weigth1= new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect20, dataSource, Link_EffectToEffect.class,0.0);
link_effecttoeffect20.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect20,dataSource,"(Key) Event Relationship Weight of Evidence","• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect20_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);

link_effecttoeffect22 = new Link_EffectToEffect(pathway, dataSource,effect_downstreameffect21, effect_adverseoutcome23);
link_effecttoeffect22.setLinkType(LinkType.UNKNOWN);ReferenceIDW<Link_EffectToEffect> link_effecttoeffect22_weigth1= new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect22, dataSource, Link_EffectToEffect.class,0.0);
link_effecttoeffect22.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect22,dataSource,"(Key) Event Relationship Weight of Evidence","• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect22_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);

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
dss = essentiality.getEssentialityDescription(effect_downstreameffect13);
dss.setContent("Section content");
dss.setFormat(ContentFormat.TEXT);
((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
dss = essentiality.getEssentialityDescription(effect_downstreameffect14);
dss.setContent("Section content");
dss.setFormat(ContentFormat.TEXT);
((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
dss = essentiality.getEssentialityDescription(effect_downstreameffect15);
dss.setContent("Section content");
dss.setFormat(ContentFormat.TEXT);
((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
dss = essentiality.getEssentialityDescription(effect_downstreameffect19);
dss.setContent("Section content");
dss.setFormat(ContentFormat.TEXT);
((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
dss = essentiality.getEssentialityDescription(effect_downstreameffect21);
dss.setContent("Section content");
dss.setFormat(ContentFormat.TEXT);
((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
dss = essentiality.getEssentialityDescription(effect_adverseoutcome23);
dss.setContent("Section content");
dss.setFormat(ContentFormat.TEXT);
((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
}
}

package org.qsari.effectopedia.data.generated;
import org.qsari.effectopedia.base.ids.ReferenceIDW;
import org.qsari.effectopedia.core.object.elemets.EssetialityDescription;
import org.qsari.effectopedia.core.objects.DescriptionSection.ContentFormat;
import org.qsari.effectopedia.core.objects.DescriptionSection_Structured;
import org.qsari.effectopedia.core.objects.Effect_AdverseOutcome;
import org.qsari.effectopedia.core.objects.Effect_DownstreamEffect;
import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.Link.LinkType;
import org.qsari.effectopedia.core.objects.Link_ChemStructToMIE;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.core.objects.Test_InVitro;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.RevisionBasedDS;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public class generated	extends SourceGeneratedPathway {

public generated(DataSource dataSource) {
super("AOP of proximal tubule injury mediated by lysosomal overload","",dataSource,"D://Java//org.qsari.effectopedia//test//AOP of proximal tubule injury mediated by lysosomal overload");
}
protected Initiator_ChemicalStructure initiator_chemicalstructure1;
protected Link_ChemStructToMIE link_chemstructtomie2;
protected Effect_MolecularInitiatingEvent effect_molecularinitiatingevent3;
protected Link_EffectToEffect link_effecttoeffect4;
protected Effect_DownstreamEffect effect_downstreameffect5;
protected Link_EffectToEffect link_effecttoeffect6;
protected Effect_DownstreamEffect effect_downstreameffect7;
protected Link_EffectToEffect link_effecttoeffect8;
protected Effect_AdverseOutcome effect_adverseoutcome9;
protected Initiator_ChemicalStructure initiator_chemicalstructure10;
protected Link_ChemStructToMIE link_chemstructtomie11;
protected Initiator_ChemicalStructure initiator_chemicalstructure12;
protected Link_ChemStructToMIE link_chemstructtomie13;
protected TestResponseMapping testresponsemapping14;
protected Test_InVitro test_invitro15;
protected Test_InVitro test_invitro16;
protected TestResponseMapping testresponsemapping17;
protected Test_InVitro test_invitro18;
protected TestResponseMapping testresponsemapping19;
@Override
public void generateContent()
{genreateRevision1();
storeRevision();
((RevisionBasedDS) dataSource).setLocation(pathway);
}
public void genreateRevision1() {

initiator_chemicalstructure1 = new Initiator_ChemicalStructure(pathway, dataSource);
initiator_chemicalstructure1.setTitle("Colistin");
initiator_chemicalstructure1.getStructure2DImage().setValue("https://apps.ideaconsult.net/ambit2/depict/cdk?search=CCC%28C%29CCCC%28%3DO%29N%5BC%40%40H%5D%28CCN%29C%28%3DO%29N%5BC%40%40H%5D%28%5BC%40%40H%5D%28C%29O%29C%28%3DO%29N%5BC%40%40H%5D%28CCN%29C%28%3DO%29N%5BC%40H%5D1CCNC%28%3DO%29%5BC%40%40H%5D%28NC%28%3DO%29%5BC%40%40H%5D%28NC%28%3DO%29%5BC%40%40H%5D%28NC%28%3DO%29%5BC%40%40H%5D%28NC%28%3DO%29%5BC%40H%5D%28NC%28%3DO%29%5BC%40%40H%5D%28NC1%3DO%29CCN%29CC%28C%29C%29CC%28C%29C%29CCN%29CCN%29%5BC%40%40H%5D%28C%29O&w=200&h=200&media=image/png");
initiator_chemicalstructure1.getIdentification().setPropertyValue(0,"1066177");
initiator_chemicalstructure1.getIdentification().setPropertyValue(1,"N-[(2S)-4-amino-1-[[(2S,3R)-1-[[(2S)-4-amino-1-oxo-1-[[(3S,6S,9S,12S,15R,18S,21S)-6,9,18-tris(2-aminoethyl)-3-[(1R)-1-hydroxyethyl]-12,15-bis(2-methylpropyl)-2,5,8,11,14,17,20-heptaoxo-1,4,7,10,13,16,19-heptazacyclotricos-21-yl]amino]butan-2-yl]amino]-3-hydroxy-1-oxobutan-2-yl]amino]-1-oxobutan-2-yl]-5-methylheptanamide");
initiator_chemicalstructure1.getIdentification().setPropertyValue(2,"CCC(C)CCCC(=O)N[C@@H](CCN)C(=O)N[C@@H]([C@@H](C)O)C(=O)N[C@@H](CCN)C(=O)N[C@H]1CCNC(=O)[C@@H](NC(=O)[C@@H](NC(=O)[C@@H](NC(=O)[C@@H](NC(=O)[C@H](NC(=O)[C@@H](NC1=O)CCN)CC(C)C)CC(C)C)CCN)CCN)[C@@H](C)O");
initiator_chemicalstructure1.getIdentification().setPropertyValue(3," ");
initiator_chemicalstructure1.getIdentification().setPropertyValue(4,"YKQOSKADJPQZHB-QNPLFGSASA-N");
initiator_chemicalstructure1.getIdentification().setPropertyValue(5," ");
initiator_chemicalstructure1.getIdentification().setPropertyValue(6,"C52H98N16O13");
initiator_chemicalstructure1.setSynonymsList(new String[] {" Colimycin", "Colisticin", "Colistin", "Colistin Sulfate", "Coly-Mycin", "Polymyxin E", "Sulfate, Colistin", "Totazina"});

effect_molecularinitiatingevent3 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
effect_molecularinitiatingevent3.setTitle("Binding to Megalin / Cubilin Complex");
effect_molecularinitiatingevent3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
effect_molecularinitiatingevent3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

effect_downstreameffect5 = new Effect_DownstreamEffect(pathway, dataSource);
effect_downstreameffect5.setTitle("Lysosomal Swelling");
effect_downstreameffect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organelle");
effect_downstreameffect5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

effect_downstreameffect7 = new Effect_DownstreamEffect(pathway, dataSource);
effect_downstreameffect7.setTitle("Cytotox");
effect_downstreameffect7.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
effect_downstreameffect7.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

effect_adverseoutcome9 = new Effect_AdverseOutcome(pathway, dataSource);
effect_adverseoutcome9.setTitle("Kidney Injury");
effect_adverseoutcome9.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
effect_adverseoutcome9.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

initiator_chemicalstructure10 = new Initiator_ChemicalStructure(pathway, dataSource);
initiator_chemicalstructure10.setTitle("Polymyxin B");
initiator_chemicalstructure10.getStructure2DImage().setValue("https://apps.ideaconsult.net/ambit2/depict/cdk?search=CCC%28C%29CCCCC%28%3DO%29N%5BC%40%40H%5D%28CCN%29C%28%3DO%29N%5BC%40%40H%5D%28%5BC%40%40H%5D%28C%29O%29C%28%3DO%29N%5BC%40%40H%5D%28CCN%29C%28%3DO%29N%5BC%40H%5D1CCNC%28%3DO%29%5BC%40%40H%5D%28NC%28%3DO%29%5BC%40%40H%5D%28NC%28%3DO%29%5BC%40%40H%5D%28NC%28%3DO%29%5BC%40%40H%5D%28NC%28%3DO%29%5BC%40H%5D%28NC%28%3DO%29%5BC%40H%5D%28NC1%3DO%29CCN%29CC2%3DCC%3DCC%3DC2%29CC%28C%29C%29CCN%29CCN%29%5BC%40%40H%5D%28C%29O&w=200&h=200&media=image/png");
initiator_chemicalstructure10.getIdentification().setPropertyValue(0,"1405205");
initiator_chemicalstructure10.getIdentification().setPropertyValue(1,"N-[(2S)-4-amino-1-[[(2S,3R)-1-[[(2S)-4-amino-1-oxo-1-[[(3S,6S,9S,12S,15R,18R,21S)-6,9,18-tris(2-aminoethyl)-15-benzyl-3-[(1R)-1-hydroxyethyl]-12-(2-methylpropyl)-2,5,8,11,14,17,20-heptaoxo-1,4,7,10,13,16,19-heptazacyclotricos-21-yl]amino]butan-2-yl]amino]-3-hydroxy-1-oxobutan-2-yl]amino]-1-oxobutan-2-yl]-6-methyloctanamide");
initiator_chemicalstructure10.getIdentification().setPropertyValue(2,"CCC(C)CCCCC(=O)N[C@@H](CCN)C(=O)N[C@@H]([C@@H](C)O)C(=O)N[C@@H](CCN)C(=O)N[C@H]1CCNC(=O)[C@@H](NC(=O)[C@@H](NC(=O)[C@@H](NC(=O)[C@@H](NC(=O)[C@H](NC(=O)[C@H](NC1=O)CCN)CC2=CC=CC=C2)CC(C)C)CCN)CCN)[C@@H](C)O");
initiator_chemicalstructure10.getIdentification().setPropertyValue(3,"InChI=1S/C56H98N16O13/c1-7-32(4)13-11-12-16-44(75)63-36(17-23-57)51(80)72-46(34(6)74)56(85)68-39(20-26-60)48(77)67-41-22-28-62-55(84)45(33(5)73)71-52(81)40(21-27-61)65-47(76)37(18-24-58)66-53(82)42(29-31(2)3)69-54(83)43(30-35-14-9-8-10-15-35)70-49(78)38(19-25-59)64-50(41)79/h8-10,14-15,31-34,36-43,45-46,73-74H,7,11-13,16-30,57-61H2,1-6H3,(H,62,84)(H,63,75)(H,64,79)(H,65,76)(H,66,82)(H,67,77)(H,68,85)(H,69,83)(H,70,78)(H,71,81)(H,72,80)/t32?,33-,34-,36+,37+,38-,39+,40+,41+,42+,43-,45+,46+/m1/s1");
initiator_chemicalstructure10.getIdentification().setPropertyValue(4,"WQVJHHACXVLGBL-BPJDFBQWSA-N");
initiator_chemicalstructure10.getIdentification().setPropertyValue(5," ");
initiator_chemicalstructure10.getIdentification().setPropertyValue(6,"C56H98N16O13");
initiator_chemicalstructure10.setSynonymsList(new String[] {" Aerosporin", "Polymyxin B", "Polymyxin B Sulfate", "Sulfate, Polymyxin B"});

initiator_chemicalstructure12 = new Initiator_ChemicalStructure(pathway, dataSource);
initiator_chemicalstructure12.setTitle("Polymyxin B Nonapeptide");
initiator_chemicalstructure12.getStructure2DImage().setValue("https://apps.ideaconsult.net/ambit2/depict/cdk?search=C%5BC%40H%5D%28%5BC%40H%5D1C%28%3DO%29NCC%5BC%40%40H%5D%28C%28%3DO%29N%5BC%40H%5D%28C%28%3DO%29N%5BC%40%40H%5D%28C%28%3DO%29N%5BC%40H%5D%28C%28%3DO%29N%5BC%40H%5D%28C%28%3DO%29N%5BC%40H%5D%28C%28%3DO%29N1%29CCN%29CCN%29CC%28C%29C%29CC2%3DCC%3DCC%3DC2%29CCN%29NC%28%3DO%29%5BC%40H%5D%28CCN%29NC%28%3DO%29%5BC%40H%5D%28%5BC%40%40H%5D%28C%29O%29N%29O&w=200&h=200&media=image/png");
initiator_chemicalstructure12.getIdentification().setPropertyValue(0,"86408368");
initiator_chemicalstructure12.getIdentification().setPropertyValue(1,"(2S,3R)-2-amino-N-[(2S)-4-amino-1-oxo-1-[[(3S,6S,9S,12S,15R,18S,21S)-6,9,18-tris(2-aminoethyl)-15-benzyl-3-[(1R)-1-hydroxyethyl]-12-(2-methylpropyl)-2,5,8,11,14,17,20-heptaoxo-1,4,7,10,13,16,19-heptazacyclotricos-21-yl]amino]butan-2-yl]-3-hydroxybutanamide");
initiator_chemicalstructure12.getIdentification().setPropertyValue(2,"C[C@H]([C@H]1C(=O)NCC[C@@H](C(=O)N[C@H](C(=O)N[C@@H](C(=O)N[C@H](C(=O)N[C@H](C(=O)N[C@H](C(=O)N1)CCN)CCN)CC(C)C)CC2=CC=CC=C2)CCN)NC(=O)[C@H](CCN)NC(=O)[C@H]([C@@H](C)O)N)O");
initiator_chemicalstructure12.getIdentification().setPropertyValue(3,"InChI=1S/C43H74N14O11/c1-22(2)20-31-40(65)52-26(10-15-44)35(60)51-29(13-18-47)39(64)57-34(24(4)59)43(68)49-19-14-30(53-36(61)28(12-17-46)54-42(67)33(48)23(3)58)38(63)50-27(11-16-45)37(62)56-32(41(66)55-31)21-25-8-6-5-7-9-25/h5-9,22-24,26-34,58-59H,10-21,44-48H2,1-4H3,(H,49,68)(H,50,63)(H,51,60)(H,52,65)(H,53,61)(H,54,67)(H,55,66)(H,56,62)(H,57,64)/t23-,24-,26+,27+,28+,29+,30+,31+,32-,33+,34+/m1/s1");
initiator_chemicalstructure12.getIdentification().setPropertyValue(4,"PYHYGIPVYYRJHU-QWDNBKTCSA-N");
initiator_chemicalstructure12.getIdentification().setPropertyValue(5," ");
initiator_chemicalstructure12.getIdentification().setPropertyValue(6,"C43H74N14O11");
initiator_chemicalstructure12.setSynonymsList(new String[] {" PMBN", "polymyxin B cyclononapeptide", "polymyxin B nonapeptide"});

test_invitro15 = new Test_InVitro(pathway, dataSource);
test_invitro15.setTitle("Lysosomal swelling");
test_invitro15.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organelle");
test_invitro15.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

test_invitro16 = new Test_InVitro(pathway, dataSource);
test_invitro16.setTitle("Cytotoxicity in human proximal tubule cells (RPTEC/TERT1)");
test_invitro16.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
test_invitro16.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

test_invitro18 = new Test_InVitro(pathway, dataSource);
test_invitro18.setTitle("Cytotoxicity in rat kidney cells (NRK-52E)");
test_invitro18.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
test_invitro18.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

link_chemstructtomie2 = new Link_ChemStructToMIE(pathway, dataSource,initiator_chemicalstructure1, effect_molecularinitiatingevent3);
link_chemstructtomie2.setLinkType(LinkType.UNKNOWN);
link_effecttoeffect4 = new Link_EffectToEffect(pathway, dataSource,effect_molecularinitiatingevent3, effect_downstreameffect5);
link_effecttoeffect4.setLinkType(LinkType.UNKNOWN);ReferenceIDW<Link_EffectToEffect> link_effecttoeffect4_weigth1= new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect4, dataSource, Link_EffectToEffect.class,0.0);
link_effecttoeffect4.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect4,dataSource,"(Key) Event Relationship Weight of Evidence","• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect4_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);

link_effecttoeffect6 = new Link_EffectToEffect(pathway, dataSource,effect_downstreameffect5, effect_downstreameffect7);
link_effecttoeffect6.setLinkType(LinkType.UNKNOWN);ReferenceIDW<Link_EffectToEffect> link_effecttoeffect6_weigth1= new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect6, dataSource, Link_EffectToEffect.class,0.0);
link_effecttoeffect6.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect6,dataSource,"(Key) Event Relationship Weight of Evidence","• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect6_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);

link_effecttoeffect8 = new Link_EffectToEffect(pathway, dataSource,effect_downstreameffect7, effect_adverseoutcome9);
link_effecttoeffect8.setLinkType(LinkType.UNKNOWN);ReferenceIDW<Link_EffectToEffect> link_effecttoeffect8_weigth1= new ReferenceIDW<Link_EffectToEffect>(link_effecttoeffect8, dataSource, Link_EffectToEffect.class,0.0);
link_effecttoeffect8.getDescriptionIDs().set(new DescriptionSection_Structured(link_effecttoeffect8,dataSource,"(Key) Event Relationship Weight of Evidence","• Biological Plausibility: \n\n• Empirical Support for Linkage:\n\n• Uncertainties or Inconsistencies:\n\n", link_effecttoeffect8_weigth1).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);

link_chemstructtomie11 = new Link_ChemStructToMIE(pathway, dataSource,initiator_chemicalstructure10, effect_molecularinitiatingevent3);
link_chemstructtomie11.setLinkType(LinkType.UNKNOWN);
link_chemstructtomie13 = new Link_ChemStructToMIE(pathway, dataSource,initiator_chemicalstructure12, effect_molecularinitiatingevent3);
link_chemstructtomie13.setLinkType(LinkType.UNKNOWN);
testresponsemapping14 = new TestResponseMapping(pathway, dataSource, test_invitro15, effect_downstreameffect5);

testresponsemapping17 = new TestResponseMapping(pathway, dataSource, test_invitro16, effect_downstreameffect7);

testresponsemapping19 = new TestResponseMapping(pathway, dataSource, test_invitro18, effect_downstreameffect7);

pathway.updateEssentiality();
EssetialityDescription essentiality = pathway.getEssentiality();
DescriptionSection_Structured dss;
dss = essentiality.getEssentialityDescription(effect_molecularinitiatingevent3);
dss.setContent("");
dss.setFormat(ContentFormat.TEXT);
((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
dss = essentiality.getEssentialityDescription(effect_downstreameffect5);
dss.setContent("");
dss.setFormat(ContentFormat.TEXT);
((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
dss = essentiality.getEssentialityDescription(effect_downstreameffect7);
dss.setContent("");
dss.setFormat(ContentFormat.TEXT);
((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
dss = essentiality.getEssentialityDescription(effect_adverseoutcome9);
dss.setContent("");
dss.setFormat(ContentFormat.TEXT);
((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
}
}

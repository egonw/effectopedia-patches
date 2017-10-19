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
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.Reference;
import org.qsari.effectopedia.core.objects.SubstanceData_InSilico;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.core.objects.Test_ExVivo;
import org.qsari.effectopedia.core.objects.Test_InSilico;
import org.qsari.effectopedia.core.objects.Test_InVitro;
import org.qsari.effectopedia.core.objects.Test_InVivo;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.DataUnit;
import org.qsari.effectopedia.data.objects.DataValue_Double;
import org.qsari.effectopedia.data.objects.DataValue_String;
import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.objects.ObjectPropertyType;
import org.qsari.effectopedia.data.objects.Resource;
import org.qsari.effectopedia.data.quantification.DataTemplates;
import org.qsari.effectopedia.defaults.DefaultDataTemplates;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.system.ActionTypes;

public class QAOP_AromataseInhibitionPR extends SourceGeneratedPathway
	{
		
		public QAOP_AromataseInhibitionPR(DataSource dataSource)
			{
				super("Aromatase inhibition leading to population reduction", "aromatase inhibition,reproductive impairment", dataSource, "D://Java//org.qsari.effectopedia//test//AromataseInhibitiopnPR");
			}
			
		// revision 1
		protected Initiator_ChemicalStructure					chemical1;
		protected Effect_MolecularInitiatingEvent	mie1;
		protected Effect_DownstreamEffect									cellular_effect1;
		protected Effect_DownstreamEffect									organ_effect1;
		protected Effect_DownstreamEffect									organ_effect2;
		protected Effect_DownstreamEffect									organ_effect3;
		protected Effect_DownstreamEffect									organ_effect4;
		protected Effect_DownstreamEffect									individual_effect1;
		protected Effect_AdverseOutcome											population_adverseOutcome;
		// revision 2
		protected Test_InVitro																				mie1test1;
		protected Test_InVivo																					mie1test2;
		protected Test_ExVivo																					mie1test3;
		protected Test_InSilico																			mie1test4;
		protected Test_ExVivo																					cellular_effect1test1;
		protected Test_InSilico																			cellular_effect1test2;
		protected Test_InVivo																					organ_effect1test1;
		protected Test_InSilico																			organ_effect1test2;
		protected Test_InVivo																					organ_effect2test1;
		protected Test_InSilico																			organ_effect2test2;
		protected Test_InVivo																					organ_effect3test1;
		protected Test_InSilico																			organ_effect3test2;
		protected Test_InVivo																					organ_effect4test1;
		protected Test_InSilico																			organ_effect4test2;
		protected Test_InVivo																					individual_effect1test1;
		protected Test_InSilico																			individual_effect1test2;
		protected Test_InSilico																			population_adverseOutcome_test1;
		
		// revision 5
		protected Test_InVitro																				mie1test5;
		protected Test_InVitro																				mie1test6;
		
		// revision 6
		protected Method_InSilicoGlobalModel						gm1;
		protected SubstanceData_InSilico										subst_data1s;
		
		// revision 9
		protected Link_EffectToEffect													mie1_to_cellular_effect1;
		protected Link_EffectToEffect													cellular_effect1_to_organ_effect1;
		protected Link_EffectToEffect													organ_effect1_to_organ_effect2;
		protected Link_EffectToEffect													organ_effect2_to_organ_effect3;
		protected Link_EffectToEffect													organ_effect3_to_organ_effect4;
		protected Link_EffectToEffect													organ_effect4_to_individual_effect1;
		protected Link_EffectToEffect													individual_effect1_to_population_adverseOutcome;
		
		@Override
		public void generateContent()
			{
				genreateRevision1();
				storeRevision();
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
			}
			
		public void genreateRevision1()
			{
				
				chemical1 = new Initiator_ChemicalStructure(pathway, dataSource);
				
				mie1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie1.setTitle("Aromatase inhibition");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie1);
				
				cellular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect1.setTitle("Reduced E2 Synthesis");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				mie1_to_cellular_effect1 = new Link_EffectToEffect(pathway, dataSource, mie1, cellular_effect1);
				
				organ_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect1.setTitle("Reduced E2 Concentration");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				organ_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect2.setTitle("Reduced Vtg Expression");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				organ_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect3.setTitle("Reduced circulating Vtg concentrations");
				organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				organ_effect4 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect4.setTitle("Reduced Vtg uptake");
				organ_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				cellular_effect1_to_organ_effect1 = new Link_EffectToEffect(pathway, dataSource, cellular_effect1, organ_effect1);
				organ_effect1_to_organ_effect2 = new Link_EffectToEffect(pathway, dataSource, organ_effect1, organ_effect2);
				organ_effect2_to_organ_effect3 = new Link_EffectToEffect(pathway, dataSource, organ_effect2, organ_effect3);
				organ_effect3_to_organ_effect4 = new Link_EffectToEffect(pathway, dataSource, organ_effect3, organ_effect4);
				
				individual_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				individual_effect1.setTitle("Decreased spawning and cumulative fecundity");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				organ_effect4_to_individual_effect1 = new Link_EffectToEffect(pathway, dataSource, organ_effect4, individual_effect1);
				
				population_adverseOutcome = (Effect_AdverseOutcome) searchEffectByTitle(dataSource, "Population reduction");
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
					
				individual_effect1_to_population_adverseOutcome = (Link_EffectToEffect) Pathway.getDirektLink(individual_effect1, population_adverseOutcome);
				if (individual_effect1_to_population_adverseOutcome != null)
					pathway.add(individual_effect1_to_population_adverseOutcome);
				else
					individual_effect1_to_population_adverseOutcome = new Link_EffectToEffect(pathway, dataSource, individual_effect1, population_adverseOutcome);
			}
			
		public void genreateRevision2()
			{
				mie1test1 = new Test_InVitro(pathway, dataSource);
				mie1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie1test2 = new Test_InVivo(pathway, dataSource);
				mie1test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie1test3 = new Test_ExVivo(pathway, dataSource);
				mie1test3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1test3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie1test4 = new Test_InSilico(pathway, dataSource);
				mie1test4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1test4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new TestResponseMapping(pathway, dataSource, mie1test1, mie1);
				new TestResponseMapping(pathway, dataSource, mie1test2, mie1);
				new TestResponseMapping(pathway, dataSource, mie1test3, mie1);
				new TestResponseMapping(pathway, dataSource, mie1test4, mie1);
				
				cellular_effect1test1 = new Test_ExVivo(pathway, dataSource);
				cellular_effect1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				cellular_effect1test2 = new Test_InSilico(pathway, dataSource);
				cellular_effect1test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				new TestResponseMapping(pathway, dataSource, cellular_effect1test1, cellular_effect1);
				new TestResponseMapping(pathway, dataSource, cellular_effect1test2, cellular_effect1);
				
				organ_effect1test1 = new Test_InVivo(pathway, dataSource);
				organ_effect1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				organ_effect1test2 = new Test_InSilico(pathway, dataSource);
				organ_effect1test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect1test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				organ_effect2test1 = new Test_InVivo(pathway, dataSource);
				organ_effect2test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect2test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				organ_effect2test2 = new Test_InSilico(pathway, dataSource);
				organ_effect2test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect2test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				organ_effect3test1 = new Test_InVivo(pathway, dataSource);
				organ_effect3test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect3test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				organ_effect3test2 = new Test_InSilico(pathway, dataSource);
				organ_effect3test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect3test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				organ_effect4test1 = new Test_InVivo(pathway, dataSource);
				organ_effect4test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect4test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				organ_effect4test2 = new Test_InSilico(pathway, dataSource);
				organ_effect4test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect4test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				new TestResponseMapping(pathway, dataSource, organ_effect1test1, organ_effect1);
				new TestResponseMapping(pathway, dataSource, organ_effect1test2, organ_effect1);
				new TestResponseMapping(pathway, dataSource, organ_effect2test1, organ_effect2);
				new TestResponseMapping(pathway, dataSource, organ_effect2test2, organ_effect2);
				new TestResponseMapping(pathway, dataSource, organ_effect3test1, organ_effect3);
				new TestResponseMapping(pathway, dataSource, organ_effect3test2, organ_effect3);
				new TestResponseMapping(pathway, dataSource, organ_effect4test1, organ_effect4);
				new TestResponseMapping(pathway, dataSource, organ_effect4test2, organ_effect4);
				
				individual_effect1test1 = new Test_InVivo(pathway, dataSource);
				individual_effect1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				individual_effect1test2 = new Test_InSilico(pathway, dataSource);
				individual_effect1test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect1test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "female");
				
				new TestResponseMapping(pathway, dataSource, individual_effect1test1, individual_effect1);
				new TestResponseMapping(pathway, dataSource, individual_effect1test2, individual_effect1);
				
				population_adverseOutcome_test1 = new Test_InSilico(pathway, dataSource);
				population_adverseOutcome_test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "population");
				population_adverseOutcome_test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				population_adverseOutcome_test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_EFFECT_TERM.DIMENSION_INDEX, "mixed");
				
				new TestResponseMapping(pathway, dataSource, population_adverseOutcome_test1, population_adverseOutcome);
				
			}
			
		public void genreateRevision3()
			{
				mie1test1.setTitle("H295R");
				mie1test2.setTitle("Aromatase inhibition in primary tissue in vivo");
				mie1test3.setTitle("Aromatase inhibition ex-vivo");
				mie1test4.setTitle("HPG axis model aromatase inhibition");
				
				cellular_effect1test1.setTitle("Ex-vivo E2 production");
				
				organ_effect1test1.setTitle("In-vivo Radio Immuno Assay");
				organ_effect2test1.setTitle("In-vivo Real Time PCR");
				organ_effect3test1.setTitle("In-vivo Radio Immuno Assay");
				organ_effect4test1.setTitle("In-vivo Histology");
				
				individual_effect1test1.setTitle("In-vivo Reproduction Assay");
				
				population_adverseOutcome_test1.setTitle("Predictive In-silico model");
				
			}
			
		public void genreateRevision4()
			{
				chemical1.setTitle("Fadrozole");
				chemical1.getStructure2DImage().setValue("https://app.effectopedia.org/media/chem/fadrozole.png");
				chemical1.getIdentification().setPropertyValue(0, "102676313");
				chemical1.getIdentification().setPropertyValue(1, "4-(5,6,7,8-tetrahydroimidazo[1,5-a]pyridin-5-yl)benzonitrile");
				chemical1.getIdentification().setPropertyValue(2, "C1CC(N2C=NC=C2C1)C3=CC=C(C=C3)C#N");
				chemical1.getIdentification().setPropertyValue(3, "InChI=1S/C14H13N3/c15-8-11-4-6-12(7-5-11)14-3-1-2-13-9-16-10-17(13)14/h4-7,9-10,14H,1-3H2");
				chemical1.getIdentification().setPropertyValue(4, "CLPFFLWZZBQMAO-UHFFFAOYSA-N");
				chemical1.getIdentification().setPropertyValue(6, "C14H13N3");
				chemical1.getProperties().setPropertyValue(0, "223.27");
			}
			
		public void genreateRevision5()
			{
				mie1test5 = new Test_InVitro(pathway, dataSource);
				mie1test5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1test5.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie1test5.setTitle("NVS_ADME hCYP19A1");
				
				/*
				 * mie1test6 = new Test_InVitro(pathway, dataSource);
				 * mie1test6.getCoordinates
				 * ().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX,
				 * "molecular");
				 * mie1test6.getCoordinates().setValue(DefaultEffectopediaObjects
				 * .DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				 * mie1test6.setTitle("Tox21 Aromatase Inhibition");
				 */
				
				new TestResponseMapping(pathway, dataSource, mie1test5, mie1);
				// new TestResponseMapping(pathway, dataSource, mie1test6, mie1);
			}
			
		public void genreateRevision6()
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
				
				gm1.getModelCallers().add(mie1test4);
				mie1test4.getGlobalModelIDs().add(gm1);
				gm1.getModelCallers().add(cellular_effect1test2);
				cellular_effect1test2.getGlobalModelIDs().add(gm1);
				gm1.getModelCallers().add(organ_effect1test2);
				organ_effect1test2.getGlobalModelIDs().add(gm1);
				gm1.getModelCallers().add(organ_effect2test2);
				organ_effect2test2.getGlobalModelIDs().add(gm1);
				gm1.getModelCallers().add(organ_effect3test2);
				organ_effect3test2.getGlobalModelIDs().add(gm1);
				gm1.getModelCallers().add(organ_effect4test2);
				organ_effect4test2.getGlobalModelIDs().add(gm1);
				
				ObjectProperties modelParameters = gm1.getModelParamaters();
				DescriptorType dt1 = new DescriptorType("StDev", "Standard Deviation", DataValue_String.class, null).makeItLive();
				DescriptorType dt2 = new DescriptorType("SEM", "Standard Error of Mean", DataValue_String.class, null).makeItLive();
				ObjectPropertyType opt1 = new ObjectPropertyType("V.1.1", "HillSlope", "HillSlope", null, Method_InSilicoGlobalModel.class,
						"Hill slope factor defines the steepnes and the curveture of the function", DataValue_Double.class, new DataUnit("kg"), ActionTypes.GM_PARAMETER).makeDocumented(null).makeItLive();
				opt1.getDescriptors().add(dt1);
				opt1.getDescriptors().add(dt2);
				ObjectPropertyMultivalued_Documented op1 = new ObjectPropertyMultivalued_Documented(gm1, opt1);
				String[][] values = new String[][]
					{
					{ "0.8", "-10", "10", null, "0.04", null, "0.01", null, "",
					"Hill, A. V. (1910-01-22). \"The possible effects of the aggregation of the molecules of hæmoglobin on its dissociation curves\". J. Physiol. 40 (Suppl): iv–vii. doi:10.1113/jphysiol.1910.sp001386." } };
				op1.assign(values);
				modelParameters.add(op1);
				
				ObjectPropertyType opt2 = new ObjectPropertyType("V.1.2", "logEC50", "logEC50", null, Method_InSilicoGlobalModel.class, "logEC50 is the log10 of the half maximal effective concentration",
						DataValue_Double.class, new DataUnit("l"), ActionTypes.GM_PARAMETER).makeDocumented(null).makeItLive();
				opt2.getDescriptors().add(dt1);
				opt2.getDescriptors().add(dt2);
				ObjectPropertyMultivalued_Documented op2 = new ObjectPropertyMultivalued_Documented(gm1, opt2);
				values = new String[][]
					{
					{ "-5", "-10", "-1", null, "0.04", null, "0.01", null, "",
					"Hill, A. V. (1910-01-22). \"The possible effects of the aggregation of the molecules of hæmoglobin on its dissociation curves\". J. Physiol. 40 (Suppl): iv–vii. doi:10.1113/jphysiol.1910.sp001386." } };
				op2.assign(values);
				modelParameters.add(op2);
				
				ObjectPropertyType opt3 = new ObjectPropertyType("V.1.3", "maxResp", "maxResp", null, Method_InSilicoGlobalModel.class, "Highest asymtotic value of the response", DataValue_Double.class,
						new DataUnit("%"), ActionTypes.GM_PARAMETER).makeDocumented(null).makeItLive();
				opt3.getDescriptors().add(dt1);
				opt3.getDescriptors().add(dt2);
				ObjectPropertyMultivalued_Documented op3 = new ObjectPropertyMultivalued_Documented(gm1, opt3);
				values = new String[][]
					{
					{ "100", "0", "100", "%", "0.4", null, "0.1", null, "",
					"Hill, A. V. (1910-01-22). \"The possible effects of the aggregation of the molecules of hæmoglobin on its dissociation curves\". J. Physiol. 40 (Suppl): iv–vii. doi:10.1113/jphysiol.1910.sp001386." } };
				op3.assign(values);
				modelParameters.add(op3);
				
				ObjectPropertyType opt4 = new ObjectPropertyType("V.1.4", "minResp", "minResp", null, Method_InSilicoGlobalModel.class, "Lowest asymtotic value of the response", DataValue_Double.class,
						new DataUnit("%"), ActionTypes.GM_PARAMETER).makeDocumented(null).makeItLive();
				opt4.getDescriptors().add(dt1);
				opt4.getDescriptors().add(dt2);
				ObjectPropertyMultivalued_Documented op4 = new ObjectPropertyMultivalued_Documented(gm1, opt4);
				values = new String[][]
					{
					{ "0", "0", "10", "%", "0.4", null, "0.1", null, "",
					"Hill, A. V. (1910-01-22). \"The possible effects of the aggregation of the molecules of hæmoglobin on its dissociation curves\". J. Physiol. 40 (Suppl): iv–vii. doi:10.1113/jphysiol.1910.sp001386." } };
				op4.assign(values);
				modelParameters.add(op4);
				
				ObjectProperties modelMetaData = gm1.getModelMetadata();
				modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_LICENSE).setValue("General Public License (GPL V 3.0)");
				modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_VERSION).setValue("1.0");
				modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_CITATION).setValue(
						"Hill, A. V. (1910-01-22). \"The possible effects of the aggregation of the molecules of hæmoglobin on its dissociation curves\". J. Physiol. 40 (Suppl): iv–vii. doi:10.1113/jphysiol.1910.sp001386.");
				ObjectProperties sysReq = modelMetaData.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQUIREMENTS).getValueAndUnit().getSubProperties();
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_CMD_LINE_OPT).setValue("none");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_EST_RUNTIME).setValue("milliseconds");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_LIBRARIES).setValue("no additional libraries required");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_OS).setValue("Windows, Linux, Mac OS");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_PROG_LANGUAGE).setValue("Matlab");
				sysReq.getProperty(DefaultEffectopediaObjects.DEFAULT_GM_SYS_REQ_PROG_OPT).setValue("default");
				
				IDs<Resource> gm1resources = DefaultEffectopediaObjects.DEFAULT_MATLAB_RECOURCE_IDS.clone(gm1, gm1.getDataSource());
				gm1resources.getCachedObject(0).makeItLive();
				gm1resources.getCachedObject(1).setContent(
						"function model()\n global INPUT MODPAR OUTPUT\n\n OUTPUT.Tested_Subst_Log_Conc_Response_chemical_concentration = INPUT.Tested_Subst_Measured_Log_Conc;\n OUTPUT.Tested_Subst_Log_Conc_Response = zeros(size(OUTPUT.Tested_Subst_Log_Conc_Response_chemical_concentration));\n OUTPUT.Tested_Subst_Log_Conc_Response =  MODPAR.minResp + (MODPAR.maxResp-MODPAR.minResp) ./(1+10.^((MODPAR.logEC50-INPUT.Tested_Subst_Measured_Log_Conc).*MODPAR.HillSlope));\n OUTPUT.Tested_Subst_Log_Conc_Response_stdiv_error = [];\n OUTPUT.Tested_Subst_Log_Conc_Response_sem_error = [];\n OUTPUT.Tested_Subst_Log_Conc_Response_ci95_error = [];\n OUTPUT.Tested_Subst_Log_Conc_Response_median = [];\nend");
				gm1.setResources(gm1resources);
				
				SubstanceData_InSilico subst_data1s = new SubstanceData_InSilico(mie1test4, chemical1, dataSource);
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
				
				ObjectProperties summary = DefaultEffectopediaObjects.DEFAULT_D_RESP_DATA.clone(chemical1, dataSource);
				DataTemplates templates = DefaultDataTemplates.DTS_DR_SINGLE_CHEM_MEAN_MIN_MAX.clone();
				templates.setChartTitle(mie1test4.getTitle());
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
					{ "99.93694405116601	", "", "", "%", "", "", "-1", "logM", "", "", "0", "%", "", "", "", "", "1", "", "", "" }
					};
				testedSubst.assign(drValues);
				mie1test4.getSubstanceDataIDs().add(subst_data1s);
				
				mie1test6 = new Test_InVitro(pathway, dataSource);
				mie1test6.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1test6.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				mie1test6.setTitle("Tox21 Aromatase Inhibition");
				
				new TestResponseMapping(pathway, dataSource, mie1test6, mie1);
			}
			
		public void genreateRevision7()
			{
				DescriptionSection arinh = new DescriptionSection(mie1, dataSource, "Aromatase Inhibition abstract",
						"<html><img src='https://app.effectopedia.org/media/rev/aromatase%20inhibition.png'alt='image description' ><p>Cytochrome P450 aromatase (CYP19) is responsible for the conversion of C19 androgens to C18 estrogens in brain and gonadal tissues of vertebrates. As such, aromatase activity is an important modulator of Î²-estradiol (E2) concentrations and is critical to the regulation of processes controlled by E2. Much of the current understanding of aromatase has arisen from the development of pharmaceuticals designed to treat post-menopausal breast cancer through inhibition of estrogen production by CYP19. Inhibition of CYP19 activity seemingly is not limited to relatively specific pharmaceuticals; there is increasing evidence that any of a large number of chemicals present in the environment, including some fungicides and isoflavonic phytoestrogens, can inhibit aromatase activity. This has led to concern that inhibition of CYP19 could be an important mechanism of action (MOA) for environmental contaminants that elicit adverse reproductive and developmental effects in humans and wildlife through alterations in the endocrine system.ToxicolSci 2002 67(1): 121-131</p></html>")
								.<DescriptionSection> makeItLive();
				arinh.setFormat(ContentFormat.HTML);
				mie1.getDescriptionIDs().set(arinh, 0);
				
				arinh = new DescriptionSection(mie1test4, dataSource, "HPG axis model: aromatase inhibition",
						"<html><img src='https://app.effectopedia.org/media/rev/aromatase_inhibition.png'alt='image description'  width='215' height='101'><p>The HPG axis model perform prediction on estradiol and vitellogenin responses to aromatase inhibitor. In this part of the model, a mathematical description is provided for aromatase inhibitor to inhibit the conversion of testosterone to estradiol.</p></html>")
								.<DescriptionSection> makeItLive();
				arinh.setFormat(ContentFormat.HTML);
				mie1test4.getDescriptionIDs().set(arinh, 0);
				
				arinh = new DescriptionSection(organ_effect1test2, dataSource, "HPG axis model: reduce circulating E2",
						"<html><img src='https://app.effectopedia.org/media/rev/aromatase%20inhibition.png'alt='image description' ><p>The HPG axis model perform prediction of E2 concentration in the plasma.</p></html>")
								.<DescriptionSection> makeItLive();
				arinh.setFormat(ContentFormat.HTML);
				organ_effect1test2.getDescriptionIDs().set(arinh, 0);
				
				DescriptionSection mm = new DescriptionSection(mie1test4, dataSource, "Methods and Materials", "https://app.effectopedia.org/media/content/Methods_HPG.xhtml").<DescriptionSection> makeItLive();
				mm.setFormat(ContentFormat.HTML);
				mie1test4.getDescriptionIDs().add(mm);
				
			}
			
		public void genreateRevision8()
			{
				pathway.setUids(
						"OECD Project 1.12: The Adverse outcome pathways linking aromatase inhibition, androgen receptor agonism, estrogen receptor antagonism, or steroidogenesis inhibition, to impaired reproduction in small repeat-spawning fish species");
				pathway.setStatus("EAGMST Approved");
				
				pathway.getDescriptionIDs()
						.set(new DescriptionSection(pathway, dataSource, "Abstract",
								"This adverse outcome pathway details the linkage between inhibition of gonadal aromatase activity in females and reproductive dysfunction, as measured through the adverse effect of reduced cumulative fecundity and spawning. Initial development of this AOP draws heavily on evidence collected using repeat-spawning fish species. Cumulative fecundity is the most apical endpoint considered in the OECD 229 Fish Short Term Reproduction Assay. The OECD 229 assay serves as screening assay for endocrine disruption and associated reproductive impairment (OECD 2012). Cumulative fecundity is one of several variables known to be of demographic significance in forecasting fish population trends. Therefore, this AOP has utility in supporting the application of measures of aromatase, or in silico predictions of the ability to inhibit aromatase, as a means to identify chemicals with known potential to adversely affect fish populations and potentially other oviparous vertebrates.")
										.<DescriptionSection> makeItLive(),
								0);
				/*
				 * pathway.updateEssentiality();
				 * 
				 * EssetialityDescription essentiality = pathway.getEssentiality();
				 * DescriptionSection[] descriptionSections =
				 * essentiality.links.getCachedObjects(); for (int i = 0; i <
				 * descriptionSections.length; i++) if (descriptionSections[i] instanceof
				 * DescriptionSection_Structured) { DescriptionSection_Structured ds =
				 * (DescriptionSection_Structured) descriptionSections[i];
				 * ReferenceIDW<Link_EffectToEffect> linkRef =
				 * ((ReferenceIDW<Link_EffectToEffect>) (ds).getStructuredContent());
				 * linkRef.setWeight(i > 3 ? 2.0D : 3.0D);
				 * linkRef.getCachedObject().setLinkType(LinkType.DIRECT); } for
				 * (DescriptionSection ds : essentiality.effects.getCachedObjects()) if (ds
				 * instanceof DescriptionSection_Structured) ((ReferenceIDW<Effect>)
				 * ((DescriptionSection_Structured)
				 * ds).getStructuredContent()).setWeight(3.0D);
				 * 
				 * DescriptionSection_Structured dss =
				 * essentiality.getEssentialityDescription(organ_effect2);
				 * ((ReferenceIDW<Link_EffectToEffect>)
				 * dss.getStructuredContent()).setWeight(2.0D); dss =
				 * essentiality.getEssentialityDescription(organ_effect4);
				 * ((ReferenceIDW<Link_EffectToEffect>)
				 * dss.getStructuredContent()).setWeight(1.0D); dss =
				 * essentiality.getEssentialityDescription(individual_effect1);
				 * ((ReferenceIDW<Link_EffectToEffect>)
				 * dss.getStructuredContent()).setWeight(2.0D);
				 */
			}
			
		public void genreateRevision9()
			{
				mie1.getDescriptionIDs()
						.set(new DescriptionSection(mie1, dataSource, "Definition",
								"Inhibition of cytochrome P450 aromatase (CYP19; specifically cyp19a1a in fish). \n\nSite of action: The site of action for the molecular initiating event is the ovarian granulosa cells. \n\nWhile many vertebrates have a single isoform of aromatase, fish are known to have two isoforms. CYP19a1a is predominantly expressed in ovary while cyp19a1b is predominantly expressed in brain (Callard et al. 2001; Cheshenko et al. 2008). For the purposes of this MIE, when applied to fish, the assumed effect is on cyp19a1a. However, given that both isoforms show similar sensitivity to aromatase inhibitors (Hinfray et al. 2006) and catalyze the same reaction, discrimination of specific isoforms is not viewed as critical in relative to determining downstream key events resulting from aromatase inhibition in ovarian granulosa cells. \n\nResponses at the macromolecular level: Aromatase catalyzes three sequential oxidation steps (i.e., KEGG reactions R02501, R04761, R03087 or R01840, R04759, R02351; http://www.genome.jp/kegg/pathway.html) involved in the conversion of C-19 androgens (e.g., testosterone, androstenedione) to C-18 estrogens (e.g., 17Î²-estradiol, estrone). Aromatase inhibitors interfere with one or more of these reactions, leading to reduced efficiency in converting C-19 androgens into C-18 estrogens. Therefore, inhibition of aromatase activity results in decreased rate of 17Î²-estradiol (and presumably estrone) production by the ovary. \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								0);
				mie1.getDescriptionIDs()
						.set(new DescriptionSection(mie1, dataSource, "Measurment/detection",
								".Measurement/detection: Aromatase activity is typically measured by evaluating the production of tritiated water released upon the aromatase catalyzed conversion of radio-labeled androstenedione to estrone (Lephart and Simpson 1991). Aromatase activity can be measured in cell lines exposed in vitro (e.g., human placental JEG-3 cells and JAR choriocarcinoma cells, (Letcher et al. 1999); H295R human adrenocortical carcinoma cells (Sanderson et al. 2000)). Aromatase activity can also be quantified in tissue (i.e., ovary or brain) from vertebrates exposed in vivo (e.g., (Villeneuve et al. 2006; Ankley et al. 2002). In vitro aromatase assays are amenable to high throughput and have been included in nascent high throughput screening programs like the US EPA ToxcastTM program. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								1);
				mie1.getDescriptionIDs()
						.add(new DescriptionSection(mie1, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Key enzymes needed to synthesize 17β-estradiol first appear in the common ancestor of amphioxus and vertebrates (Baker 2011). Consequently, it is plausible that this key event is applicable to most vertebrates.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive());
				mie1.getReferenceIDs()
						.add(new Reference(mie1, dataSource,
								"Petkov PI, Temelkov S, Villeneuve DL, Ankley GT, Mekenyan OG. 2009. Mechanism-based categorization of aromatase inhibitors: a potential discovery and screening tool. SAR QSAR Environ Res 20(7-8): 657-678. ")
										.<Reference> makeItLive());
				mie1.getReferenceIDs().add(new Reference(mie1, dataSource, "Lephart ED, Simpson ER. 1991. Assay of aromatase activity. Methods Enzymol 206: 477-483. ").<Reference> makeItLive());
				mie1.getReferenceIDs()
						.add(new Reference(mie1, dataSource,
								"Letcher RJ, van Holsteijn I, Drenth H-J, Norstrom RJ, Bergman A, Safe S, et al. 1999. Cytotoxicity and aromatase (CYP19) activity modulation by organochlorines in human placental JEG-3 and JAR choriocarcinoma cells. Toxico App Pharm 160: 10-20. ")
										.<Reference> makeItLive());
				mie1.getReferenceIDs()
						.add(new Reference(mie1, dataSource,
								"Sanderson J, Seinen W, Giesy J, van den Berg M. 2000. 2-chloro-triazine herbicides induce aromatase (CYP19) activity in H295R human adrenocortical carcinoma cells: a novel mechanism for estrogenicity. Toxicol Sci 54: 121-127. ")
										.<Reference> makeItLive());
				mie1.getReferenceIDs()
						.add(new Reference(mie1, dataSource,
								"Villeneuve DL, Knoebl I, Kahl MD, Jensen KM, Hammermeister DE, Greene KJ, et al. 2006. Relationship between brain and ovary aromatase activity and isoform-specific aromatase mRNA expression in the fathead minnow (Pimephales promelas). Aquat Toxicol 76(3-4): 353-368. ")
										.<Reference> makeItLive());
				mie1.getReferenceIDs()
						.add(new Reference(mie1, dataSource,
								"Ankley GT, Kahl MD, Jensen KM, Hornung MW, Korte JJ, Makynen EA, et al. 2002. Evaluation of the aromatase inhibitor fadrozole in a short-term reproduction assay with the fathead minnow (Pimephales promelas). Toxicol Sci 67: 121-130. ")
										.<Reference> makeItLive());
				mie1.getReferenceIDs()
						.add(new Reference(mie1, dataSource, "Castro LF, Santos MM, Reis-Henriques MA. 2005. The genomic environment around the Aromatase gene: evolutionary insights. BMC Evol Biol 5: 43. ")
								.<Reference> makeItLive());
				mie1.getReferenceIDs()
						.add(new Reference(mie1, dataSource,
								"Callard GV, Tchoudakova AV, Kishida M, Wood E. 2001. Differential tissue distribution, developmental programming, estrogen regulation and promoter characteristics of cyp19 genes in teleost fish. J Ster Biochem Mol Biol 79: 305-314. ")
										.<Reference> makeItLive());
				mie1.getReferenceIDs()
						.add(new Reference(mie1, dataSource,
								"Cheshenko K, Pakdel F, Segner H, Kah O, Eggen RI. Interference of endocrine disrupting chemicals with aromatase CYP19 expression or activity, and consequences for reproduction of teleost fish. Gen Comp Endocrinol. 2008 Jan 1;155(1):31-62. ")
										.<Reference> makeItLive());
				mie1.getReferenceIDs()
						.add(new Reference(mie1, dataSource,
								"Hinfray N, Porcher JM, Brion F. Inhibition of rainbow trout (Oncorhynchus mykiss) P450 aromatase activities in brain and ovarian microsomes by various environmental substances. Comp Biochem Physiol C Toxicol Pharmacol. 2006 Nov;144(3):252-62 ")
										.<Reference> makeItLive());
				
				cellular_effect1.setTitle("17beta-estradiol synthesis by ovarian granulosa cells, Reduction");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE.DIMENSION_INDEX, "adult");
				cellular_effect1.getDescriptionIDs()
						.set(new DescriptionSection(cellular_effect1, dataSource, "Definition",
								"Like all steroids, estradiol is a cholesterol derivative. Estradiol synthesis in ovary is mediated by a number of enzyme catalyzed reactions involving cyp11 (cholesterol side chain cleavage enzyme), cyp 17 (17alpha-hydroxylase/17,20-lyase), 3beta hydroxysteroid dehyrogenase, 17beta hydroxysteroid dehydrogenase, and cyp19 (aromatase). Among those enzyme catalyzed reactions, conversion of testosterone to estradiol, catalyzed by aromatase, is considered to be rate limiting for estradiol synthesis. Within the ovary, aromatase expression and activity is primarily localized in the granulosa cells (reviewed in (Norris 2007; Yaron 1995; Havelock et al. 2004) and others). Reactions involved in synthesis of C-19 androgens are primarily localized in the theca cells and C-19 androgens diffuse from the theca into granulosa cells where aromatase can catalyze their conversion to C-18 estrogens. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								0);
				cellular_effect1.getDescriptionIDs()
						.set(new DescriptionSection(cellular_effect1, dataSource, "Measurment/detection",
								"Due to the importance of both theca and granulosa cells in ovarian steroidogenesis, it is generally impractical to measure E2 production by isolated granulosa cells (Havelock et al. 2004). However, this key event can be evaluated by examining E2 production by intact ovarian tissue explants either exposed to chemicals in vitro (e.g., (Villeneuve et al. 2007; McMaster ME 1995) or in vivo (i.e., via ex vivo steroidogenesis assay; e.g., (Ankley et al. 2007)). Estradiol released by ovarian tissue explants into media can be quantified by RIA (e.g., Jensen et al. 2001), ELISA, or analytical methods such as LC-MS (e.g., Owen et al. 2014). \n\nOECD TG 456 (OECD 2011) is the validated test guideline for an in vitro screen for chemical effects on steroidogenesis, specifically the production of 17ÃŸ-estradiol (E2) and testosterone (T). \n\nThe synthesis of E2 can be measured in vitro cultured ovarian cells. The methods for culturing mammalian ovarian cells can be found in the Database Service on Alternative Methods to animal experimentation (DB-ALM): Culture of Human Cumulus Granulosa Cells (EURL ECVAM Protocol No. 92), Granulosa and Theca Cell Culture Systems (EURL ECVAM Method Summary No. 92). \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								1);
				cellular_effect1.getDescriptionIDs()
						.add(new DescriptionSection(cellular_effect1, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Key enzymes needed to synthesize 17β-estradiol first appear in the common ancestor of amphioxus and vertebrates (Baker 2011). Consequently, it is plausible that this key event is applicable to most vertebrates.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive());
				cellular_effect1.getReferenceIDs().add(new Reference(cellular_effect1, dataSource, "Norris DO. 2007. Vertebrate Endocrinology. Fourth ed. New York: Academic Press. ").<Reference> makeItLive());
				cellular_effect1.getReferenceIDs()
						.add(new Reference(cellular_effect1, dataSource, "Havelock JC, Rainey WE, Carr BR. 2004. Ovarian granulosa cell lines. Molecular and cellular endocrinology 228(1-2): 67-78. ")
								.<Reference> makeItLive());
				cellular_effect1.getReferenceIDs()
						.add(new Reference(cellular_effect1, dataSource, "Yaron Z. 1995. Endocrine control of gametogenesis and spawning induction in the carp. Aquaculture 129: 49-73. ").<Reference> makeItLive());
				cellular_effect1.getReferenceIDs()
						.add(new Reference(cellular_effect1, dataSource,
								"Villeneuve DL, Ankley GT, Makynen EA, Blake LS, Greene KJ, Higley EB, et al. 2007. Comparison of fathead minnow ovary explant and H295R cell-based steroidogenesis assays for identifying endocrine-active chemicals. Ecotoxicol Environ Saf 68(1): 20-32. ")
										.<Reference> makeItLive());
				cellular_effect1.getReferenceIDs()
						.add(new Reference(cellular_effect1, dataSource,
								"McMaster ME MK, Jardine JJ, Robinson RD, Van Der Kraak GJ. 1995. Protocol for measuring in vitro steroid production by fish gonadal tissue. Canadian Technical Report of Fisheries and Aquatic Sciences 1961 1961: 1-78. ")
										.<Reference> makeItLive());
				
				organ_effect1.setTitle("Plasma 17beta-estradiol concentrations, Reduction");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE.DIMENSION_INDEX, "adult");
				organ_effect1.getDescriptionIDs()
						.set(new DescriptionSection(organ_effect1, dataSource, "Definition",
								"Estradiol synthesized by the gonads is transported to other tissues via blood circulation. The gonads are generally considered to be the primary source of estrogens in systemic circulation.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								0);
				organ_effect1.getDescriptionIDs()
						.set(new DescriptionSection(organ_effect1, dataSource, "Measurment/detection",
								"Total concentrations of 17β-estradiol in plasma can be measured by radioimmunoassay (e.g., (Jensen et al. 2001)), enzyme-linked immunosorbent assay (available through many commercial vendors), or by analytical chemistry (e.g., LC/MS; Owen et al. 2014). Total steroid hormones are typically extracted from plasma or serum via liquid-liquid or solid phase extraction prior to analysis.\nGiven that there are numerous genes, like those coding for vertebrate vitellogenins, choriongenins, cyp19a1b, etc. which are known to be regulated by estrogen response elements, targeted qPCR or proteomic analysis of appropriate targets could also be used as an indirect measure of reduced circulating estrogen concentrations. However, further support for the specificity of the individual gene targets for estrogen-dependent regulation should be established in order to support their use.\nA line of transgenic zebrafish employing green fluorescence protein under control of estrogen response elements could also be used to provide direct evidence of altered estrogen, with decreased GFP signal in estrogen responsive tissues like liver, ovary, pituitary, and brain indicating a reduction in circulating estrogens (Gorelick and Halpern 2011). ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								1);
				organ_effect1.getDescriptionIDs()
						.add(new DescriptionSection(organ_effect1, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Key enzymes needed to synthesize 17β-estradiol first appear in the common ancestor of amphioxus and vertebrates (Baker 2011). Consequently, it is plausible that this key event is applicable to most vertebrates.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive());
				organ_effect1.getReferenceIDs()
						.add(new Reference(organ_effect1, dataSource,
								"Jensen K, Korte J, Kahl M, Pasha M, Ankley G. 2001. Aspects of basic reproductive biology and endocrinology in the fathead minnow (Pimephales promelas). Comparative Biochemistry and Physiology Part C 128: 127-141.")
										.<Reference> makeItLive());
				organ_effect1.getReferenceIDs().add(new Reference(organ_effect1, dataSource,
						"Baker ME. 2011. Origin and diversification of steroids: co-evolution of enzymes and nuclear receptors. Molecular and cellular endocrinology 334(1-2): 14-20. ").<Reference> makeItLive());
				organ_effect1.getReferenceIDs()
						.add(new Reference(organ_effect1, dataSource,
								"Owen LJ, Wu FC, Keevil BG. 2014. A rapid direct assay for the routine measurement of oestradiol and oestrone by liquid chromatography tandem mass spectrometry. Ann. Clin. Biochem. 51(pt 3):360-367.")
										.<Reference> makeItLive());
				organ_effect1.getReferenceIDs()
						.add(new Reference(organ_effect1, dataSource,
								"Gorelick DA, Halpern ME. Visualization of estrogen receptor transcriptional activation in zebrafish. Endocrinology. 2011 Jul;152(7):2690-703. doi: 10.1210/en.2010-1257. Epub 2011 May 3. PubMed PMID: 21540282")
										.<Reference> makeItLive());
				
				organ_effect2.setTitle("Vitellogenin synthesis in liver, Reduction");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE.DIMENSION_INDEX, "adult");
				organ_effect2.getDescriptionIDs()
						.set(new DescriptionSection(organ_effect2, dataSource, "Definition",
								"Vitellogenin is an egg yolk precursor protein synthesized by hepatocytes of oviparous vertebrates. In vertebrates, transcription of vitellogenin genes is predominantly regulated by estrogens via their action on nuclear estrogen receptors. During vitellogenic periods of the reproductive cycle, when circulating estrogen concentrations are high, vitellogenin transcription and synthesis are typically orders of magnitude greater than during non-reproductive conditions. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								0);
				organ_effect2.getDescriptionIDs()
						.set(new DescriptionSection(organ_effect2, dataSource, "Measurment/detection",
								"Relative abundance of vitellogenin transcripts or protein can be readily measured in liver tissue from organisms exposed in vivo (e.g., (Biales et al. 2007)), or in liver slices (e.g., (Schmieder et al. 2000) or hepatocytes (e.g., (Navas and Segner 2006) exposed in vitro, using real-time quantitative PCR (transcripts) or ELISA (protein). ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								1);
				organ_effect2.getDescriptionIDs()
						.add(new DescriptionSection(organ_effect2, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Oviparous vertebrates. Although vitellogenin is conserved among oviparous vertebrates and many invertebrates, liver is not a relevant tissue for the production of vitellogenin in invertebrates (Wahli 1988)")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive());
				organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect2, dataSource,
								"Biales AD, Bencic DC, Lazorchak JL, Lattier DL. 2007. A quantitative real-time polymerase chain reaction method for the analysis of vitellogenin transcripts in model and nonmodel fish species. Environ Toxicol Chem 26(12): 2679-2686.")
										.<Reference> makeItLive());
				organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect2, dataSource,
								"Schmieder P, Tapper M, Linnum A, Denny J, Kolanczyk R, Johnson R. 2000. Optimization of a precision-cut trout liver tissue slice assay as a screen for vitellogenin induction: comparison of slice incubation techniques. Aquat Toxicol 49(4): 251-268. ")
										.<Reference> makeItLive());
				organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect2, dataSource,
								"Navas JM, Segner H. 2006. Vitellogenin synthesis in primary cultures of fish liver cells as endpoint for in vitro screening of the (anti)estrogenic activity of chemical substances. Aquat Toxicol 80(1): 1-22. ")
										.<Reference> makeItLive());
				organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect2, dataSource, "Wahli W. 1988. Evolution and expression of vitellogenin genes. Trends in Genetics. 4:227-232.").<Reference> makeItLive());
				
				organ_effect3.setTitle("Plasma vitellogenin concentrations, Reduction");
				organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE.DIMENSION_INDEX, "adult");
				organ_effect3.getDescriptionIDs()
						.set(new DescriptionSection(organ_effect3, dataSource, "Definition", "Vitellogenin synthesized in the liver is secreted into the blood and circulates to the ovaries for uptake. ")
								.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(), 0);
				organ_effect3.getDescriptionIDs()
						.set(new DescriptionSection(organ_effect3, dataSource, "Measurment/detection",
								"Vitellogenin concentrations in plasma are typically detected using enzyme linked Immunosorbent assay (ELISA; e.g., (Korte et al. 2000; Tyler et al. 1996; Holbech et al. 2001; Fenske et al. 2001). Although less specific and/or sensitive, determination of alkaline-labile phosphate or Western blotting has also been employed. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								1);
				organ_effect3.getDescriptionIDs()
						.add(new DescriptionSection(organ_effect3, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Oviparous vertebrates synthesize yolk precursor proteins that are transported in the circulation for uptake by developing oocytes. Many invertebrates also synthesize vitellogenins that are taken up into developing oocytes via active transport mechanisms. However, invertebrate vitellogenins are transported in hemolymph or via other transport mechanisms rather than plasma. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive());
				organ_effect3.getReferenceIDs()
						.add(new Reference(organ_effect3, dataSource,
								"Korte JJ, Kahl MD, Jensen KM, Mumtaz SP, Parks LG, LeBlanc GA, et al. 2000. Fathead minnow vitellogenin: complementary DNA sequence and messenger RNA and protein expression after 17B-estradiol treatment. Environmental Toxicology and Chemistry 19(4): 972-981.")
										.<Reference> makeItLive());
				organ_effect3.getReferenceIDs()
						.add(new Reference(organ_effect3, dataSource,
								"Tyler C, van der Eerden B, Jobling S, Panter G, Sumpter J. 1996. Measurement of vitellogenin, a biomarker for exposure to oestrogenic chemicals, in a wide variety of cyprinid fish. Journal of Comparative Physiology and Biology 166: 418-426.")
										.<Reference> makeItLive());
				organ_effect3.getReferenceIDs()
						.add(new Reference(organ_effect3, dataSource, "Wahli W. 1988. Evolution and expression of vitellogenin genes. Trends in Genetics. 4:227-232.").<Reference> makeItLive());
				organ_effect3.getReferenceIDs()
						.add(new Reference(organ_effect3, dataSource,
								"Holbech H, Andersen L, Petersen GI, Korsgaard B, Pedersen KL, Bjerregaard P. Development of an ELISA for vitellogenin in whole body homogenate of zebrafish (Danio rerio). Comp Biochem Physiol C Toxicol Pharmacol. 2001 Sep;130(1):119-31.")
										.<Reference> makeItLive());
				organ_effect3.getReferenceIDs()
						.add(new Reference(organ_effect3, dataSource,
								"Fenske M, van Aerle R, Brack S, Tyler CR, Segner H. Development and validation of a homologous zebrafish (Danio rerio Hamilton-Buchanan) vitellogenin enzyme-linked immunosorbent assay (ELISA) and its application for studies on estrogenic chemicals. Comp Biochem Physiol C Toxicol Pharmacol. 2001. Jul;129(3):217-32.")
										.<Reference> makeItLive());
				
				organ_effect4.setTitle("Vitellogenin accumulation into oocytes and oocyte growth/development, Reduction");
				organ_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE.DIMENSION_INDEX, "adult");
				organ_effect4.getDescriptionIDs()
						.set(new DescriptionSection(organ_effect4, dataSource, "Definition",
								"Vitellogenin from the blood is selectively taken up by competent oocytes via receptor-mediated endocytosis. Although vitellogenin receptors mediate the uptake, opening of intercellular channels through the follicular layers to the oocyte surface as the oocyte reaches a “critical” size is thought to be a key trigger in allowing vitellogenin uptake (Tyler and Sumpter 1996). Once critical size is achieved, concentrations in the plasma and temperature are thought to impose the primary limits on uptake (Tyler and Sumpter 1996). Uptake of vitellogenin into oocytes causes considerable oocyte growth during vitellogenesis, accounting for up to 95% of the final egg size in many fish (Tyler and Sumpter 1996). Given the central role of vitellogenesis in oocyte maturation, vitellogenin accumulation is a prominent feature used in histological staging of oocytes (e.g., (Leino et al. 2005; Wolf et al. 2004).")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								0);
				organ_effect4.getDescriptionIDs()
						.set(new DescriptionSection(organ_effect4, dataSource, "Measurment/detection",
								"Relative vitellogenin accumulation can be evaluated qualitatively using routine histological approaches (Leino et al. 2005; Wolf et al. 2004). Oocyte size can be evaluated qualitatively or quantitatively using routine histological and light microscopy and/or imaging approaches.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								1);
				organ_effect4.getDescriptionIDs()
						.add(new DescriptionSection(organ_effect4, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Oviparous vertebrates and invertebrates. Although hormonal regulation of vitellogenin synthesis and mechanisms of vitellogenin transport from the site of synthesis to the ovary vary between vertebrates and invertebrates (Wahli 1988), in both vertebrates and invertebrates, vitellogenin is incorporated into oocytes and cleaved to form yolk proteins. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive());
				organ_effect4.getReferenceIDs()
						.add(new Reference(organ_effect4, dataSource, "Tyler C, Sumpter J. 1996. Oocyte growth and development in teleosts. Reviews in Fish Biology and Fisheries 6: 287-318.").<Reference> makeItLive());
				organ_effect4.getReferenceIDs()
						.add(new Reference(organ_effect4, dataSource,
								"Leino R, Jensen K, Ankley G. 2005. Gonadal histology and characteristic histopathology associated with endocrine disruption in the adult fathead minnow. Environmental Toxicology and Pharmacology 19: 85-98.")
										.<Reference> makeItLive());
				organ_effect4.getReferenceIDs()
						.add(new Reference(organ_effect4, dataSource,
								"Wolf JC, Dietrich DR, Friederich U, Caunter J, Brown AR. 2004. Qualitative and quantitative histomorphologic assessment of fathead minnow Pimephales promelas gonads as an endpoint for evaluating endocrine-active compounds: a pilot methodology study. Toxicol Pathol 32(5): 600-612.")
										.<Reference> makeItLive());
				
				individual_effect1.setTitle("Cumulative fecundity and spawning, Reduction");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LIFE_STAGE.DIMENSION_INDEX, "adult");
				individual_effect1.getDescriptionIDs()
						.set(new DescriptionSection(individual_effect1, dataSource, "Definition",
								"Spawning refers to the release of eggs. Cumulative fecundity refers to the total number of eggs deposited by a female, or group of females over a specified period of time. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								0);
				individual_effect1.getDescriptionIDs()
						.set(new DescriptionSection(individual_effect1, dataSource, "Measurment/detection",
								"In laboratory-based reproduction assays (e.g., OECD 229; OECD 240), spawning and cumulative fecundity can be directly measured through daily observation of egg deposition and egg counts. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								1);
				individual_effect1.getDescriptionIDs().add(new DescriptionSection(individual_effect1, dataSource, "Evidence Supporting Taxonomic Applicability",
						"Cumulative fecundity and spawning can, in theory, be evaluated for any egg laying animal. ").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive());
				individual_effect1.getDescriptionIDs()
						.add(new DescriptionSection(individual_effect1, dataSource, "Regulatory Examples Using This Adverse Outcome",
								"Cumulative fecundity is the most apical endpoint considered in the OECD 229 Fish Short Term Reproduction Assay. The OECD 229 assay serves as screening assay for endocrine disruption and associated reproductive impairment (OECD 2012). Fecundity is also an important apical endpoint in the Medaka Extended One Generation Reproduction Test (MEOGRT; OECD Test Guideline 240). ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive());
				individual_effect1.getReferenceIDs()
						.add(new Reference(individual_effect1, dataSource, "OECD. 2012a. Test no. 229: Fish short term reproduction assay. Paris, France:Organization for Economic Cooperation and Development.")
								.<Reference> makeItLive());
				
				population_adverseOutcome.setTitle("Population trajectory, Decrease");
				population_adverseOutcome.getDescriptionIDs()
						.set(new DescriptionSection(population_adverseOutcome, dataSource, "Definition",
								"Maintenance of sustainable fish and wildlife populations (i.e., adequate to ensure long-term delivery of valued ecosystem services) is an accepted regulatory goal upon which risk assessments and risk management decisions are based.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								0);
				population_adverseOutcome.getDescriptionIDs()
						.set(new DescriptionSection(population_adverseOutcome, dataSource, "Measurment/detection",
								"Population trajectories, either hypothetical or site specific, can be estimated via population modeling based on measurements of vital rates or reasonable surrogates measured in laboratory studies. As an example, Miller and Ankley 2004 used measures of cumulative fecundity from laboratory studies with repeat spawning fish species to predict population-level consequences of continuous exposure. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								1);
				population_adverseOutcome.getDescriptionIDs().add(new DescriptionSection(population_adverseOutcome, dataSource, "Evidence Supporting Taxonomic Applicability",
						"Consideration of population size and changes in population size over time is potentially relevant to all living organisms.").setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive());
				population_adverseOutcome.getDescriptionIDs()
						.add(new DescriptionSection(population_adverseOutcome, dataSource, "Regulatory Examples Using This Adverse Outcome",
								"Maintenance of sustainable fish and wildlife populations (i.e., adequate to ensure long-term delivery of valued ecosystem services) is a widely accepted regulatory goal upon which risk assessments and risk management decisions are based.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive());
				population_adverseOutcome.getReferenceIDs()
						.add(new Reference(population_adverseOutcome, dataSource,
								"Miller DH, Ankley GT. 2004. Modeling impacts on populations: fathead minnow (Pimephales promelas) exposure to the endocrine disruptor 17trenbolone as a case study. Ecotoxicology and Environmental Safety 59: 1-9.")
										.<Reference> makeItLive());
				
				mie1_to_cellular_effect1.setLinkType(LinkType.DIRECT);
				ReferenceIDW<Link_EffectToEffect> mie1_to_cellular_effect1_weigth0 = new ReferenceIDW<Link_EffectToEffect>(mie1_to_cellular_effect1, dataSource, Link_EffectToEffect.class, 3.0);
				mie1_to_cellular_effect1.getDescriptionIDs()
						.set(new DescriptionSection_Structured(mie1_to_cellular_effect1, dataSource, "(Key) Event Relationships Weight of Evidences",
								"•  Biological Plausibility: \n\nWithin the ovary, aromatase expression and activity is primarily localized in the granulosa cells (reviewed in (Norris 2007; Yaron 1995; Havelock et al. 2004) and others). C-19 androgens diffuse from the theca cells into granulosa cells where aromatase can catalyze their conversion to C-18 estrogens. Therefore, inhibition of ovarian aromatase activity can generally be assumed to directly impact E2 synthesis by the granulosa cells.\n\n•  Empirical Support for Linkage:\n\nKnown aromatase inhibitors including fadrozole and prochloraz were shown to cause concentration-dependent inhibition of aromatase activity in fathead minnow ovary homogenates (Villeneuve et al. 2006; Ankley et al. 2005). \n\nFadrozole and prochloraz also cause concentration-dependent decreases in E2 production by fathead minnow ovary explants exposed in vitro (Villeneuve et al. 2007). \n\nFollowing in vivo exposure to fadrozole or prochloraz, ex vivo E2 production is significantly decreased in a concentration-dependent manner early in the time-course following exposure, although depending on the concentration, compensatory responses may offset the direct impact later in the exposure time-course (Villeneuve et al. 2006; Villeneuve et al. 2009; Ankley et al. 2009a; Skolness et al. 2011). \n\n•  Uncertainties or Inconsistencies:\n\nBased on the limited set of studies available to date, there are no known inconsistencies. \n\n",
								mie1_to_cellular_effect1_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
				mie1_to_cellular_effect1.getDescriptionIDs()
						.set(new DescriptionSection(mie1_to_cellular_effect1, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Aromatase (CYP19) orthologs are known to be present among most of the vertebrate lineage, at least down to the cartilaginous fishes. Orthologs have generally not been found in invertebrates, however, CYP19 was detected in the invertebrate chordate, amphioxus and analysis of conservation of gene order and content suggests a possible origin among primitive chordates (Castro et al. 2005). ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								2);
				mie1_to_cellular_effect1.getDescriptionIDs()
						.set(new DescriptionSection(mie1_to_cellular_effect1, dataSource, "Quantitative Understading",
								"Several mechanistically-based models of ovarian steroidogenesis have been developed (Breen et al. 2013; Breen et al. 2007; Shoemaker et al. 2010; Quignot and Bois 2013). \n\nThe Breen et al. 2007 model was developed based on in vitro experiments with fathead minnow ovary tissue, and considers effects on steroidogenesis within the ovary only. \n\nThe Breen et al. 2013 model was developed based on in vivo time-course data for fathead minnow and incorporates prediction of compensatory responses resulting from feedback mechanisms operating as part of the hypothalamic-pituitary-gonadal axis. \n\nThe Shoemaker et al. 2010 model is chimeric and includes signaling pathways and aspects of transcriptional regulation based on a mixture of fish-specific and mammalian sources. \n\nThe Quignot and Bois 2013 model was designed to predict rat ovarian steroid secretion based on in vitro experiments with endocrine disrupting chemicals. \n\nThese may be adaptable to predict in vitro E2 production and/or plasma E2 concentrations from in vitro or in vivo measurements of aromatase inhibition. \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								3);
				mie1_to_cellular_effect1.getReferenceIDs()
						.add(new Reference(mie1_to_cellular_effect1, dataSource, "Norris DO. 2007. Vertebrate Endocrinology. Fourth ed. New York: Academic Press. ").<Reference> makeItLive());
				mie1_to_cellular_effect1.getReferenceIDs().add(
						new Reference(mie1_to_cellular_effect1, dataSource, "Yaron Z. 1995. Endocrine control of gametogenesis and spawning induction in the carp. Aquaculture 129: 49-73. ").<Reference> makeItLive());
				mie1_to_cellular_effect1.getReferenceIDs()
						.add(new Reference(mie1_to_cellular_effect1, dataSource, "Havelock JC, Rainey WE, Carr BR. 2004. Ovarian granulosa cell lines. Molecular and cellular endocrinology 228(1-2): 67-78. ")
								.<Reference> makeItLive());
				mie1_to_cellular_effect1.getReferenceIDs()
						.add(new Reference(mie1_to_cellular_effect1, dataSource,
								"Villeneuve DL, Knoebl I, Kahl MD, Jensen KM, Hammermeister DE, Greene KJ, et al. 2006. Relationship between brain and ovary aromatase activity and isoform-specific aromatase mRNA expression in the fathead minnow (Pimephales promelas). Aquat Toxicol 76(3-4): 353-368. ")
										.<Reference> makeItLive());
				mie1_to_cellular_effect1.getReferenceIDs()
						.add(new Reference(mie1_to_cellular_effect1, dataSource,
								"Ankley GT, Jensen KM, Durhan EJ, Makynen EA, Butterworth BC, Kahl MD, et al. 2005. Effects of two fungicides with multiple modes of action on reproductive endocrine function in the fathead minnow (Pimephales promelas). Toxicol Sci 86(2): 300-308. ")
										.<Reference> makeItLive());
				mie1_to_cellular_effect1.getReferenceIDs()
						.add(new Reference(mie1_to_cellular_effect1, dataSource,
								"Villeneuve DL, Ankley GT, Makynen EA, Blake LS, Greene KJ, Higley EB, et al. 2007. Comparison of fathead minnow ovary explant and H295R cell-based steroidogenesis assays for identifying endocrine-active chemicals. Ecotoxicol Environ Saf 68(1): 20-32. ")
										.<Reference> makeItLive());
				mie1_to_cellular_effect1.getReferenceIDs()
						.add(new Reference(mie1_to_cellular_effect1, dataSource,
								"Villeneuve DL, Mueller ND, Martinovic D, Makynen EA, Kahl MD, Jensen KM, et al. 2009. Direct effects, compensation, and recovery in female fathead minnows exposed to a model aromatase inhibitor. Environ Health Perspect 117(4): 624-631. ")
										.<Reference> makeItLive());
				mie1_to_cellular_effect1.getReferenceIDs()
						.add(new Reference(mie1_to_cellular_effect1, dataSource,
								"Ankley GT, Bencic D, Cavallin JE, Jensen KM, Kahl MD, Makynen EA, et al. 2009a. Dynamic nature of alterations in the endocrine system of fathead minnows exposed to the fungicide prochloraz. Toxicol Sci 112(2): 344-353. ")
										.<Reference> makeItLive());
				mie1_to_cellular_effect1.getReferenceIDs()
						.add(new Reference(mie1_to_cellular_effect1, dataSource,
								"Skolness SY, Durhan EJ, Garcia-Reyero N, Jensen KM, Kahl MD, Makynen EA, et al. 2011. Effects of a short-term exposure to the fungicide prochloraz on endocrine function and gene expression in female fathead minnows (Pimephales promelas). Aquat Toxicol 103(3-4): 170-178. ")
										.<Reference> makeItLive());
				mie1_to_cellular_effect1.getReferenceIDs()
						.add(new Reference(mie1_to_cellular_effect1, dataSource,
								"Breen M, Villeneuve DL, Ankley GT, Bencic DC, Breen MS, Watanabe KH, et al. 2013. Developing Predictive Approaches to Characterize Adaptive Responses of the Reproductive Endocrine Axis to Aromatase Inhibition: II. Computational Modeling. Toxicological sciences : an official journal of the Society of Toxicology. ")
										.<Reference> makeItLive());
				mie1_to_cellular_effect1.getReferenceIDs()
						.add(new Reference(mie1_to_cellular_effect1, dataSource,
								"Breen MS, Villeneuve DL, Breen M, Ankley GT, Conolly RB. 2007. Mechanistic computational model of ovarian steroidogenesis to predict biochemical responses to endocrine active compounds. Annals of biomedical engineering 35(6): 970-981. ")
										.<Reference> makeItLive());
				mie1_to_cellular_effect1.getReferenceIDs()
						.add(new Reference(mie1_to_cellular_effect1, dataSource,
								"Shoemaker JE, Gayen K, Garcia-Reyero N, Perkins EJ, Villeneuve DL, Liu L, et al. 2010. Fathead minnow steroidogenesis: in silico analyses reveals tradeoffs between nominal target efficacy and robustness to cross-talk. BMC systems biology 4: 89. ")
										.<Reference> makeItLive());
				mie1_to_cellular_effect1.getReferenceIDs()
						.add(new Reference(mie1_to_cellular_effect1, dataSource,
								"Quignot N, Bois FY. 2013. A computational model to predict rat ovarian steroid secretion from in vitro experiments with endocrine disruptors. PloS one 8(1): e53891. ")
										.<Reference> makeItLive());
				
				cellular_effect1_to_organ_effect1.setLinkType(LinkType.DIRECT);
				ReferenceIDW<Link_EffectToEffect> cellular_effect1_to_organ_effect1_weigth0 = new ReferenceIDW<Link_EffectToEffect>(cellular_effect1_to_organ_effect1, dataSource, Link_EffectToEffect.class, 3.0);
				cellular_effect1_to_organ_effect1.getDescriptionIDs()
						.set(new DescriptionSection_Structured(cellular_effect1_to_organ_effect1, dataSource, "(Key) Event Relationships Weight of Evidences",
								"•  Biological Plausibility: \n\nWhile brain, interrenal, adipose, and breast tissue (in mammals) are capable of synthesizing estradiol, the gonads are generally considered the major source of circulating estrogens in vertebrates, including fish (Norris 2007). Consequently, if estradiol synthesis by ovarian granulosa cells is reduced, plasma E2 concentrations would be expected to decrease unless there are concurrent reductions in the rate of E2 catabolism. Synthesis in other tissues generally plays a paracrine role only, thus the contribution of other tissues to plasma E2 concentrations can generally be considered negligible. \n\n•  Empirical Support for Linkage:\n\nFish \n\nIn multiple studies with aromatase inhibitors (e.g., fadrozole, prochloraz), significant reductions in ex vivo E2 production have been linked to, and shown to precede, reductions in circulating E2 concentrations (Villeneuve et al. 2009; Skolness et al. 2011). It is also notable that compensatory responses at the level of ex vivo steroid production (i.e., rate of E2 synthesis per unit mass of tissue) tend to precede recovery of plasma E2 concentrations following an initial insult (Villeneuve et al. 2009; Ankley et al. 2009a; Villeneuve et al. 2013). \n\nEx vivo E2 production by ovary tissue collected from female fish exposed to 30 or 300 Î¼g ketoconazole/L showed significant decreases prior to significant effects on plasma estradiol being observed (Ankley et al. 2012). \n\nMammals \n\nMEHP /DEHP, mice, ex vivo DEHP (10 -100 Î¼g/ml); MEHP (0.1 and 10 Î¼g/ml) dose dependent reduction E2 production (Gupta et al., 2010) \n\nDEHP, rat, in vivo 300-600 mg/kg/day, dose dependent reduction of E2 plasma levels (Xu et al., 2010) \n\nEvidence for rodent and human models is summarized in the AOP Wiki: Relationship:45 > Aop:25 > Relationship:5: Table 1.  Summary of the experimental data for decrease E2 production and decreased E2 levels. IC50- half maximal inhibitory concentration values reported if available, otherwise the concentration at which the effect was observed. \n\n•  Uncertainties or Inconsistencies:\n\nBased on the limited set of studies available to date, there are no known inconsistencies. \n\n",
								cellular_effect1_to_organ_effect1_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
				cellular_effect1_to_organ_effect1.getDescriptionIDs()
						.set(new DescriptionSection(cellular_effect1_to_organ_effect1, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Key enzymes needed to synthesize 17Î²-estradiol first appear in the common ancestor of amphioxus and vertebrates (Baker 2011). While some E2 synthesis can occur in other tissues, the ovary is recognized as the major source of 17Î²-estradiol synthesis in female vertebrates. Endocrine actions of ovarian E2 are facilitated through transport via the plasma. Consequently, this key event relationship is applicable to most female vertebrates. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								2);
				cellular_effect1_to_organ_effect1.getDescriptionIDs()
						.set(new DescriptionSection(cellular_effect1_to_organ_effect1, dataSource, "Quantitative Understading",
								"At present we are unaware of any well established quantitative relationships between ex vivo E2 production (as an indirect measure of granulosa cell E2 synthesis) and plasma E2 concentrations. \n\nThere are considerable data available which might support the development of such a relationship. Additionally, there are a number of existing mathematical/computational models of ovarian steroidogenesis (Breen et al. 2013; Shoemaker et al. 2010) and/or physiologically-based pharmacokinetic models of the hypothalamic-pituitary-gonadal axis (e.g., (Li et al. 2011a) that may be adaptable to support a quantitative understanding of this linkage. \n\n•  The Breen et al. 2013 model was developed based on in vivo time-course data for fathead minnow and incorporates prediction of compensatory responses resulting from feedback mechanisms operating as part of the hypothalamic-pituitary-gonadal axis. \n\n•  The Shoemaker et al. 2010 model is chimeric and includes signaling pathways and aspects of transcriptional regulation based on a mixture of fish-specific and mammalian sources. \n\n•  The Li et al. 2011 model is a PBPK-based model that was calibrated from data from fathead minnows, including controls and fish exposed to either 17alpha ethynylestradiol or 17beta trenbolone. \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								3);
				cellular_effect1_to_organ_effect1.getReferenceIDs().add(new Reference(cellular_effect1_to_organ_effect1, dataSource, "Fish ").<Reference> makeItLive());
				cellular_effect1_to_organ_effect1.getReferenceIDs()
						.add(new Reference(cellular_effect1_to_organ_effect1, dataSource, "Norris DO. 2007. Vertebrate Endocrinology. Fourth ed. New York: Academic Press. ").<Reference> makeItLive());
				cellular_effect1_to_organ_effect1.getReferenceIDs()
						.add(new Reference(cellular_effect1_to_organ_effect1, dataSource,
								"Villeneuve DL, Mueller ND, Martinovic D, Makynen EA, Kahl MD, Jensen KM, et al. 2009. Direct effects, compensation, and recovery in female fathead minnows exposed to a model aromatase inhibitor. Environ Health Perspect 117(4): 624-631. ")
										.<Reference> makeItLive());
				cellular_effect1_to_organ_effect1.getReferenceIDs()
						.add(new Reference(cellular_effect1_to_organ_effect1, dataSource,
								"Skolness SY, Durhan EJ, Garcia-Reyero N, Jensen KM, Kahl MD, Makynen EA, et al. 2011. Effects of a short-term exposure to the fungicide prochloraz on endocrine function and gene expression in female fathead minnows (Pimephales promelas). Aquat Toxicol 103(3-4): 170-178. ")
										.<Reference> makeItLive());
				cellular_effect1_to_organ_effect1.getReferenceIDs()
						.add(new Reference(cellular_effect1_to_organ_effect1, dataSource,
								"Ankley GT, Bencic DC, Cavallin JE, Jensen KM, Kahl MD, Makynen EA, et al. 2009a. Dynamic nature of alterations in the endocrine system of fathead minnows exposed to the fungicide prochloraz. Toxicological sciences : an official journal of the Society of Toxicology 112(2): 344-353. ")
										.<Reference> makeItLive());
				cellular_effect1_to_organ_effect1.getReferenceIDs()
						.add(new Reference(cellular_effect1_to_organ_effect1, dataSource,
								"Villeneuve DL, Breen M, Bencic DC, Cavallin JE, Jensen KM, Makynen EA, et al. 2013. Developing Predictive Approaches to Characterize Adaptive Responses of the Reproductive Endocrine Axis to Aromatase Inhibition: I. Data Generation in a Small Fish Model. Toxicological sciences : an official journal of the Society of Toxicology. ")
										.<Reference> makeItLive());
				cellular_effect1_to_organ_effect1.getReferenceIDs()
						.add(new Reference(cellular_effect1_to_organ_effect1, dataSource,
								"Ankley GT, Cavallin JE, Durhan EJ, Jensen KM, Kahl MD, Makynen EA, et al. 2012. A time-course analysis of effects of the steroidogenesis inhibitor ketoconazole on components of the hypothalamic-pituitary-gonadal axis of fathead minnows. Aquatic toxicology 114-115: 88-95. ")
										.<Reference> makeItLive());
				cellular_effect1_to_organ_effect1.getReferenceIDs()
						.add(new Reference(cellular_effect1_to_organ_effect1, dataSource,
								"Shoemaker JE, Gayen K, Garcia-Reyero N, Perkins EJ, Villeneuve DL, Liu L, et al. 2010. Fathead minnow steroidogenesis: in silico analyses reveals tradeoffs between nominal target efficacy and robustness to cross-talk. BMC systems biology 4: 89. ")
										.<Reference> makeItLive());
				cellular_effect1_to_organ_effect1.getReferenceIDs()
						.add(new Reference(cellular_effect1_to_organ_effect1, dataSource,
								"Li Z, Kroll KJ, Jensen KM, Villeneuve DL, Ankley GT, Brian JV, et al. 2011a. A computational model of the hypothalamic: pituitary: gonadal axis in female fathead minnows (Pimephales promelas) exposed to 17alpha-ethynylestradiol and 17beta-trenbolone. BMC systems biology 5: 63. ")
										.<Reference> makeItLive());
				cellular_effect1_to_organ_effect1.getReferenceIDs().add(new Reference(cellular_effect1_to_organ_effect1, dataSource,
						"Baker ME. 2011. Origin and diversification of steroids: co-evolution of enzymes and nuclear receptors. Molecular and cellular endocrinology 334(1-2): 14-20. ").<Reference> makeItLive());
				cellular_effect1_to_organ_effect1.getReferenceIDs().add(new Reference(cellular_effect1_to_organ_effect1, dataSource, "Mammals ").<Reference> makeItLive());
				cellular_effect1_to_organ_effect1.getReferenceIDs()
						.add(new Reference(cellular_effect1_to_organ_effect1, dataSource,
								"Davis, B J, R Weaver, L J Gaines, and J J Heindel. 1994. â€œMono-(2-Ethylhexyl) Phthalate Suppresses Estradiol Production Independent of FSH-cAMP Stimulation in Rat Granulosa Cells.â€� Toxicology and Applied Pharmacology 128 (2) (October): 224â€“8. doi:10.1006/taap.1994.1201. ")
										.<Reference> makeItLive());
				cellular_effect1_to_organ_effect1.getReferenceIDs()
						.add(new Reference(cellular_effect1_to_organ_effect1, dataSource,
								"Gupta, Rupesh K, Jeffery M Singh, Tracie C Leslie, Sharon Meachum, Jodi a Flaws, and Humphrey H-C Yao. 2010. â€œDi-(2-Ethylhexyl) Phthalate and Mono-(2-Ethylhexyl) Phthalate Inhibit Growth and Reduce Estradiol Levels of Antral Follicles in Vitro.â€� Toxicology and Applied Pharmacology 242 (2) (January 15): 224â€“30. doi:10.1016/j.taap.2009.10.011. ")
										.<Reference> makeItLive());
				cellular_effect1_to_organ_effect1.getReferenceIDs()
						.add(new Reference(cellular_effect1_to_organ_effect1, dataSource,
								"Laskey, J.W., and E. Berman. 1993. â€œSteroidogenic Assessment Using Ovary Culture in Cycling Rats: Effects of Bis (2-Diethylhexyl) Phthalate on Ovarian Steroid Production.â€� Reproductive Toxicology 7 (1) (January): 25â€“33. doi:10.1016/0890-6238(93)90006-S. ")
										.<Reference> makeItLive());
				cellular_effect1_to_organ_effect1.getReferenceIDs()
						.add(new Reference(cellular_effect1_to_organ_effect1, dataSource,
								"Lovekamp, T N, and B J Davis. 2001. â€œMono-(2-Ethylhexyl) Phthalate Suppresses Aromatase Transcript Levels and Estradiol Production in Cultured Rat Granulosa Cells.â€� Toxicology and Applied Pharmacology 172 (3) (May 1): 217â€“24. doi:10.1006/taap.2001.9156. ")
										.<Reference> makeItLive());
				cellular_effect1_to_organ_effect1.getReferenceIDs()
						.add(new Reference(cellular_effect1_to_organ_effect1, dataSource,
								"Reinsberg, Jochen, Petra Wegener-Toper, Katrin van der Ven, Hans van der Ven, and Dietrich Klingmueller. 2009. â€œEffect of Mono-(2-Ethylhexyl) Phthalate on Steroid Production of Human Granulosa Cells.â€� Toxicology and Applied Pharmacology 239 (1) (August 15): 116â€“23. doi:10.1016/j.taap.2009.05.022. ")
										.<Reference> makeItLive());
				cellular_effect1_to_organ_effect1.getReferenceIDs()
						.add(new Reference(cellular_effect1_to_organ_effect1, dataSource,
								"Xu, Chuan, Ji-An Chen, Zhiqun Qiu, Qing Zhao, Jiaohua Luo, Lan Yang, Hui Zeng, et al. 2010. â€œOvotoxicity and PPAR-Mediated Aromatase Downregulation in Female Sprague-Dawley Rats Following Combined Oral Exposure to Benzo[a]pyrene and Di-(2-Ethylhexyl) Phthalate.â€� Toxicology Letters 199 (3) (December 15): 323â€“32. doi:10.1016/j.toxlet.2010.09.015. ")
										.<Reference> makeItLive());
				
				organ_effect1_to_organ_effect2.setLinkType(LinkType.DIRECT);
				ReferenceIDW<Link_EffectToEffect> organ_effect1_to_organ_effect2_weigth0 = new ReferenceIDW<Link_EffectToEffect>(organ_effect1_to_organ_effect2, dataSource, Link_EffectToEffect.class, 3.0);
				organ_effect1_to_organ_effect2.getDescriptionIDs()
						.set(new DescriptionSection_Structured(organ_effect1_to_organ_effect2, dataSource, "(Key) Event Relationships Weight of Evidences",
								"THIS DESCRIPTION IS IN FACT FOR THE KER â€œPLASMA 17BETA-ESTRADIOL CONCENTRATIONS, REDUCTION DIRECTLY LEADS TO VITELLOGENIN SYNTHESIS IN LIVER, REDUCTIONâ€� HOWEVER THE SYSTEM DOES NOT DESCRIBE THE DIRECTIONALITY OF THE KER AND THE TITLE IS AUTOMATICALLY CREATED FROM CELLULAR TO ORGAN DIRECTION. DOES NOT ALLOW EDITING.\n\n•  Biological Plausibility: \n\nVitellogenin synthesis in fish is localized in the liver and is well documented to be regulated by estrogens via interaction with estrogen receptors (Tyler et al. 1996; Tyler and Sumpter 1996; Arukwe and GoksÃ¸yr 2003). The vitellogenin gene contains estrogen repsonsive elements in its promoter region and site directed mutagenesis has shown these to be essential for estrogen-dependent expression of vitellogenin (Chang et al. 1992; Teo et al. 1998). Liver is not regarded as a major site of E2 synthesis (Norris 2007), therefore the majority of E2 in liver comes from the circulation. \n\nEstrogen regulates expression of the vitellogenin gene in the amphibian Xenopus laevis (Skipper and Hamilton, 1977). \n\n•  Empirical Support for Linkage:\n\nIn a number of time-course experiments with aromatase inhibitors (e.g., fadrozole, prochloraz), decreases in plasma estradiol concentrations precede decreases in plasma vitellogenin concentrations (Villeneuve et al. 2009; Skolness et al. 2011; Ankley et al. 2009b). Recovery of plasma E2 concentrations also precedes recovery of plasma VTG concentrations after cessation of exposure (Villeneuve et al. 2009; Ankley et al. 2009a; Villeneuve et al. 2013). \n\nIt was demonstrated in Danio rerio that in vivo exposure to the aromatase inhibitor letrozole significantly reduced the expression of mRNA transcripts coding for vtg1, vtg2, and erÎ±, all of which are known to be regulated by estrogens (Sun et al. 2010). However, similar effects were not observed in primary cultured hepatocytes from Danio rerio, indicating that letrozoleâ€™s effects on vtg transcription were not direct. \n\nMany studies have demonstrated that exposure of hepatocytes to estrogens in vitro or in vivo induce vitellogenin mRNA synthesis (e.g., see reviews by (Navas and Segner 2006; Iguchi et al. 2006)). \n\nIn female fathead minnows exposed to 17Î²-trenbolone, significant reductions in plasma E2 concentrations preceded significant reductions in plasma VTG (Ekman et al. 2011). \n\nIntra-arterial injection of the estrogen 17Î± ethynyl estradiol into male rainbow trout causes vitellogenin induction with about a 12 h lag time before increasing from basal levels (Schultz et al. 2001). \n\n•  Uncertainties or Inconsistencies:\n\nBased on the limited set of studies available to date, there are no known inconsistencies. \n\n",
								organ_effect1_to_organ_effect2_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
				organ_effect1_to_organ_effect2.getDescriptionIDs()
						.set(new DescriptionSection(organ_effect1_to_organ_effect2, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Key enzymes needed to synthesize 17Î²-estradiol first appear in the common ancestor of amphioxus and vertebrates (Baker 2011). However, non-oviparous vertebrates do not require vitellogenin. Consequently, this KER is applicable to oviparous vertebrates. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								2);
				organ_effect1_to_organ_effect2.getDescriptionIDs()
						.set(new DescriptionSection(organ_effect1_to_organ_effect2, dataSource, "Quantitative Understading",
								"At least two computational models that include functions which link circulating concentrations of E2 to VTG production by the liver have been published (Li et al. 2011a; Murphy et al. 2005; Murphy et al. 2009), although both models focus on predicting plasma VTG concentrations rather than transcription or translation within the liver. A significant positive correlation (r=0.87) between plasma E2 concentrations corresponding plasma VTG concentrations in female fathead minnows held under laboratory conditions has also been reported (Ankley et al. 2008). \n\nThere are multiple isoforms of vitellogenin. The sensitivity and inducibility of each of those isoforms may vary somewhat. Consequently, response-response relationships may vary somewhat depending on the speicific isoform for which QPCR primers or antibodies were developed.\n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								3);
				organ_effect1_to_organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect1_to_organ_effect2, dataSource, "Tyler C, Sumpter J. 1996. Oocyte growth and development in teleosts. Reviews in Fish Biology and Fisheries 6: 287-318. ")
								.<Reference> makeItLive());
				organ_effect1_to_organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect1_to_organ_effect2, dataSource,
								"Tyler C, van der Eerden B, Jobling S, Panter G, Sumpter J. 1996. Measurement of vitellogenin, a biomarker for exposure to oestrogenic chemicals, in a wide variety of cyprinid fish. Journal of Comparative Physiology and Biology 166: 418-426. ")
										.<Reference> makeItLive());
				organ_effect1_to_organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect1_to_organ_effect2, dataSource,
								"Arukwe A, GoksÃ¸yr A. 2003. Eggshell and egg yolk proteins in fish: hepatic proteins for the next generation: oogenetic, population, and evolutionary implications of endocrine disruption. Comparative Hepatology 2(4): 1-21. ")
										.<Reference> makeItLive());
				organ_effect1_to_organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect1_to_organ_effect2, dataSource, "Norris DO. 2007. Vertebrate Endocrinology. Fourth ed. New York: Academic Press. ").<Reference> makeItLive());
				organ_effect1_to_organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect1_to_organ_effect2, dataSource,
								"Villeneuve DL, Mueller ND, Martinovic D, Makynen EA, Kahl MD, Jensen KM, et al. 2009. Direct effects, compensation, and recovery in female fathead minnows exposed to a model aromatase inhibitor. Environ Health Perspect 117(4): 624-631. ")
										.<Reference> makeItLive());
				organ_effect1_to_organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect1_to_organ_effect2, dataSource,
								"Skolness SY, Durhan EJ, Garcia-Reyero N, Jensen KM, Kahl MD, Makynen EA, et al. 2011. Effects of a short-term exposure to the fungicide prochloraz on endocrine function and gene expression in female fathead minnows (Pimephales promelas). Aquat Toxicol 103(3-4): 170-178. ")
										.<Reference> makeItLive());
				organ_effect1_to_organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect1_to_organ_effect2, dataSource,
								"Ankley GT, Bencic D, Cavallin JE, Jensen KM, Kahl MD, Makynen EA, et al. 2009b. Dynamic nature of alterations in the endocrine system of fathead minnows exposed to the fungicide prochloraz. Toxicol Sci 112(2): 344-353. ")
										.<Reference> makeItLive());
				organ_effect1_to_organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect1_to_organ_effect2, dataSource,
								"Ankley GT, Bencic DC, Cavallin JE, Jensen KM, Kahl MD, Makynen EA, et al. 2009a. Dynamic nature of alterations in the endocrine system of fathead minnows exposed to the fungicide prochloraz. Toxicological sciences : an official journal of the Society of Toxicology 112(2): 344-353. ")
										.<Reference> makeItLive());
				organ_effect1_to_organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect1_to_organ_effect2, dataSource,
								"Villeneuve DL, Breen M, Bencic DC, Cavallin JE, Jensen KM, Makynen EA, et al. 2013. Developing Predictive Approaches to Characterize Adaptive Responses of the Reproductive Endocrine Axis to Aromatase Inhibition: I. Data Generation in a Small Fish Model. Toxicological sciences : an official journal of the Society of Toxicology. ")
										.<Reference> makeItLive());
				organ_effect1_to_organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect1_to_organ_effect2, dataSource,
								"Sun L, Wen L, Shao X, Qian H, Jin Y, Liu W, et al. 2010. Screening of chemicals with anti-estrogenic activity using in vitro and in vivo vitellogenin induction responses in zebrafish (Danio rerio). Chemosphere 78(7): 793-799. ")
										.<Reference> makeItLive());
				organ_effect1_to_organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect1_to_organ_effect2, dataSource,
								"Iguchi T, Irie F, Urushitani H, Tooi O, Kawashima Y, Roberts M, et al. 2006. Availability of in vitro vitellogenin assay for screening of estrogenic and anti-estrogenic activities of environmental chemicals. Environ Sci 13(3): 161-183. ")
										.<Reference> makeItLive());
				organ_effect1_to_organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect1_to_organ_effect2, dataSource,
								"Navas JM, Segner H. 2006. Vitellogenin synthesis in primary cultures of fish liver cells as endpoint for in vitro screening of the (anti)estrogenic activity of chemical substances. Aquat Toxicol 80(1): 1-22. ")
										.<Reference> makeItLive());
				organ_effect1_to_organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect1_to_organ_effect2, dataSource,
								"Ekman DR, Villeneuve DL, Teng Q, Ralston-Hooper KJ, Martinovic-Weigelt D, Kahl MD, et al. 2011. Use of gene expression, biochemical and metabolite profiles to enhance exposure and effects assessment of the model androgen 17beta-trenbolone in fish. Environmental toxicology and chemistry / SETAC 30(2): 319-329. ")
										.<Reference> makeItLive());
				organ_effect1_to_organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect1_to_organ_effect2, dataSource,
								"Schultz IR, Orner G, Merdink JL, Skillman A. 2001. Dose-response relationships and pharmacokinetics of vitellogenin in rainbow trout after intravascular administration of 17alpha-ethynylestradiol. Aquatic toxicology 51(3): 305-318. ")
										.<Reference> makeItLive());
				organ_effect1_to_organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect1_to_organ_effect2, dataSource,
								"Li Z, Kroll KJ, Jensen KM, Villeneuve DL, Ankley GT, Brian JV, et al. 2011a. A computational model of the hypothalamic: pituitary: gonadal axis in female fathead minnows (Pimephales promelas) exposed to 17alpha-ethynylestradiol and 17beta-trenbolone. BMC systems biology 5: 63. ")
										.<Reference> makeItLive());
				organ_effect1_to_organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect1_to_organ_effect2, dataSource,
								"Murphy CA, Rose KA, Rahman MS, Thomas P. 2009. Testing and applying a fish vitellogenesis model to evaluate laboratory and field biomarkers of endocrine disruption in Atlantic croaker (Micropogonias undulatus) exposed to hypoxia. Environmental toxicology and chemistry / SETAC 28(6): 1288-1303. ")
										.<Reference> makeItLive());
				organ_effect1_to_organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect1_to_organ_effect2, dataSource,
								"Murphy CA, Rose KA, Thomas P. 2005. Modeling vitellogenesis in female fish exposed to environmental stressors: predicting the effects of endocrine disturbance due to exposure to a PCB mixture and cadmium. Reproductive toxicology 19(3): 395-409. ")
										.<Reference> makeItLive());
				organ_effect1_to_organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect1_to_organ_effect2, dataSource,
								"Ankley GT, Miller DH, Jensen KM, Villeneuve DL, Martinovic D. 2008. Relationship of plasma sex steroid concentrations in female fathead minnows to reproductive success and population status. Aquatic toxicology 88(1): 69-74. ")
										.<Reference> makeItLive());
				organ_effect1_to_organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect1_to_organ_effect2, dataSource, "Skipper JK, Hamilton TH. 1977. Regulation by estrogen of the vitellogenin gene. Proc Natl Acad Sci USA 74:2384-2388. ")
								.<Reference> makeItLive());
				organ_effect1_to_organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect1_to_organ_effect2, dataSource,
								"Chang TC, Nardulli AM, Lew D, and Shapiro, DJ. 1992. The role of estrogen response elements in expression of the Xenopus laevis vitellogenin B1 gene. Molecular Endocrinology 6:3, 346-354\\ ")
										.<Reference> makeItLive());
				organ_effect1_to_organ_effect2.getReferenceIDs().add(new Reference(organ_effect1_to_organ_effect2, dataSource,
						"Teo BY, Tan NS, Lim EH, Lam TJ, Ding JL. A novel piscine vitellogenin gene: structural and functional analyses of estrogen-inducible promoter. Mol Cell ").<Reference> makeItLive());
				organ_effect1_to_organ_effect2.getReferenceIDs()
						.add(new Reference(organ_effect1_to_organ_effect2, dataSource, "Endocrinol. 1998 Nov 25;146(1-2):103-20. PubMed PMID: 10022768. ").<Reference> makeItLive());
				
				organ_effect2_to_organ_effect3.setLinkType(LinkType.DIRECT);
				ReferenceIDW<Link_EffectToEffect> organ_effect2_to_organ_effect3_weigth0 = new ReferenceIDW<Link_EffectToEffect>(organ_effect2_to_organ_effect3, dataSource, Link_EffectToEffect.class, 3.0);
				organ_effect2_to_organ_effect3.getDescriptionIDs()
						.set(new DescriptionSection_Structured(organ_effect2_to_organ_effect3, dataSource, "(Key) Event Relationships Weight of Evidences",
								"•  Biological Plausibility: \n\nLiver is the major source of VTG protein production in fish (Tyler and Sumpter 1996; Arukwe and GoksÃ¸yr 2003). Protein production involves transcription and subsequent translation. The time-lag between decreases in transcription/translation and decreases in plasma VTG concentrations can be expected to be dependent on vitellogenin elimination half-lives. \n\n•  Empirical Support for Linkage:\n\nIn a number of time-course experiments with aromatase inhibitors, decreases in plasma estradiol concentrations precede decreases in plasma vitellogenin concentrations (Villeneuve et al. 2009; Skolness et al. 2011; Ankley et al. 2009b). Recovery of plasma E2 concentrations also precedes recovery of plasma VTG concentrations after cessation of exposure (Villeneuve et al. 2009; Ankley et al. 2009a; Villeneuve et al. 2013). \n\nIn experiments with strong estrogens, increases in vtg mRNA synthesis precede increases in plasma VTG concentration (Korte et al. 2000; Schmid et al. 2002). \n\nElimination half-lives for VTG protein have been determined for induced male fish, but to our knowledge, similar kinetic studies have not been done for reproductively mature females (Korte et al. 2000; Schultz et al. 2001). \n\nIn male sheepshead minnows injected with E2, induction of VTG mRNA precedes induction of plasma VTG (Bowman et al. 2000). \n\nIn male Cichlasoma dimerus exposed to octylphenol for 28 days and then held in clean water, decline in induced VTG mRNA concentrations precedes declines in induced plasma VTG concentrations (Genovese et al. 2012). \n\n•  Uncertainties or Inconsistencies:\n\nThere are no known inconsistencies between these KERs which are not readily explained on the basis of the expected dose, temporal, and incidence relationships between these two KERs. This applies across a significant body of literature in which these two KEs have been measured. \n\n",
								organ_effect2_to_organ_effect3_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
				organ_effect2_to_organ_effect3.getDescriptionIDs()
						.set(new DescriptionSection(organ_effect2_to_organ_effect3, dataSource, "Evidence Supporting Taxonomic Applicability",
								"This KER primarily applies to taxa that synthesize vitellogenin in the liver which is transported elsewhere in the body via plasma. ").setFormat(ContentFormat.TEXT)
										.<DescriptionSection> makeItLive(),
								2);
				organ_effect2_to_organ_effect3.getDescriptionIDs()
						.set(new DescriptionSection(organ_effect2_to_organ_effect3, dataSource, "Quantitative Understading",
								"Due to temporal disconnects (lag) between induction of mRNA transcription and translation and significant changes in plasma concentrations as well as variable rates of uptake of VTG from plasma into oocytes, a precise quantitative relationship between VTG transcription/translation and circulating VTG concentrations has not been described. However, models and statistical relationships that define quantitative relationships between circulating E2 concentrations and circulating VTG concentrations have been developed (Li et al. 2011a; Murphy et al. 2005; Murphy et al. 2009; Ankley et al. 2008).")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								3);
				organ_effect2_to_organ_effect3.getReferenceIDs()
						.add(new Reference(organ_effect2_to_organ_effect3, dataSource, "Tyler C, Sumpter J. 1996. Oocyte growth and development in teleosts. Reviews in Fish Biology and Fisheries 6: 287-318. ")
								.<Reference> makeItLive());
				organ_effect2_to_organ_effect3.getReferenceIDs()
						.add(new Reference(organ_effect2_to_organ_effect3, dataSource,
								"Arukwe A, GoksÃ¸yr A. 2003. Eggshell and egg yolk proteins in fish: hepatic proteins for the next generation: oogenetic, population, and evolutionary implications of endocrine disruption. Comparative Hepatology 2(4): 1-21. ")
										.<Reference> makeItLive());
				organ_effect2_to_organ_effect3.getReferenceIDs()
						.add(new Reference(organ_effect2_to_organ_effect3, dataSource,
								"Villeneuve DL, Mueller ND, Martinovic D, Makynen EA, Kahl MD, Jensen KM, et al. 2009. Direct effects, compensation, and recovery in female fathead minnows exposed to a model aromatase inhibitor. Environ Health Perspect 117(4): 624-631. ")
										.<Reference> makeItLive());
				organ_effect2_to_organ_effect3.getReferenceIDs()
						.add(new Reference(organ_effect2_to_organ_effect3, dataSource,
								"Skolness SY, Durhan EJ, Garcia-Reyero N, Jensen KM, Kahl MD, Makynen EA, et al. 2011. Effects of a short-term exposure to the fungicide prochloraz on endocrine function and gene expression in female fathead minnows (Pimephales promelas). Aquat Toxicol 103(3-4): 170-178. ")
										.<Reference> makeItLive());
				organ_effect2_to_organ_effect3.getReferenceIDs()
						.add(new Reference(organ_effect2_to_organ_effect3, dataSource,
								"Ankley GT, Bencic D, Cavallin JE, Jensen KM, Kahl MD, Makynen EA, et al. 2009b. Dynamic nature of alterations in the endocrine system of fathead minnows exposed to the fungicide prochloraz. Toxicol Sci 112(2): 344-353. ")
										.<Reference> makeItLive());
				organ_effect2_to_organ_effect3.getReferenceIDs()
						.add(new Reference(organ_effect2_to_organ_effect3, dataSource,
								"Ankley GT, Bencic DC, Cavallin JE, Jensen KM, Kahl MD, Makynen EA, et al. 2009a. Dynamic nature of alterations in the endocrine system of fathead minnows exposed to the fungicide prochloraz. Toxicological sciences : an official journal of the Society of Toxicology 112(2): 344-353. ")
										.<Reference> makeItLive());
				organ_effect2_to_organ_effect3.getReferenceIDs()
						.add(new Reference(organ_effect2_to_organ_effect3, dataSource,
								"Villeneuve DL, Breen M, Bencic DC, Cavallin JE, Jensen KM, Makynen EA, et al. 2013. Developing Predictive Approaches to Characterize Adaptive Responses of the Reproductive Endocrine Axis to Aromatase Inhibition: I. Data Generation in a Small Fish Model. Toxicological sciences : an official journal of the Society of Toxicology. ")
										.<Reference> makeItLive());
				organ_effect2_to_organ_effect3.getReferenceIDs()
						.add(new Reference(organ_effect2_to_organ_effect3, dataSource,
								"Korte JJ, Kahl MD, Jensen KM, Mumtaz SP, Parks LG, LeBlanc GA, et al. 2000. Fathead minnow vitellogenin: complementary DNA sequence and messenger RNA and protein expression after 17B-estradiol treatment. Environmental Toxicology and Chemistry 19(4): 972-981. ")
										.<Reference> makeItLive());
				organ_effect2_to_organ_effect3.getReferenceIDs()
						.add(new Reference(organ_effect2_to_organ_effect3, dataSource,
								"Schmid T, Gonzalez-Valero J, Rufli H, Dietrich DR. 2002. Determination of vitellogenin kinetics in male fathead minnows (Pimephales promelas). Toxicol Lett 131(1-2): 65-74. ")
										.<Reference> makeItLive());
				organ_effect2_to_organ_effect3.getReferenceIDs()
						.add(new Reference(organ_effect2_to_organ_effect3, dataSource,
								"Schultz IR, Orner G, Merdink JL, Skillman A. 2001. Dose-response relationships and pharmacokinetics of vitellogenin in rainbow trout after intravascular administration of 17alpha-ethynylestradiol. Aquatic toxicology 51(3): 305-318. ")
										.<Reference> makeItLive());
				organ_effect2_to_organ_effect3.getReferenceIDs()
						.add(new Reference(organ_effect2_to_organ_effect3, dataSource,
								"Bowman CJ, Kroll KJ, Hemmer MJ, Folmar LC, Denslow ND. 2000. Estrogen-induced vitellogenin mRNA and protein in sheepshead minnow (Cyprinodon variegatus). General and comparative endocrinology 120(3): 300-313. ")
										.<Reference> makeItLive());
				organ_effect2_to_organ_effect3.getReferenceIDs()
						.add(new Reference(organ_effect2_to_organ_effect3, dataSource,
								"Genovese G, Regueira M, Piazza Y, Towle DW, Maggese MC, Lo Nostro F. 2012. Time-course recovery of estrogen-responsive genes of a cichlid fish exposed to waterborne octylphenol. Aquatic toxicology 114-115: 1-13. ")
										.<Reference> makeItLive());
				organ_effect2_to_organ_effect3.getReferenceIDs()
						.add(new Reference(organ_effect2_to_organ_effect3, dataSource,
								"Li Z, Kroll KJ, Jensen KM, Villeneuve DL, Ankley GT, Brian JV, et al. 2011a. A computational model of the hypothalamic: pituitary: gonadal axis in female fathead minnows (Pimephales promelas) exposed to 17alpha-ethynylestradiol and 17beta-trenbolone. BMC systems biology 5: 63. ")
										.<Reference> makeItLive());
				organ_effect2_to_organ_effect3.getReferenceIDs()
						.add(new Reference(organ_effect2_to_organ_effect3, dataSource,
								"Murphy CA, Rose KA, Rahman MS, Thomas P. 2009. Testing and applying a fish vitellogenesis model to evaluate laboratory and field biomarkers of endocrine disruption in Atlantic croaker (Micropogonias undulatus) exposed to hypoxia. Environmental toxicology and chemistry / SETAC 28(6): 1288-1303. ")
										.<Reference> makeItLive());
				organ_effect2_to_organ_effect3.getReferenceIDs()
						.add(new Reference(organ_effect2_to_organ_effect3, dataSource,
								"Murphy CA, Rose KA, Thomas P. 2005. Modeling vitellogenesis in female fish exposed to environmental stressors: predicting the effects of endocrine disturbance due to exposure to a PCB mixture and cadmium. Reproductive toxicology 19(3): 395-409. ")
										.<Reference> makeItLive());
				organ_effect2_to_organ_effect3.getReferenceIDs()
						.add(new Reference(organ_effect2_to_organ_effect3, dataSource,
								"Ankley GT, Miller DH, Jensen KM, Villeneuve DL, Martinovic D. 2008. Relationship of plasma sex steroid concentrations in female fathead minnows to reproductive success and population status. Aquatic toxicology 88(1): 69-74. ")
										.<Reference> makeItLive());
				
				organ_effect3_to_organ_effect4.setLinkType(LinkType.UNKNOWN);
				ReferenceIDW<Link_EffectToEffect> organ_effect3_to_organ_effect4_weigth0 = new ReferenceIDW<Link_EffectToEffect>(organ_effect3_to_organ_effect4, dataSource, Link_EffectToEffect.class, 2.0);
				organ_effect3_to_organ_effect4.getDescriptionIDs()
						.set(new DescriptionSection_Structured(organ_effect3_to_organ_effect4, dataSource, "(Key) Event Relationships Weight of Evidences",
								"THIS DESCRIPTION IS IN FACT FOR THE KER â€œPLASMA VITELLOGENIN CONCENTRATIONS, REDUCTION DIRECTLY LEADS TO VITELLOGENIN ACCUMULATION INTO OOCYTES AND OOCYTE GROWTH/DEVELOPMENT, REDUCTIONâ€�. HOWEVER THE SYSTEM DOES NOT DESCRIBE THE DIRECTIONALITY OF THE KER AND THE TITLE IS AUTOMATICALLY CREATED FROM CELLULAR TO ORGAN DIRECTION. DOES NOT ALLOW EDITING.\n\n•  Biological Plausibility: \n\nVitellogenin synthesized in the liver and transported to the ovary via the circulation is the primary source of egg yolk proteins in fish (Tyler and Sumpter 1996; Arukwe and GoksÃ¸yr 2003). In many teleosts vitellogenesis can account for up to 95% of total egg size (Tyler and Sumpter 1996). \n\n•  Empirical Support for Linkage:\n\nIn some (Ankley et al. 2002; Ankley et al. 2003; Lalone et al. 2013), but not all (Ankley et al. 2005; Sun et al. 2007; Skolness et al. 2013) fish reproduction studies, reductions in plasma vitellogenin have been associated with visible decreases in yolk protein content in oocytes and overall reductions in ovarian stage. \n\n•  Uncertainties or Inconsistencies:\n\nNot all fish reproduction studies showing reductions in plasma vitellogenin have caused visible decreases in yolk protein content in oocytes and overall reductions in ovarian stage. (Ankley et al. 2005; Sun et al. 2007; Skolness et al. 2013). \n\nWhile plasma vitellogenin is well established as the only major source of vitellogenins to the oocyte, the extent to which a decrease will impact an ovary that has already developed vitellogenic staged oocytes is less certain. It would be assumed that the more rapid the turn-over of oocytes in the ovary, the tighter the linkage between these KEs. Thus, repeat spawning species with asynchronous oocyte development that spawn frequently would likely be more vulnerable than annual spawning species with synchronous oocyte development that had already reached late vitellogenic stages. \n\n",
								organ_effect3_to_organ_effect4_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
				organ_effect3_to_organ_effect4.getDescriptionIDs()
						.set(new DescriptionSection(organ_effect3_to_organ_effect4, dataSource, "Evidence Supporting Taxonomic Applicability",
								"This KER is expected to be primarily applicable to oviparous vertebrates that synthesize vitellogenin in hepatic tissue which is ultimately incorporated into oocytes present in the ovary.")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								2);
				organ_effect3_to_organ_effect4.getDescriptionIDs()
						.set(new DescriptionSection(organ_effect3_to_organ_effect4, dataSource, "Quantitative Understading",
								"Rates of vitellogenin uptake as a function of ovarian follicle surface area have been estimated for rainbow trout, an annual spawning fish species, and may exceed 700 ng/mm2 follicle surface per hour (Tyler and Sumpter 1996). \n\nComparable data are lacking for repeat-spawning species and kinetic relationships between plasma concentrations and uptake rates within the ovary have not been defined. \n\nA model based on a statistical relationship between plasma E2 concentrations, spawning interval, and cumulative fecundity has been developed to predict changes in cumulative fecundity from plasma VTG (Li et al. 2011b), but it does not incorporate a model of the kinetics of VTG uptake nor the influence of VTG uptake on oocyte growth. \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								3);
				organ_effect3_to_organ_effect4.getReferenceIDs()
						.add(new Reference(organ_effect3_to_organ_effect4, dataSource, "Tyler C, Sumpter J. 1996. Oocyte growth and development in teleosts. Reviews in Fish Biology and Fisheries 6: 287-318. ")
								.<Reference> makeItLive());
				organ_effect3_to_organ_effect4.getReferenceIDs()
						.add(new Reference(organ_effect3_to_organ_effect4, dataSource,
								"Arukwe A, GoksÃ¸yr A. 2003. Eggshell and egg yolk proteins in fish: hepatic proteins for the next generation: oogenetic, population, and evolutionary implications of endocrine disruption. Comparative Hepatology 2(4): 1-21. ")
										.<Reference> makeItLive());
				organ_effect3_to_organ_effect4.getReferenceIDs()
						.add(new Reference(organ_effect3_to_organ_effect4, dataSource,
								"Ankley GT, Jensen KM, Makynen EA, Kahl MD, Korte JJ, Hornung MW, et al. 2003. Effects of the androgenic growth promoter 17-ï�¢-trenbolone on fecundity and reproductive endocrinology of the fathead minnow. Environmental Toxicology and Chemistry 22(6): 1350-1360. ")
										.<Reference> makeItLive());
				organ_effect3_to_organ_effect4.getReferenceIDs()
						.add(new Reference(organ_effect3_to_organ_effect4, dataSource,
								"Ankley GT, Kahl MD, Jensen KM, Hornung MW, Korte JJ, Makynen EA, et al. 2002. Evaluation of the aromatase inhibitor fadrozole in a short-term reproduction assay with the fathead minnow (Pimephales promelas). Toxicological Sciences 67: 121-130. ")
										.<Reference> makeItLive());
				organ_effect3_to_organ_effect4.getReferenceIDs()
						.add(new Reference(organ_effect3_to_organ_effect4, dataSource,
								"Ankley GT, Jensen KM, Durhan EJ, Makynen EA, Butterworth BC, Kahl MD, et al. 2005. Effects of two fungicides with multiple modes of action on reproductive endocrine function in the fathead minnow (Pimephales promelas). Toxicol Sci 86(2): 300-308. ")
										.<Reference> makeItLive());
				organ_effect3_to_organ_effect4.getReferenceIDs()
						.add(new Reference(organ_effect3_to_organ_effect4, dataSource,
								"Sun L, Zha J, Spear PA, Wang Z. 2007. Toxicity of the aromatase inhibitor letrozole to Japanese medaka (Oryzias latipes) eggs, larvae and breeding adults. Comp Biochem Physiol C Toxicol Pharmacol 145(4): 533-541. ")
										.<Reference> makeItLive());
				organ_effect3_to_organ_effect4.getReferenceIDs()
						.add(new Reference(organ_effect3_to_organ_effect4, dataSource,
								"Skolness SY, Blanksma CA, Cavallin JE, Churchill JJ, Durhan EJ, Jensen KM, et al. 2013. Propiconazole Inhibits Steroidogenesis and Reproduction in the Fathead Minnow (Pimephales promelas). Toxicological sciences : an official journal of the Society of Toxicology 132(2): 284-297. ")
										.<Reference> makeItLive());
				organ_effect3_to_organ_effect4.getReferenceIDs()
						.add(new Reference(organ_effect3_to_organ_effect4, dataSource,
								"Li Z, Villeneuve DL, Jensen KM, Ankley GT, Watanabe KH. 2011b. A computational model for asynchronous oocyte growth dynamics in a batch-spawning fish. Can J Fish Aquat Sci 68: 1528-1538. ")
										.<Reference> makeItLive());
				
				organ_effect4_to_individual_effect1.setLinkType(LinkType.UNKNOWN);
				ReferenceIDW<Link_EffectToEffect> organ_effect4_to_individual_effect1_weigth0 = new ReferenceIDW<Link_EffectToEffect>(organ_effect4_to_individual_effect1, dataSource, Link_EffectToEffect.class,
						2.0);
				organ_effect4_to_individual_effect1.getDescriptionIDs()
						.set(new DescriptionSection_Structured(organ_effect4_to_individual_effect1, dataSource, "(Key) Event Relationships Weight of Evidences",
								"•  Biological Plausibility: \n\nVitellogenesis is a critical stage of oocyte development and accumulated lipids and yolk proteins make up the majority of oocyte biomass (Tyler and Sumpter 1996). At least in mammals, maintenance of meiotic arrest is supported by signals transmitted through gap junctions between the granulosa cells and oocytes (Jamnongjit and Hammes 2005). Disruption of oocyte-granulosa contacts as a result of cell growth has been shown to coincide with oocyte maturation (Eppig 1994). However, it remains unclear whether the relationship between vitellogenin accumulation and oocyte growth and eventual maturation is causal or simply correlative. \n\n•  Empirical Support for Linkage:\n\nAt present, to our best knowledge there are no studies that definitively demonstrate a direct cause-effect relationship between impaired VTG accumulation into oocytes and impaired spawning. There is, however, strong correlative evidence. Across a range of laboratory studies with small fish, there is a robust and statistically significant correlation between reductions in circulating VTG concentrations and reductions in cumulative fecundity (Miller et al. 2007). To date, we are unaware of any fish reproduction studies which show a large reduction in circulating VTG concentrations, but not reductions in cumulative fecundity. \n\n•  Uncertainties or Inconsistencies:\n\nBased on the limited number of studies available that have examined both of these KEs, there are no known, unexplained, results that are inconsistent with this relationship. \n\n",
								organ_effect4_to_individual_effect1_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
				organ_effect4_to_individual_effect1.getDescriptionIDs()
						.set(new DescriptionSection(organ_effect4_to_individual_effect1, dataSource, "Evidence Supporting Taxonomic Applicability",
								"On the basis of the taxonomic relevance of the two KEs linked via this KER, this KER is likely applicable to aquatic, oviparous, vertebrates which both produce vitellogenin and deposit eggs/sperm into an aquatic environment. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								2);
				organ_effect4_to_individual_effect1.getDescriptionIDs()
						.set(new DescriptionSection(organ_effect4_to_individual_effect1, dataSource, "Quantitative Understading",
								"Across a range of laboratory studies with fathead minnow, there is a robust and statistically significant correlation between reductions in circulating VTG concentrations and reductions in cumulative fecundity (Miller et al. 2007). At present it is unclear how well that relationship may hold for other fish species or feral fish under the influence of environmental variables. A model based on a statistical relationship between plasma E2 concentrations, spawning interval, and cumulative fecundity has been developed to predict changes in cumulative fecundity from plasma VTG (Li et al. 2011b). However, to date, such models do not specifically consider vitellogenin uptake into oocytes as a quantitative predictor of fecundity. Furthermore, with the exception of a few specialized studies, quantitative measures of VTG content in oocytes are rarely measured in toxicity studies. In contrast, plasma VTG is routinely measured. .")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								3);
				organ_effect4_to_individual_effect1.getReferenceIDs()
						.add(new Reference(organ_effect4_to_individual_effect1, dataSource, "Tyler C, Sumpter J. 1996. Oocyte growth and development in teleosts. Reviews in Fish Biology and Fisheries 6: 287-318. ")
								.<Reference> makeItLive());
				organ_effect4_to_individual_effect1.getReferenceIDs().add(new Reference(organ_effect4_to_individual_effect1, dataSource,
						"Jamnongjit M, Hammes SR. 2005. Oocyte maturation: the coming of age of a germ cell. Seminars in reproductive medicine 23(3): 234-241. ").<Reference> makeItLive());
				organ_effect4_to_individual_effect1.getReferenceIDs().add(
						new Reference(organ_effect4_to_individual_effect1, dataSource, "Eppig JJ. 1994. Further reflections on culture systems for the growth of oocytes in vitro. Human reproduction 9(6): 974-976. ")
								.<Reference> makeItLive());
				organ_effect4_to_individual_effect1.getReferenceIDs()
						.add(new Reference(organ_effect4_to_individual_effect1, dataSource,
								"Miller DH, Jensen KM, Villeneuve DL, Kahl MD, Makynen EA, Durhan EJ, et al. 2007. Linkage of biochemical responses to population-level effects: a case study with vitellogenin in the fathead minnow (Pimephales promelas). Environ Toxicol Chem 26(3): 521-527. ")
										.<Reference> makeItLive());
				organ_effect4_to_individual_effect1.getReferenceIDs()
						.add(new Reference(organ_effect4_to_individual_effect1, dataSource,
								"Li Z, Villeneuve DL, Jensen KM, Ankley GT, Watanabe KH. 2011b. A computational model for asynchronous oocyte growth dynamics in a batch-spawning fish. Can J Fish Aquat Sci 68: 1528-1538. ")
										.<Reference> makeItLive());
				
				individual_effect1_to_population_adverseOutcome.setLinkType(LinkType.DIRECT);
				ReferenceIDW<Link_EffectToEffect> individual_effect1_to_population_adverseOutcome_weigth0 = new ReferenceIDW<Link_EffectToEffect>(individual_effect1_to_population_adverseOutcome, dataSource,
						Link_EffectToEffect.class, 2.0);
				individual_effect1_to_population_adverseOutcome.getDescriptionIDs()
						.set(new DescriptionSection_Structured(individual_effect1_to_population_adverseOutcome, dataSource, "(Key) Event Relationships Weight of Evidences",
								"•  Biological Plausibility: \n\nUsing a relatively simple density-dependent population model and assuming constant young of year survival with no immigration/emigration, reductions in cumulative fecundity have been predicted to yield declines in population size over time (Miller and Ankley 2004). Under real-world environmental conditions, outcomes may vary depending on how well conditions conform with model assumptions. Nonetheless, cumulative fecundity can be considered one vital rate that contributes to overall population trajectories (Kramer et al. 2011). \n\n•  Empirical Support for Linkage:\n\nUsing a relatively simple density-dependent population model and assuming constant young of year survival with no immigration/emigration, reductions in cumulative fecundity have been predicted to yield declines in population size over time (Miller and Ankley 2004). However, it should be noted that the model was constructed in such a way that predicted population size is dependent on cumulative fecundity, therefore this is a fairly weak form of empirical support. \n\nIn a study in which an entire lake was treated with 17alpha-ethynyl estradiol, Kidd et al. (2007) declines in fathead minnow population size were associated with signs of reduced fecundity. \n\n•  Uncertainties or Inconsistencies:\n\nWester et al. (2003) and references cited therein suggest that although egg production is an endpoint of demographic significance, incomplete reductions of egg production may not translate in a simple manner to population reductions. Compensatory effects of reduced predation and reduced competition for limited food and/or habitat resources may offset the effects of incomplete reductions in egg production. \n\nFish and other egg laying animals employ a diverse range of reproductive strategies and life histories. The nature of the relationship between reduced spawning frequency and cumulative fecundity and overall population trajectories will depend heavily on the life history and reproductive strategy of the species in question. Relationships developed for one species will not necessarily hold for other species, particularly those with differing life histories. \n\n",
								individual_effect1_to_population_adverseOutcome_weigth0).setFormat(ContentFormat.TEXT).<DescriptionSection_Structured> makeItLive(), 1);
				individual_effect1_to_population_adverseOutcome.getDescriptionIDs()
						.set(new DescriptionSection(individual_effect1_to_population_adverseOutcome, dataSource, "Evidence Supporting Taxonomic Applicability",
								"Spawning generally refers to the release of eggs and/or sperm into water, generally by aquatic or semi-aquatic organisms. Consequently, by definition, this KER is likely applicable only to organisms that spend a portion of their life-cycle in or near aquatic environments. ")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								2);
				individual_effect1_to_population_adverseOutcome.getDescriptionIDs()
						.set(new DescriptionSection(individual_effect1_to_population_adverseOutcome, dataSource, "Quantitative Understading",
								"Cumulative fecundity is one example of a vital rate that can influence population size over time. A variety of population model constructs can be adapted to utilize measurements or estimates of cumulative fecundity as a predictor of population trends over time (e.g., (Miller and Ankley 2004; Miller et al. 2013). \n\nThe model of Miller et al. 20014 uses a relatively simple density-dependent population model and assuming constant young of year survival with no immigration/emigration, use measures of cumulative fecundity to predict relative change in in population size over time (Miller and Ankley 2004). \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								3);
				individual_effect1_to_population_adverseOutcome.getReferenceIDs()
						.add(new Reference(individual_effect1_to_population_adverseOutcome, dataSource,
								"Miller DH, Ankley GT. 2004. Modeling impacts on populations: fathead minnow (Pimephales promelas) exposure to the endocrine disruptor 17ï�¢ï€­trenbolone as a case study. Ecotoxicology and Environmental Safety 59: 1-9. ")
										.<Reference> makeItLive());
				individual_effect1_to_population_adverseOutcome.getReferenceIDs()
						.add(new Reference(individual_effect1_to_population_adverseOutcome, dataSource,
								"Miller DH, Tietge JE, McMaster ME, Munkittrick KR, Xia X, Ankley GT. 2013. Assessment of Status of White Sucker (Catostomus Commersoni) Populations Exposed to Bleached Kraft Pulp Mill Effluent. Environmental toxicology and chemistry / SETAC (in press). ")
										.<Reference> makeItLive());
				individual_effect1_to_population_adverseOutcome.getReferenceIDs()
						.add(new Reference(individual_effect1_to_population_adverseOutcome, dataSource,
								"Wester P, van den Brandhof E, Vos J, van der Ven L. 2003. Identification of endocrine disruptive effects in the aquatic environment - a partial life cycle assay with zebrafish. (RIVM Report). Bilthoven, the Netherlands: Joint Dutch Environment Ministry. ")
										.<Reference> makeItLive());
				individual_effect1_to_population_adverseOutcome.getReferenceIDs()
						.add(new Reference(individual_effect1_to_population_adverseOutcome, dataSource,
								"Kidd KA, Blanchfield KH, Palace VP, Evans RE, Lazorchak JM, Flick RW. 2007. Collapse of a fish population after exposure to a synthetic estrogen. PNAS 104:8897-8901. ")
										.<Reference> makeItLive());
				individual_effect1_to_population_adverseOutcome.getReferenceIDs()
						.add(new Reference(individual_effect1_to_population_adverseOutcome, dataSource,
								"Kramer VJ, Etterson MA, Hecker M, Murphy CA, Roesijadi G, Spade DJ, Spromberg JA, Wang M, Ankley GT. Adverse outcome pathways and ecological risk assessment: bridging to population-level effects. Environ Toxicol Chem. 2011 Jan;30(1):64-76. doi: 10.1002/etc.375. PubMed PMID: 20963853 ")
										.<Reference> makeItLive());
				
				pathway.updateEssentiality();
				EssetialityDescription essentiality = pathway.getEssentiality();
				DescriptionSection_Structured dss;
				dss = essentiality.getEssentialityDescription(mie1);
				dss.setContent("There is good evidence from stop/reversibility studies that ceasing delivery of the aromatase inhibitor leads to recovery of the subsequent key events. ");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(3.0);
				dss = essentiality.getEssentialityDescription(cellular_effect1);
				dss.setContent(
						"17beta-estradiol synthesis by ovarian granulosa cells, reduction: [Strong] In both exposure studies and stop/reversibility studies, when ex vivo E2 production (as measure of this KE) recovers either through compensation or due to removal of the stressor, subsequent KEs have been shown to recover after a lag period. ");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(3.0);
				dss = essentiality.getEssentialityDescription(organ_effect1);
				dss.setContent(
						"plasma 17beta-estradiol concentrations, reduction: [Strong] In both exposure studies and stop/reversibility studies, when plasma E2 concentrations recover either through compensation or due to removal of the stressor, subsequent KEs have been shown to recover after a lag period. ");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(3.0);
				dss = essentiality.getEssentialityDescription(organ_effect2);
				dss.setContent(
						"vitellogenin production in liver (transcription, translation), reduction: [Moderate] This endpoint was not specifically examined in stop/reversibility studies with aromatase inhibitors, but biological plausibility provides strong support for the essentiality of this event. ");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(2.0);
				dss = essentiality.getEssentialityDescription(organ_effect3);
				dss.setContent("plasma vitellogenin concentrations, reduction: [Strong] Shown to recover in a predictable fashion consistent with the order of events in the AOP in stop/recovery studies. ");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(3.0);
				dss = essentiality.getEssentialityDescription(organ_effect4);
				dss.setContent(
						"vitellogenin accumulation into oocytes and oocyte growth/development, reduction: [Weak] Some contradictory evidence regarding the essentiality of this event. No stop/reversibility studies have explicitly considered this key event. ");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(1.0);
				dss = essentiality.getEssentialityDescription(individual_effect1);
				dss.setContent("cumulative fecundity and spawning, reductions: [Moderate] By definition, some degree of spawning is required to maintain population. ");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(2.0);
				dss = essentiality.getEssentialityDescription(population_adverseOutcome);
				dss.setContent("");
				dss.setFormat(ContentFormat.TEXT);
				((ReferenceIDW<Link_EffectToEffect>) dss.getStructuredContent()).setWeight(0.0);
				
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
								"•  Life Stage Applicability: Adult, reproductively mature\n\n•  Taxonomic Applicability: \n\nmedaka Oryzias latipes - Moderate evidence\n\nzebrafish Danio rerio  - Moderate evidence\n\nfathead minnow Pimephales promelas  - Strong evidence\n\n•  Sex Applicability: Female\n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								4);
				pathway.getDescriptionIDs()
						.set(new DescriptionSection(pathway, dataSource, "Considerations for Potential Applications of the AOP (optional)",
								"The present AOP can provide potential support for the use of alternatives to the fish short term reproduction assay as a screen for aromatase inhibitors. \n\nThe present AOP can serve as a foundation for tiered testing strategies and IATA related to risk assessments on chemicals identified as aromatase inhibitors. \n\nThe present AOP can be used to guide endpoint selection for effects-based monitoring studies at sites where aromatase inhibition has been identified as a relevant biological activity of interest (e.g., through bioeffects prediction or bioeffects surveillance approaches; see Schroeder et al. 2016). \n\nA series of computational models aligned with this AOP (i.e., a quantitative AOP construct) can be applied to estimate in vivo bench-mark doses based on in vitro screening results. Case studies evaluating this application are under way. \n\n")
										.setFormat(ContentFormat.TEXT).<DescriptionSection> makeItLive(),
								5);
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
								"63. Schroeder, A. L., Ankley, G. T., Houck, K. A. and Villeneuve, D. L. (2016), Environmental surveillance and monitoringâ€”The next frontiers for high-throughput toxicology. Environ Toxicol Chem, 35: 513â€“525. doi:10.1002/etc.3309 ")
										.<Reference> makeItLive());
			}
	}

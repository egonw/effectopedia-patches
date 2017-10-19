package org.qsari.effectopedia.data.generated;

import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.core.objects.DescriptionSection.ContentFormat;
import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.Link_ChemStructToMIE;
import org.qsari.effectopedia.core.objects.Method_InSilicoGlobalModel;
import org.qsari.effectopedia.core.objects.SubstanceData;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.core.objects.Test_InSilico;
import org.qsari.effectopedia.core.objects.Test_InVitro;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.DataUnit;
import org.qsari.effectopedia.data.objects.DataValue_Double;
import org.qsari.effectopedia.data.objects.DataValue_String;
import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.objects.ObjectPropertyType;
import org.qsari.effectopedia.defaults.DefaultDataTemplates;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.system.ActionTypes;

public class QAOP_Test extends SourceGeneratedPathway
	{
		
		public QAOP_Test(DataSource dataSource)
			{
				super("Test", "test word", dataSource, "D://Java//org.qsari.effectopedia//test//GeneratedTest");
			}
		
		// revision1
		protected Initiator_ChemicalStructure					chemical1;
		protected Effect_MolecularInitiatingEvent	mie1;
		// revision2
		protected Test_InVitro																				mie1test1;
		protected Test_InSilico																			mie1test4;
		// revision 3
		protected Method_InSilicoGlobalModel						gm1;
		// revision 4
		protected SubstanceData																			subst_data1s;
		protected SubstanceData																			subst_data2s;
		
		@Override
		public void generateContent()
			{
				genreateRevision1();
				storeRevision();
				genreateRevision2();
				storeRevision();
				genreateRevision3();
				storeRevision();
				genreateRevision4();
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
				chemical1.getIdentification().setPropertyValue(5, "C11H17N");
				chemical1.getProperties().setPropertyValue(0, "163.2594");
				
				mie1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie1.setTitle("Test inhibition");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie1);
				
				pathway.updateEssentiality();
			}
		
		public void genreateRevision2()
			{
				mie1test1 = new Test_InVitro(pathway, dataSource);
				mie1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie1test4 = new Test_InSilico(pathway, dataSource);
				mie1test4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1test4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new TestResponseMapping(pathway, dataSource, mie1test1, mie1);
				new TestResponseMapping(pathway, dataSource, mie1test4, mie1);
			}
		
		public void genreateRevision3()
			{
				gm1 = new Method_InSilicoGlobalModel(pathway, dataSource);
				gm1.setTitle("Fathead Minnow Hypothalamic-Pituitary-Gonadal Axis Model");
				
				DescriptionSection sum = new DescriptionSection(
						gm1,
						dataSource,
						"HPG axis model description",
						"<html>\n<body>\n<img src='https://app.effectopedia.org/media/rev/hpg_axis.png' width='403' height='244' alt='HPG-Axis model diagram' />\n<p>Perturbation of the HPG axis by environmental chemicals can alter sex steroid levels, leading to reproductive dysfunction. In female fathead minnows (Pimephalespromelas, abbreviated FHM), inhibition of aromatase (CYP19A), which converts testosterone into 17&beta;-estradiol (E2), impairs oogenesis and reproduction. The key anatomical and regulatory components of the FHM HPG axis have been identified before using expert elicitation, which were coded into a differential equation-based computational model (Breen et al., 2013). In this model, the body of the FHM is represented by six tissue compartments: gill, brain (as a tissue including hypothalamic-pituitary complex), ovary, liver, venous blood, and rest of body. The rest of body compartment accounts for blood flow and tissue volume not directly associated with the HPG axis or reproductive function. The key input from the expert elicitation was identification of a regulatory loop that senses decreased levels of E2 and upregulates aromatase activity in an attempt to compensate for its inhibition. This regulatory loop identified thorough expert elicitation involves (i) sensing changes in the circulating E2 level in the brain compartment; (ii) release from the brain of a signaling molecule (analogous to LH and FSH); (iii) interaction of these signaling molecules with receptors at the ovary-blood interface; (iv) an increased production of ovarian aromatase mRNA as a function of the amount of signal receptor complex; and, finally, (v) translation of the mRNA into new aromatase protein.</p></</body>\n</html>")
						.<DescriptionSection> makeItLive();
				sum.setFormat(ContentFormat.HTML);
				gm1.getDescriptionIDs().set(sum, 0);
				
				DescriptionSection mm = new DescriptionSection(gm1, dataSource, "Methods and Materials", "https://app.effectopedia.org/media/content/Methods_HPG.xhtml").<DescriptionSection> makeItLive();
				mm.setFormat(ContentFormat.HTML);
				gm1.getDescriptionIDs().add(mm);
				
				gm1.getModelCallers().add(mie1test4);
				mie1test4.getGlobalModelIDs().add(gm1);
				
				ObjectProperties modelParameters = gm1.getModelParamaters();
				DescriptorType dt1 = new DescriptorType("Compartment", "Compartment of the body", DataValue_String.class, null).makeItLive();
				DescriptorType dt2 = new DescriptorType("Species", "Species", DataValue_String.class, null).makeItLive();
				DescriptorType dt3 = new DescriptorType("Life_Stage", "Life Stage", DataValue_String.class, null).makeItLive();
				DescriptorType dt4 = new DescriptorType("Age", "Individual age", DataValue_Double.class, new DataUnit("days")).makeItLive();
				ObjectPropertyType opt1 = (new ObjectPropertyType("V.1","Body weigth","Weight", null, Method_InSilicoGlobalModel.class,
						"The parameter describes the weight of the tested animal. Weight depends on the age of the animal, feeding regime and other growth contorolling factors", DataValue_Double.class, new DataUnit(
								"kg"), ActionTypes.GM_PARAMETER)).makeDocumented(null).makeItLive();
				opt1.getDescriptors().add(dt1);
				opt1.getDescriptors().add(dt2);
				opt1.getDescriptors().add(dt3);
				opt1.getDescriptors().add(dt4);
				ObjectPropertyMultivalued_Documented op1 = new ObjectPropertyMultivalued_Documented(gm1, opt1);
				String[][] values = new String[][]
					{
						{ "9.451e-4", "9.451e-4", "9.451e-4", "kg", "whole body", null, "fathead minnow", null, "adult", null, "24", "days", "", "Nichols et al.(2004), Watanabe et al.(2009), Li et al.(2011)" } };
				op1.assign(values);
				modelParameters.add(op1);
				
				ObjectPropertyType opt2 = (new ObjectPropertyType("V.1","Volume","Volume", null, Method_InSilicoGlobalModel.class,
						"The parameter describes the volume of the tested animal. Weight depends on the age of the animal, feeding regime and other growth contorolling factors", DataValue_Double.class, new DataUnit(
								"l"), ActionTypes.GM_PARAMETER)).makeDocumented(null).makeItLive();
				opt2.getDescriptors().add(dt1);
				opt2.getDescriptors().add(dt2);
				opt2.getDescriptors().add(dt3);
				opt2.getDescriptors().add(dt4);
				ObjectPropertyMultivalued_Documented op2 = new ObjectPropertyMultivalued_Documented(gm1, opt2);
				values = new String[][]
					{
						{ "9.470e-4", "9.3e-4", "9.5e-4", "l", "whole body", null, "fathead minnow", null, "adult", null, "24", "days", "", "Nichols et al.(2004), Watanabe et al.(2009), Li et al.(2011)" } };
				op2.assign(values);
				modelParameters.add(op2);
				
				ObjectPropertyType opt3 = (new ObjectPropertyType("V.1","Cardiac output","Cardiac_output", null, Method_InSilicoGlobalModel.class,
						"The parameter describes the volume of blood pumped by the heart per hour. Depends on the excitement of the animal", DataValue_Double.class, new DataUnit("l/h"), ActionTypes.GM_PARAMETER))
						.makeDocumented(null).makeItLive();
				opt3.getDescriptors().add(dt1);
				opt3.getDescriptors().add(dt2);
				opt3.getDescriptors().add(dt3);
				opt3.getDescriptors().add(dt4);
				ObjectPropertyMultivalued_Documented op3 = new ObjectPropertyMultivalued_Documented(gm1, opt3);
				values = new String[][]
					{
						{ "1.110e-2", "0.9e-2", "1.2e-2", "l/h", "whole body", null, "fathead minnow", null, "adult", null, "24", "days", "", "Nichols et al.(2004), Watanabe et al.(2009), Li et al.(2011)" } };
				op3.assign(values);
				modelParameters.add(op3);
			}
		
		public void genreateRevision4()
			{
				
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
				
				subst_data2s = new SubstanceData(mie1test1, chemical1, dataSource);
				summary = DefaultEffectopediaObjects.DEFAULT_D_RESP_AND_REF_DATA.clone(chemical1, dataSource);
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
				
			}
		
	}

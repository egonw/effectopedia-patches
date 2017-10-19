package org.qsari.effectopedia.data.generated;

import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.core.objects.DescriptionSection.ContentFormat;
import org.qsari.effectopedia.core.objects.Effect_AdverseOutcome;
import org.qsari.effectopedia.core.objects.Effect_DownstreamEffect;
import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.Link_ChemStructToMIE;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.core.objects.Test_InVitro;
import org.qsari.effectopedia.core.objects.Test_InVivo;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public class QAOP_SkinSensitization extends SourceGeneratedPathway
	{
		
		public QAOP_SkinSensitization(DataSource dataSource)
			{
				super("Skin Sensitisation Initiated by Covalent Binding to Proteins", "Skin Sensitisation, covalent binding to proteins", dataSource, "D://Java//org.qsari.effectopedia//test//SkinSensitization");
			}
		
		// revision 1
		protected Initiator_ChemicalStructure					chemical1;
		protected Effect_MolecularInitiatingEvent	mie1;
		protected Effect_DownstreamEffect									cellular_effect1;
		protected Effect_DownstreamEffect									cellular_effect2;
		protected Effect_DownstreamEffect									cellular_effect3;
		protected Effect_DownstreamEffect									cellular_effect4;
		protected Effect_DownstreamEffect									organ_effect1;
		protected Effect_DownstreamEffect									organ_effect2;
		protected Effect_DownstreamEffect									organ_effect3;
		protected Effect_DownstreamEffect									organ_system_effect1;
		protected Effect_AdverseOutcome											individual_effect1;
		
		// revision 2
		protected Test_InVitro																				mie1test1;
		protected Test_InVitro																				mie1test2;
		protected Test_InVitro																				cellular_effect1test1;
		protected Test_InVitro																				cellular_effect1test2;
		protected Test_InVitro																				cellular_effect3test1;
		protected Test_InVitro																				cellular_effect3test2;
		protected Test_InVitro																				cellular_effect3test3;
		
		protected Test_InVivo																					organ_effect3test1;
		protected Test_InVivo																					individual_effect1test1;
		protected Test_InVivo																					individual_effect1test2;
		
		@Override
		public void generateContent()
			{
				genreateRevision1();
				storeRevision();
				updateVariables();
				genreateRevision2();
				storeRevision();
			}
		
		public void genreateRevision1()
			{
				
				chemical1 = new Initiator_ChemicalStructure(pathway, dataSource);
				chemical1.setTitle("Dinitrochlorobenzene");
				chemical1.getStructure2DImage().setValue("https://app.effectopedia.org/media/chem/dncb.png");
				chemical1.getIdentification().setPropertyValue(0, "97007");
				chemical1.getIdentification().setPropertyValue(1, "1-Chloro-2,4-dinitrobenzene");
				chemical1.getIdentification().setPropertyValue(2, "c1cc(c(cc1[N+](=O)[O-])[N+](=O)[O-])Cl");
				chemical1.getIdentification().setPropertyValue(3, "InChI=1S/C6H3ClN2O4/c7-5-2-1-4(8(10)11)3-6(5)9(12)13/h1-3H");
				chemical1.getIdentification().setPropertyValue(4, "VYZAHLCBVHPDDF-UHFFFAOYSA-N");
				chemical1.getIdentification().setPropertyValue(5, "C6H3ClN2O4");
				
				chemical1.getProperties().setPropertyValue(0, "202.55");
				
				mie1 = new Effect_MolecularInitiatingEvent(pathway, dataSource);
				mie1.setTitle("Covalent modification of cellular protein");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				DescriptionSection aopKB = new DescriptionSection(
						mie1,
						dataSource,
						"AOP-Wiki description",
						"https://aopkb.org/aopwiki/index.php/Event:396")
						.<DescriptionSection> makeItLive();
				aopKB.setFormat(ContentFormat.HTML);
				mie1.getDescriptionIDs().set(aopKB, 0);
				
				new Link_ChemStructToMIE(pathway, dataSource, chemical1, mie1);
				
				cellular_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect1.setTitle("Kerantinocytes Activation");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_EffectToEffect(pathway, dataSource, mie1, cellular_effect1);
				
				cellular_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect2.setTitle("Dendritic cell activation");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_EffectToEffect(pathway, dataSource, mie1, cellular_effect2);
				new Link_EffectToEffect(pathway, dataSource, cellular_effect1, cellular_effect2);
				
				cellular_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect3.setTitle("Dendritic cell maturation");
				cellular_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				cellular_effect4 = new Effect_DownstreamEffect(pathway, dataSource);
				cellular_effect4.setTitle("Dendritic cell migraion");
				cellular_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect4.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect2, cellular_effect3);
				new Link_EffectToEffect(pathway, dataSource, cellular_effect2, cellular_effect4);
				
				organ_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect1.setTitle("Dendritic cell antigen presentation");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_EffectToEffect(pathway, dataSource, cellular_effect3, organ_effect1);
				new Link_EffectToEffect(pathway, dataSource, cellular_effect4, organ_effect1);
				
				organ_effect2 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect2.setTitle("T cell activation");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_EffectToEffect(pathway, dataSource, organ_effect1, organ_effect2);
				
				organ_effect3 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_effect3.setTitle("T cell proliferation");
				organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_EffectToEffect(pathway, dataSource, organ_effect2, organ_effect3);
				
				organ_system_effect1 = new Effect_DownstreamEffect(pathway, dataSource);
				organ_system_effect1.setTitle("T cell differentiation");
				organ_system_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ system");
				organ_system_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

				new Link_EffectToEffect(pathway, dataSource, organ_effect3, organ_system_effect1);
				
				individual_effect1 = new Effect_AdverseOutcome(pathway, dataSource);
				individual_effect1.setTitle("Alergic Contact Dermatitis");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new Link_EffectToEffect(pathway, dataSource, organ_system_effect1, individual_effect1);
			}
		
		public void genreateRevision2()
			{
				mie1test1 = new Test_InVitro(pathway, dataSource);
				mie1test1.setTitle("CorlC-420 (AcNKKCDLF)");
				mie1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				mie1test2 = new Test_InVitro(pathway, dataSource);
				mie1test2.setTitle("Cys-Peptide (AcRFAACAA)");
				mie1test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "molecular");
				mie1test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new TestResponseMapping(pathway, dataSource, mie1test1, mie1);
				new TestResponseMapping(pathway, dataSource, mie1test2, mie1);
				
				cellular_effect1test1 = new Test_InVitro(pathway, dataSource);
				cellular_effect1test1.setTitle("KeratinoSens");
				cellular_effect1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				cellular_effect1test2 = new Test_InVitro(pathway, dataSource);
				cellular_effect1test2.setTitle("NCTC 2544");
				cellular_effect1test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect1test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new TestResponseMapping(pathway, dataSource, cellular_effect1test1, cellular_effect1);
				new TestResponseMapping(pathway, dataSource, cellular_effect1test2, cellular_effect1);

				cellular_effect3test1 = new Test_InVitro(pathway, dataSource);
				cellular_effect3test1.setTitle("H-Clat");
				cellular_effect3test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect3test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				cellular_effect3test2 = new Test_InVitro(pathway, dataSource);
				cellular_effect3test2.setTitle("VITROSENS");
				cellular_effect3test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect3test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

				cellular_effect3test3 = new Test_InVitro(pathway, dataSource);
				cellular_effect3test3.setTitle("MUSST");
				cellular_effect3test3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "cellular");
				cellular_effect3test3.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");

				new TestResponseMapping(pathway, dataSource, cellular_effect3test1, cellular_effect3);
				new TestResponseMapping(pathway, dataSource, cellular_effect3test2, cellular_effect3);
				new TestResponseMapping(pathway, dataSource, cellular_effect3test3, cellular_effect3);

				organ_effect3test1 = new Test_InVivo(pathway, dataSource);
				organ_effect3test1.setTitle("Mouse LLNA");
				organ_effect3test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "organ");
				organ_effect3test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				
				new TestResponseMapping(pathway, dataSource, organ_effect3test1, organ_effect3);
				
				individual_effect1test1 = new Test_InVivo(pathway, dataSource);
				individual_effect1test1.setTitle("Guinea Pig Maximimisation Test (GPMT)");
				individual_effect1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect1test1.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				individual_effect1test2 = new Test_InVivo(pathway, dataSource);
				individual_effect1test2.setTitle("Buehler Guinea Pig Test");
				individual_effect1test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_LBO.DIMENSION_INDEX, "individual");
				individual_effect1test2.getCoordinates().setValue(DefaultEffectopediaObjects.DEFAULT_SEX.DIMENSION_INDEX, "mixed");
				
				new TestResponseMapping(pathway, dataSource, individual_effect1test1, individual_effect1);
				new TestResponseMapping(pathway, dataSource, individual_effect1test2, individual_effect1);
			}
		
		
	}

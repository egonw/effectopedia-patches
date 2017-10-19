package org.qsari.effectopedia.core.ui.nav;

import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Initiator_BiologcalPerturbation;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.Initiator_StructuralAlerts;
import org.qsari.effectopedia.core.objects.Link_ChemStructToChemStruct;
import org.qsari.effectopedia.core.objects.Link_ChemStructToMIE;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.core.objects.Method_InSilicoGlobalModel;
import org.qsari.effectopedia.core.objects.Method_Investigation;
import org.qsari.effectopedia.core.objects.Method_Study;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.core.objects.Test_InLab;
import org.qsari.effectopedia.core.objects.Test_InSilico;

public class UILocations
	{
		private static final UILocations	INSTANCE	= new UILocations();
		
		private UILocations()
			{
				
			}
		
		public UILocations getGOUtils()
			{
				return INSTANCE;
			}
		
		public static UILocation getProperEditor(Object o)
			{
				if (o instanceof Initiator_ChemicalStructure)
					return editChemicalUIL;
				if (o instanceof Initiator_StructuralAlerts)
					return editStructuralAlertUIL;
				if (o instanceof Initiator_BiologcalPerturbation)
					return editBiologicalPertyrbationUIL;
				if (o instanceof Link_ChemStructToChemStruct)
					return editADMELinkUIL;
				if (o instanceof Link_EffectToEffect)
					return editLinkUIL;
				if (o instanceof Link_ChemStructToMIE)
					return editChemLinkUIL;
				if (o instanceof Test_InLab)
					return editInLabTestUIL;
				if (o instanceof Test_InSilico)
					return editInSilicoTestUIL;
				if (o instanceof Effect)
					return editEffectUIL;
				if (o instanceof Pathway)
					return editPathwayUIL;
				if (o instanceof Method_Investigation)
					return editInvestigationUIL;
				if (o instanceof Method_Study)
					return editStudyUIL;
				if (o instanceof Method_InSilicoGlobalModel)
					return editGlobalModelUIL;
				if (o instanceof TestResponseMapping)
					return editTestResponseMappingUIL;
				else
					return null;
			}
		
		public static final String					interfaceURL																		= "http://www.effectopedia.org/intreface.php";
		public static final String					defaultPackage																= "org.qsari.effectopedia.gui.";
		
		public static final UILocation	editStructuralAlertUIL								= new UILocation("editStructuralAlertUIL", "EffectopediaUI.MainUI.EditUI.EditStructuralAlertsUI", defaultPackage);
		public static final UILocation	editBiologicalPertyrbationUIL	= new UILocation("editBiologicalPerturbationUIL", "EffectopediaUI.MainUI.EditUI.EditBiologicalPerturbationUI", defaultPackage);
		public static final UILocation	editChemicalUIL															= new UILocation("editChemicalUIL", "EffectopediaUI.MainUI.EditUI.EditChemicalsUI.ChemicalUI", defaultPackage);
		public static final UILocation	editLinkUIL																			= new UILocation("editLinkUIL", "EffectopediaUI.MainUI.EditUI.EditLinkUI", defaultPackage);
		public static final UILocation	editChemLinkUIL															= new UILocation("editChemLinkUIL", "EffectopediaUI.MainUI.EditUI.EditChemicalLinkUI", defaultPackage);
		public static final UILocation	editADMELinkUIL															= new UILocation("editADMELinkUIL", "EffectopediaUI.MainUI.EditUI.EditADMELinkUI", defaultPackage);
		public static final UILocation	editSystemUIL																	= new UILocation("editSystemUIL", "EffectopediaUI.MainUI.EditUI.EditEditSystemUI", defaultPackage);
		public static final UILocation	editInLabTestUIL														= new UILocation("editInLabTestUIL", "EffectopediaUI.MainUI.EditUI.EditInLabTestUI", defaultPackage);
		public static final UILocation	editInSilicoTestUIL											= new UILocation("editInSilicoTestUIL", "EffectopediaUI.MainUI.EditUI.EditInSilicoTestUI", defaultPackage);
		public static final UILocation	editEffectUIL																	= new UILocation("editEffectUIL", "EffectopediaUI.MainUI.EditUI.EditEffectUI", defaultPackage);
		public static final UILocation	editPathwayUIL																= new UILocation("editPathwayUIL", "EffectopediaUI.MainUI.EditUI.EditPathwayUI", defaultPackage);
		public static final UILocation	editInvestigationUIL										= new UILocation("editInvestigationUIL", "EffectopediaUI.MainUI.EditUI.InvestigationUI", defaultPackage);
		public static final UILocation	editStudyUIL																		= new UILocation("editStudyUIL", "EffectopediaUI.MainUI.EditUI.StudyUI", defaultPackage);
		public static final UILocation	editGlobalModelUIL												= new UILocation("editGlobalModelUIL", "EffectopediaUI.MainUI.EditUI.GlobalModelUI", defaultPackage);
		public static final UILocation	editTestResponseMappingUIL				= new UILocation("editTestResponseMappingUIL", "EffectopediaUI.MainUI.EditUI.EditTestResponceMappingUI", defaultPackage);
		
		public static final UILocation	editChangesUIL																= new UILocation("editChangesUIL", "EffectopediaUI.MainUI.DataSourcesMergeUI", defaultPackage);
		
		public static final UILocation	viewUIL																							= new UILocation("viewUIL", "EffectopediaUI.MainUI.ViewUI", defaultPackage);
		public static final UILocation	editUIL																							= new UILocation("editUIL", "EffectopediaUI.MainUI.EditUI", defaultPackage);
		public static final UILocation	searchUIL																					= new UILocation("searchUIL", "EffectopediaUI.MainUI.SearchUI", defaultPackage);
		public static final UILocation	historyUIL																				= new UILocation("historyUIL", "EffectopediaUI.MainUI.RevisionHistoryUI", defaultPackage);
		public static final UILocation	discussUIL																				= new UILocation("discussUIL", "EffectopediaUI.MainUI.DiscussUI", defaultPackage);
		public static final UILocation	webUIL																								= new UILocation("webUIL", "EffectopediaUI.MainUI.WebPageUI", defaultPackage);
		public static final UILocation	welcomeUIL																				= new UILocation("welcomeUIL", "EffectopediaUI.MainUI.WelcomeUI", defaultPackage);
		
	}

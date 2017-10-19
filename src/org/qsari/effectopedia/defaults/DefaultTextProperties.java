package org.qsari.effectopedia.defaults;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;

public class DefaultTextProperties extends HashMap<String, DefaultTextProperty> implements Importable, Exportable
	{
		/**
	 * 
	 */
		private static final long																	serialVersionUID	= 1L;
		public static final DefaultTextProperties	INSTANCE									= new DefaultTextProperties();
		
		private DefaultTextProperties()
			{
				/* default text properties used in org.qsari.effectopedia.embedded package */
				newDefaultTextProperty("DataUnit.caption", " ");
				newDefaultTextProperty("DataValue.value", "value");
				
				/* default text properties used in org.qsari.effectopedia.core.objects package */
				newDefaultTextProperty("ContextDimension.name", "Context dimension");
				newDefaultTextProperty("DescriptionSection.title", "Section Title");
				newDefaultTextProperty("DescriptionSection.content", "Section Content");
				newDefaultTextProperty("DiscussionPosting.title", "Discussion Posting");
				newDefaultTextProperty("DiscussionPosting.content", " ");
				newDefaultTextProperty("DiscussionTopic.subject", "Subject");
				newDefaultTextProperty("DocumentedKnowledge.title", "Title");
				newDefaultTextProperty("Effect.title", "Effect Title");
				newDefaultTextProperty("Effect_DownstreamEffect.title", "(Key) Event Title");
				newDefaultTextProperty("Effect_MolecularInitiatingEvent.title", "Molecular Initiating Event Title");
				newDefaultTextProperty("Effect_Endpoint.title", "Assessment Endpoint Title");
				newDefaultTextProperty("Effect_AdverseOutcome.title", "Adverse Outcome Title");
				newDefaultTextProperty("Link.title", "Link Title");
				newDefaultTextProperty("Link_EffectToEffect.title", "(Key) Relationship Title");
				newDefaultTextProperty("Link_SubstanceToMIE.title", "Molecular Interaction");
				newDefaultTextProperty("Link_SubstanceToReactiveSubstance.title", "Biological Activation");
				newDefaultTextProperty("Initiator_ChemicalStructure.title", "Chemical Strucutre");
				newDefaultTextProperty("Initiator_ChemicalStructure.CASNO", "xxxxxx");
				newDefaultTextProperty("Initiator_ChemicalStructure.IUPAC_NAME", "n/a");
				newDefaultTextProperty("Initiator_ChemicalStructure.SMILES", "");
				newDefaultTextProperty("Initiator_ChemicalStructure.Formula", "");
				newDefaultTextProperty("Substance.title", "Chemical Substance");
				newDefaultTextProperty("Initiator_StructuralAlerts.title", "Structural Alert");
				newDefaultTextProperty("Initiator_BiologcalPerturbation.title", "Biological Perturbation");
				newDefaultTextProperty("Test.title", "Test Method of Observation Title");
				newDefaultTextProperty("Test_InSilico.title", "In-silico Test Method Title");
				newDefaultTextProperty("Test_InChemico.title", "In-chemico Test Method Title");
				newDefaultTextProperty("Test_InVitro.title", "In-vitro Test Method Title");
				newDefaultTextProperty("Test_InVivo.title", "In-vivo Test Method Title");
				newDefaultTextProperty("Test_ExVivo.title", "Ex-vivo Test Method Title");
				newDefaultTextProperty("Pathway.title", "Sample Pathway Title");
				newDefaultTextProperty("Reference.formatedReference", "Type your APA formatted reference");
				newDefaultTextProperty("Method.title", "Method Title");
				newDefaultTextProperty("Method_Investigation.title", "Investigation Title");
				newDefaultTextProperty("Method_Study.title", "Study Title");
				newDefaultTextProperty("Method_InSilicoGlobalModel.title", "Global In-silico Model Title");
				newDefaultTextProperty("TransformationSet.title", "Transformation Functions Set Title");
				newDefaultTextProperty("Lab.name", "Liboratory name");
				
				/* default text properties used in org.qsari.effectopedia.defaults package */
				newDefaultTextProperty("DEFAULT_TAXONOMY_NAME", "Taxonomical Aplicability");
				newDefaultTextProperty("DEFAULT_LBO_NAME", "Level of Biological Organization");
				newDefaultTextProperty("DEFAULT_LIFE_STAGE_NAME", "Life Stage");
				newDefaultTextProperty("DEFAULT_SEX_NAME", "Sex");
				newDefaultTextProperty("DEFAULT_BIO_COMPARTMENT_NAME", "Biological Compartment");
				newDefaultTextProperty("DEFAULT_GENERATION_NAME", "Generation");
				newDefaultTextProperty("DEFAULT_OTHER_NAME", "Other");
				newDefaultTextProperty("DEFAULT_TIME_TO_EFFECT_NAME", "Time to Manifestation");
				newDefaultTextProperty("DEFAULT_EFFECT_TERM_NAME", "Time to Manifestation (range)");
				newDefaultTextProperty("DEFAULT_PATHWAY_DS_TITLE", "Abstract");
				newDefaultTextProperty("DEFAULT_PATHWAY_DS_CONTENT", "Provide a concise and informative summation of the AOP under development that can stand-alone from the AOP page. Abstracts should typically be 200-400 words in length (similar to an abstract for a journal article). Suggested content for the abstract includes the following: (1) the background/purpose for initiation of the AOP's development (if there was a specific intent); (2) a brief description of the MIE, AO, and/or major KEs that define the pathway; (3) a short summation of the overall weight of evidence supporting the AOP and identification of major knowledge gaps (if any); (4) a brief statement about how the AOP may be applied. The aim is to capture the highlights of the AOP and its potential scientific and regulatory relevance.");
				newDefaultTextProperty("DEFAULT_LINK_STMIE_DS_TITLE", "Definition");
				newDefaultTextProperty("DEFAULT_LINK_STMIE_DS_CONTENT", "Molecular Interaction description");
				newDefaultTextProperty("DEFAULT_LINK_STRS_DS_TITLE", "Definition");
				newDefaultTextProperty("DEFAULT_LINK_STRS_DS_CONTENT", "Bioactivation description");
				newDefaultTextProperty("DEFAULT_BIOPERT_DS_TITLE", "Abstract");
				newDefaultTextProperty("DEFAULT_BIOPERT_DS_CONTENT", "Description of the molecular level changes caused by the refered effect");
				newDefaultTextProperty("DEFAULT_LINK_ETE_DS_TITLE", "Definition");
				newDefaultTextProperty("DEFAULT_LINK_ETE_DS_CONTENT", "(Key) event relationship description");
				newDefaultTextProperty("DEFAULT_MIE_DS_TITLE", "Definition");
				newDefaultTextProperty("DEFAULT_MIE_DS_CONTENT", "Provide brief description of the molecular initiating event");
				newDefaultTextProperty("DEFAULT_DE_DS_TITLE", "Definition");
				newDefaultTextProperty("DEFAULT_DE_DS_CONTENT", "Provide brief description of the (key) event");
				newDefaultTextProperty("DEFAULT_IN_SILICO_TEST_DS_TITLE", "Abstract");
				newDefaultTextProperty("DEFAULT_IN_SILICO_TEST_DS_CONTENT", "In-silico model description");
				newDefaultTextProperty("DEFAULT_GLOBAL_MODEL_DS_TITLE", "Abstract");
				newDefaultTextProperty("DEFAULT_GLOBAL_MODEL_DS_CONTENT", "In-silico model description");
				newDefaultTextProperty("DEFAULT_IN_CHEMICO_TEST_DS_TITLE", "Assay Description");
				String assaySummary = "\n\u2022 Description of the principles of measurement\n\u2022 Identification, amplification detection.\n\u2022 Dynamic range of detection\n\u2022 Number of runs/ controls\n...";
				newDefaultTextProperty("DEFAULT_IN_CHEMICO_TEST_DS_CONTENT", "In-chemico test method description"+assaySummary);
				newDefaultTextProperty("DEFAULT_IN_VITRO_TEST_DS_TITLE", "Assay Description");
				newDefaultTextProperty("DEFAULT_IN_VITRO_TEST_DS_CONTENT", "In-vitro test method description"+assaySummary);
				newDefaultTextProperty("DEFAULT_IN_VIVO_TEST_DS_TITLE", "Assay Description");
				newDefaultTextProperty("DEFAULT_IN_VIVO_TEST_DS_CONTENT", "In-vivo test method description"+assaySummary);
				newDefaultTextProperty("DEFAULT_EX_VIVO_TEST_DS_TITLE", "Assay Description");
				newDefaultTextProperty("DEFAULT_EX_VIVO_TEST_DS_CONTENT", "Ex-vivo test method description"+assaySummary);

				newDefaultTextProperty("DEFAULT_IN_LAB_TEST_DOMAIN_DS_TITLE", "Applicability Domain");
				newDefaultTextProperty("DEFAULT_IN_LAB_TEST_DOMAIN_DS_CONTENT", "\u2022 Chemical domain\n\u2022 Time domain\n\u2022 Taxonomy domain\n\u2022 Other (life stage, generation, gender...)");
				newDefaultTextProperty("DEFAULT_IN_LAB_TEST_QUALITY_DS_TITLE", "Quality Measures");
				newDefaultTextProperty("DEFAULT_IN_LAB_TEST_QUALITY_DS_CONTENT", "\u2022 Analytical / functional sensitivity /specificity\n\u2022 Reproducibility of the assay across labs\n\u2022 In lab repeatability\n\u2022 Quality assurance measures: Validation Assays, Calibration, Analytical quality control");
				newDefaultTextProperty("DEFAULT_IN_LAB_TEST_COST_DS_TITLE", "Cost");
				newDefaultTextProperty("DEFAULT_IN_LAB_TEST_COST_DS_CONTENT", "\u2022 Approximate fixed and variable cost ranges (for a given location, year)\n\u2022 Thruput - number of assays done per unit of time\n\u2022 Number and species of animals used\n");
				
				newDefaultTextProperty("DEFAULT_TRM_DS_TITLE", "Abstract");
				newDefaultTextProperty("DEFAULT_TRM_CONTENT", "Description of the mapping of the test responce to the biolocal effect");
				newDefaultTextProperty("DEFAULT_TEST_DS_METHODS_TITLE", "Methods");
				newDefaultTextProperty("DEFAULT_TEST_DS_METHODS_CONTENT", "Systematic test methods");
				newDefaultTextProperty("DEFAULT_TEST_DS_GUIDELINES_TITLE", "Guidelines");
				newDefaultTextProperty("DEFAULT_TEST_DS_GUIDELINES_CONTENT", "Detailed description of guidelines");
				
				newDefaultTextProperty("DEFAULT_METHOD_DS_TITLE", "Methods");
				newDefaultTextProperty("DEFAULT_METHOD_DS_CONTENT", "General method description");

				newDefaultTextProperty("DEFAULT_INVESTIGATION_METHOD_DS_TITLE", "Investigation");
				newDefaultTextProperty("DEFAULT_INVESTIGATION_METHOD_DS_CONTENT", "Investigation is a high level concept, providing the shared description for a specific set of studeis");

				newDefaultTextProperty("DEFAULT_STUDY_METHOD_DS_TITLE", "Study");
				newDefaultTextProperty("DEFAULT_STUDY_METHOD_DS_CONTENT", "Study description containig information for the subject its characteristics, and treatments applied...");


				
				newDefaultTextProperty("DEFAULT_PATHWAY_BACKGROUND_DS_TITLE", "Background (optional)");
				newDefaultTextProperty("DEFAULT_PATHWAY_BACKGROUND_DS_CONTENT", "This optional section should be used to provide background information for AOP reviewers and users that is considered helpful in understanding the normal behavour of the biological sysytems adversly affected by this AOP. The background should NOT provide an overview of the AOP, its KEs or KERs, which are captured in more detail below.");   
				newDefaultTextProperty("DEFAULT_PATHWAY_QUANT_CONSID_DS_TITLE", "Quantitative Considerations");
				newDefaultTextProperty("DEFAULT_PATHWAY_QUANT_CONSID_DS_CONTENT", "Provide a summary of the quantitative information available for this AOP.");   
				newDefaultTextProperty("DEFAULT_PATHWAY_APP_DOMAIN_DS_TITLE", "Applicability of the AOP");
				newDefaultTextProperty("DEFAULT_PATHWAY_APP_DOMAIN_DS_CONTENT", "\u2022 Life Stage Applicability: \n\u2022 Taxonomic Applicability: \n\u2022 Sex Applicability:\n");   
				newDefaultTextProperty("DEFAULT_PATHWAY_APPLICATION_DS_TITLE", "Considerations for Potential Applications of the AOP (optional)");
				newDefaultTextProperty("DEFAULT_PATHWAY_APPLICATION_DS_CONTENT", "Provide a list of potential applications");
				newDefaultTextProperty("DEFAULT_LINK_QUANT_UNDERST_DS_TITLE", "Quantitative Understading");
				newDefaultTextProperty("DEFAULT_LINK_QUANT_UNDERST_DS_CONTENT", "Provide a summary of the quantitative understading available for this linkage.");   

				newDefaultTextProperty("DEFAULT_EFFECT_TEST_SUMMARY_DS_TITLE", "Measurment/detection");
				newDefaultTextProperty("DEFAULT_EFFECT_TEST_SUMMARY_DS_CONTENT", "Provide a summary of the available measurment and detection methods.");   

				newDefaultTextProperty("DEFAULT_EFFECT_ESSENTIALITY_DSS_TITLE", "Support of Essentiality of (Key) Events");
				newDefaultTextProperty("DEFAULT_LINK_ESSENTIALITY_DSS_TITLE", "Event Relationships Weight of Evidences");
				newDefaultTextProperty("DEFAULT_EFFECT_ESSENTIALITY_DS_TITLE", "(Key) Event Essentiality");
				newDefaultTextProperty("DEFAULT_LINK_ESSENTIALITY_DS_TITLE", "(Key) Event Relationship Weight of Evidence");
				newDefaultTextProperty("DEFAULT_LINK_ESSENTIALITY_DS_CONTENT", "\u2022 Biological Plausibility: \n\u2022 Empirical Support for Linkage:\n\u2022 Uncertainties or Inconsistencies:\n");

				newDefaultTextProperty("DEFAULT_LINK_TAXONOMIC_APPLIC_DS_TITLE", "Evidence Supporting Taxonomic Applicability");
				newDefaultTextProperty("DEFAULT_LINK_TAXONOMIC_APPLIC_DS_CONTENT", "Sumarise the available evidences.");
				
				newDefaultTextProperty("DEFAULT_TRANSF_SET_BIO_CONTEXT_DS_TITLE", "Biological context comparative analysis");
				newDefaultTextProperty("DEFAULT_TRANSF_SET_BIO_CONTEXT_DS_CONTENT", "Compare bilogical context of the test method with in-vivo settings.\nDescribe weather the set of transformation functions accounts for:\n \u2022 Absorption\n \u2022 Distribution\n \u2022 Metabolism\n \u2022 Excretion");
				newDefaultTextProperty("DEFAULT_TRANSF_SET_APPL_DOMAIN_DS_TITLE", "Applicability domain");
				newDefaultTextProperty("DEFAULT_TRANSF_SET_APPL_DOMAIN_DS_CONTENT", "Summarise the applicability ranges of the individual transformation functions.");
			}
		
		public void newDefaultTextProperty(String name, String text)
			{
				DefaultTextProperty d = new DefaultTextProperty(name, text);
				put(name, d);
			}

		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						BaseIOElement e = element.getChild("DefaultTextProperties");
						if (e != null)
							{
								int count = Integer.parseInt(e.getAttributeValue("count"));
								List<BaseIOElement> children = e.getChildren();
								if ((count != 0) && (children != null) && (children.size() == count))
									{
										clear();
										Iterator<BaseIOElement> iterator = children.iterator();
										while (iterator.hasNext())
											{
												BaseIOElement child = iterator.next();
												DefaultTextProperty d = new DefaultTextProperty();
												d.load(child,io);
												put(d.name, d);
											}
									}
							}
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				int count = size();
				BaseIOElement e = io.newElement("DefaultTextProperties");
				e.setAttribute("count", Integer.toString(count));
				if (count != 0)
					{
						Iterator<Map.Entry<String, DefaultTextProperty>> it = entrySet().iterator();
						while (it.hasNext())
							{
								BaseIOElement s = io.newElement("DefaultTextProperty");
								it.next().getValue().store(s, io);
								element.addChild(s);
							}
					}
				element.addChild(e);
				return element;
			}
		
		public String getDefault(String name)
			{
				DefaultTextProperty d = get(name);
				if (d != null)
					return d.text;
				else
					return " ";
			}
		
	}

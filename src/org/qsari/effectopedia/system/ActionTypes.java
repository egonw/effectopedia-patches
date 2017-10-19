package org.qsari.effectopedia.system;

import java.util.ArrayList;

public class ActionTypes extends ArrayList<ActionType>
	{
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;
		
		private ActionTypes()
			{
				
			}
			
		private static int newActionType(String fieldName, String description)
			{
				int actionID = (int) ActionType.actionTypeIDs++;
				REGISTERED.add(new ActionType(actionID, fieldName, description));
				return actionID;
			}
			
		public static String getTabDelimitedActionDescriptions()
			{
				StringBuilder sb = new StringBuilder();
				for (ActionType at : REGISTERED)
					{
						sb.append(at.getID());
						sb.append("\t");
						sb.append(at.getDescription());
						sb.append("\t");
						sb.append(at.getFieldName());
						sb.append("\n");
					}
				return sb.toString();
			}
			
		public static String getActionTypesAsInsertSQL()
			{
				StringBuilder sb = new StringBuilder();
				sb.append("INSERT INTO `action_types` ( `type_id` , `description` , `group_id` ) VALUES");
				int i = 1;
				for (ActionType at : REGISTERED)
					{
						sb.append("('");
						sb.append(at.getID() + 1);
						sb.append("', '");
						sb.append(at.getFieldName());
						sb.append("', '");
						sb.append((i <= 6) ? i : (i == 48) ? 7 : 6);
						i++;
						sb.append("'), ");
					}
				sb.replace(sb.length() - 2, sb.length(), ";");
				return sb.toString();
			}
			
		public static ActionTypes	REGISTERED															= new ActionTypes();
		
		public static final int			CREATE_OBJECT												= newActionType("object created", "create");
		public static final int			LIST_ADD																	= newActionType("object added to a list", "add");
		public static final int			LIST_REMOVE														= newActionType("object removed to a list", "remove");
		public static final int			LIST_CLEAR															= newActionType("all objects removed", "clear");
		public static final int			REFERENCE_SET												= newActionType("set reference", "set");
		public static final int			EO_UPDATED_COMPONENT_AID	= newActionType("updated sub-component", "update");
		
		public static final int			CD_LBO_VALUE													= newActionType("change level of biological organization axis value", "level of biological organization axis value");
		public static final int			CD_LBO_UNIT														= newActionType("change level of biological organization axis unit", "level of biological organization axis unit");
		public static final int			CD_LIFE_STAGE_VALUE						= newActionType("change life stage axis value", "life stage axis value");
		public static final int			CD_LIFE_STAGE_UNIT							= newActionType("change life stage axis unit", "life stage axis unit");
		public static final int			CD_LOCATION_VALUE								= newActionType("change location axis value", "location axis value");
		public static final int			CD_LOCATION_UNIT									= newActionType("change location axis unit", "location axis unit");
		public static final int			CD_TAXONOMY_VALUE								= newActionType("change taxonomy axis value", "taxonomy axis value");
		public static final int			CD_TAXONOMY_UNIT									= newActionType("change taxonomy axis unit", "taxonomy axis unit");
		public static final int			CD_SEX_VALUE													= newActionType("change sex axis value", "sex axis value");
		public static final int			CD_SEX_UNIT														= newActionType("change sex axis unit", "sex axis unit");
		public static final int			CD_TIME_TO_EFFECT_VALUE		= newActionType("change time to effect axis value", "time to effect axis value");
		public static final int			CD_TIME_TO_EFFECT_UNIT			= newActionType("change time to effect axis unit", "time to effect axis unit");
		public static final int			CD_EFFECT_TERM_VALUE					= newActionType("change time to effect in terms axis value", "time to effect in terms axis value");
		public static final int			CD_EFFECT_TERM_UNIT						= newActionType("change time to effect in terms axis unit", "time to effect in terms axis unit");
		public static final int			CD_OTHER_VALUE											= newActionType("change the custom axis value", "the custom axis value");
		public static final int			CD_OTHER_UNIT												= newActionType("change the custom axis unit", "the custom axis unit");
		
		public static final int			CI_CASNO																	= newActionType("structure CASNo", "chemical abstract service registry number");
		public static final int			CI_IUPAC_NAME												= newActionType("structure IUPAC name", "IUPAC name");
		public static final int			CI_SMILES																= newActionType("structure smiles", "smiles");
		public static final int			CI_INCHI																	= newActionType("structure InChI code", "inchi");
		public static final int			CI_INCHI_KEY													= newActionType("structure InChI key", "inchi_key");
		public static final int			CI_MOL_FORMULA											= newActionType("structure mol. formula", "mol. formula");
		public static final int			CP_MOL_WEIGHT												= newActionType("structure mol. weigth", "mol. weight");
		public static final int			CP_DENSITY															= newActionType("structure density", "density");
		public static final int			CP_MELTING_POINT									= newActionType("structure melting point", "melting point");
		public static final int			CP_BOILING_POINT									= newActionType("structure boling point", "boling point");
		public static final int			CP_CLOGP																	= newActionType("structure CLog(P)", "CLog(P)");
		public static final int			CP_WATER_SOL													= newActionType("structure water solubility", "water solubility");
		public static final int			CP_2D_IMAGE														= newActionType("structure 2D image", "2D image");
		public static final int			CP_SYNONYMS														= newActionType("structure name synonyms", "synonyms");
		
		public static final int			DS_TITLE_AID													= newActionType("description section title", "description section title");
		public static final int			DS_CONTENT_AID											= newActionType("description section content", "description section content");
		public static final int			PE_TITLE_AID													= newActionType("pathway element title", "pathway element title");
		public static final int			S_TITLE_AID														= newActionType("structure title", "structure title");
		public static final int			DN_TITLE_AID													= newActionType("documented knowledge title", "documented knowledge title");
		public static final int			DN_KEYWORDS_AID										= newActionType("documented knowledge title", "documented knowledge keywords");
		public static final int			L_QUANTITATIVE_REL							= newActionType("quantitative relationship", "quantitative relationship");
		public static final int			REFERENCE_FORMATED_AID			= newActionType("formatted reference", "formatted reference");
		public static final int			P_TITLE_AID														= newActionType("pathway title", "pathway title");
		public static final int			P_KEYWORDS_AID											= newActionType("pathway title", "pathway keywords");
		public static final int			P_UIDS_AID															= newActionType("pathway identifiers", "pathway identifiers");
		public static final int			P_STATUS_AID													= newActionType("pathway status", "pathway status");
		
		public static final int			DP_TITLE_AID													= newActionType("discussion posting title", "discussion posting title");
		public static final int			DP_CONTENT_AID											= newActionType("discussion posting content", "discussion posting content");
		public static final int			DT_SUBJECT_AID											= newActionType("discussion topic subject", "discussion topic subject");
		public static final int			DSM_REPLACE_OJECT_AID				= newActionType("replace object version with a one from another datasource", "replace");
		
		public static final int			E_GROUP_AID														= newActionType("effect group", "effect groups");
		
		public static final int			CD_GENERATION_VALUE						= newActionType("change generation axis value", "generation axis value");
		public static final int			CD_GENERATION_UNIT							= newActionType("change generation axis unit", "generation axis unit");
		
		public static final int			SUBSTANCE_DATA											= newActionType("assign subsance data", "subsance data");
		public static final int			SP_DOSE_RESP													= newActionType("subsance dose response", "dose responce");
		public static final int			GM_PARAMETER													= newActionType("model parameter", "model parameter");
		public static final int			GM_SYS_REQ															= newActionType("system requirements", "system requirements");
		public static final int			GM_LICENSE															= newActionType("License", "sourcode license");
		public static final int			GM_VERSION															= newActionType("Version", "global model version");
		public static final int			GM_CITATION														= newActionType("Citation", "preffered citation");
		
		public static final int			UUID																					= newActionType("Universally unique identifier", "universally unique identifier");
		public static final int			SUBST_TYPE															= newActionType("subsance type", "subsance type");
		public static final int			SUBST_TITLE_AID										= newActionType("substance title", "substance title");
		public static final int			S_IUC_NAME															= newActionType("IUC Public Name", "IUC Name");
		public static final int			IDs_MAP_PUT														= newActionType("Add or modify object mapping ", "object mapping");
		public static final int			IDs_MAP_REMOVE											= newActionType("remove object mapping ", "object mapping");
		public static final int			IDs_MAP_CLEAR												= newActionType("clear all object mapping ", "object mapping");
		public static final int			L_RESP_RESP														= newActionType("bilogical response response", "response response");
		public static final int			EO_FN_EXPRESSION									= newActionType("function expresion", "function expresion");
		public static final int			EO_FN_PARAMETERS									= newActionType("function parameters", "function parameters");
		public static final int			SP_TIME_COURSE											= newActionType("subsance time course response", "time course");
		public static final int			TRANSF_SET_TARGET_AID				= newActionType("transformation set target site", "transformation set target site");
		
		public static final int			RES_NAME_AID													= newActionType("resource name change", "resource name change");
		public static final int			RES_CONTENT_AID										= newActionType("resource content change", "resource content change");
		public static final int			RES_TYPE_AID													= newActionType("resource type change", "resource type change");
		public static final int			SP_MEASURED_CONC									= newActionType("subsance nominal and measured concentration", "nominal and measured concentration");
		public static final int			LAB_NAME_AID													= newActionType("Laboratory name", "laboratory name");
		
		public static final int			LIST_ASSIGN														= newActionType("object list reassigned", "assign");
		
		public static final int			SHORT_NAME															= newActionType("short name", "short name");
		public static final int			KEYWORDS																	= newActionType("keywords", "keywords");
		public static final int			GROUPS																			= newActionType("groups", "groups");
		public static final int			E_COMPONENTS													= newActionType("event component", "event component");
		public static final int			E_ACTION																	= newActionType("action", "action");
		public static final int			E_PROCESS																= newActionType("process", "process");
		public static final int			E_OBJECT																	= newActionType("object", "object");
	}

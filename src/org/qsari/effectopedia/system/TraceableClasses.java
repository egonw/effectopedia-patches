package org.qsari.effectopedia.system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.ids.DescriptionIDs;
import org.qsari.effectopedia.base.ids.IDs;
import org.qsari.effectopedia.base.ids.ReferenceID;
import org.qsari.effectopedia.base.ids.ReferenceIDW;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.objects.Constituent;
import org.qsari.effectopedia.core.objects.ContextDimension;
import org.qsari.effectopedia.core.objects.ContextDimension_Hierarchical;
import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.core.objects.DescriptionSection_Structured;
import org.qsari.effectopedia.core.objects.DiscussionPosting;
import org.qsari.effectopedia.core.objects.DiscussionTopic;
import org.qsari.effectopedia.core.objects.DocumentedKnowledge;
import org.qsari.effectopedia.core.objects.DocumentedKnowledge_Located;
import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Effect_AdverseOutcome;
import org.qsari.effectopedia.core.objects.Effect_DownstreamEffect;
import org.qsari.effectopedia.core.objects.Effect_Endpoint;
import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;
import org.qsari.effectopedia.core.objects.Initiator;
import org.qsari.effectopedia.core.objects.Initiator_BiologcalPerturbation;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.Initiator_StructuralAlerts;
import org.qsari.effectopedia.core.objects.Lab;
import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.Link_ChemStructToChemStruct;
import org.qsari.effectopedia.core.objects.Link_ChemStructToMIE;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.core.objects.Method;
import org.qsari.effectopedia.core.objects.Method_InSilicoGlobalModel;
import org.qsari.effectopedia.core.objects.Method_Investigation;
import org.qsari.effectopedia.core.objects.Method_Study;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.objects.Reference;
import org.qsari.effectopedia.core.objects.Substance;
import org.qsari.effectopedia.core.objects.SubstanceData;
import org.qsari.effectopedia.core.objects.SubstanceData_InLab;
import org.qsari.effectopedia.core.objects.SubstanceData_InSilico;
import org.qsari.effectopedia.core.objects.Test;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.core.objects.Test_ExVivo;
import org.qsari.effectopedia.core.objects.Test_InChemico;
import org.qsari.effectopedia.core.objects.Test_InLab;
import org.qsari.effectopedia.core.objects.Test_InSilico;
import org.qsari.effectopedia.core.objects.Test_InVitro;
import org.qsari.effectopedia.core.objects.Test_InVivo;
import org.qsari.effectopedia.core.objects.TransformationSet;
import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.data.objects.ObjectPropertyType;
import org.qsari.effectopedia.data.objects.Resource;
import org.qsari.effectopedia.data.quantification.DataTemplateType;

public class TraceableClasses
	{
		private TraceableClasses()
			{
				super();
				classIndex = new HashMap<Class<?>, TraceableClass>();
				identifierIndex = new HashMap<String, TraceableClass>();
				classIDs = new HashMap<Long, TraceableClass>();
				
				addClass(EffectopediaObject.class, "EffectopediaObject", "effectopedia object");
				addClass(ContextDimension.class, "ContextDimension", "context dimension");
				addClass(ContextDimension_Hierarchical.class, "ContextDimension_Hierarchical", "hierarchical context dimension");
				addClass(DescriptionSection.class, "DescriptionSection", "description section");
				addClass(DiscussionPosting.class, "DiscussionPosting", "discussion posting");
				addClass(DiscussionTopic.class, "DiscussionTopic", "discussion topic");
				addClass(DocumentedKnowledge.class, "DocumentedKnowledge", "documented knowledge");
				addClass(Effect.class, "Effect", "effect");
				addClass(Effect_MolecularInitiatingEvent.class, "Effect_MolecularInitiatingEvent", "molecular initiating event");
				addClass(Effect_DownstreamEffect.class, "Effect_DownstreamEffect", "(key) event");
				addClass(Effect_Endpoint.class, "Effect_Endpoint", "endpoint");
				addClass(Effect_AdverseOutcome.class, "Effect_AdverseOutcome", "adverse outcome");
				addClass(Lab.class, "Lab", "lab");
				addClass(Link_ChemStructToChemStruct.class, "Link_ChemStructToChemStruct", "ADME link");
				addClass(Link_ChemStructToMIE.class, "Link_ChemStructToMIE", "structure to MIE link");
				addClass(Link_EffectToEffect.class, "Link_EffectToEffect", "(key) event relationshop");
				addClass(Link.class, "Link", "abstract link");
				addClass(Pathway.class, "Pathway", "pathway");
				addClass(PathwayElement.class, "PathwayElement", "pathway element");
				addClass(Initiator.class, "Initiator", "initiator");
				addClass(Initiator_ChemicalStructure.class, "Initiator_ChemicalStructure", "chemical structure");
				addClass(Substance.class, "Substance", "chemical substance");
				addClass(Initiator_StructuralAlerts.class, "Initiator_StructuralAlerts", "structural alert");
				addClass(Test_InChemico.class, "Test_InChemico", "in-chemico test");
				addClass(Reference.class, "Reference", "reference");
				
				addClass(ReferenceIDs.class, "ReferenceIDs", "referred idnetifiers");
				addClass(ReferenceID.class, "ReferenceID", "referred idnetifier");
				addClass(IDs.class, "IDs", "contained idnetifiers");
				addClass(DescriptionIDs.class, "DescriptionIDs", "description identifiers");
				
				addClass(ObjectPropertyType.class, "ObjectPropertyType", "object property type");
				addClass(Initiator_BiologcalPerturbation.class, "Initiator_BiologcalPerturbation", "biological perturbation");
				
				addClass(Test.class, "Test", "test");
				addClass(Test_InLab.class, "Test_InLab", "in lab test");
				addClass(Test_InVitro.class, "Test_InVitro", "in-vitro test");
				addClass(Test_InVivo.class, "Test_InVivo", "in-vivo test");
				addClass(Test_InSilico.class, "Test_InSilico", "in-silico test");
				addClass(TestResponseMapping.class, "TestResponseMapping", "test responce to (key) event mapping");
				
				// additions after version 0.945 below;
				addClass(Test_ExVivo.class, "Test_ExVivo", "ex-vivo test");
				addClass(Method.class, "Method", "method");
				addClass(Method_Investigation.class, "Method_Investigation", "investigation");
				addClass(Method_Study.class, "Method_Study", "study");
				
				// additions after version 0.9455 below;
				addClass(SubstanceData.class, "SubstanceData", "substance data");
				addClass(SubstanceData_InLab.class, "SubstanceData_InLab", "substance experimental data");
				
				// additions after version 0.95 below;
				addClass(Constituent.class, "Constituent", "constituent");
				addClass(Method_InSilicoGlobalModel.class, "Method_InSilicoGlobalModel", "global model");
				addClass(DescriptionSection_Structured.class, "DescriptionSection_Structured", "description section with structured information");
				addClass(ReferenceIDW.class, "ReferenceIDW", "weighted referral");
				addClass(DescriptorType.class, "DescriptorType", "descriptor type");
				addClass(DataTemplateType.class, "DataTemplateType", "data template");
				
				// additions after version 0.963 below;
				addClass(TransformationSet.class, "TransformationSet", "transformation function set");
				
				// additions after version 0.972 below;
				addClass(Resource.class, "Resource", "resource");
				addClass(SubstanceData_InSilico.class, "SubstanceData_InSilico", "substance model predicted data");
				
				// additions after version 0.975 below;
				addClass(DocumentedKnowledge_Located.class, "DocumentedKnowledge_Located", "documented knowledge with context");
				
			}
		
		public void addClass(Class<? extends EffectopediaObject> c, String identifier, String description)
			{
				TraceableClass traceableClass = new TraceableClass(c, c.getName(), identifier, description);
				classIndex.put(c, traceableClass);
				classIDs.put(traceableClass.getID(), traceableClass);
				identifierIndex.put(identifier, traceableClass);
			}
		
		public long getClassID(Class<?> c)
			{
				TraceableClass traceable = classIndex.get(c);
				if (traceable == null)
					return 0L;
				else
					return traceable.getID();
			}
		
		public String getDescription(Class<?> c)
			{
				TraceableClass traceable = classIndex.get(c);
				if (traceable == null)
					return "";
				else
					return traceable.getDescription();
			}

		public String getIdentifier(Class<?> c)
			{
				TraceableClass traceable = classIndex.get(c);
				if (traceable == null)
					return "";
				else
					return traceable.getIdentifier();
			}
		
		public Class<? extends EffectopediaObject> getClassByIdentifier(String identifier)
			{
				TraceableClass traceable = identifierIndex.get(identifier);
				if (traceable == null)
					return null;
				else
					return traceable.getRegisteredClass();
			}
		
		public Class<? extends EffectopediaObject> getClassByID(long id)
			{
				TraceableClass traceable = classIDs.get(id);
				if (traceable == null)
					return null;
				else
					return traceable.getRegisteredClass();
			}

		public String[] getAllDescendents(Class<?> ofTheClass)
			{
				if (ofTheClass == null)
					return new String[0];
				ArrayList<String> classes = new ArrayList<String>();
				for (Iterator<Map.Entry<Class<?>, TraceableClass>> it = classIndex.entrySet().iterator(); it.hasNext();)
					{
						Map.Entry<Class<?>, TraceableClass> entry = it.next();
						if (ofTheClass.isAssignableFrom(entry.getKey()))
							classes.add(entry.getValue().getDescription());
					}
				Collections.sort(classes);
				return classes.toArray(new String[classes.size()]);
			}

		public static String getTraceableClassesDescriptions()
			{
				StringBuilder sb = new StringBuilder();
				Iterator<Map.Entry<Long, TraceableClass>> it = REGISTERED.classIDs.entrySet().iterator();
				while (it.hasNext())
					{
						Map.Entry<Long, TraceableClass> traceableClass = it.next();
						sb.append(traceableClass.getKey());
						sb.append("\t");
						sb.append(traceableClass.getValue().getRegisteredClass().getCanonicalName());
						sb.append("\t");
						sb.append(traceableClass.getValue().getDescription());
						sb.append("\n");
					}
				return sb.toString();
			}
		
		public static String getTraceableClassesAsInsertSQL()
			{
				StringBuilder sb = new StringBuilder();
				sb.append("INSERT INTO `object_types` ( `type_id` , `class_name` , `description` ) VALUES");
				Iterator<Map.Entry<Long, TraceableClass>> it = REGISTERED.classIDs.entrySet().iterator();
				while (it.hasNext())
					{
						Map.Entry<Long, TraceableClass> traceableClass = it.next();
						sb.append("('");
						sb.append(traceableClass.getKey() + 1);
						sb.append("', '");
						sb.append(traceableClass.getValue().getRegisteredClass().getCanonicalName());
						sb.append("', '");
						sb.append(traceableClass.getValue().getDescription());
						sb.append("'), ");
					}
				sb.replace(sb.length() - 2, sb.length(), ";");
				return sb.toString();
			}
		
		public static TraceableClasses												REGISTERED	= new TraceableClasses();
		private HashMap<String, TraceableClass>			identifierIndex;
		private HashMap<Class<?>, TraceableClass>	classIndex;
		private HashMap<Long, TraceableClass>					classIDs;
	}

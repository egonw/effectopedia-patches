package org.qsari.effectopedia.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObject.BatchSetExternalIDToZero;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.base.ids.DescriptionIDs;
import org.qsari.effectopedia.base.ids.IDs;
import org.qsari.effectopedia.base.ids.ReferenceID;
import org.qsari.effectopedia.base.ids.ReferenceIDW;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.core.containers.Constituents;
import org.qsari.effectopedia.core.containers.Context;
import org.qsari.effectopedia.core.containers.DataTempleteTypes;
import org.qsari.effectopedia.core.containers.Description;
import org.qsari.effectopedia.core.containers.Discussion;
import org.qsari.effectopedia.core.containers.Effects;
import org.qsari.effectopedia.core.containers.IDRefList;
import org.qsari.effectopedia.core.containers.IDsRefList;
import org.qsari.effectopedia.core.containers.Initiators;
import org.qsari.effectopedia.core.containers.Labs;
import org.qsari.effectopedia.core.containers.Links;
import org.qsari.effectopedia.core.containers.Methods;
import org.qsari.effectopedia.core.containers.Pathways;
import org.qsari.effectopedia.core.containers.PropertyTypes;
import org.qsari.effectopedia.core.containers.References;
import org.qsari.effectopedia.core.containers.Resources;
import org.qsari.effectopedia.core.containers.SubstanceDataCollections;
import org.qsari.effectopedia.core.containers.Substances;
import org.qsari.effectopedia.core.containers.TestResponseMappings;
import org.qsari.effectopedia.core.containers.Tests;
import org.qsari.effectopedia.core.containers.TransformationSets;
import org.qsari.effectopedia.core.objects.Constituent;
import org.qsari.effectopedia.core.objects.ContextDimension;
import org.qsari.effectopedia.core.objects.ContextDimension_Hierarchical;
import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.core.objects.DescriptionSection_Structured;
import org.qsari.effectopedia.core.objects.DiscussionPosting;
import org.qsari.effectopedia.core.objects.DiscussionTopic;
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

public class Indices extends LinkedHashMap<Class<? extends EffectopediaObject>, EffectopediaObjects<? extends EffectopediaObject>>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public Indices()
			{
				super();
				reverseMap = new TreeMap<EffectopediaObjects<? extends EffectopediaObject>, ArrayList<Class<? extends EffectopediaObject>>>();
				build();
			}
		
		public HashMap<Long, EffectopediaObject> generateExternalIDToIDMap()
			{
				HashMap<Long, EffectopediaObject> idMap = new HashMap<Long, EffectopediaObject>();
				Iterator<java.util.Map.Entry<EffectopediaObjects<? extends EffectopediaObject>, ArrayList<Class<? extends EffectopediaObject>>>> it = reverseMap.entrySet().iterator();
				while (it.hasNext())
					{
						EffectopediaObjects<? extends EffectopediaObject> index = it.next().getKey();
						index.updateExternalIDToIDMap(idMap);
					}
				return idMap;
			}
		
		public HashMap<Long, EffectopediaObject> getAllObjects()
			{
				HashMap<Long, EffectopediaObject> map = new HashMap<Long, EffectopediaObject>();
				Iterator<Map.Entry<EffectopediaObjects<? extends EffectopediaObject>, ArrayList<Class<? extends EffectopediaObject>>>> it = reverseMap.entrySet().iterator();
				while (it.hasNext())
					map.putAll(it.next().getKey());
				return map;
			}
		
		public void updateExternalIDs()
			{
				Iterator<Map.Entry<EffectopediaObjects<? extends EffectopediaObject>, ArrayList<Class<? extends EffectopediaObject>>>> it = reverseMap.entrySet().iterator();
				while (it.hasNext())
					it.next().getKey().updateExternalIDs();
			}
		
		public void clearExternalIDs()
			{
				Iterator<Map.Entry<EffectopediaObjects<? extends EffectopediaObject>, ArrayList<Class<? extends EffectopediaObject>>>> it = reverseMap.entrySet().iterator();
				while (it.hasNext())
					{
						EffectopediaObjects<? extends EffectopediaObject> objects = it.next().getKey();
						for (EffectopediaObject eo : objects.values())
							eo.process(BatchSetExternalIDToZero.INSTANCE);
						
					}
			}
		
		public void updateParenthood()
			{
				Iterator<Map.Entry<EffectopediaObjects<? extends EffectopediaObject>, ArrayList<Class<? extends EffectopediaObject>>>> it = reverseMap.entrySet().iterator();
				while (it.hasNext())
					it.next().getKey().updateParenthood();
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element == null)
					return;
				int count = Integer.parseInt(element.getAttributeValue("count"));
				List<BaseIOElement> children = (List<BaseIOElement>) element.getChildren();
				if ((count != 0) && (children != null) && (children.size() == count))
					{
						Iterator<BaseIOElement> iterator = children.iterator();
						while (iterator.hasNext())
							{
								BaseIOElement child = (BaseIOElement) iterator.next();
								BaseIOElement associatedClass = child.getChild("associated_classes");
								Class<?> cl = null;
								try
									{
										cl = Class.forName(associatedClass.getChildValue("class"));
									}
								catch (ClassNotFoundException e)
									{
										e.printStackTrace();
									}
								if (cl != null)
									{
										EffectopediaObjects<?> objects = get(cl);
										objects.load(child, io);
									}
							}
					}
			}
		
		public BaseIOElement store(LinkedHashMap<Long, EffectopediaObject> processedIDs, BaseIOElement element, BaseIO io)
			{
				int cnt = 0;
				Iterator<java.util.Map.Entry<EffectopediaObjects<? extends EffectopediaObject>, ArrayList<Class<? extends EffectopediaObject>>>> it = reverseMap.entrySet().iterator();
				while (it.hasNext())
					{
						java.util.Map.Entry<EffectopediaObjects<? extends EffectopediaObject>, ArrayList<Class<? extends EffectopediaObject>>> entry = it.next();
						EffectopediaObjects<? extends EffectopediaObject> index = entry.getKey();
						if (index.size() == 0)
							continue;
						ArrayList<Class<? extends EffectopediaObject>> associatedClasses = entry.getValue();
						BaseIOElement associatedClassesElement = io.newElement("associated_classes");
						associatedClassesElement.setAttribute("count", String.valueOf(associatedClasses.size()));
						for (Class<? extends EffectopediaObject> c : associatedClasses)
							{
								// System.out.println(c.getName());
								associatedClassesElement.addChild(io.newElement("class").setValue(c.getName()));
							}
						BaseIOElement effectopediaObjectsElement = io.newElement(index.getClass().getSimpleName());
						effectopediaObjectsElement.addChild(associatedClassesElement);
						if (index.store(processedIDs, effectopediaObjectsElement, io) != null)
							{
								element.addChild(effectopediaObjectsElement);
								cnt++;
							}
					}
				element.setAttribute("count", Integer.toString(cnt));
				
				return element;
			}
		
		public EffectopediaObjects<? extends EffectopediaObject> put(Class<? extends EffectopediaObject> key, EffectopediaObjects<? extends EffectopediaObject> value)
			{
				ArrayList<Class<? extends EffectopediaObject>> associatedClasses = reverseMap.get(value);
				if (associatedClasses == null)
					{
						associatedClasses = new ArrayList<Class<? extends EffectopediaObject>>();
						reverseMap.put(value, associatedClasses);
					}
				associatedClasses.add(key);
				return super.put(key, value);
			}
		
		public EffectopediaObject getByID(long id)
			{
				Iterator<Map.Entry<Class<? extends EffectopediaObject>, EffectopediaObjects<? extends EffectopediaObject>>> it = this.entrySet().iterator();
				while (it.hasNext())
					{
						EffectopediaObjects<? extends EffectopediaObject> eos = it.next().getValue();
						EffectopediaObject eo = eos.get(id);
						if (eo != null)
							return eo;
					}
				return null;
			}
		
		public void updateReverseMap(Indices indices)
			{
				super.putAll(indices);
				Iterator<Map.Entry<Class<? extends EffectopediaObject>, EffectopediaObjects<? extends EffectopediaObject>>> iterator = indices.entrySet().iterator();
				while (iterator.hasNext())
					{
						Map.Entry<Class<? extends EffectopediaObject>, EffectopediaObjects<? extends EffectopediaObject>> entry = iterator.next();
						Class<? extends EffectopediaObject> key = entry.getKey();
						EffectopediaObjects<? extends EffectopediaObject> value = entry.getValue();
						ArrayList<Class<? extends EffectopediaObject>> associatedClasses = reverseMap.get(value);
						if (associatedClasses == null)
							{
								associatedClasses = new ArrayList<Class<? extends EffectopediaObject>>();
								reverseMap.put(value, associatedClasses);
							}
						associatedClasses.add(key);
					}
			}
		
		public void putAll(Indices indices)
			{
				pathways.putAll(indices.getPathways());
				effects.putAll(indices.getEffects());
				initiatiors.putAll(indices.getInitiators());
				links.putAll(indices.getLinks());
				tests.putAll(indices.getTests());
				substance_data.putAll(indices.getSubstanceData());
				mappings.putAll(indices.getMappings());
				constituents.putAll(indices.getConstituents());
				substances.putAll(indices.getSubstances());
				methods.putAll(indices.getMethods());
				labs.putAll(indices.getLabs());
				references.putAll(indices.getReferences());
				discussion.putAll(indices.getDiscussion());
				description.putAll(indices.getDescription());
				context.putAll(indices.getContext());
				ids_ref_list.putAll(indices.getIds_ref_list());
				id_ref_list.putAll(indices.getId_ref_list());
				property_types.putAll(indices.getPropertyTypes());
				templateTypes.putAll(indices.getTemplateTypes());
				transformationSets.putAll(indices.getTransformationSets());
				resources.putAll(indices.getResources());
			}
		
		public void putClones(Indices indices, DataSource dataSource)
			{
				pathways.putClones(indices.getPathways(), dataSource);
				effects.putClones(indices.getEffects(), dataSource);
				initiatiors.putClones(indices.getInitiators(), dataSource);
				links.putClones(indices.getLinks(), dataSource);
				tests.putClones(indices.getTests(), dataSource);
				substance_data.putClones(indices.getSubstanceData(), dataSource);
				mappings.putClones(indices.getMappings(), dataSource);
				constituents.putClones(indices.getConstituents(), dataSource);
				substances.putClones(indices.getSubstances(), dataSource);
				methods.putClones(indices.getMethods(), dataSource);
				labs.putClones(indices.getLabs(), dataSource);
				references.putClones(indices.getReferences(), dataSource);
				discussion.putClones(indices.getDiscussion(), dataSource);
				description.putClones(indices.getDescription(), dataSource);
				context.putClones(indices.getContext(), dataSource);
				ids_ref_list.putClones(indices.getIds_ref_list(), dataSource);
				id_ref_list.putClones(indices.getId_ref_list(), dataSource);
				property_types.putClones(indices.getPropertyTypes(), dataSource);
				templateTypes.putClones(indices.getTemplateTypes(), dataSource);
				transformationSets.putClones(indices.getTransformationSets(), dataSource);
				resources.putClones(indices.getResources(), dataSource);
			}
		
		public void putDefault(Indices indices)
			{
				pathways.putDefault(indices.getPathways());
				effects.putDefault(indices.getEffects());
				initiatiors.putDefault(indices.getInitiators());
				links.putDefault(indices.getLinks());
				tests.putDefault(indices.getTests());
				substance_data.putDefault(indices.getSubstanceData());
				mappings.putDefault(indices.getMappings());
				constituents.putDefault(indices.getConstituents());
				substances.putDefault(indices.getSubstances());
				methods.putDefault(indices.getMethods());
				labs.putDefault(indices.getLabs());
				references.putDefault(indices.getReferences());
				discussion.putDefault(indices.getDiscussion());
				description.putDefault(indices.getDescription());
				context.putDefault(indices.getContext());
				ids_ref_list.putDefault(indices.getIds_ref_list());
				id_ref_list.putDefault(indices.getId_ref_list());
				property_types.putDefault(indices.getPropertyTypes());
				templateTypes.putDefault(indices.getTemplateTypes());
				transformationSets.putDefault(indices.getTransformationSets());
				resources.putDefault(indices.getResources());
			}
		
		public void putAll(Indices indices, long maxExternalID)
			{
				pathways.putAll(indices.getPathways(), maxExternalID);
				effects.putAll(indices.getEffects(), maxExternalID);
				initiatiors.putAll(indices.getInitiators(), maxExternalID);
				links.putAll(indices.getLinks(), maxExternalID);
				tests.putAll(indices.getTests(), maxExternalID);
				substance_data.putAll(indices.getSubstanceData());
				mappings.putAll(indices.getMappings(), maxExternalID);
				constituents.putAll(indices.getConstituents(), maxExternalID);
				substances.putAll(indices.getSubstances(), maxExternalID);
				labs.putAll(indices.getLabs(), maxExternalID);
				methods.putAll(indices.getMethods(), maxExternalID);
				references.putAll(indices.getReferences(), maxExternalID);
				discussion.putAll(indices.getDiscussion(), maxExternalID);
				description.putAll(indices.getDescription(), maxExternalID);
				context.putAll(indices.getContext(), maxExternalID);
				ids_ref_list.putAll(indices.getIds_ref_list(), maxExternalID);
				id_ref_list.putAll(indices.getId_ref_list(), maxExternalID);
				property_types.putAll(indices.getPropertyTypes(), maxExternalID);
				templateTypes.putAll(indices.getTemplateTypes(), maxExternalID);
				transformationSets.putAll(indices.getTransformationSets(), maxExternalID);
				resources.putAll(indices.getResources(), maxExternalID);
			}
		
		public void updateDataSource(DataSource dataSource, boolean reloadCachedObjects)
			{
				pathways.setDataSource(dataSource);
				effects.setDataSource(dataSource);
				initiatiors.setDataSource(dataSource);
				links.setDataSource(dataSource);
				tests.setDataSource(dataSource);
				substance_data.setDataSource(dataSource);
				mappings.setDataSource(dataSource);
				constituents.setDataSource(dataSource);
				substances.setDataSource(dataSource);
				labs.setDataSource(dataSource);
				methods.setDataSource(dataSource);
				references.setDataSource(dataSource);
				discussion.setDataSource(dataSource);
				description.setDataSource(dataSource);
				context.setDataSource(dataSource);
				ids_ref_list.setDataSource(dataSource);
				id_ref_list.setDataSource(dataSource);
				property_types.setDataSource(dataSource);
				templateTypes.setDataSource(dataSource);
				transformationSets.setDataSource(dataSource);
				resources.setDataSource(dataSource);
				if (reloadCachedObjects)
					{
						Iterator<Map.Entry<EffectopediaObjects<? extends EffectopediaObject>, ArrayList<Class<? extends EffectopediaObject>>>> it = reverseMap.entrySet().iterator();
						while (it.hasNext())
							it.next().getKey().reloadReferredObjectsFromID();
					}
			}

		public void getAll(LinkedHashMap<Long, EffectopediaObject> map)
			{
				for (EffectopediaObjects<? extends EffectopediaObject> objects:this.values())
					map.putAll(objects);
			}
		
		protected void build()
			{
				pathways = new Pathways();
				this.put(Pathway.class, pathways);
				effects = new Effects();
				this.put(Effect.class, effects);
				this.put(Effect_DownstreamEffect.class, effects);
				this.put(Effect_MolecularInitiatingEvent.class, effects);
				this.put(Effect_Endpoint.class, effects);
				this.put(Effect_AdverseOutcome.class, effects);
				initiatiors = new Initiators();
				this.put(Initiator.class, initiatiors);
				this.put(Initiator_ChemicalStructure.class, initiatiors);
				this.put(Initiator_StructuralAlerts.class, initiatiors);
				this.put(Initiator_BiologcalPerturbation.class, initiatiors);
				links = new Links();
				this.put(Link.class, links);
				this.put(Link_ChemStructToMIE.class, links);
				this.put(Link_ChemStructToChemStruct.class, links);
				this.put(Link_EffectToEffect.class, links);
				tests = new Tests();
				this.put(Test.class, tests);
				this.put(Test_InLab.class, tests);
				this.put(Test_InChemico.class, tests);
				this.put(Test_InVitro.class, tests);
				this.put(Test_InVivo.class, tests);
				this.put(Test_ExVivo.class, tests);
				this.put(Test_InSilico.class, tests);
				substance_data = new SubstanceDataCollections();
				this.put(SubstanceData.class, substance_data);
				this.put(SubstanceData_InLab.class, substance_data);
				this.put(SubstanceData_InSilico.class, substance_data);
				mappings = new TestResponseMappings();
				this.put(TestResponseMapping.class, mappings);
				substances = new Substances();
				this.put(Substance.class, substances);
				constituents = new Constituents();
				this.put(Constituent.class, constituents);
				methods = new Methods();
				this.put(Method.class, methods);
				this.put(Method_Investigation.class, methods);
				this.put(Method_Study.class, methods);
				this.put(Method_InSilicoGlobalModel.class, methods);
				labs = new Labs();
				this.put(Lab.class, labs);
				references = new References();
				this.put(Reference.class, references);
				discussion = new Discussion();
				this.put(DiscussionPosting.class, discussion);
				this.put(DiscussionTopic.class, discussion);
				description = new Description();
				this.put(DescriptionSection.class, description);
				this.put(DescriptionSection_Structured.class, description);
				context = new Context();
				this.put(ContextDimension.class, context);
				this.put(ContextDimension_Hierarchical.class, context);
				ids_ref_list = new IDsRefList();
				this.put(ReferenceIDs.class, ids_ref_list);
				this.put(IDs.class, ids_ref_list);
				this.put(DescriptionIDs.class, ids_ref_list);
				id_ref_list = new IDRefList();
				this.put(ReferenceID.class, id_ref_list);
				this.put(ReferenceIDW.class, id_ref_list);
				property_types = new PropertyTypes();
				this.put(DescriptorType.class, property_types);
				this.put(ObjectPropertyType.class, property_types);
				templateTypes = new DataTempleteTypes();
				this.put(DataTemplateType.class, templateTypes);
				transformationSets = new TransformationSets();
				this.put(TransformationSet.class, transformationSets);
				resources = new Resources();
				this.put(Resource.class, resources);
			}
		
		public EffectopediaObject getEffectopediaObject(long ID)
			{
				Iterator<Map.Entry<Class<? extends EffectopediaObject>, EffectopediaObjects<? extends EffectopediaObject>>> it = entrySet().iterator();
				while (it.hasNext())
					{
						EffectopediaObject eo = it.next().getValue().get(ID);
						if (eo != null)
							return eo;
					}
				return null;
			}
		
		public void replaceDefaultObjectsWtihClones()
			{
				Iterator<Map.Entry<EffectopediaObjects<? extends EffectopediaObject>, ArrayList<Class<? extends EffectopediaObject>>>> it = reverseMap.entrySet().iterator();
				while (it.hasNext())
					it.next().getKey().replaceDefaultObjectsWtihClones();
			}

		public void replaceArchivedObjectsWtihClones()
			{
				Iterator<Map.Entry<EffectopediaObjects<? extends EffectopediaObject>, ArrayList<Class<? extends EffectopediaObject>>>> it = reverseMap.entrySet().iterator();
				while (it.hasNext())
					it.next().getKey().replaceArchivedObjectsWtihClones();
			}
		
		public void reloadReferredObjectsFromID()
			{
				Iterator<EffectopediaObjects<? extends EffectopediaObject>> it = reverseMap.keySet().iterator();
				while (it.hasNext())
					it.next().reloadReferredObjectsFromID();
			}

		public void updateReferrals(HashMap<Long, EffectopediaObject> referrals)
			{
				ids_ref_list.updateReferrals(referrals);
				id_ref_list.updateReferrals(referrals);
				pathways.updateReferrals(referrals);
			}

		public void updateReferrals(DataSourceMerge dsm)
			{
				ids_ref_list.updateReferrals(dsm);
				id_ref_list.updateReferrals(dsm);
				pathways.updateReferrals(dsm);
			}
		
		public int getTotalEffectopediaObjectCount()
			{
				int totalSize = 0;
				Iterator<EffectopediaObjects<? extends EffectopediaObject>> it = reverseMap.keySet().iterator();
				while (it.hasNext())
					totalSize += it.next().size();
				return totalSize;
			}
		
		public long getMinObjectID()
			{
				long globalMinObjectID = EffectopediaObject.effectopediaObjectIDs;
				Iterator<EffectopediaObjects<? extends EffectopediaObject>> it = reverseMap.keySet().iterator();
				while (it.hasNext())
					{
						long minID = it.next().getMinObjectID();
						if (globalMinObjectID > minID)
							globalMinObjectID = minID;
					}
				return globalMinObjectID;
			}
		
		public long getMaxObjectID()
			{
				long indecesMaxObjectID = 0;
				Iterator<EffectopediaObjects<? extends EffectopediaObject>> it = reverseMap.keySet().iterator();
				while (it.hasNext())
					{
						long maxID = it.next().getMaxObjectID();
						if (indecesMaxObjectID < maxID)
							indecesMaxObjectID = maxID;
					}
				return indecesMaxObjectID;
			}
		
		public void DEBUG_printIndices()
			{
				Iterator<Map.Entry<EffectopediaObjects<? extends EffectopediaObject>, ArrayList<Class<? extends EffectopediaObject>>>> it = reverseMap.entrySet().iterator();
				while (it.hasNext())
					{
						EffectopediaObjects<?> eos = it.next().getKey();
					//	System.out.println("Indices.DEBUG summary\t" + eos.getClass() + "\tcount\t" + eos.size());
					}
				it = reverseMap.entrySet().iterator();
				while (it.hasNext())
					it.next().getKey().DEBUG_pintContainedIDs();
			}
		
		public void clearIndices()
			{
				Iterator<Map.Entry<EffectopediaObjects<? extends EffectopediaObject>, ArrayList<Class<? extends EffectopediaObject>>>> it = reverseMap.entrySet().iterator();
				while (it.hasNext())
					it.next().getKey().clear();
			}
		
		public Pathways getPathways()
			{
				return pathways;
			}
		
		public void setPathways(Pathways pathways)
			{
				this.pathways = pathways;
			}
		
		public Initiators getInitiators()
			{
				return initiatiors;
			}
		
		public void setInitiators(Initiators initiators)
			{
				this.initiatiors = initiators;
			}
		
		public Effects getEffects()
			{
				return effects;
			}
		
		public void setEffects(Effects effects)
			{
				this.effects = effects;
			}
		
		public Links getLinks()
			{
				return links;
			}
		
		public void setLinks(Links links)
			{
				this.links = links;
			}
		
		public Tests getTests()
			{
				return tests;
			}
		
		public void setTests(Tests tests)
			{
				this.tests = tests;
			}
		
		public TestResponseMappings getMappings()
			{
				return mappings;
			}
		
		public SubstanceDataCollections getSubstanceData()
			{
				return substance_data;
			}
		
		public void setSubstanceData(SubstanceDataCollections substanceData)
			{
				this.substance_data = substanceData;
			}
		
		public void setMappings(TestResponseMappings mappings)
			{
				this.mappings = mappings;
			}
		
		public Methods getMethods()
			{
				return methods;
			}
		
		public void setMethods(Methods methods)
			{
				this.methods = methods;
			}
		
		public Labs getLabs()
			{
				return labs;
			}
		
		public void setLabs(Labs labs)
			{
				this.labs = labs;
			}
		
		public References getReferences()
			{
				return references;
			}
		
		public void setReferences(References references)
			{
				this.references = references;
			}
		
		public Discussion getDiscussion()
			{
				return discussion;
			}
		
		public void setDiscussion(Discussion discussion)
			{
				this.discussion = discussion;
			}
		
		public Description getDescription()
			{
				return description;
			}
		
		public void setDescription(Description description)
			{
				this.description = description;
			}
		
		public Context getContext()
			{
				return context;
			}
		
		public void setContext(Context context)
			{
				this.context = context;
			}
		
		public IDsRefList getIds_ref_list()
			{
				return ids_ref_list;
			}
		
		public void setIds_ref_list(IDsRefList idsRefList)
			{
				ids_ref_list = idsRefList;
			}
		
		public IDRefList getId_ref_list()
			{
				return id_ref_list;
			}
		
		public void setId_ref_list(IDRefList idRefList)
			{
				id_ref_list = idRefList;
			}
		
		public PropertyTypes getPropertyTypes()
			{
				return property_types;
			}
		
		public void setPropertyTypes(PropertyTypes propertyTypes)
			{
				this.property_types = propertyTypes;
			}
		
		public DataTempleteTypes getTemplateTypes()
			{
				return templateTypes;
			}
		
		public void setTemplateTypes(DataTempleteTypes templateTypes)
			{
				this.templateTypes = templateTypes;
			}
		
		public Constituents getConstituents()
			{
				return constituents;
			}
		
		public void setConstituents(Constituents constituents)
			{
				this.constituents = constituents;
			}
		
		public Substances getSubstances()
			{
				return substances;
			}
		
		public void setSubstances(Substances substances)
			{
				this.substances = substances;
			}
		
		public TransformationSets getTransformationSets()
			{
				return transformationSets;
			}
		
		public void setTransformationSets(TransformationSets transformationSets)
			{
				this.transformationSets = transformationSets;
			}
		
		public Resources getResources()
			{
				return resources;
			}

		public void setResources(Resources resources)
			{
				this.resources = resources;
			}

		public TreeMap<EffectopediaObjects<? extends EffectopediaObject>, ArrayList<Class<? extends EffectopediaObject>>> getReverseMap()
			{
				return reverseMap;
			}

		protected TreeMap<EffectopediaObjects<? extends EffectopediaObject>, ArrayList<Class<? extends EffectopediaObject>>>	reverseMap;
		
		protected Pathways																																																																																																			pathways;
		protected Initiators																																																																																																	initiatiors;
		protected Effects																																																																																																				effects;
		protected Links																																																																																																						links;
		protected Tests																																																																																																						tests;
		protected TestResponseMappings																																																																																							mappings;
		protected Constituents																																																																																															constituents;
		protected Substances																																																																																																	substances;
		protected SubstanceDataCollections																																																																																			substance_data;
		protected Methods																																																																																																				methods;
		protected Labs																																																																																																							labs;
		protected References																																																																																																	references;
		protected Discussion																																																																																																	discussion;
		protected Description																																																																																																description;
		protected Context																																																																																																				context;
		protected IDsRefList																																																																																																	ids_ref_list;
		protected IDRefList																																																																																																		id_ref_list;
		protected PropertyTypes																																																																																														property_types;
		protected DataTempleteTypes																																																																																										templateTypes;
		protected TransformationSets																																																																																									transformationSets;
		protected Resources																																																																																																		resources;

		
	}

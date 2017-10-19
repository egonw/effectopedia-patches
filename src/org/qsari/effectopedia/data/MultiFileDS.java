package org.qsari.effectopedia.data;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
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
import org.qsari.effectopedia.history.EditHistory;
import org.qsari.effectopedia.system.TraceableClasses;

public class MultiFileDS extends FileDS
	{
		public static final String																				LIVE_IDS						= "live_ids";
		public static final String																				ARCHIVE_IDS			= "archive_ids";
		public static final String																				SOURCE_TRACES	= "source_traces";
		public static final String																				EDIT_HISTORY		= "edit_history";
		public static final String																				SEPARTATOR				= File.separator;
		public static final String																				SEP_REGEXPR			= SEPARTATOR.equals("\\") ? "\\\\" : SEPARTATOR;
		public static final String																				FILE_EXT						= ".xml";
		public static final String																				PROVISIONAL			= "p";
		
		public static final HashMap<Class<?>, String>	DIRECTORY_MAP	= new HashMap<Class<?>, String>();
		static
			{
				DIRECTORY_MAP.put(Pathways.class, "pathways");
				DIRECTORY_MAP.put(Initiators.class, "initiatiors");
				DIRECTORY_MAP.put(Effects.class, "effects");
				DIRECTORY_MAP.put(Links.class, "links");
				DIRECTORY_MAP.put(Tests.class, "tests");
				DIRECTORY_MAP.put(TestResponseMappings.class, "mappings");
				DIRECTORY_MAP.put(Constituents.class, "constituents");
				DIRECTORY_MAP.put(Substances.class, "substances");
				DIRECTORY_MAP.put(SubstanceDataCollections.class, "substance_data");
				DIRECTORY_MAP.put(Methods.class, "methods");
				DIRECTORY_MAP.put(Labs.class, "labs");
				DIRECTORY_MAP.put(References.class, "references");
				DIRECTORY_MAP.put(Discussion.class, "discussion");
				DIRECTORY_MAP.put(Description.class, "description");
				DIRECTORY_MAP.put(Context.class, "context");
				DIRECTORY_MAP.put(IDsRefList.class, "ids_ref_list");
				DIRECTORY_MAP.put(IDRefList.class, "id_ref_list");
				DIRECTORY_MAP.put(PropertyTypes.class, "property_types");
				DIRECTORY_MAP.put(DataTempleteTypes.class, "template_types");
				DIRECTORY_MAP.put(TransformationSets.class, "transformation_sets");
				DIRECTORY_MAP.put(Resources.class, "resources");
			}
		
		protected void initLoading()
			{
				internalLoad = true;
				createLive = true;
				// EffectopediaObject.clearDefaultObectsExternalIds();
				// processedIDs.clear();
				// processedArchivedIDs.clear();
			}
		
		protected void loadBaseIOElement(String path, BaseIOElement element, BaseIO io)
			{
				String[] pathFolders = path.toLowerCase().split(SEP_REGEXPR);
				if (pathFolders.length > 1)
					{
						String folder = pathFolders[0];
						String name = pathFolders[pathFolders.length - 1];
						if (skip(name))
							{
								//System.out.println("Skipping:" + name);
								return;
							}
						if (folder.equals(LIVE_IDS))
							loadBaseIOElementInIndices(true, element, io);
						else if (folder.equals(ARCHIVE_IDS))
							loadBaseIOElementInIndices(false, element, io);
						else if (folder.equals(EDIT_HISTORY))
							loadBaseIOElementInEditHistory(element, io);
						else if (folder.equals(SOURCE_TRACES))
							loadBaseIOElementInSrcTraces(element, io);
					}
				else if (path.equals(generateName("", "aops")))
					loadAllFromRoot(element, io);
			}
		
		protected void loadBaseIOElementInIndices(boolean isLive, BaseIOElement element, BaseIO io)
			{
				Class<?> elementClass = TraceableClasses.REGISTERED.getClassByIdentifier(element.getName());
				createLive = isLive;
				internalLoad = true;
				if (elementClass != null)
					io.load(elementClass, null, element);
				internalLoad = false;
			}
		
		protected void loadBaseIOElementInEditHistory(BaseIOElement element, BaseIO io)
			{
				BaseIOAttribute rev = element.getAttribute("number");
				BaseIOAttribute actions = element.getAttribute("count");
				BaseIOAttribute def_usr_act_cnt = element.getAttribute("default_actions_count");
				if ((rev != null) && (actions != null) && (def_usr_act_cnt != null))
					{
						long revision = rev.getLongValue();
						if (revision == 0)
							editHistory.loadBaseRevision(element, io);
						else
							editHistory.loadRevision(element, io);
						editHistory.startNewRevision();
					}
			}
		
		protected void loadBaseIOElementInSrcTraces(BaseIOElement element, BaseIO io)
			{
				livePathwayElements.loadRevision(element, io);
			}
		
		@Override
		public synchronized boolean loadAllFromRoot(BaseIOElement root, BaseIO baseIO)
			{
				loadEffectopediaHeader(root, baseIO);
				archiveIndices.updateDataSource(this, false);
				processedArchivedIDs.putAll(processedIDs);
				createLive = true;
				shallowMode = true;
				
				replaceExternalIDReferencesWithIDs();
				EffectopediaObject.updateDefaultObjectExternalIDs(processedArchivedIDs);
				
				revision = editHistory.getRevision();
				updateDefaultObjectInLiveIndices();
				liveIndices.replaceDefaultObjectsWtihClones();
				liveIndices.updateDataSource(this, false);
				liveIndices.reloadReferredObjectsFromID();
				internalLoad = false;
				liveIndices.updateParenthood();
				
				BaseIOElement locationElement = root.getChild("location");
				if (locationElement != null)
					{
						internalLocation = false;
						setLocation(Long.parseLong(locationElement.getValue()), internalLocation);
					}
				return true;
			}
		
		@Override
		protected void storeLiveIndices(BaseIOElement root, BaseIO io)
			{
				Iterator<Entry<EffectopediaObjects<? extends EffectopediaObject>, ArrayList<Class<? extends EffectopediaObject>>>> it = liveIndices.getReverseMap().entrySet().iterator();
				while (it.hasNext())
					{
						Entry<EffectopediaObjects<? extends EffectopediaObject>, ArrayList<Class<? extends EffectopediaObject>>> entry = it.next();
						String path = LIVE_IDS + SEPARTATOR + DIRECTORY_MAP.get(entry.getKey().getClass()) + SEPARTATOR;
						for (EffectopediaObject eo : entry.getKey().values())
							{
								if (saveUpdated && !editHistory.isUpdated(eo))
									continue;
							//	System.out.println("Saving:" + eo.DEBUG_getIDs());
								BaseIOElement eoElement = io.newElement(TraceableClasses.REGISTERED.getIdentifier(eo.getClass()));
								addFormatAttributes(eoElement, io);
								eo.store(eoElement, io);
								saveInFile(generateName(path, String.valueOf(eo.getExternalID())), eoElement, io);
							}
					}
			}
		
		@Override
		protected void storeArchiveIndices(BaseIOElement root, BaseIO io)
			{
				this.shallowMode = true;
				processedArchivedIDs.clear();
				Iterator<Entry<EffectopediaObjects<? extends EffectopediaObject>, ArrayList<Class<? extends EffectopediaObject>>>> it = archiveIndices.getReverseMap().entrySet().iterator();
				while (it.hasNext())
					{
						Entry<EffectopediaObjects<? extends EffectopediaObject>, ArrayList<Class<? extends EffectopediaObject>>> entry = it.next();
						String path = ARCHIVE_IDS + SEPARTATOR + DIRECTORY_MAP.get(entry.getKey().getClass()) + SEPARTATOR;
						for (EffectopediaObject eo : entry.getKey().values())
							{
								if (saveUpdated && !editHistory.isUpdated(eo))
									continue;
								BaseIOElement eoElement = io.newElement(TraceableClasses.REGISTERED.getIdentifier(eo.getClass()));
								addFormatAttributes(eoElement, io);
								eo.store(eoElement, io);
								saveInFile(generateName(path, String.valueOf(eo.getExternalID())), eoElement, io);
							}
					}
			}
		
		@Override
		protected void storeEditHistory(BaseIOElement root, BaseIO io)
			{
				String path = EDIT_HISTORY + SEPARTATOR;
				EditHistory.actionsCnt = 0;
				int fromRevision = saveUpdated ? editHistory.getRevisionsCount() - 1 : 0;
				for (int r = fromRevision; r < editHistory.getRevisionsCount(); r++)
					{
						BaseIOElement rev = io.newElement("revision");
						rev.setAttribute("number", r);
						rev.setAttribute("default_actions_count", Long.toString(-EffectopediaObject.getDefaultIDs() - 1));
						addFormatAttributes(rev, io);
						editHistory.storeRevision(r, rev, io);
						saveInFile(generateName(path, String.format("%019d", r)), rev, io);
					}
			}
		
		@Override
		protected void storeLivePathwayElements(BaseIOElement root, BaseIO io)
			{
				String path = SOURCE_TRACES + SEPARTATOR;
				int fromRevision = saveUpdated ? editHistory.getRevisionsCount() - 1 : 0;
				for (int r = fromRevision; r < editHistory.getRevisionsCount(); r++)
					{
						BaseIOElement rev = io.newElement("traces");
						rev.setAttribute("revision", r);
						addFormatAttributes(rev, io);
						livePathwayElements.storeRevision(editHistory.getFirstIDinRevision(r), editHistory.getLastIDinRevision(r), rev, io);
						saveInFile(generateName(path, String.format("%019d", r)), rev, io);
					}
			}
		
		protected String generateName(String path, String name)
			{
				StringBuilder sb = new StringBuilder();
				sb.append(path);
				if (provisional)
					sb.append(PROVISIONAL);
				sb.append(name);
				sb.append(FILE_EXT);
				return sb.toString();
			}
		
		protected boolean skip(String name)
			{
				int p = name.indexOf(PROVISIONAL);
				return provisional ^ (p != -1);
			}
		
		protected void addFormatAttributes(BaseIOElement element, BaseIO io)
			{
				element.setAttribute("format_version", VERSION);
				element.setAttribute("format_pattern", io.getDataPattern().toString());
			}
		
		protected void saveInFile(String fileName, BaseIOElement element, BaseIO io)
			{
			}
		
		public boolean isSaveUpdated()
			{
				return saveUpdated;
			}
		
		public void setSaveUpdated(boolean saveUpdated)
			{
				this.saveUpdated = saveUpdated;
			}
		
		protected boolean	saveUpdated	= false;
	}
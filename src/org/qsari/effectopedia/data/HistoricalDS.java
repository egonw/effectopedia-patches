package org.qsari.effectopedia.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.history.EditHistoryAction;
import org.qsari.effectopedia.search.SearchIndices.SearchableItemFilter;
import org.qsari.effectopedia.search.SearchableItem;
import org.qsari.effectopedia.system.TraceableClasses;

public class HistoricalDS extends RevisionBasedDS implements DataSourceItem
	{
		public HistoricalDS(RevisionBasedDS baseDS, long upToRevision)
			{
				this.revision = upToRevision;
				this.revisionCache = baseDS.revisionCache;
				this.baseDS = baseDS;
				rollbackTo(baseDS, upToRevision);
				updateSourceInfo();
				// DEBUG_SaveInFile();
			}
			
		public void updateSourceInfo()
			{
				this.sourceName = baseDS.sourceName;
				this.sourcePrefix = baseDS.sourcePrefix;
				if (baseDS.location != 0)
					{
						EffectopediaObject eo = baseDS.getLocationObject();
						eo = this.getLiveObject(eo.getClass(), eo.getID());
						if (eo != null)
							this.setLocation(eo);
					}
			}
			
		@Override
		public void add(EffectopediaObject eo)
			{
				EffectopediaObjects<? extends EffectopediaObject> objects = liveIndices.get(eo.getClass());
				objects.put(eo.getID(), eo);
			}
			
		public void addToArchive(Class<? extends EffectopediaObject> objectClass, EffectopediaObject eo)
			{
				EffectopediaObjects<? extends EffectopediaObject> objects = archiveIndices.get(objectClass);
				objects.put(eo.getID(), eo);
			}
			
		@Override
		public void add(Class<? extends EffectopediaObject> objectClass, EffectopediaObject io)
			{
			}
			
		@Override
		public EffectopediaObject remove(Class<? extends EffectopediaObject> objectClass, long id)
			{
				return null;
			}
			
		private void rollbackTo(RevisionBasedDS dataSource, long revision)
			{
				internalLoad = true;
				createLive = true;
				this.revision = revision;
				long maxExternalID = dataSource.getEditHistory().revisions.get((int) revision);
				stampIDOffset = dataSource.editHistory.getStampIDOffset();
				// Negative ID Revolution
				maxExternalID += dataSource.defaultIDs-stampIDOffset;
				
				loadIndices(dataSource, maxExternalID);
				
				// liveIndices.DEBUG_printIndices();
				for (Pathway e : liveIndices.getPathways().values())
					if (!e.isDefaultID())
						EffectopediaObject.DEBUG_printContainedIDs(e);
					
				liveIndices.getIds_ref_list().DEBUG_pintContainedIDs();
				
				liveIndices.updateDataSource(this, true);
				liveIndices.updateParenthood();
				archiveIndices.updateDataSource(this, false);
				
				editHistory.addAll(dataSource.editHistory, revision);
				views.putAll(dataSource.views);
				
				searchEngine.getIndices().copyRelevantIndices(dataSource.searchEngine.getIndices(), new ExternalIDFilter(maxExternalID));
				
				for (Pathway e : liveIndices.getPathways().values())
					if (!e.isDefaultID())
						EffectopediaObject.DEBUG_printContainedIDs(e);
					
				annotation = dataSource.annotation;
				userKey = dataSource.userKey;
				externalIDs = maxExternalID;
				internalLoad = false;
			}
			
		private void loadIndices(RevisionBasedDS dataSource, long maxExternalID)
			{
				extIDMAP = null;
				//System.out.println(TraceableClasses.getTraceableClassesDescriptions());
				//System.out.println();
				//for (EditHistoryAction eha : dataSource.editHistory.getUserActions())
				//	System.out.println("EditHistory:\t" + eha.DEBUG_getIDs());
				
				HashMap<Long, ArrayList<EditHistoryAction>> actionsMAP = dataSource.editHistory.getObjectHistoryMap();
				Iterator<Map.Entry<Long, ArrayList<EditHistoryAction>>> it = actionsMAP.entrySet().iterator();
				while (it.hasNext())
					processEntry(it.next(), dataSource, maxExternalID);
				
				liveIndices.reloadReferredObjectsFromID();
			}
			
		private void processEntry(Map.Entry<Long, ArrayList<EditHistoryAction>> entry, RevisionBasedDS dataSource, long maxExternalID)
			{
				ArrayList<EditHistoryAction> actions = entry.getValue();
				int size = (actions != null) ? actions.size() : 0;
				int index = size - 1;
				while (index >= 0)
					if ((actions.get(index).getStampId() + dataSource.defaultIDs - stampIDOffset) >= maxExternalID)
						index--;
					else
						break;
				if (index == 0)
					{
						EffectopediaObject eo = actions.get(0).getArchivedObject(dataSource);
						EffectopediaObjects<? extends EffectopediaObject> objects = liveIndices.get(eo.getClass());
						objects.put(eo.getID(), eo.clone(eo.getParent(), this));
					}
				else if (index > 0)
					{
						EffectopediaObject originalEO = actions.get(0).getArchivedObject(dataSource);
						EffectopediaObject historicEO = actions.get(index).getArchivedObject(dataSource);
						historicEO = historicEO.clone(historicEO.getParent(), this);
						originalEO.cloneIDs(historicEO);
						EffectopediaObjects<? extends EffectopediaObject> objects = liveIndices.get(originalEO.getClass());
						objects.put(historicEO.getID(), historicEO);
						index--;
						while (index>1)
							{
								EffectopediaObject archiveEO = actions.get(index).getArchivedObject(dataSource);
								objects = archiveIndices.get(originalEO.getClass());
								objects.put(archiveEO.getID(), archiveEO);
								index--;
							}
					}
			}
			
		public class ExternalIDFilter implements SearchableItemFilter
			{
				public ExternalIDFilter(long maxExternalID)
					{
						this.maxExternalID = maxExternalID;
					}
					
				public boolean match(SearchableItem sa)
					{
						long externalID = sa.getObject().getExternalID();
						return (externalID != 0) && (externalID < maxExternalID);
					}
					
				private long maxExternalID;
			}
			
		@Override
		public RevisionBasedDS get(long revision)
			{
				return baseDS.get(revision);
			}
			
		public boolean hasNext()
			{
				return revision < baseDS.getRevision();
			}
			
		public RevisionBasedDS getPrevous(boolean preserveLocation)
			{
				RevisionBasedDS ds = baseDS.get(revision - 1);
				if (preserveLocation)
					ds.setLocation(this);
				return ds;
			}
			
		public RevisionBasedDS getNext(boolean preserveLocation)
			{
				RevisionBasedDS ds = baseDS.get(revision + 1);
				if (preserveLocation)
					ds.setLocation(this);
				return ds;
			}
			
		public final RevisionBasedDS getBaseDS()
			{
				return baseDS;
			}
			
		public void setRevision(long revision)
			{
			}
			
		@Override
		public EffectopediaObject getLiveEffectopediaObjectByExternalID(long externalID)
			{
				if (extIDMAP == null)
					extIDMAP = liveIndices.generateExternalIDToIDMap();
				return extIDMAP.get(externalID);
			}
			
		@Override
		public EffectopediaObject getArchiveEffectopediaObjectByExternalID(long externalID)
			{
				return null;
			}
			
		public long getMaxRevision()
			{
				return baseDS.getMaxRevision();
			}
			
		private void DEBUG_SaveInFile()
			{
				Effectopedia.EFFECTOPEDIA.setData((DataSource) this);
				clearExternalIds();
				externalIDs = 1;
				Effectopedia.EFFECTOPEDIA.saveAsXMLFile("D:\\Java\\org.qsari.effectopedia\\test\\HistoricalDS.aop", true);
			}
			
		private long																														stampIDOffset	= 0;
		private HashMap<Long, EffectopediaObject>	extIDMAP;
		public final RevisionBasedDS														baseDS;
		private HashMap<Long, EffectopediaObject>	processed;
	}

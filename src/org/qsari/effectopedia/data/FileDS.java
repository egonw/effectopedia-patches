package org.qsari.effectopedia.data;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIO.DataPattern;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.system.UserKey;

public class FileDS extends RevisionBasedDS implements DataSourceItem
	{
		
		public FileDS()
			{
				super();
				processedIDs = new LinkedHashMap<Long, EffectopediaObject>();
				processedArchivedIDs = new LinkedHashMap<Long, EffectopediaObject>();
				revisionCache = new HashMap<Long, RevisionBasedDS>();
				
				this.fileName = null;
				this.sourceName = null;
			}
		
		protected void replaceExternalIDReferencesWithIDs()
			{
				
				/*
				 * Iterator<Map.Entry<Long, EffectopediaObject>> it =
				 * processedIDs.entrySet().iterator();
				 * 
				 * while (it.hasNext()) { Map.Entry<Long, EffectopediaObject> entry =
				 * it.next(); EffectopediaObject eo = entry.getValue();
				 * System.out.println("ExternalID\t" + entry.getKey() + "\tID=\t" +
				 * eo.getID() + "\tfor class" + eo.getClass() + "\tExternalID\t" +
				 * eo.getExternalID() + "\tDefaultID\t" + eo.getDefaultID() + "\t" +
				 * System.identityHashCode(eo)); }
				 * 
				 * it = liveIndices.getAllObjects().entrySet().iterator(); while
				 * (it.hasNext()) { Map.Entry<Long, EffectopediaObject> entry = it.next();
				 * EffectopediaObject eo = entry.getValue(); System.out.println("!!!ID\t" +
				 * entry.getKey() + "\tID=\t" + eo.getID() + "\tfor class" + eo.getClass() +
				 * "\tExternalID\t" + eo.getExternalID() + "\tDefaultID\t" +
				 * eo.getDefaultID() + "\t" + System.identityHashCode(eo)); }
				 * 
				 * it = archiveIndices.getAllObjects().entrySet().iterator(); while
				 * (it.hasNext()) { Map.Entry<Long, EffectopediaObject> entry = it.next();
				 * EffectopediaObject eo = entry.getValue(); System.out.println("!a!ID\t" +
				 * entry.getKey() + "\tID=\t" + eo.getID() + "\tfor class" + eo.getClass() +
				 * "\tExternalID\t" + eo.getExternalID() + "\tDefaultID\t" +
				 * eo.getDefaultID() + "\t" + System.identityHashCode(eo)); }
				 * 
				 * it = EffectopediaObject.getDefaultObjects().entrySet().iterator(); while
				 * (it.hasNext()) { Map.Entry<Long, EffectopediaObject> entry = it.next();
				 * EffectopediaObject eo = entry.getValue();
				 * System.out.println("!!!DefaultID\t" + entry.getKey() + "\tID=\t" +
				 * eo.getID() + "\tfor class" + eo.getClass() + "\tExternalID\t" +
				 * eo.getExternalID() + "\tDefaultID\t" + eo.getDefaultID() + "\t" +
				 * System.identityHashCode(eo)); }
				 */
				liveIndices.getIds_ref_list().replaceExternalIDReferencesWithIDs(processedIDs);
				liveIndices.getId_ref_list().replaceExternalIDReferencesWithIDs(processedIDs);
				
				archiveIndices.getIds_ref_list().replaceExternalIDReferencesWithIDs(processedArchivedIDs);
				archiveIndices.getId_ref_list().replaceExternalIDReferencesWithIDs(processedArchivedIDs);
				
				//System.out.println("replaceExternalIDReferencesWithIDs");
				/*
				 * Iterator<Map.Entry<Long, EffectopediaObject>> it =
				 * processedIDs.entrySet().iterator(); while (it.hasNext()) {
				 * Map.Entry<Long, EffectopediaObject> entry = it.next(); EffectopediaObject
				 * eo = entry.getValue(); if (eo instanceof PathwayElement) {
				 * 
				 * PathwayElement pe = (PathwayElement) eo;
				 * 
				 * System.out.print(pe.getClass() + "ID=\t" + pe.getID() + "\tExternalID=\t"
				 * + pe.getExternalID() + "\tDefaultID=\t" + pe.getDefaultID()); if (pe
				 * instanceof Link_ChemStructToMIE) System.out.print("\tsubstance=\t" +
				 * ((Link_ChemStructToMIE) pe).getStructure().getReferenceID() +
				 * "\teffect=\t" + ((Link_ChemStructToMIE)
				 * pe).getEffect().getReferenceID()); if (pe instanceof Link_EffectToEffect)
				 * System.out.print("\tfrom effect=\t" + ((Link_EffectToEffect)
				 * pe).getFromEffect().getReferenceID() + "\tto effect=\t" +
				 * ((Link_EffectToEffect) pe).getToEffect().getReferenceID());
				 * System.out.print("\tincomming=\t" +
				 * Arrays.toString(pe.incommingAssociations()));
				 * System.out.print("\toutgoing=\t" +
				 * Arrays.toString(pe.outgoingAssociations()));
				 * System.out.println("\tpathway=\t" +
				 * Arrays.toString(pe.getPathwayIDs().getCachedIDs()));
				 * 
				 * } }
				 */
			}
		
		public synchronized boolean loadAllFromRoot(BaseIOElement root, BaseIO baseIO)
			{
				loadEffectopediaHeader(root, baseIO);
				shallowMode = false;
				internalLoad = true;
				createLive = true;
				loadLivePathwayElements(root, baseIO);
				loadLiveIndices(root, baseIO);
				createLive = false;
				loadArchiveIndices(root, baseIO);
				archiveIndices.updateDataSource(this, false);
				createLive = true;
				/*
				 * System.out.println(archiveIndices.getIds_ref_list().size());
				 * Iterator<Map.Entry<Long, ReferenceIDs<EffectopediaObject>>> it =
				 * archiveIndices.getIds_ref_list().entrySet().iterator(); while
				 * (it.hasNext()) { Map.Entry<Long, ReferenceIDs<EffectopediaObject>> entry
				 * = it.next(); ReferenceIDs<EffectopediaObject> eo = entry.getValue();
				 * System.out.println("ExternalID\t" + entry.getKey() + "\tID=\t" +
				 * eo.getID() + "\tfor class" + eo.getClass() + "\tExternalID\t" +
				 * eo.getExternalID() + "\tDefaultID\t" + eo.getDefaultID() + "\t" +
				 * System.identityHashCode(eo)); }
				 */
				shallowMode = true;
				
				replaceExternalIDReferencesWithIDs();
				EffectopediaObject.updateDefaultObjectExternalIDs(processedArchivedIDs);
				
				// DEBUG_PrintProcessedIDs();
				// EffectopediaObject.DEBUG_printDefaultObjects();
				
				loadEditHistory(root, baseIO);
				
				// BaseIOElement editLogElement = e.getChild("edit_log");
				// editLog.load(editLogElement);
				revision = editHistory.getRevision();
				updateDefaultObjectInLiveIndices();
				liveIndices.replaceDefaultObjectsWtihClones();
				liveIndices.updateDataSource(this, false);
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
		
		protected void loadEffectopediaHeader(BaseIOElement root, BaseIO baseIO)
			{
				externalIDs = Long.parseLong(root.getAttributeValue("max_id"));
				BaseIOAttribute dataSourceIDAttribute = root.getAttribute("id");
				defaultIDs = Long.parseLong(root.getAttributeValue("default_max_id"));
				
				dataSourceID = (dataSourceIDAttribute != null) ? Long.parseLong(dataSourceIDAttribute.getValue()) : 0;
				
				BaseIOElement fileFormatElement = root.getChild("format");
				if (fileFormatElement != null)
					{
						String ver = fileFormatElement.getAttributeValue("version");
						fileVersionNumner = Double.valueOf(ver);
						handleFormatChanges();
						if (fileVersionNumner > VERSION_NUMBER)
							UserInterface
									.showWarning("The data source you are trying to load was generated from newer version of Effectopedia.\nSome elements might not load correctly.  Please consider downloading\nthe newest version.");
						String pat = fileFormatElement.getAttributeValue("pattern");
						if (pat != null)
							fileDataPattern = DataPattern.valueOf(pat.toUpperCase());
					}
				else
					UserInterface.showWarning("The file you are trying to load does not specify format version!\n");
				
				BaseIOElement annotationElement = root.getChild("annotation");
				if (annotationElement != null)
					annotation = annotationElement.getValue();
				
				BaseIOElement userKeyElement = root.getChild("user_key");
				if (userKeyElement != null)
					{
						long userID = Long.parseLong(userKeyElement.getAttributeValue("user_id"));
						fileUserKey = new UserKey(userID);
						validFileUserKey = fileUserKey.isValidKey(userKeyElement.getValue(), userID);
					}
				
				BaseIOAttribute provisID = root.getAttribute("lastNonProvisionalID");
				if (provisID!=null)
					lastNonProvisionalID = provisID.getLongValue();
					
				loadSourceIDs(root, baseIO);
			}
		
		protected void loadLivePathwayElements(BaseIOElement root, BaseIO baseIO)
			{
				processedIDs.clear();
				liveIndices.getAll(processedIDs);
				EffectopediaObject.clearDefaultObectsExternalIds();
				livePathwayElements.load(root, baseIO);
			}
		
		protected void loadLiveIndices(BaseIOElement root, BaseIO baseIO)
			{
				BaseIOElement liveComponentsElement = root.getChild("live_components");
				liveIndices.load(liveComponentsElement, baseIO);
			}
		
		protected void loadArchiveIndices(BaseIOElement root, BaseIO baseIO)
			{
				processedArchivedIDs.clear();
				archiveIndices.getAll(processedArchivedIDs);
				processedArchivedIDs.putAll(processedIDs);
				BaseIOElement archivedComponentsElement = root.getChild("archived_components");
				archiveIndices.load(archivedComponentsElement, baseIO);
			}
		
		protected void loadEditHistory(BaseIOElement root, BaseIO baseIO)
			{
				BaseIOElement editHistoryElement = root.getChild("edit_history");
				editHistory.load(editHistoryElement, baseIO);
			}
		
		public void handleFormatChanges()
			{
				if (fileVersionNumner >= 0.945)
					externalIDs++;
			}
		
		public URL getURL(String url)
			{
				try
					{
						URL newURL = new URL(url);
						remoteFile = true;
						sourcePrefix = "";
						return newURL;
					}
				catch (MalformedURLException e)
					{
						remoteFile = false;
						sourcePrefix = "local file: ";
						return null;
					}
				
			}
		
		public void saveAllToRoot(BaseIOElement root, BaseIO io)
			{
				archiveIndices.replaceArchivedObjectsWtihClones();
				storeEffectopediaHeader(root, io);
				
				storeLivePathwayElements(root, io);
				storeLiveIndices(root, io);
				storeArchiveIndices(root, io);
				storeEditHistory(root, io);
				
				root.setAttribute("max_id", Long.toString(externalIDs - 1));
				root.setAttribute("default_max_id", Long.toString(EffectopediaObject.getDefaultIDs() + 1));
			}
		
		protected void storeEffectopediaHeader(BaseIOElement root, BaseIO io)
			{
				setBrowsing(false);
				
				BaseIOElement fileFormatElement = io.newElement("format");
				fileFormatElement.setAttribute("version", VERSION);
				fileFormatElement.setAttribute("pattern", io.getDataPattern().toString());
				fileFormatElement.setValue("Effectopedia Adverse Outcome Pathways Format");
				root.addChild(fileFormatElement);
				
				BaseIOElement annotationElement = io.newElement("annotation");
				annotationElement.setValue(annotation);
				root.addChild(annotationElement);
				
				BaseIOElement userKeyElement = io.newElement("user_key");
				userKeyElement.setValue(userKey.getKey());
				userKeyElement.setAttribute("user_id", Long.toString(Effectopedia.EFFECTOPEDIA.getCurrentUserID()));
				root.addChild(userKeyElement);
				
				storeSourceIDs(root, io);
				
				liveIndices.updateExternalIDs();
				// liveIndices.DEBUG_printIndices();
				
				if (provisional)
					root.setAttribute("lastNonProvisionalID",lastNonProvisionalID);
				
				BaseIOElement locationElement = io.newElement("location");
				if ((internalLocation) && (locationObject != null))
					location = getExternalIDbyID(locationObject.getClass(), location);
				locationElement.setValue(Long.toString(location));
				root.addChild(locationElement);
			}
		
		@Override
		public void addDefault(DataSource dataSource)
			{
				super.addDefault(dataSource);
				liveIndices.getAll(processedIDs);
				archiveIndices.getAll(processedArchivedIDs);
			}
		
		@Override
		public void addAll(DataSource dataSource)
			{
				super.addAll(dataSource);
				liveIndices.getAll(processedIDs);
				archiveIndices.getAll(processedArchivedIDs);
			}
		
		protected void storeLivePathwayElements(BaseIOElement root, BaseIO io)
			{
				this.shallowMode = false;
				processedIDs.clear();
				livePathwayElements.store(processedIDs, root, io);
			}
		
		protected void storeLiveIndices(BaseIOElement root, BaseIO io)
			{
				root.addChild(liveIndices.store(processedIDs, io.newElement("live_components"), io));
			}
		
		protected void storeArchiveIndices(BaseIOElement root, BaseIO io)
			{
				this.shallowMode = true;
				processedArchivedIDs.clear();
				root.addChild(archiveIndices.store(processedArchivedIDs, io.newElement("archived_components"), io));
			}
		
		protected void storeEditHistory(BaseIOElement root, BaseIO io)
			{
				root.addChild(editHistory.store(io.newElement("edit_history"), io));
			}
		
		public void add(EffectopediaObject eo)
			{
				EffectopediaObjects<? extends EffectopediaObject> objects = liveIndices.get(eo.getClass());
				objects.put(eo.getID(), eo);
				if (internalLoad)
					processedIDs.put(eo.getExternalID(), (EffectopediaObject) eo);
			}
		
		public void add(Class<? extends EffectopediaObject> objectClass, EffectopediaObject eo)
			{
				EffectopediaObjects<? extends EffectopediaObject> objects = liveIndices.get(objectClass);
				objects.put(eo.getID(), eo);
				if (internalLoad)
					{
						processedIDs.put(eo.getExternalID(), (EffectopediaObject) eo);
						if (eo instanceof EffectopediaObject)
							((EffectopediaObject) eo).getContainedExternalIDs(processedIDs);
					}
			}
		
		public void addToArchive(Class<? extends EffectopediaObject> objectClass, EffectopediaObject eo)
			{
				if ((internalLoad) && (processedIDs.get(eo.getExternalID()) != null))
					{
						//System.out.println("not added to archives " + objectClass + " with externalID\t" + eo.getExternalID() + "\t->\t" + eo.getID() + "\t" + processedArchivedIDs.size());
						return; // The object is already loaded as live object
					}
				EffectopediaObjects<? extends EffectopediaObject> objects = archiveIndices.get(objectClass);
				objects.put(eo.getID(), eo);
				//System.out.println("Added to archives " + objectClass + " with externalID\t" + eo.getExternalID() + "\t->\t" + eo.getID() + "\t" + processedArchivedIDs.size());
				if (internalLoad)
					{
						processedArchivedIDs.put(eo.getExternalID(), (EffectopediaObject) eo);
						// if (eo instanceof EffectopediaObject)
						// ((EffectopediaObject)
						// eo).getContainedExternalIDs(processedArchivedIDs);
					}
			}
		
		public EffectopediaObject remove(Class<? extends EffectopediaObject> objectClass, long id)
			{
				EffectopediaObjects<?> objects = liveIndices.get(objectClass);
				if (objects != null)
					{
						EffectopediaObject o = (EffectopediaObject) objects.get(id);
						if (o != null)
							{
								objects.remove(id);
								return o;
							}
						else
							return null;
					}
				else
					return null;
			}
		
		public EffectopediaObject getLiveEffectopediaObjectByExternalID(long externalID)
			{
				return processedIDs.get(externalID);
			}
		
		public EffectopediaObject getArchiveEffectopediaObjectByExternalID(long externalID)
			{
				return processedArchivedIDs.get(externalID);
			}
		
		public long getArchiveIDbyExternalID(long classID, long externalID)
			{
				EffectopediaObject eo = processedIDs.get(externalID);
				if (eo == null)
					eo = processedArchivedIDs.get(externalID);
				return eo != null ? eo.getID() : 0L;
			}
		
		public EffectopediaObject getEffectopediaObjectByExternalID(long externalID)
			{
				return processedIDs.get(externalID);
			}
		
		public long getIDbyExternalID(long ClassID, long externalID)
			{
				EffectopediaObject eo;
				eo = processedIDs.get(externalID);
				if (eo == null)
					eo = processedArchivedIDs.get(externalID);
				return (eo != null) ? eo.getID() : 0;
			}
		
		public <E extends EffectopediaObject> E load(Class<?> cl, E effectopediaObejct, BaseIOElement element, BaseIO io)
			{
				if (element == null)
					return effectopediaObejct;
				BaseIOAttribute a = element.getAttribute("id");
				long externalID = Long.parseLong(a.getValue());
				long defaultID = EffectopediaObject.getDefaultID(element);
				EffectopediaObject eo;
				// TODO Negative ID Revolution
				// if (defaultID > 0)
				// {
				// defaultID = -defaultID;
				// externalID = -externalID;
				// }
				eo = Effectopedia.EFFECTOPEDIA.getData().getEffectopediaObjectByExternalID(externalID);
				if ((cl != null) && (eo != null) && (!cl.isAssignableFrom(eo.getClass())))
					{
						System.err.println("Error loading ExtID = \t" + externalID + "\t defaultID = \t" + eo.getDefaultID());
						UserInterface.showError("The file you are trying to load is corrupted!\nPlease sent it to the Effectopedia support team for recovery!");
						eo = null;
					}
				else
					//System.out.println("Loading ExtID = \t" + externalID + "\t eo = \t" + eo);
				// Attribute b = element.getAttribute("defaultID", namespace);
				// System.out.print("\nprocessing\t" + ((b!=null)?b.getValue():"n/a") +
				// "\texternalID=\t" + a.getValue() + "\tand eo=\t" +
				// eo+((eo!=null)?"\t found in processedIds":""));
				if (eo == null)
					{
						try
							{
								if (defaultID != EffectopediaObject.NON_DEFAULT)
									{
										if ((effectopediaObejct != null) && (effectopediaObejct.getDefaultID() == defaultID))
											eo = effectopediaObejct;
										else
											{
												eo = EffectopediaObject.getEffectopediaObjectByDefaultID(defaultID);
												// eo = eo.clone();
											}
										eo.updateExternalID(element);
										// System.out.print("\tassigned to existing default object");
									}
								else
									{
										// System.out.print("\tnew object created");
										// Negative ID Revolution
										if ((effectopediaObejct != null) && (effectopediaObejct.getExternalID() == externalID))
											eo = effectopediaObejct;
										else
											eo = (EffectopediaObject) cl.newInstance();
										eo.load(element, io);
									}
								if (Effectopedia.EFFECTOPEDIA.getData().isCreateLive())
									Effectopedia.EFFECTOPEDIA.getData().add(eo.getClass(), eo);
								else if (Effectopedia.EFFECTOPEDIA.getData().getLiveEffectopediaObjectByExternalID(externalID) == null)
									Effectopedia.EFFECTOPEDIA.getData().addToArchive(eo.getClass(), eo);
								
							}
						catch (InstantiationException e1)
							{
								e1.printStackTrace();
								return null;
							}
						catch (IllegalAccessException e1)
							{
								e1.printStackTrace();
								return null;
							}
					}
				return (E) eo;
			}
		
		public boolean isRemoteFile()
			{
				return remoteFile;
			}
		
		protected void DEBUG_PrintIndices()
			{
				HashMap<Long, EffectopediaObject> idMap = liveIndices.generateExternalIDToIDMap();
				System.out.println("live Indices");
				Iterator<Map.Entry<Long, EffectopediaObject>> it = idMap.entrySet().iterator();
				while (it.hasNext())
					{
						Map.Entry<Long, EffectopediaObject> entry = it.next();
						System.out.println(entry.getValue() + "\t->\t" + entry.getKey());
					}
				
				idMap = archiveIndices.generateExternalIDToIDMap();
				System.out.println("archive Indices");
				it = idMap.entrySet().iterator();
				while (it.hasNext())
					{
						Map.Entry<Long, EffectopediaObject> entry = it.next();
						System.out.println(entry.getValue() + "\t->\t" + entry.getKey());
					}
			}
		
		private void DEBUG_SaveStringAsFile(String text, String fileName)
			{
				BufferedWriter writer = null;
				try
					{
						writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
						writer.write(text);
						
					}
				catch (IOException e)
					{
					}
				finally
					{
						try
							{
								if (writer != null)
									writer.close();
							}
						catch (IOException e)
							{
							}
					}
			}
		
		public void storeSourceIDs(BaseIOElement element, BaseIO io)
			{
				int count = containedRevOfDataSourceIDs.size();
				if (count != 0)
					{
						BaseIOElement e = io.newElement("contained_revisions_of_source_ids");
						e.setAttribute("count", Integer.toString(count));
						StringBuilder idsArray = new StringBuilder();
						for (Map.Entry<Long, Long> revSourceID : containedRevOfDataSourceIDs.entrySet())
							{
								idsArray.append(revSourceID.getKey());
								idsArray.append(':');
								idsArray.append(revSourceID.getValue());
								idsArray.append(' ');
							}
						e.setValue(idsArray.toString());
						element.addChild(e);
					}
			}
		
		public void loadSourceIDs(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						BaseIOElement e = element.getChild("contained_revisions_of_source_ids");
						if (e != null)
							{
								int count = Integer.parseInt(e.getAttributeValue("count"));
								if (count != 0)
									{
										containedRevOfDataSourceIDs.clear();
										StringTokenizer idsArray = new StringTokenizer(e.getValue(), " ");
										while (idsArray.hasMoreTokens())
											{
												String[] token = idsArray.nextToken().trim().split(":");
												if (token.length == 2)
													containedRevOfDataSourceIDs.put(Long.parseLong(token[0]), Long.parseLong(token[1]));
											}
									}
							}
					}
			}
		
		protected void DEBUG_PrintProcessedIDs()
			{
				Iterator<Map.Entry<Long, EffectopediaObject>> it = processedIDs.entrySet().iterator();
				while (it.hasNext())
					{
						EffectopediaObject eo = it.next().getValue();
						System.out.println("FileDS.ProcessedIDs" + eo.DEBUG_getIDs());
					}
				it = processedArchivedIDs.entrySet().iterator();
				while (it.hasNext())
					{
						EffectopediaObject eo = it.next().getValue();
						System.out.println("FileDS.processedArchivedIDs" + eo.DEBUG_getIDs());
					}
			}
		
		public double getFormatVersion()
			{
				return VERSION_NUMBER;
			}
		
		public double getInputVersion()
			{
				return fileVersionNumner;
			}
		
		public static double																														VERSION_NUMBER				= 1.03D;
		public static String																														VERSION											= String.valueOf(VERSION_NUMBER);
		protected boolean																																	remoteFile;
		protected String																																		fileName;
		protected LinkedHashMap<Long, EffectopediaObject>	processedIDs;
		protected LinkedHashMap<Long, EffectopediaObject>	processedArchivedIDs;
		protected UserKey																																	fileUserKey;
		protected long																																				fileUserID;
		protected boolean																																	validFileUserKey;
		protected double																																		fileVersionNumner	= VERSION_NUMBER;
		protected DataPattern																													fileDataPattern			= DataPattern.RUSSIAN_DOLL;
	}

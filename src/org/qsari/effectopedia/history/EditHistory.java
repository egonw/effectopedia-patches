package org.qsari.effectopedia.history;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.ObjectIdentity;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.data.DataSource;

public class EditHistory implements Importable, Exportable
	{
		public EditHistory(DataSource dataSource)
			{
				super();
				this.dataSource = dataSource;
				userActions = new ArrayList<EditHistoryAction>();
				revisions = new ArrayList<Integer>();
			}
		
		public void add(ObjectIdentity ehi, long stampID)
			{
				Effectopedia.EFFECTOPEDIA.getStamps().get((int) stampID);
				// System.out.print(stamp.getFormattedDate()+" "+ActionTypes.REGISTERED.get((int)
				// stamp.getActionId()).getDescription());
				// if (ehi instanceof EditHistoryItem_Object)
				// System.out.println(" objectid="+ehi.getObjectId()+" "+((EditHistoryItem_Object)ehi).getObjectArchiveId()+" "+ehi.getObjectClass().getSimpleName());
				EditHistoryAction eha = new EditHistoryAction(ehi, stampID);
				userActions.add(eha);
				if (objectHistoryMAP != null)
					updateHistoryMap(eha);
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						BaseIOElement e = element.getChild("user_actions");
						loadBaseRevision(e, io);
						e = element.getChild("revisions");
						if (e != null)
							{
								int count = Integer.parseInt(e.getAttributeValue("count"));
								BaseIOAttribute def_usr_act_cnt = e.getAttribute("default_actions_count");
								int dua_offset = (int) ((def_usr_act_cnt != null) ? def_usr_act_cnt.getLongValue() + EffectopediaObject.getDefaultIDs() : 0);
								if (count != 0)
									{
										StringTokenizer st = new StringTokenizer(e.getValue().trim());
										while (st.hasMoreTokens())
											revisions.add(Integer.valueOf(st.nextToken()) - dua_offset);
									}
							}
					}
			}
		
		public void loadBaseRevision(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						int count = Integer.parseInt(element.getAttributeValue("count"));
						List<BaseIOElement> children = element.getChildren();
						if ((count != 0) && (children != null) && (children.size() == count))
							{
								Iterator<BaseIOElement> iterator = children.iterator();
								userActions.ensureCapacity(userActions.size() + count);
								int defaultActions = userActions.size() - 1;
								int cnt = 0;
								while (iterator.hasNext())
									{
										BaseIOElement child = iterator.next();
										EditHistoryAction eha;
										String name = child.getName().toLowerCase();
										if (cnt <= defaultActions)
											{
												if (name.compareTo("simple_action") == 0)
													{
														BaseIOElement simpleAction = child.getChild("object_id");
														EffectopediaObject eo = Effectopedia.EFFECTOPEDIA.getData().getEffectopediaObjectByExternalID(Long.parseLong(simpleAction.getValue().trim()));
														if ((eo != null) && (eo.isDefaultID()))
															{
																userActions.get(cnt).setExternalID(cnt);
																cnt++;
																continue;
															}
														else
															eha = new EditHistoryAction();
													}
												else
													continue;
											}
										else
											{
												if (name.compareTo("simple_action") == 0)
													eha = new EditHistoryAction();
												else
													continue;
											}
										cnt++;
										eha.load(child, io);
										userActions.add(eha);
									}
							}
					}
			}
		
		public void loadRevision(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						int count = Integer.parseInt(element.getAttributeValue("count"));
						List<BaseIOElement> children = element.getChildren();
						if ((count != 0) && (children != null) && (children.size() == count))
							{
								Iterator<BaseIOElement> iterator = children.iterator();
								userActions.ensureCapacity(userActions.size() + count);
								while (iterator.hasNext())
									{
										BaseIOElement child = iterator.next();
										EditHistoryAction eha;
										String name = child.getName().toLowerCase();
										if (name.compareTo("simple_action") == 0)
											eha = new EditHistoryAction();
										else
											continue;
										eha.load(child, io);
										userActions.add(eha);
									}
							}
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				startNewRevision();
				actionsCnt = 0;
				int count = userActions.size();
				BaseIOElement e = io.newElement("user_actions");
				e.setAttribute("count", Integer.toString(count));
				if (count != 0)
					{
						for (int i = 0; i < count; i++)
						
							{
								EditHistoryAction eha = userActions.get(i);
								BaseIOElement ua;
								ua = io.newElement("simple_action");
								eha.store(ua, io);
								e.addChild(ua);
							}
					}
				element.addChild(e);
				
				e = io.newElement("revisions");
				e.setAttribute("count", Integer.toString(revisions.size()));
				e.setAttribute("default_actions_count", Long.toString(-EffectopediaObject.getDefaultIDs()));
				StringBuilder rev = new StringBuilder();
				rev.append(' ');
				for (Integer i : revisions)
					{
						rev.append(i);
						rev.append(' ');
					}
				e.setValue(rev.toString());
				element.addChild(e);
				return element;
			}
		
		public void storeRevision(long revision, BaseIOElement element, BaseIO io)
			{
				int fromID = (int) (getFirstIDinRevision(revision) - EffectopediaObject.getDefaultIDs() - 1);
				int toID = (int) (getLastIDinRevision(revision) - EffectopediaObject.getDefaultIDs() - 1);
				for (int i = fromID; i < toID; i++)
					{
						EditHistoryAction eha = userActions.get(i);
						BaseIOElement ua;
						ua = io.newElement("simple_action");
						eha.store(ua, io);
						element.addChild(ua);
					}
				element.setAttribute("count", Integer.toString(toID - fromID));
			}
		
		public long getFirstIDinRevision(long revision)
			{
				return (revisions.size() > 0) && (revision >= 1) ? revisions.get((int) revision - 1) + EffectopediaObject.getDefaultIDs() + 1 : EffectopediaObject.getDefaultIDs() + 1;
			}
		
		public long getLastIDinRevision(long revision)
			{
				return revisions.size() > 0 ? revisions.get((int) revision) + EffectopediaObject.getDefaultIDs() + 1 : -1;
			}
		
		public void addAll(EditHistory editHistory)
			{
				if (revisions.size() > 0)
					{
						int offset = userActions.size();
						ArrayList<Integer> rev = new ArrayList<Integer>(editHistory.revisions.size());
						for (int i = rev.size(); i > 0; i--)
							rev.add(revisions.get(i) + offset);
					}
				else
					{
						revisions.clear();
						revisions.addAll(editHistory.revisions);
					}
				userActions.addAll(editHistory.getUserActions());
				objectHistoryMAP = null;
			}
		
		public void addDefault(EditHistory editHistory)
			{
				for (EditHistoryAction eha : editHistory.getUserActions())
					if (eha.isForDefaultObject())
						userActions.add(eha);
				objectHistoryMAP = null;
			}
		
		public void addAll(EditHistory editHistory, long revision)
			{
				revisions.clear();
				for (int i = 0; i <= revision; i++)
					revisions.add(editHistory.revisions.get(i));
				int maxExternalID = revisions.get((int) revision);
				userActions.clear();
				userActions.addAll(editHistory.getUserActions().subList(0, maxExternalID));
				objectHistoryMAP = null;
			}
		
		public Iterator<EditHistoryAction> getUserActionsIterator()
			{
				return userActions.iterator();
			}
		
		public int getUserActionsCount()
			{
				return userActions.size();
			}
		
		public EditHistoryAction getUserAction(int index)
			{
				try
					{
						return userActions.get(index);
					}
				catch (Exception e)
					{
						return null;
					}
			}
		
		public long getStampIDOffset()
			{
				EditHistoryAction eha = userActions.get(revisions.get(revisions.size() - 1) - 1);
				// Negative ID Revolution
				return eha.getStampId() - eha.getExternalID();
			}
		
		public HashMap<Long, ArrayList<EditHistoryAction>> getObjectHistoryMap()
			{
				if (objectHistoryMAP != null)
					return objectHistoryMAP;
				else
					return generateObjectHistoryMapAfter(0);
			}
		
		public HashMap<Long, ArrayList<EditHistoryAction>> getPartialObjectHistoryMap(long revision, boolean prior)
			{
				if (revision == 0)
					return getObjectHistoryMap();
				else
					{
						int offset = revision < revisions.size() ? revisions.get((int) revision) : 0;
						HashMap<Long, ArrayList<EditHistoryAction>> exisitngMAP = objectHistoryMAP;
						if (prior)
							generateObjectHistoryMapBefore(offset);
						else
							generateObjectHistoryMapAfter(offset);
						HashMap<Long, ArrayList<EditHistoryAction>> newMAP = objectHistoryMAP;
						objectHistoryMAP = exisitngMAP;
						return newMAP;
					}
			}
		
		public ArrayList<EditHistoryAction> getObjectHistory(long ID)
			{
				return getObjectHistoryMap().get(ID);
			}
		
		public ArrayList<EditHistoryAction> getContainedObjectHistory(EffectopediaObject eo, boolean includeDefaultObjects)
			{
				ArrayList<EditHistoryAction> eha = new ArrayList<EditHistoryAction>();
				LinkedHashMap<Long, EffectopediaObject> containedIDs = new LinkedHashMap<Long, EffectopediaObject>();
				eo.getContainedIDs(containedIDs, true);
				if (!includeDefaultObjects)
					{
						Iterator<Map.Entry<Long, EffectopediaObject>> it = containedIDs.entrySet().iterator();
						while (it.hasNext())
							if (it.next().getValue().isDefaultID())
								it.remove();
					}
				Iterator<Long> it = containedIDs.keySet().iterator();
				objectHistoryMAP = getObjectHistoryMap();
				while (it.hasNext())
					{
						long hID = it.next();
						ArrayList<EditHistoryAction> actions = objectHistoryMAP.get(hID);
						if (actions != null)
							eha.addAll(actions);
					}
				return eha;
			}
		
		private void updateHistoryMap(EditHistoryAction editHistoryAction)
			{
				if (editHistoryAction.object instanceof EditHistoryItem_Object)
					{
						EditHistoryItem_Object ehio = (EditHistoryItem_Object) editHistoryAction.object;
						ArrayList<EditHistoryAction> actions = objectHistoryMAP.get(ehio.getObjectId());
						if (actions == null)
							{
								actions = new ArrayList<EditHistoryAction>();
								objectHistoryMAP.put(ehio.getObjectId(), actions);
							}
						actions.add(editHistoryAction);
					}
			}
		
		private HashMap<Long, ArrayList<EditHistoryAction>> generateObjectHistoryMapAfter(int offset)
			{
				objectHistoryMAP = new HashMap<Long, ArrayList<EditHistoryAction>>();
				for (int i = offset; i < userActions.size(); i++)
					updateHistoryMap(userActions.get(i));
				return objectHistoryMAP;
			}
		
		private HashMap<Long, ArrayList<EditHistoryAction>> generateObjectHistoryMapBefore(int index)
			{
				objectHistoryMAP = new HashMap<Long, ArrayList<EditHistoryAction>>();
				for (int i = 0; i < index; i++)
					updateHistoryMap(userActions.get(i));
				return objectHistoryMAP;
			}
		
		public HashMap<Long, ArrayList<EffectopediaObject>> generateObjectChangesMap(DataSource dataSource)
			{
				HashMap<Long, ArrayList<EffectopediaObject>> changeMap = new HashMap<Long, ArrayList<EffectopediaObject>>();
				if (objectHistoryMAP == null)
					generateObjectHistoryMapAfter(0);
				Iterator<Map.Entry<Long, ArrayList<EditHistoryAction>>> it = objectHistoryMAP.entrySet().iterator();
				while (it.hasNext())
					{
						Map.Entry<Long, ArrayList<EditHistoryAction>> entry = it.next();
						ArrayList<EffectopediaObject> objects = new ArrayList<EffectopediaObject>();
						for (EditHistoryAction eha : entry.getValue())
							{
								EffectopediaObject eo = eha.getArchivedObject(dataSource);
								if (eo != null)
									objects.add(eo);
							}
						changeMap.put(entry.getKey(), objects);
					}
				return changeMap;
			}
		
		public static ArrayList<EffectopediaObject> GetObjectsFromActions(ArrayList<EditHistoryAction> actions, DataSource dataSource)
			{
				ArrayList<EffectopediaObject> objects = new ArrayList<EffectopediaObject>();
				for (EditHistoryAction eha : actions)
					objects.add(eha.getArchivedObject(dataSource));
				return objects;
			}
		
		public ArrayList<EditHistoryAction> getUserActions()
			{
				return userActions;
			}
		
		public void startNewRevision()
			{
				if ((revisions != null) && (revisions.size() > 0) && (revisions.get(revisions.size() - 1) == userActions.size()))
					return;
				revisions.add(userActions.size());
				modified.clear();
			}
		
		public int getRevision()
			{
				if (revisions.size() == 0)
					return 0;
				else
					return revisions.size() - 1;
			}
		
		public long getLastExternalID()
			{
				if (revisions.size() == 0)
					return 0;
				else
					return revisions.get(revisions.size() - 1) + EffectopediaObject.getDefaultIDs() + 1;
			}
		
		public ArrayList<Integer> getRevisions()
			{
				return revisions;
			}
		
		public int getRevisionsCount()
			{
				return revisions.size();
			}
		
		@SuppressWarnings("unchecked")
		public static <T extends EffectopediaObject> T replaceArchivedObjectsWtihClones(T object, EffectopediaObject parent, DataSource dataSource)
			{
				if (dataSource == null)
					{
						//System.out.println("Warning! DataSource is null for " + object.DEBUG_getIDs());
						return object;
					}
				EditHistory history = dataSource.getEditHistory();
				if (history.modified.contains(parent))
					return object;
				if (history.modified.contains(dataSource.get(object.getClass(), object.getID())))
					{
						ArrayList<EditHistoryAction> actions = history.getContainedObjectHistory(object, false);
						if (actions.size() > 0)
							{
								EditHistoryAction eha = actions.get(actions.size() - 1);
								return (T) eha.getArchivedObject(dataSource);
							}
					}
				return object;
			}

		public void updateModifiedAndNewSinceLastRevision()
			{
				updateModifiedSinceRevision(revisions.size() == 0 ? 0 : revisions.size() - 1);
			}
		
		public void updateModifiedSinceRevision(int revision)
			{
				setOfModified.clear();
				setOfNew.clear();
				int offset = revision < revisions.size() ? revisions.get((int) revision) : 0;
				int count = userActions.size();
				for (int act = offset; act < count; act++)
					{
						EditHistoryAction eha = userActions.get(act);
						if (eha.object instanceof EditHistoryItem_Object)
							{
								EditHistoryItem_Object ehio = (EditHistoryItem_Object) eha.object;
								long objID = ehio.getObjectId();
								long archObjID = ehio.getObjectArchiveId();
								if (objID == archObjID)
									setOfNew.add(dataSource.get(ehio.getObjectClass(), objID));
								else
									{
										setOfModified.add(dataSource.get(ehio.getObjectClass(), objID));
										setOfNew.add(dataSource.getFromArchive(ehio.getObjectClass(), archObjID));
									}
							}
					}
			}
		
		public boolean isUpdated(EffectopediaObject eo)
			{
				return setOfModified.contains(eo) || setOfNew.contains(eo);
			}
		
		public boolean isModified(EffectopediaObject eo)
			{
				return setOfModified.contains(eo);
			}
		
		public boolean isNew(EffectopediaObject eo)
			{
				return setOfNew.contains(eo);
			}
		
		public final DataSource																															dataSource;
		public final HashSet<EffectopediaObject>														modified						= new HashSet<>();
		protected final HashSet<EffectopediaObject>											setOfModified	= new HashSet<>();
		protected final HashSet<EffectopediaObject>											setOfNew						= new HashSet<>();
		public final ArrayList<Integer>																							revisions;
		protected ArrayList<EditHistoryAction>																userActions;
		protected HashMap<Long, ArrayList<EditHistoryAction>>	objectHistoryMAP;
		public static long																																				actionsCnt				= 0;
	}

package org.qsari.effectopedia.base.ids;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EventObject;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.BaseIOValue;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.DataSourceMerge;
import org.qsari.effectopedia.data.interfaces.ReferableIDs;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.system.ActionTypes;

public class ReferenceIDs<E extends EffectopediaObject> extends EffectopediaObject implements ReferableIDs<E>, Importable, Exportable, Cloneable, Traceable
	{
		
		public ReferenceIDs()
			{
				super();
				this.objectClass = null;
				items = new ArrayList<Long>();
				objects = new ArrayList<E>();
			}
			
		public ReferenceIDs(EffectopediaObject parent, DataSource dataSource, Class<E> objectClass)
			{
				super(parent, dataSource);
				this.objectClass = objectClass;
				items = new ArrayList<Long>();
				objects = new ArrayList<E>();
			}
			
		public E addNew()
			{
				E e = (E) DefaultEffectopediaObjects.getDefaultNew(objectClass);
				if (e != null)
					{
						beforeUpdate(true, ActionTypes.LIST_ADD);
						e = (E) e.clone(parent, dataSource);
						items.add(e.getID());
						objects.add(e);
						cachedObjects = null;
					}
				return e;
			}
			
		public E getNew()
			{
				E e = (E) DefaultEffectopediaObjects.getDefaultNew(objectClass);
				if (e != null)
					{
						beforeUpdate(true, ActionTypes.LIST_ADD);
						e = (E) e.clone(parent, dataSource);
						items.add(e.getID());
						objects.add(e);
						cachedObjects = null;
					}
				return e;
			}
			
		public void internalAdd(E e)
			{
				items.add(e.getID());
				objects.add(e);
				cachedObjects = null;
			}

		public void internalLoad(E e)
			{
				items.add(e.getExternalID());
				objects.add(e);
				cachedObjects = null;
			}

		public void internalInsert(int index, E e)
			{
				items.add(index, e.getID());
				objects.add(index, e);
				cachedObjects = null;
			}
			
		public void internalClear()
			{
				if (items.size() != 0)
					{
						items.clear();
						objects.clear();
						cachedObjects = null;
					}
			}
			
		public int getIndexOf(E e)
			{
				return objects.indexOf(e);
			}
			
		@SuppressWarnings("unchecked")
		public void replaceExternalReferenceID(HashMap<Long, EffectopediaObject> idMap)
			{
				if (isDefaultID())
					return;
				int count = items.size();
				objects.clear();
				cachedObjects = null;
				for (int i = 0; i < count; i++)
					{
						EffectopediaObject eo = idMap.get(items.get(i));
						if (eo == null)
							{
								items.remove(i);
								count--;
								// problem with the file !!!
							}
						else
							{
								items.set(i, eo.getID());
								objects.add((E) eo);
							}
						// System.out.println(objectClass+"\t->\t"+((eo!=null)?eo.getClass():"n/a")+"\treplace
						// externalID\t"+items.get(i)+"\twith\t"+((eo!=null)?(eo.getID()+"\tand
						// eo.externalID=\t"+eo.getExternalID()):"n/a\tand
						// eo.externalID=\tn/a")+"\tthis ID\t"+this.getID());
					}
				/*
				 * //System.out.print("\nReferences to replace:"); for (int i = 0; i <
				 * count; i++) { //System.out.print(" " + items.get(i)); EffectopediaObject
				 * eo = idMap.get(items.get(i)); if (eo != null) { //System.out.print(" (" +
				 * eo.getClass() + ")"); items.set(i, eo.getID()); } else
				 * //System.out.print(" (!!! reference not found !!!)"); }
				 */
				cachedObjects = null;
			}
			
		@SuppressWarnings("unchecked")
		public void replaceDefaultObjectsWtihClones()
			{
				int count = objects.size();
				for (int i = 0; i < count; i++)
					{
						EffectopediaObject eo = objects.get(i);
						if (eo.isDefaultID())
							objects.set(i, (E) EffectopediaObject.cloneIfInDefaultObjects(eo, eo.getParent(), eo.getDataSource()));
					}
				cachedObjects = null;
			}
			
		public void add(E e)
			{
				if ((objects != null) && objects.indexOf(e) != -1)
					return;
				beforeUpdate(true, ActionTypes.LIST_ADD);
				int index = items.size();
				items.add(e.getID());
				objects.add(e);
				cachedObjects = null;
				fireReferenceIDsChanged(new ReferenceIDsListChange(this, index, index));
			}
			
		public void insert(int index, E e)
			{
				if ((objects != null) && objects.indexOf(e) != -1)
					return;
				beforeUpdate(true, ActionTypes.LIST_ADD);
				items.add(index, e.getID());
				objects.add(index, e);
				cachedObjects = null;
				fireReferenceIDsChanged(new ReferenceIDsListChange(this, index, index));
			}
			
		public void addAndKeepItDefault(E e)
			{
				int index = items.size();
				items.add(e.getID());
				objects.add(e);
				cachedObjects = null;
				fireReferenceIDsChanged(new ReferenceIDsListChange(this, index, index));
			}
			
		public void addAndKeepItDefault(E e, int index)
			{
				items.add(index, e.getID());
				objects.add(index, e);
				cachedObjects = null;
				fireReferenceIDsChanged(new ReferenceIDsListChange(this, index, index));
			}
			
		public void setAndKeepItDefault(E e, int index)
			{
				if ((index < size()) && (index >= 0) && (objectClass.isAssignableFrom(e.getClass())))
					{
						items.set(index, e.getID());
						objects.set(index, e);
						cachedObjects = null;
						fireReferenceIDsChanged(new ReferenceIDsListChange(this, index, index));
					}
			}
			
		public void add(Object o)
			{
				if (objectClass.isAssignableFrom(o.getClass()))
					{
						beforeUpdate(true, ActionTypes.LIST_ADD);
						E eo = (E) o;
						int index = items.size();
						items.add(eo.getID());
						objects.add(eo);
						cachedObjects = null;
						fireReferenceIDsChanged(new ReferenceIDsListChange(this, index, index));
					}
			}
			
		public void set(Object e, int index)
			{
				if ((index < size()) && (index >= 0) && (objectClass.isAssignableFrom(e.getClass())))
					{
						beforeUpdate(true, ActionTypes.REFERENCE_SET);
						@SuppressWarnings("unchecked")
						E eo = (E) e;
						items.set(index, eo.getID());
						objects.set(index, eo);
						cachedObjects = null;
						fireReferenceIDsChanged(new ReferenceIDsListChange(this, index, index));
					}
			}
			
		public void setAll(Collection<E> objects)
			{
				if (objects == null)
					return;
				beforeUpdate(true, ActionTypes.REFERENCE_SET);
				this.items.clear();
				this.objects.clear();
				this.objects.addAll(objects);
				for (E obj : objects)
					this.items.add(obj.getID());
				cachedObjects = null;
				fireReferenceIDsChanged(new ReferenceIDsListChange(this, 0, objects.size()));
			}

		public void internalSetAll(Collection<E> objects)
			{
				if (objects == null)
					return;
				this.items.clear();
				this.objects.clear();
				this.objects.addAll(objects);
				for (E obj : objects)
					this.items.add(obj.getID());
				cachedObjects = null;
				fireReferenceIDsChanged(new ReferenceIDsListChange(this, 0, objects.size()));
			}
			
		public boolean addIfDifferent(E e)
			{
				long id = e.getID();
				if (items.indexOf(id) == -1)
					{
						beforeUpdate(true, ActionTypes.LIST_ADD);
						int index = items.size();
						items.add(id);
						objects.add(e);
						cachedObjects = null;
						fireReferenceIDsChanged(new ReferenceIDsListChange(this, index, index));
						return true;
					}
				return false;
			}
			
		public void remove(int index)
			{
				if ((index < 0) || (index >= items.size()))
					return;
				beforeUpdate(true, ActionTypes.LIST_REMOVE);
				cachedObjects = null;
				items.remove(index);
				objects.remove(index);
				fireReferenceIDsChanged(new ReferenceIDsListChange(this, index, index));
			}
			
		public void removeIfPresent(E e)
			{
				long id = e.getID();
				int index = items.indexOf(id);
				if (index != -1)
					{
						beforeUpdate(true, ActionTypes.LIST_REMOVE);
						cachedObjects = null;
						items.remove(index);
						objects.remove(index);
						fireReferenceIDsChanged(new ReferenceIDsListChange(this, index, index));
					}
			}
			
		public boolean repaclace(int index, E e)
			{
				cachedObjects = null;
				boolean replaceable = (index < items.size()); // &&
																																																		// ((items.get(index)).longValue()
																																																		// == 0);
				if (replaceable)
					{
						items.set(index, e.getID());
						objects.set(index, e);
						fireReferenceIDsChanged(new ReferenceIDsListChange(this, index, index));
					}
				return replaceable;
			}
			
		public boolean remove(E e)
			{
				int index = objects.indexOf(e);
				if (index != -1)
					{
						beforeUpdate(true, ActionTypes.LIST_REMOVE);
						cachedObjects = null;
						items.remove(index);
						objects.remove(index);
						fireReferenceIDsChanged(new ReferenceIDsListChange(this, index, index));
					}
				return index != -1;
			}
			
		public void clear()
			{
				if (items.size() != 0)
					{
						beforeUpdate(true, ActionTypes.LIST_CLEAR);
						int index = items.size();
						items.clear();
						objects.clear();
						cachedObjects = null;
						fireReferenceIDsChanged(new ReferenceIDsListChange(this, 0, index));
					}
			}
			
		public void updateIDsFromObjects()
			{
				int count = items.size();
				if (count == objects.size())
					for (int i = 0; i < count; i++)
						items.set(i, objects.get(i).getID());
			}
			
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				if (dataSource != null)
					{
						objects.clear();
						// System.out.println(parent != null ? parent.getClass() : "Unknown" +
						// " refence object with ID\t" + getID() + "/" + getExternalID() +
						// "\tdefault=" + isDefaultID());
						for (long id : items)
							{
								E eo = dataSource.get(objectClass, id);
								if (eo==null)
									eo = (E) dataSource.getLiveIndices().getByID(id);
								if (eo == null)
									System.err.println("Error in ReferenceIDs.reloadReferredObjectsFromID No object found for ID =\t" + objectClass + "\t" + id);
								// eo = (E) dataSource.getArchivedEffectopediaObjectByID(objectClass,
								// id);
								objects.add(eo);
								// System.out.println(" Objectid =\t" + id);
							}
						cachedObjects = (E[]) Array.newInstance(objectClass, objects.size());
						if (cachedObjects != null)
							cachedObjects = objects.toArray(cachedObjects);
					}
			}
			
		@SuppressWarnings("unchecked")
		public void updateReferrals(HashMap<Long, EffectopediaObject> referrals)
			{
				super.updateReferrals(referrals);
				for (int i = 0; i < items.size(); i++)
					{
						E eo = (E) referrals.get(items.get(i));
						if (eo != null)
							{
								items.set(i, eo.getID());
								objects.set(i, eo);
							}
					}
				cachedObjects = (E[]) Array.newInstance(objectClass, objects.size());
				if (cachedObjects != null)
					cachedObjects = objects.toArray(cachedObjects);
			}

		public void updateReferrals(DataSourceMerge dsm)
			{
				super.updateReferrals(dsm);
				for (int i = 0; i < objects.size(); i++)
					{
		//				if ((objects.get(i)!=null)&&(objects.get(i).getDataSource()!=null) && (objects.get(i).getDataSource()!=dataSource) && (!objects.get(i).isDefaultID()))
		//					System.out.println("need to replace");

						E eo = (E) dsm.get(dataSource,objects.get(i));
						if (eo != null)
							{
								items.set(i, eo.getID());
								objects.set(i, eo);
							}
						else
							System.err.println("Corresponding object was not identified! "+objects.get(i).DEBUG_getIDs());
					}
				cachedObjects = (E[]) Array.newInstance(objectClass, objects.size());
				if (cachedObjects != null)
					cachedObjects = objects.toArray(cachedObjects);
			}

		public int size()
			{
				return items.size();
			}
			
		public int contains(E e)
			{
				return objects.indexOf(e);
			}

		public Long[] getCachedIDs()
			{
				return items.toArray(new Long[items.size()]);
			}
			
		public E[] getCachedObjects()
			{
				if (cachedObjects == null)
					{
						if (objectClass == null)
							return null;
						cachedObjects = (E[]) Array.newInstance(objectClass, objects.size());
						if (cachedObjects != null)
							cachedObjects = objects.toArray(cachedObjects);
					}
				return cachedObjects;
			}

		public ArrayList<E> getObjects()
			{
				return new ArrayList<E>(objects);
			}
			
		public E getCachedObject(int index)
			{
				if ((index >= 0) && (index < objects.size()))
					return objects.get(index);
				return null;
			}
			
		public int contains(long id)
			{
				return items.indexOf(id);
			}
			
		public Class<E> getObjectClass()
			{
				return objectClass;
			}
			
		@SuppressWarnings("unchecked")
		@Override
		public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if ((eoDestintation instanceof ReferenceIDs<?>) && (objectClass == ((ReferenceIDs<?>) eoDestintation).getObjectClass()))
					{
						beforeUpdate(true, ActionTypes.LIST_ASSIGN);
						((ReferenceIDs<E>) eoDestintation).clear();
						((ReferenceIDs<E>) eoDestintation).items.addAll(this.items);
						((ReferenceIDs<E>) eoDestintation).objects.addAll(this.objects);
					}
			}
			
		@SuppressWarnings("unchecked")
		public void cloneFieldsTo(ReferenceIDs<E> clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.items.clear();
				for (int i = 0; i < this.items.size(); i++)
					{
						long itemID = this.items.get(i);
						clone.items.add(itemID > 0 ? itemID + ID_OFFSET : itemID);
					}
				clone.objects.clear();
				for (E eo : this.objects)
					clone.objects.add((E) addID_OffsetIfNeeded(eo, dataSource));
				clone.cachedObjects = null;
				clone.fireReferenceIDsChanged(new ReferenceIDsListChange(clone, 0, items.size() - 1));
			}
			
		@Override
		public ReferenceIDs<E> clone()
			{
				ReferenceIDs<E> clone = new ReferenceIDs<E>(getParent(), dataSource, objectClass);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
			
		@Override
		public ReferenceIDs<E> clone(EffectopediaObject parent, DataSource dataSource)
			{
				ReferenceIDs<E> clone = new ReferenceIDs<E>(parent, dataSource, objectClass);
				cloneFieldsTo(clone, dataSource);
				// System.out.println("Cloned reference object\t" + clone.getClass() +
				// "\tID=\t" + clone.getID() + "\tcreated");
				return clone;
			}
			
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						BaseIOElement e = element.getChild("ids");
						if (e != null)
							{
								int count = Integer.parseInt(e.getAttributeValue("count"));
								if (count != 0)
									{
										items.clear();
										items.ensureCapacity(count);
										StringTokenizer idsArray = new StringTokenizer(e.getValue(), " ");
										while (idsArray.hasMoreTokens())
											{
												items.add(Long.parseLong(idsArray.nextToken().trim()));
											}
									}
								cachedObjects = null;
								fireReferenceIDsChanged(new ReferenceIDsListChange(this, 0, items.size() - 1));
								BaseIOElement co = element.getChild("object_class");
								try
									{
										objectClass = (Class<E>) Class.forName(co.getValue());
									}
								catch (ClassNotFoundException e1)
									{
										e1.printStackTrace();
									}
							}
					}
			}
			
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				BaseIOValue co = io.newValue("object_class");
				co.setValue(objectClass.getName());
				element.addValueElement(co);
				int count = items.size();
				BaseIOElement e = io.newElement("ids");
				e.setAttribute("count", Integer.toString(count));
				if (count != 0)
					{
						StringBuilder idsArray = new StringBuilder();
						for (int i = 0; i < count; i++)
							{
								long id = Effectopedia.EFFECTOPEDIA.getData().autoExternalID(objectClass, items.get(i));
								idsArray.append(id);
								idsArray.append(' ');
							}
						e.setValue(idsArray.toString());
					}
				element.addChild(e);
				return element;
			}
			
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				/*
				 * int count = items.size(); if ((cachedObjects == null) ||
				 * (cachedObjects.length != count)) cachedObjects = getCachedObjects(); if
				 * ((cachedObjects != null)&&(cachedObjects.length==count)) for (int i = 0;
				 * i < count; i++) cachedObjects[i].getContainedIDs(containedIDs);
				 */
			}
			
		public String DEBUG_getIDs()
			{
				StringBuilder sb = new StringBuilder();
				sb.append(super.DEBUG_getIDs());
				sb.append("\titems\t");
				for (long id : items)
					{
						sb.append(id);
						sb.append(" ");
					}
				return sb.toString();
			}
			
		@SuppressWarnings("serial")
		public static class ReferenceIDsListChange extends EventObject
			{
				public ReferenceIDsListChange(Object source, int lowestIndexChanged, int highestIndexChanged)
					{
						super(source);
						this.lowestIndexChanged = lowestIndexChanged;
						this.highestIndexChanged = highestIndexChanged;
					}
					
				public final int	lowestIndexChanged;
				public final int	highestIndexChanged;
			}
			
		public interface ReferenceIDsChangeListener
			{
				public void ReferenceIDsChanged(ReferenceIDsListChange evt);
			}
			
		public void addReferenceIDsChangeListener(ReferenceIDsChangeListener listener)
			{
				if (!referenceIDsListeners.contains(listener))
					referenceIDsListeners.add(listener);
			}
			
		public void removeReferenceIDsChangeListener(ReferenceIDsChangeListener listener)
			{
				referenceIDsListeners.remove(listener);
			}
			
		protected void fireReferenceIDsChanged(ReferenceIDsListChange evt)
			{
				for (ReferenceIDsChangeListener listener : referenceIDsListeners)
					listener.ReferenceIDsChanged(evt);
			}
			
		protected ArrayList<ReferenceIDsChangeListener>	referenceIDsListeners	= new ArrayList<ReferenceIDs.ReferenceIDsChangeListener>();
		protected final ArrayList<Long>																	items;
		protected final ArrayList<E>																				objects;
		protected E[]																																			cachedObjects									= null;
		protected Class<E>																														objectClass;
	}

package org.qsari.effectopedia.base;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOArray;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.ExportableCollection;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;

public abstract class EffectopediaObjects<E extends EffectopediaObject> extends HashMap<Long, E> implements Importable, ExportableCollection, Comparable<EffectopediaObjects<?>>
	{
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		/**
		 * Helper (not efficient) method for infrequent calls that provides sorted
		 * iterator for the map elements.
		 * 
		 * @return sorted iterator for the HasMap represented by this class.
		 */
		public Iterator<Map.Entry<Long, E>> getSortedIterator()
			{
				List<Map.Entry<Long, E>> list = new ArrayList<Map.Entry<Long, E>>();
				Iterator<Map.Entry<Long, E>> it = entrySet().iterator();
				while (it.hasNext())
					list.add(it.next());
				class IDComparator implements Comparator<Map.Entry<Long, E>>
					{
						public int compare(Map.Entry<Long, E> o1, Map.Entry<Long, E> o2)
							{
								return o1.getValue().compareTo(o2.getValue());
							}
					}
				Collections.sort(list, new IDComparator());
				return list.iterator();
			}
		
		public EffectopediaObjects()
			{
				super();
			}
		
		abstract public boolean addNew(EffectopediaObject parent, DataSource dataSource, Class<E> objectClass);
		
		public void updateParenthood()
			{
				Iterator<Map.Entry<Long, E>> it = entrySet().iterator();
				while (it.hasNext())
					it.next().getValue().updateParenthood();
			}
		
		public void updateExternalIDs()
			{
				Iterator<Map.Entry<Long, E>> it = getSortedIterator();
				while (it.hasNext())
					it.next().getValue().updateExternalID();
			}
		
		public void replaceDefaultObjectsWtihClones()
			{
				Iterator<Map.Entry<Long, E>> it = getSortedIterator();
				while (it.hasNext())
					it.next().getValue().replaceDefaultObjectsWtihClones();
			}

		public void replaceArchivedObjectsWtihClones()
			{
				Iterator<Map.Entry<Long, E>> it = getSortedIterator();
				while (it.hasNext())
					it.next().getValue().replaceArchivedObjectsWtihClones();
			}

		public void putDefault(HashMap<Long, E> index)
			{
				Iterator<Map.Entry<Long, E>> it = index.entrySet().iterator();
				while (it.hasNext())
					{
						Map.Entry<Long, E> e = it.next();
						EffectopediaObject eo = e.getValue();
						if ((eo != null) && (eo.isDefaultID()))
							put(e.getKey(), e.getValue());
					}
			}
		
		public void updateExternalIDToIDMap(HashMap<Long, EffectopediaObject> idMap)
			{
				Iterator<Map.Entry<Long, E>> it = entrySet().iterator();
				while (it.hasNext())
					{
						E e = it.next().getValue();
						idMap.put(e.getExternalID(), e);
					}
			}
		
		public void reloadReferredObjectsFromID()
			{
				Iterator<Map.Entry<Long, E>> it = entrySet().iterator();
				while (it.hasNext())
					it.next().getValue().reloadReferredObjectsFromID();
			}
		
		@SuppressWarnings("unchecked")
		public <T extends EffectopediaObject> T[] getObjectArrayByIDs(ReferenceIDs<T> ids)
			{
				int count = ids.size();
				if (count == 0)
					return null;
				else
					{
						T[] objectsArray = (T[]) Array.newInstance(ids.getObjectClass(), count);
						for (int i = 0; i < count; i++)
							objectsArray[i] = (T) get(i);
						return objectsArray;
					}
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element == null)
					return;
				BaseIOArray e = element.getArray("items");
				if ((e != null) && (e.isValidArray()))
					{
						List<BaseIOElement> children = e.getChildren();
							{
								Iterator<BaseIOElement> iterator = children.iterator();
								while (iterator.hasNext())
									{
										BaseIOElement child = (BaseIOElement) iterator.next();
										try
											{
												Class<?> cl = Class.forName(child.getName());
												io.load(cl, null, child);
											}
										catch (ClassNotFoundException cnfe)
											{
												cnfe.printStackTrace();
											}
									}
							}
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				BaseIOArray e = io.newArray("items", entrySet().size());
				Iterator<Map.Entry<Long, E>> iterator = getSortedIterator();
				while (iterator.hasNext())
					{
						Map.Entry<Long, E> entry = (Map.Entry<Long, E>) iterator.next();
						E o = (E) entry.getValue();
						BaseIOElement obj = io.newElement(o.getClass().getName());
						o.store(obj, io);
						e.addChild(obj);
					}
				element.addChild(e);
				return element;
			}
		
		public BaseIOElement store(LinkedHashMap<Long, EffectopediaObject> excludeIDs, BaseIOElement element, BaseIO io)
			{
				BaseIOArray e = io.newArray("items", 0);
				int cnt = 0;
				Iterator<Map.Entry<Long, E>> iterator = getSortedIterator();
				while (iterator.hasNext())
					{
						Map.Entry<Long, E> entry = (Map.Entry<Long, E>) iterator.next();
						if (excludeIDs.get(entry.getKey()) == null)
							{
								E o = (E) entry.getValue();
								BaseIOElement obj = io.newElement(o.getClass().getName());
								o.store(obj, io);
								o.getContainedIDs(excludeIDs, true);
								e.addChild(obj);
								cnt++;
							}
					}
				e.setCount(cnt);
				element.addChild(e);
				return (cnt == 0) ? null : element;
			}
		
		public int hashCode()
			{
				return ID;
			}
		
		public int compareTo(EffectopediaObjects<?> o)
			{
				return ID - o.ID;
			}
		
		public Object[] get()
			{
				return values().toArray();
			}
		
		@SuppressWarnings("unchecked")
		public E put(Long key, EffectopediaObject eo)
			{
				return super.put(key, (E) eo);
			}
		
		public void putAll(EffectopediaObjects<E> objects, long maxExternalID)
			{
				if (objects != null)
					{
						Iterator<Map.Entry<Long, E>> it = objects.entrySet().iterator();
						while (it.hasNext())
							{
								Map.Entry<Long, E> entry = it.next();
								long externalID = entry.getValue().externalID;
								if ((externalID != 0) && (externalID <= maxExternalID))
									put(entry.getKey(), entry.getValue());
							}
					}
			}
		
		public void putClones(EffectopediaObjects<E> source, DataSource dataSource)
			{
				if (source != null)
					{
						Iterator<Map.Entry<Long, E>> it = source.entrySet().iterator();
						while (it.hasNext())
							{
								Map.Entry<Long, E> entry = it.next();
								EffectopediaObject eo = entry.getValue();
								if (!eo.isDefaultID())
									put(eo.getID(), eo.clone(eo.getParent(), dataSource));
							}
					}
			}
		
		public long getMinObjectID()
			{
				long minID = EffectopediaObject.effectopediaObjectIDs;
				for (EffectopediaObject eo : values())
					{
						long id = eo.getID();
						if ((id >= 0) && (id < minID))
							minID = id;
					}
				return minID;
			}
		
		public long getMaxObjectID()
			{
				long maxID = 0;
				for (EffectopediaObject eo : values())
					{
						long id = eo.getID();
						if ((id > 0) && (id > maxID))
							maxID = id;
					}
				return maxID;
			}
		
		public void setDataSource(DataSource dataSource)
			{
				Iterator<Map.Entry<Long, E>> it = entrySet().iterator();
				while (it.hasNext())
					{
						E e = it.next().getValue();
						e.setDataSource(dataSource);
					}
			}
		
		public void DEBUG_pintContainedIDs()
			{
				Iterator<Map.Entry<Long, E>> it = entrySet().iterator();
				while (it.hasNext())
					{
						E e = it.next().getValue();
						if (e != null)
							System.out.println(this.getClass() + e.DEBUG_getIDs());
					}
			}
		
		public String toString()
			{
				return "effectopedia_objects";
			}
		
		public final int					ID																					= effectopediaObjectsIDs++;
		public static int				effectopediaObjectsIDs	= 0;
	}

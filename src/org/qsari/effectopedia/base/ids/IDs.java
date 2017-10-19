package org.qsari.effectopedia.base.ids;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIO.DataPattern;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.data.DataSource;

public class IDs<E extends EffectopediaObject> extends ReferenceIDs<E> implements Importable, Exportable, Cloneable, Traceable
	{
		
		public IDs()
			{
				super();
			}
			
		public IDs(EffectopediaObject parent, DataSource dataSource, Class<E> objectClass)
			{
				super(parent, dataSource, objectClass);
			}
			
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				if (includeOwned)
					for (int i = 0; i < objects.size(); i++)
						{
							E e = objects.get(i);
							if (e != null)
								e.getContainedIDs(containedIDs, includeOwned);
						}
			}
			
		@Override
		public void getContainedEffectopediaObjects(ArrayList<EffectopediaObject> list)
			{
				super.getContainedEffectopediaObjects(list);
				for (int i = 0; i < objects.size(); i++)
					{
						E e = objects.get(i);
						if (e != null)
							list.add(e);
					}
			}
			
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				if (!Effectopedia.EFFECTOPEDIA.getData().isShallowMode())
					for (int i = 0; i < objects.size(); i++)
						{
							E e = objects.get(i);
							if (e != null)
								e.getContainedExternalIDs(containedIDs);
						}
			}
			
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (!Effectopedia.EFFECTOPEDIA.getData().isShallowMode())
					for (int i = 0; i < objects.size(); i++)
						{
							E e = objects.get(i);
							if (e != null)
								e.process(batch);
						}
			}
			
		@Override
		public void beforeUpdate(boolean changed, long fieldID)
			{
				super.beforeUpdate(changed, fieldID);
				if (changed && (parent instanceof PathwayElement))
					((PathwayElement) parent).setGeneric(false);
			}
			
		@SuppressWarnings("unchecked")
		@Override
		public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				if ((eoDestintation instanceof IDs<?>) && (objectClass == ((IDs<?>) eoDestintation).getObjectClass()))
					{
						int cnt = ((IDs<E>) eoDestintation).objects.size();
						while (cnt < objects.size())
							{
								((IDs<E>) eoDestintation).objects.add((E) objects.get(cnt - 1).clone(((IDs<E>) eoDestintation), dataSource));
								cnt++;
							}
						while (cnt > objects.size())
							{
								((IDs<E>) eoDestintation).objects.remove(cnt - 1);
								cnt--;
							}
						for (int i = cnt - 1; i >= 0; i--)
							objects.get(i).assignFieldsTo(((IDs<E>) eoDestintation).objects.get(i), assignContainedEO);
					}
			}
			
		@SuppressWarnings("unchecked")
		public void cloneFieldsTo(IDs<E> clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.objects.clear();
				for (E eo : this.objects)
					clone.objects.add((E) eo.clone(clone, dataSource));
			}
			
		@Override
		public IDs<E> clone()
			{
				IDs<E> clone = new IDs<E>(getParent(), dataSource, objectClass);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
			
		@Override
		public IDs<E> clone(EffectopediaObject parent, DataSource dataSource)
			{
				IDs<E> clone = new IDs<E>(parent, dataSource, objectClass);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
			
		public void load(BaseIOElement element, BaseIO io)
			{
				if (io.getDataPattern() == DataPattern.RUSSIAN_DOLL)
					deepLoad(element, io);
				else
					super.load(element, io);
			}
			
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				if (io.getDataPattern() == DataPattern.RUSSIAN_DOLL)
					return deepStore(element, io);
				else
					return super.store(element, io);
			}
			
		public BaseIOElement deepStore(BaseIOElement element, BaseIO io)
			{
				updateIDsFromObjects();
				super.store(element, io);
				BaseIOElement e = io.newElement("objects");
				int count = objects.size();
				e.setAttribute("count", String.valueOf(count));
				e.setAttribute("class_path", objectClass.getPackage().getName());
				if ((cachedObjects == null) || (cachedObjects.length != count))
					cachedObjects = getCachedObjects();
				if (cachedObjects != null)
					for (int i = 0; i < count; i++)
						{
							BaseIOElement obj = io.newElement(cachedObjects[i].getClass().getSimpleName());
							cachedObjects[i].store(obj, io);
							e.addChild(obj);
						}
				element.addChild(e);
				return element;
			}
			
		public void deepLoad(BaseIOElement element, BaseIO io)
			{
				if (element == null)
					return;
				super.load(element, io);
				BaseIOElement e = element.getChild("objects");
				if (e != null)
					{
						int count = Integer.parseInt(e.getAttributeValue("count"));
						String class_path = e.getAttributeValue("class_path") + ".";
						List<BaseIOElement> children = e.getChildren();
						if ((count != 0) && (children != null) && (children.size() == count))
							{
								Iterator<BaseIOElement> iterator = children.iterator();
								while (iterator.hasNext())
									{
										BaseIOElement child = iterator.next();
										try
											{
												BaseIOAttribute a = element.getAttribute("id");
												long externalID = a.getLongValue();
												// System.out.println("Loading:"+child.getName()+" with external
												// ID="+externalID);
												Class<E> cl = (Class<E>) Class.forName(class_path + child.getName());
												EffectopediaObject object = io.load(cl, null, child);
												objects.add((E) object);
											}
										catch (ClassNotFoundException cnfe)
											{
												cnfe.printStackTrace();
											}
									}
							}
					}
			}
			
		public void updateParenthood()
			{
				int count = objects.size();
				for (int i = 0; i < count; i++)
					{
						E eo = objects.get(i);
						if (eo != null)
							eo.setParent(this);
						else
							System.err.println("Errot in IDs.updateParenthood index:" + items.get(i) + "\t reffers to null object");
						
					}
			}
			
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
				if ((element == null) || (Effectopedia.EFFECTOPEDIA.getData().isShallowMode()))
					return;
				BaseIOElement e = element.getChild("objects");
				if (e != null)
					{
						int count = Integer.parseInt(e.getAttributeValue("count"));
						@SuppressWarnings("unchecked")
						List<BaseIOElement> children = e.getChildren();
						if ((count != 0) && (children != null) && (children.size() == count))
							{
								Iterator<BaseIOElement> iterator = children.iterator();
								while (iterator.hasNext())
									{
										BaseIOElement child = iterator.next();
										long DefaultID = EffectopediaObject.getDefaultID(child);
										if (DefaultID != EffectopediaObject.NON_DEFAULT)
											{
												// TODO Negative ID Revolution
												// if (DefaultID>0)
												// DefaultID = -DefaultID;
												EffectopediaObject eo = EffectopediaObject.getEffectopediaObjectByDefaultID(DefaultID);
												eo.updateExternalID(child);
											}
									}
							}
					}
			}
			
	}

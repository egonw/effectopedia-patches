package org.qsari.effectopedia.base.ids;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOArray;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultObjectIOFactory;
import org.qsari.effectopedia.defaults.DefaultObjectIOFactory.DefaultObjectIO;
import org.qsari.effectopedia.system.ActionTypes;

public class ReferenceIDsMAP<E extends EffectopediaObject, R, D extends EffectopediaObject> extends EffectopediaObject implements Importable, Exportable, Cloneable, Traceable
	{
		public class RDObject
			{
				public RDObject()
					{
						this.referenceID = 0;
						this.detailID = 0;
					}
				
				public RDObject(R reference, D detail, boolean deepImpExp)
					{
						this.reference = reference;
						if (reference instanceof EffectopediaObject)
							this.referenceID = ((EffectopediaObject) reference).getID();
						this.detail = detail;
						if (detail != null)
							this.detailID = detail.getID();
						this.deepImpExp = deepImpExp;
					}
				
				public RDObject(long referenceID, long detailID)
					{
						this.referenceID = referenceID;
						this.detailID = detailID;
					}
				
				public RDObject(RDObject rdo)
					{
						this.reference = rdo.reference;
						this.referenceID = rdo.referenceID;
						this.detail = rdo.detail;
						this.detailID = rdo.detailID;
						this.deepImpExp = rdo.deepImpExp;
					}
				
				public long				referenceID;
				public R							reference;
				public long				detailID;
				public D							detail;
				public boolean	deepImpExp	= false;
			}
		
		public RDObject newRDObject(R reference, D detail, boolean deepImpExp)
			{
				return new RDObject(reference, detail, deepImpExp);
			}
		
		public ReferenceIDsMAP()
			{
				super();
				idMAP = new HashMap<Long, RDObject>();
				objectMAP = new HashMap<E, RDObject>();
			}
		
		public ReferenceIDsMAP(EffectopediaObject parent, DataSource dataSource, Class<E> sourceClass, Class<?> relationClass, Class<D> targetClass, boolean deepImpExp)
			{
				super(parent, dataSource);
				idMAP = new HashMap<Long, RDObject>();
				objectMAP = new HashMap<E, RDObject>();
				this.defaultDeepImpExp = deepImpExp;
			}
		
		public void put(E e, R r)
			{
				beforeUpdate(true, ActionTypes.IDs_MAP_PUT);
				RDObject rdo = new RDObject(r, defaultDetail, defaultDeepImpExp);
				idMAP.put(e.getID(), rdo);
				objectMAP.put(e, rdo);
			}
		
		public void put(E e, R r, D d)
			{
				beforeUpdate(true, ActionTypes.IDs_MAP_PUT);
				RDObject rdo = new RDObject(r, d, defaultDeepImpExp);
				idMAP.put(e.getID(), rdo);
				objectMAP.put(e, rdo);
			}
		
		public void put(E e, R r, D d, boolean deepImpExp)
			{
				beforeUpdate(true, ActionTypes.IDs_MAP_PUT);
				RDObject rdo = new RDObject(r, d, deepImpExp);
				idMAP.put(e.getID(), rdo);
				objectMAP.put(e, rdo);
			}
		
		public void internalPut(E e, R r, D d, boolean deepImpExp)
			{
				RDObject rdo = new RDObject(r, d, deepImpExp);
				idMAP.put(e.getID(), rdo);
				objectMAP.put(e, rdo);
			}
		
		public void remove(E e)
			{
				if ((objectMAP.get(e) != null) && (idMAP.get(e.getID()) != null))
					{
						beforeUpdate(true, ActionTypes.IDs_MAP_REMOVE);
						idMAP.remove(e.getID());
						objectMAP.remove(e);
					}
			}
		
		public void internalRemove(E e)
			{
				if ((objectMAP.get(e) != null) && (idMAP.get(e.getID()) != null))
					{
						idMAP.remove(e.getID());
						objectMAP.remove(e);
					}
			}
		
		public void clear()
			{
				beforeUpdate(true, ActionTypes.IDs_MAP_CLEAR);
				idMAP.clear();
				objectMAP.clear();
			}
		
		public void internalClear()
			{
				idMAP.clear();
				objectMAP.clear();
			}
		
		public RDObject get(E e)
			{
				return objectMAP.get(e);
			}
		
		public R getR(E e)
			{
				return objectMAP.get(e).reference;
			}
		
		public D getT(E e)
			{
				return objectMAP.get(e).detail;
			}
		
		public RDObject get(Long id)
			{
				return idMAP.get(id);
			}
		
		public R getR(Long id)
			{
				return idMAP.get(id).reference;
			}
		
		public D getT(Long id)
			{
				return idMAP.get(id).detail;
			}
		
		@SuppressWarnings("unchecked")
		public void replaceExternalReferenceID(HashMap<Long, EffectopediaObject> idMap)
			{
				if (isDefaultID())
					return;
				objectMAP.clear();
				for (Iterator<Entry<Long, RDObject>> it = idMAP.entrySet().iterator(); it.hasNext();)
					{
						Entry<Long, RDObject> entry = it.next();
						E sEO = (E) idMap.get(entry.getKey());
						RDObject rdo = entry.getValue();
						if (rdo.reference instanceof EffectopediaObject)
							rdo.reference = (R) idMap.get(((EffectopediaObject) rdo.reference).getID());
						rdo.detail = (D) idMap.get(rdo.detail.getID());
						objectMAP.put(sEO, entry.getValue());
					}
			}
		
		public void updateIDsFromObjects()
			{
				idMAP.clear();
				for (Iterator<Entry<E, RDObject>> it = objectMAP.entrySet().iterator(); it.hasNext();)
					{
						Entry<E, RDObject> entry = it.next();
						idMAP.put(entry.getKey().getID(), entry.getValue());
					}
			}
		
		@SuppressWarnings("unchecked")
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				if (dataSource != null)
					{
						objectMAP.clear();
						for (Iterator<Entry<Long, RDObject>> it = idMAP.entrySet().iterator(); it.hasNext();)
							{
								Entry<Long, RDObject> entry = it.next();
								E eo = dataSource.get(sourceClass, entry.getKey());
								RDObject rdo = entry.getValue();
								if (rdo.reference instanceof EffectopediaObject)
									rdo.reference = (R) dataSource.get((Class<? extends EffectopediaObject>) referenceClass, ((EffectopediaObject) rdo.reference).getID());
								rdo.detail = (D) dataSource.get(detailClass, rdo.detail.getID());
								// if (eo == null)
								// System.out.println("Error in ReferenceIDs.reloadReferredObjectsFromID
								// No object found for ID =\d"
								// + keyClass + "\d" + entry.getKey());
								objectMAP.put(eo, rdo);
							}
					}
			}
		
		@SuppressWarnings("unchecked")
		public void updateClonedReferrals()
			{
				super.updateClonedReferrals();
				idMAP.clear();
				for (Iterator<Entry<E, RDObject>> it = objectMAP.entrySet().iterator(); it.hasNext();)
					{
						Entry<E, RDObject> entry = it.next();
						idMAP.put(entry.getKey().getID(), new RDObject(entry.getValue()));
					}
			}
		
		public int size()
			{
				return idMAP.size();
			}
		
		public boolean contains(E e)
			{
				return objectMAP.get(e) != null;
			}
		
		public boolean contains(long id)
			{
				return idMAP.get(id) != null;
			}
		
		public Class<E> getKeyClass()
			{
				return sourceClass;
			}
		
		public HashMap<Long, RDObject> getIdMAP()
			{
				return idMAP;
			}
		
		public HashMap<E, RDObject> getObjectMAP()
			{
				return objectMAP;
			}
		
		public Class<?> getValueClass()
			{
				return detailClass;
			}
		
		public void cloneFieldsTo(ReferenceIDsMAP<E, R, D> clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.idMAP.clear();
				clone.objectMAP.clear();
				for (Iterator<Entry<E, RDObject>> it = objectMAP.entrySet().iterator(); it.hasNext();)
     {
						Entry<E, RDObject> entry = it.next();
						RDObject rdo = new RDObject(entry.getValue());
						clone.idMAP.put(entry.getKey().getID(), rdo);
						clone.objectMAP.put(entry.getKey(), rdo);
					}
				clone.defaultDeepImpExp = this.defaultDeepImpExp;
			}
		
		public ReferenceIDsMAP<E, R, D> clone()
			{
				ReferenceIDsMAP<E, R, D> clone = new ReferenceIDsMAP<E, R, D>(getParent(), dataSource, sourceClass, referenceClass, detailClass, defaultDeepImpExp);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public ReferenceIDsMAP<E, R, D> clone(EffectopediaObject parent, DataSource dataSource)
			{
				ReferenceIDsMAP<E, R, D> clone = new ReferenceIDsMAP<E, R, D>(parent, dataSource, sourceClass, referenceClass, detailClass, defaultDeepImpExp);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						loadClasses(element);
						BaseIOArray e = element.getArray("map");
						if ((e != null) && (e.isValidArray()))
							{
								List<BaseIOElement> children = e.getChildren();
									{
										DefaultObjectIO defaultRefIO = DefaultObjectIOFactory.FACTORY.getDefaultIO(referenceClass);
										for (Iterator<BaseIOElement> iterator = children.iterator(); iterator.hasNext();)
											{
												BaseIOElement child = (BaseIOElement) iterator.next();
												BaseIOAttribute id = child.getAttribute("sourceID");
												if (id != null)
													{
														long sourceID = id.getLongValue();

														RDObject rdo = new RDObject();
														if (EffectopediaObject.class.isAssignableFrom(referenceClass))
															rdo.referenceID = (long) defaultRefIO.load(null, child.getAttribute("reference"), io);
														else
															rdo.reference = (R) defaultRefIO.load(referenceClass, rdo.reference, child.getChild("reference"), io);
														id = child.getAttribute("detailID");
														if (id != null)
															rdo.detailID = id.getLongValue();
														else
															{
																rdo.detail = io.load(detailClass, null, child);
																rdo.deepImpExp = rdo.detail != null;
															}
														idMAP.put(sourceID, rdo);
													}
											}
									}
							}
					}
			}
		
		private void loadClasses(BaseIOElement element)
			{
				try
					{
						BaseIOElement sc = element.getChild("source_class");
						if (sc != null)
							sourceClass = (Class<E>) Class.forName(sc.getValue());
						BaseIOElement rc = element.getChild("reference_class");
						if (rc != null)
							referenceClass = Class.forName(rc.getValue());
						BaseIOElement dc = element.getChild("detail_class");
						if (dc != null)
							detailClass = (Class<D>) Class.forName(dc.getValue());
					}
				catch (ClassNotFoundException e1)
					{
						e1.printStackTrace();
					}
			}
		
		public void loadReference(RDObject rdo, BaseIOElement element, BaseIO io)
			{
				if (Number.class.isAssignableFrom(referenceClass))
					{
						BaseIOAttribute id = element.getAttribute("reference");
						if (id != null)
							rdo.referenceID = id.getLongValue();
						else
							{
								BaseIOElement ref = element.getChild("reference");
								if (ref != null)
									rdo.reference = (R) io.load(referenceClass, null, element);
							}
					}
			}
		
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				if (sourceClass != null)
					element.addValueElement(io.newValue("source_class").setValue(sourceClass.getName()));
				if (referenceClass != null)
					element.addValueElement(io.newValue("reference_class").setValue(referenceClass.getName()));
				if (detailClass != null)
					element.addValueElement(io.newValue("detail_class").setValue(detailClass.getName()));
				int count = idMAP.size();
				BaseIOArray e = io.newArray("map", count);
				DefaultObjectIO defaultIO = DefaultObjectIOFactory.FACTORY.getDefaultIO(referenceClass);
				if (count != 0)
					{
						for (Iterator<Entry<Long, RDObject>> it = idMAP.entrySet().iterator(); it.hasNext();)
							{
								Entry<Long, RDObject> entry = it.next();
								RDObject rdo = entry.getValue();
								BaseIOElement mapEntry = io.newElement("entry");
								long sourceID = Effectopedia.EFFECTOPEDIA.getData().autoExternalID(sourceClass, entry.getKey());
								mapEntry.setAttribute("sourceID", Long.toString(sourceID));
								if (EffectopediaObject.class.isAssignableFrom(referenceClass))
									mapEntry.addChild(defaultIO.store(rdo.reference, io.newElement("reference"), io));
								else
									mapEntry.addAttribute(defaultIO.store(rdo.reference, io.newAttribute("reference"), io));
								long detailID = Effectopedia.EFFECTOPEDIA.getData().autoExternalID(detailClass, rdo.detail.getID());
								if (rdo.deepImpExp)
									mapEntry.addChild(rdo.detail.store(io.newElement("detail"), io));
								else
									mapEntry.setAttribute("detailID", Long.toString(detailID));
								e.addChild(mapEntry);
							}
					}
				element.addChild(e);
				return element;
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedIDs(containedIDs);
			}
		
		public String DEBUG_getIDs()
			{
				StringBuilder sb = new StringBuilder();
				sb.append(super.DEBUG_getIDs());
				sb.append("\tmap\t");
				for (Iterator<Entry<Long, RDObject>> it = idMAP.entrySet().iterator(); it.hasNext();)
					{
						Entry<Long, RDObject> entry = it.next();
						sb.append(entry.getKey());
						sb.append(' ');
						RDObject rdo = entry.getValue();
						sb.append(rdo.reference);
						sb.append(' ');
						sb.append(rdo.detail);
						sb.append(';');
					}
				return sb.toString();
			}
		
		protected final HashMap<Long, RDObject>	idMAP;
		protected final HashMap<E, RDObject>				objectMAP;
		protected R																													defaultReference		= null;
		protected D																													defaultDetail					= null;
		protected boolean																							defaultDeepImpExp	= false;
		protected Class<E>																						sourceClass							= null;
		protected Class<?>																						referenceClass				= null;
		protected Class<D>																						detailClass							= null;
	}

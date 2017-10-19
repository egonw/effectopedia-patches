package org.qsari.effectopedia.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.DataSourceMerge;
import org.qsari.effectopedia.data.interfaces.IdentifiableEffectopediaObject;
import org.qsari.effectopedia.data.objects.DataValue;
import org.qsari.effectopedia.data.objects.DataValues;
import org.qsari.effectopedia.system.ActionTypes;
import org.qsari.effectopedia.utils.AllClassFields;

/**
 * <code>EffectopediaObject</code> is the base class for all Effectopedia
 * classes that are treated as separate entities and are individually monitored
 * in the {@link org.qsari.effectopedia.history.EditHistory}. The subclasses in
 * the <code>org.qsari.effectopedia.objects</code> package completely represent
 * all the elements of pathways and their components. They also do not override
 * {@link IndexedObject#autoId()} and have unique internal (memory) identifier
 * {@link #ID} across all {@link org.qsari.effectopedia.core.objects} package
 * objects. When <code>EffectopediaObject</code> descendents objects are created
 * they do not automatically obtain new {@link #ID} and initially have their ids
 * set to zero. If any of the object fields is modified for the first time the
 * {@link #ID} is auto assigned in
 * {@link EffectopediaObject#beforeUpdate(boolean changed, long fieldID)} .
 * <code>EffectopediaObject</code> contains also inherits an external file or
 * database identifier {@link #externalID} used for matching objects with ones
 * stored in external source.
 * 
 * @see IndexedObject
 * @see org.qsari.effectopedia.core.objects
 * 
 * @version $Revision$, $Date$
 * @author Hristo Aladjov
 */

public class EffectopediaObject extends IndexedObject implements Importable, Exportable, Cloneable, Traceable, IdentifiableEffectopediaObject
	{
		
		public EffectopediaObject()
			{
				super();
				this.parent = null;
			}
			
		public EffectopediaObject(boolean defaultObject)
			{
				super();
			}
			
		public EffectopediaObject(EffectopediaObject parent, DataSource dataSource)
			{
				super();
				this.parent = addID_OffsetIfNeeded(parent, dataSource);
				this.dataSource = dataSource;
			}
			
		public static interface BatchProcessor
			{
				public void process(EffectopediaObject eo);
				
				public int getOptions();
				
				public static final int	PROCESS_ALL											= 0;
				public static final int	PROCESS_EMBEDDED_ONLY	= 1;
			}
			
		public static class BatchSetExternalIDToZero implements BatchProcessor
			{
				public final static BatchSetExternalIDToZero INSTANCE = new BatchSetExternalIDToZero(BatchProcessor.PROCESS_ALL);
				
				private BatchSetExternalIDToZero(int options)
					{
						this.options = options;
					}
					
				public void process(EffectopediaObject eo)
					{
						if (eo.isDefaultID())
							eo.setExternalID(eo.defaultID);
						else
							eo.setExternalID(0);
					}
					
				public int getOptions()
					{
						return this.options;
					}
					
				public int options;
			}
			
		public static class BatchUpdateIDsFromObjects implements BatchProcessor
			{
				public final static BatchUpdateIDsFromObjects INSTANCE = new BatchUpdateIDsFromObjects(BatchProcessor.PROCESS_ALL);
				
				private BatchUpdateIDsFromObjects(int options)
					{
						this.options = options;
					}
					
				public void process(EffectopediaObject eo)
					{
						eo.updateIDsFromObjects();
					}
					
				public int getOptions()
					{
						return this.options;
					}
					
				public int options;
			}
			
		public static class BatchSetReadOnlyToTrue implements BatchProcessor
			{
				public final static BatchSetReadOnlyToTrue INSTANCE = new BatchSetReadOnlyToTrue(BatchProcessor.PROCESS_ALL);
				
				private BatchSetReadOnlyToTrue(int options)
					{
						this.options = options;
					}
					
				public void process(EffectopediaObject eo)
					{
						eo.setReadonly(true);
					}
					
				public int getOptions()
					{
						return this.options;
					}
					
				public int options;
			}
			
		public static class BatchUpdateClonedReferrals implements BatchProcessor
			{
				public final static BatchUpdateClonedReferrals INSTANCE = new BatchUpdateClonedReferrals(BatchProcessor.PROCESS_ALL);
				
				private BatchUpdateClonedReferrals(int options)
					{
						this.options = options;
					}
					
				public void process(EffectopediaObject eo)
					{
						eo.updateClonedReferrals();
					}
					
				public int getOptions()
					{
						return this.options;
					}
					
				public int options;
			}
			
		public void init(boolean asDefaultObject)
			{
				updateParenthood();
			}
			
		public void updateParenthood()
			{
			}
			
		public void bringToLive()
			{
				long ID = getID();
				if ((ID == 0) || (defaultID == ID))
					{
						autoSetId();
						setExternalID(0);
						updateSearchableItems();
						Effectopedia.EFFECTOPEDIA.getData().bringToLive(this.getClass(), this);
						if ((parent != this) && (parent != null))
							{
								if (parent.getID() == 0)
									parent.bringToLive();
								BatchUpdateIDsFromObjects.INSTANCE.process(parent);
							}
							
					}
			}
			
		public void updateIDsFromObjects()
			{
				
			}
			
		public void forceToLive()
			{
				if (Effectopedia.EFFECTOPEDIA.getData().isLive(this))
					if (defaultID == NON_DEFAULT)
						return;
				setDefaultID(NON_DEFAULT);
				setExternalID(0);
				autoSetId();
				updateSearchableItems();
				Effectopedia.EFFECTOPEDIA.getData().bringToLive(this.getClass(), this);
				if ((parent != this) && (parent != null))
					{
						if (parent.getID() == 0)
							parent.bringToLive();
						BatchUpdateIDsFromObjects.INSTANCE.process(parent);
					}
			}
			
		public void bruteForceToLive()
			{
				setDefaultID(NON_DEFAULT);
				setExternalID(0);
				autoSetId();
				updateSearchableItems();
				if (dataSource == null) // TODO remove Effectopedia.EFFECTOPEDIA references
																												// and use dataSource only
					dataSource = Effectopedia.EFFECTOPEDIA.getData();
				dataSource.bringToLive(this.getClass(), this);
				if ((parent != this) && (parent != null))
					{
						if (parent.getID() == 0)
							parent.bringToLive();
						BatchUpdateIDsFromObjects.INSTANCE.process(parent);
					}
			}
			
		@SuppressWarnings("unchecked")
		public <T extends EffectopediaObject> T makeItLive()
			{
				if (getID() == 0)
					{
						autoSetId();
						Effectopedia.EFFECTOPEDIA.getData().bringToLive(this.getClass(), this);
					}
				return (T) this;
			}
			
		public void beforeUpdate(boolean changed, long fieldID)
			{
				Boolean isDefault = defaultID != NON_DEFAULT;
				DataSource data = ((dataSource == null) || (isDefault)) ? Effectopedia.EFFECTOPEDIA.getData() : dataSource;
				if ((getID() == 0) || isDefault)
					{
						// getID() is 0 during the creation of the objects
						if ((parent != this) && (parent != null))
							parent.beforeUpdate(changed, ActionTypes.EO_UPDATED_COMPONENT_AID);
						setDefaultID(NON_DEFAULT);
						setExternalID(0);
						autoSetId();
						updateSearchableItems();
						data.bringToLive(this.getClass(), this);
						if ((parent != this) && (parent != null))
							BatchUpdateIDsFromObjects.INSTANCE.process(parent);
						
					}
				else if ((!isDefault) && (changed))
					{
						data.modifyObject(this.getClass(), this, fieldID);
						// if (this.parent!=null)
						// data.modifyObject(this.parent.getClass(), this.parent,
						// ActionTypes.EO_UPDATED_COMPONENT_AID);
					}
				updated = true;
				if (this instanceof QualityAssured)
					((QualityAssured) this).getQA().reset();
				EffectopediaObject eo = parent;
				while ((eo != null) && !(eo instanceof QualityAssured))
					eo = eo.getParent();
				if ((eo != null) && (eo instanceof QualityAssured))
					((QualityAssured) eo).getQA().reset();
			}
			
		public void updateSearchableItems()
			{
				
			}
			
		public void updateProperty(DataValue<?> oldValue, DataValue<?> newValue)
			{
				Effectopedia.EFFECTOPEDIA.getData().updateSearchIndices(oldValue, newValue);
			}
			
		public void cloneFieldsTo(EffectopediaObject clone)
			{
				// Negative ID Revolution
				if (CLONEIDs)
					{
						super.cloneFieldsTo(clone);
						clone.defaultID = this.defaultID;
					}
				else
					idMAP.put(getID(), clone);
			}
			
		public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
			}
			
		public void cloneFieldsTo(EffectopediaObject clone, DataSource dataSource)
			{
				clone.defaultID = this.defaultID;
				if ((defaultID != NON_DEFAULT) || CLONEIDs)
					super.cloneFieldsTo(clone);
				else
					{
						clone.autoSetId();
						if (dataSource.isCreateLive())
							dataSource.bringToLive(clone.getClass(), clone);
						idMAP.put(getID(), clone);
					}
			}
			
		@Override
		public EffectopediaObject clone()
			{
				EffectopediaObject clone = new EffectopediaObject(null, dataSource);
				cloneFieldsTo(clone, dataSource);
				clone.setParent(parent);
				return clone;
			}
			
		public EffectopediaObject clone(EffectopediaObject parent, DataSource dataSource)
			{
				EffectopediaObject clone = new EffectopediaObject(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				setParent(addID_OffsetIfNeeded(parent, dataSource));
				return clone;
			}
			
		public static EffectopediaObject addID_OffsetIfNeeded(EffectopediaObject eo, DataSource dataSource)
			{
				if ((eo != null) && (eo.dataSource != dataSource) && (!eo.isDefaultID()) && (ID_OFFSET != 0))
					{
						EffectopediaObject eoClone;
						try
							{
								eoClone = eo.getClass().newInstance();
								eoClone.setID(eo.getID() + ID_OFFSET);
								eoClone.setDataSource(dataSource);
								eoClone.setParent(eoClone);
								return eoClone;
							}
						catch (InstantiationException | IllegalAccessException e)
							{
								e.printStackTrace();
							}
					}
				return eo;
			}
			
		public void reloadReferredObjectsFromID()
			{
				if ((parent != null) && (dataSource != null))
					parent = dataSource.get(parent.getClass(), parent.getID());
			}
			
		static public long getDefaultID(BaseIOElement element)
			{
				if (element == null)
					return NON_DEFAULT;
				BaseIOAttribute a = element.getAttribute("defaultID");
				if (a != null)
					return a.getLongValue();
				return NON_DEFAULT;
			}
			
		static public long getExternalID(BaseIOElement element)
			{
				BaseIOAttribute a = element.getAttribute("id");
				return a.getLongValue();
			}
			
		public static void loadIDs(EffectopediaObject eo, BaseIOElement element, BaseIO io)
			{
				long loadDefaultID = NON_DEFAULT;
				BaseIOAttribute a = element.getAttribute("DefaultID");
				if (a != null)
					{
						// Negative ID Revolution
						loadDefaultID = a.getLongValue();
						eo.externalID = loadDefaultID;
						eo.setID(loadDefaultID);
					}
				else
					{
						a = element.getAttribute("id");
						if (a != null)
							eo.externalID = a.getLongValue();
						if ((eo.getID() == 0) || (eo.isDefaultID() && (loadDefaultID == NON_DEFAULT)))
							{
								eo.autoSetId();
								eo.setDefaultID(NON_DEFAULT);
							}
					}
				a = element.getAttribute("readonly");
				if (a != null)
					eo.setReadonly(a.getBooleanValue());
			}
			
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						loadIDs(this, element, io);
						Effectopedia.EFFECTOPEDIA.getData().bringToLive(this.getClass(), this);
					}
				else
					externalID = 0;
			}
			
		public void updateExternalID(BaseIOElement element)
			{
				if (element != null)
					{
						BaseIOAttribute a = element.getAttribute("id");
						if (a != null)
							this.externalID = a.getLongValue();
					}
			}
			
		public static BaseIOElement storeIDs(EffectopediaObject eo, BaseIOElement element, BaseIO io)
			{
				if (eo.externalID == 0)
					eo.externalID = Effectopedia.EFFECTOPEDIA.getData().autoExternalID(eo);
				element.setAttribute("id", eo.externalID);
				if (eo.defaultID != 0)
					element.setAttribute("defaultID", eo.defaultID);
				if (eo.readonly == true)
					element.setAttribute("readonly", true);
				return element;
			}
			
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				return storeIDs(this, element, io);
			}
			
		public EffectopediaObject getParent()
			{
				return parent;
			}
			
		public void setParent(EffectopediaObject parent)
			{
				/*
				 * if ((this.parent != null))
				 * System.out.println("!!!Warninig parent change \t" + this + "\t" +
				 * this.hashCode() + " with class " + this.getClass().getSimpleName() +
				 * "\twith parent " + parent + " with class " + ((parent == null) ? "null" :
				 * parent.getClass().getSimpleName()) + "\treplacing\t" + this.parent);
				 */
				this.parent = parent;
				/*
				 * EffectopediaObject defaultObject =
				 * getEffectopediaObjectByDefaultID(this.defaultID); if ((defaultObject ==
				 * this)) System.out.println("!!!Warninig set parent to defailt object \t" +
				 * this + "\t" + this.hashCode() + " with class " +
				 * this.getClass().getSimpleName() + "\twith parent " + parent +
				 * " with class " + ((parent == null) ? "null" :
				 * parent.getClass().getSimpleName()));
				 */
			}
			
		@SuppressWarnings("unchecked")
		public static <T extends EffectopediaObject> T cloneIfDefault(T object, EffectopediaObject parent, DataSource dataSource)
			{
				if (object != null)
					if ((object.getID() == object.getDefaultID()))
						{
							T cl = (T) object.clone(parent, dataSource);
							cl.setParent(parent);
							return cl;
						}
					else
						object.setParent(parent);
				return object;
			}
			
		@SuppressWarnings("unchecked")
		public static <T extends EffectopediaObject> T cloneIfInDefaultObjects(T object, EffectopediaObject parent, DataSource dataSource)
			{
				if (object != null)
					{
						T defaultObject = (T) defaultObjects.get(object.getDefaultID());
						if (object == defaultObject)
							{
								T cl = (T) object.clone(parent, dataSource);
								return cl;
							}
						else
							{
								if ((defaultObject != null) && (object.hasEqualIDs(defaultObject)))
									defaultObjects.put(object.getID(), object);
								object.replaceDefaultObjectsWtihClones();
							}
					}
				return object;
			}
			
		public boolean hasEqualIDs(EffectopediaObject eo)
			{
				return (defaultID == eo.defaultID) && (externalID == eo.externalID) && (getID() == eo.getID());
			}
			
		public void getContainedEffectopediaObjects(ArrayList<EffectopediaObject> list)
			{
				list.add(this);
			}
			
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				containedIDs.put(getID(), this);
			}
			
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				if ((getExternalID() == 0) && (defaultID != NON_DEFAULT))
					setExternalID(EffectopediaObject.getExternalIDByDefaultID(defaultID));
				containedIDs.put(getExternalID(), this);
			}
			
		public void replaceDefaultObjectsWtihClones()
			{
			}
			
		public void replaceArchivedObjectsWtihClones()
			{
			}
			
		public void process(BatchProcessor batch)
			{
				batch.process(this);
			}
			
		@Override
		public void autoSetId()
			{
				if (EffectopediaObject.getDefaultObjects().get(this.getDefaultID()) == this)
					System.err.println("Effectopedia Error: Trying to modify defailt object: " + this.DEBUG_getIDs());
				this.setID(autoId());
			}
			
		public long autoId()
			{
				return effectopediaObjectIDs++;
			}
			
		public boolean isDefaultID()
			{
				return defaultID != NON_DEFAULT;
			}
			
		public long getDefaultID()
			{
				return defaultID;
			}
			
		public void setDefaultID(long defualtID)
			{
				this.defaultID = defualtID;
			}
			
		public final boolean isUpdated()
			{
				return updated;
			}
			
		public final void setUpdated(boolean updated)
			{
				this.updated = updated;
			}
			
		@SuppressWarnings("unchecked")
		public <T extends EffectopediaObject> T makeItDefault()
			{
				// Negative ID Revolution
				setID(DefaultIDs);
				setExternalID(DefaultIDs);
				setDefaultID(DefaultIDs--);
				// autoSetId();
				// setDefaultID(DefaultIDs++);
				defaultObjects.put(getDefaultID(), this);
				Effectopedia.EFFECTOPEDIA.getData().bringToLive(this.getClass(), this);
				return (T) this;
			}
			
		protected void updateSearchableProperties()
			{
				searchableProperties.clear();
				AllClassFields fields = new AllClassFields(this.getClass());
				try
					{
						for (int i = 0; i < fields.size(); i++)
							if (DataValue.class.isAssignableFrom(fields.get(i).getType()))
								{
									DataValue<?> dataValue;
									dataValue = (DataValue<?>) fields.get(i).get(this);
									searchableProperties.add(dataValue);
								}
					}
				catch (IllegalArgumentException e)
					{
						e.printStackTrace();
					}
				catch (IllegalAccessException e)
					{
						e.printStackTrace();
					}
			}
			
		public DataValues getSearchablePoperties()
			{
				if (searchableProperties == null)
					{
						searchableProperties = new DataValues();
						updateSearchableProperties();
					}
				return searchableProperties;
			}
			
		public void cloneIDs(EffectopediaObject eo)
			{
				if (eo != null)
					{
						eo.setDefaultID(this.defaultID);
						eo.setID(this.getID());
						eo.setExternalID(this.getExternalID());
					}
			}
			
		public static long getDefaultIDs()
			{
				return DefaultIDs;
			}
			
		public static HashMap<Long, EffectopediaObject> getDefaultObjects()
			{
				return defaultObjects;
			}
			
		public String getIDsDescription()
			{
				return "ID:" + this.getID() + " ExternalID:" + this.getExternalID() + " DefaultID:" + this.defaultID;
			}
			
		public boolean isReadonly()
			{
				return readonly;
			}
			
		public void setReadonly(boolean readonly)
			{
				this.readonly = readonly;
			}
			
		public static void clearDefaultObectsExternalIds()
			{
				Iterator<Map.Entry<Long, EffectopediaObject>> it = defaultObjects.entrySet().iterator();
				while (it.hasNext())
					{
						EffectopediaObject eo = it.next().getValue();
						eo.process(BatchSetExternalIDToZero.INSTANCE);
					}
			}
			
		public EffectopediaObject makeItReadonly()
			{
				setReadonly(true);
				return this;
			}
			
		public void updateClonedReferrals()
			{
				updateReferrals(idMAP);
			}
			
		public void updateReferrals(HashMap<Long, EffectopediaObject> referrals)
			{
				if (parent != null)
					{
						EffectopediaObject newParent = referrals.get(parent.getID());
						if (newParent != null)
							this.parent = newParent;
					}
			}
			
		public void updateReferrals(DataSourceMerge dsm)
			{
				if ((parent != null) && (dataSource != null))
					this.parent = dsm.get(dataSource, parent);
			}
			
		public static void makeItAndAllContainedObjectsReadonly(EffectopediaObject eo)
			{
				if (eo == null)
					return;
				LinkedHashMap<Long, EffectopediaObject> containedIDs = new LinkedHashMap<Long, EffectopediaObject>();
				eo.getContainedIDs(containedIDs, true);
				Iterator<Map.Entry<Long, EffectopediaObject>> it = containedIDs.entrySet().iterator();
				while (it.hasNext())
					{
						EffectopediaObject e = it.next().getValue();
						e.process(BatchSetReadOnlyToTrue.INSTANCE);
					}
			}
			
		public static EffectopediaObject getParentOfCertainClass(EffectopediaObject eo, Class<? extends EffectopediaObject> parentClass)
			{
				if ((eo == null) || (parentClass == null))
					return null;
				while (!eo.getClass().isAssignableFrom(parentClass))
					{
						EffectopediaObject p = eo.getParent();
						if (p == null)
							break;
						else
							eo = p;
					}
				return eo;
			}
			
		public final DataSource getDataSource()
			{
				return dataSource;
			}
			
		public final void setDataSource(DataSource dataSource)
			{
				this.dataSource = dataSource;
			}
			
		public String DEBUG_getIDs()
			{
				StringBuilder sb = new StringBuilder();
				sb.append("\tclass\t");
				sb.append(getClass());
				sb.append("\tdefaultID\t");
				sb.append(defaultID);
				sb.append("\tID\t");
				sb.append(getID());
				sb.append("\texternalID\t");
				sb.append(externalID);
				return sb.toString();
			}
			
		public static EffectopediaObject getEffectopediaObjectByDefaultID(long defaultID)
			{
				return defaultObjects.get(defaultID);
			}
			
		public static EffectopediaObject getDefaultObjectCloneByDefaultID(long defaultID)
			{
				EffectopediaObject deo = defaultObjects.get(defaultID);
				return deo != null ? deo.clone() : null;
			}
			
		public static long getExternalIDByDefaultID(long defaultID)
			{
				EffectopediaObject eo = defaultObjects.get(defaultID);
				return eo == null ? 0 : eo.getExternalID();
			}
			
		public static void updateDefaultObjectsParenthood()
			{
				Iterator<Map.Entry<Long, EffectopediaObject>> it = defaultObjects.entrySet().iterator();
				while (it.hasNext())
					it.next().getValue().updateParenthood();
			}
			
		public static void initDefaultObjects()
			{
				Iterator<Map.Entry<Long, EffectopediaObject>> it = defaultObjects.entrySet().iterator();
				while (it.hasNext())
					it.next().getValue().init(true);
			}
			
		public static void DEBUG_printDefaultObjects()
			{
				Iterator<Map.Entry<Long, EffectopediaObject>> it = defaultObjects.entrySet().iterator();
				while (it.hasNext())
					{
						EffectopediaObject eo = it.next().getValue();
						System.out.println("EffectopediaObject.defaultObjects:" + eo.DEBUG_getIDs() + "\t" + eo);
					}
			}
			
		public static void DEBUG_printContainedIDs(EffectopediaObject eo)
			{
				System.out.println("EffectopediaObject.containedIDs***:" + eo.DEBUG_getIDs());
				LinkedHashMap<Long, EffectopediaObject> containedIds = new LinkedHashMap<>();
				eo.getContainedIDs(containedIds, true);
				Iterator<Map.Entry<Long, EffectopediaObject>> it = containedIds.entrySet().iterator();
				while (it.hasNext())
					{
						EffectopediaObject containedEO = it.next().getValue();
						System.out.println("EffectopediaObject.containedIDs:" + containedEO.DEBUG_getIDs() + "\t" + containedEO);
					}
			}
			
		public static <E extends EffectopediaObject> E updateParent(E eo, EffectopediaObject parent)
			{
				if (eo.getParent() == parent)
					return eo;
				else
					{
						E clone = cloneIfDefault(eo, parent, parent.dataSource);
						return clone;
					}
			}
			
		public static void updateDefaultObjectExternalIDs(LinkedHashMap<Long, EffectopediaObject> ids)
			{
				Iterator<Map.Entry<Long, EffectopediaObject>> it = ids.entrySet().iterator();
				while (it.hasNext())
					{
						EffectopediaObject eo = it.next().getValue();
						if (!eo.isDefaultID())
							continue;
						// Negative ID Revolution
						eo.setExternalID(eo.defaultID);
						// EffectopediaObject def = defaultObjects.get(eo.defaultID);
						// if (def.externalID == 0)
						// def.setExternalID(eo.externalID);
					}
			}
			
		public static HashMap<Long, EffectopediaObject>				idMAP																	= new HashMap<Long, EffectopediaObject>();
		public static boolean																														CLONEIDs														= true;
		public static final long																											NON_DEFAULT											= 0;
		private DataValues																																	searchableProperties;
		private long																																							defaultID													= NON_DEFAULT;
		protected boolean																																		updated;
		protected boolean																																		readonly														= false;
		protected EffectopediaObject																							parent;
		public static long																																	effectopediaObjectIDs	= 1;
		protected static HashMap<Long, EffectopediaObject>	defaultObjects								= new HashMap<Long, EffectopediaObject>();
		protected DataSource																															dataSource;
		protected static long																														DefaultIDs												= -1;
	}
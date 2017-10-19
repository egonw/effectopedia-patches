package org.qsari.effectopedia.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.data.objects.DataValue;
import org.qsari.effectopedia.data.objects.DataValue_Double;
import org.qsari.effectopedia.data.objects.DataValue_Float;
import org.qsari.effectopedia.data.objects.DataValue_IntRef;
import org.qsari.effectopedia.data.objects.DataValue_Integer;
import org.qsari.effectopedia.data.objects.DataValue_Interval;
import org.qsari.effectopedia.data.objects.DataValue_List;
import org.qsari.effectopedia.data.objects.DataValue_Long;
import org.qsari.effectopedia.data.objects.DataValue_LongRef;
import org.qsari.effectopedia.data.objects.DataValue_String;
import org.qsari.effectopedia.data.objects.FixedValuesList;
import org.qsari.effectopedia.defaults.DefaultFixedListValues;
import org.qsari.effectopedia.defaults.DefaultTextProperties;

public class SearchIndices
	{
		public SearchIndices()
			{
				super();
				indices = new HashMap<String, SearchIndex<?>>();
				titles = new SearchIndex_Hash<String>(TITLE_INDEX, String.class);
				indices.put(TITLE_INDEX, titles);
				authors = new SearchIndex_Hash<String>(AUTHOR_INDEX, String.class);
				indices.put(AUTHOR_INDEX, authors);
				groups = new SearchIndex_Hash<String>(GROUP_INDEX, String.class);
				indices.put(GROUP_INDEX, groups);
				keywords = new SearchIndex_Hash<String>(KEYWORDS_INDEX, String.class);
				indices.put(KEYWORDS_INDEX, keywords);
				lbo = new SearchIndex_Hash_Fixed(LBO, ((FixedValuesList) DefaultFixedListValues.INSTANCE.getList("DEFAULT_LBO_LIST")).getList());
				indices.put(LBO, lbo);
				lifeStage = new SearchIndex_Hash_Fixed(LIFE_STAGE, ((FixedValuesList) DefaultFixedListValues.INSTANCE.getList("DEFAULT_LIFE_STAGE_LIST")).getList());
				indices.put(LIFE_STAGE, lifeStage);
				location = new SearchIndex_Hash<String>(LOCATION, String.class);
				indices.put(LOCATION, location);
				taxonomy = new SearchIndex_Hash_Fixed(TAXONOMY, ((FixedValuesList) DefaultFixedListValues.INSTANCE.getList("DEFAULT_TAXONOMY_LIST")).getList());
				indices.put(TAXONOMY, taxonomy);
				sex = new SearchIndex_Hash_Fixed(SEX, ((FixedValuesList) DefaultFixedListValues.INSTANCE.getList("DEFAULT_SEX_LIST")).getList());
				indices.put(SEX, sex);
				term = new SearchIndex_Hash_Fixed(TERM, ((FixedValuesList) DefaultFixedListValues.INSTANCE.getList("DEFAULT_EFFECT_TERM_LIST")).getList());
				indices.put(TERM, term);
				timeToEffect = new SearchIndex_Hash<Double>(TIME_TO_EFFECT, Double.class);
				indices.put(TIME_TO_EFFECT, timeToEffect);
				generation = new SearchIndex_Hash_Fixed(GENERATION, ((FixedValuesList) DefaultFixedListValues.INSTANCE.getList("DEFAULT_GENERATION_LIST")).getList());
				indices.put(GENERATION, generation);
				
				indices.put(CHEMICAL_CASNO, new SearchIndex_Hash<Integer>(CHEMICAL_CASNO, Integer.class));
				indices.put(CHEMICAL_IUPAC_NAME, new SearchIndex_Hash<String>(CHEMICAL_IUPAC_NAME, String.class));
				indices.put(CHEMICAL_SMILES, new SearchIndex_Hash<String>(CHEMICAL_SMILES, String.class));
				indices.put(CHEMICAL_INCHI, new SearchIndex_Hash<String>(CHEMICAL_INCHI, String.class));
				indices.put(CHEMICAL_INCHI_KEY, new SearchIndex_Hash<String>(CHEMICAL_INCHI_KEY, String.class));
				indices.put(CHEMICAL_MOL_FORMULA, new SearchIndex_Hash<String>(CHEMICAL_MOL_FORMULA, String.class));
				
				indices.put(TITLE_INDEX, titles);
				uuid = new SearchIndex_Hash<String>(UUID, String.class);
				indices.put(UUID, uuid);
				
				uids = new SearchIndex_Hash<String>(UIDS, String.class);
				indices.put(UIDS, uids);
				
				status = new SearchIndex_Hash<String>(STATUS, String.class);
				indices.put(STATUS, status);

				target_site = new SearchIndex_Hash<String>(TARGET_INDEX, String.class);
				indices.put(TARGET_INDEX, target_site);
			}
		
		public void update(DataValue<?> oldValue, DataValue<?> newValue)
			{
				// TODO Make DataSource field of IndexedObject and do not make global calls
				if (!Effectopedia.getEffectopedia().getData().isCreateLive())
					return;
				// System.out.println("OldValue="+((oldValue==null)?"null":oldValue.getSearchItem().object
				// +
				// " "+oldValue.getSearchItem().object.getIDsDescription())+"NewValue="+((newValue==null)?"null":newValue.getSearchItem().object+" "+newValue.getSearchItem().object.getIDsDescription()));
				if (updateCache == null)
					updateCache = new UpdateCache(oldValue, newValue);
				else
					updateCache.update(oldValue, newValue);
			}
		
		public void finalizeUpdates()
			{
				if (updateCache != null)
					{
						internalUpdate(updateCache.oldValue, updateCache.newValue);
						updateCache = null;
					}
			}
		
		@SuppressWarnings("unchecked")
		private void removeFromSearch(DataValue<?> value)
			{
				SearchableItem item = value.getSearchItem();
				if (value instanceof DataValue_Double)
					{
						SearchIndex<Double> index = (SearchIndex<Double>) indices.get(item.getSearchName());
						index.remove(((DataValue_Double) value).getValue(), item);
					}
				else if (value instanceof DataValue_Float)
					{
						SearchIndex<Float> index = (SearchIndex<Float>) indices.get(item.getSearchName());
						index.remove(((DataValue_Float) value).getValue(), item);
					}
				else if (value instanceof DataValue_Integer)
					{
						SearchIndex<Integer> index = (SearchIndex<Integer>) indices.get(item.getSearchName());
						index.remove(((DataValue_Integer) value).getValue(), item);
					}
				else if (value instanceof DataValue_Interval<?>)
					{
						// TODO
					}
				else if (value instanceof DataValue_List<?>)
					{
						for (DataValue<?> v : (ArrayList<DataValue<?>>) ((DataValue_List<?>) value).getValue())
							removeFromSearch(v);
					}
				else if (value instanceof DataValue_Long)
					{
						SearchIndex<Long> index = (SearchIndex<Long>) indices.get(item.getSearchName());
						index.remove(((DataValue_Long) value).getValue(), item);
					}
				else if (value instanceof DataValue_LongRef)
					{
						SearchIndex<Long> index = (SearchIndex<Long>) indices.get(item.getSearchName());
						index.remove(((DataValue_LongRef) value).getValue(), item);
					}
				else if (value instanceof DataValue_String)
					{
						SearchIndex<String> index = (SearchIndex<String>) indices.get(item.getSearchName());
						String v = ((DataValue_String) value).getValue();
						if (v != null)
							{
								StringTokenizer st = new StringTokenizer(v, " \t");
								while (st.hasMoreTokens())
									index.remove(st.nextToken(), item);
							}
					}
			}
		
		@SuppressWarnings("unchecked")
		private void addToSearch(DataValue<?> value)
			{
				SearchableItem item = value.getSearchItem();
				if (value instanceof DataValue_Double)
					{
						SearchIndex<Double> index = (SearchIndex<Double>) indices.get(item.getSearchName());
						index.add(((DataValue_Double) value).getValue(), item);
					}
				else if (value instanceof DataValue_Float)
					{
						SearchIndex<Float> index = (SearchIndex<Float>) indices.get(item.getSearchName());
						index.add(((DataValue_Float) value).getValue(), item);
					}
				else if (value instanceof DataValue_Integer)
					{
						SearchIndex<Integer> index = (SearchIndex<Integer>) indices.get(item.getSearchName());
						index.add(((DataValue_Integer) value).getValue(), item);
					}
				else if (value instanceof DataValue_Interval<?>)
					{
						// TODO
					}
				else if (value instanceof DataValue_List<?>)
					{
						for (DataValue<?> v : (ArrayList<DataValue<?>>) ((DataValue_List<?>) value).getValue())
							addToSearch(v);
					}
				else if (value instanceof DataValue_Long)
					{
						SearchIndex<Long> index = (SearchIndex<Long>) indices.get(item.getSearchName());
						index.add(((DataValue_Long) value).getValue(), item);
					}
				else if (value instanceof DataValue_LongRef)
					{
						SearchIndex<Long> index = (SearchIndex<Long>) indices.get(item.getSearchName());
						index.add(((DataValue_LongRef) value).getValue(), item);
					}
				else if (value instanceof DataValue_String)
					{
						SearchIndex<String> index = (SearchIndex<String>) indices.get(item.getSearchName());
						String v = ((DataValue_String) value).getValue();
						if (v != null)
							{
								StringTokenizer st = new StringTokenizer(v, " \t");
								while (st.hasMoreTokens())
									index.add(st.nextToken().toLowerCase(), item);
							}
					}
			}
		
		@SuppressWarnings("unchecked")
		private void updateSearch(DataValue<?> oldValue, DataValue<?> newValue)
			{
				SearchableItem item = newValue.getSearchItem();
				if (newValue instanceof DataValue_Double)
					{
						SearchIndex<Double> index = (SearchIndex<Double>) indices.get(item.getSearchName());
						index.remove(((DataValue_Double) oldValue).getValue(), item);
						index.add(((DataValue_Double) newValue).getValue(), item);
					}
				else if (newValue instanceof DataValue_Float)
					{
						SearchIndex<Float> index = (SearchIndex<Float>) indices.get(item.getSearchName());
						index.remove(((DataValue_Float) oldValue).getValue(), item);
						index.add(((DataValue_Float) newValue).getValue(), item);
					}
				else if (newValue instanceof DataValue_IntRef)
					{
						SearchIndex_Hash_Fixed index = (SearchIndex_Hash_Fixed) indices.get(item.getSearchName());
						index.remove(((DataValue_IntRef) oldValue).getValue(), item);
						index.add(((DataValue_IntRef) newValue).getValue(), item);
					}
				else if (newValue instanceof DataValue_Integer)
					{
						SearchIndex<Integer> index = (SearchIndex<Integer>) indices.get(item.getSearchName());
						index.remove(((DataValue_Integer) oldValue).getValue(), item);
						index.add(((DataValue_Integer) newValue).getValue(), item);
					}
				else if (newValue instanceof DataValue_Interval<?>)
					{
						// TODO
					}
				else if (newValue instanceof DataValue_List<?>)
					{
						HashSet<DataValue<?>> oldValues = new HashSet<DataValue<?>>();
						if (oldValue.getValue() != null)
							oldValues.addAll((ArrayList<DataValue<? extends DataValue<?>>>) (oldValue).getValue());
						HashSet<DataValue<?>> newValues = new HashSet<DataValue<?>>();
						if (newValue.getValue() != null)
							newValues.addAll((ArrayList<DataValue<? extends DataValue<?>>>) (newValue).getValue());
						HashSet<DataValue<?>> intersection = new HashSet<DataValue<?>>();
						intersection.addAll(oldValues);
						intersection.retainAll(newValues);
						oldValues.removeAll(intersection);
						newValues.removeAll(intersection);
						for (DataValue<?> v : oldValues)
							removeFromSearch(v);
						for (DataValue<?> v : newValues)
							addToSearch(v);
					}
				else if (newValue instanceof DataValue_LongRef)
					{
						SearchIndex_Hash_Fixed index = (SearchIndex_Hash_Fixed) indices.get(item.getSearchName());
						index.remove(((DataValue_LongRef) oldValue).getValue(), item);
						index.add(((DataValue_LongRef) newValue).getValue(), item);
					}
				else if (newValue instanceof DataValue_Long)
					{
						SearchIndex<Long> index = (SearchIndex<Long>) indices.get(item.getSearchName());
						index.remove(((DataValue_Long) oldValue).getValue(), item);
						index.add(((DataValue_Long) newValue).getValue(), item);
					}
				else if (newValue instanceof DataValue_String)
					{
						SearchIndex<String> index = (SearchIndex<String>) indices.get(item.getSearchName());
						String oldV = ((DataValue_String) oldValue).getValue();
						String newV = ((DataValue_String) newValue).getValue();
						if (oldV == null)
							if (newV == null)
								return;
							else
								{
									StringTokenizer st = new StringTokenizer(newV.toLowerCase(), " \t");
									while (st.hasMoreTokens())
										index.add(st.nextToken(), item);
									return;
								}
						else if (newV == null)
							{
								StringTokenizer st = new StringTokenizer(oldV.toLowerCase(), " \t");
								while (st.hasMoreTokens())
									index.remove(st.nextToken(), item);
								return;
							}
						HashSet<String> oldValues = new HashSet<String>();
						StringTokenizer st = new StringTokenizer(oldV.toLowerCase(), " \t");
						while (st.hasMoreTokens())
							oldValues.add(st.nextToken());
						HashSet<String> newValues = new HashSet<String>();
						st = new StringTokenizer(newV.toLowerCase(), " \t");
						while (st.hasMoreTokens())
							newValues.add(st.nextToken());
						HashSet<String> intersection = new HashSet<String>();
						intersection.addAll(oldValues);
						intersection.retainAll(newValues);
						oldValues.removeAll(intersection);
						newValues.removeAll(intersection);
						for (String v : oldValues)
							index.remove(v, item);
						for (String v : newValues)
							index.add(v, item);
					}
			}
		
		public void internalUpdate(DataValue<?> oldValue, DataValue<?> newValue)
			{
				if (oldValue == null)
					if (newValue == null)
						return;
					else
						addToSearch(newValue);
				else // oldValue!=null
				if (newValue == null)
					removeFromSearch(oldValue);
				else
					updateSearch(oldValue, newValue);
			}
		
		public boolean isAutoUpdating()
			{
				return autoUpdating;
			}
		
		public void setAutoUpdating(boolean autoUpdating)
			{
				this.autoUpdating = autoUpdating;
			}
		
		private class UpdateCache
			{
				UpdateCache(DataValue<?> oldValue, DataValue<?> newValue)
					{
						if (oldValue != null)
							item = oldValue.getSearchItem();
						else if (newValue != null)
							item = newValue.getSearchItem();
						this.oldValue = oldValue;
						this.newValue = newValue;
					}
				
				public void update(DataValue<?> oldValue, DataValue<?> newValue)
					{
						if (((oldValue != null) && (oldValue.getSearchItem().equals(item))) || (newValue != null) && (newValue.getSearchItem().equals(item)))
							{
								this.newValue = newValue;
								// System.out.println("using cache for" + newValue.getDisplayValue());
							}
						else
							{
								internalUpdate(this.oldValue, this.newValue);
								if (oldValue != null)
									item = oldValue.getSearchItem();
								else if (newValue != null)
									item = newValue.getSearchItem();
								this.oldValue = oldValue;
								this.newValue = newValue;
							}
					}
				
				public DataValue<?>			oldValue;
				public DataValue<?>			newValue;
				public SearchableItem	item;
			}
		
		public SearchIndex<?> getIndexByName(String indexName)
			{
				return indices.get(indexName);
			}
		
		public static interface SearchableItemFilter
			{
				public boolean match(SearchableItem sa);
			}
		
		@SuppressWarnings("unchecked")
		public void copyRelevantIndices(SearchIndices source, SearchableItemFilter filter)
			{
				Iterator<Entry<String, SearchIndex<?>>> it = source.indices.entrySet().iterator();
				while (it.hasNext())
					{
						Entry<String, SearchIndex<?>> entry = it.next();
						String indexName = entry.getKey();
						SearchIndex<?> searchIndex = entry.getValue();
						SearchIndex<?> targetIndex = indices.get(indexName);
						if (targetIndex instanceof SearchIndex_Hash)
							if (targetIndex.dataType.equals(String.class))
								((SearchIndex_Hash<String>) targetIndex).putAllMatching((SearchIndex_Hash<String>) searchIndex, filter);
							else if (targetIndex.dataType.equals(Double.class))
								((SearchIndex_Hash<Double>) targetIndex).putAllMatching((SearchIndex_Hash<Double>) searchIndex, filter);
					}
			}
		
		@SuppressWarnings("unchecked")
		public void copyAllIndices(SearchIndices source)
			{
				Iterator<Entry<String, SearchIndex<?>>> it = source.indices.entrySet().iterator();
				while (it.hasNext())
					{
						Entry<String, SearchIndex<?>> entry = it.next();
						String indexName = entry.getKey();
						SearchIndex<?> searchIndex = entry.getValue();
						SearchIndex<?> targetIndex = indices.get(indexName);
						if (targetIndex instanceof SearchIndex_Hash)
							if (targetIndex.dataType.equals(String.class))
								((SearchIndex_Hash<String>) targetIndex).putAll((SearchIndex_Hash<String>) searchIndex);
							else if (targetIndex.dataType.equals(Double.class))
								((SearchIndex_Hash<Double>) targetIndex).putAll((SearchIndex_Hash<Double>) searchIndex);
					}
			}
		
		protected SearchIndex_Hash<String>						titles;
		protected SearchIndex_Hash<String>						authors;
		protected SearchIndex_Hash<String>						groups;
		protected SearchIndex_Hash<String>						keywords;
		protected SearchIndex_Hash_Fixed								lbo;
		protected SearchIndex_Hash_Fixed								lifeStage;
		protected SearchIndex_Hash<String>						location;
		protected SearchIndex_Hash<String>						taxonomy;
		protected SearchIndex_Hash_Fixed								sex;
		protected SearchIndex_Hash_Fixed								generation;
		protected SearchIndex_Hash_Fixed								term;
		protected SearchIndex_Hash<Double>						timeToEffect;
		protected SearchIndex_Hash<String>						uids;
		protected SearchIndex_Hash<String>						status;
		protected SearchIndex_Hash<String>						target_site;
		
		protected SearchIndex_Hash<String>						uuid;
		
		private HashMap<String, SearchIndex<?>>	indices;
		
		private boolean																									autoUpdating									= true;
		private UpdateCache																					updateCache;
		
		public static final String														TITLE_INDEX										= "title";
		public static final String														AUTHOR_INDEX									= "author";
		public static final String														GROUP_INDEX										= "groups";
		public static final String														KEYWORDS_INDEX							= "keywords";
		public static final String														LBO																		= DefaultTextProperties.INSTANCE.getDefault("DEFAULT_LBO_NAME");
		public static final String														LIFE_STAGE											= DefaultTextProperties.INSTANCE.getDefault("DEFAULT_LIFE_STAGE_NAME");
		public static final String														LOCATION													= DefaultTextProperties.INSTANCE.getDefault("DEFAULT_BIO_COMPARTMENT_NAME");
		public static final String														TAXONOMY													= DefaultTextProperties.INSTANCE.getDefault("DEFAULT_TAXONOMY_NAME");
		public static final String														SEX																		= DefaultTextProperties.INSTANCE.getDefault("DEFAULT_SEX_NAME");
		public static final String														TERM																	= DefaultTextProperties.INSTANCE.getDefault("DEFAULT_EFFECT_TERM_NAME");
		public static final String														TIME_TO_EFFECT							= DefaultTextProperties.INSTANCE.getDefault("DEFAULT_TIME_TO_EFFECT_NAME");
		public static final String														GENERATION											= DefaultTextProperties.INSTANCE.getDefault("DEFAULT_GENERATION_NAME");
		public static final String														TARGET_INDEX									= "target_site";
		
		public static final String														CHEMICAL_CASNO							= "cas";
		public static final String														CHEMICAL_IUPAC_NAME		= "iupac_name";
		public static final String														CHEMICAL_SMILES						= "smiles";
		public static final String														CHEMICAL_INCHI							= "inchi";
		public static final String														CHEMICAL_INCHI_KEY			= "inchi_key";
		public static final String														CHEMICAL_MOL_FORMULA	= "molecular_formula";
		public static final String														UIDS																	= "identifiers";
		public static final String														STATUS															= "status";
		
		public static final String														UUID																	= "uuid";
		
		public static final boolean													AUTOUPDATE											= true;
		public static final boolean													NO_AUTOUPDATE								= false;
	}

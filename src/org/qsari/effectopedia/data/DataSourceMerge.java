package org.qsari.effectopedia.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.qsari.effectopedia.base.Describable;
import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.ids.IDs;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.history.EditHistoryAction;
import org.qsari.effectopedia.history.SourceID;
import org.qsari.effectopedia.history.SourceTrace;
import org.qsari.effectopedia.history.Stamp;
import org.qsari.effectopedia.history.Stamps;
import org.qsari.effectopedia.utils.MultiIndexSortedList;
import org.qsari.effectopedia.utils.ValueComparator;

public class DataSourceMerge
	{
		public DataSourceMerge(DataSource A, DataSource B)
			{
				this.A = A;
				this.B = B;
				this.map = new HashMap<SourceID, EffectopediaObjectUnion>();
				historyMapA = A.getEditHistory().getObjectHistoryMap();
				historyMapB = B.getEditHistory().getObjectHistoryMap();
				maxStampID = Stamp.getStampIDs();
				buildMap();
				compare();
				
			}
			
		public class EffectopediaObjectUnion
			{
				public EffectopediaObjectUnion(SourceID sourceID)
					{
						this.sourceId = sourceID;
					}
					
				public final void setA(EffectopediaObject eoA)
					{
						this.eoA = eoA;
						this.IDA = eoA.getID();
						this.A = historyMapA.get(IDA);
					}
					
				public final void setB(EffectopediaObject eoB)
					{
						this.eoB = eoB;
						this.IDB = eoB.getID();
						this.B = historyMapB.get(IDB);
					}
					
				private void compare()
					{
						if (A == null)
							if (B == null)
								status = EQUAL;
							else
								status = MORE_OF_B;
						else if (B == null)
							status = MORE_OF_A;
						else
							status = deepCompare();
					}
					
				private int deepCompare()
					{
						int contained = compareContainedObjects();
						if (A.size() > B.size())
							return MORE_OF_A;
						else if (A.size() < B.size())
							return MORE_OF_B;
						else
							{
								Stamps stamps = Effectopedia.EFFECTOPEDIA.getStamps();
								for (int i = 0; i < A.size(); i++)
									{
										Stamp stampIdA = stamps.get((int) A.get(i).getStampId());
										Stamp stampIdB = stamps.get((int) B.get(i).getStampId());
										if (!stampIdA.equals(stampIdB))
											return DIFFERENT;
									}
								return contained;
							}
					}
					
				private int compareContainedObjects()
					{
						if (hasContainedEOU())
							for (EffectopediaObjectUnion eou : contained)
								if ((eou.getStatus() != EQUAL) || (eou.hasUpdatedObjectID()))
									return CONT_DIFFERENT;
						return EQUAL;
					}
					
				private boolean hasContainedEOU()
					{
						if (contained == null)
							{
								contained = new ArrayList<DataSourceMerge.EffectopediaObjectUnion>();
								LinkedHashMap<Long, EffectopediaObject> containedIDsA = new LinkedHashMap<Long, EffectopediaObject>();
								boolean includeOwned = (eoA instanceof IDs);
								if (eoA instanceof Pathway)
									eoA.getContainedIDs(containedIDsA, false);
								else
									eoA.getContainedIDs(containedIDsA, includeOwned);
								containedIDsA.remove(eoA.getID());
								if (containedIDsA.size() == 0)
									return false;
								LinkedHashMap<Long, EffectopediaObject> containedIDsB = new LinkedHashMap<Long, EffectopediaObject>();
								if (eoB instanceof Pathway)
									((Pathway) eoB).getContainedIDs(containedIDsB, false);
								else
									eoB.getContainedIDs(containedIDsB, includeOwned);
								containedIDsB.remove(eoB.getID());
								Iterator<EffectopediaObject> itA = containedIDsA.values().iterator();
								Iterator<EffectopediaObject> itB = containedIDsB.values().iterator();
								while (itA.hasNext())
									{
										EffectopediaObject contEOA = itA.next();
										EffectopediaObject contEOB = itB.next();
										SourceTrace st = DataSourceMerge.this.A.livePathwayElements.getSourceTraceByID(contEOA.getID());
										if (st != null)
											contained.add(DataSourceMerge.this.map.get(st.getSourceID()));
										else
											{
												EffectopediaObjectUnion eou = new EffectopediaObjectUnion(sourceId);
												eou.setA(contEOA);
												eou.setB(contEOB);
												contained.add(eou);
												eou.compare();
											}
									}
							}
						return contained.size() > 0;
					}
					
				private boolean hasUpdatedObjectID()
					{
						return ((eoA.getID() > 0) && (eoB.getID() < 0)) || ((eoA.getID() < 0) && (eoB.getID() > 0));
					}
					
				public boolean hasNonCoglictingHistory(ArrayList<EditHistoryAction> source, ArrayList<EditHistoryAction> destination)
					{
						if (status == EQUAL)
							return true;
						if (destination == null && source != null)
							return true;
						if (destination != null && source != null)
							{
								Stamps stamps = Effectopedia.EFFECTOPEDIA.getStamps();
								int commonCnt = Math.min(destination.size(), source.size());
								for (int i = 0; i < commonCnt; i++)
									{
										Stamp stampIdSrc = stamps.get((int) source.get(i).getStampId());
										Stamp stampIdDest = stamps.get((int) destination.get(i).getStampId());
										if (stampIdDest.getID()>=maxStampID)
											break;
										if (!stampIdSrc.equals(stampIdDest))
											return false;
									}
								return true;
							}
						return false;
					}
					
				public int getStatus()
					{
						return this.status;
					}
					
				public final long getIDA()
					{
						return IDA;
					}
					
				public final long getIDB()
					{
						return IDB;
					}
					
				public Class<? extends EffectopediaObject> getObjectClassA()
					{
						if ((A != null) && (A.size() > 0))
							return A.get(0).getObjectClass();
						return null;
					}
					
				public Class<? extends EffectopediaObject> getObjectClassB()
					{
						if ((B != null) && (B.size() > 0))
							return B.get(0).getObjectClass();
						return null;
					}
					
				public long getTimeStampIDA()
					{
						if ((A != null) && (A.size() > 0))
							return A.get(0).getStampId();
						return 0L;
					}
					
				public long getTimeStampIDB()
					{
						if ((B != null) && (B.size() > 0))
							return B.get(0).getStampId();
						return 0L;
					}
					
				public EffectopediaObject getEffectopediaObjectA()
					{
						return eoA;
					}
					
				public EffectopediaObject getEffectopediaObjectB()
					{
						return eoB;
					}
					
				public SourceID getSourceID()
					{
						return sourceId;
					}
					
				private int																																status									= EQUAL;
				private ArrayList<EditHistoryAction>							A														= null;
				private ArrayList<EditHistoryAction>							B														= null;
				private long																															IDA												= 0;
				private long																															IDB												= 0;
				private EffectopediaObject																	eoA												= null;
				private EffectopediaObject																	eoB												= null;
				private ArrayList<EffectopediaObjectUnion>	contained;
				
				public final SourceID																						sourceId;
				public static final int																				EQUAL										= 1;
				public static final int																				MORE_OF_A						= 2;
				public static final int																				MORE_OF_B						= 4;
				public static final int																				DIFFERENT						= 8;
				public static final int																				CONT_DIFFERENT	= 16;
				public static final int																				ALL												= EQUAL | MORE_OF_A | MORE_OF_B | DIFFERENT | CONT_DIFFERENT;
				public static final int																				ALL_DIFFERENT		= MORE_OF_A | MORE_OF_B | DIFFERENT | CONT_DIFFERENT;
			}
			
		public static class IDComparator implements ValueComparator<EffectopediaObjectUnion>
			{
				public int compareToValue(EffectopediaObjectUnion element, Object value)
					{
						if (element.getIDA() != 0)
							return ((Long) element.getIDA()).compareTo((Long) value);
						else
							return ((Long) element.getIDB()).compareTo((Long) value);
					}
					
				public int compare(EffectopediaObjectUnion o1, EffectopediaObjectUnion o2)
					{
						if (o1.getIDA() != 0)
							return ((Long) o1.getIDA()).compareTo((Long) o2.getIDA());
						else
							return ((Long) o1.getIDB()).compareTo((Long) o2.getIDB());
					}
			}
			
		public static class TimeStampIDComparator implements ValueComparator<EffectopediaObjectUnion>
			{
				public int compareToValue(EffectopediaObjectUnion element, Object value)
					{
						if (element.getTimeStampIDA() != 0)
							return ((Long) element.getTimeStampIDA()).compareTo((Long) value);
						else
							return ((Long) element.getTimeStampIDB()).compareTo((Long) value);
					}
					
				public int compare(EffectopediaObjectUnion o1, EffectopediaObjectUnion o2)
					{
						if (o1.getTimeStampIDA() != 0)
							return ((Long) o1.getTimeStampIDA()).compareTo((Long) o2.getTimeStampIDA());
						else
							return ((Long) o1.getTimeStampIDB()).compareTo((Long) o2.getTimeStampIDB());
					}
			}
			
		public static class ObjectNameComparator implements ValueComparator<EffectopediaObjectUnion>
			{
				public int compareToValue(EffectopediaObjectUnion element, Object value)
					{
						EffectopediaObject eo = element.getEffectopediaObjectA();
						if (eo == null)
							eo = element.getEffectopediaObjectB();
						if (eo != null)
							if (eo instanceof PathwayElement)
								if ((((PathwayElement) eo).getTitle().equals("")) && (eo instanceof Describable))
									return ((Describable) eo).getGenericDescription().compareTo(value.toString());
								else
									return ((PathwayElement) eo).getTitle().compareTo(value.toString());
							else if (eo instanceof Pathway)
								return ((Pathway) eo).getTitle().compareTo(value.toString());
						return 0;
					}
					
				public int compare(EffectopediaObjectUnion o1, EffectopediaObjectUnion o2)
					{
						EffectopediaObject eo1 = o1.getEffectopediaObjectA();
						EffectopediaObject eo2 = o2.getEffectopediaObjectA();
						if (eo1 == null)
							{
								eo1 = o1.getEffectopediaObjectB();
								eo2 = o2.getEffectopediaObjectB();
							}
						if ((eo1 != null) && (eo2 != null))
							if ((eo1 instanceof PathwayElement) && (eo2 instanceof PathwayElement))
								if ((((PathwayElement) eo1).getTitle().equals("")) && (eo1 instanceof Describable) && (((PathwayElement) eo2).getTitle().equals("")) && (eo2 instanceof Describable))
									return ((Describable) eo1).getGenericDescription().compareTo(((Describable) eo2).getGenericDescription());
								else
									return ((PathwayElement) eo1).getTitle().compareTo(((PathwayElement) eo2).getTitle());
							else if ((eo1 instanceof Pathway) && (eo2 instanceof Pathway))
								return ((Pathway) eo1).getTitle().compareTo(((Pathway) eo2).getTitle());
						return 0;
					}
			}
			
		public static class ClassNameComparator implements ValueComparator<EffectopediaObjectUnion>
			{
				public int compareToValue(EffectopediaObjectUnion element, Object value)
					{
						Class<?> c = element.getObjectClassA();
						if (c == null)
							c = element.getObjectClassB();
						if (c != null)
							return c.getName().compareTo(value.toString());
						return 0;
					}
					
				public int compare(EffectopediaObjectUnion o1, EffectopediaObjectUnion o2)
					{
						Class<?> c1 = o1.getObjectClassA();
						Class<?> c2 = o2.getObjectClassA();
						if (c1 == null)
							{
								c1 = o1.getObjectClassB();
								c2 = o2.getObjectClassB();
							}
						if ((c1 != null) && (c2 != null))
							return c1.getName().compareTo(c2.getName());
						return 0;
					}
			}
			
		private void buildMap()
			{
				HashMap<Long, SourceTrace> sourceTraceA = A.getLivePathwayElements().getMap();
				HashMap<Long, SourceTrace> sourceTraceB = B.getLivePathwayElements().getMap();
				Iterator<Map.Entry<Long, SourceTrace>> it = sourceTraceA.entrySet().iterator();
				while (it.hasNext())
					{
						SourceTrace sourceTrace = it.next().getValue();
						SourceID sourceID = sourceTrace.getSourceID();
					//	System.out.println("SourceID A:\t" + sourceID.DEBUG_getIDs());
						EffectopediaObjectUnion eoUnion = new EffectopediaObjectUnion(sourceID);
						long internalID = sourceTrace.getInternalID();
						eoUnion.setA(A.get(historyMapA.get(internalID).get(0).getObjectClass(), internalID));
						map.put(sourceID, eoUnion);
					}
				it = sourceTraceB.entrySet().iterator();
				while (it.hasNext())
					{
						SourceTrace sourceTrace = it.next().getValue();
						SourceID sourceID = sourceTrace.getSourceID();
					//	System.out.println("SourceID B:\t" + sourceID.DEBUG_getIDs());
						EffectopediaObjectUnion eoUnion = map.get(sourceID);
						if (eoUnion == null)
							{
								eoUnion = new EffectopediaObjectUnion(sourceID);
								map.put(sourceID, eoUnion);
							}
						long internalID = sourceTrace.getInternalID();
						eoUnion.setB(B.get(historyMapB.get(internalID).get(0).getObjectClass(), internalID));
					}
			}
			
		@SuppressWarnings("unchecked")
		public MultiIndexSortedList<EffectopediaObjectUnion> getThose(int withStatusMask)
			{
				ValueComparator<EffectopediaObjectUnion>[] valueComparators = new ValueComparator[]
					{ new IDComparator(), new TimeStampIDComparator(), new ClassNameComparator(), new ObjectNameComparator() };
				MultiIndexSortedList<DataSourceMerge.EffectopediaObjectUnion> those = new MultiIndexSortedList<EffectopediaObjectUnion>(valueComparators);
				Iterator<Map.Entry<SourceID, EffectopediaObjectUnion>> it = map.entrySet().iterator();
				while (it.hasNext())
					{
						EffectopediaObjectUnion eoUnion = it.next().getValue();
						if ((eoUnion.getStatus() & withStatusMask) != 0)
							those.add(eoUnion);
					}
				return those;
			}
			
		public void replaceA(EffectopediaObjectUnion eou)
			{
				if (eou == null)
					return;
				if (eou.eoB != null)
					{
						if (eou.eoA != null)
							{
								if (eou.getStatus() != EffectopediaObjectUnion.CONT_DIFFERENT)
									eou.eoB.assignFieldsTo(eou.eoA, false);
								for (EffectopediaObjectUnion ceou : eou.contained)
									if (ceou.getStatus() != EffectopediaObjectUnion.EQUAL)
										ceou.getEffectopediaObjectB().assignFieldsTo(ceou.getEffectopediaObjectA(), false);
							}
						else
							{
								EffectopediaObject destParent = eou.eoB.getParent();
								EffectopediaObject eo = eou.eoB.clone(getCorrespondingEO(destParent), A);
								addAll(A, eo, eou.sourceId);
								eou.setA(eo);
							}
						eou.status = EffectopediaObjectUnion.EQUAL;
					}
			}
			
		private EffectopediaObject getCorrespondingEO(EffectopediaObject eo)
			{
				if (eo != null)
					{
						DataSource ds = eo.getDataSource();
			//			if (ds == null)
			//				System.err.println("Datasource not assigned:" + eo.DEBUG_getIDs());
						SourceTrace st = ds.getLivePathwayElements().getSourceTraceByID(eo.getID());
						EffectopediaObjectUnion eq = (st != null) ? map.get(st.getSourceID()) : null;
						return (eq != null) ? ((ds == B) ? eq.eoA : eq.eoB) : null;
					}
				return null;
			}
			
		public EffectopediaObject get(DataSource target, EffectopediaObject eo)
			{
				if ((eo == null) || (eo.getDataSource() == target))
					return eo;
	//			if (target==null)
	//				System.err.println("Null target");
				if (eo.isDefaultID())
					return target.get(eo.getClass(), eo.getID());
				return getCorrespondingEO(eo);
			}
			
		public void replaceAllA()
			{
				Iterator<Map.Entry<SourceID, EffectopediaObjectUnion>> it = map.entrySet().iterator();
				while (it.hasNext())
					{
						EffectopediaObjectUnion eou = it.next().getValue();
						if (eou.getStatus() != EffectopediaObjectUnion.EQUAL)
							replaceA(eou);
					}
				B.getLiveIndices().updateReferrals(this);
			}
			
		public void replaceB(EffectopediaObjectUnion eou)
			{
				if (eou == null)
					return;
				if (eou.eoA != null)
					{
						if (eou.eoB != null)
							{
								if (eou.getStatus() != EffectopediaObjectUnion.CONT_DIFFERENT)
									eou.eoA.assignFieldsTo(eou.eoB, false);
								for (EffectopediaObjectUnion ceou : eou.contained)
									if (ceou.getStatus() != EffectopediaObjectUnion.EQUAL)
										ceou.getEffectopediaObjectA().assignFieldsTo(ceou.getEffectopediaObjectB(), false);
							}
						else
							{
								EffectopediaObject destParent = eou.eoA.getParent();
								EffectopediaObject eo = eou.eoA.clone(getCorrespondingEO(destParent), B);
								addAll(B, eo, eou.sourceId);
								eou.setB(eo);
							}
						eou.status = EffectopediaObjectUnion.EQUAL;
					}
			}
			
		public void replaceAllB()
			{
				Iterator<Map.Entry<SourceID, EffectopediaObjectUnion>> it = map.entrySet().iterator();
				while (it.hasNext())
					{
						EffectopediaObjectUnion eou = it.next().getValue();
						if (eou.getStatus() != EffectopediaObjectUnion.EQUAL)
							replaceB(eou);
					}
				A.getLiveIndices().updateReferrals(this);
			}
			
		public void updateForeignRefferals()
			{
				B.getLiveIndices().updateReferrals(this);
				A.getLiveIndices().updateReferrals(this);
			}
			
		public void compare()
			{
				for (EffectopediaObjectUnion eou : map.values())
					eou.compare();
			}
			
		public int updateAfromB()
			{
				int conflicts = 0;
				for (EffectopediaObjectUnion eou : map.values())
					if (eou.status != EffectopediaObjectUnion.EQUAL)
						if (eou.hasNonCoglictingHistory(eou.B, eou.A))
							replaceA(eou);
						else
							conflicts++;
				A.getLiveIndices().updateReferrals(this);
				return conflicts;
			}
			
		public int updateBfromA()
			{
				int conflicts = 0;
				for (EffectopediaObjectUnion eou : map.values())
					if (eou.status != EffectopediaObjectUnion.EQUAL)
						if (eou.hasNonCoglictingHistory(eou.A, eou.B))
							replaceB(eou);
						else
							conflicts++;
				B.getLiveIndices().updateReferrals(this);
				return conflicts;
			}
			
		public boolean areDifferent()
			{
				for (EffectopediaObjectUnion eou : map.values())
					if (eou.status != EffectopediaObjectUnion.EQUAL)
						return true;
				return false;
			}
			
		public int size()
			{
				return map.size();
			}
			
		public final DataSource getA()
			{
				return A;
			}
			
		public final DataSource getB()
			{
				return B;
			}
			
		protected void addAll(DataSource dataSource, EffectopediaObject eo, SourceID sourceID)
			{
				LinkedHashMap<Long, EffectopediaObject> containedIDs = new LinkedHashMap<Long, EffectopediaObject>();
				eo.getContainedIDs(containedIDs, true);
				for (EffectopediaObject e : containedIDs.values())
					if (!e.isDefaultID())
						dataSource.bringToLive(e.getClass(), e, sourceID);
			}
		private long maxStampID;	
		private HashMap<SourceID, EffectopediaObjectUnion>								map;
		private final DataSource																																		A;
		private final DataSource																																		B;
		private final HashMap<Long, ArrayList<EditHistoryAction>>	historyMapA;
		private final HashMap<Long, ArrayList<EditHistoryAction>>	historyMapB;
		
	}

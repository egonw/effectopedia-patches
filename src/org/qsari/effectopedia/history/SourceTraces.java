package org.qsari.effectopedia.history;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.containers.Pathways;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.system.TraceableClasses;

public class SourceTraces
	{
		public SourceTraces()
			{
				pathways = new ArrayList<SourceTrace>();
				fragments = new ArrayList<SourceTrace>();
				map = new HashMap<Long, SourceTrace>();
			}
		
		public void addTrace(long internalID, long externalID, long classID, SourceID sourceID)
			{
				Class<?> c = TraceableClasses.REGISTERED.getClassByID(classID);
				if (c != null)
					{
						if (Pathway.class.isAssignableFrom(c))
							{
								SourceTrace st = new SourceTrace(internalID, externalID, classID, sourceID);
								pathways.add(st);
								map.put(internalID, st);
							}
						else if (PathwayElement.class.isAssignableFrom(c))
							{
								SourceTrace st = new SourceTrace(internalID, externalID, classID, sourceID);
								fragments.add(st);
								map.put(internalID, st);
							}
						extrnalIDMap = null;
					}
			}
		
		public void removeTrace(EffectopediaObject eo)
			{
				if (eo instanceof Pathway)
					{
						long eoID = eo.getID();
						SourceTrace st = map.get(eoID);
						if (st != null)
							pathways.remove(st);
						map.remove(eoID);
					}
				else if (eo instanceof PathwayElement)
					{
						long eoID = eo.getID();
						SourceTrace st = map.get(eoID);
						if (st != null)
							fragments.remove(st);
						map.remove(eoID);
					}
				extrnalIDMap = null;
			}
		
		public void addTrace(EffectopediaObject object, SourceID sourceID)
			{
				// Negative ID Revolution
				if (object.isDefaultID() && (map.get(object.getID()) != null))
					return;
				if (object instanceof Pathway)
					{
						SourceTrace st = new SourceTrace(object.getID(), object.getExternalID(), TraceableClasses.REGISTERED.getClassID(object.getClass()), sourceID);
						pathways.add(st);
						map.put(object.getID(), st);
					}
				else if (object instanceof PathwayElement)
					{
						SourceTrace st = new SourceTrace(object.getID(), object.getExternalID(), TraceableClasses.REGISTERED.getClassID(object.getClass()), sourceID);
						fragments.add(st);
						map.put(object.getID(), st);
					}
				extrnalIDMap = null;
			}
		
		public void addTrace(SourceTrace sourceTrace)
			{
				if (sourceTrace == null)
					return;
				Class<?> c = TraceableClasses.REGISTERED.getClassByID(sourceTrace.classID);
				if (Pathway.class.isAssignableFrom(c))
					pathways.add(sourceTrace);
				else if (PathwayElement.class.isAssignableFrom(c))
					fragments.add(sourceTrace);
				map.put(sourceTrace.internalID, sourceTrace);
				extrnalIDMap = null;
			}
		
		public SourceTrace getSourceTraceByID(long id)
			{
				return map.get(id);
			}
		
		public SourceTrace getSourceTraceByExternalID(long externalID)
			{
				if (extrnalIDMap == null)
					rebuildExternalIDMap();
				return extrnalIDMap.get(externalID);
			}
		
		public ArrayList<SourceTrace> getPathways()
			{
				return pathways;
			}
		
		public ArrayList<SourceTrace> getFragments()
			{
				return fragments;
			}
		
		public void addAll(SourceTraces sourceTraces)
			{
				pathways.addAll(sourceTraces.getPathways());
				fragments.addAll(sourceTraces.getFragments());
				extrnalIDMap = null;
			}
		
		public void addAll(SourceTraces sourceTraces, long maxExternalID)
			{
				for (SourceTrace st : sourceTraces.getPathways())
					if ((st.getExternalID() != 0) && (st.getExternalID() < maxExternalID))
						pathways.add(st);
				for (SourceTrace st : sourceTraces.getFragments())
					if ((st.getExternalID() != 0) && (st.getExternalID() < maxExternalID))
						fragments.add(st);
				extrnalIDMap = null;
			}
		
		public void addDefault(SourceTraces sourceTraces)
			{
				for (SourceTrace st : sourceTraces.getPathways())
					if (st.isDefaultTrace())
						pathways.add(st);
				for (SourceTrace st : sourceTraces.getFragments())
					if (st.isDefaultTrace())
						fragments.add(st);
				extrnalIDMap = null;
			}
		
		public void addNonDefault(SourceTraces sourceTraces)
			{
				for (SourceTrace st : sourceTraces.getPathways())
					if (!st.isDefaultTrace())
						pathways.add(st);
				for (SourceTrace st : sourceTraces.getFragments())
					if (!st.isDefaultTrace())
						fragments.add(st);
				extrnalIDMap = null;
			}
		
		public final HashMap<Long, SourceTrace> getMap()
			{
				return map;
			}
		
		private void rebuildExternalIDMap()
			{
				extrnalIDMap = new HashMap<Long, SourceTrace>();
				for (SourceTrace st : pathways)
					extrnalIDMap.put(st.getExternalID(), st);
				for (SourceTrace st : fragments)
					extrnalIDMap.put(st.getExternalID(), st);
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				loadPathways(element, io);
				loadFragments(element, io);
				loadSourceTraces(element, io);
			}
		
		public void loadRevision(BaseIOElement element, BaseIO io)
			{
				int count = Integer.parseInt(element.getAttributeValue("count"));
				List<BaseIOElement> children = element.getChildren();
				if ((count != 0) && (children != null) && (children.size() == count))
					{
						Iterator<BaseIOElement> iterator = children.iterator();
						while (iterator.hasNext())
							{
								BaseIOElement child = iterator.next();
								loadSourceTrace(child, io);
							}
					}
			}
		
		public void loadSourceTraces(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						BaseIOElement e = element.getChild("source_traces");
						if (e != null)
							loadRevision(e, io);
					}
			}
		
		private SourceTrace loadSourceTrace(BaseIOElement element, BaseIO io)
			{
				BaseIOElement e = element.getChild("object_id");
				EffectopediaObject eo = Effectopedia.EFFECTOPEDIA.getData().getEffectopediaObjectByExternalID(Long.parseLong(e.getValue().trim()));
				if (eo != null)
					if (eo.getDefaultID() != EffectopediaObject.NON_DEFAULT)
						return getSourceTraceByID(eo.getID());
				SourceTrace st = new SourceTrace();
				st.load(element, io);
				addTrace(st);
				return st;
			}
		
		public void loadPathways(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						BaseIOElement e = element.getChild("pathways");
						if (e != null)
							{
								int count = Integer.parseInt(e.getAttributeValue("count"));
								List<BaseIOElement> children = e.getChildren();
								if ((count != 0) && (children != null) && (children.size() == count))
									{
										Iterator<BaseIOElement> iterator = children.iterator();
										while (iterator.hasNext())
											{
												BaseIOElement child = iterator.next();
												io.load(Pathway.class, null, child);
											}
									}
							}
					}
			}
		
		public void loadFragments(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						BaseIOElement e = element.getChild("fragments");
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
														Class<?> cl = Class.forName(class_path + child.getName());
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
			}
		
		public void store(LinkedHashMap<Long, EffectopediaObject> processedIDs, BaseIOElement element, BaseIO io)
			{
				BaseIOElement sourceTracesElement = io.newElement("source_traces");
				sourceTracesElement.setAttribute("count", Integer.toString(pathways.size() + fragments.size()));
				
				BaseIOElement pathwaysElement = io.newElement("pathways");
				storePathways(processedIDs, pathwaysElement, sourceTracesElement, io);
				element.addChild(pathwaysElement);
				
				BaseIOElement fragmentsElement = io.newElement("fragments");
				storeFragments(processedIDs, fragmentsElement, sourceTracesElement, io);
				element.addChild(fragmentsElement);
				
				element.addChild(sourceTracesElement);
				
			}
		
		public void updateExternalIDs()
			{
				for (SourceTrace trace : pathways)
					trace.updateExternalID();
				for (SourceTrace trace : fragments)
					trace.updateExternalID();
			}
		
		public void storePathways(LinkedHashMap<Long, EffectopediaObject> processedIDs, BaseIOElement pathwayElements, BaseIOElement sourceTracesElements, BaseIO io)
			{
				int count = 0;
				for (SourceTrace trace : pathways)
					{
						Pathway p = Effectopedia.EFFECTOPEDIA.getData().getLiveIndices().getPathways().get(trace.getInternalID());
						BaseIOElement pathwayElement = io.newElement("Pathway");
						p.store(pathwayElement, io);
						p.getContainedIDs(processedIDs, true);
						pathwayElements.addChild(pathwayElement);
						
						BaseIOElement sourceTraceElement = io.newElement("SourceTrace");
						trace.updateExternalID();
						trace.store(sourceTraceElement, io);
						sourceTracesElements.addChild(sourceTraceElement);
						count++;
					}
				pathwayElements.setAttribute("count", Integer.toString(count));
			}
		
		public void storeFragments(LinkedHashMap<Long, EffectopediaObject> processedIDs, BaseIOElement freagmentElements, BaseIOElement sourceTracesElements, BaseIO io)
			{
				int count = 0;
				for (SourceTrace trace : fragments)
					{
						BaseIOElement sourceTraceElement = io.newElement("SourceTrace");
						if (processedIDs.get(trace.getInternalID()) == null)
							{
								Class<? extends EffectopediaObject> c = TraceableClasses.REGISTERED.getClassByID(trace.getClassID());
								EffectopediaObject e = Effectopedia.EFFECTOPEDIA.getData().get(c, trace.getInternalID());
								BaseIOElement pathwayElementElement = io.newElement(c.getSimpleName());
								if (e != null)
									{
										e.store(pathwayElementElement, io);
										e.getContainedIDs(processedIDs, true);
									}
								freagmentElements.addChild(pathwayElementElement);
								count++;
							}
						trace.updateExternalID();
						trace.store(sourceTraceElement, io);
						sourceTracesElements.addChild(sourceTraceElement);
					}
				freagmentElements.setAttribute("count", Integer.toString(count));
				freagmentElements.setAttribute("class_path", PathwayElement.class.getPackage().getName());
			}
		
		public void storeRevision(long fromID, long toID, BaseIOElement element, BaseIO io)
			{
				int count = 0;
				for (SourceTrace trace : pathways)
					{
						trace.updateExternalID();
						long eid = trace.getExternalID();
						if ((eid < fromID) || (eid > toID))
							continue;
						BaseIOElement sourceTraceElement = io.newElement("SourceTrace");
						trace.store(sourceTraceElement, io);
						element.addChild(sourceTraceElement);
						count++;
					}
				for (SourceTrace trace : fragments)
					{
						trace.updateExternalID();
						long eid = trace.getExternalID();
						if ((eid < fromID) || (eid > toID))
							continue;
						BaseIOElement sourceTraceElement = io.newElement("SourceTrace");
						trace.store(sourceTraceElement, io);
						element.addChild(sourceTraceElement);
						count++;
					}
				element.setAttribute("count", Integer.toString(count));
			}
		
		/**
		 * <code>pathways</code> Contain SourceTrace for Pathways instances entirely
		 * described in the current {@link org.qsari.effectopedia.data.DataSource}
		 * 
		 * @see SourceTrace
		 * @see Pathways
		 */
		protected ArrayList<SourceTrace>					pathways;
		/**
		 * Contains SourceTrace PathwayElement descendants (like Effects, Links,
		 * Tests, Substances) that are not entirely described in the current
		 * {@link org.qsari.effectopedia.data.DataSource} and could be fragments of
		 * other pathways or standalone components.
		 * 
		 * @see SourceTrace
		 */
		protected ArrayList<SourceTrace>					fragments;
		protected HashMap<Long, SourceTrace>	map;
		protected HashMap<Long, SourceTrace>	extrnalIDMap	= null;
	}

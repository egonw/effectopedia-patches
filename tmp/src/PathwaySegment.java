package org.qsari.effectopedia.core.objects;

import java.util.HashMap;

import org.jdom.Element;
import org.jdom.Namespace;
import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.XMLExportable;
import org.qsari.effectopedia.base.XMLImportable;
import org.qsari.effectopedia.base.ids.IDs;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public class PathwaySegment extends EffectopediaObject implements XMLImportable, XMLExportable, Cloneable, Traceable
	{
		public PathwaySegment(EffectopediaObject parent)
			{
				super(parent);
				elementIDs = DefaultEffectopediaObjects.DEFAULT_PE_IDS.clone(this);
				
			}
		
		public void add(PathwayElement e)
			{
				elementIDs.add(e);
				e.segmentIndex = segmentIndex;
			}
		
		public void remove(PathwayElement e)
			{
				if (elementIDs.remove(e))
					e.segmentIndex = -1;
			}
		
		public void cloneFieldsTo(PathwaySegment clone)
			{
				super.cloneFieldsTo(clone);
				clone.elementIDs = this.elementIDs.clone();
			}
		
		public PathwaySegment clone()
			{
				PathwaySegment clone = new PathwaySegment(parent);
				cloneFieldsTo(clone);
				return clone;
			}
		
		public PathwaySegment clone(EffectopediaObject parent)
			{
				PathwaySegment clone = new PathwaySegment(parent);
				cloneFieldsTo(clone);
				return clone;
			}
		
		public void loadFromXMLElement(Element element, Namespace namespace)
			{
				if (element != null)
					{
						super.loadFromXMLElement(element, namespace);
						segmentIndex = Integer.parseInt(element.getChildText("segment_index",namespace));
						elementIDs.loadFromXMLElement(element.getChild("emenetnts", namespace), namespace);
					}
			}
		
		public Element storeToXMLElement(Element element, Namespace namespace, boolean visualAttributes)
			{
				super.storeToXMLElement(element, namespace, visualAttributes);
				element.setAttribute("default",Boolean.toString(isDefaultID()),namespace);
				element.addContent(new Element("segment_index",namespace).setText(Integer.toBinaryString(segmentIndex)));
				element.addContent(elementIDs.storeToXMLElement(new Element("elements", namespace), namespace, visualAttributes));
				return element;
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				containedIDs.put(getID(), this);
				elementIDs.getContainedIDs(containedIDs);
			}
		
		public void setSegmentIndex(int segmentIndex)
			{
				this.segmentIndex = segmentIndex;
				PathwayElement[] elements = elementIDs.getCachedObjects();
				if (elements != null)
					{
						int count = elements.length;
						for (int i = 0; i < count; i++)
							elements[i].setSegmentIndex(segmentIndex);
					}
			}
		
		protected IDs<PathwayElement>	elementIDs;
		protected int																	segmentIndex;
		
	}

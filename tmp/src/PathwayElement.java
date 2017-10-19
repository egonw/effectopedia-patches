package org.qsari.effectopedia.core.objects;

import org.jdom.Element;
import org.jdom.Namespace;
import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.XMLExportable;
import org.qsari.effectopedia.base.XMLImportable;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public class PathwayElement extends EffectopediaObject implements XMLImportable, XMLExportable, Cloneable, Traceable
	{
		
		public PathwayElement(EffectopediaObject parent)
			{
				super(parent);
				pathwayIDs = DefaultEffectopediaObjects.DEFAULT_PATHWAY_REFIDS.clone(this);
				EffectopediaObject p = parent;
				while (p != null)
					{
						if (p instanceof PathwaySegment)
				   this.segmentIndex = ((PathwaySegment) p).segmentIndex;
						if (p instanceof Pathway)
							{
					   pathwayIDs.add((Pathway) p);
					   break;
							} 
					}
			}

		public void cloneFieldsTo(PathwayElement clone)
			{
				super.cloneFieldsTo(clone);
				clone.pathwayIDs = this.pathwayIDs.clone();
			}
		
		public PathwayElement clone()
			{
				PathwayElement clone = new PathwayElement(parent);
				cloneFieldsTo(clone);
				return clone;
			}
		
		public PathwayElement clone(EffectopediaObject parent)
			{
				PathwayElement clone = new PathwayElement(parent);
				cloneFieldsTo(clone);
				return clone;
			}
		
		public boolean belongsTo(long pathwayID)
			{
				return (pathwayIDs.contains(pathwayID) != -1);
			}
		
		public void loadFromXMLElement(Element element, Namespace namespace)
			{
				if (element != null)
					{
						super.loadFromXMLElement(element, namespace);
						pathwayIDs.loadFromXMLElement(element.getChild("pathway_ids", namespace), namespace);
						segmentIndex = Integer.parseInt(element.getChildText("segment_index", namespace));
					}
			}
		
		public Element storeToXMLElement(Element element, Namespace namespace, boolean visualAttributes)
			{
				super.storeToXMLElement(element, namespace, visualAttributes);
				element.addContent(new Element("segment_index", namespace).setText(Integer.toString(segmentIndex)));
				element.addContent(pathwayIDs.storeToXMLElement(new Element("pathway_ids", namespace), namespace, visualAttributes));
				return element;
			}
		
		public ReferenceIDs<Pathway> getPathwayIDs()
			{
				return pathwayIDs;
			}
		
		public PathwayElement[] incommingAssociations()
			{
				return null;
			}

		public PathwayElement[] outgoingAssociations()
			{
				return null;
			}
		
		protected ReferenceIDs<Pathway>	pathwayIDs;
	}

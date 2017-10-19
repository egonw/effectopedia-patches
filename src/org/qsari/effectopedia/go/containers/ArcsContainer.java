package org.qsari.effectopedia.go.containers;

import java.util.Iterator;
import java.util.ListIterator;

import org.qsari.effectopedia.go.ArcGO;
import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.IOPorts;
import org.qsari.effectopedia.go.StraightArcGO;
import org.qsari.effectopedia.go.pathway_elements.PathwayElementGO;

public class ArcsContainer extends GraphicObjectsContainer
	{
		
		public ArcsContainer(GraphicObject parent)
			{
				super(parent);
			}
		
		public void removeArcsConnectedTo(PathwayElementGO element)
			{
				if (element == null)
					return;
				IOPorts ports = element.getPorts();
				Iterator<GraphicObject> it = list.iterator();
				while (it.hasNext())
					{
						ArcGO arc = (ArcGO) it.next();
						if (ports.contains(arc.getOrigin()))
							it.remove();
						else if (ports.contains(arc.getEnd()))
							it.remove();
					}
			}
		
		public void substitute(PathwayElementGO oldElement, PathwayElementGO newElement)
			{
				IOPorts oldPorts = oldElement.getPorts();
				IOPorts newPorts = newElement.getPorts();
				for (int i = list.size() - 1; i >= 0; i--)
					{
						ArcGO arc = (ArcGO) list.get(i);
						int portIndex = oldPorts.getPortIndex(arc.getOrigin());
						if (portIndex != -1)
							list.set(i, new StraightArcGO(newPorts.getPorts().get(portIndex), arc.getEnd()));
						portIndex = oldPorts.getPortIndex(arc.getEnd());
						if (portIndex != -1)
							list.set(i, new StraightArcGO(arc.getOrigin(), newPorts.getPorts().get(portIndex)));
					}
			}
		
		public void removeArcBetween(PathwayElementGO elementOrigin, PathwayElementGO elementEnd)
			{
				if ((elementOrigin == null) || (elementEnd == null))
					return;
				IOPorts oPorts = elementOrigin.getPorts();
				IOPorts ePorts = elementEnd.getPorts();
				Iterator<GraphicObject> it = list.iterator();
				while (it.hasNext())
					{
						ArcGO arc = (ArcGO) it.next();
						if (oPorts.contains(arc.getOrigin()) && ePorts.contains(arc.getEnd()))
							{
								it.remove();
								return;
							}
					}
			}
		
		public void exportToSVG(StringBuilder spaceLayer,StringBuilder pathwayLayer)
			{
				if (visible)
					for (ListIterator<GraphicObject> iterator = list.listIterator(); iterator.hasNext();)
						iterator.next().exportToSVG(spaceLayer,pathwayLayer);
			}
		
	}

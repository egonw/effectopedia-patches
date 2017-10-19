package org.qsari.effectopedia.go.pathway_elements;

import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.go.Details;
import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.IOPorts;

public abstract class PathwayElementGO extends GraphicObject
	{
		
		public PathwayElementGO(PathwayElement o)
			{
				this.o = o;
				sections = new DisplaySections();
			}
			
		public PathwayElement getO()
			{
				return o;
			}
			
		public void setO(PathwayElement pathwayElement)
			{
				this.o = pathwayElement;
			}
			
		public void setX(int x)
			{
				this.x = x;
				ports.updatePortLocations();
			}
			
		public void setY(int y)
			{
				this.y = y;
				ports.updatePortLocations();
			}
			
		public void setXY(int x, int y)
			{
				this.x = x;
				this.y = y;
				ports.updatePortLocations();
			}
			
		public void setWidth(int width)
			{
				this.width = width;
				ports.updatePortLocations();
			}
			
		public void setHeight(int height)
			{
				this.height = height;
				ports.updatePortLocations();
			}
			
		public Details getDetails()
			{
				return details;
			}
			
		public void setDetails(Details details)
			{
				this.details = details;
			}
			
		public IOPorts getPorts()
			{
				return ports;
			}
			
		public void updateDisplaySections()
			{
			}
			
		public void exportID(StringBuilder sb)
			{
				if (o != null)
					{
						sb.append(" id=\"");
						sb.append(o.getClass().getSimpleName());
						sb.append("_");
						sb.append(o.getExternalID());
						sb.append("\"");
					}
			}
			
		public void exportLink(StringBuilder sb)
			{
				sb.append("<a xlink:href=\"#");
				sb.append(o.getExternalID());
				sb.append("\" target=\"_parent\">\n");
			}
			
		public void exportToSVG(StringBuilder base, StringBuilder pathwayElementsGroup)
			{
				if (visible)
					{
						pathwayElementsGroup.append("<rect");
						exportID(pathwayElementsGroup);
						exportDimensions(pathwayElementsGroup);
						exportPresentationAttributes(pathwayElementsGroup);
						pathwayElementsGroup.append("/>\n");
					}
			}
			
		protected Details									details	= Details.ALL;
		protected IOPorts									ports;
		protected PathwayElement		o;
		protected DisplaySections	sections;
	}

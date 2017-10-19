package org.qsari.effectopedia.go;

import org.qsari.effectopedia.defaults.DefaultGOSettings;

public class ArcGO extends GraphicObject
	{
		public ArcGO(IOPort origin, IOPort end)
			{
				this.origin = origin;
				this.end = end;
			}
			
		public IOPort getOrigin()
			{
				return origin;
			}
			
		public IOPort getEnd()
			{
				return end;
			}
			
		public void exportToSVG(StringBuilder base, StringBuilder pathwayElementsGroup)
			{
				if (visible)
					SVGUtils.addLine(pathwayElementsGroup, origin.getX(), origin.getY(), end.getX(), end.getY(), getColor(), 1);
			}
			
		protected IOPort	origin;
		protected IOPort	end;
	}

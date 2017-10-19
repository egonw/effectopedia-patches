package org.qsari.effectopedia.go.gui;

import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.containers.GraphicObjectsContainer;

public class PathwaySpaceDimensionGOC extends GraphicObjectsContainer
	{
		public PathwaySpaceDimensionGOC()
			{
				super();
			}
			
		public PathwaySpaceDimensionGOC(GraphicObjectsContainer parent)
			{
				super(parent);
			}
			
		public void updateActive(int index, boolean active)
			{
				GraphicObject header = list.get(index);
				if (header != null)
					header.setActive(active);
			}
			
	}

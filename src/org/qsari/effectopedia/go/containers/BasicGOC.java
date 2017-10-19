package org.qsari.effectopedia.go.containers;

import java.awt.Graphics2D;
import java.util.ListIterator;

import org.qsari.effectopedia.go.GraphicObject;

public class BasicGOC extends GraphicObjectsContainer
	{
		
		public BasicGOC()
			{
				super();
			}
	
		public BasicGOC(GraphicObject parent)
			{
				super(parent);
			}
		
		public void drawSelf(Graphics2D onCanvas)
			{
				onCanvas.setBackground(background);
				onCanvas.fillRect(x, y, width, height);
			}
		
		public void drawContent(Graphics2D onCanvas)
			{
				for (ListIterator<GraphicObject> iterator = list.listIterator(); iterator.hasNext();)
					iterator.next().draw(onCanvas);
			}
		
		public void draw(Graphics2D onCanvas)
			{
				if (visible)
					{
						if (onCanvas.hitClip(x, y, width, height))
							{
								drawSelf(onCanvas);
								drawContent(onCanvas);
							}
					}
			}

	}

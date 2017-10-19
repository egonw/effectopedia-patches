package org.qsari.effectopedia.go.gui;

import java.util.ArrayList;

import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.containers.GraphicObjectsContainer;

public class RowHeadersGOC extends PathwaySpaceDimensionGOC
	{
	
		public RowHeadersGOC()
			{
				super();
				width = DefaultGOSettings.rowHeaderWidth;
			}
		
		public RowHeadersGOC(GraphicObjectsContainer parent)
			{
				super(parent);
				width = DefaultGOSettings.rowHeaderWidth;
			}

		public void initHeaders(GraphicObjectsContainer gos)
			{
				list.clear();
				int cnt = gos.getCount();
				for (int i = 0; i < cnt; i++)
					{
						RowHeaderGO header = new RowHeaderGO(this);
						GraphicObject go = gos.get(i);
						header.setX(go.getX());
						header.setY(go.getY());
						header.setHeight(go.getHeight());
						header.setWidth(DefaultGOSettings.rowHeaderWidth);
						list.add(header);
					}
			}
		
		public void adjustHeaderDimenstions(GraphicObjectsContainer gos)
			{
				int cnt = gos.getCount();
				if (cnt != list.size())
					return;
				cnt--;
				for (int i = 0; i < cnt; i++)
					{
						GraphicObject header = list.get(i);
						GraphicObject go = gos.get(i);
						header.setX(go.getX());
						header.setY(go.getY());
						header.setHeight(go.getHeight());
						header.setWidth(DefaultGOSettings.rowHeaderWidth);
					}
			}
		
		public void setCaptions(ArrayList<String> captions)
			{
				int count=list.size();
				if (count == captions.size())
					for (int i=0;i<count;i++)
						((RowHeaderGO)list.get(i)).setCaption(captions.get(i));
			}

		public void setCaptions(String caption)
			{
				if (list.size() == 1)
				((RowHeaderGO)list.get(0)).setCaption(caption);
			}
	
	}

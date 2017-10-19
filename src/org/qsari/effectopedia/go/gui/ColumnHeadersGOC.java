package org.qsari.effectopedia.go.gui;

import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.containers.GraphicObjectsContainer;

public class ColumnHeadersGOC extends PathwaySpaceDimensionGOC
	{
		public GraphicObjectsContainer headers;
		
		public ColumnHeadersGOC()
			{
				super();
				height = DefaultGOSettings.footerHeight;
			}
			
		public ColumnHeadersGOC(GraphicObjectsContainer parent)
			{
				super(parent);
			}
			
		public void initHeaders(GraphicObjectsContainer gos)
			{
				list.clear();
				int cnt = gos.getCount();
				for (int i = 0; i < cnt; i++)
					{
						ColumnHeaderGO header = new ColumnHeaderGO(this);
						GraphicObject go = gos.get(i);
						header.setX(go.getX());
						header.setY(go.getY());
						header.setWidth(go.getWidth());
						header.setHeight(DefaultGOSettings.footerHeight);
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
						header.setWidth(go.getWidth());
						header.setHeight(DefaultGOSettings.footerHeight);
					}
			}
	}

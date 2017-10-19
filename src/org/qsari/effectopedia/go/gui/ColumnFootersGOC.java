package org.qsari.effectopedia.go.gui;

import java.util.ArrayList;

import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.containers.GraphicObjectsContainer;

public class ColumnFootersGOC extends PathwaySpaceDimensionGOC
	{
		public ColumnFootersGOC()
			{
				super();
				height = DefaultGOSettings.footerHeight;
			}
			
		public void initFooters(GraphicObjectsContainer gos)
			{
				list.clear();
				int cnt = gos.getCount();
				for (int i = 0; i < cnt; i++)
					{
						ColumnFooterGO footer = new ColumnFooterGO(this);
						GraphicObject go = gos.get(i);
						footer.setX(go.getX());
						footer.setY(go.getY());
						footer.setWidth(go.getWidth());
						footer.setHeight(DefaultGOSettings.footerHeight);
						list.add(footer);
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
						GraphicObject footer = list.get(i);
						GraphicObject go = gos.get(i);
						footer.setX(go.getX());
						footer.setY(go.getY());
						footer.setWidth(go.getWidth());
						footer.setHeight(DefaultGOSettings.footerHeight);
					}
			}
			
		public void setCaptions(ArrayList<String> captions)
			{
				int count = list.size();
				if (count == captions.size())
					for (int i = 0; i < count; i++)
						((ColumnFooterGO) list.get(i)).setCaption(captions.get(i));
			}
			
	}

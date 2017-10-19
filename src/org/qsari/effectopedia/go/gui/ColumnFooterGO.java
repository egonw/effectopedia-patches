package org.qsari.effectopedia.go.gui;

import java.awt.Color;
import java.awt.Graphics2D;

import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.GOUtils;
import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.SVGUtils;
import org.qsari.effectopedia.go.containers.GraphicObjectsContainer;

public class ColumnFooterGO extends GraphicObject
	{
		
		public ColumnFooterGO(GraphicObjectsContainer parent)
		{
   super(parent);
   if (parent!=null)
   	parent.add(this);
		}

		public void draw(Graphics2D onCanvas)
			{
				if (visible)
					{
						onCanvas.setColor(active?activeColor:color);
						onCanvas.fillRect(x, y, width, height);
						if (caption!=null)
							GOUtils.drawFooter(caption,DefaultGOSettings.footerCaptionColor , onCanvas, x + 2, y - 1, width-3, DefaultGOSettings.rowHeight);
					}
			}
		
		public void exportToSVG(StringBuilder base,StringBuilder pathwayElementsGroup)
			{
				if (visible)
					SVGUtils.addCentredCaption(caption, base, x + 2, y - 1, width-3, DefaultGOSettings.rowHeight, DefaultGOSettings.footerCaptionColor);
			}
		
		public String getCaption()
			{
				return caption;
			}
		
		public void setCaption(String caption)
			{
				this.caption = caption;
			}
		
		private Color				color		= DefaultGOSettings.headerColor;
		private Color    activeColor = DefaultGOSettings.uiSelectedColor;
		protected int				height	= DefaultGOSettings.columnHeaderHeight;
		protected String	caption;
	}

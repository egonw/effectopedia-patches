package org.qsari.effectopedia.go.gui;

import java.awt.Color;
import java.awt.Graphics2D;

import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.GOUtils;
import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.SVGUtils;
import org.qsari.effectopedia.go.containers.GraphicObjectsContainer;

public class RowHeaderGO extends GraphicObject
	{
		
		public RowHeaderGO(GraphicObjectsContainer parent)
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
						onCanvas.fillRect(x , y, width, height);
						if (caption!=null)
 						GOUtils.drawRowHeader(caption,DefaultGOSettings.footerCaptionColor , onCanvas, x, y, width ,height);
					}
			}

		public void exportToSVG(StringBuilder base,StringBuilder pathwayElementsGroup)
			{
				if (visible)
					SVGUtils.addCentredVerticalCaption(caption, base, x + 2+DefaultGOSettings.rowHeight, y - 1, width, height, DefaultGOSettings.footerCaptionColor);
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
		protected int				width	= DefaultGOSettings.rowHeaderWidth;
		protected String	caption;
	}

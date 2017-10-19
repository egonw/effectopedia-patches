package org.qsari.effectopedia.gui.chart;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import org.qsari.effectopedia.gui.chart.ChartUtils.Offset;

public class ChartTitle extends ChartComponent
	{
		public ChartTitle(String text, Offset titleOffset, boolean vertical)
			{
				this.text = text;
				this.titleOffset = titleOffset;
				this.vertical = vertical;
				this.width = ChartUtils.defaultFontHeight;
				this.height = ChartUtils.defaultFontHeight;
			}
		
		@Override
		public void render(Graphics2D canvas)
			{
				if (text==null)
					return;
				canvas.setColor(titleColor);
				FontMetrics fm = canvas.getFontMetrics(titleFont);
				int titleWidth = fm.stringWidth(text);
				if (vertical)
					{
						AffineTransform defaultTransformation = canvas.getTransform();
						AffineTransform at = new AffineTransform();
						at.setToQuadrantRotation(-1);
						canvas.setTransform(at);
						int xT = (int) defaultTransformation.getTranslateX();
						int yT = (int) defaultTransformation.getTranslateY();
						canvas.drawString(text, y + titleOffset.vertical - ((height + titleWidth) >> 1) - yT, x + titleOffset.horizontal + xT);
						canvas.setTransform(defaultTransformation);
					}
				else
					canvas.drawString(text, x + titleOffset.horizontal + (width - titleWidth) >> 1, y + titleOffset.vertical);
			}
		
		public boolean isFixedX()
			{
				return vertical;
			}
		
		public boolean isFixedY()
			{
				return !vertical;
			}
		
		@Override
		public void update()
			{
				
			}
		
		public Color getTitleColor()
			{
				return titleColor;
			}
		
		public void setTitleColor(Color titleColor)
			{
				this.titleColor = titleColor;
			}
		
		public Font getTitleFont()
			{
				return titleFont;
			}
		
		public void setTitleFont(Font titleFont)
			{
				this.titleFont = titleFont;
			}
		
		private boolean		vertical				= false;
		protected String	text								= "Some title";
		protected Color		titleColor		= ChartUtils.chartTitleColor;
		protected Font			titleFont			= ChartUtils.chartTitlesFont;
		protected Offset	titleOffset	= ChartUtils.Offset.ZERO;
	}

package org.qsari.effectopedia.go;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import org.qsari.effectopedia.defaults.DefaultGOSettings;

public class StraightArcGO extends ArcGO
	{
		
		public StraightArcGO(IOPort origin, IOPort end)
			{
				super(origin, end);
			}
		
		private void drawStraightArc(Graphics2D onCanvas)
			{
				onCanvas.setStroke(temporary?DefaultGOSettings.arcTmpPen:DefaultGOSettings.arcPen);
				if ((isSelectable() && ((origin.isActive() || end.isActive()))))
					onCanvas.setColor((origin.isSelected() && end.isSelected())?DefaultGOSettings.activeSelectionColor:DefaultGOSettings.activeArcColor);
				else if (origin.isSelected() && end.isSelected())
					onCanvas.setColor(DefaultGOSettings.selectionColor);
				else
					onCanvas.setColor(DefaultGOSettings.arcColor);
				onCanvas.drawLine(origin.getX(), origin.getY(), end.getX(), end.getY());
			}
		
		public void draw(Graphics2D onCanvas)
			{
				if ((origin != null) && (end != null))
					{
						if (isIntersected(onCanvas.getClipBounds()))
							drawStraightArc(onCanvas);
					}
			}
		
		public boolean isIntersected(Rectangle r)
			{
				if (r == null)
					return true;
				int ulx = Math.max(Math.min(origin.getX(), end.getX()), r.x);
				int uly = Math.max(Math.min(origin.getY(), end.getY()), r.y);
				int lrx = Math.min(Math.max(origin.getX(), end.getX()), r.x + r.width);
				int lry = Math.min(Math.max(origin.getY(), end.getY()), r.y + r.height);
				return ulx <= lrx && uly <= lry;
			}
		
		private void updateCoefficients()
			{
				int x1 = origin.getX();
				int x2 = end.getX();
				int y1 = origin.getY();
				int y2 = end.getY();
				int deltaX = x1 - x2;
				if (deltaX != 0)
					{
						a = (y1 - y2) / (deltaX);
						b = (y1 * x2 - x1 * y2) / (deltaX);
					}
				else
					{
						a = 0;
						b = 0;
					}
			}
		
		public GraphicObject isOver(int x, int y)
			{
				active = (this.x < x) && (this.y < y) && (this.x + width > x) && (this.y + height > y);
				if (active)
					{
						updateCoefficients();
						active = (x * a + b - y < 2);
					}
				return (active) ? this : null;
			}
		
		public Color getColor()
			{
				return DefaultGOSettings.arcColor;
			}
		
		private double	a;
		private double	b;
	}

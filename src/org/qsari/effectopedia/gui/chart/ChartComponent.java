package org.qsari.effectopedia.gui.chart;

import java.awt.Graphics2D;

public abstract class ChartComponent
	{
		
		public abstract void render(Graphics2D canvas);
		
		public abstract void update();
		
		public boolean isFixedX()
			{
				return false;
			}
		
		public boolean isFixedY()
			{
				return false;
			}
		
		public int getX()
			{
				return x;
			}
		
		public void setX(int x)
			{
				this.x = x;
			}
		
		public int getY()
			{
				return y;
			}
		
		public void setY(int y)
			{
				this.y = y;
			}
		
		public int getWidth()
			{
				return width;
			}
		
		public void setWidth(int width)
			{
				this.width = width;
			}
		
		public int getHeight()
			{
				return height;
			}
		
		public void setHeight(int height)
			{
				this.height = height;
			}
		
		public void setDimensions(ChartComponent component)
			{
				this.x = component.x;
				this.y = component.y;
				this.width = component.width;
				this.height = component.height;
			}
		
		int	x;
		int	y;
		int	width;
		int	height;
	}

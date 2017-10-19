package org.qsari.effectopedia.go;

import java.awt.Graphics2D;

public class IOPort
	{
		
		public IOPort(GraphicObject owner)
			{
				this.owner = owner;
			}
		
		public IOPort(GraphicObject owner, int x, int y)
			{
				this.owner = owner;
				this.x = x;
				this.y = y;
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
		
		public void setXY(int x, int y)
			{
				this.x = x;
				this.y = y;
			}
		
		public GraphicObject getOwner()
			{
				return owner;
			}
		
		public boolean hitClip(Graphics2D onCanvas)
			{
				return onCanvas.hitClip(x, y, 1, 1);
			}
		
		public boolean isActive()
			{
				return owner.active;
			}
		
		public boolean isSelected()
			{
				return owner.selected;
			}
		
		public boolean isUsed()
			{
				return used;
			}
		
		public void setUsed(boolean used)
			{
				this.used = used;
			}
		
		private boolean							used;
		private GraphicObject	owner;
		private int											x;
		private int											y;
	}

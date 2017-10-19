package org.qsari.effectopedia.go.gui;

import java.awt.Color;
import java.awt.Graphics2D;

import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.Details;
import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.containers.GraphicObjectsContainer;

public class ColumnHeaderGO extends GraphicObject
	{
		
		public ColumnHeaderGO()
			{
				super();
				zoomBar = new ZoomBar();
				zoomIn = new ZoomButton(ZoomButton.ZOOM_IN);
				zoomOut = new ZoomButton(ZoomButton.ZOOM_OUT);
			}
		
		public ColumnHeaderGO(GraphicObjectsContainer parent)
			{
				super(parent);
				zoomBar = new ZoomBar();
				zoomIn = new ZoomButton(ZoomButton.ZOOM_IN);
				zoomOut = new ZoomButton(ZoomButton.ZOOM_OUT);
	   if (parent!=null)
	   	parent.add(this);
			}

		public class ZoomBar extends GraphicObject
			{
				public void draw(Graphics2D onCanvas)
					{
						if (visible)
							{
								onCanvas.setColor(color);
								int stepWidth = DefaultGOSettings.headerBarWidth + DefaultGOSettings.headerBarGap;
								int zoomFactor = details.getFactor();
								for (int i = 0; i < 5; i++)
									{
										onCanvas.setColor(color);
										onCanvas.draw3DRect(x + i * stepWidth, y, DefaultGOSettings.headerBarWidth, DefaultGOSettings.headerBarHeight, false);
										onCanvas.setColor(DefaultGOSettings.uiSelectedColor);
										if (i <= zoomFactor)
											onCanvas.fillRect(x + i * stepWidth + 1, y + 1, DefaultGOSettings.headerBarWidth - 2, DefaultGOSettings.headerBarHeight - 1);
									}
							}
					}
				
				public int getPrefferedWidth()
					{
						return 4 * (DefaultGOSettings.headerBarWidth + DefaultGOSettings.headerBarGap) + DefaultGOSettings.headerBarWidth;
					}
				
				int	activeBar;
			}
		
		public class ZoomButton extends GraphicObject
			{
				public static final boolean	ZOOM_IN		= true;
				public static final boolean	ZOOM_OUT	= false;
				
				public ZoomButton(boolean zoomIn)
					{
						this.zoomIn = zoomIn;
					}
				
				public void draw(Graphics2D onCanvas)
					{
						if (visible)
							{
								onCanvas.setColor(color);
								if (active)
									onCanvas.draw3DRect(x, y, width, height, !pressed);
								onCanvas.setColor(iconColor);
								onCanvas.drawLine(x + 2, y + height / 2, x + width - 2, y + height / 2);
								if (zoomIn)
									onCanvas.drawLine(x + width / 2, y + 2, x + width / 2, y + height - 2);
							}
					}
				
				private Color			iconColor	= DefaultGOSettings.headerIconColor;
				private boolean	pressed			= false;
				private boolean	zoomIn;
			}
		
		public void draw(Graphics2D onCanvas)
			{
				if (visible)
					{
						onCanvas.setColor(color);
						onCanvas.fillRect(x + 1, y, width - 1, height);
						if (width > DefaultGOSettings.headerButtonWidth * 2)
							zoomIn.draw(onCanvas);
						zoomBar.draw(onCanvas);
						if (width > DefaultGOSettings.headerButtonWidth * 2)
							zoomOut.draw(onCanvas);
					}
			}
		
		public void setWidth(int width)
			{
				this.width = width;
				int zoomBarWidth = zoomBar.getPrefferedWidth();
				
				if ((zoomBarWidth + 2 * DefaultGOSettings.headerButtonWidth) < width)
					{
						zoomBar.setX(x + (width - zoomBarWidth) / 2);
						zoomBar.setWidth(zoomBarWidth);
						zoomBar.setVisible(true);
					}
				else
					{
						zoomBar.setX(x + width / 2);
						zoomBar.setWidth(0);
						zoomBar.setVisible(false);
					}
				zoomOut.setX(zoomBar.getX() - 2 - DefaultGOSettings.headerButtonWidth);
				zoomOut.setWidth(DefaultGOSettings.headerButtonWidth);
				zoomIn.setX(zoomBar.getX() + zoomBar.getWidth() + 2);
				zoomIn.setWidth(DefaultGOSettings.headerButtonWidth);
			}
		
		public void setHeight(int height)
			{
				this.height = height;
				zoomBar.setY(y + (height - DefaultGOSettings.headerBarHeight) / 2);
				zoomBar.setHeight(DefaultGOSettings.headerBarHeight);
				zoomOut.setY(y + (height - DefaultGOSettings.headerButtonHeight) / 2);
				zoomOut.setHeight(DefaultGOSettings.headerBarHeight);
				zoomIn.setY(y + (height - DefaultGOSettings.headerButtonHeight) / 2);
				zoomIn.setHeight(DefaultGOSettings.headerButtonHeight);
			}
		
		public GraphicObject isOver(int x, int y)
			{
				active = (this.x < x) && (this.y < y) && (this.x + width > x) && (this.y + height > y);
				GraphicObject activeGO = null;
				if (active)
					{
						activeGO = zoomIn.isOver(x, y);
						if (activeGO == null)
							activeGO = zoomBar.isOver(x, y);
						if (activeGO == null)
							activeGO = zoomOut.isOver(x, y);
						if (activeGO == null)
							activeGO = this;
					}
				return activeGO;
			}
		
		public Details getDetails()
			{
				return details;
			}
		
		public void setDetails(Details details)
			{
				this.details = details;
			}
		
		protected Details		details	= Details.LOW;
		
		private ZoomBar				zoomBar;
		private ZoomButton	zoomIn;
		private ZoomButton	zoomOut;
		
		private Color						color			= DefaultGOSettings.headerColor;
		protected int						height		= DefaultGOSettings.columnHeaderHeight;
		
	}

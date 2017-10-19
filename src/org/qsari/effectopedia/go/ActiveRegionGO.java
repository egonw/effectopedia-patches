package org.qsari.effectopedia.go;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.Layout.LayoutObjectsContainer.ActiveIndex;

public class ActiveRegionGO extends GraphicObject
	{
		
		public ActiveRegionGO(int xCount, int yCount)
			{
				this.xCount = xCount;
				this.yCount = yCount;
				this.xOffsets = distributeEqually(width, xCount);
				this.yOffsets = distributeEqually(height, yCount);
			}
		
		public void updateDivision(ArrayList<Integer> widths, ArrayList<Integer> heights)
			{
				this.xCount = widths.size();
				this.yCount = heights.size();
				this.xOffsets = length2offset(widths);
				this.yOffsets = length2offset(heights);
			}
		
		public void updateDivision(int xOffsets[], int yOffsets[])
			{
				this.xCount = xOffsets.length;
				this.yCount = yOffsets.length;
				this.xOffsets = xOffsets.clone();
				this.yOffsets = yOffsets.clone();
			}
		
		public void updateActiveIndex(ActiveIndex activeIndex, boolean simpleRegion)
			{
				this.activeIndex = activeIndex;
				this.simpleRegion = simpleRegion;
				if (simpleRegion)
					{
						activeIndex.xActionIndex = 1;
						activeIndex.yActionIndex = 1;
					}
			}
		
		public boolean isCenterAction()
			{
				return ((activeIndex.xActionIndex == 1) && (activeIndex.yActionIndex == 1));
			}
		
		public boolean isOverGO()
			{
				return activeIndex.overGO;
			}
		
		public void draw(Graphics2D onCanvas)
			{
				onCanvas.setPaintMode();
				if (visible)
					{
						
						// onCanvas.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						// RenderingHints.VALUE_ANTIALIAS_OFF);;
						// onCanvas.setXORMode(Color.white);
						onCanvas.setComposite(composite);
						onCanvas.setColor(color);
						for (int i = xCount - 2; i >= 0; i--)
							onCanvas.drawLine(xOffsets[i], y + 1, xOffsets[i], y + height - 2);
						for (int i = yCount - 2; i >= 0; i--)
							onCanvas.drawLine(x + 1, yOffsets[i], x + width - 2, yOffsets[i]);
						if (simpleRegion)
							drawSimpleRegion(onCanvas);
						else
							draw3x3Region(onCanvas);
						onCanvas.setComposite(AlphaComposite.Src);
						// onCanvas.setPaintMode();
						// onCanvas.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						// RenderingHints.VALUE_ANTIALIAS_ON);;
						
						// onCanvas.setPaintMode();
					}
			}
		
		private void drawSimpleRegion(Graphics2D onCanvas)
			{
				onCanvas.fillRect(activeIndex.left, activeIndex.top, activeIndex.width, activeIndex.height);
			}
		
		private void draw3x3Region(Graphics2D onCanvas)
			{
				if ((activeIndex.xActionIndex == 1) && (activeIndex.yActionIndex == 1))
					{
						drawSimpleRegion(onCanvas);
						return;
					}
				onCanvas.drawLine(activeIndex.xWestEdge, activeIndex.top + 1, activeIndex.xWestEdge, activeIndex.top + activeIndex.height - 1);
				onCanvas.drawLine(activeIndex.xEastEdge, activeIndex.top + 1, activeIndex.xEastEdge, activeIndex.top + activeIndex.height - 1);
				onCanvas.drawLine(activeIndex.left + 1, activeIndex.yNorthEdge, activeIndex.left + activeIndex.width - 1, activeIndex.yNorthEdge);
				onCanvas.drawLine(activeIndex.left + 1, activeIndex.ySouthEdge, activeIndex.left + activeIndex.width - 1, activeIndex.ySouthEdge);
				int xOffset = activeIndex.xOffset(activeIndex.xActionIndex);
				int yOffset = activeIndex.yOffset(activeIndex.yActionIndex);
				onCanvas.fillRect(xOffset, yOffset, activeIndex.xOffset(activeIndex.xActionIndex + 1) - xOffset, activeIndex.yOffset(activeIndex.yActionIndex + 1) - yOffset);
			}
		
		private int[] length2offset(ArrayList<Integer> lengths)
			{
				int offsets[] = new int[lengths.size()];
				int sum = 0;
				for (int i = 0; i < lengths.size(); i++)
					{
						sum += lengths.get(i);
						offsets[i] = sum;
					}
				return offsets;
			}
		
		private int[] distributeEqually(int total, int count)
			{
				int offset[] = new int[count];
				for (int i = count - 1; i >= 0; i--)
					offset[i] = i * width / count;
				return offset;
			}
		
		private Color										color								= DefaultGOSettings.activeRegionColor;
		private AlphaComposite	composite				= AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5F);
		protected ActiveIndex		activeIndex;
		protected int										xCount;
		protected int										yCount;
		protected int										xOffsets[];
		protected int										yOffsets[];
		protected boolean						simpleRegion	= true;
	}

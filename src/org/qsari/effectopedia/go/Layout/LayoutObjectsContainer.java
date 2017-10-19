package org.qsari.effectopedia.go.Layout;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.containers.GraphicObjectsContainer;

public class LayoutObjectsContainer extends LayoutObject
	{
		
		public LayoutObjectsContainer()
			{
				super();
				init();
			}
			
		public LayoutObjectsContainer(LayoutObjectsContainer parent)
			{
				super(parent);
				init();
			}
			
		public class ActiveIndex
			{
				public ActiveIndex(int mouseX, int mouseY)
					{
						updateIndex(getXIndexByX(mouseX), getYIndexByY(mouseY));
						updateActionIndex(mouseX, mouseY);
					}
					
				public boolean isCenterAction()
					{
						return (xActionIndex == 1) && (yActionIndex == 1);
					}
					
				public boolean updateActionIndex(int mouseX, int mouseY)
					{
						int oldXAtionIndex = xActionIndex;
						int oldYActionIndex = yActionIndex;
						LayoutObject lo = getComponent(xIndex, yIndex);
						if ((lo != null) && (!lo.isTemporary()))
							{
								Rectangle goBounds = lo.getGo().getBounds();
								xWestEdge = goBounds.x;
								xEastEdge = xWestEdge + goBounds.width;
								yNorthEdge = goBounds.y;
								ySouthEdge = yNorthEdge + goBounds.height;
								xActionIndex = (width > 0) ? ((mouseX < xWestEdge) ? 0 : (mouseX > xEastEdge) ? 2 : 1) : 1;
								yActionIndex = (height > 0) ? ((mouseY < yNorthEdge) ? 0 : (mouseY > ySouthEdge) ? 2 : 1) : 1;
								overGO = lo.getGo().isOver(mouseX, mouseY) != null;
								//System.out.print("### container left=" + LayoutObjectsContainer.this.x + " right=" + LayoutObjectsContainer.this.getActualRight() + " top=" + LayoutObjectsContainer.this.y + " bottom=" 	+ LayoutObjectsContainer.this.getActualBottom());
								//System.out.print(" action xIndex=" + xActionIndex + " action yIndex=" + yActionIndex);
								//System.out.println(" xWestEdge=" + xWestEdge + " xEastEdge=" + xEastEdge + " yNorthEdge=" + yNorthEdge + " ySouthEdge=" + ySouthEdge);
								//System.out.println("### mouse x=" + mouseX + " y=" + mouseY);
							}
						else
							{
								xActionIndex = 1;
								yActionIndex = 1;
								overGO = false;
							}
						return (oldXAtionIndex != xActionIndex) || (oldYActionIndex != yActionIndex);
					}
					
				public boolean equals(ActiveIndex toIndex)
					{
						return (toIndex != null) && (xActionIndex == toIndex.xActionIndex) && (yActionIndex == toIndex.yActionIndex) && overGO == toIndex.overGO;
					}
					
				public void updateIndex(int xIndex, int yIndex)
					{
						this.xIndex = xIndex;
						this.yIndex = yIndex;
						if ((xIndex != -1) && (yIndex != -1))
							{
								top = (yIndex >= 1) ? yOffsets[yIndex - 1] : y;
								left = (xIndex >= 1) ? xOffsets[xIndex - 1] : x;
								height = yOffsets[yIndex] - top;
								width = xOffsets[xIndex] - left;
							}
						else
							{
								top = y;
								left = x;
								height = 0;
								width = 0;
							}
					}
					
				public int getDefaultActionX(GraphicObject go)
					{
						Rectangle goBounds = go.getBounds();
						int goLeft = goBounds.x;
						int goWidth = goBounds.width;
						return (xActionIndex == 0) ? goLeft - 2 : (xActionIndex == 1) ? goLeft + goWidth >> 1 : goLeft + goWidth + 2;
					}
					
				public int getDefaultActionY(GraphicObject go)
					{
						Rectangle goBounds = go.getBounds();
						int goTop = goBounds.y;
						int goHeight = goBounds.height;
						return (yActionIndex == 0) ? goTop - 2 : (yActionIndex == 1) ? goTop + goHeight >> 1 : goTop + goHeight + 2;
					}
					
				public int xOffset(int index)
					{
						return (index == 0) ? left : (index == 1) ? xWestEdge : (index == 2) ? xEastEdge : left + width;
					}
					
				public int yOffset(int index)
					{
						return (index == 0) ? top : (index == 1) ? yNorthEdge : (index == 2) ? ySouthEdge : top + height;
					}
					
				public LayoutObjectsContainer getContainer()
					{
						return LayoutObjectsContainer.this;
					}
					
				public int					top;
				public int					left;
				public int					height;
				public int					width;
				public int					xIndex;
				public int					yIndex;
				public int					xActionIndex	= 1;
				public int					yActionIndex	= 1;
				public boolean	overGO							= false;
				public int					xWestEdge;
				public int					xEastEdge;
				public int					yNorthEdge;
				public int					ySouthEdge;
			}
			
		public class RuleOfThirdsActiveIndex extends ActiveIndex
			{
				public RuleOfThirdsActiveIndex(int mouseX, int mouseY)
					{
						super(mouseX, mouseY);
					}
					
				@Override
				public boolean updateActionIndex(int mouseX, int mouseY)
					{
						int oldXAtionIndex = xActionIndex;
						int oldYActionIndex = yActionIndex;
						LayoutObject lo = getComponent(xIndex, yIndex);
						if (lo != null)
							{
								Rectangle goBounds = lo.getGo().getBounds();
								int w4 = goBounds.width >> 2;
								int h4 = goBounds.height >> 2;
								xWestEdge = goBounds.x + w4;
								xEastEdge = xWestEdge + (w4 << 1);
								yNorthEdge = goBounds.y + h4;
								ySouthEdge = yNorthEdge + (h4 << 1);
								xActionIndex = (width > 0) ? ((mouseX < xWestEdge) ? 0 : (mouseX > xEastEdge) ? 2 : 1) : 1;
								yActionIndex = (height > 0) ? ((mouseY < yNorthEdge) ? 0 : (mouseY > ySouthEdge) ? 2 : 1) : 1;
								overGO = lo.getGo().isOver(mouseX, mouseY) != null;
							}
						else
							{
								xActionIndex = 1;
								yActionIndex = 1;
								overGO = false;
							}
						return (oldXAtionIndex != xActionIndex) || (oldYActionIndex != yActionIndex);
					}
					
			}
			
		public boolean isValidIndex(int i, int j)
			{
				return (i >= 0) && (j >= 0) && (i + j * xCount < components.size());
			}
			
		public LayoutObject getComponent(int i, int j)
			{
				int index = i + j * xCount;
				if ((index >= 0) && (index < components.size()))
					return components.get(index);
				else
					return null;
			}
			
		public boolean isEmpty()
			{
				return components.size() == 0;
			}
			
		public void setComponent(int i, int j, LayoutObject lo)
			{
				int index = i + j * xCount;
				if ((index >= 0) && (index < components.size()))
					{
						LayoutObject old = components.get(index);
						if ((old != null) && (lo == null))
							oCount--;
						if ((old == null) && (lo != null))
							oCount++;
						components.set(index, lo);
						setXModified(true);
						setYModified(true);
						if (lo != null)
							lo.setXYIndex(i, j);
					}
			}
			
		public void setComponent(int linearIndex, LayoutObject lo)
			{
				if ((linearIndex >= 0) && (linearIndex < components.size()))
					{
						LayoutObject old = components.get(linearIndex);
						if ((old != null) && (lo == null))
							oCount--;
						if ((old == null) && (lo != null))
							oCount++;
						components.set(linearIndex, lo);
						setXModified(true);
						setYModified(true);
						if (lo != null)
							lo.setXYIndex(linearIndex % xCount, linearIndex / xCount);
					}
			}
			
		public void setXModified(boolean modified)
			{
				xModified = modified;
				if (!modified)
					for (LayoutObject c : components)
						if (c != null)
							c.setXModified(modified);
			}
			
		public void setYModified(boolean modified)
			{
				yModified = modified;
				if (!modified)
					for (LayoutObject c : components)
						if (c != null)
							c.setYModified(modified);
			}
			
		public void clear()
			{
				components.clear();
				init();
				oCount = 0;
			}
			
		public void clear(int i, int j)
			{
				int index = i + j * xCount;
				if ((index >= 0) && (index < components.size()))
					{
						if ((components.get(index) != null) && (oCount > 0))
							oCount--;
						components.set(index, null);
					}
				updateIndices();
				for (int c = xCount - 1; c >= 0; c--)
					if (maxWidths.get(c) == -1)
						deleteColumn(c, false);
				for (int r = yCount - 1; r >= 0; r--)
					if (maxHeights.get(r) == -1)
						deleteRow(r, false);
				updateTotals();
				setXModified(true);
				setYModified(true);
			}
			
		public void clearEmpty()
			{
				updateIndices();
				for (int c = xCount - 1; c >= 0; c--)
					if (maxWidths.get(c) == -1)
						deleteColumn(c, false);
				for (int r = yCount - 1; r >= 0; r--)
					if (maxHeights.get(r) == -1)
						deleteRow(r, false);
				if ((xCount == 0) || (yCount == 0))
					init();
				else
					updateTotals();
				setXModified(true);
				setYModified(true);
			}
			
		public void reset()
			{
				updateIndices();
				for (int c = xCount - 1; c >= 0; c--)
					if (maxWidths.get(c) == -1)
						deleteColumn(c, false);
				for (int r = yCount - 1; r >= 0; r--)
					if (maxHeights.get(r) == -1)
						deleteRow(r, false);
				updateTotals();
				setXModified(true);
				setYModified(true);
			}
			
		public void insertOnANewRow(int i, int beforeRowIndex, LayoutObject lo)
			{
				if (addFirstComponent(lo))
					return;
				if (beforeRowIndex >= yCount)
					{
						addRow(i, lo);
						return;
					}
				yCount++;
				ArrayList<LayoutObject> row = new ArrayList<LayoutObject>(Arrays.asList(new LayoutObject[xCount]));
				row.set(i, lo);
				components.addAll(beforeRowIndex * xCount, row);
				if (lo != null)
					{
						oCount++;
						maxHeights.add(beforeRowIndex, lo.getHeight());
						if (maxWidths.get(i) < lo.getWidth())
							{
								maxWidths.set(i, lo.getWidth());
								setXModified(true);
							}
					}
				else
					{
						maxHeights.add(beforeRowIndex, -1);
					}
				setYModified(true);
				updateXYIndices(beforeRowIndex * xCount + i);
				// System.out.println("insertOnANewRow -> (" + i + ", " + beforeRowIndex +
				// "):" + ((PathwayElementGO) lo.getGo()).getO().getClass());
			}
			
		public void putInRow(int row, LayoutObject lo)
			{
				if (row < 0)
					{
						addRow(0, lo);
						return;
					}
				if (row >= yCount)
					{
						addRow(yCount, lo);
						return;
					}
				else
					{
						for (int xInd = 0; xInd < xCount; xInd++)
							if (components.get(row * xCount + xInd) == null)
								{
									setComponent(xInd, row, lo);
									return;
								}
						insertOnANewColumn(xCount, row, lo);
					}
			}
			
		public void addRow(int i, LayoutObject lo)
			{
				if (addFirstComponent(lo))
					return;
				yCount++;
				ArrayList<LayoutObject> row = new ArrayList<LayoutObject>(Arrays.asList(new LayoutObject[xCount]));
				row.set(i, lo);
				components.addAll(row);
				if (lo != null)
					{
						oCount++;
						maxHeights.add(lo.getHeight());
						if (maxWidths.get(i) < lo.getWidth())
							{
								maxWidths.set(i, lo.getWidth());
								setXModified(true);
							}
					}
				else
					{
						maxHeights.add(-1);
					}
				setYModified(true);
				lo.setXYIndex(i, yCount - 1);
				// System.out.println("addRow -> (" + i + ", " + yCount + "):" +
				// ((PathwayElementGO) lo.getGo()).getO().getClass());
			}
			
		public void insertOnANewColumn(int beforeColumnIndex, int j, LayoutObject lo)
			{
				if (addFirstComponent(lo))
					return;
				xCount++;
				if (lo != null)
					{
						oCount++;
						for (int row = 0; row < yCount; row++)
							components.add(row * xCount + beforeColumnIndex, (row == j) ? lo : null);
						maxWidths.add(beforeColumnIndex, lo.getWidth());
						if (maxHeights.get(j) < lo.getHeight())
							{
								maxHeights.set(j, lo.getHeight());
								setYModified(true);
							}
					}
				else
					{
						for (int row = 0; row < yCount; row++)
							components.add(row * xCount + beforeColumnIndex, null);
						maxWidths.add(beforeColumnIndex, -1);
					}
				setXModified(true);
				updateXYIndices(0);
				// System.out.println("insertOnANewColumn -> (" + beforeColumnIndex + ", " +
				// j + "):" + ((PathwayElementGO) lo.getGo()).getO().getClass());
			}
			
		public void insertOnANewColumnAndRow(int beforeColumnIndex, int beforeRowIndex, LayoutObject lo)
			{
				if (addFirstComponent(lo))
					return;
				xCount++;
				yCount++;
				ArrayList<LayoutObject> newRow = new ArrayList<LayoutObject>(Arrays.asList(new LayoutObject[xCount]));
				newRow.set(beforeColumnIndex, lo);
				for (int row = 0; row < yCount - 1; row++)
					components.add(row * xCount + beforeColumnIndex, null);
				components.addAll(beforeRowIndex * xCount, newRow);
				if (lo != null)
					{
						oCount++;
						maxHeights.add(beforeRowIndex, lo.getHeight());
						maxWidths.add(beforeColumnIndex, lo.getWidth());
					}
				else
					{
						maxHeights.add(beforeRowIndex, -1);
						maxWidths.add(beforeColumnIndex, -1);
					}
				setXModified(true);
				setYModified(true);
				updateXYIndices(beforeRowIndex * xCount + beforeColumnIndex);
				// System.out.println("insertOnNewColumnAndRow -> (" + beforeColumnIndex +
				// ", " + beforeRowIndex + "):" + ((PathwayElementGO)
				// lo.getGo()).getO().getClass());
			}
			
		public boolean addFirstComponent(LayoutObject lo)
			{
				boolean result = ((xCount == 0) || (yCount == 0));
				if ((lo != null) && result)
					{
						xCount++;
						yCount++;
						components.add(lo);
						if (maxWidths.size() == 0)
							maxWidths.add(lo.getWidth());
						else
							maxWidths.set(0, lo.getWidth());
						if (maxHeights.size() == 0)
							maxHeights.add(lo.getHeight());
						else
							maxHeights.set(0, lo.getHeight());
						setXModified(true);
						setYModified(true);
						// System.out.println("addFirstComponent -> (0,0):" + ((PathwayElementGO)
						// lo.getGo()).getO().getClass());
					}
				return result;
			}
			
		public void insert(ActiveIndex activeIndex, LayoutObject lo)
			{
				if (addFirstComponent(lo))
					return;
				if ((activeIndex.xActionIndex == 1) && (activeIndex.yActionIndex == 1))
					return;
				if (activeIndex.xActionIndex == 1)
					insertOnANewRow(activeIndex.xIndex, activeIndex.yIndex + ((activeIndex.yActionIndex == 0) ? 0 : 1), lo);
				else if (activeIndex.yActionIndex == 1)
					insertOnANewColumn(activeIndex.xIndex + ((activeIndex.xActionIndex == 0) ? 0 : 1), activeIndex.yIndex, lo);
				else
					insertOnANewColumnAndRow(activeIndex.xIndex + ((activeIndex.xActionIndex == 0) ? 0 : 1), activeIndex.yIndex + ((activeIndex.yActionIndex == 0) ? 0 : 1), lo);
			}
			
		public void moveComponent(int fromXIndex, int fromYIndex, int toXIndex, int toYIndex)
			{
				if ((fromXIndex < 0) || (fromYIndex < 0) || (toXIndex < 0) || (toYIndex < 0))
					return;
				if (toXIndex >= xCount)
					{
						addEmptyColumn();
						toXIndex = xCount - 1;
					}
				if (toYIndex >= yCount)
					{
						addEmptyRow();
						toYIndex = yCount - 1;
					}
				int fromIndex = fromXIndex + fromYIndex * xCount;
				int toIndex = toXIndex + toYIndex * xCount;
				LayoutObject lo = components.get(fromIndex);
				components.set(fromIndex, null);
				components.set(toIndex, lo);
				lo.setXYIndex(toXIndex, toYIndex);
				setXModified(true);
				setYModified(true);
			}
			
		public void swapComponents(int fromXIndex, int fromYIndex, int toXIndex, int toYIndex)
			{
				if ((fromXIndex < 0) || (fromYIndex < 0) || (toXIndex < 0) || (toYIndex < 0))
					return;
				int fromIndex = fromXIndex + fromYIndex * xCount;
				int toIndex = toXIndex + toYIndex * xCount;
				LayoutObject lo1 = components.get(fromIndex);
				LayoutObject lo2 = components.get(toIndex);
				components.set(fromIndex, lo2);
				components.set(toIndex, lo1);
				lo1.setXYIndex(toXIndex, toYIndex);
				lo2.setXYIndex(fromXIndex, fromYIndex);
				setXModified(true);
				setYModified(true);
			}
			
		public void addEmptyColumn()
			{
				xCount++;
				for (int row = 0; row < yCount; row++)
					components.add(row * xCount + xCount - 1, null);
				maxWidths.add(-1);
				updateXYIndices(xCount - 1);
				setXModified(true);
			}
			
		public void addEmptyRow()
			{
				yCount++;
				ArrayList<LayoutObject> row = new ArrayList<LayoutObject>(Arrays.asList(new LayoutObject[xCount]));
				components.addAll(row);
				maxHeights.add(-1);
				setYModified(true);
			}
			
		public int getxCount()
			{
				return xCount;
			}
			
		public int getyCount()
			{
				return yCount;
			}
			
		public void deleteRow(int yIndex, boolean updateIndices)
			{
				if (yIndex >= yCount)
					return;
				components.subList(yIndex * xCount, (yIndex + 1) * xCount).clear();
				maxHeights.remove(yIndex);
				yCount--;
				updateXYIndices(0);
				if (updateIndices)
					{
						updateObjectsCount();
						updateMaxWidths();
						updateTotals();
					}
				setXModified(true);
				setYModified(true);
			}
			
		public void deleteColumn(int xIndex, boolean updateIndices)
			{
				if (xIndex >= xCount)
					return;
				for (int i = yCount - 1; i >= 0; i--)
					components.remove(i * xCount + xIndex);
				maxWidths.remove(xIndex);
				xCount--;
				updateXYIndices(0);
				if (updateIndices)
					{
						updateObjectsCount();
						updateMaxHeights();
						updateTotals();
					}
				setXModified(true);
				setYModified(true);
			}
			
		protected void updateObjectsCount()
			{
				oCount = 0;
				for (LayoutObject o : components)
					if (o != null)
						oCount++;
			}
			
		protected void updateMaxWidths()
			{
				if (components.size() == 0)
					return;
				for (int i = xCount - 1; i >= 0; i--)
					maxWidths.set(i, -1);
				int index = xCount * yCount - 1;
				for (int i = xCount - 1; i >= 0; i--)
					{
						int currentMaxWidth = maxWidths.get(i);
						for (int j = yCount - 1; j >= 0; j--)
							{
								LayoutObject lo = components.get(index);
								if ((lo != null) && (currentMaxWidth < lo.getWidth()))
									{
										currentMaxWidth = lo.getWidth();
										maxHeights.set(j, currentMaxWidth);
									}
								index--;
							}
					}
			}
			
		protected void updateMaxHeights()
			{
				if (components.size() == 0)
					return;
				for (int i = yCount - 1; i >= 0; i--)
					maxHeights.set(i, -1);
				int index = xCount * yCount - 1;
				for (int i = xCount - 1; i >= 0; i--)
					for (int j = yCount - 1; j >= 0; j--)
						{
							LayoutObject lo = components.get(index);
							if (lo != null)
								{
									if (maxHeights.get(j) < lo.getHeight())
										maxHeights.set(j, lo.getHeight());
								}
							index--;
						}
			}
			
		protected void updateIndices()
			{
				if (components.size() == 0)
					return;
				for (int i = xCount - 1; i >= 0; i--)
					maxWidths.set(i, -1);
				for (int i = yCount - 1; i >= 0; i--)
					maxHeights.set(i, -1);
				int index = xCount * yCount - 1;
				for (int j = yCount - 1; j >= 0; j--)
					{
						int currentMaxHeight = maxHeights.get(j);
						for (int i = xCount - 1; i >= 0; i--)
							{
								LayoutObject lo = components.get(index);
								if (lo != null)
									{
										if (maxWidths.get(i) < lo.getWidth())
											maxWidths.set(i, lo.getWidth());
										if (currentMaxHeight < lo.getHeight())
											{
												currentMaxHeight = lo.getHeight();
												maxHeights.set(j, currentMaxHeight);
											}
									}
								index--;
							}
					}
			}
			
		public void updateTotals()
			{
				if (components.size() == 0)
					{
						totalWidth = super.getWidth();
						totalHeight = super.getHeight();
					}
				else
					{
						totalWidth = 0;
						for (Integer widths : maxWidths)
							if (widths != -1)
								totalWidth += widths;
						totalHeight = 0;
						for (Integer heights : maxHeights)
							if (heights != -1)
								totalHeight += heights;
					}
			}
			
		public void update()
			{
				for (LayoutObject lo : components)
					if ((lo != null) && (lo instanceof LayoutObjectsContainer))
						((LayoutObjectsContainer) lo).update();
				updateIndices();
				updateTotals();
			}
			
		private void initOffsets()
			{
				if (xCount == 0)
					{
						xOffsets = new int[1];
						xOffsets[0] = x + getActualWidth();
					}
				else
					xOffsets = new int[xCount];
				if (yCount == 0)
					{
						yOffsets = new int[1];
						yOffsets[0] = y + getActualHeight();
					}
				else
					yOffsets = new int[yCount];
			}
			
		protected void distribute(HorizontalAlignment ha, VerticalAlignment va)
			{
				alignHorizontally(ha, 0, getActualWidth());
				alignVertically(va, 0, getActualHeight());
				initOffsets();
				distributeObjects();
			}
			
		protected void distributeObjects()
			{
				int xOffset = x;
				int yOffset = y;
				int index = 0;
				float wScale = ((float) getActualWidth()) / ((float) totalWidth);
				float hScale = ((float) getActualHeight()) / ((float) totalHeight);
				for (int j = 0; j < yCount; j++)
					{
						int neededHeight = maxHeights.get(j);
						if (neededHeight == -1)
							neededHeight = 0;
						neededHeight = Math.round(neededHeight * hScale);
						xOffset = x;
						for (int i = 0; i < xCount; i++)
							{
								LayoutObject lo = components.get(index);
								int neededWidth = maxWidths.get(i);
								if (neededWidth == -1)
									neededWidth = 0;
								neededWidth = Math.round(neededWidth * wScale);
								if (lo != null)
									{
										lo.alignHorizontally(horizontalElementsAlignment, xOffset, neededWidth);
										lo.alignVertically(verticalElementsAlignment, yOffset, neededHeight);
									}
								xOffset += neededWidth;
								xOffsets[i] = xOffset;
								index++;
							}
						yOffset += neededHeight;
						yOffsets[j] = yOffset;
					}
				for (LayoutObject lo : components)
					if ((lo != null) && (lo instanceof LayoutObjectsContainer))
						{
							((LayoutObjectsContainer) lo).initOffsets();
							if (!((LayoutObjectsContainer) lo).isEmpty())
								((LayoutObjectsContainer) lo).distributeObjects();
						}
				setXModified(false);
				setYModified(false);
			}
			
		protected void init()
			{
				xCount = 0;
				yCount = 0;
				totalWidth = super.getWidth();
				maxWidths = new ArrayList<Integer>();
				maxWidths.add(totalWidth);
				totalHeight = super.getHeight();
				maxHeights = new ArrayList<Integer>();
				maxHeights.add(totalHeight);
				components = new ArrayList<LayoutObject>();
			}
			
		public void init(int xCount, int yCount)
			{
				this.xCount = xCount;
				this.yCount = yCount;
				maxWidths = new ArrayList<Integer>(Arrays.asList(new Integer[xCount]));
				maxHeights = new ArrayList<Integer>(Arrays.asList(new Integer[yCount]));
				components = new ArrayList<LayoutObject>(Arrays.asList(new LayoutObject[xCount * yCount]));
			}
			
		public ArrayList<Integer> getMaxWidths()
			{
				return maxWidths;
			}
			
		public void setMaxWidths(ArrayList<Integer> maxWidths)
			{
				if (maxWidths.size() == xCount)
					{
						this.maxWidths = maxWidths;
						setXModified(true);
					}
			}
			
		public void setMaxWidths(int maxWidth)
			{
				if (xCount == 1)
					{
						this.maxWidths.set(0, maxWidth);
						setXModified(true);
					}
			}
			
		public ArrayList<Integer> getMaxHeights()
			{
				return maxHeights;
			}
			
		public void setMaxHeights(ArrayList<Integer> maxHeights)
			{
				if (maxHeights.size() == yCount)
					{
						this.maxHeights = maxHeights;
						setYModified(true);
					}
			}
			
		public void setMaxHeights(int maxHeight)
			{
				if (yCount == 1)
					{
						this.maxHeights.set(0, maxHeight);
						setYModified(true);
					}
			}
			
		public static LayoutObjectsContainer HorizontalGOC2LOC(LayoutObjectsContainer parent, GraphicObjectsContainer goc)
			{
				if (goc != null)
					{
						LayoutObjectsContainer loc = new LayoutObjectsContainer(parent);
						loc.init(goc.getCount(), 1);
						if (goc instanceof GraphicObjectsContainer)
							{
								ArrayList<GraphicObject> containedGOs = goc.getList();
								for (int i = containedGOs.size() - 1; i >= 0; i--)
									{
										GraphicObject go = containedGOs.get(i);
										LayoutObject lo = (go instanceof GraphicObjectsContainer) ? HorizontalGOC2LOC(loc, (GraphicObjectsContainer) go) : new LayoutObject(loc);
										lo.setGo(go);
										loc.setComponent(i, lo);
									}
							}
						return loc;
					}
				else
					return null;
			}
			
		public static LayoutObjectsContainer VerticalGOC2LOC(LayoutObjectsContainer parent, GraphicObjectsContainer goc)
			{
				if (goc != null)
					{
						LayoutObjectsContainer loc = new LayoutObjectsContainer(parent);
						loc.init(1, goc.getCount());
						if (goc instanceof GraphicObjectsContainer)
							{
								ArrayList<GraphicObject> containedGOs = goc.getList();
								for (int i = containedGOs.size() - 1; i >= 0; i--)
									{
										GraphicObject go = containedGOs.get(i);
										LayoutObject lo = (go instanceof GraphicObjectsContainer) ? VerticalGOC2LOC(loc, (GraphicObjectsContainer) go) : new LayoutObject(loc);
										lo.setGo(go);
										loc.setComponent(i, lo);
									}
							}
						return loc;
					}
				else
					return null;
			}
			
		public GraphicObjectsContainer getGo()
			{
				return goc;
			}
			
		public void setGo(GraphicObjectsContainer goc)
			{
				super.setGo(goc);
				super.updateProperties();
				this.goc = goc;
			}
			
		public LayoutObject isOver(MouseEvent evt)
			{
				return isOver(evt.getX(), evt.getY());
			}
			
		public LayoutObject isOver(int x, int y)
			{
				int i = getXIndexByX(x);
				int j = getYIndexByY(y);
				boolean active = (i != -1) && (j != -1);
				if (active)
					{
						LayoutObject lo = getComponent(i, j);
						if (lo != null)
							{
								LayoutObject l = lo.isOver(x, y);
								if (l != null)
									return l;
								else
									return lo;
							}
						else
							return this;
					}
				return null;
			}
			
		public int getXIndexByX(int x)
			{
				int width = getActualWidth();
				// System.out.println("widht = "+width+" this.x = "+this.x+" x = "+x+"
				// xOffsets = "+Arrays.toString(xOffsets)+" xCount= "+xCount);
				boolean inside = (this.x <= x) && (this.x + width >= x);
				if (inside)
					{
						if (xCount == 0)
							return 0;
						int bestGuessXIndex = xCount * (x - this.x) / width;
						if (bestGuessXIndex >= xCount-1)
							return xCount - 1;
						while ((bestGuessXIndex > 0) && (x < xOffsets[bestGuessXIndex]))
							bestGuessXIndex--;
						while ((bestGuessXIndex < xCount) && (x > xOffsets[bestGuessXIndex]))
							bestGuessXIndex++;
						return bestGuessXIndex;
					}
				else
					return -1;
			}
			
		public int getYIndexByY(int y)
			{
				int height = getActualHeight();
				boolean inside = (this.y <= y) && (this.y + height >= y);
				if (inside)
					{
						if (yCount == 0)
							return 0;
						int bestGuessYIndex = yCount * (y - this.y) / height;
						if (bestGuessYIndex >= yCount-1)
							return yCount - 1;
						while ((bestGuessYIndex > 0) && (y < yOffsets[bestGuessYIndex]))
							bestGuessYIndex--;
						while ((bestGuessYIndex < yCount) && (y > yOffsets[bestGuessYIndex]))
							bestGuessYIndex++;
						return bestGuessYIndex;
					}
				else
					return -1;
			}
			
		public void makeItAccept(Class<?> c)
			{
				if (accepted == null)
					accepted = new ArrayList<Class<?>>();
				accepted.add(c);
			}
			
		public ArrayList<Class<?>> getAccepts()
			{
				return accepted;
			}
			
		public void makeItReject(Class<?> c)
			{
				if (rejected == null)
					rejected = new ArrayList<Class<?>>();
				rejected.add(c);
			}
			
		public ArrayList<Class<?>> getRejects()
			{
				return rejected;
			}
			
		public boolean isCompatible(Class<?> objectClass)
			{
				return ((accepted == null) && (rejected == null)) || ((accepted != null) && (accepted.contains(objectClass))) || ((rejected != null) && (!rejected.contains(objectClass)));
			}
			
		private void updateXYIndices(int index)
			{
				int xInd = xCount - 1;
				int yInd = yCount - 1;
				for (int i = components.size() - 1; i >= index; i--)
					{
						LayoutObject lo = components.get(i);
						if (lo != null)
							lo.setXYIndex(xInd, yInd);
						if (xInd == 0)
							{
								xInd = xCount;
								yInd--;
							}
						xInd--;
					}
			}
			
		public int getWidth()
			{
				if (totalWidth == 0)
					return (go != null) ? go.getStandardSize().getTotlaWidth() : 0;
				else
					return totalWidth;
			}
			
		public int getHeight()
			{
				if (totalHeight == 0)
					return (go != null) ? go.getStandardSize().getTotlaHeight() : 0;
				else
					return totalHeight;
			}
			
		public HorizontalAlignment getHorizontalElementsAlignment()
			{
				return horizontalElementsAlignment;
			}
			
		public void setHorizontalElementsAlignment(HorizontalAlignment horizontalElementsAlignment)
			{
				this.horizontalElementsAlignment = horizontalElementsAlignment;
			}
			
		public VerticalAlignment getVerticalElementsAlignment()
			{
				return verticalElementsAlignment;
			}
			
		public void setVerticalElementsAlignment(VerticalAlignment verticalElementsAlignment)
			{
				this.verticalElementsAlignment = verticalElementsAlignment;
			}
			
		public void setContainerComponentsAligment(HorizontalAlignment ha, VerticalAlignment va)
			{
				for (LayoutObject lo : components)
					if ((lo != null) && (lo instanceof LayoutObjectsContainer))
						{
							((LayoutObjectsContainer) lo).setHorizontalElementsAlignment(ha);
							((LayoutObjectsContainer) lo).setVerticalElementsAlignment(va);
							((LayoutObjectsContainer) lo).setContainerComponentsAligment(ha, va);
						}
			}
			
		public void rescale(Scale scale)
			{
				setScale(scale);
				for (LayoutObject lo : components)
					if (lo != null)
						{
							lo.setScale(scale);
							if (lo instanceof LayoutObjectsContainer)
								((LayoutObjectsContainer) lo).rescale(scale);
						}
			}
			
		public void updateProperties()
			{
				for (LayoutObject lo : components)
					if (lo != null)
						lo.updateProperties();
			}
			
		public void setAvailableSpace(int availableWidth, int availableHeight)
			{
				this.availableHeight = availableHeight;
				this.availableWidth = availableWidth;
				distribute(HorizontalAlignment.GAPLESSFILL, VerticalAlignment.GAPLESSFILL);
				// System.out.println(getGo() == null ? "null" :
				// getGo().getClass().getSimpleName());
				// System.out.println("set availabel = " + availableWidth + ", " +
				// availableHeight + " while totsl is = " + getWidth() + ", " +
				// getHeight());
				
			}
			
		public int getActualWidth()
			{
				return ((availableWidth > totalWidth)) ? availableWidth : totalWidth;
			}
			
		public int getActualHeight()
			{
				return ((availableHeight > totalHeight)) ? availableHeight : totalHeight;
			}
			
		public int getActualRight()
			{
				return x + getActualWidth();
			}
			
		public int getActualBottom()
			{
				return y + getActualHeight();
			}
			
		public ActiveIndex getActiveIndex(int mouseX, int mouseY)
			{
				return new RuleOfThirdsActiveIndex(mouseX, mouseY);
			}
			
		public ActiveIndex getSimpleActiveIndex(int mouseX, int mouseY)
			{
				return new ActiveIndex(mouseX, mouseY);
			}
			
		public Iterator<LayoutObject> getComponentsIterator()
			{
				return components.iterator();
			}
			
		protected GraphicObjectsContainer	goc;
		protected ArrayList<LayoutObject>	components;
		protected ArrayList<Class<?>>					accepted																				= null;
		protected ArrayList<Class<?>>					rejected																				= null;
		
		protected int																					xCount																						= 0;
		protected int																					yCount																						= 0;
		protected int																					oCount																						= 0;
		
		protected int																					xOffsets[];
		protected int																					yOffsets[];
		protected ArrayList<Integer>						maxWidths;
		protected ArrayList<Integer>						maxHeights;
		protected int																					totalWidth;
		protected int																					totalHeight;
		protected HorizontalAlignment					horizontalElementsAlignment	= HorizontalAlignment.GAPLESSFILL;
		protected VerticalAlignment							verticalElementsAlignment			= VerticalAlignment.GAPLESSFILL;
	}

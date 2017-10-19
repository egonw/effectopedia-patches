package org.qsari.effectopedia.go.Layout;

import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.StandardGOSize;

public class LayoutObject
	{
		public LayoutObject()
			{
				super();
				this.parent = null;
			}
			
		public LayoutObject(LayoutObjectsContainer parent)
			{
				super();
				this.parent = parent;
			}
			
		public boolean isXModified()
			{
				return xModified;
			}
			
		public void setXModified(boolean modified)
			{
				xModified = modified;
				if ((parent != null) && (modified))
					parent.setXModified(modified);
			}
			
		public boolean isYModified()
			{
				return yModified;
			}
			
		public void setYModified(boolean modified)
			{
				yModified = modified;
				if ((parent != null) && (modified))
					parent.setYModified(modified);
			}
			
		public int getMidX()
			{
				return this.x + (width >> 1);
			}
			
		public int getMidY()
			{
				return this.y + (height >> 1);
			}
			
		public int getX()
			{
				return this.x;
			}
			
		public int getY()
			{
				return this.y;
			}
			
		public int getWidth()
			{
				return width;
			}
			
		public int getHeight()
			{
				return height;
			}
			
		public int getBottom()
			{
				return this.y + this.height;
			}
			
		public int getRight()
			{
				return this.x + this.width;
			}

		public int getxIndex()
			{
				return xIndex;
			}
			
		public void setxIndex(int xIndex)
			{
				this.xIndex = xIndex;
			}
			
		public int getyIndex()
			{
				return yIndex;
			}
			
		public void setyIndex(int yIndex)
			{
				this.yIndex = yIndex;
			}
			
		public void setXYIndex(int xIndex, int yIndex)
			{
				this.xIndex = xIndex;
				this.yIndex = yIndex;
			}
			
		public int getUnscaledWidth()
			{
				return unscaledWidth;
			}
			
		public void setUnscaledWidth(int unscaledWidth)
			{
				this.unscaledWidth = unscaledWidth;
				this.width = Math.round(xScale * unscaledWidth + eInset + wInset + (fixedGap << 1));
				setXModified(true);
			}
			
		public int getUnscaledHeight()
			{
				return unscaledHeight;
			}
			
		public void setUnscaledHeight(int unscaledHeight)
			{
				this.unscaledHeight = unscaledHeight;
				this.height = Math.round(yScale * unscaledHeight + nInset + sInset + (fixedGap << 1));
				setYModified(true);
			}
			
		public float getxScale()
			{
				return xScale;
			}
			
		public void setxScale(float xScale)
			{
				if (limitedScalability)
					this.xScale = ((xScale < 1.0F) && (xScale > 0)) ? xScale : 1.0F;
				else
					this.xScale = (xScale != 0) ? xScale : 1.0F;
				this.width = Math.round(xScale * unscaledWidth + eInset + wInset + (fixedGap << 1));
				setXModified(true);
			}
			
		public float getyScale()
			{
				return yScale;
			}
			
		public void setyScale(float yScale)
			{
				if (limitedScalability)
					this.yScale = ((yScale < 1.0F) && (yScale > 0)) ? yScale : 1.0F;
				else
					this.yScale = (yScale != 0) ? yScale : 1.0F;
				this.height = Math.round(yScale * unscaledHeight + nInset + sInset + (fixedGap << 1));
				setYModified(true);
			}
			
		public int getUnscaledHInset()
			{
				return unscaledNInset;
			}
			
		public void setUnscaledHInset(int unscaledHInset)
			{
				this.unscaledNInset = unscaledHInset;
				this.width = Math.round(xScale * unscaledWidth + eInset + wInset + (fixedGap << 1));
			}
			
		public int getUnscaledVInset()
			{
				return unscaledSInset;
			}
			
		public void setUnscaledVInset(int unscaledVInset)
			{
				this.unscaledSInset = unscaledVInset;
				this.height = Math.round(yScale * unscaledHeight + nInset + sInset + (fixedGap << 1));
			}
			
		public int getFixedGap()
			{
				return fixedGap;
			}
			
		public void setFixedGap(int fixedGap)
			{
				this.fixedGap = fixedGap;
				fixedGap = (fixedGap << 1);
				this.width = Math.round(xScale * unscaledWidth + eInset + wInset + (fixedGap << 1));
				this.height = Math.round(yScale * unscaledHeight + nInset + sInset + (fixedGap << 1));
			}
			
		public float getxInsetScale()
			{
				return xInsetScale;
			}
			
		public void setxInsetScale(float xInsetScale)
			{
				if (limitedScalability)
					this.xInsetScale = (xInsetScale < 1.0F) ? xInsetScale : 1.0F;
				else
					this.xInsetScale = xInsetScale;
				this.eInset = Math.round(unscaledEInset * xInsetScale);
				this.wInset = Math.round(unscaledWInset * xInsetScale);
				this.width = Math.round(xScale * unscaledWidth + eInset + wInset + (fixedGap << 1));
			}
			
		public float getyInsetScale()
			{
				return yInsetScale;
			}
			
		public void setyInsetScale(float yInsetScale)
			{
				if (limitedScalability)
					this.yInsetScale = (yInsetScale < 1.0F) ? yInsetScale : 1.0F;
				else
					this.yInsetScale = yInsetScale;
				this.yInsetScale = yInsetScale;
				this.nInset = Math.round(unscaledNInset * yInsetScale);
				this.sInset = Math.round(unscaledSInset * yInsetScale);
				this.height = Math.round(yScale * unscaledHeight + nInset + sInset + (fixedGap << 1));
			}
			
		public GraphicObject getGo()
			{
				return go;
			}
			
		public void setGo(GraphicObject go)
			{
				this.go = go;
				updateProperties();
			}
			
		public void updateProperties()
			{
				if (go != null)
					{
						StandardGOSize sz = go.getStandardSize();
						this.unscaledHeight = sz.getHeight();
						this.unscaledWidth = sz.getWidth();
						this.unscaledNInset = sz.getNInset();
						this.unscaledSInset = sz.getSInset();
						this.unscaledEInset = sz.getEInset();
						this.unscaledWInset = sz.getWInset();
						this.fixedGap = sz.getFixedGap();
						this.limitedScalability = sz.getLimitedScalability();
						this.setxInsetScale(xInsetScale);
						this.setyInsetScale(yInsetScale);
					}
			}
			
		public void setScale(Scale scale)
			{
				float xScale = scale.getObjectWidthScale();
				if (limitedScalability)
					this.xScale = ((xScale <= 1.0F) && (xScale > 0)) ? xScale : 1.0F;
				else
					this.xScale = (xScale != 0) ? xScale : 1.0F;
				float yScale = scale.getObjectHeightScale();
				if (limitedScalability)
					this.yScale = ((yScale <= 1.0F) && (yScale > 0)) ? yScale : 1.0F;
				else
					this.yScale = (yScale != 0) ? yScale : 1.0F;
				this.setxInsetScale(scale.getHorizontalInsetScale());
				this.setyInsetScale(scale.getVerticalInsetScale());
			}
			
		public LayoutObjectsContainer getParent()
			{
				return parent;
			}
			
		public void alignHorizontally(HorizontalAlignment ha, int left, int availableWidth)
			{
				if (go == null)
					return;
				this.availableWidth = availableWidth;
				switch (ha)
					{
						default:
						case LEFT:
							{
								x = left;
								go.setX(left + wInset + fixedGap);
								go.setWidth(width - wInset - eInset - (fixedGap << 1));
							}
							break;
						case RIGHT:
							{
								int w = width - eInset - fixedGap;
								x = left;
								go.setX(x + availableWidth - w);
								go.setWidth(w - wInset - fixedGap);
							}
							break;
						case CENTER:
						case OPTIMIZED:
							{
								int w = width - wInset - eInset - (fixedGap << 1);
								x = left;
								go.setX(x + (availableWidth - w) / 2);
								go.setWidth(w);
							}
							break;
						case FILL:
							{
								x = left;
								if (limitedScalability)
									{
										int w = width - wInset - eInset - (fixedGap << 1);
										go.setX(x + (availableWidth - w) / 2);
										go.setWidth(w);
									}
								else
									{
										go.setX(left + wInset + fixedGap);
										go.setWidth(availableWidth - wInset - eInset - (fixedGap << 1));
									}
							}
							break;
						case GAPLESSFILL:
							{
								x = left;
								go.setX(left);
								go.setWidth(availableWidth);
							}
							break;
					}
				xModified = false;
			}
			
		public void alignVertically(VerticalAlignment va, int top, int availableHeight)
			{
				if (go == null)
					return;
				this.availableHeight = availableHeight;
				if ((limitedScalability) && va.equals(VerticalAlignment.FILL))
					va = VerticalAlignment.MIDDLE;
				switch (va)
					{
						default:
						case TOP:
							{
								y = top;
								go.setY(top + nInset + fixedGap);
								go.setHeight(height - nInset - sInset - (fixedGap << 1));
							}
							break;
						case BOTTOM:
							{
								int h = height - sInset - fixedGap;
								y = top;
								go.setY(y + availableHeight - h);
								go.setHeight(h - nInset - fixedGap);
							}
							break;
						case MIDDLE:
						case OPTIMIZED:
							{
								int h = height - nInset - sInset - (fixedGap << 1);
								y = top;
								go.setY(y + (availableHeight - h) / 2);
								go.setHeight(h);
							}
							break;
						case FILL:
							{
								y = top;
								if (limitedScalability)
									{
										int h = height - nInset - sInset - (fixedGap << 1);
										go.setY(y + (availableHeight - h) / 2);
										go.setHeight(h);
									}
								else
									{
										go.setY(top + nInset + fixedGap);
										go.setHeight(availableHeight - nInset - sInset - (fixedGap << 1));
									}
							}
							break;
						case GAPLESSFILL:
							{
								y = top;
								go.setY(top);
								go.setHeight(availableHeight);
							}
							break;
					}
				yModified = false;
			}
			
		public LayoutObject isOver(int x, int y)
			{
				boolean active = (this.x < x) && (this.y < y) && (this.x + width > x) && (this.y + height > y);
				go.setActive(active);
				return (active) ? this : null;
			}
			
		public int getAvailableWidth()
			{
				return availableWidth;
			}
			
		public void setAvailableWidth(int availableWidth)
			{
				this.availableWidth = availableWidth;
				// System.out.println("available width=" + availableWidth);
			}
			
		public int getAvailableHeight()
			{
				return availableHeight;
			}
			
		public void setAvailableHeight(int availableHeight)
			{
				this.availableHeight = availableHeight;
			}
			
		public void setAvailableSpace(int availableWidth, int availableHeight)
			{
				this.availableHeight = availableHeight;
				this.availableWidth = availableWidth;
			}
			
		public final boolean isLimitedScalability()
			{
				return limitedScalability;
			}
			
		public boolean hasAdjacentPosition(int xIndexDif, int yIndexDif)
			{
				int x = xIndex + xIndexDif;
				int y = yIndex + yIndexDif;
				if (parent != null)
					if ((x >= 0) && (x < parent.getxCount()) && (y >= 0) && (y < parent.getyCount()))
						return true;
				return false;
			}
			
		public LayoutObject getAdjacentObject(int xIndexDif, int yIndexDif)
			{
				int x = xIndex + xIndexDif;
				int y = yIndex + yIndexDif;
				if (parent != null)
					if ((x >= 0) && (x < parent.getxCount()) && (y >= 0) && (y < parent.getyCount()))
						return parent.getComponent(x, y);
				return null;
			}
			
		public int countEmptyAjaicentHorizontalBlockOfSlots(int yIndexDif, int prefferedBlockSize)
			{
				int cnt = prefferedBlockSize;
				if (parent != null)
					{
						int i = 0;
						while (cnt > 0)
							{
								int x = xIndex + i;
								int y = yIndex + yIndexDif;
								LayoutObject lo = ((x >= 0) && (x < parent.getxCount()) && (y >= 0) && (y < parent.getyCount())) ? parent.getComponent(x, y) : null;
								if (lo != null)
									break;
								i = (i < 0) ? -i + 1 : -i;
							}
					}
				return prefferedBlockSize - cnt;
			}
			
		public boolean isTemporary()
			{
				return temporary;
			}

		public void setTemporary(boolean temporary)
			{
				this.temporary = temporary;
				if (go!=null)
					go.setTemporary(temporary);
			}

		protected LayoutObjectsContainer	parent;
		protected GraphicObject										go;
		protected boolean																temporary;
		protected int																				x;
		protected int																				y;
		protected int																				xIndex										= 0;
		protected int																				yIndex										= 0;
		protected int																				unscaledNInset;
		protected int																				unscaledSInset;
		protected int																				unscaledEInset;
		protected int																				unscaledWInset;
		protected int																				fixedGap;
		protected int																				unscaledWidth;
		protected int																				unscaledHeight;
		protected float																		xInsetScale					= 1.0F;
		protected float																		yInsetScale					= 1.0F;
		protected float																		xScale										= 1.0F;
		protected float																		yScale										= 1.0F;
		protected boolean																limitedScalability;
		protected boolean																xModified;
		protected boolean																yModified;
		private int																						nInset;
		private int																						sInset;
		private int																						eInset;
		private int																						wInset;
		private int																						width;
		private int																						height;
		protected int																				availableWidth		= 0;
		protected int																				availableHeight	= 0;
		
	}

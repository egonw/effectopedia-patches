package org.qsari.effectopedia.gui.im;

import java.awt.AlphaComposite;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.Layout.LayoutObject;
import org.qsari.effectopedia.go.pathway_elements.PathwayElementGO;
import org.qsari.effectopedia.gui.ContextPopupMenusFactoryUI;
import org.qsari.effectopedia.gui.PathwaysViewUI;

public class EditIM extends InterfaceMode
	{
		public EditIM(PathwaysViewUI pathwayUI, InterfaceModes owner)
			{
				super(pathwayUI, owner);
				Cursor c = Cursor.getDefaultCursor();
				setCursors(make5StateCursors(c, c, c, c, c));
				alternativeModeType = DRAG;
				pathwaysView.getViewLayout().setArcsSelectable(true);
			}
			
		public void mousePressed(MouseEvent e)
			{
				if (e.isPopupTrigger())
					{
						ContextPopupMenusFactoryUI.getPopupMenu(pathwaysViewUI, getCurrentEO(),selection).show(pathwaysViewUI, e.getX(), e.getY());
						return;
					}
				super.mousePressed(e);
				this.lastMouseX = this.lastX;
				this.lastMouseY = this.lastY;
				mouseIsDragged = false;
			}
			
		public PathwayElement getCurrentActivePathwayElement()
			{
				if ((currentGO == null) || (!(viewLayout.getActiveRegion().isCenterAction())))
					return null;
				if (currentGO instanceof PathwayElementGO)
					return ((PathwayElementGO) currentGO).getO();
				else
					return null;
			}
			
		public void mouseClicked(MouseEvent e)
			{
				super.mouseClicked(e);
				if (currentLO == null)
					{
						selection.unselect(viewLayout);
						pathwaysViewUI.repaint();
						lastSelectedLO = null;
					}
			}
			
		public void mouseReleased(MouseEvent e)
			{
				if (e.isPopupTrigger())
					{
						ContextPopupMenusFactoryUI.getPopupMenu(pathwaysViewUI, getCurrentEO(),selection).show(pathwaysViewUI, e.getX(), e.getY());
						return;
					}
				if (mouseIsDragged)
					{
						int x = lastX < lastMouseX ? lastX : lastMouseX;
						int y = lastY < lastMouseY ? lastY : lastMouseY;
						int width = Math.abs(lastX - lastMouseX);
						int height = Math.abs(lastY - lastMouseY);
						drawSelectionRect(x, y, width, height);
						selection.select(viewLayout, x, y, width, height);
						pathwaysViewUI.repaint();
					}
				else if (currentGO != null)
					{
						if (keyCtrlPressed)
							{
								if (currentGO.isSelected())
									selection.unselect(currentLO);
								else
									selection.select(currentLO);
							}
						else if (keyShiftPressed)
							{
								if (lastSelectedLO != null)
									{
										if (lastSelectedLO.getX() < currentLO.getX())
											selection.select(pathwayDataView.getLayoutObjectsMap(), lastSelectedLO, currentLO);
										else
											selection.select(pathwayDataView.getLayoutObjectsMap(), currentLO, lastSelectedLO);
										lastSelectedLO = null;
									}
								else
									lastSelectedLO = currentLO;
							}
						else
							{
								selection.unselect(viewLayout);
								selection.select(currentLO);
							}
						pathwaysViewUI.repaint();
					}
			}
			
		public void mouseDragged(MouseEvent e)
			{
				mouseIsDragged = true;
				// if (currentLO == null)
					{// Selecting multiple objects
						int x = e.getX();
						int y = e.getY();
						eraseSelectionRect(lastX < lastMouseX ? lastX : lastMouseX, lastY < lastMouseY ? lastY : lastMouseY, Math.abs(lastX - lastMouseX), Math.abs(lastY - lastMouseY));
						drawSelectionRect(lastX < x ? lastX : x, lastY < y ? lastY : y, Math.abs(lastX - x), Math.abs(lastY - y));
						lastMouseX = x;
						lastMouseY = y;
					}
			}
			
		private void eraseSelectionRect(int x, int y, int width, int height)
			{
				if ((width != 0) && (height != 0))
					{
						// GraphicsEnvironment ge =
						// GraphicsEnvironment.getLocalGraphicsEnvironment();
						// GraphicsDevice gs = ge.getDefaultScreenDevice();
						// GraphicsConfiguration gc = gs.getDefaultConfiguration();
						Rectangle bounds = new Rectangle(x - 1, y - 1, width + 2, height + 2);// gc.getBounds();
						// BufferedImage buffer = gc.createCompatibleImage(width+8, height+8,
						// Transparency.TRANSLUCENT);
						Graphics2D g = (Graphics2D) pathwaysViewUI.getGraphics();
						g.setClip(bounds);
						// pathwaysView.getViewLayout().draw((Graphics2D) buffer.getGraphics());
						pathwaysView.getViewLayout().draw(g);
						// g.drawImage(buffer, null, 0, 0);
					}
			}
			
		private void drawSelectionRect(int x, int y, int width, int height)
			{
				Graphics2D g = (Graphics2D) pathwaysViewUI.getGraphics();
				g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5F));
				g.setStroke(DefaultGOSettings.selectionPen);
				g.setColor(DefaultGOSettings.uiSelectedColor);
				g.fillRect(x, y, width, height);
				g.setColor(DefaultGOSettings.activeRegionColor);
				g.drawRect(x, y, width, height);
				g.setComposite(AlphaComposite.Src);
			}
			
		public void setCurrentLO(LayoutObject currentLO)
			{
				this.currentLO = currentLO;
				if (currentLO == null)
					this.currentGO = null;
				else if (viewLayout.getActiveRegion().isOverGO())
					this.currentGO = currentLO.getGo();
				else
					this.currentGO = null;
			}
			
		protected void reset()
			{
				viewLayout.setSimpleActiveRegion(true);
				viewLayout.setShowActiveRegion(false);
				pathwaysView.getViewLayout().setArcsSelectable(true);
			}
			
		public String getContext()
			{
				return "";
			}
			
		private LayoutObject	lastSelectedLO;
		private int										lastMouseX;
		private int										lastMouseY;
		private boolean						mouseIsDragged;
	}

package org.qsari.effectopedia.gui.im;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import org.qsari.effectopedia.core.objects.DocumentedKnowledge_Located;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.go.Layout.LayoutObject;
import org.qsari.effectopedia.go.Layout.LayoutObjectsContainer;
import org.qsari.effectopedia.go.pathway_elements.PathwayElementGO;
import org.qsari.effectopedia.gui.ContextPopupMenusFactoryUI;
import org.qsari.effectopedia.gui.PathwaysViewUI;
import org.qsari.effectopedia.gui.UIResources;

public class DragIM extends InterfaceMode
	{
		public DragIM(PathwaysViewUI pathwayUI, InterfaceModes owner)
			{
				super(pathwayUI, owner);
				setCursors(make5StateCursors(Cursor.getDefaultCursor(), UIResources.openHandCursor, UIResources.grabHandCursor, UIResources.openHandOverObjectCursor, UIResources.grabObjectWithHandCursor));
				alternativeModeType = EDIT;
				viewLayout.setShowActiveRegion(false);
				viewLayout.setSimpleActiveRegion(true);
			}
			
		public void mousePressed(MouseEvent e)
			{
				if (e.isPopupTrigger())
					ContextPopupMenusFactoryUI.getPopupMenu(pathwaysViewUI, getCurrentEO(),selection).show(pathwaysViewUI, e.getX(), e.getY());
				else
					{
						lastX = e.getX();
						lastY = e.getY();
						setCurrentLO(viewLayout.isOver(lastX, lastY));
						setLastLO(viewLayout.getLastLO());
						currentContainer = viewLayout.getCurrentContainer();
						viewLayout.setShowActiveRegion(currentGO != null);
						if (currentContainer != null)
							pathwaysViewUI.repaint(currentContainer.getX() - 2, currentContainer.getY() - 2, currentContainer.getActualWidth() + 4, currentContainer.getActualHeight() + 4);
						mouseIsDragged = true;
						determineState();
					}
			}
			
		public void mouseReleased(MouseEvent e)
			{
				if (e.isPopupTrigger())
					ContextPopupMenusFactoryUI.getPopupMenu(pathwaysViewUI, getCurrentEO(),selection).show(pathwaysViewUI, e.getX(), e.getY());
				else
					{
						viewLayout.setShowActiveRegion(false);
						LayoutObjectsContainer cursorContainer = viewLayout.getLOContainerUnderCursor(e.getX(), e.getY());
						if (currentContainer == cursorContainer)
							moveInsideCurrentContainter(e.getX(), e.getY());
						else
							moveToDifferentContainer(cursorContainer, e.getX(), e.getY());
						mouseIsDragged = false;
						determineState();
					}
			}
			
		private void moveInsideCurrentContainter(int x, int y)
			{
				pathwaysViewUI.repaint(currentContainer.getX() - 2, currentContainer.getY() - 2, currentContainer.getActualWidth() + 4, currentContainer.getActualHeight() + 4);
				int currentXIndex = currentContainer.getXIndexByX(x);
				int currentYIndex = currentContainer.getYIndexByY(y);
				if (currentLO != null)
					{
						LayoutObject lo = currentContainer.getComponent(currentXIndex, currentYIndex);
						if (lo == null)
							{
								currentContainer.moveComponent(currentLO.getxIndex(), currentLO.getyIndex(), currentXIndex, currentYIndex);
								viewLayout.cleanup();
							}
						else
							currentContainer.swapComponents(currentLO.getxIndex(), currentLO.getyIndex(), currentXIndex, currentYIndex);
						pathwaysView.update();
						pathwaysViewUI.repaint();
					}
			}
			
		public void moveToDifferentContainer(LayoutObjectsContainer cursorContainer, int x, int y)
			{
				if (currentLO != null)
					{
						PathwayElement pe = ((PathwayElementGO) currentLO.getGo()).getO();
						if (pe instanceof DocumentedKnowledge_Located)
							{
								pathwayDataView.updateElementLocation(pe, cursorContainer);
								pathwayDataView.rebuildView();
							}
					}
					
			}
			
		public void mouseDragged(MouseEvent e)
			{
				if (currentGO == null)
					{// Drag whole pathway space
						int x = e.getX();
						int y = e.getY();
						viewLayout.setShowActiveRegion(false);
						pathwaysViewUI.scroll(x - lastX, y - lastY);
					}
				else
					{// Drag object
						viewLayout.isOver(e);
						pathwaysView.synchronizeActiveRegions(true);
						if (this.currentContainer != null)
							pathwaysViewUI.repaint(this.currentContainer.getX() - 2, this.currentContainer.getY() - 2, this.currentContainer.getActualWidth() + 4, this.currentContainer.getActualHeight() + 4);
						if (currentGO.isSelected())
							{// Drag all selected objects
								/*
								 * Relative shift with respect with previously handled objects position
								 */
								// pathwaysView.processSelected(ProcessableGO.VERTICAL_SHIFT,
								// currentObjectY - y + lastY - objectY);
								pathwaysViewUI.getViewUI().repaint();
							}
						else
							{// Drag current object only
								// currentLO.setY(y - lastY + objectY);
								pathwaysViewUI.getViewUI().repaint();
							}
					}
				determineState();
			}
			
		protected void determineState()
			{
				
				int state = mouseIsDragged ? 1 : 0;
				if (currentGO != null)
					state += 2;
				setState(state + 1);
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
			
		@Override
		public String getContext()
			{
				if (currentGO != null)
					return "-object";
				else
					return "-canvas";
			}
			
		protected int			objectXIndex;
		protected int			objectYIndex;
	}

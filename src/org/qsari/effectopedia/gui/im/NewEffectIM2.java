package org.qsari.effectopedia.gui.im;

import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.go.Layout.LayoutObject;
import org.qsari.effectopedia.go.Layout.LayoutObjectsContainer.ActiveIndex;
import org.qsari.effectopedia.go.pathway_elements.PathwayElementGO;
import org.qsari.effectopedia.gui.PathwaysViewUI;
import org.qsari.effectopedia.gui.UIResources;

public class NewEffectIM2 extends IndexedGOIM
	{
		public NewEffectIM2(PathwaysViewUI pathwayUI, InterfaceModes owner)
			{
				super(pathwayUI, owner);
				setCursors(make3StateCursors(Cursor.getDefaultCursor(), UIResources.effectCursor, UIResources.incompatibleCursor));
				viewLayout.setSimpleActiveRegion(true);
				viewLayout.setShowActiveRegion(false);
				this.alternativeModeType = DRAG;
			}
			
		private void addNewEffect(int x, int y)
			{
				PathwayElement element = (currentGO != null) && (currentGO.isTemporary()) ? null : getCurrentActivePathwayElement();
				if ((element != null) && (!element.isGeneric()))
					return;
				Effect effect = (Effect) currentElement.nextElement(element).clone(null, currentElement.getDataSource());
				if (element != null)
					{
						effect.forceToLive();
						Pathway.substitute(element, effect);
					}
				ActiveIndex activeIndex = currentContainer.getActiveIndex(x, y);
				if (activeIndex.isCenterAction())
					owner.interfaceModeUpdated(this);
				setCurrentLO(pathwayDataView.setInView(activeIndex, currentContainer, effect));
				associateWithExistingPathways(effect);
				pathwaysView.update();
				viewLayout.isOver(x, y);
				selection.unselect(viewLayout);
				selection.select(currentLO);
			}

		@Override
		public void keyPressed(KeyEvent e)
			{
				super.keyPressed(e);
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_ESCAPE)
					{
						reset();
						pathwaysView.update();
						pathwaysViewUI.repaint();
						pathwaysViewUI.getViewUI().getPathwaySpaceToolbarUI().setDefaultMode();
					}
			}
			
		public void mouseSingleClicked(MouseEvent e)
			{
				int x = e.getX();
				int y = e.getY();
				setCurrentLO(viewLayout.isOver(x, y));
				setLastLO(viewLayout.getLastLO());
				currentContainer = viewLayout.getCurrentContainer();
				removeTempPE();
				if (state == COMATIBLE)
					{
						addNewEffect(x, y);
						updateElementEditor(getCurrentActivePathwayElement());
					}
				pathwaysViewUI.repaint();
				determineState();
			}
			
		@Override
		public void mouseMoved(MouseEvent e)
			{
				currentX = e.getX();
				currentY = e.getY();
				updateKeyModifiers(e);
				setCurrentLO(viewLayout.isOver(currentX, currentY));
				setLastLO(viewLayout.getLastLO());
				pathwaysView.synchronizeActiveRegions(true);
				currentContainer = viewLayout.getCurrentContainer();
				determineState();
				if (this.lastGO != null)
					this.lastGO.setActive(this.lastGO == this.currentGO);
				updateTempPE(currentX, currentY);
				determineState();
				pathwaysViewUI.getViewUI().repaint();
				if (!pathwaysViewUI.hasFocus())
					pathwaysViewUI.requestFocusInWindow();
			}
			
		protected void updateTempPE(int x, int y)
			{
				LayoutObject lo = viewLayout.getLayoutObjectUnderCursor(x, y);
				if ((lastActiveLO != null) && (lastActiveLO == lo))
					return;
				lastActiveLO = lo;
				PathwayElementGO go = (lo != null) ? (PathwayElementGO) lo.getGo() : null;
				if ((go != null) && ((go.getO() == tempPE)))
					return;
				removeTempPE();
				tempPE = currentElement.getCurrent();
				pathwaysView.update();
				addTempPE(x, y);
				pathwaysView.update();
			}
			
		private void removeTempPE()
			{
				if (tempPE != null)
					{
						pathwayDataView.removeFromView(tempPE);
						tempPE = null;
					}
			}
			
		protected void addTempPE(int x, int y)
			{
				if (tempPE != null)
					{
						if (currentContainer.isCompatible(tempPE.getClass()))
							{
								lastActiveLO = pathwayDataView.addTemporaryToView(currentContainer.getSimpleActiveIndex(x, y), currentContainer, tempPE);
								if (lastActiveLO == null)
									{
										pathwaysView.update();
										tempPE = null;
									}
							}
					}
			}
			
		protected void reset()
			{
				removeTempPE();
				tempPE = null;
				viewLayout.setSimpleActiveRegion(true);
				viewLayout.setShowActiveRegion(false);
				currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_EFFECT_CYCLE, PathwayElementTypeCycler.FIXED_CYCLE);
				pathwaysView.getViewLayout().setArcsSelectable(false);
			}
			
		private LayoutObject			lastActiveLO	= null;
		private PathwayElement	tempPE							= null;
		
	}

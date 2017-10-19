package org.qsari.effectopedia.gui.im;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.go.Layout.LayoutObjectsContainer.ActiveIndex;
import org.qsari.effectopedia.gui.PathwaysViewUI;
import org.qsari.effectopedia.gui.UIResources;

public class NewEffectIM extends IndexedGOIM
	{
		public NewEffectIM(PathwaysViewUI pathwayUI, InterfaceModes owner)
			{
				super(pathwayUI, owner);
				setCursors(make3StateCursors(Cursor.getDefaultCursor(), UIResources.effectCursor, UIResources.incompatibleCursor));
				viewLayout.setSimpleActiveRegion(false);
				viewLayout.setShowActiveRegion(true);
				this.alternativeModeType = DRAG;
			}
			
		private void addNewEffect(int x, int y)
			{
				PathwayElement element = getCurrentActivePathwayElement();
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
			
		public void mouseSingleClicked(MouseEvent e)
			{
				int x = e.getX();
				int y = e.getY();
				setCurrentLO(viewLayout.isOver(x, y));
				setLastLO(viewLayout.getLastLO());
				currentContainer = viewLayout.getCurrentContainer();
				if (state == COMATIBLE)
					addNewEffect(x, y);
				pathwaysViewUI.repaint();
				determineState();
			}
			
		protected void reset()
			{
				viewLayout.setSimpleActiveRegion(false);
				viewLayout.setShowActiveRegion(true);
				currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_EFFECT_CYCLE, PathwayElementTypeCycler.FIXED_CYCLE);
				pathwaysView.getViewLayout().setArcsSelectable(false);
			}
			
	}

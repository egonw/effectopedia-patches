package org.qsari.effectopedia.gui.im;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import org.qsari.effectopedia.core.objects.Initiator;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.go.Layout.LayoutObjectsContainer.ActiveIndex;
import org.qsari.effectopedia.gui.PathwaysViewUI;
import org.qsari.effectopedia.gui.UIResources;

public class NewSubstanceIM extends IndexedGOIM
	{
		public NewSubstanceIM(PathwaysViewUI pathwayUI, InterfaceModes owner)
			{
				super(pathwayUI, owner);
				setCursors(make3StateCursors(Cursor.getDefaultCursor(), UIResources.chemicalCursor, UIResources.incompatibleCursor));
				viewLayout.setSimpleActiveRegion(false);
				viewLayout.setShowActiveRegion(true);
				this.alternativeModeType = DRAG;
			}
		
		private void addNewChemical(int x, int y)
			{
				PathwayElement element = getCurrentActivePathwayElement();
				if ((element != null) && (!element.isGeneric()))
					return;
				Initiator substance = (Initiator) currentElement.nextElement(element).clone(null, currentElement.getDataSource());
				if (element != null)
					{
						substance.forceToLive();
						Pathway.substitute(element, substance);
					}
				ActiveIndex activeIndex = currentContainer.getActiveIndex(x, y);
				if (activeIndex.isCenterAction())
					owner.interfaceModeUpdated(this);
				associateWithExistingPathways(substance);
				setCurrentLO(pathwayDataView.setInView(activeIndex, currentContainer, substance));
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
					addNewChemical(x, y);
				pathwaysViewUI.repaint();
				determineState();
			}
		
		protected void reset()
			{
				viewLayout.setSimpleActiveRegion(false);
				viewLayout.setShowActiveRegion(true);
				currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_SUBSTANCE_CYCLE, PathwayElementTypeCycler.FIXED_CYCLE);
				pathwaysView.getViewLayout().setArcsSelectable(false);
			}
		
	}

package org.qsari.effectopedia.gui.im;

import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.go.Layout.LayoutObject;
import org.qsari.effectopedia.go.Layout.LayoutObjectsContainer.ActiveIndex;
import org.qsari.effectopedia.go.pathway_elements.PathwayElementGO;
import org.qsari.effectopedia.gui.PathwaysViewUI;
import org.qsari.effectopedia.gui.UIResources;

public class WizardIM extends InterfaceMode
	{
		public WizardIM(PathwaysViewUI pathwayUI, InterfaceModes owner)
			{
				super(pathwayUI, owner);
				this.alternativeModeType = DRAG;
				setCursors(make3StateCursors(Cursor.getDefaultCursor(), UIResources.effectCursor, UIResources.incompatibleCursor));
				currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_EFFECT_CYCLE, PathwayElementTypeCycler.STANDARD_SEQUENCE);
				currentElement.setElementIndex(1);
				viewLayout.setSimpleActiveRegion(false);
				viewLayout.setShowActiveRegion(true);
			}
		
		protected void setElement(boolean existing)
			{
				selection.select(currentLO);
				if (lastElement == currentLO)
					return;
				if (element1 == null)
					{
						element1 = currentLO;
						existingElement1 = existing;
					}
				else
					{
						element2 = currentLO;
						existingElement2 = existing;
					}
				lastElement = currentLO;
			}
		
		private void addNewElement(int x, int y)
			{
				PathwayElement element = getCurrentActivePathwayElement();
				if ((element != null) && (!element.isGeneric()))
					{
						setElement(true);
						return;
					}
				element = currentElement.nextElement(element).clone(null,currentElement.getDataSource());
				ActiveIndex activeIndex = currentContainer.getActiveIndex(x, y);
				if (currentGO == null)
					{
						setCurrentLO(pathwayDataView.setInView(activeIndex, currentContainer, element));
						owner.interfaceModeUpdated(this);
						setElement(false);
					}
				else if (currentLO == lastElement)
					{
						setCurrentLO(pathwayDataView.setInView(activeIndex, currentContainer, element));
						owner.interfaceModeUpdated(this);
						lastElement = currentLO;
					}
				else if ((currentGO != null) && (currentGO.isSelected()))
					{
						if (element1 == currentLO)
							element1 = null;
						if (element2 == currentLO)
							element2 = null;
						setCurrentLO(pathwayDataView.setInView(activeIndex, currentContainer, element));
						owner.interfaceModeUpdated(this);
						setElement(false);
					}
				pathwaysView.update();
				viewLayout.isOver(x, y);
				selection.select(currentLO);
			}
		
		private void wizardAction()
			{
				PathwayElement pe1 = ((PathwayElementGO) element1.getGo()).getO();
				PathwayElement pe2 = ((PathwayElementGO) element2.getGo()).getO();
				Pathway pathway;
				if (pe1.getParent() != null)
					pathway = (Pathway) pe1.getParent();
				else if (pe2.getParent() != null)
					pathway = (Pathway) pe1.getParent();
				else
					{
						pathway = DefaultEffectopediaObjects.DEFAULT_PATHWAY.clone();
						pathway.forceToLive();
					}
				pathway.associate(pe1);
				if (element1.getParent().getxIndex() > element2.getParent().getxIndex())
					pathwayDataView.buildPath(selection, element2, element1, pathway, false);
				else
					pathwayDataView.buildPath(selection, element1, element2, pathway, true);
				pathway.associate(pe2);
				pathwaysView.update();
				reset();
			}
		
		public void mouseClicked(MouseEvent e)
			{
				int x = e.getX();
				int y = e.getY();
				setCurrentLO(viewLayout.isOver(x, y));
				setLastLO(viewLayout.getLastLO());
				currentContainer = viewLayout.getCurrentContainer();
				if (currentContainer != null)
					{
						if ((currentGO != null) && !(currentGO.isSelected()))
							setElement(true);
						else
							addNewElement(x, y);
						if ((element1 != null) && (element2 != null))
							wizardAction();
						pathwaysViewUI.repaint();
					}
				determineState();
			}
		
		protected void determineState()
			{
				int state = -1;
				if (currentContainer != null)
					state = ((currentContainer.isCompatible(currentElement.getCurrent().getClass())) ? 0 : 1);
				setState(state + 1);
			}
		
		protected void remove(LayoutObject lo)
			{
				if (lo != null)
					{
						int x = lo.getGo().getX() + lo.getGo().getWidth() / 2;
						int y = lo.getGo().getY() + lo.getGo().getHeight() / 2;
						pathwayDataView.removeFromView(lo.getParent().getActiveIndex(x, y), lo.getParent(), ((PathwayElementGO) (lo.getGo())).getO());
						pathwaysView.update();
					}
			}
		
		public void keyPressed(KeyEvent e)
			{
				super.keyPressed(e);
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
					{
						if (!existingElement1)
							remove(element1);
						if (!existingElement2)
							remove(element2);
						reset();
					}
			}
		
		protected void reset()
			{
				currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_EFFECT_CYCLE, PathwayElementTypeCycler.FIXED_CYCLE);
				currentElement.setElementIndex(1);
				element1 = null;
				element2 = null;
				pathwaysView.getViewLayout().setArcsSelectable(false);
				viewLayout.setSimpleActiveRegion(false);
				viewLayout.setShowActiveRegion(true);
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

		@Override
		public String getContext()
			{
				if (element1 == null)
					if (element2 == null)
						return "-start";
					else
						return "-add_upstream";
				else
					return "-add_downstream";
			}

		protected LayoutObject	element1;
		protected boolean						existingElement1;
		protected LayoutObject	element2;
		protected boolean						existingElement2;
		protected LayoutObject	lastElement	= null;
	}

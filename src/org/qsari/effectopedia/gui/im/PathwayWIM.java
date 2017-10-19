package org.qsari.effectopedia.gui.im;

import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Initiator;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.go.Layout.LayoutObject;
import org.qsari.effectopedia.go.Layout.LayoutObjectsContainer.ActiveIndex;
import org.qsari.effectopedia.go.pathway_elements.PathwayElementGO;
import org.qsari.effectopedia.gui.PathwaysViewUI;
import org.qsari.effectopedia.gui.UIResources;

public class PathwayWIM extends InterfaceMode
	{
		public PathwayWIM(PathwaysViewUI pathwayUI, InterfaceModes owner)
			{
				super(pathwayUI, owner);
				this.alternativeModeType = DRAG;
				setCursors(make5StateCursors(Cursor.getDefaultCursor(), UIResources.chemicalCursor, UIResources.incompatibleCursor, UIResources.effectCursor, UIResources.incompatibleCursor));
			}
		
		private void addNewChemical(int x, int y)
			{
				PathwayElement element = getCurrentActivePathwayElement();
				if ((element != null) && (!element.isGeneric()))
					{
						root = currentLO;
						existingRoot = true;
						above = outcome == null;
						return;
					}
				Initiator chemical = (Initiator) currentElement.nextElement(element).clone(null, currentElement.getDataSource());
				ActiveIndex activeIndex = currentContainer.getActiveIndex(x, y);
				if ((currentGO == null) || ((currentGO != null) && (currentGO.isSelected())))
					{
						setCurrentLO(pathwayDataView.setInView(activeIndex, currentContainer, chemical));
						root = currentLO;
						above = outcome == null;
						owner.interfaceModeUpdated(this);
						existingRoot = currentGO == null;
					}
				pathwaysView.update();
				viewLayout.isOver(x, y);
				selection.select(currentLO);
				existingRoot = false;
			}
		
		private void addNewEffect(int x, int y)
			{
				PathwayElement element = getCurrentActivePathwayElement();
				if ((element != null) && (!element.isGeneric()))
					{
						outcome = currentLO;
						above = root != null;
						existingOutcome = true;
						return;
					}
				if (!(element instanceof Effect))
					element = null;
				Effect effect = (Effect) currentElement.nextElement(element).clone(null, currentElement.getDataSource());
				ActiveIndex activeIndex = currentContainer.getActiveIndex(x, y);
				if ((currentGO == null) || ((currentGO != null) && (currentGO.isSelected())))
					{
						outcome = pathwayDataView.setInView(activeIndex, currentContainer, effect);
						setCurrentLO(outcome);
						above = root != null;
						owner.interfaceModeUpdated(this);
						existingOutcome = currentGO == null;
					}
				pathwaysView.update();
				viewLayout.isOver(x, y);
				selection.select(currentLO);
			}
		
		private void wizardAction()
			{
				Pathway theNewPathway = keyCtrlPressed?DefaultEffectopediaObjects.DEFAULT_PATHWAY.clone(null, currentElement.getDataSource()):pathwayDataView.getLastAddedPathway();
				theNewPathway.forceToLive();
				theNewPathway.associate(((PathwayElementGO) root.getGo()).getO());
				pathwayDataView.buildPath(selection, root, outcome, theNewPathway, above);
				theNewPathway.associate(((PathwayElementGO) outcome.getGo()).getO());
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
						if (isSubstanceMode())
							addNewChemical(x, y);
						else
							addNewEffect(x, y);
						if ((root != null) && (outcome != null))
							wizardAction();
						pathwaysViewUI.repaint();
					}
				determineState();
			}
		
		private boolean isSubstanceMode()
			{
				boolean substanceMode = (currentContainer.getxIndex() == 0) && (root == null);
				if (currentO != null)
					return (currentO instanceof Initiator);
				return substanceMode;
			}
		
		protected void determineState()
			{
				int state = -1;
				if (currentContainer != null)
					if (isSubstanceMode())
						{
							currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_SUBSTANCE_CYCLE, PathwayElementTypeCycler.FIXED_CYCLE);
							state = 0;
						}
					else
						{
							currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_EFFECT_CYCLE, PathwayElementTypeCycler.FIXED_CYCLE);
							currentElement.lastElement();
							state = 2 + ((currentContainer.isCompatible(currentElement.getCurrent().getClass())) ? 0 : 1);
						}
				setState(state + 1);
			}
		
		private void remove(LayoutObject lo)
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
						if (!existingRoot)
							remove(root);
						if (!existingOutcome)
							remove(outcome);
						reset();
					}
			}
		
		protected void reset()
			{
				viewLayout.setSimpleActiveRegion(false);
				viewLayout.setShowActiveRegion(true);
				currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_SUBSTANCE_CYCLE, PathwayElementTypeCycler.FIXED_CYCLE);
				root = null;
				outcome = null;
				pathwaysView.getViewLayout().setArcsSelectable(false);
			}
		
		public void setCurrentLO(LayoutObject currentLO)
			{
				this.currentO = null;
				this.currentLO = currentLO;
				if (currentLO == null)
					this.currentGO = null;
				else if (viewLayout.getActiveRegion().isOverGO())
					{
						this.currentGO = currentLO.getGo();
						this.currentO = ((PathwayElementGO) currentGO).getO();
					}
				else
					this.currentGO = null;
			}
		
		@Override
		public String getContext()
			{
				if (root == null)
					if (outcome == null)
						return "-start";
					else
						return "-add_root";
				else
					return "-add_outcome";
			}
		
		private LayoutObject			root;
		private boolean								existingRoot;
		private LayoutObject			outcome;
		private boolean								existingOutcome;
		private PathwayElement	currentO	= null;
		private boolean								above;
	}

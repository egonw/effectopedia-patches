package org.qsari.effectopedia.gui.im;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.objects.Test;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.go.Layout.LayoutObject;
import org.qsari.effectopedia.go.Layout.LayoutObjectsContainer.ActiveIndex;
import org.qsari.effectopedia.gui.PathwaysViewUI;
import org.qsari.effectopedia.gui.UIResources;

public class NewTestIM extends IndexedGOIM
	{
		public NewTestIM(PathwaysViewUI pathwayUI, InterfaceModes owner)
			{
				super(pathwayUI, owner);
				setCursors(make4StateCursors(Cursor.getDefaultCursor(), UIResources.testCursor, UIResources.mappingCursor, UIResources.incompatibleCursor));
				viewLayout.setSimpleActiveRegion(false);
				viewLayout.setShowActiveRegion(true);
				this.alternativeModeType = DRAG;
				currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_TEST_CYCLE, PathwayElementTypeCycler.FIXED_CYCLE);
			}
		
		private void addNewElement(int x, int y)
			{
				PathwayElement element = getCurrentActivePathwayElement();
				if (element == null)
					{
						if (lastElement == null)
							element = addNewTest(x, y);
						else if ((lastElement instanceof Effect) || (lastElement instanceof TestResponseMapping))
							element = addNewTest(x, y);
						else
							element = addNewTestResponseMapping(x, y);
					}
				else if (element.isGeneric() && (element instanceof Test))
					element = addNewTest(x, y);
				pathwaysView.update();
				viewLayout.isOver(x, y);
				selection.unselect(viewLayout);
				selection.select(currentLO);
				if ((element instanceof Effect) && (lastElement instanceof TestResponseMapping))
					TryToLink(element, currentLO, lastElement, lastElementLO, false);
				if (element != null)
					if (element instanceof Test)
						{
							if (!element.hasIncommingMappings())
								{
									lastElement = element;
									lastElementLO = currentLO;
								}
						}
					else
						{
							lastElement = element;
							lastElementLO = currentLO;
						}
			}
		
		private PathwayElement addNewTest(int x, int y)
			{
				PathwayElement element = getCurrentActivePathwayElement();
				if ((element != null) && (!element.isGeneric()))
					return element;
				Test test;
				if ((lastElement != null) && (lastElement instanceof TestResponseMapping) && (element instanceof Test) && (!element.hasIncommingAssociations()))
					{
						test = (Test) element;
						TryToLink(lastElement, lastElementLO, test, currentLO, false);
						return test;
					}
				else
					test = (Test) currentElement.nextElement(element).clone();
				test.forceToLive();
				if (element != null)
					Pathway.substitute(element, test);
				ActiveIndex activeIndex = currentContainer.getActiveIndex(x, y);
				if (activeIndex.isCenterAction())
					owner.interfaceModeUpdated(this);
				setCurrentLO(pathwayDataView.setInView(activeIndex, currentContainer, test));
				pathwaysView.update();
				viewLayout.isOver(x, y);
				selection.unselect(viewLayout);
				selection.select(currentLO);
				if (lastElement instanceof Effect)
					TryToLink(lastElement, lastElementLO, test, currentLO, true);
				if ((lastElement instanceof TestResponseMapping) || (lastElement instanceof Effect) || (test.hasIncommingMappings()))
					{
						lastElement = null;
						lastElementLO = null;
						determineState();
					}
				else
					{
						lastElement = test;
						lastElementLO = currentLO;
					}
				return test;
			}
		
		private void TryToLink(PathwayElement element1, LayoutObject element1LO, PathwayElement element2, LayoutObject element2LO, boolean attemtReverse)
			{
				if ((element1 == null) || (element2 == null))
					return;
				if (PathwayElement.areMapped(element1, element2))
					return;
				if (element1 instanceof Effect)
					{
						if (element2 instanceof TestResponseMapping)
							{
								element1.forceToLive();
								((TestResponseMapping) element2).getEffect().set((Effect) element1);
								if (((Effect) element1).getRelatedTestMappingIDs().addIfDifferent((TestResponseMapping) element2))
									pathwayDataView.createArc(element1, element2);
							}
						else if (element2 instanceof Test)
							{
								pathwaysView.update();
								TestResponseMapping trm = null;
								if (element2LO.getParent() == element1LO.getParent())
									{
										int diff = Math.abs(element2LO.getyIndex() - element1LO.getyIndex());
										if (diff == 1)
											trm = addNewTestResponseMapping(element2LO.getMidX(), ((element2LO.getY() > element1LO.getY()) ? (element2LO.getY() + 1) : element1LO.getY() + 1));
										else if (element2LO.getAdjacentObject(0, -1) == null)
											trm = addNewTestResponseMapping(element2LO.getMidX(), ((element2LO.getY() > element1LO.getY()) ? (element2LO.getY() - 1) : element1LO.getY() - 1));
									}
								// else
								// trm = addNewTestResponseMapping(element1LO.getMidX(),
								// ((element2LO.getParent().getY() > element1LO.getParent().getY()) ?
								// (element1LO.getBottom() - 1) : element1LO.getY() + 1));
								if (trm != null)
									{
										element2.forceToLive();
										trm.getTest().set((Test) element2);
										trm.getEffect().set((Effect) element1);
										if (((Test) element2).getRelatedEffectMappingIDs().addIfDifferent(trm))
											pathwayDataView.createArc(trm, element2);
										if (((Effect) element1).getRelatedTestMappingIDs().addIfDifferent(trm))
											pathwayDataView.createArc(element1, trm);
										AssociateWithExistingPathways(((Effect) element1), trm, ((Test) element2));
									}
							}
					}
				else if (attemtReverse)
					TryToLink(element2, element2LO, element1, element1LO, false);
				else if ((element1 instanceof Test) && (element2 instanceof TestResponseMapping) || ((element2 instanceof Test) && (element1 instanceof TestResponseMapping)))
					{
						element1.map(element2);
						element2.map(element1);
						pathwayDataView.createArc(element1, element2);
					}
			}
		
		private void AssociateWithExistingPathways(Effect effect, TestResponseMapping trm, Test test)
			{
				Pathway[] pathways = effect.getAssocuatedPathways();
				if ((pathways == null) || (pathways.length == 0))
					return;
				for (Pathway pathway : pathways)
					{
						trm.getPathwayIDs().addIfDifferent(pathway);
						trm.setParent(pathway);
						pathway.add(trm);
						test.getPathwayIDs().addIfDifferent(pathway);
						test.setParent(pathway);
						pathway.add(test);
					}
			}
		
		private TestResponseMapping addNewTestResponseMapping(int x, int y)
			{
				PathwayElement element = getCurrentActivePathwayElement();
				if (((element != null) && (!element.isGeneric())) || (element instanceof TestResponseMapping))
					return null;
				TestResponseMapping trm = (TestResponseMapping) DefaultEffectopediaObjects.DEFAULT_TEST_RESPONCE_MAPPNIG.clone(null, currentElement.getDataSource());
				ActiveIndex activeIndex = currentContainer.getActiveIndex(x, y);
				if (activeIndex.isCenterAction())
					owner.interfaceModeUpdated(this);
				setCurrentLO(pathwayDataView.setInView(activeIndex, currentContainer, trm));
				pathwaysView.update();
				viewLayout.isOver(x, y);
				selection.unselect(viewLayout);
				selection.select(currentLO);
				TryToLink(lastElement, lastElementLO, trm, currentLO, true);
				lastElement = trm;
				lastElementLO = currentLO;
				return trm;
			}
		
		@Override
		public void mouseSingleClicked(MouseEvent e)
			{
				int x = e.getX();
				int y = e.getY();
				setCurrentLO(viewLayout.isOver(x, y));
				setLastLO(viewLayout.getLastLO());
				currentContainer = viewLayout.getCurrentContainer();
				if (state != 3)
					addNewElement(x, y);
				pathwaysViewUI.repaint();
				determineState();
			}
		
		protected void determineState()
			{
				if (currentContainer != null)
					if (!currentContainer.isCompatible(currentElement.getCurrent().getClass()))
						setState(3);
					else if ((lastElement != null) && (lastElement instanceof Test) && (!lastElement.hasIncommingMappings()))
						setState(2);
					else
						setState(1);
			}
		
		@Override
		public String getContext()
			{
				if (currentContainer != null)
					if (!currentContainer.isCompatible(currentElement.getCurrent().getClass()))
      return "-incompatible_segment";
				PathwayElement pe = getCurrentActivePathwayElement();
				if (pe != null)
					if (pe instanceof Test)
						return "-modify_existing";
					else if ((pe instanceof TestResponseMapping) && (lastElement == null))
						return "-edit_trm";
				if (lastElement == null)
					return "-start";
				else if ((lastElement instanceof Effect) || (lastElement instanceof TestResponseMapping))
					return "-place_test";
				else
					return "-place_trm";
			}
		
		public void reset()
			{
				currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_TEST_CYCLE, PathwayElementTypeCycler.FIXED_CYCLE);
				viewLayout.setSimpleActiveRegion(false);
				viewLayout.setShowActiveRegion(true);
				pathwaysView.getViewLayout().setArcsSelectable(true);
			}
		
		private PathwayElement	lastElement			= null;
		private LayoutObject			lastElementLO	= null;
	}

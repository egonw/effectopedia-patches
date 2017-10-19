package org.qsari.effectopedia.gui.im;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Effect_AdverseOutcome;
import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;
import org.qsari.effectopedia.core.objects.Initiator;
import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.objects.Test;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.go.ArcGO;
import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.Layout.LayoutObject;
import org.qsari.effectopedia.go.Layout.LayoutObjectsContainer;
import org.qsari.effectopedia.go.Layout.LayoutObjectsContainer.ActiveIndex;
import org.qsari.effectopedia.go.pathway_elements.PathwayElementGO;
import org.qsari.effectopedia.gui.PathwaysViewUI;
import org.qsari.effectopedia.gui.UIResources;

public class NewIndexedGOIM2 extends IndexedGOIM
	{
		public static final int	ADD_CHEMICAL	= 1;
		public static final int	ADD_EFFECT			= 2;
		public static final int	ADD_TEST					= 4;
		
		public NewIndexedGOIM2(PathwaysViewUI pathwayUI, InterfaceModes owner)
			{
				super(pathwayUI, owner);
				setCursors(make4StateCursors(Cursor.getDefaultCursor(), UIResources.chemicalCursor, UIResources.effectCursor, UIResources.testCursor));
				viewLayout.setSimpleActiveRegion(true);
				viewLayout.setShowActiveRegion(false);
				this.alternativeModeType = DRAG;
				testCycler = new PathwayElementTypeCycler(PathwayElementTypeCycler.SEQUENCE_TEST_CYCLE, true);
				testCycler.updateDataSource(currentElement.getDataSource());
			}
			
		private boolean tryToLink(LayoutObject upstreamLO, LayoutObject downstreamLO, boolean temporary)
			{
				if ((upstreamLO != null) && (downstreamLO != null) && (downstreamLO != upstreamLO))
					{
						PathwayElement upstreamElement = ((PathwayElementGO) upstreamLO.getGo()).getO();
						if (upstreamElement instanceof Link)
							return false;
						PathwayElement downstreamElement = ((PathwayElementGO) downstreamLO.getGo()).getO();
						if (downstreamElement instanceof Link)
							return false;
						if (isFeedbackLinnk(upstreamLO, downstreamLO))
							return false;
						int linkedUpstream = PathwayElement.countElementsBetween(upstreamElement, downstreamElement);
						if (linkedUpstream >= 1)
							if (temporary)
								return false;
							else if (linkedUpstream == 1)
								{
									lastElementLO = downstreamLO;
									lastElement = downstreamElement;
									return true;
								}
							else
								{
									boolean confirmation = UserInterface.getUserConfirmationWithOptions("Do you like to link the two elements?");
									askForConfirmation = UserInterface.isAskingConfirmation();
									if (!confirmation)
										{
											lastElementLO = downstreamLO;
											lastElement = downstreamElement;
											return true;
										}
								}
							
						ActiveIndex activeIndex = poposePlacement(upstreamLO, downstreamLO);
						if (activeIndex == null)
							return false;
						Link newLink;
						if (temporary)
							{
								newLink = Link.getDefaultLink(upstreamElement, downstreamElement);
								pathwayDataView.addTemporaryToView(activeIndex, activeIndex.getContainer(), newLink);
								tempLinkPE = newLink;
							}
						else
							{
								tempLinkPE = null;
								newLink = Link.newLink(null, currentElement.getDataSource(), upstreamElement, downstreamElement);
								pathwayDataView.addToView(activeIndex, activeIndex.getContainer(), newLink);
								newLink.forceToLive();
								lastElement = downstreamElement;
								lastElementLO = downstreamLO;
							}
						linkElements(upstreamElement, newLink, temporary);
						linkElements(newLink, downstreamElement, temporary);
					}
				return true;
			}
			
		protected boolean isFeedbackLinnk(LayoutObject upstreamLO, LayoutObject downstreamLO)
			{
				LayoutObjectsContainer upstreamContainer = upstreamLO.getParent();
				LayoutObjectsContainer downstreamContainer = downstreamLO.getParent();
				if (upstreamContainer == downstreamContainer)
					{
						if (upstreamLO.getX() > downstreamLO.getX())
							return true;
					}
				else if (upstreamContainer.getxIndex() > downstreamContainer.getxIndex())
					return true;
				return false;
			}
			
		private ActiveIndex poposePlacement(LayoutObject upstreamLO, LayoutObject downstreamLO)
			{
				LayoutObjectsContainer upstreamContainer = upstreamLO.getParent();
				LayoutObjectsContainer downstreamContainer = downstreamLO.getParent();
				if (upstreamContainer == downstreamContainer)
					{
						GraphicObject upstreamGO = upstreamLO.getGo();
						int x = upstreamLO.getX() + upstreamLO.getAvailableWidth() - downstreamLO.getX() - downstreamLO.getAvailableWidth();
						if (x > 0)
							return null;
						x = (x < 0) ? upstreamGO.getRight() + 1 : upstreamGO.getMidX();
						int y = upstreamLO.getY() + upstreamLO.getAvailableHeight() - downstreamLO.getY() - downstreamLO.getAvailableHeight();
						y = (y < 0) ? upstreamGO.getBottom() + 1 : (y == 0) ? upstreamGO.getMidY() : upstreamGO.getY() - 1;
						return upstreamContainer.getSimpleActiveIndex(x, y);
					}
				else
					{
						int xDif = (int) Math.signum(downstreamContainer.getxIndex() - upstreamContainer.getxIndex());
						int yDif = (int) Math.signum(downstreamContainer.getyIndex() - upstreamContainer.getyIndex());
						LayoutObjectsContainer container = (LayoutObjectsContainer) upstreamContainer.getAdjacentObject(xDif, yDif);
						return container.getActiveIndex(container.getMidX(), container.getMidY());
					}
			}
			
		private void unlink(Link link, boolean temporary)
			{
				if (link != null)
					{
						PathwayElement upstreamPE = link.incommingAssociations()[0];
						PathwayElement downstreamPE = link.outgoingAssociations()[0];
						if (!temporary)
							{
								Pathway.unlink(upstreamPE, link);
								Pathway.unlink(link, downstreamPE);
								((Pathway) link.getParent()).disassociate(link);
							}
						pathwayDataView.removeArc(upstreamPE, link);
						pathwayDataView.removeArc(link, downstreamPE);
					}
			}
			
		private void unmap(TestResponseMapping trm, boolean temporary)
			{
				if (trm != null)
					{
						PathwayElement effectPE = trm.incommingMappings()[0];
						PathwayElement testPE = trm.outgoingMappings()[0];
						if (!temporary)
							{
								Pathway.unmap(effectPE, trm, testPE);
								((Pathway) trm.getParent()).disassociate(trm);
							}
						pathwayDataView.removeArc(effectPE, trm);
						pathwayDataView.removeArc(trm, testPE);
					}
			}
			
		private void linkElements(PathwayElement upstreamElement, PathwayElement downstreamElement, boolean temporary)
			{
				ArcGO tempArc = (ArcGO) pathwayDataView.createArc(upstreamElement, downstreamElement);
				if (tempArc != null)
					tempArc.setTemporary(temporary);
				if (!temporary)
					associateWithExistingPathway(upstreamElement, downstreamElement);
			}
			
		private void associateWithExistingPathway(PathwayElement upstreamElement, PathwayElement downstreamElement)
			{
				Pathway[] pathways = upstreamElement.getAssocuatedPathways();
				if ((pathways == null) || (pathways.length == 0))
					pathways = downstreamElement.getAssocuatedPathways();
				if ((pathways == null) || (pathways.length == 0))
					{
						pathways = new Pathway[1];
						pathways[0] = getCurrentPathway();
					}
				if (pathways != null)
					for (Pathway pathway : pathways)
						{
							upstreamElement.getPathwayIDs().addIfDifferent(pathway);
							upstreamElement.setParent(pathway);
							pathway.add(upstreamElement);
							downstreamElement.getPathwayIDs().addIfDifferent(pathway);
							downstreamElement.setParent(pathway);
							pathway.add(downstreamElement);
						}
			}
			
		private boolean isNewCycle(PathwayElement element, int x, int y)
			{
				return (element != null) && ((lastElementLO == null) || ((lastElementLO != null) && (lastElementLO.getGo().getRight() > x)));
			}
			
		private PathwayElement whatIsNextInCycle(int x, int y)
			{
				if ((lastElement == null) || ((lastElement != null) && (lastElementLO.getGo().getX() > x)))
					if (currentContainer.getxIndex() == 0)
						return DefaultEffectopediaObjects.DEFAULT_CHEM_STRUCTURE;
				PathwayElement element = currentElement.whatWillBe(2, 0);
				if ((element instanceof Effect_MolecularInitiatingEvent) && ((pathwayHasMIE() || (currentContainer.getxIndex() > 0))))
					element = currentElement.whatWillBe(2, 1);
				return element;
			}
			
		private PathwayElement nextInCycle(int x, int y)
			{
				if ((lastElement == null) || ((lastElement != null) && (lastElementLO.getGo().getX() > x)))
					if (currentContainer.getxIndex() == 0)
						{
							currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_SUBSTANCE_CYCLE, PathwayElementTypeCycler.STANDARD_SEQUENCE);
							return currentElement.getCurrent();
						}
				PathwayElement element = currentElement.nextAfterNextInSequence();
				if ((element instanceof Effect_MolecularInitiatingEvent) && ((pathwayHasMIE() || (currentContainer.getxIndex() > 0))))
					element = currentElement.nextElement();
				return element;
			}
			
		private void addPathwayElement(int x, int y)
			{
				PathwayElement element = nextInCycle(x, y);
				element = element.clone(null, currentElement.getDataSource());
				ActiveIndex activeIndex = (tempActiveIndex != null) ? tempActiveIndex : currentContainer.getActiveIndex(x, y);
				if (currentContainer.isCompatible(element.getClass()))
					{
						setCurrentLO(pathwayDataView.setInView(activeIndex, currentContainer, element));
						element.forceToLive();
						owner.interfaceModeUpdated(this);
						placed = true;
					}
				associateWithExistingPathways(element);
				pathwaysView.update();
				if ((lastElement instanceof Effect_MolecularInitiatingEvent) && (element instanceof Initiator))
					{
						tryToLink(currentLO, lastElementLO, PERMANENTLY);
						currentLO = lastElementLO;
					}
				else
					{
						tryToLink(lastElementLO, currentLO, PERMANENTLY);
						lastElementLO = currentLO;
						lastElement = element;
					}
				pathwaysView.update();
				viewLayout.isOver(x, y);
				selection.unselect(viewLayout);
				selection.select(currentLO);
			}
			
		private void changeActivePathwayElement(PathwayElement activeElement)
			{
				lastElementLO = currentLO;
				lastElement = activeElement;
				selection.unselect(viewLayout);
				selection.select(currentLO);
				placed = false;
			}
			
		private boolean isExisting(int x, int y)
			{
				if (currentLO == null || currentLO.isTemporary())
					return false;
				else
					return getCurrentActivePathwayElement() != null;
			}
			
		private void changePathwayElement(int x, int y)
			{/*
				if ((currentGO == null) || (!currentGO.isSelected()))
					return;
				PathwayElement element = currentElement.nextElement();
				element = element.clone(null, currentElement.getDataSource());
				ActiveIndex activeIndex = (tempActiveIndex != null) ? tempActiveIndex : currentContainer.getActiveIndex(x, y);
				setCurrentLO(pathwayDataView.setInView(activeIndex, currentContainer, element));
				element.forceToLive();
				if ((lastElement instanceof Effect) && (element instanceof Effect))
					Pathway.substitute((Effect) lastElement, (Effect) element);
				else if ((lastElement instanceof Initiator) && (element instanceof Initiator))
					Pathway.substitute((Initiator) lastElement, (Initiator) element);
				element.forceToLive();
				owner.interfaceModeUpdated(this);
				placed = false;
				lastElementLO = currentLO;
				lastElement = element;
				associateWithExistingPathways(element);
				pathwaysView.update();
				viewLayout.isOver(x, y);
				selection.unselect(viewLayout);
				selection.select(currentLO);*/
			}
			
		private void addNewTest(int x, int y)
			{
				if (currentContainer.isCompatible(Test.class))
					{
						Test test = (Test) testCycler.getCurrent().clone(null, testCycler.getDataSource());
						test.forceToLive();
						ActiveIndex activeIndex = currentContainer.getActiveIndex(x, y);
						if (activeIndex.isCenterAction())
							owner.interfaceModeUpdated(this);
						LayoutObject testLO = (pathwayDataView.setInView(activeIndex, currentContainer, test));
						pathwaysView.update();
						if (lastElement instanceof Effect)
							tryToMap((Effect) lastElement, lastElementLO, test, testLO, PERMANENTLY);
						pathwaysView.update();
						viewLayout.isOver(x, y);
						selection.unselect(viewLayout);
						selection.select(lastElementLO);
					}
			}
			
		private void tryToMap(LayoutObject element1LO, LayoutObject element2LO, boolean temporary)
			{
				if ((element1LO != null) && (element2LO != null))
					{
						PathwayElement element1PE = ((PathwayElementGO) element1LO.getGo()).getO();
						PathwayElement element2PE = ((PathwayElementGO) element2LO.getGo()).getO();
						if ((element1PE instanceof Effect) && (element2PE instanceof Test))
							tryToMap((Effect) element1PE, element1LO, (Test) element2PE, element2LO, temporary);
						else if ((element1PE instanceof Test) && (element2PE instanceof Effect))
							tryToMap((Effect) element2PE, element2LO, (Test) element1PE, element1LO, temporary);
					}
			}
			
		private void tryToMap(Effect effect, LayoutObject effectLO, Test test, LayoutObject testLO, boolean temporary)
			{
				if ((effect == null) || (test == null))
					return;
				if (PathwayElement.areMapped(effect, test))
					return;
				
				ActiveIndex activeIndex = proposeTRMPlacement(effectLO, testLO);
				if (activeIndex == null)
					return;
				TestResponseMapping trm = (TestResponseMapping) DefaultEffectopediaObjects.DEFAULT_TEST_RESPONCE_MAPPNIG.clone(null, currentElement.getDataSource());
				if (temporary)
					{
						tempTRMPE = trm;
						pathwayDataView.addTemporaryToView(activeIndex, activeIndex.getContainer(), trm);
					}
				else
					{
						tempTRMPE = null;
						pathwayDataView.setInView(activeIndex, activeIndex.getContainer(), trm);
						trm.forceToLive();
						AssociateWithExistingPathways(effect, trm, test);
					}
				mapElements(effect, trm, temporary);
				mapElements(trm, test, temporary);
			}
			
		public void mapElements(PathwayElement element1, PathwayElement element2, boolean temporary)
			{
				if (!temporary)
					TestResponseMapping.map(element1, element2);
				ArcGO tempArc = (ArcGO) pathwayDataView.createArc(element1, element2);
				if (tempArc != null)
					tempArc.setTemporary(temporary);
			}
			
		public ActiveIndex proposeTRMPlacement(LayoutObject effectLO, LayoutObject testLO)
			{
				if ((effectLO == null) || (testLO == null))
					return null;
				LayoutObjectsContainer effectContainer = effectLO.getParent();
				LayoutObjectsContainer testContainer = testLO.getParent();
				if (effectContainer == testContainer)
					{
						GraphicObject testGO = testLO.getGo();
						int x = testGO.getMidX();
						int y = effectLO.getY() + effectLO.getAvailableHeight() - testLO.getY() - testLO.getAvailableHeight();
						y = (y <= 0) ? testGO.getY() - ((testGO.getY()-effectLO.getGo().getBottom())/2) : testGO.getBottom() + ((effectLO.getGo().getY()-testGO.getBottom())/2);
						return effectContainer.getActiveIndex(x, y);
					}
				else
					{
						int xDif = (int) Math.signum(testContainer.getxIndex() - effectContainer.getxIndex());
						int yDif = (int) Math.signum(testContainer.getyIndex() - effectContainer.getyIndex());
						LayoutObjectsContainer container = (LayoutObjectsContainer) effectContainer.getAdjacentObject(xDif, yDif);
						return container.getActiveIndex(container.getMidX(), container.getMidY());
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
			
		private void cycleTestType()
			{
				if (testCycler == null)
					{
						testCycler = new PathwayElementTypeCycler(PathwayElementTypeCycler.SEQUENCE_TEST_CYCLE, true);
						testCycler.updateDataSource(currentElement.getDataSource());
					}
				Test oldTest = (Test) getCurrentActivePathwayElement();
				Test test = (Test) testCycler.nextElement(oldTest).clone(null, testCycler.getDataSource());
				Pathway.substitute(oldTest, test);
				ActiveIndex activeIndex = currentContainer.getActiveIndex(currentX, currentY);
				if (activeIndex.isCenterAction())
					owner.interfaceModeUpdated(this);
				pathwayDataView.setInView(activeIndex, currentContainer, test);
				pathwaysView.update();
				pathwaysViewUI.repaint();
			}
			
		@Override
		public void keyPressed(KeyEvent e)
			{
				boolean keyShftWasPressed = keyShiftPressed;
				super.keyPressed(e);
				if (keyShftWasPressed ^ keyShiftPressed)
					{
						Point mouse = pathwaysViewUI.getMousePosition();
						removeTempPE();
						if (mouse != null)
							updateTempPE(mouse.x, mouse.y);
					}
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_ESCAPE)
					{
						reset();
						pathwaysView.update();
						pathwaysViewUI.repaint();
						pathwaysViewUI.getViewUI().getPathwaySpaceToolbarUI().setDefaultMode();
					}
			}
			
		@Override
		public void keyReleased(KeyEvent e)
			{
				boolean keyShftWasPressed = keyShiftPressed;
				super.keyReleased(e);
				if (keyShftWasPressed ^ keyShiftPressed)
					{
						Point mouse = pathwaysViewUI.getMousePosition();
						removeTempPE();
						if (mouse != null)
							updateTempPE(mouse.x, mouse.y);
					}
			}
			
		public void mouseSingleClicked(MouseEvent e)
			{
				int x = e.getX();
				int y = e.getY();
				if (detectClickError(x, y) || (e.getButton() == MouseEvent.BUTTON2))
					return;
				setCurrentLO(viewLayout.isOver(x, y));
				setLastLO(viewLayout.getLastLO());
				currentContainer = viewLayout.getCurrentContainer();
				removeTempPE();
				performRequestedAction(x, y);
				updateElementEditor(lastElement);
				pathwaysViewUI.repaint();
				determineState();
				pathwaysViewUI.getViewUI().mouseMoved(e);
			}
			
		private void performRequestedAction(int x, int y)
			{
				PathwayElement activeElement = getCurrentActivePathwayElement();
				if ((keyShiftPressed) && (lastElement instanceof Effect))
					addNewTest(x, y);
				else if (activeElement instanceof Test)
					cycleTestType();
				else if (isExisting(x, y))
					{
						if ((lastElement != null) && (activeElement == lastElement))
							changePathwayElement(x, y);
						else if (isNewCycle(activeElement, x, y))
							changeActivePathwayElement(activeElement);
						else if (tryToLink(lastElementLO, currentLO, PERMANENTLY))
							{
								pathwaysView.update();
								viewLayout.isOver(x, y);
								selection.unselect(viewLayout);
								selection.select(lastElementLO);
							}
					}
				else
					addPathwayElement(x, y);
			}
			
		protected boolean detectClickError(int x, int y)
			{
				boolean lastElementIslink = (lastElement != null) && (lastElement instanceof Link);
				if (lastElementIslink && (lastElementLO.getX() > x))
					return true;
				GraphicObject cursorGO = viewLayout.getGraphicObjectUnderCursor(x, y);
				if ((cursorGO == null) || !(cursorGO instanceof PathwayElementGO))
					return false;
				PathwayElement justClickedOn = ((PathwayElementGO) cursorGO).getO();
				if (lastElementIslink && (lastElement == justClickedOn))
					return true;
				if ((lastElement instanceof Link) && ((Link) lastElement).isDirectlyLinkedTo(justClickedOn))
					return true;
				return false;
			}
			
		protected void reset()
			{
				lastElementLO = null;
				lastElement = null;
				removeTempPE();
				tempPE = null;
				selection.unselect(viewLayout);
				currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_SUBSTANCE_CYCLE, PathwayElementTypeCycler.STANDARD_SEQUENCE);
				determineState();
				viewLayout.setSimpleActiveRegion(true);
				viewLayout.setShowActiveRegion(false);
				pathwaysView.getViewLayout().setArcsSelectable(false);
			}
			
		protected void determineState()
			{
				PathwayElement pe = placed ? currentElement.whatWillBe(2, 0) : currentElement.getCurrent();
				int state;
				if (pe instanceof Initiator)
					state = 0;
				else if (pe instanceof Link)
					state = 1;
				else if (pe instanceof Effect)
					state = 2;
				else if (keyShiftPressed)
					state = 3;
				else
					state = -1;
				setState(state + 1);
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
				// System.out.println("updateTempPE ### x=" + x + " y=" + y);
				LayoutObject lo = viewLayout.getLayoutObjectUnderCursor(x, y);
				if ((lastActiveLO != null) && (lastActiveLO == lo))
					return;
				lastActiveLO = lo;
				PathwayElementGO go = (lo != null) ? (PathwayElementGO) lo.getGo() : null;
				if ((go != null) && ((go.getO() == tempPE) || (go.getO() == tempLinkPE) || (go.getO() == tempTRMPE)))
					return;
				removeTempPE();
				if (lastElement instanceof Effect_AdverseOutcome)
					return;
				if (lo != null && !lo.isTemporary() && go.isInside(x, y))
					{
						pathwaysView.update();
						if (keyShiftPressed)
							tryToMap(lastElementLO, lo, TEMPORARY);
						else
							tryToLink(lastElementLO, lo, TEMPORARY);
					}
				else
					{
						if (keyShiftPressed)
							tempPE = testCycler.getCurrent();
						else
							tempPE = whatIsNextInCycle(x, y);
						pathwaysView.update();
						addTempPE(x, y);
					}
				pathwaysView.update();
				
			}
			
		private void removeTempPE()
			{
				if (tempTRMPE != null)
					{
						unmap(tempTRMPE, TEMPORARY);
						pathwayDataView.removeFromView(tempTRMPE);
						tempTRMPE = null;
					}
				if (tempLinkPE != null)
					{
						// System.out.println("ublink(" + tempLinkPE.getClass() + ")");
						unlink(tempLinkPE, TEMPORARY);
						pathwayDataView.removeFromView(tempLinkPE);
						tempLinkPE = null;
					}
				if (tempPE != null)
					{
						// System.out.println("remove old tempPE(" + tempPE.getClass() + ")");
						pathwayDataView.removeFromView(tempPE);
						tempPE = null;
					}
			}
			
		protected void addTempPE(int x, int y)
			{
				if ((tempPE instanceof Effect_MolecularInitiatingEvent) && (pathwayHasMIE()))
					tempPE = DefaultEffectopediaObjects.DEFAULT_DOWNSTREAM_EFFECT;
				if (tempPE != null)
					{
						tempActiveIndex = currentContainer.getSimpleActiveIndex(x, y);
						if (currentContainer.isCompatible(tempPE.getClass()))
							{
								lastActiveLO = pathwayDataView.addTemporaryToView(tempActiveIndex, currentContainer, tempPE);
								if (lastActiveLO == null)
									{
										pathwaysView.update();
										if (!(tempPE instanceof Test))
											tryToLink(lastElementLO, viewLayout.getLayoutObjectUnderCursor(x, y), TEMPORARY);
										tempPE = null;
									}
								else if (lastElement != null)
									{
										pathwaysView.update();
										if ((lastElement instanceof Effect) && (tempPE instanceof Test))
											tryToMap((Effect) lastElement, lastElementLO, (Test) tempPE, lastActiveLO, TEMPORARY);
										else if ((lastElement instanceof Effect_MolecularInitiatingEvent) && (tempPE instanceof Initiator))
											tryToLink(lastActiveLO, lastElementLO, TEMPORARY);
										else
											tryToLink(lastElementLO, lastActiveLO, TEMPORARY);
									}
							}
					}
			}
			
		private boolean pathwayHasMIE()
			{
				Pathway p = getCurrentPathway();
				if (p != null)
					for (PathwayElement pe : p.getElements().getCachedObjects())
						if (pe instanceof Effect_MolecularInitiatingEvent)
							return true;
				return false;
			}
			
		@Override
		public String getContext()
			{
				PathwayElement peCurrent = getCurrentActivePathwayElement();
				GraphicObject lastElementGO = (lastElementLO != null) ? lastElementLO.getGo() : null;
				if ((peCurrent != null) && (lastElement != null) && (peCurrent != lastElement))
					return (currentGO!=null)&&(currentGO.isTemporary())?"-temporary":"-select";
				else if (peCurrent != null)
					if (peCurrent instanceof Effect)
						return "-modify_effect";
					else if (peCurrent instanceof Initiator)
						return "-modify_chemical";
					else if (peCurrent instanceof Link)
						return "-edit_link";
				if ((lastElementGO != null) && (currentX < lastElementGO.getX() + (lastElementGO.getWidth() / 3)))
					return "-" + "up";
				else
					return "-" + stateNames[state];
			}
			
		protected static final boolean			PERMANENTLY								= false;
		protected static final boolean			TEMPORARY										= true;
		
		private static String[]										stateNames									= new String[]
			{ "", "add_chemical", "add_link", "add_effect", "add_test" };
		private boolean																		askForConfirmation	= true;
		private boolean																		placed													= false;
		private PathwayElement											lastElement								= null;
		private LayoutObject													lastElementLO;
		private LayoutObject													lastActiveLO							= null;
		private PathwayElement											tempPE													= null;
		private Link																					tempLinkPE									= null;
		private TestResponseMapping						tempTRMPE										= null;
		private ActiveIndex														tempActiveIndex				= null;
		private PathwayElementTypeCycler	testCycler;
		
	}

package org.qsari.effectopedia.gui.im;

import java.awt.AWTException;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Effect_AdverseOutcome;
import org.qsari.effectopedia.core.objects.Effect_Endpoint;
import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;
import org.qsari.effectopedia.core.objects.Initiator;
import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.Link_ChemStructToChemStruct;
import org.qsari.effectopedia.core.objects.Link_ChemStructToMIE;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
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

public class NewIndexedGOIM extends IndexedGOIM
	{
		public static final int	ADD_CHEMICAL	= 1;
		public static final int	ADD_LINK					= 2;
		public static final int	ADD_EFFECT			= 3;
		public static final int	ADD_TEST					= 4;
		
		public NewIndexedGOIM(PathwaysViewUI pathwayUI, InterfaceModes owner)
			{
				super(pathwayUI, owner);
				setCursors(make5StateCursors(Cursor.getDefaultCursor(), UIResources.chemicalCursor, UIResources.linkCursor, UIResources.effectCursor, UIResources.testCursor));
				viewLayout.setSimpleActiveRegion(false);
				viewLayout.setShowActiveRegion(true);
				this.alternativeModeType = DRAG;
			}
			
		private void insertNewDownstreamLink()
			{
				Link link = (Link) ((PathwayElementGO) linkLO.getGo()).getO();
				LayoutObjectsContainer container = currentLO.getParent();
				GraphicObject go = currentLO.getGo();
				Effect intermediateEffect = (Effect) ((PathwayElementGO) go).getO();
				Effect effect = (Effect) link.outgoingAssociations()[0];
				if (effect == null)
					return;
				link.unlink_Down(effect);
				effect.unlink_Up(link);
				pathwayDataView.removeArc(link, effect);
				Link newLink = DefaultEffectopediaObjects.DEFAULT_LINK_ETE.clone(null, currentElement.getDataSource());
				pathwayDataView.setInView(container.getActiveIndex(go.getRight(), go.getMidY()), container, newLink);
				linkElements(link, intermediateEffect);
				linkElements(intermediateEffect, newLink);
				linkElements(newLink, effect);
			}
			
		private void insertNewUpstreamLink()
			{
				Link link = (Link) ((PathwayElementGO) linkLO.getGo()).getO();
				if (!(link instanceof Link_EffectToEffect))
					return;
				LayoutObjectsContainer container = currentLO.getParent();
				GraphicObject go = currentLO.getGo();
				Effect intermediateEffect = (Effect) ((PathwayElementGO) go).getO();
				PathwayElement upstreamElement = link.incommingAssociations()[0];
				if (upstreamElement == null)
					return;
				link.unlink_Up(upstreamElement);
				upstreamElement.unlink_Down(link);
				pathwayDataView.removeArc(upstreamElement, link);
				Link newLink = DefaultEffectopediaObjects.DEFAULT_LINK_ETE.clone(null, currentElement.getDataSource());
				pathwayDataView.setInView(container.getActiveIndex(go.getX() - 2, go.getMidY()), container, newLink);
				linkElements(upstreamElement, newLink);
				linkElements(newLink, intermediateEffect);
				linkElements(intermediateEffect, link);
				currentLO = null;
			}
			
		private void tryToLink(int x, int y)
			{
				if ((linkLO != null) && (currentLO != null) && (linkLO != currentLO))
					{
						pathwaysView.update();
						if (linkLO.getGo().getMidX() > x)
							insertNewUpstreamLink();
						else
							insertNewDownstreamLink();
						linkLO = null;
					}
				else if ((lastElementLO != null) && (currentLO != null))
					{
						PathwayElement upstreamElement = ((PathwayElementGO) lastElementLO.getGo()).getO();
						PathwayElement downstreamElement = ((PathwayElementGO) currentLO.getGo()).getO();
						if (lastElementLO.getX() > currentLO.getX())
							PathwayElement.swap(upstreamElement, downstreamElement);
						if ((upstreamElement instanceof Link_ChemStructToMIE) && (downstreamElement instanceof Initiator))
							upstreamElement = replaceLinkType((Link_ChemStructToMIE) upstreamElement, (Initiator) downstreamElement);
						if ((upstreamElement instanceof Link) ^ (downstreamElement instanceof Link))
							{
								linkElements(upstreamElement, downstreamElement);
								linkLO = null;
							}
					}
			}
			
		private Link_ChemStructToChemStruct replaceLinkType(Link_ChemStructToMIE link, Initiator initiator)
			{
				Initiator parentStructure = link.getStructure().getCachedObject();
				Link_ChemStructToChemStruct newLink = new Link_ChemStructToChemStruct(link.getParent(), link.getDataSource(), parentStructure, initiator);
				Pathway.unlink(parentStructure, link);
				((Pathway) link.getParent()).disassociate(link);
				pathwayDataView.replaceInView(link, newLink);
				pathwayDataView.createArc(newLink, initiator);
				associateWithExistingPathway(newLink.getStructure().getCachedObject(), link);
				return newLink;
			}
			
		private boolean isConnectedLink(PathwayElement link)
			{
				return ((link instanceof Link) && (link.hasIncommingAssociations() && link.hasOutgoingAssociations()));
			}
			
		private void linkElements(PathwayElement upstreamElement, PathwayElement downstreamElement)
			{
				if (PathwayElement.areLinked(upstreamElement, downstreamElement) || (isConnectedLink(upstreamElement) || isConnectedLink(downstreamElement)))
					return;
				upstreamElement.forceToLive();
				downstreamElement.forceToLive();
				upstreamElement.link_Down(downstreamElement);
				downstreamElement.link_Up(upstreamElement);
				pathwayDataView.createArc(upstreamElement, downstreamElement);
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
				if (upstreamWorkflow)
					return (element == null) && ((lastElementLO != null) && (lastElementLO.getGo().getX() + (2 * lastElementLO.getGo().getWidth() / 3) > x));
				else
					return (element == null) && ((lastElementLO != null) && (lastElementLO.getGo().getX() + (lastElementLO.getGo().getWidth() / 3) < x));
			}
			
		private PathwayElement whatIsNext(PathwayElement element, int x, int y)
			{
				if ((!newCycle) && (linkLO == null))
					{
						newCycle = isNewCycle(element, x, y);
						if (newCycle)
							{
								upstreamWorkflow = (lastElementLO == null) || ((lastElementLO != null) && (lastElementLO.getGo().getX() + (2 * lastElementLO.getGo().getWidth() / 3) > x));
								lastElementLO = null;
							}
					}
					
				if ((newCycle) || (element != null))
					{
						if (currentContainer.getxIndex() == 0)
							currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_SUBSTANCE_CYCLE, PathwayElementTypeCycler.STANDARD_SEQUENCE);
						else
							currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_EFFECT_CYCLE, PathwayElementTypeCycler.STANDARD_SEQUENCE);
						if ((element != null) && (!element.isGeneric()))
							{
								tryToLink(x, y);
								lastElementLO = currentLO;
								newCycle = false;
								if (upstreamWorkflow)
									currentElement.nextElement(element);
								else
									currentElement.previousElement(element);
								if (element instanceof Link)
									return element;
								else
									return null;
							}
						placed = false;
						PathwayElement e = currentElement.nextElement(element);
						if ((e instanceof Effect_AdverseOutcome) && ((element instanceof Effect_Endpoint) && (element.hasOutgoingAssociations())))
							e = currentElement.nextElement(e);
						return e.clone(null, currentElement.getDataSource());
					}
				else
					{
						if (linkLO != null)
							return DefaultEffectopediaObjects.DEFAULT_DOWNSTREAM_EFFECT.clone(null, currentElement.getDataSource());
						owner.interfaceModeUpdated(this);
						return currentElement.nextInSequence().clone(null, currentElement.getDataSource());
					}
			}
			
		private void addPathwayElement(int x, int y)
			{
				PathwayElement element = getCurrentActivePathwayElement();
				if (isNewCycle(element, x, y) && askForConfirmation)
					{
						boolean confirmation = UserInterface.getUserConfirmationWithOptions(
								"<html>The position you selected to create the new element is <b>upstream</b> from the last element.<br> Do you want to break the current element sequence and start new?</html>");
						askForConfirmation = UserInterface.isAskingConfirmation();
						if (!confirmation)
							return;
					}
				PathwayElement old = element;
				ActiveIndex activeIndex = currentContainer.getActiveIndex(x, y);
				if ((element instanceof Effect_MolecularInitiatingEvent) && (((currentGO != null) && (currentGO.isSelected()))) && (activeIndex.yActionIndex == 1) && (activeIndex.xActionIndex == 1))
					return;
				if ((element instanceof Link) && (((currentGO != null) && (currentGO.isSelected()))) && (activeIndex.yActionIndex == 1) && (activeIndex.xActionIndex == 1))
					return;
				if ((element instanceof Link) && (element == lastElement))
					return;
				
				element = whatIsNext(element, x, y);
				// System.out.println((EffectopediaObject.getDefaultObjects().get(element.getDefaultID())==element));
				if ((element == null) || (old == element))
					return;
				boolean substitue = false;
				if (currentContainer.isCompatible(element.getClass()))
					{
						if ((currentGO == null) || ((currentGO != null) && (currentGO.isSelected())))
							{
								if (!((old instanceof Link) && (element instanceof Link)))
									setCurrentLO(pathwayDataView.setInView(activeIndex, currentContainer, element));
								if ((old != null) && (element != null))
									{
										element.forceToLive();
										if ((old instanceof Effect) && (element instanceof Effect))
											{
												Pathway.substitute((Effect) old, (Effect) element);
												substitue = true;
											}
										else if ((old instanceof Initiator) && (element instanceof Initiator))
											{
												Pathway.substitute((Initiator) old, (Initiator) element);
												substitue = true;
											}
										else if ((old instanceof Link) && (element instanceof Link))
											setLinkLO(currentLO);
									}
								owner.interfaceModeUpdated(this);
								placed = true;
							}
						if (!substitue)
							tryToLink(x, y);
						associateWithExistingPathways(element);
						lastElementLO = currentLO;
						lastElement = element;
						pathwaysView.update();
						viewLayout.isOver(x, y);
						selection.unselect(viewLayout);
						selection.select(currentLO);
					}
				else
					currentElement.rollback();
				determineState();
				newCycle = false;
			}
			
		protected void setLinkLO(LayoutObject linkLO)
			{
				this.linkLO = linkLO;
			}
			
		private void addNewTest(int x, int y)
			{
				if (currentContainer != lastElementLO.getParent())
					return;
				if (testCycler == null)
					{
						testCycler = new PathwayElementTypeCycler(PathwayElementTypeCycler.SEQUENCE_TEST_CYCLE, true);
						testCycler.updateDataSource(currentElement.getDataSource());
					}
				Test test = (Test) testCycler.getCurrent().clone(null, testCycler.getDataSource());
				test.forceToLive();
				ActiveIndex activeIndex = currentContainer.getActiveIndex(x, y);
				if (activeIndex.isCenterAction())
					owner.interfaceModeUpdated(this);
				LayoutObject testLO = (pathwayDataView.setInView(activeIndex, currentContainer, test));
				if (lastElement instanceof Effect)
					TryToMap(lastElement, lastElementLO, test, testLO, true);
				pathwaysView.update();
				viewLayout.isOver(x, y);
				selection.unselect(viewLayout);
				selection.select(lastElementLO);
			}
			
		private void TryToMap(PathwayElement element1, LayoutObject element1LO, PathwayElement element2, LayoutObject element2LO, boolean attemtReverse)
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
					TryToMap(element2, element2LO, element1, element1LO, false);
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
				LayoutObject trmLO = pathwayDataView.setInView(activeIndex, currentContainer, trm);
				TryToMap(lastElement, lastElementLO, trm, trmLO, true);
				return trm;
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
			
		public void keyPressed(KeyEvent e)
			{
				super.keyPressed(e);
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_ESCAPE)
					pathwaysViewUI.getViewUI().getPathwaySpaceToolbarUI().setDefaultMode();
			}
			
		public void mouseSingleClicked(MouseEvent e)
			{
				int x = e.getX();
				int y = e.getY();
				if (detectClickError(x, y))
					return;
				setCurrentLO(viewLayout.isOver(x, y));
				setLastLO(viewLayout.getLastLO());
				currentContainer = viewLayout.getCurrentContainer();
				if ((keyShiftPressed) && (lastElement instanceof Effect))
					addNewTest(x, y);
				else if (getCurrentActivePathwayElement() instanceof Test)
					cycleTestType();
				else
					addPathwayElement(x, y);
				pathwaysViewUI.repaint();
				updateCanvasLocation(x, y);
				determineState();
				pathwaysViewUI.getViewUI().mouseMoved(e);
			}
			
		private void updateCanvasLocation(int x, int y)
			{
				if ((lastElementLO != null))
					try
						{
							Point pt = new Point(lastElementLO.getGo().getRight(), lastElementLO.getGo().getMidY());
							if (pathwaysViewUI.getRightmostVisibleLocation() < pt.x)
								pathwaysViewUI.scroll(x - lastElementLO.getGo().getRight()-1, y - lastElementLO.getGo().getMidY());
							else
								{
									SwingUtilities.convertPointToScreen(pt, pathwaysViewUI);
									Robot robot = new Robot();
									robot.mouseMove(pt.x+1, pt.y);
								}
						}
					catch (AWTException e)
						{
						}
			}
			
		protected boolean detectClickError(int x, int y)
			{
				boolean lastElementIslink = (lastElement != null) && (lastElement instanceof Link);
				if (lastElementIslink && upstreamWorkflow && (lastElementLO.getX() > x))
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
				newCycle = true;
				upstreamWorkflow = true;
				lastElementLO = null;
				lastElement = null;
				linkLO = null;
				currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_SUBSTANCE_CYCLE, PathwayElementTypeCycler.STANDARD_SEQUENCE);
				determineState();
				viewLayout.setSimpleActiveRegion(false);
				viewLayout.setShowActiveRegion(true);
				pathwaysView.getViewLayout().setArcsSelectable(false);
			}
			
		protected void determineState()
			{
				PathwayElement pe = placed ? currentElement.whatWillBe(1,0) : currentElement.getCurrent();
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
				setCurrentLO(viewLayout.isOver(currentX, currentY));
				setLastLO(viewLayout.getLastLO());
				pathwaysView.synchronizeActiveRegions(true);
				currentContainer = viewLayout.getCurrentContainer();
				determineState();
				if (this.lastGO != null)
					this.lastGO.setActive(this.lastGO == this.currentGO);
				determineState();
				pathwaysViewUI.getViewUI().repaint();
				if (!pathwaysViewUI.hasFocus())
					pathwaysViewUI.requestFocusInWindow();
			}
			
		@Override
		public String getContext()
			{
				PathwayElement peCurrent = getCurrentActivePathwayElement();
				//System.out.println(peCurrent + " " + lastElement);
				if ((peCurrent != null) && (lastElement != null) && (peCurrent != lastElement))
					return "-select";
				else if (peCurrent != null)
					if (peCurrent instanceof Effect)
						return "-modify_effect";
					else if (peCurrent instanceof Initiator)
						return "-modify_chemical";
					else if (peCurrent instanceof Link)
						return "-edit_link";
				GraphicObject lastElementGO = (lastElementLO != null) ? lastElementLO.getGo() : null;
				if ((lastElementGO != null) && (currentX < lastElementGO.getX() + (lastElementGO.getWidth() / 3)))
					return "-" + "up";
				else
					return "-" + stateNames[state];
			}
			
		private static String[]										stateNames										= new String[]
			{ "", "add_chemical", "add_link", "add_effect", "add_test" };
		private boolean																		askForConfirmation		= true;
		private LayoutObject													linkLO														= null;
		private boolean																		newCycle												= true;
		private boolean																		upstreamWorkflow				= true;
		private boolean																		placed														= false;
		private PathwayElement											lastElement									= null;
		private LayoutObject													lastElementLO;
		private PathwayElementTypeCycler	testCycler;
	}

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

public class NewTestIM2 extends IndexedGOIM
	{
		public static final int	ADD_CHEMICAL	= 1;
		public static final int	ADD_EFFECT			= 2;
		public static final int	ADD_TEST					= 4;
		
		public NewTestIM2(PathwaysViewUI pathwayUI, InterfaceModes owner)
			{
				super(pathwayUI, owner);
				setCursors(make4StateCursors(Cursor.getDefaultCursor(), UIResources.testCursor, UIResources.mappingCursor, UIResources.incompatibleCursor));
				this.alternativeModeType = DRAG;
				reset();
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
			
		private void changeActivePathwayElement(PathwayElement activeElement)
			{
				lastElementLO = currentLO;
				lastElement = activeElement;
				selection.unselect(viewLayout);
				selection.select(currentLO);
				placed = false;
			}
			
		private void addNewTest(int x, int y)
			{
				PathwayElement element = (currentGO != null) && (currentGO.isTemporary()) ? null : getCurrentActivePathwayElement();
				if ((element != null) && (!element.isGeneric()))
					return;
				removeTempPE();
				if (currentContainer.isCompatible(Test.class))
					{
						Test test = (Test) currentElement.nextElement(element).clone(null, currentElement.getDataSource());
						if (element != null)
							{
								test.forceToLive();
								Pathway.substitute(element, test);
							}
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
						lastElement = null;
						lastElementLO = null;
						updateElementEditor(test);
						// selection.select(lastElementLO);
					}
			}
			
		private void makePermanentMapping(Effect effect)
			{
				Test test = (Test) tempPE.clone(null, currentElement.getDataSource());
				pathwayDataView.replaceInView(tempPE, test);
				LayoutObject testLO = pathwayDataView.updateElementLocation(test);
				testLO.setTemporary(false);
				TestResponseMapping trm = tempTRMPE;
				LayoutObject trmLO = pathwayDataView.getLayoutObjectForElement(trm);
				if (trmLO != null)
					trmLO.setTemporary(false);
				test.forceToLive();
				trm.forceToLive();
				AssociateWithExistingPathways(effect, trm, test);
				mapElements(effect, trm, PERMANENTLY);
				mapElements(trm, test, PERMANENTLY);
				tempPE = null;
				tempTRMPE = null;
				updateElementEditor(test);
				reset();
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
				Test oldTest = (Test) getCurrentActivePathwayElement();
				Test test = (Test) currentElement.nextElement(oldTest).clone(null, currentElement.getDataSource());
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
			
		@Override
		public void mouseSingleClicked(MouseEvent e)
			{
				int x = e.getX();
				int y = e.getY();
				if ((e.getButton() == MouseEvent.BUTTON2))
					return;
				setCurrentLO(viewLayout.isOver(x, y));
				setLastLO(viewLayout.getLastLO());
				currentContainer = viewLayout.getCurrentContainer();
				performRequestedAction(x, y);
				pathwaysViewUI.repaint();
				determineState();
				pathwaysViewUI.getViewUI().mouseMoved(e);
			}
			
		private void performRequestedAction(int x, int y)
			{
				PathwayElement activeElement = getCurrentActivePathwayElement();
				if (activeElement instanceof Effect)
					if (placed)
						makePermanentMapping((Effect) activeElement);
					else
						changeActivePathwayElement(activeElement);
				else if ((lastElement != null) && (lastElement instanceof Effect))
					addNewTest(x, y);
				else if (activeElement instanceof Test)
					if (currentGO.isTemporary())
						{
							lastElementLO = lastActiveLO;
							lastElement = tempPE;
							placed = true;
						}
				// else
				// cycleTestType();
			}
			
		protected void reset()
			{
				lastElementLO = null;
				lastElement = null;
				placed = false;
				removeTempPE();
				tempPE = null;
				tempTRMPE = null;
				selection.unselect(viewLayout);
				currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_TEST_CYCLE, PathwayElementTypeCycler.FIXED_CYCLE);
				determineState();
				viewLayout.setSimpleActiveRegion(true);
				viewLayout.setShowActiveRegion(false);
				pathwaysView.getViewLayout().setArcsSelectable(false);
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
				PathwayElementGO go = (lo != null) ? (PathwayElementGO) lo.getGo() : null;
				boolean isInsideGo = (go != null) ? go.isInside(x, y) : false;
				if ((lastActiveLO != null) && (lastActiveLO == lo))
					if (placed)
						{
							if (isInsideGo == wasInsideGO)
								return;
						}
					else
						return;
				if ((go != null) && ((go.getO() == tempPE) || (go.getO() == tempTRMPE)))
					return;
				lastActiveLO = lo;
				wasInsideGO = isInsideGo;
				removeTempPE();
				if (lo != null && !lo.isTemporary() && isInsideGo)
					{
						pathwaysView.update();
						tryToMap(lastElementLO, lo, TEMPORARY);
					}
				else if (!placed)
					{
						tempPE = currentElement.getCurrent();
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
				if ((tempPE != null) && (!placed))
					{
						pathwayDataView.removeFromView(tempPE);
						tempPE = null;
					}
			}
			
		protected void addTempPE(int x, int y)
			{
				if (tempPE != null)
					{
						tempActiveIndex = currentContainer.getSimpleActiveIndex(x, y);
						if (currentContainer.isCompatible(tempPE.getClass()))
							{
								lastActiveLO = pathwayDataView.addTemporaryToView(tempActiveIndex, currentContainer, tempPE);
								if (lastActiveLO == null)
									{
										pathwaysView.update();
										tempPE = null;
									}
								else if (lastElement != null)
									{
										pathwaysView.update();
										if ((lastElement instanceof Effect) && (tempPE instanceof Test))
											tryToMap((Effect) lastElement, lastElementLO, (Test) tempPE, lastActiveLO, TEMPORARY);
									}
							}
					}
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
			
		protected static final boolean	PERMANENTLY					= false;
		protected static final boolean	TEMPORARY							= true;
		
		private boolean																placed										= false;
		private boolean																wasInsideGO					= false;
		private PathwayElement									lastElement					= null;
		private LayoutObject											lastElementLO;
		private LayoutObject											lastActiveLO				= null;
		private PathwayElement									tempPE										= null;
		private TestResponseMapping				tempTRMPE							= null;
		private ActiveIndex												tempActiveIndex	= null;
	}

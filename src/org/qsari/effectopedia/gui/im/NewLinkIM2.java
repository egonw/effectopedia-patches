package org.qsari.effectopedia.gui.im;

import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Initiator;
import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.go.ArcGO;
import org.qsari.effectopedia.go.IOPort;
import org.qsari.effectopedia.go.IOPorts;
import org.qsari.effectopedia.go.Layout.LayoutObject;
import org.qsari.effectopedia.go.Layout.LayoutObjectsContainer.ActiveIndex;
import org.qsari.effectopedia.go.pathway_elements.PathwayElementGO;
import org.qsari.effectopedia.gui.PathwaysViewUI;
import org.qsari.effectopedia.gui.UIResources;

public class NewLinkIM2 extends IndexedGOIM
	{
		public NewLinkIM2(PathwaysViewUI pathwayUI, InterfaceModes owner)
			{
				super(pathwayUI, owner);
				setCursors(make3StateCursors(Cursor.getDefaultCursor(), UIResources.linkCursor, UIResources.incompatibleCursor));
				this.alternativeModeType = DRAG;
				reset();
			}
			
		protected void reset()
			{
				currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_LINK_CYCLE, PathwayElementTypeCycler.FIXED_CYCLE);
				if (linkedElement1!=null)
					removeTempArc(linkedElement1, tempPE);
				removeTempPE();
				linkedElement1 = null;
				linkedElement2 = null;
				linkLO = null;
				viewLayout.setSimpleActiveRegion(true);
				viewLayout.setShowActiveRegion(false);
				pathwaysView.getViewLayout().setArcsSelectable(false);
			}
			
		private void addNewLink(int x, int y)
			{
				/*
				 * Link link = (Link)
				 * currentElement.nextElement(getCurrentActivePathwayElement()).clone(null,
				 * currentElement.getDataSource()); linkLO =
				 * pathwayDataView.addTemporaryToView(currentContainer.getActiveIndex(x, y),
				 * currentContainer, link);
				 */
				linkLO = pathwayDataView.getLayoutObjectForElement(tempPE);
				setCurrentLO(linkLO);
				pathwaysView.update();
				viewLayout.isOver(x, y);
				selection.unselect(viewLayout);
				selection.select(currentLO);
			}
			
		private void finalizeLink()
			{
				pathwayDataView.crateArc(linkLO, linkedElement2);
				if (linkedElement1.getX() > linkedElement2.getX())
					{
						LayoutObject temp = linkedElement1;
						linkedElement1 = linkedElement2;
						linkedElement2 = temp;
					}
				PathwayElement fromElement = ((PathwayElementGO) linkedElement1.getGo()).getO();
				PathwayElement toElement = ((PathwayElementGO) linkedElement2.getGo()).getO();
				Pathway pathway = pathwayDataView.getCurrentPathway();
				int x = (linkLO == null) ? lastX : linkLO.getGo().getX() + linkLO.getGo().getWidth() / 2;
				int y = (linkLO == null) ? lastY : linkLO.getGo().getY() + linkLO.getGo().getHeight() / 2;
				Link link = (Link) Pathway.getDirektLink(fromElement, toElement);
				if (link == null)
					link = Link.newLink(pathway, pathway.getDataSource(), fromElement, toElement);
				if (link == null)
					{
						if (linkLO != null)
							pathwayDataView.removeFromView(linkLO.getParent().getActiveIndex(x, y), currentContainer, ((PathwayElementGO) (linkLO.getGo())).getO());
						pathwaysView.update();
						viewLayout.isOver(x, y);
						reset();
						return;
					}
				link.forceToLive();
				associateWithExistingPathway(fromElement, link);
				associateWithExistingPathway(link, toElement);
				if (linkLO != null)
					currentContainer = linkLO.getParent();
				linkLO = pathwayDataView.setInView(currentContainer.getActiveIndex(x, y), currentContainer, link);
				setCurrentLO(linkLO);
				pathwaysView.update();
				viewLayout.isOver(x, y);
				selection.unselect(viewLayout);
				selection.select(currentLO);
				updateElementEditor(link);
				reset();
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
			
		public void keyPressed(KeyEvent e)
			{
				super.keyPressed(e);
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
					{
						if (linkLO != null)
							{
								int x = linkLO.getGo().getX() + linkLO.getGo().getWidth() / 2;
								int y = linkLO.getGo().getY() + linkLO.getGo().getHeight() / 2;
								pathwayDataView.removeFromView(linkLO.getParent().getActiveIndex(x, y), linkLO.getParent(), ((PathwayElementGO) (linkLO.getGo())).getO());
							}
						reset();
						pathwaysView.update();
						pathwaysViewUI.repaint();
						pathwaysViewUI.getViewUI().getPathwaySpaceToolbarUI().setDefaultMode();
					}
			}
			

		public void mouseMoved(MouseEvent e)
			{
				int x = e.getX();
				int y = e.getY();
				setCurrentLO(viewLayout.isOver(x, y));
				setLastLO(viewLayout.getLastLO());
				currentContainer = viewLayout.getCurrentContainer();
				updateTempPE(x, y);
				determineState();
				if (this.lastGO != null)
					this.lastGO.setActive(this.lastGO == this.currentGO);
				pathwaysViewUI.getViewUI().repaint();
				if (!pathwaysViewUI.hasFocus())
					pathwaysViewUI.requestFocusInWindow();
			}
			
		public void mouseSingleClicked(MouseEvent e)
			{
				lastX = e.getX();
				lastY = e.getY();
				setCurrentLO(viewLayout.isOver(lastX, lastY));
				setLastLO(viewLayout.getLastLO());
				currentContainer = viewLayout.getCurrentContainer();
				if (state == COMATIBLE)
					{
						if ((currentGO != null) && ((((PathwayElementGO) currentGO).getO() instanceof Initiator) || ((PathwayElementGO) currentGO).getO() instanceof Effect))
							{
								if (linkedElement1 == null)
									{
										linkedElement1 = currentLO;
										if (linkLO != null)
											{
												/*
												 * ArcGO tempArc = (ArcGO)
												 * pathwayDataView.crateArc(((PathwayElementGO)
												 * linkedElement1.getGo()).getO(), ((PathwayElementGO)
												 * linkLO.getGo()).getO()); if (tempArc != null)
												 * tempArc.setTemporary(true);
												 */
											}
									}
								else if ((linkedElement2 == null) && (linkedElement1 != currentLO))
									{
										linkedElement2 = currentLO;
										if (linkLO != null)
											finalizeLink();
									}
							}
						else if (linkLO == null)
							{
								if (linkedElement1 != null)
									{
										if (linkedElement2 != null)
											finalizeLink();
										else
											{
												addNewLink(lastX, lastY);
												pathwayDataView.crateArc(linkedElement1, linkLO);
											}
									}
								else
									addNewLink(lastX, lastY);
							}
					}
				pathwaysViewUI.repaint();
				determineState();
			}
			
		public IOPort getPort(LayoutObject lo, int x, int y)
			{
				if ((lo == null) || (currentContainer == null))
					return null;
				IOPorts ports = ((PathwayElementGO) lo.getGo()).getPorts();
				int portIndex;
				if (lo.getParent().equals(currentContainer))
					if ((currentLO != null) && (currentLO.isOver(x, y) != null))
						{
							ActiveIndex activeIndex = currentContainer.getActiveIndex(x, y);
							portIndex = ports.getOriginPortIndex(lo.getxIndex(), lo.getyIndex(), activeIndex.xActionIndex - 1, activeIndex.yActionIndex - 1);
						}
					else
						portIndex = ports.getOriginPortIndex(lo.getxIndex(), lo.getyIndex(), currentContainer.getXIndexByX(x), currentContainer.getYIndexByY(y));
				else
					portIndex = ports.getOriginPortIndex(lo.getParent().getxIndex(), lo.getParent().getyIndex(), currentContainer.getxIndex(), currentContainer.getyIndex());
				return (portIndex == -1) ? null : ports.port(portIndex);
			}
			
		protected void determineState()
			{
				int state = (currentContainer != null) ? ((currentContainer.isCompatible(currentElement.getCurrent().getClass())) ? 0 : 1) : 0;
				setState(state + 1);
			}
			
		public void setState(int state)
			{
				if (state != this.state)
					{
						this.state = state;
						setCursor();
					}
				if (state == -1)
					reset();
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
			
		protected void updateTempPE(int x, int y)
			{
				LayoutObject lo = viewLayout.getLayoutObjectUnderCursor(x, y);
				if ((lastActiveLO != null) && (lastActiveLO == lo))
					return;
				PathwayElementGO go = (lo != null) ? (PathwayElementGO) lo.getGo() : null;
				if ((go != null) && ((go.getO() == tempPE)))
					return;
				if (linkLO == null)
					{
						removeTempPE();
						tempPE = currentElement.getCurrent();
						pathwaysView.update();
						addTempPE(x, y);
						pathwaysView.update();
					}
				else
					{
						if (lastActiveLO != linkedElement1)
							removeTempArc(lastActiveLO, tempPE);
						createTempArc(lo, tempPE);
					}
				lastActiveLO = lo;
			}
			
		private void removeTempPE()
			{
				if (tempPE != null)
					{
						removeTempArc(linkedElement1, tempPE);
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
								else if (linkedElement1 != null)
									createTempArc(linkedElement1, tempPE);
							}
					}
			}
			
		public void createTempArc(LayoutObject lo1, PathwayElement element2)
			{
				PathwayElement element1;
				LayoutObject lo2;
				if (lo1 != null)
					element1 = ((PathwayElementGO) lo1.getGo()).getO();
				else
					return;
				if (element2 != null)
					lo2 = pathwayDataView.getLayoutObjectForElement(element2);
				else
					return;
				if ((element1 == null) || (lo2 == null))
					return;
				reverse = lo1.getX() > lo2.getX();
				if (reverse)
					{
						LayoutObject temp = lo1;
						PathwayElement tempE = element1;
						element1 = element2;
						lo1 = lo2;
						element2 = tempE;
						lo2 = temp;
					}
				ArcGO tempArc = (ArcGO) pathwayDataView.createArc(element1, element2);
				if (tempArc != null)
					tempArc.setTemporary(true);
			}
			
		public void removeTempArc(LayoutObject lo1, PathwayElement element2)
			{
				if (lo1 != null)
					if (reverse)
						pathwayDataView.removeArc(element2, ((PathwayElementGO) lo1.getGo()).getO());
					else
						pathwayDataView.removeArc(((PathwayElementGO) lo1.getGo()).getO(), element2);
			}
			
		@Override
		public String getContext()
			{
				if (linkLO == null)
					{
						if (linkedElement1 != null)
							return "-place_link";
					}
				else if (linkedElement1 != null)
					if (linkedElement1.getX() > linkLO.getX())
						return "-select_up";
					else
						return "-select_dn";
				else
					return "-select_up_or_dn";
				return "-start";
			}
			
		private boolean								reverse								= false;
		private LayoutObject			lastActiveLO			= null;
		private PathwayElement	tempPE									= null;
		private LayoutObject			linkedElement1	= null;
		private LayoutObject			linkedElement2	= null;
		private LayoutObject			linkLO									= null;
	}

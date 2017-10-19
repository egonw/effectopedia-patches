package org.qsari.effectopedia.go.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.qsari.effectopedia.core.objects.ContextDimension;
import org.qsari.effectopedia.core.objects.DocumentedKnowledge_Located;
import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Effect_DownstreamEffect;
import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;
import org.qsari.effectopedia.core.objects.Initiator;
import org.qsari.effectopedia.core.objects.Initiator_BiologcalPerturbation;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.Initiator_StructuralAlerts;
import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.objects.Test;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.go.ArcGO;
import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.IOPorts;
import org.qsari.effectopedia.go.StraightArcGO;
import org.qsari.effectopedia.go.Layout.LayoutObject;
import org.qsari.effectopedia.go.Layout.LayoutObjectSelection;
import org.qsari.effectopedia.go.Layout.LayoutObjectsContainer;
import org.qsari.effectopedia.go.Layout.LayoutObjectsContainer.ActiveIndex;
import org.qsari.effectopedia.go.containers.ArcsContainer;
import org.qsari.effectopedia.go.containers.GraphicObjectsContainer;
import org.qsari.effectopedia.go.pathway_elements.BiologicalPerturbationSPEGO;
import org.qsari.effectopedia.go.pathway_elements.ChemicalSPEGO;
import org.qsari.effectopedia.go.pathway_elements.EffectCPEGO;
import org.qsari.effectopedia.go.pathway_elements.LinkPEGO;
import org.qsari.effectopedia.go.pathway_elements.PathwayElementGO;
import org.qsari.effectopedia.go.pathway_elements.StructuralAlertsSPEGO;
import org.qsari.effectopedia.go.pathway_elements.TestCPEGO;
import org.qsari.effectopedia.go.pathway_elements.TestResponseMappingPEGO;
import org.qsari.effectopedia.gui.core.DataView;
import org.qsari.effectopedia.search.SearchResults;

public class PathwayVisualisationBuilder
	{
		
		public PathwayVisualisationBuilder(DataView view)
			{
				super();
				this.view = view;
				this.horizontal = view.getHorizontalDimension();
				this.vertical = view.getVerticalDimension();
				this.globalGOC = view.getViewLayout().getGlobalGOC();
				this.globalLOC = view.getViewLayout().getGlobalLOC();
				this.arcs = view.getViewLayout().getArcs();
				this.viewElements = new HashMap<PathwayElement, LayoutObject>();
				this.viewPathways = new ArrayList<Pathway>();
				if ((this.horizontal != null) && (this.vertical != null))
					this.indexMatrix = new ContextSpaceIndexMatrix(this.globalLOC, this.horizontal, this.vertical);
			}
			
		public boolean isVisible(PathwayElement element)
			{
				return viewElements.get(element) != null;
			}
			
		public PathwayElementGO newGOforPathwayElement(PathwayElement element)
			{
				if (element == null)
					return null;
				else if (Effect.class.isAssignableFrom(element.getClass()))
					return new EffectCPEGO((Effect) element);
				else if (Link.class.isAssignableFrom(element.getClass()))
					return new LinkPEGO(element);
				else if (Test.class.isAssignableFrom(element.getClass()))
					return new TestCPEGO(element);
				else if (Initiator_ChemicalStructure.class.isAssignableFrom(element.getClass()))
					return new ChemicalSPEGO(element);
				else if (Initiator_StructuralAlerts.class.isAssignableFrom(element.getClass()))
					return new StructuralAlertsSPEGO(element);
				else if (Initiator_BiologcalPerturbation.class.isAssignableFrom(element.getClass()))
					return new BiologicalPerturbationSPEGO(element);
				else if (TestResponseMapping.class.isAssignableFrom(element.getClass()))
					return new TestResponseMappingPEGO(element);
				else
					return null;
			}
			
		public LayoutObjectsContainer findContainer(PathwayElement element)
			{
				if (element instanceof DocumentedKnowledge_Located)
					return (LayoutObjectsContainer) indexMatrix.getLayoutObject(element, horizontal.DIMENSION_INDEX, vertical.DIMENSION_INDEX);
				else if (element instanceof Initiator)
					{
						PathwayElement[] downstreamMIE = PathwayElement.getNextLevelOutgoingAssociations(element.outgoingAssociations());
						boolean hasLocated = false;
						for (PathwayElement pe : downstreamMIE)
							if (pe instanceof DocumentedKnowledge_Located)
								{
									hasLocated = true;
									break;
								}
						if (!hasLocated)
							downstreamMIE = PathwayElement.getNextLevelOutgoingAssociations(PathwayElement.getNextLevelOutgoingAssociations(downstreamMIE));
						return (LayoutObjectsContainer) globalLOC.getComponent(0, indexMatrix.getAverageYIndex(downstreamMIE, vertical.DIMENSION_INDEX));
					}
				else if (element instanceof Link)
					{
						PathwayElement[] upsteam = element.incommingAssociations();
						PathwayElement[] downstream = element.outgoingAssociations();
						if ((upsteam.length == 1) && (downstream.length == 1))
							{
								LayoutObjectsContainer cUp = findContainer(upsteam[0]);
								LayoutObjectsContainer cDown = findContainer(downstream[0]);
								if (cUp == null)
									if (cDown != null)
										return cDown;
									else
										return (LayoutObjectsContainer) globalLOC.getComponent(0, 0);
								else if (cDown == null)
									return cUp;
								if (cUp == cDown)
									return cUp;
								else
									{
										int xDif = cDown.getxIndex() - cUp.getxIndex();
										if (Math.abs(xDif) > 1)
											xDif /= Math.abs(xDif);
										int yDif = cDown.getyIndex() - cUp.getyIndex();
										if (Math.abs(yDif) > 1)
											yDif /= Math.abs(yDif);
										return (LayoutObjectsContainer) globalLOC.getComponent(cUp.getxIndex() + xDif, cUp.getyIndex() + yDif);
									}
							}
					}
				else if (element instanceof TestResponseMapping)
					{
						PathwayElement[] upsteam = element.incommingMappings();
						if (upsteam.length == 1)
							return findContainer(upsteam[0]);
						PathwayElement[] downstream = element.outgoingMappings();
						if (downstream.length == 1)
							return findContainer(downstream[0]);
					}
				return (LayoutObjectsContainer) globalLOC.getComponent(0, 0);
			}
			
		public LayoutObject addPathwayElement(PathwayElement element)
			{
				currentContainer = findContainer(element);
				if ((currentContainer != null) && (element != null))
					{
						PathwayElement upstreamElement = null;
						if (element.hasIncommingAssociations())
							{
								PathwayElement incoming[] = element.incommingAssociations();
								for (int e = 0; e < incoming.length; e++)
									if (viewElements.containsKey(incoming[e]))
										{
											upstreamElement = incoming[e];
											break;// TODO this gets the first visible upstream element and does
											// not handle the case with multiple visible upstream elements
										}
							}
						return PlacePathwayElement(upstreamElement, element);
					}
				return null;
			}
			
		public LayoutObject addPathwayElement(PathwayElement element, int neighboursDepth)
			{
				if (element != null)
					{
						LayoutObject lo = addPathwayElement(element);
						placeUpstreamElements(element, neighboursDepth);
						placeDownstreamElements(element, neighboursDepth);
						return lo;
					}
				return null;
			}
			
		public LayoutObject setPathwayElement(ActiveIndex activeIndex, LayoutObjectsContainer container, PathwayElement element)
			{
				currentContainer = container;
				if ((currentContainer != null) && (element != null))
					{
						LayoutObject layoutObject = createVisualElements(currentContainer, element);
						if (activeIndex.isCenterAction())
							{
								LayoutObject lo = container.getComponent(activeIndex.xIndex, activeIndex.yIndex);
								if (lo != null)
									{
										PathwayElementGO oldElement = ((PathwayElementGO) lo.getGo());
										viewElements.remove(oldElement.getO());
										arcs.substitute(oldElement, (PathwayElementGO) layoutObject.getGo());
										container.getGo().delete(oldElement);
									}
								if (container.isEmpty())
									container.addFirstComponent(layoutObject);
								else
									container.setComponent(activeIndex.xIndex, activeIndex.yIndex, layoutObject);
							}
						else
							container.insert(activeIndex, layoutObject);
						viewElements.put(element, layoutObject);
						return layoutObject;
					}
				return null;
			}
			
		public LayoutObject addPathwayElement(ActiveIndex activeIndex, LayoutObjectsContainer container, PathwayElement element)
			{
				currentContainer = container;
				if ((currentContainer != null) && (element != null))
					{
						LayoutObject layoutObject = createVisualElements(currentContainer, element);
						if ((activeIndex.yActionIndex == 1) && (activeIndex.xActionIndex == 1))
							{
								LayoutObject lo = container.getComponent(activeIndex.xIndex, activeIndex.yIndex);
								if (lo != null)
									{
										activeIndex.yActionIndex = 2;
										container.insert(activeIndex, layoutObject);
									}
								else if (container.isEmpty())
									container.addFirstComponent(layoutObject);
								else if (container.isValidIndex(activeIndex.xIndex, activeIndex.yIndex))
									container.setComponent(activeIndex.xIndex, activeIndex.yIndex, layoutObject);
								else
									container.insert(activeIndex, layoutObject);
							}
						else
							container.insert(activeIndex, layoutObject);
						viewElements.put(element, layoutObject);
						return layoutObject;
					}
				return null;
			}
			
		public LayoutObject setTemporaryPathwayElement(ActiveIndex activeIndex, LayoutObjectsContainer container, PathwayElement element)
			{
				currentContainer = container;
				if ((currentContainer != null) && (element != null))
					{
						LayoutObject layoutObject;
						container.update();
						if (container.isEmpty())
							{
								layoutObject = createTemporaryVisualElements(currentContainer, element);
								container.addFirstComponent(layoutObject);
							}
						else if (!activeIndex.isCenterAction())
							{
								layoutObject = createTemporaryVisualElements(currentContainer, element);
								container.insert(activeIndex, layoutObject);
							}
						else if ((container.isValidIndex(activeIndex.xIndex, activeIndex.yIndex)) && (container.getComponent(activeIndex.xIndex, activeIndex.yIndex) == null))
							{
								layoutObject = createTemporaryVisualElements(currentContainer, element);
								container.setComponent(activeIndex.xIndex, activeIndex.yIndex, layoutObject);
							}
						else
							return null;
						viewElements.put(element, layoutObject);
						return layoutObject;
					}
				return null;
				
			}
			
		public LayoutObject replaceInView(PathwayElement element, PathwayElement newElement)
			{
				LayoutObject lo = viewElements.get(element);
				LayoutObjectsContainer container = lo.getParent();
				if (lo != null)
					{
						PathwayElementGO go = ((PathwayElementGO) lo.getGo());
						if ((newElement.getClass() != element.getClass()) && ((newElement instanceof Initiator) || ((newElement instanceof Test))))
							{
								PathwayElementGO newGO = newGOforPathwayElement(newElement);
								lo.setGo(newGO);
								((GraphicObjectsContainer) container.getGo()).delete(go);
								((GraphicObjectsContainer) container.getGo()).add(newGO);
							}
						go.setO(newElement);
						if (newElement instanceof DocumentedKnowledge_Located)
							((DocumentedKnowledge_Located) newElement).getCoordinates().setAll(((DocumentedKnowledge_Located) element).getCoordinates().getCoordiantes());
						viewElements.put(newElement, lo);
						viewElements.remove(element);
					}
				return lo;
			}
			
		public void removePathwayElement(ActiveIndex activeIndex, LayoutObjectsContainer container, PathwayElement element)
			{
				if ((container != null) && (element != null))
					{
						LayoutObject layoutObject = viewElements.get(element);
						if (layoutObject != null)
							{
								viewElements.remove(((PathwayElementGO) layoutObject.getGo()).getO());
								container.setComponent(activeIndex.xIndex, activeIndex.yIndex, null);
								container.getGo().delete(layoutObject.getGo());
								arcs.removeArcsConnectedTo((PathwayElementGO) layoutObject.getGo());
							}
					}
			}
			
		public void deletePathwayElement(LayoutObject layoutObject, boolean preservePath, boolean unlink, boolean genericOnly)
			{
				if (layoutObject != null)
					{
						PathwayElement element = ((PathwayElementGO) layoutObject.getGo()).getO();
						if (viewElements.get(element) == null)
							return;
						viewElements.remove(element);
						layoutObject.getParent().clear(layoutObject.getxIndex(), layoutObject.getyIndex());
						layoutObject.getParent().getGo().delete(layoutObject.getGo());
						arcs.removeArcsConnectedTo((PathwayElementGO) layoutObject.getGo());
						if (!genericOnly || element.isGeneric())
							{
								boolean willUnlink = true;
								for (Pathway p : element.getPathwayIDs().getCachedObjects())
									if (!viewPathways.contains(p))
										{
											willUnlink = false;
											break;
										}
								for (Pathway pathway : viewPathways)
									pathway.disassociate(element);
								if ((preservePath) && (element instanceof Effect) && willUnlink)
									{
										PathwayElement incomming[] = element.incommingAssociations();
										PathwayElement outgoing[] = element.outgoingAssociations();
										if (!genericOnly || ((PathwayElement.areGeneric(incomming)) && (PathwayElement.areGeneric(outgoing))))
											{
												if ((outgoing != null) && (outgoing.length == 1) && (outgoing[0].hasOutgoingAssociations()))
													{
														PathwayElement d = outgoing[0].outgoingAssociations()[0];
														for (int i = incomming.length - 1; i >= 0; i--)
															{
																Pathway.link(incomming[i], d);
																createArc(incomming[i], d);
															}
														deletePathwayElement(viewElements.get(outgoing[0]), preservePath, unlink, genericOnly);
													}
												else if ((incomming.length == 1) && (incomming[0].hasIncommingAssociations()))
													{
														PathwayElement u = incomming[0].incommingAssociations()[0];
														for (int i = outgoing.length - 1; i >= 0; i--)
															{
																Pathway.link(u, outgoing[i]);
																createArc(u, outgoing[i]);
															}
														deletePathwayElement(viewElements.get(incomming[0]), preservePath, unlink, genericOnly);
													}
											}
									}
								if (willUnlink)
									{
										unlinkFromVisible(element);
										if (element instanceof TestResponseMapping)
											unmap((TestResponseMapping) element);
									}
							}
					}
			}
			
		private void unlinkFromVisible(PathwayElement element)
			{
				PathwayElement[] associations = element.incommingAssociations();
				if (associations != null)
					for (int i = associations.length - 1; i >= 0; i--)
						if (viewElements.containsKey(associations[i]))
							Pathway.unlink(associations[i], element);
				associations = element.outgoingAssociations();
				if (associations != null)
					for (int i = associations.length - 1; i >= 0; i--)
						if (viewElements.containsKey(associations[i]))
							Pathway.unlink(element, associations[i]);
			}
			
		private void unmap(TestResponseMapping trm)
			{
				Effect effect = trm.getEffect().getCachedObject();
				Test test = trm.getTest().getCachedObject();
				if ((test != null) && (effect != null))
					Pathway.unmap(effect, trm, test);
			}
			
		public void removePathwayElements(LayoutObjectSelection selection)
			{
				if (selection == null)
					return;
				// System.out.println("delete " + selection.size());
				Iterator<LayoutObject> it = selection.getSelectionIterator();
				while (it.hasNext())
					{
						LayoutObject layoutObject = it.next();
						viewElements.remove(((PathwayElementGO) layoutObject.getGo()).getO());
						layoutObject.getParent().setComponent(layoutObject.getxIndex(), layoutObject.getyIndex(), null);
						layoutObject.getParent().getGo().delete(layoutObject.getGo());
						arcs.removeArcsConnectedTo((PathwayElementGO) layoutObject.getGo());
					}
			}
			
		public void removePathwayElement(PathwayElement element)
			{
				if (element == null)
					return;
				LayoutObject layoutObject = viewElements.get(element);
				deletePathwayElement(layoutObject, true, true, false);
				
			}
			
		public void deletePathwayElements(LayoutObjectSelection selection, boolean preservePath, boolean unlink, boolean genericOnly)
			{
				if (selection == null)
					return;
				Iterator<LayoutObject> it = selection.getSelectionIterator();
				while (it.hasNext())
					deletePathwayElement(it.next(), preservePath, unlink, genericOnly);
			}
			
		public void addPathway(Pathway pathway)
			{
				long pathwayID = pathway.getID();
				pathway.updateSegmentRoots();
				viewPathways.add(pathway);
				ArrayList<PathwayElement> segmentRooots = pathway.getSegmentRoots();
				for (PathwayElement root : segmentRooots)
					PlacePathwaySegment(pathwayID, null, root);
			}
			
		private LayoutObject createVisualElements(LayoutObjectsContainer container, PathwayElement element)
			{
				LayoutObject layoutObject = new LayoutObject(container);
				GraphicObject gObject = newGOforPathwayElement(element);
				layoutObject.setGo(gObject);
				layoutObject.setScale(view.getViewLayout().getScale());
				((GraphicObjectsContainer) container.getGo()).add(gObject);
				if (element.isGeneric())
					{
						indexMatrix.setCoordinate(element, horizontal.DIMENSION_INDEX, container.getxIndex());
						indexMatrix.setCoordinate(element, vertical.DIMENSION_INDEX, container.getyIndex());
					}
				return layoutObject;
			}
			
		private LayoutObject createTemporaryVisualElements(LayoutObjectsContainer container, PathwayElement element)
			{
				LayoutObject layoutObject = new LayoutObject(container);
				GraphicObject gObject = newGOforPathwayElement(element);
				layoutObject.setGo(gObject);
				layoutObject.setScale(view.getViewLayout().getScale());
				((GraphicObjectsContainer) container.getGo()).add(gObject);
				layoutObject.setTemporary(true);
				return layoutObject;
			}
			
		public void updateElementLocation(PathwayElement element, LayoutObjectsContainer container)
			{
				indexMatrix.setCoordinate(element, horizontal.DIMENSION_INDEX, container.getxIndex());
				indexMatrix.setCoordinate(element, vertical.DIMENSION_INDEX, container.getyIndex());
			}
			
		private LayoutObject PlacePathwayElement(PathwayElement upstreamElement, PathwayElement element)
			{
				if (!viewElements.containsKey(element))
					{
						LayoutObject layoutObject = createVisualElements(currentContainer, element);
						if ((upstreamElement == null) || (currentContainer.isEmpty()))
							currentContainer.addRow(0, layoutObject);
						else
							{
								LayoutObject prevElement = viewElements.get(upstreamElement);
								if ((prevElement == null) || (prevElement.getParent() != currentContainer))
									currentContainer.addRow(0, layoutObject);
								else
								// Upstream element is in the same container
									{
										int xIndex = prevElement.getxIndex() + 1;
										int yIndex = prevElement.getyIndex();
										if (xIndex < currentContainer.getxCount())
											if (currentContainer.getComponent(xIndex, yIndex) == null)
												currentContainer.setComponent(xIndex, yIndex, layoutObject);
											else
												currentContainer.insertOnANewRow(xIndex, currentContainer.getyCount(), layoutObject);
										else
											currentContainer.insertOnANewColumn(xIndex, yIndex, layoutObject);
										// currentContainer.insertOnANewColumn(xIndex,
										// currentContainer.getyCount() - 1, layoutObject);
									}
							}
						viewElements.put(element, layoutObject);
						return layoutObject;
					}
				else
					updateLocationIfNeeded(upstreamElement, element);
				return viewElements.get(element);
			}
			
		private void updateLocationIfNeeded(PathwayElement upstreamElement, PathwayElement element)
			{
				LayoutObject ue = viewElements.get(upstreamElement);
				LayoutObject e = viewElements.get(element);
				if ((e != null) && (ue != null))
					if (ue.getParent() == e.getParent())
						{
							int uex = ue.getxIndex();
							int ex = e.getxIndex();
							if (uex > ex)
								currentContainer.moveComponent(ex, e.getyIndex(), uex + 1, e.getyIndex());
						}
			}
			
		public ArcGO createArc(PathwayElement upstreamElement, PathwayElement element)
			{
				return createArc(viewElements.get(upstreamElement), viewElements.get(element));
			}
			
		public ArcGO createArc(LayoutObject locOrigin, LayoutObject locEnd)
			{
				if ((locOrigin != null) && (locEnd != null))
					{
						LayoutObject o = locOrigin.getParent();
						LayoutObject e = locEnd.getParent();
						if (o == e)
							{
								o = locOrigin;
								e = locEnd;
							}
						int xOrigin = o.getxIndex();
						int yOrigin = o.getyIndex();
						int xEnd = e.getxIndex();
						int yEnd = e.getyIndex();
						IOPorts origin = ((PathwayElementGO) locOrigin.getGo()).getPorts();
						IOPorts end = ((PathwayElementGO) locEnd.getGo()).getPorts();
						int originPortIndex = origin.getOriginPortIndex(xOrigin, yOrigin, xEnd, yEnd);
						int endPortIndex = end.getEndPortIndex(xOrigin, yOrigin, xEnd, yEnd);
						if ((originPortIndex != -1) && (endPortIndex != -1))
							{
								StraightArcGO arc = new StraightArcGO(origin.use(originPortIndex), end.use(endPortIndex));
								arcs.add(arc);
								return arc;
							}
					}
				return null;
			}
			
		public void removeArc(PathwayElement upstreamElement, PathwayElement element)
			{
				LayoutObject locOrigin = viewElements.get(upstreamElement);
				LayoutObject locEnd = viewElements.get(element);
				if ((locOrigin != null) && (locEnd != null))
					arcs.removeArcBetween((PathwayElementGO) locOrigin.getGo(), (PathwayElementGO) locEnd.getGo());
			}
			
		private void createLocalLink(LayoutObjectSelection selection, LayoutObject upstreamElement, LayoutObject downstreamElement, Pathway pathway)
			{
				PathwayElement ue = ((PathwayElementGO) upstreamElement.getGo()).getO();
				PathwayElement de = ((PathwayElementGO) downstreamElement.getGo()).getO();
				Link link = Link.newLink(pathway, pathway.getDataSource(), ue, de);
				currentContainer = upstreamElement.getParent();
				if ((currentContainer != null) && (link != null))
					{
						LayoutObject layoutObject = createVisualElements(currentContainer, link);
						if (selection != null)
							selection.select(layoutObject);
						int yDif = downstreamElement.getyIndex() - upstreamElement.getyIndex();
						yDif = (yDif < 0) ? -1 : (yDif == 0) ? 0 : 1;
						int xIndex = upstreamElement.getxIndex() + 1;
						int yIndex = upstreamElement.getyIndex() + yDif;
						if (currentContainer.getComponent(xIndex, yIndex) == null)
							currentContainer.setComponent(xIndex, yIndex, layoutObject);
						else if (yDif == 0)
							currentContainer.insertOnANewColumn(xIndex, yIndex, layoutObject);
						else
							currentContainer.insertOnANewRow(xIndex, currentContainer.getyCount(), layoutObject);
						viewElements.put(link, layoutObject);
						createArc(ue, link);
						createArc(link, de);
					}
			}
			
		private LayoutObject createLink(LayoutObjectSelection selection, LayoutObject upstreamElement, LayoutObject downstreamElement, LayoutObjectsContainer targetContainer, Pathway pathway, boolean above)
			{
				PathwayElement ue = ((PathwayElementGO) upstreamElement.getGo()).getO();
				PathwayElement de = ((PathwayElementGO) downstreamElement.getGo()).getO();
				currentContainer = targetContainer;
				Link link = Link.newLink(pathway, pathway.getDataSource(), ue, de);
				LayoutObject layoutObject = createVisualElements(currentContainer, link);
				if (selection != null)
					selection.select(layoutObject);
				if (ue instanceof Initiator)
					currentContainer.insertOnANewColumn(1, 0, layoutObject);
				else if (above)
					currentContainer.insertOnANewRow(0, 0, layoutObject);
				else
					targetContainer.addRow(0, layoutObject);
				viewElements.put(link, layoutObject);
				createArc(ue, link);
				createArc(link, de);
				return layoutObject;
			}
			
		private LayoutObject createEfect(LayoutObjectSelection selection, LayoutObject upstreamElement, LayoutObjectsContainer targetContainer, Pathway pathway, boolean above)
			{
				PathwayElement ue = ((PathwayElementGO) upstreamElement.getGo()).getO();
				currentContainer = targetContainer;
				Effect effect;
				boolean isMIE = (ue instanceof Initiator);
				if (isMIE)
					effect = new Effect_MolecularInitiatingEvent(pathway, pathway.getDataSource());
				else
					effect = new Effect_DownstreamEffect(pathway, pathway.getDataSource());
				LayoutObject layoutObject = createVisualElements(currentContainer, effect);
				if (selection != null)
					selection.select(layoutObject);
				if (isMIE)
					currentContainer.insertOnANewColumn(1, 0, layoutObject);
				else if (above)
					currentContainer.insertOnANewRow(0, 0, layoutObject);
				else
					targetContainer.addRow(0, layoutObject);
				viewElements.put(effect, layoutObject);
				return layoutObject;
			}
			
		public void buildPath(LayoutObjectSelection selection, LayoutObject upstreamElement, LayoutObject downstreamElement, Pathway pathway, boolean above)
			{
				if ((upstreamElement == null) || (downstreamElement == null))
					return;
				LayoutObjectsContainer uec = upstreamElement.getParent();
				LayoutObjectsContainer dec = downstreamElement.getParent();
				if (uec.equals(dec))
					createLocalLink(selection, upstreamElement, downstreamElement, pathway);
				else
					{
						int uXIndex = uec.getxIndex();
						int dXIndex = dec.getxIndex();
						int xDif = dXIndex - uXIndex;
						int uYIndex = uec.getyIndex();
						int dYIndex = dec.getyIndex();
						int yDif = dYIndex - uYIndex;
						if ((xDif % 2 == 1) || (yDif % 2 == 1))
							return;
						LayoutObjectsContainer targetContainer;
						LayoutObject currentElement = upstreamElement;
						if (xDif > 2)
							{
								targetContainer = (LayoutObjectsContainer) globalLOC.getComponent(uXIndex, dYIndex);
								currentElement = createEfect(selection, upstreamElement, targetContainer, pathway, above);
								targetContainer = (LayoutObjectsContainer) globalLOC.getComponent(uXIndex, uYIndex + yDif / 2);
								createLink(selection, upstreamElement, currentElement, targetContainer, pathway, above);
								int xIndex = uXIndex;
								while (xIndex < dXIndex - 2)
									{
										LayoutObject lastElement = currentElement;
										xIndex += 2;
										targetContainer = (LayoutObjectsContainer) globalLOC.getComponent(xIndex, dYIndex);
										currentElement = createEfect(selection, lastElement, targetContainer, pathway, above);
										targetContainer = (LayoutObjectsContainer) globalLOC.getComponent(xIndex - 1, dYIndex);
										createLink(selection, lastElement, currentElement, targetContainer, pathway, above);
									}
							}
						targetContainer = (LayoutObjectsContainer) globalLOC.getComponent(dXIndex - 1, dYIndex);
						createLink(selection, currentElement, downstreamElement, targetContainer, pathway, above);
					}
				if (viewPathways.indexOf(pathway) == -1)
					viewPathways.add(pathway);
			}
			
		private void PlacePathwaySegment(long pathwayID, PathwayElement upstreamElement, PathwayElement element)
			{
				// System.out.println(((upstreamElement != null) ? upstreamElement + ":" +
				// upstreamElement.getIDsDescription() : "null") + "\t"
				// + ((element != null) ? element + ":" + element.getIDsDescription() :
				// "null"));
				currentContainer = findContainer(element);
				PlacePathwayElement(upstreamElement, element);
				createArc(upstreamElement, element);
				if ((element instanceof Effect) && (element.hasOutgoingMappings()))
					PlaceMappedElements(element);
				if (element.hasOutgoingAssociations())
					{
						PathwayElement outgoing[] = element.outgoingAssociations();
						for (int e = 0; e < outgoing.length; e++)
							if ((outgoing[e].belongsTo(pathwayID)))
								PlacePathwaySegment(pathwayID, element, outgoing[e]);
					}
			}
			
		private void addPathwayFragment(PathwayElement upstreamElement, PathwayElement element, HashSet<PathwayElement> visibleElements)
			{
				if (!visibleElements.contains(element))
					return;
				currentContainer = findContainer(element);
				PlacePathwayElement(upstreamElement, element);
				createArc(upstreamElement, element);
				if ((element instanceof Effect) && (element.hasOutgoingMappings()))
					PlaceMappedElements(element);
				if (element.hasOutgoingAssociations())
					{
						PathwayElement outgoing[] = element.outgoingAssociations();
						for (int e = 0; e < outgoing.length; e++)
							addPathwayFragment(element, outgoing[e], visibleElements);
					}
			}
			
		public class ContainerComparator implements Comparator<Map.Entry<LayoutObjectsContainer, ArrayList<LayoutObject>>>
			{
				@Override
				public int compare(Map.Entry<LayoutObjectsContainer, ArrayList<LayoutObject>> lo1, Map.Entry<LayoutObjectsContainer, ArrayList<LayoutObject>> lo2)
					{
						int xI1 = lo1.getKey().getxIndex();
						int xI2 = lo2.getKey().getxIndex();
						return (xI1 <= xI2) ? (xI1 == xI2) ? 0 : -1 : 1;
					}
			}
			
		private void PlaceMappedElements(PathwayElement element)
			{
				if (!showTestMethods)
					return;
				PathwayElement mappings[] = element.outgoingMappings();
				PathwayElement tests[] = PathwayElement.getOutgoingMappingElements(element.outgoingMappings());
				HashMap<LayoutObjectsContainer, ArrayList<LayoutObject>> testLOs = new HashMap<LayoutObjectsContainer, ArrayList<LayoutObject>>();
				HashMap<PathwayElement, PathwayElement> mHash = new HashMap<PathwayElement, PathwayElement>();
				ArrayList<LayoutObject> los;
				ArrayList<LayoutObject> clos = new ArrayList<LayoutObject>();
				for (int t = 0; t < tests.length; t++)
					if (!viewElements.containsKey(mappings[t]))
						{
							LayoutObjectsContainer container;
							LayoutObject tLO = viewElements.get(tests[t]);
							mHash.put(tests[t], mappings[t]);
							if (tLO == null)
								{
									container = findContainer(tests[t]);
									tLO = createVisualElements(container, tests[t]);
								}
							else
								container = tLO.getParent();
							if (container == currentContainer)
								clos.add(tLO);
							else
								{
									los = testLOs.get(container);
									if (los == null)
										{
											los = new ArrayList<LayoutObject>();
											testLOs.put(container, los);
										}
									los.add(tLO);
								}
						}
				placeTestAndMappingsBelowElement(element, clos, mHash);
				ArrayList<Map.Entry<LayoutObjectsContainer, ArrayList<LayoutObject>>> list = new ArrayList<Map.Entry<LayoutObjectsContainer, ArrayList<LayoutObject>>>(testLOs.entrySet());
				ContainerComparator containerComparator = new ContainerComparator();
				Collections.sort(list, containerComparator);
				for (Map.Entry<LayoutObjectsContainer, ArrayList<LayoutObject>> entry : list)
					placeTestsInContainer(entry.getKey(), element, entry.getValue(), mHash);
			}
			
		private void placeTestsInContainer(LayoutObjectsContainer container, PathwayElement element, ArrayList<LayoutObject> los, HashMap<PathwayElement, PathwayElement> mHash)
			{
				if (los == null)
					return;
				LayoutObject elementLO = viewElements.get(element);
				int yPosDif = container.getyIndex() - currentContainer.getyIndex();
				yPosDif = (yPosDif > 0) ? 1 : -1;
				int cnt = los.size();
				int midIndex = ((cnt & 1) != 0) ? (cnt >> 1) : (cnt >> 1) - 1;
				int inserted = 0;
				int i = 0;
				
				while (inserted < cnt)
					{
						int index = midIndex + i;
						LayoutObject tLO = los.get(index);
						PathwayElement test = ((PathwayElementGO) tLO.getGo()).getO();
						container.putInRow(((yPosDif < 0) ? container.getxCount() - 1 : 0), tLO);
						viewElements.put(test, tLO);
						PathwayElement mapping = mHash.get(test);
						LayoutObject mLO = viewElements.get(mapping);
						if (mLO == null)
							mLO = createVisualElements(currentContainer, mapping);
						if (elementLO.hasAdjacentPosition(i, yPosDif) && (elementLO.getAdjacentObject(i, yPosDif) == null))
							currentContainer.setComponent(elementLO.getxIndex() + i, elementLO.getyIndex() + yPosDif, mLO);
						else if (elementLO.hasAdjacentPosition(0, yPosDif))
							currentContainer.insertOnANewColumn(currentContainer.getxCount(), elementLO.getyIndex() + yPosDif, mLO);
						else
							currentContainer.insertOnANewRow(elementLO.getxIndex() + i, elementLO.getyIndex() + ((yPosDif < 0) ? 0 : 1), mLO);
						viewElements.put(mapping, mLO);
						createArc(element, mapping);
						createArc(mapping, test);
						inserted++;
						i = (i == 0) ? 1 : (i < 0) ? -i + 1 : -i;
					}
			}
			
		private void placeTestAndMappingsBelowElement(PathwayElement element, ArrayList<LayoutObject> los, HashMap<PathwayElement, PathwayElement> mHash)
			{
				if ((los != null) && (los.size() > 0))
					{
						PathwayElement test;
						PathwayElement mapping;
						LayoutObject elementLO = viewElements.get(element);
						int cnt = los.size();
						int midIndex = ((cnt & 1) != 0) ? (cnt >> 1) : (cnt >> 1) - 1;
						int inserted = 0;
						int i = 0;
						int xIndex = elementLO.getxIndex();
						int yIndex = elementLO.getyIndex();
						int maxYIndex = currentContainer.getyCount();
						LayoutObject[] mtLO =
							{ null, null };
						if (yIndex == maxYIndex - 1)
							{
								mtLO[1] = los.get(midIndex);
								test = ((PathwayElementGO) mtLO[1].getGo()).getO();
								mapping = mHash.get(test);
								mtLO[0] = viewElements.get(mapping);
								if (mtLO[0] == null)
									mtLO[0] = createVisualElements(currentContainer, mapping);
								currentContainer.insertOnANewRow(xIndex, yIndex + 1, mtLO[0]);
								currentContainer.insertOnANewRow(xIndex, yIndex + 2, mtLO[1]);
								viewElements.put(mapping, mtLO[0]);
								viewElements.put(test, mtLO[1]);
								createArc(element, mapping);
								createArc(mapping, test);
								inserted++;
								i = 1;
							}
						while (inserted < cnt)
							{
								int index = midIndex + i;
								mtLO[1] = los.get(index);
								test = ((PathwayElementGO) mtLO[1].getGo()).getO();
								mapping = mHash.get(test);
								mtLO[0] = viewElements.get(mapping);
								if (mtLO[0] == null)
									mtLO[0] = createVisualElements(currentContainer, mapping);
								for (int p = 0; p <= 1; p++)
									if (elementLO.hasAdjacentPosition(i, 1 + p) && (elementLO.getAdjacentObject(i, 1 + p) == null))
										currentContainer.setComponent(xIndex + i, yIndex + 1 + p, mtLO[p]);
									else
										currentContainer.insertOnANewColumn(((i < 0) ? ++xIndex + i : xIndex + i), yIndex + 1 + p, mtLO[p]);
								viewElements.put(mapping, mtLO[0]);
								viewElements.put(test, mtLO[1]);
								createArc(element, mapping);
								createArc(mapping, test);
								i = (i <= 0) ? -i + 1 : -i;
								inserted++;
							}
					}
			}
			
		private void placeDownstreamElements(PathwayElement element, int neighboursDepth)
			{
				if ((element.hasOutgoingAssociations()) && (neighboursDepth > 0))
					{
						PathwayElement outgoing[] = element.outgoingAssociations();
						for (int e = 0; e < outgoing.length; e++)
							{
								addPathwayElement(outgoing[e]);
								createArc(element, outgoing[e]);
								placeDownstreamElements(outgoing[e], neighboursDepth - 1);
							}
					}
			}
			
		private void placeUpstreamElements(PathwayElement element, int neighboursDepth)
			{
				if ((element.hasIncommingAssociations()) && (neighboursDepth > 0))
					{
						PathwayElement incomming[] = element.incommingAssociations();
						for (int e = 0; e < incomming.length; e++)
							{
								addPathwayElement(incomming[e]);
								createArc(incomming[e], element);
								placeUpstreamElements(incomming[e], neighboursDepth - 1);
							}
					}
			}
			
		public void addSearchResults(SearchResults searchResults)
			{
				// TODO To be implemented
				
			}
			
		public void clear()
			{
				this.arcs.clear();
				this.viewElements.clear();
				this.viewPathways.clear();
				this.horizontal = this.view.getHorizontalDimension();
				this.vertical = this.view.getVerticalDimension();
				this.indexMatrix = new ContextSpaceIndexMatrix(this.globalLOC, this.horizontal, this.vertical);
				Iterator<LayoutObject> it = this.globalLOC.getComponentsIterator();
				while (it.hasNext())
					((LayoutObjectsContainer) it.next()).clear();
				Iterator<GraphicObject> git = this.globalGOC.getComponentsIterator();
				while (git.hasNext())
					((GraphicObjectsContainer) git.next()).clear();
			}
			
		public void rebuildView()
			{
				HashSet<PathwayElement> visibleElements = new HashSet<PathwayElement>();
				visibleElements.addAll(viewElements.keySet());
				ArrayList<PathwayElement> fragmentRoots = getFragments(true);
				ArrayList<Pathway> pathways = new ArrayList<Pathway>();
				pathways.addAll(viewPathways);
				clear();
				for (Pathway pathway : pathways)
					addPathway(pathway);
				for (PathwayElement element : fragmentRoots)
					addPathwayFragment(null, element, visibleElements);
				view.getViewLayout().zoom();
			}
			
		private ArrayList<PathwayElement> getFragments(boolean rootsOnly)
			{
				ArrayList<PathwayElement> fragments = new ArrayList<PathwayElement>();
				Iterator<Entry<PathwayElement, LayoutObject>> iterator = viewElements.entrySet().iterator();
				while (iterator.hasNext())
					{
						PathwayElement element = iterator.next().getKey();
						boolean isInViewPathway = false;
						for (Pathway pathway : viewPathways)
							{
								isInViewPathway = element.belongsTo(pathway.getID());
								if (isInViewPathway)
									break;
							}
						if (!isInViewPathway)
							if (rootsOnly)
								{
									if (!element.hasIncommingAssociations() && (!element.hasIncommingMappings()))
										fragments.add(element);
								}
							else
								fragments.add(element);
					}
				return fragments;
			}
			
		public Map<PathwayElement, LayoutObject> getViewElements()
			{
				return Collections.unmodifiableMap(viewElements);
			}
			
		public boolean isShowTestMethods()
			{
				return showTestMethods;
			}
			
		public void setShowTestMethods(boolean showTestMethods)
			{
				this.showTestMethods = showTestMethods;
			}
			
		protected final GraphicObjectsContainer							globalGOC;
		protected final LayoutObjectsContainer								globalLOC;
		protected final ArcsContainer																	arcs;
		protected ContextDimension																				horizontal;
		protected ContextDimension																				vertical;
		protected LayoutObjectsContainer														currentContainer	= null;
		protected ContextSpaceIndexMatrix													indexMatrix;
		/**
		 * Contains key-value map of <code>PathwayElement</code> descendants (like
		 * Effects, Links, Tests, Substances) and their corresponding
		 * <code>LayoutObject</code>s
		 * 
		 * @see PathwyaElement
		 */
		private HashMap<PathwayElement, LayoutObject>	viewElements;
		private ArrayList<Pathway>																				viewPathways;
		private DataView																														view;
		private boolean																															showTestMethods		= true;
	}

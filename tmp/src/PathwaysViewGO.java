package org.qsari.effectopedia.go.pathway_elements;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Effect_AdverseOutcome;
import org.qsari.effectopedia.core.objects.Effect_DownstreamEffect;
import org.qsari.effectopedia.core.objects.Effect_Endpoint;
import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;
import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.core.objects.Link_SubstanceToMIE;
import org.qsari.effectopedia.core.objects.Link_SubstanceToReactiveSubstance;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.objects.Substance;
import org.qsari.effectopedia.core.objects.Substance_Chemical;
import org.qsari.effectopedia.core.objects.Substance_ReactiveChemical;
import org.qsari.effectopedia.core.objects.Test;
import org.qsari.effectopedia.go.ArcGO;
import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.StraightArcGO;
import org.qsari.effectopedia.go.Layout.BasicLayout;
import org.qsari.effectopedia.go.Layout.HeterogeniusLayout;
import org.qsari.effectopedia.go.Layout.IndexedGOSizes;
import org.qsari.effectopedia.go.containers.GraphicObjectContainer;

public class PathwaysViewGO extends GraphicObject
	{
		public GraphicObjectContainer	segments;
		public GraphicObjectContainer	arcs;
		public BasicLayout				layout;
		
		public void GenerateTestPathway()
			{
				ArrayList<PathwayElementGO> lastSegment = new ArrayList<PathwayElementGO>();
				ArrayList<PathwayElementGO> currentSegment = new ArrayList<PathwayElementGO>();
				
				details = layout.getDetails();
				IndexedGOSizes dim = layout.getDimensions();
				PathwayElement e;
				Pathway p = new Pathway(null);
				segments.clear();
				
				SegmentGO segment = new SegmentGO(0, SubstancePEGO.class);
				segment.x = 0;
				segment.y = 0;
				segment.height = 1200;
				segment.width = dim.estimateTotalWidth(ChemicalSPEGO.class);
				
				ChemicalSPEGO chemical = new ChemicalSPEGO(e = new Substance_Chemical(p), segment);
				chemical.setX(segment.x + dim.estimateHGap(ChemicalSPEGO.class));
				chemical.setY(layout.getDefaultIntialSegmentOffset(segment) + segment.y);
				dim.resizeGO(chemical);
				
				segment.addComponent(chemical);
				s = p.getSegmentIDs().getSegment(0);
				s.add(e);
				
				segment.setDetails(details);
				segments.add(segment);
				
				int offset = segment.width;
				
				segment = new SegmentGO(1, LinkPEGO.class);
				segment.x = offset;
				segment.y = 0;
				segment.height = 1024;
				segment.width = dim.estimateTotalWidth(LinkPEGO.class);
				
				LinkPEGO bioact = new LinkPEGO(e = new Link_SubstanceToReactiveSubstance(p), segment);
				bioact.setX(segment.x + dim.estimateHGap(LinkPEGO.class));
				bioact.setY(layout.getDefaultIntialSegmentOffset(segment) + segment.y);
				dim.resizeGO(bioact);
				
				segment.addComponent(bioact);
				s = p.getSegmentIDs().getSegment(1);
				s.add(e);
				
				segment.setDetails(details);
				segments.add(segment);
				
				arcs.add(new StraightArcGO(chemical, bioact));
				chemical.connectPorts(bioact);
				
				offset += segment.width;
				
				segment = new SegmentGO(2, SubstancePEGO.class);
				segment.x = offset;
				segment.y = 0;
				segment.height = 1024;
				segment.width = dim.estimateTotalWidth(ChemicalSPEGO.class);
				
				chemical = new ChemicalSPEGO(e = new Substance_ReactiveChemical(p), segment);
				chemical.setX(segment.x + dim.estimateHGap(ChemicalSPEGO.class));
				chemical.setY(layout.getDefaultIntialSegmentOffset(segment) + segment.y);
				dim.resizeGO(chemical);
				
				segment.addComponent(chemical);
				s = p.getSegmentIDs().getSegment(2);
				s.add(e);
				lastSegment.add(chemical);
				
				segment.setDetails(details);
				segments.add(segment);
				
				arcs.add(new StraightArcGO(bioact, chemical));
				bioact.connectPorts(chemical);
				offset += segment.width;
				
				int y_offset;
				int maxY = 0;
				for (int i = 0; i < 14; i++)
					{
						if ((i & 1) == 1)
							segment = new SegmentGO(i + 3, ContextPEGO.class);
						else
							segment = new SegmentGO(i + 3, LinkPEGO.class);
						s = p.getSegmentIDs().getSegment(i + 3);
						s.setSegmentIndex(i + 3);
						
						segment.setDetails(details);
						segment.x = offset;
						segment.y = 0;
						segment.height = 1024;
						y_offset = layout.getDefaultIntialSegmentOffset(segment);
						
						currentSegment.clear();
						
						if ((i & 1) == 1)
							{
								segment.width = dim.estimateTotalWidth(EffectCPEGO.class);
								offset += segment.width;
								
								int middleIndex = lastSegment.size() / 2;
								segment.getComponents().setBaseIndex(middleIndex + 1);
								PathwayElementGO igo = chemical;
								boolean firstEffect = true;
								for (ListIterator<PathwayElementGO> iterator = lastSegment.listIterator(); iterator.hasNext();)
									{
										igo = iterator.next();
										e = (i == 1) ? new Effect_MolecularInitiatingEvent(p) : (i == 11) ? new Effect_Endpoint(p) : (i == 13) ? new Effect_AdverseOutcome(p) : new Effect_DownstreamEffect(p);
										s.add(e);
										EffectCPEGO effect = new EffectCPEGO((Effect) e, segment);
										effect.setX(segment.x + dim.estimateHGap(EffectCPEGO.class));
										effect.setY(y_offset);
										dim.resizeGO(effect);
										y_offset += dim.estimateTotalHeight(EffectCPEGO.class);
										effect.setDetails(segment.getDetails());
										segment.addComponent(effect);
										// segment.segment.add((PathwayElement)effect.o);
										
										for (int k = 0; k < (Math.random() * 0) - 1; k++)
											{
												Test t = new Test(p);
												s.add(t);
												t.setTitle("Test " + new Integer(i).toString() + ":" + new Integer(k).toString());
												TestCPEGO test = new TestCPEGO(t, segment);
												test.setX(segment.x + 2 * dim.estimateHGap(TestCPEGO.class));
												test.setY(y_offset);
												dim.resizeGO(test);
												y_offset += dim.estimateTotalHeight(TestCPEGO.class);
												effect.connectTestPorts(test);
												test.setDetails(segment.getDetails());
												segment.addComponent(test);
												// segment.segment.add((PathwayElement)test.o);
												((Effect) effect.o).getRelatedTests().add(t);
											}
										
										StraightArcGO arc = new StraightArcGO(igo, effect);
										igo.connectPorts(effect);
										if (i == 1)
											{
												((Link_SubstanceToMIE) igo.o).getToEffect().set((Effect) effect.o);
												((Effect_MolecularInitiatingEvent) effect.o).getUpstreamLinkIDs().add((Link_SubstanceToMIE) igo.o);
											}
										else if (i < 11)
											{
												((Link_EffectToEffect) igo.o).getToEffect().set((Effect) effect.o);
												((Effect_DownstreamEffect) effect.o).getUpstreamLinkIDs().add((Link_EffectToEffect) igo.o);
											}
										else if (i == 11)
											{
												((Link_EffectToEffect) igo.o).getToEffect().set((Effect) effect.o);
												((Effect_Endpoint) effect.o).getUpstreamLinkIDs().add((Link_EffectToEffect) igo.o);
											}
										else if (i == 13)
											{
												((Link_EffectToEffect) igo.o).getToEffect().set((Effect) effect.o);
												((Effect_AdverseOutcome) effect.o).getUpstreamLinkIDs().add((Link_EffectToEffect) igo.o);
											}
										
										arcs.add(arc);
										if ((Math.random() > 0.5) || firstEffect)
											currentSegment.add(effect);
										firstEffect = false;
									}
							}
						else
							{
								segment.width = dim.estimateTotalWidth(LinkPEGO.class);
								offset += segment.width;
								int middleIndex = lastSegment.size() / 2;
								segment.getComponents().setBaseIndex(middleIndex + 1);
								int iter = 0;
								for (ListIterator<PathwayElementGO> iterator = lastSegment.listIterator(); iterator.hasNext();)
									{
										PathwayElementGO igo = iterator.next();
										for (int j = 0; j < 1 + ((iter == middleIndex) ? 1 : 0); j++)
											{
												e = (i == 0) ? new Link_SubstanceToMIE(p) : new Link_EffectToEffect(p);
												s.add(e);
												LinkPEGO link = new LinkPEGO(e, segment);
												
												if (i == 0)
													{
														((Link_SubstanceToMIE) link.o).getSubstance().set((Substance_ReactiveChemical) igo.o);
													}
												else
													{
														if (igo.o instanceof Effect_DownstreamEffect)
															((Effect_DownstreamEffect) igo.o).getDownstreamLinkIDs().add((Link_EffectToEffect) link.o);
														else if (igo.o instanceof Effect_MolecularInitiatingEvent)
															((Effect_MolecularInitiatingEvent) igo.o).getDownstreamLinkIDs().add((Link_EffectToEffect) link.o);
														((Link_EffectToEffect) link.o).getFromEffect().set((Effect) igo.o);
													}
												link.setX(segment.x + dim.estimateHGap(LinkPEGO.class));
												link.setY(y_offset);
												dim.resizeGO(link);
												y_offset += dim.estimateTotalHeight(LinkPEGO.class);
												link.setDetails(segment.getDetails());
												StraightArcGO arc = new StraightArcGO(igo, link);
												segment.addComponent(link);
												// segment.segment.add((PathwayElement)link.o);
												arcs.add(arc);
												igo.connectPorts(link);
												currentSegment.add(link);
											}
										iter++;
									}
							}
						maxY = Math.max(1200, Math.max(maxY, y_offset));
						segments.add(segment);
						lastSegment.clear();
						lastSegment.addAll(currentSegment);
					}
				
				for (int i = 0; i < SegmentIDs.DEFAULT_SEGMENTS - 3 - 14; i++)
					{
						if ((i & 1) == 1)
							segment = new SegmentGO(i + 1, ContextPEGO.class);
						else
							segment = new SegmentGO(i + 1, LinkPEGO.class);
						segment.setDetails(details);
						segment.x = offset;
						segment.y = 0;
						segment.height = maxY;
						segment.width = dim.estimateTotalWidth(((i & 1) == 1) ? EffectCPEGO.class : LinkPEGO.class);
						offset += segment.width;
						segments.add(segment);
					}
				
				segments.setHeight(maxY);
				segments.setBaseIndex(3);
				// layout.distribute();
				setWidth(offset);
				setHeight(Math.max(maxY, 1024));
				segments.synchronizer.synchronize(segments, GOSynchronizer.SYNCHRONIZE_XWD);
			}
		
		public PathwaysViewGO()
			{
				segments = new GraphicObjectContainer();
				arcs = new GraphicObjectContainer();
				layout = new HeterogeniusLayout(segments, arcs);// new BasicLayout(segments,
				// arcs);
				generateDefaultSegments();
			}
		
		public void generateDefaultSegments()
			{
				int maxY = 1024;
				details = layout.getDetails();
				IndexedGOSizes dim = layout.getDimensions();
				
				SegmentGO segment = new SegmentGO(0, ChemicalSPEGO.class);
				segment.x = 0;
				segment.y = 0;
				segment.height = maxY;
				segment.width = dim.estimateTotalWidth(ChemicalSPEGO.class);
				segments.add(segment);
				
				int offset = segment.width;
				for (int i = 0; i < SegmentIDs.DEFAULT_SEGMENTS - 1; i++)
					{
						if ((i & 1) == 1)
							segment = new SegmentGO(i + 1, ContextPEGO.class);
						else
							segment = new SegmentGO(i + 1, LinkPEGO.class);
						segment.setDetails(details);
						segment.x = offset;
						segment.y = 0;
						segment.height = maxY;
						segment.width = dim.estimateTotalWidth(((i & 1) == 1) ? EffectCPEGO.class : LinkPEGO.class);
						offset += segment.width;
						segments.add(segment);
					}
				setWidth(offset);
				setHeight(maxY);
			}
		
		public void clearSegments()
			{
				segments.clear();
				generateDefaultSegments();
			}
		
		public void appendToView(Pathway pathway)
			{
				if (pathway == null)
					return;
				
			}
		
		public PathwayElementGO appendToView(PathwayElement pathwayElement, int segmentIndex)
			{
				if ((pathwayElement == null) || (segmentIndex < 0) || (segmentIndex > segments.getCount()))
					return null;
				SegmentGO segment = (SegmentGO) segments.getList().get(segmentIndex);
				int index = segment.contains(pathwayElement);
				PathwayElementGO pathwayElementGO = null;
				if (index != -1)
					pathwayElementGO = ((PathwayElementGO) segment.getComponents().getList().get(index));
				else
					{
						pathwayElementGO = createFromPathwayElement(pathwayElement, segment);
						layout.addGO(pathwayElementGO, segment, segment.getComponents().maxY() + 1);
					}
				pathwayElementGO.setO(pathwayElement);
				return pathwayElementGO;
			}
		
		protected PathwayElementGO createFromPathwayElement(PathwayElement pathwayElement, SegmentGO segment)
			{
				if (pathwayElement instanceof Substance)
					{
						if (pathwayElement instanceof Substance_Chemical)
							return new ChemicalSPEGO(pathwayElement, segment);
						else
							return new StructuralAlertsSPEGO(pathwayElement, segment);
					}
				else if (pathwayElement instanceof Effect)
					return new EffectCPEGO((Effect) pathwayElement, segment);
				else if (pathwayElement instanceof Link)
					return new LinkPEGO((Link) pathwayElement, segment);
				else if (pathwayElement instanceof Test)
					return new TestCPEGO(pathwayElement, segment);
				else
					return null;
			}
		
		public void rebuildArcs()
			{
				arcs.clear();
				int segmentsCount = segments.getCount();
				if (segmentsCount <= 1)
					return;
				for (int i = 1; i < segmentsCount - 1; i++)
					{
						SegmentGO fromSegment = (SegmentGO) segments.getList().get(i - 1);
						SegmentGO toSegment = (SegmentGO) segments.getList().get(i);
						
					}
			}
		
		protected void appendToView(PathwayElementGO pathwayElementGO, int segmentIndex)
			{
				
			}
		
		public GraphicObject isOver(int x, int y)
			{
				lastGOUnderTheMouse = currentGOUnderTheMouse;
				currentGOUnderTheMouse = segments.isOver(x, y);
				return currentGOUnderTheMouse;
			}
		
		public void setSelected(boolean selected)
			{
				this.selected = selected;
				segments.setSelected(selected);
			}
		
		public void setSelected(int x, int y, int width, int height)
			{
				this.selected = isIntersected(x, y, width, height);
				if (this.selected)
					segments.setSelected(x, y, width, height);
			}
		
		public int areLinkable(PathwayElementGO igo1, PathwayElementGO igo2)
			{
				int segmentIndex1 = this.segments.getGraphicObjectIndex(igo1.getParentSegment());
				int segmentIndex2 = this.segments.getGraphicObjectIndex(igo2.getParentSegment());
				return segmentIndex1 - segmentIndex2;
			}
		
		public void linkIfPossible(PathwayElementGO igo1, PathwayElementGO igo2)
			{
				if ((igo1 != null) && (igo2 != null) && (igo1 != igo2))
					{
						
						int segmentIndex1 = this.segments.getGraphicObjectIndex(igo1.getParentSegment());
						int segmentIndex2 = this.segments.getGraphicObjectIndex(igo2.getParentSegment());
						if (Math.abs(segmentIndex1 - segmentIndex2) != 1)
							return;
						if (segmentIndex1 > segmentIndex2)
							{
								PathwayElementGO temp = igo1;
								igo1 = igo2;
								igo2 = temp;
							}
						if (igo1.isConnected(igo2) || ((igo1 instanceof LinkPEGO) && igo1.outPort.numberOfConnectedPorts() != 0) || ((igo2 instanceof LinkPEGO) && igo2.inPort.numberOfConnectedPorts() != 0))
							return;
						igo1.connectPorts(igo2);
						arcs.add(new StraightArcGO(igo1, igo2));
					}
			}
		
		public void selectPaths(PathwayElementGO igo1, PathwayElementGO igo2)
			{
				int segmentIndex1 = this.segments.getGraphicObjectIndex(igo1.getParentSegment());
				int segmentIndex2 = this.segments.getGraphicObjectIndex(igo2.getParentSegment());
				
				if (segmentIndex1 > segmentIndex2)
					{
						int i = segmentIndex2;
						segmentIndex2 = segmentIndex1;
						segmentIndex1 = i;
						PathwayElementGO o = igo2;
						igo2 = igo1;
						igo1 = o;
					}
				
				LinkedList<PathwayElementGO> lastList = igo1.outPort.getConnectedPorts().getConnectedIGO();
				LinkedList<PathwayElementGO> currentList = new LinkedList<PathwayElementGO>();
				
				igo1.setSelected(true);
				igo2.setSelected(true);
				
				int i = segmentIndex1 + 1;
				while (i < segmentIndex2)
					{
						for (ListIterator<PathwayElementGO> iterator = lastList.listIterator(); iterator.hasNext();)
							iterator.next().setSelected(true);
						currentList.clear();
						for (ListIterator<PathwayElementGO> iterator = lastList.listIterator(); iterator.hasNext();)
							currentList.addAll(iterator.next().outPort.getConnectedPorts().getConnectedIGO());
						lastList.clear();
						lastList.addAll(currentList);
						i++;
					}
				
				i = segmentIndex2 - 1;
				SegmentGO currentSegment = (SegmentGO) segments.getPrevious(igo2.getParentSegment());
				lastList = igo2.inPort.getConnectedPorts().getConnectedIGO();
				while (i > segmentIndex1)
					{
						currentList.clear();
						for (ListIterator<GraphicObject> iterator = currentSegment.getComponents().getList().listIterator(); iterator.hasNext();)
							{
								PathwayElementGO current = (PathwayElementGO) iterator.next();
								if (current.isSelected())
									{
										boolean selectedAndConnected = lastList.indexOf(current) != -1;
										current.setSelected(selectedAndConnected);
										if (selectedAndConnected)
											currentList.addAll(current.inPort.getConnectedPorts().getConnectedIGO());
									}
							}
						lastList.clear();
						lastList.addAll(currentList);
						currentSegment = (SegmentGO) segments.getPrevious(currentSegment);
						i--;
					}
				
			}
		
		public PathwayElementGO newGO(SegmentGO segment, int outcomeIndex)
			{
				if (segment.isAllowed(EffectCPEGO.class))
					return new EffectCPEGO(Effect.newEffect(null, segment.segmentIndex, outcomeIndex), segment);
				else if (segment.isAllowed(LinkPEGO.class))
					return new LinkPEGO(Link.newLink(null, segment.segmentIndex), segment);
				else if (segment.isAllowed(SubstancePEGO.class))
					return new ChemicalSPEGO(Substance.newSubstance(null, segment.segmentIndex, false), segment);
				return null;
			}
		
		public void buildPath(int y, PathwayElementGO igo1, PathwayElementGO igo2)
			{
				int segmentIndex1 = this.segments.getGraphicObjectIndex(igo1.getParentSegment());
				int segmentIndex2 = this.segments.getGraphicObjectIndex(igo2.getParentSegment());
				
				if (segmentIndex1 > segmentIndex2)
					{
						int i = segmentIndex2;
						segmentIndex2 = segmentIndex1;
						segmentIndex1 = i;
						PathwayElementGO o = igo2;
						igo2 = igo1;
						igo1 = o;
					}
				
				PathwayElementGO lastIGO = igo1;
				PathwayElementGO newIGO = null;
				for (int i = segmentIndex1 + 1; i < segmentIndex2; i++)
					{
						SegmentGO currentSegment = (SegmentGO) this.segments.getList().get(i);
						newIGO = newGO(currentSegment, segmentIndex2);
						layout.addGO(newIGO, currentSegment, y);
						arcs.add(new StraightArcGO(lastIGO, newIGO));
						lastIGO.connectPorts(newIGO);
						lastIGO = newIGO;
					}
				arcs.add(new StraightArcGO(lastIGO, igo2));
				lastIGO.connectPorts(igo2);
				
			}
		
		public void deleteSelected()
			{
				ArrayList<GraphicObject> updatedArcs = new ArrayList<GraphicObject>();
				for (ListIterator<GraphicObject> iterator = arcs.getList().listIterator(); iterator.hasNext();)
					{
						ArcGO arc = (ArcGO) iterator.next();
						if (!(arc.getFromIGO().isSelected() || arc.getToIGO().isSelected()))
							updatedArcs.add(arc);
					}
				arcs.setList(updatedArcs);
				
				for (ListIterator<GraphicObject> segmentIterator = segments.getList().listIterator(); segmentIterator.hasNext();)
					((SegmentGO) segmentIterator.next()).getComponents().removeSelected();
			}
		
		public void draw(Graphics2D onCanvas)
			{
				onCanvas.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				segments.drawAll(onCanvas);
				arcs.drawAll(onCanvas);
			}
		
		public GraphicObject getLastGOUnderTheMouse()
			{
				return lastGOUnderTheMouse;
			}
		
		public void process(int action, Object value)
			{
				segments.process(action, value);
			}
		
		public void processSelected(int action, Object value)
			{
				segments.processSelected(action, value);
			}
		
		private GraphicObject	currentGOUnderTheMouse	= null;
		private GraphicObject	lastGOUnderTheMouse				= null;
		
	}

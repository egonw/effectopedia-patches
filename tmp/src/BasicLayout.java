package org.qsari.effectopedia.go.Layout;

import java.util.ListIterator;

import org.qsari.effectopedia.go.Details;
import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.IOPorts;
import org.qsari.effectopedia.go.ProcessableGO;
import org.qsari.effectopedia.go.containers.GraphicObjectsContainer;
import org.qsari.effectopedia.go.pathway_elements.PathwayElementGO;
import org.qsari.effectopedia.go.pathway_elements.TestCPEGO;

/**
 * @version 1.0 @(#)BasicLayout.java 1.0
 * @author Hristo Aladjov
 * 
 */

public class BasicLayout
	{
		
		public BasicLayout(GraphicObjectsContainer segments, GraphicObjectsContainer arcs)
			{
				this.segments = segments;
				this.arcs = arcs;
				objectSizes = new IndexedGOSizes(true);
				scale = new Scale();
				objectSizes.scale(scale);
			}
		
		public void reposition()
			{
				int xOffset = 0;
				for (ListIterator<GraphicObject> segmentIterator = segments.getList().listIterator(); segmentIterator.hasNext();)
					{
						SegmentGO currentSegment = (SegmentGO) segmentIterator.next();
						GraphicObjectsContainer currentComponents = currentSegment.getComponents();
						int yOffset = 0;
						for (ListIterator<GraphicObject> objectIterator = currentComponents.getList().listIterator(); objectIterator.hasNext();)
							{
								PathwayElementGO currentIGObject = (PathwayElementGO) objectIterator.next();
								currentIGObject.setX(xOffset + objectSizes.estimateHGap(currentIGObject.getClass()));
								currentIGObject.setX(yOffset);
								objectSizes.resizeGO(currentIGObject);
								yOffset += objectSizes.estimateTotalHeight(currentIGObject.getClass());
							}
					}
			}
		
		public void addGO(GraphicObject o, SegmentGO segment, int y)
			{
				GraphicObjectsContainer components = segment.getComponents();
				int maxY = components.maxY();
				if (y > maxY)
					{// add the component at the bottom
						o.setX(segment.getX() + ((o instanceof TestCPEGO) ? 2 : 1) * objectSizes.estimateHGap(o.getClass()));
						o.setY(y);
						objectSizes.resizeGO(o);
						o.setDetails(scale.getDetails());
						segment.addComponent(o);
					}
				else
					{// insert the component before the one under y
						int index = components.lastIndexBeforeY(y);
						int yOffset = (index == -1) ? getDefaultIntialSegmentOffset(segment) : components.getGrapicObject(index).getBottomY();
						GraphicObject next = components.getGrapicObject(index + 1);
						int yNext = (next == null) ? segment.getHeight() : next.getY();
						int totalHeight = objectSizes.estimateTotalHeight(o.getClass());
						o.setX(segment.getX() + ((o instanceof TestCPEGO) ? 2 : 1) * objectSizes.estimateHGap(o.getClass()));
						objectSizes.resizeGO(o);
						o.setDetails(scale.getDetails());
						if (yNext - yOffset < totalHeight)
							{
								o.setY(yOffset + 2 * objectSizes.estimateVGap(o.getClass()));
								components.processAfterIndex(ProcessableGO.VERTICAL_SHIFT, -totalHeight, index + 1);
							}
						else
							{
								o.setY(y);
								if (y + totalHeight >= yNext)
									components.processAfterIndex(ProcessableGO.VERTICAL_SHIFT, yNext - totalHeight - y, index + 1);
							}
						segment.insertComponent(o, index + 1);
					}
			}
		
		public void zoomDetails(boolean zoomIn)
			{
				
			}
		
		/*
		 * Distribute objects (IndexedGO) in the pathway space using baseline segments
		 * and baseline objects. Baseline objects are the objects that after
		 * distribution would have the smallest possible verticalTension in their
		 * ports. Objects above and below them in a segment are processed in the order
		 * of their remoteness. Normally the baseline objects are chosen to lay on the
		 * path from the chemical to the outcome of interest. The baseline segment is
		 * the first to be processed and then objects in the up and downstream
		 * segments are adjusted according to the positions of the connected objects
		 * in the baseline segment.
		 */

		public void distribute()
			{
				for (ListIterator<GraphicObject> segmentIterator = segments.getList().listIterator(segments.getBaseIndex()); segmentIterator.hasPrevious();)
					{// distribute objects in the segments before the base segment
						SegmentGO currentSegment = (SegmentGO) segmentIterator.previous();
						
						PathwayElementGO baseIGObject = (PathwayElementGO) currentSegment.getComponents().getBaseObject();
						//System.out.println(currentSegment.getSegmentIndex()+"->object"+baseIGObject.getClass().getCanonicalName()+" with id "+baseIGObject.getO().getIDandExternalID());
						int vGap = objectSizes.estimateVGap(baseIGObject.getClass()); 
						int baseY = baseIGObject.getInPort().getY();
						int initialOffset = baseIGObject.getInPort().getConnectedPorts().distribute(baseY,vGap);
						GraphicObjectsContainer currentComponents = currentSegment.getComponents();
						int baseIndex = currentComponents.getBaseIndex();
						
						int offset = baseY - initialOffset;
						if (baseIndex - 1 >= 0)
							for (ListIterator<GraphicObject> objectIterator = currentComponents.getList().listIterator(baseIndex - 1); objectIterator.hasPrevious();)
								{// distribute objects above the base object
									PathwayElementGO currentIGObject = (PathwayElementGO) objectIterator.previous();
									offset = currentIGObject.getInPort().getConnectedPorts().distribute(offset, IOPorts.Skew.UP, currentIGObject.getInPort().getY(),vGap);
								}
						
						offset = baseY + initialOffset;
						if (baseIndex + 1 < currentComponents.getList().size())
							for (ListIterator<GraphicObject> objectIterator = currentComponents.getList().listIterator(baseIndex + 1); objectIterator.hasNext();)
								{// distribute objects below the base object
									PathwayElementGO currentIGObject = (PathwayElementGO) objectIterator.next();
									offset = currentIGObject.getInPort().getConnectedPorts().distribute(offset, IOPorts.Skew.DOWN, currentIGObject.getInPort().getY(),vGap);
								}
					}
				/*
				 * for (ListIterator<GraphicObject> segmentIterator =
				 * segments.getList().listIterator(segments.getBaseIndex() + 1);
				 * segmentIterator.hasNext();) {// distribute objects in the segments after
				 * the base segment SegmentGO currentSegment = (SegmentGO)
				 * segmentIterator.next();
				 * 
				 * IndexedGO baseIGObject = (IndexedGO)
				 * currentSegment.getComponents().getBaseObject();
				 * 
				 * int baseY = baseIGObject.outPort.getY(); int initialOffset =
				 * baseIGObject.outPort.getConnectedPorts().distribute(baseY);
				 * GraphicObjects currentComponents = currentSegment.getComponents(); int
				 * baseIndex = currentComponents.getBaseIndex();
				 * 
				 * int offset = baseY - initialOffset; if (baseIndex - 1 >= 0) for
				 * (ListIterator<GraphicObject> objectIterator =
				 * currentComponents.getList().listIterator(baseIndex - 1);
				 * objectIterator.hasPrevious();) {// distribute objects above the base
				 * object IndexedGO currentIGObject = (IndexedGO) objectIterator.previous();
				 * offset = currentIGObject.outPort.getConnectedPorts().distribute(offset,
				 * IOPorts.Skew.UP, currentIGObject.outPort.getY()); }
				 * 
				 * offset = baseY + initialOffset; if (baseIndex + 1 <
				 * currentComponents.getList().size()) for (ListIterator<GraphicObject>
				 * objectIterator = currentComponents.getList().listIterator(baseIndex + 1);
				 * objectIterator.hasNext();) {// distribute objects below the base object
				 * IndexedGO currentIGObject = (IndexedGO) objectIterator.next(); offset =
				 * currentIGObject.outPort.getConnectedPorts().distribute(offset,
				 * IOPorts.Skew.DOWN, currentIGObject.outPort.getY()); } }
				 */
			}
		
		public IndexedGOSizes getDimensions()
			{
				return this.objectSizes;
			}
		
		public Scale.Details getDetails()
			{
				return scale.getDetails();
			}
		
		public void setDetails(Scale.Details details)
			{
				this.scale.setDetails(details);
			}
		
		public void zoom(boolean in)
			{
				scale.zoom(in);
				objectSizes.scale(scale);
				rescale();
			}
		
		public void resetZoom()
			{
				scale.setLevel(Scale.ZOOM_BASE_LEVEL);
				objectSizes.scale(scale);
				rescale();
			}
		
		public int getDefaultIntialSegmentOffset(SegmentGO segment)
			{
				return 20;
			}
		
		public void rescale()
			{
				int offset = 0;
				int maxHeight = 0;
				for (ListIterator<GraphicObject> segmentIterator = segments.getList().listIterator(); segmentIterator.hasNext();)
					{
						SegmentGO currentSegment = (SegmentGO) segmentIterator.next();
						GraphicObjectsContainer currentComponents = currentSegment.getComponents();
						currentSegment.setX(offset);
						int y_offset = getDefaultIntialSegmentOffset(currentSegment);
						int maxWidth = getDimensions().estimateTotalWidth(currentSegment.allows);
						for (ListIterator<GraphicObject> objectIterator = currentComponents.getList().listIterator(); objectIterator.hasNext();)
							{
								PathwayElementGO currentIGObject = (PathwayElementGO) objectIterator.next();
								currentIGObject.setX(currentSegment.getX() + ((currentIGObject instanceof TestCPEGO) ? 2 : 1) * objectSizes.estimateHGap(currentIGObject.getClass()));
								currentIGObject.setY(y_offset);
								currentIGObject.setDetails(scale.getDetails());
								objectSizes.resizeGO(currentIGObject);
								y_offset += objectSizes.estimateTotalHeight(currentIGObject.getClass());
								int currentIIGOWidth = objectSizes.estimateTotalWidth(currentIGObject.getClass());
								if (currentIIGOWidth > maxWidth)
									maxWidth = currentIIGOWidth;
							}
						currentSegment.setWidth(maxWidth);
						currentSegment.setDetails(scale.getDetails());
						offset += currentSegment.getWidth();
						if (y_offset > maxHeight)
							maxHeight = y_offset;
					}
				
				maxHeight = Math.max(maxHeight+20,1024);
				for (ListIterator<GraphicObject> segmentIterator = segments.getList().listIterator(); segmentIterator.hasNext();)
					{
						SegmentGO currentSegment = (SegmentGO) segmentIterator.next();
						currentSegment.setHeight(maxHeight);
					}
	   
	//			distribute();

				GOSynchronizer goSynchronizer = segments.getSynchronizer();
				if (goSynchronizer != null)
					goSynchronizer.synchronize(segments, GOSynchronizer.SYNCHRONIZE_XWD);
			}
		
		protected IndexedGOSizes							objectSizes;
		protected Scale																scale;
		protected final GraphicObjectsContainer	segments;
		protected final GraphicObjectsContainer	arcs;
	}

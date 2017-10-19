package org.qsari.effectopedia.go.Layout;

import java.awt.Graphics2D;

import org.qsari.effectopedia.go.SVGExportable;
import org.qsari.effectopedia.go.Layout.GlobalLayoutContainer.LayoutChangeListener;
import org.qsari.effectopedia.go.containers.ArcsContainer;
import org.qsari.effectopedia.go.containers.GraphicObjectsContainer;

/**
 * @version 1.5 @(#)BasicLayout.java 1.5
 * @author Hristo Aladjov
 * 
 */

public class BasicLayout implements SVGExportable
	{
		
		public BasicLayout()
			{
				super();
				globalLOC = new GlobalLayoutContainer(null);
				globalGOC = new GraphicObjectsContainer(null);
				globalLOC.setGo(globalGOC);
				arcs = new ArcsContainer(null);
				scale = new Scale();
			}
			
		public void zoom(boolean zoomIn)
			{
				scale.zoom(zoomIn);
				globalLOC.rescale(scale);
				update();
			}
			
		public void zoom()
			{
				globalLOC.rescale(scale);
				update();
			}
			
		public int getWidth()
			{
				return globalLOC.getWidth();
			}
			
		public int getHeight()
			{
				return globalLOC.getHeight();
			}
			
		public void draw(Graphics2D canvas)
			{
				// buffer = new BufferedImage(globalLOC.getWidth(),
				// globalLOC.getHeight(),BufferedImage.TYPE_3BYTE_BGR );
				// Graphics2D c = buffer.createGraphics();
				// c.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				// RenderingHints.VALUE_ANTIALIAS_OFF);
				globalGOC.draw(canvas);
				arcs.setBounds(globalGOC);
				arcs.draw(canvas);
				// c.dispose();
				// canvas.drawImage(buffer, 0,0,null);
				
			}
			
		public void exportToSVG(StringBuilder base, StringBuilder pathwayElementGroup)
			{
				globalGOC.exportToSVG(base, pathwayElementGroup);
				arcs.setBounds(globalGOC);
				pathwayElementGroup.append("<g id=\"Arcs\">\n");
				arcs.exportToSVG(base, pathwayElementGroup);
				pathwayElementGroup.append("</g>\n");
			}
			
		public Scale getScale()
			{
				return scale;
			}
			
		public GlobalLayoutContainer getGlobalLOC()
			{
				return globalLOC;
			}
			
		public GraphicObjectsContainer getGlobalGOC()
			{
				return globalGOC;
			}
			
		public ArcsContainer getArcs()
			{
				return arcs;
			}
			
		public void update()
			{
				globalLOC.update();
				updateLOCAligment();
				globalLOC.distribute(horizontalSegmentAlignment, verticalSegmentAlignment);
			}
			
		public void updateLOCAligment()
			{
				globalLOC.setHorizontalElementsAlignment(horizontalSegmentAlignment);
				globalLOC.setVerticalElementsAlignment(verticalSegmentAlignment);
				globalLOC.setContainerComponentsAligment(horizontalElementAlignment, verticalElementAlignment);
			}
			
		public HorizontalAlignment getHorizontalElementAlignment()
			{
				return horizontalElementAlignment;
			}
			
		public void setHorizontalElementAlignment(HorizontalAlignment horizontalElementAlignment)
			{
				this.horizontalElementAlignment = horizontalElementAlignment;
			}
			
		public VerticalAlignment getVerticalElementAlignment()
			{
				return verticalElementAlignment;
			}
			
		public void setVerticalElementAlignment(VerticalAlignment verticalElementAlignment)
			{
				this.verticalElementAlignment = verticalElementAlignment;
			}
			
		public void setArcsSelectable(boolean selectable)
			{
				arcs.setSelectable(selectable, true);
			}
			
		public void addLayoutChangeListener(LayoutChangeListener listener)
			{
				globalLOC.addLayoutChangeListener(listener);
			}
			
		public void removeLayoutChangeListener(LayoutChangeListener listener)
			{
				globalLOC.removeLayoutChangeListener(listener);
			}
			
		// private BufferedImage buffer;
		protected Scale																									scale;
		protected final GlobalLayoutContainer			globalLOC;
		protected final GraphicObjectsContainer	globalGOC;
		protected final ArcsContainer											arcs;
		protected HorizontalAlignment											horizontalSegmentAlignment	= HorizontalAlignment.GAPLESSFILL;
		protected VerticalAlignment													verticalSegmentAlignment			= VerticalAlignment.GAPLESSFILL;
		protected HorizontalAlignment											horizontalElementAlignment	= HorizontalAlignment.CENTER;
		protected VerticalAlignment													verticalElementAlignment			= VerticalAlignment.MIDDLE;
	}

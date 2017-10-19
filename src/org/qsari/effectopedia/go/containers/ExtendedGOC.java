package org.qsari.effectopedia.go.containers;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.ListIterator;

import org.qsari.effectopedia.go.GraphicObject;

public class ExtendedGOC extends BasicGOC
	{
		public static final int	DEFAULT_GRID_STEP	= 0x0008;
		
		public ExtendedGOC()
			{
				super();
			}
		
		public ExtendedGOC(GraphicObject parent)
			{
				super(parent);
			}
		
		public boolean isGridVisible()
			{
				return gridVisible;
			}
		
		public void setGridVisible(boolean gridVisible)
			{
				this.gridVisible = gridVisible;
			}
		
		public boolean isBackgorundVisible()
			{
				return backgorundVisible;
			}
		
		public void setBackgorundVisible(boolean backgorundVisible)
			{
				this.backgorundVisible = backgorundVisible;
			}
		
		public boolean isBorderVisible()
			{
				return borderVisible;
			}
		
		public void setBorderVisible(boolean borderVisible)
			{
				this.borderVisible = borderVisible;
			}
		
		public Color getBorderColor()
			{
				return borderColor;
			}
		
		public void setBorderColor(Color borderColor)
			{
				this.borderColor = borderColor;
			}
		
		public int getGridStep()
			{
				return gridStep;
			}
		
		public void setGridStep(int gridStep)
			{
				this.gridStep = gridStep;
			}
		
		private void drawGrid(Graphics2D onCanvas)
			{
				if ((width < 1) || (height < 1))
					return;
				if ((buffer == null) || (buffer.getWidth() < (width - 1)) || (buffer.getHeight() < (height - 1)))
					generateGridBuffer(2 * width, 2 * height, gridStep, background);
				onCanvas.drawImage(buffer, null, x, y);
			}
		
		private void generateGridBuffer(int width, int height, int gridStep, Color background)
			{
				buffer = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
				Graphics2D big = buffer.createGraphics();
				big.setColor(background);
				big.fillRect(0, 0, width, height);
				big.dispose();
				int xCount = (width) / gridStep;
				int yCount = (height) / gridStep;
				for (int i = 1; i < xCount; i++)
					for (int j = 0; j < yCount; j++)
						{
							buffer.setRGB(i * gridStep, j * gridStep, 0xAAAAAA);
						}
			}
		
		public void drawSelf(Graphics2D onCanvas)
			{
				if (gridVisible)
					drawGrid(onCanvas);
				else if (backgorundVisible)
					{
						onCanvas.setColor(background);
						onCanvas.fillRect(x, y, width, height);
					}
				if (borderVisible)
					{
						onCanvas.setColor(borderColor);
						BasicStroke pen = new BasicStroke(1.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
						onCanvas.setStroke(pen);
						onCanvas.drawRoundRect(x, y, width - 1, height - 1, 8, 16);
					}
				if (activeLayer != null)
					activeLayer.draw(onCanvas);
			}
		
		public void exportStyle(StringBuilder sb)
			{
				sb.append(" style=\"");
				if (gridVisible)
					sb.append("fill: url(#grid_pattern)");
				else
					{
						sb.append("fill:#");
						sb.append(Integer.toHexString(background.getRGB()).substring(2));
					}
				sb.append(";stroke:#");
				sb.append(Integer.toHexString(color.getRGB()).substring(2));
				sb.append(";stroke-width:1;");
				sb.append("\"");
			}
		
		public void exportSelfToSVG(StringBuilder sb)
			{
				if (gridVisible)
					{
						sb.append("<rect");
						exportDimensions(sb);
						sb.append(" rx=\"8\" ry=\"16\"");
						if (gridVisible)
							exportStyle(sb);
						else
							exportPresentationAttributes(sb);
						sb.append("/>\n");
					}
			}
		
		public GraphicObject getActiveLayer()
			{
				return activeLayer;
			}
		
		public void setActiveLayer(GraphicObject activeLayer)
			{
				this.activeLayer = activeLayer;
				if (activeLayer != null)
					activeLayer.setBounds(this);
			}
		
		public void resetActiveLayer()
			{
				this.activeLayer = null;
				for (ListIterator<GraphicObject> iterator = list.listIterator(); iterator.hasNext();)
					{
						GraphicObject go = iterator.next();
						if (go instanceof ExtendedGOC)
							((ExtendedGOC) go).resetActiveLayer();
					}
			}
		
		public static void resetActiveLayer(GraphicObjectsContainer goc)
			{
				Iterator<GraphicObject> it = goc.getComponentsIterator();
				while (it.hasNext())
					{
						GraphicObject go = it.next();
						if (go instanceof ExtendedGOC)
							((ExtendedGOC) go).resetActiveLayer();
					}
			}
		
		protected GraphicObject	activeLayer							= null;
		private boolean									gridVisible							= true;
		private boolean									backgorundVisible	= true;
		private boolean									borderVisible					= true;
		protected Color									borderColor							= DEFAULT_COLOR;
		private BufferedImage			buffer;
		private int													gridStep										= DEFAULT_GRID_STEP;
	}

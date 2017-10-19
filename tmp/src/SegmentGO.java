package org.qsari.effectopedia.go;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.Layout.Details;

public class SegmentGO extends GraphicObject
	{
		public static final int	DEFAULT_GRID_STEP	= 0x0008;
		public static final int	PREFERED_H_INSET		= 0x0010;
		public static final int	PREFERED_V_INSET		= 0x0010;
		
		public SegmentGO(int segmentIndex, Class<? extends GraphicObject> allows)
			{
				super();
				this.allows = allows;
				this.segmentIndex = segmentIndex;
				components = new GraphicObjects();
			}
		
		public GraphicObjects getComponents()
			{
				return components;
			}
		
		public void draw(Graphics2D onCanvas)
			{
				if (onCanvas.hitClip(x, y, width, height))
					{
						if (showGrid)
							{
								drawGrid(onCanvas);
							}
						else
							{
								onCanvas.setColor(color);
								onCanvas.fillRect(x, y, width, height);
							}
						drawBounds(onCanvas);
						components.drawAll(onCanvas);
					}
			}
		
		private void drawGrid(Graphics2D onCanvas)
			{
				if ((width == 0) || (height == 0))
					return;
				int xCount = width / gridStep;
				int yCount = height / gridStep;
				BufferedImage buffer = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
				Graphics2D big = buffer.createGraphics();
				big.setColor(background);
				big.fillRect(0, 0, width, height);
				big.dispose();
				for (int i = 1; i < xCount; i++)
					for (int j = 0; j < yCount; j++)
						{
							buffer.setRGB(i * gridStep, j * gridStep, 0xAAAAAA);
						}
				onCanvas.drawImage(buffer, null, x, y);
			}
		
		private void drawBounds(Graphics2D onCanvas)
			{
				onCanvas.setColor(DefaultGOSettings.segmentBoundsColor);
				BasicStroke pen = new BasicStroke(1.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
				onCanvas.setStroke(pen);
				onCanvas.drawRoundRect(x, y, width, height, 8, 16);
			}
		
		public boolean isColapsed()
			{
				return colapsed;
			}
		
		public void setColapsed(boolean colapsed)
			{
				this.colapsed = colapsed;
			}
		
		public boolean isShowGrid()
			{
				return showGrid;
			}
		
		public void setShowGrid(boolean showGrid)
			{
				this.showGrid = showGrid;
			}
		
		public int getGridStep()
			{
				return gridStep;
			}
		
		public void setGridStep(int gridStep)
			{
				this.gridStep = gridStep;
			}
		
		public static int getHInset()
			{
				return hInset;
			}
		
		public static void setHInset(int inset)
			{
				hInset = inset;
			}
		
		public static int getVInset()
			{
				return vInset;
			}
		
		public static void setVInset(int inset)
			{
				vInset = inset;
			}
		
		public GraphicObject isOver(int x, int y)
			{
				GraphicObject go = null;
				active = (this.x < x) && (this.y < y) && (this.x + width > x) && (this.y + height > y);
				if (active)
					go = components.isOver(x, y);
				return (go != null) ? go : ((active) ? this : null);
			}
		
		public void setSelected(boolean selected)
			{
				this.selected = selected;
				components.setSelected(selected);
			}
		
		public void setDetails(Details details)
			{
				this.details = details;
				components.setDetails(details);
			}
		
		public int getTotalComponentsHeight()
			{
				return components.totalHeight();
			}
		
		public void addComponent(GraphicObject component)
			{
				components.add(component);
			}
		
		public void insertComponent(GraphicObject component, int index)
			{
				components.insert(component, index);
			}
		
		public boolean isAllowed(Class<? extends GraphicObject> c)
			{
				return allows.isAssignableFrom(c);
			}
		
		public void process(int action, Object value)
			{
				components.process(action, value);
			}
		
		public void processSelected(int action, Object value)
			{
				components.processSelected(action, value);
			}
		
		public void setSelected(int x, int y, int width, int height)
			{
				boolean intersected = isIntersected(x, y, width, height);
				if (selecatble)
					this.selected = intersected;
				if (intersected)
					components.setSelected(x, y, width, height);
			}
		
		public int getSegmentIndex()
			{
				return segmentIndex;
			}
		
		public void setSegmentIndex(int segmentIndex)
			{
				this.segmentIndex = segmentIndex;
			}
		
		public final Class<? extends GraphicObject>	allows;
		private GraphicObjects																						components;
		private boolean																													colapsed					= false;
		private boolean																													showGrid					= true;
		protected int																															segmentIndex	= -1;
		private int																																	gridStep					= DEFAULT_GRID_STEP;
		private static int																										hInset							= PREFERED_H_INSET;
		private static int																										vInset							= PREFERED_V_INSET;

		
		public int contains(PathwayElement pathwayElement)
			{
				ArrayList<GraphicObject> list = components.getList();
				int count = list.size();
				for (int i=0;i<count;i++)
					{
					 GraphicObject go = list.get(i);
					 if ((go instanceof PathwayElementGO)&&(((PathwayElementGO)go).getO()==pathwayElement))
						 return i;
					}	
				return -1;
			}
	}

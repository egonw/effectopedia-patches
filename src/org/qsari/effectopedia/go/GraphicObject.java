package org.qsari.effectopedia.go;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.defaults.DefaultGOSettings;

public class GraphicObject extends IndexedObject implements ProcessableGO, SVGExportable
	{
		public static final Color	DEFAULT_COLOR						= DefaultGOSettings.segmentBoundsColor;
		public static final Color	DEFAULT_BACKGROUND	= Color.WHITE;
		public static final Color	DEFAULT_SELECTED			= Color.RED;
		
		public GraphicObject()
			{
				autoSetId();
			}
			
		public GraphicObject(GraphicObject parent)
			{
				autoSetId();
				this.parent = parent;
			}
			
		public boolean isVisible()
			{
				return visible;
			}
			
		public void setVisible(boolean visible)
			{
				this.visible = visible;
			}
			
		public int getX()
			{
				return x;
			}
			
		public void setX(int x)
			{
				this.x = x;
			}
			
		public int getY()
			{
				return y;
			}
			
		public int getBottom()
			{
				return y + getHeight();
			}
			
		public void setY(int y)
			{
				this.y = y;
			}
			
		public int getWidth()
			{
				return width;
			}
			
		public int getRight()
			{
				return x + getWidth();
			}
			
		public void setWidth(int width)
			{
				this.width = width;
			}
			
		public int getHeight()
			{
				return height;
			}
			
		public void setHeight(int height)
			{
				this.height = height;
			}
			
		public int getMidY()
			{
				return this.y + (this.height >> 1);
			}
			
		public int getMidX()
			{
				return this.x + (this.width >> 1);
			}
			
		public boolean isSelectable()
			{
				return selectable;
			}
			
		public void setSelectable(boolean selecatble)
			{
				this.selectable = selecatble;
			}
			
		public boolean isSelected()
			{
				return selected;
			}
			
		public void setSelected(boolean selected)
			{
				this.selected = selected;
			}
			
		public Color getColor()
			{
				return color;
			}
			
		public void setColor(Color color)
			{
				this.color = color;
			}
			
		public Color getBackground()
			{
				return background;
			}
			
		public void setBackground(Color background)
			{
				this.background = background;
			}
			
		public boolean isActive()
			{
				return active;
			}
			
		public void setActive(boolean active)
			{
				this.active = active;
			}
			
		public void draw(Graphics2D onCanvas)
			{
				if (visible)
					{
						if (onCanvas.hitClip(x, y, width, height))
							{
								onCanvas.setColor(color);
								onCanvas.setBackground(background);
								onCanvas.fillRect(x, y, width, height);
							}
					}
			}
			
		public void exportDimensions(StringBuilder sb)
			{
				SVGUtils.addDualParamaterQuatedValuePair(sb, "x", x, "y", y);
				SVGUtils.addDualParamaterQuatedValuePair(sb, "width", width, "height", height);
			}
			
		public void exportPresentationAttributes(StringBuilder sb)
			{
				SVGUtils.addParamaterQuatedValuePair(sb, "stroke", getColor());
				SVGUtils.addParamaterQuatedValuePair(sb, "fill", getBackground());
				SVGUtils.addParamaterQuatedValuePair(sb, "stroke-width", 2);
			}
			
		public void exportStyle(StringBuilder sb)
			{
				SVGUtils.addParamaterValuePair(sb, "stroke", getColor());
				SVGUtils.addParamaterValuePair(sb, "fill", getBackground());
				SVGUtils.addParamaterValuePair(sb, "stroke-width", 2);
			}
			
		public void exportToSVG(StringBuilder base, StringBuilder pathwayElementsGroup)
			{
				if (visible)
					{
						base.append("<rect");
						exportDimensions(base);
						exportPresentationAttributes(base);
						base.append("/>\n");
					}
			}
			
		public boolean isIntersected(int xR, int yR, int widthR, int heightR)
			{
				return !((x > xR + widthR) || (x + width < xR) || (y > yR + heightR) || (y + height < yR));
			}
			
		public boolean isInside(int x, int y)
			{
				return (this.x < x) && (this.y < y) && (this.x + width > x) && (this.y + height > y);
			}
			
		public void setSelected(int x, int y, int width, int height)
			{
				setSelected(isIntersected(x, y, width, height));
			}
			
		public GraphicObject isOver(int x, int y)
			{
				active = (this.x < x) && (this.y < y) && (this.x + width > x) && (this.y + height > y);
				return (active) ? this : null;
			}
			
		public void process(int action, Object value)
			{
				if ((VERTICAL_SHIFT & action) != 0)
					setY(getY() - ((Integer) value).intValue());
				if ((HORIZONTAL_SHIFT & action) != 0)
					setX(getX() - ((Integer) value).intValue());
			}
			
		public void processSelected(int action, Object value)
			{
				if (selected)
					process(action, value);
			}
			
		public void setBounds(GraphicObject go)
			{
				if (go != null)
					{
						setX(go.getX());
						setY(go.getY());
						setWidth(go.getWidth());
						setHeight(go.getHeight());
					}
			}
			
		public void setBounds(int x, int y, int width, int height)
			{
				setX(x);
				setY(y);
				setWidth(width);
				setHeight(height);
			}
			
		public void setBounds(Rectangle r)
			{
				setX(r.x);
				setY(r.y);
				setWidth(r.width);
				setHeight(r.height);
			}
			
		public Rectangle getBounds()
			{
				return new Rectangle(x, y, width, height);
			}
			
		public long autoId()
			{
				return graphicObjectIDs++;
			}
			
		public StandardGOSize getStandardSize()
			{
				return defaultUnscalledSize;
			}
			
		public static void setStandardSize(StandardGOSize newGOSize)
			{
				defaultUnscalledSize = newGOSize;
			}
			
		public void update()
			{
			}
			
		public boolean isTemporary()
			{
				return temporary;
			}
			
		public void setTemporary(boolean temporary)
			{
				this.temporary = temporary;
			}
			
		protected int																x;
		protected int																y;
		protected int																width																= defaultUnscalledSize.getWidth();
		protected int																height															= defaultUnscalledSize.getHeight();
		protected boolean												visible														= true;
		protected boolean												selectable											= true;
		protected boolean												selected													= false;
		protected boolean												active															= false;
		protected boolean												temporary												= false;
		
		protected Color														color																= DEFAULT_COLOR;
		protected Color														background											= DEFAULT_BACKGROUND;
		
		protected GraphicObject						parent;
		
		public static StandardGOSize	defaultUnscalledSize	= new StandardGOSize(0F, 0F);
		
		protected static long								graphicObjectIDs					= 0;
	}

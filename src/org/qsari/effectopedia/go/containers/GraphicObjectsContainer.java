package org.qsari.effectopedia.go.containers;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.ProcessableGO;

public class GraphicObjectsContainer extends GraphicObject implements ProcessableGO
	{
		
		public GraphicObjectsContainer()
			{
				super();
				list = new ArrayList<GraphicObject>();
			}
		
		public GraphicObjectsContainer(GraphicObject parent)
			{
				super(parent);
				list = new ArrayList<GraphicObject>();
			}
		
		public ArrayList<GraphicObject> getList()
			{
				return list;
			}
		
		public void setList(ArrayList<GraphicObject> list)
			{
				this.list = list;
				count = list.size();
			}
		
		public void add(GraphicObject gObject)
			{
				list.add(gObject);
				count++;
			}
		
		public void insert(GraphicObject gObject, int index)
			{
				list.add(index, gObject);
				count++;
			}
		
		public void delete(int index)
			{
				list.remove(index);
				count--;
			}
		
		public void delete(GraphicObject gObject)
			{
				list.remove(gObject);
				count--;
			}
		
		public void clear()
			{
				list.clear();
				count = 0;
			}
		
		public int getCount()
			{
				return count;
			}
		
		public void draw(Graphics2D onCanvas)
			{
				if (visible)
					{
						if (onCanvas.hitClip(x, y, width, height))
							{
								for (ListIterator<GraphicObject> iterator = list.listIterator(); iterator.hasNext();)
									iterator.next().draw(onCanvas);
							}
					}
			}

		
		public void exportSelfToSVG(StringBuilder sb)
			{
			}
		
		public void exportToSVG(StringBuilder base,StringBuilder pathwayElementsGroup)
			{
				if (visible)
					{
						exportSelfToSVG(base);
						for (ListIterator<GraphicObject> iterator = list.listIterator(); iterator.hasNext();)
							iterator.next().exportToSVG(base,pathwayElementsGroup);
					}
			}
		
		public GraphicObject isOver(MouseEvent evt)
			{
				return isOver(evt.getX(), evt.getY());
			}
		
		public GraphicObject isOver(int x, int y)
			{
				active = (this.x < x) && (this.y < y) && (this.x + width > x) && (this.y + height > y);
				if (active)
					{
						ListIterator<GraphicObject> iterator = list.listIterator();
						lastGO = currentGO;
						currentGO = null;
						while ((currentGO == null) && iterator.hasNext())
							currentGO = iterator.next().isOver(x, y);
						return (currentGO == null) ? this : currentGO;
					}
				return null;
			}
		
		public void setSelected(int x, int y, int width, int height)
			{
				setSelected(isIntersected(x, y, width, height));
				for (ListIterator<GraphicObject> iterator = list.listIterator(); iterator.hasNext();)
					iterator.next().setSelected(x, y, width, height);
			}
		
		public GraphicObject get(int index)
			{
				return list.get(index);
			}
		
		public GraphicObject getCurrentGO()
			{
				return currentGO;
			}
		
		public GraphicObject getLastGO()
			{
				return lastGO;
			}
		
		public void updatePositionsAndWidths(ArrayList<Integer> widths)
			{
				int widthsCnt = widths.size();
				int objectsCnt = list.size();
				if ((widthsCnt > 0) && (widthsCnt <= objectsCnt))
					{
						int rows = objectsCnt / widthsCnt;
						int cnt = 0;
						for (int row = 0; row < rows; row++)
							{
								int xOffset = 0;
								for (int column = 0; column < widthsCnt; column++)
									{
										int currentWidth = widths.get(column);
										GraphicObject go = list.get(cnt);
										if (go != null)
											{
												go.setWidth(currentWidth);
												go.setX(xOffset);
											}
										xOffset += currentWidth;
										cnt++;
									}
							}
					}
			}
		
		public void updatePositionsAndHeights(ArrayList<Integer> Heights)
			{
				int HeightsCnt = Heights.size();
				int objectsCnt = list.size();
				if ((HeightsCnt > 0) && (HeightsCnt <= objectsCnt))
					{
						int columns = objectsCnt / HeightsCnt;
						int cnt = 0;
						int yOffset = 0;
						for (int row = 0; row < HeightsCnt; row++)
							{
								int currentHeight = Heights.get(row);
								for (int column = 0; column < columns; column++)
									{
										GraphicObject go = list.get(cnt);
										if (go != null)
											{
												go.setHeight(currentHeight);
												go.setY(yOffset);
											}
										cnt++;
									}
								yOffset += currentHeight;
							}
					}
			}
		
		public void update()
			{
				for (ListIterator<GraphicObject> iterator = list.listIterator(); iterator.hasNext();)
					iterator.next().update();
			}
		
		public Iterator<GraphicObject> getComponentsIterator()
			{
				return list.iterator();
			}
		
		public void setSelectable(boolean selectable, boolean updateComponents)
			{
				setSelectable(selectable);
				if (updateComponents)
					for (ListIterator<GraphicObject> iterator = list.listIterator(); iterator.hasNext();)
						iterator.next().setSelectable(selectable);
			}
		
		protected ArrayList<GraphicObject>	list;
		protected int																						count					= 0;
		protected GraphicObject												currentGO	= null;
		protected GraphicObject												lastGO				= null;
		
	}

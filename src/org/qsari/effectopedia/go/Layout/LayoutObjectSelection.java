package org.qsari.effectopedia.go.Layout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.pathway_elements.PathwayElementGO;

public class LayoutObjectSelection
	{
		public LayoutObjectSelection()
			{
				super();
				selection = new ArrayList<LayoutObject>();
			}
		
		public void select(LayoutObject lo)
			{
				if (lo != null)
					lo.getGo().setSelected(true);
				selection.add(lo);
			}
		
		public void select(LayoutObjectsContainer container, int x, int y, int width, int height)
			{
				GraphicObject go = container.getGo();
				if ((go != null) && (go.isIntersected(x, y, width, height)))
					{
						Iterator<LayoutObject> it = container.getComponentsIterator();
						while (it.hasNext())
							{
								LayoutObject lo = it.next();
								if (lo != null)
									{
										if (lo instanceof LayoutObjectsContainer)
											select((LayoutObjectsContainer) lo, x, y, width, height);
										else
											{
												boolean s = lo.getGo().isIntersected(x, y, width, height);
												lo.getGo().setSelected(s);
												if (s)
													selection.add(lo);
											}
									}
							}
					}
			}
		
		public void select(Map<PathwayElement, LayoutObject> map, LayoutObject upstream, LayoutObject downstream)
			{
				if ((upstream == null) || (downstream == null))
					return;
				PathwayElement ue = ((PathwayElementGO) upstream.getGo()).getO();
				PathwayElement de = ((PathwayElementGO) downstream.getGo()).getO();
				PathwayElement elements[] = Pathway.getPathElements(ue, de);
				if (elements == null)
					return;
				for (int i = elements.length - 1; i >= 0; i--)
					{
						LayoutObject lo = map.get(elements[i]);
						if (lo != null)
							{
								lo.getGo().setSelected(true);
								selection.add(lo);
							}
					}
			}
		
		public void select(LayoutObjectsContainer container)
			{
				Iterator<LayoutObject> it = container.getComponentsIterator();
				while (it.hasNext())
					{
						LayoutObject lo = it.next();
						if (lo != null)
							{
								if (lo instanceof LayoutObjectsContainer)
									select((LayoutObjectsContainer) lo);
								else
									{
										lo.getGo().setSelected(true);
										selection.add(lo);
									}
							}
					}
			}
		
		public void unselect(LayoutObjectsContainer container)
			{
				Iterator<LayoutObject> it = container.getComponentsIterator();
				while (it.hasNext())
					{
						LayoutObject lo = it.next();
						if (lo != null)
							{
								if (lo instanceof LayoutObjectsContainer)
									unselect((LayoutObjectsContainer) lo);
								else
									{
										lo.getGo().setSelected(false);
										selection.remove(lo);
									}
							}
					}
			}
		
		public void unselect(LayoutObject lo)
			{
				if (lo != null)
					lo.getGo().setSelected(false);
				selection.remove(lo);
			}
		
		public Iterator<LayoutObject> getSelectionIterator()
			{
				return selection.iterator();
			}
		
		public void clear()
			{
				Iterator<LayoutObject> it = selection.iterator();
				while (it.hasNext())
					{
						LayoutObject lo = it.next();
						if (lo != null)
							lo.getGo().setSelected(false);
					}
				selection.clear();
			}

		public int size()
			{
				return selection.size();
			}
		
		protected ArrayList<LayoutObject>	selection;
	}

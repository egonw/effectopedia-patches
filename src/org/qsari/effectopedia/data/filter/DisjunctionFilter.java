package org.qsari.effectopedia.data.filter;

import java.util.ArrayList;

import org.qsari.effectopedia.core.objects.PathwayElement;

public class DisjunctionFilter extends BasicFilter
	{
		public DisjunctionFilter(String caption)
			{
				super(caption);
				filters = new ArrayList<BasicFilter>();
			}
		
		public void generateCaption()
			{
				StringBuilder newCaption = new StringBuilder();
				newCaption.append("OR(");
				for (BasicFilter f : filters)
					{
						newCaption.append(f.getCaption());
						newCaption.append(",");
					}
				newCaption.replace(newCaption.length()-1, newCaption.length(), ")");
				caption = newCaption.toString();
			}
		
		public PathwayElement[] filter(PathwayElement elements[])
			{
				if (elements != null)
					{
						ArrayList<PathwayElement> filtered = new ArrayList<PathwayElement>();
						for (int i = elements.length - 1; i >= 0; i--)
							for (BasicFilter f : filters)
								if (f.filter(elements[i]))
									{
										filtered.add(elements[i]);
										break;
									}
						return filtered.toArray(new PathwayElement[filtered.size()]);
					}
				else
					return elements;
			}
		
		public boolean filter(PathwayElement element)
			{
				for (BasicFilter f : filters)
					if (f.filter(element))
						return true;
				return false;
			}
		
		public void add(BasicFilter filter)
			{
				filters.add(filter);
			}
		
		public void remove(BasicFilter filter)
			{
				filters.remove(filter);
			}
		
		public void clear()
			{
				filters.clear();
			}
		
		protected ArrayList<BasicFilter>	filters;

	}

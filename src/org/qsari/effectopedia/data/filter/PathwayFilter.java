package org.qsari.effectopedia.data.filter;

import java.util.ArrayList;

import org.qsari.effectopedia.core.objects.PathwayElement;

public class PathwayFilter extends BasicFilter
	{
		public static enum Criterion
			{
				IS, IS_NOT
			}
		
		public PathwayFilter(String caption, long pathwayID, PathwayFilter.Criterion criterion)
			{
				super(caption);
				this.pathwayID = pathwayID;
				this.criterion = criterion;
			}
		
		public PathwayElement[] filter(PathwayElement elements[])
			{
				if (elements != null)
					{
						ArrayList<PathwayElement> filtered = new ArrayList<PathwayElement>();
						if (criterion == Criterion.IS)
							{
								for (int i = elements.length - 1; i >= 0; i--)
									if (elements[i].belongsTo(pathwayID))
										filtered.add(elements[i]);
							}
						else // Criterion.NOT_ON pathwayID
							{
								for (int i = elements.length - 1; i >= 0; i--)
									if (!elements[i].belongsTo(pathwayID))
										filtered.add(elements[i]);
							}
						return filtered.toArray(new PathwayElement[filtered.size()]);
					}
				else
					return elements;
			}

		public boolean filter(PathwayElement element)
			{
				return (element == null)?true:(criterion == Criterion.IS)?element.belongsTo(pathwayID):!element.belongsTo(pathwayID);
			}
		
		protected long						pathwayID;
		protected Criterion	criterion;
	}

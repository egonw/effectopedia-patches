package org.qsari.effectopedia.data.filter;

import java.util.ArrayList;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.objects.PathwayElement;

public class BasicFilter
	{
		public BasicFilter()
			{
				super();
			}
		
		public BasicFilter(String caption)
			{
				super();
				this.caption = caption;
			}
		
		public EffectopediaObject[] filter(EffectopediaObject elements[])
			{
				if (elements != null)
					{
						ArrayList<EffectopediaObject> nonGeneric = new ArrayList<EffectopediaObject>();
						for (int i = elements.length - 1; i >= 0; i--)
							if (elements[i] instanceof PathwayElement)
								if (!((PathwayElement) elements[i]).isGeneric())
									nonGeneric.add(elements[i]);
						return nonGeneric.toArray(new PathwayElement[nonGeneric.size()]);
					}
				else
					return elements;
			}
		
		public boolean filter(EffectopediaObject element)
			{
				return (element != null) && (element instanceof PathwayElement) && (!((PathwayElement)element).isGeneric());
			}
		
		public String getCaption()
			{
				return caption;
			}
		
		public void setCaption(String caption)
			{
				this.caption = caption;
			}
		
		protected String	caption;
	}

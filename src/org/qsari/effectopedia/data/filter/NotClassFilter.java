package org.qsari.effectopedia.data.filter;

import java.util.ArrayList;

import org.qsari.effectopedia.base.EffectopediaObject;

public class NotClassFilter extends ClassFilter
	{
		
		public NotClassFilter(String caption, Class<? extends EffectopediaObject> elementsClass)
		{
			super(caption, elementsClass);
		}

		@Override
		public EffectopediaObject[] filter(EffectopediaObject elements[])
			{
				if (elements != null)
					{
						ArrayList<EffectopediaObject> filtered = new ArrayList<EffectopediaObject>();
						for (int i = elements.length - 1; i >= 0; i--)
							if (!elementsClass.isAssignableFrom(elements[i].getClass()))
								filtered.add(elements[i]);
						return filtered.toArray(new EffectopediaObject[filtered.size()]);
					}
				else
					return elements;
			}

		@Override
		public boolean filter(EffectopediaObject element)
			{
				return (element != null) && (!elementsClass.isAssignableFrom(element.getClass()));
			}
		
	}

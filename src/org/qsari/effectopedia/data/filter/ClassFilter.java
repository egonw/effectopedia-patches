package org.qsari.effectopedia.data.filter;

import java.util.ArrayList;

import org.qsari.effectopedia.base.EffectopediaObject;

public class ClassFilter extends BasicFilter
	{
		public ClassFilter(String caption, Class<? extends EffectopediaObject> elementsClass)
			{
				super(caption);
				this.elementsClass = elementsClass;
			}
		
		public EffectopediaObject[] filter(EffectopediaObject elements[])
			{
				if (elements != null)
					{
						ArrayList<EffectopediaObject> filtered = new ArrayList<EffectopediaObject>();
						for (int i = elements.length - 1; i >= 0; i--)
							if (elementsClass.isAssignableFrom(elements[i].getClass()))
								filtered.add(elements[i]);
						return filtered.toArray(new EffectopediaObject[filtered.size()]);
					}
				else
					return elements;
			}
		
		public boolean filter(EffectopediaObject element)
			{
				return (element != null) && (elementsClass.isAssignableFrom(element.getClass()));
			}
		
		public final Class<? extends EffectopediaObject> getElementsClass()
			{
				return elementsClass;
			}
		
		protected Class<? extends EffectopediaObject>	elementsClass;
		
	}

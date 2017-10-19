package org.qsari.effectopedia.data.filter;

import java.util.ArrayList;

import org.qsari.effectopedia.base.EffectopediaObject;

public class DeafultObjectsFilter extends BasicFilter
	{
		public DeafultObjectsFilter()
			{
				super();
			}
		
		public DeafultObjectsFilter(String caption)
			{
				super();
				this.caption = caption;
			}
		
		public EffectopediaObject[] filter(EffectopediaObject elements[])
			{
				if (elements != null)
					{
						ArrayList<EffectopediaObject> nonDefault = new ArrayList<EffectopediaObject>();
						for (int i = elements.length - 1; i >= 0; i--)
							if (!elements[i].isDefaultID())
									nonDefault.add(elements[i]);
						return nonDefault.toArray(new EffectopediaObject[nonDefault.size()]);
					}
				else
					return elements;
			}
		
		public boolean filter(EffectopediaObject element)
			{
				return (element != null) && (element.isDefaultID());
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

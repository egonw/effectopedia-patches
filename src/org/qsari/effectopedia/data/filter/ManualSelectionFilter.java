package org.qsari.effectopedia.data.filter;

import java.util.ArrayList;
import java.util.HashSet;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;

public class ManualSelectionFilter extends BasicFilter
	{
		public static final String	DEFAULT_NAME	= "manual selection filter";


		public ManualSelectionFilter(EffectopediaObjects<?> index, boolean defaultStatus)
			{
				super(DEFAULT_NAME);
				this.index = index;
				selected = new HashSet<EffectopediaObject>();
				if (defaultStatus)
					for (EffectopediaObject eo : index.values())
						selected.add(eo);
			}
		
		public void mark(EffectopediaObject eo, boolean selected)
			{
				if (selected)
					this.selected.add(eo);
				else
					this.selected.remove(eo);
			}

		public void markAll(boolean select)
			{
				if (select)
					for (EffectopediaObject eo : index.values())
						selected.add(eo);
				else
					selected.clear();
			}

		public EffectopediaObject[] filter(EffectopediaObject elements[])
			{
				if (elements != null)
					{
						ArrayList<EffectopediaObject> filtered = new ArrayList<EffectopediaObject>();
						for (int i = elements.length - 1; i >= 0; i--)
							if (selected.contains(elements[i]))
								filtered.add(elements[i]);
						return filtered.toArray(new EffectopediaObject[filtered.size()]);
					}
				else
					return elements;
			}
		
		public boolean filter(EffectopediaObject element)
			{
				return (element != null) && (selected.contains(element));
			}
		
				
		public HashSet<EffectopediaObject> getSelected()
			{
				return selected;
			}

		
		protected EffectopediaObjects<?> index;
		protected HashSet<EffectopediaObject>	selected;
		
	}

package org.qsari.effectopedia.data.filter;

import java.util.ArrayList;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.data.interfaces.Ownable;

public class OwnerClassFilter extends ClassFilter
	{
		
		public OwnerClassFilter(String caption, Class<? extends EffectopediaObject> ownersClass)
			{
				super(caption, ownersClass);
				this.ownersClasses = new ArrayList<Class<? extends EffectopediaObject>>();
			}
		
		public OwnerClassFilter(String caption, ArrayList<Class<? extends EffectopediaObject>> ownersClasses)
			{
				super(caption, null);
				this.ownersClasses = ownersClasses;
			}
		
		@Override
		public EffectopediaObject[] filter(EffectopediaObject elements[])
			{
				if (elements != null)
					{
						ArrayList<EffectopediaObject> filtered = new ArrayList<EffectopediaObject>();
						for (EffectopediaObject element : elements)
							for (Class<? extends EffectopediaObject> ownerClass : ownersClasses)
								if ((element instanceof Ownable) && (ownerClass.isAssignableFrom(((Ownable) element).getOwnerClass())))
									{
										filtered.add(element);
										break;
									}
						return filtered.toArray(new EffectopediaObject[filtered.size()]);
					}
				else
					return elements;
			}
		
		@Override
		public boolean filter(EffectopediaObject element)
			{
				if (element != null)
					for (Class<? extends EffectopediaObject> ownerClass : ownersClasses)
						return ((element instanceof Ownable) && (ownerClass.isAssignableFrom(((Ownable) element).getOwnerClass())));
				return false;
			}
		
		protected ArrayList<Class<? extends EffectopediaObject>>	ownersClasses;
	}

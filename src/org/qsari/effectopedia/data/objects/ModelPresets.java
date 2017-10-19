package org.qsari.effectopedia.data.objects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;

public class ModelPresets extends ArrayList<ModelPreset> implements Importable, Exportable, Cloneable
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public ModelPresets(EffectopediaObject owner)
			{
				this.owner = owner;
			}
		
		public ModelPresets clone()
			{
				ModelPresets clone = new ModelPresets(owner);
				for (ModelPreset preset : this)
					clone.add(preset);
				return clone;
			}
		
		public ModelPresets deepClone()
			{
				ModelPresets clone = new ModelPresets(owner);
				for (ModelPreset preset : this)
					clone.add(preset.clone());
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element == null)
					return;
				clear();
				int count = Integer.parseInt(element.getAttributeValue("count"));
				List<BaseIOElement> children = element.getChildren();
				if ((count != 0) && (children != null) && (children.size() == count))
					{
						Iterator<BaseIOElement> iterator = children.iterator();
						while (iterator.hasNext())
							{
								BaseIOElement modelPreset = iterator.next();
								ModelPreset preset = new ModelPreset();
								preset.load(modelPreset, io);
								add(preset);
							}
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				if (element != null)
					{
						for (ModelPreset preset : this)
							preset.updateExternalID(element);
					}
			}
		
		@Override
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						element.setAttribute("count", String.valueOf(size()));
						for (ModelPreset preset : this)
							element.addChild(preset.store(io.newElement("preset"), io));
					}
				return element;
			}
		
		public ModelPreset getDefault()
			{
				return (size() > 0) ? get(0) : null;
			}
		
		public void setDefault(ModelPreset perset)
			{
				int cnt = size();
				if (cnt == 0)
					add(perset);
				else
					set(0, perset);
			}
		
		public boolean hasPresets(boolean withCalculatedStatus)
			{
				for (ModelPreset preset : this)
					if (preset.isCalculated() == withCalculatedStatus)
						return true;
				return false;
			}
		
		public EffectopediaObject getOwner()
			{
				return owner;
			}
		
		public void setOwner(EffectopediaObject owner)
			{
				this.owner = owner;
			}
		
		public static boolean								REQUESTED		= false;
		public static boolean								CALCULATED	= true;
		protected EffectopediaObject	owner;
	}

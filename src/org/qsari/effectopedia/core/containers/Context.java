package org.qsari.effectopedia.core.containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.core.objects.ContextDimension;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.DataValue_String;

public class Context extends EffectopediaObjects<ContextDimension>
	{
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public boolean addNew(EffectopediaObject parent, DataSource dataSource, String dimensionName)
			{
				ContextDimension cd = new ContextDimension(parent, dataSource, dimensionName, ContextDimension.INFINITE, ContextDimension.CONTINEUS, false, DataValue_String.class);
				ContextDimension old = put(cd.getID(), cd);
				dimensions = null;
				return (old == null) || (old == cd);
			}
		
		public boolean addNew(EffectopediaObject parent, DataSource dataSource, Class<ContextDimension> objectClass)
			{
				ContextDimension cd = new ContextDimension(parent, dataSource);
				ContextDimension old = put(cd.getID(), cd);
				dimensions = null;
				return (old == null) || (old == cd);
			}
		
		public boolean add(ContextDimension cd)
			{
				ContextDimension old = put(cd.getID(), cd);
				dimensions = null;
				return (old == null) || (old == cd);
			}
		
		public List<ContextDimension> getDimensions()
			{
				if (dimensions == null)
					{
						dimensions = new ArrayList<ContextDimension>();
						dimensions.addAll(values());
						Collections.sort(dimensions);
					}
				return dimensions;
			}
		
		public ContextDimension[] get()
			{
				return values().toArray(new ContextDimension[values().size()]);
			}
		
		public String toString()
			{
				return "context";
			}
		
		protected ArrayList<ContextDimension>	dimensions					= null;
	}

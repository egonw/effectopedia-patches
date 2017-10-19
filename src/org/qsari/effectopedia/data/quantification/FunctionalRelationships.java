package org.qsari.effectopedia.data.quantification;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObject.BatchProcessor;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;

public class FunctionalRelationships extends ArrayList<FunctionalRelationship> implements Importable, Exportable
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public FunctionalRelationships(EffectopediaObject owner)
			{
				super();
				this.owner = owner;
			}

		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				for (FunctionalRelationship funcRel : this)
					funcRel.getContainedIDs(containedIDs);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				for (FunctionalRelationship funcRel : this)
					funcRel.getContainedExternalIDs(containedIDs);
			}

		public void process(BatchProcessor batch)
			{
				for (FunctionalRelationship funcRel : this)
					funcRel.process(batch);
			}
		public void updateParenthood()
			{
				for (FunctionalRelationship funcRel : this)
					funcRel.updateParenthood();
			}

		public void reloadReferredObjectsFromID()
			{
				for (FunctionalRelationship funcRel : this)
					funcRel.reloadReferredObjectsFromID();
			}

		public void load(BaseIOElement element, BaseIO io)
			{
				if (element == null)
					return;
				clear();
				int count = Integer.parseInt(element.getAttributeValue("count"));
				defaultIndex = Integer.parseInt(element.getAttributeValue("default_index"));
				List<BaseIOElement> children = element.getChildren();
				if ((count != 0) && (children != null) && (children.size() == count))
					{
						Iterator<BaseIOElement> iterator = children.iterator();
						while (iterator.hasNext())
							{
								BaseIOElement fnRel = iterator.next();
								FunctionalRelationship fn;
								Class<?> cl;
								try
									{
										// temporary patch before new version of the file format is issued
										cl = Class.forName(fnRel.getName().replace("FunctionalRelatinoship_Threshold", "FunctionalRelationship_Threshold"));
										if (cl == FunctionalRelationship_Analytic.class)
											fn = new FunctionalRelationship_Analytic(owner);
										else if (cl == FunctionalRelationship_Linear.class)
											fn = new FunctionalRelationship_Linear(owner, true);
										else if (cl == FunctionalRelationship_Threshold.class)
											fn = new FunctionalRelationship_Threshold(owner);
										else if (cl == FunctionalRelationship_Nonlinear.class)
											{
												int dataType = FunctionalRelationship_Nonlinear.getDataType(fnRel);
												fn = new FunctionalRelationship_Nonlinear(owner, dataType);
											}
										else
											continue;
										fn.load(fnRel, io);
										add(fn);
									}
								catch (ClassNotFoundException e)
									{
										e.printStackTrace();
									}
							}
					}
			}
		
		@Override
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						element.setAttribute("count", String.valueOf(size()));
						element.setAttribute("default_index", String.valueOf(defaultIndex));
						for (FunctionalRelationship funcRel : this)
							element.addChild(funcRel.store(io.newElement(funcRel.getClass().getName()), io));
					}
				return element;
			}
		
		public EffectopediaObject getOwner()
			{
				return owner;
			}
		
		public void setOwner(EffectopediaObject owner)
			{
				this.owner = owner;
				for (FunctionalRelationship funcRel : this)
					funcRel.setOwner(owner);
			}
		
		public FunctionalRelationship getDefault()
			{
				if (defaultIndex < size())
					return get(defaultIndex);
				else
					return null;
			}
		
		public void setDefault(FunctionalRelationship fnRel)
			{
				if (fnRel==null)
					return;
				for (int i = defaultIndex - size(); i >= 0; i--)
					add(fnRel);
				set(defaultIndex, fnRel);
			}
		
		@Override
		public boolean add(FunctionalRelationship fnRel)
			{
				if (indexOf(fnRel) == -1)
					return super.add(fnRel);
				else
					return false;
			}
		
		public FunctionalRelationships clone(EffectopediaObject owner, DataSource dataSource)
			{
				FunctionalRelationships clone = new FunctionalRelationships(owner);
				for (FunctionalRelationship fnRel: this)
					clone.add(fnRel.clone(owner, dataSource));
				return clone;
			}
		
		protected int																defaultIndex	= 0;
		protected EffectopediaObject	owner;

		
	}

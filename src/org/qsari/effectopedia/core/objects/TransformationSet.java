package org.qsari.effectopedia.core.objects;

import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.DataValue_String;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.quantification.DataSampleValueFactory;
import org.qsari.effectopedia.data.quantification.DataSampleValueFactory.DataSampleValue;
import org.qsari.effectopedia.data.quantification.DataTemplate;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship_Analytic;
import org.qsari.effectopedia.data.quantification.FunctionalRelationships;
import org.qsari.effectopedia.data.quantification.TransformationFunctionType;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.search.SearchIndices;
import org.qsari.effectopedia.search.SearchableItem;
import org.qsari.effectopedia.system.ActionTypes;
import org.qsari.effectopedia.system.TraceableProperties;

public class TransformationSet extends DocumentedKnowledge implements Importable, Exportable, Cloneable, Traceable
	{
		
		public TransformationSet()
			{
				super();
				SearchableItem sa = new SearchableItem(this, TS_TARGET_SITE_PID, SearchIndices.TARGET_INDEX);
				this.targetSite = new DataValue_String(sa);
				descriptionIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_TRANSFORMATION_SET_IDS);
				descriptionIDs.setParent(this);
			}
		
		public TransformationSet(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				SearchableItem sa = new SearchableItem(this, TS_TARGET_SITE_PID, SearchIndices.TARGET_INDEX);
				this.targetSite = new DataValue_String(sa);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_TRANSFORMATION_SET_IDS.clone(this, dataSource);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				if (transformationFunctions != null)
					transformationFunctions.getContainedExternalIDs(containedIDs);
			}
		
		public void process(BatchProcessor batch)
			{
				super.process(batch);
				if (transformationFunctions != null)
					transformationFunctions.process(batch);
			}
		
		public void updateParenthood()
			{
				super.updateParenthood();
				if (transformationFunctions != null)
					transformationFunctions.updateParenthood();
			}
		
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				if (transformationFunctions != null)
					{
						transformationFunctions.setOwner(dataSource.get(this.getClass(), this.getID()));
						transformationFunctions.reloadReferredObjectsFromID();
					}
			}
		
		public void cloneFieldsTo(TransformationSet clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				if (targetSite != null)
					clone.targetSite = this.targetSite.clone(clone);
				if (transformationFunctions != null)
					clone.transformationFunctions = this.transformationFunctions.clone(clone, dataSource);
				else
					clone.transformationFunctions = null;
			}
		
		@Override
		public TransformationSet clone()
			{
				TransformationSet clone = new TransformationSet();
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		@Override
		public TransformationSet clone(EffectopediaObject parent, DataSource dataSource)
			{
				TransformationSet clone = new TransformationSet(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						BaseIOElement trFns = element.getChild("transformation_functions");
						if (trFns != null)
							{
								transformationFunctions = new FunctionalRelationships(this);
								transformationFunctions.load(trFns, io);
							}
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				if (transformationFunctions != null)
					element.addChild(transformationFunctions.store(io.newArray("transformation_functions", transformationFunctions.size()), io));
				return element;
			}
		
		public FunctionalRelationships getTransformationFunctions()
			{
				return transformationFunctions;
			}
		
		public void setTransformationFunctions(FunctionalRelationships transformationFunctions)
			{
				this.transformationFunctions = transformationFunctions;
			}
		
		public String getTargetSite()
			{
				if (targetSite != null)
					return targetSite.toString();
				return null;
			}
		
		public void setTargetSite(String targetSite)
			{
				if (((targetSite == null) && (this.targetSite != null)) || (!targetSite.equals(this.targetSite)))
					{
						beforeUpdate(true, ActionTypes.TRANSF_SET_TARGET_AID);
						this.targetSite.parseString(targetSite);
					}
			}
		
		public void apply(DataTemplate dataTempleate)
			{
				if ((transformationFunctions != null) && (dataTempleate != null))
					for (FunctionalRelationship trFn : transformationFunctions)
						{
							ObjectPropertyMultivalued_Documented data = dataTempleate.getObjProp();
							FunctionalRelationship_Analytic transformationFunction = (FunctionalRelationship_Analytic) trFn;
							int[] valueFactoryIDs = transformationFunction.getTransformationType().getValueFactoryIDs();
							for (int i = valueFactoryIDs.length - 1; i >= 0; i--)
								{
									DataSampleValue dsValue = DataSampleValueFactory.VALUES.get(valueFactoryIDs[i]);
									for (int valueIndex = data.valuesCount() - 1; valueIndex >= 0; valueIndex--)
										{
											Double value = dsValue.get(data, valueIndex, 0);
											if ((value != null) && (!Double.isNaN(value)))
												dsValue.set(data, valueIndex, 0, transformationFunction.evaluate(value));
										}
								}
						}
			}
		
		public String getTranformedTitle(TransformationFunctionType transformationType)
			{
				if (transformationFunctions != null)
					for (int tr = transformationFunctions.size() - 1; tr >= 0; tr--)
						{
							FunctionalRelationship transformationFunction = transformationFunctions.get(tr);
							if (transformationFunction.getTransformationType().equals(transformationType))
								return transformationFunction.getTemplates().getyPrimaryAxisTitle();
						}
				return null;
			}
		
		public String getTranformedUnit(TransformationFunctionType transformationType)
			{
				if (transformationFunctions != null)
					for (int tr = transformationFunctions.size() - 1; tr >= 0; tr--)
						{
							FunctionalRelationship transformationFunction = transformationFunctions.get(tr);
							if (transformationFunction.getTransformationType().equals(transformationType))
								return transformationFunction.getTemplates().getDefaultYDisplayUnit();
						}
				return null;
			}
		
		public static final long										TS_TARGET_SITE_PID						= TraceableProperties.REGISTERED.add("target site", "", TransformationSet.class);
		protected DataValue_String								targetSite;
		protected FunctionalRelationships	transformationFunctions	= null;
	}

package org.qsari.effectopedia.core.objects;

import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.Resource;
import org.qsari.effectopedia.data.quantification.DataTemplates;
import org.qsari.effectopedia.defaults.DefaultDataTemplates;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public class SubstanceData_InSilico extends SubstanceData implements Importable, Exportable, Cloneable, Traceable
	{
		
		public SubstanceData_InSilico()
			{
				super();
				this.localModelParameters = DefaultEffectopediaObjects.buildingDefaultObjects ? DefaultEffectopediaObjects.DEFAULT_MODEL_PARAMETERS : DefaultEffectopediaObjects.DEFAULT_MODEL_PARAMETERS.clone(
						this, null);
				this.localModelInputProperties = DefaultEffectopediaObjects.buildingDefaultObjects ? DefaultEffectopediaObjects.DEFAULT_STRESSOR_DATA : DefaultEffectopediaObjects.DEFAULT_STRESSOR_DATA.clone(
						this, null);
				this.localModelInputTemplates = DefaultDataTemplates.DTS_TC_SINGLE_CHEM_ALL.clone();
				this.localModelInputTemplates.setProperties(localModelInputProperties);
				this.localModelInputTemplates.setOwner(this);
			}
		
		public SubstanceData_InSilico(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				this.localModelParameters = DefaultEffectopediaObjects.buildingDefaultObjects ? DefaultEffectopediaObjects.DEFAULT_MODEL_PARAMETERS : DefaultEffectopediaObjects.DEFAULT_MODEL_PARAMETERS.clone(
						this, null);
				this.localModelInputProperties = DefaultEffectopediaObjects.DEFAULT_STRESSOR_DATA.clone(this, dataSource);
				this.localModelInputTemplates = DefaultDataTemplates.DTS_TC_SINGLE_CHEM_ALL.clone();
				this.localModelInputTemplates.setProperties(localModelInputProperties);
				this.localModelInputTemplates.setOwner(this);
			}
		
		public SubstanceData_InSilico(Test_InSilico test, Initiator initiator, DataSource dataSource)
			{
				super(test, initiator, dataSource);
				this.localModelParameters = DefaultEffectopediaObjects.buildingDefaultObjects ? DefaultEffectopediaObjects.DEFAULT_MODEL_PARAMETERS : DefaultEffectopediaObjects.DEFAULT_MODEL_PARAMETERS.clone(
						this, null);
				this.localModelInputProperties = DefaultEffectopediaObjects.DEFAULT_STRESSOR_DATA.clone(this, dataSource);
				this.localModelInputTemplates = DefaultDataTemplates.DTS_TC_SINGLE_CHEM_ALL.clone();
				this.localModelInputTemplates.setProperties(localModelInputProperties);
				this.localModelInputTemplates.setOwner(this);
			}
		
		@Override
		public void init(boolean asDefaultObject)
			{
				this.substance = DefaultEffectopediaObjects.buildingDefaultObjects ? DefaultEffectopediaObjects.DEFAULT_REFERENCE_S : DefaultEffectopediaObjects.DEFAULT_REFERENCE_S.clone(this, dataSource);
				this.objectProperties = DefaultEffectopediaObjects.buildingDefaultObjects ? DefaultEffectopediaObjects.DEFAULT_D_RESP_DATA : DefaultEffectopediaObjects.DEFAULT_D_RESP_DATA.clone(this, null);
				this.templates = DefaultDataTemplates.DTS_DR_SINGLE_CHEM_ALL.clone();
				this.templates.setProperties(objectProperties);
				this.templates.setOwner(this);
				this.localModelInputProperties = DefaultEffectopediaObjects.DEFAULT_STRESSOR_DATA.clone(this, dataSource);
				this.localModelInputTemplates = DefaultDataTemplates.DTS_TC_SINGLE_CHEM_ALL.clone();
				this.localModelInputTemplates.setProperties(localModelInputProperties);
				this.localModelInputTemplates.setOwner(this);
				updateParenthood();
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs, boolean includeOwned)
			{
				super.getContainedIDs(containedIDs, includeOwned);
				if (localModelParameters != null)
					localModelParameters.getContainedIDs(containedIDs);
				if (localModelInputProperties != null)
					localModelInputProperties.getContainedIDs(containedIDs);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				super.getContainedExternalIDs(containedIDs);
				if (localModelParameters != null)
					localModelParameters.getContainedExternalIDs(containedIDs);
				if (localModelInputProperties != null)
					localModelInputProperties.getContainedExternalIDs(containedIDs);
			}
		
		public void reloadReferredObjectsFromID()
			{
				super.reloadReferredObjectsFromID();
				if (localModelParameters != null)
					localModelParameters.setOwner(dataSource.get(this.getClass(), this.getID()));
				if (localModelInputTemplates != null)
					localModelInputTemplates.setOwner(dataSource.get(this.getClass(), this.getID()));
				if (localModelInputProperties != null)
					localModelInputProperties.setOwner(dataSource.get(this.getClass(), this.getID()));
			}
		
		public ObjectProperties getLocalModelParameters()
			{
				return localModelParameters;
			}
		
		public void setLocalModelParameters(ObjectProperties localModelParameters)
			{
				this.localModelParameters = localModelParameters;
			}
		
		@Override
				public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if (eoDestintation instanceof SubstanceData_InSilico)
					{
						if (this.localModelParameters != null)
							((SubstanceData_InSilico)eoDestintation).localModelParameters = this.localModelParameters.clone(eoDestintation, dataSource);
						else
							((SubstanceData_InSilico)eoDestintation).localModelParameters = null;
						if (this.localModelInputProperties != null)
							((SubstanceData_InSilico)eoDestintation).localModelInputProperties = this.localModelInputProperties.clone(eoDestintation, dataSource);
						else
							((SubstanceData_InSilico)eoDestintation).localModelInputProperties = null;
						if (this.localModelInputTemplates != null)
							{
								((SubstanceData_InSilico)eoDestintation).localModelInputTemplates = this.localModelInputTemplates.clone();
								if (((SubstanceData_InSilico)eoDestintation).localModelInputProperties != null)
									{
										((SubstanceData_InSilico)eoDestintation).localModelInputTemplates.setTypes(((SubstanceData_InSilico)eoDestintation).localModelInputProperties.getTypes());
										((SubstanceData_InSilico)eoDestintation).localModelInputTemplates.setProperties(((SubstanceData_InSilico)eoDestintation).localModelInputProperties);
									}
								((SubstanceData_InSilico)eoDestintation).localModelInputTemplates.setOwner(eoDestintation);
							}
					}
			}


		public void cloneFieldsTo(SubstanceData_InSilico clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				if (this.localModelParameters != null)
					clone.localModelParameters = this.localModelParameters.clone(clone, dataSource);
				else
					clone.localModelParameters = null;
				if (this.localModelInputProperties != null)
					clone.localModelInputProperties = this.localModelInputProperties.clone(clone, dataSource);
				else
					clone.localModelInputProperties = null;
				if (this.localModelInputTemplates != null)
					{
						clone.localModelInputTemplates = this.localModelInputTemplates.clone();
						if (clone.localModelInputProperties != null)
							{
								clone.localModelInputTemplates.setTypes(clone.localModelInputProperties.getTypes());
								clone.localModelInputTemplates.setProperties(clone.localModelInputProperties);
							}
						clone.localModelInputTemplates.setOwner(clone);
					}
				
			}
		
		@Override
		public SubstanceData_InSilico clone()
			{
				SubstanceData_InSilico clone = new SubstanceData_InSilico(null, dataSource);
				cloneFieldsTo(clone, dataSource);
				clone.setParent(parent);
				return clone;
			}
		
		@Override
		public SubstanceData_InSilico clone(EffectopediaObject parent, DataSource dataSource)
			{
				SubstanceData_InSilico clone = new SubstanceData_InSilico(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						
						BaseIOElement modelParameters = element.getChild("local_model_parameters");
						if (modelParameters != null)
							{
								objectProperties.load(modelParameters, io);
								objectProperties.setOwner(this);
							}
						BaseIOElement inp = element.getChild("local_model_input_data");
						if (inp != null)
							{
								localModelInputProperties.load(inp, io);
								localModelInputProperties.setOwner(this);
							}
						inp = element.getChild("local_model_input_templates");
						if (inp != null)
							{
								localModelInputTemplates.load(inp, io);
								localModelInputTemplates.setProperties(localModelInputProperties);
							}
						BaseIOAttribute mI = element.getAttribute("model_index");
						if (mI != null)
							modelIndex = mI.getIntValue();
						mI = element.getAttribute("method_index");
						if (mI != null)
							methodIndex = mI.getIntValue();
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				super.updateExternalID(element);
				if (objectProperties != null)
					objectProperties.updateExternalID(element.getChild("local_model_parameters"));
				if (localModelInputProperties != null)
					localModelInputProperties.updateExternalID(element.getChild("local_model_input_data"));
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				if (localModelParameters != null)
					element.addChild(localModelParameters.store(io.newElement("local_model_parameters"), io));
				if (localModelInputProperties != null)
					element.addChild(localModelInputProperties.store(io.newElement("local_model_input_data"), io));
				if (localModelInputTemplates != null)
					element.addChild(localModelInputTemplates.store(io.newElement("local_model_input_templates"), io));
				if (modelIndex != 0)
					element.setAttribute("model_index", modelIndex);
				if (modelIndex != 1)
					element.setAttribute("method_index", methodIndex);
				return element;
			}
		
		public String DEBUG_getIDs()
			{
				StringBuilder sb = new StringBuilder();
				sb.append(super.DEBUG_getIDs());
				sb.append("\tlab\t");
				if (localModelParameters != null)
					sb.append(localModelParameters.getTypes().getNames());
				return sb.toString();
			}
		
		public Method_InSilicoGlobalModel getModel()
			{
				return ((Test_InSilico) (test.getCachedObject())).getGlobalModelIDs().getCachedObject(modelIndex);
			}
		
		public void setModel(Method_InSilicoGlobalModel model)
			{
				int index = ((Test_InSilico) (test.getCachedObject())).getGlobalModelIDs().contains(model);
				if (index != -1)
					modelIndex = index;
			}
		
		public DataTemplates getLocalModelInputTemplates()
			{
				return localModelInputTemplates;
			}
		
		public void setLocalModelInputTemplates(DataTemplates localModelInputTemplates)
			{
				this.localModelInputTemplates = localModelInputTemplates;
			}
		
		public ObjectProperties getLocalModelInputProperties()
			{
				return localModelInputProperties;
			}
		
		public void setLocalModelInputProperties(ObjectProperties localModelInputProperties)
			{
				this.localModelInputProperties = localModelInputProperties;
			}
		
		public Resource getModelMethod()
			{
				if (methodIndex >= 0)
					{
						Method_InSilicoGlobalModel model = getModel();
						return model != null ? model.getResources().getCachedObject(methodIndex) : null;
					}
				else
					return null;
			}
		
		public void setModelMethod(Resource resource)
			{
				Method_InSilicoGlobalModel model = getModel();
				if (model != null)
					methodIndex = model.getResources().getIndexOf(resource);
				else
					methodIndex = -1;
			}
		
		protected int														modelIndex		= 0;
		protected int														methodIndex	= 1;
		protected DataTemplates				localModelInputTemplates;
		protected ObjectProperties	localModelInputProperties;
		protected ObjectProperties	localModelParameters;
	}

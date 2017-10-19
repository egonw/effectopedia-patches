package org.qsari.effectopedia.data.objects;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public class ModelPreset implements Importable, Exportable, Cloneable
	{
		public ModelPreset()
			{
				calculated = false;
			}
		
		public ModelPreset(EffectopediaObject owner)
			{
				this.owner = owner;
				calculated = false;
			}
		
		public ModelPreset(ObjectProperties modelInput, ObjectProperties modelParamaters, ObjectProperties modelOutput)
			{
				if (modelInput != null)
					this.modelInput = modelInput.clone(modelInput.owner, modelInput.owner.getDataSource());
				if (modelOutput != null)
					this.modelOutput = modelOutput.clone(modelOutput.owner, modelOutput.owner.getDataSource());
				if (modelParamaters != null)
					this.modelParamaters = modelParamaters.clone(modelParamaters.owner, modelParamaters.owner.getDataSource());
			}
		
		public ModelPreset clone()
			{
				EffectopediaObject eo = (this.modelParamaters != null) ? this.modelParamaters.owner : null;
				DataSource dataSource = (eo != null) ? eo.getDataSource() : null;
				return clone(eo, dataSource);
			}
		
		public ModelPreset clone(EffectopediaObject parent, DataSource dataSource)
			{
				ModelPreset clone = new ModelPreset();
				clone.setCalculated(this.calculated);
				clone.setTitle(this.title);
				clone.setDescription(this.description);
				clone.setModelInput(this.modelInput.clone(parent, dataSource));
				clone.setModelInput(this.modelInput.clone(parent, dataSource));
				clone.setModelInput(this.modelInput.clone(parent, dataSource));
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						BaseIOAttribute calc = element.getAttribute("calculated");
						if (calc != null)
							calculated = calc.getBooleanValue();
						title = element.getValueElement("title").getValue();
						description = element.getValueElement("description").getValue();
						BaseIOElement inp = element.getChild("model_input");
						if (inp != null)
							{
								if (modelInput == null)
									modelInput = DefaultEffectopediaObjects.buildingDefaultObjects ? DefaultEffectopediaObjects.DEFAULT_STRESSOR_DATA : DefaultEffectopediaObjects.DEFAULT_STRESSOR_DATA.clone(owner,null);
								modelInput.load(inp, io);
							}
						BaseIOElement out = element.getChild("model_output");
						if (out != null)
							{
								if (modelOutput==null)
									modelOutput = DefaultEffectopediaObjects.buildingDefaultObjects ? DefaultEffectopediaObjects.DEFAULT_D_RESP_DATA : DefaultEffectopediaObjects.DEFAULT_D_RESP_DATA.clone(owner,null);
							modelOutput.load(element.getChild("model_output"), io);
							}
						BaseIOElement par = element.getChild("model_parameters");
						if (par != null)
							{
								if (modelParamaters == null)
									modelParamaters = DefaultEffectopediaObjects.buildingDefaultObjects ? DefaultEffectopediaObjects.DEFAULT_MODEL_PARAMETERS : DefaultEffectopediaObjects.DEFAULT_MODEL_PARAMETERS.clone(owner,null);
								modelParamaters.load(element.getChild("model_parameters"), io);
							}
						
					}
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				if (modelInput != null)
					modelInput.updateExternalID(element.getChild("model_input"));
				if (modelOutput != null)
					modelOutput.updateExternalID(element.getChild("model_output"));
				if (modelParamaters != null)
					modelParamaters.updateExternalID(element.getChild("model_parameters"));
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				element.setAttribute("calculated", calculated);
				element.addValueElement(io.newValue("title").setValue(title));
				element.addValueElement(io.newValue("description").setValue(description));
				if (modelInput != null)
					element.addChild(modelInput.store(io.newElement("model_input"), io));
				if (modelOutput != null)
					element.addChild(modelOutput.store(io.newElement("model_output"), io));
				if (modelParamaters != null)
					element.addChild(modelParamaters.store(io.newElement("model_parameters"), io));
				return element;
			}
		
		public String getTitle()
			{
				return title;
			}
		
		public void setTitle(String title)
			{
				this.title = title;
			}
		
		public String getDescription()
			{
				return description;
			}
		
		public void setDescription(String description)
			{
				this.description = description;
			}
		
		public boolean isCalculated()
			{
				return calculated;
			}
		
		public void setCalculated(boolean calculated)
			{
				this.calculated = calculated;
				if (title != null)
					title = title.replaceFirst("Execution request", "Preset");
			}
		
		public ObjectProperties getModelInput()
			{
				return modelInput;
			}
		
		public void setModelInput(ObjectProperties modelInput)
			{
				this.modelInput = modelInput;
			}
		
		public ObjectProperties getModelOutput()
			{
				return modelOutput;
			}
		
		public void setModelOutput(ObjectProperties modelOutput)
			{
				this.modelOutput = modelOutput;
			}
		
		public ObjectProperties getModelParamaters()
			{
				return modelParamaters;
			}
		
		public void setModelParamaters(ObjectProperties modelParamaters)
			{
				this.modelParamaters = modelParamaters;
			}
		
		public String toString()
			{
				return title;
			}
		
		@Override
		public int hashCode()
			{
				return title.hashCode();
			}
		
		public EffectopediaObject getOwner()
			{
				return owner;
			}
		
		public void setOwner(EffectopediaObject owner)
			{
				this.owner = owner;
			}
		
		protected String													title;
		protected String													description;
		protected boolean												calculated;
		protected ObjectProperties			modelInput;
		protected ObjectProperties			modelOutput;
		protected ObjectProperties			modelParamaters;
		protected EffectopediaObject	owner;
	}

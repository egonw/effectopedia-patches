package org.qsari.effectopedia.core.objects;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.object.elemets.Coordinates;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public class DocumentedKnowledge_Located extends DocumentedKnowledge implements Importable, Exportable, Cloneable, Traceable
	{
		
		public DocumentedKnowledge_Located()
			{
				super();
				coordinates = new Coordinates(this, DefaultEffectopediaObjects.DEFAULT_CONTEXT.getDimensions());
			}
		
		public DocumentedKnowledge_Located(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				coordinates = new Coordinates(this, DefaultEffectopediaObjects.DEFAULT_CONTEXT.getDimensions());
			}
		
		public Coordinates getCoordinates()
			{
				return coordinates;
			}
		
		@Override
		public void init(boolean asDefaultObject)
			{
				metadata = new ObjectProperties(this, DefaultEffectopediaObjects.DEFAULT_DOC_KNOWLEDGE_METADATA);
				coordinates = new Coordinates(this, DefaultEffectopediaObjects.DEFAULT_CONTEXT.getDimensions());
				updateParenthood();
			}
		
		@Override
				public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if (eoDestintation instanceof DocumentedKnowledge_Located)
					((DocumentedKnowledge_Located) eoDestintation).coordinates = this.coordinates.clone(((DocumentedKnowledge_Located) eoDestintation));
			}

		public void cloneFieldsTo(DocumentedKnowledge_Located clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.coordinates = this.coordinates.clone(clone);
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						this.coordinates.load(element.getChild("coordinates"), io);
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addChild(coordinates.store(io.newElement("coordinates"), io));
				return element;
			}
		
		public static class BatchSetCooridnate implements BatchProcessor
			{
				
				public BatchSetCooridnate(int dimensionIndex, String value)
					{
						this.dimensionIndex = dimensionIndex;
						this.value = value;
						hierarchical = false;
					}
				
				public BatchSetCooridnate(int dimensionIndex, int category, String value)
					{
						this.dimensionIndex = dimensionIndex;
						this.category = category;
						this.value = value;
						hierarchical = true;
					}
				
				public void process(EffectopediaObject eo)
					{
						if (eo instanceof DocumentedKnowledge_Located)
							if (hierarchical)
								{
									DocumentedKnowledge_Located dkl = ((DocumentedKnowledge_Located) eo);
									ContextDimension_Hierarchical dimension = (ContextDimension_Hierarchical) dkl.getCoordinates().getCoordiante(dimensionIndex).getDimension();
									dkl.getCoordinates().setCategory(dimension.DIMENSION_INDEX, category);
									dkl.getCoordinates().setValue(dimensionIndex, value);
								}
							else
								{
									((DocumentedKnowledge_Located) eo).getCoordinates().setValue(dimensionIndex, value);
								}
					}
				
				public int getOptions()
					{
						return this.options;
					}
				
				private boolean	hierarchical	= false;
				private int					dimensionIndex;
				private int					category;
				private String		value;
				private int					options						= BatchProcessor.PROCESS_ALL;
			}
		
		protected Coordinates	coordinates;
	}

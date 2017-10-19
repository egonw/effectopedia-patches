package org.qsari.effectopedia.core.objects;

import java.util.HashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.DataValue_String;
import org.qsari.effectopedia.data.objects.ValuesList;
import org.qsari.effectopedia.defaults.DefaultTextProperties;
import org.qsari.effectopedia.system.TraceableProperties;

public class ContextDimension extends EffectopediaObject implements Cloneable, Traceable
	{
		public static long				INFINITE				= -2L;
		public static long				UNKNOWN					= -1L;
		public static boolean	DENUMERABLE	= true;
		public static boolean	CONTINEUS			= false;
		
		public ContextDimension()
			{
				super();
				this.propertyID = 0;
			}
		
		public ContextDimension(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				this.propertyID = 0;
			}
		
		public ContextDimension(EffectopediaObject parent, DataSource dataSource, String dimensionName, long cardinality, boolean countable, boolean ordered, Class<?> baseDataType)
			{
				super(parent, dataSource);
				this.name = dimensionName;
				NAME_INDEX.put(dimensionName, this);
				this.cardinality = cardinality;
				this.countable = countable;
				this.ordered = ordered;
				this.baseDataType = baseDataType;
				this.propertyID = TraceableProperties.REGISTERED.add(name, name, DocumentedKnowledge_Located.class);
			}
		
		public String getName()
			{
				if (name == null)
					return DefaultTextProperties.INSTANCE.getDefault("ContextDimension.name");
				else
					return name;
			}
		
		public void setName(String name)
			{
				if (((name == null) && (this.name != null)) || (!name.equals(this.name)))
					{
						// update(true, ActionTypes.CONTEXTDIM_NAME);
						NAME_INDEX.remove(this.name);
						this.name = name;
						NAME_INDEX.put(name, this);
					}
			}
		
		public String toString()
			{
				return getName();
			}
		
		@Override
				public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if (eoDestintation instanceof ContextDimension)
					{
						((ContextDimension) eoDestintation).setName(this.getName());
						((ContextDimension) eoDestintation).cardinality = this.cardinality;
						((ContextDimension) eoDestintation).countable = this.countable;
						((ContextDimension) eoDestintation).ordered = this.ordered;
						((ContextDimension) eoDestintation).baseDataType = this.baseDataType;
					}
			}
	
		public void cloneFieldsTo(ContextDimension clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.name = this.name;
				clone.cardinality = this.cardinality;
				clone.countable = this.countable;
				clone.ordered = this.ordered;
				clone.baseDataType = this.baseDataType;
			}
		
		public ContextDimension clone()
			{
				ContextDimension clone = new ContextDimension(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public ContextDimension clone(EffectopediaObject parent, DataSource dataSource)
			{
				ContextDimension clone = new ContextDimension(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						name = element.getChildValue("name");
						cardinality = element.getValueElement("cardinality").getLongValue();
						countable = element.getValueElement("countable").getBooleanValue();
						ordered = element.getValueElement("ordered").getBooleanValue();
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addValueElement(io.newValue("name").setValue(name));
				element.addValueElement(io.newValue("cardinality").setValue(cardinality));
				element.addValueElement(io.newValue("countable").setValue(countable));
				element.addValueElement(io.newValue("ordered").setValue(ordered));
				return element;
			}
		
		public long getCardinality()
			{
				return cardinality;
			}
		
		public boolean isCountable()
			{
				return countable;
			}
		
		public boolean isOrdered()
			{
				return ordered;
			}
		
		public ValuesList getDefaultValues()
			{
				return defaultValues;
			}
		
		public void setDefaultValues(ValuesList defaultValues)
			{
				this.defaultValues = defaultValues;
			}
		
		public Class<?> getBaseDataType()
			{
				return baseDataType;
			}
		
		public boolean isSearchable()
			{
				return searchable;
			}
		
		public ContextDimension setSearchable(boolean searchable)
			{
				this.searchable = searchable;
				return this;
			}
		
		public int getValueActionTypeID()
			{
				return valueActionTypeID;
			}
		
		public int getUnitActionTypeID()
			{
				return unitActionTypeID;
			}
		
		public ContextDimension oneTimeSetActionTypeIDs(int valueActionTypeID, int unitActionTypeID)
			{
				if ((this.valueActionTypeID == 0) && (valueActionTypeID != 0))
					this.valueActionTypeID = valueActionTypeID;
				if ((this.unitActionTypeID == 0) && (unitActionTypeID != 0))
					this.unitActionTypeID = unitActionTypeID;
				return this;
			}
		
		@Override
		public int compareTo(IndexedObject o)
			{
				if (o instanceof ContextDimension)
					return this.DIMENSION_INDEX - ((ContextDimension) o).DIMENSION_INDEX;
				return (int) (getID() - o.getID());
			}
		
		protected String																																						name;
		protected ValuesList																																		defaultValues											= null;
		protected Class<?>																																				baseDataType												= DataValue_String.class;
		protected long																																								cardinality													= INFINITE;
		protected boolean																																					countable															= CONTINEUS;
		protected boolean																																					ordered;
		private int																																											valueActionTypeID							= 0;
		private int																																											unitActionTypeID								= 0;
		protected boolean																																					searchable														= true;
		public final long																																					propertyID;
		public final int																																						DIMENSION_INDEX									= contextDimensionIndices++;
		protected static int																																		contextDimensionIndices	= 0;
		public final static HashMap<String, ContextDimension>	NAME_INDEX														= new HashMap<String, ContextDimension>();
	}

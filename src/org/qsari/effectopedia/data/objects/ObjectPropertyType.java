package org.qsari.effectopedia.data.objects;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOArray;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.BaseIOValue;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.interfaces.IdentifiableDescriptorType;
import org.qsari.effectopedia.data.interfaces.IdentifiableObjectPropertyType;
import org.qsari.effectopedia.data.interfaces.Ownable;
import org.qsari.effectopedia.data.interfaces.SearchableTypesContainer;
import org.qsari.effectopedia.system.TraceableProperties;

public class ObjectPropertyType extends DescriptorType implements Importable, Exportable, Cloneable, Ownable, IdentifiableObjectPropertyType
	{
		
		public ObjectPropertyType()
			{
				super();
			}
		
		public ObjectPropertyType assignDocumented(String name, String displayName, Class<? extends EffectopediaObject> ownerClass, String description, Class<?> baseValueType, DataUnit defaultUnit)
			{
				this.name = name;
				this.ownerClass = ownerClass;
				this.baseValueType = DataValue_Double.class;
				this.documented = true;
				this.acceptingMultipleValues = true;
				this.searchable = false;
				this.categorical = false;
				return this;
			}
		
		public ObjectPropertyType(String category, String displayName, String name, String searchName, Class<? extends EffectopediaObject> ownerClass, String description, Class<?> baseValueType,
				DataUnit defaultUnit, int actionTypeID)
			{
				super(name, description, baseValueType, defaultUnit);
				registerProperty(searchName, ownerClass, description, actionTypeID);
				this.documented = false;
				this.category = category;
				this.categorical = false;
				this.displayName = displayName;
			}
		
		public ObjectPropertyType makeDocumented(String desctiptorsCaption)
			{
				this.documented = true;
				this.acceptingMultipleValues = true;
				this.descriptorsCaption = desctiptorsCaption;
				return this;
			}

		public ObjectPropertyType makeMultivalued()
			{
				this.documented = false;
				this.acceptingMultipleValues = true;
				return this;
			}
		
		public ObjectPropertyType makeCategorical()
			{
				this.categorical = true;
				this.documented = false;
				this.acceptingMultipleValues = false;
				return this;
			}
		
		public ObjectPropertyType addFixedValuesList(FixedValuesList fixedValuesList)
			{
				this.fixedValuesList = fixedValuesList;
				return this;
			}
		
		public void cloneFieldsTo(ObjectPropertyType clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.ownerClass = this.ownerClass;
				clone.propertyID = this.propertyID;
				clone.searchName = this.searchName;
				clone.searchable = this.searchable;
				clone.actionTypeID = this.actionTypeID;
				clone.fullName = this.fullName;
				clone.displayName = this.displayName;
				clone.category = this.category;
				clone.fixedValuesList = this.fixedValuesList;
				clone.descriptors = this.descriptors.clone();
				clone.descriptorsCaption = this.descriptorsCaption;
				clone.documented = this.documented;
				clone.acceptingMultipleValues = this.acceptingMultipleValues;
				clone.categorical = this.categorical;
			}
		
		@Override
		public ObjectPropertyType clone(EffectopediaObject owner, DataSource dataSource)
			{
				ObjectPropertyType clone = new ObjectPropertyType();
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		@Override
		public ObjectPropertyType clone()
			{
				ObjectPropertyType clone = new ObjectPropertyType();
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public String getDisplayName()
			{
				return this.displayName;
			}
		
		public String getName()
			{
				return this.name;
			}
		
		public void setName(String name)
			{
				this.name = name;
				this.fullName = ownerClass.getSimpleName() + '.' + name;
			}
		
		@SuppressWarnings("unchecked")
		protected void deepLoad(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.deepLoad(element, io);
						BaseIOValue e = element.getValueElement("owner_class");
						if (e != null)
							try
								{
									ownerClass = (Class<? extends EffectopediaObject>) Class.forName(e.getValue());
								}
							catch (ClassNotFoundException e1)
								{
									e1.printStackTrace();
								}
						propertyID = element.getValueElement("propertyID").getLongValue();
						searchName = element.getValueElement("search_name").getValue();
						searchable = element.getValueElement("searchable").getBooleanValue();
						actionTypeID = element.getValueElement("actionTypeID").getIntValue();
						BaseIOValue categ = element.getValueElement("category");
						if (categ != null)
							category = categ.getValue();
						else
							category = ".";
						fullName = element.getValueElement("full_name").getValue();
						displayName = element.getChildValue("display_name");
						BaseIOValue doc = element.getValueElement("documented");
						if (doc != null)
							documented = doc.getBooleanValue();
						BaseIOValue multival = element.getValueElement("accepting_multiple_values");
						if (multival != null)
							acceptingMultipleValues = multival.getBooleanValue();
						BaseIOValue cat = element.getValueElement("categorical");
						categorical = (cat != null);
						
						BaseIOArray subProp = element.getArray("sub_property_types");
						if (subProp != null)
							{
								subPropertyTypes = new ObjectPropertyTypesContainer();
								subPropertyTypes.load(subProp, io);
							}
						e = element.getValueElement("descriptor_caption");
						if (e != null)
							descriptorsCaption = e.getValue();
						descriptors.load(element.getChild("descriptor_types"), io);
					}
			}
		
		protected BaseIOElement deepStore(BaseIOElement element, BaseIO io)
			{
				super.deepStore(element, io);
				if (ownerClass != null)
					element.addValueElement(io.newValue("owner_class").setValue(ownerClass.getName()));
				element.addValueElement(io.newValue("propertyID").setValue(propertyID));
				element.addValueElement(io.newValue("search_name").setValue(searchName));
				element.addValueElement(io.newValue("searchable").setValue(searchable));
				element.addValueElement(io.newValue("actionTypeID").setValue(actionTypeID));
				element.addValueElement(io.newValue("category").setValue(category));
				element.addValueElement(io.newValue("full_name").setValue(fullName));
				element.addValueElement(io.newValue("display_name").setValue(fullName));
				if (categorical)
					element.addValueElement(io.newValue("categorical").setValue(categorical));
				element.addValueElement(io.newValue("documented").setValue(documented));
				element.addValueElement(io.newValue("accepting_multiple_values").setValue(acceptingMultipleValues));
				if (subPropertyTypes != null)
					element.addChild(subPropertyTypes.store(io.newArray("sub_property_types", subPropertyTypes.size()), io));
				if (descriptorsCaption != null)
					element.addValueElement(io.newValue("descriptor_caption").setValue(descriptorsCaption));
				if (descriptors != null)
					element.addChild(descriptors.store(io.newArray("descriptor_types", descriptors.size()), io));
				return element;
			}
		
		protected void registerProperty(String searchName, Class<? extends EffectopediaObject> ownerClass, String description, int actionTypeID)
			{
				searchable = searchName != null;
				this.ownerClass = ownerClass;
				if (searchable)
					{
						propertyID = TraceableProperties.REGISTERED.add(name, name, ownerClass);
						this.searchName = searchName;
					}
				this.actionTypeID = actionTypeID;
				this.fullName = ownerClass.getSimpleName() + '.' + name;
			}
		
		public String getFullName()
			{
				return this.fullName;
			}
		
		public long getPeopertyID()
			{
				return propertyID;
			}
		
		public String getSearchName()
			{
				return searchName;
			}
		
		public boolean isSearchable()
			{
				return searchable;
			}
		
		public int getActionTypeID()
			{
				return actionTypeID;
			}
		
		public boolean isDocumented()
			{
				return documented;
			}
		
		public boolean isAcceptingMultipleValues()
			{
				return acceptingMultipleValues;
			}
		
		public void setAcceptingMultipleValues(boolean acceptingMultipleValues)
			{
				this.categorical = false;
				this.acceptingMultipleValues = acceptingMultipleValues;
			}
		
		public final DescriptorTypesContainer getDescriptors()
			{
				return descriptors;
			}
		
		@Override
		public void setDescriptors(SearchableTypesContainer<IdentifiableDescriptorType> descriptors)
			{
				if (descriptors instanceof DescriptorTypesContainer)
					this.descriptors = (DescriptorTypesContainer) descriptors;
				// TODO
			}
		
		public final void setDocumented(boolean documented)
			{
				this.categorical = false;
				this.documented = documented;
			}
		
		public boolean isCategorical()
			{
				return categorical;
			}
		
		public void setCategorical(boolean categorical)
			{
				if (categorical)
					makeCategorical();
				this.categorical = categorical;
			}
		
		public String getDescriptorsCaption()
			{
				return descriptorsCaption;
			}
		
		public void setDescriptorsCaption(String descriptorsCaption)
			{
				this.descriptorsCaption = descriptorsCaption;
			}
		
		public int getDescriptorsCount()
			{
				return descriptors.size();
			}
		
		public ObjectPropertyTypesContainer getSubPropertyTypes()
			{
				return subPropertyTypes;
			}
		
		public void setSubPropertyTypes(ObjectPropertyTypesContainer subPropertyTypes)
			{
				this.subPropertyTypes = subPropertyTypes;
			}
		
		public void setDisplayName(String displayName)
			{
				this.displayName = displayName;
			}
		
		public String getCategory()
			{
				return category;
			}
		
		public void setCategory(String category)
			{
				this.category = category;
			}
		
		public Class<? extends EffectopediaObject> getOwnerClass()
			{
				return ownerClass;
			}
		
		@SuppressWarnings("unchecked")
		@Override
		public void setOwnerClass(Class<?> ownerClass)
			{
				this.ownerClass = (Class<? extends EffectopediaObject>) ownerClass;
			}
		
		public boolean hasSubProperties()
			{
				return subPropertyTypes != null && subPropertyTypes.size() > 0;
			}
		
		protected DescriptorTypesContainer												descriptors													= new DescriptorTypesContainer();
		protected String																														fullName;
		protected String																														displayName;
		protected String																														category;
		protected Class<? extends EffectopediaObject>	ownerClass;
		protected long																																propertyID														= 0;
		protected String																														searchName														= null;
		protected boolean																													searchable														= false;
		protected int																																	actionTypeID												= 0;
		protected String																														descriptorsCaption;
		protected boolean																													documented;
		protected boolean																													acceptingMultipleValues	= false;
		protected boolean																													categorical													= false;
		protected ObjectPropertyTypesContainer								subPropertyTypes								= null;
		
	}

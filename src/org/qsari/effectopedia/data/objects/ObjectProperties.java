package org.qsari.effectopedia.data.objects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;

public class ObjectProperties implements Importable, Exportable, Cloneable
	{
		public ObjectProperties(EffectopediaObject owner, ObjectPropertyTypesContainer types)
			{
				super();
				this.owner = owner;
				this.types = types;
				generate();
			}
		
		public ObjectProperties(EffectopediaObject owner, LinkedHashMap<ObjectPropertyType, ObjectProperty> properties)
			{
				super();
				this.owner = owner;
				this.types = new ObjectPropertyTypesContainer();
				if (properties != null)
					for (ObjectPropertyType type : properties.keySet())
						types.add(type);
				this.properties = properties;
			}
		
		public void generate()
			{
				if (properties == null)
					properties = new LinkedHashMap<ObjectPropertyType, ObjectProperty>(types.size());
				else
					properties.clear();
				for (ObjectPropertyType t : types)
					if (t.isDocumented())
						properties.put(t, new ObjectPropertyMultivalued_Documented(owner, t));
					else
						properties.put(t, new ObjectProperty(owner, t));
			}
		
		public void getContainedIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				for (ObjectPropertyType t : types)
					t.getContainedIDs(containedIDs, true);
			}
		
		public void getContainedEffectopediaObjects(ArrayList<EffectopediaObject> list)
			{
				list.addAll(types);
			}
		
		public void getContainedExternalIDs(LinkedHashMap<Long, EffectopediaObject> containedIDs)
			{
				for (ObjectPropertyType t : types)
					t.getContainedExternalIDs(containedIDs);
			}
		
		public void cloneFieldsTo(ObjectProperties clone, DataSource dataSource)
			{
				clone.properties.clear();
				for (ObjectProperty p : properties.values())
					{
						ObjectProperty op = p.clone(clone.owner);
						clone.properties.put(op.type, op);
					}
			}
		
		public ObjectProperties clone(EffectopediaObject parent, DataSource dataSource)
			{
				ObjectProperties clone = new ObjectProperties(parent, this.types.clone());
				clone.owner = parent;
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public String[] getPropertyNames()
			{
				return types.getNames();
			}
		
		public String[] getPropertyValues()
			{
				String[] values = new String[properties.size()];
				Iterator<Entry<ObjectPropertyType, ObjectProperty>> it = properties.entrySet().iterator();
				int i = 0;
				while (it.hasNext())
					values[i++] = it.next().getValue().getValueAndUnit().getDisplayValue();
				return values;
			}
		
		public void assignPropertyValues(ObjectProperties fromProperties)
			{
				for (Entry<ObjectPropertyType, ObjectProperty> entry : fromProperties.properties.entrySet())
					{
						ObjectProperty property = properties.get(entry.getKey());
						if (property != null)
							property.assingFrom(entry.getValue());
					}
			}
		
		public String[] getPropertyUnits()
			{
				String[] values = new String[properties.size()];
				Iterator<Entry<ObjectPropertyType, ObjectProperty>> it = properties.entrySet().iterator();
				int i = 0;
				while (it.hasNext())
					values[i++] = it.next().getValue().getValueAndUnit().getDisplayUnit();
				return values;
			}
		
		public String getPropertyName(int index)
			{
				if ((index >= 0) && (index < types.size()))
					return types.get(index).getName();
				return null;
			}
		
		public ObjectProperty getProperty(String name)
			{
				int index = types.IndexOf(name);
				if (index != -1)
					return properties.get(types.get(index));
				else
					return null;
			}
		
		public ObjectProperty getProperty(int index)
			{
				if ((index >= 0) && (index < types.size()))
					return properties.get(types.get(index));
				else
					return null;
			}
		
		public ObjectProperty getOrCreateProperty(int index)
			{
				if ((index >= 0) && (index < types.size()))
					{
						ObjectPropertyType type = types.get(index);
						ObjectProperty property = properties.get(type);
						if (property == null)
							{
								if (type.isDocumented())
									property = new ObjectPropertyMultivalued_Documented(owner, type);
								else
									property = new ObjectProperty(owner, type);
								properties.put(type, property);
							}
						return property;
					}
				return null;
			}
		
		public void add(ObjectProperty o)
			{
				if (o != null)
					{
						types.add(o.type);
						properties.put(o.type, o);
					}
			}
		
		public void clear()
			{
				types.clear();
				properties.clear();
			}
		
		public void remove(int index)
			{
				if ((index >= 0) && (index < types.size()))
					{
						types.remove(index);
						properties.remove(index);
					}
			}
		
		public void remove(ObjectPropertyType type)
			{
				if (type != null)
					{
						types.remove(type);
						properties.remove(type);
					}
			}
		
		public ObjectProperty getProperty(ObjectPropertyType type)
			{
				return properties.get(type);
			}
		
		public ObjectProperty[] getProperties()
			{
				return properties.values().toArray(new ObjectProperty[types.size()]);
			}
		
		public ObjectProperty setPropery(ObjectPropertyType type, ObjectProperty property)
			{
				if (type == null)
					return null;
				ObjectProperty old = properties.get(type);
				properties.put(type, property);
				return old;
			}
		
		public String getPropertyValue(int index)
			{
				ObjectProperty property = getProperty(index);
				return (property == null) ? null : property.getValueAndUnit().getDisplayValue();
			}
		
		public void setPropertyValue(int index, String value)
			{
				getOrCreateProperty(index).setValue(value);
			}
		
		public void setPropertyUnit(int index, String value)
			{
				getOrCreateProperty(index).getValueAndUnit().setUnit(value);
			}
		
		public void setPropertyConditions(int index, String value)
			{
				ObjectPropertyType type = types.get(index);
				if (type != null && type.isDocumented())
					{
						ObjectPropertyMultivalued_Documented property = ((ObjectPropertyMultivalued_Documented) properties.get(type));
						if (property == null)
							property = new ObjectPropertyMultivalued_Documented(owner, type);
						property.parseConditions(value);
					}
			}
		
		public void setPropertyReference(int index, String value)
			{
				ObjectPropertyType type = types.get(index);
				if (type != null && type.isDocumented())
					{
						ObjectPropertyMultivalued_Documented property = ((ObjectPropertyMultivalued_Documented) properties.get(type));
						if (property == null)
							property = new ObjectPropertyMultivalued_Documented(owner, type);
						property.setDisplayReferences(value);
					}
			}
		
		public String getPropertyUnit(int index)
			{
				ObjectProperty property = getProperty(index);
				return (property == null) ? null : property.getValueAndUnit().getDisplayUnit();
			}
		
		public String getPropertyDefaultDescriptors(int index)
			{
				if ((index >= 0) && (index < types.size()))
					{
						ObjectPropertyType type = types.get(index);
						ObjectProperty op = properties.get(type);
						if (type.isDocumented() || (op != null))
							{
								String defaultDescriptors = null;
								if (op instanceof ObjectPropertyMultivalued_Documented)
									defaultDescriptors = ((ObjectPropertyMultivalued_Documented) op).getDisplayConditions();
								return (defaultDescriptors == null) ? type.getDescriptorsCaption() : defaultDescriptors;
							}
					}
				return null;
			}
		
		public String getPropertyReference(int index)
			{
				
				if ((index >= 0) && (index < types.size()))
					{
						ObjectPropertyType type = types.get(index);
						ObjectProperty op = properties.get(type);
						if (type.isDocumented() && (op instanceof ObjectPropertyMultivalued_Documented))
							{
								System.out.println(type.fullName + "\t" + op.getClass().getCanonicalName());
								return ((ObjectPropertyMultivalued_Documented) op).getDisplayReferences();
							}
					}
				return null;
			}
		
		public int getCount()
			{
				return types.size();
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element == null)
					return;
				int count = Integer.parseInt(element.getAttributeValue("count"));
				List<BaseIOElement> children = element.getChildren();
				if ((count != 0) && (children != null) && (children.size() == count))
					{
						types.clearNonDefault();
						Iterator<BaseIOElement> iterator = children.iterator();
						while (iterator.hasNext())
							{
								BaseIOElement property = iterator.next();
								ObjectProperty p;
								if (property.getAttribute("documented") != null)
									p = new ObjectPropertyMultivalued_Documented(owner, null);
								else
									p = new ObjectProperty(owner, null);
								p.load(property, io);
								properties.put(p.type, p);
								if ((!p.type.isDefaultID()) || (types.indexOf(p.type) == -1))
									types.add(p.type);
							}
					}
				
			}
		
		public void updateExternalID(BaseIOElement element)
			{
				if (element == null)
					return;
				int count = Integer.parseInt(element.getAttributeValue("count"));
				List<BaseIOElement> children = element.getChildren();
				if ((count != 0) && (children != null) && (children.size() == count))
					{
						Iterator<BaseIOElement> iterator = children.iterator();
						while (iterator.hasNext())
							{
								BaseIOElement property = iterator.next();
								BaseIOElement type = property.getChild("type");
								long DefaultID = EffectopediaObject.getDefaultID(type);
								if (DefaultID != EffectopediaObject.NON_DEFAULT)
									{
										// if (DefaultID > 0)
										// DefaultID = -DefaultID;
										EffectopediaObject eo = EffectopediaObject.getEffectopediaObjectByDefaultID(DefaultID);
										eo.updateExternalID(type);
									}
							}
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				element.setAttribute("count", String.valueOf(properties.size()));
				for (ObjectProperty p : properties.values())
					{
						BaseIOElement prop = io.newElement("property");
						p.store(prop, io);
						if (p.type.isDocumented())
							prop.setAttribute("documented", "true");
						element.addChild(prop);
					}
				return element;
			}
		
		public boolean hasData()
			{
				for (ObjectProperty p : properties.values())
					if ((p.valuesCount() > 1) || (!p.vu.generic))
						return true;
				return false;
			}
		
		public final ObjectPropertyTypesContainer getTypes()
			{
				return types;
			}
		
		public final EffectopediaObject getOwner()
			{
				return owner;
			}
		
		public final void setOwner(EffectopediaObject owner)
			{
				this.owner = owner;
				for (ObjectProperty p : properties.values())
					p.setOwner(owner);
			}
		
		public String DEBUG_getSummary()
			{
				StringBuilder sb = new StringBuilder();
				sb.append("\towner_id\t");
				sb.append(owner.DEBUG_getIDs());
				sb.append("\ttypes\t");
				sb.append(types.DEBUG_getIDs());
				sb.append("\tproperties count=\t");
				sb.append(properties.size());
				for (ObjectProperty p : properties.values())
					{
						sb.append("\tpropertiy class=\t");
						sb.append(p.getClass().getName());
						sb.append("\tpropertiy values count=\t");
						sb.append(p.valuesCount());
						sb.append("\tpropertiy values\t");
						sb.append(p.DEBUG_getSummary());
					}
				return sb.toString();
			}
		
		public String toString()
			{
				StringBuilder sb = new StringBuilder();
				sb.append("Object properties");
				if (types.size() > 0)
					{
						sb.append("(");
						sb.append(types.size());
						sb.append(")");
					}
				return sb.toString();
			}
		
		protected EffectopediaObject																																owner;
		protected LinkedHashMap<ObjectPropertyType, ObjectProperty>	properties;
		protected ObjectPropertyTypesContainer																						types;
		
	}

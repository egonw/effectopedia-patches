package org.qsari.effectopedia.ontologies;

import java.util.ArrayList;
import java.util.StringTokenizer;

import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.defaults.DefaultTextProperties;
import org.qsari.effectopedia.utils.MultiIndexSortedList;
import org.qsari.effectopedia.utils.ValueComparator;

public class OntologyInstances extends IndexedObject implements Importable, Exportable, Comparable<IndexedObject>
	{
		public OntologyInstances(OntologyClass type)
			{
				super();
				this.type = type;
				autoSetId();
				type.ontology.add(this);
				instanceIDs = new ArrayList<Long>();
			}
		
		public OntologyInstances(OntologyClass type, String name)
			{
				this(type);
				this.name = name;
			}
		
		public void setName(String name)
			{
				if (((name == null) && (this.name != null)) || (!name.equals(this.name)))
					{
						this.name = name;
					}
			}
		
		public String getName()
			{
				if (this.name == null)
					return DefaultTextProperties.INSTANCE.getDefault("Enzyme.name");
				else
					return this.name;
			}
		
		public void cloneFieldsTo(OntologyInstances clone)
			{
				super.cloneFieldsTo(clone);
				clone.name = this.name;
				for (Long enzymeID : this.instanceIDs)
					clone.instanceIDs.add(enzymeID);
			}
		
		public OntologyInstances clone()
			{
				OntologyInstances clone = new OntologyInstances(type);
				cloneFieldsTo(clone);
				return clone;
			}
		
		public String toString()
			{
				return getName();
			}
		
		public void add(OntologyInstance instance)
			{
				instanceIDs.add(instance.getID());
			}
		
		public OntologyInstance getInstance(int index)
			{
				if ((index >= 0) && (index < instanceIDs.size()))
					return type.ontology.getInstance(type, instanceIDs.get(index).intValue());
				else
					return null;
			}
		
		public long getOntologyInstanceID(int index)
			{
				if ((index >= 0) && (index < instanceIDs.size()))
					return instanceIDs.get(index);
				else
					return -1L;
			}
		
		public void setOntologyInstanceID(int index, long insatnceID)
			{
				if ((index >= 0) && (index < instanceIDs.size()))
					instanceIDs.set(index, insatnceID);
			}
		
		public int size()
			{
				return instanceIDs.size();
			}
		
		public void clear()
			{
				instanceIDs.clear();
			}
		
		public void set(OntologyInstance instance, int index)
			{
				instanceIDs.set(index, instance.getID());
			}
		
		public void remove(int index)
			{
				instanceIDs.remove(index);
			}
		
		public OntologyClass getType()
			{
				return type;
			}
		
		public void setType(OntologyClass type)
			{
				this.type = type;
			}
		
		public long autoId()
			{
				return type.collectionIDs++;
			}
		
		public static class InstancesNameComparator implements ValueComparator<OntologyInstances>
			{
				public int compare(OntologyInstances instance1, OntologyInstances instance2)
					{
						return instance1.getName().compareToIgnoreCase(instance2.getName());
					}
				
				public int compareToValue(OntologyInstances instance, Object value)
					{
						if (!(value instanceof String))
							throw new IllegalArgumentException("Illegal search type!");
						return instance.getName().compareToIgnoreCase((String) value);
					}
			}
		
		public static class InstancesIDComparator implements ValueComparator<OntologyInstances>
			{
				public int compare(OntologyInstances instance1, OntologyInstances instance2)
					{
						return (int) (instance1.getID() - instance2.getID());
					}
				
				public int compareToValue(OntologyInstances instance, Object value)
					{
						if (!(value instanceof Long))
							throw new IllegalArgumentException("Illegal search type!");
						return (int) (instance.getID() - (Long) value);
					}
			}
		
		public static MultiIndexSortedList<OntologyInstances> newMultiIndexSortedList()
			{
				ValueComparator<OntologyInstances>[] comparators = new ValueComparator[]
					{ new InstancesIDComparator(), new InstancesNameComparator() };
				return new MultiIndexSortedList<OntologyInstances>(comparators);
			}
		
		public final Object getParent()
			{
				return parent;
			}

		public final void setParent(Object parent)
			{
				this.parent = parent;
			}

		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						name = element.getValueElement("name").getValue();
						BaseIOElement e = element.getChild("enzyme_ids");
						if (e != null)
							{
								int count = Integer.parseInt(e.getAttributeValue("count"));
								if (count != 0)
									{
										instanceIDs.clear();
										instanceIDs.ensureCapacity(count);
										StringTokenizer idsArray = new StringTokenizer(e.getValue(), " ");
										while (idsArray.hasMoreTokens())
											{
												instanceIDs.add(Long.parseLong(idsArray.nextToken().trim()));
											}
									}
							}
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addValueElement(io.newValue("name").setValue(name));
				int count = instanceIDs.size();
				BaseIOElement e = io.newElement("enzyme_ids");
				e.setAttribute("count", Integer.toString(count));
				if (count != 0)
					{
						StringBuilder idsArray = new StringBuilder();
						for (Long enzymeID : instanceIDs)
							{
								idsArray.append(enzymeID);
								idsArray.append(' ');
							}
						e.setValue(idsArray.toString());
					}
				element.addChild(e);
				return element;
			}

		protected String										name;
		protected ArrayList<Long>	instanceIDs;
		protected OntologyClass			type;
		protected Object										parent;
	}

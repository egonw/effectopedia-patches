package org.qsari.effectopedia.ontologies;

import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.defaults.DefaultTextProperties;
import org.qsari.effectopedia.utils.MultiIndexSortedList;
import org.qsari.effectopedia.utils.ValueComparator;

public class OntologyInstance extends IndexedObject implements Importable, Exportable, Cloneable
	{
		public OntologyInstance(OntologyClass type)
			{
				super();
				this.type = type;
				autoSetId();
				type.ontology.add(this);
			}
		
		public OntologyInstance(OntologyClass type, String name)
			{
				super();
				this.name = name;
				this.type = type;
				autoSetId();
				type.ontology.add(this);
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
					return DefaultTextProperties.INSTANCE.getDefault(type.getName() + ".name");
				else
					return this.name;
			}
		
		public void cloneFieldsTo(OntologyInstance clone)
			{
				clone = this;
			}
		
		public OntologyInstance clone()
			{
				return this;
			}
		
		public String toString()
			{
				return getName();
			}
		
		public long autoId()
			{
				return type.instanceIDs++;
			}
		
		public static class InstanceNameComparator implements ValueComparator<OntologyInstance>
			{
				public int compare(OntologyInstance instance1, OntologyInstance instance2)
					{
						return instance1.getName().compareToIgnoreCase(instance2.getName());
					}
				
				public int compareToValue(OntologyInstance instance, Object value)
					{
						if (!(value instanceof String))
							throw new IllegalArgumentException("Illegal search boundaries!");
						return instance.getName().compareToIgnoreCase((String) value);
					}
			}
		
		public static class InstanceIDComparator implements ValueComparator<OntologyInstance>
			{
				public int compare(OntologyInstance instance1, OntologyInstance instance2)
					{
						return (int) (instance1.getID() - instance2.getID());
					}
				
				public int compareToValue(OntologyInstance instance, Object value)
					{
						if (!(value instanceof Long))
							throw new IllegalArgumentException("Illegal search boundaries!");
						return (int) (instance.getID() - (Long) value);
					}
			}
		
		public static MultiIndexSortedList<OntologyInstance> newMultiIndexSortedList()
			{
				ValueComparator<OntologyInstance>[] comparators = new ValueComparator[] {new InstanceIDComparator(), new InstanceNameComparator()};
				return new MultiIndexSortedList<OntologyInstance>(comparators);
			}

		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						// TODO Implement individual loading
						
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				BaseIOElement individual = io.newElement("Individual");
				individual.setAttribute("name", name);
				individual.addChild(io.newElement("Type").setAttribute("name", type.getName()));
				element.addChild(individual);
				return element;
			}

		protected String								name;
		protected OntologyClass	type;
	}

package org.qsari.effectopedia.ontologies;

import java.util.HashMap;

import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.defaults.DefaultTextProperties;
import org.qsari.effectopedia.utils.MultiIndexSortedList;
import org.qsari.effectopedia.utils.SortedList;
import org.qsari.effectopedia.utils.ValueComparator;

public class Ontology extends IndexedObject implements Importable, Exportable
	{
		public Ontology()
			{
				super();
				classes = new HashMap<String, OntologyClass>();
				instances = new HashMap<OntologyClass, MultiIndexSortedList<OntologyInstance>>();
				collections = new HashMap<OntologyClass, MultiIndexSortedList<OntologyInstances>>();
			}
		
		public Ontology(String name)
			{
				this();
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
					return DefaultTextProperties.INSTANCE.getDefault("Ontology.name");
				else
					return this.name;
			}
		
		public void cloneFieldsTo(Ontology clone)
			{
				super.cloneFieldsTo(clone);
				clone.name = this.name;
				// TODO
			}
		
		public Ontology clone()
			{
				Ontology clone = new Ontology();
				cloneFieldsTo(clone);
				return clone;
			}
		
		public String toString()
			{
				return getName();
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						// TODO Implement import from OWL XML format
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				// TODO Implement export in OWL XML format
				return element;
			}

		public void add(OntologyClass ontologyClass)
			{
				classes.put(ontologyClass.getName(), ontologyClass);
				instances.put(ontologyClass, new MultiIndexSortedList<OntologyInstance>(new ValueComparator[]{new OntologyInstance.InstanceNameComparator()}));
				collections.put(ontologyClass, new MultiIndexSortedList<OntologyInstances>(new ValueComparator[]{new OntologyInstances.InstancesNameComparator()}));
			}
		
		public void add(OntologyInstance ontologyInstance)
			{
				MultiIndexSortedList<OntologyInstance> classInstances = instances.get(ontologyInstance.type);
				if (classInstances != null)
					classInstances.add(ontologyInstance);
			}
		
		public void add(OntologyInstances ontologyInstances)
			{
				MultiIndexSortedList<OntologyInstances> classInstances = collections.get(ontologyInstances.type);
				if (classInstances != null)
					classInstances.add(ontologyInstances);
			}
		
		public OntologyClass getOntologyClass(String name)
			{
				return classes.get(name);
			}
		
		public OntologyInstance getInstance(OntologyClass ontologyClass, long id)
			{
				MultiIndexSortedList<OntologyInstance> classInstances = instances.get(ontologyClass);
				if (classInstances != null)
					return (id >= 0) ? classInstances.get((int)id) : null;
				else
					return null;
			}
		
		public OntologyInstance getInstance(OntologyClass ontologyClass, String name)
			{
				SortedList<OntologyInstance> classInstances = instances.get(ontologyClass).getList(NameIndex);
				if (classInstances != null)
					{
						int index = classInstances.indexOf(name);
						return (index >= 0) ? classInstances.get(index) : null;
					}
				else
					return null;
			}
		
		public SortedList<OntologyInstance> getAllOntologyInstances(OntologyClass ontologyClass)
			{
				return instances.get(ontologyClass).getList(NameIndex);
			}
		
		public SortedList<OntologyInstances> getAllOntologyInstanceCollections(OntologyClass ontologyClass)
			{
				return collections.get(ontologyClass).getList(NameIndex);
			}
		
		public long autoId()
			{
				return ontologyIDs++;
			}
		
		public static final int																																																			NameIndex			= 0;
		
		protected String																																																										name;
		protected static long																																																					ontologyIDs	= 0;
		protected HashMap<String, OntologyClass>																																		classes;
		protected HashMap<OntologyClass, MultiIndexSortedList<OntologyInstance>>		instances;
		protected HashMap<OntologyClass, MultiIndexSortedList<OntologyInstances>>	collections;
	}

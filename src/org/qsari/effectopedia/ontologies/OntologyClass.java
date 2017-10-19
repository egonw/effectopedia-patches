package org.qsari.effectopedia.ontologies;

import java.util.ArrayList;

import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.defaults.DefaultTextProperties;

public class OntologyClass extends IndexedObject implements Importable, Exportable, Cloneable
	{
		public OntologyClass(Ontology ontology)
			{
				super();
				autoSetId();
				this.ontology = ontology;
				ontology.add(this);
			}
		
		public OntologyClass(Ontology ontology, String name)
			{
				super();
				autoSetId();
				this.ontology = ontology;
				this.name = name;
				ontology.add(this);
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
		
		public void cloneFieldsTo(OntologyClass clone)
			{
				clone = this;
			}
		
		public OntologyClass clone()
			{
				return this;
			}
		
		public String toString()
			{
				return getName();
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						name = element.getChildValue("name");
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				BaseIOElement cl = io.newElement("Class");
				cl.setAttribute("name", name);
				element.addChild(cl);
				return element;
			}

		public Ontology getOntology()
			{
				return ontology;
			}
		
		public void setOntology(Ontology ontology)
			{
				this.ontology = ontology;
			}
		
		public ArrayList<OntologyInstance> getAllOntologyInstances()
			{
				return ontology.getAllOntologyInstances(this);
			}
		
		public ArrayList<OntologyInstances> getAllOntologyInstanceCollections()
			{
				return ontology.getAllOntologyInstanceCollections(this);
			}
		
		public OntologyInstance getInstance(String name)
			{
				return ontology.getInstance(this, name);
			}
				
		public long autoId()
			{
				return ontologyClassIDs++;
			}
		
		protected String						name;
		protected long								instanceIDs						= 0;
		protected long								collectionIDs				= 0;
		
		protected Ontology				ontology;
		protected static long	ontologyClassIDs	= 0;
		
	}

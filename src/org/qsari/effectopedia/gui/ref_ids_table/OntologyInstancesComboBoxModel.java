package org.qsari.effectopedia.gui.ref_ids_table;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import org.qsari.effectopedia.ontologies.OntologyClass;
import org.qsari.effectopedia.ontologies.OntologyInstances;

public class OntologyInstancesComboBoxModel extends DefaultComboBoxModel<OntologyInstances>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public OntologyInstancesComboBoxModel(OntologyClass ontologyClass)
			{
				this.ontologyClass = ontologyClass;
				if (ontologyClass != null)
					list =  ontologyClass.getAllOntologyInstanceCollections();
				else
					list = null;
			}
		
		@Override
		public OntologyInstances getElementAt(int index)
			{
				return (OntologyInstances) ((list != null) ? list.get(index) : 0);
			}
		
		@Override
		public int getSize()
			{
				return (list != null) ? list.size() : 0;
			}
		
		public void setOntologyClass(OntologyClass ontologyClass)
			{
				this.ontologyClass = ontologyClass;
				if (ontologyClass != null)
					list = ontologyClass.getAllOntologyInstanceCollections();
				else
					list = null;
			}
		
		public void select(OntologyInstances ontologyInstances)
			{
				setSelectedItem(ontologyInstances);
			}
		
		protected OntologyClass																ontologyClass;
		protected ArrayList<OntologyInstances>	list;
		
	}

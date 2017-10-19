package org.qsari.effectopedia.gui.ref_ids_table;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import org.qsari.effectopedia.ontologies.OntologyClass;
import org.qsari.effectopedia.ontologies.OntologyInstance;
import org.qsari.effectopedia.ontologies.OntologyInstances;

public class OntologyInstanceComboBoxModel extends DefaultComboBoxModel
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public OntologyInstanceComboBoxModel(OntologyClass ontologyClass, boolean readonly)
			{
				this.ontologyClass = ontologyClass;
				if (ontologyClass != null)
					list =  ontologyClass.getAllOntologyInstances();
				else
					list = null;
				this.readonly = readonly;
			}
		
		@Override
		public Object getElementAt(int index)
			{
				return (list != null) ? list.get(index) : 0;
			}
		
		@Override
		public int getSize()
			{
				return (list != null) ? list.size() : 0;
			}
		
		public void setOntologyClass(OntologyClass ontologyClass)
			{
				if (readonly)
					return;
				this.ontologyClass = ontologyClass;
				if (ontologyClass != null)
					list = ontologyClass.getAllOntologyInstances();
				else
					list = null;
			}
		
		public void select(OntologyInstances ontologyInstances)
			{
				setSelectedItem(ontologyInstances);
			}
		
		protected OntologyClass																ontologyClass;
		protected ArrayList<OntologyInstance>	list;
		private final boolean readonly;
	}

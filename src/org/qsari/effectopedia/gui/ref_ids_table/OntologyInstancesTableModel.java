package org.qsari.effectopedia.gui.ref_ids_table;

import javax.swing.table.AbstractTableModel;

import org.qsari.effectopedia.defaults.DefaultOntologies;
import org.qsari.effectopedia.ontologies.OntologyClass;
import org.qsari.effectopedia.ontologies.OntologyInstance;
import org.qsari.effectopedia.ontologies.OntologyInstances;

public class OntologyInstancesTableModel extends AbstractTableModel
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 11618547003001996L;
		
		public OntologyInstancesTableModel(OntologyInstances ontologyInstances)
			{
				this.ontologyInstances = ontologyInstances;
				this.ontologyClass = (ontologyInstances == null) ? null : ontologyInstances.getType();
			}
		
		@Override
		public int getColumnCount()
			{
				return 1;
			}
		
		@Override
		public int getRowCount()
			{
				return (ontologyInstances != null) ? ontologyInstances.size() : 0;
			}
		
		public void addRow(Object aValue)
			{
				if (ontologyInstances != null)
					{
						OntologyInstance instance;
						if (aValue != null)
							{
								instance = ontologyClass.getOntology().getInstance(ontologyClass, (String) aValue);
								if (instance == null)
									instance = new OntologyInstance(ontologyInstances.getType(), (String) aValue);
							}
						else
							instance = DefaultOntologies.defaultInstance.get(ontologyInstances.getType());
						ontologyInstances.add(instance);
						int index = getRowCount() - 1;
						fireTableRowsInserted(index, index);
					}
			}
		
		public void removeRow(int rowIndex)
			{
				if (ontologyInstances != null)
					{
						ontologyInstances.remove(rowIndex);
						fireTableRowsDeleted(rowIndex, rowIndex);
					}
			}
		
		public void reset()
			{
				if (ontologyInstances != null)
					{
						int count = getRowCount() - 1;
						ontologyInstances.clear();
						fireTableRowsDeleted(0, count);
					}
			}
		
		public OntologyInstances getOntologyInstances()
			{
				return ontologyInstances;
			}
		
		public void setOntologyInstances(OntologyInstances ontologyInstances)
			{
				this.ontologyInstances = ontologyInstances;
				this.ontologyClass = (ontologyInstances == null) ? null : ontologyInstances.getType();
				fireTableDataChanged();
			}
		
		public Object getObjectAt(int rowIndex, int columnIndex)
			{
				return (ontologyInstances != null) ? ontologyInstances.getInstance(rowIndex) : null;
			}
		
		public void setObjectAt(Object aValue, int rowIndex, int columnIndex)
			{
				if (ontologyInstances != null)
					{
						OntologyInstance instance = ontologyClass.getOntology().getInstance(ontologyClass, (String) aValue);
						if (instance == null)
							instance = new OntologyInstance(ontologyInstances.getType(), (String) aValue);
						ontologyInstances.set(instance, rowIndex);
						fireTableCellUpdated(rowIndex, columnIndex);
					}
			}
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex)
			{
				if (ontologyInstances != null)
					return ontologyInstances.getInstance(rowIndex);
				else
					return null;
			}
		
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex)
			{
				if (ontologyInstances != null)
					{
					 ontologyInstances.set(ontologyClass.getInstance(aValue.toString()), rowIndex);
						fireTableCellUpdated(rowIndex, columnIndex);
					}
			}
		
		public void addValue(Object aValue)
			{
				if (ontologyInstances != null)
					{
						OntologyInstance instance = ontologyClass.getOntology().getInstance(ontologyClass, (String) aValue);
						if (instance == null)
							instance = new OntologyInstance(ontologyClass, (String) aValue);
						ontologyInstances.add(instance);
					}
			}
		
		public boolean isCellEditable(int rowIndex, int columnIndex)
			{
				return true;
			}
		
		protected OntologyInstances	ontologyInstances;
		protected OntologyClass					ontologyClass;
		
	}

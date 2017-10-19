package org.qsari.effectopedia.gui.ref_ids_table;

import javax.swing.table.AbstractTableModel;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.ids.ReferenceIDs;

public class ReferenceIDsTableModel<E extends EffectopediaObject> extends AbstractTableModel
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= -4173253249138078762L;

		public ReferenceIDsTableModel()
			{
				this.referenceIDs = null;
				this.readonly = true;
			}
		
		public ReferenceIDsTableModel(ReferenceIDs<E> referenceIDs, boolean readonly)
			{
				this.referenceIDs = referenceIDs;
				this.readonly = readonly;
			}
		
		@Override
		public int getColumnCount()
			{
				return 1;
			}
		
		@Override
		public int getRowCount()
			{
				return (referenceIDs != null) ? referenceIDs.size() : 0;
			}
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex)
			{
				return (referenceIDs != null) ? referenceIDs.getCachedObject(rowIndex) : null;
			}
		
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex)
			{
				if (readonly)
					return;
				if (referenceIDs != null)
					{
						referenceIDs.set(aValue, rowIndex);
						fireTableCellUpdated(rowIndex, columnIndex);
					}
			}
		
		public boolean isCellEditable(int rowIndex, int columnIndex)
			{
				return editable;
			}
		
		public Object getObjectAt(int rowIndex, int columnIndex)
			{
				return (referenceIDs != null) ? referenceIDs.getCachedObject(rowIndex) : null;
			}
		
		public void setObjectAt(Object aValue, int rowIndex, int columnIndex)
			{
				if (readonly)
					return;
				if (referenceIDs != null)
					{
						referenceIDs.set(aValue, rowIndex);
						fireTableCellUpdated(rowIndex, columnIndex);
					}
			}
		
		public void addRow(Object aValue)
			{
				if (readonly)
					return;
				if ((referenceIDs != null) && (aValue != null))
					{
						referenceIDs.add(aValue);
						int index = getRowCount() - 1;
						fireTableRowsInserted(index, index);
					}
			}
		
		public void removeRow(int rowIndex)
			{
				if (readonly)
					return;
				if (referenceIDs != null)
					{
						referenceIDs.remove(rowIndex);
						fireTableRowsDeleted(rowIndex, rowIndex);
					}
			}
		
		public void reset()
			{
				if (readonly)
					return;
				if (referenceIDs != null)
					{
						int count = getRowCount() - 1;
						referenceIDs.clear();
						fireTableRowsDeleted(0, count);
					}
			}
		
		public ReferenceIDs<E> getReferenceIDs()
			{
				return referenceIDs;
			}
		
		public void setReferenceIDs(ReferenceIDs<E> referenceIDs, boolean readonly)
			{
				this.referenceIDs = referenceIDs;
				this.readonly = readonly;
				fireTableDataChanged();
			}
		
		public final boolean isEdiable()
			{
				return editable;
			}
		
		public final void setEdiable(boolean ediable)
			{
				this.editable = ediable;
			}
		
		public boolean												readonly;
		protected ReferenceIDs<E>	referenceIDs;
		protected boolean									editable	= true;
	}

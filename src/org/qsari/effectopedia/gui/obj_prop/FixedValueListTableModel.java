package org.qsari.effectopedia.gui.obj_prop;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.table.AbstractTableModel;

import org.qsari.effectopedia.data.objects.FixedValuesList;
import org.qsari.effectopedia.gui.core.ClipboardTransferableUI;
import org.qsari.effectopedia.gui.util.ClipboardUtilities;

public class FixedValueListTableModel extends AbstractTableModel implements ClipboardTransferableUI
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= -4173253249138078762L;
		
		public FixedValueListTableModel()
			{
				this.fixedValuesList = null;
				this.theList = null;
				this.readonly = true;
			}
		
		public FixedValueListTableModel(FixedValuesList fixedValuesList, boolean readonly)
			{
				this.fixedValuesList = fixedValuesList;
				this.theList = fixedValuesList.getList();
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
				return (theList != null) ? theList.size() : 0;
			}
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex)
			{
				return (theList != null) ? theList.get(rowIndex) : null;
			}
		
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex)
			{
				if (readonly)
					return;
				if (theList != null)
					{
						theList.add(rowIndex, aValue.toString());
						fireTableCellUpdated(rowIndex, columnIndex);
					}
			}
		
		public boolean isCellEditable(int rowIndex, int columnIndex)
			{
				return !readonly;
			}
		
		public Object getObjectAt(int rowIndex, int columnIndex)
			{
				return (theList != null) ? theList.get(rowIndex) : null;
			}
		
		public void setObjectAt(Object aValue, int rowIndex, int columnIndex)
			{
				if (readonly)
					return;
				if (theList != null)
					{
						theList.add(rowIndex, aValue.toString());
						fireTableCellUpdated(rowIndex, columnIndex);
					}
			}
		
		public void add(Object aValue)
			{
				if (readonly)
					return;
				if ((theList != null) && (aValue != null))
					{
						theList.add(aValue.toString());
						int index = getRowCount() - 1;
						fireTableRowsInserted(index, index);
					}
			}
		
		public void remove(int rowIndex)
			{
				if (readonly)
					return;
				if (theList != null)
					{
						theList.remove(rowIndex);
						fireTableRowsDeleted(rowIndex, rowIndex);
					}
			}
		
		public void reset()
			{
				if (readonly)
					return;
				if (theList != null)
					{
						int count = getRowCount() - 1;
						theList.clear();
						fireTableRowsDeleted(0, count);
					}
			}
		
		public FixedValuesList getFixedValuesList()
			{
				return fixedValuesList;
			}
		
		public void setFixedValuesList(FixedValuesList fixedValuesList)
			{
				this.fixedValuesList = fixedValuesList;
				this.theList = (fixedValuesList != null) ? fixedValuesList.getList() : null;
				fireTableDataChanged();
			}
		
		@Override
		public void copy()
			{
				if (theList != null)
					{
						StringBuilder sb = new StringBuilder();
						for (String value : theList)
							{
								sb.append(value);
								sb.append("\n");
							}
						ClipboardUtilities.setClipboard(sb.toString());
					}
			}
		
		@Override
		public void paste()
			{
				if (theList != null)
					{
						StringTokenizer st = new StringTokenizer(ClipboardUtilities.getClipboard(), "\n");
						while (st.hasMoreTokens())
							theList.add(st.nextToken());
					}
			}
		
		public boolean isReadonly()
			{
				return readonly;
			}

		public void setReadonly(boolean readonly)
			{
				this.readonly = readonly;
			}

		public boolean														readonly;
		protected FixedValuesList			fixedValuesList;
		protected ArrayList<String>	theList;
	}

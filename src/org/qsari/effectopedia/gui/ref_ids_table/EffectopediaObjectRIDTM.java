package org.qsari.effectopedia.gui.ref_ids_table;

import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Titleable;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.gui.UIResources;

public class EffectopediaObjectRIDTM<E extends EffectopediaObject> extends ReferenceIDsTableModel<E>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 0L;
		
		public EffectopediaObjectRIDTM(ReferenceIDs<E> referenceIDs, boolean readonly)
			{
				super(referenceIDs, readonly);
			}
		
		@Override
		public int getColumnCount()
			{
				return columnCount;
			}
		
		public void updateColumnWidths(JTable table)
			{
				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				Enumeration<TableColumn> columns = table.getColumnModel().getColumns();
				while (columns.hasMoreElements())
					{
						TableColumn column = columns.nextElement();
						int columnIndex = column.getModelIndex();
						column.setMaxWidth((columnIndex == 0) ? 24 : Integer.MAX_VALUE);
					}
			}
		
		public Class<?> getColumnClass(int columnIndex)
			{
				if (columnIndex == 0)
					return ImageIcon.class;
				else
					return String.class;
			}
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex)
			{
				Object eo = getObjectAt(rowIndex, columnIndex);
				if ((eo instanceof Titleable) && (eo != null))
					return ((Titleable) eo).getTitle();
				else
					return eo;
			}
		
		public Object getObjectAt(int rowIndex, int columnIndex)
			{
				EffectopediaObject eo = ((ReferenceIDs<E>) referenceIDs).getCachedObject(rowIndex);
				return (columnIndex == 0) ? UIResources.getIconForClass(eo.getClass()) : eo;
			}
		
		public EffectopediaObject getEffectopediaObjectAt(int rowIndex, int columnIndex)
			{
				return ((ReferenceIDs<E>) referenceIDs).getCachedObject(rowIndex);
			}
		
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex)
			{
			}
		
		public void addValue(Object aValue)
			{
			}
		
		public boolean isHorizontalPlacement()
			{
				return horizontalPlacement;
			}
		
		public void setHorizontalPlacement(boolean horizontalPlacement)
			{
				this.horizontalPlacement = horizontalPlacement;
			}
		
		protected int					columnCount									= 2;
		protected boolean	horizontalPlacement	= true;
	}

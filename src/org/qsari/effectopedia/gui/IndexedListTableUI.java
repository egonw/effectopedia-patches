package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.qsari.effectopedia.base.Stringable;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.core.ManageableIndexedListUI;

public abstract class IndexedListTableUI<R extends LoadableEditorUI & Stringable & CacheableEditorUI> extends javax.swing.JScrollPane implements AdjustableUI, ManageableIndexedListUI<R>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public IndexedListTableUI(String[] columnNames, String[] fieldNames)
			{
				super();
				this.columnNames = columnNames;
				this.fieldNames = fieldNames;
				list = new ArrayList<R>();
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						jtContent = new JTable();
						this.getViewport().setBackground(Color.white);
						tableModel = new DefaultTableModel(columnNames, 0);
						this.setViewportView(jtContent);
						jtContent.setModel(tableModel);
						jtContent.putClientProperty("terminateEditOnFocusLost", true);
						jtContent.addFocusListener(new UpdateModifiedRows());
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		class UpdateModifiedRows implements FocusListener
			{
				
				@Override
				public void focusGained(FocusEvent arg0)
					{
					}
				
				@Override
				public void focusLost(FocusEvent arg0)
					{
						if (list != null)
							for (ListIterator<R> iterator = list.listIterator(); iterator.hasNext();)
								iterator.next().updateObject();
					}
				
			}
		
		public abstract R add(boolean enableSelectionDialog);
		
		public void add(R row)
			{
				list.add(row);
				tableModel.addRow(row.getValues());
				if (ids != null)
					row.load(ids.addNew(), false);
			}
		
		public void remove()
			{
				if (jtContent.getRowSelectionAllowed())
					{
						int[] rowIndices = jtContent.getSelectedRows();
						for (int i = rowIndices.length - 1; i >= 0; i--)
							remove(rowIndices[i]);
					}
				else if (jtContent.getCellSelectionEnabled())
					{
						int rowIndex = jtContent.getSelectedRow();
						remove(rowIndex);
					}
			}
		
		public void remove(int rowIndex)
			{
				if ((rowIndex >= 0) && (rowIndex <= list.size()))
					{
						list.remove(rowIndex);
						tableModel.removeRow(rowIndex);
					}
			}
		
		public void reset()
			{
				list.clear();
				for (int rowIndex = jtContent.getRowCount() - 1; rowIndex >= 0; rowIndex--)
					tableModel.removeRow(rowIndex);
				if (ids != null)
					ids.clear();
				jtContent.revalidate();
			}
		
		public int getActiveListIndex()
			{
				return jtContent.getSelectedRow();
			}
		
		public ReferenceIDs<?> getIDs()
			{
				return ids;
			}
		
		/**
		 * Set <code>this.indexedList</code> to a new list and updates the user
		 * interface to reflect the content of the new list. All panels P implement
		 * <code>LoadableEditorUI</code> and are loaded form the elements of the new
		 * indexedList
		 * 
		 * @see LoadableEditorUI
		 * 
		 * @param IDs
		 *         <?> an <code>IDs<?></code> that specifies the list of indexed
		 *         objects to be edited in the IndexedObjectListUI
		 */
		public void setIndexedList(ReferenceIDs<?> ids, boolean readonly)
			{
				list.clear();
				this.ids = null;
				while (tableModel.getRowCount() > 0)
					tableModel.removeRow(0);
				for (int index = 0; index < ids.size(); index++)
					add(false).load(ids.getCachedObject(index), readonly);
				this.ids = ids;
				// updateOptimalSize();
			}
		
		/**
		 * Adjust <code>visible</code> properties to the current and the contained
		 * components
		 * 
		 * @see AdjustableUI
		 * 
		 * @param visualOptions
		 *         an long that specifies which of the contained components are
		 *         visible
		 */
		public void adjustUI(long visualOptions)
			{
				AdjustbleUserInterfaceTools.adjustChildren(this, visualOptions);
			}
		
		protected String[]								columnNames;
		protected String[]								fieldNames;
		private ReferenceIDs<?>			ids;
		private JTable												jtContent;
		private DefaultTableModel	tableModel;
		private ArrayList<R>						list;
		
	}

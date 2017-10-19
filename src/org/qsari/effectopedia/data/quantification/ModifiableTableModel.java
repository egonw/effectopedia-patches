package org.qsari.effectopedia.data.quantification;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.qsari.effectopedia.gui.comp.custom_table_header.ColumnGroup;
import org.qsari.effectopedia.gui.comp.custom_table_header.TableHeaderEditorManager;

public interface ModifiableTableModel extends TableModel
	{
		public void addRow();
		
		public void removeRow(int index);
		
		public void removeAll();
		
		public ColumnGroup createHeader(JTable inTable, TableHeaderEditorManager manager);
		
		public String getDataAsTabDelimitedText();
		
		public void setDataFromTabDelimitedText(String text);
		
	}

package org.qsari.effectopedia.gui.util;

import java.awt.Component;
import java.util.Enumeration;
import java.util.HashMap;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class TableCellComponentGrid extends AbstractCellEditor implements TableCellRenderer, TableCellEditor
	{
		/**
	 * 
	 */
		private static final long																						serialVersionUID	= 1L;
		protected TableCellRenderer																				defaultRenderer;
		protected TableCellComponent																			activeEditor;
		protected HashMap<Integer, TableCellComponent>	customCellComponents;
		protected final int																												rowCount;
		protected final int																												columnCount;
		protected final JTable																									table;
		protected final JTextField																					defaultEditor;
		
		public TableCellComponentGrid(final JTable table, final int rowCount, final int columnCount)
			{
				super();
				defaultEditor = new JTextField();
				defaultRenderer = new DefaultTableHeaderCellRenderer();
				this.rowCount = rowCount;
				this.columnCount = columnCount;
				this.table = table;
				install();
				customCellComponents = new HashMap<Integer, TableCellComponent>();
			}
		
		public void install()
			{
				table.setCellEditor(this);
				Enumeration<TableColumn> columns = table.getColumnModel().getColumns();
				while (columns.hasMoreElements())
					((TableColumn) columns.nextElement()).setHeaderRenderer(this);
			}
		
		public void uninstall()
			{
				table.setCellEditor(new DefaultCellEditor(defaultEditor));
				Enumeration<TableColumn> columns = table.getColumnModel().getColumns();
				table.getTableHeader().setDefaultRenderer(defaultRenderer);
				while (columns.hasMoreElements())
					((TableColumn) columns.nextElement()).setHeaderRenderer(defaultRenderer);
				
			}
		
		public void addCustomCellComponent(int row, int column, TableCellComponent component)
			{
				customCellComponents.put((Integer.valueOf(row * columnCount + column)), component);
			}
		
		public void removeCustomCellComponent(int row, int column)
			{
				customCellComponents.remove((Integer.valueOf(row * columnCount + column)));
			}
		
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
			{
				TableCellComponent renderer = customCellComponents.get(Integer.valueOf(row * columnCount + column));
				if (renderer == null)
					return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				return (Component) ((renderer == null) ? defaultRenderer : renderer);
			}
		
		@Override
		public Object getCellEditorValue()
			{
				return defaultEditor.getText();
			}
		
		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
			{
				System.out.println("getCellEditor()");
				activeEditor = customCellComponents.get(Integer.valueOf(row * columnCount + column));
				if (activeEditor == null)
					return defaultEditor;
				else
					return (Component) activeEditor.setCellEditorValue(value);
				
			}
	}

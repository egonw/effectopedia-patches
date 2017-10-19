package org.qsari.effectopedia.gui.comp.custom_table_header;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

// original from http://stackoverflow.com/questions/21347647/how-to-combine-two-column-headers-in-jtable-in-swings
public class GroupableHeaderTest extends JFrame
	{
		public JTable table;
	
		GroupableHeaderTest()
			{
				super("Groupable Header Example");
				
				
				DefaultTableModel dm = new DefaultTableModel();
				dm.setDataVector(new Object[][]
					{
						{ "1", "3", "1", "6", "1", "2.3" },
						{ "2", "4", "1", "12", "2", "4.6" },
						{ "3", "5", "1", "18", "3", "7.2" },
						{ "4", "6", "1", "24", "4", "9.6" } }, new Object[]
					{ "units.", "mean", "SEM", "mean", "SEM", "STDIV" });
				
				 table = new JTable(dm)
					{
						protected JTableHeader createDefaultTableHeader()
							{
								return new GroupableTableHeader(columnModel);
							}
					};
				
				TableColumnModel cm = table.getColumnModel();
				ColumnGroup g_title = new ColumnGroup("Response measurment title (double click to edit)");
				
				ColumnGroup g_tchem = new ColumnGroup("Tested Chemical\n[log(mol)]\nwater", new MultiLineTableHeaderRenderer());
				g_tchem.add(cm.getColumn(1));
				g_tchem.add(cm.getColumn(2));
				ColumnGroup g_rchem = new ColumnGroup("Reference Chemical");
				g_rchem.add(cm.getColumn(3));
				ColumnGroup g_error = new ColumnGroup("Error measures", new DefaultTableHeaderRenderer());
				g_error.add(cm.getColumn(4));
				g_error.add(cm.getColumn(5));
				g_rchem.add(g_error);
				g_title.add(cm.getColumn(0));
				g_title.add(g_tchem);
				g_title.add(g_rchem);

				TableHeaderEditorManager manager = new TableHeaderEditorManager(table);
				JComboBox<String> ttt =  new JComboBox<String>(new String[] {"One","two"});
				DefaultTableHeaderEditor editor = new DefaultTableHeaderEditor();
				editor.add(ttt);
				manager.setEditor(g_error, editor);
				GroupableTableHeader header = (GroupableTableHeader) table.getTableHeader();
				header.addColumnGroup(g_title);
				JScrollPane scroll = new JScrollPane(table);
				getContentPane().add(scroll);
				setSize(400, 120);
				
				// allow sorting
				// TODO: add filter
				// RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(dm);
				// table.setRowSorter(sorter);
				
				/*
				 * final TableFilterHeader filterHeader = new TableFilterHeader(header);
				 * 
				 * JViewport headerViewport = new JViewport() {
				 * 
				 * @Override public void setView(Component view) { if (view instanceof
				 * JTableHeader) { filterHeader.add(view, BorderLayout.NORTH);
				 * super.setView(filterHeader); } }
				 * 
				 * };
				 * 
				 * scroll.setColumnHeader(headerViewport);
				 */
				

			}
		
		public static void main(String[] args)
			{
				GroupableHeaderTest frame = new GroupableHeaderTest();
				frame.setSize(1024, 768);
				frame.addWindowListener(new WindowAdapter()
					{
						public void windowClosing(WindowEvent e)
							{
								System.exit(0);
							}
					});
				frame.setVisible(true);
			}
	}
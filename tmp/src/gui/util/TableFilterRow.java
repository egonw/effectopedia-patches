package org.qsari.effectopedia.gui.comp.custom_table_header;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.TableColumnModel;

// code based on posts by @camickr     
// http://stackoverflow.com/questions/26860204/multiple-editable-rows-in-jtable-header/26861494#26861494

public class TableFilterRow extends JPanel implements TableColumnModelListener
	{
		
		private JTable	table	= new JTable(3, 5);
		
		public TableFilterRow(JTable table)
			{
				this.table = table;
				table.setPreferredScrollableViewportSize(table.getPreferredSize());
				table.getColumnModel().addColumnModelListener(this);
				setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
				for (int i = 0; i < table.getColumnCount(); i++)
					{
						JTextField tf = new JTextField();
						tf.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
						tf.setBackground(Color.yellow);
						add(tf);
					}
				columnMarginChanged(new ChangeEvent(table.getColumnModel()));
				
			}
		
		// Implement TableColumnModelListener methods
		// (Note: instead of implementing a listener you should be able to
		// override the columnMarginChanged and columMoved methods of JTable)
		@Override
		public void columnMarginChanged(ChangeEvent e)
			{
				TableColumnModel tcm = table.getColumnModel();
				int columns = tcm.getColumnCount();
				
				for (int i = 0; i < columns; i++)
					{
						JTextField textField = (JTextField) getComponent(i);
						Dimension d = textField.getPreferredSize();
						d.width = tcm.getColumn(i).getWidth();
						textField.setPreferredSize(d);
					}
				
				SwingUtilities.invokeLater(new Runnable()
					{
						@Override
						public void run()
							{
								revalidate();
							}
					});
			}
		
		@Override
		public void columnMoved(TableColumnModelEvent e)
			{
				Component moved = getComponent(e.getFromIndex());
				remove(e.getFromIndex());
				add(moved, e.getToIndex());
				validate();
			}
		
		@Override
		public void columnAdded(TableColumnModelEvent e)
			{
			}
		
		@Override
		public void columnRemoved(TableColumnModelEvent e)
			{
			}
		
		@Override
		public void columnSelectionChanged(ListSelectionEvent e)
			{
			}
		
	}
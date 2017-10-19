package org.qsari.effectopedia.gui.comp.custom_table_header;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

public class MultiLineTableHeaderRenderer extends JList<String> implements TableCellRenderer
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public MultiLineTableHeaderRenderer()
			{
				setOpaque(true);
				setForeground(UIManager.getColor("TableHeader.foreground"));
				setBackground(UIManager.getColor("TableHeader.background"));
				setBorder(UIManager.getBorder("TableHeader.cellBorder"));
				ListCellRenderer<? super String> renderer = getCellRenderer();
				((JLabel) renderer).setHorizontalAlignment(JLabel.CENTER);
				setCellRenderer(renderer);
			}
		
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
			{
				setFont(table.getFont());
				String strValue = (value == null) ? "" : value.toString();
				String lines[] = strValue.split("\n");
				setListData(lines);
				return this;
			}
	}

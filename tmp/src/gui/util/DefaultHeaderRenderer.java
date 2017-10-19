package org.qsari.effectopedia.gui.util;

import java.awt.Component;
import java.awt.ComponentOrientation;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

public class DefaultHeaderRenderer extends DefaultTableCellRenderer
	{
			{
				setBorder(UIManager.getBorder("TableHeader.cellBorder"));
			}
		
		public void updateUI()
			{
				super.updateUI();
				
				setHorizontalAlignment(CENTER);
				
				setBorder(UIManager.getBorder("TableHeader.cellBorder"));
			}
		
		public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column)
			{
				TableHeader header;
				
				if (table != null && (header = (TableHeader) table.getClientProperty(TableHeader.KEY)) != null)
					{
						setForeground(header.getForeground());
						setBackground(header.getBackground());
						
						setFont(header.getFont());
						
						setComponentOrientation(header.getComponentOrientation());
						
						setEnabled(header.isEnabled());
					}
				else
					{
						setForeground(UIManager.getColor("TableHeader.foreground"));
						setBackground(UIManager.getColor("TableHeader.background"));
						
						setFont(UIManager.getFont("TableHeader.font"));
						
						setComponentOrientation(ComponentOrientation.UNKNOWN);
						
						setEnabled(true);
					}
				
				setText(value != null ? value.toString() : "");
				
				return this;
			}
	}
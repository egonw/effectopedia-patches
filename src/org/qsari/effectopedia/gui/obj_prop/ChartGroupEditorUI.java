package org.qsari.effectopedia.gui.obj_prop;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.Document;

import org.qsari.effectopedia.data.quantification.DataTemplates;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class ChartGroupEditorUI extends ChartXAxisEditorUI 
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.setContentPane(new ChartGroupEditorUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public ChartGroupEditorUI(AbstractTableModel model)
			{
				super(model);
			}
		
	
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
			{
				jlLabelList.setFont(table.getFont());
				String[] lines = new String[2];
				lines[0] = templates.getGroupingTitle();
				lines[1] = "[" + templates.getDefaultGroupDisplayUnit() + "]";
				jlLabelList.setListData(lines);
				return jlLabelList;
			}
		
		@Override
		public void load(Object o, boolean readonly)
			{
				if (o instanceof DataTemplates)
					templates = (DataTemplates) o;
				Document docGroupTitle = htfXAxisTitle.getDocument();
				listeners.unbondDocumntListener(docGroupTitle, "GroupingTitle");
				Document docUnit = htfUnit.getDocument();
				listeners.unbondDocumntListener(docUnit, "DefaultGroupDisplayUnit");
				
				htfXAxisTitle.setText(templates.getGroupingTitle());
				htfUnit.setText(templates.getDefaultGroupDisplayUnit());
				
				listeners.bondDocumntListener(docGroupTitle, templates, "GroupingTitle");
				listeners.bondDocumntListener(docUnit, templates, "DefaultGroupDisplayUnit");
			}
		
	}

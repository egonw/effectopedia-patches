package org.qsari.effectopedia.gui.obj_prop;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.Document;

import org.qsari.effectopedia.data.quantification.DataTemplates;
import org.qsari.effectopedia.gui.comp.EventsManager;
import org.qsari.effectopedia.gui.comp.custom_table_header.DefaultTableHeaderEditor;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.util.HintedTextField;

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
public class ChartTitleEditorUI extends DefaultTableHeaderEditor implements KeyListener
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.setContentPane(new ChartTitleEditorUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public ChartTitleEditorUI(AbstractTableModel model)
			{
				super(model);
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
							{
								BorderLayout thisLayout = new BorderLayout();
								this.setLayout(thisLayout);
								this.setPreferredSize(new java.awt.Dimension(162, 20));
								this.addKeyListener(this);
									{
										htfChartTitle = new HintedTextField();
										// new GhostText(htfChartTitle,"Chart Title");
										this.add(htfChartTitle, BorderLayout.CENTER);
										htfChartTitle.setPreferredSize(new java.awt.Dimension(162, 16));
										htfChartTitle.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
										htfChartTitle.addKeyListener(this);
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
			{
				if (templates != null)
					jlTitle.setText(templates.getChartTitle());
				else
					jlTitle.setText(value.toString());
				jlTitle.setHorizontalAlignment(SwingConstants.CENTER);
				jlTitle.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
				return jlTitle;
			}
		
		@Override
		public void load(Object o, boolean readonly)
			{
				if (o instanceof DataTemplates)
					templates = (DataTemplates) o;
				Document docChartTitle = htfChartTitle.getDocument();
				listeners.unbondDocumntListener(docChartTitle, "ChartTitle");
				
				htfChartTitle.setText(templates.getChartTitle());
				
				listeners.bondDocumntListener(docChartTitle, templates, "ChartTitle");
			}
		
		private EventsManager			listeners	= new EventsManager();
		protected DataTemplates	templates;
		private HintedTextField	htfChartTitle;
	}

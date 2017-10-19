package org.qsari.effectopedia.gui.obj_prop;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.Document;

import org.qsari.effectopedia.data.quantification.DataTemplates;
import org.qsari.effectopedia.gui.comp.EventsManager;
import org.qsari.effectopedia.gui.comp.custom_table_header.DefaultTableHeaderEditor;
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
public class ChartXAxisEditorUI extends DefaultTableHeaderEditor
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.setContentPane(new ChartXAxisEditorUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public ChartXAxisEditorUI(AbstractTableModel model)
			{
				super(model);
				initGUI();
			}
		
		protected void initGUI()
			{
				try
					{
							{
								GridBagLayout thisLayout = new GridBagLayout();
								thisLayout.rowWeights = new double[]
									{ 0.5, 0.5 };
								thisLayout.rowHeights = new int[]
									{ 16, 16 };
								thisLayout.columnWeights = new double[]
									{ 0.3, 0.3, 0.3 };
								thisLayout.columnWidths = new int[]
									{ 50, 50, 50 };
								this.setLayout(thisLayout);
								this.addKeyListener(this);
									{
										htfXAxisTitle = new HintedTextField();
										// new GhostText(htfYAxisTitle,"Measured Response Title");
										this.add(htfXAxisTitle, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
										htfXAxisTitle.addKeyListener(this);
										htfXAxisTitle.setName("x_title");
									}
									{
										htfUnit = new HintedTextField();
										// new GhostText(htfUnit,"Unit");
										this.add(htfUnit, new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
										htfUnit.addKeyListener(this);
										htfUnit.setName("x_unit");
									}
									{
										jlLabelList = new JList<String>();
										jlLabelList.setOpaque(true);
										jlLabelList.setForeground(UIManager.getColor("TableHeader.foreground"));
										jlLabelList.setBackground(UIManager.getColor("TableHeader.background"));
										jlLabelList.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
										ListCellRenderer<? super String> renderer = jlLabelList.getCellRenderer();
										((JLabel) renderer).setHorizontalAlignment(JLabel.CENTER);
										jlLabelList.setCellRenderer(renderer);
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
				jlLabelList.setFont(table.getFont());
				String[] lines = new String[2];
				lines[0] = templates.getxAxisTitle();
				lines[1] = "[" + templates.getDefaultXDisplayUnit() + "]";
				jlLabelList.setListData(lines);
				return jlLabelList;
			}
		
		@Override
		public void load(Object o, boolean readonly)
			{
				if (o instanceof DataTemplates)
					templates = (DataTemplates) o;
				Document docXAxisTitle = htfXAxisTitle.getDocument();
				listeners.unbondDocumntListener(docXAxisTitle, "xAxisTitle");
				Document docUnit = htfUnit.getDocument();
				listeners.unbondDocumntListener(docUnit, "DefaultXDisplayUnit");
				
				htfXAxisTitle.setText(templates.getxAxisTitle());
				htfUnit.setText(templates.getDefaultXDisplayUnit());
				
				listeners.bondDocumntListener(docXAxisTitle, templates, "xAxisTitle");
				listeners.bondDocumntListener(docUnit, templates, "DefaultXDisplayUnit");
			}
		
		protected EventsManager			listeners	= new EventsManager();
		protected DataTemplates			templates;
		protected HintedTextField	htfUnit;
		protected HintedTextField	htfXAxisTitle;
		protected JList<String>			jlLabelList;
	}

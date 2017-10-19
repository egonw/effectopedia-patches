package org.qsari.effectopedia.gui.obj_prop;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.Document;

import org.qsari.effectopedia.data.quantification.DataTemplates;
import org.qsari.effectopedia.gui.UIResources;
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
public class ChartTitleAndYAxisEditorUI extends DefaultTableHeaderEditor implements KeyListener
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.setContentPane(new ChartTitleAndYAxisEditorUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public ChartTitleAndYAxisEditorUI(AbstractTableModel model)
			{
				super(model);
				initGUI();
			}
		
		private void initGUI()
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
									{
										htfYAxisTitle = new HintedTextField();
										// new GhostText(htfYAxisTitle,"Measured Response Title");
										this.add(htfYAxisTitle, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
										htfYAxisTitle.addKeyListener(this);
									}
									{
										htfUnit = new HintedTextField();
										// new GhostText(htfUnit,"Unit");
										this.add(htfUnit, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
										htfUnit.addKeyListener(this);
									}
								this.addKeyListener(this);
									{
										htfChartTitle = new HintedTextField();
										// new GhostText(htfChartTitle,"Chart Title");
										this.add(htfChartTitle, new GridBagConstraints(0, 0, 3, 1, 0.8, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
										htfChartTitle.addKeyListener(this);
									}
									
									{
										jlLabelList = new JList<String>();
										jlLabelList.setOpaque(true);
										jlLabelList.setForeground(UIManager.getColor("TableHeader.foreground"));
										jlLabelList.setBackground(UIManager.getColor("TableHeader.background"));
										jlLabelList.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
										// ListCellRenderer<? super String> renderer =
										// jlLabelList.getCellRenderer();
										// ((JLabel) renderer).setHorizontalAlignment(JLabel.CENTER);
										jlLabelList.setCellRenderer(new OptionsListCellRenderer());
									}
								
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		class OptionsListCellRenderer extends DefaultListCellRenderer
			{
				
				private static final long	serialVersionUID	= 0L;
				private JLabel												label;
				
				OptionsListCellRenderer()
					{
						label = new JLabel();
						label.setOpaque(true);
						label.setHorizontalAlignment(JLabel.CENTER);
					}
				
				@Override
				public Component getListCellRendererComponent(JList list, Object value, int index, boolean selected, boolean expanded)
					{
						label.setIcon((index == 0) ? UIResources.imageIconOptions : null);
						if (value != null)
							label.setText(value.toString());
						return label;
					}
				
			}
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
			{
				jlLabelList.setFont(table.getFont());
				String[] lines = new String[2];
				lines[0] = templates.getChartTitle();
				lines[1] = templates.getyPrimaryAxisTitle() + " [" + templates.getDefaultYDisplayUnit() + "]";
				jlLabelList.setListData(lines);
				return jlLabelList;
			}
		
		@Override
		public void load(Object o, boolean readonly)
			{
				if (o instanceof DataTemplates)
					templates = (DataTemplates) o;
				Document docChartTitle = htfChartTitle.getDocument();
				listeners.unbondDocumntListener(docChartTitle, "ChartTitle");
				Document docYAxisTitle = htfYAxisTitle.getDocument();
				listeners.unbondDocumntListener(docYAxisTitle, "yPrimaryAxisTitle");
				Document docUnit = htfUnit.getDocument();
				listeners.unbondDocumntListener(docUnit, "DefaultYDisplayUnit");
				
				htfChartTitle.setText(templates.getChartTitle());
				htfYAxisTitle.setText(templates.getyPrimaryAxisTitle());
				htfUnit.setText(templates.getDefaultYDisplayUnit());
				
				listeners.bondDocumntListener(docChartTitle, templates, "ChartTitle");
				listeners.bondDocumntListener(docYAxisTitle, templates, "yPrimaryAxisTitle");
				listeners.bondDocumntListener(docUnit, templates, "DefaultYDisplayUnit");
			}
		
		private EventsManager			listeners	= new EventsManager();
		protected DataTemplates	templates;
		private HintedTextField	htfUnit;
		private HintedTextField	htfYAxisTitle;
		private HintedTextField	htfChartTitle;
		private JList<String>			jlLabelList;
		
	}

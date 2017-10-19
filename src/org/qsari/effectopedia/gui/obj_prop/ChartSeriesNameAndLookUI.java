package org.qsari.effectopedia.gui.obj_prop;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.Document;

import org.qsari.effectopedia.data.quantification.DataTemplate;
import org.qsari.effectopedia.gui.UIResources;
import org.qsari.effectopedia.gui.chart.ChartDataSeries.Marker;
import org.qsari.effectopedia.gui.comp.EventsManager;
import org.qsari.effectopedia.gui.comp.custom_table_header.DefaultTableHeaderEditor;
import org.qsari.effectopedia.gui.help.RootHelpContext;

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
public class ChartSeriesNameAndLookUI extends DefaultTableHeaderEditor implements ActionListener, ItemListener, KeyListener
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.setContentPane(new ChartSeriesNameAndLookUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public ChartSeriesNameAndLookUI(AbstractTableModel model)
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
									{ 0.1, 0.1 };
								thisLayout.rowHeights = new int[]
									{ 8, 8 };
								thisLayout.columnWeights = new double[]
									{ 0.0, 0.0, 0.1, 0.4, 0.4 };
								thisLayout.columnWidths = new int[]
									{ 10, 10, 40, 40, 40 };
								this.setLayout(thisLayout);
								this.addKeyListener(this);
									{
										jbColor = new JButton();
										this.add(jbColor, new GridBagConstraints(0, 0, 1, 2, 0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
										jbColor.setPreferredSize(new Dimension(10, 24));
										jbColor.setMaximumSize(new Dimension(10, 24));
										jbColor.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
										jbColor.addActionListener(this);
										jbColor.addKeyListener(this);
										
									}
									{
										jbInc = new JButton();
										this.add(jbInc, new GridBagConstraints(1, 0, 1, 1, 0, 0.5, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
										jbInc.setIcon(UIResources.imageIconMicroPlus);
										jbInc.setPreferredSize(new Dimension(7, 7));
										jbInc.setMaximumSize(new Dimension(7, 7));
										jbInc.setMinimumSize(new Dimension(7, 7));
										jbInc.addActionListener(this);
										jbInc.addKeyListener(this);
										
									}
									{
										jbDec = new JButton();
										this.add(jbDec, new GridBagConstraints(1, 1, 1, 1, 0, 0.5, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
										jbDec.setIcon(UIResources.imageIconMicroMinus);
										jbDec.setPreferredSize(new Dimension(7, 7));
										jbDec.setMaximumSize(new Dimension(7, 7));
										jbDec.setMinimumSize(new Dimension(7, 7));
										jbDec.addActionListener(this);
										jbDec.addKeyListener(this);
									}
									{
										renderer = new MarkersListRenderer(Color.white, Color.darkGray);
										jcbMarker = new JComboBox<Marker>(renderer.markers);
										this.add(jcbMarker, new GridBagConstraints(2, 0, 1, 2, 0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jcbMarker.setRenderer(renderer);
										jcbMarker.setPreferredSize(new Dimension(40, 24));
										jcbMarker.setMaximumSize(new Dimension(40, 24));
										jcbMarker.addItemListener(this);
									}
									{
										jtfTitle = new JTextField();
										this.add(jtfTitle, new GridBagConstraints(3, 0, 2, 2, 0.8, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jtfTitle.setPreferredSize(new Dimension(80, 24));
										// jtfTitle.setMinimumSize(new Dimension(40,24));
										jtfTitle.setText("Data Series Title");
										jtfTitle.addKeyListener(this);
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
				if (template != null)
					{
						jlTitle.setIcon(marker);
						jlTitle.setText(template.getSeriesTitle());
					}
				else
					{
						jlTitle.setIcon(renderer.markers[1]);
						jlTitle.setText("Treatment title");
					}
				jlTitle.setHorizontalAlignment(SwingConstants.CENTER);
				jlTitle.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
				return jlTitle;
			}
		
		@Override
		public void load(Object o, boolean readonly)
			{
				if (o instanceof DataTemplate)
					template = (DataTemplate) o;
				Document doc = jtfTitle.getDocument();
				listeners.unbondDocumntListener(doc, "SeriesTitle");
				marker = renderer.markers[template.getMarkerType()];
				jcbMarker.setSelectedItem(marker);
				marker.setSize(template.getMarkerSize());
				marker.fillColor = template.getMarkerFillColor();
				marker.outlineColor = template.getMarkerOutlineColor();
				jbColor.setBackground(marker.fillColor);
				jbColor.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, marker.outlineColor));
				jlTitle.setText(template.getSeriesTitle());
				jtfTitle.setText(template.getSeriesTitle());
				listeners.bondDocumntListener(doc, template, "SeriesTitle");
			}
		
		@Override
		public void actionPerformed(ActionEvent evt)
			{
				Object source = evt.getSource();
				if (template == null)
					return;
				if (source == jbColor)
					{
						if (ColorChooserWithMarkerPreview.selectColor(marker))
							{
								jbColor.setBackground(marker.fillColor);
								jbColor.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, marker.outlineColor));
								renderer.updateColors(marker.fillColor, marker.outlineColor);
								jlTitle.setIcon(marker);
								jlTitle.repaint();
								jcbMarker.repaint();
								template.setMarkerFillColor(marker.fillColor);
								template.setMarkerOutlineColor(marker.outlineColor);
							}
					}
				else if (source == jbInc)
					{
						template.setMarkerSize(template.getMarkerSize() + 1);
						marker.setSize(template.getMarkerSize());
						jlTitle.setIcon(marker);
					}
				else if (source == jbDec)
					{
						int size = template.getMarkerSize();
						if (size > 0)
							{
								template.setMarkerSize(size - 1);
								marker.setSize(template.getMarkerSize());
								jlTitle.setIcon(marker);
							}
					}
				if (model != null)
					model.fireTableDataChanged();
			}
		
		@Override
		public void itemStateChanged(ItemEvent evt)
			{
				int selectedItem = jcbMarker.getSelectedIndex();
				if (selectedItem > 0)
					{
						template.setMarkerType(selectedItem);
						jlTitle.setIcon(renderer.markers[selectedItem]);
						model.fireTableDataChanged();
						fireEditorActionPerformed(acOK);
					}
			}
		
		
		@Override
		public void keyReleased(KeyEvent keyEvent)
			{
				int key = keyEvent.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					fireEditorActionPerformed(acOK);
				else if (key == KeyEvent.VK_ESCAPE)
					fireEditorActionPerformed(acCancel);
			}
		
		
		private EventsManager									listeners	= new EventsManager();
		protected DataTemplate								template;
		protected Marker														marker;
		protected MarkersListRenderer	renderer;
		private JButton															jbColor;
		private JButton															jbInc;
		private JComboBox<Marker>					jcbMarker;
		private JTextField												jtfTitle;
		private JButton															jbDec;
	}

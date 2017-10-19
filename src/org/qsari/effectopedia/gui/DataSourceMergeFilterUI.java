package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.EventObject;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.event.EventListenerList;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
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
public class DataSourceMergeFilterUI extends ContextSensitivePanel implements ActionListener
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 2986301087860032504L;
		private JLabel												jlShow;
		private JCheckBox									jcbHighlightDifferences;
		private JComboBox<String>	jcbShow;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new DataSourceMergeFilterUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public DataSourceMergeFilterUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("filter");
				eventListeners = new EventListenerList();
				initGUI();
			}
		
		public interface MergeFilterListener extends EventListener
			{
				public void filterChanged(EventObject evt);
			}
		
		public void addMergeFilterListener(MergeFilterListener listener)
			{
				eventListeners.add(MergeFilterListener.class, listener);
			}
		
		public void removeMergeFilterListener(MergeFilterListener listener)
			{
				eventListeners.remove(MergeFilterListener.class, listener);
			}
		
		protected void fireMergeFilterChanged(EventObject evt)
			{
				MergeFilterListener[] listeners = eventListeners.getListeners(MergeFilterListener.class);
				for (int i = 0; i < listeners.length; i++)
					listeners[i].filterChanged(evt);
			}
		
		private void initGUI()
			{
				try
					{
						GridBagLayout thisLayout = new GridBagLayout();
						this.setPreferredSize(new java.awt.Dimension(782, 24));
						thisLayout.rowWeights = new double[]
							{ 0.1 };
						thisLayout.rowHeights = new int[]
							{ 7 };
						thisLayout.columnWeights = new double[]
							{ 0.0, 0.1, 0.1, };
						thisLayout.columnWidths = new int[]
							{ 60, 7, 7 };
						this.setLayout(thisLayout);
						this.setBackground(Color.WHITE);
							{
								jlShow = new JLabel();
								this.add(jlShow, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 4), 0, 0));
								jlShow.setText("Show: ");
							}
							{
								ComboBoxModel<String> jcbShowModel = new DefaultComboBoxModel<String>(new String[]
									{ "Conflicting edits", "All diferences", "All" });
								jcbShow = new JComboBox<String>();
								this.add(jcbShow, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jcbShow.setModel(jcbShowModel);
								jcbShow.setBackground(Color.WHITE);
								jcbShow.setMinimumSize(new java.awt.Dimension(24, 24));
								jcbShow.setSelectedIndex(2);
								jcbShow.addActionListener(this);
							}
							{
								jcbHighlightDifferences = new JCheckBox();
								this.add(jcbHighlightDifferences, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 4, 0, 4), 0, 0));
								jcbHighlightDifferences.setText("Highlight differences");
								jcbHighlightDifferences.setOpaque(false);
								jcbHighlightDifferences.setSelected(true);
								jcbHighlightDifferences.addActionListener(this);
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public TableRowSorter<TableModel> getSorter()
			{
				return sorter;
			}
		
		public void setSorter(TableRowSorter<TableModel> sorter)
			{
				this.sorter = sorter;
			}
		
		protected TableRowSorter<TableModel>	sorter;
		
		@Override
		public void actionPerformed(ActionEvent arg0)
			{
				sorter.setRowFilter(null);
				fireMergeFilterChanged(new EventObject(this));
			}
		
		public int getViewOptions()
			{
				int viewOptions = jcbShow.getSelectedIndex();
				if (viewOptions < 0)
					viewOptions = DataSourceUI.VO_CONFLICTS_ONLY;
				else
					viewOptions = 1 << (viewOptions + 1);
				viewOptions = viewOptions | (jcbHighlightDifferences.isSelected() ? DataSourceUI.VO_HIGHLIGHT : 0);
				return viewOptions;
			}
		
		protected EventListenerList	eventListeners;
	}

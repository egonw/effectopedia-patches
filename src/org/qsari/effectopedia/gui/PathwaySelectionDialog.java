package org.qsari.effectopedia.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.filter.FilteredIndex;
import org.qsari.effectopedia.data.filter.ManualSelectionFilter;
import org.qsari.effectopedia.gui.core.GUIFactory;
import org.qsari.effectopedia.gui.core.SelectableListUI;

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
public class PathwaySelectionDialog extends javax.swing.JDialog implements SelectableListUI<Pathway>, ActionListener
	{
		/**
	 * 
	 */
		private static final long																		serialVersionUID	= -8069795493814727028L;
		private JTextPane																										jtpMessage;
		private JButton																												jbCancel;
		private JButton																												jbSaveSelected;
		private FiltredListUI																						fluiPathways;
		private JButton																												jbSaveAll;
		private JLabel																													jlQuestionIcon;
		
		public static final PathwaySelectionDialog	DIALOG											= new PathwaySelectionDialog(GUIFactory.GUI.getFrame());
		
		/**
		 * Auto-generated main method to display this JDialog
		 */
		public static void main(String[] args)
			{
				SwingUtilities.invokeLater(new Runnable()
					{
						public void run()
							{
								DIALOG.setVisible(true);
							}
					});
			}
		
		private PathwaySelectionDialog(JFrame frame)
			{
				super(frame);
				dataSource = Effectopedia.EFFECTOPEDIA.getData();
				availablePathways = new FilteredIndex(dataSource == null ? null : dataSource.getLiveIndices().getPathways());
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
							{
								GridBagLayout thisLayout = new GridBagLayout();
								thisLayout.rowWeights = new double[]
									{ 0.1, 0.1, 0.1, 0.0, 0.1 };
								thisLayout.rowHeights = new int[]
									{ 7, 20, 7, 52, 7 };
								thisLayout.columnWeights = new double[]
									{ 0.1, 0.1, 0.1, 0.1 };
								thisLayout.columnWidths = new int[]
									{ 7, 7, 7, 7 };
								getContentPane().setLayout(thisLayout);
								this.setTitle("Select existing adverse outcome pathway or define new ");
									{
										jtpMessage = new JTextPane();
										getContentPane().add(jtpMessage, new GridBagConstraints(1, 0, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 15), 0, 0));
										jtpMessage.setText("Select the pathways you would like to save ");
										jtpMessage.setEditable(false);
										jtpMessage.setOpaque(false);
										jtpMessage.setFont(new java.awt.Font("Segoe UI", 0, 18));
									}
									{
										jlQuestionIcon = new JLabel();
										getContentPane().add(jlQuestionIcon, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jlQuestionIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/dialog_question.png")));
										jlQuestionIcon.setHorizontalTextPosition(SwingConstants.RIGHT);
									}
									{
										jcbSelectAll = new JCheckBox();
										getContentPane().add(jcbSelectAll, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jcbSelectAll.setText("select / deselect all");
										jcbSelectAll.setSelected(true);
										jcbSelectAll.addActionListener(new ActionListener()
											{
												
												@Override
												public void actionPerformed(ActionEvent e)
													{
														if (selectionFilter != null)
															selectionFilter.markAll(jcbSelectAll.isSelected());
														if (fluiPathways != null)
															{
																fluiPathways.invalidate();
																fluiPathways.repaint();
															}
													}
											});
									}
									
									{
										fluiPathways = new FiltredListUI();
										getContentPane().add(fluiPathways, new GridBagConstraints(0, 2, 4, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 20, 0, 10), 0, 0));
									}
									{
										jbCancel = new JButton();
										getContentPane().add(jbCancel, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jbCancel.setText("Cancel");
										jbCancel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/button_cancel.png")));
										jbCancel.addActionListener(this);
									}
									{
										jbSaveSelected = new JButton();
										getContentPane().add(jbSaveSelected, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jbSaveSelected.setText("Save selected");
										jbSaveSelected.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/button_add.png")));
										jbSaveSelected.setIconTextGap(8);
										jbSaveSelected.addActionListener(this);
									}
									{
										jbSaveAll = new JButton();
										getContentPane().add(jbSaveAll, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jbSaveAll.setText("Save all");
										jbSaveAll.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/button_ok.png")));
										jbSaveAll.addActionListener(this);
									}
							}
						setCentredLocation();
						setModal(true);
						this.setLocationByPlatform(true);
						this.setName("Pathway Selector");
						pack();
						this.setSize(500, 335);
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public void setCentredLocation()
			{
				Container parent = getParent();
				int x = parent.getLocationOnScreen().x;
				int y = parent.getLocationOnScreen().y;
				Dimension parentSize = parent.getSize();
				Dimension dialogSize = getSize();
				
				if (parentSize.width > dialogSize.width)
					x += ((parentSize.width - dialogSize.width) >> 1);
				
				if (parentSize.height > dialogSize.height)
					y += ((parentSize.height - dialogSize.height) >> 1);
				
				setLocation(x, y);
			}
		
		public void load(Object o, boolean readonly)
			{
				selected = null;
				if (dataSource == null)
					dataSource = Effectopedia.EFFECTOPEDIA.getData();
				selectionFilter = new ManualSelectionFilter(dataSource.getLiveIndices().getPathways(), true);
				availablePathways.clearFilters();
				availablePathways.addFilter(selectionFilter);
				availablePathways.sort();
				boolean hasSuggestions = availablePathways.count() > 0;
				if ((hasSuggestions) && (!readonly))
					{
						fluiPathways.setFilteredIndex(availablePathways);
						setCentredLocation();
						DIALOG.setVisible(true);
					}
				else
					{
						DIALOG.setVisible(false);
						UserInterface.getDefaultNavigator().navigate(UILocations.getProperEditor(o), o);
					}
			}
		
		public void actionPerformed(ActionEvent e)
			{
				if (e.getSource() == jbSaveAll)
					selected = dataSource.getLiveIndices().getPathways().get();
				else if (e.getSource() == jbSaveSelected)
					{
						Collection<EffectopediaObject> selected = selectionFilter.getSelected();
						this.selected = selected.toArray(new Pathway[selected.size()]);
					}
				DIALOG.setVisible(false);
			}
		
		public DataSource getDataSource()
			{
				return dataSource;
			}
		
		public void setDataSource(DataSource dataSource)
			{
				this.dataSource = dataSource;
			}
		
		@Override
		public Pathway[] getSelected()
			{
				return selected;
			}
		
		private DataSource														dataSource	= Effectopedia.EFFECTOPEDIA.getData();
		protected Pathway[]													selected;
		private JCheckBox															jcbSelectAll;
		protected ManualSelectionFilter	selectionFilter;
		private FilteredIndex											availablePathways;
		
	}

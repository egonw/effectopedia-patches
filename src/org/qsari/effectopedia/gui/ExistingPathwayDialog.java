package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.filter.FilteredIndex;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.gui.core.GUIFactory;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;

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
public class ExistingPathwayDialog extends javax.swing.JDialog implements LoadableEditorUI, ActionListener
	{
		/**
	 * 
	 */
		private static final long																	serialVersionUID	= -8069795493814727028L;
		private JTextPane																									jtpMessage;
		private JButton																											jbCancel;
		private JButton																											jbDefineNew;
		private JScrollPane																							jspExistingPathways;
		private JButton																											jbUseSelected;
		private JLabel																												jlQuestionIcon;
		private JList<String>																					jlExistingPathways;
		private JCheckBox																									jcbUpstreamElements;
		
		public static final ExistingPathwayDialog	DIALOG											= new ExistingPathwayDialog(GUIFactory.GUI.getFrame());
		
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
		
		private ExistingPathwayDialog(JFrame frame)
			{
				super(frame);
				DataSource data = Effectopedia.EFFECTOPEDIA.getData();
				suggestedPathways = new FilteredIndex(data == null ? null : data.getLiveIndices().getPathways());
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
							{
								GridBagLayout thisLayout = new GridBagLayout();
								thisLayout.rowWeights = new double[]
									{ 0.1, 0.0, 0.1, 0.0, 0.1 };
								thisLayout.rowHeights = new int[]
									{ 7, 33, 7, 52, 7 };
								thisLayout.columnWeights = new double[]
									{ 0.1, 0.1, 0.1, 0.1 };
								thisLayout.columnWidths = new int[]
									{ 7, 7, 7, 7 };
								getContentPane().setLayout(thisLayout);
								this.setTitle("Select existing adverse outcome pathway or define new ");
									{
										jtpMessage = new JTextPane();
										getContentPane().add(jtpMessage, new GridBagConstraints(1, 0, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 15), 0, 0));
										jtpMessage.setText("Please take a moment to verify that the pathway you are trying create is not already present in Effectopedia.");
										jtpMessage.setEditable(false);
										jtpMessage.setOpaque(false);
										jtpMessage.setFont(new java.awt.Font("Segoe UI", 0, 18));
									}
									{
										jspExistingPathways = new JScrollPane();
										getContentPane().add(jspExistingPathways, new GridBagConstraints(0, 2, 4, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 20, 0, 10), 0, 0));
											{
												ListModel<String> jlExistingElementsModel = suggestedPathways.getListModel();
												jlExistingPathways = new JList<String>();
												jlExistingPathways.setModel(jlExistingElementsModel);
												jlExistingPathways.addMouseListener(new MouseAdapter()
													{
														public void mouseClicked(MouseEvent e)
															{
																if (e.getClickCount() == 2)
																	{
																		int index = jlExistingPathways.locationToIndex(e.getPoint());
																		selectedPathway = (Pathway) suggestedPathways.getElement(index);
																		setVisible(false);
																	}
															}
													});
												jspExistingPathways.setViewportView(jlExistingPathways);
											}
									}
									{
										jlQuestionIcon = new JLabel();
										getContentPane().add(jlQuestionIcon, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jlQuestionIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/dialog_question.png")));
										jlQuestionIcon.setHorizontalTextPosition(SwingConstants.RIGHT);
									}
									{
										jbCancel = new JButton();
										getContentPane().add(jbCancel, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jbCancel.setText("Cancel");
										jbCancel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/button_cancel.png")));
										jbCancel.addActionListener(this);
									}
									{
										jbDefineNew = new JButton();
										getContentPane().add(jbDefineNew, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jbDefineNew.setText("Define New");
										jbDefineNew.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/button_add.png")));
										jbDefineNew.setIconTextGap(8);
										jbDefineNew.addActionListener(this);
									}
									{
										jbUseSelected = new JButton();
										getContentPane().add(jbUseSelected, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jbUseSelected.setText("Use selected");
										jbUseSelected.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/button_ok.png")));
										jbUseSelected.addActionListener(this);
									}
									{
										jpUpdateAllLinked = new JPanel();
										FlowLayout jpUpdateAllLinkedLayout = new FlowLayout();
										jpUpdateAllLinkedLayout.setAlignment(FlowLayout.LEFT);
										jpUpdateAllLinked.setLayout(jpUpdateAllLinkedLayout);
										getContentPane().add(jpUpdateAllLinked, new GridBagConstraints(0, 1, 4, 1, 0.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(4, 20, 4, 12), 0, 0));
										jpUpdateAllLinked.setBackground(Color.WHITE);
										jpUpdateAllLinked.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
											{
												jlLinkAll = new JLabel();
												jpUpdateAllLinked.add(jlLinkAll);
												jlLinkAll.setText("Update all linked");
											}
											{
												jcbUpstreamElements = new JCheckBox();
												jpUpdateAllLinked.add(jcbUpstreamElements);
												jcbUpstreamElements.setText("upstream and");
												jcbUpstreamElements.setBackground(Color.WHITE);
												jcbUpstreamElements.setSelected(true);
											}
											{
												jcbDownstreamElements = new JCheckBox();
												jpUpdateAllLinked.add(jcbDownstreamElements);
												jcbDownstreamElements.setText("downstream");
												jcbDownstreamElements.setBackground(Color.WHITE);
												jcbDownstreamElements.setSelected(true);
											}
											{
												jlElements = new JLabel();
												jpUpdateAllLinked.add(jlElements);
												jlElements.setText("elements");
											}
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
				if ((o instanceof Pathway))
					pathway = (Pathway) o;
				else
					pathway = null;
				selectedPathway = null;
				suggestedPathways.clearFilters();
				suggestedPathways.sort();
				boolean hasSuggestions = suggestedPathways.count() > 0;
				if ((hasSuggestions) && (!readonly))
					{
						ListModel<String> jlExistingElementsModel = suggestedPathways.getListModel();
						jlExistingPathways.setModel(jlExistingElementsModel);
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
				if (e.getSource() == jbUseSelected)
					selectedPathway = (Pathway) suggestedPathways.getElement(jlExistingPathways.getSelectedIndex());
				else if (e.getSource() == jbDefineNew)
					{
						if (pathway == null)
							{
								dataSource = Effectopedia.EFFECTOPEDIA.getData();
								pathway = DefaultEffectopediaObjects.DEFAULT_PATHWAY.clone(null, dataSource);
								pathway.forceToLive();
							}
						selectedPathway = pathway;
						UserInterface.getDefaultNavigator().navigate(UILocations.getProperEditor(pathway), pathway);
					}
				else if (e.getSource() == jbCancel)
					selectedPathway = null;
				DIALOG.setVisible(false);
			}
		
		public Pathway getSelectedPathway()
			{
				return selectedPathway;
			}
		
		public boolean isUpdateUpstreamElementsSelected()
			{
				return jcbUpstreamElements.isSelected();
			}
		
		public boolean isUpdateDownstreamElementsSelected()
			{
				return jcbDownstreamElements.isSelected();
			}
		
		public DataSource getDataSource()
			{
				return dataSource;
			}
		
		public void setDataSource(DataSource dataSource)
			{
				this.dataSource = dataSource;
			}
		
		private DataSource				dataSource	= Effectopedia.EFFECTOPEDIA.getData();
		private Pathway							pathway;
		private JPanel								jpUpdateAllLinked;
		private JLabel								jlElements;
		private JCheckBox					jcbDownstreamElements;
		private JLabel								jlLinkAll;
		protected Pathway					selectedPathway;
		private FilteredIndex	suggestedPathways;
		
	}

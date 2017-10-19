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
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.filter.FilteredIndex;
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
public class ExistingEffectopediaObjectDialog extends javax.swing.JDialog implements LoadableEditorUI, ActionListener
	{
		/**
	 * 
	 */
		private static final long																												serialVersionUID	= -8069795493814727028L;
		private JTextPane																																				jtpMessage;
		private JButton																																						jbCancel;
		private JButton																																						jbDefineNew;
		private JScrollPane																																		jspExistingEffectopediaObjects;
		private JButton																																						jbUseSelected;
		private JLabel																																							jlQuestionIcon;
		private JList<String>																																jlExistingEffectopediaObjects;
		
		public static final ExistingEffectopediaObjectDialog	DIALOG											= new ExistingEffectopediaObjectDialog(GUIFactory.GUI.getFrame());
		
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
		
		private ExistingEffectopediaObjectDialog(JFrame frame)
			{
				super(frame);
				DataSource data = Effectopedia.EFFECTOPEDIA.getData();
				existingEffectopediaObjects = new FilteredIndex(data == null ? null : data.getLiveIndices().getEffects());
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
								this.setTitle("Select existing " + caption + " or define new ");
									{
										jtpMessage = new JTextPane();
										getContentPane().add(jtpMessage, new GridBagConstraints(1, 0, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 15), 0, 0));
										jtpMessage.setText("Select exisitng " + caption + "or define new ");
										jtpMessage.setEditable(false);
										jtpMessage.setOpaque(false);
										jtpMessage.setFont(new java.awt.Font("Segoe UI", 0, 18));
									}
									{
										jspExistingEffectopediaObjects = new JScrollPane();
										getContentPane().add(jspExistingEffectopediaObjects, new GridBagConstraints(0, 2, 4, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 20, 0, 10), 0, 0));
											{
												ListModel<String> jlExistingElementsModel = existingEffectopediaObjects.getListModel();
												jlExistingEffectopediaObjects = new JList<String>();
												jlExistingEffectopediaObjects.setModel(jlExistingElementsModel);
												jlExistingEffectopediaObjects.addMouseListener(new MouseAdapter()
													{
														public void mouseClicked(MouseEvent e)
															{
																if (e.getClickCount() == 2)
																	{
																		int index = jlExistingEffectopediaObjects.locationToIndex(e.getPoint());
																		selectedEffectopediaObject = existingEffectopediaObjects.getElement(index);
																		setVisible(false);
																	}
															}
													});
												jspExistingEffectopediaObjects.setViewportView(jlExistingEffectopediaObjects);
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
										jpSelectObjectContainer = new JPanel();
										FlowLayout jpUpdateAllLinkedLayout = new FlowLayout();
										jpUpdateAllLinkedLayout.setAlignment(FlowLayout.LEFT);
										jpSelectObjectContainer.setLayout(jpUpdateAllLinkedLayout);
										getContentPane().add(jpSelectObjectContainer, new GridBagConstraints(0, 1, 4, 1, 0.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(4, 20, 4, 12), 0, 0));
										jpSelectObjectContainer.setBackground(Color.WHITE);
										jpSelectObjectContainer.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
											{
												jlLinkAll = new JLabel();
												jpSelectObjectContainer.add(jlLinkAll);
												jlLinkAll.setText("Show: ");
											}
											{
												jcbEffectopediaObjectsModel = new DefaultComboBoxModel<EffectopediaObjects<?>>(availableIndices);
												jcbEffectopediaObjects = new JComboBox<EffectopediaObjects<?>>();
												jpSelectObjectContainer.add(jcbEffectopediaObjects);
												jcbEffectopediaObjects.setModel(jcbEffectopediaObjectsModel);
												jcbEffectopediaObjects.setPreferredSize(new java.awt.Dimension(395, 24));
												jcbEffectopediaObjects.addActionListener(this);
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
				if ((o instanceof EffectopediaObject))
					eo = (EffectopediaObject) o;
				else
					eo = null;
				dataSource = Effectopedia.EFFECTOPEDIA.getData();
				existingEffectopediaObjects = new FilteredIndex((EffectopediaObjects<?>) jcbEffectopediaObjectsModel.getSelectedItem());
				int index = jcbEffectopediaObjects.getSelectedIndex();
				jbDefineNew.setEnabled((availablePrototypes != null) && (index != -1) && (availablePrototypes.length > index) && (availablePrototypes[index] != null));
				selectedEffectopediaObject = null;
				existingEffectopediaObjects.clearFilters();
				existingEffectopediaObjects.addGenericFilter();
				existingEffectopediaObjects.filter();
				existingEffectopediaObjects.sort();
				boolean hasSuggestions = existingEffectopediaObjects.count() > 0;
				if ((hasSuggestions) && (!readonly))
					{
						ListModel<String> jlExistingElementsModel = existingEffectopediaObjects.getListModel();
						jlExistingEffectopediaObjects.setModel(jlExistingElementsModel);
						setCentredLocation();
						if (!DIALOG.isVisible())
							DIALOG.setVisible(true);
					}
			}
		
		public void actionPerformed(ActionEvent e)
			{
				if (e.getSource() == jcbEffectopediaObjects)
					load(eo, false);
				if (e.getSource() == jbUseSelected)
					selectedEffectopediaObject = (Pathway) existingEffectopediaObjects.getElement(jlExistingEffectopediaObjects.getSelectedIndex());
				else if (e.getSource() == jbDefineNew)
					{
						int index = jcbEffectopediaObjects.getSelectedIndex();
						if (eo == null)
							{
								dataSource = Effectopedia.EFFECTOPEDIA.getData();
								eo = availablePrototypes[index].clone(null, dataSource);
								eo.forceToLive();
							}
						selectedEffectopediaObject = eo;
						UserInterface.getDefaultNavigator().navigate(UILocations.getProperEditor(eo), eo);
					}
				else if (e.getSource() == jbCancel)
					{
						selectedEffectopediaObject = null;
						DIALOG.setVisible(false);
					}
			}
		
		public EffectopediaObject getSelectedEffectopediaObject()
			{
				return selectedEffectopediaObject;
			}
		
		public DataSource getDataSource()
			{
				return dataSource;
			}
		
		public void setDataSource(DataSource dataSource)
			{
				this.dataSource = dataSource;
			}
		
		public EffectopediaObjects[] getAvailableIndices()
			{
				return availableIndices;
			}
		
		public void setAvailableIndices(EffectopediaObjects[] availableIndices)
			{
				this.availableIndices = availableIndices;
				jcbEffectopediaObjectsModel = new DefaultComboBoxModel<EffectopediaObjects<?>>(availableIndices);
				jcbEffectopediaObjects.setModel(jcbEffectopediaObjectsModel);
				jcbEffectopediaObjects.setSelectedIndex(0);
			}
		
		public EffectopediaObject[] getAvailablePrototypes()
			{
				return availablePrototypes;
			}
		
		public void setAvailablePrototypes(EffectopediaObject[] availablePrototypes)
			{
				this.availablePrototypes = availablePrototypes;
			}
		
		protected String																																caption													= "Effectopedia object";
		private DataSource																														dataSource										= Effectopedia.EFFECTOPEDIA.getData();
		protected ComboBoxModel<EffectopediaObjects<?>>	jcbEffectopediaObjectsModel;
		protected EffectopediaObjects[]																	availableIndices				= (dataSource == null) ? new EffectopediaObjects[]
																																																																							{} : new EffectopediaObjects[]
																																																																							{ dataSource.getLiveIndices().getEffects(), dataSource.getLiveIndices().getInitiators() };
		
		protected EffectopediaObject[]																		availablePrototypes	= null;
		private JComboBox<EffectopediaObjects<?>>							jcbEffectopediaObjects;
		private EffectopediaObject																						eo;
		private JPanel																																		jpSelectObjectContainer;
		private JLabel																																		jlLinkAll;
		protected EffectopediaObject																				selectedEffectopediaObject;
		private FilteredIndex																											existingEffectopediaObjects;
		
	}

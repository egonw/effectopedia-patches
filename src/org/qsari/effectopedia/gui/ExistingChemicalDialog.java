package org.qsari.effectopedia.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.Initiator;
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
public class ExistingChemicalDialog extends javax.swing.JDialog implements LoadableEditorUI, ActionListener
	{
		
		public static final ExistingChemicalDialog	DIALOG	= new ExistingChemicalDialog(GUIFactory.GUI.getFrame());
		
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
		
		private ExistingChemicalDialog(JFrame frame)
			{
				super(frame);
				DataSource data = Effectopedia.EFFECTOPEDIA.getData();
				suggestedInitiators = new FilteredIndex(data == null ? null : data.getLiveIndices().getInitiators());
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
							{
								GridBagLayout thisLayout = new GridBagLayout();
								thisLayout.rowWeights = new double[]
									{ 0.0, 0.0, 0.0, 0.1, 0.0 };
								thisLayout.rowHeights = new int[]
									{ 7, 7, 7, 7, 7 };
								thisLayout.columnWeights = new double[]
									{ 0.0, 0.1, 0.1, 0.1 };
								thisLayout.columnWidths = new int[]
									{ 7, 7, 7, 7 };
								getContentPane().setLayout(thisLayout);
								this.setTitle("Select existing chemical or define new ");
									{
										jtpMessage = new JTextPane();
										getContentPane().add(jtpMessage, new GridBagConstraints(1, 0, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
										jtpMessage
												.setText("Please take a moment to verify that the chemical structure, structural alert or biological perturbation you are trying to define is not already present in Effectopedia.");
										jtpMessage.setEditable(false);
										jtpMessage.setOpaque(false);
										jtpMessage.setFont(new java.awt.Font("Segoe UI", 0, 18));
									}
									{
										jspExistingElements = new JScrollPane();
										getContentPane().add(jspExistingElements, new GridBagConstraints(0, 3, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(4, 20, 4, 10), 0, 0));
											{
												ListModel<String> jlExistingElementsModel = suggestedInitiators.getListModel();
												jlExistingElements = new JList<String>();
												jspExistingElements.setViewportView(jlExistingElements);
												jlExistingElements.setModel(jlExistingElementsModel);
												jlExistingElements.addMouseListener(new MouseAdapter()
													{
														public void mouseClicked(MouseEvent e)
															{
																if (e.getClickCount() == 2)
																	{
																		int index = jlExistingElements.locationToIndex(e.getPoint());
																		selectedInitiator = (Initiator) suggestedInitiators.getElement(index);
																		setVisible(false);
																	}
															}
													});
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
										getContentPane().add(jbCancel, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 10, 10), 0, 0));
										jbCancel.setText("Cancel");
										jbCancel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/button_cancel.png")));
										jbCancel.setMinimumSize(new java.awt.Dimension(96, 24));
										jbCancel.setPreferredSize(new java.awt.Dimension(96, 24));
										jbCancel.addActionListener(this);
									}
									{
										jbDefineNew = new JButton();
										getContentPane().add(jbDefineNew, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 10, 0), 0, 0));
										jbDefineNew.setText("Define new");
										jbDefineNew.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/button_add.png")));
										jbDefineNew.setIconTextGap(8);
										jbDefineNew.setMinimumSize(new java.awt.Dimension(128, 24));
										jbDefineNew.setPreferredSize(new java.awt.Dimension(128, 24));
										jbDefineNew.addActionListener(this);
									}
									{
										jbUseSelected = new JButton();
										getContentPane().add(jbUseSelected, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 10, 0), 0, 0));
										jbUseSelected.setText("Use selected");
										jbUseSelected.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/button_ok.png")));
										jbUseSelected.setMinimumSize(new java.awt.Dimension(128, 24));
										jbUseSelected.setPreferredSize(new java.awt.Dimension(128, 24));
										jbUseSelected.addActionListener(this);
									}
									{
										ljSource = new JLabel();
										getContentPane().add(ljSource, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 20, 4, 3), 0, 0));
										ljSource.setText("Look in");
									}
									{
										ComboBoxModel<String> jcbSourceModel = new DefaultComboBoxModel<String>(new String[]
											{ "Effectopedia", "OECD Toolbox chemical database" });
										jcbSource = new JComboBox<String>();
										getContentPane().add(jcbSource, new GridBagConstraints(1, 1, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 4, 10), 0, 0));
										jcbSource.setModel(jcbSourceModel);
										jcbSource.setMinimumSize(new java.awt.Dimension(24, 24));
									}
									{
										jlFilterBy = new JLabel();
										getContentPane().add(jlFilterBy, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 20, 0, 3), 0, 0));
										jlFilterBy.setText("Filter by");
									}
									{
										ComboBoxModel<String> jcbFilterByModel = new DefaultComboBoxModel<String>(new String[]
											{ "IUPAC Name", "CAS", "Smiles" });
										jcbFilterBy = new JComboBox<String>();
										getContentPane().add(jcbFilterBy, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jcbFilterBy.setModel(jcbFilterByModel);
										jcbFilterBy.setMinimumSize(new java.awt.Dimension(24, 24));
									}
									{
										jtfFilter = new JTextField();
										getContentPane().add(jtfFilter, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
										jtfFilter.setText("");
										jtfFilter.setMinimumSize(new java.awt.Dimension(24, 24));
									}
									{
										ComboBoxModel<String> jcbCriteriaModel = new DefaultComboBoxModel<String>(new String[]
											{ "is", "contains", "starts" });
										jcbCriteria = new JComboBox<String>();
										getContentPane().add(jcbCriteria, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 4, 0, 4), 0, 0));
										jcbCriteria.setModel(jcbCriteriaModel);
										jcbCriteria.setMinimumSize(new java.awt.Dimension(24, 24));
									}
							}
						this.setSize(539, 367);
						setCentredLocation();
						setModal(true);
						this.setLocationByPlatform(true);
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
				if (!(o instanceof Initiator))
					return;
				initiator = (Initiator) o;
				selectedInitiator = null;
				suggestedInitiators.clearFilters();
				suggestedInitiators.addGenericFilter();
				suggestedInitiators.sort();
				boolean hasSuggestions = suggestedInitiators.count() > 0;
				if ((hasSuggestions) && (!readonly))
					{
						setCentredLocation();
						jlExistingElements.setModel(suggestedInitiators.getListModel());
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
					selectedInitiator = (Initiator) suggestedInitiators.getElement(jlExistingElements.getSelectedIndex());
				else if (e.getSource() == jbDefineNew)
					UserInterface.getDefaultNavigator().navigate(UILocations.getProperEditor(initiator), initiator);
				DIALOG.setVisible(false);
			}
		
		public Initiator getSelectedInitiator()
			{
				return selectedInitiator;
			}
		
		private Initiator									initiator;
		private JComboBox<String>	jcbSource;
		private JLabel												ljSource;
		protected Initiator							selectedInitiator;
		private FilteredIndex					suggestedInitiators;
		private JTextPane									jtpMessage;
		private JComboBox<String>	jcbCriteria;
		private JTextField								jtfFilter;
		private JComboBox<String>	jcbFilterBy;
		private JLabel												jlFilterBy;
		private JButton											jbCancel;
		private JButton											jbDefineNew;
		private JScrollPane							jspExistingElements;
		private JButton											jbUseSelected;
		private JLabel												jlQuestionIcon;
		private JList<String>					jlExistingElements;
		/**
	 * 
	 */
		private static final long	serialVersionUID	= -7672957193900032971L;
	}

package org.qsari.effectopedia.gui.obj_prop;

import java.awt.BorderLayout;
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
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.filter.FilteredIndex;
import org.qsari.effectopedia.data.objects.DataValue_String;
import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.data.objects.ObjectPropertyType;
import org.qsari.effectopedia.gui.core.GUIFactory;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI.ListEditorActionListener;

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
public class DescriptorTypeDialog extends javax.swing.JDialog implements LoadableEditorUI, ActionListener
	{
		/**
	 * 
	 */
		private static final long																serialVersionUID	= -8069795493814727028L;
		
		public static final DescriptorTypeDialog	DIALOG											= new DescriptorTypeDialog(GUIFactory.GUI.getFrame());
		
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
		
		protected DescriptorTypeDialog(JFrame frame)
			{
				super(frame);
				DataSource data = Effectopedia.EFFECTOPEDIA.getData();
				Effectopedia.EFFECTOPEDIA.getAutentication().addUserSignInListener(dtuiDescriptorType);
				Effectopedia.EFFECTOPEDIA.getAutentication().addUserSignOutListener(dtuiDescriptorType);
				suggestedDesctiptorTypes = new FilteredIndex(data == null ? null : data.getLiveIndices().getPropertyTypes());
				initGUI("descriptor type");
			}
		
		protected void initGUI(String title)
			{
				try
					{
							{
								GridBagLayout thisLayout = new GridBagLayout();
								thisLayout.rowWeights = new double[]
									{ 0.0, 0.0, 0.1 };
								thisLayout.rowHeights = new int[]
									{ 44, 388, 24 };
								thisLayout.columnWeights = new double[]
									{ 0.0, 0.1, 0.1 };
								thisLayout.columnWidths = new int[]
									{ 260, 7, 7 };
								getContentPane().setLayout(thisLayout);
								this.setTitle("Select existing " + title + "(s) or define new ");
									{
										jpExistingDescriptorTypes = new JPanel();
										jpExistingDescriptorTypes.setLayout(new BorderLayout());
										getContentPane().add(jpExistingDescriptorTypes, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 16, 0, 8), 0, 0));
										jpExistingDescriptorTypes.setBorder(BorderFactory.createTitledBorder("Available " + title));
										jpExistingDescriptorTypes.setBackground(Color.white);
											{
												jlDescription = new JLabel();
												getContentPane().add(jlDescription, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 16, 0, 0), 0, 0));
												jlDescription.setText("Select one or more " + title + "s. To add a new " + title + " click on the + button at the end of the list");
											}
											{
												jspExistingDescriptorTypes = new JScrollPane();
												jpExistingDescriptorTypes.add(jspExistingDescriptorTypes, BorderLayout.CENTER);
												jspExistingDescriptorTypes.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
													{
														ListModel<String> jlExistingElementsModel = suggestedDesctiptorTypes.getListModel();
														jlExistingDescriptorTypes = new JList<String>();
														jlExistingDescriptorTypes.setModel(jlExistingElementsModel);
														jlExistingDescriptorTypes.addMouseListener(new MouseAdapter()
															{
																public void mouseClicked(MouseEvent e)
																	{
																		int index = jlExistingDescriptorTypes.locationToIndex(e.getPoint());
																		if (e.getClickCount() == 1)
																			{
																				DescriptorType descriptorType = (DescriptorType) suggestedDesctiptorTypes.getElement(index);
																				dtuiDescriptorType.load(descriptorType, descriptorType.getExternalID() != 0);
																			}
																		if (e.getClickCount() == 2)
																			{
																				selectedDescriptorType.clear();
																				selectedDescriptorType.add((DescriptorType) suggestedDesctiptorTypes.getElement(index));
																				setVisible(false);
																			}
																	}
															});
														jspExistingDescriptorTypes.setViewportView(jlExistingDescriptorTypes);
														jlExistingDescriptorTypes.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
													}
											}
											{
												letuiDescriptorTypesToolbar = new ListEditorToolbarUI(null, title, ListEditorToolbarUI.ADD, FlowLayout.RIGHT);
												jpExistingDescriptorTypes.add(letuiDescriptorTypesToolbar, BorderLayout.SOUTH);
												letuiDescriptorTypesToolbar.addListEditorActionListener(new ListEditorActionListener()
													{
														
														@Override
														public int listEditorActionPerformed(int actionCode)
															{
																if (actionCode == ListEditorToolbarUI.ADD)
																	addDescriptorType();
																else if (actionCode == ListEditorToolbarUI.REMOVE)
																	removeDescriptorType();
																return actionCode;
															}
													});
											}
									}
									{
										jbCancel = new JButton();
										getContentPane().add(jbCancel, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 16), 0, 0));
										jbCancel.setText("Cancel");
										jbCancel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/button_cancel.png")));
										jbCancel.addActionListener(this);
									}
									{
										jbUseSelected = new JButton();
										getContentPane().add(jbUseSelected, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 8), 0, 0));
										jbUseSelected.setText("Use selected");
										jbUseSelected.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/button_ok.png")));
										jbUseSelected.addActionListener(this);
									}
									{
										dtuiDescriptorType = new DescriptorTypeUI(title);
										dtuiDescriptorType.setBorder(BorderFactory.createTitledBorder(DescriptorTypeUI.titleCase(title)));
										getContentPane().add(dtuiDescriptorType, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 16), 0, 0));
										dtuiDescriptorType.addDescriptorTypeChangeListener(new DescriptorTypeUI.DescriptorTypeChangeListener()
											{
												
												@Override
												public void descriptorTypeChanged(DescriptorType descriptorType)
													{
														jlExistingDescriptorTypes.setSelectedValue(descriptorType.getName(), true);
														jlExistingDescriptorTypes.revalidate();
														jlExistingDescriptorTypes.repaint();
													}
												
												@Override
												public void load(Object o, boolean readonly)
													{
														DescriptorTypeDialog.this.load(o, readonly);
													}
											});
									}
							}
						setCentredLocation();
						setModal(true);
						this.setLocationByPlatform(true);
						this.setName("Select " + title);
						pack();
						this.setSize(812, 537);
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
				if ((o instanceof DescriptorType))
					dtuiDescriptorType.load(o, readonly);
				selectedDescriptorType.clear();
				suggestedDesctiptorTypes.clearFilters();
				suggestedDesctiptorTypes.addNotClassFilter(ObjectPropertyType.class);
				suggestedDesctiptorTypes.sort(FilteredIndex.NAME_COMPARATOR);
				boolean hasSuggestions = suggestedDesctiptorTypes.count() > 0;
				if ((hasSuggestions) && (!readonly))
					{
						ListModel<String> jlExistingElementsModel = suggestedDesctiptorTypes.getListModel();
						jlExistingDescriptorTypes.setModel(jlExistingElementsModel);
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
				selectedDescriptorType.clear();
				if (e.getSource() == jbUseSelected)
					for (int i : jlExistingDescriptorTypes.getSelectedIndices())
						selectedDescriptorType.add((DescriptorType) suggestedDesctiptorTypes.getElement(i));
				DIALOG.setVisible(false);
			}
		
		public DescriptorType[] getSelectedDescriptorTypes()
			{
				return selectedDescriptorType.toArray(new DescriptorType[selectedDescriptorType.size()]);
			}
		
		public DataSource getDataSource()
			{
				return dataSource;
			}
		
		public void setDataSource(DataSource dataSource)
			{
				this.dataSource = dataSource;
			}
		
		protected void addDescriptorType()
			{
				DescriptorType newDescriptorType = new DescriptorType("NewDescriptor", "Provide short description", DataValue_String.class, null);
				dtuiDescriptorType.load(newDescriptorType, newDescriptorType.getExternalID() != 0);
			}
		
		protected void removeDescriptorType()
			{
				
			}
		
		protected JButton																			jbCancel;
		protected JScrollPane															jspExistingDescriptorTypes;
		protected JButton																			jbUseSelected;
		protected JList<String>													jlExistingDescriptorTypes;
		protected DescriptorTypeUI										dtuiDescriptorType;
		protected JLabel																				jlDescription;
		protected ListEditorToolbarUI							letuiDescriptorTypesToolbar;
		protected DataSource																dataSource													= Effectopedia.EFFECTOPEDIA.getData();
		protected JPanel																				jpExistingDescriptorTypes;
		protected ArrayList<DescriptorType>	selectedDescriptorType	= new ArrayList<DescriptorType>();
		protected FilteredIndex													suggestedDesctiptorTypes;
	}

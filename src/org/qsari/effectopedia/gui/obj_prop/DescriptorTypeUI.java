package org.qsari.effectopedia.gui.obj_prop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.tree.TreePath;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.DiscussionTopic;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.BaseValueTypes;
import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.data.objects.FixedValuesList;
import org.qsari.effectopedia.data.objects.ObjectPropertyType;
import org.qsari.effectopedia.defaults.DefaultServerSettings;
import org.qsari.effectopedia.gui.WelcomeUI;
import org.qsari.effectopedia.gui.comp.EventsManager;
import org.qsari.effectopedia.gui.core.GUIFactory;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI.ListEditorActionListener;
import org.qsari.effectopedia.system.AuthenticationManager.UserSignInListener;
import org.qsari.effectopedia.system.AuthenticationManager.UserSignOutListener;
import org.qsari.effectopedia.system.TraceableClasses;

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
public class DescriptorTypeUI extends JPanel implements LoadableEditorUI, ListEditorActionListener, UserSignInListener, UserSignOutListener, ActionListener
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
								JFrame frame = new JFrame();
								frame.setContentPane(new DescriptorTypeUI("descriptor type"));
								frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
								frame.pack();
								frame.setVisible(true);
							}
					});
			}
		
		public static String titleCase(String input)
			{
				StringBuilder sb = new StringBuilder();
				boolean capitalise = true;
				for (char c : input.toCharArray())
					{
						if (Character.isSpaceChar(c))
							capitalise = true;
						else if (capitalise)
							{
								c = Character.toTitleCase(c);
								capitalise = false;
							}
						sb.append(c);
					}
				return sb.toString();
			}
		
		protected DescriptorTypeUI()
			{
				super();
				initGUI("descriptor type");
			}
		
		protected DescriptorTypeUI(String elementTitle)
			{
				super();
				initGUI(elementTitle);
			}
		
		protected void initGUI(String title)
			{
				try
					{
						thisLayout = new GridBagLayout();
						thisLayout.rowWeights = new double[]
							{ 0.1, 0.1, 0.2, 0.0, 0.2 };
						thisLayout.rowHeights = new int[]
							{ 20, 20, 80, 91, 40 };
						thisLayout.columnWeights = new double[]
							{ 0.0, 0.0, 0.0, 0.1 };
						thisLayout.columnWidths = new int[]
							{ 76, 205, 97, 7 };
						this.setFont(new java.awt.Font("Arial", 2, 11));
						this.setLayout(thisLayout);
						this.setBackground(Color.white);
							{
								jlName = new JLabel();
								this.add(jlName, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 4, 0, 4), 0, 0));
								jlName.setText("name:");
							}
							{
								jtfName = new JTextField();
								this.add(jtfName, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jtfName.setText("Name");
							}
							{
								jlID = new JLabel();
								this.add(jlID, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 4, 0, 4), 0, 0));
								jlID.setText("ID:");
							}
							{
								jtfID = new JTextField();
								this.add(jtfID, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 4), 0, 0));
								jtfID.setText("0/0");
								jtfID.setEditable(false);
							}
							{
								jlDataType = new JLabel();
								this.add(jlDataType, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jlDataType.setText("data type:");
							}
							{
								ComboBoxModel<BaseValueTypes> jcbDataTypeModel = new DefaultComboBoxModel<BaseValueTypes>(BaseValueTypes.values());
								jcbDataType = new JComboBox<BaseValueTypes>();
								this.add(jcbDataType, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jcbDataType.setModel(jcbDataTypeModel);
								jcbDataType.setBackground(Color.white);
								jcbDataType.addActionListener(this);
							}
							{
								jlDefaultUnit = new JLabel();
								this.add(jlDefaultUnit, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jlDefaultUnit.setText("default unit: ");
							}
							{
								jtfDefaultUnit = new JTextField();
								this.add(jtfDefaultUnit, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 4), 0, 0));
							}
							{
								jspDescription = new JScrollPane();
								this.add(jspDescription, new GridBagConstraints(0, 3, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 4, 0, 4), 0, 0));
								jspDescription.setBackground(Color.white);
								jspDescription.setBorder(BorderFactory.createTitledBorder("Description"));
								jspDescription.setFont(new java.awt.Font("Dialog", 1, 11));
									{
										jtaDescription = new JTextArea();
										jtaDescription.setLineWrap(true);
										jtaDescription.setWrapStyleWord(true);
										jspDescription.setViewportView(jtaDescription);
									}
							}
							{
								jpFixedValuesList = new JPanel();
								BorderLayout jPanel1Layout = new BorderLayout();
								jpFixedValuesList.setLayout(jPanel1Layout);
								this.add(jpFixedValuesList, new GridBagConstraints(0, 4, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 4, 0, 4), 0, 0));
								jpFixedValuesList.setBorder(BorderFactory.createTitledBorder("Valid Values List"));
								jpFixedValuesList.setBackground(Color.white);
									{
										jcbUseFixedListOfValues = new JCheckBox();
										jpFixedValuesList.add(jcbUseFixedListOfValues, BorderLayout.NORTH);
										jcbUseFixedListOfValues.setText("Use controlled vocabulary / limited list of values");
										jcbUseFixedListOfValues.setBackground(Color.white);
										jcbUseFixedListOfValues.addActionListener(new ActionListener()
											{
												
												@Override
												public void actionPerformed(ActionEvent e)
													{
														if (descriptorType != null)
															{
																FixedValuesList valueList = descriptorType.getFixedValuesList();
																if (valueList != null)
																	{
																		jcbUseFixedListOfValues.setSelected(true);
																		fvlmFixedValuesListModel.setFixedValuesList(valueList);
																	}
																else if (jcbUseFixedListOfValues.isSelected())
																	{
																		valueList = new FixedValuesList();
																		descriptorType.setFixedValuesList(valueList);
																		fvlmFixedValuesListModel.setFixedValuesList(valueList);
																		// fvlmFixedValuesListModel.setReadonly(false);
																	}
															}
													}
											});
									}
									
									{
										jspFixedValuesList = new JScrollPane();
										jpFixedValuesList.add(jspFixedValuesList, BorderLayout.CENTER);
										jspFixedValuesList.setBackground(Color.white);
										jspFixedValuesList.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
											{
												fvlmFixedValuesListModel = new FixedValueListTableModel();
												jtFixedValuesList = new JTable();
												jtFixedValuesList.setBackground(Color.white);
												jspFixedValuesList.setViewportView(jtFixedValuesList);
												jtFixedValuesList.setModel(fvlmFixedValuesListModel);
												jtFixedValuesList.setTableHeader(null);
												jtFixedValuesList.setRowHeight(20);
												jtFixedValuesList.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
												jspFixedValuesList.getViewport().setBackground(Color.white);
											}
									}
									
									{
										letuiFixedValuesToolbar = new ListEditorToolbarUI(null, "fixed value", ListEditorToolbarUI.ALL, FlowLayout.RIGHT);
										jpFixedValuesList.add(letuiFixedValuesToolbar, BorderLayout.SOUTH);
										letuiFixedValuesToolbar.addListEditorActionListener(this);
									}
							}
							{
								jpObjectProperyTypeUI = new JPanel();
								GridBagLayout jpObjectProperyTypeUILayout = new GridBagLayout();
								this.add(jpObjectProperyTypeUI, new GridBagConstraints(0, 2, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(2, 4, 2, 4), 0, 0));
								jpObjectProperyTypeUI.setBackground(Color.white);
								jpObjectProperyTypeUILayout.rowWeights = new double[]
									{ 0.1, 0.1, 0.1, 0.0, 0.0 };
								jpObjectProperyTypeUILayout.rowHeights = new int[]
									{ 20, 20, 20, 20, 20 };
								jpObjectProperyTypeUILayout.columnWeights = new double[]
									{ 0.0, 0.0, 0.0, 0.0, 1, 0.0 };
								jpObjectProperyTypeUILayout.columnWidths = new int[]
									{ 72, 33, 146, 98, 117, 139 };
								jpObjectProperyTypeUI.setLayout(jpObjectProperyTypeUILayout);
									{
										jcbMultivalued = new JCheckBox();
										jpObjectProperyTypeUI.add(jcbMultivalued, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jcbMultivalued.setText("multiple ");
										jcbMultivalued.setBackground(Color.white);
										jcbMultivalued.setEnabled(false);
										jcbMultivalued.addActionListener(this);
									}
									{
										jcbDocumented = new JCheckBox();
										jpObjectProperyTypeUI.add(jcbDocumented, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 4, 0, 0), 0, 0));
										jcbDocumented.setText("docummented");
										jcbDocumented.setBackground(Color.white);
										jcbDocumented.setEnabled(false);
										jcbDocumented.addActionListener(this);
									}
									{
										jcbSearchable = new JCheckBox();
										jpObjectProperyTypeUI.add(jcbSearchable, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 4, 0, 4), 0, 0));
										jcbSearchable.setText("Searchable ");
										jcbSearchable.setBackground(Color.white);
										jcbSearchable.setEnabled(false);
									}
									{
										jlIndexName = new JLabel();
										jpObjectProperyTypeUI.add(jlIndexName, new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jlIndexName.setText("Search index name: ");
									}
									{
										jtfSearchIndexName = new JTextField();
										jpObjectProperyTypeUI.add(jtfSearchIndexName, new GridBagConstraints(3, 3, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 4, 0, 0), 0, 0));
										jtfSearchIndexName.setText("Index_Name");
										jtfSearchIndexName.setEditable(false);
									}
									{
										jlOwnerClass = new JLabel();
										jpObjectProperyTypeUI.add(jlOwnerClass, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 4, 0, 4), 0, 0));
										jlOwnerClass.setText("Can be property of: ");
									}
									{
										jcbOwnerClass = new JComboBox<String>();
										ComboBoxModel<String> jcbOwnerClassModel = new DefaultComboBoxModel<String>(TraceableClasses.REGISTERED.getAllDescendents(null));
										jcbOwnerClass.setModel(jcbOwnerClassModel);
										jpObjectProperyTypeUI.add(jcbOwnerClass, new GridBagConstraints(2, 4, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 4, 0, 0), 0, 0));
										jcbOwnerClass.setBackground(Color.white);
									}
									{
										jlDisplayName = new JLabel();
										jpObjectProperyTypeUI.add(jlDisplayName, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 4, 0, 0), 0, 0));
										jlDisplayName.setText("display name:");
									}
									{
										jtfDisplayName = new JTextField();
										jpObjectProperyTypeUI.add(jtfDisplayName, new GridBagConstraints(4, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
									}
									{
										jlCategory = new JLabel();
										jpObjectProperyTypeUI.add(jlCategory, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 4, 0, 0), 0, 0));
										jlCategory.setText("category: ");
									}
									{
										jtfCategory = new JTextField();
										jpObjectProperyTypeUI.add(jtfCategory, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jtfCategory.setText(".");
									}
									{
										jcbCategorical = new JCheckBox();
										jpObjectProperyTypeUI.add(jcbCategorical, new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jcbCategorical.setText("category only");
										jcbCategorical.setBackground(Color.white);
										jcbCategorical.setEnabled(false);
										jcbCategorical.addActionListener(this);
									}
									{
										jlAllow = new JLabel();
										jpObjectProperyTypeUI.add(jlAllow, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 4, 0, 0), 0, 0));
										jlAllow.setText("Allow: ");
										jlAllow.setEnabled(false);
									}
									{
										jlPropertyValues = new JLabel();
										jpObjectProperyTypeUI.add(jlPropertyValues, new GridBagConstraints(3, 2, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jlPropertyValues.setText("property values or use as");
										jlPropertyValues.setEnabled(false);
									}
									{
										jtfDescriptorsCaption = new JTextField();
										jpObjectProperyTypeUI.add(jtfDescriptorsCaption, new GridBagConstraints(4, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jtfDescriptorsCaption.setText("Descriptors");
									}
									{
										jlDescriptorsCaption = new JLabel();
										jpObjectProperyTypeUI.add(jlDescriptorsCaption, new GridBagConstraints(2, 1, 2, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 4, 0, 0), 0, 0));
										jlDescriptorsCaption.setText("list of descriptors dispaly caption: ");
									}
								// displayObjectPropertyTypeUI(false);
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public void displayObjectPropertyTypeUI(boolean show)
			{
				jpObjectProperyTypeUI.setVisible(show);
				if (show)
					{
						thisLayout.rowWeights[ObjPropTypeLayoutIndex] = 0.2;
						thisLayout.rowHeights[ObjPropTypeLayoutIndex] = ObjPropTypeUISize;
					}
				else
					{
						thisLayout.rowWeights[ObjPropTypeLayoutIndex] = 0.0;
						thisLayout.rowHeights[ObjPropTypeLayoutIndex] = 0;
					}
			}
		
		public void load(Object o, boolean readonly)
			{
				if (o instanceof TreePath)
					{
						path = (TreePath) o;
						o = path.getLastPathComponent();
					}
				if (!(o instanceof DescriptorType))
					{
						resetUI();
						return;
					}
				if (o == descriptorType)
					return;
				this.descriptorType = (DescriptorType) o;
				isObjectPropertyType = descriptorType instanceof ObjectPropertyType;
				displayObjectPropertyTypeUI(isObjectPropertyType);
				if (descriptorType != null)
					{
						descriptorTypeNameDoc = jtfName.getDocument();
						descriptorTypeNameDoc.removeDocumentListener(desriptorTypeNamelistener);
						listeners.unbondDocumntListener(descriptorTypeNameDoc, "Name");
						Document docDefaultUnit = jtfDefaultUnit.getDocument();
						listeners.unbondDocumntListener(docDefaultUnit, "DisplayUnit");
						Document docDescription = jtaDescription.getDocument();
						listeners.unbondDocumntListener(docDescription, "Description");
						
						jtfName.setText(descriptorType.getName());
						jtfName.setEditable(!readonly);
						jtfID.setText(descriptorType.getIDandExternalID());
						jtfDefaultUnit.setText(descriptorType.getDisplayUnit());
						jtfDefaultUnit.setEditable(!readonly);
						jtaDescription.setText(descriptorType.getDescription());
						jtaDescription.setEditable(!readonly);
						jcbDataType.setSelectedItem(BaseValueTypes.getByClass(descriptorType.getBaseValueType()));
						jcbDataType.setEnabled(!readonly);
						FixedValuesList valueList = descriptorType.getFixedValuesList();
						if (valueList != null)
							{
								jcbUseFixedListOfValues.setSelected(true);
								fvlmFixedValuesListModel.setFixedValuesList(valueList);
							}
						else
							fvlmFixedValuesListModel.setFixedValuesList(null);
						fvlmFixedValuesListModel.setReadonly(readonly);
						if (isObjectPropertyType)
							loadObjectProperties((ObjectPropertyType) descriptorType);
						descriptorTypeNameDoc.addDocumentListener(desriptorTypeNamelistener);
						listeners.bondDocumntListener(descriptorTypeNameDoc, descriptorType, "Name");
						listeners.bondDocumntListener(docDefaultUnit, descriptorType, "DisplayUnit");
						listeners.bondDocumntListener(docDescription, descriptorType, "Description");
					}
			}
		
		private void resetUI()
			{
				descriptorTypeNameDoc = jtfName.getDocument();
				descriptorTypeNameDoc.removeDocumentListener(desriptorTypeNamelistener);
				listeners.unbondDocumntListener(descriptorTypeNameDoc, "Name");
				Document docDefaultUnit = jtfDefaultUnit.getDocument();
				listeners.unbondDocumntListener(docDefaultUnit, "DisplayUnit");
				Document docDescription = jtaDescription.getDocument();
				listeners.unbondDocumntListener(docDescription, "Description");
				
				jtfName.setText(null);
				jtfID.setText(null);
				jtfDefaultUnit.setText(null);
				jtaDescription.setText(null);
				fvlmFixedValuesListModel.setFixedValuesList(null);
			}
		
		private void loadObjectProperties(ObjectPropertyType propertyType)
			{
				Document docCategory = jtfCategory.getDocument();
				listeners.unbondDocumntListener(docCategory, "Category");
				Document docDisplayName = jtfDisplayName.getDocument();
				listeners.unbondDocumntListener(docDisplayName, "DisplayName");
				Document docDescriptorsCaption = jtfDescriptorsCaption.getDocument();
				listeners.unbondDocumntListener(docDescriptorsCaption, "DescriptorsCaption");
				
				jcbCategorical.setSelected(propertyType.isCategorical());
				jcbMultivalued.setSelected(propertyType.isAcceptingMultipleValues());
				jcbDocumented.setSelected(propertyType.isDocumented());
				jcbSearchable.setSelected(propertyType.isSearchable());
				jtfCategory.setText(propertyType.getCategory());
				jtfDisplayName.setText(propertyType.getDisplayName());
				jtfDescriptorsCaption.setText(propertyType.getDescriptorsCaption());
				jtfSearchIndexName.setText(propertyType.getSearchName());
				jcbOwnerClass.setModel(new DefaultComboBoxModel<String>(TraceableClasses.REGISTERED.getAllDescendents(propertyType.getOwnerClass())));
				jcbOwnerClass.setSelectedItem(propertyType.getOwnerClass());
				
				listeners.bondDocumntListener(docCategory, propertyType, "Category");
				listeners.bondDocumntListener(docDisplayName, propertyType, "DisplayName");
				listeners.bondDocumntListener(docDescriptorsCaption, propertyType, "DescriptorsCaption");
				
				boolean isNewType = propertyType.getExternalID() == 0;
				jcbCategorical.setEnabled(isNewType);
				jtfCategory.setEditable(isNewType);
				jtfDisplayName.setEditable(isNewType);
				jtfDescriptorsCaption.setEditable(isNewType);
				jcbMultivalued.setEnabled(isNewType);
				jcbDocumented.setEnabled(isNewType);
				jcbSearchable.setEnabled(isNewType);
				jtfSearchIndexName.setEditable(isNewType);
				jcbOwnerClass.setEnabled(isNewType);
				jcbOwnerClass.setEnabled(isNewType);
			}
		
		@Override
		public int listEditorActionPerformed(int actionCode)
			{
				switch (actionCode)
					{
						case ListEditorToolbarUI.ADD:
							fvlmFixedValuesListModel.add("");
							break;
						case ListEditorToolbarUI.REMOVE:
							fvlmFixedValuesListModel.remove(jtFixedValuesList.getSelectedRow());
							break;
						case ListEditorToolbarUI.RESET:
							fvlmFixedValuesListModel.reset();
							break;
						case ListEditorToolbarUI.COPY:
							fvlmFixedValuesListModel.copy();
							break;
						case ListEditorToolbarUI.PASTE:
							fvlmFixedValuesListModel.paste();
							break;
						case ListEditorToolbarUI.DISCUSS:
							DiscussionTopic topic = DiscussionTopic.locateTopic(descriptorType);
							if (topic != null)
								UserInterface.getDefaultNavigator().navigate(UILocations.discussUIL, topic);
							else
								{
									boolean confirmation = UserInterface.getUserConfirmation("There is no discussion associated with the current object. Do you like " + (signedIn ? "" : "to sign in and ") + "create one?");
									if (confirmation)
										if (signedIn)
											UserInterface.getDefaultNavigator().navigate(UILocations.discussUIL, DiscussionTopic.locateORCreateTopic(descriptorType));
										else
											{
												pendingRedirection = true;
												Component comp = (Component) UserInterface.getDefaultNavigator().navigate(UILocations.welcomeUIL, null);
												if (comp instanceof WelcomeUI)
													((WelcomeUI) comp).load(DefaultServerSettings.signInURL, false);
											}
								}
							break;
						case ListEditorToolbarUI.CHAT:
							UserInterface.showFeedback("Chat feature is not implemented yet", "Information");
							break;
					}
				return actionCode;
			}
		
		@Override
		public void userSignedOut(EventObject evt)
			{
				signedIn = false;
			}
		
		@Override
		public void userSignedIn(EventObject evt)
			{
				signedIn = true;
				if (pendingRedirection)
					{
						pendingRedirection = false;
						UserInterface.getDefaultNavigator().navigate(UILocations.discussUIL, DiscussionTopic.locateORCreateTopic(descriptorType));
					}
			}
		
		public class NewDescriptorType implements DocumentListener
			{
				public void changedUpdate(DocumentEvent e)
					{
						bringNewDescriptorTypeToLive();
					}
				
				public void removeUpdate(DocumentEvent e)
					{
						bringNewDescriptorTypeToLive();
					}
				
				public void insertUpdate(DocumentEvent e)
					{
						bringNewDescriptorTypeToLive();
					}
				
				public void bringNewDescriptorTypeToLive()
					{
						if (descriptorType != null)
							{
								if (descriptorType.getID() == 0)
									{
										descriptorType.bringToLive();
										// descriptorTypeNameDoc.removeDocumentListener(this);
										jtfID.setText(descriptorType.getIDandExternalID());
										fireLoadDescriptorType(descriptorType, false);
									}
								if (isObjectPropertyType)
									jtfDisplayName.setText(descriptorType.getName());
								fireDescriptorTypeChanged(descriptorType);
							}
					}
			}
		
		@Override
		public void actionPerformed(ActionEvent evt)
			{
				if (descriptorType != null)
					{
						Object source = evt.getSource();
						if (source == jcbDataType)
							descriptorType.setBaseValueType(((BaseValueTypes) jcbDataType.getSelectedItem()).getValueType());
						
						if (isObjectPropertyType)
							if (source == jcbMultivalued)
								{
									boolean isMultivalued = jcbMultivalued.isSelected();
									((ObjectPropertyType) descriptorType).setAcceptingMultipleValues(isMultivalued);
									if (isMultivalued)
										jcbCategorical.setSelected(false);
								}
							else if (source == jcbDocumented)
								{
									boolean isDocumented = jcbDocumented.isSelected();
									((ObjectPropertyType) descriptorType).setDocumented(isDocumented);
									if (isDocumented)
										jcbCategorical.setSelected(false);
								}
							else if (source == jcbCategorical)
								{
									boolean isCategorical = jcbCategorical.isSelected();
									((ObjectPropertyType) descriptorType).setCategorical(isCategorical);
									if (isCategorical)
										{
											jcbMultivalued.setSelected(false);
											jcbDocumented.setSelected(false);
										}
								}
						
					}
			}
		
		public interface DescriptorTypeChangeListener extends LoadableEditorUI
			{
				public void descriptorTypeChanged(DescriptorType descriptorType);
			}
		
		public void addDescriptorTypeChangeListener(DescriptorTypeChangeListener listener)
			{
				descriptorTypeActionListeners.add(listener);
			}
		
		public void removeDescriptorTypeChangeListener(DescriptorTypeChangeListener listener)
			{
				descriptorTypeActionListeners.remove(listener);
			}
		
		protected void fireDescriptorTypeChanged(DescriptorType descriptorType)
			{
				for (DescriptorTypeChangeListener listener : descriptorTypeActionListeners)
					listener.descriptorTypeChanged(descriptorType);
			}
		
		protected void fireLoadDescriptorType(Object o, boolean readonly)
			{
				for (DescriptorTypeChangeListener listener : descriptorTypeActionListeners)
					listener.load(o, readonly);
			}
		
		public static int																																	ObjPropTypeLayoutIndex								= 2;
		public static int																																	ObjPropTypeUISize													= 80;
		protected ArrayList<DescriptorTypeChangeListener>	descriptorTypeActionListeners	= new ArrayList<DescriptorTypeChangeListener>();
		protected DataSource																														dataSource																				= Effectopedia.EFFECTOPEDIA.getData();
		private boolean																																			isObjectPropertyType;
		private JLabel																																				jlDescriptorsCaption;
		private JTextField																																jtfDescriptorsCaption;
		private JLabel																																				jlPropertyValues;
		private JLabel																																				jlAllow;
		private JCheckBox																																	jcbCategorical;
		private JTextField																																jtfCategory;
		private JLabel																																				jlCategory;
		private JTextField																																jtfDisplayName;
		private JLabel																																				jlDisplayName;
		private JComboBox<String>																									jcbOwnerClass;
		private JLabel																																				jlOwnerClass;
		private JTextField																																jtfSearchIndexName;
		private JLabel																																				jlIndexName;
		private JCheckBox																																	jcbSearchable;
		private JCheckBox																																	jcbDocumented;
		private JCheckBox																																	jcbMultivalued;
		protected JPanel																																		jpObjectProperyTypeUI;
		protected GridBagLayout																											thisLayout;
		protected EventsManager																											listeners																					= new EventsManager();
		protected NewDescriptorType																							desriptorTypeNamelistener					= new NewDescriptorType();
		protected JLabel																																		jlID;
		protected JTextField																														jtfName;
		protected JLabel																																		jlName;
		protected ListEditorToolbarUI																					letuiFixedValuesToolbar;
		protected Document																																descriptorTypeNameDoc;
		protected JTable																																		jtFixedValuesList;
		protected FixedValueListTableModel																fvlmFixedValuesListModel;
		protected JPanel																																		jpExistingDescriptorTypes;
		protected JPanel																																		jpFixedValuesList;
		protected JTextArea																															jtaDescription;
		protected JScrollPane																													jspFixedValuesList;
		protected JCheckBox																															jcbUseFixedListOfValues;
		protected JScrollPane																													jspDescription;
		protected JTextField																														jtfDefaultUnit;
		protected JLabel																																		jlDefaultUnit;
		protected JComboBox<BaseValueTypes>															jcbDataType;
		protected JLabel																																		jlDataType;
		protected JTextField																														jtfID;
		protected DescriptorType																										descriptorType;
		private boolean																																			signedIn																						= false;
		private boolean																																			pendingRedirection												= false;
		protected TreePath																																path;
	}

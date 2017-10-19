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
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.filter.FilteredIndex;
import org.qsari.effectopedia.data.filter.FilteredTreeIndex;
import org.qsari.effectopedia.data.objects.DataValue_String;
import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.data.objects.DescriptorTypesContainer;
import org.qsari.effectopedia.data.objects.ObjectPropertyType;
import org.qsari.effectopedia.data.objects.ObjectPropertyTypesContainer;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
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
public class ObjectPropertyTypeDialog extends javax.swing.JDialog implements LoadableEditorUI, ActionListener, TreeSelectionListener
	{
		/**
	 * 
	 */
		private static final long																				serialVersionUID	= -8069795493814727028L;
		
		public static final ObjectPropertyTypeDialog	DIALOG											= new ObjectPropertyTypeDialog(GUIFactory.GUI.getFrame());
		
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
		
		protected ObjectPropertyTypeDialog(JFrame frame)
			{
				super(frame);
				DataSource data = Effectopedia.EFFECTOPEDIA.getData();
				Effectopedia.EFFECTOPEDIA.getAutentication().addUserSignInListener(dtuiObjectPropertyType);
				Effectopedia.EFFECTOPEDIA.getAutentication().addUserSignOutListener(dtuiObjectPropertyType);
				suggestedObjectPropertyTypes = new FilteredTreeIndex(data == null ? null : data.getLiveIndices().getPropertyTypes());
				ownerClasses = new ArrayList<Class<? extends EffectopediaObject>>();
				ownerClasses.add(EffectopediaObject.class);
				initGUI("object property type");
				
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
										jspObjectProperties = new JSplitPane();
										jspObjectProperties.setResizeWeight(0.33);
										getContentPane().add(jspObjectProperties, new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 8, 0, 8), 0, 0));
											{
												jpExistingDescriptorTypes = new JPanel();
												jspObjectProperties.add(jpExistingDescriptorTypes, JSplitPane.LEFT);
												jpExistingDescriptorTypes.setLayout(new BorderLayout());
												jpExistingDescriptorTypes.setBorder(BorderFactory.createTitledBorder("Available " + title));
												jpExistingDescriptorTypes.setBackground(Color.white);
													{
														jlDescription = new JLabel();
														getContentPane().add(jlDescription, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 16, 0, 0), 0, 0));
														jlDescription.setText("Select one or more " + title + "s. To add a new " + title + " click on the + button at the end of the list");
													}
													{
														jspExistingObjectProperyTypes = new JScrollPane();
														jpExistingDescriptorTypes.add(jspExistingObjectProperyTypes, BorderLayout.CENTER);
														jspExistingObjectProperyTypes.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
															{
																tmExistingElementsModel = suggestedObjectPropertyTypes.getTreeModel();
																jtExistingObjectProperyTypes = new JTree();
																jtExistingObjectProperyTypes.setModel(tmExistingElementsModel);
																jtExistingObjectProperyTypes.setRootVisible(false);
																/*
																 * jtExistingObjectProperyTypes.addMouseListener(new
																 * MouseAdapter() { public void mouseClicked(MouseEvent e) {
																 * Point location = e.getPoint(); TreePath path =
																 * jtExistingObjectProperyTypes.getPathForLocation(location.x,
																 * location.y); if (path == null) return; Object obj =
																 * path.getLastPathComponent(); if (obj instanceof
																 * DescriptorType) if (e.getClickCount() == 1)
																 * dtuiObjectPropertyType.load(path, ((DescriptorType)
																 * obj).getExternalID() != 0); else if ((e.getClickCount() == 2)
																 * && (obj instanceof ObjectPropertyType)) {
																 * selectedObjectPropertyType.clear();
																 * selectedObjectPropertyType.add((ObjectPropertyType) obj);
																 * setVisible(false); } } });
																 */
																jtExistingObjectProperyTypes.addTreeSelectionListener(this);
																jspExistingObjectProperyTypes.setViewportView(jtExistingObjectProperyTypes);
																jtExistingObjectProperyTypes.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
															}
													}
													{
														letuiExistingObjectProperyTypes = new ListEditorToolbarUI(null, title, ListEditorToolbarUI.LISTACT + ListEditorToolbarUI.CLIPBACT, FlowLayout.RIGHT);
														jpExistingDescriptorTypes.add(letuiExistingObjectProperyTypes, BorderLayout.SOUTH);
														// letuiExistingObjectProperyTypes.updateEditButtons(true);
														letuiExistingObjectProperyTypes.updateEditButtons(ListEditorToolbarUI.PASTE, true);
														letuiExistingObjectProperyTypes.addListEditorActionListener(new ListEditorActionListener()
															{
																
																@Override
																public int listEditorActionPerformed(int actionCode)
																	{
																		if (actionCode == ListEditorToolbarUI.ADD)
																			addDescriptorType();
																		else if (actionCode == ListEditorToolbarUI.REMOVE)
																			removeDescriptorType();
																		else if (actionCode == ListEditorToolbarUI.RESET)
																			resetDescriptorTypes();
																		else if (actionCode == ListEditorToolbarUI.COPY)
																			copyDescriptorTypes();
																		else if (actionCode == ListEditorToolbarUI.PASTE)
																			pasteDescriptorTypes();
																		return actionCode;
																	}
															});
													}
											}
											{
												dtuiObjectPropertyType = new DescriptorTypeUI(title);
												jspObjectProperties.add(dtuiObjectPropertyType, JSplitPane.RIGHT);
												dtuiObjectPropertyType.setBorder(BorderFactory.createTitledBorder(DescriptorTypeUI.titleCase(title)));
												dtuiObjectPropertyType.addDescriptorTypeChangeListener(new DescriptorTypeUI.DescriptorTypeChangeListener()
													{
														
														@Override
														public void descriptorTypeChanged(DescriptorType descriptorType)
															{
																TreePath path = dtuiObjectPropertyType.path;
																Object[] nodes = path.getParentPath().getPath();
																int row = tmExistingElementsModel.getPathRow(path);
																path = jtExistingObjectProperyTypes.getPathForRow(row);
																for (int i = 2; i < nodes.length; i++)
																	path = path.pathByAddingChild(nodes[i]);
																jtExistingObjectProperyTypes.expandPath(path);
																jtExistingObjectProperyTypes.scrollPathToVisible(path);
																
																jtExistingObjectProperyTypes.invalidate();
																jtExistingObjectProperyTypes.validate();
																jtExistingObjectProperyTypes.repaint();
															}
														
														@Override
														public void load(Object o, boolean readonly)
															{
																ObjectPropertyTypeDialog.this.load(o, readonly);
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
				if ((o instanceof ObjectPropertyType))
					dtuiObjectPropertyType.load(o, readonly);
				selectedObjectPropertyType.clear();
				suggestedObjectPropertyTypes.clearFilters();
				suggestedObjectPropertyTypes.addClassFilter(ObjectPropertyType.class);
				suggestedObjectPropertyTypes.addOwnerClassesFilter(ownerClasses);
				suggestedObjectPropertyTypes.sort(FilteredIndex.NAME_COMPARATOR);
				boolean hasSuggestions = suggestedObjectPropertyTypes.count() > 0;
				if ((hasSuggestions) && (!readonly))
					{
						tmExistingElementsModel = suggestedObjectPropertyTypes.getTreeModel();
						jtExistingObjectProperyTypes.setModel(tmExistingElementsModel);
						if ((o instanceof ObjectPropertyType[]))
							loadSelection((ObjectPropertyType[]) o);
						setCentredLocation();
						DIALOG.setVisible(true);
					}
				else
					{
						DIALOG.setVisible(false);
						UserInterface.getDefaultNavigator().navigate(UILocations.getProperEditor(o), o);
					}
			}
		
		protected void loadSelection(ObjectPropertyType[] selection)
			{
				loading = true;
				TreeSelectionModel treeSelection = jtExistingObjectProperyTypes.getSelectionModel();
				treeSelection.clearSelection();
				treeSelection.addSelectionPaths(tmExistingElementsModel.getPaths(selection));
				loading = false;
			}
		
		public void actionPerformed(ActionEvent e)
			{
				selectedObjectPropertyType.clear();
				if (e.getSource() == jbUseSelected)
					for (TreePath selectedPath : jtExistingObjectProperyTypes.getSelectionPaths())
						if (selectedPath.getLastPathComponent() instanceof ObjectPropertyType)
							selectedObjectPropertyType.add((ObjectPropertyType) selectedPath.getLastPathComponent());
				DIALOG.setVisible(false);
			}
		
		public DescriptorType[] getSelectedDescriptorTypes()
			{
				return selectedObjectPropertyType.toArray(new DescriptorType[selectedObjectPropertyType.size()]);
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
		public void valueChanged(TreeSelectionEvent evt)
			{
				lastSelectedPath = evt.getNewLeadSelectionPath();
				if ((lastSelectedPath != null) && (!loading))
					{
						Object obj = lastSelectedPath.getLastPathComponent();
						if (obj instanceof DescriptorType)
							dtuiObjectPropertyType.load(lastSelectedPath, ((DescriptorType) obj).getExternalID() != 0);
						Object[] objects = lastSelectedPath.getPath();
						boolean existing = ((EffectopediaObject) objects[1]).getExternalID() > 0;
						boolean topLevel = objects.length == 2;
						letuiExistingObjectProperyTypes.updateEditButtons(!topLevel && existing);
						if ((obj instanceof ObjectPropertyTypesContainer) || (obj instanceof ObjectPropertyType))
							{
								mode = LISTMODE_OBJ_PROP_TYPE;
								letuiExistingObjectProperyTypes.setListName("object property type");
								letuiExistingObjectProperyTypes.updateEditButtons(ListEditorToolbarUI.COPY, false);
								letuiExistingObjectProperyTypes.updateEditButtons(ListEditorToolbarUI.PASTE, buffer.size() == 0);
							}
						else if ((obj instanceof DescriptorTypesContainer) || (obj instanceof DescriptorType))
							{
								mode = LISTMODE_DESCRIPTOR;
								letuiExistingObjectProperyTypes.setListName("descriptor type");
								letuiExistingObjectProperyTypes.updateEditButtons(ListEditorToolbarUI.CLIPBACT, true);
							}
					}
			}
		
		protected void addDescriptorType()
			{
				if (mode == LISTMODE_DESCRIPTOR)
					{
						DescriptorType newDescriptorType = new DescriptorType("NewDescriptor", "Provide short description", DataValue_String.class, null);
						TreePath path = tmExistingElementsModel.addDescriptor(lastSelectedPath, newDescriptorType);
						dtuiObjectPropertyType.load(path, newDescriptorType.getExternalID() != 0);
					}
				else if (mode == LISTMODE_OBJ_PROP_TYPE)
					{
						Class<? extends EffectopediaObject> ownerClass = ownerClasses.get(defaultOwnerClassIndex);
						ObjectPropertyType newObjectPropertyType = new ObjectPropertyType(DefaultEffectopediaObjects.getCategoryForClass(ownerClass),"DisplayName","NewObjectProperty", null, ownerClass, "Provide short description", DataValue_String.class, null,
								0);
						TreePath path = tmExistingElementsModel.addObjectPropertyType(lastSelectedPath, newObjectPropertyType);
						dtuiObjectPropertyType.load(path, newObjectPropertyType.getExternalID() != 0);
					}
			}
		
		protected void removeDescriptorType()
			{
				if (lastSelectedPath == null)
					return;
				Object obj = lastSelectedPath.getLastPathComponent();
				if ((mode == LISTMODE_OBJ_PROP_TYPE) && (obj instanceof ObjectPropertyType))
					{
						tmExistingElementsModel.removeObjectPropertyType(lastSelectedPath, (ObjectPropertyType) obj);
						dtuiObjectPropertyType.load(null, true);
					}
				else if ((mode == LISTMODE_DESCRIPTOR) && (obj instanceof DescriptorType))
					{
						tmExistingElementsModel.removeDescriptorType(lastSelectedPath, (DescriptorType) obj);
						dtuiObjectPropertyType.load(lastSelectedPath.getParentPath().getParentPath(), false);
					}
			}
		
		protected void resetDescriptorTypes()
			{
				if (lastSelectedPath == null)
					return;
				if (mode == LISTMODE_OBJ_PROP_TYPE)
					tmExistingElementsModel.resetObjectPropertyTypes(lastSelectedPath);
				else if (mode == LISTMODE_DESCRIPTOR)
					tmExistingElementsModel.resetDescriptorType(lastSelectedPath);
			}
		
		protected void copyDescriptorTypes()
			{
				buffer.clear();
				for (TreePath selectedPath : jtExistingObjectProperyTypes.getSelectionPaths())
					if (selectedPath.getLastPathComponent() instanceof ObjectPropertyType)
						buffer.add((ObjectPropertyType) selectedPath.getLastPathComponent());
				letuiExistingObjectProperyTypes.updateEditButtons(ListEditorToolbarUI.PASTE, buffer.size() == 0);
			}
		
		protected void pasteDescriptorTypes()
			{
				if (buffer.size() == 0)
					return;
				for (ObjectPropertyType pt : buffer)
					{
						ObjectPropertyType clone = pt.clone();
						clone.setIDandExternalIDtoZero();
						clone.setName("new_" + clone.getName());
						clone.bringToLive();
					}
				load(buffer, false);
			}
		
		public ArrayList<Class<? extends EffectopediaObject>> getOwnerClasses()
			{
				return ownerClasses;
			}
		
		public void setOwnerClasses(ArrayList<Class<? extends EffectopediaObject>> ownerClasses)
			{
				this.ownerClasses = ownerClasses;
			}
		
		public int getDefaultOwnerClassIndex()
			{
				return defaultOwnerClassIndex;
			}
		
		public void setDefaultOwnerClassIndex(int defaultOwnerClassIndex)
			{
				this.defaultOwnerClassIndex = defaultOwnerClassIndex;
			}
		
		protected ArrayList<Class<? extends EffectopediaObject>>						ownerClasses;
		protected int																																																	defaultOwnerClassIndex					= 0;
		protected int																																																	LISTMODE_NONE														= 0;
		protected int																																																	LISTMODE_DESCRIPTOR								= 1;
		protected int																																																	LISTMODE_OBJ_PROP_TYPE					= 2;
		protected int																																																	mode																							= LISTMODE_OBJ_PROP_TYPE;
		protected TreePath																																												lastSelectedPath;
		protected JButton																																													jbCancel;
		protected JScrollPane																																									jspExistingObjectProperyTypes;
		protected JButton																																													jbUseSelected;
		protected FilteredTreeIndex.FilteredObjectPropertiesTreeModel	tmExistingElementsModel;
		protected JTree																																															jtExistingObjectProperyTypes;
		protected DescriptorTypeUI																																				dtuiObjectPropertyType;
		protected JLabel																																														jlDescription;
		protected ListEditorToolbarUI																																	letuiExistingObjectProperyTypes;
		protected DataSource																																										dataSource																	= Effectopedia.EFFECTOPEDIA.getData();
		protected JPanel																																														jpExistingDescriptorTypes;
		protected ArrayList<ObjectPropertyType>																							selectedObjectPropertyType	= new ArrayList<ObjectPropertyType>();
		protected FilteredTreeIndex																																			suggestedObjectPropertyTypes;
		protected JSplitPane																																										jspObjectProperties;
		private boolean																																															loading																				= false;
		private ArrayList<ObjectPropertyType>																									buffer																					= new ArrayList<ObjectPropertyType>();
	}

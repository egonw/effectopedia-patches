package org.qsari.effectopedia.gui.obj_prop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.WindowConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.objects.ObjectPropertyType;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.UIResources;
import org.qsari.effectopedia.gui.comp.EventsManager;
import org.qsari.effectopedia.gui.comp.custom_table_header.ComponentTableHeaderRenderer;
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
public class DocObjectPropertyUI extends JPanel implements ChangeListener, PropertyChangeListener, LoadableEditorUI, TableModelListener
	{
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new DocObjectPropertyUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public DocObjectPropertyUI()
			{
				super();
				initGUI();
				listeners = new EventsManager();
			}
		
		@SuppressWarnings("serial")
		private void initGUI()
			{
				try
					{
							{
								this.setPreferredSize(optimalSize);
								this.setMinimumSize(minimalSize);
								GridBagLayout thisLayout = new GridBagLayout();
								this.setBackground(Color.white);
								thisLayout.rowWeights = new double[]
									{ 0.0, 0.0, 0.1 };
								thisLayout.rowHeights = new int[]
									{ 28, 43, 7 };
								thisLayout.columnWeights = new double[]
									{ 0.2, 0.0, 0.0, 0.1 };
								thisLayout.columnWidths = new int[]
									{ 7, 217, 98, 7 };
								this.setLayout(thisLayout);
									{
										jtfParameterName = new JTextField();
										this.add(jtfParameterName, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jtfParameterName.setText("Undefined Paramater Name");
										jtfParameterName.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
										jtfParameterName.setFont(new java.awt.Font("Tahoma", 1, 14));
									}
									{
										jlSystemName = new JLabel();
										this.add(jlSystemName, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jlSystemName.setText("System identifier: ");
									}
									{
										jtfSystemIdentifier = new JTextField();
										this.add(jtfSystemIdentifier, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jtfSystemIdentifier.setText("ParameterID");
										jtfSystemIdentifier.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
									}
									{
										jspDocumentedValues = new JScrollPane();
										jspDocumentedValues.setBackground(Color.WHITE);
										jspDocumentedValues.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
										this.add(jspDocumentedValues, new GridBagConstraints(0, 2, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
											// jspDocumentedValues.setColumnHeader(new JViewport() {
											// @Override public Dimension getPreferredSize() {
											// Dimension d = super.getPreferredSize();
											// d.height = HEADER_HEIGHT;
											// return d;
											// }
											// jspDocumentedValues.setBackground(Color.white);
											{
												dpjtValuesModel = new DocObjectPropertyTableModel(objectProperty);
												dpjtValuesModel.addTableModelListener(this);
												jtValues = new JTable();
												jtValues.setBackground(Color.white);
												jspDocumentedValues.setViewportView(jtValues);
												jspDocumentedValues.getViewport().setBackground(Color.white);
												jtValues.setModel(dpjtValuesModel);
												lastValueColumnHeader = new ComponentTableHeaderRenderer(getAddValueButton());
												nondefaultValueColumnHeader = new ArrayList<ComponentTableHeaderRenderer>();
												jtValues.addPropertyChangeListener(this);
												jtValues.setRowHeight(ROW_HEIGHT);
												jtValues.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
											}
											{
												// FixedColumnTable fct = new
												// FixedColumnTable(1,jspDocumentedValues,null);
												jtHeaders = new JTable()
													{
														public TableCellEditor getCellEditor(int row, int col)
															{
																switch (dpjtValuesModel.getRowType(row))
																	{
																		case DocObjectPropertyTableModel.DESCRIPTOR_LIST_ROW:
																			return descriptorListEditor;
																		case DocObjectPropertyTableModel.DESCRIPTOR_ROW:
																			return descriptorEditor;
																		default:
																			return jtValues.getDefaultEditor(String.class);
																	}
															}
													};
												jtHeaders.setBackground(new Color(0xEE, 0xEE, 0xEE));
												synchroniseTables(jtHeaders, jtValues, jspDocumentedValues);
												updateColumnInterface();
											}
									}
									{
										jspDescription = new JScrollPane();
										this.add(jspDescription, new GridBagConstraints(0, 1, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
											{
												jtpDescription = new JTextPane();
												jspDescription.setViewportView(jtpDescription);
											}
									}
								
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		private JButton getAddValueButton()
			{
				jbAddValue = new JButton(new AddValueAction());
				jbAddValue.setMaximumSize(BUTTON_SIZE);
				jbAddValue.setFocusPainted(false);
				jbAddValue.setHideActionText(DefaultGOSettings.hideActionText);
				return jbAddValue;
			}
		
		private JButton getRemoveValueButton(int columnIndex)
			{
				JButton jbRemoveValue = new JButton(new RemoveValueAction());
				jbRemoveValue.putClientProperty(COLUMN_INEDX, columnIndex);
				jbRemoveValue.setMaximumSize(BUTTON_SIZE);
				jbRemoveValue.setFocusPainted(false);
				jbRemoveValue.setHideActionText(DefaultGOSettings.hideActionText);
				return jbRemoveValue;
			}
		
		public class AddValueAction extends AbstractAction
			{
				/**
		 * 
		 */
				private static final long	serialVersionUID	= 1L;
				
				public AddValueAction()
					{
						String actionName = "add";
						putValue(Action.NAME, actionName);
						putValue(Action.SMALL_ICON, UIResources.imageIconAdd);
						putValue(Action.SHORT_DESCRIPTION, "Add parameter value");
						getActionMap().put(actionName, this);
					}
				
				public void actionPerformed(ActionEvent event)
					{
						dpjtValuesModel.addValue();
					}
			}
		
		public class RemoveValueAction extends AbstractAction
			{
				/**
	 * 
	 */
				private static final long	serialVersionUID	= 1L;
				
				public RemoveValueAction()
					{
						String actionName = "remove";
						putValue(Action.NAME, actionName);
						putValue(Action.SMALL_ICON, UIResources.imageIconDelete);
						putValue(Action.SHORT_DESCRIPTION, "Remove parameter value");
						getActionMap().put(actionName, this);
					}
				
				public void actionPerformed(ActionEvent event)
					{
						Integer columnIndex = (Integer)((JButton)event.getSource()).getClientProperty(COLUMN_INEDX);
						System.out.println("Remove column:" + columnIndex);
						if (columnIndex != -1)
							{
								dpjtValuesModel.removeValue(columnIndex);
								//updateColumns();
							}
					}
			}
		
		private void updateColumns()
			{
				int valuesCnt = dpjtValuesModel.getColumnCount();
				TableColumnModel columnModel = jtValues.getColumnModel();
				System.out.println("Before Update: Values count "+valuesCnt+" value table columns count = "+columnModel.getColumnCount());
				while (columnModel.getColumnCount() > valuesCnt - fixedColumns)
					{
						TableColumn column = columnModel.getColumn(0);
						columnModel.removeColumn(column);
					}
				System.out.println("After Update: Values count "+valuesCnt+" value table columns count = "+columnModel.getColumnCount());
				updateColumnInterface();
			}
		
		@Override
		public void tableChanged(TableModelEvent e)
			{
				System.out.println("Table changed");
				updateColumns();
			}
		
		private void updateColumnInterface()
			{
				TableColumnModel columnModel = jtValues.getColumnModel();
				int cnt = columnModel.getColumnCount();
				TableColumn column;
				int size = nondefaultValueColumnHeader.size();
				while (size < cnt - 1)
					nondefaultValueColumnHeader.add(new ComponentTableHeaderRenderer(getRemoveValueButton(size++)));
				boolean canRemove = cnt>2;
				for (int i = 0; i < cnt - 1; i++)
					{
						column = columnModel.getColumn(i);
						column.setPreferredWidth(144);
						column.setHeaderRenderer(canRemove?nondefaultValueColumnHeader.get(i):null);
					}
				column = columnModel.getColumn(cnt - 1);
				column.setPreferredWidth(24);
				column.setMaxWidth(24);
				column.setHeaderRenderer(lastValueColumnHeader);
				
				jtHeaders.getColumnModel().getColumn(0).setHeaderRenderer(null);
				
				JScrollBar h = jspDocumentedValues.getHorizontalScrollBar();
				if (h != null)
					h.setValue(h.getMaximum());
				jtValues.invalidate();
			}
		
		private void synchroniseTables(JTable header, JTable valuesTable, JScrollPane scrollPane)
			{
				valuesTable.setAutoCreateColumnsFromModel(true);
				
				header.setAutoCreateColumnsFromModel(false);
				header.setModel(valuesTable.getModel());
				header.setSelectionModel(valuesTable.getSelectionModel());
				header.setFocusable(false);
				header.setRowHeight(valuesTable.getRowHeight());
				
				// Remove the fixed columns from the main table
				// and add them to the header table
				
				TableColumnModel columnModel = valuesTable.getColumnModel();
				for (int i = 0; i < fixedColumns; i++)
					{
						TableColumn column = columnModel.getColumn(0);
						columnModel.removeColumn(column);
						header.getColumnModel().addColumn(column);
					}
				
				// Add the fixed table to the scroll pane
				
				header.setPreferredScrollableViewportSize(header.getPreferredSize());
				scrollPane.setRowHeaderView(header);
				scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, header.getTableHeader());
				
				// Synchronize scrolling of the row header with the main table
				
				scrollPane.getRowHeader().addChangeListener(this);
				
			}
		
		public void stateChanged(ChangeEvent e)
			{
				JViewport viewport = (JViewport) e.getSource();
				jspDocumentedValues.getVerticalScrollBar().setValue(viewport.getViewPosition().y);
			}
		
		public void propertyChange(PropertyChangeEvent e)
			{
				if ("selectionModel".equals(e.getPropertyName()))
					jtHeaders.setSelectionModel(jtValues.getSelectionModel());
				if ("model".equals(e.getPropertyName()))
					jtHeaders.setModel(jtValues.getModel());
			}
		
		public class DescriptorEditor extends JPanel implements TableCellEditor
			{
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				private String												actionName;
				private String												actionDescription;
				private int															actionType							= ADD;
				private String												label;
				private boolean											editable;
				
				public static final int			ADD														= 0;
				public static final int			REMOVE											= 1;
				
				public DescriptorEditor(String label, String objectType, int actionType, boolean editable)
					{
						super();
						this.label = label;
						this.editable = editable;
						this.actionType = actionType;
						this.actionName = (actionType == 0) ? "add" : "remove";
						this.actionDescription = actionName + " " + objectType;
						initGUI();
					}
				
				public void initGUI()
					{
						try
							{
									{
										BorderLayout thisLayout = new BorderLayout();
										this.setLayout(thisLayout);
											{
												jtfDescriptor = new JTextField();
												this.add(jtfDescriptor, BorderLayout.CENTER);
												jtfDescriptor.setText("");
												jtfDescriptor.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
												jtfDescriptor.setEditable(editable);
												
											}
											{
												jlDescriptor = new JLabel();
												this.add(jlDescriptor, BorderLayout.WEST);
												jlDescriptor.setText(label);
											}
											{
												jbAction = getDescriptorActionButton();
												this.add(jbAction, BorderLayout.EAST);
											}
									}
								
							}
						catch (Exception e)
							{
								e.printStackTrace();
							}
					}
				
				private JButton getDescriptorActionButton()
					{
						jbAction = new JButton(new DescriptorAction());
						jbAction.setMaximumSize(BUTTON_SIZE);
						jbAction.setPreferredSize(BUTTON_SIZE);
						jbAction.setFocusPainted(false);
						jbAction.setHideActionText(DefaultGOSettings.hideActionText);
						return jbAction;
					}
				
				public class DescriptorAction extends AbstractAction
					{
						/**
				 * 
				 */
						private static final long	serialVersionUID	= 1L;
						
						public DescriptorAction()
							{
								putValue(Action.NAME, actionName);
								putValue(Action.SMALL_ICON, (actionType == ADD) ? UIResources.imageIconAdd : UIResources.imageIconDelete);
								putValue(Action.SHORT_DESCRIPTION, actionDescription);
								getActionMap().put(actionName, this);
							}
						
						public void actionPerformed(ActionEvent event)
							{
								if (actionType == ADD)
									dpjtValuesModel.addDescriptor();
								jtValues.invalidate();
							}
					}
				
				@Override
				public void addCellEditorListener(CellEditorListener arg0)
					{
						// TODO Auto-generated method stub
						
					}
				
				@Override
				public void cancelCellEditing()
					{
						// TODO Auto-generated method stub
						
					}
				
				@Override
				public Object getCellEditorValue()
					{
						// TODO Auto-generated method stub
						return null;
					}
				
				@Override
				public boolean isCellEditable(EventObject arg0)
					{
						return true;
					}
				
				@Override
				public void removeCellEditorListener(CellEditorListener arg0)
					{
						// TODO Auto-generated method stub
						
					}
				
				@Override
				public boolean shouldSelectCell(EventObject arg0)
					{
						return false;
					}
				
				@Override
				public boolean stopCellEditing()
					{
						return true;
					}
				
				@Override
				public Component getTableCellEditorComponent(JTable arg0, Object arg1, boolean arg2, int arg3, int arg4)
					{
						return this;
					}
				
				private JButton				jbAction;
				private JLabel					jlDescriptor;
				private JTextField	jtfDescriptor;
				
			}
		
		@Override
		public void load(Object o, boolean readonly)
			{
				if ((o == null) || !(o instanceof ObjectPropertyMultivalued_Documented))
					return;
				objectProperty = (ObjectPropertyMultivalued_Documented) o;
				propertyType = (ObjectPropertyType) objectProperty.getType();
				// uninstall the document listeneres for the previous topic loaded in this
				// interface
				listeners.unbondDocumntListener(jtfParameterName.getDocument(), "Name");
				// listeners.unbondDocumntListener(jtfSystemIdentifier.getDocument(),
				// "ParameterID");
				listeners.unbondDocumntListener(jtpDescription.getDocument(), "Description");
				jtfParameterName.setText(propertyType.getName());
				jtfParameterName.setEditable(!readonly);
				jtfSystemIdentifier.setText("ParameterID");
				jtfSystemIdentifier.setEditable(!readonly);
				jtpDescription.setText(propertyType.getDescription());
				jtpDescription.setEditable(!readonly);
				dpjtValuesModel.setObjectProperty(objectProperty);
				listeners.bondDocumntListener(jtfParameterName.getDocument(), propertyType, "Name");
				listeners.bondDocumntListener(jtpDescription.getDocument(), propertyType, "Description");
			}
		
		public static final int																													ROW_HEIGHT											= 24;
		public static final int																													HEADER_HEIGHT								= 24;
		public static final Dimension																							BUTTON_SIZE										= new Dimension(24, 24);
		private ComponentTableHeaderRenderer																lastValueColumnHeader;
		private ArrayList<ComponentTableHeaderRenderer>					nondefaultValueColumnHeader;
		private Dimension																																			optimalSize										= new java.awt.Dimension(600, 400);
		private Dimension																																			minimalSize										= new java.awt.Dimension(380, 320);
		private JTextField																																		jtfParameterName;
		private JTextField																																		jtfSystemIdentifier;
		private JTextPane																																			jtpDescription;
		private JScrollPane																																	jspDescription;
		private JTable																																						jtValues;
		private JTable																																						jtHeaders;
		private JScrollPane																																	jspDocumentedValues;
		private JLabel																																						jlSystemName;
		private JButton																																					jbAddValue;
		protected DocObjectPropertyTableModel															dpjtValuesModel;
		private DescriptorEditor																												descriptorListEditor	= new DescriptorEditor("", "Descriptor", DescriptorEditor.ADD, false);
		private DescriptorEditor																												descriptorEditor					= new DescriptorEditor(" - ", "descriptor", DescriptorEditor.REMOVE, true);
		private int																																									fixedColumns									= 1;
		private static ObjectPropertyType																			propertyType									= new ObjectPropertyType();
		private static ObjectPropertyMultivalued_Documented	objectProperty							= new ObjectPropertyMultivalued_Documented(null, propertyType);
		private EventsManager																															listeners;
		private static final String																									COLUMN_INEDX									= "columnIndex";
	}

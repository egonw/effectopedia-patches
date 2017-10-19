package org.qsari.effectopedia.gui.obj_prop;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.objects.ObjectPropertyType;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.SizeOptimizableUI;
import org.qsari.effectopedia.gui.UIResources;
import org.qsari.effectopedia.gui.comp.EventsManager;
import org.qsari.effectopedia.gui.comp.custom_table_header.ComponentTableHeaderRenderer;
import org.qsari.effectopedia.gui.core.GUIFactory;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.obj_prop.ObjectPropertyTableModel.ObjectPropertyChangeListener;
import org.qsari.effectopedia.gui.obj_prop.SubPropertiesEditor.CellEditorActionListener;

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
public class ObjectPropertyEditorUI extends ContextSensitivePanel implements ChangeListener, PropertyChangeListener, LoadableEditorUI, TableModelListener, ComponentListener, SizeOptimizableUI,
		CellEditorActionListener
	{
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new ObjectPropertyEditorUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public ObjectPropertyEditorUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				initGUI();
				listeners = new EventsManager();
			}
		
		@SuppressWarnings("serial")
		private void initGUI()
			{
				try
					{
							{
								this.addComponentListener(this);
								thisLayout = new GridBagLayout();
								this.setBackground(Color.white);
								thisLayout.rowWeights = new double[]
									{ 0.0, 0.0, 0.1 };
								thisLayout.rowHeights = new int[]
									{ 20, 40, 40 };
								thisLayout.columnWeights = new double[]
									{ 0.0, 0.0, 0.0, 0.1 };
								thisLayout.columnWidths = new int[]
									{ 70, 217, 70, 7 };
								this.setLayout(thisLayout);
								// this.setBorder(BorderFactory.createTitledBorder("Category.ParameterName (system identifier: identifier)"));
								this.setBorder(BorderFactory.createEmptyBorder());
									{
										jlDescription = new JLabel();
										this.add(jlDescription, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 0, 0, 0), 0, 0));
										jlDescription.setText("description: ");
										jlDescription.setAlignmentY(0.0f);
										jlDescription.setHorizontalAlignment(SwingConstants.RIGHT);
										jlDescription.setFont(new java.awt.Font("Segoe UI", 2, 12));
									}
									{
											{
												jspDescription = new JScrollPane();
												this.add(jspDescription, new GridBagConstraints(1, 0, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
												jspDescription.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.lightGray));
													{
														jtpDescription = new JTextPane();
														jspDescription.setViewportView(jtpDescription);
														jtpDescription.setPreferredSize(new java.awt.Dimension(489, 40));
													}
											}
										jspDocumentedValues = new JScrollPane();
										jspDocumentedValues.setBackground(Color.WHITE);
										jspDocumentedValues.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
										this.add(jspDocumentedValues, new GridBagConstraints(0, 1, 4, 1, 0.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
											// jspDocumentedValues.setColumnHeader(new JViewport() {
											// @Override public Dimension getPreferredSize() {
											// Dimension d = super.getPreferredSize();
											// d.height = HEADER_HEIGHT;
											// return d;
											// }
											// jspDocumentedValues.setBackground(Color.white);
											{
												optbValuesModel = new ObjectPropertyTableModel(objectProperty);
												optbValuesModel.addTableModelListener(this);
												subPropertiesEditor = new SubPropertiesEditor(rootHelpContext);
												subPropertiesEditor.addCellEditorActionListener(this);
												jtValues = new JTable()
													{
														public TableCellEditor getCellEditor(int row, int col)
															{
																if ((optbValuesModel.isAllowSubPtop()) && (optbValuesModel.rowCount - 1 == row))
																	return subPropertiesEditor;
																return super.getCellEditor(row, col);
															}
													};
												jtValues.setBackground(Color.white);
												jspDocumentedValues.setViewportView(jtValues);
												jspDocumentedValues.getViewport().setBackground(Color.white);
												jtValues.setModel(optbValuesModel);
												lastValueColumnHeader = new ComponentTableHeaderRenderer(getAddValueButton());
												nondefaultValueColumnHeader = new ArrayList<ComponentTableHeaderRenderer>();
												jtValues.addPropertyChangeListener(this);
												jtValues.setRowHeight(ROW_HEIGHT);
												jtValues.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
												((DefaultCellEditor) jtValues.getDefaultEditor(Object.class)).setClickCountToStart(1);
											}
											{
												jtHeaders = new JTable();
												jtHeaders.setBackground(new Color(0xEE, 0xEE, 0xEE));
												jtHeaders.setPreferredSize(new Dimension(200, 360));
												synchroniseTables(jtHeaders, jtValues, jspDocumentedValues);
												updateColumnInterface();
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
				jbRemoveValue.setText(columnIndex == 0 ? "default value" : "value " + columnIndex);
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
						//System.out.println("add " + event.getWhen());
						optbValuesModel.addValue();
						jtHeaders.revalidate();
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
						final Integer columnIndex = (Integer) ((JButton) event.getSource()).getClientProperty(COLUMN_INEDX);
						if (columnIndex != -1)
							{
								//System.out.println("remove " + event.getWhen());
								optbValuesModel.removeValue(columnIndex);
								jtHeaders.revalidate();
							}
					}
			}
		
		private void updateColumns()
			{
				int valuesCnt = optbValuesModel.getColumnCount();
				TableColumnModel columnModel = jtValues.getColumnModel();
				// System.out.println("Before Update: Values count " + valuesCnt +
				// " value table columns count = " + columnModel.getColumnCount());
				while (columnModel.getColumnCount() > valuesCnt - fixedColumns)
					{
						TableColumn column = columnModel.getColumn(0);
						columnModel.removeColumn(column);
					}
				// System.out.println("After Update: Values count " + valuesCnt +
				// " value table columns count = " + columnModel.getColumnCount());
				updateColumnInterface();
			}
		
		@Override
		public void tableChanged(TableModelEvent e)
			{
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
				JTableHeader header = jtValues.getTableHeader();
				MouseListener[] listeners = header.getMouseListeners();
				for (MouseListener l : listeners)
					header.removeMouseListener(l);
				boolean canRemove = cnt > 2;
				updateOptimalColumnSize();
				for (int i = 0; i < cnt - 1; i++)
					{
						column = columnModel.getColumn(i);
						column.setResizable(false);
						column.setWidth(optimalWidth);
						column.setPreferredWidth(optimalWidth);
						ComponentTableHeaderRenderer renderer = nondefaultValueColumnHeader.get(i);
						if (canRemove)
							{
								renderer.listenForMouseEvents(true);
								column.setHeaderRenderer(renderer);
							}
						else
							column.setHeaderRenderer(null);
						if (optbValuesModel.isAllowSubPtop())
							column.setCellRenderer(subPropertiesRenderer);
						else
							column.setCellRenderer(null);
					}
				column = columnModel.getColumn(cnt - 1);
				column.setPreferredWidth(24);
				column.setMaxWidth(24);
				lastValueColumnHeader.setColumn(cnt - 1);
				column.setHeaderRenderer(lastValueColumnHeader);
				lastValueColumnHeader.listenForMouseEvents(true);
				
				column = jtHeaders.getColumnModel().getColumn(0);
				column.setHeaderRenderer(null);
				
				JScrollBar h = jspDocumentedValues.getHorizontalScrollBar();
				if (h != null)
					h.setValue(h.getMaximum());

				int optHeight = showValueTable ? optbValuesModel.rowCount * ROW_HEIGHT + 18 : 0;
				thisLayout.rowHeights[1] = optHeight;
				jtValues.setPreferredSize(new Dimension(optimalWidth * (cnt-1) + 24, optHeight));

				jtValues.scrollRectToVisible(jtValues.getCellRect(0, optbValuesModel.colCount - 1, true));
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
		
		@Override
		public void load(Object o, boolean readonly)
			{
				this.readonly = readonly;
				if (o instanceof ObjectProperty)
					{
						objectProperty = (ObjectProperty) o;
						propertyType = (ObjectPropertyType) objectProperty.getType();
						jtpDescription.setEditable(!readonly);
						loadTypeInfo();
						loadProperty();
						loadSubProperties(objectProperty.getValueAndUnit().getSubProperties());
						updateOptimalSize();
					}
			}
		
		protected void loadTypeInfo()
			{
				StringBuilder sb = new StringBuilder();
				String tmp = propertyType.getCategory();
				if ((tmp != null) && (tmp != "."))
					sb.append(tmp);
				tmp = propertyType.getDisplayName();
				if (tmp != null)
					sb.append(tmp);
				else
					sb.append("Undefined display name");
				propertyName = sb.toString();
				sb.append("   (system identifier: ");
				sb.append(propertyType.getName());
				sb.append(")");
				// this.setBorder(BorderFactory.createTitledBorder(null, sb.toString(),
				// TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new
				// java.awt.Font("Segoe UI", 2, 14), DefaultGOSettings.captionColor));
				listeners.unbondDocumntListener(jtpDescription.getDocument(), "Description");
				jtpDescription.setText(propertyType.getDescription());
				listeners.bondDocumntListener(jtpDescription.getDocument(), propertyType, "Description");
			}
		
		protected void loadProperty()
			{
				showValueTable = propertyType.isAcceptingMultipleValues() || propertyType.isDocumented() || propertyType.getSubPropertyTypes() != null;
				jspDocumentedValues.setVisible(showValueTable);
				if (showValueTable)
					{
						optbValuesModel.setObjectProperty(objectProperty);
						thisLayout.rowWeights[1] = 0.0D;
						thisLayout.rowHeights[1] = optbValuesModel.rowCount * ROW_HEIGHT + 32;
						boolean allowColumnEdit = !readonly && propertyType.isAcceptingMultipleValues();
						lastValueColumnHeader.getEditor().setEnabled(allowColumnEdit);
						for (ComponentTableHeaderRenderer renderer : nondefaultValueColumnHeader)
							renderer.getEditor().setEnabled(allowColumnEdit);
					}
				else
					{
						thisLayout.rowWeights[1] = 0.0D;
						thisLayout.rowHeights[1] = 0;
					}
			}
		
		protected void loadSubProperties(ObjectProperties subProperties)
			{
				if ((subProperties != null) && (subProperties.getTypes().size() > 0))
					{
						if (opluiSubPropertiesList == null)
							{
								opluiSubPropertiesList = new ObjectPropertiesListUI("Subproperties", "add " + propertyName, propertyType.getCategory(),rootHelpContext);
								this.add(opluiSubPropertiesList, new GridBagConstraints(0, 2, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
							}
						opluiSubPropertiesList.load(subProperties, readonly);
						opluiSubPropertiesList.invalidate();
						opluiSubPropertiesList.setVisible(true);
						thisLayout.rowWeights[2] = 0.0D;
						thisLayout.rowHeights[2] = opluiSubPropertiesList.getPreferredSize().height;
					}
				else
					{
						if (opluiSubPropertiesList != null)
							opluiSubPropertiesList.setVisible(false);
						thisLayout.rowWeights[2] = 0.0D;
						thisLayout.rowHeights[2] = 0;
					}
				
				TableColumnModel columnModel = jtValues.getColumnModel();
				int cnt = columnModel.getColumnCount();
				for (int i = 0; i < cnt - 1; i++)
					{
						TableColumn column = columnModel.getColumn(i);
						if (optbValuesModel.isAllowSubPtop())
							column.setCellRenderer(subPropertiesRenderer);
						else
							column.setCellRenderer(null);
					}
			}
		
		public void addObjectPropertyChangeListener(ObjectPropertyChangeListener listener)
			{
				optbValuesModel.addObjectPropertyChangeListener(listener);
			}
		
		public void removeObjectPropertyChangeListener(ObjectPropertyChangeListener listener)
			{
				optbValuesModel.removeObjectPropertyChangeListener(listener);
			}
		
		@Override
		public void componentResized(ComponentEvent e)
			{
				// availableWidth = GUIFactory.GUI.getFrame().getWidth()-
				// jtHeaders.getWidth() - 92;
				availableWidth = getParent().getWidth() - jtHeaders.getWidth() - 34;
				if (jspDocumentedValues.getVerticalScrollBar().isVisible())
					availableWidth -= jspDocumentedValues.getVerticalScrollBar().getPreferredSize().width;
				updateColumnInterface();
			}
		
		protected void updateOptimalColumnSize()
			{
				int columnCount = jtValues.getColumnCount() - 1;
				if (columnCount > 0)
					optimalWidth = availableWidth / columnCount;
				if (optimalWidth < minColumnWidth)
					optimalWidth = minColumnWidth;
				if (optimalWidth > maxColumnWidth)
					optimalWidth = maxColumnWidth;
			}
		
		@Override
		public void componentMoved(ComponentEvent e)
			{
			}
		
		@Override
		public void componentShown(ComponentEvent e)
			{
			}
		
		@Override
		public void componentHidden(ComponentEvent e)
			{
			}
		
		public void updateOptimalSize()
			{
				optimalSize.height = showValueTable ? optbValuesModel.rowCount * ROW_HEIGHT + 18 : 0;
				if (jspDocumentedValues.getHorizontalScrollBar().isVisible())
					optimalSize.height += 16;
				thisLayout.rowHeights[1] = optimalSize.height;
				optimalSize.width = optimalWidth * (optbValuesModel.colCount) + 24;
				jtValues.setPreferredSize(optimalSize);
				int headerWidth = jtHeaders.getPreferredSize().width;
				jtHeaders.setPreferredSize(new Dimension(headerWidth, optimalSize.height));
				optimalSize.width += headerWidth + 34;
				optimalSize.width = Math.max(availableWidth, optimalSize.width);
				jspDocumentedValues.setPreferredSize(optimalSize);
				optimalSize.height += jtpDescription.getPreferredSize().height;
				if ((opluiSubPropertiesList != null) && (opluiSubPropertiesList.isVisible()))
					{
						optimalSize.height += opluiSubPropertiesList.getPreferredSize().height;
						thisLayout.rowHeights[2] = opluiSubPropertiesList.getPreferredSize().height;
					}
				this.setPreferredSize(optimalSize);
				Container parent = getParent();
				while (parent != null)
					{
						if (parent instanceof SizeOptimizableUI)
							{
								((SizeOptimizableUI) parent).updateOptimalSize();
								break;
							}
						parent = parent.getParent();
					}
			}
		
		public void setNameWidth(int nameWidth)
			{
				this.nameWidth = nameWidth;
				jlDescription.setPreferredSize(new Dimension(nameWidth, jlDescription.getPreferredSize().height));
				thisLayout.columnWidths[0] = nameWidth;
				Dimension headerSize = new Dimension(nameWidth + 1, 360);
				jtHeaders.setPreferredSize(headerSize);
				jtHeaders.setPreferredScrollableViewportSize(headerSize);
				jtHeaders.invalidate();
				jlDescription.invalidate();
			}
		
		@Override
		public void cellEditorActionPerformed(EventObject evt)
			{
				if (evt.getSource() != subPropertiesEditor)
					return;
				int state = subPropertiesEditor.getState();
				int index = subPropertiesEditor.getEditorColumn();
				index = optbValuesModel.updatesubPropertyStatus(state, index);
				if (index < 0)
					loadSubProperties(null);
				else if (index == 0)
					loadSubProperties(objectProperty.getValueAndUnit().getSubProperties());
				else if (index > 0)
					loadSubProperties(((ObjectPropertyMultivalued) objectProperty).getValueAndUnitPair(index).getSubProperties());
				updateOptimalSize();
			}
		
		public static final int																									ROW_HEIGHT												= 24;
		public static final int																									HEADER_HEIGHT									= 24;
		public static final Dimension																			BUTTON_SIZE											= new Dimension(24, 24);
		private ComponentTableHeaderRenderer												lastValueColumnHeader;
		protected SubPropertiesEditor																			subPropertiesEditor;
		protected SubPropertiesEditor																			subPropertiesRenderer	= new SubPropertiesEditor(rootHelpContext);
		private ArrayList<ComponentTableHeaderRenderer>	nondefaultValueColumnHeader;
		protected int																																			minColumnWidth								= 160;
		protected int																																			maxColumnWidth								= 400;
		protected int																																			optimalWidth										= 300;
		protected int																																			availableWidth								= GUIFactory.GUI.getFrame().getWidth() - 300;
		protected int																																			nameWidth													= 0;
		
		protected int																																			fixedColumns										= 1;
		protected GridBagLayout																									thisLayout;
		protected String																																propertyName;
		protected boolean																															readonly;
		protected boolean																															showValueTable								= true;
		protected Dimension																													optimalSize											= new java.awt.Dimension(600, 120);
		private JTextPane																															jtpDescription;
		private JScrollPane																													jspDescription;
		private JTable																																		jtValues;
		private JTable																																		jtHeaders;
		private JScrollPane																													jspDocumentedValues;
		private JButton																																	jbAddValue;
		protected ObjectPropertyTableModel														optbValuesModel;
		private JLabel																																		jlDescription;
		private EventsManager																											listeners;
		
		protected ObjectPropertyType																				propertyType										= new ObjectPropertyType();
		protected ObjectProperty																								objectProperty								= new ObjectPropertyMultivalued_Documented(null, propertyType);
		protected ObjectPropertiesListUI																opluiSubPropertiesList;
		private static final String																					COLUMN_INEDX										= "columnIndex";
	}

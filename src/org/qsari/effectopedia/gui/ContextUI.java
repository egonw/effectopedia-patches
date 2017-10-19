package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;

import org.qsari.effectopedia.core.object.elemets.Coordinates;
import org.qsari.effectopedia.core.objects.ContextDimension;
import org.qsari.effectopedia.core.objects.ContextDimension_Hierarchical;
import org.qsari.effectopedia.data.objects.FixedValuesList;
import org.qsari.effectopedia.data.objects.ValuesList;
import org.qsari.effectopedia.gui.comp.GlobalUpdateTracker;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;

/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
/**
 * The Class ContextUI.
 * 
 * @version 1.0 @(#)ContextUI.java 1.0
 * @author Hristo Aladjov
 */
public class ContextUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, SizeOptimizableUI
	{
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		/** The scrollpane containing the <code>ContextUI</code> table . */
		private JScrollPane							jspContextDimensions;
		
		/** The context table is list of axis and their values and units. */
		private JTable												jtContextDimensions;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame. Used
		 * for test purposes only.
		 * 
		 * @param args
		 *         the main program arguments
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new ContextUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		/**
		 * Instantiates a new <code>ContextUI</code>.
		 */
		public ContextUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("context");
				initGUI();
			}
		
		/**
		 * Inits the gui.
		 */
		private void initGUI()
			{
				try
					{
						setPreferredSize(optimalSize);
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBorder(BorderFactory.createTitledBorder(null, "Context", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12)));
						this.setBackground(Color.WHITE);
							{
								jspContextDimensions = new JScrollPane();
								this.add(jspContextDimensions, BorderLayout.CENTER);
									{
										TableModel jtAxisModel = new DefaultTableModel(new String[][]
											{
												{ "Life stage", "adult", "" },
												{ "Species", "human", "" } }, new String[]
											{ "Dimesnion Name", "Value", "Units" });
										jtContextDimensions = new JTable();
										// this.add(jtAxis, BorderLayout.CENTER);
										
										jspContextDimensions.setViewportView(jtContextDimensions);
										jspContextDimensions.getViewport().setBackground(Color.WHITE);
										jspContextDimensions.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
										jtContextDimensions.setModel(jtAxisModel);
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		/**
		 * Adjust <code>visible</code> properties to the current and the contained
		 * components.
		 * 
		 * @param visualOptions
		 *         an long that specifies which of the contained components are
		 *         visible
		 * 
		 * @see AdjustableUI
		 */
		public void adjustUI(long visualOptions)
		
			{
				this.setVisible((visualOptions & CONTEXT) != 0);
			}
		
		class ContextTableModel extends AbstractTableModel
			{
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				public ContextTableModel(boolean readonly)
					{
						super();
						fixedListComboBox = new JComboBox<String>();
						fixedListComboBox.setEditable(true);
						defaultFixedListModel = new DefaultComboBoxModel<String>(new String[]
							{ "" });
						fixedListComboBox.setModel(defaultFixedListModel);
						
						// new AutoCompletion(fixedListComboBox,true);
						
						tableCellEditor = new DefaultCellEditor(fixedListComboBox);
						// tableCellEditor = new ComboBoxCellEditor(fixedListComboBox);
						this.readonly = readonly;
					}
				
				public void updateFixedListValues(int row, int column)
					{
						ValuesList valuesList = coordiantes.getDimension(row).getDefaultValues();
						if ((column == 1) && (valuesList != null) && (valuesList instanceof FixedValuesList))
							fixedListComboBox.setModel(new DefaultComboBoxModel<String>(((FixedValuesList) valuesList).getListArray()));
						else if ((column == 0) && (coordiantes.getDimension(row) instanceof ContextDimension_Hierarchical))
							fixedListComboBox.setModel(new DefaultComboBoxModel<String>(((ContextDimension_Hierarchical) coordiantes.getDimension(row)).getHierarchy().getListArray()));
						else
							fixedListComboBox.setModel(defaultFixedListModel);
					}
				
				protected TableCellEditor getCellEditor(int row, int column)
					{
						if ((column == 1) && (coordiantes.getDimension(row).getDefaultValues() != null))
							return tableCellEditor;
						if ((column == 0) && (coordiantes.getDimension(row) instanceof ContextDimension_Hierarchical))
							return tableCellEditor;
						return jtContextDimensions.getDefaultEditor(jtContextDimensions.getColumnClass(column));
					}
				
				public int getColumnCount()
					{
						return 3;
					}
				
				public int getRowCount()
					{
						if (coordiantes != null)
							return coordiantes.count();
						else
							return 0;
					}
				
				public Object getValueAt(int row, int column)
					{
						if (coordiantes != null)
							{
								if (column == 0)
									{
										ContextDimension dimension = coordiantes.getDimension(row);
										if (dimension instanceof ContextDimension_Hierarchical)
											{
												ContextDimension_Hierarchical hd = (ContextDimension_Hierarchical) dimension;
												int category = coordiantes.getCategory(row);
												if (category < 0)
													return coordiantes.getName(row);
												else
													return hd.getHierarchy().get(category);
											}
										return coordiantes.getName(row);
									}
								else if (column == 1)
									return coordiantes.getDisplayValue(row);
								else
									return coordiantes.getUnit(row);
							}
						else
							return null;
					}
				
				public Class<?> getColumnClass(int col)
					{
						return String.class;
					}
				
				public void setValueAt(Object value, int row, int col)
					{
						if (coordiantes != null)
							{
								if (col == 0)
									{
										ContextDimension dimension = coordiantes.getDimension(row);
										if (dimension instanceof ContextDimension_Hierarchical)
											coordiantes.setCategory(row, ((ContextDimension_Hierarchical) dimension).getHierarchy().indexOf(value.toString()));
									}
								else if (col == 1)
									coordiantes.setValue(row, value.toString());
								else
									coordiantes.setUnit(row, (String) value);
								GlobalUpdateTracker.GUT.fireObjectUpdated(new EventObject(coordiantes));
							}
					}
				
				public boolean isCellEditable(int row, int column)
					{
						if (coordiantes != null)
							updateFixedListValues(row, column);
						return !readonly && ((column > 0) || ((coordiantes != null) && (coordiantes.getDimension(row) instanceof ContextDimension_Hierarchical)));
					}
				
				public String getColumnName(int c)
					{
						return columnNames[c];
					}
				
				private JComboBox<String>												fixedListComboBox;
				private TableCellEditor														tableCellEditor;
				private DefaultComboBoxModel<String>	defaultFixedListModel;
				public String[]																						columnNames	= new String[]
																																																						{ "Name", "Value", "Units" };
				public final boolean																	readonly;
			}
		
		public void loadTable(boolean readonly)
			{
				if (coordiantes == null)
					return;
				ContextTableModel tableModel = new ContextTableModel(readonly);
				jtContextDimensions.setModel(tableModel);
				jtContextDimensions.getColumnModel().getColumn(0).setCellEditor(tableModel.tableCellEditor);
				jtContextDimensions.getColumnModel().getColumn(1).setCellEditor(tableModel.tableCellEditor);
			}
		
		public void load(Object o, boolean readonly)
			{
				if ((o == null) || (!(o instanceof Coordinates)))
					return;
				coordiantes = (Coordinates) o;
				loadTable(readonly);
				updateOptimalSize();
			}
		
		public void updateOptimalSize()
			{
				Insets insets = getBorder().getBorderInsets(this);
				optimalSize.width = jtContextDimensions.getPreferredScrollableViewportSize().width + insets.left + insets.right;
				optimalSize.height = jtContextDimensions.getRowCount() * (jtContextDimensions.getRowHeight() + 1) + jtContextDimensions.getTableHeader().getPreferredSize().height + insets.top + insets.bottom + 4;
				
				setSize(optimalSize);
				setPreferredSize(optimalSize);
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
		
		public void initializeUI()
			{
				JScrollBar scrollbar = jspContextDimensions.getVerticalScrollBar();
				if (scrollbar != null)
					scrollbar.setValue(0);
			}
		
		private Dimension					optimalSize	= new Dimension(400, 100);
		
		protected Coordinates	coordiantes;
		
	}

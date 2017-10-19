package org.qsari.effectopedia.gui.ref_ids_table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.defaults.DefaultOntologies;
import org.qsari.effectopedia.gui.SizeOptimizableUI;
import org.qsari.effectopedia.gui.comp.autocomplete.AutoCompletion;
import org.qsari.effectopedia.gui.comp.autocomplete.ComboBoxCellEditor;
import org.qsari.effectopedia.gui.core.ClipboardTransferableUI;
import org.qsari.effectopedia.gui.core.ManageableIndexedListUI;
import org.qsari.effectopedia.ontologies.OntologyInstance;
import org.qsari.effectopedia.ontologies.OntologyInstances;

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
public class OntologyInstancesTableUI extends javax.swing.JPanel implements ManageableIndexedListUI<OntologyInstance>, SizeOptimizableUI, ClipboardTransferableUI
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= -7012797187618393534L;
		private JScrollPane							jspTableScrollPane;
		private JTable												jtInstances;
		private JComboBox<Object>	jcbCellEditor;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new OntologyInstancesTableUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public OntologyInstancesTableUI()
			{
				super();
				initGUI();
				setTableModel(new OntologyInstancesTableModel(null));
			}
		
		public OntologyInstancesTableUI(OntologyInstancesTableModel tableModel)
			{
				super();
				initGUI();
				setTableModel(tableModel);
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						setPreferredSize(optimalSize);
							{
								jspTableScrollPane = new JScrollPane();
								this.add(jspTableScrollPane, BorderLayout.CENTER);
								jspTableScrollPane.setBackground(Color.WHITE);
								jspTableScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
									{
										TableModel jtReferenceIDsModel = new DefaultTableModel(new String[][]
											{
												{ "" },
												{ "" } }, new String[]
											{ "" });
										jtInstances = new JTable();
										jspTableScrollPane.setViewportView(jtInstances);
										jspTableScrollPane.getViewport().setBackground(Color.WHITE);
										jtInstances.setModel(jtReferenceIDsModel);
										jtInstances.setTableHeader(null);
										jtInstances.setGridColor(new java.awt.Color(244, 244, 244));
										
										ListSelectionModel lsm = jtInstances.getSelectionModel();
										lsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
										jtInstances.addMouseListener(new TableMouseHandler());
										
										jcbCellEditor = new JComboBox<Object>(new Object[]
											{ "" });
										jcbCellEditor.setEditable(true);
										autoCompletion = new AutoCompletion(jcbCellEditor, true);
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		private class TableMouseHandler extends MouseAdapter
			{
				public void mouseClicked(MouseEvent e)
					{
						if (e.getClickCount() == 2)
							{
								Object o = tableModel.getObjectAt(jtInstances.getSelectedRow(), jtInstances.getSelectedColumn());
								if ((o instanceof PathwayElement) || (o instanceof Pathway))
									UserInterface.getDefaultNavigator().navigate(UILocations.getProperEditor(o), o);
								
							}
					}
			}
		
		@Override
		public OntologyInstance add(boolean enableSelectionDialog)
			{
				OntologyInstances ontologyInstances;
				if (tableModel != null)
					{
						ontologyInstances = tableModel.getOntologyInstances();
						OntologyInstance ontologyInstance;
						if (ontologyInstances != null)
							{
								ontologyInstance = DefaultOntologies.defaultInstance.get(ontologyInstances.getType());
								ontologyInstances.add(ontologyInstance);
								updateOptimalSize();
								jtInstances.revalidate();
								return ontologyInstance;
							}
						else
							return null;
					}
				return null;
			}
		
		public void add(OntologyInstance instance)
			{
				tableModel.addRow(instance);
				updateOptimalSize();
				jtInstances.revalidate();
			}
		
		public void remove()
			{
				if (jtInstances.getRowSelectionAllowed())
					{
						int[] rowIndices = jtInstances.getSelectedRows();
						for (int i = rowIndices.length - 1; i >= 0; i--)
							tableModel.removeRow(rowIndices[i]);
					}
				else if (jtInstances.getCellSelectionEnabled())
					{
						int rowIndex = jtInstances.getSelectedRow();
						tableModel.removeRow(rowIndex);
					}
				updateOptimalSize();
			}
		
		public void remove(int rowIndex)
			{
				tableModel.removeRow(rowIndex);
				updateOptimalSize();
			}
		
		public void reset()
			{
				tableModel.reset();
				updateOptimalSize();
				jtInstances.revalidate();
			}
		
		public int getActiveListIndex()
			{
				return jtInstances.getSelectedRow();
			}
		
		public OntologyInstancesTableModel getTableModel()
			{
				return tableModel;
			}
		
		public void setTableModel(OntologyInstancesTableModel tableModel)
			{
				this.tableModel = tableModel;
				if (tableModel != null)
					{
						jtInstances.setModel(tableModel);
						jtInstances.getColumnModel().getColumn(0).setCellEditor(new ComboBoxCellEditor(jcbCellEditor));
					}
			}
		
		public OntologyInstances getOntologyInstances()
			{
				if (tableModel != null)
					return tableModel.getOntologyInstances();
				else
					return null;
			}
		
		@SuppressWarnings("unchecked")
		public void setOntologyInstances(OntologyInstances ontologyInstances, boolean readonly)
			{
				if (tableModel != null)
					{
						tableModel.setOntologyInstances(ontologyInstances);
						jcbCellEditor.setModel(new OntologyInstanceComboBoxModel(ontologyInstances.getType(), readonly));
						autoCompletion.setModel(jcbCellEditor.getModel());
					}
			}
		
		public void updateOptimalSize()
			{
				optimalSize.width = jspTableScrollPane.getWidth();
				optimalSize.height = (jtInstances.getRowCount()) * (jtInstances.getRowHeight() + 1);
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
				JScrollBar scrollbar = jspTableScrollPane.getVerticalScrollBar();
				if (scrollbar != null)
					scrollbar.setValue(0);
			}
		
		public void copy()
			{
				// TODO Auto-generated method stub
			}
		
		public void paste()
			{
				// TODO Auto-generated method stub
			}
		
		@Override
		public Object getList()
			{
				return (tableModel != null) ? tableModel.getOntologyInstances() : null;
			}
		
		private Dimension																					optimalSize	= new Dimension(400, 100);
		protected OntologyInstance												selected				= null;
		protected OntologyInstancesTableModel	tableModel		= null;
		protected AutoCompletion														autoCompletion;
	}

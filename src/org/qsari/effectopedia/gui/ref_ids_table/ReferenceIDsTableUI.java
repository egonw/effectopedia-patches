package org.qsari.effectopedia.gui.ref_ids_table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.ids.ReferenceID;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.core.ui.nav.UILocation;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.gui.SizeOptimizableUI;
import org.qsari.effectopedia.gui.core.ClipboardTransferableUI;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.core.ManageableIndexedListUI;

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
public class ReferenceIDsTableUI<E extends EffectopediaObject> extends javax.swing.JPanel implements ManageableIndexedListUI<E>, SizeOptimizableUI, ClipboardTransferableUI
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= -7012797187618393534L;
		protected JScrollPane					jspTableScrollPane;
		protected JTable										jtReferenceIDs;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new ReferenceIDsTableUI<ReferenceID<?>>());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public ReferenceIDsTableUI()
			{
				super();
				initGUI(true);
			}
		
		public ReferenceIDsTableUI(ReferenceIDsTableModel<E> tableModel, boolean showHeader)
			{
				super();
				initGUI(showHeader);
				setTableModel(tableModel);
			}
		
		public void addMouseMotionListener(MouseMotionListener listener)
			{
				super.addMouseMotionListener(listener);
				jtReferenceIDs.addMouseMotionListener(listener);
			}
		
		private void initGUI(boolean showHeader)
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
										jtReferenceIDs = new JTable();
										jspTableScrollPane.setViewportView(jtReferenceIDs);
										jspTableScrollPane.getViewport().setBackground(Color.WHITE);
										jspTableScrollPane.setWheelScrollingEnabled(false);
										jtReferenceIDs.setModel(jtReferenceIDsModel);
										if (!showHeader)
											jtReferenceIDs.setTableHeader(null);
										jtReferenceIDs.setGridColor(new java.awt.Color(244, 244, 244));
										jtReferenceIDs.setRowHeight(24);
										ListSelectionModel lsm = jtReferenceIDs.getSelectionModel();
										lsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
										jtReferenceIDs.addMouseListener(new TableMouseHandler());
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
								Object o;
								if (tableModel instanceof PathwayElementRIDTM)
									o = ((PathwayElementRIDTM<?>) tableModel).getPathwayElementAt(jtReferenceIDs.getSelectedRow(), jtReferenceIDs.getSelectedColumn());
								else
									o = tableModel.getObjectAt(jtReferenceIDs.getSelectedRow(), jtReferenceIDs.getSelectedColumn());
								if ((o instanceof PathwayElement) || (o instanceof Pathway))
									{
										UILocation location = UILocations.getProperEditor(o);
										location.setReadOnly(readonly);
										UserInterface.getDefaultNavigator().navigate(location, o);
									}
							}
					}
			}
		
		@Override
		public E add(boolean enableSelectionDialog)
			{
				return null;
			}
		
		public void add(E element)
			{
				tableModel.addRow(element);
				updateOptimalSize();
			}
		
		public void remove()
			{
				if (jtReferenceIDs.getRowSelectionAllowed())
					{
						int[] rowIndices = jtReferenceIDs.getSelectedRows();
						for (int i = rowIndices.length - 1; i >= 0; i--)
							removeRow(rowIndices[i]);
					}
				else if (jtReferenceIDs.getCellSelectionEnabled())
					{
						int rowIndex = jtReferenceIDs.getSelectedRow();
						removeRow(rowIndex);
					}
				updateOptimalSize();
			}
		
		protected void removeRow(int index)
			{
				tableModel.removeRow(index);
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
				jtReferenceIDs.revalidate();
			}
		
		public void refresh()
			{
				updateOptimalSize();
				jtReferenceIDs.revalidate();
				Container parent = getParent();
				while ((parent != null) && (parent.getParent() instanceof LoadableEditorUI))
					parent = parent.getParent();
				if (parent != null)
					parent.revalidate();
			}
		
		public int getActiveListIndex()
			{
				return jtReferenceIDs.getSelectedRow();
			}
		
		public ReferenceIDsTableModel<E> getTableModel()
			{
				return tableModel;
			}
		
		public void setTableModel(ReferenceIDsTableModel<E> tableModel)
			{
				this.tableModel = tableModel;
				if (tableModel != null)
					jtReferenceIDs.setModel(tableModel);
			}
		
		public ReferenceIDs<E> getReferenceIDs()
			{
				if (tableModel != null)
					return tableModel.getReferenceIDs();
				else
					return null;
			}
		
		public void setReferenceIDs(ReferenceIDs<E> referenceIDs, boolean readonly)
			{
				if (tableModel != null)
					{
						tableModel.setReferenceIDs(referenceIDs, readonly);
						tableModel.setEdiable(allowInplaceEditing);
						this.readonly = readonly;
					}
			}
		
		public void updateOptimalSize()
			{
				optimalSize.width = jspTableScrollPane.getWidth();
				optimalSize.height = (jtReferenceIDs.getRowCount()) * (jtReferenceIDs.getRowHeight() + 1);
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
				return (tableModel != null) ? tableModel.getReferenceIDs() : null;
			}
		
		public final boolean isAllowInplaceEditing()
			{
				return allowInplaceEditing;
			}
		
		public final void setAllowInplaceEditing(boolean allowInplaceEditing)
			{
				this.allowInplaceEditing = allowInplaceEditing;
				tableModel.setEdiable(allowInplaceEditing);
			}
		
		private Dimension																			optimalSize									= new Dimension(400, 100);
		protected EffectopediaObject								selected												= null;
		protected ReferenceIDsTableModel<E>	tableModel										= null;
		protected boolean																			readonly												= false;
		protected boolean																			allowInplaceEditing	= true;
		
	}

package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.EventListener;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.EventListenerList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.history.EditHistory;
import org.qsari.effectopedia.history.EditHistoryAction;
import org.qsari.effectopedia.history.EditHistoryItem_Object;
import org.qsari.effectopedia.history.EditHistoryItem_Property;
import org.qsari.effectopedia.history.Stamp;
import org.qsari.effectopedia.history.Stamps;
import org.qsari.effectopedia.system.ActionTypes;
import org.qsari.effectopedia.system.Users;

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
public class RevisionHistoryTableUI extends ContextSensitivePanel implements ListSelectionListener, LoadableEditorUI
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 871214515584565997L;
		private JScrollPane							jspTable;
		private JTable												jtHistory;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new RevisionHistoryTableUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public RevisionHistoryTableUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("history_table");
				if (Effectopedia.EFFECTOPEDIA.getData() != null)
					{
						this.data = Effectopedia.EFFECTOPEDIA.getData();
						this.editHistory = data.getEditHistory();
						this.stamps = Effectopedia.EFFECTOPEDIA.getStamps();
					}
				eventListeners = new EventListenerList();
				initGUI();
			}
		
		public class HistoryTableModel extends DefaultTableModel
			{
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 5071184128725873963L;
				
				public HistoryTableModel()
					{
						super();
					}
				
				@Override
				public int getColumnCount()
					{
						return 9;
					}
				
				@Override
				public String getColumnName(int columnIndex)
					{
						return CAPTIONS[columnIndex];
					}
				
				@Override
				public int getRowCount()
					{
						if (editHistory != null)
							return editHistory.getUserActionsCount();
						else
							return 0;
					}
				
				@Override
				public Object getValueAt(int row, int column)
					{
						EditHistoryAction eha = editHistory.getUserAction(editHistory.getUserActionsCount() - row - 1);
						
						if (eha != null)
							{
								if (column == 0)
									return eha.getID();
								if ((column < 6) && (column > 1))
									return getStampValueAt(column, eha);
								else
									return getSimpleActionValueAt(column, eha);
							}
						return null;
					}
				
				public Class<?> getColumnClass(int columnIndex)
					{
						if (columnIndex == 0)
							return Long.class;
						else if (columnIndex == 1)
							return ImageIcon.class;
						else
							return String.class;
					}
				
				private Object getStampValueAt(int column, EditHistoryAction eha)
					{
						Stamp stamp = stamps.get((int) eha.getStampId());
						if (column == 2)
							return stamp.getFormattedDate();
						else if (column == 3)
							return stamp.getLocation();
						else if (column == 4)
							return Users.REGISTERED.get((int) stamp.getUserId());
						else if (column == 5)
							return ActionTypes.REGISTERED.get((int) stamp.getActionId()).getDescription();
						return null;
					}
				
				private Object getSimpleActionValueAt(int column, EditHistoryAction eha)
					{
						if (column == 1)
							return UIResources.getIconForClass(eha.getObjectClass());
						else if (column == 6)
							return data.getLiveIndices().get(eha.getObjectClass()).get(eha.getObjectId());
						else if (column == 7)
							{
								if (eha.getObject() instanceof EditHistoryItem_Object)
									{
										long archiveID = ((EditHistoryItem_Object) eha.getObject()).getObjectArchiveId();
										if (archiveID == eha.getObjectId())
											if (data.getLiveIndices().get(eha.getObjectClass()).get(archiveID).isDefaultID())
												return "Default Effectopedia object was created";
											else
												return "Clone of the default object was created";
										else
											return "";
									}
								else if (eha.getObject() instanceof EditHistoryItem_Property)
									return ((EditHistoryItem_Property) eha.getObject()).getProperty();
							}
						else if (column == 8)
							return eha.getObjectClass().getSimpleName();
						return null;
					}
				
				public boolean isCellEditable(int row, int column)
					{
						return false;
					}
				
				public String[]	CAPTIONS	=
																														{ "No", "Icon", "Date & Time", "Location", "User", "Action", "Object", "Details", "Type" };
			}
		
		@Override
		public void valueChanged(ListSelectionEvent selection)
			{
				int row = jtHistory.getSelectedRow();
				if (row==-1)
					return;
				row = jtHistory.getRowSorter().convertRowIndexToModel(row);
				EditHistoryAction eha = editHistory.getUserAction(editHistory.getUserActionsCount() - row - 1);
				EffectopediaObject eo = data.getLiveIndices().get(eha.getObjectClass()).get(eha.getObjectId());
				EffectopediaObject aeo = data.getArchiveIndices().get(eha.getObjectClass()).get(eha.getObjectId());
				fireRevisionHistorySelection(new RevisionHistorySelection(this, eo, aeo));
			}
		
		public class RevisionHistorySelection extends EventObject
			{
				/**
		 * 
		 */
				private static final long	serialVersionUID	= 1L;
				
				public RevisionHistorySelection(Object source, EffectopediaObject object, EffectopediaObject archive)
					{
						super(source);
						this.object = object;
						this.archive = archive;
					}
				
				public final EffectopediaObject	object;
				public final EffectopediaObject	archive;
			}
		
		public interface RevisionHistorySelectionListener extends EventListener
			{
				public void selectionChanged(RevisionHistorySelection evt);
			}
		
		public void addRevisionHistorySelectionListener(RevisionHistorySelectionListener listener)
			{
				eventListeners.add(RevisionHistorySelectionListener.class, listener);
			}
		
		public void removeRevisionHistorySelectionListener(RevisionHistorySelectionListener listener)
			{
				eventListeners.remove(RevisionHistorySelectionListener.class, listener);
			}
		
		protected void fireRevisionHistorySelection(RevisionHistorySelection evt)
			{
				RevisionHistorySelectionListener[] listeners = eventListeners.getListeners(RevisionHistorySelectionListener.class);
				for (int i = 0; i < listeners.length; i++)
					listeners[i].selectionChanged(evt);
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						setPreferredSize(new Dimension(400, 300));
							{
								jspTable = new JScrollPane();
								this.add(jspTable, BorderLayout.CENTER);
								jspTable.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
								jspTable.setPreferredSize(new java.awt.Dimension(400, 300));
									{
										TableModel jtHistoryModel = new HistoryTableModel();
										sorter = new TableRowSorter<TableModel>(jtHistoryModel);
										jtHistory = new JTable();
										jtHistory.getSelectionModel().addListSelectionListener(this);
										jspTable.setViewportView(jtHistory);
										jtHistory.setModel(jtHistoryModel);
										jtHistory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
										jtHistory.getColumnModel().getColumn(0).setMaxWidth(36);
										jtHistory.getColumnModel().getColumn(1).setMaxWidth(24);
										jtHistory.getColumnModel().getColumn(2).setMaxWidth(120);
										jtHistory.getColumnModel().getColumn(2).setMinWidth(120);
										jtHistory.getColumnModel().getColumn(3).setMaxWidth(80);
										jtHistory.getColumnModel().getColumn(3).setMinWidth(80);
										jtHistory.getColumnModel().getColumn(4).setMaxWidth(120);
										jtHistory.getColumnModel().getColumn(4).setMinWidth(120);
										jtHistory.setRowHeight(24);
										jtHistory.setRowSorter(sorter);
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public TableRowSorter<TableModel> getSorter()
			{
				return sorter;
			}
		
		protected EventListenerList										eventListeners;
		protected TableRowSorter<TableModel>	sorter;
		private EditHistory																		editHistory;
		private Stamps																							stamps;
		private DataSource																			data;
		
		@Override
		public void load(Object o, boolean readonly)
			{
				if (Effectopedia.EFFECTOPEDIA.getData() != null)
					{
						this.data = Effectopedia.EFFECTOPEDIA.getData();
						this.editHistory = data.getEditHistory();
						this.stamps = Effectopedia.EFFECTOPEDIA.getStamps();
					}
			}
	}

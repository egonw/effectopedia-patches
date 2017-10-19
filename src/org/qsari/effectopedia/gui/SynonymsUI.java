package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.gui.comp.TabManager;
import org.qsari.effectopedia.gui.comp.TabManager.TabChangeListener;
import org.qsari.effectopedia.gui.core.ClipboardTransferableUI;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.core.ManageableIndexedListUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI;
import org.qsari.effectopedia.gui.util.ClipboardUtilities;

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
public class SynonymsUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, ManageableIndexedListUI<String>, ClipboardTransferableUI, SizeOptimizableUI, TabChangeListener
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		private JScrollPane							jspSynonyms;
		private JTable												jtSynonyms;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new SynonymsUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public SynonymsUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("synonyms");
				synonyms = new ArrayList<String>();
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBorder(BorderFactory.createTitledBorder(null, "Synonyms", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12)));
						this.setPreferredSize(new java.awt.Dimension(240, 125));
						this.setBackground(Color.WHITE);
							{
								jspSynonyms = new JScrollPane();
								this.add(jspSynonyms, BorderLayout.CENTER);
								jspSynonyms.setPreferredSize(new java.awt.Dimension(60, 40));
								jspSynonyms.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
									{
										jlSynonymsModel = new StringTableModel(new String[]
											{ "Carbolic Acid", "Benzenol", "Phenylic Acid", "Hydroxybenzene", "Phenic acid" });
										jtSynonyms = new JTable();
										jspSynonyms.setViewportView(jtSynonyms);
										jspSynonyms.getViewport().setBackground(Color.WHITE);
										jtSynonyms.setModel(jlSynonymsModel);
										jtSynonyms.setFont(new java.awt.Font("Dialog", 0, 12));
									}
							}
							{
								letbuiToolbar = new ListEditorToolbarUI(this, "synonym", ListEditorToolbarUI.ALL, FlowLayout.RIGHT);
								FlowLayout letbuiToolbarLayout = new FlowLayout();
								letbuiToolbar.setLayout(letbuiToolbarLayout);
								this.add(letbuiToolbar, BorderLayout.SOUTH);
								letbuiToolbar.setPreferredSize(new java.awt.Dimension(230, 26));
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public class StringTableModel extends AbstractTableModel
			{
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				public StringTableModel(String[] list)
					{
						synonyms.clear();
						synonyms.addAll(Arrays.asList(list));
					}
				
				public int getColumnCount()
					{
						return 1;
					}
				
				public int getRowCount()
					{
						return synonyms.size();
					}
				
				public Object getValueAt(int row, int column)
					{
						return synonyms.get(row);
					}
				
				public Class<?> getColumnClass(int col)
					{
						return String.class;
					}
				
				public void setValueAt(Object value, int row, int col)
					{
						modified = true;
						synonyms.set(row, (String) value);
						fireTableCellUpdated(row, col);
					}
				
				public boolean isCellEditable(int row, int column)
					{
						return (!readonly)&&(synonyms != null);
					}
				
				public String getColumnName(int c)
					{
						return columnNames[c];
					}
				
				public void addValue(Object obj)
					{
						if (readonly)
							return;
						modified = true;
						synonyms.add((String) obj);
						int index = synonyms.size() - 1;
						fireTableRowsInserted(index, index);
					}
				
				public void addAll(String[] list)
					{
						if (readonly)
							return;
						modified = true;
						synonyms.addAll(Arrays.asList(list));
						fireTableRowsInserted(0, synonyms.size() - 1);
					}
				
				public void removeRow(int row)
					{
						if (readonly)
							return;
						modified = true;
						synonyms.remove(row);
						fireTableRowsDeleted(row, row);
					}
				
				public void removeAllValues()
					{
						if (readonly)
							return;
						int index = synonyms.size() - 1;
						modified = true;
						synonyms.clear();
						fireTableRowsDeleted(0, index);
					}
				
				public String[]	columnNames	= new String[]
																																	{ "Synonyms" };
			}
		
		public String add(boolean enableSelectionDialog)
			{
				String empty = "";
				if (readonly)
					return empty;
				jlSynonymsModel.addValue(empty);
				updateOptimalSize();
				return empty;
			}
		
		public int getActiveListIndex()
			{
				return jtSynonyms.getSelectedRow();
			}
		
		public void remove()
			{
				int index = getActiveListIndex();
				if (index != -1)
					{
						jlSynonymsModel.removeRow(index);
						updateOptimalSize();
					}
			}
		
		public void reset()
			{
				jlSynonymsModel.removeAllValues();
				updateOptimalSize();
			}
		
		public void loadList()
			{
				if (chemical != null)
					{
						synonyms.clear();
						jlSynonymsModel.addAll(chemical.getSynonymsList());
					}
			}
		
		public void storeList()
			{
				if (chemical != null)
					chemical.setSynonymsList(synonyms.toArray(new String[synonyms.size()]));
			}
		
		@Override
		public void copy()
			{
				ClipboardUtilities.setClipboard(Initiator_ChemicalStructure.setSynonymsList(synonyms.toArray(new String[synonyms.size()]), "\n"));
			}
		
		@Override
		public void paste()
			{
				synonyms.clear();
				jlSynonymsModel.addAll((Initiator_ChemicalStructure.getSynonymsList(ClipboardUtilities.getClipboard())));
			}
		
		@Override
		public Object getList()
			{
				return synonyms;
			}
		
		@Override
		public void updateOptimalSize()
			{
				
			}
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof Initiator_ChemicalStructure))
					return;
				chemical = (Initiator_ChemicalStructure) o;
				this.readonly = readonly;
				letbuiToolbar.updateEditButtons(readonly);
				loadList();
				TabManager.MANAGER.addTabChangeListener(this);
			}
		
		@Override
		public void tabChanged(EventObject evt)
			{
				if (modified)
					storeList();
				TabManager.MANAGER.removeTabChangeListener(this);
			}
		
		/**
		 * Adjust <code>visible</code> properties to the current and the contained
		 * components
		 * 
		 * @see AdjustableUI
		 * 
		 * @param visualOptions
		 *         an long that specifies which of the contained components are
		 *         visible
		 */
		public void adjustUI(long visualOptions)
		
			{
				setVisible((visualOptions & CHEMSYNONYMS) != 0);
			}
		
		private boolean													modified	= false;
		private Initiator_ChemicalStructure		chemical;
		private StringTableModel				jlSynonymsModel;
		private ListEditorToolbarUI	letbuiToolbar;
		private ArrayList<String>			synonyms;
		private boolean													readonly	= false;
	}

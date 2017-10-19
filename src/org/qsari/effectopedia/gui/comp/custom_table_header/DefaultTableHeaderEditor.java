package org.qsari.effectopedia.gui.comp.custom_table_header;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;

public class DefaultTableHeaderEditor extends ContextSensitivePanel implements TableCellRenderer, LoadableEditorUI, KeyListener, RootHelpContext
	{
		/**
		* 
		*/
		private static final long	serialVersionUID	= 1L;
		
		protected JLabel										jlTitle;
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
			{
				jlTitle.setText(value.toString());
				jlTitle.setHorizontalAlignment(SwingConstants.CENTER);
				jlTitle.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
				return jlTitle;
			}
			
		public DefaultTableHeaderEditor()
			{
				super(null);
				this.model = null;
				initGUI();
			}
			
		public DefaultTableHeaderEditor(AbstractTableModel model)
			{
				super(null);
				this.model = model;
				initGUI();
			}
			
		private void initGUI()
			{
				try
					{
							{
								jlTitle = new JLabel();
								jlTitle.setText(" ");
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
			
		@Override
		public void load(Object o, boolean readonly)
			{
				object = o;
			}
			
		public Object getObject()
			{
				return object;
			}
			
		public void setObject(Object object)
			{
				this.object = object;
			}
			
		@Override
		public void keyPressed(KeyEvent keyEvent)
			{
			}
			
		@Override
		public void keyReleased(KeyEvent keyEvent)
			{
				int key = keyEvent.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					{
						if (model != null)
							model.fireTableDataChanged();
						fireEditorActionPerformed(acOK);
					}
				else if (key == KeyEvent.VK_ESCAPE)
					fireEditorActionPerformed(acCancel);
			}
			
		@Override
		public void keyTyped(KeyEvent keyEvent)
			{
			}
			
		public interface EditorActionListener
			{
				public void listEditorActionPerformed(int actionCode);
			}
			
		public void addEditorActionListener(EditorActionListener listener)
			{
				editorActionListeners.add(listener);
			}
			
		public void removeEditorActionListener(EditorActionListener listener)
			{
				editorActionListeners.remove(listener);
			}
			
		protected void fireEditorActionPerformed(int actionCode)
			{
				for (EditorActionListener listener : editorActionListeners)
					listener.listEditorActionPerformed(actionCode);
			}
			
		protected ArrayList<EditorActionListener> editorActionListeners = new ArrayList<EditorActionListener>();
		
		public interface OptionsListener
			{
				public void showOptions();
			}
			
		public void fireShowOptions()
			{
				if (optionsListener != null)
					optionsListener.showOptions();
			}
			
		public OptionsListener getOptionsListener()
			{
				return optionsListener;
			}
			
		public void setOptionsListener(OptionsListener optionsListener)
			{
				this.optionsListener = optionsListener;
			}
			
		protected OptionsListener				optionsListener;
		
		protected AbstractTableModel	model;
		protected Object													object;
		public static final int						acCancel	= -1;
		public static final int						acOK					= 0;
	}

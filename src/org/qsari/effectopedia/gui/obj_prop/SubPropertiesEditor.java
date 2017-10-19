package org.qsari.effectopedia.gui.obj_prop;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.EventListener;
import java.util.EventObject;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.EventListenerList;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.UIResources;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;

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
public class SubPropertiesEditor extends ContextSensitivePanel implements TableCellEditor, TableCellRenderer
	{
		/**
 * 
 */
		private static final long						serialVersionUID	= 1L;
		
		public static final String					CREATE											= "create";
		public static final String					DELETE											= "delete";
		public static final String					HIDE													= "hidden";
		public static final String					SHOW													= "visible";
		
		public final SubPropertyAction	createAction					= new SubPropertyAction(CREATE, "create", "create subproperty", UIResources.imageIconAdd);
		public final SubPropertyAction	deleteAction					= new SubPropertyAction(DELETE, "delete", "delete subproperty", UIResources.imageIconDelete);
		public final SubPropertyAction	hideAction							= new SubPropertyAction(HIDE, "hide", "hide subproperty", UIResources.imageIconHide);
		public final SubPropertyAction	showAction							= new SubPropertyAction(SHOW, "show", "show subproperty", UIResources.imageIconShow);
		
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new SubPropertiesEditor(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public SubPropertiesEditor(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				initGUI();
			}
		
		public void initGUI()
			{
				try
					{
							{
								this.setPreferredSize(new java.awt.Dimension(324, 21));
								this.setBackground(Color.white);
								GridLayout thisLayout = new GridLayout(1, 1);
								thisLayout.setColumns(1);
								thisLayout.setHgap(5);
								thisLayout.setVgap(5);
								this.setLayout(thisLayout);
								this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
									{
										jbCreateDestoryActions = newButton(createAction);
										this.add(jbCreateDestoryActions);
										jbCreateDestoryActions.setText(CREATE);
									}
									{
										jtbVisible = newToggleButton(showAction);
										this.add(jtbVisible);
										jtbVisible.setText(HIDE);
										jtbVisible.setSelected(true);
										jtbVisible.setEnabled(false);
									}
							}
						
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		private JButton newButton(AbstractAction action)
			{
				JButton button;
				button = new JButton(action);
				button.setFocusPainted(false);
				button.setHideActionText(DefaultGOSettings.hideActionText);
				return button;
			}
		
		private JToggleButton newToggleButton(AbstractAction action)
			{
				JToggleButton button;
				button = new JToggleButton(action);
				button.setFocusPainted(false);
				button.setHideActionText(DefaultGOSettings.hideActionText);
				return button;
			}
		
		public class SubPropertyAction extends AbstractAction
			{
				/**
	 * 
	 */
				private static final long	serialVersionUID	= 1L;
				
				public SubPropertyAction(String actionCommand, String actionName, String actionDescription, ImageIcon icon)
					{
						putValue(Action.ACTION_COMMAND_KEY, actionCommand);
						putValue(Action.NAME, actionName);
						putValue(Action.SMALL_ICON, icon);
						putValue(Action.SHORT_DESCRIPTION, actionDescription);
						getActionMap().put(actionName, this);
					}
				
				public void actionPerformed(ActionEvent event)
					{
						if (event.getActionCommand() == CREATE)
							{
								setCreateDestroyButton(deleteAction, DELETE);
								setVisibleButton(showAction, SHOW, true);
								state = SUB_PROP_VISIBLE;
							}
						else if (event.getActionCommand() == DELETE)
							{
								setCreateDestroyButton(createAction, CREATE);
								setVisibleButton(hideAction, HIDE, false);
								state = SUB_PROP_NULL;
							}
						else if (event.getActionCommand() == SHOW)
							{
								setVisibleButton(showAction, SHOW, true);
								state = SUB_PROP_HIDDEN;
							}
						else if (event.getActionCommand() == HIDE)
							{
								setVisibleButton(hideAction, HIDE, true);
								state = SUB_PROP_VISIBLE;
							}
						fireEditingStopped();
						fireCellEditorActionPerformed(new EventObject(SubPropertiesEditor.this));
					}
			}
		
		protected void setCreateDestroyButton(Action action, String actionName)
			{
				jbCreateDestoryActions.setAction(action);
				jbCreateDestoryActions.setText(actionName);
			}
		
		protected void setVisibleButton(Action action, String actionName, boolean enabled)
			{
				jtbVisible.setAction(action);
				jtbVisible.setText(actionName);
				jtbVisible.setSelected(true);
				jtbVisible.setEnabled(enabled);
			}
		
		@Override
		public Object getCellEditorValue()
			{
				return state;
			}
		
		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
			{
				if (value instanceof Integer)
					loadState((Integer) value);
				editorColumn = column;
				return this;
			}
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
			{
				if (table.getModel().getRowCount() - 1 == row)
					{
						if (value instanceof Integer)
							loadState((Integer) value);
						return this;
					}
				else
					{
						TableCellRenderer renderer = table.getDefaultRenderer(value == null ? String.class : value.getClass());
						return renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
					}
			}
		
		protected void loadState(Integer state)
			{
				this.state = state;
				if (state == SUB_PROP_NULL)
					{
						setCreateDestroyButton(createAction, CREATE);
						setVisibleButton(hideAction, HIDE, false);
					}
				else if (state == SUB_PROP_VISIBLE)
					{
						setCreateDestroyButton(deleteAction, DELETE);
						setVisibleButton(showAction, SHOW, true);
					}
				else if (state == SUB_PROP_HIDDEN)
					{
						setCreateDestroyButton(deleteAction, DELETE);
						setVisibleButton(hideAction, HIDE, true);
					}
			}
		
		/**
		 * Returns true.
		 * 
		 * @param e
		 *         an event object
		 * @return true
		 */
		public boolean isCellEditable(EventObject e)
			{
				return true;
			}
		
		/**
		 * Returns true.
		 * 
		 * @param anEvent
		 *         an event object
		 * @return true
		 */
		public boolean shouldSelectCell(EventObject anEvent)
			{
				return true;
			}
		
		/**
		 * Calls <code>fireEditingStopped</code> and returns true.
		 * 
		 * @return true
		 */
		public boolean stopCellEditing()
			{
				fireEditingStopped();
				return true;
			}
		
		/**
		 * Calls <code>fireEditingCanceled</code>.
		 */
		public void cancelCellEditing()
			{
				fireEditingCanceled();
			}
		
		/**
		 * Adds a <code>CellEditorListener</code> to the listener list.
		 * 
		 * @param l
		 *         the new listener to be added
		 */
		public void addCellEditorListener(CellEditorListener l)
			{
				listenerList.add(CellEditorListener.class, l);
			}
		
		/**
		 * Removes a <code>CellEditorListener</code> from the listener list.
		 * 
		 * @param l
		 *         the listener to be removed
		 */
		public void removeCellEditorListener(CellEditorListener l)
			{
				listenerList.remove(CellEditorListener.class, l);
			}
		
		/**
		 * Returns an array of all the <code>CellEditorListener</code>s added to this
		 * AbstractCellEditor with addCellEditorListener().
		 * 
		 * @return all of the <code>CellEditorListener</code>s added or an empty array
		 *         if no listeners have been added
		 * @since 1.4
		 */
		public CellEditorListener[] getCellEditorListeners()
			{
				return listenerList.getListeners(CellEditorListener.class);
			}
		
		/**
		 * Notifies all listeners that have registered interest for notification on
		 * this event type. The event instance is created lazily.
		 * 
		 * @see EventListenerList
		 */
		protected void fireEditingStopped()
			{
				// Guaranteed to return a non-null array
				Object[] listeners = listenerList.getListenerList();
				if (changeEvent == null)
					changeEvent = new ChangeEvent(this);
				for (int i = listeners.length - 2; i >= 0; i -= 2)
					if (listeners[i] == CellEditorListener.class)
						((CellEditorListener) listeners[i + 1]).editingStopped(changeEvent);
			}
		
		/**
		 * Notifies all listeners that have registered interest for notification on
		 * this event type. The event instance is created lazily.
		 * 
		 * @see EventListenerList
		 */
		protected void fireEditingCanceled()
			{
				Object[] listeners = listenerList.getListenerList();
				if (changeEvent == null)
					changeEvent = new ChangeEvent(this);
				for (int i = listeners.length - 2; i >= 0; i -= 2)
					if (listeners[i] == CellEditorListener.class)
						((CellEditorListener) listeners[i + 1]).editingCanceled(changeEvent);
			}
		
		public interface CellEditorActionListener extends EventListener
			{
				public void cellEditorActionPerformed(EventObject evt);
			}
		
		/**
		 * Adds a <code>CellEditorActionListener</code> to the listener list.
		 * 
		 * @param l
		 *         the new listener to be added
		 */
		public void addCellEditorActionListener(CellEditorActionListener l)
			{
				listenerList.add(CellEditorActionListener.class, l);
			}
		
		/**
		 * Removes a <code>CellEditorActionListener</code> from the listener list.
		 * 
		 * @param l
		 *         the listener to be removed
		 */
		public void removeCellEditorActionListener(CellEditorActionListener l)
			{
				listenerList.remove(CellEditorActionListener.class, l);
			}
		
		/**
		 * Notifies all listeners that have registered interest for notification on
		 * this event type.
		 * 
		 * @see EventListenerList
		 */
		protected void fireCellEditorActionPerformed(EventObject evt)
			{
				CellEditorActionListener[] listeners = listenerList.getListeners(CellEditorActionListener.class);
				for (int i = listeners.length - 1; i >= 0; i--)
					listeners[i].cellEditorActionPerformed(evt);
			}
		
		public int getEditorColumn()
			{
				return editorColumn;
			}
		
		public Integer getState()
			{
				return state;
			}
		
		public void setState(Integer state)
			{
				this.state = state;
				loadState(state);
			}
		
		public static final int									SUB_PROP_NULL				= 0;
		public static final int									SUB_PROP_HIDDEN		= 1;
		public static final int									SUB_PROP_VISIBLE	= 2;
		
		transient protected ChangeEvent	changeEvent						= null;
		protected EventListenerList					listenerList					= new EventListenerList();
		
		private JButton																	jbCreateDestoryActions;
		private JToggleButton											jtbVisible;
		protected Integer															state;
		protected int																			editorColumn					= -1;
	}

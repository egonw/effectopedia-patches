package org.qsari.effectopedia.gui.inspector;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.gui.comp.AbstractTreeTableModel;
import org.qsari.effectopedia.gui.comp.TreeTableModel;

public class XMLDataTreeTableModelAdapter extends AbstractTreeTableModel
	{
		public XMLDataTreeTableModelAdapter()
			{
				super(null);
			}
		
		public XMLDataTreeTableModelAdapter(BaseIOElement root, BaseIO io)
			{
				super(null);
				this.root = root;
				this.io = io;
			}
		
		//
		// The TreeModel interface
		//
		public Object getRoot()
			{
				if (root == null)
					return null;
				return new XMLElementAdapterNode(this.root, io);
			}
		
		/**
		 * Returns the number of children of <code>node</code>.
		 */
		public int getChildCount(Object node)
			{
				XMLElementAdapterNode element = (XMLElementAdapterNode) node;
				return element.childCount();
			}
		
		/**
		 * Returns the child of <code>node</code> at index <code>index</code>.
		 */
		public Object getChild(Object node, int index)
			{
				XMLElementAdapterNode element = (XMLElementAdapterNode) node;
				return element.child(index);
			}
		
		/**
		 * Returns true if the passed in object represents a leaf, false otherwise.
		 */
		public boolean isLeaf(Object node)
			{
				XMLElementAdapterNode jdomNode = (XMLElementAdapterNode) node;
				return (jdomNode.element.getValue().length() > 0);
			}
		
		/**
		 * Returns the index of the <code>child</code> from the <code>parent</code>.
		 */
		public int getIndexOfChild(Object parent, Object child)
			{
				XMLElementAdapterNode node = (XMLElementAdapterNode) parent;
				return node.index((XMLElementAdapterNode) child);
			}
		
		public void valueForPathChanged(TreePath path, Object newValue)
			{
				// Null. We won't be making changes in the GUI
				// If we did, we would ensure the new value was really new,
				// adjust the model, and then fire a TreeNodesChanged event.
			}
		
		/*
		 * Use these methods to add and remove event listeners. (Needed to satisfy
		 * TreeModel interface, but not used.)
		 */
		
		public void addTreeModelListener(TreeModelListener listener)
			{
				if (listener != null && !listenerList.contains(listener))
					{
						listenerList.add(listener);
					}
			}
		
		public void removeTreeModelListener(TreeModelListener listener)
			{
				if (listener != null)
					{
						listenerList.remove(listener);
					}
			}
		
		public void fireTreeNodesChanged(TreeModelEvent e)
			{
				Iterator<TreeModelListener> listeners = listenerList.iterator();
				while (listeners.hasNext())
					{
						TreeModelListener listener = (TreeModelListener) listeners.next();
						listener.treeNodesChanged(e);
					}
			}
		
		public void fireTreeNodesInserted(TreeModelEvent e)
			{
				Iterator<TreeModelListener> listeners = listenerList.iterator();
				while (listeners.hasNext())
					{
						TreeModelListener listener = (TreeModelListener) listeners.next();
						listener.treeNodesInserted(e);
					}
			}
		
		public void fireTreeNodesRemoved(TreeModelEvent e)
			{
				Iterator<TreeModelListener> listeners = listenerList.iterator();
				while (listeners.hasNext())
					{
						TreeModelListener listener = (TreeModelListener) listeners.next();
						listener.treeNodesRemoved(e);
					}
			}
		
		public void fireTreeStructureChanged(TreeModelEvent e)
			{
				Iterator<TreeModelListener> listeners = listenerList.iterator();
				while (listeners.hasNext())
					{
						TreeModelListener listener = (TreeModelListener) listeners.next();
						listener.treeStructureChanged(e);
					}
			}
		
		//
		// The TreeTableNode interface.
		//
		
		/**
		 * Returns the number of columns.
		 */
		public int getColumnCount()
			{
				return columnNames.length;
			}
		
		/**
		 * Returns the name for a particular column.
		 */
		public String getColumnName(int column)
			{
				return columnNames[column];
			}
		
		/**
		 * Returns the class for the particular column.
		 */
		public Class<?> getColumnClass(int column)
			{
				return columnTypes[column];
			}
		
		/**
		 * Returns the value of the particular column.
		 */
		public Object getValueAt(Object node, int column)
			{
				XMLElementAdapterNode n = (XMLElementAdapterNode) node;
				if (column == 0)
					return n.element.getName();
				else
					return n.element.getValue().trim();
			}
		
		// Names of the columns.
		static protected String[]												columnNames		=
																																																					{ "property", "value" };
		
		// Types of the columns.
		static protected Class<?>[]										columnTypes		=
																																																					{ TreeTableModel.class, String.class };
		protected BaseIOElement														root;
		protected BaseIO																					io;
		private ArrayList<TreeModelListener>	listenerList	= new ArrayList<TreeModelListener>();
	}

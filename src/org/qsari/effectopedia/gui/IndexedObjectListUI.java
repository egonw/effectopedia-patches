package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.core.ManageableIndexedListUI;
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
public abstract class IndexedObjectListUI<P extends javax.swing.JPanel & LoadableEditorUI> extends ContextSensitivePanel implements AdjustableUI, ManageableIndexedListUI<P>, InitializableUI
	{
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public IndexedObjectListUI(RootHelpContext rootHelpContext)
			{
				this(javax.swing.BoxLayout.Y_AXIS,rootHelpContext);
			}
		
		public IndexedObjectListUI(int boxLayout,RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("io_list");
				list = new ArrayList<P>();
				activeObject = new ActiveObject();
				initGUI(boxLayout);
			}
		
		public class ActiveObject implements FocusListener
			{
				public void focusGained(FocusEvent e)
					{
						// System.out.println("Focus gained" + e);
					}
				
				public void focusLost(FocusEvent e)
					{
						// System.out.println("Focus lost" + e);
					}
			}
		
		private void initGUI(int boxLayout)
			{
				try
					{
						BoxLayout thisLayout = new BoxLayout(this, boxLayout);
						this.setLayout(thisLayout);
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public abstract P add(boolean enableSelectionDialog);
		
		public void add(P panel)
			{
				list.add(panel);
				activeListIndex = list.size() - 1;
				super.add(panel);
				panel.addFocusListener(activeObject);
				if (indexedList != null)
					panel.load(indexedList.getNew(), false);
				updateOptimalSize();
				this.revalidate();
			}
		
		public P get(int index)
			{
				if ((index>=0)&&(index<list.size()))
					return list.get(index);
				else
					return null;
			}
		
		public void add(P panel, Object o)
			{
				list.add(panel);
				activeListIndex = list.size() - 1;
				super.add(panel);
				panel.addFocusListener(activeObject);
				if (indexedList != null)
					{
						indexedList.add(o);
						panel.load(o, false);
					}
				updateOptimalSize();
				this.revalidate();
			}
		
		public void remove()
			{
				if ((activeListIndex >= 0) && (activeListIndex < list.size()))
					{
						P panel = list.get(activeListIndex);
						panel.removeFocusListener(activeObject);
						list.remove(activeListIndex);
						this.remove(activeListIndex);
						if (indexedList != null)
							indexedList.remove(activeListIndex);
						activeListIndex--;
						updateOptimalSize();
						revalidate();
					}
			}
		
		public int itemsCount()
			{
				return list.size();
			}
		
		public void reset()
			{
				list.clear();
				this.removeAll();
				activeListIndex = -1;
				if (indexedList != null)
					indexedList.clear();
				updateOptimalSize();
				revalidate();
			}
		
		public int getActiveListIndex()
			{
				return this.activeListIndex;
			}
		
		public ReferenceIDs<?> getIndexedList()
			{
				return indexedList;
			}
		
		/**
		 * Set <code>this.indexedList</code> to a new list and updates the user
		 * interface to reflect the content of the new list. All panels P implement
		 * <code>LoadableEditorUI</code> and are loaded form the elements of the new
		 * indexedList
		 * 
		 * @see LoadableEditorUI
		 * 
		 * @param indexedList
		 *         an <code>IndexedList<?></code> that specifies the list of indexed
		 *         objects to be edited in the IndexedObjectListUI
		 */
		public void setIndexedList(ReferenceIDs<?> indexedList, boolean readonly)
			{
				this.indexedList = null;
				list.clear();
				this.removeAll();
				for (int index = 0; index < indexedList.size(); index++)
					add(false).load(indexedList.getCachedObject(index), readonly);
				this.indexedList = indexedList;
				updateOptimalSize();
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
				AdjustbleUserInterfaceTools.adjustChildren(this, visualOptions);
			}
		
		public void updateOptimalSize()
			{
				optimalSize.width = this.getWidth();
				optimalSize.height = 18;
				if ((list != null) && (list.size() > 0))
					for (JPanel panel : list)
						optimalSize.height += panel.getPreferredSize().height;
				this.setPreferredSize(optimalSize);
				setSize(optimalSize);
				setPreferredSize(optimalSize);
				this.setBackground(Color.white);
				this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
				// JScrollBar scrollbar = this.getVerticalScrollBar();
				// if (scrollbar != null)
				// scrollbar.setValue(scrollbar.getMaximum());
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
				if ((list != null) && (list.size() > 0))
					for (P panel : list)
						if (panel instanceof InitializableUI)
							((InitializableUI) panel).initializeUI();
			}
		
		private Dimension									optimalSize	= new Dimension(400, 64);
		protected ReferenceIDs<?>	indexedList;
		private int															activeListIndex;
		private ActiveObject						activeObject;
		protected ArrayList<P>				list;
	}

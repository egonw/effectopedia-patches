package org.qsari.effectopedia.gui.obj_prop;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.data.objects.ObjectPropertyType;
import org.qsari.effectopedia.gui.AdjustableUI;
import org.qsari.effectopedia.gui.AdjustbleUserInterfaceTools;
import org.qsari.effectopedia.gui.InitializableUI;
import org.qsari.effectopedia.gui.SizeOptimizableUI;
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
public abstract class ObjectPropertiesUI<P extends javax.swing.JPanel & LoadableEditorUI> extends ContextSensitivePanel implements AdjustableUI, ManageableIndexedListUI<P>, InitializableUI
	{
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public ObjectPropertiesUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				list = new ArrayList<P>();
				activeObject = new ActiveObject();
				initGUI();
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
		
		private void initGUI()
			{
				try
					{
						BoxLayout thisLayout = new BoxLayout(this, javax.swing.BoxLayout.Y_AXIS);
						this.setLayout(thisLayout);
						this.setBackground(Color.white);
						this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
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
				panel.setAlignmentX(0.5F);
				panel.setMaximumSize(null);
				if (objectProperties != null)
					{
						ObjectProperty op = new ObjectProperty(objectProperties.getOwner(), new ObjectPropertyType());
						panel.load(op, false);
					}
				updateOptimalSize();
				this.revalidate();
			}
		
		public void add(P panel, ObjectProperty o)
			{
				list.add(panel);
				activeListIndex = list.size() - 1;
				super.add(panel);
				panel.addFocusListener(activeObject);
				panel.setAlignmentX(0.5F);
				panel.setMaximumSize(null);
				if (objectProperties != null)
					{
						objectProperties.add(o);
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
						if (objectProperties != null)
							objectProperties.remove(activeListIndex);
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
				if (objectProperties != null)
					objectProperties.clear();
				updateOptimalSize();
				revalidate();
			}
		
		public int getActiveListIndex()
			{
				return this.activeListIndex;
			}
		
		public ObjectProperties getObjectProperties()
			{
				return objectProperties;
			}
		
		/**
		 * Set <code>this.objectProperties</code> to a new list and updates the user
		 * interface to reflect the content of the new list. All panels P implement
		 * <code>LoadableEditorUI</code> and are loaded form the elements of the new
		 * indexedList
		 * 
		 * @see LoadableEditorUI
		 * 
		 * @param objectProperies
		 *         an <code>ObjectProperties<?></code> that specifies the list of
		 *         indexed objects to be edited in the ObjectPropertiesUI
		 */
		public void setObjectProperties(ObjectProperties objectProperies, boolean readonly)
			{
				loading = true;
				this.objectProperties = null;
				list.clear();
				this.removeAll();
				for (int index = 0; index < objectProperies.getCount(); index++)
					add(false).load(objectProperies.getProperty(index), readonly);
				this.objectProperties = objectProperies;
				loading = false;
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
		
		@Override
		public Object getList()
			{
				return objectProperties;
			}
		
		public void initializeUI()
			{
				if ((list != null) && (list.size() > 0))
					for (P panel : list)
						if (panel instanceof InitializableUI)
							((InitializableUI) panel).initializeUI();
			}
		
		public boolean isLoading()
			{
				return loading;
			}

		private boolean										loading					= false;
		private Dimension								optimalSize	= new Dimension(400, 120);
		private ObjectProperties	objectProperties;
		private int														activeListIndex;
		private ActiveObject					activeObject;
		protected ArrayList<P>			list;
	}

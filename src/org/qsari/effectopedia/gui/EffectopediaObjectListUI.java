package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.ref_ids_table.EffectopediaObjectRIDTM;
import org.qsari.effectopedia.gui.ref_ids_table.ReferenceIDsTableUI;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI.ListEditorActionListener;

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
public class EffectopediaObjectListUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, ListEditorActionListener
	{
		/**
	 * 
	 */
		private static final long									serialVersionUID	= 1L;
		private ListEditorToolbarUI							letuiEOListToolbar;
		private EffectopediaObjectTableUI	eotuiEffectopediaObjects;
		
		class EffectopediaObjectTableUI extends ReferenceIDsTableUI<EffectopediaObject>
			{
				
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				public EffectopediaObjectTableUI(boolean readonly)
					{
						super(new EffectopediaObjectRIDTM<EffectopediaObject>(null, readonly),false);
						setName("table");
					}
				
				public Effect add()
					{
						return null;
					}
				
				public void updateColumnWidths()
					{
						EffectopediaObjectRIDTM<EffectopediaObject> tableModel = (EffectopediaObjectRIDTM<EffectopediaObject>) getTableModel();
						tableModel.updateColumnWidths(jtReferenceIDs);
					}
			}
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new LinkedEffectsListUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public EffectopediaObjectListUI(String listCaption, String elementCaption,RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("eo_list");
				if (listCaption != null)
					this.listCaption = listCaption;
				if (elementCaption != null)
					this.elementCaption = elementCaption;
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBorder(BorderFactory.createTitledBorder(null, listCaption, TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Tahoma", 2, 11)));
						this.setBackground(Color.white);
						setPreferredSize(new Dimension(200, 120));
							{
								eotuiEffectopediaObjects = new EffectopediaObjectTableUI(false);
								this.add(eotuiEffectopediaObjects, BorderLayout.CENTER);
							}
							
							{
								letuiEOListToolbar = new ListEditorToolbarUI(eotuiEffectopediaObjects, elementCaption, ListEditorToolbarUI.DEFAULT, FlowLayout.RIGHT);
								this.add(letuiEOListToolbar, BorderLayout.SOUTH);
							}
						RootHelpContext.addMouseMotionListeners(this, rootHelpContext,false);	
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
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
				this.setVisible((visualOptions & RELATEDLNK) != 0);
				letuiEOListToolbar.adjustUI(visualOptions);
			}
		
		@SuppressWarnings("unchecked")
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof ReferenceIDs))
					return;
				this.reference = (ReferenceIDs<EffectopediaObject>) o;
				eotuiEffectopediaObjects.setReferenceIDs(reference, readonly);
				eotuiEffectopediaObjects.setAllowInplaceEditing(false);
				eotuiEffectopediaObjects.updateColumnWidths();
				letuiEOListToolbar.updateEditButtons(readonly);
				letuiEOListToolbar.addListEditorActionListener(this);
			}
		
		@Override
		public int listEditorActionPerformed(int actionCode)
			{
				if (actionCode == ListEditorToolbarUI.ADD)
					{
						if (availbleIndices != null)
							ExistingEffectopediaObjectDialog.DIALOG.setAvailableIndices(availbleIndices);
						ExistingEffectopediaObjectDialog.DIALOG.load(null, false);
						EffectopediaObject selectedEO = ExistingEffectopediaObjectDialog.DIALOG.getSelectedEffectopediaObject();
						eotuiEffectopediaObjects.add(selectedEO);
						return 0;
					}
				else
					return actionCode;
			}
		
		public EffectopediaObjects<?>[] getAvailbleIndices()
			{
				return availbleIndices;
			}
		
		public void setAvailbleIndices(EffectopediaObjects<?>[] availbleIndices)
			{
				this.availbleIndices = availbleIndices;
			}
		
		protected EffectopediaObjects<?>[]									availbleIndices	= null;
		protected ReferenceIDs<EffectopediaObject>	reference							= null;
		protected String																											listCaption					= "Associated Effectopedia Objects";
		protected String																											elementCaption		= "effectopedia object";
	}

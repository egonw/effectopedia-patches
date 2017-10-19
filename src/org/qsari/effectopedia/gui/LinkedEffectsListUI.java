package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.ref_ids_table.PathwayElementRIDTM;
import org.qsari.effectopedia.gui.ref_ids_table.PathwayElementRIDTM.Level;
import org.qsari.effectopedia.gui.ref_ids_table.ReferenceIDsTableUI;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI;

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
public class LinkedEffectsListUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI
	{
		/**
	 * 
	 */
		private static final long				serialVersionUID	= 1L;
		private ListEditorToolbarUI		letuiCauseToolbar;
		private LinkedEffectsTableUI	letuiLinkedEffects;
		
		class LinkedEffectsTableUI extends ReferenceIDsTableUI<PathwayElement>
			{
				
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				public LinkedEffectsTableUI(String[] coulmnNames, String[] fieldNames, boolean readonly)
					{
						super(new PathwayElementRIDTM<PathwayElement>(null, upstream ? Level.UPSTREAM_ASSOCIATION : Level.DOWNSTREAM_ASSOCIATION, readonly),false);
					}
				
				public Effect add()
					{
						return null;
					}
				
				public void updateColumnWidths()
					{
						PathwayElementRIDTM<PathwayElement> tableModel = (PathwayElementRIDTM<PathwayElement>) getTableModel();
						tableModel.updateColumnWidths(jtReferenceIDs);
					}
			}
		
		private boolean	upstream;
		
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
		
		public LinkedEffectsListUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("upstream_list");
				this.upstream = true;
				initGUI();
			}
		
		public LinkedEffectsListUI(boolean upstream,RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName(upstream?"upstream_list":"downstream_list");
				this.upstream = upstream;
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						setPreferredSize(new Dimension(200, 120));
						this.setBackground(Color.white);
							{
								String[] captions = upstream ? new String[]
									{ "Cause", "Link" } : new String[]
									{ "Link", "Effect" };
								letuiLinkedEffects = new LinkedEffectsTableUI(captions, captions, false);
								this.add(letuiLinkedEffects, BorderLayout.CENTER);
							}
							
							{
								letuiCauseToolbar = new ListEditorToolbarUI(letuiLinkedEffects, upstream ? "upstream cause" : "downstream effect", ListEditorToolbarUI.INTERACT, FlowLayout.RIGHT);
								this.add(letuiCauseToolbar, BorderLayout.SOUTH);
							}
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
				letuiCauseToolbar.adjustUI(visualOptions);
			}
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof ReferenceIDs))
					return;
				@SuppressWarnings("unchecked")
				ReferenceIDs<PathwayElement> reference = (ReferenceIDs<PathwayElement>) o;
				letuiLinkedEffects.setReferenceIDs(reference, readonly);
				letuiLinkedEffects.setAllowInplaceEditing(false);
				letuiLinkedEffects.updateColumnWidths();
				letuiCauseToolbar.updateEditButtons(readonly);
			}

		public boolean isHorizontalPlacement()
			{
				return ((PathwayElementRIDTM<PathwayElement>)letuiLinkedEffects.getTableModel()).isHorizontalPlacement();
			}

		public void setHorizontalPlacement(boolean horizontalPlacement)
			{
				((PathwayElementRIDTM<PathwayElement>)letuiLinkedEffects.getTableModel()).setHorizontalPlacement(horizontalPlacement);
			}
		
	}

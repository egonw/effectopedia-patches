package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.objects.Test;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.ref_ids_table.PathwayElementRIDTM;
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
public class RelatedTestsListUI extends ContextSensitivePanel implements AdjustableUI
	{
		/**
	 * 
	 */
		private static final long			serialVersionUID	= 1L;
		private JPanel														letbuiToolbar;
		private RelatedTestsTableUI	rttuiRelatedTests;
		
		class RelatedTestsTableUI extends ReferenceIDsTableUI<Test>
			{
				
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				public RelatedTestsTableUI(boolean readonly)
					{
						super(new PathwayElementRIDTM<Test>(null, readonly,1),false);
					}
				
				public Test add(boolean enableSelectionDialog)
					{
						Test test = null;
						if (enableSelectionDialog)
							{
								ExistingTestDialog.DIALOG.loadExisting();
								test = ExistingTestDialog.DIALOG.getSelectedTest();
								if ((test != null) && (references != null))
									{
										references.add(test);
										rttuiRelatedTests.refresh();
									}
							}
						return test;
					}
			}
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new RelatedTestsListUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public RelatedTestsListUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("tests_list");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBackground(Color.white);
						setPreferredSize(new Dimension(200, 120));
							{
								rttuiRelatedTests = new RelatedTestsTableUI(false);
								this.add(rttuiRelatedTests, BorderLayout.CENTER);
							}
							{
								letbuiToolbar = new ListEditorToolbarUI(rttuiRelatedTests, "related tests", ListEditorToolbarUI.DEFAULT, FlowLayout.RIGHT);
								this.add(letbuiToolbar, BorderLayout.SOUTH);
								letbuiToolbar.setPreferredSize(new java.awt.Dimension(200, 21));
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
				if ((visualOptions & RELATEDLNK) != 0)
					{
						setVisible(true);
						AdjustbleUserInterfaceTools.adjustChildren(this, visualOptions);
					}
				else
					{
						setVisible(false);
					}
			}
		
		@SuppressWarnings("unchecked")
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof ReferenceIDs))
					return;
				references = (ReferenceIDs<Test>) o;
				rttuiRelatedTests.setReferenceIDs(references, readonly);
				rttuiRelatedTests.setAllowInplaceEditing(false);
			}
		
		protected ReferenceIDs<Test>	references;
		
	}

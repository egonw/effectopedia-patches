package org.qsari.effectopedia.gui;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.objects.Test;
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
public class RelatedTestsUI extends ContextSensitivePanel implements AdjustableUI
	{
		/**
	 * 
	 */
		private static final long							serialVersionUID	= 1L;
		private RelatedTestsListUI						rtluiRelatedTestList;
		private SuggestedRelatedTestsUI	stluiSuggestedTestList;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new RelatedTestsUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public RelatedTestsUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("related_tests");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						setPreferredSize(new Dimension(200, 240));
						BoxLayout thisLayout = new BoxLayout(this, javax.swing.BoxLayout.Y_AXIS);
						this.setLayout(thisLayout);
						this.setBorder(BorderFactory.createTitledBorder(null, "Related Tests", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11)));
							{
								rtluiRelatedTestList = new RelatedTestsListUI(rootHelpContext);
								this.add(rtluiRelatedTestList);
							}
							{
								stluiSuggestedTestList = new SuggestedRelatedTestsUI(rootHelpContext);
								this.add(stluiSuggestedTestList);
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
				AdjustbleUserInterfaceTools.adjustChildren(this, visualOptions);
			}

		@SuppressWarnings("unchecked")
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof ReferenceIDs))
					return;
				relatedTests = (ReferenceIDs<Test>) o;
				readonly = readonly || relatedTests.isReadonly();
				rtluiRelatedTestList.load(relatedTests, readonly);
			}
		
		private ReferenceIDs<Test>	relatedTests;

	}

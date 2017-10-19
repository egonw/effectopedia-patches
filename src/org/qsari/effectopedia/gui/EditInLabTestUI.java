package org.qsari.effectopedia.gui;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.objects.Test;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
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
public class EditInLabTestUI extends EditTestUI implements AdjustableUI, LoadableEditorUI
	{
		/**
	 * 
	 */
		protected static final long	serialVersionUID	= 1L;
		protected InLabTestUI							tuiTest;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new EditInLabTestUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public EditInLabTestUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("in_lab_test");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						tuiTest = new InLabTestUI();
						jspTest.add(tuiTest, JSplitPane.LEFT);
						tuiTest.setPreferredSize(new java.awt.Dimension(400, 300));
						tuiTest.setMinimumSize(new java.awt.Dimension(100, 300));
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof Test))
					return;
				Test test = (Test) o;
				mpeluiRelatedEffects.load(test.getRelatedEffectMappingIDs(),readonly);
				rtuiRelatedTests.load(test.getRelatedTestIDs(),readonly);
				tuiTest.load(test,readonly);
			}
		

	}

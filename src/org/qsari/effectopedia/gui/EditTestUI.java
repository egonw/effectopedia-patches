package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

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
public class EditTestUI extends ContextSensitivePanel implements AdjustableUI
	{
		/**
	 * 
	 */
		protected static final long											serialVersionUID	= 1L;
		protected JSplitPane																		jspTest;
		protected MappedPathwayElementsListUI	mpeluiRelatedEffects;
		protected RelatedTestsUI														rtuiRelatedTests;
		protected InLabTestUI																	tuiTest;
		protected JSplitPane																		jspRelated;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new EditTestUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public EditTestUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("test");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						setPreferredSize(new Dimension(600, 300));
							{
								jspTest = new JSplitPane();
								jspTest.setOneTouchExpandable(true);
								jspTest.setResizeWeight(0.75);
								this.add(jspTest, BorderLayout.CENTER);
									{
										jspRelated = new JSplitPane();
										jspRelated.setOneTouchExpandable(true);
										jspRelated.setResizeWeight(0.5);
										
										jspTest.add(jspRelated, JSplitPane.RIGHT);
										jspRelated.setOrientation(JSplitPane.VERTICAL_SPLIT);
											{
												mpeluiRelatedEffects = new MappedPathwayElementsListUI(true,rootHelpContext);
												jspRelated.add(mpeluiRelatedEffects, JSplitPane.TOP);
												mpeluiRelatedEffects.setPreferredSize(new java.awt.Dimension(200, 150));
												mpeluiRelatedEffects.setMinimumSize(new java.awt.Dimension(50, 50));
											}
											{
												rtuiRelatedTests = new RelatedTestsUI(rootHelpContext);
												jspRelated.add(rtuiRelatedTests, JSplitPane.BOTTOM);
												rtuiRelatedTests.setPreferredSize(new java.awt.Dimension(200, 150));
												rtuiRelatedTests.setMinimumSize(new java.awt.Dimension(50, 50));
											}
									}
									{
										tuiTest = new InLabTestUI();
										jspTest.add(tuiTest, JSplitPane.LEFT);
										tuiTest.setPreferredSize(new java.awt.Dimension(400, 300));
										tuiTest.setMinimumSize(new java.awt.Dimension(100, 300));
									}
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
		
	}

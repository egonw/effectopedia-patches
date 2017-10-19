package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.gui.core.LoadableEditorUI;
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
public class SuggestedRelatedTestsUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		private JList<String>					jlRelatedTests;
		private JPanel												jpLinkSelectedExistingTests;
		private JScrollPane							jspExistingRelatedTsts;
		private JButton											jbLinkSelected;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new SuggestedRelatedTestsUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public SuggestedRelatedTestsUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("related_test");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						setPreferredSize(new Dimension(200, 120));
						this.setBorder(BorderFactory.createTitledBorder(null, "Existing Tests", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11)));
							{
								jspExistingRelatedTsts = new JScrollPane();
								this.add(jspExistingRelatedTsts, BorderLayout.CENTER);
								jspExistingRelatedTsts.setPreferredSize(new java.awt.Dimension(400, 278));
									{
										ListModel<String> jlRelatedTestsModel = new DefaultComboBoxModel<String>(new String[]
											{ "Test One", "Test Two" });
										jlRelatedTests = new JList<String>();
										jspExistingRelatedTsts.setViewportView(jlRelatedTests);
										jlRelatedTests.setModel(jlRelatedTestsModel);
									}
							}
							{
								jpLinkSelectedExistingTests = new JPanel();
								this.add(jpLinkSelectedExistingTests, BorderLayout.SOUTH);
								FlowLayout jpLinkSelectedExistingTestsLayout = new FlowLayout();
								jpLinkSelectedExistingTestsLayout.setAlignment(FlowLayout.RIGHT);
								jpLinkSelectedExistingTestsLayout.setVgap(1);
								jpLinkSelectedExistingTests.setBackground(new java.awt.Color(255, 255, 255));
								jpLinkSelectedExistingTests.setPreferredSize(new java.awt.Dimension(258, 22));
								jpLinkSelectedExistingTests.setLayout(jpLinkSelectedExistingTestsLayout);
									{
										jbLinkSelected = new JButton();
										jpLinkSelectedExistingTests.add(jbLinkSelected);
										jbLinkSelected.setText("Link Selected");
										jbLinkSelected.setPreferredSize(new java.awt.Dimension(120, 18));
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}

		@Override
		public void load(Object o, boolean readonly)
			{
				// TODO Auto-generated method stub
				
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
				this.setVisible((visualOptions & RELATEDSUGG) != 0);
			}

		
	}

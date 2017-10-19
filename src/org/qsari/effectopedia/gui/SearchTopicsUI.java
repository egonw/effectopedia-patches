package org.qsari.effectopedia.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;

public class SearchTopicsUI extends ContextSensitivePanel implements AdjustableUI
	{
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new SearchTopicsUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public SearchTopicsUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("search_topics");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						setPreferredSize(new Dimension(400, 300));
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

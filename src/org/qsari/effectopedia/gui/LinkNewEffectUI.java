package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
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
public class LinkNewEffectUI extends ContextSensitivePanel implements AdjustableUI
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		private JPanel												jpLinkNewUpstreemCause;
		private JTextPane									jtpUpstreamQuestion;
		private JButton											jbLinkNewUpstreamCause;
		
		private boolean											upstream;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new LinkNewEffectUI(true,null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public LinkNewEffectUI(boolean upstream,RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName(upstream ? "link_upstream" : "link_downstream");
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
							{
								jtpUpstreamQuestion = new JTextPane();
								jtpUpstreamQuestion.setEditable(false);
								this.add(jtpUpstreamQuestion, BorderLayout.CENTER);
								jtpUpstreamQuestion.setContentType("text/html");
								if (upstream)
									{
										jtpUpstreamQuestion.setText("<HTML>What other possible <i>upstream</i> causes do you know?</HTML>");
									}
								else
									{
										jtpUpstreamQuestion.setText("<HTML>What other possible <i>downstream</i> effects do you know?</HTML>");
									}
							}
							{
								jpLinkNewUpstreemCause = new JPanel();
								this.add(jpLinkNewUpstreemCause, BorderLayout.SOUTH);
								FlowLayout jpLinkNewUpstreamCauseLayout = new FlowLayout();
								jpLinkNewUpstreamCauseLayout.setAlignment(FlowLayout.RIGHT);
								jpLinkNewUpstreemCause.setBackground(Color.white);
								jpLinkNewUpstreemCause.setLayout(jpLinkNewUpstreamCauseLayout);
									{
										jbLinkNewUpstreamCause = new JButton();
										jpLinkNewUpstreemCause.add(jbLinkNewUpstreamCause);
										String caption = upstream ? "Link new upstream cause" : "Link new downstream effect";
										jbLinkNewUpstreamCause.setText(caption);
										// jbLinkNewUpstreamCause.setFont(new java.awt.Font("Dialog", 0, 12));
										jbLinkNewUpstreamCause.setPreferredSize(new java.awt.Dimension(200, 18));
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
				this.setVisible((visualOptions & RELATEDNEW) != 0);
			}
		
	}

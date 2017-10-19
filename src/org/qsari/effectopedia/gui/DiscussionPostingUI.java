package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.objects.DiscussionPosting;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.history.Stamp;

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
public class DiscussionPostingUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, SizeOptimizableUI
	{
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		private JTextPane									jtpPosting;
		private JPanel												jpControl;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new DiscussionPostingUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public DiscussionPostingUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("discussion_posting");
				initGUI();
				adjustUI(EDIT);
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout jpDiscussionTopicHeaderLayout = new BorderLayout();
						this.setPreferredSize(optimalSize);
						this.setLayout(jpDiscussionTopicHeaderLayout);
						this.setBackground(Color.WHITE);
							{
								jtpPosting = new JTextPane();
								this.add(jtpPosting);
								jtpPosting.setContentType("text/html");
								jtpPosting.setEditable(false);
								jtpPosting.setBackground(Color.WHITE);
								
								jtpPosting.setFont(new java.awt.Font("Dialog", 0, 12));
							}
							{
								jpControl = new JPanel();
								this.add(jpControl, BorderLayout.WEST);
								jpControl.setBackground(Color.WHITE);
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
				setVisible((visualOptions & DISCUSSTOPIC) != 0);
			}
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof DiscussionPosting))
					return;
				posting = (DiscussionPosting) o;
				readonly = readonly || posting.isReadonly();
				StringBuilder builder = new StringBuilder();
				builder.append("<html>\n<head>\n<style type='text/css'>\n<!--\na {color:#6382BF;}\nh1 {font-size: medium;}\n-->\n</style>\n</head>\n\n<body text=\"#666666\">");
				builder.append("<h1>");
				builder.append(posting.getTitle());
				builder.append("</h1>");
				builder.append(posting.getContent());
				contentTextWidth = jtpPosting.getGraphics().getFontMetrics().stringWidth(posting.getContent());
				if (contentTextWidth==0)
					contentTextWidth =1;
				builder.append("<div align='right'>Posted by: <font color='6382BF'><i>");
				builder.append(posting.getAuthor());
				Stamp stamp = posting.getStamp();
				if (stamp != null)
					{
						builder.append("</i></font> on <font color='6382BF'><i>");
						builder.append(stamp.getFormattedDate());
						builder.append("</i></font></div>");
					}
				builder.append("</body>\n</html>\n");
				jtpPosting.setText(builder.toString());
				updateOptimalSize();
			}
		
		public void updateOptimalSize()
			{
				optimalSize.width = this.getParent().getWidth();
				if (optimalSize.width==0)
					optimalSize.width = 600;
				optimalSize.height =  23*contentTextWidth / optimalSize.width + 64;
				//optimalSize.height = jtpPosting.getPreferredSize().height;
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
		
		private int															contentTextWidth		= 1;
		private Dimension									optimalSize	= new Dimension(400, 48);
		private DiscussionPosting	posting;
	}

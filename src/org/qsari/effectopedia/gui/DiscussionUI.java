package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.DiscussionPosting;
import org.qsari.effectopedia.core.objects.DiscussionTopic;
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
public class DiscussionUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI
	{
		/**
	 * 
	 */
		private static final long				serialVersionUID	= 1L;
		private DiscussionTopicUI				dtuiDiscussionTopic;
		private DiscussionPostingsUI	dpuiDiscussionPostings;
		private DiscussionReplyUI				druiReply;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new DiscussionUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public DiscussionUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("discussion");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						setPreferredSize(new Dimension(600, 400));
						BoxLayout thisLayout = new BoxLayout(this, javax.swing.BoxLayout.Y_AXIS);
						this.setLayout(thisLayout);
						this.setBorder(BorderFactory.createTitledBorder("Discussion"));
						this.setBackground(Color.WHITE);
							{
								dtuiDiscussionTopic = new DiscussionTopicUI(rootHelpContext);
								this.add(dtuiDiscussionTopic);
							}
							{
								dpuiDiscussionPostings = new DiscussionPostingsUI(rootHelpContext);
								this.add(dpuiDiscussionPostings);
								dpuiDiscussionPostings.setBackground(Color.WHITE);
							}
							{
								druiReply = new DiscussionReplyUI(rootHelpContext);
								this.add(druiReply);
								druiReply.setBackground(Color.WHITE);
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

		@Override
		public void load(Object o, boolean readonly)
			{
				if ((o!=null)&&(o instanceof DiscussionTopic))
					{
						this.topic = (DiscussionTopic) o;
						readonly = readonly || topic.isReadonly();
						boolean newTopic = topic.isNew();
						ArrayList<DiscussionPosting> postings = DiscussionPosting.getPostings(topic);
						newTopic = newTopic || ((Effectopedia.EFFECTOPEDIA.getCurrentUserID()==topic.getStamp().getUserId())&&((postings==null)||(postings.size()==0)));
						dtuiDiscussionTopic.load(topic,readonly||!newTopic);
						dpuiDiscussionPostings.setTopic(topic);
						dpuiDiscussionPostings.load(postings,readonly);
						druiReply.setTopic(topic);
						druiReply.load(null,readonly||newTopic);
					}
			}
		protected DiscussionTopic topic;
	}

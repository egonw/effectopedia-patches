package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.containers.Discussion;
import org.qsari.effectopedia.core.containers.Discussion.DiscussionChangeListener;
import org.qsari.effectopedia.core.objects.DiscussionPosting;
import org.qsari.effectopedia.core.objects.DiscussionTopic;
import org.qsari.effectopedia.data.DataSource;
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
public class DiscussionPostingsUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, DiscussionChangeListener, SizeOptimizableUI
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
				frame.getContentPane().add(new DiscussionPostingsUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public DiscussionPostingsUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("discussion_postings");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						setPreferredSize(optimalSize);
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBorder(BorderFactory.createTitledBorder(null, "Discussion", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12)));
						this.setBackground(Color.WHITE);
							{
								jspPostings = new JScrollPane();
								this.add(jspPostings, BorderLayout.CENTER);
								jspPostings.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
									{
										jpPosintgs = new JPanel();
										BoxLayout jpPosintgsLayout = new BoxLayout(jpPosintgs, javax.swing.BoxLayout.Y_AXIS);
										jpPosintgs.setLayout(jpPosintgsLayout);
										jpPosintgs.setBackground(Color.WHITE);
										jspPostings.setViewportView(jpPosintgs);
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public DiscussionTopic getTopic()
			{
				return topic;
			}
		
		public void setTopic(DiscussionTopic topic)
			{
				this.topic = topic;
			}
		
		private void update()
			{
				jpPosintgs.removeAll();
				
				if (discussion != null)
					{
						interfaces = new ArrayList<DiscussionPostingUI>();
						for (DiscussionPosting posting : discussion)
							{
								DiscussionPostingUI postingUI = new DiscussionPostingUI(rootHelpContext);
								jpPosintgs.add(postingUI);
								postingUI.load(posting, readonly);
							}
					}
				updateOptimalSize();
				jspPostings.validate();
				jspPostings.repaint();
				this.getParent().validate();
				this.getParent().repaint();
			}
		
		@Override
		public void discussionChanged(EventObject evt)
			{
				if ((evt.getSource() instanceof Discussion) && (topic != null))
					{
						discussion = ((Discussion) evt.getSource()).getPostings(topic);
						update();
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
				setVisible((visualOptions & DISCUSSPOST) != 0);
			}
		
		@SuppressWarnings("unchecked")
		public void load(Object o, boolean readonly)
			{
				DataSource data = Effectopedia.EFFECTOPEDIA.getData();
				if (data != null)
					data.getLiveIndices().getDiscussion().addDiscussionChangeListener(this);
				if ((o instanceof ArrayList<?>))
					discussion = (ArrayList<DiscussionPosting>) o;
				else
					discussion = null;
				this.readonly = readonly;
				update();
			}
		
		public void updateOptimalSize()
			{
				optimalSize.width = jpPosintgs.getParent().getParent().getWidth();
				optimalSize.height = 16;
				for (Component c : jpPosintgs.getComponents())
					optimalSize.height += c.getPreferredSize().height;
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
		
		public ArrayList<DiscussionPostingUI> getInterfaces()
			{
				return interfaces;
			}

		private Dimension																						optimalSize	= new Dimension(400, 48);
		private DiscussionTopic																topic							= null;
		private JPanel																									jpPosintgs;
		private JScrollPane																				jspPostings;
		private boolean																								readonly				= false;
		private ArrayList<DiscussionPosting>			discussion;
		private ArrayList<DiscussionPostingUI>	interfaces;
		
	}

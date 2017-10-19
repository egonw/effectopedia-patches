package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

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
public class DiscussUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, RootHelpContext
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		private JSplitPane								jspDiscuss;
		private JPanel												stuiSearchTopics;
		private RelatedTopicsUI			rtuiRelatedTopics;
		private JSplitPane								jspTopics;
		private DiscussionUI						duiDiscussion;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new DiscussUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public DiscussUI()
			{
				super(null);
				setName("discuss");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						setPreferredSize(new Dimension(400, 300));
							{
								jspDiscuss = new JSplitPane();
								this.add(jspDiscuss, BorderLayout.CENTER);
								jspDiscuss.setResizeWeight(0.25);
									{
										duiDiscussion = new DiscussionUI(rootHelpContext);
										jspDiscuss.add(duiDiscussion, JSplitPane.RIGHT);
										duiDiscussion.setMinimumSize(new java.awt.Dimension(100, 243));
										duiDiscussion.setBackground(Color.WHITE);
									}
									{
										jspTopics = new JSplitPane();
										jspDiscuss.add(jspTopics, JSplitPane.LEFT);
										jspTopics.setOrientation(JSplitPane.VERTICAL_SPLIT);
											{
												rtuiRelatedTopics = new RelatedTopicsUI(rootHelpContext);
												jspTopics.add(rtuiRelatedTopics, JSplitPane.BOTTOM);
												rtuiRelatedTopics.setMinimumSize(new java.awt.Dimension(50, 46));
												rtuiRelatedTopics.setBackground(Color.WHITE);
											}
											{
												stuiSearchTopics = new JPanel();
												jspTopics.add(stuiSearchTopics, JSplitPane.LEFT);
											}
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

		public void load(Object o,boolean readonly)
			{
				if ((o!=null)&&(o instanceof DiscussionTopic))
					{
						this.topic = (DiscussionTopic) o;
						duiDiscussion.load(topic,readonly);
						rtuiRelatedTopics.load(topic,readonly);
					}
			}
		
		protected DiscussionTopic topic;
	}

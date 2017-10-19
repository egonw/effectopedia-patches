package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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
public class DiscussionReplyUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, ActionListener, DocumentListener
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		private JTextPane									jtpReply;
		private JPanel												jpPostReply;
		private JScrollPane							jspReply;
		private JTextField								jtfPostingTitle;
		private JLabel												jlReplyTitle;
		private JPanel												jpTtitle;
		private JButton											jbPostReply;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new DiscussionReplyUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public DiscussionReplyUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("discussion_replay");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						this.setPreferredSize(new java.awt.Dimension(400, 107));
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBorder(BorderFactory.createTitledBorder(null, "Reply", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12)));
						this.setBackground(Color.WHITE);
							{
								jspReply = new JScrollPane();
								this.add(jspReply, BorderLayout.CENTER);
								jspReply.setPreferredSize(new java.awt.Dimension(390, 59));
								jspReply.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
									{
										jtpReply = new JTextPane();
										jspReply.setViewportView(jtpReply);
										jtpReply.setText("Type text here");
										jtpReply.setPreferredSize(new java.awt.Dimension(513, 61));
										jtpReply.getDocument().addDocumentListener(this);
									}
							}
							{
								jpPostReply = new JPanel();
								this.add(jpPostReply, BorderLayout.SOUTH);
								FlowLayout jpPostReplyLayout = new FlowLayout();
								jpPostReplyLayout.setAlignment(FlowLayout.RIGHT);
								jpPostReplyLayout.setVgap(1);
								jpPostReply.setBackground(new java.awt.Color(255, 255, 255));
								jpPostReply.setPreferredSize(new java.awt.Dimension(390, 22));
								jpPostReply.setLayout(jpPostReplyLayout);
									{
										jbPostReply = new JButton();
										jpPostReply.add(jbPostReply);
										jbPostReply.setText("Post");
										jbPostReply.setFont(new java.awt.Font("Dialog", 0, 12));
										jbPostReply.setPreferredSize(new java.awt.Dimension(90, 18));
										jbPostReply.addActionListener(this);
									}
							}
							{
								jpTtitle = new JPanel();
								BorderLayout jpTtitleLayout = new BorderLayout();
								jpTtitle.setLayout(jpTtitleLayout);
								this.add(jpTtitle, BorderLayout.NORTH);
								jpTtitle.setPreferredSize(new java.awt.Dimension(390, 24));
								jpTtitle.setBackground(new java.awt.Color(255, 255, 255));
									{
										jlReplyTitle = new JLabel();
										jpTtitle.add(jlReplyTitle, BorderLayout.WEST);
										jlReplyTitle.setText("Title: ");
									}
									{
										jtfPostingTitle = new JTextField();
										jpTtitle.add(jtfPostingTitle, BorderLayout.CENTER);
										jtfPostingTitle.setText("Re:");
										jtfPostingTitle.getDocument().addDocumentListener(this);
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
		
		@Override
		public void load(Object o,boolean readonly)
			{
				if ((o != null) && (o instanceof DiscussionPosting))
					{
						posting = (DiscussionPosting) o;
						jtfPostingTitle.setText(posting.getTitle());
						jtfPostingTitle.setEditable(!readonly);
						jtpReply.setText(posting.getContent());
						jtpReply.setEditable(!readonly);
						jbPostReply.setEnabled(!readonly);
					}
				else
					{
						posting = null;
						if (topic != null)
							jtfPostingTitle.setText("Re:" + topic.getSubject());
						jtfPostingTitle.setEditable(!readonly);
						jtpReply.setText("");
						jtpReply.setEditable(!readonly);
						jbPostReply.setEnabled(!readonly);
					}
			 jbPostReply.setText("Post");
			}
		
		@Override
		public void actionPerformed(ActionEvent e)
			{
				if (posting == null)
					posting = new DiscussionPosting(topic,topic.getDataSource());
				posting.setTitle(jtfPostingTitle.getText());
				posting.setContent(jtpReply.getText());
				DiscussionPosting.addPosting(posting);
				jbPostReply.setEnabled(false);
			}
		
		@Override
		public void changedUpdate(DocumentEvent e)
			{
				if (posting != null)
					{
					 jbPostReply.setText("Post Edits");
  				jbPostReply.setEnabled(true);
					}	
			}
		
		@Override
		public void insertUpdate(DocumentEvent e)
			{
				if (posting != null)
					{
					 jbPostReply.setText("Post Edits");
  				jbPostReply.setEnabled(true);
					}	
			}
		
		@Override
		public void removeUpdate(DocumentEvent e)
			{
				if (posting != null)
					{
					 jbPostReply.setText("Post Edits");
  				jbPostReply.setEnabled(true);
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
				setVisible((visualOptions & DISCUSSREPLY) != 0);
			}
		
		private DiscussionTopic			topic			= null;
		private DiscussionPosting	posting	= null;
		
	}

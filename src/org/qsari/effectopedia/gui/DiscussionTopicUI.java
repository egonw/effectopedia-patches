package org.qsari.effectopedia.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.base.Describable;
import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.objects.DiscussionTopic;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.gui.comp.EventsManager;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.nav.RedirectorTextPane;
import org.qsari.effectopedia.history.Stamp;
import org.qsari.effectopedia.system.TraceableClasses;

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
public class DiscussionTopicUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI
	{
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		private JLabel												jlDiscussionID;
		private JTextField								jtfTopicID;
		private JTextArea									jtaTopic;
		private JLabel												jlTopicSubject;
		private JTextField								jtfTopicSubject;
		private JTextPane									jtpTopicHeader;
		private GridBagLayout					jpDiscussionTopicHeaderLayout;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new DiscussionTopicUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public DiscussionTopicUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				listeners = new EventsManager();
				setName("discussion_topic");
				initGUI();
				adjustUI(EDIT);
			}
		
		private void initGUI()
			{
				try
					{
						setPreferredSize(new Dimension(400, 120));
						jpDiscussionTopicHeaderLayout = new GridBagLayout();
						this.setPreferredSize(new java.awt.Dimension(523, 160));
						jpDiscussionTopicHeaderLayout.rowWeights = new double[]
							{ 0.0, 0.0, 0.1 };
						jpDiscussionTopicHeaderLayout.rowHeights = new int[]
							{ 21, 40, 0 };
						jpDiscussionTopicHeaderLayout.columnWeights = new double[]
							{ 0.0, 0.1, 0.0, 0.0 };
						jpDiscussionTopicHeaderLayout.columnWidths = new int[]
							{ 50, 335, 50, 50 };
						this.setLayout(jpDiscussionTopicHeaderLayout);
						//this.setBackground(Color.WHITE);
						this.setBorder(BorderFactory.createTitledBorder(null, "Topic", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Tahoma", 2, 11)));
						this.setBackground(new java.awt.Color(244,243,242));
							{
								jlDiscussionID = new JLabel();
								this.add(jlDiscussionID, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(2, 0, 0, 2), 0, 0));
								jlDiscussionID.setText("Topic ID");
								jlDiscussionID.setFont(new java.awt.Font("Dialog", 0, 12));
							}
							{
								jtfTopicID = new JTextField();
								this.add(jtfTopicID, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jtfTopicID.setText("auto");
								jtfTopicID.setEditable(false);
								jtfTopicID.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
							}
							{
								jspTopicContent = new JScrollPane();
								this.add(jspTopicContent, new GridBagConstraints(0, 2, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
								jspTopicContent.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
								{
									jtaTopic = new JTextArea();
									jspTopicContent.setViewportView(jtaTopic);
									jtaTopic.setText("Sample topic text");
									jtaTopic.setFont(new java.awt.Font("Dialog", 0, 12));
								}
							}
							{
								jlTopicSubject = new JLabel();
								this.add(jlTopicSubject, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(2, 0, 0, 2), 0, 0));
								jlTopicSubject.setText("Subject:");
								jlTopicSubject.setFont(new java.awt.Font("Dialog", 1, 12));
							}
							{
								jtfTopicSubject = new JTextField();
								this.add(jtfTopicSubject, new GridBagConstraints(1, 0, 1, 1, 0.1, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jtfTopicSubject.setText("Simple Topic Subject");
								jtfTopicSubject.setFont(new java.awt.Font("Dialog", 1, 12));
							}
							{
								jtpTopicHeader = new JTextPane();
								jtpTopicHeader.setContentType("text/html");
								jtpTopicHeader.setEditable(false);
								//jtpTopicHeader.setBackground(Color.WHITE);
								redirector = new RedirectorTextPane(jtpTopicHeader);
								redirector.addTarget("viewUIL", UILocations.viewUIL);
								redirector.addTarget("editUIL", UILocations.editUIL);
								redirector.addTarget("searchUIL", UILocations.searchUIL);
								redirector.addTarget("historyUIL", UILocations.historyUIL);
								redirector.addTarget("discussUIL", UILocations.discussUIL);
								redirector.addTarget("welcomeUIL", UILocations.welcomeUIL);
								
								redirector.addTarget("editChemicalUIL", UILocations.editChemicalUIL);
								redirector.addTarget("editLinkUIL", UILocations.editLinkUIL);
								redirector.addTarget("editChemLinkUIL", UILocations.editChemLinkUIL);
								redirector.addTarget("editADMELinkUIL", UILocations.editADMELinkUIL);
								redirector.addTarget("editSystemUIL", UILocations.editSystemUIL);
								redirector.addTarget("editTestUIL", UILocations.editInLabTestUIL);
								redirector.addTarget("editEffectUIL", UILocations.editEffectUIL);
								redirector.addTarget("editPathwayUIL", UILocations.editPathwayUIL);
								
								jtpTopicHeader.addHyperlinkListener(redirector);
								jtpTopicHeader.setText("");
								
								this.add(jtpTopicHeader, new GridBagConstraints(0, 1, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
								jtpTopicHeader.setPreferredSize(new java.awt.Dimension(333, 17));
								jtpTopicHeader.setMargin(new java.awt.Insets(3, 3, 3, 3));
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
				if ((visualOptions & DISCUSSTOPIC) != 0)
					{
						setVisible(true);
						boolean labels = (visualOptions & LABELS) == LABELS;
						jlDiscussionID.setVisible(labels);
						jlTopicSubject.setVisible(labels);
						jtfTopicID.setVisible((visualOptions & AUTOIDS) == AUTOIDS);
						
/*						int gridx = (jlTopicSubject.isVisible()) ? 1 : 0;
						int gridwidth = 6 - gridx;
						
						gridx = (jlTopicSubject.isVisible()) ? 1 : 0;
						gridwidth = 4 - gridx + 2 * ((jtfTopicID.isVisible()) ? 0 : 1);
*/						
					}
				else
					{
						setVisible(false);
					}
			}
		
		@Override
		public void load(Object o, boolean readonly)
			{
				if ((o == null) || !(o instanceof DiscussionTopic))
					return;
				//uninstall the document listeneres for the previous topic loaded in this interface
				listeners.unbondDocumntListener(jtfTopicSubject.getDocument(), "Subject");
				listeners.unbondDocumntListener(jtaTopic.getDocument(), "Content");
				topic = (DiscussionTopic) o;
				readonly = readonly || topic.isReadonly();
				jtfTopicSubject.setText(topic.getSubject());
				jtfTopicSubject.setEditable(!readonly);
				jtfTopicID.setText(Long.toString(topic.getID()));
				jtfTopicID.setEditable(!readonly);
				StringBuilder builder = new StringBuilder();
				EffectopediaObject eo = topic.getAboutObject();
				EffectopediaObject eop = eo;
				while ((eop != null) && !(eop instanceof PathwayElement) && !(eop instanceof Pathway))
					eop = eop.getParent();
				if (eop == null)
					eop = eo;
				builder.append("<html>\n<head>\n<style type='text/css'>\n<!--\na {color:#6382BF;}\nh1 {font-size: medium;}\n-->\n</style>\n</head>\n\n<body text=\"#666666\" bgcolor=\"#FCFBFA\" >");
				builder.append("About the ");
				builder.append(TraceableClasses.REGISTERED.getDescription(eop.getClass()));
				builder.append(" ");
				if ((eop != null) && ((eop instanceof PathwayElement) || (eop instanceof Pathway)))
					{
						builder.append("<a href='http://www.effectopedia.org/intreface.php?");
						builder.append(UILocations.getProperEditor(eop).getName());
						builder.append("'> ");
						if (eop instanceof PathwayElement)
							if ((((PathwayElement) eop).getTitle().equals("")) && (eop instanceof Describable))
								builder.append(((Describable) eop).getGenericDescription());
							else
								builder.append(((PathwayElement) eop).getTitle());
						else
							builder.append(((Pathway) eop).getTitle());
						redirector.setObject(eop);
						builder.append("</a>");
					}
				else
					builder.append(eop.toString());
				builder.append("<br>Posted by: <font color='6382BF'><i>");
				builder.append(topic.getAuthor());
				Stamp stamp = topic.getStamp();
				if (stamp != null)
					{
						builder.append("</i></font> on <font color='6382BF'><i>");
						builder.append(stamp.getFormattedDate());
						builder.append("</i></font>");
					}
				builder.append("</body>\n</html>\n");
				jtpTopicHeader.setText(builder.toString());
				jtaTopic.setText(topic.getContent());
				jtaTopic.setEditable(!readonly);

				listeners.bondDocumntListener(jtfTopicSubject.getDocument(), topic, "Subject");
				listeners.bondDocumntListener(jtaTopic.getDocument(), topic, "Content");
			}
		
		private DiscussionTopic				topic	= null;
		private JScrollPane jspTopicContent;
		private RedirectorTextPane	redirector;
		private EventsManager	listeners;
	}

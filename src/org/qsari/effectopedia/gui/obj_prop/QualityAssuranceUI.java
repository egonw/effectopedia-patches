package org.qsari.effectopedia.gui.obj_prop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.core.object.elemets.QualityAssurance;
import org.qsari.effectopedia.gui.AdjustableUI;
import org.qsari.effectopedia.gui.InitializableUI;
import org.qsari.effectopedia.gui.SizeOptimizableUI;
import org.qsari.effectopedia.gui.comp.GlobalUpdateTracker;
import org.qsari.effectopedia.gui.comp.GlobalUpdateTracker.ObjectUpdateListener;
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
public class QualityAssuranceUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, InitializableUI, ObjectUpdateListener, SizeOptimizableUI, ComponentListener
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
				frame.getContentPane().add(new QualityAssuranceUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public QualityAssuranceUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						setPreferredSize(optimalSize);
						setName("quality_assurance");
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBorder(BorderFactory.createTitledBorder(null, "Quality Assurance", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12)));
						this.setBackground(Color.WHITE);
							{
								jspQualityAssurance = new JScrollPane();
								this.add(jspQualityAssurance, BorderLayout.CENTER);
								jspQualityAssurance.setBackground(new java.awt.Color(255, 255, 255));
								jspQualityAssurance.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
								jspQualityAssurance.setOpaque(false);
									{
										jtpQualityAssurance = new JTextPane();
										jspQualityAssurance.setViewportView(jtpQualityAssurance);
										jtpQualityAssurance.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
										jtpQualityAssurance.setContentType("text/html");
										jtpQualityAssurance.setEditable(false);
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
				this.setVisible((visualOptions & QA) != 0);
			}
		
		@Override
		public void objectUpdated(EventObject evt)
			{
				if (qa != null)
					update();
			}
		
		public void load(Object o, boolean readonly)
			{
				if ((o != null) && (o instanceof QualityAssurance))
					{
						qa = (QualityAssurance) o;
						update();
						GlobalUpdateTracker.GUT.addObjectUpdateListener(this);
					}
			}
		
		private void update()
			{
				StringBuilder builder = new StringBuilder();
				builder.append("<html>\n<head>\n<style type='text/css'>\n<!--\na {color:#6382BF;}\nh1 {font-size: medium;}\n-->\n</style>\n</head>\n\n<body text=\"#666666\">");
				builder.append("<i>Contributors: </i><font color='6382BF'>");
				String list = qa.getContributors().getContributorsList(true);
				if (list != null)
					if (list.indexOf(',') != 0)
						{
							list = list.replace(",", "</font>,");
							list = list.replace(";", "</font>;<font color='6382BF'>");
							builder.append(list);
						}
					else
						builder.append(list);
				builder.append("</font>");
				builder.append("<br><i>Reviewers: </i><font color='6382BF'>");
				list = qa.getReviewers().getReviewersList(true);
				if (list != null)
					{
						if (list.indexOf(',') != 0)
						
							{
								list = list.replace(",", "</font>,");
								list = list.replace(";", "</font>;<font color='6382BF'>");
								builder.append(list);
							}
						else
							builder.append(list);
					}
				builder.append("</font>");
				builder.append("<br><i>Seals of Approval: </i>");
				Stamp stamp = qa.getContributors().getStamp();
				if (stamp != null)
					{
						builder.append("<br><i>Last modified: </i><font color='6382BF'>");
						builder.append(stamp.getFormattedDate());
						builder.append("</font>");
					}
				builder.append("</body>\n</html>\n");
				
				jtpQualityAssurance.setText(builder.toString());
				initializeUI();
				updateOptimalSize();
			}
		
		public void updateOptimalSize()
			{
				Insets insets = this.getBorder().getBorderInsets(this);
				this.setSize(optimalSize);
				this.setPreferredSize(optimalSize);
				this.setMinimumSize(optimalSize);
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
		
		public void initializeUI()
			{
				// JScrollBar scrollbar = jspQualityAssurance.getVerticalScrollBar();
				// if (scrollbar != null)
				// scrollbar.setValue(0);
				// jspQualityAssurance.getViewport().setViewPosition(SizeOptimizableUI.TOPLEFT);
				jtpQualityAssurance.setCaretPosition(0);
			}
		
		QualityAssurance				qa										= null;
		private Dimension			optimalSize	= new Dimension(400, 96);
		private JTextPane			jtpQualityAssurance;
		private JScrollPane	jspQualityAssurance;
		
		@Override
		public void componentHidden(ComponentEvent e)
			{
				GlobalUpdateTracker.GUT.removeObjectUpdateListener(this);
			}
		
		@Override
		public void componentMoved(ComponentEvent e)
			{
				
			}
		
		@Override
		public void componentResized(ComponentEvent e)
			{
				
			}
		
		@Override
		public void componentShown(ComponentEvent e)
			{
				GlobalUpdateTracker.GUT.addObjectUpdateListener(this);
				update();
			}
		
	}

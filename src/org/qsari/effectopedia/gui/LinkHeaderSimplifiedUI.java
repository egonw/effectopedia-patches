package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.gui.comp.EventsManager;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.toolbars.FeedbackToolbarUI;
import org.qsari.effectopedia.gui.util.HintedTextField;

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
public class LinkHeaderSimplifiedUI extends EffectopediaObjectHeaderUI<Link> implements AdjustableUI, LoadableEditorUI, SizeOptimizableUI, MouseListener
	{
		/**
		* 
		*/
		private static final long	serialVersionUID	= 1L;
		private JLabel												jlLinkWeight;
		private JCheckBox									jcbHypotetical;
		private JLabel												jlLinkTitle;
		private JTextField								jtfLinkWeight;
		private JTextField								jtfLinkID;
		private JLabel												jlLinkID;
		private FeedbackToolbarUI	ftbuiLink;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new LinkHeaderSimplifiedUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public LinkHeaderSimplifiedUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("header");
				listeners = new EventsManager();
				initGUI();
			}
			
		private void initGUI()
			{
				try
					{
						GridBagLayout thisLayout = new GridBagLayout();
						thisLayout.rowWeights = new double[]
							{ 0.1, 0.0 };
						thisLayout.rowHeights = new int[]
							{ 20, 28 };
						thisLayout.columnWeights = new double[]
							{ 0.1, 0.1, 0.1, 0.1, 0.1 };
						thisLayout.columnWidths = new int[]
							{ 1, 15, 1, 1, 1 };
						this.setLayout(thisLayout);
						this.setPreferredSize(optimalSize);
						this.setBackground(Color.WHITE);
							{
								jlLinkID = new JLabel();
								this.add(jlLinkID, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(2, 0, 0, 2), 0, 0));
								jlLinkID.setText("ID");
								jlLinkID.setBackground(Color.WHITE);
							}
							{
								jtfLinkID = new JTextField();
								this.add(jtfLinkID, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.2, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jtfLinkID.setText("auto");
								jtfLinkID.setName("id");
							}
							{
								ftbuiLink = new FeedbackToolbarUI("link", FeedbackToolbarUI.INTERACT, FlowLayout.RIGHT);
								this.add(ftbuiLink, new GridBagConstraints(4, 0, 1, 1, 0.1, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 2), 0, 0));
							}
							
							{
								jlLinkWeight = new JLabel();
								this.add(jlLinkWeight, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 2, 2), 0, 0));
								jlLinkWeight.setText("Weight");
								jlLinkWeight.setBackground(Color.WHITE);
								jlLinkWeight.setName("weight");
							}
							{
								jtfLinkWeight = new JTextField();
								this.add(jtfLinkWeight, new GridBagConstraints(1, 1, 1, 1, 0.7, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jtfLinkWeight.setText("1");
								jtfLinkWeight.setName("weight");
							}
							{
								jcbHypotetical = new JCheckBox();
								this.add(jcbHypotetical, new GridBagConstraints(2, 1, 3, 1, 0.3, 0.0, GridBagConstraints.NORTHEAST, GridBagConstraints.HORIZONTAL, new Insets(0, 4, 0, 0), 0, 0));
								jcbHypotetical.setText("Hypothetical");
								jcbHypotetical.setBackground(Color.WHITE);
								jcbHypotetical.setHorizontalAlignment(SwingConstants.CENTER);
								jcbHypotetical.setName("hypotetical");
							}
							{
								htfTitle = new HintedTextField();
								this.add(htfTitle, new GridBagConstraints(1, 0, 1, 1, 0.7, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								htfTitle.setText("Type Link Title Here");
								htfTitle.setFont(new java.awt.Font("Segoe UI", 1, 12));
								htfTitle.addMouseListener(this);
								htfTitle.setName("title");
							}
							{
								jlLinkTitle = new JLabel();
								this.add(jlLinkTitle, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 2), 0, 0));
								jlLinkTitle.setText("Title");
								jlLinkTitle.setBackground(Color.WHITE);
								jlLinkTitle.setName("title");
							}
						RootHelpContext.addMouseMotionListeners(this, rootHelpContext,false);
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
				if ((visualOptions & HEADER) != 0)
					{
						setVisible(true);
						jlLinkID.setVisible((visualOptions & LABELS) == LABELS);
						jlLinkWeight.setVisible((visualOptions & LABELS) == LABELS);
						jlLinkTitle.setVisible((visualOptions & LABELS) == LABELS);
						jtfLinkID.setVisible((visualOptions & AUTOIDS) == AUTOIDS);
					}
				else
					{
						setVisible(false);
					}
			}
			
		public void updateDocumentListeners()
			{
				listeners.bondDocumntListener(htfTitle.getDocument(), eo, "Title");
			}
			
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof Link))
					return;
				listeners.unbondDocumntListener(htfTitle.getDocument(), "Title");
				eo = (Link) o;
				jtfLinkID.setText(eo.getIDandExternalID());
				jtfLinkWeight.setText("0");
				jtfLinkWeight.setEditable(!readonly);
				htfTitle.setText(eo.getTitle());
				htfTitle.setEditable(!readonly);
				updateOptimalSize();
				listeners.bondDocumntListener(htfTitle.getDocument(), eo, "Title");
				ftbuiLink.load(eo, readonly);
			}
			
		public void updateOptimalSize()
			{
				Container parent = getParent();
				if (parent.getWidth() != 0)
					optimalSize.height = jlLinkTitle.getPreferredSize().height + jcbHypotetical.getPreferredSize().height + 8;
				
				setPreferredSize(optimalSize);
				setMaximumSize(optimalSize);
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
			
		private Dimension					optimalSize	= new Dimension(400, 64);
		private EventsManager	listeners;
		
	}

package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.objects.Pathway;
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
public class PathwayHeaderUI extends EffectopediaObjectHeaderUI<Pathway> implements AdjustableUI, LoadableEditorUI, SizeOptimizableUI
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1207971105123532796L;
		private JLabel												jlPathwayTitle;
		private JTextField								jtfPathwayID;
		private JLabel												jlPathwayID;
		private FeedbackToolbarUI	ftbuiPathway;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new PathwayHeaderUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public PathwayHeaderUI(RootHelpContext rootHelpContext)
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
						this.setPreferredSize(optimalSize);
						GridBagLayout thisLayout = new GridBagLayout();
						thisLayout.rowWeights = new double[]
							{ 0.0, 0.1 };
						thisLayout.rowHeights = new int[]
							{ 23, 20 };
						thisLayout.columnWeights = new double[]
							{ 0.1, 0.7, 0.05, 0.15, 0.1 };
						thisLayout.columnWidths = new int[]
							{ 40, 280, 20, 60, 40 };
						this.setLayout(thisLayout);
						this.setBackground(Color.WHITE);
							{
								jlPathwayTitle = new JLabel();
								this.add(jlPathwayTitle, new GridBagConstraints(0, 0, 1, 1, 0.1, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(2, 4, 0, 2), 0, 0));
								jlPathwayTitle.setText("Title: ");
								jlPathwayTitle.setDisplayedMnemonicIndex(0);
								jlPathwayTitle.setFont(new java.awt.Font("Dialog", 0, 12));
								jlPathwayTitle.setName("title");
							}
							{
								jlPathwayID = new JLabel();
								this.add(jlPathwayID, new GridBagConstraints(2, 0, 1, 1, 0.1, 0.0, GridBagConstraints.NORTHEAST, GridBagConstraints.NONE, new Insets(2, 0, 0, 2), 0, 0));
								jlPathwayID.setText("ID");
								jlPathwayID.setDisplayedMnemonicIndex(0);
								jlPathwayID.setFont(new java.awt.Font("Dialog", 0, 12));
								jlPathwayID.setName("id");
							}
							{
								htfTitle = new HintedTextField();
								this.add(htfTitle, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								htfTitle.setFont(new java.awt.Font("Dialog", 1, 12));
								htfTitle.setMinimumSize(new java.awt.Dimension(160, 20));
								////htfTitle.setHorizontalAlignment(SwingConstants.CENTER);
								htfTitle.setPreferredSize(new java.awt.Dimension(280, 24));
								htfTitle.setText("Type Concise Pathway Title ");
								htfTitle.addMouseListener(this);
								htfTitle.setName("title");
							}
							{
								jtfPathwayID = new JTextField();
								this.add(jtfPathwayID, new GridBagConstraints(3, 0, 1, 1, 0.15, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jtfPathwayID.setHorizontalAlignment(SwingConstants.CENTER);
								jtfPathwayID.setText("auto");
								jtfPathwayID.setEditable(false);
								jtfPathwayID.setName("id");
							}
							{
								ftbuiPathway = new FeedbackToolbarUI("pathway", FeedbackToolbarUI.INTERACT, FlowLayout.RIGHT);
								this.add(ftbuiPathway, new GridBagConstraints(4, 0, 1, 1, 0.15, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 2), 0, 0));
								ftbuiPathway.setMinimumSize(new java.awt.Dimension(48, 20));
								ftbuiPathway.setMaximumSize(new java.awt.Dimension(48, 24));
							}
							{
								puiProperties = new PropertiesUI(rootHelpContext);
								this.add(puiProperties, new GridBagConstraints(0, 1, 5, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
								puiProperties.setPreferredSize(new java.awt.Dimension(400, 64));
								puiProperties.setSize(397, 64);
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
						jlPathwayID.setVisible((visualOptions & LABELS) == LABELS);
						jlPathwayTitle.setVisible((visualOptions & LABELS) == LABELS);
						jtfPathwayID.setVisible((visualOptions & AUTOIDS) == AUTOIDS);
					}
				else
					{
						setVisible(false);
					}
			}
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof Pathway))
					return;
				listeners.unbondDocumntListener(htfTitle.getDocument(), "Title");
				eo = (Pathway) o;
				jtfPathwayID.setText(eo.getIDandExternalID());
				htfTitle.setText(eo.getTitle());
				htfTitle.setEditable(!readonly);
				puiProperties.load(eo.getSearchablePoperties(), readonly);
				updateOptimalSize();
				listeners.bondDocumntListener(htfTitle.getDocument(), eo, "Title");
				ftbuiPathway.load(eo, readonly);
			}
		
		public void updateOptimalSize()
			{
				optimalSize.width = puiProperties.getWidth();
				optimalSize.height = puiProperties.getPreferredSize().height + jlPathwayTitle.getPreferredSize().height;
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
		
		private Dimension					optimalSize						= new Dimension(400, 64);
		private EventsManager	listeners;
		private PropertiesUI		puiProperties;
			}

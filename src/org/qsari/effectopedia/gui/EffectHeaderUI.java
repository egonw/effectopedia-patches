package org.qsari.effectopedia.gui;

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
import javax.swing.text.Document;

import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.gui.comp.EventsManager;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.obj_prop.ObjectPropertiesListUI;
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
public class EffectHeaderUI extends EffectopediaObjectHeaderUI<Effect> implements AdjustableUI, LoadableEditorUI, SizeOptimizableUI
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1207971105123532796L;
		private JLabel												jlEffectTitle;
		private JTextField								jtfEffectID;
		private JLabel												jlEffectID;
		private FeedbackToolbarUI	ftbuiEffect;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new EffectHeaderUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public EffectHeaderUI(RootHelpContext rootHelpContext)
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
							{ 0.0, 0.1 };
						thisLayout.rowHeights = new int[]
							{ 24, 48 };
						thisLayout.columnWeights = new double[]
							{ 0.0, 0.7, 0.0, 0.2, 0.1 };
						// thisLayout.columnWidths = new int[] {24,230, 24, 80, 42};
						this.setLayout(thisLayout);
						this.setFont(new java.awt.Font("Tahoma", 1, 12));
							{
								jlEffectTitle = new JLabel();
								this.add(jlEffectTitle, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(2, 4, 0, 2), 0, 0));
								jlEffectTitle.setText("Title");
								jlEffectTitle.setDisplayedMnemonicIndex(0);
								jlEffectTitle.setFont(new java.awt.Font("Dialog", 0, 12));
								jlEffectTitle.addMouseListener(this);
								jlEffectTitle.setName("title");
							}
							{
								jlEffectID = new JLabel();
								this.add(jlEffectID, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHEAST, GridBagConstraints.NONE, new Insets(2, 2, 0, 2), 0, 0));
								jlEffectID.setText("ID");
								jlEffectID.setDisplayedMnemonicIndex(0);
								jlEffectID.setFont(new java.awt.Font("Dialog", 0, 12));
								jlEffectID.addMouseListener(this);
								jlEffectID.setName("id");
							}
							{
								ftbuiEffect = new FeedbackToolbarUI("effect", FeedbackToolbarUI.INTERACT, FlowLayout.RIGHT);
								this.add(ftbuiEffect, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHEAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 2), 0, 0));
							}
							{
								htfTitle = new HintedTextField();
								this.add(htfTitle, new GridBagConstraints(1, 0, 1, 1, 0.7, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								htfTitle.setFont(new java.awt.Font("Dialog", 1, 12));
								//htfTitle.setHorizontalAlignment(SwingConstants.CENTER);
								htfTitle.setText("Type Concise Title ");
								htfTitle.addMouseListener(this);
								htfTitle.setName("title");
							}
							{
								jtfEffectID = new JTextField();
								this.add(jtfEffectID, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 0, 0), 0, 0));
								jtfEffectID.setHorizontalAlignment(SwingConstants.CENTER);
								jtfEffectID.setText("auto");
								jtfEffectID.setEditable(false);
								jtfEffectID.setName("id");
							}
							{
								opuilProperties = new ObjectPropertiesListUI("(Key) Event metadata", "Event metadata", "VI",rootHelpContext);
								opuilProperties.setEditable(false);
								this.add(opuilProperties, new GridBagConstraints(0, 1, 5, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
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
				// allowRedirecting = (visualOptions & VIEW) != 0;
				if ((visualOptions & HEADER) != 0)
					{
						setVisible(true);
						jlEffectID.setVisible((visualOptions & LABELS) == LABELS);
						jlEffectTitle.setVisible((visualOptions & LABELS) == LABELS);
						jtfEffectID.setVisible((visualOptions & AUTOIDS) == AUTOIDS);
						// int gridx = (jlEffectTitle.isVisible()) ? 1 : 0;
						// int gridwidth = 2 - gridx + 2 * ((jtfEffectID.isVisible()) ? 0 : 1);
					}
				else
					{
						setVisible(false);
					}
			}
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof Effect))
					return;
				Document doc = htfTitle.getDocument();
				listeners.unbondDocumntListener(doc, "Title");
				eo = (Effect) o;
				jtfEffectID.setText(eo.getIDandExternalID());
				htfTitle.setText(eo.getTitle());
				htfTitle.setEditable(!readonly);
				opuilProperties.load(eo.getMetadata(), readonly);
				opuilProperties.collapse();
				listeners.bondDocumntListener(doc, eo, "Title");
				ftbuiEffect.load(eo, readonly);
			}
		
		public void updateOptimalSize()
			{
				optimalSize.width = opuilProperties.getWidth();
				optimalSize.height = opuilProperties.getPreferredSize().height + jlEffectTitle.getPreferredSize().height + 16;
				setSize(optimalSize);
				setPreferredSize(optimalSize);
				setMinimumSize(optimalSize);
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
		
		private Dimension					optimalSize						= new Dimension(400, 72);
		private EventsManager	listeners;
		private ObjectPropertiesListUI	opuilProperties;
		
	}

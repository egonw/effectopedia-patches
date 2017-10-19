package org.qsari.effectopedia.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.text.Document;

import org.qsari.effectopedia.core.objects.TransformationSet;
import org.qsari.effectopedia.gui.comp.EventsManager;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
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
public class TransformationSetHeaderUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, SizeOptimizableUI
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1207971105123532796L;
		private JLabel												jlTSTargetSite;
		private HintedTextField			htfTSTargetSite;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new TransformationSetHeaderUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public TransformationSetHeaderUI(RootHelpContext rootHelpContext)
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
							{ 0.0 };
						thisLayout.rowHeights = new int[]
							{ 24 };
						thisLayout.columnWeights = new double[]
							{ 0.0, 0.7 };
						// thisLayout.columnWidths = new int[] {24,230, 24, 80, 42};
						this.setLayout(thisLayout);
						this.setFont(new java.awt.Font("Tahoma", 1, 12));
							{
								jlTSTargetSite = new JLabel("Target Site: ");
								this.add(jlTSTargetSite, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(2, 4, 0, 2), 0, 0));
								jlTSTargetSite.setDisplayedMnemonicIndex(0);
								jlTSTargetSite.setFont(new java.awt.Font("Dialog", 0, 12));
							}
							{
								htfTSTargetSite = new HintedTextField();
								this.add(htfTSTargetSite, new GridBagConstraints(1, 0, 1, 1, 0.7, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								htfTSTargetSite.setFont(new java.awt.Font("Dialog", 1, 12));
								htfTSTargetSite.setHorizontalAlignment(SwingConstants.CENTER);
								htfTSTargetSite.setText("Biological compartment");
							}
						updateOptimalSize();
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
						jlTSTargetSite.setVisible((visualOptions & LABELS) == LABELS);
					}
				else
					{
						setVisible(false);
					}
			}
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof TransformationSet))
					return;
				Document doc = htfTSTargetSite.getDocument();
				listeners.unbondDocumntListener(doc, "TargetSite");
				transformationSet = (TransformationSet) o;
				htfTSTargetSite.setText(transformationSet.getTitle());
				htfTSTargetSite.setEditable(!readonly);
				listeners.bondDocumntListener(doc, transformationSet, "TargetSite");
			}
		
		public void updateOptimalSize()
			{
				optimalSize.height = jlTSTargetSite.getPreferredSize().height + 8;
				setSize(optimalSize);
				setPreferredSize(optimalSize);
				setMinimumSize(optimalSize);
				setMaximumSize(maximumSize);
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
		
		public HintedTextField getTitleUI()
			{
				return htfTSTargetSite;
			}
		
		private Dimension									optimalSize						= new Dimension(400, 24);
		private Dimension									maximumSize						= new Dimension(Integer.MAX_VALUE, 24);
		private TransformationSet	transformationSet;
		private EventsManager					listeners;
	}

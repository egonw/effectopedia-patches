package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.objects.Initiator_BiologcalPerturbation;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;

/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
/**
 * @version 1.0 @(#)StructuralAlertUI.java 1.0
 * @author Hristo Aladjov
 * 
 */

public class EditBiologicalPerturbationUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI
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
				frame.getContentPane().add(new EditBiologicalPerturbationUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		/**
		 * Instantiates a new chemical ui.
		 */
		public EditBiologicalPerturbationUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("biological_perturbation");
				initGUI(false);
			}
		
		public EditBiologicalPerturbationUI(boolean basicLayout,RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("biological_perturbation");
				initGUI(basicLayout);
			}
		
		private void initGUI(boolean basicLayout)
			{
				try
					{
						int visible = (basicLayout) ? 0 : 1;
						setPreferredSize(new Dimension(800, 300));
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBackground(Color.WHITE);
							{
								bphuiBiologicalPerturbation = new BiologicalPerturbationHeaderUI(rootHelpContext);
								this.add(bphuiBiologicalPerturbation, BorderLayout.NORTH);
								bphuiBiologicalPerturbation.setPreferredSize(new java.awt.Dimension(800, 32));
							}
							{
								jpBiologicalPerturbaton = new JPanel();
								GridBagLayout gblBiologicalPerturbation = new GridBagLayout();
								this.add(jpBiologicalPerturbaton, BorderLayout.CENTER);
								gblBiologicalPerturbation.rowWeights = new double[]
									{ 0.1,0.1, 0.1 };
								gblBiologicalPerturbation.rowHeights = new int[]
									{ 7, 7, 7 };
								gblBiologicalPerturbation.columnWeights = new double[]
									{ 0.1, 0.1, 0.12 * visible, 0.08 * visible };
								gblBiologicalPerturbation.columnWidths = new int[]
									{ 10, 10, 12 * visible, 8 * visible };
								jpBiologicalPerturbaton.setLayout(gblBiologicalPerturbation);
									{
										duiDescription = new DescriptionUI(rootHelpContext);
										jpBiologicalPerturbaton.add(duiDescription, new GridBagConstraints(0, 0, 4, 1, 0.4, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
									}

									{
										pluiAssociatedPathways = new PathwaysListUI(rootHelpContext);
										jpBiologicalPerturbaton.add(pluiAssociatedPathways, new GridBagConstraints(0, 1, 4, 1, 0.4, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
									}
									
									{
										ruiReferences = new ReferencesUI(rootHelpContext);
										jpBiologicalPerturbaton.add(ruiReferences, new GridBagConstraints(0, 2, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
										ruiReferences.setVisible(!basicLayout);
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
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof Initiator_BiologcalPerturbation))
					return;
				perturbation = (Initiator_BiologcalPerturbation) o;
				bphuiBiologicalPerturbation.load(perturbation, readonly);
				duiDescription.load(perturbation.getDescriptionIDs(), readonly);
				pluiAssociatedPathways.load(perturbation.getPathwayIDs(), readonly);
				ruiReferences.load(perturbation.getReferenceIDs(), readonly);
			}
		
		private BiologicalPerturbationHeaderUI	bphuiBiologicalPerturbation;
		private DescriptionUI																		duiDescription;
		private PathwaysListUI																	pluiAssociatedPathways;
		private ReferencesUI																			ruiReferences;
		private JPanel																									jpBiologicalPerturbaton;

		private Initiator_BiologcalPerturbation	perturbation;
	}

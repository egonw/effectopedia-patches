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

import org.qsari.effectopedia.core.objects.Initiator_StructuralAlerts;
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

public class EditStructuralAlertsUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI
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
				frame.getContentPane().add(new EditStructuralAlertsUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		private ReferencesUI												ruiReferences;
		private StructuralAlertHeaderUI	sahuiStructuralAlert;
		private PathwaysListUI										pluiAssociatedPathways;
		private JPanel																		jpStructuralAlert;
		
		/**
		 * Instantiates a new chemical ui.
		 */
		public EditStructuralAlertsUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("structural_alerts");
				initGUI(false);
			}
		
		public EditStructuralAlertsUI(boolean basicLayout, RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("structural_alerts");
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
								sahuiStructuralAlert = new StructuralAlertHeaderUI(rootHelpContext);
								this.add(sahuiStructuralAlert, BorderLayout.NORTH);
								sahuiStructuralAlert.setPreferredSize(new java.awt.Dimension(800, 32));
							}
							{
								jpStructuralAlert = new JPanel();
								GridBagLayout gblStructuralAlert = new GridBagLayout();
								this.add(jpStructuralAlert, BorderLayout.CENTER);
								gblStructuralAlert.rowWeights = new double[] {0.1, 0.1};
								gblStructuralAlert.rowHeights = new int[] {7, 7};
								gblStructuralAlert.columnWeights = new double[]
									{ 0.1, 0.1, 0.12 * visible, 0.08 * visible };
								gblStructuralAlert.columnWidths = new int[]
									{ 10, 10, 12 * visible, 8 * visible };
								jpStructuralAlert.setLayout(gblStructuralAlert);
									{
										pluiAssociatedPathways = new PathwaysListUI(rootHelpContext);
										jpStructuralAlert.add(pluiAssociatedPathways, new GridBagConstraints(0, 0, 4, 1, 0.4, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
									}
									
									{
										ruiReferences = new ReferencesUI(rootHelpContext);
										jpStructuralAlert.add(ruiReferences, new GridBagConstraints(0, 1, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
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
				if (!(o instanceof Initiator_StructuralAlerts))
					return;
				alert = (Initiator_StructuralAlerts) o;
				sahuiStructuralAlert.load(alert,readonly);
				pluiAssociatedPathways.load(alert.getPathwayIDs(),readonly);
				ruiReferences.load(alert.getReferenceIDs(),readonly);
			}
		
		private Initiator_StructuralAlerts	alert;
	}

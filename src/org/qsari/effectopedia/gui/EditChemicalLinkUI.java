package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.objects.Link_ChemStructToMIE;
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
public class EditChemicalLinkUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI
	{
		/**
	 * 
	 */
		private static final long					serialVersionUID	= 1L;
		private JSplitPane												jspCauseLink;
		private JScrollPane jspChemical;
		private ChemicalUI												cuiChemicals;
		private EffectUI														euiMolecularInitiatingEvent;
		private Link_SubstanceToMIEUI	luiLink;
		private JSplitPane												jspLinkEffect;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new EditChemicalLinkUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public EditChemicalLinkUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("chemical_link");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
							{
								BorderLayout thisLayout = new BorderLayout();
								this.setLayout(thisLayout);
								setPreferredSize(new Dimension(600, 300));
									{
										jspCauseLink = new JSplitPane();
										this.add(jspCauseLink, BorderLayout.CENTER);
										jspCauseLink.setOneTouchExpandable(true);
										jspCauseLink.setResizeWeight(0.33);
											{
												jspChemical = new JScrollPane();
												jspCauseLink.add(jspChemical, JSplitPane.LEFT);
													{
														cuiChemicals = new ChemicalUI(true);
														jspChemical.setViewportView(cuiChemicals);
														cuiChemicals.adjustUI(EDIT - CHEMPROP - CHEMSYNONYMS);
														cuiChemicals.setHeaderAllowRedirecting(true);
													}
											}
											{
												jspLinkEffect = new JSplitPane();
												jspLinkEffect.setOneTouchExpandable(true);
												jspLinkEffect.setResizeWeight(0.5);
												jspCauseLink.add(jspLinkEffect, JSplitPane.RIGHT);
													{
														luiLink = new Link_SubstanceToMIEUI();
														jspLinkEffect.add(luiLink, JSplitPane.LEFT);
														luiLink.setPreferredSize(new java.awt.Dimension(200, 400));
														luiLink.setMinimumSize(new java.awt.Dimension(50, 400));
													}
													{
														euiMolecularInitiatingEvent = new EffectUI("Molecular Initiating Event");
														jspLinkEffect.add(euiMolecularInitiatingEvent, JSplitPane.RIGHT);
														euiMolecularInitiatingEvent.setPreferredSize(new java.awt.Dimension(200, 400));
														euiMolecularInitiatingEvent.setMinimumSize(new java.awt.Dimension(50, 400));
														euiMolecularInitiatingEvent.setHeaderAllowRedirecting(true);
													}
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
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof Link_ChemStructToMIE))
					return;
				Link_ChemStructToMIE link = (Link_ChemStructToMIE) o;
				EffectopediaObject eo = link.getStructure().getCachedObject();
				cuiChemicals.load(eo, (eo != null) ? eo.isReadonly() : true);
				luiLink.load(link, readonly);
				eo = link.getEffect().getCachedObject();
				euiMolecularInitiatingEvent.load(eo, (eo != null) ? eo.isReadonly() : true);
			}
		
	}

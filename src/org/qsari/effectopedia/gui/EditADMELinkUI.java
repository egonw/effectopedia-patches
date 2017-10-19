package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.objects.Link_ChemStructToChemStruct;
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
public class EditADMELinkUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI
	{
		/**
	 * 
	 */
		private static final long																			serialVersionUID	= 1L;
		private JSplitPane																										jspCauseLink;
		private JScrollPane																									jspChildStructure;
		private JScrollPane																									jspParentStructure;
		private ChemicalUI																										cuiParentStructure;
		private ChemicalUI																										cuiChildStructure;
		private Link_SubstanceToReactiveSubstanceUI	lstrsuiLink;
		private JSplitPane																										jspLinkEffect;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new EditADMELinkUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public EditADMELinkUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("adme_link");
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
												jspParentStructure = new JScrollPane();
												jspCauseLink.add(jspParentStructure, JSplitPane.LEFT);
												jspParentStructure.setPreferredSize(new java.awt.Dimension(201, 298));
													{
														cuiParentStructure = new ChemicalUI(true);
														jspParentStructure.setViewportView(cuiParentStructure);
														cuiParentStructure.adjustUI(EDIT - CHEMPROP - CHEMSYNONYMS);
														cuiParentStructure.setPreferredSize(new java.awt.Dimension(192, 298));
														cuiParentStructure.setMinimumSize(new java.awt.Dimension(50, 400));
													}
											}
											{
												jspLinkEffect = new JSplitPane();
												jspLinkEffect.setOneTouchExpandable(true);
												jspLinkEffect.setResizeWeight(0.5);
												jspCauseLink.add(jspLinkEffect, JSplitPane.RIGHT);
													{
														lstrsuiLink = new Link_SubstanceToReactiveSubstanceUI();
														jspLinkEffect.add(lstrsuiLink, JSplitPane.LEFT);
														lstrsuiLink.setPreferredSize(new java.awt.Dimension(200, 400));
														lstrsuiLink.setMinimumSize(new java.awt.Dimension(50, 400));
													}
													{
														jspChildStructure = new JScrollPane();
														jspLinkEffect.add(jspChildStructure, JSplitPane.RIGHT);
														jspChildStructure.setPreferredSize(new java.awt.Dimension(195, 296));
															{
																cuiChildStructure = new ChemicalUI(true);
																jspChildStructure.setViewportView(cuiChildStructure);
																cuiChildStructure.setPreferredSize(new java.awt.Dimension(200, 400));
																cuiChildStructure.setMinimumSize(new java.awt.Dimension(50, 400));
															}
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
				if (!(o instanceof Link_ChemStructToChemStruct))
					return;
				Link_ChemStructToChemStruct link = (Link_ChemStructToChemStruct) o;
				EffectopediaObject eo = link.getParentStructure().getCachedObject();
				cuiParentStructure.load(eo, (eo != null) ? eo.isReadonly() : true);
				lstrsuiLink.load(link, readonly);
				eo = link.getStructure().getCachedObject();
				cuiChildStructure.load(eo, (eo != null) ? eo.isReadonly() : true);
			}
		
	}

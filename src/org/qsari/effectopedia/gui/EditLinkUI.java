package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
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
public class EditLinkUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI
	{
		/**
	 * 
	 */
		private static final long					serialVersionUID	= 1L;
		private JSplitPane												jspCauseLink;
		private EffectUI														euiCause;
		private EffectUI														euiDownstreamEffect;
		private Link_EffectToEffectUI	luiLink;
		private JSplitPane												jspLinkEffect;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new EditLinkUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public EditLinkUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("link");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						setPreferredSize(new Dimension(600, 400));
							{
								jspCauseLink = new JSplitPane();
								this.add(jspCauseLink, BorderLayout.CENTER);
								jspCauseLink.setOneTouchExpandable(true);
								jspCauseLink.setResizeWeight(0.33);
									{
										euiCause = new EffectUI("Upstream Cause");
										jspCauseLink.add(euiCause, JSplitPane.LEFT);
										euiCause.setPreferredSize(new java.awt.Dimension(200, 300));
										euiCause.setMinimumSize(new java.awt.Dimension(50, 300));
										euiCause.setHeaderAllowRedirecting(true);
									}
									{
										jspLinkEffect = new JSplitPane();
										jspLinkEffect.setOneTouchExpandable(true);
										jspLinkEffect.setResizeWeight(0.5);
										jspCauseLink.add(jspLinkEffect, JSplitPane.RIGHT);
											{
												luiLink = new Link_EffectToEffectUI();
												jspLinkEffect.add(luiLink, JSplitPane.LEFT);
												luiLink.setPreferredSize(new java.awt.Dimension(200, 300));
												luiLink.setMinimumSize(new java.awt.Dimension(50, 300));
											}
											{
												euiDownstreamEffect = new EffectUI("Downstream Effect");
												jspLinkEffect.add(euiDownstreamEffect, JSplitPane.RIGHT);
												euiDownstreamEffect.setPreferredSize(new java.awt.Dimension(200, 300));
												euiDownstreamEffect.setMinimumSize(new java.awt.Dimension(50, 300));
												euiDownstreamEffect.setHeaderAllowRedirecting(true);
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
				if (!(o instanceof Link_EffectToEffect))
					return;
				Link_EffectToEffect link = (Link_EffectToEffect) o;
				EffectopediaObject eo = link.getFromEffect().getCachedObject();
				euiCause.load(eo,(eo!=null)?eo.isReadonly():true);
				eo = link.getToEffect().getCachedObject();
				euiDownstreamEffect.load(eo,(eo!=null)?eo.isReadonly():true);
				luiLink.load(link,readonly);
			}
		
	}

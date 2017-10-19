package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.core.objects.Effect;
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
public class RelatedEffectsUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI
	{
		/**
	 * 
	 */
		private static final long			serialVersionUID	= 1L;
		private LinkedEffectsListUI	leluiLinkedEffects;
		private SuggestedEffectsUI		seuiSuggestedEffects;
		private LinkNewEffectUI					lneuiNewEffects;
		
		private boolean													upstream;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new RelatedEffectsUI(false,null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public RelatedEffectsUI(boolean upstream,RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName(upstream?"up_causes":"dn_effects");
				this.upstream = upstream;
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						BoxLayout thisLayout = new BoxLayout(this, javax.swing.BoxLayout.Y_AXIS);
						this.setLayout(thisLayout);
						setPreferredSize(new Dimension(400, 300));
						String title = upstream?"Linked upstream causes":"Linked downstream events";
						this.setBorder(BorderFactory.createTitledBorder(null, title, TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Tahoma", 2, 11)));
						this.setBackground(Color.WHITE);
							{
								leluiLinkedEffects = new LinkedEffectsListUI(upstream,rootHelpContext);
								this.add(leluiLinkedEffects);
							}
							{
								lneuiNewEffects = new LinkNewEffectUI(upstream,rootHelpContext);
								this.add(lneuiNewEffects);
							}
							{
								seuiSuggestedEffects = new SuggestedEffectsUI(upstream,rootHelpContext);
								this.add(seuiSuggestedEffects);
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
		
		public void load(Object o,boolean readonly)
			{
				if (!(o instanceof Effect))
					return;
				effect = (Effect) o;
				if (upstream)
					leluiLinkedEffects.load(effect.getUpstreamLinkIDs(),readonly);
				else
					leluiLinkedEffects.load(effect.getDownstreamLinkIDs(),readonly);
				seuiSuggestedEffects.load(effect);
			}
		
		protected Effect	effect;
	}

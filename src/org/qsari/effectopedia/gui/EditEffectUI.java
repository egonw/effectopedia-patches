package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

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
public class EditEffectUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		private JSplitPane								jspEffect;
		private JPanel												rtuiRelatedTests;
		private RelatedEffectsUI		reuiRelatedUpstreamEffects;
		private RelatedEffectsUI		reuiRelatedDownstreamEffects;
		private EffectUI										euiEffect;
		private JSplitPane								jspEffectTest;
		private JSplitPane								jspEffectDownstream;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new EditEffectUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public EditEffectUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("edit_effect");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						setPreferredSize(new Dimension(400, 300));
							{
								jspEffect = new JSplitPane();
								jspEffect.setOneTouchExpandable(true);
								jspEffect.setResizeWeight(0.25);
								this.add(jspEffect, BorderLayout.CENTER);
									{
										jspEffectDownstream = new JSplitPane();
										jspEffectDownstream.setOneTouchExpandable(true);
										jspEffectDownstream.setResizeWeight(0.75);
										jspEffect.add(jspEffectDownstream, JSplitPane.RIGHT);
											{
												jspEffectTest = new JSplitPane();
												jspEffectDownstream.add(jspEffectTest, JSplitPane.LEFT);
												jspEffectTest.setOrientation(JSplitPane.VERTICAL_SPLIT);
												jspEffectTest.setOneTouchExpandable(true);
												jspEffectTest.setResizeWeight(0.75);
												jspEffectTest.setBackground(Color.WHITE);
												jspEffectTest.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
													{
														euiEffect = new EffectUI();
														jspEffectTest.add(euiEffect, JSplitPane.TOP);
														euiEffect.setPreferredSize(new java.awt.Dimension(140, 255));
													}
													{
														rtuiRelatedTests = new JPanel();
														jspEffectTest.add(rtuiRelatedTests, JSplitPane.BOTTOM);
														rtuiRelatedTests.setVisible(false);
													}
											}
											{
												reuiRelatedDownstreamEffects = new RelatedEffectsUI(false,rootHelpContext);
												jspEffectDownstream.add(reuiRelatedDownstreamEffects, JSplitPane.RIGHT);
												reuiRelatedDownstreamEffects.setPreferredSize(new java.awt.Dimension(76, 296));
											}
									}
									{
										reuiRelatedUpstreamEffects = new RelatedEffectsUI(true,rootHelpContext);
										jspEffect.add(reuiRelatedUpstreamEffects, JSplitPane.LEFT);
										reuiRelatedUpstreamEffects.setPreferredSize(new java.awt.Dimension(85, 298));
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
				if (!(o instanceof Effect))
					return;
				Effect effect = (Effect) o;
				euiEffect.load(effect,readonly);
				reuiRelatedUpstreamEffects.load(effect,readonly);
				reuiRelatedDownstreamEffects.load(effect,readonly);
			}
		
	}

package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
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
public class EditTestResponceMappingUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI
	{
		/**
	 * 
	 */
		private static final long					serialVersionUID	= 1L;
		private JSplitPane												jspTest;
		private InLabTestUI											iltuiTest;
		private EffectUI														euiDownstreamEffect;
		private TestResponseMappingUI	trmuiTestResponseMapping;
		private JSplitPane												jspEffect;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new EditTestResponceMappingUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public EditTestResponceMappingUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("test_response_mapping");
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
								jspTest = new JSplitPane();
								this.add(jspTest, BorderLayout.CENTER);
								jspTest.setOneTouchExpandable(true);
								jspTest.setResizeWeight(0.33);
									{
										iltuiTest = new InLabTestUI();
										jspTest.add(iltuiTest, JSplitPane.LEFT);
										iltuiTest.setPreferredSize(new java.awt.Dimension(200, 300));
										iltuiTest.setMinimumSize(new java.awt.Dimension(50, 300));
										iltuiTest.setHeaderAllowRedirecting(true);
									}
									{
										jspEffect = new JSplitPane();
										jspEffect.setOneTouchExpandable(true);
										jspEffect.setResizeWeight(0.5);
										jspTest.add(jspEffect, JSplitPane.RIGHT);
											{
												trmuiTestResponseMapping = new TestResponseMappingUI();
												jspEffect.add(trmuiTestResponseMapping, JSplitPane.LEFT);
												trmuiTestResponseMapping.setPreferredSize(new java.awt.Dimension(200, 300));
												trmuiTestResponseMapping.setMinimumSize(new java.awt.Dimension(50, 300));
											}
											{
												euiDownstreamEffect = new EffectUI("Associated (key) event / effect");
												jspEffect.add(euiDownstreamEffect, JSplitPane.RIGHT);
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
				if (!(o instanceof TestResponseMapping))
					return;
				TestResponseMapping trm = (TestResponseMapping) o;
				EffectopediaObject eo = trm.getTest().getCachedObject();
				iltuiTest.load(eo, (eo != null) ? eo.isReadonly() : true);
				eo = trm.getEffect().getCachedObject();
				euiDownstreamEffect.load(eo, (eo != null) ? eo.isReadonly() : true);
				trmuiTestResponseMapping.load(trm, readonly);
			}
		
	}

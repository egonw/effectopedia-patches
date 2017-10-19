package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Effect_AdverseOutcome;
import org.qsari.effectopedia.core.objects.Effect_DownstreamEffect;
import org.qsari.effectopedia.core.objects.Effect_Endpoint;
import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.Link_ChemStructToChemStruct;
import org.qsari.effectopedia.core.objects.Link_ChemStructToMIE;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.objects.Test;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.core.objects.Test_ExVivo;
import org.qsari.effectopedia.core.objects.Test_InChemico;
import org.qsari.effectopedia.core.objects.Test_InSilico;
import org.qsari.effectopedia.core.objects.Test_InVitro;
import org.qsari.effectopedia.core.objects.Test_InVivo;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.im.InterfaceMode;

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
public class ElementEditorUI extends javax.swing.JScrollPane implements ChangeListener, Runnable
	{
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new ElementEditorUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
				frame.getContentPane().setBackground(Color.WHITE);
			}
			
		public ElementEditorUI()
			{
				super();
				setName("element_editor");
				initGUI();
			}
			
		private void initGUI()
			{
				try
					{
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
			
		public void load(Object o, boolean readonly)
			{
				if ((o != null) && (o instanceof EffectopediaObject))
					{
						if (editor instanceof JScrollPane)
							((JScrollPane) editor).getViewport().removeChangeListener(this);
						if (o instanceof PathwayElement)
							if (((PathwayElement) o).isGeneric())
								{
									// TODO Show Existing element selector
									if (o instanceof Effect)
										{
											ExistingEffectPanel.PANEL.setElementEditor(this);
											ExistingEffectPanel.PANEL.setPreferredSize(optimalSize);
											if (ExistingEffectPanel.PANEL.hasSuggestions(o))
												{
													ExistingEffectPanel.PANEL.setInterfaceMode(interfaceMode);
													ExistingEffectPanel.PANEL.load(o, readonly);
													this.setViewportView(ExistingEffectPanel.PANEL);
													editor = ExistingEffectPanel.PANEL;
													return;
												}
										}
									if (o instanceof Test)
										{
											ExistingTestPanel.PANEL.setElementEditor(this);
											ExistingTestPanel.PANEL.setPreferredSize(optimalSize);
											if (ExistingTestPanel.PANEL.hasSuggestions(o))
												{
													ExistingTestPanel.PANEL.setInterfaceMode(interfaceMode);
													ExistingTestPanel.PANEL.load(o, readonly);
													this.setViewportView(ExistingTestPanel.PANEL);
													editor = ExistingTestPanel.PANEL;
													return;
												}
										}
									/*
									 * if (!((o instanceof Link)||(o instanceof TestResponseMapping))) {
									 * this.setViewportView(null); editor = null; return; }
									 */
								}
						defineNew(o, readonly);
					}
				else
					this.setViewportView(null);
			}
			
		protected void defineNew(Object o, boolean readonly)
			{
				editor = EDITORS.get(o.getClass());
				
				this.setViewportView(editor);
				if (editor instanceof LoadableEditorUI)
					{
						// if (editor instanceof AdjustableUI)
						// ((AdjustableUI) editor).adjustUI(AdjustableUI.EDIT);
						((LoadableEditorUI) editor).load(o, readonly);
					}
				if (editor instanceof JScrollPane)
					{
						((JScrollPane) editor).getViewport().addChangeListener(this);
						((JScrollPane) editor).setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
						((JScrollPane) editor).setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
					}
					
			}
			
		public void stateChanged(ChangeEvent arg0)
			{
				if (pendingUpdate)
					return;
				SwingUtilities.invokeLater(this);
				pendingUpdate = true;
			}
			
		@Override
		public void run()
			{
				if (editor != null)
					editor.setSize(editor.getPreferredSize());
				pendingUpdate = false;
			}
			
		public InterfaceMode getInterfaceMode()
			{
				return interfaceMode;
			}
			
		public void setInterfaceMode(InterfaceMode interfaceMode)
			{
				this.interfaceMode = interfaceMode;
			}
			
		private boolean																																																													pendingUpdate										= false;
		private Component																																																											editor																	= null;
		private Dimension																																																											optimalSize												= new Dimension(400, 800);
		private InterfaceMode																																																							interfaceMode;
		public final static boolean																																																	headerAllowRedirecting	= false;
		public static final HashMap<Class<? extends EffectopediaObject>, Component>	EDITORS																= new HashMap<Class<? extends EffectopediaObject>, Component>();
		static
			{
				InLabTestUI inLabTestUI = (InLabTestUI) new InLabTestUI().setHeaderAllowRedirecting(headerAllowRedirecting);
				EDITORS.put(Test_InChemico.class, inLabTestUI);
				EDITORS.put(Test_InVitro.class, inLabTestUI);
				EDITORS.put(Test_ExVivo.class, inLabTestUI);
				EDITORS.put(Test_InVivo.class, inLabTestUI);
				EDITORS.put(Test_InSilico.class, new InSilicoTestUI());
				EDITORS.put(Link_EffectToEffect.class, new Link_EffectToEffectUI());
				EDITORS.put(Link_ChemStructToMIE.class, new Link_SubstanceToMIEUI());
				EDITORS.put(Link_ChemStructToChemStruct.class, new Link_SubstanceToReactiveSubstanceUI());
				EDITORS.put(TestResponseMapping.class, new TestResponseMappingUI());
				EffectUI effectUI = new EffectUI();
				effectUI.setHeaderAllowRedirecting(headerAllowRedirecting	);
				EDITORS.put(Effect.class, effectUI);
				EDITORS.put(Effect_MolecularInitiatingEvent.class, effectUI);
				EDITORS.put(Effect_DownstreamEffect.class, effectUI);
				EDITORS.put(Effect_Endpoint.class, effectUI);
				EDITORS.put(Effect_AdverseOutcome.class, effectUI);
				EDITORS.put(Pathway.class, (EditPathwayUI) new EditPathwayUI().setHeaderAllowRedirecting(true));
				EDITORS.put(Initiator_ChemicalStructure.class, new ChemicalUI());
			}
			
	}
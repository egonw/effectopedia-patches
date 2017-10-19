package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.core.GUIFactory;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContextScrollPane;
import org.qsari.effectopedia.gui.obj_prop.QualityAssuranceUI;
import org.qsari.effectopedia.gui.obj_prop.StateUI;
import org.qsari.effectopedia.system.TraceableClasses;
import org.qsari.effectopedia.utils.StringCaseUtil;

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
public class EffectUI extends RootHelpContextScrollPane implements AdjustableUI, LoadableEditorUI, ComponentListener, InitializableUI
	{
		/**
		* 
		*/
		private static final long											serialVersionUID	= 1207971105123532796L;
		private EffectHeaderUI														ehuiHeader;
		private QualityAssuranceUI										qauiQualityAssurance;
		private ReferencesUI																ruiReferences;
		private ContextUI																			cuiContext;
		private PathwaysListUI														pluiAssociatedPathways;
		private DescriptionUI															duiDescription;
		private StateUI																					suiState;
		private MappedPathwayElementsListUI	mpeluiRelatedTests;
		private String																						effectCaption;
		private TitledBorder																titledBorder;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new EffectUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public EffectUI()
			{
				super();
				this.effectCaption = "(Key) Event";
				initGUI();
				adjustUI(EDIT);
			}
			
		public EffectUI(String effectCaption)
			{
				super();
				this.effectCaption = effectCaption;
				initGUI();
				adjustUI(VIEW);
			}
			
		private void initGUI()
			{
				try
					{
						setPreferredSize(optimalSize);
						this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
						this.setBackground(Color.WHITE);
						cspEditPanel = new ContextSensitivePanel(rootHelpContext);
						cspEditPanel.setName("effect");
						
						cspEditPanel.setPreferredSize(new java.awt.Dimension(400, 1000));
						this.setViewportView(cspEditPanel);
						BoxLayout thisLayout = new BoxLayout(cspEditPanel, javax.swing.BoxLayout.Y_AXIS);
						titledBorder = BorderFactory.createTitledBorder(new LineBorder(DefaultGOSettings.effectColor, 2, true), effectCaption, TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
								new java.awt.Font("Segoe UI", 1, 12), DefaultGOSettings.effectColor);
						cspEditPanel.setBorder(titledBorder);
						cspEditPanel.setLayout(thisLayout);
						cspEditPanel.setBackground(Color.WHITE);
							{
								ehuiHeader = new EffectHeaderUI(rootHelpContext);
								cspEditPanel.add(ehuiHeader);
								ehuiHeader.setPreferredSize(new java.awt.Dimension(388, 49));
								ehuiHeader.setBackground(Color.WHITE);
							}
							{
								qauiQualityAssurance = new QualityAssuranceUI(rootHelpContext);
								cspEditPanel.add(qauiQualityAssurance);
							}
							{
								duiDescription = new DescriptionUI(rootHelpContext);
								cspEditPanel.add(duiDescription);
								duiDescription.setPreferredSize(new java.awt.Dimension(388, 93));
							}
							{
								suiState = new StateUI("Response", rootHelpContext);
								cspEditPanel.add(suiState);
							}
							
							{
								cuiContext = new ContextUI(rootHelpContext);
								cspEditPanel.add(cuiContext);
								cuiContext.setPreferredSize(new java.awt.Dimension(388, 77));
							}
							{
								mpeluiRelatedTests = new MappedPathwayElementsListUI(false, rootHelpContext);
								cspEditPanel.add(mpeluiRelatedTests);
							}
							{
								pluiAssociatedPathways = new PathwaysListUI(rootHelpContext);
								cspEditPanel.add(pluiAssociatedPathways);
							}
							{
								ruiReferences = new ReferencesUI(rootHelpContext);
								cspEditPanel.add(ruiReferences);
								ruiReferences.setPreferredSize(new java.awt.Dimension(388, 90));
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
				effect = (Effect) o;
				readonly = readonly || effect.isReadonly();
				ruiReferences.load(effect.getReferenceIDs(), readonly);
				mpeluiRelatedTests.load(effect.getRelatedTestMappingIDs(), readonly);
				pluiAssociatedPathways.load(effect.getPathwayIDs(), readonly);
				cuiContext.load(effect.getCoordinates(), readonly);
				suiState.load(effect.getResponseAggregationFn(), readonly);
				duiDescription.load(effect.getDescriptionIDs(), readonly);
				qauiQualityAssurance.load(effect.getQA(), readonly);
				ehuiHeader.load(effect, readonly);
				effectCaption = StringCaseUtil.TitleCase(TraceableClasses.REGISTERED.getDescription(effect.getClass()));
				titledBorder.setTitle((readonly) ? effectCaption + " - read only " : effectCaption);
				updateOptimalSize();
				initializeUI();
			}
			
		private Effect effect;
		
		@Override
		public void componentHidden(ComponentEvent e)
			{
				
			}
			
		@Override
		public void componentMoved(ComponentEvent e)
			{
				
			}
			
		@Override
		public void componentResized(ComponentEvent e)
			{
				cspEditPanel.setPreferredSize(new Dimension((int) this.getVisibleRect().getWidth(), 800));
			}
			
		@Override
		public void componentShown(ComponentEvent e)
			{
				
			}
			
		public void updateOptimalSize()
			{
				Component focused = GUIFactory.GUI.getFrame().getFocusOwner();
				Insets insets = getBorder().getBorderInsets(this);
				optimalSize.width = getWidth();
				optimalSize.width -= this.getVerticalScrollBar().isVisible() ? this.getVerticalScrollBar().getPreferredSize().width + 2 : 2;
				optimalSize.height = ehuiHeader.getPreferredSize().height + qauiQualityAssurance.getPreferredSize().height + ruiReferences.getPreferredSize().height + cuiContext.getPreferredSize().height
						+ mpeluiRelatedTests.getPreferredSize().height + pluiAssociatedPathways.getPreferredSize().height + duiDescription.getPreferredSize().height + suiState.getPreferredSize().height;
				optimalSize.height += insets.top + insets.bottom;
				cspEditPanel.setPreferredSize(optimalSize);
				this.getViewport().revalidate();
				if (focused != null)
					this.getViewport().scrollRectToVisible(focused.getBounds());
				Container parent = getParent();
				if ((parent != null) && (parent instanceof SizeOptimizableUI))
					((SizeOptimizableUI) parent).updateOptimalSize();
				else
					invalidate();
			}
			
		public void initializeUI()
			{
				qauiQualityAssurance.initializeUI();
				duiDescription.initializeUI();
				cuiContext.initializeUI();
				ruiReferences.initializeUI();
				ehuiHeader.initializeUI();
			}
			
		public EffectUI setHeaderAllowRedirecting(boolean allow)
			{
				ehuiHeader.setAllowRedirecting(allow);
				return this;
			}
			
		private Dimension									optimalSize	= new Dimension(400, 1000);

		
	}

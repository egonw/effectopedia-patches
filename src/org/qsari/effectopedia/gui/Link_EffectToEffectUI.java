package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.core.objects.Link.LinkNature;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship;
import org.qsari.effectopedia.data.quantification.FunctionalRelationships;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.LinkHeaderUI.LinkTypeChange;
import org.qsari.effectopedia.gui.LinkHeaderUI.LinkTypeChangeListener;
import org.qsari.effectopedia.gui.core.GUIFactory;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContextScrollPane;
import org.qsari.effectopedia.gui.obj_prop.NonlinearSeriesListUI;
import org.qsari.effectopedia.gui.obj_prop.QualityAssuranceUI;
import org.qsari.effectopedia.gui.obj_prop.QuantitativeRelationshipListUI;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI.ListEditorActionListener;

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
public class Link_EffectToEffectUI extends RootHelpContextScrollPane implements AdjustableUI, LoadableEditorUI, InitializableUI, LinkTypeChangeListener, ListEditorActionListener
	{
		/**
	 * 
	 */
		private static final long														serialVersionUID	= 1L;
		private LinkHeaderUI																			lhuiHeader;
		private QualityAssuranceUI													qauiQualityAssurance;
		private DescriptionUI																		duiDescription;
		private PathwaysListUI																	pluiAssociatedPathways;
		private ReferencesUI																			ruiReferences;
		private BoxLayout																						thisLayout;
		private NonlinearSeriesListUI										nsluiTemporalConcordance;
		private QuantitativeRelationshipListUI	qrluiQuantitaitveRelationships;
		private EffectopediaObjectListUI							eoluiModifyingFactors;
		
		// private QuantitativeRelationship_NonlinearUI qrnluiResponseResponse;
		// private QuantitativeRelationship_AnalyticUI qraLinearDependency;
		// private QuantitativeRelationship_AnalyticUI qraThresholdValue;
		private TitledBorder																			titledBorder;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new Link_EffectToEffectUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public Link_EffectToEffectUI()
			{
				super();
				initGUI();
				adjustUI(EDIT);
			}
		
		private void initGUI()
			{
				try
					{
						cspEditPanel = new ContextSensitivePanel(rootHelpContext);
						cspEditPanel.setPreferredSize(optimalSize);
						cspEditPanel.setName("link_e2e");
						
						this.setViewportView(cspEditPanel);
						thisLayout = new BoxLayout(cspEditPanel, javax.swing.BoxLayout.Y_AXIS);
						cspEditPanel.setLayout(thisLayout);
						titledBorder = BorderFactory.createTitledBorder(new LineBorder(DefaultGOSettings.linkColor, 2, false), "(Key) event relationship", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
								new java.awt.Font("Segoe UI", 1, 12), DefaultGOSettings.linkColor);
						cspEditPanel.setBorder(titledBorder);
						cspEditPanel.setBackground(Color.WHITE);
							{
								lhuiHeader = new LinkHeaderUI(rootHelpContext);
								cspEditPanel.add(lhuiHeader);
								lhuiHeader.setPreferredSize(new java.awt.Dimension(388, 41));
								lhuiHeader.addLinkTypeChangeListener(this);
							}
							{
								qauiQualityAssurance = new QualityAssuranceUI(rootHelpContext);
								cspEditPanel.add(qauiQualityAssurance);
							}
							{
								duiDescription = new DescriptionUI(rootHelpContext);
								cspEditPanel.add(duiDescription);
							}
							{
								eoluiModifyingFactors = new EffectopediaObjectListUI("Modifying Factors", "modifying factor",rootHelpContext);
								eoluiModifyingFactors.setName("modifying_factors");
								cspEditPanel.add(eoluiModifyingFactors);
							}
							{
								nsluiTemporalConcordance = new NonlinearSeriesListUI("Temporal concordance",rootHelpContext);
								nsluiTemporalConcordance.getListEditorUI().addListEditorActionListener(this);
								nsluiTemporalConcordance.setName("temporal_concordance");
								cspEditPanel.add(nsluiTemporalConcordance);
							}
							{
								qrluiQuantitaitveRelationships = new QuantitativeRelationshipListUI(rootHelpContext);
								qrluiQuantitaitveRelationships.setName("response_response");
								cspEditPanel.add(qrluiQuantitaitveRelationships);
							}
							{
								pluiAssociatedPathways = new PathwaysListUI(rootHelpContext);
								cspEditPanel.add(pluiAssociatedPathways);
							}
							{
								ruiReferences = new ReferencesUI(rootHelpContext);
								cspEditPanel.add(ruiReferences);
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
				if ((visualOptions & HEADER) != 0)
					{
						setVisible(true);
						this.setBackground(Color.WHITE);
						AdjustbleUserInterfaceTools.adjustChildren(this, visualOptions);
					}
				else
					{
						setVisible(false);
					}
			}
		
		public void LinkTypeChanged(LinkTypeChange evt)
			{
				if (evt.getSource() instanceof LinkHeaderUI)
					{
						LinkNature linkNature = ((LinkHeaderUI) evt.getSource()).getLinkNature();
						updateLinkNatureInterface(linkNature);
						updateQuantitiveRelationships(link, lhuiHeader.getLinkNature());
						link.setLinkNature(linkNature);
						load(link, this.readonly);
					}
			}
		
		public void updateLinkNatureInterface(LinkNature linkType)
			{
				qrluiQuantitaitveRelationships.setVisible(linkType.equals(LinkNature.RESPONSE_RESPONSE) || linkType.equals(LinkNature.LINEAR) || linkType.equals(LinkNature.THRESHOLD));
			}
		
		public void updateQuantitiveRelationship(Link_EffectToEffect link, LinkNature linkNature)
			{
				if (link != null)
					{
						FunctionalRelationship qr = link.getQuantitativeRelationship();
						qr = qrluiQuantitaitveRelationships.updateLinkNature(link, linkNature, qr);
						link.setQuantitativeRelationship(qr);
					}
			}
		
		public void updateQuantitiveRelationships(Link_EffectToEffect link, LinkNature linkNature)
			{
				if (link != null)
					{
						FunctionalRelationships fnRels = link.getQuantitativeRelationships();
						if (fnRels != null)
							for (int i = fnRels.size() - 1; i >= 0; i--)
								fnRels.set(i, qrluiQuantitaitveRelationships.updateLinkNature(link, linkNature, fnRels.get(i)));
					}
			}
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof Link_EffectToEffect))
					return;
				link = (Link_EffectToEffect) o;
				readonly = readonly || link.isReadonly();
				this.readonly = readonly;
				lhuiHeader.load(link, readonly);
				updateLinkNatureInterface(link.getLinkNature());
				qauiQualityAssurance.load(link.getQA(), readonly);
				ruiReferences.load(link.getReferenceIDs(), readonly);
				duiDescription.load(link.getDescriptionIDs(), readonly);
				eoluiModifyingFactors.load(link.getModifyingFactors().getObjectIDs(), readonly);
				pluiAssociatedPathways.load(link.getPathwayIDs(), readonly);
				updateQuantitiveRelationship(link, lhuiHeader.getLinkNature());
				qrluiQuantitaitveRelationships.load(link.getQuantitativeRelationships(), readonly);
				nsluiTemporalConcordance.load(link.getTemporalConcordances(), readonly);
				titledBorder.setTitle((readonly) ? "Link - read only " : "Link");
				updateOptimalSize();
			}
		
		public void updateOptimalSize()
			{
				Component focused = GUIFactory.GUI.getFrame().getFocusOwner();
				Insets insets = getBorder().getBorderInsets(this);
				optimalSize.width = getWidth();
				optimalSize.width -= this.getVerticalScrollBar().isVisible() ? this.getVerticalScrollBar().getPreferredSize().width + 4 : 4;
				optimalSize.height = lhuiHeader.getPreferredSize().height + qauiQualityAssurance.getPreferredSize().height + ruiReferences.getPreferredSize().height
						+ pluiAssociatedPathways.getPreferredSize().height + duiDescription.getPreferredSize().height + nsluiTemporalConcordance.getPreferredSize().height
						+ eoluiModifyingFactors.getPreferredSize().height;
				if (qrluiQuantitaitveRelationships.isVisible())
					optimalSize.height += qrluiQuantitaitveRelationships.getPreferredSize().height;
				optimalSize.height += insets.top + insets.bottom + 120;
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
		
		@Override
		public int listEditorActionPerformed(int actionCode)
			{
				if ((actionCode == ListEditorToolbarUI.ADD) && (link.getTemporalConcordances() == null))
					{
						link.setTemporalConcordances(new FunctionalRelationships(link));
						nsluiTemporalConcordance.load(link.getTemporalConcordances(), readonly);
					}
				return actionCode;
			}
		
		public Link_EffectToEffectUI setHeaderAllowRedirecting(boolean allow)
			{
				lhuiHeader.setAllowRedirecting(allow);
				return this;
			}
		
		@Override
		public void initializeUI()
			{
				qauiQualityAssurance.initializeUI();
				ruiReferences.initializeUI();
				duiDescription.initializeUI();
				qrluiQuantitaitveRelationships.initializeUI();
				nsluiTemporalConcordance.initializeUI();
				lhuiHeader.initializeUI();
			}

		private Link_EffectToEffect	link;
		private boolean													readonly				= false;
		private Dimension											optimalSize	= new Dimension(400, 1000);
	}

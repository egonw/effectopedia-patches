package org.qsari.effectopedia.gui.obj_prop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.objects.Link.LinkNature;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.data.quantification.DataTemplates;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship.EvidenceType;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship_Linear;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship_Nonlinear;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship_Threshold;
import org.qsari.effectopedia.data.quantification.FunctionalRelationships;
import org.qsari.effectopedia.gui.AdjustableUI;
import org.qsari.effectopedia.gui.AdjustbleUserInterfaceTools;
import org.qsari.effectopedia.gui.InitializableUI;
import org.qsari.effectopedia.gui.SizeOptimizableUI;
import org.qsari.effectopedia.gui.comp.CollapsableTitledPanel;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI;

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
 * @version 1 @(#)InvestigationListUI.java 1.0
 * @author Hristo Aladjov
 */

public class QuantitativeRelationshipListUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, InitializableUI
	{
		/**
		 * 
		 */
		private static final long											serialVersionUID	= 1L;
		
		private ListEditorToolbarUI									letuiQuantitativeRelationships;
		
		private QuantitativeRelationshipsUI	qruiQuantitativeRelationships;
		
		public static class EvidenceBasedFunctionalRelationshipUI extends CollapsableTitledPanel
			{
				
				/**
				* 
				*/
				private static final long										serialVersionUID		= 1L;
				private static final int											defaultItemHeight	= 360;
				private final EvidenceBasedFnRelUI	ebfruiFnRelUI;
				
				public EvidenceBasedFunctionalRelationshipUI(RootHelpContext rootHelpContext)
					{
						super(new EvidenceBasedFnRelUI(rootHelpContext), null, true, rootHelpContext);
						ebfruiFnRelUI = (EvidenceBasedFnRelUI) getBodyPanel();
						setAllowRedirecting(true);
						setAllowHTMLContent(false);
						setPreferredHeight(defaultItemHeight);
					}
					
				public void load(Object o, boolean readonly)
					{
						if (!(o instanceof FunctionalRelationship))
							return;
						this.eo = ((FunctionalRelationship) o).getOwner();
						this.defaultObject = eo.isDefaultID();
						readonly = readonly || eo.isReadonly();
						loadTitle(o, readonly);
						loadContent((FunctionalRelationship) o, readonly);
					}
					
			}
			
		/**
		 * 
		 */
		public class QuantitativeRelationshipsUI extends FunctionalRelationshipsUI<CollapsableTitledPanel>
			{
				
				/**
				* 
				*/
				private static final long serialVersionUID = 1L;
				
				public QuantitativeRelationshipsUI(RootHelpContext rootHelpContext)
					{
						super(rootHelpContext);
						setName("list");
					}
					
				public CollapsableTitledPanel add(boolean enableSelectionDialog)
					{
						if (fnRels == null)
							return null;
						CollapsableTitledPanel newQRUI = new EvidenceBasedFunctionalRelationshipUI(QuantitativeRelationshipListUI.this.rootHelpContext);
						qruiQuantitativeRelationships.add(newQRUI);
						return newQRUI;
					}
					
				@Override
				public FunctionalRelationship updateFnRel(EffectopediaObject owner, LinkNature linkNature, FunctionalRelationship fnRel)
					{
						if ((linkNature.equals(LinkNature.THRESHOLD)) && ((fnRel == null) || !(fnRel instanceof FunctionalRelationship_Threshold)))
							fnRel = new FunctionalRelationship_Threshold(owner);
						if ((linkNature.equals(LinkNature.RESPONSE_RESPONSE)) && ((fnRel == null) || !(fnRel instanceof FunctionalRelationship_Nonlinear)))
							fnRel = new FunctionalRelationship_Nonlinear(owner, FunctionalRelationship_Nonlinear.RESPONSE_RESPONSE);
						if ((linkNature.equals(LinkNature.LINEAR)) && ((fnRel == null) || !(fnRel instanceof FunctionalRelationship_Linear)))
							fnRel = new FunctionalRelationship_Linear(owner, false);
						if ((linkNature.equals(LinkNature.HARDWIRE)) && ((fnRel == null) || !(fnRel instanceof FunctionalRelationship_Linear)))
							fnRel = new FunctionalRelationship_Linear(owner, true);
						if (fnRel != null)
							fnRel.setEvidenceType(EvidenceType.EXPERIMENTAL_DATA);
						return fnRel;
					}
					
				@Override
				public FunctionalRelationship generateDefaultTitlesIfNeeded(Link_EffectToEffect link, FunctionalRelationship fnRel)
					{
						if ((link == null) || fnRel == null)
							return null;
						DataTemplates templates = fnRel.getTemplates();
						String xAxisTitle = templates.getxAxisTitle();
						String yAxisTitle = templates.getyPrimaryAxisTitle();
						String chartTitle = templates.getChartTitle();
						if (((xAxisTitle == null) || (xAxisTitle.length() == 0)))
							templates.setxAxisTitle(link.getFromEffect().getCachedObject().getTitle());
						if (((yAxisTitle == null) || (yAxisTitle.length() == 0)))
							templates.setyPrimaryAxisTitle(link.getToEffect().getCachedObject().getTitle());
						if ((((chartTitle == null) || (chartTitle.length() == 0))) && (templates.getOwner() != null))
							templates.setChartTitle(link.getLinkNature().toString() + " relationship describing: " + link.getDescriptiveTitle());
						return fnRel;
					}
					
			}
			
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new QuantitativeRelationshipListUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public QuantitativeRelationshipListUI(RootHelpContext rootHelpContext)
				{
				super(rootHelpContext);
				initGUI();
				adjustUI(EDIT);
			}
			
		public FunctionalRelationship updateLinkNature(EffectopediaObject owner, LinkNature linkNature, FunctionalRelationship fnRel)
			{
				fnRel = qruiQuantitativeRelationships.updateFnRel(owner, linkNature, fnRel);
				fnRel = qruiQuantitativeRelationships.generateDefaultTitlesIfNeeded((Link_EffectToEffect) owner, fnRel);
				return fnRel;
			}
			
		private void initGUI()
			{
				try
					{
						setPreferredSize(optimalSize);
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBorder(BorderFactory.createTitledBorder(null, "Quantitative Relationship(s)", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12)));
						this.setBackground(Color.WHITE);
							{
								qruiQuantitativeRelationships = new QuantitativeRelationshipsUI(rootHelpContext);
								this.add(qruiQuantitativeRelationships, BorderLayout.CENTER);
								qruiQuantitativeRelationships.setBackground(Color.WHITE);
								qruiQuantitativeRelationships.add(false);
							}
							{
								letuiQuantitativeRelationships = new ListEditorToolbarUI(qruiQuantitativeRelationships, "quantitative relationship", ListEditorToolbarUI.DEFAULT, FlowLayout.RIGHT);
								this.add(letuiQuantitativeRelationships, BorderLayout.SOUTH);
								letuiQuantitativeRelationships.setVisible(true);
							}
							RootHelpContext.addMouseMotionListeners(this, rootHelpContext,false);
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
				if ((o == null) || !(o instanceof FunctionalRelationships))
					{
						fnRels = null;
						qruiQuantitativeRelationships.setFunctionalRelationships(null, true);
						return;
					}
				fnRels = (FunctionalRelationships) o;
				qruiQuantitativeRelationships.setFunctionalRelationships(fnRels, readonly);
				letuiQuantitativeRelationships.updateEditButtons(readonly);
			}
			
		public void updateOptimalSize()
			{
				optimalSize.width = qruiQuantitativeRelationships.getWidth();
				optimalSize.height = qruiQuantitativeRelationships.getPreferredSize().height + ((letuiQuantitativeRelationships != null) ? letuiQuantitativeRelationships.getPreferredSize().height : 0);
				setSize(optimalSize);
				setPreferredSize(optimalSize);
				Container parent = getParent();
				while (parent != null)
					{
						if (parent instanceof SizeOptimizableUI)
							{
								((SizeOptimizableUI) parent).updateOptimalSize();
								break;
							}
						parent = parent.getParent();
					}
			}
			
		public void initializeUI()
			{
				qruiQuantitativeRelationships.initializeUI();
			}
			
		private Dimension															optimalSize	= new Dimension(400, 400);
		private FunctionalRelationships	fnRels						= null;
	}
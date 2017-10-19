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
import org.qsari.effectopedia.data.quantification.FunctionalRelationship_Analytic;
import org.qsari.effectopedia.data.quantification.FunctionalRelationships;
import org.qsari.effectopedia.data.quantification.TransformationFunctionType;
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

public class TransformationFunctionsListUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, InitializableUI
	{
		/**
		 * 
		 */
		private static final long									serialVersionUID	= 1L;
		
		private ListEditorToolbarUI							letuiTransformationFunctions;
		
		private TransformationFunctionsUI	tfuiTransformationFunctions;
		
		public static class TransFunctionUI extends CollapsableTitledPanel
			{
				
				/**
				* 
				*/
				private static final long													serialVersionUID		= 1L;
				private static final int														defaultItemHeight	= 360;
				public final TransformationFunctionUI	tfuiTransformationFunctionUI;
				
				public TransFunctionUI(TransformationFunctionsListUI parentListUI, RootHelpContext rootHelpContext)
					{
						super(new TransformationFunctionUI(rootHelpContext), null, true, rootHelpContext);
						tfuiTransformationFunctionUI = (TransformationFunctionUI) getBodyPanel();
						tfuiTransformationFunctionUI.setParentListUI(parentListUI);
						setAllowRedirecting(false);
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
		public class TransformationFunctionsUI extends FunctionalRelationshipsUI<CollapsableTitledPanel>
			{
				
				/**
				* 
				*/
				private static final long serialVersionUID = 1L;
				
				public TransformationFunctionsUI(RootHelpContext rootHelpContext)
					{
						super(rootHelpContext);
					}
					
				public CollapsableTitledPanel add(boolean enableSelectionDialog)
					{
						if (fnRels == null)
							return null;
						CollapsableTitledPanel newQRUI = new TransFunctionUI(TransformationFunctionsListUI.this, TransformationFunctionsListUI.this.rootHelpContext);
						tfuiTransformationFunctions.add(newQRUI);
						return newQRUI;
					}
					
				@Override
				public FunctionalRelationship updateFnRel(EffectopediaObject owner, LinkNature linkNature, FunctionalRelationship fnRel)
					{
						if ((fnRel == null) || !(fnRel instanceof FunctionalRelationship_Analytic))
							fnRel = new FunctionalRelationship_Analytic(owner);
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
							templates.setChartTitle("Transformation function ");
						return fnRel;
					}
					
				@Override
				public FunctionalRelationship generateDefaultTitlesIfNeeded(FunctionalRelationship fnRel)
					{
						if (fnRel == null)
							return null;
						if (fnRel.getTransformationType().equals(TransformationFunctionType.NONE))
							return fnRel;
						DataTemplates templates = fnRel.getTemplates();
						String xAxisTitle = templates.getxAxisTitle();
						String yAxisTitle = templates.getyPrimaryAxisTitle();
						String chartTitle = templates.getChartTitle();
						String variable = fnRel.getTransformationType().toString();
						if (((xAxisTitle == null) || (xAxisTitle.length() == 0)))
							templates.setxAxisTitle("Test " + variable);
						if (((yAxisTitle == null) || (yAxisTitle.length() == 0)))
							templates.setyPrimaryAxisTitle("In-vivo " + variable);
						if ((((chartTitle == null) || (chartTitle.length() == 0))) && (templates.getOwner() != null))
							templates.setChartTitle(variable + " Transformation");
						return fnRel;
					}
			}
			
		public FunctionalRelationship generateDefaultTitles(FunctionalRelationship fnRel)
			{
				if (fnRel == null)
					return null;
				if (fnRel.getTransformationType().equals(TransformationFunctionType.NONE))
					return fnRel;
				DataTemplates templates = fnRel.getTemplates();
				String variable = fnRel.getTransformationType().toString();
				templates.setxAxisTitle("Test " + variable);
				templates.setyPrimaryAxisTitle("In-vivo " + variable);
				templates.setChartTitle(variable + " Transformation");
				return fnRel;
			}
			
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new TransformationFunctionsListUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public TransformationFunctionsListUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				initGUI();
				adjustUI(EDIT);
			}
			
		public FunctionalRelationship updateLinkNature(EffectopediaObject owner, LinkNature linkNature, FunctionalRelationship fnRel)
			{
				fnRel = tfuiTransformationFunctions.updateFnRel(owner, linkNature, fnRel);
				fnRel = tfuiTransformationFunctions.generateDefaultTitlesIfNeeded((Link_EffectToEffect) owner, fnRel);
				return fnRel;
			}
			
		private void initGUI()
			{
				try
					{
						setPreferredSize(optimalSize);
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBorder(BorderFactory.createTitledBorder(null, "Transformation Function(s)", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12)));
						this.setBackground(Color.WHITE);
							{
								tfuiTransformationFunctions = new TransformationFunctionsUI(rootHelpContext);
								this.add(tfuiTransformationFunctions, BorderLayout.CENTER);
								tfuiTransformationFunctions.setBackground(Color.WHITE);
							}
							{
								letuiTransformationFunctions = new ListEditorToolbarUI(tfuiTransformationFunctions, "transformation function", ListEditorToolbarUI.DEFAULT, FlowLayout.RIGHT);
								this.add(letuiTransformationFunctions, BorderLayout.SOUTH);
								letuiTransformationFunctions.setVisible(true);
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
				if ((o == null) || !(o instanceof FunctionalRelationships))
					{
						fnRels = null;
						tfuiTransformationFunctions.setFunctionalRelationships(null, true);
						return;
					}
				fnRels = (FunctionalRelationships) o;
				tfuiTransformationFunctions.setFunctionalRelationships(fnRels, readonly);
				letuiTransformationFunctions.updateEditButtons(readonly);
			}
			
		public void updateOptimalSize()
			{
				optimalSize.width = tfuiTransformationFunctions.getWidth();
				optimalSize.height = tfuiTransformationFunctions.getPreferredSize().height + ((letuiTransformationFunctions != null) ? letuiTransformationFunctions.getPreferredSize().height : 0);
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
			
		public ListEditorToolbarUI getListEditorUI()
			{
				return letuiTransformationFunctions;
			}
			
		public void initializeUI()
			{
				tfuiTransformationFunctions.initializeUI();
			}
			
		private Dimension															optimalSize	= new Dimension(400, 400);
		private FunctionalRelationships	fnRels						= null;
	}
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
import org.qsari.effectopedia.data.quantification.FunctionalRelationship_Nonlinear;
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

public class NonlinearSeriesListUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, InitializableUI
	{
		/**
		 * 
		 */
		private static final long									serialVersionUID	= 1L;
		
		private ListEditorToolbarUI							letuiNonlinearSeries;
		
		private NonlinearDataSeriesListUI	ndsuiNonlinearDataSeriesList;
		
		public static class NonlinearDataSeriesUI extends CollapsableTitledPanel
			{
				
				/**
		 * 
		 */
				private static final long	serialVersionUID		= 1L;
				private static final int		defaultItemHeight	= 360;
				
				public NonlinearDataSeriesUI(RootHelpContext rootHelpContext)
					{
						super(new QuantitativeRelationship_NonlinearUI(rootHelpContext), null, true,rootHelpContext);
						setAllowRedirecting(false);
						setAllowHTMLContent(false);
						setPreferredHeight(defaultItemHeight);
					}
				
				public void load(Object o, boolean readonly)
					{
						DataTemplates dt;
						if (o instanceof DataTemplates)
							dt = ((DataTemplates) o);
						else if (o instanceof FunctionalRelationship_Nonlinear)
							dt = ((FunctionalRelationship_Nonlinear) o).getTemplates();
						else
							return;
						this.eo = dt.getOwner();
						this.defaultObject = eo.isDefaultID();
						readonly = readonly || eo.isReadonly();
						loadTitle(o, readonly);
						loadContent(dt, readonly);
					}
				
			}
		
		/**
		 * 
		 */
		/**
		 * 
		 */
		public class NonlinearDataSeriesListUI extends FunctionalRelationshipsUI<CollapsableTitledPanel>
			{
				public NonlinearDataSeriesListUI(RootHelpContext rootHelpContext)
				{
					super(rootHelpContext);
				}

				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				public CollapsableTitledPanel add(boolean enableSelectionDialog)
					{
						if (fnRels == null)
							return null;
						CollapsableTitledPanel newQRUI = new NonlinearDataSeriesUI(NonlinearSeriesListUI.this.rootHelpContext);
						ndsuiNonlinearDataSeriesList.add(newQRUI);
						return newQRUI;
					}
				
				public FunctionalRelationship updateFnRel(EffectopediaObject owner, LinkNature linkNature, FunctionalRelationship fnRel)
					{
						return new FunctionalRelationship_Nonlinear(owner, FunctionalRelationship_Nonlinear.TIME_COURSE);
					}
				
				public FunctionalRelationship generateDefaultTitlesIfNeeded(Link_EffectToEffect link, FunctionalRelationship fnRel)
					{
						if ((link == null) || fnRel == null)
							return null;
						DataTemplates templates = fnRel.getTemplates();
						String xAxisTitle = templates.getxAxisTitle();
						String yPrimaryAxisTitle = templates.getyPrimaryAxisTitle();
						String ySecondaryAxisTitle = templates.getySecondaryAxisTitle();
						String chartTitle = templates.getChartTitle();
						if (((xAxisTitle == null) || (xAxisTitle.length() == 0)))
							templates.setxAxisTitle("time");
						if (((yPrimaryAxisTitle == null) || (yPrimaryAxisTitle.length() == 0)))
							templates.setyPrimaryAxisTitle(link.getFromEffect().getCachedObject().getTitle());
						if (((ySecondaryAxisTitle == null) || (ySecondaryAxisTitle.length() == 0)))
							templates.setySecondaryAxisTitle(link.getToEffect().getCachedObject().getTitle());
						if ((((chartTitle == null) || (chartTitle.length() == 0))) && (templates.getOwner() != null))
							templates.setChartTitle("Temporal concordance");
						return fnRel;
					}
				
			}
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new NonlinearSeriesListUI("Temporal concordance",null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public NonlinearSeriesListUI(String title,RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				initGUI(title);
				adjustUI(EDIT);
			}
		
		private void initGUI(String title)
			{
				try
					{
						setPreferredSize(optimalSize);
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBorder(BorderFactory.createTitledBorder(null, title, TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12)));
						this.setBackground(Color.WHITE);
							{
								ndsuiNonlinearDataSeriesList = new NonlinearDataSeriesListUI(rootHelpContext);
								this.add(ndsuiNonlinearDataSeriesList, BorderLayout.CENTER);
								ndsuiNonlinearDataSeriesList.setBackground(Color.WHITE);
								// ndsuiNonlinearDataSeriesList.add(false);
							}
							{
								letuiNonlinearSeries = new ListEditorToolbarUI(ndsuiNonlinearDataSeriesList, "time series", ListEditorToolbarUI.DEFAULT, FlowLayout.RIGHT);
								this.add(letuiNonlinearSeries, BorderLayout.SOUTH);
								letuiNonlinearSeries.setVisible(true);
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
						ndsuiNonlinearDataSeriesList.setFunctionalRelationships(fnRels, true);
						return;
					}
				fnRels = (FunctionalRelationships) o;
				analytic = fnRels.getDefault() instanceof FunctionalRelationship_Analytic;
				ndsuiNonlinearDataSeriesList.setFunctionalRelationships(fnRels, readonly);
				letuiNonlinearSeries.updateEditButtons(readonly);
			}
		
		public void updateOptimalSize()
			{
				optimalSize.width = ndsuiNonlinearDataSeriesList.getWidth();
				optimalSize.height = ndsuiNonlinearDataSeriesList.getPreferredSize().height + ((letuiNonlinearSeries != null) ? letuiNonlinearSeries.getPreferredSize().height : 0);
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
				ndsuiNonlinearDataSeriesList.initializeUI();
			}
		
		public ListEditorToolbarUI getListEditorUI()
			{
				return letuiNonlinearSeries;
			}
		
		private Dimension															optimalSize	= new Dimension(400, 300);
		private FunctionalRelationships	fnRels						= null;
		private boolean																	analytic				= false;
		
	}
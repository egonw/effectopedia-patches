package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Effect_AdverseOutcome;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.filter.ContextDimensionFilter.Criterion;
import org.qsari.effectopedia.data.filter.FilteredIndex;
import org.qsari.effectopedia.data.filter.PathwayFilter;
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
public class SuggestedEffectsUI extends ContextSensitivePanel implements AdjustableUI, SizeOptimizableUI
	{
		/**
	 * 
	 */
		private static final long			serialVersionUID	= 1L;
		private JList<String>							jlSuggestedEffects;
		private JScrollPane									jspSuggestedEffects;
		private JButton													jbLinkSelectedUpstreamCauses;
		private JPanel														jpLinkUpstreamCauses;
		
		private boolean													upstream;
		
		public final static boolean	UPSTREAM									= true;
		public final static boolean	DOWNSTREAM							= false;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new SuggestedEffectsUI(SuggestedEffectsUI.UPSTREAM,null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public SuggestedEffectsUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("suggested_effects");
				this.upstream = true;
				DataSource data = Effectopedia.EFFECTOPEDIA.getData();
				suggestedEffects = new FilteredIndex(data == null ? null : data.getLiveIndices().getEffects());
				initGUI();
			}
		
		public SuggestedEffectsUI(boolean upstream,RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				this.upstream = upstream;
				setName(upstream?"up_effects":"dn_effects");
				DataSource data = Effectopedia.EFFECTOPEDIA.getData();
				suggestedEffects = new FilteredIndex(data == null ? null : data.getLiveIndices().getEffects());
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						setPreferredSize(optimalSize);
						this.setBorder(BorderFactory.createTitledBorder(null, upstream ? "Available upstream causes" : "Available downstream events", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font(
								"Tahoma", 2, 11)));
						this.setBackground(Color.WHITE);
							{
								jspSuggestedEffects = new JScrollPane();
								this.add(jspSuggestedEffects, BorderLayout.CENTER);
								jspSuggestedEffects.setPreferredSize(new java.awt.Dimension(190, 53));
								jspSuggestedEffects.setBackground(Color.WHITE);
								jspSuggestedEffects.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
									{
										ListModel<String> jList1Model = suggestedEffects.getListModel();
										jlSuggestedEffects = new JList<String>();
										jspSuggestedEffects.setViewportView(jlSuggestedEffects);
										jlSuggestedEffects.setModel(jList1Model);
										jlSuggestedEffects.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
										jlSuggestedEffects.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
									}
							}
							{
								jpLinkUpstreamCauses = new JPanel();
								this.add(jpLinkUpstreamCauses, BorderLayout.SOUTH);
								FlowLayout jpLinkUpstreamCausesLayout = new FlowLayout();
								jpLinkUpstreamCausesLayout.setAlignment(FlowLayout.RIGHT);
								jpLinkUpstreamCausesLayout.setHgap(3);
								jpLinkUpstreamCausesLayout.setVgap(1);
								jpLinkUpstreamCauses.setBackground(new java.awt.Color(255, 255, 255));
								jpLinkUpstreamCauses.setPreferredSize(new java.awt.Dimension(400, 22));
								jpLinkUpstreamCauses.setLayout(jpLinkUpstreamCausesLayout);
									{
										jbLinkSelectedUpstreamCauses = new JButton();
										jpLinkUpstreamCauses.add(jbLinkSelectedUpstreamCauses);
										jbLinkSelectedUpstreamCauses.setText("Link Selected");
										jbLinkSelectedUpstreamCauses.setFont(new java.awt.Font("Dialog", 0, 12));
										jbLinkSelectedUpstreamCauses.setPreferredSize(new java.awt.Dimension(120, 18));
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
				this.setVisible((visualOptions & RELATEDSUGG) != 0);
				// letuiCauseToolbar.AdjustUI(visualOptions);
			}
		
		public void load(Object o)
			{
				if (!(o instanceof Effect))
					return;
				effect = (Effect) o;
				selectedEffect = null;
				if ((!upstream) && (effect instanceof Effect_AdverseOutcome))
					{
						suggestedEffects.setIndex(null);
						jlSuggestedEffects.revalidate();
						return;
					}
				suggestedEffects.clearFilters();
				suggestedEffects.addGenericFilter();
				suggestedEffects.addPathwaysFilter(effect, PathwayFilter.Criterion.IS_NOT);
				if (upstream)
					suggestedEffects.buildDisjunctiveContextFilter(effect, Criterion.LOWER);
				else
					suggestedEffects.buildDisjunctiveContextFilter(effect, Criterion.GREATER);
				updateOptimalSize();
				jlSuggestedEffects.revalidate();
			}
		
		public void updateOptimalSize()
			{
				optimalSize.width = jlSuggestedEffects.getWidth();
				optimalSize.height = jlSuggestedEffects.getPreferredSize().height;
				setPreferredSize(optimalSize);
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
		
		private Dimension					optimalSize	= new Dimension(200, 120);
		
		private Effect								effect;
		protected Effect						selectedEffect;
		private FilteredIndex	suggestedEffects;
	}

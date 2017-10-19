package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.core.objects.Link_ChemStructToChemStruct;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.help.RootHelpContextScrollPane;
import org.qsari.effectopedia.gui.obj_prop.QualityAssuranceUI;

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
public class Link_SubstanceToReactiveSubstanceUI extends RootHelpContextScrollPane implements AdjustableUI, LoadableEditorUI, InitializableUI
	{
		/**
	 * 
	 */
		private static final long								serialVersionUID	= 1L;
		private LinkHeaderSimplifiedUI			lhuiHeader;
		private QualityAssuranceUI							qauiQualityAssurance;
		private DescriptionUI												duiDescription;
		private PathwaysListUI											pluiAssociatedPathways;
		private ReferencesUI													ruiReferences;
		private BoxLayout																thisLayout;
		private OntologyInstancesUI						oiuiEnzymeSystem;
		private TitledBorder													titledBorder;
		private EffectopediaObjectListUI	eoluiModifyingFactors;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new Link_SubstanceToReactiveSubstanceUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public Link_SubstanceToReactiveSubstanceUI()
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
						cspEditPanel.setName("link_s2s");
						
						this.setViewportView(cspEditPanel);
						thisLayout = new BoxLayout(cspEditPanel, javax.swing.BoxLayout.Y_AXIS);
						cspEditPanel.setLayout(thisLayout);
						titledBorder = BorderFactory.createTitledBorder(new LineBorder(DefaultGOSettings.linkColor, 2, false), "Link", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI",
								1, 12), DefaultGOSettings.linkColor);
						cspEditPanel.setBorder(titledBorder);
						cspEditPanel.setBackground(Color.WHITE);
							{
								lhuiHeader = new LinkHeaderSimplifiedUI(rootHelpContext);
								cspEditPanel.add(lhuiHeader);
								lhuiHeader.setPreferredSize(new java.awt.Dimension(388, 41));
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
								cspEditPanel.add(eoluiModifyingFactors);
							}
							{
								oiuiEnzymeSystem = new OntologyInstancesUI("Enzyme system",rootHelpContext);
								cspEditPanel.add(oiuiEnzymeSystem);
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
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof Link_ChemStructToChemStruct))
					return;
				link = (Link_ChemStructToChemStruct) o;
				readonly = readonly || link.isReadonly();
				lhuiHeader.load(link, readonly);
				qauiQualityAssurance.load(link.getQA(), readonly);
				ruiReferences.load(link.getReferenceIDs(), readonly);
				duiDescription.load(link.getDescriptionIDs(), readonly);
				eoluiModifyingFactors.load(link.getModifyingFactors().getObjectIDs(), readonly);
				pluiAssociatedPathways.load(link.getPathwayIDs(), readonly);
				oiuiEnzymeSystem.load(link.getEnzymeSystem(), readonly);
				titledBorder.setTitle((readonly) ? "Link - read only " : "Link");
				updateOptimalSize();
			}
		
		public void updateOptimalSize()
			{
				int difference;
				Insets insets = getBorder().getBorderInsets(this);
				optimalSize.width = getWidth();
				optimalSize.width -= this.getVerticalScrollBar().isVisible() ? this.getVerticalScrollBar().getPreferredSize().width + 4 : 4;
				optimalSize.height = lhuiHeader.getPreferredSize().height + qauiQualityAssurance.getPreferredSize().height + ruiReferences.getPreferredSize().height
						+ pluiAssociatedPathways.getPreferredSize().height + duiDescription.getPreferredSize().height + eoluiModifyingFactors.getPreferredSize().height;
				optimalSize.height += insets.top + insets.bottom;
				difference = optimalSize.height - cspEditPanel.getHeight();
				cspEditPanel.setPreferredSize(optimalSize);
				this.revalidate();
				JScrollBar scrollbar = this.getVerticalScrollBar();
				if (scrollbar != null)
					scrollbar.setValue(scrollbar.getValue() + difference);
				Container parent = getParent();
				if ((parent != null) && (parent instanceof SizeOptimizableUI))
					((SizeOptimizableUI) parent).updateOptimalSize();
			}
		
		@Override
		public void initializeUI()
			{
				qauiQualityAssurance.initializeUI();
				ruiReferences.initializeUI();
				duiDescription.initializeUI();
				lhuiHeader.initializeUI();
			}
		
		public Link_SubstanceToReactiveSubstanceUI setHeaderAllowRedirecting(boolean allow)
			{
				lhuiHeader.setAllowRedirecting(allow);
				return this;
			}
		
		private Dimension																			optimalSize	= new Dimension(400, 1000);
		
		private Link_ChemStructToChemStruct	link;
	}

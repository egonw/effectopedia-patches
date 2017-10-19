package org.qsari.effectopedia.gui;

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

import org.qsari.effectopedia.core.objects.Method_InSilicoGlobalModel;
import org.qsari.effectopedia.core.objects.Test_InSilico;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
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
public class InSilicoTestUI extends RootHelpContextScrollPane implements AdjustableUI, LoadableEditorUI, InitializableUI
	{
		/**
		* 
		*/
		private static final long																								serialVersionUID	= 1L;
		private TestHeaderUI																													thuiHeader;
		private QualityAssuranceUI																							qauiQualityAssurance;
		private MethodListUI<Method_InSilicoGlobalModel>	mluiAssociatedGlobalModels;
		private DescriptionUI																												duiDescription;
		private TestedSubstancesListUI																			tsluiTrainingSetSubstances;
		private ContextUI																																cuiContext;
		private PathwaysListUI																											pluiAssociatedPathways;
		private ReferencesUI																													ruiReferences;
		private TitledBorder																													titledBorder;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new InSilicoTestUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public InSilicoTestUI()
			{
				super();
				initGUI();
			}
			
		private void initGUI()
			{
				try
					{
						cspEditPanel = new ContextSensitivePanel(rootHelpContext);
						cspEditPanel.setPreferredSize(optimalSize);
						cspEditPanel.setName("in_silico_test");
						
						this.setViewportView(cspEditPanel);
						BoxLayout thisLayout = new BoxLayout(cspEditPanel, javax.swing.BoxLayout.Y_AXIS);
						cspEditPanel.setLayout(thisLayout);
						titledBorder = BorderFactory.createTitledBorder(new LineBorder(DefaultGOSettings.inSilicoTestColor, 2, false), "In-silico Test", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
								new java.awt.Font("Segoe UI", 1, 12), DefaultGOSettings.inSilicoTestColor);
						cspEditPanel.setBorder(titledBorder);
							
							{
								thuiHeader = new TestHeaderUI(rootHelpContext);
								cspEditPanel.add(thuiHeader);
							}
							{
								qauiQualityAssurance = new QualityAssuranceUI(rootHelpContext);
								cspEditPanel.add(qauiQualityAssurance);
							}
							{
								mluiAssociatedGlobalModels = new MethodListUI<Method_InSilicoGlobalModel>("Associated Global Models", "global in silico model", DefaultEffectopediaObjects.DEFAULT_GLOBAL_MODEL,
										rootHelpContext);
								cspEditPanel.add(mluiAssociatedGlobalModels);
							}
							
							{
								duiDescription = new DescriptionUI(rootHelpContext);
								cspEditPanel.add(duiDescription);
							}
							{
								cuiContext = new ContextUI(rootHelpContext);
								cspEditPanel.add(cuiContext);
							}
							{
								pluiAssociatedPathways = new PathwaysListUI(rootHelpContext);
								cspEditPanel.add(pluiAssociatedPathways);
							}
							{
								tsluiTrainingSetSubstances = new TestedSubstancesListUI(rootHelpContext);
								cspEditPanel.add(tsluiTrainingSetSubstances);
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
				AdjustbleUserInterfaceTools.adjustChildren(this, visualOptions);
			}
			
		public void load(Object o, boolean readonly)
			{
				// System.out.print(o);
				if (!(o instanceof Test_InSilico))
					return;
				test = (Test_InSilico) o;
				readonly = readonly || test.isReadonly();
				thuiHeader.load(test, readonly);
				qauiQualityAssurance.load(test.getQA(), readonly);
				mluiAssociatedGlobalModels.load(test.getGlobalModelIDs(), readonly);
				ruiReferences.load(test.getReferenceIDs(), readonly);
				cuiContext.load(test.getCoordinates(), readonly);
				pluiAssociatedPathways.load(test.getPathwayIDs(), readonly);
				tsluiTrainingSetSubstances.load(test.getSubstanceDataIDs(), readonly);
				duiDescription.load(test.getDescriptionIDs(), readonly);
				titledBorder.setTitle((readonly) ? "In-silico Test - read only " : "In-silico Test");
				updateOptimalSize();
				initializeUI();
			}
			
		public void updateOptimalSize()
			{
				int difference;
				Insets insets = getBorder().getBorderInsets(this);
				optimalSize.width = getWidth();
				optimalSize.width -= this.getVerticalScrollBar().isVisible() ? this.getVerticalScrollBar().getPreferredSize().width + 2 : 2;
				optimalSize.height = thuiHeader.getPreferredSize().height + qauiQualityAssurance.getPreferredSize().height + mluiAssociatedGlobalModels.getPreferredSize().height
						+ ruiReferences.getPreferredSize().height + cuiContext.getPreferredSize().height + pluiAssociatedPathways.getPreferredSize().height + tsluiTrainingSetSubstances.getPreferredSize().height
						+ duiDescription.getPreferredSize().height;
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
			
		public InSilicoTestUI setHeaderAllowRedirecting(boolean allow)
			{
				thuiHeader.setAllowRedirecting(allow);
				return this;
			}
			
		@Override
		public void initializeUI()
			{
				qauiQualityAssurance.initializeUI();
				mluiAssociatedGlobalModels.initializeUI();
				ruiReferences.initializeUI();
				cuiContext.initializeUI();
				tsluiTrainingSetSubstances.initializeUI();
				duiDescription.initializeUI();
				thuiHeader.initializeUI();
			}
			
			
		private Dimension									optimalSize	= new Dimension(400, 1000);
		
		private Test_InSilico					test;
		
	}

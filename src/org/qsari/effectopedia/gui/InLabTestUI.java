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

import org.qsari.effectopedia.core.objects.Method_Investigation;
import org.qsari.effectopedia.core.objects.Method_Study;
import org.qsari.effectopedia.core.objects.Test;
import org.qsari.effectopedia.core.objects.Test_InLab;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.core.GUIFactory;
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
public class InLabTestUI extends RootHelpContextScrollPane implements AdjustableUI, LoadableEditorUI, InitializableUI
	{
		/**
		* 
		*/
		private static final long																		serialVersionUID	= 1L;
		private TestHeaderUI																							thuiHeader;
		private QualityAssuranceUI																	qauiQualityAssurance;
		private MethodListUI<Method_Investigation>	mluiAssociatedInvestigations;
		private MethodListUI<Method_Study>									mluiAssociatedStudies;
		private DescriptionUI																						duiDescription;
		private LabsUI																													luiLabs;
		private ContextUI																										cuiContext;
		private PathwaysListUI																					pluiAssociatedPathways;
		private TestedSubstancesListUI													tsluiTestedSubstances;
		private ReferencesUI																							ruiReferences;
		private TitledBorder																							titledBorder;
		private LineBorder																									lineBorder;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new InLabTestUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public InLabTestUI()
			{
				super();
				rootHelpContext = this;
				initGUI();
			}
			
		private void initGUI()
			{
				try
					{
						cspEditPanel = new ContextSensitivePanel(rootHelpContext);
						cspEditPanel.setPreferredSize(optimalSize);
						cspEditPanel.setName("in_lab_test");
						
						this.setViewportView(cspEditPanel);
						BoxLayout thisLayout = new BoxLayout(cspEditPanel, javax.swing.BoxLayout.Y_AXIS);
						cspEditPanel.setLayout(thisLayout);
						lineBorder = new LineBorder(DefaultGOSettings.inVitroTestColor, 2, false);
						titledBorder = BorderFactory.createTitledBorder(lineBorder, "Test", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12),
								DefaultGOSettings.inVitroTestColor);
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
								mluiAssociatedInvestigations = new MethodListUI<Method_Investigation>("Associated investigations", "investigation", DefaultEffectopediaObjects.DEFAULT_INVESTIGATION, rootHelpContext);
								cspEditPanel.add(mluiAssociatedInvestigations);
							}
							{
								mluiAssociatedStudies = new MethodListUI<Method_Study>("Associated studies", "study", DefaultEffectopediaObjects.DEFAULT_STUDY, rootHelpContext);
								cspEditPanel.add(mluiAssociatedStudies);
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
								tsluiTestedSubstances = new TestedSubstancesListUI(rootHelpContext);
								cspEditPanel.add(tsluiTestedSubstances);
							}
							{
								luiLabs = new LabsUI(rootHelpContext);
								cspEditPanel.add(luiLabs);
								tsluiTestedSubstances.setLabsTableModel(luiLabs.getLabsTableModel());
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
				if (!(o instanceof Test_InLab))
					return;
				test = (Test_InLab) o;
				testType = test.getTestType().caption;
				readonly = readonly || test.isReadonly();
				thuiHeader.load(test, readonly);
				qauiQualityAssurance.load(test.getQA(), readonly);
				ruiReferences.load(test.getReferenceIDs(), readonly);
				luiLabs.load(test.getLabIDs(), readonly);
				mluiAssociatedInvestigations.load(test.getInvestigationIDs(), readonly);
				mluiAssociatedStudies.load(test.getStudyIDs(), readonly);
				cuiContext.load(test.getCoordinates(), readonly);
				pluiAssociatedPathways.load(test.getPathwayIDs(), readonly);
				tsluiTestedSubstances.load(test.getSubstanceDataIDs(), readonly);
				duiDescription.load(test.getDescriptionIDs(), readonly);
				titledBorder.setTitle((readonly) ? testType + " Test - read only " : testType + " Test");
				Color color = getTestColor(test);
				titledBorder.setTitleColor(color);
				titledBorder.setBorder(new LineBorder(color, 2, false));
				updateOptimalSize();
				initializeUI();
			}
			
		public Color getTestColor(Test test)
			{
				switch (test.getTestType())
					{
						case IN_CHEMICO:
						case IN_VITRO:
						case UNDEFINED:
							return DefaultGOSettings.inVitroTestColor;
						case IN_VIVO:
						case EX_VIVO:
							return DefaultGOSettings.inVivoTestColor;
						case IN_SILICO:
							return DefaultGOSettings.inSilicoTestColor;
					}
				return DefaultGOSettings.inVitroTestColor;
			}
			
		public void updateOptimalSize()
			{
				Component focused = GUIFactory.GUI.getFrame().getFocusOwner();
				Insets insets = getBorder().getBorderInsets(this);
				optimalSize.width = getWidth();
				optimalSize.width -= this.getVerticalScrollBar().isVisible() ? this.getVerticalScrollBar().getPreferredSize().width + 2 : 2;
				optimalSize.height = thuiHeader.getPreferredSize().height + qauiQualityAssurance.getPreferredSize().height + mluiAssociatedInvestigations.getPreferredSize().height
						+ mluiAssociatedStudies.getPreferredSize().height + ruiReferences.getPreferredSize().height + cuiContext.getPreferredSize().height + pluiAssociatedPathways.getPreferredSize().height
						+ tsluiTestedSubstances.getPreferredSize().height + luiLabs.getPreferredSize().height + duiDescription.getPreferredSize().height;
				optimalSize.height += insets.top + insets.bottom;
				cspEditPanel.setPreferredSize(optimalSize);
				this.revalidate();
				this.getViewport().revalidate();
				if (focused != null)
					this.getViewport().scrollRectToVisible(focused.getBounds());
				Container parent = getParent();
				if ((parent != null) && (parent instanceof SizeOptimizableUI))
					((SizeOptimizableUI) parent).updateOptimalSize();
			}
			
		public void initializeUI()
			{
				qauiQualityAssurance.initializeUI();
				mluiAssociatedInvestigations.initializeUI();
				mluiAssociatedStudies.initializeUI();
				duiDescription.initializeUI();
				cuiContext.initializeUI();
				ruiReferences.initializeUI();
				thuiHeader.initializeUI();
			}
			
		public InLabTestUI setHeaderAllowRedirecting(boolean allow)
			{
				thuiHeader.setAllowRedirecting(allow);
				return this;
			}

	private Dimension															optimalSize	= new Dimension(400, 1000);

		
		private String																		testType;
		private Test_InLab														test;
	}

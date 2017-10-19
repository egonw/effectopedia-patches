package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.gui.comp.TabManager;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.nav.GUINavigator;
import org.qsari.effectopedia.gui.nav.GUINavigator.NavigationEvent;
import org.qsari.effectopedia.gui.nav.GUINavigator.NavigatorListener;
import org.qsari.effectopedia.gui.util.DefaultTextContextMenu;

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
public class EditUI extends ContextSensitivePanel implements AdjustableUI, NavigatorListener, RootHelpContext
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new EditUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public EditUI()
			{
				super(null);
				setName("edit");
				DefaultTextContextMenu.installDefaultPopupMenu(this);
				initGUI();
				initTabCache();
				((GUINavigator) UserInterface.getDefaultNavigator()).addNavigatorListener(this);
				setVisibleTabs(new String[0]);
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						setPreferredSize(new Dimension(400, 300));
							{
								jtpEditors = new JTabbedPane();
								jtpEditors.addChangeListener(TabManager.MANAGER);
								jtpEditors.addMouseMotionListener(this);
								this.add(jtpEditors, BorderLayout.CENTER);
								jtpEditors.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
								jtpEditors.setName("tabs");
									{
										ecuiChemicals = new EditChemicalsUI(false,rootHelpContext);
										jtpEditors.addTab("Chemical", null, ecuiChemicals, null);
									}
									{
										esauiStructuralAlerts = new EditStructuralAlertsUI(rootHelpContext);
										jtpEditors.addTab("Structural Alert", null, esauiStructuralAlerts, null);
									}
									{
										ebpuiBiologicalPerutbation = new EditBiologicalPerturbationUI(rootHelpContext);
										jtpEditors.addTab("Biological Perturbation", null, ebpuiBiologicalPerutbation, null);
										ebpuiBiologicalPerutbation.addMouseMotionListener(this);
									}
									{
										eeuiEffect = new EditEffectUI(rootHelpContext);
										jtpEditors.addTab("(Key) Event", null, eeuiEffect, null);
										eeuiEffect.addMouseMotionListener(this);
									}
									{
										echluiChemicalLink = new EditChemicalLinkUI(rootHelpContext);
										jtpEditors.addTab("Link Substance to MIE", null, echluiChemicalLink, null);
										echluiChemicalLink.addMouseMotionListener(this);
									}
									{
										emluiADMELink = new EditADMELinkUI(rootHelpContext);
										jtpEditors.addTab("ADME Transformation", null, emluiADMELink, null);
										emluiADMELink.addMouseMotionListener(this);
									}
									{
										eluiLink = new EditLinkUI(rootHelpContext);
										jtpEditors.addTab("(Key) Event Relationship", null, eluiLink, null);
										eluiLink.addMouseMotionListener(this);
									}
									{
										eiltuiInLabTest = new EditInLabTestUI(rootHelpContext);
										jtpEditors.addTab("In Lab Test", null, eiltuiInLabTest, null);
										eiltuiInLabTest.addMouseMotionListener(this);
									}
									{
										eistuiInSilicoTest = new EditInSilicoTestUI(rootHelpContext);
										jtpEditors.addTab("In-silico Test", null, eistuiInSilicoTest, null);
										eistuiInSilicoTest.addMouseMotionListener(this);
									}
									{
										epuiPathway = new EditPathwayUI();
										jtpEditors.addTab("Pathway", null, epuiPathway, null);
										epuiPathway.addMouseMotionListener(this);
									}
									{
										iuiInvestigation = new InvestigationUI(rootHelpContext);
										jtpEditors.addTab("Investigation", null, iuiInvestigation, null);
										iuiInvestigation.addMouseMotionListener(this);
									}
									{
										suiStudy = new StudyUI(rootHelpContext);
										jtpEditors.addTab("Study", null, suiStudy, null);
										suiStudy.addMouseMotionListener(this);
									}
									{
										gmuiGlobalModel = new GlobalModelUI(rootHelpContext);
										jtpEditors.addTab("Global In-silico Model", null, gmuiGlobalModel, null);
										gmuiGlobalModel.addMouseMotionListener(this);
									}
									{
										etrmuiTestResponseMapping = new EditTestResponceMappingUI(rootHelpContext);
										jtpEditors.addTab("Test response mapping", null, etrmuiTestResponseMapping, null);
										etrmuiTestResponseMapping.addMouseMotionListener(this);
									}
									{
										suiSystem = new EditSystemUI(rootHelpContext);
										jtpEditors.addTab("System", null, suiSystem, null);
										suiSystem.addMouseMotionListener(this);
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		private void initTabCache()
			{
				tabs = new HashMap<String, Component>(jtpEditors.getTabCount());
				for (int t = 0; t < jtpEditors.getTabCount(); t++)
					tabs.put(jtpEditors.getTitleAt(t), jtpEditors.getComponentAt(t));
			}
		
		public void setVisibleTabs(String[] tabNames)
			{
				jtpEditors.removeAll();
				for (int i = 0; i < tabNames.length; i++)
					jtpEditors.addTab(tabNames[i], null, tabs.get(tabNames[i]), null);
			}
		
		public void setVisibleTabs()
			{
				int cnt = 0;
				for (int i = 0; i < visibleTabs.length; i++)
					{
						boolean currentlyVisible = jtpEditors.indexOfTab(AVAILABLE_TABS[i]) != -1;
						boolean setToVisible = visibleTabs[i];
						if ((currentlyVisible ^ (setToVisible)))
							if (setToVisible)
								jtpEditors.insertTab(AVAILABLE_TABS[i], null, tabs.get(AVAILABLE_TABS[i]), null, cnt);
							else
								jtpEditors.remove(tabs.get(AVAILABLE_TABS[i]));
						if (setToVisible)
							cnt++;
					}
			}
		
		private HashMap<String, Component>	tabs;
		public static final String									AVAILABLE_TABS[]	= new String[]
																																																							{ "Chemical", "Structural Alert", "Biological Perturbation", "(Key) Event", "Link Substance to MIE", "ADME Transformation",
		"(Key) Event Relationship", "In Lab Test", "In-silico Test", "Pathway", "Investigation", "Study", "Global In-silico Model", "Test response mapping", "System" };
		public boolean																					visibleTabs[]				= new boolean[]
																																																							{ false, false, false, false, false, false, false, false, false, false, false, false, false, false, false };
		
		@Override
		public void navigate(NavigationEvent evt)
			{
				String location = (String) evt.getSource();
				visibleTabs[0] = location.contains("EditChemicalsUI");
				visibleTabs[1] = location.contains("EditStructuralAlertsUI");
				visibleTabs[2] = location.contains("EditBiologicalPerturbationUI");
				visibleTabs[3] = location.contains("EditEffectUI");
				visibleTabs[4] = location.contains("EditChemicalLinkUI");
				visibleTabs[5] = location.contains("EditADMELinkUI");
				visibleTabs[6] = location.contains("EditLinkUI");
				visibleTabs[7] = location.contains("EditInLabTestUI");
				visibleTabs[8] = location.contains("EditInSilicoTestUI");
				visibleTabs[9] = location.contains("EditPathwayUI");
				visibleTabs[10] = location.contains("InvestigationUI");
				visibleTabs[11] = location.contains("StudyUI");
				visibleTabs[12] = location.contains("GlobalModelUI");
				visibleTabs[13] = location.contains("EditTestResponceMappingUI");
				visibleTabs[14] = location.contains("EditSystemUI");
				setVisibleTabs();
			}
		
		private JTabbedPane																		jtpEditors;
		private EditChemicalsUI														ecuiChemicals;
		private EditStructuralAlertsUI							esauiStructuralAlerts;
		private EditBiologicalPerturbationUI	ebpuiBiologicalPerutbation;
		private EditLinkUI																			eluiLink;
		private EditChemicalLinkUI											echluiChemicalLink;
		private EditADMELinkUI															emluiADMELink;
		private EditSystemUI																	suiSystem;
		private EditInLabTestUI														eiltuiInLabTest;
		private EditInSilicoTestUI											eistuiInSilicoTest;
		private EditEffectUI																	eeuiEffect;
		private EditPathwayUI																epuiPathway;
		private InvestigationUI														iuiInvestigation;
		private StudyUI																						suiStudy;
		private GlobalModelUI																gmuiGlobalModel;
		private EditTestResponceMappingUI				etrmuiTestResponseMapping;
		
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
		
	}

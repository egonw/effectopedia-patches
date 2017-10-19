package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.EventObject;
import java.util.HashMap;

import javax.swing.ImageIcon;
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
import org.qsari.effectopedia.gui.util.TextAreaStream.StreamChangeListener;

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
public class MainUI extends ContextSensitivePanel implements AdjustableUI, NavigatorListener, StreamChangeListener, RootHelpContext
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
				frame.getContentPane().add(new MainUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public MainUI()
			{
				super(null);
				setName("main");
				initGUI();
				initTabCache();
				((GUINavigator) UserInterface.getDefaultNavigator()).addNavigatorListener(this);
				setVisibleTabs(new String[]
					{ "Welcome", "Help" });
				EffectopediaUI.errorStream.addStreamChangeListener(this);
			}
		
		private void initGUI()
			{
				try
					{
						setPreferredSize(new Dimension(400, 300));
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBackground(Color.WHITE);
							{
								jtpMain = new JTabbedPane();
								jtpMain.addChangeListener(TabManager.MANAGER);
								jtpMain.setTabPlacement(JTabbedPane.TOP);
								this.add(jtpMain, BorderLayout.CENTER);
								jtpMain.setBackground(Color.WHITE);
								jtpMain.setFont(new java.awt.Font("Dialog", 0, 16));
									{
										wuiWelcome = new WelcomeUI();
										jtpMain.addTab("Welcome", null, wuiWelcome, null);
									}
									{
										suiSearch = new SearchUI();
										jtpMain.addTab("Search", null, suiSearch, null);
									}
									{
										vuiView = new ViewUI();
										jtpMain.addTab("View", null, vuiView, null);
									}
									{
										euiEdit = new EditUI();
										jtpMain.addTab("Edit", null, euiEdit, null);
									}
									{
										rhuiHistory = new RevisionHistoryUI();
										jtpMain.addTab("Revision History", null, rhuiHistory, null);
									}
									{
										dsmuiMerge = new DataSourcesMergeUI();
										jtpMain.addTab("Review Conflicting Changes", null, dsmuiMerge, null);
									}
									{
										duiDiscuss = new DiscussUI();
										jtpMain.addTab("Discuss", null, duiDiscuss, null);
									}
									{
										wpuiWebPage = new WebPageUI(rootHelpContext);
										jtpMain.addTab("Support", null, wpuiWebPage, null);
									}
									{
										huiHelp = new HelpUI();
										jtpMain.addTab("Help", null, huiHelp, null);
									}
									{
										scuiConsole = new SystemConsoleUI();
										jtpMain.addTab("System Console", null, scuiConsole, null);
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
				tabs = new HashMap<String, Component>(jtpMain.getTabCount());
				for (int t = 0; t < jtpMain.getTabCount(); t++)
					tabs.put(jtpMain.getTitleAt(t), jtpMain.getComponentAt(t));
			}
		
		public void setVisibleTabs(String[] tabNames)
			{
				jtpMain.removeAll();
				for (int i = 0; i < tabNames.length; i++)
					jtpMain.addTab(tabNames[i], null, tabs.get(tabNames[i]), null);
			}
		
		public void setVisibleTabs()
			{
				int cnt = 0;
				for (int i = 0; i < visibleTabs.length; i++)
					{
						boolean currentlyVisible = jtpMain.indexOfTab(AVAILABLE_TABS[i]) != -1;
						boolean setToVisible = visibleTabs[i];
						if ((currentlyVisible ^ (setToVisible)))
							if (setToVisible)
								jtpMain.insertTab(AVAILABLE_TABS[i], tabIcons[i], tabs.get(AVAILABLE_TABS[i]), null, cnt);
							else
								jtpMain.remove(tabs.get(AVAILABLE_TABS[i]));
						if (setToVisible)
							cnt++;
					}
				int index = jtpMain.indexOfTab("System Console");
				if (index != -1)
					jtpMain.setForegroundAt(index, Color.red);
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
		
		private HashMap<String, Component>	tabs;
		public static final String									AVAILABLE_TABS[]	= new String[]
																																																							{ "Welcome", "Search", "View", "Edit", "Revision History", "Review Conflicting Changes", "Discuss", "Support", "Help", "System Console" };
		public ImageIcon																			tabIcons[]							= new ImageIcon[]
																																																							{ null, null, null, null, null, null, null, null, null, UIResources.imageError };
		
		public boolean																					visibleTabs[]				= new boolean[]
																																																							{ true, false, false, false, false, false, false, false, true, false };
		
		@Override
		public void navigate(NavigationEvent evt)
			{
				String location = (String) evt.getSource();
				makeTabVisible(location);
			}
		
		public void makeTabVisible(String name)
			{
				visibleTabs[1] = visibleTabs[1] || name.contains("SearchUI");
				visibleTabs[2] = visibleTabs[2] || name.contains("ViewUI");
				visibleTabs[3] = name.contains("EditUI");
				visibleTabs[4] = visibleTabs[4] || name.contains("RevisionHistoryUI");
				visibleTabs[5] = visibleTabs[5] || name.contains("DataSourcesMergeUI");
				visibleTabs[6] = name.contains("DiscussUI");
				visibleTabs[7] = visibleTabs[7] || name.contains("WebPageUI");
				setVisibleTabs();
			}
		
		@Override
		public void streamChanged(EventObject evt)
			{
				visibleTabs[9] = true;
				setVisibleTabs();
			}
		
		public final ViewUI getViewUI()
			{
				return vuiView;
			}
		
		private JTabbedPane								jtpMain;
		private ViewUI													vuiView;
		private EditUI													euiEdit;
		private HelpUI													huiHelp;
		private DiscussUI										duiDiscuss;
		private SearchUI											suiSearch;
		private WelcomeUI										wuiWelcome;
		private RevisionHistoryUI		rhuiHistory;
		private DataSourcesMergeUI	dsmuiMerge;
		private WebPageUI										wpuiWebPage;
		private SystemConsoleUI				scuiConsole;
		
	}

package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.gui.RevisionHistoryTableUI.RevisionHistorySelection;
import org.qsari.effectopedia.gui.RevisionHistoryTableUI.RevisionHistorySelectionListener;
import org.qsari.effectopedia.gui.core.DataView;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.toolbars.PathwaySpaceToolbarUI;
import org.qsari.effectopedia.gui.toolbars.ViewOptionsToolbarUI;

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
public class RevisionHistoryUI extends ContextSensitivePanel implements ComponentListener, RevisionHistorySelectionListener, LoadableEditorUI, RootHelpContext
	{
		/**
	 * 
	 */
	private static final long	serialVersionUID	= 5976658267794584388L;
		private RevisionHistoryFilterUI	jpFilter;
		private JSplitPane														jspHistory;
		private PathwaySpaceUI										psuiHistory;
		private PathwaySpaceUI										psuiCurrent;
		private JSplitPane														jspHistoryView;
		private JPanel																		jpToolbars;
		private JPanel																		jpView;
		private RevisionHistoryTableUI		rhtuiRevisionTable;
		private PathwaySpaceToolbarUI			pstuiToolbar;
		private ViewOptionsToolbarUI				votuiToolbar;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new RevisionHistoryUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public RevisionHistoryUI()
			{
				super(null);
				setName("history");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
					BorderLayout thisLayout = new BorderLayout();
					this.setLayout(thisLayout);
						setPreferredSize(new Dimension(400, 300));
						this.addComponentListener(this);
							{
								jpFilter = new RevisionHistoryFilterUI(rootHelpContext);
								this.add(jpFilter, BorderLayout.NORTH);
								jpFilter.setMinimumSize(new java.awt.Dimension(400, 56));
								jpFilter.setMaximumSize(new java.awt.Dimension(32767, 56));
							}
							{
								jspHistory = new JSplitPane();
								jspHistory.setOneTouchExpandable(true);
								jspHistory.setDividerLocation(120);
								this.add(jspHistory, BorderLayout.CENTER);
								jspHistory.setOrientation(JSplitPane.VERTICAL_SPLIT);
									{
										rhtuiRevisionTable = new RevisionHistoryTableUI(rootHelpContext);
										jspHistory.add(rhtuiRevisionTable, JSplitPane.LEFT);
										rhtuiRevisionTable.setPreferredSize(new java.awt.Dimension(398, 119));
									 rhtuiRevisionTable.addRevisionHistorySelectionListener(this);
									}
									{
										jpView = new JPanel();
										BorderLayout jpViewLayout = new BorderLayout();
										jpView.setLayout(jpViewLayout);
										jspHistory.add(jpView, JSplitPane.RIGHT);
											{
												jspHistoryView = new JSplitPane();
												jpView.add(jspHistoryView, BorderLayout.CENTER);
												jspHistoryView.setOneTouchExpandable(true);
													{
														psuiHistory = new PathwaySpaceUI(null,null,(DataView)Effectopedia.EFFECTOPEDIA.getData().getViews().get("History"),rootHelpContext);
														jspHistoryView.add(psuiHistory, JSplitPane.RIGHT);
														psuiHistory.setSize(200, 204);
													}
													{
														psuiCurrent = new PathwaySpaceUI(null,null,(DataView)Effectopedia.EFFECTOPEDIA.getData().getViews().get("Revision"),rootHelpContext);
														//psuiCurrent.getPahwayScrollPaneUI().getPathwayUI().setSynchronizedView(psuiHistory.getPahwayScrollPaneUI().getPathwayUI());
														//psuiHistory.getPahwayScrollPaneUI().getPathwayUI().setSynchronizedView(psuiCurrent.getPahwayScrollPaneUI().getPathwayUI());
														psuiCurrent.synchronizeWith(psuiHistory);
														jspHistoryView.add(psuiCurrent, JSplitPane.LEFT);
														psuiCurrent.setSize(200, 204);
													}
											}
											
											{
												jpToolbars = new JPanel();
												jpView.add(jpToolbars, BorderLayout.NORTH);
												BoxLayout jpToolbarsLayout = new BoxLayout(jpToolbars, javax.swing.BoxLayout.X_AXIS);
												jpToolbars.setLayout(jpToolbarsLayout);
													{
														pstuiToolbar = new PathwaySpaceToolbarUI(PathwaySpaceToolbarUI.ZOOM_IN + PathwaySpaceToolbarUI.ZOOM_OUT + PathwaySpaceToolbarUI.DRAG);
														pstuiToolbar.addModes(psuiHistory.getPahwayScrollPaneUI().getPathwayUI().getModes());
														pstuiToolbar.addModes(psuiCurrent.getPahwayScrollPaneUI().getPathwayUI().getModes());
														pstuiToolbar.setDefaultMode();
														jpToolbars.add(pstuiToolbar);
														pstuiToolbar.setPreferredSize(new java.awt.Dimension(588, 40));
													}
													{
														votuiToolbar = new ViewOptionsToolbarUI(psuiCurrent, ViewOptionsToolbarUI.ALL);
														jpToolbars.add(votuiToolbar);
														votuiToolbar.setPreferredSize(new java.awt.Dimension(96, 40));
													}
												
											}
									}
							}
							jpFilter.setSorter(rhtuiRevisionTable.getSorter());
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}

		@Override
		public void componentHidden(ComponentEvent e)
			{
				
			}

		@Override
		public void componentMoved(ComponentEvent e)
			{
			
			}

		@Override
		public void componentResized(ComponentEvent e)
			{
				jspHistoryView.setDividerLocation(jspHistoryView.getWidth()>>1);
				jspHistory.setDividerLocation(jspHistory.getHeight()>>2);
			}

		@Override
		public void componentShown(ComponentEvent e)
			{
				
			}

		@Override
		public void selectionChanged(RevisionHistorySelection evt)
			{
				psuiHistory.load(evt.archive, true);
				psuiCurrent.load(evt.object, true);
			}
		
		@Override
		public void load(Object o, boolean readonly)
			{
				rhtuiRevisionTable.load(o,readonly);
			}
	}

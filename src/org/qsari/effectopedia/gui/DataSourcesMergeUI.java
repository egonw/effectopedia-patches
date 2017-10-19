package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.EventObject;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.qsari.effectopedia.data.DataSourceMerge;
import org.qsari.effectopedia.data.DataSourceMerge.EffectopediaObjectUnion;
import org.qsari.effectopedia.gui.DataSourceMergeFilterUI.MergeFilterListener;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.toolbars.MergeToolbarUI;
import org.qsari.effectopedia.gui.toolbars.MergeToolbarUI.MergeToolbarAction;
import org.qsari.effectopedia.gui.toolbars.MergeToolbarUI.MergeToolbarListener;
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
public class DataSourcesMergeUI extends ContextSensitivePanel implements ComponentListener, LoadableEditorUI, ChangeListener, MergeFilterListener, MergeToolbarListener,RootHelpContext
	{
		/**
	 * 
	 */
		private static final long							serialVersionUID	= 7677908389777147805L;
		private DataSourceMergeFilterUI	jpFilter;
		private DataSourceUI												dsuiDataSourceA;
		private DataSourceUI												dsuiDataSourceB;
		private JTabbedPane													jtbViewInterfce;
		private JSplitPane														jspComparativeView;
		private JPanel																		jpSynchronisationToolbars;
		private JPanel																		jpControls;
		private JPanel																		jpToolbars;
		private JPanel																		jpView;
		private PathwaySpaceToolbarUI			pstuiToolbar;
		private ViewOptionsToolbarUI				votuiToolbar;
		private MergeToolbarUI										mtuiSynchronize;
		private MergeToolbarUI										mtuiSynchronize1;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new DataSourcesMergeUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public DataSourcesMergeUI()
			{
				super(null);
				setName("data_source_merge");
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
								jpView = new JPanel();
								BorderLayout jpViewLayout = new BorderLayout();
								jpView.setLayout(jpViewLayout);
								jpView.setBackground(Color.WHITE);
								this.add(jpView, BorderLayout.CENTER);
									{
										jspComparativeView = new JSplitPane();
										jpView.add(jspComparativeView, BorderLayout.CENTER);
										jspComparativeView.setDividerLocation(200);
										jspComparativeView.setOneTouchExpandable(true);
											{
												dsuiDataSourceA = new DataSourceUI(rootHelpContext);
												jspComparativeView.add(dsuiDataSourceA, JSplitPane.LEFT);
												dsuiDataSourceA.setSize(200, 204);
											}
											{
												dsuiDataSourceB = new DataSourceUI(rootHelpContext);
												jspComparativeView.add(dsuiDataSourceB, JSplitPane.RIGHT);
												dsuiDataSourceB.setSize(200, 204);
											}
									}
									{
										jpControls = new JPanel();
										BorderLayout jpControlsLayout = new BorderLayout();
										jpControls.setLayout(jpControlsLayout);
										jpView.add(jpControls, BorderLayout.NORTH);
										jpControls.setPreferredSize(new java.awt.Dimension(400, 88));
										jpControls.setBackground(Color.WHITE);
											{
												jpFilter = new DataSourceMergeFilterUI(rootHelpContext);
												jpFilter.addMergeFilterListener(this);
												jpControls.add(jpFilter, BorderLayout.SOUTH);
												jpFilter.setMinimumSize(new java.awt.Dimension(400, 56));
												jpFilter.setMaximumSize(new java.awt.Dimension(32767, 56));
												jpFilter.setPreferredSize(new java.awt.Dimension(400, 24));
											}
											{
												jtbViewInterfce = new JTabbedPane();
												jtbViewInterfce.addChangeListener(this);
												jpControls.add(jtbViewInterfce, BorderLayout.CENTER);
												jtbViewInterfce.setBackground(Color.WHITE);
												jtbViewInterfce.setPreferredSize(new java.awt.Dimension(400, 66));
													{
														jpToolbars = new JPanel();
														jtbViewInterfce.addTab("Visual comparison", null, jpToolbars, null);
														BoxLayout jpToolbarsLayout = new BoxLayout(jpToolbars, javax.swing.BoxLayout.X_AXIS);
														jpToolbars.setLayout(jpToolbarsLayout);
														jpToolbars.setPreferredSize(new java.awt.Dimension(395, 44));
														jpToolbars.setBackground(Color.WHITE);
															{
																pstuiToolbar = new PathwaySpaceToolbarUI(PathwaySpaceToolbarUI.ZOOM_IN + PathwaySpaceToolbarUI.ZOOM_OUT + PathwaySpaceToolbarUI.DRAG);
																pstuiToolbar.setDefaultMode();
																jpToolbars.add(pstuiToolbar);
																pstuiToolbar.setPreferredSize(new java.awt.Dimension(149, 38));
															}
															{
																votuiToolbar = new ViewOptionsToolbarUI(dsuiDataSourceB.getPsuiViewer(), ViewOptionsToolbarUI.ALL);
																jpToolbars.add(votuiToolbar);
																votuiToolbar.setPreferredSize(new java.awt.Dimension(96, 40));
															}
															{
																mtuiSynchronize = new MergeToolbarUI(MergeToolbarUI.ALL);
																mtuiSynchronize.addMergeToolbarListener(this);
																mtuiSynchronize.setPreferredSize(new java.awt.Dimension(144, 40));
																jpToolbars.add(mtuiSynchronize);
															}
													}
													{
														jpSynchronisationToolbars = new JPanel();
														BorderLayout jpSynchronisationToolbarsLayout = new BorderLayout();
														jpSynchronisationToolbars.setLayout(jpSynchronisationToolbarsLayout);
														jtbViewInterfce.addTab("Use property editors", null, jpSynchronisationToolbars, null);
														jpSynchronisationToolbars.setBackground(Color.WHITE);
															{
																mtuiSynchronize1 = new MergeToolbarUI(MergeToolbarUI.ALL);
																mtuiSynchronize1.addMergeToolbarListener(this);
																mtuiSynchronize1.setPreferredSize(new java.awt.Dimension(144, 40));
																jpSynchronisationToolbars.add(mtuiSynchronize1, BorderLayout.CENTER);
															}
													}
											}
									}
								
							}
						jpFilter.setSorter(dsuiDataSourceA.getSorter());
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
				jspComparativeView.setDividerLocation(jspComparativeView.getWidth() >> 1);
			}
		
		@Override
		public void componentShown(ComponentEvent e)
			{
				
			}
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof DataSourceMerge))
					return;
				dsm = (DataSourceMerge) o;
				dsuiDataSourceA.loadDataSourceMerge(dsm, true, DataSourceMerge.EffectopediaObjectUnion.ALL, readonly);
				dsuiDataSourceA.setTitle(dsm.getA().toString());
				dsuiDataSourceB.loadDataSourceMerge(dsm, false, DataSourceMerge.EffectopediaObjectUnion.ALL, readonly);
				dsuiDataSourceB.setTitle(dsm.getB().toString());
				dsuiDataSourceB.synchronizeWith(dsuiDataSourceA);
				pstuiToolbar.addModes(dsuiDataSourceA.getPsuiViewer().getPahwayScrollPaneUI().getPathwayUI().getModes());
				pstuiToolbar.addModes(dsuiDataSourceB.getPsuiViewer().getPahwayScrollPaneUI().getPathwayUI().getModes());
			}
		
		@Override
		public void stateChanged(ChangeEvent e)
			{
				int viewOptions = jtbViewInterfce.getSelectedIndex();
				if (viewOptions < 0)
					viewOptions = 0;
				viewOptions |= jpFilter.getViewOptions();
				dsuiDataSourceA.setViewOptions(viewOptions);
				dsuiDataSourceB.setViewOptions(viewOptions);
			}
		
		@Override
		public void filterChanged(EventObject evt)
			{
				stateChanged(null);
			}
		
		@Override
		public void actionPerformed(MergeToolbarAction evt)
			{
				if (dsm != null)
					{
						Object o;
						switch (evt.action)
							{
								case MergeToolbarUI.OVERRIDE_SEL_LEFT:
									o = dsuiDataSourceA.getSelectedRawObject();
									if (o instanceof EffectopediaObjectUnion)
										dsm.replaceA((EffectopediaObjectUnion) o);
									break;
								case MergeToolbarUI.OVERRIDE_SEL_RIGHT:
									o = dsuiDataSourceB.getSelectedRawObject();
									if (o instanceof EffectopediaObjectUnion)
										dsm.replaceB((EffectopediaObjectUnion) o);
									break;
								case MergeToolbarUI.OVERRIDE_LEFT:
         dsm.replaceAllA();
									break;
								case MergeToolbarUI.OVERRIDE_RIGHT:
         dsm.replaceAllB();
									break;
							}
					}
			}
		private DataSourceMerge	dsm;
	}

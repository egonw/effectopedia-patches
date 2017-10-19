package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.Effectopedia.DataSourceChange;
import org.qsari.effectopedia.core.Effectopedia.DataSourceChangeListener;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.ui.RedirectionObject;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.HistoricalDS;
import org.qsari.effectopedia.data.RevisionBasedDS;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.go.Layout.LayoutObject;
import org.qsari.effectopedia.gui.core.DataView;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitiveHelpUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.im.InterfaceMode;
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
public class ViewUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, DataSourceLoadableEditorUI, MouseMotionListener, DataSourceChangeListener, RootHelpContext
	{
		/**
		* 
		*/
		private static final long					serialVersionUID	= 1L;
		private JSplitPane												jspPathwaySpace;
		private PathwaySpaceUI								puiPathwaySpace;
		private PathwaySpaceToolbarUI	pstuiToolbar;
		private ViewOptionsToolbarUI		votuiToolbar;
		private JPanel																jpViewer;
		private JPanel																jpToolbars;
		private ElementEditorUI							eeuiElementEditor;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new ViewUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public ViewUI()
			{
				super(null);
				initContextDependedntIDs();
				// DataSource data = Effectopedia.EFFECTOPEDIA.getData();
				// if (data != null)
				// dataView = data.getCurrentView();
				initGUI();
			}
			
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setPreferredSize(new java.awt.Dimension(512, 361));
						this.setName("view");
							{
								jspPathwaySpace = new JSplitPane();
								jspPathwaySpace.setOneTouchExpandable(true);
								jspPathwaySpace.setResizeWeight(0.66);
								
								this.add(jspPathwaySpace, BorderLayout.CENTER);
									{
										eeuiElementEditor = new ElementEditorUI();
										jspPathwaySpace.add(eeuiElementEditor, JSplitPane.RIGHT);
										eeuiElementEditor.setPreferredSize(new java.awt.Dimension(50, 300));
										eeuiElementEditor.setMinimumSize(new java.awt.Dimension(50, 300));
										eeuiElementEditor.addMouseMotionListener(this);
									}
									{
										jpViewer = new JPanel();
										jpViewer.setName("viwer");
										BorderLayout jpViewerLayout = new BorderLayout();
										jpViewer.setLayout(jpViewerLayout);
										jspPathwaySpace.add(jpViewer, JSplitPane.LEFT);
										jpViewer.setPreferredSize(new java.awt.Dimension(341, 298));
										jpViewer.addMouseMotionListener(this);
											
											{
													{
														puiPathwaySpace = new PathwaySpaceUI(rootHelpContext);
														puiPathwaySpace.setElementElditor(eeuiElementEditor);
														puiPathwaySpace.setName("pathwayspace");
														puiPathwaySpace.addMouseMotionListener(this);
														jpViewer.add(puiPathwaySpace, BorderLayout.CENTER);
													}
												jpToolbars = new JPanel();
												jpToolbars.setName("toolbars");
												jpToolbars.addMouseMotionListener(this);
												
												BoxLayout jpToolbarsLayout = new BoxLayout(jpToolbars, javax.swing.BoxLayout.X_AXIS);
												jpToolbars.setLayout(jpToolbarsLayout);
												jpViewer.add(jpToolbars, BorderLayout.NORTH);
													{
														pstuiToolbar = new PathwaySpaceToolbarUI(PathwaySpaceToolbarUI.ALL);
														pstuiToolbar.setName("mode");
														pstuiToolbar.addMouseMotionListener(this);
														jpToolbars.add(pstuiToolbar);
														pstuiToolbar.setPreferredSize(new java.awt.Dimension(500, 40));
													}
													{
														votuiToolbar = new ViewOptionsToolbarUI(puiPathwaySpace, ViewOptionsToolbarUI.ALL);
														votuiToolbar.setName("view");
														votuiToolbar.addMouseMotionListener(this);
														jpToolbars.add(votuiToolbar);
														votuiToolbar.setPreferredSize(new java.awt.Dimension(96, 40));
													}
											}
									}
							}
						if (puiPathwaySpace.getPahwayScrollPaneUI().getPathwayUI().getDataView() != null)
							{
								votuiToolbar.setView(puiPathwaySpace.getPahwayScrollPaneUI().getPathwayUI().getDataView().getViewLayout());
								pstuiToolbar.addModes(puiPathwaySpace.getPahwayScrollPaneUI().getPathwayUI().getModes());
								puiPathwaySpace.setPreferredSize(new java.awt.Dimension(503, 319));
								pstuiToolbar.setDefaultMode();
							}
						Effectopedia.EFFECTOPEDIA.addDataSourceChangeListener(this);
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
			
		public void refresh()
			{
				load(loaded, readonly, dataSource);
				repaint();
			}
			
		@SuppressWarnings("unchecked")
		public void load(Object o, boolean readonly, DataSource ds)
			{
				if (ds != null)
					{
						setDataSource(ds);
						this.dataView = (DataView) ds.getCurrentView();
					}
				this.loaded = o;
				this.readonly = readonly;
				puiPathwaySpace.updateDataSource(ds);
				puiPathwaySpace.load(o, readonly, dataView);
				pstuiToolbar.setReadOnly(readonly);
				pstuiToolbar.setDefaultMode();
				if (this.dataView == null)
					return;
				if (!dataView.areViewAxisInitialized())
					dataView.setDefaultViewAxis();
				else
					dataView.rebuildView();
				dataView.setReadOnly(readonly);
				dataView.getPathwaysView().reset();
				puiPathwaySpace.dataViewChanged(null);
				votuiToolbar.setView(dataView.getViewLayout());
				if (o instanceof Pathway)
					{
						pathway = (Pathway) o;
						dataView.clear();
						dataView.addToView(pathway);
						puiPathwaySpace.scrollTo(pathway.getMIE());
					}
				else if (o instanceof ArrayList)
					{
						dataView.clear();
						for (Object p : (ArrayList<Object>) o)
							if (p instanceof Pathway)
								dataView.addToView((Pathway) p);
					}
				else if (o instanceof RedirectionObject)
					{
						RedirectionObject ro = (RedirectionObject) o;
						dataView.clear();
						if (ro.countParameterObjects() == 0)
							puiPathwaySpace.focusTo(dataView.addToView((PathwayElement) ro.getBase()));
						else
							{
								dataView.addToView((Pathway) ro.getParameterObject(0));
								LayoutObject lo = dataView.getLayoutObjectsMap().get(ro.getBase());
								puiPathwaySpace.focusTo(lo);
							}
					}
				else if (o == null)
					{
						dataView.clear();
						dataView.setReadOnly(false);
						dataView.setHideEmptySegments(false);
						ds.setCreateLive(true);
						Pathway newPathway = DefaultEffectopediaObjects.DEFAULT_PATHWAY.clone(null, ds);
						newPathway.bruteForceToLive();
						dataView.addToView(newPathway);
						this.loaded = newPathway;
						this.readonly = false;
						if (ds instanceof RevisionBasedDS)
							((RevisionBasedDS) ds).setLocation(newPathway.getID(), true);
					}
			}
			
		public void load(Object o, boolean readonly)
			{
				DataSource data;
				if (o instanceof EffectopediaObject)
					{
						data = ((EffectopediaObject) o).getDataSource();
						if (data == null)
							data = Effectopedia.EFFECTOPEDIA.getDataSourceOf((EffectopediaObject) o);
					}
				else
					data = Effectopedia.EFFECTOPEDIA.getData();
				((DataView) data.getCurrentView()).setElementEditor(eeuiElementEditor);
				load(o, readonly, data);
			}
			
		@Override
		public String getComponetHelpContext(MouseEvent e)
			{
				helpID = super.getComponetHelpContext(e);
				// System.out.println(helpID);
				// helpID = ContextSensitiveHelpUI.getComponnetHelpContext(this, e);
				helpID += getContext(helpID);
				ContextSensitiveHelpUI.setCurrentID(helpID);
				return helpID;
			}
			
		protected void initContextDependedntIDs()
			{
				if (contextDependentIDs != null)
					return;
				contextDependentIDs = new HashSet<String>();
				contextDependentIDs.add("view.viwer.pathwayspace.space");
			}
			
		private String getContext(String helpID)
			{
				if (contextDependentIDs.contains(helpID))
					{
						int index = pstuiToolbar.getModeIndex();
						if (index < 0)
							return "";
						InterfaceMode activeMode = pstuiToolbar.getActiveMode();
						return MODE[index] + activeMode.getContext();
					}
				return "";
			}
			
		@Override
		public void dataSourceChanged(DataSourceChange evt)
			{
				DataSource data = Effectopedia.EFFECTOPEDIA.getData();
				if (data instanceof RevisionBasedDS)
					{
						RevisionBasedDS rbData = (RevisionBasedDS) data;
						// if (!EffectopediaUI.frame.getMainUI().visibleTabs[2])
						// EffectopediaUI.frame.getMainUI().makeTabVisible("ViewUI");
						if (rbData.getLocation() != 0)
							load(rbData.getLocationObject(), rbData instanceof HistoricalDS, rbData);
					}
			}
			
		public PathwaySpaceUI getPathwaySpaceUI()
			{
				return puiPathwaySpace;
			}
			
		public PathwaySpaceToolbarUI getPathwaySpaceToolbarUI()
			{
				return pstuiToolbar;
			}
			
		public DataSource getDataSource()
			{
				return dataSource;
			}
			
		public void setDataSource(DataSource dataSource)
			{
				this.dataSource = dataSource;
				puiPathwaySpace.setDataSource(dataSource);
			}
			
		private String																helpID			= "no.help";
		private static final String[]	MODE					=
			{ "-chemical", "-link", "-effect", "-test", "-clet", "-pw", "-cw", "-ucw", "-dcw", "-zi", "-zo", "-drag", "-edit" };
			
		private Object																loaded			= null;
		private boolean															readonly	= false;
		private HashSet<String>							contextDependentIDs;
		protected DataSource										dataSource;
		protected Pathway													pathway;
		protected DataView												dataView;
		
	}

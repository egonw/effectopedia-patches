package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.ui.NoDataView.DataViewChange;
import org.qsari.effectopedia.core.ui.NoDataView.DataViewChangeListener;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.containers.ExtendedGOC;
import org.qsari.effectopedia.go.gui.PathwaysView;
import org.qsari.effectopedia.gui.EffectopediaFrame.EffectopediaFrameChangeListener;
import org.qsari.effectopedia.gui.PathwaysViewUI.ScrollablePathwaySpace;
import org.qsari.effectopedia.gui.comp.ExtendedScrollPane;
import org.qsari.effectopedia.gui.core.DataView;
import org.qsari.effectopedia.gui.core.GUIFactory;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.inspector.ObjectInspectorUI;

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
 * @version 1.0 @(#)PathwaySpaceUI.java 1.0
 * @author Hristo Aladjov
 */

public class PathwayScrollPaneUI extends ExtendedScrollPane implements AdjustableUI, DataViewChangeListener, ComponentListener, EffectopediaFrameChangeListener
	{
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new PathwayScrollPaneUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public PathwayScrollPaneUI(RootHelpContext rootHelpContext)
			{
				super();
				this.rootHelpContext = rootHelpContext;
				initGUI();
			}
			
		public PathwayScrollPaneUI(ObjectInspectorUI objectInspector, ElementEditorUI elementEditor, RootHelpContext rootHelpContext)
			{
				super();
				DataSource data = Effectopedia.EFFECTOPEDIA.getData();
				this.rootHelpContext = rootHelpContext;
				if (data != null)
					{
						dataView = (DataView) data.getCurrentView();
						if (dataView != null)
							{
								dataView.setObjectInspector(objectInspector);
								dataView.setElementEditor(elementEditor);
								dataView.addDataViewChangeListener(this);
							}
					}
				this.objectInspector = objectInspector;
				this.elementEditor = elementEditor;
				initGUI();
			}
			
		public PathwayScrollPaneUI(ObjectInspectorUI objectInspector, ElementEditorUI elementEditor, DataView dataView, RootHelpContext rootHelpContext)
			{
				super();
				this.rootHelpContext = rootHelpContext;
				this.dataView = dataView;
				this.objectInspector = objectInspector;
				this.elementEditor = elementEditor;
				initGUI();
			}
			
		private void initGUI()
			{
				try
					{
						setPreferredSize(new Dimension(400, 300));
						addComponentListener(this);
						getHorizontalScrollBar().addAdjustmentListener(new HorizonatlAction());
						getVerticalScrollBar().addAdjustmentListener(new VerticalAction());
						this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
						this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						this.setWheelScrollingEnabled(true);
							
							{
								puiPathway = new PathwaysViewUI(objectInspector, elementEditor, dataView, rootHelpContext);
								puiPathway.setScrollListener(scroller);
								this.setViewportView(puiPathway);
								puiPathway.setName("space");
								puiPathway.setBackground(Color.white);
							}
							{
								pscfuiPathwaySpaceColumnFooter = new PathwaySpaceHeaderOrFooterUI("column_footer", rootHelpContext);
								pscfuiPathwaySpaceColumnFooter.setPreferredSize(new java.awt.Dimension(400, DefaultGOSettings.footerHeight));
								pscfuiPathwaySpaceColumnFooter.setBackground(new java.awt.Color(128, 255, 0));
								this.setColumnFooterView(pscfuiPathwaySpaceColumnFooter);
							}
							{
								psrhuiPathwaySpaceRowHeader = new PathwaySpaceHeaderOrFooterUI("row_header", rootHelpContext);
								psrhuiPathwaySpaceRowHeader.setPreferredSize(new java.awt.Dimension(DefaultGOSettings.columnHeaderHeight, 600));
								psrhuiPathwaySpaceRowHeader.setBackground(new java.awt.Color(255, 0, 128));
								this.setRowHeaderView(psrhuiPathwaySpaceRowHeader);
								this.setBackground(Color.white);
								this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
							}
							{
								/*
								 * Temporary block
								 */
								if (dataView != null)
									{
										PathwaysView pathwaysView = dataView.getPathwaysView();
										pathwaysView.setUserInterfaceGOCs(pscfuiPathwaySpaceColumnFooter.getHeader(), psrhuiPathwaySpaceRowHeader.getHeader(), this);
										puiPathway.getDataView().addDataViewChangeListener(this);
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
			
		public void addMouseMotionListener(MouseMotionListener l)
			{
				super.addMouseMotionListener(l);
				puiPathway.addMouseMotionListener(l);
				psrhuiPathwaySpaceRowHeader.addMouseMotionListener(l);
				pscfuiPathwaySpaceColumnFooter.addMouseMotionListener(l);
			}
			
		public class HorizonatlAction implements AdjustmentListener
			{
				public void adjustmentValueChanged(AdjustmentEvent ae)
					{
						ae.getValue();
					}
			}
			
		public class VerticalAction implements AdjustmentListener
			{
				public void adjustmentValueChanged(AdjustmentEvent ae)
					{
						ae.getValue();
					}
			}
			
		public class PathwaySpaceScroller implements ScrollablePathwaySpace
			{
				public void scroll(int xShift, int yShift)
					{
						JViewport viewport = getViewport();
						Point viewPosition = viewport.getViewPosition();
						viewPosition.x -= xShift;
						viewPosition.y -= yShift;
						Rectangle visibleRect = viewport.getVisibleRect();
						int maxY = viewport.getViewSize().height - visibleRect.height;
						int maxX = viewport.getViewSize().width - visibleRect.width;
						if (viewPosition.y > maxY)
							viewPosition.y = maxY;
						if (viewPosition.y < 0)
							viewPosition.y = 0;
						if (viewPosition.x > maxX)
							viewPosition.x = maxX;
						if (viewPosition.x < 0)
							viewPosition.x = 0;
						getViewport().setViewPosition(viewPosition);
						getHorizontalScrollBar().repaint();
					}
					
				public void scrollTo(int x, int y)
					{
						JViewport viewport = getViewport();
						Point viewPosition = viewport.getViewPosition();
						Rectangle2D visibleRect = viewport.getVisibleRect();
						if (visibleRect.getWidth() != 0)
							{
								viewPosition.x = x - (int) visibleRect.getWidth() / 2;
								viewPosition.y = y - (int) visibleRect.getHeight() / 2;
								int maxY = viewport.getViewSize().height - (int) visibleRect.getHeight();
								int maxX = viewport.getViewSize().width - (int) visibleRect.getWidth();
								if (viewPosition.y > maxY)
									viewPosition.y = maxY;
								if (viewPosition.y < 0)
									viewPosition.y = 0;
								if (viewPosition.x > maxX)
									viewPosition.x = maxX;
								if (viewPosition.x < 0)
									viewPosition.x = 0;
								getViewport().setViewPosition(viewPosition);
								getHorizontalScrollBar().repaint();
							}
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
			
		public PathwaysViewUI getPathwayUI()
			{
				return puiPathway;
			}
			
		public PathwaySpaceHeaderOrFooterUI getPathwaySpaceColumnFooterUI()
			{
				return pscfuiPathwaySpaceColumnFooter;
			}
			
		public PathwaySpaceHeaderOrFooterUI getPathwaySpaceRowHeaderUI()
			{
				return pscfuiPathwaySpaceColumnFooter;
			}
			
		public ObjectInspectorUI getObjectInspector()
			{
				return objectInspector;
			}
			
		public void setObjectInspector(ObjectInspectorUI objectInspector)
			{
				this.objectInspector = objectInspector;
			}
			
		public void dataViewChanged(DataViewChange evt)
			{
				pscfuiPathwaySpaceColumnFooter.updatePrefferedSize();
				psrhuiPathwaySpaceRowHeader.updatePrefferedSize();
				revalidate();
				repaint();
			}
			
		public void setDataView(DataView dataView)
			{
				if (this.dataView != null)
					dataView.removeDataViewChangeListener(this);
				this.dataView = dataView;
				if (dataView != null)
					{
						PathwaysView pathwaysView = dataView.getPathwaysView();
						pathwaysView.setUserInterfaceGOCs(pscfuiPathwaySpaceColumnFooter.getHeader(), psrhuiPathwaySpaceRowHeader.getHeader(), this);
						dataViewChanged(null);
						dataView.addDataViewChangeListener(this);
						if (GUIFactory.GUI != null)
							GUIFactory.GUI.getFrame().addEffectopediaFrameChangeListener(this);
						puiPathway.setDataView(dataView);
					}
			}
			
		public final DataView getDataView()
			{
				return dataView;
			}
			
		public void frameChanged(EventObject evt)
			{
				GUIFactory.GUI.getFrame().getGraphics().setPaintMode();
				ExtendedGOC.resetActiveLayer(puiPathway.getDataView().getViewLayout().getGlobalGOC());
			}
			
		public void componentResized(ComponentEvent e)
			{
				ExtendedGOC.resetActiveLayer(puiPathway.getDataView().getViewLayout().getGlobalGOC());
				this.dataView.setViewHeightAndWidth(getWidth(), getHeight());
			}
			
		public void componentHidden(ComponentEvent arg0)
			{
			}
			
		@Override
		public void componentMoved(ComponentEvent arg0)
			{
			}
			
		@Override
		public void componentShown(ComponentEvent arg0)
			{
			}
			
		public PathwaySpaceScroller getScroller()
			{
				return scroller;
			}
			
		public void updateDataSource(DataSource dataSource)
			{
				puiPathway.updateDataSource(dataSource);
			}
			
		public BufferedImage getAsImage()
			{
				Graphics2D canvas;
				try
					{
						BufferedImage pathwayViewImage = new BufferedImage(getSpaceWidth(), getSpaceHeight(), BufferedImage.TYPE_INT_ARGB);
						canvas = pathwayViewImage.createGraphics();
						puiPathway.paintComponent(canvas);
						BufferedImage horizontalAxisImage = new BufferedImage(pscfuiPathwaySpaceColumnFooter.getWidth(), pscfuiPathwaySpaceColumnFooter.getHeight(), BufferedImage.TYPE_INT_ARGB);
						canvas = horizontalAxisImage.createGraphics();
						pscfuiPathwaySpaceColumnFooter.paint(canvas);
						BufferedImage verticalAxisImage = new BufferedImage(psrhuiPathwaySpaceRowHeader.getWidth(), psrhuiPathwaySpaceRowHeader.getHeight(), BufferedImage.TYPE_INT_ARGB);
						canvas = verticalAxisImage.createGraphics();
						psrhuiPathwaySpaceRowHeader.paint(canvas);
						
						BufferedImage bImage = new BufferedImage(puiPathway.getWidth() + psrhuiPathwaySpaceRowHeader.getWidth(), puiPathway.getHeight() + pscfuiPathwaySpaceColumnFooter.getHeight(),
								BufferedImage.TYPE_INT_ARGB);
						canvas = bImage.createGraphics();
						canvas.drawImage(verticalAxisImage, 0, 0, null);
						canvas.drawImage(pathwayViewImage, verticalAxisImage.getWidth(), 0, null);
						canvas.drawImage(horizontalAxisImage, verticalAxisImage.getWidth(), pathwayViewImage.getHeight(), null);
						return bImage;
					}
				catch (OutOfMemoryError e)
					{
						UserInterface.showError("Out of heap memory when trying to create the new image file. Please zoom out and try again");
						return null;
					}
					
			}
			
		public void exportToSVG(StringBuilder base, StringBuilder pathwayElementsGroup)
			{
				
				base.append("<g transform=\"translate(32 0)\" id=\"PathwaySpaceProjection\">\n");
				puiPathway.exportToSVG(base, pathwayElementsGroup);
				base.append("</g>\n");
				
				base.append("<g transform=\"translate(32 ");
				base.append(getSpaceHeight() + 1);
				base.append(")\" id=\"X_Axis_Labels\">\n");
				pscfuiPathwaySpaceColumnFooter.exportToSVG(base, pathwayElementsGroup);
				base.append("</g>\n");
				
				base.append("<g id=\"Y_Axis_Labels\">\n");
				psrhuiPathwaySpaceRowHeader.exportToSVG(base, pathwayElementsGroup);
				base.append("</g>\n");
			}
			
		public int getSpaceWidth()
			{
				int w = puiPathway.getWidth();
				return (w != 0) ? w : puiPathway.getPathwaySpace().getPathwaysView().getViewLayout().getWidth();
			}
			
		public int getSpaceHeight()
			{
				int h = puiPathway.getHeight();
				return (h != 0) ? h : puiPathway.getPathwaySpace().getPathwaysView().getViewLayout().getHeight();
			}
			
		public ElementEditorUI getElementEditor()
			{
				return elementEditor;
			}
			
		public void setElementEditor(ElementEditorUI elementEditor)
			{
				this.elementEditor = elementEditor;
				puiPathway.setElementEditor(elementEditor);
			}
			
		public DataSource getDataSource()
			{
				return dataSource;
			}
			
		public void setDataSource(DataSource dataSource)
			{
				this.dataSource = dataSource;
				puiPathway.setDataSource(dataSource);
			}
			
		private PathwaySpaceScroller									scroller	= new PathwaySpaceScroller();
		private DataSource																			dataSource;
		private DataView																					dataView;
		private ObjectInspectorUI												objectInspector;
		private ElementEditorUI														elementEditor;
		private PathwaysViewUI															puiPathway;
		private PathwaySpaceHeaderOrFooterUI	pscfuiPathwaySpaceColumnFooter;
		private PathwaySpaceHeaderOrFooterUI	psrhuiPathwaySpaceRowHeader;
		private RootHelpContext														rootHelpContext;
	}

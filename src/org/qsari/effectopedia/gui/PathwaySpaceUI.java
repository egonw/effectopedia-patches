package org.qsari.effectopedia.gui;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.core.ui.NoDataView.DataViewChange;
import org.qsari.effectopedia.core.ui.NoDataView.DataViewChangeListener;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.SVGUtils;
import org.qsari.effectopedia.go.Layout.LayoutObject;
import org.qsari.effectopedia.gui.core.DataView;
import org.qsari.effectopedia.gui.core.GUIFactory;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.inspector.ObjectInspectorUI;
import org.qsari.effectopedia.gui.util.ScrollPaneSynchronizer;

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
public class PathwaySpaceUI extends ContextSensitivePanel implements LoadableEditorUI, DataViewChangeListener
	{
		
		/**
		 * s
		 * 
		 */
		private static final long serialVersionUID = -4556722120178664278L;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new PathwaySpaceUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public PathwaySpaceUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				dataSource = Effectopedia.EFFECTOPEDIA.getData();
				if (dataSource != null)
					{
						dataView = (DataView) dataSource.getCurrentView();
						dataView.addDataViewChangeListener(this);
					}
				initGUI();
			}
			
		public PathwaySpaceUI(ObjectInspectorUI objectInspector, ElementEditorUI elementEditor, DataView dataView, RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				if (dataView == null)
					{
						dataSource = Effectopedia.EFFECTOPEDIA.getData();
						if (dataSource != null)
							{
								dataView = (DataView) dataSource.getCurrentView();
								dataView.addDataViewChangeListener(this);
							}
					}
				else
					{
						this.dataView = dataView;
						dataView.addDataViewChangeListener(this);
					}
				this.objectInspector = objectInspector;
				this.elementElditor = elementEditor;
				initGUI();
				if (GUIFactory.GUI != null)
					setDataView(dataView);
			}
			
		private void initGUI()
			{
				try
					{
						setPreferredSize(new Dimension(400, 300));
						GridBagLayout thisLayout = new GridBagLayout();
						this.setPreferredSize(new java.awt.Dimension(350, 300));
						this.setMinimumSize(new java.awt.Dimension(100, 300));
						thisLayout.rowWeights = new double[]
							{ 0.1, 0.0 };
						thisLayout.rowHeights = new int[]
							{ 16, 16 };
						thisLayout.columnWeights = new double[]
							{ 0.0, 0.1 };
						thisLayout.columnWidths = new int[]
							{ 16, 16 };
						this.setLayout(thisLayout);
						this.setBackground(new java.awt.Color(245, 245, 245));
							{
								pspuiPathwayScrollPane = new PathwayScrollPaneUI(objectInspector, elementElditor, dataView, rootHelpContext);
								this.add(pspuiPathwayScrollPane, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
								// pspuiPathwayScrollPane.setEnabled(false);
								// pspuiPathwayScrollPane.setOpaque(false);
							}
							{
								psauiHorizontalAxis = new PathwaySpaceAxisUI(rootHelpContext);
								// psauiHorizontalAxis.setName("horizontal_axis");
								this.add(psauiHorizontalAxis, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
							}
							{
								psauiVerticalAxis = new PathwaySpaceAxisUI(false, rootHelpContext);
								this.add(psauiVerticalAxis, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
								// / psauiVerticalAxis.setName("vertical_axis");
								
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
				if (pspuiPathwayScrollPane != null)
					pspuiPathwayScrollPane.addMouseMotionListener(l);
				if (psauiVerticalAxis != null)
					psauiVerticalAxis.addMouseMotionListener(l);
				if (psauiHorizontalAxis != null)
					psauiHorizontalAxis.addMouseMotionListener(l);
			}
			
		public PathwaySpaceAxisUI getHorizontalAxis()
			{
				return psauiHorizontalAxis;
			}
			
		public PathwaySpaceAxisUI getVerticalAxis()
			{
				
				return psauiVerticalAxis;
			}
			
		public PathwayScrollPaneUI getPahwayScrollPaneUI()
			{
				return pspuiPathwayScrollPane;
			}
			
		public void focusTo(LayoutObject lo)
			{
				if (lo != null)
					{
						GraphicObject go = lo.getGo();
						go.setSelected(true);
						pspuiPathwayScrollPane.getScroller().scrollTo(go.getMidX(), go.getMidY());
					}
			}
			
		public void scrollTo(PathwayElement pe)
			{
				if (pe != null)
					{
						LayoutObject lo = dataView.getLayoutObjectForElement(pe);
						if (lo != null)
							pspuiPathwayScrollPane.getScroller().scrollTo(lo.getMidX(), lo.getMidY());
					}
			}
			
		public void dataViewChanged(DataViewChange evt)
			{
				psauiHorizontalAxis.setDimension(dataView.getHorizontalDimension());
				psauiVerticalAxis.setDimension(dataView.getVerticalDimension());
			}
			
		public void load(Object o, boolean readonly)
			{
				if (o == null)
					return;
				if (o instanceof EffectopediaObject)
					{
						DataSource dataSource = Effectopedia.EFFECTOPEDIA.getDataSourceOf((EffectopediaObject) o);
						if (dataSource != null)
							{
								DataView dataView = (DataView) dataSource.getCurrentView();
								setDataView(dataView);
								dataView.clear();
								dataView.setReadOnly(true);
								dataView.setHideEmptySegments(true);
								if (o instanceof Pathway)
									dataView.addToView((Pathway) o);
								else if (o instanceof Link)
									{
										Link link = (Link) o;
										LayoutObject lo = dataView.addToView(link);
										if (link.hasIncommingAssociations())
											{
												PathwayElement pe = link.incommingAssociations()[0];
												dataView.addToView(pe);
												dataView.createArc(pe, link);
											}
										if (link.hasOutgoingAssociations())
											{
												PathwayElement pe = link.outgoingAssociations()[0];
												dataView.addToView(pe);
												dataView.createArc(link, pe);
											}
										focusTo(lo);
									}
								else if (o instanceof TestResponseMapping)
									{
										TestResponseMapping trm = (TestResponseMapping) o;
										LayoutObject lo = null;
										if (trm.hasIncommingMappings())
											{
												PathwayElement pe = trm.incommingMappings()[0];
												dataView.addToView(pe);
												lo = dataView.addToView(trm);
												dataView.createArc(pe, trm);
											}
										if (trm.hasOutgoingMappings())
											{
												PathwayElement pe = trm.outgoingMappings()[0];
												dataView.addToView(pe);
												if (lo == null)
													lo = dataView.addToView(trm);
												dataView.createArc(trm, pe);
											}
											
										focusTo(lo);
									}
								else if (o instanceof PathwayElement)
									focusTo(dataView.addToView((PathwayElement) o));
								// else if (((EffectopediaObject) o).getParent()!=null)
								// load(((EffectopediaObject) o).getParent(), readonly);
							}
					}
			}
			
		public void load(Object o, boolean readonly, DataView dv)
			{
				if ((o == null) && (dataView != null))
					dataView.clear();
				if (dv != null)
					setDataView(dv);
			}
			
		public final void setDataView(DataView dataView)
			{
				this.dataView = dataView;
				pspuiPathwayScrollPane.setDataView(dataView);
			}
			
		public void synchronizeWith(PathwaySpaceUI withInterface)
			{
				ScrollPaneSynchronizer synchronizer = new ScrollPaneSynchronizer(pspuiPathwayScrollPane, withInterface.getPahwayScrollPaneUI());
				pspuiPathwayScrollPane.getVerticalScrollBar().addAdjustmentListener(synchronizer);
				pspuiPathwayScrollPane.getHorizontalScrollBar().addAdjustmentListener(synchronizer);
				withInterface.getPahwayScrollPaneUI().getVerticalScrollBar().addAdjustmentListener(synchronizer);
				withInterface.getPahwayScrollPaneUI().getHorizontalScrollBar().addAdjustmentListener(synchronizer);
			}
			
		public void exportAsPNGImageFile(String fileName)
			{
				revalidate();
				repaint();
				File imgFile = new File(fileName);
				Graphics2D canvas;
				BufferedImage pathwayViewImage = pspuiPathwayScrollPane.getAsImage();
				if (pathwayViewImage == null)
					return;
				BufferedImage bImage = new BufferedImage(pathwayViewImage.getWidth() + 16, pathwayViewImage.getHeight() + 16, BufferedImage.TYPE_INT_ARGB);
				canvas = bImage.createGraphics();
				psauiVerticalAxis.draw(canvas, 0, 0, 16, pathwayViewImage.getHeight() + 16);
				psauiHorizontalAxis.draw(canvas, 0, pathwayViewImage.getHeight(), pathwayViewImage.getWidth() + 16, 16);
				canvas.drawImage(pathwayViewImage, 16, 0, null);
				try
					{
						ImageIO.write(bImage, "png", imgFile);
					}
				catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
		public String exportAsSVGImage()
			{
				revalidate();
				repaint();
				StringBuilder base = new StringBuilder();
				StringBuilder pathwayLayer = new StringBuilder();
				int totalHeight = (pspuiPathwayScrollPane.getSpaceHeight() + 32);
				int totalWidth = (pspuiPathwayScrollPane.getSpaceWidth() + 32);
				base.append(SVGUtils.SVG_Header);
				base.append("width=\"" + totalWidth + "\" height=\"" + totalHeight + "\">\n");
				base.append(SVGUtils.SVG_Defs);
				base.append("<g id=\"PathwaySpace\">\n");
				pspuiPathwayScrollPane.exportToSVG(base, pathwayLayer);
				base.append("</g>\n");
				base.append("<g transform=\"translate(32 0)\" id=\"PathwayLayer\">\n");
				base.append(pathwayLayer);
				base.append("</g>\n");
				psauiVerticalAxis.exportToSVG(base, 0, 0, 16, totalHeight);
				psauiHorizontalAxis.exportToSVG(base, 0, totalHeight - 16, totalWidth, 16);
				base.append("</svg>");
				return base.toString();
			}
			
		public void exportAsSVGImageFile(String fileName)
			{
				String[] lines = exportAsSVGImage().split("\\n");
				try
					{
						Path filePath = Paths.get(fileName);
						Files.deleteIfExists(filePath);
						Files.write(filePath, Arrays.asList(lines), Charset.forName("UTF-8"), StandardOpenOption.CREATE);
					}
				catch (IOException e)
					{
					}
			}
			
		public String getContext()
			{
				return "";
			}
			
		public void updateDataSource(DataSource dataSource)
			{
				pspuiPathwayScrollPane.updateDataSource(dataSource);
			}
			
		public ObjectInspectorUI getObjectInspector()
			{
				return objectInspector;
			}
			
		public void setObjectInspector(ObjectInspectorUI objectInspector)
			{
				this.objectInspector = objectInspector;
			}
			
		public ElementEditorUI getElementElditor()
			{
				return elementElditor;
			}
			
		public void setElementElditor(ElementEditorUI elementEditor)
			{
				this.elementElditor = elementEditor;
				pspuiPathwayScrollPane.setElementEditor(elementEditor);
			}
			
		public DataSource getDataSource()
			{
				return dataSource;
			}
			
		public void setDataSource(DataSource dataSource)
			{
				this.dataSource = dataSource;
				pspuiPathwayScrollPane.setDataSource(dataSource);
			}
			
		private DataSource										dataSource;
		private DataView												dataView;
		private ObjectInspectorUI			objectInspector;
		private ElementEditorUI					elementElditor;
		private PathwaySpaceAxisUI		psauiVerticalAxis;
		private PathwaySpaceAxisUI		psauiHorizontalAxis;
		private PathwayScrollPaneUI	pspuiPathwayScrollPane;
		
	}

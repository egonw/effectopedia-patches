package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.ContextDimension;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.SVGUtils;
import org.qsari.effectopedia.gui.core.DataView;
import org.qsari.effectopedia.gui.core.GUIFactory;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;

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
public class PathwaySpaceAxisUI extends ContextSensitivePanel
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= -4429887156179030651L;
		private Axis														axis;
		private JPopupMenu								jpmDimensions;
		private ButtonGroup							group;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new PathwaySpaceAxisUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public PathwaySpaceAxisUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				horizontal = true;
				initGUI();
			}
		
		public PathwaySpaceAxisUI(boolean horizontal,RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				this.horizontal = horizontal;
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						Dimension dimension = horizontal ? new java.awt.Dimension(400, 16) : new java.awt.Dimension(16, 400);
						this.setPreferredSize(dimension);
						this.setSize(dimension);
						this.setBackground(DefaultGOSettings.headerColor);
							{
								axis = new Axis();
								this.add(axis, BorderLayout.CENTER);
								initPopupMenu();
								
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		private void initPopupMenu()
			{
				jpmDimensions = new JPopupMenu();
				group = new ButtonGroup();
				setComponentPopupMenu(axis, jpmDimensions);
				if (Effectopedia.EFFECTOPEDIA.getData() == null)
					return;
				List<ContextDimension> dimensions = DefaultEffectopediaObjects.DEFAULT_CONTEXT.getDimensions();
				for (ContextDimension d : dimensions)
					{
						Action action = new AxicCaptionAction(d.getName(), d);
						JRadioButtonMenuItem item = new JRadioButtonMenuItem(action);
						jpmDimensions.add(item);
						group.add(item);
					}
			}
		
		public class Axis extends Canvas
			{
				/**
			 * 
			 */
				private static final long	serialVersionUID	= -8026898693750607509L;
				
				public void paint(Graphics g)
					{
						Graphics2D canvas = (Graphics2D) g;
						int width = canvas.getClipBounds().width;
						int height = canvas.getClipBounds().height;
						if (horizontal)
							drawHorizontalAxis(canvas, getX(), getY(), width, height);
						else
							drawVerticalAxis(canvas, getX(), getY(), width, height);
					}
				
				public void drawHorizontalAxis(Graphics2D canvas, int x, int y, int width, int height)
					{
						canvas.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
						canvas.setColor(textColor);
						if (caption == null)
							return;
						FontRenderContext context = canvas.getFontRenderContext();
						Rectangle2D bounds = axisCaptionFont.getStringBounds(caption, context);
						int lineWidth = (int) bounds.getWidth();
						int maxSymbolsDispalyed = (width * caption.length()) / lineWidth;
						if (maxSymbolsDispalyed < 2)
							return;
						String txt = (lineWidth > width) ? (caption.substring(0, maxSymbolsDispalyed - 1) + "...") : caption;
						canvas.setFont(axisCaptionFont);
						bounds = axisCaptionFont.getStringBounds(txt, context);
						int xc = (int) (x + (width - bounds.getWidth()) / 2);
						int yc = (int) (y + (getHeight() - bounds.getHeight()) / 2);
						canvas.drawString(txt, xc, (int) (yc - bounds.getY()));
						yc += (int) (bounds.getHeight() / 2);
						canvas.drawLine(height - 8, 0, height - 8, height);
						canvas.drawLine(x, yc, xc - 4, yc);
						canvas.drawLine(xc + (int) bounds.getWidth() + 4, yc, x + width - 10, yc);
						Polygon poly = new Polygon();
						poly.addPoint(x + width - 10, yc - 4);
						poly.addPoint(x + width - 6, yc);
						poly.addPoint(x + width - 10, yc + 4);
						canvas.draw(poly);
					}
				
				public void drawVerticalAxis(Graphics2D canvas, int x, int y, int width, int height)
					{
						canvas.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
						canvas.setColor(textColor);
						if (caption == null)
							return;
						AffineTransform oldAT = canvas.getTransform();
						FontRenderContext context = canvas.getFontRenderContext();
						Rectangle2D bounds = axisCaptionFont.getStringBounds(caption, context);
						int lineWidth = (int) bounds.getWidth();
						int maxSymbolsDispalyed = (height * caption.length()) / lineWidth;
						if (maxSymbolsDispalyed < 2)
							return;
						String txt = (lineWidth > height) ? (caption.substring(0, maxSymbolsDispalyed - 1) + "...") : caption;
						canvas.setFont(axisCaptionFont);
						bounds = axisCaptionFont.getStringBounds(txt, context);
						int xc = x + (int) (-height - bounds.getWidth()) / 2;
						int yc = y + (int) (width - bounds.getY() - 4) / 2;
						canvas.rotate(-Math.PI / 2.0, x, y);
						canvas.drawString(txt, (int) (xc), (int) (yc));
						canvas.setTransform(oldAT);
						xc = 1 + x + (int) (bounds.getHeight()) / 2;
						yc = y + (int) (height - bounds.getWidth()) / 2;
						canvas.drawLine(xc, 8, xc, yc - 4);
						canvas.drawLine(xc, yc + (int) bounds.getWidth() + 4, xc, height);
						Polygon poly = new Polygon();
						poly.addPoint(xc, 4);
						poly.addPoint(xc + 4, 8);
						poly.addPoint(xc - 4, 8);
						canvas.draw(poly);
					}
				
				public void addHorizontalAxis(StringBuilder sb, int x, int y, int width, int height)
					{
						Graphics2D canvas = ((Graphics2D) GUIFactory.GUI.getFrame().getGraphics());
						FontRenderContext context = canvas.getFontRenderContext();
						Rectangle2D bounds = axisCaptionFont.getStringBounds(caption, context);
						int lineWidth = (int) bounds.getWidth();
						int maxSymbolsDispalyed = (width * caption.length()) / lineWidth;
						if (maxSymbolsDispalyed < 2)
							return;
						String txt = (lineWidth > width) ? (caption.substring(0, maxSymbolsDispalyed - 1) + "...") : caption;
						canvas.setFont(axisCaptionFont);
						bounds = axisCaptionFont.getStringBounds(txt, context);
						int xc = (int) (x + (width - bounds.getWidth()) / 2);
						int yc = (int) (y + (getHeight() - bounds.getHeight()) / 2);
						SVGUtils.addCentredCaption(txt, sb, x, y, width, height, textColor);
						yc += (int) (bounds.getHeight() / 2);
						SVGUtils.addLine(sb, height - 8, 0, height - 8, height, textColor, 1);
						SVGUtils.addLine(sb, x, yc, xc - 4, yc, textColor, 1);
						SVGUtils.addLine(sb, xc + (int) bounds.getWidth() + 4, yc, x + width - 10, yc, textColor, 1);

						SVGUtils.addPathOpeningTag(sb, textColor, 1);
						SVGUtils.addPathMoveCommand(sb, x + width - 10, yc - 4); 
						SVGUtils.addPathLineCommand(sb,x + width - 6, yc);
						SVGUtils.addPathLineCommand(sb,x + width - 10, yc + 4);
						sb.append(" z\" />\n");
					}
				
				public void addVerticalAxis(StringBuilder sb, int x, int y, int width, int height)
					{
						Graphics2D canvas = ((Graphics2D) GUIFactory.GUI.getFrame().getGraphics());
						canvas.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
						canvas.setColor(textColor);
						if (caption == null)
							return;
						FontRenderContext context = canvas.getFontRenderContext();
						Rectangle2D bounds = axisCaptionFont.getStringBounds(caption, context);
						int lineWidth = (int) bounds.getWidth();
						int maxSymbolsDispalyed = (height * caption.length()) / lineWidth;
						if (maxSymbolsDispalyed < 2)
							return;
						String txt = (lineWidth > height) ? (caption.substring(0, maxSymbolsDispalyed - 1) + "...") : caption;
						canvas.setFont(axisCaptionFont);
						bounds = axisCaptionFont.getStringBounds(txt, context);
						int xc = x + (int) (-height - bounds.getWidth()) / 2;
						int yc = y + (int) (width - bounds.getY() - 4) / 2;
						SVGUtils.addCentredVerticalCaption(txt, sb, x+4, y, width, height, textColor);
						xc = 1 + x + (int) (bounds.getHeight()) / 2;
						yc = y + (int) (height - bounds.getWidth()) / 2;
						SVGUtils.addLine(sb, xc, 8, xc, yc - 4,textColor,1);
						SVGUtils.addLine(sb, xc, yc + (int) bounds.getWidth() + 4, xc, height,textColor,1);
						SVGUtils.addPathOpeningTag(sb, textColor, 1);
						SVGUtils.addPathMoveCommand(sb, xc, 4); 
						SVGUtils.addPathLineCommand(sb,xc + 4, 8);
						SVGUtils.addPathLineCommand(sb,xc - 4, 8);
						sb.append(" z\" />\n");
					}
				
			}
		
		public class AxicCaptionAction extends AbstractAction
			{
				/**
		 * 
		 */
				private static final long	serialVersionUID	= 1L;
				
				public AxicCaptionAction(String actionName, ContextDimension dimension)
					{
						putValue(Action.NAME, actionName);
						this.dimension = dimension;
					}
				
				public void actionPerformed(ActionEvent event)
					{
						caption = (String) getValue(Action.NAME);
						axis.repaint();
						DataView dataView = (DataView)Effectopedia.EFFECTOPEDIA.getData().getCurrentView();
						if (!dataView.areViewAxisInitialized())
							dataView.setDefaultViewAxis();
						dataView.setViewAxis(horizontal ? dimension : dataView.getHorizontalDimension(), horizontal ? dataView.getVerticalDimension() : dimension);
						getParent().repaint();
					}
				
				private ContextDimension	dimension;
			}
		
		private void setComponentPopupMenu(final java.awt.Component parent, final javax.swing.JPopupMenu menu)
			{
				parent.addMouseListener(new java.awt.event.MouseAdapter()
					{
						public void mousePressed(java.awt.event.MouseEvent e)
							{
								
							}
						
						public void mouseReleased(java.awt.event.MouseEvent e)
							{
								menu.show(parent, e.getX(), e.getY());
							}
					});
			}
		
		public void setDimension(ContextDimension dimension)
			{
				if (dimension != null)
					{
						List<ContextDimension> dimensions = DefaultEffectopediaObjects.DEFAULT_CONTEXT.getDimensions();
						dimensionIndex = dimensions.indexOf(dimension);
						caption = dimension.getName();
						JRadioButtonMenuItem item = (JRadioButtonMenuItem) jpmDimensions.getComponent(dimensionIndex);
						item.setSelected(true);
					}
			}
		
		public void draw(Graphics2D canvas, int x, int y, int width, int height)
			{
				if (horizontal)
					axis.drawHorizontalAxis(canvas, x, y, width, height);
				else
					axis.drawVerticalAxis(canvas, x, y, width, height);
			}
		
		
		public void exportToSVG(StringBuilder sb, int x, int y, int width, int height)
			{
				if (horizontal)
					axis.addHorizontalAxis(sb,x,y,width,height);
				else
					axis.addVerticalAxis(sb,x,y,width,height);
			}
		
		public final boolean	horizontal;
		protected String					caption;
		protected int								dimensionIndex;
		protected Color						textColor							= DefaultGOSettings.captionColor;
		protected Font							axisCaptionFont	= DefaultGOSettings.captionFont;
		
	}

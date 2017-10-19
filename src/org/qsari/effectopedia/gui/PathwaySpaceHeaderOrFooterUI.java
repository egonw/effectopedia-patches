package org.qsari.effectopedia.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.SVGExportable;
import org.qsari.effectopedia.go.Layout.LayoutObjectsContainer;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;

public class PathwaySpaceHeaderOrFooterUI extends ContextSensitivePanel implements AdjustableUI, SVGExportable
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
				frame.getContentPane().add(new PathwaySpaceHeaderOrFooterUI("test",null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public PathwaySpaceHeaderOrFooterUI(String componentName,RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName(componentName);
				header = new LayoutObjectsContainer();
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						setPreferredSize(new Dimension(header.getWidth(), header.getHeight()));
						this.addMouseListener(new MouseAdapter()
							{
								public void mouseClicked(MouseEvent evt)
									{
										GraphicObject go = header.getGo().isOver(evt);
										if (go != null)
											{
												go.setSelected(!go.isSelected());
												repaint(go.getX() - 2, go.getY() - 2, go.getWidth() + 4, go.getHeight() + 4);
											}
										else
											{
												header.getGo().setSelected(false);
												repaint();
											}
									}
							});
						this.addMouseMotionListener(new MouseMotionAdapter()
							{
								public void mouseMoved(MouseEvent evt)
									{
										GraphicObject go = header.getGo().isOver(evt);
										GraphicObject lgo = header.getGo().getLastGO();
										if (lgo != null)
											{
												repaint(lgo.getX() - 2, lgo.getY() - 2, lgo.getWidth() + 4, lgo.getHeight() + 4);
												lgo.setActive(lgo == go);
											}
										if (go != null)
											repaint(go.getX() - 2, go.getY() - 2, go.getWidth() + 4, go.getHeight() + 4);
									}
							});
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public void paintComponent(Graphics g)
			{
				Graphics2D canvas = (Graphics2D) g;
				GraphicObject go = header.getGo();
				if (go != null)
					go.draw(canvas);
			}

		public void exportToSVG(StringBuilder base,StringBuilder pathwayElementsGroup)
			{
				GraphicObject go = header.getGo();
				if (go != null)
					go.exportToSVG(base,pathwayElementsGroup);
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
		
		public LayoutObjectsContainer getHeader()
			{
				return this.header;
			}
		
		public void updatePrefferedSize()
			{
				setPreferredSize(new Dimension(header.getWidth(), header.getHeight()));
			}
		
		private LayoutObjectsContainer	header;

	}

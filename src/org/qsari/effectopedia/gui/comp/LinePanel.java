package org.qsari.effectopedia.gui.comp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class LinePanel extends JPanel
	{
		/**
	 * 
	 */
		private static final long			serialVersionUID	= 1L;
		/**
	 * 
	 */
		public static final int					N																= 1;
		public static final int					E																= 2;
		public static final int					S																= 4;
		public static final int					W																= 8;
		public static final int					AN															= 16;
		public static final int					AE															= 32;
		public static final int					AS															= 64;
		public static final int					AW															= 128;
		
		public static final int					NS															= N | S;
		public static final int					EW															= E | W;
		public static final int					NArrow											= AN | N | S;
		public static final int					SArrow											= AS | N | S;
		public static final int					EArrow											= AE | E | W;
		public static final int					WArrow											= AW | E | W;
		public static final int					CROSS												= N | E | S | W;
		
		public static final int					ALL														= 255;
		
		public static final int[][]	NORTH_ARROW						= new int[][]
																																																{
																																																	{ NArrow } };
		public static final int[][]	SOUTH_ARROW						= new int[][]
																																																{
																																																	{ SArrow } };
		public static final int[][]	EAST_ARROW							= new int[][]
																																																{
																																																	{ EArrow } };
		public static final int[][]	WEST_ARROW							= new int[][]
																																																{
																																																	{ WArrow } };
		public static final int[][]	HLINE												= new int[][]
																																																{
																																																	{ EW } };
		public static final int[][]	VLINE												= new int[][]
																																																{
																																																	{ NS } };
		public static final int[][]	NE_CORNER								= new int[][]
																																																{
																																																	{ N | E } };
		public static final int[][]	SE_CORNER								= new int[][]
																																																{
																																																	{ S | E } };
		public static final int[][]	SW_CORNER								= new int[][]
																																																{
																																																	{ S | W } };
		public static final int[][]	NW_CORNER								= new int[][]
																																																{
																																																	{ N | W } };
		
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new LinePanel());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public LinePanel()
			{
				super();
				initGUI();
			}
		
		public LinePanel(int[][] lineMap)
			{
				
				super();
				this.lineMap = lineMap;
				initGUI();
			}
		
		private void initGUI()
			{
					{
						this.setBackground(Color.white);
						this.setPreferredSize(new java.awt.Dimension(30, 90));
					}
				
			}
		
		protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				Graphics2D canvas = (Graphics2D) g;
				if (lineMap != null)
					{
						canvas.setStroke(lineStroke);
						canvas.setColor(lineColor);
						xSize = lineMap[0].length;
						ySize = lineMap.length;
						int w = getWidth();
						int h = getHeight();
						int yOffset = h;
						int xNodeLength = w / xSize;
						int yNodeLength = h / ySize;
						xLineHalfLength = xNodeLength >> 1;
						yLineHalfLength = yNodeLength >> 1;
						for (int j = ySize - 1; j >= 0; j--)
							{
								int xOffset = w;
								yOffset -= yNodeLength;
								for (int i = xSize - 1; i >= 0; i--)
									{
										xOffset -= xNodeLength;
										paintGridNode(xOffset, yOffset, lineMap[j][i], canvas);
									}
								
							}
					}
			}
		
		public void paintGridNode(int xOffset, int yOffset, int code, Graphics2D canvas)
			{
				int xCenter = xOffset + xLineHalfLength;
				int yCenter = yOffset + yLineHalfLength;
				int xEdge = xCenter + xLineHalfLength;
				int yEdge = yCenter + yLineHalfLength;
				if ((code & N) != 0)
					canvas.drawLine(xCenter, yOffset, xCenter, yCenter);
				if ((code & S) != 0)
					canvas.drawLine(xCenter, yCenter, xCenter, yEdge);
				if ((code & E) != 0)
					canvas.drawLine(xCenter, yCenter, xEdge, yCenter);
				if ((code & W) != 0)
					canvas.drawLine(xOffset, yCenter, xCenter, yCenter);
				
				if ((code & AN) != 0)
					{
						canvas.drawLine(xCenter, yOffset, xCenter + arrowB, yOffset + arrowA);
						canvas.drawLine(xCenter, yOffset, xCenter - arrowB, yOffset + arrowA);
					}
				if ((code & AS) != 0)
					{
						canvas.drawLine(xCenter, yEdge, xCenter + arrowB, yEdge - arrowA);
						canvas.drawLine(xCenter, yEdge, xCenter - arrowB, yEdge - arrowA);
					}
				if ((code & AE) != 0)
					{
						canvas.drawLine(xEdge, yCenter, xEdge - arrowA, yCenter - arrowB);
						canvas.drawLine(xEdge, yCenter, xEdge - arrowA, yCenter + arrowB);
					}
				if ((code & AW) != 0)
					{
						canvas.drawLine(xOffset + arrowA, yCenter - arrowB, xOffset, yCenter);
						canvas.drawLine(xOffset + arrowA, yCenter + arrowB, xOffset, yCenter);
					}
				
			}
		
		public LinePanel setLineColor(Color color)
			{
				this.lineColor = color;
				return this;
			}
		
		public LinePanel setLineStroke(Stroke stroke)
			{
				this.lineStroke = stroke;
				return this;
			}
		
		protected int														arrowA										= 8;
		protected int														arrowB										= 6;
		protected int														xSize											= 0;
		protected int														ySize											= 0;
		protected int														xLineHalfLength	= 0;
		protected int														yLineHalfLength	= 0;
		public int[][]													lineMap									= new int[][]
																																														{
																																															{ ALL } };
		public Color															lineColor							= Color.GRAY;
		public Stroke														lineStroke						= DEFAULT_STROKE;
		public static final Stroke	DEFAULT_STROKE		= new BasicStroke(2.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		public static final Stroke	LIGHT_STROKE				= new BasicStroke(1F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1F, new float[]
																																														{ 2F }, 0F);
	}

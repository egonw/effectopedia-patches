package org.qsari.effectopedia.defaults;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

public class DefaultGOSettings
	{
		public static final DefaultGOSettings	INSTANCE	= new DefaultGOSettings();
		private static float																		interfaceScale;
		public static final float													scaleMAX	= 4.0F;
		public static final float													scaleMIN	= 0.125F;
		
		private DefaultGOSettings()
			{
				interfaceScale = 1.0F;
				rescale(0.0F);
			}
			
		private static class SizeProcessor
			{
				public int process(int value)
					{
						return value;
					}
			}
			
		private static class ScaleSizeProcessor extends SizeProcessor
			{
				@Override
				public int process(int value)
					{
						return Math.round(value * interfaceScale);
					}
			}
			
		public static void rescale(float increment)
			{
				if (increment == 0.0F)
					interfaceScale = 1.0F;
				else
					interfaceScale += increment;
				
				if (interfaceScale > scaleMAX)
					interfaceScale = scaleMAX;
				if (interfaceScale < scaleMIN)
					interfaceScale = scaleMIN;
				
				textLineWidth = 0;
				
				SizeProcessor processor = Math.abs(1 - interfaceScale) < 1e-3 ? new SizeProcessor() : new ScaleSizeProcessor();
				
				captionFont = new Font("Serif", Font.PLAIN, processor.process(12));
				subCaptionFont = new Font("Serif", Font.ITALIC, processor.process(11));
				lineFont = new Font("Serif", Font.PLAIN, processor.process(11));
				textFont = new Font("Serif", Font.PLAIN, processor.process(11));
				footerFont = new Font("Serif", Font.BOLD + Font.ITALIC, processor.process(12));
				
				rowHeight = processor.process(16);
				columnHeaderHeight = processor.process(14);
				rowHeaderWidth = processor.process(14);
				footerHeight = processor.process(14);
				textRowHeight = processor.process(10);
				linkIconRadius = (interfaceScale > 1.0F) ? processor.process(22) : 22;
				minTextWidth = processor.process(40);
				
				mappingIconHeight = processor.process(24);
				mappingIconWidth = processor.process(24);
				headerBarWidth = processor.process(4);
				headerBarHeight = processor.process(8);
				headerButtonWidth = processor.process(8);
				headerButtonHeight = processor.process(8);
				headerBarGap = processor.process(1);
				
				defaultNInset = processor.process(8);
				defaultEInset = processor.process(8);
				defaultSInset = processor.process(8);
				defaultWInset = processor.process(8);
				defaultHeight = processor.process(54);
				defaultWidth = processor.process(108);
				defaultFixedGap = processor.process(4);
				
				linkIconOffset = processor.process(1);
				
			}
			
		public DefaultGOSettings getGOOptions()
			{
				return INSTANCE;
			}
			
		public static String	sampleText							= "1234567890QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
		public static int				sampleTextLength	= sampleText.length();
		public static int				textLineWidth				= 0;
		
		public static int getTextLineWidth(Graphics2D onCanvas)
			{
				if (textLineWidth == 0)
					{
						FontRenderContext context = onCanvas.getFontRenderContext();
						Rectangle2D bounds = DefaultGOSettings.textFont.getStringBounds(sampleText, context);
						textLineWidth = (int) bounds.getWidth();
					}
				return textLineWidth;
			}
			
		public static Color	effectLightColor													= new java.awt.Color(228, 236, 248);
		
		public static Color	effectColor																		= new java.awt.Color(103, 147, 218);
		public static Color	linkColor																				= new java.awt.Color(251, 176, 59);
		public static Color	inVitroTestColor													= new java.awt.Color(126, 119, 216);
		public static Color	inVivoTestColor														= new java.awt.Color(166, 124, 82);
		public static Color	inSilicoTestColor												= new java.awt.Color(102, 102, 102);
		public static Color	chemicalColor																= new java.awt.Color(103, 218, 147);
		public static Color	arcColor																					= new java.awt.Color(200, 200, 200);
		
		public static Color	activeEffectColor												= new java.awt.Color(78, 112, 166);
		public static Color	activeLinkColor														= new java.awt.Color(191, 141, 48);
		public static Color	activeInVitroTestColor							= new java.awt.Color(96, 91, 166);
		public static Color	activeInVivoTestColor								= new java.awt.Color(115, 85, 56);
		public static Color	activeInSilicoTestColor						= new java.awt.Color(77, 77, 77);
		public static Color	activeChemicalColor										= new java.awt.Color(78, 166, 112);
		public static Color	activeArcColor															= new java.awt.Color(128, 128, 128);
		
		public static Color	pathwayColor																	= new java.awt.Color(127, 127, 127);
		public static Color	segmentBoundsColor											= new java.awt.Color(235, 235, 235);
		public static Color	headerColor																		= new java.awt.Color(245, 245, 245);
		public static Color	headerIconColor														= new java.awt.Color(99, 130, 191);
		public static Color	selectionColor															= Color.RED;
		public static Color	activeSelectionColor									= new java.awt.Color(220, 0, 0);
		public static Color	selectionFrameColor										= new java.awt.Color(127, 127, 127);
		public static Color	uiSelectedColor														= new java.awt.Color(200, 221, 242);
		public static Color	selectionFillColor											= new java.awt.Color(120, 120, 120);
		public static Color	newArcColor																		= new java.awt.Color(0, 127, 127);
		public static Color	footerCaptionColor											= new java.awt.Color(99, 99, 99);
		public static Color	activeRegionColor												= new java.awt.Color(145, 187, 229);;
		
		public static Font		captionFont;
		public static Font		subCaptionFont;
		public static Font		lineFont;
		public static Font		textFont;
		public static Font		footerFont;
		public static Color	captionColor																	= new java.awt.Color(103, 147, 218);
		
		/**
		 * Height in pixels of the title line of the pathway elements
		 */
		public static int			rowHeight;
		/**
		 * Height in pixels of the pathway space column header
		 */
		public static int			columnHeaderHeight;
		public static int			rowHeaderWidth;
		public static int			footerHeight;
		public static int			textRowHeight;
		public static int			linkIconRadius;
		public static int			minTextWidth;
		
		public static int			mappingIconHeight;
		public static int			mappingIconWidth;
		public static int			headerBarWidth;
		public static int			headerBarHeight;
		public static int			headerButtonWidth;
		public static int			headerButtonHeight;
		public static int			headerBarGap;
		
		public static int			defaultNInset;
		public static int			defaultEInset;
		public static int			defaultSInset;
		public static int			defaultWInset;
		public static int			defaultHeight;
		public static int			defaultWidth;
		public static int			defaultFixedGap;
		
		public static float	hVisWeigthChemical											= 1.4F;
		public static float	vVisWeigthChemical											= 1.3F;
		public static float	hVisWeigthLink															= 1.0F;
		public static float	vVisWeigthLink															= 1.0F;
		public static float	hVisWeigthEffect													= 1.2F;
		public static float	vVisWeigthEffect													= 1.2F;
		public static float	hVisWeigthTest															= 1.0F;
		public static float	vVisWeigthTest															= 1.0F;
		public static float	hVisWeigthMapping												= 1.1F;
		public static float	vVisWeigthMapping												= 1.1F;
		
		public static float	hVisWeigthSubstanceContainer	= 1.5F;
		public static float	vVisWeigthSubstanceContainer	= 1.8F;
		public static float	hVisWeigthEffectContainer				= 1.3F;
		public static float	vVisWeigthEffectContainer				= 1.3F;
		public static float	hVisWeigthLinkContainer						= 1.1F;
		public static float	vVisWeigthLinkContainer						= 1.1F;
		
		public static boolean isHideEmptySegments()
			{
				return hideEmptySegments;
			}
			
		public static void setHideEmptySegments(boolean hideEmptySegments)
			{
				DefaultGOSettings.hideEmptySegments = hideEmptySegments;
				if (hideEmptySegments)
					{
						hVisWeigthSubstanceContainer = 0.0F; 
						vVisWeigthSubstanceContainer = 0.0F; 
						hVisWeigthEffectContainer = 0.0F; 
						vVisWeigthEffectContainer = 0.0F; 
						hVisWeigthLinkContainer = 0.0F; 
						vVisWeigthLinkContainer = 0.0F; 
					}
				else
					{
						hVisWeigthSubstanceContainer = 1.5F;
						vVisWeigthSubstanceContainer = 1.8F;
						hVisWeigthEffectContainer = 1.3F;
						vVisWeigthEffectContainer = 1.3F;
						hVisWeigthLinkContainer = 1.1F;
						vVisWeigthLinkContainer = 1.1F;
					}
			}
			
		public static int									linkIconOffset;
		public static BasicStroke	contourPen								= new BasicStroke(2.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		public static BasicStroke	activeContourPen		= new BasicStroke(3.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		public static BasicStroke	insidePen									= new BasicStroke(1.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		public static BasicStroke	selectionPen						= new BasicStroke(1.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		public static BasicStroke	newArcPen									= new BasicStroke(1.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		
		public static BasicStroke	arcPen												= new BasicStroke(1.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 2.0F, new float[]
			{ 1.0F, 1.0F }, 1.0F);
			
		public static BasicStroke	contourTmpPen					= new BasicStroke(1.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 2.0F, new float[]
			{ 2.0F, 2.0F }, 1.0F);
		public static BasicStroke	insideTmpPen						= new BasicStroke(1.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 2.0F, new float[]
			{ 2.0F, 2.0F }, 1.0F);
		public static BasicStroke	arcTmpPen									= new BasicStroke(1.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 2.0F, new float[]
			{ 2.0F, 2.0F }, 1.0F);
			
		public static boolean					hideActionText				= true;
		private static boolean				hideEmptySegments	= false;
	}

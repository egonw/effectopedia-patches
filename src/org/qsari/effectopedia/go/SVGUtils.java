package org.qsari.effectopedia.go;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.DocumentedKnowledge;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.core.GUIFactory;

public class SVGUtils
	{
		
		public static void addParamaterQuatedValuePair(StringBuilder sb, String parameter, String value)
			{
				sb.append(" ");
				sb.append(parameter);
				sb.append("=\"");
				sb.append(value);
				sb.append("\"");
			}
		
		public static void addParamaterQuatedValuePair(StringBuilder sb, String parameter, int value)
			{
				sb.append(" ");
				sb.append(parameter);
				sb.append("=\"");
				sb.append(value);
				sb.append("\"");
			}
		
		public static void addParamaterQuatedValuePair(StringBuilder sb, String parameter, Color value)
			{
				sb.append(" ");
				sb.append(parameter);
				sb.append("=\"#");
				sb.append(Integer.toHexString(value.getRGB()).substring(2));
				sb.append("\"");
			}
		
		public static void addDualParamaterQuatedValuePair(StringBuilder sb, String parameter1, int value1, String parameter2, int value2)
			{
				sb.append(" ");
				sb.append(parameter1);
				sb.append("=\"");
				sb.append(value1);
				sb.append("\" ");
				sb.append(parameter2);
				sb.append("=\"");
				sb.append(value2);
				sb.append("\"");
			}
		
		public static void addParamaterValuePair(StringBuilder sb, String parameter, String value)
			{
				sb.append(" ");
				sb.append(parameter);
				sb.append(":");
				sb.append(value);
				sb.append(";");
			}
		
		public static void addParamaterValuePair(StringBuilder sb, String parameter, int value)
			{
				sb.append(" ");
				sb.append(parameter);
				sb.append(":");
				sb.append(value);
				sb.append(";");
			}
		
		public static void addParamaterValuePair(StringBuilder sb, String parameter, Color value)
			{
				sb.append(" ");
				sb.append(parameter);
				sb.append(":#");
				sb.append(Integer.toHexString(value.getRGB()).substring(2));
				sb.append(";");
			}
		
		public static void addTextOpeningTag(StringBuilder sb, int x, int y, Color color)
			{
				sb.append("<text x=\"");
				sb.append(x);
				sb.append("\" y=\"");
				sb.append(y);
				sb.append("\" style=\"fill: #");
				sb.append(Integer.toHexString(color.getRGB()).substring(2));
				sb.append("; stroke: none; font-size: 11px;\">\n");
			}
		
		public static void addVerticalTextOpeningTag(StringBuilder sb, int x, int y, Color color)
			{
				sb.append("<text transform=\"rotate(-90 ");
				sb.append(x);
				sb.append(" ");
				sb.append(y);
				sb.append(")\" x=\"");
				sb.append(x);
				sb.append("\" y=\"");
				sb.append(y);
				sb.append("\" style=\"fill: #");
				sb.append(Integer.toHexString(color.getRGB()).substring(2));
				sb.append("; stroke: none; font-size: 11px;\">\n");
			}

		public static void addTspan(StringBuilder sb, String text)
			{
				sb.append("<tspan>");
				sb.append(text);
				sb.append("</tspan>\n");
			}
		
		public static void addTspan(StringBuilder sb, int x, int dy, String text, Color color)
			{
				sb.append("<tspan x=\"");
				sb.append(x + 4);
				sb.append("\" dy=\"");
				sb.append(dy);
				sb.append("\" style=\" fill: #");
				sb.append(Integer.toHexString(color.getRGB()).substring(2));
				sb.append("; stroke: none; font-size: 11px;\">");
				sb.append(text);
				sb.append("</tspan>\n");
			}
		
		public static void addLine(StringBuilder sb, int x1, int y1, int x2, int y2, Color color, int strokeWidth)
			{
				sb.append("<line x1=\"");
				sb.append(x1);
				sb.append("\" y1=\"");
				sb.append(y1);
				sb.append("\" x2=\"");
				sb.append(x2);
				sb.append("\" y2=\"");
				sb.append(y2);
				sb.append("\" stroke=\"#");
				sb.append(Integer.toHexString(color.getRGB()).substring(2));
				sb.append("\" stroke-width=\"");
				sb.append(strokeWidth);
				sb.append("\"/>\n");
			}
		
		public static void addCircle(StringBuilder sb, int cx, int cy, int r, Color strokeColor, Color fillColor, int strokeWidth)
			{
				sb.append("<circle cx=\"");
				sb.append(cx);
				sb.append("\" cy=\"");
				sb.append(cy);
				sb.append("\" r=\"");
				sb.append(r);
				if (strokeColor != null)
					{
						sb.append("\" stroke=\"#");
						sb.append(Integer.toHexString(strokeColor.getRGB()).substring(2));
					}
				else
					sb.append("\" stroke=\"none");
				if (fillColor != null)
					{
						sb.append("\" fill=\"#");
						sb.append(Integer.toHexString(fillColor.getRGB()).substring(2));
					}
				else
					sb.append("\" fill=\"none");
				sb.append("\" stroke-width=\"");
				sb.append(strokeWidth);
				sb.append("\"/>\n");
			}
		
		public static void addPathOpeningTag(StringBuilder sb, Color color, int strokeWidth)
			{
				sb.append("<path stroke=\"#");
				sb.append(Integer.toHexString(color.getRGB()).substring(2));
				sb.append("\" fill=\"none\" stroke-width=\"");
				sb.append(strokeWidth);
				sb.append("\" d=\"");
			}

		public static void addPathMoveCommand(StringBuilder sb, int x, int y)
			{
				sb.append("M ");
				sb.append(x);
				sb.append(" ");
				sb.append(y);
				sb.append(" ");
			}

		public static void addPathLineCommand(StringBuilder sb, int x, int y)
			{
				sb.append("L ");
				sb.append(x);
				sb.append(" ");
				sb.append(y);
				sb.append(" ");
			}
		
		public static void addArc(StringBuilder sb, int cx, int cy, int r, int startAngle, int endAngle)
			{
				double startAngleinRadians = (startAngle) * Math.PI / 180.0;
				double endAngleinRadians = (endAngle) * Math.PI / 180.0;
				
				sb.append("M ");
				sb.append(cx + r * Math.cos(startAngleinRadians));
				sb.append(" ");
				sb.append(cy - r * Math.sin(startAngleinRadians));
				sb.append(" ");
				sb.append("A ");
				sb.append(r);
				sb.append(" ");
				sb.append(r);
				sb.append(" 0 ");
				sb.append((endAngle - startAngle) <= 180 ? "0" : "1");
				sb.append(" 0 ");
				sb.append(cx + r * Math.cos(endAngleinRadians));
				sb.append(" ");
				sb.append(cy - r * Math.sin(endAngleinRadians));
			}
		
		public static void addFilledRhomb(StringBuilder sb, int x, int y, int width, int height, Color fillColor, Color strokeColor)
			{
				sb.append("<path d=\"");
				int midX = x + (width >> 1);
				int midY = y + (height >> 1);
				sb.append("M ");
				sb.append(midX);
				sb.append(" ");
				sb.append(y);
				
				sb.append(" L ");
				sb.append(x + width);
				sb.append(" ");
				sb.append(midY);
				
				sb.append(" L ");
				sb.append(midX);
				sb.append(" ");
				sb.append(y + height);
				
				sb.append(" L ");
				sb.append(x);
				sb.append(" ");
				sb.append(midY);
				sb.append(" z");
				if (strokeColor != null)
					{
						sb.append("\" stroke=\"#");
						sb.append(Integer.toHexString(strokeColor.getRGB()).substring(2));
					}
				else
					sb.append("\" stroke=\"none");
				if (fillColor != null)
					{
						sb.append("\" fill=\"#");
						sb.append(Integer.toHexString(fillColor.getRGB()).substring(2));
					}
				else
					sb.append("\" fill=\"none");
				sb.append("\" stroke-width=\"2\"/>\n");
			}

		
		public static void addFillRoundRect(StringBuilder sb, int x, int y, int width, int height, int rx, int ry, Color fillColor, Color strokeColor)
			{
				sb.append("<rect x=\"");
				sb.append(x);
				sb.append("\" y=\"");
				sb.append(y);
				sb.append("\" width=\"");
				sb.append(width);
				sb.append("\" height=\"");
				sb.append(height);
				sb.append("\" rx=\"");
				sb.append(rx);
				sb.append("\" ry=\"");
				sb.append(ry);
				if (strokeColor != null)
					{
						sb.append("\" stroke=\"#");
						sb.append(Integer.toHexString(strokeColor.getRGB()).substring(2));
					}
				else
					sb.append("\" stroke=\"none");
				if (fillColor != null)
					{
						sb.append("\" fill=\"#");
						sb.append(Integer.toHexString(fillColor.getRGB()).substring(2));
					}
				else
					sb.append("\" fill=\"none");
				sb.append("\"/>\n");
			}
		
		public static void addFillRect(StringBuilder sb, int x, int y, int width, int height, Color fillColor, Color strokeColor)
			{
				sb.append("<rect x=\"");
				sb.append(x);
				sb.append("\" y=\"");
				sb.append(y);
				sb.append("\" width=\"");
				sb.append(width);
				sb.append("\" height=\"");
				sb.append(height);
				if (strokeColor != null)
					{
						sb.append("\" stroke=\"#");
						sb.append(Integer.toHexString(strokeColor.getRGB()).substring(2));
					}
				else
					sb.append("\" stroke=\"none");
				if (fillColor != null)
					{
						sb.append("\" fill=\"#");
						sb.append(Integer.toHexString(fillColor.getRGB()).substring(2));
					}
				else
					sb.append("\" fill=\"none");
				sb.append("\"/>\n");
			}
		
		public static void addCaption(String text, StringBuilder sb, int x, int y, int width, int height, Color color)
			{
				if ((text != null) && (height >= DefaultGOSettings.rowHeight))
					{
						if ((width <= 0) || (height <= 0) || (text == null))
							return;
						Graphics2D onCanvas = ((Graphics2D) GUIFactory.GUI.getFrame().getGraphics());
						FontRenderContext context = onCanvas.getFontRenderContext();
						Rectangle2D bounds = DefaultGOSettings.captionFont.getStringBounds(text, context);
						int lineWidth = (int) bounds.getWidth();
						if (lineWidth == 0)
							return;
						int maxSymbolsDispalyed = (width * text.length()) / lineWidth;
						if (maxSymbolsDispalyed < 2)
							return;
						String txt = (lineWidth > width) ? (text.substring(0, maxSymbolsDispalyed - 1) + "...") : text;
						SVGUtils.addTextOpeningTag(sb, x + 2, (int) (y - bounds.getY()), color);
						sb.append(txt);
						sb.append("</text>\n");
					}
			}
		
		public static void addCentredCaption(String text, StringBuilder sb, int x, int y, int width, int height, Color color)
			{
				if ((text != null) && (height >= DefaultGOSettings.rowHeight))
					{
						if ((width <= 0) || (height <= 0) || (text == null))
							return;
						Graphics2D onCanvas = ((Graphics2D) GUIFactory.GUI.getFrame().getGraphics());
						FontRenderContext context = onCanvas.getFontRenderContext();
						Rectangle2D bounds = DefaultGOSettings.captionFont.getStringBounds(text, context);
						int lineWidth = (int) bounds.getWidth();
						if (lineWidth == 0)
							return;
						int maxSymbolsDispalyed = (width * text.length()) / lineWidth;
						if (maxSymbolsDispalyed < 2)
							return;
						String txt = (lineWidth > width) ? (text.substring(0, maxSymbolsDispalyed - 1) + "...") : text;
						SVGUtils.addTextOpeningTag(sb, (int)(x + (width - bounds.getWidth()) / 2), (int) (y - bounds.getY()), color);
						sb.append(txt);
						sb.append("</text>\n");
					}
			}

		public static void addCentredVerticalCaption(String text, StringBuilder sb, int x, int y, int width, int height, Color color)
			{
				if ((text != null))
					{
						if ((width <= 0) || (height <= 0) || (text == null))
							return;
						Graphics2D onCanvas = ((Graphics2D) GUIFactory.GUI.getFrame().getGraphics());
						FontRenderContext context = onCanvas.getFontRenderContext();
						Rectangle2D bounds = DefaultGOSettings.captionFont.getStringBounds(text, context);
						int lineWidth = (int) bounds.getWidth();
						if (lineWidth == 0)
							return;
						int maxSymbolsDispalyed = (height * text.length()) / lineWidth;
						if (maxSymbolsDispalyed < 2)
							return;
						String txt = (lineWidth > height) ? (text.substring(0, maxSymbolsDispalyed - 1) + "...") : text;
						SVGUtils.addVerticalTextOpeningTag(sb, x +8, (int) (y + (height+lineWidth)/2), color);
						sb.append(txt);
						sb.append("</text>\n");
					}
			}

		public static void addMultilineCaption(PathwayElement o, StringBuilder pathwayElementsGroup, int x, int y, int width, int height, Color color)
			{
				if ((o != null) && (height >= DefaultGOSettings.rowHeight))
					{
						SVGUtils.addTextOpeningTag(pathwayElementsGroup, x + 4, y, color);
						String text = ((DocumentedKnowledge) o).getTitle();
						String id = String.valueOf(o.getExternalID());
						Graphics2D onCanvas = ((Graphics2D) GUIFactory.GUI.getFrame().getGraphics());
						FontRenderContext context = onCanvas.getFontRenderContext();
						Rectangle2D bounds = DefaultGOSettings.captionFont.getStringBounds(id + "    ", context);
						int idWidth = (int) bounds.getWidth();
						bounds = DefaultGOSettings.captionFont.getStringBounds(text, context);
						int lineWidth = (int) bounds.getWidth() + idWidth;
						onCanvas.setFont(DefaultGOSettings.textFont);
						int maxSimbolsPerRow = ((width * (text.length() + id.length() + 6)) / lineWidth);
						String[] items = GOUtils.wrapText(text, maxSimbolsPerRow - 1);
						int rowCount = Math.min(items.length, (height / (DefaultGOSettings.textRowHeight)));
						for (int i = 0; i < rowCount; i++)
							if (items[i] != null)
								SVGUtils.addTspan(pathwayElementsGroup, (int) x + 2, DefaultGOSettings.textRowHeight + (int) (y - bounds.getY()), items[i], color);
						pathwayElementsGroup.append("</text>\n");
					}
			}
		
		public static void addMultilineCaptionAndID(PathwayElement o, StringBuilder pathwayElementsGroup, int x, int y, int width, int height, Color color)
			{
				if ((o != null) && (height >= DefaultGOSettings.rowHeight))
					{
						SVGUtils.addTextOpeningTag(pathwayElementsGroup, x + 4, y, color);
						String text = ((DocumentedKnowledge) o).getTitle();
						String id = String.valueOf(o.getExternalID());
						Graphics2D onCanvas = ((Graphics2D) GUIFactory.GUI.getFrame().getGraphics());
						FontRenderContext context = onCanvas.getFontRenderContext();
						Rectangle2D bounds = DefaultGOSettings.captionFont.getStringBounds(id + "    ", context);
						int idWidth = (int) bounds.getWidth();
						bounds = DefaultGOSettings.captionFont.getStringBounds(text, context);
						int lineWidth = (int) bounds.getWidth() + idWidth;
						onCanvas.setFont(DefaultGOSettings.textFont);
						int maxSimbolsPerRow = ((width * (text.length() + id.length() + 6)) / lineWidth);
						String[] items = GOUtils.wrapText(text, maxSimbolsPerRow - 1, maxSimbolsPerRow - 10);
						int rowCount = Math.min(items.length, (height / (DefaultGOSettings.textRowHeight)));
						for (int i = 0; i < rowCount; i++)
							if (items[i] != null)
								SVGUtils.addTspan(pathwayElementsGroup, (int) x + 2, DefaultGOSettings.textRowHeight + 1, items[i], color);
						int yOffset = (rowCount - 2) * DefaultGOSettings.textRowHeight + (int) (y - bounds.getY());
						if (rowCount > 1)
							yOffset += 6;
						pathwayElementsGroup.append("</text>\n");
						SVGUtils.addFillRoundRect(pathwayElementsGroup, x + width - idWidth - 2, yOffset, idWidth + 1, DefaultGOSettings.rowHeight - 4, 6, 6, color, null);
						SVGUtils.addTextOpeningTag(pathwayElementsGroup, x + width - idWidth, yOffset + 10, Color.white);
						pathwayElementsGroup.append(id);
						pathwayElementsGroup.append("</text>\n");
					}
			}
		
		
		public final static String	SVG_Header	= "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<!-- Generator: Effectopedia " + Effectopedia.VERSION + "-->\n"
																																										+ "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n"
																																										+ "<svg version=\"1.1\" id=\"PathwayView\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n";
		public final static String	SVG_Defs			= "<defs>\n" + "<pattern id=\"grid_pattern\" x=\"0\" y=\"0\" width=\"8\" height=\"8\" patternUnits=\"userSpaceOnUse\">\n"
																																										+ "<circle cx=\"7\" cy=\"7\" r=\"1\" style=\"stroke: none; fill: #" + Integer.toHexString(DefaultGOSettings.segmentBoundsColor.getRGB()).substring(2)
																																										+ "\" />\n" + "</pattern>\n</defs>\n";
		
	}

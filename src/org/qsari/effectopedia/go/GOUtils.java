package org.qsari.effectopedia.go;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.qsari.effectopedia.core.object.elemets.Coordinate;
import org.qsari.effectopedia.core.object.elemets.Coordinates;
import org.qsari.effectopedia.core.object.elemets.QualityAssurance;
import org.qsari.effectopedia.core.objects.ContextDimension;
import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.Reference;
import org.qsari.effectopedia.data.objects.DataValues;
import org.qsari.effectopedia.defaults.DefaultGOSettings;

public class GOUtils
	{
		private static final GOUtils	INSTANCE	= new GOUtils();
		
		private GOUtils()
			{
				
			}
		
		public GOUtils getGOUtils()
			{
				return INSTANCE;
			}
		
		static public void drawCaption(String text, Color textColor, Graphics2D onCanvas, int x, int y, int width, int height)
			{
				if ((width <= 0) || (height <= 0) || (text == null))
					return;
				FontRenderContext context = onCanvas.getFontRenderContext();
				Rectangle2D bounds = DefaultGOSettings.captionFont.getStringBounds(text, context);
				int lineWidth = (int) bounds.getWidth();
				if (lineWidth == 0)
					return;
				int maxSymbolsDispalyed = (width * text.length()) / lineWidth;
				if (maxSymbolsDispalyed < 2)
					return;
				String txt = (lineWidth > width) ? (text.substring(0, maxSymbolsDispalyed - 1) + "...") : text;
				onCanvas.setColor(textColor);
				onCanvas.setFont(DefaultGOSettings.captionFont);
				onCanvas.drawString(txt, (int) x + 2, (int) (y - bounds.getY()));
			}
		
		static public void drawMultilineCaption(String text, Color textColor, Graphics2D onCanvas, int x, int y, int width, int height)
			{
				if ((width <= 0) || (height <= 0) || text=="")
					return;
				FontRenderContext context = onCanvas.getFontRenderContext();
				Rectangle2D bounds = DefaultGOSettings.captionFont.getStringBounds(text, context);
				int lineWidth = (int) bounds.getWidth();
				onCanvas.setColor(textColor);
				onCanvas.setFont(DefaultGOSettings.textFont);
				int maxSimbolsPerRow = ((width * text.length()) / lineWidth);
				String[] items = wrapText(text, maxSimbolsPerRow - 1);
				int rowCount = Math.min(items.length, (height / (DefaultGOSettings.textRowHeight)));
				for (int i = 0; i < rowCount; i++)
					if (items[i] != null)
						onCanvas.drawString(items[i], (int) x + 2, i * DefaultGOSettings.textRowHeight + (int) (y - bounds.getY()));
			}
		
		static public void drawMultilineCaptionAndID(String text, String id, Color textColor, Graphics2D onCanvas, int x, int y, int width, int height)
			{
				if ((width <= 0) || (height <= 0))
					return;
				FontRenderContext context = onCanvas.getFontRenderContext();
				Rectangle2D bounds = DefaultGOSettings.captionFont.getStringBounds(id + "    ", context);
				int idWidth = (int) bounds.getWidth();
				bounds = DefaultGOSettings.captionFont.getStringBounds(text, context);
				int lineWidth = (int) bounds.getWidth() + idWidth;
				onCanvas.setColor(textColor);
				onCanvas.setFont(DefaultGOSettings.textFont);
				int maxSimbolsPerRow = ((width * (text.length()+id.length()+6)) / lineWidth);
				String[] items = wrapText(text, maxSimbolsPerRow - 1, maxSimbolsPerRow - 10);
				int rowCount = Math.min(items.length, (height / (DefaultGOSettings.textRowHeight)));
				for (int i = 0; i < rowCount; i++)
					if (items[i] != null)
						onCanvas.drawString(items[i], (int) x + 2, i * DefaultGOSettings.textRowHeight + (int) (y - bounds.getY()));
				int yOffset = (rowCount - 2) * DefaultGOSettings.textRowHeight + (int) (y - bounds.getY());
				if (rowCount>1)
					 yOffset +=6;
				onCanvas.setStroke(DefaultGOSettings.insidePen);
				onCanvas.fillRoundRect(x + width - idWidth - 2, yOffset, idWidth + 1, DefaultGOSettings.rowHeight - 4, 6, 6);
				GOUtils.drawLine(id, Color.white, onCanvas, x + width - idWidth - 2, yOffset - 2, idWidth, DefaultGOSettings.rowHeight);// ID
			}

		static public void drawID(String id, Color textColor, Graphics2D onCanvas, int x, int y, int width, int height)
			{
				if ((width <= 0) || (height <= 0))
					return;
				onCanvas.setColor(textColor);
    onCanvas.setStroke(DefaultGOSettings.insidePen);
				onCanvas.fillRoundRect(x, y, width, height, 6, 6);
				GOUtils.drawLine(id, Color.white, onCanvas, x, y, width, height);// ID
			}
		
		static public int getLinesCount(String text, Graphics2D onCanvas, int width, boolean includingID)
			{
				if ((width <= 0)||(text==null)||(text.length()==0))
					return 0;
				FontRenderContext context = onCanvas.getFontRenderContext();
				Rectangle2D bounds = DefaultGOSettings.captionFont.getStringBounds(text, context);
				int lineWidth = (int) bounds.getWidth();
				onCanvas.setFont(DefaultGOSettings.textFont);
				int maxSimbolsPerRow = ((width * text.length()) / lineWidth);
				String[] items = includingID?wrapText(text, maxSimbolsPerRow - 1, maxSimbolsPerRow-8):wrapText(text, maxSimbolsPerRow - 1);
				return items.length;
			}
		
		static public void drawQualityAssurance(QualityAssurance qa, Color textColor, Graphics2D onCanvas, int x, int y, int width, int height)
			{
				String text = qa.getContributors().getContributorsList(false);
				if (text != null)
					{
						drawText(text, textColor, onCanvas, x + 3, y, width - 3, height);
						text = qa.getReviewers().getReviewersList(false);
						if (text != null)
							drawText(text, textColor, onCanvas, x + 3, y + DefaultGOSettings.textRowHeight, width - 3, height - DefaultGOSettings.textRowHeight);
					}
			}
		
		static public void drawSubCaption(String text, Color textColor, Graphics2D onCanvas, int x, int y, int width, int height)
			{
				if ((width <= 0) || (height <= 0))
					return;
				FontRenderContext context = onCanvas.getFontRenderContext();
				Rectangle2D bounds = DefaultGOSettings.subCaptionFont.getStringBounds(text, context);
				int lineWidth = (int) bounds.getWidth();
				int maxSymbolsDispalyed = (width * text.length()) / lineWidth;
				if (maxSymbolsDispalyed < 2)
					return;
				String txt = (lineWidth > width) ? (text.substring(0, maxSymbolsDispalyed - 1) + "...") : text;
				onCanvas.setColor(textColor);
				onCanvas.setFont(DefaultGOSettings.subCaptionFont);
				bounds = DefaultGOSettings.subCaptionFont.getStringBounds(txt, context);
				onCanvas.drawString(txt, (int) x + 2, (int) (y - bounds.getY()));
			}
		
		static public void drawLine(String text, Color textColor, Graphics2D onCanvas, int x, int y, int width, int height)
			{
				if ((width <= 0) || (height <= 0))
					return;
				FontRenderContext context = onCanvas.getFontRenderContext();
				Rectangle2D bounds = DefaultGOSettings.lineFont.getStringBounds(text, context);
				int lineWidth = (int) bounds.getWidth();
				int maxSymbolsDispalyed = (width * text.length()) / lineWidth;
				if (maxSymbolsDispalyed < 2)
					return;
				String txt = (lineWidth > width) ? (text.substring(0, maxSymbolsDispalyed - 1) + "...") : text;
				onCanvas.setColor(textColor);
				onCanvas.setFont(DefaultGOSettings.lineFont);
				bounds = DefaultGOSettings.lineFont.getStringBounds(txt, context);
				double xc = x + (width - bounds.getWidth()) / 2;
				double yc = y + (height - bounds.getHeight()) / 2;
				onCanvas.drawString(txt, (int) xc, (int) (yc - bounds.getY()));
			}
		
		static public void drawFooter(String text, Color textColor, Graphics2D onCanvas, int x, int y, int width, int height)
			{
				if ((width <= 0) || (height <= 0))
					return;
				FontRenderContext context = onCanvas.getFontRenderContext();
				Rectangle2D bounds = DefaultGOSettings.footerFont.getStringBounds(text, context);
				int lineWidth = (int) bounds.getWidth();
				int maxSymbolsDispalyed = (width * text.length()) / lineWidth;
				if (maxSymbolsDispalyed < 2)
					return;
				String txt = (lineWidth > width) ? (text.substring(0, maxSymbolsDispalyed - 1) + "...") : text;
				onCanvas.setColor(textColor);
				onCanvas.setFont(DefaultGOSettings.footerFont);
				bounds = DefaultGOSettings.footerFont.getStringBounds(txt, context);
				double xc = x + (width - bounds.getWidth()) / 2;
				double yc = y + (height - bounds.getHeight()) / 2;
				onCanvas.drawString(txt, (int) xc, (int) (yc - bounds.getY()));
			}
		
		static public void drawRowHeader(String text, Color textColor, Graphics2D onCanvas, int x, int y, int width, int height)
			{
				if ((width <= 0) || (height <= 0))
					return;
				AffineTransform oldAT = onCanvas.getTransform();
				FontRenderContext context = onCanvas.getFontRenderContext();
				Rectangle2D bounds = DefaultGOSettings.footerFont.getStringBounds(text, context);
				int lineWidth = (int) bounds.getWidth();
				int maxSymbolsDispalyed = (height * text.length()) / lineWidth;
				if (maxSymbolsDispalyed < 2)
					return;
				String txt = (lineWidth > height) ? (text.substring(0, maxSymbolsDispalyed - 1) + "...") : text;
				onCanvas.setColor(textColor);
				onCanvas.setFont(DefaultGOSettings.footerFont);
				bounds = DefaultGOSettings.footerFont.getStringBounds(txt, context);
				double xc = x + (-height - bounds.getWidth()) / 2;
				double yc = y + (width - bounds.getY() - 4) / 2;
				onCanvas.rotate(-Math.PI / 2.0, x, y);
				onCanvas.drawString(txt, (int) (xc), (int) (yc));
				onCanvas.setTransform(oldAT);
			}
		
		static public String[] wrapText(String text, int maxSymbolsPerRow)
			{
				ArrayList<String> items = new ArrayList<String>();
				StringBuilder line = new StringBuilder();
				StringTokenizer st = new StringTokenizer(text);
				while (st.hasMoreTokens())
					{
						String token = st.nextToken();
						if (token.length() + line.length() > maxSymbolsPerRow)
							{
								items.add(line.toString());
								line.setLength(0);
							}
						line.append(token);
						line.append(" ");
					}
				items.add(line.toString());
				String[] result = new String[items.size()];
				items.toArray(result);
				return result;
			}
		
		static public String[] wrapText(String text, int maxSymbolsPerRow, int maxSymbolsInLastRow)
			{
				ArrayList<String> items = new ArrayList<String>();
				StringBuilder line = new StringBuilder();
				StringTokenizer st = new StringTokenizer(text);
				while (st.hasMoreTokens())
					{
						String token = st.nextToken();
						if (token.length() + line.length() > maxSymbolsPerRow)
							{
								items.add(line.toString());
								line.setLength(0);
							}
						line.append(token);
						line.append(" ");
					}
				items.add(line.toString());
				String lastLine  = items.get(items.size()-1);
				if (lastLine.length()>maxSymbolsInLastRow)
					{
					 items.remove(items.size()-1);
						line.setLength(0);
					 st = new StringTokenizer(lastLine);
						while (st.hasMoreTokens())
							{
								String token = st.nextToken();
								if (token.length() + line.length() > maxSymbolsInLastRow)
									{
										items.add(line.toString());
										line.setLength(0);
									}
								line.append(token);
								line.append(" ");
							}
						items.add(line.toString());
					}

				String[] result = new String[items.size()];
				items.toArray(result);
				return result;
			}
		
		static public String[] wrapHangingText(String text, int maxSymbolsPerRow, int hangWith)
			{
				ArrayList<String> items = new ArrayList<String>();
				StringBuilder line = new StringBuilder();
				StringTokenizer st = new StringTokenizer(text);
				int hangs = 0;
				while (st.hasMoreTokens())
					{
						String token = st.nextToken();
						if (token.length() + line.length() > maxSymbolsPerRow - hangs)
							{
								items.add(line.toString());
								line.setLength(0);
								hangs = hangWith;
							}
						line.append(token);
						line.append(" ");
					}
				items.add(line.toString());
				String[] result = new String[items.size()];
				items.toArray(result);
				return result;
			}
		
		static public int drawText(String text, Color textColor, Graphics2D onCanvas, int x, int y, int width, int height)
			{
				if ((width <= 0) || (height <= 0))
					return 0;
				onCanvas.setColor(textColor);
				onCanvas.setFont(DefaultGOSettings.textFont);
				FontRenderContext context = onCanvas.getFontRenderContext();
				Rectangle2D bounds = DefaultGOSettings.textFont.getStringBounds(text, context);
				int lineWidth = (int) bounds.getWidth();
				int maxSimbolsPerRow = (width * text.length()) / lineWidth;
				String[] items = wrapText(text, maxSimbolsPerRow - 1);
				int rowCount = Math.min(items.length, (height / (DefaultGOSettings.textRowHeight)));
				for (int i = 0; i < rowCount; i++)
					if (items[i] != null)
						onCanvas.drawString(items[i], (int) x + 2, y+(i+1) * DefaultGOSettings.textRowHeight);
				return rowCount * DefaultGOSettings.textRowHeight;
			}
		
		static public int drawHangingText(String text, Color textColor, Graphics2D onCanvas, int x, int y, int width, int height)
			{
				if ((width <= 0) || (height <= 0))
					return 0;
				FontRenderContext context = onCanvas.getFontRenderContext();
				Rectangle2D bounds = DefaultGOSettings.textFont.getStringBounds(text, context);
				int lineWidth = (int) bounds.getWidth();
				onCanvas.setColor(textColor);
				onCanvas.setFont(DefaultGOSettings.textFont);
				int maxSimbolsPerRow = ((width * text.length()) / lineWidth);
				//System.out.println("drawHangingText maxSimbolsPerRow="+maxSimbolsPerRow);
				String[] items = wrapHangingText(text, maxSimbolsPerRow - 1, 5);
				int rowCount = Math.min(items.length, (height / (DefaultGOSettings.textRowHeight)));
				if (rowCount >= 1)
					{
						onCanvas.drawString(items[0], (int) x + 2, (int) (y - bounds.getY()));
						int inset = 5 * lineWidth / text.length();
						for (int i = 1; i < rowCount; i++)
							if (items[i] != null)
								onCanvas.drawString(items[i], (int) x + 2 + inset, i * DefaultGOSettings.textRowHeight + (int) (y - bounds.getY()));
						return rowCount * DefaultGOSettings.textRowHeight;
					}
				return 0;
			}
		
		static public void drawItems(String[] items, Color textColor, Graphics2D onCanvas, int x, int y, int width, int height)
			{
				if ((width <= 0) || (height <= 0) || (items.length == 0))
					return;
				onCanvas.setColor(textColor);
				onCanvas.setFont(DefaultGOSettings.textFont);
				int rowCount = Math.min(items.length, (height / (DefaultGOSettings.textRowHeight)));
				int maxSimbolsPerRow = ((width * DefaultGOSettings.sampleTextLength) / DefaultGOSettings.getTextLineWidth(onCanvas));
				if (maxSimbolsPerRow < 3)
					return;
				int pixelsPerSimbol = width / maxSimbolsPerRow;
				for (int i = 0; i < rowCount; i++)
					if (items[i] != null)
						{
							String txt = ((pixelsPerSimbol * items[i].length()) > width) ? (items[i].substring(0, maxSimbolsPerRow - 2) + "...") : items[i];
							onCanvas.drawString(txt, (int) x + 2, y-1+(i+1) * DefaultGOSettings.textRowHeight);
						}
			}
		
		static public void drawDescriptionSection(DescriptionSection section, Color textColor, Graphics2D onCanvas, int x, int y, int width, int height)
			{
				if ((height >= DefaultGOSettings.rowHeight) && (section != null))
					{
						GOUtils.drawSubCaption(section.getTitle(), textColor, onCanvas, x + 2, y + 2, width, DefaultGOSettings.rowHeight);
						if (height >= DefaultGOSettings.rowHeight * 2)
							GOUtils.drawText(section.getContent(), textColor, onCanvas, x + 2, y + DefaultGOSettings.rowHeight - 2, width, height - DefaultGOSettings.rowHeight);
					}
			}
		
		static public void drawContext(Coordinates coordinates, Color textColor, Graphics2D onCanvas, int x, int y, int width, int height)
			{
				if (coordinates != null)
					{
						int count = coordinates.count();
						count = Math.min(count, (int) ((Math.floor((height / (DefaultGOSettings.textRowHeight))))));
					
						String[] captions = new String[count];
						String[] values = new String[count];
						String[] units = new String[count];
						for (int i = 0; i < count; i++)
							{
								Coordinate coordinate = coordinates.getCoordiante(i);
								ContextDimension contextDimension = coordinates.getDimension(i);
								captions[i] = contextDimension.getName();
								values[i] = (coordinate.getValue() != null) ? coordinate.getValue().getDisplayValue() : "n/a";
								units[i] = (coordinate.getUnit() != null) ? coordinate.getUnit().toString() : "  ";
							}
						if (count >= 0)
							{
								int columnWidth = (width - 6) / 5;
								int doubleColumnWidth = 2 * columnWidth;
								GOUtils.drawItems(captions, textColor, onCanvas, x + 2, y + 2, doubleColumnWidth, height);
								onCanvas.drawLine(x + doubleColumnWidth + 1, y + 3, x + doubleColumnWidth + 1, y + height - 3);
								GOUtils.drawItems(values, textColor, onCanvas, x + doubleColumnWidth + 2, y + 2, doubleColumnWidth, height);
								GOUtils.drawItems(units, textColor, onCanvas, x + 2 * doubleColumnWidth + 2, y + 2, columnWidth, height);
							}
					}
			}
		
		
		static public void drawProperties(DataValues dataValues, Color textColor, Graphics2D onCanvas, int x, int y, int width, int height)
			{
				if (dataValues != null)
					{
						int count = dataValues.getAssignedValuesCount();
						count = Math.min(count, (int) ((Math.floor((height / (DefaultGOSettings.textRowHeight))))));
						
						String[] captions = dataValues.getCaptions(true);
						String[] values = dataValues.getValues(true);
						if (count >= 0)
							{
								int columnWidth = (width - 6) / 3;
								int doubleColumnWidth = 2 * columnWidth;
								GOUtils.drawItems(captions, textColor, onCanvas, x + 2, y + 2, columnWidth, height);
								onCanvas.drawLine(x + columnWidth + 1, y + 3, x + columnWidth + 1, y + height - 3);
								GOUtils.drawItems(values, textColor, onCanvas, x + columnWidth + 2, y + 2, doubleColumnWidth, height);
							}
					}
			}
	
		public static void drawPathways(Pathway[] pathways, Color textColor, Graphics2D onCanvas, int x, int y, int width, int height)
			{
				int count = pathways.length;
				count = Math.min(count, count * ((int) Math.floor(height / DefaultGOSettings.rowHeight)));
				int offset = 0;
				for (int i = 0; i < count; i++)
					if (pathways[i] != null)
						offset += GOUtils.drawText(pathways[i].getTitle(), textColor, onCanvas, x + 2, y + 2 + offset, width, height - offset);
				
			}
		
		static public void drawReferences(Reference[] references, Color textColor, Graphics2D onCanvas, int x, int y, int width, int height)
			{
				int count = references.length;
				count = Math.min(count, count * ((int) Math.floor(height / DefaultGOSettings.rowHeight)));
				int offset = 0;
				for (int i = 0; i < count; i++)
					if (references[i] != null)
						offset += GOUtils.drawHangingText(references[i].getFormatedReference(), textColor, onCanvas, x + 2, y + 2 + offset, width, height - offset);
			}
		
		public static void visibleBounds(int x, int y, int width, int height)
			{
				visibleX = x;
			}
		
		public static int	visibleX;
		public static int	visibleY;
		public static int	visibleWidth;
		public static int	visibleHeight;
		
	}

package org.qsari.effectopedia.go.pathway_elements;

import java.awt.Color;
import java.awt.Graphics2D;

import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.objects.Reference;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.GOUtils;
import org.qsari.effectopedia.go.IOPort;
import org.qsari.effectopedia.go.SVGUtils;
import org.qsari.effectopedia.go.Standard8IOPorts;
import org.qsari.effectopedia.go.Standard8IOPorts.Distribution;
import org.qsari.effectopedia.go.StandardGOSize;

public class LinkPEGO extends PathwayElementGO
	{
		
		public LinkPEGO(PathwayElement o)
			{
				super(o);
				ports = new Standard8IOPorts(this, Distribution.CIRCULAR);
			}
			
		public void drawLinkType(Graphics2D onCanvas, int x, int y, int width, int height)
			{
				if (o != null)
					{
						onCanvas.setColor(selected ? active ? DefaultGOSettings.activeSelectionColor : DefaultGOSettings.selectionColor : active ? activeColor : color);
						int diameter = Math.min(DefaultGOSettings.linkIconRadius, Math.min(width, height));
						int r = diameter >> 1;
						if (temporary)
							{
								onCanvas.setStroke(DefaultGOSettings.contourTmpPen);
								onCanvas.drawOval(x, y, diameter, diameter);
							}
						else
							{
								onCanvas.setStroke(DefaultGOSettings.contourPen);
								onCanvas.fillOval(x, y, diameter, diameter);
								onCanvas.setColor(Color.WHITE);
								if (active)
									onCanvas.drawOval(x + 3, y + 3, diameter - 7, diameter - 7);
								else
									onCanvas.drawOval(x + 2, y + 2, diameter - 5, diameter - 5);
							}
						if (diameter - 5 > DefaultGOSettings.textRowHeight)
							{
								switch (((Link) o).getLinkNature())
									{
										case HYPOTHETICAL:
											GOUtils.drawLine("H", temporary ? color : Color.WHITE, onCanvas, x + 1, y, width, height);
											break;
										case METABOLIC:
											GOUtils.drawLine("M", Color.WHITE, onCanvas, x + 1, y, width, height);
											break;
										case HARDWIRE:
											onCanvas.setStroke(DefaultGOSettings.insidePen);
											onCanvas.setColor(Color.WHITE);
											IOPort first = ports.getFirstUsed();
											IOPort last = ports.getLastUsed();
											onCanvas.drawLine(first.getX(), first.getY(), x + r, y + r);
											onCanvas.drawLine(x + r, y + r, last.getX(), last.getY());
											onCanvas.drawOval(x + r - 1, y + r - 1, 2, 2);
											break;
										case THRESHOLD:
											onCanvas.setStroke(DefaultGOSettings.insidePen);
											onCanvas.setColor(Color.WHITE);
											onCanvas.drawLine(x + 8, y + diameter - 8, x + r, y + diameter - 8);
											onCanvas.drawLine(x + r, y + diameter - 9, x + r, y + 9);
											onCanvas.drawLine(x + r, y + 8, x + diameter - 8, y + 8);
											break;
										case LINEAR:
											onCanvas.setStroke(DefaultGOSettings.insidePen);
											onCanvas.setColor(Color.WHITE);
											onCanvas.drawLine(x + 8, y + diameter - 8, x + diameter - 8, y + 8);
											onCanvas.setStroke(DefaultGOSettings.insidePen);
											break;
										case DOSE_RESPONSE:
										case RESPONSE_RESPONSE:
											onCanvas.setStroke(DefaultGOSettings.insidePen);
											onCanvas.setColor(Color.WHITE);
											onCanvas.drawArc(x + r, y + 8, 6, 6, 90, 90);
											onCanvas.drawArc(x + r - 6, y + 8, 6, 6, 270, 90);
											break;
									}
									
							}
						ports.updatePortLocations(x, y, width, height);
					}
			}
			
		public void drawLinkTitle(Graphics2D onCanvas, int x, int y, int width, int height)
			{
				if (o != null)
					{
						int xRect = x + DefaultGOSettings.linkIconOffset;
						int yRect = y + DefaultGOSettings.linkIconOffset;
						int widthRect = width - DefaultGOSettings.linkIconOffset;
						int heightRect = height - DefaultGOSettings.linkIconOffset;
						int offset = DefaultGOSettings.linkIconRadius - DefaultGOSettings.linkIconOffset;
						
						if (widthRect > DefaultGOSettings.linkIconRadius)
							{
								onCanvas.setStroke(DefaultGOSettings.contourPen);
								onCanvas.drawRect(xRect, yRect, widthRect, heightRect);
								onCanvas.setColor(Color.WHITE);
								onCanvas.fillRect(xRect + 2, yRect + 2, widthRect - 4, heightRect - 4);
								if (height < DefaultGOSettings.linkIconRadius)
									onCanvas.fillRect(x - 1, y - 1, DefaultGOSettings.linkIconRadius / 2, DefaultGOSettings.linkIconRadius + 1);
								else
									onCanvas.fillRect(x - 1, y - 1, DefaultGOSettings.linkIconRadius / 2, DefaultGOSettings.linkIconRadius / 2);
								
								Color c = (selected) ? Color.red : color;
								GOUtils.drawCaption(((Link) o).getTitle(), c, onCanvas, xRect + offset + 3, yRect + 1, widthRect - offset - DefaultGOSettings.linkIconOffset - 5, heightRect - 5);
								
								drawLinkType(onCanvas, x, y, Math.min(DefaultGOSettings.linkIconRadius, width), Math.min(DefaultGOSettings.linkIconRadius, height));
							}
						else
							drawLinkType(onCanvas, x + (width - DefaultGOSettings.linkIconRadius) / 2, y, Math.min(DefaultGOSettings.linkIconRadius, width), Math.min(DefaultGOSettings.linkIconRadius, height));
					}
			}
			
		public void drawLinkDescription(Graphics2D onCanvas, int x, int y, int width, int height)
			{
				if (o != null)
					{
						int xRect = x + DefaultGOSettings.linkIconOffset;
						int yRect = y + DefaultGOSettings.linkIconOffset;
						int widthRect = width - DefaultGOSettings.linkIconOffset;
						int heightRect = height - DefaultGOSettings.linkIconOffset;
						int offset = DefaultGOSettings.linkIconRadius - DefaultGOSettings.linkIconOffset;
						
						onCanvas.setStroke(DefaultGOSettings.contourPen);
						onCanvas.drawRect(xRect, yRect, widthRect, heightRect);
						onCanvas.setColor(Color.WHITE);
						onCanvas.fillRect(xRect + 2, yRect + 2, widthRect - 4, heightRect - 4);
						onCanvas.fillRect(x - 1, y - 1, DefaultGOSettings.linkIconRadius / 2, DefaultGOSettings.linkIconRadius / 2);
						
						Color c = selected ? active ? DefaultGOSettings.activeSelectionColor : DefaultGOSettings.selectionColor : active ? activeColor : color;
						
						if (height > DefaultGOSettings.rowHeight)
							{
								Link link = (Link) o;
								GOUtils.drawCaption(link.getTitle(), c, onCanvas, xRect + offset + 3, yRect + 1, widthRect - offset - DefaultGOSettings.linkIconOffset - 5, DefaultGOSettings.rowHeight);
								onCanvas.setStroke(DefaultGOSettings.insidePen);
								
								if (link.getDescriptionIDs().size() > 0)
									GOUtils.drawDescriptionSection((DescriptionSection) link.getDescriptionIDs().getCachedObject(0), c, onCanvas, xRect,
											yRect + ((heightRect < DefaultGOSettings.rowHeight) ? 0 : DefaultGOSettings.rowHeight), widthRect, heightRect - DefaultGOSettings.rowHeight);
							}
							
						drawLinkType(onCanvas, x, y, Math.min(DefaultGOSettings.linkIconRadius, width), Math.min(DefaultGOSettings.linkIconRadius, height));
					}
			}
			
		public void drawLinkALL(Graphics2D onCanvas, int x, int y, int width, int height)
			{
				if (o != null)
					{
						int xRect = x + DefaultGOSettings.linkIconOffset;
						int yRect = y + DefaultGOSettings.linkIconOffset;
						int widthRect = width - DefaultGOSettings.linkIconOffset;
						int heightRect = height - DefaultGOSettings.linkIconOffset;
						int offset = DefaultGOSettings.linkIconRadius - DefaultGOSettings.linkIconOffset;
						
						onCanvas.setStroke(DefaultGOSettings.contourPen);
						onCanvas.drawRect(xRect, yRect, widthRect, heightRect);
						onCanvas.setColor(Color.WHITE);
						onCanvas.fillRect(xRect + 2, yRect + 2, widthRect - 4, heightRect - 4);
						onCanvas.fillRect(x - 1, y - 1, DefaultGOSettings.linkIconRadius / 2, DefaultGOSettings.linkIconRadius / 2);
						
						Color c = selected ? active ? DefaultGOSettings.activeSelectionColor : DefaultGOSettings.selectionColor : active ? activeColor : color;
						
						if (height > DefaultGOSettings.rowHeight)
							{
								Link link = (Link) o;
								GOUtils.drawCaption(link.getTitle(), c, onCanvas, xRect + offset + 3, yRect + 1, widthRect - offset - DefaultGOSettings.linkIconOffset - 5, DefaultGOSettings.rowHeight);
								onCanvas.setStroke(DefaultGOSettings.insidePen);
								
								int sectionHeight = (heightRect) / 2;
								int yOffset = yRect + ((height < DefaultGOSettings.rowHeight) ? 0 : DefaultGOSettings.rowHeight);
								if (link.getDescriptionIDs().size() > 0)
									{
										GOUtils.drawDescriptionSection((DescriptionSection) link.getDescriptionIDs().getCachedObject(0), c, onCanvas, xRect, yOffset, widthRect, sectionHeight);
										yOffset += sectionHeight;
									}
								if (link.getReferenceIDs().size() > 0)
									GOUtils.drawReferences((Reference[]) link.getReferenceIDs().getCachedObjects(), c, onCanvas, xRect, yOffset, widthRect, sectionHeight);
								
							}
						drawLinkType(onCanvas, x, y, Math.min(DefaultGOSettings.linkIconRadius, width), Math.min(DefaultGOSettings.linkIconRadius, height));
					}
			}
			
		public void draw(Graphics2D onCanvas)
			{
				if (onCanvas.hitClip(x, y, width, height))
					{
						onCanvas.setColor(selected ? active ? DefaultGOSettings.activeSelectionColor : DefaultGOSettings.selectionColor : active ? activeColor : color);
						int r = Math.min(height, width);
						if (r <= DefaultGOSettings.linkIconRadius)
							drawLinkType(onCanvas, x + (width - r) / 2, y + (height - r) / 2, r, r);
						else
							switch (details)
								{
									case NO:
										drawLinkType(onCanvas, x + (width - r) / 2, y + (height - r) / 2, r, r);
										break;
									case LOW:
										drawLinkType(onCanvas, x + (width - r) / 2, y + (height - r) / 2, r, r);
										break;
									case MEDIUM:
										ports.updatePortLocations();
										drawLinkTitle(onCanvas, x, y, width, height);
										break;
									case HIGH:
										ports.updatePortLocations();
										drawLinkDescription(onCanvas, x, y, width, height);
										break;
									case ALL:
										ports.updatePortLocations();
										drawLinkALL(onCanvas, x, y, width, height);
										break;
								}
					}
			}
			
		public void exportDimensions(StringBuilder sb, int r)
			{
				sb.append(" cx=\"");
				sb.append(x + width / 2);
				sb.append("\" cy=\"");
				sb.append(y + height / 2);
				sb.append("\" r=\"");
				sb.append(r);
				sb.append("\"");
			}
			
		public void exportLinkType(StringBuilder sb)
			{
				if (o != null)
					{
						int diameter = Math.min(DefaultGOSettings.linkIconRadius, Math.min(width, height));
						int r = diameter >> 1;
						sb.append("<circle");
						exportDimensions(sb, r - 3);
						sb.append(" style=\" fill: #");
						sb.append(Integer.toHexString(color.getRGB()).substring(2));
						sb.append("; stroke: none;\"/>\n");
						if (diameter - 5 > DefaultGOSettings.textRowHeight)
							{
								switch (((Link) o).getLinkNature())
									{
										case HYPOTHETICAL:
											SVGUtils.addTextOpeningTag(sb, x + r - 4, y + DefaultGOSettings.rowHeight - 1, Color.white);
											sb.append("H");
											sb.append("</text>\n");
											break;
										case METABOLIC:
											SVGUtils.addTextOpeningTag(sb, x + r - 4, y + DefaultGOSettings.rowHeight - 1, Color.white);
											sb.append("M");
											sb.append("</text>\n");
											break;
										case HARDWIRE:
											IOPort first = ports.getFirstUsed();
											IOPort last = ports.getLastUsed();
											SVGUtils.addLine(sb, first.getX(), first.getY(), x + r, y + r, Color.white, 1);
											SVGUtils.addLine(sb, x + r, y + r, last.getX(), last.getY(), Color.white, 1);
											SVGUtils.addCircle(sb, x + r, y + r, 2, Color.white, Color.white, 1);
											break;
										case THRESHOLD:
											SVGUtils.addLine(sb, x + 8, y + diameter - 8, x + r, y + diameter - 8, Color.white, 1);
											SVGUtils.addLine(sb, x + r, y + diameter - 9, x + r, y + 9, Color.white, 1);
											SVGUtils.addLine(sb, x + r, y + 8, x + diameter - 8, y + 8, Color.white, 1);
											break;
										case LINEAR:
											SVGUtils.addLine(sb, x + 8, y + diameter - 8, x + diameter - 8, y + 8, Color.white, 1);
											break;
										case DOSE_RESPONSE:
										case RESPONSE_RESPONSE:
											SVGUtils.addPathOpeningTag(sb, Color.white, 1);
											SVGUtils.addArc(sb, x + diameter - 5, y + r + 1, 6, 90, 170);
											sb.append("\"/>\n");
											SVGUtils.addPathOpeningTag(sb, Color.white, 1);
											SVGUtils.addArc(sb, x + r - 6, y + r - 1, 6, 270, 350);
											sb.append("\"/>\n");
											break;
									}
									
							}
						ports.updatePortLocations(x, y, width, height);
					}
			}
			
		public void exportToSVG(StringBuilder base, StringBuilder pathwayElementsGroup)
			{
				if (visible)
					{
						pathwayElementsGroup.append("<g");
						exportID(pathwayElementsGroup);
						pathwayElementsGroup.append(">\n");
						exportLink(pathwayElementsGroup);
						pathwayElementsGroup.append("<circle");
						exportID(pathwayElementsGroup);
						exportDimensions(pathwayElementsGroup, Math.min(height, width) / 2);
						exportPresentationAttributes(pathwayElementsGroup);
						pathwayElementsGroup.append("/>\n");
						exportLinkType(pathwayElementsGroup);
						pathwayElementsGroup.append("</a>\n");
						pathwayElementsGroup.append("</g>\n");
					}
			}
			
		@Override
		public Color getColor()
			{
				return color;
			}
			
		public StandardGOSize getStandardSize()
			{
				return defaultLinkPEGOUnscalledSize;
			}
			
		public static void setStandardSize(StandardGOSize newGOSize)
			{
				defaultLinkPEGOUnscalledSize = newGOSize;
			}
			
		private Color																color																								= DefaultGOSettings.linkColor;
		private Color																activeColor																		= DefaultGOSettings.activeLinkColor;
		
		static public StandardGOSize	defaultLinkPEGOUnscalledSize	= new StandardGOSize(DefaultGOSettings.hVisWeigthLink, DefaultGOSettings.vVisWeigthLink);
		
	}

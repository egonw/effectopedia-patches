package org.qsari.effectopedia.go.pathway_elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.core.objects.Link;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.objects.Reference;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.GOUtils;
import org.qsari.effectopedia.go.SVGUtils;
import org.qsari.effectopedia.go.Standard2NSIOPorts;
import org.qsari.effectopedia.go.StandardGOSize;

public class TestResponseMappingPEGO extends PathwayElementGO
	{
		
		public TestResponseMappingPEGO(PathwayElement o)
			{
				super(o);
				ports = new Standard2NSIOPorts(this);
			}
			
		public void drawMappingType(Graphics2D onCanvas, int x, int y, int width, int height)
			{
				if (o != null)
					{
						onCanvas.setColor(selected ? active ? DefaultGOSettings.activeSelectionColor : DefaultGOSettings.selectionColor : active ? activeColor : color);
						Polygon rohmbus = new Polygon();
						int midX = x + (width >> 1);
						int midY = y + (height >> 1);
						int inset = 2;
						rohmbus.addPoint(midX, y);
						rohmbus.addPoint(x + width, midY);
						rohmbus.addPoint(midX, y + height);
						rohmbus.addPoint(x, midY);
						onCanvas.fillPolygon(rohmbus);
						if (width > 8)
							{
								Polygon rohmbusOutline = new Polygon();
								rohmbusOutline.addPoint(midX, y + inset);
								rohmbusOutline.addPoint(x + width - inset, midY);
								rohmbusOutline.addPoint(midX, y + height - inset);
								rohmbusOutline.addPoint(x + inset, midY);
								onCanvas.setStroke(temporary ? DefaultGOSettings.contourTmpPen : DefaultGOSettings.contourPen);
								onCanvas.setColor(Color.WHITE);
								onCanvas.drawPolygon(rohmbusOutline);
							}
							
						if (height > 10)
							if (((TestResponseMapping) o).hasTransformationSets())
								GOUtils.drawLine("f", Color.WHITE, onCanvas, x + inset - 2, y, width, height);
							else
								GOUtils.drawLine("?", Color.WHITE, onCanvas, x + inset, y, width, height);
						ports.updatePortLocations(x, y, width, height);
					}
			}
			
		public void drawMappingTitle(Graphics2D onCanvas, int x, int y, int width, int height)
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
								
								drawMappingType(onCanvas, x, y, Math.min(DefaultGOSettings.linkIconRadius, width), Math.min(DefaultGOSettings.linkIconRadius, height));
							}
						else
							drawMappingType(onCanvas, x + (width - DefaultGOSettings.linkIconRadius) / 2, y, Math.min(DefaultGOSettings.linkIconRadius, width), Math.min(DefaultGOSettings.linkIconRadius, height));
					}
			}
			
		public void drawMappingDescription(Graphics2D onCanvas, int x, int y, int width, int height)
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
								TestResponseMapping trm = (TestResponseMapping) o;
								GOUtils.drawCaption(trm.getTitle(), c, onCanvas, xRect + offset + 3, yRect + 1, widthRect - offset - DefaultGOSettings.linkIconOffset - 5, DefaultGOSettings.rowHeight);
								onCanvas.setStroke(DefaultGOSettings.insidePen);
								
								if (trm.getDescriptionIDs().size() > 0)
									GOUtils.drawDescriptionSection((DescriptionSection) trm.getDescriptionIDs().getCachedObject(0), c, onCanvas, xRect,
											yRect + ((heightRect < DefaultGOSettings.rowHeight) ? 0 : DefaultGOSettings.rowHeight), widthRect, heightRect - DefaultGOSettings.rowHeight);
							}
							
						drawMappingType(onCanvas, x, y, Math.min(DefaultGOSettings.linkIconRadius, width), Math.min(DefaultGOSettings.linkIconRadius, height));
					}
			}
			
		public void drawMappingALL(Graphics2D onCanvas, int x, int y, int width, int height)
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
								TestResponseMapping trm = (TestResponseMapping) o;
								GOUtils.drawCaption(trm.getTitle(), c, onCanvas, xRect + offset + 3, yRect + 1, widthRect - offset - DefaultGOSettings.linkIconOffset - 5, DefaultGOSettings.rowHeight);
								onCanvas.setStroke(DefaultGOSettings.insidePen);
								
								int sectionHeight = (heightRect) / 2;
								int yOffset = yRect + ((height < DefaultGOSettings.rowHeight) ? 0 : DefaultGOSettings.rowHeight);
								if (trm.getDescriptionIDs().size() > 0)
									{
										GOUtils.drawDescriptionSection((DescriptionSection) trm.getDescriptionIDs().getCachedObject(0), c, onCanvas, xRect, yOffset, widthRect, sectionHeight);
										yOffset += sectionHeight;
									}
								if (trm.getReferenceIDs().size() > 0)
									GOUtils.drawReferences((Reference[]) trm.getReferenceIDs().getCachedObjects(), c, onCanvas, xRect, yOffset, widthRect, sectionHeight);
								
							}
						drawMappingType(onCanvas, x, y, Math.min(DefaultGOSettings.linkIconRadius, width), Math.min(DefaultGOSettings.linkIconRadius, height));
					}
			}
			
		public void draw(Graphics2D onCanvas)
			{
				if (onCanvas.hitClip(x, y, width, height))
					{
						onCanvas.setColor(selected ? active ? DefaultGOSettings.activeSelectionColor : DefaultGOSettings.selectionColor : active ? activeColor : color);
						if ((height <= DefaultGOSettings.mappingIconHeight) || (width <= DefaultGOSettings.mappingIconWidth))
							drawMappingType(onCanvas, x, y, width, height);
						else
							switch (details)
								{
									case NO:
										drawMappingType(onCanvas, x, y, width, height);
										break;
									case LOW:
										drawMappingType(onCanvas, x, y, width, height);
										break;
									case MEDIUM:
										ports.updatePortLocations();
										drawMappingTitle(onCanvas, x, y, width, height);
										break;
									case HIGH:
										ports.updatePortLocations();
										drawMappingDescription(onCanvas, x, y, width, height);
										break;
									case ALL:
										ports.updatePortLocations();
										drawMappingALL(onCanvas, x, y, width, height);
										break;
								}
					}
			}
			
		public void exportMappingTypeToSVG(StringBuilder sb, int x, int y, int width, int height, Color color)
			{
				if (o != null)
					{
						int inset = 4;
						
						if (height > 10)
							if (((TestResponseMapping) o).hasTransformationSets())
								SVGUtils.addCaption("f", sb, x + inset - 2, y, width, height, Color.white);
							else
								SVGUtils.addCaption("?", sb, x + inset, y + 1, width, height, Color.white);
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
						SVGUtils.addFilledRhomb(pathwayElementsGroup, x, y, width, height, getColor(), getColor());
						SVGUtils.addFilledRhomb(pathwayElementsGroup, x + 3, y + 3, width - 6, height - 6, getColor(), Color.white);
						exportMappingTypeToSVG(pathwayElementsGroup, x + 3, y + 3, width - 6, height - 6, getColor());
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
				return defaultMappingEGOCUnscalledSize;
			}
			
		public static void setStandardSize(StandardGOSize newGOSize)
			{
				defaultMappingEGOCUnscalledSize = newGOSize;
			}
			
		private Color																color																											= DefaultGOSettings.inVitroTestColor;
		private Color																activeColor																					= DefaultGOSettings.activeInVitroTestColor;
		static public StandardGOSize	defaultMappingEGOCUnscalledSize	= new StandardGOSize(DefaultGOSettings.hVisWeigthMapping, DefaultGOSettings.vVisWeigthMapping);
	}

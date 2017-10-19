package org.qsari.effectopedia.go.pathway_elements;

import java.awt.Color;
import java.awt.Graphics2D;

import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.objects.Test;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.SVGUtils;
import org.qsari.effectopedia.go.Standard2NSIOPorts;
import org.qsari.effectopedia.go.StandardGOSize;

public class TestCPEGO extends ContextPEGO
	{
		
		public TestCPEGO(PathwayElement o)
			{
				super(o);
				ports = new Standard2NSIOPorts(this);
				if (o instanceof Test)
					switch (((Test) o).getTestType())
						{
							case IN_CHEMICO:
							case IN_VITRO:
							case UNDEFINED:
								color = DefaultGOSettings.inVitroTestColor;
								activeColor = DefaultGOSettings.activeInVitroTestColor;
								break;
							case IN_VIVO:
							case EX_VIVO:
								color = DefaultGOSettings.inVivoTestColor;
								activeColor = DefaultGOSettings.activeInVivoTestColor;
								break;
							case IN_SILICO:
								color = DefaultGOSettings.inSilicoTestColor;
								activeColor = DefaultGOSettings.activeInSilicoTestColor;
								break;
						}
				update();
			}
			
		public void update()
			{
				sections.clear();
				sections.addSectionsCodes(displayOptions);
			}
			
		/*
		 * public void drawTestID(Graphics2D onCanvas, int x, int y, int width, int
		 * height) { if (o != null) { onCanvas.setStroke(DefaultGOSettings.insidePen);
		 * onCanvas.fillRect(x + 3, y + 3, width - 5, height - 5); if (height >=
		 * DefaultGOSettings.textRowHeight) GOUtils.drawLine(o.toString(),
		 * Color.white, onCanvas, x + 2, y + 1, width, height); } }
		 * 
		 * public void drawTitle(Graphics2D onCanvas, int x, int y, int width, int
		 * height) { if (o != null) { onCanvas.setStroke(DefaultGOSettings.insidePen);
		 * onCanvas.setColor(Color.WHITE); onCanvas.fillRect(x + 3, y + 3, width - 5,
		 * height - 5); if (height >= DefaultGOSettings.rowHeight)
		 * GOUtils.drawCaption("Test title", color, onCanvas, x + 2, y + 1, width,
		 * height); } }
		 * 
		 * public void drawWithDescription(Graphics2D onCanvas, int x, int y, int
		 * width, int height) { if (o != null) {
		 * onCanvas.setStroke(DefaultGOSettings.insidePen); Color c =
		 * onCanvas.getColor(); onCanvas.setColor(Color.white); onCanvas.fillRect(x +
		 * 2, y + 2, width - 4, height - 4); int titleWidth = width * 2 / 3; int
		 * idWidth = width - titleWidth; if (height > DefaultGOSettings.rowHeight) {
		 * Test test = (Test) o; GOUtils.drawCaption(test.getTitle(), c, onCanvas, x +
		 * 2, y + 1, titleWidth, DefaultGOSettings.rowHeight); onCanvas.fillRect(x +
		 * titleWidth + 3, y + 3, width - titleWidth - 5, DefaultGOSettings.rowHeight
		 * - 5); GOUtils.drawLine(String.valueOf(test.getExternalID()), Color.white,
		 * onCanvas, x + titleWidth + 2, y + 1, idWidth,
		 * DefaultGOSettings.rowHeight);// ID
		 * 
		 * if (test.getDescriptionIDs().size() > 0)
		 * GOUtils.drawDescriptionSection((DescriptionSection)
		 * test.getDescriptionIDs().getCachedObject(0), c, onCanvas, x, y + ((height <
		 * DefaultGOSettings.rowHeight) ? 0 : DefaultGOSettings.rowHeight), width,
		 * height - DefaultGOSettings.rowHeight); } } }
		 * 
		 * public void drawAll(Graphics2D onCanvas, int x, int y, int width, int
		 * height) { if (o != null) { onCanvas.setStroke(DefaultGOSettings.insidePen);
		 * Color c = onCanvas.getColor(); onCanvas.setColor(Color.white);
		 * onCanvas.fillRect(x + 3, y + 3, width - 5, height - 5); int titleWidth =
		 * width * 2 / 3; int idWidth = width - titleWidth; { Test test = (Test) o; if
		 * (height >= DefaultGOSettings.rowHeight)
		 * GOUtils.drawCaption(test.getTitle(), c, onCanvas, x + 2, y + 1, titleWidth,
		 * DefaultGOSettings.rowHeight); onCanvas.fillRoundRect(x + titleWidth + 3, y
		 * + 3, width - titleWidth - 5, DefaultGOSettings.rowHeight - 5, 6, 6);
		 * GOUtils.drawLine(String.valueOf(test.getExternalID()), Color.white,
		 * onCanvas, x + titleWidth + 2, y + 1, idWidth,
		 * DefaultGOSettings.rowHeight);// ID if (height >=
		 * DefaultGOSettings.rowHeight * 2) { int sectionHeight = (height -
		 * DefaultGOSettings.rowHeight) / 3; int yOffset = y + ((height <
		 * DefaultGOSettings.rowHeight) ? 0 : DefaultGOSettings.rowHeight); if
		 * (test.getDescriptionIDs().size() > 0) {
		 * GOUtils.drawDescriptionSection((DescriptionSection)
		 * test.getDescriptionIDs().getCachedObject(0), c, onCanvas, x, yOffset,
		 * width, sectionHeight); yOffset += sectionHeight; } if
		 * (test.getCoordinates().count() > 0) {
		 * GOUtils.drawContext(test.getCoordinates(), c, onCanvas, x, yOffset, width,
		 * sectionHeight); yOffset += sectionHeight; } if
		 * (test.getReferenceIDs().size() > 0) GOUtils.drawReferences((Reference[])
		 * test.getReferenceIDs().getCachedObjects(), c, onCanvas, x, yOffset, width,
		 * sectionHeight); } } } }
		 * 
		 * public void draw(Graphics2D onCanvas) { if (onCanvas.hitClip(x, y, width,
		 * height)) { onCanvas.setColor((active || selected) ? Color.red : color);
		 * onCanvas.setStroke(DefaultGOSettings.contourPen); onCanvas.drawRect(x, y,
		 * width, height); if (!selected) onCanvas.setColor(color); switch (details) {
		 * case NO: onCanvas.setStroke(DefaultGOSettings.insidePen);
		 * onCanvas.fillRect(x + 3, y + 3, width - 5, height - 5); break; case LOW:
		 * drawTestID(onCanvas, x, y, width, height); break; case MEDIUM:
		 * drawTitle(onCanvas, x, y, width, height); break; case HIGH:
		 * drawWithDescription(onCanvas, x, y, width, height); break; case ALL:
		 * drawAll(onCanvas, x, y, width, height); break; } } }
		 */
		public void draw(Graphics2D onCanvas)
			{
				if (onCanvas.hitClip(x, y, width, height))
					{
						Color displayWithColor = selected ? active ? DefaultGOSettings.activeSelectionColor : DefaultGOSettings.selectionColor : active ? activeColor : color;
						onCanvas.setColor(displayWithColor);
						onCanvas.setStroke(temporary ? DefaultGOSettings.contourTmpPen : active ? DefaultGOSettings.activeContourPen : DefaultGOSettings.contourPen);
						onCanvas.drawRect(x, y, width, height);
						onCanvas.setStroke(temporary ? DefaultGOSettings.insideTmpPen : DefaultGOSettings.insidePen);
						onCanvas.setColor(Color.white);
						onCanvas.fillRect(x + 2, y + 2, width - 4, height - 4);
						sections.draw(o, onCanvas, x + 2, y + 2, width - 4, height - 4, displayWithColor);
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
						pathwayElementsGroup.append("<rect");
						exportDimensions(pathwayElementsGroup);
						exportPresentationAttributes(pathwayElementsGroup);
						pathwayElementsGroup.append("/>\n");
						SVGUtils.addMultilineCaptionAndID(o, pathwayElementsGroup, x, y, width, height, getColor());
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
				return defaultTestCPEGOUnscalledSize;
			}
			
		public static void setStandardSize(StandardGOSize newGOSize)
			{
				defaultTestCPEGOUnscalledSize = newGOSize;
			}
			
		static public StandardGOSize	defaultTestCPEGOUnscalledSize	= new StandardGOSize(DefaultGOSettings.hVisWeigthTest, DefaultGOSettings.vVisWeigthTest);
		
		public static int												displayOptions																= DisplaySection.TEST_DEFAULTS;
		private Color																color																									= DefaultGOSettings.inVitroTestColor;
		private Color																activeColor																			= DefaultGOSettings.activeInVitroTestColor;
	}

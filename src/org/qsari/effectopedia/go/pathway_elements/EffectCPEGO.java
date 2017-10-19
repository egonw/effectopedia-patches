package org.qsari.effectopedia.go.pathway_elements;

import java.awt.Color;
import java.awt.Graphics2D;

import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.Standard8IOPorts;
import org.qsari.effectopedia.go.Standard8IOPorts.Distribution;
import org.qsari.effectopedia.go.StandardGOSize;

public class EffectCPEGO extends ContextPEGO
	{
		
		public EffectCPEGO(Effect o)
			{
				super(o);
				ports = new Standard8IOPorts(this, Distribution.ROUNDRECTANGULAR);
				update();
			}
			
		public void update()
			{
				sections.clear();
				sections.addSectionsCodes(displayOptions);
			}
			
		public void draw(Graphics2D onCanvas)
			{
				if (onCanvas.hitClip(x, y, width, height))
					{
						Color displayWithColor = selected ? active ? DefaultGOSettings.activeSelectionColor : DefaultGOSettings.selectionColor : active ? activeColor : color;
						onCanvas.setColor(displayWithColor);
						onCanvas.setStroke(temporary ? DefaultGOSettings.contourTmpPen : active?DefaultGOSettings.activeContourPen:DefaultGOSettings.contourPen);
						onCanvas.drawRoundRect(x, y, width, height, 8, 8);
						onCanvas.setStroke(temporary ? DefaultGOSettings.insideTmpPen : DefaultGOSettings.insidePen);
						if (!selected)
							onCanvas.setColor(color);
						onCanvas.setColor(Color.white);
						onCanvas.fillRoundRect(x + 2, y + 2, width - 3, height - 3, 6, 6);
						sections.draw(o, onCanvas, x, y, width, height, displayWithColor);
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
						pathwayElementsGroup.append(" rx=\"6\" ry=\"6\"");
						exportPresentationAttributes(pathwayElementsGroup);
						pathwayElementsGroup.append("/>\n");
						sections.exportToSVG(o, pathwayElementsGroup, x, y, width, height, color);
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
				return defaultEffectCPEGOUnscalledSize;
			}
			
		public static void setStandardSize(StandardGOSize newGOSize)
			{
				defaultEffectCPEGOUnscalledSize = newGOSize;
			}
			
		public static int												displayOptions																		= DisplaySection.EFFECT_DEFAULTS;
		public static StandardGOSize	defaultEffectCPEGOUnscalledSize	= new StandardGOSize(DefaultGOSettings.hVisWeigthEffect, DefaultGOSettings.vVisWeigthEffect);
		private Color																color																											= DefaultGOSettings.effectColor;
		private Color																activeColor																					= DefaultGOSettings.activeEffectColor;
	}

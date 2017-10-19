package org.qsari.effectopedia.go.pathway_elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import org.qsari.effectopedia.core.objects.Initiator_BiologcalPerturbation;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.GOUtils;
import org.qsari.effectopedia.go.Standard8IOPorts;
import org.qsari.effectopedia.go.Standard8IOPorts.Distribution;
import org.qsari.effectopedia.go.StandardGOSize;

public class BiologicalPerturbationSPEGO extends SubstancePEGO
	{
		
		public BiologicalPerturbationSPEGO(PathwayElement o)
			{
				super(o);
				ports = new Standard8IOPorts(this, Distribution.RECTANGULAR);
			}
			
		public void drawChemicalID(Graphics2D onCanvas, int x, int y, int width, int height)
			{
				if (o != null)
					{
						onCanvas.setStroke(temporary ? DefaultGOSettings.insideTmpPen : DefaultGOSettings.insidePen);
						onCanvas.fillRect(x + 3, y + 3, width - 5, height - 5);
						GOUtils.drawLine(o.toString(), Color.white, onCanvas, x + 2, y + 1, width, height);
					}
			}
			
		public void drawCAS_Name(Graphics2D onCanvas, int x, int y, int width, int height)
			{
				if (o != null)
					{
						onCanvas.setStroke(temporary ? DefaultGOSettings.insideTmpPen : DefaultGOSettings.insidePen);
						onCanvas.setColor(Color.WHITE);
						onCanvas.fillRect(x + 3, y + 3, width - 5, height - 5);
						GOUtils.drawCaption("CAS:xxxx-xx-x Name: Some chemical name", color, onCanvas, x + 2, y + 1, width, height);
					}
			}
			
		public void drawChemical(Graphics2D onCanvas, int x, int y, int width, int height)
			{
				if (o != null)
					{
						Color c = onCanvas.getColor();
						onCanvas.setStroke(temporary ? DefaultGOSettings.insideTmpPen : DefaultGOSettings.insidePen);
						onCanvas.setColor(Color.WHITE);
						onCanvas.fillRect(x + 3, y + 3, width - 5, height - 5);
						if (height > DefaultGOSettings.rowHeight)
							{
								Initiator_BiologcalPerturbation bp = (Initiator_BiologcalPerturbation) o;
								GOUtils.drawCaption(bp.getTitle(), c, onCanvas, x + 2, y + 1, width - 4, DefaultGOSettings.rowHeight);
								y += DefaultGOSettings.rowHeight;
								height -= DefaultGOSettings.rowHeight;
								onCanvas.drawLine(x + 3, y, x + width - 3, y);
								int halfWidth = ((width - 5) / 2) - 2;
								int h = (height > halfWidth) ? halfWidth : height;
								onCanvas.drawRoundRect(x + 3, y + 3, halfWidth, h - 5, 8, 8);
								BasicStroke dottedPen = new BasicStroke(1.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0F, new float[]
									{ 2.0F, 2.0F }, 1.0F);
								onCanvas.setStroke(dottedPen);
								onCanvas.setColor(c);
								onCanvas.drawRect(x + halfWidth + 7, y + 3, halfWidth, h - 5);
								onCanvas.drawLine(x + halfWidth + 7, y + 3, x + halfWidth + 7 + halfWidth, y + h - 2);
								onCanvas.drawLine(x + halfWidth + 7, y + h - 2, x + halfWidth + 7 + halfWidth, y + 3);
								onCanvas.setStroke(temporary ? DefaultGOSettings.insideTmpPen : DefaultGOSettings.insidePen);
							}
					}
			}
			
		public void draw(Graphics2D onCanvas)
			{
				if (onCanvas.hitClip(x, y, width, height))
					{
						onCanvas.setColor(selected ? active ? DefaultGOSettings.activeSelectionColor : DefaultGOSettings.selectionColor : active ? activeColor : color);
						onCanvas.setStroke(temporary ? DefaultGOSettings.contourTmpPen : active?DefaultGOSettings.activeContourPen:DefaultGOSettings.contourPen);
						onCanvas.drawRect(x, y, width, height);
						if (!selected)
							onCanvas.setColor(color);
						switch (details)
							{
								case NO:
									break;
								case LOW:
									drawChemicalID(onCanvas, x, y, width, height);
									break;
								case MEDIUM:
									drawCAS_Name(onCanvas, x, y, width, height);
									break;
								case HIGH:
									drawChemical(onCanvas, x, y, width, height);
									break;
								case ALL:
									drawChemical(onCanvas, x, y, width, height);
									break;
							}
					}
			}
			
		public StandardGOSize getStandardSize()
			{
				return defaultBiologicalPerturbationSPEGOUnscalledSize;
			}
			
		public static void setStandardSize(StandardGOSize newGOSize)
			{
				defaultBiologicalPerturbationSPEGOUnscalledSize = newGOSize;
			}
			
		private Color																color																																											= DefaultGOSettings.chemicalColor;
		private Color																activeColor																																					= DefaultGOSettings.activeChemicalColor;
		
		static public StandardGOSize	defaultBiologicalPerturbationSPEGOUnscalledSize	= new StandardGOSize(DefaultGOSettings.hVisWeigthChemical, DefaultGOSettings.vVisWeigthChemical);
		
	}

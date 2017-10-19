package org.qsari.effectopedia.go.pathway_elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import org.qsari.effectopedia.core.objects.Initiator_StructuralAlerts;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.GOUtils;
import org.qsari.effectopedia.go.Standard8IOPorts;
import org.qsari.effectopedia.go.Standard8IOPorts.Distribution;
import org.qsari.effectopedia.go.StandardGOSize;

public class StructuralAlertsSPEGO extends SubstancePEGO
	{
		
		public StructuralAlertsSPEGO(PathwayElement o)
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
								Initiator_StructuralAlerts sa = (Initiator_StructuralAlerts) o;
								GOUtils.drawCaption(sa.getTitle(), c, onCanvas, x + 2, y + 1, width - 4, DefaultGOSettings.rowHeight);
								y += DefaultGOSettings.rowHeight;
								height -= DefaultGOSettings.rowHeight;
								onCanvas.drawLine(x + 3, y, x + width - 3, y);
								int oneThirdWidth = (width - 5) / 3;
								int h = (height > oneThirdWidth) ? oneThirdWidth : height;
								for (int i = 0; i <= 2 * oneThirdWidth; i += oneThirdWidth)
									{
										// 2D image
										BasicStroke dottedPen = new BasicStroke(1.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0F, new float[]
											{ 2.0F, 2.0F }, 1.0F);
										onCanvas.setStroke(dottedPen);
										onCanvas.setColor(c);
										onCanvas.drawRect(x + 3 + i, y + 3, oneThirdWidth, h - 5);
										onCanvas.drawLine(x + 3 + i, y + 3, x + 3 + i + oneThirdWidth, y + h - 2);
										onCanvas.drawLine(x + 3 + i, y + h - 2, x + 3 + i + oneThirdWidth, y + 3);
										onCanvas.setStroke(temporary ? DefaultGOSettings.insideTmpPen : DefaultGOSettings.insidePen);
									}
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
				return defaultStructuralAlertsSPEGOUnscalledSize;
			}
			
		public static void setStandardSize(StandardGOSize newGOSize)
			{
				defaultStructuralAlertsSPEGOUnscalledSize = newGOSize;
			}
			
		private Color																color																																					= DefaultGOSettings.chemicalColor;
		private Color																activeColor																															= DefaultGOSettings.activeChemicalColor;
		
		static public StandardGOSize	defaultStructuralAlertsSPEGOUnscalledSize	= new StandardGOSize(DefaultGOSettings.hVisWeigthChemical, DefaultGOSettings.vVisWeigthChemical);
		
	}

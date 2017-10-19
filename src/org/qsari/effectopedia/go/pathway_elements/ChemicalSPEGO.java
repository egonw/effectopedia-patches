package org.qsari.effectopedia.go.pathway_elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.GOUtils;
import org.qsari.effectopedia.go.Standard8IOPorts;
import org.qsari.effectopedia.go.Standard8IOPorts.Distribution;
import org.qsari.effectopedia.go.StandardGOSize;
import org.qsari.effectopedia.gui.util.StructureImage;

public class ChemicalSPEGO extends SubstancePEGO
	{
		
		public ChemicalSPEGO(PathwayElement o)
			{
				super(o);
				ports = new Standard8IOPorts(this, Distribution.RECTANGULAR);
				update();
			}
			
		public void update()
			{
				int insertIndex = 0;
				if ((displayOptions & DisplaySection.QUALITY_ASSURANCE) == DisplaySection.QUALITY_ASSURANCE)
					insertIndex++;
				if ((displayOptions & DisplaySection.ABBRIVIATED_TITLE) == DisplaySection.ABBRIVIATED_TITLE)
					insertIndex++;
				sections.clear();
				sections.addSectionsCodes(displayOptions);
				if ((displayOptions & DisplaySection.CHEMICAL_INFO) == DisplaySection.CHEMICAL_INFO)
					if ((displayOptions & DisplaySection.CHEMICAL_2D_STRUCTURE) == DisplaySection.CHEMICAL_2D_STRUCTURE)
						sections.add(insertIndex, getDisplayChem2DAndInfo());
					else
						sections.add(insertIndex, CHEM_INFO);
				else if ((displayOptions & DisplaySection.CHEMICAL_2D_STRUCTURE) == DisplaySection.CHEMICAL_2D_STRUCTURE)
					sections.add(insertIndex, getDisplayChem2D());
			}
			
		public DisplayChemical2DStructureAndInfo getDisplayChem2DAndInfo()
			{
				if (displayChem2DAndInfo == null)
					displayChem2DAndInfo = new DisplayChemical2DStructureAndInfo();
				return displayChem2DAndInfo;
			}
			
		public DisplayChemical2DStructure getDisplayChem2D()
			{
				if (displayChem2D == null)
					displayChem2D = new DisplayChemical2DStructure();
				return displayChem2D;
			}
			
		public static class DisplayChemicalInfo implements DisplaySection
			{
				public void draw(PathwayElement o, Graphics2D onCanvas, int x, int y, int width, int height, Color color)
					{
						if ((o != null) && (height >= DefaultGOSettings.rowHeight))
							{
								Initiator_ChemicalStructure chemical = (Initiator_ChemicalStructure) o;
								int halfWidth = (width - 5) / 2;
								GOUtils.drawItems(chemical.getIdentification().getPropertyNames(), color, onCanvas, x + 3, y + 2, halfWidth, height);
								onCanvas.drawLine(x + halfWidth, y + 3, x + halfWidth, y + height - 3);
								GOUtils.drawItems(chemical.getIdentification().getPropertyValues(), color, onCanvas, x + 6 + halfWidth, y + 2, halfWidth, height);
							}
					}
					
				public void exportToSVG(PathwayElement o, StringBuilder pathwayElementsGroup, int x, int y, int width, int height, Color color)
					{
					}
					
				public int getMinimumHeight(PathwayElement o, int forWidth, Graphics2D onCanvas)
					{
						return 2 + ((forWidth - 5) / 3);
					}
					
				public boolean isFixedHeight()
					{
						return true;
					}
			}
			
		public class DisplayChemical2DStructureAndInfo implements DisplaySection
			{
				public void draw(PathwayElement o, Graphics2D onCanvas, int x, int y, int width, int height, Color color)
					{
						if ((o != null) && (height >= DefaultGOSettings.rowHeight))
							{
								Initiator_ChemicalStructure chemical = (Initiator_ChemicalStructure) o;
								int oneThirdWidth = (width - 5) / 3;
								int h = (height > oneThirdWidth) ? oneThirdWidth : height;
								// 2D image
								if (chemical.isUpdated())
									{
										image = null;
										chemical.setUpdated(false);
									}
								draw2DStructure(onCanvas, chemical.getStructure2DImage().getDisplayValue(), new Rectangle(x + 3, y + 3, oneThirdWidth, h - 5));
								onCanvas.setStroke(temporary ? DefaultGOSettings.insideTmpPen : DefaultGOSettings.insidePen);
								int infoH = chemical.getIdentification().getCount() * DefaultGOSettings.textRowHeight;
								if (infoH > height)
									infoH = height;
								GOUtils.drawItems(chemical.getIdentification().getPropertyNames(), color, onCanvas, x + 5 + oneThirdWidth, y + 2, oneThirdWidth, height);
								onCanvas.drawLine(x + 2 * oneThirdWidth, y + 3, x + 2 * oneThirdWidth, y + infoH);
								GOUtils.drawItems(chemical.getIdentification().getPropertyValues(), color, onCanvas, x + 3 + 2 * oneThirdWidth, y + 2, oneThirdWidth, height);
							}
					}
					
				public void exportToSVG(PathwayElement o, StringBuilder pathwayElementsGroup, int x, int y, int width, int height, Color color)
					{
					}
					
				public int getMinimumHeight(PathwayElement o, int forWidth, Graphics2D onCanvas)
					{
						return 2 + ((width - 5) / 3);
					}
					
				public boolean isFixedHeight()
					{
						return true;
					}
			}
			
		public class DisplayChemical2DStructure implements DisplaySection
			{
				public void draw(PathwayElement o, Graphics2D onCanvas, int x, int y, int width, int height, Color color)
					{
						if ((o != null) && (height >= DefaultGOSettings.rowHeight))
							{
								Initiator_ChemicalStructure chemical = (Initiator_ChemicalStructure) o;
								if (chemical.isUpdated())
									{
										image = null;
										chemical.setUpdated(false);
									}
								draw2DStructure(onCanvas, chemical.getStructure2DImage().getDisplayValue(), new Rectangle(x + 3, y + 3, width - 6, height - 3));
								onCanvas.setStroke(DefaultGOSettings.insidePen);
							}
					}
					
				public void exportToSVG(PathwayElement o, StringBuilder pathwayElementsGroup, int x, int y, int width, int height, Color color)
					{
					}
					
				public int getMinimumHeight(PathwayElement o, int forWidth, Graphics2D onCanvas)
					{
						return 2 + ((width - 5) / 3);
					}
					
				public boolean isFixedHeight()
					{
						return true;
					}
			}
			
		public static class DisplayChemicalProperties implements DisplaySection
			{
				public void draw(PathwayElement o, Graphics2D onCanvas, int x, int y, int width, int height, Color color)
					{
						if ((o != null) && (height >= DefaultGOSettings.rowHeight))
							{
								Initiator_ChemicalStructure chemical = (Initiator_ChemicalStructure) o;
								if (height > DefaultGOSettings.rowHeight)
									{
										int oneThirdWidth = (width - 5) / 3;
										GOUtils.drawItems(chemical.getProperties().getPropertyNames(), color, onCanvas, x + 5, y + 2, oneThirdWidth - 2, height);
										onCanvas.drawLine(x + 2 * oneThirdWidth, y + 3, x + 2 * oneThirdWidth, y + height - 5);
										onCanvas.drawLine(x + oneThirdWidth, y + 3, x + oneThirdWidth, y + height - 5);
										GOUtils.drawItems(chemical.getProperties().getPropertyValues(), color, onCanvas, x + 3 + oneThirdWidth, y + 2, oneThirdWidth, height);
										GOUtils.drawItems(chemical.getProperties().getPropertyUnits(), color, onCanvas, x + 3 + 2 * oneThirdWidth, y + 2, oneThirdWidth, height);
									}
							}
					}
					
				public void exportToSVG(PathwayElement o, StringBuilder pathwayElementsGroup, int x, int y, int width, int height, Color color)
					{
					}
					
				public int getMinimumHeight(PathwayElement o, int forWidth, Graphics2D onCanvas)
					{
						return DefaultGOSettings.textRowHeight + 2;
					}
					
				public boolean isFixedHeight()
					{
						return false;
					}
			}
			
		public void draw2DStructure(Graphics2D onCanvas, String url, Rectangle r)
			{
				BasicStroke dottedPen = new BasicStroke(1.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0F, new float[]
					{ 2.0F, 2.0F }, 1.0F);
				onCanvas.setStroke(dottedPen);
				if (image == null)
					image = new StructureImage(url);
				image.paint(onCanvas, r);
				onCanvas.drawRect(r.x, r.y, r.width, r.height);
			}
			
		public void draw(Graphics2D onCanvas)
			{
				if (onCanvas.hitClip(x, y, width, height))
					{
						Color displayWithColor = selected ? active ? DefaultGOSettings.activeSelectionColor : DefaultGOSettings.selectionColor : active ? activeColor : color;
						onCanvas.setColor(displayWithColor);
						onCanvas.setStroke(temporary ? DefaultGOSettings.contourTmpPen : active?DefaultGOSettings.activeContourPen:DefaultGOSettings.contourPen);
						onCanvas.drawRect(x, y, width, height);
						onCanvas.setStroke(temporary ? DefaultGOSettings.insideTmpPen : DefaultGOSettings.insidePen);
						onCanvas.setColor(Color.WHITE);
						onCanvas.fillRect(x + 3, y + 3, width - 5, height - 5);
						if (!selected)
							onCanvas.setColor(color);
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
						
						pathwayElementsGroup.append("<rect");
						exportDimensions(pathwayElementsGroup);
						exportPresentationAttributes(pathwayElementsGroup);
						pathwayElementsGroup.append("/>\n");
						sections.exportToSVG(o, pathwayElementsGroup, x, y, width, height, color);
						
						pathwayElementsGroup.append("</g>\n");
					}
			}
			
		@Override
		public Color getColor()
			{
				return selected ? active ? DefaultGOSettings.activeSelectionColor : DefaultGOSettings.selectionColor : active ? activeColor : color;
			}
			
		public StandardGOSize getStandardSize()
			{
				return defaultChemicalSPEGOUnscalledSize;
			}
			
		public static void setStandardSize(StandardGOSize newGOSize)
			{
				defaultChemicalSPEGOUnscalledSize = newGOSize;
			}
			
		private static final DisplayChemicalInfo		CHEM_INFO																									= new DisplayChemicalInfo();
		private DisplayChemical2DStructureAndInfo	displayChem2DAndInfo;
		private DisplayChemical2DStructure								displayChem2D;
		public static int																									displayOptions																				= DisplaySection.CHEMICAL_DEFAULTS;
		private StructureImage																				image																													= null;
		static public StandardGOSize														defaultChemicalSPEGOUnscalledSize	= new StandardGOSize(DefaultGOSettings.hVisWeigthChemical, DefaultGOSettings.vVisWeigthChemical);
		private Color																													color																													= DefaultGOSettings.chemicalColor;
		private Color																													activeColor																							= DefaultGOSettings.activeChemicalColor;
		
	}

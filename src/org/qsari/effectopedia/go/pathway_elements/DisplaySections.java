package org.qsari.effectopedia.go.pathway_elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;

import org.qsari.effectopedia.core.containers.References.Referable;
import org.qsari.effectopedia.core.object.elemets.QualityAssurance;
import org.qsari.effectopedia.core.objects.DescriptionSection;
import org.qsari.effectopedia.core.objects.DocumentedKnowledge;
import org.qsari.effectopedia.core.objects.DocumentedKnowledge_Located;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.objects.Reference;
import org.qsari.effectopedia.data.objects.DataValues;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.GOUtils;
import org.qsari.effectopedia.go.SVGUtils;
import org.qsari.effectopedia.gui.core.GUIFactory;
import org.qsari.effectopedia.search.SearchIndices;

public class DisplaySections extends ArrayList<DisplaySection>
	{
		
		public static class DisplayAbbriviatedTitle implements DisplaySection
			{
				public void draw(PathwayElement o, Graphics2D onCanvas, int x, int y, int width, int height, Color color)
					{
						if ((height >= DefaultGOSettings.rowHeight)&&(width>DefaultGOSettings.minTextWidth))
							GOUtils.drawMultilineCaption(o.getTitle(), color, onCanvas, x + 2, y + 1, width, height - 2);
						else if (height > DefaultGOSettings.textRowHeight - 4)
							GOUtils.drawID(String.valueOf(o.getExternalID()), color, onCanvas, x - 1, y - 1, width + 3, height + 3);
					}
				
				public void exportToSVG(PathwayElement o, StringBuilder pathwayElementsGroup, int x, int y, int width, int height, Color color)
					{
						if ((o != null) && (height >= DefaultGOSettings.rowHeight))
							SVGUtils.addCaption(o.getTitle(), pathwayElementsGroup, x + 2, y + 1, width, DefaultGOSettings.rowHeight, color);
					}
				
				public int getMinimumHeight(PathwayElement o, int forWidth, Graphics2D onCanvas)
					{
						return DefaultGOSettings.rowHeight;
					}
				
				public int getMinimumHeight(PathwayElement o, int forWidth)
					{
						return DefaultGOSettings.rowHeight;
					}
				
				public boolean isFixedHeight()
					{
						return false;
					}
			}
		
		public static class DisplayFullTitle implements DisplaySection
			{
				public void draw(PathwayElement o, Graphics2D onCanvas, int x, int y, int width, int height, Color color)
					{
						if ((o != null) && (height >= DefaultGOSettings.rowHeight))
							GOUtils.drawMultilineCaption(((DocumentedKnowledge) o).getTitle(), color, onCanvas, x + 2, y + 1, width, height - 2);
					}
				
				public void exportToSVG(PathwayElement o, StringBuilder pathwayElementsGroup, int x, int y, int width, int height, Color color)
					{
						if ((o != null) && (height >= DefaultGOSettings.rowHeight))
							SVGUtils.addMultilineCaption(o, pathwayElementsGroup, x + 2, y + 1, width - 4, height - 2, color);
					}
				
				public int getMinimumHeight(PathwayElement o, int forWidth, Graphics2D onCanvas)
					{
						return DefaultGOSettings.rowHeight * GOUtils.getLinesCount(((DocumentedKnowledge) o).getTitle(), onCanvas, forWidth, false);
					}
				
				public boolean isFixedHeight()
					{
						return false;
					}
			}
		
		public static class DisplayAbbriviatedTitleAndIDs implements DisplaySection
			{
				public void draw(PathwayElement o, Graphics2D onCanvas, int x, int y, int width, int height, Color color)
					{
						if (o != null)
							{
								int titleWidth = width * 2 / 3;
								int idWidth = width - titleWidth;
								if ((height >= DefaultGOSettings.rowHeight)&&(width>DefaultGOSettings.minTextWidth))
									{
										GOUtils.drawCaption(o.getTitle(), color, onCanvas, x + 2, y + 1, titleWidth, DefaultGOSettings.rowHeight);
										onCanvas.setStroke(DefaultGOSettings.insidePen);
										onCanvas.fillRoundRect(x + titleWidth + 3, y + 3, width - titleWidth - 5, DefaultGOSettings.rowHeight - 5, 6, 6);
										GOUtils.drawLine(String.valueOf(o.getExternalID()), Color.white, onCanvas, x + titleWidth + 2, y + 1, idWidth, DefaultGOSettings.rowHeight);// ID
									}
								else if (height > DefaultGOSettings.textRowHeight - 4)
									GOUtils.drawID(String.valueOf(o.getExternalID()), color, onCanvas, x - 1, y - 1, width + 3, height + 3);
							}
					}
				
				public void exportToSVG(PathwayElement o, StringBuilder pathwayElementsGroup, int x, int y, int width, int height, Color color)
					{
						if (o != null)
							{
								int titleWidth = width * 2 / 3;
								if (height >= DefaultGOSettings.rowHeight)
									{
										SVGUtils.addCaption(o.getTitle(), pathwayElementsGroup, x + 2, y + 1, titleWidth, DefaultGOSettings.rowHeight, color);
										SVGUtils.addFillRoundRect(pathwayElementsGroup, x + titleWidth + 3, y + 3, width - titleWidth - 5, DefaultGOSettings.rowHeight - 5, 6, 6, color, null);
										SVGUtils.addTextOpeningTag(pathwayElementsGroup, x + titleWidth + 6, y + 12, Color.white);
										pathwayElementsGroup.append(String.valueOf(o.getExternalID()));
										pathwayElementsGroup.append("</text>\n");
									}
							}
					}
				
				public int getMinimumHeight(PathwayElement o, int forWidth, Graphics2D onCanvas)
					{
						return DefaultGOSettings.rowHeight;
					}
				
				public boolean isFixedHeight()
					{
						return false;
					}
			}
		
		public static class DisplayFullTitleAndID implements DisplaySection
			{
				public void draw(PathwayElement o, Graphics2D onCanvas, int x, int y, int width, int height, Color color)
					{
						if ((o != null) && (height >= DefaultGOSettings.rowHeight) && (width >= DefaultGOSettings.minTextWidth))
							if (titleOnly)
								GOUtils.drawMultilineCaption(((DocumentedKnowledge) o).getTitle(), color, onCanvas, x + 2, y + 1, width, height - 2);
							else
								GOUtils.drawMultilineCaptionAndID(((DocumentedKnowledge) o).getTitle(), String.valueOf(o.getExternalID()), color, onCanvas, x + 2, y + 2, width - 4, height - 4);
						else if (height > DefaultGOSettings.textRowHeight - 4)
							GOUtils.drawID(String.valueOf(o.getExternalID()), color, onCanvas, x - 1, y - 1, width + 3, height + 3);
					}
				
				public void exportToSVG(PathwayElement o, StringBuilder pathwayElementsGroup, int x, int y, int width, int height, Color color)
					{
						if ((o != null) && (height >= DefaultGOSettings.rowHeight))
							if (titleOnly)
								SVGUtils.addMultilineCaption(o, pathwayElementsGroup, x + 2, y + 1, width - 4, height, color);
							else
								SVGUtils.addMultilineCaptionAndID(o, pathwayElementsGroup, x + 2, y + 2, width - 4, height, color);
					}
				
				public int getMinimumHeight(PathwayElement o, int forWidth, Graphics2D onCanvas)
					{
						int lc = GOUtils.getLinesCount(((DocumentedKnowledge) o).getTitle(), onCanvas, forWidth, true);
						return DefaultGOSettings.rowHeight * ((lc > 0) ? lc : 1);
					}
				
				public boolean isFixedHeight()
					{
						return false;
					}
			}
		
		public static class DisplayGroupsAndKeywords implements DisplaySection
			{
				public void draw(PathwayElement o, Graphics2D onCanvas, int x, int y, int width, int height, Color color)
					{
						DataValues properties = o.getSearchablePoperties();
						properties.removeBySearhIndexName(SearchIndices.TITLE_INDEX);
						if ((properties != null) && (properties.getAssignedValuesCount() > 0))
							GOUtils.drawProperties(properties, color, onCanvas, x, y, width, height);
					}
				
				public void exportToSVG(PathwayElement o, StringBuilder pathwayElementsGroup, int x, int y, int width, int height, Color color)
					{
					}
				
				public int getMinimumHeight(PathwayElement o, int forWidth, Graphics2D onCanvas)
					{
						DataValues properties = o.getSearchablePoperties();
						properties.removeBySearhIndexName(SearchIndices.TITLE_INDEX);
						return (DefaultGOSettings.textRowHeight + 2) * properties.getAssignedValuesCount();
					}
				
				public boolean isFixedHeight()
					{
						return true;
					}
			}
		
		public static class DisplayQualityAssurance implements DisplaySection
			{
				public void draw(PathwayElement o, Graphics2D onCanvas, int x, int y, int width, int height, Color color)
					{
						if ((o != null) && (height >= DefaultGOSettings.textRowHeight))
							GOUtils.drawQualityAssurance(o.getQA(), color, onCanvas, x + 2, y + 1, width, height - 2);
					}
				
				public void exportToSVG(PathwayElement o, StringBuilder pathwayElementsGroup, int x, int y, int width, int height, Color color)
					{
					}
				
				public int getMinimumHeight(PathwayElement o, int forWidth, Graphics2D onCanvas)
					{
						QualityAssurance qa = o.getQA();
						return DefaultGOSettings.textRowHeight * (qa.getReviewers().hasReviewers(false) ? 2 : 1) + 2;
					}
				
				public boolean isFixedHeight()
					{
						return true;
					}
			}
		
		public static class DisplayDescriptionSection implements DisplaySection
			{
				public void draw(PathwayElement o, Graphics2D onCanvas, int x, int y, int width, int height, Color color)
					{
						DocumentedKnowledge dk = ((DocumentedKnowledge) o);
						if (dk.getDescriptionIDs().size() > 0)
							GOUtils.drawDescriptionSection((DescriptionSection) (dk.getDescriptionIDs().getCachedObject(0)), color, onCanvas, x, y, width, height);
					}
				
				public void exportToSVG(PathwayElement o, StringBuilder pathwayElementsGroup, int x, int y, int width, int height, Color color)
					{
					}
				
				public int getMinimumHeight(PathwayElement o, int forWidth, Graphics2D onCanvas)
					{
						if (((DocumentedKnowledge) o).getDescriptionIDs().size() > 0)
							return DefaultGOSettings.rowHeight;
						else
							return 0;
					}
				
				public boolean isFixedHeight()
					{
						return false;
					}
			}
		
		public static class DisplayContext implements DisplaySection
			{
				public void draw(PathwayElement o, Graphics2D onCanvas, int x, int y, int width, int height, Color color)
					{
						DocumentedKnowledge_Located dkl = (DocumentedKnowledge_Located) o;
						if (dkl.getCoordinates().count() > 0)
							GOUtils.drawContext(dkl.getCoordinates(), color, onCanvas, x, y, width, height);
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
		
		public static class DisplayPathwayAssociations implements DisplaySection
			{
				public void draw(PathwayElement o, Graphics2D onCanvas, int x, int y, int width, int height, Color color)
					{
						if (o.getPathwayIDs().size() > 0)
							GOUtils.drawPathways((Pathway[]) o.getPathwayIDs().getCachedObjects(), color, onCanvas, x, y, width, height);
					}
				
				public void exportToSVG(PathwayElement o, StringBuilder pathwayElementsGroup, int x, int y, int width, int height, Color color)
					{
					}
				
				public int getMinimumHeight(PathwayElement o, int forWidth, Graphics2D onCanvas)
					{
						if (o.getPathwayIDs().size() > 0)
							return DefaultGOSettings.textRowHeight + 2;
						else
							return 0;
					}
				
				public boolean isFixedHeight()
					{
						return false;
					}
			}
		
		public static class DisplayReferences implements DisplaySection
			{
				public void draw(PathwayElement o, Graphics2D onCanvas, int x, int y, int width, int height, Color color)
					{
						DocumentedKnowledge dk = ((DocumentedKnowledge) o);
						if (dk.getReferenceIDs().size() > 0)
							GOUtils.drawReferences((Reference[]) dk.getReferenceIDs().getCachedObjects(), color, onCanvas, x, y, width, height);
					}
				
				public void exportToSVG(PathwayElement o, StringBuilder pathwayElementsGroup, int x, int y, int width, int height, Color color)
					{
					}
				
				public int getMinimumHeight(PathwayElement o, int forWidth, Graphics2D onCanvas)
					{
						if (((Referable) o).getReferenceIDs().size() > 0)
							return DefaultGOSettings.textRowHeight + 2;
						else
							return 0;
					}
				
				public boolean isFixedHeight()
					{
						return false;
					}
			}
		
		public void draw(PathwayElement o, Graphics2D onCanvas, int x, int y, int width, int height, Color color)
			{
				int count = size();
				if (count == 0)
					return;
				int h = 0;
				int displayCnt = 0;
				int visibleCnt = 0;
				for (int i = 0; i < count; i++)
					{
						int sectionHeight = get(i).getMinimumHeight(o, width, onCanvas);
						if (sectionHeight > 0)
							{
								h += sectionHeight + 2;
								visibleCnt++;
							}
						if (h <= height)
							displayCnt++;
						else
							break;
					}
				int firstHeight = get(0).getMinimumHeight(o, width, onCanvas);
				get(0).draw(o, onCanvas, x, y, width, ((height < firstHeight) ? height : firstHeight), color);
				if (displayCnt > 1)
					{
						int sectionHeight;
						if (visibleCnt > 1)
							sectionHeight = (height - firstHeight - 2 * visibleCnt) / (visibleCnt - 1);
						else
							sectionHeight = height - firstHeight;
						h = y + firstHeight + 2;
						for (int i = 1; i < displayCnt; i++)
							{
								int requiredHeight = get(i).getMinimumHeight(o, width, onCanvas);
								if (requiredHeight == 0)
									continue;
								if ((requiredHeight < sectionHeight) && (!get(i).isFixedHeight()))
									requiredHeight = sectionHeight;
								get(i).draw(o, onCanvas, x, h, width, requiredHeight, color);
								
								onCanvas.setColor(color);
								onCanvas.drawLine(x + 3, h, x + width - 3, h);
								
								h += requiredHeight + 2;
							}
					}
			}
		
		public void exportToSVG(PathwayElement o, StringBuilder pathwayElementsGroup, int x, int y, int width, int height, Color color)
			{
				int count = size();
				if (count == 0)
					return;
				int h = 0;
				int displayCnt = 0;
				int visibleCnt = 0;
				for (int i = 0; i < count; i++)
					{
						int sectionHeight = get(i).getMinimumHeight(o, width, (Graphics2D) GUIFactory.GUI.getFrame().getGraphics());
						if (sectionHeight > 0)
							{
								h += sectionHeight + 2;
								visibleCnt++;
							}
						if (h <= height)
							displayCnt++;
						else
							break;
					}
				int firstHeight = get(0).getMinimumHeight(o, width, (Graphics2D) GUIFactory.GUI.getFrame().getGraphics());
				get(0).exportToSVG(o, pathwayElementsGroup, x, y, width, ((height < firstHeight) ? height : firstHeight), color);
				if (displayCnt > 1)
					{
						int sectionHeight;
						if (visibleCnt > 1)
							sectionHeight = (height - firstHeight - 2 * visibleCnt) / (visibleCnt - 1);
						else
							sectionHeight = height - firstHeight;
						h = y + firstHeight + 2;
						for (int i = 1; i < displayCnt; i++)
							{
								int requiredHeight = get(i).getMinimumHeight(o, width, (Graphics2D) GUIFactory.GUI.getFrame().getGraphics());
								if (requiredHeight == 0)
									continue;
								if ((requiredHeight < sectionHeight) && (!get(i).isFixedHeight()))
									requiredHeight = sectionHeight;
								get(i).exportToSVG(o, pathwayElementsGroup, x, h, width, requiredHeight, color);
								
								SVGUtils.addLine(pathwayElementsGroup, x + 3, h, x + width, h, color, 1);
								
								h += requiredHeight + 2;
							}
					}
			}
		
		public void add(int index)
			{
				add(INSTANCES.get(index));
			}
		
		public void addSectionsCodes(int sectionCodes)
			{
				boolean externalID = ((sectionCodes & DisplaySection.EXTERNAL_ID) == DisplaySection.EXTERNAL_ID);
				if ((sectionCodes & DisplaySection.ABBRIVIATED_TITLE) == DisplaySection.ABBRIVIATED_TITLE)
					add(INSTANCES.get(externalID ? DisplaySection.ABBRIVIATED_TITLE_AND_ID : DisplaySection.ABBRIVIATED_TITLE));
				if ((sectionCodes & DisplaySection.FULL_TITLE) == DisplaySection.FULL_TITLE)
					add(INSTANCES.get(externalID ? DisplaySection.FULL_TITLE_ID : DisplaySection.FULL_TITLE));
				int i = 0x0004;
				while (i <= 0x4000)
					{
						i = (i << 1);
						if ((sectionCodes & i) == i)
							{
								DisplaySection ds = INSTANCES.get(i);
								if (ds != null)
									add(ds);
							}
					}
			}
		
		private static final HashMap<Integer, DisplaySection>	INSTANCES								= new HashMap<Integer, DisplaySection>();
		static
			{
				INSTANCES.put(DisplaySection.ABBRIVIATED_TITLE, new DisplayAbbriviatedTitle());
				INSTANCES.put(DisplaySection.ABBRIVIATED_TITLE_AND_ID, new DisplayAbbriviatedTitleAndIDs());
				INSTANCES.put(DisplaySection.FULL_TITLE, new DisplayFullTitle());
				INSTANCES.put(DisplaySection.FULL_TITLE_ID, new DisplayFullTitleAndID());
				INSTANCES.put(DisplaySection.GROUPS_AND_KEYWORDS, new DisplayGroupsAndKeywords());
				INSTANCES.put(DisplaySection.QUALITY_ASSURANCE, new DisplayQualityAssurance());
				INSTANCES.put(DisplaySection.DESCRIPTION_SECTION, new DisplayDescriptionSection());
				INSTANCES.put(DisplaySection.CONTEXT, new DisplayContext());
				INSTANCES.put(DisplaySection.PATHWAY_ASSOCIATIONS, new DisplayPathwayAssociations());
				INSTANCES.put(DisplaySection.REFERENCES, new DisplayReferences());
				INSTANCES.put(DisplaySection.CHEMICAL_PROPERTIES, new ChemicalSPEGO.DisplayChemicalProperties());
			}
		
		public static boolean																																	titleOnly								= false;
		private static final long																													serialVersionUID	= 1L;
	}

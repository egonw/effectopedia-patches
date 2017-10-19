package org.qsari.effectopedia.go.pathway_elements;

import java.awt.Color;
import java.awt.Graphics2D;

import org.qsari.effectopedia.core.objects.PathwayElement;

public interface DisplaySection
	{
		public void draw(PathwayElement	o,Graphics2D onCanvas, int x, int y, int width, int height, Color color);
		public void exportToSVG(PathwayElement o, StringBuilder pathwayElementsGroup, int x, int y, int width, int height, Color color);
		public int getMinimumHeight(PathwayElement o,int forWidth,Graphics2D onCanvas);
		
  public boolean isFixedHeight();
  
		public final static int DISABLED = 0x0000;
		public final static int EXTERNAL_ID = 0x0001;
		public final static int ABBRIVIATED_TITLE = 0x0002;
		public final static int ABBRIVIATED_TITLE_AND_ID = ABBRIVIATED_TITLE+EXTERNAL_ID;
		public final static int FULL_TITLE = 0x0004;
		public final static int FULL_TITLE_ID = FULL_TITLE+EXTERNAL_ID;
		public final static int QUALITY_ASSURANCE = 0x0008;
		public final static int GROUPS_AND_KEYWORDS = 0x0010;
		public final static int DESCRIPTION_SECTION = 0x0020;
		public final static int CONTEXT = 0x0040;
		public final static int QUANTITATIVE_RELATIONSHIP = 0x0080;
		public final static int CHEMICAL_2D_STRUCTURE = 0x0100; 
		public final static int CHEMICAL_INFO = 0x0200;
		public final static int CHEMICAL_PROPERTIES = 0x0400;
		public final static int CHEMICAL_2D_STRUCTURE_AND_INFO = CHEMICAL_2D_STRUCTURE | CHEMICAL_INFO; 
		public final static int PATHWAY_ASSOCIATIONS = 0x0800; 
		public final static int REFERENCES = 0x1000; 
		public final static int LINK_TYPE = 0x2000;
		
		public final static int EFFECT_DEFAULTS = FULL_TITLE_ID | DESCRIPTION_SECTION | CONTEXT | REFERENCES;
		public final static int TEST_DEFAULTS = FULL_TITLE_ID | DESCRIPTION_SECTION | CONTEXT | REFERENCES;
		public final static int LINK_DEFAULTS = LINK_TYPE;
		public final static int CHEMICAL_DEFAULTS = ABBRIVIATED_TITLE | CHEMICAL_2D_STRUCTURE | CHEMICAL_INFO | CHEMICAL_PROPERTIES;
	}

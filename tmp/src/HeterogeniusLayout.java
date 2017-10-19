package org.qsari.effectopedia.go.Layout;

import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.containers.GraphicObjectsContainer;
import org.qsari.effectopedia.go.pathway_elements.ChemicalSPEGO;
import org.qsari.effectopedia.go.pathway_elements.ContextPEGO;
import org.qsari.effectopedia.go.pathway_elements.EffectCPEGO;
import org.qsari.effectopedia.go.pathway_elements.LinkPEGO;
import org.qsari.effectopedia.go.pathway_elements.SubstancePEGO;
import org.qsari.effectopedia.go.pathway_elements.TestCPEGO;

/**
 * @version 1.0 @(#)BasicLayout.java 1.0
 * @author Hristo Aladjov
 * 
 */

public class HeterogeniusLayout extends BasicLayout
	{
		
		public HeterogeniusLayout(GraphicObjectsContainer segments, GraphicObjectsContainer arcs)
			{
				super(segments,arcs);
				objectSizes = new IndexedGOSizes(false);
				objectSizes.put(SubstancePEGO.class, new IndexedGOSize(DefaultGOSettings.hVisWeigthChemical, DefaultGOSettings.vVisWeigthChemical));
				objectSizes.put(ChemicalSPEGO.class, new IndexedGOSize(DefaultGOSettings.hVisWeigthChemical, DefaultGOSettings.vVisWeigthChemical));
				IndexedGOSize_Fixed linkSize = new IndexedGOSize_Fixed(DefaultGOSettings.hVisWeigthLink, DefaultGOSettings.vVisWeigthLink);
				linkSize.width = DefaultGOSettings.linkIconRadius;
				linkSize.height = DefaultGOSettings.linkIconRadius;
				objectSizes.put(LinkPEGO.class,linkSize);
				objectSizes.put(EffectCPEGO.class, new IndexedGOSize(DefaultGOSettings.hVisWeigthEffect, DefaultGOSettings.vVisWeigthEffect));
				objectSizes.put(ContextPEGO.class, new IndexedGOSize(DefaultGOSettings.hVisWeigthEffect, DefaultGOSettings.vVisWeigthEffect));
				objectSizes.put(TestCPEGO.class, new IndexedGOSize(DefaultGOSettings.hVisWeigthTest, DefaultGOSettings.vVisWeigthTest));
				objectSizes.scale(scale);
			}
		
		public int getDefaultIntialSegmentOffset(SegmentGO segment)
			{
				return 20 + (segment.isAllowed(LinkPEGO.class)?objectSizes.estimateVGap(LinkPEGO.class)+1-objectSizes.estimateHeight(LinkPEGO.class)/2:0);
			}


	}

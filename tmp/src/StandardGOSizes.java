package org.qsari.effectopedia.go.builder;

import java.util.HashMap;
import java.util.Iterator;

import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.StandardGOSize;
import org.qsari.effectopedia.go.Layout.Scale;
import org.qsari.effectopedia.go.pathway_elements.ChemicalSPEGO;
import org.qsari.effectopedia.go.pathway_elements.ContextPEGO;
import org.qsari.effectopedia.go.pathway_elements.EffectCPEGO;
import org.qsari.effectopedia.go.pathway_elements.EffectEGOC;
import org.qsari.effectopedia.go.pathway_elements.LinkEGOC;
import org.qsari.effectopedia.go.pathway_elements.LinkPEGO;
import org.qsari.effectopedia.go.pathway_elements.SubstanceEGOC;
import org.qsari.effectopedia.go.pathway_elements.SubstancePEGO;
import org.qsari.effectopedia.go.pathway_elements.TestCPEGO;

public class StandardGOSizes
	{
		
		public StandardGOSizes(boolean useDefault)
			{
				objectSizes = new HashMap<Class<? extends GraphicObject>, StandardGOSize>();
				if (useDefault)
					{
						objectSizes.put(SubstancePEGO.class, new StandardGOSize(DefaultGOSettings.hVisWeigthChemical, DefaultGOSettings.vVisWeigthChemical));
						objectSizes.put(ChemicalSPEGO.class, new StandardGOSize(DefaultGOSettings.hVisWeigthChemical, DefaultGOSettings.vVisWeigthChemical));
						objectSizes.put(LinkPEGO.class, new StandardGOSize(DefaultGOSettings.hVisWeigthLink, DefaultGOSettings.vVisWeigthLink));
						objectSizes.put(ContextPEGO.class, new StandardGOSize(DefaultGOSettings.hVisWeigthEffect, DefaultGOSettings.vVisWeigthEffect));
						objectSizes.put(EffectCPEGO.class, new StandardGOSize(DefaultGOSettings.hVisWeigthEffect, DefaultGOSettings.vVisWeigthEffect));
						objectSizes.put(TestCPEGO.class, new StandardGOSize(DefaultGOSettings.hVisWeigthTest, DefaultGOSettings.vVisWeigthTest));
						objectSizes.put(SubstanceEGOC.class, new StandardGOSize(DefaultGOSettings.hVisWeigthSubstanceContainer, DefaultGOSettings.vVisWeigthSubstanceContainer));
						objectSizes.put(EffectEGOC.class, new StandardGOSize(DefaultGOSettings.hVisWeigthEffectContainer, DefaultGOSettings.vVisWeigthEffectContainer));
						objectSizes.put(LinkEGOC.class, new StandardGOSize(DefaultGOSettings.hVisWeigthLinkContainer, DefaultGOSettings.vVisWeigthLinkContainer));
					}
			}
		
		public void put(Class<? extends GraphicObject> objectClass, StandardGOSize objectSize)
			{
				objectSizes.put(objectClass, objectSize);
			}
		
		public void resizeGO(GraphicObject o)
			{
				StandardGOSize goDimensions = objectSizes.get(o.getClass());
				if (goDimensions != null)
					goDimensions.resizeGO(o);
			}
		
		public int estimateWidth(Class<? extends GraphicObject> c)
			{
				StandardGOSize goDimensions = objectSizes.get(c);
				return (goDimensions != null) ? goDimensions.estimateWidth() : 0;
			}
		
		public int estimateHeight(Class<? extends GraphicObject> c)
			{
				StandardGOSize goDimensions = objectSizes.get(c);
				return (goDimensions != null) ? goDimensions.estimateHeight() : 0;
			}
		
		public int estimateObjectWidth(Class<? extends GraphicObject> c)
			{
				StandardGOSize goDimensions = objectSizes.get(c);
				return (goDimensions != null) ? goDimensions.estimateTotalWidth() : 0;
			}
		
		public int estimateTotalHeight(Class<? extends GraphicObject> c)
			{
				StandardGOSize goDimensions = objectSizes.get(c);
				return (goDimensions != null) ? goDimensions.estimateTotalHeight() : 0;
			}
		
		public int estimateVGap(Class<? extends GraphicObject> c)
			{
				StandardGOSize goDimensions = objectSizes.get(c);
				return (goDimensions != null) ? goDimensions.estimateVGap() : 0;
			}
		
		public int estimateHGap(Class<? extends GraphicObject> c)
			{
				StandardGOSize goDimensions = objectSizes.get(c);
				return (goDimensions != null) ? goDimensions.estimateHGap() : 0;
			}
		
		public void scale(Scale scale)
			{
				for (Iterator<StandardGOSize> i = objectSizes.values().iterator(); i.hasNext();)
					{
						StandardGOSize goDimensions = i.next();
						goDimensions.scale(scale);
					}
				
			}
		
		private HashMap<Class<? extends GraphicObject>, StandardGOSize>	objectSizes;
	}

package org.qsari.effectopedia.go.pathway_elements;

import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.StandardGOSize;
import org.qsari.effectopedia.go.containers.ExtendedGOC;

public class SubstanceEGOC extends ExtendedGOC 
	{

		public SubstanceEGOC(GraphicObject parent)
			{
				super(parent);
			}

		public StandardGOSize getStandardSize()
			{
				return defaultSubstanceEGOCUnscalledSize;
			}

		public static void setStandardSize(StandardGOSize newGOSize)
			{
				defaultSubstanceEGOCUnscalledSize = newGOSize;
			}

		static public StandardGOSize defaultSubstanceEGOCUnscalledSize = new StandardGOSize(DefaultGOSettings.hVisWeigthSubstanceContainer, DefaultGOSettings.vVisWeigthSubstanceContainer,StandardGOSize.ZERO_INSET,StandardGOSize.ZERO_GAP);
	}

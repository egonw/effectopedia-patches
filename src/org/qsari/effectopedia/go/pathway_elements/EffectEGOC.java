package org.qsari.effectopedia.go.pathway_elements;

import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.StandardGOSize;
import org.qsari.effectopedia.go.containers.ExtendedGOC;

public class EffectEGOC extends ExtendedGOC
	{

		public EffectEGOC(GraphicObject parent)
			{
				super(parent);
			}

		public StandardGOSize getStandardSize()
			{
				return defaultEffectEGOCUnscalledSize;
			}

		public static void setStandardSize(StandardGOSize newGOSize)
			{
				defaultEffectEGOCUnscalledSize = newGOSize;
			}

		static public StandardGOSize defaultEffectEGOCUnscalledSize = new StandardGOSize(DefaultGOSettings.hVisWeigthEffectContainer, DefaultGOSettings.vVisWeigthEffectContainer,StandardGOSize.ZERO_INSET,StandardGOSize.ZERO_GAP);
	}

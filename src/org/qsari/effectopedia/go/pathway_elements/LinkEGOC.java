package org.qsari.effectopedia.go.pathway_elements;

import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.StandardGOSize;
import org.qsari.effectopedia.go.containers.ExtendedGOC;

public class LinkEGOC extends ExtendedGOC
	{

		public LinkEGOC(GraphicObject parent)
			{
				super(parent);
				this.setGridVisible(false);
				this.setBorderVisible(false);
			}

		public StandardGOSize getStandardSize()
			{
				return defaultLinkEGOCUnscalledSize;
			}

		public static void setStandardSize(StandardGOSize newGOSize)
			{
				defaultLinkEGOCUnscalledSize = newGOSize;
			}

		static public StandardGOSize defaultLinkEGOCUnscalledSize = new StandardGOSize(DefaultGOSettings.hVisWeigthLinkContainer, DefaultGOSettings.vVisWeigthLinkContainer,StandardGOSize.ZERO_INSET,StandardGOSize.ZERO_GAP);
	}

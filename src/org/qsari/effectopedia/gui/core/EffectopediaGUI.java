package org.qsari.effectopedia.gui.core;

import org.qsari.effectopedia.gui.AddressBarUI;
import org.qsari.effectopedia.gui.EffectopediaFrame;
import org.qsari.effectopedia.gui.PathwaySpaceUI;


public interface EffectopediaGUI
	{
		public EffectopediaFrame getFrame();

		public PathwaySpaceUI getPathwaySpaceUI();

		public AddressBarUI getAbuiAddressBar();
	}

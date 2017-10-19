package org.qsari.effectopedia.gui.swingbox;

import org.qsari.effectopedia.core.ui.DataViews;
import org.qsari.effectopedia.core.ui.IDataView;
import org.qsari.effectopedia.core.ui.IDataViews;
import org.qsari.effectopedia.core.ui.UIFactory;
import org.qsari.effectopedia.core.ui.WebViewPanel;
import org.qsari.effectopedia.gui.core.DataView;

public class GUISwingBOXFactory implements UIFactory
	{
		public final static GUISwingBOXFactory	FACTORY	= new GUISwingBOXFactory();
		
		private GUISwingBOXFactory()
			{
			}
		
		@Override
		public IDataView createDataView()
			{
				return new DataView();
			}
		
		@Override
		public IDataViews createDataViews()
			{
				return new DataViews();
			}
		
		@Override
		public WebViewPanel createWebViewPanel()
			{
				return new SwingBoxPanel();
			}
		
	}

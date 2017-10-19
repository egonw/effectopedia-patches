package org.qsari.effectopedia.gui.fx;

import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.ui.DataViews;
import org.qsari.effectopedia.core.ui.IDataView;
import org.qsari.effectopedia.core.ui.IDataViews;
import org.qsari.effectopedia.core.ui.UIFactory;
import org.qsari.effectopedia.core.ui.WebViewPanel;
import org.qsari.effectopedia.gui.PathwaySelectionDialog;
import org.qsari.effectopedia.gui.core.DataView;
import org.qsari.effectopedia.gui.core.GUIFactory;
import org.qsari.effectopedia.gui.core.SelectableListUI;

import javafx.application.Platform;

public class GUIFXFactory implements UIFactory
	{
		public final static GUIFXFactory FACTORY = new GUIFXFactory();
		
		private GUIFXFactory()
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
				if (webViewPanel == null)
					webViewPanel = new FXWebViewPanel();
				return webViewPanel;
			}
			
		@Override
		public SelectableListUI<Pathway> getPathwaySelectorUI()
			{
				return PathwaySelectionDialog.DIALOG;
			}
			
		@Override
		public void setBusyStatus(boolean isBusy)
			{
				GUIFactory.FACTORY.setBusyStatus(isBusy);
			}
			
		public void exit()
			{
				System.out.println("Exit JavaFX platrofm");
				Platform.exit();
			}
			
		private static WebViewPanel webViewPanel = null;
	}

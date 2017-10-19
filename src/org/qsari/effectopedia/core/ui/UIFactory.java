package org.qsari.effectopedia.core.ui;

import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.gui.core.SelectableListUI;


public interface UIFactory
	{
		public IDataView createDataView();
		
		public IDataViews createDataViews();
		
		public WebViewPanel createWebViewPanel();
		
		public SelectableListUI<Pathway> getPathwaySelectorUI();
		
		public void setBusyStatus(boolean isBusy);
		
		public void exit();
	}

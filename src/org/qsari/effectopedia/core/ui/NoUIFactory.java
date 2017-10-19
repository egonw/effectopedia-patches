package org.qsari.effectopedia.core.ui;

import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.gui.core.SelectableListUI;

public class NoUIFactory implements UIFactory
	{
		public final static NoUIFactory	FACTORY	= new NoUIFactory();
		
		private NoUIFactory()
			{
				super();
			}
		
		public IDataView createDataView()
			{
				return new NoDataView();
			}
		
		public IDataViews createDataViews()
			{
				return new DataViews();
			}
		
		public WebViewPanel createWebViewPanel()
			{
				return null;
			}
		
		@Override
		public SelectableListUI<Pathway> getPathwaySelectorUI()
			{
				return null;
			}
		
		@Override
		public void setBusyStatus(boolean isBusy)
			{
				this.busy = isBusy;
			}
		
		public boolean isBusy()
			{
				return busy;
			}

		public void setBusy(boolean busy)
			{
				this.busy = busy;
			}

		@Override
		public void exit()
			{
				
			}

		protected boolean	busy;

	}

package org.qsari.effectopedia.gui.core;

import java.awt.Cursor;

import javax.swing.JFrame;
import javax.swing.ToolTipManager;

import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.ui.DataViews;
import org.qsari.effectopedia.core.ui.IDataView;
import org.qsari.effectopedia.core.ui.IDataViews;
import org.qsari.effectopedia.core.ui.UIFactory;
import org.qsari.effectopedia.core.ui.WebViewPanel;
import org.qsari.effectopedia.gui.PathwaySelectionDialog;

public class GUIFactory implements UIFactory
	{
		public final static GUIFactory	FACTORY	= new GUIFactory();
		public static EffectopediaGUI		GUI;
		
		private GUIFactory()
			{
				ToolTipManager ttManager = ToolTipManager.sharedInstance();
				ttManager.setEnabled(true);
				ttManager.setLightWeightPopupEnabled(true);
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
				return new BasicWebViewPanel();
			}
			
		@Override
		public SelectableListUI<Pathway> getPathwaySelectorUI()
			{
				return PathwaySelectionDialog.DIALOG;
			}
			
		@Override
		public void setBusyStatus(boolean isBusy)
			{
				JFrame frame = (GUI != null) ? GUI.getFrame() : null;
				if (frame != null)
					if (isBusy)
						frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					else
						frame.setCursor(Cursor.getDefaultCursor());
			}
			
		@Override
		public void exit()
			{
				if (GUI != null)
					GUI.getFrame().dispose();
			}
			
	}

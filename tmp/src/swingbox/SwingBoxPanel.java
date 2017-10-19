package org.qsari.effectopedia.gui.swingbox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.net.URL;

import javax.swing.JPanel;

import org.fit.cssbox.swingbox.BrowserPane;
import org.qsari.effectopedia.core.ui.WebViewPanel;

public class SwingBoxPanel extends JPanel implements WebViewPanel

	{
		private BrowserPane	sbBrowser;
		
		public SwingBoxPanel()
			{
				super();
				initGUI();
			}
		
		@Override
		public void load(String url)
			{
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				try
					{
						URL page = new URL(url);
						sbBrowser.setPage(page);
					}
				catch (Exception e)
					{
					}
				finally
					{
						setCursor(Cursor.getDefaultCursor());
					}
			}
		
		private void initGUI()
			{
				try
					{
							{
								this.setBackground(Color.white);
								BorderLayout thisLayout = new BorderLayout();
								this.setLayout(thisLayout);
									{
										sbBrowser = new BrowserPane();
										sbBrowser.setEditable(false);
										this.add(sbBrowser, BorderLayout.CENTER);
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
	}

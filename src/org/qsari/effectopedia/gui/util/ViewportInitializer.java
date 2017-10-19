package org.qsari.effectopedia.gui.util;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JViewport;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ViewportInitializer implements ActionListener, Runnable, ChangeListener
	{
		public Point	TOPLEFT	= new Point(0, 0);
		public int			DELAY			= 10;
		
		public ViewportInitializer(JViewport viewport)
			{
				this.viewport = viewport;
				viewport.addChangeListener(this);
				inactivityTimer = null;
			}
		
		@Override
		public void run()
			{
				viewport.setViewPosition(TOPLEFT);
				//System.out.println("run x=" + viewport.getViewPosition().x + " y=" + viewport.getViewPosition().y);
			}
		
		@Override
		public void actionPerformed(ActionEvent evt)
			{
				//System.out.println("action performed x=" + viewport.getViewPosition().x + " y=" + viewport.getViewPosition().y);
				if (inactivityTimer != null)
					{
						inactivityTimer.stop();
						viewport.setViewPosition(TOPLEFT);
					}
				inactivityTimer = null;
			}
		
		public void waitAndInitialize()
			{
				// TODO Temporary work around because of unintended repositioning of the
				// scroll pane
				//System.out.println("wait and initialize x=" + viewport.getViewPosition().x + " y=" + viewport.getViewPosition().y);
				if (inactivityTimer == null)
					{
						inactivityTimer = new Timer(DELAY, this);
						inactivityTimer.start();
					}
			}
		
		public void initializeLater()
			{
				// TODO The code below should work in the general case however it does not
				// reposition the scroll pane when the same element editor is already
				// visible
				// before loading the new object
				javax.swing.SwingUtilities.invokeLater(this);
				
			}
		
		@Override
		public void stateChanged(ChangeEvent e)
			{
				//System.out.println("stateChanged x=" + viewport.getViewPosition().x + " y=" + viewport.getViewPosition().y);
				if ((inactivityTimer != null) && (inactivityTimer.isRunning()))
					inactivityTimer.restart();
			}
		
		private Timer					inactivityTimer;
		private JViewport	viewport;
	}

package org.qsari.effectopedia.gui.util;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.util.EventObject;

import org.qsari.effectopedia.gui.util.TextAreaStream.StreamChangeListener;

public class AWTLogger implements AWTEventListener, StreamChangeListener
	{
		public static AWTLogger	LOGGER	= new AWTLogger();
		
		private AWTLogger()
			{
				super();
			}
		
		public void install()
			{
				Toolkit.getDefaultToolkit().addAWTEventListener(this, EVENT_MASK);
//				Effectopedia.EFFECTOPEDIA.getErrorStream().addStreamChangeListener(this);
			}
		
		public void uninstall()
			{
				Toolkit.getDefaultToolkit().removeAWTEventListener(this);
//				Effectopedia.EFFECTOPEDIA.getErrorStream().removeStreamChangeListener(this);
			}
		
		public void eventDispatched(AWTEvent e)
			{
				log.append(System.currentTimeMillis());
				log.append("\t");
				log.append(e);
				log.append("\n");
			}

		@Override
		public void streamChanged(EventObject evt)
			{
				log.append("\n");
			}
		
		public final static StringBuilder	log								= new StringBuilder();
		private final static long									EVENT_MASK	= AWTEvent.MOUSE_MOTION_EVENT_MASK + AWTEvent.MOUSE_EVENT_MASK+AWTEvent.KEY_EVENT_MASK;

	}

package org.qsari.effectopedia.gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.util.EventListener;
import java.util.EventObject;

import javax.swing.JFrame;
import javax.swing.event.EventListenerList;

public class EffectopediaFrame extends JFrame implements WindowListener, WindowFocusListener, WindowStateListener
	{
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public EffectopediaFrame()
			{
				super();
				eventListeners = new EventListenerList();
			}
		
		@Override
		public void windowStateChanged(WindowEvent we)
			{
				fireEffectopediaFrameChanged(we);				
			}
		
		@Override
		public void windowGainedFocus(WindowEvent we)
			{
				fireEffectopediaFrameChanged(we);								
			}
		
		@Override
		public void windowLostFocus(WindowEvent we)
			{
				fireEffectopediaFrameChanged(we);								
			}
		
		@Override
		public void windowActivated(WindowEvent we)
			{
				fireEffectopediaFrameChanged(we);								
			}
		
		@Override
		public void windowClosed(WindowEvent we)
			{
				fireEffectopediaFrameChanged(we);								
			}
		
		@Override
		public void windowClosing(WindowEvent we)
			{
				fireEffectopediaFrameChanged(we);								
			}
		
		@Override
		public void windowDeactivated(WindowEvent we)
			{
				fireEffectopediaFrameChanged(we);								
			}
		
		@Override
		public void windowDeiconified(WindowEvent we)
			{
				fireEffectopediaFrameChanged(we);								
			}
		
		@Override
		public void windowIconified(WindowEvent we)
			{
				fireEffectopediaFrameChanged(we);								
			}
		
		@Override
		public void windowOpened(WindowEvent we)
			{
				fireEffectopediaFrameChanged(we);								
			}
		
		public interface EffectopediaFrameChangeListener extends EventListener
			{
				public void frameChanged(EventObject evt);
			}
		
		public void addEffectopediaFrameChangeListener(EffectopediaFrameChangeListener listener)
			{
				eventListeners.add(EffectopediaFrameChangeListener.class, listener);
			}
		
		public void removeEffectopediaFrameListener(EffectopediaFrameChangeListener listener)
			{
				eventListeners.remove(EffectopediaFrameChangeListener.class, listener);
			}
		
		protected void fireEffectopediaFrameChanged(EventObject evt)
			{
				EffectopediaFrameChangeListener[] listeners = eventListeners.getListeners(EffectopediaFrameChangeListener.class);
				for (int i = 0; i < listeners.length; i++)
					listeners[i].frameChanged(evt);
			}
		
		protected EventListenerList	eventListeners;
		
	}

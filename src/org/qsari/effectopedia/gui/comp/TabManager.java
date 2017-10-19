package org.qsari.effectopedia.gui.comp;

import java.util.EventListener;
import java.util.EventObject;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;

public class TabManager implements ChangeListener
	{
		public static final TabManager	MANAGER	= new TabManager();
		
		private TabManager()
			{
				super();
				eventListeners = new EventListenerList();
			}
		
		public interface TabChangeListener extends EventListener
			{
				public void tabChanged(EventObject evt);
			}
		
		public void addTabChangeListener(TabChangeListener listener)
			{
				eventListeners.add(TabChangeListener.class, listener);
			}
		
		public void removeTabChangeListener(TabChangeListener listener)
			{
				eventListeners.remove(TabChangeListener.class, listener);
			}
		
		@Override
		public void stateChanged(ChangeEvent evt)
			{
				fireTabChanged(new EventObject(evt.getSource()));
				lastSource = evt.getSource();
				if (lastSource instanceof JTabbedPane)
					lastTabIndex = ((JTabbedPane) lastSource).getSelectedIndex();
			}
		
		protected void fireTabChanged(EventObject evt)
			{
				TabChangeListener[] listeners = eventListeners.getListeners(TabChangeListener.class);
				for (int i = 0; i < listeners.length; i++)
					listeners[i].tabChanged(evt);
			}
		
		public Object getLastSource()
			{
				return lastSource;
			}
		
		public int getLastTabIndex()
			{
				return lastTabIndex;
			}
		
		private Object														lastSource			= null;
		private int																	lastTabIndex	= -1;
		protected EventListenerList	eventListeners;
	}

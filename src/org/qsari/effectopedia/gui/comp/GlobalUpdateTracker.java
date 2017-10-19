package org.qsari.effectopedia.gui.comp;

import java.util.EventListener;
import java.util.EventObject;

import javax.swing.event.EventListenerList;

public class GlobalUpdateTracker
	{
	 public static final GlobalUpdateTracker	GUT	= new GlobalUpdateTracker();

		private GlobalUpdateTracker()
				{
					eventListeners = new EventListenerList();
				}
			
			public interface ObjectUpdateListener extends EventListener
				{
					public void objectUpdated(EventObject evt);
				}
			
			public void addObjectUpdateListener(ObjectUpdateListener listener)
				{
					eventListeners.add(ObjectUpdateListener.class, listener);
				}
			
			public void removeObjectUpdateListener(ObjectUpdateListener listener)
				{
					eventListeners.remove(ObjectUpdateListener.class, listener);
				}
			
			public void fireObjectUpdated(EventObject evt)
				{
					ObjectUpdateListener[] listeners = eventListeners.getListeners(ObjectUpdateListener.class);
					for (int i = 0; i < listeners.length; i++)
						listeners[i].objectUpdated(evt);
				}
			
			protected EventListenerList	eventListeners;
	}

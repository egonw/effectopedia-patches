package org.qsari.effectopedia.gui.nav;

import java.awt.Component;
import java.awt.Container;
import java.util.EventListener;
import java.util.EventObject;

import javax.swing.JTabbedPane;
import javax.swing.event.EventListenerList;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.ui.nav.UIInitializer;
import org.qsari.effectopedia.core.ui.nav.UILocation;
import org.qsari.effectopedia.core.ui.nav.UINavigator;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;

public class GUINavigator implements UINavigator
	{
		
		public GUINavigator(Container root)
			{
				this.root = root;
				eventListeners = new EventListenerList();
			}
		
		private Component findComponentByClassName(Container container, String name)
			{
				Component[] components = container.getComponents();
				int cnt = components.length;
				Class<?> objectClass;
				try
					{
						objectClass = Class.forName(packageName + name);
					}
				catch (ClassNotFoundException e)
					{
						return null;
					}
				
				for (int i = 0; i < cnt; i++)
					if (objectClass.isAssignableFrom(components[i].getClass()))
						return components[i];
					else if (components[i] instanceof Container)
						{
							Component component = findComponentByClassName((Container) (components[i]), name);
							if (component != null)
								return component;
						}
				
				return null;
			}
		
		public void navigate(UILocation location, Object o, UIInitializer[] initialization)
			{
				Container container = (Container) navigate(location, o);
				if (initialization != null)
					for (int i = 0; i < initialization.length; i++)
						initialization[i].initialize(container);
			}
		
		public Component navigate(UILocation location, Object o)
			{
				if (location == null)
					return null;
				int progressIndex = 0;
				Component lastComponent = root;
				Component currentComponent = null;
				packageName = location.getPackageName();
				String currentLocation = location.getLocation(progressIndex);
				beforeNavigate(new NavigationEvent(location.getUserInterfaceLocation()));
				while (currentLocation != null)
					{
						progressIndex++;
						currentLocation = location.getLocation(progressIndex);
						if (currentLocation == null)
							break;
						if (lastComponent instanceof Container)
							currentComponent = findComponentByClassName((Container) lastComponent, currentLocation);
						if (currentComponent == null)
							return lastComponent;
						Component parentComponent = currentComponent.getParent();
						if (parentComponent instanceof JTabbedPane)
							((JTabbedPane) parentComponent).setSelectedIndex(((JTabbedPane) parentComponent).indexOfComponent(currentComponent));
						lastComponent = currentComponent;
					}
				if (currentComponent != null)
					{
						currentComponent.requestFocusInWindow();
						if (currentComponent instanceof LoadableEditorUI)
							if (o instanceof EffectopediaObject)
								{
									boolean isReadOnly = beforeLoading(new EventObject(o)) || location.isReadOnly();
								((LoadableEditorUI) currentComponent).load(o, (o != null) ? isReadOnly : false);
								}
							else
								((LoadableEditorUI) currentComponent).load(o, location.isReadOnly());
					}
				return currentComponent;
			}

		public interface PreLoadingListener extends EventListener
		{
			public boolean isReadOnly(EventObject evt);
		}

		public void addPreLoadingListener(PreLoadingListener listener)
			{
				eventListeners.add(PreLoadingListener.class, listener);
			}
		
		public void removePreLoadingListener(PreLoadingListener listener)
			{
				eventListeners.remove(PreLoadingListener.class, listener);
			}

		private boolean beforeLoading(EventObject evt)
			{
				boolean result = false;
				if (evt.getSource() instanceof EffectopediaObject)
		   result = ((EffectopediaObject)(evt.getSource())).isReadonly();
				PreLoadingListener[] listeners = eventListeners.getListeners(PreLoadingListener.class);
				for (int i = 0; i < listeners.length; i++)
					{
					result = result || listeners[i].isReadOnly(evt);
					if (result)
						return true;
					}
				return result;
			}

		public class NavigationEvent extends EventObject
			{
				/**
		 * 
		 */
				private static final long	serialVersionUID	= 1L;
				
				public NavigationEvent(String location)
					{
						super(location);
					}
			}
		
		public interface NavigatorListener extends EventListener
			{
				public void navigate(NavigationEvent evt);
			}
		
		public void addNavigatorListener(NavigatorListener listener)
			{
				eventListeners.add(NavigatorListener.class, listener);
			}
		
		public void removeNavigatorListener(NavigatorListener listener)
			{
				eventListeners.remove(NavigatorListener.class, listener);
			}
		
		private void beforeNavigate(NavigationEvent evt)
			{
				NavigatorListener[] listeners = eventListeners.getListeners(NavigatorListener.class);
				for (int i = 0; i < listeners.length; i++)
					listeners[i].navigate(evt);
			}
		
		private Container											root;
		private String														packageName;
		protected EventListenerList	eventListeners;
		
	}

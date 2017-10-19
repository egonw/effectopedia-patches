package org.qsari.effectopedia.gui.nav;

import java.awt.Component;
import java.awt.Container;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.qsari.effectopedia.core.ui.nav.UIInitializer;

public class GUIInitialization implements UIInitializer
	{
		
		public GUIInitialization(String componentName, String methodName, Object value, Class<?> valueType)
			{
				this.componentName = componentName;
				this.methodName = methodName;
				this.value = value;
				this.valueType = valueType;
			}
			
		public void initialize(Object initilization)
			{
				Method method;
				try
					{
						Container container = (Container) initilization;
						Component component = findComponent(container);
						if (component != null)
							{
								if (valueType == null)
									{
										method = component.getClass().getMethod(methodName);
										method.invoke(component);
									}
								else
									{
										method = component.getClass().getMethod(methodName, valueType);
										method.invoke(component, value);
									}
							}
					}
				catch (SecurityException e)
					{
						e.printStackTrace();
					}
				catch (NoSuchMethodException e)
					{
						e.printStackTrace();
					}
				catch (IllegalArgumentException e)
					{
						e.printStackTrace();
					}
				catch (IllegalAccessException e)
					{
						e.printStackTrace();
					}
				catch (InvocationTargetException e)
					{
						e.printStackTrace();
					}
			}
			
		private Component findComponent(Container container)
			{
				String name = container.getName();
				if ((name != null) && (componentName.compareTo(name) == 0))
					return container;
				Component[] components = container.getComponents();
				int cnt = components.length;
				for (int i = 0; i < cnt; i++)
					{
						name = components[i].getName();
						if ((name != null) && (componentName.compareTo(name) == 0))
							return components[i];
						else if (components[i] instanceof Container)
							{
								Component component = findComponent((Container) (components[i]));
								if (component != null)
									return component;
							}
					}
				return null;
			}
			
		private String			componentName;
		private String			methodName;
		private Object			value;
		private Class<?>	valueType;
	}

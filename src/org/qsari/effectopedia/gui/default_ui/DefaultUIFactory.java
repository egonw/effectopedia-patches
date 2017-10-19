package org.qsari.effectopedia.gui.default_ui;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import javax.swing.JComponent;

import org.qsari.effectopedia.base.ids.DescriptionIDs;
import org.qsari.effectopedia.base.ids.ReferenceIDW;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;

public class DefaultUIFactory
	{
		public static DefaultUIFactory	TITLE_INTERFACES			= new DefaultUIFactory();
		public static DefaultUIFactory	CONTENT_INTERFACES	= new DefaultUIFactory();
		
		private DefaultUIFactory()
			{
				interfaces = new HashMap<Class<?>, Class<? extends JComponent>>();
			}
			
		public JComponent getInterface(Class<?> cl, RootHelpContext rootHelpContext)
			{
				JComponent ui;
				Class<? extends JComponent> uiClass = interfaces.get(cl);
				if (uiClass == null)
					return null;
				if (ContextSensitivePanel.class.isAssignableFrom(uiClass))
					try
						{
							ui = uiClass.getDeclaredConstructor(RootHelpContext.class).newInstance(rootHelpContext);
						}
					catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e)
						{
							e.printStackTrace();
							return null;
						}
				else
					try
						{
							ui = uiClass.newInstance();
						}
					catch (InstantiationException | IllegalAccessException e)
						{
							e.printStackTrace();
							return null;
						}
				return ui;
			}
			
		public void putInterface(Class<?> cl, Class<? extends JComponent> inter)
			{
				interfaces.put(cl, inter);
			}
			
		public static void register(Class<?> cl, Class<? extends JComponent> titleInterface, Class<? extends JComponent> contentInterface)
			{
				TITLE_INTERFACES.putInterface(cl, titleInterface);
				CONTENT_INTERFACES.putInterface(cl, contentInterface);
			}
			
		static
			{
				register(ReferenceIDs.class, null, DescrSectionListUI.class);
				register(DescriptionIDs.class, null, DescrSectionListUI.class);
				register(ReferenceIDW.class, WeightedEvidenceTitleUI.class, null);
				register(Double.class, WeightedEvidenceTitleUI.class, null);
			}
			
		private HashMap<Class<?>, Class<? extends JComponent>> interfaces;
		
	}

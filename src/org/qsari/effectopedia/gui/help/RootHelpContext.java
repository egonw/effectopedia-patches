package org.qsari.effectopedia.gui.help;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseMotionListener;

public interface RootHelpContext extends MouseMotionListener
	{
		public ContextSensitivePanel getRootMotionListener();
		
		static public void addMouseMotionListeners(Container container, RootHelpContext rootHelpContext, boolean recursive)
			{
				if (container != null)
					{
						if (recursive)
							{
								for (Component c : container.getComponents())
									if (!(c instanceof ContextSensitivePanel))
										c.addMouseMotionListener(rootHelpContext);
							}
						else
							{
								for (Component c : container.getComponents())
									{
										if (c instanceof Container)
											addMouseMotionListeners((Container) c, rootHelpContext, recursive);
										if (!(c instanceof ContextSensitivePanel))
											c.addMouseMotionListener(rootHelpContext);
									}
							}
					}
			}
			
	}

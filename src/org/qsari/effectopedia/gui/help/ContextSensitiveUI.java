package org.qsari.effectopedia.gui.help;

import java.awt.event.MouseEvent;

public interface ContextSensitiveUI
	{
		public String getComponetHelpContext(MouseEvent e);
		
		public String getHelpID();
	}

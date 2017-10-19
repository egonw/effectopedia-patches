package org.qsari.effectopedia.gui.help;

import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;

public class RootHelpContextScrollPane extends JScrollPane implements RootHelpContext
	{
		public RootHelpContextScrollPane()
		{
			super();
			rootHelpContext = this;
		}
		
		public ContextSensitivePanel getRootMotionListener()
			{
				return cspEditPanel;
			}

		@Override
		public void mouseDragged(MouseEvent e)
			{
				cspEditPanel.mouseDragged(e);
			}

		@Override
		public void mouseMoved(MouseEvent e)
			{
				cspEditPanel.mouseMoved(e);
			}

		protected ContextSensitivePanel	cspEditPanel;
		protected RootHelpContext							rootHelpContext;
		
		/**
		* 
		*/
		private static final long							serialVersionUID	= 1L;


		
	}

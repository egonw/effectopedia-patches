package org.qsari.effectopedia.gui;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Scrollable;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.core.ui.nav.UILocation;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.util.HintedTextField;

public class EffectopediaObjectHeaderUI<E extends EffectopediaObject> extends ContextSensitivePanel implements MouseListener, Scrollable, InitializableUI
	{
		public EffectopediaObjectHeaderUI(RootHelpContext rootHelpContext)
		{
			super(rootHelpContext);
		}

		protected HintedTextField	htfTitle;
		
		public void mouseEntered(MouseEvent arg0)
			{
			}
		
		public void mouseExited(MouseEvent arg0)
			{
			}
		
		public void mousePressed(MouseEvent arg0)
			{
			}
		
		public void mouseReleased(MouseEvent arg0)
			{
			}
		
		public void mouseClicked(MouseEvent e)
			{
				if ((allowRedirecting) && (e.getClickCount() == 2) && (eo != null))
					{
						UILocation location = UILocations.getProperEditor(eo);
						location.setReadOnly(eo.isReadonly());
						UserInterface.getDefaultNavigator().navigate(location, eo);
					}
			}
		
		public boolean isAllowRedirecting()
			{
				return allowRedirecting;
			}
		
		public void setAllowRedirecting(boolean allowRedirecting)
			{
				this.allowRedirecting = allowRedirecting;
			}
		
		@Override
		public Dimension getPreferredScrollableViewportSize()
			{
				//System.out.println("getPreferredScrollableViewportSize");
				return getPreferredSize();
			}
		
		@Override
		public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction)
			{
				//System.out.println("getScrollableBlockIncrement");
				return 10;
			}
		
		@Override
		public boolean getScrollableTracksViewportHeight()
			{
				//System.out.println("getScrollableTracksViewportHeight");
				return true;
			}
		
		@Override
		public boolean getScrollableTracksViewportWidth()
			{
				//System.out.println("getScrollableTracksViewportWidth");
				return true;
			}
		
		@Override
		public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction)
			{
				//System.out.println("getScrollableUnitIncrement");
				return 10;
			}
		
		public HintedTextField getTitleUI()
			{
				return htfTitle;
			}
		
		@Override
		public void updateOptimalSize()
			{
				// TODO Auto-generated method stub
				
			}
		
		@Override
		public void initializeUI()
			{
				htfTitle.requestFocus();
				this.scrollRectToVisible(htfTitle.getBounds());
				if ((eo != null) && (eo.isDefaultID()))
					htfTitle.selectAll();
			}
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		protected E															eo;
		protected boolean									allowRedirecting	= false;
		
	}

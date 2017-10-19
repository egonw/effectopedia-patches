package org.qsari.effectopedia.gui.im;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import org.qsari.effectopedia.go.pathway_elements.DisplaySections;
import org.qsari.effectopedia.gui.PathwaysViewUI;
import org.qsari.effectopedia.gui.UIResources;

public class ZoomIM extends InterfaceMode
	{
		public static final boolean	ZOOM_IN		= true;
		public static final boolean	ZOOM_OUT	= false;
		
		public ZoomIM(PathwaysViewUI pathwayUI, InterfaceModes owner, boolean zoom)
			{
				super(pathwayUI, owner);
				setCursors(make3StateCursors(Cursor.getDefaultCursor(), UIResources.zoomInCursor, UIResources.zoomOutCursor));
				this.zoom = zoom;
				if (zoom)
					this.alternativeModeType = InterfaceModeConstants.ZOOM_OUT;
				else
					this.alternativeModeType = InterfaceModeConstants.ZOOM_IN;
			}
		
		protected void determineState()
			{
				int state = (zoom) ? 1 : 2;
				setState(state);
			}
		
		public void mouseClicked(MouseEvent e)
			{
				int lastX = e.getX();
				int lastY = e.getY();
				setCurrentLO(viewLayout.isOver(lastX, lastY));
				setLastLO(viewLayout.getLastLO());
				currentContainer = viewLayout.getCurrentContainer();
//				boolean zoomIn = (((e.getModifiersEx()&InputEvent.BUTTON3_DOWN_MASK))==InputEvent.BUTTON3_DOWN_MASK)?zoom:!zoom;
				if (keyCtrlPressed)
					{
						if (currentLO!=null)
							pathwayDataView.zoomFocusLO(zoom, currentLO);
						else 
							pathwayDataView.zoomFocusLO(zoom, currentLO);
					}
				else
				 pathwayDataView.zoom(zoom);
				DisplaySections.titleOnly = pathwaysView.getViewLayout().getScale().getLevel()<=28;
				pathwaysViewUI.repaint();
				determineState();
			}
		
		public void setActive(boolean active)
			{
				super.setActive(active);
				if (active)
					defaultAction();
			}
		
		public void defaultAction()
			{
				pathwayDataView.zoom(zoom);
				//System.out.print(pathwaysView.getViewLayout().getScale().getLevel());
				DisplaySections.titleOnly = pathwaysView.getViewLayout().getScale().getLevel()<=28;
				//System.out.println(pathwayDataView.getViewWidth()+","+pathwayDataView.getViewHeight());
				//System.out.println("available="+viewLayout.getAvailableWidth()+","+viewLayout.getAvailableHeight());
			}
		
		protected void reset()
			{
				viewLayout.setSimpleActiveRegion(true);
				viewLayout.setShowActiveRegion(false);
				pathwayDataView.zoomFocusLO(zoom, null);
				pathwaysView.getViewLayout().setArcsSelectable(true);
			}
		
		@Override
		public String getContext()
			{
				int z = ((keyAltPressed)?!zoom:zoom) ? 1 : 0;
				if (currentGO != null)
						return "-"+zoomNames[z]+"-current_object";
					else
						return "-"+zoomNames[z];
			}

		protected boolean	zoom;
		protected String[] zoomNames = new String[]{"zoom_out","zoom_in"};
	}

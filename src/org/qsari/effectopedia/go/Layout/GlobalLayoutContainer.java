package org.qsari.effectopedia.go.Layout;

import java.util.EventListener;
import java.util.EventObject;

import javax.swing.event.EventListenerList;

import org.qsari.effectopedia.go.ActiveRegionGO;
import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.containers.ExtendedGOC;
import org.qsari.effectopedia.go.containers.GraphicObjectsContainer;

public class GlobalLayoutContainer extends LayoutObjectsContainer
	{
		
		public GlobalLayoutContainer()
			{
				super();
				activeRegion = new ActiveRegionGO(1, 1);
				eventListeners = new EventListenerList();
			}
			
		public GlobalLayoutContainer(LayoutObjectsContainer parent)
			{
				super(parent);
				activeRegion = new ActiveRegionGO(1, 1);
				eventListeners = new EventListenerList();
			}
			
		public LayoutObjectsContainer getLOContainerUnderCursor(int x, int y)
			{
				int i = getXIndexByX(x);
				int j = getYIndexByY(y);
				if ((i >= 0) && (j >= 0))
					return (LayoutObjectsContainer) getComponent(i, j);
				else
					return null;
			}
			
		public GraphicObject getGraphicObjectUnderCursor(int x, int y)
			{
				int i = getXIndexByX(x);
				int j = getYIndexByY(y);
				boolean active = (i != -1) && (j != -1);
				if (active)
					{
						LayoutObjectsContainer container = (LayoutObjectsContainer) getComponent(i, j);
						if ((container != null) && (container.getSimpleActiveIndex(x, y).isCenterAction()))
							{
								i = container.getXIndexByX(x);
								j = container.getYIndexByY(y);
								LayoutObject cursorLO = container.getComponent(i, j);
								return cursorLO != null ? cursorLO.getGo() : null;
							}
					}
				return null;
			}
			
		public LayoutObject getLayoutObjectUnderCursor(int x, int y)
			{
				int i = getXIndexByX(x);
				int j = getYIndexByY(y);
				boolean active = (i != -1) && (j != -1);
				if (active)
					{
						LayoutObjectsContainer container = (LayoutObjectsContainer) getComponent(i, j);
						if ((container != null) && (container.getSimpleActiveIndex(x, y).isCenterAction()))
							{
								i = container.getXIndexByX(x);
								j = container.getYIndexByY(y);
								LayoutObject cursorLO = container.getComponent(i, j);
								return cursorLO;
							}
					}
				return null;
			}
			
		public LayoutObject isOver(int x, int y)
			{
				int i = getXIndexByX(x);
				int j = getYIndexByY(y);
				boolean active = (i != -1) && (j != -1);
				if (active)
					{
						LayoutObjectsContainer container = (LayoutObjectsContainer) getComponent(i, j);
						// System.out.println("Container i="+i+" j="+j+" left="+container.x+"
						// right="+container.getActualRight());
						setCurrentContainer((LayoutObjectsContainer) container);
						lastLO = currentLO;
						if (container != null)
							{
								i = container.getXIndexByX(x);
								j = container.getYIndexByY(y);
								currentLO = container.getComponent(i, j);
								activeRegion.updateActiveIndex(container.getActiveIndex(x, y), simpleActiveRegion || (currentLO == null) || (currentLO.getGo() == null));
								return currentLO;
							}
						else
							{
								currentLO = null;
								return this;
							}
					}
				return null;
			}
			
		public void cleanup()
			{
				for (LayoutObject loc : components)
					((LayoutObjectsContainer) loc).clearEmpty();
			}
			
		public LayoutObject getLastLO()
			{
				return lastLO;
			}
			
		public LayoutObject getCurrentLO()
			{
				return currentLO;
			}
			
		public LayoutObjectsContainer getCurrentContainer()
			{
				return currentContainer;
			}
			
		private void setCurrentContainer(LayoutObjectsContainer container)
			{
				this.lastContainer = this.currentContainer;
				if (lastContainer != null)
					{
						GraphicObjectsContainer goc = this.lastContainer.getGo();
						if ((goc != null) && (goc instanceof ExtendedGOC))
							((ExtendedGOC) goc).setActiveLayer(null);
					}
				this.currentContainer = container;
				if ((showActiveRegion) && (container != null))
					{
						GraphicObjectsContainer goc = container.getGo();
						activeRegion.updateDivision(container.xOffsets, container.yOffsets);
						if ((goc != null) && (goc instanceof ExtendedGOC))
							((ExtendedGOC) goc).setActiveLayer(activeRegion);
					}
			}
			
		public LayoutObjectsContainer getLastContainer()
			{
				return lastContainer;
			}
			
		public boolean isShowActiveRegion()
			{
				return showActiveRegion;
			}
			
		public void setShowActiveRegion(boolean showActiveRegion)
			{
				this.showActiveRegion = showActiveRegion;
				if (currentContainer != null)
					{
						GraphicObjectsContainer goc = currentContainer.getGo();
						activeRegion.updateDivision(currentContainer.xOffsets, currentContainer.yOffsets);
						if ((goc != null) && (goc instanceof ExtendedGOC))
							if (showActiveRegion)
								((ExtendedGOC) goc).setActiveLayer(activeRegion);
							else
								((ExtendedGOC) goc).setActiveLayer(null);
					}
			}
			
		public boolean isSimpleActiveRegion()
			{
				return simpleActiveRegion;
			}
			
		public void setSimpleActiveRegion(boolean simpleActiveRegion)
			{
				this.simpleActiveRegion = simpleActiveRegion;
			}
			
		public ActiveRegionGO getActiveRegion()
			{
				return activeRegion;
			}
			
		public int getActualWidth()
			{
				return ((availableWidth > totalWidth) && (xScale >= 1.0F)) ? availableWidth : totalWidth;
			}
			
		public int getActualHeight()
			{
				return ((availableHeight > totalHeight) && (yScale >= 1.0F)) ? availableHeight : totalHeight;
			}
			
		protected void distributeObjects()
			{
				super.distributeObjects();
				fireLayoutChanged(new EventObject(this));
			}
			
		public interface LayoutChangeListener extends EventListener
			{
				public void layoutUpdated(EventObject evt);
			}
			
		public void addLayoutChangeListener(LayoutChangeListener listener)
			{
				eventListeners.add(LayoutChangeListener.class, listener);
			}
			
		public void removeLayoutChangeListener(LayoutChangeListener listener)
			{
				eventListeners.remove(LayoutChangeListener.class, listener);
			}
			
		private void fireLayoutChanged(EventObject evt)
			{
				LayoutChangeListener[] listeners = eventListeners.getListeners(LayoutChangeListener.class);
				for (int i = 0; i < listeners.length; i++)
					listeners[i].layoutUpdated(evt);
			}
			
		protected EventListenerList						eventListeners;
		
		protected boolean																showActiveRegion				= true;
		protected boolean																showEmptyContainers	= true;
		protected ActiveRegionGO									activeRegion								= null;
		protected boolean																simpleActiveRegion		= true;
		protected LayoutObject											lastLO														= null;
		protected LayoutObject											currentLO											= null;
		protected LayoutObjectsContainer	lastContainer							= null;
		protected LayoutObjectsContainer	currentContainer				= null;
		
	}

package org.qsari.effectopedia.go.Layout;

import java.awt.Container;
import java.util.ArrayList;
import java.util.ListIterator;

import org.qsari.effectopedia.go.GraphicObject;
import org.qsari.effectopedia.go.containers.GraphicObjectsContainer;
import org.qsari.effectopedia.go.gui.PathwaySpaceDimensionGOC;

public class LayoutOCSynchronizer
	{
		public LayoutOCSynchronizer(LayoutObjectsContainer master, Container container)
			{
				super();
				this.master = master;
				this.container = container;
				horizontal = new ArrayList<LayoutObjectsContainer>();
				vertical = new ArrayList<LayoutObjectsContainer>();
			}
			
		public void bondToMasterHorizontally(LayoutObjectsContainer container)
			{
				horizontal.add(container);
			}
			
		public void bondToMasterVertically(LayoutObjectsContainer container)
			{
				vertical.add(container);
			}
			
		public void clearBonds()
			{
				horizontal.clear();
				vertical.clear();
			}
			
		public void synchronizeHorizontally()
			{
				for (ListIterator<LayoutObjectsContainer> iterator = horizontal.listIterator(); iterator.hasNext();)
					{
						LayoutObjectsContainer container = iterator.next();
						container.maxWidths = master.maxWidths;
						container.updateTotals();
						container.setAvailableSpace(master.getAvailableWidth(), container.getAvailableHeight());
						container.distribute(HorizontalAlignment.GAPLESSFILL, VerticalAlignment.GAPLESSFILL);
					}
			}
			
		public void synchronizeVertically()
			{
				for (ListIterator<LayoutObjectsContainer> iterator = vertical.listIterator(); iterator.hasNext();)
					{
						LayoutObjectsContainer container = iterator.next();
						container.maxHeights = master.maxHeights;
						container.updateTotals();
						container.setAvailableSpace(container.getAvailableWidth(), master.getAvailableHeight());
						// container.distribute(HorizontalAlignment.GAPLESSFILL,
						// VerticalAlignment.GAPLESSFILL);
					}
			}
			
		public void updateActiveRegion(int xIndex, int yIndex, boolean active)
			{
				for (LayoutObjectsContainer loc : horizontal)
					{
						GraphicObjectsContainer goc = loc.goc;
						if (goc instanceof PathwaySpaceDimensionGOC)
							((PathwaySpaceDimensionGOC) goc).updateActive(xIndex, active);
					}
				for (LayoutObjectsContainer loc : vertical)
					{
						GraphicObjectsContainer goc = loc.goc;
						if (goc instanceof PathwaySpaceDimensionGOC)
							((PathwaySpaceDimensionGOC) goc).updateActive(yIndex, active);
					}
			}
			
		public void synchronize()
			{
				synchronizeHorizontally();
				synchronizeVertically();
			}
			
		public void synchronizeAndPaint()
			{
				synchronizeHorizontally();
				synchronizeVertically();
				if (container != null)
					container.repaint();
			}
			
		public void repaint()
			{
				if (container != null)
					container.repaint();
			}
			
		private LayoutObjectsContainer												master;
		private Container																									container;
		private ArrayList<LayoutObjectsContainer>	horizontal;
		private ArrayList<LayoutObjectsContainer>	vertical;
		
	}

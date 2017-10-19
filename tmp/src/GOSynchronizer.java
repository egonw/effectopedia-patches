package org.qsari.effectopedia.go;

import java.awt.Container;
import java.util.ArrayList;
import java.util.ListIterator;

public class GOSynchronizer
	{
		public static final int	SYNCHRONIZE_NOTHING	= 0;
		public static final int	SYNCHRONIZE_X							= 1;
		public static final int	SYNCHRONIZE_Y							= 2;
		public static final int	SYNCHRONIZE_HEIGHT		= 4;
		public static final int	SYNCHRONIZE_WIDTH			= 8;
		public static final int	SYNCHRONIZE_DETAILS	= 16;
		public static final int	SYNCHRONIZE_XWD					= 25;
		public static final int	SYNCHRONIZE_YHD					= 22;
		public static final int	SYNCHRONIZE_ALL					= 33;
		
		public GOSynchronizer(Container container)
			{
				list = new ArrayList<GraphicObjectContainer>();
				this.container = container;
			}
		
		public void add(GraphicObjectContainer gos)
			{
				gos.setSynchronizer(this);
				list.add(gos);
			}
		
		public void remove(GraphicObjectContainer gos)
			{
				int index = list.indexOf(gos);
				if (index != -1)
					{
						gos.setSynchronizer(null);
						list.remove(index);
					}
			}
		
		public void synchronize(GraphicObjectContainer target, int what)
			{
				for (ListIterator<GraphicObjectContainer> iterator = list.listIterator(); iterator.hasNext();)
					{
						GraphicObjectContainer gos = iterator.next();
						if (gos != target)
							{
								if ((what & SYNCHRONIZE_X) != 0)
									gos.synchronizeX(target);
								if ((what & SYNCHRONIZE_Y) != 0)
									gos.synchronizeY(target);
								if ((what & SYNCHRONIZE_HEIGHT) != 0)
									gos.synchronizeHeight(target);
								if ((what & SYNCHRONIZE_WIDTH) != 0)
									gos.synchronizeWidth(target);
								if ((what & SYNCHRONIZE_DETAILS) != 0)
									gos.synchronizeDetails(target);
							}
					}
				if (container != null)
					container.repaint();
			}
		
		public void synchronizeHeight(GraphicObjectContainer target)
			{
				for (ListIterator<GraphicObjectContainer> iterator = list.listIterator(); iterator.hasNext();)
					{
						GraphicObjectContainer gos = iterator.next();
						if (gos != target)
							gos.synchronizeHeight(target);
					}
			}
		
		public void synchronizeX(GraphicObjectContainer target)
			{
				for (ListIterator<GraphicObjectContainer> iterator = list.listIterator(); iterator.hasNext();)
					{
						GraphicObjectContainer gos = iterator.next();
						if (gos != target)
							gos.synchronizeX(target);
					}
			}
		
		public void synchronizeY(GraphicObjectContainer target)
			{
				for (ListIterator<GraphicObjectContainer> iterator = list.listIterator(); iterator.hasNext();)
					{
						GraphicObjectContainer gos = iterator.next();
						if (gos != target)
							gos.synchronizeY(target);
					}
			}
		
		public void synchronizeWidth(GraphicObjectContainer target)
			{
				for (ListIterator<GraphicObjectContainer> iterator = list.listIterator(); iterator.hasNext();)
					{
						GraphicObjectContainer gos = iterator.next();
						if (gos != target)
							gos.synchronizeWidth(target);
					}
			}
		
		public void synchronizeDetails(GraphicObjectContainer target)
			{
				for (ListIterator<GraphicObjectContainer> iterator = list.listIterator(); iterator.hasNext();)
					{
						GraphicObjectContainer gos = iterator.next();
						if (gos != target)
							gos.synchronizeDetails(target);
					}
			}
		
		public void repaint()
			{
				if (container != null)
					container.repaint();
			}
		
		private Container																	container;
		private ArrayList<GraphicObjectContainer>	list;
	}

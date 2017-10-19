package org.qsari.effectopedia.core.ui;

import java.awt.Dimension;
import java.util.ArrayList;

import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.core.containers.Pathways;
import org.qsari.effectopedia.core.objects.ContextDimension;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.search.SearchResults;

public class NoDataView implements IDataView
	{
		public NoDataView()
			{
				pathways = new ArrayList<Pathway>();
				dataViewChangeListeners = new ArrayList<NoDataView.DataViewChangeListener>();
			}
		
		public void setDefaultViewAxis()
			{
				setViewAxis(DefaultEffectopediaObjects.DEFAULT_LBO, DefaultEffectopediaObjects.DEFAULT_SEX);
				fireDataViewChanged(new DataViewChange(this));
			}
		
		public void setViewAxis(ContextDimension horizontalAxis, ContextDimension verticalAxis)
			{
				this.horizontalDimension = horizontalAxis;
				this.verticalDimension = verticalAxis;
				fireDataViewChanged(new DataViewChange(this));
			}
		
		public void rebuildView()
			{
				fireDataViewChanged(new DataViewChange(this));
			}
		
		public void clear()
			{
				pathways.clear();
				currentPathway = null;
			}
		
		public void zoom(boolean zoomIn)
			{
				fireDataViewChanged(new DataViewChange(this));
			}
		
		public synchronized void addToView(Pathway pathway)
			{
				currentPathway = pathway;
				pathways.add(pathway);
				fireDataViewChanged(new DataViewChange(this));
			}
		
		public void addNewPathway(Pathway pathway)
			{
				currentPathway = pathway;
				pathways.add(pathway);
			}
		
		public void addToView(SearchResults searchResults)
			{
			}
		
		public void rebuildPathwayView()
			{
			}
		
		public Pathway getLastAddedPathway()
			{
				int index = pathways.size() - 1;
				if (index >= 0)
					return pathways.get(index);
				else
					return null;
			}
		
		public ArrayList<Pathway> getPathways()
			{
				return pathways;
			}
		
		public Pathway getCurrentPathway()
			{
				return currentPathway;
			}
		
		public void setCurrentPathway(Pathway currentPathway)
			{
				this.currentPathway = currentPathway;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				return element;
			}
		
		public ContextDimension getHorizontalDimension()
			{
				return horizontalDimension;
			}
		
		public void setHorizontalDimension(ContextDimension horizontalDimension)
			{
				this.horizontalDimension = horizontalDimension;
			}
		
		public ContextDimension getVerticalDimension()
			{
				return verticalDimension;
			}
		
		public void setVerticalDimension(ContextDimension verticalDimension)
			{
				this.verticalDimension = verticalDimension;
			}
		
		public int getViewWidth()
			{
				return viewWidth;
			}
		
		public void setViewWidth(int viewWidth)
			{
				this.viewWidth = viewWidth;
			}
		
		public int getViewHeight()
			{
				return viewHeight;
			}
		
		public void setViewHeight(int viewHeight)
			{
				this.viewHeight = viewHeight;
			}
		
		public void setViewHeightAndWidth(int viewWidth, int viewHeight)
			{
				this.viewWidth = viewWidth;
				this.viewHeight = viewHeight;
			}
		
		public void setPrefferedSize(Dimension prefferedSize)
			{
				this.viewWidth = prefferedSize.width;
				this.viewHeight = prefferedSize.height;
			}
		
		public Object createArc(PathwayElement upstreamElement, PathwayElement element)
			{
				return null;
			}
		
		public void removeArc(PathwayElement upstreamElement, PathwayElement element)
			{
			}
		
		public boolean isVisible(PathwayElement element)
			{
				return false;
			}
		
		public class DataViewChange
			{
				public DataViewChange(Object source)
					{
						this.source = source;
					}
				public final Object	source;
			}
		
		public interface DataViewChangeListener
			{
				public void dataViewChanged(DataViewChange evt);
			}
		
		public void addDataViewChangeListener(DataViewChangeListener listener)
			{
				dataViewChangeListeners.add(listener);
			}
		
		public void removeDataViewChangeListener(DataViewChangeListener listener)
			{
				dataViewChangeListeners.remove(listener);
			}
		
		protected void fireDataViewChanged(DataViewChange evt)
			{
				for (DataViewChangeListener listener : dataViewChangeListeners)
					listener.dataViewChanged(evt);
			}
		
		public boolean isReadOnly()
			{
				return readOnly;
			}
		
		public void setReadOnly(boolean readOnly)
			{
				this.readOnly = readOnly;
			}
		
		public boolean areViewAxisInitialized()
			{
				return (horizontalDimension != null) && (verticalDimension != null);
			}
		
		public final String getName()
			{
				return name;
			}
		
		public final void setName(String name)
			{
				this.name = name;
			}
		
		/**
		 * <code>pathways</code> Contain currently visible one or more pathways
		 * available in the current {@link org.qsari.effectopedia.data.DataSource}
		 * 
		 * @see Pathways
		 */
		protected ArrayList<Pathway>	pathways;
		/**
		 * <code>readOnly</code> flag determine if the loaded pathway can be edited or
		 * not.
		 */
		protected ArrayList<DataViewChangeListener>		dataViewChangeListeners;
		
		/**
		 * Currently active pathway. All new objects The name of this
		 * <code>DataView</code>
		 */
		protected Pathway												currentPathway;
		/**
		 * The name of this <code>DataView</code>
		 */
		protected String													name;
		
		protected boolean												readOnly;
		protected ContextDimension			horizontalDimension;
		protected ContextDimension			verticalDimension;
		protected int																viewWidth;
		protected int																viewHeight;
		
	}

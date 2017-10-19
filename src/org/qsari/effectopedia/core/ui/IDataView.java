package org.qsari.effectopedia.core.ui;

import java.util.ArrayList;

import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.objects.ContextDimension;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.search.SearchResults;

public interface IDataView extends Importable, Exportable
	{
		public void setDefaultViewAxis();
		
		public void setViewAxis(ContextDimension horizontalAxis, ContextDimension verticalAxis);
		
		public void rebuildView();
		
		public void clear();
		
		public void zoom(boolean zoomIn);
		
		public Object createArc(PathwayElement upstreamElement, PathwayElement element);
		
		public void removeArc(PathwayElement upstreamElement, PathwayElement element);
		
		public void addToView(Pathway pathway);
		
		public void addNewPathway(Pathway pathway);
		
		public void addToView(SearchResults searchResults);
		
		public boolean isVisible(PathwayElement element);
		
		public void rebuildPathwayView();
		
		public Pathway getLastAddedPathway();
		
		public ArrayList<Pathway> getPathways();
		
		public Pathway getCurrentPathway();
		
		public void setCurrentPathway(Pathway currentPathway);
		
		public ContextDimension getHorizontalDimension();
		
		public void setHorizontalDimension(ContextDimension horizontalDimension);
		
		public ContextDimension getVerticalDimension();
		
		public void setVerticalDimension(ContextDimension verticalDimension);
		
		public int getViewWidth();
		
		public void setViewWidth(int viewWidth);
		
		public int getViewHeight();
		
		public void setViewHeight(int viewHeight);
		
		public void setViewHeightAndWidth(int viewWidth, int viewHeight);
		
		public boolean areViewAxisInitialized();
		
		public boolean isReadOnly();
		
		public void setReadOnly(boolean readOnly);
		
		public String getName();
		
		public void setName(String name);
		
	}

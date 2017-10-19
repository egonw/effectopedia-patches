package org.qsari.effectopedia.gui.core;

import java.util.EventObject;
import java.util.HashMap;
import java.util.Map;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.containers.Pathways;
import org.qsari.effectopedia.core.objects.ContextDimension;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.ui.IDataView;
import org.qsari.effectopedia.core.ui.NoDataView;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.RevisionBasedDS;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.Layout.BasicLayout;
import org.qsari.effectopedia.go.Layout.GlobalLayoutContainer.LayoutChangeListener;
import org.qsari.effectopedia.go.Layout.LayoutObject;
import org.qsari.effectopedia.go.Layout.LayoutObjectSelection;
import org.qsari.effectopedia.go.Layout.LayoutObjectsContainer;
import org.qsari.effectopedia.go.Layout.LayoutObjectsContainer.ActiveIndex;
import org.qsari.effectopedia.go.builder.ContextSpaceBuilder;
import org.qsari.effectopedia.go.builder.PathwayVisualisationBuilder;
import org.qsari.effectopedia.go.gui.PathwaysView;
import org.qsari.effectopedia.go.pathway_elements.PathwayElementGO;
import org.qsari.effectopedia.gui.ElementEditorUI;
import org.qsari.effectopedia.gui.inspector.ObjectInspectorUI;
import org.qsari.effectopedia.search.SearchResults;

public class DataView extends NoDataView implements Importable, Exportable, LayoutChangeListener, IDataView
	{
		public DataView()
			{
				super();
				pathwaysView = new PathwaysView();
				this.pathwaysView.addLayoutChangeListener(this);
				
				fragments = new HashMap<PathwayElement, PathwayElementGO>();
				pathwayBuilder = new PathwayVisualisationBuilder(this);
			}
			
		@Override
		public void setDefaultViewAxis()
			{
				setViewAxis(DefaultEffectopediaObjects.DEFAULT_LBO, DefaultEffectopediaObjects.DEFAULT_SEX);
				pathwaysView.update();
				fireDataViewChanged(new DataViewChange(this));
			}
			
		@Override
		public void setViewAxis(ContextDimension horizontalAxis, ContextDimension verticalAxis)
			{
				this.horizontalDimension = horizontalAxis;
				this.verticalDimension = verticalAxis;
				contextSpaceBuilder = new ContextSpaceBuilder(this);
				contextSpaceBuilder.buildSpace();
				pathwayBuilder.rebuildView();
				pathwaysView.setAvailableSpace(viewWidth, viewHeight);
				pathwaysView.update();
				fireDataViewChanged(new DataViewChange(this));
			}
			
		@Override
		public void rebuildView()
			{
				contextSpaceBuilder = new ContextSpaceBuilder(this);
				contextSpaceBuilder.buildSpace();
				pathwayBuilder.rebuildView();
				pathwaysView.setAvailableSpace(viewWidth, viewHeight);
				pathwaysView.update();
				fireDataViewChanged(new DataViewChange(this));
			}
			
		@Override
		public void clear()
			{
				pathwayBuilder.clear();
				pathways.clear();
				currentPathway = null;
			}
			
		@Override
		public void zoom(boolean zoomIn)
			{
				pathwaysView.zoom(zoomIn);
				fireDataViewChanged(new DataViewChange(this));
			}
			
		public void zoomFocusLO(boolean zoomIn, LayoutObject focusLO)
			{
				pathwaysView.zoomFocusLO(zoomIn, focusLO);
				fireDataViewChanged(new DataViewChange(this));
			}
			
		public void removeFromView(ActiveIndex activeIndex, LayoutObjectsContainer container, PathwayElement element)
			{
				pathwayBuilder.removePathwayElement(activeIndex, container, element);
			}
			
		public LayoutObject setInView(ActiveIndex activeIndex, LayoutObjectsContainer container, PathwayElement element)
			{
				return pathwayBuilder.setPathwayElement(activeIndex, container, element);
			}

		public LayoutObject addToView(ActiveIndex activeIndex, LayoutObjectsContainer container, PathwayElement element)
			{
				return pathwayBuilder.addPathwayElement(activeIndex, container, element);
			}
			
		public LayoutObject addTemporaryToView(ActiveIndex activeIndex, LayoutObjectsContainer container, PathwayElement element)
			{
				return pathwayBuilder.setTemporaryPathwayElement(activeIndex, container, element);
			}
			
		public LayoutObject replaceInView(PathwayElement element, PathwayElement newElement)
			{
				return pathwayBuilder.replaceInView(element, newElement);
			}
			
		public LayoutObject getLayoutObjectForElement(PathwayElement element)
			{
				return pathwayBuilder.getViewElements().get(element);
			}
			
		public void updateElementLocation(PathwayElement element, LayoutObjectsContainer container)
			{
				pathwayBuilder.updateElementLocation(element, container);
			}

		public LayoutObject updateElementLocation(PathwayElement element)
			{
				LayoutObject lo = pathwayBuilder.getViewElements().get(element);
				if (lo != null)
					pathwayBuilder.updateElementLocation(element, lo.getParent());
				return lo;
			}
		
		@Override
		public Object createArc(PathwayElement upstreamElement, PathwayElement element)
			{
				return pathwayBuilder.createArc(upstreamElement, element);
			}
			
		public void crateArc(LayoutObject object1, LayoutObject object2)
			{
				if (object1.getX() < object2.getX())
					pathwayBuilder.createArc(object1, object2);
				else
					pathwayBuilder.createArc(object2, object1);
			}
			
		@Override
		public void removeArc(PathwayElement upstreamElement, PathwayElement element)
			{
				pathwayBuilder.removeArc(upstreamElement, element);
			}
			
		@Override
		public synchronized void addToView(Pathway pathway)
			{
				pathwayBuilder.addPathway(pathway);
				currentPathway = pathway;
				pathways.add(pathway);
				pathwaysView.getViewLayout().getScale().reset();
				pathwaysView.update();
				updateDataSourceLocation(pathway);
				if (elementEditor != null)
					elementEditor.load(pathway, pathway.isReadonly());
				fireDataViewChanged(new DataViewChange(this));
			}
			
		private void updateDataSourceLocation(EffectopediaObject eo)
			{
				DataSource ds = eo.getDataSource();
				if (ds instanceof RevisionBasedDS)
					((RevisionBasedDS) ds).setLocation(eo);
			}
			
		public LayoutObject addToView(PathwayElement pathwayElement)
			{
				LayoutObject lo = pathwayBuilder.addPathwayElement(pathwayElement);
				pathwaysView.update();
				fireDataViewChanged(new DataViewChange(this));
				return lo;
			}
			
		public LayoutObject addToView(PathwayElement pathwayElement, int neighboursDepth)
			{
				LayoutObject lo = pathwayBuilder.addPathwayElement(pathwayElement, neighboursDepth);
				pathwaysView.update();
				fireDataViewChanged(new DataViewChange(this));
				return lo;
			}
			
		public void buildPath(LayoutObjectSelection selection, LayoutObject upstreamElement, LayoutObject downstreamElement, Pathway pathway, boolean above)
			{
				pathwayBuilder.buildPath(selection, upstreamElement, downstreamElement, pathway, above);
				pathways.add(pathway);
			}
			
		@Override
		public void addToView(SearchResults searchResults)
			{
				pathwayBuilder.addSearchResults(searchResults);
			}
			
		public void removeFromView(LayoutObjectSelection selection)
			{
				pathwayBuilder.removePathwayElements(selection);
			}
			
		public void removeFromView(PathwayElement element)
			{
				pathwayBuilder.removePathwayElement(element);
			}
			
		public void deleteGenericSelection(LayoutObjectSelection selection, boolean unlink)
			{
				pathwayBuilder.deletePathwayElements(selection, true, unlink, true);
			}
			
		public void deleteSelection(LayoutObjectSelection selection, boolean unlink)
			{
				pathwayBuilder.deletePathwayElements(selection, true, unlink, false);
			}
			
		public Map<PathwayElement, LayoutObject> getLayoutObjectsMap()
			{
				return pathwayBuilder.getViewElements();
			}
			
		@Override
		public boolean isVisible(PathwayElement element)
			{
				return pathwayBuilder.isVisible(element);
			}
			
		public PathwaysView getPathwaysView()
			{
				return pathwaysView;
			}
			
		public HashMap<PathwayElement, PathwayElementGO> getFragments()
			{
				return fragments;
			}
			
		public ObjectInspectorUI getObjectInspector()
			{
				return objectInspector;
			}
			
		public void setObjectInspector(ObjectInspectorUI objectInspector)
			{
				this.objectInspector = objectInspector;
			}
			
		public BasicLayout getViewLayout()
			{
				return pathwaysView.getViewLayout();
			}
			
		/**
		 * Loads single <code>pathwayElementGO</code> and it's corresponding
		 * <code> EffectopediaObject</code> in the <code>ObjectInstepctorUI</code>
		 */
		public void loadInObjectInspector(PathwayElementGO pathwayElement, BaseIO io)
			{
				if (objectInspector != null)
					{
						Effectopedia.EFFECTOPEDIA.getData().setShallowMode(false);
						EffectopediaObject effectopediaObject = pathwayElement.getO();
						BaseIOElement effectopediaObjectElement = io.newElement("object_properties");
						effectopediaObject.store(effectopediaObjectElement, io);
						BaseIOElement graphicObjectElement = io.newElement("visual_properties");
						pathwayElement.store(graphicObjectElement, io);
						objectInspector.load(effectopediaObjectElement, io);
					}
			}
			
		@Override
		public void setViewHeightAndWidth(int viewWidth, int viewHeight)
			{
				this.viewWidth = viewWidth;
				this.viewHeight = viewHeight;
				pathwaysView.setAvailableSpace(viewWidth, viewHeight);
			}
			
		public void setShowTestMethods(boolean selected)
			{
				pathwayBuilder.setShowTestMethods(selected);
			}

		public void setHideEmptySegments(boolean hideEmptySegments)
			{
				DefaultGOSettings.setHideEmptySegments(hideEmptySegments);
				pathwaysView.updateStandardSizes();	
			}
			
		@Override
		public void layoutUpdated(EventObject evt)
			{
				fireDataViewChanged(new DataViewChange(this));
			}
			
		public ElementEditorUI getElementEditor()
			{
				return elementEditor;
			}
			
		public void setElementEditor(ElementEditorUI elementEditor)
			{
				this.elementEditor = elementEditor;
			}
			
		/**
		 * Associated elementEditor of this of this <code>DataView</code>
		 */
		protected ElementEditorUI																									elementEditor;
		/**
		 * Associated object inspector allowing the data editing of this of this
		 * <code>DataView</code>
		 */
		protected ObjectInspectorUI																							objectInspector;
		
		/**
		 * Helper instance of <code>contextSpaceBuilder</code> used to build
		 * <code>PathwaysView</code> layout (number of segments on each axis) based on
		 * the selected <code>ContextDimesnion</code>s
		 * 
		 * @see ContextDimension
		 */
		protected ContextSpaceBuilder																					contextSpaceBuilder;
		/**
		 * Helper instance of <code>PathwayVisualisationBuilder</code> used to build
		 * visual elements contained <code>PathwaysView</code> from Effectopedia
		 * objects (<code>Pathway</code>s, <code>PathwayElement</code>s)
		 */
		protected PathwayVisualisationBuilder													pathwayBuilder;
		/**
		 * <code>pathwaysView</code> Contain all currently visible objects from this
		 * SourceView
		 * 
		 * @see PathwaysView
		 */
		private PathwaysView																														pathwaysView;
		/**
		 * <code>pathways</code> Contain currently visible one or more pathways
		 * available in the current {@link org.qsari.effectopedia.data.DataSource}
		 * 
		 * @see Pathways
		 */
		private HashMap<PathwayElement, PathwayElementGO>	fragments;
	}

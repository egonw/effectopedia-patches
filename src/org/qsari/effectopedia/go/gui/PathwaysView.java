package org.qsari.effectopedia.go.gui;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.go.StandardFixedGOSize;
import org.qsari.effectopedia.go.StandardGOSize;
import org.qsari.effectopedia.go.Layout.BasicLayout;
import org.qsari.effectopedia.go.Layout.GlobalLayoutContainer.LayoutChangeListener;
import org.qsari.effectopedia.go.Layout.HeterogeneousLayout;
import org.qsari.effectopedia.go.Layout.LayoutOCSynchronizer;
import org.qsari.effectopedia.go.Layout.LayoutObject;
import org.qsari.effectopedia.go.Layout.LayoutObjectsContainer;
import org.qsari.effectopedia.go.Layout.ZoomLayout;
import org.qsari.effectopedia.go.pathway_elements.EffectEGOC;
import org.qsari.effectopedia.go.pathway_elements.LinkEGOC;
import org.qsari.effectopedia.go.pathway_elements.LinkPEGO;
import org.qsari.effectopedia.go.pathway_elements.SubstanceEGOC;
import org.qsari.effectopedia.go.pathway_elements.TestResponseMappingPEGO;

public class PathwaysView
	{
		public PathwaysView()
			{
				super();
				this.viewLayout = new ZoomLayout();
				updateStandardSizes();
			}

		public void updateStandardSizes()
			{
				StandardGOSize fixedSize = new StandardFixedGOSize(DefaultGOSettings.linkIconRadius, DefaultGOSettings.linkIconRadius, DefaultGOSettings.defaultFixedGap, DefaultGOSettings.defaultFixedGap);
				((HeterogeneousLayout) this.viewLayout).fixGraphicObject(LinkPEGO.class, fixedSize);
				if (DefaultGOSettings.isHideEmptySegments())
			 	((HeterogeneousLayout) this.viewLayout).fixGraphicObject(LinkEGOC.class, new StandardFixedGOSize(0, 0, StandardGOSize.ZERO_INSET, StandardGOSize.ZERO_GAP));
				else
					((HeterogeneousLayout) this.viewLayout).fixGraphicObject(LinkEGOC.class, fixedSize);
				EffectEGOC.defaultEffectEGOCUnscalledSize = new StandardGOSize(DefaultGOSettings.hVisWeigthEffectContainer, DefaultGOSettings.vVisWeigthEffectContainer,StandardGOSize.ZERO_INSET,StandardGOSize.ZERO_GAP);
				SubstanceEGOC.defaultSubstanceEGOCUnscalledSize = new StandardGOSize(DefaultGOSettings.hVisWeigthSubstanceContainer, DefaultGOSettings.vVisWeigthSubstanceContainer,StandardGOSize.ZERO_INSET,StandardGOSize.ZERO_GAP);
				fixedSize = new StandardFixedGOSize(DefaultGOSettings.mappingIconWidth, DefaultGOSettings.mappingIconHeight, DefaultGOSettings.defaultFixedGap, DefaultGOSettings.defaultFixedGap);
				((HeterogeneousLayout) this.viewLayout).fixGraphicObject(TestResponseMappingPEGO.class, fixedSize);
			}
			
		public int getWidth()
			{
				return viewLayout.getWidth();
			}
			
		public int getHeight()
			{
				return viewLayout.getHeight();
			}
			
		public void draw(Graphics2D canvas)
			{
				canvas.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				viewLayout.draw(canvas);
			}
			
		public void setUserInterfaceGOCs(LayoutObjectsContainer columnFooters, LayoutObjectsContainer rowHeaders, Container container)
			{
				this.columnFooters = columnFooters;
				this.rowHeaders = rowHeaders;
				synchronizer = new LayoutOCSynchronizer(viewLayout.getGlobalLOC(), container);
				synchronizer.bondToMasterHorizontally(this.columnFooters);
				synchronizer.bondToMasterVertically(this.rowHeaders);
			}
			
		public void zoom()
			{
				viewLayout.zoom();
				update();
			}
			
		public void update()
			{
				viewLayout.update();
				if (synchronizer != null)
					synchronizer.synchronize();
			}
			
		public BasicLayout getViewLayout()
			{
				return viewLayout;
			}
			
		public LayoutObjectsContainer getColumnFooters()
			{
				return columnFooters;
			}
			
		public LayoutObjectsContainer getRowHeaders()
			{
				return rowHeaders;
			}
			
		public LayoutOCSynchronizer getSynchronizer()
			{
				return synchronizer;
			}
			
		public void setSelected(boolean selected)
			{
				viewLayout.getGlobalGOC().setSelected(selected);
			}
			
		public void setSelected(int top, int left, int width, int height)
			{
				viewLayout.getGlobalGOC().setSelected(top, left, width, height);
			}
			
		public void setAvailableSpace(int availableWidth, int availableHeight)
			{
				viewLayout.getGlobalLOC().setAvailableSpace(availableWidth, availableHeight);
				synchronizer.synchronize();
				columnFooters.setAvailableSpace(availableWidth, DefaultGOSettings.footerHeight);
				rowHeaders.setAvailableSpace(DefaultGOSettings.rowHeaderWidth, availableHeight);
			}
			
		public void zoomFocusLO(boolean zoomIn, LayoutObject focusLO)
			{
				if (viewLayout instanceof ZoomLayout)
					{
						((ZoomLayout) viewLayout).zoomFocusLO(zoomIn, focusLO);
						synchronizer.synchronize();
					}
			}
			
		public void zoom(boolean zoomIn)
			{
				viewLayout.zoom(zoomIn);
				synchronizer.synchronize();
			}
			
		public void reset()
			{
				viewLayout.getScale().reset();
				synchronizer.synchronize();
			}
			
		public void addLayoutChangeListener(LayoutChangeListener listener)
			{
				viewLayout.addLayoutChangeListener(listener);
			}
			
		public void removeLayoutChangeListener(LayoutChangeListener listener)
			{
				viewLayout.removeLayoutChangeListener(listener);
			}
			
		public void deleteSelected()
			{
				// TODO Auto-generated method stub
				
			}
			
		public void synchronizeActiveRegions(boolean showActive)
			{
				LayoutObjectsContainer last = viewLayout.getGlobalLOC().getLastContainer();
				if (last != null)
					synchronizer.updateActiveRegion(last.getxIndex(), last.getyIndex(), false);
				LayoutObjectsContainer current = viewLayout.getGlobalLOC().getCurrentContainer();
				if (current != null)
					synchronizer.updateActiveRegion(current.getxIndex(), current.getyIndex(), showActive);
			}
			
		protected BasicLayout												viewLayout;
		protected LayoutObjectsContainer	columnFooters;
		protected LayoutObjectsContainer	rowHeaders;
		protected LayoutOCSynchronizer			synchronizer;
		
	}

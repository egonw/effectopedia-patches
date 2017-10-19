package org.qsari.effectopedia.go.Layout;

/**
 * @version 1.0 @(#)BasicLayout.java 1.0
 * @author Hristo Aladjov
 * 
 */

public class ZoomLayout extends HeterogeneousLayout
	{
		public ZoomLayout()
			{
				super();
				focusLOScale = new Scale();
				focusLOScale.setZoomStep(16);
			}

		public void zoomFocusLO(boolean zoomIn, LayoutObject focusLO)
			{
				if (focusLayoutObject!=focusLO)
					{
						if (focusLayoutObject!=null)
							focusLayoutObject.setScale(scale);
						focusLOScale.setLevel(scale.getLevel());
					}
				focusLayoutObject = focusLO;
				focusLOScale.zoom(zoomIn);
				if (focusLayoutObject != null)
					if (focusLayoutObject instanceof LayoutObjectsContainer)
						((LayoutObjectsContainer) focusLayoutObject).rescale(focusLOScale);
					else
						focusLayoutObject.setScale(focusLOScale);
				update();
			}
		
		public void zoom(boolean zoomIn)
			{
				scale.zoom(zoomIn);
				globalLOC.rescale(scale);
				if (focusLayoutObject != null)
					if (focusLayoutObject instanceof LayoutObjectsContainer)
						((LayoutObjectsContainer) focusLayoutObject).rescale(focusLOScale);
					else
						focusLayoutObject.setScale(focusLOScale);
				update();
			}
		
		public LayoutObject getFocus()
			{
				return focusLayoutObject;
			}
		
		public void setFocus(LayoutObject focus)
			{
				this.focusLayoutObject = focus;
			}
		
		protected Scale								focusLOScale;
		protected LayoutObject	focusLayoutObject	= null;
	}

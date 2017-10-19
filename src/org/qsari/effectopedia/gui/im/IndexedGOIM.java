package org.qsari.effectopedia.gui.im;

import org.qsari.effectopedia.gui.PathwaysViewUI;

public abstract class IndexedGOIM extends InterfaceMode
	{
		public static int	COMATIBLE				= 1;
		public static int	INCOMPATIBLE	= 2;
		
		public IndexedGOIM(PathwaysViewUI pathwayUI, InterfaceModes owner)
			{
				super(pathwayUI, owner);
				this.alternativeModeType = DRAG;
				currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_SUBSTANCE_CYCLE, PathwayElementTypeCycler.STANDARD_SEQUENCE);
			}
			
		protected void determineState()
			{
				int state = (currentContainer != null) ? ((currentContainer.isCompatible(currentElement.getCurrent().getClass())) ? 0 : 1) : 0;
				setState(state + 1);
			}
			
		protected void reset()
			{
				viewLayout.setSimpleActiveRegion(false);
				viewLayout.setShowActiveRegion(true);
				pathwaysView.getViewLayout().setArcsSelectable(false);
			}
			
		@Override
		public String getContext()
			{
				if (state == COMATIBLE)
					if (getCurrentActivePathwayElement() != null)
						return "-modify_existing";
					else
						return "-place_new";
				else
					return "-incompatible_segment";
			}
	}

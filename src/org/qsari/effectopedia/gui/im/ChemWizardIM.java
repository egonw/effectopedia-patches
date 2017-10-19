package org.qsari.effectopedia.gui.im;

import java.awt.Cursor;

import org.qsari.effectopedia.core.objects.Initiator;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.go.Layout.LayoutObject;
import org.qsari.effectopedia.go.pathway_elements.PathwayElementGO;
import org.qsari.effectopedia.gui.PathwaysViewUI;
import org.qsari.effectopedia.gui.UIResources;

public class ChemWizardIM extends WizardIM
	{
		public ChemWizardIM(PathwaysViewUI pathwayUI, InterfaceModes owner)
			{
				super(pathwayUI, owner);
				this.alternativeModeType = DRAG;
				setCursors(make5StateCursors(Cursor.getDefaultCursor(), UIResources.chemicalCursor, UIResources.linkCursor, UIResources.effectCursor, UIResources.testCursor));
				currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_SUBSTANCE_CYCLE, PathwayElementTypeCycler.STANDARD_SEQUENCE);
				currentElement.setElementIndex(1);
				viewLayout.setSimpleActiveRegion(false);
				viewLayout.setShowActiveRegion(true);
				pathwaysView.getViewLayout().setArcsSelectable(false);
			}
		
		protected void setElement(boolean existing)
			{
				selection.select(currentLO);
				if (lastElement == currentLO)
					return;
				if (((PathwayElementGO) currentLO.getGo()).getO() instanceof Initiator)
					{
						element1 = currentLO;
						existingElement1 = existing;
					}
				else
					{
						if ((element2 != null) && (!existingElement2))
							{
								selection.unselect(viewLayout);
								remove(element2);
							}
						element2 = currentLO;
						existingElement2 = existing;
						currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_SUBSTANCE_CYCLE, PathwayElementTypeCycler.FIXED_CYCLE);
					}
				lastElement = currentLO;
			}
		
		private boolean isSubstanceMode()
			{
				boolean substanceMode = (currentContainer.getxIndex() == 0) && (element1 == null);
				if (currentO != null)
					return (currentO instanceof Initiator);
				return substanceMode;
			}
		
		protected void determineState()
			{
				int state = -1;
				if (currentContainer != null)
					if (isSubstanceMode())
						{
							currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_SUBSTANCE_CYCLE, PathwayElementTypeCycler.FIXED_CYCLE);
							state = 0;
						}
					else
						{
							currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_EFFECT_CYCLE, PathwayElementTypeCycler.FIXED_CYCLE);
							currentElement.setElementIndex(2);
							state = 2 + ((currentContainer.isCompatible(currentElement.getCurrent().getClass())) ? 0 : 1);
						}
				setState(state + 1);
			}
		
		protected void reset()
			{
				currentElement.setSequenceIndex(PathwayElementTypeCycler.SEQUENCE_SUBSTANCE_CYCLE, PathwayElementTypeCycler.FIXED_CYCLE);
				element1 = null;
				element2 = null;
				viewLayout.setSimpleActiveRegion(false);
				viewLayout.setShowActiveRegion(true);
				pathwaysView.getViewLayout().setArcsSelectable(false);
			}
		
		public void setCurrentLO(LayoutObject currentLO)
			{
				this.currentO = null;
				this.currentLO = currentLO;
				if (currentLO == null)
					this.currentGO = null;
				else if (viewLayout.getActiveRegion().isOverGO())
					{
						this.currentGO = currentLO.getGo();
						this.currentO = ((PathwayElementGO) currentGO).getO();
					}
				else
					this.currentGO = null;
			}

		private PathwayElement	currentO	= null;
	}

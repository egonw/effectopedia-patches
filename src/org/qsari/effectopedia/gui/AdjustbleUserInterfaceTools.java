package org.qsari.effectopedia.gui;

import java.awt.Component;
import java.awt.Container;

/**
 * @version 1.0 @(#)AdjustbleUserInterfaceTools.java 1.0
 * @author Hristo Aladjov
 * 
 */

public class AdjustbleUserInterfaceTools

	{
		
		/**
		 * Adjust all children of <code>thisContainer</code> container.
		 * 
		 * @param thisContainer
		 *         the container
		 * @param visualOptions
		 *         an long that specifies which of the contained components are
		 *         visible
		 */
		
		static public void adjustChildren(Container thisContainer, long visualOptions)
			{
				for (Component childComponent : thisContainer.getComponents())
					{
						if (childComponent instanceof AdjustableUI)
							{
								((AdjustableUI) childComponent).adjustUI(visualOptions);
							}
						else if ((childComponent instanceof Container) && (((Container) childComponent).getComponentCount() > 0))
							{
								adjustChildren((Container) childComponent, visualOptions);
							}
					}
			}
		
	}

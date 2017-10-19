package org.qsari.effectopedia.gui.util;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ScrollPaneSynchronizer implements AdjustmentListener
	{
		JScrollBar	vA, hA, vB, hB;
		
		public ScrollPaneSynchronizer(JScrollPane spA, JScrollPane spB)
			{
				vA = spA.getVerticalScrollBar();
				hA = spA.getHorizontalScrollBar();
				vB = spB.getVerticalScrollBar();
				hB = spB.getHorizontalScrollBar();
			}
		
		public void adjustmentValueChanged(AdjustmentEvent e)
			{
				JScrollBar scrollBar = (JScrollBar) e.getSource();
				int value = scrollBar.getValue();
				JScrollBar target = null;
				
				if (scrollBar == vA)
					target = vB;
				if (scrollBar == hA)
					target = hB;
				if (scrollBar == vB)
					target = vA;
				if (scrollBar == hB)
					target = hA;
				
				target.setValue(value);
			}
	}
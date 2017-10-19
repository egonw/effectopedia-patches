package org.qsari.effectopedia.gui.comp;

import java.awt.Point;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.JViewport;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicScrollPaneUI;

public class ExtendedScrollPaneUI extends BasicScrollPaneUI implements ExtendedScrollPaneConstants
	{
		/**
		 * PropertyChangeListener installed on the vertical scrollbar.
		 */
		private PropertyChangeListener	vsbPropertyChangeListener;
		
		/**
		 * PropertyChangeListener installed on the horizontal scrollbar.
		 */
		private PropertyChangeListener	hsbPropertyChangeListener;
		
		public static ComponentUI createUI(JComponent x)
			{
				return new ExtendedScrollPaneUI();
			}
		
		protected void syncScrollPaneWithViewport()
			{
				super.syncScrollPaneWithViewport();
				JViewport viewport = scrollpane.getViewport();
				JViewport rowFoot = ((ExtendedScrollPane) scrollpane).getRowFooter();
				JViewport colFoot = ((ExtendedScrollPane) scrollpane).getColumnFooter();
				boolean ltr = scrollpane.getComponentOrientation().isLeftToRight();
				
				if (rowFoot != null)
					{
						Point p = rowFoot.getViewPosition();
						p.y = viewport.getViewPosition().y;
						p.x = 0;
						rowFoot.setViewPosition(p);
					}
				
				if (colFoot != null)
					{
						Point p = colFoot.getViewPosition();
						if (ltr)
							{
								p.x = viewport.getViewPosition().x;
							}
						else
							{
								p.x = Math.max(0, viewport.getViewPosition().x);
							}
						p.y = 0;
						colFoot.setViewPosition(p);
					}
			}
		
		protected void updateColumnFooter(PropertyChangeEvent e)
			{
				JViewport newColFoot = (JViewport) (e.getNewValue());
				if (newColFoot != null)
					{
						JViewport viewport = scrollpane.getViewport();
						Point p = newColFoot.getViewPosition();
						if (viewport == null)
							{
								p.x = 0;
							}
						else
							{
								if (scrollpane.getComponentOrientation().isLeftToRight())
									{
										p.x = viewport.getViewPosition().x;
									}
								else
									{
										p.x = Math.max(0, viewport.getViewPosition().x);
									}
							}
						newColFoot.setViewPosition(p);
						scrollpane.add(newColFoot, COLUMN_FOOTER);
					}
			}
		
		protected void updateRowFooter(PropertyChangeEvent e)
			{
				JViewport newRowFoot = (JViewport) (e.getNewValue());
				if (newRowFoot != null)
					{
						JViewport viewport = scrollpane.getViewport();
						Point p = newRowFoot.getViewPosition();
						p.y = (viewport != null) ? viewport.getViewPosition().y : 0;
						newRowFoot.setViewPosition(p);
					}
			}
		
		private void updateHorizontalScrollBar(PropertyChangeEvent pce)
			{
				updateScrollBar(pce, hsbChangeListener, hsbPropertyChangeListener);
			}
		
		private void updateVerticalScrollBar(PropertyChangeEvent pce)
			{
				updateScrollBar(pce, vsbChangeListener, vsbPropertyChangeListener);
			}
		
		private void updateScrollBar(PropertyChangeEvent pce, ChangeListener cl, PropertyChangeListener pcl)
			{
				JScrollBar sb = (JScrollBar) pce.getOldValue();
				if (sb != null)
					{
						if (cl != null)
							{
								sb.getModel().removeChangeListener(cl);
							}
						if (pcl != null)
							{
								sb.removePropertyChangeListener(pcl);
							}
					}
				sb = (JScrollBar) pce.getNewValue();
				if (sb != null)
					{
						if (cl != null)
							{
								sb.getModel().addChangeListener(cl);
							}
						if (pcl != null)
							{
								sb.addPropertyChangeListener(pcl);
							}
					}
			}
		
		protected void scrollPanePropertyChange(PropertyChangeEvent e)
			{
				String propertyName = e.getPropertyName();
				
				if (propertyName == "verticalScrollBarDisplayPolicy")
					{
						updateScrollBarDisplayPolicy(e);
					}
				else if (propertyName == "horizontalScrollBarDisplayPolicy")
					{
						updateScrollBarDisplayPolicy(e);
					}
				else if (propertyName == "viewport")
					{
						updateViewport(e);
					}
				else if (propertyName == "rowHeader")
					{
						updateRowHeader(e);
					}
				else if (propertyName == "columnHeader")
					{
						updateColumnHeader(e);
					}
				else if (propertyName == "rowFooter")
					{
						updateRowFooter(e);
					}
				else if (propertyName == "columnFooter")
					{
						updateColumnFooter(e);
					}
				else if (propertyName == "verticalScrollBar")
					{
						updateVerticalScrollBar(e);
					}
				else if (propertyName == "horizontalScrollBar")
					{
						updateHorizontalScrollBar(e);
					}
				else if (propertyName == "componentOrientation")
					{
						scrollpane.revalidate();
						scrollpane.repaint();
					}
			}
		
	}

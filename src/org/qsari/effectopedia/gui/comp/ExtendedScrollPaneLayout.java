package org.qsari.effectopedia.gui.comp;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ScrollPaneLayout;
import javax.swing.ViewportLayout;

/**
 * 
 * @version 1.0 @(#)PathwaySpaceLayout.java 1.0
 * @author Hans Muller adopted by Hristo Aladjov
 */

public class ExtendedScrollPaneLayout extends ScrollPaneLayout implements ExtendedScrollPaneConstants
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		/**
		 * The col footer child. Default is <code>null</code>.
		 * 
		 * @see JScrollPane#setColFooter
		 */
		protected JViewport							colFoot;
		/**
		 * The row footer child. Default is <code>null</code>.
		 * 
		 * @see JScrollPane#setRowFooter
		 */
		protected JViewport							rowFoot;
		
		/**
		 * This method is invoked after the PathwaySpaceLayout is set as the
		 * LayoutManager of a <code>PathwaySpaceScrollPane</code>.
		 */
		public void syncWithScrollPane(ExtendedScrollPane sp)
			{
				super.syncWithScrollPane(sp);
				colFoot = sp.getColumnFooter();
				rowFoot = sp.getRowFooter();
			}
		
		/**
		 * Adds the specified component to the layout. The layout is identified using
		 * one of the <code>ScrollPaneLayout</code> plus additional:
		 * <ul>
		 * <li>ScrollPaneConstants.ROW_FOOTER
		 * <li>ScrollPaneConstants.COLUMN_FOOTER
		 * </ul>
		 * 
		 * @param s
		 *         the component identifier
		 * @param c
		 *         the the component to be added
		 * @exception IllegalArgumentException
		 *             if <code>s</code> is an invalid key
		 */
		
		public void addLayoutComponent(String s, Component c)
			{
				if (s.equals(COLUMN_FOOTER))
					{
						colFoot = (JViewport) addSingletonComponent(colFoot, c);
					}
				else if (s.equals(ROW_FOOTER))
					{
						lowerLeft = addSingletonComponent(rowFoot, c);
					}
				else
					super.addLayoutComponent(s, c);
			}
		
		/**
		 * Removes the specified component from the layout.
		 * 
		 * @param c
		 *         the component to remove
		 */
		public void removeLayoutComponent(Component c)
			{
				if (c == rowFoot)
					{
						rowFoot = null;
					}
				else if (c == colFoot)
					{
						colFoot = null;
					}
				else
					super.removeLayoutComponent(c);
			}
		
		/**
		 * Returns the <code>JViewport</code> object that is the row header.
		 * 
		 * @return the <code>JViewport</code> object that is the row header
		 * @see ExtendedScrollPane#getRowFooter
		 */
		public JViewport getRowFooter()
			{
				return rowFoot;
			}
		
		/**
		 * Returns the <code>JViewport</code> object that is the row header.
		 * 
		 * @return the <code>JViewport</code> object that is the row header
		 * @see ExtendedScrollPane#getColumnFooter()
		 */
		public JViewport getColFooter()
			{
				return colFoot;
			}
		
		/**
		 * The preferred size of a <code>PathwaySpaceScrollPane</code> is the size of
		 * the insets, plus the preferred size of the viewport, plus the preferred
		 * size of the visible headers and footers, plus the preferred size of the
		 * scrollbars that will appear given the current view and the current
		 * scrollbar displayPolicies.
		 * <p>
		 * Note that the rowHeader,rowFooter is calculated as part of the preferred
		 * width and the colHeader,colHeader is calculated as part of the preferred
		 * size.
		 * 
		 * @param parent
		 *         the <code>Container</code> that will be laid out
		 * @return a <code>Dimension</code> object specifying the preferred size of
		 *         the viewport and any scrollbars
		 * @see ViewportLayout
		 * @see LayoutManager
		 */
		public Dimension preferredLayoutSize(Container parent)
			{
				Dimension preffered = super.preferredLayoutSize(parent);
				int prefWidth = preffered.width;
				int prefHeight = preffered.height;
				
				/* If a footer exists and it's visible, factor its preferred size in. */

				if ((rowFoot != null) && rowFoot.isVisible())
					{
						prefWidth += rowFoot.getPreferredSize().width;
					}
				
				if ((colFoot != null) && colFoot.isVisible())
					{
						prefHeight += colFoot.getPreferredSize().height;
					}
				return new Dimension(prefWidth, prefHeight);
			}
		
		/**
		 * The minimum size of a <code>PathwaySpaceScrollPane</code> is the size of
		 * the insets plus minimum size of the viewport, plus the scrollpane's
		 * viewportBorder insets, plus the minimum size of the visible headers and
		 * footers, plus the minimum size of the scrollbars whose displayPolicy isn't
		 * NEVER.
		 * 
		 * @param parent
		 *         the <code>Container</code> that will be laid out
		 * @return a <code>Dimension</code> object specifying the minimum size
		 */
		public Dimension minimumLayoutSize(Container parent)
			{
				Dimension minimum = super.minimumLayoutSize(parent);
				int minWidth = minimum.width;
				int minHeight = minimum.height;
				
				/* If a footer exists and it's visible, factor its minimum size in. */

				if ((rowFoot != null) && rowFoot.isVisible())
					{
						Dimension size = rowFoot.getMinimumSize();
						minWidth += size.width;
						minHeight = Math.max(minHeight, size.height);
					}
				
				if ((colFoot != null) && colFoot.isVisible())
					{
						Dimension size = colFoot.getMinimumSize();
						minWidth = Math.max(minWidth, size.width);
						minHeight += size.height;
					}
				return new Dimension(minWidth, minHeight);
			}
		
		/**
		 * Lays out the PathwaySpaceScrollPane. The positioning of components depends
		 * on the following constraints:
		 * <ul>
		 * <li>The row header, if present and visible, gets its preferred width and
		 * the viewport's height.
		 * 
		 * <li>The row footer, if present and visible, gets its preferred width and
		 * the viewport's height.
		 * 
		 * <li>The column header, if present and visible, gets its preferred height
		 * and the viewport's width.
		 * 
		 * <li>The column footer, if present and visible, gets its preferred height
		 * and the viewport's width.
		 * 
		 * <li>If a vertical scrollbar is needed, i.e. if the viewport's extent height
		 * is smaller than its view height or if the <code>displayPolicy</code> is
		 * ALWAYS, it's treated like the row header with respect to its dimensions and
		 * is made visible.
		 * 
		 * <li>If a horizontal scrollbar is needed, it is treated like the column
		 * header (see the paragraph above regarding the vertical scrollbar).
		 * 
		 * <li>If the scrollpane has a non-<code>null</code>
		 * <code>viewportBorder</code>, then space is allocated for that.
		 * 
		 * <li>The viewport gets the space available after accounting for the previous
		 * constraints.
		 * 
		 * <li>The corner components, if provided, are aligned with the ends of the
		 * scrollbars and headers. If there is a vertical scrollbar, the right corners
		 * appear; if there is a horizontal scrollbar, the lower corners appear; a row
		 * header gets left corners, and a column header gets upper corners.
		 * </ul>
		 * 
		 * @param parent
		 *         the <code>Container</code> to lay out
		 */
		public void layoutContainer(Container parent)
			{
				super.layoutContainer(parent);
				
				/*
				 * If there's a visible column footer remove the space it needs from the
				 * bottom of the viewport.
				 */

				Rectangle hsbR = hsb.getBounds();
				Rectangle vsbR = vsb.getBounds();
				Dimension viewD = viewport.getExtentSize();
				
				Rectangle colFootR = new Rectangle(hsbR);
				
				if ((colFoot != null) && (colFoot.isVisible()))
					{
						int colFootHeight = colFoot.getPreferredSize().height;
						viewD.height -= colFootHeight;
						colFootR.y -= colFootHeight;
						colFoot.setBounds(colFootR);
						vsbR.height -= colFootHeight;
						hsbR.width += vsbR.width;
					}
				
				/*
				 * If there's a visible row footer remove the space it needs from the right
				 * of the viewport.
				 */

				Rectangle rowFootR = new Rectangle(vsbR);
				
				if ((rowFoot != null) && (rowFoot.isVisible()))
					{
						int rowFootWidth = colFoot.getPreferredSize().height;
						viewD.width -= rowFootWidth;
						rowFootR.x -= rowFootWidth + vsbR.width;
						rowFoot.setBounds(rowFootR);
						hsbR.width -= rowFootWidth;
						vsbR.height += hsbR.height;
					}
				
				viewport.setExtentSize(viewD);
				vsb.setBounds(vsbR);
				hsb.setBounds(hsbR);
			}
		
		public static class UIResource extends ExtendedScrollPaneLayout implements javax.swing.plaf.UIResource
			{
				
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
			}
	}

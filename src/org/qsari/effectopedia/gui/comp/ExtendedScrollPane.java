package org.qsari.effectopedia.gui.comp;

import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ScrollPaneLayout;
import javax.swing.UIManager;

/**
 * Extends <code>JScrollPane</code> to provide two optional components row and
 * column footer viewports.
 * 
 * @see JScrollPane
 * @see ExtendedScrollPaneLayout
 * @see #setRowFooterView
 * @see #setColumnFooterView
 * 
 * @version 1.0 @(#)PathwaySpaceScrollPane.java 1.0
 * @author Hans Muller adopted by Hristo Aladjov
 */

public class ExtendedScrollPane extends JScrollPane implements ExtendedScrollPaneConstants
	{
		
		/**
		* 
		*/
		private static final long	serialVersionUID	= 1L;
		
		/**
		 * The column footer child. Default is <code>null</code>.
		 * 
		 * @see #setColumnFooter
		 */
		protected JViewport							columnFooter;
		
		/**
		 * The row footer child. Default is <code>null</code>.
		 * 
		 * @see #setColumnFooter
		 */
		protected JViewport							rowFooter;
		
		public Rectangle getViewportBorderBounds()
			{
				Rectangle borderR = new Rectangle(super.getViewportBorderBounds());
				
				/*
				 * If there's a visible column footer remove the space it needs from the
				 * bottom of borderR.
				 */
				
				JViewport colFoot = getColumnFooter();
				if ((colFoot != null) && (colFoot.isVisible()))
					{
						int colHeadHeight = colFoot.getHeight();
						borderR.height -= colHeadHeight;
					}
					
				/*
				 * If there's a visible row header footer the space it needs from the right
				 * of borderR.
				 */
				
				JViewport rowFoot = getRowFooter();
				if ((rowFoot != null) && (rowFoot.isVisible()))
					{
						int rowHeadWidth = rowFoot.getWidth();
						borderR.width -= rowHeadWidth;
					}
					
				return borderR;
			}
			
		/**
		 * Returns the column header.
		 * 
		 * @return the <code>columnFooter</code> property
		 * @see #setColumnFooter
		 */
		public JViewport getColumnFooter()
			{
				return columnFooter;
			}
			
		/**
		 * Removes the old columnFooter, if it exists; if the new columnFooter isn't
		 * <code>null</code>, syncs the x coordinate of its viewPosition with the
		 * viewport (if there is one) and then adds it to the scroll pane.
		 * <p>
		 * Most applications will find it more convenient to use
		 * <code>setColumnHeaderView</code> to add a column header component and its
		 * viewport to the scroll pane.
		 * 
		 * @see #getColumnFooter
		 * @see #setColumnFooterView
		 * 
		 */
		public void setColumnFooter(JViewport columnFooter)
			{
				JViewport old = getColumnFooter();
				this.columnFooter = columnFooter;
				if (columnFooter != null)
					{
						add(columnFooter, COLUMN_FOOTER);
					}
				else if (old != null)
					{
						remove(old);
					}
				firePropertyChange("columnFooter", old, columnFooter);
				
				revalidate();
				repaint();
			}
			
		/**
		 * Returns the column header.
		 * 
		 * @return the <code>rowFooter</code> property
		 * @see #setRowFooter
		 */
		public JViewport getRowFooter()
			{
				return rowFooter;
			}
			
		/**
		 * Removes the old rowFooter, if it exists; if the new rowFooter isn't
		 * <code>null</code>, syncs the y coordinate of its viewPosition with the
		 * viewport (if there is one) and then adds it to the scroll pane.
		 * <p>
		 * Most applications will find it more convenient to use
		 * <code>setRowHeaderView</code> to add a row header component and its
		 * viewport to the scroll pane.
		 * 
		 * @see #getRowFooter
		 * @see #setRowFooterView
		 * 
		 */
		public void setRowFooter(JViewport rowFooter)
			{
				JViewport old = getRowFooter();
				this.rowFooter = rowFooter;
				if (rowFooter != null)
					{
						add(rowFooter, ROW_FOOTER);
					}
				else if (old != null)
					{
						remove(old);
					}
				firePropertyChange("rowFooter", old, rowFooter);
				
				revalidate();
				repaint();
			}
			
		/**
		 * Creates a column-footer viewport if necessary, sets its view, and then adds
		 * the column-footer viewport to the scrollpane.
		 * 
		 * @param view
		 *         the component to display as the column header
		 */
		public void setColumnFooterView(Component view)
			{
				if (getColumnFooter() == null)
					{
						setColumnFooter(createViewport());
					}
				getColumnFooter().setView(view);
			}
			
		/**
		 * Creates a Row-footer viewport if necessary, sets its view, and then adds
		 * the Row-footer viewport to the scrollpane.
		 * 
		 * @param view
		 *         the component to display as the Row header
		 */
		public void setRowFooterView(Component view)
			{
				if (getRowHeader() == null)
					{
						setRowFooter(createViewport());
					}
				getRowFooter().setView(view);
			}
			
		/**
		 * Returns a string representation of this <code>PathwaySpaceScrollPane</code>
		 * . This method is intended to be used only for debugging purposes, and the
		 * content and format of the returned string may vary between implementations.
		 * The returned string may be empty but may not be <code>null</code>.
		 * 
		 * @return a string representation of this <code>JScrollPane</code>.
		 */
		protected String paramString()
			{
				String columnFooterString = (columnFooter != null ? columnFooter.toString() : "");
				String rowFooterString = (rowFooter != null ? rowFooter.toString() : "");
				
				return super.paramString() + ",columnFooter=" + columnFooterString + ",rowFooter=" + rowFooterString;
			}
			
		/**
		 * Creates a <code>ExtendedScrollPane</code> that displays the view component
		 * in a viewport whose view position can be controlled with a pair of
		 * scrollbars. The scrollbar policies specify when the scrollbars are
		 * displayed, For example, if <code>vsbPolicy</code> is
		 * <code>VERTICAL_SCROLLBAR_AS_NEEDED</code> then the vertical scrollbar only
		 * appears if the view doesn't fit vertically. The available policy settings
		 * are listed at {@link #setVerticalScrollBarPolicy} and
		 * {@link #setHorizontalScrollBarPolicy}.
		 * 
		 * @see #setViewportView
		 * 
		 * @param view
		 *         the component to display in the scrollpanes viewport
		 * @param vsbPolicy
		 *         an integer that specifies the vertical scrollbar policy
		 * @param hsbPolicy
		 *         an integer that specifies the horizontal scrollbar policy
		 */
		public ExtendedScrollPane(Component view, int vsbPolicy, int hsbPolicy)
			{
				super(view, vsbPolicy, hsbPolicy);
				defaultUI = (ExtendedScrollPaneUI) ExtendedScrollPaneUI.createUI(this);
				setUI(defaultUI);
				setLayout(new ExtendedScrollPaneLayout.UIResource());
			}
			
		/**
		 * Creates an empty (no viewport view) <code>ExtendedScrollPane</code> where
		 * both horizontal and vertical scrollbars appear when needed.
		 */
		public ExtendedScrollPane()
			{
				this(null, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
				setVerticalScrollBar(new JScrollBar(JScrollBar.VERTICAL)
					{
						@Override
						public void setValues(int newValue, int newExtent, int newMin, int newMax)
							{
								int colFootHeight = getColumnFooter() != null ? columnFooter.getHeight() : 0;
								super.setValues(newValue, newExtent, newMin, newMax - colFootHeight);
							}
					});
			}
			
		/**
		 * Replaces the current <code>ScrollPaneUI</code> object with a version from
		 * the current default look and feel. To be called when the default look and
		 * feel changes.
		 * 
		 * @see JComponent#updateUI
		 * @see UIManager#getUI
		 */
		public void updateUI()
			{
				setUI(defaultUI);
			}
			
		/**
		 * Sets the layout manager for this <code>ExtendedScrollPane</code>. This
		 * method overrides <code>setLayout</code> in <code>JScrollPane</code> to
		 * ensure that only <code>LayoutManager</code>s which are subclasses of
		 * <code>ExtendedScrollPaneLayout</code> can be used in a
		 * <code>JScrollPane</code>. If <code>layout</code> is non-null, this will
		 * invoke <code>syncWithScrollPane</code> on it.
		 * 
		 * @param layout
		 *         the specified layout manager
		 * @exception ClassCastException
		 *             if layout is not a <code>ScrollPaneLayout</code>
		 * @see java.awt.Container#getLayout
		 * @see java.awt.Container#setLayout
		 * 
		 */
		public void setLayout(LayoutManager layout)
			{
				if (layout instanceof ScrollPaneLayout)
					{
						super.setLayout(layout);
						((ScrollPaneLayout) layout).syncWithScrollPane(this);
					}
				else if (layout == null)
					{
						super.setLayout(layout);
					}
				else
					{
						String s = "layout of ExtendedScrollPane must be a ExtendedScrollPaneLayout";
						throw new ClassCastException(s);
					}
			}
			
		private ExtendedScrollPaneUI defaultUI;
	}

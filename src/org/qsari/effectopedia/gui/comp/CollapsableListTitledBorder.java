package org.qsari.effectopedia.gui.comp;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.gui.UIResources;

public class CollapsableListTitledBorder extends TitledBorder implements MouseListener, MouseMotionListener, SwingConstants, ActionListener
	{
		public CollapsableListTitledBorder(JComponent container, Border border)
			{
				super(border);
				setContainer(container);
			}
		
		public CollapsableListTitledBorder(JComponent container, Border border, String title, int titleJustification, int titlePosition, Font titleFont)
			{
				super(border, title, titleJustification, titlePosition, titleFont);
				setContainer(container);
			}
		
		public CollapsableListTitledBorder(JComponent container, Border border, String title, int titleJustification, int titlePosition, Font titleFont, Color titleColor)
			{
				super(border, title, titleJustification, titlePosition, titleFont, titleColor);
				setContainer(container);
			}
		
		public static final CollapsableListTitledBorder createCollapsableListTitledBorder(JComponent container, Border border, String title, int titleJustification, int titlePosition, Font titleFont)
			{
				return new CollapsableListTitledBorder(container, border, title, titleJustification, titlePosition, titleFont);
			}
		
		public static final CollapsableListTitledBorder createCollapsableListTitledBorder(JComponent container, Border border, String title, int titleJustification, int titlePosition, Font titleFont,
				Color titleColor)
			{
				return new CollapsableListTitledBorder(container, border, title, titleJustification, titlePosition, titleFont, titleColor);
			}
		
		public JComponent getContainer()
			{
				return container;
			}
		
		public void setContainer(JComponent container)
			{
				if (expanded)
					jbChangeAll.setAction(collapseAction);
				else
					jbChangeAll.setAction(expandAction);
				jbChangeAll.setRolloverIcon(expanded ? UIResources.imageIconCollapseAllAct : UIResources.imageIconExpandAllAct);
				this.container = container;
				container.addMouseListener(this);
				container.addMouseMotionListener(this);
			}
		
		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
			{
				super.paintBorder(c, g, x, y, width, height);
				if (showButtonAtTopLeft)
					offset = TEXT_SPACING;
				else
					offset = width - buttonW - xEdgeOffset;
				buttonRect = new Rectangle(offset, 0, buttonW, buttonH);
				SwingUtilities.paintComponent(g, jbChangeAll, (Container) c, buttonRect);
			}
		
		public class TitleAction extends AbstractAction
			{
				/**
		 * 
		 */
				private static final long	serialVersionUID	= 1L;
				
				public TitleAction(String title, ImageIcon icon)
					{
						super(title, icon);
					}
				
				public void actionPerformed(ActionEvent arg0)
					{
						expanded = !expanded;
						if (expanded)
							jbChangeAll.setAction(collapseAction);
						else
							jbChangeAll.setAction(expandAction);
						jbChangeAll.setRolloverIcon(expanded ? UIResources.imageIconCollapseAllAct : UIResources.imageIconExpandAllAct);
					}
			}
		
		private void dispatchEvent(MouseEvent me)
			{
				if ((buttonRect != null) && (buttonRect.contains(me.getX(), me.getY())))
					{
						Point pt = me.getPoint();
						pt.translate(-offset, 0);
						jbChangeAll.setBounds(buttonRect);
						jbChangeAll.dispatchEvent(new MouseEvent(jbChangeAll, me.getID(), me.getWhen(), me.getModifiers(), pt.x, pt.y, me.getClickCount(), me.isPopupTrigger(), me.getButton()));
						if (!jbChangeAll.isValid())
							container.repaint();
					}
			}
		
		private void dispatchMouseMovementEvent(MouseEvent me)
			{
				if (buttonRect.contains(me.getX(), me.getY()))
					{
						Point pt = me.getPoint();
						pt.translate(-offset, 0);
						jbChangeAll.setBounds(buttonRect);
						jbChangeAll.dispatchEvent(new MouseEvent(jbChangeAll, isOverButton ? me.getID() : MouseEvent.MOUSE_ENTERED, me.getWhen(), me.getModifiers(), pt.x, pt.y, me.getClickCount(), me.isPopupTrigger(),
								me.getButton()));
						if (!jbChangeAll.isValid())
							container.repaint();
						isOverButton = true;
					}
				else
					{
						Point pt = me.getPoint();
						pt.translate(-offset, 0);
						jbChangeAll.setBounds(buttonRect);
						jbChangeAll.dispatchEvent(new MouseEvent(jbChangeAll, isOverButton ? MouseEvent.MOUSE_EXITED : me.getID(), me.getWhen(), me.getModifiers(), pt.x, pt.y, me.getClickCount(), me.isPopupTrigger(),
								me.getButton()));
						if (!jbChangeAll.isValid())
							container.repaint();
						isOverButton = false;
					}
			}
		
		public void mouseClicked(MouseEvent me)
			{
				dispatchEvent(me);
			}
		
		public void mouseEntered(MouseEvent me)
			{
				dispatchEvent(me);
			}
		
		public void mouseExited(MouseEvent me)
			{
				dispatchEvent(me);
			}
		
		public void mousePressed(MouseEvent me)
			{
				dispatchEvent(me);
			}
		
		public void mouseReleased(MouseEvent me)
			{
				dispatchEvent(me);
			}
		
		public void mouseDragged(MouseEvent me)
			{
				dispatchEvent(me);
			}
		
		@Override
		public void mouseMoved(MouseEvent me)
			{
				dispatchMouseMovementEvent(me);
			}
		
		protected JButton createChangeButton()
			{
				JButton button = new JButton(expanded ? expandAction : collapseAction);
				button.setRolloverIcon(expanded ? UIResources.imageIconCollapseAllAct : UIResources.imageIconExpandAllAct);
				button.setFocusPainted(false);
				button.setBackground(Color.white);
				button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
				button.addActionListener(this);
				return button;
			}
		
		public void actionPerformed(ActionEvent e)
			{
				fireStatusChanged(new EventObject(this));
			}
		
		public boolean isExpanded()
			{
				return expanded;
			}
		
		public void setExpanded(boolean expanded)
			{
				this.expanded = expanded;
			}
		
		public interface CollapsableStatusChangeListener
			{
				public void statusChanged(EventObject evt);
			}
		
		public void addCollapsableStatusChangeListener(CollapsableStatusChangeListener listener)
			{
				actionListeners.add(listener);
			}
		
		public void removeCollapsableStatusChangeListener(CollapsableStatusChangeListener listener)
			{
				actionListeners.remove(listener);
			}
		
		protected void fireStatusChanged(EventObject evt)
			{
				for (CollapsableStatusChangeListener listener : actionListeners)
					listener.statusChanged(evt);
			}
		
		protected ArrayList<CollapsableStatusChangeListener>	actionListeners					= new ArrayList<CollapsableStatusChangeListener>();
		protected boolean																																				showButtonAtTopLeft	= false;
		public final int																																					xEdgeOffset									= 32;
		protected boolean																																				expanded												= false;
		protected JComponent																																	container;
		protected Action																																					expandAction								= new TitleAction("exapnd all", UIResources.imageIconExpandAll);
		protected Action																																					collapseAction						= new TitleAction("collapse all", UIResources.imageIconCollapseAll);
		protected JButton																																				jbChangeAll									= createChangeButton();
		public final int																																					buttonW													= jbChangeAll.getPreferredSize().width;
		public final int																																					buttonH													= 18;
		protected Rectangle																																		buttonRect										= new Rectangle(xEdgeOffset, 0, buttonW, buttonH);
		protected boolean																																				isOverButton								= false;
		public int																																											offset														= 4;
		
		/**
		 * 
		 */
		private static final long																												serialVersionUID				= 1L;
		
	}
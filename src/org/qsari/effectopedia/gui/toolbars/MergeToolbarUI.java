package org.qsari.effectopedia.gui.toolbars;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.EventListener;
import java.util.EventObject;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import javax.swing.event.EventListenerList;

import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.AdjustableUI;
import org.qsari.effectopedia.gui.UIResources;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class MergeToolbarUI extends javax.swing.JToolBar implements AdjustableUI
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID			= 1L;
		protected JButton									jbOverrideRightWithLeft;
		protected JButton									jbOverrideLeftWithRight;
		protected JButton									jbOverrideSelRightWithLeft;
		protected JButton									jbOverrideSelLeftWithRight;
		
		public static final int			OVERRIDE_RIGHT					= 0x0001;
		public static final int			OVERRIDE_LEFT						= 0x0002;
		public static final int			OVERRIDE_SEL_RIGHT	= 0x0004;
		public static final int			OVERRIDE_SEL_LEFT		= 0x0008;
		
		public static final int			ALL																= 0xFFFF;
		
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new MergeToolbarUI(MergeToolbarUI.ALL));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public MergeToolbarUI()
			{
				super();
				eventListeners = new EventListenerList();
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						this.setPreferredSize(new java.awt.Dimension(100, 36));
						this.setMinimumSize(new java.awt.Dimension(72, 36));
						this.setMaximumSize(new java.awt.Dimension(100, 36));
						imap = getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
						jbOverrideSelRightWithLeft = createButton(
								createAction("Override selected canges from left with right", UIResources.imageOverrideSelLWR, "Override selected canges from left with right", "C", OVERRIDE_SEL_RIGHT), OVERRIDE_SEL_RIGHT,
								ALL);
						jbOverrideSelLeftWithRight = createButton(
								createAction("Override selected canges from right with left", UIResources.imageOverrideSelRWL, "Override selected canges from right with left", "L", OVERRIDE_SEL_LEFT), OVERRIDE_SEL_LEFT, ALL);
						jbOverrideRightWithLeft = createButton(createAction("Override all canges from right with left", UIResources.imageOverrideRWL, "Override all canges from right with left", "C", OVERRIDE_RIGHT),
								OVERRIDE_RIGHT, ALL);
						jbOverrideLeftWithRight = createButton(createAction("Override all canges from left with right", UIResources.imageOverrideLWR, "Override all canges from right with left", "L", OVERRIDE_LEFT),
								OVERRIDE_LEFT, ALL);
						addKeyListener(new CommandKeys());
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public MergeToolbarUI(int buttons)
			{
				super();
				eventListeners = new EventListenerList();
				this.setMinimumSize(new java.awt.Dimension(72, 36));
				imap = getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
				if ((OVERRIDE_SEL_RIGHT & buttons) != 0)
					jbOverrideSelRightWithLeft = createButton(
							createAction("Override selected canges in left with right", UIResources.imageOverrideSelLWR, "Override selected canges in left with right", "C", OVERRIDE_SEL_RIGHT), OVERRIDE_SEL_RIGHT, ALL);
				if ((OVERRIDE_SEL_LEFT & buttons) != 0)
					jbOverrideSelLeftWithRight = createButton(
							createAction("Override selected canges in right with left", UIResources.imageOverrideSelRWL, "Override selected canges in right with left", "L", OVERRIDE_SEL_LEFT), OVERRIDE_SEL_LEFT, ALL);
				if ((OVERRIDE_RIGHT & buttons) != 0)
					jbOverrideRightWithLeft = createButton(createAction("Override all canges in right with left", UIResources.imageOverrideRWL, "Override all canges in right with left", "C", OVERRIDE_RIGHT),
							OVERRIDE_RIGHT, ALL);
				if ((OVERRIDE_LEFT & buttons) != 0)
					jbOverrideLeftWithRight = createButton(createAction("Override all canges in left with right", UIResources.imageOverrideLWR, "Override all canges in right with left", "L", OVERRIDE_LEFT),
							OVERRIDE_LEFT, ALL);
				addKeyListener(new CommandKeys());
			}
		
		public class CommandAction extends AbstractAction
			{
				/**
		 * 
		 */
				private static final long	serialVersionUID	= 1L;
				
				public CommandAction(String actionName, Icon icon, int actionCode, String description)
					{
						putValue(Action.NAME, actionName);
						putValue(Action.SMALL_ICON, icon);
						putValue("actionCode", actionCode);
						putValue(Action.SHORT_DESCRIPTION, description);
					}
				
				public void actionPerformed(ActionEvent event)
					{
						int actionCode = (Integer) getValue("actionCode");
						fireMergeToolbarAction(new MergeToolbarAction(this, actionCode));
					}
			}
		
		public class CommandKeys implements java.awt.event.KeyListener
			{
				public void keyPressed(KeyEvent e)
					{
						if (e.getKeyCode() == KeyEvent.VK_ALT)
							;
					}
				
				public void keyReleased(KeyEvent e)
					{
						if (e.getKeyCode() == KeyEvent.VK_ALT)
							;
					}
				
				public void keyTyped(KeyEvent e)
					{
						
					}
			}
		
		private CommandAction createAction(String actionName, ImageIcon icon, String hint, String key, int actionCode)
			{
				CommandAction action = new CommandAction(actionName, icon, actionCode, hint);
				imap.put(KeyStroke.getKeyStroke(key), actionName);
				getActionMap().put(actionName, action);
				return action;
			}
		
		private JButton createButton(CommandAction action, int buttonType, int buttons)
			{
				if ((buttons & buttonType) != 0)
					{
						JButton button = new JButton(action);
						add(button);
						button.setHideActionText(DefaultGOSettings.hideActionText);
						button.setFocusPainted(false);
						return button;
					}
				return null;
			}
		
		public void updatePrefferedSize()
			{
				Dimension d = new Dimension(0, 0);
				d.setSize(72, 36);
				if (getOrientation() == HORIZONTAL)
					for (Component c : getComponents())
						{
							Dimension componentDimension = c.getPreferredSize();
							d.width += componentDimension.width;
							if (d.height < componentDimension.height)
								d.height = componentDimension.height;
						}
				else
					for (Component c : getComponents())
						{
							Dimension componentDimension = c.getPreferredSize();
							d.height += componentDimension.height;
							if (d.width < componentDimension.width)
								d.width = componentDimension.width;
						}
				setPreferredSize(d);
			}
		
		/**
		 * Adjust <code>visible</code> properties to the current and the contained
		 * components
		 * 
		 * @see AdjustableUI
		 * 
		 * @param visualOptions
		 *         an long that specifies which of the contained components are
		 *         visible
		 */
		public void adjustUI(long visualOptions)
		
			{
				this.setVisible((visualOptions & LIST_TOOLBARS) != 0);
			}
		
		public class MergeToolbarAction extends EventObject
			{
				/**
	 * 
	 */
				private static final long	serialVersionUID	= 1L;
				
				public MergeToolbarAction(Object source, int action)
					{
						super(source);
						this.action = action;
					}
				
				public final int	action;
			}
		
		public interface MergeToolbarListener extends EventListener
			{
				public void actionPerformed(MergeToolbarAction evt);
			}
		
		public void addMergeToolbarListener(MergeToolbarListener listener)
			{
				eventListeners.add(MergeToolbarListener.class, listener);
			}
		
		public void removeMergeToolbarListener(MergeToolbarListener listener)
			{
				eventListeners.remove(MergeToolbarListener.class, listener);
			}
		
		protected void fireMergeToolbarAction(MergeToolbarAction evt)
			{
				MergeToolbarListener[] listeners = eventListeners.getListeners(MergeToolbarListener.class);
				for (int i = 0; i < listeners.length; i++)
					listeners[i].actionPerformed(evt);
			}
		
		public boolean														useFileDialog				= true;
		private InputMap												imap;
		protected final String								HINT_ALL									= "Override all canges in ";
		protected final String								HINT_SEL									= "Override selected canges in ";
		protected final String								DEFAULT_SOURCE_A	= "left";
		protected final String								DEFAULT_SOURCE_B	= "right";
		protected EventListenerList	eventListeners;
		
	}

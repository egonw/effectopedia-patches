package org.qsari.effectopedia.gui.toolbars;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionListener;

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

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.Effectopedia.DataSourceChange;
import org.qsari.effectopedia.core.Effectopedia.DataSourceChangeListener;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.RevisionBasedDS;
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
public class RevisionNavigationToolbarUI extends javax.swing.JToolBar implements AdjustableUI, DataSourceChangeListener
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public static final int			REVISION_BACK				= 0x0001;
		public static final int			REVISION_FORWARD	= 0x0002;
		
		public static final int			ALL														= 0xFFFF;
		
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new CommandToolbarUI(CommandToolbarUI.ALL));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public RevisionNavigationToolbarUI()
			{
				super();
				initGUI();
				setName("rev_toolbar");
			}
		
		private void initGUI()
			{
				try
					{
						this.setPreferredSize(optmalSize);
						this.setMinimumSize(optmalSize);
						this.setMaximumSize(optmalSize);
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public RevisionNavigationToolbarUI(int buttons)
			{
				super();
				this.setMinimumSize(new java.awt.Dimension(72, 36));
				imap = getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
				jbBack = createButton(createAction("previous revision", UIResources.imageBack, "(Upcoming implementation!) Will load previous revision", "", REVISION_BACK), REVISION_BACK, buttons,"previous");
				jbForward = createButton(createAction("next revision", UIResources.imageForward, "(Upcoming implementation!) Will load next revision", "", REVISION_FORWARD), REVISION_FORWARD, buttons, "next");
				Effectopedia.EFFECTOPEDIA.addDataSourceChangeListener(this);
				addKeyListener(new CommandKeys());
				setName("rev_toolbar");
			}

		@Override
		public void addMouseMotionListener(MouseMotionListener listener)
			{
				super.addMouseMotionListener(listener);
				for (Component c : getComponents())
					if (c instanceof JButton)
						c.addMouseMotionListener(listener);
			}

		public void dataSourceChanged(DataSourceChange evt)
			{
				DataSource ds = Effectopedia.EFFECTOPEDIA.getData();
				if (ds instanceof RevisionBasedDS)
					{
						RevisionBasedDS rbDS = (RevisionBasedDS) ds;
						availableActions(rbDS.hasPrevous(), rbDS.hasNext());
					}
				else
					availableActions(false,false);
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
						switch (actionCode)
							{
								case REVISION_BACK:
									{
											Effectopedia.EFFECTOPEDIA.loadPrevousRevision();
											break;
									}
								case REVISION_FORWARD:
									{
										Effectopedia.EFFECTOPEDIA.loadNextRevision();
										break;
									}
							}
					}
			}
		
		public void availableActions(boolean hasBack, boolean hasForward)
			{
				jbBack.setEnabled(hasBack);
				jbForward.setEnabled(hasForward);
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
		
		private JButton createButton(CommandAction action, int buttonType, int buttons, String name)
			{
				if ((buttons & buttonType) != 0)
					{
						JButton button = new JButton(action);
						add(button);
						button.setHideActionText(DefaultGOSettings.hideActionText);
						button.setFocusPainted(false);
						button.setPreferredSize(optmalButtonSize);
						button.setDisabledIcon(UIResources.imageDisabled);
						button.setName(name);
						// button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
						// button.setBackground(Color.white);
						return button;
					}
				return null;
			}
		
		public void updatePrefferedSize()
			{
				Dimension d = new Dimension(0, 0);
				d.setSize(72, 28);
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
		
		public boolean																useFileDialog				= false;
		private InputMap														imap;
		private JButton															jbBack;
		private JButton															jbForward;
		public static final Dimension	optmalSize							= new java.awt.Dimension(72, 28);
		public static final Dimension	optmalButtonSize	= new java.awt.Dimension(36, 28);
	}

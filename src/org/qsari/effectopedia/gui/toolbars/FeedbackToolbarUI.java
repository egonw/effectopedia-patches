package org.qsari.effectopedia.gui.toolbars;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
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

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.DiscussionTopic;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.defaults.DefaultServerSettings;
import org.qsari.effectopedia.gui.AdjustableUI;
import org.qsari.effectopedia.gui.UIResources;
import org.qsari.effectopedia.gui.WelcomeUI;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.system.AuthenticationManager.UserSignInListener;
import org.qsari.effectopedia.system.AuthenticationManager.UserSignOutListener;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class FeedbackToolbarUI extends javax.swing.JPanel implements AdjustableUI, UserSignInListener, UserSignOutListener, LoadableEditorUI
	{
		public static final int	CHAT					= 0x0001;
		public static final int	DISCUSS		= 0x0002;
		
		public static final int	INTERACT	= CHAT + DISCUSS;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new ListEditorToolbarUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public FeedbackToolbarUI()
			{
				super();
				initGUI(INTERACT, FlowLayout.LEFT);
			}
		
		public FeedbackToolbarUI(String objectName, int buttons, int flowLayoutAlign)
			{
				super();
				this.itemName = objectName;
				initGUI(buttons, flowLayoutAlign);
			}
		
		private void initGUI(int buttons, int flowLayoutAlign)
			{
				try
					{
						this.setPreferredSize(new java.awt.Dimension(42, 20));
						this.setBackground(Color.WHITE);
						this.setBackground(Color.WHITE);
						Effectopedia.EFFECTOPEDIA.getAutentication().addUserSignInListener(this);
						Effectopedia.EFFECTOPEDIA.getAutentication().addUserSignOutListener(this);
						
						FlowLayout jpLayout = new FlowLayout();
						jpLayout.setAlignment(flowLayoutAlign);
						jpLayout.setHgap(3);
						jpLayout.setVgap(1);
						setLayout(jpLayout);
						
						imap = getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
						
						if ((buttons & DISCUSS) != 0)
							createButton(createAction("discuss", UIResources.imageIconDiscuss, "Discuss this " + this.itemName, "", DISCUSS));
						if ((buttons & CHAT) != 0)
							createButton(createAction("chat", UIResources.imageIconChat, "Chat about this " + this.itemName, "", CHAT));
						
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public class ToolbarAction extends AbstractAction
			{
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				public ToolbarAction(String actionName, Icon icon, int actionCode, String description)
					{
						putValue(Action.NAME, actionName);
						putValue(Action.SMALL_ICON, icon);
						putValue("actionCode", actionCode);
						putValue(Action.SHORT_DESCRIPTION, description);
					}
				
				public void actionPerformed(ActionEvent event)
					{
						// System.out.println(event);
						if (object == null)
							return;
						int actionCode = (Integer) getValue("actionCode");
						if (actionCode == DISCUSS)
							{
								DiscussionTopic topic = DiscussionTopic.locateTopic(object);
								if (topic != null)
									UserInterface.getDefaultNavigator().navigate(UILocations.discussUIL, topic);
								else
									{
										boolean confirmed = UserInterface.getUserConfirmation("There is no discussion associated with the current object. Do you like " + (signedIn ? "" : "to sign in and ")
												+ "create one?");
										
										if (confirmed)
											if (signedIn)
												UserInterface.getDefaultNavigator().navigate(UILocations.discussUIL, DiscussionTopic.locateORCreateTopic(object));
											else
												{
													pendingRedirection = true;
													Component comp = (Component) UserInterface.getDefaultNavigator().navigate(UILocations.welcomeUIL, null);
													if (comp instanceof WelcomeUI)
														((WelcomeUI) comp).load(DefaultServerSettings.signInURL, false);
												}
									}
							}
						else if (actionCode == CHAT)
							UserInterface.showFeedback("Chat feature is not implemented yet", "Information");
					}
				
			}
		
		private ToolbarAction createAction(String actionName, ImageIcon icon, String hint, String key, int actionCode)
			{
				ToolbarAction action = new ToolbarAction(actionName, icon, actionCode, hint);
				imap.put(KeyStroke.getKeyStroke(key), actionName);
				getActionMap().put(actionName, action);
				return action;
			}
		
		private JButton createButton(Action action)
			{
				JButton button = new JButton(action);
				add(button);
				button.setPreferredSize(new java.awt.Dimension(18, 18));
				button.setHideActionText(DefaultGOSettings.hideActionText);
				return button;
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
		
		@Override
		public void userSignedOut(EventObject evt)
			{
				signedIn = false;
			}
		
		@Override
		public void userSignedIn(EventObject evt)
			{
				signedIn = true;
				if (pendingRedirection)
					{
						pendingRedirection = false;
						UserInterface.getDefaultNavigator().navigate(UILocations.discussUIL, DiscussionTopic.locateORCreateTopic(object));
					}
			}
		
		@Override
		public void load(Object o, boolean readonly)
			{
				this.object = o;
			}
		
		private boolean											signedIn											= false;
		private boolean											pendingRedirection	= false;
		private InputMap										imap;
		private String												itemName;
		private Object												object =  null;
		private static final long	serialVersionUID			= 1L;
		
	}

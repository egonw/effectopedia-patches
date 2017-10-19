package org.qsari.effectopedia.gui.toolbars;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
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
import org.qsari.effectopedia.gui.comp.GlobalUpdateTracker;
import org.qsari.effectopedia.gui.core.ClipboardTransferableUI;
import org.qsari.effectopedia.gui.core.ManageableIndexedListUI;
import org.qsari.effectopedia.system.AuthenticationManager.UserSignInListener;
import org.qsari.effectopedia.system.AuthenticationManager.UserSignOutListener;

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
public class ListEditorToolbarUI extends javax.swing.JPanel implements AdjustableUI, UserSignInListener, UserSignOutListener
	{
		public static final int	CHAT					= 0x0001;
		public static final int	DISCUSS		= 0x0002;
		public static final int	RESET				= 0x0004;
		public static final int	REMOVE			= 0x0008;
		public static final int	ADD						= 0x0010;
		public static final int	COPY					= 0x0020;
		public static final int	PASTE				= 0x0040;
		
		public static final int	DEFAULT		= 0x001F;
		public static final int	ALL						= 0x00FF;
		public static final int	LISTACT		= ADD + REMOVE + RESET;
		public static final int	CLIPBACT	= COPY + PASTE;
		public static final int	INTERACT	= CHAT + DISCUSS;
		
		protected JButton							jbChat;
		protected JButton							jbDiscuss;
		protected JButton							jbReset;
		protected JButton							jbRemove;
		protected JButton							jbAdd;
		protected JButton							jbCopy;
		protected JButton							jbPaste;
		
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
		
		public ListEditorToolbarUI()
			{
				super();
				listEditorActionListeners = new ArrayList<ListEditorActionListener>();
				initGUI(DEFAULT, FlowLayout.LEFT);
				setName("le_toolbar");
			}
		
		public ListEditorToolbarUI(ManageableIndexedListUI<?> listManager, String listName, int buttons, int flowLayoutAlign)
			{
				super();
				this.listName = listName;
				this.listManager = listManager;
				this.setName("list_editor");
				listEditorActionListeners = new ArrayList<ListEditorActionListener>();
				initGUI(buttons, flowLayoutAlign);
				setName("le_toolbar");
			}

		@Override
		public void addMouseMotionListener(MouseMotionListener listener)
			{
				super.addMouseMotionListener(listener);
				for (Component c : getComponents())
					c.addMouseMotionListener(listener);
			}

		private void initGUI(int buttons, int flowLayoutAlign)
			{
				try
					{
						this.setPreferredSize(new java.awt.Dimension(109, 20));
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
						
						if ((buttons & ADD) != 0)
							jbAdd = createButton(createAction("add", UIResources.imageIconAdd, "Add new " + this.listName, "", ADD),"add");
						if ((buttons & REMOVE) != 0)
							jbRemove = createButton(createAction("remove", UIResources.imageIconDelete, "Delete selected " + this.listName + "(s)", "", REMOVE),"remove");
						if ((buttons & RESET) != 0)
							jbReset = createButton(createAction("reset", UIResources.imageIconReset, "Delete all " + this.listName + "s", "", RESET),"reset");
						if (((buttons & LISTACT) != 0) && ((buttons & CLIPBACT) != 0) || ((buttons & INTERACT) != 0))
							createSpacer();
						if ((buttons & COPY) != 0)
							jbCopy = createButton(createAction("copy", UIResources.imageIconCopy, "Copy " + this.listName + "s", "", COPY),"copy");
						if ((buttons & PASTE) != 0)
							jbPaste = createButton(createAction("paste", UIResources.imageIconPaste, "Paste " + this.listName + "s", "", PASTE),"paste");
						if (((buttons & CLIPBACT) != 0) && ((buttons & INTERACT) != 0))
							createSpacer();
						if ((buttons & DISCUSS) != 0)
							jbDiscuss = createButton(createAction("discuss", UIResources.imageIconDiscuss, "Discuss selected " + this.listName + "(s)", "", DISCUSS),"discuss");
						if ((buttons & CHAT) != 0)
							jbChat = createButton(createAction("chat", UIResources.imageIconChat, "Chat about selected " + this.listName + "(s)", "", CHAT),"chat");
						
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
						int actionCode = (Integer) getValue("actionCode");
						actionCode = fireListEditorActionPerformed(actionCode);
						if (listManager == null)
							return;
						switch (actionCode)
							{
								case ADD:
									listManager.add(true);
									break;
								case REMOVE:
									listManager.remove();
									break;
								case RESET:
									listManager.reset();
									break;
								case COPY:
									if (listManager instanceof ClipboardTransferableUI)
										((ClipboardTransferableUI) listManager).copy();
									break;
								case PASTE:
									if (listManager instanceof ClipboardTransferableUI)
										((ClipboardTransferableUI) listManager).paste();
									break;
								case DISCUSS:
									DiscussionTopic topic = DiscussionTopic.locateTopic(listManager.getList());
									if (topic != null)
										UserInterface.getDefaultNavigator().navigate(UILocations.discussUIL, topic);
									else
										{
											boolean confirmation = UserInterface.getUserConfirmation("There is no discussion associated with the current object. Do you like " + (signedIn ? "" : "to sign in and ") + "create one?");
											if (confirmation)
												if (signedIn)
													UserInterface.getDefaultNavigator().navigate(UILocations.discussUIL, DiscussionTopic.locateORCreateTopic(listManager.getList()));
												else
													{
														pendingRedirection = true;
														Component comp = (Component) UserInterface.getDefaultNavigator().navigate(UILocations.welcomeUIL, null);
														if (comp instanceof WelcomeUI)
															((WelcomeUI) comp).load(DefaultServerSettings.signInURL, false);
													}
										}
									break;
								case CHAT:
									UserInterface.showFeedback("Chat feature is not implemented yet", "Information");
									break;
							}
						if (listManager.getList() != null)
							GlobalUpdateTracker.GUT.fireObjectUpdated(new EventObject(listManager.getList()));
					}
				
			}
		
		private ToolbarAction createAction(String actionName, ImageIcon icon, String hint, String key, int actionCode)
			{
				ToolbarAction action = new ToolbarAction(actionName, icon, actionCode, hint);
				imap.put(KeyStroke.getKeyStroke(key), actionName);
				getActionMap().put(actionName, action);
				return action;
			}
		
		private JButton createButton(Action action, String name)
			{
				JButton button = new JButton(action);
				add(button);
				button.setPreferredSize(new java.awt.Dimension(18, 18));
				button.setHideActionText(DefaultGOSettings.hideActionText);
				button.setName(name);
				return button;
			}
		
		public void setListName(String listName)
			{
				this.listName = listName;
				createAction("add", UIResources.imageIconAdd, "Add new " + this.listName, "", ADD);
				createAction("remove", UIResources.imageIconDelete, "Delete selected " + this.listName + "(s)", "", REMOVE);
				createAction("reset", UIResources.imageIconReset, "Delete all " + this.listName + "s", "", RESET);
				createAction("copy", UIResources.imageIconCopy, "Copy " + this.listName + "s", "", COPY);
				createAction("paste", UIResources.imageIconPaste, "Paste " + this.listName + "s", "", PASTE);
				createAction("discuss", UIResources.imageIconDiscuss, "Discuss selected " + this.listName + "(s)", "", DISCUSS);
				createAction("chat", UIResources.imageIconChat, "Chat about selected " + this.listName + "(s)", "", CHAT);
			}
		
		@SuppressWarnings("serial")
		class JSpacer extends JSeparator
			{
				public JSpacer(int orientation)
					{
						super(orientation);
					}
				
				protected void paintComponent(Graphics g)
					{
					}
			}
		
		private void createSpacer()
			{
					
					{
						JSpacer spacer = new JSpacer(SwingConstants.VERTICAL);
						add(spacer);
						spacer.setPreferredSize(new java.awt.Dimension(1, 18));
						spacer.setBackground(Color.WHITE);
					}
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
						UserInterface.getDefaultNavigator().navigate(UILocations.discussUIL, DiscussionTopic.locateORCreateTopic(listManager.getList()));
					}
			}
		
		public void updateEditButtons(boolean readonly)
			{
				if (jbReset != null)
					jbReset.setEnabled(!readonly);
				if (jbRemove != null)
					jbRemove.setEnabled(!readonly);
				if (jbAdd != null)
					jbAdd.setEnabled(!readonly);
				if (jbPaste != null)
					jbPaste.setEnabled(!readonly);
			}
		
		public void updateEditButtons(int buttons, boolean readonly)
			{
				if ((buttons & ADD) != 0)
					jbAdd.setEnabled(!readonly);
				if ((buttons & REMOVE) != 0)
					jbRemove.setEnabled(!readonly);
				if ((buttons & RESET) != 0)
					jbReset.setEnabled(!readonly);
				if ((buttons & COPY) != 0)
					jbCopy.setEnabled(!readonly);
				if ((buttons & PASTE) != 0)
					jbPaste.setEnabled(!readonly);
				if ((buttons & DISCUSS) != 0)
					jbDiscuss.setEnabled(!readonly);
				if ((buttons & CHAT) != 0)
					jbChat.setEnabled(!readonly);
			}

		public ManageableIndexedListUI<?> getListManager()
			{
				return listManager;
			}
		
		public void setListManager(ManageableIndexedListUI<?> listManager)
			{
				this.listManager = listManager;
			}
		
		public interface ListEditorActionListener
			{
				public int listEditorActionPerformed(int actionCode);
			}
		
		public void addListEditorActionListener(ListEditorActionListener listener)
			{
				listEditorActionListeners.add(listener);
			}
		
		public void removeListEditorActionListener(ListEditorActionListener listener)
			{
				listEditorActionListeners.remove(listener);
			}
		
		protected int fireListEditorActionPerformed(int actionCode)
			{
				for (ListEditorActionListener listener : listEditorActionListeners)
					actionCode = listener.listEditorActionPerformed(actionCode);
				return actionCode;
			}
		
		protected ArrayList<ListEditorActionListener>	listEditorActionListeners;
		private boolean																															signedIn											= false;
		private boolean																															pendingRedirection	= false;
		private InputMap																														imap;
		private String																																listName;
		private ManageableIndexedListUI<?>												listManager;
		private static final long																					serialVersionUID			= 1L;
		
	}

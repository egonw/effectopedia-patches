package org.qsari.effectopedia.gui.toolbars;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
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
import javax.swing.WindowConstants;

import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.AdjustableUI;
import org.qsari.effectopedia.gui.SystemConsoleUI;
import org.qsari.effectopedia.gui.UIResources;
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
public class SystemConsoleToolbarUI extends javax.swing.JPanel implements AdjustableUI, UserSignInListener, UserSignOutListener
	{
		public static final int	RESET			= 0x0001;
		public static final int	COPY				= 0x0002;
		public static final int	SEND				= 0x0004;
		
		public static final int	DEFAULT	= 0x0003;
		public static final int	ALL					= 0x0007;
		
		protected JButton							jbReset;
		protected JButton							jbCopy;
		protected JButton							jbSend;
		
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
		
		public SystemConsoleToolbarUI()
			{
				super();
				initGUI(DEFAULT, FlowLayout.LEFT);
			}
		
		private void initGUI(int buttons, int flowLayoutAlign)
			{
				try
					{
						this.setPreferredSize(new java.awt.Dimension(109, 20));
						this.setBackground(Color.WHITE);
						
						FlowLayout jpLayout = new FlowLayout();
						jpLayout.setAlignment(flowLayoutAlign);
						jpLayout.setHgap(3);
						jpLayout.setVgap(1);
						setLayout(jpLayout);
						
						imap = getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
						if ((buttons & RESET) != 0)
							jbReset = createButton(createAction("reset", UIResources.imageIconReset, "Clear error log and console content", "", RESET));
						if ((buttons & COPY) != 0)
							jbCopy = createButton(createAction("copy", UIResources.imageIconCopy, "Copy console and error log in the clipboard", "", COPY));
						if ((buttons & SEND) != 0)
							jbSend = createButton(createAction("send", UIResources.imageIconSend, "Send error to Effectopedia support", "", SEND));
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public static void setClipboard(String text)
			{
				StringSelection stringSelection = new StringSelection(text);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
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
						switch (actionCode)
							{
								case RESET:
									systemConsole.reset();
									break;
								case COPY:
									setClipboard(systemConsole.copy());
									break;
								case SEND:
									if (Desktop.getDesktop().isSupported(Desktop.Action.MAIL))
										sendMail();
									break;
							}
					}
				
			}
		
		private void sendMail()
			{
				String message = "Please provide brief descriptions of the circumstances in which the error occur and attach, if possible, any relevant data files.\nThe error log is already in the clipboard so you can paste it below.\nThank you!\n";
				setClipboard(systemConsole.copy());
				String uri = String.format("mailto:debug@effectopedia.org?subject=%s&body=%s", urlEncode("Effectopedia Error Report"), urlEncode(message));
				try
					{
						Desktop.getDesktop().mail(new URI(uri));
					}
				catch (IOException | URISyntaxException e)
					{
						e.printStackTrace();
					}
			}
		
		private static final String urlEncode(String str)
			{
				try
					{
						return URLEncoder.encode(str, "UTF-8").replace("+", "%20");
					}
				catch (UnsupportedEncodingException e)
					{
						return str;
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
		
		public SystemConsoleToolbarUI(SystemConsoleUI systemConsole, int buttons, int flowLayoutAlign)
			{
				super();
				this.systemConsole = systemConsole;
				initGUI(buttons, flowLayoutAlign);
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
				if (jbSend != null)
					jbSend.setEnabled(false);
			}
		
		@Override
		public void userSignedIn(EventObject evt)
			{
				if (jbSend != null)
					jbSend.setEnabled(true);
			}
		
		private SystemConsoleUI			systemConsole;
		private InputMap										imap;
		private static final long	serialVersionUID	= 1L;
		
	}

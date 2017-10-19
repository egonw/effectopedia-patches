package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.EventObject;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.defaults.DefaultServerSettings;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.nav.RedirectorTextPane;
import org.qsari.effectopedia.system.AuthenticationManager.UserSignInListener;
import org.qsari.effectopedia.system.AuthenticationManager.UserSignOutListener;
import org.qsari.effectopedia.system.User;

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
public class AuthenticationUI extends ContextSensitivePanel implements AdjustableUI, UserSignInListener, UserSignOutListener, RootHelpContext
	{
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		private JTextPane									jtpAuthentification;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new AuthenticationUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public AuthenticationUI()
			{
				super(null);
				initGUI();
				setName("authentication");
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBackground(Color.WHITE);
						this.setPreferredSize(new java.awt.Dimension(572, 25));
						Effectopedia.EFFECTOPEDIA.getAutentication().addUserSignInListener(this);
						Effectopedia.EFFECTOPEDIA.getAutentication().addUserSignOutListener(this);
							
							{
								jtpAuthentification = new JTextPane();
								jtpAuthentification.setContentType("text/html");
								jtpAuthentification.setEditable(false);
								jtpAuthentification.setBackground(Color.WHITE);
								redirector = new RedirectorTextPane(jtpAuthentification);
								redirector.addTarget("welcomeUIL", UILocations.welcomeUIL);
								jtpAuthentification.addHyperlinkListener(redirector);
								jtpAuthentification.setText(SIGN_IN);
								jtpAuthentification.setName("sign_in");
								redirector.setObject(DefaultServerSettings.signInURL);
								this.add(jtpAuthentification, BorderLayout.CENTER);
								jtpAuthentification.addMouseMotionListener(this);
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		@Override
		public void userSignedIn(EventObject evt)
			{
				if (evt.getSource() instanceof User)
					{
						User user = (User) evt.getSource();
						jtpAuthentification.setName("sign_out");
						jtpAuthentification.setText(SIGN_OUT_HEAD + "Signed as: <font color='6382BF'>" + user.getDisplayName()+"</font>" +PROFILE+ SIGN_OUT_FOOT);
						redirector.setObject(DefaultServerSettings.upd_profileURL);
					}
			}
		
		@Override
		public void userSignedOut(EventObject evt)
			{
				jtpAuthentification.setName("sign_in");
				jtpAuthentification.setText(SIGN_IN);
				redirector.setObject(DefaultServerSettings.signInURL);
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
				AdjustbleUserInterfaceTools.adjustChildren(this, visualOptions);
			}
		
		private RedirectorTextPane	redirector;
		private final String							SIGN_IN							= "<html>\n<head>\n<style type='text/css'>\n<!--a {color:#666666;}\nbody{border:0px none;text-align: right;}-->\n</style>\n</head>\n\n<body text=\"#666666\">\n<a href='http://www.effectopedia.org/intreface.php?welcomeUIL&help=authentification.sign_in'>Sign in</a>\n</body>\n</html>\n";
		private final String							SIGN_OUT_HEAD	= "<html>\n<head>\n<style type='text/css'>\n<!--a {color:#666666;}\nbody{border:0px none;text-align: right;}-->\n</style>\n</head>\n\n<body text=\"#666666\">\n";
		private final String							PROFILE	= " <a href='http://www.effectopedia.org/intreface.php?welcomeUIL&help=authentification.sign_in'>profile</a>\n ";
		private final String							SIGN_OUT_FOOT	= " <a href='" + DefaultServerSettings.signOutURL + "'>Logout</a>\n</body>\n</html>\n";
	}

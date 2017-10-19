package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.EventObject;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.text.Style;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLEditorKit;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.ui.nav.UILocation;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.defaults.DefaultServerSettings;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.nav.RedirectorTextPane;
import org.qsari.effectopedia.system.AuthenticationManager.UserSignInListener;

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
public class WelcomeUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, UserSignInListener, RootHelpContext
	{
		/**
		* 
		*/
		private static final long	serialVersionUID	= 1L;
		private JPanel												jipWelcome;
		private JPanel												jpVersion;
		private JTextPane									jtpRedirect;
		private JScrollPane							jspContent;
		private JPanel												jpRedirect;
		private JLabel												jlVersion;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new WelcomeUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public class JImagePanel extends javax.swing.JPanel
			{
				/**
				* 
				*/
				private static final long serialVersionUID = 1L;
				
				public JImagePanel(String imageFileName)
					{
						this.imageFileName = imageFileName;
					}
					
				public void paintComponent(Graphics g)
					{
						Graphics2D g2 = (Graphics2D) g;
						float w = getWidth();
						float h = getHeight();
						g2.setColor(Color.WHITE);
						g2.fillRect(0, 0, (int) w, (int) h);
						w = w - 16;
						h = h - 16;
						if (image == null)
							{
								try
									{
										URL url = WelcomeUI.class.getResource(imageFileName);
										image = ImageIO.read(url);
									}
								catch (IOException e)
									{
										e.printStackTrace();
									}
							}
							
						float iw = image.getWidth(null);
						float ih = image.getHeight(null);
						
						float scale = Math.min(w / iw, h / ih);
						
						int scaledImageWidth = (int) (iw * scale);
						int scaledImageHeight = (int) (ih * scale);
						xOffset = 8 + (int) (w - scaledImageWidth) >> 1;
						
						g2.drawImage(image, xOffset, 8 + ((int) (h - scaledImageHeight) >> 1), scaledImageWidth, scaledImageHeight, null);
						
					}
					
				public int getXOffset()
					{
						return this.xOffset;
					}
					
				private int				xOffset;
				private Image		image;
				private String	imageFileName;
			}
			
		public WelcomeUI()
			{
				super(null);
				setName("welcome");
				WelcomeLinksUI.INSTANCE.setRootHelpContext(this);
				initGUI();
			}
			
		private void initGUI()
			{
				try
					{
						GridBagLayout thisLayout = new GridBagLayout();
						thisLayout.rowWeights = new double[]
							{ 0.12, 0.2, 0 };
						thisLayout.rowHeights = new int[]
							{ 12, 20, 1 };
						thisLayout.columnWeights = new double[]
							{ 0.1 };
						thisLayout.columnWidths = new int[]
							{ 7 };
						this.setLayout(thisLayout);
						this.setPreferredSize(new java.awt.Dimension(500, 300));
						this.setBackground(Color.white);
						Effectopedia.EFFECTOPEDIA.getAutentication().addUserSignInListener(this);
							{
								jipWelcome = new WelcomeUI.JImagePanel("res/Effectopedia.png");
								jipWelcome.setName("logo");
								this.add(jipWelcome, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(30, 0, 0, 0), 0, 0));
								jipWelcome.setPreferredSize(new java.awt.Dimension(400, 200));
								jipWelcome.setLocation(new java.awt.Point(0, 0));
							}
							{
								jpRedirect = new JPanel();
								BorderLayout jpRedirectLayout = new BorderLayout();
								jpRedirect.setLayout(jpRedirectLayout);
								this.add(jpRedirect, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
								jpRedirect.setBackground(Color.white);
									{
										jspContent = new JScrollPane();
										jpRedirect.add(jspContent, BorderLayout.CENTER);
										jspContent.setPreferredSize(new java.awt.Dimension(500, 200));
										jspContent.setBackground(Color.WHITE);
										jspContent.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
											{
												jtpRedirect = new JTextPane();
												jspContent.setViewportView(jtpRedirect);
												jtpRedirect.setPreferredSize(new java.awt.Dimension(500, 200));
												jtpRedirect.setContentType("text/html");
												jtpRedirect.setEditable(false);
												((HTMLEditorKit) jtpRedirect.getEditorKitForContentType("text/html")).setAutoFormSubmission(false);
												redirector = new RedirectorTextPane(jtpRedirect);
												redirector.addTarget("viewUIL", UILocations.viewUIL);
												redirector.addTarget("editUIL", UILocations.editUIL);
												redirector.addTarget("searchUIL", UILocations.searchUIL);
												redirector.addTarget("historyUIL", UILocations.historyUIL);
												redirector.addTarget("discussUIL", UILocations.discussUIL);
												redirector.addTarget("welcomeUIL", UILocations.welcomeUIL);
												jtpRedirect.addHyperlinkListener(redirector);
												jtpRedirect.setName("jtpRedirect");
												jtpRedirect.setText("");
												WelcomeLinksUI.createWelcomeLinks(jtpRedirect.getStyledDocument());
											}
									}
							}
							{
								jpVersion = new JPanel();
								jpVersion.setName("version");
								BorderLayout jpVersionLayout = new BorderLayout();
								jpVersion.setLayout(jpVersionLayout);
								this.add(jpVersion, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jpVersion.setPreferredSize(new java.awt.Dimension(400, 15));
								jpVersion.setBackground(DefaultGOSettings.uiSelectedColor);
									{
										jlVersion = new JLabel();
										jpVersion.add(jlVersion, BorderLayout.CENTER);
										jlVersion.setText("Version " + Effectopedia.VERSION + " " + Effectopedia.RELEASE_TYPE + " (GPLv3)");
										jlVersion.setHorizontalAlignment(SwingConstants.RIGHT);
										jlVersion.setFont(new java.awt.Font("Dialog", 0, 10));
										jlVersion.setBackground(DefaultGOSettings.uiSelectedColor);
										jlVersion.setMaximumSize(new java.awt.Dimension(0, 16));
										jlVersion.addMouseMotionListener(this);
									}
								jpVersion.addMouseMotionListener(this);
							}
							
					}
				catch (Exception e)
					{
						e.printStackTrace();
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
				AdjustbleUserInterfaceTools.adjustChildren(this, visualOptions);
			}
			
		public void loadDefault()
			{
				jtpRedirect.setText("");
				WelcomeLinksUI.createWelcomeLinks(jtpRedirect.getStyledDocument());
				// jtpRedirect.setText(welcomeHTML);
				// jtpRedirect.addHyperlinkListener(redirector);
			}
			
		@Override
		public void load(Object o, boolean readonly)
			{
				if (o == null)
					return;
				
				URL url = null;
				try
					{
						if (o instanceof String)
							{
								if (DefaultServerSettings.signInURL.equals(o))
									{
										RedirectorTextPane.openTheDefaultBrowser(DefaultServerSettings.signInURL);
										jtpRedirect.setText(oidcSignInHTML);
										return;
									}
									
								if (UILocation.isInterfaceLocation((String) o))
									{
										String init = UILocation.extractInitialization((String) o);
										if (INT_FEEDBACK.equals(init))
											jtpRedirect.setText(feedbackHTML);
										else
											{
												jtpRedirect.setText("");
												WelcomeLinksUI.createWelcomeLinks(jtpRedirect.getStyledDocument());
												// jtpRedirect.setText(welcomeHTML);
											}
										return;
									}
								url = new URL((String) o);
								if (o.equals(DefaultServerSettings.upd_profileURL))
									{
										jtpRedirect.setText(Effectopedia.EFFECTOPEDIA.getAutentication().getProfile(url));
										return;
									}
							}
						else if (o instanceof URL)
							url = (URL) o;
						
						if (jtpRedirect.getPage() != null)
							{// Patch setPage does not reload the page if it is set to the same URL
								// Document doc = jtpRedirect.getDocument();
								// doc.putProperty(Document.StreamDescriptionProperty, null);
								if (someLocation == null)
									someLocation = new URL(DefaultServerSettings.baseURL + "info.php");
								jtpRedirect.setPage(someLocation);
							}
						jtpRedirect.setPage(url);
					}
				catch (MalformedURLException e)
					{
						e.printStackTrace();
						loadDefault();
					}
				catch (IOException e)
					{
						e.printStackTrace();
						loadDefault();
					}
			}
			
		@Override
		public void userSignedIn(EventObject evt)
			{
				loadDefault();
			}
			
		public static final String	welcomeHTML				= UIResources.resourceAsString("res/welcome.html");
		public static final String	feedbackHTML			= UIResources.resourceAsString("res/feedback.html");
		public static final String	oidcSignInHTML	= UIResources.resourceAsString("res/signin.html");
		
		private static String						INT_FEEDBACK			= "feedback";
		private static URL									someLocation			= null;
		private RedirectorTextPane	redirector;
		
	}

package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.PrintStream;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.RevisionBasedDS;
import org.qsari.effectopedia.defaults.DefaultClientSettings;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.core.EffectopediaGUI;
import org.qsari.effectopedia.gui.core.GUIFactory;
import org.qsari.effectopedia.gui.core.Settings;
import org.qsari.effectopedia.gui.help.ContextSensitiveHelpUI;
import org.qsari.effectopedia.gui.nav.GUINavigator;
import org.qsari.effectopedia.gui.util.AWTLogger;
import org.qsari.effectopedia.gui.util.DefaultTextContextMenu;
import org.qsari.effectopedia.gui.util.GlobalKeyboardShortcut;
import org.qsari.effectopedia.gui.util.TextAreaStream;

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
/**
 * Provides the main user interface of Effectopedia. <code>EffectopediaUI</code>
 * contains three main components <code>ControlPanelUI</code>,
 * <code>MainUI</code> and <code>ContextSensitiveHelpUI</code>.
 * <code>EffectopediaUI</code> and can be executed as both
 * 
 * @see AuthenticationUI
 * @see MainUI
 * @see ContextSensitiveHelpUI
 * 
 * @version 1.1 @(#)EffectopediaUI.java 1.1
 * @author Hristo Aladjov
 */

public class EffectopediaUI extends EffectopediaFrame implements AdjustableUI, EffectopediaGUI
	{
		/**
		* 
		*/
		private static final long						serialVersionUID	= -6375246139441018568L;
		
		private JPanel																	jpControl;
		/**
		 * The EffectopediaUI's control panel containing AddressBar and Authentication
		 * user interfaces
		 */
		
		private AddressBarUI											abuiAddressBar;
		/**
		 * The EffectopediaUI's user identification panel. Initialized in
		 * <code>initGUI</code>
		 * 
		 * @see #initGUI
		 */
		
		private AuthenticationUI							auiAuthentification;
		/**
		 * The EffectopediaUI's user identification panel. Initialized in
		 * <code>initGUI</code>
		 * 
		 * @see #initGUI
		 */
		
		private JSplitPane													jspMain;
		/**
		 * Holds EffectopediaUI's MainUI and ContextSensitiveHelpUI. Initialized in
		 * <code>initGUI</code>
		 * 
		 * @see #initGUI
		 */
		
		private MainUI																	miuiMainInterface;
		/**
		 * The EffectopediaUI's Main tabbed user interface. Initialized in
		 * <code>initGUI</code>
		 * 
		 * @see #initGUI
		 */
		
		private ContextSensitiveHelpUI	cshuiContextSensitiveHelp;
		
		/**
		 * The EffectopediaUI's context sensitive help panel. Initialized in
		 * <code>initGUI</code>
		 * 
		 * @see #initGUI
		 */
		
		public static void main(String[] args)
			{
				EffectopediaUI.commandLineParameters = args;
				SwingUtilities.invokeLater(new Runnable()
					{
						public void run()
							{
								EffectopediaUI frame = new EffectopediaUI();
								frame.setLocationRelativeTo(null);
								frame.setTitle("Effectopedia  Albert J. Leo Edition");
								frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
								Toolkit toolkit = Toolkit.getDefaultToolkit();
								Dimension screenSize = toolkit.getScreenSize();
								frame.setLocation((screenSize.width - 980) / 2, 16 + (screenSize.height - 640) / 2);
								frame.pack();
								frame.setVisible(true);
								DefaultTextContextMenu.updateUIManager();
							}
					});
			}
			
		public EffectopediaUI()
			{
				super();
				setName("effectopedia");
				Settings.useDefaultGUISettings();
				navigator = new GUINavigator(this);
				UserInterface.setDefaultNavigator(navigator);
				Effectopedia.EFFECTOPEDIA.defaultDatasource();
				initGlobalShortcuts();
				initGUI();
				DefaultEffectopediaObjects.generateTestGOs();
				if ((commandLineParameters != null) && (commandLineParameters.length >= 1) && (new File(commandLineParameters[0]).isFile()))
					{
						Effectopedia.EFFECTOPEDIA.loadFromLocalXMLFile(commandLineParameters[0]);
					}
				for (DataSource ds : Effectopedia.EFFECTOPEDIA.getAvailableDataSources())
					if (ds instanceof RevisionBasedDS)
						((RevisionBasedDS) ds).addLocaionChangeListener(abuiAddressBar);
				GUIFactory.GUI = this;
				if (DefaultClientSettings.REDIRECT_SYSTEM_STREAMS)
					redicrectSystemStreams();
				addWindowListener(new WindowAdapter()
					{
						public void windowClosing(WindowEvent e)
							{
								GUIFactory.FACTORY.exit();
							}
					});
			}
			
		public GUINavigator getNavigator()
			{
				return this.navigator;
			}
			
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						setPreferredSize(new Dimension(980, 640));
							{
								jpControl = new JPanel();
								GridBagLayout jpControlLayout = new GridBagLayout();
								jpControlLayout.rowWeights = new double[]
									{ 0.1 };
								jpControlLayout.rowHeights = new int[]
									{ 7 };
								jpControlLayout.columnWeights = new double[]
									{ 0.86, 0.1 };
								jpControlLayout.columnWidths = new int[]
									{ 860, 100 };
								jpControl.setLayout(jpControlLayout);
								this.add(jpControl, BorderLayout.NORTH);
								jpControl.setBackground(Color.white);
							}
							{
								abuiAddressBar = new AddressBarUI();
								jpControl.add(abuiAddressBar, new GridBagConstraints(0, -1, 1, 1, 0.86, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								abuiAddressBar.setPreferredSize(new java.awt.Dimension(860, 28));
								abuiAddressBar.setBackground(Color.white);
							}
							{
								auiAuthentification = new AuthenticationUI();
								jpControl.add(auiAuthentification, new GridBagConstraints(1, -1, 1, 1, 0.1, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								auiAuthentification.setPreferredSize(new java.awt.Dimension(100, 28));
							}
							
							{
								jspMain = new JSplitPane();
								this.add(jspMain, BorderLayout.CENTER);
								jspMain.setOrientation(JSplitPane.VERTICAL_SPLIT);
								jspMain.setOneTouchExpandable(true);
								jspMain.setPreferredSize(new java.awt.Dimension(798, 580));
								jspMain.setResizeWeight(0.80);
									{
										miuiMainInterface = new MainUI();
										jspMain.add(miuiMainInterface, JSplitPane.TOP);
										miuiMainInterface.setPreferredSize(new java.awt.Dimension(798, 480));
										miuiMainInterface.setSize(798, 480);
									}
									{
										cshuiContextSensitiveHelp = new ContextSensitiveHelpUI();
										jspMain.add(cshuiContextSensitiveHelp, JSplitPane.BOTTOM);
										cshuiContextSensitiveHelp.setPreferredSize(new java.awt.Dimension(798, 83));
										cshuiContextSensitiveHelp.setSize(798, 80);
										cshuiContextSensitiveHelp.setMinimumSize(new java.awt.Dimension(800, 20));
									}
							}
							
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
			
		@SuppressWarnings("serial")
		public class RescaleAction extends AbstractAction
			{
				public RescaleAction(float factor)
					{
						this.factor = factor;
					}
					
				@Override
				public void actionPerformed(ActionEvent e)
					{
						DefaultGOSettings.rescale(factor);
						miuiMainInterface.getViewUI().refresh();
					}
					
				public final float factor;
			}
			
		/**
		 * Initializes all application wide shortcuts
		 */
		@SuppressWarnings("serial")
		private void initGlobalShortcuts()
			{
				AbstractAction action = new RescaleAction(0.05F);
				GlobalKeyboardShortcut.dispatcher().register(KeyEvent.VK_EQUALS, KeyEvent.CTRL_DOWN_MASK, action);
				GlobalKeyboardShortcut.dispatcher().register(KeyEvent.VK_PLUS, KeyEvent.CTRL_DOWN_MASK, action);
				GlobalKeyboardShortcut.dispatcher().register(KeyEvent.VK_MINUS, KeyEvent.CTRL_DOWN_MASK, new RescaleAction(-0.05F));
				GlobalKeyboardShortcut.dispatcher().register(KeyEvent.VK_0, KeyEvent.CTRL_DOWN_MASK, new RescaleAction(0.0F));
				GlobalKeyboardShortcut.dispatcher().register(KeyEvent.VK_F5, 0, new AbstractAction()
					{
						@Override
						public void actionPerformed(ActionEvent arg0)
							{
								miuiMainInterface.getViewUI().refresh();
							}
					});
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
			
		public final AddressBarUI getAbuiAddressBar()
			{
				return abuiAddressBar;
			}
			
		public final AuthenticationUI getAuiAuthentification()
			{
				return auiAuthentification;
			}
			
		public final ContextSensitiveHelpUI getCshuiContextSensitiveHelp()
			{
				return cshuiContextSensitiveHelp;
			}
			
		public final PathwaySpaceUI getPathwaySpaceUI()
			{
				return miuiMainInterface.getViewUI().getPathwaySpaceUI();
			}
			
		public final ViewUI getViewUI()
			{
				return miuiMainInterface.getViewUI();
			}
			
		public final MainUI getMainUI()
			{
				return miuiMainInterface;
			}
			
		protected void redicrectSystemStreams()
			{
				System.setOut(new PrintStream(consoleStream, true));
				System.setErr(new PrintStream(errorStream, true));
				AWTLogger.LOGGER.install();
			}
			
		@Override
		public EffectopediaFrame getFrame()
			{
				return this;
			}
			
		public static final TextAreaStream	consoleStream	= new TextAreaStream();
		public static final TextAreaStream	errorStream			= new TextAreaStream();
		public static String[]													commandLineParameters;
		private GUINavigator															navigator;
		
	}

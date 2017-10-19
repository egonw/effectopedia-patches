package org.qsari.effectopedia.gui.fx;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.qsari.effectopedia.core.ui.WebViewPanel;

import com.sun.javafx.application.PlatformImpl;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * SwingFXWebView
 */
public class FXWebViewPanel extends JPanel implements WebViewPanel, ComponentListener
	{
		private String				url	= null;
		// private Stage stage;
		private WebView			browser;
		private JFXPanel		jfxPanel;
		private JButton			swingButton;
		private WebEngine	webEngine;
		
		public FXWebViewPanel()
			{
				initComponents();
			}
		
		public static void main(String... args)
			{
				// Run this later:
				SwingUtilities.invokeLater(new Runnable()
					{
						@Override
						public void run()
							{
								final JFrame frame = new JFrame();
								
								frame.getContentPane().add(new FXWebViewPanel());
								frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								frame.pack();
								frame.setVisible(true);
							}
					});
			}
		
		private void initComponents()
			{
				
				jfxPanel = new JFXPanel();
			
				setLayout(new BorderLayout());
				add(jfxPanel, BorderLayout.CENTER);
				
				swingButton = new JButton();
				swingButton.addActionListener(new ActionListener()
					{
						
						@Override
						public void actionPerformed(ActionEvent e)
							{
								Platform.runLater(new Runnable()
									{
										
										@Override
										public void run()
											{
												webEngine.reload();
												System.out.print(browser.getWidth());
											}
									});
							}
					});
				swingButton.setText("Reload");
				
				add(swingButton, BorderLayout.SOUTH);
				this.addComponentListener(this);
			}
		
		public void load(String url)
			{
				this.url = url;
				if ((url != null) && (url.length() > 0))
					if (webEngine != null)
						webEngine.load(url);
					else
						createScene();
			}
		
		/**
		 * createScene
		 * 
		 * Note: Key is that Scene needs to be created and run on "FX user thread" NOT
		 * on the AWT-EventQueue Thread
		 * 
		 */
		private void createScene()
			{
				PlatformImpl.startup(new Runnable()
					{
						@Override
						public void run()
							{
								
								// stage = new Stage();
								
								// stage.setTitle("Hello Java FX");
								// stage.setResizable(true);
								// stage.setMinWidth(1000);
								// System.out.print(stage.getWidth());
								
								Group root = new Group();
								Scene scene = new Scene(root, 1080, 200);
								
								// stage.setScene(scene);
								
								// Set up the embedded browser:
								browser = new WebView();
								webEngine = browser.getEngine();
								// webEngine.load("https://aopkb.org/aopwiki/index.php/Event:36");
								// webEngine.load("http://effectopedia.org/rev/content/Methods_HPG.xhtml");
								// webEngine.load("http://en.m.wikipedia.org/wiki/Estrogen_receptor");
								webEngine.load(url);
								ObservableList<Node> children = root.getChildren();
								children.add(browser);
								
								jfxPanel.setScene(scene);
							}
					});
			}
		
		private void reload()
			{
				Platform.runLater(new Runnable()
					{
						
						@Override
						public void run()
							{
								
								webEngine.reload();
								System.out.print(browser.getWidth());
							}
					});
				
			}
		
		@Override
		public void componentHidden(ComponentEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		
		@Override
		public void componentMoved(ComponentEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		
		@Override
		public void componentResized(ComponentEvent e)
			{
				if (browser != null)
					{
						browser.setPrefSize(getWidth(), getHeight());
						reload();
					}
			}
		
		@Override
		public void componentShown(ComponentEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		
		static
			{
		/*		Platform.setImplicitExit(false);
				Runtime.getRuntime().addShutdownHook(new Thread()
					{
						public void run()
							{
								System.out.println("Exit Platform FX");
								Platform.exit();
								System.exit(0);
							}
					});*/
			}
	}

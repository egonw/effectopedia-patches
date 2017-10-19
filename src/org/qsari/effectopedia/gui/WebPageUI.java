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
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.nav.RedirectorTextPane;

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
public class WebPageUI extends ContextSensitivePanel implements AdjustableUI
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		private JPanel												jpStatus;
		private JTextPane									jtpRedirect;
		private JPanel												jpRedirect;
		private JLabel												jlStatus;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new WebPageUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public class JImagePanel extends javax.swing.JPanel
			{
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
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
										URL url = WebPageUI.class.getResource(imageFileName);
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
		
		public WebPageUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("web_page");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						GridBagLayout thisLayout = new GridBagLayout();
						thisLayout.rowWeights = new double[]
							{ 0.2, 0 };
						thisLayout.rowHeights = new int[]
							{ 20, 1 };
						thisLayout.columnWeights = new double[]
							{ 0.1 };
						thisLayout.columnWidths = new int[]
							{ 7 };
						this.setLayout(thisLayout);
						this.setPreferredSize(new java.awt.Dimension(500, 300));
							{
								jpRedirect = new JPanel();
								this.add(jpRedirect, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
								jpRedirect.setBackground(Color.white);
									{
										jtpRedirect = new JTextPane();
										jpRedirect.add(jtpRedirect);
										jtpRedirect.setPreferredSize(new java.awt.Dimension(500, 200));
										jtpRedirect.setContentType("text/html");
										jtpRedirect.setEditable(false);
										RedirectorTextPane redirector = new RedirectorTextPane(jtpRedirect);
										redirector.addTarget("viewUIL", UILocations.viewUIL);
										jtpRedirect.addHyperlinkListener(redirector);
										jtpRedirect.setFont(new java.awt.Font("Tahoma", 0, 14));
										jtpRedirect.setText("");
									}
							}
							{
								jpStatus = new JPanel();
								BorderLayout jpVersionLayout = new BorderLayout();
								jpStatus.setLayout(jpVersionLayout);
								this.add(jpStatus, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jpStatus.setPreferredSize(new java.awt.Dimension(400, 15));
								jpStatus.setBackground(DefaultGOSettings.uiSelectedColor);
									{
										jlStatus = new JLabel();
										jpStatus.add(jlStatus, BorderLayout.CENTER);
										jlStatus.setText("online");
										jlStatus.setHorizontalAlignment(SwingConstants.RIGHT);
										jlStatus.setFont(new java.awt.Font("Dialog", 0, 10));
										jlStatus.setBackground(DefaultGOSettings.uiSelectedColor);
										jlStatus.setMaximumSize(new java.awt.Dimension(0, 16));
									}
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
		
	}

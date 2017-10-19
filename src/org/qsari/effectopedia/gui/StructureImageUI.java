package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.util.StructureImage;
import org.qsari.effectopedia.gui.util.StructureImage.StructureImageListener;

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
public class StructureImageUI extends ContextSensitivePanel implements AdjustableUI, ActionListener, ComponentListener, StructureImageListener, LoadableEditorUI
	{
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new StructureImageUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public StructureImageUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("diagram");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						this.setPreferredSize(new java.awt.Dimension(120, 142));
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBorder(BorderFactory.createTitledBorder(null, "2D Structure Diagram", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12)));
						this.setBackground(new java.awt.Color(255, 255, 255));
						this.addComponentListener(this);
							{
								jtfImageURL = new JTextField();
								jtfImageURL.addActionListener(this);
								this.add(jtfImageURL, BorderLayout.NORTH);
								jtfImageURL.setPreferredSize(new java.awt.Dimension(110, 16));
							 jtfImageURL.setVisible(false);
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		@Override
		public void imageLoaded(EventObject evt)
			{
				repaint();
			}
		
		public void paintComponent(Graphics g)
			{
				Graphics2D g2 = (Graphics2D) g;
				int offset = jtfImageURL.isVisible() ? jtfImageURL.getHeight() << 1 : 0;
				bounds.setBounds(0, offset, getWidth(), getHeight() - offset);
				g2.setColor(Color.WHITE);
				g2.fillRect(0, 0, getWidth(), getHeight());
				if (image != null)
					image.paint(g2, bounds);
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
				setVisible((visualOptions & CHEM2DIMAGE) != 0);
			}
		
		public void actionPerformed(ActionEvent event)
			{
				structure2DImage.setValue(jtfImageURL.getText());
				if (image != null)
					{
						image.setUrl(jtfImageURL.getText());
						image.loadImage();
						repaint();
					}
			}
		
		public void loadImage()
			{
				if (image != null)
					image.loadImage();
				repaint();
			}
		
		@Override
		public void componentHidden(ComponentEvent e)
			{
			}
		
		@Override
		public void componentMoved(ComponentEvent e)
			{
			}
		
		@Override
		public void componentResized(ComponentEvent e)
			{
				if (image != null)
					image.loadImage();
				loadImage();
			}
		
		@Override
		public void componentShown(ComponentEvent e)
			{
			}
		
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof ObjectProperty))
					return;
				structure2DImage = (ObjectProperty) o;
				jtfImageURL.setText(structure2DImage.getDisplayValue());
				image = new StructureImage(structure2DImage.getDisplayValue());
				image.addStructureImageListener(this);
				loadImage();
			}
		
		private ObjectProperty	structure2DImage;
		private StructureImage	image;
		private Rectangle						bounds		= new Rectangle();
		private JTextField					jtfImageURL;
	}

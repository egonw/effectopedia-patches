package org.qsari.effectopedia.gui.help;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.help.BadIDException;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.InvalidHelpSetContextException;
import javax.help.JHelpContentViewer;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JViewport;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.gui.AdjustableUI;
import org.qsari.effectopedia.gui.AdjustbleUserInterfaceTools;

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
public class ContextSensitiveHelpUI extends javax.swing.JPanel implements AdjustableUI
	{
		
		/**
		* 
		*/
		private static final long											serialVersionUID	= 1L;
		
		public static final String										helpsetName						= "context.hs";
		
		public static String																current										= "welcome.general";
		protected static JHelpContentViewer	helpContent;
		public static HelpSet															helpSet;
		public static HelpBroker												helpBroker;
		static
			{
				loadHelpSet();
			}
			
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new ContextSensitiveHelpUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		public ContextSensitiveHelpUI()
			{
				super();
				initGUI();
			}
			
		private static void loadHelpSet()
			{
				if (helpSet != null)
					return;
				try
					{
						ClassLoader cl = Effectopedia.class.getClassLoader();
						URL url = HelpSet.findHelpSet(cl, helpsetName);
						helpSet = new HelpSet(cl, url);
					}
				catch (Exception ee)
					{
						// ee.printStackTrace();
						// JOptionPane.showMessageDialog(EffectopediaUI.frame, "Help Set " +
						// helpsetName + " not found");
						System.out.println("Help Set " + helpsetName + " not found");
						return;
					}
				catch (ExceptionInInitializerError ex)
					{
						System.err.println("initialization error:");
						// JOptionPane.showMessageDialog(EffectopediaUI.frame,
						// "initialization error:"+ex.getMessage());
						ex.getException().printStackTrace();
					}
				helpBroker = helpSet.createHelpBroker();
			}
			
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBackground(Color.WHITE);
						helpContent = new JHelpContentViewer(helpSet);
						this.add(helpContent, BorderLayout.CENTER);
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
			
		public static void setDefaultID()
			{
				helpBroker.setCurrentID(current);
				helpContent.setCurrentID(current);
			}
			
		public static void setCurrentID(String helpID)
			{
				if (helpID != null)
					try
						{
							helpContent.setCurrentID(javax.help.Map.ID.create(helpID, helpSet));
						}
					catch (BadIDException e)
						{
							helpContent.setCurrentID(NO_HELP);
							//System.err.println("Missing helpID:\t" + helpID);
						}
					catch (InvalidHelpSetContextException e)
						{
							// JOptionPane.showMessageDialog(EffectopediaUI.frame,
							// "Invalid Helpset");
							e.printStackTrace();
						}
			}
			
		public static String getComponnetHelpContext(Component comp, MouseEvent e)
			{
				StringBuilder componentName = new StringBuilder();
				Point cursorPosition = e.getPoint();
				if (e.getSource() == comp)
					{
						Component component = comp;
						Component subComponent = comp.getComponentAt(cursorPosition);
						componentName.append(component.getName());
						while ((subComponent != null) && (subComponent != component))
							{
								component = subComponent;
								if ((!(component instanceof JScrollPane)) && (!(component instanceof JViewport)))
									{
										componentName.append(".");
										componentName.append(component.getName());
									}
								subComponent = component.getComponentAt(cursorPosition);
							}
					}
				else
					{
						Component component = (Component) e.getSource();
						componentName.append(component.getName());
						while ((component != comp))
							{
								component = component.getParent();
								if ((!(component instanceof JSplitPane)) && (!(component instanceof JScrollPane)) && (!(component instanceof JViewport)))
									{
										componentName.insert(0, ".");
										componentName.insert(0, component.getName());
									}
							}
					}
				//System.out.println("h:" + componentName.toString());
				return componentName.toString();
			}
			
		private static String NO_HELP = "no.help";
		
	}

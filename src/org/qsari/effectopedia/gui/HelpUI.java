package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.net.URL;
import java.util.Vector;

import javax.help.BackAction;
import javax.help.FavoritesAction;
import javax.help.ForwardAction;
import javax.help.HelpAction;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.JHelp;
import javax.help.PrintAction;
import javax.help.PrintSetupAction;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;

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
public class HelpUI extends ContextSensitivePanel implements AdjustableUI, RootHelpContext
	{
		public static final String	helpsetName	= "effectopedia.hs";
		protected HelpSet										helpSet;
		protected HelpBroker							helpBroker;
		protected JHelp												help;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new HelpUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public HelpUI()
			{
				super(null);
				initGUI();
			}
		
		private void loadHelpSet()
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
						ee.printStackTrace();
						//System.out.println("Help Set " + helpsetName + " not found");
						return;
					}
				catch (ExceptionInInitializerError ex)
					{
						System.err.println("initialization error:");
						ex.getException().printStackTrace();
					}
				helpBroker = helpSet.createHelpBroker();
			}
		
		@SuppressWarnings("unused")
		private Vector<HelpAction> createDefaultActions()
			{
				Vector<HelpAction> actions = new Vector<HelpAction>(5);
				actions.add(new BackAction(help));
				actions.add(new ForwardAction(help));
				actions.add(new PrintAction(help));
				actions.add(new PrintSetupAction(help));
				actions.add(new FavoritesAction(help));
				return actions;
			}
		
		private void initGUI()
			{
				loadHelpSet();
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						setPreferredSize(defaultSize);
							{
								help = new JHelp(helpSet);
								// help.setHelpSetPresentation(new HelpSet.Presentation("Effectopedia",
								// true, false, defaultSize, new Point(0,0), "Effectopedia Help",
								// help.get, true,
								// createDefaultActions()));
								this.add(help, BorderLayout.CENTER);
								help.setCurrentID("About");
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
		
		/**
		 * 
		 */
		private static final long						serialVersionUID	= 1L;
		private static final Dimension	defaultSize						= new Dimension(400, 300);
	}

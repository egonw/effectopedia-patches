package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.ui.RedirectionObject;
import org.qsari.effectopedia.core.ui.nav.UILocations;
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
public class SearchResultsNavigatorUI extends ContextSensitivePanel
	{
		private JTextPane										jtpSearchNavigator;
		private RedirectorTextPane	redirector;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new SearchResultsNavigatorUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public SearchResultsNavigatorUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("navigator");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setPreferredSize(new java.awt.Dimension(516, 22));
						this.setBackground(Color.white);
							{
								jtpSearchNavigator = new JTextPane();
								this.add(jtpSearchNavigator, BorderLayout.CENTER);
								jtpSearchNavigator.setPreferredSize(new java.awt.Dimension(516, 21));
								jtpSearchNavigator.setContentType("text/html");
								jtpSearchNavigator.setEditable(false);
								redirector = new RedirectorTextPane(jtpSearchNavigator);
								redirector.addTarget("searchUIL", UILocations.searchUIL);
								jtpSearchNavigator.addHyperlinkListener(redirector);
							}
						
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public void load(int page)
			{
				jtpSearchNavigator.setText(buildResultsNavigtorPage(page));
			}
		
		private String buildResultsNavigtorPage(int page)
			{
				String resultsNavigator = "";
				SearchResultsUI srs = (SearchResultsUI) getParent();
				if ((srs != null) && (srs.results != null))
					{
						int cnt = srs.results.count();
						int numberOfPages = (cnt / SearchResultsUI.RESULTS_PER_PAGE) + 1;
						
						StringBuilder navigationPage = new StringBuilder();
						navigationPage.append("<html>\n<head>\n<style type='text/css'>\n<!--\na {color:#6382BF;}\nh1 {font-size: medium;}\n-->\n</style>\n</head>\n\n<body text=\"#666666\" bgcolor=\"#FCFBFA\" >");
						navigationPage.append("<table align='center' border='0' cellpadding='0' cellspacing='0' width='100%'><tr><td>");
						navigationPage.append("Page ");
						navigationPage.append(page);
						navigationPage.append("		/");
						navigationPage.append(numberOfPages);
						navigationPage.append(" of  ");
						navigationPage.append(cnt);
						navigationPage.append(" results</td><td align='right'>");
						RedirectionObject redirectorObj = new RedirectionObject(new Integer(1));
						if (page != 1)
							{
								navigationPage.append(" <a href='http://www.effectopedia.org/intreface.php?searchUIL&help=search.result.pathwayElement&par=");
								navigationPage.append(page-2);
								navigationPage.append("' style='color:#6382BF'>");
								navigationPage.append("previous");
								navigationPage.append("</a> ");
							}
						for (int i = 1; i <= numberOfPages; i++)
							{
								if (i != page)
									{
										navigationPage.append(" <a href='http://www.effectopedia.org/intreface.php?searchUIL&help=search.result.pathwayElement&par=");
										navigationPage.append(i-1);
										navigationPage.append("' style='color:#6382BF'>");
										navigationPage.append(i);
										navigationPage.append("</a> ");
									}
								else
									{
										navigationPage.append(" ");
										navigationPage.append(i);
										navigationPage.append(" ");
									}
								redirectorObj.addParameterObject(new Integer(i));
							}
						if (page != numberOfPages)
							{
								navigationPage.append(" <a href='http://www.effectopedia.org/intreface.php?searchUIL&help=search.result.pathwayElement&par=");
								navigationPage.append(page);
								navigationPage.append("' style='color:#6382BF'>");
								navigationPage.append("next");
								navigationPage.append("</a> ");
							}
						navigationPage.append("&nbsp;&nbsp;&nbsp;</td></tr></table></body>\n</html>\n");
						redirector.setObject(redirectorObj);
						resultsNavigator = navigationPage.toString();
					}
				return resultsNavigator;
			}
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
	}

package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

import org.qsari.effectopedia.core.ui.RedirectionObject;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.nav.RedirectorTextPane;
import org.qsari.effectopedia.search.SearchResult;

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
public class SearchResultUI extends ContextSensitivePanel
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		private JTextPane									jtpSearchResult;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new SearchResultUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public SearchResultUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("search_result");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						this.setPreferredSize(optimalSize);
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBackground(Color.white);
						this.setName("result");
							{
								jtpSearchResult = new JTextPane();
								this.add(jtpSearchResult, BorderLayout.CENTER);
								jtpSearchResult.setPreferredSize(optimalSize);
								jtpSearchResult.setContentType("text/html");
								jtpSearchResult.setEditable(false);
								redirector = new RedirectorTextPane(jtpSearchResult);
								redirector.addTarget("viewUIL", UILocations.viewUIL);
								redirector.addTarget("editUIL", UILocations.editUIL);
								redirector.addTarget("searchUIL", UILocations.searchUIL);
								jtpSearchResult.addHyperlinkListener(redirector);
								jtpSearchResult.setFont(new java.awt.Font("Tahoma", 0, 14));
								jtpSearchResult.setSize(optimalSize.width,optimalSize.height);
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public void load(SearchResult result)
			{
				this.result = result;
				if (result != null)
					{
						RedirectionObject ro = result.getRedirectionObject();
						redirector.setObject(ro);
						jtpSearchResult.setText(ro.getHTML());
					}
				else
					jtpSearchResult.setText(" ");
			}
		
		protected Dimension										optimalSize	= new java.awt.Dimension(672, 102);
		protected SearchResult							result;
		protected RedirectorTextPane	redirector;
	}

package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.search.SearchResult;
import org.qsari.effectopedia.search.SearchResults;

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
public class SearchResultsUI extends ContextSensitivePanel
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
				frame.getContentPane().add(new SearchResultsUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public SearchResultsUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("search_results");
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						setPreferredSize(new Dimension(400, 300));
						this.setBackground(new java.awt.Color(255, 255, 255));
						this.setBorder(BorderFactory.createTitledBorder(null, "Results", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12), DefaultGOSettings.captionColor));
							{
								jspResults = new JScrollPane();
								this.add(jspResults, BorderLayout.CENTER);
								jspResults.setBackground(Color.white);
								jspResults.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
									{
										jpResultList = new JPanel();
										jpResultList.setName("list");
										BoxLayout jpResultListLayout = new BoxLayout(jpResultList, javax.swing.BoxLayout.Y_AXIS);
										jpResultList.setLayout(jpResultListLayout);
										jspResults.setViewportView(jpResultList);
										jpResultList.setBackground(Color.white);
										initResultUIs(RESULTS_PER_PAGE);
									}
									{
										srnuiSearchNavigator = new SearchResultsNavigatorUI(rootHelpContext);
										this.add(srnuiSearchNavigator, BorderLayout.SOUTH);
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public void initResultUIs(int number)
			{
				resultUIs = new SearchResultUI[number];
				int prefferedHeight = 0;
				for (int i = 0; i < number; i++)
					{
						SearchResultUI resultUI = new SearchResultUI(rootHelpContext);
						prefferedHeight += resultUI.getPreferredSize().height;
						jpResultList.add(resultUI);
						resultUIs[i] = resultUI;
					}
				jpResultList.setPreferredSize(new Dimension(jspResults.getWidth(), prefferedHeight));
			}
		
		public void refreshResults()
			{
				for (int i = 0; i < RESULTS_PER_PAGE; i++)
					resultUIs[i].load(null);
				if (resultsArraty != null)
					{
						int offset =  (currentPage-1)*RESULTS_PER_PAGE;
						int count = resultsArraty.length - offset;
						if (count > RESULTS_PER_PAGE)
							count = RESULTS_PER_PAGE;
						for (int i = 0; i < count; i++)
							resultUIs[i].load(resultsArraty[offset + i]);
					}
				javax.swing.SwingUtilities.invokeLater(new Runnable()
					{
						public void run()
							{
								jspResults.getViewport().setViewPosition(TOPLEFT);
							}
					});
			}
		
		public void loadPage(int page)
			{
				currentPage = page;
				srnuiSearchNavigator.load(page);
				refreshResults();
			}
		
		public void load(SearchResults results)
			{
				this.results = results;
				if (results != null)
					{
						this.resultsArraty = new SearchResult[results.getItems().size()];
						resultsArraty = results.getItems().toArray(resultsArraty);
						srnuiSearchNavigator.load(1);
					}
				else
					{
						this.resultsArraty = null;
					}
				currentPage = 1;
				refreshResults();
			}
		
		protected int																				currentPage						= 0;
		private SearchResultsNavigatorUI	srnuiSearchNavigator;
		protected SearchResults										results;
		private SearchResult[]											resultsArraty;
		private JPanel																			jpResultList;
		private JScrollPane														jspResults;
		private SearchResultUI[]									resultUIs;
		public static final int										RESULTS_PER_PAGE	= 20;
		private static final Point							TOPLEFT										= new Point(0, 0);
		
	}

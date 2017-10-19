package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.Effectopedia.DataSourceChange;
import org.qsari.effectopedia.core.Effectopedia.DataSourceChangeListener;
import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Effect_Endpoint;
import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;
import org.qsari.effectopedia.core.objects.Initiator;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.DataSourceItem;
import org.qsari.effectopedia.data.DataSources;
import org.qsari.effectopedia.data.filter.FilteredIndex;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.defaults.DefaultSearchQueries;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitiveHelpUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.ref_ids_table.DataSourceListModel;
import org.qsari.effectopedia.search.SearchResult;
import org.qsari.effectopedia.search.SearchResults;
import org.qsari.effectopedia.search.SimpleSearchQuery;

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
public class SearchUI extends ContextSensitivePanel implements AdjustableUI, DataSourceChangeListener, MouseMotionListener, LoadableEditorUI, RootHelpContext
	{
		
		/**
	 * 
	 */
		private static final long												serialVersionUID	= 1L;
		
		private SearchResultsUI														sruiSearchResults;
		private JPanel																							SearchQuery;
		private JButton																						jbList;
		private JComboBox<SimpleSearchQuery>	jcbHierarhicalContext;
		private JComboBox<SimpleSearchQuery>	jcbSearchBySubcategory;
		private JPanel																							jpSearchBy;
		private JButton																						jbSearch;
		private JTextField																			jtfClause;
		private JComboBox<SimpleSearchQuery>	jcbSearchBy;
		private JLabel																							jlSearchBy;
		private JComboBox<DataSourceItem>				jcbDataSource;
		private JComboBox<SimpleSearchQuery>	jcbSearchFor;
		private JLabel																							jlSearchForCategory;
		private JLabel																							jlDataSource;
		
		private SearchableFields													searchableFields;
		private SearchableFields													subcategories;
		private SearchableFields													context;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new SearchUI());
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public SearchUI()
			{
				super(null);
				setName("search");
				initContextDependedntIDs();
				initGUI();
			}
		
		private SimpleSearchQuery getCurrentValidQuery()
			{
				SimpleSearchQuery query = (SimpleSearchQuery) jcbSearchFor.getSelectedItem();
				if (query.isValid())
					return query;
				else
					{
						query = (SimpleSearchQuery) jcbSearchBy.getSelectedItem();
						if (query.isValid())
							return query;
						else
							{
								query = (SimpleSearchQuery) jcbSearchBySubcategory.getSelectedItem();
								if ((query != null) && (query.isValid()))
									return query;
								else
									return null;
							}
					}
			}
		
		private class ExecuteSearch extends AbstractAction
			{
				/**
			 * 
			 */
				private static final long	serialVersionUID	= -4544979167628702914L;
				
				public ExecuteSearch(String actionName)
					{
						putValue(Action.NAME, actionName);
						putValue(Action.SHORT_DESCRIPTION, "...");
						InputMap imap = getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
						imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), actionName);
						getActionMap().put(actionName, this);
					}
				
				private SearchResults searchHere(DataSource source, SimpleSearchQuery query)
					{
						source.getSearchEngine().doSearch(query);
						source.getSearchEngine().getResults().setDataSource(source);
						return source.getSearchEngine().getResults();
					}
				
				public void actionPerformed(ActionEvent e)
					{
						SimpleSearchQuery query = getCurrentValidQuery();
						if (query != null)
							{
								query.setSearchPhrase(jtfClause.getText());
								Object dataSource = jcbDataSource.getSelectedItem();
								SearchResults results = new SearchResults();
								if (dataSource instanceof DataSource)
									results.addAll(searchHere((DataSource) dataSource, query));
								else if (dataSource instanceof DataSources)
									for (DataSource ds : (DataSources) dataSource)
										results.addAll(searchHere(ds, query));
								sruiSearchResults.load(results);
								sruiSearchResults.requestFocusInWindow();
							}
					}
			}
		
		private class SearchableFields implements ActionListener
			{
				public SearchableFields(JComboBox<SimpleSearchQuery> subcategory, JComboBox<SimpleSearchQuery> parentCategory)
					{
						this.subcategory = subcategory;
						// this.parentCategory = parentCategory;
						dataModels = new HashMap<SimpleSearchQuery, ComboBoxModel<SimpleSearchQuery>>();
					}
				
				public void actionPerformed(ActionEvent e)
					{
						@SuppressWarnings("unchecked")
						JComboBox<SimpleSearchQuery> cb = (JComboBox<SimpleSearchQuery>) e.getSource();
						SimpleSearchQuery query = (SimpleSearchQuery) cb.getSelectedItem();
						ComboBoxModel<SimpleSearchQuery> subModel = dataModels.get(query);
						if (subModel != null)
							{
								subcategory.setModel(subModel);
								((DefaultComboBoxModel<SimpleSearchQuery>) subModel).setSelectedItem(((DefaultComboBoxModel<SimpleSearchQuery>) subModel).getElementAt(0));
								subcategory.setVisible(true);
							}
						else
							subcategory.setVisible(false);
					}
				
				public HashMap<SimpleSearchQuery, ComboBoxModel<SimpleSearchQuery>> getDataModels()
					{
						return dataModels;
					}
				
				@SuppressWarnings("unused")
				public void setDataModels(HashMap<SimpleSearchQuery, ComboBoxModel<SimpleSearchQuery>> dataModels)
					{
						this.dataModels = dataModels;
					}
				
				public void setDataModels(ArrayList<SimpleSearchQuery> categories, ArrayList<ComboBoxModel<SimpleSearchQuery>> models)
					{
						for (int i = 0; i < categories.size(); i++)
							dataModels.put(categories.get(i), models.get(i));
					}
				
				// protected JComboBox<SimpleSearchQuery> parentCategory;
				protected JComboBox<SimpleSearchQuery>																																	subcategory;
				protected HashMap<SimpleSearchQuery, ComboBoxModel<SimpleSearchQuery>>	dataModels;
			}
		
		private void initSearchableFields()
			{
				ArrayList<SimpleSearchQuery> objects = DefaultSearchQueries.getFromDefaultComboBoxModelQueries((DefaultComboBoxModel<SimpleSearchQuery>) jcbSearchFor.getModel());
				ArrayList<ComboBoxModel<SimpleSearchQuery>> models = new ArrayList<ComboBoxModel<SimpleSearchQuery>>();
				DefaultComboBoxModel<SimpleSearchQuery> chemicalFields = new DefaultComboBoxModel<SimpleSearchQuery>(DefaultSearchQueries.getArray("DEFAULT_SEARCHABLE_SUBSTANCE_FIELDS"));
				DefaultComboBoxModel<SimpleSearchQuery> documentedKnowledgeFields = new DefaultComboBoxModel<SimpleSearchQuery>(DefaultSearchQueries.getArray("DEFAULT_SEARCHABLE_DOCUMENTEDKNOWLDEGE_FIELDS"));
				DefaultComboBoxModel<SimpleSearchQuery> pathwayFields = new DefaultComboBoxModel<SimpleSearchQuery>(DefaultSearchQueries.getArray("DEFAULT_SEARCHABLE_PATHWAY_FIELDS"));
				models.add(chemicalFields);
				models.add(pathwayFields);
				for (int i = 1; i < objects.size() - 1; i++)
					models.add(documentedKnowledgeFields);
				searchableFields.setDataModels(objects, models);
			}
		
		private void initSubcategories(SearchableFields categories, SearchableFields subcategories)
			{
				HashMap<SimpleSearchQuery, ComboBoxModel<SimpleSearchQuery>> dataModels = categories.getDataModels();
				Iterator<Map.Entry<SimpleSearchQuery, ComboBoxModel<SimpleSearchQuery>>> it = dataModels.entrySet().iterator();
				ArrayList<SimpleSearchQuery> objects = new ArrayList<SimpleSearchQuery>();
				ArrayList<ComboBoxModel<SimpleSearchQuery>> models = new ArrayList<ComboBoxModel<SimpleSearchQuery>>();
				while (it.hasNext())
					{
						Map.Entry<SimpleSearchQuery, ComboBoxModel<SimpleSearchQuery>> entry = it.next();
						DefaultComboBoxModel<SimpleSearchQuery> model = (DefaultComboBoxModel<SimpleSearchQuery>) entry.getValue();
						int count = model.getSize();
						for (int i = 0; i < count; i++)
							{
								ArrayList<SimpleSearchQuery> subCategories = DefaultSearchQueries.getQueries("DEFAULT_SEARCHABLE_CATEGORY_" + (SimpleSearchQuery) model.getElementAt(i));
								if (subCategories != null)
									{
										DefaultComboBoxModel<SimpleSearchQuery> subcat = new DefaultComboBoxModel<SimpleSearchQuery>(DefaultSearchQueries.getArray(subCategories));
										models.add(subcat);
										objects.add((SimpleSearchQuery) model.getElementAt(i));
									}
							}
					}
				subcategories.setDataModels(objects, models);
			}
		
		private class ShowList extends AbstractAction
			{
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				public void actionPerformed(ActionEvent arg0)
					{
						Object dataSource = jcbDataSource.getSelectedItem();
						SearchResults results = new SearchResults();
						if (dataSource instanceof DataSource)
							results.addAll(list((DataSource) dataSource));
						else if (dataSource instanceof DataSources)
							for (DataSource ds : (DataSources) dataSource)
								results.addAll(list(ds));
						sruiSearchResults.load(results);
						sruiSearchResults.requestFocusInWindow();
					}
				
				private SearchResults list(DataSource dataSource)
					{
						SearchResults results = new SearchResults();
						FilteredIndex index;
						switch (jcbSearchFor.getSelectedIndex())
							{
								case 0:
									index = new FilteredIndex(dataSource.getLiveIndices().getInitiators());
									index.addClassFilter(Initiator.class);
									break;
								case 1:
									index = new FilteredIndex(dataSource.getLiveIndices().getPathways());
									index.addClassFilter(Pathway.class);
									break;
								case 2:
									index = new FilteredIndex(dataSource.getLiveIndices().getEffects());
									index.addClassFilter(Effect_MolecularInitiatingEvent.class);
									break;
								case 4:
									index = new FilteredIndex(dataSource.getLiveIndices().getEffects());
									index.addClassFilter(Effect_Endpoint.class);
									break;
								default:
									index = new FilteredIndex(dataSource.getLiveIndices().getEffects());
									index.addClassFilter(Effect.class);
									break;
							}
						// index.addGenericFilter();
						index.addDefaultObjectFilter();
						EffectopediaObject[] filteredList = index.filter();
						SearchResults items = new SearchResults();
						for (EffectopediaObject eo : filteredList)
							if (eo != null)
								if (eo instanceof PathwayElement)
									{
										//System.out.println(eo.getClass().getName() + "\t" + ((PathwayElement) eo).getTitle());
										items.add(new SearchResult(((PathwayElement) eo).getSearchableItem()));
									}
								else if (eo instanceof Pathway)
									items.add(new SearchResult(((Pathway) eo).getSearchableItem()));
						items.setDataSource(dataSource);
						results.addAll(items);
						return results;
					}
			}
		
		private void initGUI()
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.addMouseMotionListener(this);
						this.setName("search");
						setPreferredSize(new Dimension(400, 300));
							{
								SearchQuery = new JPanel();
								SearchQuery.setName("query");
								GridBagLayout SearchQueryLayout = new GridBagLayout();
								SearchQueryLayout.rowWeights = new double[]
									{ 0.1, 0.1, 0.0, 0.1 };
								SearchQueryLayout.rowHeights = new int[]
									{ 7, 7, 13, 7 };
								SearchQueryLayout.columnWeights = new double[]
									{ 0.0, 0.1, 0.0, 0.0, 0.0, 0.0 };
								SearchQueryLayout.columnWidths = new int[]
									{ 72, 7, 47, 90, 7, 7 };
								SearchQuery.setLayout(SearchQueryLayout);
								this.add(SearchQuery, BorderLayout.NORTH);
								SearchQuery.setPreferredSize(new java.awt.Dimension(454, 111));
								SearchQuery.setBorder(BorderFactory.createTitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12),
										DefaultGOSettings.captionColor));
									{
										jlDataSource = new JLabel();
										jlDataSource.setName("datasource");
										SearchQuery.add(jlDataSource, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jlDataSource.setText("Data source: ");
										jlDataSource.setHorizontalAlignment(SwingConstants.TRAILING);
										jlDataSource.setFont(new java.awt.Font("Segoe UI", 0, 11));
									}
									{
										jlSearchForCategory = new JLabel();
										jlSearchForCategory.setName("category");
										SearchQuery.add(jlSearchForCategory, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jlSearchForCategory.setText("Search for: ");
										jlSearchForCategory.setHorizontalAlignment(SwingConstants.TRAILING);
										jlSearchForCategory.setFont(new java.awt.Font("Segoe UI", 0, 11));
									}
									{
										ComboBoxModel<SimpleSearchQuery> jcbSearchForModel = new DefaultComboBoxModel<SimpleSearchQuery>(DefaultSearchQueries.getArray("DEFAULT_SEARCHABLE_OBJECTS"));
										jcbSearchFor = new JComboBox<SimpleSearchQuery>();
										jcbSearchFor.setName("jcbSearchFor");
										jcbSearchFor.addMouseMotionListener(this);
										SearchQuery.add(jcbSearchFor, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jcbSearchFor.setModel(jcbSearchForModel);
										jcbSearchFor.setPreferredSize(new java.awt.Dimension(24, 18));
										jcbSearchFor.setFont(new java.awt.Font("Segoe UI", 0, 11));
									}
									{
										DataSourceListModel dslmDataSourceModel = new DataSourceListModel(Effectopedia.EFFECTOPEDIA.getAvailableDataSources(), true);
										Effectopedia.EFFECTOPEDIA.addDataSourceChangeListener(this);
										jcbDataSource = new JComboBox<DataSourceItem>();
										jcbDataSource.setName("datasource");
										jcbDataSource.addMouseMotionListener(this);
										SearchQuery.add(jcbDataSource, new GridBagConstraints(1, 0, 5, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jcbDataSource.setModel(dslmDataSourceModel);
										jcbDataSource.setPreferredSize(new java.awt.Dimension(24, 18));
										jcbDataSource.setFont(new java.awt.Font("Segoe UI", 0, 11));
									}
									{
										jlSearchBy = new JLabel();
										jlSearchBy.setName("by");
										SearchQuery.add(jlSearchBy, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jlSearchBy.setText("by: ");
										jlSearchBy.setHorizontalAlignment(SwingConstants.TRAILING);
										jlSearchBy.setFont(new java.awt.Font("Segoe UI", 0, 11));
									}
									{
										jpSearchBy = new JPanel();
										BoxLayout jPanel1Layout = new BoxLayout(jpSearchBy, javax.swing.BoxLayout.X_AXIS);
										jpSearchBy.setLayout(jPanel1Layout);
										SearchQuery.add(jpSearchBy, new GridBagConstraints(3, 1, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jpSearchBy.setSize(175, 18);
										jpSearchBy.setPreferredSize(new java.awt.Dimension(10, 18));
											{
												jcbSearchBy = new JComboBox<SimpleSearchQuery>();
												searchableFields = new SearchableFields(jcbSearchBy, null);
												initSearchableFields();
												jcbSearchFor.addActionListener(searchableFields);
												SimpleSearchQuery selectedItem = (SimpleSearchQuery) jcbSearchFor.getSelectedItem();
												ComboBoxModel<SimpleSearchQuery> jcbSearchByModel = searchableFields.getDataModels().get(selectedItem);
												jpSearchBy.add(jcbSearchBy);
												jpSearchBy.setName("by");
												jpSearchBy.addMouseMotionListener(this);
												
												jcbSearchBy.setModel(jcbSearchByModel);
												jcbSearchBy.setPreferredSize(new java.awt.Dimension(83, 18));
												jcbSearchBy.setFont(new java.awt.Font("Segoe UI", 0, 11));
												jcbSearchBy.setSize(90, 18);
												jcbSearchBy.setName("field");
												jcbSearchBy.addMouseMotionListener(this);
												
											}
											{
												jcbSearchBySubcategory = new JComboBox<SimpleSearchQuery>();
												jcbSearchBySubcategory.setName("subcategory");
												jcbSearchBySubcategory.addMouseMotionListener(this);
												
												subcategories = new SearchableFields(jcbSearchBySubcategory, jcbSearchFor);
												initSubcategories(searchableFields, subcategories);
												jcbSearchBy.addActionListener(subcategories);
												ComboBoxModel<SimpleSearchQuery> jcbSearchBySubcategoryModel = subcategories.getDataModels().get((SimpleSearchQuery) jcbSearchFor.getSelectedItem());
												if (jcbSearchBySubcategoryModel != null)
													jcbSearchBySubcategory.setModel(jcbSearchBySubcategoryModel);
												jcbSearchBySubcategory.setVisible(jcbSearchBySubcategoryModel != null);
												jpSearchBy.add(jcbSearchBySubcategory);
												jcbSearchBySubcategory.setFont(new java.awt.Font("Segoe UI", 0, 11));
												jcbSearchBySubcategory.setPreferredSize(new java.awt.Dimension(84, 18));
											}
											
											{
												jcbHierarhicalContext = new JComboBox<SimpleSearchQuery>();
												context = new SearchableFields(jcbHierarhicalContext, jcbSearchBySubcategory);
												initSubcategories(subcategories, context);
												jcbSearchBy.addActionListener(context);
												ComboBoxModel<SimpleSearchQuery> jcbHierarhicalContextModel = context.getDataModels().get((SimpleSearchQuery) jcbSearchBySubcategory.getSelectedItem());
												if (jcbHierarhicalContextModel != null)
													jcbHierarhicalContext.setModel(jcbHierarhicalContextModel);
												jcbHierarhicalContext.setVisible(jcbHierarhicalContextModel != null);
												jpSearchBy.add(jcbHierarhicalContext);
												jcbHierarhicalContext.setFont(new java.awt.Font("Segoe UI", 0, 11));
												jcbHierarhicalContext.setPreferredSize(new java.awt.Dimension(84, 18));
											}
										
									}
									{
										jtfClause = new JTextField();
										jtfClause.setName("clause");
										jtfClause.addMouseMotionListener(this);
										SearchQuery.add(jtfClause, new GridBagConstraints(0, 3, 4, 1, 0.8, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
										jtfClause.setPreferredSize(new java.awt.Dimension(6, 18));
									}
									{
										jbSearch = new JButton(new ExecuteSearch("Search"));
										SearchQuery.add(jbSearch, new GridBagConstraints(4, 3, 1, 1, 0.1, 0.0, GridBagConstraints.SOUTHEAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
										jbSearch.setText("Search");
										jbSearch.setName("search");
										jbSearch.addMouseMotionListener(this);
										jbSearch.setPreferredSize(new java.awt.Dimension(60, 18));
										// jbSearch.addActionListener();
									}
									{
										listAction = new ShowList();
										jbList = new JButton(listAction);
										SearchQuery.add(jbList, new GridBagConstraints(5, 3, 1, 1, 0.1, 0.0, GridBagConstraints.SOUTHEAST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
										jbList.setText("List");
										jbList.setPreferredSize(new java.awt.Dimension(60, 18));
									}
								
							}
							{
								sruiSearchResults = new SearchResultsUI(rootHelpContext);
								sruiSearchResults.setName("results");
								this.add(sruiSearchResults, BorderLayout.CENTER);
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
		
		@Override
		public void dataSourceChanged(DataSourceChange evt)
			{
				ComboBoxModel<DataSourceItem> jcbDataSourceModel = new DefaultComboBoxModel<DataSourceItem>((DataSourceItem[]) Effectopedia.EFFECTOPEDIA.dataSources());
				jcbDataSource.setModel(jcbDataSourceModel);
				jcbDataSourceModel.setSelectedItem(Effectopedia.EFFECTOPEDIA.getData());
			}
		
		@Override
		public void mouseDragged(MouseEvent e)
			{
			}
		
		@Override
		public void mouseMoved(MouseEvent e)
			{
				StringBuilder componentName = new StringBuilder();
				Point cursorPosition = e.getPoint();
				if (e.getSource() == this)
					{
						Component component = this;
						Component subComponent = getComponentAt(cursorPosition);
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
						while ((component != this))
							{
								component = component.getParent();
								if ((!(component instanceof JScrollPane)) && (!(component instanceof JViewport)))
									{
										componentName.insert(0, ".");
										componentName.insert(0, component.getName());
									}
							}
					}
				if (!helpID.equals(componentName.toString()))
					{
						helpID = componentName.toString();
						//System.out.println(helpID + getContext(helpID));
						ContextSensitiveHelpUI.setCurrentID(helpID + getContext(helpID));
					}
			}
		
		private void initContextDependedntIDs()
			{
				if (contextDependentIDs != null)
					return;
				contextDependentIDs = new HashSet<String>();
				contextDependentIDs.add("search.query");
				contextDependentIDs.add("search.query.clause");
				contextDependentIDs.add("search.query.by");
				contextDependentIDs.add("search.query.by.field");
			}
		
		private String getContext(String helpID)
			{
				if (contextDependentIDs.contains(helpID))
					{
						int index = jcbSearchFor.getSelectedIndex();
						if (index < 0)
							return "";
						int i = jcbSearchBy.getSelectedIndex();
						if (i < 0)
							return "";
						return SEARCH_FOR[index] + SEARCH_BY[index][i];
					}
				return "";
			}
		
		public void load(Object o, boolean readonly)
			{
				if (o != null)
					sruiSearchResults.loadPage((Integer) o);
				else
					SwingUtilities.invokeLater(new Runnable()
						{
							@Override
							public void run()
								{
									listAction.actionPerformed(null);
								}
						});
			}
		
		private ShowList																listAction;
		private String																		helpID					= "search.query";
		private static final String[]			SEARCH_FOR	=
																																														{ "-chemical", "-aop", "-effect" };
		private static final String[][]	SEARCH_BY		=
																																														{
																																															{ ".cas", ".name", ".smiles", ".formula" },
																																															{ ".title", ".keywords" },
																																															{ ".title", ".keywords", ".group", ".context" } };
		
		private HashSet<String>									contextDependentIDs;
		
	}

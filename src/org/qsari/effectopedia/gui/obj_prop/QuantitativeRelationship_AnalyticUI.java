package org.qsari.effectopedia.gui.obj_prop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.JTableHeader;
import javax.swing.text.Document;

import org.qsari.effectopedia.core.objects.DiscussionTopic;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.data.quantification.AnalyticFunction;
import org.qsari.effectopedia.data.quantification.AnalyticFunctionTableModel;
import org.qsari.effectopedia.data.quantification.DataSeries;
import org.qsari.effectopedia.data.quantification.DataTemplate;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship_Analytic;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship_Linear;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship_Threshold;
import org.qsari.effectopedia.data.quantification.ModifiableTableModel;
import org.qsari.effectopedia.defaults.DefaultServerSettings;
import org.qsari.effectopedia.gui.AdjustableUI;
import org.qsari.effectopedia.gui.SizeOptimizableUI;
import org.qsari.effectopedia.gui.WelcomeUI;
import org.qsari.effectopedia.gui.chart.ChartDataSeries;
import org.qsari.effectopedia.gui.chart.ChartPanel;
import org.qsari.effectopedia.gui.chart.ChartTemplate;
import org.qsari.effectopedia.gui.comp.EventsManager;
import org.qsari.effectopedia.gui.comp.GlobalUpdateTracker.ObjectUpdateListener;
import org.qsari.effectopedia.gui.comp.custom_table_header.GroupableTableHeader;
import org.qsari.effectopedia.gui.comp.custom_table_header.TableHeaderEditorManager;
import org.qsari.effectopedia.gui.core.ClipboardTransferableUI;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI;
import org.qsari.effectopedia.gui.toolbars.ListEditorToolbarUI.ListEditorActionListener;
import org.qsari.effectopedia.gui.util.ClipboardUtilities;
import org.qsari.effectopedia.system.AuthenticationManager.UserSignInListener;
import org.qsari.effectopedia.system.AuthenticationManager.UserSignOutListener;

/**
 * The Class QuantitativeRelationship_NonlinearUI.
 * 
 * @version 1.1 @(#)QuantitativeRelationship_NonlinearUI.java 1.1
 * @author Hristo Aladjov
 */
public class QuantitativeRelationship_AnalyticUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, SizeOptimizableUI, ClipboardTransferableUI, ListEditorActionListener,
		UserSignInListener, UserSignOutListener, TableModelListener, ObjectUpdateListener, KeyListener, ActionListener
	{
		
		/**
	 * 
	 */
		private static final long								serialVersionUID	= 1L;
		
		/** The scrollpane containing the data points table . */
		private JScrollPane														jspFnParameters;
		private JPanel																			jpFunction;
		private ListEditorToolbarUI						letuiFnParameters;
		private JSplitPane															jspRelationship;
		
		/**
		 * The data points table is a list of treatment levels and corresponding
		 * effect levels.
		 */
		private JTable																			jtFnParameters;
		private TableHeaderEditorManager	manager;
		private ChartPanel															cpChart;
		
		private JPanel																			jpOptions;
		// JPanel jpOptions components
		private JTextField															jtfApplicabilityLowerRange;
		private JLabel																			jlApplicabilityRange;
		private JLabel																			jlExpression;
		private JTextField															jtfReferences;
		private JEditorPane														jepDescription;
		private JScrollPane														jspDescription;
		private JTextField															jtfExpression;
		private JLabel																			jlxUnit;
		private JLabel																			jl;
		private JTextField															jtfApplicabilityUpperRange;
		private JCheckBox																jcbDefineUncertainty;
		private JTextField															jtfUncertaintyType;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame. Used
		 * for test purposes only.
		 * 
		 * @param args
		 *         the main program arguments
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new QuantitativeRelationship_AnalyticUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		/**
		 * Instantiates a new <code>QuantitativeRelationshipUI</code> with the default
		 * title.
		 */
		public QuantitativeRelationship_AnalyticUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				initGUI();
			}
		
		/**
		 * Instantiates a new <code>QuantitativeRelationshipUI</code>.
		 */
		public QuantitativeRelationship_AnalyticUI(String title,RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				titledBorder.setTitle(title);
				initGUI();
			}
		
		protected void initChart()
			{
			}
		
		/**
		 * Inits the gui.
		 */
		@SuppressWarnings("serial")
		private void initGUI()
			{
				try
					{
						this.setPreferredSize(new java.awt.Dimension(560, 312));
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						this.setBorder(titledBorder);
						this.setBackground(Color.WHITE);
							{
								jspRelationship = new JSplitPane();
								this.add(jspRelationship, BorderLayout.CENTER);
								jspRelationship.setPreferredSize(optimalSize);
								jspRelationship.setBackground(Color.WHITE);
								jspRelationship.setDividerLocation(200);
								jspRelationship.setResizeWeight(0.5);
									{
										jpFunction = new JPanel();
										jpFunction.setMinimumSize(minimumSize);
										jpFunction.setName("function");
										
										jspRelationship.add(jpFunction, JSplitPane.LEFT);
										BorderLayout jpDataPointsLayout = new BorderLayout();
										jpFunction.setLayout(jpDataPointsLayout);
										jpFunction.setPreferredSize(new java.awt.Dimension(140, 170));
											{
												jspFnParameters = new JScrollPane();
												jpFunction.add(jspFnParameters, BorderLayout.CENTER);
													{
														jtFnParameters = new JTable()
															{
																protected JTableHeader createDefaultTableHeader()
																	{
																		return new GroupableTableHeader(columnModel);
																	}
															};
														initializeTableHeader();
														jspFnParameters.setViewportView(jtFnParameters);
														jspFnParameters.getViewport().setBackground(Color.WHITE);
														jspFnParameters.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
														jspFnParameters.setMinimumSize(minimumSize);
														jtFnParameters.setMinimumSize(minimumSize);
														jtFnParameters.setName("parameters");
														jtFnParameters.addMouseMotionListener(rootHelpContext);
														manager = new TableHeaderEditorManager(jtFnParameters);
													}
											}
											{
												jpOptions = new JPanel();
												initOptions(jpOptions);
												jpFunction.add(jpOptions, BorderLayout.SOUTH);
												jpOptions.setName("options");
											}
									}
									{
										cpChart = new ChartPanel();
										cpChart.setPreferredSize(new java.awt.Dimension(240, 200));
										jspRelationship.add(cpChart, JSplitPane.RIGHT);
										cpChart.setName("chart");
									}
								RootHelpContext.addMouseMotionListeners(this, rootHelpContext,true);	
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}

		/**
		 * Initialize analytic function properties graphic user interface.
		 */
		private void initOptions(JPanel options)
			{
				try
					{
							{
								options.setPreferredSize(new java.awt.Dimension(412, 200));
								GridBagLayout thisLayout = new GridBagLayout();
								options.setBackground(Color.white);
								thisLayout.rowWeights = new double[]
									{ 0.1, 0.1, 0.1, 0.1, 0.3, 0.1 };
								thisLayout.rowHeights = new int[]
									{ 24, 20, 20, 20, 40, 20 };
								thisLayout.columnWeights = new double[]
									{ 0.3, 0.25, 0.15, 0.0, 0.15, 0.15 };
								thisLayout.columnWidths = new int[]
									{ 90, 75, 45, 12, 45, 45 };
								options.setLayout(thisLayout);
									
									{
										letuiFnParameters = new ListEditorToolbarUI(null, "parameter", ListEditorToolbarUI.ALL, FlowLayout.RIGHT);
										options.add(letuiFnParameters, new GridBagConstraints(0, 0, 6, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										letuiFnParameters.addListEditorActionListener(this);
										letuiFnParameters.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
									}
									{
										jcbDefineUncertainty = new JCheckBox("Qunatify uncertainty with:  ");
										jcbDefineUncertainty.setBackground(Color.white);
										jcbDefineUncertainty.setSelected(true);
										options.add(jcbDefineUncertainty, new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jcbDefineUncertainty.addActionListener(this);
										jcbDefineUncertainty.setName("qunatify_uncertainty");
									}
									{
										jtfUncertaintyType = new JTextField();
										jtfUncertaintyType.setBorder(BorderFactory.createEmptyBorder());
										options.add(jtfUncertaintyType, new GridBagConstraints(3, 1, 3, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jtfUncertaintyType.addKeyListener(this);
										jtfUncertaintyType.setName("uncertainty_type");
									}
									
									{
										jlApplicabilityRange = new JLabel();
										options.add(jlApplicabilityRange, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jlApplicabilityRange.setText("Applicability range:  ");
										jlApplicabilityRange.setName("applic_range");
									}
									{
										jtfApplicabilityLowerRange = new JTextField();
										options.add(jtfApplicabilityLowerRange, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jtfApplicabilityLowerRange.setText("0");
										jtfApplicabilityLowerRange.setBorder(BorderFactory.createEmptyBorder());
										jtfApplicabilityLowerRange.addKeyListener(this);
										jtfApplicabilityLowerRange.setName("applic_lo");
									}
									{
										jl = new JLabel();
										options.add(jl, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jl.setText(",");
									}
									{
										jtfApplicabilityUpperRange = new JTextField();
										options.add(jtfApplicabilityUpperRange, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jtfApplicabilityUpperRange.setText("100");
										jtfApplicabilityUpperRange.setBorder(BorderFactory.createEmptyBorder());
										jtfApplicabilityUpperRange.addKeyListener(this);
										jtfApplicabilityUpperRange.setName("applic_up");
									}
									{
										jlxUnit = new JLabel();
										options.add(jlxUnit, new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 3, 0, 0), 0, 0));
										jlxUnit.setText("[]");
										jlxUnit.setName("unit");
									}
									{
										jtfExpression = new JTextField();
										options.add(jtfExpression, new GridBagConstraints(1, 3, 5, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jtfExpression.setEnabled(false);
										jtfExpression.setBorder(BorderFactory.createEmptyBorder());
										jtfExpression.addKeyListener(this);
										jtfExpression.setName("expression");
									}
									{
										jlExpression = new JLabel();
										options.add(jlExpression, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jlExpression.setText("Expression:  ");
										jlExpression.setName("expression");
									}
									{
										jspDescription = new JScrollPane();
										options.add(jspDescription, new GridBagConstraints(0, 4, 6, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
										jspDescription.setBackground(Color.white);
										jspDescription.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
										jspDescription.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
											{
												jepDescription = new JEditorPane();
												jepDescription.setText("Describe the relationship and its parameters");
												jspDescription.setViewportView(jepDescription);
												jepDescription.setName("description");
												jepDescription.addMouseMotionListener(rootHelpContext);
											}
									}
									{
										jtfReferences = new JTextField();
										jtfReferences.setText("Reference(s)");
										options.add(jtfReferences, new GridBagConstraints(0, 5, 6, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jtfReferences.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
										jtfReferences.setName("references");
									}
									RootHelpContext.addMouseMotionListeners(jpOptions, rootHelpContext,true);
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		private void initializeTableHeader()
			{
				if (modifiableTableModel != null)
					modifiableTableModel.createHeader(jtFnParameters, manager);
			}
		
		/**
		 * Adjust <code>visible</code> properties to the current and the contained
		 * components.
		 * 
		 * @param visualOptions
		 *         an long that specifies which of the contained components are
		 *         visible
		 * 
		 * @see AdjustableUI
		 */
		public void adjustUI(long visualOptions)
		
			{
				this.setVisible((visualOptions & CONTEXT) != 0);
			}
		
		@Override
		public int listEditorActionPerformed(int actionCode)
			{
				if (modifiableTableModel == null)
					return actionCode;
				switch (actionCode)
					{
						case ListEditorToolbarUI.ADD:
							modifiableTableModel.addRow();
							if (modifiableTableModel.getRowCount() == 1)
								initializeTableHeader();
							break;
						case ListEditorToolbarUI.REMOVE:
							modifiableTableModel.removeRow(jtFnParameters.getSelectedRow());
							break;
						case ListEditorToolbarUI.RESET:
							modifiableTableModel.removeAll();
							break;
						case ListEditorToolbarUI.COPY:
							copy();
							break;
						case ListEditorToolbarUI.PASTE:
							paste();
							break;
						case ListEditorToolbarUI.DISCUSS:
							DiscussionTopic topic = DiscussionTopic.locateTopic(analyticFn.getOwner());
							if (topic != null)
								UserInterface.getDefaultNavigator().navigate(UILocations.discussUIL, topic);
							else
								{
									boolean confirmation = UserInterface.getUserConfirmation("There is no discussion associated with the current object. Do you like " + (signedIn ? "" : "to sign in and ") + "create one?");
									if (confirmation)
										if (signedIn)
											UserInterface.getDefaultNavigator().navigate(UILocations.discussUIL, DiscussionTopic.locateORCreateTopic(analyticFn.getOwner()));
										else
											{
												pendingRedirection = true;
												Component comp = (Component) UserInterface.getDefaultNavigator().navigate(UILocations.welcomeUIL, null);
												if (comp instanceof WelcomeUI)
													((WelcomeUI) comp).load(DefaultServerSettings.signInURL, false);
											}
								}
							break;
						case ListEditorToolbarUI.CHAT:
							UserInterface.showFeedback("Chat feature is not implemented yet", "Information");
							break;
					}
				jtFnParameters.revalidate();
				return actionCode;
			}
		
		public void load(Object o, boolean readonly)
			{
				if ((o == null) || (!(o instanceof AnalyticFunction)))
					return;
				// this.readonly = readonly;
				analyticFn = (AnalyticFunction) o;
				if (analyticFn instanceof FunctionalRelationship_Linear)
					titledBorder.setTitle("Linear Response");
				else if (analyticFn instanceof FunctionalRelationship_Threshold)
					titledBorder.setTitle("Threshold Response");
				docLowerApplicRange = jtfApplicabilityLowerRange.getDocument();
				listeners.unbondDocumntListener(docLowerApplicRange, "LowerApplicabilityRange");
				docUpperApplicRange = jtfApplicabilityUpperRange.getDocument();
				listeners.unbondDocumntListener(docUpperApplicRange, "UpperApplicabilityRange");
				docExpression = jtfExpression.getDocument();
				listeners.unbondDocumntListener(docExpression, "Expression");
				docUncertaintyType = jtfUncertaintyType.getDocument();
				listeners.unbondDocumntListener(docUncertaintyType, "UncertaintyType");
				Document docDescription = jepDescription.getDocument();
				listeners.unbondDocumntListener(docDescription, "Description");
				Document docReferences = jtfReferences.getDocument();
				listeners.unbondDocumntListener(docReferences, "References");
				
				// GlobalUpdateTracker.GUT.addObjectUpdateListener(this);
				
				jtfExpression.setText(analyticFn.getExpression());
				jtfExpression.setCaretPosition(0);
				jtfApplicabilityLowerRange.setText(analyticFn.getLowerApplicabilityRange().toString());
				jtfApplicabilityUpperRange.setText(analyticFn.getUpperApplicabilityRange().toString());
				jtfUncertaintyType.setText(analyticFn.getUncertaintyType());
				jtfUncertaintyType.setCaretPosition(0);
				jepDescription.setText(analyticFn.getDescription());
				jepDescription.setCaretPosition(0);
				jtfReferences.setText(analyticFn.getReferences());
				jtfReferences.setCaretPosition(0);
				
				loadTable(readonly);
				updateChart();
				letuiFnParameters.updateEditButtons(!analyticFn.isParameterListModifiable());
				jtfExpression.setEnabled(analyticFn.isParameterListModifiable());
				
				listeners.bondDocumntListener(docLowerApplicRange, analyticFn, "LowerApplicabilityRange");
				listeners.bondDocumntListener(docUpperApplicRange, analyticFn, "UpperApplicabilityRange");
				listeners.bondDocumntListener(docExpression, analyticFn, "Expression");
				listeners.bondDocumntListener(docUncertaintyType, analyticFn, "UncertaintyType");
				listeners.bondDocumntListener(docDescription, analyticFn, "Description");
				listeners.bondDocumntListener(docReferences, analyticFn, "References");
				
				updateOptimalSize();
			}
		
		@Override
		public void objectUpdated(EventObject evt)
			{
				Object source = evt.getSource();
				if ((source == docExpression) || (source == docLowerApplicRange) || (source == docUpperApplicRange))
					updateChart();
			}
		
		protected void loadTable(boolean readonly)
			{
				if (analyticFn == null)
					return;
				modifiableTableModel = analyticFn.generateTableModel();
				modifiableTableModel.addTableModelListener(this);
				jtFnParameters.setModel(modifiableTableModel);
				modifiableTableModel.createHeader(jtFnParameters, manager);
			}
		
		protected void updateChart()
			{
				boolean isFunctionalRelationship = analyticFn instanceof FunctionalRelationship_Analytic;
				cpChart.setVisible(isFunctionalRelationship);
				if (isFunctionalRelationship)
					{
						String xAxisTitle = analyticFn.getTemplates().getxAxisTitle() + " [" + analyticFn.getTemplates().getDefaultXDisplayUnit() + "]";
						String yAxisTitle = analyticFn.getTemplates().getyPrimaryAxisTitle() + " [" + analyticFn.getTemplates().getDefaultYDisplayUnit() + "]";
						String chartTitle = analyticFn.getTemplates().getChartTitle();
						ChartTemplate chartTemplate = new ChartTemplate(xAxisTitle, yAxisTitle, chartTitle);
						cpChart.reset();
						cpChart.createPrimaryAxis(chartTemplate);
						DataSeries series = ((FunctionalRelationship_Analytic) analyticFn).rebuildSeries();
						DataTemplate template = analyticFn.getTemplates().get(0);
						series.updateRanges();
						ChartDataSeries chartSeries = new ChartDataSeries(series, cpChart.primaryXAxis, cpChart.primaryYAxis, template.getMarkerType(), template.getMarkerOutlineColor());
						chartSeries.getMarker().setSize(template.getMarkerSize());
						cpChart.getPrimarySeries().add(chartSeries);
						cpChart.primaryViewport.setSeries(cpChart.getPrimarySeries());
						cpChart.repaint();
						jspRelationship.setDividerLocation(0.5);
						jspRelationship.setResizeWeight(0.5);
						jspRelationship.setDividerSize(8);
					}
				else
					{
						jspRelationship.setDividerLocation(1.0);
						jspRelationship.setResizeWeight(1.0);
						jspRelationship.setDividerSize(0);
					}
			}
		
		@Override
		public void tableChanged(TableModelEvent evt)
			{
				if (analyticFn != null)
					{
						String xUnit = analyticFn.getTemplates().getDefaultXDisplayUnit();
						if (xUnit != null)
							jlxUnit.setText(xUnit);
					}
				updateChart();
			}
		
		public void updateOptimalSize()
			{
				Insets insets = getBorder().getBorderInsets(this);
				optimalSize.width = jspRelationship.getPreferredSize().width + insets.left + insets.right;
				optimalSize.height = jpOptions.getPreferredSize().height + (jtFnParameters.getRowCount()+1) * (jtFnParameters.getRowHeight() + 2) + jtFnParameters.getTableHeader().getPreferredSize().height
						+ insets.top + insets.bottom;
				// jspRelationship.setDividerLocation(optimalSize.width / 2);
				setPreferredSize(optimalSize);
				Container parent = getParent();
				while (parent != null)
					{
						if (parent instanceof SizeOptimizableUI)
							{
								((SizeOptimizableUI) parent).updateOptimalSize();
								break;
							}
						parent = parent.getParent();
					}
			}
		
		public void copy()
			{
				if (modifiableTableModel != null)
					ClipboardUtilities.setClipboard(modifiableTableModel.getDataAsTabDelimitedText());
			}
		
		public void paste()
			{
				if (modifiableTableModel != null)
					{
						modifiableTableModel.setDataFromTabDelimitedText(ClipboardUtilities.getClipboard());
						initializeTableHeader();
					}
			}
		
		public ChartPanel getChartPanel()
			{
				return cpChart;
			}
		
		@Override
		public void userSignedOut(EventObject evt)
			{
				signedIn = false;
			}
		
		@Override
		public void userSignedIn(EventObject evt)
			{
				signedIn = true;
				if (pendingRedirection)
					{
						pendingRedirection = false;
						UserInterface.getDefaultNavigator().navigate(UILocations.discussUIL, DiscussionTopic.locateORCreateTopic(analyticFn.getOwner()));
					}
			}
		
		@Override
		public void keyPressed(KeyEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}
		
		@Override
		public void keyReleased(KeyEvent keyEvent)
			{
				int key = keyEvent.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
					{
						if (analyticFn != null)
							updateChart();
					}
			}
		
		@Override
		public void keyTyped(KeyEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}
		
		@Override
		public void actionPerformed(ActionEvent evt)
			{
				if (evt.getSource() == jcbDefineUncertainty)
					{
						boolean defineUncertainty = jcbDefineUncertainty.isSelected();
						jtfUncertaintyType.setEnabled(defineUncertainty);
						if (analyticFn != null)
							{
								AnalyticFunctionTableModel tableModel = (AnalyticFunctionTableModel) modifiableTableModel;
								
								tableModel.setDefineUncertainty(defineUncertainty);
								tableModel.createHeader(jtFnParameters, manager);
								updateChart();
							}
					}
				
			}
		
		private Document															docLowerApplicRange;
		private Document															docUpperApplicRange;
		private Document															docExpression;
		private Document															docUncertaintyType;
		private EventsManager										listeners										= new EventsManager();
		private TitledBorder											titledBorder							= BorderFactory.createTitledBorder(null, "Response-Response", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2,
																																																						12));
		private Dimension														optimalSize								= new Dimension(400, 200);
		private static final Dimension	minimumSize								= new Dimension(160, 160);
		private boolean																signedIn											= false;
		private boolean																pendingRedirection	= false;
		private AnalyticFunction							analyticFn;
		private ModifiableTableModel			modifiableTableModel;
		
	}

package org.qsari.effectopedia.gui.obj_prop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.JTableHeader;
import javax.swing.text.Document;

import org.qsari.effectopedia.core.objects.DiscussionTopic;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.quantification.AggregationFunction;
import org.qsari.effectopedia.data.quantification.DTsDispalySettingsFactory;
import org.qsari.effectopedia.data.quantification.DataSampleValueFactory;
import org.qsari.effectopedia.data.quantification.DataTemplate;
import org.qsari.effectopedia.data.quantification.DataTemplateType;
import org.qsari.effectopedia.data.quantification.DataTemplates;
import org.qsari.effectopedia.data.quantification.DataTemplatesGroupedTableModel;
import org.qsari.effectopedia.data.quantification.DataTemplatesTableModel;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship_Nonlinear;
import org.qsari.effectopedia.defaults.DefaultServerSettings;
import org.qsari.effectopedia.gui.AdjustableUI;
import org.qsari.effectopedia.gui.SizeOptimizableUI;
import org.qsari.effectopedia.gui.WelcomeUI;
import org.qsari.effectopedia.gui.chart.ChartPanel;
import org.qsari.effectopedia.gui.comp.EventsManager;
import org.qsari.effectopedia.gui.comp.custom_table_header.DefaultTableHeaderEditor.OptionsListener;
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
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
/**
 * The Class QuantitativeRelationship_NonlinearUI.
 * 
 * @version 1.1 @(#)QuantitativeRelationship_NonlinearUI.java 1.1
 * @author Hristo Aladjov
 */
public class QuantitativeRelationship_NonlinearUI extends ContextSensitivePanel
		implements AdjustableUI, LoadableEditorUI, SizeOptimizableUI, ClipboardTransferableUI, ListEditorActionListener, UserSignInListener, UserSignOutListener, TableModelListener, OptionsListener
	{
		
		/**
		* 
		*/
		private static final long								serialVersionUID	= 1L;
		
		/** The scrollpane containing the data points table . */
		private JScrollPane														jspDataPoints;
		private JPanel																			jpDataPoints;
		private ListEditorToolbarUI						jletuiDataPoints;
		private JSplitPane															jspRelationship;
		private JPanel																			jpNotes;
		
		/**
		 * The data points table is a list of treatment levels and corresponding
		 * effect levels.
		 */
		private JTable																			jtDataPoints;
		private JEditorPane														jepDescription;
		private JScrollPane														jspDescription;
		private JTextField															jtfReferences;
		private TableHeaderEditorManager	manager;
		private ChartPanel															cpChart;
		
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
				frame.getContentPane().add(new QuantitativeRelationship_NonlinearUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
			
		/**
		 * Instantiates a new <code>QuantitativeRelationshipUI</code> with the default
		 * title.
		 */
		public QuantitativeRelationship_NonlinearUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				initGUI();
			}
			
		/**
		 * Instantiates a new <code>QuantitativeRelationshipUI</code>.
		 */
		public QuantitativeRelationship_NonlinearUI(String title, RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				this.title = title;
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
						this.setBorder(BorderFactory.createTitledBorder(null, title, TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12)));
						this.setBackground(Color.WHITE);
							{
								jspRelationship = new JSplitPane();
								this.add(jspRelationship, BorderLayout.CENTER);
								jspRelationship.setPreferredSize(optimalSize);
								jspRelationship.setBackground(Color.WHITE);
								jspRelationship.setDividerLocation(200);
								jspRelationship.setResizeWeight(0.5);
									{
										jpDataPoints = new JPanel();
										jpDataPoints.setMinimumSize(minimumSize);
										jpDataPoints.setName("data");
										jspRelationship.add(jpDataPoints, JSplitPane.LEFT);
										BorderLayout jpDataPointsLayout = new BorderLayout();
										jpDataPoints.setLayout(jpDataPointsLayout);
										jpDataPoints.setPreferredSize(new java.awt.Dimension(140, 170));
											{
												jspDataPoints = new JScrollPane();
												jpDataPoints.add(jspDataPoints, BorderLayout.CENTER);
													{
														jtDataPoints = new JTable()
															{
																protected JTableHeader createDefaultTableHeader()
																	{
																		return new GroupableTableHeader(columnModel);
																	}
															};
														initializeTableHeader();
														jspDataPoints.setViewportView(jtDataPoints);
														jspDataPoints.getViewport().setBackground(Color.WHITE);
														jspDataPoints.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
														jspDataPoints.setMinimumSize(minimumSize);
														jtDataPoints.setMinimumSize(minimumSize);
														jtDataPoints.setName("table");
														manager = new TableHeaderEditorManager(jtDataPoints);
													}
											}
											{
												jletuiDataPoints = new ListEditorToolbarUI(null, "data point", ListEditorToolbarUI.ALL, FlowLayout.RIGHT);
												jpDataPoints.add(jletuiDataPoints, BorderLayout.SOUTH);
												jletuiDataPoints.addListEditorActionListener(this);
											}
									}
									{
										cpChart = new ChartPanel();
										cpChart.setPreferredSize(new java.awt.Dimension(240, 200));
										jspRelationship.add(cpChart, JSplitPane.RIGHT);
										cpChart.setName("chart");
									}
									
							}
							{
								jpNotes = new JPanel();
								BorderLayout jpNotesLayout = new BorderLayout();
								jpNotes.setLayout(jpNotesLayout);
								this.add(jpNotes, BorderLayout.SOUTH);
								jpNotes.setBackground(Color.white);
								jpNotes.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
								jpNotes.setPreferredSize(new java.awt.Dimension(546, 48));
								jpNotes.setName("notes");
									{
										jtfReferences = new JTextField();
										jpNotes.add(jtfReferences, BorderLayout.SOUTH);
										jtfReferences.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
										jtfReferences.setName("references");
									}
									{
										jspDescription = new JScrollPane();
										jpNotes.add(jspDescription, BorderLayout.CENTER);
										jspDescription.setBackground(Color.white);
										jspDescription.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
											{
												jepDescription = new JTextPane();
												jspDescription.setViewportView(jepDescription);
												jepDescription.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
												jepDescription.setName("description");
											}
									}
							}
						RootHelpContext.addMouseMotionListeners(this, rootHelpContext,true);
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
			
		private void initializeTableHeader()
			{
				if (dataTemplateTableModel != null)
					{
						dataTemplateTableModel.createHeader(jtDataPoints, manager);
						RootHelpContext.addMouseMotionListeners(jtDataPoints.getTableHeader(), rootHelpContext, true); 
					}
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
				if (dataTemplateTableModel == null)
					return actionCode;
				switch (actionCode)
					{
						case ListEditorToolbarUI.ADD:
							dataTemplateTableModel.addRow();
							if (dataTemplateTableModel.getRowCount() == 1)
								initializeTableHeader();
							break;
						case ListEditorToolbarUI.REMOVE:
							dataTemplateTableModel.removeRow(jtDataPoints.getSelectedRow());
							break;
						case ListEditorToolbarUI.RESET:
							dataTemplateTableModel.removeAll();
							break;
						case ListEditorToolbarUI.COPY:
							copy();
							break;
						case ListEditorToolbarUI.PASTE:
							paste();
							break;
						case ListEditorToolbarUI.DISCUSS:
							DiscussionTopic topic = DiscussionTopic.locateTopic(dataTemplates.getOwner());
							if (topic != null)
								UserInterface.getDefaultNavigator().navigate(UILocations.discussUIL, topic);
							else
								{
									boolean confirmation = UserInterface.getUserConfirmation("There is no discussion associated with the current object. Do you like " + (signedIn ? "" : "to sign in and ") + "create one?");
									if (confirmation)
										if (signedIn)
											UserInterface.getDefaultNavigator().navigate(UILocations.discussUIL, DiscussionTopic.locateORCreateTopic(dataTemplates.getOwner()));
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
				jtDataPoints.revalidate();
				return actionCode;
			}
			
		public void load(Object o, boolean readonly)
			{
				if (o == null)
					return;
				if (o instanceof DataTemplates)
					dataTemplates = (DataTemplates) o;
				else if (o instanceof FunctionalRelationship_Nonlinear)
					{
						((FunctionalRelationship_Nonlinear) o).setOptionsListener(this);
						dataTemplates = ((FunctionalRelationship_Nonlinear) o).getTemplates();
					}
				else if (o instanceof AggregationFunction)
					{
						dataTemplates = ((AggregationFunction) o).getTemplates();
					}
				if (dataTemplates != null)
					{
						grouping = dataTemplates.isUsingGroups();
						loadTable(readonly);
						loadNotes(readonly);
						DTsDispalySettingsFactory.getSettings(dataTemplates, dataTemplateTableModel).updateChart(cpChart);
					}
				updateOptimalSize();
			}
			
		protected void loadTable(boolean readonly)
			{
				if (dataTemplates == null)
					return;
				dataTemplates.loadObjectProperties();
				dataTemplateTableModel = grouping ? new DataTemplatesGroupedTableModel(dataTemplates, this) : new DataTemplatesTableModel(dataTemplates, this);
				dataTemplateTableModel.addTableModelListener(this);
				jtDataPoints.setModel(dataTemplateTableModel);
				updateTitle();
				dataTemplateTableModel.createHeader(jtDataPoints, manager);
				updateOptimalSize();
			}
			
		protected void updateTitle()
			{
				DataTemplateType dtt = dataTemplates.get(0).getType();
				if (dtt.getChartX() == DataSampleValueFactory.DESCR_VALUE)
					title = "Dose-Response";
				else if (dtt.getChartX() == DataSampleValueFactory.TIME)
					if (dataTemplates.isUsingGroups())
						title = "Time-Dose-Response";
					else
						title = "Time-Response";
				else if (dtt.getChartX() == DataSampleValueFactory.UPSTREAM_CAUSE)
					if (dataTemplates.isUsingGroups())
						title = "Time-Response-Response";
					else
						title = "Response-Response";
				this.setBorder(BorderFactory.createTitledBorder(null, title, TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 12)));
			}
			
		protected void loadNotes(boolean readonly)
			{
				if (dataTemplates == null)
					return;
				ObjectPropertyMultivalued_Documented op = dataTemplates.get(0).getObjProp();
				Document docDescription = jepDescription.getDocument();
				listeners.unbondDocumntListener(docDescription, "Notes");
				Document docReferences = jtfReferences.getDocument();
				listeners.unbondDocumntListener(docReferences, "DisplayReferences");
				
				jepDescription.setText(op.getNotes());
				jepDescription.setCaretPosition(0);
				jtfReferences.setText(op.getDisplayReferences());
				jtfReferences.setCaretPosition(0);
				
				listeners.bondDocumntListener(docDescription, op, "Notes");
				listeners.bondDocumntListener(docReferences, op, "DisplayReferences");
			}
			
		@Override
		public void tableChanged(TableModelEvent evt)
			{
				DTsDispalySettingsFactory.getSettings(dataTemplates, dataTemplateTableModel).updateChart(cpChart);
			}
			
		public void updateOptimalSize()
			{
				Insets insets = getBorder().getBorderInsets(this);
				optimalSize.width = jspRelationship.getPreferredSize().width + insets.left + insets.right;
				int rowsVisible = (jtDataPoints.getRowCount() < 10) ? 10 : jtDataPoints.getRowCount();
				if (rowsVisible > 16)
					rowsVisible = 16;
				optimalSize.height = rowsVisible * (jtDataPoints.getRowHeight() + 1) + jtDataPoints.getTableHeader().getPreferredSize().height + insets.top + insets.bottom + 12
						+ jpNotes.getPreferredSize().height;
				if (optimalSize.height < minimumSize.height)
					optimalSize.height = minimumSize.height;
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
				if (dataTemplateTableModel != null)
					ClipboardUtilities.setClipboard(dataTemplateTableModel.getDataAsTabDelimitedText());
			}
			
		public void paste()
			{
				if (dataTemplateTableModel != null)
					{
						dataTemplateTableModel.setDataFromTabDelimitedText(ClipboardUtilities.getClipboard());
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
						UserInterface.getDefaultNavigator().navigate(UILocations.discussUIL, DiscussionTopic.locateORCreateTopic(dataTemplates.getOwner()));
					}
			}
			
		public DataTemplatesTableModel getDataTemplateTableModel()
			{
				return dataTemplateTableModel;
			}
			
		@Override
		public void showOptions()
			{
				
				DataTemplateOptionsDialog.DIALOG.load(dataTemplates, false);
				if (DataTemplateOptionsDialog.DIALOG.isSelected())
					{
						DataTemplateType newDataTemplateType = DataTemplateOptionsDialog.DIALOG.getSelectedType();
						dataTemplates.setxAxisTitle(null);
						for (DataTemplate template : dataTemplates)
							template.setType(newDataTemplateType);
						load(dataTemplates, false);
					}
			}
			
		private String[][]														AANData															= new String[][]
			{
			{ "-11", "100", "97", "103", "", "", "", "", "", "" },
			{ "-10", "98", "93", "102", "", "", "", "", "", "" },
			{ "-9", "87", "84", "93", "", "", "", "", "", "" },
			{ "-8", "46", "39", "55", "", "", "", "", "", "" },
			{ "-7", "12", "9", "14", "", "", "", "", "", "" },
			{ "-6", "0", "0", "0", "", "", "", "", "", "" },
			{ "-5", "", "", "", "", "", "", "", "", "" },
			{ "-4", "", "", "", "95", "90", "105", "", "", "" },
			{ "-3", "", "", "", "102", "89", "115", "", "", "" },
			{ "-2.7", "", "", "", "43", "35", "50", "", "", "" },
			{ "-2.3", "", "", "", "28", "21", "41", "", "", "" },
			{ "-2", "", "", "", "19", "8", "42", "", "", "" },
			{ "-1.8", "", "", "", "8", "1", "18", "", "", "" } };
		private String[]																AANExamleColumnTitles	= new String[]
			{ "chem conc.\n(LogM)", "mean", "min", "max", "mean", "min", "max" };
		private String[]																DefaultColumnTitles			= new String[]
			{ "chem conc.\n(LogM)", "mean\nChem Name\n", "lower\nChem name\n", "upper\nChem Name" };
			
		private String[][]														DefaultEmptyTable					= new String[][]
			{
			{ "", "", "", "" },
			{ "", "", "", "" },
			{ "", "", "", "" },
			{ "", "", "", "" },
			{ "", "", "", "" },
			{ "", "", "", "" } };
		private String																		title																	= "Dose-Response";
		private Dimension															optimalSize											= new Dimension(400, 300);
		private static final Dimension		minimumSize											= new Dimension(200, 200);
		private boolean																	signedIn														= false;
		private boolean																	pendingRedirection				= false;
		private boolean																	grouping														= false;
		private DataTemplates											dataTemplates;
		private DataTemplatesTableModel	dataTemplateTableModel;
		private EventsManager											listeners													= new EventsManager();
		
	}

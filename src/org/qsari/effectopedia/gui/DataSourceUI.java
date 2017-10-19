package org.qsari.effectopedia.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.Effect_AdverseOutcome;
import org.qsari.effectopedia.core.objects.Effect_DownstreamEffect;
import org.qsari.effectopedia.core.objects.Effect_Endpoint;
import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;
import org.qsari.effectopedia.core.objects.Initiator_BiologcalPerturbation;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.Initiator_StructuralAlerts;
import org.qsari.effectopedia.core.objects.Link_ChemStructToChemStruct;
import org.qsari.effectopedia.core.objects.Link_ChemStructToMIE;
import org.qsari.effectopedia.core.objects.Link_EffectToEffect;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.Test;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.DataSourceMerge;
import org.qsari.effectopedia.gui.DataSourceEntriesTableUI.EntrySelection;
import org.qsari.effectopedia.gui.DataSourceEntriesTableUI.EntrySelectionListener;
import org.qsari.effectopedia.gui.core.DataView;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
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
public class DataSourceUI extends ContextSensitivePanel implements EntrySelectionListener

	{
		/**
	 * 
	 */
		private static final long								serialVersionUID	= -2731397001105669825L;
		private JSplitPane															jspExplorer;
		private JComponent															jpComponentViewer;
		private DataSourceEntriesTableUI	dsetuiEntriesTable;
		private TitledBorder													titleBorder;
		
		/**
		 * Auto-generated main method to display this JPanel inside a new JFrame.
		 */
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.getContentPane().add(new DataSourceUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public DataSourceUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("data_source");
				initGUI(title);
			}
		
		private void initGUI(String title)
			{
				try
					{
						BorderLayout thisLayout = new BorderLayout();
						this.setLayout(thisLayout);
						setPreferredSize(new Dimension(400, 300));
						titleBorder = BorderFactory.createTitledBorder(title);
						this.setBorder(titleBorder);
							{
								jspExplorer = new JSplitPane();
								jspExplorer.setBackground(Color.WHITE);
								jspExplorer.setOneTouchExpandable(true);
								jspExplorer.setDividerLocation(120);
								this.add(jspExplorer, BorderLayout.CENTER);
								jspExplorer.setOrientation(JSplitPane.VERTICAL_SPLIT);
								jspExplorer.setPreferredSize(new java.awt.Dimension(400, 300));
									{
										dsetuiEntriesTable = new DataSourceEntriesTableUI(rootHelpContext);
										dsetuiEntriesTable.addEntrySelectionListener(this);
										jspExplorer.add(dsetuiEntriesTable, JSplitPane.LEFT);
										dsetuiEntriesTable.setPreferredSize(new java.awt.Dimension(398, 119));
									}
								setComponentViewer(VT_PATHWAY_SPACE);
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public void synchronizeWith(DataSourceUI userInterface)
			{
				setComponentViewer(VT_PATHWAY_SPACE);
				userInterface.setComponentViewer(VT_PATHWAY_SPACE);
				psuiViewer.synchronizeWith(userInterface.getPsuiViewer());
				dsetuiEntriesTable.setSychronizedTable(userInterface.dsetuiEntriesTable);
				userInterface.dsetuiEntriesTable.setSychronizedTable(dsetuiEntriesTable);
			}
		
		public static int getViewerForClass(Class<?> objectClass)
			{
				if (objectClass == null)
					return -1;
				if (objectClass.isAssignableFrom(Initiator_ChemicalStructure.class))
					return VT_CHEMICAL_EDITOR;
				else if (objectClass.isAssignableFrom(Initiator_StructuralAlerts.class) || objectClass.isAssignableFrom(Initiator_BiologcalPerturbation.class))
					return VT_CHEMICAL_EDITOR;
				else if (objectClass.isAssignableFrom(Effect_MolecularInitiatingEvent.class) || objectClass.isAssignableFrom(Effect_DownstreamEffect.class) || objectClass.isAssignableFrom(Effect_Endpoint.class)
						|| objectClass.isAssignableFrom(Effect_AdverseOutcome.class))
					return VT_EFFECT_EDITOR;
				else if (objectClass.isAssignableFrom(Link_ChemStructToChemStruct.class))
					return VT_LINK_S2RS_EDITOR;
				else if (objectClass.isAssignableFrom(Link_ChemStructToMIE.class))
					return VT_LINK_S2MIE_EDITOR;
				else if (objectClass.isAssignableFrom(Link_EffectToEffect.class))
					return VT_LINK_E2E_EDITOR;
				else if (objectClass.isAssignableFrom(Test.class))
					return VT_TEST_EDITOR;
				else if (objectClass.isAssignableFrom(Pathway.class))
					return VT_PATHWAY_EDITOR;
				return VT_PATHWAY_SPACE;
			}
		
		public void setComponentViewer(int viewerType)
			{
				int dividerLocation = jspExplorer.getDividerLocation();
				if (jpComponentViewer != null)
					jspExplorer.remove(jpComponentViewer);
				switch (viewerType)
					{
						case VT_EFFECT_EDITOR:
							if (euiEditEffect == null)
								euiEditEffect = new EffectUI();
							jpComponentViewer = euiEditEffect;
							break;
						
						case VT_LINK_S2RS_EDITOR:
							if (lstrsuiEditLink == null)
								lstrsuiEditLink = new Link_SubstanceToReactiveSubstanceUI();
							jpComponentViewer = lstrsuiEditLink;
							break;
						
						case VT_LINK_S2MIE_EDITOR:
							if (lstmieuiEditLink == null)
								lstmieuiEditLink = new Link_SubstanceToMIEUI();
							jpComponentViewer = lstmieuiEditLink;
							break;
						
						case VT_LINK_E2E_EDITOR:
							if (leteuiEditLink == null)
								leteuiEditLink = new Link_EffectToEffectUI();
							jpComponentViewer = leteuiEditLink;
							break;
						
						case VT_CHEMICAL_EDITOR:
							if (cuiEditChemical == null)
								cuiEditChemical = new ChemicalUI();
							jpComponentViewer = cuiEditChemical;
							break;
						
						case VT_TEST_EDITOR:
							if (tuiEditTest == null)
								tuiEditTest = new InLabTestUI();
							jpComponentViewer = tuiEditTest;
							break;
						
						case VT_PATHWAY_EDITOR:
							if (epuiEditPathway == null)
								epuiEditPathway = new EditPathwayUI();
							jpComponentViewer = epuiEditPathway;
							break;
						
						default:
							if (dataSource == null)
								{
									jpComponentViewer = null;
									break;
								}
							if (psuiViewer == null)
								psuiViewer = new PathwaySpaceUI(null, null, (DataView)dataSource.getCurrentView(),rootHelpContext);
							else
								psuiViewer.setDataView((DataView)dataSource.getCurrentView());
							dataSource.getCurrentView().setDefaultViewAxis();
							jpComponentViewer = psuiViewer;
							break;
					}
				if (jpComponentViewer != null)
					jspExplorer.add(jpComponentViewer, JSplitPane.RIGHT);
				jspExplorer.setDividerLocation(dividerLocation);
			}
		
		public void loadDataSourceMerge(DataSourceMerge merge, boolean sourceA, int listMask, boolean readonly)
			{
				dsetuiEntriesTable.loadDataSourceMerge(merge, sourceA, listMask, readonly);
				dataSource = sourceA ? merge.getA() : merge.getB();
			}
		
		public void loadDataSource(DataSource data)
			{
				dsetuiEntriesTable.loadDataSource(data);
				dataSource = data;
			}
		
		public final PathwaySpaceUI getPsuiViewer()
			{
				return psuiViewer;
			}
		
		public TableRowSorter<TableModel> getSorter()
			{
				return dsetuiEntriesTable.getSorter();
			}
		
		@Override
		public void selectionChanged(EntrySelection evt)
			{
				load(evt.object);
				selectedRow = dsetuiEntriesTable.getSelectedRow();
			}
		
		public final int getViewOptions()
			{
				return viewOptions;
			}
		
		public final void setViewOptions(int viewOptions)
			{
				this.viewOptions = viewOptions;
				dsetuiEntriesTable.setViewOptions(viewOptions);
				load(dsetuiEntriesTable.getSelectedObject());
			}
		
		private void load(Object object)
			{
				if (object == null)
					{
						if ((viewOptions & VT_CHEMICAL_EDITOR) == VT_CHEMICAL_EDITOR)
							setComponentViewer(VT_NONE);
						return;
					}
				if ((viewOptions & VT_CHEMICAL_EDITOR) == VT_CHEMICAL_EDITOR)
					{
						setComponentViewer(getViewerForClass(object.getClass()));
						((LoadableEditorUI) jpComponentViewer).load(object, ((EffectopediaObject) object).isReadonly());
					}
				else
					{
						setComponentViewer(VT_PATHWAY_SPACE);
						Effectopedia.EFFECTOPEDIA.setData(dataSource);
						loadInViewer(object, ((EffectopediaObject) object).isReadonly(),dataSource);
					}
				
			}
		
		private void loadInViewer(Object o, boolean readonly, DataSource ds)
			{
				if (ds != null)
					{
						this.dataSource = ds;
						this.dataView = (DataView)ds.getCurrentView();
					}
				psuiViewer.updateDataSource(ds);
				psuiViewer.load(o, readonly, dataView);
				if (this.dataView == null)
					return;
				if (!dataView.areViewAxisInitialized())
					dataView.setDefaultViewAxis();
				else
					dataView.rebuildView();
				dataView.setReadOnly(readonly);
				dataView.getPathwaysView().reset();
				psuiViewer.dataViewChanged(null);
//				votuiToolbar.setView(dataView.getViewLayout());
				if (o instanceof Pathway)
					{
						Pathway pathway = (Pathway) o;
						dataView.clear();
						dataView.addToView(pathway);
					}
				else if (o instanceof ArrayList)
					{
						dataView.clear();
						for (Object p : (ArrayList<Object>) o)
							if (p instanceof Pathway)
								dataView.addToView((Pathway) p);
					}
				
			}
		
		public final String getTitle()
			{
				return title;
			}
		
		public final void setTitle(String title)
			{
				this.title = title;
				titleBorder.setTitle(title);
			}
		
		public final Object getSelectedObject()
			{
				return dsetuiEntriesTable.getSelectedObject();
			}
		
		public final Object getSelectedRawObject()
			{
				return dsetuiEntriesTable.getSelectedRawObject();
			}
		
		public static final int																					VT_NONE														= -1;
		
		public static final int																					VT_PATHWAY_SPACE					= 0;
		public static final int																					VT_CHEMICAL_EDITOR			= 1;
		public static final int																					VT_LINK_S2RS_EDITOR		= 2;
		public static final int																					VT_LINK_S2MIE_EDITOR	= 3;
		public static final int																					VT_LINK_E2E_EDITOR			= 4;
		public static final int																					VT_EFFECT_EDITOR					= 5;
		public static final int																					VT_TEST_EDITOR							= 6;
		public static final int																					VT_PATHWAY_EDITOR				= 7;
		
		public static final int																					VO_VISAL													= 0;
		public static final int																					VO_EDITORS											= 1;
		
		public static final int																					VO_CONFLICTS_ONLY				= 2;
		public static final int																					VO_ALL_DIFERENCES				= 4;
		public static final int																					VO_ALL															= 8;
		public static final int																					VO_WHICH													= VO_ALL | VO_ALL_DIFERENCES | VO_CONFLICTS_ONLY;
		public static final int																					VO_HIGHLIGHT									= 16;
		
		public int																																		selectedRow										= -1;
		
		private DataSource																										dataSource											= null;
		
		private int																																	viewOptions										= VO_VISAL + VO_CONFLICTS_ONLY;
		private String																														title																= "Data source name";
		private DataView																												dataView;
		private PathwaySpaceUI																						psuiViewer;
		private ChemicalUI																										cuiEditChemical;
		private Link_SubstanceToReactiveSubstanceUI	lstrsuiEditLink;
		private Link_SubstanceToMIEUI															lstmieuiEditLink;
		private Link_EffectToEffectUI															leteuiEditLink;
		private EffectUI																												euiEditEffect;
		private InLabTestUI																														tuiEditTest;
		private EditPathwayUI																							epuiEditPathway;
		
	}

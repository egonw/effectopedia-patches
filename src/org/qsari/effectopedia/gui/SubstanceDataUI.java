package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import org.qsari.effectopedia.core.objects.SubstanceData;
import org.qsari.effectopedia.core.objects.SubstanceData_InSilico;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.quantification.DataSeries;
import org.qsari.effectopedia.data.quantification.DataSeriesFactory;
import org.qsari.effectopedia.data.quantification.DataTemplates;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.gui.chart.ChartTemplate;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.obj_prop.LocalDRModelUI;
import org.qsari.effectopedia.gui.obj_prop.LocalModelUI.ExecutionListener;
import org.qsari.effectopedia.gui.obj_prop.LocalModelUI.PresetListener;
import org.qsari.effectopedia.gui.obj_prop.QuantitativeRelationship_NonlinearUI;

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
public class SubstanceDataUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, SizeOptimizableUI, ExecutionListener, PresetListener
	{
		
		public SubstanceDataUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				setName("substance_data");
				initGUI();
				adjustUI(AdjustableUI.SUBST_VIEW);
			}
		
		private void initGUI()
			{
				try
					{
							{
								this.setMinimumSize(optimalSize);
								BoxLayout thisLayout = new BoxLayout(this, javax.swing.BoxLayout.Y_AXIS);
								this.setLayout(thisLayout);
									{
										jspSubstanceData = new JSplitPane();
										this.add(jspSubstanceData);
										jspSubstanceData.setResizeWeight(0.33);
										jspSubstanceData.setBackground(Color.white);
											{
												jspSubstance = new JScrollPane();
												jspSubstanceData.add(jspSubstance, JSplitPane.LEFT);
												jspSubstance.setBackground(Color.white);
													{
														isuiStructure = new IdentifiableStructureUI(true,rootHelpContext);
														isuiStructure.setPreferredSize(optimalSize);
														isuiStructure.setBasicInfoOrientation(true);
														jspSubstance.setViewportView(isuiStructure);
														jspSubstance.getViewport().revalidate();
													}
											}
											
											{
												qrnuiDoseResponceUI = new QuantitativeRelationship_NonlinearUI(rootHelpContext);
												jspSubstanceData.add(qrnuiDoseResponceUI, JSplitPane.RIGHT);
												qrnuiDoseResponceUI.getChartPanel().createDefaultChart();
											}
									}
									{
										jspModelSettings = new JSplitPane();
										jspModelSettings.setBorder(BorderFactory.createTitledBorder("In-Silico Model Settings"));
										this.add(jspModelSettings);
										jspModelSettings.setResizeWeight(0.33);
										jspModelSettings.setBackground(Color.white);
											{
												qrnuiInputDataUI = new QuantitativeRelationship_NonlinearUI("Nominal and measured chem. concentration",rootHelpContext);
												jspModelSettings.add(qrnuiInputDataUI, JSplitPane.LEFT);
												qrnuiInputDataUI.getChartPanel().createDefaultChart();
											}
											{
												localModelUI = new LocalDRModelUI(rootHelpContext);
												jspModelSettings.add(localModelUI, JSplitPane.RIGHT);
											}
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		@Override
		public void load(Object o, boolean readonly)
			{
				if (!(o instanceof SubstanceData))
					return;
				substanceData = (SubstanceData) o;
				this.readonly = readonly || substanceData.isReadonly();
				inSilico = substanceData instanceof SubstanceData_InSilico;
				isuiStructure.load(substanceData.getInitiator().getCachedObject(), readonly);
				qrnuiDoseResponceUI.load(substanceData.getTemplates(), readonly);
				jspModelSettings.setVisible(inSilico);
				if (inSilico)
					{
						qrnuiInputDataUI.load(((SubstanceData_InSilico) substanceData).getLocalModelInputTemplates(), readonly);
						localModelUI.load(substanceData, readonly);
						localModelUI.addExecutionListener(this);
						localModelUI.addPresetListener(this);
						qrnuiDoseResponceUI.getChartPanel().enableFading(true);
					}
				else
					{
						localModelUI.removeExecutionListener(this);
						qrnuiDoseResponceUI.getChartPanel().enableFading(false);
					}
				updateOptimalSize();
			}
		
		@Override
		public void onExecutionComplete(ObjectProperties modelOutput)
			{
				qrnuiDoseResponceUI.load(substanceData.getTemplates(), readonly);
			}
		
		@Override
		public void onPresetLoaded(ObjectProperties modelInput, ObjectProperties modelOutput)
			{
				DataTemplates inputTemplates = ((SubstanceData_InSilico) substanceData).getLocalModelInputTemplates();
				inputTemplates.setProperties(modelInput);
				DataTemplates outputTemplates = substanceData.getTemplates();
				outputTemplates.setProperties(modelOutput);
				qrnuiInputDataUI.load(inputTemplates, readonly);
				qrnuiDoseResponceUI.load(outputTemplates, readonly);
			}
		
		@Override
		public void adjustUI(long visualOptions)
			{
				isuiStructure.adjustUI(AdjustableUI.SUBST_VIEW);
			}
		
		@Override
		public void updateOptimalSize()
			{
				/*
				 * optimalSize.width = qrnuiDoseResponceUI.getPreferredSize().width +
				 * isuiStructure.getPreferredSize().width; optimalSize.height =
				 * qrnuiDoseResponceUI.getPreferredSize().height; if (inSilico)
				 * optimalSize.height += qrnuiInputDataUI.getPreferredSize().height;
				 * setPreferredSize(optimalSize); // setMinimumSize(optimalSize); //
				 * setMaximumSize(optimalSize); Container parent = getParent(); while
				 * (parent != null) { if (parent instanceof SizeOptimizableUI) {
				 * ((SizeOptimizableUI) parent).updateOptimalSize(); break; } parent =
				 * parent.getParent(); }
				 */
			}
		
		protected void TEST_buildChart()
			{
				if (substanceData != null)
					{
						ObjectProperties summary = substanceData.getObjectProperties();
						//System.out.println(summary.DEBUG_getSummary());
						ObjectPropertyMultivalued_Documented testedSubst = (ObjectPropertyMultivalued_Documented) summary.getProperty(0);
						String xAxisTitle = DefaultEffectopediaObjects.DEFAULT_LOG_MOL_CONCENTRATION.getDescription() + " [" + DefaultEffectopediaObjects.DEFAULT_LOG_MOL_CONCENTRATION.getDefaultUnit().getCaption()
								+ "]";
						String yAxisTitle = testedSubst.getType().getDescription() + testedSubst.getDisplayUnit();
						String chartTitle = substanceData.getTest().getCachedObject().getTitle();
						ChartTemplate chartTemplate = new ChartTemplate(xAxisTitle, yAxisTitle, chartTitle);
						DataSeries dataSeries1 = DataSeriesFactory.getDataSeriesByDescriptor(testedSubst, 0, 0, -1);
						DataSeries dataSeries2 = null;
						ObjectPropertyMultivalued_Documented refSubst = (ObjectPropertyMultivalued_Documented) summary.getProperty(1);
						if (refSubst != null)
							dataSeries2 = DataSeriesFactory.getDataSeriesByDescriptor(refSubst, 0, 0, -1);
						qrnuiDoseResponceUI.getChartPanel().reset();
						qrnuiDoseResponceUI.getChartPanel().createChart(chartTemplate, dataSeries1, dataSeries2);
					}
			}
		
		private Dimension																														optimalSize						= new Dimension(360, 280);
		protected boolean																														inSilico									= true;
		protected boolean																														readonly;
		protected SubstanceData																								substanceData;
		protected JSplitPane																											jspSubstanceData;
		protected JSplitPane																											jspModelSettings;
		protected IdentifiableStructureUI														isuiStructure;
		protected QuantitativeRelationship_NonlinearUI	qrnuiDoseResponceUI;
		protected QuantitativeRelationship_NonlinearUI	qrnuiInputDataUI;
		protected LocalDRModelUI																							localModelUI;
		protected JScrollPane																										jspSubstance;
		private static final long																						serialVersionUID	= 1L;
	}

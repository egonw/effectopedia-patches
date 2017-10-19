package org.qsari.effectopedia.gui.obj_prop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxUI;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.quantification.DataSampleValueFactory;
import org.qsari.effectopedia.data.quantification.DataTemplate;
import org.qsari.effectopedia.data.quantification.DataTemplates;
import org.qsari.effectopedia.data.quantification.DataTemplatesTableModel;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship;
import org.qsari.effectopedia.data.quantification.FunctionalRelationship.EvidenceType;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.gui.LinkExperimentalEvicencesUI;
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
public class EvidenceTitleUI extends ContextSensitivePanel implements LoadableEditorUI, ActionListener
	{
		
		/**
 * 
 */
		private static final long							serialVersionUID	= 1L;
		private JButton																	jbGenerate;
		private JLabel																		jlEvidances;
		private JComboBox<EvidenceType>	jcbEvidenceType;
		
		public EvidenceTitleUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				evidenceTypeChangeListeners = new ArrayList<EvidenceTypeChangeListener>();
				setName("evidence");
				initGUI();
			}
		
		public void initGUI()
			{
				try
					{
						this.setPreferredSize(optimalSize);
						GridBagLayout jpDefaultTitlePanelLayout = new GridBagLayout();
						this.setBackground(Color.WHITE);
						jpDefaultTitlePanelLayout.rowWeights = new double[]
							{ 0.1 };
						jpDefaultTitlePanelLayout.rowHeights = new int[]
							{ 7 };
						jpDefaultTitlePanelLayout.columnWeights = new double[]
							{ 0, 0.7, 0.20 };
						jpDefaultTitlePanelLayout.columnWidths = new int[]
							{ 0, 300, 60 };
						this.setLayout(jpDefaultTitlePanelLayout);
							{
								jlEvidances = new JLabel("");
								this.add(jlEvidances, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 2, 0, 2), 0, 0));
								jlEvidances.setName("type");
							}
							{
								ComboBoxModel<EvidenceType> jcbDataTemplateTypeModel = new DefaultComboBoxModel<EvidenceType>(supportedEvidenceTypes);
								jcbEvidenceType = new JComboBox<EvidenceType>();
								this.add(jcbEvidenceType, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jcbEvidenceType.setModel(jcbDataTemplateTypeModel);
								jcbEvidenceType.setUI(new BasicComboBoxUI());
								jcbEvidenceType.setBackground(Color.white);
								jcbEvidenceType.addActionListener(this);
								jcbEvidenceType.setName("type");
							}
							{
								jbGenerate = new JButton("Generate");
								this.add(jbGenerate, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								// jbGenerate.setBackground(Color.white);
								jbGenerate.setFocusPainted(false);
								jbGenerate.setMargin(new java.awt.Insets(2, 4, 2, 4));
								jbGenerate.addActionListener(this);
								jbGenerate.setName("generate");
							}
							RootHelpContext.addMouseMotionListeners(this, rootHelpContext,false);
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		@Override
		public void load(Object o, boolean readonly)
			{
				dataChanging = true;
				if (o instanceof FunctionalRelationship)
					{
						fnRel = (FunctionalRelationship) o;
						jcbEvidenceType.setSelectedItem(fnRel.getEvidenceType());
					}
				jbGenerate.setEnabled(false);
				dataChanging = false;
			}
		
		@Override
		public void actionPerformed(ActionEvent evt)
			{
				if (fnRel != null)
					if (evt.getSource() == jbGenerate)
						generate();
					else
						changeEvidenceType();
			}
		
		private void changeEvidenceType()
			{
				if (dataChanging)
					return;
				fnRel.setEvidenceType((EvidenceType) jcbEvidenceType.getSelectedItem());
				fireEvidenceTypeChanged(new EventObject(fnRel));
			}
		
		private void generate()
			{
				if (transformedDataTemplate != null)
					{
						if (fnRelUI instanceof QuantitativeRelationship_NonlinearUI)
							{
								DataTemplatesTableModel sourceTableModel = ((QuantitativeRelationship_NonlinearUI) evidenceUI).getDataTemplateTableModel();
								DataTemplatesTableModel destTableModel = ((QuantitativeRelationship_NonlinearUI) fnRelUI).getDataTemplateTableModel();
								
								if (sourceTableModel.templates.isUsingGroups())
									transferTimeDoseRespData(sourceTableModel, destTableModel);
								else
									transferDoseRespData(sourceTableModel, destTableModel);

								destTableModel.templates.setDefaultXDisplayUnit(sourceTableModel.templates.getDefaultYDisplayUnit());
								destTableModel.templates.setDefaultYDisplayUnit(sourceTableModel.templates.getSecondaryYDisplayUnit());
								((ObjectPropertyMultivalued_Documented) destTableModel.templates.getProperties().getProperty(0)).setNotes("Generated with Effectopedia (v." + Effectopedia.VERSION + ") using data for: "
										+ LinkExperimentalEvicencesUI.getSupportEvidenceDescription(fnRel));
								((QuantitativeRelationship_NonlinearUI) fnRelUI).load(fnRel, fnRel.getOwner().isReadonly());
							}
					}
			}

		private void transferTimeDoseRespData(DataTemplatesTableModel sourceTableModel, DataTemplatesTableModel destTableModel)
			{
				for (DataTemplate template : destTableModel.templates)
					template.setType(DefaultEffectopediaObjects.DEFAULT_T_RR_DTT_MEAN_STDEV);

				int timeSrcColumnIndex = sourceTableModel.findColumnIndex(0, DataSampleValueFactory.TIME);
				int upSrcColumnIndex = sourceTableModel.findColumnIndex(0, DataSampleValueFactory.MEAN_VALUE);
				int dnSrcColumnIndex = sourceTableModel.findColumnIndex(sourceTableModel.templates.getSecondaryAxisTemplateIndex(), DataSampleValueFactory.MEAN_VALUE);
				
				int timeDestColumnIndex = destTableModel.findColumnIndex(0, DataSampleValueFactory.TIME);
				int upDestColumnIndex = destTableModel.findColumnIndex(0, DataSampleValueFactory.UPSTREAM_CAUSE);
				int dnDestColumnIndex = destTableModel.findColumnIndex(0, DataSampleValueFactory.MEAN_VALUE);

				destTableModel.removeAll();
				for (int i = 0; i < sourceTableModel.getRowCount(); i++)
					{
						destTableModel.addDataRow();
						destTableModel.setValueAt(sourceTableModel.getValueAt(i, timeSrcColumnIndex), i, timeDestColumnIndex);
						destTableModel.setValueAt(sourceTableModel.getValueAt(i, upSrcColumnIndex), i, upDestColumnIndex);
						destTableModel.setValueAt(sourceTableModel.getValueAt(i, dnSrcColumnIndex), i, dnDestColumnIndex);
					}
			}
		
		private void transferDoseRespData(DataTemplatesTableModel sourceTableModel, DataTemplatesTableModel destTableModel)
			{
				for (DataTemplate template : destTableModel.templates)
					template.setType(DefaultEffectopediaObjects.DEFAULT_RR_DTT_MEAN_STDEV);

				int upSrcColumnIndex = sourceTableModel.findColumnIndex(0, DataSampleValueFactory.MEAN_VALUE);
				int dnSrcColumnIndex = sourceTableModel.findColumnIndex(sourceTableModel.templates.getSecondaryAxisTemplateIndex(), DataSampleValueFactory.MEAN_VALUE);
				
				int upDestColumnIndex = destTableModel.findColumnIndex(0, DataSampleValueFactory.UPSTREAM_CAUSE);
				int dnDestColumnIndex = destTableModel.findColumnIndex(0, DataSampleValueFactory.MEAN_VALUE);

				destTableModel.removeAll();
				for (int i = 0; i < sourceTableModel.getRowCount(); i++)
					{
						destTableModel.addDataRow();
						destTableModel.setValueAt(sourceTableModel.getValueAt(i, upSrcColumnIndex), i, upDestColumnIndex);
						destTableModel.setValueAt(sourceTableModel.getValueAt(i, dnSrcColumnIndex), i, dnDestColumnIndex);
					}
			}
		
		public interface EvidenceTypeChangeListener
			{
				public void evidenceTypeChanged(EventObject event);
			}
		
		public void addEvidenceTypeChangeListener(EvidenceTypeChangeListener listener)
			{
				evidenceTypeChangeListeners.add(listener);
			}
		
		public void removeEvidenceTypeChangeListener(EvidenceTypeChangeListener listener)
			{
				evidenceTypeChangeListeners.remove(listener);
			}
		
		protected void fireEvidenceTypeChanged(EventObject event)
			{
				for (EvidenceTypeChangeListener listener : evidenceTypeChangeListeners)
					listener.evidenceTypeChanged(event);
			}
		
		public void enableRRGeneration(boolean enabled, DataTemplates transformedDataTemplate)
			{
				jbGenerate.setEnabled(enabled);
				this.transformedDataTemplate = transformedDataTemplate;
			}
		
		public JPanel getFnRelUI()
			{
				return fnRelUI;
			}
		
		public void setFnRelUI(JPanel fnRelUI)
			{
				this.fnRelUI = fnRelUI;
			}
		
		public JPanel getEvidenceUI()
			{
				return evidenceUI;
			}
		
		public void setEvidenceUI(JPanel evidenceUI)
			{
				this.evidenceUI = evidenceUI;
			}
		
		private DataTemplates																											transformedDataTemplate;
		protected ArrayList<EvidenceTypeChangeListener>	evidenceTypeChangeListeners;
		private boolean																																	dataChanging											= false;
		protected FunctionalRelationship																fnRel;
		private JPanel																																		fnRelUI;
		private JPanel																																		evidenceUI;
		protected Dimension																													optimalSize												= new java.awt.Dimension(600, 28);
		public static final EvidenceType[]														supportedEvidenceTypes	= new EvidenceType[]
																																																																										{ EvidenceType.EXPERIMENTAL_DATA, EvidenceType.IN_SILICO_MODEL };
		
	}

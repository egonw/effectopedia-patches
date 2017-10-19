package org.qsari.effectopedia.gui.default_ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.plaf.basic.BasicComboBoxUI;

import org.qsari.effectopedia.core.objects.Initiator;
import org.qsari.effectopedia.core.objects.Initiator_ChemicalStructure;
import org.qsari.effectopedia.core.objects.Lab;
import org.qsari.effectopedia.core.objects.Substance;
import org.qsari.effectopedia.core.objects.SubstanceData;
import org.qsari.effectopedia.core.objects.SubstanceData_InLab;
import org.qsari.effectopedia.core.objects.Test;
import org.qsari.effectopedia.core.objects.Test_InLab;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.data.quantification.DataTemplateType;
import org.qsari.effectopedia.data.quantification.DataTemplates;
import org.qsari.effectopedia.defaults.DefaultDataTemplates;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.gui.help.RootHelpContext;

public class SubstanceDataTitleUI extends EffectopediaObjectTitleUI implements ActionListener, TableModelListener
	{
		
		/**
 * 
 */
		private static final long				serialVersionUID	= 1L;
		private JCheckBox												jcbReference;
		private JComboBox<Substance>	jcbSusbtance;
		private JLabel															jlLab;
		private JComboBox<Lab>							jcbLab;
		protected GridBagLayout						jpDefaultTitlePanelLayout;
		
		public SubstanceDataTitleUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				dataTemplateChangeListeners = new ArrayList<DataTemplateChangeListener>();
			}
		
		@Override
		public void initGUI()
			{
				try
					{
						this.setPreferredSize(optimalSize);
						jpDefaultTitlePanelLayout = new GridBagLayout();
						this.setBackground(Color.WHITE);
						jpDefaultTitlePanelLayout.rowWeights = new double[]
							{ 0.1 };
						jpDefaultTitlePanelLayout.rowHeights = new int[]
							{ 7 };
						jpDefaultTitlePanelLayout.columnWeights = new double[]
							{ 0.22, 0.22, 0.04, 0.20, 0.20, 0.055, 0.055 };
						jpDefaultTitlePanelLayout.columnWidths = new int[]
							{ 120, 120, 20, 60, 60, 20, 20 };
						this.setLayout(jpDefaultTitlePanelLayout);
							{
								jtfTitle = new JTextField();
								this.add(jtfTitle, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 4, 0, 0), 0, 0));
								jtfTitle.setText("Title");
								jtfTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
								jtfTitle.setFont(new java.awt.Font("Tahoma", 1, 12));
							}
							{
								ComboBoxModel<Substance> jcbSubstanceModel = new DefaultComboBoxModel<Substance>();
								jcbSusbtance = new JComboBox<Substance>();
								this.add(jcbSusbtance, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jcbSusbtance.setModel(jcbSubstanceModel);
								jcbSusbtance.setUI(new BasicComboBoxUI());
								jcbSusbtance.setBackground(Color.white);
								jcbSusbtance.addActionListener(this);
							}
							
							{
								jcbReference = new JCheckBox("include reference data");
								this.add(jcbReference, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jcbReference.setBackground(Color.white);
								jcbReference.setMargin(new java.awt.Insets(2, 4, 2, 4));
								jcbReference.addActionListener(this);
							}
							{
								jlLab = new JLabel("lab:");
								this.add(jlLab, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jlLab.setBackground(Color.white);
							}
							{
								ComboBoxModel<Lab> jcbLabModel = new DefaultComboBoxModel<Lab>();
								jcbLab = new JComboBox<Lab>();
								this.add(jcbLab, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jcbLab.setModel(jcbLabModel);
								jcbLab.setUI(new BasicComboBoxUI());
								jcbLab.setBackground(Color.white);
								jcbLab.addActionListener(this);
							}
							{
								jlID = new JLabel();
								this.add(jlID, new GridBagConstraints(5, 0, 1, 1, 0.5, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jlID.setText("ID: ");
							}
							{
								jtfID = new JTextField();
								this.add(jtfID, new GridBagConstraints(6, 0, 1, 1, 1.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
								jtfID.setText("0");
								jtfID.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
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
				dataChanging = true;
				if (o instanceof SubstanceData)
					{
						substanceData = (SubstanceData) o;
						dataTemplates = substanceData.getTemplates();
						listeners.unbondDocumntListener(jtfTitle.getDocument(), "Title");
						jtfTitle.setText(substanceData.getTitle());
						jtfTitle.setEditable(!readonly);
						jlID.setText(substanceData.isDefaultID() ? "DefaultID: " : "ID: ");
						jtfID.setText(substanceData.getIDandExternalID());
						jcbReference.setSelected(substanceData.getObjectProperties().getCount() > 1);
						updateSubstance();
						updateLabs();
						listeners.bondDocumntListener(jtfTitle.getDocument(), o, "Title");
					}
				dataChanging = false;
			}
		
		public void updateSubstance()
			{
				Initiator initiator = substanceData.getInitiator().getCachedObject();
				Substance substance = substanceData.getSubstance().getCachedObject();
				if (initiator instanceof Initiator_ChemicalStructure)
					{
						ComboBoxModel<Substance> jcbDataTemplateTypeModel = new DefaultComboBoxModel<Substance>(((Initiator_ChemicalStructure) initiator).getSubstanceIDs().getCachedObjects());
						jcbSusbtance.setModel(jcbDataTemplateTypeModel);
						if (jcbSusbtance.getItemCount() == 1)
							jcbSusbtance.setSelectedIndex(0);
						else
							jcbSusbtance.setSelectedItem(substance);
					}
				else if (substance != null)
					{
						ComboBoxModel<Substance> jcbDataTemplateTypeModel = new DefaultComboBoxModel<Substance>(new Substance[]
							{ substance });
						jcbSusbtance.setModel(jcbDataTemplateTypeModel);
						jcbSusbtance.setSelectedItem(substance);
					}
			}
		
		@Override
		public void tableChanged(TableModelEvent e)
			{
				updateLabs();
			}
		
		public void updateLabs()
			{
				boolean inLabTest = false;
				if (substanceData != null)
					{
						Test test = substanceData.getTest().getCachedObject();
						inLabTest = test instanceof Test_InLab;
						if (inLabTest)
							{
								ComboBoxModel<Lab> jcbLabModel = new DefaultComboBoxModel<Lab>(((Test_InLab) test).getLabIDs().getCachedObjects());
								jcbLab.setModel(jcbLabModel);
								jcbLab.setSelectedItem(((SubstanceData_InLab) substanceData).getLab().getCachedObject());
							}
					}
				else
					inLabTest = false;
				jlLab.setVisible(inLabTest);
				jcbLab.setVisible(inLabTest);
				int idx = inLabTest ? 1 : 0;
				jpDefaultTitlePanelLayout.columnWeights[2] = labLabelWeight[idx];
				jpDefaultTitlePanelLayout.columnWeights[3] = labComboBoxWeight[idx];
				jpDefaultTitlePanelLayout.columnWidths[2] = labLabelWidth[idx];
				jpDefaultTitlePanelLayout.columnWidths[3] = labComboBoxWidth[idx];
			}
		
		@Override
		public void actionPerformed(ActionEvent evt)
			{
				if (substanceData != null)
					if (evt.getSource() == jcbReference)
						changeUseOfReferenceData();
					else if (evt.getSource() == jcbSusbtance)
						substanceData.getSubstance().set((Substance) jcbSusbtance.getSelectedItem());
			}
		
		private void changeUseOfReferenceData()
			{
				if (!jcbReference.isSelected())
					{
						if (UserInterface.getUserConfirmation("You have choosen to ignor the supplied reference data. \nAll values for the reference treatment will be lost. \nDo you still want to proceed?"))
							{
								dataTemplates.remove(1);
								ObjectProperties op = substanceData.getObjectProperties();
								substanceData.setObjectProperties(DefaultEffectopediaObjects.DEFAULT_D_RESP_DATA.clone(substanceData, substanceData.getDataSource()));
								substanceData.getObjectProperties().getProperty(0).assingFrom(op.getProperty(0));
								tmpReference = op.getProperty(1);
							}
					}
				else
					{
						dataChanging = true;
						ObjectProperties opOld = substanceData.getObjectProperties();
						ObjectProperties opNew = DefaultEffectopediaObjects.DEFAULT_D_RESP_AND_REF_DATA.clone(substanceData, substanceData.getDataSource());
						opNew.getProperty(0).assingFrom(opOld.getProperty(0));
						if (tmpReference != null)
							opNew.getProperty(1).assingFrom(tmpReference);
						dataTemplates = DefaultDataTemplates.DTS_DR_DUAL_CHEM_ALL.clone();
						dataTemplates.setProperties(opNew);
						dataTemplates.setOwner(substanceData);
						substanceData.setTemplates(dataTemplates);
						dataChanging = false;
						fireDataTemplateChanged(new EventObject(substanceData));
					}
				
				fireDataTemplateChanged(new EventObject(substanceData));
			}
		
		public interface DataTemplateChangeListener
			{
				public void dataTemplateChanged(EventObject event);
			}
		
		public void addDataTemplateChangeListener(DataTemplateChangeListener listener)
			{
				dataTemplateChangeListeners.add(listener);
			}
		
		public void removeDataTemplateChangeListener(DataTemplateChangeListener listener)
			{
				dataTemplateChangeListeners.remove(listener);
			}
		
		protected void fireDataTemplateChanged(EventObject event)
			{
				for (DataTemplateChangeListener listener : dataTemplateChangeListeners)
					listener.dataTemplateChanged(event);
			}
		
		private static int[]																												labLabelWidth								= new int[]
																																																																								{ 0, 20 };
		private static int[]																												labComboBoxWidth					= new int[]
																																																																								{ 0, 60 };
		private static double[]																									labLabelWeight							= new double[]
																																																																								{ 0, 0.04 };
		private static double[]																									labComboBoxWeight				= new double[]
																																																																								{ 0, 0.20 };
		
		protected ArrayList<DataTemplateChangeListener>	dataTemplateChangeListeners;
		private boolean																																	dataChanging									= false;
		private ObjectProperty																										tmpReference									= null;
		private DataTemplateType																								lastDataTemplateType	= null;
		protected SubstanceData																									substanceData;
		protected DataTemplates																									dataTemplates;
		
	}

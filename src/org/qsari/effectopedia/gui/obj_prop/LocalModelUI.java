package org.qsari.effectopedia.gui.obj_prop;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.MutableComboBoxModel;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.text.Document;

import org.qsari.effectopedia.core.modelling.ExecutableModel;
import org.qsari.effectopedia.core.modelling.ExecutionProgressListener;
import org.qsari.effectopedia.core.modelling.ExecutionProgressUpdater;
import org.qsari.effectopedia.core.modelling.ModelExecutor;
import org.qsari.effectopedia.core.objects.Method_InSilicoGlobalModel;
import org.qsari.effectopedia.data.objects.ModelPreset;
import org.qsari.effectopedia.data.objects.ModelPresets;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.data.objects.Resource;
import org.qsari.effectopedia.gui.SizeOptimizableUI;
import org.qsari.effectopedia.gui.comp.EventsManager;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.obj_prop.GlobalModelSelectorUI.GlobalModelSelectionListener;
import org.qsari.effectopedia.gui.obj_prop.ModelParametersValuesUI.ModelParameterChangeListener;

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
public class LocalModelUI extends ContextSensitivePanel implements LoadableEditorUI, ActionListener, ExecutionProgressListener, ModelParameterChangeListener, GlobalModelSelectionListener, SizeOptimizableUI
	{
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.setContentPane(new LocalModelUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public LocalModelUI(RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
							{
								this.setPreferredSize(optimalSize);
								this.setBackground(Color.white);
								GridBagLayout thisLayout = new GridBagLayout();
								thisLayout.rowWeights = new double[]
									{ 0.0, 0.0, 0.1 };
								thisLayout.rowHeights = new int[]
									{ 18, 175, 20 };
								thisLayout.columnWeights = new double[]
									{ 0.0, 0.0, 0.1 };
								thisLayout.columnWidths = new int[]
									{ 57, 104, 7 };
								this.setLayout(thisLayout);
									{
										gmsModelSelector = new GlobalModelSelectorUI(rootHelpContext);
										this.add(gmsModelSelector, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
										gmsModelSelector.addGlobalModelSelectionListener(this);
									}
									{
										mpvuiModelParameters = new ModelParametersValuesUI(rootHelpContext);
										this.add(mpvuiModelParameters, new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
										mpvuiModelParameters.addModelParameterChangeListener(this);
									}
									{
										jtpExecutionMode = new JTabbedPane();
										this.add(jtpExecutionMode, new GridBagConstraints(0, 2, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
										jtpExecutionMode.setBackground(Color.white);
										jtpExecutionMode.setTabPlacement(JTabbedPane.BOTTOM);
											{
												jpOnDemand = new JPanel();
												GridBagLayout jpOnDemandLayout = new GridBagLayout();
												jtpExecutionMode.addTab("On demand", null, jpOnDemand, "Execute the model on the local machine in realtime");
												jpOnDemand.setBackground(Color.white);
												jpOnDemandLayout.rowWeights = new double[]
													{ 1, 3 };
												jpOnDemandLayout.rowHeights = new int[]
													{ 16, 48 };
												jpOnDemandLayout.columnWeights = new double[]
													{ 0.0, 0.0, 0.1, 0.0, 0.0 };
												jpOnDemandLayout.columnWidths = new int[]
													{ 49, 100, 288, 100, 140 };
												jpOnDemand.setLayout(jpOnDemandLayout);
													{
														jcbAuto = new JCheckBox();
														jpOnDemand.add(jcbAuto, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
														jcbAuto.setText("Auto: ");
														jcbAuto.setBackground(Color.white);
													}
													{
														jbExecute = new JButton();
														jpOnDemand.add(jbExecute, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
														jbExecute.setText("Execute");
														jbExecute.addActionListener(this);
													}
													{
														jpbProgress = new JProgressBar();
														jpOnDemand.add(jpbProgress, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
													}
													{
														jspConsole = new JScrollPane();
														jpOnDemand.add(jspConsole, new GridBagConstraints(0, 1, 5, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
														jspConsole.setBackground(Color.white);
														jspConsole.setBorder(BorderFactory.createTitledBorder("Message Console"));
														jspConsole.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
															
															{
																jtaConsole = new JTextArea();
																jspConsole.setViewportView(jtaConsole);
																console = new PrintStream(new ConsolePrintStream());
															}
													}
													{
														jbRestoreParamValuesOD = new JButton();
														jpOnDemand.add(jbRestoreParamValuesOD, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
														jbRestoreParamValuesOD.setText("Restore");
														jbRestoreParamValuesOD.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/Reset15x15.png")));
														jbRestoreParamValuesOD.addActionListener(loadDefault);
													}
													{
														jlDefaultParameterValuesOD = new JLabel();
														jpOnDemand.add(jlDefaultParameterValuesOD, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
														jlDefaultParameterValuesOD.setText("default parameter values ");
													}
											}
											{
												jpPreset = new JPanel();
												GridBagLayout jpPrecalculatedLayout = new GridBagLayout();
												jtpExecutionMode.addTab("Preset", null, jpPreset, "Add execution request or view precalculated scenaria");
												jpPreset.setBackground(Color.white);
												jpPrecalculatedLayout.rowWeights = new double[]
													{ 0.1, 0.1, 0.1, 0.1 };
												jpPrecalculatedLayout.rowHeights = new int[]
													{ 7, 7, 7, 7 };
												jpPrecalculatedLayout.columnWeights = new double[]
													{ 0.1, 0.0, 0.0, 0.0, 0.0 };
												jpPrecalculatedLayout.columnWidths = new int[]
													{ 200, 20, 80, 20, 140 };
												jpPreset.setLayout(jpPrecalculatedLayout);
													{
														pmPresetModel = new PresetsModel();
														jcbPesets = new JComboBox<ModelPreset>();
														jpPreset.add(jcbPesets, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
														jcbPesets.setModel(pmPresetModel);
														jcbPesets.setBackground(Color.white);
														jcbPesets.setEditable(true);
														jcbPesets.addActionListener(new LoadSelectedParameterValues());
													}
													{
														jbRestoreParamValuesP = new JButton();
														jpPreset.add(jbRestoreParamValuesP, new GridBagConstraints(2, 0, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 0, 2), 0, 0));
														jbRestoreParamValuesP.setText("Restore");
														jbRestoreParamValuesP.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/Reset15x15.png")));
														jbRestoreParamValuesP.addActionListener(loadDefault);
													}
													{
														jbAddNewRequest = new JButton();
														jpPreset.add(jbAddNewRequest, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 0, 2), 0, 0));
														jbAddNewRequest.setText("Add ");
														jbAddNewRequest.setIcon(new ImageIcon(getClass().getClassLoader().getResource("org/qsari/effectopedia/gui/res/Add15x15.png")));
														jbAddNewRequest.addActionListener(new AddNewRequest());
													}
													{
														jspPersetDescription = new JScrollPane();
														jpPreset.add(jspPersetDescription, new GridBagConstraints(0, 1, 1, 3, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
														jspPersetDescription.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
														jspPersetDescription.setBackground(Color.white);
														jspPersetDescription.setBorder(BorderFactory.createTitledBorder("Preset Description"));
															{
																jtaPersetDescription = new JTextArea();
																jspPersetDescription.setViewportView(jtaPersetDescription);
																jtaPersetDescription.setText("");
															}
													}
													{
														jlModify = new JLabel();
														jpPreset.add(jlModify, new GridBagConstraints(2, 1, 3, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
														jlModify.setText("Adjust to desired parameter values above ");
													}
													{
														jbCalulateRequests = new JButton();
														jpPreset.add(jbCalulateRequests, new GridBagConstraints(2, 3, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 0, 2), 0, 0));
														jbCalulateRequests.setText("Calculate");
														jbCalulateRequests.addActionListener(new CalculateRequested());
													}
													{
														jlStep1 = new JLabel();
														jpPreset.add(jlStep1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
														jlStep1.setText("1.");
													}
													{
														jlStep2 = new JLabel();
														jpPreset.add(jlStep2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
														jlStep2.setText("2.");
													}
													{
														jlStep3 = new JLabel();
														jpPreset.add(jlStep3, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
														jlStep3.setText("3.");
													}
													{
														jlStep4 = new JLabel();
														jpPreset.add(jlStep4, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
														jlStep4.setText("4.");
													}
													{
														jlDefaultValues = new JLabel();
														jpPreset.add(jlDefaultValues, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
														jlDefaultValues.setText("default parameter values ");
													}
													{
														jNewExecutionRequest = new JLabel();
														jpPreset.add(jNewExecutionRequest, new GridBagConstraints(3, 2, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 2, 0, 0), 0, 0));
														jNewExecutionRequest.setText("new execution request");
													}
													{
														jAllExecutionRequests = new JLabel();
														jpPreset.add(jAllExecutionRequests, new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 2, 0, 0), 0, 0));
														jAllExecutionRequests.setText("all exectution requests ");
													}
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
				updateInterface();
			}
		
		protected ObjectProperties getModelInput()
			{
				return null;
			}
		
		protected ObjectProperties getModelOutput()
			{
				return null;
			}
		
		public void updateInterface()
			{
				boolean hasDefault = (model != null) && (model.hasDefaultPreset(ModelPresets.REQUESTED));
				boolean hasRequested = (model != null) && (model.hasPreset(ModelPresets.REQUESTED));
				jbRestoreParamValuesOD.setVisible(hasDefault);
				jlDefaultParameterValuesOD.setVisible(hasDefault);
				jbRestoreParamValuesP.setEnabled(hasDefault);
				jbCalulateRequests.setEnabled(hasRequested);
			}
		
		@Override
		public void actionPerformed(ActionEvent e)
			{
				timer.stop();
				if (model != null)
					{
						ModelExecutor mExe = model.getModelExecutor();
						jpbProgress.setValue(0);
						if (mExe != null)
							{
								jtaConsole.setText("");
								mExe.setGlobalModel(model, method);
								mExe.setConsole(console);
								if (mExe instanceof ExecutionProgressUpdater)
									((ExecutionProgressUpdater) mExe).addExecutionProgressListener(this);
								ExecutableModel eM = mExe.getModel();
								if (eM != null)
									{
										eM.addExecutionProgressListener(this);
										eM.setConsole(console);
										if (eM.execute(getModelInput(), modelParameters, getModelOutput()))
											fireExecutionComplete(getModelOutput());
									}
							}
					}
			}
		
		public class LoadDefaultParameterValues implements ActionListener
			{
				@Override
				public void actionPerformed(ActionEvent e)
					{
						if ((model != null) && (model.hasDefaultPreset(ModelPresets.REQUESTED)))
							loadPreset(model.getModelPersets().getDefault());
					}
			}
		
		public class LoadSelectedParameterValues implements ActionListener
			{
				@Override
				public void actionPerformed(ActionEvent e)
					{
						if (model != null)
							{
								ModelPreset preset = (ModelPreset) pmPresetModel.getSelectedItem();
								if (preset != null)
									loadPreset(preset);
							}
					}
			}
		
		protected void loadPreset(ModelPreset modelPreset)
			{
				this.preset = modelPreset;
				Document description = jtaPersetDescription.getDocument();
				Document title = ((JTextField) jcbPesets.getEditor().getEditorComponent()).getDocument();
				documentListeners.unbondDocumntListener(description, "Description");
				// documentListeners.unbondDocumntListener(title, "Title");
				
				modelParameters.assignPropertyValues(modelPreset.getModelParamaters());
				mpvuiModelParameters.load(modelParameters, false);
				mpvuiModelParameters.resetModified();
				jtaPersetDescription.setText(modelPreset.getDescription());
				
				// documentListeners.bondDocumntListener(title, preset, "Title");
				documentListeners.bondDocumntListener(description, preset, "Description");
				if (modelPreset.isCalculated())
					firePresetLoaded(modelPreset.getModelInput(), modelPreset.getModelOutput());
			}
		
		public class CalculateRequested implements ActionListener
			{
				@Override
				public void actionPerformed(ActionEvent e)
					{
						if ((model != null) && (model.hasPreset(ModelPresets.REQUESTED)))
							{
								ModelExecutor mExe = model.getModelExecutor();
								if (mExe != null)
									{
										for (ModelPreset preset : model.getModelPersets())
											if (!preset.isCalculated())
												{
													mExe.setGlobalModel(model,method);
													mExe.setConsole(console);
													ExecutableModel eM = mExe.getModel();
													if (eM != null)
														{
															eM.setConsole(console);
															console.append("Attempt executting: " + preset.getTitle() + "\n");
															if (eM.execute(preset.getModelInput(), preset.getModelParamaters(), preset.getModelOutput()))
																preset.setCalculated(true);
														}
												}
										updateInterface();
									}
							}
					}
			}
		
		public class AddNewRequest implements ActionListener
			{
				@Override
				public void actionPerformed(ActionEvent e)
					{
						if (model != null)
							{
								ModelPreset preset = new ModelPreset(getModelInput(), model.getModelParamaters(), getModelOutput());
								preset.setCalculated(false);
								preset.setTitle(generateTitle());
								preset.setDescription("All model parameters, but those in the title use their default values.");
								pmPresetModel.addElement(preset);
								updateInterface();
							}
					}
				
				public String generateTitle()
					{
						StringBuilder sb = new StringBuilder();
						sb.append("Execution request: ");
						for (ObjectProperty op : mpvuiModelParameters.getModified())
							{
								sb.append(op.getType().getName());
								sb.append("=");
								sb.append(op.getDisplayValue());
								if ((op.getUnit() != null) && (op.getUnit().getCaption() != null) && (op.getUnit().getCaption().length() > 0))
									{
										sb.append(" ");
										sb.append(op.getDisplayUnit());
									}
								sb.append("; ");
							}
						return sb.toString();
					}
			}
		
		public static class PresetsModel extends AbstractListModel<ModelPreset> implements MutableComboBoxModel<ModelPreset>
			{
				
				@Override
				public int getSize()
					{
						return modelPresets != null ? modelPresets.size() : 0;
					}
				
				@Override
				public ModelPreset getElementAt(int index)
					{
						return modelPresets.get(index);
					}
				
				@Override
				public void setSelectedItem(Object preset)
					{
						if (preset == null && selectedIndex == -1)
							return;
						if (preset != null && selectedIndex != -1 && preset.equals(modelPresets.get(selectedIndex)))
							return;
						int index = modelPresets.indexOf(preset);
						if (preset != null && index == -1)
							return;
						selectedIndex = index;
						fireContentsChanged(this, -1, -1);
					}
				
				@Override
				public void addElement(ModelPreset modelPreset)
					{
						int index = modelPresets.size();
						modelPresets.add(modelPreset);
						fireIntervalAdded(this, index, index);
						setSelectedItem(modelPreset);
					}
				
				@Override
				public void removeElement(Object modelPreset)
					{
						int index = modelPresets.indexOf(modelPreset);
						if (index != -1)
							removeElementAt(index);
					}
				
				@Override
				public void insertElementAt(ModelPreset item, int index)
					{
						modelPresets.add(index, item);
						fireIntervalAdded(this, index, index);
					}
				
				@Override
				public void removeElementAt(int index)
					{
						int selected = selectedIndex;
						if (selected == index)
							{
								if (selected > 0)
									setSelectedItem(getElementAt(selected - 1));
								else
									setSelectedItem(getElementAt(selected + 1));
							}
						modelPresets.remove(index);
						fireIntervalRemoved(this, index, index);
					}
				
				@Override
				public Object getSelectedItem()
					{
						return selectedIndex != -1 ? modelPresets.get(selectedIndex) : null;
					}
				
				public void setModelPresets(ModelPresets modelPresets)
					{
						this.modelPresets = modelPresets;
					}
				
				public ModelPresets getModelPresets()
					{
						return this.modelPresets;
					}
				
				protected int													selectedIndex				= -1;
				protected ModelPresets				modelPresets;
				
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
			}
		
		public class ConsolePrintStream extends OutputStream
			{
				/**
				 * Writes the specified byte as a character to the javax.swing.JTextArea.
				 * 
				 * @param b
				 *         The byte to be written as character to the JTextArea.
				 */
				public void write(int b) throws IOException
					{
						jtaConsole.append(String.valueOf((char) b));
						jtaConsole.revalidate();
					}
			}
		
		@Override
		public void onProgress(int percentComplete)
			{
				jpbProgress.setValue(percentComplete);
			}
		
		public interface ExecutionListener
			{
				public void onExecutionComplete(ObjectProperties modelOutput);
			}
		
		public void addExecutionListener(ExecutionListener listener)
			{
				listeners.add(listener);
			}
		
		public void removeExecutionListener(ExecutionListener listener)
			{
				listeners.remove(listener);
			}
		
		public void fireExecutionComplete(ObjectProperties modelOutput)
			{
				for (ExecutionListener listener : listeners)
					listener.onExecutionComplete(modelOutput);
			}
		
		public interface PresetListener
			{
				public void onPresetLoaded(ObjectProperties modelInput, ObjectProperties modelOutput);
			}
		
		public void addPresetListener(PresetListener listener)
			{
				presetListeners.add(listener);
			}
		
		public void removePresetListener(PresetListener listener)
			{
				presetListeners.remove(listener);
			}
		
		public void firePresetLoaded(ObjectProperties modelInput, ObjectProperties modelOutput)
			{
				for (PresetListener listener : presetListeners)
					listener.onPresetLoaded(modelInput, modelOutput);
			}
		
		@Override
		public void onParameterChanged(EventObject evt)
			{
				if (jcbAuto.isSelected())
					timer.start();
			}
		
		@Override
		public void globalModelSelected(ActionEvent evt)
			{
			}
		
		public void updateOptimalSize()
			{
				optimalSize.height = gmsModelSelector.getPreferredSize().height + mpvuiModelParameters.getPreferredSize().height + jtpExecutionMode.getPreferredSize().height + 12;
				if (optimalSize.height < minimumHeight)
					optimalSize.height = minimumHeight;
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
		
		protected ModelPreset																		preset												= null;
		private EventsManager																		documentListeners	= new EventsManager();																								;
		protected Timer																								timer													= new Timer(100, this);
		protected ArrayList<ExecutionListener>	listeners									= new ArrayList<ExecutionListener>();
		protected ArrayList<PresetListener>				presetListeners			= new ArrayList<PresetListener>();
		protected LoadDefaultParameterValues			loadDefault							= new LoadDefaultParameterValues();
		protected JLabel																							jlStep1;
		protected JLabel																							jlModify;
		protected JButton																						jbRestoreParamValuesP;
		protected JButton																						jbRestoreParamValuesOD;
		protected JButton																						jbCalulateRequests;
		protected JScrollPane																		jspPersetDescription;
		protected JTextArea																				jtaPersetDescription;
		protected JButton																						jbAddNewRequest;
		protected JComboBox<ModelPreset>							jcbPesets;
		protected JPanel																							jpPreset;
		protected JPanel																							jpOnDemand;
		protected JCheckBox																				jcbAuto;
		protected PrintStream																		console;
		protected Method_InSilicoGlobalModel			model;
		protected Resource																					method;
		protected GlobalModelSelectorUI								gmsModelSelector;
		protected JLabel																							jlDefaultParameterValuesOD;
		protected JLabel																							jAllExecutionRequests;
		protected JLabel																							jNewExecutionRequest;
		protected JLabel																							jlDefaultValues;
		protected JLabel																							jlStep4;
		protected JLabel																							jlStep3;
		protected JLabel																							jlStep2;
		protected ObjectProperties													modelParameters;
		protected JTabbedPane																		jtpExecutionMode;
		protected JButton																						jbExecute;
		protected ModelParametersValuesUI						mpvuiModelParameters;
		protected JTextArea																				jtaConsole;
		protected JScrollPane																		jspConsole;
		protected JProgressBar																	jpbProgress;
		protected PresetsModel																	pmPresetModel;
		private int																												minimumHeight					= 300;
		private Dimension																						optimalSize							= new java.awt.Dimension(712, minimumHeight);
		private static final long														serialVersionUID		= 1L;
		
		public static long getSerialversionuid()
			{
				return serialVersionUID;
			}
		
	}

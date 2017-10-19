package org.qsari.effectopedia.gui.obj_prop;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashSet;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.data.objects.ObjectProperty.ValueAndUnit;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented.Documented_Value;
import org.qsari.effectopedia.data.objects.ObjectPropertyType;
import org.qsari.effectopedia.gui.comp.EventsManager;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
import org.qsari.effectopedia.gui.help.ContextSensitivePanel;
import org.qsari.effectopedia.gui.help.RootHelpContext;
import org.qsari.effectopedia.gui.util.RealSlider;

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
public class ModelParametersValuesUI extends JScrollPane implements LoadableEditorUI
	{
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.setContentPane(new ModelParametersValuesUI(null));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public ModelParametersValuesUI(RootHelpContext rootHelpContext)
			{
				super();
				this.rootHelpContext = rootHelpContext;
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
							{
								this.setPreferredSize(new java.awt.Dimension(308, 353));
								this.setBackground(Color.white);
									{
										jpParameterContols = new JPanel();
										BoxLayout jpParameterContolsLayout = new BoxLayout(jpParameterContols, javax.swing.BoxLayout.Y_AXIS);
										jpParameterContols.setLayout(jpParameterContolsLayout);
										this.setViewportView(jpParameterContols);
										jpParameterContols.setBackground(Color.white);
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public static double nullToNaN(Double value)
			{
				return (value == null) ? Double.NaN : value;
			}
		
		@Override
		public void load(Object o, boolean readonly)
			{
				if (o instanceof ObjectProperties)
					{
						modelParameters = (ObjectProperties) o;
						jpParameterContols.removeAll();
						updateParameterControls(modelParameters);
					}
			}
		
		protected void updateParameterControls(ObjectProperties properties)
			{
				if (properties != null)
					{
						for (ObjectProperty op : properties.getProperties())
							{
								ObjectPropertyType type = (ObjectPropertyType) op.getType();
								LoadableEditorUI ui;
								if (type.getFixedValuesList() != null)
									ui = new CategoryUI();
								else
									ui = new ValueSliderUI(rootHelpContext);
								ui.load(op, false);
								jpParameterContols.add((Component) ui);
								for (ValueAndUnit vu : op.getValuePairs())
									updateParameterControls(vu.getSubProperties());
							}
						this.revalidate();
					}
			}
		
		public class CategoryUI extends JComboBox<String> implements LoadableEditorUI, ActionListener
			{
				public CategoryUI()
					{
						addActionListener(this);
					}
				
				@Override
				public void actionPerformed(ActionEvent evt)
					{
						op.setValue((String) this.getSelectedItem());
						fireModelParameterChanged(new EventObject(this));
						modified.add(op);
					}
				
				@Override
				public void load(Object o, boolean readonly)
					{
						op = (ObjectProperty) o;
						ComboBoxModel<String> model = new DefaultComboBoxModel<String>(op.getType().getFixedValuesList().getListArray());
						this.setModel(model);
						this.setSelectedItem(op.getValue());
					}
				
				ObjectProperty												op;
				private static final long	serialVersionUID	= 1L;
			}
		
		public class ValueSliderUI extends ContextSensitivePanel implements LoadableEditorUI, DocumentListener, ChangeListener
			{
				/*
				 * public static void main(String[] args) { JFrame frame = new JFrame();
				 * frame.setContentPane(new ValueSliderUI(9.342e-4, 9.343e-4, 9.343e-4));
				 * frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				 * frame.pack(); frame.setVisible(true); }
				 */
				
				public ValueSliderUI(RootHelpContext rootHelpContext)
					{
						super(rootHelpContext);
						initGUI(0, 40, 20);
					}
				
				public ValueSliderUI(double min, double max, double value,RootHelpContext rootHelpContext)
					{
						super(rootHelpContext);
						initGUI(min, max, value);
					}
				
				@Override
				public void load(Object o, boolean readonly)
					{
						loading = true;
						if (o instanceof ObjectPropertyMultivalued_Documented)
							{
								op = (ObjectPropertyMultivalued_Documented) o;
								Documented_Value val = op.getValueAndUnitPair(0);
								Document valueDoc = jtfValue.getDocument();
								listeners.unbondDocumntListener(valueDoc, "Value");
								jlParameterName.setText(op.getType().getName() + " = ");
								jlParameterName.setToolTipText(op.getType().getDescription());
								jtaDescription.setText(op.getType().getDescription());
								jtfValue.setText(val.getDisplayValue());
								jlUnits.setText(val.getDisplayUnit());
								jsValueSlider.init(nullToNaN(val.getMinValueAsDouble()), nullToNaN(val.getMaxValueAsDouble()), nullToNaN(val.getDoubleValue()));
								listeners.bondDocumntListener(valueDoc, val, "Value");
							}
						loading = false;
					}
				
				private void initGUI(double min, double max, double value)
					{
						try
							{
									{
										this.setPreferredSize(new java.awt.Dimension(719, 86));
										GridBagLayout thisLayout = new GridBagLayout();
										thisLayout.rowWeights = new double[]
											{ 0.0, 0.1 };
										thisLayout.rowHeights = new int[]
											{ 24, 7 };
										thisLayout.columnWeights = new double[]
											{ 0.0, 0.0, 0.0, 0.25 };
										thisLayout.columnWidths = new int[]
											{ 240, 120, 30, 300 };
										this.setLayout(thisLayout);
										this.setBackground(Color.white);
											{
												jsValueSlider = new RealSlider(min, max, value);
												this.add(jsValueSlider, new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
												jsValueSlider.setBackground(Color.white);
												jsValueSlider.addChangeListener(this);
											}
											{
												jspDescription = new JScrollPane();
												this.add(jspDescription, new GridBagConstraints(3, 0, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
												jspDescription.setBackground(Color.white);
												jspDescription.setBorder(BorderFactory.createTitledBorder(null, "Description", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 11)));
													{
														jtaDescription = new JTextArea();
														jspDescription.setViewportView(jtaDescription);
														jtaDescription.setText("Parameter description");
														jtaDescription.setLineWrap(true);
														jtaDescription.setWrapStyleWord(true);
														jtaDescription.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
													}
											}
											{
												jlParameterName = new JLabel();
												this.add(jlParameterName, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 8, 0, 0), 0, 0));
												jlParameterName.setText("Parameter Name = ");
												jlParameterName.setHorizontalAlignment(SwingConstants.RIGHT);
											}
											{
												jtfValue = new JTextField();
												this.add(jtfValue, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 0, 2), 0, 0));
												jtfValue.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
												jtfValue.getDocument().addDocumentListener(this);
											}
											{
												jlUnits = new JLabel();
												this.add(jlUnits, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 0, 2), 0, 0));
												jlUnits.setText("[]");
											}
									}
							}
						catch (Exception e)
							{
								e.printStackTrace();
							}
					}
				
				@Override
				public void insertUpdate(DocumentEvent e)
					{
						updateSlider();
					}
				
				@Override
				public void removeUpdate(DocumentEvent e)
					{
						updateSlider();
					}
				
				@Override
				public void changedUpdate(DocumentEvent e)
					{
						updateSlider();
					}
				
				private void updateSlider()
					{
						if (loading)
							return;
						if (jtfValue.hasFocus())
							{
								if ((op != null))
									jsValueSlider.setRealValue(op.getValueAndUnitPair(0).getDoubleValue());
								else
									{
										try
											{
												Double newValue = Double.parseDouble(jtfValue.getText());
												jsValueSlider.setRealValue(newValue);
											}
										catch (Exception e)
											{
											}
									}
								fireModelParameterChanged(new EventObject(jtfValue));
							}
					}
				
				@Override
				public void stateChanged(ChangeEvent e)
					{
						if (loading)
							return;
						if (op != null)
							{
								op.getValueAndUnitPair(0).setValue(RealSlider.defaultFormat((jsValueSlider.getRealValue()), 5));
								if (jsValueSlider.hasFocus())
									{
										fireModelParameterChanged(new EventObject(jsValueSlider));
										jtfValue.setText(op.getDisplayValue());
										modified.add(op);
									}
							}
						else if (jsValueSlider.hasFocus())
							jtfValue.setText(RealSlider.defaultFormat((jsValueSlider.getRealValue()), 5));
					}
				
				protected ObjectPropertyMultivalued_Documented	op;
				private boolean																																loading;
				private RealSlider																													jsValueSlider;
				private JLabel																																	jlUnits;
				private JTextField																													jtfValue;
				private JLabel																																	jlParameterName;
				private EventsManager																										listeners								= new EventsManager();
				private JTextArea																														jtaDescription;
				private JScrollPane																												jspDescription;
				private static final long																						serialVersionUID	= 1L;
			}
		
		public interface ModelParameterChangeListener
			{
				public void onParameterChanged(EventObject evt);
			}
		
		public void addModelParameterChangeListener(ModelParameterChangeListener listener)
			{
				changeListeners.add(listener);
			}
		
		public void removeModelParameterChangeListener(ModelParameterChangeListener listener)
			{
				changeListeners.remove(listener);
			}
		
		public void fireModelParameterChanged(EventObject evt)
			{
				for (ModelParameterChangeListener listener : changeListeners)
					listener.onParameterChanged(evt);
			}
		
		public void resetModified()
			{
				modified.clear();
			}
		
		public HashSet<ObjectProperty> getModified()
			{
				return modified;
			}
		
		protected ArrayList<ModelParameterChangeListener>	changeListeners		= new ArrayList<ModelParameterChangeListener>();
		protected ObjectProperties																								modelParameters;
		protected HashSet<ObjectProperty>																	modified									= new HashSet<ObjectProperty>();
		private JPanel																																				jpParameterContols;
		private static final long																									serialVersionUID	= 1L;
		protected RootHelpContext rootHelpContext;
	}

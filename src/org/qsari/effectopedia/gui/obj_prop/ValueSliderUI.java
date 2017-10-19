package org.qsari.effectopedia.gui.obj_prop;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
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

import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented.Documented_Value;
import org.qsari.effectopedia.gui.comp.EventsManager;
import org.qsari.effectopedia.gui.core.LoadableEditorUI;
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
public class ValueSliderUI extends JPanel implements LoadableEditorUI, DocumentListener, ChangeListener

	{
		public static void main(String[] args)
			{
				JFrame frame = new JFrame();
				frame.setContentPane(new ValueSliderUI(9.342e-4, 9.343e-4, 9.343e-4));
				frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
			}
		
		public ValueSliderUI()
			{
				super();
				initGUI(0, 40, 20);
			}
		
		public ValueSliderUI(double min, double max, double value)
			{
				super();
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
						jsValueSlider.init(val.getMinValueAsDouble(), val.getMaxValueAsDouble(), val.getDoubleValue());
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
							jtfValue.setText(op.getDisplayValue());
					}
				else if (jsValueSlider.hasFocus())
					jtfValue.setText(RealSlider.defaultFormat((jsValueSlider.getRealValue()), 5));
			}
		
		private boolean																						loading;
		ObjectPropertyMultivalued_Documented	op;
		private RealSlider																			jsValueSlider;
		private JLabel																							jlUnits;
		private JTextField																			jtfValue;
		private JLabel																							jlParameterName;
		private EventsManager																listeners								= new EventsManager();
		private JTextArea																				jtaDescription;
		private JScrollPane																		jspDescription;
		private static final long												serialVersionUID	= 1L;
	}

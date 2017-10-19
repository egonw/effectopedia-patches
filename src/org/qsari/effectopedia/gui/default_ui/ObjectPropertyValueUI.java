package org.qsari.effectopedia.gui.default_ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.qsari.effectopedia.data.objects.FixedValuesList;
import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented.Documented_Value;
import org.qsari.effectopedia.data.objects.ObjectPropertyType;
import org.qsari.effectopedia.gui.AdjustableUI;
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
public class ObjectPropertyValueUI extends ContextSensitivePanel implements AdjustableUI, LoadableEditorUI, DocumentListener, ActionListener
	{
		protected JLabel												jlCategory;
		protected JLabel												jlName;
		protected JLabel												jlID;
		protected JTextField								jtfValueAndUnit;
		protected JComboBox<String>	jcbFixedValueAndUnit;
		protected JLabel												jlDescription;
		protected JTextField								jtfID;
		
		public ObjectPropertyValueUI(int valueIndex,RootHelpContext rootHelpContext)
			{
				super(rootHelpContext);
				this.valueIndex = valueIndex;
				initGUI();
			}
		
		private void initGUI()
			{
				try
					{
							{
								this.setPreferredSize(new java.awt.Dimension(740, 18));
								thisLayout = new GridBagLayout();
								this.setBackground(Color.white);
								this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));
								thisLayout.rowWeights = new double[]
									{ 0.1 };
								thisLayout.rowHeights = new int[]
									{ 7 };
								thisLayout.columnWeights = new double[]
									{ CATEGORY_VW, NAME_VW, VALUE_AND_UNIT_VW, DESCRIPTION_VW, ID_LABEL_VW, IDS_VW };
								thisLayout.columnWidths = new int[]
									{ 60, 100, 200, 300, 20, 60 };
								this.setLayout(thisLayout);
									{
										jlCategory = new JLabel();
										this.add(jlCategory, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 0, 0), 0, 0));
										jlCategory.setText("Class.");
										jlCategory.setFont(DEFAULT_FONT);
										jlCategory.setHorizontalAlignment(SwingConstants.RIGHT);
									}
									{
										jlName = new JLabel();
										this.add(jlName, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 0, 0), 0, 0));
										jlName.setText("Name: ");
										jlName.setFont(DEFAULT_FONT);
									}
									{
										jlID = new JLabel();
										this.add(jlID, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jlID.setText("ID:");
										jlID.setHorizontalAlignment(SwingConstants.CENTER);
									}
									{
										jtfID = new JTextField();
										this.add(jtfID, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
										jtfID.setText("0/0");
										jtfID.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
										jtfID.setEnabled(false);
									}
									{
										jtfValueAndUnit = new JTextField();
										this.add(jtfValueAndUnit, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jtfValueAndUnit.setText("value [unit]");
										jtfValueAndUnit.setFont(DEFAULT_FONT);
										jtfValueAndUnit.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.lightGray));
									}
									{
										jcbFixedValueAndUnit = new JComboBox<String>();
										this.add(jcbFixedValueAndUnit, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jcbFixedValueAndUnit.setVisible(false);
										jcbFixedValueAndUnit.setFont(DEFAULT_FONT);
										jcbFixedValueAndUnit.setEditable(false);
										jcbFixedValueAndUnit.setBorder(BorderFactory.createEmptyBorder());
										jcbFixedValueAndUnit.setBackground(Color.white);
									}
									{
										jlDescription = new JLabel();
										this.add(jlDescription, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
										jlDescription.setText("(Descriptors)");
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		@Override
		public void adjustUI(long visualOptions)
			{
				setShowID((visualOptions & AUTOIDS) != 0);
			}
		
		public boolean isShowID()
			{
				return showID;
			}
		
		public void setShowID(boolean showID)
			{
				this.showID = showID;
				if (showID)
					{
						thisLayout.columnWidths[ID_LABEL] = 20;
						thisLayout.columnWidths[IDS] = 60;
					}
				else
					{
						thisLayout.columnWidths[ID_LABEL] = 0;
						thisLayout.columnWidths[IDS] = 0;
					}
				jlID.setVisible(showID);
				jtfID.setVisible(showID);
			}
		
		public boolean isShowCategory()
			{
				return showCategory;
			}
		
		public void setShowCategory(boolean showCategory)
			{
				this.showCategory = showCategory;
				thisLayout.columnWidths[CATEGORY] = showCategory ? 60 : 0;
				jlCategory.setVisible(showCategory);
			}
		
		public boolean isShowValueAndUnit()
			{
				return showValueAndUnit;
			}
		
		public void setShowValueAndUnit(boolean showValueAndUnit)
			{
				this.showValueAndUnit = showValueAndUnit;
				if (showValueAndUnit)
					{
						thisLayout.columnWidths[NAME] = nameWidth;
						thisLayout.columnWidths[VALUE_AND_UNIT] = 200;
						thisLayout.columnWeights[NAME] = NAME_VW;
						thisLayout.columnWeights[VALUE_AND_UNIT] = VALUE_AND_UNIT_VW;
					}
				else
					{
						thisLayout.columnWidths[NAME] = 200 + nameWidth;
						thisLayout.columnWidths[VALUE_AND_UNIT] = 0;
						thisLayout.columnWeights[NAME] = NAME_VW + VALUE_AND_UNIT_VW;
						thisLayout.columnWeights[VALUE_AND_UNIT] = FIXED_VW;
					}
				jtfValueAndUnit.setVisible(showValueAndUnit && !fixedValue);
				jcbFixedValueAndUnit.setVisible(showValueAndUnit && fixedValue);
			}
		
		public boolean isShowDescriptors()
			{
				return showDescriptors;
			}
		
		public void setShowDescriptors(boolean showDescriptors)
			{
				this.showDescriptors = showDescriptors;
				if (showDescriptors)
					{
						thisLayout.columnWidths[DESCRIPTION] = 300;
						thisLayout.columnWeights[DESCRIPTION] = DESCRIPTION_VW;
					}
				else
					{
						thisLayout.columnWidths[DESCRIPTION] = 0;
						thisLayout.columnWeights[DESCRIPTION] = FIXED_VW;
					}
				jlDescription.setVisible(showDescriptors);
			}
		
		@Override
		public void load(Object o, boolean readonly)
			{
				if (o instanceof ObjectProperty)
					{
						property = (ObjectProperty) o;
						type = (ObjectPropertyType) property.getType();
						updateValueAndUnitUI();
						setShowValueAndUnit(!type.isCategorical());
						setShowID(!type.isAcceptingMultipleValues());
						setShowDescriptors(type.isDocumented());
						setShowCategory(showCategory);
					}
				else
					return;
				jlCategory.setText(type.getCategory());
				jlName.setText(type.getDisplayName());
				jtfID.setText(type.getIDandExternalID());
				if (valueIndex == 0)
					value = property.getValueAndUnit();
				else
					value = ((ObjectPropertyMultivalued) property).getValueAndUnitPair(valueIndex);
				if (fixedValue)
					{
						jcbFixedValueAndUnit.setSelectedItem(value.getDisplayValue());
						jcbFixedValueAndUnit.addActionListener(this);
					}
				else
					{
						jtfValueAndUnit.setText(value.getDisplayValue() + " " + value.getDisplayUnit());
						jtfValueAndUnit.getDocument().addDocumentListener(this);
					}
				if (property instanceof ObjectPropertyMultivalued_Documented)
					jlDescription.setText(((Documented_Value) value).getDescription());
			}
		
		protected void updateValueAndUnitUI()
			{
				FixedValuesList fvl = type.getFixedValuesList();
				fixedValue = fvl != null;
				if (fixedValue)
					{
						jtfValueAndUnit.setVisible(false);
						jcbFixedValueAndUnit.setVisible(true);
						jcbFixedValueAndUnit.setModel(new DefaultComboBoxModel<String>(fvl.getListArray()));
					}
				else
					{
						jtfValueAndUnit.setVisible(true);
						jcbFixedValueAndUnit.setVisible(false);
						
					}
			}
		
		@Override
		public void insertUpdate(DocumentEvent e)
			{
				updateValue(jtfValueAndUnit.getText());
			}
		
		@Override
		public void removeUpdate(DocumentEvent e)
			{
				updateValue(jtfValueAndUnit.getText());
			}
		
		@Override
		public void changedUpdate(DocumentEvent e)
			{
				updateValue(jtfValueAndUnit.getText());
			}
		
		@Override
		public void actionPerformed(ActionEvent e)
			{
				if (valueIndex == 0)
					value = property.getValueAndUnit();
				else
					value = ((ObjectPropertyMultivalued) property).getValueAndUnitPair(valueIndex);
				value.setValue((String) jcbFixedValueAndUnit.getSelectedItem());
			}
		
		public void updateValue(String valueAndUnit)
			{
				if (valueIndex == 0)
					value = property.getValueAndUnit();
				else
					value = ((ObjectPropertyMultivalued) property).getValueAndUnitPair(valueIndex);
				valueAndUnit = valueAndUnit.trim();
				int index = valueAndUnit.indexOf(" ");
				if (index == -1)
					value.setValue(valueAndUnit);
				else
					{
						value.setValue(valueAndUnit.substring(0, index));
						value.setUnit(valueAndUnit.substring(index + 1));
					}
			}
		
		public int getNameWidth()
			{
				//System.out.println("Name: "+jlName.getText()+" "+jlName.getPreferredSize().width);
				return jlName.getPreferredSize().width;
			}

		public void setNameWidth(int nameWidth)
			{
				this.nameWidth = nameWidth;
				jlName.setPreferredSize(new Dimension(nameWidth,jlName.getPreferredSize().height));
				thisLayout.columnWidths[NAME] = nameWidth;
				jlName.invalidate();
			}

		protected static final int												CATEGORY										= 0;
		protected static final int												NAME														= 1;
		protected static final int												VALUE_AND_UNIT				= 2;
		protected static final int												DESCRIPTION							= 3;
		protected static final int												ID_LABEL										= 4;
		protected static final int												IDS															= 5;
		
		protected static final double									FIXED_VW										= 0.0D;
		protected static final double									CATEGORY_VW							= 0.0D;
		protected static final double									NAME_VW											= 0.0D;
		protected static final double									VALUE_AND_UNIT_VW	= 0.2D;
		protected static final double									DESCRIPTION_VW				= 0.3D;
		protected static final double									ID_LABEL_VW							= 0.0D;
		protected static final double									IDS_VW												= 0.0D;
		
		protected int																									nameWidth									= 100;
		
		protected static final Font											DEFAULT_FONT						= new java.awt.Font("Tahoma", 1, 12);
		protected final int																			valueIndex;
		protected ObjectProperty.ValueAndUnit	value;
		protected ObjectProperty														property;
		protected ObjectPropertyType										type;
		protected GridBagLayout															thisLayout;
		protected boolean																					showCategory						= false;
		protected boolean																					showID												= false;
		protected boolean																					showValueAndUnit		= true;
		protected boolean																					showDescriptors			= false;
		protected boolean																					fixedValue								= false;
		
	}

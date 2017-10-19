package org.qsari.effectopedia.data.quantification;

import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented.Documented_Value;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented.DualDescriptorComparator;
import org.qsari.effectopedia.data.quantification.DataSampleValueFactory.DataSampleDescriptorValue;
import org.qsari.effectopedia.gui.comp.custom_table_header.DefaultTableHeaderEditor.OptionsListener;

public class DataTemplatesGroupedTableModel extends DataTemplatesTableModel
	{
		
		public DataTemplatesGroupedTableModel(DataTemplates templates, OptionsListener optionsListener)
			{
				super(templates,optionsListener);
			}
		
		@Override
		public void synchroniseXData()
			{
				int templateCount = templates.size();
				DescriptorType descriptorType;
				DescriptorType groupingType;
				Comparator<ObjectProperty.ValueAndUnit> cmp;
				if ((primaryData.type.chartX instanceof DataSampleDescriptorValue) && (primaryData.type.chartGroup instanceof DataSampleDescriptorValue))
					{
						descriptorType = ((DataSampleDescriptorValue) primaryData.type.chartX).descriptorType;
						groupingType = ((DataSampleDescriptorValue) primaryData.type.chartGroup).descriptorType;
						cmp = new DualDescriptorComparator(descriptorType, groupingType);
					}
				else
					return;
				
				// Build a index for the common X axis descriptor and the group descriptor.
				// For each unique value
				HashMap<Double, HashMap<Double, BitSet>> xValuesIndex = new HashMap<Double, HashMap<Double, BitSet>>();
				for (int i = templateCount - 1; i >= 0; i--)
					{
						DataTemplate template = templates.get(i);
						ObjectPropertyMultivalued_Documented op = template.getObjProp();
						for (int j = op.valuesCount() - 1; j >= 0; j--)
							{
								Double xValue = template.type.chartX.get(op, j, 0);
								Double gValue = template.type.chartGroup.get(op, j, 0);
								if ((xValue != null) && (gValue != null))
									{
										HashMap<Double, BitSet> groupMap = xValuesIndex.get(xValue);
										BitSet indices;
										if (groupMap == null)
											{
												groupMap = new HashMap<Double, BitSet>();
												indices = new BitSet(templateCount);
											}
										else
											{
												indices = groupMap.get(gValue);
												if (indices == null)
													indices = new BitSet(templateCount);
											}
										indices.set(i, true);
										groupMap.put(gValue, indices);
										xValuesIndex.put(xValue, groupMap);
									}
							}
					}
				
				// Add a generic Documented_value for all values available in other
				// DataTemplates
				for (Iterator<Entry<Double, HashMap<Double, BitSet>>> it = xValuesIndex.entrySet().iterator(); it.hasNext();)
					{
						Entry<Double, HashMap<Double, BitSet>> entry = it.next();
						for (Iterator<Entry<Double, BitSet>> jit = entry.getValue().entrySet().iterator(); jit.hasNext();)
							{
								Entry<Double, BitSet> valEntry = jit.next();
								for (int i = templateCount - 1; i >= 0; i--)
									if (!valEntry.getValue().get(i))
										{
											Documented_Value dv = templates.get(i).getObjProp().add();
											dv.getDescriptor(descriptorType).setFromDouble(entry.getKey());
											dv.getDescriptor(groupingType).setFromDouble(valEntry.getKey());
										}
							}
					}
				
				// Sort all ObjectProperties
				for (DataTemplate template : templates)
					template.getObjProp().sort(cmp);
				
				// Check if all objectProperties have equal number of values
				//DEBUG_displayDataTemplate(descriptorType);
				fireTableDataChanged();
			}

		protected void DEBUG_displayDataTemplate(DescriptorType descriptorType)
			{
				for (DataTemplate template : templates)
					{
						ObjectPropertyMultivalued_Documented objProp = template.getObjProp();
						System.out.println("After sorting " + objProp.valuesCount());
						for (int i = 0; i < objProp.valuesCount(); i++)
							System.out.print(objProp.getValueAndUnitPair(i).getDescriptor(descriptorType).getDisplayValue());
						System.out.println();
						for (int i = 0; i < objProp.valuesCount(); i++)
							System.out.print(objProp.getValueAndUnitPair(i).getDisplayMinValue() + " ");
						System.out.println();
						for (int i = 0; i < objProp.valuesCount(); i++)
							System.out.print(objProp.getValueAndUnitPair(i).getDisplayValue() + " ");
						System.out.println();
						for (int i = 0; i < objProp.valuesCount(); i++)
							System.out.print(objProp.getValueAndUnitPair(i).getDisplayMaxValue() + " ");
						System.out.println();
					}
			}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex)
			{
				if (columIndex2TemplateIndex != null)
					{
						int templateIndex = columIndex2TemplateIndex[columnIndex];

						if ((sharedXData) && (columnIndex <= 1))
							for (DataTemplate template : templates)
								template.setObjPropValueAt(rowIndex, columnIndex, aValue);
						else
							templates.get(templateIndex).setObjPropValueAt(rowIndex, columnIndex - columnOffests[templateIndex], aValue);
						fireTableCellUpdated(rowIndex, columnIndex);
					}
			}

		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
	}

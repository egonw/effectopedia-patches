package org.qsari.effectopedia.gui.obj_prop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventObject;
import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import org.qsari.effectopedia.data.objects.DescriptorType;
import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectProperty;
import org.qsari.effectopedia.data.objects.ObjectProperty.ValueAndUnit;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented;
import org.qsari.effectopedia.data.objects.ObjectPropertyMultivalued_Documented.Documented_Value;
import org.qsari.effectopedia.data.objects.ObjectPropertyType;

public class ObjectPropertyTableModel extends AbstractTableModel
	{
		public static final int			VALUE_ROW											= 0;
		public static final int			RANGE_ROW											= 1;
		public static final int			DESCRIPTOR_LIST_ROW	= 2;
		public static final int			DESCRIPTOR_ROW						= 3;
		public static final int			REFERENCE_ROW							= 4;
		public static final int			SUBPROPERTIES_ROW			= 5;
		
		public static final int			SUB_PROP_NULL							= 0;
		public static final int			SUB_PROP_HIDDEN					= 1;
		public static final int			SUB_PROP_VISIBLE				= 2;
		/**
	 * 
	 */
		private static final long	serialVersionUID				= 1L;
		
		public ObjectPropertyTableModel(ObjectProperty objectProperty)
			{
				setObjectProperty(objectProperty);
			}
		
		@Override
		public int getColumnCount()
			{
				return 2 + ((objectProperty != null) ? objectProperty.valuesCount() : colCount);
			}
		
		@Override
		public int getRowCount()
			{
				if (objectProperty == null)
					{
						rowCount = 0;
						return rowCount;
					}
				rowCount = propertyType.isDocumented() ? 4 : 1;
				rowCount += objectProperty.getType().getDescriptorsCount();
				lastDescriptorRow = 2 + objectProperty.getType().getDescriptorsCount();
				allowSubPtop = propertyType.hasSubProperties();
				if (allowSubPtop)
					rowCount++;
				return rowCount;
			}
		
		public void addRow(Object aValue)
			{
				if (objectProperty != null)
					{
						int index = getRowCount() - 1;
						fireTableRowsInserted(index, index);
						fireObjectPropertyChanged(new EventObject(objectProperty));
					}
			}
		
		public void removeRow(int rowIndex)
			{
				if (objectProperty != null)
					{
						fireTableRowsDeleted(rowIndex, rowIndex);
						fireObjectPropertyChanged(new EventObject(objectProperty));
					}
			}
		
		public void reset()
			{
				if (objectProperty != null)
					{
						int count = getRowCount() - 1;
						fireTableRowsDeleted(0, count);
						fireObjectPropertyChanged(new EventObject(objectProperty));
					}
			}
		
		public ObjectProperty getObjectProperty()
			{
				return objectProperty;
			}
		
		public void setObjectProperty(ObjectProperty objectProperty)
			{
				this.objectProperty = objectProperty;
				if (objectProperty != null)
					{
						propertyType = (ObjectPropertyType) objectProperty.getType();
						this.descriptorsCount = propertyType.getDescriptorsCount();
						String tmp = propertyType.getDisplayName();
						if (tmp != null)
							rowNames.set(0, tmp);
						tmp = propertyType.getDescriptorsCaption();
						if (tmp != null)
							rowNames.set(DESCRIPTOR_LIST_ROW, tmp);
						rowNames.set(1, defaultRowNames[propertyType.isDocumented() ? 1 : 4]);
						allowSubPtop = propertyType.getSubPropertyTypes() != null;
						if (allowSubPtop)
							{
								if (subPropertyStatus == null)
									subPropertyStatus = new ArrayList<Integer>();
								subPropertyStatus.clear();
								subPropertyStatus.add(objectProperty.getValueAndUnit().getSubProperties() == null ? SUB_PROP_NULL : SUB_PROP_VISIBLE);
								for (int i = 1; i < objectProperty.valuesCount(); i++)
									subPropertyStatus.add(((ObjectPropertyMultivalued) objectProperty).getValueAndUnitPair(i).getSubProperties() == null ? SUB_PROP_NULL : SUB_PROP_HIDDEN);
							}
					}
				else
					descriptorsCount = 0;
				fireTableStructureChanged();
				fireTableDataChanged();
			}
		
		private String getNormalRange(Documented_Value dv)
			{
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				sb.append(dv.getDisplayMinValue());
				sb.append(",");
				sb.append(dv.getDisplayMaxValue());
				sb.append("] ");
				sb.append(dv.getDisplayUnit());
				return sb.toString();
			}
		
		public void setObjectAt(Object aValue, int rowIndex, int columnIndex)
			{
				if (objectProperty == null)
					return;
				if (columnIndex == 0)
					{
						
					}
				else if (columnIndex <= objectProperty.valuesCount())
					{
						if (propertyType.isDocumented())
							{
								Documented_Value dv = ((ObjectPropertyMultivalued_Documented) objectProperty).getValueAndUnitPair(columnIndex - 1);
								if (rowIndex == 0) // Value and unit
									parseValueAndUnit(dv, (String) aValue);
								else if (rowIndex == 1) // Normal Range
									parseNormalRange(dv, (String) aValue);
								else if (rowIndex == 2) // Descriptors
									;
								else if (rowIndex <= lastDescriptorRow)
									dv.getDescriptor(rowIndex - 3).setValueAndUnit((String) aValue);
								else if (rowIndex == lastDescriptorRow + 1) // References
									dv.setReferences((String) aValue);
								else
									subPropertyStatus.set(columnIndex - 1, (Integer) aValue);
							}
						else
							{
								ValueAndUnit vu = objectProperty.getValueAndUnit();
								if (rowIndex == 0) // Value and unit
									parseValueAndUnit(vu, (String) aValue);
								else if (rowIndex == 1) // Subproperties
									subPropertyStatus.set(columnIndex - 1, Integer.valueOf((String) aValue));
							}
						fireObjectPropertyChanged(new EventObject(objectProperty));
					}
			}
		
		private void parseValueAndUnit(ValueAndUnit vu, String valueAndUnit)
			{
				valueAndUnit = valueAndUnit.trim();
				int index = valueAndUnit.indexOf(" ");
				if (index == -1)
					vu.setValue(valueAndUnit);
				else
					{
						vu.setValue(valueAndUnit.substring(0, index));
						vu.setUnit(valueAndUnit.substring(index + 1));
					}
			}
		
		private void parseNormalRange(Documented_Value dv, String normalRange)
			{
				int minIndex = normalRange.indexOf("[");
				int maxIndex = normalRange.indexOf(",");
				if (maxIndex == -1)
					maxIndex = normalRange.indexOf(":");
				if (maxIndex == -1)
					return;
				int maxEndIndex = normalRange.indexOf("]", maxIndex);
				int unitIdex = normalRange.indexOf(" ", maxEndIndex == -1 ? maxIndex + 2 : maxEndIndex);
				if (maxEndIndex == -1)
					maxEndIndex = unitIdex + 1;
				if (maxEndIndex < maxIndex)
					maxEndIndex = normalRange.length();
				dv.setMinValue(normalRange.substring(minIndex + 1, maxIndex));
				dv.setMaxValue(normalRange.substring(maxIndex + 1, maxEndIndex));
				if (unitIdex > 0)
					dv.setUnit(normalRange.substring(unitIdex + 1).trim());
			}
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex)
			{
				if (columnIndex == 0)
					{
						if (objectProperty == null)
							return rowNames.get(rowIndex);
						if (rowIndex < 3)
							return rowNames.get(rowIndex);
						int descrIndex = rowIndex - 3;
						if (descrIndex < descriptorsCount)
							{
								ObjectPropertyType type = (ObjectPropertyType) objectProperty.getType();
								return "   " + type.getDescriptors().get(descrIndex);
							}
						else
							return rowNames.get(rowIndex - descriptorsCount);
					}
				if (columnIndex <= objectProperty.valuesCount())
					{
						if (propertyType.isDocumented())
							{
								Documented_Value dv = ((ObjectPropertyMultivalued_Documented) objectProperty).getValueAndUnitPair(columnIndex - 1);
								if (rowIndex == 0) // Value and unit
									return dv.getDisplayValue() + (dv.hasUnit() ? " " + dv.getDisplayUnit() : "");
								else if (rowIndex == 1) // Normal Range
									return getNormalRange(dv);
								else if (rowIndex == 2) // Descriptors
									return (columnIndex == 0) ? propertyType.getDescriptorsCaption() : "";
								else if (rowIndex <= lastDescriptorRow)
									return dv.getDescriptor(rowIndex - 3).getValueAndUnit();
								else if (rowIndex == lastDescriptorRow + 1) // References
									return dv.getReferences();
								else
									return subPropertyStatus.get(columnIndex - 1);
							}
						else
							{
								ValueAndUnit vu = objectProperty.getValueAndUnit();
								if (rowIndex == 0) // Value and unit
									return vu.getDisplayValue() + (vu.hasUnit() ? " " + vu.getDisplayUnit() : "");
								else if (rowIndex == 1)
									return subPropertyStatus.get(columnIndex - 1);
							}
					}
				return null;
			}
		
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex)
			{
				setObjectAt(aValue, rowIndex, columnIndex);
			}
		
		public void addValue()
			{
				if (objectProperty instanceof ObjectPropertyMultivalued_Documented)
					((ObjectPropertyMultivalued_Documented) objectProperty).add(((ObjectPropertyMultivalued_Documented) objectProperty).new Documented_Value());
				else if (objectProperty instanceof ObjectPropertyMultivalued)
					((ObjectPropertyMultivalued) objectProperty).add(((ObjectPropertyMultivalued) objectProperty).new ValueAndUnit());
				subPropertyStatus.add(SUB_PROP_NULL);
				fireTableStructureChanged();
				fireObjectPropertyChanged(new EventObject(objectProperty));
			}
		
		public void removeValue(int index)
			{
				if (propertyType.isAcceptingMultipleValues())
					if (((ObjectPropertyMultivalued) objectProperty).remove(index))
						fireTableStructureChanged();
				subPropertyStatus.remove(index);
				fireObjectPropertyChanged(new EventObject(objectProperty));
			}
		
		public boolean isCellEditable(int rowIndex, int columnIndex)
			{
				if (columnIndex == 0)
					return ((rowIndex != rowCount - 1) && (rowIndex > 1));
				return (columnIndex < getColumnCount() - 1);
			}
		
		@Override
		public String getColumnName(int col)
			{
				if (col < colNames.length)
					return colNames[col];
				else
					return "";
			}
		
		public int getRowType(int rowIndex)
			{
				if (rowIndex <= 2)
					return rowIndex;
				else if (rowIndex <= lastDescriptorRow)
					return DESCRIPTOR_ROW;
				else if (rowIndex == lastDescriptorRow + 1)
					return REFERENCE_ROW;
				else
					return SUBPROPERTIES_ROW;
			}
		
		public void addDescriptor(DescriptorType descriptorType)
			{
				if (propertyType.isDocumented())
					{
						((ObjectPropertyMultivalued_Documented) objectProperty).addDescriptor(descriptorType);
						this.descriptorsCount = objectProperty.getType().getDescriptorsCount();
						fireTableStructureChanged();
					}
			}
		
		public void removeDescriptor(DescriptorType descriptorType)
			{
				if (propertyType.isDocumented())
					{
						((ObjectPropertyMultivalued_Documented) objectProperty).removeDescriptor(descriptorType);
						this.descriptorsCount = objectProperty.getType().getDescriptorsCount();
						fireTableStructureChanged();
					}
			}
		
		public interface ObjectPropertyChangeListener
			{
				public void propertyChanged(EventObject evt);
			}
		
		public void addObjectPropertyChangeListener(ObjectPropertyChangeListener listener)
			{
				actionListeners.add(listener);
			}
		
		public void removeObjectPropertyChangeListener(ObjectPropertyChangeListener listener)
			{
				actionListeners.remove(listener);
			}
		
		protected void fireObjectPropertyChanged(EventObject evt)
			{
				for (ObjectPropertyChangeListener listener : actionListeners)
					listener.propertyChanged(evt);
			}
		
		public int updatesubPropertyStatus(int state, int visibleIndex)
			{
				ValueAndUnit vu;
				if (propertyType.isAcceptingMultipleValues())
					vu = ((ObjectPropertyMultivalued) objectProperty).getValueAndUnitPair(visibleIndex);
				else
					vu = objectProperty.getValueAndUnit();
				if (state == SUB_PROP_VISIBLE)
					{
						if (vu.getSubProperties() == null)
							vu.setSubProperties(new ObjectProperties(objectProperty.getOwner(), propertyType.getSubPropertyTypes()));
						for (int i = subPropertyStatus.size() - 1; i >= 0; i--)
							if ((i != visibleIndex) && (subPropertyStatus.get(i) == SUB_PROP_VISIBLE))
								subPropertyStatus.set(i, SUB_PROP_HIDDEN);
					}
				else
					{
						if ((state == SUB_PROP_NULL) && (vu.getSubProperties() != null))
							vu.setSubProperties(null);
						visibleIndex = findNextHiddenIndex(visibleIndex);
						if (subPropertyStatus.get(visibleIndex) == SUB_PROP_HIDDEN)
							{
								subPropertyStatus.set(visibleIndex, SUB_PROP_VISIBLE);
								for (int i = subPropertyStatus.size() - 1; i >= 0; i--)
									if ((i != visibleIndex) && (subPropertyStatus.get(i) == SUB_PROP_VISIBLE))
										subPropertyStatus.set(i, SUB_PROP_HIDDEN);
							}
						else
							return -1;
					}
				return visibleIndex;
			}

		protected int findNextHiddenIndex(int visibleIndex)
			{
				int maxIndex = subPropertyStatus.size() - 1;
				if (visibleIndex == maxIndex)
					visibleIndex = 0;
				else
					visibleIndex++;
				int remaining = maxIndex;
				while (subPropertyStatus.get(visibleIndex) == SUB_PROP_NULL)
					{
						visibleIndex++;
						if (visibleIndex == maxIndex)
							visibleIndex = 0;
						if (remaining-- == 0)
							break;
					}
				return visibleIndex;
			}
		
		public boolean isAllowSubPtop()
			{
				return allowSubPtop;
			}

		protected ArrayList<ObjectPropertyChangeListener>	actionListeners			= new ArrayList<ObjectPropertyChangeListener>();
		protected ArrayList<Integer>																						subPropertyStatus	= null;
		protected ObjectProperty																										objectProperty;
		protected ObjectPropertyType																						propertyType;
		protected int																																					rowCount;
		protected int																																					lastDescriptorRow	= 2;
		protected int																																					colCount										= 1;
		protected int																																					descriptorsCount		= 0;
		protected boolean																																	allowSubPtop						= false;
		public static final String[]																						defaultRowNames			= new String[]
																																																																							{ "Value and unit", "Normal Range", "Descriptors", "References", "Subproperties" };
		public LinkedList<String>																									rowNames										= new LinkedList<String>(Arrays.asList(defaultRowNames));
		private String[]																																		colNames										= new String[]
																																																																							{ "", "" };
		
	}

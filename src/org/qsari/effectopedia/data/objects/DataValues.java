package org.qsari.effectopedia.data.objects;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.table.AbstractTableModel;

import org.qsari.effectopedia.search.SearchableItem;

public class DataValues extends ArrayList<DataValue<?>>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public class ValueCaptionsModel extends AbstractListModel<String>
			{
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				public ValueCaptionsModel(boolean readonly)
					{
						super();
						this.readonly = readonly;
					}
				
				public int getSize()
					{
						return size();
					}
				
				public String getElementAt(int index)
					{
						SearchableItem si = get(index).searchItem;
						if (si != null)
							return si.getSearchName();
						else
							return null;
					}
				
				public boolean isReadonly()
					{
						return readonly;
					}

				
				private final boolean	readonly;
			};
		
		public class ValuesListModel extends AbstractListModel<String>
			{
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				public ValuesListModel(boolean readonly)
					{
						super();
						this.readonly = readonly;
					}
				
				public int getSize()
					{
						return size();
					}
				
				public String getElementAt(int index)
					{
						DataValue<?> dv = get(index);
						if (dv != null)
							return dv.toString();
						else
							return null;
					}
				
				public boolean isReadonly()
					{
						return readonly;
					}

				private final boolean	readonly;
			};
		
		class ValuesTableModel extends AbstractTableModel
			{
				/**
			 * 
			 */
				private static final long	serialVersionUID	= 1L;
				
				public ValuesTableModel(boolean readonly)
					{
						this.readonly = readonly;
					}
				
				public int getColumnCount()
					{
						return 1;
					}
				
				public int getRowCount()
					{
					//	System.out.println("rowCount:"+size());
						return size();
					}
				
				public Object getValueAt(int row, int column)
					{
						//System.out.println("valueAt: row"+row+" col"+column+" is "+get(row).toString());
						if (column == 0)
							return get(row).toString();
						else
							return null;
					}
				
				public boolean isCellEditable(int row, int column)
					{
						//System.out.println("Properties: row"+row+" col"+column+(readonly?"is readonly":"is not readonly"));
						return !readonly;
					}
				
				public Class<?> getColumnClass(int col)
					{
						return String.class;
					}
				
				public void setValueAt(Object value, int row, int col)
					{
						get(row).parseString((String) value);
					}
				
				public String getRowName(int c)
					{
						return columnNames[c];
					}
				
				public String[]							columnNames	= new String[]
																																							{ "Value" };
				private final boolean	readonly;
			}
		
		public ValuesTableModel getTableModel(boolean readonly)
			{
				return new ValuesTableModel(readonly);
			}
		
		public ValueCaptionsModel getCaptionsModel(boolean readonly)
			{
				return new ValueCaptionsModel(readonly);
			}

		public ValuesListModel getValueListModel(boolean readonly)
			{
				return new ValuesListModel(readonly);
			}

		
		public void removeBySearhIndexName(String name)
			{
				for (int i = size() - 1; i >= 0; i--)
					{
						SearchableItem si = get(i).searchItem;
						if ((si != null) && (si.getSearchName().compareTo(name) == 0))
							{
								remove(i);
								return;
							}
					}
			}
		
		public String[] getCaptions(boolean nonEmptyValuesOnly)
			{
				ArrayList<String> result = new ArrayList<String>(this.size());
				for (DataValue<?> dv : this)
					{
						SearchableItem si = dv.searchItem;
						if (si != null)
							if (nonEmptyValuesOnly)
								{
									if ((dv.toString().compareTo("") != 0))
										result.add(si.getSearchName());
								}
							else
								result.add(si.getSearchName());
					}
				return result.toArray(new String[result.size()]);
			}
		
		public String[] getValues(boolean nonEmptyValuesOnly)
			{
				ArrayList<String> result = new ArrayList<String>(this.size());
				for (DataValue<?> dv : this)
					if (nonEmptyValuesOnly)
						{
							String val = dv.toString();
							if (val.compareTo("") != 0)
								result.add(val);
						}
					else
						result.add(dv.toString());
				return result.toArray(new String[result.size()]);
			}
		
		public int getAssignedValuesCount()
			{
				int i = 0;
				for (DataValue<?> dv : this)
					{
						String val = dv.toString();
						if ((val != null) && (val.compareTo("") != 0))
							i++;
					}
				return i;
			}
		
	}

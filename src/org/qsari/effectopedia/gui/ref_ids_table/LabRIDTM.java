package org.qsari.effectopedia.gui.ref_ids_table;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.objects.Lab;

public class LabRIDTM extends ReferenceIDsTableModel<Lab>
	{
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public LabRIDTM(ReferenceIDs<Lab> referenceIDs, boolean readonly)
			{
				super(referenceIDs, readonly);
			}
		
		@Override
		public int getColumnCount()
			{
				return fieldsCount;
			}
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex)
			{
				Lab lab = ((ReferenceIDs<Lab>) referenceIDs).getCachedObject(rowIndex);
				return getFieldValue(lab, columnIndex);
			}
		
		public Object getObjectAt(int rowIndex, int columnIndex)
			{
				Lab lab = ((ReferenceIDs<Lab>) referenceIDs).getCachedObject(rowIndex);
				return getFieldValue(lab, columnIndex);
			}
		
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex)
			{
				Lab lab = ((ReferenceIDs<Lab>) referenceIDs).getCachedObject(rowIndex);
				setFieldValue(lab, columnIndex, (String) aValue);
			}
		
		public String getFieldValue(Lab lab, int valueIndex)
			{
				if (lab != null)
					{
						Class<?> c = lab.getClass();
						try
							{
								Method getter = c.getMethod("get" + fields[valueIndex]);
								return (String) getter.invoke(lab);
							}
						catch (IllegalAccessException e)
							{
								e.printStackTrace();
							}
						catch (IllegalArgumentException e)
							{
								e.printStackTrace();
							}
						catch (InvocationTargetException e)
							{
								e.printStackTrace();
							}
						catch (NoSuchMethodException e)
							{
								e.printStackTrace();
							}
						catch (SecurityException e)
							{
								e.printStackTrace();
							}
					}
				return null;
			}
		
		public void setFieldValue(Lab lab, int valueIndex, String value)
			{
				if (lab != null)
					{
						Class<?> c = lab.getClass();
						try
							{
								Method setter = c.getMethod("set" + fields[valueIndex], String.class);
								setter.invoke(lab, value);
							}
						catch (IllegalAccessException e)
							{
								e.printStackTrace();
							}
						catch (IllegalArgumentException e)
							{
								e.printStackTrace();
							}
						catch (InvocationTargetException e)
							{
								e.printStackTrace();
							}
						catch (NoSuchMethodException e)
							{
								e.printStackTrace();
							}
						catch (SecurityException e)
							{
								e.printStackTrace();
							}
					}
			}
		
		@Override
		public String getColumnName(int column)
			{
				return columnNames[column];
			}
		
		private static String[]	columnNames	= new String[]
																																							{ "lab name", "address", "country", "contact", "telephone", "e-mail", "website" };
		private static String[]	fields						= new String[]
																																							{ "Name", "Address", "Country", "Contact", "Telephone", "E_mail", "Website" };
		public static int							fieldsCount	= columnNames.length;
		
	}

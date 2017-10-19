package org.qsari.effectopedia.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import org.qsari.effectopedia.data.filter.FilteredIndex;
import org.qsari.effectopedia.data.filter.ManualSelectionFilter;
import org.qsari.effectopedia.gui.util.DistinctColorGenerator;

public class FiltredListUI extends JScrollPane
	{
		public static final int			NO_OPT											= 0;
		public static final int			SELECT_OPT							= 1;
		public static final int			COLOR_OPT								= 2;
		public static final int			DEFAULT_OPT						= SELECT_OPT;
		public static final int			ALL_OPT										= SELECT_OPT + COLOR_OPT;
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		private JTable												jtFiltredList;
		
		public FiltredListUI()
			{
				super();
				initGUI(DEFAULT_OPT);
			}
		
		public FiltredListUI(int options)
			{
				super();
				initGUI(options);
			}
		
		public class FilteredListTableModel extends AbstractTableModel
			{
				public FilteredListTableModel()
					{
						this.options = DEFAULT_OPT;
					}
				
				public FilteredListTableModel(int options)
					{
						this.options = options;
					}
				
				@Override
				public int getColumnCount()
					{
						int cnt = 1;
						if ((options & SELECT_OPT) == SELECT_OPT)
							cnt++;
						if ((options & COLOR_OPT) == COLOR_OPT)
							cnt++;
						return cnt;
					}
				
				@Override
				public int getRowCount()
					{
						return (filteredIndex != null) ? filteredIndex.count() : 0;
					}
				
				@Override
				public Object getValueAt(int rowIndex, int columnIndex)
					{
						if (columnIndex == 0)
							{
								if ((this.options & SELECT_OPT) != 0)
									return new Boolean(selectionFilter.filter(filteredIndex.getFiltredElements()[rowIndex]));
								if ((this.options & COLOR_OPT) != 0)
									return colors.get(rowIndex);
							}
						if ((columnIndex == 1) && ((this.options & ALL_OPT) == ALL_OPT))
							return colors.get(rowIndex);
						return filteredIndex.getFiltredElements()[rowIndex].toString();
					}
				
				@Override
				public void setValueAt(Object aValue, int rowIndex, int columnIndex)
					{
						if (filteredIndex != null)
							{
								if (columnIndex == 0)
									{
										if ((this.options & SELECT_OPT) != 0)
											selectionFilter.mark(filteredIndex.getFiltredElements()[rowIndex], (Boolean) aValue);
										else if ((this.options & COLOR_OPT) != 0)
											colors.set(rowIndex, (Color) aValue);
									}
								else if ((columnIndex == 1) && ((this.options & ALL_OPT) != 0))
									colors.set(rowIndex, (Color) aValue);
								fireTableCellUpdated(rowIndex, columnIndex);
							}
					}
				
				@Override
				public Class<?> getColumnClass(int columnIndex)
					{
						if (columnIndex == 0)
							{
								if ((this.options & SELECT_OPT) != 0)
									return Boolean.class;
								if ((this.options & COLOR_OPT) != 0)
									return Color.class;
							}
						if ((columnIndex == 1) && ((this.options & ALL_OPT) == ALL_OPT))
							return Color.class;
						return String.class;
					}
				
				public boolean isCellEditable(int rowIndex, int columnIndex)
					{
						return editable;
					}
				
				public void updateFilteredIndex()
					{
						this.colors.clear();
						this.colors.addAll(DistinctColorGenerator.generateColorsNoRed(filteredIndex.count()));
						fireTableDataChanged();
					}
				
				public final boolean isEdiable()
					{
						return editable;
					}
				
				public final void setEdiable(boolean ediable)
					{
						this.editable = ediable;
					}
				
				protected ArrayList<Color>	colors											= new ArrayList<Color>();
				protected boolean										editable									= true;
				protected int														options;
				private static final long		serialVersionUID	= 1L;
			}
		
		private void initGUI(int options)
			{
				try
					{
							{
								setPreferredSize(optimalSize);
								this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
								this.setBackground(Color.WHITE);
									{
										fltbTableModel = new FilteredListTableModel(options);
										jtFiltredList = new JTable();
										jtFiltredList.setModel(fltbTableModel);
										jtFiltredList.setBackground(Color.WHITE);
										jtFiltredList.setTableHeader(null);
										if (options > 0)
											{
												jtFiltredList.getColumnModel().getColumn(0).setPreferredWidth(32);
												if (options == ALL_OPT)
													jtFiltredList.getColumnModel().getColumn(1).setPreferredWidth(32);
											}
										this.setViewportView(jtFiltredList);
									}
							}
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
			}
		
		public FilteredIndex getFilteredIndex()
			{
				return filteredIndex;
			}
		
		public void setFilteredIndex(FilteredIndex filteredIndex)
			{
				this.filteredIndex = filteredIndex;
				this.selectionFilter = (ManualSelectionFilter) filteredIndex.getFilterByName(ManualSelectionFilter.DEFAULT_NAME);
				fltbTableModel.updateFilteredIndex();
			}
		
		protected FilteredListTableModel	fltbTableModel;
		protected FilteredIndex										filteredIndex;
		protected ManualSelectionFilter		selectionFilter;
		private Dimension																optimalSize	= new Dimension(400, 300);
	}

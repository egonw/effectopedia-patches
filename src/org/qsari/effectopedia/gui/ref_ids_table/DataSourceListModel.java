package org.qsari.effectopedia.gui.ref_ids_table;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.DataSourceItem;
import org.qsari.effectopedia.data.DataSources;

public class DataSourceListModel extends AbstractListModel<DataSourceItem> implements ComboBoxModel<DataSourceItem>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public DataSourceListModel()
			{
				super();
			}
		
		public DataSourceListModel(DataSources sources, boolean showAllItem)
			{
				super();
				this.showAllItem = showAllItem;
				this.sources = sources;
			}
		
		public void addElement(DataSourceItem source)
			{
				sources.add((DataSource) source);
			}
		
		public DataSourceItem getElementAt(int index)
			{
				if (index == sources.size())
					return sources;
				else
					return (DataSourceItem) sources.get(index);
			}
		
		public int getIndexOf(DataSourceItem source)
			{
				return sources.indexOf(source);
			}
		
		public DataSourceItem getSelectedItem()
			{
				if (selectedIndex >= 0)
					if (selectedIndex < sources.size())
						return (DataSourceItem) sources.get(selectedIndex);
					else
						return sources;
				else
					return null;
			}
		
		public int getSize()
			{
				return (showAllItem) ? sources.size() + 1 : sources.size();
			}
		
		public void insertElementAt(DataSourceItem source, int index)
			{
				sources.add(index, (DataSource) source);
				selectedIndex = -1;
			}
		
		public void removeAllElements()
			{
				sources.clear();
				selectedIndex = -1;
			}
		
		public void removeElement(DataSourceItem source)
			{
				sources.remove(source);
				selectedIndex = -1;
			}
		
		public void removeElementAt(int index)
			{
				if (index < sources.size())
					sources.remove(index);
				selectedIndex = -1;
			}
		
		@Override
		public void setSelectedItem(Object anItem)
			{
				if (anItem.equals(sources) && showAllItem)
					selectedIndex = sources.size();
				else
					selectedIndex = sources.indexOf(anItem);
				fireContentsChanged(sources, 0, this.sources.size());
			}
		
		public void setSources(DataSources sources)
			{
				this.sources = sources;
				fireContentsChanged(sources, 0, this.sources.size());
			}
		
		public String findLongestName()
			{
				int index = 0;
				int length = -1;
				for (int i = 0; i <= sources.size() - 1; i++)
					{
						String name = sources.get(i).toString();
						if (name.length() > length)
							{
								index = i;
								length = name.length();
							}
					}
				return sources.get(index).toString();
			}
		
		private DataSources	sources;
		private int									selectedIndex	= -1;
		private boolean					showAllItem;
	}

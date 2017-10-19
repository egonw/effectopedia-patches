package org.qsari.effectopedia.gui.ref_ids_table;

import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.gui.UIResources;

public class PathwayElementRIDTM<E extends PathwayElement> extends ReferenceIDsTableModel<E>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 3888158836520411142L;
		
		public enum Level
			{
				UPSTREAM_ASSOCIATION, UPSTREAM_MAPPING, CURRENT, DOWNSTREAM_ASSOCIATION, DOWNSTREAM_MAPPING
			}
		
		public PathwayElementRIDTM(ReferenceIDs<E> referenceIDs, boolean readonly)
			{
				super(referenceIDs, readonly);
			}

		public PathwayElementRIDTM(ReferenceIDs<E> referenceIDs, boolean readonly, int columnCount)
			{
				super(referenceIDs, readonly);
				this.columnCount = columnCount; 
			}
		
		public PathwayElementRIDTM(ReferenceIDs<E> referenceIDs, Level level, boolean readonly)
			{
				super(referenceIDs, readonly);
				this.level = level;
			}
		
		@Override
		public int getColumnCount()
			{
				return columnCount;
			}
		
		public void updateColumnWidths(JTable table)
			{
				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				Enumeration<TableColumn> columns = table.getColumnModel().getColumns();
				while (columns.hasMoreElements())
					{
						TableColumn column = columns.nextElement();
						int columnIndex = column.getModelIndex();
						int maxWidth;
						switch (level)
							{
								case UPSTREAM_ASSOCIATION:
									if (columnIndex != 1)
										maxWidth = 24;
									else
										maxWidth = Integer.MAX_VALUE;
									break;
								case DOWNSTREAM_MAPPING:
								case UPSTREAM_MAPPING:
								case DOWNSTREAM_ASSOCIATION:
									if (columnIndex != 4)
										maxWidth = 24;
									else
										maxWidth = Integer.MAX_VALUE;
									break;
								default:
									maxWidth = Integer.MAX_VALUE;
							}
						column.setMaxWidth(maxWidth);
					}
			}
		
		public Class<?> getColumnClass(int columnIndex)
			{
				switch (level)
					{
						case UPSTREAM_ASSOCIATION:
							if (columnIndex != 1)
								return ImageIcon.class;
							else
								return String.class;
						case UPSTREAM_MAPPING:
						case DOWNSTREAM_MAPPING:
						case DOWNSTREAM_ASSOCIATION:
							if (columnIndex != 4)
								return ImageIcon.class;
							else
								return String.class;
						default:
							return String.class;
					}
			}
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex)
			{
				Object pathwayElement = getObjectAt(rowIndex, columnIndex);
				if ((pathwayElement instanceof PathwayElement) && (pathwayElement != null))
					return ((PathwayElement) pathwayElement).getTitle();
				else
					return pathwayElement;
			}
		
		public Object getObjectAt(int rowIndex, int columnIndex)
			{
				PathwayElement pathwayElement = ((ReferenceIDs<E>) referenceIDs).getCachedObject(rowIndex);
				switch (level)
					{
						case UPSTREAM_ASSOCIATION:
							if (columnIndex == 3)
								return UIResources.getIconForClass(pathwayElement.getClass());
							else if (columnIndex <= 1)
								if (pathwayElement.hasIncommingAssociations())
									{
										if (columnIndex == 0)
											return UIResources.getIconForClass(pathwayElement.incommingAssociations()[0].getClass());
										return pathwayElement.incommingAssociations()[0];
									}
								else
									return null;
							else if ((columnIndex == 2) || (columnIndex == 4))
								return UIResources.imageArrowRight;
						case DOWNSTREAM_ASSOCIATION:
							if (columnIndex == 1)
								return UIResources.getIconForClass(pathwayElement.getClass());
							else if (columnIndex >= 3)
								if (pathwayElement.hasOutgoingAssociations())
									{
										if (columnIndex == 3)
											return UIResources.getIconForClass(pathwayElement.outgoingAssociations()[0].getClass());
										return pathwayElement.outgoingAssociations()[0];
									}
								else
									return null;
							else 
								{
									if ((columnIndex == 0)&&(!horizontalPlacement))
										return UIResources.imageArrowDownRight;
									else
										return UIResources.imageArrowRight;
								}
						case UPSTREAM_MAPPING:
							if (columnIndex == 1)
								return UIResources.getIconForClass(pathwayElement.getClass());
							else if (columnIndex >= 3)
								if (pathwayElement.hasIncommingMappings())
									{
										if (columnIndex == 3)
											return UIResources.getIconForClass(pathwayElement.incommingMappings()[0].getClass());
										return pathwayElement.incommingMappings()[0];
									}
								else
									return null;
							else if ((columnIndex == 0) || (columnIndex == 2))
								return UIResources.imageArrowRight;
						case DOWNSTREAM_MAPPING:
							if (columnIndex == 1)
								return UIResources.getIconForClass(pathwayElement.getClass());
							else if (columnIndex >= 3)
								if (pathwayElement.hasOutgoingMappings())
									{
										if (columnIndex == 3)
											return UIResources.getIconForClass(pathwayElement.outgoingMappings()[0].getClass());
										return pathwayElement.outgoingMappings()[0];
									}
								else
									return null;
							else if (columnIndex == 0)
								return UIResources.imageArrowDownRight;
							else
								return UIResources.imageArrowRight;
						default:
							return pathwayElement;
					}
			}
		
		public PathwayElement getPathwayElementAt(int rowIndex, int columnIndex)
			{
				PathwayElement pathwayElement = ((ReferenceIDs<E>) referenceIDs).getCachedObject(rowIndex);
				switch (level)
					{
						case UPSTREAM_ASSOCIATION:
							if (columnIndex >= 3)
								return pathwayElement;
							else if (pathwayElement.hasIncommingAssociations())
								return pathwayElement.incommingAssociations()[0];
							else
								return null;
						case DOWNSTREAM_ASSOCIATION:
							if (columnIndex <= 1)
								return pathwayElement;
							else if (pathwayElement.hasOutgoingAssociations())
								return pathwayElement.outgoingAssociations()[0];
							return null;
						case UPSTREAM_MAPPING:
							if (columnIndex <= 1)
								return pathwayElement;
							else if (pathwayElement.hasIncommingMappings())
								return pathwayElement.incommingMappings()[0];
							else
								return null;
						case DOWNSTREAM_MAPPING:
							if (columnIndex <= 1)
								return pathwayElement;
							else if (pathwayElement.hasOutgoingMappings())
								return pathwayElement.outgoingMappings()[0];
							else
								return null;
						default:
							return pathwayElement;
					}
			}
		
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex)
			{
			}
		
		public void addValue(Object aValue)
			{
			}
		
		public boolean isHorizontalPlacement()
			{
				return horizontalPlacement;
			}

		public void setHorizontalPlacement(boolean horizontalPlacement)
			{
				this.horizontalPlacement = horizontalPlacement;
			}

		protected Level	level	= Level.CURRENT;
		protected int columnCount = 5;
		protected boolean horizontalPlacement = true;
	}

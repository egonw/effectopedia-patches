package org.qsari.effectopedia.gui.ref_ids_table;

import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.objects.Pathway;

public class PathwayRIDTM extends ReferenceIDsTableModel<Pathway>
	{
		/**
	 * 
	 */
	private static final long	serialVersionUID	= 7257011959729234971L;

		public enum Level
			{
				UPSTREAM, CURRENT, DOWNSTREAM
			}
		
		public PathwayRIDTM(ReferenceIDs<Pathway> referenceIDs,boolean readonly)
			{
				super(referenceIDs,readonly);
			}
		
		public PathwayRIDTM(ReferenceIDs<Pathway> referenceIDs, Level level, boolean readonly)
			{
				super(referenceIDs,readonly);
				this.level = level;
			}
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex)
			{
				Pathway pathway = ((ReferenceIDs<Pathway>) referenceIDs).getCachedObject(rowIndex);
				return pathway.getTitle();
			}
		
		public Object getObjectAt(int rowIndex, int columnIndex)
			{
				Pathway pathway = ((ReferenceIDs<Pathway>) referenceIDs).getCachedObject(rowIndex);
				return pathway;
			}
		
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex)
			{
			}
		
		public void addValue(Object aValue)
			{
			}
		
		protected Level	level	= Level.CURRENT;
	}

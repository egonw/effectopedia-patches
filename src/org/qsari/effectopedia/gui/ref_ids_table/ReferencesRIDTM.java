package org.qsari.effectopedia.gui.ref_ids_table;

import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.objects.Reference;

public class ReferencesRIDTM extends ReferenceIDsTableModel<Reference>
	{
		/**
	 * 
	 */
	private static final long	serialVersionUID	= 11618547003001996L;

		public ReferencesRIDTM(ReferenceIDs<Reference> referenceIDs, boolean readonly)
			{
				super(referenceIDs,readonly);
			}
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex)
			{
				Reference reference = ((ReferenceIDs<Reference>)referenceIDs).getCachedObject(rowIndex);
				return reference.getFormatedReference();
			}
		
		@Override
		public void 	setValueAt(Object aValue, int rowIndex, int columnIndex) 
	 	{
				if (readonly)
					return;
				Reference reference = ((ReferenceIDs<Reference>)referenceIDs).getCachedObject(rowIndex);
	 	 reference.setFormatedReference((String)aValue);
	 	 referenceIDs.updateIDsFromObjects();
	 	}
		
		public void 	addValue(Object aValue) 
	 	{
				Reference reference = new Reference(null,null);
				reference.setFormatedReference((String)aValue);
	 	 referenceIDs.add(reference);
	 	}
	
	}

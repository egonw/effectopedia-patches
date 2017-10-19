package org.qsari.effectopedia.core.objects;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;

public class Initiator_StructuralAlerts extends Initiator implements Importable, Exportable, Cloneable, Traceable
	{
		public Initiator_StructuralAlerts()
			{
				super();
			}
		
		public Initiator_StructuralAlerts(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent,dataSource);
			}
		

		@Override
				public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
			}

		public void cloneFieldsTo(Initiator_StructuralAlerts clone,DataSource dataSource)
			{
				super.cloneFieldsTo(clone,dataSource);
			}
		
		public Initiator_StructuralAlerts clone()
			{
				Initiator_StructuralAlerts clone = new Initiator_StructuralAlerts(null,dataSource);
				cloneFieldsTo(clone,dataSource);
				clone.setParent(parent);
				return clone;
			}
		
		public Initiator_StructuralAlerts clone(EffectopediaObject parent, DataSource dataSource)
			{
				Initiator_StructuralAlerts clone = new Initiator_StructuralAlerts(parent,dataSource);
				cloneFieldsTo(clone,dataSource);
				return clone;
			}

	}

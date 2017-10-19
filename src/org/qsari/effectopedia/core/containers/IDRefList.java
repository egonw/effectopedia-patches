package org.qsari.effectopedia.core.containers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.base.ids.ReferenceID;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.DataSourceMerge;

public class IDRefList extends EffectopediaObjects<ReferenceID<EffectopediaObject>>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public boolean addNew(EffectopediaObject parent, DataSource dataSource, Class<ReferenceID<EffectopediaObject>> objectClass)
			{
				ReferenceID<EffectopediaObject> l = new ReferenceID<EffectopediaObject>(parent, dataSource, EffectopediaObject.class);
				ReferenceID<EffectopediaObject> old = put(l.getID(), l);
				return (old == null) || (old == l);
			}
		
		public ReferenceID<?>[] get()
			{
				return values().toArray(new ReferenceID[values().size()]);
			}
		
		public void replaceExternalIDReferencesWithIDs(HashMap<Long, EffectopediaObject> idMap)
			{
				Iterator<java.util.Map.Entry<Long, ReferenceID<EffectopediaObject>>> it = entrySet().iterator();
				while (it.hasNext())
					{
						java.util.Map.Entry<Long, ReferenceID<EffectopediaObject>> entry = it.next();
						ReferenceID<EffectopediaObject> referenceID = entry.getValue();
						referenceID.replaceExternalReferenceID(idMap);
					}
			}
		
		public void updateReferrals(HashMap<Long, EffectopediaObject> referrals)
			{
				for (Map.Entry<Long, ReferenceID<EffectopediaObject>> entry : entrySet())
					entry.getValue().updateReferrals(referrals);
			}

		public void updateReferrals(DataSourceMerge dsm)
			{
				for (Map.Entry<Long, ReferenceID<EffectopediaObject>> entry : entrySet())
					entry.getValue().updateReferrals(dsm);
			}
		
		public String toString()
			{
				return "effectopedia object identifier reference";
			}
		
	}

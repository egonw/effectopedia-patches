package org.qsari.effectopedia.core.containers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.DataSourceMerge;

public class IDsRefList extends EffectopediaObjects<ReferenceIDs<EffectopediaObject>>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;

		public boolean addNew(EffectopediaObject parent, DataSource dataSource, Class<ReferenceIDs<EffectopediaObject>> objectClass)
			{
				ReferenceIDs<EffectopediaObject> l = new ReferenceIDs<EffectopediaObject>(parent, dataSource, EffectopediaObject.class);
				ReferenceIDs<EffectopediaObject> old = put(l.getID(), l);
				return (old == null) || (old == l);
			}
		
		public ReferenceIDs<?>[] get()
			{
				return values().toArray(new ReferenceIDs[values().size()]);
			}
		
		public void replaceExternalIDReferencesWithIDs(HashMap<Long, EffectopediaObject> idMap)
			{
				Iterator<java.util.Map.Entry<Long, ReferenceIDs<EffectopediaObject>>> it = entrySet().iterator();
				while (it.hasNext())
					{
						java.util.Map.Entry<Long, ReferenceIDs<EffectopediaObject>> entry = it.next();
						ReferenceIDs<EffectopediaObject> referenceIDs = entry.getValue();
						referenceIDs.replaceExternalReferenceID(idMap);
					}
			}
		
		public void updateReferrals(HashMap<Long, EffectopediaObject> referrals)
			{
				for (Map.Entry<Long, ReferenceIDs<EffectopediaObject>> entry : entrySet())
					entry.getValue().updateReferrals(referrals);
			}

		public void updateReferrals(DataSourceMerge dsm)
			{
				for (Map.Entry<Long, ReferenceIDs<EffectopediaObject>> entry : entrySet())
					entry.getValue().updateReferrals(dsm);
			}

		public void DEBUG_pintContainedIDs()
			{
				Iterator<Map.Entry<Long, ReferenceIDs<EffectopediaObject>>> it = entrySet().iterator();
				while (it.hasNext())
					{
						ReferenceIDs<EffectopediaObject> e = it.next().getValue();
						if (e == null)
							continue;
						StringBuilder sb = new StringBuilder();
						sb.append(e.getClass());
						sb.append("\tID=\t");
						sb.append(e.getID());
						sb.append("\textID=\t");
						sb.append(e.getExternalID());
						sb.append("\tdefID=\t");
						sb.append(e.getDefaultID());
						sb.append("\tObjectIDs");
						for (Long l : e.getCachedIDs())
							{
								sb.append("\t");
								sb.append(l);
							}
						EffectopediaObject[] obj = null;
						try
							{
								obj = e.getCachedObjects();
								if (obj != null)
									for (EffectopediaObject eo : obj)
										{
											sb.append("\teo\t");
											sb.append((eo == null ? "NULL" : eo));
										}
							}
						catch (Exception e2)
							{
								sb.append("\t exception!");
							}
						System.out.println(sb.toString());
					}
			}
		
		public String toString()
			{
				return "effectopedia object identifier references";
			}

		

	}

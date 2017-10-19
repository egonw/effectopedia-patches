package org.qsari.effectopedia.core.containers;

import java.util.HashMap;
import java.util.Map;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.DataSourceMerge;

public class Pathways extends EffectopediaObjects<Pathway>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public boolean addNew(EffectopediaObject parent, DataSource dataSource, Class<Pathway> objectClass)
			{
				Pathway p = new Pathway(parent, dataSource);
				Pathway old = put(p.getID(), p);
				return (old == null) || (old == p);
			}
		
		public Pathway[] get()
			{
				return values().toArray(new Pathway[values().size()]);
			}
		
		public long getLastID()
			{
				long pathwayID = 0;
				for (Pathway pathway : values())
					if (pathway.getID() >= pathwayID)
						pathwayID = pathway.getID();
				return pathwayID;
			}
		
		public void updateReferrals(HashMap<Long, EffectopediaObject> referrals)
			{
				for (Map.Entry<Long, Pathway> entry : entrySet())
					entry.getValue().updateReferrals(referrals);
			}

		public void updateReferrals(DataSourceMerge dsm)
			{
				for (Map.Entry<Long, Pathway> entry : entrySet())
					entry.getValue().updateReferrals(dsm);
			}
		
		public String toString()
			{
				return "pathways";
			}
		
		public static final Class<Pathway>	objectsClass	= Pathway.class;
	}

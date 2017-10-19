package org.qsari.effectopedia.core.containers;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.core.objects.SubstanceData;
import org.qsari.effectopedia.data.DataSource;

public class SubstanceDataCollections extends EffectopediaObjects<SubstanceData>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public boolean addNew(EffectopediaObject parent, DataSource dataSource, Class<SubstanceData> objectClass)
			{
				SubstanceData s = null;
				try
					{
						s = objectClass.newInstance();
						s.setParent(parent);
						s.setDataSource(dataSource);
					}
				catch (InstantiationException ie)
					{
						ie.printStackTrace();
					}
				catch (IllegalAccessException iae)
					{
						iae.printStackTrace();
					}
				SubstanceData old = put(s.getID(), s);
				return (old == null) || (old == s);
			}
		
		public SubstanceData[] get()
			{
				return values().toArray(new SubstanceData[values().size()]);
			}
		
		public String toString()
			{
				return "substance data";
			}
		
	}

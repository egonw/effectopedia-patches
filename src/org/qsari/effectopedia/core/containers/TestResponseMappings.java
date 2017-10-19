package org.qsari.effectopedia.core.containers;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.core.objects.TestResponseMapping;
import org.qsari.effectopedia.data.DataSource;

public class TestResponseMappings extends EffectopediaObjects<TestResponseMapping>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public boolean addNew(EffectopediaObject parent, DataSource dataSource, Class<TestResponseMapping> objectClass)
			{
				TestResponseMapping t = new TestResponseMapping(parent, dataSource);
				TestResponseMapping old = put(t.getID(), t);
				return (old == null) || (old == t);
			}
		
		public String toString()
			{
				return "test response mappings";
			}
		
		public static final Class<?>	objectsClass	= TestResponseMapping.class;
	}

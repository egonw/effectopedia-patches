package org.qsari.effectopedia.core.objects;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public class Test_InVivo extends Test_InLab
	{
		public Test_InVivo()
			{
				super();
				descriptionIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_IN_VIVO_TEST_IDS);
				labIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_LAB_IDS);
				relatedEffectMappingIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_TEST_RESP_MAPPING_REFIDS);
				relatedTestIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REL_TEST_IDS);
				this.testType = TestType.IN_VIVO;
			}
		
		public Test_InVivo(EffectopediaObject parent,DataSource dataSource)
			{
				super(parent,dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_IN_VIVO_TEST_IDS.clone(this,dataSource);
				labIDs = DefaultEffectopediaObjects.DEFAULT_LAB_IDS.clone(this,dataSource);
				relatedEffectMappingIDs = DefaultEffectopediaObjects.DEFAULT_TEST_RESP_MAPPING_REFIDS.clone(this,dataSource);
				relatedTestIDs = DefaultEffectopediaObjects.DEFAULT_REL_TEST_IDS.clone(this,dataSource);
				this.testType = TestType.IN_VIVO;
			}

		public Test_InVivo clone()
			{
				Test_InVivo clone = new Test_InVivo(null,dataSource);
				cloneFieldsTo(clone,dataSource);
				clone.setParent(parent);
				return clone;
			}
		
		public Test_InVivo clone(EffectopediaObject parent,DataSource dataSource)
			{
				Test_InVivo clone = new Test_InVivo(parent,dataSource);
				cloneFieldsTo(clone,dataSource);
				return clone;
			}

	}

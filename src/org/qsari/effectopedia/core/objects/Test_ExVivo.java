package org.qsari.effectopedia.core.objects;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public class Test_ExVivo extends Test_InLab
	{
		public Test_ExVivo()
			{
				super();
				descriptionIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_EX_VIVO_TEST_IDS);
				labIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_LAB_IDS);
				relatedEffectMappingIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_TEST_RESP_MAPPING_REFIDS);
				relatedTestIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REL_TEST_IDS);
				this.testType = TestType.EX_VIVO;
			}
		
		public Test_ExVivo(EffectopediaObject parent,DataSource dataSource)
			{
				super(parent,dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_EX_VIVO_TEST_IDS.clone(this,dataSource);
				labIDs = DefaultEffectopediaObjects.DEFAULT_LAB_IDS.clone(this,dataSource);
				relatedEffectMappingIDs = DefaultEffectopediaObjects.DEFAULT_TEST_RESP_MAPPING_REFIDS.clone(this,dataSource);
				relatedTestIDs = DefaultEffectopediaObjects.DEFAULT_REL_TEST_IDS.clone(this,dataSource);
				this.testType = TestType.EX_VIVO;
			}

		public Test_ExVivo clone()
			{
				Test_ExVivo clone = new Test_ExVivo(null,dataSource);
				cloneFieldsTo(clone,dataSource);
				clone.setParent(parent);
				return clone;
			}
		
		public Test_ExVivo clone(EffectopediaObject parent,DataSource dataSource)
			{
				Test_ExVivo clone = new Test_ExVivo(parent,dataSource);
				cloneFieldsTo(clone,dataSource);
				return clone;
			}

	}

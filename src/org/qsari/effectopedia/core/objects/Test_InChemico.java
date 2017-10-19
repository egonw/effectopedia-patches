package org.qsari.effectopedia.core.objects;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;

public class Test_InChemico extends Test_InLab
	{
		public Test_InChemico()
			{
				super();
				descriptionIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_IN_CHEMICO_TEST_IDS);
				labIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_LAB_IDS);
				relatedEffectMappingIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_TEST_RESP_MAPPING_REFIDS);
				relatedTestIDs = DefaultEffectopediaObjects.get(DefaultEffectopediaObjects.DEFAULT_REL_TEST_IDS);
				this.testType = TestType.IN_CHEMICO;
			}
		
		public Test_InChemico(EffectopediaObject parent,DataSource dataSource)
			{
				super(parent,dataSource);
				descriptionIDs = DefaultEffectopediaObjects.DEFAULT_IN_CHEMICO_TEST_IDS.clone(this,dataSource);
				labIDs = DefaultEffectopediaObjects.DEFAULT_LAB_IDS.clone(this,dataSource);
				relatedEffectMappingIDs = DefaultEffectopediaObjects.DEFAULT_TEST_RESP_MAPPING_REFIDS.clone(this,dataSource);
				relatedTestIDs = DefaultEffectopediaObjects.DEFAULT_REL_TEST_IDS.clone(this,dataSource);
				this.testType = TestType.IN_CHEMICO;
			}

		public Test_InChemico clone()
			{
				Test_InChemico clone = new Test_InChemico(null,dataSource);
				cloneFieldsTo(clone,dataSource);
				clone.setParent(parent);
				return clone;
			}
		
		public Test_InChemico clone(EffectopediaObject parent,DataSource dataSource)
			{
				Test_InChemico clone = new Test_InChemico(parent,dataSource);
				cloneFieldsTo(clone,dataSource);
				return clone;
			}

	}

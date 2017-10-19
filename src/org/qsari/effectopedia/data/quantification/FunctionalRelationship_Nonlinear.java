package org.qsari.effectopedia.data.quantification;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultDataTemplates;
import org.qsari.effectopedia.defaults.DefaultEffectopediaObjects;
import org.qsari.effectopedia.gui.comp.custom_table_header.DefaultTableHeaderEditor.OptionsListener;

public class FunctionalRelationship_Nonlinear extends FunctionalRelationship
	{
		public FunctionalRelationship_Nonlinear()
			{
				super();
				this.dataType = UNDEFINED;
			}
		
		public FunctionalRelationship_Nonlinear(EffectopediaObject owner, int dataType)
			{
				this.owner = owner;
				this.dataType = dataType;
				if (dataType == DOSE_RESPONSE)
					{
						this.properties = DefaultEffectopediaObjects.DEFAULT_D_RESP_DATA.clone(owner, owner.getDataSource());
						this.templates = DefaultDataTemplates.DTS_DR_SINGLE_CHEM_ALL.clone();
					}
				else if (dataType == RESPONSE_RESPONSE)
					{
						this.properties = DefaultEffectopediaObjects.DEFAULT_RESP_RESP_DATA.clone(owner, owner.getDataSource());
						this.templates = DefaultDataTemplates.DTS_RESP_RESP_ALL.clone();
					}
				else
					{
						this.properties = DefaultEffectopediaObjects.DEFAULT_LINK_TIME_COURSE_DATA.clone(owner, owner.getDataSource());
						this.templates = DefaultDataTemplates.DTS_TIME_COURSE_ALL.clone();
					}
				this.templates.setProperties(properties);
				this.templates.setOwner(owner);
			}
		
		public void cloneFieldsTo(FunctionalRelationship clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				((FunctionalRelationship_Nonlinear) clone).dataType = this.dataType;
			}
		
		public DataSeries rebuildSeries()
			{
				return templates.get(0).rebuildSeries();
			}
		
		public ModifiableTableModel generateTableModel()
			{
				if (templates.isUsingGroups())
					return new DataTemplatesGroupedTableModel(templates, optionsListener);
				else
					return new DataTemplatesTableModel(templates, optionsListener);
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						dataType = Integer.valueOf(element.getAttributeValue("data_type"));
						super.load(element, io);
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.setAttribute("data_type", dataType);
				return element;
			}
		
		public int getDataType()
			{
				return dataType;
			}
		
		public static int getDataType(BaseIOElement element)
			{
				return Integer.valueOf(element.getAttributeValue("data_type"));
			}
		
		public void setDataType(int dataType)
			{
				this.dataType = dataType;
			}
		
		public OptionsListener getOptionsListener()
			{
				return optionsListener;
			}
		
		public void setOptionsListener(OptionsListener optionsListener)
			{
				this.optionsListener = optionsListener;
			}
		
		protected OptionsListener	optionsListener;
		protected int													dataType										= DOSE_RESPONSE;
		public static final int			UNDEFINED									= -1;
		public static final int			DOSE_RESPONSE					= 0;
		public static final int			RESPONSE_RESPONSE	= 1;
		public static final int			TIME_COURSE							= 2;
		
	}

package org.qsari.effectopedia.data.quantification;

public class DTsDispalySettingsFactory
	{
		public static DTsDefaultDispalySettings						DEFAULT_SETTINGS;
		public static DTsDualYDispalySettings								DUAL_YAXIS_SETTINGS;
		public static DTsGroupedDualYDispalySettings	DUAL_GRP_SETTINGS;
		public static DTsGroupedDispalySettings						DEFAULT_GRP_SETTINGS;
		
		public static DTsDefaultDispalySettings getSettings(DataTemplates templates, DataTemplatesTableModel tableModel)
			{
				DTsDefaultDispalySettings settings;
				if (templates.secondaryAxisTemplateIndex == DataTemplates.NO_SECONDARY_AXIS)
					if (templates.isUsingGroups())
						{
							if (DEFAULT_GRP_SETTINGS == null)
								DEFAULT_GRP_SETTINGS = new DTsGroupedDispalySettings(templates, tableModel);
							settings = DEFAULT_GRP_SETTINGS;
						}
					else
						{
							if (DEFAULT_SETTINGS == null)
								DEFAULT_SETTINGS = new DTsDefaultDispalySettings(templates, tableModel);
							settings = DEFAULT_SETTINGS;
						}
				else if (templates.isUsingGroups())
					{
						if (DUAL_GRP_SETTINGS == null)
							DUAL_GRP_SETTINGS = new DTsGroupedDualYDispalySettings(templates, tableModel);
						settings = DUAL_GRP_SETTINGS;
					}
				else
					{
						if (DUAL_YAXIS_SETTINGS == null)
							DUAL_YAXIS_SETTINGS = new DTsDualYDispalySettings(templates, tableModel);
						settings = DUAL_YAXIS_SETTINGS;
					}
				settings.templates = templates;
				settings.tableModel = tableModel;
				return settings;
			}
		
	}

package org.qsari.effectopedia.data.json;

import java.util.ArrayList;

import org.qsari.effectopedia.data.RevisionBasedDS;
import org.qsari.effectopedia.data.formats.DataSourceFormat;
import org.qsari.effectopedia.data.formats.FormatFlavour;
import org.qsari.effectopedia.notification.NotificationManager;

public class JSONDataSourceFormat implements DataSourceFormat
	{
		public static JSONDataSourceFormat JSONFormat_Jakson = new JSONDataSourceFormat();
		
		public JSONDataSourceFormat()
			{
				flavours = new ArrayList<FormatFlavour>();
				flavours.add(FormatFlavour.JSON);
			}
		
		@Override
		public RevisionBasedDS createDataSource()
			{
				return new JSONFileDS();
			}
		
		@Override
		public RevisionBasedDS createDataSource(FormatFlavour withFlavour)
			{
				return createDataSource();
			}

		@Override
		public NotificationManager createNotificationManager()
			{
				return null;
			}
		
		@Override
		public String getFormatName()
			{
				return formatName;
			}
		
		@Override
		public ArrayList<FormatFlavour> getFlavours()
			{
				return flavours;
			}
		
		@Override
		public String getImplementationDescription()
			{
				return description;
			}

		@Override
		public boolean isCompatible(String fileName, FormatFlavour withFlavour)
			{
				// TODO Validation needed
				return true;
			}

		@Override
		public SupportedFeatures allows()
			{
				return SupportedFeatures.EXPORT;
			}

		protected ArrayList<FormatFlavour>	flavours;
		protected String																			formatName		= "JSON file format";
		protected String																			description	= "Single file implementation based on Jackson";


	}

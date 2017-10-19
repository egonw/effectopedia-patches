package org.qsari.effectopedia.data.formats;

import java.util.ArrayList;

import org.qsari.effectopedia.data.RevisionBasedDS;
import org.qsari.effectopedia.notification.NotificationManager;

public interface DataSourceFormat
	{
		public enum SupportedFeatures
			{
			NONE, IMPORT, EXPORT, IMPORT_EXPORT
			}
			
		public RevisionBasedDS createDataSource();
		
		public RevisionBasedDS createDataSource(FormatFlavour withFlavour);
		
		public NotificationManager createNotificationManager();
		
		public String getFormatName();
		
		public String getImplementationDescription();
		
		public ArrayList<FormatFlavour> getFlavours();
		
		public boolean isCompatible(String sourceName, FormatFlavour withFlavour);
		
		public SupportedFeatures allows();
	}

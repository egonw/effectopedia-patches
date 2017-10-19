package org.qsari.effectopedia.data.html;

import java.util.ArrayList;

import org.qsari.effectopedia.data.RevisionBasedDS;
import org.qsari.effectopedia.data.formats.DataSourceFormat;
import org.qsari.effectopedia.data.formats.FormatFlavour;
import org.qsari.effectopedia.data.xml.XMLNotificationManager;
import org.qsari.effectopedia.notification.NotificationManager;

public class HTMLFileFormat implements DataSourceFormat
	{
		
		public static HTMLFileFormat HTMLFormat_JDOM = new HTMLFileFormat();
		
		public HTMLFileFormat()
					{
						flavours = new ArrayList<FormatFlavour>();
						flavours.add(FormatFlavour.HTML);
					}
		
		@Override
		public RevisionBasedDS createDataSource()
			{
				return new HTMLFileExport();
			}
			
		@Override
		public RevisionBasedDS createDataSource(FormatFlavour withFlavour)
			{
				HTMLFileExport htmlFile = new HTMLFileExport();
				htmlFile.setDataFormatFlavour(withFlavour);
				return htmlFile;
			}
			
		@Override
		public NotificationManager createNotificationManager()
			{
				return new XMLNotificationManager();
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
				return withFlavour == FormatFlavour.HTML;
			}

		@Override
		public SupportedFeatures allows()
			{
				return SupportedFeatures.EXPORT;
			}

		protected ArrayList<FormatFlavour>	flavours;
		protected String																			formatName		= "HTML file format";
		protected String																			description	= "Single file implementation based on JDOM";
		
	}

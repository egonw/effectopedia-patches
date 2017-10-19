package org.qsari.effectopedia.data.xml;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.qsari.effectopedia.data.RevisionBasedDS;
import org.qsari.effectopedia.data.formats.DataSourceFormat;
import org.qsari.effectopedia.data.formats.FormatFlavour;
import org.qsari.effectopedia.notification.NotificationManager;

public class XMLFileFormat implements DataSourceFormat
	{
		public static XMLFileFormat	XMLFormat_JDOM	= new XMLFileFormat();
		
		public XMLFileFormat()
			{
				flavours = new ArrayList<FormatFlavour>();
				flavours.add(FormatFlavour.AOP);
				flavours.add(FormatFlavour.AOPZ);
			}
		
		@Override
		public RevisionBasedDS createDataSource()
			{
				return new XMLFileDS();
			}
		
		@Override
		public RevisionBasedDS createDataSource(FormatFlavour withFlavour)
			{
				XMLFileDS xmlFile = new XMLFileDS();
				xmlFile.setDataFormatFlavour(withFlavour);
				return xmlFile;
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
				if (withFlavour == FormatFlavour.AOP)
					return isValidAOPFromat(fileName);
				else if (withFlavour == FormatFlavour.AOPZ)
					return isValidAOPZFromat(fileName);
				return false;
			}
		
		public boolean isValidAOPFromat(String fileName)
			{
				return true;// TODO Do actual validation against a schema;
			}
		
		public boolean isValidAOPZFromat(String fileName)
			{
				// TODO Do actual validation against a schema;
				// Current code checks if the AOPZ file contains a single pathways.aop entry
				URL url;
				try
					{
						url = new URL(fileName);
					}
				catch (MalformedURLException e)
					{
						url = null;
					}
				try
					{
						FileInputStream fileInputStream = null;
						BufferedInputStream inputStream;
						if (url == null)
							{
								fileInputStream = new FileInputStream(fileName);
								inputStream = new BufferedInputStream(fileInputStream);
							}
						else
							inputStream = new BufferedInputStream(url.openStream());
						ZipInputStream zipInputEntry = new ZipInputStream(inputStream);
						ZipEntry entry = zipInputEntry.getNextEntry();
						if (entry != null)
							{
								boolean isValid = entry.getName().equals("pathways.aop") && (zipInputEntry.getNextEntry() == null);
								zipInputEntry.close();
								inputStream.close();
								return isValid;
							}
					}
				catch (NullPointerException e)
					{
						e.printStackTrace();
						return false;
					}
				catch (IOException e)
					{
						e.printStackTrace();
						return false;
					}
				return false;
			}

		@Override
		public SupportedFeatures allows()
			{
				return SupportedFeatures.IMPORT_EXPORT;
			}
		
		protected ArrayList<FormatFlavour>	flavours;
		protected String																			formatName		= "XML file format";
		protected String																			description	= "Single file implementation based on JDOM";

		
	}

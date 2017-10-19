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

public class XMLMultiFileFormat implements DataSourceFormat
	{
		public static XMLMultiFileFormat XMLFormat_JDOM = new XMLMultiFileFormat();
		
		public XMLMultiFileFormat()
			{
				flavours = new ArrayList<FormatFlavour>();
				flavours.add(FormatFlavour.XML);
				flavours.add(FormatFlavour.AOPZM);
			}
			
		@Override
		public RevisionBasedDS createDataSource()
			{
				return new XMLMultiFileDS();
			}
			
		@Override
		public RevisionBasedDS createDataSource(FormatFlavour withFlavour)
			{
				XMLMultiFileDS xmlFiles = new XMLMultiFileDS();
				xmlFiles.setDataFormatFlavour(withFlavour);
				return xmlFiles;
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
				if (withFlavour == FormatFlavour.XML)
					return isValidAOPFromat(fileName);
				else if (withFlavour == FormatFlavour.AOPZM)
					return isValidAOPZMFromat(fileName);
				return false;
			}
			
		public boolean isValidAOPFromat(String fileName)
			{
				return true;// TODO Do actual validation against a schema;
			}
			
		public boolean isValidAOPZMFromat(String fileName)
			{
				// TODO Do actual validation against a schema;
				// Current code checks if the AOPZ file contains more than one entry, the
				// first one being aop.xml
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
								boolean isValid = zipInputEntry.getNextEntry() != null;
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
		protected String																			description	= "Multiple files implementation based on JDOM";
		
	}

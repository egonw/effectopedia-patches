package org.qsari.effectopedia.data.formats;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.qsari.effectopedia.defaults.DefaultServerSettings;

public class SupportedDataSourceFormats
	{
		public static SupportedDataSourceFormats	FORMATS	= new SupportedDataSourceFormats();
		
		private SupportedDataSourceFormats()
			{
				available = new LinkedHashMap<FormatFlavour, DataSourceFormat>();
				
				// installFormat(XMLDataSourceFormat.XMLFormat_JDOM); //TODO Remove when
				// using an OSGI service resolving
			}
		
		public void installFormat(DataSourceFormat format)
			{
				if (format == null)
					return;
				for (FormatFlavour flavour : format.getFlavours())
					available.put(flavour, format);
			}
		
		public void uninstallFormat(DataSourceFormat format)
			{
				if (format == null)
					return;
				for (FormatFlavour flavour : format.getFlavours())
					available.remove(flavour.defaultExtension);
			}
		
		public DataSourceFormat getFormatByFormatFlavour(FormatFlavour flavour)
			{
				return available.get(flavour);
			}
		
		public DataSourceFormat[] getFormatsByExtension(String extension, int flavour)
			{
				ArrayList<DataSourceFormat> formats = new ArrayList<DataSourceFormat>();
				for (Map.Entry<FormatFlavour, DataSourceFormat> ff : available.entrySet())
					if (ff.getKey().defaultExtension.equals(extension))
						if ((flavour & ff.getKey().flavour) != 0)
							formats.add(ff.getValue());
				DataSourceFormat[] result = new DataSourceFormat[formats.size()];
				return formats.toArray(result);
			}
		
		public DataSourceFormat proposeFileFormat(String fileName)
			{
				String extension = getFileExtension(fileName);
				if (extension == null)
					available.get(DefaultServerSettings.defaultFormatFlavour);
				else if ("java".equals(extension))
					return null;
				else
					for (Map.Entry<FormatFlavour, DataSourceFormat> ff : available.entrySet())
						if (ff.getKey().defaultExtension.equals(extension))
							return ff.getValue();
				return available.get(DefaultServerSettings.defaultFormatFlavour);
			}
		
		public DataSourceFormat detectFileFormat(String fileName)
			{
				String extension = getFileExtension(fileName);
				if (extension == null)
					{
						for (Map.Entry<FormatFlavour, DataSourceFormat> ff : available.entrySet())
							if (ff.getValue().isCompatible(fileName, ff.getKey()))
								return ff.getValue();
					}
				else
					for (Map.Entry<FormatFlavour, DataSourceFormat> ff : available.entrySet())
						if (ff.getKey().defaultExtension.equals(extension) && ff.getValue().isCompatible(fileName, ff.getKey()))
							return ff.getValue();
				return null;
			}
		
		public static String getFileExtension(String fileName)
			{
				int extIndex = fileName.lastIndexOf('.');
				if ((extIndex == -1) || (fileName.lastIndexOf("\\") > extIndex) || (fileName.lastIndexOf("/") > extIndex))
					return null;
				return fileName.substring(extIndex + 1);
			}
		
		public LinkedHashMap<FormatFlavour, DataSourceFormat>	available;
	}

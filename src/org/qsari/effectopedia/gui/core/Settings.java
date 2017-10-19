package org.qsari.effectopedia.gui.core;

import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.data.aopxml.AopXmlFileFormat;
import org.qsari.effectopedia.data.formats.SupportedDataSourceFormats;
import org.qsari.effectopedia.data.html.HTMLFileFormat;
import org.qsari.effectopedia.data.xml.XMLFileFormat;
import org.qsari.effectopedia.data.xml.XMLMultiFileFormat;
import org.qsari.effectopedia.gui.fx.GUIFXFactory;
import org.qsari.effectopedia.system.Configuration;
import org.qsari.effectopedia.utils.proxy.ProxyDetector;

public class Settings
	{
		public static void useDefaultGUISettings()
			{
				//TODO Provide OSGI friendly implementation here
				Configuration.proxy = new ProxyDetector();
				Configuration.displayProxySettings();
				//UserInterface.setDefaultUIFactory(GUIFactory.FACTORY);
				UserInterface.setDefaultUIFactory(GUIFXFactory.FACTORY);
				//UserInterface.setDefaultUIFactory(GUISwingBOXFactory.FACTORY);
				
				SupportedDataSourceFormats.FORMATS.installFormat(XMLFileFormat.XMLFormat_JDOM); // TODO
				SupportedDataSourceFormats.FORMATS.installFormat(XMLMultiFileFormat.XMLFormat_JDOM); // TODO
				SupportedDataSourceFormats.FORMATS.installFormat(AopXmlFileFormat.INSTANCE);
				SupportedDataSourceFormats.FORMATS.installFormat(HTMLFileFormat.HTMLFormat_JDOM);
			}
	}

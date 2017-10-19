package org.qsari.effectopedia.data.html;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.jdom.Document;
import org.jdom.output.XMLOutputter;
import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.ExtensibleIO;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.data.formats.DataSourceFormat;
import org.qsari.effectopedia.data.xml.XMLElement;
import org.qsari.effectopedia.data.xml.XMLFileDS;
import org.qsari.effectopedia.defaults.DefaultGOSettings;
import org.qsari.effectopedia.defaults.DefaultServerSettings;
import org.qsari.effectopedia.gui.PathwaySpaceUI;
import org.qsari.effectopedia.gui.UIResources;
import org.qsari.effectopedia.gui.core.DataView;

/**
 * <code>HTMLFileExport</code> allows generation of HTML export of the
 * Effectopedia's aop file format. Both the original aop file and the exported
 * html file are saved in the user specified location. The implementation is
 * based on <code>XMLFileDS</code>.
 * 
 * @see XMLFileDS
 * 
 * @version 1.0 @(#)HTMLFileExport.java 1.0
 * @author fifo, Hristo Aladjov
 */
public class HTMLFileExport extends XMLFileDS implements ExtensibleIO
	{
		
		public HTMLFileExport()
			{
				super();
				dataFormat = HTMLFileFormat.HTMLFormat_JDOM;
			}
			
		public HTMLFileExport(DataSourceFormat dataFormat)
			{
				super(dataFormat);
			}
			
		@Override
		public void save(String path, boolean saveLocally)
			{
				setBrowsing(false);
				if (dataSourceID == 0)
					dataSourceID = DefaultServerSettings.getNewDataSourceID(path);
				Document doc = new Document();
				XMLElement e = new XMLElement("effectopedia");
				if (dataSourceID != 0)
					e.setAttribute("id", Long.toString(dataSourceID));
				saveAllToRoot(e, this);
				doc.setRootElement(e.getElement());
				this.fileName = path;
				this.sourceName = path;
				this.sourcePrefix = saveLocally ? "local file: " : "";
				publishing = new HTMLExport(doc, path);
				new Thread(publishing).start();
			}
			
		public class HTMLExport implements Runnable
			{
				public HTMLExport(Document doc, String fileName)
					{
						this.doc = doc;
						this.fileName = Paths.get(fileName);
					}
					
				public void run()
					{
						if (writeToLocalFile(doc, fileName))
							{
								Desktop desktop = Desktop.getDesktop();
								if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE))
									{
										if (UserInterface.getUserYesNoConfirmation(fileName.getFileName() + " was successfully created! \nWould you like to open it in the default browser?"))
											try
												{
													desktop.browse(fileName.toUri());
												}
											catch (IOException e)
												{
													e.printStackTrace();
												}
									}
								else
									UserInterface.showFeedback(fileName.getFileName() + " was successfully created!", "Acknowledgment");
							}
						else
							UserInterface.showError("There was an error while exporting in HTML! \n Review error log for more details");
						synchronized (this)
							{
								setBrowsing(true);
								notifyAll();
							}
					}
					
				private Document	doc;
				private Path					fileName;
			}
			
		public boolean writeToLocalFile(Document doc, Path fileName)
			{
				try
					{
						Path dest = fileName.getParent().resolve("res");
						String destDir = dest.toString() + File.separator;
						Files.createDirectories(dest);
						
						// Generate local AOP file
						String strFileName = fileName.getFileName().toString();
						String aopFileName = destDir + strFileName.substring(0, strFileName.lastIndexOf(".")) + ".aop";
						FileOutputStream fileStream = new FileOutputStream(aopFileName);
						OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileStream, "UTF-8");
						XMLOutputter XMLOut = new XMLOutputter();
						XMLOut.setFormat(XMLOut.getFormat().setExpandEmptyElements(true));
						XMLOut.output(doc, outputStreamWriter);
						outputStreamWriter.close();
						fileStream.close();
						
						// Use a Transformer to covert the original AOP file to HTML
						File stylesheet = new File(UIResources.class.getResource("res/aop.xsl").getFile());
						File datafile = new File(aopFileName);
						File out = new File(fileName.toString());
						Source source;
						TransformerFactory tFactory = TransformerFactory.newInstance();
						StreamSource stylesource = new StreamSource(stylesheet);
						Transformer transformer = tFactory.newTransformer(stylesource);
						OutputStream outputStream = new FileOutputStream(out);
						
						transformer.setOutputProperty(OutputKeys.INDENT, "yes");
						transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
						
						source = new StreamSource(datafile);
						StreamResult result = new StreamResult(outputStream);
						transformer.transform(source, result);
						
						// Create referred resources at the destination folder
						ExportResource("aop.xsl", destDir);
						ExportResource("aop.css", destDir);
						ExportResource("aop_icons.png", destDir);
						ExportPathwayDiagrams(destDir);
						return true;
					}
				catch (TransformerConfigurationException tce)
					{
						// Error generated by the parser
						System.err.println("\n** Transformer Factory error");
						System.err.println("   " + tce.getMessage());
						
						// Use the contained exception, if any
						Throwable x = tce;
						
						if (tce.getException() != null)
							{
								x = tce.getException();
							}
							
						x.printStackTrace();
					}
				catch (TransformerException te)
					{
						// Error generated by the parser
						System.err.println("\n** Transformation error");
						System.err.println("   " + te.getMessage());
						
						// Use the contained exception, if any
						Throwable x = te;
						
						if (te.getException() != null)
							{
								x = te.getException();
							}
							
						x.printStackTrace();
					}
				catch (FileNotFoundException e)
					{
						e.printStackTrace();
					}
				catch (UnsupportedEncodingException e)
					{
						e.printStackTrace();
					}
				catch (IOException e)
					{
						e.printStackTrace();
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
				return false;
			}
			
		private void ExportPathwayDiagrams(String destDir)
			{
				boolean hideEmptySegments = DefaultGOSettings.isHideEmptySegments();
				DataView dataView = (DataView) getCurrentView();
				PathwaySpaceUI pathwaySpace = new PathwaySpaceUI(null, null, dataView, null);
				dataView.setHideEmptySegments(true);
				pathwaySpace.updateDataSource(this);
				if (!dataView.areViewAxisInitialized())
					dataView.setDefaultViewAxis();
				for (Pathway pathway : liveIndices.getPathways().get())
					{
						dataView.getPathwaysView().reset();
						dataView.clear();
						dataView.rebuildView();
						dataView.addToView(pathway);
						pathwaySpace.dataViewChanged(null);
						pathwaySpace.exportAsSVGImageFile(destDir + pathway.getExternalID() + ".svg");
					}
				DefaultGOSettings.setHideEmptySegments(hideEmptySegments);
				pathwaySpace = null;
			}
			
		@Override
		public String getNamedValue(EffectopediaObject eo, String elementName)
			{
				String diagram = null;
				if ((eo instanceof Pathway) && (elementName == "diagram"))
					{
						Pathway pathway = (Pathway) eo;
						boolean hideEmptySegments = DefaultGOSettings.isHideEmptySegments();
						DataView dataView = (DataView) getCurrentView();
						PathwaySpaceUI pathwaySpace = new PathwaySpaceUI(null, null, dataView, null);
						dataView.setHideEmptySegments(true);
						pathwaySpace.updateDataSource(this);
						if (!dataView.areViewAxisInitialized())
							dataView.setDefaultViewAxis();
						dataView.getPathwaysView().reset();
						dataView.clear();
						dataView.rebuildView();
						dataView.addToView(pathway);
						pathwaySpace.dataViewChanged(null);
						diagram = pathwaySpace.exportAsSVGImage();
						DefaultGOSettings.setHideEmptySegments(hideEmptySegments);
						pathwaySpace = null;
					}
				return diagram;
			}
			
		static public void ExportResource(String resourceName, String destinationPath) throws Exception
			{
				InputStream resImputstream;
				OutputStream resOutputStream;
				try
					{
						URL res = UIResources.class.getResource("res/" + resourceName);
						resImputstream = res.openStream();
						int readBytes;
						byte[] buffer = new byte[BUFFER_SIZE];
						resOutputStream = new FileOutputStream(destinationPath + resourceName);
						while ((readBytes = resImputstream.read(buffer)) > 0)
							{
								resOutputStream.write(buffer, 0, readBytes);
							}
						resImputstream.close();
						resOutputStream.close();
					}
				catch (Exception ex)
					{
						throw ex;
					}
			}
			
	}

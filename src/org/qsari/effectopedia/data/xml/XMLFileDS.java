package org.qsari.effectopedia.data.xml;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOArray;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.BaseIOValue;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.DataSourceItem;
import org.qsari.effectopedia.data.FileDS;
import org.qsari.effectopedia.data.formats.DataSourceFormat;
import org.qsari.effectopedia.defaults.DefaultServerSettings;

public class XMLFileDS extends FileDS implements DataSourceItem, BaseIO
	{
		
		public XMLFileDS()
			{
				super();
				dataFormat = XMLFileFormat.XMLFormat_JDOM;
			}
		
		public XMLFileDS(DataSourceFormat dataFormat)
			{
				super();
				this.dataFormat = dataFormat;
			}
		
		public synchronized boolean load(String path)
			{
				this.fileName = path;
				this.sourceName = path;
				Document doc = readDocumentFromFile(path);
				if (doc == null)
					return false;
				Effectopedia.EFFECTOPEDIA.setData((DataSource) this);
				// System.err.println("Stamps before loading: "+Effectopedia.EFFECTOPEDIA.getStamps().size());
				XMLElement e = new XMLElement(doc.getRootElement());
				boolean temp = loadAllFromRoot(e, this);
				// System.err.println("Stamps after loading: "+Effectopedia.EFFECTOPEDIA.getStamps().size());
				return temp;
			}
		
		public Document readDocumentFromFile(String fileName)
			{
				try
					{
						SAXBuilder builder = new SAXBuilder();
						URL url = getURL(fileName);
						if (fileName.substring(fileName.lastIndexOf("."), fileName.length()).equalsIgnoreCase(".aopz"))
							{
								FileInputStream fileInputStream = null;
								BufferedInputStream inputStream;
								if (url == null)
									{
										fileInputStream = new FileInputStream(fileName);
										inputStream = new BufferedInputStream(fileInputStream);
									}
								else
									{
										inputStream = new BufferedInputStream(url.openStream());
										remoteFile = true;
									}
								ZipInputStream zipInputEntry = new ZipInputStream(inputStream);
								ZipEntry entry = zipInputEntry.getNextEntry();
								if (entry != null)
									{
										String temp = readZIPEntry(zipInputEntry, (int) entry.getSize());
										temp = XMLVersionProcessor.preprocess(temp);
										Document doc = builder.build(new StringReader(temp));
										zipInputEntry.close();
										if (url == null)
											fileInputStream.close();
										return doc;
									}
								return null;
							}
						else
							{
								if (url != null)
									return builder.build(url.openStream());
								else
									return builder.build(new File(fileName));
							}
					}
				catch (JDOMException e)
					{
						e.printStackTrace();
						return null;
					}
				catch (NullPointerException e)
					{
						e.printStackTrace();
						return null;
					}
				catch (IOException e)
					{
						e.printStackTrace();
						return null;
					}
			}
		
		private String readZIPEntry(ZipInputStream zipInputStream, int size) throws IOException
			{
				int bytesRead;
				BufferedInputStream buffer = new BufferedInputStream(zipInputStream);
				ByteArrayOutputStream content = (size > 0) ? (new ByteArrayOutputStream(size)) : (new ByteArrayOutputStream());
				byte data[] = new byte[BUFFER_SIZE];
				while ((bytesRead = buffer.read(data, 0, BUFFER_SIZE)) != -1)
					content.write(data, 0, bytesRead);
				return content.toString("UTF-8");
			}
		
		public void save(String path, boolean saveLocally)
			{
				setBrowsing(false);
				if (dataSourceID == 0)
					dataSourceID = DefaultServerSettings.getNewDataSourceID(path);
				Document doc = new Document();
				XMLElement e = new XMLElement("effectopedia");
				if (dataSourceID != 0)
					e.setAttribute("id", Long.toString(dataSourceID));
				System.out.println("Stamps before writing: " + Effectopedia.EFFECTOPEDIA.getStamps().size());
				saveAllToRoot(e, this);
				doc.setRootElement(e.element);
				this.fileName = path;
				this.sourceName = path;
				this.sourcePrefix = saveLocally ? "local file: " : "";
				publishing  = new Publish(doc, path, saveLocally);
				new Thread(publishing).start();
			}
		
		public class Publish implements Runnable
			{
				public Publish(Document doc, String fileName, boolean saveAsLocalFile)
					{
						this.doc = doc;
						this.fileName = fileName;
						this.saveAsLocalFile = saveAsLocalFile;
					}
				
				public void run()
					{
						if (writeToFile(doc, fileName, saveAsLocalFile))
							{
								if (!saveAsLocalFile)
									{
										UserInterface.showFeedback("Your changes were successfully published!", "Acknowledgment");
										DefaultServerSettings.commitRevision(String.valueOf(Effectopedia.EFFECTOPEDIA.getRevision()), Effectopedia.EFFECTOPEDIA.getCurrentUserID());
									}
							}
						else
							UserInterface
									.showError("There was an error while trying to publish your changes! \n Check your firewall settings and make sure that Effectopedia application is not blocked");
						synchronized (this)
							{
								setBrowsing(true);
								notifyAll();
							}
					}
				
				private Document	doc;
				private String			fileName;
				private boolean		saveAsLocalFile;
			}
		
		public boolean writeToFile(Document doc, String fileName, boolean saveAsLocalFile)
			{
				OutputStreamWriter outputStreamWriter = null;
				FileOutputStream fileStream = null;
				URLConnection urlc = null;
				BufferedOutputStream outputStream = null;
				byte[] header = null;
				boolean saveRemoteFile = !saveAsLocalFile;
				try
					{
						if (saveAsLocalFile)
							{
								fileStream = new FileOutputStream(fileName);
								outputStream = new BufferedOutputStream(fileStream);
							}
						else
							{
								fileName = DefaultServerSettings.getNewRevisionName();
								header = DefaultServerSettings.buildHTTPContentDisposition("", fileName);
							}
						XMLOutputter XMLOut = new XMLOutputter();
						XMLOut.setFormat(XMLOut.getFormat().setExpandEmptyElements(true));
						if (fileName.substring(fileName.lastIndexOf("."), fileName.length()).equalsIgnoreCase(".aopz"))
							{
								ByteArrayOutputStream buffer = new ByteArrayOutputStream();
								ZipOutputStream zipOutputStream = new ZipOutputStream((saveRemoteFile) ? buffer : outputStream);
								ZipEntry entry = new ZipEntry("pathways.aop");
								zipOutputStream.putNextEntry(entry);
								XMLOut.output(doc, zipOutputStream);
								zipOutputStream.flush();
								zipOutputStream.close();
								System.out.println(fileName + " entry.size:" + entry.getSize());
								
								if (saveRemoteFile)
									{
										urlc = DefaultServerSettings.getFileUploadURL(DefaultServerSettings.DefaultProtocol, fileName);
										revision = Long.parseLong(DefaultServerSettings.getResponce());
										if (DefaultServerSettings.DefaultProtocol == DefaultServerSettings.HTTP)
											urlc.setRequestProperty("Content-Length", String.valueOf(entry.getSize() + header.length + DefaultServerSettings.POST_EOL_BYTES.length + DefaultServerSettings.POST_EOL_BND_TAG.length()));
										outputStream = new BufferedOutputStream(urlc.getOutputStream());
										if (DefaultServerSettings.DefaultProtocol == DefaultServerSettings.HTTP)
											{
												outputStream.write(header);
												outputStream.write(buffer.toByteArray());
												outputStream.write(DefaultServerSettings.POST_EOL_BYTES);
												outputStream.write(DefaultServerSettings.POST_EOL_BND_TAG.getBytes());
												outputStream.flush();
												outputStream.close();
												System.out.println("Response code = " + ((HttpURLConnection) urlc).getResponseCode() + "\n");
												if (((HttpURLConnection) urlc).getResponseCode()!=200)
													return false;
											}
										else
											{
												outputStream.write(buffer.toByteArray());
												outputStream.flush();
												outputStream.close();
											}
									}
								else
									{
										revision = editHistory.getRevision();
										outputStream.flush();
										outputStream.close();
										fileStream.close();
									}
							}
						else
							{
								if (saveRemoteFile)
									outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
								else
									outputStreamWriter = new OutputStreamWriter(fileStream, "UTF-8");
								XMLOut.output(doc, outputStreamWriter);
								outputStreamWriter.close();
							}
						return true;
					}
				catch (UnsupportedEncodingException e1)
					{
						e1.printStackTrace();
					}
				catch (FileNotFoundException e1)
					{
						e1.printStackTrace();
					}
				catch (MalformedURLException e)
					{
						e.printStackTrace();
					}
				catch (IOException e)
					{
						e.printStackTrace();
					}
				return false;
			}
		
		@Override
		public <E extends EffectopediaObject> E load(Class<?> cl, E effectopediaObejct, BaseIOElement element)
			{
				return load(cl, effectopediaObejct, element, this);
			}
		
		@Override
		public BaseIOAttribute newAttribute(String name)
			{
				return new XMLAttribute(name);
			}
		
		@Override
		public BaseIOValue newValue(String name)
			{
				return (new XMLValue(name));
			}
		
		@Override
		public BaseIOElement newElement(String name)
			{
				return new XMLElement(name);
			}
		
		@Override
		public BaseIOArray newArray(String name, int count)
			{
				return new XMLArrayElement(name, count);
			}
		
		@Override
		public DataPattern getDataPattern()
			{
				return BaseIO.DataPattern.RUSSIAN_DOLL;
			}
		
		public final static int	BUFFER_SIZE	= 4096;
		
	}

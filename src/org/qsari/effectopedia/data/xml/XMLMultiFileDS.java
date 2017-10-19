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
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.qsari.effectopedia.data.MultiFileDS;
import org.qsari.effectopedia.data.formats.DataSourceFormat;
import org.qsari.effectopedia.defaults.DefaultServerSettings;

public class XMLMultiFileDS extends MultiFileDS implements DataSourceItem, BaseIO
	{
		public XMLMultiFileDS()
			{
				super();
				dataFormat = XMLMultiFileFormat.XMLFormat_JDOM;
			}
		
		public XMLMultiFileDS(DataSourceFormat dataFormat)
			{
				super();
				this.dataFormat = dataFormat;
			}
		
		@Override
		public DataPattern getDataPattern()
			{
				return BaseIO.DataPattern.VENETIAN_BLIND;
			}
		
		@Override
		public synchronized boolean load(String path)
			{
				this.fileName = path;
				this.sourceName = path;
				initLoading();
				if (fileName.substring(fileName.lastIndexOf("."), fileName.length()).equalsIgnoreCase(".aopz"))
					return loadComressedFile(fileName);
				else
					return loadLocalPath(fileName);
			}
		
		public boolean loadComressedFile(String fileName)
			{
				try
					{
						URL url = getURL(fileName);
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
						Effectopedia.EFFECTOPEDIA.setData((DataSource) this);
						while (entry != null)
							{
								SAXBuilder builder = new SAXBuilder();
								//System.out.println("Entry: " + entry.getName());
								String temp = readZIPEntry(zipInputEntry, (int) entry.getSize());
								temp = XMLVersionProcessor.preprocess(temp);
								Document doc = builder.build(new StringReader(temp));
								XMLElement e = new XMLElement(doc.getRootElement());
								loadBaseIOElement(entry.getName(), e, this);
								entry = zipInputEntry.getNextEntry();
							}
						zipInputEntry.close();
						if (url == null)
							fileInputStream.close();
						return true;
					}
				catch (JDOMException e)
					{
						e.printStackTrace();
						return false;
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
		
		public boolean loadLocalPath(String fileName)
			{
				File root = (new File(fileName)).getAbsoluteFile().getParentFile();
				rootPathLenght = root.toString().length() + 1;
				File[] files = root.listFiles();
				try
					{
						if (files != null)
							{
								files = makeLiveIndicesFirst(files);
								processFiles(files);
							}
					}
				catch (JDOMException | IOException e)
					{
						e.printStackTrace();
						return false;
					}
				return true;
			}
		
		private File[] makeLiveIndicesFirst(File[] files)
			{
				File[] result = new File[files.length];
				int index = 1;
				for (int i = 0; i < files.length; i++)
					if (files[i].getPath().contains("live_ids"))
						result[0] = files[i];
					else
						result[index++] = files[i];
				return result;
			}
		
		private void processFiles(File[] files) throws JDOMException, IOException
			{
				// Process all sub directories first
				for (File file : files)
					if (file.isDirectory())
						{
							//System.out.println("Directory: " + file.getName());
							processFiles(file.listFiles());
						}
				for (File file : files)
					if (!file.isDirectory() && !file.isHidden() && (file.getName().toLowerCase().endsWith(".xml")))
						{
							String localName = file.getAbsolutePath().substring(rootPathLenght);
							//System.out.println("File: " + localName);
							SAXBuilder builder = new SAXBuilder();
							Document doc = builder.build(file);
							XMLElement e = new XMLElement(doc.getRootElement());
							loadBaseIOElement(localName, e, this);
						}
			}
		
		public void saveAllToRoot(BaseIOElement root, BaseIO io)
			{
				archiveIndices.replaceArchivedObjectsWtihClones();
				
				if (saveUpdated)
					editHistory.updateModifiedAndNewSinceLastRevision();
				editHistory.startNewRevision();
				
				storeEffectopediaHeader(root, io);
				
				storeLiveIndices(root, io);
				storeArchiveIndices(root, io);
				storeEditHistory(root, io);
				storeLivePathwayElements(root, io);
				
				root.setAttribute("max_id", Long.toString(externalIDs - 1));
				root.setAttribute("default_max_id", Long.toString(EffectopediaObject.getDefaultIDs() + 1));
			}
		
		@Override
		public void save(String path, boolean saveLocally)
			{
				setBrowsing(false);
				if (dataSourceID == 0)
					dataSourceID = DefaultServerSettings.getNewDataSourceID(path);
				
				XMLElement e = new XMLElement("effectopedia");
				if (dataSourceID != 0)
					e.setAttribute("id", Long.toString(dataSourceID));
				
				this.fileName = path;
				this.sourceName = path;
				this.sourcePrefix = saveLocally ? "local file: " : "";
				publishing = new Publish(e, path, saveLocally);
				new Thread(publishing).start();
			}
		
		public static interface EntryProcessor
			{
				public boolean saveEntry(String fileName, BaseIOElement element);
			}
		
		@Override
		protected void saveInFile(String fileName, BaseIOElement element, BaseIO io)
			{
				super.saveInFile(fileName, element, io);
				entryProcessor.saveEntry(fileName, element);
			}
		
		public class Publish implements Runnable
			{
				public Publish(BaseIOElement element, String fileName, boolean saveAsLocalFile)
					{
						this.element = element;
						this.fileName = fileName;
						this.saveAsLocalFile = saveAsLocalFile;
					}
				
				public void run()
					{
						if (fileName.substring(fileName.lastIndexOf("."), fileName.length()).equalsIgnoreCase(".aopz"))
							if (saveCompressedFile(element, fileName, saveAsLocalFile))
								{
									UserInterface.showFeedback("Your changes were successfully published!", "Acknowledgment");
									DefaultServerSettings.commitRevision(String.valueOf(Effectopedia.EFFECTOPEDIA.getRevision()), Effectopedia.EFFECTOPEDIA.getCurrentUserID());
								}
							else
								UserInterface
										.showError("There was an error while trying to publish your changes! \n Check your firewall settings and make sure that Effectopedia application can initiate active FTP transactions");
						else if (saveToLocalPath(element, fileName))
							UserInterface.showFeedback("Your changes were successfully saved!", "Acknowledgment");
						else
							UserInterface.showError("Saving to local files did not complete successfully!");
						synchronized (this)
							{
								setBrowsing(true);
								notifyAll();
							}
					}
				
				private BaseIOElement	element;
				private String								fileName;
				private boolean							saveAsLocalFile;
			}
		
		public boolean saveCompressedFile(BaseIOElement element, String fileName, boolean saveAsLocalFile)
			{
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
						ByteArrayOutputStream buffer = new ByteArrayOutputStream();
						ZipOutputStream zipOutputStream = new ZipOutputStream((saveRemoteFile) ? buffer : outputStream);
						entryProcessor = new ZipEntryProcessor(zipOutputStream);
						XMLOutputter XMLOut = new XMLOutputter();
						XMLOut.setFormat(XMLOut.getFormat().setExpandEmptyElements(true));
						Document doc = new Document();
						saveAllToRoot(element, this);
						doc.setRootElement(((XMLElement) element).element);
						
						ZipEntry entry = new ZipEntry(generateName("", "aops"));
						zipOutputStream.putNextEntry(entry);
						XMLOut.output(doc, zipOutputStream);
						
						zipOutputStream.flush();
						zipOutputStream.close();
						
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
										//System.out.println("Response code = " + ((HttpURLConnection) urlc).getResponseCode() + "\n");
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
						return true;
					}
				catch (UnsupportedEncodingException e1)
					{
						e1.printStackTrace();
						return false;
					}
				catch (FileNotFoundException e1)
					{
						e1.printStackTrace();
						return false;
					}
				catch (MalformedURLException e)
					{
						e.printStackTrace();
						return false;
					}
				catch (IOException e)
					{
						e.printStackTrace();
						return false;
					}
			}
		
		public static class ZipEntryProcessor implements EntryProcessor
			{
				public ZipEntryProcessor(ZipOutputStream zipOutputStream)
					{
						this.zipOutputStream = zipOutputStream;
					}
				
				public boolean saveEntry(String fileName, BaseIOElement element)
					{
						try
							{
								ZipEntry entry = new ZipEntry(fileName);
								zipOutputStream.putNextEntry(entry);
								
								XMLOutputter XMLOut = new XMLOutputter();
								XMLOut.setFormat(XMLOut.getFormat().setExpandEmptyElements(true));
								Document doc = new Document();
								doc.setRootElement(((XMLElement) element).element);
								XMLOut.output(doc, zipOutputStream);
								return true;
							}
						catch (IOException e)
							{
								e.printStackTrace();
								return false;
							}
					}
				
				private final ZipOutputStream	zipOutputStream;
			}
		
		public boolean saveToLocalPath(BaseIOElement element, String fileName)
			{
				try
					{
						Path p = Paths.get(fileName);
						String name = p.getFileName().toString();
						int extIndex = (name != null) ? name.lastIndexOf(".") : -1;
						String dir = (extIndex != -1) ? SEPARTATOR + name.substring(0, extIndex) + SEPARTATOR : SEPARTATOR;
						p = p.getParent();
						String path = (p != null) ? p.toString() + dir : "";
						entryProcessor = new FileEntryProcessor(path);
						
						File file = new File(generateName(path, "aops"));
						file.getParentFile().mkdirs();
						FileOutputStream fileStream = new FileOutputStream(file);
						BufferedOutputStream outputStream = new BufferedOutputStream(fileStream);
						
						XMLOutputter XMLOut = new XMLOutputter();
						XMLOut.setFormat(XMLOut.getFormat().setExpandEmptyElements(true));
						OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
						Document doc = new Document();
						saveAllToRoot(element, this);
						doc.setRootElement(((XMLElement) element).element);
						XMLOut.output(doc, outputStreamWriter);
						outputStreamWriter.close();
						return true;
					}
				catch (IOException e)
					{
						e.printStackTrace();
					}
				return false;
			}
		
		public static class FileEntryProcessor implements EntryProcessor
			{
				public FileEntryProcessor(String path)
					{
						this.path = path;
					}
				
				public boolean saveEntry(String fileName, BaseIOElement element)
					{
						try
							{
								File file = new File(path + fileName);
								file.getParentFile().mkdirs();
								FileOutputStream fileStream = new FileOutputStream(file);
								BufferedOutputStream outputStream = new BufferedOutputStream(fileStream);
								
								XMLOutputter XMLOut = new XMLOutputter();
								XMLOut.setFormat(XMLOut.getFormat().setExpandEmptyElements(true));
								OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
								Document doc = new Document();
								doc.setRootElement(((XMLElement) element).element);
								XMLOut.output(doc, outputStreamWriter);
								outputStreamWriter.close();
								return true;
							}
						catch (IOException e)
							{
								e.printStackTrace();
							}
						return false;
					}
				
				private final String	path;
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
		
		private final int						BUFFER_SIZE				= 4096;
		private int												rootPathLenght	= 0;
		private EntryProcessor	entryProcessor	= null;
	}

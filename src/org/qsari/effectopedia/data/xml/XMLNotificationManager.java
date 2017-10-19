package org.qsari.effectopedia.data.xml;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.jdom.Document;
import org.jdom.output.XMLOutputter;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.defaults.DefaultServerSettings;
import org.qsari.effectopedia.notification.NotificationManager;
import org.qsari.effectopedia.notification.Notifications;
import org.qsari.effectopedia.utils.HexCharByteConverter;

public class XMLNotificationManager implements NotificationManager
	{
		public XMLNotificationManager()
			{
				notifications = new Notifications();
			}
		
		public void buildAndSubmitNotifications(DataSource data, BaseIO io)
			{
				buildAndSubmitNotifications(data, io, getLastNotifiedRevision());
			}
		
		public void buildAndSubmitNotifications(DataSource data, BaseIO io, int sinceRevision)
			{
				this.io = io;
				revisionRangeHi = data.getEditHistory().getRevision();
				revisionRangeLo = sinceRevision;
				if (revisionRangeHi <= revisionRangeLo)
					return;
				String fileName = "Notifications" + getRevisionRange() + ".zip";
				
				notifications.build(data.getEditHistory(), revisionRangeLo);
				Document doc = new Document();
				BaseIOElement n = io.newElement("notifications");
				notifications.store(n, io);
				doc.setRootElement(((XMLElement)n).element);
				
				(new Thread(new Publisher(doc, fileName, false))).start();
			}
		
		public int getLastNotifiedRevision()
			{
				String response = DefaultServerSettings.getLastNotifiedRevision();
				return ((response != null) && (response != "")) ? Integer.valueOf(response) : 0;
			}
		
		public class Publisher implements Runnable
			{
				public Publisher(Document doc, String fileName, boolean saveAsLocalFile)
					{
						this.doc = doc;
						this.fileName = fileName;
						this.saveAsLocalFile = saveAsLocalFile;
					}
				
				private String getDocSHA()
					{
						MessageDigest md;
						try
							{
								md = MessageDigest.getInstance("SHA-256");
								md.update(doc.toString().getBytes("UTF-8"));
								byte[] digest = md.digest();
								return String.valueOf(HexCharByteConverter.convert(digest));
							}
						catch (NoSuchAlgorithmException e)
							{
								e.printStackTrace();
								return "";
							}
						catch (UnsupportedEncodingException e)
							{
								e.printStackTrace();
								return "";
							}
					}
				
				public void run()
					{
						if (writeToFile(doc, fileName, saveAsLocalFile))
							{
								if (!saveAsLocalFile)
									{
										//System.out.println("Contributor notifications were successfully generated");
										DefaultServerSettings.submitNotifications(fileName, Effectopedia.EFFECTOPEDIA.getCurrentUserID(), getDocSHA(), revisionRangeHi);
									}
							}
						else
							UserInterface.showError("There was an error while trying to upload notifications");
					}
				
				private Document	doc;
				private String			fileName;
				private boolean		saveAsLocalFile;
			}
		
		private boolean writeToFile(Document doc, String fileName, boolean saveAsLocalFile)
			{
				if (!saveAsLocalFile)
					return writeToRemoteFile(doc, fileName);
				OutputStreamWriter outputStreamWriter = null;
				FileOutputStream fileStream = null;
				BufferedOutputStream outputStream = null;
				try
					{
						fileStream = new FileOutputStream(fileName);
						outputStream = new BufferedOutputStream(fileStream);
						
						XMLOutputter XMLOut = new XMLOutputter();
						XMLOut.setFormat(XMLOut.getFormat().setExpandEmptyElements(true));
						if (fileName.substring(fileName.lastIndexOf("."), fileName.length()).equalsIgnoreCase(".zip"))
							{
								ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
								ZipEntry entry = new ZipEntry("notifications" + getRevisionRange() + ".xml");
								zipOutputStream.putNextEntry(entry);
								XMLOut.output(doc, zipOutputStream);
								zipOutputStream.close();
								
								outputStream.flush();
								outputStream.close();
								System.out.println("notification enry.size:" + entry.getSize());
								fileStream.close();
							}
						else
							{
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
				catch (IOException e)
					{
						e.printStackTrace();
					}
				return false;
			}
		
		private boolean writeToRemoteFile(Document doc, String fileName)
			{
				OutputStreamWriter outputStreamWriter = null;
				BufferedOutputStream outputStream = null;
				URLConnection urlc = null;
				try
					{
						byte[] header = DefaultServerSettings.buildHTTPContentDisposition("notify/", fileName);
						XMLOutputter XMLOut = new XMLOutputter();
						XMLOut.setFormat(XMLOut.getFormat().setExpandEmptyElements(true));
						if (fileName.substring(fileName.lastIndexOf("."), fileName.length()).equalsIgnoreCase(".zip"))
							{
								ByteArrayOutputStream buffer = new ByteArrayOutputStream();
								ZipOutputStream zipOutputStream = new ZipOutputStream(buffer);
								ZipEntry entry = new ZipEntry("notifications" + getRevisionRange() + ".xml");
								zipOutputStream.putNextEntry(entry);
								XMLOut.output(doc, zipOutputStream);
								zipOutputStream.close();
								buffer.flush();
								System.out.println("notification enry.size:" + entry.getSize());
								
								urlc = DefaultServerSettings.getFileUploadURL(protocol, "notify/" + fileName);
								if (protocol == DefaultServerSettings.HTTP)
									urlc.setRequestProperty("Content-Length", String.valueOf(entry.getSize() + header.length + DefaultServerSettings.POST_EOL_BYTES.length + DefaultServerSettings.POST_EOL_BND_TAG.length()));
								
								outputStream = new BufferedOutputStream(urlc.getOutputStream());
								if (protocol == DefaultServerSettings.HTTP)
									{
										outputStream.write(header);
										outputStream.write(buffer.toByteArray());
										outputStream.write(DefaultServerSettings.POST_EOL_BYTES);
										outputStream.write(DefaultServerSettings.POST_EOL_BND_TAG.getBytes());
										outputStream.flush();
										outputStream.close();
										System.out.println("Response code = " + ((HttpURLConnection) urlc).getResponseCode() + "\n" + readData(((HttpURLConnection) urlc)));
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
								urlc = DefaultServerSettings.getFileUploadURL(protocol, fileName);
								outputStream = new BufferedOutputStream(urlc.getOutputStream());
								outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
								XMLOut.output(doc, outputStreamWriter);
								outputStreamWriter.close();
							}
						return true;
					}
				catch (UnsupportedEncodingException e1)
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
		
		public String readData(HttpURLConnection connection)
			{
				BufferedReader in;
				try
					{
						in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
						StringBuilder response = new StringBuilder();
						String line = in.readLine();
						while (line != null)
							{
								response.append(line);
								//System.out.println(line);
								line = in.readLine();
							}
						in.close();
						return response.toString();
					}
				catch (IOException e)
					{
						e.printStackTrace();
						return null;
					}
			}
		
		public String getRevisionRange()
			{
				if (revisionRangeHi == revisionRangeLo)
					return Integer.toString(revisionRangeLo);
				else
					return Integer.toString(revisionRangeLo) + "-" + Integer.toString(revisionRangeHi);
			}
		
		protected Notifications	notifications;
		private BaseIO										io;
		private int													revisionRangeLo;
		private int													revisionRangeHi;
		private int													protocol	= DefaultServerSettings.DefaultProtocol;
	}

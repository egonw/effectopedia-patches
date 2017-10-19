package org.qsari.effectopedia.defaults;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.formats.FormatFlavour;

public class DefaultServerSettings
	{
		public static final int							HTTP																	= 0;
		public static final int							FTP																		= 1;
		public static final int							EFFECTOPEDIA_ORG					= 0;
		public static final int							TEST																	= 1;
		public static final int							DEBUG																= 2;
		public static int													DefaultProtocol						= HTTP;
		public static int													defaultServer								= EFFECTOPEDIA_ORG;
		public static FormatFlavour			defaultFormatFlavour	= FormatFlavour.AOPZ;
		public static FormatFlavour			cdbFormatFlavour					= FormatFlavour.AOPZ;
		public static final String				POST_END_OF_LINE					= "\r\n";
		public static final String				POST_BOUNDARY								= "EfFeCx3.14159265";
		public static final String				POST_BOUNDARY_TAG				= "--" + POST_BOUNDARY + POST_END_OF_LINE;
		public static final String				POST_EOL_BND_TAG					= "--" + POST_BOUNDARY + "--" + POST_END_OF_LINE;
		public static final String				POST_DISP_PATH							= POST_BOUNDARY_TAG + "Content-Disposition: form-data; name=\"path\";" + POST_END_OF_LINE + POST_END_OF_LINE;
		
		public static final String				POST_D_FILE_START				= POST_BOUNDARY_TAG + "Content-Disposition: form-data; name=\"file\"; type=\"zip\";" + " filename=\"";
		public static final String				POST_D_FILE_END						= "\"" + POST_END_OF_LINE;
		public static final String				POST_DISPOS_TYPE					= "Content-Type: application/x-zip-compressed" + POST_END_OF_LINE;
		public static final String				POST_DISPOS_ENC						= "Content-Transfer-Encoding: binary" + POST_END_OF_LINE;
		public static final byte						POST_EOL_BYTES[]					= POST_END_OF_LINE.getBytes();
		public static final int							POST_EOL													= HTTP;

		public static final String				signInURL												= "https://app.effectopedia.org/oauth2/";
		public static final String				upd_profileURL							= "https://app.effectopedia.org/profile/index.php?route=users/profile_update";
		public static final String				signOutURL											= "https://app.effectopedia.org/fake-signout/";
		
		public static final String				defaultFileName						= "Effectopedia";
		public static final String				defaultFileExt							= "aopz";
		public static final String[]		defaultSourceNames			= new String[]
																																																						{ "effectopedia.org/xmldb.php", "effectopedia.org/testdb.php", "effectopedia.org/debugdb.php" };
		public static final String[]		baseURLs													= new String[]
																																																						{ "https://app.effectopedia.org/api.php/production/",
																																																								"https://app.effectopedia.org/api.php/test/",
																																																								"https://app.effectopedia.org/api.php/debug/" };

		public static final String				defaultSourceName				= defaultSourceNames[defaultServer];
		public static final String				baseURL														= baseURLs[defaultServer];
		public static final String				publishFormURL							= baseURL + "publish.html";
		public static final String				publishURL											= baseURL + "upload_response.php";
		public static final String				downloadURL										= baseURL + "download.php";
		
		public static final String				currentRevision						= baseURL + "info.php?revision=current";
		public static final String				getRevision										= baseURL + "info.php?revision=get";
		public static final String				commitRevision							= baseURL + "info.php?revision=commit&number=";
		public static final String				getDSID														= baseURL + "dsinfo.php?req=get";
		public static final String				getNotifRev										= baseURL + "index.php?notification=current";
		public static final String				notify															= baseURL + "index.php?notification=commit&file_name=";
		
		public static final String				ftpServer												= "ftp.effectopedia.org";
		
		public static final String				userProfiles									= "https://app.effectopedia.org/sys/user_profiles_opt.php";
		public static final String				teamProfiles									= "https://app.effectopedia.org/sys/get_team.php?id=";
		
		private static final String[]	ftpUsers													= new String[]
																																																						{ "u39607026-contr", "u39607026-test_contr", "u39607026-debug_contr" };
		private static final String			ftpUser														= ftpUsers[defaultServer];
		private static final String			ftpPassword										= "45AOPContributors@)!!";
		private static String									responce													= null;
		public static boolean									blocked														= false;
		
		public static boolean isOnline()
			{
				try
					{
						URL url = new URL(currentRevision);
						url.openStream().close();
					}
				catch (MalformedURLException e)
					{
						return false;
					}
				catch (IOException e)
					{
						return false;
					}
				return true;
			}
		
		public static String getCurrentRevision()
			{
				responce = getServiceResponse(currentRevision);
				try
					{
						Long.parseLong(responce);
						blocked = false;
					}
				catch (NumberFormatException nfe)
					{
						blocked = true;
						responce = DataSource.defaultGeneratedRevision;
					}
				try
					{
						return downloadURL + "?name=" + URLEncoder.encode(defaultFileName + responce + "." + defaultFileExt, "UTF-8");
					}
				catch (UnsupportedEncodingException e)
					{
						return null;
					}
			}
		
		public static final String getResponce()
			{
				return responce;
			}
		
		public static String commitRevision(String revision, long userID)
			{
				return getServiceResponse(commitRevision + revision + "&user=" + userID);
			}
		
		public static String getLastNotifiedRevision()
			{
				return getServiceResponse(getNotifRev);
			}
		
		public static String submitNotifications(String fileName, long userID, String SHA256, int revision)
			{
				return getServiceResponse(notify + fileName + "&user=" + userID + "&key=" + SHA256 + "&revision=" + revision);
			}
		
		public static long getNewDataSourceID(String fileName)
			{
				String response;
				long r = -1;
				try
					{
						//System.out.println("filename:" + fileName + " ");
						//System.out.println(URLEncoder.encode(fileName, "UTF-8"));
						response = getServiceResponse(getDSID + "&user=" + Effectopedia.EFFECTOPEDIA.getCurrentUserID() + "&name=" + URLEncoder.encode(fileName, "UTF-8"));
						r = Long.parseLong(response);
					}
				catch (UnsupportedEncodingException | NumberFormatException e)
					{
						System.out.println("Exception Handled!");
						e.printStackTrace(System.out);
						return -1;
					}
				
				return r;
			}
		
		public static String getServiceResponse(String service)
			{
				InputStream inputStream;
				URL url;
				String revision = "";
				try
					{
						url = new URL(service);
						inputStream = url.openStream();
					}
				catch (MalformedURLException e)
					{
						inputStream = null;
					}
				catch (IOException e)
					{
						inputStream = null;
					}
				
				if (inputStream != null)
					{
						try
							{
								int bytesRead;
								BufferedInputStream buffer = new BufferedInputStream(inputStream);
								ByteArrayOutputStream content = new ByteArrayOutputStream();
								byte data[] = new byte[512];
								while ((bytesRead = buffer.read(data, 0, 512)) != -1)
									content.write(data, 0, bytesRead);
								revision = content.toString("UTF-8").trim();
							}
						catch (UnsupportedEncodingException e)
							{
								e.printStackTrace();
							}
						catch (IOException e)
							{
								e.printStackTrace();
							}
					}
				return revision;
			}
		
		public static String getNewRevisionName()
			{
				StringBuffer sb = new StringBuffer();
				sb.append(defaultFileName);
				responce = getServiceResponse(getRevision);
				sb.append(responce);
				sb.append(".");
				sb.append(defaultFileExt);
				return sb.toString();
			}
		
		public static String getFTPURL()
			{
				StringBuffer sb = new StringBuffer("ftp://");
				try
					{
						sb.append(URLEncoder.encode(ftpUser, "UTF-8"));
						sb.append(':');
						sb.append(URLEncoder.encode(ftpPassword, "UTF-8"));
					}
				catch (UnsupportedEncodingException e)
					{
						e.printStackTrace();
					}
				sb.append('@');
				sb.append(ftpServer);
				sb.append('/');
				sb.append(getNewRevisionName());
				sb.append(";type=i");
				return sb.toString();
			}
		
		public static URLConnection getFileUploadURL(int protocol, String fileName)
			{
				URLConnection urlc;
				try
					{
						if (protocol == HTTP)
							{
								URL url = new URL(publishURL);
								urlc = url.openConnection();
								urlc.setDoInput(true);
								urlc.setDoOutput(true);
								urlc.setUseCaches(false);
								
								urlc.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
								urlc.setRequestProperty("Accept-Encoding", "gzip, deflate");
								urlc.setRequestProperty("Referer", publishURL);
								urlc.setRequestProperty("User-Agent", "Effectopedia v. 0.9x");
								urlc.setRequestProperty("Connection", "Keep-Alive");
								urlc.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + POST_BOUNDARY);
							}
						else
							{
								URL url = new URL(getFTPURL(fileName));
								urlc = url.openConnection();
							}
					}
				catch (MalformedURLException e)
					{
						urlc = null;
						e.printStackTrace();
					}
				catch (IOException e)
					{
						urlc = null;
						e.printStackTrace();
					}
				return urlc;
			}
		
		public static byte[] buildHTTPContentDisposition(String path, String fileName) throws IOException
			{
				return (POST_DISP_PATH + path + POST_END_OF_LINE + POST_D_FILE_START + fileName + POST_D_FILE_END + POST_DISPOS_TYPE + POST_DISPOS_ENC + POST_END_OF_LINE).getBytes();
			}
		
		public static String getFTPURL(String fileName)
			{
				StringBuffer sb = new StringBuffer("ftp://");
				try
					{
						sb.append(URLEncoder.encode(ftpUser, "UTF-8"));
						sb.append(':');
						sb.append(URLEncoder.encode(ftpPassword, "UTF-8"));
					}
				catch (UnsupportedEncodingException e)
					{
						e.printStackTrace();
					}
				sb.append('@');
				sb.append(ftpServer);
				sb.append('/');
				sb.append(fileName);
				sb.append(";type=i");
				return sb.toString();
			}
		
		public static boolean isInternallyLoadedURL(URL url)
			{
				String urlString = url.toString();
				return signInURL.equals(urlString) || upd_profileURL.equals(urlString);
			}
		
	}

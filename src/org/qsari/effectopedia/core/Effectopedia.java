package org.qsari.effectopedia.core;

import java.util.ArrayList;
import java.util.EventObject;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.core.ui.nav.UILocation;
import org.qsari.effectopedia.core.ui.nav.UILocations;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.DataSourceItem;
import org.qsari.effectopedia.data.DataSourceMerge;
import org.qsari.effectopedia.data.DataSources;
import org.qsari.effectopedia.data.DatabaseDS;
import org.qsari.effectopedia.data.HistoricalDS;
import org.qsari.effectopedia.data.MemoryDS;
import org.qsari.effectopedia.data.RevisionBasedDS;
import org.qsari.effectopedia.data.formats.DataSourceFormat;
import org.qsari.effectopedia.data.formats.DataSourceFormat.SupportedFeatures;
import org.qsari.effectopedia.data.formats.FormatFlavour;
import org.qsari.effectopedia.data.formats.SupportedDataSourceFormats;
import org.qsari.effectopedia.data.generated.PathwaySourceCodeGenerator;
import org.qsari.effectopedia.data.html.HTMLFileFormat;
import org.qsari.effectopedia.data.xml.XMLFileDS;
import org.qsari.effectopedia.defaults.DefaultServerSettings;
import org.qsari.effectopedia.gui.core.SelectableListUI;
import org.qsari.effectopedia.history.Stamps;
import org.qsari.effectopedia.notification.NotificationManager;
import org.qsari.effectopedia.system.AuthenticationManager;
import org.qsari.effectopedia.system.AuthenticationManager.UserSignInListener;
import org.qsari.effectopedia.system.AuthenticationManager.UserSignOutListener;
import org.qsari.effectopedia.system.User;

/**
 * <code>Effectopedia</code> provides access to all encyclopedic data. By
 * default it does contain just one memory data source <code>MemoryDS</code>.
 * Alternatively it could be used with local or remote XML file or database
 * <code>DataSource</code>,
 * 
 * @see DataSource
 * @see MemoryDS
 * @see DatabaseDS
 * @see XMLFileDS
 * 
 * @version 1.0 @(#)Effectopedia.java 1.0
 * @author Hristo Aladjov
 */

public class Effectopedia implements UserSignInListener, UserSignOutListener
	{
		public static final Effectopedia	EFFECTOPEDIA	= new Effectopedia();
		
		private Effectopedia()
			{
				super();
				availableDataSources = new DataSources();
				dataSourceListeners = new ArrayList<DataSourceChangeListener>();
				editLog = new Stamps();
				authenticationManager = new AuthenticationManager();
				authenticationManager.addUserSignInListener(this);
				authenticationManager.addUserSignOutListener(this);
				defaultFormat = SupportedDataSourceFormats.FORMATS.getFormatByFormatFlavour(DefaultServerSettings.defaultFormatFlavour);
				if (defaultFormat != null)
					notificationManager = defaultFormat.createNotificationManager();
			}
		
		public static Effectopedia getEffectopedia()
			{
				return EFFECTOPEDIA;
			}
		
		public void defaultDatasource()
			{
				data = DEFAULT_DATASOURCE;
				availableDataSources.add(data);
			}
		
		public DataSource getDataSourceOf(EffectopediaObject eo)
			{
				for (DataSource ds : availableDataSources)
					if (ds.contains(eo))
						return ds;
				return null;
			}
		
		public class CentralizedDB implements Runnable
			{
				public void run()
					{
						if (!(DefaultServerSettings.isOnline()))
							return;
						String fileName = DefaultServerSettings.getCurrentRevision();
						String revision = DefaultServerSettings.getResponce();
						if (revision != null)
							{
								DataSourceFormat cdbFormat = SupportedDataSourceFormats.FORMATS.getFormatByFormatFlavour(DefaultServerSettings.cdbFormatFlavour);
								if (cdbFormat == null)
									return;
								centralizedDB = cdbFormat.createDataSource();
								centralizedDB.addDefault(data);
								availableDataSources.add(centralizedDB);
								centralizedDB.setCustomTitle("Establishing connection to effectopedia.org");
								fireDataSourceChanged(null);
								((BaseIO) centralizedDB).load(fileName);
								centralizedDB.resetCustomTitle();
								centralizedDB.setLocation(0, false);
								centralizedDB.setSourceName(DefaultServerSettings.defaultSourceName);
								data = centralizedDB;
								fireDataSourceChanged(new DataSourceChange(availableDataSources));
								//data.getLiveIndices().DEBUG_printIndices();
							}
						UserInterface.setBusyStatus(false);
					}
			}
		
		private void testMerge()
			{
				DataSourceFormat testFormat = SupportedDataSourceFormats.FORMATS.getFormatByFormatFlavour(FormatFlavour.AOPZ);
				if (testFormat == null)
					return;
				RevisionBasedDS file1 = testFormat.createDataSource();
				availableDataSources.add(file1);
				((BaseIO) file1).load("D://JAVA//org.qsari.effectopedia//test//Effectopedia1.aopz");
				RevisionBasedDS file2 = testFormat.createDataSource();
				availableDataSources.add(file2);
				((BaseIO) file2).load("D://JAVA//org.qsari.effectopedia//test//Effectopedia8.aopz");
				DataSourceMerge dsm = new DataSourceMerge(file1, file2);
				UserInterface.getDefaultNavigator().navigate(UILocations.editChangesUIL, dsm);
			}
		
		public void publish()
			{
				if (DefaultServerSettings.defaultServer != DefaultServerSettings.EFFECTOPEDIA_ORG)
					UserInterface
							.showWarning("You are about to publish your changes into the Effectopedia test server.\nAll information in the test server is periodically deleted.\nIf you like to use the production Effectopedia server, please download effectopedia.jar instead\nYou can save all of your current changes into a local file.");
				else if (!UserInterface
						.getUserConfirmation("You are about to publish your changes into the production Effectopedia server.\nIf it is just a test, please cancel publishing now and consider downloading effectopediaT.jar instead\nYou can save all of your current changes into a local file.\nDuring the beta testing it is always recommended to keep a local copy of your work.\nWould you like to continue with publishing?"))
					return;
				if (data instanceof RevisionBasedDS)
					{
						RevisionBasedDS publishedData = (RevisionBasedDS) data;
						String fileName = DefaultServerSettings.getCurrentRevision();
						String revision = DefaultServerSettings.getResponce();
						long rev = (revision == null) ? -1 : Long.parseLong(revision);
						if ((centralizedDB == publishedData) || (publishedData.getDataSourceID() == EFFECTOPEDIA_ID))
							{
								if (publishedData.getRevision() == rev)
									if (!publishedData.isModified())
										{
											UserInterface.showWarning("Effectopedia did not find any changes to publish! \n The publishing was canceled");
											return;
										}
									else
										{
											saveAsXMLFile(fileName, false);
											return;
										}
								else 
									{
										//UserInterface.showWarning("Datasorce merging is temporary disabled. Please save your work as local file and contact Effectopedia DT if you need further assistance with pulishing.");
										//return;
						
									
										Pathway pathway = publishedData.getCurrentView().getLastAddedPathway();
										RevisionBasedDS currentCDB = loadXML(fileName);
										data = currentCDB; // TODO Need to test this in the case of AOPZ
																													// database
										DataSourceMerge dsm = new DataSourceMerge(currentCDB, publishedData);
										if (dsm.updateAfromB() > 0)
											UserInterface.getDefaultNavigator().navigate(UILocations.editChangesUIL, dsm);
										else if (currentCDB.getRevision() <= publishedData.getRevision())
											saveAsXMLFile(fileName, false);
										availableDataSources.remove(currentCDB);
										pathway.setDataSource(publishedData);
										publishedData.setLocation(pathway);
									}
							}
						else
							{
								RevisionBasedDS currentCDB = loadXML(fileName);
								data = currentCDB;
								if (currentCDB.getContainedRevOfDataSourceIDs().containsKey(publishedData.getDataSourceID()))
									{
										UserInterface
												.showWarning("Synchronisation between a file already published in Effectopedia and its newer version is still under developement.\nPublishing will not be performed to avoid duplications.");
									}
								else
									{
										Pathway pathway = currentCDB.addLiveElements(publishedData, publishedData.getCurrentView().getLastAddedPathway());
										saveAsXMLFile(fileName, false);
										availableDataSources.remove(centralizedDB);
										centralizedDB = currentCDB;
										currentCDB.setLocation(pathway);
									}
							}
					}
				else
					{
						DataSource publishedData = data;
						String fileName = DefaultServerSettings.getCurrentRevision();
						centralizedDB.setCustomTitle("Loading database updates effectopedia.org");
						fireDataSourceChanged(null);
						RevisionBasedDS currentCDB = loadXML(fileName);
						data = currentCDB;
						Pathway pathway = currentCDB.addLiveElements(publishedData, publishedData.getCurrentView().getLastAddedPathway());
						saveAsXMLFile(fileName, false);
						availableDataSources.remove(centralizedDB);
						centralizedDB = currentCDB;
						currentCDB.setLocation(pathway);
					}
				loadLocation(centralizedDB);
				centralizedDB.setSourceName(DefaultServerSettings.defaultSourceName);
				fireDataSourceChanged(new DataSourceChange(availableDataSources));
				// data.getLiveIndices().DEBUG_printIndices();
			}
		
		public void connect()
			{
				// TODO
				
				// testMerge();
				UserInterface.setBusyStatus(true);
				(new Thread(new CentralizedDB())).start();
				// System.out.println(ActionTypes.getActionTypesAsInsertSQL());
				// System.out.println(TraceableClasses.getTraceableClassesAsInsertSQL());
				// System.out.println(System.getProperty("java.home"));
				
			}
		
		public void reloadCentralizedDB()
			{
				if ((centralizedDB != null) && (centralizedDB.isModified()))
					if (!UserInterface
							.getUserConfirmation("Centralized Effectopedia database hase been modified!\n If you choose to reload it from the server the changes will be lost.\n Do you want to reload the Effectopeida database form the server?"))
						return;
				availableDataSources.remove(centralizedDB);
				connect();
			}
		
		public <T extends EffectopediaObject> T getEffectopediaObject(Class<T> objectClass, long id)
			{
				return data.get(objectClass, id);
			}
		
		public <T extends EffectopediaObject> T[] getEffectopediaObjectArray(ReferenceIDs<T> ids)
			{
				return data.get(ids);
			}
		
		public DataSource getData()
			{
				if (data == null)
					data = DEFAULT_DATASOURCE;
				return this.data;
			}
		
		public void setData(DataSource dataSource)
			{
				if (availableDataSources.indexOf(dataSource) == -1)
					availableDataSources.add(dataSource);
				data = dataSource;
			}
		
		public void setData(DataSourceItem item)
			{
				int index = availableDataSources.indexOf(item);
				if (index != -1)
					{
						data = availableDataSources.get(index);
						fireDataSourceChanged(new DataSourceChange(availableDataSources));
					}
			}
		
		public RevisionBasedDS loadPrevousRevision()
			{
				if ((data instanceof RevisionBasedDS) && (((RevisionBasedDS) data).hasPrevous()))
					{
						int index = availableDataSources.indexOf(data);
						data = ((RevisionBasedDS) data).getPrevous(true);
						// ((RevisionBasedDS) data).addLocaionChangeListener(this);
						availableDataSources.set(index, data);
						fireDataSourceChanged(new DataSourceChange(availableDataSources));
						return (RevisionBasedDS) data;
					}
				return null;
			}
		
		public RevisionBasedDS loadNextRevision()
			{
				if ((data instanceof RevisionBasedDS) && (((RevisionBasedDS) data).hasNext()))
					{
						int index = availableDataSources.indexOf(data);
						data = ((RevisionBasedDS) data).getNext(true);
						// ((RevisionBasedDS) data).addLocaionChangeListener(this);
						availableDataSources.set(index, data);
						fireDataSourceChanged(new DataSourceChange(availableDataSources));
						return (RevisionBasedDS) data;
					}
				return null;
			}
		
		public RevisionBasedDS loadRevision(long revison)
			{
				if ((data instanceof RevisionBasedDS) && (((RevisionBasedDS) data).getMaxRevision() >= revison))
					{
						int index = availableDataSources.indexOf(data);
						data = ((RevisionBasedDS) data).get(revison);
						// ((RevisionBasedDS) data).addLocaionChangeListener(this);
						availableDataSources.set(index, data);
						fireDataSourceChanged(new DataSourceChange(availableDataSources));
						return (RevisionBasedDS) data;
					}
				return null;
			}
		
		public long getCurrentUserID()
			{
				return currentUser.getID();
			}
		
		public User getCurrentUser()
			{
				return currentUser;
			}
		
		public long getRevision()
			{
				if ((data != null) && (data instanceof RevisionBasedDS))
					return ((RevisionBasedDS) data).getRevision();
				else
					return 0L;
			}
		
		public void setCurrentUser(User currentUser)
			{
				this.currentUser = currentUser;
			}
		
		public DataSourceItem[] dataSources()
			{
				int count = availableDataSources.size();
				DataSourceItem[] result = new DataSourceItem[count + 1];
				for (int i = 0; i < count; i++)
					result[i] = (DataSourceItem) availableDataSources.get(i);
				result[availableDataSources.size()] = availableDataSources;
				return result;
			}
		
		public DataSources getAvailableDataSources()
			{
				return availableDataSources;
			}
		
		public DataSource getDataSourceByName(String sourceName, boolean makeItCurrent)
			{
				for (DataSource ds : availableDataSources)
					if ((ds instanceof RevisionBasedDS) && (((RevisionBasedDS) ds).getSourceName().equalsIgnoreCase(sourceName)))
						{
							if (makeItCurrent)
								data = ds;
							return ds;
						}
				return null;
			}
		
		public DataSource saveAsXMLFile(String fileName, boolean saveAsLocalFile)
			{
				if (fileName != null)
					{
						int hasExtension = fileName.lastIndexOf(".");
						if ((hasExtension == -1) || (fileName.lastIndexOf("\\") > hasExtension) || (fileName.lastIndexOf("/") > hasExtension))
							fileName = fileName + ".aop";
						DataSourceFormat proposedFormat = SupportedDataSourceFormats.FORMATS.proposeFileFormat(fileName);
						if ((data instanceof MemoryDS) || (data instanceof HistoricalDS))
							{
								if (proposedFormat == null)
									return data;
								RevisionBasedDS dataSource = proposedFormat.createDataSource();
								swapData(dataSource);
								((BaseIO) dataSource).save(fileName, saveAsLocalFile);
								fireDataSourceChanged(new DataSourceChange(availableDataSources));
							}
						else
							{
								if (data.getDataFormat() == proposedFormat)
									((BaseIO) data).save(fileName, saveAsLocalFile);
								else if (proposedFormat == null)
									{
										SelectableListUI<Pathway> selectorUI = UserInterface.getDefaultUIFactory().getPathwaySelectorUI();
										selectorUI.load(null, false);
										Pathway[] pathways = selectorUI.getSelected();
										String fn = fileName.substring(0, fileName.length() - 5);
										int cnt = 0;
										for (Pathway pathway : pathways)
											{
												PathwaySourceCodeGenerator sg = new PathwaySourceCodeGenerator(data, pathway.getID());
												sg.save(fileName);
												fileName = fn + (cnt++) + ".java";
											}
									}
								else if (proposedFormat.allows()==SupportedFeatures.IMPORT_EXPORT)
									// proposed format is different than the current format
									{
										RevisionBasedDS dataSource = proposedFormat.createDataSource();
										swapData(dataSource);
										((BaseIO) dataSource).save(fileName, saveAsLocalFile);
										fireDataSourceChanged(new DataSourceChange(availableDataSources));
									}
								else
									{
										DataSource current = data;
										RevisionBasedDS dataSource = proposedFormat.createDataSource();
										swapData(dataSource);
										((BaseIO) dataSource).save(fileName, saveAsLocalFile);
										availableDataSources.remove(dataSource);
										data = current;
									}
							}
					}
				return data;
			}
		
		protected void swapData(RevisionBasedDS dataSource)
			{
				dataSource.setDataSourceID(data.getDataSourceID());
				availableDataSources.add(dataSource);
				dataSource.addAll(data);
				dataSource.setCreateLive(data.isCreateLive());
				dataSource.getLiveIndices().updateDataSource(dataSource, false);
				dataSource.getArchiveIndices().updateDataSource(dataSource, false);
				dataSource.setLocation();
				data = dataSource;
				dataSource.clearExternalIds();
			}
		
		public void loadFromLocalXMLFile(String fileName)
			{
				if (fileName != null)
					{
						DataSourceFormat detctedFormat = SupportedDataSourceFormats.FORMATS.detectFileFormat(fileName);
						if (detctedFormat == null)
							{
								UserInterface.showError("File format not recognized!");
								return;
							}
						RevisionBasedDS dataSource = detctedFormat.createDataSource();
						availableDataSources.add(dataSource);
						data = dataSource;
						dataSource.addDefault(DEFAULT_DATASOURCE);
						((BaseIO) dataSource).load(fileName);
						fireDataSourceChanged(new DataSourceChange(availableDataSources));
						loadLocation(dataSource);
					}
			}
		
		public static RevisionBasedDS loadXML(String fileName)
			{
				DataSource originalData = EFFECTOPEDIA.data;
				DataSourceFormat detectedFormat = SupportedDataSourceFormats.FORMATS.detectFileFormat(fileName);
				if (detectedFormat == null)
					return null;
				RevisionBasedDS xmlDS = detectedFormat.createDataSource();
				xmlDS.addDefault(DEFAULT_DATASOURCE);
				((BaseIO) xmlDS).load(fileName);
				EFFECTOPEDIA.data = originalData;
				return xmlDS;
			}
		
		private void loadLocation(RevisionBasedDS rbData)
			{
				if (rbData.getLocationObject() != null)
					{
						EffectopediaObject eo = rbData.getLocationObject();
						UILocation location = UILocations.viewUIL;
						if (location != null)
							{
								location.setReadOnly(eo.isReadonly());
								UserInterface.getDefaultNavigator().navigate(location, eo);
							}
					}
				
			}
		
		public void loadCurrentLocation()
			{
				if (data instanceof RevisionBasedDS)
					{
						loadLocation((RevisionBasedDS) data);
						fireDataSourceChanged(new DataSourceChange(availableDataSources));
					}
			}
		
		public class DataSourceChange extends EventObject
			{
				/**
		 * 
		 */
				private static final long	serialVersionUID	= 1L;
				
				public DataSourceChange(Object source)
					{
						super(source);
					}
			}
		
		public interface DataSourceChangeListener
			{
				public void dataSourceChanged(DataSourceChange evt);
			}
		
		public void addDataSourceChangeListener(DataSourceChangeListener listener)
			{
				dataSourceListeners.add(listener);
			}
		
		public void removeDataSourceChangeListener(DataSourceChangeListener listener)
			{
				dataSourceListeners.remove(listener);
			}
		
		protected void fireDataSourceChanged(DataSourceChange evt)
			{
				for (DataSourceChangeListener listener : dataSourceListeners)
					listener.dataSourceChanged(evt);
			}
		
		public final AuthenticationManager getAutentication()
			{
				return authenticationManager;
			}
		
		public Stamps getStamps()
			{
				return editLog;
			}
		
		public long newStamp(long actionId)
			{
				return editLog.newStamp(actionId, currentUser.getID(), currentUser.getTeamID());
			}
		
		public void DEBUG_info()
			{
				System.out.println("Effectopedia Kernel version:" + VERSION);
			}
		
		@Override
		public void userSignedIn(EventObject evt)
			{
				if ((evt != null) && (evt.getSource() instanceof User))
					currentUser = (User) evt.getSource();
			}
		
		@Override
		public void userSignedOut(EventObject evt)
			{
				currentUser = User.GUEST;
			}
		
		/**
		 * ArrayList containing all available data sources. Initialized in the
		 * <code>Effectopedia()</code> constructor.
		 * 
		 * @see #Effectopedia
		 */
		protected DataSources																									availableDataSources;
		
		/**
		 * The Effectopedia's current data source . Initialized in the
		 * <code>Effectopedia()</code> constructor
		 * 
		 * @see #Effectopedia
		 */
		
		protected User																																currentUser								= User.GUEST;
		protected volatile DataSourceFormat											defaultFormat						= SupportedDataSourceFormats.FORMATS.getFormatByFormatFlavour(FormatFlavour.AOPZ);
		protected volatile RevisionBasedDS												centralizedDB						= null;
		protected AuthenticationManager															authenticationManager;
		protected volatile NotificationManager								notificationManager;
		protected Stamps																														editLog;
		protected ArrayList<DataSourceChangeListener>	dataSourceListeners;
		protected DataSource																										data															= DEFAULT_DATASOURCE;
		public static final String																				VERSION												= "1.2";
		// public static final String RELEASE_TYPE = "Alpha";
		public static final String																				RELEASE_TYPE							= "Beta";
		public static final DataSource																DEFAULT_DATASOURCE	= new MemoryDS();
		public static final long																						EFFECTOPEDIA_ID				= 1L;
		
	}

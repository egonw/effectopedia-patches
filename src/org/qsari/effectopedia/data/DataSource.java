package org.qsari.effectopedia.data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.EffectopediaObjects;
import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.base.ObjectIdentity;
import org.qsari.effectopedia.base.ids.ReferenceIDs;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.ui.IDataView;
import org.qsari.effectopedia.core.ui.IDataViews;
import org.qsari.effectopedia.core.ui.UIFactory;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.data.formats.DataSourceFormat;
import org.qsari.effectopedia.data.formats.FormatFlavour;
import org.qsari.effectopedia.data.generated.AOP18;
import org.qsari.effectopedia.data.generated.AOP51;
import org.qsari.effectopedia.data.generated.AOP64;
import org.qsari.effectopedia.data.generated.ModelTester;
import org.qsari.effectopedia.data.generated.NMDARs1b;
import org.qsari.effectopedia.data.generated.SourceGeneratedPathway;
import org.qsari.effectopedia.data.interfaces.IdentifiableDataSource;
import org.qsari.effectopedia.data.objects.DataValue;
import org.qsari.effectopedia.defaults.DefaultServerSettings;
import org.qsari.effectopedia.history.EditHistory;
import org.qsari.effectopedia.history.EditHistoryItem_Object;
import org.qsari.effectopedia.history.SourceID;
import org.qsari.effectopedia.history.SourceTrace;
import org.qsari.effectopedia.history.SourceTraces;
import org.qsari.effectopedia.history.Stamp;
import org.qsari.effectopedia.search.SearchEngine;
import org.qsari.effectopedia.system.ActionTypes;
import org.qsari.effectopedia.system.TraceableClasses;
import org.qsari.effectopedia.system.User;
import org.qsari.effectopedia.system.UserKey;

public abstract class DataSource implements IdentifiableDataSource
	{
		
		abstract public void add(EffectopediaObject eo);
		
		abstract public void add(Class<? extends EffectopediaObject> objectClass, EffectopediaObject eo);
		
		abstract public void addToArchive(Class<? extends EffectopediaObject> objectClass, EffectopediaObject eo);
		
		abstract public EffectopediaObject remove(Class<? extends EffectopediaObject> objectClass, long id);
		
		public void remove(EffectopediaObject eo)
			{
				/*
				 * if (eo != null) { EffectopediaObjects<? extends EffectopediaObject>
				 * objects.put(new Long(eo.getID()),
				 * EffectopediaObject.getDefaultObjects().get(eo.getID())); else if
				 * (eo.getID() != 0) ((EffectopediaObjects<? extends EffectopediaObject>)
				 * objects).remove(eo.getID()); livePathwayElements.removeTrace(eo);
				 * editHistory.remove(eo); }
				 */
			}
			
		public DataSource()
			{
				super();
				searchEngine = new SearchEngine();
				
				liveIndices = new Indices();
				archiveIndices = new Indices();
				editHistory = new EditHistory(this);
				livePathwayElements = new SourceTraces();
				userKey = new UserKey(Effectopedia.getEffectopedia().getCurrentUserID());
				UIFactory defaultUIFactory = UserInterface.getDefaultUIFactory();
				if (defaultUIFactory != null)
					{
						views = UserInterface.getDefaultUIFactory().createDataViews();
						currentView = UserInterface.getDefaultUIFactory().createDataView();
						views.put("Default", currentView);
						views.put("Revision", UserInterface.getDefaultUIFactory().createDataView());
						views.put("History", UserInterface.getDefaultUIFactory().createDataView());
					}
			}
			
		public <T extends EffectopediaObject> T[] get(ReferenceIDs<T> ids)
			{
				EffectopediaObjects<?> objects = liveIndices.get(ids.getObjectClass());
				if (objects != null)
					return (T[]) objects.getObjectArrayByIDs(ids);
				else
					return null;
			}
			
		@SuppressWarnings("unchecked")
		public <T extends EffectopediaObject> T get	(Class<T> objectClass, long id)
			{
				EffectopediaObjects<?> objects = liveIndices.get(objectClass);
				if (objects != null)
					return (T) objects.get(id);
				else
					return null;
			}
			
		@SuppressWarnings("unchecked")
		public <T extends EffectopediaObject> T getFromArchive(Class<T> objectClass, long id)
			{
				EffectopediaObjects<?> objects = archiveIndices.get(objectClass);
				if (objects != null)
					return (T) objects.get(id);
				else
					return null;
			}
			
		public boolean contains(EffectopediaObject eo)
			{
				if (eo != null)
					{
						EffectopediaObjects<?> objects = liveIndices.get(eo.getClass());
						return objects.containsKey(eo.getID());
					}
				return false;
			}
			
		@SuppressWarnings("unchecked")
		public <T extends EffectopediaObject> T get(ObjectIdentity oi)
			{
				Class<?> objectClass = TraceableClasses.REGISTERED.getClassByID(oi.getObjectClassId());
				EffectopediaObjects<?> objects = liveIndices.get(objectClass);
				if (objects != null)
					return (T) objects.get(oi.getObjectId());
				else
					return null;
			}
			
		@SuppressWarnings("unchecked")
		public <T extends EffectopediaObject> T getArchived(long classID, long archiveObjectID)
			{
				Class<?> objectClass = TraceableClasses.REGISTERED.getClassByID(classID);
				EffectopediaObjects<?> objects = archiveIndices.get(objectClass);
				if (objects != null)
					return (T) objects.get(archiveObjectID);
				else
					return null;
			}
			
		public EffectopediaObject getEffectopediaObjectByID(Class<? extends EffectopediaObject> objectClass, long id)
			{
				EffectopediaObject eo = get((Class<? extends EffectopediaObject>) objectClass, id);
				return eo;
			}
			
		public EffectopediaObject getArchivedEffectopediaObjectByID(Class<? extends EffectopediaObject> objectClass, long id)
			{
				EffectopediaObject eo = getFromArchive((Class<? extends EffectopediaObject>) objectClass, id);
				return eo;
			}
			
		public EffectopediaObject getEffectopediaObjectByInternalID(long ID)
			{
				return liveIndices.getEffectopediaObject(ID);
			}
			
		public EffectopediaObject getEffectopediaObjectByExternalID(long externalID)
			{
				EffectopediaObject eo = getLiveEffectopediaObjectByExternalID(externalID);
				if (eo == null)
					return getArchiveEffectopediaObjectByExternalID(externalID);
				else
					return eo;
			}
			
		abstract public EffectopediaObject getLiveEffectopediaObjectByExternalID(long externalID);
		
		public EffectopediaObject DEBUG_getLiveEffectopediaObjectByExternalID(long externalID)
			{
				HashMap<Long, EffectopediaObject> idMAP = liveIndices.generateExternalIDToIDMap();
				return idMAP.get(externalID);
			}
			
		abstract public EffectopediaObject getArchiveEffectopediaObjectByExternalID(long externalID);
		
		public EffectopediaObject DEBUG_getArchiveEffectopediaObjectByExternalID(long externalID)
			{
				HashMap<Long, EffectopediaObject> idMAP = archiveIndices.generateExternalIDToIDMap();
				return idMAP.get(externalID);
			}
			
		public long getExternalIDbyID(Class<? extends EffectopediaObject> objectClass, long id)
			{
				EffectopediaObject eo = getEffectopediaObjectByID(objectClass, id);
				if (eo != null)
					return eo.getExternalID();
				else
					return 0L;
			}
			
		public long getExternalIDbyID(long classID, long id)
			{
				Class<? extends EffectopediaObject> objectClass = TraceableClasses.REGISTERED.getClassByID(classID);
				EffectopediaObject io = getEffectopediaObjectByID(objectClass, id);
				if (io != null)
					return io.getExternalID();
				else
					return 0L;
			}
			
		public long getExternalIDbyArchivedID(long classID, long id)
			{
				Class<? extends EffectopediaObject> objectClass = TraceableClasses.REGISTERED.getClassByID(classID);
				EffectopediaObject io = getArchivedEffectopediaObjectByID(objectClass, id);
				if (io != null)
					return io.getExternalID();
				else
					{
						io = getEffectopediaObjectByID(objectClass, id);
						return (io != null) ? io.getExternalID() : 0L;
					}
			}
			
		public long getIDbyExternalID(long classID, long externalID)
			{
				EffectopediaObject eo = getLiveEffectopediaObjectByExternalID(externalID);
				return eo != null ? eo.getID() : 0L;
			}
			
		public long getIDbyExternalID(Class<?> objectClass, long externalID)
			{
				EffectopediaObject eo = getLiveEffectopediaObjectByExternalID(externalID);
				return eo != null ? eo.getID() : 0L;
			}
			
		public long getArchiveIDbyExternalID(long externalID)
			{
				EffectopediaObject eo = getArchiveEffectopediaObjectByExternalID(externalID);
				if (eo == null)
					eo = getLiveEffectopediaObjectByExternalID(externalID);
				return eo != null ? eo.getID() : 0L;
			}
			
		public long getArchiveIDbyExternalID(Class<?> objectClass, long externalID)
			{
				EffectopediaObject eo = getArchiveEffectopediaObjectByExternalID(externalID);
				return eo != null ? eo.getID() : 0L;
			}
			
		public EffectopediaObject getLiveObject(Class<? extends EffectopediaObject> objectClass, long id)
			{
				EffectopediaObjects<?> index = liveIndices.get(objectClass);
				return index.get(id);
			}
			
		public EffectopediaObject getLiveObject(SourceTrace sourceTrace)
			{
				if (sourceTrace == null)
					return null;
				Class<? extends EffectopediaObject> objectClass = (Class<? extends EffectopediaObject>) TraceableClasses.REGISTERED.getClassByID(sourceTrace.getClassID());
				EffectopediaObjects<?> index = liveIndices.get(objectClass);
				return index.get(sourceTrace.getInternalID());
			}
			
		public void bringToLive(Class<? extends EffectopediaObject> objectClass, EffectopediaObject eo)
			{
				bringToLive(objectClass, eo, new SourceID().setIfDefault(eo));
			}
			
		public void bringToLive(Class<? extends EffectopediaObject> objectClass, EffectopediaObject eo, SourceID sourceID)
			{
				if (ignoreChanges)
					return;
				// System.out.println("#####> Object " + eo.getClass() + "\t" + eo.getID() +
				// "\tis brought to live");
				if (!internalLoad)
					{
						add(objectClass, eo);
						long id = eo.getID();
						if (eo.isDefaultID())
							if (EffectopediaObject.getDefaultObjects().get(eo.getDefaultID()) != eo)
								System.err.println("Adding clone to the live objects which will override the default");
						livePathwayElements.addTrace(eo, sourceID);
						// Negative ID Revolution
						if ((id >= 0) || ((id < 0) && (editHistory.getObjectHistoryMap().get(id) == null)))
							{
								long classID = TraceableClasses.REGISTERED.getClassID(objectClass);
								editHistory.add(new EditHistoryItem_Object(id, id, classID), Effectopedia.EFFECTOPEDIA.newStamp(ActionTypes.CREATE_OBJECT));
								editHistory.modified.add(eo);
							}
					}
				else
					{
						if (!eo.isDefaultID())
							eo.setDataSource(this);
						if (createLive)
							add(objectClass, eo);
						else
							addToArchive(objectClass, eo);
					}
			}
			
		public boolean isLive(EffectopediaObject eo)
			{
				EffectopediaObjects<? extends EffectopediaObject> objects = liveIndices.get(eo.getClass());
				return objects.containsKey(eo.getID());
			}
			
		public void addLiveObject(EffectopediaObject eo, SourceID sourceID)
			{
				if (ignoreChanges)
					return;
				add(eo.getClass(), eo);
				long id = eo.getID();
				livePathwayElements.addTrace(eo, sourceID);
				// Negative ID Revolution
				if ((id >= 0) || ((id < 0) && (editHistory.getObjectHistoryMap().get(id) == null)))
					{
						long classID = TraceableClasses.REGISTERED.getClassID(eo.getClass());
						editHistory.add(new EditHistoryItem_Object(id, id, classID), Effectopedia.EFFECTOPEDIA.newStamp(ActionTypes.CREATE_OBJECT));
						editHistory.modified.add(eo);
					}
			}
			
		public void modifyObject(Class<? extends EffectopediaObject> objectClass, EffectopediaObject eo, long actionID)
			{
				if (ignoreChanges || editHistory.modified.contains(eo))
					return;
				// System.out.println("#####> Modify object" + eo.getClass() + "\t" +
				// eo.getID());
				EffectopediaObject clone = eo.clone();
				clone.autoSetId();
				clone.setExternalID(0);
				eo.setDefaultID(EffectopediaObject.NON_DEFAULT);
				addToArchive(clone.getClass(), clone);
				long classID = TraceableClasses.REGISTERED.getClassID(eo.getClass());
				editHistory.add(new EditHistoryItem_Object(eo.getID(), clone.getID(), classID), Effectopedia.EFFECTOPEDIA.newStamp(actionID));
				lastActionID = actionID;
				editHistory.modified.add(eo);
			}
			
		public void updateDefaultObjectInLiveIndices()
			{
				for (EffectopediaObject eo : EffectopediaObject.getDefaultObjects().values())
					add(eo.getClass(), eo);
			}
			
		public void updateSearchIndices(DataValue<?> oldValue, DataValue<?> newValue)
			{
				if (searchEngine.getIndices().isAutoUpdating())
					searchEngine.getIndices().update(oldValue, newValue);
			}
			
		public void updateExternalIDs()
			{
				liveIndices.updateExternalIDs();
			}
			
		public void clearExternalIds()
			{
				boolean sm = shallowMode;
				shallowMode = false;
				liveIndices.clearExternalIDs();
				archiveIndices.clearExternalIDs();
				shallowMode = sm;
			}
			
		@SuppressWarnings("unused")
		public void generateTestData()
			{
				// TODO
				Stamp.setDefaultDate(2014, 2, 7, 0, 0, 0, 0);
				// Stamp.resetDefaultDate();
				// ModelTester modelTester = new ModelTester(this);
//				AInh ainh = new AInh(this);
		
				
				// Stamp.resetDefaultDate();
				// QAOP_AromataseInhibitionPR INSTANCE1 = new
				// QAOP_AromataseInhibitionPR(this);
				// QAOP_EstrogenBindingPR INSTANCE2 = new QAOP_EstrogenBindingPR(this);
				// QAOP_SkinSensitization INSTANCE3 = new QAOP_SkinSensitization(this);
				// QAOP_Test INSTANCE4 = new QAOP_Test(this);
				// QAOP_NMDARs INSTANCE5 = new QAOP_NMDARs(this);
				// User SJ = new
				// User("id=97;displayName=jarzina.s;firstName=Sebastian;lastName=Jarzina;e-mail=sebastian.jarzina@uni-wuerzburg.de");
				// Effectopedia.EFFECTOPEDIA.setCurrentUser(SJ);
				// generated gen = new generated(this);
				
				// GeneratedAOP generated = new GeneratedAOP(this);
				// User NMDAR = new
				// User("id=93;displayName=Magdalini Sachana, Sharon Munn, Anna
				// Bal-Price;firstName=NMDAR;lastName=Authors
				// team;e-mail=anna.price@ec.europa.eu");
				// Effectopedia.EFFECTOPEDIA.setCurrentUser(NMDAR);
				// SourceGeneratedPathway generated = new NMDARs1b(this);
				
				/*
				 * User Brigitte = new
				 * User("id=98;displayName=Brigitte Landesmann;firstName=Brigitte;lastName=Landesmann;e-mail=Brigitte.LANDESMANN@ec.europa.eu"
				 * ); Brigitte.setTeamID(5);
				 * Effectopedia.EFFECTOPEDIA.setCurrentUser(Brigitte);
				 * SourceGeneratedPathway ss = new ss_aop(this);
				 */
				
				/*
				 * Effectopedia.EFFECTOPEDIA.setCurrentUser(NMDAR); new gr_aop(this);
				 */
				// Effectopedia.EFFECTOPEDIA.setCurrentUser(NMDAR);
				// new NMDARs1b(this);
				
				// Effectopedia.EFFECTOPEDIA.setCurrentUser(NMDAR);
				// new gr_aop(this);
				
		//		User ArInhib = new User("id=22;displayName=Dan Villeneuve;firstName=Dan;lastName=Villeneuve;e-mail=villeneuve.dan@epa.gov");
		//		ArInhib.setTeamID(6);
		//		Effectopedia.EFFECTOPEDIA.setCurrentUser(ArInhib);
				// AInh ah = new AInh(this);
	/*			
			AOP18 ne1 = new AOP18(this,false);
			AOP51	ne2 = new AOP51(this,false);
			AOP64 ne3 = new AOP64(this,false);

			Effectopedia.EFFECTOPEDIA.saveAsXMLFile(".//test//AOPX//ThreeAOPs.aopz", true);
			*/
			Stamp.resetDefaultDate();
				
				
				// TestDataGenerator.EXAMPLES.Test0();
				createLive = true;
				if (false)
					{
						dataSourceID = 1;
						editHistory.startNewRevision();
						Effectopedia.EFFECTOPEDIA.setCurrentUser(User.IQF);
						Stamp.setDefaultDate(2008, 9, 15, 11, 30, 0, 0);
						TestDataGenerator.EXAMPLES.Example1(this);
						TestDataGenerator.EXAMPLES.Example2(this);
						TestDataGenerator.EXAMPLES.Example3(this);
						TestDataGenerator.EXAMPLES.Example4(this);
						TestDataGenerator.EXAMPLES.Example5(this);
						TestDataGenerator.EXAMPLES.Example6(this);
						TestDataGenerator.EXAMPLES.Example7(this);
						DataSource data;
						if (DefaultServerSettings.defaultFormatFlavour == FormatFlavour.XML)
							data = Effectopedia.EFFECTOPEDIA.saveAsXMLFile(".//test//mf//rev1.xml", true); // multifile
						else
							data = Effectopedia.EFFECTOPEDIA.saveAsXMLFile(".//test//Effectopedia1.aopz", true);
						waitUntilPublished();
						Stamp.setDefaultDate(2010, 3, 11, 10, 00, 0, 0);
						this.getEditHistory().startNewRevision();
						TestDataGenerator.EXAMPLES.LhasaInhibitionComplex_I_IV(data);
						TestDataGenerator.EXAMPLES.LhasaInhibitionATPSynthesis(data);
						if (DefaultServerSettings.defaultFormatFlavour == FormatFlavour.XML)
							data = Effectopedia.EFFECTOPEDIA.saveAsXMLFile(".//test//mf//rev2.xml", true);
						else
							data = Effectopedia.EFFECTOPEDIA.saveAsXMLFile(".//test//Effectopedia2.aopz", true);
						waitUntilPublished();
						
						this.getEditHistory().startNewRevision();
						TestDataGenerator.EXAMPLES.LhasaInhibitionEnzyme5AalphaReductaseType2(data);
						TestDataGenerator.EXAMPLES.LhasaAR_Antagonism(data);
						TestDataGenerator.EXAMPLES.LhasaAromatase_Inhibition(data);
						TestDataGenerator.EXAMPLES.LhasaAromatase_Inhibition_of_histone_deacetylases_class_I(data);
						(TestDataGenerator.EXAMPLES.LhasaBindingToNicotinicReceptors(data)).makeItReadonly();
						TestDataGenerator.EXAMPLES.LhasaBindingToNicotinicReceptors(data);
						TestDataGenerator.EXAMPLES.LhasaRetinoicAcidSignalling(data);
						if (DefaultServerSettings.defaultFormatFlavour == FormatFlavour.XML)
							data = Effectopedia.EFFECTOPEDIA.saveAsXMLFile(".//test//mf//rev3.xml", true);
						else
							data = Effectopedia.EFFECTOPEDIA.saveAsXMLFile(".//test//Effectopedia3.aopz", true);
						waitUntilPublished();
						
						this.getEditHistory().startNewRevision();
						Effectopedia.EFFECTOPEDIA.setCurrentUser(User.IQF);
						TestDataGenerator.EXAMPLES.generateMIEs(data);
						TestDataGenerator.EXAMPLES.generateAdversOutcomesAndEndpoints(data);
						if (DefaultServerSettings.defaultFormatFlavour == FormatFlavour.XML)
							data = Effectopedia.EFFECTOPEDIA.saveAsXMLFile(".//test//mf//rev4.xml", true);
						else
							data = Effectopedia.EFFECTOPEDIA.saveAsXMLFile(".//test//Effectopedia4.aopz", true);
						waitUntilPublished();
						// this.getEditHistory().startNewRevision();
						// Effectopedia.EFFECTOPEDIA.setCurrentUser(User.IQF);
						// TestDataGenerator.EXAMPLES.LhasaPatch(data); //
						// data = Effectopedia.EFFECTOPEDIA.saveAsXMLFile("Effectopedia5.aopz",
						// true);
						
						this.getEditHistory().startNewRevision();
						TestDataGenerator.EXAMPLES.Gil_Thought_starter_DNA_Intercalation_Mediated_Cardiomyopathy(data);
						if (DefaultServerSettings.defaultFormatFlavour == FormatFlavour.XML)
							data = Effectopedia.EFFECTOPEDIA.saveAsXMLFile(".//test//mf//rev5.xml", true);
						else
							data = Effectopedia.EFFECTOPEDIA.saveAsXMLFile(".//test//Effectopedia5.aopz", true);
						waitUntilPublished();
						this.getEditHistory().startNewRevision();
						
						TestDataGenerator.EXAMPLES.AR_Agonism_leading_to_reproductive_dysfunction(data);
						if (DefaultServerSettings.defaultFormatFlavour == FormatFlavour.XML)
							data = Effectopedia.EFFECTOPEDIA.saveAsXMLFile(".//test//mf//rev6.xml", true);
						else
							data = Effectopedia.EFFECTOPEDIA.saveAsXMLFile(".//test//Effectopedia6.aopz", true);
						waitUntilPublished();
						this.getEditHistory().startNewRevision();
						
						Stamp.setDefaultDate(2016, 9, 15, 9, 00, 0, 0);

						User NMDAR = new User("id=101;displayName=Magdalini Sachana;firstName=Magdalini;lastName=Sachana;e-mail=Magdalini.SACHANA@oecd.org");
						NMDAR.setTeamID(4);
						Effectopedia.EFFECTOPEDIA.setCurrentUser(NMDAR);
						SourceGeneratedPathway generated = new NMDARs1b(data, false);
						if (DefaultServerSettings.defaultFormatFlavour == FormatFlavour.XML)
							data = Effectopedia.EFFECTOPEDIA.saveAsXMLFile(".//test//mf//rev7.xml", true);
						else
							data = Effectopedia.EFFECTOPEDIA.saveAsXMLFile(".//test//Effectopedia7.aopz", true);
						waitUntilPublished();
						this.getEditHistory().startNewRevision();
						
						Effectopedia.EFFECTOPEDIA.setCurrentUser(User.IQF);
						generated = new ModelTester(data, false);
						if (DefaultServerSettings.defaultFormatFlavour == FormatFlavour.XML)
							data = Effectopedia.EFFECTOPEDIA.saveAsXMLFile(".//test//mf//rev8.xml", true);
						else
							data = Effectopedia.EFFECTOPEDIA.saveAsXMLFile(".//test//Effectopedia8.aopz", true);
						waitUntilPublished();
						this.getEditHistory().startNewRevision();
						
						// ModelTester modelTester = new ModelTester(this);
					}
				Effectopedia.EFFECTOPEDIA.setCurrentUser(User.GUEST);
				// TODO
			}
			
		public void waitUntilPublished()
			{
				if (publishing != null)
					{
						try
							{
								synchronized (publishing)
									{
										if (!browsing)
											wait();
									}
							}
						catch (InterruptedException e)
							{
								e.printStackTrace();
							}
						publishing = null;
					}
			}
			
		public long autoExternalID(IndexedObject io)
			{
				if (isBrowsing())
					if (io != null)
						return io.getExternalID();
					else
						return 0L;
				else if (io instanceof EffectopediaObject)
					{
						if (io.getID() == 0)
							{
								// System.out.println("foundExternalID->\t" + 0 + "\tfor an\t" +
								// io.getClass().getSimpleName()+"\t");
								return 0;
							}
						long extID = 0;
						EffectopediaObject e = (EffectopediaObject) io;
						EffectopediaObjects<?> objects = liveIndices.get(io.getClass());
						if (objects != null)
							{
								e = objects.get(io.getID());
								if (e != null)
									extID = e.getExternalID();
							}
						if (extID == 0)
							{
								objects = archiveIndices.get(io.getClass());
								if (objects != null)
									{
										e = objects.get(io.getID());
										if (e != null)
											{
												extID = e.getExternalID();
											}
									}
							}
							
						if (extID != 0)
							return extID;
						else
							{
								extID = externalIDs++;
								return extID;
							}
					}
				else
					return io.getID();
			}
			
		public long autoExternalID(Class<?> objectClass, long id)
			{
				if (EffectopediaObject.class.isAssignableFrom(objectClass))
					{
						// System.out.print("\tid=\t" + id + "\t->");
						if (id == 0)
							{
								// System.out.println("foundExternalID->\t" + 0 + "\tfor an\t" +
								// objectClass.getSimpleName()+"\t");
								return 0;
							}
						long extID = 0;
						EffectopediaObject e = null;
						EffectopediaObjects<?> objects = liveIndices.get(objectClass);
						if (objects != null)
							{
								e = objects.get(id);
								if (e != null)
									extID = e.getExternalID();
							}
						if (extID == 0)
							{
								objects = archiveIndices.get(objectClass);
								if (objects != null)
									{
										e = objects.get(id);
										if (e != null)
											extID = e.getExternalID();
									}
							}
						if (objects == null)
							{
								e = liveIndices.getByID(id);
								if (e != null)
									extID = e.getExternalID();
							}
						if (extID != 0)
							return extID;
						else
							{
								extID = externalIDs++;
								if (e != null)
									e.setExternalID(extID);
								else
									System.err.println("Assigining externalID (" + extID + ") to object " + objectClass.getName() + " ID=" + id + " which is not indexed");
								return extID;
							}
					}
				else
					{
						// System.out.println("autoExternalID == id");
						return id;
					}
			}
			
		public boolean isInternalLoad()
			{
				return internalLoad;
			}
			
		public void setInternalLoad(boolean internalLoad)
			{
				this.internalLoad = internalLoad;
			}
			
		public boolean isShallowMode()
			{
				return shallowMode;
			}
			
		public void setShallowMode(boolean shallowMode)
			{
				this.shallowMode = shallowMode;
			}
			
		public IDataViews getViews()
			{
				return views;
			}
			
		public void setViews(IDataViews views)
			{
				this.views = views;
			}
			
		public IDataView getCurrentView()
			{
				return currentView;
			}
			
		public void setCurrentView(IDataView currentView)
			{
				this.currentView = currentView;
			}
			
		public boolean isBrowsing()
			{
				return browsing;
			}
			
		public void setBrowsing(boolean browsing)
			{
				this.browsing = browsing;
			}
			
		public SearchEngine getSearchEngine()
			{
				return searchEngine;
			}
			
		public void setSearchEngine(SearchEngine searchEngine)
			{
				this.searchEngine = searchEngine;
			}
			
		public void addAll(DataSource dataSource)
			{
				liveIndices.putAll(dataSource.liveIndices);
				archiveIndices.putAll(dataSource.archiveIndices);
				
				searchEngine.getIndices().copyAllIndices(dataSource.searchEngine.getIndices());
				
				editHistory.addAll(dataSource.editHistory);
				livePathwayElements.addAll(dataSource.livePathwayElements);
				views.putAll(dataSource.views);
				
				annotation = dataSource.annotation;
				userKey = dataSource.userKey;
				externalIDs = dataSource.externalIDs;
			}
			
		public void addDefault(DataSource dataSource)
			{
				liveIndices.putDefault(dataSource.getLiveIndices());
				archiveIndices.putDefault(dataSource.getArchiveIndices());
				
				searchEngine.getIndices().copyAllIndices(dataSource.searchEngine.getIndices());
				
				editHistory.addDefault(dataSource.getEditHistory());
				livePathwayElements.addDefault(dataSource.getLivePathwayElements());
				views.putAll(dataSource.getViews());
				currentView = dataSource.getCurrentView();
			}
			
		public Pathway addLiveElements(DataSource dataSource, Pathway viewPathway)
			{
				boolean reloadViewPathway = (viewPathway != null);
				long viewPathwayID = reloadViewPathway ? viewPathway.getID() : 0;
				Indices source = dataSource.getLiveIndices();
				//System.out.println("Total count before merging:" + liveIndices.getTotalEffectopediaObjectCount());
				IndexedObject.ID_OFFSET = EffectopediaObject.effectopediaObjectIDs - dataSource.getLiveIndices().getMinObjectID() + 1;
				Iterator<EffectopediaObjects<? extends EffectopediaObject>> it = source.values().iterator();
				while (it.hasNext())
					{
						EffectopediaObjects<? extends EffectopediaObject> objects = it.next();
						for (EffectopediaObject eo : objects.values())
							if (!eo.isDefaultID())
								{
									SourceTrace srcTrace = dataSource.getLivePathwayElements().getSourceTraceByID(eo.getID());
									SourceID sourceID = (srcTrace != null) ? srcTrace.getSourceID() : null;
									if (eo instanceof Pathway)
										addLiveObject(((Pathway) eo).deepClone(null, this), sourceID);
									else
										addLiveObject(eo.clone(eo.getParent(), this), sourceID);
								}
					}
				viewPathwayID += IndexedObject.ID_OFFSET;
				//System.out.println("Total count before merging:" + liveIndices.getTotalEffectopediaObjectCount());
				//System.out.println("Max Object ID = " + liveIndices.getMaxObjectID());
				EffectopediaObject.effectopediaObjectIDs = EffectopediaObject.effectopediaObjectIDs + source.getTotalEffectopediaObjectCount() + EffectopediaObject.getDefaultIDs() + 3;
				IndexedObject.ID_OFFSET = 0;
				liveIndices.reloadReferredObjectsFromID();
				if (dataSource instanceof RevisionBasedDS)
					containedRevOfDataSourceIDs.put(dataSource.dataSourceID, ((RevisionBasedDS) dataSource).getRevision());
				else
					containedRevOfDataSourceIDs.put(dataSource.dataSourceID, 0L);
				if (reloadViewPathway)
					return get(Pathway.class, viewPathwayID);
				else
					return null;
			}
			
		/*
		 * public Pathway addLiveElements(DataSource dataSource, Pathway viewPathway)
		 * { Pathway viewPathwayClone = null; LinkedHashMap<Long, EffectopediaObject>
		 * clones = new LinkedHashMap<Long, EffectopediaObject>();
		 * EffectopediaObjects<Pathway> pathwaysIndex =
		 * dataSource.getLiveIndices().pathways; Iterator<Pathway> pathways =
		 * pathwaysIndex.values().iterator(); this.internalLoad = false;
		 * this.shallowMode = false; this.createLive = true;
		 * EffectopediaObject.CLONEIDs = false; while (pathways.hasNext()) { Pathway
		 * pathway = pathways.next(); if (!pathway.isDefaultID()) { Pathway clone =
		 * pathway.deepClone(null, this); clone.getContainedIDs(clones); if (pathway
		 * == viewPathway) viewPathwayClone = clone; } }
		 * 
		 * Iterator<EffectopediaObject> clonesIt = clones.values().iterator(); while
		 * (clonesIt.hasNext()) { EffectopediaObject eo = clonesIt.next(); if
		 * ((get(eo.getClass(), eo.getID()) != null))
		 * System.out.println("DataSource.addLiveElements cloned element found:" +
		 * eo.DEBUG_getIDs()); else
		 * System.err.println("DataSource.addLiveElements cloned element not found:" +
		 * eo.DEBUG_getIDs()); }
		 * 
		 * Iterator<EffectopediaObjects<? extends EffectopediaObject>> it =
		 * dataSource.getLiveIndices().values().iterator(); while (it.hasNext()) {
		 * EffectopediaObjects<? extends EffectopediaObject> objects = it.next(); if
		 * (objects == pathwaysIndex) continue; Iterator<? extends EffectopediaObject>
		 * oit = objects.values().iterator(); while (oit.hasNext()) {
		 * EffectopediaObject eo = oit.next(); if
		 * (EffectopediaObject.idMAP.containsKey(eo.getID())) { eo =
		 * EffectopediaObject.idMAP.get(eo.getID()); if (get(eo.getClass(),
		 * eo.getID()) == null) {
		 * System.out.println("Add clone to the destination dataSource" +
		 * eo.DEBUG_getIDs()); add(eo.getClass(), eo); } } if
		 * (!clones.containsKey(eo.getID())) {
		 * System.out.println("DataSource.addLiveElements fragment" +
		 * eo.DEBUG_getIDs()); EffectopediaObject clone = eo.clone(null, this);
		 * clone.process(EffectopediaObject.BatchUpdateClonedReferrals.INSTANCE);
		 * clone.getContainedIDs(clones); } } }
		 * 
		 * EffectopediaObject.idMAP.clear(); EffectopediaObject.CLONEIDs = true;
		 * 
		 * clonesIt = clones.values().iterator(); while (clonesIt.hasNext()) {
		 * EffectopediaObject eo = clonesIt.next();
		 * System.out.println("DataSource.addLiveElements cloned object" +
		 * eo.DEBUG_getIDs()); if (eo.isDefaultID()) continue; eo.setExternalID(0); if
		 * (!isLive(eo)) bringToLive(eo.getClass(), eo); }
		 * 
		 * clonesIt = clones.values().iterator(); while (clonesIt.hasNext()) {
		 * EffectopediaObject eo = clonesIt.next(); if (eo.isDefaultID()) continue;
		 * eo.reloadReferredObjectsFromID(); }
		 * 
		 * return viewPathwayClone; }
		 */
		
		public String toString()
			{
				return "DataSource";
			}
			
		public Indices getLiveIndices()
			{
				return liveIndices;
			}
			
		public Indices getArchiveIndices()
			{
				return archiveIndices;
			}
			
		public EditHistory getEditHistory()
			{
				return editHistory;
			}
			
		public SourceTraces getLivePathwayElements()
			{
				return livePathwayElements;
			}
			
		public String getAnnotation()
			{
				return annotation;
			}
			
		public UserKey getUserKey()
			{
				return userKey;
			}
			
		public boolean isCreateLive()
			{
				return createLive;
			}
			
		public void setCreateLive(boolean createLive)
			{
				this.createLive = createLive;
			}
			
		public long getDataSourceID()
			{
				return dataSourceID;
			}
			
		public void setDataSourceID(long dataSourceID)
			{
				this.dataSourceID = dataSourceID;
			}
			
		public boolean isModified()
			{
				return editHistory.modified.size() != 0;
			}
			
		public DataSourceFormat getDataFormat()
			{
				return dataFormat;
			}
			
		public FormatFlavour getDataFormatFlavour()
			{
				return dataFormatFlavour;
			}
			
		public void setDataFormatFlavour(FormatFlavour dataFormatFlavour)
			{
				this.dataFormatFlavour = dataFormatFlavour;
			}
			
		public String getObjectURI(IndexedObject io)
			{
				return dataFormat.getFormatName() + " sourceID= " + dataSourceID + "&extID=" + io.getExternalID();
			}
			
		public LinkedHashMap<Long, Long> getContainedRevOfDataSourceIDs()
			{
				return containedRevOfDataSourceIDs;
			}
			
		public void setContainedRevOfDataSourceIDs(LinkedHashMap<Long, Long> containedRevOfDataSourceIDs)
			{
				this.containedRevOfDataSourceIDs = containedRevOfDataSourceIDs;
			}
			
		protected DataSourceFormat										dataFormat;
		protected FormatFlavour													dataFormatFlavour;
		protected SearchEngine														searchEngine;
		protected Indices																			liveIndices;
		protected Indices																			archiveIndices;
		
		protected EffectopediaObject								lastModifiedObject										= null;
		protected long																						lastActionID																= -1;
		protected EditHistory															editHistory;
		protected SourceTraces														livePathwayElements;
		protected volatile IDataViews							views;
		protected volatile IDataView								currentView;
		
		protected boolean																			internalLoad;
		protected boolean																			createLive																		= false;
		protected boolean																			browsing																				= true;
		protected boolean																			shallowMode																	= true;
		private boolean																					ignoreChanges															= false;
		
		public static final String										defaultGeneratedRevision				= "5";
		protected String																				annotation																		= "Generated by Effectopedia Version " + Effectopedia.VERSION;
		protected UserKey																			userKey;
		protected long																						dataSourceID																= 0;
		protected LinkedHashMap<Long, Long>	containedRevOfDataSourceIDs	= new LinkedHashMap<Long, Long>();
		protected long																						externalIDs																	= 1;
		protected long																						defaultIDs																		= -1;
		protected long																						stampIDsOffset														= Stamp.getStampIDs() <= EffectopediaObject.getDefaultIDs() ? 0 : Stamp.getStampIDs();
		protected Runnable																		publishing																		= null;
	}

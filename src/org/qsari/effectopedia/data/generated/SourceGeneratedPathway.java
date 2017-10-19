package org.qsari.effectopedia.data.generated;

import java.lang.reflect.Field;
import java.util.Iterator;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.objects.Effect;
import org.qsari.effectopedia.core.objects.Effect_MolecularInitiatingEvent;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.MemoryDS;
import org.qsari.effectopedia.data.RevisionBasedDS;
import org.qsari.effectopedia.data.formats.DataSourceFormat;
import org.qsari.effectopedia.data.formats.SupportedDataSourceFormats;
import org.qsari.effectopedia.defaults.DefaultServerSettings;
import org.qsari.effectopedia.search.SearchIndices;
import org.qsari.effectopedia.search.SearchResult;
import org.qsari.effectopedia.search.SearchResults;
import org.qsari.effectopedia.search.SimpleSearchQuery;
import org.qsari.effectopedia.system.User;

public class SourceGeneratedPathway
	{
		protected boolean autoSave = true;
		
		public SourceGeneratedPathway(DataSource dataSource)
			{
				this.dataSource = dataSource;
				dataSourceID = dataSource.getDataSourceID();
				prepareDataSource();
			}
			
		public SourceGeneratedPathway(String title, String keywords, DataSource dataSource, String fileName)
			{
				this.dataSource = dataSource;
				this.dataSourceID = dataSource.getDataSourceID();
				this.fileName = fileName;
				this.autoSave = true;
				this.dataSource.getEditHistory().startNewRevision();
				pathway = new Pathway(null, this.dataSource);
				pathway.bringToLive();
				if ((title != null) && (title.length() > 0))
					pathway.setTitle(title);
				if ((keywords != null) && (keywords.length() > 0))
					pathway.setKeyWords(keywords);
				generateContent();
			}
			
		public SourceGeneratedPathway(String title, String keywords, DataSource dataSource, String fileName, boolean autoSave)
			{
				this.dataSource = dataSource;
				this.dataSourceID = dataSource.getDataSourceID();
				this.fileName = fileName;
				this.autoSave = autoSave;
				this.dataSource.getEditHistory().startNewRevision();
				pathway = new Pathway(null, this.dataSource);
				pathway.bringToLive();
				if ((title != null) && (title.length() > 0))
					pathway.setTitle(title);
				if ((keywords != null) && (keywords.length() > 0))
					pathway.setKeyWords(keywords);
				generateContent();
			}
			
		public void generateContent()
			{
				storeRevision();
			}
			
		public void prepareDataSource()
			{
				if (dataSource instanceof MemoryDS)
					{
						DataSourceFormat defaultFormat = SupportedDataSourceFormats.FORMATS.getFormatByFormatFlavour(DefaultServerSettings.defaultFormatFlavour);
						if (defaultFormat == null)
							return;
						RevisionBasedDS xmlData = defaultFormat.createDataSource();
						xmlData.setDataSourceID(dataSource.getDataSourceID());
						xmlData.addAll(dataSource);
						xmlData.setCreateLive(true);
						xmlData.getLiveIndices().updateDataSource(xmlData, false);
						xmlData.getArchiveIndices().updateDataSource(xmlData, false);
						xmlData.clearExternalIds();
						this.dataSource = xmlData;
						this.dataSource.getEditHistory().startNewRevision();
					}
			}
			
		public void storeRevision()
			{
				if (!autoSave)
					return;
				revisionNo++;
				Effectopedia.EFFECTOPEDIA.setCurrentUser(User.IQF);
				if (dataSource instanceof RevisionBasedDS)
					((RevisionBasedDS) dataSource).setLocation(pathway);
				dataSource = Effectopedia.EFFECTOPEDIA.saveAsXMLFile(fileName + revisionNo + ".aopz", true);
				dataSource.waitUntilPublished();
			}
			
		public static Effect searchEffectByTitle(DataSource dataSource, String title)
			{
				SimpleSearchQuery query = new SimpleSearchQuery("", SearchIndices.TITLE_INDEX);
				query.setSearchPhrase(title);
				dataSource.getSearchEngine().doSearch(query);
				SearchResults results = dataSource.getSearchEngine().getResults();
				if (results.count() == 1)
					{
						IndexedObject result = results.getItems().first().getSearchableItem().getObject();
						if (result instanceof Effect)
							return (Effect) result;
					}
				else
					{
						Iterator<SearchResult> it = results.getItems().iterator();
						while (it.hasNext())
							{
								SearchResult searchResult = it.next();
								IndexedObject result = searchResult.getSearchableItem().getObject();
								if (result instanceof Effect)
									return (Effect) result;
							}
					}
				return null;
			}
			
		public static Effect_MolecularInitiatingEvent getOrCreate(Pathway pathway, DataSource dataSource, String title)
			{
				Effect mie = searchEffectByTitle(dataSource, title);
				if ((mie != null) && (mie instanceof Effect_MolecularInitiatingEvent))
					{
						pathway.add(mie);
						return (Effect_MolecularInitiatingEvent) mie;
					}
				else
					{
						mie = new Effect_MolecularInitiatingEvent(pathway, dataSource);
						mie.setTitle(title);
						return (Effect_MolecularInitiatingEvent) mie;
					}
			}
			
		public void updateVariables()
			{
				Class<?> cls = this.getClass();
				Field fieldlist[] = cls.getDeclaredFields();
				for (Field field : fieldlist)
					{
						if (EffectopediaObject.class.isAssignableFrom(field.getType()))
							try
								{
									EffectopediaObject eo = ((EffectopediaObject) field.get(this));
									if (eo == null)
										continue;
									DataSource objectDS = eo.getDataSource();
									if (objectDS != this.dataSource)
										{
											EffectopediaObject newEO = this.dataSource.get(eo.getObjectIdentity());
											field.set(this, newEO);
										}
								}
							catch (IllegalArgumentException e)
								{
									e.printStackTrace();
								}
							catch (IllegalAccessException e)
								{
									e.printStackTrace();
								}
					}
			}
			
		protected String					fileName;
		protected String					keywords;
		protected long							dataSourceID;
		private long									revisionNo	= 0;
		protected DataSource	dataSource;
		protected Pathway				pathway;
	}

package org.qsari.effectopedia.search;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.core.objects.DocumentedKnowledge;
import org.qsari.effectopedia.core.objects.Initiator;
import org.qsari.effectopedia.core.objects.Pathway;
import org.qsari.effectopedia.core.objects.PathwayElement;
import org.qsari.effectopedia.core.ui.RedirectionObject;
import org.qsari.effectopedia.core.ui.nav.UILocation;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.HistoricalDS;

public class SearchResult implements Comparable<SearchResult>
	{
		public SearchResult(SearchableItem searchableItem)
			{
				this.searchableItem = searchableItem;
			}
		
		private static int getRank(IndexedObject io)
			{
				return (int)io.getID();
			}
		
		public int compareTo(SearchResult searchResult)
			{
				int rank = getRank(this.searchableItem.object) - getRank(searchResult.searchableItem.object);
				if (rank != 0)
					return rank;
				else
					return this.hashCode() - searchResult.hashCode();
			}
		
		public RedirectionObject getRedirectionObject()
			{
				if (searchableItem == null)
					return null;
				StringBuilder html = new StringBuilder();
				html.append("<html>\n");
				html.append("<head>\n</head>\n\n<body text=\"#666666\" >\n");
				RedirectionObject ro = new RedirectionObject(searchableItem.object);
				if (searchableItem.object instanceof Pathway)
					{
						html.append("Pathway: ");
						html.append("<a href='http://www.effectopedia.org/intreface.php?viewUIL&help=search.result.pathway");
						if (dataSource instanceof HistoricalDS)
							html.append(UILocation.READONLY);
						html.append("' style='color:#6382BF'>");
						// html.append(searchableItem.object.getID());
						// html.append(" - ");
						html.append(((Pathway) searchableItem.object).getTitle());
						html.append("</a><br />");
						html.append("Key words: <em>");
						html.append(((Pathway) searchableItem.object).getKeyWords());
						html.append("</em><br />");
						html.append("Elements: <span style='color:#6382BF'>" + ((Pathway) searchableItem.object).getElementsDescription(300) + "</span><br />");
						html.append("Data source: <em>");
						html.append(((EffectopediaObject) searchableItem.object).getDataSource().getObjectURI(searchableItem.object));
						html.append("</em>");
					}
				else if (searchableItem.object instanceof DocumentedKnowledge)
					{
						html.append(searchableItem.object.getClass().getSimpleName());
						html.append(":");
						html.append("<a href='http://www.effectopedia.org/intreface.php?viewUIL&help=search.result.pathwayElement&par=");
						html.append(RedirectionObject.ITSELF);
						if (dataSource instanceof HistoricalDS)
							html.append(UILocation.READONLY);
						html.append("' style='color:#6382BF'>");
						// html.append(searchableItem.object.getID());
						// html.append(" - ");
						html.append(((DocumentedKnowledge) searchableItem.object).getTitle());
						html.append("</a><br />");
						html.append("Key words: <em>" + ((DocumentedKnowledge) searchableItem.object).getKeyWords() + "</em><br />");
						appendPathways((PathwayElement) searchableItem.object, ro, html);
						html.append("<br />Data source: <em>");
						html.append(((EffectopediaObject) searchableItem.object).getDataSource().getObjectURI(searchableItem.object));
						html.append("</em>");
					}
				else if (searchableItem.object instanceof Initiator)
					{
						html.append(searchableItem.object.getClass().getSimpleName());
						html.append(":");
						
						html.append("<a href='http://www.effectopedia.org/intreface.php?viewUIL&help=search.result.substance&par=");
						html.append(RedirectionObject.ITSELF);
						if (dataSource instanceof HistoricalDS)
							html.append(UILocation.READONLY);
						html.append("' style='color:#68BD6D'>");
						html.append(((Initiator) searchableItem.object).getTitle());
						html.append("</a><br />");
						appendPathways((PathwayElement) searchableItem.object, ro, html);
						html.append("<br />Data source: <em>");
						html.append(((EffectopediaObject) searchableItem.object).getDataSource().getObjectURI(searchableItem.object));
						html.append("</em>");
					}
				html.append("\n</body>\n</html>\n");
				ro.setHTML(html.toString());
				return ro;
			}
		
		private void appendPathways(PathwayElement pe, RedirectionObject ro, StringBuilder html)
			{
				html.append("<a href='http://www.effectopedia.org/intreface.php?viewUIL&help=search.result.pathways&par=");
				html.append(RedirectionObject.ALL);
				if (dataSource instanceof HistoricalDS)
					html.append(UILocation.READONLY);
				html.append("' style='color:#6382BF'>");
				html.append("Pathways");
				html.append("</a>: ");
				Pathway[] pathways = pe.getPathwayIDs().getCachedObjects();
				for (int i = 0; i < pathways.length; i++)
					{
						html.append("<a href='http://www.effectopedia.org/intreface.php?viewUIL&help=search.result.pathway&par=");
						html.append(ro.addParameterObject(pathways[i]));
						if (dataSource instanceof HistoricalDS)
							html.append(UILocation.READONLY);
						html.append("' style='color:#6382BF'>");
						html.append(pathways[i].getTitle());
						html.append("</a>");
						if (i != pathways.length - 1)
							html.append(", ");
					}
			}
		
		public SearchableItem getSearchableItem()
			{
				return searchableItem;
			}

		public DataSource getDataSource()
			{
				return dataSource;
			}

		public void setDataSource(DataSource dataSource)
			{
				this.dataSource = dataSource;
			}
		
		protected SearchableItem	searchableItem;
		protected DataSource					dataSource;
	}

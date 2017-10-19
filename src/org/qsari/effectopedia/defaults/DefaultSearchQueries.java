package org.qsari.effectopedia.defaults;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import org.qsari.effectopedia.data.objects.FixedValuesList;
import org.qsari.effectopedia.search.SimpleSearchQuery;

public class DefaultSearchQueries
	{
		public static ArrayList<SimpleSearchQuery> getQueries(String fixedListName)
			{
				ArrayList<SimpleSearchQuery> result = new ArrayList<SimpleSearchQuery>();
				FixedValuesList capt = (FixedValuesList) DefaultFixedListValues.INSTANCE.get(fixedListName + ".Captions");
				if (capt == null)
					return null;
				ArrayList<String> captions = capt.getList();
				FixedValuesList names = (FixedValuesList)DefaultFixedListValues.INSTANCE.get(fixedListName + ".SearchNames");
				if (names == null)
					return null;
				ArrayList<String> searchIndicesNames = names.getList();
				for (int i = 0; i < captions.size(); i++)
					result.add(new SimpleSearchQuery(captions.get(i), searchIndicesNames.get(i)));
				return result;
			}
		
		public static SimpleSearchQuery[] getArray(ArrayList<SimpleSearchQuery> queries)
			{
				if (queries == null)
					return null;
				SimpleSearchQuery[] result = new SimpleSearchQuery[queries.size()];
				result = queries.toArray(result);
				return result;
			}
		
		public static SimpleSearchQuery[] getArray(String fixedListName)
			{
				ArrayList<SimpleSearchQuery> queries = getQueries(fixedListName);
				if (queries == null)
					return null;
				SimpleSearchQuery[] result = new SimpleSearchQuery[queries.size()];
				result = queries.toArray(result);
				return result;
			}

		public static ArrayList<SimpleSearchQuery> getFromDefaultComboBoxModelQueries(DefaultComboBoxModel<SimpleSearchQuery> model)
			{
				ArrayList<SimpleSearchQuery> result = new ArrayList<SimpleSearchQuery>();
				int count = model.getSize();
				for (int i = 0; i < count; i++)
					result.add((SimpleSearchQuery) model.getElementAt(i));
				return result;
			}
		
	}

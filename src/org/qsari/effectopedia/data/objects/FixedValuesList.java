package org.qsari.effectopedia.data.objects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;

public class FixedValuesList extends ValuesList implements Importable, Exportable
	{
		public FixedValuesList()
			{
				super();
				list = new ArrayList<String>();
			}
		
		public FixedValuesList(String name, String commaSeparatedList)
			{
				super();
				this.name = name;
				list = new ArrayList<String>();
				setList(commaSeparatedList);
			}
		
		public void setList(String commaSeparatedList)
			{
				StringTokenizer listValues = new StringTokenizer(commaSeparatedList.trim(), DELIMITER);
				list.clear();
				list.ensureCapacity(listValues.countTokens());
				while (listValues.hasMoreTokens())
					list.add(listValues.nextToken().trim());
			}
		
		public String toString()
			{
				StringBuilder listValues = new StringBuilder();
				for (String value : this.list)
					{
						listValues.append(value);
						listValues.append(DELIMITER);
					}
				listValues.delete(listValues.length() - DELIMITER.length(), listValues.length());
				return listValues.toString();
			}

		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element,io);
						name = element.getValueElement("name").getValue();
						BaseIOElement e = element.getChild("values_list");
						if (e != null)
							setList(e.getValue());
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addValueElement(io.newValue("name").setValue(name));
				BaseIOElement e = io.newElement("values_list");
				e.setValue(toString());
				e.setAttribute("count", Integer.toString(list.size()));
				element.addChild(e);
				return element;
			}
		
		public ArrayList<String> getList()
			{
				return list;
			}
		
		public String[] getListArray()
			{
				String[] result = new String[list.size()];
				return list.toArray(result);
			}
		
		public String get(int index)
			{
				return list.get(index);
			}
		
		public Iterator<String> getIterator()
			{
				return list.iterator();
			}
		
		public int size()
			{
				return this.list.size();
			}
		
		public int indexOf(String value)
			{
				return this.list.indexOf(value);
			}
		
		protected ArrayList<String>	list;
	}

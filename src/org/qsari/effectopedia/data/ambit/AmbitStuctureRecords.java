package org.qsari.effectopedia.data.ambit;

import java.util.ArrayList;
import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;

public class AmbitStuctureRecords extends ArrayList<AmbitStructureRecord>
	{
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public void addEntriesFromJSON(JsonNode entries)
			{
				if ((entries != null) && (entries.isArray()))
					{
						Iterator<JsonNode> it = entries.elements();
						while (it.hasNext())
							{
								JsonNode entry = it.next();
								System.out.println(entry.textValue());
								AmbitStructureRecord structure = new AmbitStructureRecord(entry);
								add(structure);
							}
					}
			}
	}

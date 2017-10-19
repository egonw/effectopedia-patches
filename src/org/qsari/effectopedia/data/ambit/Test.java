package org.qsari.effectopedia.data.ambit;

import com.fasterxml.jackson.databind.JsonNode;

public class Test
	{
		
		public static void main(String[] args)
			{
				new Test();
			}
		
		public Test()
			{
				JsonNode root = AmbitServices.searchStructure("Caffeine");
				if (root != null)
					{
						AmbitStuctureRecords result = new AmbitStuctureRecords();
						result.addEntriesFromJSON(root.get("dataEntry"));
					}
			}
	}

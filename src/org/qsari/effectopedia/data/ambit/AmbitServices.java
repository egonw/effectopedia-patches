package org.qsari.effectopedia.data.ambit;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.qsari.effectopedia.defaults.DefaultServerSettings;

import com.fasterxml.jackson.databind.JsonNode;

public class AmbitServices extends DefaultServerSettings
	{
		public static final String	ambitOnline													= "https://apps.ideaconsult.net/data";
		public static final String	ambitAPIVersion									= "https://apps.ideaconsult.net/data/api-docs";
		public static final String	baseAmbitDataURL								= "https://apps.ideaconsult.net/data/";
		public static final String	chemStructureSearch					= baseAmbitDataURL + "query/compound/search/all?search=";
		public static final String	substanceSearch									= baseAmbitDataURL + "substance?search=";
		public static final String	defaultSearchParameters	= "&media=application/json";
		private static String						responce																= null;
		public static boolean						blocked																	= false;
		
		public static boolean isOnline()
			{
				try
					{
						URL url = new URL(ambitOnline);
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
		
		public static String getAmbitAPIVersion()
			{
				responce = getServiceResponse(ambitAPIVersion);
				try
					{
						Long.parseLong(responce);
						blocked = false;
					}
				catch (NumberFormatException nfe)
					{
						blocked = true;
						responce = "";
					}
				return responce;
			}
		
		public static JsonNode searchStructure(String term)
			{
				return search(chemStructureSearch, term, "");
			}
		
		public static JsonNode search(String what, String term, String parameters)
			{
				System.out.println(what + term + parameters);
				responce = getServiceResponse(what + term + parameters);
				try
					{
						System.out.println(responce);
						return AmbitJSON.mapper.readValue(responce, JsonNode.class);
					}
				catch (IOException e)
					{
						e.printStackTrace();
						return null;
					}
			}
	}

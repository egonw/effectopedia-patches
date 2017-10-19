package org.qsari.effectopedia.data.ambit;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

public class AmbitJSON
	{
		protected static JsonNodeFactory	factory;
		protected static JsonFactory					jsonFactory;
		protected static JsonGenerator			generator;
		protected static ObjectMapper				mapper;
		protected JsonNode															root;
		
		public AmbitJSON()
			{
				factory = new JsonNodeFactory(false);
				jsonFactory = new JsonFactory();
				try
					{
						generator = jsonFactory.createGenerator(System.out);
						mapper = new ObjectMapper();
						root = factory.objectNode();
					}
				catch (IOException e)
					{
						e.printStackTrace();
					}
			}


		public static final double	VERSION_NUMBER					= 0.1;
		public static final String	VERSION												= String.valueOf(VERSION_NUMBER);
		protected double											ambitAPIVersionNumner	= VERSION_NUMBER;
	}

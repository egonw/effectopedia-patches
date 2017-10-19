package org.qsari.effectopedia.data.json;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOArray;
import org.qsari.effectopedia.base.io.BaseIOAttribute;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.BaseIOValue;
import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.data.FileDS;
import org.qsari.effectopedia.defaults.DefaultServerSettings;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

@JsonRootName(value = "effectopedia")
public class JSONFileDS extends FileDS implements BaseIO
	{
		protected static JsonNodeFactory	factory;
		// protected static JsonFactory jsonFactory;
		// protected static JsonGenerator generator;
		protected static ObjectMapper				mapper;
		protected ObjectNode													root;
		
		public JSONFileDS()
			{
				super();
				mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
				factory = mapper.getNodeFactory();
				dataFormat = JSONDataSourceFormat.JSONFormat_Jakson;
				// jsonFactory = new JsonFactory();
				// try
				// {
				// generator = jsonFactory.createGenerator(System.out);
				
				//
				// mapper.writeTree(generator, root);
				// }
				// catch (IOException e)
				// {
				// e.printStackTrace();
				// }
			}
		
		@Override
		public void save(String path, boolean saveLocally)
			{
				if (dataSourceID == 0)
					dataSourceID = DefaultServerSettings.getNewDataSourceID(fileName);
				
				root = mapper.createObjectNode();
				
				BaseIOElement effectopedia = new JSONObject(root);
				if (dataSourceID != 0)
					effectopedia.setAttribute("id", Long.toString(dataSourceID));
				
				saveAllToRoot(effectopedia, this);
				setBrowsing(true);
				
				this.fileName = path;
				this.sourceName = path;
				this.sourcePrefix = saveLocally ? "local file: " : "";
				publishing  = new Publish(root, fileName, saveLocally);
				new Thread(publishing).start();
			}
		
		public class Publish implements Runnable
			{
				public Publish(ObjectNode root, String fileName, boolean saveAsLocalFile)
					{
						this.root = root;
						this.fileName = fileName;
						this.saveAsLocalFile = saveAsLocalFile;
					}
				
				public void run()
					{
						if (writeToFile(root, fileName, saveAsLocalFile))
							{
								if (!saveAsLocalFile)
									{
										UserInterface.showFeedback("Your changes were successfully published!", "Acknowledgment");
										DefaultServerSettings.commitRevision(String.valueOf(Effectopedia.EFFECTOPEDIA.getRevision()), Effectopedia.EFFECTOPEDIA.getCurrentUserID());
									}
							}
						else
							UserInterface
									.showError("There was an error while trying to publish your changes! \n Check your firewall settings and make sure that Effectopedia application can initiate active FTP transactions");
					}
				
				private ObjectNode	root;
				private String					fileName;
				private boolean				saveAsLocalFile;
			}
		
		public boolean writeToFile(ObjectNode doc, String fileName, boolean saveAsLocalFile)
			{
				if (saveAsLocalFile)
					{
						FileOutputStream fileStream;
						try
							{
								fileStream = new FileOutputStream(fileName);
								BufferedOutputStream outputStream = new BufferedOutputStream(fileStream);
								mapper.writeValue(outputStream, root);
								return true;
							}
						catch (FileNotFoundException e)
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						catch (IOException e)
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
				return false;
			}
		
		@Override
		public boolean load(String path)
			{
				// TODO Auto-generated method stub
				return false;
			}
		
		@Override
		public BaseIOAttribute newAttribute(String name)
			{
				return new JSONValue(name);
			}
		
		@Override
		public BaseIOValue newValue(String name)
			{
				return new JSONValue(name);
			}
		
		@Override
		public BaseIOElement newElement(String name)
			{
				return new JSONObject(name);
			}
		
		@Override
		public BaseIOArray newArray(String name, int count)
			{
				return new JSONArray(name);
			}
		
		@Override
		public <E extends EffectopediaObject> E load(Class<?> cl, E effectopediaObejct, BaseIOElement element)
			{
				return load(cl, effectopediaObejct, element, this);
			}
		
		@Override
		public double getFormatVersion()
			{
				return VERSION_NUMBER;
			}
		
		@Override
		public double getInputVersion()
			{
				return inputVersionNumner;
			}

		@Override
		public DataPattern getDataPattern()
			{
				return BaseIO.DataPattern.RUSSIAN_DOLL;
			}

		public static final double	VERSION_NUMBER					= 0.1;
		public static final String	VERSION												= String.valueOf(VERSION_NUMBER);
		protected double											inputVersionNumner	= VERSION_NUMBER;
		
	}

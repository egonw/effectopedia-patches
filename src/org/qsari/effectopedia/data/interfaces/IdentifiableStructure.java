package org.qsari.effectopedia.data.interfaces;

import org.qsari.effectopedia.data.objects.ObjectProperties;
import org.qsari.effectopedia.data.objects.ObjectProperty;

public interface IdentifiableStructure extends IdentifiableEffectopediaObject
	{
		public ObjectProperties getIdentification();
		
		public void setIdentification(ObjectProperties identification);
		
		public ObjectProperties getProperties();
		
		public void setProperties(ObjectProperties properties);
		
		public ObjectProperty getStructure2DImage();
		
		public void setStructure2DImage(ObjectProperty structure2dImage);
		
		public ObjectProperty getSynonyms();
		
		public void setSynonyms(ObjectProperty synonyms);
		
		public String getStructureName();
		
		public void setStructureName(String Name);
	}

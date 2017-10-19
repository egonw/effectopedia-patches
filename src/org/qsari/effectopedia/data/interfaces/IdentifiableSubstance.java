package org.qsari.effectopedia.data.interfaces;

import org.qsari.effectopedia.base.ids.IDs;
import org.qsari.effectopedia.core.objects.Constituent;
import org.qsari.effectopedia.data.objects.ObjectProperties;

public interface IdentifiableSubstance extends IdentifiableEffectopediaObject
	{
		public ObjectProperties getIdentification();
		
		public void setIdentification(ObjectProperties identification);
		
		public ObjectProperties getProperties();
		
		public void setProperties(ObjectProperties properties);
		
		public IDs<Constituent> getComposition(); //temporary implementation  
	}

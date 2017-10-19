package org.qsari.effectopedia.data.objects;

import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.defaults.DefaultTextProperties;

public class KeyWord extends IndexedObject implements Importable, Exportable, Cloneable
	{
		public KeyWord(boolean autoSetID)
			{
				super();
				if (autoSetID)
				 autoSetId();
			}

		public KeyWord(String phrase)
			{
				super();
				autoSetId();
				this.phrase = phrase;
			}
		
		public long autoId()
			{
				return keyWordIDs++;
			}

		public void setPhrase(String phrase)
			{
				if (((phrase == null) && (this.phrase != null)) || (!phrase.equals(this.phrase)))
					{
						this.phrase = phrase;
					}
			}
		
		public String getPhrase()
			{
				if (this.phrase == null)
					return DefaultTextProperties.INSTANCE.getDefault("KeyWord.phrase");
				else
					return this.phrase;
			}
		
		public void cloneFieldsTo(KeyWord clone)
			{
				super.cloneFieldsTo(clone);
				clone.phrase = this.phrase;
			}
		
		public KeyWord clone()
			{
				KeyWord clone = new KeyWord(this.phrase);
				cloneFieldsTo(clone);
				return clone;
			}
		
		public String toString()
			{
				return getPhrase();
			}

		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element,io);
						phrase = element.getValueElement("phrase").getValue();
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addValueElement(io.newValue("phrase").setValue(phrase));
				return element;
			}
		
		protected String	phrase;
		protected static long keyWordIDs=0;
  
	}

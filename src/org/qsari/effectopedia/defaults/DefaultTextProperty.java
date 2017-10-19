/*
 * 
 */

package org.qsari.effectopedia.defaults;

import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;

public class DefaultTextProperty extends IndexedObject implements Importable, Exportable, Cloneable
	{
		
		public DefaultTextProperty()
			{
				super();
			}
		
		public DefaultTextProperty(String name, String text)
			{
				super();
				this.name = name;
				this.text = text;
			}
		
		public void setText(String text)
			{
				if (((text == null) && (this.text != null)) || (!text.equals(this.text)))
					{
						this.text = text;
					}
			}
		
		public String getText()
			{
				if (this.text == null)
					return " ";
				else
					return this.text;
			}
		
		public void cloneFieldsTo(DefaultTextProperty clone)
			{
				super.cloneFieldsTo(clone);
				clone.text = this.text;
			}
		
		public DefaultTextProperty clone()
			{
				DefaultTextProperty clone = new DefaultTextProperty();
				cloneFieldsTo(clone);
				return clone;
			}

		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						name = element.getValueElement("name").getValue();
						text = element.getValueElement("text").getValue();
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addValueElement(io.newValue("name").setValue(name));
				element.addValueElement(io.newValue("text").setValue(text));
				return element;
			}
		
		protected String	name;
		protected String	text;
	}

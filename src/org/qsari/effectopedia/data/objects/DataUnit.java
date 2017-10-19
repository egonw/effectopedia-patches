/*
 * 
 */

package org.qsari.effectopedia.data.objects;

import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.interfaces.IdentifiableDataUnit;
import org.qsari.effectopedia.defaults.DefaultTextProperties;

public class DataUnit extends IndexedObject implements Importable, Exportable, Cloneable, IdentifiableDataUnit
	{
		public DataUnit()
			{
				super();
			}

		public DataUnit(String caption)
			{
				super();
				this.caption = caption;
			}
		
		public void setCaption(String caption)
			{
				if (((caption == null) && (this.caption != null)) || (!caption.equals(this.caption)))
					{
						this.caption = caption;
					}
			}
		
		public String getCaption()
			{
				if (this.caption == null)
					return DefaultTextProperties.INSTANCE.getDefault("DataUnit.caption");
				else
					return this.caption;
			}
		
		public void cloneFieldsTo(DataUnit clone)
			{
				super.cloneFieldsTo(clone);
				clone.caption = this.caption;
			}
		
		public DataUnit clone()
			{
				DataUnit clone = new DataUnit();
				cloneFieldsTo(clone);
				return clone;
			}
		
		public String toString()
			{
				return getCaption();
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element,io);
						caption = element.getChildValue("caption");
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addValueElement((io.newValue("caption").setValue(caption)));
				return element;
			}

		protected String	caption;
	}

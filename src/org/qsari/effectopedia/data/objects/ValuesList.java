package org.qsari.effectopedia.data.objects;

import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;

public abstract class ValuesList extends IndexedObject implements Importable, Exportable
	{
		public ValuesList()
			{
				super();
			}
		
		public ValuesList(String name)
			{
				super();
				this.name = name;
			}
		
		public String getName()
			{
				return name;
			}
		
		public void setName(String name)
			{
				this.name = name;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element,io);
						name = element.getValueElement("name").getValue();
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addValueElement(io.newValue("name").setValue(name));
				return element;
			}
		
		protected String											name;
		public static final String	DELIMITER	= ",";
		
	}

package org.qsari.effectopedia.history;

import org.qsari.effectopedia.base.ObjectIdentity;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;

public class EditHistoryItem_Property extends ObjectIdentity implements Importable, Exportable
	{
		
		public EditHistoryItem_Property()
			{
				super();
			}
		
		public EditHistoryItem_Property(long id, long classID, String property)
			{
				super(id,classID);
				this.property = property;
			}

		public String getProperty()
			{
				return property;
			}
		
		public void setProperty(String property)
			{
				this.property = property;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						property = element.getValueElement("value").getValue();
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addValueElement(io.newValue("value").setValue(property));
				element.setAttribute("type","property");
				return element;
			}

		protected String	property;
	}

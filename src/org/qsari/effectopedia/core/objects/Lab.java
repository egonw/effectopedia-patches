package org.qsari.effectopedia.core.objects;

import java.util.StringTokenizer;

import org.qsari.effectopedia.base.EffectopediaObject;
import org.qsari.effectopedia.base.Traceable;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.DataSource;
import org.qsari.effectopedia.data.objects.DataValue_String;
import org.qsari.effectopedia.defaults.DefaultTextProperties;
import org.qsari.effectopedia.search.SearchIndices;
import org.qsari.effectopedia.search.SearchableItem;
import org.qsari.effectopedia.system.ActionTypes;
import org.qsari.effectopedia.system.TraceableProperties;

public class Lab extends EffectopediaObject implements Importable, Exportable, Cloneable, Traceable
	{
		public Lab()
			{
				super();
				SearchableItem sa = new SearchableItem(this, LAB_NAME_PID, SearchIndices.TITLE_INDEX);
				this.name = new DataValue_String(sa);
			}
		
		public Lab(EffectopediaObject parent, DataSource dataSource)
			{
				super(parent, dataSource);
				SearchableItem sa = new SearchableItem(this, LAB_NAME_PID, SearchIndices.TITLE_INDEX);
				this.name = new DataValue_String(sa);
			}
		
		@Override
				public void assignFieldsTo(EffectopediaObject eoDestintation, boolean assignContainedEO)
			{
				super.assignFieldsTo(eoDestintation, assignContainedEO);
				if (eoDestintation instanceof Lab)
					{
						((Lab) eoDestintation).setName(this.name.getValue());
						((Lab) eoDestintation).address = this.address;
						((Lab) eoDestintation).country = this.country;
						((Lab) eoDestintation).contact = this.contact;
						((Lab) eoDestintation).telephone = this.telephone;
						((Lab) eoDestintation).e_mail = this.e_mail;
						((Lab) eoDestintation).website = this.website;
					}
			}
		
		public void cloneFieldsTo(Lab clone, DataSource dataSource)
			{
				super.cloneFieldsTo(clone, dataSource);
				clone.name = this.name.clone(clone);
				clone.address = this.address;
				clone.country = this.country;
				clone.contact = this.contact;
				clone.telephone = this.telephone;
				clone.e_mail = this.e_mail;
				clone.website = this.website;
			}
		
		public Lab clone()
			{
				Lab clone = new Lab(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public Lab clone(EffectopediaObject parent, DataSource dataSource)
			{
				Lab clone = new Lab(parent, dataSource);
				cloneFieldsTo(clone, dataSource);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element, io);
						this.name.parseString(element.getChildValue("name"));
						this.address = element.getChildValue("address");
						this.country = element.getChildValue("country");
						this.contact = element.getChildValue("contact");
						this.telephone = element.getChildValue("telephone");
						this.e_mail = element.getChildValue("e_mail");
						this.website = element.getChildValue("website");
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addValueElement((io.newValue("name").setValue(this.name.getValue())));
				element.addValueElement((io.newValue("address").setValue(this.address)));
				element.addValueElement((io.newValue("country").setValue(this.country)));
				element.addValueElement((io.newValue("contact").setValue(this.contact)));
				element.addValueElement((io.newValue("telephone").setValue(this.telephone)));
				element.addValueElement((io.newValue("e_mail").setValue(this.e_mail)));
				element.addValueElement((io.newValue("website").setValue(this.website)));
				return element;
			}
		
		public String getName()
			{
				String labName = null;
				if (name != null)
					labName = name.toString();
				if ((labName == null) || (labName == ""))
					return DefaultTextProperties.INSTANCE.getDefault(getClass().getSimpleName() + ".name");
				else
					return labName;
			}
		
		public void setName(String name)
			{
				if (((name == null) && (this.name.getValue() != null)) || (name != null && !name.equals(this.name.getValue())))
					{
						beforeUpdate(true, ActionTypes.LAB_NAME_AID);
						this.name.parseString(name);
					}
			}
		
		public String getAddress()
			{
				return address;
			}
		
		public void setAddress(String address)
			{
				this.address = address;
			}
		
		public String getCountry()
			{
				return country;
			}
		
		public void setCountry(String country)
			{
				this.country = country;
			}
		
		public String getContact()
			{
				return contact;
			}
		
		public void setContact(String contact)
			{
				this.contact = contact;
			}
		
		public String getTelephone()
			{
				return telephone;
			}
		
		public void setTelephone(String telephone)
			{
				this.telephone = telephone;
			}
		
		public String getE_mail()
			{
				return e_mail;
			}
		
		public void setE_mail(String e_mail)
			{
				this.e_mail = e_mail;
			}
		
		public String getWebsite()
			{
				return website;
			}
		
		public void setWebsite(String website)
			{
				this.website = website;
			}
		
		public Object getDelimitedDescription(String delimiter)
			{
				StringBuilder sb = new StringBuilder();
				sb.append(name);
				sb.append(delimiter);
				sb.append(address);
				sb.append(delimiter);
				sb.append(country);
				sb.append(delimiter);
				sb.append(contact);
				sb.append(delimiter);
				sb.append(telephone);
				sb.append(delimiter);
				sb.append(e_mail);
				sb.append(delimiter);
				sb.append(website);
				return sb.toString();
			}
		
		public void setFromDelimitedDescription(String description, String delimiter)
			{
				StringTokenizer st = new StringTokenizer(description, delimiter);
				if (st.hasMoreTokens())
					name.setValue(st.nextToken());
				if (st.hasMoreTokens())
					address = st.nextToken();
				if (st.hasMoreTokens())
					country = st.nextToken();
				if (st.hasMoreTokens())
					contact = st.nextToken();
				if (st.hasMoreTokens())
					telephone = st.nextToken();
				if (st.hasMoreTokens())
					e_mail = st.nextToken();
				if (st.hasMoreTokens())
					website = st.nextToken();
			}
		
		public String toString()
			{
				return getName();
			}
		
		public static final long			LAB_NAME_PID	= TraceableProperties.REGISTERED.add("name", "", Lab.class);
		protected DataValue_String	name;
		protected String											address;
		protected String											country;
		protected String											contact;
		protected String											telephone;
		protected String											e_mail;
		protected String											website;
	}

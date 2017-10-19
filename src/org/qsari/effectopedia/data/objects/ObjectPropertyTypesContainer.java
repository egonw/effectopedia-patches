package org.qsari.effectopedia.data.objects;

import java.util.Iterator;
import java.util.List;

import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.interfaces.IdentifiableDescriptorType;

public class ObjectPropertyTypesContainer extends TypesContainer<ObjectPropertyType> implements Importable, Exportable
	{
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public ObjectPropertyTypesContainer clone()
			{
				ObjectPropertyTypesContainer clone = new ObjectPropertyTypesContainer();
				for (ObjectPropertyType type : this)
					clone.add(type);
				return clone;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element == null)
					return;
				clear();
				int count = Integer.parseInt(element.getAttributeValue("count"));
				List<BaseIOElement> children = element.getChildren();
				if ((count != 0) && (children != null) && (children.size() == count))
					{
						Iterator<BaseIOElement> iterator = children.iterator();
						while (iterator.hasNext())
							{
								BaseIOElement objectPropertyType = iterator.next();
								ObjectPropertyType opt = null;
								opt = io.load(ObjectPropertyType.class, opt, objectPropertyType);
								add(opt);
							}
					}
			}
		
		@Override
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						element.setAttribute("count", String.valueOf(size()));
						for (IdentifiableDescriptorType opt : this)
							element.addChild(((ObjectPropertyType) opt).store(io.newElement("property_type"), io));
					}
				return element;
			}
		
		public ObjectPropertyType[] getAll()
			{
				return this.toArray(new ObjectPropertyType[size()]);
			}
		
		@Override
		public String toString()
			{
				StringBuilder sb = new StringBuilder();
				sb.append("Object properties");
				if (size() > 0)
					{
						sb.append(" (");
						sb.append(size());
						sb.append(")");
					}
				return sb.toString();
			}
		
	}

package org.qsari.effectopedia.data.objects;

import java.util.Iterator;
import java.util.List;

import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;
import org.qsari.effectopedia.data.interfaces.IdentifiableDescriptorType;

public class DescriptorTypesContainer extends TypesContainer<IdentifiableDescriptorType> implements Importable, Exportable

	{
		
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public DescriptorTypesContainer create(String[] names, String[] descriptions, Class<?> baseValueType, DataUnit defaultUnit)
			{
				uniqueCode = hash++;
				if ((names.length == 0) || ((descriptions != null) && (descriptions.length > 0) && (descriptions.length != names.length)))
					return null;
				clear();
				int cnt = names.length;
				for (int i = 0; i < cnt; i++)
					this.add(new DescriptorType(names[i], descriptions[i], baseValueType, defaultUnit));
				return this;
			}
		
		public DescriptorTypesContainer clone()
			{
				DescriptorTypesContainer clone = new DescriptorTypesContainer();
				for (IdentifiableDescriptorType type : this)
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
								BaseIOElement descriptor = iterator.next();
								DescriptorType dt = null;
								dt = io.load(DescriptorType.class, dt, descriptor);
								add(dt);
							}
					}
			}
		
		@Override
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						element.setAttribute("count", String.valueOf(size()));
						for (IdentifiableDescriptorType d : this)
							element.addChild(((DescriptorType) d).store(io.newElement("descriptor_type"), io));
					}
				return element;
			}
		
		public DescriptorType[] getAll()
			{
				return this.toArray(new DescriptorType[size()]);
			}
		
		public String toString()
			{
				StringBuilder sb = new StringBuilder();
				sb.append("Descriptors");
				if (size() > 0)
					{
						sb.append(" (");
						sb.append(size());
						sb.append(")");
					}
				return sb.toString();
			}
		
		@Override
		public int hashCode()
			{
				return uniqueCode;
			}
		
		private int							uniqueCode;
		public static int	hash	= 1;
	}

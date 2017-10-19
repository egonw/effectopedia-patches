package org.qsari.effectopedia.system;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.qsari.effectopedia.base.IndexedObject;
import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;

public class Source extends IndexedObject implements Importable, Exportable
	{
		enum SourceFlags
			{
				LOCAL, REMOTE, PUBLIC, PRIVATE, XML, DB, MEMORY
			}
		
		public Source()
			{
				super();
				autoSetId();
				this.description = "Local compuer memory";
				this.resource = "";
				this.flags = EnumSet.of(SourceFlags.LOCAL, SourceFlags.PUBLIC, SourceFlags.MEMORY);
			}
		
		public static long getSourceIDs()
			{
				return sourceIDs;
			}
		
		public static void setSourceIDs(long sourceIDs)
			{
				Source.sourceIDs = sourceIDs;
			}
		
		public String getDescription()
			{
				return description;
			}
		
		public void setDescription(String description)
			{
				this.description = description;
			}
		
		public String getResource()
			{
				return resource;
			}
		
		public void setResource(String resource)
			{
				this.resource = resource;
			}
		
		public EnumSet<SourceFlags> getFlags()
			{
				return flags;
			}
		
		public void setFlags(EnumSet<SourceFlags> flags)
			{
				this.flags = flags;
			}
		
		public long autoId()
			{
				return sourceIDs++;
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						super.load(element,io);
						description = element.getChildValue("description");
						resource = element.getChildValue("resource");
						BaseIOElement f = element.getChild("flags");
						if (f != null)
							{
								StringTokenizer sources = new StringTokenizer(f.getValue(), " ");
								while (sources.hasMoreTokens())
									{
										String flag = sources.nextToken().trim().toUpperCase();
										flags.add(SourceFlags.valueOf(flag));
									}
							}
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				super.store(element, io);
				element.addValueElement(io.newValue("description").setValue(description));
				element.addValueElement(io.newValue("resource").setValue(resource));
				StringBuilder fl = new StringBuilder();
				Iterator<SourceFlags> iterator = flags.iterator();
				while (iterator.hasNext())
					{
						fl.append(iterator.next());
						if (iterator.hasNext())
							fl.append(" ");
					}
				element.addValueElement(io.newValue("flags").setValue(fl.toString()));
				return element;
			}
		
		protected static long										sourceIDs	= 0;
		protected String															description;
		protected String															resource;
		protected EnumSet<SourceFlags>	flags;
		
	}

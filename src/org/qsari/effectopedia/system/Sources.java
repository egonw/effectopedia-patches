package org.qsari.effectopedia.system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;

public class Sources extends ArrayList<Source> implements Importable, Exportable
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public long newSource()
			{
				Source s = new Source();
				return s.getID();
			}
		
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						BaseIOElement e = element.getChild("stamps");
						if (e != null)
							{
								int count = Integer.parseInt(e.getAttributeValue("count"));
								List<BaseIOElement> children = e.getChildren();
								if ((count != 0) && (children != null) && (children.size() == count))
									{
										Iterator<BaseIOElement> iterator = children.iterator();
										while (iterator.hasNext())
											{
												BaseIOElement child = iterator.next();
												Source s = new Source();
												s.load(child,io);
												add(s);
											}
									}
							}
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				int count = size();
				BaseIOElement e = io.newElement("stamps");
				e.setAttribute("count", Integer.toString(count));
				if (count != 0)
					{
						for (int i = 0; i < count; i++)
							{
								BaseIOElement s = io.newElement("Source");
								get(i).store(s, io);
								element.addChild(s);
							}
					}
				element.addChild(e);
				return element;
			}
		
	}

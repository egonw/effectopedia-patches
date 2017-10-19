package org.qsari.effectopedia.history;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;

public class Stamps extends ArrayList<Stamp> implements Importable, Exportable
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public long newStamp(long actionId, long userId, long teamId)
			{
				Stamp s = new Stamp(actionId, userId, teamId);
				add(s);
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
												Stamp s = new Stamp();
												s.load(child, io);
												// System.out.println("add stamp:\t"+s.getID()+"\tsize\t"+size());
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
								BaseIOElement s = io.newElement("stamp");
								get(i).store(s, io);
								e.addChild(s);
							}
					}
				element.addChild(e);
				return element;
			}
		
		public void setDate(Date date)
			{
				for (Stamp s : this)
					s.setDate(date);
			}
		
	}

package org.qsari.effectopedia.data.objects;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;

public class KeyWords extends HashMap<Long,KeyWord> implements Importable, Exportable
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		public void load(BaseIOElement element, BaseIO io)
			{
				if (element != null)
					{
						BaseIOElement e = element.getChild("KeyWords");
						if (e != null)
							{
								int count = Integer.parseInt(e.getAttributeValue("count"));
								List<BaseIOElement> children = e.getChildren();
								if ((count != 0) && (children != null) && (children.size() == count))
									{
										clear();
										Iterator<BaseIOElement> iterator = children.iterator();
										while (iterator.hasNext())
											{
												BaseIOElement child = iterator.next();
												KeyWord kw = new KeyWord(false);
												kw.load(child,io);
												put(kw.getID(),kw);
											}
									}
							}
					}
			}
		
		public BaseIOElement store(BaseIOElement element, BaseIO io)
			{
				int count = size();
				BaseIOElement e = io.newElement("KeyWords");
				e.setAttribute("count", Integer.toString(count));
				if (count != 0)
					{
						Iterator<Map.Entry<Long, KeyWord>> it = entrySet().iterator();
						while (it.hasNext())
							{
								BaseIOElement s = io.newElement("KeyWord");
								it.next().getValue().store(s, io);
								element.addChild(s);
							}
					}
				element.addChild(e);
				return element;
			}
		
	}

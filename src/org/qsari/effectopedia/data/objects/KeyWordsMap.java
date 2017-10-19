package org.qsari.effectopedia.data.objects;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;

public class KeyWordsMap extends HashMap<String, KeyWord> implements Exportable 
	{
		/**
	 * 
	 */
		private static final long																		serialVersionUID	= 1L;
		
		public KeyWordsMap()
			{
			}
	
		public void addNewKeyWord(String phrase)
			{
				KeyWord kw = new KeyWord(phrase);
				put(kw.getPhrase(),kw);
			}
		
		public void addSynonym(String phrase,KeyWord toKeyWord)
			{
				put(phrase,toKeyWord);
			}

		public void load(HashMap<Long,KeyWord> processed,BaseIOElement element, BaseIO io)
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
												KeyWord storedKeyWord = processed.get(kw.getExternalID()); 
												if (storedKeyWord!=null)
													put(kw.getPhrase(), storedKeyWord);
												else
													{
														kw.autoSetId();
														put(kw.getPhrase(),kw);
													}
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
						Iterator<Map.Entry<String, KeyWord>> it = entrySet().iterator();
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

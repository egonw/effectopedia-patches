package org.qsari.effectopedia.data.objects;

import java.util.ArrayList;
import java.util.StringTokenizer;

import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOArray;
import org.qsari.effectopedia.base.io.BaseIOElement;
import org.qsari.effectopedia.base.io.Exportable;
import org.qsari.effectopedia.base.io.Importable;

public class KeyWordIDs extends ArrayList<Long> implements Importable, Exportable
	{

		/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	public void load(BaseIOElement element, BaseIO io)
		{
			if (element != null)
				{
					BaseIOArray e = element.getArray("key_word_ids");
					if (e != null)
						{
							int count = e.getCount();
							if (count != 0)
								{
									clear();
									ensureCapacity(count);
									StringTokenizer idsArray = new StringTokenizer(e.getValue(), " ");
									int i = 0;
									while (idsArray.hasMoreTokens())
										{
											set(i++, Long.parseLong(idsArray.nextToken().trim()));
										}
								}
						}
				}
		}
	
	public BaseIOElement store(BaseIOElement element, BaseIO io)
		{
			int count = size();
			BaseIOArray e = io.newArray("key_word_ids",count);
			if (count != 0)
				{
					StringBuilder idsArray = new StringBuilder();
					for (int i = 0; i < count; i++)
						{
							idsArray.append(get(i));
							idsArray.append(' ');
						}
					e.setValue(idsArray.toString());
				}
			element.addChild(e);
			return element;
		}

		
	}

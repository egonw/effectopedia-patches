package org.qsari.effectopedia.core.ui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.base.io.BaseIOElement;

public class DataViews extends HashMap<String,IDataView> implements IDataViews
	{
		/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	public void load(BaseIOElement element, BaseIO io)
		{
			if (element != null)
				{
					BaseIOElement e = element.getChild("data_views");
					if (e != null)
						{
							int count = Integer.parseInt(e.getAttributeValue("count"));
							List<BaseIOElement> children = e.getChildren();
							if ((count != 0) && (children != null) && (children.size() == count))
								{
									Iterator<BaseIOElement> iterator = children.iterator();
									clear();
									while (iterator.hasNext())
										{
											BaseIOElement child = iterator.next();
											IDataView dv = UserInterface.getDefaultUIFactory().createDataView();
											dv.load(child,io);
											put(dv.getName(),dv);
										}
								}
						}
				}
		}
	
	public BaseIOElement store(BaseIOElement element, BaseIO io)
		{
			int count = size();
			BaseIOElement e = io.newElement("data_views");
			e.setAttribute("count", Integer.toString(count));
			if (count != 0)
				{
			  Iterator<Map.Entry<String, IDataView>> it = entrySet().iterator();
					while (it.hasNext())
						{
							BaseIOElement dv = io.newElement("DataView");
							it.next().getValue().store(dv, io);
							element.addChild(dv);
						}
				}
			element.addChild(e);
			return element;
		}
		
		public void setDefaultViewAxis()
			{
				for (Map.Entry<String, IDataView> e : entrySet())
					e.getValue().setDefaultViewAxis();
			}

		@SuppressWarnings("unchecked")
		@Override
		public void putAll(IDataViews views)
			{
				super.putAll((Map<? extends String, ? extends IDataView>) views);
			}

		
	}

package org.qsari.effectopedia.go;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom.Element;
import org.jdom.Namespace;
import org.qsari.effectopedia.base.XMLExportable;
import org.qsari.effectopedia.base.XMLImportable;

public class GOs extends HashMap<Long,GraphicObject> implements XMLImportable, XMLExportable
	{
		public void loadFromXMLElement(Element element, Namespace namespace)
			{
				if (element == null)
					return;
				Element e = element.getChild("items", namespace);
				if (e != null)
					{
						int count = Integer.parseInt(e.getAttributeValue("count", namespace));
						List children = e.getChildren();
						if ((count != 0) && (children != null) && (children.size() == count))
							{
								Iterator<Element> iterator = children.iterator();
								while (iterator.hasNext())
									{
										Element child = (Element) iterator.next();
										try
											{
												Class cl = Class.forName(child.getName());
												GraphicObject object = (GraphicObject) cl.newInstance();
												object.loadFromXMLElement(child, namespace);
											}
										catch (ClassNotFoundException cnfe)
											{
												cnfe.printStackTrace();
											}
										catch (InstantiationException ie)
											{
												ie.printStackTrace();
											}
										catch (IllegalAccessException iae)
											{
												iae.printStackTrace();
											}
									}
							}
					}
			}
		
		public Element storeToXMLElement(Element element, Namespace namespace, boolean visualAttributes)
			{
				Element e = new Element("items", namespace);
				e.setAttribute("count", Integer.toString(entrySet().size()), namespace);
				Iterator<Map.Entry<Long, GraphicObject>> iterator = entrySet().iterator();
				while (iterator.hasNext())
					{
						Map.Entry<Long, GraphicObject> entry = (Map.Entry<Long, GraphicObject>) iterator.next();
						GraphicObject o = (GraphicObject) entry.getValue();
						Element obj = new Element(o.getClass().getName(), namespace);
						o.storeToXMLElement(obj, namespace, visualAttributes);
						e.addContent(obj);
					}
				element.addContent(e);
				return element;
			}

	}

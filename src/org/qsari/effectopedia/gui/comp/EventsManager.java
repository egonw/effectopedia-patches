/**
 * @version 1.0 @(#)EventsManager.java 1.0
 * @author Hristo Aladjov
 * 
 */
package org.qsari.effectopedia.gui.comp;

import java.util.EventListener;
import java.util.HashMap;

import javax.swing.text.Document;

public class EventsManager extends HashMap<String, EventListener>
	{
		/**
	 * 
	 */
		private static final long	serialVersionUID	= 1L;
		
		public void unbondDocumntListener(Document d, String property)
			{
				GlobalDocumentListener listener = (GlobalDocumentListener) get(property);
				if (listener != null)
					d.removeDocumentListener(listener);
			}
		
		public void bondDocumntListener(Document d, Object o, String property)
			{
				GlobalDocumentListener listener =  new GlobalDocumentListener(o, property);
				put(property, listener);
				d.addDocumentListener(listener);
			}
	}

package org.qsari.effectopedia.gui.comp;

import java.lang.reflect.InvocationTargetException;
import java.util.EventObject;

import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class GlobalDocumentListener extends BasicDocumentListener
	{
		public GlobalDocumentListener(Object o, String fieldName)
			{
				super(o, fieldName);
			}
		
		@Override
		public void update(DocumentEvent documentEvent)
			{
				Document source = documentEvent.getDocument();
				int length = source.getLength();
				try
					{
						setter.invoke(o, length < 1 ? null : source.getText(0, length));
						GlobalUpdateTracker.GUT.fireObjectUpdated(new EventObject(source));
					}
				catch (IllegalArgumentException e)
					{
						e.printStackTrace();
					}
				catch (IllegalAccessException e)
					{
						e.printStackTrace();
					}
				catch (InvocationTargetException e)
					{
						e.printStackTrace();
					}
				catch (BadLocationException e)
					{
						e.printStackTrace();
					}
			}
		
	}

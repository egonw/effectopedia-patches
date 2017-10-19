package org.qsari.effectopedia.gui.comp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class BasicDocumentListener implements DocumentListener
	{
		
		public BasicDocumentListener(Object o, String fieldName)
			{
				this.o = o;
				try
					{
						setter = o.getClass().getMethod("set" + fieldName, String.class);
					}
				catch (SecurityException e)
					{
						e.printStackTrace();
					}
				catch (NoSuchMethodException e)
					{
						e.printStackTrace();
					}
			}
			
		public void changedUpdate(DocumentEvent documentEvent)
			{
				update(documentEvent);
			}
			
		public void insertUpdate(DocumentEvent documentEvent)
			{
				update(documentEvent);
			}
			
		public void removeUpdate(DocumentEvent documentEvent)
			{
				update(documentEvent);
			}
			
		public void update(DocumentEvent documentEvent)
			{
				Document source = documentEvent.getDocument();
				int length = source.getLength();
				try
					{
						setter.invoke(o, length < 1 ? null : source.getText(0, length));
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
			
		public Object getO()
			{
				return o;
			}
			
		protected Method	setter;
		protected Object	o;
	}

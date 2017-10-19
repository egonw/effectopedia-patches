package org.qsari.effectopedia.gui.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.EventListener;
import java.util.EventObject;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.EventListenerList;

public class TextAreaStream extends OutputStream
	{
		public TextAreaStream()
			{
				super();
				this.textArea = null;
				buffer = new StringBuilder();
				eventListeners = new EventListenerList();
			}
		
		public TextAreaStream(JTextArea textArea)
			{
				super();
				this.textArea = textArea;
				buffer = new StringBuilder();
			}
		
		private void updateTextArea(final String text)
			{
				if (textArea != null)
					SwingUtilities.invokeLater(new Runnable()
						{
							public void run()
								{
									if (buffer.length() > 0)
										{
											textArea.append(buffer.toString());
											buffer.setLength(0);
										}
									textArea.append(text);
								}
						});
				else
					buffer.append(text);
				fireDataViewChanged(this.evt);
			}
		
		@Override
		public void write(int b) throws IOException
			{
				updateTextArea(String.valueOf((char) b));
			}
		
		@Override
		public void write(byte[] b, int off, int len) throws IOException
			{
				updateTextArea(new String(b, off, len));
			}
		
		@Override
		public void write(byte[] b) throws IOException
			{
				write(b, 0, b.length);
			}
		
		public interface StreamChangeListener extends EventListener
			{
				public void streamChanged(EventObject evt);
			}
		
		public void addStreamChangeListener(StreamChangeListener listener)
			{
				eventListeners.add(StreamChangeListener.class, listener);
			}
		
		public void removeStreamChangeListener(StreamChangeListener listener)
			{
				eventListeners.remove(StreamChangeListener.class, listener);
			}
		
		protected void fireDataViewChanged(EventObject evt)
			{
				StreamChangeListener[] listeners = eventListeners.getListeners(StreamChangeListener.class);
				for (int i = 0; i < listeners.length; i++)
					listeners[i].streamChanged(evt);
			}
		
		public JTextArea getTextArea()
			{
				return textArea;
			}
		
		public void setTextArea(JTextArea textArea)
			{
				this.textArea = textArea;
			}
		
		public StringBuilder getBuffer()
			{
				return buffer;
			}
		
		public void reset()
			{
				buffer.setLength(0);
				if (textArea != null)
					this.textArea.setText("");
			}
		
		public String getContent()
			{
				if (textArea != null)
					return this.textArea.getText();
				else
					return buffer.toString();
			}
		
		protected EventObject							evt	= new EventObject(this);
		protected EventListenerList	eventListeners;
		private final StringBuilder	buffer;
		private JTextArea											textArea;
	}

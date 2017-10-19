package org.qsari.effectopedia.gui.util;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.io.IOException;
import java.net.URL;
import java.util.EventListener;
import java.util.EventObject;

import javax.imageio.ImageIO;
import javax.swing.event.EventListenerList;

public class StructureImage
	{
		
		public StructureImage(String url)
			{
				eventListeners = new EventListenerList();
				this.url = url;
				loadImage();
			}
		
		public void paint(Graphics2D g2, Rectangle r)
			{
				setBounds(r);
				Stroke currentPen = g2.getStroke();
				BasicStroke dottedPen = new BasicStroke(1.0F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0F, new float[]
					{ 2.0F, 2.0F }, 1.0F);
				g2.setStroke(dottedPen);
				if ((image == null) || (r.width < MINSIZE) || (r.height < MINSIZE))
					{
						g2.drawLine(r.x, r.y, r.x + r.width, r.y + r.height);
						g2.drawLine(r.x, r.y + r.height, r.x + r.width, r.y);
					}
				else if (resized)
					g2.drawImage(image, r.x + margin, r.y + margin, null);
				else
					{
						int w = r.width - (margin + margin);
						int h = r.height - (margin + margin);
						int iw = image.getWidth(null);
						int ih = image.getHeight(null);
						if (ih > h)
							{
								iw = (int) (iw * h / ((ih > 0) ? ih : 1));
								ih = h;
							}
						if (iw > w)
							{
								ih = (int) (ih * w / ((iw > 0) ? iw : 1));
								iw = w;
							}
						
						g2.drawImage(image, r.x + margin + ((w > iw) ? (w - iw) >> 1 : 0), r.y + margin + ((h > ih) ? (h - ih) >> 1 : 0), (int) iw, (int) ih, null);
					}
				g2.setStroke(currentPen);
			}
		
		public Rectangle getBounds()
			{
				return bounds;
			}
		
		public void setBounds(Rectangle bounds)
			{
				if (this.bounds == bounds)
					return;
				if (((this.bounds != null) && (bounds != null)) && (this.bounds.width == bounds.width) && (this.bounds.height == bounds.height))
					this.bounds = bounds;
				else
					{
						this.bounds = bounds;
						loadImage();
					}
			}
		
		public String replaceQueryParameter(String query, String parameter, String newValue)
			{
				if (query == null)
					return null;
				int pParameter = query.indexOf(parameter);
				if (pParameter != -1)
					{
						int pNext = query.indexOf("&", pParameter + 1);
						StringBuffer buffer = new StringBuffer();
						buffer.append(query.substring(0, pParameter + parameter.length()));
						buffer.append(newValue);
						buffer.append(query.substring((pNext != -1) ? pNext : query.length(), query.length()));
						return buffer.toString();
					}
				else
					{
						resized = false;
						return query;
					}
			}
		
		private String updateStructureURL(String url)
			{
				if ((url == null) || (bounds == null))
					return null;
				resized = true;
				int w = bounds.width - (margin + margin);
				int h = bounds.height - (margin + margin);
				url = replaceQueryParameter(url, "&w=", String.valueOf(w));
				url = replaceQueryParameter(url, "&h=", String.valueOf(h));
				return url;
			}
		
		public class LoadImage implements Runnable
			{
				public void run()
					{
						if (url == null)
							image = null;
						else
							{
								try
									{
										String updatedURL = updateStructureURL(url);
										if (updatedURL != null)
											{
												image = ImageIO.read(new URL(updatedURL));
												resized = (image.getWidth(null)<=bounds.width)&&(image.getHeight(null)<bounds.height);
												if (image != null)
													fireStructureImageChanged(new EventObject(image));
											}
										else
											image = null;
									}
								catch (IOException e)
									{
										System.out.println("Exception Handled!");
										e.printStackTrace(System.out);
										image = null;
									}
							}
					}
			}
		
		public interface StructureImageListener extends EventListener
			{
				public void imageLoaded(EventObject evt);
			}
		
		public void addStructureImageListener(StructureImageListener listener)
			{
				eventListeners.add(StructureImageListener.class, listener);
			}
		
		public void removeStructureImageListener(StructureImageListener listener)
			{
				eventListeners.remove(StructureImageListener.class, listener);
			}
		
		protected void fireStructureImageChanged(EventObject evt)
			{
				StructureImageListener[] listeners = eventListeners.getListeners(StructureImageListener.class);
				for (int i = 0; i < listeners.length; i++)
					listeners[i].imageLoaded(evt);
			}
		
		public void loadImage()
			{
				if (resized)
					(new Thread(new LoadImage())).start();
			}
		
		public void setMargin(int margin)
			{
				this.margin = margin;
				loadImage();
			}
		
		public int getMargin()
			{
				return margin;
			}
		
		public String getUrl()
			{
				return url;
			}
		
		public void setUrl(String url)
			{
				this.url = url;
				bounds = null;
				resized = true;
			}
		
		public Image getImage()
			{
				return image;
			}
		
		public boolean isResized()
			{
				return resized;
			}
		
		protected EventListenerList	eventListeners;
		private String														url;
		private Image															image			= null;
		private boolean													resized	= true;
		private Rectangle											bounds		= null;
		private int																	margin		= 2;
		public static final int					MINSIZE	= 20;
	}

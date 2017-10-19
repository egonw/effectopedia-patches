package org.qsari.effectopedia.gui.nav;

import java.awt.Cursor;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;

import javax.swing.JTextPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.FormSubmitEvent;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.core.ui.RedirectionObject;
import org.qsari.effectopedia.core.ui.UserInterface;
import org.qsari.effectopedia.core.ui.nav.UILocation;
import org.qsari.effectopedia.defaults.DefaultServerSettings;
import org.qsari.effectopedia.gui.help.ContextSensitiveHelpUI;

public class RedirectorTextPane implements HyperlinkListener
	{
		
		public RedirectorTextPane(JTextPane pane)
			{
				this.pane = pane;
				targets = new HashMap<String, UILocation>();
			}
		
		public void addTarget(String url, UILocation target)
			{
				targets.put(url, target);
			}
		
		public void removeTarget(String url)
			{
				targets.remove(url);
			}
		
		public void clearTargets()
			{
				targets.clear();
			}
		
		public void hyperlinkUpdate(HyperlinkEvent e)
			{
				if (e instanceof FormSubmitEvent)
					{
						String result;
						if (((FormSubmitEvent) e).getURL().toString().endsWith(DefaultServerSettings.upd_profileURL))
							result = Effectopedia.EFFECTOPEDIA.getAutentication().setProfile(((FormSubmitEvent) e).getURL(), ((FormSubmitEvent) e).getData());
						else
							result = Effectopedia.EFFECTOPEDIA.getAutentication().signIn(((FormSubmitEvent) e).getData());
						if (result != null)
							pane.setText(result);
						return;
					}
				HyperlinkEvent.EventType type = e.getEventType();
				URL url = e.getURL();
				if (type == HyperlinkEvent.EventType.ENTERED)
					{
						pane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						ContextSensitiveHelpUI.setCurrentID(UILocation.extractHelpID(url.getQuery()));
					}
				else if (type == HyperlinkEvent.EventType.EXITED)
					{
						pane.setCursor(Cursor.getDefaultCursor());
						ContextSensitiveHelpUI.setDefaultID();
					}
				else
					redirectTo(url);
			}
		
		private void redirectTo(URL url)
			{
				if (UILocation.isInterfaceLocation(url.toString()))
					{
						String interfaceLocation = UILocation.extractLocation(url.getQuery());
						String interfaceInitialization = UILocation.extractInitialization(url.getQuery());
						String objectParameter = UILocation.extractParameter(url.getQuery());
						UILocation target = targets.get(interfaceLocation);
						target.setReadOnly(url.getQuery());
						GUIInitialization[] initialization = GUIInitializations.MAP.get(interfaceInitialization);
						if (target != null)
							if (object instanceof RedirectionObject)
								UserInterface.getDefaultNavigator().navigate(target, ((RedirectionObject) object).getObject(objectParameter), initialization);
							else
								UserInterface.getDefaultNavigator().navigate(target, object, initialization);
					}
				else
					{
						try
							{
								if (url.toString().equals(DefaultServerSettings.signOutURL))
									Effectopedia.EFFECTOPEDIA.getAutentication().signOut();
								else if (DefaultServerSettings.isInternallyLoadedURL(url))
									pane.setPage(url);
								else
									openTheDefaultBrowser(url.toString());
							}
						catch (IOException e1)
							{
								e1.printStackTrace();
							}
					}
			}
		
		public static boolean openTheDefaultBrowser(String url)
			{
				boolean result = Desktop.isDesktopSupported();
				if (result)
					{
						Desktop desktop = Desktop.getDesktop();
						if (result = desktop.isSupported(Desktop.Action.BROWSE))
							{
								java.net.URI uri;
								try
									{
										uri = new java.net.URI(url);
										desktop.browse(uri);
									}
								catch (URISyntaxException e)
									{
										return false;
									}
								catch (IOException e)
									{
										return false;
									}
							}
					}
				return result;
			}
		
		public Object getObject()
			{
				return object;
			}
		
		public void setObject(Object object)
			{
				this.object = object;
			}
		
		private HashMap<String, UILocation>	targets;
		private Object																						object;
		private JTextPane																			pane;
	}

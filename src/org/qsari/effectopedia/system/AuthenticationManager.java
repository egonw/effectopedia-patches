package org.qsari.effectopedia.system;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.EventListener;
import java.util.EventObject;

import javax.swing.event.EventListenerList;

import org.qsari.effectopedia.core.Effectopedia;
import org.qsari.effectopedia.defaults.DefaultServerSettings;
import org.qsari.effectopedia.utils.HTTPCommunicator;

public class AuthenticationManager
	{
		public AuthenticationManager()
			{
				eventListeners = new EventListenerList();
				http = new HTTPCommunicator();
			}

		public String signIn(String formData)
			{
				HttpURLConnection connection = null;
				try
					{
						URL authURL = new URL(DefaultServerSettings.signInURL);
						connection = http.openConnection(authURL, true, true, "POST", formData, true);
						http.writeData(connection, formData);

						if (connection.getResponseCode() >= 400)
							{
								if (connection.getResponseCode() >= 500) {
									return ERROR_SIGN_IN_HTML;
								}
								return INVALID_SIGN_IN_CODE_HTML;
							}

						String result = http.readData(connection);
						http.saveCookies(connection);

						int profileStart = result.indexOf(PROFILE_BEGIN_WITH);
						int profileEnd = result.indexOf(PROFILE_END_WITH);
						user = new User(result.substring(profileStart + PROFILE_BEGIN_WITH.length(), profileEnd));
						fireUserSignedIn(new EventObject(user));
					}
				catch (Exception e)
					{
						e.printStackTrace();
						return ERROR_SIGN_IN_HTML;
					}
				finally
					{
						if (connection != null)
							{
								connection.disconnect();
							}
					}

				return null;
			}

		public String getProfile(URL actionURL)
			{
				String result = null;
				if (user != null)
					{
						HttpURLConnection connection;
						connection = http.openConnection(actionURL, true, false, "GET", null, true);
						result = http.readData(connection);
						connection.disconnect();
					}
				return result;
			}

		public String setProfile(URL actionURL, String formData)
			{
				HttpURLConnection connection = http.openConnection(actionURL, true, true, "POST", formData, true);
				http.writeData(connection, formData);
				http.readData(connection);
				connection.disconnect();
				return PROFILE_UPDATED_HTML;
			}

		public void signOut()
			{
				if (user != null)
					{
						http.clearCookies();
						fireUserSignedOut(new EventObject(user));
					}
			}

		public interface UserSignInListener extends EventListener
			{
				public void userSignedIn(EventObject evt);
			}

		public void addUserSignInListener(UserSignInListener listener)
			{
				eventListeners.add(UserSignInListener.class, listener);
			}

		public void removeUserSignInListener(UserSignInListener listener)
			{
				eventListeners.remove(UserSignInListener.class, listener);
			}

		protected void fireUserSignedIn(EventObject evt)
			{
				Effectopedia.EFFECTOPEDIA.setCurrentUser(user);
				UserSignInListener[] listeners = eventListeners.getListeners(UserSignInListener.class);
				for (int i = 0; i < listeners.length; i++)
					listeners[i].userSignedIn(evt);
			}

		public interface UserSignOutListener extends EventListener
			{
				public void userSignedOut(EventObject evt);
			}

		public void addUserSignOutListener(UserSignOutListener listener)
			{
				eventListeners.add(UserSignOutListener.class, listener);
			}

		public void removeUserSignOutListener(UserSignOutListener listener)
			{
				eventListeners.remove(UserSignOutListener.class, listener);
			}

		protected void fireUserSignedOut(EventObject evt)
			{
				UserSignOutListener[] listeners = eventListeners.getListeners(UserSignOutListener.class);
				for (int i = 0; i < listeners.length; i++)
					listeners[i].userSignedOut(evt);
			}

		private User user = null;
		private   HTTPCommunicator  http;
		protected EventListenerList eventListeners;
		public static final String PROFILE_UPDATED_HTML = "<center><strong>Your profile has been updated.</strong></center>";
		public static final String INVALID_SIGN_IN_CODE_HTML = "<center><strong><span color='red'>Invalid sign in code. Please try again.</span></strong></center>";
		public static final String ERROR_SIGN_IN_HTML        = "<center><strong><span color='red'>Error signing in. Please try again.</span></strong></center>";
		public static final String PROFILE_BEGIN_WITH        = "<!--profile";
		public static final String PROFILE_END_WITH          = "profile-->";
	}

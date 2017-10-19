package org.qsari.effectopedia.utils;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Trustify
	{
		public static void installTrustManager()
			{
				/*
				 * fix for Exception in thread "main" javax.net.ssl.SSLHandshakeException:
				 * sun.security.validator.ValidatorException: PKIX path building failed:
				 * sun.security.provider.certpath.SunCertPathBuilderException: unable to
				 * find valid certification path to requested target
				 */
				TrustManager[] trustAllCerts = new TrustManager[]
					{ new X509TrustManager()
						{
							public java.security.cert.X509Certificate[] getAcceptedIssuers()
								{
									return null;
								}
							
							public void checkClientTrusted(X509Certificate[] certs, String authType)
								{
								}
							
							public void checkServerTrusted(X509Certificate[] certs, String authType)
								{
								}
							
						} };
				
				SSLContext sc;
				try
					{
						sc = SSLContext.getInstance("SSL");
						sc.init(null, trustAllCerts, new java.security.SecureRandom());
						HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
					}
				catch (NoSuchAlgorithmException | KeyManagementException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				// Create all-trusting host name verifier
				HostnameVerifier allHostsValid = new HostnameVerifier()
					{
						public boolean verify(String hostname, SSLSession session)
							{
								return true;
							}
					};
				// Install the all-trusting host verifier
				HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
				/*
				 * end of the fix
				 */
			}
	}
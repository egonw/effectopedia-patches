package org.qsari.effectopedia.notification;

import org.qsari.effectopedia.base.io.BaseIO;
import org.qsari.effectopedia.data.DataSource;

public interface NotificationManager
	{
		public void buildAndSubmitNotifications(DataSource data, BaseIO io);
		
		public void buildAndSubmitNotifications(DataSource data, BaseIO io, int sinceRevision);
	}
